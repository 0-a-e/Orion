package androidx.compose.ui.platform;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000\u001a*\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\b¢\u0006\u0002\u0010\n\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0003H\u0000*\f\b\u0000\u0010\f\"\u00020\r2\u00020\r¨\u0006\u000e"}, d2 = {"simpleIdentityToString", "", "obj", "", "name", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "nativeClass", "AtomicInt", "Ljava/util/concurrent/atomic/AtomicInteger;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: JvmActuals.jvm.kt */
public final class JvmActuals_jvmKt {
    public static final String simpleIdentityToString(Object obj, String str) {
        if (str == null) {
            if (obj.getClass().isAnonymousClass()) {
                str = obj.getClass().getName();
            } else {
                str = obj.getClass().getSimpleName();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('@');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb.append(format);
        return sb.toString();
    }

    public static final Object nativeClass(Object obj) {
        return obj.getClass();
    }

    /* renamed from: synchronized  reason: not valid java name */
    public static final <R> R m5788synchronized(Object obj, Function0<? extends R> function0) {
        R invoke;
        synchronized (obj) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }
}
