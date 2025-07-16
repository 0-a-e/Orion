package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {540, 551}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "alreadyComposed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0079
            if (r2 == r4) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            java.lang.Object r2 = r0.L$7
            androidx.compose.runtime.collection.IdentityArraySet r2 = (androidx.compose.runtime.collection.IdentityArraySet) r2
            java.lang.Object r5 = r0.L$6
            androidx.compose.runtime.collection.IdentityArraySet r5 = (androidx.compose.runtime.collection.IdentityArraySet) r5
            java.lang.Object r6 = r0.L$5
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Object r7 = r0.L$4
            java.util.Set r7 = (java.util.Set) r7
            java.lang.Object r8 = r0.L$3
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$2
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r0.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.runtime.MonotonicFrameClock r11 = (androidx.compose.runtime.MonotonicFrameClock) r11
            kotlin.ResultKt.throwOnFailure(r22)
            r4 = r8
            r15 = r9
            r9 = r6
            r8 = r7
            r6 = r1
            r7 = r3
            r19 = r11
            r11 = r2
            r2 = r19
            r20 = r10
            r10 = r5
            r5 = r20
            goto L_0x0129
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004d:
            java.lang.Object r2 = r0.L$7
            androidx.compose.runtime.collection.IdentityArraySet r2 = (androidx.compose.runtime.collection.IdentityArraySet) r2
            java.lang.Object r5 = r0.L$6
            androidx.compose.runtime.collection.IdentityArraySet r5 = (androidx.compose.runtime.collection.IdentityArraySet) r5
            java.lang.Object r6 = r0.L$5
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Object r7 = r0.L$4
            java.util.Set r7 = (java.util.Set) r7
            java.lang.Object r8 = r0.L$3
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$2
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r0.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.runtime.MonotonicFrameClock r11 = (androidx.compose.runtime.MonotonicFrameClock) r11
            kotlin.ResultKt.throwOnFailure(r22)
            r12 = r7
            r13 = r8
            r15 = r9
            r14 = r10
            r9 = r2
            r10 = r5
            r2 = r11
            r11 = r6
            goto L_0x00dc
        L_0x0079:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.Object r2 = r0.L$0
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            java.util.Set r8 = (java.util.Set) r8
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            java.util.Set r9 = (java.util.Set) r9
            androidx.compose.runtime.collection.IdentityArraySet r10 = new androidx.compose.runtime.collection.IdentityArraySet
            r10.<init>()
            androidx.compose.runtime.collection.IdentityArraySet r11 = new androidx.compose.runtime.collection.IdentityArraySet
            r11.<init>()
        L_0x00ad:
            androidx.compose.runtime.Recomposer r12 = r0.this$0
            boolean r12 = r12.getShouldKeepRecomposing()
            if (r12 == 0) goto L_0x0144
            androidx.compose.runtime.Recomposer r12 = r0.this$0
            r13 = r0
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r0.L$0 = r2
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r7
            r0.L$4 = r8
            r0.L$5 = r9
            r0.L$6 = r10
            r0.L$7 = r11
            r0.label = r4
            java.lang.Object r12 = r12.awaitWorkAvailable(r13)
            if (r12 != r1) goto L_0x00d3
            return r1
        L_0x00d3:
            r14 = r5
            r15 = r6
            r13 = r7
            r12 = r8
            r19 = r11
            r11 = r9
            r9 = r19
        L_0x00dc:
            androidx.compose.runtime.Recomposer r5 = r0.this$0
            boolean r5 = r5.recordComposerModifications()
            if (r5 == 0) goto L_0x0131
            androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1 r16 = new androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1
            androidx.compose.runtime.Recomposer r6 = r0.this$0
            r5 = r16
            r7 = r10
            r8 = r9
            r4 = r9
            r9 = r14
            r3 = r10
            r10 = r15
            r22 = r11
            r11 = r12
            r17 = r1
            r1 = r12
            r12 = r13
            r18 = r4
            r4 = r13
            r13 = r22
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            r5 = r16
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r0.L$0 = r2
            r0.L$1 = r14
            r0.L$2 = r15
            r0.L$3 = r4
            r0.L$4 = r1
            r9 = r22
            r0.L$5 = r9
            r0.L$6 = r3
            r11 = r18
            r0.L$7 = r11
            r7 = 2
            r0.label = r7
            java.lang.Object r5 = r2.withFrameNanos(r5, r6)
            r6 = r17
            if (r5 != r6) goto L_0x0126
            return r6
        L_0x0126:
            r8 = r1
            r10 = r3
            r5 = r14
        L_0x0129:
            androidx.compose.runtime.Recomposer r1 = r0.this$0
            r1.discardUnusedValues()
            r1 = r6
            r3 = r7
            goto L_0x013f
        L_0x0131:
            r6 = r1
            r7 = r3
            r3 = r10
            r1 = r12
            r4 = r13
            r19 = r11
            r11 = r9
            r9 = r19
            r8 = r1
            r1 = r6
            r3 = r7
            r5 = r14
        L_0x013f:
            r6 = r15
            r7 = r4
            r4 = 1
            goto L_0x00ad
        L_0x0144:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, Set<ControlledComposition> set, Set<ControlledComposition> set2, IdentityArraySet<Object> identityArraySet, IdentityArraySet<ControlledComposition> identityArraySet2) {
        list.clear();
        list2.clear();
        list3.clear();
        set.clear();
        set2.clear();
        identityArraySet.clear();
        identityArraySet2.clear();
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        list.clear();
        synchronized (recomposer.stateLock) {
            List access$getCompositionValuesAwaitingInsert$p = recomposer.compositionValuesAwaitingInsert;
            int size = access$getCompositionValuesAwaitingInsert$p.size();
            for (int i = 0; i < size; i++) {
                list.add((MovableContentStateReference) access$getCompositionValuesAwaitingInsert$p.get(i));
            }
            recomposer.compositionValuesAwaitingInsert.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
