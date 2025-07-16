package androidx.compose.foundation.text2.input.internal.undo;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001dB/\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u000b\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bR\u0014\u0010\t\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/undo/UndoManager;", "T", "", "initialUndoStack", "", "initialRedoStack", "capacity", "", "(Ljava/util/List;Ljava/util/List;I)V", "canRedo", "", "getCanRedo$foundation_release", "()Z", "canUndo", "getCanUndo$foundation_release", "redoStack", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "size", "getSize", "()I", "undoStack", "clearHistory", "", "record", "undoableAction", "(Ljava/lang/Object;)V", "redo", "()Ljava/lang/Object;", "undo", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UndoManager.kt */
public final class UndoManager<T> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final int capacity;
    /* access modifiers changed from: private */
    public SnapshotStateList<T> redoStack;
    /* access modifiers changed from: private */
    public SnapshotStateList<T> undoStack;

    public UndoManager() {
        this((List) null, (List) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public UndoManager(List<? extends T> list, List<? extends T> list2, int i) {
        this.capacity = i;
        SnapshotStateList<T> snapshotStateList = new SnapshotStateList<>();
        snapshotStateList.addAll(list);
        this.undoStack = snapshotStateList;
        SnapshotStateList<T> snapshotStateList2 = new SnapshotStateList<>();
        snapshotStateList2.addAll(list2);
        this.redoStack = snapshotStateList2;
        if (i < 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer".toString());
        } else if (getSize() > i) {
            throw new IllegalArgumentException(("Initial list of undo and redo operations have a size=(" + getSize() + ") greater than the given capacity=(" + i + ").").toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UndoManager(List list, List list2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4) != 0 ? 100 : i);
    }

    public final boolean getCanUndo$foundation_release() {
        return !this.undoStack.isEmpty();
    }

    public final boolean getCanRedo$foundation_release() {
        return !this.redoStack.isEmpty();
    }

    public final int getSize() {
        return this.undoStack.size() + this.redoStack.size();
    }

    public final void record(T t) {
        this.redoStack.clear();
        while (getSize() > this.capacity - 1) {
            CollectionsKt.removeFirst(this.undoStack);
        }
        this.undoStack.add(t);
    }

    public final T undo() {
        if (getCanUndo$foundation_release()) {
            T removeLast = CollectionsKt.removeLast(this.undoStack);
            this.redoStack.add(removeLast);
            return removeLast;
        }
        throw new IllegalStateException("It's an error to call undo while there is nothing to undo. Please first check `canUndo` value before calling the `undo` function.".toString());
    }

    public final T redo() {
        if (getCanRedo$foundation_release()) {
            T removeLast = CollectionsKt.removeLast(this.redoStack);
            this.undoStack.add(removeLast);
            return removeLast;
        }
        throw new IllegalStateException("It's an error to call redo while there is nothing to redo. Please first check `canRedo` value before calling the `redo` function.".toString());
    }

    public final void clearHistory() {
        this.undoStack.clear();
        this.redoStack.clear();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\b\u0001\u0010\u0006\u0018\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00010\u0004H\b¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/undo/UndoManager$Companion;", "", "()V", "createSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text2/input/internal/undo/UndoManager;", "T", "itemSaver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UndoManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ <T> Saver<UndoManager<T>, Object> createSaver(Saver<T, Object> saver) {
            Intrinsics.needClassReification();
            return new UndoManager$Companion$createSaver$1(saver);
        }
    }
}
