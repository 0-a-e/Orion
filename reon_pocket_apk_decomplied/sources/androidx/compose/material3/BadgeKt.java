package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001aR\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\f2\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001c\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u0002²\u0006\n\u0010 \u001a\u00020\u001fX\u0002²\u0006\n\u0010!\u001a\u00020\u001fX\u0002²\u0006\n\u0010\"\u001a\u00020\u001fX\u0002"}, d2 = {"BadgeOffset", "Landroidx/compose/ui/unit/Dp;", "getBadgeOffset", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "Badge", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgedBox", "badge", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release", "layoutAbsoluteLeft", "", "layoutAbsoluteTop", "greatGrandParentAbsoluteRight", "greatGrandParentAbsoluteTop"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Badge.kt */
public final class BadgeKt {
    private static final float BadgeOffset = Dp.m6614constructorimpl((float) 0);
    private static final float BadgeWithContentHorizontalOffset;
    private static final float BadgeWithContentHorizontalPadding = Dp.m6614constructorimpl((float) 4);
    private static final float BadgeWithContentVerticalOffset;

    /* JADX WARNING: Removed duplicated region for block: B:102:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BadgedBox(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r1 = r18
            r3 = r20
            r4 = r22
            r0 = 1404022535(0x53afaf07, float:1.5091115E12)
            r2 = r21
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r5 = "C(BadgedBox)P(!1,2)72@2860L36,73@2926L36,76@3145L57,77@3242L57,92@3688L531,102@4226L2679,79@3305L3600:Badge.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            r5 = r23 & 1
            if (r5 == 0) goto L_0x001b
            r5 = r4 | 6
            goto L_0x002b
        L_0x001b:
            r5 = r4 & 6
            if (r5 != 0) goto L_0x002a
            boolean r5 = r2.changedInstance(r1)
            if (r5 == 0) goto L_0x0027
            r5 = 4
            goto L_0x0028
        L_0x0027:
            r5 = 2
        L_0x0028:
            r5 = r5 | r4
            goto L_0x002b
        L_0x002a:
            r5 = r4
        L_0x002b:
            r6 = r23 & 2
            if (r6 == 0) goto L_0x0032
            r5 = r5 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r4 & 48
            if (r7 != 0) goto L_0x0045
            r7 = r19
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r5 = r5 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r19
        L_0x0047:
            r8 = r23 & 4
            if (r8 == 0) goto L_0x004e
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004e:
            r8 = r4 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x005e
            boolean r8 = r2.changedInstance(r3)
            if (r8 == 0) goto L_0x005b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r5 = r5 | r8
        L_0x005e:
            r8 = r5 & 147(0x93, float:2.06E-43)
            r9 = 146(0x92, float:2.05E-43)
            if (r8 != r9) goto L_0x0071
            boolean r8 = r2.getSkipping()
            if (r8 != 0) goto L_0x006b
            goto L_0x0071
        L_0x006b:
            r2.skipToGroupEnd()
            r6 = r7
            goto L_0x039c
        L_0x0071:
            if (r6 == 0) goto L_0x0078
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0079
        L_0x0078:
            r6 = r7
        L_0x0079:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0085
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.BadgedBox (Badge.kt:71)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r7, r8)
        L_0x0085:
            r0 = -1648447067(0xffffffff9dbeb1a5, float:-5.047626E-21)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Badge.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            java.lang.Object r7 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            r9 = 0
            if (r7 != r8) goto L_0x00a4
            androidx.compose.runtime.MutableFloatState r7 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r9)
            r2.updateRememberedValue(r7)
        L_0x00a4:
            androidx.compose.runtime.MutableFloatState r7 = (androidx.compose.runtime.MutableFloatState) r7
            r2.endReplaceableGroup()
            r8 = -1648447001(0xffffffff9dbeb1e7, float:-5.0476528E-21)
            r2.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            java.lang.Object r8 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r8 != r10) goto L_0x00c5
            androidx.compose.runtime.MutableFloatState r8 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r9)
            r2.updateRememberedValue(r8)
        L_0x00c5:
            androidx.compose.runtime.MutableFloatState r8 = (androidx.compose.runtime.MutableFloatState) r8
            r2.endReplaceableGroup()
            r9 = -1648446782(0xffffffff9dbeb2c2, float:-5.0477412E-21)
            r2.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            java.lang.Object r9 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r9 != r10) goto L_0x00e8
            r9 = 2139095040(0x7f800000, float:Infinity)
            androidx.compose.runtime.MutableFloatState r9 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r9)
            r2.updateRememberedValue(r9)
        L_0x00e8:
            androidx.compose.runtime.MutableFloatState r9 = (androidx.compose.runtime.MutableFloatState) r9
            r2.endReplaceableGroup()
            r10 = -1648446685(0xffffffff9dbeb323, float:-5.0477804E-21)
            r2.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            java.lang.Object r10 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r10 != r11) goto L_0x010b
            r10 = -8388608(0xffffffffff800000, float:-Infinity)
            androidx.compose.runtime.MutableFloatState r10 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r10)
            r2.updateRememberedValue(r10)
        L_0x010b:
            androidx.compose.runtime.MutableFloatState r10 = (androidx.compose.runtime.MutableFloatState) r10
            r2.endReplaceableGroup()
            r11 = -1648446239(0xffffffff9dbeb4e1, float:-5.0479606E-21)
            r2.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            java.lang.Object r11 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r11 != r12) goto L_0x012f
            androidx.compose.material3.BadgeKt$BadgedBox$2$1 r11 = new androidx.compose.material3.BadgeKt$BadgedBox$2$1
            r11.<init>(r7, r8, r9, r10)
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r2.updateRememberedValue(r11)
        L_0x012f:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r6, r11)
            r12 = -1648445701(0xffffffff9dbeb6fb, float:-5.048178E-21)
            r2.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            java.lang.Object r0 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r0 != r12) goto L_0x0157
            androidx.compose.material3.BadgeKt$BadgedBox$3$1 r0 = new androidx.compose.material3.BadgeKt$BadgedBox$3$1
            r0.<init>(r8, r7, r9, r10)
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            r2.updateRememberedValue(r0)
        L_0x0157:
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            r2.endReplaceableGroup()
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r7)
            java.lang.String r8 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r8)
            r9 = 0
            int r10 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r9)
            androidx.compose.runtime.CompositionLocalMap r12 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r11)
            androidx.compose.runtime.Applier r14 = r2.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0185
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0185:
            r2.startReusableNode()
            boolean r14 = r2.getInserting()
            if (r14 == 0) goto L_0x0192
            r2.createNode(r13)
            goto L_0x0195
        L_0x0192:
            r2.useNode()
        L_0x0195:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r13, r0, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r13, r12, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r12 = r13.getInserting()
            if (r12 != 0) goto L_0x01c5
            java.lang.Object r12 = r13.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 != 0) goto L_0x01d3
        L_0x01c5:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r13.updateRememberedValue(r12)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13.apply(r10, r0)
        L_0x01d3:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r0)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            r11.invoke(r0, r2, r10)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            r10 = 1541064737(0x5bdac821, float:1.23163178E17)
            java.lang.String r11 = "C81@3335L161,86@3509L105:Badge.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r10, r11)
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            java.lang.String r11 = "anchor"
            androidx.compose.ui.Modifier r10 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r10, r11)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r11.getCenter()
            int r12 = r5 << 3
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | 54
            r13 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r13)
            java.lang.String r14 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            r15 = 6
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r11, r9, r2, r15)
            r2.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r8)
            int r16 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r9)
            androidx.compose.runtime.CompositionLocalMap r7 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r10)
            androidx.compose.runtime.Applier r15 = r2.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0239
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0239:
            r2.startReusableNode()
            boolean r15 = r2.getInserting()
            if (r15 == 0) goto L_0x0246
            r2.createNode(r13)
            goto L_0x0249
        L_0x0246:
            r2.useNode()
        L_0x0249:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r13, r11, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r13, r7, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            boolean r11 = r13.getInserting()
            if (r11 != 0) goto L_0x0279
            java.lang.Object r11 = r13.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r16)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r15)
            if (r11 != 0) goto L_0x0287
        L_0x0279:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)
            r13.updateRememberedValue(r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)
            r13.apply(r11, r7)
        L_0x0287:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r7)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            r10.invoke(r7, r2, r11)
            r2.startReplaceableGroup(r0)
            r7 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r10 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r10)
            androidx.compose.foundation.layout.BoxScopeInstance r11 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r13 = 6
            int r12 = r12 >> r13
            r12 = r12 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r3.invoke(r11, r2, r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            java.lang.String r12 = "badge"
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r11, r12)
            int r5 = r5 << 9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r12 = 6
            r5 = r5 | r12
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r9, r2, r9)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r8)
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r9)
            androidx.compose.runtime.CompositionLocalMap r13 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r11)
            androidx.compose.runtime.Applier r15 = r2.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0307
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0307:
            r2.startReusableNode()
            boolean r15 = r2.getInserting()
            if (r15 == 0) goto L_0x0314
            r2.createNode(r14)
            goto L_0x0317
        L_0x0314:
            r2.useNode()
        L_0x0317:
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r14, r12, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r14, r13, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetCompositeKeyHash()
            boolean r13 = r14.getInserting()
            if (r13 != 0) goto L_0x0347
            java.lang.Object r13 = r14.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r15)
            if (r13 != 0) goto L_0x0355
        L_0x0347:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            r14.updateRememberedValue(r13)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r14.apply(r8, r12)
        L_0x0355:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r11.invoke(r8, r2, r9)
            r2.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r10)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r7 = 6
            int r5 = r5 >> r7
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | r7
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.invoke(r0, r2, r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x039c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x039c:
            androidx.compose.runtime.ScopeUpdateScope r7 = r2.endRestartGroup()
            if (r7 == 0) goto L_0x03b6
            androidx.compose.material3.BadgeKt$BadgedBox$4 r8 = new androidx.compose.material3.BadgeKt$BadgedBox$4
            r0 = r8
            r1 = r18
            r2 = r6
            r3 = r20
            r4 = r22
            r5 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x03b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BadgeKt.BadgedBox(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float BadgedBox$lambda$1(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* access modifiers changed from: private */
    public static final float BadgedBox$lambda$4(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* access modifiers changed from: private */
    public static final float BadgedBox$lambda$7(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* access modifiers changed from: private */
    public static final float BadgedBox$lambda$10(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0092  */
    /* renamed from: Badge-eopBjH0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1529BadgeeopBjH0(androidx.compose.ui.Modifier r16, long r17, long r19, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r23
            r0 = 1298144073(0x4d601b49, float:2.34992784E8)
            r1 = r22
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Badge)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color)180@7847L14,181@7889L31,192@8223L919:Badge.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r24 & 1
            r3 = 2
            if (r2 == 0) goto L_0x001b
            r4 = r7 | 6
            r5 = r4
            r4 = r16
            goto L_0x002f
        L_0x001b:
            r4 = r7 & 6
            if (r4 != 0) goto L_0x002c
            r4 = r16
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0029
            r5 = 4
            goto L_0x002a
        L_0x0029:
            r5 = r3
        L_0x002a:
            r5 = r5 | r7
            goto L_0x002f
        L_0x002c:
            r4 = r16
            r5 = r7
        L_0x002f:
            r6 = r7 & 48
            if (r6 != 0) goto L_0x0046
            r6 = r24 & 2
            r8 = r17
            if (r6 != 0) goto L_0x0042
            boolean r6 = r1.changed((long) r8)
            if (r6 == 0) goto L_0x0042
            r6 = 32
            goto L_0x0044
        L_0x0042:
            r6 = 16
        L_0x0044:
            r5 = r5 | r6
            goto L_0x0048
        L_0x0046:
            r8 = r17
        L_0x0048:
            r6 = r7 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005f
            r6 = r24 & 4
            r10 = r19
            if (r6 != 0) goto L_0x005b
            boolean r6 = r1.changed((long) r10)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r5 = r5 | r6
            goto L_0x0061
        L_0x005f:
            r10 = r19
        L_0x0061:
            r6 = r24 & 8
            if (r6 == 0) goto L_0x0068
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r12 = r7 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007b
            r12 = r21
            boolean r13 = r1.changedInstance(r12)
            if (r13 == 0) goto L_0x0077
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r5 = r5 | r13
            goto L_0x007d
        L_0x007b:
            r12 = r21
        L_0x007d:
            r13 = r5 & 1171(0x493, float:1.641E-42)
            r14 = 1170(0x492, float:1.64E-42)
            if (r13 != r14) goto L_0x0092
            boolean r13 = r1.getSkipping()
            if (r13 != 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            r1.skipToGroupEnd()
            r2 = r4
        L_0x008e:
            r4 = r10
            r6 = r12
            goto L_0x0269
        L_0x0092:
            r1.startDefaults()
            r13 = r7 & 1
            r14 = 0
            r15 = 6
            if (r13 == 0) goto L_0x00b3
            boolean r13 = r1.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00a2
            goto L_0x00b3
        L_0x00a2:
            r1.skipToGroupEnd()
            r2 = r24 & 2
            if (r2 == 0) goto L_0x00ab
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ab:
            r2 = r24 & 4
            if (r2 == 0) goto L_0x00b1
            r5 = r5 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00b1:
            r2 = r4
            goto L_0x00d9
        L_0x00b3:
            if (r2 == 0) goto L_0x00ba
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00bb
        L_0x00ba:
            r2 = r4
        L_0x00bb:
            r4 = r24 & 2
            if (r4 == 0) goto L_0x00c7
            androidx.compose.material3.BadgeDefaults r4 = androidx.compose.material3.BadgeDefaults.INSTANCE
            long r8 = r4.getContainerColor(r1, r15)
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00c7:
            r4 = r24 & 4
            if (r4 == 0) goto L_0x00d6
            int r4 = r5 >> 3
            r4 = r4 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r8, r1, r4)
            r4 = r5 & -897(0xfffffffffffffc7f, float:NaN)
            r5 = r4
        L_0x00d6:
            if (r6 == 0) goto L_0x00d9
            r12 = r14
        L_0x00d9:
            r1.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00e8
            r4 = -1
            java.lang.String r6 = "androidx.compose.material3.Badge (Badge.kt:183)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r4, r6)
        L_0x00e8:
            androidx.compose.material3.tokens.BadgeTokens r0 = androidx.compose.material3.tokens.BadgeTokens.INSTANCE
            if (r12 == 0) goto L_0x00f1
            float r0 = r0.m2656getLargeSizeD9Ej5fM()
            goto L_0x00f5
        L_0x00f1:
            float r0 = r0.m2657getSizeD9Ej5fM()
        L_0x00f5:
            if (r12 == 0) goto L_0x0110
            r4 = 1947277315(0x74111803, float:4.598206E31)
            r1.startReplaceableGroup(r4)
            java.lang.String r4 = "186@8132L5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            androidx.compose.material3.tokens.BadgeTokens r4 = androidx.compose.material3.tokens.BadgeTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r4 = r4.getLargeShape()
            androidx.compose.ui.graphics.Shape r4 = androidx.compose.material3.ShapesKt.getValue(r4, r1, r15)
            r1.endReplaceableGroup()
            goto L_0x0128
        L_0x0110:
            r4 = 1947277365(0x74111835, float:4.59823E31)
            r1.startReplaceableGroup(r4)
            java.lang.String r4 = "188@8177L5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            androidx.compose.material3.tokens.BadgeTokens r4 = androidx.compose.material3.tokens.BadgeTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r4 = r4.getShape()
            androidx.compose.ui.graphics.Shape r4 = androidx.compose.material3.ShapesKt.getValue(r4, r1, r15)
            r1.endReplaceableGroup()
        L_0x0128:
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m726defaultMinSizeVpY3zN4(r2, r0, r0)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m213backgroundbw27NRU(r0, r8, r4)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ClipKt.clip(r0, r4)
            if (r12 == 0) goto L_0x0142
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            float r6 = BadgeWithContentHorizontalPadding
            r13 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m672paddingVpY3zN4$default(r4, r6, r13, r3, r14)
            goto L_0x0146
        L_0x0142:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
        L_0x0146:
            androidx.compose.ui.Modifier r0 = r0.then(r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r3.getCenterVertically()
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r4 = r4.getCenter()
            r6 = 693286680(0x2952b718, float:4.6788176E-14)
            r1.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            androidx.compose.foundation.layout.Arrangement$Horizontal r4 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r4
            r6 = 54
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r4, r3, r1, r6)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            r4 = 0
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r4)
            androidx.compose.runtime.CompositionLocalMap r13 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r15 = r1.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0192
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0192:
            r1.startReusableNode()
            boolean r15 = r1.getInserting()
            if (r15 == 0) goto L_0x019f
            r1.createNode(r14)
            goto L_0x01a2
        L_0x019f:
            r1.useNode()
        L_0x01a2:
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m3282constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r14, r3, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r14, r13, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r13 = r14.getInserting()
            if (r13 != 0) goto L_0x01d2
            java.lang.Object r13 = r14.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r6)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r15)
            if (r13 != 0) goto L_0x01e0
        L_0x01d2:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r14.updateRememberedValue(r13)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r14.apply(r6, r3)
        L_0x01e0:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r3)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.invoke(r3, r1, r4)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            r0 = -326681643(0xffffffffec873bd5, float:-1.3079003E27)
            java.lang.String r3 = "C92@4661L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r3)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            r3 = -193557333(0xfffffffff4768cab, float:-7.813465E31)
            java.lang.String r4 = "C:Badge.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r3, r4)
            r3 = 1947277962(0x74111a8a, float:4.598519E31)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "209@8898L10,210@8963L163"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            if (r12 == 0) goto L_0x0249
            androidx.compose.material3.MaterialTheme r3 = androidx.compose.material3.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material3.Typography r3 = r3.getTypography(r1, r4)
            androidx.compose.material3.tokens.BadgeTokens r6 = androidx.compose.material3.tokens.BadgeTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r6 = r6.getLargeLabelTextFont()
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.material3.TypographyKt.fromToken(r3, r6)
            androidx.compose.material3.BadgeKt$Badge$1$1 r6 = new androidx.compose.material3.BadgeKt$Badge$1$1
            r6.<init>(r12, r0)
            r0 = 719214594(0x2ade5802, float:3.949619E-13)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r13, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r4 = r5 >> 6
            r4 = r4 & 14
            r4 = r4 | 384(0x180, float:5.38E-43)
            r16 = r10
            r18 = r3
            r19 = r0
            r20 = r1
            r21 = r4
            androidx.compose.material3.ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(r16, r18, r19, r20, r21)
        L_0x0249:
            r1.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x008e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x008e
        L_0x0269:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x0280
            androidx.compose.material3.BadgeKt$Badge$2 r11 = new androidx.compose.material3.BadgeKt$Badge$2
            r0 = r11
            r1 = r2
            r2 = r8
            r7 = r23
            r8 = r24
            r0.<init>(r1, r2, r4, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0280:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BadgeKt.m1529BadgeeopBjH0(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeWithContentVerticalOffset;
    }

    public static final float getBadgeOffset() {
        return BadgeOffset;
    }

    /* access modifiers changed from: private */
    public static final void BadgedBox$lambda$2(MutableFloatState mutableFloatState, float f) {
        mutableFloatState.setFloatValue(f);
    }

    /* access modifiers changed from: private */
    public static final void BadgedBox$lambda$5(MutableFloatState mutableFloatState, float f) {
        mutableFloatState.setFloatValue(f);
    }

    /* access modifiers changed from: private */
    public static final void BadgedBox$lambda$8(MutableFloatState mutableFloatState, float f) {
        mutableFloatState.setFloatValue(f);
    }

    /* access modifiers changed from: private */
    public static final void BadgedBox$lambda$11(MutableFloatState mutableFloatState, float f) {
        mutableFloatState.setFloatValue(f);
    }

    static {
        float f = (float) 6;
        BadgeWithContentHorizontalOffset = Dp.m6614constructorimpl(-Dp.m6614constructorimpl(f));
        BadgeWithContentVerticalOffset = Dp.m6614constructorimpl(f);
    }
}
