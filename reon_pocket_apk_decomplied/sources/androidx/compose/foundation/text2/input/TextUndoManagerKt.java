package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text.UndoManagerKt;
import androidx.compose.foundation.text2.input.TextFieldBuffer;
import androidx.compose.foundation.text2.input.internal.undo.TextDeleteType;
import androidx.compose.foundation.text2.input.internal.undo.TextEditType;
import androidx.compose.foundation.text2.input.internal.undo.TextUndoOperation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a.\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0011"}, d2 = {"TEXT_UNDO_CAPACITY", "", "isNewLineInsert", "", "Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;", "(Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;)Z", "merge", "next", "recordChanges", "", "Landroidx/compose/foundation/text2/input/TextUndoManager;", "pre", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "post", "changes", "Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "allowMerge", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextUndoManager.kt */
public final class TextUndoManagerKt {
    private static final int TEXT_UNDO_CAPACITY = 100;

    public static final TextUndoOperation merge(TextUndoOperation textUndoOperation, TextUndoOperation textUndoOperation2) {
        if (!textUndoOperation.getCanMerge() || !textUndoOperation2.getCanMerge() || textUndoOperation2.getTimeInMillis() < textUndoOperation.getTimeInMillis() || textUndoOperation2.getTimeInMillis() - textUndoOperation.getTimeInMillis() >= ((long) UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS()) || isNewLineInsert(textUndoOperation) || isNewLineInsert(textUndoOperation2) || textUndoOperation.getTextEditType() != textUndoOperation2.getTextEditType()) {
            return null;
        }
        if (textUndoOperation.getTextEditType() == TextEditType.Insert && textUndoOperation.getIndex() + textUndoOperation.getPostText().length() == textUndoOperation2.getIndex()) {
            int index = textUndoOperation.getIndex();
            return new TextUndoOperation(index, "", textUndoOperation.getPostText() + textUndoOperation2.getPostText(), textUndoOperation.m1476getPreSelectiond9O1mEE(), textUndoOperation2.m1475getPostSelectiond9O1mEE(), textUndoOperation.getTimeInMillis(), false, 64, (DefaultConstructorMarker) null);
        }
        if (textUndoOperation.getTextEditType() == TextEditType.Delete && textUndoOperation.getDeletionType() == textUndoOperation2.getDeletionType() && (textUndoOperation.getDeletionType() == TextDeleteType.Start || textUndoOperation.getDeletionType() == TextDeleteType.End)) {
            if (textUndoOperation.getIndex() == textUndoOperation2.getIndex() + textUndoOperation2.getPreText().length()) {
                int index2 = textUndoOperation2.getIndex();
                return new TextUndoOperation(index2, textUndoOperation2.getPreText() + textUndoOperation.getPreText(), "", textUndoOperation.m1476getPreSelectiond9O1mEE(), textUndoOperation2.m1475getPostSelectiond9O1mEE(), textUndoOperation.getTimeInMillis(), false, 64, (DefaultConstructorMarker) null);
            } else if (textUndoOperation.getIndex() == textUndoOperation2.getIndex()) {
                int index3 = textUndoOperation.getIndex();
                return new TextUndoOperation(index3, textUndoOperation.getPreText() + textUndoOperation2.getPreText(), "", textUndoOperation.m1476getPreSelectiond9O1mEE(), textUndoOperation2.m1475getPostSelectiond9O1mEE(), textUndoOperation.getTimeInMillis(), false, 64, (DefaultConstructorMarker) null);
            }
        }
        return null;
    }

    public static /* synthetic */ void recordChanges$default(TextUndoManager textUndoManager, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        recordChanges(textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, z);
    }

    public static final void recordChanges(TextUndoManager textUndoManager, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, boolean z) {
        TextUndoManager textUndoManager2 = textUndoManager;
        TextFieldBuffer.ChangeList changeList2 = changeList;
        if (changeList.getChangeCount() > 1) {
            textUndoManager2.record(new TextUndoOperation(0, textFieldCharSequence.toString(), textFieldCharSequence2.toString(), textFieldCharSequence.m1346getSelectionInCharsd9O1mEE(), textFieldCharSequence2.m1346getSelectionInCharsd9O1mEE(), 0, false, 32, (DefaultConstructorMarker) null));
        } else if (changeList.getChangeCount() == 1) {
            long r3 = changeList2.m1343getOriginalRangejx7JFs(0);
            long r1 = changeList2.m1344getRangejx7JFs(0);
            if (!TextRange.m6036getCollapsedimpl(r3) || !TextRange.m6036getCollapsedimpl(r1)) {
                textUndoManager2.record(new TextUndoOperation(TextRange.m6040getMinimpl(r3), TextRangeKt.m6049substringFDrldGo(textFieldCharSequence, r3), TextRangeKt.m6049substringFDrldGo(textFieldCharSequence2, r1), textFieldCharSequence.m1346getSelectionInCharsd9O1mEE(), textFieldCharSequence2.m1346getSelectionInCharsd9O1mEE(), 0, z, 32, (DefaultConstructorMarker) null));
            }
        }
    }

    private static final boolean isNewLineInsert(TextUndoOperation textUndoOperation) {
        return Intrinsics.areEqual((Object) textUndoOperation.getPostText(), (Object) "\n") || Intrinsics.areEqual((Object) textUndoOperation.getPostText(), (Object) "\r\n");
    }
}
