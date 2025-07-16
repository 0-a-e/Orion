package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\bJ\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$handleDragObserver$1 implements TextDragObserver {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ TextFieldSelectionManager this$0;

    public void onCancel() {
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1310onStartk4lQ0M(long j) {
    }

    TextFieldSelectionManager$handleDragObserver$1(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        this.this$0 = textFieldSelectionManager;
        this.$isStartHandle = z;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1308onDownk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        this.this$0.setDraggingHandle(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        long r3 = SelectionHandlesKt.m1237getAdjustedCoordinatesk4lQ0M(this.this$0.m1304getHandlePositiontuRUvjQ$foundation_release(this.$isStartHandle));
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null) {
            long r32 = layoutResult.m1156translateInnerToDecorationCoordinatesMKHz9U$foundation_release(r3);
            this.this$0.dragBeginPosition = r32;
            this.this$0.m1298setCurrentDragPosition_kEHs6E(Offset.m3551boximpl(r32));
            this.this$0.dragTotalDistance = Offset.Companion.m3578getZeroF1C5BW0();
            this.this$0.previousRawDragOffset = -1;
            TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
            if (state$foundation_release2 != null) {
                state$foundation_release2.setInTouchMode(true);
            }
            this.this$0.updateFloatingToolbar(false);
        }
    }

    public void onUp() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1298setCurrentDragPosition_kEHs6E((Offset) null);
        this.this$0.updateFloatingToolbar(true);
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1309onDragk4lQ0M(long j) {
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragTotalDistance = Offset.m3567plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
        textFieldSelectionManager2.m1298setCurrentDragPosition_kEHs6E(Offset.m3551boximpl(Offset.m3567plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, this.this$0.dragTotalDistance)));
        TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
        TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
        Offset r9 = this.this$0.m1302getCurrentDragPosition_m7T9E();
        Intrinsics.checkNotNull(r9);
        long unused = textFieldSelectionManager3.m1299updateSelection8UEBfa8(value$foundation_release, r9.m3572unboximpl(), false, this.$isStartHandle, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), true);
        this.this$0.updateFloatingToolbar(false);
    }

    public void onStop() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1298setCurrentDragPosition_kEHs6E((Offset) null);
        this.this$0.updateFloatingToolbar(true);
    }
}
