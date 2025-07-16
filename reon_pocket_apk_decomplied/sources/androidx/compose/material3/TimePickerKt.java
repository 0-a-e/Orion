package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000²\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\u001a7\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00012\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00190\u001e¢\u0006\u0002\b\u001fH\u0003ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001d\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u0010+\u001a-\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u0010.\u001a\u0015\u0010/\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u00100\u001a\u001d\u00101\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u00104\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a=\u00106\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0003¢\u0006\u0002\u0010<\u001a)\u0010=\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010>\u001a%\u0010?\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010@\u001a8\u0010A\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010B\u001a\u00020CH\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001ab\u0010F\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00190I2\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a:\u0010R\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001aQ\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020:2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010%\u001a\u00020&2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00190I¢\u0006\u0002\b\u001f¢\u0006\u0002\bZH\u0003¢\u0006\u0002\u0010[\u001a\u001d\u0010\\\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010]\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u0010^\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a\u0018\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0002\u001a(\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007H\u0002\u001a*\u0010g\u001a\u00020h2\u0006\u0010J\u001a\u00020K2\u0006\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001a+\u0010m\u001a\u00020$2\b\b\u0002\u0010n\u001a\u00020\u00072\b\b\u0002\u0010o\u001a\u00020\u00072\b\b\u0002\u0010i\u001a\u00020*H\u0007¢\u0006\u0002\u0010p\u001a]\u0010q\u001a\u00020\u00192\u0006\u0010J\u001a\u00020K2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020G2\u0006\u0010r\u001a\u00020G2\u0006\u0010s\u001a\u00020\u00072!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bu\u0012\b\bv\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00190IH\u0002ø\u0001\u0000¢\u0006\u0004\bw\u0010x\u001a$\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0z2\u0006\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020\tH\u0002\u001a\u001c\u0010}\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002\u001a\u0014\u0010~\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010~\u001a\u00020*H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\r\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0016\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0017\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006²\u0006\u000b\u0010\u0001\u001a\u00020*X\u0002²\u0006\u000b\u0010\u0001\u001a\u00020GX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020GX\u0002²\u0006\f\u0010\u0001\u001a\u00030\u0001X\u0002"}, d2 = {"ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "ExtraHours", "", "", "FullCircle", "", "Hours", "InnerCircleRadius", "MaxDistance", "MinimumInteractiveSize", "Minutes", "OuterCircleSizeRadius", "PeriodToggleMargin", "QuarterCircle", "", "RadiansPerHour", "RadiansPerMinute", "SeparatorZIndex", "SupportLabelTop", "TimeInputBottomPadding", "CircularLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "radius", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ClockDisplayNumbers", "state", "Landroidx/compose/material3/TimePickerState;", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "autoSwitchToMinute", "", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockText", "value", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "HorizontalTimePicker", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "TimePicker", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePickerTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "selection", "Landroidx/compose/material3/Selection;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-lxUZ_iY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeSelector", "TimeSelector-uXwN82Y", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "VerticalPeriodToggle", "VerticalTimePicker", "atan", "y", "x", "dist", "x1", "y1", "x2", "y2", "numberContentDescription", "", "is24Hour", "number", "numberContentDescription-YKJpE6Y", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberTimePickerState", "initialHour", "initialMinute", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "timeInputOnChange", "prevValue", "max", "onNewValue", "Lkotlin/ParameterName;", "name", "timeInputOnChange-gIWD5Rc", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILkotlin/jvm/functions/Function1;)V", "valuesForAnimation", "Lkotlin/Pair;", "current", "new", "drawSelector", "visible", "material3_release", "touchExplorationServicesEnabled", "hourValue", "minuteValue", "center", "Landroidx/compose/ui/geometry/Offset;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class TimePickerKt {
    private static final float ClockDisplayBottomMargin = Dp.m6614constructorimpl((float) 36);
    private static final float ClockFaceBottomMargin;
    /* access modifiers changed from: private */
    public static final float DisplaySeparatorWidth;
    /* access modifiers changed from: private */
    public static final List<Integer> ExtraHours;
    private static final float FullCircle = 6.2831855f;
    /* access modifiers changed from: private */
    public static final List<Integer> Hours;
    /* access modifiers changed from: private */
    public static final float InnerCircleRadius = Dp.m6614constructorimpl((float) 69);
    /* access modifiers changed from: private */
    public static final float MaxDistance = Dp.m6614constructorimpl((float) 74);
    private static final float MinimumInteractiveSize = Dp.m6614constructorimpl((float) 48);
    /* access modifiers changed from: private */
    public static final List<Integer> Minutes = CollectionsKt.listOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);
    /* access modifiers changed from: private */
    public static final float OuterCircleSizeRadius = Dp.m6614constructorimpl((float) 101);
    private static final float PeriodToggleMargin = Dp.m6614constructorimpl((float) 12);
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float SupportLabelTop = Dp.m6614constructorimpl((float) 7);
    private static final float TimeInputBottomPadding;

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0090, code lost:
        if ((r14 & 8) != 0) goto L_0x00b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0115  */
    /* renamed from: TimePicker-mT9BvqQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2483TimePickermT9BvqQ(androidx.compose.material3.TimePickerState r8, androidx.compose.ui.Modifier r9, androidx.compose.material3.TimePickerColors r10, int r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = -619286452(0xffffffffdb16704c, float:-4.2344718E16)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(TimePicker)P(3,2!,1:c#material3.TimePickerLayoutType)205@10952L8,206@11020L12,208@11081L23:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r13 & 6
            if (r1 != 0) goto L_0x0022
            boolean r1 = r12.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r13
            goto L_0x0023
        L_0x0022:
            r1 = r13
        L_0x0023:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 48
            goto L_0x003a
        L_0x002a:
            r3 = r13 & 48
            if (r3 != 0) goto L_0x003a
            boolean r3 = r12.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r1 = r1 | r3
        L_0x003a:
            r3 = r13 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x004e
            r3 = r14 & 4
            if (r3 != 0) goto L_0x004b
            boolean r3 = r12.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x004b
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r3 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r3
        L_0x004e:
            r3 = r13 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0062
            r3 = r14 & 8
            if (r3 != 0) goto L_0x005f
            boolean r3 = r12.changed((int) r11)
            if (r3 == 0) goto L_0x005f
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0061
        L_0x005f:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0061:
            r1 = r1 | r3
        L_0x0062:
            r3 = r1 & 1171(0x493, float:1.641E-42)
            r4 = 1170(0x492, float:1.64E-42)
            if (r3 != r4) goto L_0x0077
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x006f
            goto L_0x0077
        L_0x006f:
            r12.skipToGroupEnd()
        L_0x0072:
            r3 = r9
            r4 = r10
            r5 = r11
            goto L_0x011a
        L_0x0077:
            r12.startDefaults()
            r3 = r13 & 1
            if (r3 == 0) goto L_0x0093
            boolean r3 = r12.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0085
            goto L_0x0093
        L_0x0085:
            r12.skipToGroupEnd()
            r2 = r14 & 4
            if (r2 == 0) goto L_0x008e
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x008e:
            r2 = r14 & 8
            if (r2 == 0) goto L_0x00b2
            goto L_0x00b0
        L_0x0093:
            if (r2 == 0) goto L_0x0099
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
        L_0x0099:
            r2 = r14 & 4
            r3 = 6
            if (r2 == 0) goto L_0x00a6
            androidx.compose.material3.TimePickerDefaults r10 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r10 = r10.colors(r12, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a6:
            r2 = r14 & 8
            if (r2 == 0) goto L_0x00b2
            androidx.compose.material3.TimePickerDefaults r11 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            int r11 = r11.m2481layoutTypesDNSZnc(r12, r3)
        L_0x00b0:
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00b2:
            r12.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00c1
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TimePicker (TimePicker.kt:207)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00c1:
            r0 = 0
            androidx.compose.runtime.State r0 = androidx.compose.material3.TouchExplorationStateProvider_androidKt.touchExplorationState(r12, r0)
            androidx.compose.material3.TimePickerLayoutType$Companion r2 = androidx.compose.material3.TimePickerLayoutType.Companion
            int r2 = r2.m2505getVerticalQJTpgSE()
            boolean r2 = androidx.compose.material3.TimePickerLayoutType.m2500equalsimpl0(r11, r2)
            if (r2 == 0) goto L_0x00f1
            r2 = 1318082425(0x4e905779, float:1.21082586E9)
            r12.startReplaceableGroup(r2)
            java.lang.String r2 = "211@11169L184"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            boolean r0 = TimePicker_mT9BvqQ$lambda$0(r0)
            r4 = r0 ^ 1
            r6 = r1 & 1022(0x3fe, float:1.432E-42)
            r7 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r12
            VerticalTimePicker(r1, r2, r3, r4, r5, r6, r7)
            r12.endReplaceableGroup()
            goto L_0x010f
        L_0x00f1:
            r2 = 1318082631(0x4e905847, float:1.21085222E9)
            r12.startReplaceableGroup(r2)
            java.lang.String r2 = "218@11375L186"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            boolean r0 = TimePicker_mT9BvqQ$lambda$0(r0)
            r4 = r0 ^ 1
            r6 = r1 & 1022(0x3fe, float:1.432E-42)
            r7 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r12
            HorizontalTimePicker(r1, r2, r3, r4, r5, r6, r7)
            r12.endReplaceableGroup()
        L_0x010f:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0072
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0072
        L_0x011a:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 == 0) goto L_0x012e
            androidx.compose.material3.TimePickerKt$TimePicker$1 r10 = new androidx.compose.material3.TimePickerKt$TimePicker$1
            r1 = r10
            r2 = r8
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2483TimePickermT9BvqQ(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0075, code lost:
        if ((r12 & 4) != 0) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TimeInput(androidx.compose.material3.TimePickerState r7, androidx.compose.ui.Modifier r8, androidx.compose.material3.TimePickerColors r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = -760850373(0xffffffffd2a6583b, float:-3.57222416E11)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r1 = "C(TimeInput)P(2,1)247@12451L8,249@12469L38:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r11 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r11 & 6
            if (r1 != 0) goto L_0x0022
            boolean r1 = r10.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r11
            goto L_0x0023
        L_0x0022:
            r1 = r11
        L_0x0023:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 48
            goto L_0x003a
        L_0x002a:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x003a
            boolean r3 = r10.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r1 = r1 | r3
        L_0x003a:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x004e
            r3 = r12 & 4
            if (r3 != 0) goto L_0x004b
            boolean r3 = r10.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x004b
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r3 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r3
        L_0x004e:
            r3 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r3 != r4) goto L_0x0061
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x005b
            goto L_0x0061
        L_0x005b:
            r10.skipToGroupEnd()
        L_0x005e:
            r3 = r8
            r4 = r9
            goto L_0x00ae
        L_0x0061:
            r10.startDefaults()
            r3 = r11 & 1
            r4 = 6
            if (r3 == 0) goto L_0x0078
            boolean r3 = r10.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0070
            goto L_0x0078
        L_0x0070:
            r10.skipToGroupEnd()
            r2 = r12 & 4
            if (r2 == 0) goto L_0x008a
            goto L_0x0088
        L_0x0078:
            if (r2 == 0) goto L_0x007e
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x007e:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x008a
            androidx.compose.material3.TimePickerDefaults r9 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r9 = r9.colors(r10, r4)
        L_0x0088:
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x008a:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0099
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TimeInput (TimePicker.kt:248)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x0099:
            int r0 = r1 >> 3
            r0 = r0 & 126(0x7e, float:1.77E-43)
            int r1 = r1 << r4
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            TimeInputImpl(r8, r9, r7, r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x005e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x005e
        L_0x00ae:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto L_0x00c2
            androidx.compose.material3.TimePickerKt$TimeInput$1 r9 = new androidx.compose.material3.TimePickerKt$TimeInput$1
            r1 = r9
            r2 = r7
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInput(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TimePickerState rememberTimePickerState(int i, int i2, boolean z, Composer composer, int i3, int i4) {
        Composer composer2 = composer;
        int i5 = i3;
        composer.startReplaceableGroup(1237715277);
        ComposerKt.sourceInformation(composer, "C(rememberTimePickerState)555@27815L14,558@27908L133,556@27852L189:TimePicker.kt#uh7d8r");
        boolean z2 = false;
        int i6 = (i4 & 1) != 0 ? 0 : i;
        int i7 = (i4 & 2) != 0 ? 0 : i2;
        boolean is24HourFormat = (i4 & 4) != 0 ? TimeFormat_androidKt.is24HourFormat(composer, 0) : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, i5, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:556)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerState, ?> Saver = TimePickerState.Companion.Saver();
        composer.startReplaceableGroup(1737740702);
        ComposerKt.sourceInformation(composer, "CC(remember):TimePicker.kt#9igjgp");
        boolean z3 = ((((i5 & 14) ^ 6) > 4 && composer.changed(i6)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(i7)) || (i5 & 48) == 32);
        if ((((i5 & 896) ^ 384) > 256 && composer.changed(is24HourFormat)) || (i5 & 384) == 256) {
            z2 = true;
        }
        boolean z4 = z3 | z2;
        Object rememberedValue = composer.rememberedValue();
        if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TimePickerKt$rememberTimePickerState$1$1(i6, i7, is24HourFormat);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TimePickerState timePickerState = (TimePickerState) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return timePickerState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008d, code lost:
        if ((r15 & 4) != 0) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void VerticalTimePicker(androidx.compose.material3.TimePickerState r9, androidx.compose.ui.Modifier r10, androidx.compose.material3.TimePickerColors r11, boolean r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            r0 = 310683247(0x1284a66f, float:8.3714E-28)
            androidx.compose.runtime.Composer r13 = r13.startRestartGroup(r0)
            java.lang.String r1 = "C(VerticalTimePicker)P(3,2,1)781@35339L8,784@35389L379:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r14 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r14 & 6
            if (r1 != 0) goto L_0x0022
            boolean r1 = r13.changed((java.lang.Object) r9)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r14
            goto L_0x0023
        L_0x0022:
            r1 = r14
        L_0x0023:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 48
            goto L_0x003a
        L_0x002a:
            r3 = r14 & 48
            if (r3 != 0) goto L_0x003a
            boolean r3 = r13.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r1 = r1 | r3
        L_0x003a:
            r3 = r14 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x004e
            r3 = r15 & 4
            if (r3 != 0) goto L_0x004b
            boolean r3 = r13.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x004b
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r3 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r3
        L_0x004e:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0055
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0065
        L_0x0055:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0065
            boolean r3 = r13.changed((boolean) r12)
            if (r3 == 0) goto L_0x0062
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r1 = r1 | r3
        L_0x0065:
            r3 = r1 & 1171(0x493, float:1.641E-42)
            r4 = 1170(0x492, float:1.64E-42)
            if (r3 != r4) goto L_0x0079
            boolean r3 = r13.getSkipping()
            if (r3 != 0) goto L_0x0072
            goto L_0x0079
        L_0x0072:
            r13.skipToGroupEnd()
        L_0x0075:
            r3 = r10
            r4 = r11
            goto L_0x01bf
        L_0x0079:
            r13.startDefaults()
            r3 = r14 & 1
            r4 = 6
            if (r3 == 0) goto L_0x0090
            boolean r3 = r13.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            r13.skipToGroupEnd()
            r2 = r15 & 4
            if (r2 == 0) goto L_0x00a2
            goto L_0x00a0
        L_0x0090:
            if (r2 == 0) goto L_0x0096
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
        L_0x0096:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x00a2
            androidx.compose.material3.TimePickerDefaults r11 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r11 = r11.colors(r13, r4)
        L_0x00a0:
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a2:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00b1
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:783)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00b1:
            androidx.compose.material3.TimePickerKt$VerticalTimePicker$1 r0 = androidx.compose.material3.TimePickerKt$VerticalTimePicker$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 0
            r3 = 0
            r5 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r10, r3, r0, r5, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getCenterHorizontally()
            r5 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r5 = r5.getTop()
            r6 = 48
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r5, r2, r13, r6)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r3)
            androidx.compose.runtime.CompositionLocalMap r6 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r8 = r13.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0101
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0101:
            r13.startReusableNode()
            boolean r8 = r13.getInserting()
            if (r8 == 0) goto L_0x010e
            r13.createNode(r7)
            goto L_0x0111
        L_0x010e:
            r13.useNode()
        L_0x0111:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3282constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r6 = r7.getInserting()
            if (r6 != 0) goto L_0x0141
            java.lang.Object r6 = r7.rememberedValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 != 0) goto L_0x014f
        L_0x0141:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r7.updateRememberedValue(r6)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.apply(r5, r2)
        L_0x014f:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.invoke(r2, r13, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r0 = 276693656(0x107e0298, float:5.0094666E-29)
            java.lang.String r2 = "C79@3979L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r2)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = 37442688(0x23b5480, float:1.376284E-37)
            java.lang.String r2 = "C788@35539L35,789@35583L60,790@35652L44,791@35705L57:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r2)
            r0 = r1 & 14
            int r1 = r1 >> 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            VerticalClockDisplay(r9, r11, r13, r0)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = ClockDisplayBottomMargin
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r2, r3)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r13, r4)
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            ClockFace(r9, r11, r12, r13, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r1 = ClockFaceBottomMargin
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r0, r1)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r13, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0075
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0075
        L_0x01bf:
            androidx.compose.runtime.ScopeUpdateScope r10 = r13.endRestartGroup()
            if (r10 == 0) goto L_0x01d4
            androidx.compose.material3.TimePickerKt$VerticalTimePicker$3 r11 = new androidx.compose.material3.TimePickerKt$VerticalTimePicker$3
            r1 = r11
            r2 = r9
            r5 = r12
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x01d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.VerticalTimePicker(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void HorizontalTimePicker(androidx.compose.material3.TimePickerState r18, androidx.compose.ui.Modifier r19, androidx.compose.material3.TimePickerColors r20, boolean r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r1 = r18
            r4 = r21
            r5 = r23
            r0 = 5079681(0x4d8281, float:7.118149E-39)
            r2 = r22
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(HorizontalTimePicker)P(3,2,1)799@35932L8,802@35982L309:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r24 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r5 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r5 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r5
            goto L_0x002b
        L_0x002a:
            r3 = r5
        L_0x002b:
            r6 = r24 & 2
            if (r6 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r5 & 48
            if (r7 != 0) goto L_0x0045
            r7 = r19
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r3 = r3 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r19
        L_0x0047:
            r8 = r5 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0060
            r8 = r24 & 4
            if (r8 != 0) goto L_0x005a
            r8 = r20
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005c
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r8 = r20
        L_0x005c:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r9
            goto L_0x0062
        L_0x0060:
            r8 = r20
        L_0x0062:
            r9 = r24 & 8
            if (r9 == 0) goto L_0x0069
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0069:
            r9 = r5 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0079
            boolean r9 = r2.changed((boolean) r4)
            if (r9 == 0) goto L_0x0076
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r9
        L_0x0079:
            r9 = r3 & 1171(0x493, float:1.641E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r9 != r10) goto L_0x008d
            boolean r9 = r2.getSkipping()
            if (r9 != 0) goto L_0x0086
            goto L_0x008d
        L_0x0086:
            r2.skipToGroupEnd()
            r6 = r7
        L_0x008a:
            r3 = r8
            goto L_0x01d0
        L_0x008d:
            r2.startDefaults()
            r9 = r5 & 1
            r10 = 6
            if (r9 == 0) goto L_0x00a7
            boolean r9 = r2.getDefaultsInvalid()
            if (r9 == 0) goto L_0x009c
            goto L_0x00a7
        L_0x009c:
            r2.skipToGroupEnd()
            r6 = r24 & 4
            if (r6 == 0) goto L_0x00a5
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a5:
            r6 = r7
            goto L_0x00bc
        L_0x00a7:
            if (r6 == 0) goto L_0x00ae
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x00af
        L_0x00ae:
            r6 = r7
        L_0x00af:
            r7 = r24 & 4
            if (r7 == 0) goto L_0x00bc
            androidx.compose.material3.TimePickerDefaults r7 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r7 = r7.colors(r2, r10)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r8 = r7
        L_0x00bc:
            r2.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00cb
            r7 = -1
            java.lang.String r9 = "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:801)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r7, r9)
        L_0x00cb:
            float r15 = ClockFaceBottomMargin
            r16 = 7
            r17 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r11 = r6
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m674paddingqDBjuR0$default(r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r7 = r7.getCenterVertically()
            r9 = 693286680(0x2952b718, float:4.6788176E-14)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r9 = r9.getStart()
            r11 = 48
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r9, r7, r2, r11)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            r9 = 0
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r9)
            androidx.compose.runtime.CompositionLocalMap r12 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r14 = r2.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x011f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x011f:
            r2.startReusableNode()
            boolean r14 = r2.getInserting()
            if (r14 == 0) goto L_0x012c
            r2.createNode(r13)
            goto L_0x012f
        L_0x012c:
            r2.useNode()
        L_0x012f:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r13, r7, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r13, r12, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            boolean r12 = r13.getInserting()
            if (r12 != 0) goto L_0x015f
            java.lang.Object r12 = r13.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 != 0) goto L_0x016d
        L_0x015f:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r13.updateRememberedValue(r12)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r13.apply(r11, r7)
        L_0x016d:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r7)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r0.invoke(r7, r2, r9)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            r0 = -326681643(0xffffffffec873bd5, float:-1.3079003E27)
            java.lang.String r7 = "C92@4661L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r7)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            r0 = -321629410(0xffffffffecd4531e, float:-2.0534783E27)
            java.lang.String r7 = "C806@36127L37,807@36173L59,808@36241L44:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r7)
            r0 = r3 & 14
            int r3 = r3 >> 3
            r7 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r7
            HorizontalClockDisplay(r1, r8, r2, r0)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            float r9 = ClockDisplayBottomMargin
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m747width3ABfNKs(r7, r9)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r7, r2, r10)
            r3 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            ClockFace(r1, r8, r4, r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x008a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x008a
        L_0x01d0:
            androidx.compose.runtime.ScopeUpdateScope r7 = r2.endRestartGroup()
            if (r7 == 0) goto L_0x01ea
            androidx.compose.material3.TimePickerKt$HorizontalTimePicker$2 r8 = new androidx.compose.material3.TimePickerKt$HorizontalTimePicker$2
            r0 = r8
            r1 = r18
            r2 = r6
            r4 = r21
            r5 = r23
            r6 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x01ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.HorizontalTimePicker(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TimeInputImpl(androidx.compose.ui.Modifier r51, androidx.compose.material3.TimePickerColors r52, androidx.compose.material3.TimePickerState r53, androidx.compose.runtime.Composer r54, int r55) {
        /*
            r7 = r51
            r8 = r52
            r9 = r53
            r10 = r55
            r0 = -475657989(0xffffffffe3a608fb, float:-6.125613E21)
            r1 = r54
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TimeInputImpl)P(1)818@36493L104,818@36441L156,821@36673L96,821@36621L148,825@36775L3592:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r10 & 6
            if (r1 != 0) goto L_0x0025
            boolean r1 = r6.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x0022
            r1 = 4
            goto L_0x0023
        L_0x0022:
            r1 = 2
        L_0x0023:
            r1 = r1 | r10
            goto L_0x0026
        L_0x0025:
            r1 = r10
        L_0x0026:
            r2 = r10 & 48
            if (r2 != 0) goto L_0x0036
            boolean r2 = r6.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0033
            r2 = 32
            goto L_0x0035
        L_0x0033:
            r2 = 16
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r10 & 384(0x180, float:5.38E-43)
            r3 = 256(0x100, float:3.59E-43)
            if (r2 != 0) goto L_0x0047
            boolean r2 = r6.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0044
            r2 = r3
            goto L_0x0046
        L_0x0044:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0046:
            r1 = r1 | r2
        L_0x0047:
            r5 = r1
            r1 = r5 & 147(0x93, float:2.06E-43)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 != r2) goto L_0x005b
            boolean r1 = r6.getSkipping()
            if (r1 != 0) goto L_0x0055
            goto L_0x005b
        L_0x0055:
            r6.skipToGroupEnd()
            r13 = r6
            goto L_0x0354
        L_0x005b:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0067
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.TimeInputImpl (TimePicker.kt:817)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r1, r2)
        L_0x0067:
            r4 = 0
            java.lang.Object[] r11 = new java.lang.Object[r4]
            androidx.compose.ui.text.input.TextFieldValue$Companion r0 = androidx.compose.ui.text.input.TextFieldValue.Companion
            androidx.compose.runtime.saveable.Saver r12 = r0.getSaver()
            r0 = 565122579(0x21af1613, float:1.1864304E-18)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r1 = r5 & 896(0x380, float:1.256E-42)
            r2 = 1
            if (r1 != r3) goto L_0x0082
            r13 = r2
            goto L_0x0083
        L_0x0082:
            r13 = r4
        L_0x0083:
            java.lang.Object r14 = r6.rememberedValue()
            if (r13 != 0) goto L_0x0091
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x009c
        L_0x0091:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1 r13 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1
            r13.<init>(r9)
            r14 = r13
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r6.updateRememberedValue(r14)
        L_0x009c:
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r6.endReplaceableGroup()
            r16 = 0
            r17 = 4
            r13 = 0
            r15 = r6
            androidx.compose.runtime.MutableState r15 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r11, r12, (java.lang.String) r13, r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17)
            java.lang.Object[] r11 = new java.lang.Object[r4]
            androidx.compose.ui.text.input.TextFieldValue$Companion r12 = androidx.compose.ui.text.input.TextFieldValue.Companion
            androidx.compose.runtime.saveable.Saver r12 = r12.getSaver()
            r13 = 565122759(0x21af16c7, float:1.186449E-18)
            r6.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            if (r1 != r3) goto L_0x00c0
            r0 = r2
            goto L_0x00c1
        L_0x00c0:
            r0 = r4
        L_0x00c1:
            java.lang.Object r1 = r6.rememberedValue()
            if (r0 != 0) goto L_0x00cf
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00da
        L_0x00cf:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1 r0 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1
            r0.<init>(r9)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r6.updateRememberedValue(r1)
        L_0x00da:
            r14 = r1
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r6.endReplaceableGroup()
            r16 = 0
            r17 = 4
            r13 = 0
            r3 = r15
            r15 = r6
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r11, r12, (java.lang.String) r13, r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17)
            float r12 = TimeInputBottomPadding
            r13 = 7
            r14 = 0
            r1 = 0
            r15 = 0
            r16 = 0
            r0 = r51
            r2 = r15
            r15 = r3
            r3 = r16
            r4 = r12
            r12 = r5
            r5 = r13
            r13 = r6
            r6 = r14
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m674paddingqDBjuR0$default(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r1 = r1.getTop()
            r2 = 693286680(0x2952b718, float:4.6788176E-14)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getStart()
            r3 = 48
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r2, r1, r13, r3)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r2)
            java.lang.String r4 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            r5 = 0
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r5)
            androidx.compose.runtime.CompositionLocalMap r14 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r2 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r3 = r13.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x0148
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0148:
            r13.startReusableNode()
            boolean r3 = r13.getInserting()
            if (r3 == 0) goto L_0x0155
            r13.createNode(r2)
            goto L_0x0158
        L_0x0155:
            r13.useNode()
        L_0x0158:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m3282constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r2, r1, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r2, r14, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r3 = r2.getInserting()
            if (r3 != 0) goto L_0x0188
            java.lang.Object r3 = r2.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r14)
            if (r3 != 0) goto L_0x0196
        L_0x0188:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r2.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r2.apply(r3, r1)
        L_0x0196:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r0.invoke(r1, r13, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r1 = -326681643(0xffffffffec873bd5, float:-1.3079003E27)
            java.lang.String r2 = "C92@4661L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r2)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r1 = -1230438189(0xffffffffb6a900d3, float:-5.0366884E-6)
            java.lang.String r2 = "C829@36938L10,835@37149L2787:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r2)
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material3.Typography r1 = r1.getTypography(r13, r2)
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r3.getTimeFieldLabelTextFont()
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.material3.TypographyKt.fromToken(r1, r3)
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r39 = r1.m6460getCentere0LSkKk()
            r1 = 1
            long r20 = r8.m2479timeSelectorContentColorvNxB06k$material3_release(r1)
            r49 = 16744446(0xff7ffe, float:2.3463966E-38)
            r50 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.ui.text.TextStyle.m6055copyp1EtxEg$default(r19, r20, r22, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r36, r37, r38, r39, r40, r41, r43, r44, r45, r46, r47, r48, r49, r50)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.ProvidedValue r3 = r6.provides(r3)
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1 r6 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1
            r6.<init>(r15, r9, r8, r11)
            r11 = 1306700887(0x4de2ac57, float:4.7536816E8)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r11, r1, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r6 = androidx.compose.runtime.ProvidedValue.$stable
            r11 = 48
            r6 = r6 | r11
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r13, (int) r6)
            r1 = 565126032(0x21af2390, float:1.1867875E-18)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "906@39981L370"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = r53.is24hour()
            if (r1 != 0) goto L_0x0336
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r14 = r1
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            float r15 = PeriodToggleMargin
            r19 = 14
            r20 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m674paddingqDBjuR0$default(r14, r15, r16, r17, r18, r19, r20)
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r5, r13, r5)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r5)
            androidx.compose.runtime.CompositionLocalMap r6 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            androidx.compose.runtime.Applier r14 = r13.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x028f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x028f:
            r13.startReusableNode()
            boolean r14 = r13.getInserting()
            if (r14 == 0) goto L_0x029c
            r13.createNode(r11)
            goto L_0x029f
        L_0x029c:
            r13.useNode()
        L_0x029f:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m3282constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r11, r3, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r11, r6, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r6 = r11.getInserting()
            if (r6 != 0) goto L_0x02cf
            java.lang.Object r6 = r11.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r4)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r14)
            if (r6 != 0) goto L_0x02dd
        L_0x02cf:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r11.updateRememberedValue(r6)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r11.apply(r4, r3)
        L_0x02dd:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r3)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r1.invoke(r3, r13, r4)
            r13.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r1 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1645130567(0xffffffff9df14cb9, float:-6.38715E-21)
            java.lang.String r1 = "C907@40049L288:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.tokens.TimeInputTokens r1 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r1 = r1.m3174getPeriodSelectorContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r3 = r3.m3173getPeriodSelectorContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m744sizeVpY3zN4(r0, r1, r3)
            int r1 = r12 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r12 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            VerticalPeriodToggle(r0, r9, r8, r13, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
        L_0x0336:
            r13.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0354
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0354:
            androidx.compose.runtime.ScopeUpdateScope r0 = r13.endRestartGroup()
            if (r0 == 0) goto L_0x0364
            androidx.compose.material3.TimePickerKt$TimeInputImpl$2 r1 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$2
            r1.<init>(r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x0364:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInputImpl(androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.material3.TimePickerState, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$5(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$8(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final void HorizontalClockDisplay(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        TimePickerState timePickerState2 = timePickerState;
        TimePickerColors timePickerColors2 = timePickerColors;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(755539561);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalClockDisplay)P(1)922@40474L554:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) timePickerState2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, i2, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:921)");
            }
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r13 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r13, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r13, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r13.getInserting() || !Intrinsics.areEqual(r13.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r13.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -385983589, "C923@40533L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState2, timePickerColors2, startRestartGroup, i2 & 126);
            startRestartGroup.startReplaceableGroup(-552392411);
            ComposerKt.sourceInformation(startRestartGroup, "925@40611L401");
            if (!timePickerState.is24hour()) {
                Modifier r6 = PaddingKt.m674paddingqDBjuR0$default(Modifier.Companion, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(r6);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r12 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r12, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r12, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r12.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 34973015, "C926@40688L310:TimePicker.kt#uh7d8r");
                int i4 = i2 << 3;
                HorizontalPeriodToggle(SizeKt.m744sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m3185getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3184getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState2, timePickerColors2, startRestartGroup, (i4 & 896) | (i4 & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
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
            endRestartGroup.updateScope(new TimePickerKt$HorizontalClockDisplay$2(timePickerState2, timePickerColors2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerticalClockDisplay(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        TimePickerState timePickerState2 = timePickerState;
        TimePickerColors timePickerColors2 = timePickerColors;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(2054675515);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalClockDisplay)P(1)941@41133L549:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) timePickerState2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, i2, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:940)");
            }
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getTop(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r13 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r13, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r13, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r13.getInserting() || !Intrinsics.areEqual(r13.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r13.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1085484635, "C942@41191L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState2, timePickerColors2, startRestartGroup, i2 & 126);
            startRestartGroup.startReplaceableGroup(952914149);
            ComposerKt.sourceInformation(startRestartGroup, "944@41269L397");
            if (!timePickerState.is24hour()) {
                Modifier r6 = PaddingKt.m674paddingqDBjuR0$default(Modifier.Companion, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(r6);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r12 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r12, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r12, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r12.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1130519783, "C945@41348L304:TimePicker.kt#uh7d8r");
                int i4 = i2 << 3;
                VerticalPeriodToggle(SizeKt.m744sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m3188getPeriodSelectorVerticalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3187getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState2, timePickerColors2, startRestartGroup, (i4 & 896) | (i4 & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
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
            endRestartGroup.updateScope(new TimePickerKt$VerticalClockDisplay$2(timePickerState2, timePickerColors2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void ClockDisplayNumbers(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockDisplayNumbers)P(1)964@41868L10,963@41796L1047:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, i2, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:962)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) TextKt.getLocalTextStyle().provides(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont())), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -477913269, true, new TimePickerKt$ClockDisplayNumbers$1(timePickerState, timePickerColors)), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ClockDisplayNumbers$2(timePickerState, timePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPeriodToggle)P(1,2)1003@43005L958,1030@44010L5,1032@44041L206:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, i2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1002)");
            }
            startRestartGroup.startReplaceableGroup(759555873);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TimePicker.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.INSTANCE;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), startRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            PeriodToggleImpl(modifier, timePickerState, timePickerColors, (MeasurePolicy) rememberedValue, ShapesKt.start(cornerBasedShape), ShapesKt.end(cornerBasedShape), startRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$HorizontalPeriodToggle$1(modifier, timePickerState, timePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerticalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalPeriodToggle)P(1,2)1048@44407L965,1075@45419L5,1077@45450L207:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, i2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1047)");
            }
            startRestartGroup.startReplaceableGroup(-2030104119);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TimePicker.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.INSTANCE;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), startRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            PeriodToggleImpl(modifier, timePickerState, timePickerColors, (MeasurePolicy) rememberedValue, ShapesKt.top(cornerBasedShape), ShapesKt.bottom(cornerBasedShape), startRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$VerticalPeriodToggle$1(modifier, timePickerState, timePickerColors, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PeriodToggleImpl(androidx.compose.ui.Modifier r25, androidx.compose.material3.TimePickerState r26, androidx.compose.material3.TimePickerColors r27, androidx.compose.ui.layout.MeasurePolicy r28, androidx.compose.ui.graphics.Shape r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.runtime.Composer r31, int r32) {
        /*
            r1 = r25
            r2 = r26
            r4 = r28
            r7 = r32
            r0 = 1374241901(0x51e9446d, float:1.25234422E11)
            r3 = r31
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r5 = "C(PeriodToggleImpl)P(3,5!1,2,4)1101@46050L5,1102@46105L41,1105@46210L116,1103@46151L1158:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r5)
            r5 = r7 & 6
            if (r5 != 0) goto L_0x0025
            boolean r5 = r3.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0022
            r5 = 4
            goto L_0x0023
        L_0x0022:
            r5 = 2
        L_0x0023:
            r5 = r5 | r7
            goto L_0x0026
        L_0x0025:
            r5 = r7
        L_0x0026:
            r6 = r7 & 48
            if (r6 != 0) goto L_0x0036
            boolean r6 = r3.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x0033
            r6 = 32
            goto L_0x0035
        L_0x0033:
            r6 = 16
        L_0x0035:
            r5 = r5 | r6
        L_0x0036:
            r6 = r7 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0049
            r6 = r27
            boolean r8 = r3.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0045
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0047
        L_0x0045:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0047:
            r5 = r5 | r8
            goto L_0x004b
        L_0x0049:
            r6 = r27
        L_0x004b:
            r8 = r7 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x005b
            boolean r8 = r3.changed((java.lang.Object) r4)
            if (r8 == 0) goto L_0x0058
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x005a
        L_0x0058:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x005a:
            r5 = r5 | r8
        L_0x005b:
            r8 = r7 & 24576(0x6000, float:3.4438E-41)
            r14 = r29
            if (r8 != 0) goto L_0x006d
            boolean r8 = r3.changed((java.lang.Object) r14)
            if (r8 == 0) goto L_0x006a
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006c
        L_0x006a:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x006c:
            r5 = r5 | r8
        L_0x006d:
            r8 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 & r7
            r13 = r30
            if (r8 != 0) goto L_0x0080
            boolean r8 = r3.changed((java.lang.Object) r13)
            if (r8 == 0) goto L_0x007d
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x007f
        L_0x007d:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x007f:
            r5 = r5 | r8
        L_0x0080:
            r8 = 74899(0x12493, float:1.04956E-40)
            r8 = r8 & r5
            r9 = 74898(0x12492, float:1.04954E-40)
            if (r8 != r9) goto L_0x0095
            boolean r8 = r3.getSkipping()
            if (r8 != 0) goto L_0x0090
            goto L_0x0095
        L_0x0090:
            r3.skipToGroupEnd()
            goto L_0x027f
        L_0x0095:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00a1
            r8 = -1
            java.lang.String r9 = "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1095)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r8, r9)
        L_0x00a1:
            androidx.compose.material3.tokens.TimePickerTokens r0 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            float r0 = r0.m3186getPeriodSelectorOutlineWidthD9Ej5fM()
            long r8 = r27.m2466getPeriodSelectorBorderColor0d7_KjU()
            androidx.compose.foundation.BorderStroke r0 = androidx.compose.foundation.BorderStrokeKt.m241BorderStrokecXLIe8U(r0, r8)
            androidx.compose.material3.tokens.TimePickerTokens r8 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r8 = r8.getPeriodSelectorContainerShape()
            r9 = 6
            androidx.compose.ui.graphics.Shape r8 = androidx.compose.material3.ShapesKt.getValue(r8, r3, r9)
            java.lang.String r9 = "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r9)
            androidx.compose.foundation.shape.CornerBasedShape r8 = (androidx.compose.foundation.shape.CornerBasedShape) r8
            androidx.compose.material3.Strings$Companion r9 = androidx.compose.material3.Strings.Companion
            int r9 = androidx.compose.material3.R.string.m3c_time_picker_period_toggle_description
            int r9 = androidx.compose.material3.Strings.m2224constructorimpl(r9)
            r12 = 0
            java.lang.String r9 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r9, r3, r12)
            r10 = -2008454294(0xffffffff88496b6a, float:-6.06125E-34)
            r3.startReplaceableGroup(r10)
            java.lang.String r11 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r11)
            boolean r10 = r3.changed((java.lang.Object) r9)
            java.lang.Object r15 = r3.rememberedValue()
            if (r10 != 0) goto L_0x00eb
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r15 != r10) goto L_0x00f6
        L_0x00eb:
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1 r10 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1
            r10.<init>(r9)
            r15 = r10
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r3.updateRememberedValue(r15)
        L_0x00f6:
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r3.endReplaceableGroup()
            r10 = 1
            r9 = 0
            androidx.compose.ui.Modifier r15 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r12, r15, r10, r9)
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r15)
            androidx.compose.ui.graphics.Shape r8 = (androidx.compose.ui.graphics.Shape) r8
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BorderKt.border(r15, r0, r8)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r8)
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r12)
            androidx.compose.runtime.CompositionLocalMap r15 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r10 = r3.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0133
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0133:
            r3.startReusableNode()
            boolean r10 = r3.getInserting()
            if (r10 == 0) goto L_0x0140
            r3.createNode(r9)
            goto L_0x0143
        L_0x0140:
            r3.useNode()
        L_0x0143:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m3282constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r9, r4, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r9, r15, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetCompositeKeyHash()
            boolean r15 = r9.getInserting()
            if (r15 != 0) goto L_0x0173
            java.lang.Object r15 = r9.rememberedValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r12)
            if (r12 != 0) goto L_0x0181
        L_0x0173:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)
            r9.updateRememberedValue(r12)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.apply(r8, r10)
        L_0x0181:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r8)
            r12 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r0.invoke(r8, r3, r9)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r0)
            r0 = 1654477473(0x629d52a1, float:1.4510464E21)
            java.lang.String r8 = "C1116@46614L35,1113@46488L267,1119@46768L240,1130@47160L34,1126@47021L272:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r8)
            boolean r0 = r26.isAfternoonToggle$material3_release()
            r10 = 1
            r8 = r0 ^ 1
            r0 = 1654477599(0x629d531f, float:1.4510642E21)
            r3.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r11)
            r0 = r5 & 112(0x70, float:1.57E-43)
            r9 = 32
            if (r0 != r9) goto L_0x01b7
            r9 = r10
            goto L_0x01b8
        L_0x01b7:
            r9 = r12
        L_0x01b8:
            java.lang.Object r15 = r3.rememberedValue()
            if (r9 != 0) goto L_0x01c6
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r15 != r9) goto L_0x01d1
        L_0x01c6:
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1 r9 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1
            r9.<init>(r2)
            r15 = r9
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r3.updateRememberedValue(r15)
        L_0x01d1:
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r3.endReplaceableGroup()
            androidx.compose.material3.ComposableSingletons$TimePickerKt r9 = androidx.compose.material3.ComposableSingletons$TimePickerKt.INSTANCE
            kotlin.jvm.functions.Function3 r16 = r9.m1731getLambda1$material3_release()
            int r9 = r5 >> 9
            r9 = r9 & 112(0x70, float:1.57E-43)
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            int r10 = r5 << 3
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r18 = r9 | r10
            r1 = 0
            r9 = r29
            r17 = r10
            r4 = 1
            r10 = r15
            r15 = r11
            r11 = r27
            r12 = r16
            r13 = r3
            r14 = r18
            ToggleItem(r8, r9, r10, r11, r12, r13, r14)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            java.lang.String r9 = "Spacer"
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r8, r9)
            r9 = 1073741824(0x40000000, float:2.0)
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.ZIndexModifierKt.zIndex(r8, r9)
            r9 = 0
            androidx.compose.ui.Modifier r19 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r8, r9, r4, r1)
            long r20 = r27.m2466getPeriodSelectorBorderColor0d7_KjU()
            r23 = 2
            r24 = 0
            r22 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m214backgroundbw27NRU$default(r19, r20, r22, r23, r24)
            r8 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r3, r8)
            boolean r1 = r26.isAfternoonToggle$material3_release()
            r9 = 1654478145(0x629d5541, float:1.451141E21)
            r3.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r15)
            r9 = 32
            if (r0 != r9) goto L_0x0234
            r12 = r4
            goto L_0x0235
        L_0x0234:
            r12 = r8
        L_0x0235:
            java.lang.Object r0 = r3.rememberedValue()
            if (r12 != 0) goto L_0x0243
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r0 != r4) goto L_0x024d
        L_0x0243:
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1 r0 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1
            r0.<init>(r2)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r3.updateRememberedValue(r0)
        L_0x024d:
            r10 = r0
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r3.endReplaceableGroup()
            androidx.compose.material3.ComposableSingletons$TimePickerKt r0 = androidx.compose.material3.ComposableSingletons$TimePickerKt.INSTANCE
            kotlin.jvm.functions.Function3 r12 = r0.m1732getLambda2$material3_release()
            int r0 = r5 >> 12
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r14 = r0 | r17
            r8 = r1
            r9 = r30
            r11 = r27
            r13 = r3
            ToggleItem(r8, r9, r10, r11, r12, r13, r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x027f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027f:
            androidx.compose.runtime.ScopeUpdateScope r8 = r3.endRestartGroup()
            if (r8 == 0) goto L_0x029e
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3 r9 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3
            r0 = r9
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r30
            r7 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x029e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.PeriodToggleImpl(androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerState, androidx.compose.material3.TimePickerColors, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.ui.graphics.Shape, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ToggleItem(boolean z, Shape shape, Function0<Unit> function0, TimePickerColors timePickerColors, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        int i2;
        boolean z2 = z;
        TimePickerColors timePickerColors2 = timePickerColors;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1937408098);
        ComposerKt.sourceInformation(startRestartGroup, "C(ToggleItem)P(!1,4,3)1152@47770L22,1157@47949L112,1148@47635L432:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed(z2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        Shape shape2 = shape;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) shape2) ? 32 : 16;
        }
        Function0<Unit> function02 = function0;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors2) ? 2048 : 1024;
        }
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
        }
        if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, i2, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1144)");
            }
            long r10 = timePickerColors2.m2477periodSelectorContentColorvNxB06k$material3_release(z2);
            long r8 = timePickerColors2.m2476periodSelectorContainerColorvNxB06k$material3_release(z2);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, z2 ? 0.0f : 1.0f), 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(526522672);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TimePicker.kt#9igjgp");
            boolean z3 = (i2 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TimePickerKt$ToggleItem$1$1(z2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(fillMaxSize$default, false, (Function1) rememberedValue, 1, (Object) null), false, shape, ButtonDefaults.INSTANCE.m1563textButtonColorsro_MJ88(r8, r10, 0, 0, startRestartGroup, CpioConstants.C_ISBLK, 12), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m663PaddingValues0680j_4(Dp.m6614constructorimpl((float) 0)), (MutableInteractionSource) null, function3, startRestartGroup, ((i2 >> 6) & 14) | 12582912 | ((i2 << 6) & 7168) | ((i2 << 15) & 1879048192), 356);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ToggleItem$2(z, shape, function0, timePickerColors, function3, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void DisplaySeparator(Modifier modifier, Composer composer, int i) {
        int i2;
        Composer composer2;
        Modifier modifier2 = modifier;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisplaySeparator)1166@48165L7,1174@48384L241:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i2, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1165)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int r36 = TextAlign.Companion.m6460getCentere0LSkKk();
            LineHeightStyle lineHeightStyle = r2;
            LineHeightStyle lineHeightStyle2 = new LineHeightStyle(LineHeightStyle.Alignment.Companion.m6437getCenterPIaL0Z0(), LineHeightStyle.Trim.Companion.m6449getBothEVpEnUU(), (DefaultConstructorMarker) null);
            TextStyle r23 = TextStyle.m6055copyp1EtxEg$default((TextStyle) consume, 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, r36, 0, 0, (TextIndent) null, (PlatformTextStyle) null, lineHeightStyle, 0, 0, (TextMotion) null, 15695871, (Object) null);
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier2, TimePickerKt$DisplaySeparator$1.INSTANCE);
            Alignment center = Alignment.Companion.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r8 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r8, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r8.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -617588430, "C1180@48577L5,1178@48503L116:TimePicker.kt#uh7d8r");
            composer2 = startRestartGroup;
            TextKt.m2456Text4IGK_g(":", (Modifier) null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), startRestartGroup, 6), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, r23, composer2, 6, 0, 65530);
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
            endRestartGroup.updateScope(new TimePickerKt$DisplaySeparator$3(modifier2, i3));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: TimeSelector-uXwN82Y  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2485TimeSelectoruXwN82Y(androidx.compose.ui.Modifier r31, int r32, androidx.compose.material3.TimePickerState r33, int r34, androidx.compose.material3.TimePickerColors r35, androidx.compose.runtime.Composer r36, int r37) {
        /*
            r1 = r31
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r37
            r0 = 21099367(0x141f367, float:3.5623134E-38)
            r2 = r36
            androidx.compose.runtime.Composer r14 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(TimeSelector)P(1,4,3,2:c#material3.Selection)1196@48920L176,1206@49248L24,1209@49362L124,1222@49791L5,1213@49506L211,1207@49277L1056:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r11 & 6
            if (r2 != 0) goto L_0x0027
            boolean r2 = r14.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0024
            r2 = 4
            goto L_0x0025
        L_0x0024:
            r2 = 2
        L_0x0025:
            r2 = r2 | r11
            goto L_0x0028
        L_0x0027:
            r2 = r11
        L_0x0028:
            r3 = r11 & 48
            r12 = r32
            if (r3 != 0) goto L_0x003a
            boolean r3 = r14.changed((int) r12)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r2 = r2 | r3
        L_0x003a:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x004a
            boolean r3 = r14.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0047
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0049
        L_0x0047:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0049:
            r2 = r2 | r3
        L_0x004a:
            r3 = r11 & 3072(0xc00, float:4.305E-42)
            r5 = 2048(0x800, float:2.87E-42)
            if (r3 != 0) goto L_0x005b
            boolean r3 = r14.changed((int) r9)
            if (r3 == 0) goto L_0x0058
            r3 = r5
            goto L_0x005a
        L_0x0058:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x005a:
            r2 = r2 | r3
        L_0x005b:
            r3 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x006b
            boolean r3 = r14.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0068
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006a
        L_0x0068:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x006a:
            r2 = r2 | r3
        L_0x006b:
            r3 = r2 & 9363(0x2493, float:1.312E-41)
            r6 = 9362(0x2492, float:1.3119E-41)
            if (r3 != r6) goto L_0x007e
            boolean r3 = r14.getSkipping()
            if (r3 != 0) goto L_0x0078
            goto L_0x007e
        L_0x0078:
            r14.skipToGroupEnd()
            r0 = r14
            goto L_0x01b7
        L_0x007e:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x008a
            r3 = -1
            java.lang.String r6 = "androidx.compose.material3.TimeSelector (TimePicker.kt:1194)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r6)
        L_0x008a:
            int r0 = r33.m2507getSelectionJiIwxys$material3_release()
            boolean r0 = androidx.compose.material3.Selection.m2164equalsimpl0(r0, r9)
            androidx.compose.material3.Selection$Companion r3 = androidx.compose.material3.Selection.Companion
            int r3 = r3.m2168getHourJiIwxys()
            boolean r3 = androidx.compose.material3.Selection.m2164equalsimpl0(r9, r3)
            if (r3 == 0) goto L_0x00a7
            androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
            int r3 = androidx.compose.material3.R.string.m3c_time_picker_hour_selection
            int r3 = androidx.compose.material3.Strings.m2224constructorimpl(r3)
            goto L_0x00af
        L_0x00a7:
            androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
            int r3 = androidx.compose.material3.R.string.m3c_time_picker_minute_selection
            int r3 = androidx.compose.material3.Strings.m2224constructorimpl(r3)
        L_0x00af:
            r6 = 0
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r3, r14, r6)
            long r17 = r10.m2478timeSelectorContainerColorvNxB06k$material3_release(r0)
            long r15 = r10.m2479timeSelectorContentColorvNxB06k$material3_release(r0)
            r7 = 773894976(0x2e20b340, float:3.6538994E-11)
            r14.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r7)
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r14.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r7)
            java.lang.Object r7 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r7 != r13) goto L_0x00ef
            kotlin.coroutines.EmptyCoroutineContext r7 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            kotlinx.coroutines.CoroutineScope r7 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r7, r14)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r13 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r13.<init>(r7)
            r14.updateRememberedValue(r13)
            r7 = r13
        L_0x00ef:
            r14.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r7 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r7
            kotlinx.coroutines.CoroutineScope r7 = r7.getCoroutineScope()
            r14.endReplaceableGroup()
            r13 = -633372797(0xffffffffda3f7f83, float:-1.34754803E16)
            r14.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r13)
            boolean r19 = r14.changed((java.lang.Object) r3)
            java.lang.Object r6 = r14.rememberedValue()
            if (r19 != 0) goto L_0x0118
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r19.getEmpty()
            if (r6 != r4) goto L_0x0123
        L_0x0118:
            androidx.compose.material3.TimePickerKt$TimeSelector$1$1 r4 = new androidx.compose.material3.TimePickerKt$TimeSelector$1$1
            r4.<init>(r3)
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r14.updateRememberedValue(r6)
        L_0x0123:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r14.endReplaceableGroup()
            r4 = 1
            androidx.compose.ui.Modifier r26 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r1, r4, r6)
            androidx.compose.material3.tokens.TimePickerTokens r3 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r3 = r3.getTimeSelectorContainerShape()
            r6 = 6
            androidx.compose.ui.graphics.Shape r30 = androidx.compose.material3.ShapesKt.getValue(r3, r14, r6)
            r3 = -633372653(0xffffffffda3f8013, float:-1.34756349E16)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r13)
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != r5) goto L_0x0147
            r3 = r4
            goto L_0x0148
        L_0x0147:
            r3 = 0
        L_0x0148:
            r2 = r2 & 896(0x380, float:1.256E-42)
            r5 = 256(0x100, float:3.59E-43)
            if (r2 != r5) goto L_0x0150
            r6 = r4
            goto L_0x0151
        L_0x0150:
            r6 = 0
        L_0x0151:
            r2 = r3 | r6
            boolean r3 = r14.changedInstance(r7)
            r2 = r2 | r3
            java.lang.Object r3 = r14.rememberedValue()
            if (r2 != 0) goto L_0x0166
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0171
        L_0x0166:
            androidx.compose.material3.TimePickerKt$TimeSelector$2$1 r2 = new androidx.compose.material3.TimePickerKt$TimeSelector$2$1
            r2.<init>(r9, r8, r7)
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r14.updateRememberedValue(r3)
        L_0x0171:
            r13 = r3
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r14.endReplaceableGroup()
            androidx.compose.material3.TimePickerKt$TimeSelector$3 r6 = new androidx.compose.material3.TimePickerKt$TimeSelector$3
            r2 = r6
            r3 = r34
            r7 = r4
            r4 = r33
            r5 = r32
            r1 = r6
            r8 = r7
            r6 = r15
            r2.<init>(r3, r4, r5, r6)
            r2 = -1338709103(0xffffffffb034eb91, float:-6.581838E-10)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r2, r8, r1)
            r25 = r1
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r28 = 48
            r29 = 1992(0x7c8, float:2.791E-42)
            r15 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r12 = r0
            r0 = r14
            r14 = r26
            r16 = r30
            r26 = r0
            androidx.compose.material3.SurfaceKt.m2304Surfaced85dljk((boolean) r12, (kotlin.jvm.functions.Function0<kotlin.Unit>) r13, (androidx.compose.ui.Modifier) r14, (boolean) r15, (androidx.compose.ui.graphics.Shape) r16, (long) r17, (long) r19, (float) r21, (float) r22, (androidx.compose.foundation.BorderStroke) r23, (androidx.compose.foundation.interaction.MutableInteractionSource) r24, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r25, (androidx.compose.runtime.Composer) r26, (int) r27, (int) r28, (int) r29)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01b7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b7:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 == 0) goto L_0x01d4
            androidx.compose.material3.TimePickerKt$TimeSelector$4 r8 = new androidx.compose.material3.TimePickerKt$TimeSelector$4
            r0 = r8
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x01d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2485TimeSelectoruXwN82Y(androidx.compose.ui.Modifier, int, androidx.compose.material3.TimePickerState, int, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    public static final void ClockFace(TimePickerState timePickerState, TimePickerColors timePickerColors, boolean z, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1525091100);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockFace)P(2,1)1340@53355L2455:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1525091100, i2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1339)");
            }
            CrossfadeKt.Crossfade(timePickerState.getValues$material3_release(), SemanticsModifierKt.semantics$default(SizeKt.m742size3ABfNKs(BackgroundKt.m213backgroundbw27NRU(Modifier.Companion, timePickerColors.m2462getClockDialColor0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), TimePickerTokens.INSTANCE.m3179getClockDialContainerSizeD9Ej5fM()), false, TimePickerKt$ClockFace$1.INSTANCE, 1, (Object) null), (FiniteAnimationSpec<Float>) AnimationSpecKt.tween$default(350, 0, (Easing) null, 6, (Object) null), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1628166511, true, new TimePickerKt$ClockFace$2(timePickerState, z, timePickerColors)), startRestartGroup, (int) CpioConstants.C_ISBLK, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ClockFace$3(timePickerState, timePickerColors, z, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Modifier drawSelector(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors) {
        return DrawModifierKt.drawWithContent(modifier, new TimePickerKt$drawSelector$1(timePickerState, timePickerColors));
    }

    /* access modifiers changed from: private */
    public static final void ClockText(Modifier modifier, TimePickerState timePickerState, int i, boolean z, Composer composer, int i2) {
        int i3;
        Composer composer2;
        boolean z2;
        int i4 = i;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-1420123631);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockText)P(1,2,3)1468@57704L10,*1469@57785L7,1470@57835L40,1471@57892L24,1473@57954L142,1491@58510L39,1493@58623L223,1486@58309L758:TimePicker.kt#uh7d8r");
        Modifier modifier2 = modifier;
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        TimePickerState timePickerState2 = timePickerState;
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) timePickerState2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changed(i4) ? 256 : 128;
        }
        boolean z3 = z;
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
        }
        int i6 = i3;
        if ((i6 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1420123631, i6, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1467)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TimePickerTokens.INSTANCE.getClockDialLabelTextFont());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r5 = ((Density) consume).m6550toPx0680j_4(MaxDistance);
            startRestartGroup.startReplaceableGroup(-1652988653);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TimePicker.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3551boximpl(Offset.Companion.m3578getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            String r13 = m2490numberContentDescriptionYKJpE6Y(timePickerState.m2507getSelectionJiIwxys$material3_release(), timePickerState.is24hour(), i4, startRestartGroup, i6 & 896);
            CoroutineScope coroutineScope2 = coroutineScope;
            MutableState mutableState2 = mutableState;
            String str = "CC(remember):TimePicker.kt#9igjgp";
            float f = r5;
            String localString$default = ActualJvm_jvmKt.toLocalString$default(i, 0, 0, false, 7, (Object) null);
            if (Selection.m2164equalsimpl0(timePickerState.m2507getSelectionJiIwxys$material3_release(), Selection.Companion.m2169getMinuteJiIwxys())) {
                z2 = Intrinsics.areEqual((Object) ActualJvm_jvmKt.toLocalString$default(timePickerState.getMinute(), 0, 0, false, 7, (Object) null), (Object) localString$default);
            } else {
                z2 = Intrinsics.areEqual((Object) ActualJvm_jvmKt.toLocalString$default(timePickerState.getHour(), 0, 0, false, 7, (Object) null), (Object) localString$default);
            }
            Alignment center = Alignment.Companion.getCenter();
            Modifier r3 = SizeKt.m742size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), MinimumInteractiveSize);
            startRestartGroup.startReplaceableGroup(-1652987978);
            String str2 = str;
            ComposerKt.sourceInformation(startRestartGroup, str2);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new TimePickerKt$ClockText$1$1(mutableState2);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier focusable$default = FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(r3, (Function1) rememberedValue3), false, (MutableInteractionSource) null, 3, (Object) null);
            startRestartGroup.startReplaceableGroup(-1652987865);
            ComposerKt.sourceInformation(startRestartGroup, str2);
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope2) | ((i6 & 112) == 32) | startRestartGroup.changed(f) | ((i6 & 7168) == 2048) | startRestartGroup.changed(z2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new TimePickerKt$ClockText$2$1(z2, coroutineScope2, timePickerState, f, z, mutableState2);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier semantics = SemanticsModifierKt.semantics(focusable$default, true, (Function1) rememberedValue4);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(semantics);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r6, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 859631416, "C1502@58922L76,1501@58863L198:TimePicker.kt#uh7d8r");
            Modifier modifier3 = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(859631475);
            ComposerKt.sourceInformation(startRestartGroup, str2);
            boolean changed = startRestartGroup.changed((Object) r13);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new TimePickerKt$ClockText$3$1$1(r13);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier3, (Function1) rememberedValue5);
            composer2 = startRestartGroup;
            TextKt.m2456Text4IGK_g(localString$default, clearAndSetSemantics, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, fromToken, composer2, 0, 0, 65532);
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
            endRestartGroup.updateScope(new TimePickerKt$ClockText$4(modifier, timePickerState, i, z, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final long ClockText$lambda$28(MutableState<Offset> mutableState) {
        return ((Offset) mutableState.getValue()).m3572unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void ClockText$lambda$29(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m3551boximpl(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: timeInputOnChange-gIWD5Rc  reason: not valid java name */
    public static final void m2491timeInputOnChangegIWD5Rc(int i, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, int i2, Function1<? super TextFieldValue, Unit> function1) {
        int i3;
        if (Intrinsics.areEqual((Object) textFieldValue.getText(), (Object) textFieldValue2.getText())) {
            function1.invoke(textFieldValue);
        } else if (textFieldValue.getText().length() == 0) {
            if (Selection.m2164equalsimpl0(i, Selection.Companion.m2168getHourJiIwxys())) {
                timePickerState.setHour$material3_release(0);
            } else {
                timePickerState.setMinute$material3_release(0);
            }
            function1.invoke(TextFieldValue.m6295copy3r_uNRQ$default(textFieldValue, "", 0, (TextRange) null, 6, (Object) null));
        } else {
            try {
                if (textFieldValue.getText().length() == 3 && TextRange.m6042getStartimpl(textFieldValue.m6299getSelectiond9O1mEE()) == 1) {
                    i3 = CharsKt.digitToInt(textFieldValue.getText().charAt(0));
                } else {
                    i3 = Integer.parseInt(textFieldValue.getText());
                }
                if (i3 <= i2) {
                    if (Selection.m2164equalsimpl0(i, Selection.Companion.m2168getHourJiIwxys())) {
                        timePickerState.setHour$material3_release(i3);
                        if (i3 > 1 && !timePickerState.is24hour()) {
                            timePickerState.m2510setSelectioniHAOin8$material3_release(Selection.Companion.m2169getMinuteJiIwxys());
                        }
                    } else {
                        timePickerState.setMinute$material3_release(i3);
                    }
                    if (textFieldValue.getText().length() > 2) {
                        textFieldValue = TextFieldValue.m6295copy3r_uNRQ$default(textFieldValue, String.valueOf(textFieldValue.getText().charAt(0)), 0, (TextRange) null, 6, (Object) null);
                    }
                    function1.invoke(textFieldValue);
                }
            } catch (IllegalArgumentException | NumberFormatException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0683  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0109  */
    /* renamed from: TimePickerTextField-lxUZ_iY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2484TimePickerTextFieldlxUZ_iY(androidx.compose.ui.Modifier r117, androidx.compose.ui.text.input.TextFieldValue r118, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r119, androidx.compose.material3.TimePickerState r120, int r121, androidx.compose.foundation.text.KeyboardOptions r122, androidx.compose.foundation.text.KeyboardActions r123, androidx.compose.material3.TimePickerColors r124, androidx.compose.runtime.Composer r125, int r126, int r127) {
        /*
            r13 = r118
            r7 = r120
            r12 = r121
            r11 = r124
            r10 = r126
            r9 = r127
            r0 = -367523658(0xffffffffea1808b6, float:-4.5949465E25)
            r1 = r125
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TimePickerTextField)P(3,7,4,6,5:c#material3.Selection,2,1)1574@60878L39,1575@60943L29,1576@61025L227,1582@61305L3266,1666@64609L103,1666@64577L135:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r9 & 1
            r108 = 4
            r109 = 2
            if (r1 == 0) goto L_0x0027
            r1 = r10 | 6
            r6 = r117
            goto L_0x003b
        L_0x0027:
            r1 = r10 & 6
            r6 = r117
            if (r1 != 0) goto L_0x003a
            boolean r1 = r8.changed((java.lang.Object) r6)
            if (r1 == 0) goto L_0x0036
            r1 = r108
            goto L_0x0038
        L_0x0036:
            r1 = r109
        L_0x0038:
            r1 = r1 | r10
            goto L_0x003b
        L_0x003a:
            r1 = r10
        L_0x003b:
            r2 = r9 & 2
            if (r2 == 0) goto L_0x0042
            r1 = r1 | 48
            goto L_0x0052
        L_0x0042:
            r2 = r10 & 48
            if (r2 != 0) goto L_0x0052
            boolean r2 = r8.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x004f
            r2 = 32
            goto L_0x0051
        L_0x004f:
            r2 = 16
        L_0x0051:
            r1 = r1 | r2
        L_0x0052:
            r2 = r9 & 4
            if (r2 == 0) goto L_0x005b
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r119
            goto L_0x006d
        L_0x005b:
            r2 = r10 & 384(0x180, float:5.38E-43)
            r5 = r119
            if (r2 != 0) goto L_0x006d
            boolean r2 = r8.changedInstance(r5)
            if (r2 == 0) goto L_0x006a
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r2 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r1 = r1 | r2
        L_0x006d:
            r2 = r9 & 8
            if (r2 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0074:
            r2 = r10 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0084
            boolean r2 = r8.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0081
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r2
        L_0x0084:
            r2 = r9 & 16
            if (r2 == 0) goto L_0x008b
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x008b:
            r2 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x009b
            boolean r2 = r8.changed((int) r12)
            if (r2 == 0) goto L_0x0098
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r1 = r1 | r2
        L_0x009b:
            r2 = r9 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r2 == 0) goto L_0x00a3
            r1 = r1 | r14
            goto L_0x00b5
        L_0x00a3:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b5
            r14 = r122
            boolean r15 = r8.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b1
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r1 = r1 | r15
            goto L_0x00b7
        L_0x00b5:
            r14 = r122
        L_0x00b7:
            r15 = r9 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c2
            r1 = r1 | r16
            r3 = r123
            goto L_0x00d5
        L_0x00c2:
            r16 = r10 & r16
            r3 = r123
            if (r16 != 0) goto L_0x00d5
            boolean r16 = r8.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x00d1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r1 = r1 | r16
        L_0x00d5:
            r4 = r9 & 128(0x80, float:1.794E-43)
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            if (r4 == 0) goto L_0x00de
            r1 = r1 | r16
            goto L_0x00ee
        L_0x00de:
            r4 = r10 & r16
            if (r4 != 0) goto L_0x00ee
            boolean r4 = r8.changed((java.lang.Object) r11)
            if (r4 == 0) goto L_0x00eb
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00eb:
            r4 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r1 = r1 | r4
        L_0x00ee:
            r4 = r1
            r1 = 4793491(0x492493, float:6.717112E-39)
            r1 = r1 & r4
            r0 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r0) goto L_0x0109
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x00ff
            goto L_0x0109
        L_0x00ff:
            r8.skipToGroupEnd()
            r4 = r7
            r0 = r12
            r6 = r14
            r7 = r3
            r3 = r8
            goto L_0x067d
        L_0x0109:
            if (r2 == 0) goto L_0x0114
            androidx.compose.foundation.text.KeyboardOptions$Companion r0 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r0 = r0.getDefault()
            r110 = r0
            goto L_0x0116
        L_0x0114:
            r110 = r14
        L_0x0116:
            if (r15 == 0) goto L_0x0121
            androidx.compose.foundation.text.KeyboardActions$Companion r0 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r0 = r0.getDefault()
            r111 = r0
            goto L_0x0123
        L_0x0121:
            r111 = r3
        L_0x0123:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0132
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1573)"
            r2 = -367523658(0xffffffffea1808b6, float:-4.5949465E25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r0, r1)
        L_0x0132:
            r0 = -525715937(0xffffffffe0aa361f, float:-9.81202E19)
            r8.startReplaceableGroup(r0)
            java.lang.String r3 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            java.lang.Object r0 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0150
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r8.updateRememberedValue(r0)
        L_0x0150:
            r2 = r0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r8.endReplaceableGroup()
            r0 = -525715872(0xffffffffe0aa3660, float:-9.812077E19)
            r8.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            java.lang.Object r0 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0173
            androidx.compose.ui.focus.FocusRequester r0 = new androidx.compose.ui.focus.FocusRequester
            r0.<init>()
            r8.updateRememberedValue(r0)
        L_0x0173:
            r1 = r0
            androidx.compose.ui.focus.FocusRequester r1 = (androidx.compose.ui.focus.FocusRequester) r1
            r8.endReplaceableGroup()
            androidx.compose.material3.OutlinedTextFieldDefaults r14 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r0 = 1
            long r23 = r11.m2478timeSelectorContainerColorvNxB06k$material3_release(r0)
            long r25 = r11.m2478timeSelectorContainerColorvNxB06k$material3_release(r0)
            long r15 = r11.m2479timeSelectorContentColorvNxB06k$material3_release(r0)
            r106 = 2147483598(0x7fffffce, float:NaN)
            r107 = 4095(0xfff, float:5.738E-42)
            r17 = 0
            r19 = 0
            r21 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r101 = 0
            r102 = 0
            r103 = 0
            r104 = 0
            r105 = 3072(0xc00, float:4.305E-42)
            r100 = r8
            androidx.compose.material3.TextFieldColors r15 = r14.m2040colors0hiis_0(r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r101, r102, r103, r104, r105, r106, r107)
            int r14 = r120.m2507getSelectionJiIwxys$material3_release()
            boolean r14 = androidx.compose.material3.Selection.m2164equalsimpl0(r12, r14)
            r0 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = r0.getTop()
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            r123 = r1
            androidx.compose.ui.Alignment$Horizontal r1 = r16.getStart()
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r0, r1, r8, r11)
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            int r1 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r11)
            androidx.compose.runtime.CompositionLocalMap r11 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r18 = r2
            kotlin.jvm.functions.Function0 r2 = r17.getConstructor()
            r17 = r3
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r117)
            androidx.compose.runtime.Applier r5 = r8.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x023f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x023f:
            r8.startReusableNode()
            boolean r5 = r8.getInserting()
            if (r5 == 0) goto L_0x024c
            r8.createNode(r2)
            goto L_0x024f
        L_0x024c:
            r8.useNode()
        L_0x024f:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m3282constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r2, r0, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r2, r11, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r5 = r2.getInserting()
            if (r5 != 0) goto L_0x027f
            java.lang.Object r5 = r2.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r11)
            if (r5 != 0) goto L_0x028d
        L_0x027f:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r2.updateRememberedValue(r5)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.apply(r1, r0)
        L_0x028d:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r0)
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r3.invoke(r0, r8, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r0)
            r0 = 276693656(0x107e0298, float:5.0094666E-29)
            java.lang.String r1 = "C79@3979L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = 896157841(0x356a4891, float:8.727739E-7)
            java.lang.String r1 = "C1593@61737L202,1601@61949L2039,1652@64142L206,1659@64415L5,1661@64473L10,1648@63998L567:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r0, r1)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "1584@61372L320"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r11 = 6
            if (r14 != 0) goto L_0x0316
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.tokens.TimeInputTokens r1 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r1 = r1.m3177getTimeFieldContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.TimeInputTokens r2 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r2 = r2.m3176getTimeFieldContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m744sizeVpY3zN4(r0, r1, r2)
            androidx.compose.material3.Selection$Companion r1 = androidx.compose.material3.Selection.Companion
            int r1 = r1.m2168getHourJiIwxys()
            boolean r1 = androidx.compose.material3.Selection.m2164equalsimpl0(r12, r1)
            if (r1 == 0) goto L_0x02e7
            int r1 = r120.getHourForDisplay$material3_release()
            goto L_0x02eb
        L_0x02e7:
            int r1 = r120.getMinute()
        L_0x02eb:
            int r2 = r4 >> 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r3 = r3 | r11
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r4 >> 9
            r5 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r5
            r19 = r2 | r3
            r5 = 1
            r3 = r123
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11 = r2
            r10 = r18
            r2 = r120
            r9 = r3
            r112 = r17
            r3 = r121
            r113 = r4
            r4 = r124
            r5 = r8
            r6 = r19
            m2485TimeSelectoruXwN82Y(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0321
        L_0x0316:
            r9 = r123
            r113 = r4
            r112 = r17
            r10 = r18
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
        L_0x0321:
            r8.endReplaceableGroup()
            androidx.compose.material3.Selection$Companion r0 = androidx.compose.material3.Selection.Companion
            int r0 = r0.m2169getMinuteJiIwxys()
            boolean r0 = androidx.compose.material3.Selection.m2164equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x0339
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_time_picker_minute_text_field
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            goto L_0x0341
        L_0x0339:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_time_picker_hour_text_field
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
        L_0x0341:
            r1 = 0
            java.lang.String r0 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r8, r1)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = visible(r2, r14)
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r8.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r1, r8, r1)
            r8.startReplaceableGroup(r11)
            java.lang.String r4 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r1)
            androidx.compose.runtime.CompositionLocalMap r1 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r2)
            androidx.compose.runtime.Applier r6 = r8.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0388
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0388:
            r8.startReusableNode()
            boolean r6 = r8.getInserting()
            if (r6 == 0) goto L_0x0395
            r8.createNode(r5)
            goto L_0x0398
        L_0x0395:
            r8.useNode()
        L_0x0398:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3282constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r3, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r1, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r3 = r5.getInserting()
            if (r3 != 0) goto L_0x03c8
            java.lang.Object r3 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 != 0) goto L_0x03d6
        L_0x03c8:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r5.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r5.apply(r3, r1)
        L_0x03d6:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.invoke(r1, r8, r4)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r1)
            r1 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r2 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = -1694928322(0xffffffff9af9723e, float:-1.03168554E-22)
            java.lang.String r2 = "C1608@62285L92,1614@62579L7,1620@62848L11,1621@62912L11,1602@61995L1983:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r2)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r1, r9)
            androidx.compose.material3.tokens.TimeInputTokens r2 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r2 = r2.m3177getTimeFieldContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r3 = r3.m3176getTimeFieldContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m744sizeVpY3zN4(r1, r2, r3)
            r2 = -1694928032(0xffffffff9af97360, float:-1.03170385E-22)
            r8.startReplaceableGroup(r2)
            r6 = r112
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r6)
            boolean r2 = r8.changed((java.lang.Object) r0)
            java.lang.Object r3 = r8.rememberedValue()
            if (r2 != 0) goto L_0x0435
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0440
        L_0x0435:
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1 r2 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
            r2.<init>(r0)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.updateRememberedValue(r3)
        L_0x0440:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.endReplaceableGroup()
            r0 = 0
            r2 = 0
            r11 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r2, r3, r11, r0)
            r2 = r1
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r4)
            java.lang.Object r1 = r8.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r5 = r1
            androidx.compose.ui.text.TextStyle r5 = (androidx.compose.ui.text.TextStyle) r5
            androidx.compose.ui.graphics.Brush$Companion r21 = androidx.compose.ui.graphics.Brush.Companion
            r1 = 6
            kotlin.Pair[] r3 = new kotlin.Pair[r1]
            r1 = 0
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r4.m3851getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3806boximpl(r16)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r4)
            r16 = 0
            r3[r16] = r1
            r1 = 1036831949(0x3dcccccd, float:0.1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r4.m3851getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3806boximpl(r17)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r4)
            r3[r11] = r1
            r1 = 1036831949(0x3dcccccd, float:0.1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.material3.MaterialTheme r4 = androidx.compose.material3.MaterialTheme.INSTANCE
            r14 = 6
            androidx.compose.material3.ColorScheme r4 = r4.getColorScheme(r8, r14)
            long r17 = r4.m1662getPrimary0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3806boximpl(r17)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r4)
            r3[r109] = r1
            r1 = 1063675494(0x3f666666, float:0.9)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.material3.MaterialTheme r4 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r4 = r4.getColorScheme(r8, r14)
            long r17 = r4.m1662getPrimary0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3806boximpl(r17)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r4)
            r4 = 3
            r3[r4] = r1
            r1 = 1063675494(0x3f666666, float:0.9)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r4.m3851getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3806boximpl(r17)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r4)
            r3[r108] = r1
            r1 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r4.m3851getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3806boximpl(r17)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r4)
            r4 = 5
            r3[r4] = r1
            r26 = 14
            r27 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r22 = r3
            androidx.compose.ui.graphics.Brush r1 = androidx.compose.ui.graphics.Brush.Companion.m3763verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r21, (kotlin.Pair[]) r22, (float) r23, (float) r24, (int) r25, (int) r26, (java.lang.Object) r27)
            r20 = r14
            r14 = r1
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2 r1 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
            r1.<init>(r13, r10, r15)
            r3 = 2133555260(0x7f2b783c, float:2.2792228E38)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r3, r11, r1)
            r15 = r1
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            r1 = r113
            int r3 = r1 >> 3
            r4 = r3 & 14
            r17 = 100666368(0x6000c00, float:2.408294E-35)
            r4 = r4 | r17
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            int r4 = r1 << 3
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r4 & r17
            r3 = r3 | r17
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r17
            r17 = r3 | r4
            r18 = 199680(0x30c00, float:2.79811E-40)
            r19 = 7696(0x1e10, float:1.0784E-41)
            r3 = 1
            r4 = 0
            r21 = 1
            r122 = r8
            r8 = r21
            r21 = 0
            r114 = r9
            r9 = r21
            r22 = r10
            r10 = r21
            r21 = 0
            r11 = r21
            r16 = 0
            r12 = r16
            r0 = r118
            r115 = r1
            r1 = r119
            r116 = r6
            r6 = r110
            r7 = r111
            r13 = r22
            r16 = r122
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r122)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r122)
            r122.endReplaceableGroup()
            r122.endNode()
            r122.endReplaceableGroup()
            r122.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 0
            float r2 = SupportLabelTop
            r14 = 0
            r15 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.OffsetKt.m629offsetVpY3zN4$default(r0, r1, r2, r15, r14)
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2 r1 = androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r0, r1)
            androidx.compose.material3.Selection$Companion r0 = androidx.compose.material3.Selection.Companion
            int r0 = r0.m2168getHourJiIwxys()
            r13 = r121
            boolean r0 = androidx.compose.material3.Selection.m2164equalsimpl0(r13, r0)
            if (r0 == 0) goto L_0x05ac
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_time_picker_hour
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
            goto L_0x05b4
        L_0x05ac:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = androidx.compose.material3.R.string.m3c_time_picker_minute
            int r0 = androidx.compose.material3.Strings.m2224constructorimpl(r0)
        L_0x05b4:
            r12 = r122
            r10 = 0
            java.lang.String r1 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r0, r12, r10)
            androidx.compose.material3.tokens.TimeInputTokens r0 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getTimeFieldSupportingTextColor()
            r5 = 6
            long r3 = androidx.compose.material3.ColorSchemeKt.getValue(r0, r12, r5)
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r0 = r0.getTypography(r12, r5)
            androidx.compose.material3.tokens.TimeInputTokens r5 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r5.getTimeFieldSupportingTextFont()
            androidx.compose.ui.text.TextStyle r21 = androidx.compose.material3.TypographyKt.fromToken(r0, r5)
            r24 = 0
            r25 = 65528(0xfff8, float:9.1824E-41)
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r16 = 0
            r0 = r10
            r10 = r16
            r16 = 0
            r122 = r12
            r12 = r16
            r0 = r13
            r13 = r16
            r16 = 0
            r26 = r15
            r14 = r16
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r23 = 0
            r22 = r122
            androidx.compose.material3.TextKt.m2456Text4IGK_g((java.lang.String) r1, (androidx.compose.ui.Modifier) r2, (long) r3, (long) r5, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontWeight) r8, (androidx.compose.ui.text.font.FontFamily) r9, (long) r10, (androidx.compose.ui.text.style.TextDecoration) r12, (androidx.compose.ui.text.style.TextAlign) r13, (long) r14, (int) r16, (boolean) r17, (int) r18, (int) r19, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r20, (androidx.compose.ui.text.TextStyle) r21, (androidx.compose.runtime.Composer) r22, (int) r23, (int) r24, (int) r25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r122)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r122)
            r122.endReplaceableGroup()
            r122.endNode()
            r122.endReplaceableGroup()
            r122.endReplaceableGroup()
            int r1 = r120.m2507getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection r1 = androidx.compose.material3.Selection.m2161boximpl(r1)
            r2 = -525712206(0xffffffffe0aa44b2, float:-9.815302E19)
            r3 = r122
            r3.startReplaceableGroup(r2)
            r2 = r116
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r2)
            r2 = r115
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 != r5) goto L_0x0637
            r4 = r26
            goto L_0x0638
        L_0x0637:
            r4 = 0
        L_0x0638:
            r5 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r5
            r5 = 16384(0x4000, float:2.2959E-41)
            if (r2 != r5) goto L_0x0641
            goto L_0x0643
        L_0x0641:
            r26 = 0
        L_0x0643:
            r2 = r4 | r26
            java.lang.Object r4 = r3.rememberedValue()
            if (r2 != 0) goto L_0x0658
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x0654
            goto L_0x0658
        L_0x0654:
            r2 = r4
            r4 = r120
            goto L_0x0667
        L_0x0658:
            androidx.compose.material3.TimePickerKt$TimePickerTextField$2$1 r2 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$2$1
            r4 = r120
            r5 = r114
            r6 = 0
            r2.<init>(r4, r0, r5, r6)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3.updateRememberedValue(r2)
        L_0x0667:
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3.endReplaceableGroup()
            r5 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2, (androidx.compose.runtime.Composer) r3, (int) r5)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0679
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0679:
            r6 = r110
            r7 = r111
        L_0x067d:
            androidx.compose.runtime.ScopeUpdateScope r11 = r3.endRestartGroup()
            if (r11 == 0) goto L_0x069e
            androidx.compose.material3.TimePickerKt$TimePickerTextField$3 r12 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$3
            r0 = r12
            r1 = r117
            r2 = r118
            r3 = r119
            r4 = r120
            r5 = r121
            r8 = r124
            r9 = r126
            r10 = r127
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x069e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2484TimePickerTextFieldlxUZ_iY(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularLayout-uFdPcIQ  reason: not valid java name */
    public static final void m2482CircularLayoutuFdPcIQ(Modifier modifier, float f, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1548175696);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularLayout)P(1,2:c#ui.unit.Dp)1682@64971L1642,1680@64910L1703:TimePicker.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, i3, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1679)");
            }
            startRestartGroup.startReplaceableGroup(1651957759);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TimePicker.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TimePickerKt$CircularLayout$1$1(f);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            int i5 = ((i3 >> 6) & 14) | ((i3 << 3) & 112);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int i6 = ((i5 << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r5 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r5, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i6 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$CircularLayout$2(modifier2, f, function2, i, i2));
        }
    }

    /* renamed from: numberContentDescription-YKJpE6Y  reason: not valid java name */
    public static final String m2490numberContentDescriptionYKJpE6Y(int i, boolean z, int i2, Composer composer, int i3) {
        int i4;
        ComposerKt.sourceInformationMarkerStart(composer, 1826155772, "C(numberContentDescription)P(2:c#material3.Selection)1733@66988L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1826155772, i3, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1724)");
        }
        if (Selection.m2164equalsimpl0(i, Selection.Companion.m2169getMinuteJiIwxys())) {
            Strings.Companion companion = Strings.Companion;
            i4 = Strings.m2224constructorimpl(R.string.m3c_time_picker_minute_suffix);
        } else if (z) {
            Strings.Companion companion2 = Strings.Companion;
            i4 = Strings.m2224constructorimpl(R.string.m3c_time_picker_hour_24h_suffix);
        } else {
            Strings.Companion companion3 = Strings.Companion;
            i4 = Strings.m2224constructorimpl(R.string.m3c_time_picker_hour_suffix);
        }
        String r3 = Strings_androidKt.m2294getStringiSCLEhQ(i4, new Object[]{Integer.valueOf(i2)}, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r3;
    }

    /* access modifiers changed from: private */
    public static final Pair<Float, Float> valuesForAnimation(float f, float f2) {
        if (((double) Math.abs(f - f2)) <= 3.141592653589793d) {
            return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
        }
        double d = (double) f;
        if (d > 3.141592653589793d && ((double) f2) < 3.141592653589793d) {
            f2 += FullCircle;
        } else if (d < 3.141592653589793d && ((double) f2) > 3.141592653589793d) {
            f += FullCircle;
        }
        return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
    }

    /* access modifiers changed from: private */
    public static final float dist(float f, float f2, int i, int i2) {
        return (float) Math.hypot((double) (((float) i) - f), (double) (((float) i2) - f2));
    }

    /* access modifiers changed from: private */
    public static final float atan(float f, float f2) {
        float atan2 = ((float) Math.atan2((double) f, (double) f2)) - 1.5707964f;
        return atan2 < 0.0f ? atan2 + FullCircle : atan2;
    }

    private static final Modifier visible(Modifier modifier, boolean z) {
        return modifier.then(new VisibleModifier(z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TimePickerKt$visible$$inlined$debugInspectorInfo$1(z) : InspectableValueKt.getNoInspectorInfo()));
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void TimeInputImpl$lambda$6(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* access modifiers changed from: private */
    public static final void TimeInputImpl$lambda$9(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    static {
        float f = (float) 24;
        ClockFaceBottomMargin = Dp.m6614constructorimpl(f);
        DisplaySeparatorWidth = Dp.m6614constructorimpl(f);
        TimeInputBottomPadding = Dp.m6614constructorimpl(f);
        List<Integer> listOf = CollectionsKt.listOf(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Hours = listOf;
        ArrayList arrayList = new ArrayList(listOf.size());
        int size = listOf.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf((listOf.get(i).intValue() % 12) + 12));
        }
        ExtraHours = arrayList;
    }
}
