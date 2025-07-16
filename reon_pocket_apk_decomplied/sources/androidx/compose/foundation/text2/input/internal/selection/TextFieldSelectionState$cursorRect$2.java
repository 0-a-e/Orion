package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Rect;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$cursorRect$2 extends Lambda implements Function0<Rect> {
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$cursorRect$2(TextFieldSelectionState textFieldSelectionState) {
        super(0);
        this.this$0 = textFieldSelectionState;
    }

    public final Rect invoke() {
        float f;
        TextLayoutResult layoutResult = this.this$0.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.Companion.getZero();
        }
        TextFieldCharSequence text = this.this$0.textFieldState.getText();
        if (!TextRange.m6036getCollapsedimpl(text.m1346getSelectionInCharsd9O1mEE())) {
            return Rect.Companion.getZero();
        }
        Rect cursorRect = layoutResult.getCursorRect(TextRange.m6042getStartimpl(text.m1346getSelectionInCharsd9O1mEE()));
        float r2 = this.this$0.density.m6550toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
            f = cursorRect.getLeft() + (r2 / ((float) 2));
        } else {
            f = cursorRect.getRight() - (r2 / ((float) 2));
        }
        float f2 = r2 / ((float) 2);
        float coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(f, ((float) IntSize.m6790getWidthimpl(layoutResult.m6015getSizeYbymL2g())) - f2), f2);
        return new Rect(coerceAtLeast - f2, cursorRect.getTop(), coerceAtLeast + f2, cursorRect.getBottom());
    }
}
