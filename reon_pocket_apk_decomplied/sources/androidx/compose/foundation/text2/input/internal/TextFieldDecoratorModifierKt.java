package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0003"}, d2 = {"withDefaultsFrom", "Landroidx/compose/foundation/text/KeyboardOptions;", "defaults", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
public final class TextFieldDecoratorModifierKt {
    public static final KeyboardOptions withDefaultsFrom(KeyboardOptions keyboardOptions, KeyboardOptions keyboardOptions2) {
        int i;
        int i2;
        int i3;
        if (keyboardOptions2 == null) {
            return keyboardOptions;
        }
        if (!KeyboardCapitalization.m6257equalsimpl0(keyboardOptions.m1082getCapitalizationIUNYP9k(), KeyboardCapitalization.Companion.m6266getNoneIUNYP9k())) {
            i = keyboardOptions.m1082getCapitalizationIUNYP9k();
        } else {
            i = keyboardOptions2.m1082getCapitalizationIUNYP9k();
        }
        int i4 = i;
        boolean z = keyboardOptions.getAutoCorrect() && keyboardOptions2.getAutoCorrect();
        if (!KeyboardType.m6272equalsimpl0(keyboardOptions.m1084getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6292getTextPjHm6EE())) {
            i2 = keyboardOptions.m1084getKeyboardTypePjHm6EE();
        } else {
            i2 = keyboardOptions2.m1084getKeyboardTypePjHm6EE();
        }
        int i5 = i2;
        if (!ImeAction.m6225equalsimpl0(keyboardOptions.m1083getImeActioneUduSuo(), ImeAction.Companion.m6237getDefaulteUduSuo())) {
            i3 = keyboardOptions.m1083getImeActioneUduSuo();
        } else {
            i3 = keyboardOptions2.m1083getImeActioneUduSuo();
        }
        return new KeyboardOptions(i4, z, i5, i3, (PlatformImeOptions) null, 16, (DefaultConstructorMarker) null);
    }
}
