package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: ErasureTypeAttributes.kt */
public class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    public ErasureTypeAttributes(TypeUsage typeUsage, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = typeUsage;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    public ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameterDescriptor) {
        Set<T> set;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        TypeUsage howThisTypeIsUsed2 = getHowThisTypeIsUsed();
        Set<TypeParameterDescriptor> visitedTypeParameters2 = getVisitedTypeParameters();
        if (visitedTypeParameters2 == null || (set = SetsKt.plus(visitedTypeParameters2, typeParameterDescriptor)) == null) {
            set = SetsKt.setOf(typeParameterDescriptor);
        }
        return new ErasureTypeAttributes(howThisTypeIsUsed2, set, getDefaultType());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ErasureTypeAttributes)) {
            return false;
        }
        ErasureTypeAttributes erasureTypeAttributes = (ErasureTypeAttributes) obj;
        if (!Intrinsics.areEqual((Object) erasureTypeAttributes.getDefaultType(), (Object) getDefaultType()) || erasureTypeAttributes.getHowThisTypeIsUsed() != getHowThisTypeIsUsed()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        SimpleType defaultType2 = getDefaultType();
        int hashCode = defaultType2 != null ? defaultType2.hashCode() : 0;
        return hashCode + (hashCode * 31) + getHowThisTypeIsUsed().hashCode();
    }
}
