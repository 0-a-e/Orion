package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridIntervalContent.kt */
final class LazyGridIntervalContent$item$3 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ Object $contentType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridIntervalContent$item$3(Object obj) {
        super(1);
        this.$contentType = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Object invoke(int i) {
        return this.$contentType;
    }
}
