package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectSelectionHandleDragGestures$2 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ Ref.LongRef $dragBeginPosition;
    final /* synthetic */ Ref.LongRef $dragTotalDistance;
    final /* synthetic */ Handle $handle;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectSelectionHandleDragGestures$2(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, boolean z, Handle handle, Ref.LongRef longRef2) {
        super(1);
        this.$dragBeginPosition = longRef;
        this.this$0 = textFieldSelectionState;
        this.$isStartHandle = z;
        this.$handle = handle;
        this.$dragTotalDistance = longRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1466invokek4lQ0M(((Offset) obj).m3572unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m1466invokek4lQ0M(long j) {
        this.$dragBeginPosition.element = SelectionHandlesKt.m1237getAdjustedCoordinatesk4lQ0M(this.this$0.m1453getHandlePositiontuRUvjQ(this.$isStartHandle));
        this.this$0.m1459updateHandleDraggingUv8p0NA(this.$handle, this.$dragBeginPosition.element);
        this.$dragTotalDistance.element = Offset.Companion.m3578getZeroF1C5BW0();
        this.this$0.previousRawDragOffset = -1;
    }
}
