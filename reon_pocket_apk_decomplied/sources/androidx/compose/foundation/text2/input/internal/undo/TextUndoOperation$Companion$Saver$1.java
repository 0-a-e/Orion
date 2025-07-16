package androidx.compose.foundation.text2.input.internal.undo;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"androidx/compose/foundation/text2/input/internal/undo/TextUndoOperation$Companion$Saver$1", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;", "", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextUndoOperation.kt */
public final class TextUndoOperation$Companion$Saver$1 implements Saver<TextUndoOperation, Object> {
    TextUndoOperation$Companion$Saver$1() {
    }

    public Object save(SaverScope saverScope, TextUndoOperation textUndoOperation) {
        return CollectionsKt.listOf(Integer.valueOf(textUndoOperation.getIndex()), textUndoOperation.getPreText(), textUndoOperation.getPostText(), Integer.valueOf(TextRange.m6042getStartimpl(textUndoOperation.m1476getPreSelectiond9O1mEE())), Integer.valueOf(TextRange.m6037getEndimpl(textUndoOperation.m1476getPreSelectiond9O1mEE())), Integer.valueOf(TextRange.m6042getStartimpl(textUndoOperation.m1475getPostSelectiond9O1mEE())), Integer.valueOf(TextRange.m6037getEndimpl(textUndoOperation.m1475getPostSelectiond9O1mEE())), Long.valueOf(textUndoOperation.getTimeInMillis()));
    }

    public TextUndoOperation restore(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj2).intValue();
        Object obj3 = list.get(1);
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        Object obj4 = list.get(2);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
        Object obj5 = list.get(3);
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
        int intValue2 = ((Integer) obj5).intValue();
        Object obj6 = list.get(4);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
        long TextRange = TextRangeKt.TextRange(intValue2, ((Integer) obj6).intValue());
        Object obj7 = list.get(5);
        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
        int intValue3 = ((Integer) obj7).intValue();
        Object obj8 = list.get(6);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Int");
        long TextRange2 = TextRangeKt.TextRange(intValue3, ((Integer) obj8).intValue());
        Object obj9 = list.get(7);
        Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Long");
        return new TextUndoOperation(intValue, (String) obj3, (String) obj4, TextRange, TextRange2, ((Long) obj9).longValue(), false, 64, (DefaultConstructorMarker) null);
    }
}
