package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final /* synthetic */ class FcmBroadcastProcessor$$Lambda$0 implements Executor {
    static final Executor $instance = new FcmBroadcastProcessor$$Lambda$0();

    private FcmBroadcastProcessor$$Lambda$0() {
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
