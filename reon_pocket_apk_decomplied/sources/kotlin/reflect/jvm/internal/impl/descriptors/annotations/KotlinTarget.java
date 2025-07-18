package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KotlinTarget.kt */
public enum KotlinTarget {
    CLASS("class", false, 2, (boolean) null),
    ANNOTATION_CLASS("annotation class", false, 2, (boolean) null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, (boolean) null),
    FIELD("field", false, 2, (boolean) null),
    LOCAL_VARIABLE("local variable", false, 2, (boolean) null),
    VALUE_PARAMETER("value parameter", false, 2, (boolean) null),
    CONSTRUCTOR("constructor", false, 2, (boolean) null),
    FUNCTION("function", false, 2, (boolean) null),
    PROPERTY_GETTER("getter", false, 2, (boolean) null),
    PROPERTY_SETTER("setter", false, 2, (boolean) null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE(TransferTable.COLUMN_FILE, false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    STANDALONE_OBJECT("standalone object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    BACKING_FIELD("backing field", false, 2, (boolean) null),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    private static final Set<KotlinTarget> ALL_TARGET_SET = null;
    private static final List<KotlinTarget> ANNOTATION_CLASS_LIST = null;
    private static final List<KotlinTarget> CLASS_LIST = null;
    private static final List<KotlinTarget> COMPANION_OBJECT_LIST = null;
    public static final Companion Companion = null;
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET = null;
    private static final List<KotlinTarget> ENUM_ENTRY_LIST = null;
    private static final List<KotlinTarget> ENUM_LIST = null;
    private static final List<KotlinTarget> FILE_LIST = null;
    private static final List<KotlinTarget> FUNCTION_LIST = null;
    private static final List<KotlinTarget> INTERFACE_LIST = null;
    private static final List<KotlinTarget> LOCAL_CLASS_LIST = null;
    private static final List<KotlinTarget> OBJECT_LIST = null;
    private static final List<KotlinTarget> PROPERTY_GETTER_LIST = null;
    private static final List<KotlinTarget> PROPERTY_SETTER_LIST = null;
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING = null;
    private static final HashMap<String, KotlinTarget> map = null;
    private final String description;
    private final boolean isDefault;

    private KotlinTarget(String str, boolean z) {
        this.description = str;
        this.isDefault = z;
    }

    static {
        KotlinTarget[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
        map = new HashMap<>();
        for (KotlinTarget kotlinTarget : values()) {
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] values = values();
        Collection arrayList = new ArrayList();
        for (KotlinTarget kotlinTarget2 : values) {
            if (kotlinTarget2.isDefault) {
                arrayList.add(kotlinTarget2);
            }
        }
        DEFAULT_TARGET_SET = CollectionsKt.toSet((List) arrayList);
        ALL_TARGET_SET = ArraysKt.toSet((T[]) values());
        KotlinTarget kotlinTarget3 = CLASS;
        ANNOTATION_CLASS_LIST = CollectionsKt.listOf(ANNOTATION_CLASS, kotlinTarget3);
        LOCAL_CLASS_LIST = CollectionsKt.listOf(LOCAL_CLASS, kotlinTarget3);
        CLASS_LIST = CollectionsKt.listOf(CLASS_ONLY, kotlinTarget3);
        KotlinTarget kotlinTarget4 = OBJECT;
        COMPANION_OBJECT_LIST = CollectionsKt.listOf(COMPANION_OBJECT, kotlinTarget4, kotlinTarget3);
        OBJECT_LIST = CollectionsKt.listOf(STANDALONE_OBJECT, kotlinTarget4, kotlinTarget3);
        INTERFACE_LIST = CollectionsKt.listOf(INTERFACE, kotlinTarget3);
        ENUM_LIST = CollectionsKt.listOf(ENUM_CLASS, kotlinTarget3);
        KotlinTarget kotlinTarget5 = PROPERTY;
        KotlinTarget kotlinTarget6 = FIELD;
        ENUM_ENTRY_LIST = CollectionsKt.listOf(ENUM_ENTRY, kotlinTarget5, kotlinTarget6);
        KotlinTarget kotlinTarget7 = PROPERTY_SETTER;
        PROPERTY_SETTER_LIST = CollectionsKt.listOf(kotlinTarget7);
        KotlinTarget kotlinTarget8 = PROPERTY_GETTER;
        PROPERTY_GETTER_LIST = CollectionsKt.listOf(kotlinTarget8);
        FUNCTION_LIST = CollectionsKt.listOf(FUNCTION);
        KotlinTarget kotlinTarget9 = FILE;
        FILE_LIST = CollectionsKt.listOf(kotlinTarget9);
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget kotlinTarget10 = VALUE_PARAMETER;
        USE_SITE_MAPPING = MapsKt.mapOf(TuplesKt.to(annotationUseSiteTarget, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.FIELD, kotlinTarget6), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, kotlinTarget5), TuplesKt.to(AnnotationUseSiteTarget.FILE, kotlinTarget9), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, kotlinTarget8), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, kotlinTarget7), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget6));
    }

    /* compiled from: KotlinTarget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
