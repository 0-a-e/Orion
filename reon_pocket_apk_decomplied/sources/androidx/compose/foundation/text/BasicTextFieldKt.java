package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010&\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010)\u001a\u00020\u0003X\u0002²\u0006\n\u0010*\u001a\u00020%X\u0002"}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "textFieldValueState", "lastTextValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
public final class BasicTextFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v3, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v4, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:267:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(java.lang.String r40, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r41, androidx.compose.ui.Modifier r42, boolean r43, boolean r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.text.KeyboardOptions r46, androidx.compose.foundation.text.KeyboardActions r47, boolean r48, int r49, int r50, androidx.compose.ui.text.input.VisualTransformation r51, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r52, androidx.compose.foundation.interaction.MutableInteractionSource r53, androidx.compose.ui.graphics.Brush r54, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.runtime.Composer r56, int r57, int r58, int r59) {
        /*
            r1 = r40
            r2 = r41
            r15 = r57
            r14 = r58
            r13 = r59
            r0 = 945255183(0x3857730f, float:5.136715E-5)
            r3 = r56
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)141@8417L39,148@8811L57,154@9153L227,163@9701L41,165@9748L1032:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r13 & 1
            if (r4 == 0) goto L_0x001f
            r4 = r15 | 6
            goto L_0x002f
        L_0x001f:
            r4 = r15 & 14
            if (r4 != 0) goto L_0x002e
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x002b
            r4 = 4
            goto L_0x002c
        L_0x002b:
            r4 = 2
        L_0x002c:
            r4 = r4 | r15
            goto L_0x002f
        L_0x002e:
            r4 = r15
        L_0x002f:
            r7 = r13 & 2
            if (r7 == 0) goto L_0x0036
            r4 = r4 | 48
            goto L_0x0046
        L_0x0036:
            r7 = r15 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0046
            boolean r7 = r3.changedInstance(r2)
            if (r7 == 0) goto L_0x0043
            r7 = 32
            goto L_0x0045
        L_0x0043:
            r7 = 16
        L_0x0045:
            r4 = r4 | r7
        L_0x0046:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x004d
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004d:
            r12 = r15 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x0061
            r12 = r42
            boolean r16 = r3.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x005c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r4 = r4 | r16
            goto L_0x0063
        L_0x0061:
            r12 = r42
        L_0x0063:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006e:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0082
            r5 = r43
            boolean r19 = r3.changed((boolean) r5)
            if (r19 == 0) goto L_0x007d
            r19 = r17
            goto L_0x007f
        L_0x007d:
            r19 = r18
        L_0x007f:
            r4 = r4 | r19
            goto L_0x0084
        L_0x0082:
            r5 = r43
        L_0x0084:
            r19 = r13 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x0094
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r8 = r44
            goto L_0x00a7
        L_0x0094:
            r23 = r15 & r22
            r8 = r44
            if (r23 != 0) goto L_0x00a7
            boolean r24 = r3.changed((boolean) r8)
            if (r24 == 0) goto L_0x00a3
            r24 = r20
            goto L_0x00a5
        L_0x00a3:
            r24 = r21
        L_0x00a5:
            r4 = r4 | r24
        L_0x00a7:
            r24 = r13 & 32
            r25 = 458752(0x70000, float:6.42848E-40)
            if (r24 == 0) goto L_0x00b4
            r26 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r26
            r9 = r45
            goto L_0x00c7
        L_0x00b4:
            r26 = r15 & r25
            r9 = r45
            if (r26 != 0) goto L_0x00c7
            boolean r27 = r3.changed((java.lang.Object) r9)
            if (r27 == 0) goto L_0x00c3
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c5
        L_0x00c3:
            r27 = 65536(0x10000, float:9.18355E-41)
        L_0x00c5:
            r4 = r4 | r27
        L_0x00c7:
            r27 = r13 & 64
            if (r27 == 0) goto L_0x00d2
            r28 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r28
            r10 = r46
            goto L_0x00e7
        L_0x00d2:
            r28 = 3670016(0x380000, float:5.142788E-39)
            r28 = r15 & r28
            r10 = r46
            if (r28 != 0) goto L_0x00e7
            boolean r29 = r3.changed((java.lang.Object) r10)
            if (r29 == 0) goto L_0x00e3
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r4 = r4 | r29
        L_0x00e7:
            r11 = r13 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x00f2
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r30
            r6 = r47
            goto L_0x0107
        L_0x00f2:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r15 & r30
            r6 = r47
            if (r30 != 0) goto L_0x0107
            boolean r31 = r3.changed((java.lang.Object) r6)
            if (r31 == 0) goto L_0x0103
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r4 = r4 | r31
        L_0x0107:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0112
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r32
            r5 = r48
            goto L_0x0127
        L_0x0112:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r15 & r32
            r5 = r48
            if (r32 != 0) goto L_0x0127
            boolean r32 = r3.changed((boolean) r5)
            if (r32 == 0) goto L_0x0123
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r4 = r4 | r32
        L_0x0127:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r15 & r32
            if (r32 != 0) goto L_0x0143
            r5 = r13 & 512(0x200, float:7.175E-43)
            if (r5 != 0) goto L_0x013c
            r5 = r49
            boolean r32 = r3.changed((int) r5)
            if (r32 == 0) goto L_0x013e
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0140
        L_0x013c:
            r5 = r49
        L_0x013e:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0140:
            r4 = r4 | r32
            goto L_0x0145
        L_0x0143:
            r5 = r49
        L_0x0145:
            r5 = r13 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x014e
            r32 = r14 | 6
            r6 = r50
            goto L_0x0164
        L_0x014e:
            r32 = r14 & 14
            r6 = r50
            if (r32 != 0) goto L_0x0162
            boolean r32 = r3.changed((int) r6)
            if (r32 == 0) goto L_0x015d
            r32 = 4
            goto L_0x015f
        L_0x015d:
            r32 = 2
        L_0x015f:
            r32 = r14 | r32
            goto L_0x0164
        L_0x0162:
            r32 = r14
        L_0x0164:
            r6 = r13 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x016b
            r32 = r32 | 48
            goto L_0x017e
        L_0x016b:
            r33 = r14 & 112(0x70, float:1.57E-43)
            r8 = r51
            if (r33 != 0) goto L_0x017e
            boolean r33 = r3.changed((java.lang.Object) r8)
            if (r33 == 0) goto L_0x017a
            r23 = 32
            goto L_0x017c
        L_0x017a:
            r23 = 16
        L_0x017c:
            r32 = r32 | r23
        L_0x017e:
            r8 = r32
            r9 = r13 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0187
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x019b
        L_0x0187:
            r10 = r14 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x019b
            r10 = r52
            boolean r23 = r3.changedInstance(r10)
            if (r23 == 0) goto L_0x0196
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r28 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r8 = r8 | r28
            goto L_0x019d
        L_0x019b:
            r10 = r52
        L_0x019d:
            r10 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01a4
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b6
        L_0x01a4:
            r12 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x01b6
            r12 = r53
            boolean r23 = r3.changed((java.lang.Object) r12)
            if (r23 == 0) goto L_0x01b1
            goto L_0x01b3
        L_0x01b1:
            r17 = r18
        L_0x01b3:
            r8 = r8 | r17
            goto L_0x01b8
        L_0x01b6:
            r12 = r53
        L_0x01b8:
            r12 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c1
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            r2 = r54
            goto L_0x01d2
        L_0x01c1:
            r17 = r14 & r22
            r2 = r54
            if (r17 != 0) goto L_0x01d2
            boolean r17 = r3.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x01ce
            goto L_0x01d0
        L_0x01ce:
            r20 = r21
        L_0x01d0:
            r8 = r8 | r20
        L_0x01d2:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r13 & r17
            if (r17 == 0) goto L_0x01e0
            r18 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 | r18
            r2 = r55
            goto L_0x01f3
        L_0x01e0:
            r18 = r14 & r25
            r2 = r55
            if (r18 != 0) goto L_0x01f3
            boolean r18 = r3.changedInstance(r2)
            if (r18 == 0) goto L_0x01ef
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f1
        L_0x01ef:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x01f1:
            r8 = r8 | r18
        L_0x01f3:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r4 & r18
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r14) goto L_0x0230
            r2 = 374491(0x5b6db, float:5.24774E-40)
            r2 = r2 & r8
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r2 != r14) goto L_0x0230
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x020d
            goto L_0x0230
        L_0x020d:
            r3.skipToGroupEnd()
            r5 = r41
            r4 = r42
            r7 = r43
            r6 = r44
            r8 = r45
            r9 = r46
            r11 = r47
            r10 = r48
            r12 = r49
            r13 = r50
            r14 = r51
            r15 = r52
            r36 = r53
            r37 = r54
            r16 = r55
            goto L_0x04bf
        L_0x0230:
            r3.startDefaults()
            r2 = r15 & 1
            r18 = 1
            if (r2 == 0) goto L_0x026a
            boolean r2 = r3.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0240
            goto L_0x026a
        L_0x0240:
            r3.skipToGroupEnd()
            r0 = r13 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x024b
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r4 = r4 & r0
        L_0x024b:
            r2 = r42
            r7 = r43
            r0 = r44
            r5 = r46
            r11 = r47
            r6 = r48
            r14 = r49
            r49 = r50
            r10 = r51
            r12 = r52
            r36 = r53
            r37 = r54
            r38 = r55
            r9 = r4
            r4 = r45
            goto L_0x0345
        L_0x026a:
            if (r7 == 0) goto L_0x0271
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0273
        L_0x0271:
            r2 = r42
        L_0x0273:
            if (r16 == 0) goto L_0x0278
            r7 = r18
            goto L_0x027a
        L_0x0278:
            r7 = r43
        L_0x027a:
            if (r19 == 0) goto L_0x027f
            r16 = 0
            goto L_0x0281
        L_0x027f:
            r16 = r44
        L_0x0281:
            if (r24 == 0) goto L_0x028a
            androidx.compose.ui.text.TextStyle$Companion r19 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r19 = r19.getDefault()
            goto L_0x028c
        L_0x028a:
            r19 = r45
        L_0x028c:
            if (r27 == 0) goto L_0x0295
            androidx.compose.foundation.text.KeyboardOptions$Companion r20 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r20 = r20.getDefault()
            goto L_0x0297
        L_0x0295:
            r20 = r46
        L_0x0297:
            if (r11 == 0) goto L_0x02a0
            androidx.compose.foundation.text.KeyboardActions$Companion r11 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r11 = r11.getDefault()
            goto L_0x02a2
        L_0x02a0:
            r11 = r47
        L_0x02a2:
            if (r0 == 0) goto L_0x02a6
            r0 = 0
            goto L_0x02a8
        L_0x02a6:
            r0 = r48
        L_0x02a8:
            r14 = r13 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x02ba
            if (r0 == 0) goto L_0x02b1
            r14 = r18
            goto L_0x02b4
        L_0x02b1:
            r14 = 2147483647(0x7fffffff, float:NaN)
        L_0x02b4:
            r23 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r4 = r4 & r23
            goto L_0x02bc
        L_0x02ba:
            r14 = r49
        L_0x02bc:
            if (r5 == 0) goto L_0x02c1
            r5 = r18
            goto L_0x02c3
        L_0x02c1:
            r5 = r50
        L_0x02c3:
            if (r6 == 0) goto L_0x02cc
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x02ce
        L_0x02cc:
            r6 = r51
        L_0x02ce:
            if (r9 == 0) goto L_0x02d5
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1 r9 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            goto L_0x02d7
        L_0x02d5:
            r9 = r52
        L_0x02d7:
            if (r10 == 0) goto L_0x0300
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r10)
            java.lang.Object r10 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r42 = r0
            java.lang.Object r0 = r23.getEmpty()
            if (r10 != r0) goto L_0x02f9
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r10)
        L_0x02f9:
            r3.endReplaceableGroup()
            r0 = r10
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0304
        L_0x0300:
            r42 = r0
            r0 = r53
        L_0x0304:
            if (r12 == 0) goto L_0x031a
            androidx.compose.ui.graphics.SolidColor r10 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            r43 = r4
            r44 = r5
            long r4 = r12.m3842getBlack0d7_KjU()
            r12 = 0
            r10.<init>(r4, r12)
            r4 = r10
            androidx.compose.ui.graphics.Brush r4 = (androidx.compose.ui.graphics.Brush) r4
            goto L_0x0320
        L_0x031a:
            r43 = r4
            r44 = r5
            r4 = r54
        L_0x0320:
            if (r17 == 0) goto L_0x0331
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r5 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r5 = r5.m1058getLambda1$foundation_release()
            r49 = r44
            r36 = r0
            r37 = r4
            r38 = r5
            goto L_0x0339
        L_0x0331:
            r49 = r44
            r38 = r55
            r36 = r0
            r37 = r4
        L_0x0339:
            r10 = r6
            r12 = r9
            r0 = r16
            r4 = r19
            r5 = r20
            r6 = r42
            r9 = r43
        L_0x0345:
            r3.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0359
            java.lang.String r13 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:145)"
            r50 = r14
            r14 = 945255183(0x3857730f, float:5.136715E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r9, r8, r13)
            goto L_0x035b
        L_0x0359:
            r50 = r14
        L_0x035b:
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r13)
            java.lang.Object r13 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r13 != r14) goto L_0x0393
            androidx.compose.ui.text.input.TextFieldValue r13 = new androidx.compose.ui.text.input.TextFieldValue
            r14 = 6
            r16 = 0
            r19 = 0
            r17 = 0
            r42 = r13
            r43 = r40
            r44 = r19
            r46 = r17
            r47 = r14
            r48 = r16
            r42.<init>((java.lang.String) r43, (long) r44, (androidx.compose.ui.text.TextRange) r46, (int) r47, (kotlin.jvm.internal.DefaultConstructorMarker) r48)
            r14 = 0
            r15 = 2
            androidx.compose.runtime.MutableState r13 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r14, r15, r14)
            r3.updateRememberedValue(r13)
        L_0x0393:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            androidx.compose.ui.text.input.TextFieldValue r14 = BasicTextField$lambda$2(r13)
            r15 = 6
            r16 = 0
            r19 = 0
            r17 = 0
            r42 = r14
            r43 = r40
            r44 = r19
            r46 = r17
            r47 = r15
            r48 = r16
            androidx.compose.ui.text.input.TextFieldValue r14 = androidx.compose.ui.text.input.TextFieldValue.m6295copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r42, (java.lang.String) r43, (long) r44, (androidx.compose.ui.text.TextRange) r46, (int) r47, (java.lang.Object) r48)
            r15 = 623728715(0x252d584b, float:1.5035273E-16)
            r3.startReplaceableGroup(r15)
            boolean r15 = r3.changed((java.lang.Object) r14)
            boolean r16 = r3.changed((java.lang.Object) r13)
            r15 = r15 | r16
            r42 = r0
            java.lang.Object r0 = r3.rememberedValue()
            if (r15 != 0) goto L_0x03d3
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r0 != r15) goto L_0x03dd
        L_0x03d3:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
            r0.<init>(r14, r13)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r3.updateRememberedValue(r0)
        L_0x03dd:
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r3.endReplaceableGroup()
            r15 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r3, r15)
            r0 = 1157296644(0x44faf204, float:2007.563)
            r3.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            boolean r0 = r3.changed((java.lang.Object) r1)
            java.lang.Object r15 = r3.rememberedValue()
            if (r0 != 0) goto L_0x0403
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r15 != r0) goto L_0x040c
        L_0x0403:
            r0 = 0
            r15 = 2
            androidx.compose.runtime.MutableState r15 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r0, r15, r0)
            r3.updateRememberedValue(r15)
        L_0x040c:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            androidx.compose.ui.text.input.ImeOptions r27 = r5.toImeOptions$foundation_release(r6)
            r24 = r6 ^ 1
            if (r6 == 0) goto L_0x041c
            r26 = r18
            goto L_0x041e
        L_0x041c:
            r26 = r49
        L_0x041e:
            if (r6 == 0) goto L_0x0423
            r0 = r18
            goto L_0x0425
        L_0x0423:
            r0 = r50
        L_0x0425:
            r1 = 623729370(0x252d5ada, float:1.503614E-16)
            r3.startReplaceableGroup(r1)
            boolean r1 = r3.changed((java.lang.Object) r13)
            boolean r16 = r3.changed((java.lang.Object) r15)
            r1 = r1 | r16
            r43 = r5
            r5 = r41
            boolean r16 = r3.changedInstance(r5)
            r1 = r1 | r16
            r44 = r6
            java.lang.Object r6 = r3.rememberedValue()
            if (r1 != 0) goto L_0x044f
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r6 != r1) goto L_0x045a
        L_0x044f:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
            r1.<init>(r5, r13, r15)
            r6 = r1
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r3.updateRememberedValue(r6)
        L_0x045a:
            r17 = r6
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r3.endReplaceableGroup()
            r1 = r9 & 896(0x380, float:1.256E-42)
            int r6 = r9 >> 6
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r6
            int r6 = r8 << 9
            r13 = r6 & r22
            r1 = r1 | r13
            r13 = r6 & r25
            r1 = r1 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r6
            r1 = r1 | r13
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r13
            r33 = r1 | r6
            int r1 = r9 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r6 = r9 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r6
            r6 = r9 & r22
            r1 = r1 | r6
            r6 = r8 & r25
            r34 = r1 | r6
            r35 = 0
            r16 = r14
            r18 = r2
            r19 = r4
            r20 = r10
            r21 = r12
            r22 = r36
            r23 = r37
            r25 = r0
            r28 = r11
            r29 = r7
            r30 = r42
            r31 = r38
            r32 = r3
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04af
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04af:
            r6 = r42
            r9 = r43
            r13 = r49
            r8 = r4
            r14 = r10
            r15 = r12
            r16 = r38
            r10 = r44
            r12 = r50
            r4 = r2
        L_0x04bf:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 == 0) goto L_0x04f9
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5 r20 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5
            r0 = r20
            r1 = r40
            r2 = r41
            r5 = r3
            r3 = r4
            r4 = r7
            r7 = r5
            r5 = r6
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r8
            r8 = r11
            r11 = r9
            r9 = r10
            r10 = r12
            r12 = r11
            r11 = r13
            r13 = r12
            r12 = r14
            r14 = r13
            r13 = r15
            r15 = r14
            r14 = r36
            r39 = r15
            r15 = r37
            r17 = r57
            r18 = r58
            r19 = r59
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r39
            r1.updateScope(r0)
        L_0x04f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$2(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final String BasicTextField$lambda$6(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v3, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v4, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(androidx.compose.ui.text.input.TextFieldValue r36, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, int r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.ui.graphics.Brush r50, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r15 = r36
            r14 = r37
            r13 = r53
            r12 = r54
            r11 = r55
            r0 = 1804514146(0x6b8eb362, float:3.4502916E26)
            r1 = r52
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)291@17267L39,296@17507L740:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x001f
            r1 = r13 | 6
            goto L_0x002f
        L_0x001f:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x002e
            boolean r1 = r10.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r13
            goto L_0x002f
        L_0x002e:
            r1 = r13
        L_0x002f:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0046
        L_0x0036:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0046
            boolean r4 = r10.changedInstance(r14)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
        L_0x0046:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x004d
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004d:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0061
            r9 = r38
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x005c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r16
            goto L_0x0063
        L_0x0061:
            r9 = r38
        L_0x0063:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x006e
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006e:
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0082
            r2 = r39
            boolean r19 = r10.changed((boolean) r2)
            if (r19 == 0) goto L_0x007d
            r19 = r17
            goto L_0x007f
        L_0x007d:
            r19 = r18
        L_0x007f:
            r1 = r1 | r19
            goto L_0x0084
        L_0x0082:
            r2 = r39
        L_0x0084:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x0094
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r3 = r40
            goto L_0x00a7
        L_0x0094:
            r23 = r13 & r22
            r3 = r40
            if (r23 != 0) goto L_0x00a7
            boolean r24 = r10.changed((boolean) r3)
            if (r24 == 0) goto L_0x00a3
            r24 = r20
            goto L_0x00a5
        L_0x00a3:
            r24 = r21
        L_0x00a5:
            r1 = r1 | r24
        L_0x00a7:
            r24 = r11 & 32
            r25 = 458752(0x70000, float:6.42848E-40)
            if (r24 == 0) goto L_0x00b4
            r26 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r26
            r5 = r41
            goto L_0x00c7
        L_0x00b4:
            r26 = r13 & r25
            r5 = r41
            if (r26 != 0) goto L_0x00c7
            boolean r27 = r10.changed((java.lang.Object) r5)
            if (r27 == 0) goto L_0x00c3
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c5
        L_0x00c3:
            r27 = 65536(0x10000, float:9.18355E-41)
        L_0x00c5:
            r1 = r1 | r27
        L_0x00c7:
            r27 = r11 & 64
            if (r27 == 0) goto L_0x00d2
            r28 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r28
            r6 = r42
            goto L_0x00e7
        L_0x00d2:
            r28 = 3670016(0x380000, float:5.142788E-39)
            r28 = r13 & r28
            r6 = r42
            if (r28 != 0) goto L_0x00e7
            boolean r29 = r10.changed((java.lang.Object) r6)
            if (r29 == 0) goto L_0x00e3
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r1 = r1 | r29
        L_0x00e7:
            r7 = r11 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x00f2
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r30
            r8 = r43
            goto L_0x0107
        L_0x00f2:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r13 & r30
            r8 = r43
            if (r30 != 0) goto L_0x0107
            boolean r31 = r10.changed((java.lang.Object) r8)
            if (r31 == 0) goto L_0x0103
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r1 = r1 | r31
        L_0x0107:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0112
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r32
            r2 = r44
            goto L_0x0127
        L_0x0112:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r13 & r32
            r2 = r44
            if (r32 != 0) goto L_0x0127
            boolean r32 = r10.changed((boolean) r2)
            if (r32 == 0) goto L_0x0123
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r1 = r1 | r32
        L_0x0127:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r13 & r32
            if (r32 != 0) goto L_0x0143
            r2 = r11 & 512(0x200, float:7.175E-43)
            if (r2 != 0) goto L_0x013c
            r2 = r45
            boolean r32 = r10.changed((int) r2)
            if (r32 == 0) goto L_0x013e
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0140
        L_0x013c:
            r2 = r45
        L_0x013e:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0140:
            r1 = r1 | r32
            goto L_0x0145
        L_0x0143:
            r2 = r45
        L_0x0145:
            r2 = r11 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x014e
            r23 = r12 | 6
            r3 = r46
            goto L_0x0164
        L_0x014e:
            r32 = r12 & 14
            r3 = r46
            if (r32 != 0) goto L_0x0162
            boolean r32 = r10.changed((int) r3)
            if (r32 == 0) goto L_0x015d
            r23 = 4
            goto L_0x015f
        L_0x015d:
            r23 = 2
        L_0x015f:
            r23 = r12 | r23
            goto L_0x0164
        L_0x0162:
            r23 = r12
        L_0x0164:
            r3 = r11 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x016b
            r23 = r23 | 48
            goto L_0x017e
        L_0x016b:
            r32 = r12 & 112(0x70, float:1.57E-43)
            r5 = r47
            if (r32 != 0) goto L_0x017e
            boolean r32 = r10.changed((java.lang.Object) r5)
            if (r32 == 0) goto L_0x017a
            r28 = 32
            goto L_0x017c
        L_0x017a:
            r28 = 16
        L_0x017c:
            r23 = r23 | r28
        L_0x017e:
            r5 = r23
            r6 = r11 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0187
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x019b
        L_0x0187:
            r8 = r12 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x019b
            r8 = r48
            boolean r23 = r10.changedInstance(r8)
            if (r23 == 0) goto L_0x0196
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r29 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r5 = r5 | r29
            goto L_0x019d
        L_0x019b:
            r8 = r48
        L_0x019d:
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01a4
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b6
        L_0x01a4:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01b6
            r9 = r49
            boolean r23 = r10.changed((java.lang.Object) r9)
            if (r23 == 0) goto L_0x01b1
            goto L_0x01b3
        L_0x01b1:
            r17 = r18
        L_0x01b3:
            r5 = r5 | r17
            goto L_0x01b8
        L_0x01b6:
            r9 = r49
        L_0x01b8:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01c1
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r14 = r50
            goto L_0x01d2
        L_0x01c1:
            r17 = r12 & r22
            r14 = r50
            if (r17 != 0) goto L_0x01d2
            boolean r17 = r10.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x01ce
            goto L_0x01d0
        L_0x01ce:
            r20 = r21
        L_0x01d0:
            r5 = r5 | r20
        L_0x01d2:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x01e0
            r18 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r18
            r12 = r51
            goto L_0x01f3
        L_0x01e0:
            r18 = r12 & r25
            r12 = r51
            if (r18 != 0) goto L_0x01f3
            boolean r18 = r10.changedInstance(r12)
            if (r18 == 0) goto L_0x01ef
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f1
        L_0x01ef:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x01f1:
            r5 = r5 | r18
        L_0x01f3:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r1 & r18
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x0230
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r5
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r14) goto L_0x0230
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x020d
            goto L_0x0230
        L_0x020d:
            r10.skipToGroupEnd()
            r3 = r38
            r4 = r39
            r5 = r40
            r6 = r41
            r7 = r42
            r8 = r43
            r9 = r44
            r11 = r46
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r16 = r51
            r22 = r10
            r10 = r45
            goto L_0x040e
        L_0x0230:
            r10.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x0268
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x023e
            goto L_0x0268
        L_0x023e:
            r10.skipToGroupEnd()
            r0 = r11 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0249
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r0
        L_0x0249:
            r20 = r38
            r21 = r39
            r23 = r40
            r24 = r41
            r14 = r42
            r26 = r43
            r12 = r44
            r27 = r45
            r28 = r46
            r29 = r47
            r30 = r48
            r32 = r49
            r33 = r50
            r34 = r51
            r0 = r1
            goto L_0x0348
        L_0x0268:
            if (r4 == 0) goto L_0x026f
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0271
        L_0x026f:
            r4 = r38
        L_0x0271:
            if (r16 == 0) goto L_0x0275
            r12 = 1
            goto L_0x0277
        L_0x0275:
            r12 = r39
        L_0x0277:
            if (r19 == 0) goto L_0x027c
            r16 = 0
            goto L_0x027e
        L_0x027c:
            r16 = r40
        L_0x027e:
            if (r24 == 0) goto L_0x0287
            androidx.compose.ui.text.TextStyle$Companion r18 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r18 = r18.getDefault()
            goto L_0x0289
        L_0x0287:
            r18 = r41
        L_0x0289:
            if (r27 == 0) goto L_0x0292
            androidx.compose.foundation.text.KeyboardOptions$Companion r19 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r19 = r19.getDefault()
            goto L_0x0294
        L_0x0292:
            r19 = r42
        L_0x0294:
            if (r7 == 0) goto L_0x029d
            androidx.compose.foundation.text.KeyboardActions$Companion r7 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r7 = r7.getDefault()
            goto L_0x029f
        L_0x029d:
            r7 = r43
        L_0x029f:
            if (r0 == 0) goto L_0x02a3
            r0 = 0
            goto L_0x02a5
        L_0x02a3:
            r0 = r44
        L_0x02a5:
            r14 = r11 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x02b6
            if (r0 == 0) goto L_0x02ad
            r14 = 1
            goto L_0x02b0
        L_0x02ad:
            r14 = 2147483647(0x7fffffff, float:NaN)
        L_0x02b0:
            r20 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r20
            goto L_0x02b8
        L_0x02b6:
            r14 = r45
        L_0x02b8:
            if (r2 == 0) goto L_0x02bc
            r2 = 1
            goto L_0x02be
        L_0x02bc:
            r2 = r46
        L_0x02be:
            if (r3 == 0) goto L_0x02c7
            androidx.compose.ui.text.input.VisualTransformation$Companion r3 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r3 = r3.getNone()
            goto L_0x02c9
        L_0x02c7:
            r3 = r47
        L_0x02c9:
            if (r6 == 0) goto L_0x02d0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6 r6 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            goto L_0x02d2
        L_0x02d0:
            r6 = r48
        L_0x02d2:
            if (r8 == 0) goto L_0x02fb
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r8)
            java.lang.Object r8 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r38 = r0
            java.lang.Object r0 = r20.getEmpty()
            if (r8 != r0) goto L_0x02f4
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r8)
        L_0x02f4:
            r10.endReplaceableGroup()
            r0 = r8
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x02ff
        L_0x02fb:
            r38 = r0
            r0 = r49
        L_0x02ff:
            if (r9 == 0) goto L_0x0315
            androidx.compose.ui.graphics.SolidColor r8 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            r40 = r0
            r39 = r1
            long r0 = r9.m3842getBlack0d7_KjU()
            r9 = 0
            r8.<init>(r0, r9)
            r0 = r8
            androidx.compose.ui.graphics.Brush r0 = (androidx.compose.ui.graphics.Brush) r0
            goto L_0x031b
        L_0x0315:
            r40 = r0
            r39 = r1
            r0 = r50
        L_0x031b:
            if (r17 == 0) goto L_0x032a
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r1 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r1 = r1.m1059getLambda2$foundation_release()
            r32 = r40
            r33 = r0
            r34 = r1
            goto L_0x0330
        L_0x032a:
            r32 = r40
            r34 = r51
            r33 = r0
        L_0x0330:
            r28 = r2
            r29 = r3
            r20 = r4
            r30 = r6
            r26 = r7
            r21 = r12
            r27 = r14
            r23 = r16
            r24 = r18
            r14 = r19
            r12 = r38
            r0 = r39
        L_0x0348:
            r10.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0359
            java.lang.String r1 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:295)"
            r2 = 1804514146(0x6b8eb362, float:3.4502916E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r0, r5, r1)
        L_0x0359:
            androidx.compose.ui.text.input.ImeOptions r16 = r14.toImeOptions$foundation_release(r12)
            r8 = r12 ^ 1
            if (r12 == 0) goto L_0x0364
            r31 = 1
            goto L_0x0366
        L_0x0364:
            r31 = r28
        L_0x0366:
            if (r12 == 0) goto L_0x036a
            r9 = 1
            goto L_0x036c
        L_0x036a:
            r9 = r27
        L_0x036c:
            r1 = 623737120(0x252d7920, float:1.5046397E-16)
            r10.startReplaceableGroup(r1)
            boolean r1 = r10.changed((java.lang.Object) r15)
            r7 = r37
            boolean r2 = r10.changedInstance(r7)
            r1 = r1 | r2
            java.lang.Object r2 = r10.rememberedValue()
            if (r1 != 0) goto L_0x038b
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0396
        L_0x038b:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
            r1.<init>(r15, r7)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r10.updateRememberedValue(r2)
        L_0x0396:
            r1 = r2
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r10.endReplaceableGroup()
            r2 = r0 & 910(0x38e, float:1.275E-42)
            int r3 = r0 >> 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r5 << 9
            r4 = r3 & r22
            r2 = r2 | r4
            r4 = r3 & r25
            r2 = r2 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r3
            r2 = r2 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r4
            r17 = r2 | r3
            int r2 = r0 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r3 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r0 = r0 & r22
            r0 = r0 | r2
            r2 = r5 & r25
            r18 = r0 | r2
            r19 = 0
            r0 = r36
            r2 = r20
            r3 = r24
            r4 = r29
            r5 = r30
            r6 = r32
            r7 = r33
            r22 = r10
            r10 = r31
            r11 = r16
            r25 = r12
            r12 = r26
            r13 = r21
            r31 = r14
            r14 = r23
            r15 = r34
            r16 = r22
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03f2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03f2:
            r3 = r20
            r4 = r21
            r5 = r23
            r6 = r24
            r9 = r25
            r8 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r7 = r31
            r14 = r32
            r15 = r33
            r16 = r34
        L_0x040e:
            androidx.compose.runtime.ScopeUpdateScope r2 = r22.endRestartGroup()
            if (r2 == 0) goto L_0x0430
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9 r20 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9
            r0 = r20
            r1 = r36
            r35 = r2
            r2 = r37
            r17 = r53
            r18 = r54
            r19 = r55
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x0430:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013a  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void BasicTextField(java.lang.String r40, kotlin.jvm.functions.Function1 r41, androidx.compose.ui.Modifier r42, boolean r43, boolean r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.text.KeyboardOptions r46, androidx.compose.foundation.text.KeyboardActions r47, boolean r48, int r49, androidx.compose.ui.text.input.VisualTransformation r50, kotlin.jvm.functions.Function1 r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.ui.graphics.Brush r53, kotlin.jvm.functions.Function3 r54, androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            r15 = r56
            r14 = r57
            r13 = r58
            r0 = -454732590(0xffffffffe4e554d2, float:-3.384333E22)
            r1 = r55
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)335@18937L39,340@19177L579:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r15 | 6
            r5 = r2
            r2 = r40
            goto L_0x0032
        L_0x001e:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x002f
            r2 = r40
            boolean r5 = r1.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x002c
            r5 = 4
            goto L_0x002d
        L_0x002c:
            r5 = 2
        L_0x002d:
            r5 = r5 | r15
            goto L_0x0032
        L_0x002f:
            r2 = r40
            r5 = r15
        L_0x0032:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r15 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            r6 = r41
            boolean r9 = r1.changedInstance(r6)
            if (r9 == 0) goto L_0x0048
            r9 = 32
            goto L_0x004a
        L_0x0048:
            r9 = 16
        L_0x004a:
            r5 = r5 | r9
            goto L_0x004e
        L_0x004c:
            r6 = r41
        L_0x004e:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0055
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0055:
            r12 = r15 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x0069
            r12 = r42
            boolean r16 = r1.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x0064
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r5 = r5 | r16
            goto L_0x006b
        L_0x0069:
            r12 = r42
        L_0x006b:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0076
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0076:
            r3 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x008a
            r3 = r43
            boolean r19 = r1.changed((boolean) r3)
            if (r19 == 0) goto L_0x0085
            r19 = r17
            goto L_0x0087
        L_0x0085:
            r19 = r18
        L_0x0087:
            r5 = r5 | r19
            goto L_0x008c
        L_0x008a:
            r3 = r43
        L_0x008c:
            r19 = r13 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x009c
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r4 = r44
            goto L_0x00af
        L_0x009c:
            r23 = r15 & r22
            r4 = r44
            if (r23 != 0) goto L_0x00af
            boolean r24 = r1.changed((boolean) r4)
            if (r24 == 0) goto L_0x00ab
            r24 = r20
            goto L_0x00ad
        L_0x00ab:
            r24 = r21
        L_0x00ad:
            r5 = r5 | r24
        L_0x00af:
            r24 = r13 & 32
            if (r24 == 0) goto L_0x00ba
            r25 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r25
            r7 = r45
            goto L_0x00cf
        L_0x00ba:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r15 & r25
            r7 = r45
            if (r25 != 0) goto L_0x00cf
            boolean r26 = r1.changed((java.lang.Object) r7)
            if (r26 == 0) goto L_0x00cb
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cd
        L_0x00cb:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00cd:
            r5 = r5 | r26
        L_0x00cf:
            r26 = r13 & 64
            if (r26 == 0) goto L_0x00da
            r27 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r27
            r8 = r46
            goto L_0x00ef
        L_0x00da:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r15 & r27
            r8 = r46
            if (r27 != 0) goto L_0x00ef
            boolean r28 = r1.changed((java.lang.Object) r8)
            if (r28 == 0) goto L_0x00eb
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ed
        L_0x00eb:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00ed:
            r5 = r5 | r28
        L_0x00ef:
            r10 = r13 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x00fa
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r29
            r11 = r47
            goto L_0x010f
        L_0x00fa:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r15 & r29
            r11 = r47
            if (r29 != 0) goto L_0x010f
            boolean r30 = r1.changed((java.lang.Object) r11)
            if (r30 == 0) goto L_0x010b
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010d
        L_0x010b:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x010d:
            r5 = r5 | r30
        L_0x010f:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x011a
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r5 = r5 | r31
            r2 = r48
            goto L_0x012f
        L_0x011a:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r15 & r31
            r2 = r48
            if (r31 != 0) goto L_0x012f
            boolean r31 = r1.changed((boolean) r2)
            if (r31 == 0) goto L_0x012b
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012d
        L_0x012b:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012d:
            r5 = r5 | r31
        L_0x012f:
            r2 = r13 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x013a
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r31
            r3 = r49
            goto L_0x014f
        L_0x013a:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r15 & r31
            r3 = r49
            if (r31 != 0) goto L_0x014f
            boolean r31 = r1.changed((int) r3)
            if (r31 == 0) goto L_0x014b
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014d
        L_0x014b:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014d:
            r5 = r5 | r31
        L_0x014f:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0158
            r23 = r14 | 6
            r4 = r50
            goto L_0x016e
        L_0x0158:
            r31 = r14 & 14
            r4 = r50
            if (r31 != 0) goto L_0x016c
            boolean r31 = r1.changed((java.lang.Object) r4)
            if (r31 == 0) goto L_0x0167
            r23 = 4
            goto L_0x0169
        L_0x0167:
            r23 = 2
        L_0x0169:
            r23 = r14 | r23
            goto L_0x016e
        L_0x016c:
            r23 = r14
        L_0x016e:
            r4 = r13 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0175
            r23 = r23 | 48
            goto L_0x0188
        L_0x0175:
            r31 = r14 & 112(0x70, float:1.57E-43)
            r6 = r51
            if (r31 != 0) goto L_0x0188
            boolean r31 = r1.changedInstance(r6)
            if (r31 == 0) goto L_0x0184
            r25 = 32
            goto L_0x0186
        L_0x0184:
            r25 = 16
        L_0x0186:
            r23 = r23 | r25
        L_0x0188:
            r6 = r23
            r7 = r13 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0191
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x01a5
        L_0x0191:
            r8 = r14 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01a5
            r8 = r52
            boolean r23 = r1.changed((java.lang.Object) r8)
            if (r23 == 0) goto L_0x01a0
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01a2
        L_0x01a0:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01a2:
            r6 = r6 | r29
            goto L_0x01a7
        L_0x01a5:
            r8 = r52
        L_0x01a7:
            r8 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01ae
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c0
        L_0x01ae:
            r11 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01c0
            r11 = r53
            boolean r23 = r1.changed((java.lang.Object) r11)
            if (r23 == 0) goto L_0x01bb
            goto L_0x01bd
        L_0x01bb:
            r17 = r18
        L_0x01bd:
            r6 = r6 | r17
            goto L_0x01c2
        L_0x01c0:
            r11 = r53
        L_0x01c2:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01cb
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r12 = r54
            goto L_0x01dc
        L_0x01cb:
            r17 = r14 & r22
            r12 = r54
            if (r17 != 0) goto L_0x01dc
            boolean r17 = r1.changedInstance(r12)
            if (r17 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d8:
            r20 = r21
        L_0x01da:
            r6 = r6 | r20
        L_0x01dc:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r5 & r17
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r13) goto L_0x0216
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r6
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x0216
            boolean r12 = r1.getSkipping()
            if (r12 != 0) goto L_0x01f5
            goto L_0x0216
        L_0x01f5:
            r1.skipToGroupEnd()
            r3 = r42
            r4 = r43
            r5 = r44
            r6 = r45
            r7 = r46
            r8 = r47
            r9 = r48
            r10 = r49
            r11 = r50
            r12 = r51
            r13 = r52
            r14 = r53
            r15 = r54
            r55 = r1
            goto L_0x0326
        L_0x0216:
            if (r9 == 0) goto L_0x021d
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            goto L_0x021f
        L_0x021d:
            r9 = r42
        L_0x021f:
            if (r16 == 0) goto L_0x0223
            r12 = 1
            goto L_0x0225
        L_0x0223:
            r12 = r43
        L_0x0225:
            if (r19 == 0) goto L_0x0229
            r13 = 0
            goto L_0x022b
        L_0x0229:
            r13 = r44
        L_0x022b:
            if (r24 == 0) goto L_0x0236
            androidx.compose.ui.text.TextStyle$Companion r16 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r16 = r16.getDefault()
            r36 = r16
            goto L_0x0238
        L_0x0236:
            r36 = r45
        L_0x0238:
            if (r26 == 0) goto L_0x0243
            androidx.compose.foundation.text.KeyboardOptions$Companion r16 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r16 = r16.getDefault()
            r37 = r16
            goto L_0x0245
        L_0x0243:
            r37 = r46
        L_0x0245:
            if (r10 == 0) goto L_0x024e
            androidx.compose.foundation.text.KeyboardActions$Companion r10 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r10 = r10.getDefault()
            goto L_0x0250
        L_0x024e:
            r10 = r47
        L_0x0250:
            if (r0 == 0) goto L_0x0254
            r0 = 0
            goto L_0x0256
        L_0x0254:
            r0 = r48
        L_0x0256:
            if (r2 == 0) goto L_0x025c
            r2 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x025e
        L_0x025c:
            r2 = r49
        L_0x025e:
            if (r3 == 0) goto L_0x0267
            androidx.compose.ui.text.input.VisualTransformation$Companion r3 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r3 = r3.getNone()
            goto L_0x0269
        L_0x0267:
            r3 = r50
        L_0x0269:
            if (r4 == 0) goto L_0x0270
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$10 r4 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$10.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            goto L_0x0272
        L_0x0270:
            r4 = r51
        L_0x0272:
            if (r7 == 0) goto L_0x0298
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            java.lang.Object r7 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r16.getEmpty()
            if (r7 != r14) goto L_0x0292
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r7)
        L_0x0292:
            r1.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = (androidx.compose.foundation.interaction.MutableInteractionSource) r7
            goto L_0x029a
        L_0x0298:
            r7 = r52
        L_0x029a:
            if (r8 == 0) goto L_0x02ae
            androidx.compose.ui.graphics.SolidColor r8 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r14.m3842getBlack0d7_KjU()
            r55 = r1
            r1 = 0
            r8.<init>(r14, r1)
            r1 = r8
            androidx.compose.ui.graphics.Brush r1 = (androidx.compose.ui.graphics.Brush) r1
            goto L_0x02b2
        L_0x02ae:
            r55 = r1
            r1 = r53
        L_0x02b2:
            if (r11 == 0) goto L_0x02bb
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r8 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r8 = r8.m1060getLambda3$foundation_release()
            goto L_0x02bd
        L_0x02bb:
            r8 = r54
        L_0x02bd:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x02cb
            java.lang.String r11 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:339)"
            r14 = -454732590(0xffffffffe4e554d2, float:-3.384333E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r5, r6, r11)
        L_0x02cb:
            r11 = 2147483646(0x7ffffffe, float:NaN)
            r33 = r5 & r11
            int r5 = r6 << 3
            r6 = r5 & 112(0x70, float:1.57E-43)
            r6 = r6 | 6
            r11 = r5 & 896(0x380, float:1.256E-42)
            r6 = r6 | r11
            r11 = r5 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r11
            r11 = r5 & r22
            r6 = r6 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r11
            r34 = r6 | r5
            r35 = 0
            r26 = 1
            r16 = r40
            r17 = r41
            r18 = r9
            r19 = r12
            r20 = r13
            r21 = r36
            r22 = r37
            r23 = r10
            r24 = r0
            r25 = r2
            r27 = r3
            r28 = r4
            r29 = r7
            r30 = r1
            r31 = r8
            r32 = r55
            BasicTextField((java.lang.String) r16, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r17, (androidx.compose.ui.Modifier) r18, (boolean) r19, (boolean) r20, (androidx.compose.ui.text.TextStyle) r21, (androidx.compose.foundation.text.KeyboardOptions) r22, (androidx.compose.foundation.text.KeyboardActions) r23, (boolean) r24, (int) r25, (int) r26, (androidx.compose.ui.text.input.VisualTransformation) r27, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r28, (androidx.compose.foundation.interaction.MutableInteractionSource) r29, (androidx.compose.ui.graphics.Brush) r30, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r31, (androidx.compose.runtime.Composer) r32, (int) r33, (int) r34, (int) r35)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0314
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0314:
            r14 = r1
            r11 = r3
            r15 = r8
            r3 = r9
            r8 = r10
            r5 = r13
            r6 = r36
            r9 = r0
            r10 = r2
            r13 = r7
            r7 = r37
            r39 = r12
            r12 = r4
            r4 = r39
        L_0x0326:
            androidx.compose.runtime.ScopeUpdateScope r2 = r55.endRestartGroup()
            if (r2 == 0) goto L_0x0348
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$12 r19 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$12
            r0 = r19
            r1 = r40
            r38 = r2
            r2 = r41
            r16 = r56
            r17 = r57
            r18 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r38
            r1.updateScope(r0)
        L_0x0348:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013a  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void BasicTextField(androidx.compose.ui.text.input.TextFieldValue r40, kotlin.jvm.functions.Function1 r41, androidx.compose.ui.Modifier r42, boolean r43, boolean r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.text.KeyboardOptions r46, androidx.compose.foundation.text.KeyboardActions r47, boolean r48, int r49, androidx.compose.ui.text.input.VisualTransformation r50, kotlin.jvm.functions.Function1 r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.ui.graphics.Brush r53, kotlin.jvm.functions.Function3 r54, androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            r15 = r56
            r14 = r57
            r13 = r58
            r0 = -560482651(0xffffffffde97b6a5, float:-5.4660533E18)
            r1 = r55
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)375@20462L39,380@20702L579:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r15 | 6
            r5 = r2
            r2 = r40
            goto L_0x0032
        L_0x001e:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x002f
            r2 = r40
            boolean r5 = r1.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x002c
            r5 = 4
            goto L_0x002d
        L_0x002c:
            r5 = 2
        L_0x002d:
            r5 = r5 | r15
            goto L_0x0032
        L_0x002f:
            r2 = r40
            r5 = r15
        L_0x0032:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r15 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            r6 = r41
            boolean r9 = r1.changedInstance(r6)
            if (r9 == 0) goto L_0x0048
            r9 = 32
            goto L_0x004a
        L_0x0048:
            r9 = 16
        L_0x004a:
            r5 = r5 | r9
            goto L_0x004e
        L_0x004c:
            r6 = r41
        L_0x004e:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0055
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0055:
            r12 = r15 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x0069
            r12 = r42
            boolean r16 = r1.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x0064
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r5 = r5 | r16
            goto L_0x006b
        L_0x0069:
            r12 = r42
        L_0x006b:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0076
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0076:
            r3 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x008a
            r3 = r43
            boolean r19 = r1.changed((boolean) r3)
            if (r19 == 0) goto L_0x0085
            r19 = r17
            goto L_0x0087
        L_0x0085:
            r19 = r18
        L_0x0087:
            r5 = r5 | r19
            goto L_0x008c
        L_0x008a:
            r3 = r43
        L_0x008c:
            r19 = r13 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x009c
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r4 = r44
            goto L_0x00af
        L_0x009c:
            r23 = r15 & r22
            r4 = r44
            if (r23 != 0) goto L_0x00af
            boolean r24 = r1.changed((boolean) r4)
            if (r24 == 0) goto L_0x00ab
            r24 = r20
            goto L_0x00ad
        L_0x00ab:
            r24 = r21
        L_0x00ad:
            r5 = r5 | r24
        L_0x00af:
            r24 = r13 & 32
            if (r24 == 0) goto L_0x00ba
            r25 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r25
            r7 = r45
            goto L_0x00cf
        L_0x00ba:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r15 & r25
            r7 = r45
            if (r25 != 0) goto L_0x00cf
            boolean r26 = r1.changed((java.lang.Object) r7)
            if (r26 == 0) goto L_0x00cb
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cd
        L_0x00cb:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00cd:
            r5 = r5 | r26
        L_0x00cf:
            r26 = r13 & 64
            if (r26 == 0) goto L_0x00da
            r27 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r27
            r8 = r46
            goto L_0x00ef
        L_0x00da:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r15 & r27
            r8 = r46
            if (r27 != 0) goto L_0x00ef
            boolean r28 = r1.changed((java.lang.Object) r8)
            if (r28 == 0) goto L_0x00eb
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ed
        L_0x00eb:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00ed:
            r5 = r5 | r28
        L_0x00ef:
            r10 = r13 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x00fa
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r29
            r11 = r47
            goto L_0x010f
        L_0x00fa:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r15 & r29
            r11 = r47
            if (r29 != 0) goto L_0x010f
            boolean r30 = r1.changed((java.lang.Object) r11)
            if (r30 == 0) goto L_0x010b
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010d
        L_0x010b:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x010d:
            r5 = r5 | r30
        L_0x010f:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x011a
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r5 = r5 | r31
            r2 = r48
            goto L_0x012f
        L_0x011a:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r15 & r31
            r2 = r48
            if (r31 != 0) goto L_0x012f
            boolean r31 = r1.changed((boolean) r2)
            if (r31 == 0) goto L_0x012b
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012d
        L_0x012b:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012d:
            r5 = r5 | r31
        L_0x012f:
            r2 = r13 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x013a
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r31
            r3 = r49
            goto L_0x014f
        L_0x013a:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r15 & r31
            r3 = r49
            if (r31 != 0) goto L_0x014f
            boolean r31 = r1.changed((int) r3)
            if (r31 == 0) goto L_0x014b
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014d
        L_0x014b:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014d:
            r5 = r5 | r31
        L_0x014f:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0158
            r23 = r14 | 6
            r4 = r50
            goto L_0x016e
        L_0x0158:
            r31 = r14 & 14
            r4 = r50
            if (r31 != 0) goto L_0x016c
            boolean r31 = r1.changed((java.lang.Object) r4)
            if (r31 == 0) goto L_0x0167
            r23 = 4
            goto L_0x0169
        L_0x0167:
            r23 = 2
        L_0x0169:
            r23 = r14 | r23
            goto L_0x016e
        L_0x016c:
            r23 = r14
        L_0x016e:
            r4 = r13 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0175
            r23 = r23 | 48
            goto L_0x0188
        L_0x0175:
            r31 = r14 & 112(0x70, float:1.57E-43)
            r6 = r51
            if (r31 != 0) goto L_0x0188
            boolean r31 = r1.changedInstance(r6)
            if (r31 == 0) goto L_0x0184
            r25 = 32
            goto L_0x0186
        L_0x0184:
            r25 = 16
        L_0x0186:
            r23 = r23 | r25
        L_0x0188:
            r6 = r23
            r7 = r13 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0191
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x01a5
        L_0x0191:
            r8 = r14 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01a5
            r8 = r52
            boolean r23 = r1.changed((java.lang.Object) r8)
            if (r23 == 0) goto L_0x01a0
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01a2
        L_0x01a0:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01a2:
            r6 = r6 | r29
            goto L_0x01a7
        L_0x01a5:
            r8 = r52
        L_0x01a7:
            r8 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01ae
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c0
        L_0x01ae:
            r11 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01c0
            r11 = r53
            boolean r23 = r1.changed((java.lang.Object) r11)
            if (r23 == 0) goto L_0x01bb
            goto L_0x01bd
        L_0x01bb:
            r17 = r18
        L_0x01bd:
            r6 = r6 | r17
            goto L_0x01c2
        L_0x01c0:
            r11 = r53
        L_0x01c2:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01cb
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r12 = r54
            goto L_0x01dc
        L_0x01cb:
            r17 = r14 & r22
            r12 = r54
            if (r17 != 0) goto L_0x01dc
            boolean r17 = r1.changedInstance(r12)
            if (r17 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d8:
            r20 = r21
        L_0x01da:
            r6 = r6 | r20
        L_0x01dc:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r5 & r17
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r13) goto L_0x0216
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r6
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x0216
            boolean r12 = r1.getSkipping()
            if (r12 != 0) goto L_0x01f5
            goto L_0x0216
        L_0x01f5:
            r1.skipToGroupEnd()
            r3 = r42
            r4 = r43
            r5 = r44
            r6 = r45
            r7 = r46
            r8 = r47
            r9 = r48
            r10 = r49
            r11 = r50
            r12 = r51
            r13 = r52
            r14 = r53
            r15 = r54
            r55 = r1
            goto L_0x0326
        L_0x0216:
            if (r9 == 0) goto L_0x021d
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            goto L_0x021f
        L_0x021d:
            r9 = r42
        L_0x021f:
            if (r16 == 0) goto L_0x0223
            r12 = 1
            goto L_0x0225
        L_0x0223:
            r12 = r43
        L_0x0225:
            if (r19 == 0) goto L_0x0229
            r13 = 0
            goto L_0x022b
        L_0x0229:
            r13 = r44
        L_0x022b:
            if (r24 == 0) goto L_0x0236
            androidx.compose.ui.text.TextStyle$Companion r16 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r16 = r16.getDefault()
            r36 = r16
            goto L_0x0238
        L_0x0236:
            r36 = r45
        L_0x0238:
            if (r26 == 0) goto L_0x0243
            androidx.compose.foundation.text.KeyboardOptions$Companion r16 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r16 = r16.getDefault()
            r37 = r16
            goto L_0x0245
        L_0x0243:
            r37 = r46
        L_0x0245:
            if (r10 == 0) goto L_0x024e
            androidx.compose.foundation.text.KeyboardActions$Companion r10 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r10 = r10.getDefault()
            goto L_0x0250
        L_0x024e:
            r10 = r47
        L_0x0250:
            if (r0 == 0) goto L_0x0254
            r0 = 0
            goto L_0x0256
        L_0x0254:
            r0 = r48
        L_0x0256:
            if (r2 == 0) goto L_0x025c
            r2 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x025e
        L_0x025c:
            r2 = r49
        L_0x025e:
            if (r3 == 0) goto L_0x0267
            androidx.compose.ui.text.input.VisualTransformation$Companion r3 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r3 = r3.getNone()
            goto L_0x0269
        L_0x0267:
            r3 = r50
        L_0x0269:
            if (r4 == 0) goto L_0x0270
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$13 r4 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$13.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            goto L_0x0272
        L_0x0270:
            r4 = r51
        L_0x0272:
            if (r7 == 0) goto L_0x0298
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            java.lang.Object r7 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r16.getEmpty()
            if (r7 != r14) goto L_0x0292
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r7)
        L_0x0292:
            r1.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = (androidx.compose.foundation.interaction.MutableInteractionSource) r7
            goto L_0x029a
        L_0x0298:
            r7 = r52
        L_0x029a:
            if (r8 == 0) goto L_0x02ae
            androidx.compose.ui.graphics.SolidColor r8 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r14.m3842getBlack0d7_KjU()
            r55 = r1
            r1 = 0
            r8.<init>(r14, r1)
            r1 = r8
            androidx.compose.ui.graphics.Brush r1 = (androidx.compose.ui.graphics.Brush) r1
            goto L_0x02b2
        L_0x02ae:
            r55 = r1
            r1 = r53
        L_0x02b2:
            if (r11 == 0) goto L_0x02bb
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r8 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r8 = r8.m1061getLambda4$foundation_release()
            goto L_0x02bd
        L_0x02bb:
            r8 = r54
        L_0x02bd:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x02cb
            java.lang.String r11 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:379)"
            r14 = -560482651(0xffffffffde97b6a5, float:-5.4660533E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r5, r6, r11)
        L_0x02cb:
            r11 = 2147483646(0x7ffffffe, float:NaN)
            r33 = r5 & r11
            int r5 = r6 << 3
            r6 = r5 & 112(0x70, float:1.57E-43)
            r6 = r6 | 6
            r11 = r5 & 896(0x380, float:1.256E-42)
            r6 = r6 | r11
            r11 = r5 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r11
            r11 = r5 & r22
            r6 = r6 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r11
            r34 = r6 | r5
            r35 = 0
            r26 = 1
            r16 = r40
            r17 = r41
            r18 = r9
            r19 = r12
            r20 = r13
            r21 = r36
            r22 = r37
            r23 = r10
            r24 = r0
            r25 = r2
            r27 = r3
            r28 = r4
            r29 = r7
            r30 = r1
            r31 = r8
            r32 = r55
            BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r16, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r17, (androidx.compose.ui.Modifier) r18, (boolean) r19, (boolean) r20, (androidx.compose.ui.text.TextStyle) r21, (androidx.compose.foundation.text.KeyboardOptions) r22, (androidx.compose.foundation.text.KeyboardActions) r23, (boolean) r24, (int) r25, (int) r26, (androidx.compose.ui.text.input.VisualTransformation) r27, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r28, (androidx.compose.foundation.interaction.MutableInteractionSource) r29, (androidx.compose.ui.graphics.Brush) r30, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r31, (androidx.compose.runtime.Composer) r32, (int) r33, (int) r34, (int) r35)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0314
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0314:
            r14 = r1
            r11 = r3
            r15 = r8
            r3 = r9
            r8 = r10
            r5 = r13
            r6 = r36
            r9 = r0
            r10 = r2
            r13 = r7
            r7 = r37
            r39 = r12
            r12 = r4
            r4 = r39
        L_0x0326:
            androidx.compose.runtime.ScopeUpdateScope r2 = r55.endRestartGroup()
            if (r2 == 0) goto L_0x0348
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$15 r19 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$15
            r0 = r19
            r1 = r40
            r38 = r2
            r2 = r41
            r16 = r56
            r17 = r57
            r18 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r38
            r1.updateScope(r0)
        L_0x0348:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void BasicTextField$lambda$3(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* access modifiers changed from: private */
    public static final void BasicTextField$lambda$7(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }
}
