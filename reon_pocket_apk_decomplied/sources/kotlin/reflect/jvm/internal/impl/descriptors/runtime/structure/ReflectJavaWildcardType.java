package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* compiled from: ReflectJavaWildcardType.kt */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    private final Collection<JavaAnnotation> annotations = CollectionsKt.emptyList();
    private final boolean isDeprecatedInJavaDoc;
    private final WildcardType reflectType;

    public ReflectJavaWildcardType(WildcardType wildcardType) {
        Intrinsics.checkNotNullParameter(wildcardType, "reflectType");
        this.reflectType = wildcardType;
    }

    /* access modifiers changed from: protected */
    public WildcardType getReflectType() {
        return this.reflectType;
    }

    public ReflectJavaType getBound() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Type[] lowerBounds = getReflectType().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + getReflectType());
        } else if (lowerBounds.length == 1) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Intrinsics.checkNotNull(lowerBounds);
            Object single = ArraysKt.single((T[]) lowerBounds);
            Intrinsics.checkNotNullExpressionValue(single, "single(...)");
            return factory.create((Type) single);
        } else {
            if (upperBounds.length == 1) {
                Intrinsics.checkNotNull(upperBounds);
                Type type = (Type) ArraysKt.single((T[]) upperBounds);
                if (!Intrinsics.areEqual((Object) type, (Object) Object.class)) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Intrinsics.checkNotNull(type);
                    return factory2.create(type);
                }
            }
            return null;
        }
    }

    public boolean isExtends() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        return !Intrinsics.areEqual(ArraysKt.firstOrNull((T[]) (Object[]) upperBounds), (Object) Object.class);
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }
}
