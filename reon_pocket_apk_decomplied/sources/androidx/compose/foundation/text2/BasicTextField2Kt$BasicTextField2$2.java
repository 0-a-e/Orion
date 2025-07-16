package androidx.compose.foundation.text2;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldLineLimits;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField2.kt */
final class BasicTextField2Kt$BasicTextField2$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ CodepointTransformation $codepointTransformation;
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ TextFieldDecorator $decorator;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InputTransformation $inputTransformation;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ TextFieldLineLimits $lineLimits;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
    final /* synthetic */ Function1<String, Unit> $onValueChange;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ String $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextField2Kt$BasicTextField2$2(String str, Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, int i, int i2, int i3) {
        super(2);
        this.$value = str;
        this.$onValueChange = function1;
        this.$modifier = modifier;
        this.$enabled = z;
        this.$readOnly = z2;
        this.$inputTransformation = inputTransformation;
        this.$textStyle = textStyle;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$lineLimits = textFieldLineLimits;
        this.$onTextLayout = function2;
        this.$interactionSource = mutableInteractionSource;
        this.$cursorBrush = brush;
        this.$codepointTransformation = codepointTransformation;
        this.$decorator = textFieldDecorator;
        this.$scrollState = scrollState;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        String str = this.$value;
        String str2 = str;
        BasicTextField2Kt.BasicTextField2(str2, this.$onValueChange, this.$modifier, this.$enabled, this.$readOnly, this.$inputTransformation, this.$textStyle, this.$keyboardOptions, this.$keyboardActions, this.$lineLimits, this.$onTextLayout, this.$interactionSource, this.$cursorBrush, this.$codepointTransformation, this.$decorator, this.$scrollState, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
