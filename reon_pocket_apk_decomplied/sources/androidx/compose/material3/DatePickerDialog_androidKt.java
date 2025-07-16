package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"DialogButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DialogButtonsMainAxisSpacing", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePickerDialog.android.kt */
public final class DatePickerDialog_androidKt {
    /* access modifiers changed from: private */
    public static final float DialogButtonsCrossAxisSpacing = Dp.m6614constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float DialogButtonsMainAxisSpacing;
    /* access modifiers changed from: private */
    public static final PaddingValues DialogButtonsPadding;

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fa  */
    /* renamed from: DatePickerDialog-GmEhDVc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1766DatePickerDialogGmEhDVc(kotlin.jvm.functions.Function0<kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.graphics.Shape r29, float r30, androidx.compose.material3.DatePickerColors r31, androidx.compose.ui.window.DialogProperties r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r10 = r35
            r11 = r36
            r0 = -36517340(0xfffffffffdd2ca24, float:-3.5023432E37)
            r1 = r34
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DatePickerDialog)P(5,1,4,3,7,8:c#ui.unit.Dp!1,6)68@3428L5,70@3545L8,74@3697L1472:DatePickerDialog.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r10 | 6
            r9 = r25
            goto L_0x002d
        L_0x001b:
            r1 = r10 & 6
            r9 = r25
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changedInstance(r9)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r10
            goto L_0x002d
        L_0x002c:
            r1 = r10
        L_0x002d:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r7 = r26
            goto L_0x0048
        L_0x0036:
            r2 = r10 & 48
            r7 = r26
            if (r2 != 0) goto L_0x0048
            boolean r2 = r8.changedInstance(r7)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r10 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r27
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r27
        L_0x0064:
            r4 = r11 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r10 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r28
            boolean r6 = r8.changedInstance(r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r28
        L_0x0080:
            r6 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x0099
            r6 = r11 & 16
            if (r6 != 0) goto L_0x0093
            r6 = r29
            boolean r12 = r8.changed((java.lang.Object) r6)
            if (r12 == 0) goto L_0x0095
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r6 = r29
        L_0x0095:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r12
            goto L_0x009b
        L_0x0099:
            r6 = r29
        L_0x009b:
            r12 = r11 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a3
            r1 = r1 | r13
            goto L_0x00b5
        L_0x00a3:
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00b5
            r13 = r30
            boolean r14 = r8.changed((float) r13)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r1 = r1 | r14
            goto L_0x00b7
        L_0x00b5:
            r13 = r30
        L_0x00b7:
            r14 = 1572864(0x180000, float:2.204052E-39)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00d1
            r14 = r11 & 64
            if (r14 != 0) goto L_0x00cb
            r14 = r31
            boolean r15 = r8.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cd
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cb:
            r14 = r31
        L_0x00cd:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r1 = r1 | r15
            goto L_0x00d3
        L_0x00d1:
            r14 = r31
        L_0x00d3:
            r15 = r11 & 128(0x80, float:1.794E-43)
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            if (r15 == 0) goto L_0x00de
            r1 = r1 | r16
            r0 = r32
            goto L_0x00f1
        L_0x00de:
            r16 = r10 & r16
            r0 = r32
            if (r16 != 0) goto L_0x00f1
            boolean r17 = r8.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00ed
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ed:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r17
        L_0x00f1:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fa
            r1 = r1 | r17
            goto L_0x010e
        L_0x00fa:
            r0 = r10 & r17
            if (r0 != 0) goto L_0x010e
            r0 = r33
            boolean r17 = r8.changedInstance(r0)
            if (r17 == 0) goto L_0x0109
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010b
        L_0x0109:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010b:
            r1 = r1 | r17
            goto L_0x0110
        L_0x010e:
            r0 = r33
        L_0x0110:
            r17 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r1 & r17
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x012e
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0121
            goto L_0x012e
        L_0x0121:
            r8.skipToGroupEnd()
            r3 = r27
            r23 = r32
            r4 = r5
            r5 = r6
            r6 = r13
            r7 = r14
            goto L_0x0205
        L_0x012e:
            r8.startDefaults()
            r0 = r10 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = 0
            if (r0 == 0) goto L_0x015e
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0140
            goto L_0x015e
        L_0x0140:
            r8.skipToGroupEnd()
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0149
            r1 = r1 & r17
        L_0x0149:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0151
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r0
        L_0x0151:
            r0 = r27
        L_0x0153:
            r23 = r32
        L_0x0155:
            r19 = r5
            r20 = r6
            r21 = r13
            r22 = r14
            goto L_0x01aa
        L_0x015e:
            if (r2 == 0) goto L_0x0165
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0167
        L_0x0165:
            r0 = r27
        L_0x0167:
            if (r4 == 0) goto L_0x016a
            r5 = r3
        L_0x016a:
            r2 = r11 & 16
            r4 = 6
            if (r2 == 0) goto L_0x0178
            androidx.compose.material3.DatePickerDefaults r2 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r8, r4)
            r1 = r1 & r17
            r6 = r2
        L_0x0178:
            if (r12 == 0) goto L_0x0181
            androidx.compose.material3.DatePickerDefaults r2 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            float r2 = r2.m1765getTonalElevationD9Ej5fM()
            r13 = r2
        L_0x0181:
            r2 = r11 & 64
            if (r2 == 0) goto L_0x0190
            androidx.compose.material3.DatePickerDefaults r2 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            androidx.compose.material3.DatePickerColors r2 = r2.colors(r8, r4)
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r4
            r14 = r2
        L_0x0190:
            if (r15 == 0) goto L_0x0153
            androidx.compose.ui.window.DialogProperties r2 = new androidx.compose.ui.window.DialogProperties
            r23 = 23
            r24 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r17 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r23 = r2
            goto L_0x0155
        L_0x01aa:
            r8.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01bc
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:73)"
            r5 = -36517340(0xfffffffffdd2ca24, float:-3.5023432E37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r1, r2, r4)
        L_0x01bc:
            r2 = 0
            r4 = 3
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r0, r3, r2, r4, r3)
            androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1 r3 = new androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
            r12 = r3
            r13 = r20
            r14 = r22
            r15 = r21
            r16 = r33
            r17 = r19
            r18 = r26
            r12.<init>(r13, r14, r15, r16, r17, r18)
            r4 = -10625622(0xffffffffff5dddaa, float:-2.9491033E38)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r4, r5, r3)
            r4 = r3
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3 = r1 & 14
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            int r1 = r1 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r6 = r3 | r1
            r12 = 0
            r1 = r25
            r3 = r23
            r5 = r8
            r7 = r12
            androidx.compose.material3.AndroidAlertDialog_androidKt.BasicAlertDialog(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01fc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01fc:
            r3 = r0
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
        L_0x0205:
            androidx.compose.runtime.ScopeUpdateScope r12 = r8.endRestartGroup()
            if (r12 == 0) goto L_0x0222
            androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$2 r13 = new androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$2
            r0 = r13
            r1 = r25
            r2 = r26
            r8 = r23
            r9 = r33
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0222:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDialog_androidKt.m1766DatePickerDialogGmEhDVc(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, float, androidx.compose.material3.DatePickerColors, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 8;
        DialogButtonsPadding = PaddingKt.m667PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m6614constructorimpl((float) 6), Dp.m6614constructorimpl(f), 3, (Object) null);
        DialogButtonsMainAxisSpacing = Dp.m6614constructorimpl(f);
    }
}
