package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/ScrollState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollKt$rememberScrollState$1$1 extends Lambda implements Function0<ScrollState> {
    final /* synthetic */ int $initial;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollKt$rememberScrollState$1$1(int i) {
        super(0);
        this.$initial = i;
    }

    public final ScrollState invoke() {
        return new ScrollState(this.$initial);
    }
}
