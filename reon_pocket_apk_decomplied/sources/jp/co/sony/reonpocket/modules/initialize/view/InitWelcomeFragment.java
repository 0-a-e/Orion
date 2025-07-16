package jp.co.sony.reonpocket.modules.initialize.view;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import java.io.Serializable;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.databinding.FragmentWelcomeBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentWelcomeBinding;", "changeBtnState", "", "aState", "", "initUI", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onResume", "rangeOfIndex", "Lkotlin/ranges/IntRange;", "", "string", "Companion", "Eula", "OnNextStepListener", "PrivacyPolicy", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InitWelcomeFragment.kt */
public final class InitWelcomeFragment extends BaseFragment {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentWelcomeBinding binding;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$OnNextStepListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onNextStep", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: InitWelcomeFragment.kt */
    public interface OnNextStepListener extends BaseFragment.Callback {
        void onNextStep();
    }

    @JvmStatic
    public static final InitWelcomeFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Companion;", "", "()V", "newInstance", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: InitWelcomeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InitWelcomeFragment newInstance() {
            return new InitWelcomeFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentWelcomeBinding inflate = FragmentWelcomeBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        initUI(inflate);
        return inflate.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private final IntRange rangeOfIndex(String str, String str2) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, true, 2, (Object) null);
        return RangesKt.until(indexOf$default, str2.length() + indexOf$default);
    }

    private final void initUI(FragmentWelcomeBinding fragmentWelcomeBinding) {
        CustomFontTextView customFontTextView = fragmentWelcomeBinding.welcomeConfirm;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "welcomeConfirm");
        String string = getString(R.string.welcome_confirm);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.welcome_license);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        IntRange rangeOfIndex = rangeOfIndex(string, string2);
        MyContentUtil myContentUtil = MyContentUtil.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string3 = getString(R.string.welcome_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        IntRange rangeOfIndex2 = rangeOfIndex(string, string3);
        MyContentUtil myContentUtil2 = MyContentUtil.INSTANCE;
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new InitWelcomeFragment$initUI$eulaUrlSpan$1(MyContentUtil.getEulaURL$default(myContentUtil, requireContext, (String) null, (String) null, 6, (Object) null)), rangeOfIndex.getFirst(), rangeOfIndex.getLast() + 1, 34);
        spannableString.setSpan(new InitWelcomeFragment$initUI$ppUrlSpan$1(MyContentUtil.getPrivacyURL$default(myContentUtil2, requireContext2, (String) null, (String) null, 6, (Object) null)), rangeOfIndex2.getFirst(), rangeOfIndex2.getLast() + 1, 34);
        customFontTextView.setText(spannableString);
        customFontTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void onActivityCreated(Bundle bundle) {
        CustomFontButton customFontButton;
        CheckBox checkBox;
        super.onActivityCreated(bundle);
        FragmentWelcomeBinding fragmentWelcomeBinding = this.binding;
        if (!(fragmentWelcomeBinding == null || (checkBox = fragmentWelcomeBinding.welcomeCheckbox) == null)) {
            checkBox.setOnClickListener(this);
        }
        FragmentWelcomeBinding fragmentWelcomeBinding2 = this.binding;
        if (fragmentWelcomeBinding2 != null && (customFontButton = fragmentWelcomeBinding2.acceptBtn) != null) {
            customFontButton.setOnClickListener(this);
        }
    }

    private final void changeBtnState(boolean z) {
        FragmentWelcomeBinding fragmentWelcomeBinding = this.binding;
        CustomFontButton customFontButton = fragmentWelcomeBinding != null ? fragmentWelcomeBinding.acceptBtn : null;
        if (customFontButton != null) {
            customFontButton.setEnabled(z);
        }
    }

    public void onClick(View view) {
        FragmentWelcomeBinding fragmentWelcomeBinding;
        CheckBox checkBox;
        super.onClick(view);
        if (view == null) {
            return;
        }
        if (!isPassedEnoughTime()) {
            DebugLogUtil.INSTANCE.e("Not enough time has passed");
            return;
        }
        int id = view.getId();
        if (id == R.id.acceptBtn) {
            OnNextStepListener onNextStepListener = (OnNextStepListener) getCallback$app_prodRelease();
            if (onNextStepListener != null) {
                onNextStepListener.onNextStep();
            }
        } else if (id == R.id.welcome_checkbox && (fragmentWelcomeBinding = this.binding) != null && (checkBox = fragmentWelcomeBinding.welcomeCheckbox) != null) {
            changeBtnState(checkBox.isChecked());
        }
    }

    public void onResume() {
        CheckBox checkBox;
        super.onResume();
        FragmentWelcomeBinding fragmentWelcomeBinding = this.binding;
        if (fragmentWelcomeBinding != null && (checkBox = fragmentWelcomeBinding.welcomeCheckbox) != null) {
            changeBtnState(checkBox.isChecked());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "Ljava/io/Serializable;", "version", "", "date", "", "country", "(ILjava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getDate", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: InitWelcomeFragment.kt */
    public static final class Eula implements Serializable {
        public static final int $stable = 0;
        private final String country;
        private final String date;
        private final int version;

        public static /* synthetic */ Eula copy$default(Eula eula, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = eula.version;
            }
            if ((i2 & 2) != 0) {
                str = eula.date;
            }
            if ((i2 & 4) != 0) {
                str2 = eula.country;
            }
            return eula.copy(i, str, str2);
        }

        public final int component1() {
            return this.version;
        }

        public final String component2() {
            return this.date;
        }

        public final String component3() {
            return this.country;
        }

        public final Eula copy(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "date");
            Intrinsics.checkNotNullParameter(str2, "country");
            return new Eula(i, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Eula)) {
                return false;
            }
            Eula eula = (Eula) obj;
            return this.version == eula.version && Intrinsics.areEqual((Object) this.date, (Object) eula.date) && Intrinsics.areEqual((Object) this.country, (Object) eula.country);
        }

        public int hashCode() {
            return (((this.version * 31) + this.date.hashCode()) * 31) + this.country.hashCode();
        }

        public String toString() {
            int i = this.version;
            String str = this.date;
            String str2 = this.country;
            return "Eula(version=" + i + ", date=" + str + ", country=" + str2 + ")";
        }

        public Eula(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "date");
            Intrinsics.checkNotNullParameter(str2, "country");
            this.version = i;
            this.date = str;
            this.country = str2;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getDate() {
            return this.date;
        }

        public final String getCountry() {
            return this.country;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "Ljava/io/Serializable;", "version", "", "date", "", "country", "(ILjava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getDate", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: InitWelcomeFragment.kt */
    public static final class PrivacyPolicy implements Serializable {
        public static final int $stable = 0;
        private final String country;
        private final String date;
        private final int version;

        public static /* synthetic */ PrivacyPolicy copy$default(PrivacyPolicy privacyPolicy, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = privacyPolicy.version;
            }
            if ((i2 & 2) != 0) {
                str = privacyPolicy.date;
            }
            if ((i2 & 4) != 0) {
                str2 = privacyPolicy.country;
            }
            return privacyPolicy.copy(i, str, str2);
        }

        public final int component1() {
            return this.version;
        }

        public final String component2() {
            return this.date;
        }

        public final String component3() {
            return this.country;
        }

        public final PrivacyPolicy copy(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "date");
            Intrinsics.checkNotNullParameter(str2, "country");
            return new PrivacyPolicy(i, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrivacyPolicy)) {
                return false;
            }
            PrivacyPolicy privacyPolicy = (PrivacyPolicy) obj;
            return this.version == privacyPolicy.version && Intrinsics.areEqual((Object) this.date, (Object) privacyPolicy.date) && Intrinsics.areEqual((Object) this.country, (Object) privacyPolicy.country);
        }

        public int hashCode() {
            return (((this.version * 31) + this.date.hashCode()) * 31) + this.country.hashCode();
        }

        public String toString() {
            int i = this.version;
            String str = this.date;
            String str2 = this.country;
            return "PrivacyPolicy(version=" + i + ", date=" + str + ", country=" + str2 + ")";
        }

        public PrivacyPolicy(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "date");
            Intrinsics.checkNotNullParameter(str2, "country");
            this.version = i;
            this.date = str;
            this.country = str2;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getDate() {
            return this.date;
        }

        public final String getCountry() {
            return this.country;
        }
    }
}
