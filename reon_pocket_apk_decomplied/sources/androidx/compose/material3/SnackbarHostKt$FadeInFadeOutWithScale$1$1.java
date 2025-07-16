package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "children", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "invoke", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$FadeInFadeOutWithScale$1$1 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ SnackbarData $current;
    final /* synthetic */ SnackbarData $key;
    final /* synthetic */ List<SnackbarData> $keys;
    final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$FadeInFadeOutWithScale$1$1(SnackbarData snackbarData, SnackbarData snackbarData2, List<SnackbarData> list, FadeInFadeOutState<SnackbarData> fadeInFadeOutState) {
        super(3);
        this.$key = snackbarData;
        this.$current = snackbarData2;
        this.$keys = list;
        this.$state = fadeInFadeOutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            r39 = this;
            r0 = r39
            r1 = r40
            r8 = r41
            java.lang.String r2 = "C372@13899L289,365@13588L618,380@14235L292,395@14829L150,388@14544L504:SnackbarHost.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = r42 & 6
            if (r2 != 0) goto L_0x001c
            boolean r2 = r8.changedInstance(r1)
            if (r2 == 0) goto L_0x0017
            r2 = 4
            goto L_0x0018
        L_0x0017:
            r2 = 2
        L_0x0018:
            r2 = r42 | r2
            r9 = r2
            goto L_0x001e
        L_0x001c:
            r9 = r42
        L_0x001e:
            r2 = r9 & 19
            r3 = 18
            if (r2 != r3) goto L_0x0030
            boolean r2 = r41.getSkipping()
            if (r2 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            r41.skipToGroupEnd()
            goto L_0x0214
        L_0x0030:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x003f
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:357)"
            r4 = -1654683077(0xffffffff9d5f8a3b, float:-2.9585268E-21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r9, r2, r3)
        L_0x003f:
            androidx.compose.material3.SnackbarData r2 = r0.$key
            androidx.compose.material3.SnackbarData r3 = r0.$current
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            r2 = 75
            if (r10 == 0) goto L_0x004f
            r3 = 150(0x96, float:2.1E-43)
            r11 = r3
            goto L_0x0050
        L_0x004f:
            r11 = r2
        L_0x0050:
            r12 = 1
            r13 = 0
            if (r10 == 0) goto L_0x0062
            java.util.List<androidx.compose.material3.SnackbarData> r3 = r0.$keys
            java.util.List r3 = androidx.compose.ui.util.ListUtilsKt.fastFilterNotNull(r3)
            int r3 = r3.size()
            if (r3 == r12) goto L_0x0062
            r14 = r2
            goto L_0x0063
        L_0x0062:
            r14 = r13
        L_0x0063:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween(r11, r14, r2)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r3 = 870026295(0x33db8c37, float:1.0223487E-7)
            r8.startReplaceableGroup(r3)
            java.lang.String r15 = "CC(remember):SnackbarHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r15)
            androidx.compose.material3.SnackbarData r3 = r0.$key
            boolean r3 = r8.changed((java.lang.Object) r3)
            androidx.compose.material3.FadeInFadeOutState<androidx.compose.material3.SnackbarData> r4 = r0.$state
            boolean r4 = r8.changedInstance(r4)
            r3 = r3 | r4
            androidx.compose.material3.SnackbarData r4 = r0.$key
            androidx.compose.material3.FadeInFadeOutState<androidx.compose.material3.SnackbarData> r5 = r0.$state
            java.lang.Object r6 = r41.rememberedValue()
            if (r3 != 0) goto L_0x0097
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x00a2
        L_0x0097:
            androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1 r3 = new androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1
            r3.<init>(r4, r5)
            r6 = r3
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r8.updateRememberedValue(r6)
        L_0x00a2:
            r4 = r6
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r41.endReplaceableGroup()
            r6 = 0
            r7 = 0
            r3 = r10
            r5 = r41
            androidx.compose.runtime.State r2 = androidx.compose.material3.SnackbarHostKt.animatedOpacity(r2, r3, r4, r5, r6, r7)
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getFastOutSlowInEasing()
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween(r11, r14, r3)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            androidx.compose.runtime.State r3 = androidx.compose.material3.SnackbarHostKt.animatedScale(r3, r10, r8, r13)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            r16 = r4
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            java.lang.Object r4 = r3.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            float r17 = r4.floatValue()
            java.lang.Object r3 = r3.getValue()
            java.lang.Number r3 = (java.lang.Number) r3
            float r18 = r3.floatValue()
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r19 = r2.floatValue()
            r37 = 131064(0x1fff8, float:1.8366E-40)
            r38 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r34, r36, r37, r38)
            r3 = 870027225(0x33db8fd9, float:1.0224148E-7)
            r8.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r15)
            androidx.compose.material3.SnackbarData r3 = r0.$key
            boolean r3 = r8.changed((java.lang.Object) r3)
            androidx.compose.material3.SnackbarData r4 = r0.$key
            java.lang.Object r5 = r41.rememberedValue()
            if (r3 != 0) goto L_0x0127
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x0132
        L_0x0127:
            androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1 r3 = new androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
            r3.<init>(r4)
            r5 = r3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r8.updateRememberedValue(r5)
        L_0x0132:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r41.endReplaceableGroup()
            r3 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r13, r5, r12, r3)
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r8.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r13, r8, r13)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r13)
            androidx.compose.runtime.CompositionLocalMap r5 = r41.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r2)
            androidx.compose.runtime.Applier r7 = r41.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0179
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0179:
            r41.startReusableNode()
            boolean r7 = r41.getInserting()
            if (r7 == 0) goto L_0x0186
            r8.createNode(r6)
            goto L_0x0189
        L_0x0186:
            r41.useNode()
        L_0x0189:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3282constructorimpl(r41)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r3, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x01b9
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x01c7
        L_0x01b9:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6.updateRememberedValue(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.apply(r4, r3)
        L_0x01c7:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r41)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r3)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r2.invoke(r3, r8, r4)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r2)
            r2 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r3 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r2 = 1581584569(0x5e4510b9, float:3.55001326E18)
            java.lang.String r3 = "C400@15020L10:SnackbarHost.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r3)
            r2 = r9 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.invoke(r8, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r41)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r41)
            r41.endReplaceableGroup()
            r41.endNode()
            r41.endReplaceableGroup()
            r41.endReplaceableGroup()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0214
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0214:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1.invoke(kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}
