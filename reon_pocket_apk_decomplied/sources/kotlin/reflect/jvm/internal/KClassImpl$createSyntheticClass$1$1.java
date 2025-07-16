package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014¨\u0006\u0005"}, d2 = {"kotlin/reflect/jvm/internal/KClassImpl$createSyntheticClass$1$1", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/GivenFunctionsMemberScope;", "computeDeclaredFunctions", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: KClassImpl.kt */
public final class KClassImpl$createSyntheticClass$1$1 extends GivenFunctionsMemberScope {
    KClassImpl$createSyntheticClass$1$1(ClassDescriptorImpl classDescriptorImpl, StorageManager storageManager) {
        super(storageManager, classDescriptorImpl);
    }

    /* access modifiers changed from: protected */
    public List<FunctionDescriptor> computeDeclaredFunctions() {
        return CollectionsKt.emptyList();
    }
}
