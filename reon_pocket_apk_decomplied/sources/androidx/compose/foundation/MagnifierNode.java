package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0001\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u0012\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\b\u0010J\u001a\u00020\u000fH\u0016J\b\u0010K\u001a\u00020\u000fH\u0016J\u0010\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016J\b\u0010P\u001a\u00020\u000fH\u0002J\u0001\u0010Q\u001a\u00020\u000f2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b2\u0019\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00132\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\b\u0010T\u001a\u00020\u000fH\u0002J\b\u0010U\u001a\u00020\u000fH\u0002J\f\u0010V\u001a\u00020\u000f*\u00020WH\u0016J\f\u0010X\u001a\u00020\u000f*\u00020YH\u0016R1\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n8B@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u0015\u001a\u00020\u0016X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u00020\u0016X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R-\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u0004\u0018\u00010=X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u00020\u000eX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R+\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00103\"\u0004\bB\u00105R\u0016\u0010C\u001a\u00020\nX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010@R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "()J", "setAnchorPositionInRoot-k-4lQ0M", "(J)V", "anchorPositionInRoot$delegate", "Landroidx/compose/runtime/MutableState;", "getClippingEnabled", "()Z", "setClippingEnabled", "(Z)V", "getCornerRadius-D9Ej5fM", "()F", "setCornerRadius-0680j_4", "(F)V", "F", "density", "getElevation-D9Ej5fM", "setElevation-0680j_4", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "getMagnifierCenter", "()Lkotlin/jvm/functions/Function1;", "setMagnifierCenter", "(Lkotlin/jvm/functions/Function1;)V", "getOnSizeChanged", "setOnSizeChanged", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "getSize-MYxV2XQ", "setSize-EaSLcWc", "J", "getSourceCenter", "setSourceCenter", "sourceCenterInRoot", "getUseTextDefault", "setUseTextDefault", "view", "Landroid/view/View;", "getZoom", "setZoom", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onObservedReadsChanged", "recreateMagnifier", "update", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "updateMagnifier", "updateSizeIfNecessary", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.android.kt */
public final class MagnifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private final MutableState anchorPositionInRoot$delegate;
    private boolean clippingEnabled;
    private float cornerRadius;
    /* access modifiers changed from: private */
    public Density density;
    private float elevation;
    /* access modifiers changed from: private */
    public PlatformMagnifier magnifier;
    private Function1<? super Density, Offset> magnifierCenter;
    private Function1<? super DpSize, Unit> onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1<? super Density, Offset> sourceCenter;
    /* access modifiers changed from: private */
    public long sourceCenterInRoot;
    private boolean useTextDefault;
    /* access modifiers changed from: private */
    public View view;
    private float zoom;

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f, z, j, f2, f3, z2, platformMagnifierFactory2);
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

    public final Function1<Density, Offset> getSourceCenter() {
        return this.sourceCenter;
    }

    public final void setSourceCenter(Function1<? super Density, Offset> function1) {
        this.sourceCenter = function1;
    }

    public final Function1<Density, Offset> getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final void setMagnifierCenter(Function1<? super Density, Offset> function1) {
        this.magnifierCenter = function1;
    }

    public final Function1<DpSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public final void setOnSizeChanged(Function1<? super DpSize, Unit> function1) {
        this.onSizeChanged = function1;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final void setUseTextDefault(boolean z) {
        this.useTextDefault = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MagnifierNode(kotlin.jvm.functions.Function1 r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function1 r19, float r20, boolean r21, long r22, float r24, float r25, boolean r26, androidx.compose.foundation.PlatformMagnifierFactory r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r16 = this;
            r0 = r28
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r18
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r19
        L_0x0013:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001b
            r1 = 2143289344(0x7fc00000, float:NaN)
            r7 = r1
            goto L_0x001d
        L_0x001b:
            r7 = r20
        L_0x001d:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0024
            r1 = 0
            r8 = r1
            goto L_0x0026
        L_0x0024:
            r8 = r21
        L_0x0026:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0032
            androidx.compose.ui.unit.DpSize$Companion r1 = androidx.compose.ui.unit.DpSize.Companion
            long r1 = r1.m6721getUnspecifiedMYxV2XQ()
            r9 = r1
            goto L_0x0034
        L_0x0032:
            r9 = r22
        L_0x0034:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0040
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            float r1 = r1.m6634getUnspecifiedD9Ej5fM()
            r11 = r1
            goto L_0x0042
        L_0x0040:
            r11 = r24
        L_0x0042:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            float r1 = r1.m6634getUnspecifiedD9Ej5fM()
            r12 = r1
            goto L_0x0050
        L_0x004e:
            r12 = r25
        L_0x0050:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0057
            r1 = 1
            r13 = r1
            goto L_0x0059
        L_0x0057:
            r13 = r26
        L_0x0059:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0065
            androidx.compose.foundation.PlatformMagnifierFactory$Companion r0 = androidx.compose.foundation.PlatformMagnifierFactory.Companion
            androidx.compose.foundation.PlatformMagnifierFactory r0 = r0.getForCurrentPlatform()
            r14 = r0
            goto L_0x0067
        L_0x0065:
            r14 = r27
        L_0x0067:
            r15 = 0
            r3 = r16
            r4 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.<init>(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, boolean, long, float, float, boolean, androidx.compose.foundation.PlatformMagnifierFactory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getSize-MYxV2XQ  reason: not valid java name */
    public final long m280getSizeMYxV2XQ() {
        return this.size;
    }

    /* renamed from: setSize-EaSLcWc  reason: not valid java name */
    public final void m283setSizeEaSLcWc(long j) {
        this.size = j;
    }

    /* renamed from: getCornerRadius-D9Ej5fM  reason: not valid java name */
    public final float m278getCornerRadiusD9Ej5fM() {
        return this.cornerRadius;
    }

    /* renamed from: setCornerRadius-0680j_4  reason: not valid java name */
    public final void m281setCornerRadius0680j_4(float f) {
        this.cornerRadius = f;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m279getElevationD9Ej5fM() {
        return this.elevation;
    }

    /* renamed from: setElevation-0680j_4  reason: not valid java name */
    public final void m282setElevation0680j_4(float f) {
        this.elevation = f;
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final void setClippingEnabled(boolean z) {
        this.clippingEnabled = z;
    }

    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    public final void setPlatformMagnifierFactory(PlatformMagnifierFactory platformMagnifierFactory2) {
        this.platformMagnifierFactory = platformMagnifierFactory2;
    }

    private MagnifierNode(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory2) {
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.onSizeChanged = function13;
        this.zoom = f;
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f2;
        this.elevation = f3;
        this.clippingEnabled = z2;
        this.platformMagnifierFactory = platformMagnifierFactory2;
        this.anchorPositionInRoot$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3551boximpl(Offset.Companion.m3577getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.sourceCenterInRoot = Offset.Companion.m3577getUnspecifiedF1C5BW0();
    }

    /* renamed from: getAnchorPositionInRoot-F1C5BW0  reason: not valid java name */
    private final long m276getAnchorPositionInRootF1C5BW0() {
        return ((Offset) this.anchorPositionInRoot$delegate.getValue()).m3572unboximpl();
    }

    /* renamed from: setAnchorPositionInRoot-k-4lQ0M  reason: not valid java name */
    private final void m277setAnchorPositionInRootk4lQ0M(long j) {
        this.anchorPositionInRoot$delegate.setValue(Offset.m3551boximpl(j));
    }

    /* renamed from: update-5F03MCQ  reason: not valid java name */
    public final void m284update5F03MCQ(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, boolean z, long j, float f2, float f3, boolean z2, Function1<? super DpSize, Unit> function13, PlatformMagnifierFactory platformMagnifierFactory2) {
        float f4 = f;
        long j2 = j;
        float f5 = f2;
        float f6 = f3;
        boolean z3 = z2;
        PlatformMagnifierFactory platformMagnifierFactory3 = platformMagnifierFactory2;
        float f7 = this.zoom;
        long j3 = this.size;
        float f8 = this.cornerRadius;
        float f9 = this.elevation;
        boolean z4 = this.clippingEnabled;
        PlatformMagnifierFactory platformMagnifierFactory4 = this.platformMagnifierFactory;
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.zoom = f4;
        this.useTextDefault = z;
        this.size = j2;
        this.cornerRadius = f5;
        this.elevation = f6;
        this.clippingEnabled = z3;
        this.onSizeChanged = function13;
        this.platformMagnifierFactory = platformMagnifierFactory3;
        if (this.magnifier == null || ((f4 != f7 && !platformMagnifierFactory2.getCanUpdateZoom()) || !DpSize.m6709equalsimpl0(j2, j3) || !Dp.m6619equalsimpl0(f5, f8) || !Dp.m6619equalsimpl0(f6, f9) || z3 != z4 || !Intrinsics.areEqual((Object) platformMagnifierFactory3, (Object) platformMagnifierFactory4))) {
            recreateMagnifier();
        }
        updateMagnifier();
    }

    public void onAttach() {
        onObservedReadsChanged();
    }

    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.magnifier = null;
    }

    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new MagnifierNode$onObservedReadsChanged$1(this));
    }

    /* access modifiers changed from: private */
    public final void recreateMagnifier() {
        Density density2;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View view2 = this.view;
        if (view2 != null && (density2 = this.density) != null) {
            this.magnifier = this.platformMagnifierFactory.m316createnHHXs2Y(view2, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density2, this.zoom);
            updateSizeIfNecessary();
        }
    }

    /* access modifiers changed from: private */
    public final void updateMagnifier() {
        Density density2;
        long j;
        long j2;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null && (density2 = this.density) != null) {
            long r2 = this.sourceCenter.invoke(density2).m3572unboximpl();
            if (!OffsetKt.m3581isSpecifiedk4lQ0M(m276getAnchorPositionInRootF1C5BW0()) || !OffsetKt.m3581isSpecifiedk4lQ0M(r2)) {
                j = Offset.Companion.m3577getUnspecifiedF1C5BW0();
            } else {
                j = Offset.m3567plusMKHz9U(m276getAnchorPositionInRootF1C5BW0(), r2);
            }
            this.sourceCenterInRoot = j;
            if (OffsetKt.m3581isSpecifiedk4lQ0M(j)) {
                Function1<? super Density, Offset> function1 = this.magnifierCenter;
                if (function1 != null) {
                    Offset r1 = Offset.m3551boximpl(function1.invoke(density2).m3572unboximpl());
                    if (!OffsetKt.m3581isSpecifiedk4lQ0M(r1.m3572unboximpl())) {
                        r1 = null;
                    }
                    if (r1 != null) {
                        j2 = Offset.m3567plusMKHz9U(m276getAnchorPositionInRootF1C5BW0(), r1.m3572unboximpl());
                        platformMagnifier.m315updateWko1d7g(this.sourceCenterInRoot, j2, this.zoom);
                        updateSizeIfNecessary();
                        return;
                    }
                }
                j2 = Offset.Companion.m3577getUnspecifiedF1C5BW0();
                platformMagnifier.m315updateWko1d7g(this.sourceCenterInRoot, j2, this.zoom);
                updateSizeIfNecessary();
                return;
            }
            platformMagnifier.dismiss();
        }
    }

    private final void updateSizeIfNecessary() {
        Density density2;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null && (density2 = this.density) != null && !IntSize.m6787equalsimpl(platformMagnifier.m314getSizeYbymL2g(), this.previousSize)) {
            Function1<? super DpSize, Unit> function1 = this.onSizeChanged;
            if (function1 != null) {
                function1.invoke(DpSize.m6700boximpl(density2.m6548toDpSizekrfVVM(IntSizeKt.m6800toSizeozmzZPI(platformMagnifier.m314getSizeYbymL2g()))));
            }
            this.previousSize = IntSize.m6782boximpl(platformMagnifier.m314getSizeYbymL2g());
        }
    }

    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new MagnifierNode$draw$1(this, (Continuation<? super MagnifierNode$draw$1>) null), 3, (Object) null);
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        m277setAnchorPositionInRootk4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new MagnifierNode$applySemantics$1(this));
    }
}
