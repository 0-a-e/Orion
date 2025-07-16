package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: LazyDsl.kt */
public final class LazyDslKt$items$6 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ T[] $items;
    final /* synthetic */ Function1<T, Object> $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyDslKt$items$6(Function1<? super T, ? extends Object> function1, T[] tArr) {
        super(1);
        this.$key = function1;
        this.$items = tArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Object invoke(int i) {
        return this.$key.invoke(this.$items[i]);
    }
}
