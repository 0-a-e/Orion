package kotlin.reflect.jvm.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClassifiers;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0011\u001a\u00020\u0012H\u0000\u001a6\u0010\u0013\u001a\u00020\u0002\"\b\b\u0000\u0010\u0014*\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0000\u001a6\u0010\u0019\u001a\u00020\u0002\"\b\b\u0000\u0010\u0014*\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0002\u001a&\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00140\f\"\b\b\u0000\u0010\u0014*\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0000\u001a \u0010\u001b\u001a\u00020\u001c\"\b\b\u0000\u0010\u0014*\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"6\u0010\u0003\u001a*\u0012&\u0012$\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t\u0012\u0004\u0012\u00020\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"$\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f0\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000*0\b\u0002\u0010\u001d\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u00052\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005¨\u0006\u001e"}, d2 = {"CACHE_FOR_BASE_CLASSIFIERS", "Lkotlin/reflect/jvm/internal/CacheByClass;", "Lkotlin/reflect/KType;", "CACHE_FOR_GENERIC_CLASSIFIERS", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "", "Lkotlin/reflect/KTypeProjection;", "", "Lkotlin/reflect/jvm/internal/Key;", "CACHE_FOR_NULLABLE_BASE_CLASSIFIERS", "K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "K_PACKAGE_CACHE", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "clearCaches", "", "getOrCreateKType", "T", "jClass", "Ljava/lang/Class;", "arguments", "isMarkedNullable", "getOrCreateKTypeWithTypeArguments", "getOrCreateKotlinClass", "getOrCreateKotlinPackage", "Lkotlin/reflect/KDeclarationContainer;", "Key", "kotlin-reflection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: caches.kt */
public final class CachesKt {
    private static final CacheByClass<KType> CACHE_FOR_BASE_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$CACHE_FOR_BASE_CLASSIFIERS$1.INSTANCE);
    private static final CacheByClass<ConcurrentHashMap<Pair<List<KTypeProjection>, Boolean>, KType>> CACHE_FOR_GENERIC_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$CACHE_FOR_GENERIC_CLASSIFIERS$1.INSTANCE);
    private static final CacheByClass<KType> CACHE_FOR_NULLABLE_BASE_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$1.INSTANCE);
    private static final CacheByClass<KClassImpl<? extends Object>> K_CLASS_CACHE = CacheByClassKt.createCache(CachesKt$K_CLASS_CACHE$1.INSTANCE);
    private static final CacheByClass<KPackageImpl> K_PACKAGE_CACHE = CacheByClassKt.createCache(CachesKt$K_PACKAGE_CACHE$1.INSTANCE);

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        KClassImpl<? extends Object> kClassImpl = K_CLASS_CACHE.get(cls);
        Intrinsics.checkNotNull(kClassImpl, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return kClassImpl;
    }

    public static final <T> KDeclarationContainer getOrCreateKotlinPackage(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        return K_PACKAGE_CACHE.get(cls);
    }

    public static final void clearCaches() {
        K_CLASS_CACHE.clear();
        K_PACKAGE_CACHE.clear();
        CACHE_FOR_BASE_CLASSIFIERS.clear();
        CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.clear();
        CACHE_FOR_GENERIC_CLASSIFIERS.clear();
    }

    public static final <T> KType getOrCreateKType(Class<T> cls, List<KTypeProjection> list, boolean z) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        Intrinsics.checkNotNullParameter(list, "arguments");
        if (!list.isEmpty()) {
            return getOrCreateKTypeWithTypeArguments(cls, list, z);
        }
        if (z) {
            return CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.get(cls);
        }
        return CACHE_FOR_BASE_CLASSIFIERS.get(cls);
    }

    private static final <T> KType getOrCreateKTypeWithTypeArguments(Class<T> cls, List<KTypeProjection> list, boolean z) {
        ConcurrentMap concurrentMap = CACHE_FOR_GENERIC_CLASSIFIERS.get(cls);
        Pair<A, B> pair = TuplesKt.to(list, Boolean.valueOf(z));
        Object obj = concurrentMap.get(pair);
        if (obj == null) {
            KType createType = KClassifiers.createType(getOrCreateKotlinClass(cls), list, z, CollectionsKt.emptyList());
            Object putIfAbsent = concurrentMap.putIfAbsent(pair, createType);
            obj = putIfAbsent == null ? createType : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return (KType) obj;
    }
}
