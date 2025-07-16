package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$TextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ TextStyle $mergedTextStyle;
    final /* synthetic */ int $minLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$TextField$5(Modifier modifier, boolean z, TextFieldColors textFieldColors, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Shape shape) {
        super(2);
        this.$modifier = modifier;
        this.$isError = z;
        this.$colors = textFieldColors;
        this.$value = textFieldValue;
        this.$onValueChange = function1;
        this.$enabled = z2;
        this.$readOnly = z3;
        this.$mergedTextStyle = textStyle;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$singleLine = z4;
        this.$maxLines = i;
        this.$minLines = i2;
        this.$visualTransformation = visualTransformation;
        this.$interactionSource = mutableInteractionSource;
        this.$label = function2;
        this.$placeholder = function22;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$prefix = function25;
        this.$suffix = function26;
        this.$supportingText = function27;
        this.$shape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C349@18647L38,358@19050L20,346@18524L1819:TextField.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1163788208, i2, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:346)");
            }
            Modifier modifier = this.$modifier;
            boolean z = this.$isError;
            Strings.Companion companion = Strings.Companion;
            Modifier r3 = SizeKt.m726defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier, z, Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.default_error_message), composer2, 0)), TextFieldDefaults.INSTANCE.m2431getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2430getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(this.$colors.cursorColor$material3_release(this.$isError, composer2, 0).getValue().m3826unboximpl(), (DefaultConstructorMarker) null);
            TextFieldValue textFieldValue = this.$value;
            Function1<TextFieldValue, Unit> function1 = this.$onValueChange;
            boolean z2 = this.$enabled;
            boolean z3 = this.$readOnly;
            TextStyle textStyle = this.$mergedTextStyle;
            KeyboardOptions keyboardOptions = this.$keyboardOptions;
            KeyboardActions keyboardActions = this.$keyboardActions;
            boolean z4 = this.$singleLine;
            int i3 = this.$maxLines;
            int i4 = this.$minLines;
            VisualTransformation visualTransformation = this.$visualTransformation;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            Function1<TextFieldValue, Unit> function12 = function1;
            TextFieldValue textFieldValue2 = this.$value;
            Modifier modifier2 = r3;
            boolean z5 = this.$enabled;
            boolean z6 = z2;
            boolean z7 = this.$singleLine;
            boolean z8 = z3;
            VisualTransformation visualTransformation2 = this.$visualTransformation;
            TextStyle textStyle2 = textStyle;
            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            KeyboardOptions keyboardOptions2 = keyboardOptions;
            boolean z9 = this.$isError;
            KeyboardActions keyboardActions2 = keyboardActions;
            Function2<Composer, Integer, Unit> function2 = this.$label;
            boolean z10 = z4;
            Function2<Composer, Integer, Unit> function22 = this.$placeholder;
            int i5 = i3;
            Function2<Composer, Integer, Unit> function23 = this.$leadingIcon;
            int i6 = i4;
            Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            VisualTransformation visualTransformation3 = visualTransformation;
            Function2<Composer, Integer, Unit> function25 = this.$prefix;
            MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
            Function2<Composer, Integer, Unit> function26 = this.$suffix;
            Brush brush = solidColor;
            Function2<Composer, Integer, Unit> function27 = this.$supportingText;
            final Shape shape = this.$shape;
            final TextFieldValue textFieldValue3 = textFieldValue2;
            final boolean z11 = z5;
            final boolean z12 = z7;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
            final boolean z13 = z9;
            final Function2<Composer, Integer, Unit> function28 = function2;
            final Function2<Composer, Integer, Unit> function29 = function22;
            final Function2<Composer, Integer, Unit> function210 = function23;
            final Function2<Composer, Integer, Unit> function211 = function24;
            final Function2<Composer, Integer, Unit> function212 = function25;
            final Function2<Composer, Integer, Unit> function213 = function26;
            final Function2<Composer, Integer, Unit> function214 = function27;
            final TextFieldColors textFieldColors = this.$colors;
            TextFieldValue textFieldValue4 = textFieldValue;
            Function1<TextFieldValue, Unit> function13 = function12;
            Modifier modifier3 = modifier2;
            boolean z14 = z6;
            boolean z15 = z8;
            TextStyle textStyle3 = textStyle2;
            KeyboardOptions keyboardOptions3 = keyboardOptions2;
            KeyboardActions keyboardActions3 = keyboardActions2;
            boolean z16 = z10;
            int i7 = i5;
            int i8 = i6;
            VisualTransformation visualTransformation5 = visualTransformation3;
            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
            Brush brush2 = brush;
            BasicTextFieldKt.BasicTextField(textFieldValue4, (Function1<? super TextFieldValue, Unit>) function13, modifier3, z14, z15, textStyle3, keyboardOptions3, keyboardActions3, z16, i7, i8, visualTransformation5, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource5, brush2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1751957978, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
                    int i2;
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C368@19571L748:TextField.kt#uh7d8r");
                    Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    if ((i & 6) == 0) {
                        i2 = i | (composer2.changedInstance(function22) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) != 18 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1751957978, i2, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:368)");
                        }
                        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
                        TextFieldDefaults.INSTANCE.DecorationBox(textFieldValue3.getText(), function23, z11, z12, visualTransformation4, mutableInteractionSource4, z13, function28, function29, function210, function211, function212, function213, function214, shape, textFieldColors, (PaddingValues) null, (Function2<? super Composer, ? super Integer, Unit>) null, composer, (i2 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 0, (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
