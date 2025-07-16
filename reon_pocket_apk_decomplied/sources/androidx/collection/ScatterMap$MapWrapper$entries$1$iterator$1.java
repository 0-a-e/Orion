package androidx.collection;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H@"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {701}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
/* compiled from: ScatterMap.kt */
final class ScatterMap$MapWrapper$entries$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<? extends K, ? extends V>>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScatterMap<K, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScatterMap$MapWrapper$entries$1$iterator$1(ScatterMap<K, V> scatterMap, Continuation<? super ScatterMap$MapWrapper$entries$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = scatterMap;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScatterMap$MapWrapper$entries$1$iterator$1 scatterMap$MapWrapper$entries$1$iterator$1 = new ScatterMap$MapWrapper$entries$1$iterator$1(this.this$0, continuation);
        scatterMap$MapWrapper$entries$1$iterator$1.L$0 = obj;
        return scatterMap$MapWrapper$entries$1$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Map.Entry<? extends K, ? extends V>> sequenceScope, Continuation<? super Unit> continuation) {
        return ((ScatterMap$MapWrapper$entries$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a3  */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r5) goto L_0x002a
            int r2 = r0.I$3
            int r6 = r0.I$2
            long r7 = r0.J$0
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$2
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.L$1
            androidx.collection.ScatterMap r12 = (androidx.collection.ScatterMap) r12
            java.lang.Object r13 = r0.L$0
            kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x009b
        L_0x002a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.Object r2 = r0.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            androidx.collection.ScatterMap<K, V> r6 = r0.this$0
            long[] r7 = r6.metadata
            int r8 = r7.length
            int r8 = r8 + -2
            if (r8 < 0) goto L_0x00b2
            r9 = 0
        L_0x0043:
            r10 = r7[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L_0x00ab
            int r12 = r9 - r8
            int r12 = ~r12
            int r12 = r12 >>> 31
            int r12 = 8 - r12
            r13 = r2
            r2 = 0
            r18 = r12
            r12 = r6
            r6 = r18
            r19 = r10
            r11 = r7
            r10 = r8
            r7 = r19
        L_0x0067:
            if (r2 >= r6) goto L_0x00a3
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r7
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x009e
            int r14 = r9 << 3
            int r14 = r14 + r2
            androidx.collection.MapEntry r15 = new androidx.collection.MapEntry
            java.lang.Object[] r3 = r12.keys
            r3 = r3[r14]
            java.lang.Object[] r4 = r12.values
            r4 = r4[r14]
            r15.<init>(r3, r4)
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.J$0 = r7
            r0.I$2 = r6
            r0.I$3 = r2
            r0.label = r5
            java.lang.Object r3 = r13.yield(r15, r0)
            if (r3 != r1) goto L_0x009b
            return r1
        L_0x009b:
            r3 = 8
            goto L_0x009f
        L_0x009e:
            r3 = r4
        L_0x009f:
            long r7 = r7 >> r3
            int r2 = r2 + r5
            r4 = r3
            goto L_0x0067
        L_0x00a3:
            r3 = r4
            if (r6 != r3) goto L_0x00b2
            r8 = r10
            r7 = r11
            r6 = r12
            r2 = r13
            goto L_0x00ac
        L_0x00ab:
            r3 = r4
        L_0x00ac:
            if (r9 == r8) goto L_0x00b2
            int r9 = r9 + 1
            r4 = r3
            goto L_0x0043
        L_0x00b2:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
