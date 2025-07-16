package androidx.compose.runtime;

import android.os.Looper;
import android.util.Log;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0019H\u0000\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\rH\u0000\u001a/\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001d\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0012\u001a\u0002H\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H\u0000¢\u0006\u0002\u0010!\u001a\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0000\"!\u0010\u0000\u001a\u00020\u00018FX\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f*\f\b\u0000\u0010'\"\u00020(2\u00020(¨\u0006)"}, d2 = {"DefaultMonotonicFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getDefaultMonotonicFrameClock$annotations", "()V", "getDefaultMonotonicFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "DefaultMonotonicFrameClock$delegate", "Lkotlin/Lazy;", "DisallowDefaultMonotonicFrameClock", "", "LogTag", "", "MainThreadId", "", "getMainThreadId", "()J", "createSnapshotMutableDoubleState", "Landroidx/compose/runtime/MutableDoubleState;", "value", "", "createSnapshotMutableFloatState", "Landroidx/compose/runtime/MutableFloatState;", "", "createSnapshotMutableIntState", "Landroidx/compose/runtime/MutableIntState;", "", "createSnapshotMutableLongState", "Landroidx/compose/runtime/MutableLongState;", "createSnapshotMutableState", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "T", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "logError", "", "message", "e", "", "CheckResult", "Landroidx/annotation/CheckResult;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActualAndroid.android.kt */
public final class ActualAndroid_androidKt {
    private static final Lazy DefaultMonotonicFrameClock$delegate = LazyKt.lazy(ActualAndroid_androidKt$DefaultMonotonicFrameClock$2.INSTANCE);
    private static final boolean DisallowDefaultMonotonicFrameClock = false;
    private static final String LogTag = "ComposeInternal";
    private static final long MainThreadId;

    @Deprecated(message = "MonotonicFrameClocks are not globally applicable across platforms. Use an appropriate local clock.")
    public static /* synthetic */ void getDefaultMonotonicFrameClock$annotations() {
    }

    static {
        long j;
        try {
            j = Looper.getMainLooper().getThread().getId();
        } catch (Exception unused) {
            j = -1;
        }
        MainThreadId = j;
    }

    public static final MonotonicFrameClock getDefaultMonotonicFrameClock() {
        return (MonotonicFrameClock) DefaultMonotonicFrameClock$delegate.getValue();
    }

    public static final <T> SnapshotMutableState<T> createSnapshotMutableState(T t, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return new ParcelableSnapshotMutableState<>(t, snapshotMutationPolicy);
    }

    public static final MutableIntState createSnapshotMutableIntState(int i) {
        return new ParcelableSnapshotMutableIntState(i);
    }

    public static final MutableLongState createSnapshotMutableLongState(long j) {
        return new ParcelableSnapshotMutableLongState(j);
    }

    public static final MutableFloatState createSnapshotMutableFloatState(float f) {
        return new ParcelableSnapshotMutableFloatState(f);
    }

    public static final MutableDoubleState createSnapshotMutableDoubleState(double d) {
        return new ParcelableSnapshotMutableDoubleState(d);
    }

    public static final void logError(String str, Throwable th) {
        Log.e(LogTag, str, th);
    }

    public static final long getMainThreadId() {
        return MainThreadId;
    }
}
