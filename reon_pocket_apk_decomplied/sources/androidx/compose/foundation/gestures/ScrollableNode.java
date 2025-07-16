package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005BK\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000203H\u0016J\u001a\u00107\u001a\u00020\r2\u0006\u00108\u001a\u000209H\u0016ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\b\u0010<\u001a\u000203H\u0016J\u001a\u0010=\u001a\u00020\r2\u0006\u00108\u001a\u000209H\u0016ø\u0001\u0000¢\u0006\u0004\b>\u0010;JL\u0010?\u001a\u0002032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010@\u001a\u000203H\u0002R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "getContentInViewNode", "()Landroidx/compose/foundation/gestures/ContentInViewNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "getDefaultFlingBehavior", "()Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "getNestedScrollDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableContainer", "Landroidx/compose/foundation/gestures/ModifierLocalScrollableContainerProvider;", "getScrollableContainer", "()Landroidx/compose/foundation/gestures/ModifierLocalScrollableContainerProvider;", "scrollableGesturesNode", "Landroidx/compose/foundation/gestures/ScrollableGesturesNode;", "getScrollableGesturesNode", "()Landroidx/compose/foundation/gestures/ScrollableGesturesNode;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onAttach", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "update", "updateDefaultFlingBehavior", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableNode extends DelegatingNode implements ObserverModifierNode, CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, KeyInputModifierNode {
    private final ContentInViewNode contentInViewNode;
    private final DefaultFlingBehavior defaultFlingBehavior;
    private boolean enabled;
    private FlingBehavior flingBehavior;
    private MutableInteractionSource interactionSource;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private final ModifierLocalScrollableContainerProvider scrollableContainer;
    private final ScrollableGesturesNode scrollableGesturesNode;
    private final ScrollingLogic scrollingLogic;
    private ScrollableState state;

    /* renamed from: onPreKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m464onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    public ScrollableNode(ScrollableState scrollableState, Orientation orientation2, OverscrollEffect overscrollEffect2, boolean z, boolean z2, FlingBehavior flingBehavior2, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        this.state = scrollableState;
        this.orientation = orientation2;
        this.overscrollEffect = overscrollEffect2;
        this.enabled = z;
        this.reverseDirection = z2;
        this.flingBehavior = flingBehavior2;
        this.interactionSource = mutableInteractionSource;
        NestedScrollDispatcher nestedScrollDispatcher2 = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = nestedScrollDispatcher2;
        DefaultFlingBehavior defaultFlingBehavior2 = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.UnityDensity), (MotionDurationScale) null, 2, (DefaultConstructorMarker) null);
        this.defaultFlingBehavior = defaultFlingBehavior2;
        ScrollableState scrollableState2 = this.state;
        Orientation orientation3 = this.orientation;
        OverscrollEffect overscrollEffect3 = this.overscrollEffect;
        boolean z3 = this.reverseDirection;
        FlingBehavior flingBehavior3 = this.flingBehavior;
        ScrollingLogic scrollingLogic2 = new ScrollingLogic(scrollableState2, orientation3, overscrollEffect3, z3, flingBehavior3 == null ? defaultFlingBehavior2 : flingBehavior3, nestedScrollDispatcher2);
        this.scrollingLogic = scrollingLogic2;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic2, this.enabled);
        this.nestedScrollConnection = scrollableNestedScrollConnection;
        ContentInViewNode contentInViewNode2 = (ContentInViewNode) delegate(new ContentInViewNode(this.orientation, this.state, this.reverseDirection, bringIntoViewSpec));
        this.contentInViewNode = contentInViewNode2;
        this.scrollableContainer = (ModifierLocalScrollableContainerProvider) delegate(new ModifierLocalScrollableContainerProvider(this.enabled));
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(scrollableNestedScrollConnection, nestedScrollDispatcher2));
        delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode());
        delegate(new BringIntoViewResponderNode(contentInViewNode2));
        delegate(new FocusedBoundsObserverNode(new Function1<LayoutCoordinates, Unit>(this) {
            final /* synthetic */ ScrollableNode this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                this.this$0.getContentInViewNode().onFocusBoundsChanged(layoutCoordinates);
            }
        }));
        this.scrollableGesturesNode = (ScrollableGesturesNode) delegate(new ScrollableGesturesNode(scrollingLogic2, this.orientation, this.enabled, nestedScrollDispatcher2, this.interactionSource));
    }

    public final NestedScrollDispatcher getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final DefaultFlingBehavior getDefaultFlingBehavior() {
        return this.defaultFlingBehavior;
    }

    public final ScrollingLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final ScrollableNestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    public final ContentInViewNode getContentInViewNode() {
        return this.contentInViewNode;
    }

    public final ModifierLocalScrollableContainerProvider getScrollableContainer() {
        return this.scrollableContainer;
    }

    public final ScrollableGesturesNode getScrollableGesturesNode() {
        return this.scrollableGesturesNode;
    }

    public final void update(ScrollableState scrollableState, Orientation orientation2, OverscrollEffect overscrollEffect2, boolean z, boolean z2, FlingBehavior flingBehavior2, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        ScrollableState scrollableState2 = scrollableState;
        Orientation orientation3 = orientation2;
        boolean z3 = z;
        boolean z4 = z2;
        FlingBehavior flingBehavior3 = flingBehavior2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        if (this.enabled != z3) {
            this.nestedScrollConnection.setEnabled(z3);
            this.scrollableContainer.setEnabled(z3);
        }
        this.scrollingLogic.update(scrollableState, orientation2, overscrollEffect2, z2, flingBehavior3 == null ? this.defaultFlingBehavior : flingBehavior3, this.nestedScrollDispatcher);
        this.scrollableGesturesNode.update(orientation3, z3, mutableInteractionSource2);
        this.contentInViewNode.update(orientation3, scrollableState, z4, bringIntoViewSpec);
        this.state = scrollableState2;
        this.orientation = orientation3;
        this.overscrollEffect = overscrollEffect2;
        this.enabled = z3;
        this.reverseDirection = z4;
        this.flingBehavior = flingBehavior3;
        this.interactionSource = mutableInteractionSource2;
    }

    public void onAttach() {
        updateDefaultFlingBehavior();
        ObserverModifierNodeKt.observeReads(this, new ScrollableNode$onAttach$1(this));
    }

    public void onObservedReadsChanged() {
        updateDefaultFlingBehavior();
    }

    private final void updateDefaultFlingBehavior() {
        this.defaultFlingBehavior.setFlingDecay(SplineBasedDecayKt.splineBasedDecay((Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalDensity())));
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
    }

    /* renamed from: onKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m463onKeyEventZmokQxo(KeyEvent keyEvent) {
        long j;
        if (!this.enabled || ((!Key.m4649equalsimpl0(KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent), Key.Companion.m4837getPageDownEK5gGoQ()) && !Key.m4649equalsimpl0(KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent), Key.Companion.m4838getPageUpEK5gGoQ())) || !KeyEventType.m4950equalsimpl0(KeyEvent_androidKt.m4958getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4954getKeyDownCS__XNY()) || KeyEvent_androidKt.m4961isCtrlPressedZmokQxo(keyEvent))) {
            return false;
        }
        ScrollingLogic scrollingLogic2 = this.scrollingLogic;
        if (this.orientation == Orientation.Vertical) {
            int r1 = IntSize.m6789getHeightimpl(this.contentInViewNode.m349getViewportSizeYbymL2g$foundation_release());
            j = OffsetKt.Offset(0.0f, Key.m4649equalsimpl0(KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent), Key.Companion.m4838getPageUpEK5gGoQ()) ? (float) r1 : -((float) r1));
        } else {
            int r12 = IntSize.m6790getWidthimpl(this.contentInViewNode.m349getViewportSizeYbymL2g$foundation_release());
            j = OffsetKt.Offset(Key.m4649equalsimpl0(KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent), Key.Companion.m4838getPageUpEK5gGoQ()) ? (float) r12 : -((float) r12), 0.0f);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new ScrollableNode$onKeyEvent$1$1(scrollingLogic2, j, (Continuation<? super ScrollableNode$onKeyEvent$1$1>) null), 3, (Object) null);
        return true;
    }
}
