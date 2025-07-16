package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0007J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "()V", "firstFreeHandle", "", "handles", "", "index", "<set-?>", "size", "getSize", "()I", "values", "add", "value", "allocateHandle", "ensure", "", "atLeast", "freeHandle", "handle", "lowestOrDefault", "default", "remove", "shiftDown", "shiftUp", "swap", "a", "b", "validate", "validateHandle", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotDoubleIndexHeap.kt */
public final class SnapshotDoubleIndexHeap {
    public static final int $stable = 8;
    private int firstFreeHandle;
    private int[] handles;
    private int[] index = new int[16];
    private int size;
    private int[] values = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i = 0;
        while (i < 16) {
            int i2 = i + 1;
            iArr[i] = i2;
            i = i2;
        }
        this.handles = iArr;
    }

    public final int getSize() {
        return this.size;
    }

    public static /* synthetic */ int lowestOrDefault$default(SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(i);
    }

    public final int lowestOrDefault(int i) {
        return this.size > 0 ? this.values[0] : i;
    }

    public final int add(int i) {
        ensure(this.size + 1);
        int i2 = this.size;
        this.size = i2 + 1;
        int allocateHandle = allocateHandle();
        this.values[i2] = i;
        this.index[i2] = allocateHandle;
        this.handles[allocateHandle] = i2;
        shiftUp(i2);
        return allocateHandle;
    }

    public final void remove(int i) {
        int i2 = this.handles[i];
        swap(i2, this.size - 1);
        this.size--;
        shiftUp(i2);
        shiftDown(i2);
        freeHandle(i);
    }

    public final void validate() {
        int i = this.size;
        int i2 = 1;
        while (i2 < i) {
            int i3 = i2 + 1;
            int[] iArr = this.values;
            if (iArr[(i3 >> 1) - 1] <= iArr[i2]) {
                i2 = i3;
            } else {
                throw new IllegalStateException(("Index " + i2 + " is out of place").toString());
            }
        }
    }

    public final void validateHandle(int i, int i2) {
        int i3 = this.handles[i];
        if (this.index[i3] != i) {
            throw new IllegalStateException(("Index for handle " + i + " is corrupted").toString());
        } else if (this.values[i3] != i2) {
            throw new IllegalStateException(("Value for handle " + i + " was " + this.values[i3] + " but was supposed to be " + i2).toString());
        }
    }

    private final void shiftUp(int i) {
        int[] iArr = this.values;
        int i2 = iArr[i];
        while (i > 0) {
            int i3 = ((i + 1) >> 1) - 1;
            if (iArr[i3] > i2) {
                swap(i3, i);
                i = i3;
            } else {
                return;
            }
        }
    }

    private final void shiftDown(int i) {
        int i2;
        int[] iArr = this.values;
        int i3 = this.size >> 1;
        while (i < i3) {
            int i4 = (i + 1) << 1;
            int i5 = i4 - 1;
            if (i4 >= this.size || (i2 = iArr[i4]) >= iArr[i5]) {
                if (iArr[i5] < iArr[i]) {
                    swap(i5, i);
                    i = i5;
                } else {
                    return;
                }
            } else if (i2 < iArr[i]) {
                swap(i4, i);
                i = i4;
            } else {
                return;
            }
        }
    }

    private final void swap(int i, int i2) {
        int[] iArr = this.values;
        int[] iArr2 = this.index;
        int[] iArr3 = this.handles;
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
        int i4 = iArr2[i];
        iArr2[i] = iArr2[i2];
        iArr2[i2] = i4;
        iArr3[iArr2[i]] = i;
        iArr3[iArr2[i2]] = i2;
    }

    private final void ensure(int i) {
        int[] iArr = this.values;
        int length = iArr.length;
        if (i > length) {
            int i2 = length * 2;
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            ArraysKt.copyInto$default(iArr, iArr2, 0, 0, 0, 14, (Object) null);
            ArraysKt.copyInto$default(this.index, iArr3, 0, 0, 0, 14, (Object) null);
            this.values = iArr2;
            this.index = iArr3;
        }
    }

    private final int allocateHandle() {
        int length = this.handles.length;
        if (this.firstFreeHandle >= length) {
            int i = length * 2;
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                iArr[i2] = i3;
                i2 = i3;
            }
            ArraysKt.copyInto$default(this.handles, iArr, 0, 0, 0, 14, (Object) null);
            this.handles = iArr;
        }
        int i4 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[i4];
        return i4;
    }

    private final void freeHandle(int i) {
        this.handles[i] = this.firstFreeHandle;
        this.firstFreeHandle = i;
    }
}
