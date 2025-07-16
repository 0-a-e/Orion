package kotlin.reflect.jvm.internal.impl.utils.addToStdlib;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: addToStdlib.kt */
public final class AddToStdlibKt {
    private static final ConcurrentHashMap<Function0<?>, Object> constantMap = new ConcurrentHashMap<>();

    public static /* synthetic */ Void shouldNotBeCalled$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "should not be called";
        }
        return shouldNotBeCalled(str);
    }

    public static final Void shouldNotBeCalled(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        throw new IllegalStateException(str.toString());
    }
}
