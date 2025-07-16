package androidx.compose.material3;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a0\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a0\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a0\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "HorizontalDivider", "HorizontalDivider-9IZ8Weo", "VerticalDivider", "VerticalDivider-9IZ8Weo", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Divider.kt */
public final class DividerKt {
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0078, code lost:
        if ((r14 & 4) != 0) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fe  */
    /* renamed from: HorizontalDivider-9IZ8Weo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1817HorizontalDivider9IZ8Weo(androidx.compose.ui.Modifier r8, float r9, long r10, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 75144485(0x47a9d25, float:2.9459516E-36)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(HorizontalDivider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)50@2061L5,51@2122L192,51@2072L242:Divider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r2 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x0022
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r2 = r2 | r13
            goto L_0x0023
        L_0x0022:
            r2 = r13
        L_0x0023:
            r3 = r14 & 2
            r4 = 32
            if (r3 == 0) goto L_0x002c
            r2 = r2 | 48
            goto L_0x003b
        L_0x002c:
            r5 = r13 & 48
            if (r5 != 0) goto L_0x003b
            boolean r5 = r12.changed((float) r9)
            if (r5 == 0) goto L_0x0038
            r5 = r4
            goto L_0x003a
        L_0x0038:
            r5 = 16
        L_0x003a:
            r2 = r2 | r5
        L_0x003b:
            r5 = r13 & 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x0050
            r5 = r14 & 4
            if (r5 != 0) goto L_0x004d
            boolean r5 = r12.changed((long) r10)
            if (r5 == 0) goto L_0x004d
            r5 = r6
            goto L_0x004f
        L_0x004d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x004f:
            r2 = r2 | r5
        L_0x0050:
            r5 = r2 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r5 != r7) goto L_0x0065
            boolean r5 = r12.getSkipping()
            if (r5 != 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            r12.skipToGroupEnd()
        L_0x0060:
            r2 = r8
            r3 = r9
            r4 = r10
            goto L_0x0103
        L_0x0065:
            r12.startDefaults()
            r5 = r13 & 1
            if (r5 == 0) goto L_0x007d
            boolean r5 = r12.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0073
            goto L_0x007d
        L_0x0073:
            r12.skipToGroupEnd()
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0097
        L_0x007a:
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0097
        L_0x007d:
            if (r1 == 0) goto L_0x0083
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x0083:
            if (r3 == 0) goto L_0x008b
            androidx.compose.material3.DividerDefaults r9 = androidx.compose.material3.DividerDefaults.INSTANCE
            float r9 = r9.m1815getThicknessD9Ej5fM()
        L_0x008b:
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0097
            androidx.compose.material3.DividerDefaults r10 = androidx.compose.material3.DividerDefaults.INSTANCE
            r11 = 6
            long r10 = r10.getColor(r12, r11)
            goto L_0x007a
        L_0x0097:
            r12.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a6
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.HorizontalDivider (Divider.kt:51)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r3)
        L_0x00a6:
            r0 = 0
            r1 = 0
            r3 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r8, r0, r3, r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r0, r9)
            r1 = 941664184(0x3820a7b8, float:3.8303173E-5)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Divider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r2 & 112(0x70, float:1.57E-43)
            r5 = 0
            if (r1 != r4) goto L_0x00c3
            r1 = r3
            goto L_0x00c4
        L_0x00c3:
            r1 = r5
        L_0x00c4:
            r4 = r2 & 896(0x380, float:1.256E-42)
            r4 = r4 ^ 384(0x180, float:5.38E-43)
            if (r4 <= r6) goto L_0x00d0
            boolean r4 = r12.changed((long) r10)
            if (r4 != 0) goto L_0x00d6
        L_0x00d0:
            r2 = r2 & 384(0x180, float:5.38E-43)
            if (r2 != r6) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r3 = r5
        L_0x00d6:
            r1 = r1 | r3
            java.lang.Object r2 = r12.rememberedValue()
            if (r1 != 0) goto L_0x00e5
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00f0
        L_0x00e5:
            androidx.compose.material3.DividerKt$HorizontalDivider$1$1 r1 = new androidx.compose.material3.DividerKt$HorizontalDivider$1$1
            r1.<init>(r9, r10)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.updateRememberedValue(r2)
        L_0x00f0:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.endReplaceableGroup()
            androidx.compose.foundation.CanvasKt.Canvas(r0, r2, r12, r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0060
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0060
        L_0x0103:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 == 0) goto L_0x0116
            androidx.compose.material3.DividerKt$HorizontalDivider$2 r9 = new androidx.compose.material3.DividerKt$HorizontalDivider$2
            r1 = r9
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m1817HorizontalDivider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0078, code lost:
        if ((r14 & 4) != 0) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fe  */
    /* renamed from: VerticalDivider-9IZ8Weo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1818VerticalDivider9IZ8Weo(androidx.compose.ui.Modifier r8, float r9, long r10, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = -1534852205(0xffffffffa4840393, float:-5.725193E-17)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(VerticalDivider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)76@3041L5,77@3102L193,77@3052L243:Divider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r2 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x0022
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r2 = r2 | r13
            goto L_0x0023
        L_0x0022:
            r2 = r13
        L_0x0023:
            r3 = r14 & 2
            r4 = 32
            if (r3 == 0) goto L_0x002c
            r2 = r2 | 48
            goto L_0x003b
        L_0x002c:
            r5 = r13 & 48
            if (r5 != 0) goto L_0x003b
            boolean r5 = r12.changed((float) r9)
            if (r5 == 0) goto L_0x0038
            r5 = r4
            goto L_0x003a
        L_0x0038:
            r5 = 16
        L_0x003a:
            r2 = r2 | r5
        L_0x003b:
            r5 = r13 & 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x0050
            r5 = r14 & 4
            if (r5 != 0) goto L_0x004d
            boolean r5 = r12.changed((long) r10)
            if (r5 == 0) goto L_0x004d
            r5 = r6
            goto L_0x004f
        L_0x004d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x004f:
            r2 = r2 | r5
        L_0x0050:
            r5 = r2 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r5 != r7) goto L_0x0065
            boolean r5 = r12.getSkipping()
            if (r5 != 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            r12.skipToGroupEnd()
        L_0x0060:
            r2 = r8
            r3 = r9
            r4 = r10
            goto L_0x0103
        L_0x0065:
            r12.startDefaults()
            r5 = r13 & 1
            if (r5 == 0) goto L_0x007d
            boolean r5 = r12.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0073
            goto L_0x007d
        L_0x0073:
            r12.skipToGroupEnd()
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0097
        L_0x007a:
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0097
        L_0x007d:
            if (r1 == 0) goto L_0x0083
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x0083:
            if (r3 == 0) goto L_0x008b
            androidx.compose.material3.DividerDefaults r9 = androidx.compose.material3.DividerDefaults.INSTANCE
            float r9 = r9.m1815getThicknessD9Ej5fM()
        L_0x008b:
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0097
            androidx.compose.material3.DividerDefaults r10 = androidx.compose.material3.DividerDefaults.INSTANCE
            r11 = 6
            long r10 = r10.getColor(r12, r11)
            goto L_0x007a
        L_0x0097:
            r12.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a6
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.VerticalDivider (Divider.kt:77)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r3)
        L_0x00a6:
            r0 = 0
            r1 = 0
            r3 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r8, r0, r3, r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m747width3ABfNKs(r0, r9)
            r1 = 1779728798(0x6a14819e, float:4.488328E25)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Divider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r2 & 112(0x70, float:1.57E-43)
            r5 = 0
            if (r1 != r4) goto L_0x00c3
            r1 = r3
            goto L_0x00c4
        L_0x00c3:
            r1 = r5
        L_0x00c4:
            r4 = r2 & 896(0x380, float:1.256E-42)
            r4 = r4 ^ 384(0x180, float:5.38E-43)
            if (r4 <= r6) goto L_0x00d0
            boolean r4 = r12.changed((long) r10)
            if (r4 != 0) goto L_0x00d6
        L_0x00d0:
            r2 = r2 & 384(0x180, float:5.38E-43)
            if (r2 != r6) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r3 = r5
        L_0x00d6:
            r1 = r1 | r3
            java.lang.Object r2 = r12.rememberedValue()
            if (r1 != 0) goto L_0x00e5
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00f0
        L_0x00e5:
            androidx.compose.material3.DividerKt$VerticalDivider$1$1 r1 = new androidx.compose.material3.DividerKt$VerticalDivider$1$1
            r1.<init>(r9, r10)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.updateRememberedValue(r2)
        L_0x00f0:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.endReplaceableGroup()
            androidx.compose.foundation.CanvasKt.Canvas(r0, r2, r12, r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0060
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0060
        L_0x0103:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 == 0) goto L_0x0116
            androidx.compose.material3.DividerKt$VerticalDivider$2 r9 = new androidx.compose.material3.DividerKt$VerticalDivider$2
            r1 = r9
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m1818VerticalDivider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0076, code lost:
        if ((r14 & 4) != 0) goto L_0x0078;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ff  */
    @kotlin.Deprecated(message = "Renamed to HorizontalDivider", replaceWith = @kotlin.ReplaceWith(expression = "HorizontalDivider(modifier, thickness, color)", imports = {}))
    /* renamed from: Divider-9IZ8Weo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1816Divider9IZ8Weo(androidx.compose.ui.Modifier r8, float r9, long r10, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 1562471785(0x5d216d69, float:7.270043E17)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)94@3579L5,101@3736L131:Divider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r2 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x0022
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r2 = r2 | r13
            goto L_0x0023
        L_0x0022:
            r2 = r13
        L_0x0023:
            r3 = r14 & 2
            if (r3 == 0) goto L_0x002a
            r2 = r2 | 48
            goto L_0x003a
        L_0x002a:
            r4 = r13 & 48
            if (r4 != 0) goto L_0x003a
            boolean r4 = r12.changed((float) r9)
            if (r4 == 0) goto L_0x0037
            r4 = 32
            goto L_0x0039
        L_0x0037:
            r4 = 16
        L_0x0039:
            r2 = r2 | r4
        L_0x003a:
            r4 = r13 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r14 & 4
            if (r4 != 0) goto L_0x004b
            boolean r4 = r12.changed((long) r10)
            if (r4 == 0) goto L_0x004b
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r4 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r2 = r2 | r4
        L_0x004e:
            r4 = r2 & 147(0x93, float:2.06E-43)
            r5 = 146(0x92, float:2.05E-43)
            if (r4 != r5) goto L_0x0063
            boolean r4 = r12.getSkipping()
            if (r4 != 0) goto L_0x005b
            goto L_0x0063
        L_0x005b:
            r12.skipToGroupEnd()
        L_0x005e:
            r2 = r8
            r3 = r9
            r4 = r10
            goto L_0x0104
        L_0x0063:
            r12.startDefaults()
            r4 = r13 & 1
            if (r4 == 0) goto L_0x007b
            boolean r4 = r12.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0071
            goto L_0x007b
        L_0x0071:
            r12.skipToGroupEnd()
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0095
        L_0x0078:
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0095
        L_0x007b:
            if (r1 == 0) goto L_0x0081
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x0081:
            if (r3 == 0) goto L_0x0089
            androidx.compose.material3.DividerDefaults r9 = androidx.compose.material3.DividerDefaults.INSTANCE
            float r9 = r9.m1815getThicknessD9Ej5fM()
        L_0x0089:
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0095
            androidx.compose.material3.DividerDefaults r10 = androidx.compose.material3.DividerDefaults.INSTANCE
            r11 = 6
            long r10 = r10.getColor(r12, r11)
            goto L_0x0078
        L_0x0095:
            r12.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a4
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.Divider (Divider.kt:95)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r3)
        L_0x00a4:
            r0 = 1232937226(0x497d210a, float:1036816.6)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "*97@3675L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m6632getHairlineD9Ej5fM()
            boolean r0 = androidx.compose.ui.unit.Dp.m6619equalsimpl0(r9, r0)
            if (r0 == 0) goto L_0x00de
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r2)
            java.lang.Object r0 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            float r0 = r0.getDensity()
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 / r0
            float r0 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            goto L_0x00df
        L_0x00de:
            r0 = r9
        L_0x00df:
            r12.endReplaceableGroup()
            r1 = 0
            r2 = 0
            r3 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r8, r1, r3, r2)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r1, r0)
            r5 = 2
            r6 = 0
            r4 = 0
            r2 = r10
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m214backgroundbw27NRU$default(r1, r2, r4, r5, r6)
            r1 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r0, r12, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x005e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x005e
        L_0x0104:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 == 0) goto L_0x0117
            androidx.compose.material3.DividerKt$Divider$1 r9 = new androidx.compose.material3.DividerKt$Divider$1
            r1 = r9
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m1816Divider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
