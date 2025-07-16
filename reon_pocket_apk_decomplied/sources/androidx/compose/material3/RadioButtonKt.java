package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0015"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = Dp.m6614constructorimpl((float) 12);
    private static final float RadioButtonPadding;
    /* access modifiers changed from: private */
    public static final float RadioStrokeWidth;

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RadioButton(boolean r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.ui.Modifier r25, boolean r26, androidx.compose.material3.RadioButtonColors r27, androidx.compose.foundation.interaction.MutableInteractionSource r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r7 = r23
            r8 = r24
            r9 = r30
            r0 = 408580840(0x185a72e8, float:2.8233852E-24)
            r1 = r29
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(RadioButton)P(5,4,3,1)77@3753L8,78@3813L39,80@3877L164,84@4070L29,115@5122L415,102@4704L833:RadioButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r31 & 1
            r5 = 2
            if (r1 == 0) goto L_0x001c
            r1 = r9 | 6
            goto L_0x002c
        L_0x001c:
            r1 = r9 & 6
            if (r1 != 0) goto L_0x002b
            boolean r1 = r6.changed((boolean) r7)
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0028:
            r1 = r5
        L_0x0029:
            r1 = r1 | r9
            goto L_0x002c
        L_0x002b:
            r1 = r9
        L_0x002c:
            r2 = r31 & 2
            if (r2 == 0) goto L_0x0033
            r1 = r1 | 48
            goto L_0x0043
        L_0x0033:
            r2 = r9 & 48
            if (r2 != 0) goto L_0x0043
            boolean r2 = r6.changedInstance(r8)
            if (r2 == 0) goto L_0x0040
            r2 = 32
            goto L_0x0042
        L_0x0040:
            r2 = 16
        L_0x0042:
            r1 = r1 | r2
        L_0x0043:
            r2 = r31 & 4
            if (r2 == 0) goto L_0x004a
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005d
        L_0x004a:
            r3 = r9 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x005d
            r3 = r25
            boolean r4 = r6.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0059
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r1 = r1 | r4
            goto L_0x005f
        L_0x005d:
            r3 = r25
        L_0x005f:
            r4 = r31 & 8
            if (r4 == 0) goto L_0x0066
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r10 = r9 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0079
            r10 = r26
            boolean r11 = r6.changed((boolean) r10)
            if (r11 == 0) goto L_0x0075
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r1 = r1 | r11
            goto L_0x007b
        L_0x0079:
            r10 = r26
        L_0x007b:
            r11 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0094
            r11 = r31 & 16
            if (r11 != 0) goto L_0x008e
            r11 = r27
            boolean r12 = r6.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0090
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x008e:
            r11 = r27
        L_0x0090:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r1 = r1 | r12
            goto L_0x0096
        L_0x0094:
            r11 = r27
        L_0x0096:
            r12 = r31 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x009e
            r1 = r1 | r13
            goto L_0x00b0
        L_0x009e:
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00b0
            r13 = r28
            boolean r14 = r6.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00ac
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00ac:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r1 = r1 | r14
            goto L_0x00b2
        L_0x00b0:
            r13 = r28
        L_0x00b2:
            r14 = 74899(0x12493, float:1.04956E-40)
            r14 = r14 & r1
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00cb
            boolean r14 = r6.getSkipping()
            if (r14 != 0) goto L_0x00c2
            goto L_0x00cb
        L_0x00c2:
            r6.skipToGroupEnd()
            r12 = r6
            r4 = r10
            r5 = r11
            r6 = r13
            goto L_0x025b
        L_0x00cb:
            r6.startDefaults()
            r14 = r9 & 1
            java.lang.String r15 = "CC(remember):RadioButton.kt#9igjgp"
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r13 = 6
            if (r14 == 0) goto L_0x00ee
            boolean r14 = r6.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00df
            goto L_0x00ee
        L_0x00df:
            r6.skipToGroupEnd()
            r2 = r31 & 16
            if (r2 == 0) goto L_0x00e8
            r1 = r1 & r16
        L_0x00e8:
            r17 = r28
            r4 = r3
        L_0x00eb:
            r3 = r10
            r2 = r11
            goto L_0x0132
        L_0x00ee:
            if (r2 == 0) goto L_0x00f5
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00f6
        L_0x00f5:
            r2 = r3
        L_0x00f6:
            if (r4 == 0) goto L_0x00fa
            r3 = 1
            r10 = r3
        L_0x00fa:
            r3 = r31 & 16
            if (r3 == 0) goto L_0x0107
            androidx.compose.material3.RadioButtonDefaults r3 = androidx.compose.material3.RadioButtonDefaults.INSTANCE
            androidx.compose.material3.RadioButtonColors r3 = r3.colors(r6, r13)
            r1 = r1 & r16
            r11 = r3
        L_0x0107:
            if (r12 == 0) goto L_0x012e
            r3 = 735546075(0x2bd78adb, float:1.5315209E-12)
            r6.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r15)
            java.lang.Object r3 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0125
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r3)
        L_0x0125:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            r6.endReplaceableGroup()
            r4 = r2
            r17 = r3
            goto L_0x00eb
        L_0x012e:
            r17 = r28
            r4 = r2
            goto L_0x00eb
        L_0x0132:
            r6.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0141
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.RadioButton (RadioButton.kt:79)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r10, r11)
        L_0x0141:
            r0 = 0
            if (r7 == 0) goto L_0x014d
            float r10 = RadioButtonDotSize
            float r11 = (float) r5
            float r10 = r10 / r11
            float r10 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r10)
            goto L_0x0152
        L_0x014d:
            float r10 = (float) r0
            float r10 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r10)
        L_0x0152:
            r11 = 100
            r14 = 0
            androidx.compose.animation.core.TweenSpec r11 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r11, r0, r14, r13, r14)
            androidx.compose.animation.core.AnimationSpec r11 = (androidx.compose.animation.core.AnimationSpec) r11
            r16 = 48
            r18 = 12
            r12 = 0
            r19 = 0
            r20 = r13
            r13 = r19
            r14 = r6
            r21 = r15
            r15 = r16
            r16 = r18
            androidx.compose.runtime.State r15 = androidx.compose.animation.core.AnimateAsStateKt.m119animateDpAsStateAjpBEmI(r10, r11, r12, r13, r14, r15, r16)
            int r10 = r1 >> 9
            r10 = r10 & 14
            int r11 = r1 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            int r1 = r1 >> 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r10
            androidx.compose.runtime.State r1 = r2.radioColor$material3_release(r3, r7, r6, r1)
            r10 = 735546399(0x2bd78c1f, float:1.531556E-12)
            r6.startReplaceableGroup(r10)
            java.lang.String r10 = "94@4501L136"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r10)
            if (r8 == 0) goto L_0x01d4
            androidx.compose.ui.Modifier$Companion r18 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r10 = androidx.compose.ui.semantics.Role.Companion
            int r19 = r10.m5868getRadioButtono7Vup1c()
            androidx.compose.material3.tokens.RadioButtonTokens r10 = androidx.compose.material3.tokens.RadioButtonTokens.INSTANCE
            float r10 = r10.m3114getStateLayerSizeD9Ej5fM()
            float r11 = (float) r5
            float r10 = r10 / r11
            float r11 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r10)
            r16 = 54
            r20 = 4
            r10 = 0
            r12 = 0
            r14 = r6
            r22 = r15
            r15 = r16
            r16 = r20
            androidx.compose.foundation.Indication r10 = androidx.compose.material.ripple.RippleKt.m1491rememberRipple9IZ8Weo(r10, r11, r12, r14, r15, r16)
            r11 = r18
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            androidx.compose.ui.semantics.Role r12 = androidx.compose.ui.semantics.Role.m5857boximpl(r19)
            r13 = r0
            r0 = r11
            r11 = r1
            r1 = r23
            r14 = r2
            r2 = r17
            r15 = r3
            r3 = r10
            r10 = r4
            r4 = r15
            r7 = r5
            r5 = r12
            r12 = r6
            r6 = r24
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.SelectableKt.m1000selectableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x01e1
        L_0x01d4:
            r13 = r0
            r11 = r1
            r14 = r2
            r10 = r4
            r7 = r5
            r12 = r6
            r22 = r15
            r15 = r3
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x01e1:
            r12.endReplaceableGroup()
            if (r8 == 0) goto L_0x01ef
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r1)
            goto L_0x01f3
        L_0x01ef:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x01f3:
            androidx.compose.ui.Modifier r1 = r10.then(r1)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r0, r1, r13, r7, r2)
            float r1 = RadioButtonPadding
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m670padding3ABfNKs(r0, r1)
            androidx.compose.material3.tokens.RadioButtonTokens r1 = androidx.compose.material3.tokens.RadioButtonTokens.INSTANCE
            float r1 = r1.m3113getIconSizeD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m734requiredSize3ABfNKs(r0, r1)
            r1 = 735547384(0x2bd78ff8, float:1.5316628E-12)
            r12.startReplaceableGroup(r1)
            r1 = r21
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            boolean r1 = r12.changed((java.lang.Object) r11)
            r2 = r22
            boolean r3 = r12.changed((java.lang.Object) r2)
            r1 = r1 | r3
            java.lang.Object r3 = r12.rememberedValue()
            if (r1 != 0) goto L_0x023a
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0245
        L_0x023a:
            androidx.compose.material3.RadioButtonKt$RadioButton$2$1 r1 = new androidx.compose.material3.RadioButtonKt$RadioButton$2$1
            r1.<init>(r11, r2)
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r12.updateRememberedValue(r3)
        L_0x0245:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r12.endReplaceableGroup()
            androidx.compose.foundation.CanvasKt.Canvas(r0, r3, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0256
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0256:
            r3 = r10
            r5 = r14
            r4 = r15
            r6 = r17
        L_0x025b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r12.endRestartGroup()
            if (r10 == 0) goto L_0x0274
            androidx.compose.material3.RadioButtonKt$RadioButton$3 r11 = new androidx.compose.material3.RadioButtonKt$RadioButton$3
            r0 = r11
            r1 = r23
            r2 = r24
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0274:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.RadioButtonKt.RadioButton(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.RadioButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 2;
        RadioButtonPadding = Dp.m6614constructorimpl(f);
        RadioStrokeWidth = Dp.m6614constructorimpl(f);
    }
}
