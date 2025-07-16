package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaTypeParameter.kt */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    private final TypeVariable<?> typeVariable;

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaTypeParameter(TypeVariable<?> typeVariable2) {
        Intrinsics.checkNotNullParameter(typeVariable2, "typeVariable");
        this.typeVariable = typeVariable2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt.getAnnotations((r0 = r0.getDeclaredAnnotations()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation> getAnnotations() {
        /*
            r1 = this;
            java.lang.reflect.AnnotatedElement r0 = r1.getElement()
            if (r0 == 0) goto L_0x0012
            java.lang.annotation.Annotation[] r0 = r0.getDeclaredAnnotations()
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt.getAnnotations(r0)
            if (r0 != 0) goto L_0x0016
        L_0x0012:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter.getAnnotations():java.util.List");
    }

    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] bounds = this.typeVariable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        Object[] objArr = (Object[]) bounds;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new ReflectJavaClassifierType((Type) obj));
        }
        List<ReflectJavaClassifierType> list = (List) arrayList;
        ReflectJavaClassifierType reflectJavaClassifierType = (ReflectJavaClassifierType) CollectionsKt.singleOrNull(list);
        return Intrinsics.areEqual((Object) reflectJavaClassifierType != null ? reflectJavaClassifierType.getReflectType() : null, (Object) Object.class) ? CollectionsKt.emptyList() : list;
    }

    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        Annotation[] declaredAnnotations;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        AnnotatedElement element = getElement();
        if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
            return null;
        }
        return ReflectJavaAnnotationOwnerKt.findAnnotation(declaredAnnotations, fqName);
    }

    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable2 = this.typeVariable;
        if (typeVariable2 instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable2;
        }
        return null;
    }

    public Name getName() {
        Name identifier = Name.identifier(this.typeVariable.getName());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return identifier;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaTypeParameter) && Intrinsics.areEqual((Object) this.typeVariable, (Object) ((ReflectJavaTypeParameter) obj).typeVariable);
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.typeVariable;
    }
}
