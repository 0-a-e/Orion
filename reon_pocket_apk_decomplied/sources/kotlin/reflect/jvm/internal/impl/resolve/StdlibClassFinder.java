package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: StdlibClassFinder.kt */
public interface StdlibClassFinder {
    ClassDescriptor findEnumEntriesClass(ModuleDescriptor moduleDescriptor);
}
