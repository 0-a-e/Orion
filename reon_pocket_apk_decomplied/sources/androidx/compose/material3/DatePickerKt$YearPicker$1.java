package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$YearPicker$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ long $displayedMonthMillis;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$YearPicker$1(CalendarModel calendarModel, long j, IntRange intRange, DatePickerColors datePickerColors, Modifier modifier, Function1<? super Integer, Unit> function1, SelectableDates selectableDates) {
        super(2);
        this.$calendarModel = calendarModel;
        this.$displayedMonthMillis = j;
        this.$yearRange = intRange;
        this.$colors = datePickerColors;
        this.$modifier = modifier;
        this.$onYearSelected = function1;
        this.$selectableDates = selectableDates;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r11 = r25
            r1 = r26
            java.lang.String r2 = "C2000@86448L319,2008@86911L11,2010@87049L7,2008@86923L143,2012@87096L24,2013@87161L53,2014@87253L51,2027@87936L2261,2015@87313L2884:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001c
            boolean r2 = r25.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r25.skipToGroupEnd()
            goto L_0x01b6
        L_0x001c:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002b
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:1997)"
            r5 = 1301915789(0x4d99a88d, float:3.22245024E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r1, r2, r4)
        L_0x002b:
            androidx.compose.material3.CalendarModel r1 = r0.$calendarModel
            androidx.compose.material3.CalendarDate r2 = r1.getToday()
            androidx.compose.material3.CalendarMonth r1 = r1.getMonth((androidx.compose.material3.CalendarDate) r2)
            int r7 = r1.getYear()
            androidx.compose.material3.CalendarModel r1 = r0.$calendarModel
            long r4 = r0.$displayedMonthMillis
            androidx.compose.material3.CalendarMonth r1 = r1.getMonth((long) r4)
            int r8 = r1.getYear()
            kotlin.ranges.IntRange r1 = r0.$yearRange
            int r1 = r1.getFirst()
            int r1 = r8 - r1
            r9 = 3
            int r1 = r1 - r9
            r10 = 0
            int r1 = java.lang.Math.max(r10, r1)
            androidx.compose.foundation.lazy.grid.LazyGridState r15 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r1, r10, r11, r10, r3)
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material3.ColorScheme r1 = r1.getColorScheme(r11, r2)
            androidx.compose.material3.DatePickerColors r2 = r0.$colors
            long r2 = r2.m1738getContainerColor0d7_KjU()
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material3.SurfaceKt.getLocalAbsoluteTonalElevation()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r4 = r11.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r25)
            androidx.compose.ui.unit.Dp r4 = (androidx.compose.ui.unit.Dp) r4
            float r4 = r4.m6628unboximpl()
            r6 = 0
            r5 = r25
            long r17 = androidx.compose.material3.ColorSchemeKt.m1679applyTonalElevationRFCenO8(r1, r2, r4, r5, r6)
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r1 = r25.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x00ba
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r11)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r11.updateRememberedValue(r2)
            r1 = r2
        L_0x00ba:
            r25.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r1 = r1.getCoroutineScope()
            r25.endReplaceableGroup()
            androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_date_picker_scroll_to_earlier_years
            int r2 = androidx.compose.material3.Strings.m2224constructorimpl(r2)
            java.lang.String r2 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r2, r11, r10)
            androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
            int r3 = androidx.compose.material3.R.string.m3c_date_picker_scroll_to_later_years
            int r3 = androidx.compose.material3.Strings.m2224constructorimpl(r3)
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r3, r11, r10)
            androidx.compose.foundation.lazy.grid.GridCells$Fixed r4 = new androidx.compose.foundation.lazy.grid.GridCells$Fixed
            r4.<init>(r9)
            androidx.compose.ui.Modifier r5 = r0.$modifier
            r20 = 2
            r21 = 0
            r19 = 0
            r16 = r5
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.BackgroundKt.m214backgroundbw27NRU$default(r16, r17, r19, r20, r21)
            androidx.compose.material3.DatePickerKt$YearPicker$1$1 r6 = androidx.compose.material3.DatePickerKt$YearPicker$1.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r9 = 1
            r12 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r5, r10, r6, r9, r12)
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r6 = r6.getSpaceEvenly()
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r10 = androidx.compose.material3.DatePickerKt.YearsVerticalPadding
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r9 = r9.m537spacedBy0680j_4(r10)
            androidx.compose.foundation.lazy.grid.GridCells r4 = (androidx.compose.foundation.lazy.grid.GridCells) r4
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = (androidx.compose.foundation.layout.Arrangement.Vertical) r9
            r10 = r6
            androidx.compose.foundation.layout.Arrangement$Horizontal r10 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r10
            r6 = -969328877(0xffffffffc6393713, float:-11853.769)
            r11.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r6)
            kotlin.ranges.IntRange r6 = r0.$yearRange
            boolean r6 = r11.changedInstance(r6)
            boolean r12 = r11.changed((java.lang.Object) r15)
            r6 = r6 | r12
            boolean r12 = r11.changedInstance(r1)
            r6 = r6 | r12
            boolean r12 = r11.changed((java.lang.Object) r2)
            r6 = r6 | r12
            boolean r12 = r11.changed((java.lang.Object) r3)
            r6 = r6 | r12
            boolean r12 = r11.changed((int) r8)
            r6 = r6 | r12
            boolean r12 = r11.changed((int) r7)
            r6 = r6 | r12
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r12 = r0.$onYearSelected
            boolean r12 = r11.changed((java.lang.Object) r12)
            r6 = r6 | r12
            androidx.compose.material3.SelectableDates r12 = r0.$selectableDates
            boolean r12 = r11.changed((java.lang.Object) r12)
            r6 = r6 | r12
            androidx.compose.material3.DatePickerColors r12 = r0.$colors
            boolean r12 = r11.changed((java.lang.Object) r12)
            r6 = r6 | r12
            kotlin.ranges.IntRange r13 = r0.$yearRange
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r14 = r0.$onYearSelected
            androidx.compose.material3.SelectableDates r12 = r0.$selectableDates
            r26 = r10
            androidx.compose.material3.DatePickerColors r10 = r0.$colors
            java.lang.Object r0 = r25.rememberedValue()
            if (r6 != 0) goto L_0x0172
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r0 != r6) goto L_0x016f
            goto L_0x0172
        L_0x016f:
            r23 = r15
            goto L_0x0190
        L_0x0172:
            androidx.compose.material3.DatePickerKt$YearPicker$1$2$1 r0 = new androidx.compose.material3.DatePickerKt$YearPicker$1$2$1
            r6 = r12
            r12 = r0
            r20 = r14
            r14 = r15
            r23 = r15
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r8
            r19 = r7
            r21 = r6
            r22 = r10
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r11.updateRememberedValue(r0)
        L_0x0190:
            r10 = r0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r25.endReplaceableGroup()
            r12 = 1769472(0x1b0000, float:2.479558E-39)
            r13 = 408(0x198, float:5.72E-43)
            r0 = 0
            r6 = 0
            r8 = 0
            r14 = 0
            r1 = r4
            r2 = r5
            r3 = r23
            r4 = r0
            r5 = r6
            r6 = r9
            r7 = r26
            r9 = r14
            r11 = r25
            androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$YearPicker$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
