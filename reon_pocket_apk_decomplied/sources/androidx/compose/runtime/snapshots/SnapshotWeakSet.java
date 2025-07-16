package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\"J\r\u0010#\u001a\u00020\u0019H\u0001¢\u0006\u0002\b$J\u001d\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190(H\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00120\u0011X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "T", "", "()V", "hashes", "", "getHashes$runtime_release", "()[I", "setHashes$runtime_release", "([I)V", "size", "", "getSize$runtime_release", "()I", "setSize$runtime_release", "(I)V", "values", "", "Landroidx/compose/runtime/WeakReference;", "getValues$runtime_release", "()[Landroidx/compose/runtime/WeakReference;", "setValues$runtime_release", "([Landroidx/compose/runtime/WeakReference;)V", "[Landroidx/compose/runtime/WeakReference;", "add", "", "value", "(Ljava/lang/Object;)Z", "find", "hash", "(Ljava/lang/Object;I)I", "findExactIndex", "midIndex", "valueHash", "(ILjava/lang/Object;I)I", "isValid", "isValid$runtime_release", "removeIf", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotWeakSet.kt */
public final class SnapshotWeakSet<T> {
    public static final int $stable = 8;
    private int[] hashes = new int[16];
    private int size;
    private WeakReference<T>[] values = new WeakReference[16];

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    public final int[] getHashes$runtime_release() {
        return this.hashes;
    }

    public final void setHashes$runtime_release(int[] iArr) {
        this.hashes = iArr;
    }

    public final WeakReference<T>[] getValues$runtime_release() {
        return this.values;
    }

    public final void setValues$runtime_release(WeakReference<T>[] weakReferenceArr) {
        this.values = weakReferenceArr;
    }

    public final boolean add(T t) {
        int i;
        int i2 = this.size;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(t);
        if (i2 > 0) {
            i = find(t, identityHashCode);
            if (i >= 0) {
                return false;
            }
        } else {
            i = -1;
        }
        int i3 = -(i + 1);
        WeakReference<T>[] weakReferenceArr = this.values;
        int length = weakReferenceArr.length;
        if (i2 == length) {
            int i4 = length * 2;
            WeakReference<T>[] weakReferenceArr2 = new WeakReference[i4];
            int[] iArr = new int[i4];
            int i5 = i3 + 1;
            ArraysKt.copyInto((T[]) weakReferenceArr, (T[]) weakReferenceArr2, i5, i3, i2);
            int i6 = i3;
            ArraysKt.copyInto$default((Object[]) this.values, (Object[]) weakReferenceArr2, 0, 0, i6, 6, (Object) null);
            ArraysKt.copyInto(this.hashes, iArr, i5, i3, i2);
            ArraysKt.copyInto$default(this.hashes, iArr, 0, 0, i6, 6, (Object) null);
            this.values = weakReferenceArr2;
            this.hashes = iArr;
        } else {
            int i7 = i3 + 1;
            ArraysKt.copyInto((T[]) weakReferenceArr, (T[]) weakReferenceArr, i7, i3, i2);
            int[] iArr2 = this.hashes;
            ArraysKt.copyInto(iArr2, iArr2, i7, i3, i2);
        }
        this.values[i3] = new WeakReference<>(t);
        this.hashes[i3] = identityHashCode;
        this.size++;
        return true;
    }

    public final void removeIf(Function1<? super T, Boolean> function1) {
        int size$runtime_release = getSize$runtime_release();
        int i = 0;
        int i2 = 0;
        while (true) {
            Object obj = null;
            if (i >= size$runtime_release) {
                break;
            }
            WeakReference weakReference = getValues$runtime_release()[i];
            if (weakReference != null) {
                obj = weakReference.get();
            }
            if (obj != null && !function1.invoke(obj).booleanValue()) {
                if (i2 != i) {
                    getValues$runtime_release()[i2] = weakReference;
                    getHashes$runtime_release()[i2] = getHashes$runtime_release()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i3 = i2; i3 < size$runtime_release; i3++) {
            getValues$runtime_release()[i3] = null;
            getHashes$runtime_release()[i3] = 0;
        }
        if (i2 != size$runtime_release) {
            setSize$runtime_release(i2);
        }
    }

    private final int find(T t, int i) {
        int i2 = this.size - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.hashes[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 > i) {
                i2 = i4 - 1;
            } else {
                WeakReference<T> weakReference = this.values[i4];
                if (t == (weakReference != null ? weakReference.get() : null)) {
                    return i4;
                }
                return findExactIndex(i4, t, i);
            }
        }
        return -(i3 + 1);
    }

    private final int findExactIndex(int i, T t, int i2) {
        int i3 = i - 1;
        while (true) {
            T t2 = null;
            if (-1 >= i3 || this.hashes[i3] != i2) {
                int i4 = i + 1;
                int i5 = this.size;
            } else {
                WeakReference<T> weakReference = this.values[i3];
                if (weakReference != null) {
                    t2 = weakReference.get();
                }
                if (t2 == t) {
                    return i3;
                }
                i3--;
            }
        }
        int i42 = i + 1;
        int i52 = this.size;
        while (true) {
            if (i42 >= i52) {
                i42 = this.size;
                break;
            } else if (this.hashes[i42] != i2) {
                break;
            } else {
                WeakReference<T> weakReference2 = this.values[i42];
                if ((weakReference2 != null ? weakReference2.get() : null) == t) {
                    return i42;
                }
                i42++;
            }
        }
        return -(i42 + 1);
    }

    public final boolean isValid$runtime_release() {
        WeakReference<T> weakReference;
        int i = this.size;
        WeakReference<T>[] weakReferenceArr = this.values;
        int[] iArr = this.hashes;
        int length = weakReferenceArr.length;
        if (i > length) {
            return false;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            if (i4 < i2 || (weakReference = weakReferenceArr[i3]) == null) {
                return false;
            }
            Object obj = weakReference.get();
            if (obj != null && i4 != ActualJvm_jvmKt.identityHashCode(obj)) {
                return false;
            }
            i3++;
            i2 = i4;
        }
        while (i < length) {
            if (iArr[i] != 0 || weakReferenceArr[i] != null) {
                return false;
            }
            i++;
        }
        return true;
    }
}
