package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: SyntheticJavaPartsProvider.kt */
public interface SyntheticJavaPartsProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    void generateConstructors(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, List<ClassConstructorDescriptor> list);

    void generateMethods(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, Collection<SimpleFunctionDescriptor> collection);

    void generateNestedClass(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, List<ClassDescriptor> list);

    void generateStaticFunctions(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, Collection<SimpleFunctionDescriptor> collection);

    List<Name> getMethodNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor);

    List<Name> getNestedClassNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor);

    List<Name> getStaticFunctionNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor);

    PropertyDescriptorImpl modifyField(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, PropertyDescriptorImpl propertyDescriptorImpl);

    /* compiled from: SyntheticJavaPartsProvider.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final CompositeSyntheticJavaPartsProvider EMPTY = new CompositeSyntheticJavaPartsProvider(CollectionsKt.emptyList());

        private Companion() {
        }

        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }
}
