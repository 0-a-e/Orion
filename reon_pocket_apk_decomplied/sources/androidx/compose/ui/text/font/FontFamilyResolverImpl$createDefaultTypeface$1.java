package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/text/font/TypefaceRequest;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.kt */
final class FontFamilyResolverImpl$createDefaultTypeface$1 extends Lambda implements Function1<TypefaceRequest, Object> {
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FontFamilyResolverImpl$createDefaultTypeface$1(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
    }

    public final Object invoke(TypefaceRequest typefaceRequest) {
        return this.this$0.resolve(TypefaceRequest.m6211copye1PVR60$default(typefaceRequest, (FontFamily) null, (FontWeight) null, 0, 0, (Object) null, 30, (Object) null)).getValue();
    }
}
