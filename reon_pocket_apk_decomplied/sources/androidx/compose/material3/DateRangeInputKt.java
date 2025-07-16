package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062:\u0010\b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\u0010\u0018\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0019"}, d2 = {"TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangeInputContent", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangeInput.kt */
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = Dp.m6614constructorimpl((float) 8);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: androidx.compose.material3.DateInputValidator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v20, resolved type: androidx.compose.material3.DateInputValidator} */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0168, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x016a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DateRangeInputContent(java.lang.Long r33, java.lang.Long r34, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Long, kotlin.Unit> r35, androidx.compose.material3.CalendarModel r36, kotlin.ranges.IntRange r37, androidx.compose.material3.DatePickerFormatter r38, androidx.compose.material3.SelectableDates r39, androidx.compose.material3.DatePickerColors r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            r14 = r33
            r15 = r34
            r13 = r35
            r12 = r36
            r11 = r38
            r10 = r42
            r0 = -607499086(0xffffffffdbca4cb2, float:-1.13884545E17)
            r1 = r41
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DateRangeInputContent)P(6,5,3!1,7,2,4)42@1614L15,43@1656L87,46@1771L45,47@1851L44,48@1929L45,49@2003L50,50@2083L486,67@2782L2321:DateRangeInput.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r10 & 6
            if (r1 != 0) goto L_0x0029
            boolean r1 = r9.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0026
            r1 = 4
            goto L_0x0027
        L_0x0026:
            r1 = 2
        L_0x0027:
            r1 = r1 | r10
            goto L_0x002a
        L_0x0029:
            r1 = r10
        L_0x002a:
            r2 = r10 & 48
            if (r2 != 0) goto L_0x003a
            boolean r2 = r9.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x0037
            r2 = 32
            goto L_0x0039
        L_0x0037:
            r2 = 16
        L_0x0039:
            r1 = r1 | r2
        L_0x003a:
            r2 = r10 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x004a
            boolean r2 = r9.changedInstance(r13)
            if (r2 == 0) goto L_0x0047
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0049
        L_0x0047:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0049:
            r1 = r1 | r2
        L_0x004a:
            r2 = r10 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x005a
            boolean r2 = r9.changedInstance(r12)
            if (r2 == 0) goto L_0x0057
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0059
        L_0x0057:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0059:
            r1 = r1 | r2
        L_0x005a:
            r2 = r10 & 24576(0x6000, float:3.4438E-41)
            r6 = r37
            if (r2 != 0) goto L_0x006c
            boolean r2 = r9.changedInstance(r6)
            if (r2 == 0) goto L_0x0069
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006b
        L_0x0069:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006b:
            r1 = r1 | r2
        L_0x006c:
            r2 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 & r10
            r5 = 262144(0x40000, float:3.67342E-40)
            if (r2 != 0) goto L_0x0088
            r2 = r10 & r5
            if (r2 != 0) goto L_0x007c
            boolean r2 = r9.changed((java.lang.Object) r11)
            goto L_0x0080
        L_0x007c:
            boolean r2 = r9.changedInstance(r11)
        L_0x0080:
            if (r2 == 0) goto L_0x0085
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0087
        L_0x0085:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0087:
            r1 = r1 | r2
        L_0x0088:
            r2 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 & r10
            if (r2 != 0) goto L_0x009d
            r2 = r39
            boolean r16 = r9.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x0098
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x009a
        L_0x0098:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x009a:
            r1 = r1 | r16
            goto L_0x009f
        L_0x009d:
            r2 = r39
        L_0x009f:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r10 & r16
            r3 = r40
            if (r16 != 0) goto L_0x00b4
            boolean r16 = r9.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x00b0
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b2
        L_0x00b0:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00b2:
            r1 = r1 | r16
        L_0x00b4:
            r16 = 4793491(0x492493, float:6.717112E-39)
            r8 = r1 & r16
            r7 = 4793490(0x492492, float:6.71711E-39)
            if (r8 != r7) goto L_0x00cd
            boolean r7 = r9.getSkipping()
            if (r7 != 0) goto L_0x00c5
            goto L_0x00cd
        L_0x00c5:
            r9.skipToGroupEnd()
            r16 = r9
            r15 = r13
            goto L_0x03fe
        L_0x00cd:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00d9
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:40)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r7, r8)
        L_0x00d9:
            r8 = 0
            java.util.Locale r7 = androidx.compose.material3.ActualAndroid_androidKt.defaultLocale(r9, r8)
            r0 = 1694771901(0x65042abd, float:3.9008797E22)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):DateRangeInput.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r16 = r9.changed((java.lang.Object) r7)
            java.lang.Object r5 = r9.rememberedValue()
            if (r16 != 0) goto L_0x00fb
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r16.getEmpty()
            if (r5 != r4) goto L_0x0102
        L_0x00fb:
            androidx.compose.material3.DateInputFormat r5 = r12.getDateInputFormat(r7)
            r9.updateRememberedValue(r5)
        L_0x0102:
            androidx.compose.material3.DateInputFormat r5 = (androidx.compose.material3.DateInputFormat) r5
            r9.endReplaceableGroup()
            androidx.compose.material3.Strings$Companion r4 = androidx.compose.material3.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_date_input_invalid_for_pattern
            int r4 = androidx.compose.material3.Strings.m2224constructorimpl(r4)
            java.lang.String r21 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r4, r9, r8)
            androidx.compose.material3.Strings$Companion r4 = androidx.compose.material3.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_date_input_invalid_year_range
            int r4 = androidx.compose.material3.Strings.m2224constructorimpl(r4)
            java.lang.String r22 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r4, r9, r8)
            androidx.compose.material3.Strings$Companion r4 = androidx.compose.material3.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_date_input_invalid_not_allowed
            int r4 = androidx.compose.material3.Strings.m2224constructorimpl(r4)
            java.lang.String r23 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r4, r9, r8)
            androidx.compose.material3.Strings$Companion r4 = androidx.compose.material3.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_date_range_input_invalid_range_input
            int r4 = androidx.compose.material3.Strings.m2224constructorimpl(r4)
            java.lang.String r24 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r4, r9, r8)
            r4 = 1694772328(0x65042c68, float:3.901072E22)
            r9.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r4 = r9.changed((java.lang.Object) r5)
            r16 = 458752(0x70000, float:6.42848E-40)
            r8 = r1 & r16
            r12 = 131072(0x20000, float:1.83671E-40)
            if (r8 == r12) goto L_0x015a
            r8 = 262144(0x40000, float:3.67342E-40)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0158
            boolean r8 = r9.changed((java.lang.Object) r11)
            if (r8 == 0) goto L_0x0158
            goto L_0x015a
        L_0x0158:
            r8 = 0
            goto L_0x015b
        L_0x015a:
            r8 = 1
        L_0x015b:
            r4 = r4 | r8
            java.lang.Object r8 = r9.rememberedValue()
            if (r4 != 0) goto L_0x016a
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r8 != r4) goto L_0x0184
        L_0x016a:
            androidx.compose.material3.DateInputValidator r8 = new androidx.compose.material3.DateInputValidator
            r27 = 768(0x300, float:1.076E-42)
            r28 = 0
            r25 = 0
            r26 = 0
            r16 = r8
            r17 = r37
            r18 = r39
            r19 = r5
            r20 = r38
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r9.updateRememberedValue(r8)
        L_0x0184:
            r12 = r8
            androidx.compose.material3.DateInputValidator r12 = (androidx.compose.material3.DateInputValidator) r12
            r9.endReplaceableGroup()
            r12.setCurrentStartDateMillis$material3_release(r14)
            r12.setCurrentEndDateMillis$material3_release(r15)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.foundation.layout.PaddingValues r8 = androidx.compose.material3.DateInputKt.getInputTextFieldPadding()
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.PaddingKt.padding(r4, r8)
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r2 = TextFieldSpacing
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r2 = r8.m537spacedBy0680j_4(r2)
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r2
            r8 = 693286680(0x2952b718, float:4.6788176E-14)
            r9.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r8.getTop()
            r3 = 6
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r2, r8, r9, r3)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r3)
            r3 = 0
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r4)
            r16 = r7
            androidx.compose.runtime.Applier r7 = r9.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x01e7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01e7:
            r9.startReusableNode()
            boolean r7 = r9.getInserting()
            if (r7 == 0) goto L_0x01f4
            r9.createNode(r6)
            goto L_0x01f7
        L_0x01f4:
            r9.useNode()
        L_0x01f7:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3282constructorimpl(r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r3 = r6.getInserting()
            if (r3 != 0) goto L_0x0227
            java.lang.Object r3 = r6.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r3 != 0) goto L_0x0235
        L_0x0227:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r6.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r6.apply(r3, r2)
        L_0x0235:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r2)
            r3 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            r4.invoke(r2, r9, r6)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r2)
            r2 = -326681643(0xffffffffec873bd5, float:-1.3079003E27)
            java.lang.String r3 = "C92@4661L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            androidx.compose.foundation.layout.RowScopeInstance r2 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r23 = r2
            androidx.compose.foundation.layout.RowScope r23 = (androidx.compose.foundation.layout.RowScope) r23
            r2 = 1849029228(0x6e35f26c, float:1.4077464E28)
            java.lang.String r3 = "C72@3043L56,84@3623L203,73@3108L955,94@4091L54,106@4663L199,95@4154L943:DateRangeInput.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            java.lang.String r2 = r5.getPatternWithDelimiters()
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r8 = r2.toUpperCase(r3)
            java.lang.String r2 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_date_range_picker_start_headline
            int r2 = androidx.compose.material3.Strings.m2224constructorimpl(r2)
            r7 = 0
            java.lang.String r2 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r2, r9, r7)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r18 = r3
            androidx.compose.ui.Modifier r18 = (androidx.compose.ui.Modifier) r18
            r21 = 2
            r22 = 0
            r19 = 1056964608(0x3f000000, float:0.5)
            r20 = 0
            r17 = r23
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.material3.InputIdentifier$Companion r4 = androidx.compose.material3.InputIdentifier.Companion
            int r6 = r4.m1926getStartDateInputJ2x2o4M()
            r4 = 1849029901(0x6e35f50d, float:1.4078259E28)
            r9.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r4 = r1 & 896(0x380, float:1.256E-42)
            r7 = 256(0x100, float:3.59E-43)
            if (r4 != r7) goto L_0x02aa
            r17 = 1
            goto L_0x02ac
        L_0x02aa:
            r17 = 0
        L_0x02ac:
            r14 = r1 & 112(0x70, float:1.57E-43)
            r7 = 32
            if (r14 != r7) goto L_0x02b4
            r7 = 1
            goto L_0x02b5
        L_0x02b4:
            r7 = 0
        L_0x02b5:
            r7 = r17 | r7
            r41 = r0
            java.lang.Object r0 = r9.rememberedValue()
            if (r7 != 0) goto L_0x02c7
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r0 != r7) goto L_0x02d1
        L_0x02c7:
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$1$1 r0 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$1$1
            r0.<init>(r13, r15)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9.updateRememberedValue(r0)
        L_0x02d1:
            r7 = r0
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r9.endReplaceableGroup()
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2 r0 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2
            r0.<init>(r2, r8)
            r2 = 801434508(0x2fc4eb8c, float:3.5819558E-10)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r2, r13, r0)
            r17 = r0
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3 r0 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3
            r0.<init>(r8)
            r2 = 665407211(0x27a94eeb, float:4.6992486E-15)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r2, r13, r0)
            r18 = r0
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            int r0 = r1 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r24 = 1794048(0x1b6000, float:2.513997E-39)
            r0 = r0 | r24
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r19 = r0 | r2
            int r0 = r1 >> 21
            r25 = r0 & 14
            r26 = r14
            r14 = r41
            r0 = r3
            r27 = r1
            r1 = r33
            r28 = r2
            r2 = r7
            r3 = r36
            r7 = r4
            r4 = r17
            r31 = r5
            r5 = r18
            r15 = r7
            r17 = 0
            r7 = r12
            r32 = r8
            r30 = r15
            r15 = r17
            r8 = r31
            r41 = r9
            r9 = r16
            r10 = r40
            r11 = r41
            r29 = r12
            r12 = r19
            r13 = r25
            androidx.compose.material3.DateInputKt.m1734DateInputTextFieldtQNruF0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_range_picker_end_headline
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            r13 = r41
            java.lang.String r0 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r13, r15)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r18 = r1
            androidx.compose.ui.Modifier r18 = (androidx.compose.ui.Modifier) r18
            r21 = 2
            r22 = 0
            r19 = 1056964608(0x3f000000, float:0.5)
            r20 = 0
            r17 = r23
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.material3.InputIdentifier$Companion r2 = androidx.compose.material3.InputIdentifier.Companion
            int r6 = r2.m1924getEndDateInputJ2x2o4M()
            r2 = 1849030941(0x6e35f91d, float:1.4079487E28)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r14)
            r2 = r30
            r3 = 256(0x100, float:3.59E-43)
            if (r2 != r3) goto L_0x0374
            r8 = 1
            goto L_0x0375
        L_0x0374:
            r8 = r15
        L_0x0375:
            r2 = r27 & 14
            r3 = 4
            if (r2 != r3) goto L_0x037b
            r15 = 1
        L_0x037b:
            r2 = r8 | r15
            java.lang.Object r3 = r13.rememberedValue()
            if (r2 != 0) goto L_0x0394
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x038c
            goto L_0x0394
        L_0x038c:
            r14 = r33
            r15 = r35
            r2 = r3
            r3 = r26
            goto L_0x03a4
        L_0x0394:
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$4$1 r2 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$4$1
            r14 = r33
            r15 = r35
            r3 = r26
            r2.<init>(r15, r14)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r13.updateRememberedValue(r2)
        L_0x03a4:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r13.endReplaceableGroup()
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5 r4 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5
            r5 = r32
            r4.<init>(r0, r5)
            r0 = 911487285(0x36543135, float:3.1619104E-6)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r7, r4)
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6 r0 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6
            r0.<init>(r5)
            r5 = -961726252(0xffffffffc6ad38d4, float:-22172.414)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r5, r7, r0)
            r5 = r0
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0 = r3 | r24
            r12 = r0 | r28
            r0 = r1
            r1 = r34
            r3 = r36
            r7 = r29
            r8 = r31
            r9 = r16
            r10 = r40
            r11 = r13
            r16 = r13
            r13 = r25
            androidx.compose.material3.DateInputKt.m1734DateInputTextFieldtQNruF0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r16)
            r16.endReplaceableGroup()
            r16.endNode()
            r16.endReplaceableGroup()
            r16.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03fe
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03fe:
            androidx.compose.runtime.ScopeUpdateScope r10 = r16.endRestartGroup()
            if (r10 == 0) goto L_0x0421
            androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$3 r11 = new androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$3
            r0 = r11
            r1 = r33
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r7 = r39
            r8 = r40
            r9 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0421:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangeInputKt.DateRangeInputContent(java.lang.Long, java.lang.Long, kotlin.jvm.functions.Function2, androidx.compose.material3.CalendarModel, kotlin.ranges.IntRange, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }
}
