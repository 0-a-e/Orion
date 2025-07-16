package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListItemProvider.kt */
final class LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$intervalContentState$1 extends Lambda implements Function0<LazyListIntervalContent> {
    final /* synthetic */ State<Function1<LazyListScope, Unit>> $latestContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$intervalContentState$1(State<? extends Function1<? super LazyListScope, Unit>> state) {
        super(0);
        this.$latestContent = state;
    }

    public final LazyListIntervalContent invoke() {
        return new LazyListIntervalContent(this.$latestContent.getValue());
    }
}
