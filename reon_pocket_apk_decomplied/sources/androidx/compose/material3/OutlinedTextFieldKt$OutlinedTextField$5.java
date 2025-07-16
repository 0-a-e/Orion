package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
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
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
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
    OutlinedTextFieldKt$OutlinedTextField$5(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, TextFieldColors textFieldColors, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Shape shape) {
        super(2);
        this.$label = function2;
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
        Modifier modifier;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C344@18897L38,353@19316L20,333@18397L2430:OutlinedTextField.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1830921872, i2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:333)");
            }
            if (this.$label != null) {
                modifier = PaddingKt.m674paddingqDBjuR0$default(SemanticsModifierKt.semantics(this.$modifier, true, AnonymousClass1.INSTANCE), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, (Object) null);
            } else {
                modifier = this.$modifier;
            }
            boolean z = this.$isError;
            Strings.Companion companion = Strings.Companion;
            Modifier r3 = SizeKt.m726defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier, z, Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.default_error_message), composer2, 0)), OutlinedTextFieldDefaults.INSTANCE.m2044getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2043getMinHeightD9Ej5fM());
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
            SolidColor solidColor2 = solidColor;
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
            Brush brush = solidColor2;
            Function2<Composer, Integer, Unit> function27 = this.$supportingText;
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
            final Shape shape = this.$shape;
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
            BasicTextFieldKt.BasicTextField(textFieldValue4, (Function1<? super TextFieldValue, Unit>) function13, modifier3, z14, z15, textStyle3, keyboardOptions3, keyboardActions3, z16, i7, i8, visualTransformation5, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource5, brush2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -757328870, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
                    int i2;
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C362@19752L1051:OutlinedTextField.kt#uh7d8r");
                    Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    if ((i & 6) == 0) {
                        i2 = i | (composer2.changedInstance(function22) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) != 18 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-757328870, i2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:362)");
                        }
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        String text = textFieldValue3.getText();
                        boolean z = z11;
                        boolean z2 = z12;
                        VisualTransformation visualTransformation = visualTransformation4;
                        String str = text;
                        boolean z3 = z11;
                        boolean z4 = z;
                        boolean z5 = z13;
                        boolean z6 = z2;
                        MutableInteractionSource mutableInteractionSource = mutableInteractionSource4;
                        VisualTransformation visualTransformation2 = visualTransformation;
                        TextFieldColors textFieldColors = textFieldColors;
                        InteractionSource interactionSource = mutableInteractionSource4;
                        final boolean z7 = z3;
                        final boolean z8 = z5;
                        final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final Shape shape = shape;
                        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults2 = outlinedTextFieldDefaults;
                        String str2 = str;
                        boolean z9 = z4;
                        boolean z10 = z6;
                        VisualTransformation visualTransformation3 = visualTransformation2;
                        InteractionSource interactionSource2 = interactionSource;
                        outlinedTextFieldDefaults2.DecorationBox(str2, function23, z9, z10, visualTransformation3, interactionSource2, z13, function28, function29, function210, function211, function212, function213, function214, textFieldColors, (PaddingValues) null, ComposableLambdaKt.composableLambda(composer2, 255570733, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                int i2 = i;
                                Composer composer2 = composer;
                                ComposerKt.sourceInformation(composer, "C379@20533L230:OutlinedTextField.kt#uh7d8r");
                                if ((i2 & 3) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(255570733, i2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:379)");
                                    }
                                    OutlinedTextFieldDefaults.INSTANCE.m2039ContainerBoxnbWgWpA(z7, z8, mutableInteractionSource2, textFieldColors2, shape, 0.0f, 0.0f, composer, 12582912, 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, (i2 << 3) & 112, 14155776, 32768);
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
