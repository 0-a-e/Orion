package jp.co.sony.reonpocket.modules.tagInfo.view;

import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragmentOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "isTagRegistered", "", "tagScan", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoFragment.kt */
public interface TagInfoFragmentOutput extends BaseViewInput {
    boolean isTagRegistered();

    void tagScan();
}
