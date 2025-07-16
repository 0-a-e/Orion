package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.TypefaceHelperMethodsApi28;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\t0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidGenericFontFamilyTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "fontFamily", "Landroidx/compose/ui/text/font/GenericFontFamily;", "(Landroidx/compose/ui/text/font/GenericFontFamily;)V", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "nativeTypeface", "Landroid/graphics/Typeface;", "buildStyledTypeface", "kotlin.jvm.PlatformType", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "buildStyledTypeface-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "getNativeTypeface", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(message = "This path for preloading loading fonts is not supported.")
/* compiled from: AndroidGenericFontFamilyTypeface.android.kt */
public final class AndroidGenericFontFamilyTypeface implements AndroidTypeface {
    public static final int $stable = 8;
    private final FontFamily fontFamily;
    private final Typeface nativeTypeface;

    public AndroidGenericFontFamilyTypeface(GenericFontFamily genericFontFamily) {
        this.fontFamily = genericFontFamily;
        Typeface create = Typeface.create(genericFontFamily.getName(), 0);
        Intrinsics.checkNotNull(create);
        this.nativeTypeface = create;
    }

    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: getNativeTypeface-PYhJU0U  reason: not valid java name */
    public Typeface m6308getNativeTypefacePYhJU0U(FontWeight fontWeight, int i, int i2) {
        return m6307buildStyledTypefaceFO1MlWM(fontWeight, i);
    }

    /* renamed from: buildStyledTypeface-FO1MlWM  reason: not valid java name */
    private final Typeface m6307buildStyledTypefaceFO1MlWM(FontWeight fontWeight, int i) {
        if (Build.VERSION.SDK_INT < 28) {
            return Typeface.create(this.nativeTypeface, AndroidFontUtils_androidKt.m6107getAndroidTypefaceStyleFO1MlWM(fontWeight, i));
        }
        return TypefaceHelperMethodsApi28.INSTANCE.create(this.nativeTypeface, fontWeight.getWeight(), FontStyle.m6158equalsimpl0(i, FontStyle.Companion.m6164getItalic_LCdwA()));
    }
}
