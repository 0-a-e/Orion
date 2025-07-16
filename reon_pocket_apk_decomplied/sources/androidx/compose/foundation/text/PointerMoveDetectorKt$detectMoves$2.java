package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", f = "PointerMoveDetector.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PointerMoveDetector.kt */
final class PointerMoveDetectorKt$detectMoves$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onMove;
    final /* synthetic */ PointerEventPass $pointerEventPass;
    final /* synthetic */ PointerInputScope $this_detectMoves;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerMoveDetectorKt$detectMoves$2(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super PointerMoveDetectorKt$detectMoves$2> continuation) {
        super(2, continuation);
        this.$this_detectMoves = pointerInputScope;
        this.$pointerEventPass = pointerEventPass;
        this.$onMove = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PointerMoveDetectorKt$detectMoves$2(this.$this_detectMoves, this.$pointerEventPass, this.$onMove, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PointerMoveDetectorKt$detectMoves$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineContext context = getContext();
            PointerInputScope pointerInputScope = this.$this_detectMoves;
            final PointerEventPass pointerEventPass = this.$pointerEventPass;
            final Function1<Offset, Unit> function1 = this.$onMove;
            this.label = 1;
            if (pointerInputScope.awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", f = "PointerMoveDetector.kt", i = {0, 0}, l = {44}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "previousPosition"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1  reason: invalid class name */
    /* compiled from: PointerMoveDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(context, pointerEventPass, function1, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                java.lang.Object r1 = r7.L$1
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r3 = r7.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0046
            L_0x0017:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001f:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                r3 = r8
            L_0x002c:
                kotlin.coroutines.CoroutineContext r8 = r8
                boolean r8 = kotlinx.coroutines.JobKt.isActive(r8)
                if (r8 == 0) goto L_0x00aa
                androidx.compose.ui.input.pointer.PointerEventPass r8 = r4
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r7.L$0 = r3
                r7.L$1 = r1
                r7.label = r2
                java.lang.Object r8 = r3.awaitPointerEvent(r8, r4)
                if (r8 != r0) goto L_0x0046
                return r0
            L_0x0046:
                androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
                int r4 = r8.m5054getType7fucELk()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r5 = r5.m5067getMove7fucELk()
                boolean r5 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r4, r5)
                if (r5 == 0) goto L_0x005a
                r5 = r2
                goto L_0x0064
            L_0x005a:
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r5 = r5.m5065getEnter7fucELk()
                boolean r5 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r4, r5)
            L_0x0064:
                if (r5 == 0) goto L_0x0068
                r4 = r2
                goto L_0x0072
            L_0x0068:
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r5 = r5.m5066getExit7fucELk()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r4, r5)
            L_0x0072:
                if (r4 == 0) goto L_0x002c
                java.util.List r8 = r8.getChanges()
                java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                long r4 = r8.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m3551boximpl(r4)
                long r4 = r8.m3572unboximpl()
                T r6 = r1.element
                boolean r4 = androidx.compose.ui.geometry.Offset.m3558equalsimpl(r4, r6)
                if (r4 != 0) goto L_0x0093
                goto L_0x0094
            L_0x0093:
                r8 = 0
            L_0x0094:
                if (r8 == 0) goto L_0x002c
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r5
                long r5 = r8.m3572unboximpl()
                androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m3551boximpl(r5)
                r1.element = r8
                androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m3551boximpl(r5)
                r4.invoke(r8)
                goto L_0x002c
            L_0x00aa:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
