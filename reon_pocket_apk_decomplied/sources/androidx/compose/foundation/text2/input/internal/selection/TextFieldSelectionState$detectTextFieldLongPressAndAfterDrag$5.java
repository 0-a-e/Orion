package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "dragAmount", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$5 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {
    final /* synthetic */ Ref.ObjectRef<Handle> $actingHandle;
    final /* synthetic */ Ref.IntRef $dragBeginOffsetInText;
    final /* synthetic */ Ref.LongRef $dragBeginPosition;
    final /* synthetic */ Ref.LongRef $dragTotalDistance;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$5(TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef, Ref.LongRef longRef2, Ref.IntRef intRef, Ref.ObjectRef<Handle> objectRef) {
        super(2);
        this.this$0 = textFieldSelectionState;
        this.$dragTotalDistance = longRef;
        this.$dragBeginPosition = longRef2;
        this.$dragBeginOffsetInText = intRef;
        this.$actingHandle = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m1469invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m3572unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m1469invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
        int i;
        int r0;
        SelectionAdjustment word;
        T t;
        if (this.this$0.textFieldState.getText().length() != 0) {
            Ref.LongRef longRef = this.$dragTotalDistance;
            longRef.element = Offset.m3567plusMKHz9U(longRef.element, j);
            final long r10 = Offset.m3567plusMKHz9U(this.$dragBeginPosition.element, this.$dragTotalDistance.element);
            TextFieldSelectionStateKt.logDebug(new Function0<String>() {
                public final String invoke() {
                    return "onDrag after longPress " + Offset.m3570toStringimpl(r10);
                }
            });
            if (this.$dragBeginOffsetInText.element >= 0 || this.this$0.textLayoutState.m1416isPositionOnTextk4lQ0M(r10)) {
                Integer valueOf = Integer.valueOf(this.$dragBeginOffsetInText.element);
                if (valueOf.intValue() < 0) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    i = valueOf.intValue();
                } else {
                    i = this.this$0.textLayoutState.m1415getOffsetForPosition3MmeM6k(this.$dragBeginPosition.element, false);
                }
                r0 = this.this$0.textLayoutState.m1415getOffsetForPosition3MmeM6k(r10, false);
                if (this.$dragBeginOffsetInText.element >= 0 || i != r0) {
                    word = SelectionAdjustment.Companion.getWord();
                } else {
                    return;
                }
            } else {
                i = TextLayoutState.m1413getOffsetForPosition3MmeM6k$default(this.this$0.textLayoutState, this.$dragBeginPosition.element, false, 2, (Object) null);
                r0 = TextLayoutState.m1413getOffsetForPosition3MmeM6k$default(this.this$0.textLayoutState, r10, false, 2, (Object) null);
                if (i == r0) {
                    word = SelectionAdjustment.Companion.getNone();
                } else {
                    word = SelectionAdjustment.Companion.getWord();
                }
            }
            int i2 = i;
            int i3 = r0;
            SelectionAdjustment selectionAdjustment = word;
            long r02 = this.this$0.textFieldState.getText().m1346getSelectionInCharsd9O1mEE();
            TextFieldSelectionState textFieldSelectionState = this.this$0;
            long r2 = textFieldSelectionState.m1460updateSelectionQNhciaU(textFieldSelectionState.textFieldState.getText(), i2, i3, false, selectionAdjustment, false);
            if (TextRange.m6041getReversedimpl(r2)) {
                r2 = TextFieldSelectionStateKt.m1474reverse5zctL8(r2);
            }
            if (this.$dragBeginOffsetInText.element == -1 && !TextRange.m6036getCollapsedimpl(r2)) {
                this.$dragBeginOffsetInText.element = TextRange.m6042getStartimpl(r2);
            }
            if (!TextRange.m6035equalsimpl0(r2, r02)) {
                Ref.ObjectRef<Handle> objectRef = this.$actingHandle;
                if (TextRange.m6042getStartimpl(r2) != TextRange.m6042getStartimpl(r02) && TextRange.m6037getEndimpl(r2) == TextRange.m6037getEndimpl(r02)) {
                    t = Handle.SelectionStart;
                } else if (TextRange.m6042getStartimpl(r2) == TextRange.m6042getStartimpl(r02) && TextRange.m6037getEndimpl(r2) != TextRange.m6037getEndimpl(r02)) {
                    t = Handle.SelectionEnd;
                } else if (((float) (TextRange.m6042getStartimpl(r2) + TextRange.m6037getEndimpl(r2))) / 2.0f > ((float) (TextRange.m6042getStartimpl(r02) + TextRange.m6037getEndimpl(r02))) / 2.0f) {
                    t = Handle.SelectionEnd;
                } else {
                    t = Handle.SelectionStart;
                }
                objectRef.element = t;
            }
            if (TextRange.m6036getCollapsedimpl(r02) || !TextRange.m6036getCollapsedimpl(r2)) {
                this.this$0.textFieldState.m1429selectCharsIn5zctL8(r2);
            }
            this.this$0.m1459updateHandleDraggingUv8p0NA((Handle) this.$actingHandle.element, r10);
        }
    }
}
