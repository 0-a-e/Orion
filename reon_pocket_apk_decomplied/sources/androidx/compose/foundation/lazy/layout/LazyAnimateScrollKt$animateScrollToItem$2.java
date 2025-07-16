package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {182, 280}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "F$2", "I$0", "L$0"})
/* compiled from: LazyAnimateScroll.kt */
final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $index;
    final /* synthetic */ int $numOfItemsForTeleport;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2(int i, Density density, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i2, int i3, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$density = density;
        this.$this_animateScrollToItem = lazyLayoutAnimateScrollScope;
        this.$scrollOffset = i2;
        this.$numOfItemsForTeleport = i3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$density, this.$this_animateScrollToItem, this.$scrollOffset, this.$numOfItemsForTeleport, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: androidx.compose.foundation.gestures.ScrollScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e3 A[SYNTHETIC, Splitter:B:35:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0130 A[Catch:{ ItemFoundInScroll -> 0x01b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0133 A[Catch:{ ItemFoundInScroll -> 0x01b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013d A[Catch:{ ItemFoundInScroll -> 0x01b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0140 A[Catch:{ ItemFoundInScroll -> 0x01b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0230 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r37) {
        /*
            r36 = this;
            r1 = r36
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 2
            r4 = 0
            r6 = 1
            if (r0 == 0) goto L_0x0050
            if (r0 == r6) goto L_0x0022
            if (r0 != r3) goto L_0x001a
            java.lang.Object r0 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r0 = (androidx.compose.foundation.gestures.ScrollScope) r0
            kotlin.ResultKt.throwOnFailure(r37)
            goto L_0x0231
        L_0x001a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0022:
            int r0 = r1.I$0
            float r7 = r1.F$2
            float r8 = r1.F$1
            float r9 = r1.F$0
            java.lang.Object r10 = r1.L$3
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r12 = (kotlin.jvm.internal.Ref.BooleanRef) r12
            java.lang.Object r13 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r13 = (androidx.compose.foundation.gestures.ScrollScope) r13
            kotlin.ResultKt.throwOnFailure(r37)     // Catch:{ ItemFoundInScroll -> 0x004b }
            r15 = r8
            r14 = r9
            r34 = r13
            r13 = r10
            r10 = r34
            r35 = r12
            r12 = r11
            r11 = r35
            goto L_0x01a1
        L_0x004b:
            r0 = move-exception
            r3 = r0
            r0 = r13
            goto L_0x01d3
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r37)
            java.lang.Object r0 = r1.L$0
            r7 = r0
            androidx.compose.foundation.gestures.ScrollScope r7 = (androidx.compose.foundation.gestures.ScrollScope) r7
            int r0 = r1.$index
            float r8 = (float) r0
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x0061
            r8 = r6
            goto L_0x0062
        L_0x0061:
            r8 = 0
        L_0x0062:
            if (r8 == 0) goto L_0x023d
            androidx.compose.ui.unit.Density r0 = r1.$density     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            float r8 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.TargetDistance     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            float r0 = r0.m6550toPx0680j_4(r8)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            androidx.compose.ui.unit.Density r8 = r1.$density     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            float r9 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.BoundDistance     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            float r8 = r8.m6550toPx0680j_4(r9)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            androidx.compose.ui.unit.Density r9 = r1.$density     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            float r10 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.MinimumDistance     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            float r9 = r9.m6550toPx0680j_4(r10)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            kotlin.jvm.internal.Ref$BooleanRef r10 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r10.<init>()     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r10.element = r6     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r11.<init>()     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r19 = 30
            r20 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            androidx.compose.animation.core.AnimationState r12 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r12, r13, r14, r16, r18, r19, r20)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r11.element = r12     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r12 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            int r13 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            boolean r12 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.isItemVisible(r12, r13)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            if (r12 != 0) goto L_0x01be
            int r12 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r13 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            int r13 = r13.getFirstVisibleItemIndex()     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            if (r12 <= r13) goto L_0x00b6
            r12 = r6
            goto L_0x00b7
        L_0x00b6:
            r12 = 0
        L_0x00b7:
            kotlin.jvm.internal.Ref$IntRef r13 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r13.<init>()     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r13.element = r6     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r14 = r0
            r15 = r8
            r0 = r12
            r12 = r11
            r11 = r10
            r10 = r7
            r7 = r9
        L_0x00c5:
            boolean r8 = r11.element     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            if (r8 == 0) goto L_0x023a
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r8 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r8 = r8.getItemCount()     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            if (r8 <= 0) goto L_0x023a
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r8 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r9 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r5 = r1.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r5 = r8.calculateDistanceTo(r9, r5)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r8 = java.lang.Math.abs(r5)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r8 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r8 >= 0) goto L_0x00f0
            float r5 = java.lang.Math.abs(r5)     // Catch:{ ItemFoundInScroll -> 0x01ac }
            float r5 = java.lang.Math.max(r5, r7)     // Catch:{ ItemFoundInScroll -> 0x01ac }
            if (r0 == 0) goto L_0x00ee
            goto L_0x00f5
        L_0x00ee:
            float r5 = -r5
            goto L_0x00f5
        L_0x00f0:
            if (r0 == 0) goto L_0x00f4
            r5 = r14
            goto L_0x00f5
        L_0x00f4:
            float r5 = -r14
        L_0x00f5:
            T r8 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r21 = r8
            androidx.compose.animation.core.AnimationState r21 = (androidx.compose.animation.core.AnimationState) r21     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r29 = 30
            r30 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r28 = 0
            androidx.compose.animation.core.AnimationState r8 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r21, (float) r22, (float) r23, (long) r24, (long) r26, (boolean) r28, (int) r29, (java.lang.Object) r30)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r12.element = r8     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            kotlin.jvm.internal.Ref$FloatRef r16 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r16.<init>()     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            T r8 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r21 = r8
            androidx.compose.animation.core.AnimationState r21 = (androidx.compose.animation.core.AnimationState) r21     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            java.lang.Float r22 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            T r8 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            androidx.compose.animation.core.AnimationState r8 = (androidx.compose.animation.core.AnimationState) r8     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            java.lang.Object r8 = r8.getVelocity()     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r8 = r8.floatValue()     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x0133
            r24 = 0
            goto L_0x0135
        L_0x0133:
            r24 = r6
        L_0x0135:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3 r23 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r9 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r8 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            if (r0 == 0) goto L_0x0140
            r17 = r6
            goto L_0x0142
        L_0x0140:
            r17 = 0
        L_0x0142:
            int r3 = r1.$numOfItemsForTeleport     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r4 = r1.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r18 = r8
            r8 = r23
            r37 = r10
            r10 = r18
            r31 = r11
            r11 = r5
            r5 = r12
            r12 = r16
            r32 = r13
            r13 = r37
            r6 = r14
            r14 = r31
            r33 = r15
            r15 = r17
            r16 = r33
            r17 = r32
            r18 = r3
            r19 = r4
            r20 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ ItemFoundInScroll -> 0x01b2 }
            r25 = r23
            kotlin.jvm.functions.Function1 r25 = (kotlin.jvm.functions.Function1) r25     // Catch:{ ItemFoundInScroll -> 0x01b2 }
            r26 = r1
            kotlin.coroutines.Continuation r26 = (kotlin.coroutines.Continuation) r26     // Catch:{ ItemFoundInScroll -> 0x01b2 }
            r3 = r37
            r1.L$0 = r3     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r10 = r31
            r1.L$1 = r10     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r1.L$2 = r5     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r13 = r32
            r1.L$3 = r13     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r1.F$0 = r6     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r8 = r33
            r1.F$1 = r8     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r1.F$2 = r7     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r1.I$0 = r0     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r4 = 1
            r1.label = r4     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            r23 = 0
            r27 = 2
            r28 = 0
            java.lang.Object r4 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r21, r22, r23, r24, r25, r26, r27, r28)     // Catch:{ ItemFoundInScroll -> 0x01b0 }
            if (r4 != r2) goto L_0x019c
            return r2
        L_0x019c:
            r12 = r5
            r14 = r6
            r15 = r8
            r11 = r10
            r10 = r3
        L_0x01a1:
            int r3 = r13.element     // Catch:{ ItemFoundInScroll -> 0x01ac }
            r4 = 1
            int r3 = r3 + r4
            r13.element = r3     // Catch:{ ItemFoundInScroll -> 0x01ac }
            r3 = 2
            r4 = 0
            r6 = 1
            goto L_0x00c5
        L_0x01ac:
            r0 = move-exception
            r3 = r0
            r0 = r10
            goto L_0x01d3
        L_0x01b0:
            r0 = move-exception
            goto L_0x01b8
        L_0x01b2:
            r0 = move-exception
            r3 = r37
            goto L_0x01b8
        L_0x01b6:
            r0 = move-exception
            r3 = r10
        L_0x01b8:
            r34 = r3
            r3 = r0
            r0 = r34
            goto L_0x01d3
        L_0x01be:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r0 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            int r3 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            int r0 = r0.getVisibleItemScrollOffset(r3)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            androidx.compose.foundation.lazy.layout.ItemFoundInScroll r3 = new androidx.compose.foundation.lazy.layout.ItemFoundInScroll     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            T r4 = r11.element     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            r3.<init>(r0, r4)     // Catch:{ ItemFoundInScroll -> 0x01d0 }
            throw r3     // Catch:{ ItemFoundInScroll -> 0x01d0 }
        L_0x01d0:
            r0 = move-exception
            r3 = r0
            r0 = r7
        L_0x01d3:
            androidx.compose.animation.core.AnimationState r4 = r3.getPreviousAnimation()
            r12 = 30
            r13 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            androidx.compose.animation.core.AnimationState r21 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r4, (float) r5, (float) r6, (long) r7, (long) r9, (boolean) r11, (int) r12, (java.lang.Object) r13)
            int r3 = r3.getItemOffset()
            int r4 = r1.$scrollOffset
            int r3 = r3 + r4
            float r3 = (float) r3
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            java.lang.Float r22 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            java.lang.Object r5 = r21.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x0207
            r5 = 1
            goto L_0x0208
        L_0x0207:
            r5 = 0
        L_0x0208:
            r6 = 1
            r24 = r5 ^ 1
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5 r5 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5
            r5.<init>(r3, r4, r0)
            r25 = r5
            kotlin.jvm.functions.Function1 r25 = (kotlin.jvm.functions.Function1) r25
            r26 = r1
            kotlin.coroutines.Continuation r26 = (kotlin.coroutines.Continuation) r26
            r1.L$0 = r0
            r3 = 0
            r1.L$1 = r3
            r1.L$2 = r3
            r1.L$3 = r3
            r3 = 2
            r1.label = r3
            r23 = 0
            r27 = 2
            r28 = 0
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r21, r22, r23, r24, r25, r26, r27, r28)
            if (r3 != r2) goto L_0x0231
            return r2
        L_0x0231:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r2 = r1.$this_animateScrollToItem
            int r3 = r1.$index
            int r4 = r1.$scrollOffset
            r2.snapToItem(r0, r3, r4)
        L_0x023a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x023d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Index should be non-negative ("
            r2.<init>(r3)
            r2.append(r0)
            r0 = 41
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean z, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, int i2) {
        if (z) {
            if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() <= i && (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() != i || lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() <= i2)) {
                return false;
            }
        } else if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() >= i && (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() != i || lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() >= i2)) {
            return false;
        }
        return true;
    }
}
