package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$TabRowImpl$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<TabIndicatorScope, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$TabRowImpl$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C371@17511L1344,416@19062L2364,409@18865L2561:TabRow.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-65106680, i, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:371)");
            }
            composer.startReplaceableGroup(474062752);
            ComposerKt.sourceInformation(composer, "CC(remember):TabRow.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TabRowKt$TabRowImpl$1$scope$1$1();
                composer.updateRememberedValue(rememberedValue);
            }
            final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) rememberedValue;
            composer.endReplaceableGroup();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            final Function3<TabIndicatorScope, Composer, Integer, Unit> function3 = this.$indicator;
            List listOf = CollectionsKt.listOf(this.$tabs, this.$divider, ComposableLambdaKt.composableLambda(composer, 1236693605, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C414@19023L11:TabRow.kt#uh7d8r");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1236693605, i, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:414)");
                        }
                        function3.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }));
            composer.startReplaceableGroup(474064303);
            ComposerKt.sourceInformation(composer, "CC(remember):TabRow.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new TabRowKt$TabRowImpl$1$2$1(tabRowKt$TabRowImpl$1$scope$1$1);
                composer.updateRememberedValue(rememberedValue2);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue2;
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(1399185516);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = composer.changed((Object) multiContentMeasurePolicy);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
            combineAsVirtualLayouts.invoke(composer, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
