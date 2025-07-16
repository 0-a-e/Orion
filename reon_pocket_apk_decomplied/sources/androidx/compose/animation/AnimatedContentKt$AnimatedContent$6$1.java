package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "S", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentKt$AnimatedContent$6$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function4<AnimatedContentScope, S, Composer, Integer, Unit> $content;
    final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> $rootScope;
    final /* synthetic */ S $stateForContent;
    final /* synthetic */ Transition<S> $this_AnimatedContent;
    final /* synthetic */ Function1<AnimatedContentTransitionScope<S>, ContentTransform> $transitionSpec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentKt$AnimatedContent$6$1(Transition<S> transition, S s, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl, SnapshotStateList<S> snapshotStateList, Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4) {
        super(2);
        this.$this_AnimatedContent = transition;
        this.$stateForContent = s;
        this.$transitionSpec = function1;
        this.$rootScope = animatedContentTransitionScopeImpl;
        this.$currentlyVisible = snapshotStateList;
        this.$content = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ExitTransition exitTransition;
        ComposerKt.sourceInformation(composer, "C709@36279L38,713@36493L323,720@36849L125,725@37157L1637:AnimatedContent.kt#xbi5r1");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(885640742, i, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:709)");
            }
            Function1<AnimatedContentTransitionScope<S>, ContentTransform> function1 = this.$transitionSpec;
            AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this.$rootScope;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = function1.invoke(animatedContentTransitionScopeImpl);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            final ContentTransform contentTransform = (ContentTransform) rememberedValue;
            Boolean valueOf = Boolean.valueOf(Intrinsics.areEqual((Object) this.$this_AnimatedContent.getSegment().getTargetState(), (Object) this.$stateForContent));
            Transition<S> transition = this.$this_AnimatedContent;
            S s = this.$stateForContent;
            Function1<AnimatedContentTransitionScope<S>, ContentTransform> function12 = this.$transitionSpec;
            AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl2 = this.$rootScope;
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = composer.changed((Object) valueOf);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                if (Intrinsics.areEqual((Object) transition.getSegment().getTargetState(), (Object) s)) {
                    exitTransition = ExitTransition.Companion.getNone();
                } else {
                    exitTransition = function12.invoke(animatedContentTransitionScopeImpl2).getInitialContentExit();
                }
                rememberedValue2 = exitTransition;
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            ExitTransition exitTransition2 = (ExitTransition) rememberedValue2;
            S s2 = this.$stateForContent;
            Transition<S> transition2 = this.$this_AnimatedContent;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual((Object) s2, (Object) transition2.getTargetState()));
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceableGroup();
            AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) rememberedValue3;
            EnterTransition targetContentEnter = contentTransform.getTargetContentEnter();
            Modifier layout = LayoutModifierKt.layout(Modifier.Companion, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return m34invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m6532unboximpl());
                }

                /* renamed from: invoke-3p2s80s  reason: not valid java name */
                public final MeasureResult m34invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                    final Placeable r9 = measurable.m5368measureBRTryo0(j);
                    int width = r9.getWidth();
                    int height = r9.getHeight();
                    final ContentTransform contentTransform = contentTransform;
                    return MeasureScope.CC.layout$default(measureScope, width, height, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Placeable.PlacementScope placementScope) {
                            placementScope.place(r9, 0, 0, contentTransform.getTargetContentZIndex());
                        }
                    }, 4, (Object) null);
                }
            });
            childData.setTarget(Intrinsics.areEqual((Object) this.$stateForContent, (Object) this.$this_AnimatedContent.getTargetState()));
            Modifier then = layout.then(childData);
            Transition<S> transition3 = this.$this_AnimatedContent;
            final S s3 = this.$stateForContent;
            Function1 r1 = new Function1<S, Boolean>() {
                public final Boolean invoke(S s) {
                    return Boolean.valueOf(Intrinsics.areEqual((Object) s, (Object) s3));
                }
            };
            composer.startReplaceableGroup(841088387);
            boolean changed2 = composer.changed((Object) exitTransition2);
            Object rememberedValue4 = composer.rememberedValue();
            if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new AnimatedContentKt$AnimatedContent$6$1$4$1(exitTransition2);
                composer.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceableGroup();
            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl3 = this.$rootScope;
            final S s4 = this.$stateForContent;
            final SnapshotStateList<S> snapshotStateList = this.$currentlyVisible;
            final Function4<AnimatedContentScope, S, Composer, Integer, Unit> function4 = this.$content;
            AnimatedVisibilityKt.AnimatedEnterExitImpl(transition3, r1, then, targetContentEnter, exitTransition2, (Function2) rememberedValue4, (OnLookaheadMeasured) null, ComposableLambdaKt.composableLambda(composer, -616195562, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C745@38244L253,*753@38659L43,754@38730L24:AnimatedContent.kt#xbi5r1");
                    if ((i & 14) == 0) {
                        i |= composer.changed((Object) animatedVisibilityScope) ? 4 : 2;
                    }
                    if ((i & 91) != 18 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-616195562, i, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:745)");
                        }
                        final SnapshotStateList<S> snapshotStateList = snapshotStateList;
                        final S s = s4;
                        final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl3;
                        EffectsKt.DisposableEffect((Object) animatedVisibilityScope, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                return new AnimatedContentKt$AnimatedContent$6$1$5$1$invoke$$inlined$onDispose$1(snapshotStateList, s, animatedContentTransitionScopeImpl);
                            }
                        }, composer, i & 14);
                        Map<S, State<IntSize>> targetSizeMap$animation_release = animatedContentTransitionScopeImpl3.getTargetSizeMap$animation_release();
                        S s2 = s4;
                        Intrinsics.checkNotNull(animatedVisibilityScope, "null cannot be cast to non-null type androidx.compose.animation.AnimatedVisibilityScopeImpl");
                        targetSizeMap$animation_release.put(s2, ((AnimatedVisibilityScopeImpl) animatedVisibilityScope).getTargetSize$animation_release());
                        composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue = composer.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new AnimatedContentScopeImpl(animatedVisibilityScope);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceableGroup();
                        function4.invoke((AnimatedContentScopeImpl) rememberedValue, s4, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 12582912, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
