package androidx.compose.foundation.text2.input.internal;

import android.text.TextUtils;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¨\u0006\t"}, d2 = {"toCharArray", "", "", "destination", "", "destinationOffset", "", "startIndex", "endIndex", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ToCharArray.android.kt */
public final class ToCharArray_androidKt {
    public static final void toCharArray(CharSequence charSequence, char[] cArr, int i, int i2, int i3) {
        if (charSequence instanceof TextFieldCharSequence) {
            TextFieldCharSequenceKt.toCharArray((TextFieldCharSequence) charSequence, cArr, i, i2, i3);
        } else {
            TextUtils.getChars(charSequence, i2, i3, cArr, i);
        }
    }
}
