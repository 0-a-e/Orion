package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.view.SmartSettingCoolTempView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartSettingSwitchingTempFragment.kt */
final class MainSmartSettingSwitchingTempFragment$setTouchAction$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ MainSmartSettingSwitchingTempFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainSmartSettingSwitchingTempFragment$setTouchAction$1(MainSmartSettingSwitchingTempFragment mainSmartSettingSwitchingTempFragment) {
        super(1);
        this.this$0 = mainSmartSettingSwitchingTempFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (i == 0) {
            this.this$0.parentModalSwipeEnabled(false);
            SmartSettingCoolTempView access$getMCoolTempTextView$p = this.this$0.mCoolTempTextView;
            if (access$getMCoolTempTextView$p != null) {
                access$getMCoolTempTextView$p.setTextStyle(true);
            }
            this.this$0.setCoolInitTextTransparent(false);
        } else if (i == 1) {
            this.this$0.parentModalSwipeEnabled(true);
            SmartSettingCoolTempView access$getMCoolTempTextView$p2 = this.this$0.mCoolTempTextView;
            if (access$getMCoolTempTextView$p2 != null) {
                access$getMCoolTempTextView$p2.setTextStyle(false);
            }
            this.this$0.setCoolInitTextTransparent(true);
        }
    }
}
