package androidx.compose.foundation;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2", f = "BasicMarquee.kt", i = {}, l = {367}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BasicMarquee.kt */
final class MarqueeModifierNode$runAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MarqueeModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MarqueeModifierNode$runAnimation$2(MarqueeModifierNode marqueeModifierNode, Continuation<? super MarqueeModifierNode$runAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = marqueeModifierNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarqueeModifierNode$runAnimation$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MarqueeModifierNode$runAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final MarqueeModifierNode marqueeModifierNode = this.this$0;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Float>() {
                public final Float invoke() {
                    if (marqueeModifierNode.getContentWidth() <= marqueeModifierNode.getContainerWidth()) {
                        return null;
                    }
                    if (!MarqueeAnimationMode.m293equalsimpl0(marqueeModifierNode.m305getAnimationModeZbEOnfQ(), MarqueeAnimationMode.Companion.m300getWhileFocusedZbEOnfQ()) || marqueeModifierNode.getHasFocus()) {
                        return Float.valueOf((float) (marqueeModifierNode.getContentWidth() + marqueeModifierNode.getSpacingPx()));
                    }
                    return null;
                }
            });
            final MarqueeModifierNode marqueeModifierNode2 = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(snapshotFlow, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "contentWithSpacingWidth", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2", f = "BasicMarquee.kt", i = {0, 0}, l = {380, 382, 386, 386}, m = "invokeSuspend", n = {"contentWithSpacingWidth", "spec"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2  reason: invalid class name */
    /* compiled from: BasicMarquee.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(marqueeModifierNode2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Float f, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(f, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c5 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r1 = r18
                java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r1.label
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = 0
                r8 = 0
                if (r0 == 0) goto L_0x0044
                if (r0 == r6) goto L_0x0036
                if (r0 == r5) goto L_0x002e
                if (r0 == r4) goto L_0x0029
                if (r0 == r3) goto L_0x0020
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0020:
                java.lang.Object r0 = r1.L$0
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x00e3
            L_0x0029:
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x00c6
            L_0x002e:
                kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x0033 }
                goto L_0x00b0
            L_0x0033:
                r0 = move-exception
                goto L_0x00c9
            L_0x0036:
                java.lang.Object r0 = r1.L$1
                androidx.compose.animation.core.AnimationSpec r0 = (androidx.compose.animation.core.AnimationSpec) r0
                java.lang.Object r6 = r1.L$0
                java.lang.Float r6 = (java.lang.Float) r6
                kotlin.ResultKt.throwOnFailure(r19)
                r12 = r0
                r11 = r6
                goto L_0x0094
            L_0x0044:
                kotlin.ResultKt.throwOnFailure(r19)
                java.lang.Object r0 = r1.L$0
                java.lang.Float r0 = (java.lang.Float) r0
                if (r0 != 0) goto L_0x0050
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x0050:
                androidx.compose.foundation.MarqueeModifierNode r9 = r3
                int r10 = r9.iterations
                float r11 = r0.floatValue()
                androidx.compose.foundation.MarqueeModifierNode r9 = r3
                int r12 = r9.initialDelayMillis
                androidx.compose.foundation.MarqueeModifierNode r9 = r3
                int r13 = r9.delayMillis
                androidx.compose.foundation.MarqueeModifierNode r9 = r3
                float r14 = r9.velocity
                androidx.compose.foundation.MarqueeModifierNode r9 = r3
                androidx.compose.ui.node.DelegatableNode r9 = (androidx.compose.ui.node.DelegatableNode) r9
                androidx.compose.ui.unit.Density r15 = androidx.compose.ui.node.DelegatableNodeKt.requireDensity(r9)
                androidx.compose.animation.core.AnimationSpec r9 = androidx.compose.foundation.BasicMarqueeKt.m221createMarqueeAnimationSpecZ4HSEVQ(r10, r11, r12, r13, r14, r15)
                androidx.compose.foundation.MarqueeModifierNode r10 = r3
                androidx.compose.animation.core.Animatable r10 = r10.offset
                java.lang.Float r11 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
                r12 = r1
                kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                r1.L$0 = r0
                r1.L$1 = r9
                r1.label = r6
                java.lang.Object r6 = r10.snapTo(r11, r12)
                if (r6 != r2) goto L_0x0092
                return r2
            L_0x0092:
                r11 = r0
                r12 = r9
            L_0x0094:
                androidx.compose.foundation.MarqueeModifierNode r0 = r3     // Catch:{ all -> 0x0033 }
                androidx.compose.animation.core.Animatable r10 = r0.offset     // Catch:{ all -> 0x0033 }
                r15 = r1
                kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15     // Catch:{ all -> 0x0033 }
                r1.L$0 = r7     // Catch:{ all -> 0x0033 }
                r1.L$1 = r7     // Catch:{ all -> 0x0033 }
                r1.label = r5     // Catch:{ all -> 0x0033 }
                r13 = 0
                r14 = 0
                r16 = 12
                r17 = 0
                java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0033 }
                if (r0 != r2) goto L_0x00b0
                return r2
            L_0x00b0:
                androidx.compose.foundation.MarqueeModifierNode r0 = r3
                androidx.compose.animation.core.Animatable r0 = r0.offset
                java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r1.label = r4
                java.lang.Object r0 = r0.snapTo(r3, r5)
                if (r0 != r2) goto L_0x00c6
                return r2
            L_0x00c6:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x00c9:
                androidx.compose.foundation.MarqueeModifierNode r4 = r3
                androidx.compose.animation.core.Animatable r4 = r4.offset
                java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r1.L$0 = r0
                r1.L$1 = r7
                r1.label = r3
                java.lang.Object r3 = r4.snapTo(r5, r6)
                if (r3 != r2) goto L_0x00e3
                return r2
            L_0x00e3:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
