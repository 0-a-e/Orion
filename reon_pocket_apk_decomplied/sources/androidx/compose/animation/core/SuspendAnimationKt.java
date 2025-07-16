package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0001\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u000b2\u0006\u0010\f\u001a\u0002H\u00072\u0006\u0010\r\u001a\u0002H\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@¢\u0006\u0002\u0010\u0017\u001ap\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@¢\u0006\u0002\u0010\u0018\u001a^\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001a26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@¢\u0006\u0002\u0010\u001b\u001as\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@¢\u0006\u0002\u0010$\u001am\u0010\u0019\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070%2\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@¢\u0006\u0002\u0010(\u001aw\u0010)\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0006\u0010\r\u001a\u0002H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00102\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@¢\u0006\u0002\u0010*\u001aW\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\u0007\"\b\b\u0002\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H,0!H@¢\u0006\u0002\u0010/\u001a\u0001\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a\u0001\u00104\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010\u0000\u001a\u00020\u00012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a<\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001cH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u00066"}, d2 = {"durationScale", "", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "animate", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "playTimeNanos", "anim", "state", "doAnimationFrameWithScale", "updateState", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendAnimation.kt */
public final class SuspendAnimationKt {
    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        float f4 = (i & 4) != 0 ? 0.0f : f3;
        if ((i & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        return animate(f, f2, f4, animationSpec, function2, continuation);
    }

    public static final Object animate(float f, float f2, float f3, AnimationSpec<Float> animationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object animate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(f), Boxing.boxFloat(f2), Boxing.boxFloat(f3), animationSpec, function2, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static final Object animateDecay(float f, float f2, FloatDecayAnimationSpec floatDecayAnimationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        float f3 = f;
        float f4 = f2;
        Object animate$default = animate$default(AnimationStateKt.AnimationState$default(f3, f4, 0, 0, false, 28, (Object) null), AnimationKt.DecayAnimation(floatDecayAnimationSpec, f3, f4), 0, new SuspendAnimationKt$animateDecay$2(function2), continuation, 2, (Object) null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj4) {
        AnimationSpec animationSpec2;
        Object obj5 = (i & 8) != 0 ? null : obj3;
        if ((i & 16) != 0) {
            animationSpec2 = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        } else {
            animationSpec2 = animationSpec;
        }
        return animate(twoWayConverter, obj, obj2, obj5, animationSpec2, function2, continuation);
    }

    public static final <T, V extends AnimationVector> Object animate(TwoWayConverter<T, V> twoWayConverter, T t, T t2, T t3, AnimationSpec<T> animationSpec, Function2<? super T, ? super T, Unit> function2, Continuation<? super Unit> continuation) {
        AnimationVector animationVector;
        T t4 = t3;
        if (t4 == null || (animationVector = (AnimationVector) twoWayConverter.getConvertToVector().invoke(t4)) == null) {
            animationVector = AnimationVectorsKt.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(t));
        } else {
            T t5 = t;
        }
        TwoWayConverter<T, V> twoWayConverter2 = twoWayConverter;
        Object animate$default = animate$default(new AnimationState(twoWayConverter, t, animationVector, 0, 0, false, 56, (DefaultConstructorMarker) null), new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, animationVector), 0, new SuspendAnimationKt$animate$3(function2, twoWayConverter), continuation, 2, (Object) null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = SuspendAnimationKt$animateTo$2.INSTANCE;
        }
        return animateTo(animationState, obj, animationSpec2, z2, function1, continuation);
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> animationState, T t, AnimationSpec<T> animationSpec, boolean z, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t, animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = SuspendAnimationKt$animateDecay$4.INSTANCE;
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, (Continuation<? super Unit>) continuation);
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> animationState, DecayAnimationSpec<T> decayAnimationSpec, boolean z, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new DecayAnimation(decayAnimationSpec, animationState.getTypeConverter(), animationState.getValue(), animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f4 A[Catch:{ CancellationException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0120 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(androidx.compose.animation.core.AnimationState<T, V> r25, androidx.compose.animation.core.Animation<T, V> r26, long r27, kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, kotlin.Unit> r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            r9 = r25
            r0 = r26
            r1 = r30
            boolean r2 = r1 instanceof androidx.compose.animation.core.SuspendAnimationKt$animate$4
            if (r2 == 0) goto L_0x001a
            r2 = r1
            androidx.compose.animation.core.SuspendAnimationKt$animate$4 r2 = (androidx.compose.animation.core.SuspendAnimationKt$animate$4) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001a
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001f
        L_0x001a:
            androidx.compose.animation.core.SuspendAnimationKt$animate$4 r2 = new androidx.compose.animation.core.SuspendAnimationKt$animate$4
            r2.<init>(r1)
        L_0x001f:
            r10 = r2
            java.lang.Object r1 = r10.result
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r12 = 2
            r13 = 1
            if (r2 == 0) goto L_0x0066
            if (r2 == r13) goto L_0x004a
            if (r2 != r12) goto L_0x0042
            java.lang.Object r0 = r10.L$3
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r10.L$2
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r3 = r10.L$1
            androidx.compose.animation.core.Animation r3 = (androidx.compose.animation.core.Animation) r3
            java.lang.Object r4 = r10.L$0
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4
            goto L_0x005b
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004a:
            java.lang.Object r0 = r10.L$3
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r10.L$2
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r3 = r10.L$1
            androidx.compose.animation.core.Animation r3 = (androidx.compose.animation.core.Animation) r3
            java.lang.Object r4 = r10.L$0
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ CancellationException -> 0x0062 }
            r8 = r0
            r0 = r3
            goto L_0x00e7
        L_0x0062:
            r0 = move-exception
            r9 = r4
            goto L_0x0128
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = 0
            java.lang.Object r15 = r0.getValueFromNanos(r1)
            androidx.compose.animation.core.AnimationVector r17 = r0.getVelocityVectorFromNanos(r1)
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            r1 = -9223372036854775808
            int r1 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00ae
            kotlin.coroutines.CoroutineContext r1 = r10.getContext()     // Catch:{ CancellationException -> 0x0126 }
            float r7 = getDurationScale(r1)     // Catch:{ CancellationException -> 0x0126 }
            androidx.compose.animation.core.SuspendAnimationKt$animate$6 r16 = new androidx.compose.animation.core.SuspendAnimationKt$animate$6     // Catch:{ CancellationException -> 0x0126 }
            r1 = r16
            r2 = r14
            r3 = r15
            r4 = r26
            r5 = r17
            r6 = r25
            r8 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ CancellationException -> 0x0126 }
            r1 = r16
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1     // Catch:{ CancellationException -> 0x0126 }
            r10.L$0 = r9     // Catch:{ CancellationException -> 0x0126 }
            r10.L$1 = r0     // Catch:{ CancellationException -> 0x0126 }
            r8 = r29
            r10.L$2 = r8     // Catch:{ CancellationException -> 0x0126 }
            r10.L$3 = r14     // Catch:{ CancellationException -> 0x0126 }
            r10.label = r13     // Catch:{ CancellationException -> 0x0126 }
            java.lang.Object r1 = callWithFrameNanos(r0, r1, r10)     // Catch:{ CancellationException -> 0x0126 }
            if (r1 != r11) goto L_0x00e5
            return r11
        L_0x00ae:
            r8 = r29
            androidx.compose.animation.core.AnimationScope r13 = new androidx.compose.animation.core.AnimationScope     // Catch:{ CancellationException -> 0x0126 }
            androidx.compose.animation.core.TwoWayConverter r16 = r26.getTypeConverter()     // Catch:{ CancellationException -> 0x0126 }
            java.lang.Object r20 = r26.getTargetValue()     // Catch:{ CancellationException -> 0x0126 }
            androidx.compose.animation.core.SuspendAnimationKt$animate$7 r1 = new androidx.compose.animation.core.SuspendAnimationKt$animate$7     // Catch:{ CancellationException -> 0x0126 }
            r1.<init>(r9)     // Catch:{ CancellationException -> 0x0126 }
            r24 = r1
            kotlin.jvm.functions.Function0 r24 = (kotlin.jvm.functions.Function0) r24     // Catch:{ CancellationException -> 0x0126 }
            r23 = 1
            r7 = r14
            r14 = r13
            r18 = r27
            r21 = r27
            r14.<init>(r15, r16, r17, r18, r20, r21, r23, r24)     // Catch:{ CancellationException -> 0x0123 }
            kotlin.coroutines.CoroutineContext r1 = r10.getContext()     // Catch:{ CancellationException -> 0x0123 }
            float r4 = getDurationScale(r1)     // Catch:{ CancellationException -> 0x0123 }
            r1 = r13
            r2 = r27
            r5 = r26
            r6 = r25
            r14 = r7
            r7 = r29
            doAnimationFrameWithScale(r1, r2, r4, r5, r6, r7)     // Catch:{ CancellationException -> 0x0126 }
            r14.element = r13     // Catch:{ CancellationException -> 0x0126 }
        L_0x00e5:
            r4 = r9
            r2 = r14
        L_0x00e7:
            T r1 = r2.element     // Catch:{ CancellationException -> 0x0062 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ CancellationException -> 0x0062 }
            androidx.compose.animation.core.AnimationScope r1 = (androidx.compose.animation.core.AnimationScope) r1     // Catch:{ CancellationException -> 0x0062 }
            boolean r1 = r1.isRunning()     // Catch:{ CancellationException -> 0x0062 }
            if (r1 == 0) goto L_0x0120
            kotlin.coroutines.CoroutineContext r1 = r10.getContext()     // Catch:{ CancellationException -> 0x0062 }
            float r1 = getDurationScale(r1)     // Catch:{ CancellationException -> 0x0062 }
            androidx.compose.animation.core.SuspendAnimationKt$animate$9 r3 = new androidx.compose.animation.core.SuspendAnimationKt$animate$9     // Catch:{ CancellationException -> 0x0062 }
            r25 = r3
            r26 = r2
            r27 = r1
            r28 = r0
            r29 = r4
            r30 = r8
            r25.<init>(r26, r27, r28, r29, r30)     // Catch:{ CancellationException -> 0x0062 }
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ CancellationException -> 0x0062 }
            r10.L$0 = r4     // Catch:{ CancellationException -> 0x0062 }
            r10.L$1 = r0     // Catch:{ CancellationException -> 0x0062 }
            r10.L$2 = r8     // Catch:{ CancellationException -> 0x0062 }
            r10.L$3 = r2     // Catch:{ CancellationException -> 0x0062 }
            r10.label = r12     // Catch:{ CancellationException -> 0x0062 }
            java.lang.Object r1 = callWithFrameNanos(r0, r3, r10)     // Catch:{ CancellationException -> 0x0062 }
            if (r1 != r11) goto L_0x00e7
            return r11
        L_0x0120:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0123:
            r0 = move-exception
            r14 = r7
            goto L_0x0127
        L_0x0126:
            r0 = move-exception
        L_0x0127:
            r2 = r14
        L_0x0128:
            T r1 = r2.element
            androidx.compose.animation.core.AnimationScope r1 = (androidx.compose.animation.core.AnimationScope) r1
            r3 = 0
            if (r1 != 0) goto L_0x0130
            goto L_0x0133
        L_0x0130:
            r1.setRunning$animation_core_release(r3)
        L_0x0133:
            T r1 = r2.element
            androidx.compose.animation.core.AnimationScope r1 = (androidx.compose.animation.core.AnimationScope) r1
            if (r1 == 0) goto L_0x0148
            long r1 = r1.getLastFrameTimeNanos()
            long r4 = r9.getLastFrameTimeNanos()
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0148
            r9.setRunning$animation_core_release(r3)
        L_0x0148:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MIN_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            function1 = SuspendAnimationKt$animate$5.INSTANCE;
        }
        return animate(animationState, animation, j2, function1, continuation);
    }

    /* access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        if (animation.isInfinite()) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation);
        }
        return MonotonicFrameClockKt.withFrameNanos(new SuspendAnimationKt$callWithFrameNanos$2(function1), continuation);
    }

    public static final float getDurationScale(CoroutineContext coroutineContext) {
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(MotionDurationScale.Key);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (scaleFactor >= 0.0f) {
            return scaleFactor;
        }
        throw new IllegalStateException("negative scale factor".toString());
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> animationScope, AnimationState<T, V> animationState) {
        animationState.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(animationState.getVelocityVector(), animationScope.getVelocityVector());
        animationState.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        animationState.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        animationState.setRunning$animation_core_release(animationScope.isRunning());
    }

    /* access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long j, float f, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        long j2;
        if (f == 0.0f) {
            j2 = animation.getDurationNanos();
        } else {
            j2 = (long) (((float) (j - animationScope.getStartTimeNanos())) / f);
        }
        doAnimationFrame(animationScope, j, j2, animation, animationState, function1);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long j, long j2, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(j2));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(j2));
        if (animation.isFinishedFromNanos(j2)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }
}
