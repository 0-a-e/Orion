package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000bJ\u0015\u0010&\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001cJ.\u0010(\u001a\u00020)2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text/TextFieldSize;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "resolvedStyle", "Landroidx/compose/ui/text/TextStyle;", "typeface", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/text/TextStyle;Ljava/lang/Object;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "minSize", "getMinSize-YbymL2g", "()J", "J", "getResolvedStyle", "()Landroidx/compose/ui/text/TextStyle;", "setResolvedStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "getTypeface", "()Ljava/lang/Object;", "setTypeface", "(Ljava/lang/Object;)V", "computeMinSize", "computeMinSize-YbymL2g", "update", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSize.kt */
final class TextFieldSize {
    private Density density;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection layoutDirection;
    private long minSize = m1143computeMinSizeYbymL2g();
    private TextStyle resolvedStyle;
    private Object typeface;

    public TextFieldSize(LayoutDirection layoutDirection2, Density density2, FontFamily.Resolver resolver, TextStyle textStyle, Object obj) {
        this.layoutDirection = layoutDirection2;
        this.density = density2;
        this.fontFamilyResolver = resolver;
        this.resolvedStyle = textStyle;
        this.typeface = obj;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final void setLayoutDirection(LayoutDirection layoutDirection2) {
        this.layoutDirection = layoutDirection2;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density density2) {
        this.density = density2;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver = resolver;
    }

    public final TextStyle getResolvedStyle() {
        return this.resolvedStyle;
    }

    public final void setResolvedStyle(TextStyle textStyle) {
        this.resolvedStyle = textStyle;
    }

    public final Object getTypeface() {
        return this.typeface;
    }

    public final void setTypeface(Object obj) {
        this.typeface = obj;
    }

    /* renamed from: getMinSize-YbymL2g  reason: not valid java name */
    public final long m1144getMinSizeYbymL2g() {
        return this.minSize;
    }

    public final void update(LayoutDirection layoutDirection2, Density density2, FontFamily.Resolver resolver, TextStyle textStyle, Object obj) {
        if (layoutDirection2 != this.layoutDirection || !Intrinsics.areEqual((Object) density2, (Object) this.density) || !Intrinsics.areEqual((Object) resolver, (Object) this.fontFamilyResolver) || !Intrinsics.areEqual((Object) textStyle, (Object) this.resolvedStyle) || !Intrinsics.areEqual(obj, this.typeface)) {
            this.layoutDirection = layoutDirection2;
            this.density = density2;
            this.fontFamilyResolver = resolver;
            this.resolvedStyle = textStyle;
            this.typeface = obj;
            this.minSize = m1143computeMinSizeYbymL2g();
        }
    }

    /* renamed from: computeMinSize-YbymL2g  reason: not valid java name */
    private final long m1143computeMinSizeYbymL2g() {
        return TextFieldDelegateKt.computeSizeForDefaultText$default(this.resolvedStyle, this.density, this.fontFamilyResolver, (String) null, 0, 24, (Object) null);
    }
}
