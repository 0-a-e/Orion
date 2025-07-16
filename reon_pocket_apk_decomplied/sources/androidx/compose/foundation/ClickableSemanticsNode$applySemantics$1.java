package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableSemanticsNode$applySemantics$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ClickableSemanticsNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableSemanticsNode$applySemantics$1(ClickableSemanticsNode clickableSemanticsNode) {
        super(0);
        this.this$0 = clickableSemanticsNode;
    }

    public final Boolean invoke() {
        this.this$0.onClick.invoke();
        return true;
    }
}
