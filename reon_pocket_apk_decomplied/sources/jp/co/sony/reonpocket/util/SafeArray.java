package jp.co.sony.reonpocket.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u001b\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/util/SafeArray;", "T", "", "list", "", "(Ljava/util/List;)V", "add", "", "value", "(Ljava/lang/Object;)V", "index", "", "(ILjava/lang/Object;)V", "get", "(I)Ljava/lang/Object;", "getArray", "", "isIndexValid", "", "removeAt", "set", "size", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SafeArray.kt */
public final class SafeArray<T> {
    public static final int $stable = 8;
    private final List<T> list;

    public SafeArray() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public SafeArray(List<T> list2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SafeArray(List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list2);
    }

    private final boolean isIndexValid(int i) {
        return i >= 0 && i < this.list.size();
    }

    public final T get(int i) {
        if (isIndexValid(i)) {
            return this.list.get(i);
        }
        return null;
    }

    public final void set(int i, T t) {
        if (isIndexValid(i)) {
            this.list.set(i, t);
            return;
        }
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("Error: Index " + i + " out of bounds");
    }

    public final void add(T t) {
        this.list.add(t);
    }

    public final void add(int i, T t) {
        if (i < 0 || i > this.list.size()) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.e("Error: Index " + i + " out of bounds");
            return;
        }
        this.list.add(i, t);
    }

    public final void removeAt(int i) {
        if (isIndexValid(i)) {
            this.list.remove(i);
            return;
        }
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("Error: Index " + i + " out of bounds");
    }

    public final int size() {
        return this.list.size();
    }

    public final List<T> getArray() {
        return this.list;
    }
}
