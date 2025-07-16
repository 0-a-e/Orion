package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "Landroidx/compose/ui/unit/Velocity;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.Draggable2DKt$draggable2D$2", f = "Draggable2D.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Draggable2D.kt */
final class Draggable2DKt$draggable2D$2 extends SuspendLambda implements Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> {
    int label;

    Draggable2DKt$draggable2D$2(Continuation<? super Draggable2DKt$draggable2D$2> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m390invokeLuvzFrg((CoroutineScope) obj, ((Velocity) obj2).m6864unboximpl(), (Continuation) obj3);
    }

    /* renamed from: invoke-LuvzFrg  reason: not valid java name */
    public final Object m390invokeLuvzFrg(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation) {
        return new Draggable2DKt$draggable2D$2(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
