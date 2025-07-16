package jp.co.sony.reonpocket.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.io.Serializable;
import java.lang.reflect.Field;
import jp.co.sony.reonpocket.util.BitmapUtil;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0005./012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\u0017\u0010\"\u001a\u0004\u0018\u0001H#\"\u0004\b\u0000\u0010#H\u0000¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u001a\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u00063"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface;", "()V", "dialogTag", "", "getDialogTag", "()Ljava/lang/String;", "mCallback", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Callback;", "getMCallback", "()Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Callback;", "setMCallback", "(Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Callback;)V", "mListener", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "getMListener", "()Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "setMListener", "(Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;)V", "mParam", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Param;", "getMParam", "()Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Param;", "setMParam", "(Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Param;)V", "requestCode", "", "getRequestCode", "()I", "cancel", "", "dismiss", "dismissAllowingStateLoss", "getCallback", "T", "getCallback$app_prodRelease", "()Ljava/lang/Object;", "onAttach", "context", "Landroid/content/Context;", "onDetach", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "Builder", "Callback", "Companion", "DialogFragmentLifecycleListener", "Param", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseDialogFragment.kt */
public abstract class BaseDialogFragment extends DialogFragment implements DialogInterface {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_ARGUMENT = "key_argument";
    private Callback mCallback;
    private DialogFragmentLifecycleListener mListener;
    private Param mParam;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Callback;", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseDialogFragment.kt */
    public interface Callback {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseDialogFragment.kt */
    public interface DialogFragmentLifecycleListener {
        void onViewCreated(View view);
    }

    /* access modifiers changed from: protected */
    public final Param getMParam() {
        return this.mParam;
    }

    /* access modifiers changed from: protected */
    public final void setMParam(Param param) {
        this.mParam = param;
    }

    /* access modifiers changed from: protected */
    public final Callback getMCallback() {
        return this.mCallback;
    }

    /* access modifiers changed from: protected */
    public final void setMCallback(Callback callback) {
        this.mCallback = callback;
    }

    /* access modifiers changed from: protected */
    public final DialogFragmentLifecycleListener getMListener() {
        return this.mListener;
    }

    /* access modifiers changed from: protected */
    public final void setMListener(DialogFragmentLifecycleListener dialogFragmentLifecycleListener) {
        this.mListener = dialogFragmentLifecycleListener;
    }

    /* access modifiers changed from: protected */
    public final int getRequestCode() {
        Param param = this.mParam;
        Intrinsics.checkNotNull(param);
        return param.getMRequestCode$app_prodRelease();
    }

    /* access modifiers changed from: protected */
    public final String getDialogTag() {
        Param param = this.mParam;
        Intrinsics.checkNotNull(param);
        return param.getMTag$app_prodRelease();
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Object targetFragment = getTargetFragment();
        if (targetFragment == null && (targetFragment = getActivity()) == null) {
            this.mCallback = null;
        } else if (targetFragment instanceof Callback) {
            this.mCallback = (Callback) targetFragment;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mCallback = null;
    }

    public void show(FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        if (!fragmentManager.isDestroyed()) {
            try {
                Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
                declaredField.setAccessible(true);
                declaredField.set(this, false);
                Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
                declaredField2.setAccessible(true);
                declaredField2.set(this, true);
            } catch (NoSuchFieldException unused) {
                DebugLogUtil.INSTANCE.e("failed to access private member.");
            } catch (IllegalAccessException unused2) {
                DebugLogUtil.INSTANCE.e("failed to access private member.");
            } catch (IllegalArgumentException unused3) {
                DebugLogUtil.INSTANCE.e("failed to access private member.");
            }
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public void cancel() {
        dismissAllowingStateLoss();
    }

    public void dismiss() {
        dismissAllowingStateLoss();
    }

    public void dismissAllowingStateLoss() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            try {
                super.dismissAllowingStateLoss();
            } catch (IllegalStateException unused) {
                DebugLogUtil.INSTANCE.e("failed to dismiss.");
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001c\u0010$\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010'\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+¨\u00066"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Param;", "Ljava/io/Serializable;", "()V", "mCancelable", "", "getMCancelable$app_prodRelease", "()Z", "setMCancelable$app_prodRelease", "(Z)V", "mImage", "", "getMImage$app_prodRelease", "()[B", "setMImage$app_prodRelease", "([B)V", "mMessage", "", "getMMessage$app_prodRelease", "()Ljava/lang/String;", "setMMessage$app_prodRelease", "(Ljava/lang/String;)V", "mNegativeLabel", "getMNegativeLabel$app_prodRelease", "setMNegativeLabel$app_prodRelease", "mPositiveLabel", "getMPositiveLabel$app_prodRelease", "setMPositiveLabel$app_prodRelease", "mRequestCode", "", "getMRequestCode$app_prodRelease", "()I", "setMRequestCode$app_prodRelease", "(I)V", "mTag", "getMTag$app_prodRelease", "setMTag$app_prodRelease", "mTitle", "getMTitle$app_prodRelease", "setMTitle$app_prodRelease", "mType", "getMType$app_prodRelease", "()Ljava/lang/Integer;", "setMType$app_prodRelease", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mView", "Landroid/view/View;", "getMView$app_prodRelease", "()Landroid/view/View;", "setMView$app_prodRelease", "(Landroid/view/View;)V", "mViewRes", "getMViewRes$app_prodRelease", "setMViewRes$app_prodRelease", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseDialogFragment.kt */
    protected static final class Param implements Serializable {
        private boolean mCancelable;
        private byte[] mImage;
        private String mMessage;
        private String mNegativeLabel;
        private String mPositiveLabel;
        private int mRequestCode = -1;
        private String mTag = "default";
        private String mTitle;
        private Integer mType;
        private View mView;
        private Integer mViewRes;

        public final String getMTitle$app_prodRelease() {
            return this.mTitle;
        }

        public final void setMTitle$app_prodRelease(String str) {
            this.mTitle = str;
        }

        public final String getMMessage$app_prodRelease() {
            return this.mMessage;
        }

        public final void setMMessage$app_prodRelease(String str) {
            this.mMessage = str;
        }

        public final byte[] getMImage$app_prodRelease() {
            return this.mImage;
        }

        public final void setMImage$app_prodRelease(byte[] bArr) {
            this.mImage = bArr;
        }

        public final View getMView$app_prodRelease() {
            return this.mView;
        }

        public final void setMView$app_prodRelease(View view) {
            this.mView = view;
        }

        public final Integer getMViewRes$app_prodRelease() {
            return this.mViewRes;
        }

        public final void setMViewRes$app_prodRelease(Integer num) {
            this.mViewRes = num;
        }

        public final Integer getMType$app_prodRelease() {
            return this.mType;
        }

        public final void setMType$app_prodRelease(Integer num) {
            this.mType = num;
        }

        public final String getMPositiveLabel$app_prodRelease() {
            return this.mPositiveLabel;
        }

        public final void setMPositiveLabel$app_prodRelease(String str) {
            this.mPositiveLabel = str;
        }

        public final String getMNegativeLabel$app_prodRelease() {
            return this.mNegativeLabel;
        }

        public final void setMNegativeLabel$app_prodRelease(String str) {
            this.mNegativeLabel = str;
        }

        public final int getMRequestCode$app_prodRelease() {
            return this.mRequestCode;
        }

        public final void setMRequestCode$app_prodRelease(int i) {
            this.mRequestCode = i;
        }

        public final String getMTag$app_prodRelease() {
            return this.mTag;
        }

        public final void setMTag$app_prodRelease(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mTag = str;
        }

        public final boolean getMCancelable$app_prodRelease() {
            return this.mCancelable;
        }

        public final void setMCancelable$app_prodRelease(boolean z) {
            this.mCancelable = z;
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0001+B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0004J\b\u0010\u000f\u001a\u00020\u0010H$J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0013J\b\u0010(\u001a\u0004\u0018\u00010\u0010J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u001bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Builder;", "", "aActivity", "Landroidx/fragment/app/FragmentActivity;", "aParentFragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "mParam", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Param;", "createArgument", "Landroid/os/Bundle;", "createInstance", "Landroidx/fragment/app/DialogFragment;", "requestCode", "aRequestCode", "", "setCancelable", "aCancelable", "", "setImage", "aImage", "setMessage", "aMessage", "", "setNegativeButton", "aNegativeLabel", "setPositiveButton", "aPositiveLabel", "setTitle", "aTitle", "setType", "aType", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Builder$DialogType;", "setView", "aView", "Landroid/view/View;", "show", "tag", "aTag", "DialogType", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseDialogFragment.kt */
    public static abstract class Builder {
        public static final int $stable = 8;
        private final FragmentActivity aActivity;
        private final Fragment aParentFragment;
        private final Param mParam;

        public Builder() {
            this((FragmentActivity) null, (Fragment) null, 3, (DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: protected */
        public abstract DialogFragment createInstance();

        public Builder(FragmentActivity fragmentActivity, Fragment fragment) {
            this.aActivity = fragmentActivity;
            this.aParentFragment = fragment;
            this.mParam = new Param();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(FragmentActivity fragmentActivity, Fragment fragment, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : fragmentActivity, (i & 2) != 0 ? null : fragment);
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Builder$DialogType;", "", "(Ljava/lang/String;I)V", "PICKER", "RADIO", "PROGRESS", "PASSWORD", "INFORMATION_PATTERN_2", "INFORMATION_PATTERN_3", "INFORMATION", "EULA_PP", "TAG_SINGLE_BUTTON", "TAG_DOUBLE_BUTTON", "SETTING_MENU_POPUP", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: BaseDialogFragment.kt */
        public enum DialogType {
            PICKER,
            RADIO,
            PROGRESS,
            PASSWORD,
            INFORMATION_PATTERN_2,
            INFORMATION_PATTERN_3,
            INFORMATION,
            EULA_PP,
            TAG_SINGLE_BUTTON,
            TAG_DOUBLE_BUTTON,
            SETTING_MENU_POPUP;

            public static EnumEntries<DialogType> getEntries() {
                return $ENTRIES;
            }

            static {
                DialogType[] $values;
                $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            }
        }

        private final Context getContext() {
            FragmentActivity fragmentActivity = this.aActivity;
            if (fragmentActivity != null) {
                return fragmentActivity;
            }
            Fragment fragment = this.aParentFragment;
            return fragment != null ? fragment.getActivity() : null;
        }

        public final Builder setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "aTitle");
            this.mParam.setMTitle$app_prodRelease(str);
            return this;
        }

        public final Builder setTitle(int i) {
            if (i == 0) {
                return this;
            }
            Context context = getContext();
            if (context == null) {
                return this;
            }
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return setTitle(string);
        }

        public final Builder setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "aMessage");
            this.mParam.setMMessage$app_prodRelease(str);
            return this;
        }

        public final Builder setMessage(int i) {
            if (i == 0) {
                return this;
            }
            Context context = getContext();
            if (context == null) {
                return this;
            }
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return setMessage(string);
        }

        public final Builder setImage(int i) {
            Context context;
            if (!(i == 0 || (context = getContext()) == null)) {
                this.mParam.setMImage$app_prodRelease(BitmapUtil.INSTANCE.convertBitmapToByteArray(BitmapFactory.decodeResource(context.getResources(), i)));
            }
            return this;
        }

        public final Builder setView(int i) {
            Context context;
            if (!(i == 0 || (context = getContext()) == null)) {
                this.mParam.setMView$app_prodRelease(LayoutInflater.from(context).inflate(i, (ViewGroup) null));
            }
            return this;
        }

        public final Builder setView(View view) {
            Intrinsics.checkNotNullParameter(view, "aView");
            this.mParam.setMView$app_prodRelease(view);
            return this;
        }

        public final Builder setType(DialogType dialogType) {
            Intrinsics.checkNotNullParameter(dialogType, "aType");
            this.mParam.setMType$app_prodRelease(Integer.valueOf(dialogType.ordinal()));
            return this;
        }

        public final Builder setPositiveButton(String str) {
            Intrinsics.checkNotNullParameter(str, "aPositiveLabel");
            this.mParam.setMPositiveLabel$app_prodRelease(str);
            return this;
        }

        public final Builder setPositiveButton(int i) {
            Context context = getContext();
            if (context == null || i <= 0) {
                return this;
            }
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return setPositiveButton(string);
        }

        public final Builder setNegativeButton(String str) {
            Intrinsics.checkNotNullParameter(str, "aNegativeLabel");
            this.mParam.setMNegativeLabel$app_prodRelease(str);
            return this;
        }

        public final Builder setNegativeButton(int i) {
            Context context = getContext();
            if (context == null || i <= 0) {
                return this;
            }
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return setNegativeButton(string);
        }

        public final Builder requestCode(int i) {
            this.mParam.setMRequestCode$app_prodRelease(i);
            return this;
        }

        public final Builder tag(String str) {
            Intrinsics.checkNotNullParameter(str, "aTag");
            this.mParam.setMTag$app_prodRelease(str);
            return this;
        }

        public final Builder setCancelable(boolean z) {
            this.mParam.setMCancelable$app_prodRelease(z);
            return this;
        }

        public final DialogFragment show() {
            FragmentManager fragmentManager;
            Fragment fragment = this.aParentFragment;
            if (fragment != null) {
                fragmentManager = fragment.requireActivity().getSupportFragmentManager();
                Intrinsics.checkNotNull(fragmentManager);
            } else {
                FragmentActivity fragmentActivity = this.aActivity;
                if (fragmentActivity == null) {
                    return null;
                }
                fragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(fragmentManager, "getSupportFragmentManager(...)");
            }
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(this.mParam.getMTag$app_prodRelease());
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            DialogFragment createInstance = createInstance();
            createInstance.setArguments(createArgument());
            Fragment fragment2 = this.aParentFragment;
            if (fragment2 != null) {
                createInstance.setTargetFragment(fragment2, this.mParam.getMRequestCode$app_prodRelease());
            }
            createInstance.show(fragmentManager, this.mParam.getMTag$app_prodRelease());
            return createInstance;
        }

        /* access modifiers changed from: protected */
        public final Bundle createArgument() {
            Bundle bundle = new Bundle();
            bundle.putSerializable(BaseDialogFragment.KEY_ARGUMENT, this.mParam);
            return bundle;
        }
    }

    public final <T> T getCallback$app_prodRelease() {
        try {
            return (Object) this.mCallback;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$Companion;", "", "()V", "KEY_ARGUMENT", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
