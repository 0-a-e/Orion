package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivityKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* compiled from: typeSignatureMapping.kt */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> jvmTypeFactory, T t, boolean z) {
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "<this>");
        Intrinsics.checkNotNullParameter(t, "possiblyPrimitiveType");
        return z ? jvmTypeFactory.boxType(t) : t;
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, JvmTypeFactory<T> jvmTypeFactory, TypeMappingMode typeMappingMode) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, TransferTable.COLUMN_TYPE);
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "typeFactory");
        Intrinsics.checkNotNullParameter(typeMappingMode, PairingActivityKt.TRANSIT_TO_MAIN_MODE);
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            return null;
        }
        PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
        if (primitiveType != null) {
            return boxTypeIfNeeded(jvmTypeFactory, jvmTypeFactory.createPrimitiveType(primitiveType), typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) || TypeEnhancementUtilsKt.hasEnhancedNullability(typeSystemCommonBackendContext, kotlinTypeMarker));
        }
        PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
        if (primitiveArrayType != null) {
            return jvmTypeFactory.createFromString("[" + JvmPrimitiveType.get(primitiveArrayType).getDesc());
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
            FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
            ClassId mapKotlinToJava = classFqNameUnsafe != null ? JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classFqNameUnsafe) : null;
            if (mapKotlinToJava != null) {
                if (!typeMappingMode.getKotlinCollectionsToJavaCollections()) {
                    Iterable<JavaToKotlinClassMap.PlatformMutabilityMapping> mutabilityMappings = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof Collection) || !((Collection) mutabilityMappings).isEmpty()) {
                        for (JavaToKotlinClassMap.PlatformMutabilityMapping javaClass : mutabilityMappings) {
                            if (Intrinsics.areEqual((Object) javaClass.getJavaClass(), (Object) mapKotlinToJava)) {
                                return null;
                            }
                        }
                    }
                }
                String internalName = JvmClassName.byClassId(mapKotlinToJava).getInternalName();
                Intrinsics.checkNotNullExpressionValue(internalName, "getInternalName(...)");
                return jvmTypeFactory.createObjectType(internalName);
            }
        }
        return null;
    }
}
