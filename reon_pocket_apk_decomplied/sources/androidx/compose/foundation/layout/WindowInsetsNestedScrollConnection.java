package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J+\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u0004\u0018\u00010\rH@¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J#\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0004\b3\u00104J*\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\"\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0002J\"\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010HR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    /* access modifiers changed from: private */
    public WindowInsetsAnimationController animationController;
    /* access modifiers changed from: private */
    public Job animationJob;
    private final CancellationSignal cancellationSignal = new CancellationSignal();
    /* access modifiers changed from: private */
    public CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets androidWindowInsets, View view2, SideCalculator sideCalculator2, Density density2) {
        this.windowInsets = androidWindowInsets;
        this.view = view2;
        this.sideCalculator = sideCalculator2;
        this.density = density2;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public final View getView() {
        return this.view;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* access modifiers changed from: private */
    public final void requestAnimationController() {
        if (!this.isControllerRequested) {
            this.isControllerRequested = true;
            WindowInsetsController m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(this.view);
            if (m != null) {
                m.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1, (Interpolator) null, this.cancellationSignal, ComponentDialog$$ExternalSyntheticApiModelOutline0.m((Object) this));
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> continuation2) {
        Object obj = this.animationController;
        if (obj == null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
            cancellableContinuationImpl.initCancellability();
            this.continuation = cancellableContinuationImpl;
            requestAnimationController();
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation2);
            }
        }
        return obj;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m778onPreScrollOzD1aCk(long j, int i) {
        return m774scroll8S9VItk(j, this.sideCalculator.hideMotion(Offset.m3562getXimpl(j), Offset.m3563getYimpl(j)));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m776onPostScrollDzOQY0M(long j, long j2, int i) {
        return m774scroll8S9VItk(j2, this.sideCalculator.showMotion(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2)));
    }

    /* renamed from: scroll-8S9VItk  reason: not valid java name */
    private final long m774scroll8S9VItk(long j, float f) {
        Job job = this.animationJob;
        if (job != null) {
            job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
            this.animationJob = null;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (f != 0.0f) {
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (!(this.windowInsets.isVisible() == (i > 0) && windowInsetsAnimationController == null)) {
                if (windowInsetsAnimationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.m715consumedOffsetsMKHz9U(j);
                }
                int valueOf = this.sideCalculator.valueOf(windowInsetsAnimationController.getHiddenStateInsets());
                int valueOf2 = this.sideCalculator.valueOf(windowInsetsAnimationController.getShownStateInsets());
                Insets m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(windowInsetsAnimationController);
                int valueOf3 = this.sideCalculator.valueOf(m);
                if (valueOf3 == (i > 0 ? valueOf2 : valueOf)) {
                    this.partialConsumption = 0.0f;
                    return Offset.Companion.m3578getZeroF1C5BW0();
                }
                float f2 = ((float) valueOf3) + f + this.partialConsumption;
                int coerceIn = RangesKt.coerceIn(MathKt.roundToInt(f2), valueOf, valueOf2);
                this.partialConsumption = f2 - ((float) MathKt.roundToInt(f2));
                if (coerceIn != valueOf3) {
                    windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(m, coerceIn), 1.0f, 0.0f);
                }
                return this.sideCalculator.m715consumedOffsetsMKHz9U(j);
            }
        }
        return Offset.Companion.m3578getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m777onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation2) {
        return m773flinghuYlsQE(j, this.sideCalculator.hideMotion(Velocity.m6855getXimpl(j), Velocity.m6856getYimpl(j)), false, continuation2);
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m775onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation2) {
        return m773flinghuYlsQE(j2, this.sideCalculator.showMotion(Velocity.m6855getXimpl(j2), Velocity.m6856getYimpl(j2)), true, continuation2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* renamed from: fling-huYlsQE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m773flinghuYlsQE(long r26, float r28, boolean r29, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r30) {
        /*
            r25 = this;
            r0 = r25
            r1 = r28
            r2 = r29
            r3 = r30
            boolean r4 = r3 instanceof androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r4 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            r4.<init>(r0, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            if (r6 == 0) goto L_0x0064
            if (r6 == r10) goto L_0x0058
            if (r6 == r9) goto L_0x0049
            if (r6 != r8) goto L_0x0041
            long r1 = r4.J$0
            java.lang.Object r4 = r4.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r4
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0151
        L_0x0041:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0049:
            long r1 = r4.J$0
            java.lang.Object r5 = r4.L$1
            kotlin.jvm.internal.Ref$FloatRef r5 = (kotlin.jvm.internal.Ref.FloatRef) r5
            java.lang.Object r4 = r4.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r4
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x018f
        L_0x0058:
            float r1 = r4.F$0
            long r12 = r4.J$0
            java.lang.Object r2 = r4.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r2 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r2
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x00aa
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r3)
            kotlinx.coroutines.Job r3 = r0.animationJob
            if (r3 == 0) goto L_0x0075
            androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException r6 = new androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException
            r6.<init>()
            java.util.concurrent.CancellationException r6 = (java.util.concurrent.CancellationException) r6
            r3.cancel((java.util.concurrent.CancellationException) r6)
        L_0x0075:
            r0.animationJob = r7
            r0.partialConsumption = r11
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x007f
            if (r2 == 0) goto L_0x008b
        L_0x007f:
            android.view.WindowInsetsAnimationController r3 = r0.animationController
            if (r3 != 0) goto L_0x0096
            androidx.compose.foundation.layout.AndroidWindowInsets r3 = r0.windowInsets
            boolean r3 = r3.isVisible()
            if (r3 != r2) goto L_0x0096
        L_0x008b:
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m6866getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6846boximpl(r1)
            return r1
        L_0x0096:
            r4.L$0 = r0
            r2 = r26
            r4.J$0 = r2
            r4.F$0 = r1
            r4.label = r10
            java.lang.Object r6 = r0.getAnimationController(r4)
            if (r6 != r5) goto L_0x00a7
            return r5
        L_0x00a7:
            r12 = r2
            r3 = r6
            r2 = r0
        L_0x00aa:
            android.view.WindowInsetsAnimationController r3 = androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) r3)
            if (r3 != 0) goto L_0x00bb
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m6866getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6846boximpl(r1)
            return r1
        L_0x00bb:
            androidx.compose.foundation.layout.SideCalculator r6 = r2.sideCalculator
            android.graphics.Insets r14 = r3.getHiddenStateInsets()
            int r6 = r6.valueOf(r14)
            androidx.compose.foundation.layout.SideCalculator r14 = r2.sideCalculator
            android.graphics.Insets r15 = r3.getShownStateInsets()
            int r15 = r14.valueOf(r15)
            android.graphics.Insets r14 = androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m((android.view.WindowInsetsAnimationController) r3)
            androidx.compose.foundation.layout.SideCalculator r10 = r2.sideCalculator
            int r10 = r10.valueOf(r14)
            int r14 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            r16 = 0
            if (r14 > 0) goto L_0x00e1
            if (r10 == r6) goto L_0x00e7
        L_0x00e1:
            int r14 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x00fd
            if (r10 != r15) goto L_0x00fd
        L_0x00e7:
            if (r10 != r15) goto L_0x00eb
            r10 = 1
            goto L_0x00ed
        L_0x00eb:
            r10 = r16
        L_0x00ed:
            r3.finish(r10)
            r2.animationController = r7
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m6866getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6846boximpl(r1)
            return r1
        L_0x00fd:
            androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec r7 = new androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec
            androidx.compose.ui.unit.Density r14 = r2.density
            r7.<init>(r14)
            float r14 = (float) r10
            float r17 = r7.flingDistance(r1)
            float r14 = r14 + r17
            float r9 = (float) r6
            float r17 = r14 - r9
            int r11 = r15 - r6
            float r11 = (float) r11
            float r17 = r17 / r11
            r11 = 1056964608(0x3f000000, float:0.5)
            int r11 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x011c
            r23 = 1
            goto L_0x011e
        L_0x011c:
            r23 = r16
        L_0x011e:
            if (r23 == 0) goto L_0x0123
            r17 = r15
            goto L_0x0125
        L_0x0123:
            r17 = r6
        L_0x0125:
            float r11 = (float) r15
            int r11 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r11 > 0) goto L_0x015d
            int r9 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x012f
            goto L_0x015d
        L_0x012f:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3 r6 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3
            r21 = 0
            r14 = r6
            r15 = r2
            r16 = r10
            r18 = r1
            r19 = r3
            r20 = r23
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r4.L$0 = r2
            r4.J$0 = r12
            r4.label = r8
            java.lang.Object r1 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r4)
            if (r1 != r5) goto L_0x014f
            return r5
        L_0x014f:
            r4 = r2
            r1 = r12
        L_0x0151:
            androidx.compose.foundation.layout.SideCalculator r3 = r4.sideCalculator
            r4 = 0
            long r1 = r3.m716consumedVelocityQWom1Mo(r1, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6846boximpl(r1)
            return r1
        L_0x015d:
            kotlin.jvm.internal.Ref$FloatRef r8 = new kotlin.jvm.internal.Ref$FloatRef
            r8.<init>()
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2 r9 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2
            r24 = 0
            r14 = r9
            r11 = r15
            r15 = r2
            r16 = r10
            r17 = r1
            r18 = r7
            r19 = r6
            r20 = r11
            r21 = r8
            r22 = r3
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r4.L$0 = r2
            r4.L$1 = r8
            r4.J$0 = r12
            r1 = 2
            r4.label = r1
            java.lang.Object r1 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r9, r4)
            if (r1 != r5) goto L_0x018c
            return r5
        L_0x018c:
            r4 = r2
            r5 = r8
            r1 = r12
        L_0x018f:
            androidx.compose.foundation.layout.SideCalculator r3 = r4.sideCalculator
            float r4 = r5.element
            long r1 = r3.m716consumedVelocityQWom1Mo(r1, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6846boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.m773flinghuYlsQE(long, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void adjustInsets(float f) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(windowInsetsAnimationController), MathKt.roundToInt(f)), 1.0f, 0.0f);
        }
    }

    public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i) {
        this.animationController = windowInsetsAnimationController;
        this.isControllerRequested = false;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(windowInsetsAnimationController, WindowInsetsNestedScrollConnection$onReady$1.INSTANCE);
        }
        this.continuation = null;
    }

    public final void dispose() {
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$dispose$1.INSTANCE);
        }
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(!Intrinsics.areEqual((Object) ComponentDialog$$ExternalSyntheticApiModelOutline0.m(windowInsetsAnimationController), (Object) windowInsetsAnimationController.getHiddenStateInsets()));
        }
    }

    public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        animationEnded();
    }

    public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
        animationEnded();
    }

    private final void animationEnded() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if (!(windowInsetsAnimationController2 == null || !ComponentDialog$$ExternalSyntheticApiModelOutline0.m(windowInsetsAnimationController2) || (windowInsetsAnimationController = this.animationController) == null)) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$animationEnded$1.INSTANCE);
        }
        this.continuation = null;
        Job job = this.animationJob;
        if (job != null) {
            job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }
}
