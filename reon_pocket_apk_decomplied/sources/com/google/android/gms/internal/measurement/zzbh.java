package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzbh extends zzaw {
    protected zzbh() {
        this.zza.add(zzbl.FOR_IN);
        this.zza.add(zzbl.FOR_IN_CONST);
        this.zza.add(zzbl.FOR_IN_LET);
        this.zza.add(zzbl.FOR_LET);
        this.zza.add(zzbl.FOR_OF);
        this.zza.add(zzbl.FOR_OF_CONST);
        this.zza.add(zzbl.FOR_OF_LET);
        this.zza.add(zzbl.WHILE);
    }

    private static zzap zzc(zzbf zzbf, zzap zzap, zzap zzap2) {
        return zze(zzbf, zzap.zzf(), zzap2);
    }

    private static zzap zzd(zzbf zzbf, zzap zzap, zzap zzap2) {
        if (zzap instanceof Iterable) {
            return zze(zzbf, ((Iterable) zzap).iterator(), zzap2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    private static zzap zze(zzbf zzbf, Iterator<zzap> it, zzap zzap) {
        if (it != null) {
            while (it.hasNext()) {
                zzap zzb = zzbf.zza(it.next()).zzb((zzae) zzap);
                if (zzb instanceof zzag) {
                    zzag zzag = (zzag) zzb;
                    if ("break".equals(zzag.zzg())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzag.zzg())) {
                        return zzag;
                    }
                }
            }
        }
        return zzap.zzf;
    }

    public final zzap zza(String str, zzg zzg, List<zzap> list) {
        zzbl zzbl = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 65) {
            switch (ordinal) {
                case 26:
                    zzh.zza(zzbl.FOR_IN.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        return zzc(new zzbg(zzg, list.get(0).zzc()), zzg.zza(list.get(1)), zzg.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                case 27:
                    zzh.zza(zzbl.FOR_IN_CONST.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        return zzc(new zzbd(zzg, list.get(0).zzc()), zzg.zza(list.get(1)), zzg.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                case 28:
                    zzh.zza(zzbl.FOR_IN_LET.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        return zzc(new zzbe(zzg, list.get(0).zzc()), zzg.zza(list.get(1)), zzg.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                    zzh.zza(zzbl.FOR_LET.name(), 4, list);
                    zzap zza = zzg.zza(list.get(0));
                    if (zza instanceof zzae) {
                        zzae zzae = (zzae) zza;
                        zzap zzap = list.get(1);
                        zzap zzap2 = list.get(2);
                        zzap zza2 = zzg.zza(list.get(3));
                        zzg zzc = zzg.zzc();
                        for (int i = 0; i < zzae.zzh(); i++) {
                            String zzc2 = zzae.zzl(i).zzc();
                            zzc.zze(zzc2, zzg.zzh(zzc2));
                        }
                        while (zzg.zza(zzap).zze().booleanValue()) {
                            zzap zzb = zzg.zzb((zzae) zza2);
                            if (zzb instanceof zzag) {
                                zzag zzag = (zzag) zzb;
                                if ("break".equals(zzag.zzg())) {
                                    return zzap.zzf;
                                }
                                if ("return".equals(zzag.zzg())) {
                                    return zzag;
                                }
                            }
                            zzg zzc3 = zzg.zzc();
                            for (int i2 = 0; i2 < zzae.zzh(); i2++) {
                                String zzc4 = zzae.zzl(i2).zzc();
                                zzc3.zze(zzc4, zzc.zzh(zzc4));
                            }
                            zzc3.zza(zzap2);
                            zzc = zzc3;
                        }
                        return zzap.zzf;
                    }
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                case 30:
                    zzh.zza(zzbl.FOR_OF.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        return zzd(new zzbg(zzg, list.get(0).zzc()), zzg.zza(list.get(1)), zzg.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                case 31:
                    zzh.zza(zzbl.FOR_OF_CONST.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        return zzd(new zzbd(zzg, list.get(0).zzc()), zzg.zza(list.get(1)), zzg.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                case 32:
                    zzh.zza(zzbl.FOR_OF_LET.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        return zzd(new zzbe(zzg, list.get(0).zzc()), zzg.zza(list.get(1)), zzg.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                default:
                    return super.zzb(str);
            }
        } else {
            zzh.zza(zzbl.WHILE.name(), 4, list);
            zzap zzap3 = list.get(0);
            zzap zzap4 = list.get(1);
            zzap zza3 = zzg.zza(list.get(3));
            if (zzg.zza(list.get(2)).zze().booleanValue()) {
                zzap zzb2 = zzg.zzb((zzae) zza3);
                if (zzb2 instanceof zzag) {
                    zzag zzag2 = (zzag) zzb2;
                    if ("break".equals(zzag2.zzg())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzag2.zzg())) {
                        return zzag2;
                    }
                }
            }
            while (zzg.zza(zzap3).zze().booleanValue()) {
                zzap zzb3 = zzg.zzb((zzae) zza3);
                if (zzb3 instanceof zzag) {
                    zzag zzag3 = (zzag) zzb3;
                    if ("break".equals(zzag3.zzg())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzag3.zzg())) {
                        return zzag3;
                    }
                }
                zzg.zza(zzap4);
            }
            return zzap.zzf;
        }
    }
}
