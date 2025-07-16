package androidx.compose.ui.platform;

import android.os.Looper;
import android.view.Choreographer;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidUiDispatcher.android.kt */
final class AndroidUiDispatcher$Companion$Main$2 extends Lambda implements Function0<CoroutineContext> {
    public static final AndroidUiDispatcher$Companion$Main$2 INSTANCE = new AndroidUiDispatcher$Companion$Main$2();

    AndroidUiDispatcher$Companion$Main$2() {
        super(0);
    }

    public final CoroutineContext invoke() {
        Choreographer choreographer;
        if (AndroidUiDispatcher_androidKt.isMainThread()) {
            choreographer = Choreographer.getInstance();
        } else {
            choreographer = (Choreographer) BuildersKt.runBlocking(Dispatchers.getMain(), new AndroidUiDispatcher$Companion$Main$2$dispatcher$1((Continuation<? super AndroidUiDispatcher$Companion$Main$2$dispatcher$1>) null));
        }
        AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, HandlerCompat.createAsync(Looper.getMainLooper()), (DefaultConstructorMarker) null);
        return androidUiDispatcher.plus(androidUiDispatcher.getFrameClock());
    }
}
