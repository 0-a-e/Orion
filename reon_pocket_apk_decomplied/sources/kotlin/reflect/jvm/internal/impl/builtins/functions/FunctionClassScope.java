package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: FunctionClassScope.kt */
public final class FunctionClassScope extends GivenFunctionsMemberScope {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionClassScope(StorageManager storageManager, FunctionClassDescriptor functionClassDescriptor) {
        super(storageManager, functionClassDescriptor);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(functionClassDescriptor, "containingClass");
    }

    /* access modifiers changed from: protected */
    public List<FunctionDescriptor> computeDeclaredFunctions() {
        ClassDescriptor containingClass = getContainingClass();
        Intrinsics.checkNotNull(containingClass, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        FunctionTypeKind functionTypeKind = ((FunctionClassDescriptor) containingClass).getFunctionTypeKind();
        if (Intrinsics.areEqual((Object) functionTypeKind, (Object) FunctionTypeKind.Function.INSTANCE)) {
            return CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) getContainingClass(), false));
        }
        if (Intrinsics.areEqual((Object) functionTypeKind, (Object) FunctionTypeKind.SuspendFunction.INSTANCE)) {
            return CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) getContainingClass(), true));
        }
        return CollectionsKt.emptyList();
    }
}
