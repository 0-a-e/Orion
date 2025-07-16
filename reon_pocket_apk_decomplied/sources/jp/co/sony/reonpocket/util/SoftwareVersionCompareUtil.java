package jp.co.sony.reonpocket.util;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/util/SoftwareVersionCompareUtil;", "", "()V", "compareVersion", "Ljp/co/sony/reonpocket/util/SoftwareVersionCompareUtil$CompareResult;", "aFirstVersion", "", "aSecondVersion", "compareVersionIgnoreBuildVersion", "getResult", "aTempRes", "", "isValidFirm", "", "aRevisionNumber", "CompareResult", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SoftwareVersionCompareUtil.kt */
public final class SoftwareVersionCompareUtil {
    public static final int $stable = 0;
    public static final SoftwareVersionCompareUtil INSTANCE = new SoftwareVersionCompareUtil();

    private SoftwareVersionCompareUtil() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/util/SoftwareVersionCompareUtil$CompareResult;", "", "(Ljava/lang/String;I)V", "INVALID", "SAME", "ASCENDING", "DESCENDING", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SoftwareVersionCompareUtil.kt */
    public enum CompareResult {
        INVALID,
        SAME,
        ASCENDING,
        DESCENDING;

        public static EnumEntries<CompareResult> getEntries() {
            return $ENTRIES;
        }

        static {
            CompareResult[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final boolean isValidFirm(String str) {
        Intrinsics.checkNotNullParameter(str, "aRevisionNumber");
        CharSequence charSequence = str;
        if (!new Regex("^[0-9.]+$").matches(charSequence)) {
            return false;
        }
        List split$default = StringsKt.split$default(charSequence, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
        if (split$default.size() != 3 || split$default.contains("")) {
            return false;
        }
        return true;
    }

    public final CompareResult compareVersion(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "aFirstVersion");
        Intrinsics.checkNotNullParameter(str4, "aSecondVersion");
        try {
            Integer valueOf = Integer.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) str4, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(0)));
            Integer valueOf2 = Integer.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) str4, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(1)));
            Integer valueOf3 = Integer.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) str4, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(2)));
            try {
                int parseInt = Integer.parseInt((String) StringsKt.split$default((CharSequence) str3, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(0));
                Integer valueOf4 = Integer.valueOf(parseInt);
                int parseInt2 = Integer.parseInt((String) StringsKt.split$default((CharSequence) str3, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(1));
                Integer valueOf5 = Integer.valueOf(parseInt2);
                int parseInt3 = Integer.parseInt((String) StringsKt.split$default((CharSequence) str3, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(2));
                Integer valueOf6 = Integer.valueOf(parseInt3);
                if (!Intrinsics.areEqual((Object) valueOf4, (Object) valueOf)) {
                    SoftwareVersionCompareUtil softwareVersionCompareUtil = INSTANCE;
                    valueOf4.getClass();
                    return softwareVersionCompareUtil.getResult(Integer.compare(parseInt, valueOf.intValue()));
                } else if (!Intrinsics.areEqual((Object) valueOf5, (Object) valueOf2)) {
                    SoftwareVersionCompareUtil softwareVersionCompareUtil2 = INSTANCE;
                    valueOf5.getClass();
                    return softwareVersionCompareUtil2.getResult(Integer.compare(parseInt2, valueOf2.intValue()));
                } else if (Intrinsics.areEqual((Object) valueOf6, (Object) valueOf3)) {
                    return CompareResult.SAME;
                } else {
                    SoftwareVersionCompareUtil softwareVersionCompareUtil3 = INSTANCE;
                    valueOf6.getClass();
                    return softwareVersionCompareUtil3.getResult(Integer.compare(parseInt3, valueOf3.intValue()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                DebugLogUtil.INSTANCE.e("local firmware reversion's format error");
                return CompareResult.INVALID;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            DebugLogUtil.INSTANCE.e("device firmware reversion's format error");
            return CompareResult.INVALID;
        }
    }

    public final CompareResult compareVersionIgnoreBuildVersion(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "aFirstVersion");
        Intrinsics.checkNotNullParameter(str2, "aSecondVersion");
        try {
            Integer valueOf = Integer.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) str2, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(0)));
            Integer valueOf2 = Integer.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) str2, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(1)));
            try {
                int parseInt = Integer.parseInt((String) StringsKt.split$default((CharSequence) str, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(0));
                Integer valueOf3 = Integer.valueOf(parseInt);
                int parseInt2 = Integer.parseInt((String) StringsKt.split$default((CharSequence) str, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(1));
                Integer valueOf4 = Integer.valueOf(parseInt2);
                if (!Intrinsics.areEqual((Object) valueOf3, (Object) valueOf)) {
                    SoftwareVersionCompareUtil softwareVersionCompareUtil = INSTANCE;
                    valueOf3.getClass();
                    return softwareVersionCompareUtil.getResult(Integer.compare(parseInt, valueOf.intValue()));
                } else if (Intrinsics.areEqual((Object) valueOf4, (Object) valueOf2)) {
                    return CompareResult.SAME;
                } else {
                    SoftwareVersionCompareUtil softwareVersionCompareUtil2 = INSTANCE;
                    valueOf4.getClass();
                    return softwareVersionCompareUtil2.getResult(Integer.compare(parseInt2, valueOf2.intValue()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                DebugLogUtil.INSTANCE.e("local firmware reversion's format error");
                return CompareResult.INVALID;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            DebugLogUtil.INSTANCE.e("device firmware reversion's format error");
            return CompareResult.INVALID;
        }
    }

    private final CompareResult getResult(int i) {
        if (i == -1) {
            return CompareResult.ASCENDING;
        }
        if (i == 0) {
            return CompareResult.SAME;
        }
        if (i != 1) {
            return CompareResult.INVALID;
        }
        return CompareResult.DESCENDING;
    }
}
