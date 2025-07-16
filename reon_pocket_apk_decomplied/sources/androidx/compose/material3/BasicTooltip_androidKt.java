package androidx.compose.material3;

import androidx.compose.foundation.R;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000f\u001a@\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a,\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/material3/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/material3/BasicTooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "WrappedAnchor", "(ZLandroidx/compose/material3/BasicTooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "anchorSemantics", "label", "", "enabled", "handleGestures", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTooltip.android.kt */
public final class BasicTooltip_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTooltipBox(androidx.compose.ui.window.PopupPositionProvider r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.material3.BasicTooltipState r22, androidx.compose.ui.Modifier r23, boolean r24, boolean r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r7 = r22
            r8 = r28
            r0 = 568522220(0x21e2f5ec, float:1.5379451E-18)
            r1 = r27
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicTooltipBox)P(4,6,5,3,2,1)82@3657L24,83@3686L451,102@4167L47,102@4143L71:BasicTooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r29 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r8 | 6
            r10 = r20
            goto L_0x002d
        L_0x001b:
            r1 = r8 & 6
            r10 = r20
            if (r1 != 0) goto L_0x002c
            boolean r1 = r9.changed((java.lang.Object) r10)
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
            r2 = r29 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r11 = r21
            goto L_0x0048
        L_0x0036:
            r2 = r8 & 48
            r11 = r21
            if (r2 != 0) goto L_0x0048
            boolean r2 = r9.changedInstance(r11)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r29 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004f:
            r2 = r8 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x005f
            boolean r2 = r9.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x005c
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r2 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r2
        L_0x005f:
            r2 = r29 & 8
            if (r2 == 0) goto L_0x0066
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r3 = r8 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0079
            r3 = r23
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0075
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r1 = r1 | r4
            goto L_0x007b
        L_0x0079:
            r3 = r23
        L_0x007b:
            r4 = r29 & 16
            if (r4 == 0) goto L_0x0082
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r5 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x0095
            r5 = r24
            boolean r6 = r9.changed((boolean) r5)
            if (r6 == 0) goto L_0x0091
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r1 = r1 | r6
            goto L_0x0097
        L_0x0095:
            r5 = r24
        L_0x0097:
            r6 = r29 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r6 == 0) goto L_0x009f
            r1 = r1 | r13
            goto L_0x00b1
        L_0x009f:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b1
            r13 = r25
            boolean r14 = r9.changed((boolean) r13)
            if (r14 == 0) goto L_0x00ad
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r1 = r1 | r14
            goto L_0x00b3
        L_0x00b1:
            r13 = r25
        L_0x00b3:
            r14 = r29 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bb
            r1 = r1 | r15
            goto L_0x00ce
        L_0x00bb:
            r14 = r8 & r15
            if (r14 != 0) goto L_0x00ce
            r14 = r26
            boolean r15 = r9.changedInstance(r14)
            if (r15 == 0) goto L_0x00ca
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00ca:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r1 = r1 | r15
            goto L_0x00d0
        L_0x00ce:
            r14 = r26
        L_0x00d0:
            r15 = r1
            r1 = 599187(0x92493, float:8.3964E-40)
            r1 = r1 & r15
            r12 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r12) goto L_0x00e8
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x00e1
            goto L_0x00e8
        L_0x00e1:
            r9.skipToGroupEnd()
            r4 = r3
            r6 = r13
            goto L_0x02ad
        L_0x00e8:
            if (r2 == 0) goto L_0x00f0
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r12 = r1
            goto L_0x00f1
        L_0x00f0:
            r12 = r3
        L_0x00f1:
            r16 = 1
            if (r4 == 0) goto L_0x00f8
            r17 = r16
            goto L_0x00fa
        L_0x00f8:
            r17 = r5
        L_0x00fa:
            if (r6 == 0) goto L_0x00fe
            r13 = r16
        L_0x00fe:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x010a
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.BasicTooltipBox (BasicTooltip.android.kt:81)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x010a:
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            java.lang.Object r0 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x013d
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r9)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r9.updateRememberedValue(r1)
            r0 = r1
        L_0x013d:
            r9.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r2 = r0.getCoroutineScope()
            r9.endReplaceableGroup()
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r6, r9, r6)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r3)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r6)
            androidx.compose.runtime.CompositionLocalMap r4 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r6 = r9.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x018b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x018b:
            r9.startReusableNode()
            boolean r6 = r9.getInserting()
            if (r6 == 0) goto L_0x0198
            r9.createNode(r5)
            goto L_0x019b
        L_0x0198:
            r9.useNode()
        L_0x019b:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3282constructorimpl(r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r4 = r5.getInserting()
            if (r4 != 0) goto L_0x01cb
            java.lang.Object r4 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x01d9
        L_0x01cb:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5.updateRememberedValue(r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.apply(r3, r1)
        L_0x01d9:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r6 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r0.invoke(r1, r9, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r1 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            java.lang.String r0 = "C94@3970L161:BasicTooltip.android.kt#uh7d8r"
            r1 = -1071913438(0xffffffffc01be622, float:-2.4359212)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r0)
            r9.startReplaceableGroup(r1)
            java.lang.String r0 = "85@3735L215"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r0 = r22.isVisible()
            if (r0 == 0) goto L_0x0234
            r0 = r15 & 14
            int r1 = r15 >> 3
            r3 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            int r3 = r15 << 9
            r1 = r1 & r3
            r18 = r0 | r1
            r0 = r20
            r1 = r22
            r3 = r17
            r4 = r21
            r5 = r9
            r19 = r6
            r6 = r18
            TooltipPopup(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0236
        L_0x0234:
            r19 = r6
        L_0x0236:
            r9.endReplaceableGroup()
            int r0 = r15 >> 15
            r0 = r0 & 14
            int r1 = r15 >> 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r15 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = r0 | r1
            r6 = 0
            r0 = r13
            r1 = r22
            r2 = r12
            r3 = r26
            r4 = r9
            WrappedAnchor(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            r0 = -1577643692(0xffffffffa1f71154, float:-1.6741958E-18)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):BasicTooltip.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = r15 & 896(0x380, float:1.256E-42)
            r1 = 256(0x100, float:3.59E-43)
            if (r0 != r1) goto L_0x027a
            goto L_0x027c
        L_0x027a:
            r16 = r19
        L_0x027c:
            java.lang.Object r0 = r9.rememberedValue()
            if (r16 != 0) goto L_0x028a
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0294
        L_0x028a:
            androidx.compose.material3.BasicTooltip_androidKt$BasicTooltipBox$2$1 r0 = new androidx.compose.material3.BasicTooltip_androidKt$BasicTooltipBox$2$1
            r0.<init>(r7)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9.updateRememberedValue(r0)
        L_0x0294:
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9.endReplaceableGroup()
            int r1 = r15 >> 6
            r1 = r1 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r9, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02a9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a9:
            r4 = r12
            r6 = r13
            r5 = r17
        L_0x02ad:
            androidx.compose.runtime.ScopeUpdateScope r12 = r9.endRestartGroup()
            if (r12 == 0) goto L_0x02ca
            androidx.compose.material3.BasicTooltip_androidKt$BasicTooltipBox$3 r13 = new androidx.compose.material3.BasicTooltip_androidKt$BasicTooltipBox$3
            r0 = r13
            r1 = r20
            r2 = r21
            r3 = r22
            r7 = r26
            r8 = r28
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x02ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BasicTooltip_androidKt.BasicTooltipBox(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.material3.BasicTooltipState, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void WrappedAnchor(boolean z, BasicTooltipState basicTooltipState, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(513239742);
        ComposerKt.sourceInformation(startRestartGroup, "C(WrappedAnchor)P(1,3,2)114@4408L24,115@4458L38,116@4501L163:BasicTooltip.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) basicTooltipState) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(513239742, i3, -1, "androidx.compose.material3.WrappedAnchor (BasicTooltip.android.kt:113)");
            }
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            Modifier anchorSemantics = anchorSemantics(handleGestures(modifier, z, basicTooltipState), StringResources_androidKt.stringResource(R.string.tooltip_label, startRestartGroup, 0), z, basicTooltipState, coroutineScope);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchorSemantics);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r6, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1276523287, "C119@4653L9:BasicTooltip.android.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTooltip_androidKt$WrappedAnchor$2(z, basicTooltipState, modifier2, function2, i, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TooltipPopup(androidx.compose.ui.window.PopupPositionProvider r21, androidx.compose.material3.BasicTooltipState r22, kotlinx.coroutines.CoroutineScope r23, boolean r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27) {
        /*
            r2 = r22
            r3 = r23
            r5 = r25
            r6 = r27
            r0 = -237130298(0xfffffffff1ddadc6, float:-2.1954005E30)
            r1 = r26
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r4 = "C(TooltipPopup)P(2,4,3,1)130@4901L44,133@5034L109,131@4950L464:BasicTooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            r4 = r6 & 6
            if (r4 != 0) goto L_0x0027
            r4 = r21
            boolean r7 = r1.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x0024
            r7 = 4
            goto L_0x0025
        L_0x0024:
            r7 = 2
        L_0x0025:
            r7 = r7 | r6
            goto L_0x002a
        L_0x0027:
            r4 = r21
            r7 = r6
        L_0x002a:
            r8 = r6 & 48
            r9 = 32
            if (r8 != 0) goto L_0x003b
            boolean r8 = r1.changed((java.lang.Object) r2)
            if (r8 == 0) goto L_0x0038
            r8 = r9
            goto L_0x003a
        L_0x0038:
            r8 = 16
        L_0x003a:
            r7 = r7 | r8
        L_0x003b:
            r8 = r6 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x004b
            boolean r8 = r1.changedInstance(r3)
            if (r8 == 0) goto L_0x0048
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x004a
        L_0x0048:
            r8 = 128(0x80, float:1.794E-43)
        L_0x004a:
            r7 = r7 | r8
        L_0x004b:
            r8 = r6 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x005e
            r8 = r24
            boolean r10 = r1.changed((boolean) r8)
            if (r10 == 0) goto L_0x005a
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x005c
        L_0x005a:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x005c:
            r7 = r7 | r10
            goto L_0x0060
        L_0x005e:
            r8 = r24
        L_0x0060:
            r10 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0070
            boolean r10 = r1.changedInstance(r5)
            if (r10 == 0) goto L_0x006d
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006f
        L_0x006d:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x006f:
            r7 = r7 | r10
        L_0x0070:
            r10 = r7 & 9363(0x2493, float:1.312E-41)
            r11 = 9362(0x2492, float:1.3119E-41)
            if (r10 != r11) goto L_0x0082
            boolean r10 = r1.getSkipping()
            if (r10 != 0) goto L_0x007d
            goto L_0x0082
        L_0x007d:
            r1.skipToGroupEnd()
            goto L_0x0108
        L_0x0082:
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x008e
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.TooltipPopup (BasicTooltip.android.kt:129)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r10, r11)
        L_0x008e:
            int r0 = androidx.compose.foundation.R.string.tooltip_description
            r10 = 0
            java.lang.String r0 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r0, r1, r10)
            r11 = 1291172190(0x4cf5b95e, float:1.28830192E8)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember):BasicTooltip.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r11 = r7 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r11 != r9) goto L_0x00a6
            r10 = r15
        L_0x00a6:
            boolean r9 = r1.changedInstance(r3)
            r9 = r9 | r10
            java.lang.Object r10 = r1.rememberedValue()
            if (r9 != 0) goto L_0x00b9
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x00c4
        L_0x00b9:
            androidx.compose.material3.BasicTooltip_androidKt$TooltipPopup$1$1 r9 = new androidx.compose.material3.BasicTooltip_androidKt$TooltipPopup$1$1
            r9.<init>(r2, r3)
            r10 = r9
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r1.updateRememberedValue(r10)
        L_0x00c4:
            r9 = r10
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r1.endReplaceableGroup()
            androidx.compose.ui.window.PopupProperties r19 = new androidx.compose.ui.window.PopupProperties
            r17 = 62
            r18 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r20 = 0
            r10 = r19
            r11 = r24
            r15 = r16
            r16 = r20
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            androidx.compose.material3.BasicTooltip_androidKt$TooltipPopup$2 r10 = new androidx.compose.material3.BasicTooltip_androidKt$TooltipPopup$2
            r10.<init>(r0, r5)
            r0 = 282408040(0x10d53468, float:8.409443E-29)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r11, r10)
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0 = r7 & 14
            r12 = r0 | 3072(0xc00, float:4.305E-42)
            r7 = r21
            r8 = r9
            r9 = r19
            r11 = r1
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0108
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0108:
            androidx.compose.runtime.ScopeUpdateScope r7 = r1.endRestartGroup()
            if (r7 == 0) goto L_0x0125
            androidx.compose.material3.BasicTooltip_androidKt$TooltipPopup$3 r8 = new androidx.compose.material3.BasicTooltip_androidKt$TooltipPopup$3
            r0 = r8
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BasicTooltip_androidKt.TooltipPopup(androidx.compose.ui.window.PopupPositionProvider, androidx.compose.material3.BasicTooltipState, kotlinx.coroutines.CoroutineScope, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z, BasicTooltipState basicTooltipState) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) basicTooltipState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTooltip_androidKt$handleGestures$1(basicTooltipState, (Continuation<? super BasicTooltip_androidKt$handleGestures$1>) null)), (Object) basicTooltipState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTooltip_androidKt$handleGestures$2(basicTooltipState, (Continuation<? super BasicTooltip_androidKt$handleGestures$2>) null)) : modifier;
    }

    private static final Modifier anchorSemantics(Modifier modifier, String str, boolean z, BasicTooltipState basicTooltipState, CoroutineScope coroutineScope) {
        return z ? SemanticsModifierKt.semantics(modifier, true, new BasicTooltip_androidKt$anchorSemantics$1(str, coroutineScope, basicTooltipState)) : modifier;
    }
}
