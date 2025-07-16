package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.LocaleUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "", "getTagBDAddress", "", "aContext", "Landroid/content/Context;", "getTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "getTagModel", "getTagSerialNo", "isTagAvailableInThisCountry", "", "aCountryCode", "isTagRegistered", "removeTagBDAddress", "", "removeTagInfo", "removeTagModel", "saveTagBDAddress", "bdAddress", "saveTagInfo", "aValue", "saveTagModel", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoInteractorInput.kt */
public interface TagInfoInteractorInput {
    String getTagBDAddress(Context context);

    TagDataEntity getTagInfo(Context context);

    String getTagModel(Context context);

    String getTagSerialNo(Context context);

    boolean isTagAvailableInThisCountry(Context context, String str);

    boolean isTagRegistered(Context context);

    void removeTagBDAddress(Context context);

    void removeTagInfo(Context context);

    void removeTagModel(Context context);

    void saveTagBDAddress(Context context, String str);

    void saveTagInfo(Context context, TagDataEntity tagDataEntity);

    void saveTagModel(Context context, String str);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagInfoInteractorInput.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean isTagAvailableInThisCountry$default(TagInfoInteractorInput tagInfoInteractorInput, Context context, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = LocaleUtil.INSTANCE.getLocale(context).getCountry();
                    Intrinsics.checkNotNullExpressionValue(str, "getCountry(...)");
                }
                return tagInfoInteractorInput.isTagAvailableInThisCountry(context, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isTagAvailableInThisCountry");
        }
    }
}
