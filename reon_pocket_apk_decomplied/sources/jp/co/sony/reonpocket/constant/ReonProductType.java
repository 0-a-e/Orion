package jp.co.sony.reonpocket.constant;

import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/constant/ReonProductType;", "", "(Ljava/lang/String;I)V", "ORIGINAL", "PRO", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModelConstant.kt */
public enum ReonProductType {
    ORIGINAL,
    PRO;
    
    public static final Companion Companion = null;

    public static EnumEntries<ReonProductType> getEntries() {
        return $ENTRIES;
    }

    static {
        ReonProductType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/constant/ReonProductType$Companion;", "", "()V", "getReonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "aModelName", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ModelConstant.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReonProductType getReonProductType(String str) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if (Intrinsics.areEqual((Object) str, (Object) ModelConstant.ModelName.RNP_P1.getModel())) {
                return ReonProductType.PRO;
            }
            boolean z6 = true;
            if (Intrinsics.areEqual((Object) str, (Object) ModelConstant.ModelName.RNP_1.getModel())) {
                z = true;
            } else {
                z = Intrinsics.areEqual((Object) str, (Object) ModelConstant.ModelName.RNP_1A.getModel());
            }
            if (z) {
                z2 = true;
            } else {
                z2 = Intrinsics.areEqual((Object) str, (Object) ModelConstant.ModelName.RNP_1L.getModel());
            }
            if (z2) {
                z3 = true;
            } else {
                z3 = Intrinsics.areEqual((Object) str, (Object) ModelConstant.ModelName.RNP_2.getModel());
            }
            if (z3) {
                z4 = true;
            } else {
                z4 = Intrinsics.areEqual((Object) str, (Object) ModelConstant.ModelName.RNP_3.getModel());
            }
            if (z4) {
                z5 = true;
            } else {
                z5 = Intrinsics.areEqual((Object) str, (Object) ModelConstant.ModelName.RNP_4.getModel());
            }
            if (!z5) {
                z6 = Intrinsics.areEqual((Object) str, (Object) ModelConstant.ModelName.RNP_5.getModel());
            }
            if (z6) {
                return ReonProductType.ORIGINAL;
            }
            DebugLogUtil.INSTANCE.e("unknown type");
            return ReonProductType.ORIGINAL;
        }
    }
}
