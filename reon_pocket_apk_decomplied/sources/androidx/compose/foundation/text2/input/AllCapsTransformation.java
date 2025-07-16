package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.TextFieldBuffer;
import androidx.compose.ui.text.StringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text2/input/AllCapsTransformation;", "Landroidx/compose/foundation/text2/input/InputTransformation;", "locale", "Landroidx/compose/ui/text/intl/Locale;", "(Landroidx/compose/ui/text/intl/Locale;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "transformInput", "", "originalValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "valueWithChanges", "Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AllCapsTransformation.kt */
final class AllCapsTransformation implements InputTransformation {
    private final KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.Companion.m6265getCharactersIUNYP9k(), false, 0, 0, (PlatformImeOptions) null, 30, (DefaultConstructorMarker) null);
    private final Locale locale;

    private final Locale component1() {
        return this.locale;
    }

    public static /* synthetic */ AllCapsTransformation copy$default(AllCapsTransformation allCapsTransformation, Locale locale2, int i, Object obj) {
        if ((i & 1) != 0) {
            locale2 = allCapsTransformation.locale;
        }
        return allCapsTransformation.copy(locale2);
    }

    public final AllCapsTransformation copy(Locale locale2) {
        return new AllCapsTransformation(locale2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AllCapsTransformation) && Intrinsics.areEqual((Object) this.locale, (Object) ((AllCapsTransformation) obj).locale);
    }

    public int hashCode() {
        return this.locale.hashCode();
    }

    public AllCapsTransformation(Locale locale2) {
        this.locale = locale2;
    }

    public KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public void transformInput(TextFieldCharSequence textFieldCharSequence, TextFieldBuffer textFieldBuffer) {
        TextFieldBuffer.ChangeList changes = textFieldBuffer.getChanges();
        for (int i = 0; i < changes.getChangeCount(); i++) {
            long r1 = changes.m1344getRangejx7JFs(i);
            changes.m1343getOriginalRangejx7JFs(i);
            if (!TextRange.m6036getCollapsedimpl(r1)) {
                textFieldBuffer.replace(TextRange.m6040getMinimpl(r1), TextRange.m6039getMaximpl(r1), StringKt.toUpperCase(TextRangeKt.m6049substringFDrldGo(textFieldBuffer.asCharSequence(), r1), this.locale));
            }
        }
    }

    public String toString() {
        return "InputTransformation.allCaps(locale=" + this.locale + ')';
    }
}
