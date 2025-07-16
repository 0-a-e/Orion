package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.ArrowStatus;
import jp.co.sony.reonpocket.constant.TagCorrectionStatus;
import jp.co.sony.reonpocket.constant.TagIlluminationStatus;
import jp.co.sony.reonpocket.constant.TagProximityStatus;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001DB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020,H\u0002J\u0018\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\fH\u0002J$\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0018\u00109\u001a\u00020,2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\fH\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020\u001eH\u0002J\u0012\u0010=\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u00010?H\u0007J\u0006\u0010@\u001a\u00020,J\u0012\u0010A\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u00010BH\u0007J\u0006\u0010C\u001a\u00020,R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, d2 = {"Ljp/co/sony/reonpocket/view/TagMiniInfoView;", "Landroid/widget/FrameLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG_COUNT_DOWN_TIME", "", "TAG_MEASUREMENT_TEMP_HIGH", "", "TAG_MEASUREMENT_TEMP_LOW", "mCountDown", "Ljp/co/sony/reonpocket/view/TagMiniInfoView$CustomCountDown;", "mCurrentHumi", "Ljava/lang/Float;", "mCurrentHumiAnimeArrowDirection", "Ljp/co/sony/reonpocket/constant/ArrowStatus;", "mCurrentTemp", "mCurrentTempAnimeArrowDirection", "mErrorLayout", "Landroid/widget/LinearLayout;", "mErrorText", "Landroid/widget/TextView;", "mHumiImageAnime", "Landroid/widget/ImageView;", "mHumiText", "mIsTagReceiving", "", "mTagBatteryImage", "mTempHumiLayout", "mTempImageAnime", "mTempText", "output", "Ljp/co/sony/reonpocket/view/TagMiniInfoViewOutput;", "getOutput", "()Ljp/co/sony/reonpocket/view/TagMiniInfoViewOutput;", "setOutput", "(Ljp/co/sony/reonpocket/view/TagMiniInfoViewOutput;)V", "formatFirstDecimal", "value", "initUI", "", "aView", "Landroid/view/View;", "noReceiving", "setHumiAnimation", "start", "humi", "setTagIcon", "batteryLevel", "illumination", "Ljp/co/sony/reonpocket/constant/TagIlluminationStatus;", "proximity", "Ljp/co/sony/reonpocket/constant/TagProximityStatus;", "setTempAnimation", "temp", "startAnimation", "isTemp", "updateTagInfo", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "updateTagInfoInitTagRegisterd", "updateTagInfoNoReceiving", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "updateTagInfoUnregistered", "CustomCountDown", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagMiniInfoView.kt */
public final class TagMiniInfoView extends FrameLayout {
    public static final int $stable = 8;
    private final long TAG_COUNT_DOWN_TIME;
    private final float TAG_MEASUREMENT_TEMP_HIGH;
    private final float TAG_MEASUREMENT_TEMP_LOW;
    private final Context mContext;
    private CustomCountDown mCountDown;
    private Float mCurrentHumi;
    private ArrowStatus mCurrentHumiAnimeArrowDirection;
    private Float mCurrentTemp;
    private ArrowStatus mCurrentTempAnimeArrowDirection;
    private LinearLayout mErrorLayout;
    private TextView mErrorText;
    private ImageView mHumiImageAnime;
    private TextView mHumiText;
    private boolean mIsTagReceiving;
    private ImageView mTagBatteryImage;
    private LinearLayout mTempHumiLayout;
    private ImageView mTempImageAnime;
    private TextView mTempText;
    private TagMiniInfoViewOutput output;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TagMiniInfoView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TagMiniInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TagMiniInfoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TagMiniInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.mCurrentTempAnimeArrowDirection = ArrowStatus.NONE;
        this.mCurrentHumiAnimeArrowDirection = ArrowStatus.NONE;
        this.TAG_MEASUREMENT_TEMP_HIGH = 60.0f;
        this.TAG_MEASUREMENT_TEMP_LOW = -10.0f;
        this.TAG_COUNT_DOWN_TIME = 65000;
        View inflate = View.inflate(getContext(), R.layout.view_tag_mini_info, this);
        Intrinsics.checkNotNull(inflate);
        initUI(inflate);
    }

    public final TagMiniInfoViewOutput getOutput() {
        return this.output;
    }

    public final void setOutput(TagMiniInfoViewOutput tagMiniInfoViewOutput) {
        this.output = tagMiniInfoViewOutput;
    }

    private final void initUI(View view) {
        View findViewById = findViewById(R.id.tag_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mTagBatteryImage = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tag_mini_temp_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mTempHumiLayout = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.tag_error_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mErrorLayout = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.status_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mErrorText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.message_temp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mTempText = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.message_humi);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.mHumiText = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.tag_temp_anime);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.mTempImageAnime = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.tag_humi_anime);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.mHumiImageAnime = (ImageView) findViewById8;
        ImageView imageView = this.mTagBatteryImage;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTagBatteryImage");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.ic_minitag_tag);
        LinearLayout linearLayout = this.mTempHumiLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTempHumiLayout");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.mErrorLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorLayout");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        TextView textView2 = this.mErrorText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorText");
        } else {
            textView = textView2;
        }
        textView.setText(this.mContext.getString(R.string.tag_receiving));
    }

    public final void updateTagInfoInitTagRegisterd() {
        TextView textView = this.mErrorText;
        LinearLayout linearLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorText");
            textView = null;
        }
        textView.setText(this.mContext.getString(R.string.tag_receiving));
        LinearLayout linearLayout2 = this.mErrorLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorLayout");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = this.mTempHumiLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTempHumiLayout");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(8);
    }

    public final void updateTagInfoUnregistered() {
        this.mIsTagReceiving = false;
        TagMiniInfoViewOutput tagMiniInfoViewOutput = this.output;
        if (tagMiniInfoViewOutput != null) {
            tagMiniInfoViewOutput.updateNoReceiving(true);
        }
        CustomCountDown customCountDown = this.mCountDown;
        if (customCountDown != null) {
            customCountDown.cancel();
        }
        ImageView imageView = this.mTagBatteryImage;
        LinearLayout linearLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTagBatteryImage");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.ic_minitag_tag);
        ImageView imageView2 = this.mHumiImageAnime;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
            imageView2 = null;
        }
        imageView2.setVisibility(4);
        ImageView imageView3 = this.mTempImageAnime;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
            imageView3 = null;
        }
        imageView3.setVisibility(4);
        TextView textView = this.mTempText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTempText");
            textView = null;
        }
        textView.setText(this.mContext.getString(R.string.tag_temperature_value_no_data) + this.mContext.getString(R.string.common_celsius));
        TextView textView2 = this.mHumiText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHumiText");
            textView2 = null;
        }
        textView2.setText(this.mContext.getString(R.string.tag_humiduty_value_no_data) + this.mContext.getString(R.string.common_percent));
        LinearLayout linearLayout2 = this.mErrorLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorLayout");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = this.mTempHumiLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTempHumiLayout");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(0);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.widget.LinearLayout] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [android.widget.ImageView] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateTagInfo(jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            jp.co.sony.reonpocket.constant.TagSensorDataReceivedStatus r0 = r11.getDataReceivedStatus()
            jp.co.sony.reonpocket.constant.TagSensorDataReceivedStatus r1 = jp.co.sony.reonpocket.constant.TagSensorDataReceivedStatus.RECEIVING
            r2 = 0
            r3 = 0
            if (r0 == r1) goto L_0x002c
            r10.mIsTagReceiving = r2
            android.widget.ImageView r11 = r10.mHumiImageAnime
            if (r11 != 0) goto L_0x0019
            java.lang.String r11 = "mHumiImageAnime"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r11 = r3
        L_0x0019:
            r0 = 4
            r11.setVisibility(r0)
            android.widget.ImageView r11 = r10.mTempImageAnime
            if (r11 != 0) goto L_0x0027
            java.lang.String r11 = "mTempImageAnime"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x0028
        L_0x0027:
            r3 = r11
        L_0x0028:
            r3.setVisibility(r0)
            return
        L_0x002c:
            r0 = 1
            r10.mIsTagReceiving = r0
            jp.co.sony.reonpocket.view.TagMiniInfoViewOutput r1 = r10.output
            if (r1 == 0) goto L_0x0036
            r1.updateNoReceiving(r2)
        L_0x0036:
            jp.co.sony.reonpocket.view.TagMiniInfoView$CustomCountDown r1 = r10.mCountDown
            if (r1 == 0) goto L_0x003d
            r1.cancel()
        L_0x003d:
            jp.co.sony.reonpocket.view.TagMiniInfoView$CustomCountDown r1 = new jp.co.sony.reonpocket.view.TagMiniInfoView$CustomCountDown
            long r6 = r10.TAG_COUNT_DOWN_TIME
            r8 = 1000(0x3e8, double:4.94E-321)
            r4 = r1
            r5 = r10
            r4.<init>(r6, r8)
            r10.mCountDown = r1
            r1.start()
            int r1 = r11.getBatteryLevel()
            jp.co.sony.reonpocket.constant.TagIlluminationStatus r4 = r11.getTagIlluminationStatus()
            jp.co.sony.reonpocket.constant.TagProximityStatus r5 = r11.getTagProximityStatus()
            r10.setTagIcon(r1, r4, r5)
            float r1 = r11.getTagTemp()
            r4 = -1012672758(0xffffffffc3a3d70a, float:-327.68)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0069
            goto L_0x00e9
        L_0x0069:
            float r1 = r11.getTagTemp()
            float r5 = r10.TAG_MEASUREMENT_TEMP_LOW
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            java.lang.String r5 = "mTempText"
            if (r1 >= 0) goto L_0x008b
            android.widget.TextView r1 = r10.mTempText
            if (r1 != 0) goto L_0x007d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r3
        L_0x007d:
            android.content.Context r5 = r10.mContext
            int r6 = jp.co.sony.reonpocket.R.string.tag_temperature_low
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            goto L_0x00d7
        L_0x008b:
            float r1 = r11.getTagTemp()
            float r6 = r10.TAG_MEASUREMENT_TEMP_HIGH
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ab
            android.widget.TextView r1 = r10.mTempText
            if (r1 != 0) goto L_0x009d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r3
        L_0x009d:
            android.content.Context r5 = r10.mContext
            int r6 = jp.co.sony.reonpocket.R.string.tag_temperature_high
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            goto L_0x00d7
        L_0x00ab:
            float r1 = r11.getTagTemp()
            float r1 = r10.formatFirstDecimal(r1)
            android.widget.TextView r6 = r10.mTempText
            if (r6 != 0) goto L_0x00bb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r6 = r3
        L_0x00bb:
            android.content.Context r5 = r10.mContext
            int r7 = jp.co.sony.reonpocket.R.string.common_celsius
            java.lang.String r5 = r5.getString(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            r7.append(r5)
            java.lang.String r1 = r7.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6.setText(r1)
        L_0x00d7:
            jp.co.sony.reonpocket.constant.TagCorrectionStatus r1 = r11.getTempCorrection()
            jp.co.sony.reonpocket.constant.TagCorrectionStatus r5 = jp.co.sony.reonpocket.constant.TagCorrectionStatus.CORRECTING
            if (r1 != r5) goto L_0x00e1
            r1 = r0
            goto L_0x00e2
        L_0x00e1:
            r1 = r2
        L_0x00e2:
            float r5 = r11.getTagTemp()
            r10.setTempAnimation(r1, r5)
        L_0x00e9:
            float r1 = r11.getTagHumi()
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x00f2
            goto L_0x0131
        L_0x00f2:
            float r1 = r11.getTagHumi()
            float r1 = r10.formatFirstDecimal(r1)
            android.widget.TextView r4 = r10.mHumiText
            if (r4 != 0) goto L_0x0104
            java.lang.String r4 = "mHumiText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r3
        L_0x0104:
            android.content.Context r5 = r10.mContext
            int r6 = jp.co.sony.reonpocket.R.string.common_percent
            java.lang.String r5 = r5.getString(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            r6.append(r5)
            java.lang.String r1 = r6.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.setText(r1)
            jp.co.sony.reonpocket.constant.TagCorrectionStatus r1 = r11.getHumiCorrection()
            jp.co.sony.reonpocket.constant.TagCorrectionStatus r4 = jp.co.sony.reonpocket.constant.TagCorrectionStatus.CORRECTING
            if (r1 != r4) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r0 = r2
        L_0x012a:
            float r11 = r11.getTagHumi()
            r10.setHumiAnimation(r0, r11)
        L_0x0131:
            android.widget.LinearLayout r11 = r10.mErrorLayout
            if (r11 != 0) goto L_0x013b
            java.lang.String r11 = "mErrorLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r11 = r3
        L_0x013b:
            r0 = 8
            r11.setVisibility(r0)
            android.widget.LinearLayout r11 = r10.mTempHumiLayout
            if (r11 != 0) goto L_0x014a
            java.lang.String r11 = "mTempHumiLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x014b
        L_0x014a:
            r3 = r11
        L_0x014b:
            r3.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.view.TagMiniInfoView.updateTagInfo(jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity):void");
    }

    private final float formatFirstDecimal(float f) {
        if (((double) f) > 100.0d) {
            return 100.0f;
        }
        return ((float) MathKt.roundToInt(f * 10.0f)) / 10.0f;
    }

    public final void updateTagInfoNoReceiving(TagDataEntity tagDataEntity) {
        if (tagDataEntity != null && !this.mIsTagReceiving) {
            TagMiniInfoViewOutput tagMiniInfoViewOutput = this.output;
            if (tagMiniInfoViewOutput != null) {
                tagMiniInfoViewOutput.updateNoReceiving(false);
            }
            CustomCountDown customCountDown = this.mCountDown;
            if (customCountDown != null) {
                customCountDown.cancel();
            }
            CustomCountDown customCountDown2 = new CustomCountDown(65000, 1000);
            this.mCountDown = customCountDown2;
            customCountDown2.start();
            Integer batteryLevel = tagDataEntity.getBatteryLevel();
            if (batteryLevel != null) {
                setTagIcon(batteryLevel.intValue(), tagDataEntity.getIlluminationStatus(), tagDataEntity.getProximityStatus());
            }
            boolean z = true;
            float f = 0.0f;
            LinearLayout linearLayout = null;
            if (!Intrinsics.areEqual(tagDataEntity.getTemperature(), 32768.0f)) {
                Float temperature = tagDataEntity.getTemperature();
                float floatValue = (temperature != null ? temperature.floatValue() : 0.0f) / 100.0f;
                if (floatValue < this.TAG_MEASUREMENT_TEMP_LOW) {
                    TextView textView = this.mTempText;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                        textView = null;
                    }
                    textView.setText(this.mContext.getString(R.string.tag_temperature_low));
                } else if (floatValue > this.TAG_MEASUREMENT_TEMP_HIGH) {
                    TextView textView2 = this.mTempText;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                        textView2 = null;
                    }
                    textView2.setText(this.mContext.getString(R.string.tag_temperature_high));
                } else {
                    float formatFirstDecimal = formatFirstDecimal(floatValue);
                    TextView textView3 = this.mTempText;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTempText");
                        textView3 = null;
                    }
                    textView3.setText(formatFirstDecimal + this.mContext.getString(R.string.common_celsius));
                }
                setTempAnimation(tagDataEntity.getTempCorrection() == TagCorrectionStatus.CORRECTING, floatValue);
            }
            if (!Intrinsics.areEqual(tagDataEntity.getHumidity(), 32768.0f)) {
                Float humidity = tagDataEntity.getHumidity();
                if (humidity != null) {
                    f = humidity.floatValue();
                }
                float f2 = f / 100.0f;
                float formatFirstDecimal2 = formatFirstDecimal(f2);
                TextView textView4 = this.mHumiText;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHumiText");
                    textView4 = null;
                }
                textView4.setText(formatFirstDecimal2 + this.mContext.getString(R.string.common_percent));
                if (tagDataEntity.getHumiCorrection() != TagCorrectionStatus.CORRECTING) {
                    z = false;
                }
                setHumiAnimation(z, f2);
            }
            LinearLayout linearLayout2 = this.mErrorLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorLayout");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = this.mTempHumiLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempHumiLayout");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setVisibility(0);
        }
    }

    private final void setTempAnimation(boolean z, float f) {
        ImageView imageView = null;
        if (z) {
            Float f2 = this.mCurrentTemp;
            if (f2 == null) {
                this.mCurrentTemp = Float.valueOf(f);
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
            Intrinsics.checkNotNull(f2);
            if (f2.floatValue() >= f) {
                Float f3 = this.mCurrentTemp;
                Intrinsics.checkNotNull(f3);
                if (f3.floatValue() > f) {
                    if (this.mCurrentTempAnimeArrowDirection != ArrowStatus.DOWN) {
                        this.mCurrentTempAnimeArrowDirection = ArrowStatus.DOWN;
                        ImageView imageView3 = this.mTempImageAnime;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
                        } else {
                            imageView = imageView3;
                        }
                        imageView.setImageResource(R.drawable.ic_tag_arrow_down_anim);
                        startAnimation(true);
                    }
                } else if (this.mCurrentTempAnimeArrowDirection == ArrowStatus.NONE) {
                    return;
                }
            } else if (this.mCurrentTempAnimeArrowDirection != ArrowStatus.UP) {
                this.mCurrentTempAnimeArrowDirection = ArrowStatus.UP;
                ImageView imageView4 = this.mTempImageAnime;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempImageAnime");
                } else {
                    imageView = imageView4;
                }
                imageView.setImageResource(R.drawable.ic_tag_arrow_up_anim);
                startAnimation(true);
            }
            this.mCurrentTemp = Float.valueOf(f);
            return;
        }
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
        if (z) {
            Float f2 = this.mCurrentHumi;
            if (f2 == null) {
                this.mCurrentHumi = Float.valueOf(f);
                ImageView imageView2 = this.mHumiImageAnime;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(8);
                this.mCurrentHumiAnimeArrowDirection = ArrowStatus.NONE;
                return;
            }
            Intrinsics.checkNotNull(f2);
            if (f2.floatValue() >= f) {
                Float f3 = this.mCurrentHumi;
                Intrinsics.checkNotNull(f3);
                if (f3.floatValue() > f) {
                    if (this.mCurrentHumiAnimeArrowDirection != ArrowStatus.DOWN) {
                        this.mCurrentHumiAnimeArrowDirection = ArrowStatus.DOWN;
                        ImageView imageView3 = this.mHumiImageAnime;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
                        } else {
                            imageView = imageView3;
                        }
                        imageView.setImageResource(R.drawable.ic_tag_arrow_down_anim);
                        startAnimation(false);
                    }
                } else if (this.mCurrentHumiAnimeArrowDirection == ArrowStatus.NONE) {
                    return;
                }
            } else if (this.mCurrentHumiAnimeArrowDirection != ArrowStatus.UP) {
                this.mCurrentHumiAnimeArrowDirection = ArrowStatus.UP;
                ImageView imageView4 = this.mHumiImageAnime;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHumiImageAnime");
                } else {
                    imageView = imageView4;
                }
                imageView.setImageResource(R.drawable.ic_tag_arrow_up_anim);
                startAnimation(false);
            }
            this.mCurrentHumi = Float.valueOf(f);
            return;
        }
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
            animatedVectorDrawable.registerAnimationCallback(new TagMiniInfoView$startAnimation$1(animatedVectorDrawable));
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
        animatedVectorDrawable2.registerAnimationCallback(new TagMiniInfoView$startAnimation$2(animatedVectorDrawable2));
        animatedVectorDrawable2.start();
    }

    private final void setTagIcon(int i, TagIlluminationStatus tagIlluminationStatus, TagProximityStatus tagProximityStatus) {
        ImageView imageView = null;
        if (tagIlluminationStatus == TagIlluminationStatus.DARK && tagProximityStatus == TagProximityStatus.CLOSE) {
            ImageView imageView2 = this.mTagBatteryImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagBatteryImage");
            } else {
                imageView = imageView2;
            }
            imageView.setImageResource(R.drawable.ic_minitag_caution);
            TagMiniInfoViewOutput tagMiniInfoViewOutput = this.output;
            if (tagMiniInfoViewOutput != null) {
                tagMiniInfoViewOutput.updateNoAmbientTemperature(true);
            }
        } else if (i <= 1) {
            ImageView imageView3 = this.mTagBatteryImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagBatteryImage");
            } else {
                imageView = imageView3;
            }
            imageView.setImageResource(R.drawable.ic_minitag_lowbattery);
            TagMiniInfoViewOutput tagMiniInfoViewOutput2 = this.output;
            if (tagMiniInfoViewOutput2 != null) {
                tagMiniInfoViewOutput2.updateNoAmbientTemperature(false);
            }
        } else {
            ImageView imageView4 = this.mTagBatteryImage;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTagBatteryImage");
            } else {
                imageView = imageView4;
            }
            imageView.setImageResource(R.drawable.ic_minitag_tag);
            TagMiniInfoViewOutput tagMiniInfoViewOutput3 = this.output;
            if (tagMiniInfoViewOutput3 != null) {
                tagMiniInfoViewOutput3.updateNoAmbientTemperature(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void noReceiving() {
        if (getContext() == null) {
            DebugLogUtil.INSTANCE.e("fun noReceiving error: context is null");
            return;
        }
        LinearLayout linearLayout = this.mTempHumiLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTempHumiLayout");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        this.mCurrentTemp = null;
        this.mCurrentTempAnimeArrowDirection = ArrowStatus.NONE;
        this.mCurrentHumi = null;
        this.mCurrentHumiAnimeArrowDirection = ArrowStatus.NONE;
        ImageView imageView = this.mTagBatteryImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTagBatteryImage");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.ic_minitag_tag);
        LinearLayout linearLayout2 = this.mErrorLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorLayout");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        TextView textView2 = this.mErrorText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorText");
        } else {
            textView = textView2;
        }
        textView.setText(this.mContext.getString(R.string.tag_not_received));
        TagMiniInfoViewOutput tagMiniInfoViewOutput = this.output;
        if (tagMiniInfoViewOutput != null) {
            tagMiniInfoViewOutput.updateNoReceiving(true);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/view/TagMiniInfoView$CustomCountDown;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Ljp/co/sony/reonpocket/view/TagMiniInfoView;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagMiniInfoView.kt */
    public final class CustomCountDown extends CountDownTimer {
        public void onTick(long j) {
        }

        public CustomCountDown(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            ThreadUtils.runOnUiThread(new TagMiniInfoView$CustomCountDown$$ExternalSyntheticLambda0(TagMiniInfoView.this));
        }

        /* access modifiers changed from: private */
        public static final void onFinish$lambda$0(TagMiniInfoView tagMiniInfoView) {
            Intrinsics.checkNotNullParameter(tagMiniInfoView, "this$0");
            tagMiniInfoView.noReceiving();
        }
    }
}
