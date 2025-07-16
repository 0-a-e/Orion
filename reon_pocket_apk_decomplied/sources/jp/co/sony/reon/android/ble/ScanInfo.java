package jp.co.sony.reon.android.ble;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Ljp/co/sony/reon/android/ble/ScanInfo;", "", "handleFun", "", "nameIsNullDevices", "", "(Ljava/lang/String;Ljava/util/Set;)V", "getHandleFun", "()Ljava/lang/String;", "setHandleFun", "(Ljava/lang/String;)V", "getNameIsNullDevices", "()Ljava/util/Set;", "clear", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleManager.kt */
final class ScanInfo {
    private String handleFun;
    private final Set<String> nameIsNullDevices;

    public ScanInfo() {
        this((String) null, (Set) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ScanInfo copy$default(ScanInfo scanInfo, String str, Set<String> set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scanInfo.handleFun;
        }
        if ((i & 2) != 0) {
            set = scanInfo.nameIsNullDevices;
        }
        return scanInfo.copy(str, set);
    }

    public final String component1() {
        return this.handleFun;
    }

    public final Set<String> component2() {
        return this.nameIsNullDevices;
    }

    public final ScanInfo copy(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "nameIsNullDevices");
        return new ScanInfo(str, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScanInfo)) {
            return false;
        }
        ScanInfo scanInfo = (ScanInfo) obj;
        return Intrinsics.areEqual((Object) this.handleFun, (Object) scanInfo.handleFun) && Intrinsics.areEqual((Object) this.nameIsNullDevices, (Object) scanInfo.nameIsNullDevices);
    }

    public int hashCode() {
        String str = this.handleFun;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.nameIsNullDevices.hashCode();
    }

    public String toString() {
        String str = this.handleFun;
        Set<String> set = this.nameIsNullDevices;
        return "ScanInfo(handleFun=" + str + ", nameIsNullDevices=" + set + ")";
    }

    public ScanInfo(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "nameIsNullDevices");
        this.handleFun = str;
        this.nameIsNullDevices = set;
    }

    public final String getHandleFun() {
        return this.handleFun;
    }

    public final void setHandleFun(String str) {
        this.handleFun = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanInfo(String str, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new LinkedHashSet() : set);
    }

    public final Set<String> getNameIsNullDevices() {
        return this.nameIsNullDevices;
    }

    public final void clear() {
        this.handleFun = null;
        this.nameIsNullDevices.clear();
    }
}
