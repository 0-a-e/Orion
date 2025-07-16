package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzb {
    private static volatile ClassLoader zza;
    private static volatile Thread zzb;

    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        synchronized (zzb.class) {
            if (zza == null) {
                zza = zzb();
            }
            classLoader = zza;
        }
        return classLoader;
    }

    private static synchronized ClassLoader zzb() {
        synchronized (zzb.class) {
            ClassLoader classLoader = null;
            if (zzb == null) {
                zzb = zzc();
                if (zzb == null) {
                    return null;
                }
            }
            synchronized (zzb) {
                try {
                    classLoader = zzb.getContextClassLoader();
                } catch (SecurityException e) {
                    String message = e.getMessage();
                    Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + message);
                }
            }
            return classLoader;
        }
    }

    private static synchronized Thread zzc() {
        zza zza2;
        zza zza3;
        SecurityException e;
        ThreadGroup threadGroup;
        synchronized (zzb.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= activeGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i2];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i2++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i >= activeCount) {
                            zza2 = null;
                            break;
                        }
                        zza2 = threadArr[i];
                        if ("GmsDynamite".equals(zza2.getName())) {
                            break;
                        }
                        i++;
                    }
                    if (zza2 == null) {
                        try {
                            zza3 = new zza(threadGroup, "GmsDynamite");
                            try {
                                zza3.setContextClassLoader((ClassLoader) null);
                                zza3.start();
                            } catch (SecurityException e2) {
                                e = e2;
                            }
                        } catch (SecurityException e3) {
                            e = e3;
                            zza3 = zza2;
                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                            zza2 = zza3;
                            return zza2;
                        }
                        zza2 = zza3;
                    }
                } catch (SecurityException e4) {
                    e = e4;
                    zza3 = null;
                    Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                    zza2 = zza3;
                    return zza2;
                }
            }
            return zza2;
        }
    }
}
