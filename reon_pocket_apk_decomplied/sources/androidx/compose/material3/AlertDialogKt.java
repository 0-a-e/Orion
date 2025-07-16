package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a¦\u0001\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"DialogMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getDialogMaxWidth", "()F", "F", "DialogMinWidth", "getDialogMinWidth", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TextPadding", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
public final class AlertDialogKt {
    private static final float DialogMaxWidth = Dp.m6614constructorimpl((float) 560);
    private static final float DialogMinWidth = Dp.m6614constructorimpl((float) 280);
    /* access modifiers changed from: private */
    public static final PaddingValues DialogPadding;
    /* access modifiers changed from: private */
    public static final PaddingValues IconPadding;
    /* access modifiers changed from: private */
    public static final PaddingValues TextPadding;
    /* access modifiers changed from: private */
    public static final PaddingValues TitlePadding;

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011f  */
    /* renamed from: AlertDialogContent-4hvqGtA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1499AlertDialogContent4hvqGtA(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.graphics.Shape r37, long r38, float r40, long r41, long r43, long r45, long r47, androidx.compose.runtime.Composer r49, int r50, int r51, int r52) {
        /*
            r14 = r50
            r15 = r52
            r0 = 1522575799(0x5ac0a9b7, float:2.71148995E16)
            r1 = r49
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AlertDialogContent)P(1,5,3,9,7,6,2:c#ui.graphics.Color,11:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,8:c#ui.graphics.Color)53@1918L2445:AlertDialog.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r14 | 6
            r12 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r14 & 6
            r12 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r13.changedInstance(r12)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r14
            goto L_0x002d
        L_0x002c:
            r1 = r14
        L_0x002d:
            r4 = r15 & 2
            r6 = 16
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0048
        L_0x0036:
            r7 = r14 & 48
            if (r7 != 0) goto L_0x0048
            r7 = r33
            boolean r8 = r13.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0045
            r8 = 32
            goto L_0x0046
        L_0x0045:
            r8 = r6
        L_0x0046:
            r1 = r1 | r8
            goto L_0x004a
        L_0x0048:
            r7 = r33
        L_0x004a:
            r8 = r15 & 4
            if (r8 == 0) goto L_0x0053
            r1 = r1 | 384(0x180, float:5.38E-43)
            r11 = r34
            goto L_0x0065
        L_0x0053:
            r8 = r14 & 384(0x180, float:5.38E-43)
            r11 = r34
            if (r8 != 0) goto L_0x0065
            boolean r8 = r13.changedInstance(r11)
            if (r8 == 0) goto L_0x0062
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r1 = r1 | r8
        L_0x0065:
            r8 = r15 & 8
            if (r8 == 0) goto L_0x006e
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r10 = r35
            goto L_0x0080
        L_0x006e:
            r8 = r14 & 3072(0xc00, float:4.305E-42)
            r10 = r35
            if (r8 != 0) goto L_0x0080
            boolean r8 = r13.changedInstance(r10)
            if (r8 == 0) goto L_0x007d
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r1 = r1 | r8
        L_0x0080:
            r8 = r15 & 16
            if (r8 == 0) goto L_0x0089
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r9 = r36
            goto L_0x009b
        L_0x0089:
            r8 = r14 & 24576(0x6000, float:3.4438E-41)
            r9 = r36
            if (r8 != 0) goto L_0x009b
            boolean r8 = r13.changedInstance(r9)
            if (r8 == 0) goto L_0x0098
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r1 = r1 | r8
        L_0x009b:
            r8 = r15 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a4
            r1 = r1 | r16
            goto L_0x00b8
        L_0x00a4:
            r8 = r14 & r16
            if (r8 != 0) goto L_0x00b8
            r8 = r37
            boolean r16 = r13.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r1 = r1 | r16
            goto L_0x00ba
        L_0x00b8:
            r8 = r37
        L_0x00ba:
            r16 = r15 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c5
            r1 = r1 | r17
            r9 = r38
            goto L_0x00d8
        L_0x00c5:
            r16 = r14 & r17
            r9 = r38
            if (r16 != 0) goto L_0x00d8
            boolean r16 = r13.changed((long) r9)
            if (r16 == 0) goto L_0x00d4
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r1 = r1 | r16
        L_0x00d8:
            r2 = r15 & 128(0x80, float:1.794E-43)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            if (r2 == 0) goto L_0x00e1
            r1 = r1 | r29
            goto L_0x00f5
        L_0x00e1:
            r2 = r14 & r29
            if (r2 != 0) goto L_0x00f5
            r2 = r40
            boolean r16 = r13.changed((float) r2)
            if (r16 == 0) goto L_0x00f0
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r1 = r1 | r16
            goto L_0x00f7
        L_0x00f5:
            r2 = r40
        L_0x00f7:
            r3 = r15 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x0102
            r1 = r1 | r17
            r9 = r41
            goto L_0x0114
        L_0x0102:
            r3 = r14 & r17
            r9 = r41
            if (r3 != 0) goto L_0x0114
            boolean r3 = r13.changed((long) r9)
            if (r3 == 0) goto L_0x0111
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r3 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r1 = r1 | r3
        L_0x0114:
            r3 = r15 & 512(0x200, float:7.175E-43)
            r17 = 805306368(0x30000000, float:4.656613E-10)
            if (r3 == 0) goto L_0x011f
            r1 = r1 | r17
            r9 = r43
            goto L_0x0131
        L_0x011f:
            r3 = r14 & r17
            r9 = r43
            if (r3 != 0) goto L_0x0131
            boolean r3 = r13.changed((long) r9)
            if (r3 == 0) goto L_0x012e
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0130
        L_0x012e:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0130:
            r1 = r1 | r3
        L_0x0131:
            r3 = r15 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x013a
            r3 = r51 | 6
            r9 = r45
            goto L_0x0150
        L_0x013a:
            r3 = r51 & 6
            r9 = r45
            if (r3 != 0) goto L_0x014e
            boolean r3 = r13.changed((long) r9)
            if (r3 == 0) goto L_0x0149
            r16 = 4
            goto L_0x014b
        L_0x0149:
            r16 = 2
        L_0x014b:
            r3 = r51 | r16
            goto L_0x0150
        L_0x014e:
            r3 = r51
        L_0x0150:
            r5 = r15 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0159
            r3 = r3 | 48
            r9 = r47
            goto L_0x016a
        L_0x0159:
            r5 = r51 & 48
            r9 = r47
            if (r5 != 0) goto L_0x016a
            boolean r5 = r13.changed((long) r9)
            if (r5 == 0) goto L_0x0168
            r5 = 32
            goto L_0x0169
        L_0x0168:
            r5 = r6
        L_0x0169:
            r3 = r3 | r5
        L_0x016a:
            r5 = 306783379(0x12492493, float:6.34695E-28)
            r5 = r5 & r1
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r6) goto L_0x0187
            r5 = r3 & 19
            r6 = 18
            if (r5 != r6) goto L_0x0187
            boolean r5 = r13.getSkipping()
            if (r5 != 0) goto L_0x0180
            goto L_0x0187
        L_0x0180:
            r13.skipToGroupEnd()
            r2 = r7
            r0 = r13
            goto L_0x01fd
        L_0x0187:
            if (r4 == 0) goto L_0x0190
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r30 = r4
            goto L_0x0192
        L_0x0190:
            r30 = r7
        L_0x0192:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x019d
            java.lang.String r4 = "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:52)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r4)
        L_0x019d:
            androidx.compose.material3.AlertDialogKt$AlertDialogContent$1 r0 = new androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
            r16 = r0
            r17 = r34
            r18 = r35
            r19 = r36
            r20 = r43
            r22 = r45
            r24 = r47
            r26 = r41
            r28 = r32
            r16.<init>(r17, r18, r19, r20, r22, r24, r26, r28)
            r3 = -2126308228(0xffffffff81431c7c, float:-3.583628E-38)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r3, r4, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r3 = r1 >> 3
            r3 = r3 & 14
            r3 = r3 | r29
            int r4 = r1 >> 12
            r5 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r5
            r4 = r4 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            int r1 = r1 >> 9
            r4 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r16 = r3 | r1
            r17 = 104(0x68, float:1.46E-43)
            r5 = 0
            r18 = 0
            r19 = 0
            r1 = r30
            r2 = r37
            r3 = r38
            r7 = r40
            r8 = r18
            r9 = r19
            r10 = r0
            r11 = r13
            r12 = r16
            r0 = r13
            r13 = r17
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01fb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01fb:
            r2 = r30
        L_0x01fd:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 == 0) goto L_0x0231
            androidx.compose.material3.AlertDialogKt$AlertDialogContent$2 r21 = new androidx.compose.material3.AlertDialogKt$AlertDialogContent$2
            r0 = r21
            r1 = r32
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            r7 = r38
            r9 = r40
            r10 = r41
            r31 = r12
            r12 = r43
            r14 = r45
            r16 = r47
            r18 = r50
            r19 = r51
            r20 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r14, r16, r18, r19, r20)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r31
            r1.updateScope(r0)
        L_0x0231:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.m1499AlertDialogContent4hvqGtA(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, float, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8  reason: not valid java name */
    public static final void m1500AlertDialogFlowRowixp7dh8(float f, float f2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(586821353);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)130@4637L3306,130@4621L3322:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, i2, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:129)");
            }
            startRestartGroup.startReplaceableGroup(-1133133582);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AlertDialog.kt#9igjgp");
            boolean z = true;
            boolean z2 = (i2 & 14) == 4;
            if ((i2 & 112) != 32) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AlertDialogKt$AlertDialogFlowRow$1$1(f, f2);
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
            int i3 = ((((i2 >> 6) & 14) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r6, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
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
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogFlowRow$2(f, f2, function2, i));
        }
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    static {
        float f = (float) 24;
        DialogPadding = PaddingKt.m663PaddingValues0680j_4(Dp.m6614constructorimpl(f));
        float f2 = (float) 16;
        IconPadding = PaddingKt.m667PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6614constructorimpl(f2), 7, (Object) null);
        TitlePadding = PaddingKt.m667PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6614constructorimpl(f2), 7, (Object) null);
        TextPadding = PaddingKt.m667PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6614constructorimpl(f), 7, (Object) null);
    }
}
