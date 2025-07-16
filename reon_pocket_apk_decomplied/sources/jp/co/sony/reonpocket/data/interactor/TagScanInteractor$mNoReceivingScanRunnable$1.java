package jp.co.sony.reonpocket.data.interactor;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"jp/co/sony/reonpocket/data/interactor/TagScanInteractor$mNoReceivingScanRunnable$1", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "run", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagScanInteractor.kt */
public final class TagScanInteractor$mNoReceivingScanRunnable$1 implements Runnable {
    final /* synthetic */ TagScanInteractor this$0;

    TagScanInteractor$mNoReceivingScanRunnable$1(TagScanInteractor tagScanInteractor) {
        this.this$0 = tagScanInteractor;
    }

    public void run() {
        this.this$0.executeNoReceiving();
        this.this$0.mNoReceivingScanHandler.postDelayed(this, 6100);
    }
}
