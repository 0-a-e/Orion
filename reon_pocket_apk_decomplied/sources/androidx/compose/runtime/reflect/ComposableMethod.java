package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J:\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableMethod;", "", "method", "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "parameterCount", "", "getParameterCount", "()I", "parameterTypes", "", "Ljava/lang/Class;", "getParameterTypes", "()[Ljava/lang/Class;", "parameters", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "asMethod", "equals", "", "other", "hashCode", "invoke", "composer", "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposableMethod.jvm.kt */
public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    public ComposableMethod(Method method2, ComposableInfo composableInfo2) {
        this.method = method2;
        this.composableInfo = composableInfo2;
    }

    public final Method asMethod() {
        return this.method;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Parameter[] getParameters() {
        return (Parameter[]) ArraysKt.copyOfRange((T[]) this.method.getParameters(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Class<?>[] getParameterTypes() {
        return (Class[]) ArraysKt.copyOfRange((T[]) this.method.getParameterTypes(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Object invoke(Composer composer, Object obj, Object... objArr) {
        Object obj2;
        Object[] objArr2 = objArr;
        ComposableInfo composableInfo2 = this.composableInfo;
        int component2 = composableInfo2.component2();
        int component3 = composableInfo2.component3();
        int component4 = composableInfo2.component4();
        int length = this.method.getParameterTypes().length;
        int i = component2 + 1;
        int i2 = component3 + i;
        Object[] objArr3 = new Integer[component4];
        int i3 = 0;
        for (int i4 = 0; i4 < component4; i4++) {
            int i5 = i4 * 31;
            Iterable until = RangesKt.until(i5, Math.min(i5 + 31, component2));
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                arrayList.add(Integer.valueOf((nextInt >= objArr2.length || objArr2[nextInt] == null) ? 1 : 0));
            }
            int i6 = 0;
            int i7 = 0;
            for (Object next : (List) arrayList) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                i6 |= ((Number) next).intValue() << i7;
                i7 = i8;
            }
            objArr3[i4] = Integer.valueOf(i6);
        }
        Object[] objArr4 = new Object[length];
        while (i3 < length) {
            if (i3 >= 0 && i3 < component2) {
                obj2 = (i3 < 0 || i3 > ArraysKt.getLastIndex((T[]) objArr)) ? ComposableMethodKt.getDefaultValue(this.method.getParameterTypes()[i3]) : objArr2[i3];
            } else if (i3 == component2) {
                obj2 = composer;
            } else if (i3 == i || (component2 + 2 <= i3 && i3 < i2)) {
                obj2 = 0;
            } else if (i2 > i3 || i3 >= length) {
                throw new IllegalStateException("Unexpected index".toString());
            } else {
                obj2 = objArr3[i3 - i2];
            }
            objArr4[i3] = obj2;
            i3++;
        }
        return this.method.invoke(obj, Arrays.copyOf(objArr4, length));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ComposableMethod) {
            return Intrinsics.areEqual((Object) this.method, (Object) ((ComposableMethod) obj).method);
        }
        return false;
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
