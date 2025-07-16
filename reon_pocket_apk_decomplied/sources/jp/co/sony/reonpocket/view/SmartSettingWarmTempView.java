package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.util.AttributeSet;
import jp.co.sony.reonpocket.common.SmartSwitchThreshold;
import jp.co.sony.reonpocket.view.SmartSettingTempView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/view/SmartSettingWarmTempView;", "Ljp/co/sony/reonpocket/view/SmartSettingTempView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentTemp", "", "getCurrentTemp", "()F", "setCurrentTemp", "(F)V", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SmartSettingCoolTempView.kt */
public final class SmartSettingWarmTempView extends SmartSettingTempView {
    public static final int $stable = 8;
    private float currentTemp;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmartSettingWarmTempView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmartSettingWarmTempView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmartSettingWarmTempView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartSettingWarmTempView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, SmartSettingTempView.SmartSettingTempPattern.WARM);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentTemp = SmartSwitchThreshold.INSTANCE.getSmartWarmTempSwitchThreshold(context);
    }

    public float getCurrentTemp() {
        return this.currentTemp;
    }

    public void setCurrentTemp(float f) {
        this.currentTemp = f;
    }
}
