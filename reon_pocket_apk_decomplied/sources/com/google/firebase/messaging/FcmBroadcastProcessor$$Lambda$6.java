package com.google.firebase.messaging;

import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final /* synthetic */ class FcmBroadcastProcessor$$Lambda$6 implements Continuation {
    static final Continuation $instance = new FcmBroadcastProcessor$$Lambda$6();

    private FcmBroadcastProcessor$$Lambda$6() {
    }

    public Object then(Task task) {
        return Integer.valueOf(Constants.BUCKET_ACCESS_FORBIDDEN_STATUS_CODE);
    }
}
