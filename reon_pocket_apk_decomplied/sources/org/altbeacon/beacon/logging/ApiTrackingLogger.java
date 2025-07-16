package org.altbeacon.beacon.logging;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.MissingFormatArgumentException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ9\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011JC\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J9\u0010\u0015\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011JC\u0010\u0015\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J/\u0010\u0016\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0004¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0002\u0010\u0019J9\u0010\u001a\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011JC\u0010\u001a\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J9\u0010\u001c\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011JC\u0010\u001c\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J9\u0010\u001d\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011JC\u0010\u001d\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lorg/altbeacon/beacon/logging/ApiTrackingLogger;", "Lorg/altbeacon/beacon/logging/Logger;", "()V", "apiCalls", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "dateformat", "Ljava/text/SimpleDateFormat;", "clearApiCalls", "", "d", "tag", "message", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "t", "", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "formatString", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "getApiCalls", "()[Ljava/lang/String;", "i", "trackApiLogs", "v", "w", "android-beacon-library_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ApiTrackingLogger.kt */
public final class ApiTrackingLogger implements Logger {
    private ArrayList<String> apiCalls = new ArrayList<>();
    private final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /* access modifiers changed from: protected */
    public final String formatString(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        try {
            if (objArr.length != 0) {
                if (str != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                    String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    return format;
                }
            }
            Intrinsics.checkNotNull(str);
            return str;
        } catch (MissingFormatArgumentException unused) {
            Intrinsics.checkNotNull(str);
            return str;
        }
    }

    public void v(String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.v(str, new VerboseAndroidLogger().formatString(str2, Arrays.copyOf(objArr, objArr.length)));
    }

    public void v(Throwable th, String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.v(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)), th);
    }

    public void d(String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.d(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)));
    }

    public void d(Throwable th, String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.d(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)), th);
    }

    public void i(String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.i(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)));
    }

    public void i(Throwable th, String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.i(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)), th);
    }

    public void w(String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.w(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)));
    }

    public void w(Throwable th, String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.w(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)), th);
    }

    public void e(String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.e(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)));
    }

    public void e(Throwable th, String str, String str2, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        trackApiLogs(str2);
        Log.e(str, formatString(str2, Arrays.copyOf(objArr, objArr.length)), th);
    }

    private final void trackApiLogs(String str) {
        if (str != null && StringsKt.indexOf$default((CharSequence) str, "API", 0, false, 6, (Object) null) == 0) {
            this.apiCalls.add(this.dateformat.format(new Date()) + " " + str);
        }
    }

    public final String[] getApiCalls() {
        Object[] array = this.apiCalls.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void clearApiCalls() {
        this.apiCalls.clear();
    }
}
