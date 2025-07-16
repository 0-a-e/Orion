package androidx.compose.foundation.text2;

import androidx.compose.foundation.text.AndroidCursorHandle_androidKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001aÙ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u001628\b\u0002\u0010\u0017\u001a2\u0012\u0004\u0012\u00020\u0019\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018¢\u0006\u0002\b\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010)\u001aí\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00050-2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u001628\b\u0002\u0010\u0017\u001a2\u0012\u0004\u0012\u00020\u0019\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018¢\u0006\u0002\b\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010.\u001a\u0015\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\u00102\u001a\u0015\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\u00102\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u00064²\u0006\n\u00105\u001a\u000206X\u0002"}, d2 = {"DefaultTextFieldDecorator", "Landroidx/compose/foundation/text2/TextFieldDecorator;", "getDefaultTextFieldDecorator$annotations", "()V", "BasicTextField2", "", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "lineLimits", "Landroidx/compose/foundation/text2/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "codepointTransformation", "Landroidx/compose/foundation/text2/input/CodepointTransformation;", "decorator", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text2/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/foundation/text2/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text2/input/CodepointTransformation;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "value", "", "onValueChange", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/foundation/text2/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text2/input/CodepointTransformation;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "TextFieldCursorHandle", "selectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "(Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "foundation_release", "valueWithSelection", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField2.kt */
public final class BasicTextField2Kt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = BasicTextField2Kt$DefaultTextFieldDecorator$1.INSTANCE;

    private static /* synthetic */ void getDefaultTextFieldDecorator$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:245:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField2(java.lang.String r39, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r40, androidx.compose.ui.Modifier r41, boolean r42, boolean r43, androidx.compose.foundation.text2.input.InputTransformation r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.text.KeyboardOptions r46, androidx.compose.foundation.text.KeyboardActions r47, androidx.compose.foundation.text2.input.TextFieldLineLimits r48, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.ui.graphics.Brush r51, androidx.compose.foundation.text2.input.CodepointTransformation r52, androidx.compose.foundation.text2.TextFieldDecorator r53, androidx.compose.foundation.ScrollState r54, androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            r1 = r39
            r2 = r40
            r15 = r56
            r14 = r57
            r13 = r58
            r0 = -797091052(0xffffffffd07d5b14, float:-1.70024182E10)
            r3 = r55
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(BasicTextField2)P(15,11,9,3,12,4,14,7,6,8,10,5,1)186@11484L21,190@11642L213,200@12048L174,210@12291L1011:BasicTextField2.kt#g98mwb"
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
            r12 = r41
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
            r12 = r41
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
            r5 = r42
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
            r5 = r42
        L_0x0084:
            r19 = r13 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x0094
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r8 = r43
            goto L_0x00a7
        L_0x0094:
            r23 = r15 & r22
            r8 = r43
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
            r9 = r44
            goto L_0x00c7
        L_0x00b4:
            r26 = r15 & r25
            r9 = r44
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
            r10 = r45
            goto L_0x00e7
        L_0x00d2:
            r28 = 3670016(0x380000, float:5.142788E-39)
            r28 = r15 & r28
            r10 = r45
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
            r6 = r46
            goto L_0x0107
        L_0x00f2:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r15 & r30
            r6 = r46
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
            r5 = r47
            goto L_0x0127
        L_0x0112:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r15 & r32
            r5 = r47
            if (r32 != 0) goto L_0x0127
            boolean r32 = r3.changed((java.lang.Object) r5)
            if (r32 == 0) goto L_0x0123
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r4 = r4 | r32
        L_0x0127:
            r5 = r13 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0132
            r32 = 805306368(0x30000000, float:4.656613E-10)
            r4 = r4 | r32
            r6 = r48
            goto L_0x0147
        L_0x0132:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r15 & r32
            r6 = r48
            if (r32 != 0) goto L_0x0147
            boolean r32 = r3.changed((java.lang.Object) r6)
            if (r32 == 0) goto L_0x0143
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0145
        L_0x0143:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0145:
            r4 = r4 | r32
        L_0x0147:
            r6 = r13 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0150
            r32 = r14 | 6
            r8 = r49
            goto L_0x0166
        L_0x0150:
            r32 = r14 & 14
            r8 = r49
            if (r32 != 0) goto L_0x0164
            boolean r32 = r3.changedInstance(r8)
            if (r32 == 0) goto L_0x015f
            r32 = 4
            goto L_0x0161
        L_0x015f:
            r32 = 2
        L_0x0161:
            r32 = r14 | r32
            goto L_0x0166
        L_0x0164:
            r32 = r14
        L_0x0166:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x016d
            r32 = r32 | 48
            goto L_0x0180
        L_0x016d:
            r33 = r14 & 112(0x70, float:1.57E-43)
            r9 = r50
            if (r33 != 0) goto L_0x0180
            boolean r33 = r3.changed((java.lang.Object) r9)
            if (r33 == 0) goto L_0x017c
            r23 = 32
            goto L_0x017e
        L_0x017c:
            r23 = 16
        L_0x017e:
            r32 = r32 | r23
        L_0x0180:
            r9 = r32
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0189
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x019d
        L_0x0189:
            r12 = r14 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x019d
            r12 = r51
            boolean r23 = r3.changed((java.lang.Object) r12)
            if (r23 == 0) goto L_0x0198
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x019a
        L_0x0198:
            r28 = 128(0x80, float:1.794E-43)
        L_0x019a:
            r9 = r9 | r28
            goto L_0x019f
        L_0x019d:
            r12 = r51
        L_0x019f:
            r12 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01a6
            r9 = r9 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b8
        L_0x01a6:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x01b8
            r2 = r52
            boolean r23 = r3.changed((java.lang.Object) r2)
            if (r23 == 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b3:
            r17 = r18
        L_0x01b5:
            r9 = r9 | r17
            goto L_0x01ba
        L_0x01b8:
            r2 = r52
        L_0x01ba:
            r2 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x01c3
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            r1 = r53
            goto L_0x01d4
        L_0x01c3:
            r17 = r14 & r22
            r1 = r53
            if (r17 != 0) goto L_0x01d4
            boolean r17 = r3.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r20 = r21
        L_0x01d2:
            r9 = r9 | r20
        L_0x01d4:
            r17 = r14 & r25
            r18 = 32768(0x8000, float:4.5918E-41)
            if (r17 != 0) goto L_0x01ef
            r17 = r13 & r18
            r1 = r54
            if (r17 != 0) goto L_0x01ea
            boolean r17 = r3.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x01ea
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01ec
        L_0x01ea:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x01ec:
            r9 = r9 | r17
            goto L_0x01f1
        L_0x01ef:
            r1 = r54
        L_0x01f1:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r4 & r17
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r14) goto L_0x022e
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r9
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r14) goto L_0x022e
            boolean r1 = r3.getSkipping()
            if (r1 != 0) goto L_0x020b
            goto L_0x022e
        L_0x020b:
            r3.skipToGroupEnd()
            r15 = r40
            r4 = r41
            r5 = r42
            r6 = r43
            r7 = r44
            r8 = r45
            r11 = r46
            r9 = r47
            r10 = r48
            r12 = r49
            r13 = r50
            r14 = r51
            r35 = r52
            r36 = r53
            r16 = r54
            goto L_0x046a
        L_0x022e:
            r3.startDefaults()
            r1 = r15 & 1
            r14 = 0
            if (r1 == 0) goto L_0x0267
            boolean r1 = r3.getDefaultsInvalid()
            if (r1 == 0) goto L_0x023d
            goto L_0x0267
        L_0x023d:
            r3.skipToGroupEnd()
            r0 = r13 & r18
            if (r0 == 0) goto L_0x0248
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r9 = r9 & r0
        L_0x0248:
            r1 = r41
            r0 = r42
            r2 = r43
            r5 = r44
            r6 = r45
            r11 = r46
            r7 = r47
            r8 = r48
            r10 = r50
            r12 = r51
            r35 = r52
            r36 = r53
            r37 = r54
            r14 = r9
            r9 = r49
            goto L_0x0319
        L_0x0267:
            if (r7 == 0) goto L_0x026e
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0270
        L_0x026e:
            r1 = r41
        L_0x0270:
            if (r16 == 0) goto L_0x0275
            r16 = 1
            goto L_0x0277
        L_0x0275:
            r16 = r42
        L_0x0277:
            if (r19 == 0) goto L_0x027c
            r17 = 0
            goto L_0x027e
        L_0x027c:
            r17 = r43
        L_0x027e:
            if (r24 == 0) goto L_0x0283
            r19 = r14
            goto L_0x0285
        L_0x0283:
            r19 = r44
        L_0x0285:
            if (r27 == 0) goto L_0x028e
            androidx.compose.ui.text.TextStyle$Companion r20 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r20 = r20.getDefault()
            goto L_0x0290
        L_0x028e:
            r20 = r45
        L_0x0290:
            if (r11 == 0) goto L_0x0299
            androidx.compose.foundation.text.KeyboardOptions$Companion r11 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r11 = r11.getDefault()
            goto L_0x029b
        L_0x0299:
            r11 = r46
        L_0x029b:
            if (r0 == 0) goto L_0x02a4
            androidx.compose.foundation.text.KeyboardActions$Companion r0 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r0 = r0.getDefault()
            goto L_0x02a6
        L_0x02a4:
            r0 = r47
        L_0x02a6:
            if (r5 == 0) goto L_0x02af
            androidx.compose.foundation.text2.input.TextFieldLineLimits$Companion r5 = androidx.compose.foundation.text2.input.TextFieldLineLimits.Companion
            androidx.compose.foundation.text2.input.TextFieldLineLimits r5 = r5.getDefault()
            goto L_0x02b1
        L_0x02af:
            r5 = r48
        L_0x02b1:
            if (r6 == 0) goto L_0x02b5
            r6 = r14
            goto L_0x02b7
        L_0x02b5:
            r6 = r49
        L_0x02b7:
            if (r8 == 0) goto L_0x02bb
            r8 = r14
            goto L_0x02bd
        L_0x02bb:
            r8 = r50
        L_0x02bd:
            if (r10 == 0) goto L_0x02d0
            androidx.compose.ui.graphics.SolidColor r10 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r21 = androidx.compose.ui.graphics.Color.Companion
            r42 = r8
            long r7 = r21.m3842getBlack0d7_KjU()
            r10.<init>(r7, r14)
            r7 = r10
            androidx.compose.ui.graphics.Brush r7 = (androidx.compose.ui.graphics.Brush) r7
            goto L_0x02d4
        L_0x02d0:
            r42 = r8
            r7 = r51
        L_0x02d4:
            if (r12 == 0) goto L_0x02d8
            r8 = r14
            goto L_0x02da
        L_0x02d8:
            r8 = r52
        L_0x02da:
            if (r2 == 0) goto L_0x02de
            r2 = r14
            goto L_0x02e0
        L_0x02de:
            r2 = r53
        L_0x02e0:
            r10 = r13 & r18
            if (r10 == 0) goto L_0x0304
            r10 = 0
            r12 = 1
            androidx.compose.foundation.ScrollState r12 = androidx.compose.foundation.ScrollKt.rememberScrollState(r10, r3, r10, r12)
            r10 = -458753(0xfffffffffff8ffff, float:NaN)
            r9 = r9 & r10
            r10 = r42
            r36 = r2
            r35 = r8
            r14 = r9
            r37 = r12
            r2 = r17
            r8 = r5
            r9 = r6
            r12 = r7
            r5 = r19
            r6 = r20
            r7 = r0
            r0 = r16
            goto L_0x0319
        L_0x0304:
            r10 = r42
            r37 = r54
            r36 = r2
            r12 = r7
            r35 = r8
            r14 = r9
            r2 = r17
            r7 = r0
            r8 = r5
            r9 = r6
            r0 = r16
            r5 = r19
            r6 = r20
        L_0x0319:
            r3.endDefaults()
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x032a
            java.lang.String r13 = "androidx.compose.foundation.text2.BasicTextField2 (BasicTextField2.kt:189)"
            r15 = -797091052(0xffffffffd07d5b14, float:-1.70024182E10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r4, r14, r13)
        L_0x032a:
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r13)
            java.lang.Object r13 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r13 != r15) goto L_0x035b
            androidx.compose.foundation.text2.input.TextFieldState r13 = new androidx.compose.foundation.text2.input.TextFieldState
            int r15 = r39.length()
            r48 = r9
            r49 = r10
            long r9 = androidx.compose.ui.text.TextRangeKt.TextRange(r15)
            r15 = r39
            r50 = r12
            r12 = 0
            r13.<init>((java.lang.String) r15, (long) r9, (kotlin.jvm.internal.DefaultConstructorMarker) r12)
            r3.updateRememberedValue(r13)
            goto L_0x0363
        L_0x035b:
            r15 = r39
            r48 = r9
            r49 = r10
            r50 = r12
        L_0x0363:
            r3.endReplaceableGroup()
            r9 = r13
            androidx.compose.foundation.text2.input.TextFieldState r9 = (androidx.compose.foundation.text2.input.TextFieldState) r9
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r10)
            java.lang.Object r10 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x03a8
            androidx.compose.ui.text.input.TextFieldValue r10 = new androidx.compose.ui.text.input.TextFieldValue
            int r12 = r39.length()
            long r12 = androidx.compose.ui.text.TextRangeKt.TextRange(r12)
            r17 = 4
            r18 = 0
            r19 = 0
            r41 = r10
            r42 = r39
            r43 = r12
            r45 = r19
            r46 = r17
            r47 = r18
            r41.<init>((java.lang.String) r42, (long) r43, (androidx.compose.ui.text.TextRange) r45, (int) r46, (kotlin.jvm.internal.DefaultConstructorMarker) r47)
            r12 = 2
            r13 = 0
            androidx.compose.runtime.MutableState r10 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r10, r13, r12, r13)
            r3.updateRememberedValue(r10)
        L_0x03a8:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r10 = (androidx.compose.runtime.MutableState) r10
            androidx.compose.ui.text.input.TextFieldValue r12 = BasicTextField2$lambda$2(r10)
            r13 = 6
            r16 = 0
            r17 = 0
            r19 = 0
            r41 = r12
            r42 = r39
            r43 = r17
            r45 = r19
            r46 = r13
            r47 = r16
            androidx.compose.ui.text.input.TextFieldValue r12 = androidx.compose.ui.text.input.TextFieldValue.m6295copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r41, (java.lang.String) r42, (long) r43, (androidx.compose.ui.text.TextRange) r45, (int) r46, (java.lang.Object) r47)
            BasicTextField2$lambda$3(r10, r12)
            androidx.compose.ui.text.input.TextFieldValue r12 = BasicTextField2$lambda$2(r10)
            r13 = 1290401378(0x4ce9f662, float:1.22663696E8)
            r3.startReplaceableGroup(r13)
            boolean r13 = r3.changed((java.lang.Object) r10)
            r15 = r40
            boolean r16 = r3.changedInstance(r15)
            r13 = r13 | r16
            r41 = r8
            java.lang.Object r8 = r3.rememberedValue()
            if (r13 != 0) goto L_0x03f1
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r8 != r13) goto L_0x03fb
        L_0x03f1:
            androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$1$1 r8 = new androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$1$1
            r8.<init>(r15, r10)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r3.updateRememberedValue(r8)
        L_0x03fb:
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r3.endReplaceableGroup()
            r10 = 0
            androidx.compose.ui.Modifier r17 = androidx.compose.foundation.text2.input.internal.StateSyncingModifierKt.syncTextFieldState(r1, r9, r12, r8, r10)
            int r4 = r4 >> 3
            r8 = r4 & 896(0x380, float:1.256E-42)
            r8 = r8 | 6
            r10 = r4 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r10
            r10 = r4 & r22
            r8 = r8 | r10
            r10 = r4 & r25
            r8 = r8 | r10
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r4
            r8 = r8 | r10
            r10 = 29360128(0x1c00000, float:7.052966E-38)
            r10 = r10 & r4
            r8 = r8 | r10
            r10 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r10
            r4 = r4 | r8
            int r8 = r14 << 27
            r10 = 1879048192(0x70000000, float:1.58456325E29)
            r8 = r8 & r10
            r32 = r4 | r8
            int r4 = r14 >> 3
            r8 = 65534(0xfffe, float:9.1833E-41)
            r33 = r4 & r8
            r34 = 0
            r16 = r9
            r18 = r0
            r19 = r2
            r20 = r5
            r21 = r6
            r22 = r11
            r23 = r7
            r24 = r41
            r25 = r48
            r26 = r49
            r27 = r50
            r28 = r35
            r29 = r36
            r30 = r37
            r31 = r3
            BasicTextField2(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x045a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x045a:
            r10 = r41
            r12 = r48
            r13 = r49
            r14 = r50
            r4 = r1
            r8 = r6
            r9 = r7
            r16 = r37
            r6 = r2
            r7 = r5
            r5 = r0
        L_0x046a:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 == 0) goto L_0x049a
            androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$2 r20 = new androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$2
            r0 = r20
            r1 = r39
            r2 = r40
            r15 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r35
            r38 = r15
            r15 = r36
            r17 = r56
            r18 = r57
            r19 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r38
            r1.updateScope(r0)
        L_0x049a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.BasicTextField2Kt.BasicTextField2(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text2.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.foundation.text2.input.TextFieldLineLimits, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text2.input.CodepointTransformation, androidx.compose.foundation.text2.TextFieldDecorator, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue BasicTextField2$lambda$2(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: androidx.compose.foundation.text2.TextFieldDecorator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: androidx.compose.foundation.text2.TextFieldDecorator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: androidx.compose.foundation.text2.input.CodepointTransformation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v21, resolved type: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v8, resolved type: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState} */
    /* JADX WARNING: type inference failed for: r14v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x03c0, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x03c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0426, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0428;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0633  */
    /* JADX WARNING: Removed duplicated region for block: B:288:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField2(androidx.compose.foundation.text2.input.TextFieldState r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.foundation.text2.input.InputTransformation r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, androidx.compose.foundation.text2.input.TextFieldLineLimits r45, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.ui.graphics.Brush r48, androidx.compose.foundation.text2.input.CodepointTransformation r49, androidx.compose.foundation.text2.TextFieldDecorator r50, androidx.compose.foundation.ScrollState r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r1 = r37
            r15 = r53
            r14 = r54
            r13 = r55
            r0 = 437246650(0x1a0fdaba, float:2.9748393E-23)
            r2 = r52
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(BasicTextField2)P(13,9,3,11,4,14,7,6,8,10,5,1)331@19539L21,335@19712L7,336@19767L7,337@19812L7,343@20182L25,346@20295L598,357@21091L48,359@21175L319,369@21547L7,370@21611L7,371@21665L7,372@21677L440,385@22123L125,423@23614L2468:BasicTextField2.kt#g98mwb"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x001d
            r3 = r15 | 6
            goto L_0x002d
        L_0x001d:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0029
            r3 = 4
            goto L_0x002a
        L_0x0029:
            r3 = 2
        L_0x002a:
            r3 = r3 | r15
            goto L_0x002d
        L_0x002c:
            r3 = r15
        L_0x002d:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0047
        L_0x0034:
            r9 = r15 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x0047
            r9 = r38
            boolean r10 = r2.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0043
            r10 = 32
            goto L_0x0045
        L_0x0043:
            r10 = 16
        L_0x0045:
            r3 = r3 | r10
            goto L_0x0049
        L_0x0047:
            r9 = r38
        L_0x0049:
            r10 = r13 & 4
            if (r10 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0050:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0064
            r4 = r39
            boolean r16 = r2.changed((boolean) r4)
            if (r16 == 0) goto L_0x005f
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r16
            goto L_0x0066
        L_0x0064:
            r4 = r39
        L_0x0066:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0071
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0071:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0085
            r5 = r40
            boolean r20 = r2.changed((boolean) r5)
            if (r20 == 0) goto L_0x0080
            r20 = r17
            goto L_0x0082
        L_0x0080:
            r20 = r18
        L_0x0082:
            r3 = r3 | r20
            goto L_0x0087
        L_0x0085:
            r5 = r40
        L_0x0087:
            r20 = r13 & 16
            r21 = 8192(0x2000, float:1.14794E-41)
            r22 = 16384(0x4000, float:2.2959E-41)
            if (r20 == 0) goto L_0x0094
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r7 = r41
            goto L_0x00aa
        L_0x0094:
            r23 = 57344(0xe000, float:8.0356E-41)
            r23 = r15 & r23
            r7 = r41
            if (r23 != 0) goto L_0x00aa
            boolean r24 = r2.changed((java.lang.Object) r7)
            if (r24 == 0) goto L_0x00a6
            r24 = r22
            goto L_0x00a8
        L_0x00a6:
            r24 = r21
        L_0x00a8:
            r3 = r3 | r24
        L_0x00aa:
            r24 = r13 & 32
            if (r24 == 0) goto L_0x00b5
            r25 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r25
            r8 = r42
            goto L_0x00ca
        L_0x00b5:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r15 & r25
            r8 = r42
            if (r25 != 0) goto L_0x00ca
            boolean r26 = r2.changed((java.lang.Object) r8)
            if (r26 == 0) goto L_0x00c6
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r3 = r3 | r26
        L_0x00ca:
            r26 = r13 & 64
            if (r26 == 0) goto L_0x00d5
            r27 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r27
            r11 = r43
            goto L_0x00ea
        L_0x00d5:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r15 & r27
            r11 = r43
            if (r27 != 0) goto L_0x00ea
            boolean r28 = r2.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x00e6
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e8
        L_0x00e6:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00e8:
            r3 = r3 | r28
        L_0x00ea:
            r12 = r13 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x00f5
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r29
            r0 = r44
            goto L_0x010a
        L_0x00f5:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r15 & r29
            r0 = r44
            if (r29 != 0) goto L_0x010a
            boolean r30 = r2.changed((java.lang.Object) r0)
            if (r30 == 0) goto L_0x0106
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0108
        L_0x0106:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0108:
            r3 = r3 | r30
        L_0x010a:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0115
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r30
            r4 = r45
            goto L_0x012a
        L_0x0115:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r15 & r30
            r4 = r45
            if (r30 != 0) goto L_0x012a
            boolean r30 = r2.changed((java.lang.Object) r4)
            if (r30 == 0) goto L_0x0126
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0128
        L_0x0126:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0128:
            r3 = r3 | r30
        L_0x012a:
            r4 = r13 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0135
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r30
            r5 = r46
            goto L_0x014a
        L_0x0135:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r15 & r30
            r5 = r46
            if (r30 != 0) goto L_0x014a
            boolean r30 = r2.changedInstance(r5)
            if (r30 == 0) goto L_0x0146
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0148
        L_0x0146:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0148:
            r3 = r3 | r30
        L_0x014a:
            r5 = r13 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0153
            r19 = r14 | 6
            r7 = r47
            goto L_0x0169
        L_0x0153:
            r30 = r14 & 14
            r7 = r47
            if (r30 != 0) goto L_0x0167
            boolean r30 = r2.changed((java.lang.Object) r7)
            if (r30 == 0) goto L_0x0162
            r19 = 4
            goto L_0x0164
        L_0x0162:
            r19 = 2
        L_0x0164:
            r19 = r14 | r19
            goto L_0x0169
        L_0x0167:
            r19 = r14
        L_0x0169:
            r7 = r13 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0170
            r19 = r19 | 48
            goto L_0x0183
        L_0x0170:
            r30 = r14 & 112(0x70, float:1.57E-43)
            r8 = r48
            if (r30 != 0) goto L_0x0183
            boolean r30 = r2.changed((java.lang.Object) r8)
            if (r30 == 0) goto L_0x017f
            r23 = 32
            goto L_0x0181
        L_0x017f:
            r23 = 16
        L_0x0181:
            r19 = r19 | r23
        L_0x0183:
            r8 = r19
            r9 = r13 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x018c
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x01a0
        L_0x018c:
            r11 = r14 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01a0
            r11 = r49
            boolean r19 = r2.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x019b
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x019d
        L_0x019b:
            r27 = 128(0x80, float:1.794E-43)
        L_0x019d:
            r8 = r8 | r27
            goto L_0x01a2
        L_0x01a0:
            r11 = r49
        L_0x01a2:
            r11 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01a9
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01bb
        L_0x01a9:
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x01bb
            r1 = r50
            boolean r19 = r2.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x01b6
            goto L_0x01b8
        L_0x01b6:
            r17 = r18
        L_0x01b8:
            r8 = r8 | r17
            goto L_0x01bd
        L_0x01bb:
            r1 = r50
        L_0x01bd:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r14 & r17
            if (r17 != 0) goto L_0x01d8
            r1 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r1 != 0) goto L_0x01d3
            r1 = r51
            boolean r17 = r2.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x01d5
            r21 = r22
            goto L_0x01d5
        L_0x01d3:
            r1 = r51
        L_0x01d5:
            r8 = r8 | r21
            goto L_0x01da
        L_0x01d8:
            r1 = r51
        L_0x01da:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r3 & r17
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r14) goto L_0x0214
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r8
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r14) goto L_0x0214
            boolean r1 = r2.getSkipping()
            if (r1 != 0) goto L_0x01f3
            goto L_0x0214
        L_0x01f3:
            r2.skipToGroupEnd()
            r25 = r38
            r3 = r39
            r4 = r40
            r5 = r41
            r6 = r42
            r7 = r43
            r8 = r44
            r9 = r45
            r10 = r46
            r11 = r47
            r12 = r48
            r13 = r49
            r14 = r50
            r15 = r51
            goto L_0x062d
        L_0x0214:
            r2.startDefaults()
            r1 = r15 & 1
            if (r1 == 0) goto L_0x024d
            boolean r1 = r2.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0222
            goto L_0x024d
        L_0x0222:
            r2.skipToGroupEnd()
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x022d
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r0
        L_0x022d:
            r1 = r38
            r6 = r39
            r10 = r40
            r4 = r41
            r18 = r42
            r19 = r43
            r12 = r44
            r5 = r45
            r7 = r46
            r9 = r48
            r11 = r49
            r14 = r50
            r20 = r51
            r15 = r8
            r0 = 0
            r8 = r47
            goto L_0x02e0
        L_0x024d:
            if (r6 == 0) goto L_0x0254
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0256
        L_0x0254:
            r1 = r38
        L_0x0256:
            if (r10 == 0) goto L_0x025a
            r6 = 1
            goto L_0x025c
        L_0x025a:
            r6 = r39
        L_0x025c:
            if (r16 == 0) goto L_0x0260
            r10 = 0
            goto L_0x0262
        L_0x0260:
            r10 = r40
        L_0x0262:
            if (r20 == 0) goto L_0x0267
            r16 = 0
            goto L_0x0269
        L_0x0267:
            r16 = r41
        L_0x0269:
            if (r24 == 0) goto L_0x0272
            androidx.compose.ui.text.TextStyle$Companion r18 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r18 = r18.getDefault()
            goto L_0x0274
        L_0x0272:
            r18 = r42
        L_0x0274:
            if (r26 == 0) goto L_0x027d
            androidx.compose.foundation.text.KeyboardOptions$Companion r19 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r19 = r19.getDefault()
            goto L_0x027f
        L_0x027d:
            r19 = r43
        L_0x027f:
            if (r12 == 0) goto L_0x0288
            androidx.compose.foundation.text.KeyboardActions$Companion r12 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r12 = r12.getDefault()
            goto L_0x028a
        L_0x0288:
            r12 = r44
        L_0x028a:
            if (r0 == 0) goto L_0x0293
            androidx.compose.foundation.text2.input.TextFieldLineLimits$Companion r0 = androidx.compose.foundation.text2.input.TextFieldLineLimits.Companion
            androidx.compose.foundation.text2.input.TextFieldLineLimits r0 = r0.getDefault()
            goto L_0x0295
        L_0x0293:
            r0 = r45
        L_0x0295:
            if (r4 == 0) goto L_0x0299
            r4 = 0
            goto L_0x029b
        L_0x0299:
            r4 = r46
        L_0x029b:
            if (r5 == 0) goto L_0x029f
            r5 = 0
            goto L_0x02a1
        L_0x029f:
            r5 = r47
        L_0x02a1:
            if (r7 == 0) goto L_0x02b4
            androidx.compose.ui.graphics.SolidColor r7 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r20.m3842getBlack0d7_KjU()
            r38 = r0
            r0 = 0
            r7.<init>(r14, r0)
            androidx.compose.ui.graphics.Brush r7 = (androidx.compose.ui.graphics.Brush) r7
            goto L_0x02b9
        L_0x02b4:
            r38 = r0
            r0 = 0
            r7 = r48
        L_0x02b9:
            if (r9 == 0) goto L_0x02bd
            r9 = r0
            goto L_0x02bf
        L_0x02bd:
            r9 = r49
        L_0x02bf:
            if (r11 == 0) goto L_0x02c3
            r11 = r0
            goto L_0x02c5
        L_0x02c3:
            r11 = r50
        L_0x02c5:
            r14 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x02d4
            r14 = 0
            r15 = 1
            androidx.compose.foundation.ScrollState r20 = androidx.compose.foundation.ScrollKt.rememberScrollState(r14, r2, r14, r15)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r14
            goto L_0x02d6
        L_0x02d4:
            r20 = r51
        L_0x02d6:
            r15 = r8
            r14 = r11
            r8 = r5
            r11 = r9
            r5 = r38
            r9 = r7
            r7 = r4
            r4 = r16
        L_0x02e0:
            r2.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x02f1
            java.lang.String r0 = "androidx.compose.foundation.text2.BasicTextField2 (BasicTextField2.kt:334)"
            r13 = 437246650(0x1a0fdaba, float:2.9748393E-23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r3, r15, r0)
        L_0x02f1:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r13)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r13)
            java.lang.Object r15 = r2.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalWindowInfo()
            r22 = r7
            r7 = r16
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r13)
            java.lang.Object r7 = r2.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.WindowInfo r7 = (androidx.compose.ui.platform.WindowInfo) r7
            androidx.compose.foundation.text2.input.TextFieldLineLimits$SingleLine r3 = androidx.compose.foundation.text2.input.TextFieldLineLimits.SingleLine.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r3)
            r16 = r9
            r9 = -957633428(0xffffffffc6ebac6c, float:-30166.21)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "341@20017L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            if (r8 != 0) goto L_0x036b
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            java.lang.Object r9 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r24 = r8
            java.lang.Object r8 = r23.getEmpty()
            if (r9 != r8) goto L_0x0365
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r2.updateRememberedValue(r9)
        L_0x0365:
            r2.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = (androidx.compose.foundation.interaction.MutableInteractionSource) r9
            goto L_0x036f
        L_0x036b:
            r24 = r8
            r9 = r24
        L_0x036f:
            r2.endReplaceableGroup()
            if (r3 == 0) goto L_0x0377
            androidx.compose.foundation.gestures.Orientation r8 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x0379
        L_0x0377:
            androidx.compose.foundation.gestures.Orientation r8 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x0379:
            r23 = r5
            r5 = r9
            androidx.compose.foundation.interaction.InteractionSource r5 = (androidx.compose.foundation.interaction.InteractionSource) r5
            r34 = r14
            r14 = 0
            androidx.compose.runtime.State r5 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r5, r2, r14)
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            boolean r7 = r7.isWindowFocused()
            r14 = 1618982084(0x607fb4c4, float:7.370227E19)
            r2.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            r14 = r37
            boolean r25 = r2.changed((java.lang.Object) r14)
            boolean r26 = r2.changed((java.lang.Object) r4)
            r25 = r25 | r26
            boolean r26 = r2.changed((java.lang.Object) r11)
            r25 = r25 | r26
            r50 = r8
            java.lang.Object r8 = r2.rememberedValue()
            if (r25 != 0) goto L_0x03c3
            androidx.compose.runtime.Composer$Companion r25 = androidx.compose.runtime.Composer.Companion
            r48 = r15
            java.lang.Object r15 = r25.getEmpty()
            if (r8 != r15) goto L_0x03da
            goto L_0x03c5
        L_0x03c3:
            r48 = r15
        L_0x03c5:
            if (r11 != 0) goto L_0x03d0
            androidx.compose.foundation.text2.input.SingleLineCodepointTransformation r8 = androidx.compose.foundation.text2.input.SingleLineCodepointTransformation.INSTANCE
            if (r3 == 0) goto L_0x03cc
            goto L_0x03cd
        L_0x03cc:
            r8 = 0
        L_0x03cd:
            androidx.compose.foundation.text2.input.CodepointTransformation r8 = (androidx.compose.foundation.text2.input.CodepointTransformation) r8
            goto L_0x03d1
        L_0x03d0:
            r8 = r11
        L_0x03d1:
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r15 = new androidx.compose.foundation.text2.input.internal.TransformedTextFieldState
            r15.<init>(r14, r4, r8)
            r2.updateRememberedValue(r15)
            r8 = r15
        L_0x03da:
            r2.endReplaceableGroup()
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r8 = (androidx.compose.foundation.text2.input.internal.TransformedTextFieldState) r8
            r15 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            boolean r15 = r2.changed((java.lang.Object) r8)
            r35 = r11
            java.lang.Object r11 = r2.rememberedValue()
            if (r15 != 0) goto L_0x03fe
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r11 != r15) goto L_0x0406
        L_0x03fe:
            androidx.compose.foundation.text2.input.internal.TextLayoutState r11 = new androidx.compose.foundation.text2.input.internal.TextLayoutState
            r11.<init>()
            r2.updateRememberedValue(r11)
        L_0x0406:
            r2.endReplaceableGroup()
            androidx.compose.foundation.text2.input.internal.TextLayoutState r11 = (androidx.compose.foundation.text2.input.internal.TextLayoutState) r11
            r15 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            boolean r15 = r2.changed((java.lang.Object) r8)
            java.lang.Object r14 = r2.rememberedValue()
            if (r15 != 0) goto L_0x0428
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r14 != r15) goto L_0x0445
        L_0x0428:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r14 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState
            if (r5 == 0) goto L_0x0430
            if (r7 == 0) goto L_0x0430
            r15 = 1
            goto L_0x0431
        L_0x0430:
            r15 = 0
        L_0x0431:
            r38 = r14
            r39 = r8
            r40 = r11
            r41 = r0
            r42 = r6
            r43 = r10
            r44 = r15
            r38.<init>(r39, r40, r41, r42, r43, r44)
            r2.updateRememberedValue(r14)
        L_0x0445:
            r2.endReplaceableGroup()
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r14 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState) r14
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r49 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r13)
            java.lang.Object r15 = r2.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.hapticfeedback.HapticFeedback r15 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r15
            androidx.compose.runtime.ProvidableCompositionLocal r25 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            r51 = r5
            r5 = r25
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r13)
            java.lang.Object r5 = r2.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.ClipboardManager r5 = (androidx.compose.ui.platform.ClipboardManager) r5
            androidx.compose.runtime.ProvidableCompositionLocal r25 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            r52 = r9
            r9 = r25
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r13)
            java.lang.Object r7 = r2.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.TextToolbar r7 = (androidx.compose.ui.platform.TextToolbar) r7
            androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$3 r9 = new androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$3
            r38 = r9
            r39 = r14
            r40 = r15
            r41 = r5
            r42 = r7
            r43 = r0
            r44 = r6
            r45 = r10
            r38.<init>(r39, r40, r41, r42, r43, r44, r45)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r0 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r9, r2, r0)
            androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4 r0 = new androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4
            r0.<init>(r14)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r5 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r14, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r2, (int) r5)
            androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifier r0 = new androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifier
            r38 = r0
            r39 = r8
            r40 = r11
            r41 = r14
            r42 = r4
            r43 = r6
            r44 = r10
            r45 = r19
            r46 = r12
            r47 = r3
            r38.<init>(r39, r40, r41, r42, r43, r44, r45, r46, r47)
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            r9 = r52
            androidx.compose.ui.Modifier r25 = androidx.compose.foundation.FocusableKt.focusable(r0, r6, r9)
            r26 = r20
            androidx.compose.foundation.gestures.ScrollableState r26 = (androidx.compose.foundation.gestures.ScrollableState) r26
            if (r6 == 0) goto L_0x04ee
            int r0 = r20.getMaxValue()
            if (r0 <= 0) goto L_0x04ee
            androidx.compose.foundation.text.Handle r0 = r14.getDraggingHandle()
            if (r0 != 0) goto L_0x04ee
            r28 = 1
            goto L_0x04f0
        L_0x04ee:
            r28 = 0
        L_0x04f0:
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r15 = r48
            r5 = r50
            r7 = 0
            boolean r29 = r0.reverseDirection(r15, r5, r7)
            r32 = 16
            r33 = 0
            r30 = 0
            r27 = r5
            r31 = r9
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r25, r26, r27, r28, r29, r30, r31, r32, r33)
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            r9 = 48
            r13 = 1
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r13, r2, r9)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            r9 = 0
            int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r9)
            androidx.compose.runtime.CompositionLocalMap r9 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r25 = r1
            androidx.compose.runtime.Applier r1 = r2.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x054c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x054c:
            r2.startReusableNode()
            boolean r1 = r2.getInserting()
            if (r1 == 0) goto L_0x0559
            r2.createNode(r15)
            goto L_0x055c
        L_0x0559:
            r2.useNode()
        L_0x055c:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r1, r7, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r1, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            boolean r9 = r1.getInserting()
            if (r9 != 0) goto L_0x058c
            java.lang.Object r9 = r1.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r13)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r15)
            if (r9 != 0) goto L_0x059a
        L_0x058c:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r13)
            r1.updateRememberedValue(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r13)
            r1.apply(r9, r7)
        L_0x059a:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r7 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.invoke(r1, r2, r7)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r1 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 481805554(0x1cb7c4f2, float:1.2160833E-21)
            java.lang.String r1 = "C425@23768L2308:BasicTextField2.kt#g98mwb"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            if (r34 != 0) goto L_0x05c9
            androidx.compose.foundation.text2.TextFieldDecorator r0 = DefaultTextFieldDecorator
            goto L_0x05cb
        L_0x05c9:
            r0 = r34
        L_0x05cb:
            androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$5$1 r1 = new androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$5$1
            r38 = r1
            r39 = r23
            r40 = r11
            r41 = r18
            r42 = r51
            r43 = r49
            r44 = r8
            r45 = r14
            r46 = r16
            r47 = r6
            r48 = r10
            r49 = r20
            r50 = r5
            r51 = r3
            r52 = r22
            r38.<init>(r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52)
            r3 = 1476233751(0x57fd8a17, float:5.57539066E14)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r3, r5, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = 6
            r0.Decoration(r1, r2, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0617
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0617:
            r5 = r4
            r3 = r6
            r4 = r10
            r8 = r12
            r12 = r16
            r6 = r18
            r7 = r19
            r15 = r20
            r10 = r22
            r9 = r23
            r11 = r24
            r14 = r34
            r13 = r35
        L_0x062d:
            androidx.compose.runtime.ScopeUpdateScope r2 = r2.endRestartGroup()
            if (r2 == 0) goto L_0x064f
            androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$6 r19 = new androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$6
            r0 = r19
            r1 = r37
            r36 = r2
            r2 = r25
            r16 = r53
            r17 = r54
            r18 = r55
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r36
            r1.updateScope(r0)
        L_0x064f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.BasicTextField2Kt.BasicTextField2(androidx.compose.foundation.text2.input.TextFieldState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text2.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.foundation.text2.input.TextFieldLineLimits, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text2.input.CodepointTransformation, androidx.compose.foundation.text2.TextFieldDecorator, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionState textFieldSelectionState, Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(773754631);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)490@26277L629:BasicTextField2.kt#g98mwb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(773754631, i, -1, "androidx.compose.foundation.text2.TextFieldCursorHandle (BasicTextField2.kt:487)");
        }
        TextFieldHandleState cursorHandle = textFieldSelectionState.getCursorHandle();
        if (cursorHandle.getVisible()) {
            long r1 = cursorHandle.m1439getPositionF1C5BW0();
            Modifier modifier = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(1290415310);
            boolean changed = startRestartGroup.changed((Object) cursorHandle);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BasicTextField2Kt$TextFieldCursorHandle$1$1(cursorHandle);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m1042CursorHandleULxng0E(r1, SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null), (Object) textFieldSelectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTextField2Kt$TextFieldCursorHandle$2(textFieldSelectionState, (Continuation<? super BasicTextField2Kt$TextFieldCursorHandle$2>) null)), (Function2<? super Composer, ? super Integer, Unit>) null, startRestartGroup, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextField2Kt$TextFieldCursorHandle$3(textFieldSelectionState, i));
        }
    }

    public static final void TextFieldSelectionHandles(TextFieldSelectionState textFieldSelectionState, Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1194626330);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldSelectionHandles)528@27633L397:BasicTextField2.kt#g98mwb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1194626330, i, -1, "androidx.compose.foundation.text2.TextFieldSelectionHandles (BasicTextField2.kt:512)");
        }
        TextFieldHandleState startSelectionHandle = textFieldSelectionState.getStartSelectionHandle();
        startRestartGroup.startReplaceableGroup(-1453543870);
        ComposerKt.sourceInformation(startRestartGroup, "515@27123L401");
        if (startSelectionHandle.getVisible()) {
            AndroidSelectionHandles_androidKt.SelectionHandle(new BasicTextField2Kt$TextFieldSelectionHandles$1(textFieldSelectionState), true, startSelectionHandle.getDirection(), startSelectionHandle.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textFieldSelectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTextField2Kt$TextFieldSelectionHandles$2(textFieldSelectionState, (Continuation<? super BasicTextField2Kt$TextFieldSelectionHandles$2>) null)), startRestartGroup, 48);
        }
        startRestartGroup.endReplaceableGroup();
        TextFieldHandleState endSelectionHandle = textFieldSelectionState.getEndSelectionHandle();
        if (endSelectionHandle.getVisible()) {
            AndroidSelectionHandles_androidKt.SelectionHandle(new BasicTextField2Kt$TextFieldSelectionHandles$3(textFieldSelectionState), false, endSelectionHandle.getDirection(), endSelectionHandle.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textFieldSelectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTextField2Kt$TextFieldSelectionHandles$4(textFieldSelectionState, (Continuation<? super BasicTextField2Kt$TextFieldSelectionHandles$4>) null)), startRestartGroup, 48);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextField2Kt$TextFieldSelectionHandles$5(textFieldSelectionState, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void BasicTextField2$lambda$3(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }
}
