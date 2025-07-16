package androidx.compose.foundation.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Toggleable.kt */
final class ToggleableKt$toggleable$4$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onValueChange;
    final /* synthetic */ boolean $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleable$4$1(Function1<? super Boolean, Unit> function1, boolean z) {
        super(0);
        this.$onValueChange = function1;
        this.$value = z;
    }

    public final void invoke() {
        this.$onValueChange.invoke(Boolean.valueOf(!this.$value));
    }
}
