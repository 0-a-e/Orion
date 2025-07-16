package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020'H\u0002J\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0&J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u00020+J\u0006\u00102\u001a\u00020+J\r\u00103\u001a\u00020+H\u0000¢\u0006\u0002\b4J\u001e\u00105\u001a\u000206*\u00020'2\u0006\u00107\u001a\u000206H$ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0014\u0010:\u001a\u00020\b*\u00020'2\u0006\u0010,\u001a\u00020\u0007H$R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001a\u0010\u001f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R\u001a\u0010\"\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0&*\u00020'X¤\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)\u0001\u0002;<\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Landroidx/compose/ui/node/AlignmentLines;", "", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/AlignmentLinesOwner;)V", "alignmentLineMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "dirty", "", "getDirty$ui_release", "()Z", "setDirty$ui_release", "(Z)V", "previousUsedDuringParentLayout", "getPreviousUsedDuringParentLayout$ui_release", "setPreviousUsedDuringParentLayout$ui_release", "queried", "getQueried$ui_release", "queryOwner", "required", "getRequired$ui_release", "usedByModifierLayout", "getUsedByModifierLayout$ui_release", "setUsedByModifierLayout$ui_release", "usedByModifierMeasurement", "getUsedByModifierMeasurement$ui_release", "setUsedByModifierMeasurement$ui_release", "usedDuringParentLayout", "getUsedDuringParentLayout$ui_release", "setUsedDuringParentLayout$ui_release", "usedDuringParentMeasurement", "getUsedDuringParentMeasurement$ui_release", "setUsedDuringParentMeasurement$ui_release", "alignmentLinesMap", "", "Landroidx/compose/ui/node/NodeCoordinator;", "getAlignmentLinesMap", "(Landroidx/compose/ui/node/NodeCoordinator;)Ljava/util/Map;", "addAlignmentLine", "", "alignmentLine", "initialPosition", "initialCoordinator", "getLastCalculation", "onAlignmentsChanged", "recalculate", "recalculateQueryOwner", "reset", "reset$ui_release", "calculatePositionInParent", "Landroidx/compose/ui/geometry/Offset;", "position", "calculatePositionInParent-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "getPositionFor", "Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "Landroidx/compose/ui/node/LookaheadAlignmentLines;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeAlignmentLines.kt */
public abstract class AlignmentLines {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Map<AlignmentLine, Integer> alignmentLineMap;
    private final AlignmentLinesOwner alignmentLinesOwner;
    private boolean dirty;
    private boolean previousUsedDuringParentLayout;
    private AlignmentLinesOwner queryOwner;
    private boolean usedByModifierLayout;
    private boolean usedByModifierMeasurement;
    private boolean usedDuringParentLayout;
    private boolean usedDuringParentMeasurement;

    public /* synthetic */ AlignmentLines(AlignmentLinesOwner alignmentLinesOwner2, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLinesOwner2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: calculatePositionInParent-R5De75A  reason: not valid java name */
    public abstract long m5449calculatePositionInParentR5De75A(NodeCoordinator nodeCoordinator, long j);

    /* access modifiers changed from: protected */
    public abstract Map<AlignmentLine, Integer> getAlignmentLinesMap(NodeCoordinator nodeCoordinator);

    /* access modifiers changed from: protected */
    public abstract int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine);

    private AlignmentLines(AlignmentLinesOwner alignmentLinesOwner2) {
        this.alignmentLinesOwner = alignmentLinesOwner2;
        this.dirty = true;
        this.alignmentLineMap = new HashMap();
    }

    public final AlignmentLinesOwner getAlignmentLinesOwner() {
        return this.alignmentLinesOwner;
    }

    public final boolean getDirty$ui_release() {
        return this.dirty;
    }

    public final void setDirty$ui_release(boolean z) {
        this.dirty = z;
    }

    public final boolean getUsedDuringParentMeasurement$ui_release() {
        return this.usedDuringParentMeasurement;
    }

    public final void setUsedDuringParentMeasurement$ui_release(boolean z) {
        this.usedDuringParentMeasurement = z;
    }

    public final boolean getUsedDuringParentLayout$ui_release() {
        return this.usedDuringParentLayout;
    }

    public final void setUsedDuringParentLayout$ui_release(boolean z) {
        this.usedDuringParentLayout = z;
    }

    public final boolean getPreviousUsedDuringParentLayout$ui_release() {
        return this.previousUsedDuringParentLayout;
    }

    public final void setPreviousUsedDuringParentLayout$ui_release(boolean z) {
        this.previousUsedDuringParentLayout = z;
    }

    public final boolean getUsedByModifierMeasurement$ui_release() {
        return this.usedByModifierMeasurement;
    }

    public final void setUsedByModifierMeasurement$ui_release(boolean z) {
        this.usedByModifierMeasurement = z;
    }

    public final boolean getUsedByModifierLayout$ui_release() {
        return this.usedByModifierLayout;
    }

    public final void setUsedByModifierLayout$ui_release(boolean z) {
        this.usedByModifierLayout = z;
    }

    public final boolean getQueried$ui_release() {
        return this.usedDuringParentMeasurement || this.previousUsedDuringParentLayout || this.usedByModifierMeasurement || this.usedByModifierLayout;
    }

    public final boolean getRequired$ui_release() {
        recalculateQueryOwner();
        return this.queryOwner != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        r0 = r0.getAlignmentLines();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void recalculateQueryOwner() {
        /*
            r2 = this;
            boolean r0 = r2.getQueried$ui_release()
            if (r0 == 0) goto L_0x0009
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r2.alignmentLinesOwner
            goto L_0x0053
        L_0x0009:
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r2.alignmentLinesOwner
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r0.getParentAlignmentLinesOwner()
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            androidx.compose.ui.node.AlignmentLines r0 = r0.getAlignmentLines()
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r0.queryOwner
            if (r0 == 0) goto L_0x0025
            androidx.compose.ui.node.AlignmentLines r1 = r0.getAlignmentLines()
            boolean r1 = r1.getQueried$ui_release()
            if (r1 == 0) goto L_0x0025
            goto L_0x0053
        L_0x0025:
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r2.queryOwner
            if (r0 == 0) goto L_0x0055
            androidx.compose.ui.node.AlignmentLines r1 = r0.getAlignmentLines()
            boolean r1 = r1.getQueried$ui_release()
            if (r1 == 0) goto L_0x0034
            goto L_0x0055
        L_0x0034:
            androidx.compose.ui.node.AlignmentLinesOwner r1 = r0.getParentAlignmentLinesOwner()
            if (r1 == 0) goto L_0x0043
            androidx.compose.ui.node.AlignmentLines r1 = r1.getAlignmentLines()
            if (r1 == 0) goto L_0x0043
            r1.recalculateQueryOwner()
        L_0x0043:
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r0.getParentAlignmentLinesOwner()
            if (r0 == 0) goto L_0x0052
            androidx.compose.ui.node.AlignmentLines r0 = r0.getAlignmentLines()
            if (r0 == 0) goto L_0x0052
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r0.queryOwner
            goto L_0x0053
        L_0x0052:
            r0 = 0
        L_0x0053:
            r2.queryOwner = r0
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.AlignmentLines.recalculateQueryOwner():void");
    }

    public final Map<AlignmentLine, Integer> getLastCalculation() {
        return this.alignmentLineMap;
    }

    /* access modifiers changed from: private */
    public final void addAlignmentLine(AlignmentLine alignmentLine, int i, NodeCoordinator nodeCoordinator) {
        int i2;
        float f = (float) i;
        long Offset = OffsetKt.Offset(f, f);
        while (true) {
            Offset = m5449calculatePositionInParentR5De75A(nodeCoordinator, Offset);
            nodeCoordinator = nodeCoordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(nodeCoordinator);
            if (Intrinsics.areEqual((Object) nodeCoordinator, (Object) this.alignmentLinesOwner.getInnerCoordinator())) {
                break;
            } else if (getAlignmentLinesMap(nodeCoordinator).containsKey(alignmentLine)) {
                float positionFor = (float) getPositionFor(nodeCoordinator, alignmentLine);
                Offset = OffsetKt.Offset(positionFor, positionFor);
            }
        }
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            i2 = MathKt.roundToInt(Offset.m3563getYimpl(Offset));
        } else {
            i2 = MathKt.roundToInt(Offset.m3562getXimpl(Offset));
        }
        Map<AlignmentLine, Integer> map = this.alignmentLineMap;
        if (map.containsKey(alignmentLine)) {
            i2 = AlignmentLineKt.merge(alignmentLine, ((Number) MapsKt.getValue(this.alignmentLineMap, alignmentLine)).intValue(), i2);
        }
        map.put(alignmentLine, Integer.valueOf(i2));
    }

    public final void recalculate() {
        this.alignmentLineMap.clear();
        this.alignmentLinesOwner.forEachChildAlignmentLinesOwner(new AlignmentLines$recalculate$1(this));
        this.alignmentLineMap.putAll(getAlignmentLinesMap(this.alignmentLinesOwner.getInnerCoordinator()));
        this.dirty = false;
    }

    public final void reset$ui_release() {
        this.dirty = true;
        this.usedDuringParentMeasurement = false;
        this.previousUsedDuringParentLayout = false;
        this.usedDuringParentLayout = false;
        this.usedByModifierMeasurement = false;
        this.usedByModifierLayout = false;
        this.queryOwner = null;
    }

    public final void onAlignmentsChanged() {
        this.dirty = true;
        AlignmentLinesOwner parentAlignmentLinesOwner = this.alignmentLinesOwner.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner != null) {
            if (this.usedDuringParentMeasurement) {
                parentAlignmentLinesOwner.requestMeasure();
            } else if (this.previousUsedDuringParentLayout || this.usedDuringParentLayout) {
                parentAlignmentLinesOwner.requestLayout();
            }
            if (this.usedByModifierMeasurement) {
                this.alignmentLinesOwner.requestMeasure();
            }
            if (this.usedByModifierLayout) {
                this.alignmentLinesOwner.requestLayout();
            }
            parentAlignmentLinesOwner.getAlignmentLines().onAlignmentsChanged();
        }
    }
}
