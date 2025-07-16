package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u0005H\u0002JA\u0010\u001e\u001a\u00020\u001526\u0010\u001f\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00150 H\bJ\u0018\u0010$\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u0017J\u0006\u0010'\u001a\u00020\u0017J\u0015\u0010(\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010%JA\u0010)\u001a\u00020\u001526\u0010\u001f\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00170 H\bJ,\u0010*\u001a\u00020\u00152!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00170+H\bJ\u001e\u0010,\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010-R0\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b@BX\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b@BX\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006."}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "<set-?>", "", "keys", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "size", "getSize", "()I", "values", "getValues", "asMap", "", "clear", "", "contains", "", "key", "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeIf", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArrayMap.kt */
public final class IdentityArrayMap<Key, Value> {
    public static final int $stable = 8;
    private Object[] keys;
    /* access modifiers changed from: private */
    public int size;
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public IdentityArrayMap(int i) {
        this.keys = new Object[i];
        this.values = new Object[i];
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IdentityArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final boolean contains(Key key) {
        return find(key) >= 0;
    }

    public final Value get(Key key) {
        int find = find(key);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    public final void set(Key key, Value value) {
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i = this.size;
        int find = find(key);
        if (find >= 0) {
            objArr2[find] = value;
            return;
        }
        int i2 = -(find + 1);
        boolean z = i == objArr.length;
        Object[] objArr3 = z ? new Object[(i * 2)] : objArr;
        int i3 = i2 + 1;
        ArraysKt.copyInto((T[]) objArr, (T[]) objArr3, i3, i2, i);
        if (z) {
            ArraysKt.copyInto$default(objArr, objArr3, 0, 0, i2, 6, (Object) null);
        }
        objArr3[i2] = key;
        this.keys = objArr3;
        Object[] objArr4 = z ? new Object[(i * 2)] : objArr2;
        ArraysKt.copyInto((T[]) objArr2, (T[]) objArr4, i3, i2, i);
        if (z) {
            ArraysKt.copyInto$default(objArr2, objArr4, 0, 0, i2, 6, (Object) null);
        }
        objArr4[i2] = value;
        this.values = objArr4;
        this.size++;
    }

    public final Value remove(Key key) {
        int find = find(key);
        if (find < 0) {
            return null;
        }
        Value[] valueArr = this.values;
        Value value = valueArr[find];
        int i = this.size;
        Object[] objArr = this.keys;
        int i2 = find + 1;
        ArraysKt.copyInto((T[]) objArr, (T[]) objArr, find, i2, i);
        ArraysKt.copyInto((T[]) valueArr, (T[]) valueArr, find, i2, i);
        int i3 = i - 1;
        objArr[i3] = null;
        valueArr[i3] = null;
        this.size = i3;
        return value;
    }

    public final void clear() {
        this.size = 0;
        ArraysKt.fill$default(this.keys, (Object) null, 0, 0, 6, (Object) null);
        ArraysKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
    }

    public final void removeIf(Function2<? super Key, ? super Value, Boolean> function2) {
        int size2 = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            Object obj = getKeys()[i2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!function2.invoke(obj, getValues()[i2]).booleanValue()) {
                if (i != i2) {
                    getKeys()[i] = obj;
                    getValues()[i] = getValues()[i2];
                }
                i++;
            }
        }
        if (getSize() > i) {
            int size3 = getSize();
            for (int i3 = i; i3 < size3; i3++) {
                getKeys()[i3] = null;
                getValues()[i3] = null;
            }
            this.size = i;
        }
    }

    public final void forEach(Function2<? super Key, ? super Value, Unit> function2) {
        int size2 = getSize();
        for (int i = 0; i < size2; i++) {
            Object obj = getKeys()[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            function2.invoke(obj, getValues()[i]);
        }
    }

    private final int find(Object obj) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i = this.size - 1;
        Object[] objArr = this.keys;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = objArr[i3];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i2 = i3 + 1;
            } else if (identityHashCode2 > identityHashCode) {
                i = i3 - 1;
            } else if (obj == obj2) {
                return i3;
            } else {
                return findExactIndex(i3, obj, identityHashCode);
            }
        }
        return -(i2 + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        Object obj2;
        Object[] objArr = this.keys;
        int i3 = this.size;
        for (int i4 = i - 1; -1 < i4; i4--) {
            Object obj3 = objArr[i4];
            if (obj3 == obj) {
                return i4;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
        }
        do {
            i++;
            if (i >= i3) {
                return -(i3 + 1);
            }
            obj2 = objArr[i];
            if (obj2 == obj) {
                return i;
            }
        } while (ActualJvm_jvmKt.identityHashCode(obj2) == i2);
        return -(i + 1);
    }

    public final Map<Key, Value> asMap() {
        return new IdentityArrayMap$asMap$1(this);
    }

    public final void removeValueIf(Function1<? super Value, Boolean> function1) {
        int size2 = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            Object obj = getKeys()[i2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!function1.invoke(getValues()[i2]).booleanValue()) {
                if (i != i2) {
                    getKeys()[i] = obj;
                    getValues()[i] = getValues()[i2];
                }
                i++;
            }
        }
        if (getSize() > i) {
            int size3 = getSize();
            for (int i3 = i; i3 < size3; i3++) {
                getKeys()[i3] = null;
                getValues()[i3] = null;
            }
            this.size = i;
        }
    }
}
