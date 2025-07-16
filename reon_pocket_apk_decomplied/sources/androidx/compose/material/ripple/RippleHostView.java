package androidx.compose.material.ripple;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JN\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010 \u001a\u00020\rJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J0\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0014J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0014J\b\u0010-\u001a\u00020\rH\u0016J\u0006\u0010.\u001a\u00020\rJ\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0006H\u0002J0\u00101\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b2\u00103R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bounded", "", "Ljava/lang/Boolean;", "lastRippleStateChangeTimeMillis", "", "Ljava/lang/Long;", "onInvalidateRipple", "Lkotlin/Function0;", "", "resetRippleRunnable", "Ljava/lang/Runnable;", "ripple", "Landroidx/compose/material/ripple/UnprojectedRipple;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "radius", "", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "addRipple-KOepWvA", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;ZJIJFLkotlin/jvm/functions/Function0;)V", "createRipple", "disposeRipple", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDrawableState", "removeRipple", "setRippleState", "pressed", "updateRippleProperties", "updateRippleProperties-biQXAtU", "(JIJF)V", "Companion", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RippleHostView.android.kt */
public final class RippleHostView extends View {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long MinimumRippleStateChangeTime = 5;
    private static final int[] PressedState = {16842919, 16842910};
    private static final long ResetRippleDelayDuration = 50;
    private static final int[] RestingState = new int[0];
    private Boolean bounded;
    private Long lastRippleStateChangeTimeMillis;
    private Function0<Unit> onInvalidateRipple;
    private Runnable resetRippleRunnable;
    private UnprojectedRipple ripple;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void refreshDrawableState() {
    }

    public RippleHostView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    private final void createRipple(boolean z) {
        UnprojectedRipple unprojectedRipple = new UnprojectedRipple(z);
        setBackground(unprojectedRipple);
        this.ripple = unprojectedRipple;
    }

    public void invalidateDrawable(Drawable drawable) {
        Function0<Unit> function0 = this.onInvalidateRipple;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: addRipple-KOepWvA  reason: not valid java name */
    public final void m1488addRippleKOepWvA(PressInteraction.Press press, boolean z, long j, int i, long j2, float f, Function0<Unit> function0) {
        boolean z2 = z;
        if (this.ripple == null || !Intrinsics.areEqual((Object) Boolean.valueOf(z), (Object) this.bounded)) {
            createRipple(z);
            this.bounded = Boolean.valueOf(z);
        }
        UnprojectedRipple unprojectedRipple = this.ripple;
        Intrinsics.checkNotNull(unprojectedRipple);
        this.onInvalidateRipple = function0;
        m1489updateRipplePropertiesbiQXAtU(j, i, j2, f);
        if (z2) {
            unprojectedRipple.setHotspot(Offset.m3562getXimpl(press.m502getPressPositionF1C5BW0()), Offset.m3563getYimpl(press.m502getPressPositionF1C5BW0()));
        } else {
            unprojectedRipple.setHotspot((float) unprojectedRipple.getBounds().centerX(), (float) unprojectedRipple.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    /* renamed from: updateRippleProperties-biQXAtU  reason: not valid java name */
    public final void m1489updateRipplePropertiesbiQXAtU(long j, int i, long j2, float f) {
        UnprojectedRipple unprojectedRipple = this.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.trySetRadius(i);
            unprojectedRipple.m1497setColorDxMtmZc(j2, f);
            Rect rect = new Rect(0, 0, MathKt.roundToInt(Size.m3631getWidthimpl(j)), MathKt.roundToInt(Size.m3628getHeightimpl(j)));
            setLeft(rect.left);
            setTop(rect.top);
            setRight(rect.right);
            setBottom(rect.bottom);
            unprojectedRipple.setBounds(rect);
        }
    }

    public final void disposeRipple() {
        this.onInvalidateRipple = null;
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            Runnable runnable2 = this.resetRippleRunnable;
            Intrinsics.checkNotNull(runnable2);
            runnable2.run();
        } else {
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(RestingState);
            }
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        if (unprojectedRipple2 != null) {
            unprojectedRipple2.setVisible(false, false);
            unscheduleDrawable(unprojectedRipple2);
        }
    }

    private final void setRippleState(boolean z) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l = this.lastRippleStateChangeTimeMillis;
        long longValue = currentAnimationTimeMillis - (l != null ? l.longValue() : 0);
        if (z || longValue >= MinimumRippleStateChangeTime) {
            int[] iArr = z ? PressedState : RestingState;
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(iArr);
            }
        } else {
            RippleHostView$$ExternalSyntheticLambda0 rippleHostView$$ExternalSyntheticLambda0 = new RippleHostView$$ExternalSyntheticLambda0(this);
            this.resetRippleRunnable = rippleHostView$$ExternalSyntheticLambda0;
            postDelayed(rippleHostView$$ExternalSyntheticLambda0, ResetRippleDelayDuration);
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(currentAnimationTimeMillis);
    }

    /* access modifiers changed from: private */
    public static final void setRippleState$lambda$2(RippleHostView rippleHostView) {
        UnprojectedRipple unprojectedRipple = rippleHostView.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.setState(RestingState);
        }
        rippleHostView.resetRippleRunnable = null;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView$Companion;", "", "()V", "MinimumRippleStateChangeTime", "", "PressedState", "", "ResetRippleDelayDuration", "RestingState", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RippleHostView.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
