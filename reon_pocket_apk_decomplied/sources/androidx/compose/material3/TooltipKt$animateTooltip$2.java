package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$animateTooltip$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Transition<Boolean> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$animateTooltip$2(Transition<Boolean> transition) {
        super(3);
        this.$transition = transition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        int i2;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1498516085);
        ComposerKt.sourceInformation(composer2, "C655@25162L583,674@25775L561:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1498516085, i, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:655)");
        }
        Transition<Boolean> transition = this.$transition;
        Function3 function3 = TooltipKt$animateTooltip$2$scale$2.INSTANCE;
        composer2.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation(composer2, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        composer2.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer2, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        boolean booleanValue = transition.getCurrentState().booleanValue();
        composer2.startReplaceableGroup(-1553362193);
        ComposerKt.sourceInformation(composer2, "C:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:672)");
        }
        float f = 0.8f;
        float f2 = 1.0f;
        float f3 = booleanValue ? 1.0f : 0.8f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        Float valueOf = Float.valueOf(f3);
        boolean booleanValue2 = transition.getTargetState().booleanValue();
        composer2.startReplaceableGroup(-1553362193);
        ComposerKt.sourceInformation(composer2, "C:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:672)");
        }
        if (booleanValue2) {
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        State<Float> createTransitionAnimation = TransitionKt.createTransitionAnimation(transition, valueOf, Float.valueOf(f), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer2, 0), vectorConverter, "tooltip transition: scaling", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        Transition<Boolean> transition2 = this.$transition;
        Function3 function32 = TooltipKt$animateTooltip$2$alpha$2.INSTANCE;
        composer2.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation(composer2, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        composer2.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer2, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        boolean booleanValue3 = transition2.getCurrentState().booleanValue();
        composer2.startReplaceableGroup(2073045083);
        ComposerKt.sourceInformation(composer2, "C:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            i2 = 0;
            ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:691)");
        } else {
            i2 = 0;
        }
        float f4 = booleanValue3 ? 1.0f : 0.0f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        Float valueOf2 = Float.valueOf(f4);
        boolean booleanValue4 = transition2.getTargetState().booleanValue();
        composer2.startReplaceableGroup(2073045083);
        ComposerKt.sourceInformation(composer2, "C:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2073045083, i2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:691)");
        }
        if (!booleanValue4) {
            f2 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        State<Float> createTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition2, valueOf2, Float.valueOf(f2), (FiniteAnimationSpec) function32.invoke(transition2.getSegment(), composer2, Integer.valueOf(i2)), vectorConverter2, "tooltip transition: alpha", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        Modifier r1 = GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(modifier, invoke$lambda$1(createTransitionAnimation), invoke$lambda$1(createTransitionAnimation), invoke$lambda$3(createTransitionAnimation2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131064, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    private static final float invoke$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float invoke$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
