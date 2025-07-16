package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0015H\u0002J\u0011\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0002J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/DataIterator;", "", "", "", "table", "Landroidx/compose/runtime/SlotTable;", "group", "", "(Landroidx/compose/runtime/SlotTable;I)V", "end", "getEnd", "()I", "index", "getIndex", "setIndex", "(I)V", "start", "getStart", "getTable", "()Landroidx/compose/runtime/SlotTable;", "hasNext", "", "iterator", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
final class DataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {
    private final int end;
    private int index;
    private final int start;
    private final SlotTable table;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public DataIterator(SlotTable slotTable, int i) {
        this.table = slotTable;
        int access$dataAnchor = SlotTableKt.dataAnchor(slotTable.getGroups(), i);
        this.start = access$dataAnchor;
        int i2 = i + 1;
        this.end = i2 < slotTable.getGroupsSize() ? SlotTableKt.dataAnchor(slotTable.getGroups(), i2) : slotTable.getSlotsSize();
        this.index = access$dataAnchor;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public Iterator<Object> iterator() {
        return this;
    }

    public boolean hasNext() {
        return this.index < this.end;
    }

    public Object next() {
        int i = this.index;
        Object obj = (i < 0 || i >= this.table.getSlots().length) ? null : this.table.getSlots()[this.index];
        this.index++;
        return obj;
    }
}
