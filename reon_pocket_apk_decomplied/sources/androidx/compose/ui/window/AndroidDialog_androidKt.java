package androidx.compose.ui.window;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
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

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\u0015\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u0002"}, d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
public final class AndroidDialog_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Dialog(kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.ui.window.DialogProperties r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r19
            r8 = r21
            r9 = r23
            r0 = -2032877254(0xffffffff86d4c13a, float:-8.002946E-35)
            r1 = r22
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Dialog)P(1,2)155@6564L7,156@6603L7,157@6658L7,158@6688L28,159@6743L29,160@6792L38,161@6848L616,182@7470L154,191@7630L193:AndroidDialog.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r24 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r9 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x002a
            boolean r1 = r6.changedInstance(r7)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r9
            goto L_0x002b
        L_0x002a:
            r1 = r9
        L_0x002b:
            r2 = r24 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0045
            r3 = r20
            boolean r4 = r6.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r20
        L_0x0047:
            r4 = r24 & 4
            if (r4 == 0) goto L_0x004e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004e:
            r4 = r9 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x005e
            boolean r4 = r6.changedInstance(r8)
            if (r4 == 0) goto L_0x005b
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r4
        L_0x005e:
            r4 = r1 & 731(0x2db, float:1.024E-42)
            r5 = 146(0x92, float:2.05E-43)
            if (r4 != r5) goto L_0x0072
            boolean r4 = r6.getSkipping()
            if (r4 != 0) goto L_0x006b
            goto L_0x0072
        L_0x006b:
            r6.skipToGroupEnd()
            r2 = r3
            r11 = r6
            goto L_0x0169
        L_0x0072:
            if (r2 == 0) goto L_0x0081
            androidx.compose.ui.window.DialogProperties r2 = new androidx.compose.ui.window.DialogProperties
            r14 = 7
            r15 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r10 = r2
            r10.<init>((boolean) r11, (boolean) r12, (androidx.compose.ui.window.SecureFlagPolicy) r13, (int) r14, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
            r5 = r2
            goto L_0x0082
        L_0x0081:
            r5 = r3
        L_0x0082:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x008e
            r2 = -1
            java.lang.String r3 = "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:154)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x008e:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r2 = r6.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r3 = r2
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            r2 = 0
            androidx.compose.runtime.CompositionContext r15 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r6, r2)
            int r1 = r1 >> 6
            r1 = r1 & 14
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r8, r6, r1)
            java.lang.Object[] r10 = new java.lang.Object[r2]
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1 r11 = androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1.INSTANCE
            r13 = r11
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r16 = 3080(0xc08, float:4.316E-42)
            r17 = 6
            r11 = 0
            r12 = 0
            r14 = r6
            r18 = r15
            r15 = r16
            r16 = r17
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            java.util.UUID r10 = (java.util.UUID) r10
            r11 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r11)
            boolean r11 = r6.changed((java.lang.Object) r4)
            boolean r12 = r6.changed((java.lang.Object) r0)
            r11 = r11 | r12
            java.lang.Object r12 = r6.rememberedValue()
            if (r11 != 0) goto L_0x0119
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x0115
            goto L_0x0119
        L_0x0115:
            r15 = r3
            r14 = r5
            r11 = r6
            goto L_0x0143
        L_0x0119:
            androidx.compose.ui.window.DialogWrapper r12 = new androidx.compose.ui.window.DialogWrapper
            r11 = r0
            r0 = r12
            r13 = r1
            r1 = r19
            r14 = r2
            r2 = r5
            r15 = r3
            r3 = r4
            r4 = r15
            r14 = r5
            r5 = r11
            r11 = r6
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
            r0.<init>(r13)
            r1 = 488261145(0x1d1a4619, float:2.041797E-21)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r1, r2, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r18
            r12.setContent(r1, r0)
            r11.updateRememberedValue(r12)
        L_0x0143:
            r11.endReplaceableGroup()
            androidx.compose.ui.window.DialogWrapper r12 = (androidx.compose.ui.window.DialogWrapper) r12
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1
            r0.<init>(r12)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r12, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r11, (int) r1)
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2
            r0.<init>(r12, r7, r14, r15)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r11, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0168
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0168:
            r2 = r14
        L_0x0169:
            androidx.compose.runtime.ScopeUpdateScope r6 = r11.endRestartGroup()
            if (r6 == 0) goto L_0x0182
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3 r10 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3
            r0 = r10
            r1 = r19
            r3 = r21
            r4 = r23
            r5 = r24
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r6.updateScope(r10)
        L_0x0182:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog(kotlin.jvm.functions.Function0, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void DialogLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1177876616);
        ComposerKt.sourceInformation(startRestartGroup, "C(DialogLayout)P(1)453@17860L455:AndroidDialog.android.kt#2oxthz");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1177876616, i3, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:452)");
            }
            MeasurePolicy measurePolicy = AndroidDialog_androidKt$DialogLayout$1.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int i5 = ((((((i3 >> 3) & 14) | 384) | ((i3 << 3) & 112)) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r5 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r5, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidDialog_androidKt$DialogLayout$2(modifier, function2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Dialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
