package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
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
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0001\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ax\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b\u0018¢\u0006\u0002\b*H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a7\u0010-\u001a\u00020\u00122\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0002\u0010.\u001a=\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0012*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rH\u0002\u001a\u001c\u0010?\u001a\u00020\u0012*\u0002052\u0006\u0010@\u001a\u0002092\u0006\u0010<\u001a\u00020\rH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u001eX\u0002"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release", "color"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon = Dp.m6614constructorimpl((float) 6);
    private static final float HorizontalTextPadding = Dp.m6614constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    /* access modifiers changed from: private */
    public static final float LargeTabHeight = Dp.m6614constructorimpl((float) 72);
    private static final float SingleLineTextBaselineWithIcon = Dp.m6614constructorimpl((float) 14);
    /* access modifiers changed from: private */
    public static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m3110getContainerHeightD9Ej5fM();
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    /* access modifiers changed from: private */
    public static final float TextDistanceFromLeadingIcon = Dp.m6614constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00ff  */
    /* renamed from: Tab-wqdebIU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2343TabwqdebIU(boolean r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, long r35, long r37, androidx.compose.foundation.interaction.MutableInteractionSource r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r12 = r41
            r13 = r42
            r0 = -350627181(0xffffffffeb19da93, float:-1.8599784E26)
            r1 = r40
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)98@4483L7,100@4600L39,110@4967L234:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r12 | 6
            r3 = r2
            r2 = r29
            goto L_0x0030
        L_0x001c:
            r2 = r12 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r29
            boolean r3 = r1.changed((boolean) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r12
            goto L_0x0030
        L_0x002d:
            r2 = r29
            r3 = r12
        L_0x0030:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r12 & 48
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
            r5 = r13 & 4
            if (r5 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r12 & 384(0x180, float:5.38E-43)
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
            r7 = r13 & 8
            if (r7 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r8 = r12 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0082
            r8 = r32
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
            r8 = r32
        L_0x0084:
            r9 = r13 & 16
            if (r9 == 0) goto L_0x008b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008b:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009e
            r10 = r33
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x009a
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r11
            goto L_0x00a0
        L_0x009e:
            r10 = r33
        L_0x00a0:
            r11 = r13 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00a8
            r3 = r3 | r14
            goto L_0x00ba
        L_0x00a8:
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00ba
            r14 = r34
            boolean r15 = r1.changedInstance(r14)
            if (r15 == 0) goto L_0x00b6
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r3 = r3 | r15
            goto L_0x00bc
        L_0x00ba:
            r14 = r34
        L_0x00bc:
            r15 = 1572864(0x180000, float:2.204052E-39)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00d7
            r15 = r13 & 64
            if (r15 != 0) goto L_0x00d0
            r14 = r35
            boolean r16 = r1.changed((long) r14)
            if (r16 == 0) goto L_0x00d2
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d0:
            r14 = r35
        L_0x00d2:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r3 = r3 | r16
            goto L_0x00d9
        L_0x00d7:
            r14 = r35
        L_0x00d9:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00f2
            r0 = r13 & 128(0x80, float:1.794E-43)
            r14 = r37
            if (r0 != 0) goto L_0x00ee
            boolean r0 = r1.changed((long) r14)
            if (r0 == 0) goto L_0x00ee
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ee:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r3 = r3 | r0
            goto L_0x00f4
        L_0x00f2:
            r14 = r37
        L_0x00f4:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00ff
            r3 = r3 | r18
            r2 = r39
            goto L_0x0112
        L_0x00ff:
            r18 = r12 & r18
            r2 = r39
            if (r18 != 0) goto L_0x0112
            boolean r18 = r1.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x010e
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0110
        L_0x010e:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0110:
            r3 = r3 | r18
        L_0x0112:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r2 = r3 & r18
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r4) goto L_0x0132
            boolean r2 = r1.getSkipping()
            if (r2 != 0) goto L_0x0123
            goto L_0x0132
        L_0x0123:
            r1.skipToGroupEnd()
            r11 = r39
            r3 = r6
            r4 = r8
            r5 = r10
            r9 = r14
            r6 = r34
            r7 = r35
            goto L_0x0248
        L_0x0132:
            r1.startDefaults()
            r2 = r12 & 1
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0162
            boolean r2 = r1.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0146
            goto L_0x0162
        L_0x0146:
            r1.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x014f
            r3 = r3 & r18
        L_0x014f:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0157
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0157:
            r5 = r34
            r0 = r39
            r2 = r6
            r27 = r14
            r6 = r35
            goto L_0x01cf
        L_0x0162:
            if (r5 == 0) goto L_0x0169
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x016a
        L_0x0169:
            r2 = r6
        L_0x016a:
            if (r7 == 0) goto L_0x016d
            r8 = r4
        L_0x016d:
            if (r9 == 0) goto L_0x0171
            r10 = r19
        L_0x0171:
            if (r11 == 0) goto L_0x0176
            r5 = r19
            goto L_0x0178
        L_0x0176:
            r5 = r34
        L_0x0178:
            r6 = r13 & 64
            if (r6 == 0) goto L_0x019a
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r9)
            java.lang.Object r6 = r1.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.graphics.Color r6 = (androidx.compose.ui.graphics.Color) r6
            long r6 = r6.m3826unboximpl()
            r3 = r3 & r18
            goto L_0x019c
        L_0x019a:
            r6 = r35
        L_0x019c:
            r9 = r13 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x01a5
            r9 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r9
            r14 = r6
        L_0x01a5:
            if (r0 == 0) goto L_0x01cb
            r0 = 1665134950(0x633ff166, float:3.5407227E21)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Tab.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            java.lang.Object r0 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r0 != r9) goto L_0x01c5
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r0)
        L_0x01c5:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r1.endReplaceableGroup()
            goto L_0x01cd
        L_0x01cb:
            r0 = r39
        L_0x01cd:
            r27 = r14
        L_0x01cf:
            r1.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01e1
            r9 = -1
            java.lang.String r11 = "androidx.compose.material3.Tab (Tab.kt:101)"
            r14 = -350627181(0xffffffffeb19da93, float:-1.8599784E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r3, r9, r11)
        L_0x01e1:
            if (r10 == 0) goto L_0x01f3
            androidx.compose.material3.TabKt$Tab$styledText$1$1 r9 = new androidx.compose.material3.TabKt$Tab$styledText$1$1
            r9.<init>(r10)
            r11 = 708874428(0x2a4090bc, float:1.710324E-13)
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r11, r4, r9)
            r19 = r9
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
        L_0x01f3:
            r9 = r19
            androidx.compose.material3.TabKt$Tab$2 r11 = new androidx.compose.material3.TabKt$Tab$2
            r11.<init>(r9, r5)
            r9 = 1540996038(0x5bd9bbc6, float:1.22573058E17)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r9, r4, r11)
            r23 = r4
            kotlin.jvm.functions.Function3 r23 = (kotlin.jvm.functions.Function3) r23
            r4 = r3 & 14
            r4 = r4 | r16
            r9 = r3 & 112(0x70, float:1.57E-43)
            r4 = r4 | r9
            r9 = r3 & 896(0x380, float:1.256E-42)
            r4 = r4 | r9
            r9 = r3 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r9
            int r3 = r3 >> 6
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r3
            r4 = r4 | r9
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r3
            r4 = r4 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r9
            r25 = r4 | r3
            r26 = 0
            r14 = r29
            r15 = r30
            r16 = r2
            r17 = r8
            r18 = r6
            r20 = r27
            r22 = r0
            r24 = r1
            m2342TabbogVsAg(r14, r15, r16, r17, r18, r20, r22, r23, r24, r25, r26)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0240
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0240:
            r11 = r0
            r3 = r2
            r4 = r8
            r7 = r6
            r6 = r5
            r5 = r10
            r9 = r27
        L_0x0248:
            androidx.compose.runtime.ScopeUpdateScope r14 = r1.endRestartGroup()
            if (r14 == 0) goto L_0x0261
            androidx.compose.material3.TabKt$Tab$3 r15 = new androidx.compose.material3.TabKt$Tab$3
            r0 = r15
            r1 = r29
            r2 = r30
            r12 = r41
            r13 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0261:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2343TabwqdebIU(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011d  */
    /* renamed from: LeadingIconTab-wqdebIU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2341LeadingIconTabwqdebIU(boolean r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, long r29, long r31, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r12 = r35
            r13 = r36
            r0 = -777316544(0xffffffffd1ab1740, float:-9.1853685E10)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LeadingIconTab)P(5,4,7,1,3!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)160@7001L7,162@7118L39,168@7466L82,173@7554L991:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r12 | 6
            r3 = r2
            r2 = r23
            goto L_0x0030
        L_0x001c:
            r2 = r12 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r23
            boolean r3 = r1.changed((boolean) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r12
            goto L_0x0030
        L_0x002d:
            r2 = r23
            r3 = r12
        L_0x0030:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            r14 = r24
            goto L_0x004b
        L_0x0039:
            r4 = r12 & 48
            r14 = r24
            if (r4 != 0) goto L_0x004b
            boolean r4 = r1.changedInstance(r14)
            if (r4 == 0) goto L_0x0048
            r4 = 32
            goto L_0x004a
        L_0x0048:
            r4 = 16
        L_0x004a:
            r3 = r3 | r4
        L_0x004b:
            r4 = r13 & 4
            if (r4 == 0) goto L_0x0054
            r3 = r3 | 384(0x180, float:5.38E-43)
            r15 = r25
            goto L_0x0066
        L_0x0054:
            r4 = r12 & 384(0x180, float:5.38E-43)
            r15 = r25
            if (r4 != 0) goto L_0x0066
            boolean r4 = r1.changedInstance(r15)
            if (r4 == 0) goto L_0x0063
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r3 = r3 | r4
        L_0x0066:
            r4 = r13 & 8
            if (r4 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r11 = r26
            goto L_0x0081
        L_0x006f:
            r4 = r12 & 3072(0xc00, float:4.305E-42)
            r11 = r26
            if (r4 != 0) goto L_0x0081
            boolean r4 = r1.changedInstance(r11)
            if (r4 == 0) goto L_0x007e
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r4
        L_0x0081:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x0088
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r5 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x009b
            r5 = r27
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0097
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r6
            goto L_0x009d
        L_0x009b:
            r5 = r27
        L_0x009d:
            r6 = r13 & 32
            r7 = 196608(0x30000, float:2.75506E-40)
            if (r6 == 0) goto L_0x00a5
            r3 = r3 | r7
            goto L_0x00b7
        L_0x00a5:
            r7 = r7 & r12
            if (r7 != 0) goto L_0x00b7
            r7 = r28
            boolean r8 = r1.changed((boolean) r7)
            if (r8 == 0) goto L_0x00b3
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r8
            goto L_0x00b9
        L_0x00b7:
            r7 = r28
        L_0x00b9:
            r8 = 1572864(0x180000, float:2.204052E-39)
            r8 = r8 & r12
            if (r8 != 0) goto L_0x00d3
            r8 = r13 & 64
            if (r8 != 0) goto L_0x00cd
            r8 = r29
            boolean r10 = r1.changed((long) r8)
            if (r10 == 0) goto L_0x00cf
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cd:
            r8 = r29
        L_0x00cf:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r10
            goto L_0x00d5
        L_0x00d3:
            r8 = r29
        L_0x00d5:
            r10 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00ed
            r10 = r13 & 128(0x80, float:1.794E-43)
            r7 = r31
            if (r10 != 0) goto L_0x00e9
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x00e9
            r9 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00e9:
            r9 = 4194304(0x400000, float:5.877472E-39)
        L_0x00eb:
            r3 = r3 | r9
            goto L_0x00ef
        L_0x00ed:
            r7 = r31
        L_0x00ef:
            r9 = r13 & 256(0x100, float:3.59E-43)
            r10 = 100663296(0x6000000, float:2.4074124E-35)
            if (r9 == 0) goto L_0x00f7
            r3 = r3 | r10
            goto L_0x010a
        L_0x00f7:
            r10 = r10 & r12
            if (r10 != 0) goto L_0x010a
            r10 = r33
            boolean r16 = r1.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x0105
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0107
        L_0x0105:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0107:
            r3 = r3 | r16
            goto L_0x010c
        L_0x010a:
            r10 = r33
        L_0x010c:
            r16 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r3 & r16
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x0128
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x011d
            goto L_0x0128
        L_0x011d:
            r1.skipToGroupEnd()
            r6 = r28
            r11 = r10
            r9 = r7
            r7 = r29
            goto L_0x023c
        L_0x0128:
            r1.startDefaults()
            r0 = r12 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0156
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0139
            goto L_0x0156
        L_0x0139:
            r1.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0142
            r3 = r3 & r16
        L_0x0142:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x014a
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x014a:
            r2 = r28
            r18 = r29
        L_0x014e:
            r0 = r5
            r20 = r7
            r16 = r10
            r10 = r3
            goto L_0x01c1
        L_0x0156:
            if (r4 == 0) goto L_0x015d
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x015d:
            if (r6 == 0) goto L_0x0161
            r0 = 1
            goto L_0x0163
        L_0x0161:
            r0 = r28
        L_0x0163:
            r4 = r13 & 64
            if (r4 == 0) goto L_0x0185
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r2)
            java.lang.Object r2 = r1.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r18 = r2.m3826unboximpl()
            r3 = r3 & r16
            goto L_0x0187
        L_0x0185:
            r18 = r29
        L_0x0187:
            r2 = r13 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0192
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r3
            r3 = r2
            r7 = r18
        L_0x0192:
            if (r9 == 0) goto L_0x01bf
            r2 = -788247595(0xffffffffd1044bd5, float:-3.5512996E10)
            r1.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Tab.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            java.lang.Object r2 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x01b2
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r2)
        L_0x01b2:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r1.endReplaceableGroup()
            r16 = r2
            r10 = r3
            r20 = r7
            r2 = r0
            r0 = r5
            goto L_0x01c1
        L_0x01bf:
            r2 = r0
            goto L_0x014e
        L_0x01c1:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01d3
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.LeadingIconTab (Tab.kt:163)"
            r5 = -777316544(0xffffffffd1ab1740, float:-9.1853685E10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r10, r3, r4)
        L_0x01d3:
            int r3 = r10 >> 12
            r3 = r3 & 896(0x380, float:1.256E-42)
            r3 = r3 | 6
            r4 = 2
            r5 = 1
            r6 = 0
            r27 = r5
            r28 = r6
            r29 = r18
            r31 = r1
            r32 = r3
            r33 = r4
            androidx.compose.foundation.Indication r7 = androidx.compose.material.ripple.RippleKt.m1491rememberRipple9IZ8Weo(r27, r28, r29, r31, r32, r33)
            androidx.compose.material3.TabKt$LeadingIconTab$2 r9 = new androidx.compose.material3.TabKt$LeadingIconTab$2
            r3 = r9
            r4 = r0
            r5 = r23
            r6 = r16
            r8 = r2
            r17 = r0
            r0 = r9
            r9 = r24
            r22 = r10
            r10 = r26
            r11 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -429037564(0xffffffffe66d6804, float:-2.802799E23)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r3, r4, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r3 = r22 >> 18
            r4 = r3 & 14
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            int r4 = r22 << 6
            r4 = r4 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            r27 = r18
            r29 = r20
            r31 = r23
            r32 = r0
            r33 = r1
            r34 = r3
            m2344TabTransitionKlgxPg(r27, r29, r31, r32, r33, r34)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0233
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0233:
            r6 = r2
            r11 = r16
            r5 = r17
            r7 = r18
            r9 = r20
        L_0x023c:
            androidx.compose.runtime.ScopeUpdateScope r4 = r1.endRestartGroup()
            if (r4 == 0) goto L_0x025d
            androidx.compose.material3.TabKt$LeadingIconTab$3 r16 = new androidx.compose.material3.TabKt$LeadingIconTab$3
            r0 = r16
            r1 = r23
            r2 = r24
            r3 = r25
            r14 = r4
            r4 = r26
            r12 = r35
            r13 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x025d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2341LeadingIconTabwqdebIU(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0111  */
    /* renamed from: Tab-bogVsAg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2342TabbogVsAg(boolean r27, kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, long r31, long r33, androidx.compose.foundation.interaction.MutableInteractionSource r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r11 = r38
            r12 = r39
            r0 = -202735880(0xfffffffff3ea7ef8, float:-3.715737E31)
            r1 = r37
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Tab)P(5,4,3,1,6:c#ui.graphics.Color,7:c#ui.graphics.Color,2)234@10306L7,236@10423L39,243@10817L82,248@10905L618:Tab.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r10 = r27
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r10 = r27
            if (r1 != 0) goto L_0x002c
            boolean r1 = r9.changed((boolean) r10)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r8 = r28
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r8 = r28
            if (r2 != 0) goto L_0x0048
            boolean r2 = r9.changedInstance(r8)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r29
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r29
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r30
            boolean r6 = r9.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r30
        L_0x0080:
            r6 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x0099
            r6 = r12 & 16
            if (r6 != 0) goto L_0x0093
            r6 = r31
            boolean r13 = r9.changed((long) r6)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r6 = r31
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r13
            goto L_0x009b
        L_0x0099:
            r6 = r31
        L_0x009b:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00b5
            r13 = r12 & 32
            if (r13 != 0) goto L_0x00af
            r13 = r33
            boolean r15 = r9.changed((long) r13)
            if (r15 == 0) goto L_0x00b1
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r13 = r33
        L_0x00b1:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r1 = r1 | r15
            goto L_0x00b7
        L_0x00b5:
            r13 = r33
        L_0x00b7:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c2
            r1 = r1 | r16
            r0 = r35
            goto L_0x00d5
        L_0x00c2:
            r16 = r11 & r16
            r0 = r35
            if (r16 != 0) goto L_0x00d5
            boolean r17 = r9.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00d1
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r1 = r1 | r17
        L_0x00d5:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00de
            r1 = r1 | r17
            goto L_0x00f2
        L_0x00de:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00f2
            r0 = r36
            boolean r17 = r9.changedInstance(r0)
            if (r17 == 0) goto L_0x00ed
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ed:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r17
            goto L_0x00f4
        L_0x00f2:
            r0 = r36
        L_0x00f4:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r1 & r17
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0111
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x0105
            goto L_0x0111
        L_0x0105:
            r9.skipToGroupEnd()
            r3 = r29
            r26 = r35
            r4 = r5
            r5 = r6
            r7 = r13
            goto L_0x020d
        L_0x0111:
            r9.startDefaults()
            r0 = r11 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = 1
            if (r0 == 0) goto L_0x013f
            boolean r0 = r9.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0123
            goto L_0x013f
        L_0x0123:
            r9.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x012c
            r1 = r1 & r17
        L_0x012c:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0134
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r0
        L_0x0134:
            r0 = r29
        L_0x0136:
            r26 = r35
        L_0x0138:
            r21 = r5
            r22 = r6
            r24 = r13
            goto L_0x019d
        L_0x013f:
            if (r2 == 0) goto L_0x0146
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0148
        L_0x0146:
            r0 = r29
        L_0x0148:
            if (r4 == 0) goto L_0x014b
            r5 = r3
        L_0x014b:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x016c
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r6)
            java.lang.Object r2 = r9.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r6 = r2.m3826unboximpl()
            r1 = r1 & r17
        L_0x016c:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x0175
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r2
            r13 = r6
        L_0x0175:
            if (r15 == 0) goto L_0x0136
            r2 = 1665140773(0x63400825, float:3.5423617E21)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Tab.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            java.lang.Object r2 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x0195
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r9.updateRememberedValue(r2)
        L_0x0195:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r9.endReplaceableGroup()
            r26 = r2
            goto L_0x0138
        L_0x019d:
            r9.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01af
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.Tab (Tab.kt:238)"
            r5 = -202735880(0xfffffffff3ea7ef8, float:-3.715737E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r1, r2, r4)
        L_0x01af:
            int r2 = r1 >> 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | 6
            r4 = 2
            r5 = 1
            r6 = 0
            r29 = r5
            r30 = r6
            r31 = r22
            r33 = r9
            r34 = r2
            r35 = r4
            androidx.compose.foundation.Indication r17 = androidx.compose.material.ripple.RippleKt.m1491rememberRipple9IZ8Weo(r29, r30, r31, r33, r34, r35)
            androidx.compose.material3.TabKt$Tab$5 r2 = new androidx.compose.material3.TabKt$Tab$5
            r13 = r2
            r14 = r0
            r15 = r27
            r16 = r26
            r18 = r21
            r19 = r28
            r20 = r36
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            r4 = -551896140(0xffffffffdf1abbb4, float:-1.1149703E19)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r4, r3, r2)
            r6 = r2
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            int r2 = r1 >> 12
            r3 = r2 & 14
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r1 = r1 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r13 = r2 | r1
            r1 = r22
            r3 = r24
            r5 = r27
            r7 = r9
            r8 = r13
            m2344TabTransitionKlgxPg(r1, r3, r5, r6, r7, r8)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0206
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0206:
            r3 = r0
            r4 = r21
            r5 = r22
            r7 = r24
        L_0x020d:
            androidx.compose.runtime.ScopeUpdateScope r13 = r9.endRestartGroup()
            if (r13 == 0) goto L_0x022a
            androidx.compose.material3.TabKt$Tab$6 r14 = new androidx.compose.material3.TabKt$Tab$6
            r0 = r14
            r1 = r27
            r2 = r28
            r9 = r26
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x022a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2342TabbogVsAg(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg  reason: not valid java name */
    public static final void m2344TabTransitionKlgxPg(long j, long j2, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(735731848);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)279@11954L26,280@12009L550,298@12564L99:Tab.kt#uh7d8r");
        long j3 = j;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed(j3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        long j4 = j2;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 32 : 16;
        }
        boolean z2 = z;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735731848, i2, -1, "androidx.compose.material3.TabTransition (Tab.kt:278)");
            }
            int i4 = i2 >> 6;
            Transition updateTransition = TransitionKt.updateTransition(Boolean.valueOf(z), (String) null, startRestartGroup, i4 & 14, 2);
            Function3 function3 = TabKt$TabTransition$color$2.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1939694975);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            boolean booleanValue = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceableGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:296)");
            }
            long j5 = booleanValue ? j : j4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceableGroup();
            ColorSpace r3 = Color.m3820getColorSpaceimpl(j5);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) r3);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(r3);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TwoWayConverter twoWayConverter = (TwoWayConverter) rememberedValue;
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            boolean booleanValue2 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceableGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:296)");
            }
            long j6 = booleanValue2 ? j : j4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceableGroup();
            Color r32 = Color.m3806boximpl(j6);
            boolean booleanValue3 = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceableGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:296)");
            }
            long j7 = booleanValue3 ? j : j4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, r32, Color.m3806boximpl(j7), (FiniteAnimationSpec) function3.invoke(updateTransition.getSegment(), startRestartGroup, 0), twoWayConverter, "ColorAnimation", startRestartGroup, 32768);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(TabTransition_Klgx_Pg$lambda$5(createTransitionAnimation))), function22, startRestartGroup, (i4 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabKt$TabTransition$1(j, j2, z, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(514131524);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabBaselineLayout)P(1)327@13445L1785,314@13071L2159:Tab.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, i2, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:313)");
            }
            startRestartGroup.startReplaceableGroup(150513508);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tab.kt#9igjgp");
            int i4 = i2 & 14;
            boolean z = true;
            boolean z2 = i4 == 4;
            if ((i2 & 112) != 32) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TabKt$TabBaselineLayout$2$1(function23, function24);
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
            Composer r14 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r14, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r14, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r14.getInserting() || !Intrinsics.areEqual(r14.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r14.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 720851373, "C:Tab.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(720851373);
            ComposerKt.sourceInformation(startRestartGroup, "317@13137L173");
            if (function23 != null) {
                Modifier r6 = PaddingKt.m672paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), HorizontalTextPadding, 0.0f, 2, (Object) null);
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
                Composer r142 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r142, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r142, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r142.getInserting() || !Intrinsics.areEqual(r142.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r142.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r142.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -978021225, "C321@13302L6:Tab.kt#uh7d8r");
                function23.invoke(startRestartGroup, Integer.valueOf(i4));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(150513400);
            ComposerKt.sourceInformation(startRestartGroup, "324@13373L41");
            if (function24 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "icon");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(layoutId);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r9 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r9, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r9, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r9.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -978021121, "C324@13406L6:Tab.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
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
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabKt$TabBaselineLayout$3(function23, function24, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        float f;
        Density density2 = density;
        int i5 = i3;
        int i6 = i4;
        if (i5 == i6) {
            f = SingleLineTextBaselineWithIcon;
        } else {
            f = DoubleLineTextBaselineWithIcon;
        }
        int r3 = density.m6545roundToPx0680j_4(f) + density.m6545roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m3108getActiveIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.m6544roundToPxR2X_6o(IconDistanceFromBaseline)) - i5;
        int i7 = (i2 - i6) - r3;
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, (i - placeable.getWidth()) / 2, i7, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, (i - placeable2.getWidth()) / 2, i7 - height, 0.0f, 4, (Object) null);
    }

    public static final float getHorizontalTextPadding() {
        return HorizontalTextPadding;
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> state) {
        return state.getValue().m3826unboximpl();
    }
}
