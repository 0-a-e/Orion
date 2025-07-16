package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda2 implements SQLiteEventStore.Function {
    public final /* synthetic */ SQLiteEventStore f$0;
    public final /* synthetic */ TransportContext f$1;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda2(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f$0 = sQLiteEventStore;
        this.f$1 = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f$0.m6951lambda$hasPendingEventsFor$5$comgoogleandroiddatatransportruntimeschedulingpersistenceSQLiteEventStore(this.f$1, (SQLiteDatabase) obj);
    }
}
