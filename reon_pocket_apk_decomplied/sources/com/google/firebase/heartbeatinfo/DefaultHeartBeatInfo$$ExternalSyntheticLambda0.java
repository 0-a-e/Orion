package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultHeartBeatInfo$$ExternalSyntheticLambda0 implements Provider {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ DefaultHeartBeatInfo$$ExternalSyntheticLambda0(Context context) {
        this.f$0 = context;
    }

    public final Object get() {
        return HeartBeatInfoStorage.getInstance(this.f$0);
    }
}
