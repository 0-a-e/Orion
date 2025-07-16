package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u001d\u0012\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0014J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000R \u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/ComputableClassValue;", "V", "Ljava/lang/ClassValue;", "Ljava/lang/ref/SoftReference;", "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "(Lkotlin/jvm/functions/Function1;)V", "computeValue", "type", "createNewCopy", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CacheByClass.kt */
final class ComputableClassValue<V> extends ClassValue<SoftReference<V>> {
    public final Function1<Class<?>, V> compute;

    public ComputableClassValue(Function1<? super Class<?>, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(function1, "compute");
        this.compute = function1;
    }

    /* access modifiers changed from: protected */
    public SoftReference<V> computeValue(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, TransferTable.COLUMN_TYPE);
        return new SoftReference<>(this.compute.invoke(cls));
    }

    public final ComputableClassValue<V> createNewCopy() {
        return new ComputableClassValue<>(this.compute);
    }
}
