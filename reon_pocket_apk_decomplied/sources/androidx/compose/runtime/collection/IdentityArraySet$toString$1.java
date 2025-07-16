package androidx.compose.runtime.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArraySet.kt */
final class IdentityArraySet$toString$1 extends Lambda implements Function1<T, CharSequence> {
    public static final IdentityArraySet$toString$1 INSTANCE = new IdentityArraySet$toString$1();

    IdentityArraySet$toString$1() {
        super(1);
    }

    public final CharSequence invoke(T t) {
        return t.toString();
    }
}
