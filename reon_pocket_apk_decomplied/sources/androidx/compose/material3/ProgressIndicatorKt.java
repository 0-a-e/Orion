package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u001aR\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a0\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a8\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001aL\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00108\u001aH\u00109\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a0\u00109\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a:\u00109\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a8\u00109\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aB\u00109\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010B\u001a6\u0010C\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a&\u0010K\u001a\u00020&*\u00020D2\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001a6\u0010N\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010J\u001a>\u0010P\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a>\u0010S\u001a\u00020&*\u00020D2\u0006\u0010T\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a.\u0010X\u001a\u00020&*\u00020D2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0016\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u0016\u0010\u0018\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010$\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006["}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "IncreaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "SemanticsBoundsPadding", "StartAngleOffset", "CircularProgressIndicator", "", "progress", "Lkotlin/Function0;", "modifier", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final float CircularIndicatorDiameter = Dp.m6614constructorimpl(CircularProgressIndicatorTokens.INSTANCE.m2681getSizeD9Ej5fM() - Dp.m6614constructorimpl(CircularProgressIndicatorTokens.INSTANCE.m2680getActiveIndicatorWidthD9Ej5fM() * ((float) 2)));
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final Modifier IncreaseSemanticsBounds;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m2947getTrackHeightD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m6614constructorimpl((float) 240);
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    /* access modifiers changed from: private */
    public static final float SemanticsBoundsPadding;
    private static final float StartAngleOffset = -90.0f;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* renamed from: LinearProgressIndicator-_5eSR-E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2068LinearProgressIndicator_5eSRE(kotlin.jvm.functions.Function0<java.lang.Float> r20, androidx.compose.ui.Modifier r21, long r22, long r24, int r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r1 = r20
            r8 = r28
            r0 = -1796992155(0xffffffff94e41365, float:-2.3029766E-26)
            r2 = r27
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)81@3829L11,82@3892L16,85@4010L31,89@4162L102,93@4334L196,86@4046L484:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r29 & 1
            r4 = 4
            if (r3 == 0) goto L_0x001a
            r3 = r8 | 6
            goto L_0x002a
        L_0x001a:
            r3 = r8 & 6
            if (r3 != 0) goto L_0x0029
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0026
            r3 = r4
            goto L_0x0027
        L_0x0026:
            r3 = 2
        L_0x0027:
            r3 = r3 | r8
            goto L_0x002a
        L_0x0029:
            r3 = r8
        L_0x002a:
            r5 = r29 & 2
            if (r5 == 0) goto L_0x0031
            r3 = r3 | 48
            goto L_0x0044
        L_0x0031:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0044
            r6 = r21
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0040
            r7 = 32
            goto L_0x0042
        L_0x0040:
            r7 = 16
        L_0x0042:
            r3 = r3 | r7
            goto L_0x0046
        L_0x0044:
            r6 = r21
        L_0x0046:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005d
            r7 = r29 & 4
            r10 = r22
            if (r7 != 0) goto L_0x0059
            boolean r7 = r2.changed((long) r10)
            if (r7 == 0) goto L_0x0059
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r3 = r3 | r7
            goto L_0x005f
        L_0x005d:
            r10 = r22
        L_0x005f:
            r7 = r8 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0076
            r7 = r29 & 8
            r13 = r24
            if (r7 != 0) goto L_0x0072
            boolean r7 = r2.changed((long) r13)
            if (r7 == 0) goto L_0x0072
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0074
        L_0x0072:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0074:
            r3 = r3 | r7
            goto L_0x0078
        L_0x0076:
            r13 = r24
        L_0x0078:
            r7 = r29 & 16
            if (r7 == 0) goto L_0x007f
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0093
        L_0x007f:
            r9 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0093
            r9 = r26
            boolean r16 = r2.changed((int) r9)
            if (r16 == 0) goto L_0x008e
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0090
        L_0x008e:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0090:
            r3 = r3 | r16
            goto L_0x0095
        L_0x0093:
            r9 = r26
        L_0x0095:
            r15 = r3 & 9363(0x2493, float:1.312E-41)
            r12 = 9362(0x2492, float:1.3119E-41)
            if (r15 != r12) goto L_0x00a9
            boolean r12 = r2.getSkipping()
            if (r12 != 0) goto L_0x00a2
            goto L_0x00a9
        L_0x00a2:
            r2.skipToGroupEnd()
            r7 = r9
            r3 = r10
            goto L_0x01f7
        L_0x00a9:
            r2.startDefaults()
            r12 = r8 & 1
            if (r12 == 0) goto L_0x00ca
            boolean r12 = r2.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00b7
            goto L_0x00ca
        L_0x00b7:
            r2.skipToGroupEnd()
            r5 = r29 & 4
            if (r5 == 0) goto L_0x00c0
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c0:
            r5 = r29 & 8
            if (r5 == 0) goto L_0x00c6
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00c6:
            r5 = r9
            r12 = r13
        L_0x00c8:
            r14 = r10
            goto L_0x00f7
        L_0x00ca:
            if (r5 == 0) goto L_0x00d1
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = r5
        L_0x00d1:
            r5 = r29 & 4
            r12 = 6
            if (r5 == 0) goto L_0x00de
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r10 = r5.getLinearColor(r2, r12)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00de:
            r5 = r29 & 8
            if (r5 == 0) goto L_0x00eb
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r12 = r5.getLinearTrackColor(r2, r12)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x00ec
        L_0x00eb:
            r12 = r13
        L_0x00ec:
            if (r7 == 0) goto L_0x00f5
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r5 = r5.m2059getLinearStrokeCapKaPHkGw()
            goto L_0x00c8
        L_0x00f5:
            r5 = r9
            goto L_0x00c8
        L_0x00f7:
            r2.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0106
            r7 = -1
            java.lang.String r9 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:84)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r7, r9)
        L_0x0106:
            r0 = -1348540816(0xffffffffaf9ee670, float:-2.8903768E-10)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r7 = r3 & 14
            r9 = 1
            if (r7 != r4) goto L_0x0118
            r4 = r9
            goto L_0x0119
        L_0x0118:
            r4 = 0
        L_0x0119:
            java.lang.Object r7 = r2.rememberedValue()
            if (r4 != 0) goto L_0x0127
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r7 != r4) goto L_0x0132
        L_0x0127:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1 r4 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1
            r4.<init>(r1)
            r7 = r4
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r2.updateRememberedValue(r7)
        L_0x0132:
            r4 = r7
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier r7 = IncreaseSemanticsBounds
            androidx.compose.ui.Modifier r7 = r6.then(r7)
            r11 = -1348540664(0xffffffffaf9ee708, float:-2.890419E-10)
            r2.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            boolean r11 = r2.changed((java.lang.Object) r4)
            java.lang.Object r10 = r2.rememberedValue()
            if (r11 != 0) goto L_0x0159
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r10 != r11) goto L_0x0163
        L_0x0159:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1 r10 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
            r10.<init>(r4)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r2.updateRememberedValue(r10)
        L_0x0163:
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r7, r9, r10)
            float r10 = LinearIndicatorWidth
            float r11 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m744sizeVpY3zN4(r7, r10, r11)
            r10 = -1348540492(0xffffffffaf9ee7b4, float:-2.8904668E-10)
            r2.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 ^ 3072(0xc00, float:4.305E-42)
            r10 = 2048(0x800, float:2.87E-42)
            if (r0 <= r10) goto L_0x018b
            boolean r0 = r2.changed((long) r12)
            if (r0 != 0) goto L_0x018f
        L_0x018b:
            r0 = r3 & 3072(0xc00, float:4.305E-42)
            if (r0 != r10) goto L_0x0191
        L_0x018f:
            r0 = r9
            goto L_0x0192
        L_0x0191:
            r0 = 0
        L_0x0192:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r3
            r11 = 16384(0x4000, float:2.2959E-41)
            if (r10 != r11) goto L_0x019c
            r10 = r9
            goto L_0x019d
        L_0x019c:
            r10 = 0
        L_0x019d:
            r0 = r0 | r10
            boolean r10 = r2.changed((java.lang.Object) r4)
            r0 = r0 | r10
            r10 = r3 & 896(0x380, float:1.256E-42)
            r10 = r10 ^ 384(0x180, float:5.38E-43)
            r11 = 256(0x100, float:3.59E-43)
            if (r10 <= r11) goto L_0x01b1
            boolean r10 = r2.changed((long) r14)
            if (r10 != 0) goto L_0x01b7
        L_0x01b1:
            r3 = r3 & 384(0x180, float:5.38E-43)
            if (r3 != r11) goto L_0x01b6
            goto L_0x01b7
        L_0x01b6:
            r9 = 0
        L_0x01b7:
            r0 = r0 | r9
            java.lang.Object r3 = r2.rememberedValue()
            if (r0 != 0) goto L_0x01ce
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x01c7
            goto L_0x01ce
        L_0x01c7:
            r0 = r3
            r16 = r12
            r18 = r14
            r3 = 0
            goto L_0x01e1
        L_0x01ce:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1
            r9 = r0
            r3 = 0
            r10 = r12
            r16 = r12
            r12 = r5
            r13 = r4
            r18 = r14
            r9.<init>(r10, r12, r13, r14)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2.updateRememberedValue(r0)
        L_0x01e1:
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2.endReplaceableGroup()
            androidx.compose.foundation.CanvasKt.Canvas(r7, r0, r2, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01f2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f2:
            r7 = r5
            r13 = r16
            r3 = r18
        L_0x01f7:
            androidx.compose.runtime.ScopeUpdateScope r10 = r2.endRestartGroup()
            if (r10 == 0) goto L_0x0210
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3 r11 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3
            r0 = r11
            r1 = r20
            r2 = r6
            r5 = r13
            r8 = r28
            r9 = r29
            r0.<init>(r1, r2, r3, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0210:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2068LinearProgressIndicator_5eSRE(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0208, code lost:
        if (r1.changed(r10) == false) goto L_0x020d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x021e  */
    /* renamed from: LinearProgressIndicator-2cYBFYY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2065LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier r30, long r31, long r33, int r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r7 = r37
            r0 = -476865359(0xffffffffe3939cb1, float:-5.4459244E21)
            r1 = r36
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)118@5518L11,119@5581L16,122@5702L28,126@5984L320,137@6348L320,148@6713L324,159@7082L324,175@7581L660,170@7411L830:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r38 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r7 | 6
            r4 = r3
            r3 = r30
            goto L_0x002e
        L_0x001a:
            r3 = r7 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r30
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r7
            goto L_0x002e
        L_0x002b:
            r3 = r30
            r4 = r7
        L_0x002e:
            r5 = r7 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r38 & 2
            r8 = r31
            if (r5 != 0) goto L_0x0041
            boolean r5 = r1.changed((long) r8)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r4 = r4 | r5
            goto L_0x0047
        L_0x0045:
            r8 = r31
        L_0x0047:
            r5 = r7 & 384(0x180, float:5.38E-43)
            r15 = 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x005f
            r5 = r38 & 4
            r10 = r33
            if (r5 != 0) goto L_0x005b
            boolean r5 = r1.changed((long) r10)
            if (r5 == 0) goto L_0x005b
            r5 = r15
            goto L_0x005d
        L_0x005b:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r4 = r4 | r5
            goto L_0x0061
        L_0x005f:
            r10 = r33
        L_0x0061:
            r5 = r38 & 8
            if (r5 == 0) goto L_0x0068
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r12 = r7 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007b
            r12 = r35
            boolean r13 = r1.changed((int) r12)
            if (r13 == 0) goto L_0x0077
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r4 = r4 | r13
            goto L_0x007d
        L_0x007b:
            r12 = r35
        L_0x007d:
            r13 = r4 & 1171(0x493, float:1.641E-42)
            r14 = 1170(0x492, float:1.64E-42)
            if (r13 != r14) goto L_0x0092
            boolean r13 = r1.getSkipping()
            if (r13 != 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            r1.skipToGroupEnd()
            r2 = r3
            r4 = r10
            r6 = r12
            goto L_0x028d
        L_0x0092:
            r1.startDefaults()
            r13 = r7 & 1
            if (r13 == 0) goto L_0x00b5
            boolean r13 = r1.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00a0
            goto L_0x00b5
        L_0x00a0:
            r1.skipToGroupEnd()
            r2 = r38 & 2
            if (r2 == 0) goto L_0x00a9
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00a9:
            r2 = r38 & 4
            if (r2 == 0) goto L_0x00af
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00af:
            r2 = r3
        L_0x00b0:
            r13 = r10
            r5 = r12
            r12 = r4
            r3 = r8
            goto L_0x00e3
        L_0x00b5:
            if (r2 == 0) goto L_0x00bc
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00bd
        L_0x00bc:
            r2 = r3
        L_0x00bd:
            r3 = r38 & 2
            r13 = 6
            if (r3 == 0) goto L_0x00ca
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r8 = r3.getLinearColor(r1, r13)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ca:
            r3 = r38 & 4
            if (r3 == 0) goto L_0x00d7
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r10 = r3.getLinearTrackColor(r1, r13)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x00d7:
            if (r5 == 0) goto L_0x00b0
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r3 = r3.m2059getLinearStrokeCapKaPHkGw()
            r5 = r3
            r12 = r4
            r3 = r8
            r13 = r10
        L_0x00e3:
            r1.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00f2
            r8 = -1
            java.lang.String r9 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:121)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r8, r9)
        L_0x00f2:
            r0 = 0
            r11 = 0
            r10 = 1
            androidx.compose.animation.core.InfiniteTransition r0 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r0, r1, r11, r10)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1 r8 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.animation.core.KeyframesSpec r8 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r8)
            androidx.compose.animation.core.DurationBasedAnimationSpec r8 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r8
            r9 = 6
            r16 = 0
            r17 = 0
            r18 = 0
            r30 = r8
            r31 = r17
            r32 = r18
            r34 = r9
            r35 = r16
            androidx.compose.animation.core.InfiniteRepeatableSpec r16 = androidx.compose.animation.core.AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(r30, r31, r32, r34, r35)
            int r8 = androidx.compose.animation.core.InfiniteTransition.$stable
            r8 = r8 | 432(0x1b0, float:6.05E-43)
            int r9 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r9 = r9 << 9
            r17 = r8 | r9
            r18 = 8
            r9 = 0
            r19 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            r8 = r0
            r21 = r10
            r10 = r19
            r11 = r16
            r6 = r12
            r12 = r20
            r26 = r13
            r13 = r1
            r14 = r17
            r7 = r15
            r15 = r18
            androidx.compose.runtime.State r15 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r8, r9, r10, r11, r12, r13, r14, r15)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1 r8 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.animation.core.KeyframesSpec r8 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r8)
            androidx.compose.animation.core.DurationBasedAnimationSpec r8 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r8
            r9 = 6
            r10 = 0
            r11 = 0
            r12 = 0
            r30 = r8
            r31 = r11
            r32 = r12
            r34 = r9
            r35 = r10
            androidx.compose.animation.core.InfiniteRepeatableSpec r11 = androidx.compose.animation.core.AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(r30, r31, r32, r34, r35)
            int r8 = androidx.compose.animation.core.InfiniteTransition.$stable
            r8 = r8 | 432(0x1b0, float:6.05E-43)
            int r9 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r9 = r9 << 9
            r14 = r8 | r9
            r17 = 8
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r8 = r0
            r13 = r1
            r28 = r15
            r15 = r17
            androidx.compose.runtime.State r15 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r8, r9, r10, r11, r12, r13, r14, r15)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1 r8 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.animation.core.KeyframesSpec r8 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r8)
            androidx.compose.animation.core.DurationBasedAnimationSpec r8 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r8
            r9 = 6
            r10 = 0
            r11 = 0
            r12 = 0
            r30 = r8
            r31 = r11
            r32 = r12
            r34 = r9
            r35 = r10
            androidx.compose.animation.core.InfiniteRepeatableSpec r11 = androidx.compose.animation.core.AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(r30, r31, r32, r34, r35)
            int r8 = androidx.compose.animation.core.InfiniteTransition.$stable
            r8 = r8 | 432(0x1b0, float:6.05E-43)
            int r9 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r9 = r9 << 9
            r14 = r8 | r9
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r8 = r0
            r13 = r1
            r29 = r15
            r15 = r17
            androidx.compose.runtime.State r15 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r8, r9, r10, r11, r12, r13, r14, r15)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1 r8 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.animation.core.KeyframesSpec r8 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r8)
            androidx.compose.animation.core.DurationBasedAnimationSpec r8 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r8
            r9 = 6
            r10 = 0
            r11 = 0
            r12 = 0
            r30 = r8
            r31 = r11
            r32 = r12
            r34 = r9
            r35 = r10
            androidx.compose.animation.core.InfiniteRepeatableSpec r11 = androidx.compose.animation.core.AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(r30, r31, r32, r34, r35)
            int r8 = androidx.compose.animation.core.InfiniteTransition.$stable
            r8 = r8 | 432(0x1b0, float:6.05E-43)
            int r9 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r9 = r9 << 9
            r14 = r8 | r9
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r8 = r0
            r13 = r1
            r0 = r15
            r15 = r17
            androidx.compose.runtime.State r8 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r8, r9, r10, r11, r12, r13, r14, r15)
            androidx.compose.ui.Modifier r9 = IncreaseSemanticsBounds
            androidx.compose.ui.Modifier r9 = r2.then(r9)
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r9)
            float r10 = LinearIndicatorWidth
            float r11 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m744sizeVpY3zN4(r9, r10, r11)
            r10 = -1348537245(0xffffffffaf9ef463, float:-2.891368E-10)
            r1.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            r10 = r6 & 896(0x380, float:1.256E-42)
            r10 = r10 ^ 384(0x180, float:5.38E-43)
            if (r10 <= r7) goto L_0x020b
            r10 = r26
            boolean r12 = r1.changed((long) r10)
            if (r12 != 0) goto L_0x0211
            goto L_0x020d
        L_0x020b:
            r10 = r26
        L_0x020d:
            r12 = r6 & 384(0x180, float:5.38E-43)
            if (r12 != r7) goto L_0x0214
        L_0x0211:
            r7 = r21
            goto L_0x0215
        L_0x0214:
            r7 = 0
        L_0x0215:
            r12 = r6 & 7168(0x1c00, float:1.0045E-41)
            r13 = 2048(0x800, float:2.87E-42)
            if (r12 != r13) goto L_0x021e
            r12 = r21
            goto L_0x021f
        L_0x021e:
            r12 = 0
        L_0x021f:
            r7 = r7 | r12
            r12 = r28
            boolean r13 = r1.changed((java.lang.Object) r12)
            r7 = r7 | r13
            r13 = r29
            boolean r14 = r1.changed((java.lang.Object) r13)
            r7 = r7 | r14
            r14 = r6 & 112(0x70, float:1.57E-43)
            r14 = r14 ^ 48
            r15 = 32
            if (r14 <= r15) goto L_0x023c
            boolean r14 = r1.changed((long) r3)
            if (r14 != 0) goto L_0x0243
        L_0x023c:
            r6 = r6 & 48
            if (r6 != r15) goto L_0x0241
            goto L_0x0243
        L_0x0241:
            r21 = 0
        L_0x0243:
            r6 = r7 | r21
            boolean r7 = r1.changed((java.lang.Object) r0)
            r6 = r6 | r7
            boolean r7 = r1.changed((java.lang.Object) r8)
            r6 = r6 | r7
            java.lang.Object r7 = r1.rememberedValue()
            if (r6 != 0) goto L_0x025d
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x0278
        L_0x025d:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1 r6 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
            r16 = r6
            r17 = r10
            r19 = r5
            r20 = r12
            r21 = r13
            r22 = r3
            r24 = r0
            r25 = r8
            r16.<init>(r17, r19, r20, r21, r22, r24, r25)
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r1.updateRememberedValue(r7)
        L_0x0278:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r1.endReplaceableGroup()
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r9, r7, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x028a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x028a:
            r8 = r3
            r6 = r5
            r4 = r10
        L_0x028d:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x02a4
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$5 r11 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$5
            r0 = r11
            r1 = r2
            r2 = r8
            r7 = r37
            r8 = r38
            r0.<init>(r1, r2, r4, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x02a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2065LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: LinearProgressIndicator-_5eSR-E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2067LinearProgressIndicator_5eSRE(float r23, androidx.compose.ui.Modifier r24, long r25, long r27, int r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r23
            r8 = r31
            r0 = 905419617(0x35f79b61, float:1.8448155E-6)
            r2 = r30
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)213@8723L11,214@8786L16,217@8918L12,216@8878L155:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r32 & 1
            r4 = 4
            if (r3 == 0) goto L_0x001a
            r3 = r8 | 6
            goto L_0x002a
        L_0x001a:
            r3 = r8 & 6
            if (r3 != 0) goto L_0x0029
            boolean r3 = r2.changed((float) r1)
            if (r3 == 0) goto L_0x0026
            r3 = r4
            goto L_0x0027
        L_0x0026:
            r3 = 2
        L_0x0027:
            r3 = r3 | r8
            goto L_0x002a
        L_0x0029:
            r3 = r8
        L_0x002a:
            r5 = r32 & 2
            if (r5 == 0) goto L_0x0031
            r3 = r3 | 48
            goto L_0x0044
        L_0x0031:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0044
            r6 = r24
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0040
            r7 = 32
            goto L_0x0042
        L_0x0040:
            r7 = 16
        L_0x0042:
            r3 = r3 | r7
            goto L_0x0046
        L_0x0044:
            r6 = r24
        L_0x0046:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005d
            r7 = r32 & 4
            r9 = r25
            if (r7 != 0) goto L_0x0059
            boolean r7 = r2.changed((long) r9)
            if (r7 == 0) goto L_0x0059
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r3 = r3 | r7
            goto L_0x005f
        L_0x005d:
            r9 = r25
        L_0x005f:
            r7 = r8 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0076
            r7 = r32 & 8
            r11 = r27
            if (r7 != 0) goto L_0x0072
            boolean r7 = r2.changed((long) r11)
            if (r7 == 0) goto L_0x0072
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0074
        L_0x0072:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0074:
            r3 = r3 | r7
            goto L_0x0078
        L_0x0076:
            r11 = r27
        L_0x0078:
            r7 = r32 & 16
            if (r7 == 0) goto L_0x007f
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0092
        L_0x007f:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0092
            r13 = r29
            boolean r14 = r2.changed((int) r13)
            if (r14 == 0) goto L_0x008e
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0090
        L_0x008e:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0090:
            r3 = r3 | r14
            goto L_0x0094
        L_0x0092:
            r13 = r29
        L_0x0094:
            r14 = r3 & 9363(0x2493, float:1.312E-41)
            r15 = 9362(0x2492, float:1.3119E-41)
            if (r14 != r15) goto L_0x00a8
            boolean r14 = r2.getSkipping()
            if (r14 != 0) goto L_0x00a1
            goto L_0x00a8
        L_0x00a1:
            r2.skipToGroupEnd()
            r3 = r9
            r7 = r13
            goto L_0x0157
        L_0x00a8:
            r2.startDefaults()
            r14 = r8 & 1
            if (r14 == 0) goto L_0x00cb
            boolean r14 = r2.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00b6
            goto L_0x00cb
        L_0x00b6:
            r2.skipToGroupEnd()
            r5 = r32 & 4
            if (r5 == 0) goto L_0x00bf
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00bf:
            r5 = r32 & 8
            if (r5 == 0) goto L_0x00c5
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00c5:
            r19 = r9
            r21 = r11
            r5 = r13
            goto L_0x00f7
        L_0x00cb:
            if (r5 == 0) goto L_0x00d2
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = r5
        L_0x00d2:
            r5 = r32 & 4
            r14 = 6
            if (r5 == 0) goto L_0x00df
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r9 = r5.getLinearColor(r2, r14)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00df:
            r5 = r32 & 8
            if (r5 == 0) goto L_0x00eb
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r11 = r5.getLinearTrackColor(r2, r14)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00eb:
            if (r7 == 0) goto L_0x00c5
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r5 = r5.m2059getLinearStrokeCapKaPHkGw()
            r19 = r9
            r21 = r11
        L_0x00f7:
            r2.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0106
            r7 = -1
            java.lang.String r9 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:216)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r7, r9)
        L_0x0106:
            r0 = -1348535908(0xffffffffaf9ef99c, float:-2.891739E-10)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r3 & 14
            if (r0 != r4) goto L_0x0117
            r0 = 1
            goto L_0x0118
        L_0x0117:
            r0 = 0
        L_0x0118:
            java.lang.Object r4 = r2.rememberedValue()
            if (r0 != 0) goto L_0x0126
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x0131
        L_0x0126:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
            r0.<init>(r1)
            r4 = r0
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.updateRememberedValue(r4)
        L_0x0131:
            r9 = r4
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r2.endReplaceableGroup()
            r0 = 65520(0xfff0, float:9.1813E-41)
            r17 = r3 & r0
            r18 = 0
            r10 = r6
            r11 = r19
            r13 = r21
            r15 = r5
            r16 = r2
            m2068LinearProgressIndicator_5eSRE((kotlin.jvm.functions.Function0<java.lang.Float>) r9, (androidx.compose.ui.Modifier) r10, (long) r11, (long) r13, (int) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0152
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0152:
            r7 = r5
            r3 = r19
            r11 = r21
        L_0x0157:
            androidx.compose.runtime.ScopeUpdateScope r10 = r2.endRestartGroup()
            if (r10 == 0) goto L_0x0170
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$7 r13 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$7
            r0 = r13
            r1 = r23
            r2 = r6
            r5 = r11
            r8 = r31
            r9 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r10.updateScope(r13)
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2067LinearProgressIndicator_5eSRE(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2069LinearProgressIndicatoreaDK9VM(float r20, androidx.compose.ui.Modifier r21, long r22, long r24, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r7 = r27
            r0 = -372717133(0xffffffffe9c8c9b3, float:-3.0342208E25)
            r1 = r26
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)230@9286L11,231@9349L16,232@9371L140:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r28 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r7 | 6
            r3 = r2
            r2 = r20
            goto L_0x002e
        L_0x001a:
            r2 = r7 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r20
            boolean r3 = r1.changed((float) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r7
            goto L_0x002e
        L_0x002b:
            r2 = r20
            r3 = r7
        L_0x002e:
            r4 = r28 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r7 & 48
            if (r5 != 0) goto L_0x0048
            r5 = r21
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
            r5 = r21
        L_0x004a:
            r6 = r7 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r28 & 4
            r8 = r22
            if (r6 != 0) goto L_0x005d
            boolean r6 = r1.changed((long) r8)
            if (r6 == 0) goto L_0x005d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r6
            goto L_0x0063
        L_0x0061:
            r8 = r22
        L_0x0063:
            r6 = r7 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007a
            r6 = r28 & 8
            r10 = r24
            if (r6 != 0) goto L_0x0076
            boolean r6 = r1.changed((long) r10)
            if (r6 == 0) goto L_0x0076
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r6
            goto L_0x007c
        L_0x007a:
            r10 = r24
        L_0x007c:
            r6 = r3 & 1171(0x493, float:1.641E-42)
            r12 = 1170(0x492, float:1.64E-42)
            if (r6 != r12) goto L_0x0090
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x0089
            goto L_0x0090
        L_0x0089:
            r1.skipToGroupEnd()
            r4 = r5
            r5 = r10
            goto L_0x0112
        L_0x0090:
            r1.startDefaults()
            r6 = r7 & 1
            if (r6 == 0) goto L_0x00af
            boolean r6 = r1.getDefaultsInvalid()
            if (r6 == 0) goto L_0x009e
            goto L_0x00af
        L_0x009e:
            r1.skipToGroupEnd()
            r4 = r28 & 4
            if (r4 == 0) goto L_0x00a7
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a7:
            r4 = r28 & 8
            if (r4 == 0) goto L_0x00ad
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00ad:
            r4 = r5
            goto L_0x00d4
        L_0x00af:
            if (r4 == 0) goto L_0x00b6
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00b7
        L_0x00b6:
            r4 = r5
        L_0x00b7:
            r5 = r28 & 4
            r6 = 6
            if (r5 == 0) goto L_0x00c4
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r8 = r5.getLinearColor(r1, r6)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c4:
            r5 = r28 & 8
            if (r5 == 0) goto L_0x00d4
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r5 = r5.getLinearTrackColor(r1, r6)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r18 = r5
            r5 = r8
            goto L_0x00d7
        L_0x00d4:
            r5 = r8
            r18 = r10
        L_0x00d7:
            r1.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00e6
            r8 = -1
            java.lang.String r9 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:232)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r8, r9)
        L_0x00e6:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r14 = r0.m2059getLinearStrokeCapKaPHkGw()
            r0 = r3 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r8 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r8
            r8 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r8
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r16 = r0 | r3
            r17 = 0
            r8 = r20
            r9 = r4
            r10 = r5
            r12 = r18
            r15 = r1
            m2067LinearProgressIndicator_5eSRE((float) r8, (androidx.compose.ui.Modifier) r9, (long) r10, (long) r12, (int) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x010f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010f:
            r8 = r5
            r5 = r18
        L_0x0112:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x012b
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$8 r11 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$8
            r0 = r11
            r1 = r20
            r2 = r4
            r3 = r8
            r7 = r27
            r8 = r28
            r0.<init>(r1, r2, r3, r5, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x012b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2069LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk  reason: not valid java name */
    public static final /* synthetic */ void m2066LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        long j5;
        Modifier modifier3;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)244@9718L11,245@9781L16,246@9803L126:ProgressIndicator.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i4 | 6;
            modifier2 = modifier;
        } else if ((i4 & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i4;
        } else {
            modifier2 = modifier;
            i3 = i4;
        }
        if ((i4 & 48) == 0) {
            j3 = j;
            i3 |= ((i2 & 2) != 0 || !startRestartGroup.changed(j3)) ? 16 : 32;
        } else {
            j3 = j;
        }
        if ((i4 & 384) == 0) {
            j4 = j2;
            i3 |= ((i2 & 4) != 0 || !startRestartGroup.changed(j4)) ? 128 : 256;
        } else {
            j4 = j2;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i4 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                modifier3 = i5 != 0 ? Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                    i3 &= -897;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                modifier3 = modifier2;
            }
            int i6 = i3;
            j5 = j3;
            long j6 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i6, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:246)");
            }
            m2065LinearProgressIndicator2cYBFYY(modifier3, j5, j6, ProgressIndicatorDefaults.INSTANCE.m2059getLinearStrokeCapKaPHkGw(), startRestartGroup, (i6 & 14) | 3072 | (i6 & 112) | (i6 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j6;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j5 = j3;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$9(modifier3, j5, j4, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g  reason: not valid java name */
    public static final void m2079drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float r0 = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc());
        float r1 = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc());
        float f4 = (float) 2;
        float f5 = r1 / f4;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f6 = (z ? f : 1.0f - f2) * r0;
        float f7 = (z ? f2 : 1.0f - f) * r0;
        if (StrokeCap.m4226equalsimpl0(i, StrokeCap.Companion.m4230getButtKaPHkGw()) || r1 > r0) {
            DrawScope.CC.m4462drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(f6, f5), OffsetKt.Offset(f7, f5), f3, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
            return;
        }
        float f8 = f3 / f4;
        ClosedFloatingPointRange rangeTo = RangesKt.rangeTo(f8, r0 - f8);
        float floatValue = ((Number) RangesKt.coerceIn(Float.valueOf(f6), rangeTo)).floatValue();
        float floatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(f7), rangeTo)).floatValue();
        if (Math.abs(f2 - f) > 0.0f) {
            DrawScope.CC.m4462drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(floatValue, f5), OffsetKt.Offset(floatValue2, f5), f3, i, (PathEffect) null, 0.0f, (ColorFilter) null, 0, MainPresenterKt.EIGHT_HOURS_IN_MINUTES, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorTrack-AZGd3zU  reason: not valid java name */
    public static final void m2080drawLinearIndicatorTrackAZGd3zU(DrawScope drawScope, long j, float f, int i) {
        m2079drawLinearIndicatorqYKTg0g(drawScope, 0.0f, 1.0f, j, f, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c9  */
    /* renamed from: CircularProgressIndicator-DUhRLBM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2061CircularProgressIndicatorDUhRLBM(kotlin.jvm.functions.Function0<java.lang.Float> r26, androidx.compose.ui.Modifier r27, long r28, float r30, long r31, int r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r1 = r26
            r9 = r35
            r0 = -761680467(0xffffffffd299adad, float:-3.30021896E11)
            r2 = r34
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)348@14143L13,350@14277L18,353@14410L31,*354@14477L7,359@14631L102,363@14785L243,357@14558L470:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r36 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r9 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r9 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r9
            goto L_0x0029
        L_0x0028:
            r3 = r9
        L_0x0029:
            r5 = r36 & 2
            if (r5 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r6 = r9 & 48
            if (r6 != 0) goto L_0x0043
            r6 = r27
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r6 = r27
        L_0x0045:
            r7 = r9 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005c
            r7 = r36 & 4
            r10 = r28
            if (r7 != 0) goto L_0x0058
            boolean r7 = r2.changed((long) r10)
            if (r7 == 0) goto L_0x0058
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r3 = r3 | r7
            goto L_0x005e
        L_0x005c:
            r10 = r28
        L_0x005e:
            r7 = r36 & 8
            if (r7 == 0) goto L_0x0065
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0078
        L_0x0065:
            r12 = r9 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x0078
            r12 = r30
            boolean r13 = r2.changed((float) r12)
            if (r13 == 0) goto L_0x0074
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r3 = r3 | r13
            goto L_0x007a
        L_0x0078:
            r12 = r30
        L_0x007a:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0091
            r13 = r36 & 16
            r14 = r31
            if (r13 != 0) goto L_0x008d
            boolean r13 = r2.changed((long) r14)
            if (r13 == 0) goto L_0x008d
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008f
        L_0x008d:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x008f:
            r3 = r3 | r13
            goto L_0x0093
        L_0x0091:
            r14 = r31
        L_0x0093:
            r13 = r36 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x009e
            r3 = r3 | r16
            r8 = r33
            goto L_0x00b1
        L_0x009e:
            r16 = r9 & r16
            r8 = r33
            if (r16 != 0) goto L_0x00b1
            boolean r17 = r2.changed((int) r8)
            if (r17 == 0) goto L_0x00ad
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r17
        L_0x00b1:
            r17 = 74899(0x12493, float:1.04956E-40)
            r4 = r3 & r17
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r0) goto L_0x00c9
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00c2
            goto L_0x00c9
        L_0x00c2:
            r2.skipToGroupEnd()
        L_0x00c5:
            r3 = r10
            r5 = r12
            goto L_0x023b
        L_0x00c9:
            r2.startDefaults()
            r0 = r9 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x00e9
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00da
            goto L_0x00e9
        L_0x00da:
            r2.skipToGroupEnd()
            r0 = r36 & 4
            if (r0 == 0) goto L_0x00e3
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00e3:
            r0 = r36 & 16
            if (r0 == 0) goto L_0x011c
            r3 = r3 & r4
            goto L_0x011c
        L_0x00e9:
            if (r5 == 0) goto L_0x00f0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x00f0:
            r0 = r36 & 4
            r5 = 6
            if (r0 == 0) goto L_0x00fd
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r10 = r0.getCircularColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00fd:
            if (r7 == 0) goto L_0x0106
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r0 = r0.m2058getCircularStrokeWidthD9Ej5fM()
            r12 = r0
        L_0x0106:
            r0 = r36 & 16
            if (r0 == 0) goto L_0x0113
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r14 = r0.getCircularTrackColor(r2, r5)
            r0 = r3 & r4
            r3 = r0
        L_0x0113:
            if (r13 == 0) goto L_0x011c
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r0 = r0.m2056getCircularDeterminateStrokeCapKaPHkGw()
            r8 = r0
        L_0x011c:
            r2.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x012e
            r0 = -1
            java.lang.String r4 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:352)"
            r5 = -761680467(0xffffffffd299adad, float:-3.30021896E11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r0, r4)
        L_0x012e:
            r0 = 821866314(0x30fcaf4a, float:1.8385233E-9)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r4 = r3 & 14
            r13 = 4
            if (r4 != r13) goto L_0x0140
            r4 = 1
            goto L_0x0141
        L_0x0140:
            r4 = 0
        L_0x0141:
            java.lang.Object r13 = r2.rememberedValue()
            if (r4 != 0) goto L_0x014f
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r13 != r4) goto L_0x015a
        L_0x014f:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1 r4 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
            r4.<init>(r1)
            r13 = r4
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r2.updateRememberedValue(r13)
        L_0x015a:
            r4 = r13
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r5 = r2.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.ui.graphics.drawscope.Stroke r7 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r19 = r5.m6550toPx0680j_4(r12)
            r24 = 26
            r25 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r18 = r7
            r21 = r8
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r5 = 821866535(0x30fcb027, float:1.8385479E-9)
            r2.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            boolean r5 = r2.changed((java.lang.Object) r4)
            java.lang.Object r13 = r2.rememberedValue()
            if (r5 != 0) goto L_0x01a9
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r13 != r5) goto L_0x01b4
        L_0x01a9:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1 r5 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
            r5.<init>(r4)
            r13 = r5
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r2.updateRememberedValue(r13)
        L_0x01b4:
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r2.endReplaceableGroup()
            r5 = 1
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r6, r5, r13)
            float r5 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m742size3ABfNKs(r13, r5)
            r13 = 821866689(0x30fcb0c1, float:1.838565E-9)
            r2.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            boolean r0 = r2.changed((java.lang.Object) r4)
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r3
            r13 = r13 ^ 24576(0x6000, float:3.4438E-41)
            r1 = 16384(0x4000, float:2.2959E-41)
            if (r13 <= r1) goto L_0x01e1
            boolean r13 = r2.changed((long) r14)
            if (r13 != 0) goto L_0x01e5
        L_0x01e1:
            r13 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r13 != r1) goto L_0x01e7
        L_0x01e5:
            r1 = 1
            goto L_0x01e8
        L_0x01e7:
            r1 = 0
        L_0x01e8:
            r0 = r0 | r1
            boolean r1 = r2.changedInstance(r7)
            r0 = r0 | r1
            r1 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 ^ 384(0x180, float:5.38E-43)
            r13 = 256(0x100, float:3.59E-43)
            if (r1 <= r13) goto L_0x01fc
            boolean r1 = r2.changed((long) r10)
            if (r1 != 0) goto L_0x0200
        L_0x01fc:
            r1 = r3 & 384(0x180, float:5.38E-43)
            if (r1 != r13) goto L_0x0202
        L_0x0200:
            r1 = 1
            goto L_0x0203
        L_0x0202:
            r1 = 0
        L_0x0203:
            r0 = r0 | r1
            java.lang.Object r1 = r2.rememberedValue()
            if (r0 != 0) goto L_0x0212
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0227
        L_0x0212:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
            r27 = r0
            r28 = r4
            r29 = r14
            r31 = r7
            r32 = r10
            r27.<init>(r28, r29, r31, r32)
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2.updateRememberedValue(r1)
        L_0x0227:
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2.endReplaceableGroup()
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r5, r1, r2, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00c5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x00c5
        L_0x023b:
            androidx.compose.runtime.ScopeUpdateScope r11 = r2.endRestartGroup()
            if (r11 == 0) goto L_0x0254
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3 r12 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3
            r0 = r12
            r1 = r26
            r2 = r6
            r6 = r14
            r9 = r35
            r10 = r36
            r0.<init>(r1, r2, r3, r5, r6, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0254:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2061CircularProgressIndicatorDUhRLBM(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02aa  */
    /* renamed from: CircularProgressIndicator-LxG7B9w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2062CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier r35, long r36, float r38, long r39, int r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r8 = r43
            r0 = -115871647(0xfffffffff917f061, float:-4.930702E34)
            r1 = r42
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,4:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)391@16088L13,393@16222L18,*396@16366L7,400@16465L28,402@16622L278,414@17014L230,425@17361L346,436@17740L355,451@18209L628,447@18100L737:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r44 & 1
            r3 = 2
            if (r2 == 0) goto L_0x001b
            r4 = r8 | 6
            r5 = r4
            r4 = r35
            goto L_0x002f
        L_0x001b:
            r4 = r8 & 6
            if (r4 != 0) goto L_0x002c
            r4 = r35
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0029
            r5 = 4
            goto L_0x002a
        L_0x0029:
            r5 = r3
        L_0x002a:
            r5 = r5 | r8
            goto L_0x002f
        L_0x002c:
            r4 = r35
            r5 = r8
        L_0x002f:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0046
            r6 = r44 & 2
            r9 = r36
            if (r6 != 0) goto L_0x0042
            boolean r6 = r1.changed((long) r9)
            if (r6 == 0) goto L_0x0042
            r6 = 32
            goto L_0x0044
        L_0x0042:
            r6 = 16
        L_0x0044:
            r5 = r5 | r6
            goto L_0x0048
        L_0x0046:
            r9 = r36
        L_0x0048:
            r6 = r44 & 4
            if (r6 == 0) goto L_0x004f
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r11 = r8 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0062
            r11 = r38
            boolean r12 = r1.changed((float) r11)
            if (r12 == 0) goto L_0x005e
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r5 = r5 | r12
            goto L_0x0064
        L_0x0062:
            r11 = r38
        L_0x0064:
            r12 = r8 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r44 & 8
            if (r12 != 0) goto L_0x0077
            r12 = r39
            boolean r16 = r1.changed((long) r12)
            if (r16 == 0) goto L_0x0079
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r12 = r39
        L_0x0079:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r5 = r5 | r16
            goto L_0x0080
        L_0x007e:
            r12 = r39
        L_0x0080:
            r16 = r44 & 16
            if (r16 == 0) goto L_0x0087
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0087:
            r14 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x009b
            r14 = r41
            boolean r17 = r1.changed((int) r14)
            if (r17 == 0) goto L_0x0096
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r5 = r5 | r17
            goto L_0x009d
        L_0x009b:
            r14 = r41
        L_0x009d:
            r15 = r5 & 9363(0x2493, float:1.312E-41)
            r7 = 9362(0x2492, float:1.3119E-41)
            if (r15 != r7) goto L_0x00b2
            boolean r7 = r1.getSkipping()
            if (r7 != 0) goto L_0x00aa
            goto L_0x00b2
        L_0x00aa:
            r1.skipToGroupEnd()
            r2 = r9
            r6 = r11
            r7 = r14
            goto L_0x033e
        L_0x00b2:
            r1.startDefaults()
            r7 = r8 & 1
            if (r7 == 0) goto L_0x00d6
            boolean r7 = r1.getDefaultsInvalid()
            if (r7 == 0) goto L_0x00c0
            goto L_0x00d6
        L_0x00c0:
            r1.skipToGroupEnd()
            r2 = r44 & 2
            if (r2 == 0) goto L_0x00c9
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00c9:
            r2 = r44 & 8
            if (r2 == 0) goto L_0x00cf
            r5 = r5 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00cf:
            r2 = r4
            r6 = r11
            r7 = r14
            r14 = r12
            r13 = r5
        L_0x00d4:
            r4 = r9
            goto L_0x0118
        L_0x00d6:
            if (r2 == 0) goto L_0x00dd
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00de
        L_0x00dd:
            r2 = r4
        L_0x00de:
            r4 = r44 & 2
            r7 = 6
            if (r4 == 0) goto L_0x00eb
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r9 = r4.getCircularColor(r1, r7)
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00eb:
            if (r6 == 0) goto L_0x00f4
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r4 = r4.m2058getCircularStrokeWidthD9Ej5fM()
            r11 = r4
        L_0x00f4:
            r4 = r44 & 8
            if (r4 == 0) goto L_0x0102
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r6 = r4.getCircularTrackColor(r1, r7)
            r4 = r5 & -7169(0xffffffffffffe3ff, float:NaN)
            r5 = r4
            goto L_0x0103
        L_0x0102:
            r6 = r12
        L_0x0103:
            if (r16 == 0) goto L_0x0110
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r4 = r4.m2057getCircularIndeterminateStrokeCapKaPHkGw()
            r13 = r5
            r14 = r6
            r6 = r11
            r7 = r4
            goto L_0x00d4
        L_0x0110:
            r13 = r5
            r4 = r9
            r33 = r6
            r6 = r11
            r7 = r14
            r14 = r33
        L_0x0118:
            r1.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0127
            r9 = -1
            java.lang.String r10 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:395)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r9, r10)
        L_0x0127:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r9, r10)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.ui.graphics.drawscope.Stroke r12 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r19 = r0.m6550toPx0680j_4(r6)
            r24 = 26
            r25 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r18 = r12
            r21 = r7
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r0 = 0
            r11 = 0
            r10 = 1
            androidx.compose.animation.core.InfiniteTransition r18 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r0, r1, r11, r10)
            java.lang.Integer r16 = java.lang.Integer.valueOf(r11)
            r9 = 5
            java.lang.Integer r19 = java.lang.Integer.valueOf(r9)
            kotlin.jvm.internal.IntCompanionObject r9 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r20 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.IntCompanionObject) r9)
            r9 = 6660(0x1a04, float:9.333E-42)
            androidx.compose.animation.core.Easing r10 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r9 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r9, r11, r10, r3, r0)
            androidx.compose.animation.core.DurationBasedAnimationSpec r9 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r9
            r10 = 6
            r21 = 0
            r22 = 0
            r23 = 0
            r36 = r9
            r37 = r22
            r38 = r23
            r40 = r10
            r41 = r21
            androidx.compose.animation.core.InfiniteRepeatableSpec r21 = androidx.compose.animation.core.AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(r36, r37, r38, r40, r41)
            int r9 = androidx.compose.animation.core.InfiniteTransition.$stable
            r9 = r9 | 432(0x1b0, float:6.05E-43)
            int r10 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r10 = r10 << 12
            r22 = r9 | r10
            r23 = 16
            r24 = 0
            r9 = r18
            r25 = 1
            r10 = r16
            r11 = r19
            r29 = r12
            r12 = r20
            r30 = r13
            r13 = r21
            r31 = r14
            r15 = 2048(0x800, float:2.87E-42)
            r14 = r24
            r15 = r1
            r16 = r22
            r17 = r23
            androidx.compose.runtime.State r9 = androidx.compose.animation.core.InfiniteTransitionKt.animateValue(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r10 = 1332(0x534, float:1.867E-42)
            androidx.compose.animation.core.Easing r11 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r12 = 0
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r10, r12, r11, r3, r0)
            androidx.compose.animation.core.DurationBasedAnimationSpec r0 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r0
            r3 = 6
            r10 = 0
            r11 = 0
            r13 = 0
            r35 = r0
            r36 = r11
            r37 = r13
            r39 = r3
            r40 = r10
            androidx.compose.animation.core.InfiniteRepeatableSpec r0 = androidx.compose.animation.core.AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(r35, r36, r37, r39, r40)
            int r3 = androidx.compose.animation.core.InfiniteTransition.$stable
            r3 = r3 | 432(0x1b0, float:6.05E-43)
            int r10 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r10 = r10 << 9
            r3 = r3 | r10
            r10 = 8
            r11 = 0
            r13 = 1133445120(0x438f0000, float:286.0)
            r14 = 0
            r35 = r18
            r36 = r11
            r37 = r13
            r38 = r0
            r39 = r14
            r40 = r1
            r41 = r3
            r42 = r10
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r35, r36, r37, r38, r39, r40, r41, r42)
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1 r3 = androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.animation.core.KeyframesSpec r3 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r3)
            androidx.compose.animation.core.DurationBasedAnimationSpec r3 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r3
            r10 = 6
            r11 = 0
            r13 = 0
            r14 = 0
            r35 = r3
            r36 = r13
            r37 = r14
            r39 = r10
            r40 = r11
            androidx.compose.animation.core.InfiniteRepeatableSpec r3 = androidx.compose.animation.core.AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(r35, r36, r37, r39, r40)
            int r10 = androidx.compose.animation.core.InfiniteTransition.$stable
            r10 = r10 | 432(0x1b0, float:6.05E-43)
            int r11 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r11 = r11 << 9
            r10 = r10 | r11
            r11 = 8
            r13 = 0
            r14 = 1133576192(0x43910000, float:290.0)
            r15 = 0
            r35 = r18
            r36 = r13
            r37 = r14
            r38 = r3
            r39 = r15
            r40 = r1
            r41 = r10
            r42 = r11
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r35, r36, r37, r38, r39, r40, r41, r42)
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1 r10 = androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            androidx.compose.animation.core.KeyframesSpec r10 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r10)
            androidx.compose.animation.core.DurationBasedAnimationSpec r10 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r10
            r11 = 6
            r13 = 0
            r14 = 0
            r15 = 0
            r35 = r10
            r36 = r14
            r37 = r15
            r39 = r11
            r40 = r13
            androidx.compose.animation.core.InfiniteRepeatableSpec r10 = androidx.compose.animation.core.AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(r35, r36, r37, r39, r40)
            int r11 = androidx.compose.animation.core.InfiniteTransition.$stable
            r11 = r11 | 432(0x1b0, float:6.05E-43)
            int r13 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r13 = r13 << 9
            r11 = r11 | r13
            r13 = 8
            r14 = 0
            r15 = 1133576192(0x43910000, float:290.0)
            r16 = 0
            r35 = r18
            r36 = r14
            r37 = r15
            r38 = r10
            r39 = r16
            r40 = r1
            r41 = r11
            r42 = r13
            androidx.compose.runtime.State r10 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r35, r36, r37, r38, r39, r40, r41, r42)
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r2)
            float r13 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.m742size3ABfNKs(r11, r13)
            r13 = 821870113(0x30fcbe21, float:1.8389451E-9)
            r1.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            r13 = r30
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 ^ 3072(0xc00, float:4.305E-42)
            r15 = 2048(0x800, float:2.87E-42)
            r12 = r31
            if (r14 <= r15) goto L_0x02aa
            boolean r14 = r1.changed((long) r12)
            if (r14 != 0) goto L_0x02a5
            goto L_0x02aa
        L_0x02a5:
            r35 = r2
            r14 = r30
            goto L_0x02b2
        L_0x02aa:
            r35 = r2
            r14 = r30
            r2 = r14 & 3072(0xc00, float:4.305E-42)
            if (r2 != r15) goto L_0x02b7
        L_0x02b2:
            r2 = r25
            r15 = r29
            goto L_0x02ba
        L_0x02b7:
            r15 = r29
            r2 = 0
        L_0x02ba:
            boolean r16 = r1.changedInstance(r15)
            r2 = r2 | r16
            boolean r16 = r1.changed((java.lang.Object) r9)
            r2 = r2 | r16
            boolean r16 = r1.changed((java.lang.Object) r3)
            r2 = r2 | r16
            boolean r16 = r1.changed((java.lang.Object) r10)
            r2 = r2 | r16
            boolean r16 = r1.changed((java.lang.Object) r0)
            r2 = r2 | r16
            r36 = r7
            r7 = r14 & 896(0x380, float:1.256E-42)
            r8 = 256(0x100, float:3.59E-43)
            if (r7 != r8) goto L_0x02e3
            r7 = r25
            goto L_0x02e4
        L_0x02e3:
            r7 = 0
        L_0x02e4:
            r2 = r2 | r7
            r7 = r14 & 112(0x70, float:1.57E-43)
            r7 = r7 ^ 48
            r8 = 32
            if (r7 <= r8) goto L_0x02f3
            boolean r7 = r1.changed((long) r4)
            if (r7 != 0) goto L_0x02fa
        L_0x02f3:
            r7 = r14 & 48
            if (r7 != r8) goto L_0x02f8
            goto L_0x02fa
        L_0x02f8:
            r25 = 0
        L_0x02fa:
            r2 = r2 | r25
            java.lang.Object r7 = r1.rememberedValue()
            if (r2 != 0) goto L_0x030a
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r7 != r2) goto L_0x0327
        L_0x030a:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1 r2 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
            r18 = r2
            r19 = r12
            r21 = r15
            r22 = r9
            r23 = r3
            r24 = r10
            r25 = r0
            r26 = r6
            r27 = r4
            r18.<init>(r19, r21, r22, r23, r24, r25, r26, r27)
            r7 = r2
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r1.updateRememberedValue(r7)
        L_0x0327:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r1.endReplaceableGroup()
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r11, r7, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0339
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0339:
            r7 = r36
            r2 = r4
            r4 = r35
        L_0x033e:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x0356
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5 r11 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5
            r0 = r11
            r1 = r4
            r4 = r6
            r5 = r12
            r8 = r43
            r9 = r44
            r0.<init>(r1, r2, r4, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0356:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2062CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0149  */
    @kotlin.Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @kotlin.ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: CircularProgressIndicator-DUhRLBM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2060CircularProgressIndicatorDUhRLBM(float r21, androidx.compose.ui.Modifier r22, long r23, float r25, long r26, int r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r1 = r21
            r9 = r30
            r0 = -1472321743(0xffffffffa83e2731, float:-1.0555617E-14)
            r2 = r29
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)487@19401L13,489@19535L18,492@19684L12,491@19642L188:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r31 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r9 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r9 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((float) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r9
            goto L_0x0029
        L_0x0028:
            r3 = r9
        L_0x0029:
            r5 = r31 & 2
            if (r5 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r6 = r9 & 48
            if (r6 != 0) goto L_0x0043
            r6 = r22
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r6 = r22
        L_0x0045:
            r7 = r9 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005e
            r7 = r31 & 4
            if (r7 != 0) goto L_0x0058
            r7 = r23
            boolean r10 = r2.changed((long) r7)
            if (r10 == 0) goto L_0x005a
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r7 = r23
        L_0x005a:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r10
            goto L_0x0060
        L_0x005e:
            r7 = r23
        L_0x0060:
            r10 = r31 & 8
            if (r10 == 0) goto L_0x0067
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r11 = r9 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007a
            r11 = r25
            boolean r12 = r2.changed((float) r11)
            if (r12 == 0) goto L_0x0076
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r12
            goto L_0x007c
        L_0x007a:
            r11 = r25
        L_0x007c:
            r12 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r31 & 16
            if (r12 != 0) goto L_0x008f
            r12 = r26
            boolean r14 = r2.changed((long) r12)
            if (r14 == 0) goto L_0x0091
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x008f:
            r12 = r26
        L_0x0091:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r14
            goto L_0x0097
        L_0x0095:
            r12 = r26
        L_0x0097:
            r14 = r31 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x009f
            r3 = r3 | r15
            goto L_0x00b2
        L_0x009f:
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00b2
            r15 = r28
            boolean r16 = r2.changed((int) r15)
            if (r16 == 0) goto L_0x00ad
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r16
            goto L_0x00b4
        L_0x00b2:
            r15 = r28
        L_0x00b4:
            r16 = 74899(0x12493, float:1.04956E-40)
            r4 = r3 & r16
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r0) goto L_0x00cd
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00c5
            goto L_0x00cd
        L_0x00c5:
            r2.skipToGroupEnd()
            r3 = r7
            r5 = r11
            r8 = r15
            goto L_0x018b
        L_0x00cd:
            r2.startDefaults()
            r0 = r9 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x00f1
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00de
            goto L_0x00f1
        L_0x00de:
            r2.skipToGroupEnd()
            r0 = r31 & 4
            if (r0 == 0) goto L_0x00e7
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00e7:
            r0 = r31 & 16
            if (r0 == 0) goto L_0x00ec
            r3 = r3 & r4
        L_0x00ec:
            r10 = r3
            r0 = r11
            r3 = r12
            r5 = r15
            goto L_0x0127
        L_0x00f1:
            if (r5 == 0) goto L_0x00f8
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x00f8:
            r0 = r31 & 4
            r5 = 6
            if (r0 == 0) goto L_0x0105
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r7 = r0.getCircularColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0105:
            if (r10 == 0) goto L_0x010e
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r0 = r0.m2058getCircularStrokeWidthD9Ej5fM()
            r11 = r0
        L_0x010e:
            r0 = r31 & 16
            if (r0 == 0) goto L_0x011b
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r12 = r0.getCircularTrackColor(r2, r5)
            r0 = r3 & r4
            r3 = r0
        L_0x011b:
            if (r14 == 0) goto L_0x00ec
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r0 = r0.m2056getCircularDeterminateStrokeCapKaPHkGw()
            r5 = r0
            r10 = r3
            r0 = r11
            r3 = r12
        L_0x0127:
            r2.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0139
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:491)"
            r13 = -1472321743(0xffffffffa83e2731, float:-1.0555617E-14)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r10, r11, r12)
        L_0x0139:
            r11 = 821871588(0x30fcc3e4, float:1.8391089E-9)
            r2.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            r11 = r10 & 14
            r12 = 4
            if (r11 != r12) goto L_0x014b
            r11 = 1
            goto L_0x014c
        L_0x014b:
            r11 = 0
        L_0x014c:
            java.lang.Object r12 = r2.rememberedValue()
            if (r11 != 0) goto L_0x015a
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x0165
        L_0x015a:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1 r11 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
            r11.<init>(r1)
            r12 = r11
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r2.updateRememberedValue(r12)
        L_0x0165:
            r11 = r12
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r2.endReplaceableGroup()
            r12 = 524272(0x7fff0, float:7.34662E-40)
            r19 = r10 & r12
            r20 = 0
            r10 = r11
            r11 = r6
            r12 = r7
            r14 = r0
            r15 = r3
            r17 = r5
            r18 = r2
            m2061CircularProgressIndicatorDUhRLBM((kotlin.jvm.functions.Function0<java.lang.Float>) r10, (androidx.compose.ui.Modifier) r11, (long) r12, (float) r14, (long) r15, (int) r17, (androidx.compose.runtime.Composer) r18, (int) r19, (int) r20)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0187
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0187:
            r12 = r3
            r3 = r7
            r8 = r5
            r5 = r0
        L_0x018b:
            androidx.compose.runtime.ScopeUpdateScope r11 = r2.endRestartGroup()
            if (r11 == 0) goto L_0x01a4
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$7 r14 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$7
            r0 = r14
            r1 = r21
            r2 = r6
            r6 = r12
            r9 = r30
            r10 = r31
            r0.<init>(r1, r2, r3, r5, r6, r8, r9, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r11.updateScope(r14)
        L_0x01a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2060CircularProgressIndicatorDUhRLBM(float, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2063CircularProgressIndicatorMBs18nI(float r20, androidx.compose.ui.Modifier r21, long r22, float r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r6 = r26
            r0 = 402841196(0x1802de6c, float:1.69144E-24)
            r1 = r25
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)506@20085L13,513@20298L18,508@20172L219:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r27 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r6 | 6
            r3 = r2
            r2 = r20
            goto L_0x002e
        L_0x001a:
            r2 = r6 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r20
            boolean r3 = r1.changed((float) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r6
            goto L_0x002e
        L_0x002b:
            r2 = r20
            r3 = r6
        L_0x002e:
            r4 = r27 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r6 & 48
            if (r5 != 0) goto L_0x0048
            r5 = r21
            boolean r7 = r1.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x0044
            r7 = 32
            goto L_0x0046
        L_0x0044:
            r7 = 16
        L_0x0046:
            r3 = r3 | r7
            goto L_0x004a
        L_0x0048:
            r5 = r21
        L_0x004a:
            r7 = r6 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0063
            r7 = r27 & 4
            if (r7 != 0) goto L_0x005d
            r7 = r22
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005d:
            r7 = r22
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r9
            goto L_0x0065
        L_0x0063:
            r7 = r22
        L_0x0065:
            r9 = r27 & 8
            if (r9 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r10 = r6 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007f
            r10 = r24
            boolean r11 = r1.changed((float) r10)
            if (r11 == 0) goto L_0x007b
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r3 = r3 | r11
            goto L_0x0081
        L_0x007f:
            r10 = r24
        L_0x0081:
            r11 = r3 & 1171(0x493, float:1.641E-42)
            r12 = 1170(0x492, float:1.64E-42)
            if (r11 != r12) goto L_0x0097
            boolean r11 = r1.getSkipping()
            if (r11 != 0) goto L_0x008e
            goto L_0x0097
        L_0x008e:
            r1.skipToGroupEnd()
            r4 = r5
            r18 = r7
            r5 = r10
            goto L_0x0111
        L_0x0097:
            r1.startDefaults()
            r11 = r6 & 1
            r12 = 6
            if (r11 == 0) goto L_0x00b4
            boolean r11 = r1.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00a6
            goto L_0x00b4
        L_0x00a6:
            r1.skipToGroupEnd()
            r4 = r27 & 4
            if (r4 == 0) goto L_0x00af
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00af:
            r4 = r5
        L_0x00b0:
            r18 = r7
            r5 = r10
            goto L_0x00d2
        L_0x00b4:
            if (r4 == 0) goto L_0x00bb
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00bc
        L_0x00bb:
            r4 = r5
        L_0x00bc:
            r5 = r27 & 4
            if (r5 == 0) goto L_0x00c8
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r7 = r5.getCircularColor(r1, r12)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c8:
            if (r9 == 0) goto L_0x00b0
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r5 = r5.m2058getCircularStrokeWidthD9Ej5fM()
            r18 = r7
        L_0x00d2:
            r1.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00e1
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:508)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r7, r8)
        L_0x00e1:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r12 = r0.getCircularTrackColor(r1, r12)
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r14 = r0.m2056getCircularDeterminateStrokeCapKaPHkGw()
            r0 = r3 & 14
            r7 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r7
            r7 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r7
            r7 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r7
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r16 = r0 | r3
            r17 = 0
            r7 = r20
            r8 = r4
            r9 = r18
            r11 = r5
            r15 = r1
            m2060CircularProgressIndicatorDUhRLBM((float) r7, (androidx.compose.ui.Modifier) r8, (long) r9, (float) r11, (long) r12, (int) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0111
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0111:
            androidx.compose.runtime.ScopeUpdateScope r8 = r1.endRestartGroup()
            if (r8 == 0) goto L_0x012b
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$8 r9 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$8
            r0 = r9
            r1 = r20
            r2 = r4
            r3 = r18
            r6 = r26
            r7 = r27
            r0.<init>(r1, r2, r3, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x012b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2063CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2064CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier r19, long r20, float r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r5 = r24
            r0 = 947193756(0x3875079c, float:5.841964E-5)
            r1 = r23
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)521@20600L13,527@20799L18,523@20687L207:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r25 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r5 | 6
            r4 = r3
            r3 = r19
            goto L_0x002e
        L_0x001a:
            r3 = r5 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r19
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r5
            goto L_0x002e
        L_0x002b:
            r3 = r19
            r4 = r5
        L_0x002e:
            r6 = r5 & 48
            if (r6 != 0) goto L_0x0047
            r6 = r25 & 2
            if (r6 != 0) goto L_0x0041
            r6 = r20
            boolean r8 = r1.changed((long) r6)
            if (r8 == 0) goto L_0x0043
            r8 = 32
            goto L_0x0045
        L_0x0041:
            r6 = r20
        L_0x0043:
            r8 = 16
        L_0x0045:
            r4 = r4 | r8
            goto L_0x0049
        L_0x0047:
            r6 = r20
        L_0x0049:
            r8 = r25 & 4
            if (r8 == 0) goto L_0x0050
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r9 = r5 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0063
            r9 = r22
            boolean r10 = r1.changed((float) r9)
            if (r10 == 0) goto L_0x005f
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r4 = r4 | r10
            goto L_0x0065
        L_0x0063:
            r9 = r22
        L_0x0065:
            r10 = r4 & 147(0x93, float:2.06E-43)
            r11 = 146(0x92, float:2.05E-43)
            if (r10 != r11) goto L_0x0079
            boolean r10 = r1.getSkipping()
            if (r10 != 0) goto L_0x0072
            goto L_0x0079
        L_0x0072:
            r1.skipToGroupEnd()
            r2 = r3
            r3 = r6
            goto L_0x00f3
        L_0x0079:
            r1.startDefaults()
            r10 = r5 & 1
            r11 = 6
            if (r10 == 0) goto L_0x009a
            boolean r10 = r1.getDefaultsInvalid()
            if (r10 == 0) goto L_0x0088
            goto L_0x009a
        L_0x0088:
            r1.skipToGroupEnd()
            r2 = r25 & 2
            if (r2 == 0) goto L_0x0091
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0091:
            r2 = r3
        L_0x0092:
            r16 = r9
        L_0x0094:
            r17 = r6
            r6 = r4
            r3 = r17
            goto L_0x00b9
        L_0x009a:
            if (r2 == 0) goto L_0x00a1
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00a2
        L_0x00a1:
            r2 = r3
        L_0x00a2:
            r3 = r25 & 2
            if (r3 == 0) goto L_0x00ae
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r6 = r3.getCircularColor(r1, r11)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ae:
            if (r8 == 0) goto L_0x0092
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r3 = r3.m2058getCircularStrokeWidthD9Ej5fM()
            r16 = r3
            goto L_0x0094
        L_0x00b9:
            r1.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00c8
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:523)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r7, r8)
        L_0x00c8:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r10 = r0.getCircularTrackColor(r1, r11)
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r12 = r0.m2057getCircularIndeterminateStrokeCapKaPHkGw()
            r0 = r6 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r7 = r6 & 112(0x70, float:1.57E-43)
            r0 = r0 | r7
            r6 = r6 & 896(0x380, float:1.256E-42)
            r14 = r0 | r6
            r15 = 0
            r6 = r2
            r7 = r3
            r9 = r16
            r13 = r1
            m2062CircularProgressIndicatorLxG7B9w(r6, r7, r9, r10, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00f1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f1:
            r9 = r16
        L_0x00f3:
            androidx.compose.runtime.ScopeUpdateScope r7 = r1.endRestartGroup()
            if (r7 == 0) goto L_0x010b
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$9 r8 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$9
            r0 = r8
            r1 = r2
            r2 = r3
            r4 = r9
            r5 = r24
            r6 = r25
            r0.<init>(r1, r2, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2064CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: drawCircularIndicator-42QJj7c  reason: not valid java name */
    private static final void m2075drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = (float) 2;
        float width = stroke.getWidth() / f3;
        float r2 = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc()) - (f3 * width);
        DrawScope.CC.m4455drawArcyD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), SizeKt.Size(r2, r2), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorTrack-bw27NRU  reason: not valid java name */
    public static final void m2076drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m2075drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m2077drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m2075drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI  reason: not valid java name */
    public static final void m2078drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        float f4;
        if (StrokeCap.m4226equalsimpl0(stroke.m4555getCapKaPHkGw(), StrokeCap.Companion.m4230getButtKaPHkGw())) {
            f4 = 0.0f;
        } else {
            f4 = ((f2 / Dp.m6614constructorimpl(CircularIndicatorDiameter / ((float) 2))) * 57.29578f) / 2.0f;
        }
        m2075drawCircularIndicator42QJj7c(drawScope, f + f4, Math.max(f3, 0.1f), j, stroke);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    static {
        float r0 = Dp.m6614constructorimpl((float) 10);
        SemanticsBoundsPadding = r0;
        IncreaseSemanticsBounds = PaddingKt.m672paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.Companion, ProgressIndicatorKt$IncreaseSemanticsBounds$1.INSTANCE), true, ProgressIndicatorKt$IncreaseSemanticsBounds$2.INSTANCE), 0.0f, r0, 1, (Object) null);
    }
}
