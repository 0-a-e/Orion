package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class LayoutNodeSubcompositionsState$subcompose$3$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ LayoutNodeSubcompositionsState.NodeState $nodeState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeSubcompositionsState$subcompose$3$1$1(LayoutNodeSubcompositionsState.NodeState nodeState, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$nodeState = nodeState;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C477@20610L46:SubcomposeLayout.kt#80mrfh");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1750409193, i, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:477)");
            }
            boolean active = this.$nodeState.getActive();
            Function2<Composer, Integer, Unit> function2 = this.$content;
            composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(active));
            boolean changed = composer.changed(active);
            if (active) {
                function2.invoke(composer, 0);
            } else {
                composer.deactivateToEndGroup(changed);
            }
            composer.endReusableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
