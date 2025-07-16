package jp.co.sony.reonpocket.modules.tagInfo.view;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.ArrowStatus;
import jp.co.sony.reonpocket.constant.TagCorrectionStatus;
import jp.co.sony.reonpocket.constant.TagIlluminationStatus;
import jp.co.sony.reonpocket.constant.TagProximityStatus;
import jp.co.sony.reonpocket.constant.TagSensorDataReceivedStatus;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.modules.tagInfo.presenter.TagInfoFragmentPresenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0002QRB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001cH\u0016J&\u0010.\u001a\u0004\u0018\u00010,2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020*H\u0016J\b\u00106\u001a\u00020*H\u0016J\b\u00107\u001a\u00020*H\u0016J\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020\fH\u0002J\u0018\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010=\u001a\u00020*2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u001c\u0010>\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0018\u0010C\u001a\u00020*2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u0005H\u0002J\u0010\u0010E\u001a\u00020*2\u0006\u0010D\u001a\u00020\u0005H\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020\u001cH\u0002J\u0010\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020*2\u0006\u0010I\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020*H\u0016J\b\u0010N\u001a\u00020*H\u0016J\u0014\u0010O\u001a\u00020**\u00020\n2\u0006\u0010P\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragmentViewInput;", "()V", "TAG_MEASUREMENT_TEMP_HIGH", "", "TAG_MEASUREMENT_TEMP_LOW", "mAmbientTempErrorImage", "Landroid/widget/ImageView;", "mAmbientTempErrorMessage", "Landroid/widget/TextView;", "mBattery", "", "mBatteryIcon", "mCountDown", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragment$CustomCountDown;", "mCurrentHumi", "Ljava/lang/Float;", "mCurrentHumiAnimeArrowDirection", "Ljp/co/sony/reonpocket/constant/ArrowStatus;", "mCurrentTemp", "mCurrentTempAnimeArrowDirection", "mErrorImage", "mErrorMessage", "mHumi", "mHumiImageAnime", "mHumiText", "mIsNoAmbientTemp", "", "mIsReceiving", "mIsUseDeviceReadSensor", "mOutput", "Ljp/co/sony/reonpocket/modules/tagInfo/presenter/TagInfoFragmentPresenter;", "mSerialNo", "", "mTemp", "mTempImageAnime", "mTempText", "mTempTextUnit", "formatFirstDecimal", "value", "initView", "", "aView", "Landroid/view/View;", "isDataFromDevice", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setBatteryIcon", "remaining", "setHumiAnimation", "start", "humi", "setHumiText", "setNotGetAmbientTemp", "illumination", "Ljp/co/sony/reonpocket/constant/TagIlluminationStatus;", "proximity", "Ljp/co/sony/reonpocket/constant/TagProximityStatus;", "setTempAnimation", "temp", "setTmpText", "startAnimation", "isTemp", "updateDisplay", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "updateNoReceivingDisplay", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "updateNotReceivingDisplay", "updateReceivingDisplay", "addHyperLink", "linkText", "Companion", "CustomCountDown", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoFragment.kt */
public final class TagInfoFragment extends BaseFragment implements TagInfoFragmentViewInput {
    public static final int $stable = 8;
    private static final String BATTERY = "battery";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HUMI = "humi";
    private static final String IS_TAG_NO_AMBIENT = "isNoAmbientTemp";
    private static final String IS_TAG_RECEIVING = "isReceiving";
    private static final String IS_USE_DEVICE_READ_SENSOR = "isUseDeviceReadSensor";
    private static final String SERIAL_NO = "serialNo";
    private static final String TEMP = "temp";
    private final float TAG_MEASUREMENT_TEMP_HIGH = 60.0f;
    private final float TAG_MEASUREMENT_TEMP_LOW = -10.0f;
    private ImageView mAmbientTempErrorImage;
    private TextView mAmbientTempErrorMessage;
    private int mBattery;
    private ImageView mBatteryIcon;
    private CustomCountDown mCountDown;
    private Float mCurrentHumi;
    private ArrowStatus mCurrentHumiAnimeArrowDirection = ArrowStatus.NONE;
    private Float mCurrentTemp;
    private ArrowStatus mCurrentTempAnimeArrowDirection = ArrowStatus.NONE;
    private ImageView mErrorImage;
    private TextView mErrorMessage;
    private float mHumi;
    private ImageView mHumiImageAnime;
    private TextView mHumiText;
    private boolean mIsNoAmbientTemp;
    private boolean mIsReceiving;
    private boolean mIsUseDeviceReadSensor;
    private TagInfoFragmentPresenter mOutput;
    private String mSerialNo = "";
    private float mTemp;
    private ImageView mTempImageAnime;
    private TextView mTempText;
    private TextView mTempTextUnit;

    @JvmStatic
    public static final TagInfoFragment newInstance(boolean z, boolean z2, String str, float f, float f2, int i, boolean z3) {
        return Companion.newInstance(z, z2, str, f, f2, i, z3);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragment$Companion;", "", "()V", "BATTERY", "", "HUMI", "IS_TAG_NO_AMBIENT", "IS_TAG_RECEIVING", "IS_USE_DEVICE_READ_SENSOR", "SERIAL_NO", "TEMP", "newInstance", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragment;", "isReceiving", "", "isNoAmbientTemp", "serialNo", "temp", "", "humi", "battery", "", "isUseDeviceReadSensor", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagInfoFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ TagInfoFragment newInstance$default(Companion companion, boolean z, boolean z2, String str, float f, float f2, int i, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            if ((i2 & 4) != 0) {
                str = "";
            }
            if ((i2 & 8) != 0) {
                f = 0.0f;
            }
            if ((i2 & 16) != 0) {
                f2 = 0.0f;
            }
            if ((i2 & 32) != 0) {
                i = 0;
            }
            if ((i2 & 64) != 0) {
                z3 = false;
            }
            return companion.newInstance(z, z2, str, f, f2, i, z3);
        }

        @JvmStatic
        public final TagInfoFragment newInstance(boolean z, boolean z2, String str, float f, float f2, int i, boolean z3) {
            TagInfoFragment tagInfoFragment = new TagInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(TagInfoFragment.IS_TAG_RECEIVING, z);
            bundle.putBoolean(TagInfoFragment.IS_TAG_NO_AMBIENT, z2);
            bundle.putString(TagInfoFragment.SERIAL_NO, str);
            bundle.putFloat(TagInfoFragment.TEMP, f);
            bundle.putFloat(TagInfoFragment.HUMI, f2);
            bundle.putInt(TagInfoFragment.BATTERY, i);
            bundle.putBoolean(TagInfoFragment.IS_USE_DEVICE_READ_SENSOR, z3);
            tagInfoFragment.setArguments(bundle);
            return tagInfoFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        this.mIsReceiving = arguments.getBoolean(IS_TAG_RECEIVING);
        this.mIsNoAmbientTemp = arguments.getBoolean(IS_TAG_NO_AMBIENT);
        String string = arguments.getString(SERIAL_NO);
        if (string == null) {
            string = "";
        }
        this.mSerialNo = string;
        this.mTemp = arguments.getFloat(TEMP);
        this.mHumi = arguments.getFloat(HUMI);
        this.mBattery = arguments.getInt(BATTERY);
        this.mIsUseDeviceReadSensor = arguments.getBoolean(IS_USE_DEVICE_READ_SENSOR);
        View inflate = layoutInflater.inflate(R.layout.fragment_tag_info, viewGroup, false);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        TagInfoFragmentPresenter tagInfoFragmentPresenter = new TagInfoFragmentPresenter(requireContext, this);
        this.mOutput = tagInfoFragmentPresenter;
        tagInfoFragmentPresenter.onCreateView();
        Intrinsics.checkNotNull(inflate);
        initView(inflate);
        return inflate;
    }

    public void onPause() {
        super.onPause();
        TagInfoFragmentPresenter tagInfoFragmentPresenter = this.mOutput;
        if (tagInfoFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            tagInfoFragmentPresenter = null;
        }
        tagInfoFragmentPresenter.onPause();
    }

    public void onResume() {
        super.onResume();
        TagInfoFragmentPresenter tagInfoFragmentPresenter = this.mOutput;
        if (tagInfoFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            tagInfoFragmentPresenter = null;
        }
        tagInfoFragmentPresenter.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        TagInfoFragmentPresenter tagInfoFragmentPresenter = this.mOutput;
        if (tagInfoFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            tagInfoFragmentPresenter = null;
        }
        tagInfoFragmentPresenter.onDestroy();
        CustomCountDown customCountDown = this.mCountDown;
        if (customCountDown != null) {
            customCountDown.cancel();
        }
    }

    private final void initView(View view) {
        TagInfoFragmentPresenter tagInfoFragmentPresenter = this.mOutput;
        TextView textView = null;
        if (tagInfoFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            tagInfoFragmentPresenter = null;
        }
        boolean isTagRegistered = tagInfoFragmentPresenter.isTagRegistered();
        View findViewById = view.findViewById(R.id.message_serialNo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView textView2 = (TextView) findViewById;
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        textView2.setText(activity.getString(R.string.tag_serial_number, new Object[]{this.mSerialNo}));
        int i = 4;
        textView2.setVisibility(isTagRegistered ? 0 : 4);
        View findViewById2 = view.findViewById(R.id.message_temp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mTempText = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.message_temp_unit);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mTempTextUnit = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tag_temp_anime);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mTempImageAnime = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.message_humi);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mHumiText = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tag_humi_anime);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.mHumiImageAnime = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.row_battery_image);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById7;
        this.mBatteryIcon = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBatteryIcon");
            imageView = null;
        }
        imageView.setVisibility(isTagRegistered ? 0 : 4);
        View findViewById8 = view.findViewById(R.id.image_error);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        ImageView imageView2 = (ImageView) findViewById8;
        this.mErrorImage = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorImage");
            imageView2 = null;
        }
        imageView2.setVisibility(isTagRegistered ? 0 : 4);
        View findViewById9 = view.findViewById(R.id.message_error);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        TextView textView3 = (TextView) findViewById9;
        this.mErrorMessage = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
            textView3 = null;
        }
        textView3.setVisibility(isTagRegistered ? 0 : 4);
        View findViewById10 = view.findViewById(R.id.ambient_temp_image_error);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.mAmbientTempErrorImage = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.ambient_temp_message_error);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.mAmbientTempErrorMessage = (TextView) findViewById11;
        ImageView imageView3 = this.mAmbientTempErrorImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorImage");
            imageView3 = null;
        }
        imageView3.setVisibility(isTagRegistered ? 0 : 4);
        TextView textView4 = this.mAmbientTempErrorMessage;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorMessage");
            textView4 = null;
        }
        if (isTagRegistered) {
            i = 0;
        }
        textView4.setVisibility(i);
        View findViewById12 = view.findViewById(R.id.tag_info_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) findViewById12;
        ViewTreeObserver viewTreeObserver = linearLayout.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "getViewTreeObserver(...)");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        viewTreeObserver.addOnGlobalLayoutListener(new TagInfoFragment$$ExternalSyntheticLambda0(booleanRef, linearLayout, view));
        if (isTagRegistered) {
            if (this.mTemp == 0.0f && this.mHumi == 0.0f && this.mBattery == 0) {
                CustomCountDown customCountDown = new CustomCountDown(65000, 1000);
                this.mCountDown = customCountDown;
                customCountDown.start();
                updateReceivingDisplay();
            } else if (!this.mIsReceiving) {
                updateNotReceivingDisplay();
            } else {
                TextView textView5 = this.mTempText;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                    textView5 = null;
                }
                textView5.setText(String.valueOf(this.mTemp));
                TextView textView6 = this.mHumiText;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHumiText");
                    textView6 = null;
                }
                textView6.setText(String.valueOf(this.mHumi));
                setBatteryIcon(this.mBattery);
                if (this.mIsNoAmbientTemp) {
                    ImageView imageView4 = this.mAmbientTempErrorImage;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorImage");
                        imageView4 = null;
                    }
                    imageView4.setVisibility(0);
                    TextView textView7 = this.mAmbientTempErrorMessage;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorMessage");
                    } else {
                        textView = textView7;
                    }
                    textView.setVisibility(0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(Ref.BooleanRef booleanRef, LinearLayout linearLayout, View view) {
        Intrinsics.checkNotNullParameter(booleanRef, "$isFirstInitView");
        Intrinsics.checkNotNullParameter(linearLayout, "$tagMainLayout");
        Intrinsics.checkNotNullParameter(view, "$aView");
        if (booleanRef.element) {
            View findViewById = view.findViewById(R.id.tag_humi_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            LinearLayout linearLayout2 = (LinearLayout) findViewById;
            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(0, (linearLayout.getHeight() / 100) * 2, 0, 0);
            linearLayout2.setLayoutParams(marginLayoutParams);
            booleanRef.element = false;
        }
    }

    private final void setTmpText(float f) {
        if (getActivity() != null) {
            TextView textView = null;
            if (f < this.TAG_MEASUREMENT_TEMP_LOW) {
                TextView textView2 = this.mTempText;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                    textView2 = null;
                }
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                textView2.setText(activity.getString(R.string.tag_temperature_low));
                TextView textView3 = this.mTempTextUnit;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempTextUnit");
                } else {
                    textView = textView3;
                }
                textView.setVisibility(4);
            } else if (f > this.TAG_MEASUREMENT_TEMP_HIGH) {
                TextView textView4 = this.mTempText;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                    textView4 = null;
                }
                FragmentActivity activity2 = getActivity();
                Intrinsics.checkNotNull(activity2);
                textView4.setText(activity2.getString(R.string.tag_temperature_high));
                TextView textView5 = this.mTempTextUnit;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempTextUnit");
                } else {
                    textView = textView5;
                }
                textView.setVisibility(4);
            } else {
                float formatFirstDecimal = formatFirstDecimal(f);
                TextView textView6 = this.mTempText;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                    textView6 = null;
                }
                textView6.setText(String.valueOf(formatFirstDecimal));
                TextView textView7 = this.mTempTextUnit;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempTextUnit");
                } else {
                    textView = textView7;
                }
                textView.setVisibility(0);
            }
        }
    }

    private final void setHumiText(float f) {
        TextView textView = this.mHumiText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHumiText");
            textView = null;
        }
        textView.setText(String.valueOf(f));
    }

    private final float formatFirstDecimal(float f) {
        if (((double) f) > 100.0d) {
            return 100.0f;
        }
        return ((float) MathKt.roundToInt(f * 10.0f)) / 10.0f;
    }

    private final void setTempAnimation(boolean z, float f) {
        ImageView imageView = null;
        if (!z) {
            ImageView imageView2 = this.mTempImageAnime;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(4);
            this.mCurrentTempAnimeArrowDirection = ArrowStatus.NONE;
            return;
        }
        Float f2 = this.mCurrentTemp;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            if (floatValue < f) {
                if (this.mCurrentTempAnimeArrowDirection != ArrowStatus.UP) {
                    this.mCurrentTempAnimeArrowDirection = ArrowStatus.UP;
                    ImageView imageView3 = this.mTempImageAnime;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
                    } else {
                        imageView = imageView3;
                    }
                    imageView.setImageResource(R.drawable.ic_tag_arrow_up_anim);
                    startAnimation(true);
                }
            } else if (floatValue > f) {
                if (this.mCurrentTempAnimeArrowDirection != ArrowStatus.DOWN) {
                    this.mCurrentTempAnimeArrowDirection = ArrowStatus.DOWN;
                    ImageView imageView4 = this.mTempImageAnime;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
                    } else {
                        imageView = imageView4;
                    }
                    imageView.setImageResource(R.drawable.ic_tag_arrow_down_anim);
                    startAnimation(true);
                }
            } else if (this.mCurrentTempAnimeArrowDirection == ArrowStatus.NONE) {
                return;
            }
            this.mCurrentTemp = Float.valueOf(f);
            return;
        }
        this.mCurrentTemp = Float.valueOf(f);
        ImageView imageView5 = this.mTempImageAnime;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
        } else {
            imageView = imageView5;
        }
        imageView.setVisibility(4);
        this.mCurrentTempAnimeArrowDirection = ArrowStatus.NONE;
    }

    private final void setHumiAnimation(boolean z, float f) {
        ImageView imageView = null;
        if (!z) {
            ImageView imageView2 = this.mHumiImageAnime;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(4);
            this.mCurrentHumiAnimeArrowDirection = ArrowStatus.NONE;
            return;
        }
        Float f2 = this.mCurrentHumi;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            if (floatValue < f) {
                if (this.mCurrentHumiAnimeArrowDirection != ArrowStatus.UP) {
                    this.mCurrentHumiAnimeArrowDirection = ArrowStatus.UP;
                    ImageView imageView3 = this.mHumiImageAnime;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
                    } else {
                        imageView = imageView3;
                    }
                    imageView.setImageResource(R.drawable.ic_tag_arrow_up_anim);
                    startAnimation(false);
                }
            } else if (floatValue > f) {
                if (this.mCurrentHumiAnimeArrowDirection != ArrowStatus.DOWN) {
                    this.mCurrentHumiAnimeArrowDirection = ArrowStatus.DOWN;
                    ImageView imageView4 = this.mHumiImageAnime;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
                    } else {
                        imageView = imageView4;
                    }
                    imageView.setImageResource(R.drawable.ic_tag_arrow_down_anim);
                    startAnimation(false);
                }
            } else if (this.mCurrentHumiAnimeArrowDirection == ArrowStatus.NONE) {
                return;
            }
            this.mCurrentHumi = Float.valueOf(f);
            return;
        }
        this.mCurrentHumi = Float.valueOf(f);
        ImageView imageView5 = this.mHumiImageAnime;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
        } else {
            imageView = imageView5;
        }
        imageView.setVisibility(4);
        this.mCurrentHumiAnimeArrowDirection = ArrowStatus.NONE;
    }

    private final void startAnimation(boolean z) {
        ImageView imageView = null;
        if (z) {
            ImageView imageView2 = this.mTempImageAnime;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.mTempImageAnime;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
            } else {
                imageView = imageView3;
            }
            Drawable drawable = imageView.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimatedVectorDrawable");
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            animatedVectorDrawable.registerAnimationCallback(new TagInfoFragment$startAnimation$1(animatedVectorDrawable));
            animatedVectorDrawable.start();
            return;
        }
        ImageView imageView4 = this.mHumiImageAnime;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
            imageView4 = null;
        }
        imageView4.setVisibility(0);
        ImageView imageView5 = this.mHumiImageAnime;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
        } else {
            imageView = imageView5;
        }
        Drawable drawable2 = imageView.getDrawable();
        Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.AnimatedVectorDrawable");
        AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
        animatedVectorDrawable2.registerAnimationCallback(new TagInfoFragment$startAnimation$2(animatedVectorDrawable2));
        animatedVectorDrawable2.start();
    }

    private final void setBatteryIcon(int i) {
        TextView textView = null;
        if (i < 0 || i >= 2) {
            ImageView imageView = this.mBatteryIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBatteryIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
            ImageView imageView2 = this.mErrorImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorImage");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            TextView textView2 = this.mErrorMessage;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.mBatteryIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBatteryIcon");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.mBatteryIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBatteryIcon");
            imageView4 = null;
        }
        imageView4.setImageResource(R.drawable.ic_tag_battery_low);
        ImageView imageView5 = this.mErrorImage;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorImage");
            imageView5 = null;
        }
        imageView5.setVisibility(0);
        TextView textView3 = this.mErrorMessage;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.mErrorMessage;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
            textView4 = null;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        textView4.setText(activity.getString(R.string.tag_low_battery));
        TextView textView5 = this.mErrorMessage;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
        } else {
            textView = textView5;
        }
        addHyperLink(textView, "こちら");
    }

    private final void addHyperLink(TextView textView, String str) {
        SpannableString spannableString = new SpannableString(textView.getText());
        Matcher matcher = Pattern.compile(str).matcher(textView.getText());
        while (matcher.find()) {
            spannableString.setSpan(new TagInfoFragment$addHyperLink$1(this), matcher.start(), matcher.end(), 18);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void setNotGetAmbientTemp(TagIlluminationStatus tagIlluminationStatus, TagProximityStatus tagProximityStatus) {
        TextView textView = null;
        if (tagIlluminationStatus == TagIlluminationStatus.DARK && tagProximityStatus == TagProximityStatus.CLOSE) {
            ImageView imageView = this.mAmbientTempErrorImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorImage");
                imageView = null;
            }
            imageView.setVisibility(0);
            TextView textView2 = this.mAmbientTempErrorMessage;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorMessage");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        ImageView imageView2 = this.mAmbientTempErrorImage;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorImage");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        TextView textView3 = this.mAmbientTempErrorMessage;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorMessage");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragment$CustomCountDown;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragment;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagInfoFragment.kt */
    public final class CustomCountDown extends CountDownTimer {
        public void onTick(long j) {
        }

        public CustomCountDown(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            ThreadUtils.runOnUiThread(new TagInfoFragment$CustomCountDown$$ExternalSyntheticLambda0(TagInfoFragment.this));
        }

        /* access modifiers changed from: private */
        public static final void onFinish$lambda$0(TagInfoFragment tagInfoFragment) {
            Intrinsics.checkNotNullParameter(tagInfoFragment, "this$0");
            tagInfoFragment.updateNotReceivingDisplay();
        }
    }

    public void updateDisplay(NotifyTagSensorDataEntity notifyTagSensorDataEntity) {
        Intrinsics.checkNotNullParameter(notifyTagSensorDataEntity, "entity");
        if (getActivity() != null) {
            CustomCountDown customCountDown = this.mCountDown;
            if (customCountDown != null) {
                customCountDown.cancel();
            }
            TagInfoFragmentPresenter tagInfoFragmentPresenter = this.mOutput;
            if (tagInfoFragmentPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
                tagInfoFragmentPresenter = null;
            }
            if (tagInfoFragmentPresenter.isTagRegistered()) {
                CustomCountDown customCountDown2 = new CustomCountDown(65000, 1000);
                this.mCountDown = customCountDown2;
                customCountDown2.start();
                boolean z = true;
                boolean z2 = notifyTagSensorDataEntity.getDataReceivedStatus() == TagSensorDataReceivedStatus.RECEIVING;
                this.mIsReceiving = z2;
                if (z2) {
                    if (notifyTagSensorDataEntity.getTagTemp() != -327.68f) {
                        setTmpText(formatFirstDecimal(notifyTagSensorDataEntity.getTagTemp()));
                        setTempAnimation(notifyTagSensorDataEntity.getTempCorrection() == TagCorrectionStatus.CORRECTING, notifyTagSensorDataEntity.getTagTemp());
                    }
                    if (notifyTagSensorDataEntity.getTagHumi() != -327.68f) {
                        setHumiText(formatFirstDecimal(notifyTagSensorDataEntity.getTagHumi()));
                        if (notifyTagSensorDataEntity.getHumiCorrection() != TagCorrectionStatus.CORRECTING) {
                            z = false;
                        }
                        setHumiAnimation(z, notifyTagSensorDataEntity.getTagHumi());
                    }
                    setBatteryIcon(notifyTagSensorDataEntity.getBatteryLevel());
                    setNotGetAmbientTemp(notifyTagSensorDataEntity.getTagIlluminationStatus(), notifyTagSensorDataEntity.getTagProximityStatus());
                }
            }
        }
    }

    public void updateNoReceivingDisplay(TagDataEntity tagDataEntity) {
        Intrinsics.checkNotNullParameter(tagDataEntity, "entity");
        if (getActivity() != null) {
            CustomCountDown customCountDown = this.mCountDown;
            if (customCountDown != null) {
                customCountDown.cancel();
            }
            TagInfoFragmentPresenter tagInfoFragmentPresenter = this.mOutput;
            if (tagInfoFragmentPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
                tagInfoFragmentPresenter = null;
            }
            if (tagInfoFragmentPresenter.isTagRegistered() && !this.mIsReceiving) {
                CustomCountDown customCountDown2 = new CustomCountDown(65000, 1000);
                this.mCountDown = customCountDown2;
                customCountDown2.start();
                boolean z = true;
                float f = 0.0f;
                if (!Intrinsics.areEqual(tagDataEntity.getTemperature(), 32768.0f)) {
                    Float temperature = tagDataEntity.getTemperature();
                    float floatValue = (temperature != null ? temperature.floatValue() : 0.0f) / 100.0f;
                    setTmpText(formatFirstDecimal(floatValue));
                    setTempAnimation(tagDataEntity.getTempCorrection() == TagCorrectionStatus.CORRECTING, floatValue);
                }
                if (!Intrinsics.areEqual(tagDataEntity.getHumidity(), 32768.0f)) {
                    Float humidity = tagDataEntity.getHumidity();
                    if (humidity != null) {
                        f = humidity.floatValue();
                    }
                    float f2 = f / 100.0f;
                    setHumiText(formatFirstDecimal(f2));
                    if (tagDataEntity.getHumiCorrection() != TagCorrectionStatus.CORRECTING) {
                        z = false;
                    }
                    setHumiAnimation(z, f2);
                }
                Integer batteryLevel = tagDataEntity.getBatteryLevel();
                if (batteryLevel != null) {
                    setBatteryIcon(batteryLevel.intValue());
                }
                setNotGetAmbientTemp(tagDataEntity.getIlluminationStatus(), tagDataEntity.getProximityStatus());
            }
        }
    }

    public void updateNotReceivingDisplay() {
        if (getActivity() != null) {
            TextView textView = null;
            this.mCurrentTemp = null;
            this.mCurrentTempAnimeArrowDirection = ArrowStatus.NONE;
            TextView textView2 = this.mTempText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                textView2 = null;
            }
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            textView2.setText(activity.getString(R.string.tag_temperature_value_no_data));
            TextView textView3 = this.mTempTextUnit;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempTextUnit");
                textView3 = null;
            }
            textView3.setVisibility(0);
            ImageView imageView = this.mTempImageAnime;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
                imageView = null;
            }
            imageView.setVisibility(4);
            TextView textView4 = this.mHumiText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHumiText");
                textView4 = null;
            }
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2);
            textView4.setText(activity2.getString(R.string.tag_humiduty_value_no_data));
            ImageView imageView2 = this.mHumiImageAnime;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
                imageView2 = null;
            }
            imageView2.setVisibility(4);
            this.mCurrentHumi = null;
            this.mCurrentHumiAnimeArrowDirection = ArrowStatus.NONE;
            ImageView imageView3 = this.mBatteryIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBatteryIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            ImageView imageView4 = this.mErrorImage;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorImage");
                imageView4 = null;
            }
            imageView4.setVisibility(8);
            ImageView imageView5 = this.mAmbientTempErrorImage;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorImage");
                imageView5 = null;
            }
            imageView5.setVisibility(8);
            TextView textView5 = this.mAmbientTempErrorMessage;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorMessage");
                textView5 = null;
            }
            textView5.setVisibility(8);
            TextView textView6 = this.mErrorMessage;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
                textView6 = null;
            }
            textView6.setVisibility(0);
            TextView textView7 = this.mErrorMessage;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
            } else {
                textView = textView7;
            }
            FragmentActivity activity3 = getActivity();
            Intrinsics.checkNotNull(activity3);
            textView.setText(activity3.getString(R.string.tag_not_received_with_advice));
        }
    }

    public void updateReceivingDisplay() {
        if (getActivity() != null) {
            TextView textView = null;
            this.mCurrentTemp = null;
            this.mCurrentTempAnimeArrowDirection = ArrowStatus.NONE;
            TextView textView2 = this.mTempText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                textView2 = null;
            }
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            textView2.setText(activity.getString(R.string.tag_temperature_value_no_data));
            TextView textView3 = this.mTempTextUnit;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempTextUnit");
                textView3 = null;
            }
            textView3.setVisibility(0);
            ImageView imageView = this.mTempImageAnime;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
                imageView = null;
            }
            imageView.setVisibility(4);
            TextView textView4 = this.mHumiText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHumiText");
                textView4 = null;
            }
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2);
            textView4.setText(activity2.getString(R.string.tag_humiduty_value_no_data));
            ImageView imageView2 = this.mHumiImageAnime;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
                imageView2 = null;
            }
            imageView2.setVisibility(4);
            this.mCurrentHumi = null;
            this.mCurrentHumiAnimeArrowDirection = ArrowStatus.NONE;
            ImageView imageView3 = this.mBatteryIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBatteryIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            ImageView imageView4 = this.mErrorImage;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorImage");
                imageView4 = null;
            }
            imageView4.setVisibility(8);
            ImageView imageView5 = this.mAmbientTempErrorImage;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorImage");
                imageView5 = null;
            }
            imageView5.setVisibility(8);
            TextView textView5 = this.mAmbientTempErrorMessage;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAmbientTempErrorMessage");
                textView5 = null;
            }
            textView5.setVisibility(8);
            TextView textView6 = this.mErrorMessage;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
                textView6 = null;
            }
            textView6.setVisibility(0);
            TextView textView7 = this.mErrorMessage;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorMessage");
            } else {
                textView = textView7;
            }
            FragmentActivity activity3 = getActivity();
            Intrinsics.checkNotNull(activity3);
            textView.setText(activity3.getString(R.string.tag_receiving_with_advice));
        }
    }

    public boolean isDataFromDevice() {
        return this.mIsUseDeviceReadSensor;
    }
}
