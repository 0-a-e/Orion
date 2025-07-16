package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u001a(\u0010\u0018\u001a\u00020\u00192\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a]\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010*\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a*\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u0002002\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001aH\u0007\u001a,\u00102\u001a\u00020!2\b\b\u0002\u00103\u001a\u00020\u00042\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aF\u00106\u001a\u00020\u0019*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a>\u0010A\u001a\u00020\u0019*\u0002072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00162\u0006\u0010B\u001a\u00020;2\u0006\u0010>\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0013\u0010\u0011\"\u0010\u0010\u0014\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E²\u0006\n\u0010F\u001a\u00020\u0002X\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "DragMultiplier", "Elevation", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerContainerSize", "getSpinnerContainerSize", "()F", "SpinnerSize", "getSpinnerSize", "StrokeWidth", "ArrowValues", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "progress", "CircularArrowProgressIndicator", "", "Lkotlin/Function0;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "PullToRefreshContainer", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "PullToRefreshContainer-wBJOh4Y", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "PullToRefreshState", "positionalThresholdPx", "initialRefreshing", "", "enabled", "rememberPullToRefreshState", "positionalThreshold", "rememberPullToRefreshState--orJrPs", "(FLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "strokeWidth", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawCircularIndicator", "arcBounds", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "material3_release", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
public final class PullToRefreshKt {
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, EasingKt.getLinearEasing(), 2, (Object) null);
    /* access modifiers changed from: private */
    public static final float ArcRadius = Dp.m6614constructorimpl((float) 5.5d);
    private static final float ArrowHeight = Dp.m6614constructorimpl((float) 5);
    private static final float ArrowWidth = Dp.m6614constructorimpl((float) 10);
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    /* access modifiers changed from: private */
    public static final float Elevation = ElevationTokens.INSTANCE.m2819getLevel2D9Ej5fM();
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float SpinnerContainerSize = Dp.m6614constructorimpl((float) 40);
    private static final float SpinnerSize = Dp.m6614constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final float StrokeWidth = Dp.m6614constructorimpl((float) 2.5d);

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00eb, code lost:
        if ((r27 & 32) != 0) goto L_0x00ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0149  */
    /* renamed from: PullToRefreshContainer-wBJOh4Y  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2634PullToRefreshContainerwBJOh4Y(androidx.compose.material3.pulltorefresh.PullToRefreshState r17, androidx.compose.ui.Modifier r18, kotlin.jvm.functions.Function3<? super androidx.compose.material3.pulltorefresh.PullToRefreshState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.ui.graphics.Shape r20, long r21, long r23, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r1 = r17
            r9 = r26
            r0 = -801976958(0xffffffffd032cd82, float:-1.19992504E10)
            r2 = r25
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(PullToRefreshContainer)P(5,3,2,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color)113@4939L14,114@5003L12,118@5222L91,121@5318L650:PullToRefresh.kt#djiw08"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r27 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r9 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r9 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((java.lang.Object) r1)
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
            r4 = r27 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r9 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r18
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r18
        L_0x0045:
            r6 = r27 & 4
            if (r6 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r7 = r9 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005f
            r7 = r19
            boolean r8 = r2.changedInstance(r7)
            if (r8 == 0) goto L_0x005b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r8
            goto L_0x0061
        L_0x005f:
            r7 = r19
        L_0x0061:
            r8 = r27 & 8
            if (r8 == 0) goto L_0x0068
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r10 = r9 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007b
            r10 = r20
            boolean r11 = r2.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0077
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r3 = r3 | r11
            goto L_0x007d
        L_0x007b:
            r10 = r20
        L_0x007d:
            r11 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0096
            r11 = r27 & 16
            if (r11 != 0) goto L_0x0090
            r11 = r21
            boolean r13 = r2.changed((long) r11)
            if (r13 == 0) goto L_0x0092
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0090:
            r11 = r21
        L_0x0092:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r3 = r3 | r13
            goto L_0x0098
        L_0x0096:
            r11 = r21
        L_0x0098:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00b2
            r13 = r27 & 32
            if (r13 != 0) goto L_0x00ac
            r13 = r23
            boolean r15 = r2.changed((long) r13)
            if (r15 == 0) goto L_0x00ae
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r13 = r23
        L_0x00ae:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00b2:
            r13 = r23
        L_0x00b4:
            r15 = 74899(0x12493, float:1.04956E-40)
            r15 = r15 & r3
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r0) goto L_0x00cc
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00c4
            goto L_0x00cc
        L_0x00c4:
            r2.skipToGroupEnd()
        L_0x00c7:
            r3 = r7
            r4 = r10
            r7 = r13
            goto L_0x0197
        L_0x00cc:
            r2.startDefaults()
            r0 = r9 & 1
            r15 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x00ef
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00e0
            goto L_0x00ef
        L_0x00e0:
            r2.skipToGroupEnd()
            r0 = r27 & 16
            if (r0 == 0) goto L_0x00e9
            r3 = r3 & r16
        L_0x00e9:
            r0 = r27 & 32
            if (r0 == 0) goto L_0x0120
        L_0x00ed:
            r3 = r3 & r15
            goto L_0x0120
        L_0x00ef:
            if (r4 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x00f6:
            if (r6 == 0) goto L_0x00ff
            androidx.compose.material3.pulltorefresh.ComposableSingletons$PullToRefreshKt r0 = androidx.compose.material3.pulltorefresh.ComposableSingletons$PullToRefreshKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m2630getLambda1$material3_release()
            r7 = r0
        L_0x00ff:
            if (r8 == 0) goto L_0x0108
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults r0 = androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getShape()
            r10 = r0
        L_0x0108:
            r0 = r27 & 16
            r4 = 6
            if (r0 == 0) goto L_0x0115
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults r0 = androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.INSTANCE
            long r11 = r0.getContainerColor(r2, r4)
            r3 = r3 & r16
        L_0x0115:
            r0 = r27 & 32
            if (r0 == 0) goto L_0x0120
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults r0 = androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.INSTANCE
            long r13 = r0.getContentColor(r2, r4)
            goto L_0x00ed
        L_0x0120:
            r2.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0132
            r0 = -1
            java.lang.String r4 = "androidx.compose.material3.pulltorefresh.PullToRefreshContainer (PullToRefresh.kt:115)"
            r6 = -801976958(0xffffffffd032cd82, float:-1.19992504E10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r3, r0, r4)
        L_0x0132:
            r0 = 751291370(0x2cc7cbea, float:5.678559E-12)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):PullToRefresh.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            java.lang.Object r0 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x0157
            androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$showElevation$1$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$showElevation$1$1
            r0.<init>(r1)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0)
            r2.updateRememberedValue(r0)
        L_0x0157:
            androidx.compose.runtime.State r0 = (androidx.compose.runtime.State) r0
            r2.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3806boximpl(r13)
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r4)
            androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1 r4 = new androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1
            r18 = r4
            r19 = r5
            r20 = r17
            r21 = r0
            r22 = r10
            r23 = r11
            r25 = r7
            r18.<init>(r19, r20, r21, r22, r23, r25)
            r0 = 935555266(0x37c370c2, float:2.3298318E-5)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r0, r6, r4)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r4 = androidx.compose.runtime.ProvidedValue.$stable
            r4 = r4 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r2, (int) r4)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00c7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x00c7
        L_0x0197:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x01b0
            androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$2 r14 = new androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$2
            r0 = r14
            r1 = r17
            r2 = r5
            r5 = r11
            r9 = r26
            r10 = r27
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x01b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshKt.m2634PullToRefreshContainerwBJOh4Y(androidx.compose.material3.pulltorefresh.PullToRefreshState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: kotlin.jvm.functions.Function0<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.pulltorefresh.PullToRefreshState, java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: kotlin.jvm.functions.Function0<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: kotlin.jvm.functions.Function0<java.lang.Boolean>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberPullToRefreshState--orJrPs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.pulltorefresh.PullToRefreshState m2640rememberPullToRefreshStateorJrPs(float r9, kotlin.jvm.functions.Function0<java.lang.Boolean> r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            r0 = 1935213334(0x73590316, float:1.7193466E31)
            r11.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberPullToRefreshState)P(1:c#ui.unit.Dp)253@9584L7,261@9888L176,255@9680L384:PullToRefresh.kt#djiw08"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x0015
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults r9 = androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.INSTANCE
            float r9 = r9.m2632getPositionalThresholdD9Ej5fM()
        L_0x0015:
            r1 = 2
            r13 = r13 & r1
            if (r13 == 0) goto L_0x001d
            androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$1 r10 = androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$1.INSTANCE
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
        L_0x001d:
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0029
            r13 = -1
            java.lang.String r2 = "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:252)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r13, r2)
        L_0x0029:
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r2)
            java.lang.Object r13 = r11.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            float r9 = r13.m6550toPx0680j_4(r9)
            java.lang.Float r13 = java.lang.Float.valueOf(r9)
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r0 = 0
            r2[r0] = r13
            r13 = 1
            r2[r13] = r10
            androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$Companion r1 = androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl.Companion
            androidx.compose.runtime.saveable.Saver r3 = r1.Saver(r9, r10)
            r1 = 804873447(0x2ff964e7, float:4.5364532E-10)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):PullToRefresh.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r1 = r11.changed((float) r9)
            r4 = r12 & 112(0x70, float:1.57E-43)
            r4 = r4 ^ 48
            r5 = 32
            if (r4 <= r5) goto L_0x0073
            boolean r4 = r11.changed((java.lang.Object) r10)
            if (r4 != 0) goto L_0x0077
        L_0x0073:
            r12 = r12 & 48
            if (r12 != r5) goto L_0x0078
        L_0x0077:
            r0 = r13
        L_0x0078:
            r12 = r1 | r0
            java.lang.Object r13 = r11.rememberedValue()
            if (r12 != 0) goto L_0x0088
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x0093
        L_0x0088:
            androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$2$1 r12 = new androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$2$1
            r12.<init>(r9, r10)
            r13 = r12
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r11.updateRememberedValue(r13)
        L_0x0093:
            r5 = r13
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r11.endReplaceableGroup()
            r7 = 0
            r8 = 4
            r4 = 0
            r6 = r11
            java.lang.Object r9 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r2, r3, (java.lang.String) r4, r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            androidx.compose.material3.pulltorefresh.PullToRefreshState r9 = (androidx.compose.material3.pulltorefresh.PullToRefreshState) r9
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00ac
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ac:
            r11.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshKt.m2640rememberPullToRefreshStateorJrPs(float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.pulltorefresh.PullToRefreshState");
    }

    public static /* synthetic */ PullToRefreshState PullToRefreshState$default(float f, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function0 = PullToRefreshKt$PullToRefreshState$1.INSTANCE;
        }
        return PullToRefreshState(f, z, function0);
    }

    public static final PullToRefreshState PullToRefreshState(float f, boolean z, Function0<Boolean> function0) {
        return new PullToRefreshStateImpl(z, f, function0);
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularArrowProgressIndicator-RPmYEkk  reason: not valid java name */
    public static final void m2633CircularArrowProgressIndicatorRPmYEkk(Function0<Float> function0, long j, Composer composer, int i) {
        int i2;
        Composer composer2;
        Function0<Float> function02 = function0;
        long j2 = j;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-569718810);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularArrowProgressIndicator)P(1,0:c#ui.graphics.Color)428@15876L61,430@16038L88,433@16148L74,436@16300L118,441@16456L443,434@16227L672:PullToRefresh.kt#djiw08");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569718810, i2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:427)");
            }
            startRestartGroup.startReplaceableGroup(-656076138);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            Path path = rememberedValue;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.m4111setFillTypeoQ8Xj4U(PathFillType.Companion.m4128getEvenOddRgk1Os());
                startRestartGroup.updateRememberedValue(Path);
                path = Path;
            }
            Path path2 = (Path) path;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-656075976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1(function02));
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$6((State) rememberedValue2), AlphaTween, 0.0f, (String) null, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 28);
            Modifier modifier = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(-656075714);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            int i4 = i2 & 14;
            boolean z = true;
            boolean z2 = i4 == 4;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new PullToRefreshKt$CircularArrowProgressIndicator$1$1(function02);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier r11 = SizeKt.m742size3ABfNKs(SemanticsModifierKt.semantics(modifier, true, (Function1) rememberedValue3), SpinnerSize);
            startRestartGroup.startReplaceableGroup(-656075558);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean changed = (i4 == 4) | startRestartGroup.changed((Object) animateFloatAsState);
            if ((i2 & 112) != 32) {
                z = false;
            }
            boolean changedInstance = changed | z | startRestartGroup.changedInstance(path2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                composer2 = startRestartGroup;
                rememberedValue4 = new PullToRefreshKt$CircularArrowProgressIndicator$2$1(function0, animateFloatAsState, j, path2);
                composer2.updateRememberedValue(rememberedValue4);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceableGroup();
            CanvasKt.Canvas(r11, (Function1) rememberedValue4, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PullToRefreshKt$CircularArrowProgressIndicator$3(function02, j2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCircularIndicator-KzyDr3Q  reason: not valid java name */
    public static final void m2639drawCircularIndicatorKzyDr3Q(DrawScope drawScope, long j, float f, ArrowValues arrowValues, Rect rect, float f2) {
        DrawScope.CC.m4455drawArcyD3GUKo$default(drawScope, j, arrowValues.getStartAngle(), arrowValues.getEndAngle() - arrowValues.getStartAngle(), false, rect.m3597getTopLeftF1C5BW0(), rect.m3595getSizeNHjbRc(), f, new Stroke(drawScope.m6550toPx0680j_4(f2), 0.0f, StrokeCap.Companion.m4230getButtKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 768, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float f) {
        float max = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * ((float) 5)) / ((float) 3);
        float coerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float pow = (((0.4f * max) - 16.0f) + (coerceIn - (((float) Math.pow((double) coerceIn, (double) 2)) / ((float) 4)))) * 0.5f;
        float f2 = (float) 360;
        return new ArrowValues(pow, pow * f2, ((MaxProgressArc * max) + pow) * f2, Math.min(1.0f, max));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawArrow-uDrxG_w  reason: not valid java name */
    public static final void m2638drawArrowuDrxG_w(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues, float f2) {
        DrawScope drawScope2 = drawScope;
        Path path2 = path;
        float f3 = f2;
        path.reset();
        path2.moveTo(0.0f, 0.0f);
        float f4 = ArrowWidth;
        path2.lineTo((drawScope2.m6550toPx0680j_4(f4) * arrowValues.getScale()) / ((float) 2), drawScope2.m6550toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path2.lineTo(drawScope2.m6550toPx0680j_4(f4) * arrowValues.getScale(), 0.0f);
        path2.m4113translatek4lQ0M(OffsetKt.Offset(((Math.min(rect.getWidth(), rect.getHeight()) / 2.0f) + Offset.m3562getXimpl(rect.m3592getCenterF1C5BW0())) - ((drawScope2.m6550toPx0680j_4(f4) * arrowValues.getScale()) / 2.0f), Offset.m3563getYimpl(rect.m3592getCenterF1C5BW0()) - drawScope2.m6550toPx0680j_4(f3)));
        float endAngle = arrowValues.getEndAngle() - drawScope2.m6550toPx0680j_4(f3);
        long r4 = drawScope.m4433getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long r11 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4526rotateUv8p0NA(endAngle, r4);
        DrawScope.CC.m4466drawPathLG529CI$default(drawScope2, path2, j, f, new Stroke(drawScope2.m6550toPx0680j_4(f3), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 48, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r11);
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }
}
