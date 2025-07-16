package jp.co.sony.reonpocket.modules.settings.view;

import android.view.View;
import android.widget.NumberPicker;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment$showPickerDialog$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChangeUserInfoFragment.kt */
public final class ChangeUserInfoFragment$showPickerDialog$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ int $aViewId;
    final /* synthetic */ Ref.ObjectRef<Integer> $maxValue;
    final /* synthetic */ int $minValue;
    final /* synthetic */ ChangeUserInfoFragment this$0;

    ChangeUserInfoFragment$showPickerDialog$1(int i, int i2, ChangeUserInfoFragment changeUserInfoFragment, Ref.ObjectRef<Integer> objectRef) {
        this.$minValue = i;
        this.$aViewId = i2;
        this.this$0 = changeUserInfoFragment;
        this.$maxValue = objectRef;
    }

    public void onViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "aView");
        View findViewById = view.findViewById(R.id.numberPicker);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        NumberPicker numberPicker = (NumberPicker) findViewById;
        numberPicker.setMinValue(this.$minValue);
        numberPicker.setWrapSelectorWheel(false);
        int i = this.$aViewId;
        String[] strArr = null;
        if (i == 2) {
            String[] access$getMAgeEntries$p = this.this$0.mAgeEntries;
            if (access$getMAgeEntries$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeEntries");
                access$getMAgeEntries$p = null;
            }
            numberPicker.setDisplayedValues(access$getMAgeEntries$p);
            String[] access$getMAgeEntries$p2 = this.this$0.mAgeEntries;
            if (access$getMAgeEntries$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeEntries");
            } else {
                strArr = access$getMAgeEntries$p2;
            }
            numberPicker.setMaxValue(strArr.length - 1);
            numberPicker.setValue(this.this$0.mLastAgeSelectedValue);
            numberPicker.setOnValueChangedListener(new ChangeUserInfoFragment$showPickerDialog$1$$ExternalSyntheticLambda0(this.this$0));
        } else if (i == 3) {
            String[] access$getMHeightEntries$p = this.this$0.mHeightEntries;
            if (access$getMHeightEntries$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeightEntries");
                access$getMHeightEntries$p = null;
            }
            numberPicker.setDisplayedValues(access$getMHeightEntries$p);
            String[] access$getMHeightEntries$p2 = this.this$0.mHeightEntries;
            if (access$getMHeightEntries$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeightEntries");
            } else {
                strArr = access$getMHeightEntries$p2;
            }
            numberPicker.setMaxValue(strArr.length - 1);
            numberPicker.setValue(this.this$0.mLastHeightSelectedValue);
            numberPicker.setOnValueChangedListener(new ChangeUserInfoFragment$showPickerDialog$1$$ExternalSyntheticLambda1(this.this$0));
        } else if (i == 4) {
            String[] access$getMWeightEntries$p = this.this$0.mWeightEntries;
            if (access$getMWeightEntries$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWeightEntries");
                access$getMWeightEntries$p = null;
            }
            numberPicker.setDisplayedValues(access$getMWeightEntries$p);
            String[] access$getMWeightEntries$p2 = this.this$0.mWeightEntries;
            if (access$getMWeightEntries$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWeightEntries");
            } else {
                strArr = access$getMWeightEntries$p2;
            }
            numberPicker.setMaxValue(strArr.length - 1);
            numberPicker.setValue(this.this$0.mLastWeightSelectedValue);
            numberPicker.setOnValueChangedListener(new ChangeUserInfoFragment$showPickerDialog$1$$ExternalSyntheticLambda2(this.this$0));
        } else if (i == 5) {
            String[] access$getMAddressEntry$p = this.this$0.mAddressEntry;
            if (access$getMAddressEntry$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddressEntry");
                access$getMAddressEntry$p = null;
            }
            numberPicker.setDisplayedValues(access$getMAddressEntry$p);
            String[] access$getMAddressEntry$p2 = this.this$0.mAddressEntry;
            if (access$getMAddressEntry$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddressEntry");
            } else {
                strArr = access$getMAddressEntry$p2;
            }
            numberPicker.setMaxValue(strArr.length - 1);
            numberPicker.setValue(this.this$0.mLastAddressSelectedValue);
            numberPicker.setOnValueChangedListener(new ChangeUserInfoFragment$showPickerDialog$1$$ExternalSyntheticLambda3(this.this$0));
        }
        T t = this.$maxValue.element;
        Intrinsics.checkNotNull(t);
        numberPicker.setMaxValue(((Number) t).intValue() - 1);
        ChangeUserInfoFragment changeUserInfoFragment = this.this$0;
        changeUserInfoFragment.changeNumberPickerDividerColor(numberPicker, changeUserInfoFragment.getResources().getColor(R.color.colorTransparent));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(ChangeUserInfoFragment changeUserInfoFragment, NumberPicker numberPicker, int i, int i2) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        changeUserInfoFragment.mTempAgeSelectedValue = i2;
        changeUserInfoFragment.mLastAgeSelectedValue = changeUserInfoFragment.mTempAgeSelectedValue;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(ChangeUserInfoFragment changeUserInfoFragment, NumberPicker numberPicker, int i, int i2) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        changeUserInfoFragment.mTempHeightSelectedValue = i2;
        changeUserInfoFragment.mLastHeightSelectedValue = changeUserInfoFragment.mTempHeightSelectedValue;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ChangeUserInfoFragment changeUserInfoFragment, NumberPicker numberPicker, int i, int i2) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        changeUserInfoFragment.mTempWeightSelectedValue = i2;
        changeUserInfoFragment.mLastWeightSelectedValue = changeUserInfoFragment.mTempWeightSelectedValue;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(ChangeUserInfoFragment changeUserInfoFragment, NumberPicker numberPicker, int i, int i2) {
        Intrinsics.checkNotNullParameter(changeUserInfoFragment, "this$0");
        changeUserInfoFragment.mTempAddressSelectedValue = i2;
        changeUserInfoFragment.mLastAddressSelectedValue = changeUserInfoFragment.mTempAddressSelectedValue;
    }
}
