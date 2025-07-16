package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.DatePickerFormatter;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "()V", "DateRangePickerHeadline", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DateRangePickerHeadline-v84Udv0", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "DateRangePickerHeadline-0YIUgSQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerTitle", "DateRangePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    private DateRangePickerDefaults() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* renamed from: DateRangePickerTitle-hOD91z4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1785DateRangePickerTitlehOD91z4(int r30, androidx.compose.ui.Modifier r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r29 = this;
            r2 = r30
            r0 = -1412719908(0xffffffffabcb9adc, float:-1.4467E-12)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(DateRangePickerTitle)P(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r"
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
            java.lang.String r4 = "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:339)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r3, r4)
        L_0x0070:
            androidx.compose.material3.DisplayMode$Companion r0 = androidx.compose.material3.DisplayMode.Companion
            int r0 = r0.m1814getPickerjFl4v0()
            boolean r0 = androidx.compose.material3.DisplayMode.m1809equalsimpl0(r2, r0)
            r3 = 0
            if (r0 == 0) goto L_0x00bf
            r0 = 585816325(0x22ead905, float:6.3655605E-18)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "342@15160L48,341@15138L121"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_range_picker_title
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
            r0 = 585816481(0x22ead9a1, float:6.365625E-18)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "347@15316L47,346@15294L120"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_range_input_title
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
            r0 = 585816611(0x22eada23, float:6.365679E-18)
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
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerTitle$1 r7 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerTitle$1
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.m1785DateRangePickerTitlehOD91z4(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* renamed from: DateRangePickerHeadline-v84Udv0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1784DateRangePickerHeadlinev84Udv0(java.lang.Long r22, java.lang.Long r23, int r24, androidx.compose.material3.DatePickerFormatter r25, androidx.compose.ui.Modifier r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r21 = this;
            r14 = r25
            r15 = r28
            r0 = -1611069472(0xffffffff9ff907e0, float:-1.0546863E-19)
            r1 = r27
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DateRangePickerHeadline)P(4,3,1:c#material3.DisplayMode)373@16430L47,374@16504L45,375@16558L534:DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r29 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r15 | 6
            r12 = r22
            goto L_0x002d
        L_0x001b:
            r1 = r15 & 6
            r12 = r22
            if (r1 != 0) goto L_0x002c
            boolean r1 = r13.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r15
            goto L_0x002d
        L_0x002c:
            r1 = r15
        L_0x002d:
            r2 = r29 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r11 = r23
            goto L_0x0048
        L_0x0036:
            r2 = r15 & 48
            r11 = r23
            if (r2 != 0) goto L_0x0048
            boolean r2 = r13.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r29 & 4
            if (r2 == 0) goto L_0x0051
            r1 = r1 | 384(0x180, float:5.38E-43)
            r10 = r24
            goto L_0x0063
        L_0x0051:
            r2 = r15 & 384(0x180, float:5.38E-43)
            r10 = r24
            if (r2 != 0) goto L_0x0063
            boolean r2 = r13.changed((int) r10)
            if (r2 == 0) goto L_0x0060
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r2
        L_0x0063:
            r2 = r29 & 8
            if (r2 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x006a:
            r2 = r15 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0083
            r2 = r15 & 4096(0x1000, float:5.74E-42)
            if (r2 != 0) goto L_0x0077
            boolean r2 = r13.changed((java.lang.Object) r14)
            goto L_0x007b
        L_0x0077:
            boolean r2 = r13.changedInstance(r14)
        L_0x007b:
            if (r2 == 0) goto L_0x0080
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r1 = r1 | r2
        L_0x0083:
            r2 = r29 & 16
            if (r2 == 0) goto L_0x008a
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008a:
            r3 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x009d
            r3 = r26
            boolean r4 = r13.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0099
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r1 = r1 | r4
            goto L_0x009f
        L_0x009d:
            r3 = r26
        L_0x009f:
            r4 = r29 & 32
            r5 = 196608(0x30000, float:2.75506E-40)
            if (r4 == 0) goto L_0x00a9
            r1 = r1 | r5
            r9 = r21
            goto L_0x00bb
        L_0x00a9:
            r4 = r15 & r5
            r9 = r21
            if (r4 != 0) goto L_0x00bb
            boolean r4 = r13.changed((java.lang.Object) r9)
            if (r4 == 0) goto L_0x00b8
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r1 = r1 | r4
        L_0x00bb:
            r4 = 74899(0x12493, float:1.04956E-40)
            r4 = r4 & r1
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r5) goto L_0x00d3
            boolean r4 = r13.getSkipping()
            if (r4 != 0) goto L_0x00cb
            goto L_0x00d3
        L_0x00cb:
            r13.skipToGroupEnd()
            r6 = r3
            r17 = r13
            goto L_0x0166
        L_0x00d3:
            if (r2 == 0) goto L_0x00dc
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r16 = r2
            goto L_0x00de
        L_0x00dc:
            r16 = r3
        L_0x00de:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ea
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:372)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00ea:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_range_picker_start_headline
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            r2 = 0
            java.lang.String r6 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r13, r2)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_date_range_picker_end_headline
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            java.lang.String r7 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r13, r2)
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1 r0 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
            r0.<init>(r6)
            r2 = 482821121(0x1cc74401, float:1.3186294E-21)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r2, r3, r0)
            r8 = r0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2 r0 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
            r0.<init>(r7)
            r2 = -1522669758(0xffffffffa53de742, float:-1.647149E-16)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r2, r3, r0)
            r17 = r0
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            androidx.compose.material3.ComposableSingletons$DateRangePickerKt r0 = androidx.compose.material3.ComposableSingletons$DateRangePickerKt.INSTANCE
            kotlin.jvm.functions.Function2 r18 = r0.m1709getLambda1$material3_release()
            r0 = r1 & 14
            r2 = 918552576(0x36c00000, float:5.722046E-6)
            r0 = r0 | r2
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r19 = r0 | r2
            int r0 = r1 >> 15
            r20 = r0 & 14
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r16
            r9 = r17
            r10 = r18
            r11 = r13
            r12 = r19
            r17 = r13
            r13 = r20
            r0.m1782DateRangePickerHeadline0YIUgSQ(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0164
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0164:
            r6 = r16
        L_0x0166:
            androidx.compose.runtime.ScopeUpdateScope r9 = r17.endRestartGroup()
            if (r9 == 0) goto L_0x0185
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$3 r10 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$3
            r0 = r10
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r7 = r28
            r8 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.m1784DateRangePickerHeadlinev84Udv0(java.lang.Long, java.lang.Long, int, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: DateRangePickerHeadline-0YIUgSQ  reason: not valid java name */
    public final void m1782DateRangePickerHeadline0YIUgSQ(Long l, Long l2, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i2, int i3) {
        int i4;
        Composer composer2;
        Long l3 = l;
        Long l4 = l2;
        int i5 = i;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        Modifier modifier2 = modifier;
        String str3 = str;
        String str4 = str2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        int i6 = i2;
        int i7 = i3;
        Composer startRestartGroup = composer.startRestartGroup(-820363420);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerHeadline)P(7,6,2:c#material3.DisplayMode!1,5,9,4,8,3)426@19095L15,461@20504L156,460@20446L720:DateRangePicker.kt#uh7d8r");
        if ((i6 & 6) == 0) {
            i4 = (startRestartGroup.changed((Object) l3) ? 4 : 2) | i6;
        } else {
            i4 = i6;
        }
        if ((i6 & 48) == 0) {
            i4 |= startRestartGroup.changed((Object) l4) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i4 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i4 |= (i6 & 4096) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 2048 : 1024;
        }
        if ((i6 & CpioConstants.C_ISBLK) == 0) {
            i4 |= startRestartGroup.changed((Object) modifier2) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i4 |= startRestartGroup.changed((Object) str3) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i4 |= startRestartGroup.changed((Object) str4) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((100663296 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(function25) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(function26) ? 536870912 : 268435456;
        }
        int i8 = i4;
        if ((306783379 & i8) == 306783378 && (i7 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-820363420, i8, i7, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:425)");
            }
            DatePickerFormatter datePickerFormatter3 = datePickerFormatter;
            int i9 = i8;
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            Composer composer3 = startRestartGroup;
            String formatDate$default = DatePickerFormatter.CC.formatDate$default(datePickerFormatter3, l, defaultLocale, false, 4, (Object) null);
            String formatDate$default2 = DatePickerFormatter.CC.formatDate$default(datePickerFormatter3, l2, defaultLocale, false, 4, (Object) null);
            String formatDate = datePickerFormatter2.formatDate(l3, defaultLocale, true);
            composer2 = composer3;
            composer2.startReplaceableGroup(-1212631660);
            String str5 = "";
            ComposerKt.sourceInformation(composer2, str5);
            if (formatDate == null) {
                if (DisplayMode.m1809equalsimpl0(i5, DisplayMode.Companion.m1814getPickerjFl4v0())) {
                    composer2.startReplaceableGroup(-1212631439);
                    ComposerKt.sourceInformation(composer2, "442@19680L51");
                    Strings.Companion companion = Strings.Companion;
                    formatDate = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_picker_no_selection_description), composer2, 0);
                    composer2.endReplaceableGroup();
                } else if (DisplayMode.m1809equalsimpl0(i5, DisplayMode.Companion.m1813getInputjFl4v0())) {
                    composer2.startReplaceableGroup(-1212631354);
                    ComposerKt.sourceInformation(composer2, "443@19765L46");
                    Strings.Companion companion2 = Strings.Companion;
                    formatDate = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_input_no_input_description), composer2, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(1063135767);
                    composer2.endReplaceableGroup();
                    formatDate = str5;
                }
            }
            composer2.endReplaceableGroup();
            String formatDate2 = datePickerFormatter2.formatDate(l4, defaultLocale, true);
            composer2.startReplaceableGroup(-1212631233);
            ComposerKt.sourceInformation(composer2, str5);
            if (formatDate2 != null) {
                str5 = formatDate2;
            } else if (DisplayMode.m1809equalsimpl0(i5, DisplayMode.Companion.m1814getPickerjFl4v0())) {
                composer2.startReplaceableGroup(-1212631014);
                ComposerKt.sourceInformation(composer2, "452@20105L51");
                Strings.Companion companion3 = Strings.Companion;
                str5 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_picker_no_selection_description), composer2, 0);
                composer2.endReplaceableGroup();
            } else if (DisplayMode.m1809equalsimpl0(i5, DisplayMode.Companion.m1813getInputjFl4v0())) {
                composer2.startReplaceableGroup(-1212630929);
                ComposerKt.sourceInformation(composer2, "453@20190L46");
                Strings.Companion companion4 = Strings.Companion;
                str5 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_input_no_input_description), composer2, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1063148942);
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            String str6 = str3 + ": " + formatDate;
            String str7 = str4 + ": " + str5;
            composer2.startReplaceableGroup(-1212630615);
            ComposerKt.sourceInformation(composer2, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean changed = composer2.changed((Object) str6) | composer2.changed((Object) str7);
            Object rememberedValue = composer2.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DateRangePickerDefaults$DateRangePickerHeadline$4$1(str6, str7);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceableGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier2, (Function1) rememberedValue);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical r3 = Arrangement.INSTANCE.m537spacedBy0680j_4(Dp.m6614constructorimpl((float) 4));
            composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(r3, centerVertically, composer2, 54);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(composer2);
            Updater.m3289setimpl(r6, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1922100092, "C473@20978L16:DateRangePicker.kt#uh7d8r");
            if (formatDate$default != null) {
                composer2.startReplaceableGroup(1922100124);
                ComposerKt.sourceInformation(composer2, "469@20860L31");
                TextKt.m2456Text4IGK_g(formatDate$default, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1922100193);
                ComposerKt.sourceInformation(composer2, "471@20929L22");
                function24.invoke(composer2, Integer.valueOf((i9 >> 21) & 14));
                composer2.endReplaceableGroup();
            }
            function26.invoke(composer2, Integer.valueOf((i9 >> 27) & 14));
            if (formatDate$default2 != null) {
                composer2.startReplaceableGroup(1922100319);
                ComposerKt.sourceInformation(composer2, "475@21055L29");
                TextKt.m2456Text4IGK_g(formatDate$default2, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1922100386);
                ComposerKt.sourceInformation(composer2, "477@21122L20");
                function25.invoke(composer2, Integer.valueOf((i9 >> 24) & 14));
                composer2.endReplaceableGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerDefaults$DateRangePickerHeadline$6(this, l, l2, i, datePickerFormatter, modifier, str, str2, function2, function22, function23, i2, i3));
        }
    }
}
