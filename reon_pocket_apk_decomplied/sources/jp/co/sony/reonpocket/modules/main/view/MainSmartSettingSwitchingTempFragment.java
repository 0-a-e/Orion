package jp.co.sony.reonpocket.modules.main.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DensityUtil;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.SmartSettingCoolTempView;
import jp.co.sony.reonpocket.view.SmartSettingWarmTempView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartSettingSwitchingTempFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "coachingIcon", "Landroid/widget/ImageView;", "mCoolInitText", "Landroid/widget/TextView;", "mCoolInitView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mCoolTempPopTextView", "mCoolTempTextView", "Ljp/co/sony/reonpocket/view/SmartSettingCoolTempView;", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "mWarmInitText", "mWarmInitView", "mWarmTempPopTextView", "mWarmTempTextView", "Ljp/co/sony/reonpocket/view/SmartSettingWarmTempView;", "tempView", "Landroid/widget/LinearLayout;", "initUi", "", "aView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "parentModalSwipeEnabled", "aIsEnable", "", "setCoolInitTextTransparent", "isNormal", "setCoolTempViewSlideLimit", "setGradientTemp", "setTouchAction", "setWarmTempViewSlideLimit", "Companion", "SmartSwitchThresholdListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartSettingSwitchingTempFragment.kt */
public final class MainSmartSettingSwitchingTempFragment extends BaseFragment {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ImageView coachingIcon;
    private TextView mCoolInitText;
    private ConstraintLayout mCoolInitView;
    private TextView mCoolTempPopTextView;
    /* access modifiers changed from: private */
    public SmartSettingCoolTempView mCoolTempTextView;
    private UserInfoInteractorInput mUserInfoInteractor = new UserInfoInteractor();
    private TextView mWarmInitText;
    private ConstraintLayout mWarmInitView;
    private TextView mWarmTempPopTextView;
    /* access modifiers changed from: private */
    public SmartSettingWarmTempView mWarmTempTextView;
    private LinearLayout tempView;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartSettingSwitchingTempFragment$SmartSwitchThresholdListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onSmartSwitchThresholdSelected", "", "coolTempSwitchThreshold", "", "warmTempStepSwitchThreshold", "setSwipeEnabled", "aIsOn", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartSettingSwitchingTempFragment.kt */
    public interface SmartSwitchThresholdListener extends BaseFragment.Callback {
        void onSmartSwitchThresholdSelected(double d, double d2);

        void setSwipeEnabled(boolean z);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartSettingSwitchingTempFragment$Companion;", "", "()V", "newInstance", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartSettingSwitchingTempFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartSettingSwitchingTempFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MainSmartSettingSwitchingTempFragment newInstance() {
            return new MainSmartSettingSwitchingTempFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_setting_switting_temp, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        initUi(inflate);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        UserInfoInteractorInput userInfoInteractorInput = this.mUserInfoInteractor;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        Boolean smartCoachingAnimeIsDisplay = userInfoInteractorInput.getSmartCoachingAnimeIsDisplay(requireContext);
        if (smartCoachingAnimeIsDisplay == null || smartCoachingAnimeIsDisplay.booleanValue()) {
            ImageView imageView = this.coachingIcon;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            SmartSettingCoolTempView smartSettingCoolTempView = this.mCoolTempTextView;
            if (smartSettingCoolTempView != null) {
                int calculatePositionFromTemp = smartSettingCoolTempView.calculatePositionFromTemp(25.0f);
                SmartSettingCoolTempView smartSettingCoolTempView2 = this.mCoolTempTextView;
                if (smartSettingCoolTempView2 != null) {
                    int calculatePositionFromTemp2 = smartSettingCoolTempView2.calculatePositionFromTemp(27.5f);
                    int i = calculatePositionFromTemp2 - calculatePositionFromTemp;
                    SmartSettingCoolTempView smartSettingCoolTempView3 = this.mCoolTempTextView;
                    if (smartSettingCoolTempView3 != null) {
                        TranslateAnimation translateAnimation = new TranslateAnimation(smartSettingCoolTempView3.getX(), smartSettingCoolTempView3.getX(), smartSettingCoolTempView3.getY(), (float) i);
                        translateAnimation.setDuration(1000);
                        translateAnimation.setFillAfter(true);
                        translateAnimation.setAnimationListener(new MainSmartSettingSwitchingTempFragment$onResume$1$1(smartSettingCoolTempView3, calculatePositionFromTemp2, this));
                        SmartSettingCoolTempView smartSettingCoolTempView4 = this.mCoolTempTextView;
                        if (smartSettingCoolTempView4 != null) {
                            smartSettingCoolTempView4.startAnimation(translateAnimation);
                        }
                        SmartSettingCoolTempView smartSettingCoolTempView5 = this.mCoolTempTextView;
                        if (smartSettingCoolTempView5 != null) {
                            smartSettingCoolTempView5.setTextStyle(true);
                        }
                        ConstraintLayout constraintLayout = this.mCoolInitView;
                        if (constraintLayout != null) {
                            constraintLayout.setVisibility(4);
                        }
                        ConstraintLayout constraintLayout2 = this.mWarmInitView;
                        if (constraintLayout2 != null) {
                            constraintLayout2.setVisibility(4);
                        }
                        double d = ((double) 1000) / (5.0d + ((double) 1));
                        Handler handler = new Handler();
                        Ref.DoubleRef doubleRef = new Ref.DoubleRef();
                        doubleRef.element = 25.0d;
                        handler.postDelayed(new MainSmartSettingSwitchingTempFragment$onResume$1$2(smartSettingCoolTempView3, this, doubleRef, 27.5d, handler, d), (long) d);
                    }
                    ImageView imageView2 = this.coachingIcon;
                    if (imageView2 != null) {
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(imageView2.getX(), imageView2.getX(), imageView2.getY(), (float) i);
                        translateAnimation2.setDuration(1000);
                        translateAnimation2.setFillAfter(true);
                        translateAnimation2.setAnimationListener(new MainSmartSettingSwitchingTempFragment$onResume$2$1(imageView2, calculatePositionFromTemp2));
                        imageView2.startAnimation(translateAnimation2);
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda9(this), 2000);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$4(MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment) {
        Intrinsics.checkNotNullParameter(mainSmartSettingSwitchingTempFragment, "this$0");
        ImageView imageView = mainSmartSettingSwitchingTempFragment.coachingIcon;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        TextView textView = mainSmartSettingSwitchingTempFragment.mCoolTempPopTextView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda1(mainSmartSettingSwitchingTempFragment), 3000);
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$4$lambda$3(MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment) {
        Intrinsics.checkNotNullParameter(mainSmartSettingSwitchingTempFragment, "this$0");
        TextView textView = mainSmartSettingSwitchingTempFragment.mCoolTempPopTextView;
        if (textView != null) {
            textView.setVisibility(4);
        }
        TextView textView2 = mainSmartSettingSwitchingTempFragment.mWarmTempPopTextView;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda0(mainSmartSettingSwitchingTempFragment), 3000);
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$4$lambda$3$lambda$2(MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment) {
        Intrinsics.checkNotNullParameter(mainSmartSettingSwitchingTempFragment, "this$0");
        TextView textView = mainSmartSettingSwitchingTempFragment.mWarmTempPopTextView;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ConstraintLayout constraintLayout = mainSmartSettingSwitchingTempFragment.mCoolInitView;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = mainSmartSettingSwitchingTempFragment.mWarmInitView;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
    }

    private final void initUi(View view) {
        int i;
        this.mCoolTempTextView = (SmartSettingCoolTempView) view.findViewById(R.id.cool_temp_text_view);
        this.mWarmTempTextView = (SmartSettingWarmTempView) view.findViewById(R.id.warm_temp_text_view);
        this.tempView = (LinearLayout) view.findViewById(R.id.gradeLinearLayout);
        this.coachingIcon = (ImageView) view.findViewById(R.id.coaching_icon);
        this.mCoolTempPopTextView = (TextView) view.findViewById(R.id.cool_temp_text_view_pop);
        this.mWarmTempPopTextView = (TextView) view.findViewById(R.id.warm_temp_text_view_pop);
        this.mCoolInitView = (ConstraintLayout) view.findViewById(R.id.cool_temp_initial_view);
        this.mWarmInitView = (ConstraintLayout) view.findViewById(R.id.warm_temp_initial_view);
        this.mCoolInitText = (TextView) view.findViewById(R.id.cool_temp_initial_text_view);
        this.mWarmInitText = (TextView) view.findViewById(R.id.warm_temp_initial_text_view);
        setCoolTempViewSlideLimit();
        setWarmTempViewSlideLimit();
        setTouchAction();
        SmartSettingCoolTempView smartSettingCoolTempView = this.mCoolTempTextView;
        if (smartSettingCoolTempView != null) {
            smartSettingCoolTempView.post(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda2(this));
        }
        SmartSettingWarmTempView smartSettingWarmTempView = this.mWarmTempTextView;
        if (smartSettingWarmTempView != null) {
            smartSettingWarmTempView.post(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda3(this));
        }
        ImageView imageView = this.coachingIcon;
        if (imageView != null) {
            SmartSettingCoolTempView smartSettingCoolTempView2 = this.mCoolTempTextView;
            if (smartSettingCoolTempView2 != null) {
                i = smartSettingCoolTempView2.calculatePositionFromTemp(smartSettingCoolTempView2 != null ? smartSettingCoolTempView2.getCurrentTemp() : 25.0f);
            } else {
                i = (int) imageView.getY();
            }
            DensityUtil densityUtil = DensityUtil.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            int dip2px = densityUtil.dip2px(requireContext, 40.0f);
            imageView.post(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda4(imageView, i + (dip2px / 2), dip2px));
        }
        view.findViewById(R.id.smart_setting_space).setOnClickListener(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda5(this));
        ((CustomFontButton) view.findViewById(R.id.do_setting)).setOnClickListener(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda6(this));
        ConstraintLayout constraintLayout = this.mCoolInitView;
        if (constraintLayout != null) {
            SmartSettingCoolTempView smartSettingCoolTempView3 = this.mCoolTempTextView;
            constraintLayout.post(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda7(constraintLayout, smartSettingCoolTempView3 != null ? smartSettingCoolTempView3.calculatePositionFromTemp(25.0f) : (int) constraintLayout.getY()));
        }
        ConstraintLayout constraintLayout2 = this.mWarmInitView;
        if (constraintLayout2 != null) {
            SmartSettingWarmTempView smartSettingWarmTempView2 = this.mWarmTempTextView;
            constraintLayout2.post(new MainSmartSettingSwitchingTempFragment$$ExternalSyntheticLambda8(constraintLayout2, smartSettingWarmTempView2 != null ? smartSettingWarmTempView2.calculatePositionFromTemp(20.0f) : (int) constraintLayout2.getY()));
        }
        TextView textView = this.mCoolInitText;
        if (textView != null) {
            textView.setText(getString(R.string.mainview_smart_favorite_change_condition_cool_default));
        }
        TextView textView2 = this.mWarmInitText;
        if (textView2 != null) {
            textView2.setText(getString(R.string.mainview_smart_favorite_change_condition_warm_default));
        }
        setCoolInitTextTransparent(true);
        ConstraintLayout constraintLayout3 = this.mCoolInitView;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(0);
        }
        ConstraintLayout constraintLayout4 = this.mWarmInitView;
        if (constraintLayout4 != null) {
            constraintLayout4.setVisibility(0);
        }
        setGradientTemp(view);
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$5(MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment) {
        Intrinsics.checkNotNullParameter(mainSmartSettingSwitchingTempFragment, "this$0");
        SmartSettingCoolTempView smartSettingCoolTempView = mainSmartSettingSwitchingTempFragment.mCoolTempTextView;
        if (smartSettingCoolTempView != null) {
            smartSettingCoolTempView.initPosition();
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$6(MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment) {
        Intrinsics.checkNotNullParameter(mainSmartSettingSwitchingTempFragment, "this$0");
        SmartSettingWarmTempView smartSettingWarmTempView = mainSmartSettingSwitchingTempFragment.mWarmTempTextView;
        if (smartSettingWarmTempView != null) {
            smartSettingWarmTempView.initPosition();
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$8$lambda$7(ImageView imageView, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "$it");
        imageView.layout((int) imageView.getX(), i, ((int) imageView.getX()) + imageView.getWidth(), i2 + i);
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$9(MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment, View view) {
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(mainSmartSettingSwitchingTempFragment, "this$0");
        FragmentManager fragmentManager = mainSmartSettingSwitchingTempFragment.getFragmentManager();
        if (fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(mainSmartSettingSwitchingTempFragment)) != null) {
            remove.commit();
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$11$lambda$10(MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment, View view) {
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(mainSmartSettingSwitchingTempFragment, "this$0");
        SmartSwitchThresholdListener smartSwitchThresholdListener = (SmartSwitchThresholdListener) mainSmartSettingSwitchingTempFragment.getCallback$app_prodRelease();
        if (smartSwitchThresholdListener != null) {
            SmartSettingCoolTempView smartSettingCoolTempView = mainSmartSettingSwitchingTempFragment.mCoolTempTextView;
            double d = 25.0d;
            double currentTemp = smartSettingCoolTempView != null ? (double) smartSettingCoolTempView.getCurrentTemp() : 25.0d;
            SmartSettingWarmTempView smartSettingWarmTempView = mainSmartSettingSwitchingTempFragment.mWarmTempTextView;
            if (smartSettingWarmTempView != null) {
                d = (double) smartSettingWarmTempView.getCurrentTemp();
            }
            smartSwitchThresholdListener.onSmartSwitchThresholdSelected(currentTemp, d);
        }
        FragmentManager fragmentManager = mainSmartSettingSwitchingTempFragment.getFragmentManager();
        if (!(fragmentManager == null || (beginTransaction = fragmentManager.beginTransaction()) == null || (remove = beginTransaction.remove(mainSmartSettingSwitchingTempFragment)) == null)) {
            remove.commit();
        }
        UserInfoInteractorInput userInfoInteractorInput = mainSmartSettingSwitchingTempFragment.mUserInfoInteractor;
        Context requireContext = mainSmartSettingSwitchingTempFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        userInfoInteractorInput.saveSmartCoachingAnimeIsDisplay(requireContext, false);
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$13$lambda$12(ConstraintLayout constraintLayout, int i) {
        Intrinsics.checkNotNullParameter(constraintLayout, "$it");
        constraintLayout.layout((int) constraintLayout.getX(), i, ((int) constraintLayout.getX()) + constraintLayout.getWidth(), constraintLayout.getHeight() + i);
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$15$lambda$14(ConstraintLayout constraintLayout, int i) {
        Intrinsics.checkNotNullParameter(constraintLayout, "$it");
        constraintLayout.layout((int) constraintLayout.getX(), i, ((int) constraintLayout.getX()) + constraintLayout.getWidth(), constraintLayout.getHeight() + i);
    }

    private final void setGradientTemp(View view) {
        View findViewById = view.findViewById(R.id.temp_view1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = view.findViewById(R.id.temp_view2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        View findViewById3 = view.findViewById(R.id.temp_view3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        View findViewById4 = view.findViewById(R.id.temp_view4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#C10D0D"), Color.parseColor("#DF8D2A")});
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#DF8D2A"), Color.parseColor("#DCDCDC")});
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#DCDCDC"), Color.parseColor("#72BFE0")});
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#72BFE0"), Color.parseColor("#0F69BD")});
        findViewById.setBackground(gradientDrawable);
        findViewById2.setBackground(gradientDrawable2);
        findViewById3.setBackground(gradientDrawable3);
        findViewById4.setBackground(gradientDrawable4);
    }

    private final void setCoolTempViewSlideLimit() {
        SmartSettingWarmTempView smartSettingWarmTempView;
        LinearLayout linearLayout;
        SmartSettingCoolTempView smartSettingCoolTempView = this.mCoolTempTextView;
        if (smartSettingCoolTempView != null && (smartSettingWarmTempView = this.mWarmTempTextView) != null && (linearLayout = this.tempView) != null) {
            smartSettingCoolTempView.setLocalMoving(new MainSmartSettingSwitchingTempFragment$setCoolTempViewSlideLimit$1(smartSettingCoolTempView, linearLayout, smartSettingWarmTempView));
            DensityUtil densityUtil = DensityUtil.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            int dip2px = densityUtil.dip2px(requireContext, 221.0f);
            DensityUtil densityUtil2 = DensityUtil.INSTANCE;
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            smartSettingCoolTempView.setLimit(0, dip2px - densityUtil2.dip2px(requireContext2, 40.0f));
        }
    }

    private final void setWarmTempViewSlideLimit() {
        SmartSettingWarmTempView smartSettingWarmTempView;
        LinearLayout linearLayout;
        SmartSettingCoolTempView smartSettingCoolTempView = this.mCoolTempTextView;
        if (smartSettingCoolTempView != null && (smartSettingWarmTempView = this.mWarmTempTextView) != null && (linearLayout = this.tempView) != null) {
            smartSettingWarmTempView.setLocalMoving(new MainSmartSettingSwitchingTempFragment$setWarmTempViewSlideLimit$1(smartSettingWarmTempView, linearLayout, smartSettingCoolTempView));
            DensityUtil densityUtil = DensityUtil.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            int dip2px = densityUtil.dip2px(requireContext, 221.0f);
            DensityUtil densityUtil2 = DensityUtil.INSTANCE;
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            smartSettingWarmTempView.setLimit(0, dip2px - densityUtil2.dip2px(requireContext2, 40.0f));
        }
    }

    /* access modifiers changed from: private */
    public final void parentModalSwipeEnabled(boolean z) {
        SmartSwitchThresholdListener smartSwitchThresholdListener = (SmartSwitchThresholdListener) getCallback$app_prodRelease();
        if (smartSwitchThresholdListener != null) {
            smartSwitchThresholdListener.setSwipeEnabled(z);
        }
    }

    private final void setTouchAction() {
        SmartSettingCoolTempView smartSettingCoolTempView = this.mCoolTempTextView;
        if (smartSettingCoolTempView != null) {
            smartSettingCoolTempView.setAddTouchAction(new MainSmartSettingSwitchingTempFragment$setTouchAction$1(this));
        }
        SmartSettingWarmTempView smartSettingWarmTempView = this.mWarmTempTextView;
        if (smartSettingWarmTempView != null) {
            smartSettingWarmTempView.setAddTouchAction(new MainSmartSettingSwitchingTempFragment$setTouchAction$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void setCoolInitTextTransparent(boolean z) {
        if (z) {
            ConstraintLayout constraintLayout = this.mCoolInitView;
            if (constraintLayout != null) {
                constraintLayout.setAlpha(0.5f);
            }
            ConstraintLayout constraintLayout2 = this.mWarmInitView;
            if (constraintLayout2 != null) {
                constraintLayout2.setAlpha(0.5f);
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout3 = this.mCoolInitView;
        if (constraintLayout3 != null) {
            constraintLayout3.setAlpha(1.0f);
        }
        ConstraintLayout constraintLayout4 = this.mWarmInitView;
        if (constraintLayout4 != null) {
            constraintLayout4.setAlpha(1.0f);
        }
    }
}
