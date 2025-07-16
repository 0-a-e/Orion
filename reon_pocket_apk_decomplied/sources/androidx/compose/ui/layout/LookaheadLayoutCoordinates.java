package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\nH\u0016J\"\u0010&\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001a\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001a\u0010.\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b/\u0010-J\"\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001a\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b8\u0010-R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8BX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "()J", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayoutCoordinates.kt */
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public static final int $stable = 0;
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate2) {
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m5359getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate2 = this.lookaheadDelegate;
        return IntSizeKt.IntSize(lookaheadDelegate2.getWidth(), lookaheadDelegate2.getHeight());
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate2;
        if (isAttached()) {
            NodeCoordinator wrappedBy$ui_release = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy$ui_release();
            if (wrappedBy$ui_release == null || (lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
                return null;
            }
            return lookaheadDelegate2.getCoordinates();
        }
        throw new IllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates.toString());
    }

    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate2;
        if (isAttached()) {
            NodeCoordinator wrappedBy$ui_release = getCoordinator().getWrappedBy$ui_release();
            if (wrappedBy$ui_release == null || (lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
                return null;
            }
            return lookaheadDelegate2.getCoordinates();
        }
        throw new IllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates.toString());
    }

    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    /* renamed from: getLookaheadOffset-F1C5BW0  reason: not valid java name */
    private final long m5358getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m3566minusMKHz9U(m5360localPositionOfR5De75A(rootLookaheadDelegate.getCoordinates(), Offset.Companion.m3578getZeroF1C5BW0()), getCoordinator().m5626localPositionOfR5De75A(rootLookaheadDelegate.getCoordinator(), Offset.Companion.m3578getZeroF1C5BW0()));
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m5364windowToLocalMKHz9U(long j) {
        return Offset.m3567plusMKHz9U(getCoordinator().m5636windowToLocalMKHz9U(j), m5358getLookaheadOffsetF1C5BW0());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m5362localToWindowMKHz9U(long j) {
        return getCoordinator().m5628localToWindowMKHz9U(Offset.m3567plusMKHz9U(j, m5358getLookaheadOffsetF1C5BW0()));
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m5361localToRootMKHz9U(long j) {
        return getCoordinator().m5627localToRootMKHz9U(Offset.m3567plusMKHz9U(j, m5358getLookaheadOffsetF1C5BW0()));
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m5360localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadDelegate lookaheadDelegate2 = ((LookaheadLayoutCoordinates) layoutCoordinates).lookaheadDelegate;
            lookaheadDelegate2.getCoordinator().onCoordinatesUsed$ui_release();
            LookaheadDelegate lookaheadDelegate3 = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate2.getCoordinator()).getLookaheadDelegate();
            if (lookaheadDelegate3 != null) {
                long r1 = lookaheadDelegate2.m5586positionInBjo55l4$ui_release(lookaheadDelegate3);
                long IntOffset = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3562getXimpl(j)), MathKt.roundToInt(Offset.m3563getYimpl(j)));
                long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r1) + IntOffset.m6748getXimpl(IntOffset), IntOffset.m6749getYimpl(r1) + IntOffset.m6749getYimpl(IntOffset));
                long r0 = this.lookaheadDelegate.m5586positionInBjo55l4$ui_release(lookaheadDelegate3);
                long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset2) - IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(IntOffset2) - IntOffset.m6749getYimpl(r0));
                return OffsetKt.Offset((float) IntOffset.m6748getXimpl(IntOffset3), (float) IntOffset.m6749getYimpl(IntOffset3));
            }
            LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate2);
            long r12 = lookaheadDelegate2.m5586positionInBjo55l4$ui_release(rootLookaheadDelegate);
            long r3 = rootLookaheadDelegate.m5582getPositionnOccac();
            long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r12) + IntOffset.m6748getXimpl(r3), IntOffset.m6749getYimpl(r12) + IntOffset.m6749getYimpl(r3));
            long IntOffset5 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3562getXimpl(j)), MathKt.roundToInt(Offset.m3563getYimpl(j)));
            long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset4) + IntOffset.m6748getXimpl(IntOffset5), IntOffset.m6749getYimpl(IntOffset4) + IntOffset.m6749getYimpl(IntOffset5));
            LookaheadDelegate lookaheadDelegate4 = this.lookaheadDelegate;
            long r13 = lookaheadDelegate4.m5586positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate4));
            long r32 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate4).m5582getPositionnOccac();
            long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r13) + IntOffset.m6748getXimpl(r32), IntOffset.m6749getYimpl(r13) + IntOffset.m6749getYimpl(r32));
            long IntOffset8 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset6) - IntOffset.m6748getXimpl(IntOffset7), IntOffset.m6749getYimpl(IntOffset6) - IntOffset.m6749getYimpl(IntOffset7));
            NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            NodeCoordinator wrappedBy$ui_release2 = rootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release2);
            return wrappedBy$ui_release.m5626localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset((float) IntOffset.m6748getXimpl(IntOffset8), (float) IntOffset.m6749getYimpl(IntOffset8)));
        }
        LookaheadDelegate rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m3567plusMKHz9U(m5360localPositionOfR5De75A(rootLookaheadDelegate2.getLookaheadLayoutCoordinates(), j), rootLookaheadDelegate2.getCoordinator().getCoordinates().m5319localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m3578getZeroF1C5BW0()));
    }

    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        return getCoordinator().localBoundingBoxOf(layoutCoordinates, z);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m5363transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        getCoordinator().m5634transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    public int get(AlignmentLine alignmentLine) {
        return this.lookaheadDelegate.get(alignmentLine);
    }
}
