package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\u0000\u001aQ\u0010\u0014\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001aQ\u0010!\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u0010\u0017\u001a\u00020\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060\u001cH\u0007\u001aQ\u0010%\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u0010\u0017\u001a\u00020&2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a\"\u0010)\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010*\u001a\u00020\u0002H\u0007\u001a\"\u0010+\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010,\u001a\u00020\u0002H\u0007\u001a6\u0010-\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a6\u00102\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u00103\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aQ\u00106\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u00108\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001aQ\u00109\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u00107\u001a\u00020\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060\u001cH\u0007\u001aQ\u0010;\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u00107\u001a\u00020&2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010<\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a;\u0010=\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162!\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00040\u001cH\u0007\u001a=\u0010?\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162#\b\u0002\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a=\u0010A\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162#\b\u0002\u0010B\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a;\u0010C\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00040\u001cH\u0007\u001a=\u0010E\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162#\b\u0002\u0010F\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a=\u0010G\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162#\b\u0002\u0010H\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a/\u0010I\u001a\u00020J*\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020PH\u0003¢\u0006\u0002\u0010Q\u001a/\u0010R\u001a\u00020S*\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020PH\u0001¢\u0006\u0002\u0010T\u001a\u001f\u0010U\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u001f\u0010U\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010*\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\f\u0010V\u001a\u00020\"*\u00020\u0018H\u0002\u001a\f\u0010V\u001a\u00020\"*\u00020&H\u0002\u001a\u001f\u0010W\u001a\u00020\f*\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u00020\fH\u0001¢\u0006\u0002\u0010X\u001a\u001f\u0010Y\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010N\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010Z\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006[²\u0006\n\u0010\\\u001a\u00020\fX\u0002²\u0006\n\u0010]\u001a\u00020\u0013X\u0002"}, d2 = {"DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "EnterTransition", "Landroidx/compose/animation/EnterTransition;", "key", "", "node", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/Modifier$Node;", "ExitTransition", "Landroidx/compose/animation/ExitTransition;", "expandHorizontally", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createGraphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "createModifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "get", "toAlignment", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "animation_release", "activeEnter", "activeExit"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
public final class EnterExitTransitionKt {
    /* access modifiers changed from: private */
    public static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), (Slide) null, (ChangeSize) null, (Scale) null, false, (Map) null, 62, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), (Slide) null, (ChangeSize) null, (Scale) null, false, (Map) null, 62, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new EnterTransitionImpl(new TransitionData((Fade) null, new Slide(function1, finiteAnimationSpec), (ChangeSize) null, (Scale) null, false, (Map) null, 61, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new ExitTransitionImpl(new TransitionData((Fade) null, new Slide(function1, finiteAnimationSpec), (ChangeSize) null, (Scale) null, false, (Map) null, 61, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ EnterTransition m74scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m4269getCenterSzJe1aQ();
        }
        return m73scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleIn-L8ZKh-E  reason: not valid java name */
    public static final EnterTransition m73scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(f, j, finiteAnimationSpec, (DefaultConstructorMarker) null), false, (Map) null, 55, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ ExitTransition m76scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m4269getCenterSzJe1aQ();
        }
        return m75scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleOut-L8ZKh-E  reason: not valid java name */
    public static final ExitTransition m75scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(f, j, finiteAnimationSpec, (DefaultConstructorMarker) null), false, (Map) null, 55, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandIn$1.INSTANCE;
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), (Scale) null, false, (Map) null, 59, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkOut$1.INSTANCE;
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), (Scale) null, false, (Map) null, 59, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandHorizontally$1.INSTANCE;
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z, new EnterExitTransitionKt$expandHorizontally$2(function1));
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandVertically$1.INSTANCE;
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z, new EnterExitTransitionKt$expandVertically$2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkHorizontally$1.INSTANCE;
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z, new EnterExitTransitionKt$shrinkHorizontally$2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkVertically$1.INSTANCE;
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z, new EnterExitTransitionKt$shrinkVertically$2(function1));
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInHorizontally$1.INSTANCE;
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new EnterExitTransitionKt$slideInHorizontally$2(function1));
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInVertically$1.INSTANCE;
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new EnterExitTransitionKt$slideInVertically$2(function1));
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutHorizontally$1.INSTANCE;
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new EnterExitTransitionKt$slideOutHorizontally$2(function1));
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutVertically$1.INSTANCE;
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new EnterExitTransitionKt$slideOutVertically$2(function1));
    }

    public static final EnterTransition EnterTransition(Object obj, ModifierNodeElement<? extends Modifier.Node> modifierNodeElement) {
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, false, MapsKt.mapOf(TuplesKt.to(obj, modifierNodeElement)), 31, (DefaultConstructorMarker) null));
    }

    public static final ExitTransition ExitTransition(Object obj, ModifierNodeElement<? extends Modifier.Node> modifierNodeElement) {
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, false, MapsKt.mapOf(TuplesKt.to(obj, modifierNodeElement)), 31, (DefaultConstructorMarker) null));
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        if (Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getStart())) {
            return Alignment.Companion.getCenterStart();
        }
        if (Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getEnd())) {
            return Alignment.Companion.getCenterEnd();
        }
        return Alignment.Companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        if (Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getTop())) {
            return Alignment.Companion.getTopCenter();
        }
        if (Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getBottom())) {
            return Alignment.Companion.getBottomCenter();
        }
        return Alignment.Companion.getCenter();
    }

    public static final ModifierNodeElement<? extends Modifier.Node> get(EnterTransition enterTransition, Object obj) {
        return enterTransition.getData$animation_release().getEffectsMap().get(obj);
    }

    public static final ModifierNodeElement<? extends Modifier.Node> get(ExitTransition exitTransition, Object obj) {
        return exitTransition.getData$animation_release().getEffectsMap().get(obj);
    }

    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, String str, Composer composer, int i) {
        Transition.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation;
        String str2;
        int i2;
        Transition.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation2;
        ChangeSize changeSize;
        Transition<EnterExitState> transition2 = transition;
        String str3 = str;
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(914000546);
        ComposerKt.sourceInformation(composer2, "C(createModifier)856@37697L31,857@37750L28,882@38722L56:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(914000546, i3, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:855)");
        }
        int i4 = i3 & 14;
        EnterTransition trackActiveEnter = trackActiveEnter(transition2, enterTransition, composer2, i3 & 126);
        ExitTransition trackActiveExit = trackActiveExit(transition2, exitTransition, composer2, ((i3 >> 3) & 112) | i4);
        boolean z = (trackActiveEnter.getData$animation_release().getSlide() == null && trackActiveExit.getData$animation_release().getSlide() == null) ? false : true;
        boolean z2 = (trackActiveEnter.getData$animation_release().getChangeSize() == null && trackActiveExit.getData$animation_release().getChangeSize() == null) ? false : true;
        composer2.startReplaceableGroup(1657242209);
        ComposerKt.sourceInformation(composer2, "864@38100L27,864@38049L79");
        Transition.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3 = null;
        if (z) {
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = str3 + " slide";
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            i2 = -492369756;
            str2 = "CC(remember):Composables.kt#9igjgp";
            deferredAnimation = TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) rememberedValue, composer, i4 | 448, 0);
        } else {
            i2 = -492369756;
            str2 = "CC(remember):Composables.kt#9igjgp";
            deferredAnimation = null;
        }
        composer.endReplaceableGroup();
        composer2.startReplaceableGroup(1657242379);
        ComposerKt.sourceInformation(composer2, "869@38273L35,869@38224L85");
        if (z2) {
            TwoWayConverter<IntSize, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.Companion);
            composer2.startReplaceableGroup(i2);
            ComposerKt.sourceInformation(composer2, str2);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = str3 + " shrink/expand";
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            deferredAnimation2 = TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) rememberedValue2, composer, i4 | 448, 0);
        } else {
            deferredAnimation2 = null;
        }
        composer.endReplaceableGroup();
        composer2.startReplaceableGroup(1657242547);
        ComposerKt.sourceInformation(composer2, "875@38468L48,873@38392L134");
        if (z2) {
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter3 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            composer2.startReplaceableGroup(i2);
            ComposerKt.sourceInformation(composer2, str2);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = str3 + " InterruptionHandlingOffset";
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceableGroup();
            deferredAnimation3 = TransitionKt.createDeferredAnimation(transition, vectorConverter3, (String) rememberedValue3, composer, i4 | 448, 0);
        }
        composer.endReplaceableGroup();
        ChangeSize changeSize2 = trackActiveEnter.getData$animation_release().getChangeSize();
        Modifier then = GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, !((changeSize2 != null && !changeSize2.getClip()) || ((changeSize = trackActiveExit.getData$animation_release().getChangeSize()) != null && !changeSize.getClip()) || !z2), (RenderEffect) null, 0, 0, 0, 126975, (Object) null).then(new EnterExitTransitionElement(transition, deferredAnimation2, deferredAnimation3, deferredAnimation, trackActiveEnter, trackActiveExit, createGraphicsLayerBlock(transition, trackActiveEnter, trackActiveExit, str, composer, i3 & 7182)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }

    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> transition, EnterTransition enterTransition, Composer composer, int i) {
        composer.startReplaceableGroup(21614502);
        ComposerKt.sourceInformation(composer, "C(trackActiveEnter)899@39573L40:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21614502, i, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:894)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enterTransition, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                trackActiveEnter$lambda$5(mutableState, enterTransition);
            } else {
                trackActiveEnter$lambda$5(mutableState, EnterTransition.Companion.getNone());
            }
        } else if (transition.getTargetState() == EnterExitState.Visible) {
            trackActiveEnter$lambda$5(mutableState, trackActiveEnter$lambda$4(mutableState).plus(enterTransition));
        }
        EnterTransition trackActiveEnter$lambda$4 = trackActiveEnter$lambda$4(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return trackActiveEnter$lambda$4;
    }

    private static final EnterTransition trackActiveEnter$lambda$4(MutableState<EnterTransition> mutableState) {
        return (EnterTransition) mutableState.getValue();
    }

    public static final ExitTransition trackActiveExit(Transition<EnterExitState> transition, ExitTransition exitTransition, Composer composer, int i) {
        composer.startReplaceableGroup(-1363864804);
        ComposerKt.sourceInformation(composer, "C(trackActiveExit)919@40554L39:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1363864804, i, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:914)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(exitTransition, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                trackActiveExit$lambda$8(mutableState, exitTransition);
            } else {
                trackActiveExit$lambda$8(mutableState, ExitTransition.Companion.getNone());
            }
        } else if (transition.getTargetState() != EnterExitState.Visible) {
            trackActiveExit$lambda$8(mutableState, trackActiveExit$lambda$7(mutableState).plus(exitTransition));
        }
        ExitTransition trackActiveExit$lambda$7 = trackActiveExit$lambda$7(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return trackActiveExit$lambda$7;
    }

    private static final ExitTransition trackActiveExit$lambda$7(MutableState<ExitTransition> mutableState) {
        return (ExitTransition) mutableState.getValue();
    }

    private static final GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, String str, Composer composer, int i) {
        Transition.DeferredAnimation<Float, AnimationVector1D> deferredAnimation;
        Transition.DeferredAnimation<Float, AnimationVector1D> deferredAnimation2;
        String str2 = str;
        Composer composer2 = composer;
        int i2 = i;
        composer2.startReplaceableGroup(642253525);
        ComposerKt.sourceInformation(composer2, "C(createGraphicsLayerBlock)963@42205L136:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(642253525, i2, -1, "androidx.compose.animation.createGraphicsLayerBlock (EnterExitTransition.kt:942)");
        }
        boolean z = (enterTransition.getData$animation_release().getFade() == null && exitTransition.getData$animation_release().getFade() == null) ? false : true;
        boolean z2 = (enterTransition.getData$animation_release().getScale() == null && exitTransition.getData$animation_release().getScale() == null) ? false : true;
        composer2.startReplaceableGroup(-1158245383);
        ComposerKt.sourceInformation(composer2, "952@41884L27,951@41801L120");
        Transition.DeferredAnimation<TransformOrigin, AnimationVector2D> deferredAnimation3 = null;
        if (z) {
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = str2 + " alpha";
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            deferredAnimation = TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) rememberedValue, composer, (i2 & 14) | 448, 0);
        } else {
            deferredAnimation = null;
        }
        composer.endReplaceableGroup();
        composer2.startReplaceableGroup(-1158245186);
        ComposerKt.sourceInformation(composer2, "958@42081L27,957@41998L120");
        if (z2) {
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = str2 + " scale";
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            deferredAnimation2 = TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) rememberedValue2, composer, (i2 & 14) | 448, 0);
        } else {
            deferredAnimation2 = null;
        }
        composer.endReplaceableGroup();
        if (z2) {
            deferredAnimation3 = TransitionKt.createDeferredAnimation(transition, TransformOriginVectorConverter, "TransformOriginInterruptionHandling", composer, (i2 & 14) | 448, 0);
        }
        EnterExitTransitionKt$$ExternalSyntheticLambda0 enterExitTransitionKt$$ExternalSyntheticLambda0 = new EnterExitTransitionKt$$ExternalSyntheticLambda0(deferredAnimation, deferredAnimation2, transition, enterTransition, exitTransition, deferredAnimation3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return enterExitTransitionKt$$ExternalSyntheticLambda0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.jvm.functions.Function1 createGraphicsLayerBlock$lambda$11(androidx.compose.animation.core.Transition.DeferredAnimation r3, androidx.compose.animation.core.Transition.DeferredAnimation r4, androidx.compose.animation.core.Transition r5, androidx.compose.animation.EnterTransition r6, androidx.compose.animation.ExitTransition r7, androidx.compose.animation.core.Transition.DeferredAnimation r8) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0016
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$alpha$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$alpha$1
            r1.<init>(r6, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$alpha$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$alpha$2
            r2.<init>(r6, r7)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.State r3 = r3.animate(r1, r2)
            goto L_0x0017
        L_0x0016:
            r3 = r0
        L_0x0017:
            if (r4 == 0) goto L_0x002c
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$scale$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$scale$1
            r1.<init>(r6, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$scale$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$scale$2
            r2.<init>(r6, r7)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.State r4 = r4.animate(r1, r2)
            goto L_0x002d
        L_0x002c:
            r4 = r0
        L_0x002d:
            java.lang.Object r5 = r5.getCurrentState()
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter
            if (r5 != r1) goto L_0x0053
            androidx.compose.animation.TransitionData r5 = r6.getData$animation_release()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L_0x0048
        L_0x003f:
            long r1 = r5.m102getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m4256boximpl(r1)
            goto L_0x0072
        L_0x0048:
            androidx.compose.animation.TransitionData r5 = r7.getData$animation_release()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L_0x0071
            goto L_0x003f
        L_0x0053:
            androidx.compose.animation.TransitionData r5 = r7.getData$animation_release()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L_0x0066
        L_0x005d:
            long r1 = r5.m102getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m4256boximpl(r1)
            goto L_0x0072
        L_0x0066:
            androidx.compose.animation.TransitionData r5 = r6.getData$animation_release()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L_0x0071
            goto L_0x005d
        L_0x0071:
            r5 = r0
        L_0x0072:
            if (r8 == 0) goto L_0x0083
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$transformOrigin$1 r0 = androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$transformOrigin$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$transformOrigin$2 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$transformOrigin$2
            r1.<init>(r5, r6, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.runtime.State r0 = r8.animate(r0, r1)
        L_0x0083:
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$block$1 r5 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$block$1
            r5.<init>(r3, r4, r0)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock$lambda$11(androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, androidx.compose.animation.core.Transition$DeferredAnimation):kotlin.jvm.functions.Function1");
    }

    private static final void trackActiveEnter$lambda$5(MutableState<EnterTransition> mutableState, EnterTransition enterTransition) {
        mutableState.setValue(enterTransition);
    }

    private static final void trackActiveExit$lambda$8(MutableState<ExitTransition> mutableState, ExitTransition exitTransition) {
        mutableState.setValue(exitTransition);
    }
}
