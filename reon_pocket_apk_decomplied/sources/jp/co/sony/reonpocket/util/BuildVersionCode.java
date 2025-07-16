package jp.co.sony.reonpocket.util;

import android.os.Build;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/util/BuildVersionCode;", "", "(Ljava/lang/String;I)V", "requestBluetoothPermissionList", "", "", "getRequestBluetoothPermissionList", "()[Ljava/lang/String;", "requestLocationPermissionList", "getRequestLocationPermissionList", "CODE_OVER_TIRAMISU", "CODE_OVER_S", "CODE_OVER_Q", "CODE_UNDER_P", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionUtil.kt */
public enum BuildVersionCode {
    ;
    
    /* access modifiers changed from: private */
    public static final String[] BLUETOOTH_PERMISSION_LIST = null;
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final String[] LOCATION_PERMISSION_LIST_Q = null;
    /* access modifiers changed from: private */
    public static final String[] LOCATION_PERMISSION_LIST_S = null;
    /* access modifiers changed from: private */
    public static final String[] LOCATION_PERMISSION_LIST_TIRAMISU = null;

    public static EnumEntries<BuildVersionCode> getEntries() {
        return $ENTRIES;
    }

    public abstract String[] getRequestBluetoothPermissionList();

    public abstract String[] getRequestLocationPermissionList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0001\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/util/BuildVersionCode$CODE_OVER_TIRAMISU;", "Ljp/co/sony/reonpocket/util/BuildVersionCode;", "requestBluetoothPermissionList", "", "", "getRequestBluetoothPermissionList", "()[Ljava/lang/String;", "requestLocationPermissionList", "getRequestLocationPermissionList", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionUtil.kt */
    static final class CODE_OVER_TIRAMISU extends BuildVersionCode {
        CODE_OVER_TIRAMISU(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public String[] getRequestLocationPermissionList() {
            return BuildVersionCode.LOCATION_PERMISSION_LIST_TIRAMISU;
        }

        public String[] getRequestBluetoothPermissionList() {
            return BuildVersionCode.BLUETOOTH_PERMISSION_LIST;
        }
    }

    static {
        BuildVersionCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
        LOCATION_PERMISSION_LIST_TIRAMISU = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
        LOCATION_PERMISSION_LIST_S = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
        LOCATION_PERMISSION_LIST_Q = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        BLUETOOTH_PERMISSION_LIST = new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0001\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/util/BuildVersionCode$CODE_OVER_S;", "Ljp/co/sony/reonpocket/util/BuildVersionCode;", "requestBluetoothPermissionList", "", "", "getRequestBluetoothPermissionList", "()[Ljava/lang/String;", "requestLocationPermissionList", "getRequestLocationPermissionList", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionUtil.kt */
    static final class CODE_OVER_S extends BuildVersionCode {
        CODE_OVER_S(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public String[] getRequestLocationPermissionList() {
            return BuildVersionCode.LOCATION_PERMISSION_LIST_S;
        }

        public String[] getRequestBluetoothPermissionList() {
            return BuildVersionCode.BLUETOOTH_PERMISSION_LIST;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/util/BuildVersionCode$CODE_OVER_Q;", "Ljp/co/sony/reonpocket/util/BuildVersionCode;", "requestBluetoothPermissionList", "", "", "getRequestBluetoothPermissionList", "()[Ljava/lang/String;", "requestLocationPermissionList", "getRequestLocationPermissionList", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionUtil.kt */
    static final class CODE_OVER_Q extends BuildVersionCode {
        public String[] getRequestBluetoothPermissionList() {
            return new String[0];
        }

        CODE_OVER_Q(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public String[] getRequestLocationPermissionList() {
            return BuildVersionCode.LOCATION_PERMISSION_LIST_Q;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/util/BuildVersionCode$CODE_UNDER_P;", "Ljp/co/sony/reonpocket/util/BuildVersionCode;", "requestBluetoothPermissionList", "", "", "getRequestBluetoothPermissionList", "()[Ljava/lang/String;", "requestLocationPermissionList", "getRequestLocationPermissionList", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionUtil.kt */
    static final class CODE_UNDER_P extends BuildVersionCode {
        public String[] getRequestBluetoothPermissionList() {
            return new String[0];
        }

        CODE_UNDER_P(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public String[] getRequestLocationPermissionList() {
            return BuildVersionCode.LOCATION_PERMISSION_LIST_Q;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/util/BuildVersionCode$Companion;", "", "()V", "BLUETOOTH_PERMISSION_LIST", "", "", "[Ljava/lang/String;", "LOCATION_PERMISSION_LIST_Q", "LOCATION_PERMISSION_LIST_S", "LOCATION_PERMISSION_LIST_TIRAMISU", "getNowBuildVersionCodeType", "Ljp/co/sony/reonpocket/util/BuildVersionCode;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BuildVersionCode getNowBuildVersionCodeType() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                return BuildVersionCode.CODE_OVER_TIRAMISU;
            }
            if (i == 31 || i == 32) {
                return BuildVersionCode.CODE_OVER_S;
            }
            if (i == 29 || i == 30) {
                return BuildVersionCode.CODE_OVER_Q;
            }
            return BuildVersionCode.CODE_UNDER_P;
        }
    }
}
