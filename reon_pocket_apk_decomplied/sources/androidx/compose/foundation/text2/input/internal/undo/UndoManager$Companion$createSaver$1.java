package androidx.compose.foundation.text2.input.internal.undo;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u001a\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¨\u0006\b"}, d2 = {"androidx/compose/foundation/text2/input/internal/undo/UndoManager$Companion$createSaver$1", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text2/input/internal/undo/UndoManager;", "", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
/* compiled from: UndoManager.kt */
public final class UndoManager$Companion$createSaver$1 implements Saver<UndoManager<T>, Object> {
    final /* synthetic */ Saver<T, Object> $itemSaver;

    public UndoManager$Companion$createSaver$1(Saver<T, Object> saver) {
        this.$itemSaver = saver;
    }

    public Object save(SaverScope saverScope, UndoManager<T> undoManager) {
        Saver<T, Object> saver = this.$itemSaver;
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(Integer.valueOf(undoManager.capacity));
        createListBuilder.add(Integer.valueOf(undoManager.undoStack.size()));
        createListBuilder.add(Integer.valueOf(undoManager.redoStack.size()));
        List access$getUndoStack$p = undoManager.undoStack;
        int size = access$getUndoStack$p.size();
        for (int i = 0; i < size; i++) {
            createListBuilder.add(saver.save(saverScope, access$getUndoStack$p.get(i)));
        }
        List access$getRedoStack$p = undoManager.redoStack;
        int size2 = access$getRedoStack$p.size();
        for (int i2 = 0; i2 < size2; i2++) {
            createListBuilder.add(saver.save(saverScope, access$getRedoStack$p.get(i2)));
        }
        return CollectionsKt.build(createListBuilder);
    }

    public UndoManager<T> restore(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        int intValue = ((Number) list.get(0)).intValue();
        int intValue2 = ((Number) list.get(1)).intValue();
        int intValue3 = ((Number) list.get(2)).intValue();
        Saver<T, Object> saver = this.$itemSaver;
        List createListBuilder = CollectionsKt.createListBuilder();
        int i = 3;
        while (i < intValue2 + 3) {
            T restore = saver.restore(list.get(i));
            Intrinsics.checkNotNull(restore);
            createListBuilder.add(restore);
            i++;
        }
        List build = CollectionsKt.build(createListBuilder);
        Saver<T, Object> saver2 = this.$itemSaver;
        List createListBuilder2 = CollectionsKt.createListBuilder();
        while (i < intValue2 + intValue3 + 3) {
            T restore2 = saver2.restore(list.get(i));
            Intrinsics.checkNotNull(restore2);
            createListBuilder2.add(restore2);
            i++;
        }
        return new UndoManager<>(build, CollectionsKt.build(createListBuilder2), intValue);
    }
}
