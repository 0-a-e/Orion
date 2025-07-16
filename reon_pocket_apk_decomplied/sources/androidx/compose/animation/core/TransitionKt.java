package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\t\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u000b\u001a\u0002H\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\f\u001a3\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00032*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00032*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001f0\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00032*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00032*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\"0\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00032*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020$0\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00032*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020&0\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00032*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020(0\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00032*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020*0\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u0010\u001d\u001a¦\u0001\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0010\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010,*\u00020-*\b\u0012\u0004\u0012\u0002H\u00120\u00032\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H,0/2*\b\n\u0010\u0013\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u0010\u0019\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00040\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u00100\u001a\\\u00101\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00120\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2&\u00102\u001a\"\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(3\u0012\u0004\u0012\u0002H\u00040\u0014¢\u0006\u0002\b\u0017H\b¢\u0006\u0002\u00104\u001aA\u00105\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00120\u00032\u0006\u00106\u001a\u0002H\u00042\u0006\u0010\u000b\u001a\u0002H\u00042\u0006\u00107\u001a\u00020\bH\u0001¢\u0006\u0002\u00108\u001aa\u00109\u001a\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H,0:R\b\u0012\u0004\u0012\u0002H\u00120\u0003\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010,*\u00020-*\b\u0012\u0004\u0012\u0002H\u00120\u00032\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H,0/2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010;\u001am\u0010<\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0010\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010,*\u00020-*\b\u0012\u0004\u0012\u0002H\u00120\u00032\u0006\u0010=\u001a\u0002H\u00042\u0006\u0010>\u001a\u0002H\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00162\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H,0/2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010@\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"AnimationDebugDurationScale", "", "rememberTransition", "Landroidx/compose/animation/core/Transition;", "T", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "label", "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "updateTransition", "targetState", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "S", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;

    public static final <T> Transition<T> updateTransition(T t, String str, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(2029166765);
        ComposerKt.sourceInformation(composer, "C(updateTransition)P(1)74@3063L51,75@3130L22,76@3157L224:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:73)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition(t, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition = (Transition) rememberedValue;
        transition.animateTo$animation_core_release(t, composer, (i & 8) | 48 | (i & 14));
        composer.startReplaceableGroup(1951093734);
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new TransitionKt$updateTransition$1$1(transition);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition;
    }

    public static final <T> Transition<T> rememberTransition(TransitionState<T> transitionState, String str, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1643203617);
        ComposerKt.sourceInformation(composer, "C(rememberTransition)P(1)317@12686L94,320@12796L38,321@12839L224:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1643203617, i, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:316)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) transitionState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition(transitionState, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition = (Transition) rememberedValue;
        transition.animateTo$animation_core_release(transitionState.getTargetState(), composer, 0);
        composer.startReplaceableGroup(1951103416);
        boolean changed2 = composer.changed((Object) transition);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new TransitionKt$rememberTransition$1$1(transition);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition;
    }

    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> mutableTransitionState, String str, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(882913843);
        ComposerKt.sourceInformation(composer, "C(updateTransition)P(1)357@14430L32:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:355)");
        }
        Transition<T> rememberTransition = rememberTransition(mutableTransitionState, str, composer, i & 126, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberTransition;
    }

    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1714122528);
        ComposerKt.sourceInformation(composer, "C(createDeferredAnimation)P(1)977@38433L58,978@38496L102:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, i, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:976)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition.DeferredAnimation(twoWayConverter, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) rememberedValue;
        EffectsKt.DisposableEffect((Object) deferredAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new TransitionKt$createDeferredAnimation$1(transition, deferredAnimation), composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return deferredAnimation;
    }

    public static final <S, T> Transition<T> createChildTransition(Transition<S> transition, String str, Function3<? super S, ? super Composer, ? super Integer, ? extends T> function3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1215497572);
        ComposerKt.sourceInformation(composer, "CC(createChildTransition)1010@39937L36,1011@39997L74,1012@40094L39,1013@40145L63:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            str = "ChildTransition";
        }
        String str2 = str;
        int i3 = i & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) transition);
        S rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = transition.getCurrentState();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        if (transition.isSeeking()) {
            rememberedValue = transition.getCurrentState();
        }
        int i4 = (i >> 3) & 112;
        Transition<T> createChildTransitionInternal = createChildTransitionInternal(transition, function3.invoke(rememberedValue, composer, Integer.valueOf(i4)), function3.invoke(transition.getTargetState(), composer, Integer.valueOf(i4)), str2, composer, i3 | ((i << 6) & 7168));
        composer.endReplaceableGroup();
        return createChildTransitionInternal;
    }

    public static final <S, T> Transition<T> createChildTransitionInternal(Transition<S> transition, T t, T t2, String str, Composer composer, int i) {
        composer.startReplaceableGroup(-198307638);
        ComposerKt.sourceInformation(composer, "C(createChildTransitionInternal)P(1,2)1023@40408L110,1027@40524L141,1041@40887L25:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1022)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            MutableTransitionState mutableTransitionState = new MutableTransitionState(t);
            rememberedValue = new Transition(mutableTransitionState, transition.getLabel() + " > " + str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition2 = (Transition) rememberedValue;
        composer.startReplaceableGroup(1951131101);
        boolean changed2 = composer.changed((Object) transition) | composer.changed((Object) transition2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new TransitionKt$createChildTransitionInternal$1$1(transition, transition2);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t, t2, transition.getLastSeekedTimeNanos$animation_core_release());
        } else {
            transition2.updateTarget$animation_core_release(t2, composer, ((i >> 3) & 8) | ((i >> 6) & 14));
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transition2;
    }

    public static final <S, T, V extends AnimationVector> State<T> animateValue(Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, ? extends T> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        if ((i2 & 2) != 0) {
            function3 = TransitionKt$animateValue$1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            str = "ValueAnimation";
        }
        int i3 = (i >> 9) & 112;
        Transition<S> transition2 = transition;
        TwoWayConverter<T, V> twoWayConverter2 = twoWayConverter;
        State<T> createTransitionAnimation = createTransitionAnimation(transition2, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i3)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i3)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i >> 3) & 112)), twoWayConverter2, str, composer, (i & 14) | (57344 & (i << 9)) | ((i << 6) & 458752));
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.compose.animation.core.Transition$TransitionAnimationState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.animation.core.Transition$TransitionAnimationState} */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0034;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.runtime.State<T> createTransitionAnimation(androidx.compose.animation.core.Transition<S> r7, T r8, T r9, androidx.compose.animation.core.FiniteAnimationSpec<T> r10, androidx.compose.animation.core.TwoWayConverter<T, V> r11, java.lang.String r12, androidx.compose.runtime.Composer r13, int r14) {
        /*
            r0 = -304821198(0xffffffffedd4cc32, float:-8.23221E27)
            r13.startReplaceableGroup(r0)
            java.lang.String r1 = "C(createTransitionAnimation)P(1,3!1,4)1098@43468L499,1121@44313L166:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1097)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x0017:
            r14 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r14)
            boolean r14 = r13.changed((java.lang.Object) r7)
            java.lang.Object r0 = r13.rememberedValue()
            if (r14 != 0) goto L_0x0034
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r0 != r14) goto L_0x0045
        L_0x0034:
            androidx.compose.animation.core.Transition$TransitionAnimationState r0 = new androidx.compose.animation.core.Transition$TransitionAnimationState
            androidx.compose.animation.core.AnimationVector r4 = androidx.compose.animation.core.AnimationStateKt.createZeroVectorFrom(r11, r9)
            r1 = r0
            r2 = r7
            r3 = r8
            r5 = r11
            r6 = r12
            r1.<init>(r3, r4, r5, r6)
            r13.updateRememberedValue(r0)
        L_0x0045:
            r13.endReplaceableGroup()
            androidx.compose.animation.core.Transition$TransitionAnimationState r0 = (androidx.compose.animation.core.Transition.TransitionAnimationState) r0
            boolean r11 = r7.isSeeking()
            if (r11 == 0) goto L_0x0054
            r0.updateInitialAndTargetValue$animation_core_release(r8, r9, r10)
            goto L_0x0057
        L_0x0054:
            r0.updateTargetValue$animation_core_release(r9, r10)
        L_0x0057:
            r8 = 1951134899(0x744bf4b3, float:6.463619E31)
            r13.startReplaceableGroup(r8)
            boolean r8 = r13.changed((java.lang.Object) r7)
            boolean r9 = r13.changed((java.lang.Object) r0)
            r8 = r8 | r9
            java.lang.Object r9 = r13.rememberedValue()
            if (r8 != 0) goto L_0x0074
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x007f
        L_0x0074:
            androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1 r8 = new androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1
            r8.<init>(r7, r0)
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r13.updateRememberedValue(r9)
        L_0x007f:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r13.endReplaceableGroup()
            r7 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r9, (androidx.compose.runtime.Composer) r13, (int) r7)
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0091
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0091:
            r13.endReplaceableGroup()
            androidx.compose.runtime.State r0 = (androidx.compose.runtime.State) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.TransitionKt.createTransitionAnimation(androidx.compose.animation.core.Transition, java.lang.Object, java.lang.Object, androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.TwoWayConverter, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    public static final <S> State<Float> animateFloat(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Float> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation(composer, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateFloat$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        State<Float> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Dp> animateDp(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Dp> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(184732935);
        ComposerKt.sourceInformation(composer, "CC(animateDp)P(2)1196@48083L75:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateDp$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        State<Dp> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Offset> animateOffset(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Offset> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(2078477582);
        ComposerKt.sourceInformation(composer, "CC(animateOffset)P(2)1227@49823L79:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateOffset$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        State<Offset> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Size> animateSize(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Size> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-802210820);
        ComposerKt.sourceInformation(composer, "CC(animateSize)P(2)1258@51552L77:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateSize$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<Size, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Size.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        State<Size> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<IntOffset> animateIntOffset(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, IntOffset> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(776131825);
        ComposerKt.sourceInformation(composer, "CC(animateIntOffset)P(2)1289@53300L82:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateIntOffset$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        State<IntOffset> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Integer> animateInt(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Integer> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1318902782);
        ComposerKt.sourceInformation(composer, "CC(animateInt)P(2)1320@55003L76:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateInt$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        State<Integer> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<IntSize> animateIntSize(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, IntSize> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2104123233);
        ComposerKt.sourceInformation(composer, "CC(animateIntSize)P(2)1350@56732L80:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateIntSize$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        State<IntSize> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Rect> animateRect(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Rect> function32, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1496278239);
        ComposerKt.sourceInformation(composer, "CC(animateRect)P(2)1380@58458L77:Transition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            function3 = TransitionKt$animateRect$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        TwoWayConverter<Rect, AnimationVector4D> vectorConverter = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int i3 = i & 14;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        int i6 = (i5 >> 9) & 112;
        State<Rect> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), vectorConverter, str2, composer, (i5 & 14) | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }
}
