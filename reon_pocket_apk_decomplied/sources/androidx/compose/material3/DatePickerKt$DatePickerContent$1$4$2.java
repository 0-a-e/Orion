package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedVisibilityScope;", "invoke", "(Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$1$4$2 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ CalendarMonth $displayedMonth;
    final /* synthetic */ long $displayedMonthMillis;
    final /* synthetic */ LazyListState $monthsListState;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerContent$1$4$2(long j, MutableState<Boolean> mutableState, CoroutineScope coroutineScope, LazyListState lazyListState, IntRange intRange, CalendarMonth calendarMonth, SelectableDates selectableDates, CalendarModel calendarModel, DatePickerColors datePickerColors) {
        super(3);
        this.$displayedMonthMillis = j;
        this.$yearPickerVisible$delegate = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$monthsListState = lazyListState;
        this.$yearRange = intRange;
        this.$displayedMonth = calendarMonth;
        this.$selectableDates = selectableDates;
        this.$calendarModel = calendarModel;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.animation.AnimatedVisibilityScope r21, androidx.compose.runtime.Composer r22, int r23) {
        /*
            r20 = this;
            r0 = r20
            r11 = r22
            java.lang.String r1 = "C1547@69058L48,1548@69160L30,1548@69123L1872:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x001a
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1547)"
            r3 = 1193716082(0x4726a972, float:42665.445)
            r4 = r23
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r1, r2)
        L_0x001a:
            androidx.compose.material3.Strings$Companion r1 = androidx.compose.material3.Strings.Companion
            int r1 = androidx.compose.material3.R.string.m3c_date_picker_year_picker_pane_title
            int r1 = androidx.compose.material3.Strings.m2224constructorimpl(r1)
            r2 = 0
            java.lang.String r1 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r1, r11, r2)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 1247395025(0x4a59bcd1, float:3567412.2)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            boolean r5 = r11.changed((java.lang.Object) r1)
            java.lang.Object r6 = r22.rememberedValue()
            if (r5 != 0) goto L_0x0048
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x0053
        L_0x0048:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$1$1 r5 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$1$1
            r5.<init>(r1)
            r6 = r5
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r11.updateRememberedValue(r6)
        L_0x0053:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r22.endReplaceableGroup()
            r1 = 1
            r5 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r2, r6, r1, r5)
            long r6 = r0.$displayedMonthMillis
            androidx.compose.runtime.MutableState<java.lang.Boolean> r14 = r0.$yearPickerVisible$delegate
            kotlinx.coroutines.CoroutineScope r13 = r0.$coroutineScope
            androidx.compose.foundation.lazy.LazyListState r15 = r0.$monthsListState
            kotlin.ranges.IntRange r8 = r0.$yearRange
            androidx.compose.material3.CalendarMonth r3 = r0.$displayedMonth
            androidx.compose.material3.SelectableDates r9 = r0.$selectableDates
            androidx.compose.material3.CalendarModel r10 = r0.$calendarModel
            androidx.compose.material3.DatePickerColors r12 = r0.$colors
            r5 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r5 = r5.getTop()
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r0 = r16.getStart()
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r5, r0, r11, r2)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r2)
            androidx.compose.runtime.CompositionLocalMap r2 = r22.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            r17 = r12
            kotlin.jvm.functions.Function0 r12 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            r18 = r10
            androidx.compose.runtime.Applier r10 = r22.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x00b7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b7:
            r22.startReusableNode()
            boolean r10 = r22.getInserting()
            if (r10 == 0) goto L_0x00c4
            r11.createNode(r12)
            goto L_0x00c7
        L_0x00c4:
            r22.useNode()
        L_0x00c7:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3282constructorimpl(r22)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r10, r0, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r10, r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r2 = r10.getInserting()
            if (r2 != 0) goto L_0x00f7
            java.lang.Object r2 = r10.rememberedValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r12)
            if (r2 != 0) goto L_0x0105
        L_0x00f7:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r10.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r10.apply(r2, r0)
        L_0x0105:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r22)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r0)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.invoke(r0, r11, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r0)
            r0 = 276693656(0x107e0298, float:5.0094666E-29)
            java.lang.String r1 = "C79@3979L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = -1036318296(0xffffffffc23b09a8, float:-46.75943)
            java.lang.String r1 = "C1560@69919L767,1549@69214L1696,1577@70931L46:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r1 = androidx.compose.material3.DatePickerKt.getRecommendedSizeForAccessibility()
            r2 = 7
            float r2 = (float) r2
            float r1 = r1 * r2
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            androidx.compose.material3.DividerDefaults r2 = androidx.compose.material3.DividerDefaults.INSTANCE
            float r2 = r2.m1815getThicknessD9Ej5fM()
            float r1 = r1 - r2
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m731requiredHeight3ABfNKs(r0, r1)
            float r1 = androidx.compose.material3.DatePickerKt.getDatePickerHorizontalPadding()
            r2 = 0
            r5 = 2
            r10 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m672paddingVpY3zN4$default(r0, r1, r2, r5, r10)
            r0 = -1036317591(0xffffffffc23b0c69, float:-46.76212)
            r11.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            boolean r0 = r11.changed((java.lang.Object) r14)
            boolean r2 = r11.changedInstance(r13)
            r0 = r0 | r2
            boolean r2 = r11.changed((java.lang.Object) r15)
            r0 = r0 | r2
            boolean r2 = r11.changedInstance(r8)
            r0 = r0 | r2
            boolean r2 = r11.changed((java.lang.Object) r3)
            r0 = r0 | r2
            java.lang.Object r2 = r22.rememberedValue()
            if (r0 != 0) goto L_0x018b
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0188
            goto L_0x018b
        L_0x0188:
            r19 = r17
            goto L_0x019d
        L_0x018b:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1 r0 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1
            r19 = r17
            r12 = r0
            r16 = r8
            r17 = r3
            r12.<init>(r13, r14, r15, r16, r17)
            r2 = r0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r11.updateRememberedValue(r2)
        L_0x019d:
            r4 = r2
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r22.endReplaceableGroup()
            r10 = 6
            r2 = r6
            r5 = r9
            r6 = r18
            r7 = r8
            r8 = r19
            r9 = r22
            androidx.compose.material3.DatePickerKt.YearPicker(r1, r2, r4, r5, r6, r7, r8, r9, r10)
            long r3 = r19.m1749getDividerColor0d7_KjU()
            r6 = 0
            r7 = 3
            r1 = 0
            r2 = 0
            r5 = r22
            androidx.compose.material3.DividerKt.m1817HorizontalDivider9IZ8Weo(r1, r2, r3, r5, r6, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r22)
            r22.endReplaceableGroup()
            r22.endNode()
            r22.endReplaceableGroup()
            r22.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2.invoke(androidx.compose.animation.AnimatedVisibilityScope, androidx.compose.runtime.Composer, int):void");
    }
}
