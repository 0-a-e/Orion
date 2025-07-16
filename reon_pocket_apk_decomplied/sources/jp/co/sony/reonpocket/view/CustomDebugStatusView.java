package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.entity.NotifyDeviceSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.ThermoControlStatusEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0018R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomDebugStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clothesHumi", "Landroid/widget/TextView;", "clothesTemp", "fanCurrentPower", "finTemp", "tagALS", "tagPS", "tecCurrentPower", "tecTemp", "setStatusText", "", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyDeviceSensorDataEntity;", "Ljp/co/sony/reonpocket/data/entity/ThermoControlStatusEntity;", "setTagStatusText", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomDebugStatusView.kt */
public final class CustomDebugStatusView extends ConstraintLayout {
    public static final int $stable = 8;
    private TextView clothesHumi;
    private TextView clothesTemp;
    private TextView fanCurrentPower;
    private TextView finTemp;
    private TextView tagALS;
    private TextView tagPS;
    private TextView tecCurrentPower;
    private TextView tecTemp;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomDebugStatusView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomDebugStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomDebugStatusView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomDebugStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.view_debug_status, this);
        View findViewById = findViewById(R.id.tecTemp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.tecTemp = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.finTemp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.finTemp = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.clothesTemp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.clothesTemp = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.clothesHumi);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.clothesHumi = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.tagALS);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.tagALS = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.tagPS);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.tagPS = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.peltier_output);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.tecCurrentPower = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.fan_output);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.fanCurrentPower = (TextView) findViewById8;
    }

    public final void setStatusText(NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity) {
        Intrinsics.checkNotNullParameter(notifyDeviceSensorDataEntity, "entity");
        TextView textView = this.tecTemp;
        String format = String.format("TecTemp: %.2f ℃", Arrays.copyOf(new Object[]{Float.valueOf(notifyDeviceSensorDataEntity.getTec1Temp())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        TextView textView2 = this.finTemp;
        String format2 = String.format("FinTemp: %.2f ℃", Arrays.copyOf(new Object[]{Float.valueOf(notifyDeviceSensorDataEntity.getFinTemp())}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView2.setText(format2);
        if (notifyDeviceSensorDataEntity.getInnerTempB() == -0.01f && notifyDeviceSensorDataEntity.getInnerHumiB() == -0.01f) {
            TextView textView3 = this.clothesTemp;
            String format3 = String.format("CloTempA: %.2f ℃", Arrays.copyOf(new Object[]{Float.valueOf(notifyDeviceSensorDataEntity.getInnerTempA())}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            textView3.setText(format3);
            return;
        }
        TextView textView4 = this.clothesTemp;
        String format4 = String.format("CloTempB: %.2f ℃", Arrays.copyOf(new Object[]{Float.valueOf(notifyDeviceSensorDataEntity.getInnerTempB())}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
        textView4.setText(format4);
        TextView textView5 = this.clothesHumi;
        String format5 = String.format("CloHumiB: %.2f ％", Arrays.copyOf(new Object[]{Float.valueOf(notifyDeviceSensorDataEntity.getInnerHumiB())}, 1));
        Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
        textView5.setText(format5);
    }

    public final void setStatusText(ThermoControlStatusEntity thermoControlStatusEntity) {
        Intrinsics.checkNotNullParameter(thermoControlStatusEntity, "entity");
        TextView textView = this.tecCurrentPower;
        String format = String.format("Peltier: %.2f W", Arrays.copyOf(new Object[]{Double.valueOf(((double) thermoControlStatusEntity.getTec1CurrentPower()) / 10000.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        int fanCurrentPower2 = thermoControlStatusEntity.getFanCurrentPower();
        TextView textView2 = this.fanCurrentPower;
        textView2.setText("Fan: " + fanCurrentPower2 + " ％");
    }

    public final void setTagStatusText(NotifyTagSensorDataEntity notifyTagSensorDataEntity) {
        Intrinsics.checkNotNullParameter(notifyTagSensorDataEntity, "entity");
        if (notifyTagSensorDataEntity.getTagIllumination() != 65535) {
            this.tagALS.setVisibility(0);
            TextView textView = this.tagALS;
            String format = String.format("TagALS: %d", Arrays.copyOf(new Object[]{Integer.valueOf(notifyTagSensorDataEntity.getTagIllumination())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        } else {
            this.tagALS.setVisibility(4);
        }
        if (notifyTagSensorDataEntity.getTagProximity() != 65535) {
            this.tagPS.setVisibility(0);
            TextView textView2 = this.tagPS;
            String format2 = String.format("TagPS: %d", Arrays.copyOf(new Object[]{Integer.valueOf(notifyTagSensorDataEntity.getTagProximity() * 16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView2.setText(format2);
            return;
        }
        this.tagPS.setVisibility(4);
    }
}
