package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\f*\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014j\u0002\b\u0015j\u0002\b\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode;", "", "(Ljava/lang/String;I)V", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "isSelected", "", "start", "end", "isSelected-2x9bVx0$foundation_release", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "containsInclusive", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Vertical", "Horizontal", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionMode.kt */
public enum SelectionMode {
    ;

    /* renamed from: compare-3MmeM6k$foundation_release  reason: not valid java name */
    public abstract int m1284compare3MmeM6k$foundation_release(long j, Rect rect);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0010ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode$Vertical;", "Landroidx/compose/foundation/text/selection/SelectionMode;", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionMode.kt */
    static final class Vertical extends SelectionMode {
        Vertical(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        /* renamed from: compare-3MmeM6k$foundation_release  reason: not valid java name */
        public int m1287compare3MmeM6k$foundation_release(long j, Rect rect) {
            if (SelectionManagerKt.m1277containsInclusiveUv8p0NA(rect, j)) {
                return 0;
            }
            if (Offset.m3563getYimpl(j) < rect.getTop()) {
                return -1;
            }
            if (Offset.m3562getXimpl(j) >= rect.getLeft() || Offset.m3563getYimpl(j) >= rect.getBottom()) {
                return 1;
            }
            return -1;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0010ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode$Horizontal;", "Landroidx/compose/foundation/text/selection/SelectionMode;", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionMode.kt */
    static final class Horizontal extends SelectionMode {
        Horizontal(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        /* renamed from: compare-3MmeM6k$foundation_release  reason: not valid java name */
        public int m1286compare3MmeM6k$foundation_release(long j, Rect rect) {
            if (SelectionManagerKt.m1277containsInclusiveUv8p0NA(rect, j)) {
                return 0;
            }
            if (Offset.m3562getXimpl(j) < rect.getLeft()) {
                return -1;
            }
            if (Offset.m3563getYimpl(j) >= rect.getTop() || Offset.m3562getXimpl(j) >= rect.getRight()) {
                return 1;
            }
            return -1;
        }
    }

    /* renamed from: isSelected-2x9bVx0$foundation_release  reason: not valid java name */
    public final boolean m1285isSelected2x9bVx0$foundation_release(Rect rect, long j, long j2) {
        boolean z = true;
        if (m1283containsInclusiveUv8p0NA(rect, j) || m1283containsInclusiveUv8p0NA(rect, j2)) {
            return true;
        }
        int r4 = m1284compare3MmeM6k$foundation_release(j, rect);
        int r3 = m1284compare3MmeM6k$foundation_release(j2, rect);
        boolean z2 = r4 > 0;
        if (r3 <= 0) {
            z = false;
        }
        return z2 ^ z;
    }

    /* renamed from: containsInclusive-Uv8p0NA  reason: not valid java name */
    private final boolean m1283containsInclusiveUv8p0NA(Rect rect, long j) {
        float left = rect.getLeft();
        float right = rect.getRight();
        float r2 = Offset.m3562getXimpl(j);
        if (left <= r2 && r2 <= right) {
            float top = rect.getTop();
            float bottom = rect.getBottom();
            float r5 = Offset.m3563getYimpl(j);
            return top <= r5 && r5 <= bottom;
        }
    }
}
