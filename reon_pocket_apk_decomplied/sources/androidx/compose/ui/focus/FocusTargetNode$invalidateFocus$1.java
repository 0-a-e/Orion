package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTargetNode.kt */
final class FocusTargetNode$invalidateFocus$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<FocusProperties> $focusProperties;
    final /* synthetic */ FocusTargetNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusTargetNode$invalidateFocus$1(Ref.ObjectRef<FocusProperties> objectRef, FocusTargetNode focusTargetNode) {
        super(0);
        this.$focusProperties = objectRef;
        this.this$0 = focusTargetNode;
    }

    public final void invoke() {
        this.$focusProperties.element = this.this$0.fetchFocusProperties$ui_release();
    }
}
