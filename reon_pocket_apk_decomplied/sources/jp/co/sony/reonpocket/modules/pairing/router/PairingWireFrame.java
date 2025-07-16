package jp.co.sony.reonpocket.modules.pairing.router;

import android.os.Bundle;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J,\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/router/PairingWireFrame;", "", "goToChangeUserInfo", "", "goToLegal", "goToMain", "aBundle", "Landroid/os/Bundle;", "goToOss", "goToPairingComplete", "aModelName", "", "goToTagInfo", "isTagInfoReceiving", "", "isTagNoAmbientTemp", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "tagDataEntity", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingRouter.kt */
public interface PairingWireFrame {
    void goToChangeUserInfo();

    void goToLegal();

    void goToMain(Bundle bundle);

    void goToOss();

    void goToPairingComplete(String str);

    void goToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity, TagDataEntity tagDataEntity);
}
