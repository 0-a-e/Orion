package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda14 implements SQLiteEventStore.Producer {
    public final /* synthetic */ SchemaManager f$0;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda14(SchemaManager schemaManager) {
        this.f$0 = schemaManager;
    }

    public final Object produce() {
        return this.f$0.getWritableDatabase();
    }
}
