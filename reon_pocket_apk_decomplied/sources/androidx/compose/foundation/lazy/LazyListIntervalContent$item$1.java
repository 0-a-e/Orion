package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListIntervalContent.kt */
final class LazyListIntervalContent$item$1 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ Object $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListIntervalContent$item$1(Object obj) {
        super(1);
        this.$key = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Object invoke(int i) {
        return this.$key;
    }
}
