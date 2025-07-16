package androidx.compose.foundation.pager;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
final class PagerKt$pagerSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ PagerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerKt$pagerSemantics$1(boolean z, PagerState pagerState, CoroutineScope coroutineScope) {
        super(1);
        this.$isVertical = z;
        this.$state = pagerState;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.$isVertical) {
            final PagerState pagerState = this.$state;
            final CoroutineScope coroutineScope = this.$scope;
            SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
                public final Boolean invoke() {
                    return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState, coroutineScope));
                }
            }, 1, (Object) null);
            final PagerState pagerState2 = this.$state;
            final CoroutineScope coroutineScope2 = this.$scope;
            SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
                public final Boolean invoke() {
                    return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState2, coroutineScope2));
                }
            }, 1, (Object) null);
            return;
        }
        final PagerState pagerState3 = this.$state;
        final CoroutineScope coroutineScope3 = this.$scope;
        SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState3, coroutineScope3));
            }
        }, 1, (Object) null);
        final PagerState pagerState4 = this.$state;
        final CoroutineScope coroutineScope4 = this.$scope;
        SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState4, coroutineScope4));
            }
        }, 1, (Object) null);
    }
}
