package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.compress.utils.CharsetNames;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
public final class zzkl {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName(CharsetNames.ISO_8859_1);
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzjg zze;

    static {
        byte[] bArr = new byte[0];
        zzc = bArr;
        zzd = ByteBuffer.wrap(bArr);
        zzjf zzjf = new zzjf(bArr, 0, 0, false, (zzje) null);
        try {
            zzjf.zza(0);
            zze = zzjf;
        } catch (zzkn e) {
            throw new IllegalArgumentException(e);
        }
    }

    static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    static <T> T zzb(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzc(byte[] bArr) {
        return zzmw.zza(bArr);
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zze(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzf(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzg(byte[] bArr) {
        int length = bArr.length;
        int zzh = zzh(length, bArr, 0, length);
        if (zzh == 0) {
            return 1;
        }
        return zzh;
    }

    static int zzh(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zzi(Object obj, Object obj2) {
        return ((zzli) obj).zzbG().zzau((zzli) obj2).zzaD();
    }
}
