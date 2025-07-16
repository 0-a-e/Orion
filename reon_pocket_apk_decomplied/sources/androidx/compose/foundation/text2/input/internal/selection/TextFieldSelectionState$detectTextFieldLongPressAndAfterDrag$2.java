package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "dragStartOffset", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$2 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ Ref.ObjectRef<Handle> $actingHandle;
    final /* synthetic */ Ref.IntRef $dragBeginOffsetInText;
    final /* synthetic */ Ref.LongRef $dragBeginPosition;
    final /* synthetic */ Ref.LongRef $dragTotalDistance;
    final /* synthetic */ Function0<Unit> $requestFocus;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$2(Function0<Unit> function0, TextFieldSelectionState textFieldSelectionState, Ref.ObjectRef<Handle> objectRef, Ref.LongRef longRef, Ref.LongRef longRef2, Ref.IntRef intRef) {
        super(1);
        this.$requestFocus = function0;
        this.this$0 = textFieldSelectionState;
        this.$actingHandle = objectRef;
        this.$dragBeginPosition = longRef;
        this.$dragTotalDistance = longRef2;
        this.$dragBeginOffsetInText = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1468invokek4lQ0M(((Offset) obj).m3572unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m1468invokek4lQ0M(long j) {
        final long j2 = j;
        TextFieldSelectionStateKt.logDebug(new Function0<String>() {
            public final String invoke() {
                return "onDragStart after longPress " + Offset.m3570toStringimpl(j2);
            }
        });
        this.$requestFocus.invoke();
        this.this$0.m1459updateHandleDraggingUv8p0NA((Handle) this.$actingHandle.element, j2);
        this.$dragBeginPosition.element = j2;
        this.$dragTotalDistance.element = Offset.Companion.m3578getZeroF1C5BW0();
        this.this$0.previousRawDragOffset = -1;
        if (!this.this$0.textLayoutState.m1416isPositionOnTextk4lQ0M(j2)) {
            int r1 = TextLayoutState.m1413getOffsetForPosition3MmeM6k$default(this.this$0.textLayoutState, j, false, 2, (Object) null);
            HapticFeedback access$getHapticFeedBack$p = this.this$0.hapticFeedBack;
            if (access$getHapticFeedBack$p != null) {
                access$getHapticFeedBack$p.m4617performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4626getTextHandleMove5zf0vsI());
            }
            this.this$0.textFieldState.placeCursorBeforeCharAt(r1);
            this.this$0.setShowCursorHandle(true);
            this.this$0.updateTextToolbarState(TextToolbarState.Cursor);
        } else if (this.this$0.textFieldState.getText().length() != 0) {
            int r10 = TextLayoutState.m1413getOffsetForPosition3MmeM6k$default(this.this$0.textLayoutState, j, false, 2, (Object) null);
            TextFieldSelectionState textFieldSelectionState = this.this$0;
            long r12 = TextFieldSelectionState.m1461updateSelectionQNhciaU$default(textFieldSelectionState, TextFieldCharSequenceKt.m1348TextFieldCharSequence3r_uNRQ$default(textFieldSelectionState.textFieldState.getText(), TextRange.Companion.m6047getZerod9O1mEE(), (TextRange) null, 4, (Object) null), r10, r10, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), false, 32, (Object) null);
            this.this$0.textFieldState.m1429selectCharsIn5zctL8(r12);
            this.this$0.updateTextToolbarState(TextToolbarState.Selection);
            this.$dragBeginOffsetInText.element = TextRange.m6042getStartimpl(r12);
        }
    }
}
