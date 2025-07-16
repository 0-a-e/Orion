package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH¦\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0003H&J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH&ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH&ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH&ø\u0001\u0000¢\u0006\u0004\b$\u0010\"J\"\u0010%\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001a\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001bH&ø\u0001\u0000¢\u0006\u0004\b-\u0010\"R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006.À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "", "isAttached", "", "()Z", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutCoordinates.kt */
public interface LayoutCoordinates {
    int get(AlignmentLine alignmentLine);

    LayoutCoordinates getParentCoordinates();

    LayoutCoordinates getParentLayoutCoordinates();

    Set<AlignmentLine> getProvidedAlignmentLines();

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long m5318getSizeYbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z);

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    long m5319localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j);

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    long m5320localToRootMKHz9U(long j);

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    long m5321localToWindowMKHz9U(long j);

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    void m5322transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr);

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    long m5323windowToLocalMKHz9U(long j);

    /* renamed from: androidx.compose.ui.layout.LayoutCoordinates$-CC  reason: invalid class name */
    /* compiled from: LayoutCoordinates.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Rect localBoundingBoxOf$default(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
        }

        /* renamed from: $default$transformFrom-EL8BTi8  reason: not valid java name */
        public static void m5324$default$transformFromEL8BTi8(LayoutCoordinates _this, LayoutCoordinates layoutCoordinates, float[] fArr) {
            throw new UnsupportedOperationException("transformFrom is not implemented on this LayoutCoordinates");
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutCoordinates.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
        public static void m5326transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, float[] fArr) {
            CC.m5324$default$transformFromEL8BTi8(layoutCoordinates, layoutCoordinates2, fArr);
        }
    }
}
