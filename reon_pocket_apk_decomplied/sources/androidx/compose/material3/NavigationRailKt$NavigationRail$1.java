package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
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
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRail$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $header;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationRailKt$NavigationRail$1(WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$header = function3;
        this.$content = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C117@5355L619:NavigationRail.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2092683357, i, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:117)");
            }
            Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m672paddingVpY3zN4$default(SizeKt.m749widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), this.$windowInsets), NavigationRailTokens.INSTANCE.m2979getContainerWidthD9Ej5fM(), 0.0f, 2, (Object) null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, (Object) null));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.HorizontalOrVertical r1 = Arrangement.INSTANCE.m537spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$header;
            Function3<ColumnScope, Composer, Integer, Unit> function32 = this.$content;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(r1, centerHorizontally, composer, 54);
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(selectableGroup);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(composer);
            Updater.m3289setimpl(r6, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 716053806, "C131@5955L9:NavigationRail.kt#uh7d8r");
            composer.startReplaceableGroup(716053806);
            ComposerKt.sourceInformation(composer, "128@5851L8,129@5876L52");
            if (function3 != null) {
                function3.invoke(columnScope, composer, 6);
                SpacerKt.Spacer(SizeKt.m728height3ABfNKs(Modifier.Companion, NavigationRailKt.NavigationRailHeaderPadding), composer, 6);
            }
            composer.endReplaceableGroup();
            function32.invoke(columnScope, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
