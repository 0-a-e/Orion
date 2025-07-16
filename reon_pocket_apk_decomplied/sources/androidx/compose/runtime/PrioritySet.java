package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/PrioritySet;", "", "list", "", "", "(Ljava/util/List;)V", "add", "", "value", "isEmpty", "", "isNotEmpty", "peek", "takeMax", "validateHeap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class PrioritySet {
    public static final int $stable = 8;
    private final List<Integer> list;

    public PrioritySet() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public PrioritySet(List<Integer> list2) {
        this.list = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrioritySet(List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list2);
    }

    public final void add(int i) {
        if (!this.list.isEmpty()) {
            if (this.list.get(0).intValue() != i) {
                List<Integer> list2 = this.list;
                if (list2.get(list2.size() - 1).intValue() == i) {
                    return;
                }
            } else {
                return;
            }
        }
        int size = this.list.size();
        this.list.add(Integer.valueOf(i));
        while (size > 0) {
            int i2 = ((size + 1) >>> 1) - 1;
            int intValue = this.list.get(i2).intValue();
            if (i <= intValue) {
                break;
            }
            this.list.set(size, Integer.valueOf(intValue));
            size = i2;
        }
        this.list.set(size, Integer.valueOf(i));
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        return ((Number) CollectionsKt.first(this.list)).intValue();
    }

    public final int takeMax() {
        int intValue;
        if (this.list.size() > 0) {
            int intValue2 = this.list.get(0).intValue();
            while ((!this.list.isEmpty()) && this.list.get(0).intValue() == intValue2) {
                List<Integer> list2 = this.list;
                list2.set(0, CollectionsKt.last(list2));
                List<Integer> list3 = this.list;
                list3.remove(list3.size() - 1);
                int size = this.list.size();
                int size2 = this.list.size() >>> 1;
                int i = 0;
                while (i < size2) {
                    int intValue3 = this.list.get(i).intValue();
                    int i2 = (i + 1) * 2;
                    int i3 = i2 - 1;
                    int intValue4 = this.list.get(i3).intValue();
                    if (i2 < size && (intValue = this.list.get(i2).intValue()) > intValue4) {
                        if (intValue <= intValue3) {
                            break;
                        }
                        this.list.set(i, Integer.valueOf(intValue));
                        this.list.set(i2, Integer.valueOf(intValue3));
                        i = i2;
                    } else if (intValue4 <= intValue3) {
                        break;
                    } else {
                        this.list.set(i, Integer.valueOf(intValue4));
                        this.list.set(i3, Integer.valueOf(intValue3));
                        i = i3;
                    }
                }
            }
            return intValue2;
        }
        ComposerKt.composeRuntimeError("Set is empty".toString());
        throw new KotlinNothingValueException();
    }

    public final void validateHeap() {
        int size = this.list.size();
        int i = size / 2;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            int i4 = i3 * 2;
            if (this.list.get(i2).intValue() < this.list.get(i4 - 1).intValue()) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (i4 >= size || this.list.get(i2).intValue() >= this.list.get(i4).intValue()) {
                i2 = i3;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }
}
