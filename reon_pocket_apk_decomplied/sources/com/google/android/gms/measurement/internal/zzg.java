package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzg {
    private long zzA;
    private long zzB;
    private String zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private final zzfu zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private long zzp;
    private boolean zzq;
    private String zzr;
    private Boolean zzs;
    private long zzt;
    private List<String> zzu;
    private String zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    zzg(zzfu zzfu, String str) {
        Preconditions.checkNotNull(zzfu);
        Preconditions.checkNotEmpty(str);
        this.zza = zzfu;
        this.zzb = str;
        zzfu.zzav().zzg();
    }

    public final void zzA(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzm != j;
        this.zzm = j;
    }

    public final long zzB() {
        this.zza.zzav().zzg();
        return this.zzn;
    }

    public final void zzC(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzn != j;
        this.zzn = j;
    }

    public final long zzD() {
        this.zza.zzav().zzg();
        return this.zzt;
    }

    public final void zzE(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzt != j;
        this.zzt = j;
    }

    public final boolean zzF() {
        this.zza.zzav().zzg();
        return this.zzo;
    }

    public final void zzG(boolean z) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzo != z;
        this.zzo = z;
    }

    public final void zzH(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zza.zzav().zzg();
        boolean z2 = this.zzD;
        if (this.zzg == j) {
            z = false;
        }
        this.zzD = z2 | z;
        this.zzg = j;
    }

    public final long zzI() {
        this.zza.zzav().zzg();
        return this.zzg;
    }

    public final long zzJ() {
        this.zza.zzav().zzg();
        return this.zzE;
    }

    public final void zzK(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzE != j;
        this.zzE = j;
    }

    public final long zzL() {
        this.zza.zzav().zzg();
        return this.zzF;
    }

    public final void zzM(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzF != j;
        this.zzF = j;
    }

    public final void zzN() {
        this.zza.zzav().zzg();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            this.zza.zzau().zze().zzb("Bundle index overflow. appId", zzem.zzl(this.zzb));
            j = 0;
        }
        this.zzD = true;
        this.zzg = j;
    }

    public final long zzO() {
        this.zza.zzav().zzg();
        return this.zzw;
    }

    public final void zzP(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzw != j;
        this.zzw = j;
    }

    public final long zzQ() {
        this.zza.zzav().zzg();
        return this.zzx;
    }

    public final void zzR(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzx != j;
        this.zzx = j;
    }

    public final long zzS() {
        this.zza.zzav().zzg();
        return this.zzy;
    }

    public final void zzT(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzy != j;
        this.zzy = j;
    }

    public final long zzU() {
        this.zza.zzav().zzg();
        return this.zzz;
    }

    public final void zzV(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzz != j;
        this.zzz = j;
    }

    public final long zzW() {
        this.zza.zzav().zzg();
        return this.zzB;
    }

    public final void zzX(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzB != j;
        this.zzB = j;
    }

    public final long zzY() {
        this.zza.zzav().zzg();
        return this.zzA;
    }

    public final void zzZ(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzA != j;
        this.zzA = j;
    }

    public final boolean zza() {
        this.zza.zzav().zzg();
        return this.zzD;
    }

    public final String zzaa() {
        this.zza.zzav().zzg();
        return this.zzC;
    }

    public final String zzab() {
        this.zza.zzav().zzg();
        String str = this.zzC;
        zzac((String) null);
        return str;
    }

    public final void zzac(String str) {
        this.zza.zzav().zzg();
        this.zzD |= !zzku.zzS(this.zzC, str);
        this.zzC = str;
    }

    public final long zzad() {
        this.zza.zzav().zzg();
        return this.zzp;
    }

    public final void zzae(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzp != j;
        this.zzp = j;
    }

    public final boolean zzaf() {
        this.zza.zzav().zzg();
        return this.zzq;
    }

    public final void zzag(boolean z) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzq != z;
        this.zzq = z;
    }

    public final Boolean zzah() {
        this.zza.zzav().zzg();
        return this.zzs;
    }

    public final void zzai(Boolean bool) {
        this.zza.zzav().zzg();
        boolean z = this.zzD;
        Boolean bool2 = this.zzs;
        int i = zzku.zza;
        this.zzD = z | (!((bool2 == null && bool == null) ? true : bool2 == null ? false : bool2.equals(bool)));
        this.zzs = bool;
    }

    public final List<String> zzaj() {
        this.zza.zzav().zzg();
        return this.zzu;
    }

    public final void zzak(List<String> list) {
        this.zza.zzav().zzg();
        List<String> list2 = this.zzu;
        int i = zzku.zza;
        if (list2 != null || list != null) {
            if (list2 == null || !list2.equals(list)) {
                this.zzD = true;
                this.zzu = list != null ? new ArrayList(list) : null;
            }
        }
    }

    public final void zzb() {
        this.zza.zzav().zzg();
        this.zzD = false;
    }

    public final String zzc() {
        this.zza.zzav().zzg();
        return this.zzb;
    }

    public final String zzd() {
        this.zza.zzav().zzg();
        return this.zzc;
    }

    public final void zze(String str) {
        this.zza.zzav().zzg();
        this.zzD |= !zzku.zzS(this.zzc, str);
        this.zzc = str;
    }

    public final String zzf() {
        this.zza.zzav().zzg();
        return this.zzd;
    }

    public final void zzg(String str) {
        this.zza.zzav().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzD |= true ^ zzku.zzS(this.zzd, str);
        this.zzd = str;
    }

    public final String zzh() {
        this.zza.zzav().zzg();
        return this.zzr;
    }

    public final void zzi(String str) {
        this.zza.zzav().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzD |= true ^ zzku.zzS(this.zzr, str);
        this.zzr = str;
    }

    public final String zzj() {
        this.zza.zzav().zzg();
        return this.zzv;
    }

    public final void zzk(String str) {
        this.zza.zzav().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzD |= true ^ zzku.zzS(this.zzv, str);
        this.zzv = str;
    }

    public final String zzl() {
        this.zza.zzav().zzg();
        return this.zze;
    }

    public final void zzm(String str) {
        this.zza.zzav().zzg();
        this.zzD |= !zzku.zzS(this.zze, str);
        this.zze = str;
    }

    public final String zzn() {
        this.zza.zzav().zzg();
        return this.zzf;
    }

    public final void zzo(String str) {
        this.zza.zzav().zzg();
        this.zzD |= !zzku.zzS(this.zzf, str);
        this.zzf = str;
    }

    public final long zzp() {
        this.zza.zzav().zzg();
        return this.zzh;
    }

    public final void zzq(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzh != j;
        this.zzh = j;
    }

    public final long zzr() {
        this.zza.zzav().zzg();
        return this.zzi;
    }

    public final void zzs(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzi != j;
        this.zzi = j;
    }

    public final String zzt() {
        this.zza.zzav().zzg();
        return this.zzj;
    }

    public final void zzu(String str) {
        this.zza.zzav().zzg();
        this.zzD |= !zzku.zzS(this.zzj, str);
        this.zzj = str;
    }

    public final long zzv() {
        this.zza.zzav().zzg();
        return this.zzk;
    }

    public final void zzw(long j) {
        this.zza.zzav().zzg();
        this.zzD |= this.zzk != j;
        this.zzk = j;
    }

    public final String zzx() {
        this.zza.zzav().zzg();
        return this.zzl;
    }

    public final void zzy(String str) {
        this.zza.zzav().zzg();
        this.zzD |= !zzku.zzS(this.zzl, str);
        this.zzl = str;
    }

    public final long zzz() {
        this.zza.zzav().zzg();
        return this.zzm;
    }
}
