package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;

/* compiled from: ErrorModuleDescriptor.kt */
final class ErrorModuleDescriptor$builtIns$2 extends Lambda implements Function0<DefaultBuiltIns> {
    public static final ErrorModuleDescriptor$builtIns$2 INSTANCE = new ErrorModuleDescriptor$builtIns$2();

    ErrorModuleDescriptor$builtIns$2() {
        super(0);
    }

    public final DefaultBuiltIns invoke() {
        return DefaultBuiltIns.Companion.getInstance();
    }
}
