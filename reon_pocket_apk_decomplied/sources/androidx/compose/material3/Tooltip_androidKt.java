package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aq\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a@\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"PlainTooltip", "", "Landroidx/compose/material3/CaretScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretProperties", "Landroidx/compose/material3/CaretProperties;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip-Fg7CxbU", "(Landroidx/compose/material3/CaretScope;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CaretProperties;Landroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawCaretWithPath", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "density", "Landroidx/compose/ui/unit/Density;", "configuration", "Landroid/content/res/Configuration;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "drawCaretWithPath-Bx497Mc", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/unit/Density;Landroid/content/res/Configuration;JLandroidx/compose/material3/CaretProperties;Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/draw/DrawResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.android.kt */
public final class Tooltip_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* renamed from: PlainTooltip-Fg7CxbU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2605PlainTooltipFg7CxbU(androidx.compose.material3.CaretScope r30, androidx.compose.ui.Modifier r31, androidx.compose.material3.CaretProperties r32, androidx.compose.ui.graphics.Shape r33, long r34, long r36, float r38, float r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r1 = r30
            r11 = r40
            r12 = r42
            r13 = r43
            r0 = 419109811(0x18fb1bb3, float:6.490995E-24)
            r2 = r41
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(PlainTooltip)P(4!1,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)184@7877L26,184@7947L24,184@8017L26,83@3344L784:Tooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r13
            if (r3 == 0) goto L_0x001e
            r3 = r12 | 6
            goto L_0x0037
        L_0x001e:
            r3 = r12 & 6
            if (r3 != 0) goto L_0x0036
            r3 = r12 & 8
            if (r3 != 0) goto L_0x002b
            boolean r3 = r2.changed((java.lang.Object) r1)
            goto L_0x002f
        L_0x002b:
            boolean r3 = r2.changedInstance(r1)
        L_0x002f:
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r3 = r3 | r12
            goto L_0x0037
        L_0x0036:
            r3 = r12
        L_0x0037:
            r4 = r13 & 1
            if (r4 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x0051
        L_0x003e:
            r5 = r12 & 48
            if (r5 != 0) goto L_0x0051
            r5 = r31
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r3 = r3 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r31
        L_0x0053:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x005a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r8 = r12 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x006d
            r8 = r32
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0069
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r9 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r3 = r3 | r9
            goto L_0x006f
        L_0x006d:
            r8 = r32
        L_0x006f:
            r9 = r12 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0088
            r9 = r13 & 4
            if (r9 != 0) goto L_0x0082
            r9 = r33
            boolean r10 = r2.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0084
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0082:
            r9 = r33
        L_0x0084:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r3 = r3 | r10
            goto L_0x008a
        L_0x0088:
            r9 = r33
        L_0x008a:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x00a1
            r10 = r13 & 8
            r14 = r34
            if (r10 != 0) goto L_0x009d
            boolean r10 = r2.changed((long) r14)
            if (r10 == 0) goto L_0x009d
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r3 = r3 | r10
            goto L_0x00a3
        L_0x00a1:
            r14 = r34
        L_0x00a3:
            r10 = 196608(0x30000, float:2.75506E-40)
            r16 = r12 & r10
            if (r16 != 0) goto L_0x00bd
            r16 = r13 & 16
            r7 = r36
            if (r16 != 0) goto L_0x00b8
            boolean r17 = r2.changed((long) r7)
            if (r17 == 0) goto L_0x00b8
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r3 = r3 | r17
            goto L_0x00bf
        L_0x00bd:
            r7 = r36
        L_0x00bf:
            r17 = r13 & 32
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00ca
            r3 = r3 | r18
            r10 = r38
            goto L_0x00dd
        L_0x00ca:
            r18 = r12 & r18
            r10 = r38
            if (r18 != 0) goto L_0x00dd
            boolean r19 = r2.changed((float) r10)
            if (r19 == 0) goto L_0x00d9
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r3 = r3 | r19
        L_0x00dd:
            r19 = r13 & 64
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            if (r19 == 0) goto L_0x00e8
            r3 = r3 | r20
            r0 = r39
            goto L_0x00fb
        L_0x00e8:
            r21 = r12 & r20
            r0 = r39
            if (r21 != 0) goto L_0x00fb
            boolean r22 = r2.changed((float) r0)
            if (r22 == 0) goto L_0x00f7
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r3 = r3 | r22
        L_0x00fb:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0104
            r3 = r3 | r22
            goto L_0x0114
        L_0x0104:
            r0 = r12 & r22
            if (r0 != 0) goto L_0x0114
            boolean r0 = r2.changedInstance(r11)
            if (r0 == 0) goto L_0x0111
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r3 = r3 | r0
        L_0x0114:
            r0 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r0 & r3
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r5) goto L_0x0130
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0124
            goto L_0x0130
        L_0x0124:
            r2.skipToGroupEnd()
            r3 = r31
            r4 = r32
            r27 = r39
            r5 = r14
            goto L_0x02cc
        L_0x0130:
            r2.startDefaults()
            r0 = r12 & 1
            r22 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0168
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0141
            goto L_0x0168
        L_0x0141:
            r2.skipToGroupEnd()
            r0 = r13 & 4
            if (r0 == 0) goto L_0x014a
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014a:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0150
            r3 = r3 & r22
        L_0x0150:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0158
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r0
        L_0x0158:
            r0 = r31
            r4 = r32
            r27 = r39
            r6 = r9
            r5 = 0
            r28 = r14
            r14 = r3
            r3 = r10
        L_0x0164:
            r9 = r7
            r7 = r28
            goto L_0x01bb
        L_0x0168:
            if (r4 == 0) goto L_0x016f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0171
        L_0x016f:
            r0 = r31
        L_0x0171:
            if (r6 == 0) goto L_0x0175
            r4 = 0
            goto L_0x0177
        L_0x0175:
            r4 = r32
        L_0x0177:
            r6 = r13 & 4
            r5 = 6
            if (r6 == 0) goto L_0x0185
            androidx.compose.material3.TooltipDefaults r6 = androidx.compose.material3.TooltipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r6 = r6.getPlainTooltipContainerShape(r2, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0186
        L_0x0185:
            r6 = r9
        L_0x0186:
            r9 = r13 & 8
            if (r9 == 0) goto L_0x0192
            androidx.compose.material3.TooltipDefaults r9 = androidx.compose.material3.TooltipDefaults.INSTANCE
            long r14 = r9.getPlainTooltipContentColor(r2, r5)
            r3 = r3 & r22
        L_0x0192:
            r9 = r13 & 16
            if (r9 == 0) goto L_0x01a0
            androidx.compose.material3.TooltipDefaults r7 = androidx.compose.material3.TooltipDefaults.INSTANCE
            long r7 = r7.getPlainTooltipContainerColor(r2, r5)
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r5
        L_0x01a0:
            r5 = 0
            if (r17 == 0) goto L_0x01a9
            float r9 = (float) r5
            float r9 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r9)
            goto L_0x01aa
        L_0x01a9:
            r9 = r10
        L_0x01aa:
            if (r19 == 0) goto L_0x01b4
            float r10 = (float) r5
            float r10 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r10)
            r27 = r10
            goto L_0x01b6
        L_0x01b4:
            r27 = r39
        L_0x01b6:
            r28 = r14
            r14 = r3
            r3 = r9
            goto L_0x0164
        L_0x01bb:
            r2.endDefaults()
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x01cd
            r15 = -1
            java.lang.String r5 = "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:67)"
            r12 = 419109811(0x18fb1bb3, float:6.490995E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r14, r15, r5)
        L_0x01cd:
            r5 = 2067440203(0x7b3aa24b, float:9.690589E35)
            r2.startReplaceableGroup(r5)
            java.lang.String r5 = "70@2893L7,71@2952L7,72@2991L308"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            if (r4 == 0) goto L_0x027a
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r15)
            java.lang.Object r12 = r2.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalConfiguration()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r13)
            java.lang.Object r5 = r2.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            android.content.res.Configuration r5 = (android.content.res.Configuration) r5
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            r15 = 2067440371(0x7b3aa2f3, float:9.690722E35)
            r2.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember):Tooltip.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            boolean r15 = r2.changed((java.lang.Object) r12)
            boolean r17 = r2.changedInstance(r5)
            r15 = r15 | r17
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r14 & r17
            r38 = r3
            r18 = 196608(0x30000, float:2.75506E-40)
            r3 = r17 ^ r18
            r39 = r6
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r3 <= r6) goto L_0x0234
            boolean r3 = r2.changed((long) r9)
            if (r3 != 0) goto L_0x0238
        L_0x0234:
            r3 = r14 & r18
            if (r3 != r6) goto L_0x023a
        L_0x0238:
            r3 = 1
            goto L_0x023b
        L_0x023a:
            r3 = 0
        L_0x023b:
            r3 = r3 | r15
            r6 = r14 & 896(0x380, float:1.256E-42)
            r15 = 256(0x100, float:3.59E-43)
            if (r6 != r15) goto L_0x0245
            r24 = 1
            goto L_0x0247
        L_0x0245:
            r24 = 0
        L_0x0247:
            r3 = r3 | r24
            java.lang.Object r6 = r2.rememberedValue()
            if (r3 != 0) goto L_0x0257
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x026c
        L_0x0257:
            androidx.compose.material3.Tooltip_androidKt$PlainTooltip$customModifier$1$1 r3 = new androidx.compose.material3.Tooltip_androidKt$PlainTooltip$customModifier$1$1
            r31 = r3
            r32 = r12
            r33 = r5
            r34 = r9
            r36 = r4
            r31.<init>(r32, r33, r34, r36)
            r6 = r3
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r2.updateRememberedValue(r6)
        L_0x026c:
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier r3 = r1.drawCaret(r13, r6)
            androidx.compose.ui.Modifier r3 = r3.then(r0)
            goto L_0x027f
        L_0x027a:
            r38 = r3
            r39 = r6
            r3 = r0
        L_0x027f:
            r2.endReplaceableGroup()
            androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1 r5 = new androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1
            r5.<init>(r7, r11)
            r6 = -705895688(0xffffffffd5ece2f8, float:-3.25574459E13)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r6, r12, r5)
            r23 = r5
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            int r5 = r14 >> 6
            r6 = r5 & 112(0x70, float:1.57E-43)
            r6 = r6 | r20
            int r12 = r14 >> 9
            r12 = r12 & 896(0x380, float:1.256E-42)
            r6 = r6 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r5
            r6 = r6 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r12
            r25 = r6 | r5
            r26 = 72
            r18 = 0
            r22 = 0
            r14 = r3
            r15 = r39
            r16 = r9
            r20 = r38
            r21 = r27
            r24 = r2
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x02c5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02c5:
            r3 = r0
            r5 = r7
            r7 = r9
            r10 = r38
            r9 = r39
        L_0x02cc:
            androidx.compose.runtime.ScopeUpdateScope r14 = r2.endRestartGroup()
            if (r14 == 0) goto L_0x02eb
            androidx.compose.material3.Tooltip_androidKt$PlainTooltip$2 r15 = new androidx.compose.material3.Tooltip_androidKt$PlainTooltip$2
            r0 = r15
            r1 = r30
            r2 = r3
            r3 = r4
            r4 = r9
            r9 = r10
            r10 = r27
            r11 = r40
            r12 = r42
            r13 = r43
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x02eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Tooltip_androidKt.m2605PlainTooltipFg7CxbU(androidx.compose.material3.CaretScope, androidx.compose.ui.Modifier, androidx.compose.material3.CaretProperties, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCaretWithPath-Bx497Mc  reason: not valid java name */
    public static final DrawResult m2607drawCaretWithPathBx497Mc(CacheDrawScope cacheDrawScope, Density density, Configuration configuration, long j, CaretProperties caretProperties, LayoutCoordinates layoutCoordinates) {
        long j2;
        Density density2 = density;
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        Path Path = AndroidPath_androidKt.Path();
        if (layoutCoordinates2 != null) {
            int r3 = density2.m6545roundToPx0680j_4(caretProperties.m1584getCaretHeightD9Ej5fM());
            int r4 = density2.m6545roundToPx0680j_4(caretProperties.m1585getCaretWidthD9Ej5fM());
            int r5 = density2.m6545roundToPx0680j_4(Dp.m6614constructorimpl((float) configuration.screenWidthDp));
            int r0 = density2.m6545roundToPx0680j_4(TooltipKt.getSpacingBetweenTooltipAndAnchor());
            Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
            float left = boundsInWindow.getLeft();
            float right = boundsInWindow.getRight();
            float top = boundsInWindow.getTop();
            float f = (float) 2;
            float f2 = (right + left) / f;
            float f3 = right - left;
            float r12 = Size.m3631getWidthimpl(cacheDrawScope.m3452getSizeNHjbRc());
            float r13 = Size.m3628getHeightimpl(cacheDrawScope.m3452getSizeNHjbRc());
            boolean z = (top - r13) - ((float) r0) < 0.0f;
            if (z) {
                r13 = 0.0f;
            }
            float f4 = (float) r5;
            if ((r12 / f) + f2 > f4) {
                j2 = OffsetKt.Offset(r12 - (f4 - f2), r13);
            } else {
                j2 = OffsetKt.Offset(f2 - Math.max(left - ((Size.m3631getWidthimpl(cacheDrawScope.m3452getSizeNHjbRc()) / f) - (f3 / f)), 0.0f), r13);
            }
            if (z) {
                Path.moveTo(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2));
                float f5 = (float) (r4 / 2);
                Path.lineTo(Offset.m3562getXimpl(j2) + f5, Offset.m3563getYimpl(j2));
                Path.lineTo(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2) - ((float) r3));
                Path.lineTo(Offset.m3562getXimpl(j2) - f5, Offset.m3563getYimpl(j2));
                Path.close();
            } else {
                Path.moveTo(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2));
                float f6 = (float) (r4 / 2);
                Path.lineTo(Offset.m3562getXimpl(j2) + f6, Offset.m3563getYimpl(j2));
                Path.lineTo(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2) + ((float) r3));
                Path.lineTo(Offset.m3562getXimpl(j2) - f6, Offset.m3563getYimpl(j2));
                Path.close();
            }
        }
        return cacheDrawScope.onDrawWithContent(new Tooltip_androidKt$drawCaretWithPath$4(layoutCoordinates2, Path, j));
    }
}
