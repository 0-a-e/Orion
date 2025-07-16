package androidx.compose.foundation.text2.input.internal.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.IntRef $dragBeginOffsetInText;
    final /* synthetic */ Ref.LongRef $dragBeginPosition;
    final /* synthetic */ Ref.LongRef $dragTotalDistance;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$3(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.IntRef intRef, Ref.LongRef longRef2) {
        super(0);
        this.$dragBeginPosition = longRef;
        this.this$0 = textFieldSelectionState;
        this.$dragBeginOffsetInText = intRef;
        this.$dragTotalDistance = longRef2;
    }

    public final void invoke() {
        TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$1(this.$dragBeginPosition, this.this$0, this.$dragBeginOffsetInText, this.$dragTotalDistance);
    }
}
