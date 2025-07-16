package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.ExceptionsKt;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aP\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\u000b¢\u0006\u0002\b\fH\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\r\u001a2\u0010\u000e\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\u000bHH¢\u0006\u0002\u0010\u0010\u001a$\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0012\"\b\b\u0000\u0010\t*\u00020\u0013*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a$\u0010\u0014\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u0013*\b\u0012\u0004\u0012\u0002H\t0\u0004H@¢\u0006\u0002\u0010\u0015\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\t0\u0017\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H@¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cause", "", "consume", "R", "E", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* compiled from: Channels.common.kt */
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r3);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R> R consume(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r2, kotlin.jvm.functions.Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> r3) {
        /*
            r0 = 1
            java.lang.Object r3 = r3.invoke(r2)     // Catch:{ all -> 0x0010 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r1 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return r3
        L_0x0010:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consume(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object consumeEach(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r6, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r4) goto L_0x0039
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0037 }
            goto L_0x005e
        L_0x0037:
            r6 = move-exception
            goto L_0x0081
        L_0x0039:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x007d }
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L_0x004c:
            r0.L$0 = r8     // Catch:{ all -> 0x0037 }
            r0.L$1 = r7     // Catch:{ all -> 0x0037 }
            r0.L$2 = r6     // Catch:{ all -> 0x0037 }
            r0.label = r4     // Catch:{ all -> 0x0037 }
            java.lang.Object r2 = r6.hasNext(r0)     // Catch:{ all -> 0x0037 }
            if (r2 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r5 = r2
            r2 = r8
            r8 = r5
        L_0x005e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0037 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0037 }
            if (r8 == 0) goto L_0x006f
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0037 }
            r2.invoke(r8)     // Catch:{ all -> 0x0037 }
            r8 = r2
            goto L_0x004c
        L_0x006f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x007d:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0081:
            throw r6     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object toList(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r8, kotlin.coroutines.Continuation<? super java.util.List<? extends E>> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r4) goto L_0x003e
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r5 = r0.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003b }
            goto L_0x0069
        L_0x003b:
            r8 = move-exception
            r9 = r2
            goto L_0x008a
        L_0x003e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.List r9 = kotlin.collections.CollectionsKt.createListBuilder()
            kotlinx.coroutines.channels.ChannelIterator r2 = r8.iterator()     // Catch:{ all -> 0x0086 }
            r5 = r9
            r6 = r5
            r9 = r8
            r8 = r2
        L_0x0055:
            r0.L$0 = r6     // Catch:{ all -> 0x0084 }
            r0.L$1 = r5     // Catch:{ all -> 0x0084 }
            r0.L$2 = r9     // Catch:{ all -> 0x0084 }
            r0.L$3 = r8     // Catch:{ all -> 0x0084 }
            r0.label = r4     // Catch:{ all -> 0x0084 }
            java.lang.Object r2 = r8.hasNext(r0)     // Catch:{ all -> 0x0084 }
            if (r2 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r7 = r2
            r2 = r9
            r9 = r7
        L_0x0069:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x003b }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x003b }
            if (r9 == 0) goto L_0x007a
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x003b }
            r5.add(r9)     // Catch:{ all -> 0x003b }
            r9 = r2
            goto L_0x0055
        L_0x007a:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003b }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r3)
            java.util.List r8 = kotlin.collections.CollectionsKt.build(r6)
            return r8
        L_0x0084:
            r8 = move-exception
            goto L_0x008a
        L_0x0086:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x008a:
            throw r8     // Catch:{ all -> 0x008b }
        L_0x008b:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r9, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.toList(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <E> java.lang.Object consumeEach$$forInline(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r3, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r5 = 1
            r0 = r3
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0     // Catch:{ all -> 0x0036 }
            kotlinx.coroutines.channels.ChannelIterator r0 = r3.iterator()     // Catch:{ all -> 0x0036 }
        L_0x0008:
            r1 = 3
            kotlin.jvm.internal.InlineMarker.mark((int) r1)     // Catch:{ all -> 0x0036 }
            r1 = 0
            kotlin.jvm.internal.InlineMarker.mark((int) r1)     // Catch:{ all -> 0x0036 }
            r1 = 0
            java.lang.Object r2 = r0.hasNext(r1)     // Catch:{ all -> 0x0036 }
            kotlin.jvm.internal.InlineMarker.mark((int) r5)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0036 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x0028
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0036 }
            r4.invoke(r1)     // Catch:{ all -> 0x0036 }
            goto L_0x0008
        L_0x0028:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0036 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0036:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach$$forInline(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
