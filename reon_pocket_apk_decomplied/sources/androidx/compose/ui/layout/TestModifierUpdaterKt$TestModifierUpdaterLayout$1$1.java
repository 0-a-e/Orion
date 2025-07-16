package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TestModifierUpdater.kt */
final class TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1 extends Lambda implements Function1<LayoutNode, Unit> {
    final /* synthetic */ Function1<TestModifierUpdater, Unit> $onAttached;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(Function1<? super TestModifierUpdater, Unit> function1) {
        super(1);
        this.$onAttached = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode layoutNode) {
        this.$onAttached.invoke(new TestModifierUpdater(layoutNode));
    }
}
