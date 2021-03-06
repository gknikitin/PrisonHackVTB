package com.bumptech.glide.request;

public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private final RequestCoordinator coordinator;
    private Request error;
    private Request primary;

    public ErrorRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.coordinator = requestCoordinator;
    }

    public void setRequests(Request request, Request request2) {
        this.primary = request;
        this.error = request2;
    }

    public void begin() {
        if (!this.primary.isRunning()) {
            this.primary.begin();
        }
    }

    public void pause() {
        if (!this.primary.isFailed()) {
            this.primary.pause();
        }
        if (this.error.isRunning()) {
            this.error.pause();
        }
    }

    public void clear() {
        if (this.primary.isFailed()) {
            this.error.clear();
        } else {
            this.primary.clear();
        }
    }

    public boolean isPaused() {
        return (this.primary.isFailed() ? this.error : this.primary).isPaused();
    }

    public boolean isRunning() {
        return (this.primary.isFailed() ? this.error : this.primary).isRunning();
    }

    public boolean isComplete() {
        return (this.primary.isFailed() ? this.error : this.primary).isComplete();
    }

    public boolean isResourceSet() {
        return (this.primary.isFailed() ? this.error : this.primary).isResourceSet();
    }

    public boolean isCancelled() {
        return (this.primary.isFailed() ? this.error : this.primary).isCancelled();
    }

    public boolean isFailed() {
        return this.primary.isFailed() && this.error.isFailed();
    }

    public void recycle() {
        this.primary.recycle();
        this.error.recycle();
    }

    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.primary.isEquivalentTo(errorRequestCoordinator.primary) || !this.error.isEquivalentTo(errorRequestCoordinator.error)) {
            return false;
        }
        return true;
    }

    public boolean canSetImage(Request request) {
        return parentCanSetImage() && isValidRequest(request);
    }

    private boolean parentCanSetImage() {
        return this.coordinator == null || this.coordinator.canSetImage(this);
    }

    public boolean canNotifyStatusChanged(Request request) {
        return parentCanNotifyStatusChanged() && isValidRequest(request);
    }

    private boolean parentCanNotifyStatusChanged() {
        return this.coordinator == null || this.coordinator.canNotifyStatusChanged(this);
    }

    private boolean isValidRequest(Request request) {
        return request.equals(this.primary) || (this.primary.isFailed() && request.equals(this.error));
    }

    public boolean isAnyResourceSet() {
        return parentIsAnyResourceSet() || isResourceSet();
    }

    private boolean parentIsAnyResourceSet() {
        return this.coordinator != null && this.coordinator.isAnyResourceSet();
    }

    public void onRequestSuccess(Request request) {
        if (this.coordinator != null) {
            this.coordinator.onRequestSuccess(this);
        }
    }

    public void onRequestFailed(Request request) {
        if (!request.equals(this.error)) {
            if (!this.error.isRunning()) {
                this.error.begin();
            }
        } else if (this.coordinator != null) {
            this.coordinator.onRequestFailed(this.error);
        }
    }
}
