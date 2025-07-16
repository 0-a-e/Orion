package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f66kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf('k', 'o', 't', 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    private static final Map<String, String> map;

    private ClassMapperLite() {
    }

    static {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        List listOf = CollectionsKt.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f66kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((String) listOf.get(i));
                int i2 = i + 1;
                linkedHashMap.put(sb.toString(), listOf.get(i2));
                linkedHashMap.put(str + '/' + ((String) listOf.get(i)) + "Array", "[" + ((String) listOf.get(i2)));
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        linkedHashMap.put(f66kotlin + "/Unit", "V");
        map$lambda$0$add(linkedHashMap, "Any", "java/lang/Object");
        map$lambda$0$add(linkedHashMap, "Nothing", "java/lang/Void");
        map$lambda$0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            map$lambda$0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : CollectionsKt.listOf("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            map$lambda$0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            map$lambda$0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        map$lambda$0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f66kotlin;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i3);
            map$lambda$0$add(linkedHashMap, "Function" + i3, sb2.toString());
            map$lambda$0$add(linkedHashMap, "reflect/KFunction" + i3, str4 + "/reflect/KFunction");
        }
        for (String str5 : CollectionsKt.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            map$lambda$0$add(linkedHashMap, str5 + ".Companion", f66kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private static final void map$lambda$0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f66kotlin + '/' + str, "L" + str2 + ';');
    }

    @JvmStatic
    public static final String mapClass(String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        return "L" + StringsKt.replace$default(str, '.', (char) Typography.dollar, false, 4, (Object) null) + ';';
    }
}
