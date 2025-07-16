package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.AndroidComposeView", f = "AndroidComposeView.android.kt", i = {}, l = {428}, m = "textInputSession", n = {}, s = {})
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$textInputSession$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$textInputSession$1(AndroidComposeView androidComposeView, Continuation<? super AndroidComposeView$textInputSession$1> continuation) {
        super(continuation);
        this.this$0 = androidComposeView;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.textInputSession((Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object>) null, this);
    }
}
