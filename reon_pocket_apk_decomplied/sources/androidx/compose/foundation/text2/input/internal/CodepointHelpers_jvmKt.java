package androidx.compose.foundation.text2.input.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0004H\u0000¨\u0006\u0007"}, d2 = {"charCount", "", "codePoint", "codePointAt", "", "index", "codePointCount", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CodepointHelpers.jvm.kt */
public final class CodepointHelpers_jvmKt {
    public static final int codePointAt(CharSequence charSequence, int i) {
        return Character.codePointAt(charSequence, i);
    }

    public static final int codePointCount(CharSequence charSequence) {
        return Character.codePointCount(charSequence, 0, charSequence.length());
    }

    public static final int charCount(int i) {
        return Character.charCount(i);
    }
}
