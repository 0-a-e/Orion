package androidx.compose.foundation.text2;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text2.input.ImeActionHandler;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
final class BasicSecureTextFieldKt$BasicSecureTextField$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ TextFieldDecorator $decorator;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ int $imeAction;
    final /* synthetic */ InputTransformation $inputTransformation;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ int $keyboardType;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ ImeActionHandler $onSubmit;
    final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ int $textObfuscationMode;
    final /* synthetic */ TextStyle $textStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicSecureTextFieldKt$BasicSecureTextField$4(TextFieldState textFieldState, Modifier modifier, ImeActionHandler imeActionHandler, int i, int i2, int i3, boolean z, InputTransformation inputTransformation, TextStyle textStyle, MutableInteractionSource mutableInteractionSource, Brush brush, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, TextFieldDecorator textFieldDecorator, ScrollState scrollState, int i4, int i5, int i6) {
        super(2);
        this.$state = textFieldState;
        this.$modifier = modifier;
        this.$onSubmit = imeActionHandler;
        this.$imeAction = i;
        this.$textObfuscationMode = i2;
        this.$keyboardType = i3;
        this.$enabled = z;
        this.$inputTransformation = inputTransformation;
        this.$textStyle = textStyle;
        this.$interactionSource = mutableInteractionSource;
        this.$cursorBrush = brush;
        this.$onTextLayout = function2;
        this.$decorator = textFieldDecorator;
        this.$scrollState = scrollState;
        this.$$changed = i4;
        this.$$changed1 = i5;
        this.$$default = i6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        TextFieldState textFieldState = this.$state;
        TextFieldState textFieldState2 = textFieldState;
        BasicSecureTextFieldKt.m1326BasicSecureTextFieldmMrxcSU(textFieldState2, this.$modifier, this.$onSubmit, this.$imeAction, this.$textObfuscationMode, this.$keyboardType, this.$enabled, this.$inputTransformation, this.$textStyle, this.$interactionSource, this.$cursorBrush, this.$onTextLayout, this.$decorator, this.$scrollState, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
