package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\f\u001a \u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\r\u001a>\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00070\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\b¢\u0006\u0002\u0010\u0011\u001a7\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001a;\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00070\u000fH\u0001¢\u0006\u0002\u0010\u0015\u001a3\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u001a2\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a3\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u001a2\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0016\u0010\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"LargeDimension", "", "Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "modifierMaterializerOf", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "materializerOfWithCompositionLocalInjection", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
public final class LayoutKt {
    public static final int LargeDimension = 32767;

    public static final void Layout(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = modifierMaterializerOf(modifier);
        int i3 = ((i << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer r2 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r2, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i3 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
        if ((i2 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        composer.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation(composer, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new LayoutKt$Layout$$inlined$ReusableComposeNode$1(constructor));
        } else {
            composer.useNode();
        }
        Composer r0 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r0, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r0, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.m3289setimpl(r0, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r0.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void Layout(List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Modifier modifier, MultiContentMeasurePolicy multiContentMeasurePolicy, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1399185516);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)172@6924L62,169@6810L182:Layout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = combineAsVirtualLayouts(list);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) multiContentMeasurePolicy);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = modifierMaterializerOf(modifier);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer r1 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r1, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r1.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        combineAsVirtualLayouts.invoke(composer, 0);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final Function2<Composer, Integer, Unit> combineAsVirtualLayouts(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        return ComposableLambdaKt.composableLambdaInstance(-1953651383, true, new LayoutKt$combineAsVirtualLayouts$1(list));
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf(Modifier modifier) {
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new LayoutKt$materializerOf$1(modifier));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Needed only for backwards compatibility. Do not use.")
    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(Modifier modifier) {
        return ComposableLambdaKt.composableLambdaInstance(-55743822, true, new LayoutKt$materializerOfWithCompositionLocalInjection$1(modifier));
    }

    @Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    public static final void MultiMeasureLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1949933075);
        ComposerKt.sourceInformation(startRestartGroup, "C(MultiMeasureLayout)P(2)247@9566L23,251@9718L491:Layout.kt#80mrfh");
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
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) measurePolicy) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1949933075, i3, -1, "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:246)");
            }
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
            int i5 = ((i3 << 3) & 896) | 6;
            startRestartGroup.startReplaceableGroup(-692256719);
            ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor$ui_release);
            } else {
                startRestartGroup.useNode();
            }
            Composer r4 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r4, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m3286initimpl(r4, LayoutKt$MultiMeasureLayout$1$1.INSTANCE);
            Updater.m3289setimpl(r4, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            startRestartGroup.endNode();
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
            endRestartGroup.updateScope(new LayoutKt$MultiMeasureLayout$2(modifier2, function2, measurePolicy, i, i2));
        }
    }
}
