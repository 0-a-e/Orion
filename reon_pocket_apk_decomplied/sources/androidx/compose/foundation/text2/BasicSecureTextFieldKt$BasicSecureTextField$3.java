package androidx.compose.foundation.text2;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.foundation.text2.input.ImeActionHandler;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.InputTransformationKt;
import androidx.compose.foundation.text2.input.TextFieldLineLimits;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
final class BasicSecureTextFieldKt$BasicSecureTextField$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CodepointTransformation $codepointTransformation;
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ TextFieldDecorator $decorator;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ int $imeAction;
    final /* synthetic */ InputTransformation $inputTransformation;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ int $keyboardType;
    final /* synthetic */ ImeActionHandler $onSubmit;
    final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
    final /* synthetic */ boolean $revealLastTypedEnabled;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ SecureTextFieldController $secureTextFieldController;
    final /* synthetic */ Modifier $secureTextFieldModifier;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextStyle $textStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicSecureTextFieldKt$BasicSecureTextField$3(boolean z, InputTransformation inputTransformation, SecureTextFieldController secureTextFieldController, int i, int i2, ImeActionHandler imeActionHandler, TextFieldState textFieldState, Modifier modifier, boolean z2, TextStyle textStyle, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState) {
        super(2);
        this.$revealLastTypedEnabled = z;
        this.$inputTransformation = inputTransformation;
        this.$secureTextFieldController = secureTextFieldController;
        this.$keyboardType = i;
        this.$imeAction = i2;
        this.$onSubmit = imeActionHandler;
        this.$state = textFieldState;
        this.$secureTextFieldModifier = modifier;
        this.$enabled = z2;
        this.$textStyle = textStyle;
        this.$onTextLayout = function2;
        this.$interactionSource = mutableInteractionSource;
        this.$cursorBrush = brush;
        this.$codepointTransformation = codepointTransformation;
        this.$decorator = textFieldDecorator;
        this.$scrollState = scrollState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        InputTransformation inputTransformation;
        KeyboardActions keyboardActions;
        int i2 = i;
        ComposerKt.sourceInformation(composer, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
        if ((i2 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415093334, i2, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
            }
            if (this.$revealLastTypedEnabled) {
                inputTransformation = InputTransformationKt.thenOrNull(this.$inputTransformation, this.$secureTextFieldController.getPasswordRevealFilter());
            } else {
                inputTransformation = this.$inputTransformation;
            }
            InputTransformation inputTransformation2 = inputTransformation;
            TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, this.$keyboardType, this.$imeAction, (PlatformImeOptions) null, 17, (DefaultConstructorMarker) null);
            ImeActionHandler imeActionHandler = this.$onSubmit;
            if (imeActionHandler == null || (keyboardActions = BasicSecureTextFieldKt.KeyboardActions(new BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(imeActionHandler))) == null) {
                keyboardActions = KeyboardActions.Companion.getDefault();
            }
            BasicTextField2Kt.BasicTextField2(this.$state, this.$secureTextFieldModifier, this.$enabled, false, inputTransformation2, this.$textStyle, keyboardOptions, keyboardActions, singleLine, this.$onTextLayout, this.$interactionSource, this.$cursorBrush, this.$codepointTransformation, this.$decorator, this.$scrollState, composer, 100666368, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
