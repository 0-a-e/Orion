package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u001a\b\u0010\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0012\u0010\\\u001a\u00020\u001a2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\b\u0010_\u001a\u00020`H\u0016J\u000e\u0010a\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`bJ\n\u0010c\u001a\u0004\u0018\u00010dH\u0016J\b\u0010e\u001a\u00020\nH\u0016J\u001e\u0010f\u001a\u0004\u0018\u00010g2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\u0006\u0010j\u001a\u000206J\b\u0010k\u001a\u00020\u001aH\u0016J \u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\nH\u0002J\b\u0010p\u001a\u000206H\u0014J\b\u0010q\u001a\u000206H\u0016J\u0018\u0010r\u001a\u0002062\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000eH\u0016J\b\u0010u\u001a\u000206H\u0014J0\u0010v\u001a\u0002062\u0006\u0010w\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\n2\u0006\u0010y\u001a\u00020\n2\u0006\u0010z\u001a\u00020\n2\u0006\u0010{\u001a\u00020\nH\u0014J\u0018\u0010|\u001a\u0002062\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0014J-\u0010\u001a\u00020\u001a2\u0006\u0010t\u001a\u00020\u000e2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001aH\u0016J%\u0010\u0001\u001a\u00020\u001a2\u0006\u0010t\u001a\u00020\u000e2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J5\u0010\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020\nH\u0016J>\u0010\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016JG\u0010\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020+H\u0016J+\u0010\u0001\u001a\u0002062\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\t\u0010\u0001\u001a\u000206H\u0016J\t\u0010\u0001\u001a\u000206H\u0016J+\u0010\u0001\u001a\u00020\u001a2\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\u001a\u0010\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020\nH\u0014J\u0007\u0010\u0001\u001a\u000206J\u0012\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020\u001aH\u0016J\t\u0010\u0001\u001a\u00020\u001aH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0012\u001a\u0004\u0018\u00010$@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020,@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000206\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010;\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u000206\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R(\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000206\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R0\u0010C\u001a\b\u0012\u0004\u0012\u0002060B2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002060B@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR0\u0010H\u001a\b\u0012\u0004\u0012\u0002060B2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002060B@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\u0014\u0010K\u001a\b\u0012\u0004\u0012\u0002060BX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u0002060BX\u0004¢\u0006\u0002\n\u0000R(\u0010N\u001a\u0004\u0018\u00010M2\b\u0010\u0012\u001a\u0004\u0018\u00010M@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020T8BX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR0\u0010W\u001a\b\u0012\u0004\u0012\u0002060B2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002060B@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010E\"\u0004\bY\u0010GR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/node/OwnerScope;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHash", "", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "view", "Landroid/view/View;", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;ILandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroid/view/View;Landroidx/compose/ui/node/Owner;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "isDrawing", "isValidOwnerScope", "()Z", "lastHeightMeasureSpec", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onDensityChanged", "Lkotlin/Function1;", "", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "<set-?>", "Lkotlin/Function0;", "release", "getRelease", "()Lkotlin/jvm/functions/Function0;", "setRelease", "(Lkotlin/jvm/functions/Function0;)V", "reset", "getReset", "setReset", "runInvalidate", "runUpdate", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "update", "getUpdate", "setUpdate", "getView", "()Landroid/view/View;", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getAccessibilityClassName", "", "getInteropView", "Landroidx/compose/ui/viewinterop/InteropView;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getNestedScrollAxes", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "invalidateOrDefer", "isNestedScrollingEnabled", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDeactivate", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "axes", "onRelease", "onReuse", "onStartNestedScroll", "onStopNestedScroll", "onWindowVisibilityChanged", "visibility", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback, OwnerScope {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function1<AndroidViewHolder, Unit> OnCommitAffectingUpdate = AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.INSTANCE;
    private final int compositeKeyHash;
    private Density density;
    /* access modifiers changed from: private */
    public final NestedScrollDispatcher dispatcher;
    /* access modifiers changed from: private */
    public boolean hasUpdateBlock;
    /* access modifiers changed from: private */
    public boolean isDrawing;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    private final Owner owner;
    private Function0<Unit> release;
    private Function0<Unit> reset;
    private final Function0<Unit> runInvalidate;
    /* access modifiers changed from: private */
    public final Function0<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private Function0<Unit> update;
    private final View view;

    public boolean onStartNestedScroll(View view2, View view3, int i, int i2) {
        return ((i & 2) == 0 && (i & 1) == 0) ? false : true;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final View getView() {
        return this.view;
    }

    public AndroidViewHolder(Context context, CompositionContext compositionContext, int i, NestedScrollDispatcher nestedScrollDispatcher, View view2, Owner owner2) {
        super(context);
        this.compositeKeyHash = i;
        this.dispatcher = nestedScrollDispatcher;
        this.view = view2;
        this.owner = owner2;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        addView(view2);
        this.update = AndroidViewHolder$update$1.INSTANCE;
        this.reset = AndroidViewHolder$reset$1.INSTANCE;
        this.release = AndroidViewHolder$release$1.INSTANCE;
        this.modifier = Modifier.Companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.runUpdate = new AndroidViewHolder$runUpdate$1(this);
        this.runInvalidate = new AndroidViewHolder$runInvalidate$1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        AndroidViewHolder androidViewHolder = this;
        LayoutNode layoutNode2 = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        layoutNode2.setInteropViewFactoryHolder$ui_release(this);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(Modifier.Companion, AndroidViewHolder_androidKt.NoOpScrollConnection, this.dispatcher), true, AndroidViewHolder$layoutNode$1$coreModifier$1.INSTANCE), this), new AndroidViewHolder$layoutNode$1$coreModifier$2(this, layoutNode2, this)), new AndroidViewHolder$layoutNode$1$coreModifier$3(this, layoutNode2));
        layoutNode2.setCompositeKeyHash(this.compositeKeyHash);
        layoutNode2.setModifier(this.modifier.then(onGloballyPositioned));
        this.onModifierChanged = new AndroidViewHolder$layoutNode$1$1(layoutNode2, onGloballyPositioned);
        layoutNode2.setDensity(this.density);
        this.onDensityChanged = new AndroidViewHolder$layoutNode$1$2(layoutNode2);
        layoutNode2.setOnAttach$ui_release(new AndroidViewHolder$layoutNode$1$3(this, layoutNode2));
        layoutNode2.setOnDetach$ui_release(new AndroidViewHolder$layoutNode$1$4(this));
        layoutNode2.setMeasurePolicy(new AndroidViewHolder$layoutNode$1$5(this, layoutNode2));
        this.layoutNode = layoutNode2;
    }

    public final View getInteropView() {
        return this.view;
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    /* access modifiers changed from: protected */
    public final void setUpdate(Function0<Unit> function0) {
        this.update = function0;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final Function0<Unit> getReset() {
        return this.reset;
    }

    /* access modifiers changed from: protected */
    public final void setReset(Function0<Unit> function0) {
        this.reset = function0;
    }

    public final Function0<Unit> getRelease() {
        return this.release;
    }

    /* access modifiers changed from: protected */
    public final void setRelease(Function0<Unit> function0) {
        this.release = function0;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final void setModifier(Modifier modifier2) {
        if (modifier2 != this.modifier) {
            this.modifier = modifier2;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(modifier2);
            }
        }
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density density2) {
        if (density2 != this.density) {
            this.density = density2;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(density2);
            }
        }
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner2) {
        if (lifecycleOwner2 != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner2;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner2);
        }
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner2) {
        if (savedStateRegistryOwner2 != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner2);
        }
    }

    /* access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        if (isAttachedToWindow()) {
            return this.owner.getSnapshotObserver();
        }
        throw new IllegalStateException("Expected AndroidViewHolder to be attached when observing reads.".toString());
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    public boolean isValidOwnerScope() {
        return isAttachedToWindow();
    }

    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    public void onReuse() {
        if (this.view.getParent() != this) {
            addView(this.view);
        } else {
            this.reset.invoke();
        }
    }

    public void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    public void onRelease() {
        this.release.invoke();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        } else if (this.view.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
        } else {
            this.view.measure(i, i2);
            setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
            this.lastWidthMeasureSpec = i;
            this.lastHeightMeasureSpec = i2;
        }
    }

    public final void remeasure() {
        int i;
        int i2 = this.lastWidthMeasureSpec;
        if (i2 != Integer.MIN_VALUE && (i = this.lastHeightMeasureSpec) != Integer.MIN_VALUE) {
            measure(i2, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.view.layout(0, 0, i3 - i, i4 - i2);
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().clear$ui_release(this);
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        invalidateOrDefer();
        return null;
    }

    public void onDescendantInvalidated(View view2, View view3) {
        super.onDescendantInvalidated(view2, view3);
        invalidateOrDefer();
    }

    public final void invalidateOrDefer() {
        if (this.isDrawing) {
            this.view.postOnAnimation(new AndroidViewHolder$$ExternalSyntheticLambda0(this.runInvalidate));
        } else {
            this.layoutNode.invalidateLayer$ui_release();
        }
    }

    /* access modifiers changed from: private */
    public static final void invalidateOrDefer$lambda$2(Function0 function0) {
        function0.invoke();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i = iArr[0];
        region.op(i, iArr[1], i + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* access modifiers changed from: private */
    public final int obtainMeasureSpec(int i, int i2, int i3) {
        if (i3 >= 0 || i == i2) {
            return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(i3, i, i2), 1073741824);
        }
        if (i3 == -2 && i2 != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
        }
        if (i3 != -1 || i2 == Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
    }

    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    public void onNestedScrollAccepted(View view2, View view3, int i, int i2) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(view2, view3, i, i2);
    }

    public void onStopNestedScroll(View view2, int i) {
        this.nestedScrollingParentHelper.onStopNestedScroll(view2, i);
    }

    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (isNestedScrollingEnabled()) {
            long r7 = this.dispatcher.m4990dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i3), AndroidViewHolder_androidKt.toComposeOffset(i4)), AndroidViewHolder_androidKt.toNestedScrollSource(i5));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3562getXimpl(r7));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3563getYimpl(r7));
        }
    }

    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5) {
        if (isNestedScrollingEnabled()) {
            this.dispatcher.m4990dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i3), AndroidViewHolder_androidKt.toComposeOffset(i4)), AndroidViewHolder_androidKt.toNestedScrollSource(i5));
        }
    }

    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr, int i3) {
        if (isNestedScrollingEnabled()) {
            long r1 = this.dispatcher.m4992dispatchPreScrollOzD1aCk(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), AndroidViewHolder_androidKt.toNestedScrollSource(i3));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3562getXimpl(r1));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3563getYimpl(r1));
        }
    }

    public boolean onNestedFling(View view2, float f, float f2, boolean z) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        long Velocity = VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f), AndroidViewHolder_androidKt.toComposeVelocity(f2));
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedFling$1(z, this, Velocity, (Continuation<? super AndroidViewHolder$onNestedFling$1>) null), 3, (Object) null);
        return false;
    }

    public boolean onNestedPreFling(View view2, float f, float f2) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedPreFling$1(this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f), AndroidViewHolder_androidKt.toComposeVelocity(f2)), (Continuation<? super AndroidViewHolder$onNestedPreFling$1>) null), 3, (Object) null);
        return false;
    }

    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder$Companion;", "", "()V", "OnCommitAffectingUpdate", "Lkotlin/Function1;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidViewHolder.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
