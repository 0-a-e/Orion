package jp.co.sony.reonpocket.modules.main.view;

import android.os.Handler;
import android.widget.TextView;
import java.util.Arrays;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.SmartSettingCoolTempView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainSmartSettingSwitchingTempFragment$onResume$1$2", "Ljava/lang/Runnable;", "run", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartSettingSwitchingTempFragment.kt */
public final class MainSmartSettingSwitchingTempFragment$onResume$1$2 implements Runnable {
    final /* synthetic */ double $endValue;
    final /* synthetic */ Handler $handler;
    final /* synthetic */ Ref.DoubleRef $i;
    final /* synthetic */ double $interval;
    final /* synthetic */ SmartSettingCoolTempView $it;
    final /* synthetic */ MainSmartSettingSwitchingTempFragment this$0;

    MainSmartSettingSwitchingTempFragment$onResume$1$2(SmartSettingCoolTempView smartSettingCoolTempView, MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment, Ref.DoubleRef doubleRef, double d, Handler handler, double d2) {
        this.$it = smartSettingCoolTempView;
        this.this$0 = mainSmartSettingSwitchingTempFragment;
        this.$i = doubleRef;
        this.$endValue = d;
        this.$handler = handler;
        this.$interval = d2;
    }

    public void run() {
        TextView textview = this.$it.getTextview();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/%s%s", Arrays.copyOf(new Object[]{this.this$0.requireContext().getString(R.string.mainview_smart_favorite_cool), String.valueOf(this.$i.element), this.this$0.requireContext().getString(R.string.common_celsius)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textview.setText(format);
        this.$i.element += 0.5d;
        if (this.$i.element <= this.$endValue) {
            this.$handler.postDelayed(this, (long) this.$interval);
        }
    }
}
