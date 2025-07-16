package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"TestModifierUpdaterLayout", "", "onAttached", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/TestModifierUpdater;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TestModifierUpdater.kt */
public final class TestModifierUpdaterKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
    public static final void TestModifierUpdaterLayout(Function1<? super TestModifierUpdater, Unit> function1, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1673066036);
        ComposerKt.sourceInformation(startRestartGroup, "C(TestModifierUpdaterLayout)50@1816L23,54@1971L330:TestModifierUpdater.kt#80mrfh");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1673066036, i2, -1, "androidx.compose.ui.layout.TestModifierUpdaterLayout (TestModifierUpdater.kt:49)");
            }
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            MeasurePolicy measurePolicy = TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.INSTANCE;
            Function0<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
            startRestartGroup.startReplaceableGroup(1886828752);
            ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(new TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1(constructor$ui_release));
            } else {
                startRestartGroup.useNode();
            }
            Composer r2 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r2, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3286initimpl(r2, new TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(function1));
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
            endRestartGroup.updateScope(new TestModifierUpdaterKt$TestModifierUpdaterLayout$2(function1, i));
        }
    }
}
