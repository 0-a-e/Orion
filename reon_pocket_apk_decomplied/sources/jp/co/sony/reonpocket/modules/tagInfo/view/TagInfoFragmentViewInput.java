package jp.co.sony.reonpocket.modules.tagInfo.view;

import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragmentViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "isDataFromDevice", "", "updateDisplay", "", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "updateNoReceivingDisplay", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "updateNotReceivingDisplay", "updateReceivingDisplay", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoFragment.kt */
public interface TagInfoFragmentViewInput extends BaseViewInput {
    boolean isDataFromDevice();

    void updateDisplay(NotifyTagSensorDataEntity notifyTagSensorDataEntity);

    void updateNoReceivingDisplay(TagDataEntity tagDataEntity);

    void updateNotReceivingDisplay();

    void updateReceivingDisplay();
}
