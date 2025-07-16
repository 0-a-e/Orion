package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $container;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ TextFieldType $type;
    final /* synthetic */ String $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$4(TextFieldType textFieldType, String str, Function2<? super Composer, ? super Integer, Unit> function2, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2<? super Composer, ? super Integer, Unit> function29, int i, int i2, int i3) {
        super(2);
        this.$type = textFieldType;
        this.$value = str;
        this.$innerTextField = function2;
        this.$visualTransformation = visualTransformation;
        this.$label = function22;
        this.$placeholder = function23;
        this.$leadingIcon = function24;
        this.$trailingIcon = function25;
        this.$prefix = function26;
        this.$suffix = function27;
        this.$supportingText = function28;
        this.$singleLine = z;
        this.$enabled = z2;
        this.$isError = z3;
        this.$interactionSource = interactionSource;
        this.$contentPadding = paddingValues;
        this.$colors = textFieldColors;
        this.$container = function29;
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
        TextFieldType textFieldType = this.$type;
        TextFieldType textFieldType2 = textFieldType;
        TextFieldImplKt.CommonDecorationBox(textFieldType2, this.$value, this.$innerTextField, this.$visualTransformation, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$prefix, this.$suffix, this.$supportingText, this.$singleLine, this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$container, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
