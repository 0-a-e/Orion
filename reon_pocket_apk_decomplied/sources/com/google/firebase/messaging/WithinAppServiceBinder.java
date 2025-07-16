package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
class WithinAppServiceBinder extends Binder {
    private final IntentHandler intentHandler;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    interface IntentHandler {
        Task<Void> handle(Intent intent);
    }

    WithinAppServiceBinder(IntentHandler intentHandler2) {
        this.intentHandler = intentHandler2;
    }

    /* access modifiers changed from: package-private */
    public void send(WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "service received new intent via bind strategy");
            }
            this.intentHandler.handle(bindRequest.intent).addOnCompleteListener(WithinAppServiceBinder$$Lambda$0.$instance, new WithinAppServiceBinder$$Lambda$1(bindRequest));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
