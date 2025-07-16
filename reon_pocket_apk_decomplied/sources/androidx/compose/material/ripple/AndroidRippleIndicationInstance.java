package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020\u0019H\u0016J\b\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\u0010\u00103\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0016J\u0006\u00104\u001a\u00020\u0019J\f\u00105\u001a\u00020\u0019*\u000206H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001d8B@BX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u00020'X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/material/ripple/AndroidRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "view", "Landroid/view/ViewGroup;", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroid/view/ViewGroup;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "invalidateTick", "getInvalidateTick", "()Z", "setInvalidateTick", "(Z)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "onInvalidateRipple", "Lkotlin/Function0;", "", "F", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "getRippleHostView", "()Landroidx/compose/material/ripple/RippleHostView;", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "rippleHostView$delegate", "rippleRadius", "", "rippleSize", "Landroidx/compose/ui/geometry/Size;", "J", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispose", "getOrCreateRippleContainer", "onAbandoned", "onForgotten", "onRemembered", "removeRipple", "resetHostView", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.android.kt */
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    public static final int $stable = 8;
    private final boolean bounded;
    private final State<Color> color;
    private final MutableState invalidateTick$delegate;
    private final Function0<Unit> onInvalidateRipple;
    private final float radius;
    private final State<RippleAlpha> rippleAlpha;
    private RippleContainer rippleContainer;
    private final MutableState rippleHostView$delegate;
    private int rippleRadius;
    private long rippleSize;
    private final ViewGroup view;

    public /* synthetic */ AndroidRippleIndicationInstance(boolean z, float f, State state, State state2, ViewGroup viewGroup, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state, state2, viewGroup);
    }

    public void onRemembered() {
    }

    private AndroidRippleIndicationInstance(boolean z, float f, State<Color> state, State<RippleAlpha> state2, ViewGroup viewGroup) {
        super(z, state2);
        this.bounded = z;
        this.radius = f;
        this.color = state;
        this.rippleAlpha = state2;
        this.view = viewGroup;
        this.rippleHostView$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.invalidateTick$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.rippleSize = Size.Companion.m3640getZeroNHjbRc();
        this.rippleRadius = -1;
        this.onInvalidateRipple = new AndroidRippleIndicationInstance$onInvalidateRipple$1(this);
    }

    private final RippleHostView getRippleHostView() {
        return (RippleHostView) this.rippleHostView$delegate.getValue();
    }

    private final void setRippleHostView(RippleHostView rippleHostView) {
        this.rippleHostView$delegate.setValue(rippleHostView);
    }

    /* access modifiers changed from: private */
    public final boolean getInvalidateTick() {
        return ((Boolean) this.invalidateTick$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void setInvalidateTick(boolean z) {
        this.invalidateTick$delegate.setValue(Boolean.valueOf(z));
    }

    public void drawIndication(ContentDrawScope contentDrawScope) {
        int i;
        this.rippleSize = contentDrawScope.m4434getSizeNHjbRc();
        if (Float.isNaN(this.radius)) {
            i = MathKt.roundToInt(RippleAnimationKt.m1485getRippleEndRadiuscSwnlzA(contentDrawScope, this.bounded, contentDrawScope.m4434getSizeNHjbRc()));
        } else {
            i = contentDrawScope.m6545roundToPx0680j_4(this.radius);
        }
        this.rippleRadius = i;
        long r5 = this.color.getValue().m3826unboximpl();
        float pressedAlpha = this.rippleAlpha.getValue().getPressedAlpha();
        contentDrawScope.drawContent();
        DrawScope drawScope = contentDrawScope;
        m1490drawStateLayerH2RKhps(drawScope, this.radius, r5);
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        getInvalidateTick();
        RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            rippleHostView.m1489updateRipplePropertiesbiQXAtU(contentDrawScope.m4434getSizeNHjbRc(), this.rippleRadius, r5, pressedAlpha);
            rippleHostView.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
    }

    public void addRipple(PressInteraction.Press press, CoroutineScope coroutineScope) {
        RippleHostView rippleHostView = getOrCreateRippleContainer().getRippleHostView(this);
        rippleHostView.m1488addRippleKOepWvA(press, this.bounded, this.rippleSize, this.rippleRadius, this.color.getValue().m3826unboximpl(), this.rippleAlpha.getValue().getPressedAlpha(), this.onInvalidateRipple);
        setRippleHostView(rippleHostView);
    }

    public void removeRipple(PressInteraction.Press press) {
        RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            rippleHostView.removeRipple();
        }
    }

    public void onForgotten() {
        dispose();
    }

    public void onAbandoned() {
        dispose();
    }

    private final void dispose() {
        RippleContainer rippleContainer2 = this.rippleContainer;
        if (rippleContainer2 != null) {
            rippleContainer2.disposeRippleIfNeeded(this);
        }
    }

    public final void resetHostView() {
        setRippleHostView((RippleHostView) null);
    }

    private final RippleContainer getOrCreateRippleContainer() {
        RippleContainer rippleContainer2 = this.rippleContainer;
        if (rippleContainer2 != null) {
            Intrinsics.checkNotNull(rippleContainer2);
            return rippleContainer2;
        }
        int childCount = this.view.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = this.view.getChildAt(i);
            if (childAt instanceof RippleContainer) {
                this.rippleContainer = (RippleContainer) childAt;
                break;
            }
            i++;
        }
        if (this.rippleContainer == null) {
            RippleContainer rippleContainer3 = new RippleContainer(this.view.getContext());
            this.view.addView(rippleContainer3);
            this.rippleContainer = rippleContainer3;
        }
        RippleContainer rippleContainer4 = this.rippleContainer;
        Intrinsics.checkNotNull(rippleContainer4);
        return rippleContainer4;
    }
}
