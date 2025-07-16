package jp.co.sony.reonpocket.modules.tagInfo.presenter;

import android.content.Context;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.tagInfo.router.TagInfoRouter;
import jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity;
import jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoViewInput;
import jp.co.sony.reonpocket.util.NoticeUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/presenter/TagInfoPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoActivity$TagInfoViewOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoViewInput;)V", "mRouter", "Ljp/co/sony/reonpocket/modules/tagInfo/router/TagInfoRouter;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "getIsTagRegistered", "", "getTagSerialNo", "", "handleSettingMenuTapItem", "", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "initUserInfo", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "showNotification", "transitToChangeUserInfo", "transitToEula", "transitToLegal", "transitToOss", "transitToPrivacy", "transitToSupport", "transitToUserFeedback", "unRegisterTag", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoPresenter.kt */
public final class TagInfoPresenter extends BasePresenter implements TagInfoActivity.TagInfoViewOutput {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Context aContext;
    /* access modifiers changed from: private */
    public final TagInfoViewInput aView;
    private final TagInfoRouter mRouter;
    private final TagInfoInteractorInput mTagInfoInteractor = new TagInfoInteractor();
    private UserInfoInteractorInput mUserInfoInteractor = new UserInfoInteractor();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagInfoPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem[] r0 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.FEEDBACK     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.INFORMATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.SUPPORT_PAGE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LEGAL     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.USER_INFO     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_UNREGISTER     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.tagInfo.presenter.TagInfoPresenter.WhenMappings.<clinit>():void");
        }
    }

    public TagInfoPresenter(Context context, TagInfoViewInput tagInfoViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = tagInfoViewInput;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity");
        this.mRouter = new TagInfoRouter((TagInfoActivity) context);
    }

    public void unRegisterTag() {
        this.mTagInfoInteractor.removeTagInfo(this.aContext);
        this.mTagInfoInteractor.removeTagBDAddress(this.aContext);
        this.mTagInfoInteractor.removeTagModel(this.aContext);
    }

    public String getTagSerialNo() {
        TagDataEntity tagInfo = this.mTagInfoInteractor.getTagInfo(this.aContext);
        if (tagInfo != null) {
            return tagInfo.getSerialNo();
        }
        return null;
    }

    public boolean getIsTagRegistered() {
        return this.mTagInfoInteractor.isTagRegistered(this.aContext);
    }

    public void transitToEula() {
        this.mRouter.transitToEula(this.aContext);
    }

    public void transitToPrivacy() {
        this.mRouter.transitToPrivacy(this.aContext);
    }

    public void transitToOss() {
        this.mRouter.goToOss();
    }

    public void initUserInfo() {
        UserInfoEntity userInfo = this.mUserInfoInteractor.getUserInfo(this.aContext);
        TagInfoViewInput tagInfoViewInput = this.aView;
        if (tagInfoViewInput != null) {
            tagInfoViewInput.onUserInfoInit(userInfo.getGender(), userInfo.getAge(), userInfo.getHeight(), userInfo.getWight(), userInfo.getState());
        }
    }

    public void registerUserInfo(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "aUserInfoEntity");
        this.mUserInfoInteractor.saveUserInfo(this.aContext, userInfoEntity, false, new TagInfoPresenter$registerUserInfo$1(this));
    }

    public void handleSettingMenuTapItem(SettingItemAdapter.SettingListItem settingListItem) {
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        switch (WhenMappings.$EnumSwitchMapping$0[settingListItem.getType().ordinal()]) {
            case 1:
                TagInfoViewInput tagInfoViewInput = this.aView;
                if (tagInfoViewInput != null) {
                    tagInfoViewInput.hiddenSettingMenuDialog();
                }
                transitToUserFeedback();
                return;
            case 2:
                TagInfoViewInput tagInfoViewInput2 = this.aView;
                if (tagInfoViewInput2 != null) {
                    tagInfoViewInput2.hiddenSettingMenuDialog();
                }
                TagInfoViewInput tagInfoViewInput3 = this.aView;
                if (tagInfoViewInput3 != null) {
                    tagInfoViewInput3.showNoMessageProgress();
                }
                showNotification();
                return;
            case 3:
                TagInfoViewInput tagInfoViewInput4 = this.aView;
                if (tagInfoViewInput4 != null) {
                    tagInfoViewInput4.hiddenSettingMenuDialog();
                }
                transitToSupport();
                return;
            case 4:
                TagInfoViewInput tagInfoViewInput5 = this.aView;
                if (tagInfoViewInput5 != null) {
                    tagInfoViewInput5.hiddenSettingMenuDialog();
                }
                transitToLegal();
                return;
            case 5:
                TagInfoViewInput tagInfoViewInput6 = this.aView;
                if (tagInfoViewInput6 != null) {
                    tagInfoViewInput6.hiddenSettingMenuDialog();
                }
                transitToChangeUserInfo();
                return;
            case 6:
                TagInfoViewInput tagInfoViewInput7 = this.aView;
                if (tagInfoViewInput7 != null) {
                    tagInfoViewInput7.hiddenSettingMenuDialog();
                }
                TagInfoViewInput tagInfoViewInput8 = this.aView;
                if (tagInfoViewInput8 != null) {
                    tagInfoViewInput8.showTagUnRegisterDialog();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void transitToUserFeedback() {
        String mFeedBackUrl = RemoteConfigUtil.INSTANCE.getMFeedBackUrl();
        if (mFeedBackUrl != null) {
            this.mRouter.jump2Url(mFeedBackUrl);
        }
    }

    public void showNotification() {
        NoticeUtil.INSTANCE.getNoticeImage(this.aContext, new TagInfoPresenter$showNotification$1(this));
    }

    private final void transitToSupport() {
        this.mRouter.transitToSupport(this.aContext);
    }

    private final void transitToLegal() {
        this.mRouter.goToLegal();
    }

    private final void transitToChangeUserInfo() {
        this.mRouter.goToChangeUserInfo();
    }
}
