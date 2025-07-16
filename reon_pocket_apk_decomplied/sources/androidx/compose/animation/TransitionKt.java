package androidx.compose.animation;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b2&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0002\b\u0014H\b¢\u0006\u0002\u0010\u001a\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/InfiniteTransition;", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animateColor-RIQooxk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "label", "", "animateColor-DTcfvLk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "S", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class TransitionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> animateColor(androidx.compose.animation.core.Transition<S> r8, kotlin.jvm.functions.Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.graphics.Color>> r9, java.lang.String r10, kotlin.jvm.functions.Function3<? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r14 & 1
            if (r0 == 0) goto L_0x0013
            androidx.compose.animation.TransitionKt$animateColor$1 r9 = androidx.compose.animation.TransitionKt$animateColor$1.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
        L_0x0013:
            r14 = r14 & 2
            if (r14 == 0) goto L_0x0019
            java.lang.String r10 = "ColorAnimation"
        L_0x0019:
            r5 = r10
            java.lang.Object r10 = r8.getTargetState()
            int r14 = r13 >> 6
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r10 = r11.invoke(r10, r12, r14)
            androidx.compose.ui.graphics.Color r10 = (androidx.compose.ui.graphics.Color) r10
            long r0 = r10.m3826unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r10 = androidx.compose.ui.graphics.Color.m3820getColorSpaceimpl(r0)
            r14 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r14)
            boolean r14 = r12.changed((java.lang.Object) r10)
            java.lang.Object r0 = r12.rememberedValue()
            if (r14 != 0) goto L_0x0051
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r0 != r14) goto L_0x0061
        L_0x0051:
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r14 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r14)
            java.lang.Object r10 = r14.invoke(r10)
            r0 = r10
            androidx.compose.animation.core.TwoWayConverter r0 = (androidx.compose.animation.core.TwoWayConverter) r0
            r12.updateRememberedValue(r0)
        L_0x0061:
            r12.endReplaceableGroup()
            r4 = r0
            androidx.compose.animation.core.TwoWayConverter r4 = (androidx.compose.animation.core.TwoWayConverter) r4
            r10 = r13 & 14
            r10 = r10 | 64
            int r13 = r13 << 3
            r14 = r13 & 896(0x380, float:1.256E-42)
            r10 = r10 | r14
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r14
            r10 = r10 | r13
            r13 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r12.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            java.lang.Object r13 = r8.getCurrentState()
            int r14 = r10 >> 9
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r11.invoke(r13, r12, r0)
            java.lang.Object r13 = r8.getTargetState()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r2 = r11.invoke(r13, r12, r14)
            androidx.compose.animation.core.Transition$Segment r11 = r8.getSegment()
            int r13 = r10 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.Object r9 = r9.invoke(r11, r12, r13)
            r3 = r9
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            r9 = r10 & 14
            r11 = 32768(0x8000, float:4.5918E-41)
            r9 = r9 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            int r10 = r10 << 6
            r10 = r10 & r11
            r7 = r9 | r10
            r0 = r8
            r6 = r12
            androidx.compose.runtime.State r8 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.TransitionKt.animateColor(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function3, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    /* renamed from: animateColor-DTcfvLk  reason: not valid java name */
    public static final State<Color> m117animateColorDTcfvLk(InfiniteTransition infiniteTransition, long j, long j2, InfiniteRepeatableSpec<Color> infiniteRepeatableSpec, String str, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(1901963533);
        ComposerKt.sourceInformation(composer2, "C(animateColor)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color)102@4596L72,105@4680L72:Transition.kt#xbi5r1");
        String str2 = (i2 & 8) != 0 ? "ColorAnimation" : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1901963533, i3, -1, "androidx.compose.animation.animateColor (Transition.kt:101)");
        }
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m3820getColorSpaceimpl(j2));
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        int i4 = i3 << 3;
        State<Color> animateValue = InfiniteTransitionKt.animateValue(infiniteTransition, Color.m3806boximpl(j), Color.m3806boximpl(j2), (TwoWayConverter) rememberedValue, infiniteRepeatableSpec, str2, composer, InfiniteTransition.$stable | 4096 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (InfiniteRepeatableSpec.$stable << 12) | (57344 & i4) | (i4 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateColor APIs now have a new label parameter added.")
    /* renamed from: animateColor-RIQooxk  reason: not valid java name */
    public static final /* synthetic */ State m118animateColorRIQooxk(InfiniteTransition infiniteTransition, long j, long j2, InfiniteRepeatableSpec infiniteRepeatableSpec, Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        composer2.startReplaceableGroup(1400583834);
        ComposerKt.sourceInformation(composer2, "C(animateColor)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color)117@5040L143:Transition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1400583834, i2, -1, "androidx.compose.animation.animateColor (Transition.kt:117)");
        }
        State<Color> r0 = m117animateColorDTcfvLk(infiniteTransition, j, j2, infiniteRepeatableSpec, "ColorAnimation", composer, InfiniteTransition.$stable | CpioConstants.C_ISBLK | (i2 & 14) | (i2 & 112) | (i2 & 896) | (InfiniteRepeatableSpec.$stable << 9) | (i2 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }
}
