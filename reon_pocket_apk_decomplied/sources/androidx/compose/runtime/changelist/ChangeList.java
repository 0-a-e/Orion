package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.changelist.Operations;
import androidx.compose.runtime.internal.IntRef;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006J\u001e\u0010\u0017\u001a\u00020\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ(\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020\nJ\u0016\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)J\u001b\u0010*\u001a\u00020\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0+¢\u0006\u0002\u0010,J\"\u0010-\u001a\u00020\n2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\n0/2\u0006\u00101\u001a\u000200J\u0006\u00102\u001a\u00020\nJ\u0006\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u00020\n2\u0006\u0010(\u001a\u00020)J\u0006\u00105\u001a\u00020\nJ\u001a\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0016\u00108\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u000209J\u001e\u00108\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u0002092\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0006J\u001e\u0010>\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006J\u001e\u0010@\u001a\u00020\n2\u0006\u00101\u001a\u00020A2\u0006\u0010 \u001a\u00020!2\u0006\u0010B\u001a\u00020#J\u000e\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020\nJ\u0016\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0006J\u0006\u0010J\u001a\u00020\nJ\u0014\u0010K\u001a\u00020\n2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0MJ\u0006\u0010N\u001a\u00020\nJ\u0010\u0010O\u001a\u00020\n2\b\u0010P\u001a\u0004\u0018\u00010\u001aJ>\u0010Q\u001a\u00020\n\"\u0004\b\u0000\u0010R\"\u0004\b\u0001\u0010S2\u0006\u0010D\u001a\u0002HS2\u001d\u0010T\u001a\u0019\u0012\u0004\u0012\u0002HR\u0012\u0004\u0012\u0002HS\u0012\u0004\u0012\u00020\n0U¢\u0006\u0002\bV¢\u0006\u0002\u0010WJ\u0018\u0010X\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010\u001a2\u0006\u0010Y\u001a\u00020\u0006J\u000e\u0010Z\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0006J\u0010\u0010[\u001a\u00020\n2\b\u0010\\\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020^H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006`"}, d2 = {"Landroidx/compose/runtime/changelist/ChangeList;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "()V", "operations", "Landroidx/compose/runtime/changelist/Operations;", "size", "", "getSize", "()I", "clear", "", "executeAndFlushAllPendingChanges", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "isEmpty", "", "isNotEmpty", "pushAdvanceSlotsBy", "distance", "pushCopyNodesToNewAnchorLocation", "nodes", "", "", "effectiveNodeIndex", "Landroidx/compose/runtime/internal/IntRef;", "pushCopySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "from", "Landroidx/compose/runtime/MovableContentStateReference;", "to", "pushDeactivateCurrentGroup", "pushDetermineMovableContentNodeIndex", "effectiveNodeIndexOut", "anchor", "Landroidx/compose/runtime/Anchor;", "pushDowns", "", "([Ljava/lang/Object;)V", "pushEndCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "pushEndCurrentGroup", "pushEndMovableContentPlacement", "pushEnsureGroupStarted", "pushEnsureRootStarted", "pushExecuteOperationsIn", "changeList", "pushInsertSlots", "Landroidx/compose/runtime/SlotTable;", "fixups", "Landroidx/compose/runtime/changelist/FixupList;", "pushMoveCurrentGroup", "offset", "pushMoveNode", "count", "pushReleaseMovableGroupAtCurrent", "Landroidx/compose/runtime/ControlledComposition;", "reference", "pushRemember", "value", "Landroidx/compose/runtime/RememberObserver;", "pushRemoveCurrentGroup", "pushRemoveNode", "removeFrom", "moveCount", "pushResetSlots", "pushSideEffect", "effect", "Lkotlin/Function0;", "pushSkipToEndOfCurrentGroup", "pushUpdateAuxData", "data", "pushUpdateNode", "T", "V", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "pushUpdateValue", "groupSlotIndex", "pushUps", "pushUseNode", "node", "toDebugString", "", "linePrefix", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ChangeList.kt */
public final class ChangeList implements OperationsDebugStringFormattable {
    public static final int $stable = 8;
    private final Operations operations = new Operations();

    public final int getSize() {
        return this.operations.getSize();
    }

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final boolean isNotEmpty() {
        return this.operations.isNotEmpty();
    }

    public final void clear() {
        this.operations.clear();
    }

    public final void executeAndFlushAllPendingChanges(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        this.operations.executeAndFlushAllPendingOperations(applier, slotWriter, rememberManager);
    }

    public final void pushRemember(RememberObserver rememberObserver) {
        Operations operations2 = this.operations;
        Operation operation = Operation.Remember.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.Remember remember = Operation.Remember.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), rememberObserver);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushUpdateValue(Object obj, int i) {
        Operations operations2 = this.operations;
        Operation operation = Operation.UpdateValue.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.UpdateValue updateValue = Operation.UpdateValue.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), obj);
        Operation.UpdateValue updateValue2 = Operation.UpdateValue.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(0), i);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i2 = 0;
            for (int i3 = 0; i3 < ints; i3++) {
                if (((1 << i3) & operations2.pushedIntMask) != 0) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i3)));
                    i2++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i4 = 0;
            for (int i5 = 0; i5 < objects; i5++) {
                if (((1 << i5) & operations2.pushedObjectMask) != 0) {
                    if (i2 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i5)));
                    i4++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i2 + " int arguments (" + sb2 + ") and " + i4 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushResetSlots() {
        this.operations.push(Operation.ResetSlots.INSTANCE);
    }

    public final void pushDeactivateCurrentGroup() {
        this.operations.push(Operation.DeactivateCurrentGroup.INSTANCE);
    }

    public final void pushUpdateAuxData(Object obj) {
        Operations operations2 = this.operations;
        Operation operation = Operation.UpdateAuxData.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.UpdateAuxData updateAuxData = Operation.UpdateAuxData.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), obj);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushEnsureRootStarted() {
        this.operations.push(Operation.EnsureRootGroupStarted.INSTANCE);
    }

    public final void pushEnsureGroupStarted(Anchor anchor) {
        Operations operations2 = this.operations;
        Operation operation = Operation.EnsureGroupStarted.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.EnsureGroupStarted ensureGroupStarted = Operation.EnsureGroupStarted.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), anchor);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushEndCurrentGroup() {
        this.operations.push(Operation.EndCurrentGroup.INSTANCE);
    }

    public final void pushSkipToEndOfCurrentGroup() {
        this.operations.push(Operation.SkipToEndOfCurrentGroup.INSTANCE);
    }

    public final void pushRemoveCurrentGroup() {
        this.operations.push(Operation.RemoveCurrentGroup.INSTANCE);
    }

    public final void pushInsertSlots(Anchor anchor, SlotTable slotTable) {
        Operations operations2 = this.operations;
        Operation operation = Operation.InsertSlots.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.InsertSlots insertSlots = Operation.InsertSlots.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), anchor);
        Operation.InsertSlots insertSlots2 = Operation.InsertSlots.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(1), slotTable);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushInsertSlots(Anchor anchor, SlotTable slotTable, FixupList fixupList) {
        Operations operations2 = this.operations;
        Operation operation = Operation.InsertSlotsWithFixups.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.InsertSlotsWithFixups insertSlotsWithFixups = Operation.InsertSlotsWithFixups.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), anchor);
        Operation.InsertSlotsWithFixups insertSlotsWithFixups2 = Operation.InsertSlotsWithFixups.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(1), slotTable);
        Operation.InsertSlotsWithFixups insertSlotsWithFixups3 = Operation.InsertSlotsWithFixups.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(2), fixupList);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushMoveCurrentGroup(int i) {
        Operations operations2 = this.operations;
        Operation operation = Operation.MoveCurrentGroup.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.MoveCurrentGroup moveCurrentGroup = Operation.MoveCurrentGroup.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(0), i);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i2 = 0;
            for (int i3 = 0; i3 < ints; i3++) {
                if (((1 << i3) & operations2.pushedIntMask) != 0) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i3)));
                    i2++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i4 = 0;
            for (int i5 = 0; i5 < objects; i5++) {
                if (((1 << i5) & operations2.pushedObjectMask) != 0) {
                    if (i2 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i5)));
                    i4++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i2 + " int arguments (" + sb2 + ") and " + i4 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushEndCompositionScope(Function1<? super Composition, Unit> function1, Composition composition) {
        Operations operations2 = this.operations;
        Operation operation = Operation.EndCompositionScope.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.EndCompositionScope endCompositionScope = Operation.EndCompositionScope.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), function1);
        Operation.EndCompositionScope endCompositionScope2 = Operation.EndCompositionScope.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(1), composition);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushUseNode(Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            this.operations.push(Operation.UseCurrentNode.INSTANCE);
        }
    }

    public final <T, V> void pushUpdateNode(V v, Function2<? super T, ? super V, Unit> function2) {
        Operations operations2 = this.operations;
        Operation operation = Operation.UpdateNode.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.UpdateNode updateNode = Operation.UpdateNode.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), v);
        Operation.UpdateNode updateNode2 = Operation.UpdateNode.INSTANCE;
        int r4 = Operation.ObjectParameter.m3345constructorimpl(1);
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.m3392setObjectDKhxnng(r2, r4, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2));
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushRemoveNode(int i, int i2) {
        Operations operations2 = this.operations;
        Operation operation = Operation.RemoveNode.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.RemoveNode removeNode = Operation.RemoveNode.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(0), i);
        Operation.RemoveNode removeNode2 = Operation.RemoveNode.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(1), i2);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i3 = 0;
            for (int i4 = 0; i4 < ints; i4++) {
                if (((1 << i4) & operations2.pushedIntMask) != 0) {
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i4)));
                    i3++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i5 = 0;
            for (int i6 = 0; i6 < objects; i6++) {
                if (((1 << i6) & operations2.pushedObjectMask) != 0) {
                    if (i3 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i6)));
                    i5++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i3 + " int arguments (" + sb2 + ") and " + i5 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushMoveNode(int i, int i2, int i3) {
        Operations operations2 = this.operations;
        Operation operation = Operation.MoveNode.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.MoveNode moveNode = Operation.MoveNode.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(1), i);
        Operation.MoveNode moveNode2 = Operation.MoveNode.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(0), i2);
        Operation.MoveNode moveNode3 = Operation.MoveNode.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(2), i3);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i4 = 0;
            for (int i5 = 0; i5 < ints; i5++) {
                if (((1 << i5) & operations2.pushedIntMask) != 0) {
                    if (i4 > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i5)));
                    i4++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i6 = 0;
            for (int i7 = 0; i7 < objects; i7++) {
                if (((1 << i7) & operations2.pushedObjectMask) != 0) {
                    if (i4 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i7)));
                    i6++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i4 + " int arguments (" + sb2 + ") and " + i6 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushAdvanceSlotsBy(int i) {
        Operations operations2 = this.operations;
        Operation operation = Operation.AdvanceSlotsBy.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.AdvanceSlotsBy advanceSlotsBy = Operation.AdvanceSlotsBy.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(0), i);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i2 = 0;
            for (int i3 = 0; i3 < ints; i3++) {
                if (((1 << i3) & operations2.pushedIntMask) != 0) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i3)));
                    i2++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i4 = 0;
            for (int i5 = 0; i5 < objects; i5++) {
                if (((1 << i5) & operations2.pushedObjectMask) != 0) {
                    if (i2 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i5)));
                    i4++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i2 + " int arguments (" + sb2 + ") and " + i4 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushUps(int i) {
        Operations operations2 = this.operations;
        Operation operation = Operation.Ups.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.Ups ups = Operation.Ups.INSTANCE;
        Operations.WriteScope.m3391setIntA6tL2VI(r2, Operation.IntParameter.m3332constructorimpl(0), i);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i2 = 0;
            for (int i3 = 0; i3 < ints; i3++) {
                if (((1 << i3) & operations2.pushedIntMask) != 0) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i3)));
                    i2++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i4 = 0;
            for (int i5 = 0; i5 < objects; i5++) {
                if (((1 << i5) & operations2.pushedObjectMask) != 0) {
                    if (i2 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i5)));
                    i4++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i2 + " int arguments (" + sb2 + ") and " + i4 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushDowns(Object[] objArr) {
        if (!(objArr.length == 0)) {
            Operations operations2 = this.operations;
            Operation operation = Operation.Downs.INSTANCE;
            operations2.pushOp(operation);
            Operations r4 = Operations.WriteScope.m3386constructorimpl(operations2);
            Operation.Downs downs = Operation.Downs.INSTANCE;
            Operations.WriteScope.m3392setObjectDKhxnng(r4, Operation.ObjectParameter.m3345constructorimpl(0), objArr);
            if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
                StringBuilder sb = new StringBuilder();
                int ints = operation.getInts();
                int i = 0;
                for (int i2 = 0; i2 < ints; i2++) {
                    if (((1 << i2) & operations2.pushedIntMask) != 0) {
                        if (i > 0) {
                            sb.append(", ");
                        }
                        sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                        i++;
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                StringBuilder sb3 = new StringBuilder();
                int objects = operation.getObjects();
                int i3 = 0;
                for (int i4 = 0; i4 < objects; i4++) {
                    if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                        if (i > 0) {
                            sb3.append(", ");
                        }
                        sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                        i3++;
                    }
                }
                String sb4 = sb3.toString();
                Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
                throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
            }
        }
    }

    public final void pushSideEffect(Function0<Unit> function0) {
        Operations operations2 = this.operations;
        Operation operation = Operation.SideEffect.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.SideEffect sideEffect = Operation.SideEffect.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), function0);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushDetermineMovableContentNodeIndex(IntRef intRef, Anchor anchor) {
        Operations operations2 = this.operations;
        Operation operation = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), intRef);
        Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex2 = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(1), anchor);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushCopyNodesToNewAnchorLocation(List<? extends Object> list, IntRef intRef) {
        if (!list.isEmpty()) {
            Operations operations2 = this.operations;
            Operation operation = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
            operations2.pushOp(operation);
            Operations r3 = Operations.WriteScope.m3386constructorimpl(operations2);
            Operation.CopyNodesToNewAnchorLocation copyNodesToNewAnchorLocation = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
            Operations.WriteScope.m3392setObjectDKhxnng(r3, Operation.ObjectParameter.m3345constructorimpl(1), list);
            Operation.CopyNodesToNewAnchorLocation copyNodesToNewAnchorLocation2 = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
            Operations.WriteScope.m3392setObjectDKhxnng(r3, Operation.ObjectParameter.m3345constructorimpl(0), intRef);
            if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
                StringBuilder sb = new StringBuilder();
                int ints = operation.getInts();
                int i = 0;
                for (int i2 = 0; i2 < ints; i2++) {
                    if (((1 << i2) & operations2.pushedIntMask) != 0) {
                        if (i > 0) {
                            sb.append(", ");
                        }
                        sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                        i++;
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                StringBuilder sb3 = new StringBuilder();
                int objects = operation.getObjects();
                int i3 = 0;
                for (int i4 = 0; i4 < objects; i4++) {
                    if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                        if (i > 0) {
                            sb3.append(", ");
                        }
                        sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                        i3++;
                    }
                }
                String sb4 = sb3.toString();
                Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
                throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
            }
        }
    }

    public final void pushCopySlotTableToAnchorLocation(MovableContentState movableContentState, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        Operations operations2 = this.operations;
        Operation operation = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.CopySlotTableToAnchorLocation copySlotTableToAnchorLocation = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), movableContentState);
        Operation.CopySlotTableToAnchorLocation copySlotTableToAnchorLocation2 = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(1), compositionContext);
        Operation.CopySlotTableToAnchorLocation copySlotTableToAnchorLocation3 = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(3), movableContentStateReference2);
        Operation.CopySlotTableToAnchorLocation copySlotTableToAnchorLocation4 = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(2), movableContentStateReference);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushReleaseMovableGroupAtCurrent(ControlledComposition controlledComposition, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference) {
        Operations operations2 = this.operations;
        Operation operation = Operation.ReleaseMovableGroupAtCurrent.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
        Operation.ReleaseMovableGroupAtCurrent releaseMovableGroupAtCurrent = Operation.ReleaseMovableGroupAtCurrent.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), controlledComposition);
        Operation.ReleaseMovableGroupAtCurrent releaseMovableGroupAtCurrent2 = Operation.ReleaseMovableGroupAtCurrent.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(1), compositionContext);
        Operation.ReleaseMovableGroupAtCurrent releaseMovableGroupAtCurrent3 = Operation.ReleaseMovableGroupAtCurrent.INSTANCE;
        Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(2), movableContentStateReference);
        if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pushEndMovableContentPlacement() {
        this.operations.push(Operation.EndMovableContentPlacement.INSTANCE);
    }

    public static /* synthetic */ void pushExecuteOperationsIn$default(ChangeList changeList, ChangeList changeList2, IntRef intRef, int i, Object obj) {
        if ((i & 2) != 0) {
            intRef = null;
        }
        changeList.pushExecuteOperationsIn(changeList2, intRef);
    }

    public final void pushExecuteOperationsIn(ChangeList changeList, IntRef intRef) {
        if (changeList.isNotEmpty()) {
            Operations operations2 = this.operations;
            Operation operation = Operation.ApplyChangeList.INSTANCE;
            operations2.pushOp(operation);
            Operations r2 = Operations.WriteScope.m3386constructorimpl(operations2);
            Operation.ApplyChangeList applyChangeList = Operation.ApplyChangeList.INSTANCE;
            Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(0), changeList);
            Operation.ApplyChangeList applyChangeList2 = Operation.ApplyChangeList.INSTANCE;
            Operations.WriteScope.m3392setObjectDKhxnng(r2, Operation.ObjectParameter.m3345constructorimpl(1), intRef);
            if (operations2.pushedIntMask != operations2.createExpectedArgMask(operation.getInts()) || operations2.pushedObjectMask != operations2.createExpectedArgMask(operation.getObjects())) {
                StringBuilder sb = new StringBuilder();
                int ints = operation.getInts();
                int i = 0;
                for (int i2 = 0; i2 < ints; i2++) {
                    if (((1 << i2) & operations2.pushedIntMask) != 0) {
                        if (i > 0) {
                            sb.append(", ");
                        }
                        sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                        i++;
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                StringBuilder sb3 = new StringBuilder();
                int objects = operation.getObjects();
                int i3 = 0;
                for (int i4 = 0; i4 < objects; i4++) {
                    if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                        if (i > 0) {
                            sb3.append(", ");
                        }
                        sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                        i3++;
                    }
                }
                String sb4 = sb3.toString();
                Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
                throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
            }
        }
    }

    public String toDebugString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeList instance containing");
        sb.append(getSize());
        sb.append(" operations");
        if (sb.length() > 0) {
            sb.append(":\n");
            sb.append(this.operations.toDebugString(str));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
