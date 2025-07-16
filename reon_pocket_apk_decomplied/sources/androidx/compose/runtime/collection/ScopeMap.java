package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J4\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\r0\u0017H\bJ\u001b\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ.\u0010\u001e\u001a\u00020\r2#\b\u0004\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00130\u0017H\bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "T", "", "()V", "map", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize", "()I", "add", "", "key", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)V", "clear", "contains", "", "element", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "(Ljava/lang/Object;)V", "removeScopeIf", "predicate", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScopeMap.kt */
public final class ScopeMap<T> {
    public static final int $stable = 8;
    private final MutableScatterMap<Object, Object> map = ScatterMapKt.mutableScatterMapOf();

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public final int getSize() {
        return this.map.getSize();
    }

    public final void add(Object obj, T t) {
        T t2;
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        int findInsertIndex = mutableScatterMap.findInsertIndex(obj);
        boolean z = findInsertIndex < 0;
        if (z) {
            t2 = null;
        } else {
            t2 = mutableScatterMap.values[findInsertIndex];
        }
        if (t2 != null) {
            if (t2 instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                ((MutableScatterSet) t2).add(t);
            } else if (t2 != t) {
                T mutableScatterSet = new MutableScatterSet(0, 1, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet.add(t2);
                mutableScatterSet.add(t);
                t = mutableScatterSet;
            }
            t = t2;
        }
        if (z) {
            int i = ~findInsertIndex;
            mutableScatterMap.keys[i] = obj;
            mutableScatterMap.values[i] = t;
            return;
        }
        mutableScatterMap.values[findInsertIndex] = t;
    }

    public final boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    public final void forEachScopeOf(Object obj, Function1<? super T, Unit> function1) {
        Object obj2 = getMap().get(obj);
        if (obj2 == null) {
            return;
        }
        if (obj2 instanceof MutableScatterSet) {
            ScatterSet scatterSet = (MutableScatterSet) obj2;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function1.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            return;
                        }
                    }
                    if (i != length) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            function1.invoke(obj2);
        }
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean remove(Object obj, T t) {
        Object obj2 = this.map.get(obj);
        if (obj2 == null) {
            return false;
        }
        if (obj2 instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
            boolean remove = mutableScatterSet.remove(t);
            if (remove && mutableScatterSet.isEmpty()) {
                this.map.remove(obj);
            }
            return remove;
        } else if (!Intrinsics.areEqual(obj2, (Object) t)) {
            return false;
        } else {
            this.map.remove(obj);
            return true;
        }
    }

    public final void removeScopeIf(Function1<? super T, Boolean> function1) {
        long[] jArr;
        int i;
        int i2;
        int i3;
        int i4;
        long[] jArr2;
        long j;
        int i5;
        boolean z;
        int i6;
        Function1<? super T, Boolean> function12 = function1;
        MutableScatterMap<Object, Object> map2 = getMap();
        long[] jArr3 = map2.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i7 = 0;
            while (true) {
                long j2 = jArr3[i7];
                char c = 7;
                long j3 = -9187201950435737472L;
                if ((((~j2) << 7) & j2 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j2 & 255) < 128) {
                            int i11 = (i7 << 3) + i10;
                            Object obj = map2.keys[i11];
                            Object obj2 = map2.values[i11];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                int length2 = jArr4.length - 2;
                                jArr2 = jArr3;
                                i4 = length;
                                if (length2 >= 0) {
                                    int i12 = 0;
                                    while (true) {
                                        long j4 = jArr4[i12];
                                        i3 = i9;
                                        long[] jArr5 = jArr4;
                                        j = -9187201950435737472L;
                                        if ((((~j4) << c) & j4 & -9187201950435737472L) != -9187201950435737472L) {
                                            int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                            int i14 = 0;
                                            while (i14 < i13) {
                                                if ((j4 & 255) < 128) {
                                                    int i15 = (i12 << 3) + i14;
                                                    i6 = i7;
                                                    if (function12.invoke(objArr[i15]).booleanValue()) {
                                                        mutableScatterSet.removeElementAt(i15);
                                                    }
                                                } else {
                                                    i6 = i7;
                                                }
                                                j4 >>= 8;
                                                i14++;
                                                i7 = i6;
                                            }
                                            i2 = i7;
                                            if (i13 != 8) {
                                                break;
                                            }
                                        } else {
                                            i2 = i7;
                                        }
                                        if (i12 == length2) {
                                            break;
                                        }
                                        i12++;
                                        i9 = i3;
                                        jArr4 = jArr5;
                                        i7 = i2;
                                        c = 7;
                                    }
                                } else {
                                    i2 = i7;
                                    i3 = i9;
                                    j = -9187201950435737472L;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr3;
                                i4 = length;
                                i2 = i7;
                                i3 = i9;
                                j = j3;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                                z = function12.invoke(obj2).booleanValue();
                            }
                            if (z) {
                                map2.removeValueAt(i11);
                            }
                            i5 = 8;
                        } else {
                            jArr2 = jArr3;
                            i4 = length;
                            i2 = i7;
                            i3 = i9;
                            j = j3;
                            i5 = i8;
                        }
                        j2 >>= i5;
                        i10++;
                        i8 = i5;
                        j3 = j;
                        jArr3 = jArr2;
                        length = i4;
                        i9 = i3;
                        i7 = i2;
                        c = 7;
                    }
                    jArr = jArr3;
                    int i16 = length;
                    int i17 = i7;
                    if (i9 == i8) {
                        length = i16;
                        i = i17;
                    } else {
                        return;
                    }
                } else {
                    jArr = jArr3;
                    i = i7;
                }
                if (i != length) {
                    i7 = i + 1;
                    jArr3 = jArr;
                } else {
                    return;
                }
            }
        }
    }

    public final void removeScope(T t) {
        long[] jArr;
        int i;
        int i2;
        int i3;
        int i4;
        long[] jArr2;
        long j;
        int i5;
        int i6;
        T t2 = t;
        MutableScatterMap<Object, Object> map2 = getMap();
        long[] jArr3 = map2.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i7 = 0;
            while (true) {
                long j2 = jArr3[i7];
                char c = 7;
                long j3 = -9187201950435737472L;
                if ((((~j2) << 7) & j2 & -9187201950435737472L) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j2 & 255) < 128) {
                            int i11 = (i7 << 3) + i10;
                            Object obj = map2.keys[i11];
                            T t3 = map2.values[i11];
                            boolean z = true;
                            if (t3 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) t3;
                                T[] tArr = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                int length2 = jArr4.length - 2;
                                jArr2 = jArr3;
                                i4 = length;
                                if (length2 >= 0) {
                                    int i12 = 0;
                                    while (true) {
                                        long j4 = jArr4[i12];
                                        i3 = i9;
                                        long[] jArr5 = jArr4;
                                        j = -9187201950435737472L;
                                        if ((((~j4) << c) & j4 & -9187201950435737472L) != -9187201950435737472L) {
                                            int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                            int i14 = 0;
                                            while (i14 < i13) {
                                                if ((j4 & 255) < 128) {
                                                    int i15 = (i12 << 3) + i14;
                                                    i6 = i7;
                                                    if (tArr[i15] == t2) {
                                                        mutableScatterSet.removeElementAt(i15);
                                                    }
                                                } else {
                                                    i6 = i7;
                                                }
                                                j4 >>= 8;
                                                i14++;
                                                i7 = i6;
                                            }
                                            i2 = i7;
                                            if (i13 != 8) {
                                                break;
                                            }
                                        } else {
                                            i2 = i7;
                                        }
                                        if (i12 == length2) {
                                            break;
                                        }
                                        i12++;
                                        i9 = i3;
                                        jArr4 = jArr5;
                                        i7 = i2;
                                        c = 7;
                                    }
                                } else {
                                    i2 = i7;
                                    i3 = i9;
                                    j = -9187201950435737472L;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr3;
                                i4 = length;
                                i2 = i7;
                                i3 = i9;
                                j = j3;
                                Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                                if (t3 != t2) {
                                    z = false;
                                }
                            }
                            if (z) {
                                map2.removeValueAt(i11);
                            }
                            i5 = 8;
                        } else {
                            jArr2 = jArr3;
                            i4 = length;
                            i2 = i7;
                            i3 = i9;
                            j = j3;
                            i5 = i8;
                        }
                        j2 >>= i5;
                        i10++;
                        i8 = i5;
                        j3 = j;
                        jArr3 = jArr2;
                        length = i4;
                        i9 = i3;
                        i7 = i2;
                        c = 7;
                    }
                    jArr = jArr3;
                    int i16 = length;
                    int i17 = i7;
                    if (i9 == i8) {
                        length = i16;
                        i = i17;
                    } else {
                        return;
                    }
                } else {
                    jArr = jArr3;
                    i = i7;
                }
                if (i != length) {
                    i7 = i + 1;
                    jArr3 = jArr;
                } else {
                    return;
                }
            }
        }
    }
}
