package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001ay\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0010\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+²\u0006\n\u0010,\u001a\u00020\u0011X\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release", "isPressed"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float ThumbPathLength;
    private static final float UncheckedThumbDiameter = SwitchTokens.INSTANCE.m3168getUnselectedHandleWidthD9Ej5fM();

    /* JADX WARNING: Removed duplicated region for block: B:159:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Switch(boolean r27, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, androidx.compose.material3.SwitchColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r7 = r28
            r8 = r35
            r0 = 1580463220(0x5e33f474, float:3.24177919E18)
            r1 = r34
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Switch)P(!1,5,4,6,2)96@4481L8,97@4541L39,*106@4829L7,107@4904L7,108@4964L111,113@5139L36,114@5192L24,116@5233L145,116@5222L156,121@5410L190,121@5384L216,145@6060L844:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r36 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r8 | 6
            r14 = r27
            goto L_0x002d
        L_0x001b:
            r1 = r8 & 6
            r14 = r27
            if (r1 != 0) goto L_0x002c
            boolean r1 = r15.changed((boolean) r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r8
            goto L_0x002d
        L_0x002c:
            r1 = r8
        L_0x002d:
            r2 = r36 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            goto L_0x0044
        L_0x0034:
            r2 = r8 & 48
            if (r2 != 0) goto L_0x0044
            boolean r2 = r15.changedInstance(r7)
            if (r2 == 0) goto L_0x0041
            r2 = 32
            goto L_0x0043
        L_0x0041:
            r2 = 16
        L_0x0043:
            r1 = r1 | r2
        L_0x0044:
            r2 = r36 & 4
            if (r2 == 0) goto L_0x004b
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r3 = r8 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x005e
            r3 = r29
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005a
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r1 = r1 | r4
            goto L_0x0060
        L_0x005e:
            r3 = r29
        L_0x0060:
            r4 = r36 & 8
            if (r4 == 0) goto L_0x0067
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r5 = r8 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007a
            r5 = r30
            boolean r6 = r15.changedInstance(r5)
            if (r6 == 0) goto L_0x0076
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r1 = r1 | r6
            goto L_0x007c
        L_0x007a:
            r5 = r30
        L_0x007c:
            r6 = r36 & 16
            if (r6 == 0) goto L_0x0083
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0083:
            r10 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0096
            r10 = r31
            boolean r11 = r15.changed((boolean) r10)
            if (r11 == 0) goto L_0x0092
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r1 = r1 | r11
            goto L_0x0098
        L_0x0096:
            r10 = r31
        L_0x0098:
            r11 = 196608(0x30000, float:2.75506E-40)
            r11 = r11 & r8
            if (r11 != 0) goto L_0x00b2
            r11 = r36 & 32
            if (r11 != 0) goto L_0x00ac
            r11 = r32
            boolean r12 = r15.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x00ae
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r11 = r32
        L_0x00ae:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r1 = r1 | r12
            goto L_0x00b4
        L_0x00b2:
            r11 = r32
        L_0x00b4:
            r12 = r36 & 64
            r13 = 1572864(0x180000, float:2.204052E-39)
            if (r12 == 0) goto L_0x00bc
            r1 = r1 | r13
            goto L_0x00cf
        L_0x00bc:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00cf
            r13 = r33
            boolean r16 = r15.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00ca
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00ca:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r1 = r1 | r16
            goto L_0x00d1
        L_0x00cf:
            r13 = r33
        L_0x00d1:
            r16 = 599187(0x92493, float:8.3964E-40)
            r9 = r1 & r16
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r9 != r0) goto L_0x00ed
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00ed
        L_0x00e2:
            r15.skipToGroupEnd()
            r4 = r5
            r5 = r10
            r6 = r11
            r26 = r13
            r0 = r15
            goto L_0x044e
        L_0x00ed:
            r15.startDefaults()
            r0 = r8 & 1
            java.lang.String r3 = "CC(remember):Switch.kt#9igjgp"
            r9 = 6
            if (r0 == 0) goto L_0x0115
            boolean r0 = r15.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00fe
            goto L_0x0115
        L_0x00fe:
            r15.skipToGroupEnd()
            r0 = r36 & 32
            if (r0 == 0) goto L_0x0109
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r0
        L_0x0109:
            r23 = r5
            r24 = r10
            r25 = r11
            r26 = r13
            r13 = r29
        L_0x0113:
            r10 = r1
            goto L_0x016b
        L_0x0115:
            if (r2 == 0) goto L_0x011c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x011e
        L_0x011c:
            r0 = r29
        L_0x011e:
            if (r4 == 0) goto L_0x0121
            r5 = 0
        L_0x0121:
            if (r6 == 0) goto L_0x0125
            r2 = 1
            r10 = r2
        L_0x0125:
            r2 = r36 & 32
            if (r2 == 0) goto L_0x0134
            androidx.compose.material3.SwitchDefaults r2 = androidx.compose.material3.SwitchDefaults.INSTANCE
            androidx.compose.material3.SwitchColors r2 = r2.colors(r15, r9)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            r11 = r2
        L_0x0134:
            if (r12 == 0) goto L_0x0161
            r2 = -1221651002(0xffffffffb72f15c6, float:-1.0435882E-5)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            java.lang.Object r2 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x0152
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r2)
        L_0x0152:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r15.endReplaceableGroup()
            r13 = r0
            r26 = r2
            r23 = r5
            r24 = r10
            r25 = r11
            goto L_0x0113
        L_0x0161:
            r23 = r5
            r24 = r10
            r25 = r11
            r26 = r13
            r13 = r0
            goto L_0x0113
        L_0x016b:
            r15.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017d
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.Switch (Switch.kt:98)"
            r2 = 1580463220(0x5e33f474, float:3.24177919E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r1)
        L_0x017d:
            if (r23 != 0) goto L_0x0182
            float r0 = UncheckedThumbDiameter
            goto L_0x0184
        L_0x0182:
            float r0 = ThumbDiameter
        L_0x0184:
            r18 = r0
            float r11 = SwitchHeight
            float r0 = r11 - r18
            float r0 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r0)
            r1 = 2
            float r2 = (float) r1
            float r0 = r0 / r2
            float r12 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r1, r2)
            java.lang.Object r0 = r15.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            float r0 = r0.m6550toPx0680j_4(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r1, r2)
            java.lang.Object r1 = r15.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r6 = ThumbPathLength
            float r1 = r1.m6550toPx0680j_4(r6)
            r2 = -1221650579(0xffffffffb72f176d, float:-1.0436267E-5)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            boolean r2 = r15.changed((float) r0)
            boolean r4 = r15.changed((float) r1)
            r2 = r2 | r4
            java.lang.Object r4 = r15.rememberedValue()
            if (r2 != 0) goto L_0x01e8
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x01f3
        L_0x01e8:
            androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1 r2 = new androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
            r2.<init>(r1, r0)
            r4 = r2
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r15.updateRememberedValue(r4)
        L_0x01f3:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r15.endReplaceableGroup()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r27)
            java.lang.Object r1 = r4.invoke(r1)
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            r2 = -1221650404(0xffffffffb72f181c, float:-1.0436426E-5)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            java.lang.Object r2 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x0226
            r2 = 0
            r4 = 0
            r5 = 2
            androidx.compose.animation.core.Animatable r2 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r1, r2, r5, r4)
            r15.updateRememberedValue(r2)
            goto L_0x0227
        L_0x0226:
            r4 = 0
        L_0x0227:
            r5 = r2
            androidx.compose.animation.core.Animatable r5 = (androidx.compose.animation.core.Animatable) r5
            r15.endReplaceableGroup()
            r2 = 773894976(0x2e20b340, float:3.6538994E-11)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            java.lang.Object r2 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r16.getEmpty()
            if (r2 != r4) goto L_0x0260
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r15)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r4.<init>(r2)
            r15.updateRememberedValue(r4)
            r2 = r4
        L_0x0260:
            r15.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r2 = r2.getCoroutineScope()
            r15.endReplaceableGroup()
            r4 = -1221650310(0xffffffffb72f187a, float:-1.0436512E-5)
            r15.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            boolean r4 = r15.changedInstance(r5)
            boolean r16 = r15.changed((float) r0)
            r4 = r4 | r16
            java.lang.Object r9 = r15.rememberedValue()
            if (r4 != 0) goto L_0x028d
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r9 != r4) goto L_0x0298
        L_0x028d:
            androidx.compose.material3.SwitchKt$Switch$2$1 r4 = new androidx.compose.material3.SwitchKt$Switch$2$1
            r4.<init>(r5, r0)
            r9 = r4
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r15.updateRememberedValue(r9)
        L_0x0298:
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r15.endReplaceableGroup()
            r4 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r9, r15, r4)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r27)
            r9 = -1221650133(0xffffffffb72f192b, float:-1.0436673E-5)
            r15.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            boolean r3 = r15.changedInstance(r5)
            boolean r9 = r15.changed((float) r1)
            r3 = r3 | r9
            boolean r9 = r15.changedInstance(r2)
            r3 = r3 | r9
            java.lang.Object r9 = r15.rememberedValue()
            if (r3 != 0) goto L_0x02ca
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r9 != r3) goto L_0x02d5
        L_0x02ca:
            androidx.compose.material3.SwitchKt$Switch$3$1 r3 = new androidx.compose.material3.SwitchKt$Switch$3$1
            r3.<init>(r5, r1, r2)
            r9 = r3
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r15.updateRememberedValue(r9)
        L_0x02d5:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r15.endReplaceableGroup()
            r1 = r10 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r9, (androidx.compose.runtime.Composer) r15, (int) r1)
            if (r7 == 0) goto L_0x0303
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m5869getSwitcho7Vup1c()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r3 = 0
            androidx.compose.ui.semantics.Role r9 = androidx.compose.ui.semantics.Role.m5857boximpl(r1)
            r1 = r27
            r2 = r26
            r8 = 0
            r4 = r24
            r17 = r5
            r5 = r9
            r19 = r6
            r6 = r28
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m1004toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x030c
        L_0x0303:
            r17 = r5
            r19 = r6
            r8 = 0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x030c:
            if (r7 == 0) goto L_0x0317
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r1)
            goto L_0x031b
        L_0x0317:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x031b:
            androidx.compose.ui.Modifier r1 = r13.then(r1)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 2
            r3 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r0, r1, r3, r2, r8)
            float r1 = SwitchWidth
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m736requiredSizeVpY3zN4(r0, r1, r11)
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r3, r15, r3)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r15, r3)
            androidx.compose.runtime.CompositionLocalMap r4 = r15.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r6 = r15.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0372
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0372:
            r15.startReusableNode()
            boolean r6 = r15.getInserting()
            if (r6 == 0) goto L_0x037f
            r15.createNode(r5)
            goto L_0x0382
        L_0x037f:
            r15.useNode()
        L_0x0382:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3282constructorimpl(r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r4 = r5.getInserting()
            if (r4 != 0) goto L_0x03b2
            java.lang.Object r4 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x03c0
        L_0x03b2:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r5.updateRememberedValue(r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.apply(r2, r1)
        L_0x03c0:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r0.invoke(r1, r15, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r1 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r9 = r0
            androidx.compose.foundation.layout.BoxScope r9 = (androidx.compose.foundation.layout.BoxScope) r9
            r0 = -1873061411(0xffffffff905b59dd, float:-4.3259363E-29)
            java.lang.String r1 = "C164@6698L5,158@6451L447:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r1)
            androidx.compose.runtime.State r0 = r17.asState()
            androidx.compose.material3.tokens.SwitchTokens r1 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r1 = r1.getHandleShape()
            r2 = 6
            androidx.compose.ui.graphics.Shape r16 = androidx.compose.material3.ShapesKt.getValue(r1, r15, r2)
            r1 = r26
            androidx.compose.foundation.interaction.InteractionSource r1 = (androidx.compose.foundation.interaction.InteractionSource) r1
            int r3 = r10 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r3 = r10 >> 6
            r4 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r10 << 6
            r4 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r4
            r2 = r2 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r10
            r21 = r2 | r3
            r22 = 6
            r10 = r27
            r11 = r24
            r2 = r12
            r12 = r25
            r3 = r13
            r13 = r0
            r14 = r23
            r0 = r15
            r15 = r1
            r17 = r18
            r18 = r2
            r20 = r0
            m2337SwitchImpl0DmnUew(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0448
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0448:
            r4 = r23
            r5 = r24
            r6 = r25
        L_0x044e:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 == 0) goto L_0x0469
            androidx.compose.material3.SwitchKt$Switch$5 r11 = new androidx.compose.material3.SwitchKt$Switch$5
            r0 = r11
            r1 = r27
            r2 = r28
            r7 = r26
            r8 = r35
            r9 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0469:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.SwitchColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: SwitchImpl-0DmnUew  reason: not valid java name */
    public static final void m2337SwitchImpl0DmnUew(BoxScope boxScope, boolean z, boolean z2, SwitchColors switchColors, State<Float> state, Function2<? super Composer, ? super Integer, Unit> function2, InteractionSource interactionSource, Shape shape, float f, float f2, float f3, Composer composer, int i, int i2) {
        int i3;
        int i4;
        float f4;
        float f5;
        float f6;
        BoxScope boxScope2 = boxScope;
        boolean z3 = z;
        boolean z4 = z2;
        SwitchColors switchColors2 = switchColors;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        InteractionSource interactionSource2 = interactionSource;
        Shape shape2 = shape;
        float f7 = f;
        float f8 = f2;
        float f9 = f3;
        int i5 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1968109941);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchImpl)P(!1,2!1,8,6!1,7,9:c#ui.unit.Dp,5:c#ui.unit.Dp,4:c#ui.unit.Dp)188@7413L25,*190@7481L7,210@8114L5,222@8432L1050:Switch.kt#uh7d8r");
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) boxScope2) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changed(z3) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changed(z4) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changed((Object) switchColors2) ? 2048 : 1024;
        }
        if ((i5 & CpioConstants.C_ISBLK) == 0) {
            i3 |= startRestartGroup.changed((Object) state) ? 16384 : 8192;
        } else {
            State<Float> state2 = state;
        }
        if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i3 |= startRestartGroup.changed((Object) interactionSource2) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i3 |= startRestartGroup.changed((Object) shape2) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i3 |= startRestartGroup.changed(f7) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i3 |= startRestartGroup.changed(f8) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changed(f9) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 306783379) == 306783378 && (i4 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968109941, i3, i4, "androidx.compose.material3.SwitchImpl (Switch.kt:186)");
            }
            long r14 = switchColors2.m2334trackColorWaAFU9c$material3_release(z4, z3);
            State<Boolean> collectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource2, startRestartGroup, (i3 >> 18) & 14);
            int i6 = i3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r12 = ((Density) consume).m6546toDpu2uoSUM(state.getValue().floatValue());
            if (SwitchImpl_0DmnUew$lambda$8(collectIsPressedAsState)) {
                f4 = SwitchTokens.INSTANCE.m3159getPressedHandleWidthD9Ej5fM();
            } else {
                f4 = Dp.m6614constructorimpl(Dp.m6614constructorimpl(Dp.m6614constructorimpl(ThumbDiameter - f7) * (Dp.m6614constructorimpl(r12 - f8) / Dp.m6614constructorimpl(f9 - f8))) + f7);
            }
            startRestartGroup.startReplaceableGroup(-993794132);
            ComposerKt.sourceInformation(startRestartGroup, "*199@7822L7");
            if (SwitchImpl_0DmnUew$lambda$8(collectIsPressedAsState)) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density = (Density) consume2;
                if (z3) {
                    f6 = Dp.m6614constructorimpl(ThumbPathLength - SwitchTokens.INSTANCE.m3165getTrackOutlineWidthD9Ej5fM());
                } else {
                    f6 = SwitchTokens.INSTANCE.m3165getTrackOutlineWidthD9Ej5fM();
                }
                f5 = density.m6550toPx0680j_4(f6);
            } else {
                f5 = state.getValue().floatValue();
            }
            startRestartGroup.endReplaceableGroup();
            Shape value = ShapesKt.getValue(SwitchTokens.INSTANCE.getTrackShape(), startRestartGroup, 6);
            Modifier r6 = BackgroundKt.m213backgroundbw27NRU(BorderKt.m225borderxT4_qwU(SizeKt.m728height3ABfNKs(SizeKt.m747width3ABfNKs(boxScope2.align(Modifier.Companion, Alignment.Companion.getCenter()), SwitchWidth), SwitchHeight), SwitchTokens.INSTANCE.m3165getTrackOutlineWidthD9Ej5fM(), switchColors2.m2314borderColorWaAFU9c$material3_release(z4, z3), value), r14, value);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r6);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r9 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r9, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r9, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r9.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1420969714, "C228@8671L42,231@8868L134,225@8564L912:Switch.kt#uh7d8r");
            long r62 = switchColors2.m2333thumbColorWaAFU9c$material3_release(z4, z3);
            Modifier align = BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getCenterStart());
            startRestartGroup.startReplaceableGroup(1420969929);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
            boolean changed = startRestartGroup.changed(f5);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SwitchKt$SwitchImpl$1$1$1(f5);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            int i7 = i6;
            String str = "C73@3426L9:Box.kt#2w3rfo";
            Modifier r0 = BackgroundKt.m213backgroundbw27NRU(SizeKt.m734requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) rememberedValue), interactionSource, RippleKt.m1491rememberRipple9IZ8Weo(false, Dp.m6614constructorimpl(SwitchTokens.INSTANCE.m3163getStateLayerSizeD9Ej5fM() / ((float) 2)), 0, startRestartGroup, 54, 4)), f4), r62, shape2);
            Alignment center = Alignment.Companion.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(r0);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r122 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r122, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r122, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r122.getInserting() || !Intrinsics.areEqual(r122.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r122.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r122.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, str);
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2040677128, "C:Switch.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(1420970455);
            ComposerKt.sourceInformation(startRestartGroup, "242@9308L144");
            Function2<? super Composer, ? super Integer, Unit> function23 = function2;
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(switchColors2.m2332iconColorWaAFU9c$material3_release(z4, z3))), function23, startRestartGroup, ProvidedValue.$stable | ((i7 >> 12) & 112));
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SwitchKt$SwitchImpl$2(boxScope, z, z2, switchColors, state, function2, interactionSource, shape, f, f2, f3, i, i2));
        }
    }

    static {
        float r0 = SwitchTokens.INSTANCE.m3161getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = r0;
        float r1 = SwitchTokens.INSTANCE.m3166getTrackWidthD9Ej5fM();
        SwitchWidth = r1;
        float r2 = SwitchTokens.INSTANCE.m3164getTrackHeightD9Ej5fM();
        SwitchHeight = r2;
        float r22 = Dp.m6614constructorimpl(Dp.m6614constructorimpl(r2 - r0) / ((float) 2));
        ThumbPadding = r22;
        ThumbPathLength = Dp.m6614constructorimpl(Dp.m6614constructorimpl(r1 - r0) - r22);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }

    private static final boolean SwitchImpl_0DmnUew$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
