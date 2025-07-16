package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ArrayMapOwner.kt */
public abstract class TypeRegistry<K, V> {
    /* access modifiers changed from: private */
    public final AtomicInteger idCounter = new AtomicInteger(0);
    private final ConcurrentHashMap<String, Integer> idPerType = new ConcurrentHashMap<>();

    public abstract int customComputeIfAbsent(ConcurrentHashMap<String, Integer> concurrentHashMap, String str, Function1<? super String, Integer> function1);

    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(KClass<KK> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new NullableArrayMapAccessor<>(getId(kClass));
    }

    public final <T extends K> int getId(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        String qualifiedName = kClass.getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName);
        return getId(qualifiedName);
    }

    public final int getId(String str) {
        Intrinsics.checkNotNullParameter(str, "keyQualifiedName");
        return customComputeIfAbsent(this.idPerType, str, new TypeRegistry$getId$1(this));
    }

    /* access modifiers changed from: protected */
    public final Collection<Integer> getIndices() {
        Collection<Integer> values = this.idPerType.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return values;
    }
}
