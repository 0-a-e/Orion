package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedContentScope;", "mode", "Landroidx/compose/material3/DisplayMode;", "invoke-fYndouo", "(Landroidx/compose/animation/AnimatedContentScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$SwitchableDateEntryContent$3 extends Lambda implements Function4<AnimatedContentScope, DisplayMode, Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ long $displayedMonthMillis;
    final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
    final /* synthetic */ Function1<Long, Unit> $onDisplayedMonthChange;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $selectedDateMillis;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$SwitchableDateEntryContent$3(Long l, long j, Function1<? super Long, Unit> function1, Function1<? super Long, Unit> function12, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors) {
        super(4);
        this.$selectedDateMillis = l;
        this.$displayedMonthMillis = j;
        this.$onDateSelectionChange = function1;
        this.$onDisplayedMonthChange = function12;
        this.$calendarModel = calendarModel;
        this.$yearRange = intRange;
        this.$dateFormatter = datePickerFormatter;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        m1777invokefYndouo((AnimatedContentScope) obj, ((DisplayMode) obj2).m1812unboximpl(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-fYndouo  reason: not valid java name */
    public final void m1777invokefYndouo(AnimatedContentScope animatedContentScope, int i, Composer composer, int i2) {
        int i3 = i;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "CP(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-459778869, i2, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1439)");
        }
        if (DisplayMode.m1809equalsimpl0(i3, DisplayMode.Companion.m1814getPickerjFl4v0())) {
            composer2.startReplaceableGroup(-1168710170);
            ComposerKt.sourceInformation(composer2, "1440@64331L494");
            DatePickerKt.DatePickerContent(this.$selectedDateMillis, this.$displayedMonthMillis, this.$onDateSelectionChange, this.$onDisplayedMonthChange, this.$calendarModel, this.$yearRange, this.$dateFormatter, this.$selectableDates, this.$colors, composer, 0);
            composer.endReplaceableGroup();
        } else if (DisplayMode.m1809equalsimpl0(i3, DisplayMode.Companion.m1813getInputjFl4v0())) {
            composer2.startReplaceableGroup(-1168709641);
            ComposerKt.sourceInformation(composer2, "1452@64860L367");
            DateInputKt.DateInputContent(this.$selectedDateMillis, this.$onDateSelectionChange, this.$calendarModel, this.$yearRange, this.$dateFormatter, this.$selectableDates, this.$colors, composer, 0);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-1168709264);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
