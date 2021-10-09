package com.bumptech.glide.request;

import android.support.annotation.Nullable;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    @Nullable
    private RequestCoordinator coordinator;
    private Request full;
    private boolean isRunning;
    private Request thumb;

    public ThumbnailRequestCoordinator() {
        this((RequestCoordinator) null);
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.coordinator = requestCoordinator;
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }

    public boolean canSetImage(Request request) {
        return parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet());
    }

    private boolean parentCanSetImage() {
        return this.coordinator == null || this.coordinator.canSetImage(this);
    }

    public boolean canNotifyStatusChanged(Request request) {
        return parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet();
    }

    private boolean parentCanNotifyStatusChanged() {
        return this.coordinator == null || this.coordinator.canNotifyStatusChanged(this);
    }

    public boolean isAnyResourceSet() {
        return parentIsAnyResourceSet() || isResourceSet();
    }

    public void onRequestSuccess(Request request) {
        if (!request.equals(this.thumb)) {
            if (this.coordinator != null) {
                this.coordinator.onRequestSuccess(this);
            }
            if (!this.thumb.isComplete()) {
                this.thumb.clear();
            }
        }
    }

    public void onRequestFailed(Request request) {
        if (request.equals(this.full) && this.coordinator != null) {
            this.coordinator.onRequestFailed(this);
        }
    }

    private boolean parentIsAnyResourceSet() {
        return this.coordinator != null && this.coordinator.isAnyResourceSet();
    }

    public void begin() {
        this.isRunning = true;
        if (!this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (this.isRunning && !this.full.isRunning()) {
            this.full.begin();
        }
    }

    public void pause() {
        this.isRunning = false;
        this.full.pause();
        this.thumb.pause();
    }

    public void clear() {
        this.isRunning = false;
        this.thumb.clear();
        this.full.clear();
    }

    public boolean isPaused() {
        return this.full.isPaused();
    }

    public boolean isRunning() {
        return this.full.isRunning();
    }

    public boolean isComplete() {
        return this.full.isComplete() || this.thumb.isComplete();
    }

    public boolean isResourceSet() {
        return this.full.isResourceSet() || this.thumb.isResourceSet();
    }

    public boolean isCancelled() {
        return this.full.isCancelled();
    }

    public boolean isFailed() {
        return this.full.isFailed();
    }

    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEquivalentTo(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator
            r1 = 0
            if (r0 == 0) goto L_0x002f
            com.bumptech.glide.request.ThumbnailRequestCoordinator r4 = (com.bumptech.glide.request.ThumbnailRequestCoordinator) r4
            com.bumptech.glide.request.Request r0 = r3.full
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.Request r0 = r4.full
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.request.Request r0 = r3.full
            com.bumptech.glide.request.Request r2 = r4.full
            boolean r0 = r0.isEquivalentTo(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.request.Request r0 = r3.thumb
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.request.Request r4 = r4.thumb
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.request.Request r0 = r3.thumb
            com.bumptech.glide.request.Request r4 = r4.thumb
            boolean r4 = r0.isEquivalentTo(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }
}
