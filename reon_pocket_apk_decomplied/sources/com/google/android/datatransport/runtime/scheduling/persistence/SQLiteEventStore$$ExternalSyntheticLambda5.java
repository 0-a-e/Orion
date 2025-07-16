package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda5 implements SQLiteEventStore.Function {
    public final /* synthetic */ long f$0;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda5(long j) {
        this.f$0 = j;
    }

    public final Object apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f$0)}));
    }
}
