package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u000e\b\u0001\u0010\u0003\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "", "E", "Landroidx/compose/runtime/Applier;", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: Composables.kt */
public final class ComposablesKt$ComposeNode$1 extends Lambda implements Function0<T> {
    final /* synthetic */ Function0<T> $factory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposablesKt$ComposeNode$1(Function0<? extends T> function0) {
        super(0);
        this.$factory = function0;
    }

    public final T invoke() {
        return this.$factory.invoke();
    }
}
