package com.google.android.gms.internal.measurement;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhp extends zzht<Double> {
    zzhp(zzhr zzhr, String str, Double d, boolean z) {
        super(zzhr, "measurement.test.double_flag", d, true, (zzhn) null);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzd = super.zzd();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 27 + str.length());
            sb.append("Invalid double value for ");
            sb.append(zzd);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
