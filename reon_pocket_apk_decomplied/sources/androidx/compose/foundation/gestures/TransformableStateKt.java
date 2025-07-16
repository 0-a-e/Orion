package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.TransformableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\u0000\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003\u001aZ\u0010\f\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007¢\u0006\u0002\u0010\r\u001a/\u0010\u000e\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0014\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H@¢\u0006\u0002\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H@¢\u0006\u0002\u0010\u0016\u001a\u001f\u0010\u0019\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001a\u0010\u001c\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0004H@¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\u000b*\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 H@¢\u0006\u0002\u0010!\u001a\u001a\u0010\"\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0004H@¢\u0006\u0002\u0010\u001d\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animatePanBy", "offset", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateZoomBy", "zoomFactor", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zoomBy", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformableState.kt */
public final class TransformableStateKt {
    public static final TransformableState TransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        return new DefaultTransformableState(function3);
    }

    public static final TransformableState rememberTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> function3, Composer composer, int i) {
        composer.startReplaceableGroup(1681419281);
        ComposerKt.sourceInformation(composer, "C(rememberTransformableState)117@5191L38,118@5241L80:TransformableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:116)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = TransformableState(new TransformableStateKt$rememberTransformableState$1$1(rememberUpdatedState));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TransformableState transformableState = (TransformableState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transformableState;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, (Object) null, 5, (DefaultConstructorMarker) null);
        }
        return animateZoomBy(transformableState, f, animationSpec, continuation);
    }

    public static final Object animateZoomBy(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        if (f > 0.0f) {
            Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = 1.0f;
            Object transform$default = TransformableState.CC.transform$default(transformableState, (MutatePriority) null, new TransformableStateKt$animateZoomBy$3(floatRef, f, animationSpec, (Continuation<? super TransformableStateKt$animateZoomBy$3>) null), continuation, 1, (Object) null);
            return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
        }
        throw new IllegalArgumentException("zoom value should be greater than 0".toString());
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, (Object) null, 5, (DefaultConstructorMarker) null);
        }
        return animateRotateBy(transformableState, f, animationSpec, continuation);
    }

    public static final Object animateRotateBy(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object transform$default = TransformableState.CC.transform$default(transformableState, (MutatePriority) null, new TransformableStateKt$animateRotateBy$2(new Ref.FloatRef(), f, animationSpec, (Continuation<? super TransformableStateKt$animateRotateBy$2>) null), continuation, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    /* renamed from: animatePanBy-ubNVwUQ$default  reason: not valid java name */
    public static /* synthetic */ Object m488animatePanByubNVwUQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, (Object) null, 5, (DefaultConstructorMarker) null);
        }
        return m487animatePanByubNVwUQ(transformableState, j, animationSpec, continuation);
    }

    /* renamed from: animatePanBy-ubNVwUQ  reason: not valid java name */
    public static final Object m487animatePanByubNVwUQ(TransformableState transformableState, long j, AnimationSpec<Offset> animationSpec, Continuation<? super Unit> continuation) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.Companion.m3578getZeroF1C5BW0();
        Object transform$default = TransformableState.CC.transform$default(transformableState, (MutatePriority) null, new TransformableStateKt$animatePanBy$2(longRef, j, animationSpec, (Continuation<? super TransformableStateKt$animatePanBy$2>) null), continuation, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    public static final Object zoomBy(TransformableState transformableState, float f, Continuation<? super Unit> continuation) {
        Object transform$default = TransformableState.CC.transform$default(transformableState, (MutatePriority) null, new TransformableStateKt$zoomBy$2(f, (Continuation<? super TransformableStateKt$zoomBy$2>) null), continuation, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    public static final Object rotateBy(TransformableState transformableState, float f, Continuation<? super Unit> continuation) {
        Object transform$default = TransformableState.CC.transform$default(transformableState, (MutatePriority) null, new TransformableStateKt$rotateBy$2(f, (Continuation<? super TransformableStateKt$rotateBy$2>) null), continuation, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    /* renamed from: panBy-d-4ec7I  reason: not valid java name */
    public static final Object m489panByd4ec7I(TransformableState transformableState, long j, Continuation<? super Unit> continuation) {
        Object transform$default = TransformableState.CC.transform$default(transformableState, (MutatePriority) null, new TransformableStateKt$panBy$2(j, (Continuation<? super TransformableStateKt$panBy$2>) null), continuation, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, continuation);
    }

    public static final Object stopTransformation(TransformableState transformableState, MutatePriority mutatePriority, Continuation<? super Unit> continuation) {
        Object transform = transformableState.transform(mutatePriority, new TransformableStateKt$stopTransformation$2((Continuation<? super TransformableStateKt$stopTransformation$2>) null), continuation);
        return transform == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform : Unit.INSTANCE;
    }
}
