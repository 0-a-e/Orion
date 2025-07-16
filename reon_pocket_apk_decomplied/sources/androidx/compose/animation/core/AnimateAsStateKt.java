package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aH\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u00022\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010!\u001aW\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\"\u001aC\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010$\u001aM\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010%\u001aH\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aR\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aH\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010(\u001aR\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010*\u001aH\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010(\u001aR\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010*\u001aC\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00102\u001aM\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00103\u001aH\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u0010(\u001aR\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u0010*\u001as\u00107\u001a\b\u0012\u0004\u0012\u0002H80\u0012\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H80\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H82\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010=\u001a}\u00107\u001a\b\u0012\u0004\u0012\u0002H80\u0012\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H80\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H82\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010>\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?²\u0006(\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:X\u0002²\u0006 \u0010A\u001a\b\u0012\u0004\u0012\u0002H80\u0015\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:X\u0002"}, d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "dpDefaultSpring", "Landroidx/compose/ui/unit/Dp;", "intDefaultSpring", "", "intOffsetDefaultSpring", "Landroidx/compose/ui/unit/IntOffset;", "intSizeDefaultSpring", "Landroidx/compose/ui/unit/IntSize;", "offsetDefaultSpring", "Landroidx/compose/ui/geometry/Offset;", "rectDefaultSpring", "Landroidx/compose/ui/geometry/Rect;", "sizeDefaultSpring", "Landroidx/compose/ui/geometry/Size;", "animateDpAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "label", "", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloatAsState", "visibilityThreshold", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntAsState", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(ILandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState", "animateIntOffsetAsState-8f6pmRE", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState-HyPO7BM", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntSizeAsState", "animateIntSizeAsState-zTRF_AQ", "animateIntSizeAsState-4goxYXU", "animateOffsetAsState", "animateOffsetAsState-N6fFfp4", "animateOffsetAsState-7362WCg", "animateRectAsState", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState", "animateSizeAsState-LjSzlW0", "animateSizeAsState-YLp_XPw", "animateValueAsState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release", "listener", "animSpec"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimateAsState.kt */
public final class AnimateAsStateKt {
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m6612boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, (Object) null);
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, (Object) null);
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m6782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, (Object) null);
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m3551boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, (Object) null);
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, (Object) null);
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m3619boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, (Object) null);

    public static final State<Float> animateFloatAsState(float f, AnimationSpec<Float> animationSpec, float f2, String str, Function1<? super Float, Unit> function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(668842840);
        ComposerKt.sourceInformation(composer, "C(animateFloatAsState)P(3!1,4,2)75@3368L173:AnimateAsState.kt#pdpnli");
        AnimationSpec<Float> animationSpec2 = (i2 & 2) != 0 ? defaultAnimation : animationSpec;
        float f3 = (i2 & 4) != 0 ? 0.01f : f2;
        String str2 = (i2 & 8) != 0 ? "FloatAnimation" : str;
        Function1<? super Float, Unit> function12 = (i2 & 16) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(668842840, i3, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:68)");
        }
        composer.startReplaceableGroup(841393662);
        ComposerKt.sourceInformation(composer, "71@3220L83");
        if (animationSpec2 == defaultAnimation) {
            Float valueOf = Float.valueOf(f3);
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = composer.changed((Object) valueOf);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, Float.valueOf(f3), 3, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) rememberedValue;
        }
        composer.endReplaceableGroup();
        int i4 = i3 & 14;
        int i5 = i3 << 3;
        State<Float> animateValueAsState = animateValueAsState(Float.valueOf(f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), animationSpec2, Float.valueOf(f3), str2, function12, composer, (i5 & 7168) | i4 | (57344 & i5) | (i5 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateDpAsState-AjpBEmI  reason: not valid java name */
    public static final State<Dp> m119animateDpAsStateAjpBEmI(float f, AnimationSpec<Dp> animationSpec, String str, Function1<? super Dp, Unit> function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(-1407150062);
        ComposerKt.sourceInformation(composer, "C(animateDpAsState)P(3:c#ui.unit.Dp!1,2)114@5081L165:AnimateAsState.kt#pdpnli");
        AnimationSpec<Dp> animationSpec2 = (i2 & 2) != 0 ? dpDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "DpAnimation" : str;
        Function1<? super Dp, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1407150062, i, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:113)");
        }
        int i4 = i3 << 6;
        State<Dp> animateValueAsState = animateValueAsState(Dp.m6612boximpl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), animationSpec2, (Dp) null, str2, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateSizeAsState-YLp_XPw  reason: not valid java name */
    public static final State<Size> m128animateSizeAsStateYLp_XPw(long j, AnimationSpec<Size> animationSpec, String str, Function1<? super Size, Unit> function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(1374633148);
        ComposerKt.sourceInformation(composer, "C(animateSizeAsState)P(3:c#ui.geometry.Size!1,2)155@6928L167:AnimateAsState.kt#pdpnli");
        AnimationSpec<Size> animationSpec2 = (i2 & 2) != 0 ? sizeDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "SizeAnimation" : str;
        Function1<? super Size, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1374633148, i3, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:154)");
        }
        int i4 = i3 << 6;
        State<Size> animateValueAsState = animateValueAsState(Size.m3619boximpl(j), VectorConvertersKt.getVectorConverter(Size.Companion), animationSpec2, (Size) null, str2, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateOffsetAsState-7362WCg  reason: not valid java name */
    public static final State<Offset> m125animateOffsetAsState7362WCg(long j, AnimationSpec<Offset> animationSpec, String str, Function1<? super Offset, Unit> function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(357896800);
        ComposerKt.sourceInformation(composer, "C(animateOffsetAsState)P(3:c#ui.geometry.Offset!1,2)195@8761L169:AnimateAsState.kt#pdpnli");
        AnimationSpec<Offset> animationSpec2 = (i2 & 2) != 0 ? offsetDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "OffsetAnimation" : str;
        Function1<? super Offset, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(357896800, i3, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:194)");
        }
        int i4 = i3 << 6;
        State<Offset> animateValueAsState = animateValueAsState(Offset.m3551boximpl(j), VectorConvertersKt.getVectorConverter(Offset.Companion), animationSpec2, (Offset) null, str2, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final State<Rect> animateRectAsState(Rect rect, AnimationSpec<Rect> animationSpec, String str, Function1<? super Rect, Unit> function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(536062978);
        ComposerKt.sourceInformation(composer, "C(animateRectAsState)P(3!1,2)236@10633L167:AnimateAsState.kt#pdpnli");
        AnimationSpec<Rect> animationSpec2 = (i2 & 2) != 0 ? rectDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "RectAnimation" : str;
        Function1<? super Rect, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(536062978, i, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:235)");
        }
        int i4 = i3 << 6;
        State<Rect> animateValueAsState = animateValueAsState(rect, VectorConvertersKt.getVectorConverter(Rect.Companion), animationSpec2, (Rect) null, str2, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final State<Integer> animateIntAsState(int i, AnimationSpec<Integer> animationSpec, String str, Function1<? super Integer, Unit> function1, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i2;
        composer.startReplaceableGroup(428074472);
        ComposerKt.sourceInformation(composer, "C(animateIntAsState)P(3!1,2)274@12363L166:AnimateAsState.kt#pdpnli");
        AnimationSpec<Integer> animationSpec2 = (i3 & 2) != 0 ? intDefaultSpring : animationSpec;
        String str2 = (i3 & 4) != 0 ? "IntAnimation" : str;
        Function1<? super Integer, Unit> function12 = (i3 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(428074472, i2, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:273)");
        }
        int i5 = i4 << 6;
        State<Integer> animateValueAsState = animateValueAsState(Integer.valueOf(i), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, (Integer) null, str2, function12, composer, (i4 & 14) | ((i4 << 3) & 896) | (57344 & i5) | (i5 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateIntOffsetAsState-HyPO7BM  reason: not valid java name */
    public static final State<IntOffset> m122animateIntOffsetAsStateHyPO7BM(long j, AnimationSpec<IntOffset> animationSpec, String str, Function1<? super IntOffset, Unit> function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(-696782904);
        ComposerKt.sourceInformation(composer, "C(animateIntOffsetAsState)P(3:c#ui.unit.IntOffset!1,2)314@14224L172:AnimateAsState.kt#pdpnli");
        AnimationSpec<IntOffset> animationSpec2 = (i2 & 2) != 0 ? intOffsetDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "IntOffsetAnimation" : str;
        Function1<? super IntOffset, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-696782904, i3, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:313)");
        }
        int i4 = i3 << 6;
        State<IntOffset> animateValueAsState = animateValueAsState(IntOffset.m6739boximpl(j), VectorConvertersKt.getVectorConverter(IntOffset.Companion), animationSpec2, (IntOffset) null, str2, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateIntSizeAsState-4goxYXU  reason: not valid java name */
    public static final State<IntSize> m123animateIntSizeAsState4goxYXU(long j, AnimationSpec<IntSize> animationSpec, String str, Function1<? super IntSize, Unit> function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(582576328);
        ComposerKt.sourceInformation(composer, "C(animateIntSizeAsState)P(3:c#ui.unit.IntSize!1,2)352@16009L170:AnimateAsState.kt#pdpnli");
        AnimationSpec<IntSize> animationSpec2 = (i2 & 2) != 0 ? intSizeDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "IntSizeAnimation" : str;
        Function1<? super IntSize, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(582576328, i3, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:351)");
        }
        int i4 = i3 << 6;
        State<IntSize> animateValueAsState = animateValueAsState(IntSize.m6782boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.Companion), animationSpec2, (IntSize) null, str2, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final <T, V extends AnimationVector> State<T> animateValueAsState(T t, TwoWayConverter<T, V> twoWayConverter, AnimationSpec<T> animationSpec, T t2, String str, Function1<? super T, Unit> function1, Composer composer, int i, int i2) {
        AnimationSpec<T> animationSpec2;
        T t3 = t;
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(-1994373980);
        ComposerKt.sourceInformation(composer2, "C(animateValueAsState)P(3,4!1,5,2)393@18031L21,399@18213L44,400@18279L79,401@18379L38,402@18456L339,413@18814L42,414@18861L55,417@18921L721:AnimateAsState.kt#pdpnli");
        if ((i2 & 4) != 0) {
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) rememberedValue;
        } else {
            animationSpec2 = animationSpec;
        }
        T t4 = (i2 & 8) != 0 ? null : t2;
        String str2 = (i2 & 16) != 0 ? "ValueAnimation" : str;
        Function1<? super T, Unit> function12 = (i2 & 32) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994373980, i3, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:397)");
        }
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue2;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            TwoWayConverter<T, V> twoWayConverter2 = twoWayConverter;
            rememberedValue3 = new Animatable(t, twoWayConverter, t4, str2);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue3;
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function12, composer2, (i3 >> 15) & 14);
        if (t4 != null && (animationSpec2 instanceof SpringSpec)) {
            SpringSpec springSpec = (SpringSpec) animationSpec2;
            if (!Intrinsics.areEqual(springSpec.getVisibilityThreshold(), (Object) t4)) {
                animationSpec2 = AnimationSpecKt.spring(springSpec.getDampingRatio(), springSpec.getStiffness(), t4);
            }
        }
        State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(animationSpec2, composer2, 0);
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            composer2.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        Channel channel = (Channel) rememberedValue4;
        EffectsKt.SideEffect(new AnimateAsStateKt$animateValueAsState$2(channel, t), composer2, 0);
        EffectsKt.LaunchedEffect((Object) channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnimateAsStateKt$animateValueAsState$3(channel, animatable, rememberUpdatedState2, rememberUpdatedState, (Continuation<? super AnimateAsStateKt$animateValueAsState$3>) null), composer2, 72);
        State<T> state = (State) mutableState.getValue();
        if (state == null) {
            state = animatable.asState();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloatAsState(float f, AnimationSpec animationSpec, float f2, Function1 function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1091643291);
        ComposerKt.sourceInformation(composer, "C(animateFloatAsState)P(2!1,3)446@20047L143:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = defaultAnimation;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            f2 = 0.01f;
        }
        float f3 = f2;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1091643291, i, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:446)");
        }
        State<Float> animateFloatAsState = animateFloatAsState(f, animationSpec2, f3, (String) null, function12, composer, (i & 1022) | ((i << 3) & 57344), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateFloatAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateDpAsState-Kz89ssw  reason: not valid java name */
    public static final /* synthetic */ State m120animateDpAsStateKz89ssw(float f, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(704104481);
        ComposerKt.sourceInformation(composer, "C(animateDpAsState)P(2:c#ui.unit.Dp)463@20491L142:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(704104481, i, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:462)");
        }
        State<Dp> animateValueAsState = animateValueAsState(Dp.m6612boximpl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), animationSpec2, (Dp) null, (String) null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateSizeAsState-LjSzlW0  reason: not valid java name */
    public static final /* synthetic */ State m127animateSizeAsStateLjSzlW0(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(875212471);
        ComposerKt.sourceInformation(composer, "C(animateSizeAsState)P(2:c#ui.geometry.Size)481@20948L144:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i2 & 2) != 0 ? sizeDefaultSpring : animationSpec;
        Function1 function12 = (i2 & 4) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(875212471, i, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:480)");
        }
        State<Size> animateValueAsState = animateValueAsState(Size.m3619boximpl(j), VectorConvertersKt.getVectorConverter(Size.Companion), animationSpec2, (Size) null, (String) null, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | ((i3 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateOffsetAsState-N6fFfp4  reason: not valid java name */
    public static final /* synthetic */ State m126animateOffsetAsStateN6fFfp4(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(-456513133);
        ComposerKt.sourceInformation(composer, "C(animateOffsetAsState)P(2:c#ui.geometry.Offset)499@21419L122:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i2 & 2) != 0 ? offsetDefaultSpring : animationSpec;
        Function1 function12 = (i2 & 4) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-456513133, i, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:498)");
        }
        State<Offset> animateValueAsState = animateValueAsState(Offset.m3551boximpl(j), VectorConvertersKt.getVectorConverter(Offset.Companion), animationSpec2, (Offset) null, (String) null, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | ((i3 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateRectAsState(Rect rect, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-782613967);
        ComposerKt.sourceInformation(composer, "C(animateRectAsState)P(2)514@21856L120:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = rectDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-782613967, i, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:513)");
        }
        State<Rect> animateValueAsState = animateValueAsState(rect, VectorConvertersKt.getVectorConverter(Rect.Companion), animationSpec2, (Rect) null, (String) null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateIntAsState(int i, AnimationSpec animationSpec, Function1 function1, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-842612981);
        ComposerKt.sourceInformation(composer, "C(animateIntAsState)P(2)529@22285L119:AnimateAsState.kt#pdpnli");
        if ((i3 & 2) != 0) {
            animationSpec = intDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-842612981, i2, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:528)");
        }
        State<Integer> animateValueAsState = animateValueAsState(Integer.valueOf(i), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, (Integer) null, (String) null, function12, composer, (i2 & 14) | ((i2 << 3) & 896) | ((i2 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateIntOffsetAsState-8f6pmRE  reason: not valid java name */
    public static final /* synthetic */ State m121animateIntOffsetAsState8f6pmRE(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(1010307371);
        ComposerKt.sourceInformation(composer, "C(animateIntOffsetAsState)P(2:c#ui.unit.IntOffset)544@22749L125:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i2 & 2) != 0 ? intOffsetDefaultSpring : animationSpec;
        Function1 function12 = (i2 & 4) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1010307371, i, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:543)");
        }
        State<IntOffset> animateValueAsState = animateValueAsState(IntOffset.m6739boximpl(j), VectorConvertersKt.getVectorConverter(IntOffset.Companion), animationSpec2, (IntOffset) null, (String) null, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | ((i3 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateIntSizeAsState-zTRF_AQ  reason: not valid java name */
    public static final /* synthetic */ State m124animateIntSizeAsStatezTRF_AQ(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(-1749239765);
        ComposerKt.sourceInformation(composer, "C(animateIntSizeAsState)P(2:c#ui.unit.IntSize)559@23207L123:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i2 & 2) != 0 ? intSizeDefaultSpring : animationSpec;
        Function1 function12 = (i2 & 4) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1749239765, i, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:558)");
        }
        State<IntSize> animateValueAsState = animateValueAsState(IntSize.m6782boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.Companion), animationSpec2, (IntSize) null, (String) null, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | ((i3 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValueAsState(Object obj, TwoWayConverter twoWayConverter, AnimationSpec animationSpec, Object obj2, Function1 function1, Composer composer, int i, int i2) {
        AnimationSpec animationSpec2;
        Composer composer2 = composer;
        int i3 = i;
        composer.startReplaceableGroup(-846382129);
        ComposerKt.sourceInformation(composer, "C(animateValueAsState)P(2,3!1,4)572@23613L21,575@23730L240:AnimateAsState.kt#pdpnli");
        if ((i2 & 4) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) rememberedValue;
        } else {
            animationSpec2 = animationSpec;
        }
        Object obj3 = (i2 & 8) != 0 ? null : obj2;
        Function1 function12 = (i2 & 16) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-846382129, i3, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:575)");
        }
        int i4 = i3 & 8;
        State animateValueAsState = animateValueAsState(obj, twoWayConverter, animationSpec2, obj3, "ValueAnimation", function12, composer, (i4 << 9) | i4 | CpioConstants.C_ISBLK | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* access modifiers changed from: private */
    public static final <T> Function1<T, Unit> animateValueAsState$lambda$4(State<? extends Function1<? super T, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    public static final <T> AnimationSpec<T> animateValueAsState$lambda$6(State<? extends AnimationSpec<T>> state) {
        return (AnimationSpec) state.getValue();
    }
}
