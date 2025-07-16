package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0002\u0010\u000fJN\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u000201J \u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020(H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "", "currentPosition", "Landroidx/compose/ui/geometry/Offset;", "previousHandlePosition", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "(JJLandroidx/compose/ui/layout/LayoutCoordinates;ZLandroidx/compose/foundation/text/selection/Selection;Ljava/util/Comparator;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCurrentPosition-F1C5BW0", "()J", "J", "currentSlot", "", "endSlot", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "()Z", "getPreviousHandlePosition-F1C5BW0", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "getSelectableIdOrderingComparator", "()Ljava/util/Comparator;", "selectableIdToInfoListIndex", "", "startSlot", "appendInfo", "selectableId", "rawStartHandleOffset", "startXHandleDirection", "Landroidx/compose/foundation/text/selection/Direction;", "startYHandleDirection", "rawEndHandleOffset", "endXHandleDirection", "endYHandleDirection", "rawPreviousHandleOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "build", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "updateSlot", "slot", "xPositionDirection", "yPositionDirection", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionLayout.kt */
public final class SelectionLayoutBuilder {
    public static final int $stable = 8;
    private final LayoutCoordinates containerCoordinates;
    private final long currentPosition;
    private int currentSlot;
    private int endSlot;
    private final List<SelectableInfo> infoList;
    private final boolean isStartHandle;
    private final long previousHandlePosition;
    private final Selection previousSelection;
    private final Comparator<Long> selectableIdOrderingComparator;
    private final Map<Long, Integer> selectableIdToInfoListIndex;
    private int startSlot;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionLayout.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.foundation.text.selection.Direction[] r0 = androidx.compose.foundation.text.selection.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.selection.Direction r1 = androidx.compose.foundation.text.selection.Direction.BEFORE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.selection.Direction r1 = androidx.compose.foundation.text.selection.Direction.ON     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.selection.Direction r1 = androidx.compose.foundation.text.selection.Direction.AFTER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionLayoutBuilder.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ SelectionLayoutBuilder(long j, long j2, LayoutCoordinates layoutCoordinates, boolean z, Selection selection, Comparator comparator, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, layoutCoordinates, z, selection, comparator);
    }

    private SelectionLayoutBuilder(long j, long j2, LayoutCoordinates layoutCoordinates, boolean z, Selection selection, Comparator<Long> comparator) {
        this.currentPosition = j;
        this.previousHandlePosition = j2;
        this.containerCoordinates = layoutCoordinates;
        this.isStartHandle = z;
        this.previousSelection = selection;
        this.selectableIdOrderingComparator = comparator;
        this.selectableIdToInfoListIndex = new LinkedHashMap();
        this.infoList = new ArrayList();
        this.startSlot = -1;
        this.endSlot = -1;
        this.currentSlot = -1;
    }

    /* renamed from: getCurrentPosition-F1C5BW0  reason: not valid java name */
    public final long m1238getCurrentPositionF1C5BW0() {
        return this.currentPosition;
    }

    /* renamed from: getPreviousHandlePosition-F1C5BW0  reason: not valid java name */
    public final long m1239getPreviousHandlePositionF1C5BW0() {
        return this.previousHandlePosition;
    }

    public final LayoutCoordinates getContainerCoordinates() {
        return this.containerCoordinates;
    }

    public final boolean isStartHandle() {
        return this.isStartHandle;
    }

    public final Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public final Comparator<Long> getSelectableIdOrderingComparator() {
        return this.selectableIdOrderingComparator;
    }

    public final SelectionLayout build() {
        int i = this.currentSlot + 1;
        int size = this.infoList.size();
        if (size == 0) {
            throw new IllegalStateException("SelectionLayout must not be empty.");
        } else if (size != 1) {
            Map<Long, Integer> map = this.selectableIdToInfoListIndex;
            List<SelectableInfo> list = this.infoList;
            int i2 = this.startSlot;
            int i3 = i2 == -1 ? i : i2;
            int i4 = this.endSlot;
            return new MultiSelectionLayout(map, list, i3, i4 == -1 ? i : i4, this.isStartHandle, this.previousSelection);
        } else {
            SelectableInfo selectableInfo = (SelectableInfo) CollectionsKt.single(this.infoList);
            int i5 = this.startSlot;
            int i6 = i5 == -1 ? i : i5;
            int i7 = this.endSlot;
            return new SingleSelectionLayout(this.isStartHandle, i6, i7 == -1 ? i : i7, this.previousSelection, selectableInfo);
        }
    }

    public final SelectableInfo appendInfo(long j, int i, Direction direction, Direction direction2, int i2, Direction direction3, Direction direction4, int i3, TextLayoutResult textLayoutResult) {
        this.currentSlot += 2;
        SelectableInfo selectableInfo = new SelectableInfo(j, this.currentSlot, i, i2, i3, textLayoutResult);
        Direction direction5 = direction;
        Direction direction6 = direction2;
        this.startSlot = updateSlot(this.startSlot, direction, direction2);
        this.endSlot = updateSlot(this.endSlot, direction3, direction4);
        this.selectableIdToInfoListIndex.put(Long.valueOf(j), Integer.valueOf(this.infoList.size()));
        this.infoList.add(selectableInfo);
        return selectableInfo;
    }

    private final int updateSlot(int i, Direction direction, Direction direction2) {
        if (i != -1) {
            return i;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[SelectionLayoutKt.resolve2dDirection(direction, direction2).ordinal()];
        if (i2 == 1) {
            return this.currentSlot - 1;
        }
        if (i2 == 2) {
            return this.currentSlot;
        }
        if (i2 == 3) {
            return i;
        }
        throw new NoWhenBranchMatchedException();
    }
}
