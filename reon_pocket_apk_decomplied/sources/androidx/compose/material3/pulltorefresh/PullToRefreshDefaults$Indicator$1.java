package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ProgressIndicatorKt;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "refreshing", "", "invoke", "(ZLandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshDefaults$Indicator$1 extends Lambda implements Function3<Boolean, Composer, Integer, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ PullToRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshDefaults$Indicator$1(Modifier modifier, long j, PullToRefreshState pullToRefreshState) {
        super(3);
        this.$modifier = modifier;
        this.$color = j;
        this.$state = pullToRefreshState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C171@7045L604:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i |= composer.changed(z) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1378661396, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous> (PullToRefresh.kt:171)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(this.$modifier, 0.0f, 1, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            long j = this.$color;
            PullToRefreshState pullToRefreshState = this.$state;
            composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer r7 = Updater.m3282constructorimpl(composer);
            Updater.m3289setimpl(r7, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r7, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r7.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1849687653, "C:PullToRefresh.kt#djiw08");
            if (z) {
                composer.startReplaceableGroup(-1849687637);
                ComposerKt.sourceInformation(composer, "176@7223L201");
                ProgressIndicatorKt.m2062CircularProgressIndicatorLxG7B9w(SizeKt.m742size3ABfNKs(Modifier.Companion, PullToRefreshKt.getSpinnerSize()), j, PullToRefreshKt.StrokeWidth, 0, 0, composer, 390, 24);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1849687390);
                ComposerKt.sourceInformation(composer, "183@7537L18,182@7470L147");
                composer.startReplaceableGroup(-1849687301);
                ComposerKt.sourceInformation(composer, "CC(remember):PullToRefresh.kt#9igjgp");
                boolean changed = composer.changed((Object) pullToRefreshState);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new PullToRefreshDefaults$Indicator$1$1$1$1(pullToRefreshState);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                PullToRefreshKt.m2633CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j, composer, 0);
                composer.endReplaceableGroup();
            }
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
