package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.AsyncTypefaceCache", f = "FontListFontFamilyTypefaceAdapter.kt", i = {0, 0, 0}, l = {398}, m = "runCached", n = {"this", "key", "forever"}, s = {"L$0", "L$1", "Z$0"})
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
final class AsyncTypefaceCache$runCached$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncTypefaceCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncTypefaceCache$runCached$1(AsyncTypefaceCache asyncTypefaceCache, Continuation<? super AsyncTypefaceCache$runCached$1> continuation) {
        super(continuation);
        this.this$0 = asyncTypefaceCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runCached((Font) null, (PlatformFontLoader) null, false, (Function1<? super Continuation<Object>, ? extends Object>) null, this);
    }
}
