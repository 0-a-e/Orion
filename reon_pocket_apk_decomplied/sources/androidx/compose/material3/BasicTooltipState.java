package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/BasicTooltipState;", "", "isPersistent", "", "()Z", "isVisible", "dismiss", "", "onDispose", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTooltip.kt */
public interface BasicTooltipState {
    void dismiss();

    boolean isPersistent();

    boolean isVisible();

    void onDispose();

    Object show(MutatePriority mutatePriority, Continuation<? super Unit> continuation);

    /* renamed from: androidx.compose.material3.BasicTooltipState$-CC  reason: invalid class name */
    /* compiled from: BasicTooltip.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object show$default(BasicTooltipState basicTooltipState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    mutatePriority = MutatePriority.Default;
                }
                return basicTooltipState.show(mutatePriority, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
    }
}
