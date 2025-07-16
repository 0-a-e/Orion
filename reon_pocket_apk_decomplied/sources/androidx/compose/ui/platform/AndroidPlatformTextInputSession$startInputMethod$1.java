package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.AndroidPlatformTextInputSession", f = "AndroidPlatformTextInputSession.android.kt", i = {}, l = {69}, m = "startInputMethod", n = {}, s = {})
/* compiled from: AndroidPlatformTextInputSession.android.kt */
final class AndroidPlatformTextInputSession$startInputMethod$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidPlatformTextInputSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidPlatformTextInputSession$startInputMethod$1(AndroidPlatformTextInputSession androidPlatformTextInputSession, Continuation<? super AndroidPlatformTextInputSession$startInputMethod$1> continuation) {
        super(continuation);
        this.this$0 = androidPlatformTextInputSession;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startInputMethod((PlatformTextInputMethodRequest) null, this);
    }
}
