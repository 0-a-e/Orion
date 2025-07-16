package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
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
/* compiled from: DatePicker.kt */
final class DatePickerKt$HorizontalMonthsList$1$2$1 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ CalendarMonth $firstMonth;
    final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $selectedDateMillis;
    final /* synthetic */ CalendarDate $today;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$HorizontalMonthsList$1$2$1(IntRange intRange, CalendarModel calendarModel, CalendarMonth calendarMonth, Function1<? super Long, Unit> function1, CalendarDate calendarDate, Long l, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors) {
        super(1);
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

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyListScope lazyListScope) {
        int numberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(this.$yearRange);
        final CalendarModel calendarModel = this.$calendarModel;
        final CalendarMonth calendarMonth = this.$firstMonth;
        final Function1<Long, Unit> function1 = this.$onDateSelectionChange;
        final CalendarDate calendarDate = this.$today;
        final Long l = this.$selectedDateMillis;
        final DatePickerFormatter datePickerFormatter = this.$dateFormatter;
        final SelectableDates selectableDates = this.$selectableDates;
        final DatePickerColors datePickerColors = this.$colors;
        LazyListScope.CC.items$default(lazyListScope, numberOfMonthsInRange, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1137566309, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                LazyItemScope lazyItemScope2 = lazyItemScope;
                int i4 = i;
                Composer composer2 = composer;
                ComposerKt.sourceInformation(composer2, "C1668@73949L634:DatePicker.kt#uh7d8r");
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
                        ComposerKt.traceEventStart(1137566309, i3, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1664)");
                    }
                    CalendarMonth plusMonths = calendarModel.plusMonths(calendarMonth, i4);
                    Modifier fillParentMaxWidth$default = LazyItemScope.CC.fillParentMaxWidth$default(lazyItemScope2, Modifier.Companion, 0.0f, 1, (Object) null);
                    Function1<Long, Unit> function1 = function1;
                    CalendarDate calendarDate = calendarDate;
                    Long l = l;
                    DatePickerFormatter datePickerFormatter = datePickerFormatter;
                    SelectableDates selectableDates = selectableDates;
                    DatePickerColors datePickerColors = datePickerColors;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillParentMaxWidth$default);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer r14 = Updater.m3282constructorimpl(composer);
                    Updater.m3289setimpl(r14, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3289setimpl(r14, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (r14.getInserting() || !Intrinsics.areEqual(r14.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                        r14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        r14.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1367623956, "C1671@74055L510:DatePicker.kt#uh7d8r");
                    DatePickerKt.Month(plusMonths, function1, calendarDate.getUtcTimeMillis(), l, (Long) null, (SelectedRangeInfo) null, datePickerFormatter, selectableDates, datePickerColors, composer, 221184);
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
