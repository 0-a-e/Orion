package kotlin.reflect.jvm.internal.impl.name;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FqNamesUtil.kt */
public final class FqNamesUtilKt {

    /* compiled from: FqNamesUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.name.State[] r0 = kotlin.reflect.jvm.internal.impl.name.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.name.State r1 = kotlin.reflect.jvm.internal.impl.name.State.BEGINNING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.jvm.internal.impl.name.State r1 = kotlin.reflect.jvm.internal.impl.name.State.AFTER_DOT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.jvm.internal.impl.name.State r1 = kotlin.reflect.jvm.internal.impl.name.State.MIDDLE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.WhenMappings.<clinit>():void");
        }
    }

    public static final boolean isSubpackageOf(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        if (Intrinsics.areEqual((Object) fqName, (Object) fqName2) || fqName2.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        String asString2 = fqName2.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
        return isSubpackageOf(asString, asString2);
    }

    public static final boolean isChildOf(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        return Intrinsics.areEqual((Object) parentOrNull(fqName), (Object) fqName2);
    }

    private static final boolean isSubpackageOf(String str, String str2) {
        return StringsKt.startsWith$default(str, str2, false, 2, (Object) null) && str.charAt(str2.length()) == '.';
    }

    public static final FqName tail(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, "prefix");
        if (!isSubpackageOf(fqName, fqName2) || fqName2.isRoot()) {
            return fqName;
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) fqName2)) {
            FqName fqName3 = FqName.ROOT;
            Intrinsics.checkNotNullExpressionValue(fqName3, "ROOT");
            return fqName3;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        String substring = asString.substring(fqName2.asString().length() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return new FqName(substring);
    }

    public static final FqName parentOrNull(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        if (fqName.isRoot()) {
            return null;
        }
        return fqName.parent();
    }

    public static final boolean isValidJavaFqName(String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (!Character.isJavaIdentifierStart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i2 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        if (state != State.AFTER_DOT) {
            return true;
        }
        return false;
    }

    public static final <V> V findValueForMostSpecificFqname(FqName fqName, Map<FqName, ? extends V> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(map, "values");
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            FqName fqName2 = (FqName) next.getKey();
            if (Intrinsics.areEqual((Object) fqName, (Object) fqName2) || isChildOf(fqName, fqName2)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            obj = it.next();
            if (it.hasNext()) {
                int length = tail((FqName) ((Map.Entry) obj).getKey(), fqName).asString().length();
                do {
                    Object next2 = it.next();
                    int length2 = tail((FqName) ((Map.Entry) next2).getKey(), fqName).asString().length();
                    if (length > length2) {
                        obj = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }
}
