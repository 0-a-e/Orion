package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bc\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018Bc\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001bBm\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001cJ\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010<\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010*\u001a\u0004\b)\u0010(R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0004¢\u0006\f\u0012\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/ui/text/TextLayoutInput;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)V", "_developerSuppliedResourceLoader", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getMaxLines", "()I", "getOverflow-gIe3tQ8", "I", "getPlaceholders", "()Ljava/util/List;", "getResourceLoader$annotations", "()V", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "copy", "copy-hu-1Yfo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Landroidx/compose/ui/text/TextLayoutInput;", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutResult.kt */
public final class TextLayoutInput {
    public static final int $stable = 8;
    private Font.ResourceLoader _developerSuppliedResourceLoader;
    private final long constraints;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private final LayoutDirection layoutDirection;
    private final int maxLines;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    @Deprecated(message = "Font.ResourceLoader is replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, fontFamilyResolver, constraints", imports = {}))
    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) list, i, z, i2, density2, layoutDirection2, resourceLoader, j);
    }

    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, FontFamily.Resolver resolver, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) list, i, z, i2, density2, layoutDirection2, resolver, j);
    }

    @Deprecated(message = "Replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getResourceLoader$annotations() {
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, FontFamily.Resolver resolver, long j) {
        this.text = annotatedString;
        this.style = textStyle;
        this.placeholders = list;
        this.maxLines = i;
        this.softWrap = z;
        this.overflow = i2;
        this.density = density2;
        this.layoutDirection = layoutDirection2;
        this.fontFamilyResolver = resolver;
        this.constraints = j;
        this._developerSuppliedResourceLoader = resourceLoader;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    /* renamed from: getOverflow-gIe3tQ8  reason: not valid java name */
    public final int m6011getOverflowgIe3tQ8() {
        return this.overflow;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m6010getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public final Font.ResourceLoader getResourceLoader() {
        Font.ResourceLoader resourceLoader = this._developerSuppliedResourceLoader;
        return resourceLoader == null ? DeprecatedBridgeFontResourceLoader.Companion.from(this.fontFamilyResolver) : resourceLoader;
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j) {
        this(annotatedString, textStyle, list, i, z, i2, density2, layoutDirection2, resourceLoader, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader), j);
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, FontFamily.Resolver resolver, long j) {
        this(annotatedString, textStyle, list, i, z, i2, density2, layoutDirection2, (Font.ResourceLoader) null, resolver, j);
    }

    /* renamed from: copy-hu-1Yfo$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutInput m6008copyhu1Yfo$default(TextLayoutInput textLayoutInput, AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j, int i3, Object obj) {
        long j2;
        TextLayoutInput textLayoutInput2 = textLayoutInput;
        int i4 = i3;
        AnnotatedString annotatedString2 = (i4 & 1) != 0 ? textLayoutInput2.text : annotatedString;
        TextStyle textStyle2 = (i4 & 2) != 0 ? textLayoutInput2.style : textStyle;
        List list2 = (i4 & 4) != 0 ? textLayoutInput2.placeholders : list;
        int i5 = (i4 & 8) != 0 ? textLayoutInput2.maxLines : i;
        boolean z2 = (i4 & 16) != 0 ? textLayoutInput2.softWrap : z;
        int i6 = (i4 & 32) != 0 ? textLayoutInput2.overflow : i2;
        Density density3 = (i4 & 64) != 0 ? textLayoutInput2.density : density2;
        LayoutDirection layoutDirection3 = (i4 & 128) != 0 ? textLayoutInput2.layoutDirection : layoutDirection2;
        Font.ResourceLoader resourceLoader2 = (i4 & 256) != 0 ? textLayoutInput.getResourceLoader() : resourceLoader;
        if ((i4 & 512) != 0) {
            j2 = textLayoutInput2.constraints;
        } else {
            j2 = j;
        }
        return textLayoutInput.m6009copyhu1Yfo(annotatedString2, textStyle2, list2, i5, z2, i6, density3, layoutDirection3, resourceLoader2, j2);
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated", replaceWith = @ReplaceWith(expression = "TextLayoutInput(text, style, placeholders, maxLines, softWrap, overFlow, density, layoutDirection, fontFamilyResolver, constraints)", imports = {}))
    /* renamed from: copy-hu-1Yfo  reason: not valid java name */
    public final TextLayoutInput m6009copyhu1Yfo(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j) {
        return new TextLayoutInput(annotatedString, textStyle, list, i, z, i2, density2, layoutDirection2, resourceLoader, this.fontFamilyResolver, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = (TextLayoutInput) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) textLayoutInput.text) && Intrinsics.areEqual((Object) this.style, (Object) textLayoutInput.style) && Intrinsics.areEqual((Object) this.placeholders, (Object) textLayoutInput.placeholders) && this.maxLines == textLayoutInput.maxLines && this.softWrap == textLayoutInput.softWrap && TextOverflow.m6504equalsimpl0(this.overflow, textLayoutInput.overflow) && Intrinsics.areEqual((Object) this.density, (Object) textLayoutInput.density) && this.layoutDirection == textLayoutInput.layoutDirection && Intrinsics.areEqual((Object) this.fontFamilyResolver, (Object) textLayoutInput.fontFamilyResolver) && Constraints.m6519equalsimpl0(this.constraints, textLayoutInput.constraints);
    }

    public int hashCode() {
        return (((((((((((((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.placeholders.hashCode()) * 31) + this.maxLines) * 31) + UByte$$ExternalSyntheticBackport0.m(this.softWrap)) * 31) + TextOverflow.m6505hashCodeimpl(this.overflow)) * 31) + this.density.hashCode()) * 31) + this.layoutDirection.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31) + Constraints.m6529hashCodeimpl(this.constraints);
    }

    public String toString() {
        return "TextLayoutInput(text=" + this.text + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + TextOverflow.m6506toStringimpl(this.overflow) + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.m6531toStringimpl(this.constraints) + ')';
    }
}
