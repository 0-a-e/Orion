package androidx.compose.runtime.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.collection.IdentityArrayMap$asMap$1$keys$1$iterator$1", f = "IdentityArrayMap.kt", i = {0, 0}, l = {251}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
/* compiled from: IdentityArrayMap.kt */
final class IdentityArrayMap$asMap$1$keys$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Key>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IdentityArrayMap<Key, Value> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IdentityArrayMap$asMap$1$keys$1$iterator$1(IdentityArrayMap<Key, Value> identityArrayMap, Continuation<? super IdentityArrayMap$asMap$1$keys$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = identityArrayMap;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IdentityArrayMap$asMap$1$keys$1$iterator$1 identityArrayMap$asMap$1$keys$1$iterator$1 = new IdentityArrayMap$asMap$1$keys$1$iterator$1(this.this$0, continuation);
        identityArrayMap$asMap$1$keys$1$iterator$1.L$0 = obj;
        return identityArrayMap$asMap$1$keys$1$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Key> sequenceScope, Continuation<? super Unit> continuation) {
        return ((IdentityArrayMap$asMap$1$keys$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            int r1 = r6.I$1
            int r3 = r6.I$0
            java.lang.Object r4 = r6.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004f
        L_0x0017:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            androidx.compose.runtime.collection.IdentityArrayMap<Key, Value> r1 = r6.this$0
            int r1 = r1.getSize()
            r3 = 0
            r4 = r7
        L_0x002e:
            if (r3 >= r1) goto L_0x0051
            androidx.compose.runtime.collection.IdentityArrayMap<Key, Value> r7 = r6.this$0
            java.lang.Object[] r7 = r7.getKeys()
            r7 = r7[r3]
            java.lang.String r5 = "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r5)
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r4
            r6.I$0 = r3
            r6.I$1 = r1
            r6.label = r2
            java.lang.Object r7 = r4.yield(r7, r5)
            if (r7 != r0) goto L_0x004f
            return r0
        L_0x004f:
            int r3 = r3 + r2
            goto L_0x002e
        L_0x0051:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityArrayMap$asMap$1$keys$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
