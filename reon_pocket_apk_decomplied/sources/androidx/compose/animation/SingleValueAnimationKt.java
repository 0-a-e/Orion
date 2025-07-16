package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a$\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aH\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aR\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"colorDefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/graphics/Color;", "Animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector4D;", "initialValue", "Animatable-8_81llA", "(J)Landroidx/compose/animation/core/Animatable;", "animateColorAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateColorAsState-KTwxG1Y", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "label", "", "animateColorAsState-euL9pac", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SingleValueAnimation.kt */
public final class SingleValueAnimationKt {
    private static final SpringSpec<Color> colorDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: animateColorAsState-euL9pac  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> m105animateColorAsStateeuL9pac(long r10, androidx.compose.animation.core.AnimationSpec<androidx.compose.ui.graphics.Color> r12, java.lang.String r13, kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.Color, kotlin.Unit> r14, androidx.compose.runtime.Composer r15, int r16, int r17) {
        /*
            r9 = r15
            r0 = r16
            r1 = -451899108(0xffffffffe510911c, float:-4.26686E22)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "C(animateColorAsState)P(3:c#ui.graphics.Color!1,2)62@2847L96,65@2955L124:SingleValueAnimation.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r17 & 2
            if (r2 == 0) goto L_0x0017
            androidx.compose.animation.core.SpringSpec<androidx.compose.ui.graphics.Color> r2 = colorDefaultSpring
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            goto L_0x0018
        L_0x0017:
            r2 = r12
        L_0x0018:
            r3 = r17 & 4
            if (r3 == 0) goto L_0x0020
            java.lang.String r3 = "ColorAnimation"
            r4 = r3
            goto L_0x0021
        L_0x0020:
            r4 = r13
        L_0x0021:
            r3 = r17 & 8
            if (r3 == 0) goto L_0x0028
            r3 = 0
            r5 = r3
            goto L_0x0029
        L_0x0028:
            r5 = r14
        L_0x0029:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0035
            r3 = -1
            java.lang.String r6 = "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:61)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r3, r6)
        L_0x0035:
            androidx.compose.ui.graphics.colorspace.ColorSpace r1 = androidx.compose.ui.graphics.Color.m3820getColorSpaceimpl(r10)
            r3 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            boolean r1 = r15.changed((java.lang.Object) r1)
            java.lang.Object r3 = r15.rememberedValue()
            if (r1 != 0) goto L_0x0056
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x006a
        L_0x0056:
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r1 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r1)
            androidx.compose.ui.graphics.colorspace.ColorSpace r3 = androidx.compose.ui.graphics.Color.m3820getColorSpaceimpl(r10)
            java.lang.Object r1 = r1.invoke(r3)
            r3 = r1
            androidx.compose.animation.core.TwoWayConverter r3 = (androidx.compose.animation.core.TwoWayConverter) r3
            r15.updateRememberedValue(r3)
        L_0x006a:
            r15.endReplaceableGroup()
            r1 = r3
            androidx.compose.animation.core.TwoWayConverter r1 = (androidx.compose.animation.core.TwoWayConverter) r1
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m3806boximpl(r10)
            r6 = r0 & 14
            r6 = r6 | 576(0x240, float:8.07E-43)
            int r0 = r0 << 6
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r0
            r6 = r6 | r7
            r7 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r7
            r7 = r6 | r0
            r8 = 8
            r6 = 0
            r0 = r3
            r3 = r6
            r6 = r15
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.AnimateAsStateKt.animateValueAsState(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0097
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0097:
            r15.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.SingleValueAnimationKt.m105animateColorAsStateeuL9pac(long, androidx.compose.animation.core.AnimationSpec, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateColorAsState-KTwxG1Y  reason: not valid java name */
    public static final /* synthetic */ State m104animateColorAsStateKTwxG1Y(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1942442407);
        ComposerKt.sourceInformation(composer, "C(animateColorAsState)P(2:c#ui.graphics.Color)80@3400L98:SingleValueAnimation.kt#xbi5r1");
        if ((i2 & 2) != 0) {
            animationSpec = colorDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1942442407, i, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:79)");
        }
        State<Color> r9 = m105animateColorAsStateeuL9pac(j, animationSpec2, (String) null, function12, composer, (i & 14) | 64 | ((i << 3) & 7168), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r9;
    }

    /* renamed from: Animatable-8_81llA  reason: not valid java name */
    public static final Animatable<Color, AnimationVector4D> m103Animatable8_81llA(long j) {
        return new Animatable(Color.m3806boximpl(j), ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m3820getColorSpaceimpl(j)), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
    }
}
