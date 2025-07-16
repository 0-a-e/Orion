package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0001\u001a\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002H\u0002\u001aF\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010H@¢\u0006\u0002\u0010\u0012\u001aH\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0001\u001a0\u0010\u001e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010\u001f\u001a\u0002H\u00022\b\b\u0002\u0010 \u001a\u00020!H@¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010\u001f\u001a\u0002H\u0002H@¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"DraggableAnchors", "Landroidx/compose/material3/DraggableAnchors;", "T", "", "builder", "Lkotlin/Function1;", "Landroidx/compose/material3/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "emptyDraggableAnchors", "Landroidx/compose/material3/MapDraggableAnchors;", "restartable", "I", "inputs", "Lkotlin/Function0;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "animateTo", "targetValue", "velocity", "", "(Landroidx/compose/material3/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Landroidx/compose/material3/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public final class AnchoredDraggableKt {
    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> function1) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        function1.invoke(draggableAnchorsConfig);
        return new MapDraggableAnchors<>(draggableAnchorsConfig.getAnchors$material3_release());
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            mutableInteractionSource = null;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z3, z4, mutableInteractionSource);
    }

    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource) {
        AnchoredDraggableState<T> anchoredDraggableState2 = anchoredDraggableState;
        return DraggableKt.draggable$default(modifier, anchoredDraggableState.getDraggableState$material3_release(), orientation, z, mutableInteractionSource, anchoredDraggableState.isAnimationRunning(), (Function3) null, new AnchoredDraggableKt$anchoredDraggable$1(anchoredDraggableState, (Continuation<? super AnchoredDraggableKt$anchoredDraggable$1>) null), z2, 32, (Object) null);
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, (MutatePriority) null, new AnchoredDraggableKt$snapTo$2((Continuation<? super AnchoredDraggableKt$snapTo$2>) null), continuation, 2, (Object) null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = anchoredDraggableState.getLastVelocity();
        }
        return animateTo(anchoredDraggableState, obj, f, continuation);
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t, float f, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, (MutatePriority) null, new AnchoredDraggableKt$animateTo$2(anchoredDraggableState, f, (Continuation<? super AnchoredDraggableKt$animateTo$2>) null), continuation, 2, (Object) null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <I> java.lang.Object restartable(kotlin.jvm.functions.Function0<? extends I> r4, kotlin.jvm.functions.Function2<? super I, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.material3.AnchoredDraggableKt$restartable$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.material3.AnchoredDraggableKt$restartable$1 r0 = (androidx.compose.material3.AnchoredDraggableKt$restartable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.AnchoredDraggableKt$restartable$1 r0 = new androidx.compose.material3.AnchoredDraggableKt$restartable$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ AnchoredDragFinishedSignal -> 0x0046 }
            goto L_0x0046
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.material3.AnchoredDraggableKt$restartable$2 r6 = new androidx.compose.material3.AnchoredDraggableKt$restartable$2     // Catch:{ AnchoredDragFinishedSignal -> 0x0046 }
            r2 = 0
            r6.<init>(r4, r5, r2)     // Catch:{ AnchoredDragFinishedSignal -> 0x0046 }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ AnchoredDragFinishedSignal -> 0x0046 }
            r0.label = r3     // Catch:{ AnchoredDragFinishedSignal -> 0x0046 }
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)     // Catch:{ AnchoredDragFinishedSignal -> 0x0046 }
            if (r4 != r1) goto L_0x0046
            return r1
        L_0x0046:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AnchoredDraggableKt.restartable(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final <T> MapDraggableAnchors<T> emptyDraggableAnchors() {
        return new MapDraggableAnchors<>(MapsKt.emptyMap());
    }
}
