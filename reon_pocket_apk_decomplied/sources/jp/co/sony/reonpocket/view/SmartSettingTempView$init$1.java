package jp.co.sony.reonpocket.view;

import jp.co.sony.reonpocket.view.TouchAndDragView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljp/co/sony/reonpocket/view/TouchAndDragView$Coordinate;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SmartSettingCoolTempView.kt */
final class SmartSettingTempView$init$1 extends Lambda implements Function1<TouchAndDragView.Coordinate, Unit> {
    final /* synthetic */ SmartSettingTempView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartSettingTempView$init$1(SmartSettingTempView smartSettingTempView) {
        super(1);
        this.this$0 = smartSettingTempView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TouchAndDragView.Coordinate) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TouchAndDragView.Coordinate coordinate) {
        Intrinsics.checkNotNullParameter(coordinate, "it");
        float access$calculateTempFromPosition = this.this$0.calculateTempFromPosition(coordinate.getY());
        this.this$0.setCurrentTemp(access$calculateTempFromPosition);
        this.this$0.updateText(access$calculateTempFromPosition);
    }
}
