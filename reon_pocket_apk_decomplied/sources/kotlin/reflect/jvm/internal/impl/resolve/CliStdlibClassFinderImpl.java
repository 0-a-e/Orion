package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

/* compiled from: StdlibClassFinder.kt */
final class CliStdlibClassFinderImpl implements StdlibClassFinder {
    public static final CliStdlibClassFinderImpl INSTANCE = new CliStdlibClassFinderImpl();

    private CliStdlibClassFinderImpl() {
    }

    public ClassDescriptor findEnumEntriesClass(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        return FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, StandardClassIds.INSTANCE.getEnumEntries());
    }
}
