package com.google.android.gms.internal.measurement;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public enum zzew implements zzkf {
    UNKNOWN_MATCH_TYPE(0),
    REGEXP(1),
    BEGINS_WITH(2),
    ENDS_WITH(3),
    PARTIAL(4),
    EXACT(5),
    IN_LIST(6);
    
    private static final zzkg<zzew> zzh = null;
    private final int zzi;

    static {
        zzh = new zzeu();
    }

    private zzew(int i) {
        this.zzi = i;
    }

    public static zzew zza(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_MATCH_TYPE;
            case 1:
                return REGEXP;
            case 2:
                return BEGINS_WITH;
            case 3:
                return ENDS_WITH;
            case 4:
                return PARTIAL;
            case 5:
                return EXACT;
            case 6:
                return IN_LIST;
            default:
                return null;
        }
    }

    public static zzkh zzb() {
        return zzev.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
    }
}
