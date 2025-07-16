package androidx.compose.ui.platform;

import android.os.Looper;
import android.view.Choreographer;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"androidx/compose/ui/platform/AndroidUiDispatcher$Companion$currentThread$1", "Ljava/lang/ThreadLocal;", "Lkotlin/coroutines/CoroutineContext;", "initialValue", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidUiDispatcher.android.kt */
public final class AndroidUiDispatcher$Companion$currentThread$1 extends ThreadLocal<CoroutineContext> {
    AndroidUiDispatcher$Companion$currentThread$1() {
    }

    /* access modifiers changed from: protected */
    public CoroutineContext initialValue() {
        Choreographer instance = Choreographer.getInstance();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(instance, HandlerCompat.createAsync(myLooper), (DefaultConstructorMarker) null);
            return androidUiDispatcher.plus(androidUiDispatcher.getFrameClock());
        }
        throw new IllegalStateException("no Looper on this thread".toString());
    }
}
