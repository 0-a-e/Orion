package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedScrollNode.kt */
final class NestedScrollNode$updateDispatcherFields$1 extends Lambda implements Function0<CoroutineScope> {
    final /* synthetic */ NestedScrollNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NestedScrollNode$updateDispatcherFields$1(NestedScrollNode nestedScrollNode) {
        super(0);
        this.this$0 = nestedScrollNode;
    }

    public final CoroutineScope invoke() {
        return this.this$0.getNestedCoroutineScope();
    }
}
