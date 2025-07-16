package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", i = {0}, l = {61}, m = "scrollBy", n = {"consumed"}, s = {"L$0"})
/* compiled from: ScrollExtensions.kt */
final class ScrollExtensionsKt$scrollBy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ScrollExtensionsKt$scrollBy$1(Continuation<? super ScrollExtensionsKt$scrollBy$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScrollExtensionsKt.scrollBy((ScrollableState) null, 0.0f, this);
    }
}
