package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aÜ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aÆ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aÒ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Text.kt */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0433  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:265:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0131  */
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2456Text4IGK_g(java.lang.String r68, androidx.compose.ui.Modifier r69, long r70, long r72, androidx.compose.ui.text.font.FontStyle r74, androidx.compose.ui.text.font.FontWeight r75, androidx.compose.ui.text.font.FontFamily r76, long r77, androidx.compose.ui.text.style.TextDecoration r79, androidx.compose.ui.text.style.TextAlign r80, long r81, int r83, boolean r84, int r85, int r86, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r87, androidx.compose.ui.text.TextStyle r88, androidx.compose.runtime.Composer r89, int r90, int r91, int r92) {
        /*
            r14 = r90
            r15 = r91
            r13 = r92
            r0 = -2055108902(0xffffffff858186da, float:-1.2180638E-35)
            r1 = r89
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)108@5588L7,117@5732L530:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r14 | 6
            r5 = r2
            r2 = r68
            goto L_0x0032
        L_0x001e:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002f
            r2 = r68
            boolean r5 = r1.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x002c
            r5 = 4
            goto L_0x002d
        L_0x002c:
            r5 = 2
        L_0x002d:
            r5 = r5 | r14
            goto L_0x0032
        L_0x002f:
            r2 = r68
            r5 = r14
        L_0x0032:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x004c
        L_0x0039:
            r9 = r14 & 48
            if (r9 != 0) goto L_0x004c
            r9 = r69
            boolean r10 = r1.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0048
            r10 = 32
            goto L_0x004a
        L_0x0048:
            r10 = 16
        L_0x004a:
            r5 = r5 | r10
            goto L_0x004e
        L_0x004c:
            r9 = r69
        L_0x004e:
            r10 = r13 & 4
            if (r10 == 0) goto L_0x0057
            r5 = r5 | 384(0x180, float:5.38E-43)
            r7 = r70
            goto L_0x006a
        L_0x0057:
            r3 = r14 & 384(0x180, float:5.38E-43)
            r7 = r70
            if (r3 != 0) goto L_0x006a
            boolean r17 = r1.changed((long) r7)
            if (r17 == 0) goto L_0x0066
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r17 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r5 = r5 | r17
        L_0x006a:
            r17 = r13 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0077
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            r11 = r72
            goto L_0x008a
        L_0x0077:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            r11 = r72
            if (r3 != 0) goto L_0x008a
            boolean r22 = r1.changed((long) r11)
            if (r22 == 0) goto L_0x0086
            r22 = r18
            goto L_0x0088
        L_0x0086:
            r22 = r19
        L_0x0088:
            r5 = r5 | r22
        L_0x008a:
            r22 = r13 & 16
            r23 = 16384(0x4000, float:2.2959E-41)
            r24 = 8192(0x2000, float:1.14794E-41)
            if (r22 == 0) goto L_0x0095
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x00a9
            r3 = r74
            boolean r26 = r1.changed((java.lang.Object) r3)
            if (r26 == 0) goto L_0x00a4
            r26 = r23
            goto L_0x00a6
        L_0x00a4:
            r26 = r24
        L_0x00a6:
            r5 = r5 | r26
            goto L_0x00ab
        L_0x00a9:
            r3 = r74
        L_0x00ab:
            r26 = r13 & 32
            r27 = 131072(0x20000, float:1.83671E-40)
            r28 = 196608(0x30000, float:2.75506E-40)
            r29 = 65536(0x10000, float:9.18355E-41)
            if (r26 == 0) goto L_0x00ba
            r5 = r5 | r28
            r4 = r75
            goto L_0x00cd
        L_0x00ba:
            r30 = r14 & r28
            r4 = r75
            if (r30 != 0) goto L_0x00cd
            boolean r31 = r1.changed((java.lang.Object) r4)
            if (r31 == 0) goto L_0x00c9
            r31 = r27
            goto L_0x00cb
        L_0x00c9:
            r31 = r29
        L_0x00cb:
            r5 = r5 | r31
        L_0x00cd:
            r31 = r13 & 64
            r32 = 1572864(0x180000, float:2.204052E-39)
            if (r31 == 0) goto L_0x00d8
            r5 = r5 | r32
            r0 = r76
            goto L_0x00eb
        L_0x00d8:
            r33 = r14 & r32
            r0 = r76
            if (r33 != 0) goto L_0x00eb
            boolean r34 = r1.changed((java.lang.Object) r0)
            if (r34 == 0) goto L_0x00e7
            r34 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r34 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r5 = r5 | r34
        L_0x00eb:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r34 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00f6
            r5 = r5 | r34
            r2 = r77
            goto L_0x0109
        L_0x00f6:
            r34 = r14 & r34
            r2 = r77
            if (r34 != 0) goto L_0x0109
            boolean r34 = r1.changed((long) r2)
            if (r34 == 0) goto L_0x0105
            r34 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r34 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r5 = r5 | r34
        L_0x0109:
            r2 = r13 & 256(0x100, float:3.59E-43)
            r3 = 100663296(0x6000000, float:2.4074124E-35)
            if (r2 == 0) goto L_0x0111
            r5 = r5 | r3
            goto L_0x0124
        L_0x0111:
            r3 = r3 & r14
            if (r3 != 0) goto L_0x0124
            r3 = r79
            boolean r34 = r1.changed((java.lang.Object) r3)
            if (r34 == 0) goto L_0x011f
            r34 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0121
        L_0x011f:
            r34 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0121:
            r5 = r5 | r34
            goto L_0x0126
        L_0x0124:
            r3 = r79
        L_0x0126:
            r3 = r13 & 512(0x200, float:7.175E-43)
            r34 = 805306368(0x30000000, float:4.656613E-10)
            if (r3 == 0) goto L_0x0131
            r5 = r5 | r34
            r4 = r80
            goto L_0x0144
        L_0x0131:
            r34 = r14 & r34
            r4 = r80
            if (r34 != 0) goto L_0x0144
            boolean r34 = r1.changed((java.lang.Object) r4)
            if (r34 == 0) goto L_0x0140
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r5 = r5 | r34
        L_0x0144:
            r4 = r13 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x014d
            r30 = r15 | 6
            r7 = r81
            goto L_0x0163
        L_0x014d:
            r34 = r15 & 6
            r7 = r81
            if (r34 != 0) goto L_0x0161
            boolean r34 = r1.changed((long) r7)
            if (r34 == 0) goto L_0x015c
            r30 = 4
            goto L_0x015e
        L_0x015c:
            r30 = 2
        L_0x015e:
            r30 = r15 | r30
            goto L_0x0163
        L_0x0161:
            r30 = r15
        L_0x0163:
            r7 = r13 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x016a
            r30 = r30 | 48
            goto L_0x0180
        L_0x016a:
            r8 = r15 & 48
            if (r8 != 0) goto L_0x017e
            r8 = r83
            boolean r34 = r1.changed((int) r8)
            if (r34 == 0) goto L_0x0179
            r16 = 32
            goto L_0x017b
        L_0x0179:
            r16 = 16
        L_0x017b:
            r30 = r30 | r16
            goto L_0x0180
        L_0x017e:
            r8 = r83
        L_0x0180:
            r8 = r30
            r9 = r13 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0189
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x019d
        L_0x0189:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x019d
            r11 = r84
            boolean r12 = r1.changed((boolean) r11)
            if (r12 == 0) goto L_0x0198
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x019a
        L_0x0198:
            r25 = 128(0x80, float:1.794E-43)
        L_0x019a:
            r8 = r8 | r25
            goto L_0x019f
        L_0x019d:
            r11 = r84
        L_0x019f:
            r12 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01a6
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b8
        L_0x01a6:
            r11 = r15 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x01b8
            r11 = r85
            boolean r16 = r1.changed((int) r11)
            if (r16 == 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b3:
            r18 = r19
        L_0x01b5:
            r8 = r8 | r18
            goto L_0x01ba
        L_0x01b8:
            r11 = r85
        L_0x01ba:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c3
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            r16 = r11
            goto L_0x01d7
        L_0x01c3:
            r16 = r11
            r11 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01d7
            r11 = r86
            boolean r18 = r1.changed((int) r11)
            if (r18 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r23 = r24
        L_0x01d4:
            r8 = r8 | r23
            goto L_0x01d9
        L_0x01d7:
            r11 = r86
        L_0x01d9:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r13 & r18
            if (r18 == 0) goto L_0x01e5
            r8 = r8 | r28
            r11 = r87
            goto L_0x01f6
        L_0x01e5:
            r19 = r15 & r28
            r11 = r87
            if (r19 != 0) goto L_0x01f6
            boolean r19 = r1.changedInstance(r11)
            if (r19 == 0) goto L_0x01f2
            goto L_0x01f4
        L_0x01f2:
            r27 = r29
        L_0x01f4:
            r8 = r8 | r27
        L_0x01f6:
            r19 = r15 & r32
            if (r19 != 0) goto L_0x020e
            r19 = r13 & r29
            r11 = r88
            if (r19 != 0) goto L_0x0209
            boolean r19 = r1.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x0209
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x020b
        L_0x0209:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x020b:
            r8 = r8 | r19
            goto L_0x0210
        L_0x020e:
            r11 = r88
        L_0x0210:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r5 & r19
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r15) goto L_0x024f
            r11 = 599187(0x92493, float:8.3964E-40)
            r11 = r11 & r8
            r15 = 599186(0x92492, float:8.39638E-40)
            if (r11 != r15) goto L_0x024f
            boolean r11 = r1.getSkipping()
            if (r11 != 0) goto L_0x022a
            goto L_0x024f
        L_0x022a:
            r1.skipToGroupEnd()
            r2 = r69
            r3 = r70
            r5 = r72
            r7 = r74
            r8 = r75
            r9 = r76
            r10 = r77
            r12 = r79
            r13 = r80
            r14 = r81
            r16 = r83
            r17 = r84
            r18 = r85
            r19 = r86
            r20 = r87
            r21 = r88
            goto L_0x0454
        L_0x024f:
            r1.startDefaults()
            r11 = r14 & 1
            if (r11 == 0) goto L_0x028b
            boolean r11 = r1.getDefaultsInvalid()
            if (r11 == 0) goto L_0x025d
            goto L_0x028b
        L_0x025d:
            r1.skipToGroupEnd()
            r0 = r13 & r29
            if (r0 == 0) goto L_0x0268
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r0
        L_0x0268:
            r6 = r69
            r10 = r70
            r19 = r72
            r17 = r74
            r21 = r75
            r22 = r76
            r23 = r77
            r0 = r79
            r2 = r80
            r3 = r81
            r7 = r83
            r9 = r84
            r12 = r85
            r25 = r86
            r15 = r87
        L_0x0286:
            r13 = r8
            r8 = r88
            goto L_0x033e
        L_0x028b:
            if (r6 == 0) goto L_0x0292
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0294
        L_0x0292:
            r6 = r69
        L_0x0294:
            if (r10 == 0) goto L_0x029d
            androidx.compose.ui.graphics.Color$Companion r10 = androidx.compose.ui.graphics.Color.Companion
            long r10 = r10.m3852getUnspecified0d7_KjU()
            goto L_0x029f
        L_0x029d:
            r10 = r70
        L_0x029f:
            if (r17 == 0) goto L_0x02a8
            androidx.compose.ui.unit.TextUnit$Companion r15 = androidx.compose.ui.unit.TextUnit.Companion
            long r19 = r15.m6822getUnspecifiedXSAIIZE()
            goto L_0x02aa
        L_0x02a8:
            r19 = r72
        L_0x02aa:
            r15 = 0
            if (r22 == 0) goto L_0x02b0
            r17 = r15
            goto L_0x02b2
        L_0x02b0:
            r17 = r74
        L_0x02b2:
            if (r26 == 0) goto L_0x02b7
            r21 = r15
            goto L_0x02b9
        L_0x02b7:
            r21 = r75
        L_0x02b9:
            if (r31 == 0) goto L_0x02be
            r22 = r15
            goto L_0x02c0
        L_0x02be:
            r22 = r76
        L_0x02c0:
            if (r0 == 0) goto L_0x02c9
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r23 = r0.m6822getUnspecifiedXSAIIZE()
            goto L_0x02cb
        L_0x02c9:
            r23 = r77
        L_0x02cb:
            if (r2 == 0) goto L_0x02cf
            r0 = r15
            goto L_0x02d1
        L_0x02cf:
            r0 = r79
        L_0x02d1:
            if (r3 == 0) goto L_0x02d5
            r2 = r15
            goto L_0x02d7
        L_0x02d5:
            r2 = r80
        L_0x02d7:
            if (r4 == 0) goto L_0x02e0
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6822getUnspecifiedXSAIIZE()
            goto L_0x02e2
        L_0x02e0:
            r3 = r81
        L_0x02e2:
            if (r7 == 0) goto L_0x02eb
            androidx.compose.ui.text.style.TextOverflow$Companion r7 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r7 = r7.m6511getClipgIe3tQ8()
            goto L_0x02ed
        L_0x02eb:
            r7 = r83
        L_0x02ed:
            r25 = 1
            if (r9 == 0) goto L_0x02f4
            r9 = r25
            goto L_0x02f6
        L_0x02f4:
            r9 = r84
        L_0x02f6:
            if (r12 == 0) goto L_0x02fc
            r12 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02fe
        L_0x02fc:
            r12 = r85
        L_0x02fe:
            if (r16 == 0) goto L_0x0301
            goto L_0x0303
        L_0x0301:
            r25 = r86
        L_0x0303:
            if (r18 == 0) goto L_0x0306
            goto L_0x0308
        L_0x0306:
            r15 = r87
        L_0x0308:
            r16 = r13 & r29
            if (r16 == 0) goto L_0x0336
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r16 = LocalTextStyle
            r69 = r0
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r70 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r71 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r3)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r2
            r2 = r70
            r3 = r71
            r13 = r8
            r8 = r0
            r0 = r69
            goto L_0x033e
        L_0x0336:
            r69 = r0
            r70 = r2
            r71 = r3
            goto L_0x0286
        L_0x033e:
            r1.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0352
            java.lang.String r14 = "androidx.compose.material3.Text (Text.kt:109)"
            r81 = r12
            r12 = -2055108902(0xffffffff858186da, float:-1.2180638E-35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r5, r13, r14)
            goto L_0x0354
        L_0x0352:
            r81 = r12
        L_0x0354:
            r12 = 79582827(0x4be566b, float:4.4748148E-36)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            long r26 = r12.m3852getUnspecified0d7_KjU()
            int r12 = (r10 > r26 ? 1 : (r10 == r26 ? 0 : -1))
            if (r12 == 0) goto L_0x036e
            r82 = r10
            r35 = r82
            goto L_0x03ac
        L_0x036e:
            r12 = 79582860(0x4be568c, float:4.4748266E-36)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "*113@5703L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            long r26 = r8.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            long r28 = r12.m3852getUnspecified0d7_KjU()
            int r12 = (r26 > r28 ? 1 : (r26 == r28 ? 0 : -1))
            if (r12 == 0) goto L_0x038a
            r82 = r10
            goto L_0x03a7
        L_0x038a:
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r82 = r10
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r14, r10)
            java.lang.Object r10 = r1.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.graphics.Color r10 = (androidx.compose.ui.graphics.Color) r10
            long r26 = r10.m3826unboximpl()
        L_0x03a7:
            r1.endReplaceableGroup()
            r35 = r26
        L_0x03ac:
            r1.endReplaceableGroup()
            if (r2 == 0) goto L_0x03b6
            int r10 = r2.m6459unboximpl()
            goto L_0x03bc
        L_0x03b6:
            androidx.compose.ui.text.style.TextAlign$Companion r10 = androidx.compose.ui.text.style.TextAlign.Companion
            int r10 = r10.m6466getUnspecifiede0LSkKk()
        L_0x03bc:
            r54 = r10
            r64 = 16609104(0xfd6f50, float:2.3274312E-38)
            r65 = 0
            r41 = 0
            r43 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r52 = 0
            r53 = 0
            r55 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r34 = r8
            r37 = r19
            r39 = r21
            r40 = r17
            r42 = r22
            r44 = r23
            r51 = r0
            r56 = r3
            androidx.compose.ui.text.TextStyle r10 = androidx.compose.ui.text.TextStyle.m6062mergedA7vx0o$default(r34, r35, r37, r39, r40, r41, r42, r43, r44, r46, r47, r48, r49, r51, r52, r53, r54, r55, r56, r58, r59, r60, r61, r62, r63, r64, r65)
            r5 = r5 & 126(0x7e, float:1.77E-43)
            int r11 = r13 >> 6
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r11
            int r11 = r13 << 9
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r11
            r5 = r5 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r11
            r5 = r5 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r11
            r5 = r5 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r11 = r11 & r12
            r5 = r5 | r11
            r11 = 256(0x100, float:3.59E-43)
            r12 = 0
            r69 = r68
            r70 = r6
            r71 = r10
            r72 = r15
            r73 = r7
            r74 = r9
            r75 = r81
            r76 = r25
            r77 = r12
            r78 = r1
            r79 = r5
            r80 = r11
            androidx.compose.foundation.text.BasicTextKt.m1050BasicTextVhcvRP8((java.lang.String) r69, (androidx.compose.ui.Modifier) r70, (androidx.compose.ui.text.TextStyle) r71, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r72, (int) r73, (boolean) r74, (int) r75, (int) r76, (androidx.compose.ui.graphics.ColorProducer) r77, (androidx.compose.runtime.Composer) r78, (int) r79, (int) r80)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0436
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0436:
            r18 = r81
            r12 = r0
            r13 = r2
            r2 = r6
            r16 = r7
            r7 = r17
            r5 = r19
            r10 = r23
            r19 = r25
            r17 = r9
            r20 = r15
            r9 = r22
            r14 = r3
            r3 = r82
            r67 = r21
            r21 = r8
            r8 = r67
        L_0x0454:
            androidx.compose.runtime.ScopeUpdateScope r1 = r1.endRestartGroup()
            if (r1 == 0) goto L_0x0474
            androidx.compose.material3.TextKt$Text$1 r25 = new androidx.compose.material3.TextKt$Text$1
            r0 = r25
            r66 = r1
            r1 = r68
            r22 = r90
            r23 = r91
            r24 = r92
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r66
            r1.updateScope(r0)
        L_0x0474:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2456Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012f  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2458TextfLXpl1I(java.lang.String r54, androidx.compose.ui.Modifier r55, long r56, long r58, androidx.compose.ui.text.font.FontStyle r60, androidx.compose.ui.text.font.FontWeight r61, androidx.compose.ui.text.font.FontFamily r62, long r63, androidx.compose.ui.text.style.TextDecoration r65, androidx.compose.ui.text.style.TextAlign r66, long r67, int r69, boolean r70, int r71, kotlin.jvm.functions.Function1 r72, androidx.compose.ui.text.TextStyle r73, androidx.compose.runtime.Composer r74, int r75, int r76, int r77) {
        /*
            r14 = r75
            r15 = r76
            r13 = r77
            r0 = 1968784669(0x7559451d, float:2.7542241E32)
            r1 = r74
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)160@7042L7,162@7058L322:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r14 | 6
            r5 = r2
            r2 = r54
            goto L_0x0032
        L_0x001e:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002f
            r2 = r54
            boolean r5 = r1.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x002c
            r5 = 4
            goto L_0x002d
        L_0x002c:
            r5 = 2
        L_0x002d:
            r5 = r5 | r14
            goto L_0x0032
        L_0x002f:
            r2 = r54
            r5 = r14
        L_0x0032:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x004c
        L_0x0039:
            r9 = r14 & 48
            if (r9 != 0) goto L_0x004c
            r9 = r55
            boolean r10 = r1.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0048
            r10 = 32
            goto L_0x004a
        L_0x0048:
            r10 = 16
        L_0x004a:
            r5 = r5 | r10
            goto L_0x004e
        L_0x004c:
            r9 = r55
        L_0x004e:
            r10 = r13 & 4
            if (r10 == 0) goto L_0x0057
            r5 = r5 | 384(0x180, float:5.38E-43)
            r7 = r56
            goto L_0x006a
        L_0x0057:
            r3 = r14 & 384(0x180, float:5.38E-43)
            r7 = r56
            if (r3 != 0) goto L_0x006a
            boolean r17 = r1.changed((long) r7)
            if (r17 == 0) goto L_0x0066
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r17 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r5 = r5 | r17
        L_0x006a:
            r17 = r13 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0077
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            r11 = r58
            goto L_0x008a
        L_0x0077:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            r11 = r58
            if (r3 != 0) goto L_0x008a
            boolean r22 = r1.changed((long) r11)
            if (r22 == 0) goto L_0x0086
            r22 = r18
            goto L_0x0088
        L_0x0086:
            r22 = r19
        L_0x0088:
            r5 = r5 | r22
        L_0x008a:
            r22 = r13 & 16
            r23 = 16384(0x4000, float:2.2959E-41)
            r24 = 8192(0x2000, float:1.14794E-41)
            if (r22 == 0) goto L_0x0095
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x00a9
            r3 = r60
            boolean r26 = r1.changed((java.lang.Object) r3)
            if (r26 == 0) goto L_0x00a4
            r26 = r23
            goto L_0x00a6
        L_0x00a4:
            r26 = r24
        L_0x00a6:
            r5 = r5 | r26
            goto L_0x00ab
        L_0x00a9:
            r3 = r60
        L_0x00ab:
            r26 = r13 & 32
            r27 = 65536(0x10000, float:9.18355E-41)
            r28 = 196608(0x30000, float:2.75506E-40)
            if (r26 == 0) goto L_0x00b8
            r5 = r5 | r28
            r4 = r61
            goto L_0x00cb
        L_0x00b8:
            r29 = r14 & r28
            r4 = r61
            if (r29 != 0) goto L_0x00cb
            boolean r30 = r1.changed((java.lang.Object) r4)
            if (r30 == 0) goto L_0x00c7
            r30 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r30 = r27
        L_0x00c9:
            r5 = r5 | r30
        L_0x00cb:
            r30 = r13 & 64
            r31 = 1572864(0x180000, float:2.204052E-39)
            if (r30 == 0) goto L_0x00d6
            r5 = r5 | r31
            r0 = r62
            goto L_0x00e9
        L_0x00d6:
            r31 = r14 & r31
            r0 = r62
            if (r31 != 0) goto L_0x00e9
            boolean r32 = r1.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x00e5
            r32 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r32 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r5 = r5 | r32
        L_0x00e9:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r32 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00f4
            r5 = r5 | r32
            r2 = r63
            goto L_0x0107
        L_0x00f4:
            r32 = r14 & r32
            r2 = r63
            if (r32 != 0) goto L_0x0107
            boolean r32 = r1.changed((long) r2)
            if (r32 == 0) goto L_0x0103
            r32 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r32 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r5 = r5 | r32
        L_0x0107:
            r2 = r13 & 256(0x100, float:3.59E-43)
            r3 = 100663296(0x6000000, float:2.4074124E-35)
            if (r2 == 0) goto L_0x010f
            r5 = r5 | r3
            goto L_0x0122
        L_0x010f:
            r3 = r3 & r14
            if (r3 != 0) goto L_0x0122
            r3 = r65
            boolean r32 = r1.changed((java.lang.Object) r3)
            if (r32 == 0) goto L_0x011d
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011d:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r5 = r5 | r32
            goto L_0x0124
        L_0x0122:
            r3 = r65
        L_0x0124:
            r3 = r13 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r3 == 0) goto L_0x012f
            r5 = r5 | r32
            r4 = r66
            goto L_0x0142
        L_0x012f:
            r32 = r14 & r32
            r4 = r66
            if (r32 != 0) goto L_0x0142
            boolean r32 = r1.changed((java.lang.Object) r4)
            if (r32 == 0) goto L_0x013e
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0140
        L_0x013e:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0140:
            r5 = r5 | r32
        L_0x0142:
            r4 = r13 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x014b
            r29 = r15 | 6
            r7 = r67
            goto L_0x0161
        L_0x014b:
            r32 = r15 & 6
            r7 = r67
            if (r32 != 0) goto L_0x015f
            boolean r32 = r1.changed((long) r7)
            if (r32 == 0) goto L_0x015a
            r29 = 4
            goto L_0x015c
        L_0x015a:
            r29 = 2
        L_0x015c:
            r29 = r15 | r29
            goto L_0x0161
        L_0x015f:
            r29 = r15
        L_0x0161:
            r7 = r13 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0168
            r29 = r29 | 48
            goto L_0x017e
        L_0x0168:
            r8 = r15 & 48
            if (r8 != 0) goto L_0x017c
            r8 = r69
            boolean r32 = r1.changed((int) r8)
            if (r32 == 0) goto L_0x0177
            r16 = 32
            goto L_0x0179
        L_0x0177:
            r16 = 16
        L_0x0179:
            r29 = r29 | r16
            goto L_0x017e
        L_0x017c:
            r8 = r69
        L_0x017e:
            r8 = r29
            r9 = r13 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0187
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x019b
        L_0x0187:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x019b
            r11 = r70
            boolean r12 = r1.changed((boolean) r11)
            if (r12 == 0) goto L_0x0196
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r25 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r8 = r8 | r25
            goto L_0x019d
        L_0x019b:
            r11 = r70
        L_0x019d:
            r12 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01a4
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b6
        L_0x01a4:
            r11 = r15 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x01b6
            r11 = r71
            boolean r16 = r1.changed((int) r11)
            if (r16 == 0) goto L_0x01b1
            goto L_0x01b3
        L_0x01b1:
            r18 = r19
        L_0x01b3:
            r8 = r8 | r18
            goto L_0x01b8
        L_0x01b6:
            r11 = r71
        L_0x01b8:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c1
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            r16 = r11
            goto L_0x01d5
        L_0x01c1:
            r16 = r11
            r11 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01d5
            r11 = r72
            boolean r18 = r1.changedInstance(r11)
            if (r18 == 0) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r23 = r24
        L_0x01d2:
            r8 = r8 | r23
            goto L_0x01d7
        L_0x01d5:
            r11 = r72
        L_0x01d7:
            r18 = r15 & r28
            r19 = 32768(0x8000, float:4.5918E-41)
            if (r18 != 0) goto L_0x01ef
            r18 = r13 & r19
            r11 = r73
            if (r18 != 0) goto L_0x01ec
            boolean r18 = r1.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01ec
            r27 = 131072(0x20000, float:1.83671E-40)
        L_0x01ec:
            r8 = r8 | r27
            goto L_0x01f1
        L_0x01ef:
            r11 = r73
        L_0x01f1:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r5 & r18
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r15) goto L_0x0230
            r11 = 74899(0x12493, float:1.04956E-40)
            r11 = r11 & r8
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r15) goto L_0x0230
            boolean r11 = r1.getSkipping()
            if (r11 != 0) goto L_0x020b
            goto L_0x0230
        L_0x020b:
            r1.skipToGroupEnd()
            r2 = r55
            r3 = r56
            r5 = r58
            r7 = r60
            r8 = r61
            r9 = r62
            r10 = r63
            r12 = r65
            r13 = r66
            r14 = r67
            r16 = r69
            r17 = r70
            r18 = r71
            r19 = r72
            r20 = r73
            r74 = r1
            goto L_0x03a9
        L_0x0230:
            r1.startDefaults()
            r11 = r14 & 1
            if (r11 == 0) goto L_0x026a
            boolean r11 = r1.getDefaultsInvalid()
            if (r11 == 0) goto L_0x023e
            goto L_0x026a
        L_0x023e:
            r1.skipToGroupEnd()
            r0 = r13 & r19
            if (r0 == 0) goto L_0x0249
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = r8 & r0
        L_0x0249:
            r6 = r55
            r10 = r56
            r2 = r58
            r0 = r60
            r4 = r61
            r7 = r62
            r12 = r65
            r15 = r66
            r41 = r67
            r43 = r69
            r44 = r70
            r45 = r71
            r46 = r72
            r47 = r73
            r13 = r8
            r8 = r63
            goto L_0x0327
        L_0x026a:
            if (r6 == 0) goto L_0x0271
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0273
        L_0x0271:
            r6 = r55
        L_0x0273:
            if (r10 == 0) goto L_0x027c
            androidx.compose.ui.graphics.Color$Companion r10 = androidx.compose.ui.graphics.Color.Companion
            long r10 = r10.m3852getUnspecified0d7_KjU()
            goto L_0x027e
        L_0x027c:
            r10 = r56
        L_0x027e:
            if (r17 == 0) goto L_0x0287
            androidx.compose.ui.unit.TextUnit$Companion r15 = androidx.compose.ui.unit.TextUnit.Companion
            long r17 = r15.m6822getUnspecifiedXSAIIZE()
            goto L_0x0289
        L_0x0287:
            r17 = r58
        L_0x0289:
            r15 = 0
            if (r22 == 0) goto L_0x028f
            r20 = r15
            goto L_0x0291
        L_0x028f:
            r20 = r60
        L_0x0291:
            if (r26 == 0) goto L_0x0296
            r21 = r15
            goto L_0x0298
        L_0x0296:
            r21 = r61
        L_0x0298:
            if (r30 == 0) goto L_0x029d
            r22 = r15
            goto L_0x029f
        L_0x029d:
            r22 = r62
        L_0x029f:
            if (r0 == 0) goto L_0x02a8
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r23 = r0.m6822getUnspecifiedXSAIIZE()
            goto L_0x02aa
        L_0x02a8:
            r23 = r63
        L_0x02aa:
            if (r2 == 0) goto L_0x02ae
            r0 = r15
            goto L_0x02b0
        L_0x02ae:
            r0 = r65
        L_0x02b0:
            if (r3 == 0) goto L_0x02b3
            goto L_0x02b5
        L_0x02b3:
            r15 = r66
        L_0x02b5:
            if (r4 == 0) goto L_0x02be
            androidx.compose.ui.unit.TextUnit$Companion r2 = androidx.compose.ui.unit.TextUnit.Companion
            long r2 = r2.m6822getUnspecifiedXSAIIZE()
            goto L_0x02c0
        L_0x02be:
            r2 = r67
        L_0x02c0:
            if (r7 == 0) goto L_0x02c9
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m6511getClipgIe3tQ8()
            goto L_0x02cb
        L_0x02c9:
            r4 = r69
        L_0x02cb:
            if (r9 == 0) goto L_0x02cf
            r7 = 1
            goto L_0x02d1
        L_0x02cf:
            r7 = r70
        L_0x02d1:
            if (r12 == 0) goto L_0x02d7
            r9 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02d9
        L_0x02d7:
            r9 = r71
        L_0x02d9:
            if (r16 == 0) goto L_0x02e0
            androidx.compose.material3.TextKt$Text$2 r12 = androidx.compose.material3.TextKt$Text$2.INSTANCE
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            goto L_0x02e2
        L_0x02e0:
            r12 = r72
        L_0x02e2:
            r16 = r13 & r19
            if (r16 == 0) goto L_0x030a
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r16 = LocalTextStyle
            r55 = r0
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r56 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r3)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = r8 & r2
            r41 = r56
            r47 = r0
            goto L_0x0312
        L_0x030a:
            r55 = r0
            r56 = r2
            r41 = r56
            r47 = r73
        L_0x0312:
            r43 = r4
            r44 = r7
            r13 = r8
            r45 = r9
            r46 = r12
            r2 = r17
            r0 = r20
            r4 = r21
            r7 = r22
            r8 = r23
            r12 = r55
        L_0x0327:
            r1.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x033b
            java.lang.String r14 = "androidx.compose.material3.Text (Text.kt:161)"
            r74 = r1
            r1 = 1968784669(0x7559451d, float:2.7542241E32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r5, r13, r14)
            goto L_0x033d
        L_0x033b:
            r74 = r1
        L_0x033d:
            r1 = 2147483646(0x7ffffffe, float:NaN)
            r38 = r5 & r1
            r1 = r13 & 14
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r5 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 | r5
            r5 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r5
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r5
            int r5 = r13 << 3
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r5
            r1 = r1 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r13
            r39 = r1 | r5
            r40 = 0
            r34 = 1
            r16 = r54
            r17 = r6
            r18 = r10
            r20 = r2
            r22 = r0
            r23 = r4
            r24 = r7
            r25 = r8
            r27 = r12
            r28 = r15
            r29 = r41
            r31 = r43
            r32 = r44
            r33 = r45
            r35 = r46
            r36 = r47
            r37 = r74
            m2456Text4IGK_g((java.lang.String) r16, (androidx.compose.ui.Modifier) r17, (long) r18, (long) r20, (androidx.compose.ui.text.font.FontStyle) r22, (androidx.compose.ui.text.font.FontWeight) r23, (androidx.compose.ui.text.font.FontFamily) r24, (long) r25, (androidx.compose.ui.text.style.TextDecoration) r27, (androidx.compose.ui.text.style.TextAlign) r28, (long) r29, (int) r31, (boolean) r32, (int) r33, (int) r34, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r35, (androidx.compose.ui.text.TextStyle) r36, (androidx.compose.runtime.Composer) r37, (int) r38, (int) r39, (int) r40)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x038c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x038c:
            r13 = r15
            r14 = r41
            r16 = r43
            r17 = r44
            r18 = r45
            r19 = r46
            r20 = r47
            r49 = r7
            r7 = r0
            r50 = r8
            r8 = r4
            r9 = r49
            r52 = r2
            r2 = r6
            r5 = r52
            r3 = r10
            r10 = r50
        L_0x03a9:
            androidx.compose.runtime.ScopeUpdateScope r1 = r74.endRestartGroup()
            if (r1 == 0) goto L_0x03c9
            androidx.compose.material3.TextKt$Text$3 r24 = new androidx.compose.material3.TextKt$Text$3
            r0 = r24
            r48 = r1
            r1 = r54
            r21 = r75
            r22 = r76
            r23 = r77
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r24
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r48
            r1.updateScope(r0)
        L_0x03c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2458TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0493  */
    /* JADX WARNING: Removed duplicated region for block: B:277:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0130  */
    /* renamed from: Text-IbK3jfQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2457TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString r61, androidx.compose.ui.Modifier r62, long r63, long r65, androidx.compose.ui.text.font.FontStyle r67, androidx.compose.ui.text.font.FontWeight r68, androidx.compose.ui.text.font.FontFamily r69, long r70, androidx.compose.ui.text.style.TextDecoration r72, androidx.compose.ui.text.style.TextAlign r73, long r74, int r76, boolean r77, int r78, int r79, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r80, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r81, androidx.compose.ui.text.TextStyle r82, androidx.compose.runtime.Composer r83, int r84, int r85, int r86) {
        /*
            r14 = r84
            r15 = r85
            r13 = r86
            r0 = 2027001676(0x78d1974c, float:3.4008085E34)
            r1 = r83
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)254@11532L7,262@11675L654:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001e
            r1 = r14 | 6
            r4 = r1
            r1 = r61
            goto L_0x0032
        L_0x001e:
            r1 = r14 & 6
            if (r1 != 0) goto L_0x002f
            r1 = r61
            boolean r4 = r0.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r14
            goto L_0x0032
        L_0x002f:
            r1 = r61
            r4 = r14
        L_0x0032:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x004c
        L_0x0039:
            r8 = r14 & 48
            if (r8 != 0) goto L_0x004c
            r8 = r62
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0048
            r9 = 32
            goto L_0x004a
        L_0x0048:
            r9 = 16
        L_0x004a:
            r4 = r4 | r9
            goto L_0x004e
        L_0x004c:
            r8 = r62
        L_0x004e:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0057
            r4 = r4 | 384(0x180, float:5.38E-43)
            r2 = r63
            goto L_0x006a
        L_0x0057:
            r12 = r14 & 384(0x180, float:5.38E-43)
            r2 = r63
            if (r12 != 0) goto L_0x006a
            boolean r16 = r0.changed((long) r2)
            if (r16 == 0) goto L_0x0066
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r4 = r4 | r16
        L_0x006a:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0077
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            r7 = r65
            goto L_0x008a
        L_0x0077:
            r6 = r14 & 3072(0xc00, float:4.305E-42)
            r7 = r65
            if (r6 != 0) goto L_0x008a
            boolean r20 = r0.changed((long) r7)
            if (r20 == 0) goto L_0x0086
            r20 = r17
            goto L_0x0088
        L_0x0086:
            r20 = r18
        L_0x0088:
            r4 = r4 | r20
        L_0x008a:
            r20 = r13 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x0095
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r6 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x00a9
            r6 = r67
            boolean r24 = r0.changed((java.lang.Object) r6)
            if (r24 == 0) goto L_0x00a4
            r24 = r21
            goto L_0x00a6
        L_0x00a4:
            r24 = r22
        L_0x00a6:
            r4 = r4 | r24
            goto L_0x00ab
        L_0x00a9:
            r6 = r67
        L_0x00ab:
            r24 = r13 & 32
            r25 = 65536(0x10000, float:9.18355E-41)
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 131072(0x20000, float:1.83671E-40)
            if (r24 == 0) goto L_0x00ba
            r4 = r4 | r26
            r10 = r68
            goto L_0x00cd
        L_0x00ba:
            r28 = r14 & r26
            r10 = r68
            if (r28 != 0) goto L_0x00cd
            boolean r29 = r0.changed((java.lang.Object) r10)
            if (r29 == 0) goto L_0x00c9
            r29 = r27
            goto L_0x00cb
        L_0x00c9:
            r29 = r25
        L_0x00cb:
            r4 = r4 | r29
        L_0x00cd:
            r29 = r13 & 64
            r30 = 1572864(0x180000, float:2.204052E-39)
            if (r29 == 0) goto L_0x00d8
            r4 = r4 | r30
            r11 = r69
            goto L_0x00eb
        L_0x00d8:
            r31 = r14 & r30
            r11 = r69
            if (r31 != 0) goto L_0x00eb
            boolean r32 = r0.changed((java.lang.Object) r11)
            if (r32 == 0) goto L_0x00e7
            r32 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r32 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r4 = r4 | r32
        L_0x00eb:
            r12 = r13 & 128(0x80, float:1.794E-43)
            r33 = 12582912(0xc00000, float:1.7632415E-38)
            if (r12 == 0) goto L_0x00f6
            r4 = r4 | r33
            r1 = r70
            goto L_0x0108
        L_0x00f6:
            r34 = r14 & r33
            r1 = r70
            if (r34 != 0) goto L_0x0108
            boolean r3 = r0.changed((long) r1)
            if (r3 == 0) goto L_0x0105
            r3 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r3 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r4 = r4 | r3
        L_0x0108:
            r3 = r13 & 256(0x100, float:3.59E-43)
            r34 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x0113
            r4 = r4 | r34
            r1 = r72
            goto L_0x0125
        L_0x0113:
            r34 = r14 & r34
            r1 = r72
            if (r34 != 0) goto L_0x0125
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0122
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0124
        L_0x0122:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0124:
            r4 = r4 | r2
        L_0x0125:
            r2 = r13 & 512(0x200, float:7.175E-43)
            r34 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0130
            r4 = r4 | r34
            r1 = r73
            goto L_0x0143
        L_0x0130:
            r34 = r14 & r34
            r1 = r73
            if (r34 != 0) goto L_0x0143
            boolean r34 = r0.changed((java.lang.Object) r1)
            if (r34 == 0) goto L_0x013f
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0141
        L_0x013f:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0141:
            r4 = r4 | r34
        L_0x0143:
            r1 = r13 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x014c
            r32 = r15 | 6
            r6 = r74
            goto L_0x0162
        L_0x014c:
            r34 = r15 & 6
            r6 = r74
            if (r34 != 0) goto L_0x0160
            boolean r8 = r0.changed((long) r6)
            if (r8 == 0) goto L_0x015b
            r32 = 4
            goto L_0x015d
        L_0x015b:
            r32 = 2
        L_0x015d:
            r32 = r15 | r32
            goto L_0x0162
        L_0x0160:
            r32 = r15
        L_0x0162:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x016b
            r32 = r32 | 48
            r6 = r76
            goto L_0x017e
        L_0x016b:
            r34 = r15 & 48
            r6 = r76
            if (r34 != 0) goto L_0x017e
            boolean r7 = r0.changed((int) r6)
            if (r7 == 0) goto L_0x017a
            r23 = 32
            goto L_0x017c
        L_0x017a:
            r23 = 16
        L_0x017c:
            r32 = r32 | r23
        L_0x017e:
            r7 = r32
            r6 = r13 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0187
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x019b
        L_0x0187:
            r10 = r15 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x019b
            r10 = r77
            boolean r19 = r0.changed((boolean) r10)
            if (r19 == 0) goto L_0x0196
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r28 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r7 = r7 | r28
            goto L_0x019d
        L_0x019b:
            r10 = r77
        L_0x019d:
            r10 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01a4
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b6
        L_0x01a4:
            r11 = r15 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x01b6
            r11 = r78
            boolean r19 = r0.changed((int) r11)
            if (r19 == 0) goto L_0x01b1
            goto L_0x01b3
        L_0x01b1:
            r17 = r18
        L_0x01b3:
            r7 = r7 | r17
            goto L_0x01b8
        L_0x01b6:
            r11 = r78
        L_0x01b8:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c1
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            r17 = r11
            goto L_0x01d5
        L_0x01c1:
            r17 = r11
            r11 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01d5
            r11 = r79
            boolean r18 = r0.changed((int) r11)
            if (r18 == 0) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r21 = r22
        L_0x01d2:
            r7 = r7 | r21
            goto L_0x01d7
        L_0x01d5:
            r11 = r79
        L_0x01d7:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r13 & r18
            if (r18 == 0) goto L_0x01e3
            r7 = r7 | r26
            r11 = r80
            goto L_0x01f6
        L_0x01e3:
            r19 = r15 & r26
            r11 = r80
            if (r19 != 0) goto L_0x01f6
            boolean r19 = r0.changedInstance(r11)
            if (r19 == 0) goto L_0x01f2
            r19 = r27
            goto L_0x01f4
        L_0x01f2:
            r19 = r25
        L_0x01f4:
            r7 = r7 | r19
        L_0x01f6:
            r19 = r13 & r25
            if (r19 == 0) goto L_0x01ff
            r7 = r7 | r30
            r11 = r81
            goto L_0x0212
        L_0x01ff:
            r21 = r15 & r30
            r11 = r81
            if (r21 != 0) goto L_0x0212
            boolean r21 = r0.changedInstance(r11)
            if (r21 == 0) goto L_0x020e
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0210
        L_0x020e:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x0210:
            r7 = r7 | r21
        L_0x0212:
            r21 = r15 & r33
            if (r21 != 0) goto L_0x022a
            r21 = r13 & r27
            r11 = r82
            if (r21 != 0) goto L_0x0225
            boolean r21 = r0.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x0225
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0227
        L_0x0225:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x0227:
            r7 = r7 | r21
            goto L_0x022c
        L_0x022a:
            r11 = r82
        L_0x022c:
            r21 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r4 & r21
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r15) goto L_0x026d
            r11 = 4793491(0x492493, float:6.717112E-39)
            r11 = r11 & r7
            r15 = 4793490(0x492492, float:6.71711E-39)
            if (r11 != r15) goto L_0x026d
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x0246
            goto L_0x026d
        L_0x0246:
            r0.skipToGroupEnd()
            r2 = r62
            r3 = r63
            r5 = r65
            r7 = r67
            r8 = r68
            r9 = r69
            r10 = r70
            r12 = r72
            r13 = r73
            r14 = r74
            r16 = r76
            r17 = r77
            r18 = r78
            r19 = r79
            r20 = r80
            r21 = r81
            r22 = r82
            goto L_0x048d
        L_0x026d:
            r0.startDefaults()
            r11 = r14 & 1
            if (r11 == 0) goto L_0x02ab
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x027b
            goto L_0x02ab
        L_0x027b:
            r0.skipToGroupEnd()
            r1 = r13 & r27
            if (r1 == 0) goto L_0x0286
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r7 = r7 & r1
        L_0x0286:
            r5 = r62
            r21 = r63
            r15 = r65
            r11 = r67
            r20 = r68
            r1 = r69
            r2 = r70
            r6 = r72
            r9 = r73
            r10 = r76
            r12 = r77
            r17 = r78
            r18 = r79
            r19 = r80
            r55 = r81
            r56 = r82
            r13 = r7
            r7 = r74
            goto L_0x0370
        L_0x02ab:
            if (r5 == 0) goto L_0x02b2
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x02b4
        L_0x02b2:
            r5 = r62
        L_0x02b4:
            if (r9 == 0) goto L_0x02bd
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r21 = r9.m3852getUnspecified0d7_KjU()
            goto L_0x02bf
        L_0x02bd:
            r21 = r63
        L_0x02bf:
            if (r16 == 0) goto L_0x02c8
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r15 = r9.m6822getUnspecifiedXSAIIZE()
            goto L_0x02ca
        L_0x02c8:
            r15 = r65
        L_0x02ca:
            r9 = 0
            if (r20 == 0) goto L_0x02cf
            r11 = r9
            goto L_0x02d1
        L_0x02cf:
            r11 = r67
        L_0x02d1:
            if (r24 == 0) goto L_0x02d6
            r20 = r9
            goto L_0x02d8
        L_0x02d6:
            r20 = r68
        L_0x02d8:
            if (r29 == 0) goto L_0x02dd
            r23 = r9
            goto L_0x02df
        L_0x02dd:
            r23 = r69
        L_0x02df:
            if (r12 == 0) goto L_0x02e8
            androidx.compose.ui.unit.TextUnit$Companion r12 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r12.m6822getUnspecifiedXSAIIZE()
            goto L_0x02ea
        L_0x02e8:
            r24 = r70
        L_0x02ea:
            if (r3 == 0) goto L_0x02ee
            r3 = r9
            goto L_0x02f0
        L_0x02ee:
            r3 = r72
        L_0x02f0:
            if (r2 == 0) goto L_0x02f3
            goto L_0x02f5
        L_0x02f3:
            r9 = r73
        L_0x02f5:
            if (r1 == 0) goto L_0x02fe
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m6822getUnspecifiedXSAIIZE()
            goto L_0x0300
        L_0x02fe:
            r1 = r74
        L_0x0300:
            if (r8 == 0) goto L_0x0309
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r8 = r8.m6511getClipgIe3tQ8()
            goto L_0x030b
        L_0x0309:
            r8 = r76
        L_0x030b:
            r12 = 1
            if (r6 == 0) goto L_0x0310
            r6 = r12
            goto L_0x0312
        L_0x0310:
            r6 = r77
        L_0x0312:
            if (r10 == 0) goto L_0x0318
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x031a
        L_0x0318:
            r10 = r78
        L_0x031a:
            if (r17 == 0) goto L_0x031d
            goto L_0x031f
        L_0x031d:
            r12 = r79
        L_0x031f:
            if (r18 == 0) goto L_0x0326
            java.util.Map r17 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0328
        L_0x0326:
            r17 = r80
        L_0x0328:
            if (r19 == 0) goto L_0x032f
            androidx.compose.material3.TextKt$Text$4 r18 = androidx.compose.material3.TextKt$Text$4.INSTANCE
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            goto L_0x0331
        L_0x032f:
            r18 = r81
        L_0x0331:
            r19 = r13 & r27
            if (r19 == 0) goto L_0x0357
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r19 = LocalTextStyle
            r62 = r1
            r1 = r19
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r64 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r3)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r7 = r7 & r2
            r56 = r1
            goto L_0x035d
        L_0x0357:
            r62 = r1
            r64 = r3
            r56 = r82
        L_0x035d:
            r13 = r7
            r19 = r17
            r55 = r18
            r1 = r23
            r2 = r24
            r17 = r10
            r18 = r12
            r12 = r6
            r10 = r8
            r7 = r62
            r6 = r64
        L_0x0370:
            r0.endDefaults()
            boolean r23 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r23 == 0) goto L_0x0384
            r14 = 2027001676(0x78d1974c, float:3.4008085E34)
            r75 = r12
            java.lang.String r12 = "androidx.compose.material3.Text (Text.kt:255)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r4, r13, r12)
            goto L_0x0386
        L_0x0384:
            r75 = r12
        L_0x0386:
            r12 = 79588770(0x4be6da2, float:4.4769467E-36)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            long r23 = r12.m3852getUnspecified0d7_KjU()
            int r12 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r12 == 0) goto L_0x03a0
            r76 = r10
            r24 = r21
            goto L_0x03de
        L_0x03a0:
            r12 = 79588803(0x4be6dc3, float:4.4769586E-36)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "*258@11646L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            long r23 = r56.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            long r25 = r12.m3852getUnspecified0d7_KjU()
            int r12 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r12 == 0) goto L_0x03bc
            r76 = r10
            goto L_0x03d9
        L_0x03bc:
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r76 = r10
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r10)
            java.lang.Object r10 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.graphics.Color r10 = (androidx.compose.ui.graphics.Color) r10
            long r23 = r10.m3826unboximpl()
        L_0x03d9:
            r0.endReplaceableGroup()
            r24 = r23
        L_0x03de:
            r0.endReplaceableGroup()
            if (r9 == 0) goto L_0x03e8
            int r10 = r9.m6459unboximpl()
            goto L_0x03ee
        L_0x03e8:
            androidx.compose.ui.text.style.TextAlign$Companion r10 = androidx.compose.ui.text.style.TextAlign.Companion
            int r10 = r10.m6466getUnspecifiede0LSkKk()
        L_0x03ee:
            r43 = r10
            r53 = 16609104(0xfd6f50, float:2.3274312E-38)
            r54 = 0
            r30 = 0
            r32 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r41 = 0
            r42 = 0
            r44 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r23 = r56
            r26 = r15
            r28 = r20
            r29 = r11
            r31 = r1
            r33 = r2
            r40 = r6
            r45 = r7
            androidx.compose.ui.text.TextStyle r10 = androidx.compose.ui.text.TextStyle.m6062mergedA7vx0o$default(r23, r24, r26, r28, r29, r30, r31, r32, r33, r35, r36, r37, r38, r40, r41, r42, r43, r44, r45, r47, r48, r49, r50, r51, r52, r53, r54)
            r4 = r4 & 126(0x7e, float:1.77E-43)
            int r12 = r13 >> 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r12
            int r12 = r13 << 9
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r12
            r4 = r4 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r12
            r4 = r4 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r12
            r4 = r4 | r13
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r13 = r13 & r12
            r4 = r4 | r13
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            r12 = r12 & r13
            r4 = r4 | r12
            r12 = 512(0x200, float:7.175E-43)
            r13 = 0
            r62 = r61
            r63 = r5
            r64 = r10
            r65 = r55
            r66 = r76
            r67 = r75
            r68 = r17
            r69 = r18
            r70 = r19
            r71 = r13
            r72 = r0
            r73 = r4
            r74 = r12
            androidx.compose.foundation.text.BasicTextKt.m1048BasicTextRWo7tUw(r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x046e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x046e:
            r12 = r6
            r13 = r9
            r9 = r1
            r58 = r17
            r17 = r75
            r59 = r15
            r16 = r76
            r14 = r7
            r7 = r11
            r8 = r20
            r10 = r2
            r2 = r5
            r5 = r59
            r20 = r19
            r3 = r21
            r21 = r55
            r22 = r56
            r19 = r18
            r18 = r58
        L_0x048d:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 == 0) goto L_0x04ad
            androidx.compose.material3.TextKt$Text$5 r26 = new androidx.compose.material3.TextKt$Text$5
            r0 = r26
            r57 = r1
            r1 = r61
            r23 = r84
            r24 = r85
            r25 = r86
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r0 = r26
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r57
            r1.updateScope(r0)
        L_0x04ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2457TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0131  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2455Text4IGK_g(androidx.compose.ui.text.AnnotatedString r56, androidx.compose.ui.Modifier r57, long r58, long r60, androidx.compose.ui.text.font.FontStyle r62, androidx.compose.ui.text.font.FontWeight r63, androidx.compose.ui.text.font.FontFamily r64, long r65, androidx.compose.ui.text.style.TextDecoration r67, androidx.compose.ui.text.style.TextAlign r68, long r69, int r71, boolean r72, int r73, java.util.Map r74, kotlin.jvm.functions.Function1 r75, androidx.compose.ui.text.TextStyle r76, androidx.compose.runtime.Composer r77, int r78, int r79, int r80) {
        /*
            r14 = r78
            r15 = r79
            r13 = r80
            r0 = 224529679(0xd620d0f, float:6.9657345E-31)
            r1 = r77
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)307@13179L7,309@13195L345:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r14 | 6
            r5 = r2
            r2 = r56
            goto L_0x0032
        L_0x001e:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002f
            r2 = r56
            boolean r5 = r1.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x002c
            r5 = 4
            goto L_0x002d
        L_0x002c:
            r5 = 2
        L_0x002d:
            r5 = r5 | r14
            goto L_0x0032
        L_0x002f:
            r2 = r56
            r5 = r14
        L_0x0032:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x004c
        L_0x0039:
            r9 = r14 & 48
            if (r9 != 0) goto L_0x004c
            r9 = r57
            boolean r10 = r1.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0048
            r10 = 32
            goto L_0x004a
        L_0x0048:
            r10 = 16
        L_0x004a:
            r5 = r5 | r10
            goto L_0x004e
        L_0x004c:
            r9 = r57
        L_0x004e:
            r10 = r13 & 4
            if (r10 == 0) goto L_0x0057
            r5 = r5 | 384(0x180, float:5.38E-43)
            r7 = r58
            goto L_0x006a
        L_0x0057:
            r3 = r14 & 384(0x180, float:5.38E-43)
            r7 = r58
            if (r3 != 0) goto L_0x006a
            boolean r17 = r1.changed((long) r7)
            if (r17 == 0) goto L_0x0066
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r17 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r5 = r5 | r17
        L_0x006a:
            r17 = r13 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0077
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            r11 = r60
            goto L_0x008a
        L_0x0077:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            r11 = r60
            if (r3 != 0) goto L_0x008a
            boolean r22 = r1.changed((long) r11)
            if (r22 == 0) goto L_0x0086
            r22 = r18
            goto L_0x0088
        L_0x0086:
            r22 = r19
        L_0x0088:
            r5 = r5 | r22
        L_0x008a:
            r22 = r13 & 16
            r23 = 16384(0x4000, float:2.2959E-41)
            r24 = 8192(0x2000, float:1.14794E-41)
            if (r22 == 0) goto L_0x0095
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x00a9
            r3 = r62
            boolean r26 = r1.changed((java.lang.Object) r3)
            if (r26 == 0) goto L_0x00a4
            r26 = r23
            goto L_0x00a6
        L_0x00a4:
            r26 = r24
        L_0x00a6:
            r5 = r5 | r26
            goto L_0x00ab
        L_0x00a9:
            r3 = r62
        L_0x00ab:
            r26 = r13 & 32
            r27 = 131072(0x20000, float:1.83671E-40)
            r28 = 196608(0x30000, float:2.75506E-40)
            r29 = 65536(0x10000, float:9.18355E-41)
            if (r26 == 0) goto L_0x00ba
            r5 = r5 | r28
            r4 = r63
            goto L_0x00cd
        L_0x00ba:
            r30 = r14 & r28
            r4 = r63
            if (r30 != 0) goto L_0x00cd
            boolean r31 = r1.changed((java.lang.Object) r4)
            if (r31 == 0) goto L_0x00c9
            r31 = r27
            goto L_0x00cb
        L_0x00c9:
            r31 = r29
        L_0x00cb:
            r5 = r5 | r31
        L_0x00cd:
            r31 = r13 & 64
            r32 = 1572864(0x180000, float:2.204052E-39)
            if (r31 == 0) goto L_0x00d8
            r5 = r5 | r32
            r0 = r64
            goto L_0x00eb
        L_0x00d8:
            r33 = r14 & r32
            r0 = r64
            if (r33 != 0) goto L_0x00eb
            boolean r34 = r1.changed((java.lang.Object) r0)
            if (r34 == 0) goto L_0x00e7
            r34 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r34 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r5 = r5 | r34
        L_0x00eb:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r34 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00f6
            r5 = r5 | r34
            r2 = r65
            goto L_0x0109
        L_0x00f6:
            r34 = r14 & r34
            r2 = r65
            if (r34 != 0) goto L_0x0109
            boolean r34 = r1.changed((long) r2)
            if (r34 == 0) goto L_0x0105
            r34 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r34 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r5 = r5 | r34
        L_0x0109:
            r2 = r13 & 256(0x100, float:3.59E-43)
            r3 = 100663296(0x6000000, float:2.4074124E-35)
            if (r2 == 0) goto L_0x0111
            r5 = r5 | r3
            goto L_0x0124
        L_0x0111:
            r3 = r3 & r14
            if (r3 != 0) goto L_0x0124
            r3 = r67
            boolean r34 = r1.changed((java.lang.Object) r3)
            if (r34 == 0) goto L_0x011f
            r34 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0121
        L_0x011f:
            r34 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0121:
            r5 = r5 | r34
            goto L_0x0126
        L_0x0124:
            r3 = r67
        L_0x0126:
            r3 = r13 & 512(0x200, float:7.175E-43)
            r34 = 805306368(0x30000000, float:4.656613E-10)
            if (r3 == 0) goto L_0x0131
            r5 = r5 | r34
            r4 = r68
            goto L_0x0144
        L_0x0131:
            r34 = r14 & r34
            r4 = r68
            if (r34 != 0) goto L_0x0144
            boolean r34 = r1.changed((java.lang.Object) r4)
            if (r34 == 0) goto L_0x0140
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r5 = r5 | r34
        L_0x0144:
            r4 = r13 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x014d
            r30 = r15 | 6
            r7 = r69
            goto L_0x0163
        L_0x014d:
            r34 = r15 & 6
            r7 = r69
            if (r34 != 0) goto L_0x0161
            boolean r34 = r1.changed((long) r7)
            if (r34 == 0) goto L_0x015c
            r30 = 4
            goto L_0x015e
        L_0x015c:
            r30 = 2
        L_0x015e:
            r30 = r15 | r30
            goto L_0x0163
        L_0x0161:
            r30 = r15
        L_0x0163:
            r7 = r13 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x016a
            r30 = r30 | 48
            goto L_0x0180
        L_0x016a:
            r8 = r15 & 48
            if (r8 != 0) goto L_0x017e
            r8 = r71
            boolean r34 = r1.changed((int) r8)
            if (r34 == 0) goto L_0x0179
            r16 = 32
            goto L_0x017b
        L_0x0179:
            r16 = 16
        L_0x017b:
            r30 = r30 | r16
            goto L_0x0180
        L_0x017e:
            r8 = r71
        L_0x0180:
            r8 = r30
            r9 = r13 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0189
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x019d
        L_0x0189:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x019d
            r11 = r72
            boolean r12 = r1.changed((boolean) r11)
            if (r12 == 0) goto L_0x0198
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x019a
        L_0x0198:
            r25 = 128(0x80, float:1.794E-43)
        L_0x019a:
            r8 = r8 | r25
            goto L_0x019f
        L_0x019d:
            r11 = r72
        L_0x019f:
            r12 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01a6
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b8
        L_0x01a6:
            r11 = r15 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x01b8
            r11 = r73
            boolean r16 = r1.changed((int) r11)
            if (r16 == 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b3:
            r18 = r19
        L_0x01b5:
            r8 = r8 | r18
            goto L_0x01ba
        L_0x01b8:
            r11 = r73
        L_0x01ba:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c3
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            r16 = r11
            goto L_0x01d7
        L_0x01c3:
            r16 = r11
            r11 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01d7
            r11 = r74
            boolean r18 = r1.changedInstance(r11)
            if (r18 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r23 = r24
        L_0x01d4:
            r8 = r8 | r23
            goto L_0x01d9
        L_0x01d7:
            r11 = r74
        L_0x01d9:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r13 & r18
            if (r18 == 0) goto L_0x01e5
            r8 = r8 | r28
            r11 = r75
            goto L_0x01f6
        L_0x01e5:
            r19 = r15 & r28
            r11 = r75
            if (r19 != 0) goto L_0x01f6
            boolean r19 = r1.changedInstance(r11)
            if (r19 == 0) goto L_0x01f2
            goto L_0x01f4
        L_0x01f2:
            r27 = r29
        L_0x01f4:
            r8 = r8 | r27
        L_0x01f6:
            r19 = r15 & r32
            if (r19 != 0) goto L_0x020e
            r19 = r13 & r29
            r11 = r76
            if (r19 != 0) goto L_0x0209
            boolean r19 = r1.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x0209
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x020b
        L_0x0209:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x020b:
            r8 = r8 | r19
            goto L_0x0210
        L_0x020e:
            r11 = r76
        L_0x0210:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r11 = r5 & r19
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r15) goto L_0x0251
            r11 = 599187(0x92493, float:8.3964E-40)
            r11 = r11 & r8
            r15 = 599186(0x92492, float:8.39638E-40)
            if (r11 != r15) goto L_0x0251
            boolean r11 = r1.getSkipping()
            if (r11 != 0) goto L_0x022a
            goto L_0x0251
        L_0x022a:
            r1.skipToGroupEnd()
            r2 = r57
            r3 = r58
            r5 = r60
            r7 = r62
            r8 = r63
            r9 = r64
            r10 = r65
            r12 = r67
            r13 = r68
            r14 = r69
            r16 = r71
            r17 = r72
            r18 = r73
            r19 = r74
            r20 = r75
            r21 = r76
            r77 = r1
            goto L_0x03df
        L_0x0251:
            r1.startDefaults()
            r11 = r14 & 1
            if (r11 == 0) goto L_0x028d
            boolean r11 = r1.getDefaultsInvalid()
            if (r11 == 0) goto L_0x025f
            goto L_0x028d
        L_0x025f:
            r1.skipToGroupEnd()
            r0 = r13 & r29
            if (r0 == 0) goto L_0x026a
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r0
        L_0x026a:
            r6 = r57
            r10 = r58
            r2 = r60
            r0 = r62
            r4 = r63
            r7 = r64
            r12 = r67
            r15 = r68
            r42 = r69
            r44 = r71
            r45 = r72
            r46 = r73
            r47 = r74
            r48 = r75
            r49 = r76
            r13 = r8
            r8 = r65
            goto L_0x0355
        L_0x028d:
            if (r6 == 0) goto L_0x0294
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0296
        L_0x0294:
            r6 = r57
        L_0x0296:
            if (r10 == 0) goto L_0x029f
            androidx.compose.ui.graphics.Color$Companion r10 = androidx.compose.ui.graphics.Color.Companion
            long r10 = r10.m3852getUnspecified0d7_KjU()
            goto L_0x02a1
        L_0x029f:
            r10 = r58
        L_0x02a1:
            if (r17 == 0) goto L_0x02aa
            androidx.compose.ui.unit.TextUnit$Companion r15 = androidx.compose.ui.unit.TextUnit.Companion
            long r19 = r15.m6822getUnspecifiedXSAIIZE()
            goto L_0x02ac
        L_0x02aa:
            r19 = r60
        L_0x02ac:
            r15 = 0
            if (r22 == 0) goto L_0x02b2
            r17 = r15
            goto L_0x02b4
        L_0x02b2:
            r17 = r62
        L_0x02b4:
            if (r26 == 0) goto L_0x02b9
            r21 = r15
            goto L_0x02bb
        L_0x02b9:
            r21 = r63
        L_0x02bb:
            if (r31 == 0) goto L_0x02c0
            r22 = r15
            goto L_0x02c2
        L_0x02c0:
            r22 = r64
        L_0x02c2:
            if (r0 == 0) goto L_0x02cb
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r23 = r0.m6822getUnspecifiedXSAIIZE()
            goto L_0x02cd
        L_0x02cb:
            r23 = r65
        L_0x02cd:
            if (r2 == 0) goto L_0x02d1
            r0 = r15
            goto L_0x02d3
        L_0x02d1:
            r0 = r67
        L_0x02d3:
            if (r3 == 0) goto L_0x02d6
            goto L_0x02d8
        L_0x02d6:
            r15 = r68
        L_0x02d8:
            if (r4 == 0) goto L_0x02e1
            androidx.compose.ui.unit.TextUnit$Companion r2 = androidx.compose.ui.unit.TextUnit.Companion
            long r2 = r2.m6822getUnspecifiedXSAIIZE()
            goto L_0x02e3
        L_0x02e1:
            r2 = r69
        L_0x02e3:
            if (r7 == 0) goto L_0x02ec
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m6511getClipgIe3tQ8()
            goto L_0x02ee
        L_0x02ec:
            r4 = r71
        L_0x02ee:
            if (r9 == 0) goto L_0x02f2
            r7 = 1
            goto L_0x02f4
        L_0x02f2:
            r7 = r72
        L_0x02f4:
            if (r12 == 0) goto L_0x02fa
            r9 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02fc
        L_0x02fa:
            r9 = r73
        L_0x02fc:
            if (r16 == 0) goto L_0x0303
            java.util.Map r12 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0305
        L_0x0303:
            r12 = r74
        L_0x0305:
            if (r18 == 0) goto L_0x030c
            androidx.compose.material3.TextKt$Text$6 r16 = androidx.compose.material3.TextKt$Text$6.INSTANCE
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16
            goto L_0x030e
        L_0x030c:
            r16 = r75
        L_0x030e:
            r18 = r13 & r29
            if (r18 == 0) goto L_0x0336
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r18 = LocalTextStyle
            r57 = r0
            r0 = r18
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r58 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r3)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r2
            r42 = r58
            r49 = r0
            goto L_0x033e
        L_0x0336:
            r57 = r0
            r58 = r2
            r42 = r58
            r49 = r76
        L_0x033e:
            r44 = r4
            r45 = r7
            r13 = r8
            r46 = r9
            r47 = r12
            r48 = r16
            r0 = r17
            r2 = r19
            r4 = r21
            r7 = r22
            r8 = r23
            r12 = r57
        L_0x0355:
            r1.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0369
            java.lang.String r14 = "androidx.compose.material3.Text (Text.kt:308)"
            r77 = r1
            r1 = 224529679(0xd620d0f, float:6.9657345E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r5, r13, r14)
            goto L_0x036b
        L_0x0369:
            r77 = r1
        L_0x036b:
            r1 = 2147483646(0x7ffffffe, float:NaN)
            r39 = r5 & r1
            r1 = r13 & 14
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r5 = r13 & 112(0x70, float:1.57E-43)
            r1 = r1 | r5
            r5 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r5
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r5
            int r5 = r13 << 3
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r5
            r1 = r1 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r5
            r1 = r1 | r13
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r13
            r40 = r1 | r5
            r41 = 0
            r34 = 1
            r16 = r56
            r17 = r6
            r18 = r10
            r20 = r2
            r22 = r0
            r23 = r4
            r24 = r7
            r25 = r8
            r27 = r12
            r28 = r15
            r29 = r42
            r31 = r44
            r32 = r45
            r33 = r46
            r35 = r47
            r36 = r48
            r37 = r49
            r38 = r77
            m2457TextIbK3jfQ(r16, r17, r18, r20, r22, r23, r24, r25, r27, r28, r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03c0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03c0:
            r13 = r15
            r14 = r42
            r16 = r44
            r17 = r45
            r18 = r46
            r19 = r47
            r20 = r48
            r21 = r49
            r51 = r7
            r7 = r0
            r52 = r8
            r8 = r4
            r9 = r51
            r54 = r2
            r2 = r6
            r5 = r54
            r3 = r10
            r10 = r52
        L_0x03df:
            androidx.compose.runtime.ScopeUpdateScope r1 = r77.endRestartGroup()
            if (r1 == 0) goto L_0x03ff
            androidx.compose.material3.TextKt$Text$7 r25 = new androidx.compose.material3.TextKt$Text$7
            r0 = r25
            r50 = r1
            r1 = r56
            r22 = r78
            r23 = r79
            r24 = r80
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r50
            r1.updateScope(r0)
        L_0x03ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2455Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-460300127);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyle)P(1)350@14496L7,351@14521L80:Text.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-460300127, i2, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:349)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) providableCompositionLocal.provides(((TextStyle) consume).merge(textStyle)), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$ProvideTextStyle$1(textStyle, function2, i));
        }
    }
}
