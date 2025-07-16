package androidx.compose.ui.text.input;

import android.view.Choreographer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 implements Choreographer.FrameCallback {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0(Runnable runnable) {
        this.f$0 = runnable;
    }

    public final void doFrame(long j) {
        TextInputServiceAndroid_androidKt.asExecutor$lambda$2$lambda$1(this.f$0, j);
    }
}
