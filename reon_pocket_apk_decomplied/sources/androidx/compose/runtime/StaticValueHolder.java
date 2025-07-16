package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/StaticValueHolder;", "T", "Landroidx/compose/runtime/State;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Landroidx/compose/runtime/StaticValueHolder;", "equals", "", "other", "", "hashCode", "", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ValueHolders.kt */
public final class StaticValueHolder<T> implements State<T> {
    public static final int $stable = 0;
    private final T value;

    public static /* synthetic */ StaticValueHolder copy$default(StaticValueHolder staticValueHolder, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            t = staticValueHolder.value;
        }
        return staticValueHolder.copy(t);
    }

    public final T component1() {
        return this.value;
    }

    public final StaticValueHolder<T> copy(T t) {
        return new StaticValueHolder<>(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StaticValueHolder) && Intrinsics.areEqual((Object) this.value, (Object) ((StaticValueHolder) obj).value);
    }

    public int hashCode() {
        T t = this.value;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "StaticValueHolder(value=" + this.value + ')';
    }

    public StaticValueHolder(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }
}
