package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ak\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a°\u0001\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010.\u001a`\u0010/\u001a\u00020\f2\n\u00100\u001a\u000601j\u0002`22\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a½\u0001\u0010:\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010;\u001a\u0002072:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a°\u0001\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010A\u001a.\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010\u000b\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002\u001aT\u0010J\u001a\u00020\f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001ae\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u001c2\b\u0010O\u001a\u0004\u0018\u00010\u001c2\b\u0010P\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 H\u0002¢\u0006\u0002\u0010Q\u001a&\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0000ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerHeadlinePadding", "DateRangePickerTitlePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayedMonthMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateRangePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "displayMode", "SwitchableDateEntryContent-RN-2D1Q", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "rememberDateRangePickerState", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
public final class DateRangePickerKt {
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m667PaddingValuesa9UjIt4$default(Dp.m6614constructorimpl((float) 24), Dp.m6614constructorimpl((float) 20), 0.0f, Dp.m6614constructorimpl((float) 8), 4, (Object) null);
    /* access modifiers changed from: private */
    public static final PaddingValues DateRangePickerHeadlinePadding;
    /* access modifiers changed from: private */
    public static final PaddingValues DateRangePickerTitlePadding;
    private static final float HeaderHeightOffset = Dp.m6614constructorimpl((float) 60);

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DateRangePicker(androidx.compose.material3.DateRangePickerState r25, androidx.compose.ui.Modifier r26, androidx.compose.material3.DatePickerFormatter r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, boolean r30, androidx.compose.material3.DatePickerColors r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r1 = r25
            r0 = r27
            r8 = r33
            r2 = 650830774(0x26cae3b6, float:1.4078287E-15)
            r3 = r32
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(DateRangePicker)P(5,3,1,6,2,4)87@4101L47,104@4858L8,106@4895L15,107@4935L62,123@5551L10,108@5002L1936:DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r34 & 1
            if (r4 == 0) goto L_0x001b
            r4 = r8 | 6
            goto L_0x002b
        L_0x001b:
            r4 = r8 & 6
            if (r4 != 0) goto L_0x002a
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x0028
        L_0x0027:
            r4 = 2
        L_0x0028:
            r4 = r4 | r8
            goto L_0x002b
        L_0x002a:
            r4 = r8
        L_0x002b:
            r5 = r34 & 2
            if (r5 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0045
            r6 = r26
            boolean r7 = r3.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r4 = r4 | r7
            goto L_0x0047
        L_0x0045:
            r6 = r26
        L_0x0047:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r34 & 4
            if (r7 != 0) goto L_0x0061
            r7 = r8 & 512(0x200, float:7.175E-43)
            if (r7 != 0) goto L_0x0058
            boolean r7 = r3.changed((java.lang.Object) r0)
            goto L_0x005c
        L_0x0058:
            boolean r7 = r3.changedInstance(r0)
        L_0x005c:
            if (r7 == 0) goto L_0x0061
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r7
        L_0x0064:
            r7 = r34 & 8
            if (r7 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r9 = r8 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007e
            r9 = r28
            boolean r10 = r3.changedInstance(r9)
            if (r10 == 0) goto L_0x007a
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r4 = r4 | r10
            goto L_0x0080
        L_0x007e:
            r9 = r28
        L_0x0080:
            r10 = r34 & 16
            if (r10 == 0) goto L_0x0087
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009a
            r11 = r29
            boolean r12 = r3.changedInstance(r11)
            if (r12 == 0) goto L_0x0096
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r4 = r4 | r12
            goto L_0x009c
        L_0x009a:
            r11 = r29
        L_0x009c:
            r12 = r34 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a4
            r4 = r4 | r13
            goto L_0x00b6
        L_0x00a4:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b6
            r13 = r30
            boolean r14 = r3.changed((boolean) r13)
            if (r14 == 0) goto L_0x00b2
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r4 = r4 | r14
            goto L_0x00b8
        L_0x00b6:
            r13 = r30
        L_0x00b8:
            r14 = 1572864(0x180000, float:2.204052E-39)
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d2
            r14 = r34 & 64
            if (r14 != 0) goto L_0x00cc
            r14 = r31
            boolean r15 = r3.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00ce
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r14 = r31
        L_0x00ce:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r4 = r4 | r15
            goto L_0x00d4
        L_0x00d2:
            r14 = r31
        L_0x00d4:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r4
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r2) goto L_0x00ee
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x00e4
            goto L_0x00ee
        L_0x00e4:
            r3.skipToGroupEnd()
            r4 = r0
            r2 = r6
            r5 = r11
            r6 = r13
            r7 = r14
            goto L_0x0240
        L_0x00ee:
            r3.startDefaults()
            r2 = r8 & 1
            java.lang.String r15 = "CC(remember):DateRangePicker.kt#9igjgp"
            r0 = 1
            if (r2 == 0) goto L_0x011b
            boolean r2 = r3.getDefaultsInvalid()
            if (r2 == 0) goto L_0x00ff
            goto L_0x011b
        L_0x00ff:
            r3.skipToGroupEnd()
            r2 = r34 & 4
            if (r2 == 0) goto L_0x0108
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0108:
            r2 = r34 & 64
            if (r2 == 0) goto L_0x0110
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r2
        L_0x0110:
            r2 = r27
        L_0x0112:
            r5 = r11
            r7 = r13
            r24 = r9
            r9 = r4
            r4 = r24
            goto L_0x018e
        L_0x011b:
            if (r5 == 0) goto L_0x0122
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r6 = r2
        L_0x0122:
            r2 = r34 & 4
            if (r2 == 0) goto L_0x0156
            r2 = -1155307541(0xffffffffbb2367eb, float:-0.0024933766)
            r3.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r15)
            java.lang.Object r2 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r2 != r5) goto L_0x014e
            androidx.compose.material3.DatePickerDefaults r18 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            r22 = 7
            r23 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            androidx.compose.material3.DatePickerFormatter r2 = androidx.compose.material3.DatePickerDefaults.dateFormatter$default(r18, r19, r20, r21, r22, r23)
            r3.updateRememberedValue(r2)
        L_0x014e:
            androidx.compose.material3.DatePickerFormatter r2 = (androidx.compose.material3.DatePickerFormatter) r2
            r3.endReplaceableGroup()
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0158
        L_0x0156:
            r2 = r27
        L_0x0158:
            if (r7 == 0) goto L_0x0169
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$2 r5 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$2
            r5.<init>(r1)
            r7 = -162164694(0xfffffffff655902a, float:-1.0828938E33)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r7, r0, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r9 = r5
        L_0x0169:
            if (r10 == 0) goto L_0x017a
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$3 r5 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$3
            r5.<init>(r1, r2)
            r7 = -185279404(0xfffffffff4f4dc54, float:-1.5519888E32)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r7, r0, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r11 = r5
        L_0x017a:
            if (r12 == 0) goto L_0x017d
            r13 = r0
        L_0x017d:
            r5 = r34 & 64
            if (r5 == 0) goto L_0x0112
            androidx.compose.material3.DatePickerDefaults r5 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            r7 = 6
            androidx.compose.material3.DatePickerColors r5 = r5.colors(r3, r7)
            r7 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r7
            r14 = r5
            goto L_0x0112
        L_0x018e:
            r3.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x01a0
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:105)"
            r12 = 650830774(0x26cae3b6, float:1.4078287E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r9, r10, r11)
        L_0x01a0:
            r10 = 0
            java.util.Locale r10 = androidx.compose.material3.ActualAndroid_androidKt.defaultLocale(r3, r10)
            r11 = -1155306707(0xffffffffbb236b2d, float:-0.0024935708)
            r3.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r15)
            boolean r11 = r3.changed((java.lang.Object) r10)
            java.lang.Object r12 = r3.rememberedValue()
            if (r11 != 0) goto L_0x01c0
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x01c7
        L_0x01c0:
            androidx.compose.material3.CalendarModel r12 = androidx.compose.material3.CalendarModel_androidKt.createCalendarModel(r10)
            r3.updateRememberedValue(r12)
        L_0x01c7:
            androidx.compose.material3.CalendarModel r12 = (androidx.compose.material3.CalendarModel) r12
            r3.endReplaceableGroup()
            if (r7 == 0) goto L_0x01dd
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$4 r10 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
            r10.<init>(r1)
            r11 = -1490010652(0xffffffffa7303de4, float:-2.4458458E-15)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r11, r0, r10)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            goto L_0x01de
        L_0x01dd:
            r10 = 0
        L_0x01de:
            r13 = r10
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            r11 = 6
            androidx.compose.material3.Typography r10 = r10.getTypography(r3, r11)
            androidx.compose.material3.tokens.DatePickerModalTokens r11 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r11 = r11.getRangeSelectionHeaderHeadlineFont()
            androidx.compose.ui.text.TextStyle r15 = androidx.compose.material3.TypographyKt.fromToken(r10, r11)
            androidx.compose.material3.tokens.DatePickerModalTokens r10 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            float r10 = r10.m2795getRangeSelectionHeaderContainerHeightD9Ej5fM()
            float r11 = HeaderHeightOffset
            float r10 = r10 - r11
            float r16 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r10)
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$5 r10 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
            r10.<init>(r1, r12, r2, r14)
            r11 = -57534331(0xfffffffffc921885, float:-6.068581E36)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r11, r0, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r10 = r9 >> 3
            r10 = r10 & 14
            r11 = 14155776(0xd80000, float:1.9836467E-38)
            r10 = r10 | r11
            r11 = 6
            int r9 = r9 >> r11
            r11 = r9 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            r11 = r9 & 896(0x380, float:1.256E-42)
            r10 = r10 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r11
            r18 = r10 | r9
            r9 = r6
            r10 = r4
            r11 = r5
            r12 = r13
            r13 = r14
            r19 = r14
            r14 = r15
            r15 = r16
            r16 = r0
            r17 = r3
            androidx.compose.material3.DatePickerKt.m1767DateEntryContainerau3_HiA(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x023a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x023a:
            r9 = r4
            r4 = r2
            r2 = r6
            r6 = r7
            r7 = r19
        L_0x0240:
            androidx.compose.runtime.ScopeUpdateScope r10 = r3.endRestartGroup()
            if (r10 == 0) goto L_0x0259
            androidx.compose.material3.DateRangePickerKt$DateRangePicker$6 r11 = new androidx.compose.material3.DateRangePickerKt$DateRangePicker$6
            r0 = r11
            r1 = r25
            r3 = r4
            r4 = r9
            r8 = r33
            r9 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0259:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt.DateRangePicker(androidx.compose.material3.DateRangePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.DateRangePickerStateImpl, java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberDateRangePickerState-IlFM19s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.DateRangePickerState m1791rememberDateRangePickerStateIlFM19s(java.lang.Long r16, java.lang.Long r17, java.lang.Long r18, kotlin.ranges.IntRange r19, int r20, androidx.compose.material3.SelectableDates r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r22
            r0 = r23
            r1 = -2012087461(0xffffffff8811fb5b, float:-4.3929817E-34)
            r7.startReplaceableGroup(r1)
            java.lang.String r2 = "C(rememberDateRangePickerState)P(3,2,1,5,0:c#material3.DisplayMode)262@11461L15,265@11584L435,263@11488L531:DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r24 & 1
            r3 = 0
            if (r2 == 0) goto L_0x0016
            r9 = r3
            goto L_0x0018
        L_0x0016:
            r9 = r16
        L_0x0018:
            r2 = r24 & 2
            if (r2 == 0) goto L_0x001e
            r10 = r3
            goto L_0x0020
        L_0x001e:
            r10 = r17
        L_0x0020:
            r2 = r24 & 4
            if (r2 == 0) goto L_0x0026
            r11 = r9
            goto L_0x0028
        L_0x0026:
            r11 = r18
        L_0x0028:
            r2 = r24 & 8
            if (r2 == 0) goto L_0x0034
            androidx.compose.material3.DatePickerDefaults r2 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            kotlin.ranges.IntRange r2 = r2.getYearRange()
            r12 = r2
            goto L_0x0036
        L_0x0034:
            r12 = r19
        L_0x0036:
            r2 = r24 & 16
            if (r2 == 0) goto L_0x0042
            androidx.compose.material3.DisplayMode$Companion r2 = androidx.compose.material3.DisplayMode.Companion
            int r2 = r2.m1814getPickerjFl4v0()
            r13 = r2
            goto L_0x0044
        L_0x0042:
            r13 = r20
        L_0x0044:
            r2 = 32
            r3 = r24 & 32
            if (r3 == 0) goto L_0x0052
            androidx.compose.material3.DatePickerDefaults r3 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            androidx.compose.material3.SelectableDates r3 = r3.getAllDates()
            r14 = r3
            goto L_0x0054
        L_0x0052:
            r14 = r21
        L_0x0054:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0060
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:261)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r3, r4)
        L_0x0060:
            r1 = 0
            java.util.Locale r15 = androidx.compose.material3.ActualAndroid_androidKt.defaultLocale(r7, r1)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            androidx.compose.material3.DateRangePickerStateImpl$Companion r4 = androidx.compose.material3.DateRangePickerStateImpl.Companion
            androidx.compose.runtime.saveable.Saver r4 = r4.Saver(r14, r15)
            r5 = 269010268(0x1008c55c, float:2.697331E-29)
            r7.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):DateRangePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            r5 = r0 & 14
            r5 = r5 ^ 6
            r6 = 4
            r8 = 1
            if (r5 <= r6) goto L_0x0086
            boolean r5 = r7.changed((java.lang.Object) r9)
            if (r5 != 0) goto L_0x008a
        L_0x0086:
            r5 = r0 & 6
            if (r5 != r6) goto L_0x008c
        L_0x008a:
            r5 = r8
            goto L_0x008d
        L_0x008c:
            r5 = r1
        L_0x008d:
            r6 = r0 & 112(0x70, float:1.57E-43)
            r6 = r6 ^ 48
            if (r6 <= r2) goto L_0x0099
            boolean r6 = r7.changed((java.lang.Object) r10)
            if (r6 != 0) goto L_0x009d
        L_0x0099:
            r6 = r0 & 48
            if (r6 != r2) goto L_0x009f
        L_0x009d:
            r2 = r8
            goto L_0x00a0
        L_0x009f:
            r2 = r1
        L_0x00a0:
            r2 = r2 | r5
            r5 = r0 & 896(0x380, float:1.256E-42)
            r5 = r5 ^ 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r5 <= r6) goto L_0x00af
            boolean r5 = r7.changed((java.lang.Object) r11)
            if (r5 != 0) goto L_0x00b3
        L_0x00af:
            r5 = r0 & 384(0x180, float:5.38E-43)
            if (r5 != r6) goto L_0x00b5
        L_0x00b3:
            r5 = r8
            goto L_0x00b6
        L_0x00b5:
            r5 = r1
        L_0x00b6:
            r2 = r2 | r5
            boolean r5 = r7.changedInstance(r12)
            r2 = r2 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r0
            r5 = r5 ^ 24576(0x6000, float:3.4438E-41)
            r6 = 16384(0x4000, float:2.2959E-41)
            if (r5 <= r6) goto L_0x00cc
            boolean r5 = r7.changed((int) r13)
            if (r5 != 0) goto L_0x00d0
        L_0x00cc:
            r5 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r5 != r6) goto L_0x00d2
        L_0x00d0:
            r5 = r8
            goto L_0x00d3
        L_0x00d2:
            r5 = r1
        L_0x00d3:
            r2 = r2 | r5
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r0
            r6 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 ^ r6
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r5 <= r1) goto L_0x00e4
            boolean r5 = r7.changed((java.lang.Object) r14)
            if (r5 != 0) goto L_0x00e7
        L_0x00e4:
            r0 = r0 & r6
            if (r0 != r1) goto L_0x00e9
        L_0x00e7:
            r1 = r8
            goto L_0x00ea
        L_0x00e9:
            r1 = 0
        L_0x00ea:
            r0 = r2 | r1
            boolean r1 = r7.changedInstance(r15)
            r0 = r0 | r1
            java.lang.Object r1 = r22.rememberedValue()
            if (r0 != 0) goto L_0x00ff
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x010b
        L_0x00ff:
            androidx.compose.material3.DateRangePickerKt$rememberDateRangePickerState$1$1 r0 = new androidx.compose.material3.DateRangePickerKt$rememberDateRangePickerState$1$1
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r7.updateRememberedValue(r1)
        L_0x010b:
            r5 = r1
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r22.endReplaceableGroup()
            r6 = 0
            r8 = 4
            r2 = 0
            r0 = r3
            r1 = r4
            r3 = r5
            r4 = r22
            r5 = r6
            r6 = r8
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.DateRangePickerStateImpl r0 = (androidx.compose.material3.DateRangePickerStateImpl) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x012a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x012a:
            r22.endReplaceableGroup()
            androidx.compose.material3.DateRangePickerState r0 = (androidx.compose.material3.DateRangePickerState) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt.m1791rememberDateRangePickerStateIlFM19s(java.lang.Long, java.lang.Long, java.lang.Long, kotlin.ranges.IntRange, int, androidx.compose.material3.SelectableDates, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.DateRangePickerState");
    }

    /* renamed from: DateRangePickerState-HVP43zI$default  reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m1787DateRangePickerStateHVP43zI$default(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = null;
        }
        if ((i2 & 8) != 0) {
            l3 = l;
        }
        if ((i2 & 16) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 32) != 0) {
            i = DisplayMode.Companion.m1814getPickerjFl4v0();
        }
        if ((i2 & 64) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m1786DateRangePickerStateHVP43zI(locale, l, l2, l3, intRange, i, selectableDates);
    }

    /* renamed from: DateRangePickerState-HVP43zI  reason: not valid java name */
    public static final DateRangePickerState m1786DateRangePickerStateHVP43zI(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DateRangePickerStateImpl(l, l2, l3, intRange, i, selectableDates, locale, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: SwitchableDateEntryContent-RN-2D1Q  reason: not valid java name */
    public static final void m1788SwitchableDateEntryContentRN2D1Q(Long l, Long l2, long j, int i, Function2<? super Long, ? super Long, Unit> function2, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i2, int i3) {
        int i4;
        int i5;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        int i6 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-532789335);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchableDateEntryContent)P(9,8,4,3:c#material3.DisplayMode,5,6!1,10,2,7)683@29429L1337:DateRangePicker.kt#uh7d8r");
        int i7 = 4;
        Long l3 = l;
        if ((i6 & 6) == 0) {
            i4 = (startRestartGroup.changed((Object) l3) ? 4 : 2) | i6;
        } else {
            i4 = i6;
        }
        Long l4 = l2;
        if ((i6 & 48) == 0) {
            i4 |= startRestartGroup.changed((Object) l4) ? 32 : 16;
        }
        long j2 = j;
        if ((i6 & 384) == 0) {
            i4 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        int i8 = i;
        if ((i6 & 3072) == 0) {
            i4 |= startRestartGroup.changed(i8) ? 2048 : 1024;
        }
        Function2<? super Long, ? super Long, Unit> function22 = function2;
        if ((i6 & CpioConstants.C_ISBLK) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        Function1<? super Long, Unit> function12 = function1;
        if ((196608 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        CalendarModel calendarModel2 = calendarModel;
        if ((1572864 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(calendarModel2) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i4 |= startRestartGroup.changedInstance(intRange) ? 8388608 : 4194304;
        } else {
            IntRange intRange2 = intRange;
        }
        if ((i6 & 100663296) == 0) {
            i4 |= (i6 & 134217728) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        SelectableDates selectableDates2 = selectableDates;
        if ((i6 & 805306368) == 0) {
            i4 |= startRestartGroup.changed((Object) selectableDates2) ? 536870912 : 268435456;
        }
        DatePickerColors datePickerColors2 = datePickerColors;
        if ((i3 & 6) == 0) {
            if (!startRestartGroup.changed((Object) datePickerColors2)) {
                i7 = 2;
            }
            i5 = i3 | i7;
        } else {
            i5 = i3;
        }
        if ((i4 & 306783379) == 306783378 && (i5 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532789335, i4, i5, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:680)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, DateRangePickerKt$SwitchableDateEntryContent$1.INSTANCE, 1, (Object) null);
            DisplayMode r18 = DisplayMode.m1806boximpl(i);
            DateRangePickerKt$SwitchableDateEntryContent$2 dateRangePickerKt$SwitchableDateEntryContent$2 = r0;
            DateRangePickerKt$SwitchableDateEntryContent$2 dateRangePickerKt$SwitchableDateEntryContent$22 = new DateRangePickerKt$SwitchableDateEntryContent$2(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors);
            CrossfadeKt.Crossfade(r18, semantics$default, (FiniteAnimationSpec<Float>) AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1026642619, true, dateRangePickerKt$SwitchableDateEntryContent$2), startRestartGroup, ((i4 >> 9) & 14) | 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerKt$SwitchableDateEntryContent$3(l, l2, j, i, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void DateRangePickerContent(Long l, Long l2, long j, Function2<? super Long, ? super Long, Unit> function2, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composer2;
        long j2 = j;
        CalendarModel calendarModel2 = calendarModel;
        IntRange intRange2 = intRange;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        DatePickerColors datePickerColors2 = datePickerColors;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-787063721);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerContent)P(8,7,3,4,5!1,9,2,6)734@31377L87,735@31469L648:DateRangePicker.kt#uh7d8r");
        Long l3 = l;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) l3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        Long l4 = l2;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) l4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        Function2<? super Long, ? super Long, Unit> function22 = function2;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        Function1<? super Long, Unit> function12 = function1;
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= (16777216 & i3) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) selectableDates) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            SelectableDates selectableDates2 = selectableDates;
        }
        if ((i3 & 805306368) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787063721, i2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:731)");
            }
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(calendarModel2.getMonth(j2).indexIn(intRange2), 0, startRestartGroup, 0, 2);
            Modifier r1 = PaddingKt.m672paddingVpY3zN4$default(Modifier.Companion, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r1);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r7 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r7, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r7, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r7.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1265380359, "C736@31557L31,737@31597L514:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(datePickerColors2, calendarModel2, startRestartGroup, ((i2 >> 27) & 14) | ((i2 >> 12) & 112));
            composer2 = startRestartGroup;
            VerticalMonthsList(rememberLazyListState, l, l2, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, ((i2 << 3) & PointerIconCompat.TYPE_TEXT) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerKt$DateRangePickerContent$2(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: androidx.compose.material3.CalendarMonth} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void VerticalMonthsList(androidx.compose.foundation.lazy.LazyListState r23, java.lang.Long r24, java.lang.Long r25, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Long, kotlin.Unit> r26, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r27, androidx.compose.material3.CalendarModel r28, kotlin.ranges.IntRange r29, androidx.compose.material3.DatePickerFormatter r30, androidx.compose.material3.SelectableDates r31, androidx.compose.material3.DatePickerColors r32, androidx.compose.runtime.Composer r33, int r34) {
        /*
            r12 = r23
            r13 = r28
            r14 = r29
            r15 = r30
            r11 = r34
            r0 = 1257365001(0x4af1de09, float:7925508.5)
            r1 = r33
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(VerticalMonthsList)P(3,8,7,4,5!1,9,2,6)771@32837L138,778@33020L10,777@32980L4376,872@37391L228,872@37361L258:DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r11 & 6
            if (r1 != 0) goto L_0x0027
            boolean r1 = r10.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x0024
            r1 = 4
            goto L_0x0025
        L_0x0024:
            r1 = 2
        L_0x0025:
            r1 = r1 | r11
            goto L_0x0028
        L_0x0027:
            r1 = r11
        L_0x0028:
            r2 = r11 & 48
            r8 = r24
            if (r2 != 0) goto L_0x003a
            boolean r2 = r10.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0037
            r2 = 32
            goto L_0x0039
        L_0x0037:
            r2 = 16
        L_0x0039:
            r1 = r1 | r2
        L_0x003a:
            r2 = r11 & 384(0x180, float:5.38E-43)
            r7 = r25
            if (r2 != 0) goto L_0x004c
            boolean r2 = r10.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0049
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004b
        L_0x0049:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004b:
            r1 = r1 | r2
        L_0x004c:
            r2 = r11 & 3072(0xc00, float:4.305E-42)
            r6 = r26
            if (r2 != 0) goto L_0x005e
            boolean r2 = r10.changedInstance(r6)
            if (r2 == 0) goto L_0x005b
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005d
        L_0x005b:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005d:
            r1 = r1 | r2
        L_0x005e:
            r2 = r11 & 24576(0x6000, float:3.4438E-41)
            r4 = r27
            if (r2 != 0) goto L_0x0070
            boolean r2 = r10.changedInstance(r4)
            if (r2 == 0) goto L_0x006d
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006f
        L_0x006d:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006f:
            r1 = r1 | r2
        L_0x0070:
            r2 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x0081
            boolean r2 = r10.changedInstance(r13)
            if (r2 == 0) goto L_0x007e
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0080
        L_0x007e:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0080:
            r1 = r1 | r2
        L_0x0081:
            r2 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x0092
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x008f
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0091
        L_0x008f:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x0091:
            r1 = r1 | r2
        L_0x0092:
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x00ad
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x00a1
            boolean r2 = r10.changed((java.lang.Object) r15)
            goto L_0x00a5
        L_0x00a1:
            boolean r2 = r10.changedInstance(r15)
        L_0x00a5:
            if (r2 == 0) goto L_0x00aa
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ac
        L_0x00aa:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ac:
            r1 = r1 | r2
        L_0x00ad:
            r2 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 & r11
            r3 = r31
            if (r2 != 0) goto L_0x00c0
            boolean r2 = r10.changed((java.lang.Object) r3)
            if (r2 == 0) goto L_0x00bd
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00bf
        L_0x00bd:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00bf:
            r1 = r1 | r2
        L_0x00c0:
            r2 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x00d5
            r2 = r32
            boolean r16 = r10.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x00d0
            r16 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00d2
        L_0x00d0:
            r16 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00d2:
            r1 = r1 | r16
            goto L_0x00d7
        L_0x00d5:
            r2 = r32
        L_0x00d7:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r5 = r1 & r16
            r9 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r9) goto L_0x00ef
            boolean r5 = r10.getSkipping()
            if (r5 != 0) goto L_0x00e8
            goto L_0x00ef
        L_0x00e8:
            r10.skipToGroupEnd()
            r0 = r10
            r2 = r12
            goto L_0x01d8
        L_0x00ef:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00fb
            r5 = -1
            java.lang.String r9 = "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:769)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r5, r9)
        L_0x00fb:
            androidx.compose.material3.CalendarDate r17 = r28.getToday()
            r0 = 1454981403(0x56b9411b, float:1.01844638E14)
            r10.startReplaceableGroup(r0)
            java.lang.String r9 = "CC(remember):DateRangePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            boolean r0 = r10.changed((java.lang.Object) r14)
            java.lang.Object r5 = r10.rememberedValue()
            r15 = 1
            if (r0 != 0) goto L_0x011d
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x0128
        L_0x011d:
            int r0 = r29.getFirst()
            androidx.compose.material3.CalendarMonth r5 = r13.getMonth(r0, r15)
            r10.updateRememberedValue(r5)
        L_0x0128:
            r18 = r5
            androidx.compose.material3.CalendarMonth r18 = (androidx.compose.material3.CalendarMonth) r18
            r10.endReplaceableGroup()
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            r5 = 6
            androidx.compose.material3.Typography r0 = r0.getTypography(r10, r5)
            androidx.compose.material3.tokens.DatePickerModalTokens r5 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r5.getDateLabelTextFont()
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.material3.TypographyKt.fromToken(r0, r5)
            androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1 r0 = new androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1
            r19 = r0
            r20 = r1
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r23
            r21 = r5
            r5 = r29
            r6 = r28
            r7 = r18
            r8 = r30
            r22 = r9
            r9 = r32
            r12 = r10
            r10 = r17
            r11 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = 1090773432(0x4103e1b8, float:8.242607)
            r1 = r19
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r15, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 48
            r2 = r21
            androidx.compose.material3.TextKt.ProvideTextStyle(r2, r0, r12, r1)
            r0 = 1454985957(0x56b952e5, float:1.0188284E14)
            r12.startReplaceableGroup(r0)
            r0 = r22
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r6 = r20 & 14
            r0 = 0
            r1 = 4
            if (r6 != r1) goto L_0x0189
            r1 = r15
            goto L_0x018a
        L_0x0189:
            r1 = r0
        L_0x018a:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r20 & r2
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r2 != r3) goto L_0x0194
            goto L_0x0195
        L_0x0194:
            r15 = r0
        L_0x0195:
            r0 = r1 | r15
            boolean r1 = r12.changedInstance(r13)
            r0 = r0 | r1
            boolean r1 = r12.changedInstance(r14)
            r0 = r0 | r1
            java.lang.Object r1 = r12.rememberedValue()
            if (r0 != 0) goto L_0x01af
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x01c4
        L_0x01af:
            androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$2$1 r7 = new androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$2$1
            r5 = 0
            r0 = r7
            r1 = r23
            r2 = r27
            r3 = r28
            r4 = r29
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = r7
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r12.updateRememberedValue(r1)
        L_0x01c4:
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r12.endReplaceableGroup()
            r2 = r23
            r0 = r12
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r0, (int) r6)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01d8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d8:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 == 0) goto L_0x01ff
            androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$3 r15 = new androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$3
            r0 = r15
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r11 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r12.updateScope(r15)
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList(androidx.compose.foundation.lazy.LazyListState, java.lang.Long, java.lang.Long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, androidx.compose.material3.CalendarModel, kotlin.ranges.IntRange, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void updateDateSelection(long j, Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2) {
        if ((l == null && l2 == null) || (l != null && l2 != null)) {
            function2.invoke(Long.valueOf(j), null);
        } else if (l == null || j < l.longValue()) {
            function2.invoke(Long.valueOf(j), null);
        } else {
            function2.invoke(l, Long.valueOf(j));
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* renamed from: drawRangeBackground-mxwnekA  reason: not valid java name */
    public static final void m1790drawRangeBackgroundmxwnekA(ContentDrawScope contentDrawScope, SelectedRangeInfo selectedRangeInfo, long j) {
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float r1 = contentDrawScope2.m6550toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float r2 = contentDrawScope2.m6550toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float r3 = contentDrawScope2.m6550toPx0680j_4(DatePickerModalTokens.INSTANCE.m2788getDateStateLayerHeightD9Ej5fM());
        float f = (float) 2;
        float f2 = (r2 - r3) / f;
        float f3 = (float) 7;
        float r6 = (Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()) - (f3 * r1)) / f3;
        long r7 = selectedRangeInfo.m2160getGridStartCoordinatesnOccac();
        int r9 = IntOffset.m6740component1impl(r7);
        int r72 = IntOffset.m6741component2impl(r7);
        long r10 = selectedRangeInfo.m2159getGridEndCoordinatesnOccac();
        int r8 = IntOffset.m6740component1impl(r10);
        int r102 = IntOffset.m6741component2impl(r10);
        float f4 = r1 + r6;
        float f5 = 0.0f;
        float f6 = r6 / f;
        float f7 = (((float) r9) * f4) + (selectedRangeInfo.getFirstIsSelectionStart() ? r1 / f : 0.0f) + f6;
        float f8 = (((float) r72) * r2) + f2;
        float f9 = ((float) r8) * f4;
        if (selectedRangeInfo.getLastIsSelectionEnd()) {
            r1 /= f;
        }
        float f10 = f9 + r1 + f6;
        float f11 = (((float) r102) * r2) + f2;
        boolean z = contentDrawScope.getLayoutDirection() == LayoutDirection.Rtl;
        if (z) {
            f7 = Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()) - f7;
            f10 = Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()) - f10;
        }
        DrawScope drawScope = contentDrawScope2;
        DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope, j, OffsetKt.Offset(f7, f8), SizeKt.Size(r72 == r102 ? f10 - f7 : z ? -f7 : Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()) - f7, r3), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        if (r72 != r102) {
            for (int i = (r102 - r72) - 1; i > 0; i--) {
                DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope, j, OffsetKt.Offset(0.0f, (((float) i) * r2) + f8), SizeKt.Size(Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()), r3), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
            }
            if (contentDrawScope.getLayoutDirection() != LayoutDirection.Ltr) {
                f5 = Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc());
            }
            long Offset = OffsetKt.Offset(f5, f11);
            if (z) {
                f10 -= Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc());
            }
            DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope, j, Offset, SizeKt.Size(f10, r3), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(LazyListState lazyListState, CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf(new CustomAccessibilityAction(str, new DateRangePickerKt$customScrollActions$scrollUpAction$1(lazyListState, coroutineScope)), new CustomAccessibilityAction(str2, new DateRangePickerKt$customScrollActions$scrollDownAction$1(lazyListState, coroutineScope)));
    }

    static {
        float f = (float) 64;
        float f2 = (float) 12;
        DateRangePickerTitlePadding = PaddingKt.m667PaddingValuesa9UjIt4$default(Dp.m6614constructorimpl(f), 0.0f, Dp.m6614constructorimpl(f2), 0.0f, 10, (Object) null);
        DateRangePickerHeadlinePadding = PaddingKt.m667PaddingValuesa9UjIt4$default(Dp.m6614constructorimpl(f), 0.0f, Dp.m6614constructorimpl(f2), Dp.m6614constructorimpl(f2), 2, (Object) null);
    }
}
