package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
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
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001ak\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010+\u001a\u0001\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010=\u001aZ\u0010>\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aT\u0010E\u001a\u00020&2\n\u0010F\u001a\u00060Gj\u0002`H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010.2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001an\u0010O\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010X\u001a6\u0010Y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020L2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001401H\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a\u0001\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2\b\u0010-\u001a\u0004\u0018\u00010.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010a\u001av\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020d2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012\u0006\u0010e\u001a\u00020.2\b\u0010f\u001a\u0004\u0018\u00010.2\b\u0010g\u001a\u0004\u0018\u00010.2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010j\u001ag\u0010k\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020W2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010s\u001a\u0001\u0010t\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2\u0006\u0010Z\u001a\u00020L2#\u00100\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\bu\u0010v\u001a\u001d\u0010w\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u0010x\u001a^\u0010y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\u0006\u0010z\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010S\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010{\u001a`\u0010|\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010/\u001a\u00020.2!\u0010}\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(~\u0012\u0004\u0012\u00020\u0014012\u0006\u0010;\u001a\u00020<2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u001aC\u0010\u0001\u001a\u00020\u00142\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0007\u0010\u0001\u001a\u00020*2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0003\u0010\u0001\u001a6\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00012\u0007\u0010%\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020W2\u0007\u0010\u0001\u001a\u00020WH\u0002\u001a>\u0010\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*2\u0007\u0010\u0001\u001a\u00020*H\u0003¢\u0006\u0003\u0010\u0001\u001a\u0011\u0010\u0001\u001a\u00020\f2\u0006\u00109\u001a\u00020:H\u0000\u001aK\u0010\u0001\u001a\u00020&2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010.2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001aK\u0010\u0001\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H@¢\u0006\u0003\u0010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005\"\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0001²\u0006\n\u0010n\u001a\u00020*X\u0002"}, d2 = {"DatePickerHeadlinePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getDatePickerHorizontalPadding", "()F", "F", "DatePickerModeTogglePadding", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "MaxCalendarRows", "", "MonthYearHeight", "getMonthYearHeight", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "YearsInRow", "YearsVerticalPadding", "DateEntryContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "modeToggleButton", "colors", "Landroidx/compose/material3/DatePickerColors;", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePicker", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "showModeToggle", "", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "selectedDateMillis", "", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "Day", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "DisplayModeToggleButton-tER2X8s", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "SwitchableDateEntryContent-d7iavvg", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "scrollDownLabel", "dayContentDescription", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "numberOfMonthsInRange", "rememberDatePickerState", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerKt {
    /* access modifiers changed from: private */
    public static final PaddingValues DatePickerHeadlinePadding;
    private static final float DatePickerHorizontalPadding;
    private static final PaddingValues DatePickerModeTogglePadding;
    /* access modifiers changed from: private */
    public static final PaddingValues DatePickerTitlePadding;
    private static final int MaxCalendarRows = 6;
    private static final float MonthYearHeight = Dp.m6614constructorimpl((float) 56);
    private static final float RecommendedSizeForAccessibility = Dp.m6614constructorimpl((float) 48);
    private static final int YearsInRow = 3;
    /* access modifiers changed from: private */
    public static final float YearsVerticalPadding;

    /* JADX WARNING: Removed duplicated region for block: B:131:0x023f  */
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
    public static final void DatePicker(androidx.compose.material3.DatePickerState r25, androidx.compose.ui.Modifier r26, androidx.compose.material3.DatePickerFormatter r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, boolean r30, androidx.compose.material3.DatePickerColors r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r1 = r25
            r0 = r27
            r8 = r33
            r2 = 809701813(0x304311b5, float:7.096575E-10)
            r3 = r32
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(DatePicker)P(5,3,1,6,2,4)154@7440L47,170@8108L8,172@8145L15,173@8185L62,189@8801L10,174@8252L1391:DatePicker.kt#uh7d8r"
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
            goto L_0x0239
        L_0x00ee:
            r3.startDefaults()
            r2 = r8 & 1
            java.lang.String r15 = "CC(remember):DatePicker.kt#9igjgp"
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
            r2 = 1809358065(0x6bd89cf1, float:5.2373822E26)
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
            androidx.compose.material3.DatePickerKt$DatePicker$2 r5 = new androidx.compose.material3.DatePickerKt$DatePicker$2
            r5.<init>(r1)
            r7 = -1504998463(0xffffffffa64b8bc1, float:-7.0619175E-16)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r7, r0, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r9 = r5
        L_0x0169:
            if (r10 == 0) goto L_0x017a
            androidx.compose.material3.DatePickerKt$DatePicker$3 r5 = new androidx.compose.material3.DatePickerKt$DatePicker$3
            r5.<init>(r1, r2)
            r7 = -1780043561(0xffffffff95e6b0d7, float:-9.3175264E-26)
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
            java.lang.String r11 = "androidx.compose.material3.DatePicker (DatePicker.kt:171)"
            r12 = 809701813(0x304311b5, float:7.096575E-10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r9, r10, r11)
        L_0x01a0:
            r10 = 0
            java.util.Locale r10 = androidx.compose.material3.ActualAndroid_androidKt.defaultLocale(r3, r10)
            r11 = 1809358810(0x6bd89fda, float:5.237657E26)
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
            androidx.compose.material3.DatePickerKt$DatePicker$4 r10 = new androidx.compose.material3.DatePickerKt$DatePicker$4
            r10.<init>(r1)
            r11 = 1982226759(0x76266147, float:8.436468E32)
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
            androidx.compose.material3.tokens.TypographyKeyTokens r11 = r11.getHeaderHeadlineFont()
            androidx.compose.ui.text.TextStyle r15 = androidx.compose.material3.TypographyKt.fromToken(r10, r11)
            androidx.compose.material3.tokens.DatePickerModalTokens r10 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            float r16 = r10.m2791getHeaderContainerHeightD9Ej5fM()
            androidx.compose.material3.DatePickerKt$DatePicker$5 r10 = new androidx.compose.material3.DatePickerKt$DatePicker$5
            r10.<init>(r1, r12, r2, r14)
            r11 = -1840727866(0xffffffff9248b8c6, float:-6.3336623E-28)
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
            m1767DateEntryContainerau3_HiA(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0233
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0233:
            r9 = r4
            r4 = r2
            r2 = r6
            r6 = r7
            r7 = r19
        L_0x0239:
            androidx.compose.runtime.ScopeUpdateScope r10 = r3.endRestartGroup()
            if (r10 == 0) goto L_0x0252
            androidx.compose.material3.DatePickerKt$DatePicker$6 r11 = new androidx.compose.material3.DatePickerKt$DatePicker$6
            r0 = r11
            r1 = r25
            r3 = r4
            r4 = r9
            r8 = r33
            r9 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0252:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.DatePicker(androidx.compose.material3.DatePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.DatePickerStateImpl, java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberDatePickerState-EU0dCGE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.DatePickerState m1774rememberDatePickerStateEU0dCGE(java.lang.Long r15, java.lang.Long r16, kotlin.ranges.IntRange r17, int r18, androidx.compose.material3.SelectableDates r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r7 = r20
            r0 = r21
            r1 = 2065763010(0x7b210ac2, float:8.36178E35)
            r7.startReplaceableGroup(r1)
            java.lang.String r2 = "C(rememberDatePickerState)P(2,1,4,0:c#material3.DisplayMode)364@14941L15,367@15059L347,365@14968L438:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r22 & 1
            if (r2 == 0) goto L_0x0016
            r2 = 0
            r9 = r2
            goto L_0x0017
        L_0x0016:
            r9 = r15
        L_0x0017:
            r2 = r22 & 2
            if (r2 == 0) goto L_0x001d
            r10 = r9
            goto L_0x001f
        L_0x001d:
            r10 = r16
        L_0x001f:
            r2 = r22 & 4
            if (r2 == 0) goto L_0x002b
            androidx.compose.material3.DatePickerDefaults r2 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            kotlin.ranges.IntRange r2 = r2.getYearRange()
            r11 = r2
            goto L_0x002d
        L_0x002b:
            r11 = r17
        L_0x002d:
            r2 = r22 & 8
            if (r2 == 0) goto L_0x0039
            androidx.compose.material3.DisplayMode$Companion r2 = androidx.compose.material3.DisplayMode.Companion
            int r2 = r2.m1814getPickerjFl4v0()
            r12 = r2
            goto L_0x003b
        L_0x0039:
            r12 = r18
        L_0x003b:
            r2 = r22 & 16
            if (r2 == 0) goto L_0x0047
            androidx.compose.material3.DatePickerDefaults r2 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            androidx.compose.material3.SelectableDates r2 = r2.getAllDates()
            r13 = r2
            goto L_0x0049
        L_0x0047:
            r13 = r19
        L_0x0049:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0055
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:363)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r2, r3)
        L_0x0055:
            r1 = 0
            java.util.Locale r14 = androidx.compose.material3.ActualAndroid_androidKt.defaultLocale(r7, r1)
            java.lang.Object[] r2 = new java.lang.Object[r1]
            androidx.compose.material3.DatePickerStateImpl$Companion r3 = androidx.compose.material3.DatePickerStateImpl.Companion
            androidx.compose.runtime.saveable.Saver r3 = r3.Saver(r13, r14)
            r4 = -1398082866(0xffffffffacaaf2ce, float:-4.8586473E-12)
            r7.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r4)
            r4 = r0 & 14
            r4 = r4 ^ 6
            r5 = 4
            r6 = 1
            if (r4 <= r5) goto L_0x007b
            boolean r4 = r7.changed((java.lang.Object) r9)
            if (r4 != 0) goto L_0x007f
        L_0x007b:
            r4 = r0 & 6
            if (r4 != r5) goto L_0x0081
        L_0x007f:
            r4 = r6
            goto L_0x0082
        L_0x0081:
            r4 = r1
        L_0x0082:
            r5 = r0 & 112(0x70, float:1.57E-43)
            r5 = r5 ^ 48
            r8 = 32
            if (r5 <= r8) goto L_0x0090
            boolean r5 = r7.changed((java.lang.Object) r10)
            if (r5 != 0) goto L_0x0094
        L_0x0090:
            r5 = r0 & 48
            if (r5 != r8) goto L_0x0096
        L_0x0094:
            r5 = r6
            goto L_0x0097
        L_0x0096:
            r5 = r1
        L_0x0097:
            r4 = r4 | r5
            boolean r5 = r7.changedInstance(r11)
            r4 = r4 | r5
            r5 = r0 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 ^ 3072(0xc00, float:4.305E-42)
            r8 = 2048(0x800, float:2.87E-42)
            if (r5 <= r8) goto L_0x00ab
            boolean r5 = r7.changed((int) r12)
            if (r5 != 0) goto L_0x00af
        L_0x00ab:
            r5 = r0 & 3072(0xc00, float:4.305E-42)
            if (r5 != r8) goto L_0x00b1
        L_0x00af:
            r5 = r6
            goto L_0x00b2
        L_0x00b1:
            r5 = r1
        L_0x00b2:
            r4 = r4 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r0
            r5 = r5 ^ 24576(0x6000, float:3.4438E-41)
            r8 = 16384(0x4000, float:2.2959E-41)
            if (r5 <= r8) goto L_0x00c3
            boolean r5 = r7.changed((java.lang.Object) r13)
            if (r5 != 0) goto L_0x00c7
        L_0x00c3:
            r0 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r0 != r8) goto L_0x00c8
        L_0x00c7:
            r1 = r6
        L_0x00c8:
            r0 = r4 | r1
            boolean r1 = r7.changedInstance(r14)
            r0 = r0 | r1
            java.lang.Object r1 = r20.rememberedValue()
            if (r0 != 0) goto L_0x00dd
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00e9
        L_0x00dd:
            androidx.compose.material3.DatePickerKt$rememberDatePickerState$1$1 r0 = new androidx.compose.material3.DatePickerKt$rememberDatePickerState$1$1
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r7.updateRememberedValue(r1)
        L_0x00e9:
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r20.endReplaceableGroup()
            r5 = 0
            r6 = 4
            r8 = 0
            r0 = r2
            r1 = r3
            r2 = r8
            r3 = r4
            r4 = r20
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.DatePickerStateImpl r0 = (androidx.compose.material3.DatePickerStateImpl) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0107
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0107:
            r20.endReplaceableGroup()
            androidx.compose.material3.DatePickerState r0 = (androidx.compose.material3.DatePickerState) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.m1774rememberDatePickerStateEU0dCGE(java.lang.Long, java.lang.Long, kotlin.ranges.IntRange, int, androidx.compose.material3.SelectableDates, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.DatePickerState");
    }

    /* renamed from: DatePickerState-sHin3Bw$default  reason: not valid java name */
    public static /* synthetic */ DatePickerState m1770DatePickerStatesHin3Bw$default(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        Long l3 = (i2 & 4) != 0 ? l : l2;
        if ((i2 & 8) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        IntRange intRange2 = intRange;
        if ((i2 & 16) != 0) {
            i = DisplayMode.Companion.m1814getPickerjFl4v0();
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m1769DatePickerStatesHin3Bw(locale, l, l3, intRange2, i3, selectableDates);
    }

    /* renamed from: DatePickerState-sHin3Bw  reason: not valid java name */
    public static final DatePickerState m1769DatePickerStatesHin3Bw(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DatePickerStateImpl(l, l2, intRange, i, selectableDates, locale, (DefaultConstructorMarker) null);
    }

    /* renamed from: DateEntryContainer-au3_HiA  reason: not valid java name */
    public static final void m1767DateEntryContainerau3_HiA(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, DatePickerColors datePickerColors, TextStyle textStyle, float f, Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function24;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1507356255);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateEntryContainer)P(6,7,3,5!1,4,2:c#ui.unit.Dp)1303@58682L1716:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function27 = function22;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function28 = function23;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors) ? 16384 : 8192;
        } else {
            DatePickerColors datePickerColors2 = datePickerColors;
        }
        TextStyle textStyle2 = textStyle;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle2) ? 131072 : 65536;
        }
        float f2 = f;
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507356255, i2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1302)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(SizeKt.m746sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m2785getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, (Object) null), false, DatePickerKt$DateEntryContainer$1.INSTANCE, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(semantics$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r14 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r14, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r14, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r14.getInserting() || !Intrinsics.areEqual(r14.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r14.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -916065881, "C1311@58918L1456,1344@60383L9:DatePicker.kt#uh7d8r");
            long r16 = datePickerColors.m1757getTitleContentColor0d7_KjU();
            long r18 = datePickerColors.m1750getHeadlineContentColor0d7_KjU();
            DatePickerKt$DateEntryContainer$2$1 datePickerKt$DateEntryContainer$2$1 = r10;
            DatePickerKt$DateEntryContainer$2$1 datePickerKt$DateEntryContainer$2$12 = new DatePickerKt$DateEntryContainer$2$1(function22, function23, function2, datePickerColors, textStyle);
            m1768DatePickerHeaderpc5RIQQ(Modifier.Companion, function2, r16, r18, f, ComposableLambdaKt.composableLambda(startRestartGroup, -229007058, true, datePickerKt$DateEntryContainer$2$1), startRestartGroup, (i2 & 112) | 196614 | (57344 & (i2 >> 6)));
            function25.invoke(startRestartGroup, Integer.valueOf((i2 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$DateEntryContainer$3(modifier, function2, function22, function23, datePickerColors, textStyle, f, function24, i));
        }
    }

    /* renamed from: DisplayModeToggleButton-tER2X8s  reason: not valid java name */
    public static final void m1771DisplayModeToggleButtontER2X8s(Modifier modifier, int i, Function1<? super DisplayMode, Unit> function1, Composer composer, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1393846115);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisplayModeToggleButton)P(1,0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393846115, i3, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1354)");
            }
            boolean z = true;
            if (DisplayMode.m1809equalsimpl0(i, DisplayMode.Companion.m1814getPickerjFl4v0())) {
                startRestartGroup.startReplaceableGroup(-1814955688);
                ComposerKt.sourceInformation(startRestartGroup, "1356@60671L42,1356@60650L262");
                startRestartGroup.startReplaceableGroup(-1814955657);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                if ((i3 & 896) != 256) {
                    z = false;
                }
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DatePickerKt$DisplayModeToggleButton$1$1(function1);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                IconButtonKt.IconButton((Function0) rememberedValue, modifier, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$DatePickerKt.INSTANCE.m1705getLambda1$material3_release(), startRestartGroup, ((i3 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1814955404);
                ComposerKt.sourceInformation(startRestartGroup, "1363@60955L43,1363@60934L271");
                startRestartGroup.startReplaceableGroup(-1814955373);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                if ((i3 & 896) != 256) {
                    z = false;
                }
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new DatePickerKt$DisplayModeToggleButton$2$1(function1);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                IconButtonKt.IconButton((Function0) rememberedValue2, modifier, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$DatePickerKt.INSTANCE.m1706getLambda2$material3_release(), startRestartGroup, ((i3 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$DisplayModeToggleButton$3(modifier, i, function1, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: kotlin.jvm.functions.Function1} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: SwitchableDateEntryContent-d7iavvg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1772SwitchableDateEntryContentd7iavvg(java.lang.Long r20, long r21, int r23, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r24, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r25, androidx.compose.material3.CalendarModel r26, kotlin.ranges.IntRange r27, androidx.compose.material3.DatePickerFormatter r28, androidx.compose.material3.SelectableDates r29, androidx.compose.material3.DatePickerColors r30, androidx.compose.runtime.Composer r31, int r32) {
        /*
            r11 = r28
            r12 = r32
            r0 = -895379221(0xffffffffcaa198eb, float:-5295221.5)
            r1 = r31
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SwitchableDateEntryContent)P(8,4,3:c#material3.DisplayMode,5,6!1,9,2,7)*1392@62001L7,1399@62233L1975,1393@62037L3206:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r12 & 6
            r14 = r20
            if (r1 != 0) goto L_0x0023
            boolean r1 = r13.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0020
            r1 = 4
            goto L_0x0021
        L_0x0020:
            r1 = 2
        L_0x0021:
            r1 = r1 | r12
            goto L_0x0024
        L_0x0023:
            r1 = r12
        L_0x0024:
            r2 = r12 & 48
            r9 = r21
            if (r2 != 0) goto L_0x0036
            boolean r2 = r13.changed((long) r9)
            if (r2 == 0) goto L_0x0033
            r2 = 32
            goto L_0x0035
        L_0x0033:
            r2 = 16
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r12 & 384(0x180, float:5.38E-43)
            r15 = r23
            if (r2 != 0) goto L_0x0048
            boolean r2 = r13.changed((int) r15)
            if (r2 == 0) goto L_0x0045
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0047
        L_0x0045:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 3072(0xc00, float:4.305E-42)
            r8 = r24
            if (r2 != 0) goto L_0x005a
            boolean r2 = r13.changedInstance(r8)
            if (r2 == 0) goto L_0x0057
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0059
        L_0x0057:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0059:
            r1 = r1 | r2
        L_0x005a:
            r2 = r12 & 24576(0x6000, float:3.4438E-41)
            r7 = r25
            if (r2 != 0) goto L_0x006c
            boolean r2 = r13.changedInstance(r7)
            if (r2 == 0) goto L_0x0069
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006b
        L_0x0069:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006b:
            r1 = r1 | r2
        L_0x006c:
            r2 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 & r12
            r6 = r26
            if (r2 != 0) goto L_0x007f
            boolean r2 = r13.changedInstance(r6)
            if (r2 == 0) goto L_0x007c
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x007e
        L_0x007c:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x007e:
            r1 = r1 | r2
        L_0x007f:
            r2 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 & r12
            r5 = r27
            if (r2 != 0) goto L_0x0092
            boolean r2 = r13.changedInstance(r5)
            if (r2 == 0) goto L_0x008f
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0091
        L_0x008f:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x0091:
            r1 = r1 | r2
        L_0x0092:
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00ad
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00a1
            boolean r2 = r13.changed((java.lang.Object) r11)
            goto L_0x00a5
        L_0x00a1:
            boolean r2 = r13.changedInstance(r11)
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
            r2 = r2 & r12
            r4 = r29
            if (r2 != 0) goto L_0x00c0
            boolean r2 = r13.changed((java.lang.Object) r4)
            if (r2 == 0) goto L_0x00bd
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00bf
        L_0x00bd:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00bf:
            r1 = r1 | r2
        L_0x00c0:
            r2 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00d4
            r2 = r30
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x00d0
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00d2
        L_0x00d0:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00d2:
            r1 = r1 | r3
            goto L_0x00d6
        L_0x00d4:
            r2 = r30
        L_0x00d6:
            r3 = r1
            r1 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r1 & r3
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r0) goto L_0x00ec
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x00e7
            goto L_0x00ec
        L_0x00e7:
            r13.skipToGroupEnd()
            goto L_0x01a9
        L_0x00ec:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00fb
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1389)"
            r2 = -895379221(0xffffffffcaa198eb, float:-5295221.5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r0, r1)
        L_0x00fb:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r2)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r1 = 48
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            int r0 = r0.m6545roundToPx0680j_4(r1)
            int r0 = -r0
            androidx.compose.material3.DisplayMode r16 = androidx.compose.material3.DisplayMode.m1806boximpl(r23)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1 r2 = androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r31 = r3
            r3 = 0
            r4 = 0
            r11 = 1
            androidx.compose.ui.Modifier r17 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r4, r2, r11, r3)
            r1 = 1777156755(0x69ed4293, float:3.5853726E25)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = r13.changed((int) r0)
            java.lang.Object r2 = r13.rememberedValue()
            if (r1 != 0) goto L_0x0150
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x015b
        L_0x0150:
            androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1 r1 = new androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1
            r1.<init>(r0)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r13.updateRememberedValue(r2)
        L_0x015b:
            r18 = r2
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            r13.endReplaceableGroup()
            androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3 r4 = new androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3
            r0 = r4
            r1 = r20
            r19 = r31
            r2 = r21
            r12 = r4
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r10 = r30
            r0.<init>(r1, r2, r4, r5, r6, r7, r8, r9, r10)
            r0 = -459778869(0xffffffffe49854cb, float:-2.248012E22)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r11, r12)
            r7 = r0
            kotlin.jvm.functions.Function4 r7 = (kotlin.jvm.functions.Function4) r7
            int r0 = r19 >> 6
            r0 = r0 & 14
            r1 = 1597440(0x186000, float:2.23849E-39)
            r9 = r0 | r1
            r10 = 40
            r4 = 0
            java.lang.String r5 = "DatePickerDisplayModeAnimation"
            r6 = 0
            r1 = r16
            r2 = r17
            r3 = r18
            r8 = r13
            androidx.compose.animation.AnimatedContentKt.AnimatedContent(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a9:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 == 0) goto L_0x01d3
            androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$4 r16 = new androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$4
            r0 = r16
            r1 = r20
            r2 = r21
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r12 = r32
            r0.<init>(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x01d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.m1772SwitchableDateEntryContentd7iavvg(java.lang.Long, long, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.material3.CalendarModel, kotlin.ranges.IntRange, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v3, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x026e, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0273;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DatePickerContent(java.lang.Long r32, long r33, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r35, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r36, androidx.compose.material3.CalendarModel r37, kotlin.ranges.IntRange r38, androidx.compose.material3.DatePickerFormatter r39, androidx.compose.material3.SelectableDates r40, androidx.compose.material3.DatePickerColors r41, androidx.compose.runtime.Composer r42, int r43) {
        /*
            r11 = r33
            r13 = r37
            r14 = r38
            r15 = r39
            r10 = r41
            r9 = r43
            r0 = -434467002(0xffffffffe61a8f46, float:-1.8247184E23)
            r1 = r42
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DatePickerContent)P(7,3,4,5!1,8,2,6)1480@65783L87,1481@65896L24,1482@65950L42,1483@66017L15,1484@66037L4988:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r9 & 6
            r6 = r32
            if (r1 != 0) goto L_0x002b
            boolean r1 = r8.changed((java.lang.Object) r6)
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0028:
            r1 = 2
        L_0x0029:
            r1 = r1 | r9
            goto L_0x002c
        L_0x002b:
            r1 = r9
        L_0x002c:
            r2 = r9 & 48
            if (r2 != 0) goto L_0x003c
            boolean r2 = r8.changed((long) r11)
            if (r2 == 0) goto L_0x0039
            r2 = 32
            goto L_0x003b
        L_0x0039:
            r2 = 16
        L_0x003b:
            r1 = r1 | r2
        L_0x003c:
            r2 = r9 & 384(0x180, float:5.38E-43)
            r5 = r35
            if (r2 != 0) goto L_0x004e
            boolean r2 = r8.changedInstance(r5)
            if (r2 == 0) goto L_0x004b
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r2
        L_0x004e:
            r2 = r9 & 3072(0xc00, float:4.305E-42)
            r4 = r36
            if (r2 != 0) goto L_0x0060
            boolean r2 = r8.changedInstance(r4)
            if (r2 == 0) goto L_0x005d
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005f
        L_0x005d:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005f:
            r1 = r1 | r2
        L_0x0060:
            r2 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x0070
            boolean r2 = r8.changedInstance(r13)
            if (r2 == 0) goto L_0x006d
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006f
        L_0x006d:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006f:
            r1 = r1 | r2
        L_0x0070:
            r2 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 & r9
            if (r2 != 0) goto L_0x0081
            boolean r2 = r8.changedInstance(r14)
            if (r2 == 0) goto L_0x007e
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0080
        L_0x007e:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0080:
            r1 = r1 | r2
        L_0x0081:
            r2 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 & r9
            if (r2 != 0) goto L_0x009c
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r9
            if (r2 != 0) goto L_0x0090
            boolean r2 = r8.changed((java.lang.Object) r15)
            goto L_0x0094
        L_0x0090:
            boolean r2 = r8.changedInstance(r15)
        L_0x0094:
            if (r2 == 0) goto L_0x0099
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x009b
        L_0x0099:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x009b:
            r1 = r1 | r2
        L_0x009c:
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 & r9
            r3 = r40
            if (r2 != 0) goto L_0x00af
            boolean r2 = r8.changed((java.lang.Object) r3)
            if (r2 == 0) goto L_0x00ac
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ae
        L_0x00ac:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ae:
            r1 = r1 | r2
        L_0x00af:
            r2 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 & r9
            if (r2 != 0) goto L_0x00c0
            boolean r2 = r8.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x00bd
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00bf
        L_0x00bd:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00bf:
            r1 = r1 | r2
        L_0x00c0:
            r2 = r1
            r1 = 38347923(0x2492493, float:1.4777644E-37)
            r1 = r1 & r2
            r7 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r7) goto L_0x00d7
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L_0x00d1
            goto L_0x00d7
        L_0x00d1:
            r8.skipToGroupEnd()
            r15 = r8
            goto L_0x0576
        L_0x00d7:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00e3
            r1 = -1
            java.lang.String r7 = "androidx.compose.material3.DatePickerContent (DatePicker.kt:1477)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r7)
        L_0x00e3:
            androidx.compose.material3.CalendarMonth r0 = r13.getMonth((long) r11)
            int r1 = r0.indexIn(r14)
            r7 = 0
            r6 = 2
            androidx.compose.foundation.lazy.LazyListState r1 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r1, r7, r8, r7, r6)
            r6 = 773894976(0x2e20b340, float:3.6538994E-11)
            r8.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r6)
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r6)
            java.lang.Object r6 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r16.getEmpty()
            if (r6 != r7) goto L_0x0124
            kotlin.coroutines.EmptyCoroutineContext r6 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            kotlinx.coroutines.CoroutineScope r6 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r6, r8)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r7 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r7.<init>(r6)
            r8.updateRememberedValue(r7)
            r6 = r7
        L_0x0124:
            r8.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r6 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r6
            kotlinx.coroutines.CoroutineScope r7 = r6.getCoroutineScope()
            r8.endReplaceableGroup()
            r16 = r0
            r6 = 0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2 r17 = androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2.INSTANCE
            kotlin.jvm.functions.Function0 r17 = (kotlin.jvm.functions.Function0) r17
            r18 = 3072(0xc00, float:4.305E-42)
            r19 = 6
            r20 = 0
            r21 = 0
            r22 = r1
            r1 = r0
            r0 = r2
            r2 = r20
            r3 = r21
            r4 = r17
            r5 = r8
            r20 = r6
            r17 = 2
            r6 = r18
            r11 = r7
            r12 = r20
            r7 = r19
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            java.util.Locale r1 = androidx.compose.material3.ActualAndroid_androidKt.defaultLocale(r8, r12)
            r6 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r8.startReplaceableGroup(r6)
            java.lang.String r5 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r3 = r3.getTop()
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r4 = r4.getStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r3, r4, r8, r12)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r4)
            java.lang.String r14 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r14)
            int r17 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r12)
            androidx.compose.runtime.CompositionLocalMap r4 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r2)
            androidx.compose.runtime.Applier r12 = r8.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x01a9
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01a9:
            r8.startReusableNode()
            boolean r12 = r8.getInserting()
            if (r12 == 0) goto L_0x01b6
            r8.createNode(r6)
            goto L_0x01b9
        L_0x01b6:
            r8.useNode()
        L_0x01b9:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3282constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r3, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r6, r4, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r4 = r6.getInserting()
            if (r4 != 0) goto L_0x01e9
            java.lang.Object r4 = r6.rememberedValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r17)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r12)
            if (r4 != 0) goto L_0x01f7
        L_0x01e9:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            r6.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            r6.apply(r4, r3)
        L_0x01f7:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r3)
            r4 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r2.invoke(r3, r8, r6)
            r12 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r12)
            r6 = 276693656(0x107e0298, float:5.0094666E-29)
            java.lang.String r4 = "C79@3979L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r4)
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r2 = (androidx.compose.foundation.layout.ColumnScope) r2
            r2 = -269657363(0xffffffffefed5aed, float:-1.4691574E29)
            java.lang.String r3 = "C1494@66536L511,1506@67081L520,1518@67643L42,1485@66054L1670,1522@67734L3285:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = DatePickerHorizontalPadding
            r12 = 0
            r13 = 0
            r6 = 2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m672paddingVpY3zN4$default(r2, r3, r12, r6, r13)
            boolean r6 = r22.getCanScrollForward()
            boolean r23 = r22.getCanScrollBackward()
            boolean r24 = DatePickerContent$lambda$8(r7)
            java.lang.Long r12 = java.lang.Long.valueOf(r33)
            java.lang.String r1 = r15.formatMonthYear(r12, r1)
            if (r1 != 0) goto L_0x0246
            java.lang.String r1 = "-"
        L_0x0246:
            r12 = r1
            r1 = -269656881(0xffffffffefed5ccf, float:-1.4692029E29)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):DatePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            boolean r25 = r8.changedInstance(r11)
            r13 = r22
            boolean r22 = r8.changed((java.lang.Object) r13)
            r22 = r25 | r22
            r25 = r3
            java.lang.Object r3 = r8.rememberedValue()
            if (r22 != 0) goto L_0x0271
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r26 = r4
            java.lang.Object r4 = r22.getEmpty()
            if (r3 != r4) goto L_0x027d
            goto L_0x0273
        L_0x0271:
            r26 = r4
        L_0x0273:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1 r3 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1
            r3.<init>(r11, r13)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r8.updateRememberedValue(r3)
        L_0x027d:
            r22 = r3
            kotlin.jvm.functions.Function0 r22 = (kotlin.jvm.functions.Function0) r22
            r8.endReplaceableGroup()
            r3 = -269656336(0xffffffffefed5ef0, float:-1.4692544E29)
            r8.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            boolean r3 = r8.changedInstance(r11)
            boolean r4 = r8.changed((java.lang.Object) r13)
            r3 = r3 | r4
            java.lang.Object r4 = r8.rememberedValue()
            if (r3 != 0) goto L_0x02a4
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02af
        L_0x02a4:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1 r3 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1
            r3.<init>(r11, r13)
            r4 = r3
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r8.updateRememberedValue(r4)
        L_0x02af:
            r27 = r4
            kotlin.jvm.functions.Function0 r27 = (kotlin.jvm.functions.Function0) r27
            r8.endReplaceableGroup()
            r3 = -269655774(0xffffffffefed6122, float:-1.4693075E29)
            r8.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            boolean r1 = r8.changed((java.lang.Object) r7)
            java.lang.Object r3 = r8.rememberedValue()
            if (r1 != 0) goto L_0x02d1
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x02dc
        L_0x02d1:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$3$1 r1 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$3$1
            r1.<init>(r7)
            r3 = r1
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r8.updateRememberedValue(r3)
        L_0x02dc:
            r28 = r3
            kotlin.jvm.functions.Function0 r28 = (kotlin.jvm.functions.Function0) r28
            r8.endReplaceableGroup()
            r1 = 234881024(0xe000000, float:1.5777218E-30)
            r29 = r0 & r1
            r30 = r29 | 6
            r4 = r0
            r0 = r2
            r1 = r6
            r2 = r23
            r6 = r25
            r3 = r24
            r15 = r4
            r18 = r11
            r23 = r13
            r11 = r26
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4 = r12
            r12 = r5
            r5 = r22
            r31 = r6
            r6 = r27
            r20 = r7
            r7 = r28
            r21 = r8
            r8 = r41
            r9 = r21
            r10 = r30
            MonthsNavigation(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10 = r21
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r2 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r2, r10, r2)
            r10.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r2)
            androidx.compose.runtime.CompositionLocalMap r2 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r5 = r10.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x0352
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0352:
            r10.startReusableNode()
            boolean r5 = r10.getInserting()
            if (r5 == 0) goto L_0x035f
            r10.createNode(r4)
            goto L_0x0362
        L_0x035f:
            r10.useNode()
        L_0x0362:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3282constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r1, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r2, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r2 = r4.getInserting()
            if (r2 != 0) goto L_0x0392
            java.lang.Object r2 = r4.rememberedValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 != 0) goto L_0x03a0
        L_0x0392:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r4.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r4.apply(r2, r1)
        L_0x03a0:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r10, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r1 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 1767588144(0x695b4130, float:1.6566412E25)
            java.lang.String r1 = "C1523@67752L683,1537@68475L2534:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = r31
            r2 = 0
            r3 = 2
            r4 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m672paddingVpY3zN4$default(r0, r1, r2, r3, r4)
            r1 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r1 = r1.getTop()
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getStart()
            r3 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r1, r2, r10, r3)
            r10.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r6 = r10.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0414
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0414:
            r10.startReusableNode()
            boolean r6 = r10.getInserting()
            if (r6 == 0) goto L_0x0421
            r10.createNode(r5)
            goto L_0x0424
        L_0x0421:
            r10.useNode()
        L_0x0424:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3282constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r3 = r5.getInserting()
            if (r3 != 0) goto L_0x0454
            java.lang.Object r3 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 != 0) goto L_0x0462
        L_0x0454:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r5.updateRememberedValue(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.apply(r2, r1)
        L_0x0462:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r10, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r0)
            r0 = 276693656(0x107e0298, float:5.0094666E-29)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r11)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = 1247393713(0x4a59b7b1, float:3567084.2)
            java.lang.String r1 = "C1524@67848L31,1525@67896L525:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r1)
            int r0 = r15 >> 24
            r0 = r0 & 14
            int r1 = r15 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r11 = r37
            r12 = r41
            r13 = r4
            WeekDays(r12, r11, r10, r0)
            int r0 = r15 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r1 = r15 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r15 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r15
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r15
            r0 = r0 | r1
            r1 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r15
            r0 = r0 | r1
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r15
            r0 = r0 | r1
            r14 = r0 | r29
            r0 = r23
            r1 = r32
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            r7 = r40
            r8 = r41
            r9 = r10
            r15 = r10
            r10 = r14
            HorizontalMonthsList(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            boolean r14 = DatePickerContent$lambda$8(r20)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r17 = androidx.compose.ui.draw.ClipKt.clipToBounds(r0)
            r4 = 15
            r5 = 0
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            androidx.compose.animation.EnterTransition r0 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r0, r1, r2, r3, r4, r5)
            r1 = 1058642330(0x3f19999a, float:0.6)
            r10 = 1
            androidx.compose.animation.EnterTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r1, r10, r13)
            androidx.compose.animation.EnterTransition r19 = r0.plus(r1)
            r0 = 0
            r1 = 0
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r0, r1, r2, r3, r4, r5)
            r1 = 3
            r2 = 0
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r2, r1, r13)
            androidx.compose.animation.ExitTransition r13 = r0.plus(r1)
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2 r9 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2
            r0 = r9
            r1 = r33
            r3 = r20
            r4 = r18
            r5 = r23
            r6 = r38
            r7 = r16
            r8 = r40
            r11 = r9
            r9 = r37
            r12 = r10
            r10 = r41
            r0.<init>(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 1193716082(0x4726a972, float:42665.445)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r12, r11)
            r6 = r0
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            r8 = 200112(0x30db0, float:2.80417E-40)
            r9 = 16
            r5 = 0
            r1 = r14
            r2 = r17
            r3 = r19
            r4 = r13
            r7 = r15
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((boolean) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.animation.EnterTransition) r3, (androidx.compose.animation.ExitTransition) r4, (java.lang.String) r5, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0576
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0576:
            androidx.compose.runtime.ScopeUpdateScope r12 = r15.endRestartGroup()
            if (r12 == 0) goto L_0x059b
            androidx.compose.material3.DatePickerKt$DatePickerContent$2 r13 = new androidx.compose.material3.DatePickerKt$DatePickerContent$2
            r0 = r13
            r1 = r32
            r2 = r33
            r4 = r35
            r5 = r36
            r6 = r37
            r7 = r38
            r8 = r39
            r9 = r40
            r10 = r41
            r11 = r43
            r0.<init>(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x059b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.DatePickerContent(java.lang.Long, long, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.material3.CalendarModel, kotlin.ranges.IntRange, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$8(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void DatePickerContent$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: DatePickerHeader-pc5RIQQ  reason: not valid java name */
    public static final void m1768DatePickerHeaderpc5RIQQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        Modifier modifier3 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        float f2 = f;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-996037719);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerHeader)P(3,4,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.unit.Dp)1600@71484L740:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        } else {
            long j3 = j;
        }
        long j4 = j2;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 2048 : 1024;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-996037719, i2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1592)");
            }
            if (function23 != null) {
                modifier2 = SizeKt.m727defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, f2, 1, (Object) null);
            } else {
                modifier2 = Modifier.Companion;
            }
            Modifier then = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null).then(modifier2);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r12 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r12, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r12, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r12.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1127544336, "C1619@72104L114:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(1127544336);
            ComposerKt.sourceInformation(startRestartGroup, "1608@71722L10,1611@71841L244");
            if (function23 != null) {
                ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(j, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1936268514, true, new DatePickerKt$DatePickerHeader$1$1(function23)), startRestartGroup, ((i2 >> 6) & 14) | 384);
            }
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j2)), function24, startRestartGroup, ((i2 >> 12) & 112) | ProvidedValue.$stable);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$DatePickerHeader$2(modifier, function2, j, j2, f, function22, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void HorizontalMonthsList(LazyListState lazyListState, Long l, Function1<? super Long, Unit> function1, Function1<? super Long, Unit> function12, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composer2;
        LazyListState lazyListState2 = lazyListState;
        CalendarModel calendarModel2 = calendarModel;
        IntRange intRange2 = intRange;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1994757941);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalMonthsList)P(3,7,4,5!1,8,2,6)1642@72780L138,1649@72963L10,1648@72923L1690,1687@74649L228,1687@74619L258:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) lazyListState2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        Long l2 = l;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) l2) ? 32 : 16;
        }
        Function1<? super Long, Unit> function13 = function1;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function13) ? 256 : 128;
        }
        Function1<? super Long, Unit> function14 = function12;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function14) ? 2048 : 1024;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= (2097152 & i3) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 1048576 : 524288;
        }
        SelectableDates selectableDates2 = selectableDates;
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? 8388608 : 4194304;
        }
        DatePickerColors datePickerColors2 = datePickerColors;
        if ((100663296 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i4 = i2;
        if ((38347923 & i4) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994757941, i4, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1640)");
            }
            CalendarDate today = calendarModel.getToday();
            startRestartGroup.startReplaceableGroup(1346192500);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) intRange2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = calendarModel2.getMonth(intRange.getFirst(), 1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getDateLabelTextFont());
            DatePickerKt$HorizontalMonthsList$1 datePickerKt$HorizontalMonthsList$1 = r0;
            int i5 = i4;
            composer2 = startRestartGroup;
            DatePickerKt$HorizontalMonthsList$1 datePickerKt$HorizontalMonthsList$12 = new DatePickerKt$HorizontalMonthsList$1(lazyListState, intRange, calendarModel, (CalendarMonth) rememberedValue, function1, today, l, datePickerFormatter, selectableDates, datePickerColors);
            TextKt.ProvideTextStyle(fromToken, ComposableLambdaKt.composableLambda(composer2, 1504086906, true, datePickerKt$HorizontalMonthsList$1), composer2, 48);
            composer2.startReplaceableGroup(1346194369);
            ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
            int i6 = i5 & 14;
            boolean changedInstance = (i6 == 4) | ((i5 & 7168) == 2048) | composer2.changedInstance(calendarModel2) | composer2.changedInstance(intRange);
            Object rememberedValue2 = composer2.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new DatePickerKt$HorizontalMonthsList$2$1(lazyListState, function12, calendarModel, intRange, (Continuation<? super DatePickerKt$HorizontalMonthsList$2$1>) null);
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) lazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer2, i6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            LazyListState lazyListState3 = lazyListState2;
            IntRange intRange3 = intRange2;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$HorizontalMonthsList$3(lazyListState, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }

    public static final Object updateDisplayedMonth(LazyListState lazyListState, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new DatePickerKt$updateDisplayedMonth$2(lazyListState)).collect(new DatePickerKt$updateDisplayedMonth$3(lazyListState, function1, calendarModel, intRange), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static final void WeekDays(DatePickerColors datePickerColors, CalendarModel calendarModel, Composer composer, int i) {
        int i2;
        Composer composer2;
        DatePickerColors datePickerColors2 = datePickerColors;
        CalendarModel calendarModel2 = calendarModel;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1849465391);
        ComposerKt.sourceInformation(startRestartGroup, "C(WeekDays)P(1)1733@76133L10,1735@76204L990:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) datePickerColors2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, i2, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1721)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List<Pair<String, String>> weekdayNames = calendarModel.getWeekdayNames();
            ArrayList arrayList = new ArrayList();
            int i4 = firstDayOfWeek - 1;
            int size = weekdayNames.size();
            for (int i5 = i4; i5 < size; i5++) {
                arrayList.add(weekdayNames.get(i5));
            }
            boolean z = false;
            for (int i6 = 0; i6 < i4; i6++) {
                arrayList.add(weekdayNames.get(i6));
            }
            int i7 = 6;
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont());
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m727defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, RecommendedSizeForAccessibility, 1, (Object) null), 0.0f, 1, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), centerVertically, startRestartGroup, 54);
            int i8 = -1323940314;
            startRestartGroup.startReplaceableGroup(-1323940314);
            String str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
            ComposerKt.sourceInformation(startRestartGroup, str);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r9 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r9, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r9, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r9.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 289869412, "C:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(-971954356);
            ComposerKt.sourceInformation(startRestartGroup, "*1747@76615L33,1745@76532L646");
            List list = arrayList;
            int size2 = list.size();
            int i9 = 0;
            while (i9 < size2) {
                Pair pair = (Pair) list.get(i9);
                Modifier modifier = Modifier.Companion;
                startRestartGroup.startReplaceableGroup(784223355);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                boolean changed = startRestartGroup.changed((Object) pair);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DatePickerKt$WeekDays$1$1$1$1(pair);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) rememberedValue);
                float f = RecommendedSizeForAccessibility;
                Modifier r5 = SizeKt.m744sizeVpY3zN4(clearAndSetSemantics, f, f);
                Alignment center = Alignment.Companion.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, z, startRestartGroup, i7);
                startRestartGroup.startReplaceableGroup(i8);
                ComposerKt.sourceInformation(startRestartGroup, str);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, z ? 1 : 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(r5);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r13 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r13, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r13, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r13.getInserting() || !Intrinsics.areEqual(r13.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r13.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 178856377, "C1753@76900L264:DatePicker.kt#uh7d8r");
                Composer composer3 = startRestartGroup;
                TextKt.m2456Text4IGK_g((String) pair.getSecond(), SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null), datePickerColors.m1760getWeekdayContentColor0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m6453boximpl(TextAlign.Companion.m6460getCentere0LSkKk()), 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, fromToken, composer3, 48, 0, 65016);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                i9++;
                list = list;
                size2 = size2;
                str = str;
                i8 = -1323940314;
                z = false;
                i7 = 6;
                startRestartGroup = composer3;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceableGroup();
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
            endRestartGroup.updateScope(new DatePickerKt$WeekDays$2(datePickerColors2, calendarModel2, i3));
        }
    }

    public static final void Month(CalendarMonth calendarMonth, Function1<? super Long, Unit> function1, long j, Long l, Long l2, SelectedRangeInfo selectedRangeInfo, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composer2;
        Modifier modifier;
        String str;
        String str2;
        Locale locale;
        String str3;
        boolean z;
        int i3;
        int i4;
        Composer composer3;
        boolean z2;
        char c;
        boolean z3;
        boolean z4;
        long j2;
        Boolean bool;
        String str4;
        MutableState mutableState;
        boolean z5;
        Function1<? super Long, Unit> function12 = function1;
        long j3 = j;
        Long l3 = l;
        Long l4 = l2;
        SelectedRangeInfo selectedRangeInfo2 = selectedRangeInfo;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        SelectableDates selectableDates2 = selectableDates;
        DatePickerColors datePickerColors2 = datePickerColors;
        int i5 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1912870997);
        ComposerKt.sourceInformation(startRestartGroup, "C(Month)P(3,4,8,7,2,5,1,6)1790@77967L15,1792@78009L4836:DatePicker.kt#uh7d8r");
        CalendarMonth calendarMonth2 = calendarMonth;
        if ((i5 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) calendarMonth2) ? 4 : 2) | i5;
        } else {
            i2 = i5;
        }
        if ((i5 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) l3) ? 2048 : 1024;
        }
        if ((i5 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed((Object) l4) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i2 |= startRestartGroup.changed((Object) selectedRangeInfo2) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i2 |= (2097152 & i5) == 0 ? startRestartGroup.changed((Object) datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i2 |= startRestartGroup.changed((Object) selectableDates2) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i2;
        if ((38347923 & i6) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912870997, i6, -1, "androidx.compose.material3.Month (DatePicker.kt:1780)");
            }
            startRestartGroup.startReplaceableGroup(-2019459922);
            ComposerKt.sourceInformation(startRestartGroup, "1782@77774L131");
            String str5 = "CC(remember):DatePicker.kt#9igjgp";
            if (selectedRangeInfo2 != null) {
                Modifier modifier2 = Modifier.Companion;
                startRestartGroup.startReplaceableGroup(-2019459855);
                ComposerKt.sourceInformation(startRestartGroup, str5);
                boolean z6 = ((i6 & 458752) == 131072) | ((i6 & 234881024) == 67108864);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DatePickerKt$Month$rangeSelectionDrawModifier$1$1(selectedRangeInfo2, datePickerColors2);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                modifier = DrawModifierKt.drawWithContent(modifier2, (Function1) rememberedValue);
            } else {
                modifier = Modifier.Companion;
            }
            startRestartGroup.endReplaceableGroup();
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            Modifier then = SizeKt.m731requiredHeight3ABfNKs(Modifier.Companion, Dp.m6614constructorimpl(RecommendedSizeForAccessibility * ((float) 6))).then(modifier);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), Alignment.Companion.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            String str6 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
            ComposerKt.sourceInformation(startRestartGroup, str6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r1 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r1, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r1.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -713628571, "C:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(-2019459388);
            ComposerKt.sourceInformation(startRestartGroup, "*1799@78298L4531");
            int i7 = 0;
            int i8 = 0;
            int i9 = 6;
            while (i7 < i9) {
                int i10 = i7;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                startRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), centerVertically, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, str6);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                int i11 = i8;
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r2 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                boolean z7 = false;
                modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1111236200, "C:DatePicker.kt#uh7d8r");
                startRestartGroup.startReplaceableGroup(-713628297);
                String str7 = "";
                ComposerKt.sourceInformation(startRestartGroup, str7);
                int i12 = 0;
                int i13 = i11;
                while (i12 < 7) {
                    if (i13 < calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() || i13 >= calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth.getNumberOfDays()) {
                        SelectableDates selectableDates3 = selectableDates;
                        str3 = str7;
                        str2 = str5;
                        z = z7;
                        i4 = i6;
                        str = str6;
                        i3 = i13;
                        composer3 = startRestartGroup;
                        locale = defaultLocale;
                        composer3.startReplaceableGroup(-1111235936);
                        ComposerKt.sourceInformation(composer3, "1810@78843L271");
                        float f = RecommendedSizeForAccessibility;
                        SpacerKt.Spacer(SizeKt.m736requiredSizeVpY3zN4(Modifier.Companion, f, f), composer3, 6);
                        composer3.endReplaceableGroup();
                    } else {
                        startRestartGroup.startReplaceableGroup(-1111235573);
                        ComposerKt.sourceInformation(startRestartGroup, "1834@80231L341,1849@81021L39,1854@81396L518,1846@80852L1891");
                        int daysFromStartOfWeekToFirstOfMonth = i13 - calendarMonth.getDaysFromStartOfWeekToFirstOfMonth();
                        int i14 = i6;
                        long startUtcTimeMillis = calendarMonth.getStartUtcTimeMillis() + (((long) daysFromStartOfWeekToFirstOfMonth) * CalendarModelKt.MillisecondsIn24Hours);
                        boolean z8 = startUtcTimeMillis == j3;
                        boolean z9 = l3 != null && startUtcTimeMillis == l.longValue();
                        if (l4 != null && startUtcTimeMillis == l2.longValue()) {
                            str3 = str7;
                            z2 = true;
                        } else {
                            str3 = str7;
                            z2 = false;
                        }
                        startRestartGroup.startReplaceableGroup(-1111235085);
                        ComposerKt.sourceInformation(startRestartGroup, "1824@79692L387");
                        if (selectedRangeInfo2 != null) {
                            startRestartGroup.startReplaceableGroup(-1111235023);
                            ComposerKt.sourceInformation(startRestartGroup, str5);
                            boolean changed = ((i14 & 458752) == 131072) | startRestartGroup.changed(startUtcTimeMillis);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                if (startUtcTimeMillis >= (l3 != null ? l.longValue() : Long.MAX_VALUE)) {
                                    if (startUtcTimeMillis <= (l4 != null ? l2.longValue() : Long.MIN_VALUE)) {
                                        z5 = true;
                                        c = 2;
                                        mutableState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), (SnapshotMutationPolicy) null, 2, (Object) null);
                                        startRestartGroup.updateRememberedValue(mutableState);
                                    }
                                }
                                z5 = false;
                                c = 2;
                                mutableState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(mutableState);
                            } else {
                                mutableState = rememberedValue2;
                                c = 2;
                            }
                            startRestartGroup.endReplaceableGroup();
                            z3 = ((Boolean) mutableState.getValue()).booleanValue();
                        } else {
                            c = 2;
                            z3 = false;
                        }
                        startRestartGroup.endReplaceableGroup();
                        long j4 = startUtcTimeMillis;
                        z = false;
                        i4 = i14;
                        str = str6;
                        char c2 = c;
                        i3 = i13;
                        Locale locale2 = defaultLocale;
                        Composer composer4 = startRestartGroup;
                        String dayContentDescription = dayContentDescription(selectedRangeInfo2 != null, z8, z9, z2, z3, composer4, 0);
                        String formatDate = datePickerFormatter2.formatDate(Long.valueOf(j4), locale2, true);
                        if (formatDate == null) {
                            formatDate = str3;
                        }
                        Modifier modifier3 = Modifier.Companion;
                        boolean z10 = z9 || z2;
                        composer3 = composer4;
                        composer3.startReplaceableGroup(-1111233694);
                        ComposerKt.sourceInformation(composer3, str5);
                        locale = locale2;
                        if ((i4 & 112) == 32) {
                            j2 = j4;
                            z4 = true;
                        } else {
                            z4 = false;
                            j2 = j4;
                        }
                        boolean changed2 = z4 | composer3.changed(j2);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new DatePickerKt$Month$1$1$1$1(function1, j2);
                            composer3.updateRememberedValue(rememberedValue3);
                        } else {
                            Function1<? super Long, Unit> function13 = function1;
                        }
                        Function0 function0 = (Function0) rememberedValue3;
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(-1111233319);
                        ComposerKt.sourceInformation(composer3, str5);
                        boolean changed3 = composer3.changed(j2);
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            SelectableDates selectableDates4 = selectableDates;
                            bool = Boolean.valueOf(selectableDates4.isSelectableYear(calendarMonth.getYear()) && selectableDates4.isSelectableDate(j2));
                            composer3.updateRememberedValue(bool);
                        } else {
                            bool = rememberedValue4;
                            SelectableDates selectableDates5 = selectableDates;
                        }
                        boolean booleanValue = bool.booleanValue();
                        composer3.endReplaceableGroup();
                        if (dayContentDescription != null) {
                            str4 = dayContentDescription + ", " + formatDate;
                        } else {
                            str4 = formatDate;
                        }
                        str2 = str5;
                        Day(modifier3, z10, function0, z9, booleanValue, z8, z3, str4, datePickerColors, ComposableLambdaKt.composableLambda(composer3, -2095706591, true, new DatePickerKt$Month$1$1$3(daysFromStartOfWeekToFirstOfMonth)), composer3, 805306374 | (i4 & 234881024));
                        composer3.endReplaceableGroup();
                    }
                    i13 = i3 + 1;
                    i12++;
                    l3 = l;
                    l4 = l2;
                    selectedRangeInfo2 = selectedRangeInfo;
                    datePickerFormatter2 = datePickerFormatter;
                    startRestartGroup = composer3;
                    i6 = i4;
                    z7 = z;
                    str7 = str3;
                    defaultLocale = locale;
                    str5 = str2;
                    str6 = str;
                    j3 = j;
                }
                SelectableDates selectableDates6 = selectableDates;
                String str8 = str5;
                boolean z11 = z7;
                int i15 = i6;
                String str9 = str6;
                int i16 = i13;
                Composer composer5 = startRestartGroup;
                Locale locale3 = defaultLocale;
                composer5.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer5.endReplaceableGroup();
                composer5.endNode();
                composer5.endReplaceableGroup();
                composer5.endReplaceableGroup();
                Function1<? super Long, Unit> function14 = function1;
                l3 = l;
                l4 = l2;
                selectedRangeInfo2 = selectedRangeInfo;
                datePickerFormatter2 = datePickerFormatter;
                i9 = 6;
                i8 = i16;
                j3 = j;
                i7 = i10 + 1;
            }
            SelectableDates selectableDates7 = selectableDates;
            composer2 = startRestartGroup;
            composer2.endReplaceableGroup();
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
            SelectableDates selectableDates8 = selectableDates2;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$Month$2(calendarMonth, function1, j, l, l2, selectedRangeInfo, datePickerFormatter, selectableDates, datePickerColors, i));
        }
    }

    public static final int numberOfMonthsInRange(IntRange intRange) {
        return ((intRange.getLast() - intRange.getFirst()) + 1) * 12;
    }

    private static final String dayContentDescription(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i) {
        composer.startReplaceableGroup(502032503);
        ComposerKt.sourceInformation(composer, "C(dayContentDescription)P(4,3,2)1919@83871L54:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, i, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1900)");
        }
        StringBuilder sb = new StringBuilder();
        composer.startReplaceableGroup(-852185051);
        ComposerKt.sourceInformation(composer, "");
        if (z) {
            if (z3) {
                composer.startReplaceableGroup(-852184961);
                ComposerKt.sourceInformation(composer, "1905@83379L56");
                Strings.Companion companion = Strings.Companion;
                sb.append(Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_range_picker_start_headline), composer, 0));
                composer.endReplaceableGroup();
            } else if (z4) {
                composer.startReplaceableGroup(-852184821);
                ComposerKt.sourceInformation(composer, "1909@83519L54");
                Strings.Companion companion2 = Strings.Companion;
                sb.append(Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_range_picker_end_headline), composer, 0));
                composer.endReplaceableGroup();
            } else if (z5) {
                composer.startReplaceableGroup(-852184683);
                ComposerKt.sourceInformation(composer, "1913@83657L53");
                Strings.Companion companion3 = Strings.Companion;
                sb.append(Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_range_picker_day_in_range), composer, 0));
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-852184582);
                composer.endReplaceableGroup();
            }
        }
        composer.endReplaceableGroup();
        if (z2) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            Strings.Companion companion4 = Strings.Companion;
            sb.append(Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_picker_today_description), composer, 0));
        }
        String sb2 = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sb2;
    }

    /* access modifiers changed from: private */
    public static final void Day(Modifier modifier, boolean z, Function0<Unit> function0, boolean z2, boolean z3, boolean z4, boolean z5, String str, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer composer2;
        Modifier modifier2 = modifier;
        boolean z6 = z;
        boolean z7 = z4;
        String str2 = str;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1434777861);
        ComposerKt.sourceInformation(startRestartGroup, "C(Day)P(6,8,7!1,4,9,5,3)1945@84736L102,1950@84924L5,1951@84954L129,1956@85121L150,1938@84354L1463:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(z6) ? 32 : 16;
        }
        Function0<Unit> function02 = function0;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        boolean z8 = z2;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed(z8) ? 2048 : 1024;
        }
        boolean z9 = z3;
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed(z9) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(z7) ? 131072 : 65536;
        }
        boolean z10 = z5;
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed(z10) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) str2) ? 8388608 : 4194304;
        }
        DatePickerColors datePickerColors2 = datePickerColors;
        if ((100663296 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
        }
        int i4 = i2;
        if ((306783379 & i4) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1434777861, i4, -1, "androidx.compose.material3.Day (DatePicker.kt:1937)");
            }
            startRestartGroup.startReplaceableGroup(1664739143);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean z11 = (29360128 & i4) == 8388608;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DatePickerKt$Day$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier semantics = SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue);
            int i5 = i4 >> 3;
            int i6 = i4 >> 15;
            int i7 = i5;
            int i8 = i4;
            int i9 = i8 >> 12;
            composer2 = startRestartGroup;
            SurfaceKt.m2304Surfaced85dljk(z, function0, semantics, z3, ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getDateContainerShape(), startRestartGroup, 6), datePickerColors.dayContainerColor$material3_release(z, z3, z2, startRestartGroup, (i6 & 7168) | (i5 & 14) | ((i4 >> 9) & 112) | (i5 & 896)).getValue().m3826unboximpl(), datePickerColors.dayContentColor$material3_release(z4, z, z5, z3, startRestartGroup, (i6 & 14) | (i8 & 112) | (i9 & 896) | (i7 & 7168) | (i9 & 57344)).getValue().m3826unboximpl(), 0.0f, 0.0f, (!z7 || z6) ? null : BorderStrokeKt.m241BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m2790getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.m1759getTodayDateBorderColor0d7_KjU()), (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -2031780827, true, new DatePickerKt$Day$2(function22)), composer2, i7 & 7294, 48, 1408);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$Day$3(modifier, z, function0, z2, z3, z4, z5, str, datePickerColors, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void YearPicker(Modifier modifier, long j, Function1<? super Integer, Unit> function1, SelectableDates selectableDates, CalendarModel calendarModel, IntRange intRange, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1286899812);
        ComposerKt.sourceInformation(startRestartGroup, "C(YearPicker)P(3,2,4,5!1,6)1995@86176L10,1994@86128L4075:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        } else {
            long j2 = j;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        } else {
            Function1<? super Integer, Unit> function12 = function1;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) selectableDates) ? 2048 : 1024;
        } else {
            SelectableDates selectableDates2 = selectableDates;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        } else {
            CalendarModel calendarModel2 = calendarModel;
        }
        IntRange intRange2 = intRange;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange2) ? 131072 : 65536;
        }
        DatePickerColors datePickerColors2 = datePickerColors;
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 1048576 : 524288;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286899812, i2, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1993)");
            }
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1301915789, true, new DatePickerKt$YearPicker$1(calendarModel, j, intRange, datePickerColors, modifier, function1, selectableDates)), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$YearPicker$2(modifier, j, function1, selectableDates, calendarModel, intRange, datePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void Year(Modifier modifier, boolean z, boolean z2, Function0<Unit> function0, boolean z3, String str, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer composer2;
        BorderStroke borderStroke;
        Modifier modifier2 = modifier;
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        String str2 = str;
        DatePickerColors datePickerColors2 = datePickerColors;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(238547184);
        ComposerKt.sourceInformation(startRestartGroup, "C(Year)P(5,7,2,6,4,3)2086@90509L353,2103@91225L90,2108@91411L5,2109@91441L58,2110@91537L129,2097@90867L964:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        } else {
            Function0<Unit> function02 = function0;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) str2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(238547184, i2, -1, "androidx.compose.material3.Year (DatePicker.kt:2085)");
            }
            startRestartGroup.startReplaceableGroup(84263149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            int i4 = i2 & 112;
            boolean z7 = ((i2 & 896) == 256) | (i4 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue == Composer.Companion.getEmpty()) {
                if (!z5 || z4) {
                    borderStroke = null;
                } else {
                    borderStroke = BorderStrokeKt.m241BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m2790getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.m1759getTodayDateBorderColor0d7_KjU());
                }
                startRestartGroup.updateRememberedValue(borderStroke);
            } else {
                borderStroke = rememberedValue;
            }
            BorderStroke borderStroke2 = borderStroke;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(84263865);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean z8 = (458752 & i2) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new DatePickerKt$Year$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier semantics = SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue2);
            Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), startRestartGroup, 6);
            int i5 = i2 >> 3;
            int i6 = i5 & 14;
            int i7 = i2 >> 9;
            int i8 = i4;
            long r13 = datePickerColors2.yearContainerColor$material3_release(z4, z6, startRestartGroup, i6 | (i7 & 112) | ((i2 >> 12) & 896)).getValue().m3826unboximpl();
            int i9 = i2 >> 6;
            int i10 = i9;
            Composer composer3 = startRestartGroup;
            composer2 = composer3;
            SurfaceKt.m2304Surfaced85dljk(z, function0, semantics, z3, value, r13, datePickerColors.yearContentColor$material3_release(z2, z, z3, composer3, (i9 & 14) | i8 | (i9 & 896) | (i7 & 7168)).getValue().m3826unboximpl(), 0.0f, 0.0f, borderStroke2, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -1573188346, true, new DatePickerKt$Year$2(function22)), composer2, i6 | (i10 & 112) | (i5 & 7168), 48, 1408);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            Function2<? super Composer, ? super Integer, Unit> function23 = function22;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$Year$3(modifier, z, z2, function0, z3, str, datePickerColors, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void MonthsNavigation(Modifier modifier, boolean z, boolean z2, boolean z3, String str, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Arrangement.Horizontal horizontal;
        Modifier modifier2 = modifier;
        boolean z4 = z3;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-773929258);
        ComposerKt.sourceInformation(startRestartGroup, "C(MonthsNavigation)P(1,2,6,8,7,3,4,5)2140@92337L1934:DatePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        boolean z5 = z;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        boolean z6 = z2;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 2048 : 1024;
        }
        String str2 = str;
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed((Object) str2) ? 16384 : 8192;
        }
        Function0<Unit> function04 = function0;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function04) ? 131072 : 65536;
        }
        Function0<Unit> function05 = function02;
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function05) ? 1048576 : 524288;
        }
        Function0<Unit> function06 = function03;
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function06) ? 8388608 : 4194304;
        }
        DatePickerColors datePickerColors2 = datePickerColors;
        if ((100663296 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) datePickerColors2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773929258, i2, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2139)");
            }
            Modifier r0 = SizeKt.m731requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), MonthYearHeight);
            if (z4) {
                horizontal = Arrangement.INSTANCE.getStart();
            } else {
                horizontal = Arrangement.INSTANCE.getSpaceBetween();
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r0);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r3 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r3.getInserting() || !Intrinsics.areEqual(r3.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1911948306, "C2151@92667L1598:DatePicker.kt#uh7d8r");
            ProvidedValue<Color> provides = ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(datePickerColors.m1751getNavigationContentColor0d7_KjU()));
            DatePickerKt$MonthsNavigation$1$1 datePickerKt$MonthsNavigation$1$1 = r2;
            DatePickerKt$MonthsNavigation$1$1 datePickerKt$MonthsNavigation$1$12 = new DatePickerKt$MonthsNavigation$1$1(function03, z3, str, function02, z2, function0, z);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -962805198, true, datePickerKt$MonthsNavigation$1$1), startRestartGroup, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$MonthsNavigation$2(modifier, z, z2, z3, str, function0, function02, function03, datePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void YearPickerMenuButton(kotlin.jvm.functions.Function0<kotlin.Unit> r20, boolean r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r2 = r21
            r4 = r23
            r5 = r25
            r0 = 409654418(0x186ad492, float:3.0351112E-24)
            r1 = r24
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(YearPickerMenuButton)P(3,1,2)2198@94691L7,2198@94641L58,2194@94512L665:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r26 & 1
            if (r3 == 0) goto L_0x001e
            r3 = r5 | 6
            r6 = r3
            r3 = r20
            goto L_0x0032
        L_0x001e:
            r3 = r5 & 6
            if (r3 != 0) goto L_0x002f
            r3 = r20
            boolean r6 = r1.changedInstance(r3)
            if (r6 == 0) goto L_0x002c
            r6 = 4
            goto L_0x002d
        L_0x002c:
            r6 = 2
        L_0x002d:
            r6 = r6 | r5
            goto L_0x0032
        L_0x002f:
            r3 = r20
            r6 = r5
        L_0x0032:
            r7 = r26 & 2
            if (r7 == 0) goto L_0x0039
            r6 = r6 | 48
            goto L_0x0049
        L_0x0039:
            r7 = r5 & 48
            if (r7 != 0) goto L_0x0049
            boolean r7 = r1.changed((boolean) r2)
            if (r7 == 0) goto L_0x0046
            r7 = 32
            goto L_0x0048
        L_0x0046:
            r7 = 16
        L_0x0048:
            r6 = r6 | r7
        L_0x0049:
            r7 = r26 & 4
            if (r7 == 0) goto L_0x0050
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r8 = r5 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0063
            r8 = r22
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r6 = r6 | r9
            goto L_0x0065
        L_0x0063:
            r8 = r22
        L_0x0065:
            r9 = r26 & 8
            if (r9 == 0) goto L_0x006c
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x006c:
            r9 = r5 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007c
            boolean r9 = r1.changedInstance(r4)
            if (r9 == 0) goto L_0x0079
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r6 = r6 | r9
        L_0x007c:
            r15 = r6
            r6 = r15 & 1171(0x493, float:1.641E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r6 != r9) goto L_0x0091
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x008a
            goto L_0x0091
        L_0x008a:
            r1.skipToGroupEnd()
            r19 = r8
            goto L_0x0111
        L_0x0091:
            if (r7 == 0) goto L_0x009a
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r19 = r6
            goto L_0x009c
        L_0x009a:
            r19 = r8
        L_0x009c:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x00a8
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2193)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r6, r7)
        L_0x00a8:
            androidx.compose.foundation.shape.RoundedCornerShape r0 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            androidx.compose.material3.ButtonDefaults r6 = androidx.compose.material3.ButtonDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r9)
            java.lang.Object r7 = r1.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.graphics.Color r7 = (androidx.compose.ui.graphics.Color) r7
            long r9 = r7.m3826unboximpl()
            r16 = 24576(0x6000, float:3.4438E-41)
            r17 = 13
            r7 = 0
            r11 = 0
            r13 = 0
            r18 = r15
            r15 = r1
            androidx.compose.material3.ButtonColors r10 = r6.m1563textButtonColorsro_MJ88(r7, r9, r11, r13, r15, r16, r17)
            androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1 r6 = new androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1
            r6.<init>(r4, r2)
            r7 = 1899012021(0x71309fb5, float:8.74599E29)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r7, r8, r6)
            r15 = r6
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            r6 = r18 & 14
            r7 = 807075840(0x301b0000, float:5.638867E-10)
            r6 = r6 | r7
            int r7 = r18 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r17 = r6 | r7
            r18 = 388(0x184, float:5.44E-43)
            r8 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r6 = r20
            r7 = r19
            r9 = r0
            r16 = r1
            androidx.compose.material3.ButtonKt.TextButton(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0111
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0111:
            androidx.compose.runtime.ScopeUpdateScope r7 = r1.endRestartGroup()
            if (r7 == 0) goto L_0x012e
            androidx.compose.material3.DatePickerKt$YearPickerMenuButton$2 r8 = new androidx.compose.material3.DatePickerKt$YearPickerMenuButton$2
            r0 = r8
            r1 = r20
            r2 = r21
            r3 = r19
            r4 = r23
            r5 = r25
            r6 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.YearPickerMenuButton(kotlin.jvm.functions.Function0, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(LazyGridState lazyGridState, CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf(new CustomAccessibilityAction(str, new DatePickerKt$customScrollActions$scrollUpAction$1(lazyGridState, coroutineScope)), new CustomAccessibilityAction(str2, new DatePickerKt$customScrollActions$scrollDownAction$1(lazyGridState, coroutineScope)));
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    static {
        float f = (float) 12;
        DatePickerHorizontalPadding = Dp.m6614constructorimpl(f);
        DatePickerModeTogglePadding = PaddingKt.m667PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m6614constructorimpl(f), Dp.m6614constructorimpl(f), 3, (Object) null);
        float f2 = (float) 24;
        float f3 = (float) 16;
        DatePickerTitlePadding = PaddingKt.m667PaddingValuesa9UjIt4$default(Dp.m6614constructorimpl(f2), Dp.m6614constructorimpl(f3), Dp.m6614constructorimpl(f), 0.0f, 8, (Object) null);
        DatePickerHeadlinePadding = PaddingKt.m667PaddingValuesa9UjIt4$default(Dp.m6614constructorimpl(f2), 0.0f, Dp.m6614constructorimpl(f), Dp.m6614constructorimpl(f), 2, (Object) null);
        YearsVerticalPadding = Dp.m6614constructorimpl(f3);
    }
}
