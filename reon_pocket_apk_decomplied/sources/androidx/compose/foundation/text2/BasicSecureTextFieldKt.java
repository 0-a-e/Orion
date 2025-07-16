package androidx.compose.foundation.text2;

import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text2.input.ImeActionHandler;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001aÔ\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u001928\b\u0002\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\u0002\b\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aè\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00030,2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u001928\b\u0002\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\u0002\b\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a \u0010/\u001a\u00020\u00032\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\u00030\u001d¢\u0006\u0002\b1H\u0003¢\u0006\u0002\u00102\u001a\u0010\u00103\u001a\u0002042\u0006\u0010\b\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065²\u0006\n\u00106\u001a\u000207X\u0002"}, d2 = {"LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "onSubmit", "Landroidx/compose/foundation/text2/input/ImeActionHandler;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "textObfuscationMode", "Landroidx/compose/foundation/text2/input/TextObfuscationMode;", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "decorator", "Landroidx/compose/foundation/text2/TextFieldDecorator;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "BasicSecureTextField-mMrxcSU", "(Landroidx/compose/foundation/text2/input/TextFieldState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text2/input/ImeActionHandler;IIIZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "value", "", "onValueChange", "Lkotlin/Function1;", "BasicSecureTextField-TLP4tmw", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text2/input/ImeActionHandler;IIIZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "KeyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "foundation_release", "valueWithSelection", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
public final class BasicSecureTextFieldKt {
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARNING: Removed duplicated region for block: B:105:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0132  */
    /* renamed from: BasicSecureTextField-TLP4tmw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1325BasicSecureTextFieldTLP4tmw(java.lang.String r36, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, androidx.compose.foundation.text2.input.ImeActionHandler r39, int r40, int r41, int r42, boolean r43, androidx.compose.foundation.text2.input.InputTransformation r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.ui.graphics.Brush r47, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r48, androidx.compose.foundation.text2.TextFieldDecorator r49, androidx.compose.foundation.ScrollState r50, androidx.compose.runtime.Composer r51, int r52, int r53, int r54) {
        /*
            r1 = r36
            r2 = r37
            r15 = r52
            r14 = r53
            r13 = r54
            r0 = 917546540(0x36b0a62c, float:5.2645537E-6)
            r3 = r51
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(BasicSecureTextField)P(14,10,7,8,3:c#ui.text.input.ImeAction,12:c#foundation.text2.input.TextObfuscationMode,6:c#ui.text.input.KeyboardType,2,4,13,5!1,9)156@9390L21,158@9433L213,168@9839L174,178@10082L957:BasicSecureTextField.kt#g98mwb"
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
            r12 = r38
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
            r12 = r38
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
            r5 = r39
            boolean r19 = r3.changed((java.lang.Object) r5)
            if (r19 == 0) goto L_0x007d
            r19 = r17
            goto L_0x007f
        L_0x007d:
            r19 = r18
        L_0x007f:
            r4 = r4 | r19
            goto L_0x0084
        L_0x0082:
            r5 = r39
        L_0x0084:
            r19 = r13 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            r21 = 57344(0xe000, float:8.0356E-41)
            r22 = 16384(0x4000, float:2.2959E-41)
            if (r19 == 0) goto L_0x0094
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r8 = r40
            goto L_0x00a7
        L_0x0094:
            r23 = r15 & r21
            r8 = r40
            if (r23 != 0) goto L_0x00a7
            boolean r24 = r3.changed((int) r8)
            if (r24 == 0) goto L_0x00a3
            r24 = r22
            goto L_0x00a5
        L_0x00a3:
            r24 = r20
        L_0x00a5:
            r4 = r4 | r24
        L_0x00a7:
            r24 = r13 & 32
            if (r24 == 0) goto L_0x00b2
            r25 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r25
            r9 = r41
            goto L_0x00c7
        L_0x00b2:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r15 & r25
            r9 = r41
            if (r25 != 0) goto L_0x00c7
            boolean r26 = r3.changed((int) r9)
            if (r26 == 0) goto L_0x00c3
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c5
        L_0x00c3:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00c5:
            r4 = r4 | r26
        L_0x00c7:
            r26 = r13 & 64
            if (r26 == 0) goto L_0x00d2
            r27 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r27
            r10 = r42
            goto L_0x00e7
        L_0x00d2:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r15 & r27
            r10 = r42
            if (r27 != 0) goto L_0x00e7
            boolean r28 = r3.changed((int) r10)
            if (r28 == 0) goto L_0x00e3
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r4 = r4 | r28
        L_0x00e7:
            r11 = r13 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x00f2
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r29
            r6 = r43
            goto L_0x0107
        L_0x00f2:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r15 & r29
            r6 = r43
            if (r29 != 0) goto L_0x0107
            boolean r30 = r3.changed((boolean) r6)
            if (r30 == 0) goto L_0x0103
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r4 = r4 | r30
        L_0x0107:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0112
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r31
            r5 = r44
            goto L_0x0127
        L_0x0112:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r15 & r31
            r5 = r44
            if (r31 != 0) goto L_0x0127
            boolean r31 = r3.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x0123
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r4 = r4 | r31
        L_0x0127:
            r5 = r13 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0132
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r4 = r4 | r31
            r6 = r45
            goto L_0x0147
        L_0x0132:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r15 & r31
            r6 = r45
            if (r31 != 0) goto L_0x0147
            boolean r31 = r3.changed((java.lang.Object) r6)
            if (r31 == 0) goto L_0x0143
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0145
        L_0x0143:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0145:
            r4 = r4 | r31
        L_0x0147:
            r6 = r13 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0150
            r31 = r14 | 6
            r8 = r46
            goto L_0x0166
        L_0x0150:
            r31 = r14 & 14
            r8 = r46
            if (r31 != 0) goto L_0x0164
            boolean r31 = r3.changed((java.lang.Object) r8)
            if (r31 == 0) goto L_0x015f
            r31 = 4
            goto L_0x0161
        L_0x015f:
            r31 = 2
        L_0x0161:
            r31 = r14 | r31
            goto L_0x0166
        L_0x0164:
            r31 = r14
        L_0x0166:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x016d
            r31 = r31 | 48
            goto L_0x0180
        L_0x016d:
            r32 = r14 & 112(0x70, float:1.57E-43)
            r9 = r47
            if (r32 != 0) goto L_0x0180
            boolean r32 = r3.changed((java.lang.Object) r9)
            if (r32 == 0) goto L_0x017c
            r23 = 32
            goto L_0x017e
        L_0x017c:
            r23 = 16
        L_0x017e:
            r31 = r31 | r23
        L_0x0180:
            r9 = r31
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0189
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x019d
        L_0x0189:
            r12 = r14 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x019d
            r12 = r48
            boolean r23 = r3.changedInstance(r12)
            if (r23 == 0) goto L_0x0198
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x019a
        L_0x0198:
            r27 = 128(0x80, float:1.794E-43)
        L_0x019a:
            r9 = r9 | r27
            goto L_0x019f
        L_0x019d:
            r12 = r48
        L_0x019f:
            r12 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01a6
            r9 = r9 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b8
        L_0x01a6:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x01b8
            r2 = r49
            boolean r23 = r3.changed((java.lang.Object) r2)
            if (r23 == 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b3:
            r17 = r18
        L_0x01b5:
            r9 = r9 | r17
            goto L_0x01ba
        L_0x01b8:
            r2 = r49
        L_0x01ba:
            r17 = r14 & r21
            if (r17 != 0) goto L_0x01d2
            r2 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r2 != 0) goto L_0x01cd
            r2 = r50
            boolean r17 = r3.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x01cf
            r20 = r22
            goto L_0x01cf
        L_0x01cd:
            r2 = r50
        L_0x01cf:
            r9 = r9 | r20
            goto L_0x01d4
        L_0x01d2:
            r2 = r50
        L_0x01d4:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r4 & r17
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r14) goto L_0x020e
            r2 = 46811(0xb6db, float:6.5596E-41)
            r2 = r2 & r9
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r2 != r14) goto L_0x020e
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x01ed
            goto L_0x020e
        L_0x01ed:
            r3.skipToGroupEnd()
            r1 = r37
            r4 = r38
            r7 = r39
            r5 = r40
            r6 = r41
            r8 = r42
            r11 = r43
            r9 = r44
            r10 = r45
            r12 = r46
            r13 = r47
            r14 = r48
            r15 = r49
            r34 = r50
            goto L_0x0433
        L_0x020e:
            r3.startDefaults()
            r2 = r15 & 1
            if (r2 == 0) goto L_0x0244
            boolean r2 = r3.getDefaultsInvalid()
            if (r2 == 0) goto L_0x021c
            goto L_0x0244
        L_0x021c:
            r3.skipToGroupEnd()
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0227
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r9 = r9 & r0
        L_0x0227:
            r2 = r38
            r7 = r39
            r0 = r40
            r5 = r41
            r6 = r42
            r11 = r43
            r8 = r44
            r10 = r46
            r12 = r47
            r14 = r48
            r15 = r49
            r34 = r50
            r13 = r9
            r9 = r45
            goto L_0x02e4
        L_0x0244:
            if (r7 == 0) goto L_0x024b
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x024d
        L_0x024b:
            r2 = r38
        L_0x024d:
            if (r16 == 0) goto L_0x0251
            r7 = 0
            goto L_0x0253
        L_0x0251:
            r7 = r39
        L_0x0253:
            if (r19 == 0) goto L_0x025c
            androidx.compose.ui.text.input.ImeAction$Companion r16 = androidx.compose.ui.text.input.ImeAction.Companion
            int r16 = r16.m6237getDefaulteUduSuo()
            goto L_0x025e
        L_0x025c:
            r16 = r40
        L_0x025e:
            if (r24 == 0) goto L_0x0267
            androidx.compose.foundation.text2.input.TextObfuscationMode$Companion r17 = androidx.compose.foundation.text2.input.TextObfuscationMode.Companion
            int r17 = r17.m1362getRevealLastTypedpyid5Pk()
            goto L_0x0269
        L_0x0267:
            r17 = r41
        L_0x0269:
            if (r26 == 0) goto L_0x0272
            androidx.compose.ui.text.input.KeyboardType$Companion r18 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r18 = r18.m6290getPasswordPjHm6EE()
            goto L_0x0274
        L_0x0272:
            r18 = r42
        L_0x0274:
            if (r11 == 0) goto L_0x0278
            r11 = 1
            goto L_0x027a
        L_0x0278:
            r11 = r43
        L_0x027a:
            if (r0 == 0) goto L_0x027e
            r0 = 0
            goto L_0x0280
        L_0x027e:
            r0 = r44
        L_0x0280:
            if (r5 == 0) goto L_0x0289
            androidx.compose.ui.text.TextStyle$Companion r5 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r5 = r5.getDefault()
            goto L_0x028b
        L_0x0289:
            r5 = r45
        L_0x028b:
            if (r6 == 0) goto L_0x028f
            r6 = 0
            goto L_0x0291
        L_0x028f:
            r6 = r46
        L_0x0291:
            if (r8 == 0) goto L_0x02a5
            androidx.compose.ui.graphics.SolidColor r8 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r20.m3842getBlack0d7_KjU()
            r39 = r0
            r0 = 0
            r8.<init>(r14, r0)
            r0 = r8
            androidx.compose.ui.graphics.Brush r0 = (androidx.compose.ui.graphics.Brush) r0
            goto L_0x02a9
        L_0x02a5:
            r39 = r0
            r0 = r47
        L_0x02a9:
            if (r10 == 0) goto L_0x02ad
            r8 = 0
            goto L_0x02af
        L_0x02ad:
            r8 = r48
        L_0x02af:
            if (r12 == 0) goto L_0x02b3
            r10 = 0
            goto L_0x02b5
        L_0x02b3:
            r10 = r49
        L_0x02b5:
            r12 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x02d4
            r12 = 0
            r14 = 1
            androidx.compose.foundation.ScrollState r14 = androidx.compose.foundation.ScrollKt.rememberScrollState(r12, r3, r12, r14)
            r12 = -57345(0xffffffffffff1fff, float:NaN)
            r9 = r9 & r12
            r12 = r0
            r13 = r9
            r15 = r10
            r34 = r14
            r0 = r16
            r9 = r5
            r10 = r6
            r14 = r8
            r5 = r17
            r6 = r18
            r8 = r39
            goto L_0x02e4
        L_0x02d4:
            r34 = r50
            r12 = r0
            r14 = r8
            r13 = r9
            r15 = r10
            r0 = r16
            r8 = r39
            r9 = r5
            r10 = r6
            r5 = r17
            r6 = r18
        L_0x02e4:
            r3.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x02fa
            r45 = r15
            java.lang.String r15 = "androidx.compose.foundation.text2.BasicSecureTextField (BasicSecureTextField.kt:157)"
            r46 = r14
            r14 = 917546540(0x36b0a62c, float:5.2645537E-6)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r4, r13, r15)
            goto L_0x02fe
        L_0x02fa:
            r46 = r14
            r45 = r15
        L_0x02fe:
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r14)
            java.lang.Object r14 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r14 != r15) goto L_0x032b
            androidx.compose.foundation.text2.input.TextFieldState r14 = new androidx.compose.foundation.text2.input.TextFieldState
            int r15 = r36.length()
            r47 = r9
            r48 = r10
            long r9 = androidx.compose.ui.text.TextRangeKt.TextRange(r15)
            r15 = 0
            r14.<init>((java.lang.String) r1, (long) r9, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
            r3.updateRememberedValue(r14)
            goto L_0x032f
        L_0x032b:
            r47 = r9
            r48 = r10
        L_0x032f:
            r3.endReplaceableGroup()
            r9 = r14
            androidx.compose.foundation.text2.input.TextFieldState r9 = (androidx.compose.foundation.text2.input.TextFieldState) r9
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r10)
            java.lang.Object r10 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r10 != r14) goto L_0x0374
            androidx.compose.ui.text.input.TextFieldValue r10 = new androidx.compose.ui.text.input.TextFieldValue
            int r14 = r36.length()
            long r14 = androidx.compose.ui.text.TextRangeKt.TextRange(r14)
            r16 = 4
            r17 = 0
            r18 = 0
            r38 = r10
            r39 = r36
            r40 = r14
            r42 = r18
            r43 = r16
            r44 = r17
            r38.<init>((java.lang.String) r39, (long) r40, (androidx.compose.ui.text.TextRange) r42, (int) r43, (kotlin.jvm.internal.DefaultConstructorMarker) r44)
            r14 = 2
            r15 = 0
            androidx.compose.runtime.MutableState r10 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r10, r15, r14, r15)
            r3.updateRememberedValue(r10)
        L_0x0374:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r10 = (androidx.compose.runtime.MutableState) r10
            androidx.compose.ui.text.input.TextFieldValue r14 = BasicSecureTextField_TLP4tmw$lambda$2(r10)
            r15 = 6
            r16 = 0
            r17 = 0
            r19 = 0
            r38 = r14
            r39 = r36
            r40 = r17
            r42 = r19
            r43 = r15
            r44 = r16
            androidx.compose.ui.text.input.TextFieldValue r14 = androidx.compose.ui.text.input.TextFieldValue.m6295copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r38, (java.lang.String) r39, (long) r40, (androidx.compose.ui.text.TextRange) r42, (int) r43, (java.lang.Object) r44)
            BasicSecureTextField_TLP4tmw$lambda$3(r10, r14)
            androidx.compose.ui.text.input.TextFieldValue r14 = BasicSecureTextField_TLP4tmw$lambda$2(r10)
            r15 = 1829191301(0x6d073e85, float:2.6160036E27)
            r3.startReplaceableGroup(r15)
            boolean r15 = r3.changed((java.lang.Object) r10)
            r1 = r37
            boolean r16 = r3.changedInstance(r1)
            r15 = r15 | r16
            r38 = r12
            java.lang.Object r12 = r3.rememberedValue()
            if (r15 != 0) goto L_0x03bd
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r12 != r15) goto L_0x03c7
        L_0x03bd:
            androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$1$1 r12 = new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$1$1
            r12.<init>(r1, r10)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r3.updateRememberedValue(r12)
        L_0x03c7:
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r3.endReplaceableGroup()
            r10 = 0
            androidx.compose.ui.Modifier r17 = androidx.compose.foundation.text2.input.internal.StateSyncingModifierKt.syncTextFieldState(r2, r9, r14, r12, r10)
            int r4 = r4 >> 3
            r10 = r4 & 896(0x380, float:1.256E-42)
            r10 = r10 | 6
            r12 = r4 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r12
            r12 = r4 & r21
            r10 = r10 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r4
            r10 = r10 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r4
            r10 = r10 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r4
            r10 = r10 | r12
            r12 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r12
            r4 = r4 | r10
            int r10 = r13 << 27
            r12 = 1879048192(0x70000000, float:1.58456325E29)
            r10 = r10 & r12
            r31 = r4 | r10
            int r4 = r13 >> 3
            r4 = r4 & 8190(0x1ffe, float:1.1477E-41)
            r32 = r4
            r33 = 0
            r16 = r9
            r18 = r7
            r19 = r0
            r20 = r5
            r21 = r6
            r22 = r11
            r23 = r8
            r24 = r47
            r25 = r48
            r26 = r38
            r27 = r46
            r28 = r45
            r29 = r34
            r30 = r3
            m1326BasicSecureTextFieldmMrxcSU(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0424
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0424:
            r13 = r38
            r15 = r45
            r14 = r46
            r10 = r47
            r12 = r48
            r4 = r2
            r9 = r8
            r8 = r6
            r6 = r5
            r5 = r0
        L_0x0433:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 == 0) goto L_0x045f
            androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$2 r19 = new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$2
            r0 = r19
            r1 = r36
            r2 = r37
            r35 = r3
            r3 = r4
            r4 = r7
            r7 = r8
            r8 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r34
            r16 = r52
            r17 = r53
            r18 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x045f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.BasicSecureTextFieldKt.m1325BasicSecureTextFieldTLP4tmw(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.foundation.text2.input.ImeActionHandler, int, int, int, boolean, androidx.compose.foundation.text2.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function2, androidx.compose.foundation.text2.TextFieldDecorator, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue BasicSecureTextField_TLP4tmw$lambda$2(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: androidx.compose.foundation.text2.SecureTextFieldController} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit>} */
    /* JADX WARNING: type inference failed for: r13v1, types: [androidx.compose.foundation.text2.TextFieldDecorator] */
    /* JADX WARNING: type inference failed for: r31v0, types: [androidx.compose.foundation.text2.TextFieldDecorator] */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r13v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01b1, code lost:
        if (r1.changed((java.lang.Object) r50) != false) goto L_0x01b8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0136  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: BasicSecureTextField-mMrxcSU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1326BasicSecureTextFieldmMrxcSU(androidx.compose.foundation.text2.input.TextFieldState r37, androidx.compose.ui.Modifier r38, androidx.compose.foundation.text2.input.ImeActionHandler r39, int r40, int r41, int r42, boolean r43, androidx.compose.foundation.text2.input.InputTransformation r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.ui.graphics.Brush r47, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r48, androidx.compose.foundation.text2.TextFieldDecorator r49, androidx.compose.foundation.ScrollState r50, androidx.compose.runtime.Composer r51, int r52, int r53, int r54) {
        /*
            r15 = r52
            r14 = r53
            r13 = r54
            r0 = 1073441926(0x3ffb6c86, float:1.9642494)
            r1 = r51
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicSecureTextField)P(11,7,8,3:c#ui.text.input.ImeAction,12:c#foundation.text2.input.TextObfuscationMode,6:c#ui.text.input.KeyboardType,2,4,13,5!1,9)277@16038L21,281@16205L24,282@16266L82,322@17467L1064:BasicSecureTextField.kt#g98mwb"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r15 | 6
            r5 = r2
            r2 = r37
            goto L_0x0032
        L_0x001e:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x002f
            r2 = r37
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
            r2 = r37
            r5 = r15
        L_0x0032:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x004c
        L_0x0039:
            r9 = r15 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x004c
            r9 = r38
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
            r9 = r38
        L_0x004e:
            r10 = r13 & 4
            if (r10 == 0) goto L_0x0055
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0055:
            r3 = r15 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0069
            r3 = r39
            boolean r16 = r1.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x0064
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r5 = r5 | r16
            goto L_0x006b
        L_0x0069:
            r3 = r39
        L_0x006b:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0076
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0076:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008a
            r4 = r40
            boolean r20 = r1.changed((int) r4)
            if (r20 == 0) goto L_0x0085
            r20 = r17
            goto L_0x0087
        L_0x0085:
            r20 = r18
        L_0x0087:
            r5 = r5 | r20
            goto L_0x008c
        L_0x008a:
            r4 = r40
        L_0x008c:
            r20 = r13 & 16
            if (r20 == 0) goto L_0x0095
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r7 = r41
            goto L_0x00ab
        L_0x0095:
            r21 = 57344(0xe000, float:8.0356E-41)
            r21 = r15 & r21
            r7 = r41
            if (r21 != 0) goto L_0x00ab
            boolean r22 = r1.changed((int) r7)
            if (r22 == 0) goto L_0x00a7
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a7:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r5 = r5 | r22
        L_0x00ab:
            r22 = r13 & 32
            if (r22 == 0) goto L_0x00b6
            r23 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r23
            r8 = r42
            goto L_0x00cb
        L_0x00b6:
            r23 = 458752(0x70000, float:6.42848E-40)
            r23 = r15 & r23
            r8 = r42
            if (r23 != 0) goto L_0x00cb
            boolean r24 = r1.changed((int) r8)
            if (r24 == 0) goto L_0x00c7
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r5 = r5 | r24
        L_0x00cb:
            r24 = r13 & 64
            if (r24 == 0) goto L_0x00d6
            r25 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r25
            r11 = r43
            goto L_0x00eb
        L_0x00d6:
            r25 = 3670016(0x380000, float:5.142788E-39)
            r25 = r15 & r25
            r11 = r43
            if (r25 != 0) goto L_0x00eb
            boolean r26 = r1.changed((boolean) r11)
            if (r26 == 0) goto L_0x00e7
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r5 = r5 | r26
        L_0x00eb:
            r12 = r13 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x00f6
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r27
            r0 = r44
            goto L_0x010b
        L_0x00f6:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r15 & r27
            r0 = r44
            if (r27 != 0) goto L_0x010b
            boolean r28 = r1.changed((java.lang.Object) r0)
            if (r28 == 0) goto L_0x0107
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0109
        L_0x0107:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0109:
            r5 = r5 | r28
        L_0x010b:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0116
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r5 = r5 | r28
            r2 = r45
            goto L_0x012b
        L_0x0116:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r15 & r28
            r2 = r45
            if (r28 != 0) goto L_0x012b
            boolean r28 = r1.changed((java.lang.Object) r2)
            if (r28 == 0) goto L_0x0127
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0129
        L_0x0127:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0129:
            r5 = r5 | r28
        L_0x012b:
            r2 = r13 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0136
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r28
            r3 = r46
            goto L_0x014b
        L_0x0136:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r15 & r28
            r3 = r46
            if (r28 != 0) goto L_0x014b
            boolean r28 = r1.changed((java.lang.Object) r3)
            if (r28 == 0) goto L_0x0147
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0149
        L_0x0147:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0149:
            r5 = r5 | r28
        L_0x014b:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0154
            r19 = r14 | 6
            r4 = r47
            goto L_0x016a
        L_0x0154:
            r28 = r14 & 14
            r4 = r47
            if (r28 != 0) goto L_0x0168
            boolean r28 = r1.changed((java.lang.Object) r4)
            if (r28 == 0) goto L_0x0163
            r19 = 4
            goto L_0x0165
        L_0x0163:
            r19 = 2
        L_0x0165:
            r19 = r14 | r19
            goto L_0x016a
        L_0x0168:
            r19 = r14
        L_0x016a:
            r4 = r13 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0171
            r19 = r19 | 48
            goto L_0x0184
        L_0x0171:
            r28 = r14 & 112(0x70, float:1.57E-43)
            r7 = r48
            if (r28 != 0) goto L_0x0184
            boolean r28 = r1.changedInstance(r7)
            if (r28 == 0) goto L_0x0180
            r21 = 32
            goto L_0x0182
        L_0x0180:
            r21 = 16
        L_0x0182:
            r19 = r19 | r21
        L_0x0184:
            r7 = r19
            r8 = r13 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x018d
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x01a1
        L_0x018d:
            r9 = r14 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01a1
            r9 = r49
            boolean r19 = r1.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x019c
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x019e
        L_0x019c:
            r25 = 128(0x80, float:1.794E-43)
        L_0x019e:
            r7 = r7 | r25
            goto L_0x01a3
        L_0x01a1:
            r9 = r49
        L_0x01a3:
            r9 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01bb
            r9 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r9 != 0) goto L_0x01b4
            r9 = r50
            boolean r19 = r1.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x01b6
            goto L_0x01b8
        L_0x01b4:
            r9 = r50
        L_0x01b6:
            r17 = r18
        L_0x01b8:
            r7 = r7 | r17
            goto L_0x01bd
        L_0x01bb:
            r9 = r50
        L_0x01bd:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r5 & r17
            r11 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r11) goto L_0x01f3
            r9 = r7 & 5851(0x16db, float:8.199E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r9 != r11) goto L_0x01f3
            boolean r9 = r1.getSkipping()
            if (r9 != 0) goto L_0x01d4
            goto L_0x01f3
        L_0x01d4:
            r1.skipToGroupEnd()
            r2 = r38
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
            goto L_0x03dd
        L_0x01f3:
            r1.startDefaults()
            r9 = r15 & 1
            if (r9 == 0) goto L_0x0227
            boolean r9 = r1.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0201
            goto L_0x0227
        L_0x0201:
            r1.skipToGroupEnd()
            r0 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x020a
            r7 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x020a:
            r6 = r38
            r9 = r39
            r10 = r40
            r2 = r41
            r3 = r42
            r4 = r43
            r8 = r45
            r11 = r46
            r12 = r47
            r33 = r48
            r34 = r49
            r35 = r50
            r0 = r7
            r7 = r44
            goto L_0x02d0
        L_0x0227:
            if (r6 == 0) goto L_0x022e
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0230
        L_0x022e:
            r6 = r38
        L_0x0230:
            if (r10 == 0) goto L_0x0234
            r9 = 0
            goto L_0x0236
        L_0x0234:
            r9 = r39
        L_0x0236:
            if (r16 == 0) goto L_0x023f
            androidx.compose.ui.text.input.ImeAction$Companion r10 = androidx.compose.ui.text.input.ImeAction.Companion
            int r10 = r10.m6237getDefaulteUduSuo()
            goto L_0x0241
        L_0x023f:
            r10 = r40
        L_0x0241:
            if (r20 == 0) goto L_0x024a
            androidx.compose.foundation.text2.input.TextObfuscationMode$Companion r16 = androidx.compose.foundation.text2.input.TextObfuscationMode.Companion
            int r16 = r16.m1362getRevealLastTypedpyid5Pk()
            goto L_0x024c
        L_0x024a:
            r16 = r41
        L_0x024c:
            if (r22 == 0) goto L_0x0255
            androidx.compose.ui.text.input.KeyboardType$Companion r17 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r17 = r17.m6290getPasswordPjHm6EE()
            goto L_0x0257
        L_0x0255:
            r17 = r42
        L_0x0257:
            if (r24 == 0) goto L_0x025c
            r18 = 1
            goto L_0x025e
        L_0x025c:
            r18 = r43
        L_0x025e:
            if (r12 == 0) goto L_0x0262
            r12 = 0
            goto L_0x0264
        L_0x0262:
            r12 = r44
        L_0x0264:
            if (r0 == 0) goto L_0x026d
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            goto L_0x026f
        L_0x026d:
            r0 = r45
        L_0x026f:
            if (r2 == 0) goto L_0x0273
            r2 = 0
            goto L_0x0275
        L_0x0273:
            r2 = r46
        L_0x0275:
            if (r3 == 0) goto L_0x028a
            androidx.compose.ui.graphics.SolidColor r3 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r19 = androidx.compose.ui.graphics.Color.Companion
            r38 = r12
            long r11 = r19.m3842getBlack0d7_KjU()
            r39 = r0
            r0 = 0
            r3.<init>(r11, r0)
            androidx.compose.ui.graphics.Brush r3 = (androidx.compose.ui.graphics.Brush) r3
            goto L_0x0291
        L_0x028a:
            r39 = r0
            r38 = r12
            r0 = 0
            r3 = r47
        L_0x0291:
            if (r4 == 0) goto L_0x0295
            r4 = r0
            goto L_0x0297
        L_0x0295:
            r4 = r48
        L_0x0297:
            if (r8 == 0) goto L_0x029b
            r8 = r0
            goto L_0x029d
        L_0x029b:
            r8 = r49
        L_0x029d:
            r11 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x02bd
            r11 = 0
            r12 = 1
            androidx.compose.foundation.ScrollState r11 = androidx.compose.foundation.ScrollKt.rememberScrollState(r11, r1, r11, r12)
            r7 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
            r12 = r3
            r33 = r4
            r0 = r7
            r34 = r8
            r35 = r11
            r3 = r17
            r4 = r18
            r7 = r38
            r8 = r39
            r11 = r2
            r2 = r16
            goto L_0x02d0
        L_0x02bd:
            r35 = r50
            r11 = r2
            r12 = r3
            r33 = r4
            r0 = r7
            r34 = r8
            r2 = r16
            r3 = r17
            r4 = r18
            r7 = r38
            r8 = r39
        L_0x02d0:
            r1.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x02e1
            java.lang.String r13 = "androidx.compose.foundation.text2.BasicSecureTextField (BasicSecureTextField.kt:280)"
            r14 = 1073441926(0x3ffb6c86, float:1.9642494)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r5, r0, r13)
        L_0x02e1:
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            java.lang.Object r0 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x0314
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r5.<init>(r0)
            r1.updateRememberedValue(r5)
            r0 = r5
        L_0x0314:
            r1.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r0 = r0.getCoroutineScope()
            r1.endReplaceableGroup()
            r5 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            boolean r5 = r1.changed((java.lang.Object) r0)
            java.lang.Object r13 = r1.rememberedValue()
            if (r5 != 0) goto L_0x033d
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r13 != r5) goto L_0x0345
        L_0x033d:
            androidx.compose.foundation.text2.SecureTextFieldController r13 = new androidx.compose.foundation.text2.SecureTextFieldController
            r13.<init>(r0)
            r1.updateRememberedValue(r13)
        L_0x0345:
            r1.endReplaceableGroup()
            r19 = r13
            androidx.compose.foundation.text2.SecureTextFieldController r19 = (androidx.compose.foundation.text2.SecureTextFieldController) r19
            androidx.compose.foundation.text2.input.TextObfuscationMode$Companion r0 = androidx.compose.foundation.text2.input.TextObfuscationMode.Companion
            int r0 = r0.m1362getRevealLastTypedpyid5Pk()
            boolean r17 = androidx.compose.foundation.text2.input.TextObfuscationMode.m1357equalsimpl0(r2, r0)
            if (r17 != 0) goto L_0x035f
            androidx.compose.foundation.text2.PasswordRevealFilter r0 = r19.getPasswordRevealFilter()
            r0.hide()
        L_0x035f:
            if (r17 == 0) goto L_0x0368
            androidx.compose.foundation.text2.input.CodepointTransformation r0 = r19.getCodepointTransformation()
        L_0x0365:
            r30 = r0
            goto L_0x037f
        L_0x0368:
            androidx.compose.foundation.text2.input.TextObfuscationMode$Companion r0 = androidx.compose.foundation.text2.input.TextObfuscationMode.Companion
            int r0 = r0.m1361getHiddenpyid5Pk()
            boolean r0 = androidx.compose.foundation.text2.input.TextObfuscationMode.m1357equalsimpl0(r2, r0)
            if (r0 == 0) goto L_0x037d
            androidx.compose.foundation.text2.input.CodepointTransformation$Companion r0 = androidx.compose.foundation.text2.input.CodepointTransformation.Companion
            r5 = 8226(0x2022, float:1.1527E-41)
            androidx.compose.foundation.text2.input.CodepointTransformation r0 = androidx.compose.foundation.text2.input.CodepointTransformationKt.mask(r0, r5)
            goto L_0x0365
        L_0x037d:
            r30 = 0
        L_0x037f:
            androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1 r0 = androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r5 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r6, r5, r0)
            if (r17 == 0) goto L_0x038f
            androidx.compose.ui.Modifier r5 = r19.getFocusChangeModifier()
            goto L_0x0393
        L_0x038f:
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
        L_0x0393:
            androidx.compose.ui.Modifier r24 = r0.then(r5)
            androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3 r0 = new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
            r16 = r0
            r18 = r7
            r20 = r3
            r21 = r10
            r22 = r9
            r23 = r37
            r25 = r4
            r26 = r8
            r27 = r33
            r28 = r11
            r29 = r12
            r31 = r34
            r32 = r35
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r5 = -1415093334(0xffffffffaba763aa, float:-1.1893726E-12)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r5, r13, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r5 = 6
            DisableCutCopy(r0, r1, r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03cd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03cd:
            r5 = r2
            r2 = r6
            r13 = r34
            r14 = r35
            r6 = r3
            r3 = r9
            r9 = r8
            r8 = r7
            r7 = r4
            r4 = r10
            r10 = r11
            r11 = r12
            r12 = r33
        L_0x03dd:
            androidx.compose.runtime.ScopeUpdateScope r1 = r1.endRestartGroup()
            if (r1 == 0) goto L_0x03fd
            androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$4 r18 = new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$4
            r0 = r18
            r36 = r1
            r1 = r37
            r15 = r52
            r16 = r53
            r17 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r36
            r1.updateScope(r0)
        L_0x03fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.BasicSecureTextFieldKt.m1326BasicSecureTextFieldmMrxcSU(androidx.compose.foundation.text2.input.TextFieldState, androidx.compose.ui.Modifier, androidx.compose.foundation.text2.input.ImeActionHandler, int, int, int, boolean, androidx.compose.foundation.text2.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function2, androidx.compose.foundation.text2.TextFieldDecorator, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final KeyboardActions KeyboardActions(ImeActionHandler imeActionHandler) {
        return new KeyboardActions(new BasicSecureTextFieldKt$KeyboardActions$1(imeActionHandler), new BasicSecureTextFieldKt$KeyboardActions$2(imeActionHandler), new BasicSecureTextFieldKt$KeyboardActions$3(imeActionHandler), new BasicSecureTextFieldKt$KeyboardActions$4(imeActionHandler), new BasicSecureTextFieldKt$KeyboardActions$5(imeActionHandler), new BasicSecureTextFieldKt$KeyboardActions$6(imeActionHandler));
    }

    /* access modifiers changed from: private */
    public static final void DisableCutCopy(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(930154034);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableCutCopy)491@23154L7,492@23192L680,511@23877L434:BasicSecureTextField.kt#g98mwb");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(930154034, i2, -1, "androidx.compose.foundation.text2.DisableCutCopy (BasicSecureTextField.kt:490)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextToolbar textToolbar = (TextToolbar) consume;
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) textToolbar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1(textToolbar);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) rememberedValue), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -1741121166, true, new BasicSecureTextFieldKt$DisableCutCopy$1(function2)), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicSecureTextFieldKt$DisableCutCopy$2(function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void BasicSecureTextField_TLP4tmw$lambda$3(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }
}
