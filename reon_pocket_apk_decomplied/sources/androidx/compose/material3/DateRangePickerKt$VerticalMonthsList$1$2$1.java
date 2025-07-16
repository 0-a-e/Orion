package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyListScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$VerticalMonthsList$1$2$1 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ List<CustomAccessibilityAction> $customAccessibilityAction;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ CalendarMonth $firstMonth;
    final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $selectedEndDateMillis;
    final /* synthetic */ Long $selectedStartDateMillis;
    final /* synthetic */ CalendarDate $today;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$VerticalMonthsList$1$2$1(IntRange intRange, CalendarModel calendarModel, CalendarMonth calendarMonth, Long l, Long l2, Function1<? super Long, Unit> function1, CalendarDate calendarDate, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, List<CustomAccessibilityAction> list) {
        super(1);
        this.$yearRange = intRange;
        this.$calendarModel = calendarModel;
        this.$firstMonth = calendarMonth;
        this.$selectedStartDateMillis = l;
        this.$selectedEndDateMillis = l2;
        this.$onDateSelectionChange = function1;
        this.$today = calendarDate;
        this.$dateFormatter = datePickerFormatter;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
        this.$customAccessibilityAction = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyListScope lazyListScope) {
        int numberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(this.$yearRange);
        final CalendarModel calendarModel = this.$calendarModel;
        final CalendarMonth calendarMonth = this.$firstMonth;
        final Long l = this.$selectedStartDateMillis;
        final Long l2 = this.$selectedEndDateMillis;
        final Function1<Long, Unit> function1 = this.$onDateSelectionChange;
        final CalendarDate calendarDate = this.$today;
        final DatePickerFormatter datePickerFormatter = this.$dateFormatter;
        final SelectableDates selectableDates = this.$selectableDates;
        final DatePickerColors datePickerColors = this.$colors;
        final List<CustomAccessibilityAction> list = this.$customAccessibilityAction;
        LazyListScope.CC.items$default(lazyListScope, numberOfMonthsInRange, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1413501381, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                SelectedRangeInfo selectedRangeInfo;
                LazyItemScope lazyItemScope2 = lazyItemScope;
                int i4 = i;
                Composer composer2 = composer;
                ComposerKt.sourceInformation(composer2, "C817@34746L2580:DateRangePicker.kt#uh7d8r");
                if ((i2 & 6) == 0) {
                    i3 = i2 | (composer2.changed((Object) lazyItemScope2) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer2.changed(i4) ? 32 : 16;
                }
                if ((i3 & 147) != 146 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1413501381, i3, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:812)");
                    }
                    CalendarMonth plusMonths = calendarModel.plusMonths(calendarMonth, i4);
                    Modifier fillParentMaxWidth$default = LazyItemScope.CC.fillParentMaxWidth$default(lazyItemScope2, Modifier.Companion, 0.0f, 1, (Object) null);
                    Long l = l;
                    Long l2 = l2;
                    Function1<Long, Unit> function1 = function1;
                    CalendarDate calendarDate = calendarDate;
                    DatePickerFormatter datePickerFormatter = datePickerFormatter;
                    SelectableDates selectableDates = selectableDates;
                    DatePickerColors datePickerColors = datePickerColors;
                    List<CustomAccessibilityAction> list = list;
                    CalendarModel calendarModel = calendarModel;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillParentMaxWidth$default);
                    SelectableDates selectableDates2 = selectableDates;
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer r0 = Updater.m3282constructorimpl(composer);
                    Updater.m3289setimpl(r0, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3289setimpl(r0, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                        r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        r0.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1455464542, "C821@34911L10,820@34855L947,857@36762L546:DateRangePicker.kt#uh7d8r");
                    TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadFont()), ComposableLambdaKt.composableLambda(composer2, 1622100276, true, new DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1(datePickerFormatter, plusMonths, list, datePickerColors)), composer2, 48);
                    composer2.startReplaceableGroup(-1455463505);
                    ComposerKt.sourceInformation(composer2, "843@36045L604");
                    if (l == null || l2 == null) {
                        selectedRangeInfo = null;
                    } else {
                        composer2.startReplaceableGroup(-1455463352);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean changed = composer2.changed((Object) l) | composer2.changed((Object) l2);
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SelectedRangeInfo.Companion.calculateRangeInfo(plusMonths, calendarModel.getCanonicalDate(l.longValue()), calendarModel.getCanonicalDate(l2.longValue()));
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceableGroup();
                        selectedRangeInfo = (SelectedRangeInfo) rememberedValue;
                    }
                    composer.endReplaceableGroup();
                    DatePickerKt.Month(plusMonths, function1, calendarDate.getUtcTimeMillis(), l, l2, selectedRangeInfo, datePickerFormatter, selectableDates2, datePickerColors, composer, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 6, (Object) null);
    }
}
