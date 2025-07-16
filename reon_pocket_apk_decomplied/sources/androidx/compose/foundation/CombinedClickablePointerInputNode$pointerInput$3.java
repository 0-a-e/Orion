package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class CombinedClickablePointerInputNode$pointerInput$3 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ CombinedClickablePointerInputNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombinedClickablePointerInputNode$pointerInput$3(CombinedClickablePointerInputNode combinedClickablePointerInputNode) {
        super(1);
        this.this$0 = combinedClickablePointerInputNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m269invokek4lQ0M(((Offset) obj).m3572unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m269invokek4lQ0M(long j) {
        Function0 access$getOnLongClick$p = this.this$0.onLongClick;
        if (access$getOnLongClick$p != null) {
            access$getOnLongClick$p.invoke();
        }
    }
}
