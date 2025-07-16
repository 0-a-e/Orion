package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"useClassValue", "", "createCache", "Lkotlin/reflect/jvm/internal/CacheByClass;", "V", "", "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: CacheByClass.kt */
public final class CacheByClassKt {
    private static final boolean useClassValue;

    static {
        boolean z;
        try {
            Result.Companion companion = Result.Companion;
            z = Result.m7042constructorimpl(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            z = Result.m7042constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7049isSuccessimpl(z)) {
            Result.Companion companion3 = Result.Companion;
            Class cls = (Class) z;
            z = true;
        }
        Object r0 = Result.m7042constructorimpl(z);
        if (Result.m7048isFailureimpl(r0)) {
            r0 = false;
        }
        useClassValue = ((Boolean) r0).booleanValue();
    }

    public static final <V> CacheByClass<V> createCache(Function1<? super Class<?>, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(function1, "compute");
        return useClassValue ? new ClassValueCache<>(function1) : new ConcurrentHashMapCache<>(function1);
    }
}
