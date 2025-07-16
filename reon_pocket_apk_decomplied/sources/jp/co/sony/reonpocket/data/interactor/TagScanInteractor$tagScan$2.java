package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.data.interactor.TagScanInteractor$tagScan$2", f = "TagScanInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TagScanInteractor.kt */
final class TagScanInteractor$tagScan$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TagScanInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TagScanInteractor$tagScan$2(TagScanInteractor tagScanInteractor, Continuation<? super TagScanInteractor$tagScan$2> continuation) {
        super(2, continuation);
        this.this$0 = tagScanInteractor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TagScanInteractor$tagScan$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TagScanInteractor$tagScan$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence tagBDAddress = this.this$0.mTagInfoInteractor.getTagBDAddress(this.this$0.getAContext());
            if (tagBDAddress != null && tagBDAddress.length() != 0) {
                return Unit.INSTANCE;
            }
            if (this.this$0.callback != null) {
                TagScanInteractor tagScanInteractor = this.this$0;
                tagScanInteractor.mBleInteractor.tagScan(tagScanInteractor.getAContext(), tagScanInteractor.tagScanHandler);
            } else {
                Boxing.boxInt(DebugLogUtil.INSTANCE.d(TagScanInteractor.LOG_TAG, "asyncString:no Listener"));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
