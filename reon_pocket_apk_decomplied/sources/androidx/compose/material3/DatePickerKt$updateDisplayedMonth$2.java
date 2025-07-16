package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$updateDisplayedMonth$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ LazyListState $lazyListState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$updateDisplayedMonth$2(LazyListState lazyListState) {
        super(0);
        this.$lazyListState = lazyListState;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.$lazyListState.getFirstVisibleItemIndex());
    }
}
