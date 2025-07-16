package jp.co.sony.reon.android.ble;

import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reon.android.ble.BleManager$sendServiceMessage$4", f = "BleManager.kt", i = {}, l = {393}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BleManager.kt */
final class BleManager$sendServiceMessage$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BleManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleManager$sendServiceMessage$4(BleManager bleManager, Continuation<? super BleManager$sendServiceMessage$4> continuation) {
        super(2, continuation);
        this.this$0 = bleManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BleManager$sendServiceMessage$4(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BleManager$sendServiceMessage$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "jp.co.sony.reon.android.ble.BleManager$sendServiceMessage$4$1", f = "BleManager.kt", i = {}, l = {395}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: jp.co.sony.reon.android.ble.BleManager$sendServiceMessage$4$1  reason: invalid class name */
    /* compiled from: BleManager.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(bleManager, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0 || i == 1) {
                ResultKt.throwOnFailure(obj);
                while (!bleManager.isServiceConnected) {
                    this.label = 1;
                    if (DelayKt.delay(50, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                while (bleManager.isServiceConnected && (!bleManager.mMessageQueue.isEmpty())) {
                    Message message = (Message) bleManager.mMessageQueue.poll();
                    try {
                        Messenger access$getMSendMessenger$p = bleManager.mSendMessenger;
                        if (access$getMSendMessenger$p != null) {
                            access$getMSendMessenger$p.send(message);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final BleManager bleManager = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
