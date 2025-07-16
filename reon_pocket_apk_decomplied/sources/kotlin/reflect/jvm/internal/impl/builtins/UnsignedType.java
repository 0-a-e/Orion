package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: UnsignedType.kt */
public enum UnsignedType {
    UBYTE(r1),
    USHORT(r1),
    UINT(r1),
    ULONG(r1);
    
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    private UnsignedType(ClassId classId2) {
        this.classId = classId2;
        Name shortClassName = classId2.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(shortClassName, "getShortClassName(...)");
        this.typeName = shortClassName;
        FqName packageFqName = classId2.getPackageFqName();
        this.arrayClassId = new ClassId(packageFqName, Name.identifier(shortClassName.asString() + "Array"));
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    static {
        UnsignedType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }
}
