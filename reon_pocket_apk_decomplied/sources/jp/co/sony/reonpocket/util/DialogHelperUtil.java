package jp.co.sony.reonpocket.util;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import jp.co.sony.reonpocket.view.fragment.AlertDialogFragment;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002JC\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0016J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010JH\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J8\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u001e\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001fJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "", "aActivity", "Landroidx/fragment/app/FragmentActivity;", "aParentFragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "createAlertDialogFragmentBuilder", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment$Builder;", "createDataDialogFragmentBuilder", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Builder;", "createProgressDialogFragmentBuilder", "Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment$Builder;", "showConfirmationDialog", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "aTitle", "", "aMessage", "aImage", "aRequestCode", "aPositiveLabel", "aNegativeLabel", "(IIIILjava/lang/Integer;Ljava/lang/Integer;)Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "", "showDataDialog", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "aView", "Landroid/view/View;", "aType", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Builder$DialogType;", "isCancel", "", "showProgressDialog", "Landroid/content/DialogInterface;", "aTag", "aCancelable", "Companion", "RequestCode", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DialogHelperUtil.kt */
public final class DialogHelperUtil {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NO_RESOURCE = 0;
    private final FragmentActivity aActivity;
    private final Fragment aParentFragment;

    public DialogHelperUtil() {
        this((FragmentActivity) null, (Fragment) null, 3, (DefaultConstructorMarker) null);
    }

    public DialogHelperUtil(FragmentActivity fragmentActivity, Fragment fragment) {
        this.aActivity = fragmentActivity;
        this.aParentFragment = fragment;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogHelperUtil(FragmentActivity fragmentActivity, Fragment fragment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : fragmentActivity, (i & 2) != 0 ? null : fragment);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b$\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Ljp/co/sony/reonpocket/util/DialogHelperUtil$RequestCode;", "", "(Ljava/lang/String;I)V", "REQUEST_DFU", "CONFIRM_DFU", "NO_REQUEST", "DFU_COMPLETE", "DFU_FAILED", "INFORMATION", "EULA", "PASSWORD_SETTING", "FORCE_UPDATE", "BLUETOOTH_NOT_SETTING", "BLUETOOTH_TURN_ON_FAILED", "LOCATION_NOT_SETTING", "CONNECT_FAILED", "ACTION_FAILED", "DISCONNECT", "CONNECT_SUSPENDED", "SETTING_INITIALIZE", "SETTING_UNREGISTER", "DIALOG_TIMER", "WITH_SUPPORT", "REQUEST_LOCATION", "SETTING_LOCATION", "DIALOG_DURATION", "TAG_BASE", "TAG_SINGLE_BUTTON", "TAG_DOUBLE_BUTTON", "REQUEST_NEARBY_DEVICES", "SETTING_MENU_POPUP", "TAG_UPDATE_DIALOG", "TAG_UNREGISTER", "SMART_MODE_SWITCH_COOL_TEMP", "SMART_MODE_SWITCH_WARM_TEMP", "TAG_DFU_COMPLETE", "TAG_DFU_FAILED", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DialogHelperUtil.kt */
    public enum RequestCode {
        REQUEST_DFU,
        CONFIRM_DFU,
        NO_REQUEST,
        DFU_COMPLETE,
        DFU_FAILED,
        INFORMATION,
        EULA,
        PASSWORD_SETTING,
        FORCE_UPDATE,
        BLUETOOTH_NOT_SETTING,
        BLUETOOTH_TURN_ON_FAILED,
        LOCATION_NOT_SETTING,
        CONNECT_FAILED,
        ACTION_FAILED,
        DISCONNECT,
        CONNECT_SUSPENDED,
        SETTING_INITIALIZE,
        SETTING_UNREGISTER,
        DIALOG_TIMER,
        WITH_SUPPORT,
        REQUEST_LOCATION,
        SETTING_LOCATION,
        DIALOG_DURATION,
        TAG_BASE,
        TAG_SINGLE_BUTTON,
        TAG_DOUBLE_BUTTON,
        REQUEST_NEARBY_DEVICES,
        SETTING_MENU_POPUP,
        TAG_UPDATE_DIALOG,
        TAG_UNREGISTER,
        SMART_MODE_SWITCH_COOL_TEMP,
        SMART_MODE_SWITCH_WARM_TEMP,
        TAG_DFU_COMPLETE,
        TAG_DFU_FAILED;

        public static EnumEntries<RequestCode> getEntries() {
            return $ENTRIES;
        }

        static {
            RequestCode[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    private final AlertDialogFragment.Builder createAlertDialogFragmentBuilder() {
        if (this.aActivity != null) {
            return new AlertDialogFragment.Builder(this.aActivity, (Fragment) null, 2, (DefaultConstructorMarker) null);
        }
        return new AlertDialogFragment.Builder((FragmentActivity) null, this.aParentFragment, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AlertDialogFragment showConfirmationDialog$default(DialogHelperUtil dialogHelperUtil, int i, int i2, int i3, int i4, Integer num, Integer num2, int i5, Object obj) {
        return dialogHelperUtil.showConfirmationDialog(i, i2, i3, i4, (i5 & 16) != 0 ? null : num, (i5 & 32) != 0 ? null : num2);
    }

    public final AlertDialogFragment showConfirmationDialog(int i, int i2, int i3, int i4, Integer num, Integer num2) {
        AlertDialogFragment.Builder createAlertDialogFragmentBuilder = createAlertDialogFragmentBuilder();
        if (i > 0) {
            createAlertDialogFragmentBuilder.setTitle(i);
        }
        if (i2 > 0) {
            createAlertDialogFragmentBuilder.setMessage(i2);
        }
        if (i3 > 0) {
            createAlertDialogFragmentBuilder.setImage(i3);
        }
        if (num != null) {
            createAlertDialogFragmentBuilder.setPositiveButton(num.intValue());
        }
        if (num2 != null) {
            createAlertDialogFragmentBuilder.setNegativeButton(num2.intValue());
        }
        createAlertDialogFragmentBuilder.requestCode(i4);
        createAlertDialogFragmentBuilder.tag(String.valueOf(i4));
        DialogFragment show = createAlertDialogFragmentBuilder.show();
        Intrinsics.checkNotNull(show, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.AlertDialogFragment");
        return (AlertDialogFragment) show;
    }

    public final AlertDialogFragment showConfirmationDialog(int i, String str, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "aMessage");
        AlertDialogFragment.Builder createAlertDialogFragmentBuilder = createAlertDialogFragmentBuilder();
        if (i > 0) {
            createAlertDialogFragmentBuilder.setTitle(i);
        }
        if (!TextUtils.isEmpty(str)) {
            createAlertDialogFragmentBuilder.setMessage(str);
        }
        if (i2 > 0) {
            createAlertDialogFragmentBuilder.setImage(i2);
        }
        createAlertDialogFragmentBuilder.setPositiveButton(i4);
        createAlertDialogFragmentBuilder.setNegativeButton(i5);
        createAlertDialogFragmentBuilder.requestCode(i3);
        createAlertDialogFragmentBuilder.tag(String.valueOf(i3));
        DialogFragment show = createAlertDialogFragmentBuilder.show();
        Intrinsics.checkNotNull(show, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.AlertDialogFragment");
        return (AlertDialogFragment) show;
    }

    public final AlertDialogFragment showConfirmationDialog(String str, String str2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "aTitle");
        Intrinsics.checkNotNullParameter(str2, "aMessage");
        AlertDialogFragment.Builder createAlertDialogFragmentBuilder = createAlertDialogFragmentBuilder();
        if (!TextUtils.isEmpty(str)) {
            createAlertDialogFragmentBuilder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            createAlertDialogFragmentBuilder.setMessage(str2);
        }
        if (i > 0) {
            createAlertDialogFragmentBuilder.setImage(i);
        }
        createAlertDialogFragmentBuilder.setPositiveButton(i3);
        createAlertDialogFragmentBuilder.setNegativeButton(i4);
        createAlertDialogFragmentBuilder.requestCode(i2);
        createAlertDialogFragmentBuilder.tag(String.valueOf(i2));
        DialogFragment show = createAlertDialogFragmentBuilder.show();
        Intrinsics.checkNotNull(show, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.AlertDialogFragment");
        return (AlertDialogFragment) show;
    }

    public final DialogInterface showProgressDialog(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "aMessage");
        Intrinsics.checkNotNullParameter(str2, "aTag");
        ProgressDialogFragment.Builder createProgressDialogFragmentBuilder = createProgressDialogFragmentBuilder();
        createProgressDialogFragmentBuilder.setMessage(str);
        createProgressDialogFragmentBuilder.tag(str2);
        createProgressDialogFragmentBuilder.setCancelable(z);
        createProgressDialogFragmentBuilder.show();
        DialogInterface dialog = createProgressDialogFragmentBuilder.getDialog();
        Intrinsics.checkNotNull(dialog);
        return dialog;
    }

    public final DialogInterface showProgressDialog(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "aTag");
        ProgressDialogFragment.Builder createProgressDialogFragmentBuilder = createProgressDialogFragmentBuilder();
        createProgressDialogFragmentBuilder.setMessage(i);
        createProgressDialogFragmentBuilder.tag(str);
        createProgressDialogFragmentBuilder.setCancelable(z);
        createProgressDialogFragmentBuilder.show();
        DialogInterface dialog = createProgressDialogFragmentBuilder.getDialog();
        Intrinsics.checkNotNull(dialog);
        return dialog;
    }

    private final ProgressDialogFragment.Builder createProgressDialogFragmentBuilder() {
        if (this.aActivity != null) {
            return new ProgressDialogFragment.Builder(this.aActivity, (Fragment) null, 2, (DefaultConstructorMarker) null);
        }
        return new ProgressDialogFragment.Builder((FragmentActivity) null, this.aParentFragment, 1, (DefaultConstructorMarker) null);
    }

    private final DataDialogFragment.Builder createDataDialogFragmentBuilder() {
        if (this.aActivity != null) {
            return new DataDialogFragment.Builder(this.aActivity, (Fragment) null, 2, (DefaultConstructorMarker) null);
        }
        return new DataDialogFragment.Builder((FragmentActivity) null, this.aParentFragment, 1, (DefaultConstructorMarker) null);
    }

    public final DataDialogFragment showDataDialog(int i, int i2, int i3, int i4, int i5) {
        DataDialogFragment.Builder createDataDialogFragmentBuilder = createDataDialogFragmentBuilder();
        if (i > 0) {
            createDataDialogFragmentBuilder.setTitle(i);
        }
        if (i2 > 0) {
            createDataDialogFragmentBuilder.setView(i2);
        }
        createDataDialogFragmentBuilder.setPositiveButton(i4);
        createDataDialogFragmentBuilder.setNegativeButton(i5);
        createDataDialogFragmentBuilder.requestCode(i3);
        createDataDialogFragmentBuilder.tag(String.valueOf(i3));
        DialogFragment show = createDataDialogFragmentBuilder.show();
        Intrinsics.checkNotNull(show, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.DataDialogFragment");
        return (DataDialogFragment) show;
    }

    public final DataDialogFragment showDataDialog(int i, View view, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "aView");
        DataDialogFragment.Builder createDataDialogFragmentBuilder = createDataDialogFragmentBuilder();
        if (i > 0) {
            createDataDialogFragmentBuilder.setTitle(i);
        }
        createDataDialogFragmentBuilder.setView(view);
        createDataDialogFragmentBuilder.setPositiveButton(i3);
        createDataDialogFragmentBuilder.setNegativeButton(i4);
        createDataDialogFragmentBuilder.requestCode(i2);
        createDataDialogFragmentBuilder.tag(String.valueOf(i2));
        DialogFragment show = createDataDialogFragmentBuilder.show();
        Intrinsics.checkNotNull(show, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.DataDialogFragment");
        return (DataDialogFragment) show;
    }

    public final DataDialogFragment showDataDialog(String str, BaseDialogFragment.Builder.DialogType dialogType, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "aTitle");
        Intrinsics.checkNotNullParameter(dialogType, "aType");
        DataDialogFragment.Builder createDataDialogFragmentBuilder = createDataDialogFragmentBuilder();
        createDataDialogFragmentBuilder.setTitle(str);
        createDataDialogFragmentBuilder.setType(dialogType);
        createDataDialogFragmentBuilder.setPositiveButton(i2);
        createDataDialogFragmentBuilder.setNegativeButton(i3);
        createDataDialogFragmentBuilder.requestCode(i);
        createDataDialogFragmentBuilder.tag(String.valueOf(i));
        DialogFragment show = createDataDialogFragmentBuilder.show();
        Intrinsics.checkNotNull(show, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.DataDialogFragment");
        return (DataDialogFragment) show;
    }

    public static /* synthetic */ DataDialogFragment showDataDialog$default(DialogHelperUtil dialogHelperUtil, int i, BaseDialogFragment.Builder.DialogType dialogType, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 32) != 0) {
            i5 = 0;
        }
        return dialogHelperUtil.showDataDialog(i, dialogType, i2, i3, i4, i5);
    }

    public final DataDialogFragment showDataDialog(int i, BaseDialogFragment.Builder.DialogType dialogType, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(dialogType, "aType");
        DataDialogFragment.Builder createDataDialogFragmentBuilder = createDataDialogFragmentBuilder();
        if (i > 0) {
            createDataDialogFragmentBuilder.setTitle(i);
        }
        if (i5 > 0) {
            createDataDialogFragmentBuilder.setMessage(i5);
        }
        createDataDialogFragmentBuilder.setType(dialogType);
        createDataDialogFragmentBuilder.setPositiveButton(i3);
        createDataDialogFragmentBuilder.setNegativeButton(i4);
        createDataDialogFragmentBuilder.requestCode(i2);
        createDataDialogFragmentBuilder.tag(String.valueOf(i2));
        DialogFragment show = createDataDialogFragmentBuilder.show();
        Intrinsics.checkNotNull(show, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.DataDialogFragment");
        return (DataDialogFragment) show;
    }

    public static /* synthetic */ DataDialogFragment showDataDialog$default(DialogHelperUtil dialogHelperUtil, int i, BaseDialogFragment.Builder.DialogType dialogType, int i2, int i3, int i4, boolean z, int i5, int i6, Object obj) {
        return dialogHelperUtil.showDataDialog((i6 & 1) != 0 ? 0 : i, dialogType, i2, (i6 & 8) != 0 ? 0 : i3, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) != 0 ? false : z, (i6 & 64) != 0 ? 0 : i5);
    }

    public final DataDialogFragment showDataDialog(int i, BaseDialogFragment.Builder.DialogType dialogType, int i2, int i3, int i4, boolean z, int i5) {
        Intrinsics.checkNotNullParameter(dialogType, "aType");
        DataDialogFragment.Builder createDataDialogFragmentBuilder = createDataDialogFragmentBuilder();
        if (i > 0) {
            createDataDialogFragmentBuilder.setTitle(i);
        }
        if (i5 > 0) {
            createDataDialogFragmentBuilder.setMessage(i5);
        }
        createDataDialogFragmentBuilder.setType(dialogType);
        createDataDialogFragmentBuilder.setPositiveButton(i3);
        createDataDialogFragmentBuilder.setNegativeButton(i4);
        createDataDialogFragmentBuilder.requestCode(i2);
        createDataDialogFragmentBuilder.tag(String.valueOf(i2));
        createDataDialogFragmentBuilder.setCancelable(z);
        DialogFragment show = createDataDialogFragmentBuilder.show();
        Intrinsics.checkNotNull(show, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.DataDialogFragment");
        return (DataDialogFragment) show;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/util/DialogHelperUtil$Companion;", "", "()V", "NO_RESOURCE", "", "newInstance", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "aParentFragment", "Landroidx/fragment/app/Fragment;", "aActivity", "Landroidx/fragment/app/FragmentActivity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DialogHelperUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DialogHelperUtil newInstance(FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
            return new DialogHelperUtil(fragmentActivity, (Fragment) null, 2, (DefaultConstructorMarker) null);
        }

        public final DialogHelperUtil newInstance(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "aParentFragment");
            return new DialogHelperUtil((FragmentActivity) null, fragment, 1, (DefaultConstructorMarker) null);
        }
    }
}
