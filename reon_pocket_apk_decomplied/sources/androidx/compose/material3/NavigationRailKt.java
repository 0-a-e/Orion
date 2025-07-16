package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.tokens.NavigationRailTokens;
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

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001az\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\b\b\u0002\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00104\u001aq\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\u0006\u0010/\u001a\u00020)2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090+H\u0003¢\u0006\u0002\u0010:\u001a8\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aP\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J²\u0006\n\u0010K\u001a\u00020\u001bX\u0002²\u0006\n\u0010L\u001a\u00020\u001bX\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", "indicatorRipple", "indicator", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    /* access modifiers changed from: private */
    public static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    /* access modifiers changed from: private */
    public static final float IndicatorVerticalPaddingNoLabel;
    /* access modifiers changed from: private */
    public static final float IndicatorVerticalPaddingWithLabel;
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    /* access modifiers changed from: private */
    public static final float NavigationRailHeaderPadding = Dp.m6614constructorimpl((float) 8);
    private static final float NavigationRailItemHeight = NavigationRailTokens.INSTANCE.m2982getNoLabelActiveIndicatorHeightD9Ej5fM();
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailItemWidth = NavigationRailTokens.INSTANCE.m2979getContainerWidthD9Ej5fM();
    private static final float NavigationRailVerticalPadding;

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* renamed from: NavigationRail-qi6gXK8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2032NavigationRailqi6gXK8(androidx.compose.ui.Modifier r25, long r26, long r28, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.foundation.layout.WindowInsets r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r8 = r32
            r9 = r34
            r0 = 118552648(0x710f848, float:1.0906319E-34)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(NavigationRail)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,5)106@4973L14,107@5015L31,109@5162L12,112@5232L748:NavigationRail.kt#uh7d8r"
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
            boolean r13 = r1.changedInstance(r12)
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
            goto L_0x0179
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
            goto L_0x012e
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
            androidx.compose.material3.NavigationRailDefaults r3 = androidx.compose.material3.NavigationRailDefaults.INSTANCE
            long r5 = r3.getContainerColor(r1, r14)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x010d:
            r3 = r35 & 4
            if (r3 == 0) goto L_0x011c
            int r3 = r4 >> 3
            r3 = r3 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r5, r1, r3)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x011c:
            if (r7 == 0) goto L_0x0120
            r3 = 0
            r12 = r3
        L_0x0120:
            r3 = r35 & 16
            if (r3 == 0) goto L_0x00f0
            androidx.compose.material3.NavigationRailDefaults r3 = androidx.compose.material3.NavigationRailDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r14)
            r4 = r4 & r15
            r14 = r3
            r7 = r12
            goto L_0x00f2
        L_0x012e:
            r1.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x013d
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.NavigationRail (NavigationRail.kt:111)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r11, r12)
        L_0x013d:
            androidx.compose.material3.NavigationRailKt$NavigationRail$1 r0 = new androidx.compose.material3.NavigationRailKt$NavigationRail$1
            r0.<init>(r14, r7, r8)
            r11 = -2092683357(0xffffffff83442fa3, float:-5.7653907E-37)
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
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r21 = r0 | r10
            r22 = 114(0x72, float:1.6E-43)
            r11 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r10 = r2
            r12 = r5
            r0 = r14
            r14 = r3
            r20 = r1
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0177
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0177:
            r13 = r0
            r10 = r3
        L_0x0179:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x0195
            androidx.compose.material3.NavigationRailKt$NavigationRail$2 r14 = new androidx.compose.material3.NavigationRailKt$NavigationRail$2
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
        L_0x0195:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.m2032NavigationRailqi6gXK8(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationRailItem(boolean r33, kotlin.jvm.functions.Function0<kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, boolean r39, androidx.compose.material3.NavigationRailItemColors r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r1 = r33
            r10 = r43
            r11 = r44
            r0 = -1533971045(0xffffffffa491759b, float:-6.308296E-17)
            r2 = r42
            androidx.compose.runtime.Composer r12 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(NavigationRailItem)P(8,7,3,6,2,5)172@7762L8,173@7822L39,196@8797L2874:NavigationRail.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r12.changed((boolean) r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r10
            goto L_0x002b
        L_0x002a:
            r2 = r10
        L_0x002b:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            r14 = r34
            goto L_0x0046
        L_0x0034:
            r3 = r10 & 48
            r14 = r34
            if (r3 != 0) goto L_0x0046
            boolean r3 = r12.changedInstance(r14)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r2 = r2 | r3
        L_0x0046:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            r15 = r35
            goto L_0x0061
        L_0x004f:
            r3 = r10 & 384(0x180, float:5.38E-43)
            r15 = r35
            if (r3 != 0) goto L_0x0061
            boolean r3 = r12.changedInstance(r15)
            if (r3 == 0) goto L_0x005e
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r3
        L_0x0061:
            r3 = r11 & 8
            if (r3 == 0) goto L_0x0068
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r4 = r10 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x007b
            r4 = r36
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0077
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r5
            goto L_0x007d
        L_0x007b:
            r4 = r36
        L_0x007d:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0084
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r6 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x0097
            r6 = r37
            boolean r7 = r12.changed((boolean) r6)
            if (r7 == 0) goto L_0x0093
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r2 = r2 | r7
            goto L_0x0099
        L_0x0097:
            r6 = r37
        L_0x0099:
            r7 = r11 & 32
            r8 = 196608(0x30000, float:2.75506E-40)
            if (r7 == 0) goto L_0x00a1
            r2 = r2 | r8
            goto L_0x00b3
        L_0x00a1:
            r8 = r8 & r10
            if (r8 != 0) goto L_0x00b3
            r8 = r38
            boolean r9 = r12.changedInstance(r8)
            if (r9 == 0) goto L_0x00af
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r2 = r2 | r9
            goto L_0x00b5
        L_0x00b3:
            r8 = r38
        L_0x00b5:
            r9 = r11 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r9 == 0) goto L_0x00c0
            r2 = r2 | r16
            r13 = r39
            goto L_0x00d3
        L_0x00c0:
            r16 = r10 & r16
            r13 = r39
            if (r16 != 0) goto L_0x00d3
            boolean r17 = r12.changed((boolean) r13)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r2 = r2 | r17
        L_0x00d3:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r10 & r17
            if (r17 != 0) goto L_0x00ef
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00e8
            r0 = r40
            boolean r18 = r12.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00ea
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ec
        L_0x00e8:
            r0 = r40
        L_0x00ea:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ec:
            r2 = r2 | r18
            goto L_0x00f1
        L_0x00ef:
            r0 = r40
        L_0x00f1:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fc
            r2 = r2 | r18
            r8 = r41
            goto L_0x010f
        L_0x00fc:
            r18 = r10 & r18
            r8 = r41
            if (r18 != 0) goto L_0x010f
            boolean r19 = r12.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x010b
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x010b:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r2 = r2 | r19
        L_0x010f:
            r19 = 38347923(0x2492493, float:1.4777644E-37)
            r4 = r2 & r19
            r6 = 38347922(0x2492492, float:1.4777643E-37)
            if (r4 != r6) goto L_0x012f
            boolean r4 = r12.getSkipping()
            if (r4 != 0) goto L_0x0120
            goto L_0x012f
        L_0x0120:
            r12.skipToGroupEnd()
            r4 = r36
            r5 = r37
            r6 = r38
            r9 = r8
            r7 = r13
            r8 = r40
            goto L_0x0446
        L_0x012f:
            r12.startDefaults()
            r4 = r10 & 1
            java.lang.String r8 = "CC(remember):NavigationRail.kt#9igjgp"
            r6 = 1
            if (r4 == 0) goto L_0x0159
            boolean r4 = r12.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0140
            goto L_0x0159
        L_0x0140:
            r12.skipToGroupEnd()
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x014b
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r0
        L_0x014b:
            r0 = r36
            r9 = r38
            r7 = r40
            r22 = r41
            r5 = r2
            r21 = r13
            r13 = r37
            goto L_0x01b1
        L_0x0159:
            if (r3 == 0) goto L_0x0160
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0162
        L_0x0160:
            r3 = r36
        L_0x0162:
            if (r5 == 0) goto L_0x0166
            r4 = r6
            goto L_0x0168
        L_0x0166:
            r4 = r37
        L_0x0168:
            if (r7 == 0) goto L_0x016c
            r5 = 0
            goto L_0x016e
        L_0x016c:
            r5 = r38
        L_0x016e:
            if (r9 == 0) goto L_0x0171
            r13 = r6
        L_0x0171:
            r7 = r11 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0181
            androidx.compose.material3.NavigationRailItemDefaults r7 = androidx.compose.material3.NavigationRailItemDefaults.INSTANCE
            r9 = 6
            androidx.compose.material3.NavigationRailItemColors r7 = r7.colors(r12, r9)
            r9 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r9
            goto L_0x0183
        L_0x0181:
            r7 = r40
        L_0x0183:
            if (r0 == 0) goto L_0x01a9
            r0 = -1687813390(0xffffffff9b6602f2, float:-1.9026106E-22)
            r12.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            java.lang.Object r0 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r0 != r9) goto L_0x01a1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r0)
        L_0x01a1:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r12.endReplaceableGroup()
            r22 = r0
            goto L_0x01ab
        L_0x01a9:
            r22 = r41
        L_0x01ab:
            r0 = r3
            r9 = r5
            r21 = r13
            r5 = r2
            r13 = r4
        L_0x01b1:
            r12.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01c3
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:174)"
            r4 = -1533971045(0xffffffffa491759b, float:-6.308296E-17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r5, r2, r3)
        L_0x01c3:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1 r2 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
            r36 = r2
            r37 = r7
            r38 = r33
            r39 = r13
            r40 = r9
            r41 = r21
            r42 = r35
            r36.<init>(r37, r38, r39, r40, r41, r42)
            r3 = -1023357515(0xffffffffc300cdb5, float:-128.80354)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r3, r6, r2)
            r17 = r2
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            if (r9 == 0) goto L_0x01f4
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1 r2 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1
            r2.<init>(r7, r1, r13, r9)
            r3 = -105269599(0xfffffffff9b9b6a1, float:-1.2053488E35)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r3, r6, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r23 = r2
            goto L_0x01f6
        L_0x01f4:
            r23 = 0
        L_0x01f6:
            androidx.compose.ui.semantics.Role$Companion r2 = androidx.compose.ui.semantics.Role.Companion
            int r2 = r2.m5870getTabo7Vup1c()
            r3 = 0
            androidx.compose.ui.semantics.Role r2 = androidx.compose.ui.semantics.Role.m5857boximpl(r2)
            r36 = r0
            r37 = r33
            r38 = r22
            r39 = r3
            r40 = r13
            r41 = r2
            r42 = r34
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.selection.SelectableKt.m1000selectableO2vRcR0(r36, r37, r38, r39, r40, r41, r42)
            float r3 = NavigationRailItemHeight
            r4 = 0
            r0 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m727defaultMinSizeVpY3zN4$default(r2, r4, r3, r6, r0)
            float r3 = NavigationRailItemWidth
            r6 = 2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m749widthInVpY3zN4$default(r2, r3, r4, r6, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getCenter()
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            r6 = 54
            r37 = r5
            r5 = 1
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r5, r12, r6)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            r6 = 0
            int r24 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r6)
            androidx.compose.runtime.CompositionLocalMap r4 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r25.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r2)
            androidx.compose.runtime.Applier r6 = r12.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0265
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0265:
            r12.startReusableNode()
            boolean r6 = r12.getInserting()
            if (r6 == 0) goto L_0x0272
            r12.createNode(r5)
            goto L_0x0275
        L_0x0272:
            r12.useNode()
        L_0x0275:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3282constructorimpl(r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r0, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r4, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r4 = r5.getInserting()
            if (r4 != 0) goto L_0x02a5
            java.lang.Object r4 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r24)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x02b3
        L_0x02a5:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r24)
            r5.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r24)
            r5.apply(r4, r0)
        L_0x02b3:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r0)
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r2.invoke(r0, r12, r5)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r2 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 1104516321(0x41d594e1, float:26.697695)
            java.lang.String r2 = "C211@9346L145,*220@9775L7,225@10066L120,267@11627L27,261@11376L289:NavigationRail.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r2)
            if (r1 == 0) goto L_0x02e3
            r0 = 1065353216(0x3f800000, float:1.0)
            r2 = r0
            goto L_0x02e4
        L_0x02e3:
            r2 = 0
        L_0x02e4:
            r0 = 150(0x96, float:2.1E-43)
            r4 = 6
            r5 = 0
            r6 = 0
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r6, r5, r4, r5)
            androidx.compose.animation.core.AnimationSpec r0 = (androidx.compose.animation.core.AnimationSpec) r0
            r19 = 48
            r20 = 28
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = r3
            r3 = r0
            r28 = r4
            r0 = 0
            r4 = r24
            r24 = r37
            r29 = r5
            r30 = 1
            r5 = r25
            r25 = r6
            r6 = r26
            r31 = r7
            r7 = r12
            r32 = r8
            r8 = r19
            r18 = r9
            r9 = r20
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r5)
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            r4 = r27
            int r4 = r3.m6545roundToPx0680j_4(r4)
            androidx.compose.material3.tokens.NavigationRailTokens r5 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            float r5 = r5.m2977getActiveIndicatorWidthD9Ej5fM()
            int r3 = r3.m6545roundToPx0680j_4(r5)
            int r4 = r4 - r3
            float r3 = (float) r4
            r4 = 2
            float r4 = (float) r4
            float r3 = r3 / r4
            long r3 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = 1104517079(0x41d597d7, float:26.69914)
            r12.startReplaceableGroup(r0)
            r0 = r32
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r24 & r5
            r6 = 67108864(0x4000000, float:1.5046328E-36)
            if (r5 != r6) goto L_0x0363
            r6 = 1
            goto L_0x0365
        L_0x0363:
            r6 = r25
        L_0x0365:
            boolean r5 = r12.changed((long) r3)
            r5 = r5 | r6
            java.lang.Object r6 = r12.rememberedValue()
            if (r5 != 0) goto L_0x0378
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x0385
        L_0x0378:
            androidx.compose.material3.MappedInteractionSource r6 = new androidx.compose.material3.MappedInteractionSource
            r5 = r22
            androidx.compose.foundation.interaction.InteractionSource r5 = (androidx.compose.foundation.interaction.InteractionSource) r5
            r7 = 0
            r6.<init>(r5, r3, r7)
            r12.updateRememberedValue(r6)
        L_0x0385:
            androidx.compose.material3.MappedInteractionSource r6 = (androidx.compose.material3.MappedInteractionSource) r6
            r12.endReplaceableGroup()
            if (r18 == 0) goto L_0x03a6
            r3 = 1104517249(0x41d59881, float:26.699465)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "230@10292L5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            androidx.compose.material3.tokens.NavigationRailTokens r3 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r3 = r3.getActiveIndicatorShape()
            r4 = 6
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.material3.ShapesKt.getValue(r3, r12, r4)
            r12.endReplaceableGroup()
            goto L_0x03bf
        L_0x03a6:
            r4 = 6
            r3 = 1104517326(0x41d598ce, float:26.699612)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "232@10376L5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            androidx.compose.material3.tokens.NavigationRailTokens r3 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r3 = r3.getNoLabelActiveIndicatorShape()
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.material3.ShapesKt.getValue(r3, r12, r4)
            r12.endReplaceableGroup()
        L_0x03bf:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1 r5 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
            r5.<init>(r3, r6)
            r6 = 211026382(0xc9401ce, float:2.2804097E-31)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r6, r7, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1 r6 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
            r9 = r31
            r6.<init>(r2, r9, r3)
            r3 = -1862011490(0xffffffff9103f59e, float:-1.0409764E-28)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r3, r7, r6)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r6 = 1104518640(0x41d59df0, float:26.702118)
            r12.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            boolean r0 = r12.changed((java.lang.Object) r2)
            java.lang.Object r6 = r12.rememberedValue()
            if (r0 != 0) goto L_0x03f9
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r6 != r0) goto L_0x0404
        L_0x03f9:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1 r0 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1
            r0.<init>(r2)
            r6 = r0
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r12.updateRememberedValue(r6)
        L_0x0404:
            r7 = r6
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r12.endReplaceableGroup()
            r0 = 57344(0xe000, float:8.0356E-41)
            int r2 = r24 >> 6
            r0 = r0 & r2
            r0 = r0 | 438(0x1b6, float:6.14E-43)
            r2 = r5
            r4 = r17
            r5 = r23
            r6 = r21
            r8 = r12
            r16 = r9
            r9 = r0
            NavigationRailItemLayout(r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x043b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x043b:
            r4 = r36
            r5 = r13
            r8 = r16
            r6 = r18
            r7 = r21
            r9 = r22
        L_0x0446:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 == 0) goto L_0x0461
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$3 r13 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$3
            r0 = r13
            r1 = r33
            r2 = r34
            r3 = r35
            r10 = r43
            r11 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0461:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.NavigationRailItem(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationRailItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void NavigationRailItemLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, Function0<Float> function0, Composer composer, int i) {
        int i2;
        Function1 function1;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        boolean z2 = z;
        Function0<Float> function02 = function0;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1498399348);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailItemLayout)P(4,3,2,5)516@22576L2124,503@22202L2498:NavigationRail.kt#uh7d8r");
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
                ComposerKt.traceEventStart(1498399348, i2, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:502)");
            }
            startRestartGroup.startReplaceableGroup(-753441910);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
            int i4 = 458752 & i2;
            int i5 = 57344 & i2;
            boolean z3 = (i4 == 131072) | ((i2 & 7168) == 2048) | (i5 == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NavigationRailKt$NavigationRailItemLayout$2$1(function02, function28, z2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 484846918, "C504@22219L17,505@22245L11,507@22266L50:NavigationRail.kt#uh7d8r");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -960475328, "C507@22308L6:NavigationRail.kt#uh7d8r");
            function27.invoke(startRestartGroup, Integer.valueOf((i2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-753442160);
            ComposerKt.sourceInformation(startRestartGroup, "513@22472L60,510@22359L199");
            if (function28 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, "label");
                startRestartGroup.startReplaceableGroup(484847171);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                boolean z4 = (i5 == 16384) | (i4 == 131072);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    function1 = new NavigationRailKt$NavigationRailItemLayout$1$2$1(z, function02);
                    startRestartGroup.updateRememberedValue(function1);
                } else {
                    function1 = rememberedValue2;
                    boolean z5 = z;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(layoutId2, function1);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(graphicsLayer);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -960475087, "C514@22549L7:NavigationRail.kt#uh7d8r");
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
            endRestartGroup.updateScope(new NavigationRailKt$NavigationRailItemLayout$3(function2, function22, function23, function24, z, function0, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4  reason: not valid java name */
    public static final MeasureResult m2035placeIconX9ElhV4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, long j) {
        long j2 = j;
        int r2 = ConstraintsKt.m6540constrainWidthK40F9xA(j2, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        MeasureScope measureScope2 = measureScope;
        int r0 = ConstraintsKt.m6539constrainHeightK40F9xA(j2, measureScope.m6545roundToPx0680j_4(NavigationRailItemHeight));
        return MeasureScope.CC.layout$default(measureScope, r2, r0, (Map) null, new NavigationRailKt$placeIcon$1(placeable3, placeable, (r2 - placeable.getWidth()) / 2, (r0 - placeable.getHeight()) / 2, placeable2, (r2 - placeable2.getWidth()) / 2, (r0 - placeable2.getHeight()) / 2, r2, r0), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0  reason: not valid java name */
    public static final MeasureResult m2036placeLabelAndIconzUg2_y0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, boolean z, float f) {
        float f2;
        MeasureScope measureScope2 = measureScope;
        float f3 = IndicatorVerticalPaddingWithLabel;
        float height = ((float) placeable2.getHeight()) + measureScope2.m6550toPx0680j_4(f3);
        float f4 = NavigationRailItemVerticalPadding;
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
        int r16 = ConstraintsKt.m6540constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        return MeasureScope.CC.layout$default(measureScope, r16, MathKt.roundToInt(f6), (Map) null, new NavigationRailKt$placeLabelAndIcon$1(placeable4, z, f, placeable, (r16 - placeable.getWidth()) / 2, height2, f7, placeable2, (r16 - placeable2.getWidth()) / 2, coerceAtLeast, placeable3, (r16 - placeable3.getWidth()) / 2, coerceAtLeast - measureScope2.m6550toPx0680j_4(f3), r16, measureScope), 4, (Object) null);
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    static {
        float f = (float) 4;
        NavigationRailVerticalPadding = Dp.m6614constructorimpl(f);
        NavigationRailItemVerticalPadding = Dp.m6614constructorimpl(f);
        float f2 = (float) 2;
        IndicatorHorizontalPadding = Dp.m6614constructorimpl(Dp.m6614constructorimpl(NavigationRailTokens.INSTANCE.m2977getActiveIndicatorWidthD9Ej5fM() - NavigationRailTokens.INSTANCE.m2980getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingWithLabel = Dp.m6614constructorimpl(Dp.m6614constructorimpl(NavigationRailTokens.INSTANCE.m2976getActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m2980getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingNoLabel = Dp.m6614constructorimpl(Dp.m6614constructorimpl(NavigationRailTokens.INSTANCE.m2982getNoLabelActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m2980getIconSizeD9Ej5fM()) / f2);
    }
}
