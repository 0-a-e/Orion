package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u001c\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/text/font/DeviceFontFamilyNameFont;", "Landroidx/compose/ui/text/font/AndroidFont;", "familyName", "Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/String;", "getStyle-_-LCdwA", "()I", "I", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "equals", "", "other", "", "hashCode", "", "loadCached", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DeviceFontFamilyNameFont.android.kt */
final class DeviceFontFamilyNameFont extends AndroidFont {
    private final String familyName;
    private final int style;
    private final FontWeight weight;

    public /* synthetic */ DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fontWeight, i, settings);
    }

    public FontWeight getWeight() {
        return this.weight;
    }

    /* renamed from: getStyle-_-LCdwA  reason: not valid java name */
    public int m6125getStyle_LCdwA() {
        return this.style;
    }

    private DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(FontLoadingStrategy.Companion.m6151getOptionalLocalPKNRLFQ(), NamedFontLoader.INSTANCE, settings, (DefaultConstructorMarker) null);
        this.familyName = str;
        this.weight = fontWeight;
        this.style = i;
    }

    public final Typeface loadCached(Context context) {
        return PlatformTypefaces_androidKt.PlatformTypefaces().m6191optionalOnDeviceFontFamilyByName78DK7lM(this.familyName, getWeight(), m6125getStyle_LCdwA(), getVariationSettings(), context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceFontFamilyNameFont)) {
            return false;
        }
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = (DeviceFontFamilyNameFont) obj;
        return DeviceFontFamilyName.m6121equalsimpl0(this.familyName, deviceFontFamilyNameFont.familyName) && Intrinsics.areEqual((Object) getWeight(), (Object) deviceFontFamilyNameFont.getWeight()) && FontStyle.m6158equalsimpl0(m6125getStyle_LCdwA(), deviceFontFamilyNameFont.m6125getStyle_LCdwA()) && Intrinsics.areEqual((Object) getVariationSettings(), (Object) deviceFontFamilyNameFont.getVariationSettings());
    }

    public int hashCode() {
        return (((((DeviceFontFamilyName.m6122hashCodeimpl(this.familyName) * 31) + getWeight().hashCode()) * 31) + FontStyle.m6159hashCodeimpl(m6125getStyle_LCdwA())) * 31) + getVariationSettings().hashCode();
    }

    public String toString() {
        return "Font(familyName=\"" + DeviceFontFamilyName.m6123toStringimpl(this.familyName) + "\", weight=" + getWeight() + ", style=" + FontStyle.m6160toStringimpl(m6125getStyle_LCdwA()) + ')';
    }
}
