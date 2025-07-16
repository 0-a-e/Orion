package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, 300, 307}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* compiled from: SnapshotIdSet.kt */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            r6 = 3
            r7 = 2
            r8 = 64
            r10 = 0
            r12 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r12) goto L_0x0039
            if (r2 == r7) goto L_0x002e
            if (r2 != r6) goto L_0x0026
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r21)
            r13 = r6
            goto L_0x00f6
        L_0x0026:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002e:
            int r2 = r0.I$0
            java.lang.Object r13 = r0.L$0
            kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x00b6
        L_0x0039:
            int r2 = r0.I$1
            int r13 = r0.I$0
            java.lang.Object r14 = r0.L$1
            int[] r14 = (int[]) r14
            java.lang.Object r15 = r0.L$0
            kotlin.sequences.SequenceScope r15 = (kotlin.sequences.SequenceScope) r15
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x0079
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r2 = r0.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            androidx.compose.runtime.snapshots.SnapshotIdSet r13 = r0.this$0
            int[] r13 = r13.belowBound
            if (r13 == 0) goto L_0x007d
            int r14 = r13.length
            r15 = r2
            r2 = r14
            r14 = r13
            r13 = 0
        L_0x005d:
            if (r13 >= r2) goto L_0x007c
            r16 = r14[r13]
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r16)
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r0.L$0 = r15
            r0.L$1 = r14
            r0.I$0 = r13
            r0.I$1 = r2
            r0.label = r12
            java.lang.Object r6 = r15.yield(r9, r6)
            if (r6 != r1) goto L_0x0079
            return r1
        L_0x0079:
            int r13 = r13 + r12
            r6 = 3
            goto L_0x005d
        L_0x007c:
            r2 = r15
        L_0x007d:
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r0.this$0
            long r13 = r6.lowerSet
            int r6 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00b9
            r13 = r2
            r2 = 0
        L_0x0089:
            if (r2 >= r8) goto L_0x00b8
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r0.this$0
            long r14 = r6.lowerSet
            long r18 = r4 << r2
            long r14 = r14 & r18
            int r6 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00b6
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r0.this$0
            int r6 = r6.lowerBound
            int r6 = r6 + r2
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.L$0 = r13
            r0.L$1 = r3
            r0.I$0 = r2
            r0.label = r7
            java.lang.Object r6 = r13.yield(r6, r9)
            if (r6 != r1) goto L_0x00b6
            return r1
        L_0x00b6:
            int r2 = r2 + r12
            goto L_0x0089
        L_0x00b8:
            r2 = r13
        L_0x00b9:
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r0.this$0
            long r6 = r6.upperSet
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00fb
            r7 = r2
            r9 = 0
        L_0x00c5:
            if (r9 >= r8) goto L_0x00fb
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r0.this$0
            long r13 = r2.upperSet
            long r17 = r4 << r9
            long r13 = r13 & r17
            int r2 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x00f8
            int r2 = r9 + 64
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r0.this$0
            int r6 = r6.lowerBound
            int r2 = r2 + r6
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r0.L$0 = r7
            r0.L$1 = r3
            r0.I$0 = r9
            r13 = 3
            r0.label = r13
            java.lang.Object r2 = r7.yield(r2, r6)
            if (r2 != r1) goto L_0x00f5
            return r1
        L_0x00f5:
            r2 = r9
        L_0x00f6:
            r9 = r2
            goto L_0x00f9
        L_0x00f8:
            r13 = 3
        L_0x00f9:
            int r9 = r9 + r12
            goto L_0x00c5
        L_0x00fb:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
