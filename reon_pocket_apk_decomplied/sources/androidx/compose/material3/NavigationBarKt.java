package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001ab\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00140\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001aq\u0010$\u001a\u00020\u00142\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\b 2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0&H\u0003¢\u0006\u0002\u0010.\u001a\u0001\u0010/\u001a\u00020\u0014*\u00020\u001f2\u0006\u00100\u001a\u00020+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140&2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u00102\u001a\u00020+2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\b 2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001a8\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001aP\u0010C\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\n\"\u0016\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0012\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0018X\u0002²\u0006\n\u0010I\u001a\u00020\u0018X\u0002²\u0006\n\u0010J\u001a\u00020\fX\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "()F", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", "indicatorRipple", "Lkotlin/Function0;", "indicator", "icon", "label", "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor", "itemWidth"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    /* access modifiers changed from: private */
    public static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = Dp.m6614constructorimpl((float) 12);
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    /* access modifiers changed from: private */
    public static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m2968getContainerHeightD9Ej5fM();
    private static final float NavigationBarIndicatorToLabelPadding = Dp.m6614constructorimpl((float) 4);
    private static final float NavigationBarItemHorizontalPadding = Dp.m6614constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:101:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* renamed from: NavigationBar-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2001NavigationBarHsRjFd4(androidx.compose.ui.Modifier r25, long r26, long r28, float r30, androidx.compose.foundation.layout.WindowInsets r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r8 = r32
            r9 = r34
            r0 = 1596802123(0x5f2d444b, float:1.2485187E19)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(NavigationBar)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,5)103@4868L14,104@4924L11,106@5082L12,109@5149L583:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r9 | 6
            r4 = r3
            r3 = r25
            goto L_0x0030
        L_0x001c:
            r3 = r9 & 6
            if (r3 != 0) goto L_0x002d
            r3 = r25
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r9
            goto L_0x0030
        L_0x002d:
            r3 = r25
            r4 = r9
        L_0x0030:
            r5 = r9 & 48
            if (r5 != 0) goto L_0x0049
            r5 = r35 & 2
            if (r5 != 0) goto L_0x0043
            r5 = r26
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x0045
            r7 = 32
            goto L_0x0047
        L_0x0043:
            r5 = r26
        L_0x0045:
            r7 = 16
        L_0x0047:
            r4 = r4 | r7
            goto L_0x004b
        L_0x0049:
            r5 = r26
        L_0x004b:
            r7 = r9 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0062
            r7 = r35 & 4
            r10 = r28
            if (r7 != 0) goto L_0x005e
            boolean r7 = r1.changed((long) r10)
            if (r7 == 0) goto L_0x005e
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r4 = r4 | r7
            goto L_0x0064
        L_0x0062:
            r10 = r28
        L_0x0064:
            r7 = r35 & 8
            if (r7 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r12 = r9 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r30
            boolean r13 = r1.changed((float) r12)
            if (r13 == 0) goto L_0x007a
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r4 = r4 | r13
            goto L_0x0080
        L_0x007e:
            r12 = r30
        L_0x0080:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r35 & 16
            if (r13 != 0) goto L_0x0093
            r13 = r31
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r13 = r31
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r4 = r4 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r31
        L_0x009b:
            r14 = r35 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r4 = r4 | r15
            goto L_0x00b3
        L_0x00a3:
            r14 = r9 & r15
            if (r14 != 0) goto L_0x00b3
            boolean r14 = r1.changedInstance(r8)
            if (r14 == 0) goto L_0x00b0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r4 = r4 | r14
        L_0x00b3:
            r14 = 74899(0x12493, float:1.04956E-40)
            r14 = r14 & r4
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00ca
            boolean r14 = r1.getSkipping()
            if (r14 != 0) goto L_0x00c3
            goto L_0x00ca
        L_0x00c3:
            r1.skipToGroupEnd()
            r2 = r3
            r7 = r12
            goto L_0x0185
        L_0x00ca:
            r1.startDefaults()
            r14 = r9 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r14 == 0) goto L_0x00f8
            boolean r14 = r1.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00db
            goto L_0x00f8
        L_0x00db:
            r1.skipToGroupEnd()
            r2 = r35 & 2
            if (r2 == 0) goto L_0x00e4
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00e4:
            r2 = r35 & 4
            if (r2 == 0) goto L_0x00ea
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ea:
            r2 = r35 & 16
            if (r2 == 0) goto L_0x00ef
            r4 = r4 & r15
        L_0x00ef:
            r2 = r3
        L_0x00f0:
            r7 = r12
            r14 = r13
        L_0x00f2:
            r23 = r10
            r10 = r4
            r3 = r23
            goto L_0x0135
        L_0x00f8:
            if (r2 == 0) goto L_0x00ff
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0100
        L_0x00ff:
            r2 = r3
        L_0x0100:
            r3 = r35 & 2
            r14 = 6
            if (r3 == 0) goto L_0x010d
            androidx.compose.material3.NavigationBarDefaults r3 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            long r5 = r3.getContainerColor(r1, r14)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x010d:
            r3 = r35 & 4
            if (r3 == 0) goto L_0x011e
            androidx.compose.material3.MaterialTheme r3 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r3 = r3.getColorScheme(r1, r14)
            long r10 = androidx.compose.material3.ColorSchemeKt.m1680contentColorFor4WTKRHQ(r3, r5)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x011e:
            if (r7 == 0) goto L_0x0127
            androidx.compose.material3.NavigationBarDefaults r3 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            float r3 = r3.m1988getElevationD9Ej5fM()
            r12 = r3
        L_0x0127:
            r3 = r35 & 16
            if (r3 == 0) goto L_0x00f0
            androidx.compose.material3.NavigationBarDefaults r3 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r14)
            r4 = r4 & r15
            r14 = r3
            r7 = r12
            goto L_0x00f2
        L_0x0135:
            r1.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0144
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.NavigationBar (NavigationBar.kt:108)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r11, r12)
        L_0x0144:
            androidx.compose.material3.NavigationBarKt$NavigationBar$1 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBar$1
            r0.<init>(r14, r8)
            r11 = 105663120(0x64c4a90, float:3.8422915E-35)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r11, r12, r0)
            r19 = r0
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r0 = r10 & 14
            r11 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r11
            int r10 = r10 << 3
            r11 = r10 & 896(0x380, float:1.256E-42)
            r0 = r0 | r11
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r11
            r21 = r0 | r10
            r22 = 98
            r11 = 0
            r17 = 0
            r18 = 0
            r10 = r2
            r12 = r5
            r0 = r14
            r14 = r3
            r16 = r7
            r20 = r1
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0183
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0183:
            r13 = r0
            r10 = r3
        L_0x0185:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x01a1
            androidx.compose.material3.NavigationBarKt$NavigationBar$2 r14 = new androidx.compose.material3.NavigationBarKt$NavigationBar$2
            r0 = r14
            r1 = r2
            r2 = r5
            r4 = r10
            r6 = r7
            r7 = r13
            r8 = r32
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r12.updateScope(r14)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.m2001NavigationBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationBarItem(androidx.compose.foundation.layout.RowScope r30, boolean r31, kotlin.jvm.functions.Function0<kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, boolean r37, androidx.compose.material3.NavigationBarItemColors r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r2 = r31
            r11 = r41
            r12 = r42
            r0 = -663510974(0xffffffffd873a042, float:-1.07147851E15)
            r1 = r40
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(NavigationBarItem)P(8,7,3,6,2,5)171@7961L8,172@8021L39,195@9011L33,209@9453L52,197@9050L2789:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r12
            if (r3 == 0) goto L_0x001e
            r3 = r11 | 6
            r14 = r30
            goto L_0x0030
        L_0x001e:
            r3 = r11 & 6
            r14 = r30
            if (r3 != 0) goto L_0x002f
            boolean r3 = r1.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r11
            goto L_0x0030
        L_0x002f:
            r3 = r11
        L_0x0030:
            r4 = r12 & 1
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x0047
        L_0x0037:
            r4 = r11 & 48
            if (r4 != 0) goto L_0x0047
            boolean r4 = r1.changed((boolean) r2)
            if (r4 == 0) goto L_0x0044
            r4 = 32
            goto L_0x0046
        L_0x0044:
            r4 = 16
        L_0x0046:
            r3 = r3 | r4
        L_0x0047:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            r15 = r32
            goto L_0x0062
        L_0x0050:
            r4 = r11 & 384(0x180, float:5.38E-43)
            r15 = r32
            if (r4 != 0) goto L_0x0062
            boolean r4 = r1.changedInstance(r15)
            if (r4 == 0) goto L_0x005f
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r4
        L_0x0062:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r10 = r33
            goto L_0x007d
        L_0x006b:
            r4 = r11 & 3072(0xc00, float:4.305E-42)
            r10 = r33
            if (r4 != 0) goto L_0x007d
            boolean r4 = r1.changedInstance(r10)
            if (r4 == 0) goto L_0x007a
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r4
        L_0x007d:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x0084
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r5 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x0097
            r5 = r34
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0093
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r6
            goto L_0x0099
        L_0x0097:
            r5 = r34
        L_0x0099:
            r6 = r12 & 16
            r7 = 196608(0x30000, float:2.75506E-40)
            if (r6 == 0) goto L_0x00a1
            r3 = r3 | r7
            goto L_0x00b3
        L_0x00a1:
            r7 = r7 & r11
            if (r7 != 0) goto L_0x00b3
            r7 = r35
            boolean r8 = r1.changed((boolean) r7)
            if (r8 == 0) goto L_0x00af
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r8
            goto L_0x00b5
        L_0x00b3:
            r7 = r35
        L_0x00b5:
            r8 = r12 & 32
            r9 = 1572864(0x180000, float:2.204052E-39)
            if (r8 == 0) goto L_0x00bd
            r3 = r3 | r9
            goto L_0x00d0
        L_0x00bd:
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00d0
            r9 = r36
            boolean r16 = r1.changedInstance(r9)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r9 = r36
        L_0x00d2:
            r16 = r12 & 64
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r16 == 0) goto L_0x00dd
            r3 = r3 | r17
            r13 = r37
            goto L_0x00f0
        L_0x00dd:
            r17 = r11 & r17
            r13 = r37
            if (r17 != 0) goto L_0x00f0
            boolean r18 = r1.changed((boolean) r13)
            if (r18 == 0) goto L_0x00ec
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r3 = r3 | r18
        L_0x00f0:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x010c
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x0105
            r0 = r38
            boolean r19 = r1.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x0107
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0109
        L_0x0105:
            r0 = r38
        L_0x0107:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0109:
            r3 = r3 | r19
            goto L_0x010e
        L_0x010c:
            r0 = r38
        L_0x010e:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r19 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0119
            r3 = r3 | r19
            r10 = r39
            goto L_0x012c
        L_0x0119:
            r19 = r11 & r19
            r10 = r39
            if (r19 != 0) goto L_0x012c
            boolean r20 = r1.changed((java.lang.Object) r10)
            if (r20 == 0) goto L_0x0128
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012a
        L_0x0128:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012a:
            r3 = r3 | r20
        L_0x012c:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r5 = r3 & r20
            r7 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r7) goto L_0x014a
            boolean r5 = r1.getSkipping()
            if (r5 != 0) goto L_0x013d
            goto L_0x014a
        L_0x013d:
            r1.skipToGroupEnd()
            r5 = r34
            r6 = r35
            r7 = r9
            r8 = r13
            r9 = r38
            goto L_0x0483
        L_0x014a:
            r1.startDefaults()
            r5 = r11 & 1
            r7 = 6
            java.lang.String r10 = "CC(remember):NavigationBar.kt#9igjgp"
            r9 = 1
            if (r5 == 0) goto L_0x0176
            boolean r5 = r1.getDefaultsInvalid()
            if (r5 == 0) goto L_0x015c
            goto L_0x0176
        L_0x015c:
            r1.skipToGroupEnd()
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0167
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = r3 & r0
        L_0x0167:
            r0 = r34
            r8 = r36
            r7 = r38
            r22 = r39
            r6 = r3
            r16 = r13
            r13 = r35
            goto L_0x01cf
        L_0x0176:
            if (r4 == 0) goto L_0x017d
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x017f
        L_0x017d:
            r4 = r34
        L_0x017f:
            if (r6 == 0) goto L_0x0183
            r5 = r9
            goto L_0x0185
        L_0x0183:
            r5 = r35
        L_0x0185:
            if (r8 == 0) goto L_0x0189
            r6 = 0
            goto L_0x018b
        L_0x0189:
            r6 = r36
        L_0x018b:
            if (r16 == 0) goto L_0x018e
            r13 = r9
        L_0x018e:
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x019e
            androidx.compose.material3.NavigationBarItemDefaults r8 = androidx.compose.material3.NavigationBarItemDefaults.INSTANCE
            androidx.compose.material3.NavigationBarItemColors r8 = r8.colors(r1, r7)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = r3 & r16
            goto L_0x01a0
        L_0x019e:
            r8 = r38
        L_0x01a0:
            if (r0 == 0) goto L_0x01c6
            r0 = -280425562(0xffffffffef490ba6, float:-6.222057E28)
            r1.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            java.lang.Object r0 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r16.getEmpty()
            if (r0 != r7) goto L_0x01be
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r0)
        L_0x01be:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r1.endReplaceableGroup()
            r22 = r0
            goto L_0x01c8
        L_0x01c6:
            r22 = r39
        L_0x01c8:
            r0 = r4
            r7 = r8
            r16 = r13
            r13 = r5
            r8 = r6
            r6 = r3
        L_0x01cf:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01e1
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:173)"
            r5 = -663510974(0xffffffffd873a042, float:-1.07147851E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r6, r3, r4)
        L_0x01e1:
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1 r3 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
            r34 = r3
            r35 = r7
            r36 = r31
            r37 = r13
            r38 = r8
            r39 = r16
            r40 = r33
            r34.<init>(r35, r36, r37, r38, r39, r40)
            r4 = -1419576100(0xffffffffab62fcdc, float:-8.064224E-13)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r4, r9, r3)
            r18 = r3
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            if (r8 == 0) goto L_0x0212
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1 r3 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
            r3.<init>(r7, r2, r13, r8)
            r4 = 1644987592(0x620c84c8, float:6.48028E20)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r4, r9, r3)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r23 = r3
            goto L_0x0214
        L_0x0212:
            r23 = 0
        L_0x0214:
            r3 = -280424572(0xffffffffef490f84, float:-6.2225244E28)
            r1.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            java.lang.Object r3 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            r5 = 0
            if (r3 != r4) goto L_0x0231
            androidx.compose.runtime.MutableIntState r3 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r5)
            r1.updateRememberedValue(r3)
        L_0x0231:
            r4 = r3
            androidx.compose.runtime.MutableIntState r4 = (androidx.compose.runtime.MutableIntState) r4
            r1.endReplaceableGroup()
            androidx.compose.ui.semantics.Role$Companion r3 = androidx.compose.ui.semantics.Role.Companion
            int r3 = r3.m5870getTabo7Vup1c()
            r24 = 0
            androidx.compose.ui.semantics.Role r3 = androidx.compose.ui.semantics.Role.m5857boximpl(r3)
            r34 = r0
            r35 = r31
            r36 = r22
            r37 = r24
            r38 = r13
            r39 = r3
            r40 = r32
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableKt.m1000selectableO2vRcR0(r34, r35, r36, r37, r38, r39, r40)
            r5 = 0
            r24 = r0
            float r0 = NavigationBarHeight
            r25 = r6
            r6 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m727defaultMinSizeVpY3zN4$default(r3, r5, r0, r9, r6)
            r3 = 2
            r5 = 0
            r6 = 1065353216(0x3f800000, float:1.0)
            r26 = 0
            r34 = r30
            r35 = r0
            r36 = r6
            r37 = r26
            r38 = r3
            r39 = r5
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r34, r35, r36, r37, r38, r39)
            r3 = -280424130(0xffffffffef49113e, float:-6.222733E28)
            r1.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            java.lang.Object r3 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r3 != r5) goto L_0x0296
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1 r3 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1
            r3.<init>(r4)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1.updateRememberedValue(r3)
        L_0x0296:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r0, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenter()
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            r5 = 54
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r9, r1, r5)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            r5 = 0
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r5)
            androidx.compose.runtime.CompositionLocalMap r5 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r26.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r34 = r4
            androidx.compose.runtime.Applier r4 = r1.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x02e1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02e1:
            r1.startReusableNode()
            boolean r4 = r1.getInserting()
            if (r4 == 0) goto L_0x02ee
            r1.createNode(r9)
            goto L_0x02f1
        L_0x02ee:
            r1.useNode()
        L_0x02f1:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3282constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r5 = r4.getInserting()
            if (r5 != 0) goto L_0x0321
            java.lang.Object r5 = r4.rememberedValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
            if (r5 != 0) goto L_0x032f
        L_0x0321:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r4.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r4.apply(r5, r3)
        L_0x032f:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r3)
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r0.invoke(r3, r1, r5)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r3 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 1035149946(0x3db3227a, float:0.0874681)
            java.lang.String r3 = "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r3)
            if (r2 == 0) goto L_0x035e
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x035f
        L_0x035e:
            r0 = 0
        L_0x035f:
            r3 = r0
            r0 = 100
            r4 = 6
            r5 = 0
            r9 = 0
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r5, r9, r4, r9)
            r4 = r0
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r0 = 48
            r20 = 28
            r6 = 0
            r21 = 0
            r26 = 0
            r27 = r34
            r28 = r5
            r5 = r6
            r6 = r21
            r29 = r7
            r7 = r26
            r21 = r8
            r8 = r1
            r9 = r0
            r0 = r10
            r10 = r20
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r6)
            java.lang.Object r4 = r1.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.material3.tokens.NavigationBarTokens r5 = androidx.compose.material3.tokens.NavigationBarTokens.INSTANCE
            float r5 = r5.m2966getActiveIndicatorWidthD9Ej5fM()
            int r5 = r4.m6545roundToPx0680j_4(r5)
            int r6 = NavigationBarItem$lambda$3(r27)
            int r6 = r6 - r5
            float r5 = (float) r6
            r6 = 2
            float r6 = (float) r6
            float r5 = r5 / r6
            float r6 = IndicatorVerticalOffset
            float r4 = r4.m6550toPx0680j_4(r6)
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r5, r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r6 = 1035150713(0x3db32579, float:0.08747382)
            r1.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r25 & r6
            r7 = 536870912(0x20000000, float:1.0842022E-19)
            if (r6 != r7) goto L_0x03d4
            r9 = 1
            goto L_0x03d6
        L_0x03d4:
            r9 = r28
        L_0x03d6:
            boolean r6 = r1.changed((long) r4)
            r6 = r6 | r9
            java.lang.Object r7 = r1.rememberedValue()
            if (r6 != 0) goto L_0x03e9
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x03f6
        L_0x03e9:
            androidx.compose.material3.MappedInteractionSource r7 = new androidx.compose.material3.MappedInteractionSource
            r6 = r22
            androidx.compose.foundation.interaction.InteractionSource r6 = (androidx.compose.foundation.interaction.InteractionSource) r6
            r8 = 0
            r7.<init>(r6, r4, r8)
            r1.updateRememberedValue(r7)
        L_0x03f6:
            androidx.compose.material3.MappedInteractionSource r7 = (androidx.compose.material3.MappedInteractionSource) r7
            r1.endReplaceableGroup()
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1 r4 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
            r4.<init>(r7)
            r5 = 691730997(0x293afa35, float:4.1517317E-14)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r5, r6, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1 r5 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
            r10 = r29
            r5.<init>(r3, r10)
            r7 = -474426875(0xffffffffe3b8d205, float:-6.818669E21)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r7, r6, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 1035152133(0x3db32b05, float:0.0874844)
            r1.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            boolean r0 = r1.changed((java.lang.Object) r3)
            java.lang.Object r6 = r1.rememberedValue()
            if (r0 != 0) goto L_0x0435
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r6 != r0) goto L_0x0440
        L_0x0435:
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
            r0.<init>(r3)
            r6 = r0
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r1.updateRememberedValue(r6)
        L_0x0440:
            r8 = r6
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r1.endReplaceableGroup()
            int r0 = r25 >> 9
            r3 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r3
            r0 = r0 | 438(0x1b6, float:6.14E-43)
            r3 = r4
            r4 = r5
            r5 = r18
            r6 = r23
            r7 = r16
            r9 = r1
            r17 = r10
            r10 = r0
            NavigationBarItemLayout(r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0478
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0478:
            r6 = r13
            r8 = r16
            r9 = r17
            r7 = r21
            r10 = r22
            r5 = r24
        L_0x0483:
            androidx.compose.runtime.ScopeUpdateScope r13 = r1.endRestartGroup()
            if (r13 == 0) goto L_0x04a3
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$4 r16 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$4
            r0 = r16
            r1 = r30
            r2 = r31
            r3 = r32
            r4 = r33
            r11 = r41
            r12 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x04a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.NavigationBarItem(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationBarItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final int NavigationBarItem$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* access modifiers changed from: private */
    public static final void NavigationBarItemLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, Function0<Float> function0, Composer composer, int i) {
        int i2;
        Function1 function1;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        boolean z2 = z;
        Function0<Float> function02 = function0;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1427075886);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBarItemLayout)P(4,3,2,5)520@22742L1945,506@22286L2401:NavigationBar.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function25) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function28) ? 2048 : 1024;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1427075886, i2, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:505)");
            }
            startRestartGroup.startReplaceableGroup(-1250032035);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            int i4 = 458752 & i2;
            int i5 = 57344 & i2;
            boolean z3 = (i4 == 131072) | ((i2 & 7168) == 2048) | (i5 == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NavigationBarKt$NavigationBarItemLayout$2$1(function02, function28, z2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1836184647, "C507@22303L17,508@22329L11,510@22350L50:NavigationBar.kt#uh7d8r");
            function25.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            function26.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, IconLayoutIdTag);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutId);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 610171585, "C510@22392L6:NavigationBar.kt#uh7d8r");
            function27.invoke(startRestartGroup, Integer.valueOf((i2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1250032367);
            ComposerKt.sourceInformation(startRestartGroup, "516@22556L60,513@22443L281");
            if (function28 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                startRestartGroup.startReplaceableGroup(1836184900);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                boolean z4 = (i5 == 16384) | (i4 == 131072);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    function1 = new NavigationBarKt$NavigationBarItemLayout$1$2$1(z, function02);
                    startRestartGroup.updateRememberedValue(function1);
                } else {
                    function1 = rememberedValue2;
                    boolean z5 = z;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier r0 = PaddingKt.m672paddingVpY3zN4$default(GraphicsLayerModifierKt.graphicsLayer(layoutId2, function1), Dp.m6614constructorimpl(NavigationBarItemHorizontalPadding / ((float) 2)), 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(r0);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r12 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r12, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r12, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r12.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 610171908, "C518@22715L7:NavigationBar.kt#uh7d8r");
                function28.invoke(startRestartGroup, Integer.valueOf((i2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                boolean z6 = z;
            }
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
            boolean z7 = z2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationBarKt$NavigationBarItemLayout$3(function2, function22, function23, function24, z, function0, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4  reason: not valid java name */
    public static final MeasureResult m2004placeIconX9ElhV4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, long j) {
        int r10 = Constraints.m6526getMaxWidthimpl(j);
        MeasureScope measureScope2 = measureScope;
        int r12 = ConstraintsKt.m6539constrainHeightK40F9xA(j, measureScope.m6545roundToPx0680j_4(NavigationBarHeight));
        return MeasureScope.CC.layout$default(measureScope, r10, r12, (Map) null, new NavigationBarKt$placeIcon$1(placeable3, placeable, (r10 - placeable.getWidth()) / 2, (r12 - placeable.getHeight()) / 2, placeable2, (r10 - placeable2.getWidth()) / 2, (r12 - placeable2.getHeight()) / 2, r10, r12), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0  reason: not valid java name */
    public static final MeasureResult m2005placeLabelAndIconzUg2_y0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, boolean z, float f) {
        float f2;
        MeasureScope measureScope2 = measureScope;
        float f3 = IndicatorVerticalPadding;
        float height = ((float) placeable2.getHeight()) + measureScope2.m6550toPx0680j_4(f3);
        float f4 = NavigationBarIndicatorToLabelPadding;
        float r0 = height + measureScope2.m6550toPx0680j_4(f4) + ((float) placeable.getHeight());
        float f5 = (float) 2;
        float coerceAtLeast = RangesKt.coerceAtLeast((((float) Constraints.m6527getMinHeightimpl(j)) - r0) / f5, measureScope2.m6550toPx0680j_4(f3));
        float f6 = r0 + (coerceAtLeast * f5);
        if (z) {
            f2 = coerceAtLeast;
        } else {
            f2 = (f6 - ((float) placeable2.getHeight())) / f5;
        }
        float f7 = (f2 - coerceAtLeast) * (((float) 1) - f);
        float height2 = ((float) placeable2.getHeight()) + coerceAtLeast + measureScope2.m6550toPx0680j_4(f3) + measureScope2.m6550toPx0680j_4(f4);
        int r16 = Constraints.m6526getMaxWidthimpl(j);
        int width = (r16 - placeable.getWidth()) / 2;
        int width2 = (r16 - placeable2.getWidth()) / 2;
        int width3 = (r16 - placeable3.getWidth()) / 2;
        float r13 = coerceAtLeast - measureScope2.m6550toPx0680j_4(f3);
        return MeasureScope.CC.layout$default(measureScope, r16, MathKt.roundToInt(f6), (Map) null, new NavigationBarKt$placeLabelAndIcon$1(placeable4, z, f, placeable, width, height2, f7, placeable2, width2, coerceAtLeast, placeable3, width3, r13, r16, measureScope), 4, (Object) null);
    }

    static {
        float f = (float) 2;
        IndicatorHorizontalPadding = Dp.m6614constructorimpl(Dp.m6614constructorimpl(NavigationBarTokens.INSTANCE.m2966getActiveIndicatorWidthD9Ej5fM() - NavigationBarTokens.INSTANCE.m2969getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = Dp.m6614constructorimpl(Dp.m6614constructorimpl(NavigationBarTokens.INSTANCE.m2965getActiveIndicatorHeightD9Ej5fM() - NavigationBarTokens.INSTANCE.m2969getIconSizeD9Ej5fM()) / f);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarIndicatorToLabelPadding;
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }

    /* access modifiers changed from: private */
    public static final void NavigationBarItem$lambda$4(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }
}
