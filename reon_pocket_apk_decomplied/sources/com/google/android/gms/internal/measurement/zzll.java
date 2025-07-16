package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzll<T> implements zzlt<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmr.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzli zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkw zzm;
    private final zzmh<?, ?> zzn;
    private final zzjq<?> zzo;
    private final zzln zzp;
    private final zzld zzq;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.measurement.zzli} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.google.android.gms.internal.measurement.zzln} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.measurement.zzld} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.measurement.zzjq<?>, com.google.android.gms.internal.measurement.zzjq] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v8, types: [int] */
    /* JADX WARNING: type inference failed for: r3v11, types: [com.google.android.gms.internal.measurement.zzkw] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.measurement.zzmh<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzll(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.measurement.zzli r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.measurement.zzln r17, com.google.android.gms.internal.measurement.zzkw r18, com.google.android.gms.internal.measurement.zzmh<?, ?> r19, com.google.android.gms.internal.measurement.zzjq<?> r20, com.google.android.gms.internal.measurement.zzld r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            r3 = r11
            r0.zzi = r3
            r3 = 0
            if (r2 == 0) goto L_0x0020
            boolean r4 = r2.zza(r10)
            if (r4 == 0) goto L_0x0020
            r3 = 1
        L_0x0020:
            r0.zzh = r3
            r3 = r13
            r0.zzj = r3
            r3 = r14
            r0.zzk = r3
            r3 = r15
            r0.zzl = r3
            r3 = r16
            r0.zzp = r3
            r3 = r17
            r0.zzm = r3
            r3 = r18
            r0.zzn = r3
            r0.zzo = r2
            r0.zzg = r1
            r1 = r20
            r0.zzq = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.measurement.zzli, boolean, boolean, int[], int, int, com.google.android.gms.internal.measurement.zzln, com.google.android.gms.internal.measurement.zzkw, com.google.android.gms.internal.measurement.zzmh, com.google.android.gms.internal.measurement.zzjq, com.google.android.gms.internal.measurement.zzld, byte[]):void");
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static int zzC(int i) {
        return (i >>> 20) & 255;
    }

    private static <T> double zzD(T t, long j) {
        return ((Double) zzmr.zzn(t, j)).doubleValue();
    }

    private static <T> float zzE(T t, long j) {
        return ((Float) zzmr.zzn(t, j)).floatValue();
    }

    private static <T> int zzF(T t, long j) {
        return ((Integer) zzmr.zzn(t, j)).intValue();
    }

    private static <T> long zzG(T t, long j) {
        return ((Long) zzmr.zzn(t, j)).longValue();
    }

    private static <T> boolean zzH(T t, long j) {
        return ((Boolean) zzmr.zzn(t, j)).booleanValue();
    }

    private final boolean zzI(T t, T t2, int i) {
        return zzK(t, i) == zzK(t2, i);
    }

    private final boolean zzJ(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzK(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzK(T t, int i) {
        int zzB = zzB(i);
        long j = (long) (zzB & 1048575);
        if (j != 1048575) {
            return (zzmr.zzd(t, j) & (1 << (zzB >>> 20))) != 0;
        }
        int zzA = zzA(i);
        long j2 = (long) (zzA & 1048575);
        switch (zzC(zzA)) {
            case 0:
                return zzmr.zzl(t, j2) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            case 1:
                return zzmr.zzj(t, j2) != 0.0f;
            case 2:
                return zzmr.zzf(t, j2) != 0;
            case 3:
                return zzmr.zzf(t, j2) != 0;
            case 4:
                return zzmr.zzd(t, j2) != 0;
            case 5:
                return zzmr.zzf(t, j2) != 0;
            case 6:
                return zzmr.zzd(t, j2) != 0;
            case 7:
                return zzmr.zzh(t, j2);
            case 8:
                Object zzn2 = zzmr.zzn(t, j2);
                if (zzn2 instanceof String) {
                    return !((String) zzn2).isEmpty();
                }
                if (zzn2 instanceof zzjd) {
                    return !zzjd.zzb.equals(zzn2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmr.zzn(t, j2) != null;
            case 10:
                return !zzjd.zzb.equals(zzmr.zzn(t, j2));
            case 11:
                return zzmr.zzd(t, j2) != 0;
            case 12:
                return zzmr.zzd(t, j2) != 0;
            case 13:
                return zzmr.zzd(t, j2) != 0;
            case 14:
                return zzmr.zzf(t, j2) != 0;
            case 15:
                return zzmr.zzd(t, j2) != 0;
            case 16:
                return zzmr.zzf(t, j2) != 0;
            case 17:
                return zzmr.zzn(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzL(T t, int i) {
        int zzB = zzB(i);
        long j = (long) (1048575 & zzB);
        if (j != 1048575) {
            zzmr.zze(t, j, (1 << (zzB >>> 20)) | zzmr.zzd(t, j));
        }
    }

    private final boolean zzM(T t, int i, int i2) {
        return zzmr.zzd(t, (long) (zzB(i2) & 1048575)) == i;
    }

    private final void zzN(T t, int i, int i2) {
        zzmr.zze(t, (long) (zzB(i2) & 1048575), i);
    }

    private final int zzO(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzQ(i, 0);
    }

    private final int zzP(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzQ(i, i2);
    }

    private final int zzQ(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044e, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029d, code lost:
        r12 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzR(T r17, com.google.android.gms.internal.measurement.zzjl r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x045f
            int[] r3 = r0.zzc
            int r3 = r3.length
            sun.misc.Unsafe r4 = zzb
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r5
            r7 = 0
            r8 = 0
        L_0x0015:
            if (r7 >= r3) goto L_0x0455
            int r10 = r0.zzA(r7)
            int[] r11 = r0.zzc
            r11 = r11[r7]
            int r12 = zzC(r10)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x003d
            int[] r13 = r0.zzc
            int r15 = r7 + 2
            r13 = r13[r15]
            r15 = r13 & r5
            if (r15 == r9) goto L_0x0038
            long r8 = (long) r15
            int r8 = r4.getInt(r1, r8)
            r9 = r15
        L_0x0038:
            int r13 = r13 >>> 20
            int r13 = r14 << r13
            goto L_0x003e
        L_0x003d:
            r13 = 0
        L_0x003e:
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r12) {
                case 0: goto L_0x0442;
                case 1: goto L_0x0435;
                case 2: goto L_0x0428;
                case 3: goto L_0x041b;
                case 4: goto L_0x040e;
                case 5: goto L_0x0401;
                case 6: goto L_0x03f4;
                case 7: goto L_0x03e7;
                case 8: goto L_0x03d9;
                case 9: goto L_0x03c7;
                case 10: goto L_0x03b7;
                case 11: goto L_0x03a9;
                case 12: goto L_0x039b;
                case 13: goto L_0x038d;
                case 14: goto L_0x037f;
                case 15: goto L_0x0371;
                case 16: goto L_0x0363;
                case 17: goto L_0x0351;
                case 18: goto L_0x0341;
                case 19: goto L_0x0331;
                case 20: goto L_0x0321;
                case 21: goto L_0x0311;
                case 22: goto L_0x0301;
                case 23: goto L_0x02f1;
                case 24: goto L_0x02e1;
                case 25: goto L_0x02d1;
                case 26: goto L_0x02c2;
                case 27: goto L_0x02af;
                case 28: goto L_0x02a0;
                case 29: goto L_0x028f;
                case 30: goto L_0x0280;
                case 31: goto L_0x0271;
                case 32: goto L_0x0262;
                case 33: goto L_0x0253;
                case 34: goto L_0x0244;
                case 35: goto L_0x0235;
                case 36: goto L_0x0226;
                case 37: goto L_0x0217;
                case 38: goto L_0x0208;
                case 39: goto L_0x01f9;
                case 40: goto L_0x01ea;
                case 41: goto L_0x01db;
                case 42: goto L_0x01cc;
                case 43: goto L_0x01bd;
                case 44: goto L_0x01ae;
                case 45: goto L_0x019f;
                case 46: goto L_0x0190;
                case 47: goto L_0x0181;
                case 48: goto L_0x0172;
                case 49: goto L_0x015f;
                case 50: goto L_0x0156;
                case 51: goto L_0x0147;
                case 52: goto L_0x0138;
                case 53: goto L_0x0129;
                case 54: goto L_0x011a;
                case 55: goto L_0x010b;
                case 56: goto L_0x00fc;
                case 57: goto L_0x00ed;
                case 58: goto L_0x00de;
                case 59: goto L_0x00cf;
                case 60: goto L_0x00bc;
                case 61: goto L_0x00ac;
                case 62: goto L_0x009e;
                case 63: goto L_0x0090;
                case 64: goto L_0x0082;
                case 65: goto L_0x0074;
                case 66: goto L_0x0066;
                case 67: goto L_0x0058;
                case 68: goto L_0x0046;
                default: goto L_0x0043;
            }
        L_0x0043:
            r12 = 0
            goto L_0x044e
        L_0x0046:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlt r6 = r0.zzv(r7)
            r2.zzs(r11, r5, r6)
            goto L_0x0043
        L_0x0058:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzG(r1, r5)
            r2.zzq(r11, r5)
            goto L_0x0043
        L_0x0066:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzF(r1, r5)
            r2.zzp(r11, r5)
            goto L_0x0043
        L_0x0074:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzG(r1, r5)
            r2.zzd(r11, r5)
            goto L_0x0043
        L_0x0082:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzF(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x0043
        L_0x0090:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzF(r1, r5)
            r2.zzg(r11, r5)
            goto L_0x0043
        L_0x009e:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzF(r1, r5)
            r2.zzo(r11, r5)
            goto L_0x0043
        L_0x00ac:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzjd r5 = (com.google.android.gms.internal.measurement.zzjd) r5
            r2.zzn(r11, r5)
            goto L_0x0043
        L_0x00bc:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlt r6 = r0.zzv(r7)
            r2.zzr(r11, r5, r6)
            goto L_0x0043
        L_0x00cf:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzT(r11, r5, r2)
            goto L_0x0043
        L_0x00de:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            boolean r5 = zzH(r1, r5)
            r2.zzl(r11, r5)
            goto L_0x0043
        L_0x00ed:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzF(r1, r5)
            r2.zzk(r11, r5)
            goto L_0x0043
        L_0x00fc:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzG(r1, r5)
            r2.zzj(r11, r5)
            goto L_0x0043
        L_0x010b:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzF(r1, r5)
            r2.zzi(r11, r5)
            goto L_0x0043
        L_0x011a:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzG(r1, r5)
            r2.zzh(r11, r5)
            goto L_0x0043
        L_0x0129:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzG(r1, r5)
            r2.zzc(r11, r5)
            goto L_0x0043
        L_0x0138:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            float r5 = zzE(r1, r5)
            r2.zze(r11, r5)
            goto L_0x0043
        L_0x0147:
            boolean r10 = r0.zzM(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            double r5 = zzD(r1, r5)
            r2.zzf(r11, r5)
            goto L_0x0043
        L_0x0156:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.zzS(r2, r11, r5, r7)
            goto L_0x0043
        L_0x015f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlt r6 = r0.zzv(r7)
            com.google.android.gms.internal.measurement.zzlv.zzaa(r10, r5, r2, r6)
            goto L_0x0043
        L_0x0172:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzN(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0181:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzS(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0190:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzP(r10, r5, r2, r14)
            goto L_0x0043
        L_0x019f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzU(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ae:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzV(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01bd:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzR(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01cc:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzW(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01db:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzT(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ea:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzO(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01f9:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzQ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0208:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzM(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0217:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzL(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0226:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzK(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0235:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzJ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0244:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.gms.internal.measurement.zzlv.zzN(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0253:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzS(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0262:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzP(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0271:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzU(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0280:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzV(r10, r5, r2, r11)
            goto L_0x029d
        L_0x028f:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzR(r10, r5, r2, r11)
        L_0x029d:
            r12 = r11
            goto L_0x044e
        L_0x02a0:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzY(r10, r5, r2)
            goto L_0x0043
        L_0x02af:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlt r6 = r0.zzv(r7)
            com.google.android.gms.internal.measurement.zzlv.zzZ(r10, r5, r2, r6)
            goto L_0x0043
        L_0x02c2:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzX(r10, r5, r2)
            goto L_0x0043
        L_0x02d1:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.android.gms.internal.measurement.zzlv.zzW(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02e1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzT(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02f1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzO(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0301:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzQ(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0311:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzM(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0321:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzL(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0331:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzK(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0341:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlv.zzJ(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0351:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlt r6 = r0.zzv(r7)
            r2.zzs(r11, r5, r6)
            goto L_0x044e
        L_0x0363:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzq(r11, r5)
            goto L_0x044e
        L_0x0371:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzp(r11, r5)
            goto L_0x044e
        L_0x037f:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzd(r11, r5)
            goto L_0x044e
        L_0x038d:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x044e
        L_0x039b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzg(r11, r5)
            goto L_0x044e
        L_0x03a9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzo(r11, r5)
            goto L_0x044e
        L_0x03b7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzjd r5 = (com.google.android.gms.internal.measurement.zzjd) r5
            r2.zzn(r11, r5)
            goto L_0x044e
        L_0x03c7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlt r6 = r0.zzv(r7)
            r2.zzr(r11, r5, r6)
            goto L_0x044e
        L_0x03d9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzT(r11, r5, r2)
            goto L_0x044e
        L_0x03e7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            boolean r5 = com.google.android.gms.internal.measurement.zzmr.zzh(r1, r5)
            r2.zzl(r11, r5)
            goto L_0x044e
        L_0x03f4:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzk(r11, r5)
            goto L_0x044e
        L_0x0401:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzj(r11, r5)
            goto L_0x044e
        L_0x040e:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzi(r11, r5)
            goto L_0x044e
        L_0x041b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzh(r11, r5)
            goto L_0x044e
        L_0x0428:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzc(r11, r5)
            goto L_0x044e
        L_0x0435:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            float r5 = com.google.android.gms.internal.measurement.zzmr.zzj(r1, r5)
            r2.zze(r11, r5)
            goto L_0x044e
        L_0x0442:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            double r5 = com.google.android.gms.internal.measurement.zzmr.zzl(r1, r5)
            r2.zzf(r11, r5)
        L_0x044e:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0455:
            com.google.android.gms.internal.measurement.zzmh<?, ?> r3 = r0.zzn
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzi(r1, r2)
            return
        L_0x045f:
            com.google.android.gms.internal.measurement.zzjq<?> r2 = r0.zzo
            r2.zzb(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.zzR(java.lang.Object, com.google.android.gms.internal.measurement.zzjl):void");
    }

    private final <K, V> void zzS(zzjl zzjl, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlb zzlb = (zzlb) zzw(i2);
            throw null;
        }
    }

    private static final void zzT(int i, Object obj, zzjl zzjl) throws IOException {
        if (obj instanceof String) {
            zzjl.zzm(i, (String) obj);
        } else {
            zzjl.zzn(i, (zzjd) obj);
        }
    }

    static zzmi zzf(Object obj) {
        zzkd zzkd = (zzkd) obj;
        zzmi zzmi = zzkd.zzc;
        if (zzmi != zzmi.zza()) {
            return zzmi;
        }
        zzmi zzb2 = zzmi.zzb();
        zzkd.zzc = zzb2;
        return zzb2;
    }

    static <T> zzll<T> zzk(Class<T> cls, zzlf zzlf, zzln zzln, zzkw zzkw, zzmh<?, ?> zzmh, zzjq<?> zzjq, zzld zzld) {
        if (zzlf instanceof zzls) {
            return zzl((zzls) zzlf, zzln, zzkw, zzmh, zzjq, zzld);
        }
        zzme zzme = (zzme) zzlf;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x037f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzll<T> zzl(com.google.android.gms.internal.measurement.zzls r34, com.google.android.gms.internal.measurement.zzln r35, com.google.android.gms.internal.measurement.zzkw r36, com.google.android.gms.internal.measurement.zzmh<?, ?> r37, com.google.android.gms.internal.measurement.zzjq<?> r38, com.google.android.gms.internal.measurement.zzld r39) {
        /*
            int r0 = r34.zzc()
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r2
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = zza
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.measurement.zzli r18 = r34.zzb()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r1) goto L_0x03ce
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0194:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a6
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0194
        L_0x01a6:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ae
        L_0x01ac:
            r3 = r24
        L_0x01ae:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01db
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d5
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01bc
        L_0x01d5:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r1
            r1 = r24
        L_0x01df:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x029a
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r14) goto L_0x0223
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r1 = r1 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r1 = r1 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0248
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x0248
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0257
            if (r10 != 0) goto L_0x0257
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0255
        L_0x0248:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0255:
            r16 = r14
        L_0x0257:
            int r1 = r1 + r1
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0261
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0269
        L_0x0261:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzn(r2, r12)
            r17[r1] = r12
        L_0x0269:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r1 = r1 + 1
            r8 = r17[r1]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027c
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0284
        L_0x027c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzn(r2, r8)
            r17[r1] = r8
        L_0x0284:
            r1 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r29 = r11
            r0 = r16
            r26 = r27
            r25 = 1
            r16 = r7
            r7 = r1
            r1 = 0
            goto L_0x0393
        L_0x029a:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzn(r2, r8)
            r12 = 9
            if (r5 == r12) goto L_0x0312
            r12 = 17
            if (r5 != r12) goto L_0x02b2
            goto L_0x0312
        L_0x02b2:
            r12 = 27
            if (r5 == r12) goto L_0x0302
            r12 = 49
            if (r5 != r12) goto L_0x02bb
            goto L_0x0302
        L_0x02bb:
            r12 = 12
            if (r5 == r12) goto L_0x02f2
            r12 = 30
            if (r5 == r12) goto L_0x02f2
            r12 = 44
            if (r5 != r12) goto L_0x02c8
            goto L_0x02f2
        L_0x02c8:
            r12 = 50
            if (r5 != r12) goto L_0x02e8
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r29 = r16 + 2
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02eb
            int r7 = r16 + 3
            int r22 = r22 + 1
            r16 = r17[r29]
            r11[r22] = r16
            r22 = r12
        L_0x02e8:
            r25 = 1
            goto L_0x031f
        L_0x02eb:
            r22 = r12
            r12 = r29
            r25 = 1
            goto L_0x0320
        L_0x02f2:
            if (r10 != 0) goto L_0x02e8
            int r12 = r9 / 3
            int r16 = r16 + 2
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030f
        L_0x0302:
            r25 = 1
            int r12 = r9 / 3
            int r16 = r16 + 2
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030f:
            r12 = r16
            goto L_0x0320
        L_0x0312:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r16 = r8.getType()
            r11[r12] = r16
        L_0x031f:
            r12 = r7
        L_0x0320:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r3 & 4096(0x1000, float:5.74E-42)
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x037f
            r8 = 17
            if (r5 > r8) goto L_0x037f
            int r8 = r1 + 1
            char r1 = r0.charAt(r1)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r11) goto L_0x0359
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0343:
            int r26 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0355
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r16
            r1 = r1 | r8
            int r16 = r16 + 13
            r8 = r26
            goto L_0x0343
        L_0x0355:
            int r8 = r8 << r16
            r1 = r1 | r8
            goto L_0x035b
        L_0x0359:
            r26 = r8
        L_0x035b:
            int r8 = r6 + r6
            int r16 = r1 / 32
            int r8 = r8 + r16
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x036c
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x0374
        L_0x036c:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzn(r2, r11)
            r17[r8] = r11
        L_0x0374:
            r0 = r12
            long r11 = r15.objectFieldOffset(r11)
            int r8 = (int) r11
            int r1 = r1 % 32
            r16 = r8
            goto L_0x0385
        L_0x037f:
            r30 = r0
            r0 = r12
            r26 = r1
            r1 = 0
        L_0x0385:
            r8 = 18
            if (r5 < r8) goto L_0x0393
            r8 = 49
            if (r5 > r8) goto L_0x0393
            int r8 = r23 + 1
            r13[r23] = r7
            r23 = r8
        L_0x0393:
            int r8 = r9 + 1
            r31[r9] = r4
            int r4 = r9 + 2
            r11 = r3 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x03a0
            r11 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a1
        L_0x03a0:
            r11 = 0
        L_0x03a1:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03a8
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a9
        L_0x03a8:
            r3 = 0
        L_0x03a9:
            r3 = r3 | r11
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r7
            r31[r8] = r3
            int r9 = r9 + 3
            int r1 = r1 << 20
            r1 = r1 | r16
            r31[r4] = r1
            r16 = r0
            r8 = r14
            r14 = r24
            r4 = r26
            r1 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03ce:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.measurement.zzll r0 = new com.google.android.gms.internal.measurement.zzll
            r4 = r0
            com.google.android.gms.internal.measurement.zzli r9 = r34.zzb()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.zzl(com.google.android.gms.internal.measurement.zzls, com.google.android.gms.internal.measurement.zzln, com.google.android.gms.internal.measurement.zzkw, com.google.android.gms.internal.measurement.zzmh, com.google.android.gms.internal.measurement.zzjq, com.google.android.gms.internal.measurement.zzld):com.google.android.gms.internal.measurement.zzll");
    }

    private static Field zzn(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzo(T t, T t2, int i) {
        long zzA = (long) (zzA(i) & 1048575);
        if (zzK(t2, i)) {
            Object zzn2 = zzmr.zzn(t, zzA);
            Object zzn3 = zzmr.zzn(t2, zzA);
            if (zzn2 != null && zzn3 != null) {
                zzmr.zzo(t, zzA, zzkl.zzi(zzn2, zzn3));
                zzL(t, i);
            } else if (zzn3 != null) {
                zzmr.zzo(t, zzA, zzn3);
                zzL(t, i);
            }
        }
    }

    private final void zzp(T t, T t2, int i) {
        int zzA = zzA(i);
        int i2 = this.zzc[i];
        long j = (long) (zzA & 1048575);
        if (zzM(t2, i2, i)) {
            Object zzn2 = zzM(t, i2, i) ? zzmr.zzn(t, j) : null;
            Object zzn3 = zzmr.zzn(t2, j);
            if (zzn2 != null && zzn3 != null) {
                zzmr.zzo(t, j, zzkl.zzi(zzn2, zzn3));
                zzN(t, i2, i);
            } else if (zzn3 != null) {
                zzmr.zzo(t, j, zzn3);
                zzN(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0302, code lost:
        r8 = r8 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0469, code lost:
        r8 = r8 + (r9 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04b3, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04de, code lost:
        r8 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04df, code lost:
        r4 = r4 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0506, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0513, code lost:
        r7 = r7 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0521, code lost:
        r7 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0525, code lost:
        r3 = r3 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r2
        L_0x000a:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x0529
            int r7 = r14.zzA(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzC(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0035
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r2
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0036
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0036
        L_0x0035:
            r10 = r1
        L_0x0036:
            r7 = r7 & r2
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0517;
                case 1: goto L_0x0509;
                case 2: goto L_0x04f4;
                case 3: goto L_0x04e1;
                case 4: goto L_0x04cc;
                case 5: goto L_0x04c1;
                case 6: goto L_0x04b6;
                case 7: goto L_0x04a9;
                case 8: goto L_0x047f;
                case 9: goto L_0x046d;
                case 10: goto L_0x0451;
                case 11: goto L_0x043d;
                case 12: goto L_0x0429;
                case 13: goto L_0x041d;
                case 14: goto L_0x0411;
                case 15: goto L_0x03f8;
                case 16: goto L_0x03e0;
                case 17: goto L_0x03cd;
                case 18: goto L_0x03c0;
                case 19: goto L_0x03b5;
                case 20: goto L_0x03aa;
                case 21: goto L_0x039f;
                case 22: goto L_0x0394;
                case 23: goto L_0x0389;
                case 24: goto L_0x037e;
                case 25: goto L_0x0373;
                case 26: goto L_0x0368;
                case 27: goto L_0x0359;
                case 28: goto L_0x034d;
                case 29: goto L_0x0341;
                case 30: goto L_0x0335;
                case 31: goto L_0x0329;
                case 32: goto L_0x031d;
                case 33: goto L_0x0311;
                case 34: goto L_0x0305;
                case 35: goto L_0x02ee;
                case 36: goto L_0x02d9;
                case 37: goto L_0x02c4;
                case 38: goto L_0x02af;
                case 39: goto L_0x029a;
                case 40: goto L_0x0285;
                case 41: goto L_0x026f;
                case 42: goto L_0x0259;
                case 43: goto L_0x0243;
                case 44: goto L_0x022d;
                case 45: goto L_0x0217;
                case 46: goto L_0x0201;
                case 47: goto L_0x01eb;
                case 48: goto L_0x01d5;
                case 49: goto L_0x01c5;
                case 50: goto L_0x01b8;
                case 51: goto L_0x01aa;
                case 52: goto L_0x019c;
                case 53: goto L_0x0186;
                case 54: goto L_0x0170;
                case 55: goto L_0x015a;
                case 56: goto L_0x014c;
                case 57: goto L_0x013e;
                case 58: goto L_0x0130;
                case 59: goto L_0x0102;
                case 60: goto L_0x00ee;
                case 61: goto L_0x00d2;
                case 62: goto L_0x00bc;
                case 63: goto L_0x00a6;
                case 64: goto L_0x0098;
                case 65: goto L_0x008a;
                case 66: goto L_0x006f;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0525
        L_0x003f:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzli r7 = (com.google.android.gms.internal.measurement.zzli) r7
            com.google.android.gms.internal.measurement.zzlt r9 = r14.zzv(r3)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzE(r8, r7, r9)
            goto L_0x03ca
        L_0x0055:
            boolean r9 = r14.zzM(r15, r8, r3)
            if (r9 == 0) goto L_0x0525
            long r9 = zzG(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzx(r9)
            goto L_0x04de
        L_0x006f:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzF(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x04de
        L_0x008a:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0521
        L_0x0098:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0513
        L_0x00a6:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzF(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzv(r7)
            goto L_0x04de
        L_0x00bc:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzF(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x04de
        L_0x00d2:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzjd r7 = (com.google.android.gms.internal.measurement.zzjd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0469
        L_0x00ee:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzlt r9 = r14.zzv(r3)
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzw(r8, r7, r9)
            goto L_0x03ca
        L_0x0102:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r9 == 0) goto L_0x0122
            com.google.android.gms.internal.measurement.zzjd r7 = (com.google.android.gms.internal.measurement.zzjd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0469
        L_0x0122:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzy(r7)
            goto L_0x04de
        L_0x0130:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x04b3
        L_0x013e:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0513
        L_0x014c:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0521
        L_0x015a:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzF(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzv(r7)
            goto L_0x04de
        L_0x0170:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzG(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzx(r9)
            goto L_0x0506
        L_0x0186:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzG(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzx(r9)
            goto L_0x0506
        L_0x019c:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0513
        L_0x01aa:
            boolean r7 = r14.zzM(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0521
        L_0x01b8:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzw(r3)
            com.google.android.gms.internal.measurement.zzld.zza(r8, r7, r9)
            goto L_0x0525
        L_0x01c5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzlt r9 = r14.zzv(r3)
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzz(r8, r7, r9)
            goto L_0x03ca
        L_0x01d5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzf(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x01eb:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzn(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x0201:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzr(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x0217:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzp(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x022d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzh(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x0243:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzl(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x0259:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzt(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x026f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzp(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x0285:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzr(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x029a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzj(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x02af:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzd(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x02c4:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzb(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x02d9:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzp(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0302
        L_0x02ee:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzr(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzu(r8)
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
        L_0x0302:
            int r8 = r8 + r9
            goto L_0x04de
        L_0x0305:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzg(r8, r7, r1)
            goto L_0x03ca
        L_0x0311:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzo(r8, r7, r1)
            goto L_0x03ca
        L_0x031d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzs(r8, r7, r1)
            goto L_0x03ca
        L_0x0329:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzq(r8, r7, r1)
            goto L_0x03ca
        L_0x0335:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzi(r8, r7, r1)
            goto L_0x03ca
        L_0x0341:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzm(r8, r7, r1)
            goto L_0x03ca
        L_0x034d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzy(r8, r7)
            goto L_0x03ca
        L_0x0359:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzlt r9 = r14.zzv(r3)
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzx(r8, r7, r9)
            goto L_0x03ca
        L_0x0368:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzv(r8, r7)
            goto L_0x03ca
        L_0x0373:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzu(r8, r7, r1)
            goto L_0x03ca
        L_0x037e:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzq(r8, r7, r1)
            goto L_0x03ca
        L_0x0389:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzs(r8, r7, r1)
            goto L_0x03ca
        L_0x0394:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzk(r8, r7, r1)
            goto L_0x03ca
        L_0x039f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zze(r8, r7, r1)
            goto L_0x03ca
        L_0x03aa:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzc(r8, r7, r1)
            goto L_0x03ca
        L_0x03b5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzq(r8, r7, r1)
            goto L_0x03ca
        L_0x03c0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzs(r8, r7, r1)
        L_0x03ca:
            int r4 = r4 + r7
            goto L_0x0525
        L_0x03cd:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzli r7 = (com.google.android.gms.internal.measurement.zzli) r7
            com.google.android.gms.internal.measurement.zzlt r9 = r14.zzv(r3)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzE(r8, r7, r9)
            goto L_0x03ca
        L_0x03e0:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzx(r9)
            goto L_0x04de
        L_0x03f8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x04de
        L_0x0411:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0521
        L_0x041d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0513
        L_0x0429:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzv(r7)
            goto L_0x04de
        L_0x043d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x04de
        L_0x0451:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzjd r7 = (com.google.android.gms.internal.measurement.zzjd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
        L_0x0469:
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x04df
        L_0x046d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.measurement.zzlt r9 = r14.zzv(r3)
            int r7 = com.google.android.gms.internal.measurement.zzlv.zzw(r8, r7, r9)
            goto L_0x03ca
        L_0x047f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r9 == 0) goto L_0x049c
            com.google.android.gms.internal.measurement.zzjd r7 = (com.google.android.gms.internal.measurement.zzjd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0469
        L_0x049c:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzy(r7)
            goto L_0x04de
        L_0x04a9:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
        L_0x04b3:
            int r7 = r7 + r11
            goto L_0x03ca
        L_0x04b6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0513
        L_0x04c1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            goto L_0x0521
        L_0x04cc:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzw(r8)
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzv(r7)
        L_0x04de:
            int r8 = r8 + r7
        L_0x04df:
            int r4 = r4 + r8
            goto L_0x0525
        L_0x04e1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzx(r9)
            goto L_0x0506
        L_0x04f4:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
            int r8 = com.google.android.gms.internal.measurement.zzjk.zzx(r9)
        L_0x0506:
            int r7 = r7 + r8
            goto L_0x03ca
        L_0x0509:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
        L_0x0513:
            int r7 = r7 + 4
            goto L_0x03ca
        L_0x0517:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.measurement.zzjk.zzw(r7)
        L_0x0521:
            int r7 = r7 + 8
            goto L_0x03ca
        L_0x0525:
            int r3 = r3 + 3
            goto L_0x000a
        L_0x0529:
            com.google.android.gms.internal.measurement.zzmh<?, ?> r0 = r14.zzn
            java.lang.Object r1 = r0.zzd(r15)
            int r0 = r0.zzh(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzh
            if (r0 != 0) goto L_0x0539
            return r4
        L_0x0539:
            com.google.android.gms.internal.measurement.zzjq<?> r0 = r14.zzo
            r0.zzb(r15)
            r15 = 0
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.zzq(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzr(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzA(r2)
            int r5 = zzC(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.measurement.zzjv r4 = com.google.android.gms.internal.measurement.zzjv.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.measurement.zzjv r4 = com.google.android.gms.internal.measurement.zzjv.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            com.google.android.gms.internal.measurement.zzli r4 = (com.google.android.gms.internal.measurement.zzli) r4
            com.google.android.gms.internal.measurement.zzlt r5 = r11.zzv(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzE(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzM(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzG(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzx(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzF(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzF(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzF(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            com.google.android.gms.internal.measurement.zzjd r4 = (com.google.android.gms.internal.measurement.zzjd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            com.google.android.gms.internal.measurement.zzlt r5 = r11.zzv(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzw(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.measurement.zzjd r4 = (com.google.android.gms.internal.measurement.zzjd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzF(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzG(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzx(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzG(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzx(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzM(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.lang.Object r5 = r11.zzw(r2)
            com.google.android.gms.internal.measurement.zzld.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlt r5 = r11.zzv(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzz(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzf(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzp(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzh(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzp(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzj(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzd(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzp(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzu(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzg(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzo(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzi(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzy(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlt r5 = r11.zzv(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzx(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzv(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzu(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zze(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzc(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzs(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            com.google.android.gms.internal.measurement.zzli r4 = (com.google.android.gms.internal.measurement.zzli) r4
            com.google.android.gms.internal.measurement.zzlt r5 = r11.zzv(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzE(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzK(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.measurement.zzmr.zzf(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzx(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmr.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmr.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmr.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            com.google.android.gms.internal.measurement.zzjd r4 = (com.google.android.gms.internal.measurement.zzjd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            com.google.android.gms.internal.measurement.zzlt r5 = r11.zzv(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlv.zzw(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzjd r4 = (com.google.android.gms.internal.measurement.zzjd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmr.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjk.zzw(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmr.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzx(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmr.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjk.zzw(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzx(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzK(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjk.zzw(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.measurement.zzmh<?, ?> r0 = r11.zzn
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zzh(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.zzr(java.lang.Object):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0450 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzs(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzir r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzkk r12 = (com.google.android.gms.internal.measurement.zzkk) r12
            boolean r13 = r12.zza()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.measurement.zzkk r12 = r12.zze(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.measurement.zzlt r1 = r15.zzv(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzis.zzj(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.measurement.zzkx r12 = (com.google.android.gms.internal.measurement.zzkx) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzjg.zzc(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkx r12 = (com.google.android.gms.internal.measurement.zzkx) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzjg.zzc(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzjg.zzc(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.measurement.zzke r12 = (com.google.android.gms.internal.measurement.zzke) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjg.zzb(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzke r12 = (com.google.android.gms.internal.measurement.zzke) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjg.zzb(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjg.zzb(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.measurement.zzis.zzl(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzis.zzk(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.measurement.zzkd r1 = (com.google.android.gms.internal.measurement.zzkd) r1
            com.google.android.gms.internal.measurement.zzmi r3 = r1.zzc
            com.google.android.gms.internal.measurement.zzmi r4 = com.google.android.gms.internal.measurement.zzmi.zza()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.measurement.zzkh r4 = r15.zzx(r8)
            com.google.android.gms.internal.measurement.zzmh<?, ?> r5 = r0.zzn
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzlv.zzG(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.measurement.zzmi r3 = (com.google.android.gms.internal.measurement.zzmi) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.measurement.zzjd r4 = com.google.android.gms.internal.measurement.zzjd.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.measurement.zzjd r6 = com.google.android.gms.internal.measurement.zzjd.zzj(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.measurement.zzjd r4 = com.google.android.gms.internal.measurement.zzjd.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.measurement.zzjd r6 = com.google.android.gms.internal.measurement.zzjd.zzj(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zzb()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zzb()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.measurement.zzlt r1 = r15.zzv(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.measurement.zzis.zzm(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fa
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f5
            if (r4 != 0) goto L_0x01c2
            r12.add(r6)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkl.zza
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01cc:
            int r1 = r1 + r4
        L_0x01cd:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f0
            if (r4 != 0) goto L_0x01e5
            r12.add(r6)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkl.zza
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zzb()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zzb()
            throw r1
        L_0x01fa:
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0255
            if (r4 != 0) goto L_0x0208
            r12.add(r6)
            goto L_0x021b
        L_0x0208:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzmw.zzb(r3, r1, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkl.zza
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x021a:
            r1 = r8
        L_0x021b:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024b
            if (r4 != 0) goto L_0x0233
            r12.add(r6)
            goto L_0x021b
        L_0x0233:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzmw.zzb(r3, r1, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkl.zza
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zzf()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zzb()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zzf()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zzb()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.measurement.zzit r12 = (com.google.android.gms.internal.measurement.zzit) r12
            int r2 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0274
            r5 = r13
            goto L_0x0275
        L_0x0274:
            r5 = r1
        L_0x0275:
            r12.zzd(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzit r12 = (com.google.android.gms.internal.measurement.zzit) r12
            int r4 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = r13
            goto L_0x0294
        L_0x0293:
            r6 = r1
        L_0x0294:
            r12.zzd(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r12.zzd(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.measurement.zzke r12 = (com.google.android.gms.internal.measurement.zzke) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.measurement.zzis.zzd(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzke r12 = (com.google.android.gms.internal.measurement.zzke) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zzd(r17, r18)
            r12.zzh(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.measurement.zzis.zzd(r3, r4)
            r12.zzh(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.measurement.zzkx r12 = (com.google.android.gms.internal.measurement.zzkx) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.measurement.zzis.zze(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkx r12 = (com.google.android.gms.internal.measurement.zzkx) r12
            long r8 = com.google.android.gms.internal.measurement.zzis.zze(r17, r18)
            r12.zzg(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.measurement.zzis.zze(r3, r4)
            r12.zzg(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.measurement.zzis.zzl(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.measurement.zzis.zzk(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.measurement.zzkx r12 = (com.google.android.gms.internal.measurement.zzkx) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkx r12 = (com.google.android.gms.internal.measurement.zzkx) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.measurement.zzis.zzc(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.measurement.zzjw r12 = (com.google.android.gms.internal.measurement.zzjw) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.measurement.zzis.zzd(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zzd(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjw r12 = (com.google.android.gms.internal.measurement.zzjw) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zzd(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zzd(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.measurement.zzis.zzd(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zzd(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.measurement.zzjm r12 = (com.google.android.gms.internal.measurement.zzjm) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.measurement.zzis.zze(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zzd(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjm r12 = (com.google.android.gms.internal.measurement.zzjm) r12
            long r8 = com.google.android.gms.internal.measurement.zzis.zze(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zzd(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.measurement.zzis.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.measurement.zzis.zze(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zzd(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.measurement.zzis.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzis.zzj(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.zzs(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzir):int");
    }

    private final <K, V> int zzt(T t, byte[] bArr, int i, int i2, int i3, long j, zzir zzir) throws IOException {
        Unsafe unsafe = zzb;
        Object zzw = zzw(i3);
        Object object = unsafe.getObject(t, j);
        if (!((zzlc) object).zze()) {
            zzlc zzc2 = zzlc.zza().zzc();
            zzld.zzb(zzc2, object);
            unsafe.putObject(t, j, zzc2);
        }
        zzlb zzlb = (zzlb) zzw;
        throw null;
    }

    private final int zzu(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzir zzir) throws IOException {
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzir zzir2 = zzir;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case ModuleDescriptor.MODULE_VERSION:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(Double.longBitsToDouble(zzis.zze(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(Float.intBitsToFloat(zzis.zzd(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzc2 = zzis.zzc(bArr2, i9, zzir2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzir2.zzb));
                    unsafe.putInt(t2, j3, i11);
                    return zzc2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zza2 = zzis.zza(bArr2, i9, zzir2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzir2.zza));
                    unsafe.putInt(t2, j3, i11);
                    return zza2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzis.zze(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzis.zzd(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzc3 = zzis.zzc(bArr2, i9, zzir2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzir2.zzb != 0));
                    unsafe.putInt(t2, j3, i11);
                    return zzc3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zza3 = zzis.zza(bArr2, i9, zzir2);
                    int i14 = zzir2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzmw.zzb(bArr2, zza3, zza3 + i14)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zza3, i14, zzkl.zza));
                        zza3 += i14;
                    } else {
                        throw zzkn.zzf();
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zza3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzi2 = zzis.zzi(zzv(i13), bArr2, i9, i2, zzir2);
                    Object object = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzir2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzkl.zzi(object, zzir2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzi2;
                }
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                if (i12 == 2) {
                    int zzh2 = zzis.zzh(bArr2, i9, zzir2);
                    unsafe.putObject(t2, j2, zzir2.zzc);
                    unsafe.putInt(t2, j3, i11);
                    return zzh2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zza4 = zzis.zza(bArr2, i9, zzir2);
                    int i15 = zzir2.zza;
                    zzkh zzx = zzx(i13);
                    if (zzx == null || zzx.zza(i15)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i15));
                        unsafe.putInt(t2, j3, i11);
                    } else {
                        zzf(t).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zza4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zza5 = zzis.zza(bArr2, i9, zzir2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzjg.zzb(zzir2.zza)));
                    unsafe.putInt(t2, j3, i11);
                    return zza5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzc4 = zzis.zzc(bArr2, i9, zzir2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzjg.zzc(zzir2.zzb)));
                    unsafe.putInt(t2, j3, i11);
                    return zzc4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzj2 = zzis.zzj(zzv(i13), bArr, i, i2, (i10 & -8) | 4, zzir);
                    Object object2 = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, zzir2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzkl.zzi(object2, zzir2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzj2;
                }
                break;
        }
        return i9;
    }

    private final zzlt zzv(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzlt zzlt = (zzlt) this.zzd[i3];
        if (zzlt != null) {
            return zzlt;
        }
        zzlt zzb2 = zzlq.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzkh zzx(int i) {
        int i2 = i / 3;
        return (zzkh) this.zzd[i2 + i2 + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02e8, code lost:
        if (r0 != r15) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x030b, code lost:
        if (r0 != r15) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        r19 = r32;
        r11 = r34;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        r32 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f2, code lost:
        r6 = r6 | r20;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c9, code lost:
        r2 = r8;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e4, code lost:
        r0 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0200, code lost:
        r6 = r32 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0202, code lost:
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0203, code lost:
        r1 = r19;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0208, code lost:
        r6 = r32;
        r2 = r4;
        r18 = r8;
        r28 = r9;
        r27 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02a1, code lost:
        if (r0 != r15) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02b7, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzy(T r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.measurement.zzir r34) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            sun.misc.Unsafe r9 = zzb
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = r8
            r7 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x0335
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003b
            int r2 = r2 / 3
            int r0 = r15.zzP(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzO(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r8) goto L_0x004d
            r2 = r4
            r19 = r5
            r27 = r8
            r28 = r9
            r18 = r16
            goto L_0x030e
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzC(r1)
            r8 = r1 & r10
            long r10 = (long) r8
            r8 = 17
            r32 = r5
            if (r0 > r8) goto L_0x0213
            int[] r8 = r15.zzc
            int r20 = r2 + 2
            r8 = r8[r20]
            int r20 = r8 >>> 20
            r5 = 1
            int r20 = r5 << r20
            r22 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r10
            if (r8 == r7) goto L_0x0084
            if (r7 == r10) goto L_0x007c
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
            r10 = 1048575(0xfffff, float:1.469367E-39)
        L_0x007c:
            if (r8 == r10) goto L_0x0083
            long r6 = (long) r8
            int r6 = r9.getInt(r14, r6)
        L_0x0083:
            r7 = r8
        L_0x0084:
            r8 = 5
            switch(r0) {
                case 0: goto L_0x01e7;
                case 1: goto L_0x01cd;
                case 2: goto L_0x01ab;
                case 3: goto L_0x01ab;
                case 4: goto L_0x0196;
                case 5: goto L_0x0178;
                case 6: goto L_0x0163;
                case 7: goto L_0x0140;
                case 8: goto L_0x011f;
                case 9: goto L_0x00f7;
                case 10: goto L_0x00df;
                case 11: goto L_0x0196;
                case 12: goto L_0x00cc;
                case 13: goto L_0x0163;
                case 14: goto L_0x0178;
                case 15: goto L_0x00b2;
                case 16: goto L_0x0091;
                default: goto L_0x0088;
            }
        L_0x0088:
            r19 = r32
            r11 = r34
            r8 = r2
        L_0x008d:
            r32 = r6
            goto L_0x0208
        L_0x0091:
            if (r3 != 0) goto L_0x0088
            r11 = r34
            r0 = r22
            int r8 = com.google.android.gms.internal.measurement.zzis.zzc(r12, r4, r11)
            long r3 = r11.zzb
            long r4 = com.google.android.gms.internal.measurement.zzjg.zzc(r3)
            r0 = r9
            r1 = r30
            r17 = r8
            r8 = r2
            r2 = r22
            r19 = r32
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            goto L_0x01c9
        L_0x00b2:
            r19 = r32
            r11 = r34
            r8 = r2
            if (r3 != 0) goto L_0x008d
            int r0 = com.google.android.gms.internal.measurement.zzis.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzjg.zzb(r1)
            r2 = r22
            r9.putInt(r14, r2, r1)
            r6 = r6 | r20
            goto L_0x0202
        L_0x00cc:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            if (r3 != 0) goto L_0x008d
            int r2 = com.google.android.gms.internal.measurement.zzis.zza(r12, r4, r11)
            int r3 = r11.zza
            r9.putInt(r14, r0, r3)
            goto L_0x00f2
        L_0x00df:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            r2 = 2
            if (r3 != r2) goto L_0x008d
            int r2 = com.google.android.gms.internal.measurement.zzis.zzh(r12, r4, r11)
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
        L_0x00f2:
            r6 = r6 | r20
            r0 = r2
            goto L_0x0202
        L_0x00f7:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            r2 = 2
            if (r3 != r2) goto L_0x008d
            com.google.android.gms.internal.measurement.zzlt r2 = r15.zzv(r8)
            int r2 = com.google.android.gms.internal.measurement.zzis.zzi(r2, r12, r4, r13, r11)
            java.lang.Object r3 = r9.getObject(r14, r0)
            if (r3 != 0) goto L_0x0115
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
            goto L_0x00f2
        L_0x0115:
            java.lang.Object r4 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkl.zzi(r3, r4)
            r9.putObject(r14, r0, r3)
            goto L_0x00f2
        L_0x011f:
            r19 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            r0 = 2
            if (r3 != r0) goto L_0x0208
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0135
            int r0 = com.google.android.gms.internal.measurement.zzis.zzf(r12, r4, r11)
            goto L_0x0139
        L_0x0135:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzg(r12, r4, r11)
        L_0x0139:
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r5, r1)
            goto L_0x0200
        L_0x0140:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0208
            int r1 = com.google.android.gms.internal.measurement.zzis.zzc(r12, r4, r11)
            long r2 = r11.zzb
            r21 = 0
            int r2 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r2 == 0) goto L_0x0159
            goto L_0x015b
        L_0x0159:
            r0 = r16
        L_0x015b:
            com.google.android.gms.internal.measurement.zzmr.zzi(r14, r5, r0)
            r6 = r32 | r20
            r0 = r1
            goto L_0x0202
        L_0x0163:
            r19 = r32
            r11 = r34
            r32 = r6
            r0 = r8
            r5 = r22
            r8 = r2
            if (r3 != r0) goto L_0x0208
            int r0 = com.google.android.gms.internal.measurement.zzis.zzd(r12, r4)
            r9.putInt(r14, r5, r0)
            goto L_0x01e4
        L_0x0178:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != r0) goto L_0x0208
            long r21 = com.google.android.gms.internal.measurement.zzis.zze(r12, r4)
            r0 = r9
            r1 = r30
            r2 = r5
            r6 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r6 + 8
            goto L_0x0200
        L_0x0196:
            r19 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0208
            int r0 = com.google.android.gms.internal.measurement.zzis.zza(r12, r4, r11)
            int r1 = r11.zza
            r9.putInt(r14, r5, r1)
            goto L_0x0200
        L_0x01ab:
            r19 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0208
            int r17 = com.google.android.gms.internal.measurement.zzis.zzc(r12, r4, r11)
            long r2 = r11.zzb
            r0 = r9
            r1 = r30
            r21 = r2
            r2 = r5
            r4 = r21
            r0.putLong(r1, r2, r4)
            r6 = r32 | r20
        L_0x01c9:
            r2 = r8
            r0 = r17
            goto L_0x0203
        L_0x01cd:
            r19 = r32
            r11 = r34
            r32 = r6
            r0 = r8
            r5 = r22
            r8 = r2
            if (r3 != r0) goto L_0x0208
            int r0 = com.google.android.gms.internal.measurement.zzis.zzd(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmr.zzk(r14, r5, r0)
        L_0x01e4:
            int r0 = r4 + 4
            goto L_0x0200
        L_0x01e7:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != r0) goto L_0x0208
            long r0 = com.google.android.gms.internal.measurement.zzis.zze(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmr.zzm(r14, r5, r0)
            int r0 = r4 + 8
        L_0x0200:
            r6 = r32 | r20
        L_0x0202:
            r2 = r8
        L_0x0203:
            r1 = r19
            r8 = -1
            goto L_0x0019
        L_0x0208:
            r6 = r32
            r2 = r4
            r18 = r8
            r28 = r9
            r27 = -1
            goto L_0x030e
        L_0x0213:
            r19 = r32
            r8 = r2
            r20 = r6
            r5 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r34
            r2 = 27
            if (r0 != r2) goto L_0x026c
            r2 = 2
            if (r3 != r2) goto L_0x025f
            java.lang.Object r0 = r9.getObject(r14, r5)
            com.google.android.gms.internal.measurement.zzkk r0 = (com.google.android.gms.internal.measurement.zzkk) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x0242
            int r1 = r0.size()
            if (r1 != 0) goto L_0x023a
            r1 = 10
            goto L_0x023b
        L_0x023a:
            int r1 = r1 + r1
        L_0x023b:
            com.google.android.gms.internal.measurement.zzkk r0 = r0.zze(r1)
            r9.putObject(r14, r5, r0)
        L_0x0242:
            r5 = r0
            com.google.android.gms.internal.measurement.zzlt r0 = r15.zzv(r8)
            r1 = r17
            r2 = r31
            r3 = r4
            r4 = r33
            r15 = r20
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r0, r1, r2, r3, r4, r5, r6)
            r2 = r8
            r6 = r15
            r1 = r19
            r8 = -1
            r15 = r29
            goto L_0x0019
        L_0x025f:
            r15 = r4
            r26 = r7
            r18 = r8
            r28 = r9
            r23 = r20
            r27 = -1
            goto L_0x02eb
        L_0x026c:
            r15 = r20
            r2 = 49
            if (r0 > r2) goto L_0x02b9
            long r1 = (long) r1
            r32 = r0
            r0 = r29
            r20 = r1
            r1 = r30
            r2 = r31
            r22 = r3
            r3 = r4
            r23 = r15
            r15 = r4
            r4 = r33
            r24 = r5
            r5 = r17
            r6 = r19
            r26 = r7
            r7 = r22
            r18 = r8
            r27 = -1
            r28 = r9
            r9 = r20
            r11 = r32
            r12 = r24
            r14 = r34
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02b7
        L_0x02a3:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r2 = r18
            r1 = r19
            r6 = r23
            r7 = r26
            goto L_0x032c
        L_0x02b7:
            r2 = r0
            goto L_0x02ec
        L_0x02b9:
            r32 = r0
            r22 = r3
            r24 = r5
            r26 = r7
            r18 = r8
            r28 = r9
            r23 = r15
            r27 = -1
            r15 = r4
            r0 = 50
            r9 = r32
            if (r9 != r0) goto L_0x02f1
            r7 = r22
            r0 = 2
            if (r7 != r0) goto L_0x02eb
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r24
            r8 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02b7
            goto L_0x02a3
        L_0x02eb:
            r2 = r15
        L_0x02ec:
            r6 = r23
            r7 = r26
            goto L_0x030e
        L_0x02f1:
            r7 = r22
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r17
            r6 = r19
            r10 = r24
            r12 = r18
            r13 = r34
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02b7
            goto L_0x02a3
        L_0x030e:
            com.google.android.gms.internal.measurement.zzmi r4 = zzf(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zzn(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r2 = r18
            r1 = r19
        L_0x032c:
            r8 = r27
            r9 = r28
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0335:
            r23 = r6
            r28 = r9
            r1 = r10
            if (r7 == r1) goto L_0x0346
            long r1 = (long) r7
            r3 = r30
            r6 = r23
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0346:
            r1 = r33
            if (r0 != r1) goto L_0x034b
            return r0
        L_0x034b:
            com.google.android.gms.internal.measurement.zzkn r0 = com.google.android.gms.internal.measurement.zzkn.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.zzy(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzir):int");
    }

    private static boolean zzz(Object obj, int i, zzlt zzlt) {
        return zzlt.zzj(zzmr.zzn(obj, (long) (i & 1048575)));
    }

    public final T zza() {
        return ((zzkd) this.zzg).zzl(4, (Object) null, (Object) null);
    }

    public final boolean zzb(T t, T t2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzA = zzA(i);
            long j = (long) (zzA & 1048575);
            switch (zzC(zzA)) {
                case 0:
                    if (zzI(t, t2, i) && Double.doubleToLongBits(zzmr.zzl(t, j)) == Double.doubleToLongBits(zzmr.zzl(t2, j))) {
                        continue;
                    }
                case 1:
                    if (zzI(t, t2, i) && Float.floatToIntBits(zzmr.zzj(t, j)) == Float.floatToIntBits(zzmr.zzj(t2, j))) {
                        continue;
                    }
                case 2:
                    if (zzI(t, t2, i) && zzmr.zzf(t, j) == zzmr.zzf(t2, j)) {
                        continue;
                    }
                case 3:
                    if (zzI(t, t2, i) && zzmr.zzf(t, j) == zzmr.zzf(t2, j)) {
                        continue;
                    }
                case 4:
                    if (zzI(t, t2, i) && zzmr.zzd(t, j) == zzmr.zzd(t2, j)) {
                        continue;
                    }
                case 5:
                    if (zzI(t, t2, i) && zzmr.zzf(t, j) == zzmr.zzf(t2, j)) {
                        continue;
                    }
                case 6:
                    if (zzI(t, t2, i) && zzmr.zzd(t, j) == zzmr.zzd(t2, j)) {
                        continue;
                    }
                case 7:
                    if (zzI(t, t2, i) && zzmr.zzh(t, j) == zzmr.zzh(t2, j)) {
                        continue;
                    }
                case 8:
                    if (zzI(t, t2, i) && zzlv.zzD(zzmr.zzn(t, j), zzmr.zzn(t2, j))) {
                        continue;
                    }
                case 9:
                    if (zzI(t, t2, i) && zzlv.zzD(zzmr.zzn(t, j), zzmr.zzn(t2, j))) {
                        continue;
                    }
                case 10:
                    if (zzI(t, t2, i) && zzlv.zzD(zzmr.zzn(t, j), zzmr.zzn(t2, j))) {
                        continue;
                    }
                case 11:
                    if (zzI(t, t2, i) && zzmr.zzd(t, j) == zzmr.zzd(t2, j)) {
                        continue;
                    }
                case 12:
                    if (zzI(t, t2, i) && zzmr.zzd(t, j) == zzmr.zzd(t2, j)) {
                        continue;
                    }
                case 13:
                    if (zzI(t, t2, i) && zzmr.zzd(t, j) == zzmr.zzd(t2, j)) {
                        continue;
                    }
                case 14:
                    if (zzI(t, t2, i) && zzmr.zzf(t, j) == zzmr.zzf(t2, j)) {
                        continue;
                    }
                case 15:
                    if (zzI(t, t2, i) && zzmr.zzd(t, j) == zzmr.zzd(t2, j)) {
                        continue;
                    }
                case 16:
                    if (zzI(t, t2, i) && zzmr.zzf(t, j) == zzmr.zzf(t2, j)) {
                        continue;
                    }
                case 17:
                    if (zzI(t, t2, i) && zzlv.zzD(zzmr.zzn(t, j), zzmr.zzn(t2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    z = zzlv.zzD(zzmr.zzn(t, j), zzmr.zzn(t2, j));
                    break;
                case 50:
                    z = zzlv.zzD(zzmr.zzn(t, j), zzmr.zzn(t2, j));
                    break;
                case ModuleDescriptor.MODULE_VERSION:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzB = (long) (zzB(i) & 1048575);
                    if (zzmr.zzd(t, zzB) == zzmr.zzd(t2, zzB) && zzlv.zzD(zzmr.zzn(t, j), zzmr.zzn(t2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzn.zzd(t).equals(this.zzn.zzd(t2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zzb(t);
        this.zzo.zzb(t2);
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzA(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzC(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzG(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzF(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzG(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzF(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzF(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzF(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzH(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zzf(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzF(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzG(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzF(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzG(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzG(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzE(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzM(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzD(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmr.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmr.zzd(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmr.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmr.zzd(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmr.zzd(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmr.zzd(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmr.zzn(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzmr.zzh(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zzf(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmr.zzd(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmr.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmr.zzd(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmr.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmr.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzmr.zzj(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzmr.zzl(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkl.zze(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzmh<?, ?> r0 = r8.zzn
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.measurement.zzjq<?> r0 = r8.zzo
            r0.zzb(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.zzc(java.lang.Object):int");
    }

    public final int zze(T t) {
        return this.zzi ? zzr(t) : zzq(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0367, code lost:
        if (r0 != r3) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0382, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03ae, code lost:
        if (r0 != r14) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d0, code lost:
        if (r0 != r14) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01f0, code lost:
        r1 = r6 | r23;
        r6 = r31;
        r2 = r5;
        r3 = r7;
        r5 = r1;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x021b, code lost:
        r2 = r1;
        r20 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0297, code lost:
        r5 = r6 | r23;
        r6 = r31;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x029c, code lost:
        r1 = r11;
        r2 = r13;
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02a2, code lost:
        r20 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02c0, code lost:
        r15 = r33;
        r21 = r6;
        r27 = r10;
        r26 = r19;
        r6 = r31;
        r19 = r7;
        r7 = r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzg(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.zzir r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r31
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            r17 = 0
            if (r0 >= r13) goto L_0x0441
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002d
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002e
        L_0x002d:
            r4 = r0
        L_0x002e:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r2) goto L_0x003b
            int r3 = r3 / r7
            int r2 = r15.zzP(r0, r3)
            goto L_0x003f
        L_0x003b:
            int r2 = r15.zzO(r0)
        L_0x003f:
            r3 = -1
            if (r2 != r3) goto L_0x0051
            r20 = r0
            r2 = r1
            r26 = r3
            r7 = r4
            r21 = r5
            r27 = r10
            r15 = r11
            r19 = r16
            goto L_0x03d3
        L_0x0051:
            int[] r3 = r15.zzc
            int r20 = r2 + 1
            r3 = r3[r20]
            int r7 = zzC(r3)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r3 & r18
            r22 = r3
            r21 = r4
            long r3 = (long) r0
            r0 = 17
            if (r7 > r0) goto L_0x02cf
            int[] r0 = r15.zzc
            int r23 = r2 + 2
            r0 = r0[r23]
            int r23 = r0 >>> 20
            r11 = 1
            int r23 = r11 << r23
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r11
            if (r0 == r6) goto L_0x0089
            if (r6 == r11) goto L_0x0082
            long r11 = (long) r6
            r10.putInt(r14, r11, r5)
        L_0x0082:
            long r5 = (long) r0
            int r5 = r10.getInt(r14, r5)
            r11 = r0
            goto L_0x008a
        L_0x0089:
            r11 = r6
        L_0x008a:
            r6 = r5
            r0 = 5
            switch(r7) {
                case 0: goto L_0x027b;
                case 1: goto L_0x025f;
                case 2: goto L_0x0239;
                case 3: goto L_0x0239;
                case 4: goto L_0x0220;
                case 5: goto L_0x01fa;
                case 6: goto L_0x01da;
                case 7: goto L_0x01b9;
                case 8: goto L_0x0196;
                case 9: goto L_0x0167;
                case 10: goto L_0x014e;
                case 11: goto L_0x0220;
                case 12: goto L_0x0115;
                case 13: goto L_0x01da;
                case 14: goto L_0x01fa;
                case 15: goto L_0x00f9;
                case 16: goto L_0x00bf;
                default: goto L_0x008f;
            }
        L_0x008f:
            r12 = r30
            r7 = r2
            r31 = r11
            r13 = r20
            r11 = r21
            r0 = 3
            r19 = -1
            r2 = r1
            if (r8 != r0) goto L_0x02a2
            com.google.android.gms.internal.measurement.zzlt r0 = r15.zzv(r7)
            int r1 = r13 << 3
            r5 = r1 | 4
            r1 = r30
            r20 = r13
            r12 = r3
            r3 = r32
            r4 = r5
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x02a5
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x02b2
        L_0x00bf:
            if (r8 != 0) goto L_0x00ed
            r12 = r30
            int r7 = com.google.android.gms.internal.measurement.zzis.zzc(r12, r1, r9)
            long r0 = r9.zzb
            long r24 = com.google.android.gms.internal.measurement.zzjg.zzc(r0)
            r8 = r20
            r0 = r10
            r1 = r29
            r5 = r2
            r19 = -1
            r2 = r3
            r17 = r7
            r31 = r11
            r11 = r21
            r7 = r5
            r4 = r24
            r0.putLong(r1, r2, r4)
            r5 = r6 | r23
            r6 = r31
            r3 = r7
            r2 = r8
            r1 = r11
            r0 = r17
            goto L_0x031c
        L_0x00ed:
            r12 = r30
            r7 = r2
            r31 = r11
            r11 = r21
            r19 = -1
            r2 = r1
            goto L_0x02c0
        L_0x00f9:
            r12 = r30
            r7 = r2
            r31 = r11
            r5 = r20
            r11 = r21
            r19 = -1
            if (r8 != 0) goto L_0x021b
            int r0 = com.google.android.gms.internal.measurement.zzis.zza(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzjg.zzb(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x01f0
        L_0x0115:
            r12 = r30
            r7 = r2
            r31 = r11
            r5 = r20
            r11 = r21
            r19 = -1
            if (r8 != 0) goto L_0x021b
            int r0 = com.google.android.gms.internal.measurement.zzis.zza(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.measurement.zzkh r2 = r15.zzx(r7)
            if (r2 == 0) goto L_0x0149
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0135
            goto L_0x0149
        L_0x0135:
            com.google.android.gms.internal.measurement.zzmi r2 = zzf(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r2 = r5
            r5 = r6
            r3 = r7
            r1 = r11
            r6 = r31
            goto L_0x031c
        L_0x0149:
            r10.putInt(r14, r3, r1)
            goto L_0x01f0
        L_0x014e:
            r12 = r30
            r7 = r2
            r31 = r11
            r5 = r20
            r11 = r21
            r0 = 2
            r19 = -1
            if (r8 != r0) goto L_0x021b
            int r0 = com.google.android.gms.internal.measurement.zzis.zzh(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x01f0
        L_0x0167:
            r12 = r30
            r7 = r2
            r31 = r11
            r5 = r20
            r11 = r21
            r0 = 2
            r19 = -1
            if (r8 != r0) goto L_0x021b
            com.google.android.gms.internal.measurement.zzlt r0 = r15.zzv(r7)
            int r0 = com.google.android.gms.internal.measurement.zzis.zzi(r0, r12, r1, r13, r9)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x0188
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x01f0
        L_0x0188:
            java.lang.Object r1 = r10.getObject(r14, r3)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkl.zzi(r1, r2)
            r10.putObject(r14, r3, r1)
            goto L_0x01f0
        L_0x0196:
            r12 = r30
            r7 = r2
            r31 = r11
            r5 = r20
            r11 = r21
            r0 = 2
            r19 = -1
            if (r8 != r0) goto L_0x021b
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r22 & r0
            if (r0 != 0) goto L_0x01af
            int r0 = com.google.android.gms.internal.measurement.zzis.zzf(r12, r1, r9)
            goto L_0x01b3
        L_0x01af:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzg(r12, r1, r9)
        L_0x01b3:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x01f0
        L_0x01b9:
            r12 = r30
            r7 = r2
            r31 = r11
            r5 = r20
            r11 = r21
            r19 = -1
            if (r8 != 0) goto L_0x021b
            int r0 = com.google.android.gms.internal.measurement.zzis.zzc(r12, r1, r9)
            long r1 = r9.zzb
            r20 = 0
            int r1 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x01d4
            r1 = 1
            goto L_0x01d6
        L_0x01d4:
            r1 = r16
        L_0x01d6:
            com.google.android.gms.internal.measurement.zzmr.zzi(r14, r3, r1)
            goto L_0x01f0
        L_0x01da:
            r12 = r30
            r7 = r2
            r31 = r11
            r5 = r20
            r11 = r21
            r19 = -1
            if (r8 != r0) goto L_0x021b
            int r0 = com.google.android.gms.internal.measurement.zzis.zzd(r12, r1)
            r10.putInt(r14, r3, r0)
            int r0 = r1 + 4
        L_0x01f0:
            r1 = r6 | r23
            r6 = r31
            r2 = r5
            r3 = r7
            r5 = r1
            r1 = r11
            goto L_0x031c
        L_0x01fa:
            r12 = r30
            r7 = r2
            r31 = r11
            r5 = r20
            r11 = r21
            r0 = 1
            r19 = -1
            if (r8 != r0) goto L_0x021b
            long r20 = com.google.android.gms.internal.measurement.zzis.zze(r12, r1)
            r0 = r10
            r8 = r1
            r1 = r29
            r2 = r3
            r13 = r5
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0297
        L_0x021b:
            r2 = r1
            r20 = r5
            goto L_0x02c0
        L_0x0220:
            r12 = r30
            r7 = r2
            r31 = r11
            r13 = r20
            r11 = r21
            r19 = -1
            r2 = r1
            if (r8 != 0) goto L_0x02a2
            int r0 = com.google.android.gms.internal.measurement.zzis.zza(r12, r2, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x0297
        L_0x0239:
            r12 = r30
            r7 = r2
            r31 = r11
            r13 = r20
            r11 = r21
            r19 = -1
            r2 = r1
            if (r8 != 0) goto L_0x02a2
            int r8 = com.google.android.gms.internal.measurement.zzis.zzc(r12, r2, r9)
            long r1 = r9.zzb
            r0 = r10
            r20 = r1
            r1 = r29
            r2 = r3
            r4 = r20
            r0.putLong(r1, r2, r4)
            r5 = r6 | r23
            r6 = r31
            r3 = r7
            r0 = r8
            goto L_0x029c
        L_0x025f:
            r12 = r30
            r7 = r2
            r31 = r11
            r13 = r20
            r11 = r21
            r19 = -1
            r2 = r1
            if (r8 != r0) goto L_0x02a2
            int r0 = com.google.android.gms.internal.measurement.zzis.zzd(r12, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmr.zzk(r14, r3, r0)
            int r0 = r2 + 4
            goto L_0x0297
        L_0x027b:
            r12 = r30
            r7 = r2
            r31 = r11
            r13 = r20
            r11 = r21
            r0 = 1
            r19 = -1
            r2 = r1
            if (r8 != r0) goto L_0x02a2
            long r0 = com.google.android.gms.internal.measurement.zzis.zze(r12, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmr.zzm(r14, r3, r0)
            int r0 = r2 + 8
        L_0x0297:
            r5 = r6 | r23
            r6 = r31
            r3 = r7
        L_0x029c:
            r1 = r11
            r2 = r13
            r13 = r32
            goto L_0x031c
        L_0x02a2:
            r20 = r13
            goto L_0x02c0
        L_0x02a5:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkl.zzi(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x02b2:
            r5 = r6 | r23
            r12 = r30
            r6 = r31
            r13 = r32
            r3 = r7
            r1 = r11
            r2 = r20
            goto L_0x031c
        L_0x02c0:
            r15 = r33
            r21 = r6
            r27 = r10
            r26 = r19
            r6 = r31
            r19 = r7
            r7 = r11
            goto L_0x03d3
        L_0x02cf:
            r12 = r3
            r4 = r7
            r11 = r21
            r19 = -1
            r7 = r2
            r2 = r1
            r0 = 27
            if (r4 != r0) goto L_0x0331
            r0 = 2
            if (r8 != r0) goto L_0x0320
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.measurement.zzkk r0 = (com.google.android.gms.internal.measurement.zzkk) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x02fb
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02f3
            r1 = 10
            goto L_0x02f4
        L_0x02f3:
            int r1 = r1 + r1
        L_0x02f4:
            com.google.android.gms.internal.measurement.zzkk r0 = r0.zze(r1)
            r10.putObject(r14, r12, r0)
        L_0x02fb:
            r8 = r0
            com.google.android.gms.internal.measurement.zzlt r0 = r15.zzv(r7)
            r1 = r11
            r3 = r2
            r2 = r30
            r4 = r32
            r21 = r5
            r5 = r8
            r23 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r0, r1, r2, r3, r4, r5, r6)
            r12 = r30
            r13 = r32
            r3 = r7
            r2 = r20
            r5 = r21
            r6 = r23
        L_0x031c:
            r11 = r33
            goto L_0x001a
        L_0x0320:
            r21 = r5
            r23 = r6
            r15 = r33
            r14 = r2
            r27 = r10
            r18 = r11
            r26 = r19
            r19 = r7
            goto L_0x03b1
        L_0x0331:
            r3 = r2
            r21 = r5
            r23 = r6
            r0 = 49
            if (r4 > r0) goto L_0x0384
            r5 = r22
            long r5 = (long) r5
            r0 = r28
            r1 = r29
            r2 = r30
            r31 = r3
            r22 = r4
            r4 = r32
            r24 = r5
            r5 = r11
            r6 = r20
            r26 = r19
            r19 = r7
            r7 = r8
            r8 = r19
            r27 = r10
            r9 = r24
            r15 = r33
            r18 = r11
            r11 = r22
            r14 = r34
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r31
            if (r0 == r14) goto L_0x0382
        L_0x0369:
            r14 = r29
            r12 = r30
            r13 = r32
            r9 = r34
            r11 = r15
            r1 = r18
            r3 = r19
            r2 = r20
            r5 = r21
            r6 = r23
            r10 = r27
            r15 = r28
            goto L_0x001a
        L_0x0382:
            r2 = r0
            goto L_0x03b2
        L_0x0384:
            r15 = r33
            r14 = r3
            r27 = r10
            r18 = r11
            r26 = r19
            r5 = r22
            r22 = r4
            r19 = r7
            r0 = 50
            r9 = r22
            if (r9 != r0) goto L_0x03b7
            r0 = 2
            if (r8 != r0) goto L_0x03b1
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r14
            r4 = r32
            r5 = r19
            r6 = r12
            r8 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r14) goto L_0x0382
            goto L_0x0369
        L_0x03b1:
            r2 = r14
        L_0x03b2:
            r7 = r18
            r6 = r23
            goto L_0x03d3
        L_0x03b7:
            r0 = r28
            r1 = r29
            r2 = r30
            r10 = r5
            r3 = r14
            r4 = r32
            r5 = r18
            r6 = r20
            r7 = r8
            r8 = r10
            r10 = r12
            r12 = r19
            r13 = r34
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x0382
            goto L_0x0369
        L_0x03d3:
            if (r7 != r15) goto L_0x03e2
            if (r15 == 0) goto L_0x03e2
            r8 = r28
            r12 = r29
            r0 = r2
            r1 = r7
            r9 = r15
            r5 = r21
            goto L_0x044a
        L_0x03e2:
            r8 = r28
            r9 = r15
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x041a
            r10 = r34
            com.google.android.gms.internal.measurement.zzjp r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzjp r1 = com.google.android.gms.internal.measurement.zzjp.zza()
            if (r0 == r1) goto L_0x0417
            com.google.android.gms.internal.measurement.zzli r0 = r8.zzg
            com.google.android.gms.internal.measurement.zzjp r1 = r10.zzd
            r11 = r20
            com.google.android.gms.internal.measurement.zzkb r0 = r1.zzc(r0, r11)
            if (r0 != 0) goto L_0x0411
            com.google.android.gms.internal.measurement.zzmi r4 = zzf(r29)
            r0 = r7
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zzn(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x042f
        L_0x0411:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.measurement.zzka r0 = (com.google.android.gms.internal.measurement.zzka) r0
            throw r17
        L_0x0417:
            r12 = r29
            goto L_0x041e
        L_0x041a:
            r12 = r29
            r10 = r34
        L_0x041e:
            r11 = r20
            com.google.android.gms.internal.measurement.zzmi r4 = zzf(r29)
            r0 = r7
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zzn(r0, r1, r2, r3, r4, r5)
        L_0x042f:
            r13 = r32
            r1 = r7
            r15 = r8
            r2 = r11
            r14 = r12
            r3 = r19
            r5 = r21
            r12 = r30
            r11 = r9
            r9 = r10
            r10 = r27
            goto L_0x001a
        L_0x0441:
            r21 = r5
            r23 = r6
            r27 = r10
            r9 = r11
            r12 = r14
            r8 = r15
        L_0x044a:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x0455
            long r3 = (long) r6
            r6 = r27
            r6.putInt(r12, r3, r5)
        L_0x0455:
            int r3 = r8.zzk
        L_0x0457:
            int r4 = r8.zzl
            if (r3 >= r4) goto L_0x0482
            int[] r4 = r8.zzj
            r4 = r4[r3]
            int[] r5 = r8.zzc
            r5 = r5[r4]
            int r5 = r8.zzA(r4)
            r5 = r5 & r2
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzmr.zzn(r12, r5)
            if (r5 != 0) goto L_0x0470
            goto L_0x0476
        L_0x0470:
            com.google.android.gms.internal.measurement.zzkh r6 = r8.zzx(r4)
            if (r6 != 0) goto L_0x0479
        L_0x0476:
            int r3 = r3 + 1
            goto L_0x0457
        L_0x0479:
            com.google.android.gms.internal.measurement.zzlc r5 = (com.google.android.gms.internal.measurement.zzlc) r5
            java.lang.Object r0 = r8.zzw(r4)
            com.google.android.gms.internal.measurement.zzlb r0 = (com.google.android.gms.internal.measurement.zzlb) r0
            throw r17
        L_0x0482:
            if (r9 != 0) goto L_0x048e
            r2 = r32
            if (r0 != r2) goto L_0x0489
            goto L_0x0494
        L_0x0489:
            com.google.android.gms.internal.measurement.zzkn r0 = com.google.android.gms.internal.measurement.zzkn.zze()
            throw r0
        L_0x048e:
            r2 = r32
            if (r0 > r2) goto L_0x0495
            if (r1 != r9) goto L_0x0495
        L_0x0494:
            return r0
        L_0x0495:
            com.google.android.gms.internal.measurement.zzkn r0 = com.google.android.gms.internal.measurement.zzkn.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzll.zzg(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzir):int");
    }

    public final void zzh(T t, byte[] bArr, int i, int i2, zzir zzir) throws IOException {
        if (this.zzi) {
            zzy(t, bArr, i, i2, zzir);
        } else {
            zzg(t, bArr, i, i2, 0, zzir);
        }
    }

    public final void zzi(T t) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long zzA = (long) (zzA(this.zzj[i2]) & 1048575);
            Object zzn2 = zzmr.zzn(t, zzA);
            if (zzn2 != null) {
                ((zzlc) zzn2).zzd();
                zzmr.zzo(t, zzA, zzn2);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(t, (long) this.zzj[i]);
            i++;
        }
        this.zzn.zze(t);
        if (this.zzh) {
            this.zzo.zzc(t);
        }
    }

    public final boolean zzj(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzA = zzA(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzA) != 0 && !zzJ(t, i6, i2, i, i10)) {
                return false;
            }
            int zzC = zzC(zzA);
            if (zzC != 9 && zzC != 17) {
                if (zzC != 27) {
                    if (zzC == 60 || zzC == 68) {
                        if (zzM(t2, i7, i6) && !zzz(t2, zzA, zzv(i6))) {
                            return false;
                        }
                    } else if (zzC != 49) {
                        if (zzC == 50 && !((zzlc) zzmr.zzn(t2, (long) (zzA & 1048575))).isEmpty()) {
                            zzlb zzlb = (zzlb) zzw(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzmr.zzn(t2, (long) (zzA & 1048575));
                if (!list.isEmpty()) {
                    zzlt zzv = zzv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzv.zzj(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzJ(t, i6, i2, i, i10) && !zzz(t2, zzA, zzv(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zzb(t2);
        throw null;
    }

    public final void zzm(T t, zzjl zzjl) throws IOException {
        if (!this.zzi) {
            zzR(t, zzjl);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzA = zzA(i);
                int i2 = this.zzc[i];
                switch (zzC(zzA)) {
                    case 0:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzf(i2, zzmr.zzl(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zze(i2, zzmr.zzj(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzc(i2, zzmr.zzf(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzh(i2, zzmr.zzf(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzi(i2, zzmr.zzd(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzj(i2, zzmr.zzf(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzk(i2, zzmr.zzd(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzl(i2, zzmr.zzh(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzT(i2, zzmr.zzn(t, (long) (zzA & 1048575)), zzjl);
                            break;
                        }
                    case 9:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzr(i2, zzmr.zzn(t, (long) (zzA & 1048575)), zzv(i));
                            break;
                        }
                    case 10:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzn(i2, (zzjd) zzmr.zzn(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzo(i2, zzmr.zzd(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzg(i2, zzmr.zzd(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzb(i2, zzmr.zzd(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzd(i2, zzmr.zzf(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzp(i2, zzmr.zzd(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzq(i2, zzmr.zzf(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzK(t, i)) {
                            break;
                        } else {
                            zzjl.zzs(i2, zzmr.zzn(t, (long) (zzA & 1048575)), zzv(i));
                            break;
                        }
                    case 18:
                        zzlv.zzJ(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 19:
                        zzlv.zzK(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 20:
                        zzlv.zzL(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 21:
                        zzlv.zzM(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 22:
                        zzlv.zzQ(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 23:
                        zzlv.zzO(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 24:
                        zzlv.zzT(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 25:
                        zzlv.zzW(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 26:
                        zzlv.zzX(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl);
                        break;
                    case 27:
                        zzlv.zzZ(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, zzv(i));
                        break;
                    case 28:
                        zzlv.zzY(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                        zzlv.zzR(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 30:
                        zzlv.zzV(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 31:
                        zzlv.zzU(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 32:
                        zzlv.zzP(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 33:
                        zzlv.zzS(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 34:
                        zzlv.zzN(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, false);
                        break;
                    case 35:
                        zzlv.zzJ(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 36:
                        zzlv.zzK(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 37:
                        zzlv.zzL(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 38:
                        zzlv.zzM(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 39:
                        zzlv.zzQ(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 40:
                        zzlv.zzO(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 41:
                        zzlv.zzT(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 42:
                        zzlv.zzW(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 43:
                        zzlv.zzR(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 44:
                        zzlv.zzV(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 45:
                        zzlv.zzU(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 46:
                        zzlv.zzP(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case 47:
                        zzlv.zzS(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        zzlv.zzN(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                        zzlv.zzaa(this.zzc[i], (List) zzmr.zzn(t, (long) (zzA & 1048575)), zzjl, zzv(i));
                        break;
                    case 50:
                        zzS(zzjl, i2, zzmr.zzn(t, (long) (zzA & 1048575)), i);
                        break;
                    case ModuleDescriptor.MODULE_VERSION:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzf(i2, zzD(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zze(i2, zzE(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzc(i2, zzG(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzh(i2, zzG(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzi(i2, zzF(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzj(i2, zzG(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzk(i2, zzF(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzl(i2, zzH(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzT(i2, zzmr.zzn(t, (long) (zzA & 1048575)), zzjl);
                            break;
                        }
                    case 60:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzr(i2, zzmr.zzn(t, (long) (zzA & 1048575)), zzv(i));
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzn(i2, (zzjd) zzmr.zzn(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzo(i2, zzF(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzg(i2, zzF(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzb(i2, zzF(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzd(i2, zzG(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzp(i2, zzF(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzq(i2, zzG(t, (long) (zzA & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzM(t, i2, i)) {
                            break;
                        } else {
                            zzjl.zzs(i2, zzmr.zzn(t, (long) (zzA & 1048575)), zzv(i));
                            break;
                        }
                }
            }
            zzmh<?, ?> zzmh = this.zzn;
            zzmh.zzi(zzmh.zzd(t), zzjl);
        } else {
            this.zzo.zzb(t);
            throw null;
        }
    }

    public final void zzd(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzA = zzA(i);
            long j = (long) (1048575 & zzA);
            int i2 = this.zzc[i];
            switch (zzC(zzA)) {
                case 0:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzm(t, j, zzmr.zzl(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 1:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzk(t, j, zzmr.zzj(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 2:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzg(t, j, zzmr.zzf(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 3:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzg(t, j, zzmr.zzf(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 4:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zze(t, j, zzmr.zzd(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 5:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzg(t, j, zzmr.zzf(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 6:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zze(t, j, zzmr.zzd(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 7:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzi(t, j, zzmr.zzh(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 8:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzo(t, j, zzmr.zzn(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 9:
                    zzo(t, t2, i);
                    break;
                case 10:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzo(t, j, zzmr.zzn(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 11:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zze(t, j, zzmr.zzd(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 12:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zze(t, j, zzmr.zzd(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 13:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zze(t, j, zzmr.zzd(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 14:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzg(t, j, zzmr.zzf(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 15:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zze(t, j, zzmr.zzd(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 16:
                    if (!zzK(t2, i)) {
                        break;
                    } else {
                        zzmr.zzg(t, j, zzmr.zzf(t2, j));
                        zzL(t, i);
                        break;
                    }
                case 17:
                    zzo(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    this.zzm.zzb(t, t2, j);
                    break;
                case 50:
                    zzlv.zzI(this.zzq, t, t2, j);
                    break;
                case ModuleDescriptor.MODULE_VERSION:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzM(t2, i2, i)) {
                        break;
                    } else {
                        zzmr.zzo(t, j, zzmr.zzn(t2, j));
                        zzN(t, i2, i);
                        break;
                    }
                case 60:
                    zzp(t, t2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzM(t2, i2, i)) {
                        break;
                    } else {
                        zzmr.zzo(t, j, zzmr.zzn(t2, j));
                        zzN(t, i2, i);
                        break;
                    }
                case 68:
                    zzp(t, t2, i);
                    break;
            }
        }
        zzlv.zzF(this.zzn, t, t2);
        if (this.zzh) {
            zzlv.zzE(this.zzo, t, t2);
        }
    }
}
