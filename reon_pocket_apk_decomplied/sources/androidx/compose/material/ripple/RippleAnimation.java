package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010#\u001a\u00020\u0019H@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u0019H@¢\u0006\u0002\u0010$J\u000e\u0010&\u001a\u00020\u0019H@¢\u0006\u0002\u0010$J\u0006\u0010'\u001a\u00020\u0019J\u001c\u0010(\u001a\u00020\u0019*\u00020)2\u0006\u0010*\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b,\u0010-R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\u0003X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010 \u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ripple/RippleAnimation;", "", "origin", "Landroidx/compose/ui/geometry/Offset;", "radius", "Landroidx/compose/ui/unit/Dp;", "bounded", "", "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedCenterPercent", "animatedRadiusPercent", "<set-?>", "finishRequested", "getFinishRequested", "()Z", "setFinishRequested", "(Z)V", "finishRequested$delegate", "Landroidx/compose/runtime/MutableState;", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "finishedFadingIn", "getFinishedFadingIn", "setFinishedFadingIn", "finishedFadingIn$delegate", "F", "startRadius", "Ljava/lang/Float;", "targetCenter", "targetRadius", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RippleAnimation.kt */
public final class RippleAnimation {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> animatedAlpha;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> animatedCenterPercent;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;
    private final MutableState finishRequested$delegate;
    private final CompletableDeferred<Unit> finishSignalDeferred;
    private final MutableState finishedFadingIn$delegate;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;
    private Float targetRadius;

    public /* synthetic */ RippleAnimation(Offset offset, float f, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(offset, f, z);
    }

    private RippleAnimation(Offset offset, float f, boolean z) {
        this.origin = offset;
        this.radius = f;
        this.bounded = z;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred((Job) null);
        this.finishedFadingIn$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.finishRequested$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final boolean getFinishedFadingIn() {
        return ((Boolean) this.finishedFadingIn$delegate.getValue()).booleanValue();
    }

    private final void setFinishedFadingIn(boolean z) {
        this.finishedFadingIn$delegate.setValue(Boolean.valueOf(z));
    }

    private final boolean getFinishRequested() {
        return ((Boolean) this.finishRequested$delegate.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z) {
        this.finishRequested$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animate(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.material.ripple.RippleAnimation$animate$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation$animate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0073
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0038:
            java.lang.Object r2 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0067
        L_0x0040:
            java.lang.Object r2 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0057
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.fadeIn(r0)
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r2 = r6
        L_0x0057:
            r2.setFinishedFadingIn(r5)
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r7 = r2.finishSignalDeferred
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r2.fadeOut(r0)
            if (r7 != r1) goto L_0x0073
            return r1
        L_0x0073:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.animate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object fadeIn(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeIn$2(this, (Continuation<? super RippleAnimation$fadeIn$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object fadeOut(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeOut$2(this, (Continuation<? super RippleAnimation$fadeOut$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }

    /* renamed from: draw-4WTKRHQ  reason: not valid java name */
    public final void m1484draw4WTKRHQ(DrawScope drawScope, long j) {
        float f;
        Float f2;
        DrawScope drawScope2 = drawScope;
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m1486getRippleStartRadiusuvyYCjk(drawScope.m4434getSizeNHjbRc()));
        }
        if (this.targetRadius == null) {
            if (Float.isNaN(this.radius)) {
                f2 = Float.valueOf(RippleAnimationKt.m1485getRippleEndRadiuscSwnlzA(drawScope2, this.bounded, drawScope.m4434getSizeNHjbRc()));
            } else {
                f2 = Float.valueOf(drawScope2.m6550toPx0680j_4(this.radius));
            }
            this.targetRadius = f2;
        }
        if (this.origin == null) {
            this.origin = Offset.m3551boximpl(drawScope.m4433getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m3551boximpl(OffsetKt.Offset(Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc()) / 2.0f, Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc()) / 2.0f));
        }
        if (!getFinishRequested() || getFinishedFadingIn()) {
            f = this.animatedAlpha.getValue().floatValue();
        } else {
            f = 1.0f;
        }
        Float f3 = this.startRadius;
        Intrinsics.checkNotNull(f3);
        float floatValue = f3.floatValue();
        Float f4 = this.targetRadius;
        Intrinsics.checkNotNull(f4);
        float lerp = MathHelpersKt.lerp(floatValue, f4.floatValue(), this.animatedRadiusPercent.getValue().floatValue());
        Offset offset = this.origin;
        Intrinsics.checkNotNull(offset);
        float r3 = Offset.m3562getXimpl(offset.m3572unboximpl());
        Offset offset2 = this.targetCenter;
        Intrinsics.checkNotNull(offset2);
        float lerp2 = MathHelpersKt.lerp(r3, Offset.m3562getXimpl(offset2.m3572unboximpl()), this.animatedCenterPercent.getValue().floatValue());
        Offset offset3 = this.origin;
        Intrinsics.checkNotNull(offset3);
        float r5 = Offset.m3563getYimpl(offset3.m3572unboximpl());
        Offset offset4 = this.targetCenter;
        Intrinsics.checkNotNull(offset4);
        long Offset = OffsetKt.Offset(lerp2, MathHelpersKt.lerp(r5, Offset.m3563getYimpl(offset4.m3572unboximpl()), this.animatedCenterPercent.getValue().floatValue()));
        long r2 = Color.m3815copywmQWz5c$default(j, Color.m3818getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        if (this.bounded) {
            float r12 = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc());
            float r13 = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc());
            int r14 = ClipOp.Companion.m3805getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long r7 = drawContext.m4412getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m4523clipRectN_I0leg(0.0f, 0.0f, r12, r13, r14);
            DrawScope.CC.m4457drawCircleVaOC9Bg$default(drawScope, r2, lerp, Offset, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
            drawContext.getCanvas().restore();
            drawContext.m4413setSizeuvyYCjk(r7);
            return;
        }
        DrawScope.CC.m4457drawCircleVaOC9Bg$default(drawScope, r2, lerp, Offset, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
    }
}
