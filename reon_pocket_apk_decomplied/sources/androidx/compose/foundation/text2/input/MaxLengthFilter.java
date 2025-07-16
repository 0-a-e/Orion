package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.InputTransformation;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/text2/input/MaxLengthFilter;", "Landroidx/compose/foundation/text2/input/InputTransformation;", "maxLength", "", "inCodepoints", "", "(IZ)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "transformInput", "", "originalValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "valueWithChanges", "Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MaxLengthTransformation.kt */
final class MaxLengthFilter implements InputTransformation {
    private final boolean inCodepoints;
    private final int maxLength;

    private final int component1() {
        return this.maxLength;
    }

    private final boolean component2() {
        return this.inCodepoints;
    }

    public static /* synthetic */ MaxLengthFilter copy$default(MaxLengthFilter maxLengthFilter, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = maxLengthFilter.maxLength;
        }
        if ((i2 & 2) != 0) {
            z = maxLengthFilter.inCodepoints;
        }
        return maxLengthFilter.copy(i, z);
    }

    public final MaxLengthFilter copy(int i, boolean z) {
        return new MaxLengthFilter(i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaxLengthFilter)) {
            return false;
        }
        MaxLengthFilter maxLengthFilter = (MaxLengthFilter) obj;
        return this.maxLength == maxLengthFilter.maxLength && this.inCodepoints == maxLengthFilter.inCodepoints;
    }

    public /* synthetic */ KeyboardOptions getKeyboardOptions() {
        return InputTransformation.CC.$default$getKeyboardOptions(this);
    }

    public int hashCode() {
        return (this.maxLength * 31) + UByte$$ExternalSyntheticBackport0.m(this.inCodepoints);
    }

    public MaxLengthFilter(int i, boolean z) {
        this.maxLength = i;
        this.inCodepoints = z;
        if (i < 0) {
            throw new IllegalArgumentException(("maxLength must be at least zero, was " + i).toString());
        }
    }

    public void transformInput(TextFieldCharSequence textFieldCharSequence, TextFieldBuffer textFieldBuffer) {
        if ((this.inCodepoints ? textFieldBuffer.getCodepointLength() : textFieldBuffer.getLength()) > this.maxLength) {
            textFieldBuffer.revertAllChanges();
        }
    }

    public String toString() {
        String str = this.inCodepoints ? "maxLengthInCodepoints" : "maxLengthInChars";
        return "InputTransformation." + str + "(maxLength=" + this.maxLength + ')';
    }
}
