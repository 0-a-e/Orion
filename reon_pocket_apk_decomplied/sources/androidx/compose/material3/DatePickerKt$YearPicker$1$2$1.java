package androidx.compose.material3;

import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$YearPicker$1$2$1 extends Lambda implements Function1<LazyGridScope, Unit> {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ int $currentYear;
    final /* synthetic */ int $displayedYear;
    final /* synthetic */ LazyGridState $lazyGridState;
    final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
    final /* synthetic */ String $scrollToEarlierYearsLabel;
    final /* synthetic */ String $scrollToLaterYearsLabel;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$YearPicker$1$2$1(IntRange intRange, LazyGridState lazyGridState, CoroutineScope coroutineScope, String str, String str2, int i, int i2, Function1<? super Integer, Unit> function1, SelectableDates selectableDates, DatePickerColors datePickerColors) {
        super(1);
        this.$yearRange = intRange;
        this.$lazyGridState = lazyGridState;
        this.$coroutineScope = coroutineScope;
        this.$scrollToEarlierYearsLabel = str;
        this.$scrollToLaterYearsLabel = str2;
        this.$displayedYear = i;
        this.$currentYear = i2;
        this.$onYearSelected = function1;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyGridScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyGridScope lazyGridScope) {
        int count = CollectionsKt.count(this.$yearRange);
        final IntRange intRange = this.$yearRange;
        final LazyGridState lazyGridState = this.$lazyGridState;
        final CoroutineScope coroutineScope = this.$coroutineScope;
        final String str = this.$scrollToEarlierYearsLabel;
        final String str2 = this.$scrollToLaterYearsLabel;
        final int i = this.$displayedYear;
        final int i2 = this.$currentYear;
        final Function1<Integer, Unit> function1 = this.$onYearSelected;
        final SelectableDates selectableDates = this.$selectableDates;
        final DatePickerColors datePickerColors = this.$colors;
        LazyGridScope.CC.items$default(lazyGridScope, count, (Function1) null, (Function2) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1040623618, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: kotlin.jvm.functions.Function0} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(androidx.compose.foundation.lazy.grid.LazyGridItemScope r17, int r18, androidx.compose.runtime.Composer r19, int r20) {
                /*
                    r16 = this;
                    r0 = r16
                    r3 = r18
                    r9 = r19
                    java.lang.String r1 = "C2037@88435L975,2056@89567L32,*2058@89713L54,2031@88114L2059:DatePicker.kt#uh7d8r"
                    androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
                    r1 = r20 & 48
                    r2 = 32
                    if (r1 != 0) goto L_0x001e
                    boolean r1 = r9.changed((int) r3)
                    if (r1 == 0) goto L_0x0019
                    r1 = r2
                    goto L_0x001b
                L_0x0019:
                    r1 = 16
                L_0x001b:
                    r1 = r20 | r1
                    goto L_0x0020
                L_0x001e:
                    r1 = r20
                L_0x0020:
                    r4 = r1 & 145(0x91, float:2.03E-43)
                    r5 = 144(0x90, float:2.02E-43)
                    if (r4 != r5) goto L_0x0032
                    boolean r4 = r19.getSkipping()
                    if (r4 != 0) goto L_0x002d
                    goto L_0x0032
                L_0x002d:
                    r19.skipToGroupEnd()
                    goto L_0x0149
                L_0x0032:
                    boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r4 == 0) goto L_0x0041
                    r4 = -1
                    java.lang.String r5 = "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2029)"
                    r6 = 1040623618(0x3e06a802, float:0.13150027)
                    androidx.compose.runtime.ComposerKt.traceEventStart(r6, r1, r4, r5)
                L_0x0041:
                    kotlin.ranges.IntRange r4 = r4
                    int r4 = r4.getFirst()
                    int r7 = r3 + r4
                    r14 = 7
                    r15 = 0
                    r11 = 0
                    r12 = 0
                    r13 = 0
                    r10 = r7
                    java.lang.String r8 = androidx.compose.material3.ActualJvm_jvmKt.toLocalString$default(r10, r11, r12, r13, r14, r15)
                    androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
                    androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
                    androidx.compose.material3.tokens.DatePickerModalTokens r5 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
                    float r5 = r5.m2797getSelectionYearContainerWidthD9Ej5fM()
                    androidx.compose.material3.tokens.DatePickerModalTokens r6 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
                    float r6 = r6.m2796getSelectionYearContainerHeightD9Ej5fM()
                    androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.m736requiredSizeVpY3zN4(r4, r5, r6)
                    r4 = -1669466775(0xffffffff9c7df569, float:-8.4027863E-22)
                    r9.startReplaceableGroup(r4)
                    java.lang.String r11 = "CC(remember):DatePicker.kt#9igjgp"
                    androidx.compose.runtime.ComposerKt.sourceInformation(r9, r11)
                    androidx.compose.foundation.lazy.grid.LazyGridState r4 = r5
                    boolean r4 = r9.changed((java.lang.Object) r4)
                    r1 = r1 & 112(0x70, float:1.57E-43)
                    r13 = 1
                    if (r1 != r2) goto L_0x007f
                    r1 = r13
                    goto L_0x0080
                L_0x007f:
                    r1 = r12
                L_0x0080:
                    r1 = r1 | r4
                    kotlinx.coroutines.CoroutineScope r2 = r6
                    boolean r2 = r9.changedInstance(r2)
                    r1 = r1 | r2
                    java.lang.String r2 = r7
                    boolean r2 = r9.changed((java.lang.Object) r2)
                    r1 = r1 | r2
                    java.lang.String r2 = r8
                    boolean r2 = r9.changed((java.lang.Object) r2)
                    r1 = r1 | r2
                    androidx.compose.foundation.lazy.grid.LazyGridState r2 = r5
                    kotlinx.coroutines.CoroutineScope r4 = r6
                    java.lang.String r5 = r7
                    java.lang.String r6 = r8
                    java.lang.Object r14 = r19.rememberedValue()
                    if (r1 != 0) goto L_0x00ac
                    androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r1 = r1.getEmpty()
                    if (r14 != r1) goto L_0x00b9
                L_0x00ac:
                    androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$1$1 r14 = new androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$1$1
                    r1 = r14
                    r3 = r18
                    r1.<init>(r2, r3, r4, r5, r6)
                    kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
                    r9.updateRememberedValue(r14)
                L_0x00b9:
                    kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
                    r19.endReplaceableGroup()
                    r1 = 0
                    androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r10, r12, r14, r13, r1)
                    int r2 = r9
                    if (r7 != r2) goto L_0x00c9
                    r2 = r13
                    goto L_0x00ca
                L_0x00c9:
                    r2 = r12
                L_0x00ca:
                    int r3 = r10
                    if (r7 != r3) goto L_0x00d0
                    r3 = r13
                    goto L_0x00d1
                L_0x00d0:
                    r3 = r12
                L_0x00d1:
                    r4 = -1669465643(0xffffffff9c7df9d5, float:-8.403358E-22)
                    r9.startReplaceableGroup(r4)
                    androidx.compose.runtime.ComposerKt.sourceInformation(r9, r11)
                    kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r4 = r11
                    boolean r4 = r9.changed((java.lang.Object) r4)
                    boolean r5 = r9.changed((int) r7)
                    r4 = r4 | r5
                    kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r5 = r11
                    java.lang.Object r6 = r19.rememberedValue()
                    if (r4 != 0) goto L_0x00f5
                    androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r4 = r4.getEmpty()
                    if (r6 != r4) goto L_0x0100
                L_0x00f5:
                    androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$2$1 r4 = new androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$2$1
                    r4.<init>(r5, r7)
                    r6 = r4
                    kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                    r9.updateRememberedValue(r6)
                L_0x0100:
                    r4 = r6
                    kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
                    r19.endReplaceableGroup()
                    androidx.compose.material3.SelectableDates r5 = r12
                    boolean r5 = r5.isSelectableYear(r7)
                    androidx.compose.material3.Strings$Companion r6 = androidx.compose.material3.Strings.Companion
                    int r6 = androidx.compose.material3.R.string.m3c_date_picker_navigate_to_year_description
                    int r6 = androidx.compose.material3.Strings.m2224constructorimpl(r6)
                    java.lang.String r6 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r6, r9, r12)
                    java.lang.Object[] r7 = new java.lang.Object[r13]
                    r7[r12] = r8
                    java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r13)
                    java.lang.String r6 = java.lang.String.format(r6, r7)
                    java.lang.String r7 = "format(this, *args)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                    androidx.compose.material3.DatePickerColors r7 = r13
                    androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$3 r10 = new androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$3
                    r10.<init>(r8)
                    r8 = 882189459(0x34952493, float:2.7780024E-7)
                    androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r8, r13, r10)
                    kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                    r10 = 12582912(0xc00000, float:1.7632415E-38)
                    r9 = r19
                    androidx.compose.material3.DatePickerKt.Year(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                    boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r1 == 0) goto L_0x0149
                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                L_0x0149:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1.AnonymousClass1.invoke(androidx.compose.foundation.lazy.grid.LazyGridItemScope, int, androidx.compose.runtime.Composer, int):void");
            }
        }), 14, (Object) null);
    }
}
