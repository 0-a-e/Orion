package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Button.kt */
final class ButtonKt$Button$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ PaddingValues $contentPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ButtonKt$Button$3(long j, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$contentColor = j;
        this.$contentPadding = paddingValues;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(956488494, i, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
            }
            long j = this.$contentColor;
            TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer, 6).getLabelLarge();
            final PaddingValues paddingValues = this.$contentPadding;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer, 1327513942, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C134@6628L427:Button.kt#uh7d8r");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1327513942, i, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                        }
                        Modifier padding = PaddingKt.padding(SizeKt.m726defaultMinSizeVpY3zN4(Modifier.Companion, ButtonDefaults.INSTANCE.m1561getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1560getMinHeightD9Ej5fM()), paddingValues);
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        composer.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer, 54);
                        composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        Composer r5 = Updater.m3282constructorimpl(composer);
                        Updater.m3289setimpl(r5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3289setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                            r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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
            }), composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
