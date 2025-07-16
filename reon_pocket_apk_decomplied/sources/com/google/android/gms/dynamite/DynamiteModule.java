package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import jp.co.sony.reonpocket.connection.log.logcat.LogCatFileRepository;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzl();
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        int i;
        Boolean bool;
        DynamiteModule dynamiteModule;
        IObjectWrapper iObjectWrapper;
        zzr zzr;
        boolean z;
        Boolean valueOf;
        IObjectWrapper iObjectWrapper2;
        Context context2 = context;
        VersionPolicy versionPolicy2 = versionPolicy;
        String str2 = str;
        ThreadLocal threadLocal = zzg;
        zzn zzn = (zzn) threadLocal.get();
        zzn zzn2 = new zzn((zzm) null);
        threadLocal.set(zzn2);
        ThreadLocal threadLocal2 = zzh;
        Long l = (Long) threadLocal2.get();
        long longValue = l.longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectModule = versionPolicy2.selectModule(context2, str2, zzi);
            String str3 = "No acceptable module ";
            String str4 = "VersionPolicy returned invalid code:";
            Log.i("DynamiteModule", "Considering local module " + str2 + ":" + selectModule.localVersion + " and remote module " + str2 + ":" + selectModule.remoteVersion);
            int i2 = selectModule.selection;
            if (i2 != 0) {
                if (i2 == -1) {
                    if (selectModule.localVersion != 0) {
                        i2 = -1;
                    }
                }
                if (!(i2 == 1 && selectModule.remoteVersion == 0)) {
                    if (i2 == -1) {
                        DynamiteModule zzc2 = zzc(context2, str2);
                        if (longValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(l);
                        }
                        Cursor cursor = zzn2.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(zzn);
                        return zzc2;
                    } else if (i2 == 1) {
                        try {
                            int i3 = selectModule.remoteVersion;
                            try {
                                synchronized (DynamiteModule.class) {
                                    if (zzf(context)) {
                                        bool = zzb;
                                    } else {
                                        throw new LoadingException("Remote loading disabled", (zzp) null);
                                    }
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str2 + ", version >= " + i3);
                                        synchronized (DynamiteModule.class) {
                                            zzr = zzl;
                                        }
                                        if (zzr != null) {
                                            zzn zzn3 = (zzn) threadLocal.get();
                                            if (zzn3 == null || zzn3.zza == null) {
                                                throw new LoadingException("No result cursor", (zzp) null);
                                            }
                                            Context applicationContext = context.getApplicationContext();
                                            Cursor cursor2 = zzn3.zza;
                                            ObjectWrapper.wrap(null);
                                            synchronized (DynamiteModule.class) {
                                                z = zze >= 2;
                                                valueOf = Boolean.valueOf(z);
                                            }
                                            valueOf.getClass();
                                            if (z) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                iObjectWrapper2 = zzr.zzf(ObjectWrapper.wrap(applicationContext), str2, i3, ObjectWrapper.wrap(cursor2));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                iObjectWrapper2 = zzr.zze(ObjectWrapper.wrap(applicationContext), str2, i3, ObjectWrapper.wrap(cursor2));
                                            }
                                            Context context3 = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
                                            if (context3 != null) {
                                                dynamiteModule = new DynamiteModule(context3);
                                            } else {
                                                throw new LoadingException("Failed to get module context", (zzp) null);
                                            }
                                        } else {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", (zzp) null);
                                        }
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str2 + ", version >= " + i3);
                                        zzq zzg2 = zzg(context);
                                        if (zzg2 != null) {
                                            int zze2 = zzg2.zze();
                                            if (zze2 >= 3) {
                                                zzn zzn4 = (zzn) threadLocal.get();
                                                if (zzn4 != null) {
                                                    iObjectWrapper = zzg2.zzi(ObjectWrapper.wrap(context), str2, i3, ObjectWrapper.wrap(zzn4.zza));
                                                } else {
                                                    throw new LoadingException("No cached result cursor holder", (zzp) null);
                                                }
                                            } else if (zze2 == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                iObjectWrapper = zzg2.zzj(ObjectWrapper.wrap(context), str2, i3);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                iObjectWrapper = zzg2.zzh(ObjectWrapper.wrap(context), str2, i3);
                                            }
                                            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                                            if (unwrap != null) {
                                                dynamiteModule = new DynamiteModule((Context) unwrap);
                                            } else {
                                                throw new LoadingException("Failed to load remote module.", (zzp) null);
                                            }
                                        } else {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", (zzp) null);
                                        }
                                    }
                                    if (longValue == 0) {
                                        threadLocal2.remove();
                                    } else {
                                        threadLocal2.set(l);
                                    }
                                    Cursor cursor3 = zzn2.zza;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal.set(zzn);
                                    return dynamiteModule;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.", (zzp) null);
                            } catch (RemoteException e) {
                                throw new LoadingException("Failed to load remote module.", e, (zzp) null);
                            } catch (LoadingException e2) {
                                throw e2;
                            } catch (Throwable th) {
                                CrashUtils.addDynamiteErrorToDropBox(context2, th);
                                throw new LoadingException("Failed to load remote module.", th, (zzp) null);
                            }
                        } catch (LoadingException e3) {
                            Log.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                            int i4 = selectModule.localVersion;
                            if (i4 != 0) {
                                if (versionPolicy.selectModule(context2, str2, new zzo(i4, 0)).selection == -1) {
                                    DynamiteModule zzc3 = zzc(context2, str2);
                                    if (i != 0) {
                                        zzh.set(l);
                                    }
                                    return zzc3;
                                }
                            }
                            throw new LoadingException("Remote load failed. No local fallback found.", e3, (zzp) null);
                        }
                    } else {
                        throw new LoadingException(str4 + i2, (zzp) null);
                    }
                }
            }
            throw new LoadingException(str3 + str2 + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + InstructionFileId.DOT, (zzp) null);
        } finally {
            if (longValue == 0) {
                zzh.remove();
            } else {
                zzh.set(l);
            }
            Cursor cursor4 = zzn2.zza;
            if (cursor4 != null) {
                cursor4.close();
            }
            zzg.set(zzn);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:17:0x003b=Splitter:B:17:0x003b, B:50:0x009e=Splitter:B:50:0x009e} */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01c6 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01c3 }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00dc
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b6 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b6 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b6 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b6 }
            goto L_0x00b4
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b6 }
            goto L_0x00b4
        L_0x003f:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00b6 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b6 }
            if (r5 != 0) goto L_0x00ab
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b6 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x00b6 }
            if (r5 == 0) goto L_0x0055
            goto L_0x00ab
        L_0x0055:
            r5 = 1
            int r5 = zzb(r10, r11, r12, r5)     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x00a1 }
            if (r6 == 0) goto L_0x009e
            boolean r6 = r6.isEmpty()     // Catch:{ LoadingException -> 0x00a1 }
            if (r6 == 0) goto L_0x0065
            goto L_0x009e
        L_0x0065:
            java.lang.ClassLoader r6 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x00a1 }
            if (r6 == 0) goto L_0x006c
            goto L_0x0091
        L_0x006c:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x00a1 }
            r7 = 29
            if (r6 < r7) goto L_0x0083
            androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m()     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x00a1 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00a1 }
            dalvik.system.DelegateLastClassLoader r6 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.lang.String) r6, (java.lang.ClassLoader) r7)     // Catch:{ LoadingException -> 0x00a1 }
            goto L_0x0091
        L_0x0083:
            com.google.android.gms.dynamite.zzc r6 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x00a1 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00a1 }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x00a1 }
        L_0x0091:
            zzd(r6)     // Catch:{ LoadingException -> 0x00a1 }
            r1.set(r2, r6)     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x00a1 }
            zzb = r6     // Catch:{ LoadingException -> 0x00a1 }
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            return r5
        L_0x009e:
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            return r5
        L_0x00a1:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b6 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b6 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b6 }
            goto L_0x00b4
        L_0x00ab:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b6 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b6 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b6 }
        L_0x00b4:
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            goto L_0x00da
        L_0x00b6:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
        L_0x00b9:
            r1 = move-exception
            goto L_0x00be
        L_0x00bb:
            r1 = move-exception
            goto L_0x00be
        L_0x00bd:
            r1 = move-exception
        L_0x00be:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01c3 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c3 }
            r4.<init>()     // Catch:{ all -> 0x01c3 }
            java.lang.String r5 = "Failed to load module via V2: "
            r4.append(r5)     // Catch:{ all -> 0x01c3 }
            r4.append(r1)     // Catch:{ all -> 0x01c3 }
            java.lang.String r1 = "DynamiteModule"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01c3 }
            android.util.Log.w(r1, r4)     // Catch:{ all -> 0x01c3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01c3 }
        L_0x00da:
            zzb = r1     // Catch:{ all -> 0x01c3 }
        L_0x00dc:
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01c6 }
            if (r0 == 0) goto L_0x0104
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00e8 }
            return r10
        L_0x00e8:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01c6 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c6 }
            r12.<init>()     // Catch:{ all -> 0x01c6 }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r12.append(r0)     // Catch:{ all -> 0x01c6 }
            r12.append(r11)     // Catch:{ all -> 0x01c6 }
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01c6 }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01c6 }
            return r3
        L_0x0104:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x01c6 }
            if (r4 != 0) goto L_0x010c
            goto L_0x01ba
        L_0x010c:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x0199 }
            r1 = 3
            if (r0 < r1) goto L_0x0174
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x0199 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0199 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x0199 }
            if (r0 == 0) goto L_0x0127
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x0199 }
            if (r0 == 0) goto L_0x0127
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x0199 }
            goto L_0x01ba
        L_0x0127:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0199 }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x0199 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0199 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0199 }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x0199 }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0199 }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x0199 }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x0199 }
            if (r11 == 0) goto L_0x0161
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x0171, all -> 0x016e }
            if (r12 != 0) goto L_0x014c
            goto L_0x0161
        L_0x014c:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x0171, all -> 0x016e }
            if (r12 <= 0) goto L_0x0159
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x0171, all -> 0x016e }
            if (r0 == 0) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            r2 = r11
        L_0x015a:
            if (r2 == 0) goto L_0x015f
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x015f:
            r3 = r12
            goto L_0x01ba
        L_0x0161:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x0171, all -> 0x016e }
            if (r11 == 0) goto L_0x01ba
            r11.close()     // Catch:{ all -> 0x01c6 }
            goto L_0x01ba
        L_0x016e:
            r12 = move-exception
            r2 = r11
            goto L_0x01bd
        L_0x0171:
            r12 = move-exception
            r2 = r11
            goto L_0x019b
        L_0x0174:
            r1 = 2
            if (r0 != r1) goto L_0x0187
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0199 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0199 }
            int r3 = r4.zzg(r0, r11, r12)     // Catch:{ RemoteException -> 0x0199 }
            goto L_0x01ba
        L_0x0187:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0199 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0199 }
            int r3 = r4.zzf(r0, r11, r12)     // Catch:{ RemoteException -> 0x0199 }
            goto L_0x01ba
        L_0x0197:
            r12 = r11
            goto L_0x01bd
        L_0x0199:
            r11 = move-exception
            r12 = r11
        L_0x019b:
            java.lang.String r11 = r12.getMessage()     // Catch:{ all -> 0x01bb }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bb }
            r12.<init>()     // Catch:{ all -> 0x01bb }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r12.append(r0)     // Catch:{ all -> 0x01bb }
            r12.append(r11)     // Catch:{ all -> 0x01bb }
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01bb }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01bb }
            if (r2 == 0) goto L_0x01ba
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x01ba:
            return r3
        L_0x01bb:
            r11 = move-exception
            goto L_0x0197
        L_0x01bd:
            if (r2 == 0) goto L_0x01c2
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x01c2:
            throw r12     // Catch:{ all -> 0x01c6 }
        L_0x01c3:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            throw r11     // Catch:{ all -> 0x01c6 }
        L_0x01c6:
            r11 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[Catch:{ all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bd A[Catch:{ all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r12.<init>()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            if (r10 == 0) goto L_0x00a3
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r11 == 0) goto L_0x00a3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009b }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            zzc = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            zze = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = r11
        L_0x007f:
            zzd = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r13 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r11 = move-exception
            goto L_0x00b8
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r12
        L_0x00a3:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x009b }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x00b2:
            r10 = move-exception
            r11 = r10
            goto L_0x00c7
        L_0x00b5:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b8:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00c5 }
            if (r12 == 0) goto L_0x00bd
            throw r11     // Catch:{ all -> 0x00c5 }
        L_0x00bd:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00c5 }
            java.lang.String r13 = "V2 version check failed"
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00c5 }
            throw r12     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r11 = move-exception
            r0 = r10
        L_0x00c7:
            if (r0 == 0) goto L_0x00cc
            r0.close()
        L_0x00cc:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor((Class[]) null).newInstance((Object[]) null);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals((Object) null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, LogCatFileRepository.MAX_LOG_FILE_SIZE_BYTE) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            valueOf.getClass();
            if (z && resolveContentProvider != null && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
        }
        return null;
    }

    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, (zzp) null);
        }
    }
}
