package androidx.compose.ui.platform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/ValueElementSequence;", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "()V", "elements", "", "iterator", "", "set", "", "name", "", "value", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class ValueElementSequence implements Sequence<ValueElement> {
    public static final int $stable = 8;
    private final List<ValueElement> elements = new ArrayList();

    public Iterator<ValueElement> iterator() {
        return this.elements.iterator();
    }

    public final void set(String str, Object obj) {
        this.elements.add(new ValueElement(str, obj));
    }
}
