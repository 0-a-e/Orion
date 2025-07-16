package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\f"}, d2 = {"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isStart", "", "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "getHorizontalPosition", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextSelectionDelegate.kt */
public final class TextSelectionDelegateKt {
    public static final long getSelectionHandleCoordinates(TextLayoutResult textLayoutResult, int i, boolean z, boolean z2) {
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        return OffsetKt.Offset(getHorizontalPosition(textLayoutResult, i, z, z2), textLayoutResult.getLineBottom(lineForOffset));
    }

    public static final float getHorizontalPosition(TextLayoutResult textLayoutResult, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (textLayoutResult.getBidiRunDirection(((!z || z2) && (z || !z2)) ? Math.max(i - 1, 0) : i) == textLayoutResult.getParagraphDirection(i)) {
            z3 = true;
        }
        return textLayoutResult.getHorizontalPosition(i, z3);
    }
}
