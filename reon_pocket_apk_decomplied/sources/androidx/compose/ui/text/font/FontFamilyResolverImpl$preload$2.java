package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/font/TypefaceResult;", "typeRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.kt */
final class FontFamilyResolverImpl$preload$2 extends Lambda implements Function1<TypefaceRequest, TypefaceResult> {
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FontFamilyResolverImpl$preload$2(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
    }

    public final TypefaceResult invoke(TypefaceRequest typefaceRequest) {
        TypefaceResult resolve = this.this$0.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), AnonymousClass1.INSTANCE, this.this$0.createDefaultTypeface);
        if (resolve != null || (resolve = this.this$0.platformFamilyTypefaceAdapter.resolve(typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), AnonymousClass2.INSTANCE, this.this$0.createDefaultTypeface)) != null) {
            return resolve;
        }
        throw new IllegalStateException("Could not load font");
    }
}
