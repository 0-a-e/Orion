package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;

/* compiled from: FunctionClassKind.kt */
public enum FunctionClassKind {
    Function,
    SuspendFunction,
    KFunction,
    KSuspendFunction,
    UNKNOWN;
    
    public static final Companion Companion = null;

    static {
        FunctionClassKind[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    /* compiled from: FunctionClassKind.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FunctionClassKind getFunctionClassKind(FunctionTypeKind functionTypeKind) {
            Intrinsics.checkNotNullParameter(functionTypeKind, "functionTypeKind");
            if (Intrinsics.areEqual((Object) functionTypeKind, (Object) FunctionTypeKind.Function.INSTANCE)) {
                return FunctionClassKind.Function;
            }
            if (Intrinsics.areEqual((Object) functionTypeKind, (Object) FunctionTypeKind.SuspendFunction.INSTANCE)) {
                return FunctionClassKind.SuspendFunction;
            }
            if (Intrinsics.areEqual((Object) functionTypeKind, (Object) FunctionTypeKind.KFunction.INSTANCE)) {
                return FunctionClassKind.KFunction;
            }
            if (Intrinsics.areEqual((Object) functionTypeKind, (Object) FunctionTypeKind.KSuspendFunction.INSTANCE)) {
                return FunctionClassKind.KSuspendFunction;
            }
            return FunctionClassKind.UNKNOWN;
        }
    }
}
