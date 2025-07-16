package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConfigFetchHandler$$ExternalSyntheticLambda0 implements Continuation {
    public final /* synthetic */ ConfigFetchHandler f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ ConfigFetchHandler$$ExternalSyntheticLambda0(ConfigFetchHandler configFetchHandler, long j) {
        this.f$0 = configFetchHandler;
        this.f$1 = j;
    }

    public final Object then(Task task) {
        return this.f$0.m6975lambda$fetch$0$comgooglefirebaseremoteconfiginternalConfigFetchHandler(this.f$1, task);
    }
}
