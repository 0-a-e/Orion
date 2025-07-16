package jp.co.sony.reonpocket.modules.main.view;

import android.widget.LinearLayout;
import jp.co.sony.reonpocket.view.SmartSettingCoolTempView;
import jp.co.sony.reonpocket.view.SmartSettingWarmTempView;
import jp.co.sony.reonpocket.view.TouchAndDragView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljp/co/sony/reonpocket/view/TouchAndDragView$Coordinate;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartSettingSwitchingTempFragment.kt */
final class MainSmartSettingSwitchingTempFragment$setWarmTempViewSlideLimit$1 extends Lambda implements Function1<TouchAndDragView.Coordinate, TouchAndDragView.Coordinate> {
    final /* synthetic */ SmartSettingCoolTempView $coolTemp;
    final /* synthetic */ LinearLayout $temp;
    final /* synthetic */ SmartSettingWarmTempView $warmTemp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainSmartSettingSwitchingTempFragment$setWarmTempViewSlideLimit$1(SmartSettingWarmTempView smartSettingWarmTempView, LinearLayout linearLayout, SmartSettingCoolTempView smartSettingCoolTempView) {
        super(1);
        this.$warmTemp = smartSettingWarmTempView;
        this.$temp = linearLayout;
        this.$coolTemp = smartSettingCoolTempView;
    }

    public final TouchAndDragView.Coordinate invoke(TouchAndDragView.Coordinate coordinate) {
        int i;
        Intrinsics.checkNotNullParameter(coordinate, "it");
        if (coordinate.getY() < 0) {
            i = 0;
        } else if (coordinate.getY() + this.$warmTemp.getHeight() > this.$temp.getHeight()) {
            i = this.$temp.getHeight() - this.$warmTemp.getHeight();
        } else if (((float) coordinate.getY()) < this.$coolTemp.getY()) {
            i = this.$coolTemp.getTop();
        } else {
            i = coordinate.getY();
        }
        return new TouchAndDragView.Coordinate(coordinate.getX(), i);
    }
}
