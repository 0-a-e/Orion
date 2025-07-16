package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "change", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "dragAmount", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectCursorHandleDragGestures$5 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {
    final /* synthetic */ Ref.LongRef $cursorDragDelta;
    final /* synthetic */ Ref.LongRef $cursorDragStart;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectCursorHandleDragGestures$5(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        super(2);
        this.$cursorDragDelta = longRef;
        this.this$0 = textFieldSelectionState;
        this.$cursorDragStart = longRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m1465invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m3572unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m1465invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
        Ref.LongRef longRef = this.$cursorDragDelta;
        longRef.element = Offset.m3567plusMKHz9U(longRef.element, j);
        this.this$0.m1459updateHandleDraggingUv8p0NA(Handle.Cursor, Offset.m3567plusMKHz9U(this.$cursorDragStart.element, this.$cursorDragDelta.element));
        TextLayoutResult layoutResult = this.this$0.textLayoutState.getLayoutResult();
        if (layoutResult != null) {
            long TextRange = TextRangeKt.TextRange(layoutResult.m6014getOffsetForPositionk4lQ0M(this.this$0.m1462getHandleDragPositionF1C5BW0()));
            if (!TextRange.m6035equalsimpl0(TextRange, this.this$0.textFieldState.getText().m1346getSelectionInCharsd9O1mEE())) {
                pointerInputChange.consume();
                HapticFeedback access$getHapticFeedBack$p = this.this$0.hapticFeedBack;
                if (access$getHapticFeedBack$p != null) {
                    access$getHapticFeedBack$p.m4617performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4626getTextHandleMove5zf0vsI());
                }
                this.this$0.textFieldState.m1429selectCharsIn5zctL8(TextRange);
            }
        }
    }
}
