package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: IntersectionType.kt */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    private TypeIntersector() {
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> list) {
        Intrinsics.checkNotNullParameter(list, "types");
        list.size();
        ArrayList arrayList = new ArrayList();
        for (SimpleType simpleType : list) {
            if (simpleType.getConstructor() instanceof IntersectionTypeConstructor) {
                Collection<KotlinType> supertypes = simpleType.getConstructor().getSupertypes();
                Intrinsics.checkNotNullExpressionValue(supertypes, "getSupertypes(...)");
                Iterable<KotlinType> iterable = supertypes;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (KotlinType kotlinType : iterable) {
                    Intrinsics.checkNotNull(kotlinType);
                    SimpleType upperIfFlexible = FlexibleTypesKt.upperIfFlexible(kotlinType);
                    if (simpleType.isMarkedNullable()) {
                        upperIfFlexible = upperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(upperIfFlexible);
                }
                arrayList.addAll((List) arrayList2);
            } else {
                arrayList.add(simpleType);
            }
        }
        Iterable<UnwrappedType> iterable2 = arrayList;
        ResultNullability resultNullability = ResultNullability.START;
        for (UnwrappedType combine : iterable2) {
            resultNullability = resultNullability.combine(combine);
        }
        Collection linkedHashSet = new LinkedHashSet();
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            SimpleType simpleType2 = (SimpleType) it.next();
            if (resultNullability == ResultNullability.NOT_NULL) {
                if (simpleType2 instanceof NewCapturedType) {
                    simpleType2 = SpecialTypesKt.withNotNullProjection((NewCapturedType) simpleType2);
                }
                simpleType2 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(simpleType2, false, 1, (Object) null);
            }
            linkedHashSet.add(simpleType2);
        }
        LinkedHashSet linkedHashSet2 = (LinkedHashSet) linkedHashSet;
        Iterable<SimpleType> iterable3 = list;
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
        for (SimpleType attributes : iterable3) {
            arrayList3.add(attributes.getAttributes());
        }
        Iterator it2 = ((List) arrayList3).iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            while (it2.hasNext()) {
                next = ((TypeAttributes) next).intersect((TypeAttributes) it2.next());
            }
            return intersectTypesWithoutIntersectionType(linkedHashSet2).replaceAttributes((TypeAttributes) next);
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    private final SimpleType intersectTypesWithoutIntersectionType(Set<? extends SimpleType> set) {
        if (set.size() == 1) {
            return (SimpleType) CollectionsKt.single(set);
        }
        new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(set);
        Collection collection = set;
        Collection<SimpleType> filterTypes = filterTypes(collection, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        filterTypes.isEmpty();
        SimpleType findIntersectionType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(filterTypes);
        if (findIntersectionType != null) {
            return findIntersectionType;
        }
        Collection<SimpleType> filterTypes2 = filterTypes(filterTypes, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
        filterTypes2.isEmpty();
        if (filterTypes2.size() < 2) {
            return (SimpleType) CollectionsKt.single(filterTypes2);
        }
        return new IntersectionTypeConstructor(collection).createType();
    }

    private final Collection<SimpleType> filterTypes(Collection<? extends SimpleType> collection, Function2<? super SimpleType, ? super SimpleType, Boolean> function2) {
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SimpleType simpleType = (SimpleType) it.next();
            Iterable iterable = arrayList;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    SimpleType simpleType2 = (SimpleType) it2.next();
                    if (simpleType2 != simpleType) {
                        Intrinsics.checkNotNull(simpleType2);
                        Intrinsics.checkNotNull(simpleType);
                        if (function2.invoke(simpleType2, simpleType).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final boolean isStrictSupertype(KotlinType kotlinType, KotlinType kotlinType2) {
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        return newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType2, kotlinType);
    }

    /* compiled from: IntersectionType.kt */
    private enum ResultNullability {
        ;

        public abstract ResultNullability combine(UnwrappedType unwrappedType);

        /* compiled from: IntersectionType.kt */
        static final class START extends ResultNullability {
            START(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return getResultNullability(unwrappedType);
            }
        }

        static {
            ResultNullability[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }

        /* compiled from: IntersectionType.kt */
        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return getResultNullability(unwrappedType);
            }
        }

        /* compiled from: IntersectionType.kt */
        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                ResultNullability resultNullability = getResultNullability(unwrappedType);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        /* compiled from: IntersectionType.kt */
        static final class NOT_NULL extends ResultNullability {
            public NOT_NULL combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return this;
            }

            NOT_NULL(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }

        /* access modifiers changed from: protected */
        public final ResultNullability getResultNullability(UnwrappedType unwrappedType) {
            Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
            if (unwrappedType.isMarkedNullable()) {
                return ACCEPT_NULL;
            }
            if ((unwrappedType instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) unwrappedType).getOriginal() instanceof StubTypeForBuilderInference)) {
                return NOT_NULL;
            }
            if (unwrappedType instanceof StubTypeForBuilderInference) {
                return UNKNOWN;
            }
            if (NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }
    }
}
