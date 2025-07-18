package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/ProvidedValue;", "T", "", "compositionLocal", "Landroidx/compose/runtime/CompositionLocal;", "value", "canOverride", "", "(Landroidx/compose/runtime/CompositionLocal;Ljava/lang/Object;Z)V", "getCanOverride", "()Z", "getCompositionLocal", "()Landroidx/compose/runtime/CompositionLocal;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ProvidedValue<T> {
    public static final int $stable = 0;
    private final boolean canOverride;
    private final CompositionLocal<T> compositionLocal;
    private final T value;

    public ProvidedValue(CompositionLocal<T> compositionLocal2, T t, boolean z) {
        this.compositionLocal = compositionLocal2;
        this.value = t;
        this.canOverride = z;
    }

    public final CompositionLocal<T> getCompositionLocal() {
        return this.compositionLocal;
    }

    public final T getValue() {
        return this.value;
    }

    public final boolean getCanOverride() {
        return this.canOverride;
    }
}
