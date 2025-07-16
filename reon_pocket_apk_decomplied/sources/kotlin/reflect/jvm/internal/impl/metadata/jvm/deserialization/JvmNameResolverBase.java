package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: JvmNameResolverBase.kt */
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final List<String> PREDEFINED_STRINGS;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f67kotlin;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    /* compiled from: JvmNameResolverBase.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$Operation[] r0 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$Operation r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$Operation r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$Operation r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverBase.WhenMappings.<clinit>():void");
        }
    }

    public JvmNameResolverBase(String[] strArr, Set<Integer> set, List<JvmProtoBuf.StringTableTypes.Record> list) {
        Intrinsics.checkNotNullParameter(strArr, "strings");
        Intrinsics.checkNotNullParameter(set, "localNameIndices");
        Intrinsics.checkNotNullParameter(list, "records");
        this.strings = strArr;
        this.localNameIndices = set;
        this.records = list;
    }

    public String getString(int i) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = PREDEFINED_STRINGS;
                int size = list.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex < size) {
                    str = list.get(record.getPredefinedIndex());
                }
            }
            str = this.strings[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNull(substringIndexList);
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            Intrinsics.checkNotNull(num);
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                Intrinsics.checkNotNull(num2);
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    Intrinsics.checkNotNull(str);
                    str = str.substring(num.intValue(), num2.intValue());
                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNull(replaceCharList);
            Intrinsics.checkNotNull(str2);
            str2 = StringsKt.replace$default(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, (Object) null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 == 2) {
            Intrinsics.checkNotNull(str3);
            str3 = StringsKt.replace$default(str3, (char) Typography.dollar, '.', false, 4, (Object) null);
        } else if (i2 == 3) {
            if (str3.length() >= 2) {
                Intrinsics.checkNotNull(str3);
                str3 = str3.substring(1, str3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
            }
            String str4 = str3;
            Intrinsics.checkNotNull(str4);
            str3 = StringsKt.replace$default(str4, (char) Typography.dollar, '.', false, 4, (Object) null);
        }
        Intrinsics.checkNotNull(str3);
        return str3;
    }

    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(Integer.valueOf(i));
    }

    /* compiled from: JvmNameResolverBase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf('k', 'o', 't', 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        f67kotlin = joinToString$default;
        List<String> listOf = CollectionsKt.listOf(joinToString$default + "/Any", joinToString$default + "/Nothing", joinToString$default + "/Unit", joinToString$default + "/Throwable", joinToString$default + "/Number", joinToString$default + "/Byte", joinToString$default + "/Double", joinToString$default + "/Float", joinToString$default + "/Int", joinToString$default + "/Long", joinToString$default + "/Short", joinToString$default + "/Boolean", joinToString$default + "/Char", joinToString$default + "/CharSequence", joinToString$default + "/String", joinToString$default + "/Comparable", joinToString$default + "/Enum", joinToString$default + "/Array", joinToString$default + "/ByteArray", joinToString$default + "/DoubleArray", joinToString$default + "/FloatArray", joinToString$default + "/IntArray", joinToString$default + "/LongArray", joinToString$default + "/ShortArray", joinToString$default + "/BooleanArray", joinToString$default + "/CharArray", joinToString$default + "/Cloneable", joinToString$default + "/Annotation", joinToString$default + "/collections/Iterable", joinToString$default + "/collections/MutableIterable", joinToString$default + "/collections/Collection", joinToString$default + "/collections/MutableCollection", joinToString$default + "/collections/List", joinToString$default + "/collections/MutableList", joinToString$default + "/collections/Set", joinToString$default + "/collections/MutableSet", joinToString$default + "/collections/Map", joinToString$default + "/collections/MutableMap", joinToString$default + "/collections/Map.Entry", joinToString$default + "/collections/MutableMap.MutableEntry", joinToString$default + "/collections/Iterator", joinToString$default + "/collections/MutableIterator", joinToString$default + "/collections/ListIterator", joinToString$default + "/collections/MutableListIterator");
        PREDEFINED_STRINGS = listOf;
        Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(listOf);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }
}
