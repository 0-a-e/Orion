package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.enums.EnumEntriesKt;

/* compiled from: ClassKind.kt */
public enum ClassKind {
    CLASS("class"),
    INTERFACE("interface"),
    ENUM_CLASS("enum class"),
    ENUM_ENTRY((String) null),
    ANNOTATION_CLASS("annotation class"),
    OBJECT("object");
    
    private final String codeRepresentation;

    private ClassKind(String str) {
        this.codeRepresentation = str;
    }

    static {
        ClassKind[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }

    public final boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
