package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text2.input.internal.undo.TextUndoOperationKt;
import androidx.compose.foundation.text2.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR/\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text2/input/TextUndoManager;", "", "initialStagingUndo", "Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;", "undoManager", "Landroidx/compose/foundation/text2/input/internal/undo/UndoManager;", "(Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;Landroidx/compose/foundation/text2/input/internal/undo/UndoManager;)V", "canRedo", "", "getCanRedo", "()Z", "canUndo", "getCanUndo", "<set-?>", "stagingUndo", "getStagingUndo", "()Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;", "setStagingUndo", "(Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;)V", "stagingUndo$delegate", "Landroidx/compose/runtime/MutableState;", "clearHistory", "", "flush", "record", "op", "redo", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "undo", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextUndoManager.kt */
public final class TextUndoManager {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableState stagingUndo$delegate;
    /* access modifiers changed from: private */
    public final UndoManager<TextUndoOperation> undoManager;

    public TextUndoManager() {
        this((TextUndoOperation) null, (UndoManager) null, 3, (DefaultConstructorMarker) null);
    }

    public TextUndoManager(TextUndoOperation textUndoOperation, UndoManager<TextUndoOperation> undoManager2) {
        this.undoManager = undoManager2;
        this.stagingUndo$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textUndoOperation, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextUndoManager(TextUndoOperation textUndoOperation, UndoManager undoManager2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textUndoOperation, (i & 2) != 0 ? new UndoManager((List) null, (List) null, 100, 3, (DefaultConstructorMarker) null) : undoManager2);
    }

    /* access modifiers changed from: private */
    public final TextUndoOperation getStagingUndo() {
        return (TextUndoOperation) this.stagingUndo$delegate.getValue();
    }

    private final void setStagingUndo(TextUndoOperation textUndoOperation) {
        this.stagingUndo$delegate.setValue(textUndoOperation);
    }

    public final boolean getCanUndo() {
        return this.undoManager.getCanUndo$foundation_release() || getStagingUndo() != null;
    }

    public final boolean getCanRedo() {
        return this.undoManager.getCanRedo$foundation_release() && getStagingUndo() == null;
    }

    public final void undo(TextFieldState textFieldState) {
        if (getCanUndo()) {
            flush();
            TextUndoOperationKt.undo(textFieldState, this.undoManager.undo());
        }
    }

    public final void redo(TextFieldState textFieldState) {
        if (getCanRedo()) {
            TextUndoOperationKt.redo(textFieldState, this.undoManager.redo());
        }
    }

    public final void record(TextUndoOperation textUndoOperation) {
        Snapshot makeCurrent;
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            TextUndoOperation stagingUndo = getStagingUndo();
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            if (stagingUndo == null) {
                setStagingUndo(textUndoOperation);
                return;
            }
            TextUndoOperation merge = TextUndoManagerKt.merge(stagingUndo, textUndoOperation);
            if (merge != null) {
                setStagingUndo(merge);
                return;
            }
            flush();
            setStagingUndo(textUndoOperation);
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    public final void clearHistory() {
        setStagingUndo((TextUndoOperation) null);
        this.undoManager.clearHistory();
    }

    private final void flush() {
        Snapshot makeCurrent;
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            TextUndoOperation stagingUndo = getStagingUndo();
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            if (stagingUndo != null) {
                this.undoManager.record(stagingUndo);
            }
            setStagingUndo((TextUndoOperation) null);
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/text2/input/TextUndoManager$Companion;", "", "()V", "Saver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextUndoManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0014\u0010\n\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R \u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text2/input/TextUndoManager$Companion$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text2/input/TextUndoManager;", "", "()V", "undoManagerSaver", "Landroidx/compose/foundation/text2/input/internal/undo/UndoManager;", "Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: TextUndoManager.kt */
        public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextUndoManager, Object> {
            public static final int $stable = 8;
            public static final Saver INSTANCE = new Saver();
            private static final androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object> undoManagerSaver = new TextUndoManager$Companion$Saver$special$$inlined$createSaver$1(TextUndoOperation.Companion.getSaver());

            private Saver() {
            }

            static {
                UndoManager.Companion companion = UndoManager.Companion;
            }

            public Object save(SaverScope saverScope, TextUndoManager textUndoManager) {
                TextUndoOperation access$getStagingUndo = textUndoManager.getStagingUndo();
                return CollectionsKt.listOf(access$getStagingUndo != null ? TextUndoOperation.Companion.getSaver().save(saverScope, access$getStagingUndo) : null, undoManagerSaver.save(saverScope, textUndoManager.undoManager));
            }

            public TextUndoManager restore(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List list = (List) obj;
                Object obj2 = list.get(0);
                Object obj3 = list.get(1);
                TextUndoOperation restore = obj2 != null ? TextUndoOperation.Companion.getSaver().restore(obj2) : null;
                androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object> saver = undoManagerSaver;
                Intrinsics.checkNotNull(obj3);
                UndoManager restore2 = saver.restore(obj3);
                Intrinsics.checkNotNull(restore2);
                return new TextUndoManager(restore, restore2);
            }
        }

        private Companion() {
        }
    }
}
