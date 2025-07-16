package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 $2\u00020\u0001:\u0001$J\b\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H&JB\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\nH&J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000eH&J2\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H&R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "", "subselections", "", "", "Landroidx/compose/foundation/text/selection/Selection;", "getSubselections", "()Ljava/util/Map;", "nextSelectableId", "notifyPositionChange", "", "selectableId", "notifySelectableChange", "notifySelectionUpdate", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "newPosition", "Landroidx/compose/ui/geometry/Offset;", "previousPosition", "isStartHandle", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isInTouchMode", "notifySelectionUpdate-njBpvok", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)Z", "notifySelectionUpdateEnd", "notifySelectionUpdateSelectAll", "notifySelectionUpdateStart", "startPosition", "notifySelectionUpdateStart-ubNVwUQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)V", "subscribe", "Landroidx/compose/foundation/text/selection/Selectable;", "selectable", "unsubscribe", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionRegistrar.kt */
public interface SelectionRegistrar {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final long InvalidSelectableId = 0;

    Map<Long, Selection> getSubselections();

    long nextSelectableId();

    void notifyPositionChange(long j);

    void notifySelectableChange(long j);

    /* renamed from: notifySelectionUpdate-njBpvok  reason: not valid java name */
    boolean m1288notifySelectionUpdatenjBpvok(LayoutCoordinates layoutCoordinates, long j, long j2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2);

    void notifySelectionUpdateEnd();

    void notifySelectionUpdateSelectAll(long j, boolean z);

    /* renamed from: notifySelectionUpdateStart-ubNVwUQ  reason: not valid java name */
    void m1289notifySelectionUpdateStartubNVwUQ(LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment, boolean z);

    Selectable subscribe(Selectable selectable);

    void unsubscribe(Selectable selectable);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrar$Companion;", "", "()V", "InvalidSelectableId", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionRegistrar.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long InvalidSelectableId = 0;

        private Companion() {
        }
    }
}
