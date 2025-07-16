package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Track$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $activeTickColor;
    final /* synthetic */ long $activeTrackColor;
    final /* synthetic */ long $inactiveTickColor;
    final /* synthetic */ long $inactiveTrackColor;
    final /* synthetic */ SliderPositions $sliderPositions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderDefaults$Track$1$1(long j, SliderPositions sliderPositions, long j2, long j3, long j4) {
        super(1);
        this.$inactiveTrackColor = j;
        this.$sliderPositions = sliderPositions;
        this.$activeTrackColor = j2;
        this.$inactiveTickColor = j3;
        this.$activeTickColor = j4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(0.0f, Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc()), Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0()));
        long j = z ? Offset2 : Offset;
        long j2 = z ? Offset : Offset2;
        float r18 = drawScope2.m6550toPx0680j_4(SliderKt.TickSize);
        float r8 = drawScope2.m6550toPx0680j_4(SliderKt.getTrackHeight());
        long j3 = j2;
        long j4 = j;
        DrawScope.CC.m4462drawLineNGM6Ib0$default(drawScope, this.$inactiveTrackColor, j, j2, r8, StrokeCap.Companion.m4231getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, MainPresenterKt.EIGHT_HOURS_IN_MINUTES, (Object) null);
        DrawScope.CC.m4462drawLineNGM6Ib0$default(drawScope, this.$activeTrackColor, OffsetKt.Offset(Offset.m3562getXimpl(j4) + ((Offset.m3562getXimpl(j3) - Offset.m3562getXimpl(j4)) * this.$sliderPositions.getActiveRange().getStart().floatValue()), Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3562getXimpl(j4) + ((Offset.m3562getXimpl(j3) - Offset.m3562getXimpl(j4)) * this.$sliderPositions.getActiveRange().getEndInclusive().floatValue()), Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0())), r8, StrokeCap.Companion.m4231getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, MainPresenterKt.EIGHT_HOURS_IN_MINUTES, (Object) null);
        float[] tickFractions = this.$sliderPositions.getTickFractions();
        SliderPositions sliderPositions = this.$sliderPositions;
        Map linkedHashMap = new LinkedHashMap();
        int length = tickFractions.length;
        for (int i = 0; i < length; i++) {
            float f = tickFractions[i];
            Boolean valueOf = Boolean.valueOf(f > sliderPositions.getActiveRange().getEndInclusive().floatValue() || f < sliderPositions.getActiveRange().getStart().floatValue());
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(Float.valueOf(f));
        }
        long j5 = this.$inactiveTickColor;
        long j6 = this.$activeTickColor;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                arrayList.add(Offset.m3551boximpl(OffsetKt.Offset(Offset.m3562getXimpl(OffsetKt.m3585lerpWko1d7g(j4, j3, ((Number) list.get(i2)).floatValue())), Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0()))));
                i2++;
            }
            long j7 = j4;
            j3 = j3;
            DrawScope.CC.m4467drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.Companion.m4153getPointsr_lszbg(), booleanValue ? j5 : j6, r18, StrokeCap.Companion.m4231getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, MainPresenterKt.EIGHT_HOURS_IN_MINUTES, (Object) null);
            j6 = j6;
            j4 = j7;
        }
    }
}
