package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a A[SYNTHETIC, Splitter:B:23:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b2  */
    static {
        /*
            java.lang.String r0 = "add"
            int r1 = android.os.Process.myUid()
            zza = r1
            r1 = 0
            r2 = 1
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0018 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0018 }
            r4[r1] = r5     // Catch:{ Exception -> 0x0018 }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.reflect.Method r4 = r5.getMethod(r0, r4)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r4 = r3
        L_0x0019:
            zzb = r4
            boolean r4 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r5 = 2
            if (r4 == 0) goto L_0x0033
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0033 }
            r4[r1] = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r4[r2] = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r0 = r3
        L_0x0034:
            zzc = r0
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r4 = "size"
            java.lang.reflect.Method r0 = r0.getMethod(r4, r3)     // Catch:{ Exception -> 0x003f }
            goto L_0x0040
        L_0x003f:
            r0 = r3
        L_0x0040:
            zzd = r0
            java.lang.Class[] r0 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0051 }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0051 }
            r0[r1] = r4     // Catch:{ Exception -> 0x0051 }
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "get"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0052
        L_0x0051:
            r0 = r3
        L_0x0052:
            zze = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r0 == 0) goto L_0x0069
            java.lang.Class[] r0 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0069 }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0069 }
            r0[r1] = r4     // Catch:{ Exception -> 0x0069 }
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "getName"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006a
        L_0x0069:
            r0 = r3
        L_0x006a:
            zzf = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r4 = "WorkSourceUtil"
            if (r0 == 0) goto L_0x0083
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r6 = "createWorkChain"
            java.lang.reflect.Method r0 = r0.getMethod(r6, r3)     // Catch:{ Exception -> 0x007d }
            goto L_0x0084
        L_0x007d:
            r0 = move-exception
            java.lang.String r6 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r4, r6, r0)
        L_0x0083:
            r0 = r3
        L_0x0084:
            zzg = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00a9
            java.lang.String r0 = "android.os.WorkSource$WorkChain"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00a3 }
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00a3 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00a3 }
            r5[r1] = r6     // Catch:{ Exception -> 0x00a3 }
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r5[r2] = r1     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r1 = "addNode"
            java.lang.reflect.Method r0 = r0.getMethod(r1, r5)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00aa
        L_0x00a3:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r4, r1, r0)
        L_0x00a9:
            r0 = r3
        L_0x00aa:
            zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00bd
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r1 = "isEmpty"
            java.lang.reflect.Method r3 = r0.getMethod(r1, r3)     // Catch:{ Exception -> 0x00bd }
            r3.setAccessible(r2)     // Catch:{ Exception -> 0x00bd }
        L_0x00bd:
            zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    public static void add(WorkSource workSource, int i, String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                }
            }
        }
    }

    public static WorkSource fromPackage(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, (Object[]) null);
                int i2 = zza;
                if (i != i2) {
                    method.invoke(invoke, new Object[]{Integer.valueOf(i), str});
                }
                method.invoke(invoke, new Object[]{Integer.valueOf(i2), str2});
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e);
            }
        }
        return workSource;
    }

    public static int get(WorkSource workSource, int i) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[]{Integer.valueOf(i)});
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static String getName(WorkSource workSource, int i) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i)});
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return null;
        }
    }

    public static List<String> getNames(WorkSource workSource) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (workSource == null) {
            i = 0;
        } else {
            i = size(workSource);
        }
        if (i != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                String name = getName(workSource, i2);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    public static boolean hasWorkSourcePermission(Context context) {
        if (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, (Object[]) null);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e);
            }
        }
        return size(workSource) == 0;
    }

    public static int size(WorkSource workSource) {
        Method method = zzd;
        if (method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(workSource, (Object[]) null);
            Preconditions.checkNotNull(invoke);
            return ((Integer) invoke).intValue();
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return 0;
        }
    }
}
