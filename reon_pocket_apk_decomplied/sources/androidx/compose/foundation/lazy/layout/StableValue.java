package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0001\u0003¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/StableValue;", "T", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: LazyLayoutItemContentFactory.kt */
final class StableValue<T> {
    private final T value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ StableValue m915boximpl(Object obj) {
        return new StableValue(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Object m916constructorimpl(T t) {
        return t;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m917equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof StableValue) && Intrinsics.areEqual(obj, ((StableValue) obj2).m921unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m918equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m919hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m920toStringimpl(Object obj) {
        return "StableValue(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m917equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m919hashCodeimpl(this.value);
    }

    public String toString() {
        return m920toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m921unboximpl() {
        return this.value;
    }

    private /* synthetic */ StableValue(Object obj) {
        this.value = obj;
    }

    public final T getValue() {
        return this.value;
    }
}
