package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B­\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015\u0012\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020\u0002H\u0016J\u0013\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u0012H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0002H\u0016J\f\u0010'\u001a\u00020\f*\u00020(H\u0016R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u000eX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u001c\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "equals", "other", "", "hashCode", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextAnnotatedStringElement.kt */
public final class TextAnnotatedStringElement extends ModifierNodeElement<TextAnnotatedStringNode> {
    public static final int $stable = 0;
    private final ColorProducer color;
    private final FontFamily.Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final Function1<List<Rect>, Unit> onPlaceholderLayout;
    private final Function1<TextLayoutResult, Unit> onTextLayout;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final SelectionController selectionController;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    public /* synthetic */ TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function12, SelectionController selectionController2, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController2, colorProducer);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextAnnotatedStringElement(androidx.compose.ui.text.AnnotatedString r18, androidx.compose.ui.text.TextStyle r19, androidx.compose.ui.text.font.FontFamily.Resolver r20, kotlin.jvm.functions.Function1 r21, int r22, boolean r23, int r24, int r25, java.util.List r26, kotlin.jvm.functions.Function1 r27, androidx.compose.foundation.text.modifiers.SelectionController r28, androidx.compose.ui.graphics.ColorProducer r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontFamily$Resolver, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.List, kotlin.jvm.functions.Function1, androidx.compose.foundation.text.modifiers.SelectionController, androidx.compose.ui.graphics.ColorProducer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController2, ColorProducer colorProducer) {
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.onTextLayout = function1;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.placeholders = list;
        this.onPlaceholderLayout = function12;
        this.selectionController = selectionController2;
        this.color = colorProducer;
    }

    public TextAnnotatedStringNode create() {
        return new TextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, (DefaultConstructorMarker) null);
    }

    public void update(TextAnnotatedStringNode textAnnotatedStringNode) {
        textAnnotatedStringNode.doInvalidations(textAnnotatedStringNode.updateDraw(this.color, this.style), textAnnotatedStringNode.updateText(this.text), textAnnotatedStringNode.m1204updateLayoutRelatedArgsMPT68mk(this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow), textAnnotatedStringNode.updateCallbacks(this.onTextLayout, this.onPlaceholderLayout, this.selectionController));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        return Intrinsics.areEqual((Object) this.color, (Object) textAnnotatedStringElement.color) && Intrinsics.areEqual((Object) this.text, (Object) textAnnotatedStringElement.text) && Intrinsics.areEqual((Object) this.style, (Object) textAnnotatedStringElement.style) && Intrinsics.areEqual((Object) this.placeholders, (Object) textAnnotatedStringElement.placeholders) && Intrinsics.areEqual((Object) this.fontFamilyResolver, (Object) textAnnotatedStringElement.fontFamilyResolver) && Intrinsics.areEqual((Object) this.onTextLayout, (Object) textAnnotatedStringElement.onTextLayout) && TextOverflow.m6504equalsimpl0(this.overflow, textAnnotatedStringElement.overflow) && this.softWrap == textAnnotatedStringElement.softWrap && this.maxLines == textAnnotatedStringElement.maxLines && this.minLines == textAnnotatedStringElement.minLines && Intrinsics.areEqual((Object) this.onPlaceholderLayout, (Object) textAnnotatedStringElement.onPlaceholderLayout) && Intrinsics.areEqual((Object) this.selectionController, (Object) textAnnotatedStringElement.selectionController);
    }

    public int hashCode() {
        int hashCode = ((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31;
        Function1<TextLayoutResult, Unit> function1 = this.onTextLayout;
        int i = 0;
        int hashCode2 = (((((((((hashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + TextOverflow.m6505hashCodeimpl(this.overflow)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.softWrap)) * 31) + this.maxLines) * 31) + this.minLines) * 31;
        List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Function1<List<Rect>, Unit> function12 = this.onPlaceholderLayout;
        int hashCode4 = (hashCode3 + (function12 != null ? function12.hashCode() : 0)) * 31;
        SelectionController selectionController2 = this.selectionController;
        int hashCode5 = (hashCode4 + (selectionController2 != null ? selectionController2.hashCode() : 0)) * 31;
        ColorProducer colorProducer = this.color;
        if (colorProducer != null) {
            i = colorProducer.hashCode();
        }
        return hashCode5 + i;
    }
}
