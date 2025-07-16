package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0019\u0010\u000b\u001a\u00028\u00002\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/ClassValueCache;", "V", "Lkotlin/reflect/jvm/internal/CacheByClass;", "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "(Lkotlin/jvm/functions/Function1;)V", "classValue", "Lkotlin/reflect/jvm/internal/ComputableClassValue;", "clear", "", "get", "key", "(Ljava/lang/Class;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CacheByClass.kt */
final class ClassValueCache<V> extends CacheByClass<V> {
    private volatile ComputableClassValue<V> classValue;

    public ClassValueCache(Function1<? super Class<?>, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(function1, "compute");
        this.classValue = new ComputableClassValue<>(function1);
    }

    public V get(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, TransferTable.COLUMN_KEY);
        ComputableClassValue<V> computableClassValue = this.classValue;
        V v = ((SoftReference) ClassValueCache$$ExternalSyntheticApiModelOutline0.m((ComputableClassValue) computableClassValue, (Class) cls)).get();
        if (v != null) {
            return v;
        }
        ClassValueCache$$ExternalSyntheticApiModelOutline0.m((ComputableClassValue) computableClassValue, (Class) cls);
        V v2 = ((SoftReference) ClassValueCache$$ExternalSyntheticApiModelOutline0.m((ComputableClassValue) computableClassValue, (Class) cls)).get();
        if (v2 != null) {
            return v2;
        }
        return computableClassValue.compute.invoke(cls);
    }

    public void clear() {
        this.classValue = this.classValue.createNewCopy();
    }
}
