package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda0 implements SQLiteEventStore.Function {
    public final /* synthetic */ String f$0;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordFailure$3(this.f$0, (SQLiteDatabase) obj);
    }
}
