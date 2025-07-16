package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* compiled from: DefaultBuiltIns.kt */
final class DefaultBuiltIns$Companion$Instance$2 extends Lambda implements Function0<DefaultBuiltIns> {
    public static final DefaultBuiltIns$Companion$Instance$2 INSTANCE = new DefaultBuiltIns$Companion$Instance$2();

    DefaultBuiltIns$Companion$Instance$2() {
        super(0);
    }

    public final DefaultBuiltIns invoke() {
        return new DefaultBuiltIns(false, 1, (DefaultConstructorMarker) null);
    }
}
