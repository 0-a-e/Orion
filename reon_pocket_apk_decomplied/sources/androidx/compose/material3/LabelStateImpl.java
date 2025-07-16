package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH@¢\u0006\u0002\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/LabelStateImpl;", "Landroidx/compose/material3/BasicTooltipState;", "isVisible", "", "isPersistent", "(ZZ)V", "()Z", "dismiss", "", "onDispose", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Label.kt */
final class LabelStateImpl implements BasicTooltipState {
    private final boolean isPersistent;
    private final boolean isVisible;

    public LabelStateImpl() {
        this(false, false, 3, (DefaultConstructorMarker) null);
    }

    public void dismiss() {
    }

    public void onDispose() {
    }

    public LabelStateImpl(boolean z, boolean z2) {
        this.isVisible = z;
        this.isPersistent = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LabelStateImpl(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public Object show(MutatePriority mutatePriority, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
