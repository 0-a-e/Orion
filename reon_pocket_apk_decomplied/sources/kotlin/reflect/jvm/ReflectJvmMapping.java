package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0&2\u0006\u0010(\u001a\u00020\u000eH\u0002\u001a$\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0&2\u0006\u0010*\u001a\u00020\tH\u0002\u001a\u000e\u0010+\u001a\u0004\u0018\u00010,*\u00020-H\u0002\"/\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006."}, d2 = {"javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "Lkotlin/reflect/KFunction;", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "findKFunction", "", "Lkotlin/reflect/KCallable;", "method", "findKProperty", "field", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReflectJvmMapping.kt */
public final class ReflectJvmMapping {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReflectJvmMapping.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind[] r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.FILE_FACADE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS_PART     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction kFunction) {
    }

    public static final Field getJavaField(KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<this>");
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(kProperty);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    public static final Method getJavaGetter(KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<this>");
        return getJavaMethod(kProperty.getGetter());
    }

    public static final Method getJavaSetter(KMutableProperty<?> kMutableProperty) {
        Intrinsics.checkNotNullParameter(kMutableProperty, "<this>");
        return getJavaMethod(kMutableProperty.getSetter());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r2.getCaller();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.reflect.Method getJavaMethod(kotlin.reflect.KFunction<?> r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.KCallableImpl r2 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r2)
            r0 = 0
            if (r2 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.calls.Caller r2 = r2.getCaller()
            if (r2 == 0) goto L_0x0017
            java.lang.reflect.Member r2 = r2.getMember()
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            boolean r1 = r2 instanceof java.lang.reflect.Method
            if (r1 == 0) goto L_0x001f
            r0 = r2
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getJavaMethod(kotlin.reflect.KFunction):java.lang.reflect.Method");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r2.getCaller();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.reflect.Constructor<T> getJavaConstructor(kotlin.reflect.KFunction<? extends T> r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.KCallableImpl r2 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r2)
            r0 = 0
            if (r2 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.calls.Caller r2 = r2.getCaller()
            if (r2 == 0) goto L_0x0017
            java.lang.reflect.Member r2 = r2.getMember()
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            boolean r1 = r2 instanceof java.lang.reflect.Constructor
            if (r1 == 0) goto L_0x001f
            r0 = r2
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getJavaConstructor(kotlin.reflect.KFunction):java.lang.reflect.Constructor");
    }

    public static final Type getJavaType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        Type javaType = ((KTypeImpl) kType).getJavaType();
        return javaType == null ? TypesJVMKt.getJavaType(kType) : javaType;
    }

    public static final KProperty<?> getKotlinProperty(Field field) {
        KProperty<?> findKProperty;
        Intrinsics.checkNotNullParameter(field, "<this>");
        if (field.isSynthetic()) {
            return null;
        }
        if (Modifier.isStatic(field.getModifiers())) {
            KDeclarationContainer kPackage = getKPackage(field);
            if (kPackage != null) {
                return findKProperty(kPackage.getMembers(), field);
            }
            Class<?> declaringClass = field.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            KClass<?> companionObject = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(declaringClass));
            if (companionObject != null) {
                Class<?> declaringClass2 = field.getDeclaringClass();
                Intrinsics.checkNotNullExpressionValue(declaringClass2, "getDeclaringClass(...)");
                String name = field.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Field declaredFieldOrNull = UtilKt.getDeclaredFieldOrNull(declaringClass2, name);
                if (!(declaredFieldOrNull == null || (findKProperty = findKProperty(KClasses.getMemberProperties(companionObject), declaredFieldOrNull)) == null)) {
                    return findKProperty;
                }
            }
        }
        Class<?> declaringClass3 = field.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass3, "getDeclaringClass(...)");
        return findKProperty(KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(declaringClass3)), field);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r0.getClassHeader();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.reflect.KDeclarationContainer getKPackage(java.lang.reflect.Member r4) {
        /*
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass$Factory r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory
            java.lang.Class r1 = r4.getDeclaringClass()
            java.lang.String r2 = "getDeclaringClass(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass r0 = r0.create(r1)
            r1 = 0
            if (r0 == 0) goto L_0x001d
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r0.getClassHeader()
            if (r0 == 0) goto L_0x001d
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r0 = r0.getKind()
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            if (r0 != 0) goto L_0x0022
            r0 = -1
            goto L_0x002a
        L_0x0022:
            int[] r3 = kotlin.reflect.jvm.ReflectJvmMapping.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r3[r0]
        L_0x002a:
            r3 = 1
            if (r0 == r3) goto L_0x0034
            r3 = 2
            if (r0 == r3) goto L_0x0034
            r3 = 3
            if (r0 == r3) goto L_0x0034
            goto L_0x0043
        L_0x0034:
            kotlin.reflect.jvm.internal.KPackageImpl r0 = new kotlin.reflect.jvm.internal.KPackageImpl
            java.lang.Class r4 = r4.getDeclaringClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r0.<init>(r4)
            r1 = r0
            kotlin.reflect.KDeclarationContainer r1 = (kotlin.reflect.KDeclarationContainer) r1
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getKPackage(java.lang.reflect.Member):kotlin.reflect.KDeclarationContainer");
    }

    public static final KFunction<?> getKotlinFunction(Method method) {
        KFunction<?> findKFunction;
        Intrinsics.checkNotNullParameter(method, "<this>");
        if (Modifier.isStatic(method.getModifiers())) {
            KDeclarationContainer kPackage = getKPackage(method);
            if (kPackage != null) {
                return findKFunction(kPackage.getMembers(), method);
            }
            Class<?> declaringClass = method.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            KClass<?> companionObject = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(declaringClass));
            if (companionObject != null) {
                Class<?> javaClass = JvmClassMappingKt.getJavaClass(companionObject);
                String name = method.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Class[] parameterTypes = method.getParameterTypes();
                Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
                Method declaredMethodOrNull = UtilKt.getDeclaredMethodOrNull(javaClass, name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
                if (!(declaredMethodOrNull == null || (findKFunction = findKFunction(KClasses.getFunctions(companionObject), declaredMethodOrNull)) == null)) {
                    return findKFunction;
                }
            }
        }
        Class<?> declaringClass2 = method.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass2, "getDeclaringClass(...)");
        return findKFunction(KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(declaringClass2)), method);
    }

    private static final KFunction<?> findKFunction(Collection<? extends KCallable<?>> collection, Method method) {
        for (KCallable kCallable : collection) {
            if ((kCallable instanceof KFunction) && Intrinsics.areEqual((Object) kCallable.getName(), (Object) method.getName())) {
                KFunction<?> kFunction = (KFunction) kCallable;
                if (Intrinsics.areEqual((Object) getJavaMethod(kFunction), (Object) method)) {
                    return kFunction;
                }
            }
        }
        for (KCallable kCallable2 : collection) {
            if ((kCallable2 instanceof KFunction) && !Intrinsics.areEqual((Object) kCallable2.getName(), (Object) method.getName())) {
                KFunction<?> kFunction2 = (KFunction) kCallable2;
                if (Intrinsics.areEqual((Object) getJavaMethod(kFunction2), (Object) method)) {
                    return kFunction2;
                }
            }
        }
        return null;
    }

    private static final KProperty<?> findKProperty(Collection<? extends KCallable<?>> collection, Field field) {
        for (KCallable kCallable : collection) {
            if ((kCallable instanceof KProperty) && Intrinsics.areEqual((Object) kCallable.getName(), (Object) field.getName())) {
                KProperty<?> kProperty = (KProperty) kCallable;
                if (Intrinsics.areEqual((Object) getJavaField(kProperty), (Object) field)) {
                    return kProperty;
                }
            }
        }
        for (KCallable kCallable2 : collection) {
            if ((kCallable2 instanceof KProperty) && !Intrinsics.areEqual((Object) kCallable2.getName(), (Object) field.getName())) {
                KProperty<?> kProperty2 = (KProperty) kCallable2;
                if (Intrinsics.areEqual((Object) getJavaField(kProperty2), (Object) field)) {
                    return kProperty2;
                }
            }
        }
        return null;
    }

    public static final <T> KFunction<T> getKotlinFunction(Constructor<T> constructor) {
        Object obj;
        Intrinsics.checkNotNullParameter(constructor, "<this>");
        Class<T> declaringClass = constructor.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        Iterator it = JvmClassMappingKt.getKotlinClass(declaringClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) getJavaConstructor((KFunction) obj), (Object) constructor)) {
                break;
            }
        }
        return (KFunction) obj;
    }
}
