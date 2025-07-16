package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH@¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "Landroidx/compose/foundation/relocation/BringIntoViewChildNode;", "requester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;)V", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeRequester", "onAttach", "onDetach", "updateRequester", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewRequester.kt */
public final class BringIntoViewRequesterNode extends BringIntoViewChildNode {
    public static final int $stable = 8;
    private BringIntoViewRequester requester;

    public BringIntoViewRequesterNode(BringIntoViewRequester bringIntoViewRequester) {
        this.requester = bringIntoViewRequester;
    }

    public void onAttach() {
        updateRequester(this.requester);
    }

    public final void updateRequester(BringIntoViewRequester bringIntoViewRequester) {
        disposeRequester();
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).getModifiers().add(this);
        }
        this.requester = bringIntoViewRequester;
    }

    private final void disposeRequester() {
        BringIntoViewRequester bringIntoViewRequester = this.requester;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            Intrinsics.checkNotNull(bringIntoViewRequester, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).getModifiers().remove(this);
        }
    }

    public void onDetach() {
        disposeRequester();
    }

    public final Object bringIntoView(Rect rect, Continuation<? super Unit> continuation) {
        BringIntoViewParent parent = getParent();
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return Unit.INSTANCE;
        }
        Object bringChildIntoView = parent.bringChildIntoView(layoutCoordinates, new BringIntoViewRequesterNode$bringIntoView$2(rect, this), continuation);
        return bringChildIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringChildIntoView : Unit.INSTANCE;
    }
}
