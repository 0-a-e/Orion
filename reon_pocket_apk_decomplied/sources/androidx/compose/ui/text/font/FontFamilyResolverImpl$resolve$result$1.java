package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/font/TypefaceResult;", "onAsyncCompletion", "Lkotlin/Function1;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.kt */
final class FontFamilyResolverImpl$resolve$result$1 extends Lambda implements Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult> {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FontFamilyResolverImpl$resolve$result$1(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
        this.$typefaceRequest = typefaceRequest;
    }

    public final TypefaceResult invoke(Function1<? super TypefaceResult, Unit> function1) {
        TypefaceResult resolve = this.this$0.fontListFontFamilyTypefaceAdapter.resolve(this.$typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), function1, this.this$0.createDefaultTypeface);
        if (resolve != null || (resolve = this.this$0.platformFamilyTypefaceAdapter.resolve(this.$typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), function1, this.this$0.createDefaultTypeface)) != null) {
            return resolve;
        }
        throw new IllegalStateException("Could not load font");
    }
}
