package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\n\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutCoordinates.kt */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.m5320localToRootMKHz9U(Offset.Companion.m3578getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.m5321localToWindowMKHz9U(Offset.Companion.m3578getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.CC.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, (Object) null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float r2 = (float) IntSize.m6790getWidthimpl(findRootCoordinates.m5318getSizeYbymL2g());
        float r3 = (float) IntSize.m6789getHeightimpl(findRootCoordinates.m5318getSizeYbymL2g());
        float coerceIn = RangesKt.coerceIn(boundsInRoot.getLeft(), 0.0f, r2);
        float coerceIn2 = RangesKt.coerceIn(boundsInRoot.getTop(), 0.0f, r3);
        float coerceIn3 = RangesKt.coerceIn(boundsInRoot.getRight(), 0.0f, r2);
        float coerceIn4 = RangesKt.coerceIn(boundsInRoot.getBottom(), 0.0f, r3);
        if (coerceIn == coerceIn3 || coerceIn2 == coerceIn4) {
            return Rect.Companion.getZero();
        }
        long r7 = findRootCoordinates.m5321localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn2));
        long r5 = findRootCoordinates.m5321localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn2));
        long r22 = findRootCoordinates.m5321localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn4));
        long r0 = findRootCoordinates.m5321localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn4));
        return new Rect(ComparisonsKt.minOf(Offset.m3562getXimpl(r7), Offset.m3562getXimpl(r5), Offset.m3562getXimpl(r0), Offset.m3562getXimpl(r22)), ComparisonsKt.minOf(Offset.m3563getYimpl(r7), Offset.m3563getYimpl(r5), Offset.m3563getYimpl(r0), Offset.m3563getYimpl(r22)), ComparisonsKt.maxOf(Offset.m3562getXimpl(r7), Offset.m3562getXimpl(r5), Offset.m3562getXimpl(r0), Offset.m3562getXimpl(r22)), ComparisonsKt.maxOf(Offset.m3563getYimpl(r7), Offset.m3563getYimpl(r5), Offset.m3563getYimpl(r0), Offset.m3563getYimpl(r22)));
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.m5319localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m3578getZeroF1C5BW0()) : Offset.Companion.m3578getZeroF1C5BW0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.compose.ui.layout.LayoutCoordinates.CC.localBoundingBoxOf$default(r0, r4, false, 2, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.geometry.Rect boundsInParent(androidx.compose.ui.layout.LayoutCoordinates r4) {
        /*
            androidx.compose.ui.layout.LayoutCoordinates r0 = r4.getParentLayoutCoordinates()
            if (r0 == 0) goto L_0x000f
            r1 = 2
            r2 = 0
            r3 = 0
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.layout.LayoutCoordinates.CC.localBoundingBoxOf$default(r0, r4, r3, r1, r2)
            if (r0 != 0) goto L_0x0027
        L_0x000f:
            androidx.compose.ui.geometry.Rect r0 = new androidx.compose.ui.geometry.Rect
            long r1 = r4.m5318getSizeYbymL2g()
            int r1 = androidx.compose.ui.unit.IntSize.m6790getWidthimpl(r1)
            float r1 = (float) r1
            long r2 = r4.m5318getSizeYbymL2g()
            int r4 = androidx.compose.ui.unit.IntSize.m6789getHeightimpl(r2)
            float r4 = (float) r4
            r2 = 0
            r0.<init>(r2, r2, r1, r4)
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(androidx.compose.ui.layout.LayoutCoordinates):androidx.compose.ui.geometry.Rect");
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy$ui_release;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        }
    }
}
