package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ae\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001ag\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001aj\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
public final class SnackbarKt {
    /* access modifiers changed from: private */
    public static final float ContainerMaxWidth = Dp.m6614constructorimpl((float) 600);
    /* access modifiers changed from: private */
    public static final float HeightToFirstLine = Dp.m6614constructorimpl((float) 30);
    private static final float HorizontalSpacing = Dp.m6614constructorimpl((float) 16);
    private static final float HorizontalSpacingButtonSide;
    private static final float LongButtonVerticalOffset = Dp.m6614constructorimpl((float) 12);
    private static final float SeparateButtonExtraY = Dp.m6614constructorimpl((float) 2);
    private static final float SnackbarVerticalPadding = Dp.m6614constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float TextEndExtraSpacing;

    /* JADX WARNING: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0116  */
    /* renamed from: Snackbar-eQBnUkQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2218SnackbareQBnUkQ(androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, boolean r27, androidx.compose.ui.graphics.Shape r28, long r29, long r31, long r33, long r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r15 = r39
            r14 = r40
            r0 = -1235788955(0xffffffffb6575b65, float:-3.2090695E-6)
            r1 = r38
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)101@4932L5,102@4984L5,103@5034L12,104@5097L18,105@5173L25,108@5244L1420:Snackbar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r14 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r15 | 6
            r4 = r3
            r3 = r24
            goto L_0x0030
        L_0x001c:
            r3 = r15 & 6
            if (r3 != 0) goto L_0x002d
            r3 = r24
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r15
            goto L_0x0030
        L_0x002d:
            r3 = r24
            r4 = r15
        L_0x0030:
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            goto L_0x004a
        L_0x0037:
            r6 = r15 & 48
            if (r6 != 0) goto L_0x004a
            r6 = r25
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x0046
            r7 = 32
            goto L_0x0048
        L_0x0046:
            r7 = 16
        L_0x0048:
            r4 = r4 | r7
            goto L_0x004c
        L_0x004a:
            r6 = r25
        L_0x004c:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0053
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r8 = r15 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0066
            r8 = r26
            boolean r9 = r1.changedInstance(r8)
            if (r9 == 0) goto L_0x0062
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r4 = r4 | r9
            goto L_0x0068
        L_0x0066:
            r8 = r26
        L_0x0068:
            r9 = r14 & 8
            if (r9 == 0) goto L_0x006f
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r10 = r15 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0082
            r10 = r27
            boolean r11 = r1.changed((boolean) r10)
            if (r11 == 0) goto L_0x007e
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r4 = r4 | r11
            goto L_0x0084
        L_0x0082:
            r10 = r27
        L_0x0084:
            r11 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009d
            r11 = r14 & 16
            if (r11 != 0) goto L_0x0097
            r11 = r28
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0099
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0097:
            r11 = r28
        L_0x0099:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r4 = r4 | r12
            goto L_0x009f
        L_0x009d:
            r11 = r28
        L_0x009f:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r15
            if (r12 != 0) goto L_0x00ba
            r12 = r14 & 32
            if (r12 != 0) goto L_0x00b3
            r12 = r29
            boolean r16 = r1.changed((long) r12)
            if (r16 == 0) goto L_0x00b5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b3:
            r12 = r29
        L_0x00b5:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r4 = r4 | r16
            goto L_0x00bc
        L_0x00ba:
            r12 = r29
        L_0x00bc:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00d6
            r16 = r14 & 64
            r10 = r31
            if (r16 != 0) goto L_0x00d1
            boolean r16 = r1.changed((long) r10)
            if (r16 == 0) goto L_0x00d1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r4 = r4 | r16
            goto L_0x00d8
        L_0x00d6:
            r10 = r31
        L_0x00d8:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00f1
            r0 = r14 & 128(0x80, float:1.794E-43)
            r10 = r33
            if (r0 != 0) goto L_0x00ed
            boolean r0 = r1.changed((long) r10)
            if (r0 == 0) goto L_0x00ed
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ed:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r4 = r4 | r0
            goto L_0x00f3
        L_0x00f1:
            r10 = r33
        L_0x00f3:
            r0 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 & r15
            if (r0 != 0) goto L_0x010b
            r0 = r14 & 256(0x100, float:3.59E-43)
            r10 = r35
            if (r0 != 0) goto L_0x0107
            boolean r0 = r1.changed((long) r10)
            if (r0 == 0) goto L_0x0107
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0109
        L_0x0107:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0109:
            r4 = r4 | r0
            goto L_0x010d
        L_0x010b:
            r10 = r35
        L_0x010d:
            r0 = r14 & 512(0x200, float:7.175E-43)
            r17 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0116
            r4 = r4 | r17
            goto L_0x012a
        L_0x0116:
            r0 = r15 & r17
            if (r0 != 0) goto L_0x012a
            r0 = r37
            boolean r17 = r1.changedInstance(r0)
            if (r17 == 0) goto L_0x0125
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0127
        L_0x0125:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0127:
            r4 = r4 | r17
            goto L_0x012c
        L_0x012a:
            r0 = r37
        L_0x012c:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r4 & r17
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x014f
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x013d
            goto L_0x014f
        L_0x013d:
            r1.skipToGroupEnd()
            r2 = r24
            r4 = r27
            r5 = r28
            r3 = r8
            r16 = r10
            r8 = r31
            r10 = r33
            goto L_0x026f
        L_0x014f:
            r1.startDefaults()
            r0 = r15 & 1
            r3 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0199
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016c
            goto L_0x0199
        L_0x016c:
            r1.skipToGroupEnd()
            r0 = r14 & 16
            if (r0 == 0) goto L_0x0175
            r4 = r4 & r20
        L_0x0175:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x017b
            r4 = r4 & r19
        L_0x017b:
            r0 = r14 & 64
            if (r0 == 0) goto L_0x0181
            r4 = r4 & r18
        L_0x0181:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0187
            r4 = r4 & r17
        L_0x0187:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x018c
            r4 = r4 & r3
        L_0x018c:
            r0 = r24
            r5 = r27
            r7 = r28
            r19 = r31
            r21 = r33
            r2 = r8
            goto L_0x01f6
        L_0x0199:
            if (r2 == 0) goto L_0x01a0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01a2
        L_0x01a0:
            r0 = r24
        L_0x01a2:
            r2 = 0
            if (r5 == 0) goto L_0x01a6
            r6 = r2
        L_0x01a6:
            if (r7 == 0) goto L_0x01a9
            goto L_0x01aa
        L_0x01a9:
            r2 = r8
        L_0x01aa:
            if (r9 == 0) goto L_0x01ae
            r5 = 0
            goto L_0x01b0
        L_0x01ae:
            r5 = r27
        L_0x01b0:
            r7 = r14 & 16
            r8 = 6
            if (r7 == 0) goto L_0x01be
            androidx.compose.material3.SnackbarDefaults r7 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r7 = r7.getShape(r1, r8)
            r4 = r4 & r20
            goto L_0x01c0
        L_0x01be:
            r7 = r28
        L_0x01c0:
            r9 = r14 & 32
            if (r9 == 0) goto L_0x01cc
            androidx.compose.material3.SnackbarDefaults r9 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r12 = r9.getColor(r1, r8)
            r4 = r4 & r19
        L_0x01cc:
            r9 = r14 & 64
            if (r9 == 0) goto L_0x01d9
            androidx.compose.material3.SnackbarDefaults r9 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r19 = r9.getContentColor(r1, r8)
            r4 = r4 & r18
            goto L_0x01db
        L_0x01d9:
            r19 = r31
        L_0x01db:
            r9 = r14 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x01e8
            androidx.compose.material3.SnackbarDefaults r9 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r21 = r9.getActionContentColor(r1, r8)
            r4 = r4 & r17
            goto L_0x01ea
        L_0x01e8:
            r21 = r33
        L_0x01ea:
            r9 = r14 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x01f6
            androidx.compose.material3.SnackbarDefaults r9 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r8 = r9.getDismissActionContentColor(r1, r8)
            r4 = r4 & r3
            r10 = r8
        L_0x01f6:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0208
            r3 = -1
            java.lang.String r8 = "androidx.compose.material3.Snackbar (Snackbar.kt:107)"
            r9 = -1235788955(0xffffffffb6575b65, float:-3.2090695E-6)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r4, r3, r8)
        L_0x0208:
            androidx.compose.material3.tokens.SnackbarTokens r3 = androidx.compose.material3.tokens.SnackbarTokens.INSTANCE
            float r3 = r3.m3142getContainerElevationD9Ej5fM()
            androidx.compose.material3.SnackbarKt$Snackbar$1 r8 = new androidx.compose.material3.SnackbarKt$Snackbar$1
            r24 = r8
            r25 = r6
            r26 = r37
            r27 = r2
            r28 = r21
            r30 = r10
            r32 = r5
            r24.<init>(r25, r26, r27, r28, r30, r32)
            r9 = -1829663446(0xffffffff92f18d2a, float:-1.5244038E-27)
            r38 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r9, r2, r8)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r8 = r4 & 14
            r9 = 12779520(0xc30000, float:1.7907922E-38)
            r8 = r8 | r9
            int r4 = r4 >> 9
            r9 = r4 & 112(0x70, float:1.57E-43)
            r8 = r8 | r9
            r9 = r4 & 896(0x380, float:1.256E-42)
            r8 = r8 | r9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r8
            r8 = 80
            r9 = 0
            r16 = 0
            r24 = r0
            r25 = r7
            r26 = r12
            r28 = r19
            r30 = r9
            r31 = r3
            r32 = r16
            r33 = r2
            r34 = r1
            r35 = r4
            r36 = r8
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r24, r25, r26, r28, r30, r31, r32, r33, r34, r35, r36)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0264
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0264:
            r3 = r38
            r2 = r0
            r4 = r5
            r5 = r7
            r16 = r10
            r8 = r19
            r10 = r21
        L_0x026f:
            androidx.compose.runtime.ScopeUpdateScope r7 = r1.endRestartGroup()
            if (r7 == 0) goto L_0x0292
            androidx.compose.material3.SnackbarKt$Snackbar$2 r18 = new androidx.compose.material3.SnackbarKt$Snackbar$2
            r0 = r18
            r1 = r2
            r2 = r6
            r23 = r7
            r6 = r12
            r12 = r16
            r14 = r37
            r15 = r39
            r16 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r12, r14, r15, r16)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r23
            r1.updateScope(r0)
        L_0x0292:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m2218SnackbareQBnUkQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0103  */
    /* renamed from: Snackbar-sDKtq54  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2219SnackbarsDKtq54(androidx.compose.material3.SnackbarData r38, androidx.compose.ui.Modifier r39, boolean r40, androidx.compose.ui.graphics.Shape r41, long r42, long r44, long r46, long r48, long r50, androidx.compose.runtime.Composer r52, int r53, int r54) {
        /*
            r1 = r38
            r15 = r53
            r13 = r54
            r0 = 274621471(0x105e641f, float:4.385891E-29)
            r2 = r52
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)203@9555L5,204@9607L5,205@9657L12,206@9713L11,207@9775L18,208@9851L25,238@10864L456:Snackbar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r15 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r15 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r15
            goto L_0x002b
        L_0x002a:
            r3 = r15
        L_0x002b:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r15 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r39
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
            r5 = r39
        L_0x0047:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r15 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0061
            r7 = r40
            boolean r8 = r2.changed((boolean) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r40
        L_0x0063:
            r8 = r15 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r13 & 8
            if (r8 != 0) goto L_0x0076
            r8 = r41
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r8 = r41
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r9
            goto L_0x007e
        L_0x007c:
            r8 = r41
        L_0x007e:
            r9 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0097
            r9 = r13 & 16
            if (r9 != 0) goto L_0x0091
            r9 = r42
            boolean r11 = r2.changed((long) r9)
            if (r11 == 0) goto L_0x0093
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r9 = r42
        L_0x0093:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r11
            goto L_0x0099
        L_0x0097:
            r9 = r42
        L_0x0099:
            r11 = 196608(0x30000, float:2.75506E-40)
            r11 = r11 & r15
            if (r11 != 0) goto L_0x00b3
            r11 = r13 & 32
            if (r11 != 0) goto L_0x00ad
            r11 = r44
            boolean r14 = r2.changed((long) r11)
            if (r14 == 0) goto L_0x00af
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00ad:
            r11 = r44
        L_0x00af:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r14
            goto L_0x00b5
        L_0x00b3:
            r11 = r44
        L_0x00b5:
            r14 = 1572864(0x180000, float:2.204052E-39)
            r14 = r14 & r15
            if (r14 != 0) goto L_0x00ce
            r14 = r13 & 64
            r0 = r46
            if (r14 != 0) goto L_0x00c9
            boolean r16 = r2.changed((long) r0)
            if (r16 == 0) goto L_0x00c9
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cb
        L_0x00c9:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cb:
            r3 = r3 | r16
            goto L_0x00d0
        L_0x00ce:
            r0 = r46
        L_0x00d0:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00e9
            r14 = r13 & 128(0x80, float:1.794E-43)
            r0 = r48
            if (r14 != 0) goto L_0x00e5
            boolean r14 = r2.changed((long) r0)
            if (r14 == 0) goto L_0x00e5
            r14 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e7
        L_0x00e5:
            r14 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e7:
            r3 = r3 | r14
            goto L_0x00eb
        L_0x00e9:
            r0 = r48
        L_0x00eb:
            r14 = 100663296(0x6000000, float:2.4074124E-35)
            r14 = r14 & r15
            if (r14 != 0) goto L_0x0103
            r14 = r13 & 256(0x100, float:3.59E-43)
            r0 = r50
            if (r14 != 0) goto L_0x00ff
            boolean r14 = r2.changed((long) r0)
            if (r14 == 0) goto L_0x00ff
            r14 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0101
        L_0x00ff:
            r14 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0101:
            r3 = r3 | r14
            goto L_0x0105
        L_0x0103:
            r0 = r50
        L_0x0105:
            r14 = 38347923(0x2492493, float:1.4777644E-37)
            r14 = r14 & r3
            r0 = 38347922(0x2492492, float:1.4777643E-37)
            if (r14 != r0) goto L_0x0126
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0115
            goto L_0x0126
        L_0x0115:
            r2.skipToGroupEnd()
            r14 = r38
            r33 = r48
            r35 = r50
            r3 = r7
            r4 = r8
            r7 = r9
            r9 = r11
            r11 = r46
            goto L_0x0293
        L_0x0126:
            r2.startDefaults()
            r0 = r15 & 1
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r14 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0175
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0143
            goto L_0x0175
        L_0x0143:
            r2.skipToGroupEnd()
            r0 = r13 & 8
            if (r0 == 0) goto L_0x014c
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014c:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0152
            r3 = r3 & r18
        L_0x0152:
            r0 = r13 & 32
            if (r0 == 0) goto L_0x0158
            r3 = r3 & r17
        L_0x0158:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x015e
            r3 = r3 & r16
        L_0x015e:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0163
            r3 = r3 & r14
        L_0x0163:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0168
            r3 = r3 & r1
        L_0x0168:
            r33 = r48
            r35 = r50
            r0 = r5
            r4 = r7
            r5 = r8
            r7 = r9
            r9 = r11
            r11 = r46
            goto L_0x01e3
        L_0x0175:
            if (r4 == 0) goto L_0x017c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x017d
        L_0x017c:
            r0 = r5
        L_0x017d:
            if (r6 == 0) goto L_0x0181
            r4 = 0
            goto L_0x0182
        L_0x0181:
            r4 = r7
        L_0x0182:
            r5 = r13 & 8
            r6 = 6
            if (r5 == 0) goto L_0x0190
            androidx.compose.material3.SnackbarDefaults r5 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getShape(r2, r6)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0191
        L_0x0190:
            r5 = r8
        L_0x0191:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x019e
            androidx.compose.material3.SnackbarDefaults r7 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r7 = r7.getColor(r2, r6)
            r3 = r3 & r18
            goto L_0x019f
        L_0x019e:
            r7 = r9
        L_0x019f:
            r9 = r13 & 32
            if (r9 == 0) goto L_0x01ac
            androidx.compose.material3.SnackbarDefaults r9 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r9 = r9.getContentColor(r2, r6)
            r3 = r3 & r17
            goto L_0x01ad
        L_0x01ac:
            r9 = r11
        L_0x01ad:
            r11 = r13 & 64
            if (r11 == 0) goto L_0x01ba
            androidx.compose.material3.SnackbarDefaults r11 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r11 = r11.getActionColor(r2, r6)
            r3 = r3 & r16
            goto L_0x01bc
        L_0x01ba:
            r11 = r46
        L_0x01bc:
            r1 = r13 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01ca
            androidx.compose.material3.SnackbarDefaults r1 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r17 = r1.getActionContentColor(r2, r6)
            r1 = r3 & r14
            r3 = r1
            goto L_0x01cc
        L_0x01ca:
            r17 = r48
        L_0x01cc:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01df
            androidx.compose.material3.SnackbarDefaults r1 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r19 = r1.getDismissActionContentColor(r2, r6)
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = r3 & r1
            r33 = r17
            r35 = r19
            goto L_0x01e3
        L_0x01df:
            r35 = r50
            r33 = r17
        L_0x01e3:
            r2.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01f5
            r1 = -1
            java.lang.String r6 = "androidx.compose.material3.Snackbar (Snackbar.kt:209)"
            r14 = 274621471(0x105e641f, float:4.385891E-29)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r3, r1, r6)
        L_0x01f5:
            androidx.compose.material3.SnackbarVisuals r1 = r38.getVisuals()
            java.lang.String r1 = r1.getActionLabel()
            if (r1 == 0) goto L_0x0215
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1 r6 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
            r14 = r38
            r6.<init>(r11, r14, r1)
            r1 = -1378313599(0xffffffffadd89a81, float:-2.462497E-11)
            r41 = r11
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r1, r11, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r17 = r1
            goto L_0x021c
        L_0x0215:
            r14 = r38
            r41 = r11
            r11 = 1
            r17 = 0
        L_0x021c:
            androidx.compose.material3.SnackbarVisuals r1 = r38.getVisuals()
            boolean r1 = r1.getWithDismissAction()
            if (r1 == 0) goto L_0x0237
            androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1 r1 = new androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
            r1.<init>(r14)
            r6 = -1812633777(0xffffffff93f5674f, float:-6.1948565E-27)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r6, r11, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r18 = r1
            goto L_0x0239
        L_0x0237:
            r18 = 0
        L_0x0239:
            r1 = 12
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.PaddingKt.m670padding3ABfNKs(r0, r1)
            androidx.compose.material3.SnackbarKt$Snackbar$3 r1 = new androidx.compose.material3.SnackbarKt$Snackbar$3
            r1.<init>(r14)
            r6 = -1266389126(0xffffffffb4846f7a, float:-2.4668026E-7)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r6, r11, r1)
            r29 = r1
            kotlin.jvm.functions.Function2 r29 = (kotlin.jvm.functions.Function2) r29
            int r1 = r3 << 3
            r6 = r1 & 7168(0x1c00, float:1.0045E-41)
            r11 = 805306368(0x30000000, float:4.656613E-10)
            r6 = r6 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r1
            r6 = r6 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r1
            r6 = r6 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r11
            r1 = r1 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r3
            r1 = r1 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r6
            r31 = r1 | r3
            r32 = 0
            r19 = r4
            r20 = r5
            r21 = r7
            r23 = r9
            r25 = r33
            r27 = r35
            r30 = r2
            m2218SnackbareQBnUkQ(r16, r17, r18, r19, r20, r21, r23, r25, r27, r29, r30, r31, r32)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x028e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x028e:
            r11 = r41
            r3 = r4
            r4 = r5
            r5 = r0
        L_0x0293:
            androidx.compose.runtime.ScopeUpdateScope r6 = r2.endRestartGroup()
            if (r6 == 0) goto L_0x02ba
            androidx.compose.material3.SnackbarKt$Snackbar$4 r17 = new androidx.compose.material3.SnackbarKt$Snackbar$4
            r0 = r17
            r1 = r38
            r2 = r5
            r14 = r6
            r5 = r7
            r7 = r9
            r9 = r11
            r11 = r33
            r37 = r14
            r13 = r35
            r15 = r53
            r16 = r54
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r13, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r37
            r1.updateScope(r0)
        L_0x02ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m2219SnackbarsDKtq54(androidx.compose.material3.SnackbarData, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m2216NewLineButtonSnackbarkKq0p4A(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j, long j2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        TextStyle textStyle2 = textStyle;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1332496681);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)261@11595L1173:Snackbar.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function24) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle2) ? 2048 : 1024;
        }
        long j3 = j;
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 16384 : 8192;
        }
        long j4 = j2;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:260)");
            }
            Modifier r0 = PaddingKt.m674paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m749widthInVpY3zN4$default(Modifier.Companion, 0.0f, ContainerMaxWidth, 1, (Object) null), 0.0f, 1, (Object) null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r0);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r9 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r9, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r9, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r9.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -916592009, "C271@11902L171,276@12083L679:Snackbar.kt#uh7d8r");
            Modifier r21 = AlignmentLineKt.m509paddingFromBaselineVpY3zN4(Modifier.Companion, HeightToFirstLine, LongButtonVerticalOffset);
            float f = HorizontalSpacingButtonSide;
            Modifier r92 = PaddingKt.m674paddingqDBjuR0$default(r21, 0.0f, 0.0f, f, 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            float f2 = f;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(r92);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r10 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r10, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r10, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r10.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 302366651, "C274@12065L6:Snackbar.kt#uh7d8r");
            function24.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier r7 = PaddingKt.m674paddingqDBjuR0$default(columnScope.align(Modifier.Companion, Alignment.Companion.getEnd()), 0.0f, 0.0f, function26 == null ? f2 : Dp.m6614constructorimpl((float) 0), 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(r7);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 302366837, "C280@12251L501:Snackbar.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer r102 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r102, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r102, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r102.getInserting() || !Intrinsics.areEqual(r102.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                r102.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                r102.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 435596204, "C281@12273L208:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle2)}, function25, startRestartGroup, i2 & 112);
            startRestartGroup.startReplaceableGroup(302367084);
            ComposerKt.sourceInformation(startRestartGroup, "287@12547L173");
            if (function26 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j2)), function26, startRestartGroup, ((i2 >> 3) & 112) | ProvidedValue.$stable);
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$NewLineButtonSnackbar$2(function2, function22, function23, textStyle, j, j2, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m2217OneRowSnackbarkKq0p4A(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j, long j2, Composer composer, int i) {
        int i2;
        float f;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        TextStyle textStyle2 = textStyle;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation(startRestartGroup, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)334@14108L3465,309@13126L4447:Snackbar.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function24) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle2) ? 2048 : 1024;
        }
        long j3 = j;
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 16384 : 8192;
        }
        long j4 = j2;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:305)");
            }
            Modifier modifier = Modifier.Companion;
            float f2 = HorizontalSpacing;
            if (function26 == null) {
                f = HorizontalSpacingButtonSide;
            } else {
                f = Dp.m6614constructorimpl((float) 0);
            }
            Modifier r8 = PaddingKt.m674paddingqDBjuR0$default(modifier, f2, 0.0f, f, 0.0f, 10, (Object) null);
            startRestartGroup.startReplaceableGroup(44739392);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Snackbar.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarKt$OneRowSnackbar$2$1("action", "dismissAction", "text");
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(r8);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r12 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r12, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r12, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r12.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -167734359, "C311@13156L86:Snackbar.kt#uh7d8r");
            Modifier r7 = PaddingKt.m672paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), 0.0f, SnackbarVerticalPadding, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(r7);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r82 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r82, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r82, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r82.getInserting() || !Intrinsics.areEqual(r82.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r82.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r82.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288408, "C311@13234L6:Snackbar.kt#uh7d8r");
            function24.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-167734260);
            ComposerKt.sourceInformation(startRestartGroup, "313@13293L295");
            if (function25 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "action");
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
                Composer r72 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r72, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r72, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r72.getInserting() || !Intrinsics.areEqual(r72.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r72.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r72.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288523, "C314@13349L221:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle2)}, function25, startRestartGroup, i2 & 112);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(44738899);
            ComposerKt.sourceInformation(startRestartGroup, "322@13660L247");
            if (function26 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, "dismissAction");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(layoutId2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r11 = Updater.m3282constructorimpl(startRestartGroup);
                Updater.m3289setimpl(r11, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3289setimpl(r11, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r11.getInserting() || !Intrinsics.areEqual(r11.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                    r11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    r11.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                modifierMaterializerOf4.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288897, "C323@13723L166:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j2)), function26, startRestartGroup, ((i2 >> 3) & 112) | ProvidedValue.$stable);
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
            endRestartGroup.updateScope(new SnackbarKt$OneRowSnackbar$3(function2, function22, function23, textStyle, j, j2, i));
        }
    }

    static {
        float f = (float) 8;
        HorizontalSpacingButtonSide = Dp.m6614constructorimpl(f);
        TextEndExtraSpacing = Dp.m6614constructorimpl(f);
    }
}
