package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0016J\"\u0010\n\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001d\u0010\u000f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0002J\"\u0010\u0010\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u001b\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0016J\"\u0010\u0015\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016J\"\u0010\u0016\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$entries$1", "", "", "size", "", "getSize", "()I", "add", "", "element", "addAll", "elements", "", "clear", "", "contains", "containsAll", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScatterMap.kt */
public final class MutableScatterMap$MutableMapWrapper$entries$1 implements Set<Map.Entry<K, V>>, KMutableSet {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!TypeIntrinsics.isMutableMapEntry(obj)) {
            return false;
        }
        return contains((Map.Entry) obj);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!TypeIntrinsics.isMutableMapEntry(obj)) {
            return false;
        }
        return remove((Map.Entry) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.this$0._size;
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(this.this$0);
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterable<Map.Entry> iterable = collection;
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Map.Entry entry : iterable) {
            if (!Intrinsics.areEqual((Object) mutableScatterMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Map.Entry<K, V> entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        return Intrinsics.areEqual((Object) this.this$0.get(entry.getKey()), (Object) entry.getValue());
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public boolean add(Map.Entry<K, V> entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        boolean z;
        int i;
        Intrinsics.checkNotNullParameter(collection, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            Iterator<? extends Object> it = collection.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    mutableScatterMap.removeValueAt(i6);
                                    z2 = true;
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                if (Intrinsics.areEqual(entry.getKey(), mutableScatterMap.keys[i6]) && Intrinsics.areEqual(entry.getValue(), mutableScatterMap.values[i6])) {
                                    break;
                                }
                            }
                            i = 8;
                        } else {
                            i = i3;
                        }
                        j >>= i;
                        i5++;
                        i3 = i;
                    }
                    if (i4 != i3) {
                        return z2;
                    }
                }
                if (i2 == length) {
                    z = z2;
                    break;
                }
                i2++;
            }
        } else {
            z = false;
        }
        return z;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        boolean z;
        int i;
        Intrinsics.checkNotNullParameter(collection, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            Iterator<? extends Object> it = collection.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                if (Intrinsics.areEqual(entry.getKey(), mutableScatterMap.keys[i6]) && Intrinsics.areEqual(entry.getValue(), mutableScatterMap.values[i6])) {
                                    mutableScatterMap.removeValueAt(i6);
                                    z2 = true;
                                    break;
                                }
                            }
                            i = 8;
                        } else {
                            i = i3;
                        }
                        j >>= i;
                        i5++;
                        i3 = i;
                    }
                    if (i4 != i3) {
                        return z2;
                    }
                }
                if (i2 == length) {
                    z = z2;
                    break;
                }
                i2++;
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007b, code lost:
        if (((r9 & ((~r9) << 6)) & -9187201950435737472L) == 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007d, code lost:
        r15 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(java.util.Map.Entry<K, V> r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "element"
            r2 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            androidx.collection.ScatterMap r1 = (androidx.collection.ScatterMap) r1
            java.lang.Object r3 = r20.getKey()
            if (r3 == 0) goto L_0x0018
            int r5 = r3.hashCode()
            goto L_0x0019
        L_0x0018:
            r5 = 0
        L_0x0019:
            r6 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r5 = r5 * r6
            int r6 = r5 << 16
            r5 = r5 ^ r6
            r6 = r5 & 127(0x7f, float:1.78E-43)
            int r7 = r1._capacity
            int r5 = r5 >>> 7
            r5 = r5 & r7
            r8 = 0
        L_0x0028:
            long[] r9 = r1.metadata
            int r10 = r5 >> 3
            r11 = r5 & 7
            int r11 = r11 << 3
            r12 = r9[r10]
            long r12 = r12 >>> r11
            r14 = 1
            int r10 = r10 + r14
            r15 = r9[r10]
            int r9 = 64 - r11
            long r9 = r15 << r9
            long r14 = (long) r11
            long r14 = -r14
            r11 = 63
            long r14 = r14 >> r11
            long r9 = r9 & r14
            long r9 = r9 | r12
            long r11 = (long) r6
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r11 = r11 * r13
            long r11 = r11 ^ r9
            long r13 = r11 - r13
            long r11 = ~r11
            long r11 = r11 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
        L_0x0054:
            r17 = 0
            int r15 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r15 == 0) goto L_0x0074
            int r15 = java.lang.Long.numberOfTrailingZeros(r11)
            int r15 = r15 >> 3
            int r15 = r15 + r5
            r15 = r15 & r7
            java.lang.Object[] r4 = r1.keys
            r4 = r4[r15]
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r4 == 0) goto L_0x006d
            goto L_0x007e
        L_0x006d:
            r17 = 1
            long r17 = r11 - r17
            long r11 = r11 & r17
            goto L_0x0054
        L_0x0074:
            long r11 = ~r9
            r4 = 6
            long r11 = r11 << r4
            long r9 = r9 & r11
            long r9 = r9 & r13
            int r4 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0099
            r15 = -1
        L_0x007e:
            if (r15 < 0) goto L_0x0097
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            java.lang.Object[] r1 = r1.values
            r1 = r1[r15]
            java.lang.Object r2 = r20.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0097
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            r1.removeValueAt(r15)
            r1 = 1
            return r1
        L_0x0097:
            r4 = 0
            return r4
        L_0x0099:
            r4 = 0
            int r8 = r8 + 8
            int r5 = r5 + r8
            r5 = r5 & r7
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1.remove(java.util.Map$Entry):boolean");
    }
}
