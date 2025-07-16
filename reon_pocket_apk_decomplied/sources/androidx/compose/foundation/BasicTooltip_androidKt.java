package androidx.compose.foundation;

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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000f\u001a@\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a,\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/foundation/BasicTooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "WrappedAnchor", "(ZLandroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "anchorSemantics", "label", "", "enabled", "handleGestures", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTooltip.android.kt */
public final class BasicTooltip_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTooltipBox(androidx.compose.ui.window.PopupPositionProvider r18, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.foundation.BasicTooltipState r20, androidx.compose.ui.Modifier r21, boolean r22, boolean r23, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r7 = r20
            r8 = r26
            r0 = -868234445(0xffffffffcc3fcb33, float:-5.027758E7)
            r1 = r25
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicTooltipBox)P(4,6,5,3,2,1)75@3416L24,76@3445L451,95@3902L71:BasicTooltip.android.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r27 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r8 | 6
            r10 = r18
            goto L_0x002d
        L_0x001b:
            r1 = r8 & 14
            r10 = r18
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
            r2 = r27 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r11 = r19
            goto L_0x0048
        L_0x0036:
            r2 = r8 & 112(0x70, float:1.57E-43)
            r11 = r19
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
            r2 = r27 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004f:
            r2 = r8 & 896(0x380, float:1.256E-42)
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
            r2 = r27 & 8
            if (r2 == 0) goto L_0x0066
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r3 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0079
            r3 = r21
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
            r3 = r21
        L_0x007b:
            r4 = r27 & 16
            r5 = 57344(0xe000, float:8.0356E-41)
            if (r4 == 0) goto L_0x0085
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r6 = r8 & r5
            if (r6 != 0) goto L_0x0098
            r6 = r22
            boolean r12 = r9.changed((boolean) r6)
            if (r12 == 0) goto L_0x0094
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r1 = r1 | r12
            goto L_0x009a
        L_0x0098:
            r6 = r22
        L_0x009a:
            r12 = r27 & 32
            if (r12 == 0) goto L_0x00a2
            r13 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r13
            goto L_0x00b6
        L_0x00a2:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b6
            r13 = r23
            boolean r14 = r9.changed((boolean) r13)
            if (r14 == 0) goto L_0x00b2
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r14
            goto L_0x00b8
        L_0x00b6:
            r13 = r23
        L_0x00b8:
            r14 = r27 & 64
            if (r14 == 0) goto L_0x00c0
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            goto L_0x00d4
        L_0x00c0:
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d4
            r14 = r24
            boolean r15 = r9.changedInstance(r14)
            if (r15 == 0) goto L_0x00d0
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r1 = r1 | r15
            goto L_0x00d6
        L_0x00d4:
            r14 = r24
        L_0x00d6:
            r15 = r1
            r1 = 2995931(0x2db6db, float:4.198194E-39)
            r1 = r1 & r15
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r5) goto L_0x00ef
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x00e7
            goto L_0x00ef
        L_0x00e7:
            r9.skipToGroupEnd()
            r4 = r3
            r5 = r6
            r6 = r13
            goto L_0x02a7
        L_0x00ef:
            if (r2 == 0) goto L_0x00f8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x00fa
        L_0x00f8:
            r16 = r3
        L_0x00fa:
            r1 = 1
            if (r4 == 0) goto L_0x0100
            r17 = r1
            goto L_0x0102
        L_0x0100:
            r17 = r6
        L_0x0102:
            if (r12 == 0) goto L_0x0105
            r13 = r1
        L_0x0105:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0111
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.BasicTooltipBox (BasicTooltip.android.kt:74)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x0111:
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
            if (r0 != r1) goto L_0x0144
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r9)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r9.updateRememberedValue(r1)
            r0 = r1
        L_0x0144:
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
            r3 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r3, r9, r3)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r3)
            androidx.compose.runtime.CompositionLocalMap r5 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r12 = r9.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0192
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0192:
            r9.startReusableNode()
            boolean r12 = r9.getInserting()
            if (r12 == 0) goto L_0x019f
            r9.createNode(r6)
            goto L_0x01a2
        L_0x019f:
            r9.useNode()
        L_0x01a2:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3282constructorimpl(r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r1, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x01d2
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r12)
            if (r5 != 0) goto L_0x01e0
        L_0x01d2:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6.updateRememberedValue(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.apply(r4, r1)
        L_0x01e0:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.invoke(r1, r9, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r1 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            java.lang.String r0 = "C87@3729L161:BasicTooltip.android.kt#71ulvw"
            r1 = 2056005864(0x7a8c28e8, float:3.638756E35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r0)
            r9.startReplaceableGroup(r1)
            java.lang.String r0 = "78@3494L215"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r0 = r20.isVisible()
            if (r0 == 0) goto L_0x0237
            r0 = r15 & 14
            r0 = r0 | 512(0x200, float:7.175E-43)
            int r1 = r15 >> 3
            r3 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r15 << 9
            r3 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r3
            r6 = r0 | r1
            r0 = r18
            r1 = r20
            r3 = r17
            r4 = r19
            r5 = r9
            TooltipPopup(r0, r1, r2, r3, r4, r5, r6)
        L_0x0237:
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
            r1 = r20
            r2 = r16
            r3 = r24
            r4 = r9
            WrappedAnchor(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            r0 = -1626833339(0xffffffff9f087e45, float:-2.8903568E-20)
            r9.startReplaceableGroup(r0)
            boolean r0 = r9.changed((java.lang.Object) r7)
            java.lang.Object r1 = r9.rememberedValue()
            if (r0 != 0) goto L_0x0282
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x028d
        L_0x0282:
            androidx.compose.foundation.BasicTooltip_androidKt$BasicTooltipBox$2$1 r0 = new androidx.compose.foundation.BasicTooltip_androidKt$BasicTooltipBox$2$1
            r0.<init>(r7)
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9.updateRememberedValue(r1)
        L_0x028d:
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9.endReplaceableGroup()
            int r0 = r15 >> 6
            r0 = r0 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r9, (int) r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02a2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a2:
            r6 = r13
            r4 = r16
            r5 = r17
        L_0x02a7:
            androidx.compose.runtime.ScopeUpdateScope r12 = r9.endRestartGroup()
            if (r12 == 0) goto L_0x02c4
            androidx.compose.foundation.BasicTooltip_androidKt$BasicTooltipBox$3 r13 = new androidx.compose.foundation.BasicTooltip_androidKt$BasicTooltipBox$3
            r0 = r13
            r1 = r18
            r2 = r19
            r3 = r20
            r7 = r24
            r8 = r26
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x02c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BasicTooltip_androidKt.BasicTooltipBox(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.foundation.BasicTooltipState, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void WrappedAnchor(boolean z, BasicTooltipState basicTooltipState, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1712976033);
        ComposerKt.sourceInformation(startRestartGroup, "C(WrappedAnchor)P(1,3,2)108@4208L24,109@4258L38,110@4301L171:BasicTooltip.android.kt#71ulvw");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) basicTooltipState) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1712976033, i3, -1, "androidx.compose.foundation.WrappedAnchor (BasicTooltip.android.kt:107)");
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
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1784805326, "C113@4461L9:BasicTooltip.android.kt#71ulvw");
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

    /* access modifiers changed from: private */
    public static final void TooltipPopup(PopupPositionProvider popupPositionProvider, BasicTooltipState basicTooltipState, CoroutineScope coroutineScope, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(-73658727);
        ComposerKt.sourceInformation(startRestartGroup, "C(TooltipPopup)P(2,4,3,1)125@4750L44,126@4799L464:BasicTooltip.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-73658727, i2, -1, "androidx.compose.foundation.TooltipPopup (BasicTooltip.android.kt:124)");
        }
        PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Composer composer2 = startRestartGroup;
        AndroidPopup_androidKt.Popup(popupPositionProvider2, new BasicTooltip_androidKt$TooltipPopup$1(basicTooltipState, coroutineScope), new PopupProperties(z, false, false, (SecureFlagPolicy) null, false, false, 62, (DefaultConstructorMarker) null), ComposableLambdaKt.composableLambda(startRestartGroup, -1147839433, true, new BasicTooltip_androidKt$TooltipPopup$2(StringResources_androidKt.stringResource(R.string.tooltip_description, startRestartGroup, 0), function2)), composer2, (i2 & 14) | 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTooltip_androidKt$TooltipPopup$3(popupPositionProvider, basicTooltipState, coroutineScope, z, function2, i));
        }
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z, BasicTooltipState basicTooltipState) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) basicTooltipState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTooltip_androidKt$handleGestures$1(basicTooltipState, (Continuation<? super BasicTooltip_androidKt$handleGestures$1>) null)), (Object) basicTooltipState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTooltip_androidKt$handleGestures$2(basicTooltipState, (Continuation<? super BasicTooltip_androidKt$handleGestures$2>) null)) : modifier;
    }

    private static final Modifier anchorSemantics(Modifier modifier, String str, boolean z, BasicTooltipState basicTooltipState, CoroutineScope coroutineScope) {
        return z ? SemanticsModifierKt.semantics(modifier, true, new BasicTooltip_androidKt$anchorSemantics$1(str, coroutineScope, basicTooltipState)) : modifier;
    }
}
