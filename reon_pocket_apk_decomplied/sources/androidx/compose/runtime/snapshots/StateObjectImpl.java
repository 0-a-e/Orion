package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.snapshots.StateObject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "readerKind", "Landroidx/compose/runtime/AtomicInt;", "isReadIn", "", "reader", "Landroidx/compose/runtime/snapshots/ReaderKind;", "isReadIn-h_f27i8$runtime_release", "(I)Z", "recordReadIn", "", "recordReadIn-h_f27i8$runtime_release", "(I)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StateObjectImpl.kt */
public abstract class StateObjectImpl implements StateObject {
    public static final int $stable = 0;
    private final AtomicInt readerKind = new AtomicInt(0);

    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return StateObject.CC.$default$mergeRecords(this, stateRecord, stateRecord2, stateRecord3);
    }

    /* renamed from: recordReadIn-h_f27i8$runtime_release  reason: not valid java name */
    public final void m3416recordReadInh_f27i8$runtime_release(int i) {
        int r0;
        do {
            r0 = ReaderKind.m3402constructorimpl(this.readerKind.get());
            if ((r0 & i) == 0) {
            } else {
                return;
            }
        } while (!this.readerKind.compareAndSet(r0, ReaderKind.m3402constructorimpl(r0 | i)));
    }

    /* renamed from: isReadIn-h_f27i8$runtime_release  reason: not valid java name */
    public final boolean m3415isReadInh_f27i8$runtime_release(int i) {
        return (i & ReaderKind.m3402constructorimpl(this.readerKind.get())) != 0;
    }
}
