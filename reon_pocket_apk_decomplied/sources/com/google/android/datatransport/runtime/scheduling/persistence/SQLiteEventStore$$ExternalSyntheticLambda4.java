package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda4 implements SQLiteEventStore.Function {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda4(Map map) {
        this.f$0 = map;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadMetadata$14(this.f$0, (Cursor) obj);
    }
}
