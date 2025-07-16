package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B­\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\b\u0002\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0016J¦\u0001\u0010&\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u001c\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u001fø\u0001\u0000¢\u0006\u0004\b(\u0010)J\f\u0010*\u001a\u00020\u000e*\u00020+H\u0016J\u001c\u0010,\u001a\u00020\u0014*\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0014H\u0016J\u001c\u00101\u001a\u00020\u0014*\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00102\u001a\u00020\u0014H\u0016J&\u00103\u001a\u000204*\u0002052\u0006\u0010.\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001c\u0010;\u001a\u00020\u0014*\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0014H\u0016J\u001c\u0010<\u001a\u00020\u0014*\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00102\u001a\u00020\u0014H\u0016R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "delegate", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "update", "color", "update-L09Iy8E", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;)V", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectableTextAnnotatedStringNode.kt */
public final class SelectableTextAnnotatedStringNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private final TextAnnotatedStringNode delegate;
    private SelectionController selectionController;

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function12, SelectionController selectionController2, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController2, colorProducer);
    }

    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SelectableTextAnnotatedStringNode(androidx.compose.ui.text.AnnotatedString r18, androidx.compose.ui.text.TextStyle r19, androidx.compose.ui.text.font.FontFamily.Resolver r20, kotlin.jvm.functions.Function1 r21, int r22, boolean r23, int r24, int r25, java.util.List r26, kotlin.jvm.functions.Function1 r27, androidx.compose.foundation.text.modifiers.SelectionController r28, androidx.compose.ui.graphics.ColorProducer r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r17 = this;
            r0 = r30
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r21
        L_0x000b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0017
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m6511getClipgIe3tQ8()
            r8 = r1
            goto L_0x0019
        L_0x0017:
            r8 = r22
        L_0x0019:
            r1 = r0 & 32
            r3 = 1
            if (r1 == 0) goto L_0x0020
            r9 = r3
            goto L_0x0022
        L_0x0020:
            r9 = r23
        L_0x0022:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002b
            r1 = 2147483647(0x7fffffff, float:NaN)
            r10 = r1
            goto L_0x002d
        L_0x002b:
            r10 = r24
        L_0x002d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0033
            r11 = r3
            goto L_0x0035
        L_0x0033:
            r11 = r25
        L_0x0035:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003b
            r12 = r2
            goto L_0x003d
        L_0x003b:
            r12 = r26
        L_0x003d:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0043
            r13 = r2
            goto L_0x0045
        L_0x0043:
            r13 = r27
        L_0x0045:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004b
            r14 = r2
            goto L_0x004d
        L_0x004b:
            r14 = r28
        L_0x004d:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0053
            r15 = r2
            goto L_0x0055
        L_0x0053:
            r15 = r29
        L_0x0055:
            r16 = 0
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringNode.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontFamily$Resolver, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.List, kotlin.jvm.functions.Function1, androidx.compose.foundation.text.modifiers.SelectionController, androidx.compose.ui.graphics.ColorProducer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController2, ColorProducer colorProducer) {
        this.selectionController = selectionController2;
        this.delegate = (TextAnnotatedStringNode) delegate(new TextAnnotatedStringNode(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, this.selectionController, colorProducer, (DefaultConstructorMarker) null));
        if (this.selectionController == null) {
            throw new IllegalArgumentException("Do not use SelectionCapableStaticTextModifier unless selectionController != null".toString());
        }
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        SelectionController selectionController2 = this.selectionController;
        if (selectionController2 != null) {
            selectionController2.updateGlobalPosition(layoutCoordinates);
        }
    }

    public void draw(ContentDrawScope contentDrawScope) {
        this.delegate.drawNonExtension(contentDrawScope);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1193measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return this.delegate.m1203measureNonExtension3p2s80s(measureScope, measurable, j);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.delegate.minIntrinsicWidthNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.delegate.minIntrinsicHeightNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.delegate.maxIntrinsicWidthNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.delegate.maxIntrinsicHeightNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: update-L09Iy8E  reason: not valid java name */
    public final void m1194updateL09Iy8E(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, int i2, boolean z, FontFamily.Resolver resolver, int i3, Function1<? super TextLayoutResult, Unit> function1, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController2, ColorProducer colorProducer) {
        SelectionController selectionController3 = selectionController2;
        TextAnnotatedStringNode textAnnotatedStringNode = this.delegate;
        AnnotatedString annotatedString2 = annotatedString;
        textAnnotatedStringNode.doInvalidations(textAnnotatedStringNode.updateDraw(colorProducer, textStyle), this.delegate.updateText(annotatedString), this.delegate.m1204updateLayoutRelatedArgsMPT68mk(textStyle, list, i, i2, z, resolver, i3), this.delegate.updateCallbacks(function1, function12, selectionController3));
        this.selectionController = selectionController3;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }
}
