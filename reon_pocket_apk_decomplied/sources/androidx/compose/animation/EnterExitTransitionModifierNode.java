package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010E\u001a\u00020FH\u0016J \u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ \u0010L\u001a\u00020\n2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010KJ \u0010N\u001a\u00020\n2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010KJ&\u0010P\u001a\u00020Q*\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\bV\u0010WR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R&\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020(@BX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\"\u0004\b*\u0010+R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u00020\u0007X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010,R2\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R2\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R.\u00106\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000408\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070907¢\u0006\u0002\b:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R2\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00101\"\u0004\b>\u00103R.\u0010?\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000408\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0907¢\u0006\u0002\b:¢\u0006\b\n\u0000\u001a\u0004\b@\u0010<R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "alignment", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "currentAlignment", "getCurrentAlignment", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "J", "lookaheadConstraintsAvailable", "", "lookaheadSize", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setOffsetAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getSizeAnimation", "setSizeAnimation", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "getSlideAnimation", "setSlideAnimation", "slideSpec", "getSlideSpec", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "onAttach", "", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "slideTargetValueByState", "slideTargetValueByState-oFUgxo0", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    private Alignment currentAlignment;
    private EnterTransition enter;
    private ExitTransition exit;
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
    private boolean lookaheadConstraintsAvailable;
    private long lookaheadSize = AnimationModifierKt.getInvalidSize();
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec = new EnterExitTransitionModifierNode$sizeTransitionSpec$1(this);
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation;
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> slideSpec = new EnterExitTransitionModifierNode$slideSpec$1(this);
    private Transition<EnterExitState> transition;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: EnterExitTransition.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.animation.EnterExitState[] r0 = androidx.compose.animation.EnterExitState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.Visible     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PostExit     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionModifierNode.WhenMappings.<clinit>():void");
        }
    }

    public final Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public final void setTransition(Transition<EnterExitState> transition2) {
        this.transition = transition2;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final void setSizeAnimation(Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation) {
        this.sizeAnimation = deferredAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final void setOffsetAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.offsetAnimation = deferredAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    public final void setSlideAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.slideAnimation = deferredAnimation;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final void setEnter(EnterTransition enterTransition) {
        this.enter = enterTransition;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final void setExit(ExitTransition exitTransition) {
        this.exit = exitTransition;
    }

    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    public final void setGraphicsLayerBlock(GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    public EnterExitTransitionModifierNode(Transition<EnterExitState> transition2, Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3, EnterTransition enterTransition, ExitTransition exitTransition, GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.transition = transition2;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransition;
        this.exit = exitTransition;
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    /* renamed from: setLookaheadConstraints-BRTryo0  reason: not valid java name */
    private final void m90setLookaheadConstraintsBRTryo0(long j) {
        this.lookaheadConstraintsAvailable = true;
        this.lookaheadConstraints = j;
    }

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final void setCurrentAlignment(Alignment alignment) {
        this.currentAlignment = alignment;
    }

    public final Alignment getAlignment() {
        Alignment alignment;
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            ChangeSize changeSize = this.enter.getData$animation_release().getChangeSize();
            if (changeSize == null || (alignment = changeSize.getAlignment()) == null) {
                ChangeSize changeSize2 = this.exit.getData$animation_release().getChangeSize();
                if (changeSize2 != null) {
                    return changeSize2.getAlignment();
                }
                return null;
            }
        } else {
            ChangeSize changeSize3 = this.exit.getData$animation_release().getChangeSize();
            if (changeSize3 == null || (alignment = changeSize3.getAlignment()) == null) {
                ChangeSize changeSize4 = this.enter.getData$animation_release().getChangeSize();
                if (changeSize4 != null) {
                    return changeSize4.getAlignment();
                }
                return null;
            }
        }
        return alignment;
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        r2 = r2.getSize();
     */
    /* renamed from: sizeByState-Uzc_VyU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m92sizeByStateUzc_VyU(androidx.compose.animation.EnterExitState r2, long r3) {
        /*
            r1 = this;
            int[] r0 = androidx.compose.animation.EnterExitTransitionModifierNode.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            if (r2 == r0) goto L_0x0058
            r0 = 2
            if (r2 == r0) goto L_0x0038
            r0 = 3
            if (r2 != r0) goto L_0x0032
            androidx.compose.animation.ExitTransition r2 = r1.exit
            androidx.compose.animation.TransitionData r2 = r2.getData$animation_release()
            androidx.compose.animation.ChangeSize r2 = r2.getChangeSize()
            if (r2 == 0) goto L_0x0058
            kotlin.jvm.functions.Function1 r2 = r2.getSize()
            if (r2 == 0) goto L_0x0058
            androidx.compose.ui.unit.IntSize r3 = androidx.compose.ui.unit.IntSize.m6782boximpl(r3)
            java.lang.Object r2 = r2.invoke(r3)
            androidx.compose.ui.unit.IntSize r2 = (androidx.compose.ui.unit.IntSize) r2
            long r3 = r2.m6794unboximpl()
            goto L_0x0058
        L_0x0032:
            kotlin.NoWhenBranchMatchedException r2 = new kotlin.NoWhenBranchMatchedException
            r2.<init>()
            throw r2
        L_0x0038:
            androidx.compose.animation.EnterTransition r2 = r1.enter
            androidx.compose.animation.TransitionData r2 = r2.getData$animation_release()
            androidx.compose.animation.ChangeSize r2 = r2.getChangeSize()
            if (r2 == 0) goto L_0x0058
            kotlin.jvm.functions.Function1 r2 = r2.getSize()
            if (r2 == 0) goto L_0x0058
            androidx.compose.ui.unit.IntSize r3 = androidx.compose.ui.unit.IntSize.m6782boximpl(r3)
            java.lang.Object r2 = r2.invoke(r3)
            androidx.compose.ui.unit.IntSize r2 = (androidx.compose.ui.unit.IntSize) r2
            long r3 = r2.m6794unboximpl()
        L_0x0058:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionModifierNode.m92sizeByStateUzc_VyU(androidx.compose.animation.EnterExitState, long):long");
    }

    public void onAttach() {
        super.onAttach();
        this.lookaheadConstraintsAvailable = false;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    /* renamed from: targetOffsetByState-oFUgxo0  reason: not valid java name */
    public final long m94targetOffsetByStateoFUgxo0(EnterExitState enterExitState, long j) {
        if (this.currentAlignment == null) {
            return IntOffset.Companion.m6758getZeronOccac();
        }
        if (getAlignment() == null) {
            return IntOffset.Companion.m6758getZeronOccac();
        }
        if (Intrinsics.areEqual((Object) this.currentAlignment, (Object) getAlignment())) {
            return IntOffset.Companion.m6758getZeronOccac();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i == 1) {
            return IntOffset.Companion.m6758getZeronOccac();
        }
        if (i == 2) {
            return IntOffset.Companion.m6758getZeronOccac();
        }
        if (i == 3) {
            ChangeSize changeSize = this.exit.getData$animation_release().getChangeSize();
            if (changeSize == null) {
                return IntOffset.Companion.m6758getZeronOccac();
            }
            long r6 = changeSize.getSize().invoke(IntSize.m6782boximpl(j)).m6794unboximpl();
            Alignment alignment = getAlignment();
            Intrinsics.checkNotNull(alignment);
            long j2 = j;
            long j3 = r6;
            long r8 = alignment.m3417alignKFBX0sM(j2, j3, LayoutDirection.Ltr);
            Alignment alignment2 = this.currentAlignment;
            Intrinsics.checkNotNull(alignment2);
            long r11 = alignment2.m3417alignKFBX0sM(j2, j3, LayoutDirection.Ltr);
            return IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r8) - IntOffset.m6748getXimpl(r11), IntOffset.m6749getYimpl(r8) - IntOffset.m6749getYimpl(r11));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m91measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long j2;
        State<IntOffset> animate;
        State<IntOffset> animate2;
        long j3 = j;
        State<IntSize> state = null;
        if (this.transition.getCurrentState() == this.transition.getTargetState()) {
            this.currentAlignment = null;
        } else if (this.currentAlignment == null) {
            Alignment alignment = getAlignment();
            if (alignment == null) {
                alignment = Alignment.Companion.getTopStart();
            }
            this.currentAlignment = alignment;
        }
        if (measureScope.isLookingAhead()) {
            Placeable r3 = measurable.m5368measureBRTryo0(j);
            long IntSize = IntSizeKt.IntSize(r3.getWidth(), r3.getHeight());
            this.lookaheadSize = IntSize;
            m90setLookaheadConstraintsBRTryo0(j3);
            return MeasureScope.CC.layout$default(measureScope, IntSize.m6790getWidthimpl(IntSize), IntSize.m6789getHeightimpl(IntSize), (Map) null, new EnterExitTransitionModifierNode$measure$1(r3), 4, (Object) null);
        }
        Function1<GraphicsLayerScope, Unit> init = this.graphicsLayerBlock.init();
        Placeable r7 = measurable.m5368measureBRTryo0(j);
        long IntSize2 = IntSizeKt.IntSize(r7.getWidth(), r7.getHeight());
        long j4 = AnimationModifierKt.m69isValidozmzZPI(this.lookaheadSize) ? this.lookaheadSize : IntSize2;
        Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
        if (deferredAnimation != null) {
            state = deferredAnimation.animate(this.sizeTransitionSpec, new EnterExitTransitionModifierNode$measure$animSize$1(this, j4));
        }
        if (state != null) {
            IntSize2 = state.getValue().m6794unboximpl();
        }
        long r1 = ConstraintsKt.m6537constrain4WqzIAM(j3, IntSize2);
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2 = this.offsetAnimation;
        long r10 = (deferredAnimation2 == null || (animate2 = deferredAnimation2.animate(EnterExitTransitionModifierNode$measure$offsetDelta$1.INSTANCE, new EnterExitTransitionModifierNode$measure$offsetDelta$2(this, j4))) == null) ? IntOffset.Companion.m6758getZeronOccac() : animate2.getValue().m6757unboximpl();
        Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3 = this.slideAnimation;
        long r32 = (deferredAnimation3 == null || (animate = deferredAnimation3.animate(this.slideSpec, new EnterExitTransitionModifierNode$measure$slideOffset$1(this, j4))) == null) ? IntOffset.Companion.m6758getZeronOccac() : animate.getValue().m6757unboximpl();
        Alignment alignment2 = this.currentAlignment;
        if (alignment2 != null) {
            j2 = alignment2.m3417alignKFBX0sM(j4, r1, LayoutDirection.Ltr);
        } else {
            j2 = IntOffset.Companion.m6758getZeronOccac();
        }
        return MeasureScope.CC.layout$default(measureScope, IntSize.m6790getWidthimpl(r1), IntSize.m6789getHeightimpl(r1), (Map) null, new EnterExitTransitionModifierNode$measure$2(r7, IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j2) + IntOffset.m6748getXimpl(r32), IntOffset.m6749getYimpl(j2) + IntOffset.m6749getYimpl(r32)), r10, init), 4, (Object) null);
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> getSlideSpec() {
        return this.slideSpec;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = r0.getSlideOffset();
     */
    /* renamed from: slideTargetValueByState-oFUgxo0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m93slideTargetValueByStateoFUgxo0(androidx.compose.animation.EnterExitState r4, long r5) {
        /*
            r3 = this;
            androidx.compose.animation.EnterTransition r0 = r3.enter
            androidx.compose.animation.TransitionData r0 = r0.getData$animation_release()
            androidx.compose.animation.Slide r0 = r0.getSlide()
            if (r0 == 0) goto L_0x0021
            kotlin.jvm.functions.Function1 r0 = r0.getSlideOffset()
            if (r0 == 0) goto L_0x0021
            androidx.compose.ui.unit.IntSize r1 = androidx.compose.ui.unit.IntSize.m6782boximpl(r5)
            java.lang.Object r0 = r0.invoke(r1)
            androidx.compose.ui.unit.IntOffset r0 = (androidx.compose.ui.unit.IntOffset) r0
            long r0 = r0.m6757unboximpl()
            goto L_0x0027
        L_0x0021:
            androidx.compose.ui.unit.IntOffset$Companion r0 = androidx.compose.ui.unit.IntOffset.Companion
            long r0 = r0.m6758getZeronOccac()
        L_0x0027:
            androidx.compose.animation.ExitTransition r2 = r3.exit
            androidx.compose.animation.TransitionData r2 = r2.getData$animation_release()
            androidx.compose.animation.Slide r2 = r2.getSlide()
            if (r2 == 0) goto L_0x0048
            kotlin.jvm.functions.Function1 r2 = r2.getSlideOffset()
            if (r2 == 0) goto L_0x0048
            androidx.compose.ui.unit.IntSize r5 = androidx.compose.ui.unit.IntSize.m6782boximpl(r5)
            java.lang.Object r5 = r2.invoke(r5)
            androidx.compose.ui.unit.IntOffset r5 = (androidx.compose.ui.unit.IntOffset) r5
            long r5 = r5.m6757unboximpl()
            goto L_0x004e
        L_0x0048:
            androidx.compose.ui.unit.IntOffset$Companion r5 = androidx.compose.ui.unit.IntOffset.Companion
            long r5 = r5.m6758getZeronOccac()
        L_0x004e:
            int[] r2 = androidx.compose.animation.EnterExitTransitionModifierNode.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r2[r4]
            r2 = 1
            if (r4 == r2) goto L_0x0067
            r2 = 2
            if (r4 == r2) goto L_0x006d
            r0 = 3
            if (r4 != r0) goto L_0x0061
            r0 = r5
            goto L_0x006d
        L_0x0061:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L_0x0067:
            androidx.compose.ui.unit.IntOffset$Companion r4 = androidx.compose.ui.unit.IntOffset.Companion
            long r0 = r4.m6758getZeronOccac()
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionModifierNode.m93slideTargetValueByStateoFUgxo0(androidx.compose.animation.EnterExitState, long):long");
    }
}
