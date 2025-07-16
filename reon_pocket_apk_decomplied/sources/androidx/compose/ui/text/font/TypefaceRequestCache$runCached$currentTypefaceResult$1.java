package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "finalResult", "Landroidx/compose/ui/text/font/TypefaceResult;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.kt */
final class TypefaceRequestCache$runCached$currentTypefaceResult$1 extends Lambda implements Function1<TypefaceResult, Unit> {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ TypefaceRequestCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypefaceRequestCache$runCached$currentTypefaceResult$1(TypefaceRequestCache typefaceRequestCache, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = typefaceRequestCache;
        this.$typefaceRequest = typefaceRequest;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypefaceResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TypefaceResult typefaceResult) {
        SynchronizedObject lock$ui_text_release = this.this$0.getLock$ui_text_release();
        TypefaceRequestCache typefaceRequestCache = this.this$0;
        TypefaceRequest typefaceRequest = this.$typefaceRequest;
        synchronized (lock$ui_text_release) {
            if (typefaceResult.getCacheable()) {
                typefaceRequestCache.resultCache.put(typefaceRequest, typefaceResult);
            } else {
                typefaceRequestCache.resultCache.remove(typefaceRequest);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
