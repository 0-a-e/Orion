package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"DefaultRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "TextSelectionBackgroundOpacity", "", "MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MaterialTheme.kt */
public final class MaterialThemeKt {
    /* access modifiers changed from: private */
    public static final RippleAlpha DefaultRippleAlpha = new RippleAlpha(0.16f, 0.12f, 0.08f, 0.12f);
    public static final float TextSelectionBackgroundOpacity = 0.4f;

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00af, code lost:
        if ((r24 & 4) != 0) goto L_0x00d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MaterialTheme(androidx.compose.material3.ColorScheme r18, androidx.compose.material3.Shapes r19, androidx.compose.material3.Typography r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r4 = r21
            r5 = r23
            r0 = -2127166334(0xffffffff81360482, float:-3.3431355E-38)
            r1 = r22
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(MaterialTheme)P(!1,2,3)56@2691L11,57@2739L6,58@2790L10,61@2902L16,62@2945L40,63@2990L440:MaterialTheme.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r5 & 6
            r3 = 4
            r13 = 2
            if (r2 != 0) goto L_0x002b
            r2 = r24 & 1
            if (r2 != 0) goto L_0x0026
            r2 = r18
            boolean r6 = r1.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x0028
            r6 = r3
            goto L_0x0029
        L_0x0026:
            r2 = r18
        L_0x0028:
            r6 = r13
        L_0x0029:
            r6 = r6 | r5
            goto L_0x002e
        L_0x002b:
            r2 = r18
            r6 = r5
        L_0x002e:
            r7 = r5 & 48
            if (r7 != 0) goto L_0x0047
            r7 = r24 & 2
            if (r7 != 0) goto L_0x0041
            r7 = r19
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0043
            r8 = 32
            goto L_0x0045
        L_0x0041:
            r7 = r19
        L_0x0043:
            r8 = 16
        L_0x0045:
            r6 = r6 | r8
            goto L_0x0049
        L_0x0047:
            r7 = r19
        L_0x0049:
            r8 = r5 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0062
            r8 = r24 & 4
            if (r8 != 0) goto L_0x005c
            r8 = r20
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005e
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r8 = r20
        L_0x005e:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r6 = r6 | r9
            goto L_0x0064
        L_0x0062:
            r8 = r20
        L_0x0064:
            r9 = r24 & 8
            if (r9 == 0) goto L_0x006b
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x006b:
            r9 = r5 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007b
            boolean r9 = r1.changedInstance(r4)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r6 = r6 | r9
        L_0x007b:
            r9 = r6 & 1171(0x493, float:1.641E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r9 != r10) goto L_0x008f
            boolean r9 = r1.getSkipping()
            if (r9 != 0) goto L_0x0088
            goto L_0x008f
        L_0x0088:
            r1.skipToGroupEnd()
            r15 = r7
            r3 = r8
            goto L_0x0161
        L_0x008f:
            r1.startDefaults()
            r9 = r5 & 1
            r14 = 6
            if (r9 == 0) goto L_0x00b2
            boolean r9 = r1.getDefaultsInvalid()
            if (r9 == 0) goto L_0x009e
            goto L_0x00b2
        L_0x009e:
            r1.skipToGroupEnd()
            r9 = r24 & 1
            if (r9 == 0) goto L_0x00a7
            r6 = r6 & -15
        L_0x00a7:
            r9 = r24 & 2
            if (r9 == 0) goto L_0x00ad
            r6 = r6 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ad:
            r9 = r24 & 4
            if (r9 == 0) goto L_0x00d6
            goto L_0x00d4
        L_0x00b2:
            r9 = r24 & 1
            if (r9 == 0) goto L_0x00be
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r1, r14)
            r6 = r6 & -15
        L_0x00be:
            r9 = r24 & 2
            if (r9 == 0) goto L_0x00ca
            androidx.compose.material3.MaterialTheme r7 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Shapes r7 = r7.getShapes(r1, r14)
            r6 = r6 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ca:
            r9 = r24 & 4
            if (r9 == 0) goto L_0x00d6
            androidx.compose.material3.MaterialTheme r8 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r8 = r8.getTypography(r1, r14)
        L_0x00d4:
            r6 = r6 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00d6:
            r11 = r6
            r15 = r7
            r12 = r8
            r1.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x00e8
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:60)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r6, r7)
        L_0x00e8:
            r0 = 0
            r16 = 7
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = r1
            r17 = r11
            r11 = r0
            r0 = r12
            r12 = r16
            androidx.compose.foundation.Indication r6 = androidx.compose.material.ripple.RippleKt.m1491rememberRipple9IZ8Weo(r6, r7, r8, r10, r11, r12)
            r7 = r17 & 14
            androidx.compose.foundation.text.selection.TextSelectionColors r7 = rememberTextSelectionColors(r2, r1, r7)
            androidx.compose.runtime.ProvidedValue[] r8 = new androidx.compose.runtime.ProvidedValue[r14]
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.material3.ColorSchemeKt.getLocalColorScheme()
            androidx.compose.runtime.ProvidedValue r9 = r9.provides(r2)
            r10 = 0
            r8[r10] = r9
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.foundation.IndicationKt.getLocalIndication()
            androidx.compose.runtime.ProvidedValue r6 = r9.provides(r6)
            r9 = 1
            r8[r9] = r6
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.material.ripple.RippleThemeKt.getLocalRippleTheme()
            androidx.compose.material3.MaterialRippleTheme r10 = androidx.compose.material3.MaterialRippleTheme.INSTANCE
            androidx.compose.runtime.ProvidedValue r6 = r6.provides(r10)
            r8[r13] = r6
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.material3.ShapesKt.getLocalShapes()
            androidx.compose.runtime.ProvidedValue r6 = r6.provides(r15)
            r10 = 3
            r8[r10] = r6
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.ProvidedValue r6 = r6.provides(r7)
            r8[r3] = r6
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.TypographyKt.getLocalTypography()
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r0)
            r6 = 5
            r8[r6] = r3
            androidx.compose.material3.MaterialThemeKt$MaterialTheme$1 r3 = new androidx.compose.material3.MaterialThemeKt$MaterialTheme$1
            r3.<init>(r0, r4)
            r6 = -1066563262(0xffffffffc06d8942, float:-3.7115026)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r6, r9, r3)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r6 = 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r3, (androidx.compose.runtime.Composer) r1, (int) r6)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0160
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0160:
            r3 = r0
        L_0x0161:
            androidx.compose.runtime.ScopeUpdateScope r7 = r1.endRestartGroup()
            if (r7 == 0) goto L_0x017a
            androidx.compose.material3.MaterialThemeKt$MaterialTheme$2 r8 = new androidx.compose.material3.MaterialThemeKt$MaterialTheme$2
            r0 = r8
            r1 = r2
            r2 = r15
            r4 = r21
            r5 = r23
            r6 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MaterialThemeKt.MaterialTheme(androidx.compose.material3.ColorScheme, androidx.compose.material3.Shapes, androidx.compose.material3.Typography, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0036, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0038;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.text.selection.TextSelectionColors rememberTextSelectionColors(androidx.compose.material3.ColorScheme r11, androidx.compose.runtime.Composer r12, int r13) {
        /*
            r0 = 1866455512(0x6f3fd9d8, float:5.9374994E28)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberTextSelectionColors)128@5053L198:MaterialTheme.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:126)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r1, r2)
        L_0x0017:
            long r0 = r11.m1662getPrimary0d7_KjU()
            r11 = -314518050(0xffffffffed40d5de, float:-3.7299795E27)
            r12.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember):MaterialTheme.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r11)
            boolean r11 = r12.changed((long) r0)
            java.lang.Object r13 = r12.rememberedValue()
            if (r11 != 0) goto L_0x0038
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r13 != r11) goto L_0x0051
        L_0x0038:
            androidx.compose.foundation.text.selection.TextSelectionColors r13 = new androidx.compose.foundation.text.selection.TextSelectionColors
            r9 = 14
            r10 = 0
            r5 = 1053609165(0x3ecccccd, float:0.4)
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r0
            long r6 = androidx.compose.ui.graphics.Color.m3815copywmQWz5c$default(r3, r5, r6, r7, r8, r9, r10)
            r8 = 0
            r3 = r13
            r4 = r0
            r3.<init>(r4, r6, r8)
            r12.updateRememberedValue(r13)
        L_0x0051:
            androidx.compose.foundation.text.selection.TextSelectionColors r13 = (androidx.compose.foundation.text.selection.TextSelectionColors) r13
            r12.endReplaceableGroup()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x005f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x005f:
            r12.endReplaceableGroup()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MaterialThemeKt.rememberTextSelectionColors(androidx.compose.material3.ColorScheme, androidx.compose.runtime.Composer, int):androidx.compose.foundation.text.selection.TextSelectionColors");
    }
}
