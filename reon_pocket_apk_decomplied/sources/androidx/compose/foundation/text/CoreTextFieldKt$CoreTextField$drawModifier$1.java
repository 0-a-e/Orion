package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$drawModifier$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$drawModifier$1(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(1);
        this.$state = textFieldState;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
        if (layoutResult != null) {
            TextFieldValue textFieldValue = this.$value;
            OffsetMapping offsetMapping = this.$offsetMapping;
            TextFieldState textFieldState = this.$state;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            TextFieldDelegate.Companion.draw$foundation_release(canvas, textFieldValue, offsetMapping, layoutResult.getValue(), textFieldState.getSelectionPaint());
        }
    }
}
