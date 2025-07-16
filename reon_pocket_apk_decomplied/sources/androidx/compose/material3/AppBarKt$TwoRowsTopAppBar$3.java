package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TwoRowsTopAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $actionsRow;
    final /* synthetic */ float $bottomTitleAlpha;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ boolean $hideBottomRowSemantics;
    final /* synthetic */ boolean $hideTopRowSemantics;
    final /* synthetic */ Ref.FloatRef $maxHeightPx;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ Ref.FloatRef $pinnedHeightPx;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ Function2<Composer, Integer, Unit> $smallTitle;
    final /* synthetic */ TextStyle $smallTitleTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ Ref.IntRef $titleBottomPaddingPx;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ float $topTitleAlpha;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TwoRowsTopAppBar$3(WindowInsets windowInsets, Ref.FloatRef floatRef, TopAppBarColors topAppBarColors, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Ref.FloatRef floatRef2, TopAppBarScrollBehavior topAppBarScrollBehavior, Function2<? super Composer, ? super Integer, Unit> function24, TextStyle textStyle2, float f2, Ref.IntRef intRef, boolean z2) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$pinnedHeightPx = floatRef;
        this.$colors = topAppBarColors;
        this.$smallTitle = function2;
        this.$smallTitleTextStyle = textStyle;
        this.$topTitleAlpha = f;
        this.$hideTopRowSemantics = z;
        this.$navigationIcon = function22;
        this.$actionsRow = function23;
        this.$maxHeightPx = floatRef2;
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$title = function24;
        this.$titleTextStyle = textStyle2;
        this.$bottomTitleAlpha = f2;
        this.$titleBottomPaddingPx = intRef;
        this.$hideBottomRowSemantics = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x01a3, code lost:
        r3 = r22.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r35, int r36) {
        /*
            r34 = this;
            r0 = r34
            r15 = r35
            r1 = r36
            java.lang.String r2 = "C1808@80392L2201:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001c
            boolean r2 = r35.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r35.skipToGroupEnd()
            goto L_0x0202
        L_0x001c:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002b
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1808)"
            r4 = 1985938853(0x765f05a5, float:1.1308561E33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x002b:
            androidx.compose.foundation.layout.WindowInsets r11 = r0.$windowInsets
            kotlin.jvm.internal.Ref$FloatRef r10 = r0.$pinnedHeightPx
            androidx.compose.material3.TopAppBarColors r9 = r0.$colors
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r0.$smallTitle
            androidx.compose.ui.text.TextStyle r13 = r0.$smallTitleTextStyle
            float r12 = r0.$topTitleAlpha
            boolean r7 = r0.$hideTopRowSemantics
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$navigationIcon
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$actionsRow
            kotlin.jvm.internal.Ref$FloatRef r6 = r0.$maxHeightPx
            androidx.compose.material3.TopAppBarScrollBehavior r3 = r0.$scrollBehavior
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$title
            androidx.compose.ui.text.TextStyle r2 = r0.$titleTextStyle
            float r1 = r0.$bottomTitleAlpha
            r16 = r14
            kotlin.jvm.internal.Ref$IntRef r14 = r0.$titleBottomPaddingPx
            r17 = r14
            boolean r14 = r0.$hideBottomRowSemantics
            r0 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.layout.Arrangement r18 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r19 = r1
            androidx.compose.foundation.layout.Arrangement$Vertical r1 = r18.getTop()
            androidx.compose.ui.Alignment$Companion r18 = androidx.compose.ui.Alignment.Companion
            r20 = r2
            androidx.compose.ui.Alignment$Horizontal r2 = r18.getStart()
            r18 = r3
            r3 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r1, r2, r15, r3)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r15, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r35.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r4
            kotlin.jvm.functions.Function0 r4 = r21.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r21 = r5
            androidx.compose.runtime.Applier r5 = r35.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x00a1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00a1:
            r35.startReusableNode()
            boolean r5 = r35.getInserting()
            if (r5 == 0) goto L_0x00ae
            r15.createNode(r4)
            goto L_0x00b1
        L_0x00ae:
            r35.useNode()
        L_0x00b1:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3282constructorimpl(r35)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r1, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r3 = r4.getInserting()
            if (r3 != 0) goto L_0x00e1
            java.lang.Object r3 = r4.rememberedValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x00ef
        L_0x00e1:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4.updateRememberedValue(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.apply(r2, r1)
        L_0x00ef:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r35)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r15, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r0)
            r0 = 276693656(0x107e0298, float:5.0094666E-29)
            java.lang.String r1 = "C79@3979L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = 1863931258(0x6f19557a, float:4.745454E28)
            java.lang.String r1 = "C1809@80413L982,1830@81408L1175:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.windowInsetsPadding(r0, r11)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.ClipKt.clipToBounds(r0)
            r0 = r19
            float r2 = r10.element
            r23 = r20
            long r3 = r9.m2613getNavigationIconContentColor0d7_KjU()
            r24 = r22
            r22 = r18
            long r18 = r9.m2615getTitleContentColor0d7_KjU()
            r25 = r6
            r5 = r18
            long r18 = r9.m2611getActionIconContentColor0d7_KjU()
            r26 = r7
            r27 = r8
            r7 = r18
            androidx.compose.foundation.layout.Arrangement r18 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r18 = r18.getCenter()
            androidx.compose.foundation.layout.Arrangement$Vertical r18 = (androidx.compose.foundation.layout.Arrangement.Vertical) r18
            r28 = r12
            r12 = r18
            androidx.compose.foundation.layout.Arrangement r18 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r18 = r18.getStart()
            r29 = r13
            r13 = r18
            r19 = 905969664(0x36000000, float:1.9073486E-6)
            r20 = 3078(0xc06, float:4.313E-42)
            r18 = 0
            r36 = r0
            r30 = r14
            r0 = r17
            r14 = r18
            r31 = r9
            r9 = r16
            r32 = r10
            r10 = r29
            r33 = r11
            r11 = r28
            r15 = r26
            r16 = r27
            r17 = r21
            r18 = r35
            androidx.compose.material3.AppBarKt.m1515TopAppBarLayoutkXwM9vE(r1, r2, r3, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.layout.WindowInsetsSides$Companion r2 = androidx.compose.foundation.layout.WindowInsetsSides.Companion
            int r2 = r2.m795getHorizontalJoeWqyM()
            r3 = r33
            androidx.compose.foundation.layout.WindowInsets r2 = androidx.compose.foundation.layout.WindowInsetsKt.m771onlybOOhFvg(r3, r2)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.windowInsetsPadding(r1, r2)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.ClipKt.clipToBounds(r1)
            r2 = r25
            float r2 = r2.element
            r3 = r32
            float r3 = r3.element
            float r2 = r2 - r3
            if (r22 == 0) goto L_0x01ae
            androidx.compose.material3.TopAppBarState r3 = r22.getState()
            if (r3 == 0) goto L_0x01ae
            float r3 = r3.getHeightOffset()
            goto L_0x01af
        L_0x01ae:
            r3 = 0
        L_0x01af:
            float r2 = r2 + r3
            long r3 = r31.m2613getNavigationIconContentColor0d7_KjU()
            long r5 = r31.m2615getTitleContentColor0d7_KjU()
            long r7 = r31.m2611getActionIconContentColor0d7_KjU()
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r12 = r9.getBottom()
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r13 = r9.getStart()
            int r14 = r0.element
            androidx.compose.material3.ComposableSingletons$AppBarKt r0 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r16 = r0.m1693getLambda11$material3_release()
            androidx.compose.material3.ComposableSingletons$AppBarKt r0 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r17 = r0.m1694getLambda12$material3_release()
            r19 = 905969664(0x36000000, float:1.9073486E-6)
            r20 = 3456(0xd80, float:4.843E-42)
            r9 = r24
            r10 = r23
            r11 = r36
            r15 = r30
            r18 = r35
            androidx.compose.material3.AppBarKt.m1515TopAppBarLayoutkXwM9vE(r1, r2, r3, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            r35.endReplaceableGroup()
            r35.endNode()
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0202
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0202:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
