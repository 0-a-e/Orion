package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/CompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "provides", "Landroidx/compose/runtime/ProvidedValue;", "value", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "providesDefault", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocal.kt */
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public static final int $stable = 0;

    public ProvidableCompositionLocal(Function0<? extends T> function0) {
        super(function0, (DefaultConstructorMarker) null);
    }

    public final ProvidedValue<T> provides(T t) {
        return new ProvidedValue<>(this, t, true);
    }

    public final ProvidedValue<T> providesDefault(T t) {
        return new ProvidedValue<>(this, t, false);
    }
}
