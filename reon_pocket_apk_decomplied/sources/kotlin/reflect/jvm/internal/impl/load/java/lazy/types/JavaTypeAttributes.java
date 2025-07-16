package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* compiled from: JavaTypeAttributes.kt */
public final class JavaTypeAttributes extends ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final JavaTypeFlexibility flexibility;
    private final TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    private final boolean isRaw;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, Set<TypeParameterDescriptor> set, SimpleType simpleType, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = javaTypeAttributes.howThisTypeIsUsed;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.flexibility;
        }
        JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
        if ((i & 4) != 0) {
            z = javaTypeAttributes.isRaw;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = javaTypeAttributes.isForAnnotationParameter;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            set = javaTypeAttributes.visitedTypeParameters;
        }
        Set<TypeParameterDescriptor> set2 = set;
        if ((i & 32) != 0) {
            simpleType = javaTypeAttributes.defaultType;
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility2, z3, z4, set2, simpleType);
    }

    public final JavaTypeAttributes copy(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return new JavaTypeAttributes(typeUsage, javaTypeFlexibility, z, z2, set, simpleType);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.howThisTypeIsUsed + ", flexibility=" + this.flexibility + ", isRaw=" + this.isRaw + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + this.visitedTypeParameters + ", defaultType=" + this.defaultType + ')';
    }

    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, Set set, SimpleType simpleType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : set, (i & 32) != 0 ? null : simpleType);
    }

    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        super(typeUsage, set, simpleType);
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        this.howThisTypeIsUsed = typeUsage;
        this.flexibility = javaTypeFlexibility;
        this.isRaw = z;
        this.isForAnnotationParameter = z2;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility javaTypeFlexibility) {
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return copy$default(this, (TypeUsage) null, javaTypeFlexibility, false, false, (Set) null, (SimpleType) null, 61, (Object) null);
    }

    public final JavaTypeAttributes markIsRaw(boolean z) {
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, z, false, (Set) null, (SimpleType) null, 59, (Object) null);
    }

    public JavaTypeAttributes withDefaultType(SimpleType simpleType) {
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, false, (Set) null, simpleType, 31, (Object) null);
    }

    public JavaTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, false, getVisitedTypeParameters() != null ? SetsKt.plus(getVisitedTypeParameters(), typeParameterDescriptor) : SetsKt.setOf(typeParameterDescriptor), (SimpleType) null, 47, (Object) null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JavaTypeAttributes)) {
            return false;
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
        if (Intrinsics.areEqual((Object) javaTypeAttributes.getDefaultType(), (Object) getDefaultType()) && javaTypeAttributes.getHowThisTypeIsUsed() == getHowThisTypeIsUsed() && javaTypeAttributes.flexibility == this.flexibility && javaTypeAttributes.isRaw == this.isRaw && javaTypeAttributes.isForAnnotationParameter == this.isForAnnotationParameter) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        SimpleType defaultType2 = getDefaultType();
        int hashCode = defaultType2 != null ? defaultType2.hashCode() : 0;
        int hashCode2 = hashCode + (hashCode * 31) + getHowThisTypeIsUsed().hashCode();
        int hashCode3 = hashCode2 + (hashCode2 * 31) + this.flexibility.hashCode();
        int i = hashCode3 + (hashCode3 * 31) + (this.isRaw ? 1 : 0);
        return i + (i * 31) + (this.isForAnnotationParameter ? 1 : 0);
    }
}
