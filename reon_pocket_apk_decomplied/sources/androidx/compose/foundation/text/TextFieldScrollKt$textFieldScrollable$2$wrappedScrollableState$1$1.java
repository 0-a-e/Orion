package androidx.compose.foundation.text;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0001JA\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\u0013\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018HA¢\u0006\u0002\u0010\u0019R\u001b\u0010\u0002\u001a\u00020\u00038VX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\b\u001a\u00020\u00038VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\u000b\u001a\u00020\u0003X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u001a"}, d2 = {"androidx/compose/foundation/text/TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1", "Landroidx/compose/foundation/gestures/ScrollableState;", "canScrollBackward", "", "getCanScrollBackward", "()Z", "canScrollBackward$delegate", "Landroidx/compose/runtime/State;", "canScrollForward", "getCanScrollForward", "canScrollForward$delegate", "isScrollInProgress", "dispatchRawDelta", "", "delta", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
public final class TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 implements ScrollableState {
    private final /* synthetic */ ScrollableState $$delegate_0;
    private final State canScrollBackward$delegate;
    private final State canScrollForward$delegate;

    public float dispatchRawDelta(float f) {
        return this.$$delegate_0.dispatchRawDelta(f);
    }

    public boolean isScrollInProgress() {
        return this.$$delegate_0.isScrollInProgress();
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.scroll(mutatePriority, function2, continuation);
    }

    TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1(ScrollableState scrollableState, TextFieldScrollerPosition textFieldScrollerPosition) {
        this.$$delegate_0 = scrollableState;
        this.canScrollForward$delegate = SnapshotStateKt.derivedStateOf(new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollForward$2(textFieldScrollerPosition));
        this.canScrollBackward$delegate = SnapshotStateKt.derivedStateOf(new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollBackward$2(textFieldScrollerPosition));
    }

    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }
}
