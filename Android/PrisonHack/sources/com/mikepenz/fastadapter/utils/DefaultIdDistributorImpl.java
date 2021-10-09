package com.mikepenz.fastadapter.utils;

import com.mikepenz.fastadapter.IIdentifyable;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultIdDistributorImpl<Identifiable extends IIdentifyable> extends DefaultIdDistributor<Identifiable> {
    private final AtomicLong idDistributor = new AtomicLong(-2);

    public long nextId(Identifiable identifiable) {
        return this.idDistributor.decrementAndGet();
    }
}
