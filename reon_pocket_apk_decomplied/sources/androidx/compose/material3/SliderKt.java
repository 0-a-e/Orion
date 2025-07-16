package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.SliderTokens;
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
import androidx.compose.ui.R;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u0010&\u001aä\u0001\u0010\u0015\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0018\u0010*\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\b\b\u0003\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u00100\u001a\u0010\u0015\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0018\u0010*\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0003\u0010.\u001a\u00020/2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u00101\u001a\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0003¢\u0006\u0002\u00103\u001as\u00104\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u0002052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001f2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u00108\u001a³\u0001\u00104\u001a\u00020\u00162\u0006\u0010'\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001f2\b\b\u0003\u0010.\u001a\u00020/2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(H\u0007¢\u0006\u0002\u00109\u001a}\u00104\u001a\u00020\u00162\u0006\u0010'\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0003\u0010.\u001a\u00020/2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010:\u001a_\u0010;\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u001f2\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0003¢\u0006\u0002\u0010<\u001a\u001d\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020)H\u0001¢\u0006\u0002\u0010@\u001a\u001b\u0010=\u001a\u00020\u00102\f\u0010A\u001a\b\u0012\u0004\u0012\u00020)0(H\u0001¢\u0006\u0002\u0010B\u001a \u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020)H\u0002\u001a:\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a0\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020)2\u0006\u0010O\u001a\u00020)2\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)H\u0002\u001a(\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020)2\u0006\u0010U\u001a\u00020)H\u0002\u001a\u0010\u0010V\u001a\u00020S2\u0006\u0010.\u001a\u00020/H\u0002\u001a5\u0010W\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020)\u0018\u00010X*\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H@ø\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a\u001c\u0010a\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a,\u0010b\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0003\u001a\u001c\u0010c\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a\u001c\u0010d\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a$\u0010e\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u00106\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\r\u0010\n\"\u001e\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"ThumbDefaultElevation", "Landroidx/compose/ui/unit/Dp;", "F", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "isSpecified", "", "Landroidx/compose/material3/SliderRange;", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "RangeSlider", "", "state", "Landroidx/compose/material3/RangeSliderState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "onValueChange", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Slider", "Landroidx/compose/material3/SliderState;", "interactionSource", "thumb", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x", "a2", "b2", "scale-ziovWd0", "(FFJFF)J", "x1", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderEndThumbSemantics", "rangeSliderPressDragModifier", "rangeSliderStartThumbSemantics", "sliderSemantics", "sliderTapModifier", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderKt {
    /* access modifiers changed from: private */
    public static final float ThumbDefaultElevation = Dp.m6614constructorimpl((float) 1);
    private static final float ThumbHeight;
    /* access modifiers changed from: private */
    public static final float ThumbPressedElevation = Dp.m6614constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final long ThumbSize;
    private static final float ThumbWidth;
    /* access modifiers changed from: private */
    public static final float TickSize = SliderTokens.INSTANCE.m3140getTickMarksContainerSizeD9Ej5fM();
    private static final float TrackHeight = SliderTokens.INSTANCE.m3135getInactiveTrackHeightD9Ej5fM();

    /* renamed from: isSpecified-If1S1O4$annotations  reason: not valid java name */
    public static /* synthetic */ void m2197isSpecifiedIf1S1O4$annotations(long j) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r28, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, boolean r31, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r32, int r33, kotlin.jvm.functions.Function0<kotlin.Unit> r34, androidx.compose.material3.SliderColors r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r10 = r38
            r11 = r39
            r0 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            r1 = r37
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Slider)P(7,4,3,1,8,6,5)155@7378L8,156@7438L39,158@7486L714:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r10 | 6
            r3 = r2
            r2 = r28
            goto L_0x0030
        L_0x001c:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r28
            boolean r3 = r1.changed((float) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r10
            goto L_0x0030
        L_0x002d:
            r2 = r28
            r3 = r10
        L_0x0030:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r10 & 48
            if (r4 != 0) goto L_0x004a
            r4 = r29
            boolean r5 = r1.changedInstance(r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r3 = r3 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r29
        L_0x004c:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0066
            r6 = r30
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r7
            goto L_0x0068
        L_0x0066:
            r6 = r30
        L_0x0068:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0082
            r8 = r31
            boolean r9 = r1.changed((boolean) r8)
            if (r9 == 0) goto L_0x007e
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r9
            goto L_0x0084
        L_0x0082:
            r8 = r31
        L_0x0084:
            r9 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009d
            r9 = r11 & 16
            if (r9 != 0) goto L_0x0097
            r9 = r32
            boolean r12 = r1.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0099
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0097:
            r9 = r32
        L_0x0099:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r3 = r3 | r12
            goto L_0x009f
        L_0x009d:
            r9 = r32
        L_0x009f:
            r12 = r11 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a7
            r3 = r3 | r13
            goto L_0x00b9
        L_0x00a7:
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00b9
            r13 = r33
            boolean r14 = r1.changed((int) r13)
            if (r14 == 0) goto L_0x00b5
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r3 = r3 | r14
            goto L_0x00bb
        L_0x00b9:
            r13 = r33
        L_0x00bb:
            r14 = r11 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c3
            r3 = r3 | r15
            goto L_0x00d6
        L_0x00c3:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00d6
            r15 = r34
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00d1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r3 = r3 | r16
            goto L_0x00d8
        L_0x00d6:
            r15 = r34
        L_0x00d8:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00f4
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ed
            r0 = r35
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00ef
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ed:
            r0 = r35
        L_0x00ef:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r3 = r3 | r17
            goto L_0x00f6
        L_0x00f4:
            r0 = r35
        L_0x00f6:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0101
            r3 = r3 | r17
            r2 = r36
            goto L_0x0114
        L_0x0101:
            r17 = r10 & r17
            r2 = r36
            if (r17 != 0) goto L_0x0114
            boolean r17 = r1.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x0110
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0112
        L_0x0110:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0112:
            r3 = r3 | r17
        L_0x0114:
            r17 = 38347923(0x2492493, float:1.4777644E-37)
            r2 = r3 & r17
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r4) goto L_0x0133
            boolean r2 = r1.getSkipping()
            if (r2 != 0) goto L_0x0125
            goto L_0x0133
        L_0x0125:
            r1.skipToGroupEnd()
            r3 = r6
            r4 = r8
            r5 = r9
            r6 = r13
            r7 = r15
            r8 = r35
            r9 = r36
            goto L_0x0242
        L_0x0133:
            r1.startDefaults()
            r2 = r10 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r4 = 1
            if (r2 == 0) goto L_0x015f
            boolean r2 = r1.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0145
            goto L_0x015f
        L_0x0145:
            r1.skipToGroupEnd()
            r0 = r11 & 16
            if (r0 == 0) goto L_0x014e
            r3 = r3 & r17
        L_0x014e:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0156
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0156:
            r5 = r36
            r7 = r3
            r0 = r13
            r2 = r15
            r3 = r35
            goto L_0x01be
        L_0x015f:
            if (r5 == 0) goto L_0x0166
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r6 = r2
        L_0x0166:
            if (r7 == 0) goto L_0x0169
            r8 = r4
        L_0x0169:
            r2 = r11 & 16
            if (r2 == 0) goto L_0x0177
            r2 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r2 = kotlin.ranges.RangesKt.rangeTo((float) r2, (float) r5)
            r3 = r3 & r17
            r9 = r2
        L_0x0177:
            if (r12 == 0) goto L_0x017b
            r2 = 0
            r13 = r2
        L_0x017b:
            if (r14 == 0) goto L_0x017f
            r2 = 0
            r15 = r2
        L_0x017f:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x018f
            androidx.compose.material3.SliderDefaults r2 = androidx.compose.material3.SliderDefaults.INSTANCE
            r5 = 6
            androidx.compose.material3.SliderColors r2 = r2.colors(r1, r5)
            r5 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r5
            goto L_0x0191
        L_0x018f:
            r2 = r35
        L_0x0191:
            if (r0 == 0) goto L_0x01b8
            r0 = -1537043190(0xffffffffa462950a, float:-4.913218E-17)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            java.lang.Object r0 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x01b1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r0)
        L_0x01b1:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r1.endReplaceableGroup()
            r5 = r0
            goto L_0x01ba
        L_0x01b8:
            r5 = r36
        L_0x01ba:
            r7 = r3
            r0 = r13
            r3 = r2
            r2 = r15
        L_0x01be:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01d0
            r12 = -1
            java.lang.String r13 = "androidx.compose.material3.Slider (Slider.kt:157)"
            r14 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r7, r12, r13)
        L_0x01d0:
            androidx.compose.material3.SliderKt$Slider$2 r12 = new androidx.compose.material3.SliderKt$Slider$2
            r12.<init>(r5, r3, r8)
            r13 = 308249025(0x125f81c1, float:7.0526327E-28)
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r4, r12)
            r20 = r12
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            androidx.compose.material3.SliderKt$Slider$3 r12 = new androidx.compose.material3.SliderKt$Slider$3
            r12.<init>(r3, r8)
            r13 = -1843234110(0xffffffff92227ac2, float:-5.1269497E-28)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r4, r12)
            r21 = r4
            kotlin.jvm.functions.Function3 r21 = (kotlin.jvm.functions.Function3) r21
            r4 = r7 & 14
            r12 = 905969664(0x36000000, float:1.9073486E-6)
            r4 = r4 | r12
            r12 = r7 & 112(0x70, float:1.57E-43)
            r4 = r4 | r12
            r12 = r7 & 896(0x380, float:1.256E-42)
            r4 = r4 | r12
            r12 = r7 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r12
            int r12 = r7 >> 6
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r12
            r4 = r4 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r12
            r4 = r4 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r13
            r4 = r4 | r12
            int r12 = r7 << 6
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r13
            r24 = r4 | r12
            int r4 = r7 >> 12
            r25 = r4 & 14
            r26 = 0
            r12 = r28
            r13 = r29
            r14 = r6
            r15 = r8
            r16 = r2
            r17 = r3
            r18 = r5
            r19 = r0
            r22 = r9
            r23 = r1
            Slider(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0238
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0238:
            r7 = r2
            r4 = r8
            r8 = r3
            r3 = r6
            r6 = r0
            r27 = r9
            r9 = r5
            r5 = r27
        L_0x0242:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x025b
            androidx.compose.material3.SliderKt$Slider$4 r13 = new androidx.compose.material3.SliderKt$Slider$4
            r0 = r13
            r1 = r28
            r2 = r29
            r10 = r38
            r11 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x025b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: androidx.compose.material3.SliderState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r22, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r23, androidx.compose.ui.Modifier r24, boolean r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.material3.SliderColors r27, androidx.compose.foundation.interaction.MutableInteractionSource r28, int r29, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r32, androidx.compose.runtime.Composer r33, int r34, int r35, int r36) {
        /*
            r1 = r22
            r2 = r23
            r12 = r34
            r14 = r36
            r0 = 1191170377(0x46ffd149, float:32744.643)
            r3 = r33
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(Slider)P(9,4,3,1,5)246@11459L8,247@11519L39,266@12117L43,267@12177L210,283@12458L184:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r14 & 1
            if (r4 == 0) goto L_0x001d
            r4 = r12 | 6
            goto L_0x002d
        L_0x001d:
            r4 = r12 & 6
            if (r4 != 0) goto L_0x002c
            boolean r4 = r3.changed((float) r1)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = 2
        L_0x002a:
            r4 = r4 | r12
            goto L_0x002d
        L_0x002c:
            r4 = r12
        L_0x002d:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x0034
            r4 = r4 | 48
            goto L_0x0044
        L_0x0034:
            r7 = r12 & 48
            if (r7 != 0) goto L_0x0044
            boolean r7 = r3.changedInstance(r2)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r4 = r4 | r7
        L_0x0044:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x004b
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r8 = r12 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x005e
            r8 = r24
            boolean r9 = r3.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005a
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r4 = r4 | r9
            goto L_0x0060
        L_0x005e:
            r8 = r24
        L_0x0060:
            r9 = r14 & 8
            if (r9 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r10 = r12 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007a
            r10 = r25
            boolean r11 = r3.changed((boolean) r10)
            if (r11 == 0) goto L_0x0076
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r11
            goto L_0x007c
        L_0x007a:
            r10 = r25
        L_0x007c:
            r11 = r14 & 16
            if (r11 == 0) goto L_0x0083
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0083:
            r13 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0096
            r13 = r26
            boolean r15 = r3.changedInstance(r13)
            if (r15 == 0) goto L_0x0092
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r4 = r4 | r15
            goto L_0x0098
        L_0x0096:
            r13 = r26
        L_0x0098:
            r15 = 196608(0x30000, float:2.75506E-40)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00b3
            r15 = r14 & 32
            if (r15 != 0) goto L_0x00ac
            r15 = r27
            boolean r16 = r3.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ae
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r15 = r27
        L_0x00ae:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r4 = r4 | r16
            goto L_0x00b5
        L_0x00b3:
            r15 = r27
        L_0x00b5:
            r16 = r14 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c0
            r4 = r4 | r17
            r6 = r28
            goto L_0x00d3
        L_0x00c0:
            r17 = r12 & r17
            r6 = r28
            if (r17 != 0) goto L_0x00d3
            boolean r17 = r3.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r4 = r4 | r17
        L_0x00d3:
            r0 = r14 & 128(0x80, float:1.794E-43)
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00de
            r4 = r4 | r19
            r5 = r29
            goto L_0x00f1
        L_0x00de:
            r19 = r12 & r19
            r5 = r29
            if (r19 != 0) goto L_0x00f1
            boolean r20 = r3.changed((int) r5)
            if (r20 == 0) goto L_0x00ed
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ed:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r4 = r4 | r20
        L_0x00f1:
            r5 = r14 & 256(0x100, float:3.59E-43)
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            if (r5 == 0) goto L_0x00fc
            r4 = r4 | r20
            r6 = r30
            goto L_0x010f
        L_0x00fc:
            r20 = r12 & r20
            r6 = r30
            if (r20 != 0) goto L_0x010f
            boolean r20 = r3.changedInstance(r6)
            if (r20 == 0) goto L_0x010b
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x010b:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r4 = r4 | r20
        L_0x010f:
            r6 = r14 & 512(0x200, float:7.175E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r6 == 0) goto L_0x011a
            r4 = r4 | r20
            r8 = r31
            goto L_0x012d
        L_0x011a:
            r20 = r12 & r20
            r8 = r31
            if (r20 != 0) goto L_0x012d
            boolean r20 = r3.changedInstance(r8)
            if (r20 == 0) goto L_0x0129
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012b
        L_0x0129:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012b:
            r4 = r4 | r20
        L_0x012d:
            r20 = r35 & 6
            if (r20 != 0) goto L_0x0147
            r8 = r14 & 1024(0x400, float:1.435E-42)
            if (r8 != 0) goto L_0x0140
            r8 = r32
            boolean r20 = r3.changed((java.lang.Object) r8)
            if (r20 == 0) goto L_0x0142
            r20 = 4
            goto L_0x0144
        L_0x0140:
            r8 = r32
        L_0x0142:
            r20 = 2
        L_0x0144:
            r20 = r35 | r20
            goto L_0x014b
        L_0x0147:
            r8 = r32
            r20 = r35
        L_0x014b:
            r21 = 306783379(0x12492493, float:6.34695E-28)
            r8 = r4 & r21
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r10) goto L_0x0176
            r8 = r20 & 3
            r10 = 2
            if (r8 != r10) goto L_0x0176
            boolean r8 = r3.getSkipping()
            if (r8 != 0) goto L_0x0161
            goto L_0x0176
        L_0x0161:
            r3.skipToGroupEnd()
            r7 = r24
            r4 = r25
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r5 = r13
            r6 = r15
            r13 = r28
            goto L_0x02ef
        L_0x0176:
            r3.startDefaults()
            r8 = r12 & 1
            r18 = 0
            r10 = 1
            if (r8 == 0) goto L_0x01ac
            boolean r8 = r3.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0187
            goto L_0x01ac
        L_0x0187:
            r3.skipToGroupEnd()
            r0 = r14 & 32
            if (r0 == 0) goto L_0x0192
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r0
        L_0x0192:
            r0 = r14 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0198
            r20 = r20 & -15
        L_0x0198:
            r7 = r24
            r8 = r25
            r0 = r29
            r5 = r30
            r6 = r31
            r10 = r32
            r9 = r13
            r11 = r15
            r15 = r20
            r13 = r28
            goto L_0x0238
        L_0x01ac:
            if (r7 == 0) goto L_0x01b3
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            goto L_0x01b5
        L_0x01b3:
            r7 = r24
        L_0x01b5:
            if (r9 == 0) goto L_0x01b9
            r8 = r10
            goto L_0x01bb
        L_0x01b9:
            r8 = r25
        L_0x01bb:
            if (r11 == 0) goto L_0x01bf
            r9 = 0
            goto L_0x01c0
        L_0x01bf:
            r9 = r13
        L_0x01c0:
            r11 = r14 & 32
            if (r11 == 0) goto L_0x01d0
            androidx.compose.material3.SliderDefaults r11 = androidx.compose.material3.SliderDefaults.INSTANCE
            r13 = 6
            androidx.compose.material3.SliderColors r11 = r11.colors(r3, r13)
            r13 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r13
            goto L_0x01d1
        L_0x01d0:
            r11 = r15
        L_0x01d1:
            if (r16 == 0) goto L_0x01f7
            r13 = -1537039109(0xffffffffa462a4fb, float:-4.9145682E-17)
            r3.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r13)
            java.lang.Object r13 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r13 != r15) goto L_0x01f1
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r13)
        L_0x01f1:
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = (androidx.compose.foundation.interaction.MutableInteractionSource) r13
            r3.endReplaceableGroup()
            goto L_0x01f9
        L_0x01f7:
            r13 = r28
        L_0x01f9:
            if (r0 == 0) goto L_0x01fe
            r0 = r18
            goto L_0x0200
        L_0x01fe:
            r0 = r29
        L_0x0200:
            if (r5 == 0) goto L_0x0211
            androidx.compose.material3.SliderKt$Slider$6 r5 = new androidx.compose.material3.SliderKt$Slider$6
            r5.<init>(r13, r11, r8)
            r15 = -1756326375(0xffffffff97509619, float:-6.7397875E-25)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r15, r10, r5)
            kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
            goto L_0x0213
        L_0x0211:
            r5 = r30
        L_0x0213:
            if (r6 == 0) goto L_0x0224
            androidx.compose.material3.SliderKt$Slider$7 r6 = new androidx.compose.material3.SliderKt$Slider$7
            r6.<init>(r11, r8)
            r15 = 2083675534(0x7c325d8e, float:3.7045054E36)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r15, r10, r6)
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            goto L_0x0226
        L_0x0224:
            r6 = r31
        L_0x0226:
            r15 = r14 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0234
            r15 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r10 = kotlin.ranges.RangesKt.rangeTo((float) r15, (float) r10)
            r20 = r20 & -15
            goto L_0x0236
        L_0x0234:
            r10 = r32
        L_0x0236:
            r15 = r20
        L_0x0238:
            r3.endDefaults()
            boolean r20 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r20 == 0) goto L_0x024c
            r20 = r11
            java.lang.String r11 = "androidx.compose.material3.Slider (Slider.kt:265)"
            r12 = 1191170377(0x46ffd149, float:32744.643)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r4, r15, r11)
            goto L_0x024e
        L_0x024c:
            r20 = r11
        L_0x024e:
            int r11 = r4 >> 12
            r11 = r11 & 14
            androidx.compose.runtime.State r11 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r9, r3, r11)
            r12 = -1537038451(0xffffffffa462a78d, float:-4.914786E-17)
            r3.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r12)
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r4
            r17 = r9
            r9 = 8388608(0x800000, float:1.17549435E-38)
            if (r12 != r9) goto L_0x026c
            r9 = 1
            goto L_0x026e
        L_0x026c:
            r9 = r18
        L_0x026e:
            r12 = r15 & 14
            r19 = 6
            r12 = r12 ^ 6
            r14 = 4
            if (r12 <= r14) goto L_0x027d
            boolean r12 = r3.changed((java.lang.Object) r10)
            if (r12 != 0) goto L_0x0281
        L_0x027d:
            r12 = r15 & 6
            if (r12 != r14) goto L_0x0283
        L_0x0281:
            r18 = 1
        L_0x0283:
            r9 = r9 | r18
            java.lang.Object r12 = r3.rememberedValue()
            if (r9 != 0) goto L_0x0293
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r12 != r9) goto L_0x02a2
        L_0x0293:
            androidx.compose.material3.SliderState r12 = new androidx.compose.material3.SliderState
            androidx.compose.material3.SliderKt$Slider$state$1$1 r9 = new androidx.compose.material3.SliderKt$Slider$state$1$1
            r9.<init>(r11)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r12.<init>(r1, r0, r9, r10)
            r3.updateRememberedValue(r12)
        L_0x02a2:
            r9 = r12
            androidx.compose.material3.SliderState r9 = (androidx.compose.material3.SliderState) r9
            r3.endReplaceableGroup()
            r9.setOnValueChange$material3_release(r2)
            r9.setValue(r1)
            int r11 = r4 >> 3
            r11 = r11 & 1008(0x3f0, float:1.413E-42)
            int r12 = r4 >> 6
            r14 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r14
            r11 = r11 | r12
            int r4 = r4 >> 9
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r4
            r11 = r11 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r12
            r4 = r4 | r11
            r11 = 8
            r12 = 0
            r24 = r9
            r25 = r7
            r26 = r8
            r27 = r12
            r28 = r13
            r29 = r5
            r30 = r6
            r31 = r3
            r32 = r4
            r33 = r11
            Slider(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x02e6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e6:
            r9 = r5
            r4 = r8
            r11 = r10
            r5 = r17
            r8 = r0
            r10 = r6
            r6 = r20
        L_0x02ef:
            androidx.compose.runtime.ScopeUpdateScope r15 = r3.endRestartGroup()
            if (r15 == 0) goto L_0x030f
            androidx.compose.material3.SliderKt$Slider$8 r16 = new androidx.compose.material3.SliderKt$Slider$8
            r0 = r16
            r1 = r22
            r2 = r23
            r3 = r7
            r7 = r13
            r12 = r34
            r13 = r35
            r14 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x030f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, int, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.ranges.ClosedFloatingPointRange, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(androidx.compose.material3.SliderState r18, androidx.compose.ui.Modifier r19, boolean r20, androidx.compose.material3.SliderColors r21, androidx.compose.foundation.interaction.MutableInteractionSource r22, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r8 = r26
            r0 = -1303883986(0xffffffffb2484f2e, float:-1.1659536E-8)
            r1 = r25
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Slider)P(4,3,1)342@15085L8,343@15145L39,361@15666L188:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r27 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 6
            r3 = r2
            r2 = r18
            goto L_0x002e
        L_0x001a:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r18
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r8
            goto L_0x002e
        L_0x002b:
            r2 = r18
            r3 = r8
        L_0x002e:
            r4 = r27 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0048
            r5 = r19
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
            r5 = r19
        L_0x004a:
            r6 = r27 & 4
            if (r6 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r20
            boolean r9 = r1.changed((boolean) r7)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r7 = r20
        L_0x0066:
            r9 = r8 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007f
            r9 = r27 & 8
            if (r9 != 0) goto L_0x0079
            r9 = r21
            boolean r10 = r1.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x007b
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x0079:
            r9 = r21
        L_0x007b:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r3 = r3 | r10
            goto L_0x0081
        L_0x007f:
            r9 = r21
        L_0x0081:
            r10 = r27 & 16
            if (r10 == 0) goto L_0x0088
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009b
            r11 = r22
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r22
        L_0x009d:
            r12 = r27 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a5
            r3 = r3 | r13
            goto L_0x00b7
        L_0x00a5:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b7
            r13 = r23
            boolean r14 = r1.changedInstance(r13)
            if (r14 == 0) goto L_0x00b3
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r14
            goto L_0x00b9
        L_0x00b7:
            r13 = r23
        L_0x00b9:
            r14 = r27 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c1
            r3 = r3 | r15
            goto L_0x00d4
        L_0x00c1:
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00d4
            r15 = r24
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00cf
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r16
            goto L_0x00d6
        L_0x00d4:
            r15 = r24
        L_0x00d6:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r2) goto L_0x00f2
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e7
            goto L_0x00f2
        L_0x00e7:
            r1.skipToGroupEnd()
            r2 = r5
            r3 = r7
            r4 = r9
            r5 = r11
            r6 = r13
            r7 = r15
            goto L_0x01c8
        L_0x00f2:
            r1.startDefaults()
            r0 = r8 & 1
            if (r0 == 0) goto L_0x0111
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0100
            goto L_0x0111
        L_0x0100:
            r1.skipToGroupEnd()
            r0 = r27 & 8
            if (r0 == 0) goto L_0x0109
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0109:
            r6 = r3
            r0 = r5
        L_0x010b:
            r2 = r9
            r3 = r11
            r4 = r13
            r5 = r15
            goto L_0x017a
        L_0x0111:
            if (r4 == 0) goto L_0x0118
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0119
        L_0x0118:
            r0 = r5
        L_0x0119:
            r2 = 1
            if (r6 == 0) goto L_0x011d
            r7 = r2
        L_0x011d:
            r4 = r27 & 8
            if (r4 == 0) goto L_0x012b
            androidx.compose.material3.SliderDefaults r4 = androidx.compose.material3.SliderDefaults.INSTANCE
            r5 = 6
            androidx.compose.material3.SliderColors r4 = r4.colors(r1, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r9 = r4
        L_0x012b:
            if (r10 == 0) goto L_0x0151
            r4 = -1537035483(0xffffffffa462b325, float:-4.915768E-17)
            r1.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            java.lang.Object r4 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x014b
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r4)
        L_0x014b:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r1.endReplaceableGroup()
            r11 = r4
        L_0x0151:
            if (r12 == 0) goto L_0x0162
            androidx.compose.material3.SliderKt$Slider$10 r4 = new androidx.compose.material3.SliderKt$Slider$10
            r4.<init>(r11, r9, r7)
            r5 = 1426271326(0x55032c5e, float:9.0141612E12)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r5, r2, r4)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            r13 = r4
        L_0x0162:
            if (r14 == 0) goto L_0x0178
            androidx.compose.material3.SliderKt$Slider$11 r4 = new androidx.compose.material3.SliderKt$Slider$11
            r4.<init>(r9, r7)
            r5 = 577038345(0x2264e809, float:3.10226E-18)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r5, r2, r4)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r5 = r2
            r6 = r3
            r2 = r9
            r3 = r11
            r4 = r13
            goto L_0x017a
        L_0x0178:
            r6 = r3
            goto L_0x010b
        L_0x017a:
            r1.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x018c
            r9 = -1
            java.lang.String r10 = "androidx.compose.material3.Slider (Slider.kt:358)"
            r11 = -1303883986(0xffffffffb2484f2e, float:-1.1659536E-8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r6, r9, r10)
        L_0x018c:
            int r9 = r18.getSteps()
            if (r9 < 0) goto L_0x01e0
            int r9 = r6 >> 3
            r10 = r9 & 14
            int r11 = r6 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r10
            r10 = r9 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r10
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r9
            r6 = r6 | r10
            r10 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r10
            r16 = r6 | r9
            r9 = r0
            r10 = r18
            r11 = r7
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r1
            SliderImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x01bf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01bf:
            r6 = r4
            r4 = r2
            r2 = r0
            r17 = r5
            r5 = r3
            r3 = r7
            r7 = r17
        L_0x01c8:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x01df
            androidx.compose.material3.SliderKt$Slider$13 r11 = new androidx.compose.material3.SliderKt$Slider$13
            r0 = r11
            r1 = r18
            r8 = r26
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x01df:
            return
        L_0x01e0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r29, kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r33, int r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.material3.SliderColors r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r9 = r38
            r10 = r39
            r0 = -743091416(0xffffffffd3b55328, float:-1.55756842E12)
            r1 = r37
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(RangeSlider)P(6,3,2,1,7,5,4)415@18225L8,417@18297L39,418@18394L39,420@18439L987:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r9 | 6
            r3 = r2
            r2 = r29
            goto L_0x0030
        L_0x001c:
            r2 = r9 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r29
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r9
            goto L_0x0030
        L_0x002d:
            r2 = r29
            r3 = r9
        L_0x0030:
            r4 = r10 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r9 & 48
            if (r4 != 0) goto L_0x004a
            r4 = r30
            boolean r5 = r1.changedInstance(r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r3 = r3 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r30
        L_0x004c:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r9 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0066
            r6 = r31
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r7
            goto L_0x0068
        L_0x0066:
            r6 = r31
        L_0x0068:
            r7 = r10 & 8
            if (r7 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r8 = r9 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0082
            r8 = r32
            boolean r11 = r1.changed((boolean) r8)
            if (r11 == 0) goto L_0x007e
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r11
            goto L_0x0084
        L_0x0082:
            r8 = r32
        L_0x0084:
            r11 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009d
            r11 = r10 & 16
            if (r11 != 0) goto L_0x0097
            r11 = r33
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0099
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0097:
            r11 = r33
        L_0x0099:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r3 = r3 | r12
            goto L_0x009f
        L_0x009d:
            r11 = r33
        L_0x009f:
            r12 = r10 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a7
            r3 = r3 | r13
            goto L_0x00b9
        L_0x00a7:
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00b9
            r13 = r34
            boolean r14 = r1.changed((int) r13)
            if (r14 == 0) goto L_0x00b5
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r3 = r3 | r14
            goto L_0x00bb
        L_0x00b9:
            r13 = r34
        L_0x00bb:
            r14 = r10 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c3
            r3 = r3 | r15
            goto L_0x00d6
        L_0x00c3:
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00d6
            r15 = r35
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00d1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r3 = r3 | r16
            goto L_0x00d8
        L_0x00d6:
            r15 = r35
        L_0x00d8:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x00f4
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ed
            r0 = r36
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00ef
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ed:
            r0 = r36
        L_0x00ef:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r3 = r3 | r17
            goto L_0x00f6
        L_0x00f4:
            r0 = r36
        L_0x00f6:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r3 & r17
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0112
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0107
            goto L_0x0112
        L_0x0107:
            r1.skipToGroupEnd()
            r3 = r6
            r5 = r11
            r6 = r13
            r7 = r15
            r11 = r36
            goto L_0x023e
        L_0x0112:
            r1.startDefaults()
            r0 = r9 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = 1
            if (r0 == 0) goto L_0x013c
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0124
            goto L_0x013c
        L_0x0124:
            r1.skipToGroupEnd()
            r0 = r10 & 16
            if (r0 == 0) goto L_0x012d
            r3 = r3 & r17
        L_0x012d:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0135
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0135:
            r7 = r36
        L_0x0137:
            r0 = r11
            r5 = r15
            r11 = r3
            r3 = r13
            goto L_0x016d
        L_0x013c:
            if (r5 == 0) goto L_0x0143
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0143:
            if (r7 == 0) goto L_0x0146
            r8 = r2
        L_0x0146:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x0154
            r0 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r0 = kotlin.ranges.RangesKt.rangeTo((float) r0, (float) r5)
            r3 = r3 & r17
            r11 = r0
        L_0x0154:
            if (r12 == 0) goto L_0x0158
            r0 = 0
            r13 = r0
        L_0x0158:
            if (r14 == 0) goto L_0x015c
            r0 = 0
            r15 = r0
        L_0x015c:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0135
            androidx.compose.material3.SliderDefaults r0 = androidx.compose.material3.SliderDefaults.INSTANCE
            r5 = 6
            androidx.compose.material3.SliderColors r0 = r0.colors(r1, r5)
            r5 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r5
            r7 = r0
            goto L_0x0137
        L_0x016d:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x017f
            r12 = -1
            java.lang.String r13 = "androidx.compose.material3.RangeSlider (Slider.kt:416)"
            r14 = -743091416(0xffffffffd3b55328, float:-1.55756842E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r11, r12, r13)
        L_0x017f:
            r12 = -223513570(0xfffffffff2ad741e, float:-6.8712043E30)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            java.lang.Object r13 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r13 != r14) goto L_0x019d
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r13)
        L_0x019d:
            r15 = r13
            androidx.compose.foundation.interaction.MutableInteractionSource r15 = (androidx.compose.foundation.interaction.MutableInteractionSource) r15
            r1.endReplaceableGroup()
            r13 = -223513473(0xfffffffff2ad747f, float:-6.871263E30)
            r1.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            java.lang.Object r12 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r12 != r13) goto L_0x01bf
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r12)
        L_0x01bf:
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = (androidx.compose.foundation.interaction.MutableInteractionSource) r12
            r19 = r12
            r1.endReplaceableGroup()
            androidx.compose.material3.SliderKt$RangeSlider$1 r13 = new androidx.compose.material3.SliderKt$RangeSlider$1
            r13.<init>(r15, r7, r8)
            r14 = -811582901(0xffffffffcfa03a4b, float:-5.3763497E9)
            androidx.compose.runtime.internal.ComposableLambda r13 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r14, r2, r13)
            r20 = r13
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            androidx.compose.material3.SliderKt$RangeSlider$2 r13 = new androidx.compose.material3.SliderKt$RangeSlider$2
            r13.<init>(r12, r7, r8)
            r12 = -1832060001(0xffffffff92ccfb9f, float:-1.2936239E-27)
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r12, r2, r13)
            r21 = r12
            kotlin.jvm.functions.Function3 r21 = (kotlin.jvm.functions.Function3) r21
            androidx.compose.material3.SliderKt$RangeSlider$3 r12 = new androidx.compose.material3.SliderKt$RangeSlider$3
            r12.<init>(r7, r8)
            r13 = 377064480(0x16798c20, float:2.0158275E-25)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r2, r12)
            r22 = r2
            kotlin.jvm.functions.Function3 r22 = (kotlin.jvm.functions.Function3) r22
            r2 = r11 & 14
            r12 = 918552576(0x36c00000, float:5.722046E-6)
            r2 = r2 | r12
            r12 = r11 & 112(0x70, float:1.57E-43)
            r2 = r2 | r12
            r12 = r11 & 896(0x380, float:1.256E-42)
            r2 = r2 | r12
            r12 = r11 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r11
            r2 = r2 | r12
            int r12 = r11 >> 3
            r13 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r13
            r25 = r2 | r12
            int r2 = r11 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r26 = r2 | 54
            r27 = 64
            r17 = 0
            r11 = r29
            r12 = r30
            r13 = r6
            r14 = r8
            r2 = r15
            r15 = r0
            r16 = r5
            r18 = r2
            r23 = r3
            r24 = r1
            RangeSlider(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0236
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0236:
            r11 = r7
            r7 = r5
            r5 = r0
            r28 = r6
            r6 = r3
            r3 = r28
        L_0x023e:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x0259
            androidx.compose.material3.SliderKt$RangeSlider$4 r13 = new androidx.compose.material3.SliderKt$RangeSlider$4
            r0 = r13
            r1 = r29
            r2 = r30
            r4 = r8
            r8 = r11
            r9 = r38
            r10 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0259:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: androidx.compose.material3.RangeSliderState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: androidx.compose.material3.RangeSliderState} */
    /* JADX WARNING: type inference failed for: r14v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0413  */
    /* JADX WARNING: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r27, kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r31, kotlin.jvm.functions.Function0<kotlin.Unit> r32, androidx.compose.material3.SliderColors r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, int r39, androidx.compose.runtime.Composer r40, int r41, int r42, int r43) {
        /*
            r2 = r28
            r14 = r41
            r15 = r42
            r13 = r43
            r0 = -1048796133(0xffffffffc17ca41b, float:-15.790065)
            r1 = r40
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)517@23109L8,518@23174L39,519@23268L39,544@24060L43,545@24120L252,558@24400L44,562@24537L291:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x0020
            r3 = r14 | 6
            r6 = r3
            r3 = r27
            goto L_0x0034
        L_0x0020:
            r3 = r14 & 6
            if (r3 != 0) goto L_0x0031
            r3 = r27
            boolean r6 = r1.changed((java.lang.Object) r3)
            if (r6 == 0) goto L_0x002e
            r6 = 4
            goto L_0x002f
        L_0x002e:
            r6 = 2
        L_0x002f:
            r6 = r6 | r14
            goto L_0x0034
        L_0x0031:
            r3 = r27
            r6 = r14
        L_0x0034:
            r7 = r13 & 2
            if (r7 == 0) goto L_0x003b
            r6 = r6 | 48
            goto L_0x004b
        L_0x003b:
            r7 = r14 & 48
            if (r7 != 0) goto L_0x004b
            boolean r7 = r1.changedInstance(r2)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r6 = r6 | r7
        L_0x004b:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0052
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0052:
            r12 = r14 & 384(0x180, float:5.38E-43)
            if (r12 != 0) goto L_0x0066
            r12 = r29
            boolean r16 = r1.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x0061
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r6 = r6 | r16
            goto L_0x0068
        L_0x0066:
            r12 = r29
        L_0x0068:
            r16 = r13 & 8
            if (r16 == 0) goto L_0x006f
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x006f:
            r4 = r14 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x0083
            r4 = r30
            boolean r17 = r1.changed((boolean) r4)
            if (r17 == 0) goto L_0x007e
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r6 = r6 | r17
            goto L_0x0085
        L_0x0083:
            r4 = r30
        L_0x0085:
            r5 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x009f
            r5 = r13 & 16
            if (r5 != 0) goto L_0x0098
            r5 = r31
            boolean r19 = r1.changed((java.lang.Object) r5)
            if (r19 == 0) goto L_0x009a
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r5 = r31
        L_0x009a:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r6 = r6 | r19
            goto L_0x00a1
        L_0x009f:
            r5 = r31
        L_0x00a1:
            r19 = r13 & 32
            r20 = 196608(0x30000, float:2.75506E-40)
            if (r19 == 0) goto L_0x00ac
            r6 = r6 | r20
            r10 = r32
            goto L_0x00bf
        L_0x00ac:
            r20 = r14 & r20
            r10 = r32
            if (r20 != 0) goto L_0x00bf
            boolean r21 = r1.changedInstance(r10)
            if (r21 == 0) goto L_0x00bb
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r6 = r6 | r21
        L_0x00bf:
            r21 = 1572864(0x180000, float:2.204052E-39)
            r21 = r14 & r21
            if (r21 != 0) goto L_0x00d9
            r21 = r13 & 64
            r8 = r33
            if (r21 != 0) goto L_0x00d4
            boolean r22 = r1.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x00d4
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r6 = r6 | r22
            goto L_0x00db
        L_0x00d9:
            r8 = r33
        L_0x00db:
            r9 = r13 & 128(0x80, float:1.794E-43)
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            if (r9 == 0) goto L_0x00e6
            r6 = r6 | r23
            r11 = r34
            goto L_0x00f9
        L_0x00e6:
            r23 = r14 & r23
            r11 = r34
            if (r23 != 0) goto L_0x00f9
            boolean r24 = r1.changed((java.lang.Object) r11)
            if (r24 == 0) goto L_0x00f5
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f7
        L_0x00f5:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f7:
            r6 = r6 | r24
        L_0x00f9:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r25 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0104
            r6 = r6 | r25
            r3 = r35
            goto L_0x0117
        L_0x0104:
            r25 = r14 & r25
            r3 = r35
            if (r25 != 0) goto L_0x0117
            boolean r25 = r1.changed((java.lang.Object) r3)
            if (r25 == 0) goto L_0x0113
            r25 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0115
        L_0x0113:
            r25 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0115:
            r6 = r6 | r25
        L_0x0117:
            r3 = r13 & 512(0x200, float:7.175E-43)
            r25 = 805306368(0x30000000, float:4.656613E-10)
            if (r3 == 0) goto L_0x0122
            r6 = r6 | r25
            r4 = r36
            goto L_0x0135
        L_0x0122:
            r25 = r14 & r25
            r4 = r36
            if (r25 != 0) goto L_0x0135
            boolean r25 = r1.changedInstance(r4)
            if (r25 == 0) goto L_0x0131
            r25 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0133
        L_0x0131:
            r25 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0133:
            r6 = r6 | r25
        L_0x0135:
            r4 = r13 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x013e
            r17 = r15 | 6
            r5 = r37
            goto L_0x0154
        L_0x013e:
            r25 = r15 & 6
            r5 = r37
            if (r25 != 0) goto L_0x0152
            boolean r25 = r1.changedInstance(r5)
            if (r25 == 0) goto L_0x014d
            r17 = 4
            goto L_0x014f
        L_0x014d:
            r17 = 2
        L_0x014f:
            r17 = r15 | r17
            goto L_0x0154
        L_0x0152:
            r17 = r15
        L_0x0154:
            r5 = r13 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x015b
            r17 = r17 | 48
            goto L_0x016e
        L_0x015b:
            r25 = r15 & 48
            r8 = r38
            if (r25 != 0) goto L_0x016e
            boolean r25 = r1.changedInstance(r8)
            if (r25 == 0) goto L_0x016a
            r18 = 32
            goto L_0x016c
        L_0x016a:
            r18 = 16
        L_0x016c:
            r17 = r17 | r18
        L_0x016e:
            r8 = r17
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0177
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x018b
        L_0x0177:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x018b
            r11 = r39
            boolean r17 = r1.changed((int) r11)
            if (r17 == 0) goto L_0x0186
            r20 = 256(0x100, float:3.59E-43)
            goto L_0x0188
        L_0x0186:
            r20 = 128(0x80, float:1.794E-43)
        L_0x0188:
            r8 = r8 | r20
            goto L_0x018d
        L_0x018b:
            r11 = r39
        L_0x018d:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r6 & r17
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r12) goto L_0x01bf
            r11 = r8 & 147(0x93, float:2.06E-43)
            r12 = 146(0x92, float:2.05E-43)
            if (r11 != r12) goto L_0x01bf
            boolean r11 = r1.getSkipping()
            if (r11 != 0) goto L_0x01a4
            goto L_0x01bf
        L_0x01a4:
            r1.skipToGroupEnd()
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = r36
            r11 = r37
            r12 = r38
            r13 = r39
            goto L_0x040d
        L_0x01bf:
            r1.startDefaults()
            r11 = r14 & 1
            java.lang.String r12 = "CC(remember):Slider.kt#9igjgp"
            if (r11 == 0) goto L_0x01fa
            boolean r11 = r1.getDefaultsInvalid()
            if (r11 == 0) goto L_0x01cf
            goto L_0x01fa
        L_0x01cf:
            r1.skipToGroupEnd()
            r0 = r13 & 16
            if (r0 == 0) goto L_0x01da
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r6 & r0
        L_0x01da:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x01e2
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r6 = r6 & r0
        L_0x01e2:
            r0 = r29
            r11 = r30
            r3 = r31
            r14 = r32
            r7 = r33
            r9 = r34
            r4 = r35
            r5 = r36
            r10 = r37
            r13 = r38
            r16 = r39
            goto L_0x02d7
        L_0x01fa:
            if (r7 == 0) goto L_0x0201
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            goto L_0x0203
        L_0x0201:
            r7 = r29
        L_0x0203:
            if (r16 == 0) goto L_0x0207
            r11 = 1
            goto L_0x0209
        L_0x0207:
            r11 = r30
        L_0x0209:
            r16 = r13 & 16
            if (r16 == 0) goto L_0x021b
            r14 = 0
            r29 = r7
            r7 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r7 = kotlin.ranges.RangesKt.rangeTo((float) r14, (float) r7)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r6 & r14
            goto L_0x021f
        L_0x021b:
            r29 = r7
            r7 = r31
        L_0x021f:
            if (r19 == 0) goto L_0x0223
            r14 = 0
            goto L_0x0225
        L_0x0223:
            r14 = r32
        L_0x0225:
            r17 = r13 & 64
            r30 = r7
            if (r17 == 0) goto L_0x0237
            androidx.compose.material3.SliderDefaults r7 = androidx.compose.material3.SliderDefaults.INSTANCE
            r13 = 6
            androidx.compose.material3.SliderColors r7 = r7.colors(r1, r13)
            r13 = -3670017(0xffffffffffc7ffff, float:NaN)
            r6 = r6 & r13
            goto L_0x0239
        L_0x0237:
            r7 = r33
        L_0x0239:
            if (r9 == 0) goto L_0x025d
            r9 = -223508693(0xfffffffff2ad872b, float:-6.874152E30)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            java.lang.Object r9 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r9 != r13) goto L_0x0257
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r9)
        L_0x0257:
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = (androidx.compose.foundation.interaction.MutableInteractionSource) r9
            r1.endReplaceableGroup()
            goto L_0x025f
        L_0x025d:
            r9 = r34
        L_0x025f:
            if (r0 == 0) goto L_0x0283
            r0 = -223508599(0xfffffffff2ad8789, float:-6.874209E30)
            r1.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            java.lang.Object r0 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r0 != r13) goto L_0x027d
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r0)
        L_0x027d:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r1.endReplaceableGroup()
            goto L_0x0285
        L_0x0283:
            r0 = r35
        L_0x0285:
            if (r3 == 0) goto L_0x0299
            androidx.compose.material3.SliderKt$RangeSlider$7 r3 = new androidx.compose.material3.SliderKt$RangeSlider$7
            r3.<init>(r9, r7, r11)
            r13 = -1963073082(0xffffffff8afde1c6, float:-2.444794E-32)
            r31 = r6
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r6, r3)
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            goto L_0x029e
        L_0x0299:
            r31 = r6
            r6 = 1
            r3 = r36
        L_0x029e:
            if (r4 == 0) goto L_0x02af
            androidx.compose.material3.SliderKt$RangeSlider$8 r4 = new androidx.compose.material3.SliderKt$RangeSlider$8
            r4.<init>(r0, r7, r11)
            r13 = 1908709951(0x71c49a3f, float:1.9470571E30)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r6, r4)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            goto L_0x02b1
        L_0x02af:
            r4 = r37
        L_0x02b1:
            if (r5 == 0) goto L_0x02c2
            androidx.compose.material3.SliderKt$RangeSlider$9 r5 = new androidx.compose.material3.SliderKt$RangeSlider$9
            r5.<init>(r7, r11)
            r13 = -429193201(0xffffffffe66b080f, float:-2.774762E23)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r6, r5)
            kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
            goto L_0x02c4
        L_0x02c2:
            r5 = r38
        L_0x02c4:
            r6 = r31
            if (r10 == 0) goto L_0x02cd
            r10 = r4
            r13 = r5
            r16 = 0
            goto L_0x02d1
        L_0x02cd:
            r16 = r39
            r10 = r4
            r13 = r5
        L_0x02d1:
            r4 = r0
            r5 = r3
            r0 = r29
            r3 = r30
        L_0x02d7:
            r1.endDefaults()
            boolean r18 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r18 == 0) goto L_0x02eb
            r18 = r7
            java.lang.String r7 = "androidx.compose.material3.RangeSlider (Slider.kt:543)"
            r15 = -1048796133(0xffffffffc17ca41b, float:-15.790065)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r6, r8, r7)
            goto L_0x02ed
        L_0x02eb:
            r18 = r7
        L_0x02ed:
            int r7 = r6 >> 15
            r7 = r7 & 14
            androidx.compose.runtime.State r7 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r14, r1, r7)
            r15 = -223507747(0xfffffffff2ad8add, float:-6.874724E30)
            r1.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            r15 = r8 & 896(0x380, float:1.256E-42)
            r19 = r14
            r14 = 256(0x100, float:3.59E-43)
            if (r15 != r14) goto L_0x0308
            r14 = 1
            goto L_0x0309
        L_0x0308:
            r14 = 0
        L_0x0309:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r6
            r15 = r15 ^ 24576(0x6000, float:3.4438E-41)
            r20 = r13
            r13 = 16384(0x4000, float:2.2959E-41)
            if (r15 <= r13) goto L_0x031b
            boolean r15 = r1.changed((java.lang.Object) r3)
            if (r15 != 0) goto L_0x031f
        L_0x031b:
            r15 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r15 != r13) goto L_0x0321
        L_0x031f:
            r13 = 1
            goto L_0x0322
        L_0x0321:
            r13 = 0
        L_0x0322:
            r13 = r13 | r14
            java.lang.Object r14 = r1.rememberedValue()
            if (r13 != 0) goto L_0x0335
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x0332
            goto L_0x0335
        L_0x0332:
            r22 = r10
            goto L_0x0367
        L_0x0335:
            androidx.compose.material3.RangeSliderState r14 = new androidx.compose.material3.RangeSliderState
            java.lang.Comparable r13 = r27.getStart()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            java.lang.Comparable r15 = r27.getEndInclusive()
            java.lang.Number r15 = (java.lang.Number) r15
            float r15 = r15.floatValue()
            r22 = r10
            androidx.compose.material3.SliderKt$RangeSlider$state$1$1 r10 = new androidx.compose.material3.SliderKt$RangeSlider$state$1$1
            r10.<init>(r7)
            r7 = r10
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r29 = r14
            r30 = r13
            r31 = r15
            r32 = r16
            r33 = r7
            r34 = r3
            r29.<init>(r30, r31, r32, r33, r34)
            r1.updateRememberedValue(r14)
        L_0x0367:
            r7 = r14
            androidx.compose.material3.RangeSliderState r7 = (androidx.compose.material3.RangeSliderState) r7
            r1.endReplaceableGroup()
            r10 = -223507467(0xfffffffff2ad8bf5, float:-6.8748934E30)
            r1.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            r10 = r6 & 112(0x70, float:1.57E-43)
            r12 = 32
            if (r10 != r12) goto L_0x037e
            r12 = 1
            goto L_0x037f
        L_0x037e:
            r12 = 0
        L_0x037f:
            java.lang.Object r10 = r1.rememberedValue()
            if (r12 != 0) goto L_0x038d
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x0397
        L_0x038d:
            androidx.compose.material3.SliderKt$RangeSlider$10$1 r10 = new androidx.compose.material3.SliderKt$RangeSlider$10$1
            r10.<init>(r2)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r1.updateRememberedValue(r10)
        L_0x0397:
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r1.endReplaceableGroup()
            r7.setOnValueChange$material3_release(r10)
            java.lang.Comparable r10 = r27.getStart()
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            r7.setActiveRangeStart(r10)
            java.lang.Comparable r10 = r27.getEndInclusive()
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            r7.setActiveRangeEnd(r10)
            int r10 = r6 >> 3
            r10 = r10 & 1008(0x3f0, float:1.413E-42)
            int r6 = r6 >> 9
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r6
            r10 = r10 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r6
            r10 = r10 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r12
            r6 = r6 | r10
            int r8 = r8 << 21
            r10 = 29360128(0x1c00000, float:7.052966E-38)
            r10 = r10 & r8
            r6 = r6 | r10
            r10 = 234881024(0xe000000, float:1.5777218E-30)
            r8 = r8 & r10
            r6 = r6 | r8
            r8 = 8
            r10 = 0
            r29 = r7
            r30 = r0
            r31 = r11
            r32 = r10
            r33 = r9
            r34 = r4
            r35 = r5
            r36 = r22
            r37 = r20
            r38 = r1
            r39 = r6
            r40 = r8
            RangeSlider(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x03fd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03fd:
            r10 = r5
            r8 = r9
            r13 = r16
            r7 = r18
            r6 = r19
            r12 = r20
            r5 = r3
            r9 = r4
            r4 = r11
            r11 = r22
            r3 = r0
        L_0x040d:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 == 0) goto L_0x042f
            androidx.compose.material3.SliderKt$RangeSlider$11 r17 = new androidx.compose.material3.SliderKt$RangeSlider$11
            r0 = r17
            r1 = r27
            r2 = r28
            r14 = r41
            r26 = r15
            r15 = r42
            r16 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r26
            r1.updateScope(r0)
        L_0x042f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, int, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(androidx.compose.material3.RangeSliderState r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.material3.SliderColors r25, androidx.compose.foundation.interaction.MutableInteractionSource r26, androidx.compose.foundation.interaction.MutableInteractionSource r27, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r10 = r32
            r11 = r33
            r0 = 511405654(0x1e7b6e56, float:1.3310646E-20)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(RangeSlider)P(7,4,1!1,5!1,6)624@27533L8,625@27598L39,626@27692L39,651@28465L295:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r10 | 6
            r3 = r2
            r2 = r22
            goto L_0x0030
        L_0x001c:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r22
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r10
            goto L_0x0030
        L_0x002d:
            r2 = r22
            r3 = r10
        L_0x0030:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x004a
            r5 = r23
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
            r5 = r23
        L_0x004c:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0066
            r7 = r24
            boolean r8 = r1.changed((boolean) r7)
            if (r8 == 0) goto L_0x0062
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r8
            goto L_0x0068
        L_0x0066:
            r7 = r24
        L_0x0068:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0081
            r8 = r11 & 8
            if (r8 != 0) goto L_0x007b
            r8 = r25
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007b:
            r8 = r25
        L_0x007d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r3 = r3 | r9
            goto L_0x0083
        L_0x0081:
            r8 = r25
        L_0x0083:
            r9 = r11 & 16
            if (r9 == 0) goto L_0x008a
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008a:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009d
            r12 = r26
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0099
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r3 = r3 | r13
            goto L_0x009f
        L_0x009d:
            r12 = r26
        L_0x009f:
            r13 = r11 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a7
            r3 = r3 | r14
            goto L_0x00b9
        L_0x00a7:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b9
            r14 = r27
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b5
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r3 = r3 | r15
            goto L_0x00bb
        L_0x00b9:
            r14 = r27
        L_0x00bb:
            r15 = r11 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c6
            r3 = r3 | r16
            r0 = r28
            goto L_0x00d9
        L_0x00c6:
            r16 = r10 & r16
            r0 = r28
            if (r16 != 0) goto L_0x00d9
            boolean r17 = r1.changedInstance(r0)
            if (r17 == 0) goto L_0x00d5
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r3 = r3 | r17
        L_0x00d9:
            r0 = r11 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e4
            r3 = r3 | r17
            r2 = r29
            goto L_0x00f7
        L_0x00e4:
            r17 = r10 & r17
            r2 = r29
            if (r17 != 0) goto L_0x00f7
            boolean r17 = r1.changedInstance(r2)
            if (r17 == 0) goto L_0x00f3
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f3:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r3 = r3 | r17
        L_0x00f7:
            r2 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r2 == 0) goto L_0x0102
            r3 = r3 | r17
            r5 = r30
            goto L_0x0115
        L_0x0102:
            r17 = r10 & r17
            r5 = r30
            if (r17 != 0) goto L_0x0115
            boolean r17 = r1.changedInstance(r5)
            if (r17 == 0) goto L_0x0111
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r3 = r3 | r17
        L_0x0115:
            r17 = 38347923(0x2492493, float:1.4777644E-37)
            r5 = r3 & r17
            r7 = 38347922(0x2492492, float:1.4777643E-37)
            if (r5 != r7) goto L_0x0138
            boolean r5 = r1.getSkipping()
            if (r5 != 0) goto L_0x0126
            goto L_0x0138
        L_0x0126:
            r1.skipToGroupEnd()
            r2 = r23
            r3 = r24
            r7 = r28
            r9 = r30
            r4 = r8
            r5 = r12
            r6 = r14
            r8 = r29
            goto L_0x0266
        L_0x0138:
            r1.startDefaults()
            r5 = r10 & 1
            if (r5 == 0) goto L_0x015f
            boolean r5 = r1.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0146
            goto L_0x015f
        L_0x0146:
            r1.skipToGroupEnd()
            r0 = r11 & 8
            if (r0 == 0) goto L_0x014f
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014f:
            r4 = r23
            r6 = r24
            r0 = r28
            r2 = r29
            r5 = r3
            r7 = r8
            r9 = r12
            r8 = r14
        L_0x015b:
            r3 = r30
            goto L_0x020a
        L_0x015f:
            if (r4 == 0) goto L_0x0166
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0168
        L_0x0166:
            r4 = r23
        L_0x0168:
            r5 = 1
            if (r6 == 0) goto L_0x016d
            r6 = r5
            goto L_0x016f
        L_0x016d:
            r6 = r24
        L_0x016f:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x017d
            androidx.compose.material3.SliderDefaults r7 = androidx.compose.material3.SliderDefaults.INSTANCE
            r8 = 6
            androidx.compose.material3.SliderColors r7 = r7.colors(r1, r8)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x017e
        L_0x017d:
            r7 = r8
        L_0x017e:
            java.lang.String r8 = "CC(remember):Slider.kt#9igjgp"
            if (r9 == 0) goto L_0x01a4
            r9 = -223504269(0xfffffffff2ad9873, float:-6.8768264E30)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            java.lang.Object r9 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r9 != r12) goto L_0x019e
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r9)
        L_0x019e:
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = (androidx.compose.foundation.interaction.MutableInteractionSource) r9
            r1.endReplaceableGroup()
            goto L_0x01a5
        L_0x01a4:
            r9 = r12
        L_0x01a5:
            if (r13 == 0) goto L_0x01c9
            r12 = -223504175(0xfffffffff2ad98d1, float:-6.876883E30)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            java.lang.Object r8 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r8 != r12) goto L_0x01c3
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r8)
        L_0x01c3:
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = (androidx.compose.foundation.interaction.MutableInteractionSource) r8
            r1.endReplaceableGroup()
            goto L_0x01ca
        L_0x01c9:
            r8 = r14
        L_0x01ca:
            if (r15 == 0) goto L_0x01db
            androidx.compose.material3.SliderKt$RangeSlider$14 r12 = new androidx.compose.material3.SliderKt$RangeSlider$14
            r12.<init>(r9, r7, r6)
            r13 = 1884205643(0x704eb24b, float:2.5587782E29)
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r5, r12)
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12
            goto L_0x01dd
        L_0x01db:
            r12 = r28
        L_0x01dd:
            if (r0 == 0) goto L_0x01ee
            androidx.compose.material3.SliderKt$RangeSlider$15 r0 = new androidx.compose.material3.SliderKt$RangeSlider$15
            r0.<init>(r8, r7, r6)
            r13 = 1016457138(0x3c95e7b2, float:0.018298957)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r5, r0)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            goto L_0x01f0
        L_0x01ee:
            r0 = r29
        L_0x01f0:
            if (r2 == 0) goto L_0x0205
            androidx.compose.material3.SliderKt$RangeSlider$16 r2 = new androidx.compose.material3.SliderKt$RangeSlider$16
            r2.<init>(r7, r6)
            r13 = -1617375262(0xffffffff9f98cfe2, float:-6.471842E-20)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r5, r2)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r5 = r3
            r3 = r2
            r2 = r0
            r0 = r12
            goto L_0x020a
        L_0x0205:
            r2 = r0
            r5 = r3
            r0 = r12
            goto L_0x015b
        L_0x020a:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x021c
            r12 = -1
            java.lang.String r13 = "androidx.compose.material3.RangeSlider (Slider.kt:648)"
            r14 = 511405654(0x1e7b6e56, float:1.3310646E-20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r5, r12, r13)
        L_0x021c:
            int r12 = r22.getSteps()
            if (r12 < 0) goto L_0x027e
            int r12 = r5 >> 3
            r13 = r12 & 14
            int r14 = r5 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            r5 = r5 & 896(0x380, float:1.256E-42)
            r5 = r5 | r13
            r13 = r12 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r12
            r5 = r5 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r12
            r5 = r5 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r12
            r5 = r5 | r13
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r13
            r21 = r5 | r12
            r12 = r4
            r13 = r22
            r14 = r6
            r15 = r9
            r16 = r8
            r17 = r0
            r18 = r2
            r19 = r3
            r20 = r1
            RangeSliderImpl(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x025e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x025e:
            r5 = r9
            r9 = r3
            r3 = r6
            r6 = r8
            r8 = r2
            r2 = r4
            r4 = r7
            r7 = r0
        L_0x0266:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x027d
            androidx.compose.material3.SliderKt$RangeSlider$18 r13 = new androidx.compose.material3.SliderKt$RangeSlider$18
            r0 = r13
            r1 = r22
            r10 = r32
            r11 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x027d:
            return
        L_0x027e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SliderImpl(androidx.compose.ui.Modifier r25, androidx.compose.material3.SliderState r26, boolean r27, androidx.compose.foundation.interaction.MutableInteractionSource r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32) {
        /*
            r2 = r26
            r14 = r27
            r15 = r28
            r1 = r29
            r0 = r30
            r13 = r32
            r3 = 1390990089(0x52e8d309, float:4.99986498E11)
            r4 = r31
            androidx.compose.runtime.Composer r12 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(SliderImpl)P(2,3)673@29093L7,684@29451L28,711@30244L1254,689@29563L1935:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            r4 = r13 & 6
            r11 = r25
            if (r4 != 0) goto L_0x002b
            boolean r4 = r12.changed((java.lang.Object) r11)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r13
            goto L_0x002c
        L_0x002b:
            r4 = r13
        L_0x002c:
            r5 = r13 & 48
            r10 = 32
            if (r5 != 0) goto L_0x003d
            boolean r5 = r12.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x003a
            r5 = r10
            goto L_0x003c
        L_0x003a:
            r5 = 16
        L_0x003c:
            r4 = r4 | r5
        L_0x003d:
            r5 = r13 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x004d
            boolean r5 = r12.changed((boolean) r14)
            if (r5 == 0) goto L_0x004a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x004c
        L_0x004a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x004c:
            r4 = r4 | r5
        L_0x004d:
            r5 = r13 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x005d
            boolean r5 = r12.changed((java.lang.Object) r15)
            if (r5 == 0) goto L_0x005a
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x005c
        L_0x005a:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x005c:
            r4 = r4 | r5
        L_0x005d:
            r5 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x006d
            boolean r5 = r12.changedInstance(r1)
            if (r5 == 0) goto L_0x006a
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006c
        L_0x006a:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x006c:
            r4 = r4 | r5
        L_0x006d:
            r5 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x007e
            boolean r5 = r12.changedInstance(r0)
            if (r5 == 0) goto L_0x007b
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x007d
        L_0x007b:
            r5 = 65536(0x10000, float:9.18355E-41)
        L_0x007d:
            r4 = r4 | r5
        L_0x007e:
            r9 = r4
            r4 = 74899(0x12493, float:1.04956E-40)
            r4 = r4 & r9
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r5) goto L_0x0096
            boolean r4 = r12.getSkipping()
            if (r4 != 0) goto L_0x008f
            goto L_0x0096
        L_0x008f:
            r12.skipToGroupEnd()
            r3 = r0
            r5 = r12
            goto L_0x03de
        L_0x0096:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00a2
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.SliderImpl (Slider.kt:672)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r9, r4, r5)
        L_0x00a2:
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r5)
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r4 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r16 = 1
            if (r3 != r4) goto L_0x00c0
            r3 = r16
            goto L_0x00c1
        L_0x00c0:
            r3 = 0
        L_0x00c1:
            r2.setRtl$material3_release(r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r7 = sliderTapModifier(r3, r2, r15, r14)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r5 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r17 = r26.isRtl$material3_release()
            boolean r18 = r26.isDragging$material3_release()
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = r2
            androidx.compose.foundation.gestures.DraggableState r4 = (androidx.compose.foundation.gestures.DraggableState) r4
            r6 = 1114013383(0x42667ec7, float:57.623806)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            r13 = r9 & 112(0x70, float:1.57E-43)
            if (r13 != r10) goto L_0x00ef
            r19 = r16
            goto L_0x00f1
        L_0x00ef:
            r19 = 0
        L_0x00f1:
            java.lang.Object r8 = r12.rememberedValue()
            if (r19 != 0) goto L_0x00ff
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r19.getEmpty()
            if (r8 != r10) goto L_0x010a
        L_0x00ff:
            androidx.compose.material3.SliderKt$SliderImpl$drag$1$1 r8 = new androidx.compose.material3.SliderKt$SliderImpl$drag$1$1
            r10 = 0
            r8.<init>(r2, r10)
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            r12.updateRememberedValue(r8)
        L_0x010a:
            r10 = r8
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            r12.endReplaceableGroup()
            r19 = 32
            r20 = 0
            r21 = 0
            r8 = r6
            r6 = r27
            r22 = r7
            r7 = r28
            r23 = r8
            r8 = r18
            r18 = r9
            r9 = r21
            r11 = r17
            r24 = r12
            r12 = r19
            r0 = r13
            r13 = r20
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            androidx.compose.ui.Modifier r4 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r25)
            androidx.compose.material3.tokens.SliderTokens r5 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r5 = r5.m3134getHandleWidthD9Ej5fM()
            androidx.compose.material3.tokens.SliderTokens r6 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r6 = r6.m3133getHandleHeightD9Ej5fM()
            r9 = 12
            r10 = 0
            r7 = 0
            r8 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m738requiredSizeInqDBjuR0$default(r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.Modifier r4 = sliderSemantics(r4, r2, r14)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.FocusableKt.focusable(r4, r14, r15)
            r5 = r22
            androidx.compose.ui.Modifier r4 = r4.then(r5)
            androidx.compose.ui.Modifier r3 = r4.then(r3)
            r4 = 1114014176(0x426681e0, float:57.62683)
            r5 = r24
            r5.startReplaceableGroup(r4)
            r4 = r23
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            r4 = 32
            if (r0 != r4) goto L_0x016f
            goto L_0x0171
        L_0x016f:
            r16 = 0
        L_0x0171:
            java.lang.Object r0 = r5.rememberedValue()
            if (r16 != 0) goto L_0x017f
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r0 != r4) goto L_0x0189
        L_0x017f:
            androidx.compose.material3.SliderKt$SliderImpl$2$1 r0 = new androidx.compose.material3.SliderKt$SliderImpl$2$1
            r0.<init>(r2)
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            r5.updateRememberedValue(r0)
        L_0x0189:
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            r5.endReplaceableGroup()
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r4)
            java.lang.String r6 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r7 = 0
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r7)
            androidx.compose.runtime.CompositionLocalMap r9 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            androidx.compose.runtime.Applier r11 = r5.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x01b7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b7:
            r5.startReusableNode()
            boolean r11 = r5.getInserting()
            if (r11 == 0) goto L_0x01c4
            r5.createNode(r10)
            goto L_0x01c7
        L_0x01c4:
            r5.useNode()
        L_0x01c7:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3282constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r10, r0, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r10, r9, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r9 = r10.getInserting()
            if (r9 != 0) goto L_0x01f7
            java.lang.Object r9 = r10.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r9 != 0) goto L_0x0205
        L_0x01f7:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r10.updateRememberedValue(r9)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10.apply(r8, r0)
        L_0x0205:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r0)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r3.invoke(r0, r5, r8)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r0)
            r3 = 1541261174(0x5bddc776, float:1.24850559E17)
            java.lang.String r8 = "C691@29593L102,694@29708L102:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r8)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.material3.SliderComponents r8 = androidx.compose.material3.SliderComponents.THUMB
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r8)
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r5.startReplaceableGroup(r8)
            java.lang.String r9 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r7, r5, r7)
            r5.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r7)
            androidx.compose.runtime.CompositionLocalMap r12 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            androidx.compose.runtime.Applier r4 = r5.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x0264
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0264:
            r5.startReusableNode()
            boolean r4 = r5.getInserting()
            if (r4 == 0) goto L_0x0271
            r5.createNode(r13)
            goto L_0x0274
        L_0x0271:
            r5.useNode()
        L_0x0274:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3282constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r10, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r12, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetCompositeKeyHash()
            boolean r12 = r4.getInserting()
            if (r12 != 0) goto L_0x02a4
            java.lang.Object r12 = r4.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 != 0) goto L_0x02b2
        L_0x02a4:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r4.updateRememberedValue(r12)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r4.apply(r11, r10)
        L_0x02b2:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r4)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            r3.invoke(r4, r5, r10)
            r5.startReplaceableGroup(r0)
            r3 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r4 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r10 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r10 = (androidx.compose.foundation.layout.BoxScope) r10
            r10 = -1819482525(0xffffffff938ce663, float:-3.5568147E-27)
            java.lang.String r11 = "C692@29669L12:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r11)
            int r10 = r18 >> 3
            r10 = r10 & 14
            int r11 = r18 >> 9
            r11 = r11 & 112(0x70, float:1.57E-43)
            r11 = r11 | r10
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r1.invoke(r2, r5, r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            androidx.compose.material3.SliderComponents r12 = androidx.compose.material3.SliderComponents.TRACK
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r11, r12)
            r5.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r7, r5, r7)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r7)
            androidx.compose.runtime.CompositionLocalMap r9 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r11)
            androidx.compose.runtime.Applier r13 = r5.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x033a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x033a:
            r5.startReusableNode()
            boolean r13 = r5.getInserting()
            if (r13 == 0) goto L_0x0347
            r5.createNode(r12)
            goto L_0x034a
        L_0x0347:
            r5.useNode()
        L_0x034a:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m3282constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r8, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r9, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetCompositeKeyHash()
            boolean r9 = r12.getInserting()
            if (r9 != 0) goto L_0x037a
            java.lang.Object r9 = r12.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r9 != 0) goto L_0x0388
        L_0x037a:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r12.updateRememberedValue(r9)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r12.apply(r6, r8)
        L_0x0388:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r11.invoke(r6, r5, r7)
            r5.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1819482410(0xffffffff938ce6d6, float:-3.556859E-27)
            java.lang.String r3 = "C695@29784L12:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r3)
            int r0 = r18 >> 12
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r10
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3 = r30
            r3.invoke(r2, r5, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03de
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03de:
            androidx.compose.runtime.ScopeUpdateScope r8 = r5.endRestartGroup()
            if (r8 == 0) goto L_0x03fd
            androidx.compose.material3.SliderKt$SliderImpl$3 r9 = new androidx.compose.material3.SliderKt$SliderImpl$3
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
        L_0x03fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.SliderImpl(androidx.compose.ui.Modifier, androidx.compose.material3.SliderState, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void RangeSliderImpl(Modifier modifier, RangeSliderState rangeSliderState, boolean z, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, int i) {
        int i2;
        RangeSliderState rangeSliderState2 = rangeSliderState;
        boolean z2 = z;
        MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34 = function3;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35 = function32;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36 = function33;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1411725677);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSliderImpl)P(3,6!1,4!1,5)763@31973L7,775@32367L35,776@32435L33,807@33617L2386,778@32474L3529:Slider.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) rangeSliderState2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource3) ? 2048 : 1024;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource4) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function34) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function35) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function36) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411725677, i2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:762)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            rangeSliderState2.setRtl$material3_release(consume == LayoutDirection.Rtl);
            Modifier rangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.Companion, rangeSliderState2, mutableInteractionSource3, mutableInteractionSource4, z2);
            Modifier rangeSliderStartThumbSemantics = rangeSliderStartThumbSemantics(Modifier.Companion, rangeSliderState2, z2);
            Modifier rangeSliderEndThumbSemantics = rangeSliderEndThumbSemantics(Modifier.Companion, rangeSliderState2, z2);
            Strings.Companion companion = Strings.Companion;
            String r13 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.range_start), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.Companion;
            String r9 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.range_end), startRestartGroup, 0);
            Modifier then = SizeKt.m738requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), SliderTokens.INSTANCE.m3134getHandleWidthD9Ej5fM(), SliderTokens.INSTANCE.m3133getHandleHeightD9Ej5fM(), 0.0f, 0.0f, 12, (Object) null).then(rangeSliderPressDragModifier);
            startRestartGroup.startReplaceableGroup(1300547382);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean z3 = (i2 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SliderKt$RangeSliderImpl$2$1(rangeSliderState2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifier3 = rangeSliderEndThumbSemantics;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2040261250, "C782@32640L84,780@32504L359,790@33010L82,788@32876L349,796@33238L107:Slider.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.STARTTHUMB);
            startRestartGroup.startReplaceableGroup(-2040261114);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) r13);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SliderKt$RangeSliderImpl$1$1$1(r13);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then2 = FocusableKt.focusable(SemanticsModifierKt.semantics(layoutId, true, (Function1) rememberedValue2), z2, mutableInteractionSource3).then(rangeSliderStartThumbSemantics);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r0 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r0, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r0, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r0.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551475, "C787@32844L17:Slider.kt#uh7d8r");
            int i4 = (i2 >> 3) & 14;
            function34.invoke(rangeSliderState2, startRestartGroup, Integer.valueOf(((i2 >> 12) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.ENDTHUMB);
            startRestartGroup.startReplaceableGroup(-2040260744);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed((Object) r9);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new SliderKt$RangeSliderImpl$1$3$1(r9);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = FocusableKt.focusable(SemanticsModifierKt.semantics(layoutId2, true, (Function1) rememberedValue3), z2, mutableInteractionSource2).then(modifier3);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(then3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer r02 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r02, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r02, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r02.getInserting() || !Intrinsics.areEqual(r02.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r02.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r02.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            modifierMaterializerOf3.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551839, "C795@33208L15:Slider.kt#uh7d8r");
            function32.invoke(rangeSliderState2, startRestartGroup, Integer.valueOf(((i2 >> 15) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.TRACK);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(layoutId3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer r132 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r132, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r132, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r132.getInserting() || !Intrinsics.areEqual(r132.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                r132.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                r132.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551950, "C797@33319L12:Slider.kt#uh7d8r");
            function33.invoke(rangeSliderState2, startRestartGroup, Integer.valueOf(((i2 >> 18) & 112) | i4));
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
        } else {
            startRestartGroup.skipToGroupEnd();
            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
            Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37 = function35;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSliderImpl$3(modifier, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, i));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m2195awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L_0x0019:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r8 = r6.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0058
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r1 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r1.<init>(r12)
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6.L$0 = r12
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material3.DragGestureDetectorCopyKt.m1819awaitHorizontalPointerSlopOrCancellationgDDlDlE(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L_0x0055
            return r0
        L_0x0055:
            r7 = r12
            r12 = r8
            r8 = r7
        L_0x0058:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L_0x0067
            float r8 = r8.element
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r12, r8)
            goto L_0x0068
        L_0x0067:
            r8 = 0
        L_0x0068:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m2195awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i2 = i + 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = ((float) i3) / ((float) (i + 1));
        }
        return fArr;
    }

    /* access modifiers changed from: private */
    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* access modifiers changed from: private */
    /* renamed from: scale-ziovWd0  reason: not valid java name */
    public static final long m2198scaleziovWd0(float f, float f2, long j, float f3, float f4) {
        return SliderRange(scale(f, f2, SliderRange.m2209getStartimpl(j), f3, f4), scale(f, f2, SliderRange.m2208getEndInclusiveimpl(j), f3, f4));
    }

    /* access modifiers changed from: private */
    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return RangesKt.coerceIn(f4 == 0.0f ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    private static final Modifier sliderSemantics(Modifier modifier, SliderState sliderState, boolean z) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$sliderSemantics$1(z, sliderState), 1, (Object) null), sliderState.getValue(), RangesKt.rangeTo(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue()), sliderState.getSteps());
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier modifier, RangeSliderState rangeSliderState, boolean z) {
        ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(rangeSliderState.getValueRange().getStart().floatValue(), rangeSliderState.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$rangeSliderStartThumbSemantics$1(z, rangeTo, rangeSliderState), 1, (Object) null), rangeSliderState.getActiveRangeStart(), rangeTo, rangeSliderState.getStartSteps$material3_release());
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier modifier, RangeSliderState rangeSliderState, boolean z) {
        ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(rangeSliderState.getActiveRangeStart(), rangeSliderState.getValueRange().getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$rangeSliderEndThumbSemantics$1(z, rangeTo, rangeSliderState), 1, (Object) null), rangeSliderState.getActiveRangeEnd(), rangeTo, rangeSliderState.getEndSteps$material3_release());
    }

    private static final Modifier sliderTapModifier(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, sliderState, mutableInteractionSource, new SliderKt$sliderTapModifier$1(sliderState, (Continuation<? super SliderKt$sliderTapModifier$1>) null)) : modifier;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z) {
        if (!z) {
            return modifier;
        }
        return SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(rangeSliderState, mutableInteractionSource, mutableInteractionSource2, (Continuation<? super SliderKt$rangeSliderPressDragModifier$1>) null));
    }

    static {
        float r0 = SliderTokens.INSTANCE.m3134getHandleWidthD9Ej5fM();
        ThumbWidth = r0;
        float r1 = SliderTokens.INSTANCE.m3133getHandleHeightD9Ej5fM();
        ThumbHeight = r1;
        ThumbSize = DpKt.m6636DpSizeYgX7TsA(r0, r1);
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    public static final long SliderRange(float f, float f2) {
        if ((!Float.isNaN(f) || !Float.isNaN(f2)) && f > f2) {
            throw new IllegalArgumentException(("start(" + f + ") must be <= endInclusive(" + f2 + ')').toString());
        }
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f);
        return SliderRange.m2205constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (floatToRawIntBits << 32));
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        float floatValue = closedFloatingPointRange.getStart().floatValue();
        float floatValue2 = closedFloatingPointRange.getEndInclusive().floatValue();
        if ((Float.isNaN(floatValue) && Float.isNaN(floatValue2)) || floatValue <= floatValue2) {
            return SliderRange.m2205constructorimpl((((long) Float.floatToRawIntBits(floatValue)) << 32) | (((long) Float.floatToRawIntBits(floatValue2)) & 4294967295L));
        }
        throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + floatValue + ") must be <= ClosedFloatingPoint.endInclusive(" + floatValue2 + ')').toString());
    }

    /* renamed from: isSpecified-If1S1O4  reason: not valid java name */
    public static final boolean m2196isSpecifiedIf1S1O4(long j) {
        return j != SliderRange.Companion.m2214getUnspecifiedFYbKRX4();
    }

    /* access modifiers changed from: private */
    public static final float snapValueToTick(float f, float[] fArr, float f2, float f3) {
        Float f4;
        if (fArr.length == 0) {
            f4 = null;
        } else {
            float f5 = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex == 0) {
                f4 = Float.valueOf(f5);
            } else {
                float abs = Math.abs(MathHelpersKt.lerp(f2, f3, f5) - f);
                IntIterator it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    float f6 = fArr[it.nextInt()];
                    float abs2 = Math.abs(MathHelpersKt.lerp(f2, f3, f6) - f);
                    if (Float.compare(abs, abs2) > 0) {
                        f5 = f6;
                        abs = abs2;
                    }
                }
                f4 = Float.valueOf(f5);
            }
        }
        return f4 != null ? MathHelpersKt.lerp(f2, f3, f4.floatValue()) : f;
    }
}
