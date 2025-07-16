package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010.\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001a\u0002\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010#\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\u0010>\u001ar\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001aj\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a&\u0010W\u001a\u00020\r*\u00020\r2\u0006\u0010X\u001a\u0002092\u0006\u0010<\u001a\u00020=H\u0000ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a\u0001\u0010[\u001a\u00020\u0007*\u00020\\2\u0006\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020%2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010`2\b\u0010b\u001a\u0004\u0018\u00010`2\b\u0010c\u001a\u0004\u0018\u00010`2\u0006\u0010d\u001a\u00020`2\b\u0010e\u001a\u0004\u0018\u00010`2\b\u0010f\u001a\u0004\u0018\u00010`2\u0006\u0010g\u001a\u00020`2\b\u0010h\u001a\u0004\u0018\u00010`2\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010J\u001a\u0002072\u0006\u0010i\u001a\u00020j2\u0006\u0010<\u001a\u00020=H\u0002\u001a\u0014\u0010k\u001a\u00020%*\u00020%2\u0006\u0010l\u001a\u00020%H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006m"}, d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-DHJA7U0", "(IIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "substractConstraintSafely", "from", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
public final class OutlinedTextFieldKt {
    /* access modifiers changed from: private */
    public static final float OutlinedTextFieldInnerPadding = Dp.m6614constructorimpl((float) 4);
    private static final float OutlinedTextFieldTopPadding = Dp.m6614constructorimpl((float) 8);

    /* access modifiers changed from: private */
    public static final int substractConstraintSafely(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : i - i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x05e9  */
    /* JADX WARNING: Removed duplicated region for block: B:355:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextField(java.lang.String r80, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r81, androidx.compose.ui.Modifier r82, boolean r83, boolean r84, androidx.compose.ui.text.TextStyle r85, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r87, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r92, boolean r93, androidx.compose.ui.text.input.VisualTransformation r94, androidx.compose.foundation.text.KeyboardOptions r95, androidx.compose.foundation.text.KeyboardActions r96, boolean r97, int r98, int r99, androidx.compose.foundation.interaction.MutableInteractionSource r100, androidx.compose.ui.graphics.Shape r101, androidx.compose.material3.TextFieldColors r102, androidx.compose.runtime.Composer r103, int r104, int r105, int r106, int r107) {
        /*
            r15 = r104
            r14 = r105
            r13 = r106
            r12 = r107
            r0 = -1922450045(0xffffffff8d69bd83, float:-7.2026785E-31)
            r1 = r103
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)147@8277L7,162@9029L39,163@9115L5,164@9178L8,172@9540L15,172@9474L2524:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0020
            r1 = r15 | 6
            r4 = r1
            r1 = r80
            goto L_0x0034
        L_0x0020:
            r1 = r15 & 6
            if (r1 != 0) goto L_0x0031
            r1 = r80
            boolean r4 = r0.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x002e
            r4 = 4
            goto L_0x002f
        L_0x002e:
            r4 = 2
        L_0x002f:
            r4 = r4 | r15
            goto L_0x0034
        L_0x0031:
            r1 = r80
            r4 = r15
        L_0x0034:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x003b
            r4 = r4 | 48
            goto L_0x004e
        L_0x003b:
            r5 = r15 & 48
            if (r5 != 0) goto L_0x004e
            r5 = r81
            boolean r8 = r0.changedInstance(r5)
            if (r8 == 0) goto L_0x004a
            r8 = 32
            goto L_0x004c
        L_0x004a:
            r8 = 16
        L_0x004c:
            r4 = r4 | r8
            goto L_0x0050
        L_0x004e:
            r5 = r81
        L_0x0050:
            r8 = r12 & 4
            if (r8 == 0) goto L_0x0057
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0057:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x006b
            r11 = r82
            boolean r16 = r0.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x0066
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r4 = r4 | r16
            goto L_0x006d
        L_0x006b:
            r11 = r82
        L_0x006d:
            r16 = r12 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0078
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0078:
            r2 = r15 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x008c
            r2 = r83
            boolean r19 = r0.changed((boolean) r2)
            if (r19 == 0) goto L_0x0087
            r19 = r17
            goto L_0x0089
        L_0x0087:
            r19 = r18
        L_0x0089:
            r4 = r4 | r19
            goto L_0x008e
        L_0x008c:
            r2 = r83
        L_0x008e:
            r19 = r12 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0099
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ad
        L_0x0099:
            r3 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x00ad
            r3 = r84
            boolean r23 = r0.changed((boolean) r3)
            if (r23 == 0) goto L_0x00a8
            r23 = r20
            goto L_0x00aa
        L_0x00a8:
            r23 = r21
        L_0x00aa:
            r4 = r4 | r23
            goto L_0x00af
        L_0x00ad:
            r3 = r84
        L_0x00af:
            r23 = 196608(0x30000, float:2.75506E-40)
            r24 = r15 & r23
            if (r24 != 0) goto L_0x00c9
            r24 = r12 & 32
            r6 = r85
            if (r24 != 0) goto L_0x00c4
            boolean r25 = r0.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00c4
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c4:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r4 = r4 | r25
            goto L_0x00cb
        L_0x00c9:
            r6 = r85
        L_0x00cb:
            r25 = r12 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00d6
            r4 = r4 | r26
            r7 = r86
            goto L_0x00e9
        L_0x00d6:
            r27 = r15 & r26
            r7 = r86
            if (r27 != 0) goto L_0x00e9
            boolean r28 = r0.changedInstance(r7)
            if (r28 == 0) goto L_0x00e5
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r4 = r4 | r28
        L_0x00e9:
            r9 = r12 & 128(0x80, float:1.794E-43)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r30 = 4194304(0x400000, float:5.877472E-39)
            if (r9 == 0) goto L_0x00f6
            r4 = r4 | r29
            r10 = r87
            goto L_0x0109
        L_0x00f6:
            r31 = r15 & r29
            r10 = r87
            if (r31 != 0) goto L_0x0109
            boolean r32 = r0.changedInstance(r10)
            if (r32 == 0) goto L_0x0105
            r32 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r32 = r30
        L_0x0107:
            r4 = r4 | r32
        L_0x0109:
            r1 = r12 & 256(0x100, float:3.59E-43)
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x0114
            r4 = r4 | r32
            r2 = r88
            goto L_0x0127
        L_0x0114:
            r32 = r15 & r32
            r2 = r88
            if (r32 != 0) goto L_0x0127
            boolean r32 = r0.changedInstance(r2)
            if (r32 == 0) goto L_0x0123
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r4 = r4 | r32
        L_0x0127:
            r2 = r12 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0132
            r4 = r4 | r32
            r3 = r89
            goto L_0x0145
        L_0x0132:
            r33 = r15 & r32
            r3 = r89
            if (r33 != 0) goto L_0x0145
            boolean r33 = r0.changedInstance(r3)
            if (r33 == 0) goto L_0x0141
            r33 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0143
        L_0x0141:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0143:
            r4 = r4 | r33
        L_0x0145:
            r3 = r12 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x014e
            r33 = r14 | 6
            r5 = r90
            goto L_0x0164
        L_0x014e:
            r33 = r14 & 6
            r5 = r90
            if (r33 != 0) goto L_0x0162
            boolean r33 = r0.changedInstance(r5)
            if (r33 == 0) goto L_0x015d
            r33 = 4
            goto L_0x015f
        L_0x015d:
            r33 = 2
        L_0x015f:
            r33 = r14 | r33
            goto L_0x0164
        L_0x0162:
            r33 = r14
        L_0x0164:
            r5 = r12 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x016b
            r33 = r33 | 48
            goto L_0x017e
        L_0x016b:
            r34 = r14 & 48
            r6 = r91
            if (r34 != 0) goto L_0x017e
            boolean r34 = r0.changedInstance(r6)
            if (r34 == 0) goto L_0x017a
            r34 = 32
            goto L_0x017c
        L_0x017a:
            r34 = 16
        L_0x017c:
            r33 = r33 | r34
        L_0x017e:
            r6 = r33
            r7 = r12 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0187
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x019b
        L_0x0187:
            r10 = r14 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x019b
            r10 = r92
            boolean r33 = r0.changedInstance(r10)
            if (r33 == 0) goto L_0x0196
            r33 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r33 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r6 = r6 | r33
            goto L_0x019d
        L_0x019b:
            r10 = r92
        L_0x019d:
            r10 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01a4
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b6
        L_0x01a4:
            r11 = r14 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x01b6
            r11 = r93
            boolean r33 = r0.changed((boolean) r11)
            if (r33 == 0) goto L_0x01b1
            goto L_0x01b3
        L_0x01b1:
            r17 = r18
        L_0x01b3:
            r6 = r6 | r17
            goto L_0x01b8
        L_0x01b6:
            r11 = r93
        L_0x01b8:
            r11 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c1
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r17 = r11
            goto L_0x01d5
        L_0x01c1:
            r17 = r11
            r11 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01d5
            r11 = r94
            boolean r18 = r0.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r20 = r21
        L_0x01d2:
            r6 = r6 | r20
            goto L_0x01d7
        L_0x01d5:
            r11 = r94
        L_0x01d7:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r12 & r18
            if (r18 == 0) goto L_0x01e3
            r6 = r6 | r23
            r11 = r95
            goto L_0x01f6
        L_0x01e3:
            r20 = r14 & r23
            r11 = r95
            if (r20 != 0) goto L_0x01f6
            boolean r20 = r0.changed((java.lang.Object) r11)
            if (r20 == 0) goto L_0x01f2
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f4
        L_0x01f2:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x01f4:
            r6 = r6 | r20
        L_0x01f6:
            r20 = 65536(0x10000, float:9.18355E-41)
            r20 = r12 & r20
            if (r20 == 0) goto L_0x0201
            r6 = r6 | r26
            r11 = r96
            goto L_0x0214
        L_0x0201:
            r21 = r14 & r26
            r11 = r96
            if (r21 != 0) goto L_0x0214
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x0210
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0212
        L_0x0210:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x0212:
            r6 = r6 | r21
        L_0x0214:
            r21 = 131072(0x20000, float:1.83671E-40)
            r21 = r12 & r21
            if (r21 == 0) goto L_0x021f
            r6 = r6 | r29
            r11 = r97
            goto L_0x0232
        L_0x021f:
            r23 = r14 & r29
            r11 = r97
            if (r23 != 0) goto L_0x0232
            boolean r23 = r0.changed((boolean) r11)
            if (r23 == 0) goto L_0x022e
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0230
        L_0x022e:
            r23 = r30
        L_0x0230:
            r6 = r6 | r23
        L_0x0232:
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r23 = r14 & r23
            if (r23 != 0) goto L_0x024e
            r23 = 262144(0x40000, float:3.67342E-40)
            r23 = r12 & r23
            r11 = r98
            if (r23 != 0) goto L_0x0249
            boolean r23 = r0.changed((int) r11)
            if (r23 == 0) goto L_0x0249
            r23 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x024b
        L_0x0249:
            r23 = 33554432(0x2000000, float:9.403955E-38)
        L_0x024b:
            r6 = r6 | r23
            goto L_0x0250
        L_0x024e:
            r11 = r98
        L_0x0250:
            r23 = 524288(0x80000, float:7.34684E-40)
            r23 = r12 & r23
            if (r23 == 0) goto L_0x025b
            r6 = r6 | r32
            r11 = r99
            goto L_0x026e
        L_0x025b:
            r26 = r14 & r32
            r11 = r99
            if (r26 != 0) goto L_0x026e
            boolean r26 = r0.changed((int) r11)
            if (r26 == 0) goto L_0x026a
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x026c
        L_0x026a:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x026c:
            r6 = r6 | r26
        L_0x026e:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r26 = r12 & r26
            if (r26 == 0) goto L_0x0279
            r22 = r13 | 6
            r11 = r100
            goto L_0x028f
        L_0x0279:
            r29 = r13 & 6
            r11 = r100
            if (r29 != 0) goto L_0x028d
            boolean r29 = r0.changed((java.lang.Object) r11)
            if (r29 == 0) goto L_0x0288
            r22 = 4
            goto L_0x028a
        L_0x0288:
            r22 = 2
        L_0x028a:
            r22 = r13 | r22
            goto L_0x028f
        L_0x028d:
            r22 = r13
        L_0x028f:
            r29 = r13 & 48
            if (r29 != 0) goto L_0x02a9
            r29 = 2097152(0x200000, float:2.938736E-39)
            r29 = r12 & r29
            r11 = r101
            if (r29 != 0) goto L_0x02a4
            boolean r29 = r0.changed((java.lang.Object) r11)
            if (r29 == 0) goto L_0x02a4
            r24 = 32
            goto L_0x02a6
        L_0x02a4:
            r24 = 16
        L_0x02a6:
            r22 = r22 | r24
            goto L_0x02ab
        L_0x02a9:
            r11 = r101
        L_0x02ab:
            r11 = r13 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x02c5
            r11 = r12 & r30
            if (r11 != 0) goto L_0x02be
            r11 = r102
            boolean r24 = r0.changed((java.lang.Object) r11)
            if (r24 == 0) goto L_0x02c0
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x02c2
        L_0x02be:
            r11 = r102
        L_0x02c0:
            r28 = 128(0x80, float:1.794E-43)
        L_0x02c2:
            r22 = r22 | r28
            goto L_0x02c7
        L_0x02c5:
            r11 = r102
        L_0x02c7:
            r11 = r22
            r22 = 306783379(0x12492493, float:6.34695E-28)
            r13 = r4 & r22
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r13 != r14) goto L_0x0318
            r13 = 306783379(0x12492493, float:6.34695E-28)
            r13 = r13 & r6
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r13 != r14) goto L_0x0318
            r13 = r11 & 147(0x93, float:2.06E-43)
            r14 = 146(0x92, float:2.05E-43)
            if (r13 != r14) goto L_0x0318
            boolean r13 = r0.getSkipping()
            if (r13 != 0) goto L_0x02e9
            goto L_0x0318
        L_0x02e9:
            r0.skipToGroupEnd()
            r3 = r82
            r4 = r83
            r5 = r84
            r6 = r85
            r7 = r86
            r8 = r87
            r9 = r88
            r10 = r89
            r11 = r90
            r12 = r91
            r13 = r92
            r14 = r93
            r15 = r94
            r16 = r95
            r17 = r96
            r18 = r97
            r19 = r98
            r20 = r99
            r21 = r100
            r22 = r101
            r23 = r102
            goto L_0x05e3
        L_0x0318:
            r0.startDefaults()
            r13 = r15 & 1
            if (r13 == 0) goto L_0x0377
            boolean r13 = r0.getDefaultsInvalid()
            if (r13 == 0) goto L_0x0326
            goto L_0x0377
        L_0x0326:
            r0.skipToGroupEnd()
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0331
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r1
        L_0x0331:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x033a
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r6 = r6 & r1
        L_0x033a:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x0341
            r11 = r11 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0341:
            r1 = r12 & r30
            if (r1 == 0) goto L_0x0347
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0347:
            r1 = r82
            r2 = r83
            r3 = r84
            r8 = r85
            r14 = r86
            r9 = r87
            r5 = r89
            r7 = r91
            r13 = r92
            r10 = r93
            r40 = r95
            r41 = r96
            r42 = r97
            r43 = r98
            r44 = r99
            r45 = r100
            r46 = r101
            r12 = r4
            r15 = r6
            r16 = r11
            r4 = r88
            r6 = r90
            r11 = r94
            r88 = r102
            goto L_0x04b9
        L_0x0377:
            if (r8 == 0) goto L_0x037e
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            goto L_0x0380
        L_0x037e:
            r8 = r82
        L_0x0380:
            if (r16 == 0) goto L_0x0384
            r13 = 1
            goto L_0x0386
        L_0x0384:
            r13 = r83
        L_0x0386:
            if (r19 == 0) goto L_0x038b
            r16 = 0
            goto L_0x038d
        L_0x038b:
            r16 = r84
        L_0x038d:
            r19 = r12 & 32
            if (r19 == 0) goto L_0x03b3
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.material3.TextKt.getLocalTextStyle()
            r14 = r19
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r82 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            r83 = r13
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r13)
            java.lang.Object r8 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r8 = (androidx.compose.ui.text.TextStyle) r8
            r13 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r13
            goto L_0x03b9
        L_0x03b3:
            r82 = r8
            r83 = r13
            r8 = r85
        L_0x03b9:
            r13 = 0
            if (r25 == 0) goto L_0x03be
            r14 = r13
            goto L_0x03c0
        L_0x03be:
            r14 = r86
        L_0x03c0:
            if (r9 == 0) goto L_0x03c4
            r9 = r13
            goto L_0x03c6
        L_0x03c4:
            r9 = r87
        L_0x03c6:
            if (r1 == 0) goto L_0x03ca
            r1 = r13
            goto L_0x03cc
        L_0x03ca:
            r1 = r88
        L_0x03cc:
            if (r2 == 0) goto L_0x03d0
            r2 = r13
            goto L_0x03d2
        L_0x03d0:
            r2 = r89
        L_0x03d2:
            if (r3 == 0) goto L_0x03d6
            r3 = r13
            goto L_0x03d8
        L_0x03d6:
            r3 = r90
        L_0x03d8:
            if (r5 == 0) goto L_0x03dc
            r5 = r13
            goto L_0x03de
        L_0x03dc:
            r5 = r91
        L_0x03de:
            if (r7 == 0) goto L_0x03e1
            goto L_0x03e3
        L_0x03e1:
            r13 = r92
        L_0x03e3:
            if (r10 == 0) goto L_0x03e7
            r7 = 0
            goto L_0x03e9
        L_0x03e7:
            r7 = r93
        L_0x03e9:
            if (r17 == 0) goto L_0x03f2
            androidx.compose.ui.text.input.VisualTransformation$Companion r10 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r10 = r10.getNone()
            goto L_0x03f4
        L_0x03f2:
            r10 = r94
        L_0x03f4:
            if (r18 == 0) goto L_0x03fd
            androidx.compose.foundation.text.KeyboardOptions$Companion r17 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r17 = r17.getDefault()
            goto L_0x03ff
        L_0x03fd:
            r17 = r95
        L_0x03ff:
            if (r20 == 0) goto L_0x0408
            androidx.compose.foundation.text.KeyboardActions$Companion r18 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r18 = r18.getDefault()
            goto L_0x040a
        L_0x0408:
            r18 = r96
        L_0x040a:
            if (r21 == 0) goto L_0x040f
            r19 = 0
            goto L_0x0411
        L_0x040f:
            r19 = r97
        L_0x0411:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r12 & r20
            if (r20 == 0) goto L_0x0425
            if (r19 == 0) goto L_0x041c
            r20 = 1
            goto L_0x041f
        L_0x041c:
            r20 = 2147483647(0x7fffffff, float:NaN)
        L_0x041f:
            r21 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r6 = r6 & r21
            goto L_0x0427
        L_0x0425:
            r20 = r98
        L_0x0427:
            if (r23 == 0) goto L_0x042c
            r21 = 1
            goto L_0x042e
        L_0x042c:
            r21 = r99
        L_0x042e:
            r84 = r1
            if (r26 == 0) goto L_0x0458
            r1 = 1663535677(0x63278a3d, float:3.0905674E21)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):OutlinedTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            java.lang.Object r1 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r85 = r2
            java.lang.Object r2 = r22.getEmpty()
            if (r1 != r2) goto L_0x0452
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r1)
        L_0x0452:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r0.endReplaceableGroup()
            goto L_0x045c
        L_0x0458:
            r85 = r2
            r1 = r100
        L_0x045c:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x046d
            androidx.compose.material3.OutlinedTextFieldDefaults r2 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r86 = r1
            r1 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r0, r1)
            r11 = r11 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0472
        L_0x046d:
            r86 = r1
            r1 = 6
            r2 = r101
        L_0x0472:
            r22 = r12 & r30
            r87 = r2
            if (r22 == 0) goto L_0x0497
            androidx.compose.material3.OutlinedTextFieldDefaults r2 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r2 = r2.colors(r0, r1)
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            r1 = r82
            r45 = r86
            r46 = r87
            r88 = r2
            r12 = r4
            r15 = r6
            r40 = r17
            r41 = r18
            r42 = r19
            r43 = r20
            r44 = r21
            r2 = r83
            goto L_0x04ad
        L_0x0497:
            r1 = r82
            r2 = r83
            r45 = r86
            r46 = r87
            r88 = r102
            r12 = r4
            r15 = r6
            r40 = r17
            r41 = r18
            r42 = r19
            r43 = r20
            r44 = r21
        L_0x04ad:
            r4 = r84
            r6 = r3
            r3 = r16
            r16 = r11
            r11 = r10
            r10 = r7
            r7 = r5
            r5 = r85
        L_0x04b9:
            r0.endDefaults()
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x04cf
            r89 = r13
            r13 = -1922450045(0xffffffff8d69bd83, float:-7.2026785E-31)
            r90 = r7
            java.lang.String r7 = "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:165)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r12, r15, r7)
            goto L_0x04d3
        L_0x04cf:
            r90 = r7
            r89 = r13
        L_0x04d3:
            r7 = 1663535958(0x63278b56, float:3.0906465E21)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "*168@9338L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            long r17 = r8.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion
            long r19 = r7.m3852getUnspecified0d7_KjU()
            int r7 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r7 == 0) goto L_0x04ed
            goto L_0x051e
        L_0x04ed:
            r7 = r45
            androidx.compose.foundation.interaction.InteractionSource r7 = (androidx.compose.foundation.interaction.InteractionSource) r7
            int r12 = r12 >> 9
            r12 = r12 & 14
            r13 = 6
            int r15 = r15 >> r13
            r13 = r15 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            int r13 = r16 << 6
            r13 = r13 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            int r13 = r16 << 3
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            r82 = r88
            r83 = r2
            r84 = r10
            r85 = r7
            r86 = r0
            r87 = r12
            androidx.compose.runtime.State r7 = r82.textColor$material3_release(r83, r84, r85, r86, r87)
            java.lang.Object r7 = r7.getValue()
            androidx.compose.ui.graphics.Color r7 = (androidx.compose.ui.graphics.Color) r7
            long r17 = r7.m3826unboximpl()
        L_0x051e:
            r48 = r17
            r0.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r7 = new androidx.compose.ui.text.TextStyle
            r47 = r7
            r77 = 16777214(0xfffffe, float:2.3509884E-38)
            r78 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r64 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r71 = 0
            r72 = 0
            r73 = 0
            r74 = 0
            r75 = 0
            r76 = 0
            r47.<init>((long) r48, (long) r50, (androidx.compose.ui.text.font.FontWeight) r52, (androidx.compose.ui.text.font.FontStyle) r53, (androidx.compose.ui.text.font.FontSynthesis) r54, (androidx.compose.ui.text.font.FontFamily) r55, (java.lang.String) r56, (long) r57, (androidx.compose.ui.text.style.BaselineShift) r59, (androidx.compose.ui.text.style.TextGeometricTransform) r60, (androidx.compose.ui.text.intl.LocaleList) r61, (long) r62, (androidx.compose.ui.text.style.TextDecoration) r64, (androidx.compose.ui.graphics.Shadow) r65, (androidx.compose.ui.graphics.drawscope.DrawStyle) r66, (int) r67, (int) r68, (long) r69, (androidx.compose.ui.text.style.TextIndent) r71, (androidx.compose.ui.text.PlatformTextStyle) r72, (androidx.compose.ui.text.style.LineHeightStyle) r73, (int) r74, (int) r75, (androidx.compose.ui.text.style.TextMotion) r76, (int) r77, (kotlin.jvm.internal.DefaultConstructorMarker) r78)
            androidx.compose.ui.text.TextStyle r25 = r8.merge((androidx.compose.ui.text.TextStyle) r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            r12 = 6
            int r12 = r16 >> 6
            r12 = r12 & 14
            r13 = r88
            androidx.compose.foundation.text.selection.TextSelectionColors r12 = r13.getSelectionColors(r0, r12)
            androidx.compose.runtime.ProvidedValue r7 = r7.provides(r12)
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2 r12 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2
            r16 = r12
            r17 = r14
            r18 = r1
            r19 = r10
            r20 = r13
            r21 = r80
            r22 = r81
            r23 = r2
            r24 = r3
            r26 = r40
            r27 = r41
            r28 = r42
            r29 = r43
            r30 = r44
            r31 = r11
            r32 = r45
            r33 = r9
            r34 = r4
            r35 = r5
            r36 = r6
            r37 = r90
            r38 = r89
            r39 = r46
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            r15 = -1886965181(0xffffffff8f873243, float:-1.3331388E-29)
            r82 = r1
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r1, r12)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r12 = androidx.compose.runtime.ProvidedValue.$stable
            r12 = r12 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r0, (int) r12)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x05c3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05c3:
            r12 = r90
            r15 = r11
            r23 = r13
            r7 = r14
            r16 = r40
            r17 = r41
            r18 = r42
            r19 = r43
            r20 = r44
            r21 = r45
            r22 = r46
            r13 = r89
            r11 = r6
            r6 = r8
            r8 = r9
            r14 = r10
            r9 = r4
            r10 = r5
            r4 = r2
            r5 = r3
            r3 = r82
        L_0x05e3:
            androidx.compose.runtime.ScopeUpdateScope r2 = r0.endRestartGroup()
            if (r2 == 0) goto L_0x0607
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3 r28 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3
            r0 = r28
            r1 = r80
            r79 = r2
            r2 = r81
            r24 = r104
            r25 = r105
            r26 = r106
            r27 = r107
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r0 = r28
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r79
            r1.updateScope(r0)
        L_0x0607:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x05e9  */
    /* JADX WARNING: Removed duplicated region for block: B:355:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue r80, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r81, androidx.compose.ui.Modifier r82, boolean r83, boolean r84, androidx.compose.ui.text.TextStyle r85, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r87, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r92, boolean r93, androidx.compose.ui.text.input.VisualTransformation r94, androidx.compose.foundation.text.KeyboardOptions r95, androidx.compose.foundation.text.KeyboardActions r96, boolean r97, int r98, int r99, androidx.compose.foundation.interaction.MutableInteractionSource r100, androidx.compose.ui.graphics.Shape r101, androidx.compose.material3.TextFieldColors r102, androidx.compose.runtime.Composer r103, int r104, int r105, int r106, int r107) {
        /*
            r15 = r104
            r14 = r105
            r13 = r106
            r12 = r107
            r0 = -1570442800(0xffffffffa264f1d0, float:-3.1027776E-18)
            r1 = r103
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)307@17107L7,322@17859L39,323@17945L5,324@18008L8,332@18370L15,332@18304L2529:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0020
            r1 = r15 | 6
            r4 = r1
            r1 = r80
            goto L_0x0034
        L_0x0020:
            r1 = r15 & 6
            if (r1 != 0) goto L_0x0031
            r1 = r80
            boolean r4 = r0.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x002e
            r4 = 4
            goto L_0x002f
        L_0x002e:
            r4 = 2
        L_0x002f:
            r4 = r4 | r15
            goto L_0x0034
        L_0x0031:
            r1 = r80
            r4 = r15
        L_0x0034:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x003b
            r4 = r4 | 48
            goto L_0x004e
        L_0x003b:
            r5 = r15 & 48
            if (r5 != 0) goto L_0x004e
            r5 = r81
            boolean r8 = r0.changedInstance(r5)
            if (r8 == 0) goto L_0x004a
            r8 = 32
            goto L_0x004c
        L_0x004a:
            r8 = 16
        L_0x004c:
            r4 = r4 | r8
            goto L_0x0050
        L_0x004e:
            r5 = r81
        L_0x0050:
            r8 = r12 & 4
            if (r8 == 0) goto L_0x0057
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0057:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x006b
            r11 = r82
            boolean r16 = r0.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x0066
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r4 = r4 | r16
            goto L_0x006d
        L_0x006b:
            r11 = r82
        L_0x006d:
            r16 = r12 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0078
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0078:
            r2 = r15 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x008c
            r2 = r83
            boolean r19 = r0.changed((boolean) r2)
            if (r19 == 0) goto L_0x0087
            r19 = r17
            goto L_0x0089
        L_0x0087:
            r19 = r18
        L_0x0089:
            r4 = r4 | r19
            goto L_0x008e
        L_0x008c:
            r2 = r83
        L_0x008e:
            r19 = r12 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0099
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ad
        L_0x0099:
            r3 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x00ad
            r3 = r84
            boolean r23 = r0.changed((boolean) r3)
            if (r23 == 0) goto L_0x00a8
            r23 = r20
            goto L_0x00aa
        L_0x00a8:
            r23 = r21
        L_0x00aa:
            r4 = r4 | r23
            goto L_0x00af
        L_0x00ad:
            r3 = r84
        L_0x00af:
            r23 = 196608(0x30000, float:2.75506E-40)
            r24 = r15 & r23
            if (r24 != 0) goto L_0x00c9
            r24 = r12 & 32
            r6 = r85
            if (r24 != 0) goto L_0x00c4
            boolean r25 = r0.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00c4
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c4:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r4 = r4 | r25
            goto L_0x00cb
        L_0x00c9:
            r6 = r85
        L_0x00cb:
            r25 = r12 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00d6
            r4 = r4 | r26
            r7 = r86
            goto L_0x00e9
        L_0x00d6:
            r27 = r15 & r26
            r7 = r86
            if (r27 != 0) goto L_0x00e9
            boolean r28 = r0.changedInstance(r7)
            if (r28 == 0) goto L_0x00e5
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r4 = r4 | r28
        L_0x00e9:
            r9 = r12 & 128(0x80, float:1.794E-43)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r30 = 4194304(0x400000, float:5.877472E-39)
            if (r9 == 0) goto L_0x00f6
            r4 = r4 | r29
            r10 = r87
            goto L_0x0109
        L_0x00f6:
            r31 = r15 & r29
            r10 = r87
            if (r31 != 0) goto L_0x0109
            boolean r32 = r0.changedInstance(r10)
            if (r32 == 0) goto L_0x0105
            r32 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r32 = r30
        L_0x0107:
            r4 = r4 | r32
        L_0x0109:
            r1 = r12 & 256(0x100, float:3.59E-43)
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x0114
            r4 = r4 | r32
            r2 = r88
            goto L_0x0127
        L_0x0114:
            r32 = r15 & r32
            r2 = r88
            if (r32 != 0) goto L_0x0127
            boolean r32 = r0.changedInstance(r2)
            if (r32 == 0) goto L_0x0123
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r4 = r4 | r32
        L_0x0127:
            r2 = r12 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0132
            r4 = r4 | r32
            r3 = r89
            goto L_0x0145
        L_0x0132:
            r33 = r15 & r32
            r3 = r89
            if (r33 != 0) goto L_0x0145
            boolean r33 = r0.changedInstance(r3)
            if (r33 == 0) goto L_0x0141
            r33 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0143
        L_0x0141:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0143:
            r4 = r4 | r33
        L_0x0145:
            r3 = r12 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x014e
            r33 = r14 | 6
            r5 = r90
            goto L_0x0164
        L_0x014e:
            r33 = r14 & 6
            r5 = r90
            if (r33 != 0) goto L_0x0162
            boolean r33 = r0.changedInstance(r5)
            if (r33 == 0) goto L_0x015d
            r33 = 4
            goto L_0x015f
        L_0x015d:
            r33 = 2
        L_0x015f:
            r33 = r14 | r33
            goto L_0x0164
        L_0x0162:
            r33 = r14
        L_0x0164:
            r5 = r12 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x016b
            r33 = r33 | 48
            goto L_0x017e
        L_0x016b:
            r34 = r14 & 48
            r6 = r91
            if (r34 != 0) goto L_0x017e
            boolean r34 = r0.changedInstance(r6)
            if (r34 == 0) goto L_0x017a
            r34 = 32
            goto L_0x017c
        L_0x017a:
            r34 = 16
        L_0x017c:
            r33 = r33 | r34
        L_0x017e:
            r6 = r33
            r7 = r12 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0187
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x019b
        L_0x0187:
            r10 = r14 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x019b
            r10 = r92
            boolean r33 = r0.changedInstance(r10)
            if (r33 == 0) goto L_0x0196
            r33 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r33 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r6 = r6 | r33
            goto L_0x019d
        L_0x019b:
            r10 = r92
        L_0x019d:
            r10 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01a4
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b6
        L_0x01a4:
            r11 = r14 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x01b6
            r11 = r93
            boolean r33 = r0.changed((boolean) r11)
            if (r33 == 0) goto L_0x01b1
            goto L_0x01b3
        L_0x01b1:
            r17 = r18
        L_0x01b3:
            r6 = r6 | r17
            goto L_0x01b8
        L_0x01b6:
            r11 = r93
        L_0x01b8:
            r11 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c1
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r17 = r11
            goto L_0x01d5
        L_0x01c1:
            r17 = r11
            r11 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01d5
            r11 = r94
            boolean r18 = r0.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r20 = r21
        L_0x01d2:
            r6 = r6 | r20
            goto L_0x01d7
        L_0x01d5:
            r11 = r94
        L_0x01d7:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r12 & r18
            if (r18 == 0) goto L_0x01e3
            r6 = r6 | r23
            r11 = r95
            goto L_0x01f6
        L_0x01e3:
            r20 = r14 & r23
            r11 = r95
            if (r20 != 0) goto L_0x01f6
            boolean r20 = r0.changed((java.lang.Object) r11)
            if (r20 == 0) goto L_0x01f2
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f4
        L_0x01f2:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x01f4:
            r6 = r6 | r20
        L_0x01f6:
            r20 = 65536(0x10000, float:9.18355E-41)
            r20 = r12 & r20
            if (r20 == 0) goto L_0x0201
            r6 = r6 | r26
            r11 = r96
            goto L_0x0214
        L_0x0201:
            r21 = r14 & r26
            r11 = r96
            if (r21 != 0) goto L_0x0214
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x0210
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0212
        L_0x0210:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x0212:
            r6 = r6 | r21
        L_0x0214:
            r21 = 131072(0x20000, float:1.83671E-40)
            r21 = r12 & r21
            if (r21 == 0) goto L_0x021f
            r6 = r6 | r29
            r11 = r97
            goto L_0x0232
        L_0x021f:
            r23 = r14 & r29
            r11 = r97
            if (r23 != 0) goto L_0x0232
            boolean r23 = r0.changed((boolean) r11)
            if (r23 == 0) goto L_0x022e
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0230
        L_0x022e:
            r23 = r30
        L_0x0230:
            r6 = r6 | r23
        L_0x0232:
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r23 = r14 & r23
            if (r23 != 0) goto L_0x024e
            r23 = 262144(0x40000, float:3.67342E-40)
            r23 = r12 & r23
            r11 = r98
            if (r23 != 0) goto L_0x0249
            boolean r23 = r0.changed((int) r11)
            if (r23 == 0) goto L_0x0249
            r23 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x024b
        L_0x0249:
            r23 = 33554432(0x2000000, float:9.403955E-38)
        L_0x024b:
            r6 = r6 | r23
            goto L_0x0250
        L_0x024e:
            r11 = r98
        L_0x0250:
            r23 = 524288(0x80000, float:7.34684E-40)
            r23 = r12 & r23
            if (r23 == 0) goto L_0x025b
            r6 = r6 | r32
            r11 = r99
            goto L_0x026e
        L_0x025b:
            r26 = r14 & r32
            r11 = r99
            if (r26 != 0) goto L_0x026e
            boolean r26 = r0.changed((int) r11)
            if (r26 == 0) goto L_0x026a
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x026c
        L_0x026a:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x026c:
            r6 = r6 | r26
        L_0x026e:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r26 = r12 & r26
            if (r26 == 0) goto L_0x0279
            r22 = r13 | 6
            r11 = r100
            goto L_0x028f
        L_0x0279:
            r29 = r13 & 6
            r11 = r100
            if (r29 != 0) goto L_0x028d
            boolean r29 = r0.changed((java.lang.Object) r11)
            if (r29 == 0) goto L_0x0288
            r22 = 4
            goto L_0x028a
        L_0x0288:
            r22 = 2
        L_0x028a:
            r22 = r13 | r22
            goto L_0x028f
        L_0x028d:
            r22 = r13
        L_0x028f:
            r29 = r13 & 48
            if (r29 != 0) goto L_0x02a9
            r29 = 2097152(0x200000, float:2.938736E-39)
            r29 = r12 & r29
            r11 = r101
            if (r29 != 0) goto L_0x02a4
            boolean r29 = r0.changed((java.lang.Object) r11)
            if (r29 == 0) goto L_0x02a4
            r24 = 32
            goto L_0x02a6
        L_0x02a4:
            r24 = 16
        L_0x02a6:
            r22 = r22 | r24
            goto L_0x02ab
        L_0x02a9:
            r11 = r101
        L_0x02ab:
            r11 = r13 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x02c5
            r11 = r12 & r30
            if (r11 != 0) goto L_0x02be
            r11 = r102
            boolean r24 = r0.changed((java.lang.Object) r11)
            if (r24 == 0) goto L_0x02c0
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x02c2
        L_0x02be:
            r11 = r102
        L_0x02c0:
            r28 = 128(0x80, float:1.794E-43)
        L_0x02c2:
            r22 = r22 | r28
            goto L_0x02c7
        L_0x02c5:
            r11 = r102
        L_0x02c7:
            r11 = r22
            r22 = 306783379(0x12492493, float:6.34695E-28)
            r13 = r4 & r22
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r13 != r14) goto L_0x0318
            r13 = 306783379(0x12492493, float:6.34695E-28)
            r13 = r13 & r6
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r13 != r14) goto L_0x0318
            r13 = r11 & 147(0x93, float:2.06E-43)
            r14 = 146(0x92, float:2.05E-43)
            if (r13 != r14) goto L_0x0318
            boolean r13 = r0.getSkipping()
            if (r13 != 0) goto L_0x02e9
            goto L_0x0318
        L_0x02e9:
            r0.skipToGroupEnd()
            r3 = r82
            r4 = r83
            r5 = r84
            r6 = r85
            r7 = r86
            r8 = r87
            r9 = r88
            r10 = r89
            r11 = r90
            r12 = r91
            r13 = r92
            r14 = r93
            r15 = r94
            r16 = r95
            r17 = r96
            r18 = r97
            r19 = r98
            r20 = r99
            r21 = r100
            r22 = r101
            r23 = r102
            goto L_0x05e3
        L_0x0318:
            r0.startDefaults()
            r13 = r15 & 1
            if (r13 == 0) goto L_0x0377
            boolean r13 = r0.getDefaultsInvalid()
            if (r13 == 0) goto L_0x0326
            goto L_0x0377
        L_0x0326:
            r0.skipToGroupEnd()
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0331
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r1
        L_0x0331:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x033a
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r6 = r6 & r1
        L_0x033a:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x0341
            r11 = r11 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0341:
            r1 = r12 & r30
            if (r1 == 0) goto L_0x0347
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0347:
            r1 = r82
            r2 = r83
            r3 = r84
            r8 = r85
            r14 = r86
            r9 = r87
            r5 = r89
            r7 = r91
            r13 = r92
            r10 = r93
            r40 = r95
            r41 = r96
            r42 = r97
            r43 = r98
            r44 = r99
            r45 = r100
            r46 = r101
            r12 = r4
            r15 = r6
            r16 = r11
            r4 = r88
            r6 = r90
            r11 = r94
            r88 = r102
            goto L_0x04b9
        L_0x0377:
            if (r8 == 0) goto L_0x037e
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            goto L_0x0380
        L_0x037e:
            r8 = r82
        L_0x0380:
            if (r16 == 0) goto L_0x0384
            r13 = 1
            goto L_0x0386
        L_0x0384:
            r13 = r83
        L_0x0386:
            if (r19 == 0) goto L_0x038b
            r16 = 0
            goto L_0x038d
        L_0x038b:
            r16 = r84
        L_0x038d:
            r19 = r12 & 32
            if (r19 == 0) goto L_0x03b3
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.material3.TextKt.getLocalTextStyle()
            r14 = r19
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r82 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            r83 = r13
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r13)
            java.lang.Object r8 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r8 = (androidx.compose.ui.text.TextStyle) r8
            r13 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r13
            goto L_0x03b9
        L_0x03b3:
            r82 = r8
            r83 = r13
            r8 = r85
        L_0x03b9:
            r13 = 0
            if (r25 == 0) goto L_0x03be
            r14 = r13
            goto L_0x03c0
        L_0x03be:
            r14 = r86
        L_0x03c0:
            if (r9 == 0) goto L_0x03c4
            r9 = r13
            goto L_0x03c6
        L_0x03c4:
            r9 = r87
        L_0x03c6:
            if (r1 == 0) goto L_0x03ca
            r1 = r13
            goto L_0x03cc
        L_0x03ca:
            r1 = r88
        L_0x03cc:
            if (r2 == 0) goto L_0x03d0
            r2 = r13
            goto L_0x03d2
        L_0x03d0:
            r2 = r89
        L_0x03d2:
            if (r3 == 0) goto L_0x03d6
            r3 = r13
            goto L_0x03d8
        L_0x03d6:
            r3 = r90
        L_0x03d8:
            if (r5 == 0) goto L_0x03dc
            r5 = r13
            goto L_0x03de
        L_0x03dc:
            r5 = r91
        L_0x03de:
            if (r7 == 0) goto L_0x03e1
            goto L_0x03e3
        L_0x03e1:
            r13 = r92
        L_0x03e3:
            if (r10 == 0) goto L_0x03e7
            r7 = 0
            goto L_0x03e9
        L_0x03e7:
            r7 = r93
        L_0x03e9:
            if (r17 == 0) goto L_0x03f2
            androidx.compose.ui.text.input.VisualTransformation$Companion r10 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r10 = r10.getNone()
            goto L_0x03f4
        L_0x03f2:
            r10 = r94
        L_0x03f4:
            if (r18 == 0) goto L_0x03fd
            androidx.compose.foundation.text.KeyboardOptions$Companion r17 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r17 = r17.getDefault()
            goto L_0x03ff
        L_0x03fd:
            r17 = r95
        L_0x03ff:
            if (r20 == 0) goto L_0x0408
            androidx.compose.foundation.text.KeyboardActions$Companion r18 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r18 = r18.getDefault()
            goto L_0x040a
        L_0x0408:
            r18 = r96
        L_0x040a:
            if (r21 == 0) goto L_0x040f
            r19 = 0
            goto L_0x0411
        L_0x040f:
            r19 = r97
        L_0x0411:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r12 & r20
            if (r20 == 0) goto L_0x0425
            if (r19 == 0) goto L_0x041c
            r20 = 1
            goto L_0x041f
        L_0x041c:
            r20 = 2147483647(0x7fffffff, float:NaN)
        L_0x041f:
            r21 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r6 = r6 & r21
            goto L_0x0427
        L_0x0425:
            r20 = r98
        L_0x0427:
            if (r23 == 0) goto L_0x042c
            r21 = 1
            goto L_0x042e
        L_0x042c:
            r21 = r99
        L_0x042e:
            r84 = r1
            if (r26 == 0) goto L_0x0458
            r1 = 1663544507(0x6327acbb, float:3.0930528E21)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):OutlinedTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            java.lang.Object r1 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r85 = r2
            java.lang.Object r2 = r22.getEmpty()
            if (r1 != r2) goto L_0x0452
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r1)
        L_0x0452:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r0.endReplaceableGroup()
            goto L_0x045c
        L_0x0458:
            r85 = r2
            r1 = r100
        L_0x045c:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x046d
            androidx.compose.material3.OutlinedTextFieldDefaults r2 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r86 = r1
            r1 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r0, r1)
            r11 = r11 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0472
        L_0x046d:
            r86 = r1
            r1 = 6
            r2 = r101
        L_0x0472:
            r22 = r12 & r30
            r87 = r2
            if (r22 == 0) goto L_0x0497
            androidx.compose.material3.OutlinedTextFieldDefaults r2 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r2 = r2.colors(r0, r1)
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            r1 = r82
            r45 = r86
            r46 = r87
            r88 = r2
            r12 = r4
            r15 = r6
            r40 = r17
            r41 = r18
            r42 = r19
            r43 = r20
            r44 = r21
            r2 = r83
            goto L_0x04ad
        L_0x0497:
            r1 = r82
            r2 = r83
            r45 = r86
            r46 = r87
            r88 = r102
            r12 = r4
            r15 = r6
            r40 = r17
            r41 = r18
            r42 = r19
            r43 = r20
            r44 = r21
        L_0x04ad:
            r4 = r84
            r6 = r3
            r3 = r16
            r16 = r11
            r11 = r10
            r10 = r7
            r7 = r5
            r5 = r85
        L_0x04b9:
            r0.endDefaults()
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x04cf
            r89 = r13
            r13 = -1570442800(0xffffffffa264f1d0, float:-3.1027776E-18)
            r90 = r7
            java.lang.String r7 = "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:325)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r12, r15, r7)
            goto L_0x04d3
        L_0x04cf:
            r90 = r7
            r89 = r13
        L_0x04d3:
            r7 = 1663544788(0x6327add4, float:3.093132E21)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "*328@18168L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            long r17 = r8.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion
            long r19 = r7.m3852getUnspecified0d7_KjU()
            int r7 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r7 == 0) goto L_0x04ed
            goto L_0x051e
        L_0x04ed:
            r7 = r45
            androidx.compose.foundation.interaction.InteractionSource r7 = (androidx.compose.foundation.interaction.InteractionSource) r7
            int r12 = r12 >> 9
            r12 = r12 & 14
            r13 = 6
            int r15 = r15 >> r13
            r13 = r15 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            int r13 = r16 << 6
            r13 = r13 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            int r13 = r16 << 3
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            r82 = r88
            r83 = r2
            r84 = r10
            r85 = r7
            r86 = r0
            r87 = r12
            androidx.compose.runtime.State r7 = r82.textColor$material3_release(r83, r84, r85, r86, r87)
            java.lang.Object r7 = r7.getValue()
            androidx.compose.ui.graphics.Color r7 = (androidx.compose.ui.graphics.Color) r7
            long r17 = r7.m3826unboximpl()
        L_0x051e:
            r48 = r17
            r0.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r7 = new androidx.compose.ui.text.TextStyle
            r47 = r7
            r77 = 16777214(0xfffffe, float:2.3509884E-38)
            r78 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r64 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r71 = 0
            r72 = 0
            r73 = 0
            r74 = 0
            r75 = 0
            r76 = 0
            r47.<init>((long) r48, (long) r50, (androidx.compose.ui.text.font.FontWeight) r52, (androidx.compose.ui.text.font.FontStyle) r53, (androidx.compose.ui.text.font.FontSynthesis) r54, (androidx.compose.ui.text.font.FontFamily) r55, (java.lang.String) r56, (long) r57, (androidx.compose.ui.text.style.BaselineShift) r59, (androidx.compose.ui.text.style.TextGeometricTransform) r60, (androidx.compose.ui.text.intl.LocaleList) r61, (long) r62, (androidx.compose.ui.text.style.TextDecoration) r64, (androidx.compose.ui.graphics.Shadow) r65, (androidx.compose.ui.graphics.drawscope.DrawStyle) r66, (int) r67, (int) r68, (long) r69, (androidx.compose.ui.text.style.TextIndent) r71, (androidx.compose.ui.text.PlatformTextStyle) r72, (androidx.compose.ui.text.style.LineHeightStyle) r73, (int) r74, (int) r75, (androidx.compose.ui.text.style.TextMotion) r76, (int) r77, (kotlin.jvm.internal.DefaultConstructorMarker) r78)
            androidx.compose.ui.text.TextStyle r25 = r8.merge((androidx.compose.ui.text.TextStyle) r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            r12 = 6
            int r12 = r16 >> 6
            r12 = r12 & 14
            r13 = r88
            androidx.compose.foundation.text.selection.TextSelectionColors r12 = r13.getSelectionColors(r0, r12)
            androidx.compose.runtime.ProvidedValue r7 = r7.provides(r12)
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5 r12 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5
            r16 = r12
            r17 = r14
            r18 = r1
            r19 = r10
            r20 = r13
            r21 = r80
            r22 = r81
            r23 = r2
            r24 = r3
            r26 = r40
            r27 = r41
            r28 = r42
            r29 = r43
            r30 = r44
            r31 = r11
            r32 = r45
            r33 = r9
            r34 = r4
            r35 = r5
            r36 = r6
            r37 = r90
            r38 = r89
            r39 = r46
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            r15 = 1830921872(0x6d21a690, float:3.126778E27)
            r82 = r1
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r1, r12)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r12 = androidx.compose.runtime.ProvidedValue.$stable
            r12 = r12 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r0, (int) r12)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x05c3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05c3:
            r12 = r90
            r15 = r11
            r23 = r13
            r7 = r14
            r16 = r40
            r17 = r41
            r18 = r42
            r19 = r43
            r20 = r44
            r21 = r45
            r22 = r46
            r13 = r89
            r11 = r6
            r6 = r8
            r8 = r9
            r14 = r10
            r9 = r4
            r10 = r5
            r4 = r2
            r5 = r3
            r3 = r82
        L_0x05e3:
            androidx.compose.runtime.ScopeUpdateScope r2 = r0.endRestartGroup()
            if (r2 == 0) goto L_0x0607
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$6 r28 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$6
            r0 = r28
            r1 = r80
            r79 = r2
            r2 = r81
            r24 = r104
            r25 = r105
            r26 = r106
            r27 = r107
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r0 = r28
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r79
            r1.updateScope(r0)
        L_0x0607:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:324:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0131  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void OutlinedTextField(java.lang.String r53, kotlin.jvm.functions.Function1 r54, androidx.compose.ui.Modifier r55, boolean r56, boolean r57, androidx.compose.ui.text.TextStyle r58, kotlin.jvm.functions.Function2 r59, kotlin.jvm.functions.Function2 r60, kotlin.jvm.functions.Function2 r61, kotlin.jvm.functions.Function2 r62, kotlin.jvm.functions.Function2 r63, boolean r64, androidx.compose.ui.text.input.VisualTransformation r65, androidx.compose.foundation.text.KeyboardOptions r66, androidx.compose.foundation.text.KeyboardActions r67, boolean r68, int r69, int r70, androidx.compose.foundation.interaction.MutableInteractionSource r71, androidx.compose.ui.graphics.Shape r72, androidx.compose.material3.TextFieldColors r73, androidx.compose.runtime.Composer r74, int r75, int r76, int r77, int r78) {
        /*
            r15 = r75
            r14 = r76
            r13 = r78
            r0 = -1575225237(0xffffffffa21bf86b, float:-2.1137928E-18)
            r1 = r74
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)402@21186L7,415@21846L39,416@21932L5,417@21995L8,419@22012L771:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001e
            r1 = r15 | 6
            r4 = r1
            r1 = r53
            goto L_0x0032
        L_0x001e:
            r1 = r15 & 6
            if (r1 != 0) goto L_0x002f
            r1 = r53
            boolean r4 = r0.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r15
            goto L_0x0032
        L_0x002f:
            r1 = r53
            r4 = r15
        L_0x0032:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r15 & 48
            if (r5 != 0) goto L_0x004c
            r5 = r54
            boolean r8 = r0.changedInstance(r5)
            if (r8 == 0) goto L_0x0048
            r8 = 32
            goto L_0x004a
        L_0x0048:
            r8 = 16
        L_0x004a:
            r4 = r4 | r8
            goto L_0x004e
        L_0x004c:
            r5 = r54
        L_0x004e:
            r8 = r13 & 4
            if (r8 == 0) goto L_0x0055
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0068
            r11 = r55
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0064
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r12
            goto L_0x006a
        L_0x0068:
            r11 = r55
        L_0x006a:
            r12 = r13 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0075
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0075:
            r2 = r15 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0089
            r2 = r56
            boolean r18 = r0.changed((boolean) r2)
            if (r18 == 0) goto L_0x0084
            r18 = r16
            goto L_0x0086
        L_0x0084:
            r18 = r17
        L_0x0086:
            r4 = r4 | r18
            goto L_0x008b
        L_0x0089:
            r2 = r56
        L_0x008b:
            r18 = r13 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x0094
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0094:
            r6 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x00a8
            r6 = r57
            boolean r21 = r0.changed((boolean) r6)
            if (r21 == 0) goto L_0x00a3
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r21 = r19
        L_0x00a5:
            r4 = r4 | r21
            goto L_0x00aa
        L_0x00a8:
            r6 = r57
        L_0x00aa:
            r21 = 196608(0x30000, float:2.75506E-40)
            r22 = r15 & r21
            r23 = 65536(0x10000, float:9.18355E-41)
            if (r22 != 0) goto L_0x00c6
            r22 = r13 & 32
            r7 = r58
            if (r22 != 0) goto L_0x00c1
            boolean r24 = r0.changed((java.lang.Object) r7)
            if (r24 == 0) goto L_0x00c1
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r24 = r23
        L_0x00c3:
            r4 = r4 | r24
            goto L_0x00c8
        L_0x00c6:
            r7 = r58
        L_0x00c8:
            r24 = r13 & 64
            r25 = 1048576(0x100000, float:1.469368E-39)
            r26 = 524288(0x80000, float:7.34684E-40)
            r27 = 1572864(0x180000, float:2.204052E-39)
            if (r24 == 0) goto L_0x00d7
            r4 = r4 | r27
            r9 = r59
            goto L_0x00ea
        L_0x00d7:
            r27 = r15 & r27
            r9 = r59
            if (r27 != 0) goto L_0x00ea
            boolean r28 = r0.changedInstance(r9)
            if (r28 == 0) goto L_0x00e6
            r28 = r25
            goto L_0x00e8
        L_0x00e6:
            r28 = r26
        L_0x00e8:
            r4 = r4 | r28
        L_0x00ea:
            r10 = r13 & 128(0x80, float:1.794E-43)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00f5
            r4 = r4 | r29
            r3 = r60
            goto L_0x0108
        L_0x00f5:
            r30 = r15 & r29
            r3 = r60
            if (r30 != 0) goto L_0x0108
            boolean r31 = r0.changedInstance(r3)
            if (r31 == 0) goto L_0x0104
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0106
        L_0x0104:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0106:
            r4 = r4 | r31
        L_0x0108:
            r1 = r13 & 256(0x100, float:3.59E-43)
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x0113
            r4 = r4 | r31
            r2 = r61
            goto L_0x0126
        L_0x0113:
            r32 = r15 & r31
            r2 = r61
            if (r32 != 0) goto L_0x0126
            boolean r32 = r0.changedInstance(r2)
            if (r32 == 0) goto L_0x0122
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0124
        L_0x0122:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0124:
            r4 = r4 | r32
        L_0x0126:
            r2 = r13 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0131
            r4 = r4 | r32
            r3 = r62
            goto L_0x0144
        L_0x0131:
            r32 = r15 & r32
            r3 = r62
            if (r32 != 0) goto L_0x0144
            boolean r32 = r0.changedInstance(r3)
            if (r32 == 0) goto L_0x0140
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r4 = r4 | r32
        L_0x0144:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x014d
            r32 = r14 | 6
            r5 = r63
            goto L_0x0163
        L_0x014d:
            r32 = r14 & 6
            r5 = r63
            if (r32 != 0) goto L_0x0161
            boolean r32 = r0.changedInstance(r5)
            if (r32 == 0) goto L_0x015c
            r32 = 4
            goto L_0x015e
        L_0x015c:
            r32 = 2
        L_0x015e:
            r32 = r14 | r32
            goto L_0x0163
        L_0x0161:
            r32 = r14
        L_0x0163:
            r5 = r13 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x016a
            r32 = r32 | 48
            goto L_0x017d
        L_0x016a:
            r33 = r14 & 48
            r6 = r64
            if (r33 != 0) goto L_0x017d
            boolean r33 = r0.changed((boolean) r6)
            if (r33 == 0) goto L_0x0179
            r22 = 32
            goto L_0x017b
        L_0x0179:
            r22 = 16
        L_0x017b:
            r32 = r32 | r22
        L_0x017d:
            r6 = r32
            r7 = r13 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0186
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x019a
        L_0x0186:
            r9 = r14 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x019a
            r9 = r65
            boolean r20 = r0.changed((java.lang.Object) r9)
            if (r20 == 0) goto L_0x0195
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x0197
        L_0x0195:
            r27 = 128(0x80, float:1.794E-43)
        L_0x0197:
            r6 = r6 | r27
            goto L_0x019c
        L_0x019a:
            r9 = r65
        L_0x019c:
            r9 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x01a3
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b5
        L_0x01a3:
            r11 = r14 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x01b5
            r11 = r66
            boolean r20 = r0.changed((java.lang.Object) r11)
            if (r20 == 0) goto L_0x01b0
            goto L_0x01b2
        L_0x01b0:
            r16 = r17
        L_0x01b2:
            r6 = r6 | r16
            goto L_0x01b7
        L_0x01b5:
            r11 = r66
        L_0x01b7:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c0
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r16 = r11
            goto L_0x01d3
        L_0x01c0:
            r16 = r11
            r11 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01d3
            r11 = r67
            boolean r17 = r0.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x01d0
            r19 = 16384(0x4000, float:2.2959E-41)
        L_0x01d0:
            r6 = r6 | r19
            goto L_0x01d5
        L_0x01d3:
            r11 = r67
        L_0x01d5:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r13 & r17
            if (r17 == 0) goto L_0x01e1
            r6 = r6 | r21
            r11 = r68
            goto L_0x01f4
        L_0x01e1:
            r19 = r14 & r21
            r11 = r68
            if (r19 != 0) goto L_0x01f4
            boolean r19 = r0.changed((boolean) r11)
            if (r19 == 0) goto L_0x01f0
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f2
        L_0x01f0:
            r19 = r23
        L_0x01f2:
            r6 = r6 | r19
        L_0x01f4:
            r19 = 1572864(0x180000, float:2.204052E-39)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x020e
            r19 = r13 & r23
            r11 = r69
            if (r19 != 0) goto L_0x0209
            boolean r19 = r0.changed((int) r11)
            if (r19 == 0) goto L_0x0209
            r19 = r25
            goto L_0x020b
        L_0x0209:
            r19 = r26
        L_0x020b:
            r6 = r6 | r19
            goto L_0x0210
        L_0x020e:
            r11 = r69
        L_0x0210:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r13 & r19
            if (r19 == 0) goto L_0x021b
            r6 = r6 | r29
            r11 = r70
            goto L_0x022e
        L_0x021b:
            r20 = r14 & r29
            r11 = r70
            if (r20 != 0) goto L_0x022e
            boolean r20 = r0.changed((int) r11)
            if (r20 == 0) goto L_0x022a
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x022c
        L_0x022a:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x022c:
            r6 = r6 | r20
        L_0x022e:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r13 & r20
            if (r20 == 0) goto L_0x0239
            r6 = r6 | r31
            r11 = r71
            goto L_0x024c
        L_0x0239:
            r21 = r14 & r31
            r11 = r71
            if (r21 != 0) goto L_0x024c
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x0248
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x024a
        L_0x0248:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x024a:
            r6 = r6 | r21
        L_0x024c:
            r21 = 805306368(0x30000000, float:4.656613E-10)
            r21 = r14 & r21
            if (r21 != 0) goto L_0x0266
            r21 = r13 & r26
            r11 = r72
            if (r21 != 0) goto L_0x0261
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x0261
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0263
        L_0x0261:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0263:
            r6 = r6 | r21
            goto L_0x0268
        L_0x0266:
            r11 = r72
        L_0x0268:
            r21 = r77 & 6
            if (r21 != 0) goto L_0x0280
            r21 = r13 & r25
            r11 = r73
            if (r21 != 0) goto L_0x027b
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x027b
            r21 = 4
            goto L_0x027d
        L_0x027b:
            r21 = 2
        L_0x027d:
            r21 = r77 | r21
            goto L_0x0284
        L_0x0280:
            r11 = r73
            r21 = r77
        L_0x0284:
            r22 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r4 & r22
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r14) goto L_0x02d0
            r11 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r11 & r6
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r14) goto L_0x02d0
            r11 = r21 & 3
            r14 = 2
            if (r11 != r14) goto L_0x02d0
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x02a3
            goto L_0x02d0
        L_0x02a3:
            r0.skipToGroupEnd()
            r3 = r55
            r4 = r56
            r5 = r57
            r6 = r58
            r7 = r59
            r8 = r60
            r9 = r61
            r10 = r62
            r11 = r63
            r12 = r64
            r13 = r65
            r14 = r66
            r15 = r67
            r16 = r68
            r17 = r69
            r18 = r70
            r19 = r71
            r20 = r72
            r21 = r73
            r50 = r0
            goto L_0x04e6
        L_0x02d0:
            r0.startDefaults()
            r11 = r15 & 1
            if (r11 == 0) goto L_0x0329
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x02de
            goto L_0x0329
        L_0x02de:
            r0.skipToGroupEnd()
            r1 = r13 & 32
            if (r1 == 0) goto L_0x02e9
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r1
        L_0x02e9:
            r1 = r13 & r23
            if (r1 == 0) goto L_0x02f1
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r6 = r6 & r1
        L_0x02f1:
            r1 = r13 & r26
            if (r1 == 0) goto L_0x02f9
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r1
        L_0x02f9:
            r1 = r13 & r25
            if (r1 == 0) goto L_0x02ff
            r21 = r21 & -15
        L_0x02ff:
            r1 = r55
            r12 = r56
            r2 = r57
            r8 = r58
            r14 = r59
            r10 = r60
            r3 = r61
            r11 = r63
            r5 = r64
            r7 = r66
            r9 = r67
            r44 = r68
            r45 = r69
            r46 = r70
            r47 = r71
            r48 = r72
            r49 = r73
            r13 = r4
            r15 = r6
            r4 = r62
            r6 = r65
            goto L_0x0441
        L_0x0329:
            if (r8 == 0) goto L_0x0330
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            goto L_0x0332
        L_0x0330:
            r8 = r55
        L_0x0332:
            if (r12 == 0) goto L_0x0336
            r12 = 1
            goto L_0x0338
        L_0x0336:
            r12 = r56
        L_0x0338:
            if (r18 == 0) goto L_0x033d
            r18 = 0
            goto L_0x033f
        L_0x033d:
            r18 = r57
        L_0x033f:
            r22 = r13 & 32
            if (r22 == 0) goto L_0x0363
            androidx.compose.runtime.ProvidableCompositionLocal r22 = androidx.compose.material3.TextKt.getLocalTextStyle()
            r11 = r22
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r22 = r8
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r8)
            java.lang.Object r8 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r8 = (androidx.compose.ui.text.TextStyle) r8
            r11 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r11
            goto L_0x0367
        L_0x0363:
            r22 = r8
            r8 = r58
        L_0x0367:
            r11 = 0
            if (r24 == 0) goto L_0x036c
            r14 = r11
            goto L_0x036e
        L_0x036c:
            r14 = r59
        L_0x036e:
            if (r10 == 0) goto L_0x0372
            r10 = r11
            goto L_0x0374
        L_0x0372:
            r10 = r60
        L_0x0374:
            if (r1 == 0) goto L_0x0378
            r1 = r11
            goto L_0x037a
        L_0x0378:
            r1 = r61
        L_0x037a:
            if (r2 == 0) goto L_0x037e
            r2 = r11
            goto L_0x0380
        L_0x037e:
            r2 = r62
        L_0x0380:
            if (r3 == 0) goto L_0x0383
            goto L_0x0385
        L_0x0383:
            r11 = r63
        L_0x0385:
            if (r5 == 0) goto L_0x0389
            r3 = 0
            goto L_0x038b
        L_0x0389:
            r3 = r64
        L_0x038b:
            if (r7 == 0) goto L_0x0394
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0396
        L_0x0394:
            r5 = r65
        L_0x0396:
            if (r9 == 0) goto L_0x039f
            androidx.compose.foundation.text.KeyboardOptions$Companion r7 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r7 = r7.getDefault()
            goto L_0x03a1
        L_0x039f:
            r7 = r66
        L_0x03a1:
            if (r16 == 0) goto L_0x03aa
            androidx.compose.foundation.text.KeyboardActions$Companion r9 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r9 = r9.getDefault()
            goto L_0x03ac
        L_0x03aa:
            r9 = r67
        L_0x03ac:
            if (r17 == 0) goto L_0x03b1
            r16 = 0
            goto L_0x03b3
        L_0x03b1:
            r16 = r68
        L_0x03b3:
            r17 = r13 & r23
            if (r17 == 0) goto L_0x03c5
            if (r16 == 0) goto L_0x03bc
            r17 = 1
            goto L_0x03bf
        L_0x03bc:
            r17 = 2147483647(0x7fffffff, float:NaN)
        L_0x03bf:
            r23 = -3670017(0xffffffffffc7ffff, float:NaN)
            r6 = r6 & r23
            goto L_0x03c7
        L_0x03c5:
            r17 = r69
        L_0x03c7:
            if (r19 == 0) goto L_0x03cc
            r19 = 1
            goto L_0x03ce
        L_0x03cc:
            r19 = r70
        L_0x03ce:
            r55 = r1
            if (r20 == 0) goto L_0x03f8
            r1 = 1663548494(0x6327bc4e, float:3.094175E21)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):OutlinedTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            java.lang.Object r1 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r56 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r1 != r2) goto L_0x03f2
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r1)
        L_0x03f2:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r0.endReplaceableGroup()
            goto L_0x03fc
        L_0x03f8:
            r56 = r2
            r1 = r71
        L_0x03fc:
            r2 = r13 & r26
            if (r2 == 0) goto L_0x040f
            androidx.compose.material3.OutlinedTextFieldDefaults r2 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r57 = r1
            r1 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r0, r1)
            r20 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r20
            goto L_0x0414
        L_0x040f:
            r57 = r1
            r1 = 6
            r2 = r72
        L_0x0414:
            r20 = r13 & r25
            r58 = r2
            if (r20 == 0) goto L_0x0429
            androidx.compose.material3.OutlinedTextFieldDefaults r2 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r2 = r2.colors(r0, r1)
            r21 = r21 & -15
            r47 = r57
            r48 = r58
            r49 = r2
            goto L_0x042f
        L_0x0429:
            r47 = r57
            r48 = r58
            r49 = r73
        L_0x042f:
            r13 = r4
            r15 = r6
            r44 = r16
            r45 = r17
            r2 = r18
            r46 = r19
            r1 = r22
            r4 = r56
            r6 = r5
            r5 = r3
            r3 = r55
        L_0x0441:
            r0.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r50 = r0
            if (r16 == 0) goto L_0x0457
            r0 = -1575225237(0xffffffffa21bf86b, float:-2.1137928E-18)
            r55 = r9
            java.lang.String r9 = "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:418)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r15, r9)
            goto L_0x0459
        L_0x0457:
            r55 = r9
        L_0x0459:
            r0 = 2147483646(0x7ffffffe, float:NaN)
            r40 = r13 & r0
            int r0 = r15 << 6
            r9 = r0 & 896(0x380, float:1.256E-42)
            r9 = r9 | 54
            r13 = r0 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r13
            r41 = r9 | r0
            int r0 = r15 >> 24
            r0 = r0 & 126(0x7e, float:1.77E-43)
            r9 = 6
            int r9 = r21 << 6
            r9 = r9 & 896(0x380, float:1.256E-42)
            r42 = r0 | r9
            r43 = 0
            r26 = 0
            r27 = 0
            r16 = r53
            r17 = r54
            r18 = r1
            r19 = r12
            r20 = r2
            r21 = r8
            r22 = r14
            r23 = r10
            r24 = r3
            r25 = r4
            r28 = r11
            r29 = r5
            r30 = r6
            r31 = r7
            r32 = r55
            r33 = r44
            r34 = r45
            r35 = r46
            r36 = r47
            r37 = r48
            r38 = r49
            r39 = r50
            OutlinedTextField((java.lang.String) r16, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r17, (androidx.compose.ui.Modifier) r18, (boolean) r19, (boolean) r20, (androidx.compose.ui.text.TextStyle) r21, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r23, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r24, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r25, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r26, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r27, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r28, (boolean) r29, (androidx.compose.ui.text.input.VisualTransformation) r30, (androidx.compose.foundation.text.KeyboardOptions) r31, (androidx.compose.foundation.text.KeyboardActions) r32, (boolean) r33, (int) r34, (int) r35, (androidx.compose.foundation.interaction.MutableInteractionSource) r36, (androidx.compose.ui.graphics.Shape) r37, (androidx.compose.material3.TextFieldColors) r38, (androidx.compose.runtime.Composer) r39, (int) r40, (int) r41, (int) r42, (int) r43)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04ca
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04ca:
            r15 = r55
            r9 = r3
            r13 = r6
            r6 = r8
            r8 = r10
            r16 = r44
            r17 = r45
            r18 = r46
            r19 = r47
            r20 = r48
            r21 = r49
            r3 = r1
            r10 = r4
            r4 = r12
            r12 = r5
            r5 = r2
            r52 = r14
            r14 = r7
            r7 = r52
        L_0x04e6:
            androidx.compose.runtime.ScopeUpdateScope r2 = r50.endRestartGroup()
            if (r2 == 0) goto L_0x050a
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$8 r26 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$8
            r0 = r26
            r1 = r53
            r51 = r2
            r2 = r54
            r22 = r75
            r23 = r76
            r24 = r77
            r25 = r78
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r0 = r26
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r51
            r1.updateScope(r0)
        L_0x050a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:324:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0131  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue r53, kotlin.jvm.functions.Function1 r54, androidx.compose.ui.Modifier r55, boolean r56, boolean r57, androidx.compose.ui.text.TextStyle r58, kotlin.jvm.functions.Function2 r59, kotlin.jvm.functions.Function2 r60, kotlin.jvm.functions.Function2 r61, kotlin.jvm.functions.Function2 r62, kotlin.jvm.functions.Function2 r63, boolean r64, androidx.compose.ui.text.input.VisualTransformation r65, androidx.compose.foundation.text.KeyboardOptions r66, androidx.compose.foundation.text.KeyboardActions r67, boolean r68, int r69, int r70, androidx.compose.foundation.interaction.MutableInteractionSource r71, androidx.compose.ui.graphics.Shape r72, androidx.compose.material3.TextFieldColors r73, androidx.compose.runtime.Composer r74, int r75, int r76, int r77, int r78) {
        /*
            r15 = r75
            r14 = r76
            r13 = r78
            r0 = -989817544(0xffffffffc5009538, float:-2057.3262)
            r1 = r74
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)455@23152L7,468@23812L39,469@23898L5,470@23961L8,472@23978L771:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001e
            r1 = r15 | 6
            r4 = r1
            r1 = r53
            goto L_0x0032
        L_0x001e:
            r1 = r15 & 6
            if (r1 != 0) goto L_0x002f
            r1 = r53
            boolean r4 = r0.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r15
            goto L_0x0032
        L_0x002f:
            r1 = r53
            r4 = r15
        L_0x0032:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r15 & 48
            if (r5 != 0) goto L_0x004c
            r5 = r54
            boolean r8 = r0.changedInstance(r5)
            if (r8 == 0) goto L_0x0048
            r8 = 32
            goto L_0x004a
        L_0x0048:
            r8 = 16
        L_0x004a:
            r4 = r4 | r8
            goto L_0x004e
        L_0x004c:
            r5 = r54
        L_0x004e:
            r8 = r13 & 4
            if (r8 == 0) goto L_0x0055
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0068
            r11 = r55
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0064
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r12
            goto L_0x006a
        L_0x0068:
            r11 = r55
        L_0x006a:
            r12 = r13 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0075
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0075:
            r2 = r15 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0089
            r2 = r56
            boolean r18 = r0.changed((boolean) r2)
            if (r18 == 0) goto L_0x0084
            r18 = r16
            goto L_0x0086
        L_0x0084:
            r18 = r17
        L_0x0086:
            r4 = r4 | r18
            goto L_0x008b
        L_0x0089:
            r2 = r56
        L_0x008b:
            r18 = r13 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x0094
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0094:
            r6 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x00a8
            r6 = r57
            boolean r21 = r0.changed((boolean) r6)
            if (r21 == 0) goto L_0x00a3
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r21 = r19
        L_0x00a5:
            r4 = r4 | r21
            goto L_0x00aa
        L_0x00a8:
            r6 = r57
        L_0x00aa:
            r21 = 196608(0x30000, float:2.75506E-40)
            r22 = r15 & r21
            r23 = 65536(0x10000, float:9.18355E-41)
            if (r22 != 0) goto L_0x00c6
            r22 = r13 & 32
            r7 = r58
            if (r22 != 0) goto L_0x00c1
            boolean r24 = r0.changed((java.lang.Object) r7)
            if (r24 == 0) goto L_0x00c1
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r24 = r23
        L_0x00c3:
            r4 = r4 | r24
            goto L_0x00c8
        L_0x00c6:
            r7 = r58
        L_0x00c8:
            r24 = r13 & 64
            r25 = 1048576(0x100000, float:1.469368E-39)
            r26 = 524288(0x80000, float:7.34684E-40)
            r27 = 1572864(0x180000, float:2.204052E-39)
            if (r24 == 0) goto L_0x00d7
            r4 = r4 | r27
            r9 = r59
            goto L_0x00ea
        L_0x00d7:
            r27 = r15 & r27
            r9 = r59
            if (r27 != 0) goto L_0x00ea
            boolean r28 = r0.changedInstance(r9)
            if (r28 == 0) goto L_0x00e6
            r28 = r25
            goto L_0x00e8
        L_0x00e6:
            r28 = r26
        L_0x00e8:
            r4 = r4 | r28
        L_0x00ea:
            r10 = r13 & 128(0x80, float:1.794E-43)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00f5
            r4 = r4 | r29
            r3 = r60
            goto L_0x0108
        L_0x00f5:
            r30 = r15 & r29
            r3 = r60
            if (r30 != 0) goto L_0x0108
            boolean r31 = r0.changedInstance(r3)
            if (r31 == 0) goto L_0x0104
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0106
        L_0x0104:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0106:
            r4 = r4 | r31
        L_0x0108:
            r1 = r13 & 256(0x100, float:3.59E-43)
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x0113
            r4 = r4 | r31
            r2 = r61
            goto L_0x0126
        L_0x0113:
            r32 = r15 & r31
            r2 = r61
            if (r32 != 0) goto L_0x0126
            boolean r32 = r0.changedInstance(r2)
            if (r32 == 0) goto L_0x0122
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0124
        L_0x0122:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0124:
            r4 = r4 | r32
        L_0x0126:
            r2 = r13 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0131
            r4 = r4 | r32
            r3 = r62
            goto L_0x0144
        L_0x0131:
            r32 = r15 & r32
            r3 = r62
            if (r32 != 0) goto L_0x0144
            boolean r32 = r0.changedInstance(r3)
            if (r32 == 0) goto L_0x0140
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r4 = r4 | r32
        L_0x0144:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x014d
            r32 = r14 | 6
            r5 = r63
            goto L_0x0163
        L_0x014d:
            r32 = r14 & 6
            r5 = r63
            if (r32 != 0) goto L_0x0161
            boolean r32 = r0.changedInstance(r5)
            if (r32 == 0) goto L_0x015c
            r32 = 4
            goto L_0x015e
        L_0x015c:
            r32 = 2
        L_0x015e:
            r32 = r14 | r32
            goto L_0x0163
        L_0x0161:
            r32 = r14
        L_0x0163:
            r5 = r13 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x016a
            r32 = r32 | 48
            goto L_0x017d
        L_0x016a:
            r33 = r14 & 48
            r6 = r64
            if (r33 != 0) goto L_0x017d
            boolean r33 = r0.changed((boolean) r6)
            if (r33 == 0) goto L_0x0179
            r22 = 32
            goto L_0x017b
        L_0x0179:
            r22 = 16
        L_0x017b:
            r32 = r32 | r22
        L_0x017d:
            r6 = r32
            r7 = r13 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0186
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x019a
        L_0x0186:
            r9 = r14 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x019a
            r9 = r65
            boolean r20 = r0.changed((java.lang.Object) r9)
            if (r20 == 0) goto L_0x0195
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x0197
        L_0x0195:
            r27 = 128(0x80, float:1.794E-43)
        L_0x0197:
            r6 = r6 | r27
            goto L_0x019c
        L_0x019a:
            r9 = r65
        L_0x019c:
            r9 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x01a3
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b5
        L_0x01a3:
            r11 = r14 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x01b5
            r11 = r66
            boolean r20 = r0.changed((java.lang.Object) r11)
            if (r20 == 0) goto L_0x01b0
            goto L_0x01b2
        L_0x01b0:
            r16 = r17
        L_0x01b2:
            r6 = r6 | r16
            goto L_0x01b7
        L_0x01b5:
            r11 = r66
        L_0x01b7:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c0
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r16 = r11
            goto L_0x01d3
        L_0x01c0:
            r16 = r11
            r11 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01d3
            r11 = r67
            boolean r17 = r0.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x01d0
            r19 = 16384(0x4000, float:2.2959E-41)
        L_0x01d0:
            r6 = r6 | r19
            goto L_0x01d5
        L_0x01d3:
            r11 = r67
        L_0x01d5:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r13 & r17
            if (r17 == 0) goto L_0x01e1
            r6 = r6 | r21
            r11 = r68
            goto L_0x01f4
        L_0x01e1:
            r19 = r14 & r21
            r11 = r68
            if (r19 != 0) goto L_0x01f4
            boolean r19 = r0.changed((boolean) r11)
            if (r19 == 0) goto L_0x01f0
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f2
        L_0x01f0:
            r19 = r23
        L_0x01f2:
            r6 = r6 | r19
        L_0x01f4:
            r19 = 1572864(0x180000, float:2.204052E-39)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x020e
            r19 = r13 & r23
            r11 = r69
            if (r19 != 0) goto L_0x0209
            boolean r19 = r0.changed((int) r11)
            if (r19 == 0) goto L_0x0209
            r19 = r25
            goto L_0x020b
        L_0x0209:
            r19 = r26
        L_0x020b:
            r6 = r6 | r19
            goto L_0x0210
        L_0x020e:
            r11 = r69
        L_0x0210:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r13 & r19
            if (r19 == 0) goto L_0x021b
            r6 = r6 | r29
            r11 = r70
            goto L_0x022e
        L_0x021b:
            r20 = r14 & r29
            r11 = r70
            if (r20 != 0) goto L_0x022e
            boolean r20 = r0.changed((int) r11)
            if (r20 == 0) goto L_0x022a
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x022c
        L_0x022a:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x022c:
            r6 = r6 | r20
        L_0x022e:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r13 & r20
            if (r20 == 0) goto L_0x0239
            r6 = r6 | r31
            r11 = r71
            goto L_0x024c
        L_0x0239:
            r21 = r14 & r31
            r11 = r71
            if (r21 != 0) goto L_0x024c
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x0248
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x024a
        L_0x0248:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x024a:
            r6 = r6 | r21
        L_0x024c:
            r21 = 805306368(0x30000000, float:4.656613E-10)
            r21 = r14 & r21
            if (r21 != 0) goto L_0x0266
            r21 = r13 & r26
            r11 = r72
            if (r21 != 0) goto L_0x0261
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x0261
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0263
        L_0x0261:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0263:
            r6 = r6 | r21
            goto L_0x0268
        L_0x0266:
            r11 = r72
        L_0x0268:
            r21 = r77 & 6
            if (r21 != 0) goto L_0x0280
            r21 = r13 & r25
            r11 = r73
            if (r21 != 0) goto L_0x027b
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x027b
            r21 = 4
            goto L_0x027d
        L_0x027b:
            r21 = 2
        L_0x027d:
            r21 = r77 | r21
            goto L_0x0284
        L_0x0280:
            r11 = r73
            r21 = r77
        L_0x0284:
            r22 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r4 & r22
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r14) goto L_0x02d0
            r11 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r11 & r6
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r14) goto L_0x02d0
            r11 = r21 & 3
            r14 = 2
            if (r11 != r14) goto L_0x02d0
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x02a3
            goto L_0x02d0
        L_0x02a3:
            r0.skipToGroupEnd()
            r3 = r55
            r4 = r56
            r5 = r57
            r6 = r58
            r7 = r59
            r8 = r60
            r9 = r61
            r10 = r62
            r11 = r63
            r12 = r64
            r13 = r65
            r14 = r66
            r15 = r67
            r16 = r68
            r17 = r69
            r18 = r70
            r19 = r71
            r20 = r72
            r21 = r73
            r50 = r0
            goto L_0x04e6
        L_0x02d0:
            r0.startDefaults()
            r11 = r15 & 1
            if (r11 == 0) goto L_0x0329
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x02de
            goto L_0x0329
        L_0x02de:
            r0.skipToGroupEnd()
            r1 = r13 & 32
            if (r1 == 0) goto L_0x02e9
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r1
        L_0x02e9:
            r1 = r13 & r23
            if (r1 == 0) goto L_0x02f1
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r6 = r6 & r1
        L_0x02f1:
            r1 = r13 & r26
            if (r1 == 0) goto L_0x02f9
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r1
        L_0x02f9:
            r1 = r13 & r25
            if (r1 == 0) goto L_0x02ff
            r21 = r21 & -15
        L_0x02ff:
            r1 = r55
            r12 = r56
            r2 = r57
            r8 = r58
            r14 = r59
            r10 = r60
            r3 = r61
            r11 = r63
            r5 = r64
            r7 = r66
            r9 = r67
            r44 = r68
            r45 = r69
            r46 = r70
            r47 = r71
            r48 = r72
            r49 = r73
            r13 = r4
            r15 = r6
            r4 = r62
            r6 = r65
            goto L_0x0441
        L_0x0329:
            if (r8 == 0) goto L_0x0330
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            goto L_0x0332
        L_0x0330:
            r8 = r55
        L_0x0332:
            if (r12 == 0) goto L_0x0336
            r12 = 1
            goto L_0x0338
        L_0x0336:
            r12 = r56
        L_0x0338:
            if (r18 == 0) goto L_0x033d
            r18 = 0
            goto L_0x033f
        L_0x033d:
            r18 = r57
        L_0x033f:
            r22 = r13 & 32
            if (r22 == 0) goto L_0x0363
            androidx.compose.runtime.ProvidableCompositionLocal r22 = androidx.compose.material3.TextKt.getLocalTextStyle()
            r11 = r22
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r22 = r8
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r8)
            java.lang.Object r8 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r8 = (androidx.compose.ui.text.TextStyle) r8
            r11 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r11
            goto L_0x0367
        L_0x0363:
            r22 = r8
            r8 = r58
        L_0x0367:
            r11 = 0
            if (r24 == 0) goto L_0x036c
            r14 = r11
            goto L_0x036e
        L_0x036c:
            r14 = r59
        L_0x036e:
            if (r10 == 0) goto L_0x0372
            r10 = r11
            goto L_0x0374
        L_0x0372:
            r10 = r60
        L_0x0374:
            if (r1 == 0) goto L_0x0378
            r1 = r11
            goto L_0x037a
        L_0x0378:
            r1 = r61
        L_0x037a:
            if (r2 == 0) goto L_0x037e
            r2 = r11
            goto L_0x0380
        L_0x037e:
            r2 = r62
        L_0x0380:
            if (r3 == 0) goto L_0x0383
            goto L_0x0385
        L_0x0383:
            r11 = r63
        L_0x0385:
            if (r5 == 0) goto L_0x0389
            r3 = 0
            goto L_0x038b
        L_0x0389:
            r3 = r64
        L_0x038b:
            if (r7 == 0) goto L_0x0394
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0396
        L_0x0394:
            r5 = r65
        L_0x0396:
            if (r9 == 0) goto L_0x039f
            androidx.compose.foundation.text.KeyboardOptions$Companion r7 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r7 = r7.getDefault()
            goto L_0x03a1
        L_0x039f:
            r7 = r66
        L_0x03a1:
            if (r16 == 0) goto L_0x03aa
            androidx.compose.foundation.text.KeyboardActions$Companion r9 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r9 = r9.getDefault()
            goto L_0x03ac
        L_0x03aa:
            r9 = r67
        L_0x03ac:
            if (r17 == 0) goto L_0x03b1
            r16 = 0
            goto L_0x03b3
        L_0x03b1:
            r16 = r68
        L_0x03b3:
            r17 = r13 & r23
            if (r17 == 0) goto L_0x03c5
            if (r16 == 0) goto L_0x03bc
            r17 = 1
            goto L_0x03bf
        L_0x03bc:
            r17 = 2147483647(0x7fffffff, float:NaN)
        L_0x03bf:
            r23 = -3670017(0xffffffffffc7ffff, float:NaN)
            r6 = r6 & r23
            goto L_0x03c7
        L_0x03c5:
            r17 = r69
        L_0x03c7:
            if (r19 == 0) goto L_0x03cc
            r19 = 1
            goto L_0x03ce
        L_0x03cc:
            r19 = r70
        L_0x03ce:
            r55 = r1
            if (r20 == 0) goto L_0x03f8
            r1 = 1663550460(0x6327c3fc, float:3.0947284E21)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):OutlinedTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            java.lang.Object r1 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r56 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r1 != r2) goto L_0x03f2
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r1)
        L_0x03f2:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r0.endReplaceableGroup()
            goto L_0x03fc
        L_0x03f8:
            r56 = r2
            r1 = r71
        L_0x03fc:
            r2 = r13 & r26
            if (r2 == 0) goto L_0x040f
            androidx.compose.material3.OutlinedTextFieldDefaults r2 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r57 = r1
            r1 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r0, r1)
            r20 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r20
            goto L_0x0414
        L_0x040f:
            r57 = r1
            r1 = 6
            r2 = r72
        L_0x0414:
            r20 = r13 & r25
            r58 = r2
            if (r20 == 0) goto L_0x0429
            androidx.compose.material3.OutlinedTextFieldDefaults r2 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r2 = r2.colors(r0, r1)
            r21 = r21 & -15
            r47 = r57
            r48 = r58
            r49 = r2
            goto L_0x042f
        L_0x0429:
            r47 = r57
            r48 = r58
            r49 = r73
        L_0x042f:
            r13 = r4
            r15 = r6
            r44 = r16
            r45 = r17
            r2 = r18
            r46 = r19
            r1 = r22
            r4 = r56
            r6 = r5
            r5 = r3
            r3 = r55
        L_0x0441:
            r0.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r50 = r0
            if (r16 == 0) goto L_0x0457
            r0 = -989817544(0xffffffffc5009538, float:-2057.3262)
            r55 = r9
            java.lang.String r9 = "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:471)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r15, r9)
            goto L_0x0459
        L_0x0457:
            r55 = r9
        L_0x0459:
            r0 = 2147483646(0x7ffffffe, float:NaN)
            r40 = r13 & r0
            int r0 = r15 << 6
            r9 = r0 & 896(0x380, float:1.256E-42)
            r9 = r9 | 54
            r13 = r0 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            r13 = r13 & r0
            r9 = r9 | r13
            r13 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r13
            r41 = r9 | r0
            int r0 = r15 >> 24
            r0 = r0 & 126(0x7e, float:1.77E-43)
            r9 = 6
            int r9 = r21 << 6
            r9 = r9 & 896(0x380, float:1.256E-42)
            r42 = r0 | r9
            r43 = 0
            r26 = 0
            r27 = 0
            r16 = r53
            r17 = r54
            r18 = r1
            r19 = r12
            r20 = r2
            r21 = r8
            r22 = r14
            r23 = r10
            r24 = r3
            r25 = r4
            r28 = r11
            r29 = r5
            r30 = r6
            r31 = r7
            r32 = r55
            r33 = r44
            r34 = r45
            r35 = r46
            r36 = r47
            r37 = r48
            r38 = r49
            r39 = r50
            OutlinedTextField((androidx.compose.ui.text.input.TextFieldValue) r16, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r17, (androidx.compose.ui.Modifier) r18, (boolean) r19, (boolean) r20, (androidx.compose.ui.text.TextStyle) r21, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r23, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r24, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r25, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r26, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r27, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r28, (boolean) r29, (androidx.compose.ui.text.input.VisualTransformation) r30, (androidx.compose.foundation.text.KeyboardOptions) r31, (androidx.compose.foundation.text.KeyboardActions) r32, (boolean) r33, (int) r34, (int) r35, (androidx.compose.foundation.interaction.MutableInteractionSource) r36, (androidx.compose.ui.graphics.Shape) r37, (androidx.compose.material3.TextFieldColors) r38, (androidx.compose.runtime.Composer) r39, (int) r40, (int) r41, (int) r42, (int) r43)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04ca
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04ca:
            r15 = r55
            r9 = r3
            r13 = r6
            r6 = r8
            r8 = r10
            r16 = r44
            r17 = r45
            r18 = r46
            r19 = r47
            r20 = r48
            r21 = r49
            r3 = r1
            r10 = r4
            r4 = r12
            r12 = r5
            r5 = r2
            r52 = r14
            r14 = r7
            r7 = r52
        L_0x04e6:
            androidx.compose.runtime.ScopeUpdateScope r2 = r50.endRestartGroup()
            if (r2 == 0) goto L_0x050a
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$10 r26 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$10
            r0 = r26
            r1 = r53
            r51 = r2
            r2 = r54
            r22 = r75
            r23 = r76
            r24 = r77
            r25 = r78
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r0 = r26
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r51
            r1.updateScope(r0)
        L_0x050a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z, float f, Function1<? super Size, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, PaddingValues paddingValues, Composer composer, int i, int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        float f2;
        float f3;
        Function2<? super Composer, ? super Integer, Unit> function29 = function2;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function210 = function22;
        Function2<? super Composer, ? super Integer, Unit> function211 = function23;
        Function2<? super Composer, ? super Integer, Unit> function212 = function24;
        Function2<? super Composer, ? super Integer, Unit> function213 = function25;
        Function2<? super Composer, ? super Integer, Unit> function214 = function26;
        boolean z2 = z;
        float f4 = f;
        Function1<? super Size, Unit> function12 = function1;
        Function2<? super Composer, ? super Integer, Unit> function215 = function27;
        Function2<? super Composer, ? super Integer, Unit> function216 = function28;
        PaddingValues paddingValues3 = paddingValues;
        int i7 = i;
        int i8 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)522@25593L239,530@25880L7,531@25892L3534:OutlinedTextField.kt#uh7d8r");
        if ((i7 & 6) == 0) {
            i3 = i7 | (startRestartGroup.changed((Object) modifier) ? 4 : 2);
        } else {
            Modifier modifier2 = modifier;
            i3 = i7;
        }
        int i9 = 16;
        if ((i7 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function29) ? 32 : 16;
        }
        if ((i7 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function32) ? 256 : 128;
        }
        if ((i7 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function210) ? 2048 : 1024;
        }
        if ((i7 & CpioConstants.C_ISBLK) == 0) {
            i3 |= startRestartGroup.changedInstance(function211) ? 16384 : 8192;
        }
        if ((196608 & i7) == 0) {
            i3 |= startRestartGroup.changedInstance(function212) ? 131072 : 65536;
        }
        if ((1572864 & i7) == 0) {
            i3 |= startRestartGroup.changedInstance(function213) ? 1048576 : 524288;
        }
        if ((12582912 & i7) == 0) {
            i3 |= startRestartGroup.changedInstance(function214) ? 8388608 : 4194304;
        }
        if ((100663296 & i7) == 0) {
            i3 |= startRestartGroup.changed(z2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i7) == 0) {
            i3 |= startRestartGroup.changed(f4) ? 536870912 : 268435456;
        }
        int i10 = i3;
        if ((i8 & 6) == 0) {
            i4 = i8 | (startRestartGroup.changedInstance(function12) ? 4 : 2);
        } else {
            i4 = i8;
        }
        if ((i8 & 48) == 0) {
            if (startRestartGroup.changedInstance(function215)) {
                i9 = 32;
            }
            i4 |= i9;
        }
        if ((i8 & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function28) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function217 = function28;
        }
        if ((i8 & 3072) == 0) {
            paddingValues2 = paddingValues;
            i4 |= startRestartGroup.changed((Object) paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        int i11 = i4;
        if ((i10 & 306783379) == 306783378 && (i11 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            Function2<? super Composer, ? super Integer, Unit> function218 = function22;
            Function2<? super Composer, ? super Integer, Unit> function219 = function28;
            float f5 = f4;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408290209, i10, i11, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:521)");
            }
            startRestartGroup.startReplaceableGroup(-2058767641);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):OutlinedTextField.kt#9igjgp");
            boolean z3 = ((i11 & 14) == 4) | ((234881024 & i10) == 67108864) | ((1879048192 & i10) == 536870912) | ((i11 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(function12, z2, f4, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
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
            Updater.m3289setimpl(r3, outlinedTextFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r3.getInserting() || !Intrinsics.areEqual(r3.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1116455288, "C534@25961L11,604@28446L228:OutlinedTextField.kt#uh7d8r");
            function215.invoke(startRestartGroup, Integer.valueOf((i11 >> 3) & 14));
            startRestartGroup.startReplaceableGroup(1116455313);
            ComposerKt.sourceInformation(startRestartGroup, "537@26025L219");
            if (function211 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.Companion.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                i5 = i11;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r1 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r1, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r1, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r1.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828313575, "C541@26217L9:OutlinedTextField.kt#uh7d8r");
                function211.invoke(startRestartGroup, Integer.valueOf((i10 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                i5 = i11;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116455598);
            ComposerKt.sourceInformation(startRestartGroup, "545@26311L221");
            if (function212 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.Companion.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(then2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r11 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r11, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r11, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r11.getInserting() || !Intrinsics.areEqual(r11.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r11.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828313288, "C549@26504L10:OutlinedTextField.kt#uh7d8r");
                function212.invoke(startRestartGroup, Integer.valueOf((i10 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function211 != null) {
                i6 = 0;
                calculateStartPadding = Dp.m6614constructorimpl(RangesKt.coerceAtLeast(Dp.m6614constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6614constructorimpl((float) 0)));
            } else {
                i6 = 0;
            }
            if (function212 != null) {
                calculateEndPadding = Dp.m6614constructorimpl(RangesKt.coerceAtLeast(Dp.m6614constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6614constructorimpl((float) i6)));
            }
            startRestartGroup.startReplaceableGroup(1116456488);
            ComposerKt.sourceInformation(startRestartGroup, "568@27199L334");
            if (function213 != null) {
                Modifier r5 = PaddingKt.m674paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m730heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), calculateStartPadding, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(r5);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r2 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r2, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                    r2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    r2.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                modifierMaterializerOf4.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828312285, "C575@27507L8:OutlinedTextField.kt#uh7d8r");
                function213.invoke(startRestartGroup, Integer.valueOf((i10 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116456887);
            ComposerKt.sourceInformation(startRestartGroup, "579@27598L332");
            Function2<? super Composer, ? super Integer, Unit> function220 = function26;
            if (function220 != null) {
                Modifier r22 = PaddingKt.m674paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m730heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, calculateEndPadding, 0.0f, 10, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(r22);
                f2 = calculateEndPadding;
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r0 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r0, rememberBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r0, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash5))) {
                    r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    r0.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                modifierMaterializerOf5.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828311888, "C586@27904L8:OutlinedTextField.kt#uh7d8r");
                function220.invoke(startRestartGroup, Integer.valueOf((i10 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                f2 = calculateEndPadding;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m730heightInVpY3zN4$default(Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            if (function213 != null) {
                calculateStartPadding = Dp.m6614constructorimpl((float) 0);
            }
            float f6 = calculateStartPadding;
            if (function220 == null) {
                f3 = f2;
            } else {
                f3 = Dp.m6614constructorimpl((float) 0);
            }
            Modifier r02 = PaddingKt.m674paddingqDBjuR0$default(wrapContentHeight$default, f6, 0.0f, f3, 0.0f, 10, (Object) null);
            startRestartGroup.startReplaceableGroup(1116457597);
            ComposerKt.sourceInformation(startRestartGroup, "599@28313L105");
            Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function33 = function3;
            if (function33 != null) {
                function33.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(r02), startRestartGroup, Integer.valueOf((i10 >> 3) & 112));
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(r02);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(then3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor6);
            } else {
                startRestartGroup.useNode();
            }
            Composer r112 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r112, rememberBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r112, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r112.getInserting() || !Intrinsics.areEqual(r112.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash6))) {
                r112.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                r112.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            modifierMaterializerOf6.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828311143, "C610@28649L11:OutlinedTextField.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf((i10 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116458015);
            ComposerKt.sourceInformation(startRestartGroup, "614@28725L237");
            Function2<? super Composer, ? super Integer, Unit> function221 = function22;
            if (function221 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.m730heightInVpY3zN4$default(Modifier.Companion, DpKt.m6657lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), TextFieldImplKt.LabelId);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(layoutId);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor7);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r6 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r6, rememberBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r6, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash7))) {
                    r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                    r6.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                }
                modifierMaterializerOf7.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828310839, "C618@28953L7:OutlinedTextField.kt#uh7d8r");
                function221.invoke(startRestartGroup, Integer.valueOf((i10 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                float f7 = f;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-2058764244);
            ComposerKt.sourceInformation(startRestartGroup, "623@29088L269");
            Function2<? super Composer, ? super Integer, Unit> function222 = function28;
            if (function222 != null) {
                Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m730heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), TextFieldDefaults.m2421supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, (Object) null));
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(padding);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r9 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r9, rememberBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r9, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash8))) {
                    r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    r9.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                modifierMaterializerOf8.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828310449, "C628@29343L12:OutlinedTextField.kt#uh7d8r");
                function222.invoke(startRestartGroup, Integer.valueOf((i5 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new OutlinedTextFieldKt$OutlinedTextFieldLayout$2(modifier, function2, function3, function22, function23, function24, function25, function26, z, f, function1, function27, function28, paddingValues, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-DHJA7U0  reason: not valid java name */
    public static final int m2049calculateWidthDHJA7U0(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, float f2, PaddingValues paddingValues) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, MathHelpersKt.lerp(i6, 0, f))) + i2, Math.max(MathKt.roundToInt((((float) i6) + (Dp.m6614constructorimpl(paddingValues.m685calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.m686calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * f2)) * f), Constraints.m6528getMinWidthimpl(j)));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc  reason: not valid java name */
    public static final int m2048calculateHeightmKXJcVc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, long j, float f2, PaddingValues paddingValues) {
        int maxOf = ComparisonsKt.maxOf(i5, i7, i3, i4, MathHelpersKt.lerp(i6, 0, f));
        float r4 = paddingValues.m687calculateTopPaddingD9Ej5fM() * f2;
        return Math.max(Constraints.m6527getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(MathHelpersKt.lerp(r4, Math.max(r4, ((float) i6) / 2.0f), f) + ((float) maxOf) + (paddingValues.m684calculateBottomPaddingD9Ej5fM() * f2)))) + i8);
    }

    /* access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        float f3;
        Placeable placeable10 = placeable3;
        Placeable placeable11 = placeable4;
        Placeable placeable12 = placeable6;
        Placeable placeable13 = placeable7;
        float f4 = f;
        boolean z2 = z;
        Placeable.PlacementScope.m5409place70tqf50$default(placementScope, placeable8, IntOffset.Companion.m6758getZeronOccac(), 0.0f, 2, (Object) null);
        int heightOrZero = i - TextFieldImplKt.heightOrZero(placeable9);
        int roundToInt = MathKt.roundToInt(paddingValues.m687calculateTopPaddingD9Ej5fM() * f2);
        int roundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.Companion.getCenterVertically().align(placeable.getHeight(), heightOrZero), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), heightOrZero), 0.0f, 4, (Object) null);
        }
        if (placeable12 != null) {
            int lerp = MathHelpersKt.lerp(z2 ? Alignment.Companion.getCenterVertically().align(placeable6.getHeight(), heightOrZero) : roundToInt, -(placeable6.getHeight() / 2), f4);
            if (placeable == null) {
                f3 = 0.0f;
            } else {
                f3 = (((float) TextFieldImplKt.widthOrZero(placeable)) - horizontalIconPadding) * (((float) 1) - f4);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, MathKt.roundToInt(f3) + roundToInt2, lerp, 0.0f, 4, (Object) null);
        }
        if (placeable10 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), place$calculateVerticalPosition(z2, heightOrZero, roundToInt, placeable12, placeable10), 0.0f, 4, (Object) null);
        }
        if (placeable11 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (i2 - TextFieldImplKt.widthOrZero(placeable2)) - placeable4.getWidth(), place$calculateVerticalPosition(z2, heightOrZero, roundToInt, placeable12, placeable11), 0.0f, 4, (Object) null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, widthOrZero, place$calculateVerticalPosition(z2, heightOrZero, roundToInt, placeable12, placeable5), 0.0f, 4, (Object) null);
        if (placeable13 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, widthOrZero, place$calculateVerticalPosition(z2, heightOrZero, roundToInt, placeable12, placeable13), 0.0f, 4, (Object) null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, heightOrZero, 0.0f, 4, (Object) null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable, Placeable placeable2) {
        if (z) {
            i2 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i);
        }
        return Math.max(i2, TextFieldImplKt.heightOrZero(placeable) / 2);
    }

    /* renamed from: outlineCutout-12SF9DM  reason: not valid java name */
    public static final Modifier m2050outlineCutout12SF9DM(Modifier modifier, long j, PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new OutlinedTextFieldKt$outlineCutout$1(j, paddingValues));
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
