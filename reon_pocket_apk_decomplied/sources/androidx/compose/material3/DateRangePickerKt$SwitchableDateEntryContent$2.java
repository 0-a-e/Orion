package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "mode", "Landroidx/compose/material3/DisplayMode;", "invoke-QujVXRc", "(ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$SwitchableDateEntryContent$2 extends Lambda implements Function3<DisplayMode, Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ long $displayedMonthMillis;
    final /* synthetic */ Function2<Long, Long, Unit> $onDatesSelectionChange;
    final /* synthetic */ Function1<Long, Unit> $onDisplayedMonthChange;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $selectedEndDateMillis;
    final /* synthetic */ Long $selectedStartDateMillis;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$SwitchableDateEntryContent$2(Long l, Long l2, long j, Function2<? super Long, ? super Long, Unit> function2, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors) {
        super(3);
        this.$selectedStartDateMillis = l;
        this.$selectedEndDateMillis = l2;
        this.$displayedMonthMillis = j;
        this.$onDatesSelectionChange = function2;
        this.$onDisplayedMonthChange = function1;
        this.$calendarModel = calendarModel;
        this.$yearRange = intRange;
        this.$dateFormatter = datePickerFormatter;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m1793invokeQujVXRc(((DisplayMode) obj).m1812unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-QujVXRc  reason: not valid java name */
    public final void m1793invokeQujVXRc(int i, Composer composer, int i2) {
        int i3;
        int i4 = i;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "CP(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer2.changed(i4) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i3 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1026642619, i3, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:690)");
            }
            if (DisplayMode.m1809equalsimpl0(i4, DisplayMode.Companion.m1814getPickerjFl4v0())) {
                composer2.startReplaceableGroup(-1168744807);
                ComposerKt.sourceInformation(composer2, "691@29694L574");
                DateRangePickerKt.DateRangePickerContent(this.$selectedStartDateMillis, this.$selectedEndDateMillis, this.$displayedMonthMillis, this.$onDatesSelectionChange, this.$onDisplayedMonthChange, this.$calendarModel, this.$yearRange, this.$dateFormatter, this.$selectableDates, this.$colors, composer, 0);
                composer.endReplaceableGroup();
            } else if (DisplayMode.m1809equalsimpl0(i4, DisplayMode.Companion.m1813getInputjFl4v0())) {
                composer2.startReplaceableGroup(-1168744198);
                ComposerKt.sourceInformation(composer2, "704@30303L447");
                DateRangeInputKt.DateRangeInputContent(this.$selectedStartDateMillis, this.$selectedEndDateMillis, this.$onDatesSelectionChange, this.$calendarModel, this.$yearRange, this.$dateFormatter, this.$selectableDates, this.$colors, composer, 0);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-1168743741);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
