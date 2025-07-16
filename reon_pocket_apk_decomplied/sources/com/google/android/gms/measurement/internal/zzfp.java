package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzfp<V> extends FutureTask<V> implements Comparable<zzfp<V>> {
    final boolean zza;
    final /* synthetic */ zzfr zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfp(zzfr zzfr, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zzb = zzfr;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfr.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfr.zzs.zzau().zzb().zza("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfp zzfp = (zzfp) obj;
        boolean z = this.zza;
        if (z != zzfp.zza) {
            return !z ? 1 : -1;
        }
        int i = (this.zzc > zzfp.zzc ? 1 : (this.zzc == zzfp.zzc ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        this.zzb.zzs.zzau().zzc().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzs.zzau().zzb().zzb(this.zzd, th);
        if ((th instanceof zzfn) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfp(zzfr zzfr, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzb = zzfr;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzfr.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfr.zzs.zzau().zzb().zza("Tasks index overflow");
        }
    }
}
