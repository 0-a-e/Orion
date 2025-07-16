package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "delta", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectSelectionHandleDragGestures$5 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {
    final /* synthetic */ Ref.LongRef $dragBeginPosition;
    final /* synthetic */ Ref.LongRef $dragTotalDistance;
    final /* synthetic */ Handle $handle;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectSelectionHandleDragGestures$5(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Handle handle, Ref.LongRef longRef2, boolean z) {
        super(2);
        this.$dragTotalDistance = longRef;
        this.this$0 = textFieldSelectionState;
        this.$handle = handle;
        this.$dragBeginPosition = longRef2;
        this.$isStartHandle = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m1467invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m3572unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m1467invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
        int i;
        int i2;
        Ref.LongRef longRef = this.$dragTotalDistance;
        longRef.element = Offset.m3567plusMKHz9U(longRef.element, j);
        TextLayoutResult layoutResult = this.this$0.textLayoutState.getLayoutResult();
        if (layoutResult != null) {
            this.this$0.m1459updateHandleDraggingUv8p0NA(this.$handle, Offset.m3567plusMKHz9U(this.$dragBeginPosition.element, this.$dragTotalDistance.element));
            if (this.$isStartHandle) {
                i = layoutResult.m6014getOffsetForPositionk4lQ0M(this.this$0.m1462getHandleDragPositionF1C5BW0());
            } else {
                i = TextRange.m6042getStartimpl(this.this$0.textFieldState.getText().m1346getSelectionInCharsd9O1mEE());
            }
            int i3 = i;
            if (this.$isStartHandle) {
                i2 = TextRange.m6037getEndimpl(this.this$0.textFieldState.getText().m1346getSelectionInCharsd9O1mEE());
            } else {
                i2 = layoutResult.m6014getOffsetForPositionk4lQ0M(this.this$0.m1462getHandleDragPositionF1C5BW0());
            }
            int i4 = i2;
            long r10 = this.this$0.textFieldState.getText().m1346getSelectionInCharsd9O1mEE();
            TextFieldSelectionState textFieldSelectionState = this.this$0;
            long r0 = TextFieldSelectionState.m1461updateSelectionQNhciaU$default(textFieldSelectionState, textFieldSelectionState.textFieldState.getText(), i3, i4, this.$isStartHandle, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), false, 32, (Object) null);
            if (TextRange.m6036getCollapsedimpl(r10) || !TextRange.m6036getCollapsedimpl(r0)) {
                this.this$0.textFieldState.m1429selectCharsIn5zctL8(r0);
            }
        }
    }
}
