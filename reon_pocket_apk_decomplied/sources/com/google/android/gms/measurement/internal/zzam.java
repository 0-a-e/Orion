package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Handler;
import androidx.compose.material3.CalendarModelKt;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.AccountType;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
public final class zzam extends zzgo {
    private long zza;
    private String zzb;
    private AccountManager zzc;
    private Boolean zzd;
    private long zze;

    zzam(zzfu zzfu) {
        super(zzfu);
    }

    /* access modifiers changed from: protected */
    public final boolean zza() {
        Calendar instance = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.zzb = sb.toString();
        return false;
    }

    public final long zzb() {
        zzv();
        return this.zza;
    }

    public final String zzc() {
        zzv();
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final long zzd() {
        zzg();
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        zzg();
        this.zzd = null;
        this.zze = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        zzg();
        long currentTimeMillis = this.zzs.zzay().currentTimeMillis();
        if (currentTimeMillis - this.zze > CalendarModelKt.MillisecondsIn24Hours) {
            this.zzd = null;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(this.zzs.zzax(), "android.permission.GET_ACCOUNTS") != 0) {
            this.zzs.zzau().zzf().zza("Permission error checking for dasher/unicorn accounts");
            this.zze = currentTimeMillis;
            this.zzd = false;
            return false;
        }
        if (this.zzc == null) {
            this.zzc = AccountManager.get(this.zzs.zzax());
        }
        try {
            Account[] result = this.zzc.getAccountsByTypeAndFeatures(AccountType.GOOGLE, new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.zzc.getAccountsByTypeAndFeatures(AccountType.GOOGLE, new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.zzd = true;
                    this.zze = currentTimeMillis;
                    return true;
                }
                this.zze = currentTimeMillis;
                this.zzd = false;
                return false;
            }
            this.zzd = true;
            this.zze = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            this.zzs.zzau().zzc().zzb("Exception checking account types", e);
        }
    }
}
