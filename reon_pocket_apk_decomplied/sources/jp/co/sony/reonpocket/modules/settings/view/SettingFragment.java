package jp.co.sony.reonpocket.modules.settings.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.databinding.FragmentSettingTopBinding;
import jp.co.sony.reonpocket.databinding.ViewPreferenceSettingListItemBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.MyContentUtil;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020#J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/SettingFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "appListItems", "", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "[Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentSettingTopBinding;", "mAppListView", "Landroidx/recyclerview/widget/RecyclerView;", "mOperationView", "mReonListView", "operationItems", "reonListItems", "userInfoBinding", "Ljp/co/sony/reonpocket/databinding/ViewPreferenceSettingListItemBinding;", "initArray", "", "initUI", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "updateFirmwareReversion", "aFirmwareReversion", "", "updateModelName", "aModelName", "updateSettingItem", "aPosition", "", "aItem", "Companion", "OnSettingListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingFragment.kt */
public final class SettingFragment extends BaseFragment {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private SettingItemAdapter.SettingListItem[] appListItems;
    private FragmentSettingTopBinding binding;
    private RecyclerView mAppListView;
    private RecyclerView mOperationView;
    private RecyclerView mReonListView;
    private SettingItemAdapter.SettingListItem[] operationItems;
    private SettingItemAdapter.SettingListItem[] reonListItems;
    private ViewPreferenceSettingListItemBinding userInfoBinding;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/SettingFragment$OnSettingListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "clickUserFeedBack", "", "aUrl", "", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "getTagFwVersion", "getTagModelName", "isTagRegistered", "", "onChangeUserSelected", "onItemSelect", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "onRequestDataInit", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingFragment.kt */
    public interface OnSettingListener extends BaseFragment.Callback {
        void clickUserFeedBack(String str);

        CapabilityEntity getCapability();

        String getTagFwVersion();

        String getTagModelName();

        boolean isTagRegistered();

        void onChangeUserSelected();

        void onItemSelect(SettingItemAdapter.SettingListItem settingListItem);

        void onRequestDataInit();
    }

    @JvmStatic
    public static final SettingFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/SettingFragment$Companion;", "", "()V", "newInstance", "Ljp/co/sony/reonpocket/modules/settings/view/SettingFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SettingFragment newInstance() {
            return new SettingFragment();
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof OnSettingListener)) {
            throw new RuntimeException(context + " must implement OnSettingListener");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initArray() {
        /*
            r31 = this;
            r0 = r31
            java.lang.Object r1 = r31.getCallback$app_prodRelease()
            jp.co.sony.reonpocket.modules.settings.view.SettingFragment$OnSettingListener r1 = (jp.co.sony.reonpocket.modules.settings.view.SettingFragment.OnSettingListener) r1
            r2 = 0
            if (r1 == 0) goto L_0x0010
            jp.co.sony.reonpocket.data.entity.CapabilityEntity r3 = r1.getCapability()
            goto L_0x0011
        L_0x0010:
            r3 = r2
        L_0x0011:
            r4 = 0
            if (r3 == 0) goto L_0x001f
            jp.co.sony.reonpocket.data.entity.Capability1 r5 = r3.getCapability1()
            if (r5 == 0) goto L_0x001f
            boolean r5 = r5.isSupportAutoStart()
            goto L_0x0020
        L_0x001f:
            r5 = r4
        L_0x0020:
            if (r3 == 0) goto L_0x002d
            jp.co.sony.reonpocket.data.entity.Capability1 r3 = r3.getCapability1()
            if (r3 == 0) goto L_0x002d
            boolean r3 = r3.isSupportQuickLaunchMode()
            goto L_0x002e
        L_0x002d:
            r3 = r4
        L_0x002e:
            android.content.Context r6 = r31.getContext()
            if (r6 == 0) goto L_0x004f
            android.content.pm.PackageManager r6 = r6.getPackageManager()
            if (r6 == 0) goto L_0x004f
            android.content.Context r7 = r31.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r7 = r7.getPackageName()
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r7, r4)
            if (r6 == 0) goto L_0x004f
            java.lang.String r6 = r6.versionName
            r10 = r6
            goto L_0x0050
        L_0x004f:
            r10 = r2
        L_0x0050:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            if (r1 == 0) goto L_0x005f
            java.lang.String r7 = r1.getTagModelName()
            r14 = r7
            goto L_0x0060
        L_0x005f:
            r14 = r2
        L_0x0060:
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = r1.getTagFwVersion()
            goto L_0x0068
        L_0x0067:
            r1 = r2
        L_0x0068:
            java.lang.Object r7 = r31.getCallback$app_prodRelease()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            jp.co.sony.reonpocket.modules.settings.view.SettingFragment$OnSettingListener r7 = (jp.co.sony.reonpocket.modules.settings.view.SettingFragment.OnSettingListener) r7
            boolean r7 = r7.isTagRegistered()
            jp.co.sony.reonpocket.data.interactor.TagInfoInteractor r8 = new jp.co.sony.reonpocket.data.interactor.TagInfoInteractor
            r8.<init>()
            jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput r8 = (jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput) r8
            android.content.Context r9 = r31.requireContext()
            java.lang.String r11 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
            r11 = 2
            boolean r2 = jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput.DefaultImpls.isTagAvailableInThisCountry$default(r8, r9, r2, r11, r2)
            java.lang.String r9 = "getString(...)"
            if (r5 == 0) goto L_0x00aa
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r5 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r16 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.AUTO_START
            int r8 = jp.co.sony.reonpocket.R.string.setting_top_auto_start
            java.lang.String r8 = r0.getString(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            java.lang.Class<jp.co.sony.reonpocket.modules.autoStart.view.AutoStartActivity> r19 = jp.co.sony.reonpocket.modules.autoStart.view.AutoStartActivity.class
            r20 = 1
            r18 = 0
            r15 = r5
            r17 = r8
            r15.<init>(r16, r17, r18, r19, r20)
            r6.add(r5)
        L_0x00aa:
            if (r3 == 0) goto L_0x00c9
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r22 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.QUICK_LAUNCH
            int r5 = jp.co.sony.reonpocket.R.string.setting_top_quick_launch
            java.lang.String r5 = r0.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            java.lang.Class<jp.co.sony.reonpocket.modules.quickMode.view.QuickLaunchActivity> r25 = jp.co.sony.reonpocket.modules.quickMode.view.QuickLaunchActivity.class
            r26 = 1
            r24 = 0
            r21 = r3
            r23 = r5
            r21.<init>(r22, r23, r24, r25, r26)
            r6.add(r3)
        L_0x00c9:
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r3 < r5) goto L_0x00eb
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r16 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.BATTERY_NOTIFICATIONS
            int r5 = jp.co.sony.reonpocket.R.string.setting_top_remaining_battery_notification
            java.lang.String r5 = r0.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            java.lang.Class<jp.co.sony.reonpocket.modules.locationSetting.view.LocationSettingActivity> r19 = jp.co.sony.reonpocket.modules.locationSetting.view.LocationSettingActivity.class
            r20 = 1
            r18 = 0
            r15 = r3
            r17 = r5
            r15.<init>(r16, r17, r18, r19, r20)
            r6.add(r3)
        L_0x00eb:
            java.util.Collection r6 = (java.util.Collection) r6
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[] r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[r4]
            java.lang.Object[] r3 = r6.toArray(r3)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[] r3 = (jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[]) r3
            r0.reonListItems = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r5 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r16 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.UNREGISTER_DEVICE
            int r6 = jp.co.sony.reonpocket.R.string.setting_top_device_unregist
            java.lang.String r6 = r0.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            r19 = 0
            r20 = 1
            r18 = 0
            r15 = r5
            r17 = r6
            r15.<init>(r16, r17, r18, r19, r20)
            r3.add(r5)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r5 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r22 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.INITIALIZE_DEVICE
            int r6 = jp.co.sony.reonpocket.R.string.setting_top_device_initialize
            java.lang.String r6 = r0.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            r25 = 0
            r26 = 1
            r24 = 0
            r21 = r5
            r23 = r6
            r21.<init>(r22, r23, r24, r25, r26)
            r3.add(r5)
            if (r7 == 0) goto L_0x0156
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r2 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r16 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_UNREGISTER
            int r5 = jp.co.sony.reonpocket.R.string.setting_top_tag_unregist
            java.lang.String r5 = r0.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r19 = 0
            r20 = 1
            r18 = 0
            r15 = r2
            r17 = r5
            r15.<init>(r16, r17, r18, r19, r20)
            r3.add(r2)
            goto L_0x0175
        L_0x0156:
            if (r2 == 0) goto L_0x0175
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r2 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r22 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_REGISTER
            int r5 = jp.co.sony.reonpocket.R.string.setting_top_tag_regist
            java.lang.String r5 = r0.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r25 = 0
            r26 = 1
            r24 = 0
            r21 = r2
            r23 = r5
            r21.<init>(r22, r23, r24, r25, r26)
            r3.add(r2)
        L_0x0175:
            java.util.Collection r3 = (java.util.Collection) r3
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[] r2 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[r4]
            java.lang.Object[] r2 = r3.toArray(r2)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[] r2 = (jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[]) r2
            r0.operationItems = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r16 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.MODEL
            int r5 = jp.co.sony.reonpocket.R.string.setting_top_device_model
            java.lang.String r5 = r0.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r21 = 16
            r22 = 0
            java.lang.String r18 = " "
            r19 = 0
            r20 = 0
            r15 = r3
            r17 = r5
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r2.add(r3)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r24 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.SOFTWARE_VERSION
            int r5 = jp.co.sony.reonpocket.R.string.setting_top_device_fw_version
            java.lang.String r5 = r0.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r29 = 16
            r30 = 0
            java.lang.String r26 = " "
            r27 = 0
            r28 = 0
            r23 = r3
            r25 = r5
            r23.<init>(r24, r25, r26, r27, r28, r29, r30)
            r2.add(r3)
            if (r7 == 0) goto L_0x0206
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r12 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_MODEL
            int r5 = jp.co.sony.reonpocket.R.string.setting_top_tag_model
            java.lang.String r13 = r0.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r9)
            r17 = 16
            r18 = 0
            r15 = 0
            r16 = 0
            r11 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            r2.add(r3)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r16 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_SOFTWARE_VERSION
            int r5 = jp.co.sony.reonpocket.R.string.setting_top_tag_fw_version
            java.lang.String r5 = r0.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r21 = 16
            r22 = 0
            r19 = 0
            r20 = 0
            r15 = r3
            r17 = r5
            r18 = r1
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r2.add(r3)
        L_0x0206:
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r1 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r8 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.APP_VERSION
            int r3 = jp.co.sony.reonpocket.R.string.setting_top_app_version
            java.lang.String r3 = r0.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)
            r13 = 16
            r14 = 0
            r11 = 0
            r12 = 0
            r7 = r1
            r5 = r9
            r9 = r3
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r2.add(r1)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r1 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r16 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.INFORMATION
            int r3 = jp.co.sony.reonpocket.R.string.setting_top_notification
            java.lang.String r3 = r0.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            r19 = 0
            r20 = 1
            r18 = 0
            r15 = r1
            r17 = r3
            r15.<init>(r16, r17, r18, r19, r20)
            r2.add(r1)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r1 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r7 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.SUPPORT_PAGE
            int r3 = jp.co.sony.reonpocket.R.string.setting_top_support
            java.lang.String r8 = r0.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r10 = 0
            r11 = 1
            r9 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
            r2.add(r1)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r1 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r13 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LEGAL
            int r3 = jp.co.sony.reonpocket.R.string.setting_top_legal
            java.lang.String r14 = r0.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r5)
            r16 = 0
            r17 = 1
            r15 = 0
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r2.add(r1)
            java.util.Collection r2 = (java.util.Collection) r2
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[] r1 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[r4]
            java.lang.Object[] r1 = r2.toArray(r1)
            jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[] r1 = (jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[]) r1
            r0.appListItems = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.settings.view.SettingFragment.initArray():void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSettingTopBinding inflate = FragmentSettingTopBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        initArray();
        initUI(inflate);
        return inflate.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OnSettingListener onSettingListener = (OnSettingListener) getCallback$app_prodRelease();
        if (onSettingListener != null) {
            onSettingListener.onRequestDataInit();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
        this.userInfoBinding = null;
    }

    private final void initUI(FragmentSettingTopBinding fragmentSettingTopBinding) {
        MyContentUtil myContentUtil = MyContentUtil.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (myContentUtil.isShowTwitter(requireContext)) {
            fragmentSettingTopBinding.twitterDescription.setVisibility(0);
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.settings.view.SettingActivity");
        String feedbackUrl = ((SettingActivity) activity).getFeedbackUrl();
        if (feedbackUrl != null && feedbackUrl.length() > 0) {
            MyContentUtil myContentUtil2 = MyContentUtil.INSTANCE;
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            if (MyContentUtil.isSupportFeedback$default(myContentUtil2, requireContext2, (String) null, 2, (Object) null)) {
                fragmentSettingTopBinding.feedbackContainer.setVisibility(0);
                ViewPreferenceSettingListItemBinding viewPreferenceSettingListItemBinding = fragmentSettingTopBinding.userFeedbackLayout;
                viewPreferenceSettingListItemBinding.title.setText(getString(R.string.setting_top_feedback));
                viewPreferenceSettingListItemBinding.summary.setVisibility(8);
                if (Intrinsics.areEqual((Object) Locale.getDefault().getLanguage(), (Object) ArchiveStreamFactory.AR)) {
                    viewPreferenceSettingListItemBinding.rightIcon.setImageResource(R.drawable.ic_right_arrow_ar);
                    viewPreferenceSettingListItemBinding.rightIcon.setScaleType(ImageView.ScaleType.FIT_START);
                }
                viewPreferenceSettingListItemBinding.rightIcon.setVisibility(0);
                viewPreferenceSettingListItemBinding.getRoot().setOnClickListener(new SettingFragment$$ExternalSyntheticLambda0(this, feedbackUrl));
            }
        }
        RecyclerView recyclerView = fragmentSettingTopBinding.reonList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "reonList");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mReonListView = recyclerView;
        SettingItemAdapter.SettingListItem[] settingListItemArr = this.reonListItems;
        if (settingListItemArr != null) {
            recyclerView.setAdapter(new SettingItemAdapter(settingListItemArr, new SettingFragment$initUI$2$1(this)));
        }
        RecyclerView recyclerView2 = fragmentSettingTopBinding.operationList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "operationList");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mOperationView = recyclerView2;
        SettingItemAdapter.SettingListItem[] settingListItemArr2 = this.operationItems;
        if (settingListItemArr2 != null) {
            recyclerView2.setAdapter(new SettingItemAdapter(settingListItemArr2, new SettingFragment$initUI$3$1(this)));
        }
        RecyclerView recyclerView3 = fragmentSettingTopBinding.appList;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "appList");
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mAppListView = recyclerView3;
        SettingItemAdapter.SettingListItem[] settingListItemArr3 = this.appListItems;
        if (settingListItemArr3 != null) {
            recyclerView3.setAdapter(new SettingItemAdapter(settingListItemArr3, new SettingFragment$initUI$4$1(this)));
        }
        fragmentSettingTopBinding.itemChangeUserInfo.setOnInflateListener(new SettingFragment$$ExternalSyntheticLambda1(this));
        fragmentSettingTopBinding.itemChangeUserInfo.inflate();
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$2$lambda$1$lambda$0(SettingFragment settingFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$url");
        OnSettingListener onSettingListener = (OnSettingListener) settingFragment.getCallback$app_prodRelease();
        if (onSettingListener != null) {
            onSettingListener.clickUserFeedBack(str);
        }
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$9(SettingFragment settingFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        ViewPreferenceSettingListItemBinding bind = ViewPreferenceSettingListItemBinding.bind(view);
        MyContentUtil myContentUtil = MyContentUtil.INSTANCE;
        Context requireContext = settingFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (myContentUtil.isValidUserInfo(requireContext)) {
            bind.getRoot().setVisibility(0);
            bind.title.setText(settingFragment.getString(R.string.user_info_title));
            bind.summary.setVisibility(8);
            bind.getRoot().setOnClickListener(new SettingFragment$$ExternalSyntheticLambda2(settingFragment));
        } else {
            bind.getRoot().setVisibility(8);
        }
        settingFragment.userInfoBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$9$lambda$7$lambda$6(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        OnSettingListener onSettingListener = (OnSettingListener) settingFragment.getCallback$app_prodRelease();
        if (onSettingListener != null) {
            onSettingListener.onChangeUserSelected();
        }
    }

    private final void updateSettingItem(int i, SettingItemAdapter.SettingListItem settingListItem) {
        RecyclerView.Adapter adapter;
        SettingItemAdapter.SettingListItem[] settingListItemArr = this.appListItems;
        if (settingListItemArr != null) {
            settingListItemArr[i] = settingListItem;
        }
        RecyclerView recyclerView = this.mAppListView;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void updateFirmwareReversion(String str) {
        Intrinsics.checkNotNullParameter(str, "aFirmwareReversion");
        SettingItemAdapter.SettingItem settingItem = SettingItemAdapter.SettingItem.SOFTWARE_VERSION;
        String string = getString(R.string.setting_top_device_fw_version);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        updateSettingItem(1, new SettingItemAdapter.SettingListItem(settingItem, string, str, (Class) null, false, 16, (DefaultConstructorMarker) null));
    }

    public final void updateModelName(String str) {
        Intrinsics.checkNotNullParameter(str, "aModelName");
        SettingItemAdapter.SettingItem settingItem = SettingItemAdapter.SettingItem.MODEL;
        String string = getString(R.string.setting_top_device_model);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        updateSettingItem(0, new SettingItemAdapter.SettingListItem(settingItem, string, str, (Class) null, false, 16, (DefaultConstructorMarker) null));
    }
}
