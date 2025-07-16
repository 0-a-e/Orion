package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.AndroidTypeface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "()V", "platformTypefaceResolver", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "createDefaultTypeface", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformFontFamilyTypefaceAdapter.android.kt */
public final class PlatformFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    public static final int $stable = 8;
    private final PlatformTypefaces platformTypefaceResolver = PlatformTypefaces_androidKt.PlatformTypefaces();

    public TypefaceResult resolve(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1<? super TypefaceResult.Immutable, Unit> function1, Function1<? super TypefaceRequest, ? extends Object> function12) {
        boolean z;
        Typeface typeface;
        FontFamily fontFamily = typefaceRequest.getFontFamily();
        if (fontFamily == null) {
            z = true;
        } else {
            z = fontFamily instanceof DefaultFontFamily;
        }
        if (z) {
            typeface = this.platformTypefaceResolver.m6189createDefaultFO1MlWM(typefaceRequest.getFontWeight(), typefaceRequest.m6215getFontStyle_LCdwA());
        } else if (fontFamily instanceof GenericFontFamily) {
            typeface = this.platformTypefaceResolver.m6190createNamedRetOiIg((GenericFontFamily) typefaceRequest.getFontFamily(), typefaceRequest.getFontWeight(), typefaceRequest.m6215getFontStyle_LCdwA());
        } else if (!(fontFamily instanceof LoadedFontFamily)) {
            return null;
        } else {
            Typeface typeface2 = ((LoadedFontFamily) typefaceRequest.getFontFamily()).getTypeface();
            Intrinsics.checkNotNull(typeface2, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            typeface = ((AndroidTypeface) typeface2).m6323getNativeTypefacePYhJU0U(typefaceRequest.getFontWeight(), typefaceRequest.m6215getFontStyle_LCdwA(), typefaceRequest.m6216getFontSynthesisGVVA2EU());
        }
        return new TypefaceResult.Immutable(typeface, false, 2, (DefaultConstructorMarker) null);
    }
}
