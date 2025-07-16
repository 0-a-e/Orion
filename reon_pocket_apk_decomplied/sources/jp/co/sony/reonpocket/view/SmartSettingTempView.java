package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.LocaleUtil;
import jp.co.sony.reonpocket.view.TouchAndDragView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001:\u0001.B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\fJ\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\"J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0002J\u0016\u0010)\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\fH\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Ljp/co/sony/reonpocket/view/SmartSettingTempView;", "Ljp/co/sony/reonpocket/view/TouchAndDragView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "type", "Ljp/co/sony/reonpocket/view/SmartSettingTempView$SmartSettingTempPattern;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjp/co/sony/reonpocket/view/SmartSettingTempView$SmartSettingTempPattern;)V", "currentTemp", "", "getCurrentTemp", "()F", "setCurrentTemp", "(F)V", "lowerLimit", "tempLowerLimit", "tempUpperLimit", "textview", "Landroid/widget/TextView;", "getTextview", "()Landroid/widget/TextView;", "setTextview", "(Landroid/widget/TextView;)V", "getType", "()Ljp/co/sony/reonpocket/view/SmartSettingTempView$SmartSettingTempPattern;", "upperLimit", "calculatePositionFromTemp", "temp", "calculateTempFromPosition", "position", "init", "", "initPosition", "initUI", "aView", "Landroid/view/View;", "roundHalf", "value", "setLimit", "setTextStyle", "isPressed", "", "updateText", "SmartSettingTempPattern", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SmartSettingCoolTempView.kt */
public class SmartSettingTempView extends TouchAndDragView {
    public static final int $stable = 8;
    private float currentTemp;
    private int lowerLimit;
    private float tempLowerLimit;
    private float tempUpperLimit;
    public TextView textview;
    private final SmartSettingTempPattern type;
    private int upperLimit;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmartSettingTempView(Context context, AttributeSet attributeSet, SmartSettingTempPattern smartSettingTempPattern) {
        this(context, attributeSet, 0, smartSettingTempPattern, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(smartSettingTempPattern, TransferTable.COLUMN_TYPE);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmartSettingTempView(Context context, SmartSettingTempPattern smartSettingTempPattern) {
        this(context, (AttributeSet) null, 0, smartSettingTempPattern, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(smartSettingTempPattern, TransferTable.COLUMN_TYPE);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmartSettingTempView(Context context, AttributeSet attributeSet, int i, SmartSettingTempPattern smartSettingTempPattern, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, smartSettingTempPattern);
    }

    public final SmartSettingTempPattern getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bj\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/view/SmartSettingTempView$SmartSettingTempPattern;", "", "layoutId", "", "textViewId", "textPrefixId", "normalBgId", "pressedBgId", "textColorId", "(Ljava/lang/String;IIIIIII)V", "getLayoutId", "()I", "getNormalBgId", "getPressedBgId", "getTextColorId", "getTextPrefixId", "getTextViewId", "COOL", "WARM", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SmartSettingCoolTempView.kt */
    public enum SmartSettingTempPattern {
        COOL(R.layout.view_smart_setting_cool_temp, R.id.cool_temp_text, R.string.mainview_smart_favorite_cool, R.drawable.bg_cool_temp_text, R.drawable.bg_cool_temp_text_pressed, Color.parseColor("#0F70D6")),
        WARM(R.layout.view_smart_setting_warm_temp, R.id.warm_temp_text, R.string.mainview_smart_favorite_warm, R.drawable.bg_warm_temp_text, R.drawable.bg_warm_temp_text_pressed, Color.parseColor("#D62A15"));
        
        private final int layoutId;
        private final int normalBgId;
        private final int pressedBgId;
        private final int textColorId;
        private final int textPrefixId;
        private final int textViewId;

        public static EnumEntries<SmartSettingTempPattern> getEntries() {
            return $ENTRIES;
        }

        private SmartSettingTempPattern(int i, int i2, int i3, int i4, int i5, int i6) {
            this.layoutId = i;
            this.textViewId = i2;
            this.textPrefixId = i3;
            this.normalBgId = i4;
            this.pressedBgId = i5;
            this.textColorId = i6;
        }

        public final int getLayoutId() {
            return this.layoutId;
        }

        public final int getTextViewId() {
            return this.textViewId;
        }

        public final int getTextPrefixId() {
            return this.textPrefixId;
        }

        public final int getNormalBgId() {
            return this.normalBgId;
        }

        public final int getPressedBgId() {
            return this.pressedBgId;
        }

        public final int getTextColorId() {
            return this.textColorId;
        }

        static {
            SmartSettingTempPattern[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartSettingTempView(Context context, AttributeSet attributeSet, int i, SmartSettingTempPattern smartSettingTempPattern) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(smartSettingTempPattern, TransferTable.COLUMN_TYPE);
        this.type = smartSettingTempPattern;
        this.tempUpperLimit = 30.0f;
        this.tempLowerLimit = 10.0f;
        this.currentTemp = 10.0f;
        init();
    }

    public final TextView getTextview() {
        TextView textView = this.textview;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textview");
        return null;
    }

    public final void setTextview(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.textview = textView;
    }

    public float getCurrentTemp() {
        return this.currentTemp;
    }

    public void setCurrentTemp(float f) {
        this.currentTemp = f;
    }

    private final void init() {
        View inflate = View.inflate(getContext(), this.type.getLayoutId(), this);
        Intrinsics.checkNotNull(inflate);
        initUI(inflate);
        setMovementDirectionPossible(TouchAndDragView.MovementDirection.UP_AND_DOWN);
        setMovedCompletion(new SmartSettingTempView$init$1(this));
    }

    private final void initUI(View view) {
        View findViewById = view.findViewById(this.type.getTextViewId());
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setTextview((TextView) findViewById);
    }

    /* access modifiers changed from: private */
    public final void updateText(float f) {
        if (this.type == SmartSettingTempPattern.COOL) {
            LocaleUtil localeUtil = LocaleUtil.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (localeUtil.isRtl(context)) {
                TextView textview2 = getTextview();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s%s/%s", Arrays.copyOf(new Object[]{String.valueOf(f), getContext().getString(R.string.common_celsius), getContext().getString(this.type.getTextPrefixId())}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textview2.setText(format);
                return;
            }
            TextView textview3 = getTextview();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%s/%s%s", Arrays.copyOf(new Object[]{getContext().getString(this.type.getTextPrefixId()), String.valueOf(f), getContext().getString(R.string.common_celsius)}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textview3.setText(format2);
            return;
        }
        LocaleUtil localeUtil2 = LocaleUtil.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        if (localeUtil2.isRtl(context2)) {
            TextView textview4 = getTextview();
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%s/%s%s", Arrays.copyOf(new Object[]{getContext().getString(this.type.getTextPrefixId()), String.valueOf(f), getContext().getString(R.string.common_celsius)}, 3));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            textview4.setText(format3);
            return;
        }
        TextView textview5 = getTextview();
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        String format4 = String.format("%s%s/%s", Arrays.copyOf(new Object[]{String.valueOf(f), getContext().getString(R.string.common_celsius), getContext().getString(this.type.getTextPrefixId())}, 3));
        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
        textview5.setText(format4);
    }

    /* access modifiers changed from: private */
    public final float calculateTempFromPosition(int i) {
        int i2 = this.lowerLimit;
        float f = this.tempUpperLimit;
        float f2 = this.tempLowerLimit;
        return roundHalf((((float) (i2 - i)) / (((float) (i2 - this.upperLimit)) / (f - f2))) + f2);
    }

    public final int calculatePositionFromTemp(float f) {
        int i = this.lowerLimit;
        float f2 = this.tempUpperLimit;
        float f3 = this.tempLowerLimit;
        return (int) (((float) i) - ((f - f3) * (((float) (i - this.upperLimit)) / (f2 - f3))));
    }

    private final float roundHalf(float f) {
        return (float) (((double) MathKt.roundToInt(((double) f) * 2.0d)) / 2.0d);
    }

    public final void setTextStyle(boolean z) {
        if (z) {
            getTextview().setBackgroundResource(this.type.getPressedBgId());
            getTextview().setTextColor(-1);
            return;
        }
        getTextview().setBackgroundResource(this.type.getNormalBgId());
        getTextview().setTextColor(this.type.getTextColorId());
    }

    public final void setLimit(int i, int i2) {
        this.upperLimit = i;
        this.lowerLimit = i2;
    }

    public final void initPosition() {
        int calculatePositionFromTemp = calculatePositionFromTemp(getCurrentTemp());
        layout((int) getX(), calculatePositionFromTemp, ((int) getX()) + getWidth(), getHeight() + calculatePositionFromTemp);
        updateText(getCurrentTemp());
    }
}
