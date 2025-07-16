package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010 \u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010!\u001a\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002\u001a¬\u0001\u0010'\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,\u0018\u00010+2\u001c\u0010.\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010/0+\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "textModifier-RWo7tUw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
public final class BasicTextKt {
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0217, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0219;
     */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0130  */
    /* renamed from: BasicText-VhcvRP8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1050BasicTextVhcvRP8(java.lang.String r43, androidx.compose.ui.Modifier r44, androidx.compose.ui.text.TextStyle r45, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r46, int r47, boolean r48, int r49, int r50, androidx.compose.ui.graphics.ColorProducer r51, androidx.compose.runtime.Composer r52, int r53, int r54) {
        /*
            r10 = r53
            r11 = r54
            r0 = -1186827822(0xffffffffb94271d2, float:-1.8543683E-4)
            r1 = r52
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)95@4654L7,144@6466L41:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r10 | 6
            r3 = r2
            r2 = r43
            goto L_0x0030
        L_0x001c:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r43
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r10
            goto L_0x0030
        L_0x002d:
            r2 = r43
            r3 = r10
        L_0x0030:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004a
            r5 = r44
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r44
        L_0x004c:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r8 = r10 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0066
            r8 = r45
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0062
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r9
            goto L_0x0068
        L_0x0066:
            r8 = r45
        L_0x0068:
            r9 = r11 & 8
            if (r9 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r12 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0082
            r12 = r46
            boolean r13 = r1.changedInstance(r12)
            if (r13 == 0) goto L_0x007e
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r13
            goto L_0x0084
        L_0x0082:
            r12 = r46
        L_0x0084:
            r13 = r11 & 16
            if (r13 == 0) goto L_0x008b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008b:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00a0
            r14 = r47
            boolean r15 = r1.changed((int) r14)
            if (r15 == 0) goto L_0x009c
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r3 = r3 | r15
            goto L_0x00a2
        L_0x00a0:
            r14 = r47
        L_0x00a2:
            r15 = r11 & 32
            if (r15 == 0) goto L_0x00ad
            r16 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r16
            r0 = r48
            goto L_0x00c2
        L_0x00ad:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r10 & r16
            r0 = r48
            if (r16 != 0) goto L_0x00c2
            boolean r17 = r1.changed((boolean) r0)
            if (r17 == 0) goto L_0x00be
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r3 = r3 | r17
        L_0x00c2:
            r17 = r11 & 64
            if (r17 == 0) goto L_0x00cd
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r7 = r49
            goto L_0x00e2
        L_0x00cd:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r10 & r18
            r7 = r49
            if (r18 != 0) goto L_0x00e2
            boolean r18 = r1.changed((int) r7)
            if (r18 == 0) goto L_0x00de
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r3 = r3 | r18
        L_0x00e2:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00ed
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r18
            r2 = r50
            goto L_0x0102
        L_0x00ed:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r10 & r18
            r2 = r50
            if (r18 != 0) goto L_0x0102
            boolean r18 = r1.changed((int) r2)
            if (r18 == 0) goto L_0x00fe
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0100
        L_0x00fe:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x0100:
            r3 = r3 | r18
        L_0x0102:
            r2 = r11 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x010a
            r18 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 | r18
        L_0x010a:
            r5 = 256(0x100, float:3.59E-43)
            if (r2 != r5) goto L_0x0130
            r5 = 191739611(0xb6db6db, float:4.5782105E-32)
            r5 = r5 & r3
            r7 = 38347922(0x2492492, float:1.4777643E-37)
            if (r5 != r7) goto L_0x0130
            boolean r5 = r1.getSkipping()
            if (r5 != 0) goto L_0x011e
            goto L_0x0130
        L_0x011e:
            r1.skipToGroupEnd()
            r2 = r44
            r6 = r48
            r7 = r49
            r9 = r51
            r3 = r8
            r4 = r12
            r5 = r14
            r8 = r50
            goto L_0x03e1
        L_0x0130:
            if (r4 == 0) goto L_0x0137
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0139
        L_0x0137:
            r4 = r44
        L_0x0139:
            if (r6 == 0) goto L_0x0142
            androidx.compose.ui.text.TextStyle$Companion r5 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r5 = r5.getDefault()
            goto L_0x0143
        L_0x0142:
            r5 = r8
        L_0x0143:
            r6 = 0
            if (r9 == 0) goto L_0x0148
            r7 = r6
            goto L_0x0149
        L_0x0148:
            r7 = r12
        L_0x0149:
            if (r13 == 0) goto L_0x0152
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r8 = r8.m6511getClipgIe3tQ8()
            goto L_0x0153
        L_0x0152:
            r8 = r14
        L_0x0153:
            r9 = 1
            if (r15 == 0) goto L_0x0159
            r41 = r9
            goto L_0x015b
        L_0x0159:
            r41 = r48
        L_0x015b:
            if (r17 == 0) goto L_0x0162
            r12 = 2147483647(0x7fffffff, float:NaN)
            r15 = r12
            goto L_0x0164
        L_0x0162:
            r15 = r49
        L_0x0164:
            if (r0 == 0) goto L_0x0168
            r0 = r9
            goto L_0x016a
        L_0x0168:
            r0 = r50
        L_0x016a:
            if (r2 == 0) goto L_0x016e
            r2 = r6
            goto L_0x0170
        L_0x016e:
            r2 = r51
        L_0x0170:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x017f
            r12 = -1
            java.lang.String r13 = "androidx.compose.foundation.text.BasicText (BasicText.kt:90)"
            r14 = -1186827822(0xffffffffb94271d2, float:-1.8543683E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r3, r12, r13)
        L_0x017f:
            androidx.compose.foundation.text.HeightInLinesModifierKt.validateMinMaxLines(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r3 = r1.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.foundation.text.selection.SelectionRegistrar r3 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r3
            r14 = 959238528(0x392cd180, float:1.6481243E-4)
            r1.startReplaceableGroup(r14)
            java.lang.String r14 = "97@4790L7,99@4853L152,102@5014L234"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            r14 = 0
            if (r3 == 0) goto L_0x023a
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r6 = r1.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.foundation.text.selection.TextSelectionColors r6 = (androidx.compose.foundation.text.selection.TextSelectionColors) r6
            long r16 = r6.m1323getBackgroundColor0d7_KjU()
            java.lang.Object[] r6 = new java.lang.Object[r9]
            r6[r14] = r3
            androidx.compose.runtime.saveable.Saver r9 = selectionIdSaver(r3)
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1 r14 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1
            r14.<init>(r3)
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r18 = 72
            r19 = 4
            r20 = 0
            r44 = r6
            r45 = r9
            r46 = r20
            r47 = r14
            r48 = r1
            r49 = r18
            r50 = r19
            java.lang.Object r6 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r44, r45, (java.lang.String) r46, r47, (androidx.compose.runtime.Composer) r48, (int) r49, (int) r50)
            java.lang.Number r6 = (java.lang.Number) r6
            long r18 = r6.longValue()
            java.lang.Long r6 = java.lang.Long.valueOf(r18)
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m3806boximpl(r16)
            r14 = 1618982084(0x607fb4c4, float:7.370227E19)
            r1.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            boolean r6 = r1.changed((java.lang.Object) r6)
            boolean r14 = r1.changed((java.lang.Object) r3)
            r6 = r6 | r14
            boolean r9 = r1.changed((java.lang.Object) r9)
            r6 = r6 | r9
            java.lang.Object r9 = r1.rememberedValue()
            if (r6 != 0) goto L_0x0219
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r9 != r6) goto L_0x0234
        L_0x0219:
            androidx.compose.foundation.text.modifiers.SelectionController r9 = new androidx.compose.foundation.text.modifiers.SelectionController
            r6 = 8
            r14 = 0
            r20 = 0
            r44 = r9
            r45 = r18
            r47 = r3
            r48 = r16
            r50 = r20
            r51 = r6
            r52 = r14
            r44.<init>(r45, r47, r48, r50, r51, r52)
            r1.updateRememberedValue(r9)
        L_0x0234:
            r1.endReplaceableGroup()
            androidx.compose.foundation.text.modifiers.SelectionController r9 = (androidx.compose.foundation.text.modifiers.SelectionController) r9
            r6 = r9
        L_0x023a:
            r1.endReplaceableGroup()
            if (r6 != 0) goto L_0x02b1
            if (r7 == 0) goto L_0x0243
            goto L_0x02b1
        L_0x0243:
            r3 = 959239868(0x392cd6bc, float:1.6483193E-4)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "136@6279L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r39 = 131071(0x1ffff, float:1.8367E-40)
            r40 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r18 = r4
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r36, r38, r39, r40)
            androidx.compose.foundation.text.modifiers.TextStringSimpleElement r6 = new androidx.compose.foundation.text.modifiers.TextStringSimpleElement
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r9 = r1.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.text.font.FontFamily$Resolver r9 = (androidx.compose.ui.text.font.FontFamily.Resolver) r9
            r21 = 0
            r12 = r6
            r13 = r43
            r10 = 0
            r14 = r5
            r42 = r15
            r15 = r9
            r16 = r8
            r17 = r41
            r18 = r42
            r19 = r0
            r20 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Modifier r3 = r3.then(r6)
            r1.endReplaceableGroup()
            goto L_0x0330
        L_0x02b1:
            r42 = r15
            r10 = 0
            r3 = 959239198(0x392cd41e, float:1.6482218E-4)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "124@5828L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r39 = 131071(0x1ffff, float:1.8367E-40)
            r40 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r18 = r4
            androidx.compose.ui.Modifier r18 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r36, r38, r39, r40)
            androidx.compose.ui.text.AnnotatedString r19 = new androidx.compose.ui.text.AnnotatedString
            r3 = 6
            r9 = 0
            r14 = 0
            r15 = 0
            r44 = r19
            r45 = r43
            r46 = r14
            r47 = r15
            r48 = r3
            r49 = r9
            r44.<init>(r45, r46, r47, r48, r49)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r3 = r1.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r26 = r3
            androidx.compose.ui.text.font.FontFamily$Resolver r26 = (androidx.compose.ui.text.font.FontFamily.Resolver) r26
            r27 = 0
            r28 = 0
            r20 = r5
            r21 = r7
            r22 = r8
            r23 = r41
            r24 = r42
            r25 = r0
            r29 = r6
            r30 = r2
            androidx.compose.ui.Modifier r3 = m1051textModifierRWo7tUw(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r1.endReplaceableGroup()
        L_0x0330:
            androidx.compose.foundation.text.EmptyMeasurePolicy r6 = androidx.compose.foundation.text.EmptyMeasurePolicy.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r6 = (androidx.compose.ui.layout.MeasurePolicy) r6
            r9 = 544976794(0x207baf9a, float:2.1318629E-19)
            r1.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r9)
            int r9 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r10)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r3)
            androidx.compose.runtime.CompositionLocalMap r10 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            r13 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r1.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            androidx.compose.runtime.Applier r13 = r1.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0367
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0367:
            r1.startReusableNode()
            boolean r13 = r1.getInserting()
            if (r13 == 0) goto L_0x037b
            androidx.compose.foundation.text.BasicTextKt$BasicText-VhcvRP8$$inlined$Layout$1 r13 = new androidx.compose.foundation.text.BasicTextKt$BasicText-VhcvRP8$$inlined$Layout$1
            r13.<init>(r12)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r1.createNode(r13)
            goto L_0x037e
        L_0x037b:
            r1.useNode()
        L_0x037e:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m3282constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r3, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r6 = r12.getInserting()
            if (r6 != 0) goto L_0x03b7
            java.lang.Object r6 = r12.rememberedValue()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r10)
            if (r6 != 0) goto L_0x03c5
        L_0x03b7:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            r12.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            r12.apply(r6, r3)
        L_0x03c5:
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x03d7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03d7:
            r9 = r2
            r2 = r4
            r3 = r5
            r4 = r7
            r5 = r8
            r6 = r41
            r7 = r42
            r8 = r0
        L_0x03e1:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x03f8
            androidx.compose.foundation.text.BasicTextKt$BasicText$1 r13 = new androidx.compose.foundation.text.BasicTextKt$BasicText$1
            r0 = r13
            r1 = r43
            r10 = r53
            r11 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x03f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1050BasicTextVhcvRP8(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, androidx.compose.ui.graphics.ColorProducer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r51v1, resolved type: androidx.compose.runtime.saveable.Saver<java.lang.Long, java.lang.Long>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.compose.foundation.text.modifiers.SelectionController} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: androidx.compose.foundation.text.modifiers.SelectionController} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v3, resolved type: androidx.compose.foundation.text.modifiers.SelectionController} */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0236, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0238;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x054b  */
    /* JADX WARNING: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013b  */
    /* renamed from: BasicText-RWo7tUw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1048BasicTextRWo7tUw(androidx.compose.ui.text.AnnotatedString r49, androidx.compose.ui.Modifier r50, androidx.compose.ui.text.TextStyle r51, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r52, int r53, boolean r54, int r55, int r56, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r57, androidx.compose.ui.graphics.ColorProducer r58, androidx.compose.runtime.Composer r59, int r60, int r61) {
        /*
            r13 = r49
            r14 = r60
            r15 = r61
            r0 = -1064305212(0xffffffffc08ffdc4, float:-4.4997272)
            r1 = r59
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)189@8865L7:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r14 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r14 & 14
            if (r1 != 0) goto L_0x002a
            boolean r1 = r12.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r14
            goto L_0x002b
        L_0x002a:
            r1 = r14
        L_0x002b:
            r3 = r15 & 2
            if (r3 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r14 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0045
            r4 = r50
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r1 = r1 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r50
        L_0x0047:
            r5 = r15 & 4
            if (r5 == 0) goto L_0x004e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r6 = r14 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0061
            r6 = r51
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005d
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r7
            goto L_0x0063
        L_0x0061:
            r6 = r51
        L_0x0063:
            r7 = r15 & 8
            if (r7 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007d
            r8 = r52
            boolean r9 = r12.changedInstance(r8)
            if (r9 == 0) goto L_0x0079
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r9
            goto L_0x007f
        L_0x007d:
            r8 = r52
        L_0x007f:
            r9 = r15 & 16
            if (r9 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r14
            if (r10 != 0) goto L_0x009b
            r10 = r53
            boolean r11 = r12.changed((int) r10)
            if (r11 == 0) goto L_0x0097
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r1 = r1 | r11
            goto L_0x009d
        L_0x009b:
            r10 = r53
        L_0x009d:
            r11 = r15 & 32
            if (r11 == 0) goto L_0x00a8
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r2 = r54
            goto L_0x00bd
        L_0x00a8:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r14 & r16
            r2 = r54
            if (r16 != 0) goto L_0x00bd
            boolean r16 = r12.changed((boolean) r2)
            if (r16 == 0) goto L_0x00b9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r1 = r1 | r16
        L_0x00bd:
            r16 = r15 & 64
            if (r16 == 0) goto L_0x00c8
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r0 = r55
            goto L_0x00dd
        L_0x00c8:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r14 & r17
            r0 = r55
            if (r17 != 0) goto L_0x00dd
            boolean r18 = r12.changed((int) r0)
            if (r18 == 0) goto L_0x00d9
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r1 = r1 | r18
        L_0x00dd:
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00e8
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r18
            r2 = r56
            goto L_0x00fd
        L_0x00e8:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r14 & r18
            r2 = r56
            if (r18 != 0) goto L_0x00fd
            boolean r18 = r12.changed((int) r2)
            if (r18 == 0) goto L_0x00f9
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fb
        L_0x00f9:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fb:
            r1 = r1 | r18
        L_0x00fd:
            r2 = r15 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0105
            r18 = 33554432(0x2000000, float:9.403955E-38)
            r1 = r1 | r18
        L_0x0105:
            r4 = r15 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x010d
            r18 = 268435456(0x10000000, float:2.5243549E-29)
            r1 = r1 | r18
        L_0x010d:
            r6 = r15 & 768(0x300, float:1.076E-42)
            r8 = 768(0x300, float:1.076E-42)
            if (r6 != r8) goto L_0x013b
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r1
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r8) goto L_0x013b
            boolean r6 = r12.getSkipping()
            if (r6 != 0) goto L_0x0123
            goto L_0x013b
        L_0x0123:
            r12.skipToGroupEnd()
            r2 = r50
            r3 = r51
            r4 = r52
            r6 = r54
            r7 = r55
            r8 = r56
            r9 = r57
            r5 = r10
            r15 = r12
            r1 = r13
            r10 = r58
            goto L_0x0545
        L_0x013b:
            if (r3 == 0) goto L_0x0144
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r41 = r3
            goto L_0x0146
        L_0x0144:
            r41 = r50
        L_0x0146:
            if (r5 == 0) goto L_0x0151
            androidx.compose.ui.text.TextStyle$Companion r3 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r3 = r3.getDefault()
            r42 = r3
            goto L_0x0153
        L_0x0151:
            r42 = r51
        L_0x0153:
            if (r7 == 0) goto L_0x0158
            r43 = 0
            goto L_0x015a
        L_0x0158:
            r43 = r52
        L_0x015a:
            if (r9 == 0) goto L_0x0165
            androidx.compose.ui.text.style.TextOverflow$Companion r5 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r5 = r5.m6511getClipgIe3tQ8()
            r44 = r5
            goto L_0x0167
        L_0x0165:
            r44 = r10
        L_0x0167:
            r5 = 1
            if (r11 == 0) goto L_0x016d
            r45 = r5
            goto L_0x016f
        L_0x016d:
            r45 = r54
        L_0x016f:
            if (r16 == 0) goto L_0x0176
            r6 = 2147483647(0x7fffffff, float:NaN)
            r11 = r6
            goto L_0x0178
        L_0x0176:
            r11 = r55
        L_0x0178:
            if (r0 == 0) goto L_0x017c
            r10 = r5
            goto L_0x017e
        L_0x017c:
            r10 = r56
        L_0x017e:
            if (r2 == 0) goto L_0x0186
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r9 = r0
            goto L_0x0188
        L_0x0186:
            r9 = r57
        L_0x0188:
            if (r4 == 0) goto L_0x018d
            r16 = 0
            goto L_0x018f
        L_0x018d:
            r16 = r58
        L_0x018f:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019e
            r0 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.BasicText (BasicText.kt:184)"
            r4 = -1064305212(0xffffffffc08ffdc4, float:-4.4997272)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r0, r2)
        L_0x019e:
            androidx.compose.foundation.text.HeightInLinesModifierKt.validateMinMaxLines(r10, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r4)
            java.lang.Object r0 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.foundation.text.selection.SelectionRegistrar r0 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r0
            r6 = 959242739(0x392ce1f3, float:1.6487371E-4)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "191@9001L7,193@9064L152,196@9225L234"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            r8 = 0
            if (r0 == 0) goto L_0x025b
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r4)
            java.lang.Object r6 = r12.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.foundation.text.selection.TextSelectionColors r6 = (androidx.compose.foundation.text.selection.TextSelectionColors) r6
            long r6 = r6.m1323getBackgroundColor0d7_KjU()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            androidx.compose.runtime.saveable.Saver r17 = selectionIdSaver(r0)
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$2 r8 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$2
            r8.<init>(r0)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r18 = 72
            r19 = 4
            r20 = 0
            r50 = r5
            r51 = r17
            r52 = r20
            r53 = r8
            r54 = r12
            r55 = r18
            r56 = r19
            java.lang.Object r5 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r50, r51, (java.lang.String) r52, r53, (androidx.compose.runtime.Composer) r54, (int) r55, (int) r56)
            java.lang.Number r5 = (java.lang.Number) r5
            long r17 = r5.longValue()
            java.lang.Long r5 = java.lang.Long.valueOf(r17)
            androidx.compose.ui.graphics.Color r8 = androidx.compose.ui.graphics.Color.m3806boximpl(r6)
            r3 = 1618982084(0x607fb4c4, float:7.370227E19)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            boolean r3 = r12.changed((java.lang.Object) r5)
            boolean r5 = r12.changed((java.lang.Object) r0)
            r3 = r3 | r5
            boolean r5 = r12.changed((java.lang.Object) r8)
            r3 = r3 | r5
            java.lang.Object r5 = r12.rememberedValue()
            if (r3 != 0) goto L_0x0238
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x0253
        L_0x0238:
            androidx.compose.foundation.text.modifiers.SelectionController r5 = new androidx.compose.foundation.text.modifiers.SelectionController
            r3 = 8
            r8 = 0
            r20 = 0
            r50 = r5
            r51 = r17
            r53 = r0
            r54 = r6
            r56 = r20
            r57 = r3
            r58 = r8
            r50.<init>(r51, r53, r54, r56, r57, r58)
            r12.updateRememberedValue(r5)
        L_0x0253:
            r12.endReplaceableGroup()
            androidx.compose.foundation.text.modifiers.SelectionController r5 = (androidx.compose.foundation.text.modifiers.SelectionController) r5
            r17 = r5
            goto L_0x025d
        L_0x025b:
            r17 = 0
        L_0x025d:
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt.hasInlineContent(r49)
            if (r0 != 0) goto L_0x037a
            r0 = 959243362(0x392ce462, float:1.6488277E-4)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "220@10119L7,208@9605L768"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r39 = 131071(0x1ffff, float:1.8367E-40)
            r40 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r18 = r41
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r36, r38, r39, r40)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r4)
            java.lang.Object r1 = r12.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r8 = r1
            androidx.compose.ui.text.font.FontFamily$Resolver r8 = (androidx.compose.ui.text.font.FontFamily.Resolver) r8
            r18 = 0
            r19 = 0
            r1 = r49
            r2 = r42
            r3 = r43
            r4 = r44
            r5 = r45
            r6 = r11
            r7 = r10
            r14 = r9
            r9 = r18
            r46 = r10
            r10 = r19
            r47 = r11
            r11 = r17
            r15 = r12
            r12 = r16
            androidx.compose.ui.Modifier r0 = m1051textModifierRWo7tUw(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            androidx.compose.foundation.text.EmptyMeasurePolicy r1 = androidx.compose.foundation.text.EmptyMeasurePolicy.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r1 = (androidx.compose.ui.layout.MeasurePolicy) r1
            r2 = 544976794(0x207baf9a, float:2.1318629E-19)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r12 = 0
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r15, r12)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r15, r0)
            androidx.compose.runtime.CompositionLocalMap r3 = r15.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            r5 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r15.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r5)
            androidx.compose.runtime.Applier r5 = r15.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x030b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x030b:
            r15.startReusableNode()
            boolean r5 = r15.getInserting()
            if (r5 == 0) goto L_0x031f
            androidx.compose.foundation.text.BasicTextKt$BasicText-RWo7tUw$$inlined$Layout$1 r5 = new androidx.compose.foundation.text.BasicTextKt$BasicText-RWo7tUw$$inlined$Layout$1
            r5.<init>(r4)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r15.createNode(r5)
            goto L_0x0322
        L_0x031f:
            r15.useNode()
        L_0x0322:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3282constructorimpl(r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r1, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r0, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r1 = r4.getInserting()
            if (r1 != 0) goto L_0x035b
            java.lang.Object r1 = r4.rememberedValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x0369
        L_0x035b:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r4.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r4.apply(r1, r0)
        L_0x0369:
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            r1 = r13
            r20 = r14
            goto L_0x052a
        L_0x037a:
            r14 = r9
            r46 = r10
            r47 = r11
            r15 = r12
            r12 = 0
            r0 = 959244221(0x392ce7bd, float:1.6489527E-4)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "233@10597L81,249@11260L7,236@10687L908"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            kotlin.Pair r0 = androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt.resolveInlineContent(r13, r14)
            java.lang.Object r3 = r0.component1()
            r9 = r3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r0 = r0.component2()
            r11 = r0
            java.util.List r11 = (java.util.List) r11
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            java.lang.Object r0 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x03be
            r3 = 2
            r5 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r5, r3, r5)
            r15.updateRememberedValue(r0)
        L_0x03be:
            r15.endReplaceableGroup()
            r10 = r0
            androidx.compose.runtime.MutableState r10 = (androidx.compose.runtime.MutableState) r10
            r39 = 131071(0x1ffff, float:1.8367E-40)
            r40 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r18 = r41
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r36, r38, r39, r40)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r2, r4)
            java.lang.Object r2 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r8 = r2
            androidx.compose.ui.text.font.FontFamily$Resolver r8 = (androidx.compose.ui.text.font.FontFamily.Resolver) r8
            r2 = 572128197(0x2219fbc5, float:2.0868652E-18)
            r15.startReplaceableGroup(r2)
            boolean r2 = r15.changed((java.lang.Object) r10)
            java.lang.Object r3 = r15.rememberedValue()
            if (r2 != 0) goto L_0x041c
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0427
        L_0x041c:
            androidx.compose.foundation.text.BasicTextKt$BasicText$3$1 r2 = new androidx.compose.foundation.text.BasicTextKt$BasicText$3$1
            r2.<init>(r10)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r15.updateRememberedValue(r3)
        L_0x0427:
            r18 = r3
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            r15.endReplaceableGroup()
            r19 = r1
            r1 = r49
            r2 = r42
            r3 = r43
            r4 = r44
            r5 = r45
            r6 = r47
            r7 = r46
            r20 = r14
            r14 = r10
            r10 = r18
            r48 = r11
            r11 = r17
            r13 = r12
            r12 = r16
            androidx.compose.ui.Modifier r0 = m1051textModifierRWo7tUw(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r1 = 572128392(0x2219fc88, float:2.0869055E-18)
            r15.startReplaceableGroup(r1)
            boolean r1 = r15.changed((java.lang.Object) r14)
            java.lang.Object r2 = r15.rememberedValue()
            if (r1 != 0) goto L_0x0466
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0471
        L_0x0466:
            androidx.compose.foundation.text.BasicTextKt$BasicText$4$1 r1 = new androidx.compose.foundation.text.BasicTextKt$BasicText$4$1
            r1.<init>(r14)
            r2 = r1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r15.updateRememberedValue(r2)
        L_0x0471:
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r15.endReplaceableGroup()
            androidx.compose.foundation.text.TextMeasurePolicy r1 = new androidx.compose.foundation.text.TextMeasurePolicy
            r1.<init>(r2)
            androidx.compose.ui.layout.MeasurePolicy r1 = (androidx.compose.ui.layout.MeasurePolicy) r1
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r15, r13)
            androidx.compose.runtime.CompositionLocalMap r3 = r15.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r5 = r15.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x04a5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x04a5:
            r15.startReusableNode()
            boolean r5 = r15.getInserting()
            if (r5 == 0) goto L_0x04b2
            r15.createNode(r4)
            goto L_0x04b5
        L_0x04b2:
            r15.useNode()
        L_0x04b5:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3282constructorimpl(r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r1, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r4, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r3 = r4.getInserting()
            if (r3 != 0) goto L_0x04e5
            java.lang.Object r3 = r4.rememberedValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x04f3
        L_0x04e5:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4.updateRememberedValue(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.apply(r2, r1)
        L_0x04f3:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r0.invoke(r1, r15, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r0)
            r0 = 1350732076(0x5082892c, float:1.75202222E10)
            java.lang.String r1 = "C237@10719L63:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r1)
            r0 = r19 & 14
            r0 = r0 | 64
            r1 = r49
            r2 = r48
            androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt.InlineChildren(r1, r2, r15, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
        L_0x052a:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0533
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0533:
            r10 = r16
            r9 = r20
            r2 = r41
            r3 = r42
            r4 = r43
            r5 = r44
            r6 = r45
            r8 = r46
            r7 = r47
        L_0x0545:
            androidx.compose.runtime.ScopeUpdateScope r13 = r15.endRestartGroup()
            if (r13 == 0) goto L_0x055c
            androidx.compose.foundation.text.BasicTextKt$BasicText$5 r14 = new androidx.compose.foundation.text.BasicTextKt$BasicText$5
            r0 = r14
            r1 = r49
            r11 = r60
            r12 = r61
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x055c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1048BasicTextRWo7tUw(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.Map, androidx.compose.ui.graphics.ColorProducer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fd  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-BpD7jsM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1047BasicTextBpD7jsM(java.lang.String r21, androidx.compose.ui.Modifier r22, androidx.compose.ui.text.TextStyle r23, kotlin.jvm.functions.Function1 r24, int r25, boolean r26, int r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r8 = r29
            r0 = 1022429478(0x3cf10926, float:0.029423308)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)271@11987L234:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r30 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r8 | 6
            r3 = r2
            r2 = r21
            goto L_0x002e
        L_0x001a:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x002b
            r2 = r21
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r8
            goto L_0x002e
        L_0x002b:
            r2 = r21
            r3 = r8
        L_0x002e:
            r4 = r30 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r5 = r8 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0048
            r5 = r22
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0044
            r6 = 32
            goto L_0x0046
        L_0x0044:
            r6 = 16
        L_0x0046:
            r3 = r3 | r6
            goto L_0x004a
        L_0x0048:
            r5 = r22
        L_0x004a:
            r6 = r30 & 4
            if (r6 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r7 = r8 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0064
            r7 = r23
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r7 = r23
        L_0x0066:
            r9 = r30 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r10 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0080
            r10 = r24
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x007c
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r11
            goto L_0x0082
        L_0x0080:
            r10 = r24
        L_0x0082:
            r11 = r30 & 16
            r12 = 57344(0xe000, float:8.0356E-41)
            if (r11 == 0) goto L_0x008c
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008c:
            r13 = r8 & r12
            if (r13 != 0) goto L_0x009f
            r13 = r25
            boolean r14 = r1.changed((int) r13)
            if (r14 == 0) goto L_0x009b
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r3 = r3 | r14
            goto L_0x00a1
        L_0x009f:
            r13 = r25
        L_0x00a1:
            r14 = r30 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00ae
            r16 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r16
            r15 = r26
            goto L_0x00c1
        L_0x00ae:
            r16 = r8 & r15
            r15 = r26
            if (r16 != 0) goto L_0x00c1
            boolean r16 = r1.changed((boolean) r15)
            if (r16 == 0) goto L_0x00bd
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r3 = r3 | r16
        L_0x00c1:
            r16 = r30 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00ce
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r12 = r27
            goto L_0x00e1
        L_0x00ce:
            r18 = r8 & r17
            r12 = r27
            if (r18 != 0) goto L_0x00e1
            boolean r19 = r1.changed((int) r12)
            if (r19 == 0) goto L_0x00dd
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r3 = r3 | r19
        L_0x00e1:
            r19 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r3 & r19
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r2) goto L_0x00fd
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00f2
            goto L_0x00fd
        L_0x00f2:
            r1.skipToGroupEnd()
            r2 = r5
            r3 = r7
            r4 = r10
            r7 = r12
            r5 = r13
            r6 = r15
            goto L_0x0175
        L_0x00fd:
            if (r4 == 0) goto L_0x0104
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0105
        L_0x0104:
            r0 = r5
        L_0x0105:
            if (r6 == 0) goto L_0x010e
            androidx.compose.ui.text.TextStyle$Companion r2 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r2 = r2.getDefault()
            r7 = r2
        L_0x010e:
            if (r9 == 0) goto L_0x0112
            r2 = 0
            goto L_0x0113
        L_0x0112:
            r2 = r10
        L_0x0113:
            if (r11 == 0) goto L_0x011c
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m6511getClipgIe3tQ8()
            goto L_0x011d
        L_0x011c:
            r4 = r13
        L_0x011d:
            if (r14 == 0) goto L_0x0121
            r5 = 1
            goto L_0x0122
        L_0x0121:
            r5 = r15
        L_0x0122:
            if (r16 == 0) goto L_0x0128
            r6 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0129
        L_0x0128:
            r6 = r12
        L_0x0129:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0138
            r9 = -1
            java.lang.String r10 = "androidx.compose.foundation.text.BasicText (BasicText.kt:270)"
            r11 = 1022429478(0x3cf10926, float:0.029423308)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r3, r9, r10)
        L_0x0138:
            r9 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r3 & 14
            r9 = r9 | r10
            r10 = r3 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            r10 = r3 & 896(0x380, float:1.256E-42)
            r9 = r9 | r10
            r10 = r3 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r10
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r3
            r9 = r9 | r10
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r3
            r9 = r9 | r10
            r3 = r3 & r17
            r19 = r9 | r3
            r20 = 256(0x100, float:3.59E-43)
            r16 = 1
            r17 = 0
            r9 = r21
            r10 = r0
            r11 = r7
            r12 = r2
            r13 = r4
            r14 = r5
            r15 = r6
            r18 = r1
            m1050BasicTextVhcvRP8((java.lang.String) r9, (androidx.compose.ui.Modifier) r10, (androidx.compose.ui.text.TextStyle) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (int) r13, (boolean) r14, (int) r15, (int) r16, (androidx.compose.ui.graphics.ColorProducer) r17, (androidx.compose.runtime.Composer) r18, (int) r19, (int) r20)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x016f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x016f:
            r3 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r2
            r2 = r0
        L_0x0175:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x018c
            androidx.compose.foundation.text.BasicTextKt$BasicText$6 r11 = new androidx.compose.foundation.text.BasicTextKt$BasicText$6
            r0 = r11
            r1 = r21
            r8 = r29
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1047BasicTextBpD7jsM(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010e  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1045BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.text.TextStyle r27, kotlin.jvm.functions.Function1 r28, int r29, boolean r30, int r31, java.util.Map r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r9 = r34
            r10 = r35
            r0 = -648605928(0xffffffffd9570f18, float:-3.78335723E15)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)295@12678L273:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r9 | 6
            r3 = r2
            r2 = r25
            goto L_0x0030
        L_0x001c:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r25
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r9
            goto L_0x0030
        L_0x002d:
            r2 = r25
            r3 = r9
        L_0x0030:
            r4 = r10 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r9 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004a
            r5 = r26
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r26
        L_0x004c:
            r6 = r10 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r8 = r9 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0066
            r8 = r27
            boolean r11 = r1.changed((java.lang.Object) r8)
            if (r11 == 0) goto L_0x0062
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r11
            goto L_0x0068
        L_0x0066:
            r8 = r27
        L_0x0068:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r12 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0082
            r12 = r28
            boolean r13 = r1.changedInstance(r12)
            if (r13 == 0) goto L_0x007e
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r13
            goto L_0x0084
        L_0x0082:
            r12 = r28
        L_0x0084:
            r13 = r10 & 16
            r14 = 57344(0xe000, float:8.0356E-41)
            if (r13 == 0) goto L_0x008e
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008e:
            r15 = r9 & r14
            if (r15 != 0) goto L_0x00a2
            r15 = r29
            boolean r16 = r1.changed((int) r15)
            if (r16 == 0) goto L_0x009d
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r3 = r3 | r16
            goto L_0x00a4
        L_0x00a2:
            r15 = r29
        L_0x00a4:
            r16 = r10 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b1
            r18 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r18
            r14 = r30
            goto L_0x00c4
        L_0x00b1:
            r18 = r9 & r17
            r14 = r30
            if (r18 != 0) goto L_0x00c4
            boolean r18 = r1.changed((boolean) r14)
            if (r18 == 0) goto L_0x00c0
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r3 = r3 | r18
        L_0x00c4:
            r18 = r10 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00d1
            r20 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r20
            r0 = r31
            goto L_0x00e4
        L_0x00d1:
            r20 = r9 & r19
            r0 = r31
            if (r20 != 0) goto L_0x00e4
            boolean r21 = r1.changed((int) r0)
            if (r21 == 0) goto L_0x00e0
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e2
        L_0x00e0:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00e2:
            r3 = r3 | r21
        L_0x00e4:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x00ec
            r22 = 4194304(0x400000, float:5.877472E-39)
            r3 = r3 | r22
        L_0x00ec:
            r0 = 128(0x80, float:1.794E-43)
            if (r7 != r0) goto L_0x010e
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r3
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x010e
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0100
            goto L_0x010e
        L_0x0100:
            r1.skipToGroupEnd()
            r7 = r31
            r2 = r5
            r3 = r8
            r4 = r12
            r6 = r14
            r5 = r15
            r8 = r32
            goto L_0x0196
        L_0x010e:
            if (r4 == 0) goto L_0x0115
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0115:
            if (r6 == 0) goto L_0x011e
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r8 = r0
        L_0x011e:
            if (r11 == 0) goto L_0x0122
            r0 = 0
            goto L_0x0123
        L_0x0122:
            r0 = r12
        L_0x0123:
            if (r13 == 0) goto L_0x012c
            androidx.compose.ui.text.style.TextOverflow$Companion r2 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r2 = r2.m6511getClipgIe3tQ8()
            goto L_0x012d
        L_0x012c:
            r2 = r15
        L_0x012d:
            if (r16 == 0) goto L_0x0131
            r4 = 1
            goto L_0x0132
        L_0x0131:
            r4 = r14
        L_0x0132:
            if (r18 == 0) goto L_0x0138
            r6 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x013a
        L_0x0138:
            r6 = r31
        L_0x013a:
            if (r7 == 0) goto L_0x0141
            java.util.Map r7 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0143
        L_0x0141:
            r7 = r32
        L_0x0143:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0152
            r11 = -1
            java.lang.String r12 = "androidx.compose.foundation.text.BasicText (BasicText.kt:294)"
            r13 = -648605928(0xffffffffd9570f18, float:-3.78335723E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r3, r11, r12)
        L_0x0152:
            r11 = 146800640(0x8c00000, float:1.155558E-33)
            r12 = r3 & 14
            r11 = r11 | r12
            r12 = r3 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            r12 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 | r12
            r12 = r3 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r3
            r11 = r11 | r12
            r12 = r3 & r17
            r11 = r11 | r12
            r3 = r3 & r19
            r22 = r11 | r3
            r23 = 512(0x200, float:7.175E-43)
            r18 = 1
            r20 = 0
            r11 = r25
            r12 = r5
            r13 = r8
            r14 = r0
            r15 = r2
            r16 = r4
            r17 = r6
            r19 = r7
            r21 = r1
            m1048BasicTextRWo7tUw(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x018c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x018c:
            r3 = r8
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r0
            r24 = r5
            r5 = r2
            r2 = r24
        L_0x0196:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x01ad
            androidx.compose.foundation.text.BasicTextKt$BasicText$7 r12 = new androidx.compose.foundation.text.BasicTextKt$BasicText$7
            r0 = r12
            r1 = r25
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x01ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1045BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0121  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1046BasicText4YKlhWE(java.lang.String r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.text.TextStyle r27, kotlin.jvm.functions.Function1 r28, int r29, boolean r30, int r31, int r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r9 = r34
            r10 = r35
            r0 = 1542716361(0x5bf3fbc9, float:1.3735052E17)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)319@13349L86:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r9 | 6
            r3 = r2
            r2 = r25
            goto L_0x0030
        L_0x001c:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r25
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r9
            goto L_0x0030
        L_0x002d:
            r2 = r25
            r3 = r9
        L_0x0030:
            r4 = r10 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r9 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004a
            r5 = r26
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r26
        L_0x004c:
            r6 = r10 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r7 = r9 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0066
            r7 = r27
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0062
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r8
            goto L_0x0068
        L_0x0066:
            r7 = r27
        L_0x0068:
            r8 = r10 & 8
            if (r8 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0082
            r11 = r28
            boolean r12 = r1.changedInstance(r11)
            if (r12 == 0) goto L_0x007e
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r12
            goto L_0x0084
        L_0x0082:
            r11 = r28
        L_0x0084:
            r12 = r10 & 16
            if (r12 == 0) goto L_0x008b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008b:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00a0
            r13 = r29
            boolean r14 = r1.changed((int) r13)
            if (r14 == 0) goto L_0x009c
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r3 = r3 | r14
            goto L_0x00a2
        L_0x00a0:
            r13 = r29
        L_0x00a2:
            r14 = r10 & 32
            if (r14 == 0) goto L_0x00aa
            r15 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r15
            goto L_0x00bf
        L_0x00aa:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00bf
            r15 = r30
            boolean r16 = r1.changed((boolean) r15)
            if (r16 == 0) goto L_0x00ba
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r16
            goto L_0x00c1
        L_0x00bf:
            r15 = r30
        L_0x00c1:
            r16 = r10 & 64
            if (r16 == 0) goto L_0x00cc
            r17 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r17
            r0 = r31
            goto L_0x00e1
        L_0x00cc:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r9 & r17
            r0 = r31
            if (r17 != 0) goto L_0x00e1
            boolean r18 = r1.changed((int) r0)
            if (r18 == 0) goto L_0x00dd
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r3 = r3 | r18
        L_0x00e1:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00ec
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r18
            r2 = r32
            goto L_0x0101
        L_0x00ec:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r9 & r18
            r2 = r32
            if (r18 != 0) goto L_0x0101
            boolean r18 = r1.changed((int) r2)
            if (r18 == 0) goto L_0x00fd
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ff
        L_0x00fd:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ff:
            r3 = r3 | r18
        L_0x0101:
            r18 = 23967451(0x16db6db, float:4.3661218E-38)
            r2 = r3 & r18
            r5 = 4793490(0x492492, float:6.71711E-39)
            if (r2 != r5) goto L_0x0121
            boolean r2 = r1.getSkipping()
            if (r2 != 0) goto L_0x0112
            goto L_0x0121
        L_0x0112:
            r1.skipToGroupEnd()
            r2 = r26
            r8 = r32
            r3 = r7
            r4 = r11
            r5 = r13
            r6 = r15
            r7 = r31
            goto L_0x0191
        L_0x0121:
            if (r4 == 0) goto L_0x0128
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x012a
        L_0x0128:
            r2 = r26
        L_0x012a:
            if (r6 == 0) goto L_0x0133
            androidx.compose.ui.text.TextStyle$Companion r4 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r4 = r4.getDefault()
            r7 = r4
        L_0x0133:
            if (r8 == 0) goto L_0x0137
            r4 = 0
            goto L_0x0138
        L_0x0137:
            r4 = r11
        L_0x0138:
            if (r12 == 0) goto L_0x0141
            androidx.compose.ui.text.style.TextOverflow$Companion r5 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r5 = r5.m6511getClipgIe3tQ8()
            goto L_0x0142
        L_0x0141:
            r5 = r13
        L_0x0142:
            r6 = 1
            if (r14 == 0) goto L_0x0147
            r8 = r6
            goto L_0x0148
        L_0x0147:
            r8 = r15
        L_0x0148:
            if (r16 == 0) goto L_0x0150
            r11 = 2147483647(0x7fffffff, float:NaN)
            r23 = r11
            goto L_0x0152
        L_0x0150:
            r23 = r31
        L_0x0152:
            if (r0 == 0) goto L_0x0155
            goto L_0x0157
        L_0x0155:
            r6 = r32
        L_0x0157:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0166
            r0 = -1
            java.lang.String r11 = "androidx.compose.foundation.text.BasicText (BasicText.kt:319)"
            r12 = 1542716361(0x5bf3fbc9, float:1.3735052E17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r3, r0, r11)
        L_0x0166:
            r0 = 33554430(0x1fffffe, float:9.4039537E-38)
            r21 = r3 & r0
            r22 = 256(0x100, float:3.59E-43)
            r19 = 0
            r11 = r25
            r12 = r2
            r13 = r7
            r14 = r4
            r15 = r5
            r16 = r8
            r17 = r23
            r18 = r6
            r20 = r1
            m1050BasicTextVhcvRP8((java.lang.String) r11, (androidx.compose.ui.Modifier) r12, (androidx.compose.ui.text.TextStyle) r13, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r14, (int) r15, (boolean) r16, (int) r17, (int) r18, (androidx.compose.ui.graphics.ColorProducer) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0189
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0189:
            r3 = r7
            r7 = r23
            r24 = r8
            r8 = r6
            r6 = r24
        L_0x0191:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x01a8
            androidx.compose.foundation.text.BasicTextKt$BasicText$8 r12 = new androidx.compose.foundation.text.BasicTextKt$BasicText$8
            r0 = r12
            r1 = r25
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x01a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1046BasicText4YKlhWE(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0131  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-VhcvRP8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1049BasicTextVhcvRP8(androidx.compose.ui.text.AnnotatedString r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.text.TextStyle r28, kotlin.jvm.functions.Function1 r29, int r30, boolean r31, int r32, int r33, java.util.Map r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r10 = r36
            r11 = r37
            r0 = 851408699(0x32bf773b, float:2.2289546E-8)
            r1 = r35
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)333@13901L240:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r10 | 6
            r3 = r2
            r2 = r26
            goto L_0x0030
        L_0x001c:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r26
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r10
            goto L_0x0030
        L_0x002d:
            r2 = r26
            r3 = r10
        L_0x0030:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004a
            r5 = r27
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r27
        L_0x004c:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r8 = r10 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0066
            r8 = r28
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0062
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r9
            goto L_0x0068
        L_0x0066:
            r8 = r28
        L_0x0068:
            r9 = r11 & 8
            if (r9 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r12 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0082
            r12 = r29
            boolean r13 = r1.changedInstance(r12)
            if (r13 == 0) goto L_0x007e
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r13
            goto L_0x0084
        L_0x0082:
            r12 = r29
        L_0x0084:
            r13 = r11 & 16
            r14 = 57344(0xe000, float:8.0356E-41)
            if (r13 == 0) goto L_0x008e
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008e:
            r15 = r10 & r14
            if (r15 != 0) goto L_0x00a2
            r15 = r30
            boolean r16 = r1.changed((int) r15)
            if (r16 == 0) goto L_0x009d
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r3 = r3 | r16
            goto L_0x00a4
        L_0x00a2:
            r15 = r30
        L_0x00a4:
            r16 = r11 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b1
            r18 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r18
            r14 = r31
            goto L_0x00c4
        L_0x00b1:
            r18 = r10 & r17
            r14 = r31
            if (r18 != 0) goto L_0x00c4
            boolean r18 = r1.changed((boolean) r14)
            if (r18 == 0) goto L_0x00c0
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r3 = r3 | r18
        L_0x00c4:
            r18 = r11 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00d1
            r20 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r20
            r0 = r32
            goto L_0x00e4
        L_0x00d1:
            r20 = r10 & r19
            r0 = r32
            if (r20 != 0) goto L_0x00e4
            boolean r21 = r1.changed((int) r0)
            if (r21 == 0) goto L_0x00e0
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e2
        L_0x00e0:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00e2:
            r3 = r3 | r21
        L_0x00e4:
            r7 = r11 & 128(0x80, float:1.794E-43)
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            if (r7 == 0) goto L_0x00f1
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r23
            r0 = r33
            goto L_0x0104
        L_0x00f1:
            r23 = r10 & r22
            r0 = r33
            if (r23 != 0) goto L_0x0104
            boolean r23 = r1.changed((int) r0)
            if (r23 == 0) goto L_0x0100
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0102
        L_0x0100:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x0102:
            r3 = r3 | r23
        L_0x0104:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x010c
            r23 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 | r23
        L_0x010c:
            r2 = 256(0x100, float:3.59E-43)
            if (r0 != r2) goto L_0x0131
            r2 = 191739611(0xb6db6db, float:4.5782105E-32)
            r2 = r2 & r3
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r5) goto L_0x0131
            boolean r2 = r1.getSkipping()
            if (r2 != 0) goto L_0x0120
            goto L_0x0131
        L_0x0120:
            r1.skipToGroupEnd()
            r2 = r27
            r7 = r32
            r9 = r34
            r3 = r8
            r4 = r12
            r6 = r14
            r5 = r15
            r8 = r33
            goto L_0x01c5
        L_0x0131:
            if (r4 == 0) goto L_0x0138
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x013a
        L_0x0138:
            r2 = r27
        L_0x013a:
            if (r6 == 0) goto L_0x0143
            androidx.compose.ui.text.TextStyle$Companion r4 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r4 = r4.getDefault()
            goto L_0x0144
        L_0x0143:
            r4 = r8
        L_0x0144:
            if (r9 == 0) goto L_0x0148
            r5 = 0
            goto L_0x0149
        L_0x0148:
            r5 = r12
        L_0x0149:
            if (r13 == 0) goto L_0x0152
            androidx.compose.ui.text.style.TextOverflow$Companion r6 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r6 = r6.m6511getClipgIe3tQ8()
            goto L_0x0153
        L_0x0152:
            r6 = r15
        L_0x0153:
            r8 = 1
            if (r16 == 0) goto L_0x0158
            r9 = r8
            goto L_0x0159
        L_0x0158:
            r9 = r14
        L_0x0159:
            if (r18 == 0) goto L_0x0161
            r12 = 2147483647(0x7fffffff, float:NaN)
            r25 = r12
            goto L_0x0163
        L_0x0161:
            r25 = r32
        L_0x0163:
            if (r7 == 0) goto L_0x0166
            goto L_0x0168
        L_0x0166:
            r8 = r33
        L_0x0168:
            if (r0 == 0) goto L_0x016f
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0171
        L_0x016f:
            r0 = r34
        L_0x0171:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0180
            r7 = -1
            java.lang.String r12 = "androidx.compose.foundation.text.BasicText (BasicText.kt:333)"
            r13 = 851408699(0x32bf773b, float:2.2289546E-8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r3, r7, r12)
        L_0x0180:
            r7 = 134217728(0x8000000, float:3.85186E-34)
            r12 = r3 & 14
            r7 = r7 | r12
            r12 = r3 & 112(0x70, float:1.57E-43)
            r7 = r7 | r12
            r12 = r3 & 896(0x380, float:1.256E-42)
            r7 = r7 | r12
            r12 = r3 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r3
            r7 = r7 | r12
            r12 = r3 & r17
            r7 = r7 | r12
            r12 = r3 & r19
            r7 = r7 | r12
            r3 = r3 & r22
            r23 = r7 | r3
            r24 = 512(0x200, float:7.175E-43)
            r21 = 0
            r12 = r26
            r13 = r2
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r9
            r18 = r25
            r19 = r8
            r20 = r0
            r22 = r1
            m1048BasicTextRWo7tUw(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01be
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01be:
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
            r7 = r25
            r9 = r0
        L_0x01c5:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x01dc
            androidx.compose.foundation.text.BasicTextKt$BasicText$9 r13 = new androidx.compose.foundation.text.BasicTextKt$BasicText$9
            r0 = r13
            r1 = r26
            r10 = r36
            r11 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x01dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1049BasicTextVhcvRP8(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Saver<Long, Long> selectionIdSaver(SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new BasicTextKt$selectionIdSaver$1(selectionRegistrar), BasicTextKt$selectionIdSaver$2.INSTANCE);
    }

    /* renamed from: textModifier-RWo7tUw  reason: not valid java name */
    private static final Modifier m1051textModifierRWo7tUw(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer) {
        Modifier modifier2 = modifier;
        if (selectionController == null) {
            return modifier2.then(Modifier.Companion).then(new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, (SelectionController) null, colorProducer, (DefaultConstructorMarker) null));
        }
        return modifier2.then(selectionController.getModifier()).then(new SelectableTextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController, colorProducer, (DefaultConstructorMarker) null));
    }
}
