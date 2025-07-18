package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B#\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00032\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J.\u0010 \u001a\u00020\u00032#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00030\"H\u0001J\u0016\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\nH\u0014J\u0015\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0014¢\u0006\u0002\u0010,J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0001J\u0016\u0010/\u001a\u00020\u00032\u0006\u0010&\u001a\u00028\u0000HA¢\u0006\u0002\u00100J$\u00101\u001a\b\u0012\u0004\u0012\u00020\u0003022\u0006\u0010&\u001a\u00028\u0000H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R$\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "isActive", "()Z", "isClosedForSend", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "onCancelled", "handled", "onCompleted", "value", "(Lkotlin/Unit;)V", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Broadcast.kt */
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    private final BroadcastChannel<E> _channel;

    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        this._channel.invokeOnClose(function1);
    }

    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return this._channel.offer(e);
    }

    public ReceiveChannel<E> openSubscription() {
        return this._channel.openSubscription();
    }

    public Object send(E e, Continuation<? super Unit> continuation) {
        return this._channel.send(e, continuation);
    }

    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m8555trySendJP2dKIU(E e) {
        return this._channel.m8593trySendJP2dKIU(e);
    }

    /* access modifiers changed from: protected */
    public final BroadcastChannel<E> get_channel() {
        return this._channel;
    }

    public BroadcastCoroutine(CoroutineContext coroutineContext, BroadcastChannel<E> broadcastChannel, boolean z) {
        super(coroutineContext, false, z);
        this._channel = broadcastChannel;
        initParentJob((Job) coroutineContext.get(Job.Key));
    }

    public boolean isActive() {
        return super.isActive();
    }

    public SendChannel<E> getChannel() {
        return this;
    }

    public void cancelInternal(Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, (String) null, 1, (Object) null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    /* access modifiers changed from: protected */
    public void onCompleted(Unit unit) {
        SendChannel.DefaultImpls.close$default(this._channel, (Throwable) null, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Throwable th, boolean z) {
        if (!this._channel.close(th) && !z) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        }
    }

    public boolean close(Throwable th) {
        boolean close = this._channel.close(th);
        start();
        return close;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable th) {
        if (th == null) {
            JobSupport jobSupport = this;
            th = new JobCancellationException(jobSupport.cancellationExceptionMessage(), (Throwable) null, jobSupport);
        }
        cancelInternal(th);
        return true;
    }

    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            JobSupport jobSupport = this;
            cancellationException = new JobCancellationException(jobSupport.cancellationExceptionMessage(), (Throwable) null, jobSupport);
        }
        cancelInternal(cancellationException);
    }
}
