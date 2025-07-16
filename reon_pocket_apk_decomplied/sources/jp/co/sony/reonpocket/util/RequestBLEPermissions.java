package jp.co.sony.reonpocket.util;

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceManager;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Ljp/co/sony/reonpocket/util/RequestBLEPermissions;", "", "code", "", "Permission", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getPermission", "()Ljava/lang/String;", "getCode", "()I", "getPreferenceCode", "isMarkPermissionRequested", "", "context", "Landroid/content/Context;", "isPermissionDeniedForever", "activity", "Landroid/app/Activity;", "markPermissionRequested", "", "requestPermission", "REQUEST_ACCESS_COARSE_LOCATION", "REQUEST_BLUETOOTH", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionUtil.kt */
public enum RequestBLEPermissions {
    ;
    
    public static final Companion Companion = null;
    private static final String preferenceCode = "RequestBLEPermissions_";
    private final String Permission;
    private final int code;
    private final String getPreferenceCode;

    public static EnumEntries<RequestBLEPermissions> getEntries() {
        return $ENTRIES;
    }

    public abstract boolean requestPermission(Context context);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/util/RequestBLEPermissions$REQUEST_ACCESS_COARSE_LOCATION;", "Ljp/co/sony/reonpocket/util/RequestBLEPermissions;", "requestPermission", "", "context", "Landroid/content/Context;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionUtil.kt */
    static final class REQUEST_ACCESS_COARSE_LOCATION extends RequestBLEPermissions {
        REQUEST_ACCESS_COARSE_LOCATION(String str, int i) {
            super(str, i, 1, "android.permission.ACCESS_COARSE_LOCATION", (DefaultConstructorMarker) null);
        }

        public boolean requestPermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return PermissionUtil.INSTANCE.isLocationPermissionsGranted(context);
        }
    }

    private RequestBLEPermissions(int i, String str) {
        this.code = i;
        this.Permission = str;
        String name = name();
        this.getPreferenceCode = preferenceCode + name;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getPermission() {
        return this.Permission;
    }

    static {
        RequestBLEPermissions[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/util/RequestBLEPermissions$REQUEST_BLUETOOTH;", "Ljp/co/sony/reonpocket/util/RequestBLEPermissions;", "requestPermission", "", "context", "Landroid/content/Context;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionUtil.kt */
    static final class REQUEST_BLUETOOTH extends RequestBLEPermissions {
        REQUEST_BLUETOOTH(String str, int i) {
            super(str, i, 2, "android.permission.BLUETOOTH_SCAN", (DefaultConstructorMarker) null);
        }

        public boolean requestPermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return PermissionUtil.INSTANCE.isBluetoothPermissionsGranted(context);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ljp/co/sony/reonpocket/util/RequestBLEPermissions$Companion;", "", "()V", "preferenceCode", "", "isAllRequestPermission", "", "context", "Landroid/content/Context;", "isNotGrantedArray", "Ljava/util/ArrayList;", "Ljp/co/sony/reonpocket/util/RequestBLEPermissions;", "Lkotlin/collections/ArrayList;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isAllRequestPermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            for (RequestBLEPermissions requestPermission : RequestBLEPermissions.values()) {
                if (!requestPermission.requestPermission(context)) {
                    return false;
                }
            }
            return true;
        }

        public final ArrayList<RequestBLEPermissions> isNotGrantedArray(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList<RequestBLEPermissions> arrayList = new ArrayList<>();
            for (RequestBLEPermissions requestBLEPermissions : RequestBLEPermissions.values()) {
                if (!requestBLEPermissions.requestPermission(context)) {
                    arrayList.add(requestBLEPermissions);
                }
            }
            return arrayList;
        }
    }

    public final void markPermissionRequested(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(this.getPreferenceCode, true).apply();
    }

    private final boolean isMarkPermissionRequested(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(this.getPreferenceCode, false);
    }

    public final boolean isPermissionDeniedForever(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Context context = activity;
        return !requestPermission(context) && isMarkPermissionRequested(context) && ActivityCompat.shouldShowRequestPermissionRationale(activity, this.Permission);
    }
}
