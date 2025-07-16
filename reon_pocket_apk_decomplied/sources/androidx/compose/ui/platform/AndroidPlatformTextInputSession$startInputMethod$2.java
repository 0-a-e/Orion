package androidx.compose.ui.platform;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/platform/InputMethodSession;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPlatformTextInputSession.android.kt */
final class AndroidPlatformTextInputSession$startInputMethod$2 extends Lambda implements Function1<CoroutineScope, InputMethodSession> {
    final /* synthetic */ PlatformTextInputMethodRequest $request;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidPlatformTextInputSession$startInputMethod$2(PlatformTextInputMethodRequest platformTextInputMethodRequest) {
        super(1);
        this.$request = platformTextInputMethodRequest;
    }

    public final InputMethodSession invoke(final CoroutineScope coroutineScope) {
        return new InputMethodSession(this.$request, new Function0<Unit>() {
            public final void invoke() {
                CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
            }
        });
    }
}
