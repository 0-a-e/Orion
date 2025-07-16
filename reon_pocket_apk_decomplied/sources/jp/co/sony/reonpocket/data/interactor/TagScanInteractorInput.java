package jp.co.sony.reonpocket.data.interactor;

import java.util.Date;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagScanInteractorInput;", "", "execute", "", "release", "setListener", "callback", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractorCallbackListener;", "setNoReceivingListener", "Ljp/co/sony/reonpocket/data/interactor/TagScanNoReceivingInteractorCallbackListener;", "setNotShowPopupTime", "date", "Ljava/util/Date;", "tagInfo", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$TagInfo;", "startNoReceiving", "stopNoReceiving", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagScanInteractorInput.kt */
public interface TagScanInteractorInput {
    void execute();

    void release();

    void setListener(TagScanInteractorCallbackListener tagScanInteractorCallbackListener);

    void setNoReceivingListener(TagScanNoReceivingInteractorCallbackListener tagScanNoReceivingInteractorCallbackListener);

    void setNotShowPopupTime(Date date, TagScanInteractor.TagInfo tagInfo);

    void startNoReceiving();

    void stopNoReceiving();
}
