package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TapGestureDetector.kt */
final class TapGestureDetectorKt$detectTapAndPress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    final /* synthetic */ PressGestureScopeImpl $pressScope;
    final /* synthetic */ PointerInputScope $this_detectTapAndPress;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TapGestureDetectorKt$detectTapAndPress$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super TapGestureDetectorKt$detectTapAndPress$2> continuation) {
        super(2, continuation);
        this.$this_detectTapAndPress = pointerInputScope;
        this.$onPress = function3;
        this.$onTap = function1;
        this.$pressScope = pressGestureScopeImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$detectTapAndPress$2 tapGestureDetectorKt$detectTapAndPress$2 = new TapGestureDetectorKt$detectTapAndPress$2(this.$this_detectTapAndPress, this.$onPress, this.$onTap, this.$pressScope, continuation);
        tapGestureDetectorKt$detectTapAndPress$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapAndPress$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$detectTapAndPress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", i = {0}, l = {237, 245}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1  reason: invalid class name */
    /* compiled from: TapGestureDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(coroutineScope, function3, function1, pressGestureScopeImpl, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x009b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0029
                if (r2 == r4) goto L_0x001f
                if (r2 != r3) goto L_0x0017
                kotlin.ResultKt.throwOnFailure(r19)
                r2 = r19
                goto L_0x0083
            L_0x0017:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x001f:
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r19)
                r6 = r19
                goto L_0x0053
            L_0x0029:
                kotlin.ResultKt.throwOnFailure(r19)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlinx.coroutines.CoroutineScope r6 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1 r7 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1
                androidx.compose.foundation.gestures.PressGestureScopeImpl r8 = r7
                r7.<init>(r8, r5)
                r9 = r7
                kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                r10 = 3
                r11 = 0
                r7 = 0
                r8 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
                r9 = r0
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r0.L$0 = r2
                r0.label = r4
                r7 = 0
                r6 = r2
                java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r6, r7, r8, r9, r10, r11)
                if (r6 != r1) goto L_0x0053
                return r1
            L_0x0053:
                androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                r6.consume()
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r7 = r5
                kotlin.jvm.functions.Function3 r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture
                if (r7 == r8) goto L_0x0075
                kotlinx.coroutines.CoroutineScope r9 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2 r7 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r8 = r5
                androidx.compose.foundation.gestures.PressGestureScopeImpl r10 = r7
                r7.<init>(r8, r10, r6, r5)
                r12 = r7
                kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
                r13 = 3
                r14 = 0
                r10 = 0
                r11 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
            L_0x0075:
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r0.L$0 = r5
                r0.label = r3
                java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation$default(r2, r5, r6, r4, r5)
                if (r2 != r1) goto L_0x0083
                return r1
            L_0x0083:
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                if (r2 != 0) goto L_0x009b
                kotlinx.coroutines.CoroutineScope r6 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3 r1 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3
                androidx.compose.foundation.gestures.PressGestureScopeImpl r2 = r7
                r1.<init>(r2, r5)
                r9 = r1
                kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                r10 = 3
                r11 = 0
                r7 = 0
                r8 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
                goto L_0x00c2
            L_0x009b:
                r2.consume()
                kotlinx.coroutines.CoroutineScope r12 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$4 r1 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$4
                androidx.compose.foundation.gestures.PressGestureScopeImpl r3 = r7
                r1.<init>(r3, r5)
                r15 = r1
                kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
                r16 = 3
                r17 = 0
                r13 = 0
                r14 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r12, r13, r14, r15, r16, r17)
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r1 = r6
                if (r1 == 0) goto L_0x00c2
                long r2 = r2.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3551boximpl(r2)
                r1.invoke(r2)
            L_0x00c2:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PointerInputScope pointerInputScope = this.$this_detectTapAndPress;
            final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
            final Function1<Offset, Unit> function1 = this.$onTap;
            final PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
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
