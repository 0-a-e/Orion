package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007H@¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"androidx/compose/foundation/lazy/grid/LazySemanticsKt$rememberLazyGridSemanticState$1$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "canScrollForward", "", "getCanScrollForward", "()Z", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "animateScrollBy", "", "delta", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "scrollToItem", "index", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySemantics.kt */
public final class LazySemanticsKt$rememberLazyGridSemanticState$1$1 implements LazyLayoutSemanticState {
    final /* synthetic */ LazyGridState $state;

    public /* synthetic */ float pseudoMaxScrollOffset() {
        return LazyLayoutSemanticState.CC.$default$pseudoMaxScrollOffset(this);
    }

    public /* synthetic */ float pseudoScrollOffset() {
        return LazyLayoutSemanticState.CC.$default$pseudoScrollOffset(this);
    }

    LazySemanticsKt$rememberLazyGridSemanticState$1$1(LazyGridState lazyGridState) {
        this.$state = lazyGridState;
    }

    public int getFirstVisibleItemScrollOffset() {
        return this.$state.getFirstVisibleItemScrollOffset();
    }

    public int getFirstVisibleItemIndex() {
        return this.$state.getFirstVisibleItemIndex();
    }

    public boolean getCanScrollForward() {
        return this.$state.getCanScrollForward();
    }

    public Object animateScrollBy(float f, Continuation<? super Unit> continuation) {
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.$state, f, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    public Object scrollToItem(int i, Continuation<? super Unit> continuation) {
        Object scrollToItem$default = LazyGridState.scrollToItem$default(this.$state, i, 0, continuation, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }

    public CollectionInfo collectionInfo() {
        return new CollectionInfo(-1, -1);
    }
}
