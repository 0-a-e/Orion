package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
final class TextFieldDefaults$TextFieldDecorationBox$4 extends Lambda implements Function2<Composer, Integer, Unit> {
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
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ TextFieldDefaults $tmp0_rcvr;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDefaults$TextFieldDecorationBox$4(TextFieldDefaults textFieldDefaults, String str, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function27, int i, int i2, int i3) {
        super(2);
        this.$tmp0_rcvr = textFieldDefaults;
        this.$value = str;
        this.$innerTextField = function2;
        this.$enabled = z;
        this.$singleLine = z2;
        this.$visualTransformation = visualTransformation;
        this.$interactionSource = interactionSource;
        this.$isError = z3;
        this.$label = function22;
        this.$placeholder = function23;
        this.$leadingIcon = function24;
        this.$trailingIcon = function25;
        this.$supportingText = function26;
        this.$shape = shape;
        this.$colors = textFieldColors;
        this.$contentPadding = paddingValues;
        this.$container = function27;
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
        TextFieldDefaults textFieldDefaults = this.$tmp0_rcvr;
        TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
        textFieldDefaults2.TextFieldDecorationBox(this.$value, this.$innerTextField, this.$enabled, this.$singleLine, this.$visualTransformation, this.$interactionSource, this.$isError, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$supportingText, this.$shape, this.$colors, this.$contentPadding, this.$container, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
