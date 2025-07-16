package androidx.compose.material3;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$HorizontalMonthsList$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ CalendarMonth $firstMonth;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $selectedDateMillis;
    final /* synthetic */ CalendarDate $today;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$HorizontalMonthsList$1(LazyListState lazyListState, IntRange intRange, CalendarModel calendarModel, CalendarMonth calendarMonth, Function1<? super Long, Unit> function1, CalendarDate calendarDate, Long l, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors) {
        super(2);
        this.$lazyListState = lazyListState;
        this.$yearRange = intRange;
        this.$calendarModel = calendarModel;
        this.$firstMonth = calendarMonth;
        this.$onDateSelectionChange = function1;
        this.$today = calendarDate;
        this.$selectedDateMillis = l;
        this.$dateFormatter = datePickerFormatter;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C1661@73673L40,1662@73724L883,1651@73041L1566:DatePicker.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1504086906, i2, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous> (DatePicker.kt:1651)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, (Object) null);
            LazyListState lazyListState = this.$lazyListState;
            FlingBehavior rememberSnapFlingBehavior$material3_release = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3_release(this.$lazyListState, (DecayAnimationSpec<Float>) null, composer, 384, 2);
            composer2.startReplaceableGroup(1286688325);
            ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
            boolean changedInstance = composer2.changedInstance(this.$yearRange) | composer2.changedInstance(this.$calendarModel) | composer2.changed((Object) this.$firstMonth) | composer2.changed((Object) this.$onDateSelectionChange) | composer2.changed((Object) this.$today) | composer2.changed((Object) this.$selectedDateMillis) | composer2.changedInstance(this.$dateFormatter) | composer2.changed((Object) this.$selectableDates) | composer2.changed((Object) this.$colors);
            IntRange intRange = this.$yearRange;
            CalendarModel calendarModel = this.$calendarModel;
            CalendarMonth calendarMonth = this.$firstMonth;
            Function1<Long, Unit> function1 = this.$onDateSelectionChange;
            CalendarDate calendarDate = this.$today;
            Long l = this.$selectedDateMillis;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            SelectableDates selectableDates = this.$selectableDates;
            DatePickerColors datePickerColors = this.$colors;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DatePickerKt$HorizontalMonthsList$1$2$1(intRange, calendarModel, calendarMonth, function1, calendarDate, l, datePickerFormatter, selectableDates, datePickerColors);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            LazyDslKt.LazyRow(semantics$default, lazyListState, (PaddingValues) null, false, (Arrangement.Horizontal) null, (Alignment.Vertical) null, rememberSnapFlingBehavior$material3_release, false, (Function1) rememberedValue, composer, 0, 188);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
