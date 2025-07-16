package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001a+\u0010S\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\u001a!\u0010V\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010W\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010X\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a\u001c\u0010Y\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a-\u0010[\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\",\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"(\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\"$\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013\",\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\",\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"B\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\",\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\">\u0010#\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\",\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\"\u0010+\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010.\",\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001c\u00102\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0004¢\u0006\u0006\u001a\u0004\b2\u00105\"\u001c\u00106\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0004¢\u0006\u0006\u001a\u0004\b6\u00105\",\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"B\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\",\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\">\u0010@\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"6\u0010C\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\u0015\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010F\",\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\",\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030K0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\",\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020O*\u0006\u0012\u0002\b\u00030\u00028FX\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010R¨\u0006\\"}, d2 = {"allSuperclasses", "", "Lkotlin/reflect/KClass;", "getAllSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "getAllSupertypes$annotations", "getAllSupertypes", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", "T", "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "defaultType", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "getFunctions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberProperties", "getMemberProperties$annotations", "getMemberProperties", "primaryConstructor", "getPrimaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", "base", "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: KClasses.kt */
public final class KClasses {
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getAllSupertypes$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getCompanionObject$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMembers$annotations(KClass kClass) {
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    public static /* synthetic */ void getDefaultType$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getStaticFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getStaticProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getSuperclasses$annotations(KClass kClass) {
    }

    public static final <T> KFunction<T> getPrimaryConstructor(KClass<T> kClass) {
        Object obj;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator it = ((KClassImpl) kClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            KFunction kFunction = (KFunction) obj;
            Intrinsics.checkNotNull(kFunction, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            FunctionDescriptor descriptor = ((KFunctionImpl) kFunction).getDescriptor();
            Intrinsics.checkNotNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((ConstructorDescriptor) descriptor).isPrimary()) {
                break;
            }
        }
        return (KFunction) obj;
    }

    public static final KClass<?> getCompanionObject(KClass<?> kClass) {
        Object obj;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator it = kClass.getNestedClasses().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            KClass kClass2 = (KClass) obj;
            Intrinsics.checkNotNull(kClass2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            if (((KClassImpl) kClass2).getDescriptor().isCompanionObject()) {
                break;
            }
        }
        return (KClass) obj;
    }

    public static final Object getCompanionObjectInstance(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KClass<?> companionObject = getCompanionObject(kClass);
        if (companionObject != null) {
            return companionObject.getObjectInstance();
        }
        return null;
    }

    public static final KType getDefaultType(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        SimpleType defaultType = ((KClassImpl) kClass).getDescriptor().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        return new KTypeImpl(defaultType, new KClasses$defaultType$1(kClass));
    }

    public static final Collection<KCallable<?>> getDeclaredMembers(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return ((KClassImpl) kClass).getData().getValue().getDeclaredMembers();
    }

    public static final Collection<KFunction<?>> getFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : kClass.getMembers()) {
            if (next instanceof KFunction) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final Collection<KFunction<?>> getStaticFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getAllStaticMembers()) {
            if (next instanceof KFunction) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final Collection<KFunction<?>> getMemberFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getAllNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final Collection<KFunction<?>> getMemberExtensionFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getAllNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final Collection<KFunction<?>> getDeclaredFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getDeclaredMembers()) {
            if (next instanceof KFunction) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getDeclaredNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getDeclaredNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final Collection<KProperty0<?>> getStaticProperties(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getAllStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty0)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getAllNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getAllNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KProperty2)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getDeclaredNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (Object next : ((KClassImpl) kClass).getData().getValue().getDeclaredNonStaticMembers()) {
            KCallableImpl kCallableImpl = (KCallableImpl) next;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KProperty2)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    private static final boolean isExtension(KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean isNotExtension(KCallableImpl<?> kCallableImpl) {
        return !isExtension(kCallableImpl);
    }

    public static final List<KClass<?>> getSuperclasses(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection arrayList = new ArrayList();
        for (KType classifier : kClass.getSupertypes()) {
            KClassifier classifier2 = classifier.getClassifier();
            KClass kClass2 = classifier2 instanceof KClass ? (KClass) classifier2 : null;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return (List) arrayList;
    }

    public static final Collection<KType> getAllSupertypes(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Object dfs = DFS.dfs(kClass.getSupertypes(), KClasses$$Lambda$0.INSTANCE, new DFS.VisitedWithSet(), new KClasses$allSupertypes$2());
        Intrinsics.checkNotNullExpressionValue(dfs, "dfs(...)");
        return (Collection) dfs;
    }

    /* access modifiers changed from: private */
    public static final Iterable _get_allSupertypes_$lambda$14(KType kType) {
        KClassifier classifier = kType.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass != null) {
            List<KType> supertypes = kClass.getSupertypes();
            if (kType.getArguments().isEmpty()) {
                return supertypes;
            }
            Intrinsics.checkNotNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            TypeSubstitutor create = TypeSubstitutor.create(((KTypeImpl) kType).getType());
            Iterable<KType> iterable = supertypes;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (KType kType2 : iterable) {
                Intrinsics.checkNotNull(kType2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                KotlinType substitute = create.substitute(((KTypeImpl) kType2).getType(), Variance.INVARIANT);
                if (substitute != null) {
                    Intrinsics.checkNotNull(substitute);
                    arrayList.add(new KTypeImpl(substitute, (Function0) null, 2, (DefaultConstructorMarker) null));
                } else {
                    throw new KotlinReflectionInternalError("Type substitution failed: " + kType2 + " (" + kType + ')');
                }
            }
            return (List) arrayList;
        }
        throw new KotlinReflectionInternalError("Supertype not a class: " + kType);
    }

    public static final Collection<KClass<?>> getAllSuperclasses(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterable<KType> allSupertypes = getAllSupertypes(kClass);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allSupertypes, 10));
        for (KType kType : allSupertypes) {
            KClassifier classifier = kType.getClassifier();
            KClass kClass2 = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            } else {
                throw new KotlinReflectionInternalError("Supertype not a class: " + kType);
            }
        }
        return (List) arrayList;
    }

    public static final boolean isSubclassOf(KClass<?> kClass, KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kClass2, "base");
        if (!Intrinsics.areEqual((Object) kClass, (Object) kClass2)) {
            Boolean ifAny = DFS.ifAny(CollectionsKt.listOf(kClass), new KClasses$$Lambda$1(KClasses$isSubclassOf$1.INSTANCE), new KClasses$isSubclassOf$2(kClass2));
            Intrinsics.checkNotNullExpressionValue(ifAny, "ifAny(...)");
            return ifAny.booleanValue();
        }
    }

    /* access modifiers changed from: private */
    public static final Iterable isSubclassOf$lambda$16(KProperty1 kProperty1, KClass kClass) {
        Intrinsics.checkNotNullParameter(kProperty1, "$tmp0");
        return (Iterable) kProperty1.invoke(kClass);
    }

    public static final boolean isSuperclassOf(KClass<?> kClass, KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kClass2, "derived");
        return isSubclassOf(kClass2, kClass);
    }

    public static final <T> T cast(KClass<T> kClass, Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (kClass.isInstance(obj)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
            return obj;
        }
        throw new TypeCastException("Value cannot be cast to " + kClass.getQualifiedName());
    }

    public static final <T> T safeCast(KClass<T> kClass, Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (!kClass.isInstance(obj)) {
            return null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
        return obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlin.reflect.KFunction} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T createInstance(kotlin.reflect.KClass<T> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.Collection r0 = r7.getConstructors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = 0
            r3 = r1
        L_0x0012:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0050
            java.lang.Object r4 = r0.next()
            r5 = r4
            kotlin.reflect.KFunction r5 = (kotlin.reflect.KFunction) r5
            java.util.List r5 = r5.getParameters()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r6 = r5 instanceof java.util.Collection
            if (r6 == 0) goto L_0x0033
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0033
            goto L_0x004a
        L_0x0033:
            java.util.Iterator r5 = r5.iterator()
        L_0x0037:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x004a
            java.lang.Object r6 = r5.next()
            kotlin.reflect.KParameter r6 = (kotlin.reflect.KParameter) r6
            boolean r6 = r6.isOptional()
            if (r6 != 0) goto L_0x0037
            goto L_0x0012
        L_0x004a:
            if (r2 == 0) goto L_0x004d
            goto L_0x0054
        L_0x004d:
            r2 = 1
            r3 = r4
            goto L_0x0012
        L_0x0050:
            if (r2 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r1 = r3
        L_0x0054:
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            if (r1 == 0) goto L_0x0061
            java.util.Map r7 = kotlin.collections.MapsKt.emptyMap()
            java.lang.Object r7 = r1.callBy(r7)
            return r7
        L_0x0061:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Class should have a single no-arg constructor: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KClasses.createInstance(kotlin.reflect.KClass):java.lang.Object");
    }
}
