package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CancellableContinuation;", "", "frameTime", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class Recomposer$runFrameLoop$2 extends Lambda implements Function1<Long, CancellableContinuation<? super Unit>> {
    final /* synthetic */ ProduceFrameSignal $frameSignal;
    final /* synthetic */ List<ControlledComposition> $toApply;
    final /* synthetic */ List<ControlledComposition> $toRecompose;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runFrameLoop$2(Recomposer recomposer, List<ControlledComposition> list, List<ControlledComposition> list2, ProduceFrameSignal produceFrameSignal) {
        super(1);
        this.this$0 = recomposer;
        this.$toRecompose = list;
        this.$toApply = list2;
        this.$frameSignal = produceFrameSignal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    public final CancellableContinuation<Unit> invoke(long j) {
        int i;
        CancellableContinuation<Unit> access$deriveStateLocked;
        if (this.this$0.getHasBroadcastFrameClockAwaiters()) {
            Recomposer recomposer = this.this$0;
            Object beginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
            try {
                recomposer.broadcastFrameClock.sendFrame(j);
                Snapshot.Companion.sendApplyNotifications();
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.INSTANCE.endSection(beginSection);
            }
        }
        Recomposer recomposer2 = this.this$0;
        List<ControlledComposition> list = this.$toRecompose;
        List<ControlledComposition> list2 = this.$toApply;
        ProduceFrameSignal produceFrameSignal = this.$frameSignal;
        Object beginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
        boolean unused = recomposer2.recordComposerModifications();
        synchronized (recomposer2.stateLock) {
            List access$getCompositionsAwaitingApply$p = recomposer2.compositionsAwaitingApply;
            int size = access$getCompositionsAwaitingApply$p.size();
            for (int i2 = 0; i2 < size; i2++) {
                list2.add((ControlledComposition) access$getCompositionsAwaitingApply$p.get(i2));
            }
            recomposer2.compositionsAwaitingApply.clear();
            List access$getCompositionInvalidations$p = recomposer2.compositionInvalidations;
            int size2 = access$getCompositionInvalidations$p.size();
            for (int i3 = 0; i3 < size2; i3++) {
                list.add((ControlledComposition) access$getCompositionInvalidations$p.get(i3));
            }
            recomposer2.compositionInvalidations.clear();
            produceFrameSignal.takeFrameRequestLocked();
            Unit unit2 = Unit.INSTANCE;
        }
        IdentityArraySet identityArraySet = new IdentityArraySet();
        try {
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ControlledComposition access$performRecompose = recomposer2.performRecompose(list.get(i4), identityArraySet);
                if (access$performRecompose != null) {
                    list2.add(access$performRecompose);
                }
            }
            list.clear();
            if (!list2.isEmpty()) {
                recomposer2.changeCount = recomposer2.getChangeCount() + 1;
            }
            int size4 = list2.size();
            for (i = 0; i < size4; i++) {
                list2.get(i).applyChanges();
            }
            list2.clear();
            synchronized (recomposer2.stateLock) {
                access$deriveStateLocked = recomposer2.deriveStateLocked();
            }
            Trace.INSTANCE.endSection(beginSection2);
            return access$deriveStateLocked;
        } catch (Throwable th) {
            Trace.INSTANCE.endSection(beginSection2);
            throw th;
        }
    }
}
