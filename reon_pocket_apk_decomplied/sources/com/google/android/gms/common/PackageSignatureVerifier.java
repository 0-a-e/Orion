package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class PackageSignatureVerifier {
    private static zzad zza;
    private volatile zzac zzb;

    private static zzad zza() {
        zzad zzad;
        synchronized (zzad.class) {
            if (zza == null) {
                zza = new zzad();
            }
            zzad = zza;
        }
        return zzad;
    }

    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        String str2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza();
        if (zzn.zzf()) {
            if (true != honorsDebugCertificates) {
                str2 = "-0";
            } else {
                str2 = "-1";
            }
            String concat = String.valueOf(str).concat(str2);
            if (this.zzb != null && this.zzb.zza.equals(concat)) {
                return this.zzb.zzb;
            }
            zza();
            zzx zzc = zzn.zzc(str, honorsDebugCertificates, false, false);
            if (zzc.zza) {
                this.zzb = new zzac(concat, PackageVerificationResult.zzd(str, zzc.zzd));
                return this.zzb.zzb;
            }
            Preconditions.checkNotNull(zzc.zzb);
            return PackageVerificationResult.zza(str, zzc.zzb, zzc.zzc);
        }
        throw new zzae();
    }

    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzb();
            return queryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (!queryPackageSignatureVerified2.zzc()) {
                return queryPackageSignatureVerified2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            return queryPackageSignatureVerified2;
        }
    }
}
