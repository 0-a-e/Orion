package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConfigFetchHandler$$ExternalSyntheticLambda3 implements Continuation {
    public final /* synthetic */ ConfigFetchHandler f$0;
    public final /* synthetic */ Date f$1;

    public /* synthetic */ ConfigFetchHandler$$ExternalSyntheticLambda3(ConfigFetchHandler configFetchHandler, Date date) {
        this.f$0 = configFetchHandler;
        this.f$1 = date;
    }

    public final Object then(Task task) {
        return this.f$0.m6977lambda$fetchIfCacheExpiredAndNotThrottled$2$comgooglefirebaseremoteconfiginternalConfigFetchHandler(this.f$1, task);
    }
}
