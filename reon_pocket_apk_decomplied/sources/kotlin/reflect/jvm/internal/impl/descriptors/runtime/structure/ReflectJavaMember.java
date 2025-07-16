package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* compiled from: ReflectJavaMember.kt */
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public abstract Member getMember();

    public boolean isDeprecatedInJavaDoc() {
        return false;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember.getAnnotations():java.util.List");
    }

    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
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

    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public AnnotatedElement getElement() {
        Member member = getMember();
        Intrinsics.checkNotNull(member, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) member;
    }

    public int getModifiers() {
        return getMember().getModifiers();
    }

    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    public Name getName() {
        String name = getMember().getName();
        Name identifier = name != null ? Name.identifier(name) : null;
        return identifier == null ? SpecialNames.NO_NAME_PROVIDED : identifier;
    }

    public Visibility getVisibility() {
        int modifiers = getModifiers();
        if (Modifier.isPublic(modifiers)) {
            return Visibilities.Public.INSTANCE;
        }
        if (Modifier.isPrivate(modifiers)) {
            return Visibilities.Private.INSTANCE;
        }
        if (!Modifier.isProtected(modifiers)) {
            return JavaVisibilities.PackageVisibility.INSTANCE;
        }
        if (Modifier.isStatic(modifiers)) {
            return JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
        }
        return JavaVisibilities.ProtectedAndPackage.INSTANCE;
    }

    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        return new ReflectJavaClass(declaringClass);
    }

    /* access modifiers changed from: protected */
    public final List<JavaValueParameter> getValueParameters(Type[] typeArr, Annotation[][] annotationArr, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(typeArr, "parameterTypes");
        Intrinsics.checkNotNullParameter(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> loadParameterNames = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        int size = loadParameterNames != null ? loadParameterNames.size() - typeArr.length : 0;
        int length = typeArr.length;
        int i = 0;
        while (i < length) {
            ReflectJavaType create = ReflectJavaType.Factory.create(typeArr[i]);
            if (loadParameterNames != null) {
                str = (String) CollectionsKt.getOrNull(loadParameterNames, i + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i + '+' + size + " (name=" + getName() + " type=" + create + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new ReflectJavaValueParameter(create, annotationArr[i], str, z && i == ArraysKt.getLastIndex((T[]) typeArr)));
            i++;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaMember) && Intrinsics.areEqual((Object) getMember(), (Object) ((ReflectJavaMember) obj).getMember());
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }
}
