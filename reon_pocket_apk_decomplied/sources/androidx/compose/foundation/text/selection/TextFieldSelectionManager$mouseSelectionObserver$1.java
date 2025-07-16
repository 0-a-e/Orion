package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\"\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$mouseSelectionObserver$1", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "onDrag", "", "dragPosition", "Landroidx/compose/ui/geometry/Offset;", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onDragDone", "", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$mouseSelectionObserver$1 implements MouseSelectionObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    public void onDragDone() {
    }

    TextFieldSelectionManager$mouseSelectionObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.this$0 = textFieldSelectionManager;
    }

    /* renamed from: onExtend-k-4lQ0M  reason: not valid java name */
    public boolean m1312onExtendk4lQ0M(long j) {
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release == null || state$foundation_release.getLayoutResult() == null) {
            return false;
        }
        this.this$0.previousRawDragOffset = -1;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        long unused = textFieldSelectionManager.m1299updateSelection8UEBfa8(textFieldSelectionManager.getValue$foundation_release(), j, false, false, SelectionAdjustment.Companion.getNone(), false);
        return true;
    }

    /* renamed from: onExtendDrag-k-4lQ0M  reason: not valid java name */
    public boolean m1313onExtendDragk4lQ0M(long j) {
        TextFieldState state$foundation_release;
        if (this.this$0.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = this.this$0.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        long unused = textFieldSelectionManager.m1299updateSelection8UEBfa8(textFieldSelectionManager.getValue$foundation_release(), j, false, false, SelectionAdjustment.Companion.getNone(), false);
        return true;
    }

    /* renamed from: onStart-3MmeM6k  reason: not valid java name */
    public boolean m1314onStart3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
        TextFieldState state$foundation_release;
        if (this.this$0.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = this.this$0.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
            return false;
        }
        FocusRequester focusRequester = this.this$0.getFocusRequester();
        if (focusRequester != null) {
            focusRequester.requestFocus();
        }
        this.this$0.dragBeginPosition = j;
        this.this$0.previousRawDragOffset = -1;
        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(this.this$0, false, 1, (Object) null);
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        long unused = textFieldSelectionManager.m1299updateSelection8UEBfa8(textFieldSelectionManager.getValue$foundation_release(), this.this$0.dragBeginPosition, true, false, selectionAdjustment, false);
        return true;
    }

    /* renamed from: onDrag-3MmeM6k  reason: not valid java name */
    public boolean m1311onDrag3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
        TextFieldState state$foundation_release;
        if (this.this$0.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = this.this$0.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        long unused = textFieldSelectionManager.m1299updateSelection8UEBfa8(textFieldSelectionManager.getValue$foundation_release(), j, false, false, selectionAdjustment, false);
        return true;
    }
}
