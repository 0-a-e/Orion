package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: NameUtils.kt */
public final class NameUtils {
    private static final String CONTEXT_RECEIVER_PREFIX = "$context_receiver";
    public static final NameUtils INSTANCE = new NameUtils();
    private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");

    private NameUtils() {
    }

    @JvmStatic
    public static final String sanitizeAsJavaIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace((CharSequence) str, "_");
    }

    @JvmStatic
    public static final Name contextReceiverName(int i) {
        Name identifier = Name.identifier(CONTEXT_RECEIVER_PREFIX + '_' + i);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return identifier;
    }
}
