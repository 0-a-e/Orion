package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "", "canScrollForward", "", "getCanScrollForward", "()Z", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "animateScrollBy", "", "delta", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "pseudoMaxScrollOffset", "pseudoScrollOffset", "scrollToItem", "index", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
public interface LazyLayoutSemanticState {
    Object animateScrollBy(float f, Continuation<? super Unit> continuation);

    CollectionInfo collectionInfo();

    boolean getCanScrollForward();

    int getFirstVisibleItemIndex();

    int getFirstVisibleItemScrollOffset();

    float pseudoMaxScrollOffset();

    float pseudoScrollOffset();

    Object scrollToItem(int i, Continuation<? super Unit> continuation);

    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState$-CC  reason: invalid class name */
    /* compiled from: LazyLayoutSemantics.kt */
    public final /* synthetic */ class CC {
        public static float $default$pseudoScrollOffset(LazyLayoutSemanticState _this) {
            return (float) (_this.getFirstVisibleItemScrollOffset() + (_this.getFirstVisibleItemIndex() * 500));
        }

        public static float $default$pseudoMaxScrollOffset(LazyLayoutSemanticState _this) {
            if (_this.getCanScrollForward()) {
                return _this.pseudoScrollOffset() + ((float) 100);
            }
            return _this.pseudoScrollOffset();
        }
    }
}
