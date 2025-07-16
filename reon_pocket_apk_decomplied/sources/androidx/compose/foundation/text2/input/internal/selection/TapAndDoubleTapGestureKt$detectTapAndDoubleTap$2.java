package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2", f = "TapAndDoubleTapGesture.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TapAndDoubleTapGesture.kt */
final class TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TapOnPosition $onDoubleTap;
    final /* synthetic */ TapOnPosition $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapAndDoubleTap;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Continuation<? super TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2> continuation) {
        super(2, continuation);
        this.$this_detectTapAndDoubleTap = pointerInputScope;
        this.$onTap = tapOnPosition;
        this.$onDoubleTap = tapOnPosition2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2(this.$this_detectTapAndDoubleTap, this.$onTap, this.$onDoubleTap, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1", f = "TapAndDoubleTapGesture.kt", i = {0, 1, 1, 2, 2, 3, 3, 4}, l = {44, 50, 54, 64, 69, 77}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0"})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1  reason: invalid class name */
    /* compiled from: TapAndDoubleTapGesture.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(tapOnPosition, tapOnPosition2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
            ((androidx.compose.ui.input.pointer.PointerInputChange) r11).consume();
            r3 = r1.getViewConfiguration().getLongPressTimeoutMillis();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r10.L$0 = r1;
            r10.J$0 = r3;
            r10.label = 2;
            r11 = r1.withTimeout(r3, new androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2.AnonymousClass1.AnonymousClass1((kotlin.coroutines.Continuation<? super androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2.AnonymousClass1.AnonymousClass1>) null), r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
            if (r11 != r0) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0089, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x008a, code lost:
            r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
            r11 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x009f, code lost:
            if (r11 == null) goto L_0x00ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
            r11.consume();
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a6, code lost:
            if (r5 == null) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
            r5.m1435onEventk4lQ0M(r11.m5113getPositionF1C5BW0());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b1, code lost:
            if (r4 == null) goto L_0x00ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b3, code lost:
            r10.L$0 = r1;
            r10.J$0 = r3;
            r10.label = 4;
            r11 = androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.access$awaitSecondDown(r1, r11, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c1, code lost:
            if (r11 != r0) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c3, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c6, code lost:
            if (((androidx.compose.ui.input.pointer.PointerInputChange) r11) == null) goto L_0x00ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r5 = r4;
            r10.L$0 = r1;
            r10.label = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dd, code lost:
            if (r1.withTimeout(r3, new androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2.AnonymousClass1.AnonymousClass2((kotlin.coroutines.Continuation<? super androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2.AnonymousClass1.AnonymousClass2>) null), r10) != r0) goto L_0x00ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00df, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f1, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x0047;
                    case 1: goto L_0x003f;
                    case 2: goto L_0x0035;
                    case 3: goto L_0x002b;
                    case 4: goto L_0x0020;
                    case 5: goto L_0x0017;
                    case 6: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0012:
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x00ef
            L_0x0017:
                java.lang.Object r1 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                goto L_0x00ef
            L_0x0020:
                long r3 = r10.J$0
                java.lang.Object r1 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x00c4
            L_0x002b:
                long r3 = r10.J$0
                java.lang.Object r1 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x009e
            L_0x0035:
                long r3 = r10.J$0
                java.lang.Object r1 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                goto L_0x008a
            L_0x003f:
                java.lang.Object r1 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x0065
            L_0x0047:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
                r6 = r10
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r10.L$0 = r11
                r1 = 1
                r10.label = r1
                r4 = 0
                r5 = 0
                r7 = 3
                r8 = 0
                r3 = r11
                java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r3, r4, r5, r6, r7, r8)
                if (r1 != r0) goto L_0x0062
                return r0
            L_0x0062:
                r9 = r1
                r1 = r11
                r11 = r9
            L_0x0065:
                androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                r11.consume()
                androidx.compose.ui.platform.ViewConfiguration r11 = r1.getViewConfiguration()
                long r3 = r11.getLongPressTimeoutMillis()
                androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$1 r11 = new androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$1     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                r11.<init>(r2)     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                r5 = r10
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                r10.L$0 = r1     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                r10.J$0 = r3     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                r6 = 2
                r10.label = r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                java.lang.Object r11 = r1.withTimeout(r3, r11, r5)     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                if (r11 != r0) goto L_0x008a
                return r0
            L_0x008a:
                androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x008d }
                goto L_0x009f
            L_0x008d:
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                r10.L$0 = r1
                r10.J$0 = r3
                r5 = 3
                r10.label = r5
                java.lang.Object r11 = androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.consumeUntilUp(r1, r11)
                if (r11 != r0) goto L_0x009e
                return r0
            L_0x009e:
                r11 = r2
            L_0x009f:
                if (r11 == 0) goto L_0x00ef
                r11.consume()
                androidx.compose.foundation.text2.input.internal.selection.TapOnPosition r5 = r3
                if (r5 == 0) goto L_0x00af
                long r6 = r11.m5113getPositionF1C5BW0()
                r5.m1435onEventk4lQ0M(r6)
            L_0x00af:
                androidx.compose.foundation.text2.input.internal.selection.TapOnPosition r5 = r4
                if (r5 == 0) goto L_0x00ef
                r5 = r10
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r10.L$0 = r1
                r10.J$0 = r3
                r6 = 4
                r10.label = r6
                java.lang.Object r11 = androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.awaitSecondDown(r1, r11, r5)
                if (r11 != r0) goto L_0x00c4
                return r0
            L_0x00c4:
                androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                if (r11 == 0) goto L_0x00ef
                androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$2 r11 = new androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$2     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                androidx.compose.foundation.text2.input.internal.selection.TapOnPosition r5 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                r11.<init>(r5, r2)     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                r5 = r10
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                r10.L$0 = r1     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                r6 = 5
                r10.label = r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                java.lang.Object r11 = r1.withTimeout(r3, r11, r5)     // Catch:{ PointerEventTimeoutCancellationException -> 0x00e0 }
                if (r11 != r0) goto L_0x00ef
                return r0
            L_0x00e0:
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                r10.L$0 = r2
                r2 = 6
                r10.label = r2
                java.lang.Object r11 = androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.consumeUntilUp(r1, r11)
                if (r11 != r0) goto L_0x00ef
                return r0
            L_0x00ef:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = this.$this_detectTapAndDoubleTap;
            final TapOnPosition tapOnPosition = this.$onTap;
            final TapOnPosition tapOnPosition2 = this.$onDoubleTap;
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
