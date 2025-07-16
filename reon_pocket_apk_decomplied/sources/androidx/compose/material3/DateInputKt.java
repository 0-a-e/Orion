package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001ad\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010 ¢\u0006\u0002\b!2\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010 ¢\u0006\u0002\b!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\n\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006.²\u0006\n\u0010/\u001a\u000200X\u0002"}, d2 = {"InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "DateInputContent", "", "selectedDateMillis", "", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "initialDateMillis", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateInputTextField-tQNruF0", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "material3_release", "text", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding;
    private static final float InputTextNonErroneousBottomPadding = Dp.m6614constructorimpl((float) 16);

    public static final void DateInputContent(Long l, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composer2;
        DateInputFormat dateInputFormat;
        Locale locale;
        int i3;
        boolean z;
        Composer composer3;
        Long l2 = l;
        CalendarModel calendarModel2 = calendarModel;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(643325609);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateInputContent)P(5,3!1,6,2,4)57@2329L15,58@2371L87,61@2486L45,62@2566L44,63@2644L45,64@2719L507,77@3315L42,78@3362L891:DateInput.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) l2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        Function1<? super Long, Unit> function12 = function1;
        if ((i4 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 256 : 128;
        }
        IntRange intRange2 = intRange;
        if ((i4 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange2) ? 2048 : 1024;
        }
        if ((i4 & CpioConstants.C_ISBLK) == 0) {
            i2 |= (i4 & 32768) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 16384 : 8192;
        }
        SelectableDates selectableDates2 = selectableDates;
        if ((196608 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? 131072 : 65536;
        }
        DatePickerColors datePickerColors2 = datePickerColors;
        if ((1572864 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 1048576 : 524288;
        }
        int i5 = i2;
        if ((599187 & i5) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(643325609, i5, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:55)");
            }
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-356766397);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateInput.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) defaultLocale);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = calendarModel2.getDateInputFormat(defaultLocale);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            DateInputFormat dateInputFormat2 = (DateInputFormat) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            Strings.Companion companion = Strings.Companion;
            String r16 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_input_invalid_for_pattern), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.Companion;
            String r17 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_input_invalid_year_range), startRestartGroup, 0);
            Strings.Companion companion3 = Strings.Companion;
            String r18 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_input_invalid_not_allowed), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-356766049);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateInput.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed((Object) dateInputFormat2) | ((57344 & i5) == 16384 || ((32768 & i5) != 0 && startRestartGroup.changed((Object) datePickerFormatter2)));
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                locale = defaultLocale;
                DateInputValidator dateInputValidator = r0;
                dateInputFormat = dateInputFormat2;
                String str = r16;
                i3 = i5;
                z = true;
                DateInputValidator dateInputValidator2 = new DateInputValidator(intRange, selectableDates, dateInputFormat2, datePickerFormatter, str, r17, r18, "", (Long) null, (Long) null, 768, (DefaultConstructorMarker) null);
                DateInputValidator dateInputValidator3 = dateInputValidator;
                composer3 = startRestartGroup;
                composer3.updateRememberedValue(dateInputValidator3);
                rememberedValue2 = dateInputValidator3;
            } else {
                locale = defaultLocale;
                dateInputFormat = dateInputFormat2;
                i3 = i5;
                z = true;
                composer3 = startRestartGroup;
            }
            DateInputValidator dateInputValidator4 = (DateInputValidator) rememberedValue2;
            composer3.endReplaceableGroup();
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Strings.Companion companion4 = Strings.Companion;
            String r1 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_input_label), composer3, 0);
            Modifier padding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, z ? 1 : 0, (Object) null), InputTextFieldPadding);
            int r6 = InputIdentifier.Companion.m1925getSingleDateInputJ2x2o4M();
            dateInputValidator4.setCurrentStartDateMillis$material3_release(l2);
            int i6 = i3 << 3;
            composer2 = composer3;
            m1734DateInputTextFieldtQNruF0(padding, l, function1, calendarModel, ComposableLambdaKt.composableLambda(composer3, -1819015125, z, new DateInputKt$DateInputContent$2(r1, upperCase)), ComposableLambdaKt.composableLambda(composer3, -564233108, z, new DateInputKt$DateInputContent$3(upperCase)), r6, dateInputValidator4, dateInputFormat, locale, datePickerColors, composer3, (i6 & 112) | 1794054 | (i6 & 896) | (i6 & 7168), (i3 >> 18) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateInputKt$DateInputContent$4(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: DateInputTextField-tQNruF0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1734DateInputTextFieldtQNruF0(androidx.compose.ui.Modifier r47, java.lang.Long r48, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r49, androidx.compose.material3.CalendarModel r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, int r53, androidx.compose.material3.DateInputValidator r54, androidx.compose.material3.DateInputFormat r55, java.util.Locale r56, androidx.compose.material3.DatePickerColors r57, androidx.compose.runtime.Composer r58, int r59, int r60) {
        /*
            r2 = r48
            r12 = r50
            r13 = r55
            r14 = r56
            r15 = r59
            r0 = -857008589(0xffffffffcceb1633, float:-1.23253144E8)
            r1 = r58
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(DateInputTextField)P(8,4,9!1,6,10,5:c#material3.InputIdentifier,3,2,7)117@4757L39,118@4865L388,118@4813L440,135@5324L1418,178@7156L88,133@5259L2503:DateInput.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r15 & 6
            r4 = 4
            r11 = r47
            if (r3 != 0) goto L_0x002a
            boolean r3 = r1.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x0027
            r3 = r4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r15
            goto L_0x002b
        L_0x002a:
            r3 = r15
        L_0x002b:
            r6 = r15 & 48
            if (r6 != 0) goto L_0x003b
            boolean r6 = r1.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x0038
            r6 = 32
            goto L_0x003a
        L_0x0038:
            r6 = 16
        L_0x003a:
            r3 = r3 | r6
        L_0x003b:
            r6 = r15 & 384(0x180, float:5.38E-43)
            r8 = r49
            if (r6 != 0) goto L_0x004d
            boolean r6 = r1.changedInstance(r8)
            if (r6 == 0) goto L_0x004a
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x004c
        L_0x004a:
            r6 = 128(0x80, float:1.794E-43)
        L_0x004c:
            r3 = r3 | r6
        L_0x004d:
            r6 = r15 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x005d
            boolean r6 = r1.changedInstance(r12)
            if (r6 == 0) goto L_0x005a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x005c
        L_0x005a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x005c:
            r3 = r3 | r6
        L_0x005d:
            r6 = r15 & 24576(0x6000, float:3.4438E-41)
            r7 = r51
            if (r6 != 0) goto L_0x006f
            boolean r6 = r1.changedInstance(r7)
            if (r6 == 0) goto L_0x006c
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006e
        L_0x006c:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x006e:
            r3 = r3 | r6
        L_0x006f:
            r6 = 196608(0x30000, float:2.75506E-40)
            r6 = r6 & r15
            if (r6 != 0) goto L_0x0084
            r6 = r52
            boolean r16 = r1.changedInstance(r6)
            if (r16 == 0) goto L_0x007f
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0081
        L_0x007f:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x0081:
            r3 = r3 | r16
            goto L_0x0086
        L_0x0084:
            r6 = r52
        L_0x0086:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r15 & r16
            r10 = r53
            if (r16 != 0) goto L_0x009b
            boolean r17 = r1.changed((int) r10)
            if (r17 == 0) goto L_0x0097
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0099
        L_0x0097:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x0099:
            r3 = r3 | r17
        L_0x009b:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r15 & r17
            r9 = r54
            if (r17 != 0) goto L_0x00b0
            boolean r19 = r1.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x00ac
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ae
        L_0x00ac:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ae:
            r3 = r3 | r19
        L_0x00b0:
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            r19 = r15 & r19
            if (r19 != 0) goto L_0x00c3
            boolean r19 = r1.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x00bf
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00c1
        L_0x00bf:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00c1:
            r3 = r3 | r19
        L_0x00c3:
            r19 = 805306368(0x30000000, float:4.656613E-10)
            r19 = r15 & r19
            if (r19 != 0) goto L_0x00d6
            boolean r19 = r1.changedInstance(r14)
            if (r19 == 0) goto L_0x00d2
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00d4
        L_0x00d2:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00d4:
            r3 = r3 | r19
        L_0x00d6:
            r19 = r60 & 6
            r9 = r57
            if (r19 != 0) goto L_0x00e7
            boolean r20 = r1.changed((java.lang.Object) r9)
            if (r20 == 0) goto L_0x00e3
            goto L_0x00e4
        L_0x00e3:
            r4 = 2
        L_0x00e4:
            r4 = r60 | r4
            goto L_0x00e9
        L_0x00e7:
            r4 = r60
        L_0x00e9:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r3 & r20
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r5) goto L_0x0104
            r0 = r4 & 3
            r5 = 2
            if (r0 != r5) goto L_0x0104
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00ff
            goto L_0x0104
        L_0x00ff:
            r1.skipToGroupEnd()
            goto L_0x02fc
        L_0x0104:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0112
            java.lang.String r0 = "androidx.compose.material3.DateInputTextField (DateInput.kt:116)"
            r5 = -857008589(0xffffffffcceb1633, float:-1.23253144E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r4, r0)
        L_0x0112:
            r0 = 0
            java.lang.Object[] r4 = new java.lang.Object[r0]
            androidx.compose.material3.DateInputKt$DateInputTextField$errorText$1 r5 = androidx.compose.material3.DateInputKt$DateInputTextField$errorText$1.INSTANCE
            r20 = r5
            kotlin.jvm.functions.Function0 r20 = (kotlin.jvm.functions.Function0) r20
            r21 = 3072(0xc00, float:4.305E-42)
            r22 = 6
            r5 = 0
            r23 = 0
            r44 = r3
            r3 = r4
            r4 = r5
            r5 = r23
            r6 = r20
            r7 = r1
            r8 = r21
            r9 = r22
            java.lang.Object r3 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            r9 = r3
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            java.lang.Object[] r3 = new java.lang.Object[r0]
            androidx.compose.ui.text.input.TextFieldValue$Companion r4 = androidx.compose.ui.text.input.TextFieldValue.Companion
            androidx.compose.runtime.saveable.Saver r4 = r4.getSaver()
            r5 = 1947288557(0x741143ed, float:4.603642E31)
            r1.startReplaceableGroup(r5)
            java.lang.String r8 = "CC(remember):DateInput.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            r7 = r44
            r5 = r7 & 112(0x70, float:1.57E-43)
            r6 = 32
            if (r5 != r6) goto L_0x0153
            r5 = 1
            goto L_0x0154
        L_0x0153:
            r5 = r0
        L_0x0154:
            boolean r6 = r1.changedInstance(r12)
            r5 = r5 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r7
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            if (r6 != r0) goto L_0x0163
            r18 = 1
            goto L_0x0165
        L_0x0163:
            r18 = 0
        L_0x0165:
            r5 = r5 | r18
            boolean r18 = r1.changedInstance(r14)
            r5 = r5 | r18
            java.lang.Object r0 = r1.rememberedValue()
            if (r5 != 0) goto L_0x017b
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x0185
        L_0x017b:
            androidx.compose.material3.DateInputKt$DateInputTextField$text$2$1 r0 = new androidx.compose.material3.DateInputKt$DateInputTextField$text$2$1
            r0.<init>(r2, r12, r13, r14)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1.updateRememberedValue(r0)
        L_0x0185:
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1.endReplaceableGroup()
            r18 = 0
            r19 = 4
            r5 = 0
            r45 = r6
            r6 = r0
            r0 = r7
            r7 = r1
            r46 = r8
            r8 = r18
            r2 = r9
            r9 = r19
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.ui.text.input.TextFieldValue r23 = DateInputTextField_tQNruF0$lambda$4(r9)
            r3 = 1947289016(0x741145b8, float:4.603864E31)
            r1.startReplaceableGroup(r3)
            r8 = r46
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            r3 = r45
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            if (r3 != r4) goto L_0x01b6
            r6 = 1
            goto L_0x01b7
        L_0x01b6:
            r6 = 0
        L_0x01b7:
            boolean r3 = r1.changed((java.lang.Object) r9)
            r3 = r3 | r6
            boolean r4 = r1.changed((java.lang.Object) r2)
            r3 = r3 | r4
            r4 = r0 & 896(0x380, float:1.256E-42)
            r5 = 256(0x100, float:3.59E-43)
            if (r4 != r5) goto L_0x01c9
            r6 = 1
            goto L_0x01ca
        L_0x01c9:
            r6 = 0
        L_0x01ca:
            r3 = r3 | r6
            boolean r4 = r1.changedInstance(r12)
            r3 = r3 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r0
            r5 = 8388608(0x800000, float:1.17549435E-38)
            if (r4 != r5) goto L_0x01d9
            r6 = 1
            goto L_0x01da
        L_0x01d9:
            r6 = 0
        L_0x01da:
            r3 = r3 | r6
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r0
            r5 = 1048576(0x100000, float:1.469368E-39)
            if (r4 != r5) goto L_0x01e4
            r6 = 1
            goto L_0x01e5
        L_0x01e4:
            r6 = 0
        L_0x01e5:
            r3 = r3 | r6
            boolean r4 = r1.changedInstance(r14)
            r3 = r3 | r4
            java.lang.Object r4 = r1.rememberedValue()
            if (r3 != 0) goto L_0x01fc
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x01fa
            goto L_0x01fc
        L_0x01fa:
            r12 = r8
            goto L_0x021c
        L_0x01fc:
            androidx.compose.material3.DateInputKt$DateInputTextField$1$1 r16 = new androidx.compose.material3.DateInputKt$DateInputTextField$1$1
            r3 = r16
            r4 = r55
            r5 = r2
            r6 = r49
            r7 = r50
            r12 = r8
            r8 = r54
            r17 = r9
            r9 = r53
            r10 = r56
            r11 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r4 = r16
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r1.updateRememberedValue(r4)
        L_0x021c:
            r3 = r4
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1.endReplaceableGroup()
            java.lang.Object r4 = r2.getValue()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            r5 = 1
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x0237
            r4 = 0
            float r6 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r6)
            goto L_0x0239
        L_0x0237:
            float r4 = InputTextNonErroneousBottomPadding
        L_0x0239:
            r20 = r4
            r21 = 7
            r22 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r16 = r47
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.PaddingKt.m674paddingqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            r6 = 1947290848(0x74114ce0, float:4.60475E31)
            r1.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            boolean r6 = r1.changed((java.lang.Object) r2)
            java.lang.Object r7 = r1.rememberedValue()
            if (r6 != 0) goto L_0x0266
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x0271
        L_0x0266:
            androidx.compose.material3.DateInputKt$DateInputTextField$2$1 r6 = new androidx.compose.material3.DateInputKt$DateInputTextField$2$1
            r6.<init>(r2)
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r1.updateRememberedValue(r7)
        L_0x0271:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r1.endReplaceableGroup()
            r6 = 0
            r8 = 0
            androidx.compose.ui.Modifier r18 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r4, r8, r7, r5, r6)
            androidx.compose.material3.DateInputKt$DateInputTextField$3 r4 = new androidx.compose.material3.DateInputKt$DateInputTextField$3
            r4.<init>(r2)
            r6 = -591991974(0xffffffffdcb6eb5a, float:-4.1189774E17)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r6, r5, r4)
            r28 = r4
            kotlin.jvm.functions.Function2 r28 = (kotlin.jvm.functions.Function2) r28
            java.lang.Object r2 = r2.getValue()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            r29 = r2 ^ 1
            androidx.compose.material3.DateVisualTransformation r2 = new androidx.compose.material3.DateVisualTransformation
            r2.<init>(r13)
            r30 = r2
            androidx.compose.ui.text.input.VisualTransformation r30 = (androidx.compose.ui.text.input.VisualTransformation) r30
            androidx.compose.foundation.text.KeyboardOptions r4 = new androidx.compose.foundation.text.KeyboardOptions
            r31 = r4
            androidx.compose.ui.text.input.KeyboardType$Companion r2 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r7 = r2.m6288getNumberPjHm6EE()
            androidx.compose.ui.text.input.ImeAction$Companion r2 = androidx.compose.ui.text.input.ImeAction.Companion
            int r8 = r2.m6238getDoneeUduSuo()
            r10 = 17
            r11 = 0
            r5 = 0
            r6 = 0
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.material3.TextFieldColors r38 = r57.getDateTextFieldColors()
            int r0 = r0 << 6
            r2 = 33030144(0x1f80000, float:9.110081E-38)
            r40 = r0 & r2
            r42 = 0
            r43 = 4001592(0x3d0f38, float:5.607425E-39)
            r19 = 0
            r20 = 0
            r21 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r32 = 0
            r33 = 1
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r41 = 12779904(0xc30180, float:1.790846E-38)
            r16 = r23
            r17 = r3
            r22 = r51
            r23 = r52
            r39 = r1
            androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField((androidx.compose.ui.text.input.TextFieldValue) r16, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r17, (androidx.compose.ui.Modifier) r18, (boolean) r19, (boolean) r20, (androidx.compose.ui.text.TextStyle) r21, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r23, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r24, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r25, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r26, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r27, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r28, (boolean) r29, (androidx.compose.ui.text.input.VisualTransformation) r30, (androidx.compose.foundation.text.KeyboardOptions) r31, (androidx.compose.foundation.text.KeyboardActions) r32, (boolean) r33, (int) r34, (int) r35, (androidx.compose.foundation.interaction.MutableInteractionSource) r36, (androidx.compose.ui.graphics.Shape) r37, (androidx.compose.material3.TextFieldColors) r38, (androidx.compose.runtime.Composer) r39, (int) r40, (int) r41, (int) r42, (int) r43)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02fc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02fc:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x032b
            androidx.compose.material3.DateInputKt$DateInputTextField$4 r16 = new androidx.compose.material3.DateInputKt$DateInputTextField$4
            r0 = r16
            r1 = r47
            r2 = r48
            r3 = r49
            r4 = r50
            r5 = r51
            r6 = r52
            r7 = r53
            r8 = r54
            r9 = r55
            r10 = r56
            r11 = r57
            r14 = r12
            r12 = r59
            r13 = r60
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x032b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputKt.m1734DateInputTextFieldtQNruF0(androidx.compose.ui.Modifier, java.lang.Long, kotlin.jvm.functions.Function1, androidx.compose.material3.CalendarModel, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, androidx.compose.material3.DateInputValidator, androidx.compose.material3.DateInputFormat, java.util.Locale, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final TextFieldValue DateInputTextField_tQNruF0$lambda$4(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }

    /* access modifiers changed from: private */
    public static final void DateInputTextField_tQNruF0$lambda$5(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    static {
        float f = (float) 24;
        InputTextFieldPadding = PaddingKt.m667PaddingValuesa9UjIt4$default(Dp.m6614constructorimpl(f), Dp.m6614constructorimpl((float) 10), Dp.m6614constructorimpl(f), 0.0f, 8, (Object) null);
    }
}
