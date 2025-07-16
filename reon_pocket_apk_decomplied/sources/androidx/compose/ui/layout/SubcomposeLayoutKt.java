package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0001\u001a6\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001d\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001a>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001d\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0015"}, d2 = {"ReusedSlotId", "androidx/compose/ui/layout/SubcomposeLayoutKt$ReusedSlotId$1", "Landroidx/compose/ui/layout/SubcomposeLayoutKt$ReusedSlotId$1;", "SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class SubcomposeLayoutKt {
    /* access modifiers changed from: private */
    public static final SubcomposeLayoutKt$ReusedSlotId$1 ReusedSlotId = new SubcomposeLayoutKt$ReusedSlotId$1();

    public static final void SubcomposeLayout(Modifier modifier, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1298353104);
        ComposerKt.sourceInformation(startRestartGroup, "C(SubcomposeLayout)P(1)76@3572L36,75@3538L144:SubcomposeLayout.kt#80mrfh");
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
                ComposerKt.traceEventStart(-1298353104, i3, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:74)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SubcomposeLayoutState();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            int i5 = i3 << 3;
            SubcomposeLayout((SubcomposeLayoutState) rememberedValue, modifier, function2, startRestartGroup, (i5 & 112) | 8 | (i5 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$2(modifier, function2, i, i2));
        }
    }

    public static final void SubcomposeLayout(SubcomposeLayoutState subcomposeLayoutState, Modifier modifier, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, Composer composer, int i, int i2) {
        Composer startRestartGroup = composer.startRestartGroup(-511989831);
        ComposerKt.sourceInformation(startRestartGroup, "C(SubcomposeLayout)P(2,1)109@5028L23,110@5081L28,113@5237L487,126@5770L65:SubcomposeLayout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511989831, i, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:108)");
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
        startRestartGroup.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new SubcomposeLayoutKt$SubcomposeLayout$$inlined$ReusableComposeNode$1(constructor$ui_release));
        } else {
            startRestartGroup.useNode();
        }
        Composer r5 = Updater.m3282constructorimpl(startRestartGroup);
        Updater.m3289setimpl(r5, subcomposeLayoutState, subcomposeLayoutState.getSetRoot$ui_release());
        Updater.m3289setimpl(r5, rememberCompositionContext, subcomposeLayoutState.getSetCompositionContext$ui_release());
        Updater.m3289setimpl(r5, function2, subcomposeLayoutState.getSetMeasurePolicy$ui_release());
        Updater.m3289setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.m3289setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (!startRestartGroup.getSkipping()) {
            EffectsKt.SideEffect(new SubcomposeLayoutKt$SubcomposeLayout$4(subcomposeLayoutState), startRestartGroup, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$5(subcomposeLayoutState, modifier2, function2, i, i2));
        }
    }

    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int i) {
        return new FixedCountSubcomposeSlotReusePolicy(i);
    }
}
