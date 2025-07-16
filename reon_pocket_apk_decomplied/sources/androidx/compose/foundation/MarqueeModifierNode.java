package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020;H\u0002J\u000e\u0010A\u001a\u00020;H@¢\u0006\u0002\u0010BJ@\u0010C\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\f\u0010F\u001a\u00020;*\u00020GH\u0016J\u001c\u0010H\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0006H\u0016J\u001c\u0010M\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0006H\u0016J&\u0010O\u001a\u00020P*\u00020Q2\u0006\u0010J\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001c\u0010W\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0006H\u0016J\u001c\u0010X\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0006H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R1\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b8F@FX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R+\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R+\u0010'\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020&8B@BX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00105\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b6\u0010\u0014R\u0016\u0010\r\u001a\u00020\u000eX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00109\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/MarqueeModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animationJob", "Lkotlinx/coroutines/Job;", "<set-?>", "getAnimationMode-ZbEOnfQ", "()I", "setAnimationMode-97h66l8", "(I)V", "animationMode$delegate", "Landroidx/compose/runtime/MutableState;", "containerWidth", "getContainerWidth", "setContainerWidth", "containerWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "contentWidth", "getContentWidth", "setContentWidth", "contentWidth$delegate", "direction", "", "getDirection", "()F", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "offset", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "spacing$delegate", "spacingPx", "getSpacingPx", "spacingPx$delegate", "Landroidx/compose/runtime/State;", "F", "onAttach", "", "onDetach", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "restartAnimation", "runAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "update-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)V", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicMarquee.kt */
final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {
    private Job animationJob;
    private final MutableState animationMode$delegate;
    private final MutableIntState containerWidth$delegate;
    private final MutableIntState contentWidth$delegate;
    /* access modifiers changed from: private */
    public int delayMillis;
    private final MutableState hasFocus$delegate;
    /* access modifiers changed from: private */
    public int initialDelayMillis;
    /* access modifiers changed from: private */
    public int iterations;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> offset;
    private final MutableState spacing$delegate;
    private final State spacingPx$delegate;
    /* access modifiers changed from: private */
    public float velocity;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BasicMarquee.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.compose.ui.unit.LayoutDirection[] r0 = androidx.compose.ui.unit.LayoutDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Ltr     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Rtl     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifierNode.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ MarqueeModifierNode(int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, marqueeSpacing, f);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return 0;
    }

    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    private MarqueeModifierNode(int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f) {
        this.iterations = i;
        this.delayMillis = i3;
        this.initialDelayMillis = i4;
        this.velocity = f;
        this.contentWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.containerWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.spacing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(marqueeSpacing, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animationMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.m290boximpl(i2), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.offset = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.spacingPx$delegate = SnapshotStateKt.derivedStateOf(new MarqueeModifierNode$spacingPx$2(marqueeSpacing, this));
    }

    /* access modifiers changed from: private */
    public final int getContentWidth() {
        return this.contentWidth$delegate.getIntValue();
    }

    private final void setContentWidth(int i) {
        this.contentWidth$delegate.setIntValue(i);
    }

    /* access modifiers changed from: private */
    public final int getContainerWidth() {
        return this.containerWidth$delegate.getIntValue();
    }

    private final void setContainerWidth(int i) {
        this.containerWidth$delegate.setIntValue(i);
    }

    /* access modifiers changed from: private */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    private final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final MarqueeSpacing getSpacing() {
        return (MarqueeSpacing) this.spacing$delegate.getValue();
    }

    public final void setSpacing(MarqueeSpacing marqueeSpacing) {
        this.spacing$delegate.setValue(marqueeSpacing);
    }

    /* renamed from: getAnimationMode-ZbEOnfQ  reason: not valid java name */
    public final int m305getAnimationModeZbEOnfQ() {
        return ((MarqueeAnimationMode) this.animationMode$delegate.getValue()).m296unboximpl();
    }

    /* renamed from: setAnimationMode-97h66l8  reason: not valid java name */
    public final void m307setAnimationMode97h66l8(int i) {
        this.animationMode$delegate.setValue(MarqueeAnimationMode.m290boximpl(i));
    }

    /* access modifiers changed from: private */
    public final float getDirection() {
        float signum = Math.signum(this.velocity);
        int i = WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()];
        int i2 = 1;
        if (i != 1) {
            if (i == 2) {
                i2 = -1;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return signum * ((float) i2);
    }

    /* access modifiers changed from: private */
    public final int getSpacingPx() {
        return ((Number) this.spacingPx$delegate.getValue()).intValue();
    }

    public void onAttach() {
        restartAnimation();
    }

    public void onDetach() {
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
    }

    /* renamed from: update-lWfNwf4  reason: not valid java name */
    public final void m308updatelWfNwf4(int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f) {
        setSpacing(marqueeSpacing);
        m307setAnimationMode97h66l8(i2);
        if (this.iterations != i || this.delayMillis != i3 || this.initialDelayMillis != i4 || !Dp.m6619equalsimpl0(this.velocity, f)) {
            this.iterations = i;
            this.delayMillis = i3;
            this.initialDelayMillis = i4;
            this.velocity = f;
            restartAnimation();
        }
    }

    public void onFocusEvent(FocusState focusState) {
        setHasFocus(focusState.getHasFocus());
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m306measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r10 = measurable.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, (Object) null));
        setContainerWidth(ConstraintsKt.m6540constrainWidthK40F9xA(j, r10.getWidth()));
        setContentWidth(r10.getWidth());
        return MeasureScope.CC.layout$default(measureScope, getContainerWidth(), r10.getHeight(), (Map) null, new MarqueeModifierNode$measure$1(r10, this), 4, (Object) null);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        int i;
        float floatValue = this.offset.getValue().floatValue() * getDirection();
        boolean z = getDirection() != 1.0f ? this.offset.getValue().floatValue() < ((float) getContainerWidth()) : this.offset.getValue().floatValue() < ((float) getContentWidth());
        boolean z2 = getDirection() != 1.0f ? this.offset.getValue().floatValue() > ((float) getSpacingPx()) : this.offset.getValue().floatValue() > ((float) ((getContentWidth() + getSpacingPx()) - getContainerWidth()));
        if (getDirection() == 1.0f) {
            i = getContentWidth() + getSpacingPx();
        } else {
            i = (-getContentWidth()) - getSpacingPx();
        }
        float f = (float) i;
        DrawScope drawScope = contentDrawScope;
        float containerWidth = floatValue + ((float) getContainerWidth());
        float r6 = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc());
        int r7 = ClipOp.Companion.m3805getIntersectrtfAjoo();
        DrawContext drawContext = drawScope.getDrawContext();
        long r11 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4523clipRectN_I0leg(floatValue, 0.0f, containerWidth, r6, r7);
        if (z) {
            contentDrawScope.drawContent();
        }
        if (z2) {
            drawScope.getDrawContext().getTransform().translate(f, 0.0f);
            contentDrawScope.drawContent();
            drawScope.getDrawContext().getTransform().translate(-f, -0.0f);
        }
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r11);
    }

    private final void restartAnimation() {
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (isAttached()) {
            this.animationJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new MarqueeModifierNode$restartAnimation$1(job, this, (Continuation<? super MarqueeModifierNode$restartAnimation$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Object runAnimation(Continuation<? super Unit> continuation) {
        if (this.iterations <= 0) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new MarqueeModifierNode$runAnimation$2(this, (Continuation<? super MarqueeModifierNode$runAnimation$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
