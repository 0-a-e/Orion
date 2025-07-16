package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH&J%\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH&J\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\n\u0010!\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\"\u001a\u00020#H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/Selectable;", "", "selectableId", "", "getSelectableId", "()J", "appendSelectableInfoToBuilder", "", "builder", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "", "getCenterYForOffset", "", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLastVisibleOffset", "getLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLineLeft", "getLineRight", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getSelectAllSelection", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Selectable.kt */
public interface Selectable {
    void appendSelectableInfoToBuilder(SelectionLayoutBuilder selectionLayoutBuilder);

    Rect getBoundingBox(int i);

    float getCenterYForOffset(int i);

    /* renamed from: getHandlePosition-dBAh8RU  reason: not valid java name */
    long m1223getHandlePositiondBAh8RU(Selection selection, boolean z);

    int getLastVisibleOffset();

    LayoutCoordinates getLayoutCoordinates();

    float getLineLeft(int i);

    float getLineRight(int i);

    /* renamed from: getRangeOfLineContaining--jx7JFs  reason: not valid java name */
    long m1224getRangeOfLineContainingjx7JFs(int i);

    Selection getSelectAllSelection();

    long getSelectableId();

    AnnotatedString getText();
}
