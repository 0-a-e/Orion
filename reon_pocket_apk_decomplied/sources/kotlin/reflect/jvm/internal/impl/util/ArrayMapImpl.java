package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArrayMap.kt */
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public Object[] data;
    private int size;

    /* compiled from: ArrayMap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private ArrayMapImpl(Object[] objArr, int i) {
        super((DefaultConstructorMarker) null);
        this.data = objArr;
        this.size = i;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }

    public int getSize() {
        return this.size;
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.data;
        if (objArr.length <= i) {
            int length = objArr.length;
            do {
                length *= 2;
            } while (length <= i);
            Object[] copyOf = Arrays.copyOf(this.data, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.data = copyOf;
        }
    }

    public void set(int i, T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        ensureCapacity(i);
        if (this.data[i] == null) {
            this.size = getSize() + 1;
        }
        this.data[i] = t;
    }

    public T get(int i) {
        return ArraysKt.getOrNull((T[]) this.data, i);
    }

    public Iterator<T> iterator() {
        return new ArrayMapImpl$iterator$1(this);
    }
}
