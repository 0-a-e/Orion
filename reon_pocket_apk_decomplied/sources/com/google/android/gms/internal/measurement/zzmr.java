package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzmr {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zziq.zza();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzmq zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0156  */
    static {
        /*
            sun.misc.Unsafe r0 = zzq()
            zzc = r0
            java.lang.Class r1 = com.google.android.gms.internal.measurement.zziq.zza()
            zzd = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r1 = zzr(r1)
            zze = r1
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = zzr(r2)
            zzf = r2
            r3 = 0
            if (r0 != 0) goto L_0x0020
            goto L_0x002f
        L_0x0020:
            if (r1 == 0) goto L_0x0028
            com.google.android.gms.internal.measurement.zzmp r3 = new com.google.android.gms.internal.measurement.zzmp
            r3.<init>(r0)
            goto L_0x002f
        L_0x0028:
            if (r2 == 0) goto L_0x002f
            com.google.android.gms.internal.measurement.zzmo r3 = new com.google.android.gms.internal.measurement.zzmo
            r3.<init>(r0)
        L_0x002f:
            zzg = r3
            java.lang.String r0 = "getLong"
            java.lang.String r1 = "objectFieldOffset"
            r2 = 2
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x003c
        L_0x003a:
            r3 = r5
            goto L_0x0069
        L_0x003c:
            sun.misc.Unsafe r3 = r3.zza
            if (r3 != 0) goto L_0x0041
            goto L_0x003a
        L_0x0041:
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x0064 }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ all -> 0x0064 }
            java.lang.Class<java.lang.reflect.Field> r7 = java.lang.reflect.Field.class
            r6[r5] = r7     // Catch:{ all -> 0x0064 }
            r3.getMethod(r1, r6)     // Catch:{ all -> 0x0064 }
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0064 }
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r6[r5] = r7     // Catch:{ all -> 0x0064 }
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ all -> 0x0064 }
            r6[r4] = r7     // Catch:{ all -> 0x0064 }
            r3.getMethod(r0, r6)     // Catch:{ all -> 0x0064 }
            java.lang.reflect.Field r3 = zzB()     // Catch:{ all -> 0x0064 }
            if (r3 != 0) goto L_0x0062
            goto L_0x003a
        L_0x0062:
            r3 = r4
            goto L_0x0069
        L_0x0064:
            r3 = move-exception
            zzs(r3)
            goto L_0x003a
        L_0x0069:
            zzh = r3
            com.google.android.gms.internal.measurement.zzmq r3 = zzg
            if (r3 != 0) goto L_0x0072
        L_0x006f:
            r0 = r5
            goto L_0x0103
        L_0x0072:
            sun.misc.Unsafe r3 = r3.zza
            if (r3 != 0) goto L_0x0077
            goto L_0x006f
        L_0x0077:
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x00fd }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.reflect.Field> r7 = java.lang.reflect.Field.class
            r6[r5] = r7     // Catch:{ all -> 0x00fd }
            r3.getMethod(r1, r6)     // Catch:{ all -> 0x00fd }
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
            r1[r5] = r6     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "arrayBaseOffset"
            r3.getMethod(r6, r1)     // Catch:{ all -> 0x00fd }
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.Class> r6 = java.lang.Class.class
            r1[r5] = r6     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "arrayIndexScale"
            r3.getMethod(r6, r1)     // Catch:{ all -> 0x00fd }
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r1[r5] = r6     // Catch:{ all -> 0x00fd }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fd }
            r1[r4] = r6     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "getInt"
            r3.getMethod(r6, r1)     // Catch:{ all -> 0x00fd }
            r1 = 3
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r6[r5] = r7     // Catch:{ all -> 0x00fd }
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fd }
            r6[r4] = r7     // Catch:{ all -> 0x00fd }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00fd }
            r6[r2] = r7     // Catch:{ all -> 0x00fd }
            java.lang.String r7 = "putInt"
            r3.getMethod(r7, r6)     // Catch:{ all -> 0x00fd }
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r6[r5] = r7     // Catch:{ all -> 0x00fd }
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fd }
            r6[r4] = r7     // Catch:{ all -> 0x00fd }
            r3.getMethod(r0, r6)     // Catch:{ all -> 0x00fd }
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r0[r5] = r6     // Catch:{ all -> 0x00fd }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fd }
            r0[r4] = r6     // Catch:{ all -> 0x00fd }
            r0[r2] = r6     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "putLong"
            r3.getMethod(r6, r0)     // Catch:{ all -> 0x00fd }
            java.lang.Class[] r0 = new java.lang.Class[r2]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r0[r5] = r6     // Catch:{ all -> 0x00fd }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fd }
            r0[r4] = r6     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "getObject"
            r3.getMethod(r6, r0)     // Catch:{ all -> 0x00fd }
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ all -> 0x00fd }
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            r0[r5] = r1     // Catch:{ all -> 0x00fd }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fd }
            r0[r4] = r6     // Catch:{ all -> 0x00fd }
            r0[r2] = r1     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = "putObject"
            r3.getMethod(r1, r0)     // Catch:{ all -> 0x00fd }
            r0 = r4
            goto L_0x0103
        L_0x00fd:
            r0 = move-exception
            zzs(r0)
            goto L_0x006f
        L_0x0103:
            zzi = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzz(r0)
            long r0 = (long) r0
            zza = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzz(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x014d
            com.google.android.gms.internal.measurement.zzmq r1 = zzg
            if (r1 == 0) goto L_0x014d
            r1.zzh(r0)
        L_0x014d:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0156
            goto L_0x0157
        L_0x0156:
            r4 = r5
        L_0x0157:
            zzb = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmr.<clinit>():void");
    }

    private zzmr() {
    }

    private static int zzA(Class<?> cls) {
        if (zzi) {
            return zzg.zzj(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i = zziq.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(Buffer.class, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzmq zzmq = zzg;
        int zzk = zzmq.zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzmq.zzl(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzmq zzmq = zzg;
        int i = (((int) j) & 3) << 3;
        zzmq.zzl(obj, j2, ((255 & b) << i) | (zzmq.zzk(obj, j2) & (~(255 << i))));
    }

    static boolean zza() {
        return zzi;
    }

    static boolean zzb() {
        return zzh;
    }

    static <T> T zzc(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static int zzd(Object obj, long j) {
        return zzg.zzk(obj, j);
    }

    static void zze(Object obj, long j, int i) {
        zzg.zzl(obj, j, i);
    }

    static long zzf(Object obj, long j) {
        return zzg.zzm(obj, j);
    }

    static void zzg(Object obj, long j, long j2) {
        zzg.zzn(obj, j, j2);
    }

    static boolean zzh(Object obj, long j) {
        return zzg.zzb(obj, j);
    }

    static void zzi(Object obj, long j, boolean z) {
        zzg.zzc(obj, j, z);
    }

    static float zzj(Object obj, long j) {
        return zzg.zzd(obj, j);
    }

    static void zzk(Object obj, long j, float f) {
        zzg.zze(obj, j, f);
    }

    static double zzl(Object obj, long j) {
        return zzg.zzf(obj, j);
    }

    static void zzm(Object obj, long j, double d) {
        zzg.zzg(obj, j, d);
    }

    static Object zzn(Object obj, long j) {
        return zzg.zzo(obj, j);
    }

    static void zzo(Object obj, long j, Object obj2) {
        zzg.zzp(obj, j, obj2);
    }

    static void zzp(byte[] bArr, long j, byte b) {
        zzg.zza(bArr, zza + j, b);
    }

    static Unsafe zzq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmn());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzr(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zziq.zza;
        try {
            Class<?> cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            Class cls4 = Integer.TYPE;
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls4, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static /* synthetic */ void zzs(Throwable th) {
        Logger logger = Logger.getLogger(zzmr.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
        sb.append("platform method missing - proto runtime falling back to safer methods: ");
        sb.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb.toString());
    }

    static /* synthetic */ boolean zzv(Object obj, long j) {
        return ((byte) ((zzg.zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzw(Object obj, long j) {
        return ((byte) ((zzg.zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    private static int zzz(Class<?> cls) {
        if (zzi) {
            return zzg.zzi(cls);
        }
        return -1;
    }
}
