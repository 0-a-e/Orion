package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: BuiltinSpecialProperties.kt */
public final class BuiltinSpecialPropertiesKt {
    /* access modifiers changed from: private */
    public static final FqName child(FqName fqName, String str) {
        FqName child = fqName.child(Name.identifier(str));
        Intrinsics.checkNotNullExpressionValue(child, "child(...)");
        return child;
    }

    /* access modifiers changed from: private */
    public static final FqName childSafe(FqNameUnsafe fqNameUnsafe, String str) {
        FqName safe = fqNameUnsafe.child(Name.identifier(str)).toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "toSafe(...)");
        return safe;
    }
}
