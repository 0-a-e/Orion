package jp.co.sony.reonpocket.modules.settings.view;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.core.os.ConfigurationCompat;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;
import java.util.Locale;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.common.Gender;
import jp.co.sony.reonpocket.databinding.FragmentChangeUserInfoBinding;
import jp.co.sony.reonpocket.databinding.ViewPreferenceListBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0002UVB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\"H\u0003J.\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\fJ\u0010\u0010>\u001a\u0002042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010?\u001a\u0002042\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J$\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0018\u0010I\u001a\u0002042\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\"H\u0016J \u0010M\u001a\u0002042\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\"2\u0006\u0010N\u001a\u00020\"H\u0016J\b\u0010O\u001a\u000204H\u0016J\u0018\u0010P\u001a\u0002042\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\"H\u0016J\u0006\u0010Q\u001a\u000204J\b\u0010R\u001a\u000204H\u0002J\u0010\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0016\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u001c\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010 \u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u00101\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "()V", "addressBinding", "Ljp/co/sony/reonpocket/databinding/ViewPreferenceListBinding;", "ageBinding", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentChangeUserInfoBinding;", "genderBinding", "heightBinding", "mAddress", "", "mAddressEntry", "", "[Ljava/lang/String;", "mAddressEntryValues", "mAddressTextView", "Landroid/widget/TextView;", "mAge", "mAgeEntries", "mAgeEntryValues", "mAgeTextView", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mGender", "mGenderEntries", "mGenderEntryValues", "mGenderTextView", "mHeight", "mHeightEntries", "mHeightEntryValues", "mHeightTextView", "mLastAddressSelectedValue", "", "mLastAgeSelectedValue", "mLastGenderSelectedValue", "mLastHeightSelectedValue", "mLastWeightSelectedValue", "mSelectedPickerViewId", "Ljava/lang/Integer;", "mTempAddressSelectedValue", "mTempAgeSelectedValue", "mTempGenderSelectedValue", "mTempHeightSelectedValue", "mTempWeightSelectedValue", "mWeight", "mWeightEntries", "mWeightEntryValues", "mWeightTextView", "weightBinding", "changeNumberPickerDividerColor", "", "aNumberPicker", "Landroid/widget/NumberPicker;", "aColor", "doInitDataSetting", "aGender", "aAge", "aHeight", "aWeight", "aState", "initUI", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDataDialogCancelled", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "onDataDialogSucceeded", "aResultCode", "onDestroyView", "onDismiss", "sendUserInfo", "showListDialog", "showPickerDialog", "aViewId", "Companion", "OnChangeUserInfoListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChangeUserInfoFragment.kt */
public final class ChangeUserInfoFragment extends BaseFragment implements DataDialogFragment.Callback {
    public static final int $stable = 8;
    private static final int ADDRESS_LIST_ITEM_ID = 5;
    private static final int AGE_LIST_ITEM_ID = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int GENDER_LIST_ITEM_ID = 1;
    private static final int HEIGHT_LIST_ITEM_ID = 3;
    private static final int WEIGHT_LIST_ITEM_ID = 4;
    private ViewPreferenceListBinding addressBinding;
    private ViewPreferenceListBinding ageBinding;
    private FragmentChangeUserInfoBinding binding;
    private ViewPreferenceListBinding genderBinding;
    private ViewPreferenceListBinding heightBinding;
    private String mAddress;
    /* access modifiers changed from: private */
    public String[] mAddressEntry;
    private String[] mAddressEntryValues;
    private TextView mAddressTextView;
    private String mAge;
    /* access modifiers changed from: private */
    public String[] mAgeEntries;
    private String[] mAgeEntryValues;
    private TextView mAgeTextView;
    private DialogHelperUtil mDialogHelper;
    private String mGender;
    private String[] mGenderEntries;
    private String[] mGenderEntryValues;
    private TextView mGenderTextView;
    private String mHeight;
    /* access modifiers changed from: private */
    public String[] mHeightEntries;
    private String[] mHeightEntryValues;
    private TextView mHeightTextView;
    /* access modifiers changed from: private */
    public int mLastAddressSelectedValue;
    /* access modifiers changed from: private */
    public int mLastAgeSelectedValue;
    /* access modifiers changed from: private */
    public int mLastGenderSelectedValue;
    /* access modifiers changed from: private */
    public int mLastHeightSelectedValue;
    /* access modifiers changed from: private */
    public int mLastWeightSelectedValue;
    private Integer mSelectedPickerViewId;
    /* access modifiers changed from: private */
    public int mTempAddressSelectedValue;
    /* access modifiers changed from: private */
    public int mTempAgeSelectedValue;
    /* access modifiers changed from: private */
    public int mTempGenderSelectedValue;
    /* access modifiers changed from: private */
    public int mTempHeightSelectedValue;
    /* access modifiers changed from: private */
    public int mTempWeightSelectedValue;
    private String mWeight;
    /* access modifiers changed from: private */
    public String[] mWeightEntries;
    private String[] mWeightEntryValues;
    private TextView mWeightTextView;
    private ViewPreferenceListBinding weightBinding;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J0\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment$OnChangeUserInfoListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onCancelUserInfo", "", "onInitUserInfo", "onSend", "aGender", "", "aAge", "aHeight", "aWeight", "aAddress", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ChangeUserInfoFragment.kt */
    public interface OnChangeUserInfoListener extends BaseFragment.Callback {
        void onCancelUserInfo();

        void onInitUserInfo();

        void onSend(String str, String str2, String str3, String str4, String str5);
    }

    @JvmStatic
    public static final ChangeUserInfoFragment newInstance() {
        return Companion.newInstance();
    }

    public void onDataDialogCancelled(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onDismiss(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment$Companion;", "", "()V", "ADDRESS_LIST_ITEM_ID", "", "AGE_LIST_ITEM_ID", "GENDER_LIST_ITEM_ID", "HEIGHT_LIST_ITEM_ID", "WEIGHT_LIST_ITEM_ID", "newInstance", "Ljp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ChangeUserInfoFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChangeUserInfoFragment newInstance() {
            return new ChangeUserInfoFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        isShowHomeAsUpButton(true);
        layoutInflater.inflate(R.layout.fragment_change_user_info, viewGroup, false);
        FragmentChangeUserInfoBinding inflate = FragmentChangeUserInfoBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((Fragment) this);
        initUI(inflate);
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private final void initUI(FragmentChangeUserInfoBinding fragmentChangeUserInfoBinding) {
        setActionBarTitle(R.string.user_info_title);
        String string = getResources().getString(R.string.user_info_gender_male);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getResources().getString(R.string.user_info_gender_female);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getResources().getString(R.string.user_info_gender_other);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.mGenderEntries = new String[]{string, string2, string3};
        String[] genderValue = Gender.INSTANCE.getGenderValue();
        this.mGenderEntryValues = genderValue;
        String[] strArr = null;
        if (genderValue == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGenderEntryValues");
            genderValue = null;
        }
        String[] strArr2 = this.mGenderEntryValues;
        if (strArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGenderEntryValues");
            strArr2 = null;
        }
        this.mGender = genderValue[strArr2.length - 1];
        fragmentChangeUserInfoBinding.genderItemStub.setOnInflateListener(new ChangeUserInfoFragment$$ExternalSyntheticLambda0(this));
        fragmentChangeUserInfoBinding.genderItemStub.inflate();
        fragmentChangeUserInfoBinding.ageItemStub.setOnInflateListener(new ChangeUserInfoFragment$$ExternalSyntheticLambda1(this));
        fragmentChangeUserInfoBinding.ageItemStub.inflate();
        fragmentChangeUserInfoBinding.heightItemStub.setOnInflateListener(new ChangeUserInfoFragment$$ExternalSyntheticLambda2(this));
        fragmentChangeUserInfoBinding.heightItemStub.inflate();
        fragmentChangeUserInfoBinding.weightItemStub.setOnInflateListener(new ChangeUserInfoFragment$$ExternalSyntheticLambda3(this));
        fragmentChangeUserInfoBinding.weightItemStub.inflate();
        fragmentChangeUserInfoBinding.addressItemStub.setOnInflateListener(new ChangeUserInfoFragment$$ExternalSyntheticLambda4(this));
        fragmentChangeUserInfoBinding.addressItemStub.inflate();
        String[] stringArray = getResources().getStringArray(R.array.user_info_age_array);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        this.mAgeEntries = stringArray;
        String[] stringArray2 = getResources().getStringArray(R.array.user_info_age_array_values);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
        this.mAgeEntryValues = stringArray2;
        if (stringArray2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgeEntryValues");
            stringArray2 = null;
        }
        String[] strArr3 = this.mAgeEntryValues;
        if (strArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgeEntryValues");
            strArr3 = null;
        }
        this.mAge = stringArray2[strArr3.length - 1];
        String[] stringArray3 = getResources().getStringArray(R.array.user_info_height_array);
        Intrinsics.checkNotNullExpressionValue(stringArray3, "getStringArray(...)");
        this.mHeightEntries = stringArray3;
        String[] stringArray4 = getResources().getStringArray(R.array.user_info_height_array_values);
        Intrinsics.checkNotNullExpressionValue(stringArray4, "getStringArray(...)");
        this.mHeightEntryValues = stringArray4;
        if (stringArray4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeightEntryValues");
            stringArray4 = null;
        }
        String[] strArr4 = this.mHeightEntryValues;
        if (strArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeightEntryValues");
            strArr4 = null;
        }
        this.mHeight = stringArray4[strArr4.length - 1];
        String[] stringArray5 = getResources().getStringArray(R.array.user_info_weight_array);
        Intrinsics.checkNotNullExpressionValue(stringArray5, "getStringArray(...)");
        this.mWeightEntries = stringArray5;
        String[] stringArray6 = getResources().getStringArray(R.array.user_info_weight_array_values);
        Intrinsics.checkNotNullExpressionValue(stringArray6, "getStringArray(...)");
        this.mWeightEntryValues = stringArray6;
        if (stringArray6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeightEntryValues");
            stringArray6 = null;
        }
        String[] strArr5 = this.mWeightEntryValues;
        if (strArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeightEntryValues");
            strArr5 = null;
        }
        this.mWeight = stringArray6[strArr5.length - 1];
        String[] stringArray7 = getResources().getStringArray(R.array.user_info_location_array);
        Intrinsics.checkNotNullExpressionValue(stringArray7, "getStringArray(...)");
        this.mAddressEntry = stringArray7;
        String[] stringArray8 = getResources().getStringArray(R.array.user_info_location_array_values);
        Intrinsics.checkNotNullExpressionValue(stringArray8, "getStringArray(...)");
        this.mAddressEntryValues = stringArray8;
        if (stringArray8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressEntryValues");
            stringArray8 = null;
        }
        String[] strArr6 = this.mAddressEntryValues;
        if (strArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressEntryValues");
        } else {
            strArr = strArr6;
        }
        this.mAddress = stringArray8[strArr.length - 1];
        OnChangeUserInfoListener onChangeUserInfoListener = (OnChangeUserInfoListener) getCallback$app_prodRelease();
        if (onChangeUserInfoListener != null) {
            onChangeUserInfoListener.onInitUserInfo();
        }
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$2(ChangeUserInfoFragment changeUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(1);
        bind.getRoot().setOnClickListener(changeUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        changeUserInfoFragment.mGenderTextView = customFontTextView;
        bind.listTitle.setText(changeUserInfoFragment.getString(R.string.user_info_gender));
        bind.listValue.setText(changeUserInfoFragment.getString(R.string.user_info_gender_other));
        changeUserInfoFragment.genderBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$5(ChangeUserInfoFragment changeUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(2);
        bind.listTitle.setText(changeUserInfoFragment.getString(R.string.user_info_age));
        bind.getRoot().setOnClickListener(changeUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        TextView textView = customFontTextView;
        changeUserInfoFragment.mAgeTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgeTextView");
            textView = null;
        }
        textView.setText(changeUserInfoFragment.getString(R.string.user_info_gender_other));
        changeUserInfoFragment.ageBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$8(ChangeUserInfoFragment changeUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(3);
        bind.listTitle.setText(changeUserInfoFragment.getString(R.string.user_info_height));
        bind.getRoot().setOnClickListener(changeUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        TextView textView = customFontTextView;
        changeUserInfoFragment.mHeightTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeightTextView");
            textView = null;
        }
        textView.setText(changeUserInfoFragment.getString(R.string.user_info_gender_other));
        changeUserInfoFragment.heightBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$11(ChangeUserInfoFragment changeUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(4);
        bind.listTitle.setText(changeUserInfoFragment.getString(R.string.user_info_weight));
        bind.getRoot().setOnClickListener(changeUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        TextView textView = customFontTextView;
        changeUserInfoFragment.mWeightTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeightTextView");
            textView = null;
        }
        textView.setText(changeUserInfoFragment.getString(R.string.user_info_gender_other));
        changeUserInfoFragment.weightBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$14(ChangeUserInfoFragment changeUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(5);
        bind.listTitle.setText(changeUserInfoFragment.getString(R.string.user_info_location));
        bind.getRoot().setOnClickListener(changeUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        TextView textView = customFontTextView;
        changeUserInfoFragment.mAddressTextView = textView;
        String str = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressTextView");
            textView = null;
        }
        textView.setText(changeUserInfoFragment.getString(R.string.user_info_gender_other));
        Locale locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        if (locale != null) {
            str = locale.getLanguage();
        }
        if (Intrinsics.areEqual((Object) str, (Object) Locale.JAPANESE.toString())) {
            bind.getRoot().setVisibility(0);
        } else if (!Intrinsics.areEqual((Object) str, (Object) Locale.CHINESE.toString())) {
            bind.getRoot().setVisibility(8);
        } else if (StringsKt.equals(locale.getCountry(), "hk", true)) {
            bind.getRoot().setVisibility(0);
        } else {
            bind.getRoot().setVisibility(8);
        }
        changeUserInfoFragment.addressBinding = bind;
    }

    private final void showListDialog() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DialogHelperUtil.showDataDialog$default(dialogHelperUtil, R.string.user_info_gender, BaseDialogFragment.Builder.DialogType.RADIO, DialogHelperUtil.RequestCode.DIALOG_DURATION.ordinal(), R.string.common_ok, R.string.common_cancel, 0, 32, (Object) null).setLifecycleListener(new ChangeUserInfoFragment$showListDialog$1(this));
    }

    private final void showPickerDialog(int i) {
        Integer num;
        DialogHelperUtil dialogHelperUtil;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (i == 2) {
            String[] strArr = this.mAgeEntries;
            if (strArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeEntries");
                strArr = null;
            }
            objectRef.element = Integer.valueOf(strArr.length);
            num = Integer.valueOf(R.string.user_info_age);
        } else if (i == 3) {
            String[] strArr2 = this.mHeightEntries;
            if (strArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeightEntries");
                strArr2 = null;
            }
            objectRef.element = Integer.valueOf(strArr2.length);
            num = Integer.valueOf(R.string.user_info_height);
        } else if (i == 4) {
            String[] strArr3 = this.mWeightEntries;
            if (strArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWeightEntries");
                strArr3 = null;
            }
            objectRef.element = Integer.valueOf(strArr3.length);
            num = Integer.valueOf(R.string.user_info_weight);
        } else if (i != 5) {
            num = null;
        } else {
            String[] strArr4 = this.mAddressEntry;
            if (strArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddressEntry");
                strArr4 = null;
            }
            objectRef.element = Integer.valueOf(strArr4.length);
            num = Integer.valueOf(R.string.user_info_location);
        }
        this.mSelectedPickerViewId = Integer.valueOf(i);
        DialogHelperUtil dialogHelperUtil2 = this.mDialogHelper;
        if (dialogHelperUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        } else {
            dialogHelperUtil = dialogHelperUtil2;
        }
        Intrinsics.checkNotNull(num);
        DialogHelperUtil.showDataDialog$default(dialogHelperUtil, num.intValue(), BaseDialogFragment.Builder.DialogType.PICKER, DialogHelperUtil.RequestCode.DIALOG_TIMER.ordinal(), R.string.common_ok, R.string.common_cancel, 0, 32, (Object) null).setLifecycleListener(new ChangeUserInfoFragment$showPickerDialog$1(0, i, this, objectRef));
    }

    /* access modifiers changed from: private */
    public final void changeNumberPickerDividerColor(NumberPicker numberPicker, int i) {
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDivider");
            declaredField.setAccessible(true);
            declaredField.set(numberPicker, new ColorDrawable(i));
            Field declaredField2 = NumberPicker.class.getDeclaredField("mSelectionDividerHeight");
            declaredField2.setAccessible(true);
            declaredField2.set(numberPicker, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view == null) {
            return;
        }
        if (!isPassedEnoughTime()) {
            DebugLogUtil.INSTANCE.e("Not enough time has passed");
            return;
        }
        int id = view.getId();
        if (id == 1) {
            showListDialog();
        } else if (id == 2 || id == 3 || id == 4 || id == 5) {
            showPickerDialog(view.getId());
        }
    }

    public final void sendUserInfo() {
        OnChangeUserInfoListener onChangeUserInfoListener = (OnChangeUserInfoListener) getCallback$app_prodRelease();
        if (onChangeUserInfoListener != null) {
            String str = this.mGender;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGender");
                str = null;
            }
            String str2 = this.mAge;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAge");
                str2 = null;
            }
            String str3 = this.mHeight;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeight");
                str3 = null;
            }
            String str4 = this.mWeight;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWeight");
                str4 = null;
            }
            String str5 = this.mAddress;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddress");
                str5 = null;
            }
            onChangeUserInfoListener.onSend(str, str2, str3, str4, str5);
        }
    }

    public void onDataDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        Integer num;
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
        String[] strArr = null;
        if (i == DialogHelperUtil.RequestCode.DIALOG_DURATION.ordinal()) {
            if (i2 == -1) {
                int i3 = this.mTempGenderSelectedValue;
                this.mLastGenderSelectedValue = i3;
                TextView textView = this.mGenderTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGenderTextView");
                    textView = null;
                }
                String[] strArr2 = this.mGenderEntries;
                Intrinsics.checkNotNull(strArr2);
                textView.setText(strArr2[i3]);
                String[] strArr3 = this.mGenderEntryValues;
                if (strArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGenderEntryValues");
                } else {
                    strArr = strArr3;
                }
                this.mGender = strArr[i3];
            }
        } else if (i == DialogHelperUtil.RequestCode.DIALOG_TIMER.ordinal() && i2 == -1 && (num = this.mSelectedPickerViewId) != null) {
            int intValue = num.intValue();
            if (intValue == 2) {
                this.mLastAgeSelectedValue = this.mTempAgeSelectedValue;
                TextView textView2 = this.mAgeTextView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAgeTextView");
                    textView2 = null;
                }
                String[] strArr4 = this.mAgeEntries;
                if (strArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAgeEntries");
                    strArr4 = null;
                }
                textView2.setText(strArr4[this.mTempAgeSelectedValue]);
                String[] strArr5 = this.mAgeEntryValues;
                if (strArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAgeEntryValues");
                } else {
                    strArr = strArr5;
                }
                this.mAge = strArr[this.mTempAgeSelectedValue];
            } else if (intValue == 3) {
                this.mLastHeightSelectedValue = this.mTempHeightSelectedValue;
                TextView textView3 = this.mHeightTextView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeightTextView");
                    textView3 = null;
                }
                String[] strArr6 = this.mHeightEntries;
                if (strArr6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeightEntries");
                    strArr6 = null;
                }
                textView3.setText(strArr6[this.mTempHeightSelectedValue]);
                String[] strArr7 = this.mHeightEntryValues;
                if (strArr7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeightEntryValues");
                } else {
                    strArr = strArr7;
                }
                this.mHeight = strArr[this.mTempHeightSelectedValue];
            } else if (intValue == 4) {
                this.mLastWeightSelectedValue = this.mTempWeightSelectedValue;
                TextView textView4 = this.mWeightTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWeightTextView");
                    textView4 = null;
                }
                String[] strArr8 = this.mWeightEntries;
                if (strArr8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWeightEntries");
                    strArr8 = null;
                }
                textView4.setText(strArr8[this.mTempWeightSelectedValue]);
                String[] strArr9 = this.mWeightEntryValues;
                if (strArr9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWeightEntryValues");
                } else {
                    strArr = strArr9;
                }
                this.mWeight = strArr[this.mTempWeightSelectedValue];
            } else if (intValue == 5) {
                this.mLastAddressSelectedValue = this.mTempAddressSelectedValue;
                TextView textView5 = this.mAddressTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddressTextView");
                    textView5 = null;
                }
                String[] strArr10 = this.mAddressEntry;
                if (strArr10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddressEntry");
                    strArr10 = null;
                }
                textView5.setText(strArr10[this.mTempAddressSelectedValue]);
                String[] strArr11 = this.mAddressEntryValues;
                if (strArr11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddressEntryValues");
                } else {
                    strArr = strArr11;
                }
                this.mAddress = strArr[this.mTempAddressSelectedValue];
            }
        }
    }

    public final void doInitDataSetting(String str, String str2, String str3, String str4, String str5) {
        int i;
        Intrinsics.checkNotNullParameter(str, "aGender");
        Intrinsics.checkNotNullParameter(str2, "aAge");
        Intrinsics.checkNotNullParameter(str3, "aHeight");
        Intrinsics.checkNotNullParameter(str4, "aWeight");
        Intrinsics.checkNotNullParameter(str5, "aState");
        String[] strArr = this.mGenderEntryValues;
        String[] strArr2 = null;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGenderEntryValues");
            strArr = null;
        }
        this.mLastGenderSelectedValue = ArraysKt.indexOf((T[]) strArr, str);
        String[] strArr3 = this.mAgeEntryValues;
        if (strArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgeEntryValues");
            strArr3 = null;
        }
        this.mLastAgeSelectedValue = ArraysKt.indexOf((T[]) strArr3, str2);
        String[] strArr4 = this.mHeightEntryValues;
        if (strArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeightEntryValues");
            strArr4 = null;
        }
        this.mLastHeightSelectedValue = ArraysKt.indexOf((T[]) strArr4, str3);
        String[] strArr5 = this.mWeightEntryValues;
        if (strArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeightEntryValues");
            strArr5 = null;
        }
        this.mLastWeightSelectedValue = ArraysKt.indexOf((T[]) strArr5, str4);
        String[] strArr6 = this.mAddressEntryValues;
        if (strArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressEntryValues");
            strArr6 = null;
        }
        if (ArraysKt.indexOf((T[]) strArr6, str5) == -1) {
            String[] strArr7 = this.mAddressEntry;
            if (strArr7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddressEntry");
                strArr7 = null;
            }
            i = strArr7.length - 1;
        } else {
            String[] strArr8 = this.mAddressEntryValues;
            if (strArr8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddressEntryValues");
                strArr8 = null;
            }
            i = ArraysKt.indexOf((T[]) strArr8, str5);
        }
        this.mLastAddressSelectedValue = i;
        TextView textView = this.mGenderTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGenderTextView");
            textView = null;
        }
        String[] strArr9 = this.mGenderEntries;
        Intrinsics.checkNotNull(strArr9);
        textView.setText(strArr9[this.mLastGenderSelectedValue]);
        TextView textView2 = this.mAgeTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgeTextView");
            textView2 = null;
        }
        String[] strArr10 = this.mAgeEntries;
        if (strArr10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgeEntries");
            strArr10 = null;
        }
        textView2.setText(strArr10[this.mLastAgeSelectedValue]);
        TextView textView3 = this.mHeightTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeightTextView");
            textView3 = null;
        }
        String[] strArr11 = this.mHeightEntries;
        if (strArr11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeightEntries");
            strArr11 = null;
        }
        textView3.setText(strArr11[this.mLastHeightSelectedValue]);
        TextView textView4 = this.mWeightTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeightTextView");
            textView4 = null;
        }
        String[] strArr12 = this.mWeightEntries;
        if (strArr12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeightEntries");
            strArr12 = null;
        }
        textView4.setText(strArr12[this.mLastWeightSelectedValue]);
        TextView textView5 = this.mAddressTextView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressTextView");
            textView5 = null;
        }
        String[] strArr13 = this.mAddressEntry;
        if (strArr13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressEntry");
            strArr13 = null;
        }
        textView5.setText(strArr13[this.mLastAddressSelectedValue]);
        String[] strArr14 = this.mGenderEntryValues;
        if (strArr14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGenderEntryValues");
            strArr14 = null;
        }
        this.mGender = strArr14[this.mLastGenderSelectedValue];
        String[] strArr15 = this.mAgeEntryValues;
        if (strArr15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgeEntryValues");
            strArr15 = null;
        }
        this.mAge = strArr15[this.mLastAgeSelectedValue];
        String[] strArr16 = this.mHeightEntryValues;
        if (strArr16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeightEntryValues");
            strArr16 = null;
        }
        this.mHeight = strArr16[this.mLastHeightSelectedValue];
        String[] strArr17 = this.mWeightEntryValues;
        if (strArr17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeightEntryValues");
            strArr17 = null;
        }
        this.mWeight = strArr17[this.mLastWeightSelectedValue];
        String[] strArr18 = this.mAddressEntryValues;
        if (strArr18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressEntryValues");
        } else {
            strArr2 = strArr18;
        }
        this.mAddress = strArr2[this.mLastAddressSelectedValue];
    }
}
