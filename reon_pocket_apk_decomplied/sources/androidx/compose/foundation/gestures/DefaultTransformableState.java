package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BR\u0012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\u0010\fJ?\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2'\u0010\u001b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001c¢\u0006\u0002\b\u001fH@¢\u0006\u0002\u0010 R\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011X\u0004¢\u0006\u0002\n\u0000RV\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultTransformableState;", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "(Lkotlin/jvm/functions/Function3;)V", "isTransformInProgress", "", "()Z", "isTransformingState", "Landroidx/compose/runtime/MutableState;", "getOnTransformation", "()Lkotlin/jvm/functions/Function3;", "transformMutex", "Landroidx/compose/foundation/MutatorMutex;", "transformScope", "Landroidx/compose/foundation/gestures/TransformScope;", "transform", "transformPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformableState.kt */
final class DefaultTransformableState implements TransformableState {
    /* access modifiers changed from: private */
    public final MutableState<Boolean> isTransformingState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Function3<Float, Offset, Float, Unit> onTransformation;
    /* access modifiers changed from: private */
    public final MutatorMutex transformMutex = new MutatorMutex();
    /* access modifiers changed from: private */
    public final TransformScope transformScope = new DefaultTransformableState$transformScope$1(this);

    public DefaultTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        this.onTransformation = function3;
    }

    public final Function3<Float, Offset, Float, Unit> getOnTransformation() {
        return this.onTransformation;
    }

    public Object transform(MutatePriority mutatePriority, Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new DefaultTransformableState$transform$2(this, mutatePriority, function2, (Continuation<? super DefaultTransformableState$transform$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public boolean isTransformInProgress() {
        return this.isTransformingState.getValue().booleanValue();
    }
}
