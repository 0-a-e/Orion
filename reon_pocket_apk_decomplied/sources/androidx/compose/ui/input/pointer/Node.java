package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0017\u0010&\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0(H\bJ.\u0010)\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u001a\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020\rH\u0002J\u0006\u0010-\u001a\u00020\"J\b\u0010.\u001a\u00020/H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "vec", "Landroidx/compose/runtime/collection/MutableVector;", "", "getVec", "()Landroidx/compose/runtime/collection/MutableVector;", "wasIn", "buildCache", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private boolean hasExited = true;
    private boolean isIn = true;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private final MutableVector<Long> vec = new MutableVector<>(new Long[16], 0);
    private boolean wasIn;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    public final MutableVector<Long> getVec() {
        return this.vec;
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean buildCache(androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r36, androidx.compose.ui.layout.LayoutCoordinates r37, androidx.compose.ui.input.pointer.InternalPointerEvent r38, boolean r39) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r37
            r3 = r38
            boolean r4 = super.buildCache(r36, r37, r38, r39)
            androidx.compose.ui.Modifier$Node r5 = r0.modifierNode
            boolean r5 = r5.isAttached()
            r6 = 1
            if (r5 != 0) goto L_0x0016
            return r6
        L_0x0016:
            androidx.compose.ui.Modifier$Node r5 = r0.modifierNode
            r7 = 16
            int r8 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r7)
            r10 = 0
        L_0x001f:
            r11 = 0
            if (r5 == 0) goto L_0x0074
            boolean r12 = r5 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r12 == 0) goto L_0x002f
            androidx.compose.ui.node.PointerInputModifierNode r5 = (androidx.compose.ui.node.PointerInputModifierNode) r5
            androidx.compose.ui.layout.LayoutCoordinates r5 = androidx.compose.ui.node.PointerInputModifierNodeKt.getLayoutCoordinates(r5)
            r0.coordinates = r5
            goto L_0x006f
        L_0x002f:
            int r12 = r5.getKindSet$ui_release()
            r12 = r12 & r8
            if (r12 == 0) goto L_0x006f
            boolean r12 = r5 instanceof androidx.compose.ui.node.DelegatingNode
            if (r12 == 0) goto L_0x006f
            r12 = r5
            androidx.compose.ui.node.DelegatingNode r12 = (androidx.compose.ui.node.DelegatingNode) r12
            androidx.compose.ui.Modifier$Node r12 = r12.getDelegate$ui_release()
            r13 = r11
        L_0x0042:
            if (r12 == 0) goto L_0x006c
            int r14 = r12.getKindSet$ui_release()
            r14 = r14 & r8
            if (r14 == 0) goto L_0x0067
            int r13 = r13 + 1
            if (r13 != r6) goto L_0x0051
            r5 = r12
            goto L_0x0067
        L_0x0051:
            if (r10 != 0) goto L_0x005a
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r14 = new androidx.compose.ui.Modifier.Node[r7]
            r10.<init>(r14, r11)
        L_0x005a:
            if (r5 == 0) goto L_0x0062
            if (r10 == 0) goto L_0x0061
            r10.add(r5)
        L_0x0061:
            r5 = 0
        L_0x0062:
            if (r10 == 0) goto L_0x0067
            r10.add(r12)
        L_0x0067:
            androidx.compose.ui.Modifier$Node r12 = r12.getChild$ui_release()
            goto L_0x0042
        L_0x006c:
            if (r13 != r6) goto L_0x006f
            goto L_0x001f
        L_0x006f:
            androidx.compose.ui.Modifier$Node r5 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x001f
        L_0x0074:
            int r5 = r36.size()
            r7 = r11
        L_0x0079:
            if (r7 >= r5) goto L_0x0126
            long r12 = r1.keyAt(r7)
            java.lang.Object r8 = r1.valueAt(r7)
            r14 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            androidx.compose.ui.input.pointer.util.PointerIdArray r8 = r0.pointerIds
            boolean r8 = r8.contains(r12)
            if (r8 == 0) goto L_0x0118
            java.util.ArrayList r8 = new java.util.ArrayList
            java.util.List r10 = r14.getHistorical()
            int r10 = r10.size()
            r8.<init>(r10)
            java.util.List r10 = r14.getHistorical()
            int r15 = r10.size()
            r9 = r11
        L_0x00a4:
            if (r9 >= r15) goto L_0x00da
            java.lang.Object r16 = r10.get(r9)
            androidx.compose.ui.input.pointer.HistoricalChange r16 = (androidx.compose.ui.input.pointer.HistoricalChange) r16
            androidx.compose.ui.input.pointer.HistoricalChange r11 = new androidx.compose.ui.input.pointer.HistoricalChange
            long r18 = r16.getUptimeMillis()
            androidx.compose.ui.layout.LayoutCoordinates r6 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r33 = r4
            r34 = r5
            long r4 = r16.m5039getPositionF1C5BW0()
            long r20 = r6.m5319localPositionOfR5De75A(r2, r4)
            long r22 = r16.m5038getOriginalEventPositionF1C5BW0$ui_release()
            r24 = 0
            r17 = r11
            r17.<init>(r18, r20, r22, r24)
            r8.add(r11)
            int r9 = r9 + 1
            r4 = r33
            r5 = r34
            r6 = 1
            r11 = 0
            goto L_0x00a4
        L_0x00da:
            r33 = r4
            r34 = r5
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r0.relevantChanges
            androidx.compose.ui.layout.LayoutCoordinates r5 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            long r9 = r14.m5114getPreviousPositionF1C5BW0()
            long r24 = r5.m5319localPositionOfR5De75A(r2, r9)
            androidx.compose.ui.layout.LayoutCoordinates r5 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            long r9 = r14.m5113getPositionF1C5BW0()
            long r19 = r5.m5319localPositionOfR5De75A(r2, r9)
            r28 = r8
            java.util.List r28 = (java.util.List) r28
            r31 = 731(0x2db, float:1.024E-42)
            r32 = 0
            r15 = 0
            r17 = 0
            r21 = 0
            r22 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r5 = androidx.compose.ui.input.pointer.PointerInputChange.m5103copyOHpmEuE$default(r14, r15, r17, r19, r21, r22, r24, r26, r27, r28, r29, r31, r32)
            r4.put(r12, r5)
            goto L_0x011c
        L_0x0118:
            r33 = r4
            r34 = r5
        L_0x011c:
            int r7 = r7 + 1
            r4 = r33
            r5 = r34
            r6 = 1
            r11 = 0
            goto L_0x0079
        L_0x0126:
            r33 = r4
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r2 = r0.relevantChanges
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x013e
            androidx.compose.ui.input.pointer.util.PointerIdArray r1 = r0.pointerIds
            r1.clear()
            androidx.compose.runtime.collection.MutableVector r1 = r35.getChildren()
            r1.clear()
            r2 = 1
            return r2
        L_0x013e:
            r2 = 1
            androidx.compose.ui.input.pointer.util.PointerIdArray r4 = r0.pointerIds
            int r4 = r4.getSize()
            int r4 = r4 - r2
        L_0x0146:
            r2 = -1
            if (r2 >= r4) goto L_0x015d
            androidx.compose.ui.input.pointer.util.PointerIdArray r2 = r0.pointerIds
            long r5 = r2.m5241get_I2yYro(r4)
            boolean r2 = r1.containsKey(r5)
            if (r2 != 0) goto L_0x015a
            androidx.compose.ui.input.pointer.util.PointerIdArray r2 = r0.pointerIds
            r2.removeAt(r4)
        L_0x015a:
            int r4 = r4 + -1
            goto L_0x0146
        L_0x015d:
            java.util.ArrayList r1 = new java.util.ArrayList
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r2 = r0.relevantChanges
            int r2 = r2.size()
            r1.<init>(r2)
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r2 = r0.relevantChanges
            int r2 = r2.size()
            r4 = 0
        L_0x016f:
            if (r4 >= r2) goto L_0x017d
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r5 = r0.relevantChanges
            java.lang.Object r5 = r5.valueAt(r4)
            r1.add(r5)
            int r4 = r4 + 1
            goto L_0x016f
        L_0x017d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = new androidx.compose.ui.input.pointer.PointerEvent
            java.util.List r1 = (java.util.List) r1
            r2.<init>(r1, r3)
            java.util.List r1 = r2.getChanges()
            int r4 = r1.size()
            r5 = 0
        L_0x018d:
            if (r5 >= r4) goto L_0x01a5
            java.lang.Object r6 = r1.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r7 = r7.m5111getIdJ3iCeTQ()
            boolean r7 = r3.m5041issuesEnterExitEvent0FcD4WY(r7)
            if (r7 == 0) goto L_0x01a2
            r9 = r6
            goto L_0x01a6
        L_0x01a2:
            int r5 = r5 + 1
            goto L_0x018d
        L_0x01a5:
            r9 = 0
        L_0x01a6:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 == 0) goto L_0x0265
            if (r39 != 0) goto L_0x01b0
            r1 = 0
            r0.isIn = r1
            goto L_0x01d3
        L_0x01b0:
            r1 = 0
            boolean r3 = r0.isIn
            if (r3 != 0) goto L_0x01d3
            boolean r3 = r9.getPressed()
            if (r3 != 0) goto L_0x01c1
            boolean r3 = r9.getPreviousPressed()
            if (r3 == 0) goto L_0x01d3
        L_0x01c1:
            androidx.compose.ui.layout.LayoutCoordinates r3 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            long r3 = r3.m5318getSizeYbymL2g()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.m5056isOutOfBoundsO0kMr_c(r9, r3)
            r4 = 1
            r3 = r3 ^ r4
            r0.isIn = r3
            goto L_0x01d4
        L_0x01d3:
            r4 = 1
        L_0x01d4:
            boolean r3 = r0.isIn
            boolean r5 = r0.wasIn
            if (r3 == r5) goto L_0x021f
            int r3 = r2.m5054getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m5067getMove7fucELk()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r3, r5)
            if (r3 != 0) goto L_0x020a
            int r3 = r2.m5054getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m5065getEnter7fucELk()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r3, r5)
            if (r3 != 0) goto L_0x020a
            int r3 = r2.m5054getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m5066getExit7fucELk()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r3, r5)
            if (r3 == 0) goto L_0x021f
        L_0x020a:
            boolean r3 = r0.isIn
            if (r3 == 0) goto L_0x0215
            androidx.compose.ui.input.pointer.PointerEventType$Companion r3 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r3 = r3.m5065getEnter7fucELk()
            goto L_0x021b
        L_0x0215:
            androidx.compose.ui.input.pointer.PointerEventType$Companion r3 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r3 = r3.m5066getExit7fucELk()
        L_0x021b:
            r2.m5055setTypeEhbLWgg$ui_release(r3)
            goto L_0x0267
        L_0x021f:
            int r3 = r2.m5054getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m5065getEnter7fucELk()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r3, r5)
            if (r3 == 0) goto L_0x0241
            boolean r3 = r0.wasIn
            if (r3 == 0) goto L_0x0241
            boolean r3 = r0.hasExited
            if (r3 != 0) goto L_0x0241
            androidx.compose.ui.input.pointer.PointerEventType$Companion r3 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r3 = r3.m5067getMove7fucELk()
            r2.m5055setTypeEhbLWgg$ui_release(r3)
            goto L_0x0267
        L_0x0241:
            int r3 = r2.m5054getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m5066getExit7fucELk()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r3, r5)
            if (r3 == 0) goto L_0x0267
            boolean r3 = r0.isIn
            if (r3 == 0) goto L_0x0267
            boolean r3 = r9.getPressed()
            if (r3 == 0) goto L_0x0267
            androidx.compose.ui.input.pointer.PointerEventType$Companion r3 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r3 = r3.m5067getMove7fucELk()
            r2.m5055setTypeEhbLWgg$ui_release(r3)
            goto L_0x0267
        L_0x0265:
            r1 = 0
            r4 = 1
        L_0x0267:
            if (r33 != 0) goto L_0x0284
            int r3 = r2.m5054getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m5067getMove7fucELk()
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r3, r5)
            if (r3 == 0) goto L_0x0284
            androidx.compose.ui.input.pointer.PointerEvent r3 = r0.pointerEvent
            boolean r3 = r0.hasPositionChanged(r3, r2)
            if (r3 == 0) goto L_0x0282
            goto L_0x0284
        L_0x0282:
            r6 = r1
            goto L_0x0285
        L_0x0284:
            r6 = r4
        L_0x0285:
            r0.pointerEvent = r2
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(androidx.collection.LongSparseArray, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent2, PointerEvent pointerEvent3) {
        if (pointerEvent2 == null || pointerEvent2.getChanges().size() != pointerEvent3.getChanges().size()) {
            return true;
        }
        int size = pointerEvent3.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m3559equalsimpl0(pointerEvent2.getChanges().get(i).m5113getPositionF1C5BW0(), pointerEvent3.getChanges().get(i).m5113getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> function0) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.isAttached()) {
            return false;
        }
        function0.invoke();
        return true;
    }

    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Object[] content = children.getContent();
            int i = 0;
            do {
                ((Node) content[i]).dispatchCancel();
                i++;
            } while (i < size);
        }
        Modifier.Node node = this.modifierNode;
        int r4 = NodeKind.m5647constructorimpl(16);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) node).onCancelPointerInput();
            } else if ((node.getKindSet$ui_release() & r4) != 0 && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                    if ((delegate$ui_release.getKindSet$ui_release() & r4) != 0) {
                        i2++;
                        if (i2 == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent2 = this.pointerEvent;
        if (pointerEvent2 != null) {
            this.wasIn = this.isIn;
            List<PointerInputChange> changes = pointerEvent2.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = changes.get(i);
                if (!pointerInputChange.getPressed() && (!internalPointerEvent.m5041issuesEnterExitEvent0FcD4WY(pointerInputChange.m5111getIdJ3iCeTQ()) || !this.isIn)) {
                    this.pointerIds.m5242remove0FcD4WY(pointerInputChange.m5111getIdJ3iCeTQ());
                }
            }
            this.isIn = false;
            this.hasExited = PointerEventType.m5061equalsimpl0(pointerEvent2.m5054getType7fucELk(), PointerEventType.Companion.m5066getExit7fucELk());
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchMainEventPass(androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r12, androidx.compose.ui.layout.LayoutCoordinates r13, androidx.compose.ui.input.pointer.InternalPointerEvent r14, boolean r15) {
        /*
            r11 = this;
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r12 = r11.relevantChanges
            boolean r12 = r12.isEmpty()
            r13 = 0
            if (r12 == 0) goto L_0x000b
            goto L_0x010c
        L_0x000b:
            androidx.compose.ui.Modifier$Node r12 = r11.modifierNode
            boolean r12 = r12.isAttached()
            if (r12 != 0) goto L_0x0015
            goto L_0x010c
        L_0x0015:
            androidx.compose.ui.input.pointer.PointerEvent r12 = r11.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            androidx.compose.ui.layout.LayoutCoordinates r0 = r11.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            long r0 = r0.m5318getSizeYbymL2g()
            androidx.compose.ui.Modifier$Node r2 = r11.modifierNode
            r3 = 16
            int r4 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r3)
            r5 = 0
            r6 = r5
        L_0x002d:
            r7 = 1
            if (r2 == 0) goto L_0x0081
            boolean r8 = r2 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r8 == 0) goto L_0x003c
            androidx.compose.ui.node.PointerInputModifierNode r2 = (androidx.compose.ui.node.PointerInputModifierNode) r2
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r2.m5707onPointerEventH0pRuoY(r12, r7, r0)
            goto L_0x007c
        L_0x003c:
            int r8 = r2.getKindSet$ui_release()
            r8 = r8 & r4
            if (r8 == 0) goto L_0x007c
            boolean r8 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x007c
            r8 = r2
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r13
        L_0x004f:
            if (r8 == 0) goto L_0x0079
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r4
            if (r10 == 0) goto L_0x0074
            int r9 = r9 + 1
            if (r9 != r7) goto L_0x005e
            r2 = r8
            goto L_0x0074
        L_0x005e:
            if (r6 != 0) goto L_0x0067
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r3]
            r6.<init>(r10, r13)
        L_0x0067:
            if (r2 == 0) goto L_0x006f
            if (r6 == 0) goto L_0x006e
            r6.add(r2)
        L_0x006e:
            r2 = r5
        L_0x006f:
            if (r6 == 0) goto L_0x0074
            r6.add(r8)
        L_0x0074:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x004f
        L_0x0079:
            if (r9 != r7) goto L_0x007c
            goto L_0x002d
        L_0x007c:
            androidx.compose.ui.Modifier$Node r2 = androidx.compose.ui.node.DelegatableNodeKt.pop(r6)
            goto L_0x002d
        L_0x0081:
            androidx.compose.ui.Modifier$Node r2 = r11.modifierNode
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x00a9
            androidx.compose.runtime.collection.MutableVector r2 = r11.getChildren()
            int r4 = r2.getSize()
            if (r4 <= 0) goto L_0x00a9
            java.lang.Object[] r2 = r2.getContent()
            r6 = r13
        L_0x0098:
            r8 = r2[r6]
            androidx.compose.ui.input.pointer.Node r8 = (androidx.compose.ui.input.pointer.Node) r8
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r9 = r11.relevantChanges
            androidx.compose.ui.layout.LayoutCoordinates r10 = r11.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r8.dispatchMainEventPass(r9, r10, r14, r15)
            int r6 = r6 + r7
            if (r6 < r4) goto L_0x0098
        L_0x00a9:
            androidx.compose.ui.Modifier$Node r14 = r11.modifierNode
            boolean r14 = r14.isAttached()
            if (r14 == 0) goto L_0x010b
            androidx.compose.ui.Modifier$Node r14 = r11.modifierNode
            int r15 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r3)
            r2 = r5
        L_0x00b8:
            if (r14 == 0) goto L_0x010b
            boolean r4 = r14 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r4 == 0) goto L_0x00c6
            androidx.compose.ui.node.PointerInputModifierNode r14 = (androidx.compose.ui.node.PointerInputModifierNode) r14
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r14.m5707onPointerEventH0pRuoY(r12, r4, r0)
            goto L_0x0106
        L_0x00c6:
            int r4 = r14.getKindSet$ui_release()
            r4 = r4 & r15
            if (r4 == 0) goto L_0x0106
            boolean r4 = r14 instanceof androidx.compose.ui.node.DelegatingNode
            if (r4 == 0) goto L_0x0106
            r4 = r14
            androidx.compose.ui.node.DelegatingNode r4 = (androidx.compose.ui.node.DelegatingNode) r4
            androidx.compose.ui.Modifier$Node r4 = r4.getDelegate$ui_release()
            r6 = r13
        L_0x00d9:
            if (r4 == 0) goto L_0x0103
            int r8 = r4.getKindSet$ui_release()
            r8 = r8 & r15
            if (r8 == 0) goto L_0x00fe
            int r6 = r6 + 1
            if (r6 != r7) goto L_0x00e8
            r14 = r4
            goto L_0x00fe
        L_0x00e8:
            if (r2 != 0) goto L_0x00f1
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r8, r13)
        L_0x00f1:
            if (r14 == 0) goto L_0x00f9
            if (r2 == 0) goto L_0x00f8
            r2.add(r14)
        L_0x00f8:
            r14 = r5
        L_0x00f9:
            if (r2 == 0) goto L_0x00fe
            r2.add(r4)
        L_0x00fe:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L_0x00d9
        L_0x0103:
            if (r6 != r7) goto L_0x0106
            goto L_0x00b8
        L_0x0106:
            androidx.compose.ui.Modifier$Node r14 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x00b8
        L_0x010b:
            r13 = r7
        L_0x010c:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(androidx.collection.LongSparseArray, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent r14) {
        /*
            r13 = this;
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r0 = r13.relevantChanges
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x000b
            goto L_0x00a2
        L_0x000b:
            androidx.compose.ui.Modifier$Node r0 = r13.modifierNode
            boolean r0 = r0.isAttached()
            if (r0 != 0) goto L_0x0015
            goto L_0x00a2
        L_0x0015:
            androidx.compose.ui.input.pointer.PointerEvent r0 = r13.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.layout.LayoutCoordinates r2 = r13.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r2 = r2.m5318getSizeYbymL2g()
            androidx.compose.ui.Modifier$Node r4 = r13.modifierNode
            r5 = 16
            int r6 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r5)
            r7 = 0
            r8 = r7
        L_0x002d:
            r9 = 1
            if (r4 == 0) goto L_0x0081
            boolean r10 = r4 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r10 == 0) goto L_0x003c
            androidx.compose.ui.node.PointerInputModifierNode r4 = (androidx.compose.ui.node.PointerInputModifierNode) r4
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4.m5707onPointerEventH0pRuoY(r0, r9, r2)
            goto L_0x007c
        L_0x003c:
            int r10 = r4.getKindSet$ui_release()
            r10 = r10 & r6
            if (r10 == 0) goto L_0x007c
            boolean r10 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r10 == 0) goto L_0x007c
            r10 = r4
            androidx.compose.ui.node.DelegatingNode r10 = (androidx.compose.ui.node.DelegatingNode) r10
            androidx.compose.ui.Modifier$Node r10 = r10.getDelegate$ui_release()
            r11 = r1
        L_0x004f:
            if (r10 == 0) goto L_0x0079
            int r12 = r10.getKindSet$ui_release()
            r12 = r12 & r6
            if (r12 == 0) goto L_0x0074
            int r11 = r11 + 1
            if (r11 != r9) goto L_0x005e
            r4 = r10
            goto L_0x0074
        L_0x005e:
            if (r8 != 0) goto L_0x0067
            androidx.compose.runtime.collection.MutableVector r8 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r12 = new androidx.compose.ui.Modifier.Node[r5]
            r8.<init>(r12, r1)
        L_0x0067:
            if (r4 == 0) goto L_0x006f
            if (r8 == 0) goto L_0x006e
            r8.add(r4)
        L_0x006e:
            r4 = r7
        L_0x006f:
            if (r8 == 0) goto L_0x0074
            r8.add(r10)
        L_0x0074:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild$ui_release()
            goto L_0x004f
        L_0x0079:
            if (r11 != r9) goto L_0x007c
            goto L_0x002d
        L_0x007c:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.pop(r8)
            goto L_0x002d
        L_0x0081:
            androidx.compose.ui.Modifier$Node r0 = r13.modifierNode
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x00a1
            androidx.compose.runtime.collection.MutableVector r0 = r13.getChildren()
            int r2 = r0.getSize()
            if (r2 <= 0) goto L_0x00a1
            java.lang.Object[] r0 = r0.getContent()
        L_0x0097:
            r3 = r0[r1]
            androidx.compose.ui.input.pointer.Node r3 = (androidx.compose.ui.input.pointer.Node) r3
            r3.dispatchFinalEventPass(r14)
            int r1 = r1 + r9
            if (r1 < r2) goto L_0x0097
        L_0x00a1:
            r1 = r9
        L_0x00a2:
            r13.cleanUpHits(r14)
            r13.clearCache()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent):boolean");
    }
}
