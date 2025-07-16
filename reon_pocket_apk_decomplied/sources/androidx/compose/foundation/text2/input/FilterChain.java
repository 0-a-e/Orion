package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text.KeyboardOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text2/input/FilterChain;", "Landroidx/compose/foundation/text2/input/InputTransformation;", "first", "second", "(Landroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/foundation/text2/input/InputTransformation;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "", "other", "", "hashCode", "", "toString", "", "transformInput", "", "originalValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "valueWithChanges", "Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InputTransformation.kt */
final class FilterChain implements InputTransformation {
    private final InputTransformation first;
    private final InputTransformation second;

    public FilterChain(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        this.first = inputTransformation;
        this.second = inputTransformation2;
    }

    public KeyboardOptions getKeyboardOptions() {
        KeyboardOptions keyboardOptions = this.second.getKeyboardOptions();
        return keyboardOptions == null ? this.first.getKeyboardOptions() : keyboardOptions;
    }

    public void transformInput(TextFieldCharSequence textFieldCharSequence, TextFieldBuffer textFieldBuffer) {
        this.first.transformInput(textFieldCharSequence, textFieldBuffer);
        this.second.transformInput(textFieldCharSequence, textFieldBuffer);
    }

    public String toString() {
        return this.first + ".then(" + this.second + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FilterChain filterChain = (FilterChain) obj;
        return Intrinsics.areEqual((Object) this.first, (Object) filterChain.first) && Intrinsics.areEqual((Object) this.second, (Object) filterChain.second) && Intrinsics.areEqual((Object) getKeyboardOptions(), (Object) filterChain.getKeyboardOptions());
    }

    public int hashCode() {
        int hashCode = ((this.first.hashCode() * 31) + this.second.hashCode()) * 32;
        KeyboardOptions keyboardOptions = getKeyboardOptions();
        return hashCode + (keyboardOptions != null ? keyboardOptions.hashCode() : 0);
    }
}
