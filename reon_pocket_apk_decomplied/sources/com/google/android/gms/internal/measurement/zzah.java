package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzah implements zzap {
    private final Double zza;

    public zzah(Double d) {
        if (d == null) {
            this.zza = Double.valueOf(Double.NaN);
        } else {
            this.zza = d;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        return this.zza.equals(((zzah) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return zzc();
    }

    public final zzap zzbK(String str, zzg zzg, List<zzap> list) {
        if ("toString".equals(str)) {
            return new zzat(zzc());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{zzc(), str}));
    }

    public final String zzc() {
        int i;
        if (Double.isNaN(this.zza.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(this.zza.doubleValue())) {
            return this.zza.doubleValue() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? "Infinity" : "-Infinity";
        }
        BigDecimal m = zzah$$ExternalSyntheticBackportWithForwarding0.m(BigDecimal.valueOf(this.zza.doubleValue()));
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (m.scale() > 0) {
            i = m.precision();
        } else {
            i = m.scale();
        }
        decimalFormat.setMinimumFractionDigits(i - 1);
        String format = decimalFormat.format(m);
        int indexOf = format.indexOf("E");
        if (indexOf <= 0) {
            return format;
        }
        int parseInt = Integer.parseInt(format.substring(indexOf + 1));
        if ((parseInt >= 0 || parseInt <= -7) && (parseInt < 0 || parseInt >= 21)) {
            return format.replace("E-", "e-").replace("E", "e+");
        }
        return m.toPlainString();
    }

    public final Double zzd() {
        return this.zza;
    }

    public final Boolean zze() {
        boolean z = false;
        if (!Double.isNaN(this.zza.doubleValue()) && this.zza.doubleValue() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public final Iterator<zzap> zzf() {
        return null;
    }

    public final zzap zzt() {
        return new zzah(this.zza);
    }
}
