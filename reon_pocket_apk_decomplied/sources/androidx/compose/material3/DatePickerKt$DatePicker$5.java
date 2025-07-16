package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePicker$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePicker$5(DatePickerState datePickerState, CalendarModel calendarModel, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors) {
        super(2);
        this.$state = datePickerState;
        this.$calendarModel = calendarModel;
        this.$dateFormatter = datePickerFormatter;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r15 & 3
            r1 = 2
            if (r0 != r1) goto L_0x0016
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r14.skipToGroupEnd()
            goto L_0x00b9
        L_0x0016:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0025
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)"
            r2 = -1840727866(0xffffffff9248b8c6, float:-6.3336623E-28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r15, r0, r1)
        L_0x0025:
            androidx.compose.material3.DatePickerState r15 = r13.$state
            java.lang.Long r0 = r15.getSelectedDateMillis()
            androidx.compose.material3.DatePickerState r15 = r13.$state
            long r1 = r15.getDisplayedMonthMillis()
            androidx.compose.material3.DatePickerState r15 = r13.$state
            int r3 = r15.m1778getDisplayModejFl4v0()
            r15 = -1036919665(0xffffffffc231dc8f, float:-44.46539)
            r14.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            androidx.compose.material3.DatePickerState r4 = r13.$state
            boolean r4 = r14.changed((java.lang.Object) r4)
            androidx.compose.material3.DatePickerState r5 = r13.$state
            java.lang.Object r6 = r14.rememberedValue()
            if (r4 != 0) goto L_0x0058
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x0063
        L_0x0058:
            androidx.compose.material3.DatePickerKt$DatePicker$5$1$1 r4 = new androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
            r4.<init>(r5)
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r14.updateRememberedValue(r6)
        L_0x0063:
            r4 = r6
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r14.endReplaceableGroup()
            r5 = -1036919567(0xffffffffc231dcf1, float:-44.465763)
            r14.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            androidx.compose.material3.DatePickerState r15 = r13.$state
            boolean r15 = r14.changed((java.lang.Object) r15)
            androidx.compose.material3.DatePickerState r5 = r13.$state
            java.lang.Object r6 = r14.rememberedValue()
            if (r15 != 0) goto L_0x0088
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r6 != r15) goto L_0x0093
        L_0x0088:
            androidx.compose.material3.DatePickerKt$DatePicker$5$2$1 r15 = new androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
            r15.<init>(r5)
            r6 = r15
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r14.updateRememberedValue(r6)
        L_0x0093:
            r5 = r6
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r14.endReplaceableGroup()
            androidx.compose.material3.CalendarModel r6 = r13.$calendarModel
            androidx.compose.material3.DatePickerState r15 = r13.$state
            kotlin.ranges.IntRange r7 = r15.getYearRange()
            androidx.compose.material3.DatePickerFormatter r8 = r13.$dateFormatter
            androidx.compose.material3.DatePickerState r15 = r13.$state
            androidx.compose.material3.SelectableDates r9 = r15.getSelectableDates()
            androidx.compose.material3.DatePickerColors r10 = r13.$colors
            r12 = 0
            r11 = r14
            androidx.compose.material3.DatePickerKt.m1772SwitchableDateEntryContentd7iavvg(r0, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x00b9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$DatePicker$5.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
