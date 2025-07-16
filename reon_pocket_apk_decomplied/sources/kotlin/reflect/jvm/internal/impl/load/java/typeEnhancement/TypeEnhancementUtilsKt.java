package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: typeEnhancementUtils.kt */
public final class TypeEnhancementUtilsKt {
    private static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        Set<? extends T> set2;
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (!Intrinsics.areEqual((Object) t4, (Object) t) || !Intrinsics.areEqual((Object) t3, (Object) t2)) {
                return t3 == null ? t4 : t3;
            }
            return null;
        }
        if (!(t3 == null || (set2 = CollectionsKt.toSet(SetsKt.plus(set, t3))) == null)) {
            set = set2;
        }
        return CollectionsKt.singleOrNull(set);
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z) {
        if (nullabilityQualifier == NullabilityQualifier.FORCE_FLEXIBILITY) {
            return NullabilityQualifier.FORCE_FLEXIBILITY;
        }
        return (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isNullabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getNullability();
    }

    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers javaTypeQualifiers, Collection<JavaTypeQualifiers> collection, boolean z, boolean z2, boolean z3) {
        NullabilityQualifier nullabilityQualifier;
        boolean z4;
        Intrinsics.checkNotNullParameter(javaTypeQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(collection, "superQualifiers");
        Iterable<JavaTypeQualifiers> iterable = collection;
        Collection arrayList = new ArrayList();
        for (JavaTypeQualifiers nullabilityForErrors : iterable) {
            NullabilityQualifier nullabilityForErrors2 = getNullabilityForErrors(nullabilityForErrors);
            if (nullabilityForErrors2 != null) {
                arrayList.add(nullabilityForErrors2);
            }
        }
        NullabilityQualifier select = select(CollectionsKt.toSet((List) arrayList), getNullabilityForErrors(javaTypeQualifiers), z);
        if (select == null) {
            Collection arrayList2 = new ArrayList();
            for (JavaTypeQualifiers nullability : iterable) {
                NullabilityQualifier nullability2 = nullability.getNullability();
                if (nullability2 != null) {
                    arrayList2.add(nullability2);
                }
            }
            nullabilityQualifier = select(CollectionsKt.toSet((List) arrayList2), javaTypeQualifiers.getNullability(), z);
        } else {
            nullabilityQualifier = select;
        }
        Collection arrayList3 = new ArrayList();
        for (JavaTypeQualifiers mutability : iterable) {
            MutabilityQualifier mutability2 = mutability.getMutability();
            if (mutability2 != null) {
                arrayList3.add(mutability2);
            }
        }
        MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) select(CollectionsKt.toSet((List) arrayList3), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, javaTypeQualifiers.getMutability(), z);
        NullabilityQualifier nullabilityQualifier2 = null;
        if (nullabilityQualifier != null && !z3 && (!z2 || nullabilityQualifier != NullabilityQualifier.NULLABLE)) {
            nullabilityQualifier2 = nullabilityQualifier;
        }
        boolean z5 = true;
        if (nullabilityQualifier2 == NullabilityQualifier.NOT_NULL) {
            if (javaTypeQualifiers.getDefinitelyNotNull()) {
                z4 = true;
            } else if (!((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((JavaTypeQualifiers) it.next()).getDefinitelyNotNull()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z4 = true;
            if (nullabilityQualifier2 == null || select == nullabilityQualifier) {
                z5 = false;
            }
            return new JavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z4, z5);
        }
        z4 = false;
        z5 = false;
        return new JavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z4, z5);
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, TransferTable.COLUMN_TYPE);
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(kotlinTypeMarker, fqName);
    }
}
