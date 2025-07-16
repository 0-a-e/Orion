package androidx.compose.material3.carousel;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010*\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0003J\u0017\u0010!\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0001J\u000e\u0010$\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020%J\u0011\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\tH\u0003J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020%J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020%J\u0011\u0010+\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H\u0001J\t\u0010,\u001a\u00020\u001fH\u0001J\u0006\u0010-\u001a\u00020\u001fJ\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020%J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000201H\u0003J\u000e\u00102\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020%J\u0011\u00103\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H\u0001J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000205H\u0001J\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u0002052\u0006\u0010'\u001a\u00020\tH\u0001J\u001f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0001R\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0012\u0010\u001c\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000b¨\u00069"}, d2 = {"Landroidx/compose/material3/carousel/KeylineList;", "", "Landroidx/compose/material3/carousel/Keyline;", "keylines", "(Ljava/util/List;)V", "firstFocal", "getFirstFocal", "()Landroidx/compose/material3/carousel/Keyline;", "firstFocalIndex", "", "getFirstFocalIndex", "()I", "firstNonAnchor", "getFirstNonAnchor", "firstNonAnchorIndex", "getFirstNonAnchorIndex", "lastFocal", "getLastFocal", "lastFocalIndex", "getLastFocalIndex", "lastNonAnchor", "getLastNonAnchor", "lastNonAnchorIndex", "getLastNonAnchorIndex", "pivot", "getPivot", "pivotIndex", "getPivotIndex", "size", "getSize", "contains", "", "element", "containsAll", "elements", "", "firstIndexAfterFocalRangeWithSize", "", "get", "index", "getKeylineAfter", "unadjustedOffset", "getKeylineBefore", "indexOf", "isEmpty", "isFirstFocalItemAtStartOfContainer", "isLastFocalItemAtEndOfContainer", "carouselMainAxisSize", "iterator", "", "lastIndexBeforeFocalRangeWithSize", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Keyline.kt */
public final class KeylineList implements List<Keyline>, KMappedMarker {
    public static final int $stable = 8;
    private final /* synthetic */ List<Keyline> $$delegate_0;
    private final Keyline firstFocal;
    private final int firstFocalIndex;
    private final Keyline firstNonAnchor;
    private final int firstNonAnchorIndex;
    private final Keyline lastFocal;
    private final int lastFocalIndex;
    private final Keyline lastNonAnchor;
    private final int lastNonAnchorIndex;
    private final Keyline pivot;
    private final int pivotIndex;

    public void add(int i, Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends Keyline> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Keyline> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Keyline keyline) {
        return this.$$delegate_0.contains(keyline);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.$$delegate_0.containsAll(collection);
    }

    public Keyline get(int i) {
        return this.$$delegate_0.get(i);
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    public int indexOf(Keyline keyline) {
        return this.$$delegate_0.indexOf(keyline);
    }

    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    public Iterator<Keyline> iterator() {
        return this.$$delegate_0.iterator();
    }

    public int lastIndexOf(Keyline keyline) {
        return this.$$delegate_0.lastIndexOf(keyline);
    }

    public ListIterator<Keyline> listIterator() {
        return this.$$delegate_0.listIterator();
    }

    public ListIterator<Keyline> listIterator(int i) {
        return this.$$delegate_0.listIterator(i);
    }

    public Keyline remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator<Keyline> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Keyline set(int i, Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void sort(Comparator<? super Keyline> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Keyline> subList(int i, int i2) {
        return this.$$delegate_0.subList(i, i2);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    public KeylineList(List<Keyline> list) {
        int i;
        int i2;
        this.$$delegate_0 = list;
        List list2 = this;
        Iterator it = list2.iterator();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i4 = -1;
                break;
            } else if (((Keyline) it.next()).isPivot()) {
                break;
            } else {
                i4++;
            }
        }
        this.pivotIndex = i4;
        this.pivot = get(i4);
        Iterator it2 = list2.iterator();
        int i5 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i5 = -1;
                break;
            } else if (!((Keyline) it2.next()).isAnchor()) {
                break;
            } else {
                i5++;
            }
        }
        this.firstNonAnchorIndex = i5;
        this.firstNonAnchor = get(i5);
        ListIterator listIterator = list2.listIterator(list2.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (!((Keyline) listIterator.previous()).isAnchor()) {
                    i2 = listIterator.nextIndex();
                    break;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        this.lastNonAnchorIndex = i2;
        this.lastNonAnchor = get(i2);
        Iterator it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                i3 = -1;
                break;
            } else if (((Keyline) it3.next()).isFocal()) {
                break;
            } else {
                i3++;
            }
        }
        this.firstFocalIndex = i3;
        Keyline keyline = (Keyline) CollectionsKt.getOrNull(list2, i3);
        if (keyline != null) {
            this.firstFocal = keyline;
            ListIterator listIterator2 = list2.listIterator(list2.size());
            while (true) {
                if (listIterator2.hasPrevious()) {
                    if (((Keyline) listIterator2.previous()).isFocal()) {
                        i = listIterator2.nextIndex();
                        break;
                    }
                } else {
                    break;
                }
            }
            this.lastFocalIndex = i;
            Keyline keyline2 = (Keyline) CollectionsKt.getOrNull(list2, i);
            if (keyline2 != null) {
                this.lastFocal = keyline2;
                return;
            }
            throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
        }
        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Keyline)) {
            return false;
        }
        return contains((Keyline) obj);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Keyline)) {
            return -1;
        }
        return indexOf((Keyline) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Keyline)) {
            return -1;
        }
        return lastIndexOf((Keyline) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final int getPivotIndex() {
        return this.pivotIndex;
    }

    public final Keyline getPivot() {
        return this.pivot;
    }

    public final int getFirstNonAnchorIndex() {
        return this.firstNonAnchorIndex;
    }

    public final Keyline getFirstNonAnchor() {
        return this.firstNonAnchor;
    }

    public final int getLastNonAnchorIndex() {
        return this.lastNonAnchorIndex;
    }

    public final Keyline getLastNonAnchor() {
        return this.lastNonAnchor;
    }

    public final int getFirstFocalIndex() {
        return this.firstFocalIndex;
    }

    public final Keyline getFirstFocal() {
        return this.firstFocal;
    }

    public final int getLastFocalIndex() {
        return this.lastFocalIndex;
    }

    public final Keyline getLastFocal() {
        return this.lastFocal;
    }

    public final boolean isFirstFocalItemAtStartOfContainer() {
        return this.firstFocal.getOffset() - (this.firstFocal.getSize() / ((float) 2)) >= 0.0f && Intrinsics.areEqual((Object) this.firstFocal, (Object) this.firstNonAnchor);
    }

    public final boolean isLastFocalItemAtEndOfContainer(float f) {
        return this.lastFocal.getOffset() + (this.lastFocal.getSize() / ((float) 2)) <= f && Intrinsics.areEqual((Object) this.lastFocal, (Object) this.lastNonAnchor);
    }

    public final int firstIndexAfterFocalRangeWithSize(float f) {
        Object obj;
        List list = this;
        Iterator it = new IntRange(this.lastFocalIndex, CollectionsKt.getLastIndex(list)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (get(((Number) obj).intValue()).getSize() == f) {
                break;
            }
        }
        Integer num = (Integer) obj;
        return num != null ? num.intValue() : CollectionsKt.getLastIndex(list);
    }

    public final int lastIndexBeforeFocalRangeWithSize(float f) {
        Object obj;
        Iterator it = RangesKt.downTo(this.firstFocalIndex - 1, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (get(((Number) obj).intValue()).getSize() == f) {
                break;
            }
        }
        Integer num = (Integer) obj;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final Keyline getKeylineBefore(float f) {
        int size = size() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                Keyline keyline = get(size);
                if (keyline.getUnadjustedOffset() < f) {
                    return keyline;
                }
                if (i < 0) {
                    break;
                }
                size = i;
            }
        }
        return (Keyline) CollectionsKt.first(this);
    }

    public final Keyline getKeylineAfter(float f) {
        Object obj;
        List list = this;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list.get(i);
            if (((Keyline) obj).getUnadjustedOffset() >= f) {
                break;
            }
            i++;
        }
        Keyline keyline = (Keyline) obj;
        return keyline == null ? (Keyline) CollectionsKt.last(list) : keyline;
    }
}
