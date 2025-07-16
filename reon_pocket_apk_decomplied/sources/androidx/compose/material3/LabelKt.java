package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a\\\u0010\t\u001a\u00020\u00012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0002"}, d2 = {"HandleInteractions", "", "enabled", "", "state", "Landroidx/compose/material3/BasicTooltipState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLandroidx/compose/material3/BasicTooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "Label", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/CaretScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "isPersistent", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release", "anchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Label.kt */
public final class LabelKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Label(kotlin.jvm.functions.Function3<? super androidx.compose.material3.CaretScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.ui.Modifier r21, androidx.compose.foundation.interaction.MutableInteractionSource r22, boolean r23, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r1 = r20
            r5 = r24
            r6 = r26
            r0 = -544399326(0xffffffffdf8d2022, float:-2.033833E19)
            r2 = r25
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(Label)P(3,4,1,2)66@2846L39,71@3060L38,77@3290L33,78@3340L257,95@3793L249,104@4047L127:Label.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r27 & 1
            r4 = 2
            if (r3 == 0) goto L_0x001c
            r3 = r6 | 6
            goto L_0x002c
        L_0x001c:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x002b
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = r4
        L_0x0029:
            r3 = r3 | r6
            goto L_0x002c
        L_0x002b:
            r3 = r6
        L_0x002c:
            r7 = r27 & 2
            if (r7 == 0) goto L_0x0033
            r3 = r3 | 48
            goto L_0x0046
        L_0x0033:
            r8 = r6 & 48
            if (r8 != 0) goto L_0x0046
            r8 = r21
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0042
            r9 = 32
            goto L_0x0044
        L_0x0042:
            r9 = 16
        L_0x0044:
            r3 = r3 | r9
            goto L_0x0048
        L_0x0046:
            r8 = r21
        L_0x0048:
            r9 = r27 & 4
            if (r9 == 0) goto L_0x004f
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r10 = r6 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0062
            r10 = r22
            boolean r11 = r2.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x005e
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r11
            goto L_0x0064
        L_0x0062:
            r10 = r22
        L_0x0064:
            r11 = r27 & 8
            if (r11 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r12 = r6 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r23
            boolean r13 = r2.changed((boolean) r12)
            if (r13 == 0) goto L_0x007a
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r13
            goto L_0x0080
        L_0x007e:
            r12 = r23
        L_0x0080:
            r13 = r27 & 16
            if (r13 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0087:
            r13 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0097
            boolean r13 = r2.changedInstance(r5)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r13
        L_0x0097:
            r13 = r3 & 9363(0x2493, float:1.312E-41)
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00ab
            boolean r13 = r2.getSkipping()
            if (r13 != 0) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            r2.skipToGroupEnd()
            r3 = r10
            r4 = r12
            goto L_0x01e4
        L_0x00ab:
            if (r7 == 0) goto L_0x00b4
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r17 = r7
            goto L_0x00b6
        L_0x00b4:
            r17 = r8
        L_0x00b6:
            java.lang.String r13 = "CC(remember):Label.kt#9igjgp"
            if (r9 == 0) goto L_0x00dd
            r7 = -2061465011(0xffffffff85208a4d, float:-7.548566E-36)
            r2.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            java.lang.Object r7 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x00d6
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r2.updateRememberedValue(r7)
        L_0x00d6:
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = (androidx.compose.foundation.interaction.MutableInteractionSource) r7
            r2.endReplaceableGroup()
            r15 = r7
            goto L_0x00de
        L_0x00dd:
            r15 = r10
        L_0x00de:
            r7 = 0
            if (r11 == 0) goto L_0x00e4
            r18 = r7
            goto L_0x00e6
        L_0x00e4:
            r18 = r12
        L_0x00e6:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00f2
            r8 = -1
            java.lang.String r9 = "androidx.compose.material3.Label (Label.kt:69)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r8, r9)
        L_0x00f2:
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            r8 = 0
            r9 = 48
            r14 = 1
            androidx.compose.ui.window.PopupPositionProvider r0 = r0.m2599rememberPlainTooltipPositionProviderkHDZbjc(r8, r2, r9, r14)
            r12 = 0
            if (r18 == 0) goto L_0x0131
            r8 = -2061464716(0xffffffff85208b74, float:-7.548777E-36)
            r2.startReplaceableGroup(r8)
            java.lang.String r9 = "73@3141L29"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            r2.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            java.lang.Object r8 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r8 != r9) goto L_0x0125
            androidx.compose.material3.LabelStateImpl r8 = new androidx.compose.material3.LabelStateImpl
            r9 = 3
            r8.<init>(r7, r7, r9, r12)
            r2.updateRememberedValue(r8)
        L_0x0125:
            androidx.compose.material3.LabelStateImpl r8 = (androidx.compose.material3.LabelStateImpl) r8
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.material3.BasicTooltipState r8 = (androidx.compose.material3.BasicTooltipState) r8
            r14 = r12
            goto L_0x0151
        L_0x0131:
            r7 = -2061464669(0xffffffff85208ba3, float:-7.548811E-36)
            r2.startReplaceableGroup(r7)
            java.lang.String r7 = "75@3188L56"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            androidx.compose.foundation.MutatorMutex r9 = new androidx.compose.foundation.MutatorMutex
            r9.<init>()
            r11 = 0
            r16 = 3
            r7 = 0
            r8 = 0
            r10 = r2
            r14 = r12
            r12 = r16
            androidx.compose.material3.BasicTooltipState r8 = androidx.compose.material3.BasicTooltipKt.rememberBasicTooltipState(r7, r8, r9, r10, r11, r12)
            r2.endReplaceableGroup()
        L_0x0151:
            r12 = r8
            r7 = -2061464567(0xffffffff85208c09, float:-7.548884E-36)
            r2.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            java.lang.Object r7 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x016e
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r14, r14, r4, r14)
            r2.updateRememberedValue(r7)
        L_0x016e:
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            r2.endReplaceableGroup()
            r4 = -2061464517(0xffffffff85208c3b, float:-7.54892E-36)
            r2.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            java.lang.Object r4 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r4 != r8) goto L_0x0190
            androidx.compose.material3.LabelKt$Label$scope$1$1 r4 = new androidx.compose.material3.LabelKt$Label$scope$1$1
            r4.<init>(r7)
            r2.updateRememberedValue(r4)
        L_0x0190:
            androidx.compose.material3.LabelKt$Label$scope$1$1 r4 = (androidx.compose.material3.LabelKt$Label$scope$1$1) r4
            r2.endReplaceableGroup()
            androidx.compose.material3.LabelKt$Label$wrappedContent$1 r8 = new androidx.compose.material3.LabelKt$Label$wrappedContent$1
            r8.<init>(r7, r5)
            r7 = 1950723216(0x7445ac90, float:6.2645414E31)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r7, r9, r8)
            r13 = r7
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            androidx.compose.material3.LabelKt$Label$2 r7 = new androidx.compose.material3.LabelKt$Label$2
            r7.<init>(r1, r4)
            r4 = 784196780(0x2ebde4ac, float:8.635345E-11)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r4, r9, r7)
            r8 = r4
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            int r4 = r3 << 6
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r7 = 1794096(0x1b6030, float:2.514064E-39)
            r4 = r4 | r7
            r16 = 0
            r11 = 0
            r14 = 0
            r7 = r0
            r9 = r12
            r10 = r17
            r0 = r12
            r12 = r14
            r14 = r2
            r19 = r15
            r15 = r4
            androidx.compose.material3.BasicTooltip_androidKt.BasicTooltipBox(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r4 = r18 ^ 1
            r3 = r3 & 896(0x380, float:1.256E-42)
            r10 = r19
            HandleInteractions(r4, r0, r10, r2, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01df
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01df:
            r3 = r10
            r8 = r17
            r4 = r18
        L_0x01e4:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x01fe
            androidx.compose.material3.LabelKt$Label$3 r10 = new androidx.compose.material3.LabelKt$Label$3
            r0 = r10
            r1 = r20
            r2 = r8
            r5 = r24
            r6 = r26
            r7 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x01fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.LabelKt.Label(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final LayoutCoordinates Label$lambda$3(MutableState<LayoutCoordinates> mutableState) {
        return (LayoutCoordinates) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final void HandleInteractions(boolean z, BasicTooltipState basicTooltipState, MutableInteractionSource mutableInteractionSource, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1479255681);
        ComposerKt.sourceInformation(startRestartGroup, "C(HandleInteractions)P(!1,2)119@4427L499,119@4393L533:Label.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) basicTooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1479255681, i2, -1, "androidx.compose.material3.HandleInteractions (Label.kt:117)");
            }
            if (z) {
                startRestartGroup.startReplaceableGroup(-404204353);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
                boolean z2 = true;
                boolean z3 = (i2 & 896) == 256;
                if ((i2 & 112) != 32) {
                    z2 = false;
                }
                boolean z4 = z3 | z2;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new LabelKt$HandleInteractions$1$1(mutableInteractionSource, basicTooltipState, (Continuation<? super LabelKt$HandleInteractions$1$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect((Object) mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue, startRestartGroup, (i2 >> 6) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LabelKt$HandleInteractions$2(z, basicTooltipState, mutableInteractionSource, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void Label$lambda$4(MutableState<LayoutCoordinates> mutableState, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
    }
}
