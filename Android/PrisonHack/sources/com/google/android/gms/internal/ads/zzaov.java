package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzbv;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzadh
@TargetApi(14)
public final class zzaov extends zzapg implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzcwo = new HashMap();
    private final zzapx zzcwp;
    private final boolean zzcwq;
    private int zzcwr = 0;
    private int zzcws = 0;
    private MediaPlayer zzcwt;
    private Uri zzcwu;
    private int zzcwv;
    private int zzcww;
    private int zzcwx;
    private int zzcwy;
    private int zzcwz;
    private zzapu zzcxa;
    private boolean zzcxb;
    private int zzcxc;
    /* access modifiers changed from: private */
    public zzapf zzcxd;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzcwo.put(-1004, "MEDIA_ERROR_IO");
            zzcwo.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzcwo.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzcwo.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzcwo.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzcwo.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzcwo.put(1, "MEDIA_ERROR_UNKNOWN");
        zzcwo.put(1, "MEDIA_INFO_UNKNOWN");
        zzcwo.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzcwo.put(701, "MEDIA_INFO_BUFFERING_START");
        zzcwo.put(702, "MEDIA_INFO_BUFFERING_END");
        zzcwo.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzcwo.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzcwo.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzcwo.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzcwo.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzaov(Context context, boolean z, boolean z2, zzapv zzapv, zzapx zzapx) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzcwp = zzapx;
        this.zzcxb = z;
        this.zzcwq = z2;
        this.zzcwp.zzb(this);
    }

    private final void zza(float f) {
        if (this.zzcwt != null) {
            try {
                this.zzcwt.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzakb.zzdk("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzag(int i) {
        if (i == 3) {
            this.zzcwp.zztt();
            this.zzcxl.zztt();
        } else if (this.zzcwr == 3) {
            this.zzcwp.zztu();
            this.zzcxl.zztu();
        }
        this.zzcwr = i;
    }

    private final void zzag(boolean z) {
        zzakb.m39v("AdMediaPlayerView release");
        if (this.zzcxa != null) {
            this.zzcxa.zzti();
            this.zzcxa = null;
        }
        if (this.zzcwt != null) {
            this.zzcwt.reset();
            this.zzcwt.release();
            this.zzcwt = null;
            zzag(0);
            if (z) {
                this.zzcws = 0;
                this.zzcws = 0;
            }
        }
    }

    private final void zzsq() {
        zzakb.m39v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzcwu != null && surfaceTexture != null) {
            zzag(false);
            try {
                zzbv.zzfb();
                this.zzcwt = new MediaPlayer();
                this.zzcwt.setOnBufferingUpdateListener(this);
                this.zzcwt.setOnCompletionListener(this);
                this.zzcwt.setOnErrorListener(this);
                this.zzcwt.setOnInfoListener(this);
                this.zzcwt.setOnPreparedListener(this);
                this.zzcwt.setOnVideoSizeChangedListener(this);
                this.zzcwx = 0;
                if (this.zzcxb) {
                    this.zzcxa = new zzapu(getContext());
                    this.zzcxa.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzcxa.start();
                    SurfaceTexture zztj = this.zzcxa.zztj();
                    if (zztj != null) {
                        surfaceTexture = zztj;
                    } else {
                        this.zzcxa.zzti();
                        this.zzcxa = null;
                    }
                }
                this.zzcwt.setDataSource(getContext(), this.zzcwu);
                zzbv.zzfc();
                this.zzcwt.setSurface(new Surface(surfaceTexture));
                this.zzcwt.setAudioStreamType(3);
                this.zzcwt.setScreenOnWhilePlaying(true);
                this.zzcwt.prepareAsync();
                zzag(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzcwu);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzakb.zzc(sb.toString(), e);
                onError(this.zzcwt, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:10:0x0034->B:15:0x0050, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzsr() {
        /*
            r8 = this;
            boolean r0 = r8.zzcwq
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.zzss()
            if (r0 == 0) goto L_0x005a
            android.media.MediaPlayer r0 = r8.zzcwt
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x005a
            int r0 = r8.zzcws
            r1 = 3
            if (r0 == r1) goto L_0x005a
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.ads.zzakb.m39v(r0)
            r0 = 0
            r8.zza((float) r0)
            android.media.MediaPlayer r0 = r8.zzcwt
            r0.start()
            android.media.MediaPlayer r0 = r8.zzcwt
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzbv.zzer()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r8.zzss()
            if (r3 == 0) goto L_0x0052
            android.media.MediaPlayer r3 = r8.zzcwt
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0052
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzbv.zzer()
            long r3 = r3.currentTimeMillis()
            long r5 = r3 - r1
            r3 = 250(0xfa, double:1.235E-321)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
        L_0x0052:
            android.media.MediaPlayer r0 = r8.zzcwt
            r0.pause()
            r8.zzst()
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaov.zzsr():void");
    }

    private final boolean zzss() {
        return (this.zzcwt == null || this.zzcwr == -1 || this.zzcwr == 0 || this.zzcwr == 1) ? false : true;
    }

    public final int getCurrentPosition() {
        if (zzss()) {
            return this.zzcwt.getCurrentPosition();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzss()) {
            return this.zzcwt.getDuration();
        }
        return -1;
    }

    public final int getVideoHeight() {
        if (this.zzcwt != null) {
            return this.zzcwt.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        if (this.zzcwt != null) {
            return this.zzcwt.getVideoWidth();
        }
        return 0;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzcwx = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzakb.m39v("AdMediaPlayerView completion");
        zzag(5);
        this.zzcws = 5;
        zzakk.zzcrm.post(new zzaoy(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzcwo.get(Integer.valueOf(i));
        String str2 = zzcwo.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzakb.zzdk(sb.toString());
        zzag(-1);
        this.zzcws = -1;
        zzakk.zzcrm.post(new zzaoz(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzcwo.get(Integer.valueOf(i));
        String str2 = zzcwo.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzakb.m39v(sb.toString());
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        if ((r5.zzcwv * r7) > (r5.zzcww * r6)) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        if (r1 > r6) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008b, code lost:
        if (r1 > r6) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzcwv
            int r0 = getDefaultSize(r0, r6)
            int r1 = r5.zzcww
            int r1 = getDefaultSize(r1, r7)
            int r2 = r5.zzcwv
            if (r2 <= 0) goto L_0x008e
            int r2 = r5.zzcww
            if (r2 <= 0) goto L_0x008e
            com.google.android.gms.internal.ads.zzapu r2 = r5.zzcxa
            if (r2 != 0) goto L_0x008e
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0055
            if (r1 != r2) goto L_0x0055
            int r0 = r5.zzcwv
            int r0 = r0 * r7
            int r1 = r5.zzcww
            int r1 = r1 * r6
            if (r0 >= r1) goto L_0x0042
            int r6 = r5.zzcwv
            int r6 = r6 * r7
            int r0 = r5.zzcww
            int r0 = r6 / r0
            r6 = r0
            goto L_0x0090
        L_0x0042:
            int r0 = r5.zzcwv
            int r0 = r0 * r7
            int r1 = r5.zzcww
            int r1 = r1 * r6
            if (r0 <= r1) goto L_0x0090
        L_0x004c:
            int r7 = r5.zzcww
            int r7 = r7 * r6
            int r0 = r5.zzcwv
            int r1 = r7 / r0
            goto L_0x008f
        L_0x0055:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x0067
            int r0 = r5.zzcww
            int r0 = r0 * r6
            int r2 = r5.zzcwv
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0065
            if (r0 <= r7) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            r7 = r0
            goto L_0x0090
        L_0x0067:
            if (r1 != r2) goto L_0x0077
            int r1 = r5.zzcwv
            int r1 = r1 * r7
            int r2 = r5.zzcww
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0075
            if (r1 <= r6) goto L_0x0075
            goto L_0x0090
        L_0x0075:
            r6 = r1
            goto L_0x0090
        L_0x0077:
            int r2 = r5.zzcwv
            int r4 = r5.zzcww
            if (r1 != r3) goto L_0x0087
            if (r4 <= r7) goto L_0x0087
            int r1 = r5.zzcwv
            int r1 = r1 * r7
            int r2 = r5.zzcww
            int r1 = r1 / r2
            goto L_0x0089
        L_0x0087:
            r1 = r2
            r7 = r4
        L_0x0089:
            if (r0 != r3) goto L_0x0075
            if (r1 <= r6) goto L_0x0075
            goto L_0x004c
        L_0x008e:
            r6 = r0
        L_0x008f:
            r7 = r1
        L_0x0090:
            r5.setMeasuredDimension(r6, r7)
            com.google.android.gms.internal.ads.zzapu r0 = r5.zzcxa
            if (r0 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzapu r0 = r5.zzcxa
            r0.zzh(r6, r7)
        L_0x009c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 != r1) goto L_0x00b9
            int r0 = r5.zzcwy
            if (r0 <= 0) goto L_0x00aa
            int r0 = r5.zzcwy
            if (r0 != r6) goto L_0x00b2
        L_0x00aa:
            int r0 = r5.zzcwz
            if (r0 <= 0) goto L_0x00b5
            int r0 = r5.zzcwz
            if (r0 == r7) goto L_0x00b5
        L_0x00b2:
            r5.zzsr()
        L_0x00b5:
            r5.zzcwy = r6
            r5.zzcwz = r7
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaov.onMeasure(int, int):void");
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzakb.m39v("AdMediaPlayerView prepared");
        zzag(2);
        this.zzcwp.zzsv();
        zzakk.zzcrm.post(new zzaox(this));
        this.zzcwv = mediaPlayer.getVideoWidth();
        this.zzcww = mediaPlayer.getVideoHeight();
        if (this.zzcxc != 0) {
            seekTo(this.zzcxc);
        }
        zzsr();
        int i = this.zzcwv;
        int i2 = this.zzcww;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzakb.zzdj(sb.toString());
        if (this.zzcws == 3) {
            play();
        }
        zzst();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzakb.m39v("AdMediaPlayerView surface created");
        zzsq();
        zzakk.zzcrm.post(new zzapa(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzakb.m39v("AdMediaPlayerView surface destroyed");
        if (this.zzcwt != null && this.zzcxc == 0) {
            this.zzcxc = this.zzcwt.getCurrentPosition();
        }
        if (this.zzcxa != null) {
            this.zzcxa.zzti();
        }
        zzakk.zzcrm.post(new zzapc(this));
        zzag(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzakb.m39v("AdMediaPlayerView surface changed");
        boolean z = false;
        boolean z2 = this.zzcws == 3;
        if (this.zzcwv == i && this.zzcww == i2) {
            z = true;
        }
        if (this.zzcwt != null && z2 && z) {
            if (this.zzcxc != 0) {
                seekTo(this.zzcxc);
            }
            play();
        }
        if (this.zzcxa != null) {
            this.zzcxa.zzh(i, i2);
        }
        zzakk.zzcrm.post(new zzapb(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzcwp.zzc(this);
        this.zzcxk.zza(surfaceTexture, this.zzcxd);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzakb.m39v(sb.toString());
        this.zzcwv = mediaPlayer.getVideoWidth();
        this.zzcww = mediaPlayer.getVideoHeight();
        if (this.zzcwv != 0 && this.zzcww != 0) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzakb.m39v(sb.toString());
        zzakk.zzcrm.post(new zzaow(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void pause() {
        zzakb.m39v("AdMediaPlayerView pause");
        if (zzss() && this.zzcwt.isPlaying()) {
            this.zzcwt.pause();
            zzag(4);
            zzakk.zzcrm.post(new zzape(this));
        }
        this.zzcws = 4;
    }

    public final void play() {
        zzakb.m39v("AdMediaPlayerView play");
        if (zzss()) {
            this.zzcwt.start();
            zzag(3);
            this.zzcxk.zzsw();
            zzakk.zzcrm.post(new zzapd(this));
        }
        this.zzcws = 3;
    }

    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzakb.m39v(sb.toString());
        if (zzss()) {
            this.zzcwt.seekTo(i);
            this.zzcxc = 0;
            return;
        }
        this.zzcxc = i;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzhl zzd = zzhl.zzd(parse);
        if (zzd != null) {
            parse = Uri.parse(zzd.url);
        }
        this.zzcwu = parse;
        this.zzcxc = 0;
        zzsq();
        requestLayout();
        invalidate();
    }

    public final void stop() {
        zzakb.m39v("AdMediaPlayerView stop");
        if (this.zzcwt != null) {
            this.zzcwt.stop();
            this.zzcwt.release();
            this.zzcwt = null;
            zzag(0);
            this.zzcws = 0;
        }
        this.zzcwp.onStop();
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    public final void zza(float f, float f2) {
        if (this.zzcxa != null) {
            this.zzcxa.zzb(f, f2);
        }
    }

    public final void zza(zzapf zzapf) {
        this.zzcxd = zzapf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzah(int i) {
        if (this.zzcxd != null) {
            this.zzcxd.onWindowVisibilityChanged(i);
        }
    }

    public final String zzsp() {
        String valueOf = String.valueOf(this.zzcxb ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    public final void zzst() {
        zza(this.zzcxl.getVolume());
    }
}
