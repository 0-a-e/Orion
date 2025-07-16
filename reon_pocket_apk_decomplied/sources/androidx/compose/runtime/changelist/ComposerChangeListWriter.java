package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SlotReader;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.IntRef;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 |2\u00020\u0001:\u0001|B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010$2\u0006\u0010%\u001a\u00020&J(\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020\"J\u0016\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u000203J\"\u00104\u001a\u00020\"2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\"062\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u00020\"J\u0006\u0010:\u001a\u00020\"J\u0006\u0010;\u001a\u00020\"J\u0016\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0012J\u0006\u0010?\u001a\u00020\"J\u0010\u0010@\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0002J\b\u0010A\u001a\u00020\"H\u0002J\u0006\u0010B\u001a\u00020\"J\u001a\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&J\u0016\u0010E\u001a\u00020\"2\u0006\u00102\u001a\u0002032\u0006\u0010,\u001a\u00020FJ\u001e\u0010E\u001a\u00020\"2\u0006\u00102\u001a\u0002032\u0006\u0010,\u001a\u00020F2\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020\"2\u0006\u0010J\u001a\u00020\u0012J\u0010\u0010K\u001a\u00020\"2\b\u0010L\u001a\u0004\u0018\u00010\u0001J\u001e\u0010M\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\u0012J\u000e\u0010O\u001a\u00020\"2\u0006\u0010P\u001a\u00020\u0012J\u000e\u0010Q\u001a\u00020\"2\u0006\u0010P\u001a\u00020\u0012J\u0006\u0010R\u001a\u00020\"J\b\u0010S\u001a\u00020\"H\u0002J\b\u0010T\u001a\u00020\"H\u0002J\b\u0010U\u001a\u00020\"H\u0002J\u0012\u0010V\u001a\u00020\"2\b\b\u0002\u0010W\u001a\u00020\fH\u0002J \u0010X\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\u0012H\u0002J\b\u0010Y\u001a\u00020\"H\u0002J\u0012\u0010Z\u001a\u00020\"2\b\b\u0002\u0010[\u001a\u00020\fH\u0002J\u0018\u0010\\\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010]\u001a\u00020\"J\u0006\u0010^\u001a\u00020\"J\u001e\u0010_\u001a\u00020\"2\u0006\u00108\u001a\u00020`2\u0006\u0010*\u001a\u00020+2\u0006\u0010a\u001a\u00020-J\u000e\u0010b\u001a\u00020\"2\u0006\u0010c\u001a\u00020dJ\u0006\u0010e\u001a\u00020\"J\u0016\u0010f\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\u0012J\u0006\u0010g\u001a\u00020\"J\u0006\u0010h\u001a\u00020\"J\u0014\u0010i\u001a\u00020\"2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\"0kJ\u0006\u0010l\u001a\u00020\"J\u0010\u0010m\u001a\u00020\"2\b\u0010n\u001a\u0004\u0018\u00010\u0001J>\u0010o\u001a\u00020\"\"\u0004\b\u0000\u0010p\"\u0004\b\u0001\u0010q2\u0006\u0010c\u001a\u0002Hq2\u001d\u0010r\u001a\u0019\u0012\u0004\u0012\u0002Hp\u0012\u0004\u0012\u0002Hq\u0012\u0004\u0012\u00020\"0s¢\u0006\u0002\bt¢\u0006\u0002\u0010uJ\u0018\u0010v\u001a\u00020\"2\b\u0010c\u001a\u0004\u0018\u00010\u00012\u0006\u0010w\u001a\u00020\u0012J\u0010\u0010x\u001a\u00020\"2\b\u0010L\u001a\u0004\u0018\u00010\u0001J\u001f\u0010y\u001a\u00020\"2\u0006\u0010z\u001a\u00020\u00052\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\"0kH\bJ\u0017\u0010{\u001a\u00020\"2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\"0kH\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "", "composer", "Landroidx/compose/runtime/ComposerImpl;", "changeList", "Landroidx/compose/runtime/changelist/ChangeList;", "(Landroidx/compose/runtime/ComposerImpl;Landroidx/compose/runtime/changelist/ChangeList;)V", "getChangeList", "()Landroidx/compose/runtime/changelist/ChangeList;", "setChangeList", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "implicitRootStart", "", "getImplicitRootStart", "()Z", "setImplicitRootStart", "(Z)V", "moveCount", "", "moveFrom", "moveTo", "pendingDownNodes", "Landroidx/compose/runtime/Stack;", "pendingUps", "reader", "Landroidx/compose/runtime/SlotReader;", "getReader", "()Landroidx/compose/runtime/SlotReader;", "removeFrom", "startedGroup", "startedGroups", "Landroidx/compose/runtime/IntStack;", "writersReaderDelta", "copyNodesToNewAnchorLocation", "", "nodes", "", "effectiveNodeIndex", "Landroidx/compose/runtime/internal/IntRef;", "copySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "from", "Landroidx/compose/runtime/MovableContentStateReference;", "to", "deactivateCurrentGroup", "determineMovableContentNodeIndex", "effectiveNodeIndexOut", "anchor", "Landroidx/compose/runtime/Anchor;", "endCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "endCurrentGroup", "endMovableContentPlacement", "endNodeMovement", "endNodeMovementAndDeleteNode", "nodeIndex", "group", "endRoot", "ensureGroupStarted", "ensureRootStarted", "finalizeComposition", "includeOperationsIn", "other", "insertSlots", "Landroidx/compose/runtime/SlotTable;", "fixups", "Landroidx/compose/runtime/changelist/FixupList;", "moveCurrentGroup", "offset", "moveDown", "node", "moveNode", "count", "moveReaderRelativeTo", "location", "moveReaderToAbsolute", "moveUp", "pushApplierOperationPreamble", "pushPendingUpsAndDowns", "pushSlotEditingOperationPreamble", "pushSlotTableOperationPreamble", "useParentSlot", "realizeMoveNode", "realizeNodeMovementOperations", "realizeOperationLocation", "forParent", "realizeRemoveNode", "recordSlotEditing", "releaseMovableContent", "releaseMovableGroupAtCurrent", "Landroidx/compose/runtime/ControlledComposition;", "reference", "remember", "value", "Landroidx/compose/runtime/RememberObserver;", "removeCurrentGroup", "removeNode", "resetSlots", "resetTransientState", "sideEffect", "effect", "Lkotlin/Function0;", "skipToEndOfCurrentGroup", "updateAuxData", "data", "updateNode", "T", "V", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "updateValue", "groupSlotIndex", "useNode", "withChangeList", "newChangeList", "withoutImplicitRootStart", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposerChangeListWriter.kt */
public final class ComposerChangeListWriter {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int invalidGroupLocation = -2;
    private ChangeList changeList;
    private final ComposerImpl composer;
    private boolean implicitRootStart = true;
    private int moveCount;
    private int moveFrom = -1;
    private int moveTo = -1;
    private Stack<Object> pendingDownNodes = new Stack<>();
    private int pendingUps;
    private int removeFrom = -1;
    private boolean startedGroup;
    private final IntStack startedGroups = new IntStack();
    private int writersReaderDelta;

    public ComposerChangeListWriter(ComposerImpl composerImpl, ChangeList changeList2) {
        this.composer = composerImpl;
        this.changeList = changeList2;
    }

    public final ChangeList getChangeList() {
        return this.changeList;
    }

    public final void setChangeList(ChangeList changeList2) {
        this.changeList = changeList2;
    }

    private final SlotReader getReader() {
        return this.composer.getReader$runtime_release();
    }

    public final boolean getImplicitRootStart() {
        return this.implicitRootStart;
    }

    public final void setImplicitRootStart(boolean z) {
        this.implicitRootStart = z;
    }

    private final void pushApplierOperationPreamble() {
        pushPendingUpsAndDowns();
    }

    private final void pushSlotEditingOperationPreamble() {
        realizeOperationLocation$default(this, false, 1, (Object) null);
        recordSlotEditing();
    }

    static /* synthetic */ void pushSlotTableOperationPreamble$default(ComposerChangeListWriter composerChangeListWriter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerChangeListWriter.pushSlotTableOperationPreamble(z);
    }

    private final void pushSlotTableOperationPreamble(boolean z) {
        realizeOperationLocation(z);
    }

    public final void moveReaderRelativeTo(int i) {
        this.writersReaderDelta += i - getReader().getCurrentGroup();
    }

    public final void moveReaderToAbsolute(int i) {
        this.writersReaderDelta = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = getReader();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void recordSlotEditing() {
        /*
            r4 = this;
            androidx.compose.runtime.SlotReader r0 = r4.getReader()
            int r0 = r0.getSize()
            if (r0 <= 0) goto L_0x002c
            androidx.compose.runtime.SlotReader r0 = r4.getReader()
            int r1 = r0.getParent()
            androidx.compose.runtime.IntStack r2 = r4.startedGroups
            r3 = -2
            int r2 = r2.peekOr(r3)
            if (r2 == r1) goto L_0x002c
            r4.ensureRootStarted()
            if (r1 <= 0) goto L_0x002c
            androidx.compose.runtime.Anchor r0 = r0.anchor(r1)
            androidx.compose.runtime.IntStack r2 = r4.startedGroups
            r2.push(r1)
            r4.ensureGroupStarted(r0)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.changelist.ComposerChangeListWriter.recordSlotEditing():void");
    }

    private final void ensureRootStarted() {
        if (!this.startedGroup && this.implicitRootStart) {
            pushSlotTableOperationPreamble$default(this, false, 1, (Object) null);
            this.changeList.pushEnsureRootStarted();
            this.startedGroup = true;
        }
    }

    private final void ensureGroupStarted(Anchor anchor) {
        pushSlotTableOperationPreamble$default(this, false, 1, (Object) null);
        this.changeList.pushEnsureGroupStarted(anchor);
        this.startedGroup = true;
    }

    static /* synthetic */ void realizeOperationLocation$default(ComposerChangeListWriter composerChangeListWriter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerChangeListWriter.realizeOperationLocation(z);
    }

    private final void realizeOperationLocation(boolean z) {
        int parent = z ? getReader().getParent() : getReader().getCurrentGroup();
        int i = parent - this.writersReaderDelta;
        if (!(i >= 0)) {
            ComposerKt.composeRuntimeError("Tried to seek backward".toString());
            throw new KotlinNothingValueException();
        } else if (i > 0) {
            this.changeList.pushAdvanceSlotsBy(i);
            this.writersReaderDelta = parent;
        }
    }

    public final void withChangeList(ChangeList changeList2, Function0<Unit> function0) {
        ChangeList changeList3 = getChangeList();
        try {
            setChangeList(changeList2);
            function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            setChangeList(changeList3);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void withoutImplicitRootStart(Function0<Unit> function0) {
        boolean implicitRootStart2 = getImplicitRootStart();
        try {
            setImplicitRootStart(false);
            function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            setImplicitRootStart(implicitRootStart2);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void remember(RememberObserver rememberObserver) {
        this.changeList.pushRemember(rememberObserver);
    }

    public final void updateValue(Object obj, int i) {
        pushSlotTableOperationPreamble(true);
        this.changeList.pushUpdateValue(obj, i);
    }

    public final void resetSlots() {
        this.changeList.pushResetSlots();
    }

    public final void updateAuxData(Object obj) {
        pushSlotTableOperationPreamble$default(this, false, 1, (Object) null);
        this.changeList.pushUpdateAuxData(obj);
    }

    public final void endRoot() {
        if (this.startedGroup) {
            pushSlotTableOperationPreamble$default(this, false, 1, (Object) null);
            pushSlotTableOperationPreamble$default(this, false, 1, (Object) null);
            this.changeList.pushEndCurrentGroup();
            this.startedGroup = false;
        }
    }

    public final void endCurrentGroup() {
        int parent = getReader().getParent();
        if (!(this.startedGroups.peekOr(-1) <= parent)) {
            ComposerKt.composeRuntimeError("Missed recording an endGroup".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.peekOr(-1) == parent) {
            pushSlotTableOperationPreamble$default(this, false, 1, (Object) null);
            this.startedGroups.pop();
            this.changeList.pushEndCurrentGroup();
        }
    }

    public final void skipToEndOfCurrentGroup() {
        this.changeList.pushSkipToEndOfCurrentGroup();
    }

    public final void removeCurrentGroup() {
        pushSlotEditingOperationPreamble();
        this.changeList.pushRemoveCurrentGroup();
        this.writersReaderDelta += getReader().getGroupSize();
    }

    public final void insertSlots(Anchor anchor, SlotTable slotTable) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        this.changeList.pushInsertSlots(anchor, slotTable);
    }

    public final void insertSlots(Anchor anchor, SlotTable slotTable, FixupList fixupList) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        this.changeList.pushInsertSlots(anchor, slotTable, fixupList);
    }

    public final void moveCurrentGroup(int i) {
        pushSlotEditingOperationPreamble();
        this.changeList.pushMoveCurrentGroup(i);
    }

    public final void endCompositionScope(Function1<? super Composition, Unit> function1, Composition composition) {
        this.changeList.pushEndCompositionScope(function1, composition);
    }

    public final void useNode(Object obj) {
        pushApplierOperationPreamble();
        this.changeList.pushUseNode(obj);
    }

    public final <T, V> void updateNode(V v, Function2<? super T, ? super V, Unit> function2) {
        pushApplierOperationPreamble();
        this.changeList.pushUpdateNode(v, function2);
    }

    public final void removeNode(int i, int i2) {
        if (i2 > 0) {
            if (!(i >= 0)) {
                ComposerKt.composeRuntimeError(("Invalid remove index " + i).toString());
                throw new KotlinNothingValueException();
            } else if (this.removeFrom == i) {
                this.moveCount += i2;
            } else {
                realizeNodeMovementOperations();
                this.removeFrom = i;
                this.moveCount = i2;
            }
        }
    }

    public final void moveNode(int i, int i2, int i3) {
        if (i3 > 0) {
            int i4 = this.moveCount;
            if (i4 > 0 && this.moveFrom == i - i4 && this.moveTo == i2 - i4) {
                this.moveCount = i4 + i3;
                return;
            }
            realizeNodeMovementOperations();
            this.moveFrom = i;
            this.moveTo = i2;
            this.moveCount = i3;
        }
    }

    public final void releaseMovableContent() {
        pushPendingUpsAndDowns();
        if (this.startedGroup) {
            skipToEndOfCurrentGroup();
            endRoot();
        }
    }

    public final void endNodeMovement() {
        realizeNodeMovementOperations();
    }

    public final void endNodeMovementAndDeleteNode(int i, int i2) {
        endNodeMovement();
        pushPendingUpsAndDowns();
        int nodeCount = getReader().isNode(i2) ? 1 : getReader().nodeCount(i2);
        if (nodeCount > 0) {
            removeNode(i, nodeCount);
        }
    }

    private final void realizeNodeMovementOperations() {
        int i = this.moveCount;
        if (i > 0) {
            int i2 = this.removeFrom;
            if (i2 >= 0) {
                realizeRemoveNode(i2, i);
                this.removeFrom = -1;
            } else {
                realizeMoveNode(this.moveTo, this.moveFrom, i);
                this.moveFrom = -1;
                this.moveTo = -1;
            }
            this.moveCount = 0;
        }
    }

    private final void realizeRemoveNode(int i, int i2) {
        pushApplierOperationPreamble();
        this.changeList.pushRemoveNode(i, i2);
    }

    private final void realizeMoveNode(int i, int i2, int i3) {
        pushApplierOperationPreamble();
        this.changeList.pushMoveNode(i, i2, i3);
    }

    public final void moveUp() {
        if (this.pendingDownNodes.isNotEmpty()) {
            this.pendingDownNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    public final void moveDown(Object obj) {
        this.pendingDownNodes.push(obj);
    }

    private final void pushPendingUpsAndDowns() {
        int i = this.pendingUps;
        if (i > 0) {
            this.changeList.pushUps(i);
            this.pendingUps = 0;
        }
        if (this.pendingDownNodes.isNotEmpty()) {
            this.changeList.pushDowns(this.pendingDownNodes.toArray());
            this.pendingDownNodes.clear();
        }
    }

    public final void sideEffect(Function0<Unit> function0) {
        this.changeList.pushSideEffect(function0);
    }

    public final void determineMovableContentNodeIndex(IntRef intRef, Anchor anchor) {
        pushPendingUpsAndDowns();
        this.changeList.pushDetermineMovableContentNodeIndex(intRef, anchor);
    }

    public final void copyNodesToNewAnchorLocation(List<? extends Object> list, IntRef intRef) {
        this.changeList.pushCopyNodesToNewAnchorLocation(list, intRef);
    }

    public final void copySlotTableToAnchorLocation(MovableContentState movableContentState, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        this.changeList.pushCopySlotTableToAnchorLocation(movableContentState, compositionContext, movableContentStateReference, movableContentStateReference2);
    }

    public final void releaseMovableGroupAtCurrent(ControlledComposition controlledComposition, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference) {
        this.changeList.pushReleaseMovableGroupAtCurrent(controlledComposition, compositionContext, movableContentStateReference);
    }

    public final void endMovableContentPlacement() {
        this.changeList.pushEndMovableContentPlacement();
        this.writersReaderDelta = 0;
    }

    public static /* synthetic */ void includeOperationsIn$default(ComposerChangeListWriter composerChangeListWriter, ChangeList changeList2, IntRef intRef, int i, Object obj) {
        if ((i & 2) != 0) {
            intRef = null;
        }
        composerChangeListWriter.includeOperationsIn(changeList2, intRef);
    }

    public final void includeOperationsIn(ChangeList changeList2, IntRef intRef) {
        this.changeList.pushExecuteOperationsIn(changeList2, intRef);
    }

    public final void finalizeComposition() {
        pushPendingUpsAndDowns();
        if (!this.startedGroups.isEmpty()) {
            ComposerKt.composeRuntimeError("Missed recording an endGroup()".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void resetTransientState() {
        this.startedGroup = false;
        this.startedGroups.clear();
        this.writersReaderDelta = 0;
    }

    public final void deactivateCurrentGroup() {
        pushSlotTableOperationPreamble$default(this, false, 1, (Object) null);
        this.changeList.pushDeactivateCurrentGroup();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/changelist/ComposerChangeListWriter$Companion;", "", "()V", "invalidGroupLocation", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ComposerChangeListWriter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
