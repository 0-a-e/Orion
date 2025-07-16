package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\bJ\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$touchSelectionObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$touchSelectionObserver$1 implements TextDragObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    public void onCancel() {
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1315onDownk4lQ0M(long j) {
    }

    public void onUp() {
    }

    TextFieldSelectionManager$touchSelectionObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.this$0 = textFieldSelectionManager;
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1317onStartk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResultProxy layoutResult2;
        if (this.this$0.getDraggingHandle() == null) {
            this.this$0.setDraggingHandle(Handle.SelectionEnd);
            this.this$0.previousRawDragOffset = -1;
            this.this$0.hideSelectionToolbar$foundation_release();
            TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
            if (state$foundation_release == null || (layoutResult2 = state$foundation_release.getLayoutResult()) == null || !layoutResult2.m1154isPositionOnTextk4lQ0M(j)) {
                TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
                if (!(state$foundation_release2 == null || (layoutResult = state$foundation_release2.getLayoutResult()) == null)) {
                    TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                    int transformedToOriginal = textFieldSelectionManager.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.m1152getOffsetForPosition3MmeM6k$default(layoutResult, j, false, 2, (Object) null));
                    TextFieldValue r2 = textFieldSelectionManager.m1296createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                    textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                    textFieldSelectionManager.setHandleState(HandleState.Cursor);
                    HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                    if (hapticFeedBack != null) {
                        hapticFeedBack.m4617performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4626getTextHandleMove5zf0vsI());
                    }
                    textFieldSelectionManager.getOnValueChange$foundation_release().invoke(r2);
                }
            } else if (this.this$0.getValue$foundation_release().getText().length() != 0) {
                this.this$0.enterSelectionMode$foundation_release(false);
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                this.this$0.dragBeginOffsetInText = Integer.valueOf(TextRange.m6042getStartimpl(textFieldSelectionManager2.m1299updateSelection8UEBfa8(TextFieldValue.m6294copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.Companion.m6047getZerod9O1mEE(), (TextRange) null, 5, (Object) null), j, true, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), true)));
            } else {
                return;
            }
            this.this$0.dragBeginPosition = j;
            TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
            textFieldSelectionManager3.m1298setCurrentDragPosition_kEHs6E(Offset.m3551boximpl(textFieldSelectionManager3.dragBeginPosition));
            this.this$0.dragTotalDistance = Offset.Companion.m3578getZeroF1C5BW0();
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1316onDragk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        long j2;
        SelectionAdjustment selectionAdjustment;
        if (this.this$0.getValue$foundation_release().getText().length() != 0) {
            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
            textFieldSelectionManager.dragTotalDistance = Offset.m3567plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
            TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null)) {
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m1298setCurrentDragPosition_kEHs6E(Offset.m3551boximpl(Offset.m3567plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                if (textFieldSelectionManager2.dragBeginOffsetInText == null) {
                    Offset r0 = textFieldSelectionManager2.m1302getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(r0);
                    if (!layoutResult.m1154isPositionOnTextk4lQ0M(r0.m3572unboximpl())) {
                        int transformedToOriginal = textFieldSelectionManager2.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.m1152getOffsetForPosition3MmeM6k$default(layoutResult, textFieldSelectionManager2.dragBeginPosition, false, 2, (Object) null));
                        OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                        Offset r02 = textFieldSelectionManager2.m1302getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(r02);
                        if (transformedToOriginal == offsetMapping$foundation_release.transformedToOriginal(TextLayoutResultProxy.m1152getOffsetForPosition3MmeM6k$default(layoutResult, r02.m3572unboximpl(), false, 2, (Object) null))) {
                            selectionAdjustment = SelectionAdjustment.Companion.getNone();
                        } else {
                            selectionAdjustment = SelectionAdjustment.Companion.getCharacterWithWordAccelerate();
                        }
                        TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                        Offset r03 = textFieldSelectionManager2.m1302getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(r03);
                        j2 = textFieldSelectionManager2.m1299updateSelection8UEBfa8(value$foundation_release, r03.m3572unboximpl(), false, false, selectionAdjustment, true);
                        TextRange.m6030boximpl(j2);
                    }
                }
                Integer access$getDragBeginOffsetInText$p = textFieldSelectionManager2.dragBeginOffsetInText;
                int intValue = access$getDragBeginOffsetInText$p != null ? access$getDragBeginOffsetInText$p.intValue() : layoutResult.m1153getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false);
                Offset r1 = textFieldSelectionManager2.m1302getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r1);
                int r10 = layoutResult.m1153getOffsetForPosition3MmeM6k(r1.m3572unboximpl(), false);
                if (textFieldSelectionManager2.dragBeginOffsetInText != null || intValue != r10) {
                    TextFieldValue value$foundation_release2 = textFieldSelectionManager2.getValue$foundation_release();
                    Offset r102 = textFieldSelectionManager2.m1302getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(r102);
                    j2 = textFieldSelectionManager2.m1299updateSelection8UEBfa8(value$foundation_release2, r102.m3572unboximpl(), false, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), true);
                    TextRange.m6030boximpl(j2);
                } else {
                    return;
                }
            }
            this.this$0.updateFloatingToolbar(false);
        }
    }

    public void onStop() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1298setCurrentDragPosition_kEHs6E((Offset) null);
        this.this$0.updateFloatingToolbar(true);
        this.this$0.dragBeginOffsetInText = null;
    }
}
