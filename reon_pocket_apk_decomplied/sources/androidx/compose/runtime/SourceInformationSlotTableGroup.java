package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001fH\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Landroidx/compose/runtime/SourceInformationSlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/SlotTable;", "sourceInformation", "Landroidx/compose/runtime/GroupSourceInformation;", "(Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/GroupSourceInformation;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "data", "", "getData", "isEmpty", "", "()Z", "key", "getKey", "()Ljava/lang/Object;", "node", "getNode", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "getSourceInformation", "()Landroidx/compose/runtime/GroupSourceInformation;", "getTable", "()Landroidx/compose/runtime/SlotTable;", "iterator", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
final class SourceInformationSlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {
    private final Iterable<CompositionGroup> compositionGroups = this;
    private final Iterable<Object> data = CollectionsKt.emptyList();
    private final Object key;
    private final GroupSourceInformation sourceInformation;
    private final SlotTable table;

    public /* synthetic */ CompositionGroup find(Object obj) {
        return CompositionData.CC.$default$find(this, obj);
    }

    public /* synthetic */ int getGroupSize() {
        return CompositionGroup.CC.$default$getGroupSize(this);
    }

    public /* synthetic */ Object getIdentity() {
        return CompositionGroup.CC.$default$getIdentity(this);
    }

    public Object getNode() {
        return null;
    }

    public /* synthetic */ int getSlotsSize() {
        return CompositionGroup.CC.$default$getSlotsSize(this);
    }

    public SourceInformationSlotTableGroup(SlotTable slotTable, GroupSourceInformation groupSourceInformation) {
        this.table = slotTable;
        this.sourceInformation = groupSourceInformation;
        this.key = Integer.valueOf(groupSourceInformation.getKey());
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final GroupSourceInformation getSourceInformation() {
        return this.sourceInformation;
    }

    public Object getKey() {
        return this.key;
    }

    public String getSourceInfo() {
        return this.sourceInformation.getSourceInformation();
    }

    public Iterable<Object> getData() {
        return this.data;
    }

    public Iterable<CompositionGroup> getCompositionGroups() {
        return this.compositionGroups;
    }

    public boolean isEmpty() {
        ArrayList<Object> groups = this.sourceInformation.getGroups();
        boolean z = false;
        if (groups != null && !groups.isEmpty()) {
            z = true;
        }
        return !z;
    }

    public Iterator<CompositionGroup> iterator() {
        return new SourceInformationGroupIterator(this.table, this.sourceInformation);
    }
}
