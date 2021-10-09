package com.bumptech.glide.load.engine;

import android.os.Build;
import android.support.p000v4.p002os.TraceCompat;
import android.support.p000v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    private static final String TAG = "DecodeJob";
    private Callback<R> callback;
    private Key currentAttemptingKey;
    private Object currentData;
    private DataSource currentDataSource;
    private DataFetcher<?> currentFetcher;
    private volatile DataFetcherGenerator currentGenerator;
    Key currentSourceKey;
    private Thread currentThread;
    final DecodeHelper<R> decodeHelper = new DecodeHelper<>();
    final DeferredEncodeManager<?> deferredEncodeManager = new DeferredEncodeManager<>();
    private final DiskCacheProvider diskCacheProvider;
    DiskCacheStrategy diskCacheStrategy;
    /* access modifiers changed from: private */
    public GlideContext glideContext;
    int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private EngineKey loadKey;
    private boolean onlyRetrieveFromCache;
    Options options;
    private int order;
    private final Pools.Pool<DecodeJob<?>> pool;
    private Priority priority;
    private final ReleaseManager releaseManager = new ReleaseManager();
    private RunReason runReason;
    Key signature;
    private Stage stage;
    private long startFetchTime;
    private final StateVerifier stateVerifier = StateVerifier.newInstance();
    private final List<Throwable> throwables = new ArrayList();
    int width;

    interface Callback<R> {
        void onLoadFailed(GlideException glideException);

        void onResourceReady(Resource<R> resource, DataSource dataSource);

        void reschedule(DecodeJob<?> decodeJob);
    }

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    DecodeJob(DiskCacheProvider diskCacheProvider2, Pools.Pool<DecodeJob<?>> pool2) {
        this.diskCacheProvider = diskCacheProvider2;
        this.pool = pool2;
    }

    /* access modifiers changed from: package-private */
    public DecodeJob<R> init(GlideContext glideContext2, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority2, DiskCacheStrategy diskCacheStrategy2, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options2, Callback<R> callback2, int i3) {
        this.decodeHelper.init(glideContext2, obj, key, i, i2, diskCacheStrategy2, cls, cls2, priority2, options2, map, z, z2, this.diskCacheProvider);
        this.glideContext = glideContext2;
        this.signature = key;
        this.priority = priority2;
        this.loadKey = engineKey;
        this.width = i;
        this.height = i2;
        this.diskCacheStrategy = diskCacheStrategy2;
        this.onlyRetrieveFromCache = z3;
        this.options = options2;
        this.callback = callback2;
        this.order = i3;
        this.runReason = RunReason.INITIALIZE;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean willDecodeFromCache() {
        Stage nextStage = getNextStage(Stage.INITIALIZE);
        return nextStage == Stage.RESOURCE_CACHE || nextStage == Stage.DATA_CACHE;
    }

    /* access modifiers changed from: package-private */
    public void release(boolean z) {
        if (this.releaseManager.release(z)) {
            releaseInternal();
        }
    }

    private void onEncodeComplete() {
        if (this.releaseManager.onEncodeComplete()) {
            releaseInternal();
        }
    }

    private void onLoadFailed() {
        if (this.releaseManager.onFailed()) {
            releaseInternal();
        }
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0;
        this.isCancelled = false;
        this.throwables.clear();
        this.pool.release(this);
    }

    public int compareTo(DecodeJob<?> decodeJob) {
        int priority2 = getPriority() - decodeJob.getPriority();
        return priority2 == 0 ? this.order - decodeJob.order : priority2;
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    public void cancel() {
        this.isCancelled = true;
        DataFetcherGenerator dataFetcherGenerator = this.currentGenerator;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r0 != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r0.cleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        android.support.p000v4.p002os.TraceCompat.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        if (r0 != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            java.lang.String r0 = "DecodeJob#run"
            android.support.p000v4.p002os.TraceCompat.beginSection(r0)
            com.bumptech.glide.load.data.DataFetcher<?> r0 = r5.currentFetcher
            boolean r1 = r5.isCancelled     // Catch:{ Throwable -> 0x0025 }
            if (r1 == 0) goto L_0x0017
            r5.notifyFailed()     // Catch:{ Throwable -> 0x0025 }
            if (r0 == 0) goto L_0x0013
            r0.cleanup()
        L_0x0013:
            android.support.p000v4.p002os.TraceCompat.endSection()
            return
        L_0x0017:
            r5.runWrapped()     // Catch:{ Throwable -> 0x0025 }
            if (r0 == 0) goto L_0x001f
        L_0x001c:
            r0.cleanup()
        L_0x001f:
            android.support.p000v4.p002os.TraceCompat.endSection()
            goto L_0x0067
        L_0x0023:
            r1 = move-exception
            goto L_0x0068
        L_0x0025:
            r1 = move-exception
            java.lang.String r2 = "DecodeJob"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = "DecodeJob"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            r3.<init>()     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = "DecodeJob threw unexpectedly, isCancelled: "
            r3.append(r4)     // Catch:{ all -> 0x0023 }
            boolean r4 = r5.isCancelled     // Catch:{ all -> 0x0023 }
            r3.append(r4)     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = ", stage: "
            r3.append(r4)     // Catch:{ all -> 0x0023 }
            com.bumptech.glide.load.engine.DecodeJob$Stage r4 = r5.stage     // Catch:{ all -> 0x0023 }
            r3.append(r4)     // Catch:{ all -> 0x0023 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0023 }
            android.util.Log.d(r2, r3, r1)     // Catch:{ all -> 0x0023 }
        L_0x0051:
            com.bumptech.glide.load.engine.DecodeJob$Stage r2 = r5.stage     // Catch:{ all -> 0x0023 }
            com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.ENCODE     // Catch:{ all -> 0x0023 }
            if (r2 == r3) goto L_0x005f
            java.util.List<java.lang.Throwable> r2 = r5.throwables     // Catch:{ all -> 0x0023 }
            r2.add(r1)     // Catch:{ all -> 0x0023 }
            r5.notifyFailed()     // Catch:{ all -> 0x0023 }
        L_0x005f:
            boolean r2 = r5.isCancelled     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0064
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0064:
            if (r0 == 0) goto L_0x001f
            goto L_0x001c
        L_0x0067:
            return
        L_0x0068:
            if (r0 == 0) goto L_0x006d
            r0.cleanup()
        L_0x006d:
            android.support.p000v4.p002os.TraceCompat.endSection()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.run():void");
    }

    private void runWrapped() {
        switch (this.runReason) {
            case INITIALIZE:
                this.stage = getNextStage(Stage.INITIALIZE);
                this.currentGenerator = getNextGenerator();
                runGenerators();
                return;
            case SWITCH_TO_SOURCE_SERVICE:
                runGenerators();
                return;
            case DECODE_DATA:
                decodeFromRetrievedData();
                return;
            default:
                throw new IllegalStateException("Unrecognized run reason: " + this.runReason);
        }
    }

    private DataFetcherGenerator getNextGenerator() {
        switch (this.stage) {
            case RESOURCE_CACHE:
                return new ResourceCacheGenerator(this.decodeHelper, this);
            case DATA_CACHE:
                return new DataCacheGenerator(this.decodeHelper, this);
            case SOURCE:
                return new SourceGenerator(this.decodeHelper, this);
            case FINISHED:
                return null;
            default:
                throw new IllegalStateException("Unrecognized stage: " + this.stage);
        }
    }

    private void runGenerators() {
        this.currentThread = Thread.currentThread();
        this.startFetchTime = LogTime.getLogTime();
        boolean z = false;
        while (!this.isCancelled && this.currentGenerator != null && !(z = this.currentGenerator.startNext())) {
            this.stage = getNextStage(this.stage);
            this.currentGenerator = getNextGenerator();
            if (this.stage == Stage.SOURCE) {
                reschedule();
                return;
            }
        }
        if ((this.stage == Stage.FINISHED || this.isCancelled) && !z) {
            notifyFailed();
        }
    }

    private void notifyFailed() {
        setNotifiedOrThrow();
        this.callback.onLoadFailed(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.throwables)));
        onLoadFailed();
    }

    private void notifyComplete(Resource<R> resource, DataSource dataSource) {
        setNotifiedOrThrow();
        this.callback.onResourceReady(resource, dataSource);
    }

    private void setNotifiedOrThrow() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCallbackNotified) {
            throw new IllegalStateException("Already notified");
        }
        this.isCallbackNotified = true;
    }

    private Stage getNextStage(Stage stage2) {
        switch (stage2) {
            case RESOURCE_CACHE:
                if (this.diskCacheStrategy.decodeCachedData()) {
                    return Stage.DATA_CACHE;
                }
                return getNextStage(Stage.DATA_CACHE);
            case DATA_CACHE:
                return this.onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
            case SOURCE:
            case FINISHED:
                return Stage.FINISHED;
            case INITIALIZE:
                if (this.diskCacheStrategy.decodeCachedResource()) {
                    return Stage.RESOURCE_CACHE;
                }
                return getNextStage(Stage.RESOURCE_CACHE);
            default:
                throw new IllegalArgumentException("Unrecognized stage: " + stage2);
        }
    }

    public void reschedule() {
        this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.callback.reschedule(this);
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.currentSourceKey = key;
        this.currentData = obj;
        this.currentFetcher = dataFetcher;
        this.currentDataSource = dataSource;
        this.currentAttemptingKey = key2;
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.DECODE_DATA;
            this.callback.reschedule(this);
            return;
        }
        TraceCompat.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            decodeFromRetrievedData();
        } finally {
            TraceCompat.endSection();
        }
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.getDataClass());
        this.throwables.add(glideException);
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.callback.reschedule(this);
            return;
        }
        runGenerators();
    }

    private void decodeFromRetrievedData() {
        if (Log.isLoggable(TAG, 2)) {
            long j = this.startFetchTime;
            logWithTimeAndKey("Retrieved data", j, "data: " + this.currentData + ", cache key: " + this.currentSourceKey + ", fetcher: " + this.currentFetcher);
        }
        Resource<R> resource = null;
        try {
            resource = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
        } catch (GlideException e) {
            e.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
            this.throwables.add(e);
        }
        if (resource != null) {
            notifyEncodeAndRelease(resource, this.currentDataSource);
        } else {
            runGenerators();
        }
    }

    private void notifyEncodeAndRelease(Resource<R> resource, DataSource dataSource) {
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
        LockedResource<R> lockedResource = null;
        LockedResource<R> lockedResource2 = resource;
        if (this.deferredEncodeManager.hasResourceToEncode()) {
            LockedResource<R> obtain = LockedResource.obtain(resource);
            lockedResource = obtain;
            lockedResource2 = obtain;
        }
        notifyComplete(lockedResource2, dataSource);
        this.stage = Stage.ENCODE;
        try {
            if (this.deferredEncodeManager.hasResourceToEncode()) {
                this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);
            }
        } finally {
            if (lockedResource != null) {
                lockedResource.unlock();
            }
            onEncodeComplete();
        }
    }

    private <Data> Resource<R> decodeFromData(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long logTime = LogTime.getLogTime();
            Resource<R> decodeFromFetcher = decodeFromFetcher(data, dataSource);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Decoded result " + decodeFromFetcher, logTime);
            }
            return decodeFromFetcher;
        } finally {
            dataFetcher.cleanup();
        }
    }

    private <Data> Resource<R> decodeFromFetcher(Data data, DataSource dataSource) throws GlideException {
        return runLoadPath(data, dataSource, this.decodeHelper.getLoadPath(data.getClass()));
    }

    private Options getOptionsWithHardwareConfig(DataSource dataSource) {
        Options options2 = this.options;
        if (Build.VERSION.SDK_INT < 26 || options2.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null) {
            return options2;
        }
        if (dataSource != DataSource.RESOURCE_DISK_CACHE && !this.decodeHelper.isScaleOnlyOrNoTransform()) {
            return options2;
        }
        Options options3 = new Options();
        options3.putAll(this.options);
        options3.set(Downsampler.ALLOW_HARDWARE_CONFIG, true);
        return options3;
    }

    private <Data, ResourceType> Resource<R> runLoadPath(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options optionsWithHardwareConfig = getOptionsWithHardwareConfig(dataSource);
        DataRewinder rewinder = this.glideContext.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, optionsWithHardwareConfig, this.width, this.height, new DecodeCallback(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    private void logWithTimeAndKey(String str, long j) {
        logWithTimeAndKey(str, j, (String) null);
    }

    private void logWithTimeAndKey(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(j));
        sb.append(", load key: ");
        sb.append(this.loadKey);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v(TAG, sb.toString());
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    private final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
        private final DataSource dataSource;

        DecodeCallback(DataSource dataSource2) {
            this.dataSource = dataSource2;
        }

        /* JADX WARNING: type inference failed for: r11v9, types: [com.bumptech.glide.load.engine.DataCacheKey] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.bumptech.glide.load.engine.Resource<Z> onResourceDecoded(com.bumptech.glide.load.engine.Resource<Z> r11) {
            /*
                r10 = this;
                java.lang.Class r6 = r10.getResourceClass(r11)
                com.bumptech.glide.load.DataSource r0 = r10.dataSource
                com.bumptech.glide.load.DataSource r1 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
                r2 = 0
                if (r0 == r1) goto L_0x0028
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r0.decodeHelper
                com.bumptech.glide.load.Transformation r0 = r0.getTransformation(r6)
                com.bumptech.glide.load.engine.DecodeJob r1 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.GlideContext r1 = r1.glideContext
                com.bumptech.glide.load.engine.DecodeJob r3 = com.bumptech.glide.load.engine.DecodeJob.this
                int r3 = r3.width
                com.bumptech.glide.load.engine.DecodeJob r4 = com.bumptech.glide.load.engine.DecodeJob.this
                int r4 = r4.height
                com.bumptech.glide.load.engine.Resource r1 = r0.transform(r1, r11, r3, r4)
                r5 = r0
                r8 = r1
                goto L_0x002a
            L_0x0028:
                r8 = r11
                r5 = r2
            L_0x002a:
                boolean r0 = r11.equals(r8)
                if (r0 != 0) goto L_0x0033
                r11.recycle()
            L_0x0033:
                com.bumptech.glide.load.engine.DecodeJob r11 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r11 = r11.decodeHelper
                boolean r11 = r11.isResourceEncoderAvailable(r8)
                if (r11 == 0) goto L_0x004f
                com.bumptech.glide.load.engine.DecodeJob r11 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r11 = r11.decodeHelper
                com.bumptech.glide.load.ResourceEncoder r2 = r11.getResultEncoder(r8)
                com.bumptech.glide.load.engine.DecodeJob r11 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Options r11 = r11.options
                com.bumptech.glide.load.EncodeStrategy r11 = r2.getEncodeStrategy(r11)
            L_0x004d:
                r9 = r2
                goto L_0x0052
            L_0x004f:
                com.bumptech.glide.load.EncodeStrategy r11 = com.bumptech.glide.load.EncodeStrategy.NONE
                goto L_0x004d
            L_0x0052:
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r0.decodeHelper
                com.bumptech.glide.load.engine.DecodeJob r1 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r1 = r1.currentSourceKey
                boolean r0 = r0.isSourceKey(r1)
                r0 = r0 ^ 1
                com.bumptech.glide.load.engine.DecodeJob r1 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DiskCacheStrategy r1 = r1.diskCacheStrategy
                com.bumptech.glide.load.DataSource r2 = r10.dataSource
                boolean r0 = r1.isResourceCacheable(r0, r2, r11)
                if (r0 == 0) goto L_0x00cf
                if (r9 != 0) goto L_0x007c
                com.bumptech.glide.Registry$NoResultEncoderAvailableException r11 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
                java.lang.Object r0 = r8.get()
                java.lang.Class r0 = r0.getClass()
                r11.<init>(r0)
                throw r11
            L_0x007c:
                com.bumptech.glide.load.EncodeStrategy r0 = com.bumptech.glide.load.EncodeStrategy.SOURCE
                if (r11 != r0) goto L_0x008e
                com.bumptech.glide.load.engine.DataCacheKey r11 = new com.bumptech.glide.load.engine.DataCacheKey
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r0 = r0.currentSourceKey
                com.bumptech.glide.load.engine.DecodeJob r1 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r1 = r1.signature
                r11.<init>(r0, r1)
                goto L_0x00ac
            L_0x008e:
                com.bumptech.glide.load.EncodeStrategy r0 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED
                if (r11 != r0) goto L_0x00b8
                com.bumptech.glide.load.engine.ResourceCacheKey r11 = new com.bumptech.glide.load.engine.ResourceCacheKey
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r1 = r0.currentSourceKey
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r2 = r0.signature
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                int r3 = r0.width
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                int r4 = r0.height
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Options r7 = r0.options
                r0 = r11
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            L_0x00ac:
                com.bumptech.glide.load.engine.LockedResource r8 = com.bumptech.glide.load.engine.LockedResource.obtain(r8)
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r0 = r0.deferredEncodeManager
                r0.init(r11, r9, r8)
                goto L_0x00cf
            L_0x00b8:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unknown strategy: "
                r1.append(r2)
                r1.append(r11)
                java.lang.String r11 = r1.toString()
                r0.<init>(r11)
                throw r0
            L_0x00cf:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.DecodeCallback.onResourceDecoded(com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource");
        }

        private Class<Z> getResourceClass(Resource<Z> resource) {
            return resource.get().getClass();
        }
    }

    private static class ReleaseManager {
        private boolean isEncodeComplete;
        private boolean isFailed;
        private boolean isReleased;

        ReleaseManager() {
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean release(boolean z) {
            this.isReleased = true;
            return isComplete(z);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean onEncodeComplete() {
            this.isEncodeComplete = true;
            return isComplete(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean onFailed() {
            this.isFailed = true;
            return isComplete(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized void reset() {
            this.isEncodeComplete = false;
            this.isReleased = false;
            this.isFailed = false;
        }

        private boolean isComplete(boolean z) {
            return (this.isFailed || z || this.isEncodeComplete) && this.isReleased;
        }
    }

    private static class DeferredEncodeManager<Z> {
        private ResourceEncoder<Z> encoder;
        private Key key;
        private LockedResource<Z> toEncode;

        DeferredEncodeManager() {
        }

        /* access modifiers changed from: package-private */
        public <X> void init(Key key2, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.key = key2;
            this.encoder = resourceEncoder;
            this.toEncode = lockedResource;
        }

        /* access modifiers changed from: package-private */
        public void encode(DiskCacheProvider diskCacheProvider, Options options) {
            TraceCompat.beginSection("DecodeJob.encode");
            try {
                diskCacheProvider.getDiskCache().put(this.key, new DataCacheWriter(this.encoder, this.toEncode, options));
            } finally {
                this.toEncode.unlock();
                TraceCompat.endSection();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean hasResourceToEncode() {
            return this.toEncode != null;
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.key = null;
            this.encoder = null;
            this.toEncode = null;
        }
    }
}
