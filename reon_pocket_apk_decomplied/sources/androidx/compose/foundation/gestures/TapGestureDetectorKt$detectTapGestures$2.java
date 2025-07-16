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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TapGestureDetector.kt */
final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
    final /* synthetic */ Function1<Offset, Unit> $onLongPress;
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
        super(2, continuation);
        this.$this_detectTapGestures = pointerInputScope;
        this.$onPress = function3;
        this.$onLongPress = function1;
        this.$onDoubleTap = function12;
        this.$onTap = function13;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$detectTapGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
            PointerInputScope pointerInputScope = this.$this_detectTapGestures;
            final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
            final Function1<Offset, Unit> function1 = this.$onLongPress;
            final Function1<Offset, Unit> function12 = this.$onDoubleTap;
            final Function1<Offset, Unit> function13 = this.$onTap;
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

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {100, 114, 129, 141, 156, 178}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "secondDown"}, s = {"L$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1  reason: invalid class name */
    /* compiled from: TapGestureDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(coroutineScope, function3, function1, function12, function13, pressGestureScopeImpl, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0091, code lost:
            r8 = r2;
            r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r4;
            r7.consume();
            r9 = r4;
            r4 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass1((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass1>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b1, code lost:
            if (r5 == androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture) goto L_0x00c8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b3, code lost:
            r9 = r4;
            r4 = r5;
            r5 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass2((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass2>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ca, code lost:
            if (r6 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cc, code lost:
            r4 = r8.getViewConfiguration().getLongPressTimeoutMillis();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d5, code lost:
            r4 = kotlin.time.DurationKt.MAX_MILLIS;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00da, code lost:
            r2 = new kotlin.jvm.internal.Ref.ObjectRef();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r0.L$0 = r8;
            r0.L$1 = r7;
            r0.L$2 = r2;
            r0.L$3 = r2;
            r0.J$0 = r4;
            r0.label = 2;
            r6 = r8.withTimeout(r4, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass3((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass3>) null), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fa, code lost:
            if (r6 != r1) goto L_0x00fd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fc, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fd, code lost:
            r9 = r8;
            r8 = r7;
            r7 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r2.element = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0104, code lost:
            if (r7.element != null) goto L_0x011a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0106, code lost:
            r10 = r4;
            r6 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass4((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass4>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x011a, code lost:
            ((androidx.compose.ui.input.pointer.PointerInputChange) r7.element).consume();
            r10 = r4;
            r6 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass5((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass5>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0135, code lost:
            r2 = r7;
            r7 = r8;
            r6 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x013c, code lost:
            r8.invoke(androidx.compose.ui.geometry.Offset.m3551boximpl(r7.m5113getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x015d, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0179, code lost:
            if (r7 == null) goto L_0x017b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x017b, code lost:
            r1 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x017d, code lost:
            if (r1 != null) goto L_0x017f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x017f, code lost:
            r1.invoke(androidx.compose.ui.geometry.Offset.m3551boximpl(((androidx.compose.ui.input.pointer.PointerInputChange) r7.element).m5113getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0190, code lost:
            r0.L$0 = r9;
            r0.L$1 = r7;
            r0.L$2 = null;
            r0.L$3 = null;
            r0.J$0 = r4;
            r0.label = 4;
            r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitSecondDown(r9, (androidx.compose.ui.input.pointer.PointerInputChange) r7.element, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01a8, code lost:
            if (r2 == r1) goto L_0x01aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01aa, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ab, code lost:
            r13 = r7;
            r14 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01ad, code lost:
            r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01af, code lost:
            if (r2 == null) goto L_0x01b1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01b1, code lost:
            r1 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x01b3, code lost:
            if (r1 != null) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b5, code lost:
            r1.invoke(androidx.compose.ui.geometry.Offset.m3551boximpl(((androidx.compose.ui.input.pointer.PointerInputChange) r13.element).m5113getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01c6, code lost:
            r6 = r4;
            r8 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass7((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass7>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x01df, code lost:
            if (r5 != androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture) goto L_0x01e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e1, code lost:
            r15 = r4;
            r7 = r5;
            r8 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r15, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass8((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass8>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            r7 = r4;
            r8 = r7;
            r9 = r8;
            r11 = r9;
            r10 = r13;
            r0.L$0 = r14;
            r0.L$1 = r13;
            r0.L$2 = r2;
            r0.label = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x021d, code lost:
            if (r14.withTimeout(r4, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass9((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass9>) null), r0) == r1) goto L_0x021f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x021f, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0220, code lost:
            r4 = r13;
            r5 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0222, code lost:
            r6 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0224, code lost:
            if (r6 != null) goto L_0x0226;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0226, code lost:
            r6.invoke(androidx.compose.ui.geometry.Offset.m3551boximpl(((androidx.compose.ui.input.pointer.PointerInputChange) r4.element).m5113getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0235, code lost:
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0237, code lost:
            if (r4 != null) goto L_0x0239;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0239, code lost:
            r4.invoke(androidx.compose.ui.geometry.Offset.m3551boximpl(r2.m5113getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0244, code lost:
            r0.L$0 = null;
            r0.L$1 = null;
            r0.L$2 = null;
            r0.label = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0254, code lost:
            if (androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r5, r0) == r1) goto L_0x0256;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0256, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0257, code lost:
            r4 = r4;
            r2 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass10((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass10>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x013c  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x015d A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0177  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                r0 = r21
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                switch(r2) {
                    case 0: goto L_0x0076;
                    case 1: goto L_0x006c;
                    case 2: goto L_0x004c;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x002a;
                    case 5: goto L_0x0019;
                    case 6: goto L_0x0014;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0014:
                kotlin.ResultKt.throwOnFailure(r22)
                goto L_0x0257
            L_0x0019:
                java.lang.Object r2 = r0.L$2
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                java.lang.Object r4 = r0.L$1
                kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
                java.lang.Object r5 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                goto L_0x026a
            L_0x002a:
                long r4 = r0.J$0
                java.lang.Object r2 = r0.L$1
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r6 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                kotlin.ResultKt.throwOnFailure(r22)
                r13 = r2
                r14 = r6
                r2 = r22
                goto L_0x01ad
            L_0x003d:
                long r4 = r0.J$0
                java.lang.Object r2 = r0.L$1
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r6 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                kotlin.ResultKt.throwOnFailure(r22)
                goto L_0x015e
            L_0x004c:
                long r4 = r0.J$0
                java.lang.Object r2 = r0.L$3
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r6 = r0.L$2
                kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
                java.lang.Object r7 = r0.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                java.lang.Object r8 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
                kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0068 }
                r9 = r8
                r8 = r7
                r7 = r6
                r6 = r22
                goto L_0x0100
            L_0x0068:
                r2 = r6
            L_0x0069:
                r6 = r8
                goto L_0x0138
            L_0x006c:
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r22)
                r4 = r22
                goto L_0x0091
            L_0x0076:
                kotlin.ResultKt.throwOnFailure(r22)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                r7 = r0
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r0.L$0 = r2
                r4 = 1
                r0.label = r4
                r5 = 0
                r6 = 0
                r8 = 3
                r9 = 0
                r4 = r2
                java.lang.Object r4 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                if (r4 != r1) goto L_0x0091
                return r1
            L_0x0091:
                r8 = r2
                r7 = r4
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                r7.consume()
                kotlinx.coroutines.CoroutineScope r9 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1
                androidx.compose.foundation.gestures.PressGestureScopeImpl r4 = r9
                r2.<init>(r4, r3)
                r12 = r2
                kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
                r13 = 3
                r14 = 0
                r10 = 0
                r11 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r2 = r5
                kotlin.jvm.functions.Function3 r4 = androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture
                if (r2 == r4) goto L_0x00c8
                kotlinx.coroutines.CoroutineScope r9 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r4 = r5
                androidx.compose.foundation.gestures.PressGestureScopeImpl r5 = r9
                r2.<init>(r4, r5, r7, r3)
                r12 = r2
                kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
                r13 = 3
                r14 = 0
                r10 = 0
                r11 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
            L_0x00c8:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r6
                if (r2 == 0) goto L_0x00d5
                androidx.compose.ui.platform.ViewConfiguration r2 = r8.getViewConfiguration()
                long r4 = r2.getLongPressTimeoutMillis()
                goto L_0x00da
            L_0x00d5:
                r4 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            L_0x00da:
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3 r6 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r6.<init>(r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r9 = r0
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.L$0 = r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.L$1 = r7     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.L$2 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.L$3 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.J$0 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r10 = 2
                r0.label = r10     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                java.lang.Object r6 = r8.withTimeout(r4, r6, r9)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                if (r6 != r1) goto L_0x00fd
                return r1
            L_0x00fd:
                r9 = r8
                r8 = r7
                r7 = r2
            L_0x0100:
                r2.element = r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                T r2 = r7.element     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                if (r2 != 0) goto L_0x011a
                kotlinx.coroutines.CoroutineScope r10 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r6 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                r2.<init>(r6, r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                r13 = r2
                kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                r14 = 3
                r15 = 0
                r11 = 0
                r12 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                goto L_0x0173
            L_0x011a:
                T r2 = r7.element     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                r2.consume()     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                kotlinx.coroutines.CoroutineScope r10 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r6 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                r2.<init>(r6, r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                r13 = r2
                kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                r14 = 3
                r15 = 0
                r11 = 0
                r12 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0135 }
                goto L_0x0173
            L_0x0135:
                r2 = r7
                r7 = r8
                r6 = r9
            L_0x0138:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r8 = r6
                if (r8 == 0) goto L_0x0147
                long r9 = r7.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r7 = androidx.compose.ui.geometry.Offset.m3551boximpl(r9)
                r8.invoke(r7)
            L_0x0147:
                r7 = r0
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r0.L$0 = r6
                r0.L$1 = r2
                r0.L$2 = r3
                r0.L$3 = r3
                r0.J$0 = r4
                r8 = 3
                r0.label = r8
                java.lang.Object r7 = androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r6, r7)
                if (r7 != r1) goto L_0x015e
                return r1
            L_0x015e:
                kotlinx.coroutines.CoroutineScope r7 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6 r8 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6
                androidx.compose.foundation.gestures.PressGestureScopeImpl r9 = r9
                r8.<init>(r9, r3)
                r10 = r8
                kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
                r11 = 3
                r12 = 0
                r8 = 0
                r9 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
                r7 = r2
                r9 = r6
            L_0x0173:
                T r2 = r7.element
                if (r2 == 0) goto L_0x026a
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r7
                if (r2 != 0) goto L_0x0190
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r1 = r8
                if (r1 == 0) goto L_0x026a
                T r2 = r7.element
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                long r2 = r2.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3551boximpl(r2)
                r1.invoke(r2)
                goto L_0x026a
            L_0x0190:
                T r2 = r7.element
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r0.L$0 = r9
                r0.L$1 = r7
                r0.L$2 = r3
                r0.L$3 = r3
                r0.J$0 = r4
                r8 = 4
                r0.label = r8
                java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitSecondDown(r9, r2, r6)
                if (r2 != r1) goto L_0x01ab
                return r1
            L_0x01ab:
                r13 = r7
                r14 = r9
            L_0x01ad:
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                if (r2 != 0) goto L_0x01c6
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r1 = r8
                if (r1 == 0) goto L_0x026a
                T r2 = r13.element
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                long r2 = r2.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3551boximpl(r2)
                r1.invoke(r2)
                goto L_0x026a
            L_0x01c6:
                kotlinx.coroutines.CoroutineScope r6 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7 r7 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7
                androidx.compose.foundation.gestures.PressGestureScopeImpl r8 = r9
                r7.<init>(r8, r3)
                r9 = r7
                kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                r10 = 3
                r11 = 0
                r7 = 0
                r8 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r5
                kotlin.jvm.functions.Function3 r7 = androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture
                if (r6 == r7) goto L_0x01fb
                kotlinx.coroutines.CoroutineScope r15 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8 r6 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r7 = r5
                androidx.compose.foundation.gestures.PressGestureScopeImpl r8 = r9
                r6.<init>(r7, r8, r2, r3)
                r18 = r6
                kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
                r19 = 3
                r20 = 0
                r16 = 0
                r17 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r15, r16, r17, r18, r19, r20)
            L_0x01fb:
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9 r15 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                kotlinx.coroutines.CoroutineScope r7 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r8 = r7     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r9 = r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r11 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                r12 = 0
                r6 = r15
                r10 = r13
                r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                r0.L$0 = r14     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                r0.L$1 = r13     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                r0.L$2 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                r7 = 5
                r0.label = r7     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                java.lang.Object r2 = r14.withTimeout(r4, r15, r6)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0220 }
                if (r2 != r1) goto L_0x026a
                return r1
            L_0x0220:
                r4 = r13
                r5 = r14
            L_0x0222:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r6 = r8
                if (r6 == 0) goto L_0x0235
                T r4 = r4.element
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                long r7 = r4.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3551boximpl(r7)
                r6.invoke(r4)
            L_0x0235:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r6
                if (r4 == 0) goto L_0x0244
                long r6 = r2.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3551boximpl(r6)
                r4.invoke(r2)
            L_0x0244:
                r2 = r0
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r0.L$0 = r3
                r0.L$1 = r3
                r0.L$2 = r3
                r4 = 6
                r0.label = r4
                java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r5, r2)
                if (r2 != r1) goto L_0x0257
                return r1
            L_0x0257:
                kotlinx.coroutines.CoroutineScope r4 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10 r1 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10
                androidx.compose.foundation.gestures.PressGestureScopeImpl r2 = r9
                r1.<init>(r2, r3)
                r7 = r1
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            L_0x026a:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
