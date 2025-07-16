package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¨\u0006\u0018"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractor;", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "()V", "getTagBDAddress", "", "aContext", "Landroid/content/Context;", "getTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "getTagModel", "getTagSerialNo", "isTagAvailableInThisCountry", "", "aCountryCode", "isTagRegistered", "removeTagBDAddress", "", "removeTagInfo", "removeTagModel", "saveTagBDAddress", "bdAddress", "saveTagInfo", "aValue", "saveTagModel", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoInteractor.kt */
public final class TagInfoInteractor implements TagInfoInteractorInput {
    public static final int $stable = 0;

    public void saveTagBDAddress(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "bdAddress");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_TAG_BD_ADDRESS, str);
    }

    public String getTagBDAddress(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_TAG_BD_ADDRESS);
    }

    public void removeTagBDAddress(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.remove(context, SimpleStorageUtil.REON_TAG_BD_ADDRESS);
    }

    public void saveTagInfo(Context context, TagDataEntity tagDataEntity) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(tagDataEntity, "aValue");
        String jSONString = tagDataEntity.toJSONString();
        if (jSONString != null) {
            SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_TAG_INFO, jSONString);
        }
    }

    public TagDataEntity getTagInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_TAG_INFO);
        CharSequence charSequence = stringValue;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        return TagDataEntity.Companion.from(new JSONObject(stringValue));
    }

    public void removeTagInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.remove(context, SimpleStorageUtil.REON_TAG_INFO);
    }

    public void saveTagModel(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aValue");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_TAG_MODEL_NAME, str);
    }

    public String getTagModel(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_TAG_MODEL_NAME);
    }

    public void removeTagModel(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.remove(context, SimpleStorageUtil.REON_TAG_MODEL_NAME);
    }

    public String getTagSerialNo(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        TagDataEntity tagInfo = getTagInfo(context);
        if (tagInfo != null) {
            return tagInfo.getSerialNo();
        }
        return null;
    }

    public boolean isTagRegistered(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        String tagBDAddress = getTagBDAddress(context);
        return tagBDAddress != null && tagBDAddress.length() > 0;
    }

    public boolean isTagAvailableInThisCountry(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountryCode");
        int hashCode = str.hashCode();
        return hashCode == 2084 ? !str.equals("AE") : !(hashCode == 2118 ? str.equals("BH") : hashCode == 2412 ? str.equals("KW") : hashCode == 2526 ? str.equals("OM") : !(hashCode == 2576 ? !str.equals("QA") : !(hashCode == 2638 && str.equals("SA"))));
    }
}
