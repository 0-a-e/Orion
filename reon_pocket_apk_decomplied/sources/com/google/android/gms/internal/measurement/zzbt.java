package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 6
            java.lang.String r2 = "JobSchedulerCompat"
            r3 = 0
            r4 = 24
            if (r0 < r4) goto L_0x0033
            r0 = 4
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<android.app.job.JobInfo> r5 = android.app.job.JobInfo.class
            r6 = 0
            r0[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 1
            r0[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0028 }
            r7 = 2
            r0[r7] = r6     // Catch:{ NoSuchMethodException -> 0x0028 }
            r6 = 3
            r0[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<android.app.job.JobScheduler> r5 = android.app.job.JobScheduler.class
            java.lang.String r6 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r5.getDeclaredMethod(r6, r0)     // Catch:{ NoSuchMethodException -> 0x0028 }
            goto L_0x0034
        L_0x0028:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r2, r0)
        L_0x0033:
            r0 = r3
        L_0x0034:
            zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x004e
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r4 = "myUserId"
            java.lang.reflect.Method r3 = r0.getDeclaredMethod(r4, r3)     // Catch:{ NoSuchMethodException -> 0x0043 }
            goto L_0x004e
        L_0x0043:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r2, r0)
        L_0x004e:
            zzb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045 A[SYNTHETIC, Splitter:B:18:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r7 = "jobscheduler"
            java.lang.Object r7 = r5.getSystemService(r7)
            android.app.job.JobScheduler r7 = (android.app.job.JobScheduler) r7
            r7.getClass()
            java.lang.reflect.Method r8 = zza
            if (r8 == 0) goto L_0x0073
            java.lang.String r8 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r8)
            if (r5 == 0) goto L_0x0018
            goto L_0x0073
        L_0x0018:
            java.lang.reflect.Method r5 = zzb
            r8 = 0
            if (r5 == 0) goto L_0x003e
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            r1 = 0
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            if (r5 == 0) goto L_0x003e
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            goto L_0x003f
        L_0x002d:
            r5 = move-exception
            goto L_0x0030
        L_0x002f:
            r5 = move-exception
        L_0x0030:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x003e
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r5)
        L_0x003e:
            r5 = r8
        L_0x003f:
            java.lang.String r0 = "UploadAlarm"
            java.lang.reflect.Method r1 = zza
            if (r1 == 0) goto L_0x006e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            r2[r8] = r6     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            java.lang.String r3 = "com.google.android.gms"
            r4 = 1
            r2[r4] = r3     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            r3 = 2
            r2[r3] = r5     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            r5 = 3
            r2[r5] = r0     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            java.lang.Object r5 = r1.invoke(r7, r2)     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            if (r5 == 0) goto L_0x0072
            int r8 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x0068, InvocationTargetException -> 0x0066 }
            goto L_0x0072
        L_0x0066:
            r5 = move-exception
            goto L_0x0069
        L_0x0068:
            r5 = move-exception
        L_0x0069:
            java.lang.String r8 = "error calling scheduleAsPackage"
            android.util.Log.e(r0, r8, r5)
        L_0x006e:
            int r8 = r7.schedule(r6)
        L_0x0072:
            return r8
        L_0x0073:
            int r5 = r7.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
