package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0010H\u0002J\t\u0010\u0011\u001a\u00020\u0002H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/SourceInformationGroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "table", "Landroidx/compose/runtime/SlotTable;", "group", "Landroidx/compose/runtime/GroupSourceInformation;", "(Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/GroupSourceInformation;)V", "getGroup", "()Landroidx/compose/runtime/GroupSourceInformation;", "index", "", "getTable", "()Landroidx/compose/runtime/SlotTable;", "version", "hasNext", "", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
final class SourceInformationGroupIterator implements Iterator<CompositionGroup>, KMappedMarker {
    private final GroupSourceInformation group;
    private int index;
    private final SlotTable table;
    private final int version;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public SourceInformationGroupIterator(SlotTable slotTable, GroupSourceInformation groupSourceInformation) {
        this.table = slotTable;
        this.group = groupSourceInformation;
        this.version = slotTable.getVersion$runtime_release();
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final GroupSourceInformation getGroup() {
        return this.group;
    }

    public boolean hasNext() {
        ArrayList<Object> groups = this.group.getGroups();
        return groups != null && this.index < groups.size();
    }

    public CompositionGroup next() {
        Object obj;
        ArrayList<Object> groups = this.group.getGroups();
        if (groups != null) {
            int i = this.index;
            this.index = i + 1;
            obj = groups.get(i);
        } else {
            obj = null;
        }
        if (obj instanceof Anchor) {
            return new SlotTableGroup(this.table, ((Anchor) obj).getLocation$runtime_release(), this.version);
        }
        if (obj instanceof GroupSourceInformation) {
            return new SourceInformationSlotTableGroup(this.table, (GroupSourceInformation) obj);
        }
        ComposerKt.composeRuntimeError("Unexpected group information structure");
        throw new KotlinNothingValueException();
    }
}
