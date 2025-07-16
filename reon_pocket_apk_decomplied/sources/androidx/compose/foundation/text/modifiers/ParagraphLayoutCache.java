package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0016\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\"\u0010=\u001a\u0002012\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@J \u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\b\u0010D\u001a\u00020,H\u0002J\u000e\u0010E\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\"\u0010G\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010CJ\u0010\u0010I\u001a\u0002072\u0006\u0010<\u001a\u00020\u001fH\u0002J\u0010\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010\u0004\u001a\u00020\u0005JH\u0010L\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\bM\u0010NR\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u00020!X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"R\"\u0010#\u001a\u00020$X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8@X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u0010\b\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\u000209X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006O"}, d2 = {"Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "cachedIntrinsicHeight", "cachedIntrinsicHeightInputWidth", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "didOverflow", "getDidOverflow$foundation_release", "()Z", "setDidOverflow$foundation_release", "(Z)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "layoutSize", "Landroidx/compose/ui/unit/IntSize;", "getLayoutSize-YbymL2g$foundation_release", "()J", "setLayoutSize-ozmzZPI$foundation_release", "(J)V", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "observeFontChanges", "", "getObserveFontChanges$foundation_release", "()Lkotlin/Unit;", "I", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "getParagraph$foundation_release", "()Landroidx/compose/ui/text/Paragraph;", "setParagraph$foundation_release", "(Landroidx/compose/ui/text/Paragraph;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "prevConstraints", "Landroidx/compose/ui/unit/Constraints;", "intrinsicHeight", "width", "layoutDirection", "layoutText", "constraints", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/Paragraph;", "layoutWithConstraints", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "maxIntrinsicWidth", "minIntrinsicWidth", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-K40F9xA", "setLayoutDirection", "slowCreateTextLayoutResultOrNull", "Landroidx/compose/ui/text/TextLayoutResult;", "update", "update-L6sJoHM", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZII)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParagraphLayoutCache.kt */
public final class ParagraphLayoutCache {
    public static final int $stable = 8;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private boolean didOverflow;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private long layoutSize;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private Paragraph paragraph;
    private ParagraphIntrinsics paragraphIntrinsics;
    private long prevConstraints;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    public /* synthetic */ ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i, z, i2, i3);
    }

    private ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.lastDensity = InlineDensity.Companion.m1172getUnspecifiedL26CHvs();
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.prevConstraints = Constraints.Companion.m6534fixedJhjzzOo(0, 0);
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, (i4 & 8) != 0 ? TextOverflow.Companion.m6511getClipgIe3tQ8() : i, (i4 & 16) != 0 ? true : z, (i4 & 32) != 0 ? Integer.MAX_VALUE : i2, (i4 & 64) != 0 ? 1 : i3, (DefaultConstructorMarker) null);
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density2) {
        Density density3 = this.density;
        long r1 = density2 != null ? InlineDensity.m1164constructorimpl(density2) : InlineDensity.Companion.m1172getUnspecifiedL26CHvs();
        if (density3 == null) {
            this.density = density2;
            this.lastDensity = r1;
        } else if (density2 == null || !InlineDensity.m1166equalsimpl0(this.lastDensity, r1)) {
            this.density = density2;
            this.lastDensity = r1;
            markDirty();
        }
    }

    public final Unit getObserveFontChanges$foundation_release() {
        ParagraphIntrinsics paragraphIntrinsics2 = this.paragraphIntrinsics;
        if (paragraphIntrinsics2 != null) {
            paragraphIntrinsics2.getHasStaleResolvedFonts();
        }
        return Unit.INSTANCE;
    }

    public final Paragraph getParagraph$foundation_release() {
        return this.paragraph;
    }

    public final void setParagraph$foundation_release(Paragraph paragraph2) {
        this.paragraph = paragraph2;
    }

    public final boolean getDidOverflow$foundation_release() {
        return this.didOverflow;
    }

    public final void setDidOverflow$foundation_release(boolean z) {
        this.didOverflow = z;
    }

    /* renamed from: getLayoutSize-YbymL2g$foundation_release  reason: not valid java name */
    public final long m1186getLayoutSizeYbymL2g$foundation_release() {
        return this.layoutSize;
    }

    /* renamed from: setLayoutSize-ozmzZPI$foundation_release  reason: not valid java name */
    public final void m1188setLayoutSizeozmzZPI$foundation_release(long j) {
        this.layoutSize = j;
    }

    /* renamed from: layoutWithConstraints-K40F9xA  reason: not valid java name */
    public final boolean m1187layoutWithConstraintsK40F9xA(long j, LayoutDirection layoutDirection) {
        boolean z = true;
        if (this.minLines > 1) {
            MinLinesConstrainer.Companion companion = MinLinesConstrainer.Companion;
            MinLinesConstrainer minLinesConstrainer = this.mMinLinesConstrainer;
            TextStyle textStyle = this.style;
            Density density2 = this.density;
            Intrinsics.checkNotNull(density2);
            MinLinesConstrainer from = companion.from(minLinesConstrainer, layoutDirection, textStyle, density2, this.fontFamilyResolver);
            this.mMinLinesConstrainer = from;
            j = from.m1176coerceMinLinesOh53vG4$foundation_release(j, this.minLines);
        }
        boolean z2 = false;
        if (!m1185newLayoutWillBeDifferentK40F9xA(j, layoutDirection)) {
            if (!Constraints.m6519equalsimpl0(j, this.prevConstraints)) {
                Paragraph paragraph2 = this.paragraph;
                Intrinsics.checkNotNull(paragraph2);
                long r3 = ConstraintsKt.m6537constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(Math.min(paragraph2.getMaxIntrinsicWidth(), paragraph2.getWidth())), TextDelegateKt.ceilToIntPx(paragraph2.getHeight())));
                this.layoutSize = r3;
                if (TextOverflow.m6504equalsimpl0(this.overflow, TextOverflow.Companion.m6513getVisiblegIe3tQ8()) || (((float) IntSize.m6790getWidthimpl(r3)) >= paragraph2.getWidth() && ((float) IntSize.m6789getHeightimpl(r3)) >= paragraph2.getHeight())) {
                    z = false;
                }
                this.didOverflow = z;
                this.prevConstraints = j;
            }
            return false;
        }
        Paragraph r11 = m1184layoutTextK40F9xA(j, layoutDirection);
        this.prevConstraints = j;
        long r9 = ConstraintsKt.m6537constrain4WqzIAM(j, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(r11.getWidth()), TextDelegateKt.ceilToIntPx(r11.getHeight())));
        this.layoutSize = r9;
        if (!TextOverflow.m6504equalsimpl0(this.overflow, TextOverflow.Companion.m6513getVisiblegIe3tQ8()) && (((float) IntSize.m6790getWidthimpl(r9)) < r11.getWidth() || ((float) IntSize.m6789getHeightimpl(r9)) < r11.getHeight())) {
            z2 = true;
        }
        this.didOverflow = z2;
        this.paragraph = r11;
        return true;
    }

    public final int intrinsicHeight(int i, LayoutDirection layoutDirection) {
        int i2 = this.cachedIntrinsicHeightInputWidth;
        int i3 = this.cachedIntrinsicHeight;
        if (i == i2 && i2 != -1) {
            return i3;
        }
        int ceilToIntPx = TextDelegateKt.ceilToIntPx(m1184layoutTextK40F9xA(ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), layoutDirection).getHeight());
        this.cachedIntrinsicHeightInputWidth = i;
        this.cachedIntrinsicHeight = ceilToIntPx;
        return ceilToIntPx;
    }

    /* renamed from: update-L6sJoHM  reason: not valid java name */
    public final void m1189updateL6sJoHM(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        markDirty();
    }

    private final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics2 = this.paragraphIntrinsics;
        if (paragraphIntrinsics2 == null || layoutDirection != this.intrinsicsLayoutDirection || paragraphIntrinsics2.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            String str = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density2 = this.density;
            Intrinsics.checkNotNull(density2);
            paragraphIntrinsics2 = ParagraphIntrinsicsKt.ParagraphIntrinsics$default(str, resolveDefaults, (List) null, (List) null, density2, this.fontFamilyResolver, 12, (Object) null);
        }
        this.paragraphIntrinsics = paragraphIntrinsics2;
        return paragraphIntrinsics2;
    }

    /* renamed from: layoutText-K40F9xA  reason: not valid java name */
    private final Paragraph m1184layoutTextK40F9xA(long j, LayoutDirection layoutDirection) {
        ParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        return ParagraphKt.m5935Paragraph_EkL_Y(layoutDirection2, LayoutUtilsKt.m1173finalConstraintstfFHcEY(j, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth()), LayoutUtilsKt.m1174finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), TextOverflow.m6504equalsimpl0(this.overflow, TextOverflow.Companion.m6512getEllipsisgIe3tQ8()));
    }

    /* renamed from: newLayoutWillBeDifferent-K40F9xA  reason: not valid java name */
    private final boolean m1185newLayoutWillBeDifferentK40F9xA(long j, LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics2;
        Paragraph paragraph2 = this.paragraph;
        if (paragraph2 == null || (paragraphIntrinsics2 = this.paragraphIntrinsics) == null || paragraphIntrinsics2.getHasStaleResolvedFonts() || layoutDirection != this.intrinsicsLayoutDirection) {
            return true;
        }
        if (Constraints.m6519equalsimpl0(j, this.prevConstraints)) {
            return false;
        }
        if (Constraints.m6526getMaxWidthimpl(j) == Constraints.m6526getMaxWidthimpl(this.prevConstraints) && ((float) Constraints.m6525getMaxHeightimpl(j)) >= paragraph2.getHeight() && !paragraph2.getDidExceedMaxLines()) {
            return false;
        }
        return true;
    }

    private final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = Constraints.Companion.m6534fixedJhjzzOo(0, 0);
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.didOverflow = false;
    }

    public final TextLayoutResult slowCreateTextLayoutResultOrNull(TextStyle textStyle) {
        Density density2;
        LayoutDirection layoutDirection = this.intrinsicsLayoutDirection;
        if (layoutDirection == null || (density2 = this.density) == null) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.text, (List) null, (List) null, 6, (DefaultConstructorMarker) null);
        if (this.paragraph == null || this.paragraphIntrinsics == null) {
            return null;
        }
        long r26 = Constraints.m6517copyZbe2FdA$default(this.prevConstraints, 0, 0, 0, 0, 10, (Object) null);
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString, textStyle, CollectionsKt.emptyList(), this.maxLines, this.softWrap, this.overflow, density2, layoutDirection, this.fontFamilyResolver, r26, (DefaultConstructorMarker) null);
        MultiParagraph multiParagraph = new MultiParagraph(new MultiParagraphIntrinsics(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) CollectionsKt.emptyList(), density2, this.fontFamilyResolver), r26, this.maxLines, TextOverflow.m6504equalsimpl0(this.overflow, TextOverflow.Companion.m6512getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
        return new TextLayoutResult(textLayoutInput, multiParagraph, this.layoutSize, (DefaultConstructorMarker) null);
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }
}
