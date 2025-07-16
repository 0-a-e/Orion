package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: LazyJavaStaticClassScope.kt */
final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1 extends Lambda implements Function1<KotlinType, ClassDescriptor> {
    public static final LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1 INSTANCE = new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1();

    LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1() {
        super(1);
    }

    public final ClassDescriptor invoke(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }
}
