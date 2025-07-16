package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0002J2\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u000e0\u0017H\u0016J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u001a\u0010\u001b\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "T", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "()V", "intervals", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "lastInterval", "<set-?>", "", "size", "getSize", "()I", "addInterval", "", "value", "(ILjava/lang/Object;)V", "checkIndexBounds", "index", "forEach", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", "get", "getIntervalForIndex", "itemIndex", "contains", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntervalList.kt */
public final class MutableIntervalList<T> implements IntervalList<T> {
    public static final int $stable = 8;
    private final MutableVector<IntervalList.Interval<T>> intervals = new MutableVector<>(new IntervalList.Interval[16], 0);
    private IntervalList.Interval<? extends T> lastInterval;
    private int size;

    public int getSize() {
        return this.size;
    }

    public final void addInterval(int i, T t) {
        if (i < 0) {
            throw new IllegalArgumentException(("size should be >=0, but was " + i).toString());
        } else if (i != 0) {
            IntervalList.Interval interval = new IntervalList.Interval(getSize(), i, t);
            this.size = getSize() + i;
            this.intervals.add(interval);
        }
    }

    public void forEach(int i, int i2, Function1<? super IntervalList.Interval<? extends T>, Unit> function1) {
        checkIndexBounds(i);
        checkIndexBounds(i2);
        if (i2 >= i) {
            int access$binarySearch = IntervalListKt.binarySearch(this.intervals, i);
            int startIndex = ((IntervalList.Interval) this.intervals.getContent()[access$binarySearch]).getStartIndex();
            while (startIndex <= i2) {
                IntervalList.Interval interval = (IntervalList.Interval) this.intervals.getContent()[access$binarySearch];
                function1.invoke(interval);
                startIndex += interval.getSize();
                access$binarySearch++;
            }
            return;
        }
        throw new IllegalArgumentException(("toIndex (" + i2 + ") should be not smaller than fromIndex (" + i + ')').toString());
    }

    public IntervalList.Interval<T> get(int i) {
        checkIndexBounds(i);
        return getIntervalForIndex(i);
    }

    private final IntervalList.Interval<T> getIntervalForIndex(int i) {
        IntervalList.Interval<? extends T> interval = this.lastInterval;
        if (interval != null && contains(interval, i)) {
            return interval;
        }
        MutableVector<IntervalList.Interval<T>> mutableVector = this.intervals;
        IntervalList.Interval<? extends T> interval2 = (IntervalList.Interval) mutableVector.getContent()[IntervalListKt.binarySearch(mutableVector, i)];
        this.lastInterval = interval2;
        return interval2;
    }

    private final void checkIndexBounds(int i) {
        if (i < 0 || i >= getSize()) {
            throw new IndexOutOfBoundsException("Index " + i + ", size " + getSize());
        }
    }

    private final boolean contains(IntervalList.Interval<? extends T> interval, int i) {
        return i < interval.getStartIndex() + interval.getSize() && interval.getStartIndex() <= i;
    }
}
