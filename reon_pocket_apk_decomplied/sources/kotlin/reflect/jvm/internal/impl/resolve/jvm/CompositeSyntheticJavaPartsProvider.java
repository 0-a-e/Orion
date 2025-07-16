package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: SyntheticJavaPartsProvider.kt */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    private final List<SyntheticJavaPartsProvider> inner;

    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> list) {
        Intrinsics.checkNotNullParameter(list, "inner");
        this.inner = list;
    }

    public List<Name> getMethodNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "$context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Collection arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider methodNames : this.inner) {
            CollectionsKt.addAll(arrayList, methodNames.getMethodNames(lazyJavaResolverContext, classDescriptor));
        }
        return (List) arrayList;
    }

    public void generateMethods(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "$context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        for (SyntheticJavaPartsProvider generateMethods : this.inner) {
            generateMethods.generateMethods(lazyJavaResolverContext, classDescriptor, name, collection);
        }
    }

    public List<Name> getStaticFunctionNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "$context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Collection arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider staticFunctionNames : this.inner) {
            CollectionsKt.addAll(arrayList, staticFunctionNames.getStaticFunctionNames(lazyJavaResolverContext, classDescriptor));
        }
        return (List) arrayList;
    }

    public void generateStaticFunctions(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "$context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        for (SyntheticJavaPartsProvider generateStaticFunctions : this.inner) {
            generateStaticFunctions.generateStaticFunctions(lazyJavaResolverContext, classDescriptor, name, collection);
        }
    }

    public void generateConstructors(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, List<ClassConstructorDescriptor> list) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "$context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(list, "result");
        for (SyntheticJavaPartsProvider generateConstructors : this.inner) {
            generateConstructors.generateConstructors(lazyJavaResolverContext, classDescriptor, list);
        }
    }

    public List<Name> getNestedClassNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "$context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Collection arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider nestedClassNames : this.inner) {
            CollectionsKt.addAll(arrayList, nestedClassNames.getNestedClassNames(lazyJavaResolverContext, classDescriptor));
        }
        return (List) arrayList;
    }

    public void generateNestedClass(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, List<ClassDescriptor> list) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "$context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "result");
        for (SyntheticJavaPartsProvider generateNestedClass : this.inner) {
            generateNestedClass.generateNestedClass(lazyJavaResolverContext, classDescriptor, name, list);
        }
    }

    public PropertyDescriptorImpl modifyField(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, PropertyDescriptorImpl propertyDescriptorImpl) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "$context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(propertyDescriptorImpl, "propertyDescriptor");
        for (SyntheticJavaPartsProvider modifyField : this.inner) {
            propertyDescriptorImpl = modifyField.modifyField(lazyJavaResolverContext, classDescriptor, propertyDescriptorImpl);
        }
        return propertyDescriptorImpl;
    }
}
