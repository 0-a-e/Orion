package androidx.compose.foundation;

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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1", f = "AndroidOverscroll.android.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidOverscroll.android.kt */
final class AndroidEdgeEffectOverscrollEffect$effectModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$effectModifier$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidEdgeEffectOverscrollEffect$effectModifier$1 androidEdgeEffectOverscrollEffect$effectModifier$1 = new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this.this$0, continuation);
        androidEdgeEffectOverscrollEffect$effectModifier$1.L$0 = obj;
        return androidEdgeEffectOverscrollEffect$effectModifier$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((AndroidEdgeEffectOverscrollEffect$effectModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1", f = "AndroidOverscroll.android.kt", i = {0, 1}, l = {321, 325}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1  reason: invalid class name */
    /* compiled from: AndroidOverscroll.android.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(androidEdgeEffectOverscrollEffect, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x006b A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0083  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00bc A[SYNTHETIC] */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0027
                if (r1 == r4) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x006c
            L_0x0017:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x001f:
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x0042
            L_0x0027:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                r1 = r13
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                r8 = r12
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r12.L$0 = r1
                r12.label = r4
                r6 = 0
                r7 = 0
                r9 = 2
                r10 = 0
                r5 = r1
                java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r13 != r0) goto L_0x0042
                return r0
            L_0x0042:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r5 = r3
                long r6 = r13.m5111getIdJ3iCeTQ()
                androidx.compose.ui.input.pointer.PointerId r6 = androidx.compose.ui.input.pointer.PointerId.m5092boximpl(r6)
                r5.pointerId = r6
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r5 = r3
                long r6 = r13.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r13 = androidx.compose.ui.geometry.Offset.m3551boximpl(r6)
                r5.pointerPosition = r13
            L_0x005e:
                r13 = r12
                kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
                r12.L$0 = r1
                r12.label = r2
                java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r1, r3, r13, r4, r3)
                if (r13 != r0) goto L_0x006c
                return r0
            L_0x006c:
                androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
                java.util.List r13 = r13.getChanges()
                java.util.ArrayList r5 = new java.util.ArrayList
                int r6 = r13.size()
                r5.<init>(r6)
                int r6 = r13.size()
                r7 = 0
                r8 = r7
            L_0x0081:
                if (r8 >= r6) goto L_0x0099
                java.lang.Object r9 = r13.get(r8)
                r10 = r9
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                boolean r10 = r10.getPressed()
                if (r10 == 0) goto L_0x0096
                r10 = r5
                java.util.Collection r10 = (java.util.Collection) r10
                r10.add(r9)
            L_0x0096:
                int r8 = r8 + 1
                goto L_0x0081
            L_0x0099:
                java.util.List r5 = (java.util.List) r5
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = r3
                int r6 = r5.size()
            L_0x00a1:
                if (r7 >= r6) goto L_0x00bc
                java.lang.Object r8 = r5.get(r7)
                r9 = r8
                androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                long r9 = r9.m5111getIdJ3iCeTQ()
                androidx.compose.ui.input.pointer.PointerId r11 = r13.pointerId
                boolean r9 = androidx.compose.ui.input.pointer.PointerId.m5094equalsimpl(r9, r11)
                if (r9 == 0) goto L_0x00b9
                goto L_0x00bd
            L_0x00b9:
                int r7 = r7 + 1
                goto L_0x00a1
            L_0x00bc:
                r8 = r3
            L_0x00bd:
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                if (r8 != 0) goto L_0x00c8
                java.lang.Object r13 = kotlin.collections.CollectionsKt.firstOrNull(r5)
                r8 = r13
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            L_0x00c8:
                if (r8 == 0) goto L_0x00e4
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = r3
                long r6 = r8.m5111getIdJ3iCeTQ()
                androidx.compose.ui.input.pointer.PointerId r6 = androidx.compose.ui.input.pointer.PointerId.m5092boximpl(r6)
                r13.pointerId = r6
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = r3
                long r6 = r8.m5113getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m3551boximpl(r6)
                r13.pointerPosition = r6
            L_0x00e4:
                java.util.Collection r5 = (java.util.Collection) r5
                boolean r13 = r5.isEmpty()
                r13 = r13 ^ r4
                if (r13 != 0) goto L_0x005e
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = r3
                r13.pointerId = r3
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.this$0;
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture((PointerInputScope) this.L$0, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
