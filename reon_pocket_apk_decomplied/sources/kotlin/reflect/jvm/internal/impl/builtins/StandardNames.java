package kotlin.reflect.jvm.internal.impl.builtins;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: StandardNames.kt */
public final class StandardNames {
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME;
    public static final Name BACKING_FIELD;
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME;
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;
    public static final Name BUILT_INS_PACKAGE_NAME;
    public static final Name CHAR_CODE;
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME;
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
    public static final FqName COROUTINES_PACKAGE_FQ_NAME;
    public static final String DATA_CLASS_COMPONENT_PREFIX = "component";
    public static final Name DATA_CLASS_COPY;
    public static final Name DEFAULT_VALUE_PARAMETER;
    public static final FqName DYNAMIC_FQ_NAME = new FqName("<dynamic>");
    public static final Name ENUM_ENTRIES;
    public static final Name ENUM_VALUES;
    public static final Name ENUM_VALUE_OF;
    public static final Name HASHCODE_NAME;
    public static final Name IMPLICIT_LAMBDA_PARAMETER_NAME;
    public static final StandardNames INSTANCE = new StandardNames();
    public static final FqName KOTLIN_INTERNAL_FQ_NAME;
    public static final FqName KOTLIN_REFLECT_FQ_NAME;
    public static final Name MAIN;
    public static final Name NAME;
    public static final Name NEXT_CHAR;
    private static final FqName NON_EXISTENT_CLASS = new FqName("error.NonExistentClass");
    public static final List<String> PREFIXES = CollectionsKt.listOf("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
    public static final FqName RANGES_PACKAGE_FQ_NAME;
    public static final FqName RESULT_FQ_NAME = new FqName("kotlin.Result");
    public static final FqName TEXT_PACKAGE_FQ_NAME;

    private StandardNames() {
    }

    static {
        Name identifier = Name.identifier("field");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        BACKING_FIELD = identifier;
        Name identifier2 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
        DEFAULT_VALUE_PARAMETER = identifier2;
        Name identifier3 = Name.identifier("values");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(...)");
        ENUM_VALUES = identifier3;
        Name identifier4 = Name.identifier(RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(...)");
        ENUM_ENTRIES = identifier4;
        Name identifier5 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(...)");
        ENUM_VALUE_OF = identifier5;
        Name identifier6 = Name.identifier("copy");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(...)");
        DATA_CLASS_COPY = identifier6;
        Name identifier7 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(...)");
        HASHCODE_NAME = identifier7;
        Name identifier8 = Name.identifier("code");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(...)");
        CHAR_CODE = identifier8;
        Name identifier9 = Name.identifier("name");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(...)");
        NAME = identifier9;
        Name identifier10 = Name.identifier("main");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(...)");
        MAIN = identifier10;
        Name identifier11 = Name.identifier("nextChar");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(...)");
        NEXT_CHAR = identifier11;
        Name identifier12 = Name.identifier("it");
        Intrinsics.checkNotNullExpressionValue(identifier12, "identifier(...)");
        IMPLICIT_LAMBDA_PARAMETER_NAME = identifier12;
        Name identifier13 = Name.identifier("count");
        Intrinsics.checkNotNullExpressionValue(identifier13, "identifier(...)");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = identifier13;
        FqName fqName = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = fqName;
        FqName child = fqName.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(child, "child(...)");
        CONTINUATION_INTERFACE_FQ_NAME = child;
        FqName fqName2 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = fqName2;
        Name identifier14 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(identifier14, "identifier(...)");
        BUILT_INS_PACKAGE_NAME = identifier14;
        FqName fqName3 = FqName.topLevel(identifier14);
        Intrinsics.checkNotNullExpressionValue(fqName3, "topLevel(...)");
        BUILT_INS_PACKAGE_FQ_NAME = fqName3;
        FqName child2 = fqName3.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child2, "child(...)");
        ANNOTATION_PACKAGE_FQ_NAME = child2;
        FqName child3 = fqName3.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(child3, "child(...)");
        COLLECTIONS_PACKAGE_FQ_NAME = child3;
        FqName child4 = fqName3.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(child4, "child(...)");
        RANGES_PACKAGE_FQ_NAME = child4;
        FqName child5 = fqName3.child(Name.identifier("text"));
        Intrinsics.checkNotNullExpressionValue(child5, "child(...)");
        TEXT_PACKAGE_FQ_NAME = child5;
        FqName child6 = fqName3.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child6, "child(...)");
        KOTLIN_INTERNAL_FQ_NAME = child6;
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(fqName3, child3, child4, child2, fqName2, child6, fqName);
    }

    /* compiled from: StandardNames.kt */
    public static final class FqNames {
        public static final FqNames INSTANCE;
        public static final FqNameUnsafe _boolean;
        public static final FqNameUnsafe _byte;
        public static final FqNameUnsafe _char;
        public static final FqNameUnsafe _double;
        public static final FqNameUnsafe _enum;
        public static final FqNameUnsafe _float;
        public static final FqNameUnsafe _int;
        public static final FqNameUnsafe _long;
        public static final FqNameUnsafe _short;
        public static final FqName accessibleLateinitPropertyLiteral;
        public static final FqName annotation;
        public static final FqName annotationRetention;
        public static final FqName annotationTarget;
        public static final FqNameUnsafe any;
        public static final FqNameUnsafe array;
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType;
        public static final FqNameUnsafe charSequence;
        public static final FqNameUnsafe cloneable;
        public static final FqName collection;
        public static final FqName comparable;
        public static final FqName contextFunctionTypeParams;
        public static final FqName deprecated;
        public static final FqName deprecatedSinceKotlin;
        public static final FqName deprecationLevel;
        public static final FqName extensionFunctionType;
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType;
        public static final FqNameUnsafe functionSupertype;
        public static final FqNameUnsafe intRange;
        public static final FqName iterable;
        public static final FqName iterator;
        public static final FqNameUnsafe kCallable = reflect("KCallable");
        public static final FqNameUnsafe kClass = reflect("KClass");
        public static final FqNameUnsafe kDeclarationContainer = reflect("KDeclarationContainer");
        public static final FqNameUnsafe kMutableProperty0 = reflect("KMutableProperty0");
        public static final FqNameUnsafe kMutableProperty1 = reflect("KMutableProperty1");
        public static final FqNameUnsafe kMutableProperty2 = reflect("KMutableProperty2");
        public static final FqNameUnsafe kMutablePropertyFqName = reflect("KMutableProperty");
        public static final ClassId kProperty;
        public static final FqNameUnsafe kProperty0 = reflect("KProperty0");
        public static final FqNameUnsafe kProperty1 = reflect("KProperty1");
        public static final FqNameUnsafe kProperty2 = reflect("KProperty2");
        public static final FqNameUnsafe kPropertyFqName;
        public static final FqNameUnsafe kType = reflect("KType");
        public static final FqName list;
        public static final FqName listIterator;
        public static final FqNameUnsafe longRange;
        public static final FqName map;
        public static final FqName mapEntry;
        public static final FqName mustBeDocumented;
        public static final FqName mutableCollection;
        public static final FqName mutableIterable;
        public static final FqName mutableIterator;
        public static final FqName mutableList;
        public static final FqName mutableListIterator;
        public static final FqName mutableMap;
        public static final FqName mutableMapEntry;
        public static final FqName mutableSet;
        public static final FqNameUnsafe nothing;
        public static final FqNameUnsafe number;
        public static final FqName parameterName;
        public static final ClassId parameterNameClassId;
        public static final Set<Name> primitiveArrayTypeShortNames;
        public static final Set<Name> primitiveTypeShortNames;
        public static final FqName publishedApi;
        public static final FqName repeatable;
        public static final ClassId repeatableClassId;
        public static final FqName replaceWith;
        public static final FqName retention;
        public static final ClassId retentionClassId;
        public static final FqName set;
        public static final FqNameUnsafe string;
        public static final FqName suppress;
        public static final FqName target;
        public static final ClassId targetClassId;
        public static final FqName throwable;
        public static final ClassId uByte;
        public static final FqName uByteArrayFqName;
        public static final FqName uByteFqName;
        public static final ClassId uInt;
        public static final FqName uIntArrayFqName;
        public static final FqName uIntFqName;
        public static final ClassId uLong;
        public static final FqName uLongArrayFqName;
        public static final FqName uLongFqName;
        public static final ClassId uShort;
        public static final FqName uShortArrayFqName;
        public static final FqName uShortFqName;
        public static final FqNameUnsafe unit;
        public static final FqName unsafeVariance;

        private FqNames() {
        }

        static {
            FqNames fqNames = new FqNames();
            INSTANCE = fqNames;
            any = fqNames.fqNameUnsafe("Any");
            nothing = fqNames.fqNameUnsafe("Nothing");
            cloneable = fqNames.fqNameUnsafe("Cloneable");
            suppress = fqNames.fqName("Suppress");
            unit = fqNames.fqNameUnsafe("Unit");
            charSequence = fqNames.fqNameUnsafe("CharSequence");
            string = fqNames.fqNameUnsafe("String");
            array = fqNames.fqNameUnsafe("Array");
            _boolean = fqNames.fqNameUnsafe("Boolean");
            _char = fqNames.fqNameUnsafe("Char");
            _byte = fqNames.fqNameUnsafe("Byte");
            _short = fqNames.fqNameUnsafe("Short");
            _int = fqNames.fqNameUnsafe("Int");
            _long = fqNames.fqNameUnsafe("Long");
            _float = fqNames.fqNameUnsafe("Float");
            _double = fqNames.fqNameUnsafe("Double");
            number = fqNames.fqNameUnsafe("Number");
            _enum = fqNames.fqNameUnsafe("Enum");
            functionSupertype = fqNames.fqNameUnsafe("Function");
            throwable = fqNames.fqName("Throwable");
            comparable = fqNames.fqName("Comparable");
            intRange = fqNames.rangesFqName("IntRange");
            longRange = fqNames.rangesFqName("LongRange");
            deprecated = fqNames.fqName("Deprecated");
            deprecatedSinceKotlin = fqNames.fqName("DeprecatedSinceKotlin");
            deprecationLevel = fqNames.fqName("DeprecationLevel");
            replaceWith = fqNames.fqName("ReplaceWith");
            extensionFunctionType = fqNames.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = fqNames.fqName("ContextFunctionTypeParams");
            FqName fqName = fqNames.fqName("ParameterName");
            parameterName = fqName;
            ClassId classId = ClassId.topLevel(fqName);
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(...)");
            parameterNameClassId = classId;
            annotation = fqNames.fqName("Annotation");
            FqName annotationName = fqNames.annotationName("Target");
            target = annotationName;
            ClassId classId2 = ClassId.topLevel(annotationName);
            Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(...)");
            targetClassId = classId2;
            annotationTarget = fqNames.annotationName("AnnotationTarget");
            annotationRetention = fqNames.annotationName("AnnotationRetention");
            FqName annotationName2 = fqNames.annotationName("Retention");
            retention = annotationName2;
            ClassId classId3 = ClassId.topLevel(annotationName2);
            Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(...)");
            retentionClassId = classId3;
            FqName annotationName3 = fqNames.annotationName("Repeatable");
            repeatable = annotationName3;
            ClassId classId4 = ClassId.topLevel(annotationName3);
            Intrinsics.checkNotNullExpressionValue(classId4, "topLevel(...)");
            repeatableClassId = classId4;
            mustBeDocumented = fqNames.annotationName("MustBeDocumented");
            unsafeVariance = fqNames.fqName("UnsafeVariance");
            publishedApi = fqNames.fqName("PublishedApi");
            accessibleLateinitPropertyLiteral = fqNames.internalName("AccessibleLateinitPropertyLiteral");
            iterator = fqNames.collectionsFqName("Iterator");
            iterable = fqNames.collectionsFqName("Iterable");
            collection = fqNames.collectionsFqName("Collection");
            list = fqNames.collectionsFqName("List");
            listIterator = fqNames.collectionsFqName("ListIterator");
            set = fqNames.collectionsFqName("Set");
            FqName collectionsFqName = fqNames.collectionsFqName("Map");
            map = collectionsFqName;
            FqName child = collectionsFqName.child(Name.identifier("Entry"));
            Intrinsics.checkNotNullExpressionValue(child, "child(...)");
            mapEntry = child;
            mutableIterator = fqNames.collectionsFqName("MutableIterator");
            mutableIterable = fqNames.collectionsFqName("MutableIterable");
            mutableCollection = fqNames.collectionsFqName("MutableCollection");
            mutableList = fqNames.collectionsFqName("MutableList");
            mutableListIterator = fqNames.collectionsFqName("MutableListIterator");
            mutableSet = fqNames.collectionsFqName("MutableSet");
            FqName collectionsFqName2 = fqNames.collectionsFqName("MutableMap");
            mutableMap = collectionsFqName2;
            FqName child2 = collectionsFqName2.child(Name.identifier("MutableEntry"));
            Intrinsics.checkNotNullExpressionValue(child2, "child(...)");
            mutableMapEntry = child2;
            FqNameUnsafe reflect = reflect("KProperty");
            kPropertyFqName = reflect;
            ClassId classId5 = ClassId.topLevel(reflect.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId5, "topLevel(...)");
            kProperty = classId5;
            FqName fqName2 = fqNames.fqName("UByte");
            uByteFqName = fqName2;
            FqName fqName3 = fqNames.fqName("UShort");
            uShortFqName = fqName3;
            FqName fqName4 = fqNames.fqName("UInt");
            uIntFqName = fqName4;
            FqName fqName5 = fqNames.fqName("ULong");
            uLongFqName = fqName5;
            ClassId classId6 = ClassId.topLevel(fqName2);
            Intrinsics.checkNotNullExpressionValue(classId6, "topLevel(...)");
            uByte = classId6;
            ClassId classId7 = ClassId.topLevel(fqName3);
            Intrinsics.checkNotNullExpressionValue(classId7, "topLevel(...)");
            uShort = classId7;
            ClassId classId8 = ClassId.topLevel(fqName4);
            Intrinsics.checkNotNullExpressionValue(classId8, "topLevel(...)");
            uInt = classId8;
            ClassId classId9 = ClassId.topLevel(fqName5);
            Intrinsics.checkNotNullExpressionValue(classId9, "topLevel(...)");
            uLong = classId9;
            uByteArrayFqName = fqNames.fqName("UByteArray");
            uShortArrayFqName = fqNames.fqName("UShortArray");
            uIntArrayFqName = fqNames.fqName("UIntArray");
            uLongArrayFqName = fqNames.fqName("ULongArray");
            HashSet newHashSetWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType typeName : PrimitiveType.values()) {
                newHashSetWithExpectedSize.add(typeName.getTypeName());
            }
            Collection collection2 = newHashSetWithExpectedSize;
            primitiveTypeShortNames = newHashSetWithExpectedSize;
            HashSet newHashSetWithExpectedSize2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType arrayTypeName : PrimitiveType.values()) {
                newHashSetWithExpectedSize2.add(arrayTypeName.getArrayTypeName());
            }
            Collection collection3 = newHashSetWithExpectedSize2;
            primitiveArrayTypeShortNames = newHashSetWithExpectedSize2;
            HashMap newHashMapWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                FqNames fqNames2 = INSTANCE;
                String asString = primitiveType.getTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                newHashMapWithExpectedSize.put(fqNames2.fqNameUnsafe(asString), primitiveType);
            }
            fqNameToPrimitiveType = newHashMapWithExpectedSize;
            HashMap newHashMapWithExpectedSize2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType2 : PrimitiveType.values()) {
                FqNames fqNames3 = INSTANCE;
                String asString2 = primitiveType2.getArrayTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
                newHashMapWithExpectedSize2.put(fqNames3.fqNameUnsafe(asString2), primitiveType2);
            }
            arrayClassFqNameToPrimitiveType = newHashMapWithExpectedSize2;
        }

        private final FqNameUnsafe fqNameUnsafe(String str) {
            FqNameUnsafe unsafe = fqName(str).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "toUnsafe(...)");
            return unsafe;
        }

        private final FqName fqName(String str) {
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "child(...)");
            return child;
        }

        private final FqName collectionsFqName(String str) {
            FqName child = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "child(...)");
            return child;
        }

        private final FqNameUnsafe rangesFqName(String str) {
            FqNameUnsafe unsafe = StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "toUnsafe(...)");
            return unsafe;
        }

        @JvmStatic
        public static final FqNameUnsafe reflect(String str) {
            Intrinsics.checkNotNullParameter(str, "simpleName");
            FqNameUnsafe unsafe = StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "toUnsafe(...)");
            return unsafe;
        }

        private final FqName annotationName(String str) {
            FqName child = StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "child(...)");
            return child;
        }

        private final FqName internalName(String str) {
            FqName child = StandardNames.KOTLIN_INTERNAL_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "child(...)");
            return child;
        }
    }

    @JvmStatic
    public static final String getFunctionName(int i) {
        return "Function" + i;
    }

    @JvmStatic
    public static final ClassId getFunctionClassId(int i) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(i)));
    }

    @JvmStatic
    public static final String getSuspendFunctionName(int i) {
        return FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix() + i;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "arrayFqName");
        return FqNames.arrayClassFqNameToPrimitiveType.get(fqNameUnsafe) != null;
    }

    @JvmStatic
    public static final FqName getPrimitiveFqName(PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        FqName child = BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
        Intrinsics.checkNotNullExpressionValue(child, "child(...)");
        return child;
    }
}
