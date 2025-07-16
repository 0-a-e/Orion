package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(J$\u0010)\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010-J\u0002\u0010,\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u00020/2\b\b\u0002\u00104\u001a\u00020/2\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020/2\b\b\u0002\u0010:\u001a\u00020/2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020/2\b\b\u0002\u0010F\u001a\u00020/2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ$\u0010#\u001a\u00020$2\b\b\u0002\u0010K\u001a\u00020\r2\b\b\u0002\u0010L\u001a\u00020\r2\b\b\u0002\u0010M\u001a\u00020\rJ'\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0001¢\u0006\u0004\bU\u0010VR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8AX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "()V", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "YearAbbrMonthDaySkeleton", "", "YearMonthSkeleton", "YearMonthWeekdayDaySkeleton", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultDatePickerColors", "Landroidx/compose/material3/DatePickerColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "DatePickerHeadline", "", "selectedDateMillis", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DatePickerHeadline-3kbWawI", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DatePickerTitle", "DatePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "yearSelectionSkeleton", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3_release", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerDefaults {
    public static final int $stable = 0;
    private static final SelectableDates AllDates = new DatePickerDefaults$AllDates$1();
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final float TonalElevation = DatePickerModalTokens.INSTANCE.m2783getContainerElevationD9Ej5fM();
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    private static final IntRange YearRange = new IntRange(1900, 2100);

    private DatePickerDefaults() {
    }

    public final DatePickerColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(-275219611);
        ComposerKt.sourceInformation(composer, "C(colors)433@17872L11,433@17884L23:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-275219611, i, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:433)");
        }
        DatePickerColors defaultDatePickerColors = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultDatePickerColors;
    }

    /* renamed from: colors-bSRYm20  reason: not valid java name */
    public final DatePickerColors m1764colorsbSRYm20(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, Composer composer, int i, int i2, int i3, int i4) {
        Composer composer2 = composer;
        int i5 = i4;
        composer2.startReplaceableGroup(1991626358);
        ComposerKt.sourceInformation(composer2, "C(colors)P(0:c#ui.graphics.Color,20:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,19:c#ui.graphics.Color,14:c#ui.graphics.Color,24:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,18:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,21:c#ui.graphics.Color,22:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color)502@22150L11,502@22162L23:DatePicker.kt#uh7d8r");
        long r6 = (i5 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i5 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r10 = (i5 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r12 = (i5 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r14 = (i5 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r16 = (i5 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r18 = (i5 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r20 = (i5 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        long r22 = (i5 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j9;
        long r24 = (i5 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j10;
        long r26 = (i5 & 1024) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j11;
        long r28 = (i5 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j12;
        long r30 = (i5 & 4096) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j13;
        long r32 = (i5 & 8192) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j14;
        long r34 = (i5 & 16384) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j15;
        long r36 = (32768 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j16;
        long r38 = (65536 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j17;
        long r40 = (131072 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j18;
        long r42 = (262144 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j19;
        long r44 = (524288 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j20;
        long r46 = (1048576 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j21;
        long r50 = (2097152 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j22;
        long r48 = (4194304 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j23;
        long r52 = (8388608 & i5) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j24;
        TextFieldColors textFieldColors2 = (i5 & 16777216) != 0 ? null : textFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1991626358, i, i2, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:502)");
        }
        DatePickerColors r1 = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), composer2, (i3 >> 12) & 112).m1737copytNwlRmA(r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, textFieldColors2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme colorScheme, Composer composer, int i) {
        ColorScheme colorScheme2 = colorScheme;
        Composer composer2 = composer;
        int i2 = i;
        composer2.startReplaceableGroup(1180555308);
        ComposerKt.sourceInformation(composer2, "C*581@27175L30:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1180555308, i2, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:532)");
        }
        DatePickerColors defaultDatePickerColorsCached$material3_release = colorScheme.getDefaultDatePickerColorsCached$material3_release();
        if (defaultDatePickerColorsCached$material3_release == null) {
            defaultDatePickerColorsCached$material3_release = new DatePickerColors(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), colorScheme.m1657getOnSurfaceVariant0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), ColorSchemeKt.fromToken(colorScheme2, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(colorScheme2, composer2, (i2 & 14) | 48), (DefaultConstructorMarker) null);
            colorScheme2.setDefaultDatePickerColorsCached$material3_release(defaultDatePickerColorsCached$material3_release);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultDatePickerColorsCached$material3_release;
    }

    public static /* synthetic */ DatePickerFormatter dateFormatter$default(DatePickerDefaults datePickerDefaults, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = YearMonthSkeleton;
        }
        if ((i & 2) != 0) {
            str2 = YearAbbrMonthDaySkeleton;
        }
        if ((i & 4) != 0) {
            str3 = YearMonthWeekdayDaySkeleton;
        }
        return datePickerDefaults.dateFormatter(str, str2, str3);
    }

    public final DatePickerFormatter dateFormatter(String str, String str2, String str3) {
        return new DatePickerFormatterImpl(str, str2, str3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* renamed from: DatePickerTitle-hOD91z4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1763DatePickerTitlehOD91z4(int r30, androidx.compose.ui.Modifier r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r29 = this;
            r2 = r30
            r0 = 327413563(0x1383ef3b, float:3.330495E-27)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(DatePickerTitle)P(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r34 & 1
            if (r3 == 0) goto L_0x0017
            r3 = r33 | 6
            goto L_0x0029
        L_0x0017:
            r3 = r33 & 6
            if (r3 != 0) goto L_0x0027
            boolean r3 = r1.changed((int) r2)
            if (r3 == 0) goto L_0x0023
            r3 = 4
            goto L_0x0024
        L_0x0023:
            r3 = 2
        L_0x0024:
            r3 = r33 | r3
            goto L_0x0029
        L_0x0027:
            r3 = r33
        L_0x0029:
            r4 = r34 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r33 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r31
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r31
        L_0x0045:
            r6 = r3
            r3 = r6 & 19
            r7 = 18
            if (r3 != r7) goto L_0x0059
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x0053
            goto L_0x0059
        L_0x0053:
            r1.skipToGroupEnd()
            r3 = r5
            goto L_0x0121
        L_0x0059:
            if (r4 == 0) goto L_0x0062
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r28 = r3
            goto L_0x0064
        L_0x0062:
            r28 = r5
        L_0x0064:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0070
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:621)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r3, r4)
        L_0x0070:
            androidx.compose.material3.DisplayMode$Companion r0 = androidx.compose.material3.DisplayMode.Companion
            int r0 = r0.m1814getPickerjFl4v0()
            boolean r0 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r2, r0)
            r3 = 0
            if (r0 == 0) goto L_0x00bf
            r0 = -2065101749(0xffffffff84e90c4b, float:-5.4789326E-36)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "624@29127L43,623@29098L123"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_picker_title
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r1, r3)
            r25 = r6 & 112(0x70, float:1.57E-43)
            r26 = 0
            r27 = 131068(0x1fffc, float:1.83665E-40)
            r5 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r4 = r28
            r24 = r1
            androidx.compose.material3.TextKt.m2456Text4IGK_g((java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (long) r5, (long) r7, (androidx.compose.ui.text.font.FontStyle) r9, (androidx.compose.ui.text.font.FontWeight) r10, (androidx.compose.ui.text.font.FontFamily) r11, (long) r12, (androidx.compose.ui.text.style.TextDecoration) r14, (androidx.compose.ui.text.style.TextAlign) r15, (long) r16, (int) r18, (boolean) r19, (int) r20, (int) r21, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r22, (androidx.compose.ui.text.TextStyle) r23, (androidx.compose.runtime.Composer) r24, (int) r25, (int) r26, (int) r27)
            r1.endReplaceableGroup()
            goto L_0x0116
        L_0x00bf:
            androidx.compose.material3.DisplayMode$Companion r0 = androidx.compose.material3.DisplayMode.Companion
            int r0 = r0.m1813getInputjFl4v0()
            boolean r0 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r2, r0)
            if (r0 == 0) goto L_0x010d
            r0 = -2065101591(0xffffffff84e90ce9, float:-5.4789893E-36)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "629@29285L42,628@29256L122"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_input_title
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r1, r3)
            r25 = r6 & 112(0x70, float:1.57E-43)
            r26 = 0
            r27 = 131068(0x1fffc, float:1.83665E-40)
            r5 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r4 = r28
            r24 = r1
            androidx.compose.material3.TextKt.m2456Text4IGK_g((java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (long) r5, (long) r7, (androidx.compose.ui.text.font.FontStyle) r9, (androidx.compose.ui.text.font.FontWeight) r10, (androidx.compose.ui.text.font.FontFamily) r11, (long) r12, (androidx.compose.ui.text.style.TextDecoration) r14, (androidx.compose.ui.text.style.TextAlign) r15, (long) r16, (int) r18, (boolean) r19, (int) r20, (int) r21, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r22, (androidx.compose.ui.text.TextStyle) r23, (androidx.compose.runtime.Composer) r24, (int) r25, (int) r26, (int) r27)
            r1.endReplaceableGroup()
            goto L_0x0116
        L_0x010d:
            r0 = -2065101459(0xffffffff84e90d6d, float:-5.4790366E-36)
            r1.startReplaceableGroup(r0)
            r1.endReplaceableGroup()
        L_0x0116:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x011f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x011f:
            r3 = r28
        L_0x0121:
            androidx.compose.runtime.ScopeUpdateScope r6 = r1.endRestartGroup()
            if (r6 == 0) goto L_0x013a
            androidx.compose.material3.DatePickerDefaults$DatePickerTitle$1 r7 = new androidx.compose.material3.DatePickerDefaults$DatePickerTitle$1
            r0 = r7
            r1 = r29
            r2 = r30
            r4 = r33
            r5 = r34
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDefaults.m1763DatePickerTitlehOD91z4(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* renamed from: DatePickerHeadline-3kbWawI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1762DatePickerHeadline3kbWawI(java.lang.Long r36, int r37, androidx.compose.material3.DatePickerFormatter r38, androidx.compose.ui.Modifier r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r35 = this;
            r6 = r36
            r7 = r37
            r8 = r38
            r9 = r41
            r0 = 1502835813(0x59937465, float:5.1880998E15)
            r1 = r40
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DatePickerHeadline)P(3,1:c#material3.DisplayMode)652@30155L15,681@31348L123,679@31267L240:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r42 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r9 | 6
            goto L_0x002d
        L_0x001d:
            r1 = r9 & 6
            if (r1 != 0) goto L_0x002c
            boolean r1 = r10.changed((java.lang.Object) r6)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r9
            goto L_0x002d
        L_0x002c:
            r1 = r9
        L_0x002d:
            r2 = r42 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            goto L_0x0044
        L_0x0034:
            r2 = r9 & 48
            if (r2 != 0) goto L_0x0044
            boolean r2 = r10.changed((int) r7)
            if (r2 == 0) goto L_0x0041
            r2 = 32
            goto L_0x0043
        L_0x0041:
            r2 = 16
        L_0x0043:
            r1 = r1 | r2
        L_0x0044:
            r2 = r42 & 4
            if (r2 == 0) goto L_0x004b
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x004b:
            r2 = r9 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x0064
            r2 = r9 & 512(0x200, float:7.175E-43)
            if (r2 != 0) goto L_0x0058
            boolean r2 = r10.changed((java.lang.Object) r8)
            goto L_0x005c
        L_0x0058:
            boolean r2 = r10.changedInstance(r8)
        L_0x005c:
            if (r2 == 0) goto L_0x0061
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r2
        L_0x0064:
            r2 = r42 & 8
            if (r2 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r3 = r9 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x007e
            r3 = r39
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x007a
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r4
            goto L_0x0080
        L_0x007e:
            r3 = r39
        L_0x0080:
            r4 = r1 & 1171(0x493, float:1.641E-42)
            r5 = 1170(0x492, float:1.64E-42)
            if (r4 != r5) goto L_0x0094
            boolean r4 = r10.getSkipping()
            if (r4 != 0) goto L_0x008d
            goto L_0x0094
        L_0x008d:
            r10.skipToGroupEnd()
            r5 = r3
            r1 = r10
            goto L_0x025f
        L_0x0094:
            if (r2 == 0) goto L_0x009c
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r14 = r2
            goto L_0x009d
        L_0x009c:
            r14 = r3
        L_0x009d:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00a9
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:651)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00a9:
            r11 = 0
            java.util.Locale r12 = androidx.compose.material3.ActualAndroid_androidKt.defaultLocale(r10, r11)
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r38
            r1 = r36
            r2 = r12
            java.lang.String r0 = androidx.compose.material3.DatePickerFormatter.CC.formatDate$default(r0, r1, r2, r3, r4, r5)
            r1 = 1
            java.lang.String r2 = r8.formatDate(r6, r12, r1)
            r3 = 729793187(0x2b7fc2a3, float:9.086431E-13)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            if (r2 != 0) goto L_0x0124
            androidx.compose.material3.DisplayMode$Companion r2 = androidx.compose.material3.DisplayMode.Companion
            int r2 = r2.m1814getPickerjFl4v0()
            boolean r2 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r7, r2)
            if (r2 == 0) goto L_0x00f3
            r2 = 729793403(0x2b7fc37b, float:9.086548E-13)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "662@30568L51"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_date_picker_no_selection_description
            int r2 = androidx.compose.material3.Strings.m2224constructorimpl(r2)
            java.lang.String r2 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r2, r10, r11)
            r10.endReplaceableGroup()
            goto L_0x0124
        L_0x00f3:
            androidx.compose.material3.DisplayMode$Companion r2 = androidx.compose.material3.DisplayMode.Companion
            int r2 = r2.m1813getInputjFl4v0()
            boolean r2 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r7, r2)
            if (r2 == 0) goto L_0x011a
            r2 = 729793488(0x2b7fc3d0, float:9.0865943E-13)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "663@30653L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_date_input_no_input_description
            int r2 = androidx.compose.material3.Strings.m2224constructorimpl(r2)
            java.lang.String r2 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r2, r10, r11)
            r10.endReplaceableGroup()
            goto L_0x0124
        L_0x011a:
            r2 = 1148763725(0x4478be4d, float:994.97345)
            r10.startReplaceableGroup(r2)
            r10.endReplaceableGroup()
            r2 = r3
        L_0x0124:
            r10.endReplaceableGroup()
            r4 = 729793596(0x2b7fc43c, float:9.086653E-13)
            r10.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            if (r0 != 0) goto L_0x018a
            androidx.compose.material3.DisplayMode$Companion r0 = androidx.compose.material3.DisplayMode.Companion
            int r0 = r0.m1814getPickerjFl4v0()
            boolean r0 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r7, r0)
            if (r0 == 0) goto L_0x0159
            r0 = 729793668(0x2b7fc484, float:9.086692E-13)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "668@30833L37"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_picker_headline
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            java.lang.String r0 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r10, r11)
            r10.endReplaceableGroup()
            goto L_0x018a
        L_0x0159:
            androidx.compose.material3.DisplayMode$Companion r0 = androidx.compose.material3.DisplayMode.Companion
            int r0 = r0.m1813getInputjFl4v0()
            boolean r0 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r7, r0)
            if (r0 == 0) goto L_0x0180
            r0 = 729793739(0x2b7fc4cb, float:9.0867304E-13)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "669@30904L36"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_input_headline
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            java.lang.String r0 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r10, r11)
            r10.endReplaceableGroup()
            goto L_0x018a
        L_0x0180:
            r0 = 1148771196(0x4478db7c, float:995.42944)
            r10.startReplaceableGroup(r0)
            r10.endReplaceableGroup()
            r0 = r3
        L_0x018a:
            r10.endReplaceableGroup()
            androidx.compose.material3.DisplayMode$Companion r4 = androidx.compose.material3.DisplayMode.Companion
            int r4 = r4.m1814getPickerjFl4v0()
            boolean r4 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r7, r4)
            if (r4 == 0) goto L_0x01b4
            r3 = 729793899(0x2b7fc56b, float:9.086817E-13)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "674@31064L48"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
            int r3 = androidx.compose.material3.R.string.m3c_date_picker_headline_description
            int r3 = androidx.compose.material3.Strings.m2224constructorimpl(r3)
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r3, r10, r11)
            r10.endReplaceableGroup()
            goto L_0x01e4
        L_0x01b4:
            androidx.compose.material3.DisplayMode$Companion r4 = androidx.compose.material3.DisplayMode.Companion
            int r4 = r4.m1813getInputjFl4v0()
            boolean r4 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r7, r4)
            if (r4 == 0) goto L_0x01db
            r3 = 729793981(0x2b7fc5bd, float:9.0868616E-13)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "675@31146L47"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
            int r3 = androidx.compose.material3.R.string.m3c_date_input_headline_description
            int r3 = androidx.compose.material3.Strings.m2224constructorimpl(r3)
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r3, r10, r11)
            r10.endReplaceableGroup()
            goto L_0x01e4
        L_0x01db:
            r4 = 1148779039(0x4478fa1f, float:995.90814)
            r10.startReplaceableGroup(r4)
            r10.endReplaceableGroup()
        L_0x01e4:
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r11] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r4, r1)
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = 729794183(0x2b7fc687, float:9.086971E-13)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            boolean r3 = r10.changed((java.lang.Object) r2)
            java.lang.Object r4 = r10.rememberedValue()
            if (r3 != 0) goto L_0x0212
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x021d
        L_0x0212:
            androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$1$1 r3 = new androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$1$1
            r3.<init>(r2)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r10.updateRememberedValue(r4)
        L_0x021d:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r10.endReplaceableGroup()
            r2 = 0
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r14, r11, r4, r1, r2)
            r33 = 3072(0xc00, float:4.305E-42)
            r34 = 122876(0x1dffc, float:1.72186E-40)
            r12 = 0
            r1 = 0
            r3 = r14
            r14 = r1
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 1
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r1 = r10
            r10 = r0
            r31 = r1
            androidx.compose.material3.TextKt.m2456Text4IGK_g((java.lang.String) r10, (androidx.compose.ui.Modifier) r11, (long) r12, (long) r14, (androidx.compose.ui.text.font.FontStyle) r16, (androidx.compose.ui.text.font.FontWeight) r17, (androidx.compose.ui.text.font.FontFamily) r18, (long) r19, (androidx.compose.ui.text.style.TextDecoration) r21, (androidx.compose.ui.text.style.TextAlign) r22, (long) r23, (int) r25, (boolean) r26, (int) r27, (int) r28, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r29, (androidx.compose.ui.text.TextStyle) r30, (androidx.compose.runtime.Composer) r31, (int) r32, (int) r33, (int) r34)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x025e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x025e:
            r5 = r3
        L_0x025f:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x027c
            androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$2 r11 = new androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$2
            r0 = r11
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r6 = r41
            r7 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x027c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDefaults.m1762DatePickerHeadline3kbWawI(java.lang.Long, int, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3_release(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2036003494);
        ComposerKt.sourceInformation(composer, "C(rememberSnapFlingBehavior)P(1)701@32015L7,702@32038L295:DatePicker.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, i, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:700)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        composer.startReplaceableGroup(-1872611444);
        ComposerKt.sourceInformation(composer, "CC(remember):DatePicker.kt#9igjgp");
        boolean changed = composer.changed((Object) density);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SnapFlingBehavior(lazyListState, decayAnimationSpec, AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null), density);
            composer.updateRememberedValue(rememberedValue);
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) rememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m1765getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(700927667);
        ComposerKt.sourceInformation(composer, "C719@32723L5:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:719)");
        }
        Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final SelectableDates getAllDates() {
        return AllDates;
    }
}
