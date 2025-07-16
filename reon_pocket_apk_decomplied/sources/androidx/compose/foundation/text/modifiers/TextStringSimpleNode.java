package androidx.compose.foundation.text.modifiers;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001PBQ\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010+\u001a\u00020,H\u0002J\u001e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0006H\u0002J\u0018\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\bJ@\u00107\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b8\u00109J\u000e\u0010:\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010;\u001a\u00020,*\u00020<H\u0016J\f\u0010=\u001a\u00020,*\u00020>H\u0016J\u001c\u0010?\u001a\u00020\u0010*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0010H\u0016J\u001c\u0010D\u001a\u00020\u0010*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010E\u001a\u00020\u0010H\u0016J&\u0010F\u001a\u00020G*\u00020H2\u0006\u0010A\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020\u0010*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0010H\u0016J\u001c\u0010O\u001a\u00020\u0010*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010E\u001a\u00020\u0010H\u0016R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 \u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8B@BX\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "I", "semanticsTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "<set-?>", "Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "textSubstitution", "getTextSubstitution", "()Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "setTextSubstitution", "(Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;)V", "textSubstitution$delegate", "Landroidx/compose/runtime/MutableState;", "clearSubstitution", "", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "density", "Landroidx/compose/ui/unit/Density;", "setSubstitution", "updatedText", "updateDraw", "color", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-HuAbxIM", "(Landroidx/compose/ui/text/TextStyle;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateText", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "TextSubstitutionValue", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextStringSimpleNode.kt */
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private ParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private int overflow;
    /* access modifiers changed from: private */
    public ColorProducer overrideColor;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    /* access modifiers changed from: private */
    public TextStyle style;
    private String text;
    private final MutableState textSubstitution$delegate;

    public /* synthetic */ TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i, z, i2, i3, colorProducer);
    }

    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStringSimpleNode(java.lang.String r13, androidx.compose.ui.text.TextStyle r14, androidx.compose.ui.text.font.FontFamily.Resolver r15, int r16, boolean r17, int r18, int r19, androidx.compose.ui.graphics.ColorProducer r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 8
            if (r1 == 0) goto L_0x000e
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m6511getClipgIe3tQ8()
            r6 = r1
            goto L_0x0010
        L_0x000e:
            r6 = r16
        L_0x0010:
            r1 = r0 & 16
            r2 = 1
            if (r1 == 0) goto L_0x0017
            r7 = r2
            goto L_0x0019
        L_0x0017:
            r7 = r17
        L_0x0019:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0022
            r1 = 2147483647(0x7fffffff, float:NaN)
            r8 = r1
            goto L_0x0024
        L_0x0022:
            r8 = r18
        L_0x0024:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002a
            r9 = r2
            goto L_0x002c
        L_0x002a:
            r9 = r19
        L_0x002c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            r10 = r0
            goto L_0x0035
        L_0x0033:
            r10 = r20
        L_0x0035:
            r11 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextStringSimpleNode.<init>(java.lang.String, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontFamily$Resolver, int, boolean, int, int, androidx.compose.ui.graphics.ColorProducer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, ColorProducer colorProducer) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.overrideColor = colorProducer;
        this.textSubstitution$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, (DefaultConstructorMarker) null);
        }
        ParagraphLayoutCache paragraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(paragraphLayoutCache);
        return paragraphLayoutCache;
    }

    private final ParagraphLayoutCache getLayoutCache(Density density) {
        ParagraphLayoutCache layoutCache;
        TextSubstitutionValue textSubstitution = getTextSubstitution();
        if (textSubstitution == null || !textSubstitution.isShowingSubstitution() || (layoutCache = textSubstitution.getLayoutCache()) == null) {
            ParagraphLayoutCache layoutCache2 = getLayoutCache();
            layoutCache2.setDensity$foundation_release(density);
            return layoutCache2;
        }
        layoutCache.setDensity$foundation_release(density);
        return layoutCache;
    }

    public final boolean updateDraw(ColorProducer colorProducer, TextStyle textStyle) {
        boolean z = !Intrinsics.areEqual((Object) colorProducer, (Object) this.overrideColor);
        this.overrideColor = colorProducer;
        if (z || !textStyle.hasSameDrawAffectingAttributes(this.style)) {
            return true;
        }
        return false;
    }

    public final boolean updateText(String str) {
        if (Intrinsics.areEqual((Object) this.text, (Object) str)) {
            return false;
        }
        this.text = str;
        clearSubstitution();
        return true;
    }

    /* renamed from: updateLayoutRelatedArgs-HuAbxIM  reason: not valid java name */
    public final boolean m1206updateLayoutRelatedArgsHuAbxIM(TextStyle textStyle, int i, int i2, boolean z, FontFamily.Resolver resolver, int i3) {
        boolean z2 = !this.style.hasSameLayoutAffectingAttributes(textStyle);
        this.style = textStyle;
        if (this.minLines != i) {
            this.minLines = i;
            z2 = true;
        }
        if (this.maxLines != i2) {
            this.maxLines = i2;
            z2 = true;
        }
        if (this.softWrap != z) {
            this.softWrap = z;
            z2 = true;
        }
        if (!Intrinsics.areEqual((Object) this.fontFamilyResolver, (Object) resolver)) {
            this.fontFamilyResolver = resolver;
            z2 = true;
        }
        if (TextOverflow.m6504equalsimpl0(this.overflow, i3)) {
            return z2;
        }
        this.overflow = i3;
        return true;
    }

    public final void doInvalidations(boolean z, boolean z2, boolean z3) {
        if (isAttached()) {
            if (z2 || (z && this.semanticsTextLayoutResult != null)) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }
            if (z2 || z3) {
                getLayoutCache().m1189updateL6sJoHM(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
                LayoutModifierNodeKt.invalidateMeasurement(this);
                DrawModifierNodeKt.invalidateDraw(this);
            }
            if (z) {
                DrawModifierNodeKt.invalidateDraw(this);
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "", "original", "", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "getOriginal", "()Ljava/lang/String;", "getSubstitution", "setSubstitution", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextStringSimpleNode.kt */
    public static final class TextSubstitutionValue {
        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private ParagraphLayoutCache layoutCache;
        private final String original;
        private String substitution;

        public static /* synthetic */ TextSubstitutionValue copy$default(TextSubstitutionValue textSubstitutionValue, String str, String str2, boolean z, ParagraphLayoutCache paragraphLayoutCache, int i, Object obj) {
            if ((i & 1) != 0) {
                str = textSubstitutionValue.original;
            }
            if ((i & 2) != 0) {
                str2 = textSubstitutionValue.substitution;
            }
            if ((i & 4) != 0) {
                z = textSubstitutionValue.isShowingSubstitution;
            }
            if ((i & 8) != 0) {
                paragraphLayoutCache = textSubstitutionValue.layoutCache;
            }
            return textSubstitutionValue.copy(str, str2, z, paragraphLayoutCache);
        }

        public final String component1() {
            return this.original;
        }

        public final String component2() {
            return this.substitution;
        }

        public final boolean component3() {
            return this.isShowingSubstitution;
        }

        public final ParagraphLayoutCache component4() {
            return this.layoutCache;
        }

        public final TextSubstitutionValue copy(String str, String str2, boolean z, ParagraphLayoutCache paragraphLayoutCache) {
            return new TextSubstitutionValue(str, str2, z, paragraphLayoutCache);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) obj;
            return Intrinsics.areEqual((Object) this.original, (Object) textSubstitutionValue.original) && Intrinsics.areEqual((Object) this.substitution, (Object) textSubstitutionValue.substitution) && this.isShowingSubstitution == textSubstitutionValue.isShowingSubstitution && Intrinsics.areEqual((Object) this.layoutCache, (Object) textSubstitutionValue.layoutCache);
        }

        public int hashCode() {
            int hashCode = ((((this.original.hashCode() * 31) + this.substitution.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isShowingSubstitution)) * 31;
            ParagraphLayoutCache paragraphLayoutCache = this.layoutCache;
            return hashCode + (paragraphLayoutCache == null ? 0 : paragraphLayoutCache.hashCode());
        }

        public String toString() {
            return "TextSubstitutionValue(original=" + this.original + ", substitution=" + this.substitution + ", isShowingSubstitution=" + this.isShowingSubstitution + ", layoutCache=" + this.layoutCache + ')';
        }

        public TextSubstitutionValue(String str, String str2, boolean z, ParagraphLayoutCache paragraphLayoutCache) {
            this.original = str;
            this.substitution = str2;
            this.isShowingSubstitution = z;
            this.layoutCache = paragraphLayoutCache;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TextSubstitutionValue(String str, String str2, boolean z, ParagraphLayoutCache paragraphLayoutCache, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : paragraphLayoutCache);
        }

        public final String getOriginal() {
            return this.original;
        }

        public final String getSubstitution() {
            return this.substitution;
        }

        public final void setSubstitution(String str) {
            this.substitution = str;
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setShowingSubstitution(boolean z) {
            this.isShowingSubstitution = z;
        }

        public final ParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final void setLayoutCache(ParagraphLayoutCache paragraphLayoutCache) {
            this.layoutCache = paragraphLayoutCache;
        }
    }

    /* access modifiers changed from: private */
    public final TextSubstitutionValue getTextSubstitution() {
        return (TextSubstitutionValue) this.textSubstitution$delegate.getValue();
    }

    private final void setTextSubstitution(TextSubstitutionValue textSubstitutionValue) {
        this.textSubstitution$delegate.setValue(textSubstitutionValue);
    }

    /* access modifiers changed from: private */
    public final boolean setSubstitution(String str) {
        Unit unit;
        TextSubstitutionValue textSubstitution = getTextSubstitution();
        if (textSubstitution == null) {
            TextSubstitutionValue textSubstitutionValue = new TextSubstitutionValue(this.text, str, false, (ParagraphLayoutCache) null, 12, (DefaultConstructorMarker) null);
            ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(str, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, (DefaultConstructorMarker) null);
            paragraphLayoutCache.setDensity$foundation_release(getLayoutCache().getDensity$foundation_release());
            textSubstitutionValue.setLayoutCache(paragraphLayoutCache);
            setTextSubstitution(textSubstitutionValue);
            return true;
        } else if (Intrinsics.areEqual((Object) str, (Object) textSubstitution.getSubstitution())) {
            return false;
        } else {
            textSubstitution.setSubstitution(str);
            ParagraphLayoutCache layoutCache = textSubstitution.getLayoutCache();
            if (layoutCache != null) {
                layoutCache.m1189updateL6sJoHM(str, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final void clearSubstitution() {
        setTextSubstitution((TextSubstitutionValue) null);
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Function1<? super List<TextLayoutResult>, Boolean> function1 = this.semanticsTextLayoutResult;
        if (function1 == null) {
            function1 = new TextStringSimpleNode$applySemantics$1(this);
            this.semanticsTextLayoutResult = function1;
        }
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(this.text, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
        TextSubstitutionValue textSubstitution = getTextSubstitution();
        if (textSubstitution != null) {
            SemanticsPropertiesKt.setShowingTextSubstitution(semanticsPropertyReceiver, textSubstitution.isShowingSubstitution());
            SemanticsPropertiesKt.setTextSubstitution(semanticsPropertyReceiver, new AnnotatedString(textSubstitution.getSubstitution(), (List) null, (List) null, 6, (DefaultConstructorMarker) null));
        }
        SemanticsPropertiesKt.setTextSubstitution$default(semanticsPropertyReceiver, (String) null, new TextStringSimpleNode$applySemantics$2(this), 1, (Object) null);
        SemanticsPropertiesKt.showTextSubstitution$default(semanticsPropertyReceiver, (String) null, new TextStringSimpleNode$applySemantics$3(this), 1, (Object) null);
        SemanticsPropertiesKt.clearTextSubstitution$default(semanticsPropertyReceiver, (String) null, new TextStringSimpleNode$applySemantics$4(this), 1, (Object) null);
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, (String) null, function1, 1, (Object) null);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1205measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ParagraphLayoutCache layoutCache = getLayoutCache(measureScope);
        boolean r7 = layoutCache.m1187layoutWithConstraintsK40F9xA(j, measureScope.getLayoutDirection());
        layoutCache.getObserveFontChanges$foundation_release();
        Paragraph paragraph$foundation_release = layoutCache.getParagraph$foundation_release();
        Intrinsics.checkNotNull(paragraph$foundation_release);
        long r0 = layoutCache.m1186getLayoutSizeYbymL2g$foundation_release();
        if (r7) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Map<AlignmentLine, Integer> map = this.baselineCache;
            if (map == null) {
                map = new LinkedHashMap<>(2);
            }
            map.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(paragraph$foundation_release.getFirstBaseline())));
            map.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(paragraph$foundation_release.getLastBaseline())));
            this.baselineCache = map;
        }
        Placeable r6 = measurable.m5368measureBRTryo0(LayoutUtilsKt.fixedCoerceHeightAndWidthForBits(Constraints.Companion, IntSize.m6790getWidthimpl(r0), IntSize.m6789getHeightimpl(r0)));
        int r72 = IntSize.m6790getWidthimpl(r0);
        int r8 = IntSize.m6789getHeightimpl(r0);
        Map<AlignmentLine, Integer> map2 = this.baselineCache;
        Intrinsics.checkNotNull(map2);
        return measureScope.layout(r72, r8, map2, new TextStringSimpleNode$measure$1(r6));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).minIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).maxIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    public void draw(ContentDrawScope contentDrawScope) {
        if (isAttached()) {
            Paragraph paragraph$foundation_release = getLayoutCache().getParagraph$foundation_release();
            if (paragraph$foundation_release != null) {
                Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
                boolean didOverflow$foundation_release = getLayoutCache().getDidOverflow$foundation_release();
                if (didOverflow$foundation_release) {
                    Rect r2 = RectKt.m3602Recttz77jQw(Offset.Companion.m3578getZeroF1C5BW0(), SizeKt.Size((float) IntSize.m6790getWidthimpl(getLayoutCache().m1186getLayoutSizeYbymL2g$foundation_release()), (float) IntSize.m6789getHeightimpl(getLayoutCache().m1186getLayoutSizeYbymL2g$foundation_release())));
                    canvas.save();
                    Canvas.CC.m3790clipRectmtrdDE$default(canvas, r2, 0, 2, (Object) null);
                }
                try {
                    TextDecoration textDecoration = this.style.getTextDecoration();
                    if (textDecoration == null) {
                        textDecoration = TextDecoration.Companion.getNone();
                    }
                    TextDecoration textDecoration2 = textDecoration;
                    Shadow shadow = this.style.getShadow();
                    if (shadow == null) {
                        shadow = Shadow.Companion.getNone();
                    }
                    Shadow shadow2 = shadow;
                    DrawStyle drawStyle = this.style.getDrawStyle();
                    if (drawStyle == null) {
                        drawStyle = Fill.INSTANCE;
                    }
                    DrawStyle drawStyle2 = drawStyle;
                    Brush brush = this.style.getBrush();
                    if (brush != null) {
                        Paragraph.CC.m5927painthn5TExg$default(paragraph$foundation_release, canvas, brush, this.style.getAlpha(), shadow2, textDecoration2, drawStyle2, 0, 64, (Object) null);
                    } else {
                        ColorProducer colorProducer = this.overrideColor;
                        long r22 = colorProducer != null ? colorProducer.m3897invoke0d7_KjU() : Color.Companion.m3852getUnspecified0d7_KjU();
                        if (r22 == Color.Companion.m3852getUnspecified0d7_KjU()) {
                            if (this.style.m6072getColor0d7_KjU() != Color.Companion.m3852getUnspecified0d7_KjU()) {
                                r22 = this.style.m6072getColor0d7_KjU();
                            } else {
                                r22 = Color.Companion.m3842getBlack0d7_KjU();
                            }
                        }
                        Paragraph.CC.m5925paintLG529CI$default(paragraph$foundation_release, canvas, r22, shadow2, textDecoration2, drawStyle2, 0, 32, (Object) null);
                    }
                } finally {
                    if (didOverflow$foundation_release) {
                        canvas.restore();
                    }
                }
            } else {
                throw new IllegalArgumentException("no paragraph".toString());
            }
        }
    }
}
