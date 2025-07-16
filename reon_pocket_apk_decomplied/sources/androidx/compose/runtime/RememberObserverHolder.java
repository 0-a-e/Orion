package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/RememberObserverHolder;", "", "wrapped", "Landroidx/compose/runtime/RememberObserver;", "(Landroidx/compose/runtime/RememberObserver;)V", "getWrapped", "()Landroidx/compose/runtime/RememberObserver;", "setWrapped", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class RememberObserverHolder {
    public static final int $stable = 8;
    private RememberObserver wrapped;

    public RememberObserverHolder(RememberObserver rememberObserver) {
        this.wrapped = rememberObserver;
    }

    public final RememberObserver getWrapped() {
        return this.wrapped;
    }

    public final void setWrapped(RememberObserver rememberObserver) {
        this.wrapped = rememberObserver;
    }
}
