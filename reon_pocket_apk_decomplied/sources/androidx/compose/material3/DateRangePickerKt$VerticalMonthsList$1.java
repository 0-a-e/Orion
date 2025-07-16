package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$VerticalMonthsList$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ CalendarMonth $firstMonth;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function2<Long, Long, Unit> $onDatesSelectionChange;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $selectedEndDateMillis;
    final /* synthetic */ Long $selectedStartDateMillis;
    final /* synthetic */ CalendarDate $today;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$VerticalMonthsList$1(Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2, LazyListState lazyListState, IntRange intRange, CalendarModel calendarModel, CalendarMonth calendarMonth, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, CalendarDate calendarDate, SelectableDates selectableDates) {
        super(2);
        this.$selectedStartDateMillis = l;
        this.$selectedEndDateMillis = l2;
        this.$onDatesSelectionChange = function2;
        this.$lazyListState = lazyListState;
        this.$yearRange = intRange;
        this.$calendarModel = calendarModel;
        this.$firstMonth = calendarMonth;
        this.$dateFormatter = datePickerFormatter;
        this.$colors = datePickerColors;
        this.$today = calendarDate;
        this.$selectableDates = selectableDates;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r10 = r25
            r1 = r26
            java.lang.String r2 = "C780@33119L24,781@33185L59,782@33282L55,786@33518L317,810@34489L2861,803@34138L3212:DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001c
            boolean r2 = r25.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r25.skipToGroupEnd()
            goto L_0x018a
        L_0x001c:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002b
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:780)"
            r4 = 1090773432(0x4103e1b8, float:8.242607)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x002b:
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r1 = r25.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x005e
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r10)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r10.updateRememberedValue(r2)
            r1 = r2
        L_0x005e:
            r25.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r1 = r1.getCoroutineScope()
            r25.endReplaceableGroup()
            androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_date_range_picker_scroll_to_previous_month
            int r2 = androidx.compose.material3.Strings.m2224constructorimpl(r2)
            r3 = 0
            java.lang.String r2 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r2, r10, r3)
            androidx.compose.material3.Strings$Companion r4 = androidx.compose.material3.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_date_range_picker_scroll_to_next_month
            int r4 = androidx.compose.material3.Strings.m2224constructorimpl(r4)
            java.lang.String r4 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r4, r10, r3)
            r5 = 1645720805(0x6217b4e5, float:6.996233E20)
            r10.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):DateRangePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            java.lang.Long r6 = r0.$selectedStartDateMillis
            boolean r6 = r10.changed((java.lang.Object) r6)
            java.lang.Long r7 = r0.$selectedEndDateMillis
            boolean r7 = r10.changed((java.lang.Object) r7)
            r6 = r6 | r7
            kotlin.jvm.functions.Function2<java.lang.Long, java.lang.Long, kotlin.Unit> r7 = r0.$onDatesSelectionChange
            boolean r7 = r10.changed((java.lang.Object) r7)
            r6 = r6 | r7
            java.lang.Long r7 = r0.$selectedStartDateMillis
            java.lang.Long r8 = r0.$selectedEndDateMillis
            kotlin.jvm.functions.Function2<java.lang.Long, java.lang.Long, kotlin.Unit> r9 = r0.$onDatesSelectionChange
            java.lang.Object r11 = r25.rememberedValue()
            if (r6 != 0) goto L_0x00b6
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r11 != r6) goto L_0x00c1
        L_0x00b6:
            androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$onDateSelectionChange$1$1 r6 = new androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$onDateSelectionChange$1$1
            r6.<init>(r7, r8, r9)
            r11 = r6
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r10.updateRememberedValue(r11)
        L_0x00c1:
            r6 = r11
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r25.endReplaceableGroup()
            androidx.compose.foundation.lazy.LazyListState r7 = r0.$lazyListState
            java.util.List r1 = androidx.compose.material3.DateRangePickerKt.customScrollActions(r7, r1, r2, r4)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$1 r4 = androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r7 = 1
            r8 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r3, r4, r7, r8)
            androidx.compose.foundation.lazy.LazyListState r3 = r0.$lazyListState
            r4 = 1645721776(0x6217b8b0, float:6.996916E20)
            r10.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            kotlin.ranges.IntRange r4 = r0.$yearRange
            boolean r4 = r10.changedInstance(r4)
            androidx.compose.material3.CalendarModel r5 = r0.$calendarModel
            boolean r5 = r10.changedInstance(r5)
            r4 = r4 | r5
            androidx.compose.material3.CalendarMonth r5 = r0.$firstMonth
            boolean r5 = r10.changed((java.lang.Object) r5)
            r4 = r4 | r5
            androidx.compose.material3.DatePickerFormatter r5 = r0.$dateFormatter
            boolean r5 = r10.changedInstance(r5)
            r4 = r4 | r5
            boolean r5 = r10.changedInstance(r1)
            r4 = r4 | r5
            androidx.compose.material3.DatePickerColors r5 = r0.$colors
            boolean r5 = r10.changed((java.lang.Object) r5)
            r4 = r4 | r5
            java.lang.Long r5 = r0.$selectedStartDateMillis
            boolean r5 = r10.changed((java.lang.Object) r5)
            r4 = r4 | r5
            java.lang.Long r5 = r0.$selectedEndDateMillis
            boolean r5 = r10.changed((java.lang.Object) r5)
            r4 = r4 | r5
            boolean r5 = r10.changed((java.lang.Object) r6)
            r4 = r4 | r5
            androidx.compose.material3.CalendarDate r5 = r0.$today
            boolean r5 = r10.changed((java.lang.Object) r5)
            r4 = r4 | r5
            androidx.compose.material3.SelectableDates r5 = r0.$selectableDates
            boolean r5 = r10.changed((java.lang.Object) r5)
            r4 = r4 | r5
            kotlin.ranges.IntRange r13 = r0.$yearRange
            androidx.compose.material3.CalendarModel r14 = r0.$calendarModel
            androidx.compose.material3.CalendarMonth r15 = r0.$firstMonth
            java.lang.Long r5 = r0.$selectedStartDateMillis
            java.lang.Long r7 = r0.$selectedEndDateMillis
            androidx.compose.material3.CalendarDate r8 = r0.$today
            androidx.compose.material3.DatePickerFormatter r9 = r0.$dateFormatter
            androidx.compose.material3.SelectableDates r11 = r0.$selectableDates
            androidx.compose.material3.DatePickerColors r12 = r0.$colors
            java.lang.Object r0 = r25.rememberedValue()
            if (r4 != 0) goto L_0x014e
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r0 != r4) goto L_0x016a
        L_0x014e:
            androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1 r0 = new androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1
            r4 = r12
            r12 = r0
            r16 = r5
            r17 = r7
            r18 = r6
            r19 = r8
            r20 = r9
            r21 = r11
            r22 = r4
            r23 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r10.updateRememberedValue(r0)
        L_0x016a:
            r9 = r0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r25.endReplaceableGroup()
            r11 = 0
            r12 = 252(0xfc, float:3.53E-43)
            r0 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r2
            r2 = r3
            r3 = r0
            r10 = r25
            androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x018a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
