package androidx.compose.runtime;

import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/MonotonicFrameClock;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActualAndroid.android.kt */
final class ActualAndroid_androidKt$DefaultMonotonicFrameClock$2 extends Lambda implements Function0<MonotonicFrameClock> {
    public static final ActualAndroid_androidKt$DefaultMonotonicFrameClock$2 INSTANCE = new ActualAndroid_androidKt$DefaultMonotonicFrameClock$2();

    ActualAndroid_androidKt$DefaultMonotonicFrameClock$2() {
        super(0);
    }

    public final MonotonicFrameClock invoke() {
        if (Looper.getMainLooper() != null) {
            return DefaultChoreographerFrameClock.INSTANCE;
        }
        return SdkStubsFallbackFrameClock.INSTANCE;
    }
}
