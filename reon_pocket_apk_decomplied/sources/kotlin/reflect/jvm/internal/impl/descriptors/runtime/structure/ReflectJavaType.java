package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* compiled from: ReflectJavaType.kt */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

    /* access modifiers changed from: protected */
    public abstract Type getReflectType();

    /* compiled from: ReflectJavaType.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final ReflectJavaType create(Type type) {
            Intrinsics.checkNotNullParameter(type, TransferTable.COLUMN_TYPE);
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new ReflectJavaPrimitiveType(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                return new ReflectJavaArrayType(type);
            }
            if (type instanceof WildcardType) {
                return new ReflectJavaWildcardType((WildcardType) type);
            }
            return new ReflectJavaClassifierType(type);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaType) && Intrinsics.areEqual((Object) getReflectType(), (Object) ((ReflectJavaType) obj).getReflectType());
    }

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: kotlin.reflect.jvm.internal.impl.name.FqName} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.reflect.jvm.internal.impl.name.FqName} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: kotlin.reflect.jvm.internal.impl.name.FqName} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: kotlin.reflect.jvm.internal.impl.name.FqName} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: kotlin.reflect.jvm.internal.impl.name.FqName} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName r5) {
        /*
            r4 = this;
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Collection r0 = r4.getAnnotations()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()
            r3 = r1
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation r3 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation) r3
            kotlin.reflect.jvm.internal.impl.name.ClassId r3 = r3.getClassId()
            if (r3 == 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.name.FqName r2 = r3.asSingleFqName()
        L_0x0027:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x000f
            r2 = r1
        L_0x002e:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName):kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation");
    }
}
