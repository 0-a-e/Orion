package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.compress.utils.CharsetNames;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
abstract class zzj extends zzy {
    private final int zza;

    protected zzj(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    protected static byte[] zze(String str) {
        try {
            return str.getBytes(CharsetNames.ISO_8859_1);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        IObjectWrapper zzd;
        if (obj != null && (obj instanceof zzz)) {
            try {
                zzz zzz = (zzz) obj;
                if (zzz.zzc() != this.zza || (zzd = zzz.zzd()) == null) {
                    return false;
                }
                return Arrays.equals(zzf(), (byte[]) ObjectWrapper.unwrap(zzd));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }

    public final int zzc() {
        return this.zza;
    }

    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(zzf());
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] zzf();
}
