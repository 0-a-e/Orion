package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemReusePolicy;", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "factory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;)V", "countPerType", "", "", "", "areCompatible", "", "slotId", "reusableSlotId", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutItemReusePolicy implements SubcomposeSlotReusePolicy {
    private final Map<Object, Integer> countPerType = new LinkedHashMap();
    private final LazyLayoutItemContentFactory factory;

    public LazyLayoutItemReusePolicy(LazyLayoutItemContentFactory lazyLayoutItemContentFactory) {
        this.factory = lazyLayoutItemContentFactory;
    }

    public void getSlotsToRetain(SubcomposeSlotReusePolicy.SlotIdsSet slotIdsSet) {
        this.countPerType.clear();
        Iterator<Object> it = slotIdsSet.iterator();
        while (it.hasNext()) {
            Object contentType = this.factory.getContentType(it.next());
            Integer num = this.countPerType.get(contentType);
            int intValue = num != null ? num.intValue() : 0;
            if (intValue == 7) {
                it.remove();
            } else {
                this.countPerType.put(contentType, Integer.valueOf(intValue + 1));
            }
        }
    }

    public boolean areCompatible(Object obj, Object obj2) {
        return Intrinsics.areEqual(this.factory.getContentType(obj), this.factory.getContentType(obj2));
    }
}
