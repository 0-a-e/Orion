package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H@¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;", "Landroidx/compose/foundation/relocation/BringIntoViewChildNode;", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "(Landroidx/compose/foundation/relocation/BringIntoViewResponder;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "getResponder", "()Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "setResponder", "bringChildIntoView", "", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewResponder.kt */
public final class BringIntoViewResponderNode extends BringIntoViewChildNode implements BringIntoViewParent {
    public static final int $stable = 8;
    private final ModifierLocalMap providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(BringIntoViewKt.getModifierLocalBringIntoViewParent(), this));
    private BringIntoViewResponder responder;

    public final BringIntoViewResponder getResponder() {
        return this.responder;
    }

    public final void setResponder(BringIntoViewResponder bringIntoViewResponder) {
        this.responder = bringIntoViewResponder;
    }

    public BringIntoViewResponderNode(BringIntoViewResponder bringIntoViewResponder) {
        this.responder = bringIntoViewResponder;
    }

    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    /* access modifiers changed from: private */
    public static final Rect bringChildIntoView$localRect(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0<Rect> function0) {
        Rect invoke;
        LayoutCoordinates layoutCoordinates2 = bringIntoViewResponderNode.getLayoutCoordinates();
        if (layoutCoordinates2 == null) {
            return null;
        }
        if (!layoutCoordinates.isAttached()) {
            layoutCoordinates = null;
        }
        if (layoutCoordinates == null || (invoke = function0.invoke()) == null) {
            return null;
        }
        return BringIntoViewResponderKt.localRectOf(layoutCoordinates2, layoutCoordinates, invoke);
    }

    public Object bringChildIntoView(LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new BringIntoViewResponderNode$bringChildIntoView$2(this, layoutCoordinates, function0, new BringIntoViewResponderNode$bringChildIntoView$parentRect$1(this, layoutCoordinates, function0), (Continuation<? super BringIntoViewResponderNode$bringChildIntoView$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }
}
