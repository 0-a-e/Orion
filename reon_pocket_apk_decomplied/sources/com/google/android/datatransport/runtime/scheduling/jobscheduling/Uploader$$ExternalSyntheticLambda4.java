package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Uploader$$ExternalSyntheticLambda4 implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ Uploader f$0;
    public final /* synthetic */ BackendResponse f$1;
    public final /* synthetic */ Iterable f$2;
    public final /* synthetic */ TransportContext f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ Uploader$$ExternalSyntheticLambda4(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        this.f$0 = uploader;
        this.f$1 = backendResponse;
        this.f$2 = iterable;
        this.f$3 = transportContext;
        this.f$4 = i;
    }

    public final Object execute() {
        return this.f$0.m6946lambda$logAndUpdateState$3$comgoogleandroiddatatransportruntimeschedulingjobschedulingUploader(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
