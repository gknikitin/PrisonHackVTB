package com.mikepenz.fastadapter.utils;

import com.mikepenz.fastadapter.IIdDistributor;
import com.mikepenz.fastadapter.IIdentifyable;
import java.util.List;

public abstract class DefaultIdDistributor<Identifiable extends IIdentifyable> implements IIdDistributor<Identifiable> {
    public List<Identifiable> checkIds(List<Identifiable> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            checkId((IIdentifyable) list.get(i));
        }
        return list;
    }

    public Identifiable[] checkIds(Identifiable... identifiableArr) {
        for (Identifiable checkId : identifiableArr) {
            checkId(checkId);
        }
        return identifiableArr;
    }

    public Identifiable checkId(Identifiable identifiable) {
        if (identifiable.getIdentifier() == -1) {
            identifiable.withIdentifier(nextId(identifiable));
        }
        return identifiable;
    }
}
