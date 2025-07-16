package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jt\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "defaultFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "defaultDensity", "Landroidx/compose/ui/unit/Density;", "defaultLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextMeasurer.kt */
public final class TextMeasurer {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int cacheSize;
    private final Density defaultDensity;
    private final FontFamily.Resolver defaultFontFamilyResolver;
    private final LayoutDirection defaultLayoutDirection;
    private final TextLayoutCache textLayoutCache;

    public TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i) {
        this.defaultFontFamilyResolver = resolver;
        this.defaultDensity = density;
        this.defaultLayoutDirection = layoutDirection;
        this.cacheSize = i;
        this.textLayoutCache = i > 0 ? new TextLayoutCache(i) : null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }

    /* renamed from: measure-xDpz5zY$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m6018measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        FontFamily.Resolver resolver2;
        TextMeasurer textMeasurer2 = textMeasurer;
        int i4 = i3;
        TextStyle textStyle2 = (i4 & 2) != 0 ? TextStyle.Companion.getDefault() : textStyle;
        int r3 = (i4 & 4) != 0 ? TextOverflow.Companion.m6511getClipgIe3tQ8() : i;
        boolean z3 = (i4 & 8) != 0 ? true : z;
        int i5 = (i4 & 16) != 0 ? Integer.MAX_VALUE : i2;
        List emptyList = (i4 & 32) != 0 ? CollectionsKt.emptyList() : list;
        long Constraints$default = (i4 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null) : j;
        LayoutDirection layoutDirection2 = (i4 & 128) != 0 ? textMeasurer2.defaultLayoutDirection : layoutDirection;
        Density density2 = (i4 & 256) != 0 ? textMeasurer2.defaultDensity : density;
        if ((i4 & 512) != 0) {
            resolver2 = textMeasurer2.defaultFontFamilyResolver;
        } else {
            resolver2 = resolver;
        }
        return textMeasurer.m6020measurexDpz5zY(annotatedString, textStyle2, r3, z3, i5, emptyList, Constraints$default, layoutDirection2, density2, resolver2, (i4 & 1024) != 0 ? false : z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001e, code lost:
        r1 = r0.textLayoutCache;
     */
    /* renamed from: measure-xDpz5zY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.TextLayoutResult m6020measurexDpz5zY(androidx.compose.ui.text.AnnotatedString r16, androidx.compose.ui.text.TextStyle r17, int r18, boolean r19, int r20, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r21, long r22, androidx.compose.ui.unit.LayoutDirection r24, androidx.compose.ui.unit.Density r25, androidx.compose.ui.text.font.FontFamily.Resolver r26, boolean r27) {
        /*
            r15 = this;
            r0 = r15
            androidx.compose.ui.text.TextLayoutInput r14 = new androidx.compose.ui.text.TextLayoutInput
            r13 = 0
            r1 = r14
            r2 = r16
            r3 = r17
            r4 = r21
            r5 = r20
            r6 = r19
            r7 = r18
            r8 = r25
            r9 = r24
            r10 = r26
            r11 = r22
            r1.<init>((androidx.compose.ui.text.AnnotatedString) r2, (androidx.compose.ui.text.TextStyle) r3, (java.util.List) r4, (int) r5, (boolean) r6, (int) r7, (androidx.compose.ui.unit.Density) r8, (androidx.compose.ui.unit.LayoutDirection) r9, (androidx.compose.ui.text.font.FontFamily.Resolver) r10, (long) r11, (kotlin.jvm.internal.DefaultConstructorMarker) r13)
            if (r27 != 0) goto L_0x0027
            androidx.compose.ui.text.TextLayoutCache r1 = r0.textLayoutCache
            if (r1 == 0) goto L_0x0027
            androidx.compose.ui.text.TextLayoutResult r1 = r1.get(r14)
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            if (r1 == 0) goto L_0x0051
            androidx.compose.ui.text.MultiParagraph r2 = r1.getMultiParagraph()
            float r2 = r2.getWidth()
            int r2 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r2)
            androidx.compose.ui.text.MultiParagraph r3 = r1.getMultiParagraph()
            float r3 = r3.getHeight()
            int r3 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r3)
            long r2 = androidx.compose.ui.unit.IntSizeKt.IntSize(r2, r3)
            r4 = r22
            long r2 = androidx.compose.ui.unit.ConstraintsKt.m6537constrain4WqzIAM(r4, r2)
            androidx.compose.ui.text.TextLayoutResult r1 = r1.m6013copyO0kMr_c(r14, r2)
            goto L_0x005e
        L_0x0051:
            androidx.compose.ui.text.TextMeasurer$Companion r1 = Companion
            androidx.compose.ui.text.TextLayoutResult r1 = r1.layout(r14)
            androidx.compose.ui.text.TextLayoutCache r2 = r0.textLayoutCache
            if (r2 == 0) goto L_0x005e
            r2.put(r14, r1)
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextMeasurer.m6020measurexDpz5zY(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, int, boolean, int, java.util.List, long, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, boolean):androidx.compose.ui.text.TextLayoutResult");
    }

    /* renamed from: measure-wNUYSr0$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m6017measurewNUYSr0$default(TextMeasurer textMeasurer, String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        FontFamily.Resolver resolver2;
        TextMeasurer textMeasurer2 = textMeasurer;
        int i4 = i3;
        TextStyle textStyle2 = (i4 & 2) != 0 ? TextStyle.Companion.getDefault() : textStyle;
        int r3 = (i4 & 4) != 0 ? TextOverflow.Companion.m6511getClipgIe3tQ8() : i;
        boolean z3 = (i4 & 8) != 0 ? true : z;
        int i5 = (i4 & 16) != 0 ? Integer.MAX_VALUE : i2;
        long Constraints$default = (i4 & 32) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null) : j;
        LayoutDirection layoutDirection2 = (i4 & 64) != 0 ? textMeasurer2.defaultLayoutDirection : layoutDirection;
        Density density2 = (i4 & 128) != 0 ? textMeasurer2.defaultDensity : density;
        if ((i4 & 256) != 0) {
            resolver2 = textMeasurer2.defaultFontFamilyResolver;
        } else {
            resolver2 = resolver;
        }
        return textMeasurer.m6019measurewNUYSr0(str, textStyle2, r3, z3, i5, Constraints$default, layoutDirection2, density2, resolver2, (i4 & 512) != 0 ? false : z2);
    }

    /* renamed from: measure-wNUYSr0  reason: not valid java name */
    public final TextLayoutResult m6019measurewNUYSr0(String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2) {
        return m6018measurexDpz5zY$default(this, new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), textStyle, i, z, i2, (List) null, j, layoutDirection, density, resolver, z2, 32, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextMeasurer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            int i;
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
            int r0 = Constraints.m6528getMinWidthimpl(textLayoutInput.m6010getConstraintsmsEJaDk());
            int r1 = ((textLayoutInput.getSoftWrap() || TextOverflow.m6504equalsimpl0(textLayoutInput.m6011getOverflowgIe3tQ8(), TextOverflow.Companion.m6512getEllipsisgIe3tQ8())) && Constraints.m6522getHasBoundedWidthimpl(textLayoutInput.m6010getConstraintsmsEJaDk())) ? Constraints.m6526getMaxWidthimpl(textLayoutInput.m6010getConstraintsmsEJaDk()) : Integer.MAX_VALUE;
            if (textLayoutInput.getSoftWrap() || !TextOverflow.m6504equalsimpl0(textLayoutInput.m6011getOverflowgIe3tQ8(), TextOverflow.Companion.m6512getEllipsisgIe3tQ8())) {
                i = textLayoutInput.getMaxLines();
            } else {
                i = 1;
            }
            int i2 = i;
            if (r0 != r1) {
                r1 = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), r0, r1);
            }
            MultiParagraph multiParagraph = new MultiParagraph(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, r1, 0, Constraints.m6525getMaxHeightimpl(textLayoutInput.m6010getConstraintsmsEJaDk()), 5, (Object) null), i2, TextOverflow.m6504equalsimpl0(textLayoutInput.m6011getOverflowgIe3tQ8(), TextOverflow.Companion.m6512getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
            return new TextLayoutResult(textLayoutInput, multiParagraph, ConstraintsKt.m6537constrain4WqzIAM(textLayoutInput.m6010getConstraintsmsEJaDk(), IntSizeKt.IntSize((int) ((float) Math.ceil((double) multiParagraph.getWidth())), (int) ((float) Math.ceil((double) multiParagraph.getHeight())))), (DefaultConstructorMarker) null);
        }
    }
}
