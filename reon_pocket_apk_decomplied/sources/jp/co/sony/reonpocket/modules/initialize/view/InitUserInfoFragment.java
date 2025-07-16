package jp.co.sony.reonpocket.modules.initialize.view;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.ConfigurationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.lang.reflect.Field;
import java.util.Locale;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.common.Gender;
import jp.co.sony.reonpocket.databinding.FragmentUserInfoBinding;
import jp.co.sony.reonpocket.databinding.ViewPreferenceListBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0002TUB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u0018\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\"H\u0003J\u0010\u0010=\u001a\u0002062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010>\u001a\u0002062\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u0002062\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J&\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0018\u0010I\u001a\u0002062\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\"H\u0016J \u0010M\u001a\u0002062\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\"2\u0006\u0010N\u001a\u00020\"H\u0016J\b\u0010O\u001a\u000206H\u0016J\u0018\u0010P\u001a\u0002062\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\"H\u0016J\b\u0010Q\u001a\u000206H\u0002J\u0010\u0010R\u001a\u0002062\u0006\u0010S\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0016\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u001c\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010 \u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u00103\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitUserInfoFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "()V", "addressBinding", "Ljp/co/sony/reonpocket/databinding/ViewPreferenceListBinding;", "ageBinding", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentUserInfoBinding;", "genderBinding", "heightBinding", "mAddress", "", "mAddressEntry", "", "[Ljava/lang/String;", "mAddressEntryValues", "mAddressTextView", "Landroid/widget/TextView;", "mAge", "mAgeEntries", "mAgeEntryValues", "mAgeTextView", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mGender", "mGenderEntries", "mGenderEntryValues", "mGenderTextView", "mHeight", "mHeightEntries", "mHeightEntryValues", "mHeightTextView", "mLastAddressSelectedValue", "", "mLastAgeSelectedValue", "mLastGenderSelectedValue", "mLastHeightSelectedValue", "mLastWeightSelectedValue", "mSelectedPickerViewId", "Ljava/lang/Integer;", "mTempAddressSelectedValue", "mTempAgeSelectedValue", "mTempGenderSelectedValue", "mTempHeightSelectedValue", "mTempWeightSelectedValue", "mToolBar", "Landroidx/appcompat/widget/Toolbar;", "mWeight", "mWeightEntries", "mWeightEntryValues", "mWeightTextView", "weightBinding", "changeNextBtnState", "", "aIsEnabled", "", "changeNumberPickerDividerColor", "aNumberPicker", "Landroid/widget/NumberPicker;", "aColor", "initUI", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDataDialogCancelled", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "onDataDialogSucceeded", "aResultCode", "onDestroyView", "onDismiss", "showListDialog", "showPickerDialog", "aViewId", "Companion", "OnSendUserInfoListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InitUserInfoFragment.kt */
public final class InitUserInfoFragment extends BaseFragment implements DataDialogFragment.Callback {
    public static final int $stable = 8;
    private static final int ADDRESS_LIST_ITEM_ID = 5;
    private static final int AGE_LIST_ITEM_ID = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int GENDER_LIST_ITEM_ID = 1;
    private static final int HEIGHT_LIST_ITEM_ID = 3;
    private static final int WEIGHT_LIST_ITEM_ID = 4;
    private ViewPreferenceListBinding addressBinding;
    private ViewPreferenceListBinding ageBinding;
    private FragmentUserInfoBinding binding;
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
    private Toolbar mToolBar;
    private String mWeight;
    /* access modifiers changed from: private */
    public String[] mWeightEntries;
    private String[] mWeightEntryValues;
    private TextView mWeightTextView;
    private ViewPreferenceListBinding weightBinding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitUserInfoFragment$OnSendUserInfoListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onSend", "", "aGender", "", "aAge", "aHeight", "aWeight", "aAddress", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: InitUserInfoFragment.kt */
    public interface OnSendUserInfoListener extends BaseFragment.Callback {
        void onSend(String str, String str2, String str3, String str4, String str5);
    }

    @JvmStatic
    public static final InitUserInfoFragment newInstance() {
        return Companion.newInstance();
    }

    public void onDataDialogCancelled(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onDismiss(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitUserInfoFragment$Companion;", "", "()V", "ADDRESS_LIST_ITEM_ID", "", "AGE_LIST_ITEM_ID", "GENDER_LIST_ITEM_ID", "HEIGHT_LIST_ITEM_ID", "WEIGHT_LIST_ITEM_ID", "newInstance", "Ljp/co/sony/reonpocket/modules/initialize/view/InitUserInfoFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: InitUserInfoFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InitUserInfoFragment newInstance() {
            return new InitUserInfoFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentUserInfoBinding inflate = FragmentUserInfoBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((Fragment) this);
        initUI(inflate);
        return inflate.getRoot();
    }

    private final void initUI(FragmentUserInfoBinding fragmentUserInfoBinding) {
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
        fragmentUserInfoBinding.genderItemStub.setOnInflateListener(new InitUserInfoFragment$$ExternalSyntheticLambda0(this));
        fragmentUserInfoBinding.genderItemStub.inflate();
        fragmentUserInfoBinding.ageItemStub.setOnInflateListener(new InitUserInfoFragment$$ExternalSyntheticLambda1(this));
        fragmentUserInfoBinding.ageItemStub.inflate();
        fragmentUserInfoBinding.heightItemStub.setOnInflateListener(new InitUserInfoFragment$$ExternalSyntheticLambda2(this));
        fragmentUserInfoBinding.heightItemStub.inflate();
        fragmentUserInfoBinding.weightItemStub.setOnInflateListener(new InitUserInfoFragment$$ExternalSyntheticLambda3(this));
        fragmentUserInfoBinding.weightItemStub.inflate();
        fragmentUserInfoBinding.addressItemStub.setOnInflateListener(new InitUserInfoFragment$$ExternalSyntheticLambda4(this));
        fragmentUserInfoBinding.addressItemStub.inflate();
        Toolbar toolbar = fragmentUserInfoBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        this.mToolBar = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolBar");
            toolbar = null;
        }
        toolbar.setNavigationIcon(R.drawable.ic_back);
        Toolbar toolbar2 = this.mToolBar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolBar");
            toolbar2 = null;
        }
        toolbar2.setOnClickListener(this);
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
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$2(InitUserInfoFragment initUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(initUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(1);
        bind.getRoot().setOnClickListener(initUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        initUserInfoFragment.mGenderTextView = customFontTextView;
        bind.listTitle.setText(initUserInfoFragment.getString(R.string.user_info_gender));
        bind.listValue.setText(initUserInfoFragment.getString(R.string.user_info_gender_other));
        initUserInfoFragment.genderBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$5(InitUserInfoFragment initUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(initUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(2);
        bind.listTitle.setText(initUserInfoFragment.getString(R.string.user_info_age));
        bind.getRoot().setOnClickListener(initUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        TextView textView = customFontTextView;
        initUserInfoFragment.mAgeTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgeTextView");
            textView = null;
        }
        textView.setText(initUserInfoFragment.getString(R.string.user_info_gender_other));
        initUserInfoFragment.ageBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$8(InitUserInfoFragment initUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(initUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(3);
        bind.listTitle.setText(initUserInfoFragment.getString(R.string.user_info_height));
        bind.getRoot().setOnClickListener(initUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        TextView textView = customFontTextView;
        initUserInfoFragment.mHeightTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeightTextView");
            textView = null;
        }
        textView.setText(initUserInfoFragment.getString(R.string.user_info_gender_other));
        initUserInfoFragment.heightBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$11(InitUserInfoFragment initUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(initUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(4);
        bind.listTitle.setText(initUserInfoFragment.getString(R.string.user_info_weight));
        bind.getRoot().setOnClickListener(initUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        TextView textView = customFontTextView;
        initUserInfoFragment.mWeightTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeightTextView");
            textView = null;
        }
        textView.setText(initUserInfoFragment.getString(R.string.user_info_gender_other));
        initUserInfoFragment.weightBinding = bind;
    }

    /* access modifiers changed from: private */
    public static final void initUI$lambda$14(InitUserInfoFragment initUserInfoFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(initUserInfoFragment, "this$0");
        ViewPreferenceListBinding bind = ViewPreferenceListBinding.bind(view);
        bind.getRoot().setId(5);
        bind.listTitle.setText(initUserInfoFragment.getString(R.string.user_info_location));
        bind.getRoot().setOnClickListener(initUserInfoFragment);
        CustomFontTextView customFontTextView = bind.listValue;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "listValue");
        TextView textView = customFontTextView;
        initUserInfoFragment.mAddressTextView = textView;
        String str = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressTextView");
            textView = null;
        }
        textView.setText(initUserInfoFragment.getString(R.string.user_info_gender_other));
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
        initUserInfoFragment.addressBinding = bind;
    }

    public void onActivityCreated(Bundle bundle) {
        CustomFontButton customFontButton;
        super.onActivityCreated(bundle);
        FragmentUserInfoBinding fragmentUserInfoBinding = this.binding;
        if (fragmentUserInfoBinding != null && (customFontButton = fragmentUserInfoBinding.nextBtn) != null) {
            customFontButton.setOnClickListener(this);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
        this.genderBinding = null;
        this.ageBinding = null;
        this.heightBinding = null;
        this.weightBinding = null;
        this.addressBinding = null;
    }

    private final void showListDialog() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DialogHelperUtil.showDataDialog$default(dialogHelperUtil, R.string.user_info_gender, BaseDialogFragment.Builder.DialogType.RADIO, DialogHelperUtil.RequestCode.DIALOG_DURATION.ordinal(), R.string.common_ok, R.string.common_cancel, 0, 32, (Object) null).setLifecycleListener(new InitUserInfoFragment$showListDialog$1(this));
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
        DialogHelperUtil.showDataDialog$default(dialogHelperUtil, num.intValue(), BaseDialogFragment.Builder.DialogType.PICKER, DialogHelperUtil.RequestCode.DIALOG_TIMER.ordinal(), R.string.common_ok, R.string.common_cancel, 0, 32, (Object) null).setLifecycleListener(new InitUserInfoFragment$showPickerDialog$1(0, i, this, objectRef));
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
        if (id == 2 || id == 3 || id == 4 || id == 5) {
            showPickerDialog(view.getId());
        } else if (id == 1) {
            showListDialog();
        } else if (id == R.id.nextBtn) {
            OnSendUserInfoListener onSendUserInfoListener = (OnSendUserInfoListener) getCallback$app_prodRelease();
            if (onSendUserInfoListener != null) {
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
                onSendUserInfoListener.onSend(str, str2, str3, str4, str5);
            }
        } else {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStack();
            }
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

    public final void changeNextBtnState(boolean z) {
        FragmentUserInfoBinding fragmentUserInfoBinding = this.binding;
        CustomFontButton customFontButton = fragmentUserInfoBinding != null ? fragmentUserInfoBinding.nextBtn : null;
        if (customFontButton != null) {
            customFontButton.setEnabled(z);
        }
    }
}
