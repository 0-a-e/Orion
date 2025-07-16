package androidx.compose.runtime.snapshots;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"sync", "", "invalidIteratorSet", "", "modificationError", "validateRange", "", "index", "", "size", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateList.kt */
public final class SnapshotStateListKt {
    /* access modifiers changed from: private */
    public static final Object sync = new Object();

    /* access modifiers changed from: private */
    public static final Void modificationError() {
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }

    /* access modifiers changed from: private */
    public static final void validateRange(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index (" + i + ") is out of bound of [0, " + i2 + ')');
        }
    }

    /* access modifiers changed from: private */
    public static final Void invalidIteratorSet() {
        throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()".toString());
    }
}
