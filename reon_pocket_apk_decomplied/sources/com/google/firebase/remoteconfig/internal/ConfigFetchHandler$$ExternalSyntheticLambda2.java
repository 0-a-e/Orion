package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConfigFetchHandler$$ExternalSyntheticLambda2 implements Continuation {
    public final /* synthetic */ ConfigFetchHandler f$0;
    public final /* synthetic */ Task f$1;
    public final /* synthetic */ Task f$2;
    public final /* synthetic */ Date f$3;

    public /* synthetic */ ConfigFetchHandler$$ExternalSyntheticLambda2(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        this.f$0 = configFetchHandler;
        this.f$1 = task;
        this.f$2 = task2;
        this.f$3 = date;
    }

    public final Object then(Task task) {
        return this.f$0.m6976lambda$fetchIfCacheExpiredAndNotThrottled$1$comgooglefirebaseremoteconfiginternalConfigFetchHandler(this.f$1, this.f$2, this.f$3, task);
    }
}
