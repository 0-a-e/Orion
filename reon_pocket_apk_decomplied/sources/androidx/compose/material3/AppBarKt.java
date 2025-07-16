package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001al\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001ax\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0007\u001a\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0010;\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0010<\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0001\u0010=\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010%\u001a\u0004\u0018\u000109H\u0003¢\u0006\u0002\u0010B\u001a\u0010C\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0010D\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a£\u0001\u0010E\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020A2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001aµ\u0001\u0010T\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010O\u001a\u00020\u00012\u0011\u0010U\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010V\u001a\u00020?2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\u0006\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\u00012\b\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a+\u0010[\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010\\\u001a+\u0010]\u001a\u00020^2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010_\u001a>\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020^2\u0006\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010gH@¢\u0006\u0002\u0010h\u001a>\u0010i\u001a\u00020a2\u0006\u0010b\u001a\u00020/2\u0006\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010gH@¢\u0006\u0002\u0010j\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k²\u0006\n\u0010l\u001a\u00020\u001cX\u0002"}, d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "scrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "MediumTopAppBar", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "TopAppBar", "TopAppBarLayout", "heightPx", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "maxHeight", "pinnedHeight", "TwoRowsTopAppBar-tjU4iQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;FFLandroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberBottomAppBarState", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settleAppBarBottom", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release", "appBarContainerColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
public final class AppBarKt {
    /* access modifiers changed from: private */
    public static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    /* access modifiers changed from: private */
    public static final float FABHorizontalPadding;
    /* access modifiers changed from: private */
    public static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding = Dp.m6614constructorimpl((float) 28);
    private static final float MediumTitleBottomPadding = Dp.m6614constructorimpl((float) 24);
    private static final float TopAppBarHorizontalPadding;
    /* access modifiers changed from: private */
    public static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.material3.TopAppBarColors r26, androidx.compose.material3.TopAppBarScrollBehavior r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r8 = r29
            r0 = 1906353009(0x71a0a371, float:1.5908861E30)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(TopAppBar)P(5,2,3!1,6)126@6292L12,127@6354L17,133@6544L10,130@6433L374:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r30 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 6
            r3 = r2
            r2 = r21
            goto L_0x002e
        L_0x001a:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r21
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r8
            goto L_0x002e
        L_0x002b:
            r2 = r21
            r3 = r8
        L_0x002e:
            r4 = r30 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0048
            r5 = r22
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0044
            r6 = 32
            goto L_0x0046
        L_0x0044:
            r6 = 16
        L_0x0046:
            r3 = r3 | r6
            goto L_0x004a
        L_0x0048:
            r5 = r22
        L_0x004a:
            r6 = r30 & 4
            if (r6 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r23
            boolean r9 = r1.changedInstance(r7)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r7 = r23
        L_0x0066:
            r9 = r30 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0080
            r10 = r24
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x007c
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r11
            goto L_0x0082
        L_0x0080:
            r10 = r24
        L_0x0082:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009b
            r11 = r30 & 16
            if (r11 != 0) goto L_0x0095
            r11 = r25
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r11 = r25
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r25
        L_0x009d:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b7
            r12 = r30 & 32
            if (r12 != 0) goto L_0x00b1
            r12 = r26
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b3
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r12 = r26
        L_0x00b3:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r13
            goto L_0x00b9
        L_0x00b7:
            r12 = r26
        L_0x00b9:
            r13 = r30 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00c1
            r3 = r3 | r14
            goto L_0x00d3
        L_0x00c1:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d3
            r14 = r27
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cf
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r15
            goto L_0x00d5
        L_0x00d3:
            r14 = r27
        L_0x00d5:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r3
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ee
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00ee
        L_0x00e5:
            r1.skipToGroupEnd()
            r3 = r7
            r4 = r10
            r6 = r12
            r7 = r14
            goto L_0x01be
        L_0x00ee:
            r1.startDefaults()
            r0 = r8 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r15 = 6
            if (r0 == 0) goto L_0x0118
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0100
            goto L_0x0118
        L_0x0100:
            r1.skipToGroupEnd()
            r0 = r30 & 16
            if (r0 == 0) goto L_0x0109
            r3 = r3 & r17
        L_0x0109:
            r0 = r30 & 32
            if (r0 == 0) goto L_0x0111
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r0
        L_0x0111:
            r9 = r3
            r0 = r5
        L_0x0113:
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r14
            goto L_0x0159
        L_0x0118:
            if (r4 == 0) goto L_0x011f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0120
        L_0x011f:
            r0 = r5
        L_0x0120:
            if (r6 == 0) goto L_0x0129
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r4 = r4.m1691getLambda1$material3_release()
            r7 = r4
        L_0x0129:
            if (r9 == 0) goto L_0x0132
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1695getLambda2$material3_release()
            r10 = r4
        L_0x0132:
            r4 = r30 & 16
            if (r4 == 0) goto L_0x013f
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r1, r15)
            r3 = r3 & r17
            r11 = r4
        L_0x013f:
            r4 = r30 & 32
            if (r4 == 0) goto L_0x014e
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r4 = r4.topAppBarColors(r1, r15)
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r5
            r12 = r4
        L_0x014e:
            if (r13 == 0) goto L_0x0157
            r4 = 0
            r9 = r3
            r6 = r4
            r3 = r10
            r4 = r11
            r5 = r12
            goto L_0x0159
        L_0x0157:
            r9 = r3
            goto L_0x0113
        L_0x0159:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x016b
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.TopAppBar (AppBar.kt:129)"
            r12 = 1906353009(0x71a0a371, float:1.5908861E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r9, r10, r11)
        L_0x016b:
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r10 = r10.getTypography(r1, r15)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r11 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r11 = r11.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r11 = androidx.compose.material3.TypographyKt.fromToken(r10, r11)
            int r10 = r9 >> 3
            r10 = r10 & 14
            r10 = r10 | 3072(0xc00, float:4.305E-42)
            int r12 = r9 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r10 = r10 | r12
            int r9 = r9 << r15
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r9
            r10 = r10 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r9
            r10 = r10 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r9
            r10 = r10 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r9
            r10 = r10 | r12
            r12 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r12
            r19 = r10 | r9
            r20 = 0
            r12 = 0
            r9 = r0
            r10 = r21
            r13 = r7
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r1
            SingleRowTopAppBar(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01b8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b8:
            r11 = r4
            r4 = r3
            r3 = r7
            r7 = r6
            r6 = r5
            r5 = r0
        L_0x01be:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x01d7
            androidx.compose.material3.AppBarKt$TopAppBar$1 r12 = new androidx.compose.material3.AppBarKt$TopAppBar$1
            r0 = r12
            r1 = r21
            r2 = r5
            r5 = r11
            r8 = r29
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r10.updateScope(r12)
        L_0x01d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.TopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ee  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @kotlin.ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SmallTopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.foundation.layout.WindowInsets r23, androidx.compose.material3.TopAppBarColors r24, androidx.compose.material3.TopAppBarScrollBehavior r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r8 = r27
            r0 = -1967617284(0xffffffff8ab88afc, float:-1.7770836E-32)
            r1 = r26
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(SmallTopAppBar)P(5,2,3!1,6)189@9271L12,190@9333L17,192@9408L89:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r28 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 6
            r3 = r2
            r2 = r19
            goto L_0x002e
        L_0x001a:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r19
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r8
            goto L_0x002e
        L_0x002b:
            r2 = r19
            r3 = r8
        L_0x002e:
            r4 = r28 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0048
            r5 = r20
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0044
            r6 = 32
            goto L_0x0046
        L_0x0044:
            r6 = 16
        L_0x0046:
            r3 = r3 | r6
            goto L_0x004a
        L_0x0048:
            r5 = r20
        L_0x004a:
            r6 = r28 & 4
            if (r6 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r21
            boolean r9 = r1.changedInstance(r7)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r7 = r21
        L_0x0066:
            r9 = r28 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0080
            r10 = r22
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x007c
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r11
            goto L_0x0082
        L_0x0080:
            r10 = r22
        L_0x0082:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009b
            r11 = r28 & 16
            if (r11 != 0) goto L_0x0095
            r11 = r23
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r11 = r23
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r23
        L_0x009d:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b7
            r12 = r28 & 32
            if (r12 != 0) goto L_0x00b1
            r12 = r24
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b3
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r12 = r24
        L_0x00b3:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r13
            goto L_0x00b9
        L_0x00b7:
            r12 = r24
        L_0x00b9:
            r13 = r28 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00c1
            r3 = r3 | r14
            goto L_0x00d3
        L_0x00c1:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d3
            r14 = r25
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cf
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r15
            goto L_0x00d5
        L_0x00d3:
            r14 = r25
        L_0x00d5:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r3
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ee
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00ee
        L_0x00e5:
            r1.skipToGroupEnd()
            r3 = r7
            r4 = r10
            r6 = r12
            r7 = r14
            goto L_0x018b
        L_0x00ee:
            r1.startDefaults()
            r0 = r8 & 1
            r15 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0117
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0102
            goto L_0x0117
        L_0x0102:
            r1.skipToGroupEnd()
            r0 = r28 & 16
            if (r0 == 0) goto L_0x010b
            r3 = r3 & r17
        L_0x010b:
            r0 = r28 & 32
            if (r0 == 0) goto L_0x0110
            r3 = r3 & r15
        L_0x0110:
            r9 = r3
            r0 = r5
        L_0x0112:
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r14
            goto L_0x0156
        L_0x0117:
            if (r4 == 0) goto L_0x011e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x011f
        L_0x011e:
            r0 = r5
        L_0x011f:
            if (r6 == 0) goto L_0x0128
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r4 = r4.m1696getLambda3$material3_release()
            r7 = r4
        L_0x0128:
            if (r9 == 0) goto L_0x0131
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1697getLambda4$material3_release()
            r10 = r4
        L_0x0131:
            r4 = r28 & 16
            r5 = 6
            if (r4 == 0) goto L_0x013f
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r1, r5)
            r3 = r3 & r17
            r11 = r4
        L_0x013f:
            r4 = r28 & 32
            if (r4 == 0) goto L_0x014b
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r4 = r4.topAppBarColors(r1, r5)
            r3 = r3 & r15
            r12 = r4
        L_0x014b:
            if (r13 == 0) goto L_0x0154
            r4 = 0
            r9 = r3
            r6 = r4
            r3 = r10
            r4 = r11
            r5 = r12
            goto L_0x0156
        L_0x0154:
            r9 = r3
            goto L_0x0112
        L_0x0156:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0168
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.SmallTopAppBar (AppBar.kt:192)"
            r12 = -1967617284(0xffffffff8ab88afc, float:-1.7770836E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r9, r10, r11)
        L_0x0168:
            r10 = 4194302(0x3ffffe, float:5.877469E-39)
            r17 = r9 & r10
            r18 = 0
            r9 = r19
            r10 = r0
            r11 = r7
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r1
            TopAppBar(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0185
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0185:
            r11 = r4
            r4 = r3
            r3 = r7
            r7 = r6
            r6 = r5
            r5 = r0
        L_0x018b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x01a4
            androidx.compose.material3.AppBarKt$SmallTopAppBar$1 r12 = new androidx.compose.material3.AppBarKt$SmallTopAppBar$1
            r0 = r12
            r1 = r19
            r2 = r5
            r5 = r11
            r8 = r27
            r9 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r10.updateScope(r12)
        L_0x01a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SmallTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CenterAlignedTopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.material3.TopAppBarColors r26, androidx.compose.material3.TopAppBarScrollBehavior r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r8 = r29
            r0 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(CenterAlignedTopAppBar)P(5,2,3!1,6)230@11690L12,231@11752L30,238@11963L10,234@11844L381:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r30 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 6
            r3 = r2
            r2 = r21
            goto L_0x002e
        L_0x001a:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r21
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r8
            goto L_0x002e
        L_0x002b:
            r2 = r21
            r3 = r8
        L_0x002e:
            r4 = r30 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0048
            r5 = r22
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0044
            r6 = 32
            goto L_0x0046
        L_0x0044:
            r6 = 16
        L_0x0046:
            r3 = r3 | r6
            goto L_0x004a
        L_0x0048:
            r5 = r22
        L_0x004a:
            r6 = r30 & 4
            if (r6 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r23
            boolean r9 = r1.changedInstance(r7)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r7 = r23
        L_0x0066:
            r9 = r30 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0080
            r10 = r24
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x007c
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r11
            goto L_0x0082
        L_0x0080:
            r10 = r24
        L_0x0082:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009b
            r11 = r30 & 16
            if (r11 != 0) goto L_0x0095
            r11 = r25
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r11 = r25
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r25
        L_0x009d:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b7
            r12 = r30 & 32
            if (r12 != 0) goto L_0x00b1
            r12 = r26
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b3
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r12 = r26
        L_0x00b3:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r13
            goto L_0x00b9
        L_0x00b7:
            r12 = r26
        L_0x00b9:
            r13 = r30 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00c1
            r3 = r3 | r14
            goto L_0x00d3
        L_0x00c1:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d3
            r14 = r27
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cf
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r15
            goto L_0x00d5
        L_0x00d3:
            r14 = r27
        L_0x00d5:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r3
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ee
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00ee
        L_0x00e5:
            r1.skipToGroupEnd()
            r3 = r7
            r4 = r10
            r6 = r12
            r7 = r14
            goto L_0x01be
        L_0x00ee:
            r1.startDefaults()
            r0 = r8 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r15 = 6
            if (r0 == 0) goto L_0x0118
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0100
            goto L_0x0118
        L_0x0100:
            r1.skipToGroupEnd()
            r0 = r30 & 16
            if (r0 == 0) goto L_0x0109
            r3 = r3 & r17
        L_0x0109:
            r0 = r30 & 32
            if (r0 == 0) goto L_0x0111
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r0
        L_0x0111:
            r9 = r3
            r0 = r5
        L_0x0113:
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r14
            goto L_0x0159
        L_0x0118:
            if (r4 == 0) goto L_0x011f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0120
        L_0x011f:
            r0 = r5
        L_0x0120:
            if (r6 == 0) goto L_0x0129
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r4 = r4.m1698getLambda5$material3_release()
            r7 = r4
        L_0x0129:
            if (r9 == 0) goto L_0x0132
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1699getLambda6$material3_release()
            r10 = r4
        L_0x0132:
            r4 = r30 & 16
            if (r4 == 0) goto L_0x013f
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r1, r15)
            r3 = r3 & r17
            r11 = r4
        L_0x013f:
            r4 = r30 & 32
            if (r4 == 0) goto L_0x014e
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r4 = r4.centerAlignedTopAppBarColors(r1, r15)
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r5
            r12 = r4
        L_0x014e:
            if (r13 == 0) goto L_0x0157
            r4 = 0
            r9 = r3
            r6 = r4
            r3 = r10
            r4 = r11
            r5 = r12
            goto L_0x0159
        L_0x0157:
            r9 = r3
            goto L_0x0113
        L_0x0159:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x016b
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:233)"
            r12 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r9, r10, r11)
        L_0x016b:
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r10 = r10.getTypography(r1, r15)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r11 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r11 = r11.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r11 = androidx.compose.material3.TypographyKt.fromToken(r10, r11)
            int r10 = r9 >> 3
            r10 = r10 & 14
            r10 = r10 | 3072(0xc00, float:4.305E-42)
            int r12 = r9 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r10 = r10 | r12
            int r9 = r9 << r15
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r9
            r10 = r10 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r9
            r10 = r10 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r9
            r10 = r10 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r9
            r10 = r10 | r12
            r12 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r12
            r19 = r10 | r9
            r20 = 0
            r12 = 1
            r9 = r0
            r10 = r21
            r13 = r7
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r1
            SingleRowTopAppBar(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01b8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b8:
            r11 = r4
            r4 = r3
            r3 = r7
            r7 = r6
            r6 = r5
            r5 = r0
        L_0x01be:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x01d7
            androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1 r12 = new androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1
            r0 = r12
            r1 = r21
            r2 = r5
            r5 = r11
            r8 = r29
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r10.updateScope(r12)
        L_0x01d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MediumTopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.foundation.layout.WindowInsets r30, androidx.compose.material3.TopAppBarColors r31, androidx.compose.material3.TopAppBarScrollBehavior r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r8 = r34
            r0 = 1805417862(0x6b9c7d86, float:3.783704E26)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(MediumTopAppBar)P(5,2,3!1,6)285@14543L12,286@14605L23,292@14799L10,293@14901L10,289@14690L646:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 6
            r3 = r2
            r2 = r26
            goto L_0x002e
        L_0x001a:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r26
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r8
            goto L_0x002e
        L_0x002b:
            r2 = r26
            r3 = r8
        L_0x002e:
            r4 = r35 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0048
            r5 = r27
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0044
            r6 = 32
            goto L_0x0046
        L_0x0044:
            r6 = 16
        L_0x0046:
            r3 = r3 | r6
            goto L_0x004a
        L_0x0048:
            r5 = r27
        L_0x004a:
            r6 = r35 & 4
            if (r6 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r28
            boolean r9 = r1.changedInstance(r7)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r7 = r28
        L_0x0066:
            r9 = r35 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0080
            r10 = r29
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x007c
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r11
            goto L_0x0082
        L_0x0080:
            r10 = r29
        L_0x0082:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009b
            r11 = r35 & 16
            if (r11 != 0) goto L_0x0095
            r11 = r30
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r11 = r30
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r30
        L_0x009d:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b7
            r12 = r35 & 32
            if (r12 != 0) goto L_0x00b1
            r12 = r31
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b3
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r12 = r31
        L_0x00b3:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r13
            goto L_0x00b9
        L_0x00b7:
            r12 = r31
        L_0x00b9:
            r13 = r35 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00c1
            r3 = r3 | r14
            goto L_0x00d3
        L_0x00c1:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d3
            r14 = r32
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cf
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r15
            goto L_0x00d5
        L_0x00d3:
            r14 = r32
        L_0x00d5:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r3
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ee
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00ee
        L_0x00e5:
            r1.skipToGroupEnd()
            r3 = r7
            r4 = r10
            r6 = r12
            r7 = r14
            goto L_0x01e6
        L_0x00ee:
            r1.startDefaults()
            r0 = r8 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r15 = 6
            if (r0 == 0) goto L_0x0118
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0100
            goto L_0x0118
        L_0x0100:
            r1.skipToGroupEnd()
            r0 = r35 & 16
            if (r0 == 0) goto L_0x0109
            r3 = r3 & r17
        L_0x0109:
            r0 = r35 & 32
            if (r0 == 0) goto L_0x0111
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r0
        L_0x0111:
            r9 = r3
            r0 = r5
        L_0x0113:
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r14
            goto L_0x0159
        L_0x0118:
            if (r4 == 0) goto L_0x011f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0120
        L_0x011f:
            r0 = r5
        L_0x0120:
            if (r6 == 0) goto L_0x0129
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r4 = r4.m1700getLambda7$material3_release()
            r7 = r4
        L_0x0129:
            if (r9 == 0) goto L_0x0132
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1701getLambda8$material3_release()
            r10 = r4
        L_0x0132:
            r4 = r35 & 16
            if (r4 == 0) goto L_0x013f
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r1, r15)
            r3 = r3 & r17
            r11 = r4
        L_0x013f:
            r4 = r35 & 32
            if (r4 == 0) goto L_0x014e
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r4 = r4.mediumTopAppBarColors(r1, r15)
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r5
            r12 = r4
        L_0x014e:
            if (r13 == 0) goto L_0x0157
            r4 = 0
            r9 = r3
            r6 = r4
            r3 = r10
            r4 = r11
            r5 = r12
            goto L_0x0159
        L_0x0157:
            r9 = r3
            goto L_0x0113
        L_0x0159:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x016b
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.MediumTopAppBar (AppBar.kt:288)"
            r12 = 1805417862(0x6b9c7d86, float:3.783704E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r9, r10, r11)
        L_0x016b:
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r10 = r10.getTypography(r1, r15)
            androidx.compose.material3.tokens.TopAppBarMediumTokens r11 = androidx.compose.material3.tokens.TopAppBarMediumTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r11 = r11.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r11 = androidx.compose.material3.TypographyKt.fromToken(r10, r11)
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r10 = r10.getTypography(r1, r15)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r12 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r12 = r12.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material3.TypographyKt.fromToken(r10, r12)
            float r12 = MediumTitleBottomPadding
            androidx.compose.material3.tokens.TopAppBarMediumTokens r10 = androidx.compose.material3.tokens.TopAppBarMediumTokens.INSTANCE
            float r19 = r10.m3197getContainerHeightD9Ej5fM()
            androidx.compose.material3.tokens.TopAppBarSmallTokens r10 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r20 = r10.m3207getContainerHeightD9Ej5fM()
            int r10 = r9 >> 3
            r10 = r10 & 14
            r10 = r10 | 3072(0xc00, float:4.305E-42)
            int r13 = r9 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r10 = r10 | r13
            int r13 = r9 << 12
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r13
            r10 = r10 | r15
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r13
            r10 = r10 | r15
            r15 = 29360128(0x1c00000, float:7.052966E-38)
            r15 = r15 & r13
            r10 = r10 | r15
            r15 = 234881024(0xe000000, float:1.5777218E-30)
            r15 = r15 & r13
            r10 = r10 | r15
            r15 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r15
            r23 = r10 | r13
            int r9 = r9 >> 12
            r9 = r9 & 896(0x380, float:1.256E-42)
            r24 = r9 | 54
            r25 = 0
            r9 = r0
            r10 = r26
            r13 = r26
            r15 = r7
            r16 = r3
            r17 = r4
            r18 = r5
            r21 = r6
            r22 = r1
            m1516TwoRowsTopAppBartjU4iQQ(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01e0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e0:
            r11 = r4
            r4 = r3
            r3 = r7
            r7 = r6
            r6 = r5
            r5 = r0
        L_0x01e6:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x01ff
            androidx.compose.material3.AppBarKt$MediumTopAppBar$1 r12 = new androidx.compose.material3.AppBarKt$MediumTopAppBar$1
            r0 = r12
            r1 = r26
            r2 = r5
            r5 = r11
            r8 = r34
            r9 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r10.updateScope(r12)
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.MediumTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LargeTopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.foundation.layout.WindowInsets r30, androidx.compose.material3.TopAppBarColors r31, androidx.compose.material3.TopAppBarScrollBehavior r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r8 = r34
            r0 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LargeTopAppBar)P(5,2,3!1,6)343@17646L12,344@17708L22,349@17872L10,350@17973L10,347@17792L643:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 6
            r3 = r2
            r2 = r26
            goto L_0x002e
        L_0x001a:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r26
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r8
            goto L_0x002e
        L_0x002b:
            r2 = r26
            r3 = r8
        L_0x002e:
            r4 = r35 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0048
            r5 = r27
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0044
            r6 = 32
            goto L_0x0046
        L_0x0044:
            r6 = 16
        L_0x0046:
            r3 = r3 | r6
            goto L_0x004a
        L_0x0048:
            r5 = r27
        L_0x004a:
            r6 = r35 & 4
            if (r6 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r28
            boolean r9 = r1.changedInstance(r7)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r7 = r28
        L_0x0066:
            r9 = r35 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0080
            r10 = r29
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x007c
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r11
            goto L_0x0082
        L_0x0080:
            r10 = r29
        L_0x0082:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009b
            r11 = r35 & 16
            if (r11 != 0) goto L_0x0095
            r11 = r30
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r11 = r30
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r30
        L_0x009d:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b7
            r12 = r35 & 32
            if (r12 != 0) goto L_0x00b1
            r12 = r31
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b3
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r12 = r31
        L_0x00b3:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r13
            goto L_0x00b9
        L_0x00b7:
            r12 = r31
        L_0x00b9:
            r13 = r35 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00c1
            r3 = r3 | r14
            goto L_0x00d3
        L_0x00c1:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d3
            r14 = r32
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cf
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r15
            goto L_0x00d5
        L_0x00d3:
            r14 = r32
        L_0x00d5:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r3
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ee
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00ee
        L_0x00e5:
            r1.skipToGroupEnd()
            r3 = r7
            r4 = r10
            r6 = r12
            r7 = r14
            goto L_0x01e6
        L_0x00ee:
            r1.startDefaults()
            r0 = r8 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r15 = 6
            if (r0 == 0) goto L_0x0118
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0100
            goto L_0x0118
        L_0x0100:
            r1.skipToGroupEnd()
            r0 = r35 & 16
            if (r0 == 0) goto L_0x0109
            r3 = r3 & r17
        L_0x0109:
            r0 = r35 & 32
            if (r0 == 0) goto L_0x0111
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r0
        L_0x0111:
            r9 = r3
            r0 = r5
        L_0x0113:
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r14
            goto L_0x0159
        L_0x0118:
            if (r4 == 0) goto L_0x011f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0120
        L_0x011f:
            r0 = r5
        L_0x0120:
            if (r6 == 0) goto L_0x0129
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r4 = r4.m1702getLambda9$material3_release()
            r7 = r4
        L_0x0129:
            if (r9 == 0) goto L_0x0132
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1692getLambda10$material3_release()
            r10 = r4
        L_0x0132:
            r4 = r35 & 16
            if (r4 == 0) goto L_0x013f
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r1, r15)
            r3 = r3 & r17
            r11 = r4
        L_0x013f:
            r4 = r35 & 32
            if (r4 == 0) goto L_0x014e
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r4 = r4.largeTopAppBarColors(r1, r15)
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r5
            r12 = r4
        L_0x014e:
            if (r13 == 0) goto L_0x0157
            r4 = 0
            r9 = r3
            r6 = r4
            r3 = r10
            r4 = r11
            r5 = r12
            goto L_0x0159
        L_0x0157:
            r9 = r3
            goto L_0x0113
        L_0x0159:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x016b
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.LargeTopAppBar (AppBar.kt:346)"
            r12 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r9, r10, r11)
        L_0x016b:
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r10 = r10.getTypography(r1, r15)
            androidx.compose.material3.tokens.TopAppBarLargeTokens r11 = androidx.compose.material3.tokens.TopAppBarLargeTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r11 = r11.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r11 = androidx.compose.material3.TypographyKt.fromToken(r10, r11)
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r10 = r10.getTypography(r1, r15)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r12 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r12 = r12.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material3.TypographyKt.fromToken(r10, r12)
            float r12 = LargeTitleBottomPadding
            androidx.compose.material3.tokens.TopAppBarLargeTokens r10 = androidx.compose.material3.tokens.TopAppBarLargeTokens.INSTANCE
            float r19 = r10.m3193getContainerHeightD9Ej5fM()
            androidx.compose.material3.tokens.TopAppBarSmallTokens r10 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r20 = r10.m3207getContainerHeightD9Ej5fM()
            int r10 = r9 >> 3
            r10 = r10 & 14
            r10 = r10 | 3072(0xc00, float:4.305E-42)
            int r13 = r9 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r10 = r10 | r13
            int r13 = r9 << 12
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r13
            r10 = r10 | r15
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r13
            r10 = r10 | r15
            r15 = 29360128(0x1c00000, float:7.052966E-38)
            r15 = r15 & r13
            r10 = r10 | r15
            r15 = 234881024(0xe000000, float:1.5777218E-30)
            r15 = r15 & r13
            r10 = r10 | r15
            r15 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r15
            r23 = r10 | r13
            int r9 = r9 >> 12
            r9 = r9 & 896(0x380, float:1.256E-42)
            r24 = r9 | 54
            r25 = 0
            r9 = r0
            r10 = r26
            r13 = r26
            r15 = r7
            r16 = r3
            r17 = r4
            r18 = r5
            r21 = r6
            r22 = r1
            m1516TwoRowsTopAppBartjU4iQQ(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01e0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e0:
            r11 = r4
            r4 = r3
            r3 = r7
            r7 = r6
            r6 = r5
            r5 = r0
        L_0x01e6:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x01ff
            androidx.compose.material3.AppBarKt$LargeTopAppBar$1 r12 = new androidx.compose.material3.AppBarKt$LargeTopAppBar$1
            r0 = r12
            r1 = r26
            r2 = r5
            r5 = r11
            r8 = r34
            r9 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r10.updateScope(r12)
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.LargeTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0114  */
    /* renamed from: BottomAppBar-Snr_uVM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1512BottomAppBarSnr_uVM(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, long r34, long r36, float r38, androidx.compose.foundation.layout.PaddingValues r39, androidx.compose.foundation.layout.WindowInsets r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r11 = r42
            r12 = r43
            r0 = 2141738945(0x7fa857c1, float:NaN)
            r1 = r41
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)400@20438L14,401@20480L31,404@20706L12,405@20724L315:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r11 | 6
            r3 = r2
            r2 = r31
            goto L_0x0030
        L_0x001c:
            r2 = r11 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r31
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r11
            goto L_0x0030
        L_0x002d:
            r2 = r31
            r3 = r11
        L_0x0030:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r11 & 48
            if (r5 != 0) goto L_0x004a
            r5 = r32
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r32
        L_0x004c:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r7 = r11 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0066
            r7 = r33
            boolean r8 = r1.changedInstance(r7)
            if (r8 == 0) goto L_0x0062
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r8
            goto L_0x0068
        L_0x0066:
            r7 = r33
        L_0x0068:
            r8 = r11 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0081
            r8 = r12 & 8
            if (r8 != 0) goto L_0x007b
            r8 = r34
            boolean r10 = r1.changed((long) r8)
            if (r10 == 0) goto L_0x007d
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007b:
            r8 = r34
        L_0x007d:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r3 = r3 | r10
            goto L_0x0083
        L_0x0081:
            r8 = r34
        L_0x0083:
            r10 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009a
            r10 = r12 & 16
            r13 = r36
            if (r10 != 0) goto L_0x0096
            boolean r10 = r1.changed((long) r13)
            if (r10 == 0) goto L_0x0096
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r3 = r3 | r10
            goto L_0x009c
        L_0x009a:
            r13 = r36
        L_0x009c:
            r10 = r12 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a4
            r3 = r3 | r15
            goto L_0x00b7
        L_0x00a4:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00b7
            r15 = r38
            boolean r16 = r1.changed((float) r15)
            if (r16 == 0) goto L_0x00b2
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r3 = r3 | r16
            goto L_0x00b9
        L_0x00b7:
            r15 = r38
        L_0x00b9:
            r16 = r12 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c4
            r3 = r3 | r17
            r0 = r39
            goto L_0x00d7
        L_0x00c4:
            r17 = r11 & r17
            r0 = r39
            if (r17 != 0) goto L_0x00d7
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00d3
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r3 = r3 | r18
        L_0x00d7:
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x00f3
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ec
            r0 = r40
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00ee
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ec:
            r0 = r40
        L_0x00ee:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r3 = r3 | r18
            goto L_0x00f5
        L_0x00f3:
            r0 = r40
        L_0x00f5:
            r18 = 4793491(0x492493, float:6.717112E-39)
            r0 = r3 & r18
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0114
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0106
            goto L_0x0114
        L_0x0106:
            r1.skipToGroupEnd()
            r10 = r40
            r2 = r5
            r3 = r7
            r4 = r8
            r6 = r13
            r8 = r15
            r9 = r39
            goto L_0x01f2
        L_0x0114:
            r1.startDefaults()
            r0 = r11 & 1
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0144
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0128
            goto L_0x0144
        L_0x0128:
            r1.skipToGroupEnd()
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0131
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0131:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0137
            r3 = r3 & r18
        L_0x0137:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x013c
            r3 = r3 & r2
        L_0x013c:
            r4 = r39
            r6 = r40
        L_0x0140:
            r10 = r3
            r2 = r13
        L_0x0142:
            r0 = r15
            goto L_0x0193
        L_0x0144:
            if (r4 == 0) goto L_0x014b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x014b:
            if (r6 == 0) goto L_0x014f
            r0 = 0
            r7 = r0
        L_0x014f:
            r0 = r12 & 8
            r4 = 6
            if (r0 == 0) goto L_0x015c
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r8 = r0.getContainerColor(r1, r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x015c:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x016b
            int r0 = r3 >> 9
            r0 = r0 & 14
            long r13 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r8, r1, r0)
            r0 = r3 & r18
            r3 = r0
        L_0x016b:
            if (r10 == 0) goto L_0x0174
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r0 = r0.m1531getContainerElevationD9Ej5fM()
            r15 = r0
        L_0x0174:
            if (r16 == 0) goto L_0x017d
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r0 = r0.getContentPadding()
            goto L_0x017f
        L_0x017d:
            r0 = r39
        L_0x017f:
            r6 = r12 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x018f
            androidx.compose.material3.BottomAppBarDefaults r6 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r6.getWindowInsets(r1, r4)
            r3 = r3 & r2
            r10 = r3
            r6 = r4
            r2 = r13
            r4 = r0
            goto L_0x0142
        L_0x018f:
            r6 = r40
            r4 = r0
            goto L_0x0140
        L_0x0193:
            r1.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01a5
            r13 = -1
            java.lang.String r14 = "androidx.compose.material3.BottomAppBar (AppBar.kt:405)"
            r15 = 2141738945(0x7fa857c1, float:NaN)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r10, r13, r14)
        L_0x01a5:
            r13 = r10 & 14
            r14 = 100663296(0x6000000, float:2.4074124E-35)
            r13 = r13 | r14
            r14 = r10 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            r14 = r10 & 896(0x380, float:1.256E-42)
            r13 = r13 | r14
            r14 = r10 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r10
            r13 = r13 | r14
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r10
            r13 = r13 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r10
            r13 = r13 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r10 = r10 & r14
            r25 = r13 | r10
            r26 = 0
            r23 = 0
            r13 = r31
            r14 = r5
            r15 = r7
            r16 = r8
            r18 = r2
            r20 = r0
            r21 = r4
            r22 = r6
            r24 = r1
            m1514BottomAppBarqhFBPw4(r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x01e5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e5:
            r10 = r6
            r27 = r8
            r8 = r0
            r9 = r4
            r29 = r2
            r2 = r5
            r3 = r7
            r4 = r27
            r6 = r29
        L_0x01f2:
            androidx.compose.runtime.ScopeUpdateScope r13 = r1.endRestartGroup()
            if (r13 == 0) goto L_0x0209
            androidx.compose.material3.AppBarKt$BottomAppBar$1 r14 = new androidx.compose.material3.AppBarKt$BottomAppBar$1
            r0 = r14
            r1 = r31
            r11 = r42
            r12 = r43
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0209:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1512BottomAppBarSnr_uVM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fd  */
    /* renamed from: BottomAppBar-qhFBPw4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1514BottomAppBarqhFBPw4(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, long r33, long r35, float r37, androidx.compose.foundation.layout.PaddingValues r38, androidx.compose.foundation.layout.WindowInsets r39, androidx.compose.material3.BottomAppBarScrollBehavior r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r1 = r30
            r12 = r42
            r13 = r43
            r0 = -1044837119(0xffffffffc1b90d01, float:-23.13135)
            r2 = r41
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,7:c#ui.unit.Dp!1,8)462@23624L14,463@23666L31,466@23892L12,468@23966L804:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r12 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r12 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r12
            goto L_0x002b
        L_0x002a:
            r3 = r12
        L_0x002b:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r12 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r31
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r31
        L_0x0047:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r12 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0061
            r7 = r32
            boolean r8 = r2.changedInstance(r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r32
        L_0x0063:
            r8 = r12 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r13 & 8
            if (r8 != 0) goto L_0x0076
            r8 = r33
            boolean r10 = r2.changed((long) r8)
            if (r10 == 0) goto L_0x0078
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r8 = r33
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r10
            goto L_0x007e
        L_0x007c:
            r8 = r33
        L_0x007e:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0097
            r10 = r13 & 16
            if (r10 != 0) goto L_0x0091
            r10 = r35
            boolean r14 = r2.changed((long) r10)
            if (r14 == 0) goto L_0x0093
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r10 = r35
        L_0x0093:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r14
            goto L_0x0099
        L_0x0097:
            r10 = r35
        L_0x0099:
            r14 = r13 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a1
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00a1:
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00b4
            r15 = r37
            boolean r16 = r2.changed((float) r15)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r16
            goto L_0x00b6
        L_0x00b4:
            r15 = r37
        L_0x00b6:
            r16 = r13 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c1
            r3 = r3 | r17
            r0 = r38
            goto L_0x00d4
        L_0x00c1:
            r17 = r12 & r17
            r0 = r38
            if (r17 != 0) goto L_0x00d4
            boolean r18 = r2.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00d0
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r3 = r3 | r18
        L_0x00d4:
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r19 = r12 & r18
            if (r19 != 0) goto L_0x00f0
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00e9
            r0 = r39
            boolean r19 = r2.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x00eb
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r0 = r39
        L_0x00eb:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r3 = r3 | r19
            goto L_0x00f2
        L_0x00f0:
            r0 = r39
        L_0x00f2:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fd
            r3 = r3 | r19
            r5 = r40
            goto L_0x0110
        L_0x00fd:
            r19 = r12 & r19
            r5 = r40
            if (r19 != 0) goto L_0x0110
            boolean r19 = r2.changed((java.lang.Object) r5)
            if (r19 == 0) goto L_0x010c
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010c:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r3 = r3 | r19
        L_0x0110:
            r19 = 38347923(0x2492493, float:1.4777644E-37)
            r5 = r3 & r19
            r7 = 38347922(0x2492492, float:1.4777643E-37)
            if (r5 != r7) goto L_0x0131
            boolean r5 = r2.getSkipping()
            if (r5 != 0) goto L_0x0121
            goto L_0x0131
        L_0x0121:
            r2.skipToGroupEnd()
            r4 = r31
            r3 = r32
            r27 = r40
            r6 = r10
            r10 = r38
            r11 = r39
            goto L_0x022a
        L_0x0131:
            r2.startDefaults()
            r5 = r12 & 1
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            r7 = 6
            if (r5 == 0) goto L_0x0168
            boolean r5 = r2.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0143
            goto L_0x0168
        L_0x0143:
            r2.skipToGroupEnd()
            r0 = r13 & 8
            if (r0 == 0) goto L_0x014c
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014c:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0152
            r3 = r3 & r19
        L_0x0152:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x015a
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x015a:
            r4 = r31
            r6 = r32
            r5 = r39
            r27 = r40
            r14 = r3
            r0 = r15
            r3 = r38
            goto L_0x01c3
        L_0x0168:
            if (r4 == 0) goto L_0x016f
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0171
        L_0x016f:
            r4 = r31
        L_0x0171:
            if (r6 == 0) goto L_0x0175
            r6 = 0
            goto L_0x0177
        L_0x0175:
            r6 = r32
        L_0x0177:
            r20 = r13 & 8
            if (r20 == 0) goto L_0x0183
            androidx.compose.material3.BottomAppBarDefaults r8 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r8 = r8.getContainerColor(r2, r7)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0183:
            r20 = r13 & 16
            if (r20 == 0) goto L_0x0191
            int r10 = r3 >> 9
            r10 = r10 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r8, r2, r10)
            r3 = r3 & r19
        L_0x0191:
            if (r14 == 0) goto L_0x019a
            androidx.compose.material3.BottomAppBarDefaults r14 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r14 = r14.m1531getContainerElevationD9Ej5fM()
            goto L_0x019b
        L_0x019a:
            r14 = r15
        L_0x019b:
            if (r16 == 0) goto L_0x01a4
            androidx.compose.material3.BottomAppBarDefaults r15 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r15 = r15.getContentPadding()
            goto L_0x01a6
        L_0x01a4:
            r15 = r38
        L_0x01a6:
            r5 = r13 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x01b6
            androidx.compose.material3.BottomAppBarDefaults r5 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r5 = r5.getWindowInsets(r2, r7)
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r16
            goto L_0x01b8
        L_0x01b6:
            r5 = r39
        L_0x01b8:
            if (r0 == 0) goto L_0x01be
            r0 = r14
            r27 = 0
            goto L_0x01c1
        L_0x01be:
            r27 = r40
            r0 = r14
        L_0x01c1:
            r14 = r3
            r3 = r15
        L_0x01c3:
            r2.endDefaults()
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x01d5
            r15 = -1
            java.lang.String r7 = "androidx.compose.material3.BottomAppBar (AppBar.kt:468)"
            r12 = -1044837119(0xffffffffc1b90d01, float:-23.13135)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r14, r15, r7)
        L_0x01d5:
            androidx.compose.material3.AppBarKt$BottomAppBar$2 r7 = new androidx.compose.material3.AppBarKt$BottomAppBar$2
            r7.<init>(r1, r6)
            r12 = 1566394874(0x5d5d49fa, float:9.9659693E17)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r12, r15, r7)
            r23 = r7
            kotlin.jvm.functions.Function3 r23 = (kotlin.jvm.functions.Function3) r23
            int r7 = r14 >> 3
            r7 = r7 & 14
            r7 = r7 | r18
            r12 = 6
            int r12 = r14 >> 6
            r14 = r12 & 112(0x70, float:1.57E-43)
            r7 = r7 | r14
            r14 = r12 & 896(0x380, float:1.256E-42)
            r7 = r7 | r14
            r14 = r12 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r12
            r7 = r7 | r14
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r12
            r7 = r7 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r14
            r25 = r7 | r12
            r26 = 0
            r14 = r4
            r15 = r8
            r17 = r10
            r19 = r0
            r20 = r3
            r21 = r5
            r22 = r27
            r24 = r2
            m1513BottomAppBare3WI5M(r14, r15, r17, r19, r20, r21, r22, r23, r24, r25, r26)
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0222
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0222:
            r15 = r0
            r28 = r10
            r10 = r3
            r11 = r5
            r3 = r6
            r6 = r28
        L_0x022a:
            androidx.compose.runtime.ScopeUpdateScope r14 = r2.endRestartGroup()
            if (r14 == 0) goto L_0x024b
            androidx.compose.material3.AppBarKt$BottomAppBar$3 r16 = new androidx.compose.material3.AppBarKt$BottomAppBar$3
            r0 = r16
            r1 = r30
            r2 = r4
            r4 = r8
            r8 = r15
            r9 = r10
            r10 = r11
            r11 = r27
            r12 = r42
            r13 = r43
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x024b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1514BottomAppBarqhFBPw4(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ef  */
    /* renamed from: BottomAppBar-1oL4kX8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1511BottomAppBar1oL4kX8(androidx.compose.ui.Modifier r24, long r25, long r27, float r29, androidx.compose.foundation.layout.PaddingValues r30, androidx.compose.foundation.layout.WindowInsets r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r34
            r0 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)527@26431L14,528@26473L31,531@26699L12,533@26762L266:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r10 | 6
            r4 = r3
            r3 = r24
            goto L_0x002e
        L_0x001a:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r24
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r10
            goto L_0x002e
        L_0x002b:
            r3 = r24
            r4 = r10
        L_0x002e:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0047
            r5 = r35 & 2
            if (r5 != 0) goto L_0x0041
            r5 = r25
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x0043
            r7 = 32
            goto L_0x0045
        L_0x0041:
            r5 = r25
        L_0x0043:
            r7 = 16
        L_0x0045:
            r4 = r4 | r7
            goto L_0x0049
        L_0x0047:
            r5 = r25
        L_0x0049:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0062
            r7 = r35 & 4
            if (r7 != 0) goto L_0x005c
            r7 = r27
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x005e
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r7 = r27
        L_0x005e:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r4 = r4 | r9
            goto L_0x0064
        L_0x0062:
            r7 = r27
        L_0x0064:
            r9 = r35 & 8
            if (r9 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r11 = r10 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007e
            r11 = r29
            boolean r12 = r1.changed((float) r11)
            if (r12 == 0) goto L_0x007a
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r4 = r4 | r12
            goto L_0x0080
        L_0x007e:
            r11 = r29
        L_0x0080:
            r12 = r35 & 16
            if (r12 == 0) goto L_0x0087
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009a
            r13 = r30
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0096
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r4 = r4 | r14
            goto L_0x009c
        L_0x009a:
            r13 = r30
        L_0x009c:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b6
            r14 = r35 & 32
            if (r14 != 0) goto L_0x00b0
            r14 = r31
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r14 = r31
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r4 = r4 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r31
        L_0x00b8:
            r15 = r35 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c1
            r4 = r4 | r16
            goto L_0x00d5
        L_0x00c1:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d5
            r15 = r32
            boolean r17 = r1.changedInstance(r15)
            if (r17 == 0) goto L_0x00d0
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r4 = r4 | r17
            goto L_0x00d7
        L_0x00d5:
            r15 = r32
        L_0x00d7:
            r17 = 599187(0x92493, float:8.3964E-40)
            r0 = r4 & r17
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x00ef
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00ef
        L_0x00e8:
            r1.skipToGroupEnd()
            r2 = r24
            goto L_0x01b4
        L_0x00ef:
            r1.startDefaults()
            r0 = r10 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x011b
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0100
            goto L_0x011b
        L_0x0100:
            r1.skipToGroupEnd()
            r0 = r35 & 2
            if (r0 == 0) goto L_0x0109
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0109:
            r0 = r35 & 4
            if (r0 == 0) goto L_0x010f
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010f:
            r0 = r35 & 32
            if (r0 == 0) goto L_0x0114
            r4 = r4 & r3
        L_0x0114:
            r0 = r24
        L_0x0116:
            r9 = r4
            r2 = r11
            r3 = r13
            r4 = r14
            goto L_0x0164
        L_0x011b:
            if (r2 == 0) goto L_0x0122
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0124
        L_0x0122:
            r0 = r24
        L_0x0124:
            r2 = r35 & 2
            r3 = 6
            if (r2 == 0) goto L_0x0131
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r5 = r2.getContainerColor(r1, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0131:
            r2 = r35 & 4
            if (r2 == 0) goto L_0x0140
            int r2 = r4 >> 3
            r2 = r2 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r5, r1, r2)
            r2 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r2
        L_0x0140:
            if (r9 == 0) goto L_0x0149
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r2 = r2.m1531getContainerElevationD9Ej5fM()
            r11 = r2
        L_0x0149:
            if (r12 == 0) goto L_0x0152
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r2 = r2.getContentPadding()
            r13 = r2
        L_0x0152:
            r2 = r35 & 32
            if (r2 == 0) goto L_0x0116
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r1, r3)
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r3
            r9 = r4
            r3 = r13
            r4 = r2
            r2 = r11
        L_0x0164:
            r1.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0176
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.BottomAppBar (AppBar.kt:533)"
            r13 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r9, r11, r12)
        L_0x0176:
            r11 = r9 & 14
            r11 = r11 | r16
            r12 = r9 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            r12 = r9 & 896(0x380, float:1.256E-42)
            r11 = r11 | r12
            r12 = r9 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r9
            r11 = r11 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r9
            r11 = r11 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            int r9 = r9 << 3
            r9 = r9 & r12
            r22 = r11 | r9
            r23 = 0
            r19 = 0
            r11 = r0
            r12 = r5
            r14 = r7
            r16 = r2
            r17 = r3
            r18 = r4
            r20 = r32
            r21 = r1
            m1513BottomAppBare3WI5M(r11, r12, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01b0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b0:
            r11 = r2
            r13 = r3
            r14 = r4
            r2 = r0
        L_0x01b4:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x01d1
            androidx.compose.material3.AppBarKt$BottomAppBar$4 r15 = new androidx.compose.material3.AppBarKt$BottomAppBar$4
            r0 = r15
            r1 = r2
            r2 = r5
            r4 = r7
            r6 = r11
            r7 = r13
            r8 = r14
            r9 = r32
            r10 = r34
            r11 = r35
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r12.updateScope(r15)
        L_0x01d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1511BottomAppBar1oL4kX8(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0113  */
    /* renamed from: BottomAppBar-e-3WI5M  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1513BottomAppBare3WI5M(androidx.compose.ui.Modifier r37, long r38, long r40, float r42, androidx.compose.foundation.layout.PaddingValues r43, androidx.compose.foundation.layout.WindowInsets r44, androidx.compose.material3.BottomAppBarScrollBehavior r45, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            r10 = r46
            r11 = r48
            r12 = r49
            r0 = 422438773(0x192de775, float:8.990633E-24)
            r1 = r47
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp,3,7,5)577@29038L14,578@29080L31,581@29306L12,613@30640L5,615@30695L577,608@30373L1325:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x001e
            r3 = r11 | 6
            r4 = r3
            r3 = r37
            goto L_0x0032
        L_0x001e:
            r3 = r11 & 6
            if (r3 != 0) goto L_0x002f
            r3 = r37
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r11
            goto L_0x0032
        L_0x002f:
            r3 = r37
            r4 = r11
        L_0x0032:
            r5 = r11 & 48
            if (r5 != 0) goto L_0x004b
            r5 = r12 & 2
            if (r5 != 0) goto L_0x0045
            r5 = r38
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x0047
            r7 = 32
            goto L_0x0049
        L_0x0045:
            r5 = r38
        L_0x0047:
            r7 = 16
        L_0x0049:
            r4 = r4 | r7
            goto L_0x004d
        L_0x004b:
            r5 = r38
        L_0x004d:
            r7 = r11 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0066
            r7 = r12 & 4
            if (r7 != 0) goto L_0x0060
            r7 = r40
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x0062
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0060:
            r7 = r40
        L_0x0062:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r4 = r4 | r9
            goto L_0x0068
        L_0x0066:
            r7 = r40
        L_0x0068:
            r9 = r12 & 8
            if (r9 == 0) goto L_0x006f
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r13 = r11 & 3072(0xc00, float:4.305E-42)
            if (r13 != 0) goto L_0x0082
            r13 = r42
            boolean r14 = r1.changed((float) r13)
            if (r14 == 0) goto L_0x007e
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r4 = r4 | r14
            goto L_0x0084
        L_0x0082:
            r13 = r42
        L_0x0084:
            r14 = r12 & 16
            if (r14 == 0) goto L_0x008b
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008b:
            r15 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x009f
            r15 = r43
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x009a
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r4 = r4 | r16
            goto L_0x00a1
        L_0x009f:
            r15 = r43
        L_0x00a1:
            r16 = 196608(0x30000, float:2.75506E-40)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00bb
            r16 = r12 & 32
            r0 = r44
            if (r16 != 0) goto L_0x00b6
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00b6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r4 = r4 | r17
            goto L_0x00bd
        L_0x00bb:
            r0 = r44
        L_0x00bd:
            r17 = r12 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c8
            r4 = r4 | r18
            r0 = r45
            goto L_0x00db
        L_0x00c8:
            r18 = r11 & r18
            r0 = r45
            if (r18 != 0) goto L_0x00db
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00d7
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r4 = r4 | r18
        L_0x00db:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e4
            r4 = r4 | r18
            goto L_0x00f4
        L_0x00e4:
            r0 = r11 & r18
            if (r0 != 0) goto L_0x00f4
            boolean r0 = r1.changedInstance(r10)
            if (r0 == 0) goto L_0x00f1
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00f1:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r4 = r4 | r0
        L_0x00f4:
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r0 & r4
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0113
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0104
            goto L_0x0113
        L_0x0104:
            r1.skipToGroupEnd()
            r26 = r37
            r9 = r45
            r2 = r5
            r4 = r7
            r6 = r13
            r7 = r15
            r8 = r44
            goto L_0x02d1
        L_0x0113:
            r1.startDefaults()
            r0 = r11 & 1
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = 6
            if (r0 == 0) goto L_0x0144
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0125
            goto L_0x0144
        L_0x0125:
            r1.skipToGroupEnd()
            r0 = r12 & 2
            if (r0 == 0) goto L_0x012e
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x012e:
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0134
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0134:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013a
            r4 = r4 & r19
        L_0x013a:
            r0 = r37
            r9 = r44
            r2 = r13
            r13 = r4
            r4 = r15
        L_0x0141:
            r15 = r45
            goto L_0x018f
        L_0x0144:
            if (r2 == 0) goto L_0x014b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x014d
        L_0x014b:
            r0 = r37
        L_0x014d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0159
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r5 = r2.getContainerColor(r1, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0159:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0167
            int r2 = r4 >> 3
            r2 = r2 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r5, r1, r2)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0167:
            if (r9 == 0) goto L_0x0170
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r2 = r2.m1531getContainerElevationD9Ej5fM()
            r13 = r2
        L_0x0170:
            if (r14 == 0) goto L_0x0179
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r2 = r2.getContentPadding()
            r15 = r2
        L_0x0179:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x0186
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r1, r3)
            r4 = r4 & r19
            goto L_0x0188
        L_0x0186:
            r2 = r44
        L_0x0188:
            r9 = r2
            r2 = r13
            r13 = r4
            r4 = r15
            if (r17 == 0) goto L_0x0141
            r15 = 0
        L_0x018f:
            r1.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x01a1
            r14 = -1
            java.lang.String r3 = "androidx.compose.material3.BottomAppBar (AppBar.kt:584)"
            r11 = 422438773(0x192de775, float:8.990633E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r13, r14, r3)
        L_0x01a1:
            r3 = 1291864525(0x4d0049cd, float:1.34520016E8)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "589@29726L83,589@29703L106,592@29839L261"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = 3670016(0x380000, float:5.142788E-39)
            java.lang.String r11 = "CC(remember):AppBar.kt#9igjgp"
            if (r15 == 0) goto L_0x0239
            boolean r16 = r15.isPinned()
            if (r16 != 0) goto L_0x0239
            androidx.compose.ui.Modifier$Companion r16 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r23 = androidx.compose.foundation.gestures.Orientation.Vertical
            r14 = 1291864702(0x4d004a7e, float:1.34522848E8)
            r1.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r14 = r13 & r3
            r3 = 1048576(0x100000, float:1.469368E-39)
            if (r14 != r3) goto L_0x01cd
            r3 = 1
            goto L_0x01ce
        L_0x01cd:
            r3 = 0
        L_0x01ce:
            java.lang.Object r12 = r1.rememberedValue()
            if (r3 != 0) goto L_0x01dc
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r12 != r3) goto L_0x01e7
        L_0x01dc:
            androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$1$1 r3 = new androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$1$1
            r3.<init>(r15)
            r12 = r3
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r1.updateRememberedValue(r12)
        L_0x01e7:
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r1.endReplaceableGroup()
            r3 = 0
            androidx.compose.foundation.gestures.DraggableState r22 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r12, r1, r3)
            r21 = r16
            androidx.compose.ui.Modifier r21 = (androidx.compose.ui.Modifier) r21
            r12 = 1291864815(0x4d004aef, float:1.34524656E8)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r12 = 1048576(0x100000, float:1.469368E-39)
            if (r14 != r12) goto L_0x0204
            r12 = 1
            goto L_0x0205
        L_0x0204:
            r12 = r3
        L_0x0205:
            java.lang.Object r14 = r1.rememberedValue()
            if (r12 != 0) goto L_0x0213
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r14 != r12) goto L_0x021f
        L_0x0213:
            androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$2$1 r12 = new androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$2$1
            r14 = 0
            r12.<init>(r15, r14)
            r14 = r12
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            r1.updateRememberedValue(r14)
        L_0x021f:
            r28 = r14
            kotlin.jvm.functions.Function3 r28 = (kotlin.jvm.functions.Function3) r28
            r1.endReplaceableGroup()
            r30 = 188(0xbc, float:2.63E-43)
            r31 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            goto L_0x023e
        L_0x0239:
            r3 = 0
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
        L_0x023e:
            r1.endReplaceableGroup()
            androidx.compose.material3.tokens.BottomAppBarTokens r14 = androidx.compose.material3.tokens.BottomAppBarTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r14 = r14.getContainerShape()
            r3 = 6
            androidx.compose.ui.graphics.Shape r14 = androidx.compose.material3.ShapesKt.getValue(r14, r1, r3)
            r3 = 1291865671(0x4d004e47, float:1.34538352E8)
            r1.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r13
            r11 = 1048576(0x100000, float:1.469368E-39)
            if (r3 != r11) goto L_0x025e
            r3 = 1
            goto L_0x025f
        L_0x025e:
            r3 = 0
        L_0x025f:
            java.lang.Object r11 = r1.rememberedValue()
            if (r3 != 0) goto L_0x026d
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r11 != r3) goto L_0x0278
        L_0x026d:
            androidx.compose.material3.AppBarKt$BottomAppBar$5$1 r3 = new androidx.compose.material3.AppBarKt$BottomAppBar$5$1
            r3.<init>(r15)
            r11 = r3
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r1.updateRememberedValue(r11)
        L_0x0278:
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutModifierKt.layout(r0, r11)
            androidx.compose.ui.Modifier r3 = r3.then(r12)
            androidx.compose.material3.AppBarKt$BottomAppBar$6 r11 = new androidx.compose.material3.AppBarKt$BottomAppBar$6
            r11.<init>(r9, r4, r10)
            r12 = 1243053520(0x4a177dd0, float:2482036.0)
            r26 = r0
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r12, r0, r11)
            r22 = r0
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            int r0 = r13 << 3
            r11 = r0 & 896(0x380, float:1.256E-42)
            r11 = r11 | r18
            r12 = r0 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r12
            r24 = r11 | r0
            r25 = 96
            r20 = 0
            r21 = 0
            r13 = r3
            r0 = r15
            r15 = r5
            r17 = r7
            r19 = r2
            r23 = r1
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24, r25)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x02c2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02c2:
            r32 = r9
            r9 = r0
            r33 = r5
            r6 = r2
            r2 = r33
            r35 = r7
            r7 = r4
            r4 = r35
            r8 = r32
        L_0x02d1:
            androidx.compose.runtime.ScopeUpdateScope r13 = r1.endRestartGroup()
            if (r13 == 0) goto L_0x02ea
            androidx.compose.material3.AppBarKt$BottomAppBar$7 r14 = new androidx.compose.material3.AppBarKt$BottomAppBar$7
            r0 = r14
            r1 = r26
            r10 = r46
            r11 = r48
            r12 = r49
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x02ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1513BottomAppBare3WI5M(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.TopAppBarState rememberTopAppBarState(float r9, float r10, float r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 1801969826(0x6b67e0a2, float:2.8032266E26)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberTopAppBarState)P(2,1)1052@50642L145,1052@50595L192:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0012
            r9 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x0012:
            r1 = r14 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0018
            r10 = r2
        L_0x0018:
            r1 = 4
            r14 = r14 & r1
            if (r14 == 0) goto L_0x001d
            r11 = r2
        L_0x001d:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0029
            r14 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1051)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r14, r2)
        L_0x0029:
            r14 = 0
            java.lang.Object[] r2 = new java.lang.Object[r14]
            androidx.compose.material3.TopAppBarState$Companion r0 = androidx.compose.material3.TopAppBarState.Companion
            androidx.compose.runtime.saveable.Saver r3 = r0.getSaver()
            r0 = 1171243704(0x45cfc2b8, float:6648.34)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r13 & 14
            r0 = r0 ^ 6
            r4 = 1
            if (r0 <= r1) goto L_0x004a
            boolean r0 = r12.changed((float) r9)
            if (r0 != 0) goto L_0x004e
        L_0x004a:
            r0 = r13 & 6
            if (r0 != r1) goto L_0x0050
        L_0x004e:
            r0 = r4
            goto L_0x0051
        L_0x0050:
            r0 = r14
        L_0x0051:
            r1 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 ^ 48
            r5 = 32
            if (r1 <= r5) goto L_0x005f
            boolean r1 = r12.changed((float) r10)
            if (r1 != 0) goto L_0x0063
        L_0x005f:
            r1 = r13 & 48
            if (r1 != r5) goto L_0x0065
        L_0x0063:
            r1 = r4
            goto L_0x0066
        L_0x0065:
            r1 = r14
        L_0x0066:
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 ^ 384(0x180, float:5.38E-43)
            r5 = 256(0x100, float:3.59E-43)
            if (r1 <= r5) goto L_0x0075
            boolean r1 = r12.changed((float) r11)
            if (r1 != 0) goto L_0x0079
        L_0x0075:
            r13 = r13 & 384(0x180, float:5.38E-43)
            if (r13 != r5) goto L_0x007a
        L_0x0079:
            r14 = r4
        L_0x007a:
            r13 = r0 | r14
            java.lang.Object r14 = r12.rememberedValue()
            if (r13 != 0) goto L_0x008a
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x0095
        L_0x008a:
            androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1 r13 = new androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
            r13.<init>(r9, r10, r11)
            r14 = r13
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r12.updateRememberedValue(r14)
        L_0x0095:
            r5 = r14
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r12.endReplaceableGroup()
            r7 = 0
            r8 = 4
            r4 = 0
            r6 = r12
            java.lang.Object r9 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r2, r3, (java.lang.String) r4, r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            androidx.compose.material3.TopAppBarState r9 = (androidx.compose.material3.TopAppBarState) r9
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00ae
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ae:
            r12.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.rememberTopAppBarState(float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.TopAppBarState");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.BottomAppBarState rememberBottomAppBarState(float r9, float r10, float r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 1420874240(0x54b0d200, float:6.0754997E12)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberBottomAppBarState)P(2,1)1373@63308L148,1373@63258L198:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0012
            r9 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x0012:
            r1 = r14 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0018
            r10 = r2
        L_0x0018:
            r1 = 4
            r14 = r14 & r1
            if (r14 == 0) goto L_0x001d
            r11 = r2
        L_0x001d:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0029
            r14 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:1372)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r14, r2)
        L_0x0029:
            r14 = 0
            java.lang.Object[] r2 = new java.lang.Object[r14]
            androidx.compose.material3.BottomAppBarState$Companion r0 = androidx.compose.material3.BottomAppBarState.Companion
            androidx.compose.runtime.saveable.Saver r3 = r0.getSaver()
            r0 = 647586024(0x269960e8, float:1.0642774E-15)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r13 & 14
            r0 = r0 ^ 6
            r4 = 1
            if (r0 <= r1) goto L_0x004a
            boolean r0 = r12.changed((float) r9)
            if (r0 != 0) goto L_0x004e
        L_0x004a:
            r0 = r13 & 6
            if (r0 != r1) goto L_0x0050
        L_0x004e:
            r0 = r4
            goto L_0x0051
        L_0x0050:
            r0 = r14
        L_0x0051:
            r1 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 ^ 48
            r5 = 32
            if (r1 <= r5) goto L_0x005f
            boolean r1 = r12.changed((float) r10)
            if (r1 != 0) goto L_0x0063
        L_0x005f:
            r1 = r13 & 48
            if (r1 != r5) goto L_0x0065
        L_0x0063:
            r1 = r4
            goto L_0x0066
        L_0x0065:
            r1 = r14
        L_0x0066:
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 ^ 384(0x180, float:5.38E-43)
            r5 = 256(0x100, float:3.59E-43)
            if (r1 <= r5) goto L_0x0075
            boolean r1 = r12.changed((float) r11)
            if (r1 != 0) goto L_0x0079
        L_0x0075:
            r13 = r13 & 384(0x180, float:5.38E-43)
            if (r13 != r5) goto L_0x007a
        L_0x0079:
            r14 = r4
        L_0x007a:
            r13 = r0 | r14
            java.lang.Object r14 = r12.rememberedValue()
            if (r13 != 0) goto L_0x008a
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x0095
        L_0x008a:
            androidx.compose.material3.AppBarKt$rememberBottomAppBarState$1$1 r13 = new androidx.compose.material3.AppBarKt$rememberBottomAppBarState$1$1
            r13.<init>(r9, r10, r11)
            r14 = r13
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r12.updateRememberedValue(r14)
        L_0x0095:
            r5 = r14
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r12.endReplaceableGroup()
            r7 = 0
            r8 = 4
            r4 = 0
            r6 = r12
            java.lang.Object r9 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r2, r3, (java.lang.String) r4, r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            androidx.compose.material3.BottomAppBarState r9 = (androidx.compose.material3.BottomAppBarState) r9
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00ae
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ae:
            r12.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.rememberBottomAppBarState(float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.BottomAppBarState");
    }

    public static final BottomAppBarState BottomAppBarState(float f, float f2, float f3) {
        return new BottomAppBarStateImpl(f, f2, f3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0112 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object settleAppBarBottom(androidx.compose.material3.BottomAppBarState r22, float r23, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r24, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r25, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r26) {
        /*
            r0 = r22
            r1 = r26
            boolean r2 = r1 instanceof androidx.compose.material3.AppBarKt$settleAppBarBottom$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            androidx.compose.material3.AppBarKt$settleAppBarBottom$1 r2 = (androidx.compose.material3.AppBarKt$settleAppBarBottom$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            androidx.compose.material3.AppBarKt$settleAppBarBottom$1 r2 = new androidx.compose.material3.AppBarKt$settleAppBarBottom$1
            r2.<init>(r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r10 = 2
            r4 = 1
            r12 = 0
            if (r3 == 0) goto L_0x0052
            if (r3 == r4) goto L_0x003f
            if (r3 != r10) goto L_0x0037
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0114
        L_0x0037:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003f:
            java.lang.Object r0 = r2.L$2
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            java.lang.Object r3 = r2.L$1
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            java.lang.Object r4 = r2.L$0
            androidx.compose.material3.BottomAppBarState r4 = (androidx.compose.material3.BottomAppBarState) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r13 = r3
            r0 = r4
            goto L_0x00b5
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r1)
            float r1 = r22.getCollapsedFraction()
            r3 = 1008981770(0x3c23d70a, float:0.01)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0120
            float r1 = r22.getCollapsedFraction()
            r3 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x006c
            goto L_0x0120
        L_0x006c:
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r5 = r23
            r1.element = r5
            if (r24 == 0) goto L_0x00b7
            float r6 = java.lang.Math.abs(r23)
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b7
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            r20 = 28
            r21 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r14 = r23
            androidx.compose.animation.core.AnimationState r5 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)
            androidx.compose.material3.AppBarKt$settleAppBarBottom$2 r6 = new androidx.compose.material3.AppBarKt$settleAppBarBottom$2
            r6.<init>(r3, r0, r1)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r2.L$0 = r0
            r13 = r25
            r2.L$1 = r13
            r2.L$2 = r1
            r2.label = r4
            r7 = 0
            r8 = 2
            r9 = 0
            r3 = r5
            r4 = r24
            r5 = r7
            r7 = r2
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r11) goto L_0x00b5
            return r11
        L_0x00b5:
            r5 = r13
            goto L_0x00ba
        L_0x00b7:
            r13 = r25
            goto L_0x00b5
        L_0x00ba:
            if (r5 == 0) goto L_0x0115
            float r3 = r0.getHeightOffset()
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 >= 0) goto L_0x0115
            float r3 = r0.getHeightOffset()
            float r4 = r0.getHeightOffsetLimit()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0115
            float r13 = r0.getHeightOffset()
            r20 = 30
            r21 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            androidx.compose.animation.core.AnimationState r3 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)
            float r4 = r0.getCollapsedFraction()
            r6 = 1056964608(0x3f000000, float:0.5)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x00ef
            r4 = r12
            goto L_0x00f3
        L_0x00ef:
            float r4 = r0.getHeightOffsetLimit()
        L_0x00f3:
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            androidx.compose.material3.AppBarKt$settleAppBarBottom$3 r6 = new androidx.compose.material3.AppBarKt$settleAppBarBottom$3
            r6.<init>(r0)
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r2.L$0 = r1
            r0 = 0
            r2.L$1 = r0
            r2.L$2 = r0
            r2.label = r10
            r6 = 0
            r9 = 4
            r10 = 0
            r8 = r2
            java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 != r11) goto L_0x0113
            return r11
        L_0x0113:
            r0 = r1
        L_0x0114:
            r1 = r0
        L_0x0115:
            float r0 = r1.element
            long r0 = androidx.compose.ui.unit.VelocityKt.Velocity(r12, r0)
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m6846boximpl(r0)
            return r0
        L_0x0120:
            androidx.compose.ui.unit.Velocity$Companion r0 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r0.m6866getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m6846boximpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBarBottom(androidx.compose.material3.BottomAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v0, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SingleRowTopAppBar(androidx.compose.ui.Modifier r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.ui.text.TextStyle r36, boolean r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.foundation.layout.WindowInsets r40, androidx.compose.material3.TopAppBarColors r41, androidx.compose.material3.TopAppBarScrollBehavior r42, androidx.compose.runtime.Composer r43, int r44, int r45) {
        /*
            r6 = r39
            r5 = r41
            r4 = r42
            r3 = r44
            r2 = r45
            r0 = 1841601619(0x6dc49c53, float:7.606006E27)
            r1 = r43
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r7 = "C(SingleRowTopAppBar)P(3,6,7,1,4!1,8)*1639@73368L7,1640@73441L167,1640@73430L178,1652@74154L151,1690@75611L1166:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            r7 = r2 & 1
            if (r7 == 0) goto L_0x0022
            r8 = r3 | 6
            r9 = r8
            r8 = r34
            goto L_0x0036
        L_0x0022:
            r8 = r3 & 6
            if (r8 != 0) goto L_0x0033
            r8 = r34
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0030
            r9 = 4
            goto L_0x0031
        L_0x0030:
            r9 = 2
        L_0x0031:
            r9 = r9 | r3
            goto L_0x0036
        L_0x0033:
            r8 = r34
            r9 = r3
        L_0x0036:
            r10 = r2 & 2
            if (r10 == 0) goto L_0x003f
            r9 = r9 | 48
            r15 = r35
            goto L_0x0051
        L_0x003f:
            r10 = r3 & 48
            r15 = r35
            if (r10 != 0) goto L_0x0051
            boolean r10 = r1.changedInstance(r15)
            if (r10 == 0) goto L_0x004e
            r10 = 32
            goto L_0x0050
        L_0x004e:
            r10 = 16
        L_0x0050:
            r9 = r9 | r10
        L_0x0051:
            r10 = r2 & 4
            if (r10 == 0) goto L_0x005a
            r9 = r9 | 384(0x180, float:5.38E-43)
            r14 = r36
            goto L_0x006c
        L_0x005a:
            r10 = r3 & 384(0x180, float:5.38E-43)
            r14 = r36
            if (r10 != 0) goto L_0x006c
            boolean r10 = r1.changed((java.lang.Object) r14)
            if (r10 == 0) goto L_0x0069
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r10 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r9 = r9 | r10
        L_0x006c:
            r10 = r2 & 8
            if (r10 == 0) goto L_0x0075
            r9 = r9 | 3072(0xc00, float:4.305E-42)
            r13 = r37
            goto L_0x0087
        L_0x0075:
            r10 = r3 & 3072(0xc00, float:4.305E-42)
            r13 = r37
            if (r10 != 0) goto L_0x0087
            boolean r10 = r1.changed((boolean) r13)
            if (r10 == 0) goto L_0x0084
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r9 = r9 | r10
        L_0x0087:
            r10 = r2 & 16
            if (r10 == 0) goto L_0x0090
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            r12 = r38
            goto L_0x00a2
        L_0x0090:
            r10 = r3 & 24576(0x6000, float:3.4438E-41)
            r12 = r38
            if (r10 != 0) goto L_0x00a2
            boolean r10 = r1.changedInstance(r12)
            if (r10 == 0) goto L_0x009f
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r9 = r9 | r10
        L_0x00a2:
            r10 = r2 & 32
            r11 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00aa
            r9 = r9 | r11
            goto L_0x00ba
        L_0x00aa:
            r10 = r3 & r11
            if (r10 != 0) goto L_0x00ba
            boolean r10 = r1.changedInstance(r6)
            if (r10 == 0) goto L_0x00b7
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r9 = r9 | r10
        L_0x00ba:
            r10 = r2 & 64
            r11 = 1572864(0x180000, float:2.204052E-39)
            if (r10 == 0) goto L_0x00c4
            r9 = r9 | r11
            r11 = r40
            goto L_0x00d6
        L_0x00c4:
            r10 = r3 & r11
            r11 = r40
            if (r10 != 0) goto L_0x00d6
            boolean r10 = r1.changed((java.lang.Object) r11)
            if (r10 == 0) goto L_0x00d3
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r9 = r9 | r10
        L_0x00d6:
            r10 = r2 & 128(0x80, float:1.794E-43)
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00df
            r9 = r9 | r16
            goto L_0x00ef
        L_0x00df:
            r10 = r3 & r16
            if (r10 != 0) goto L_0x00ef
            boolean r10 = r1.changed((java.lang.Object) r5)
            if (r10 == 0) goto L_0x00ec
            r10 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r10 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r9 = r9 | r10
        L_0x00ef:
            r10 = r2 & 256(0x100, float:3.59E-43)
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            if (r10 == 0) goto L_0x00f8
            r9 = r9 | r16
            goto L_0x0108
        L_0x00f8:
            r10 = r3 & r16
            if (r10 != 0) goto L_0x0108
            boolean r10 = r1.changed((java.lang.Object) r4)
            if (r10 == 0) goto L_0x0105
            r10 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0107
        L_0x0105:
            r10 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0107:
            r9 = r9 | r10
        L_0x0108:
            r10 = 38347923(0x2492493, float:1.4777644E-37)
            r10 = r10 & r9
            r14 = 38347922(0x2492492, float:1.4777643E-37)
            if (r10 != r14) goto L_0x011f
            boolean r10 = r1.getSkipping()
            if (r10 != 0) goto L_0x0118
            goto L_0x011f
        L_0x0118:
            r1.skipToGroupEnd()
            r20 = r8
            goto L_0x02cd
        L_0x011f:
            if (r7 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r14 = r7
            goto L_0x0128
        L_0x0127:
            r14 = r8
        L_0x0128:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0134
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1635)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r7, r8)
        L_0x0134:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r8)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.material3.tokens.TopAppBarSmallTokens r7 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r7 = r7.m3207getContainerHeightD9Ej5fM()
            float r0 = r0.m6550toPx0680j_4(r7)
            float r0 = -r0
            r7 = -1008351447(0xffffffffc3e5c729, float:-459.55594)
            r1.startReplaceableGroup(r7)
            java.lang.String r10 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            r7 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r7
            r7 = 0
            r13 = 67108864(0x4000000, float:1.5046328E-36)
            if (r9 != r13) goto L_0x016c
            r16 = 1
            goto L_0x016e
        L_0x016c:
            r16 = r7
        L_0x016e:
            boolean r17 = r1.changed((float) r0)
            r16 = r16 | r17
            java.lang.Object r8 = r1.rememberedValue()
            if (r16 != 0) goto L_0x0182
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r16.getEmpty()
            if (r8 != r13) goto L_0x018c
        L_0x0182:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1 r8 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
            r8.<init>(r4, r0)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r1.updateRememberedValue(r8)
        L_0x018c:
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r1.endReplaceableGroup()
            androidx.compose.runtime.EffectsKt.SideEffect(r8, r1, r7)
            r0 = 0
            if (r4 == 0) goto L_0x01a2
            androidx.compose.material3.TopAppBarState r8 = r42.getState()
            if (r8 == 0) goto L_0x01a2
            float r8 = r8.getOverlappedFraction()
            goto L_0x01a3
        L_0x01a2:
            r8 = r0
        L_0x01a3:
            r13 = 1008981770(0x3c23d70a, float:0.01)
            int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r8 <= 0) goto L_0x01ad
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01ae
        L_0x01ad:
            r8 = r0
        L_0x01ae:
            long r16 = r5.m2609containerColorvNxB06k$material3_release(r8)
            r8 = 1137180672(0x43c80000, float:400.0)
            r13 = 5
            r18 = r14
            r14 = 0
            androidx.compose.animation.core.SpringSpec r0 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r0, r8, r14, r13, r14)
            androidx.compose.animation.core.AnimationSpec r0 = (androidx.compose.animation.core.AnimationSpec) r0
            r13 = 48
            r19 = 12
            r20 = 0
            r21 = 0
            r7 = r16
            r22 = r9
            r9 = r0
            r0 = r10
            r10 = r20
            r11 = r21
            r12 = r1
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            r3 = r16
            r2 = r18
            r14 = r19
            androidx.compose.runtime.State r7 = androidx.compose.animation.SingleValueAnimationKt.m105animateColorAsStateeuL9pac(r7, r9, r10, r11, r12, r13, r14)
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1 r8 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
            r8.<init>(r6)
            r9 = 1520880938(0x5aa6cd2a, float:2.34752132E16)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r9, r14, r8)
            r17 = r8
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            r8 = -1008350212(0xffffffffc3e5cbfc, float:-459.59363)
            r1.startReplaceableGroup(r8)
            java.lang.String r8 = "1670@74853L118,1670@74830L141,1673@75001L255"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            if (r4 == 0) goto L_0x027b
            boolean r8 = r42.isPinned()
            if (r8 != 0) goto L_0x027b
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r25 = androidx.compose.foundation.gestures.Orientation.Vertical
            r9 = -1008350035(0xffffffffc3e5ccad, float:-459.59903)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            r9 = r22
            if (r9 != r3) goto L_0x0214
            r10 = r14
            goto L_0x0215
        L_0x0214:
            r10 = 0
        L_0x0215:
            java.lang.Object r11 = r1.rememberedValue()
            if (r10 != 0) goto L_0x0223
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x022e
        L_0x0223:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1 r10 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
            r10.<init>(r4)
            r11 = r10
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r1.updateRememberedValue(r11)
        L_0x022e:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r1.endReplaceableGroup()
            r10 = 0
            androidx.compose.foundation.gestures.DraggableState r24 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r11, r1, r10)
            r23 = r8
            androidx.compose.ui.Modifier r23 = (androidx.compose.ui.Modifier) r23
            r8 = -1008349887(0xffffffffc3e5cd41, float:-459.60355)
            r1.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            if (r9 != r3) goto L_0x0248
            r10 = r14
        L_0x0248:
            java.lang.Object r0 = r1.rememberedValue()
            if (r10 != 0) goto L_0x0256
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x0261
        L_0x0256:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 r0 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1
            r3 = 0
            r0.<init>(r4, r3)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1.updateRememberedValue(r0)
        L_0x0261:
            r30 = r0
            kotlin.jvm.functions.Function3 r30 = (kotlin.jvm.functions.Function3) r30
            r1.endReplaceableGroup()
            r32 = 188(0xbc, float:2.63E-43)
            r33 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            goto L_0x027f
        L_0x027b:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x027f:
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = r2.then(r0)
            long r18 = SingleRowTopAppBar$lambda$7(r7)
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2 r3 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
            r7 = r3
            r8 = r40
            r9 = r41
            r10 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r20 = r2
            r2 = r14
            r14 = r17
            r15 = r42
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            r7 = 376925230(0x16776c2e, float:1.9986637E-25)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r7, r2, r3)
            r16 = r2
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = 122(0x7a, float:1.71E-43)
            r8 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r7 = r0
            r9 = r18
            r17 = r1
            r18 = r2
            r19 = r3
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02cd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02cd:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x02f4
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3 r13 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3
            r0 = r13
            r1 = r20
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            r7 = r40
            r8 = r41
            r9 = r42
            r10 = r44
            r11 = r45
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x02f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SingleRowTopAppBar(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v0, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012e  */
    /* renamed from: TwoRowsTopAppBar-tjU4iQQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1516TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.ui.text.TextStyle r42, float r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.ui.text.TextStyle r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.foundation.layout.WindowInsets r48, androidx.compose.material3.TopAppBarColors r49, float r50, float r51, androidx.compose.material3.TopAppBarScrollBehavior r52, androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            r4 = r43
            r8 = r47
            r7 = r49
            r6 = r50
            r5 = r51
            r3 = r52
            r2 = r54
            r1 = r55
            r0 = r56
            r9 = 210227552(0xc87d160, float:2.0926056E-31)
            r10 = r53
            androidx.compose.runtime.Composer r15 = r10.startRestartGroup(r9)
            java.lang.String r10 = "C(TwoRowsTopAppBar)P(3,9,11,10:c#ui.unit.Dp,7,8,4!1,12!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)*1750@77824L7,1758@78137L189,1758@78126L200,1807@80298L2301:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r10)
            r10 = r0 & 1
            if (r10 == 0) goto L_0x002a
            r13 = r2 | 6
            r14 = r13
            r13 = r40
            goto L_0x003e
        L_0x002a:
            r13 = r2 & 6
            if (r13 != 0) goto L_0x003b
            r13 = r40
            boolean r14 = r15.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0038
            r14 = 4
            goto L_0x0039
        L_0x0038:
            r14 = 2
        L_0x0039:
            r14 = r14 | r2
            goto L_0x003e
        L_0x003b:
            r13 = r40
            r14 = r2
        L_0x003e:
            r16 = r0 & 2
            r17 = 32
            r18 = 16
            if (r16 == 0) goto L_0x004b
            r14 = r14 | 48
            r9 = r41
            goto L_0x005e
        L_0x004b:
            r16 = r2 & 48
            r9 = r41
            if (r16 != 0) goto L_0x005e
            boolean r19 = r15.changedInstance(r9)
            if (r19 == 0) goto L_0x005a
            r19 = r17
            goto L_0x005c
        L_0x005a:
            r19 = r18
        L_0x005c:
            r14 = r14 | r19
        L_0x005e:
            r19 = r0 & 4
            r20 = 128(0x80, float:1.794E-43)
            if (r19 == 0) goto L_0x0067
            r14 = r14 | 384(0x180, float:5.38E-43)
            goto L_0x007b
        L_0x0067:
            r12 = r2 & 384(0x180, float:5.38E-43)
            if (r12 != 0) goto L_0x007b
            r12 = r42
            boolean r21 = r15.changed((java.lang.Object) r12)
            if (r21 == 0) goto L_0x0076
            r21 = 256(0x100, float:3.59E-43)
            goto L_0x0078
        L_0x0076:
            r21 = r20
        L_0x0078:
            r14 = r14 | r21
            goto L_0x007d
        L_0x007b:
            r12 = r42
        L_0x007d:
            r21 = r0 & 8
            if (r21 == 0) goto L_0x0084
            r14 = r14 | 3072(0xc00, float:4.305E-42)
            goto L_0x0094
        L_0x0084:
            r11 = r2 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0094
            boolean r11 = r15.changed((float) r4)
            if (r11 == 0) goto L_0x0091
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0093
        L_0x0091:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0093:
            r14 = r14 | r11
        L_0x0094:
            r11 = r0 & 16
            if (r11 == 0) goto L_0x009b
            r14 = r14 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00af
        L_0x009b:
            r11 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00af
            r11 = r44
            boolean r22 = r15.changedInstance(r11)
            if (r22 == 0) goto L_0x00aa
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r14 = r14 | r22
            goto L_0x00b1
        L_0x00af:
            r11 = r44
        L_0x00b1:
            r22 = r0 & 32
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r22 == 0) goto L_0x00bc
            r14 = r14 | r23
            r13 = r45
            goto L_0x00cf
        L_0x00bc:
            r22 = r2 & r23
            r13 = r45
            if (r22 != 0) goto L_0x00cf
            boolean r22 = r15.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x00cb
            r22 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cd
        L_0x00cb:
            r22 = 65536(0x10000, float:9.18355E-41)
        L_0x00cd:
            r14 = r14 | r22
        L_0x00cf:
            r22 = r0 & 64
            r23 = 1572864(0x180000, float:2.204052E-39)
            if (r22 == 0) goto L_0x00da
            r14 = r14 | r23
            r13 = r46
            goto L_0x00ed
        L_0x00da:
            r22 = r2 & r23
            r13 = r46
            if (r22 != 0) goto L_0x00ed
            boolean r22 = r15.changedInstance(r13)
            if (r22 == 0) goto L_0x00e9
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00eb
        L_0x00e9:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00eb:
            r14 = r14 | r22
        L_0x00ed:
            r9 = r0 & 128(0x80, float:1.794E-43)
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            if (r9 == 0) goto L_0x00f6
            r14 = r14 | r22
            goto L_0x0106
        L_0x00f6:
            r9 = r2 & r22
            if (r9 != 0) goto L_0x0106
            boolean r9 = r15.changedInstance(r8)
            if (r9 == 0) goto L_0x0103
            r9 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r9 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r14 = r14 | r9
        L_0x0106:
            r9 = r0 & 256(0x100, float:3.59E-43)
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            if (r9 == 0) goto L_0x010f
            r14 = r14 | r22
            goto L_0x0123
        L_0x010f:
            r9 = r2 & r22
            if (r9 != 0) goto L_0x0123
            r9 = r48
            boolean r22 = r15.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x011e
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0120
        L_0x011e:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0120:
            r14 = r14 | r22
            goto L_0x0125
        L_0x0123:
            r9 = r48
        L_0x0125:
            r9 = r0 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r9 == 0) goto L_0x012e
            r14 = r14 | r22
            goto L_0x013e
        L_0x012e:
            r9 = r2 & r22
            if (r9 != 0) goto L_0x013e
            boolean r9 = r15.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x013b
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013d
        L_0x013b:
            r9 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013d:
            r14 = r14 | r9
        L_0x013e:
            r9 = r0 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0145
            r9 = r1 | 6
            goto L_0x0158
        L_0x0145:
            r9 = r1 & 6
            if (r9 != 0) goto L_0x0157
            boolean r9 = r15.changed((float) r6)
            if (r9 == 0) goto L_0x0152
            r19 = 4
            goto L_0x0154
        L_0x0152:
            r19 = 2
        L_0x0154:
            r9 = r1 | r19
            goto L_0x0158
        L_0x0157:
            r9 = r1
        L_0x0158:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x015f
            r9 = r9 | 48
            goto L_0x016e
        L_0x015f:
            r2 = r1 & 48
            if (r2 != 0) goto L_0x016e
            boolean r2 = r15.changed((float) r5)
            if (r2 == 0) goto L_0x016a
            goto L_0x016c
        L_0x016a:
            r17 = r18
        L_0x016c:
            r9 = r9 | r17
        L_0x016e:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0175
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x0183
        L_0x0175:
            r2 = r1 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x0183
            boolean r2 = r15.changed((java.lang.Object) r3)
            if (r2 == 0) goto L_0x0181
            r20 = 256(0x100, float:3.59E-43)
        L_0x0181:
            r9 = r9 | r20
        L_0x0183:
            r2 = 306783379(0x12492493, float:6.34695E-28)
            r2 = r2 & r14
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r0) goto L_0x01a1
            r0 = r9 & 147(0x93, float:2.06E-43)
            r2 = 146(0x92, float:2.05E-43)
            if (r0 != r2) goto L_0x01a1
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x0199
            goto L_0x01a1
        L_0x0199:
            r15.skipToGroupEnd()
            r1 = r40
            r0 = r15
            goto L_0x035c
        L_0x01a1:
            if (r10 == 0) goto L_0x01a8
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01aa
        L_0x01a8:
            r0 = r40
        L_0x01aa:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01b8
            java.lang.String r2 = "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1741)"
            r10 = 210227552(0xc87d160, float:2.0926056E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r14, r9, r2)
        L_0x01b8:
            int r2 = androidx.compose.ui.unit.Dp.m6613compareTo0680j_4(r50, r51)
            if (r2 <= 0) goto L_0x0393
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            kotlin.jvm.internal.Ref$FloatRef r14 = new kotlin.jvm.internal.Ref$FloatRef
            r14.<init>()
            kotlin.jvm.internal.Ref$IntRef r10 = new kotlin.jvm.internal.Ref$IntRef
            r10.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r1 = r16
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r11, r12)
            java.lang.Object r1 = r15.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r11 = r1.m6550toPx0680j_4(r5)
            r2.element = r11
            float r11 = r1.m6550toPx0680j_4(r6)
            r14.element = r11
            int r1 = r1.m6545roundToPx0680j_4(r4)
            r10.element = r1
            r1 = -1609641260(0xffffffffa00ed2d4, float:-1.2097625E-19)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r9 = r9 & 896(0x380, float:1.256E-42)
            r12 = 256(0x100, float:3.59E-43)
            if (r9 != r12) goto L_0x020b
            r12 = 1
            goto L_0x020c
        L_0x020b:
            r12 = 0
        L_0x020c:
            float r11 = r2.element
            boolean r11 = r15.changed((float) r11)
            r11 = r11 | r12
            float r12 = r14.element
            boolean r12 = r15.changed((float) r12)
            r11 = r11 | r12
            java.lang.Object r12 = r15.rememberedValue()
            if (r11 != 0) goto L_0x0228
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x0233
        L_0x0228:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1 r11 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1
            r11.<init>(r3, r2, r14)
            r12 = r11
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r15.updateRememberedValue(r12)
        L_0x0233:
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r15.endReplaceableGroup()
            r11 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r12, r15, r11)
            if (r3 == 0) goto L_0x0249
            androidx.compose.material3.TopAppBarState r11 = r52.getState()
            if (r11 == 0) goto L_0x0249
            float r11 = r11.getCollapsedFraction()
            goto L_0x024a
        L_0x0249:
            r11 = 0
        L_0x024a:
            long r26 = r7.m2609containerColorvNxB06k$material3_release(r11)
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1 r12 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
            r12.<init>(r8)
            r4 = -1048401111(0xffffffffc182ab29, float:-16.333574)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r4, r5, r12)
            r18 = r4
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            androidx.compose.animation.core.CubicBezierEasing r4 = TopTitleAlphaEasing
            float r4 = r4.transform(r11)
            r12 = 1065353216(0x3f800000, float:1.0)
            float r23 = r12 - r11
            r12 = 1056964608(0x3f000000, float:0.5)
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0272
            r16 = r5
            goto L_0x0274
        L_0x0272:
            r16 = 0
        L_0x0274:
            r25 = r16 ^ 1
            r11 = -1609639731(0xffffffffa00ed8cd, float:-1.2099601E-19)
            r15.startReplaceableGroup(r11)
            java.lang.String r11 = "1791@79843L118,1791@79820L141,1794@79991L255"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r11)
            if (r3 == 0) goto L_0x0306
            boolean r11 = r52.isPinned()
            if (r11 != 0) goto L_0x0306
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r30 = androidx.compose.foundation.gestures.Orientation.Vertical
            r12 = -1609639554(0xffffffffa00ed97e, float:-1.209983E-19)
            r15.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r12 = 256(0x100, float:3.59E-43)
            if (r9 != r12) goto L_0x029c
            r12 = r5
            goto L_0x029d
        L_0x029c:
            r12 = 0
        L_0x029d:
            java.lang.Object r5 = r15.rememberedValue()
            if (r12 != 0) goto L_0x02ab
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r5 != r12) goto L_0x02b5
        L_0x02ab:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1 r5 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1
            r5.<init>(r3)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r15.updateRememberedValue(r5)
        L_0x02b5:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r15.endReplaceableGroup()
            r12 = 0
            androidx.compose.foundation.gestures.DraggableState r29 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r5, r15, r12)
            r28 = r11
            androidx.compose.ui.Modifier r28 = (androidx.compose.ui.Modifier) r28
            r5 = -1609639406(0xffffffffa00eda12, float:-1.2100021E-19)
            r15.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = 256(0x100, float:3.59E-43)
            if (r9 != r1) goto L_0x02d2
            r11 = 1
            goto L_0x02d3
        L_0x02d2:
            r11 = r12
        L_0x02d3:
            java.lang.Object r1 = r15.rememberedValue()
            if (r11 != 0) goto L_0x02e1
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r1 != r5) goto L_0x02ec
        L_0x02e1:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 r1 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1
            r5 = 0
            r1.<init>(r3, r5)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r15.updateRememberedValue(r1)
        L_0x02ec:
            r35 = r1
            kotlin.jvm.functions.Function3 r35 = (kotlin.jvm.functions.Function3) r35
            r15.endReplaceableGroup()
            r37 = 188(0xbc, float:2.63E-43)
            r38 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            goto L_0x030a
        L_0x0306:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x030a:
            r15.endReplaceableGroup()
            androidx.compose.ui.Modifier r1 = r0.then(r1)
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3 r5 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3
            r9 = r5
            r24 = r10
            r10 = r48
            r11 = r2
            r2 = 1
            r12 = r49
            r13 = r44
            r19 = r14
            r14 = r45
            r28 = r0
            r0 = r15
            r15 = r4
            r17 = r46
            r20 = r52
            r21 = r41
            r22 = r42
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r4 = 1985938853(0x765f05a5, float:1.1308561E33)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r4, r2, r5)
            r19 = r2
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r22 = 122(0x7a, float:1.71E-43)
            r11 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r10 = r1
            r12 = r26
            r20 = r0
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x035a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x035a:
            r1 = r28
        L_0x035c:
            androidx.compose.runtime.ScopeUpdateScope r15 = r0.endRestartGroup()
            if (r15 == 0) goto L_0x0392
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4 r17 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4
            r0 = r17
            r2 = r41
            r3 = r42
            r4 = r43
            r5 = r44
            r6 = r45
            r7 = r46
            r8 = r47
            r9 = r48
            r10 = r49
            r11 = r50
            r12 = r51
            r13 = r52
            r14 = r54
            r39 = r15
            r15 = r55
            r16 = r56
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r39
            r1.updateScope(r0)
        L_0x0392:
            return
        L_0x0393:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "A TwoRowsTopAppBar max height should be greater than its pinned height"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1516TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, float, float, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TopAppBarLayout-kXwM9vE  reason: not valid java name */
    public static final void m1515TopAppBarLayoutkXwM9vE(Modifier modifier, float f, long j, long j2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i2, int i3) {
        int i4;
        int i5;
        float f3 = f;
        Arrangement.Vertical vertical2 = vertical;
        Arrangement.Horizontal horizontal2 = horizontal;
        int i6 = i;
        boolean z2 = z;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        Function2<? super Composer, ? super Integer, Unit> function25 = function23;
        int i7 = i2;
        int i8 = i3;
        Composer startRestartGroup = composer.startRestartGroup(-6794037);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBarLayout)P(4,2,6:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,3,5)1936@85940L4001,1900@84643L5298:AppBar.kt#uh7d8r");
        if ((i7 & 6) == 0) {
            i4 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i7;
        } else {
            Modifier modifier2 = modifier;
            i4 = i7;
        }
        int i9 = 16;
        if ((i7 & 48) == 0) {
            i4 |= startRestartGroup.changed(f3) ? 32 : 16;
        }
        int i10 = 256;
        long j4 = j;
        if ((i7 & 384) == 0) {
            i4 |= startRestartGroup.changed(j4) ? 256 : 128;
        }
        int i11 = 1024;
        long j5 = j2;
        if ((i7 & 3072) == 0) {
            i4 |= startRestartGroup.changed(j5) ? 2048 : 1024;
        }
        long j6 = j3;
        if ((i7 & CpioConstants.C_ISBLK) == 0) {
            i4 |= startRestartGroup.changed(j6) ? 16384 : 8192;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        if ((196608 & i7) == 0) {
            i4 |= startRestartGroup.changedInstance(function26) ? 131072 : 65536;
        }
        if ((1572864 & i7) == 0) {
            i4 |= startRestartGroup.changed((Object) textStyle) ? 1048576 : 524288;
        } else {
            TextStyle textStyle2 = textStyle;
        }
        float f4 = f2;
        if ((i7 & 12582912) == 0) {
            i4 |= startRestartGroup.changed(f4) ? 8388608 : 4194304;
        }
        if ((i7 & 100663296) == 0) {
            i4 |= startRestartGroup.changed((Object) vertical2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i7 & 805306368) == 0) {
            i4 |= startRestartGroup.changed((Object) horizontal2) ? 536870912 : 268435456;
        }
        if ((i8 & 6) == 0) {
            i5 = i8 | (startRestartGroup.changed(i6) ? 4 : 2);
        } else {
            i5 = i8;
        }
        if ((i8 & 48) == 0) {
            if (startRestartGroup.changed(z2)) {
                i9 = 32;
            }
            i5 |= i9;
        }
        if ((i8 & 384) == 0) {
            if (!startRestartGroup.changedInstance(function24)) {
                i10 = 128;
            }
            i5 |= i10;
        }
        if ((i8 & 3072) == 0) {
            if (startRestartGroup.changedInstance(function25)) {
                i11 = 2048;
            }
            i5 |= i11;
        }
        int i12 = i5;
        if ((i4 & 306783379) == 306783378 && (i12 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6794037, i4, i12, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:1899)");
            }
            startRestartGroup.startReplaceableGroup(1019460550);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
            boolean z3 = ((i4 & 112) == 32) | ((1879048192 & i4) == 536870912) | ((234881024 & i4) == 67108864) | ((i12 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AppBarKt$TopAppBarLayout$2$1(f3, horizontal2, vertical2, i6);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
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
            Composer r2 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r2, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -290509324, "C1902@84673L352,1912@85038L507,1924@85558L336:AppBar.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "navigationIcon");
            float f5 = TopAppBarHorizontalPadding;
            Modifier r4 = PaddingKt.m674paddingqDBjuR0$default(layoutId, f5, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(r4);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r9 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r9, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r9, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r9.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090257852, "C1907@84848L163:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j)), function24, startRestartGroup, ProvidedValue.$stable | ((i12 >> 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier r22 = PaddingKt.m672paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "title"), f5, 0.0f, 2, (Object) null);
            Modifier modifier3 = Modifier.Companion;
            if (z2) {
                modifier3 = SemanticsModifierKt.clearAndSetSemantics(modifier3, AppBarKt$TopAppBarLayout$1$2.INSTANCE);
            }
            Modifier r23 = GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(r22.then(modifier3), 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131067, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(r23);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090257337, "C1919@85363L168:AppBar.kt#uh7d8r");
            int i13 = i4 >> 9;
            ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(j2, textStyle, function2, startRestartGroup, ((i4 >> 15) & 112) | (i13 & 14) | (i13 & 896));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier r24 = PaddingKt.m674paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.Companion, "actionIcons"), 0.0f, 0.0f, f5, 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(r24);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer r7 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r7, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r7, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                r7.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090256972, "C1929@85728L152:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j3)), function25, startRestartGroup, ((i12 >> 6) & 112) | ProvidedValue.$stable);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
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
            endRestartGroup.updateScope(new AppBarKt$TopAppBarLayout$3(modifier, f, j, j2, j3, function2, textStyle, f2, vertical, horizontal, i, z, function22, function23, i2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0112 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object settleAppBar(androidx.compose.material3.TopAppBarState r22, float r23, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r24, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r25, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r26) {
        /*
            r0 = r22
            r1 = r26
            boolean r2 = r1 instanceof androidx.compose.material3.AppBarKt$settleAppBar$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            androidx.compose.material3.AppBarKt$settleAppBar$1 r2 = (androidx.compose.material3.AppBarKt$settleAppBar$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            androidx.compose.material3.AppBarKt$settleAppBar$1 r2 = new androidx.compose.material3.AppBarKt$settleAppBar$1
            r2.<init>(r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r10 = 2
            r4 = 1
            r12 = 0
            if (r3 == 0) goto L_0x0052
            if (r3 == r4) goto L_0x003f
            if (r3 != r10) goto L_0x0037
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0114
        L_0x0037:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003f:
            java.lang.Object r0 = r2.L$2
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            java.lang.Object r3 = r2.L$1
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            java.lang.Object r4 = r2.L$0
            androidx.compose.material3.TopAppBarState r4 = (androidx.compose.material3.TopAppBarState) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r13 = r3
            r0 = r4
            goto L_0x00b5
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r1)
            float r1 = r22.getCollapsedFraction()
            r3 = 1008981770(0x3c23d70a, float:0.01)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0120
            float r1 = r22.getCollapsedFraction()
            r3 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x006c
            goto L_0x0120
        L_0x006c:
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r5 = r23
            r1.element = r5
            if (r24 == 0) goto L_0x00b7
            float r6 = java.lang.Math.abs(r23)
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b7
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            r20 = 28
            r21 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r14 = r23
            androidx.compose.animation.core.AnimationState r5 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)
            androidx.compose.material3.AppBarKt$settleAppBar$2 r6 = new androidx.compose.material3.AppBarKt$settleAppBar$2
            r6.<init>(r3, r0, r1)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r2.L$0 = r0
            r13 = r25
            r2.L$1 = r13
            r2.L$2 = r1
            r2.label = r4
            r7 = 0
            r8 = 2
            r9 = 0
            r3 = r5
            r4 = r24
            r5 = r7
            r7 = r2
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r11) goto L_0x00b5
            return r11
        L_0x00b5:
            r5 = r13
            goto L_0x00ba
        L_0x00b7:
            r13 = r25
            goto L_0x00b5
        L_0x00ba:
            if (r5 == 0) goto L_0x0115
            float r3 = r0.getHeightOffset()
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 >= 0) goto L_0x0115
            float r3 = r0.getHeightOffset()
            float r4 = r0.getHeightOffsetLimit()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0115
            float r13 = r0.getHeightOffset()
            r20 = 30
            r21 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            androidx.compose.animation.core.AnimationState r3 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)
            float r4 = r0.getCollapsedFraction()
            r6 = 1056964608(0x3f000000, float:0.5)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x00ef
            r4 = r12
            goto L_0x00f3
        L_0x00ef:
            float r4 = r0.getHeightOffsetLimit()
        L_0x00f3:
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            androidx.compose.material3.AppBarKt$settleAppBar$3 r6 = new androidx.compose.material3.AppBarKt$settleAppBar$3
            r6.<init>(r0)
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r2.L$0 = r1
            r0 = 0
            r2.L$1 = r0
            r2.L$2 = r0
            r2.label = r10
            r6 = 0
            r9 = 4
            r10 = 0
            r8 = r2
            java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 != r11) goto L_0x0113
            return r11
        L_0x0113:
            r0 = r1
        L_0x0114:
            r1 = r0
        L_0x0115:
            float r0 = r1.element
            long r0 = androidx.compose.ui.unit.VelocityKt.Velocity(r12, r0)
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m6846boximpl(r0)
            return r0
        L_0x0120:
            androidx.compose.ui.unit.Velocity$Companion r0 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r0.m6866getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m6846boximpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBar(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    private static final long SingleRowTopAppBar$lambda$7(State<Color> state) {
        return state.getValue().m3826unboximpl();
    }

    static {
        float f = (float) 16;
        float f2 = (float) 12;
        float r1 = Dp.m6614constructorimpl(Dp.m6614constructorimpl(f) - Dp.m6614constructorimpl(f2));
        BottomAppBarHorizontalPadding = r1;
        float r3 = Dp.m6614constructorimpl(Dp.m6614constructorimpl(f) - Dp.m6614constructorimpl(f2));
        BottomAppBarVerticalPadding = r3;
        FABHorizontalPadding = Dp.m6614constructorimpl(Dp.m6614constructorimpl(f) - r1);
        FABVerticalPadding = Dp.m6614constructorimpl(Dp.m6614constructorimpl(f2) - r3);
        float r12 = Dp.m6614constructorimpl((float) 4);
        TopAppBarHorizontalPadding = r12;
        TopAppBarTitleInset = Dp.m6614constructorimpl(Dp.m6614constructorimpl(f) - r12);
    }
}
