package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackwardsCompatNode.kt */
final class BackwardsCompatNode$updateModifierLocalConsumer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BackwardsCompatNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackwardsCompatNode$updateModifierLocalConsumer$1(BackwardsCompatNode backwardsCompatNode) {
        super(0);
        this.this$0 = backwardsCompatNode;
    }

    public final void invoke() {
        Modifier.Element element = this.this$0.getElement();
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
        ((ModifierLocalConsumer) element).onModifierLocalsUpdated(this.this$0);
    }
}
