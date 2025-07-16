package jp.co.sony.reonpocket.data.interactor;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorOutput;", "", "onTagWriteFailed", "", "onTagWriteSuccess", "setCanReceiveTagConnectCallbackListener", "value", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagWriteInteractorInput.kt */
public interface TagWriteInteractorOutput {
    void onTagWriteFailed();

    void onTagWriteSuccess();

    void setCanReceiveTagConnectCallbackListener(boolean z);
}
