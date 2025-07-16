package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
final class LayoutKt$combineAsVirtualLayouts$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<Function2<Composer, Integer, Unit>> $contents;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutKt$combineAsVirtualLayouts$1(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        super(2);
        this.$contents = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*181@7218L23,182@7250L298:Layout.kt#80mrfh");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1953651383, i, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:180)");
            }
            List<Function2<Composer, Integer, Unit>> list = this.$contents;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Function2 function2 = list.get(i2);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                Function0<ComposeUiNode> virtualConstructor = ComposeUiNode.Companion.getVirtualConstructor();
                composer.startReplaceableGroup(-692256719);
                ComposerKt.sourceInformation(composer, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(virtualConstructor);
                } else {
                    composer.useNode();
                }
                Composer r5 = Updater.m3282constructorimpl(composer);
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                    r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                function2.invoke(composer, 0);
                composer.endNode();
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
