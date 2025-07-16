package androidx.compose.material3.internal;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0001¢\u0006\u0002\u0010\b\u001a+\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0013\b\b\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\b¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u0002²\u0006\u0015\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u0002"}, d2 = {"ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release", "isTouchExplorationEnabled", "", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.android.kt */
public final class ExposedDropdownMenuPopup_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: androidx.compose.material3.internal.PopupLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: androidx.compose.material3.internal.PopupLayout} */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0<kotlin.Unit> r21, androidx.compose.ui.window.PopupPositionProvider r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r3 = r23
            r4 = r25
            r0 = -727958629(0xffffffffd49c3b9b, float:-5.3681193E12)
            r1 = r24
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ExposedDropdownMenuPopup)P(1,2)85@3452L7,86@3491L7,87@3546L7,88@3591L23,90@3644L28,91@3699L29,92@3747L38,93@3808L964,120@4808L319,120@4778L349,133@5144L150,133@5133L161,145@5551L462,156@6020L99,143@5472L647:ExposedDropdownMenuPopup.android.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x001c
            r5 = r4 | 6
            r6 = r5
            r5 = r21
            goto L_0x0030
        L_0x001c:
            r5 = r4 & 6
            if (r5 != 0) goto L_0x002d
            r5 = r21
            boolean r6 = r1.changedInstance(r5)
            if (r6 == 0) goto L_0x002a
            r6 = 4
            goto L_0x002b
        L_0x002a:
            r6 = 2
        L_0x002b:
            r6 = r6 | r4
            goto L_0x0030
        L_0x002d:
            r5 = r21
            r6 = r4
        L_0x0030:
            r7 = r26 & 2
            if (r7 == 0) goto L_0x0039
            r6 = r6 | 48
            r15 = r22
            goto L_0x004b
        L_0x0039:
            r7 = r4 & 48
            r15 = r22
            if (r7 != 0) goto L_0x004b
            boolean r7 = r1.changed((java.lang.Object) r15)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r6 = r6 | r7
        L_0x004b:
            r7 = r26 & 4
            if (r7 == 0) goto L_0x0052
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x0052:
            r7 = r4 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0062
            boolean r7 = r1.changedInstance(r3)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r6 = r6 | r7
        L_0x0062:
            r14 = r6
            r6 = r14 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r6 != r7) goto L_0x0076
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x0070
            goto L_0x0076
        L_0x0070:
            r1.skipToGroupEnd()
            r2 = r5
            goto L_0x02c5
        L_0x0076:
            if (r2 == 0) goto L_0x007a
            r2 = 0
            goto L_0x007b
        L_0x007a:
            r2 = r5
        L_0x007b:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0087
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.android.kt:84)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r5, r6)
        L_0x0087:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r6)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            android.view.View r0 = (android.view.View) r0
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r6)
            java.lang.Object r7 = r1.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r18 = r7
            androidx.compose.ui.unit.Density r18 = (androidx.compose.ui.unit.Density) r18
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r6)
            java.lang.Object r5 = r1.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r13 = r5
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            r11 = 0
            androidx.compose.runtime.State r16 = androidx.compose.material3.TouchExplorationStateProvider_androidKt.touchExplorationState(r1, r11)
            androidx.compose.runtime.CompositionContext r10 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r1, r11)
            int r5 = r14 >> 6
            r5 = r5 & 14
            androidx.compose.runtime.State r9 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r3, r1, r5)
            java.lang.Object[] r5 = new java.lang.Object[r11]
            androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupId$1 r6 = androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupId$1.INSTANCE
            r8 = r6
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r17 = 3072(0xc00, float:4.305E-42)
            r19 = 6
            r6 = 0
            r7 = 0
            r12 = r9
            r9 = r1
            r20 = r10
            r10 = r17
            r3 = r11
            r11 = r19
            java.lang.Object r5 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r5, r6, (java.lang.String) r7, r8, (androidx.compose.runtime.Composer) r9, (int) r10, (int) r11)
            r19 = r5
            java.util.UUID r19 = (java.util.UUID) r19
            boolean r5 = ExposedDropdownMenuPopup$lambda$0(r16)
            r6 = -246571242(0xfffffffff14d9f16, float:-1.018188E30)
            r1.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            boolean r5 = r1.changed((boolean) r5)
            java.lang.Object r7 = r1.rememberedValue()
            r11 = 1
            if (r5 != 0) goto L_0x011a
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x0117
            goto L_0x011a
        L_0x0117:
            r5 = r13
            r8 = r14
            goto L_0x0140
        L_0x011a:
            androidx.compose.material3.internal.PopupLayout r7 = new androidx.compose.material3.internal.PopupLayout
            boolean r17 = ExposedDropdownMenuPopup$lambda$0(r16)
            r5 = r13
            r13 = r7
            r8 = r14
            r14 = r2
            r15 = r0
            r16 = r22
            r13.<init>(r14, r15, r16, r17, r18, r19)
            androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1 r0 = new androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1
            r0.<init>(r7, r12)
            r9 = -493861435(0xffffffffe29045c5, float:-1.3306793E21)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r9, r11, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9 = r20
            r7.setContent(r9, r0)
            r1.updateRememberedValue(r7)
        L_0x0140:
            androidx.compose.material3.internal.PopupLayout r7 = (androidx.compose.material3.internal.PopupLayout) r7
            r1.endReplaceableGroup()
            r0 = -246570242(0xfffffffff14da2fe, float:-1.01826356E30)
            r1.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            boolean r0 = r1.changedInstance(r7)
            r8 = r8 & 14
            r9 = 4
            if (r8 != r9) goto L_0x0159
            r9 = r11
            goto L_0x015a
        L_0x0159:
            r9 = r3
        L_0x015a:
            r0 = r0 | r9
            boolean r9 = r1.changed((java.lang.Object) r5)
            r0 = r0 | r9
            java.lang.Object r9 = r1.rememberedValue()
            if (r0 != 0) goto L_0x016e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r9 != r0) goto L_0x0179
        L_0x016e:
            androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1 r0 = new androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1
            r0.<init>(r7, r2, r5)
            r9 = r0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r1.updateRememberedValue(r9)
        L_0x0179:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r1.endReplaceableGroup()
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r9, (androidx.compose.runtime.Composer) r1, (int) r3)
            r0 = -246569906(0xfffffffff14da44e, float:-1.01828895E30)
            r1.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            boolean r0 = r1.changedInstance(r7)
            r9 = 4
            if (r8 != r9) goto L_0x0192
            goto L_0x0193
        L_0x0192:
            r11 = r3
        L_0x0193:
            r0 = r0 | r11
            boolean r8 = r1.changed((java.lang.Object) r5)
            r0 = r0 | r8
            java.lang.Object r8 = r1.rememberedValue()
            if (r0 != 0) goto L_0x01a7
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r8 != r0) goto L_0x01b2
        L_0x01a7:
            androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$2$1 r0 = new androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$2$1
            r0.<init>(r7, r2, r5)
            r8 = r0
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r1.updateRememberedValue(r8)
        L_0x01b2:
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r1.endReplaceableGroup()
            androidx.compose.runtime.EffectsKt.SideEffect(r8, r1, r3)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r8 = -246569499(0xfffffffff14da5e5, float:-1.0183197E30)
            r1.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            boolean r8 = r1.changedInstance(r7)
            java.lang.Object r9 = r1.rememberedValue()
            if (r8 != 0) goto L_0x01d9
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x01e4
        L_0x01d9:
            androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$4$1 r8 = new androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$4$1
            r8.<init>(r7)
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r1.updateRememberedValue(r9)
        L_0x01e4:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r9)
            r8 = -246569030(0xfffffffff14da7ba, float:-1.0183551E30)
            r1.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            boolean r6 = r1.changedInstance(r7)
            boolean r8 = r1.changed((java.lang.Object) r5)
            r6 = r6 | r8
            java.lang.Object r8 = r1.rememberedValue()
            if (r6 != 0) goto L_0x020d
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r8 != r6) goto L_0x0218
        L_0x020d:
            androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$5$1 r6 = new androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$5$1
            r6.<init>(r7, r5)
            r8 = r6
            androidx.compose.ui.layout.MeasurePolicy r8 = (androidx.compose.ui.layout.MeasurePolicy) r8
            r1.updateRememberedValue(r8)
        L_0x0218:
            androidx.compose.ui.layout.MeasurePolicy r8 = (androidx.compose.ui.layout.MeasurePolicy) r8
            r1.endReplaceableGroup()
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r3)
            androidx.compose.runtime.CompositionLocalMap r6 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r9 = r1.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0245
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0245:
            r1.startReusableNode()
            boolean r9 = r1.getInserting()
            if (r9 == 0) goto L_0x0252
            r1.createNode(r7)
            goto L_0x0255
        L_0x0252:
            r1.useNode()
        L_0x0255:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3282constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r8, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r6, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r8 = r7.getInserting()
            if (r8 != 0) goto L_0x0285
            java.lang.Object r8 = r7.rememberedValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x0293
        L_0x0285:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r7.updateRememberedValue(r8)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.apply(r5, r6)
        L_0x0293:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.invoke(r5, r1, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            r0 = 571475666(0x221006d2, float:1.951925E-18)
            java.lang.String r3 = "C:ExposedDropdownMenuPopup.android.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02c5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02c5:
            androidx.compose.runtime.ScopeUpdateScope r6 = r1.endRestartGroup()
            if (r6 == 0) goto L_0x02df
            androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6 r7 = new androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6
            r0 = r7
            r1 = r2
            r2 = r22
            r3 = r23
            r4 = r25
            r5 = r26
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x02df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(437877758);
        ComposerKt.sourceInformation(composer, "CC(SimpleStack)P(1)167@6382L979:ExposedDropdownMenuPopup.android.kt#mqatfk");
        MeasurePolicy measurePolicy = ExposedDropdownMenuPopup_androidKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        int i2 = (((((i << 3) & 112) | ((i >> 3) & 14)) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer r4 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r4, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    private static final boolean ExposedDropdownMenuPopup$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
