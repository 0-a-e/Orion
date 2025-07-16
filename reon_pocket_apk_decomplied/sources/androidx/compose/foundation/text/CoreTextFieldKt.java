package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u000123\b\u0002\u0010\u001e\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0002\b ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b H\u0001¢\u0006\u0002\u0010$\u001a0\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0002\b H\u0003¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010,\u001a\u0015\u0010-\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\u0010.\u001a\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H\u0002\u001a\u0010\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u000204H\u0000\u001a \u00105\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0002\u001a0\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u00100\u001a\u0002012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0002\u001a \u0010;\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0001H\u0002\u001a2\u0010?\u001a\u00020\u0003*\u00020@2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000f2\u0006\u00106\u001a\u000207H@¢\u0006\u0002\u0010D\u001a\u001c\u0010E\u001a\u00020\t*\u00020\t2\u0006\u00100\u001a\u0002012\u0006\u0010&\u001a\u00020'H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006F²\u0006\n\u0010G\u001a\u00020\u0001X\u0002"}, d2 = {"USE_WINDOW_FOCUS_ENABLED", "", "CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/TextFieldState;", "isWindowFocusedBehindFlag", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
public final class CoreTextFieldKt {
    public static final boolean USE_WINDOW_FOCUS_ENABLED = false;

    public static final boolean isWindowFocusedBehindFlag(WindowInfo windowInfo) {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0877  */
    /* JADX WARNING: Removed duplicated region for block: B:308:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoreTextField(androidx.compose.ui.text.input.TextFieldValue r49, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r50, androidx.compose.ui.Modifier r51, androidx.compose.ui.text.TextStyle r52, androidx.compose.ui.text.input.VisualTransformation r53, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r54, androidx.compose.foundation.interaction.MutableInteractionSource r55, androidx.compose.ui.graphics.Brush r56, boolean r57, int r58, int r59, androidx.compose.ui.text.input.ImeOptions r60, androidx.compose.foundation.text.KeyboardActions r61, boolean r62, boolean r63, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, androidx.compose.runtime.Composer r65, int r66, int r67, int r68) {
        /*
            r15 = r49
            r14 = r66
            r13 = r67
            r12 = r68
            r0 = -958708118(0xffffffffc6db466a, float:-28067.207)
            r1 = r65
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CoreTextField)P(14,10,8,13,15,9,4!1,12,6,7,3,5,2,11)214@11969L29,218@12167L7,219@12206L7,220@12267L7,221@12335L7,222@12400L7,223@12445L7,224@12514L7,229@12730L135,235@12906L268,247@13479L21,248@13517L397,277@14313L26,280@14399L51,286@14702L7,287@14753L7,288@14810L7,292@14921L24,293@14979L37,588@27132L86,592@27224L515,641@29030L4637:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r14 | 6
            goto L_0x002d
        L_0x001d:
            r1 = r14 & 14
            if (r1 != 0) goto L_0x002c
            boolean r1 = r11.changed((java.lang.Object) r15)
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
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r10 = r50
            goto L_0x0048
        L_0x0036:
            r4 = r14 & 112(0x70, float:1.57E-43)
            r10 = r50
            if (r4 != 0) goto L_0x0048
            boolean r4 = r11.changedInstance(r10)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x004f:
            r9 = r14 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0063
            r9 = r51
            boolean r16 = r11.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x005e
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r16
            goto L_0x0065
        L_0x0063:
            r9 = r51
        L_0x0065:
            r16 = r12 & 8
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 2048(0x800, float:2.87E-42)
            if (r16 == 0) goto L_0x0070
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0070:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0084
            r2 = r52
            boolean r19 = r11.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x007f
            r19 = r18
            goto L_0x0081
        L_0x007f:
            r19 = r17
        L_0x0081:
            r1 = r1 | r19
            goto L_0x0086
        L_0x0084:
            r2 = r52
        L_0x0086:
            r19 = r12 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0093
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r5 = r53
            goto L_0x00a9
        L_0x0093:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r14 & r22
            r5 = r53
            if (r22 != 0) goto L_0x00a9
            boolean r23 = r11.changed((java.lang.Object) r5)
            if (r23 == 0) goto L_0x00a5
            r23 = r20
            goto L_0x00a7
        L_0x00a5:
            r23 = r21
        L_0x00a7:
            r1 = r1 | r23
        L_0x00a9:
            r23 = r12 & 32
            if (r23 == 0) goto L_0x00b4
            r24 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r24
            r6 = r54
            goto L_0x00c9
        L_0x00b4:
            r24 = 458752(0x70000, float:6.42848E-40)
            r24 = r14 & r24
            r6 = r54
            if (r24 != 0) goto L_0x00c9
            boolean r25 = r11.changedInstance(r6)
            if (r25 == 0) goto L_0x00c5
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r1 = r1 | r25
        L_0x00c9:
            r25 = r12 & 64
            if (r25 == 0) goto L_0x00d4
            r26 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r26
            r7 = r55
            goto L_0x00e9
        L_0x00d4:
            r26 = 3670016(0x380000, float:5.142788E-39)
            r26 = r14 & r26
            r7 = r55
            if (r26 != 0) goto L_0x00e9
            boolean r27 = r11.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x00e5
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r1 = r1 | r27
        L_0x00e9:
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00f4
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r28
            r3 = r56
            goto L_0x0109
        L_0x00f4:
            r28 = 29360128(0x1c00000, float:7.052966E-38)
            r28 = r14 & r28
            r3 = r56
            if (r28 != 0) goto L_0x0109
            boolean r29 = r11.changed((java.lang.Object) r3)
            if (r29 == 0) goto L_0x0105
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r1 = r1 | r29
        L_0x0109:
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0114
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r30
            r2 = r57
            goto L_0x0129
        L_0x0114:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r14 & r30
            r2 = r57
            if (r30 != 0) goto L_0x0129
            boolean r30 = r11.changed((boolean) r2)
            if (r30 == 0) goto L_0x0125
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0127
        L_0x0125:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0127:
            r1 = r1 | r30
        L_0x0129:
            r2 = r12 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0134
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r30
            r3 = r58
            goto L_0x0149
        L_0x0134:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r14 & r30
            r3 = r58
            if (r30 != 0) goto L_0x0149
            boolean r30 = r11.changed((int) r3)
            if (r30 == 0) goto L_0x0145
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0147
        L_0x0145:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0147:
            r1 = r1 | r30
        L_0x0149:
            r3 = r12 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0152
            r30 = r13 | 6
            r5 = r59
            goto L_0x0168
        L_0x0152:
            r30 = r13 & 14
            r5 = r59
            if (r30 != 0) goto L_0x0166
            boolean r30 = r11.changed((int) r5)
            if (r30 == 0) goto L_0x0161
            r30 = 4
            goto L_0x0163
        L_0x0161:
            r30 = 2
        L_0x0163:
            r30 = r13 | r30
            goto L_0x0168
        L_0x0166:
            r30 = r13
        L_0x0168:
            r31 = r13 & 112(0x70, float:1.57E-43)
            if (r31 != 0) goto L_0x0182
            r5 = r12 & 2048(0x800, float:2.87E-42)
            if (r5 != 0) goto L_0x017b
            r5 = r60
            boolean r31 = r11.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x017d
            r22 = 32
            goto L_0x017f
        L_0x017b:
            r5 = r60
        L_0x017d:
            r22 = 16
        L_0x017f:
            r30 = r30 | r22
            goto L_0x0184
        L_0x0182:
            r5 = r60
        L_0x0184:
            r5 = r30
            r6 = r12 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x018d
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x01a1
        L_0x018d:
            r7 = r13 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x01a1
            r7 = r61
            boolean r22 = r11.changed((java.lang.Object) r7)
            if (r22 == 0) goto L_0x019c
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x019e
        L_0x019c:
            r26 = 128(0x80, float:1.794E-43)
        L_0x019e:
            r5 = r5 | r26
            goto L_0x01a3
        L_0x01a1:
            r7 = r61
        L_0x01a3:
            r7 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01aa
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01bb
        L_0x01aa:
            r9 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01bb
            r9 = r62
            boolean r22 = r11.changed((boolean) r9)
            if (r22 == 0) goto L_0x01b8
            r17 = r18
        L_0x01b8:
            r5 = r5 | r17
            goto L_0x01bd
        L_0x01bb:
            r9 = r62
        L_0x01bd:
            r9 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01c6
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r10 = r63
            goto L_0x01da
        L_0x01c6:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r13 & r17
            r10 = r63
            if (r17 != 0) goto L_0x01da
            boolean r17 = r11.changed((boolean) r10)
            if (r17 == 0) goto L_0x01d6
            goto L_0x01d8
        L_0x01d6:
            r20 = r21
        L_0x01d8:
            r5 = r5 | r20
        L_0x01da:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r12 & r17
            if (r17 == 0) goto L_0x01e8
            r18 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r18
            r10 = r64
            goto L_0x01fd
        L_0x01e8:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r13 & r18
            r10 = r64
            if (r18 != 0) goto L_0x01fd
            boolean r18 = r11.changedInstance(r10)
            if (r18 == 0) goto L_0x01f9
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01fb
        L_0x01f9:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x01fb:
            r5 = r5 | r18
        L_0x01fd:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r1 & r18
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r13) goto L_0x0239
            r10 = 374491(0x5b6db, float:5.24774E-40)
            r10 = r10 & r5
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r10 != r13) goto L_0x0239
            boolean r10 = r11.getSkipping()
            if (r10 != 0) goto L_0x0217
            goto L_0x0239
        L_0x0217:
            r11.skipToGroupEnd()
            r3 = r51
            r4 = r52
            r5 = r53
            r6 = r54
            r7 = r55
            r8 = r56
            r9 = r57
            r10 = r58
            r12 = r60
            r13 = r61
            r14 = r62
            r15 = r63
            r16 = r64
            r1 = r11
            r11 = r59
            goto L_0x0871
        L_0x0239:
            r11.startDefaults()
            r10 = r14 & 1
            if (r10 == 0) goto L_0x026e
            boolean r10 = r11.getDefaultsInvalid()
            if (r10 == 0) goto L_0x0247
            goto L_0x026e
        L_0x0247:
            r11.skipToGroupEnd()
            r0 = r12 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0250
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0250:
            r14 = r51
            r20 = r52
            r13 = r53
            r21 = r54
            r10 = r55
            r23 = r56
            r24 = r57
            r9 = r58
            r25 = r59
            r8 = r60
            r26 = r61
            r7 = r62
            r27 = r63
            r30 = r64
            goto L_0x031f
        L_0x026e:
            if (r4 == 0) goto L_0x0275
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0277
        L_0x0275:
            r4 = r51
        L_0x0277:
            if (r16 == 0) goto L_0x0280
            androidx.compose.ui.text.TextStyle$Companion r10 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r10 = r10.getDefault()
            goto L_0x0282
        L_0x0280:
            r10 = r52
        L_0x0282:
            if (r19 == 0) goto L_0x028b
            androidx.compose.ui.text.input.VisualTransformation$Companion r16 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r16 = r16.getNone()
            goto L_0x028d
        L_0x028b:
            r16 = r53
        L_0x028d:
            if (r23 == 0) goto L_0x0294
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1 r19 = androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r19 = (kotlin.jvm.functions.Function1) r19
            goto L_0x0296
        L_0x0294:
            r19 = r54
        L_0x0296:
            if (r25 == 0) goto L_0x029b
            r20 = 0
            goto L_0x029d
        L_0x029b:
            r20 = r55
        L_0x029d:
            if (r8 == 0) goto L_0x02b1
            androidx.compose.ui.graphics.SolidColor r8 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r21 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r21.m3852getUnspecified0d7_KjU()
            r51 = r4
            r4 = 0
            r8.<init>(r13, r4)
            r4 = r8
            androidx.compose.ui.graphics.Brush r4 = (androidx.compose.ui.graphics.Brush) r4
            goto L_0x02b5
        L_0x02b1:
            r51 = r4
            r4 = r56
        L_0x02b5:
            if (r0 == 0) goto L_0x02b9
            r0 = 1
            goto L_0x02bb
        L_0x02b9:
            r0 = r57
        L_0x02bb:
            if (r2 == 0) goto L_0x02c1
            r2 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02c3
        L_0x02c1:
            r2 = r58
        L_0x02c3:
            if (r3 == 0) goto L_0x02c7
            r3 = 1
            goto L_0x02c9
        L_0x02c7:
            r3 = r59
        L_0x02c9:
            r8 = r12 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02d6
            androidx.compose.ui.text.input.ImeOptions$Companion r8 = androidx.compose.ui.text.input.ImeOptions.Companion
            androidx.compose.ui.text.input.ImeOptions r8 = r8.getDefault()
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02d8
        L_0x02d6:
            r8 = r60
        L_0x02d8:
            if (r6 == 0) goto L_0x02e1
            androidx.compose.foundation.text.KeyboardActions$Companion r6 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r6 = r6.getDefault()
            goto L_0x02e3
        L_0x02e1:
            r6 = r61
        L_0x02e3:
            if (r7 == 0) goto L_0x02e7
            r7 = 1
            goto L_0x02e9
        L_0x02e7:
            r7 = r62
        L_0x02e9:
            if (r9 == 0) goto L_0x02ed
            r9 = 0
            goto L_0x02ef
        L_0x02ed:
            r9 = r63
        L_0x02ef:
            if (r17 == 0) goto L_0x0306
            androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt r13 = androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r13 = r13.m1062getLambda1$foundation_release()
            r14 = r51
            r24 = r0
            r25 = r3
            r23 = r4
            r26 = r6
            r27 = r9
            r30 = r13
            goto L_0x0314
        L_0x0306:
            r14 = r51
            r30 = r64
            r24 = r0
            r25 = r3
            r23 = r4
            r26 = r6
            r27 = r9
        L_0x0314:
            r13 = r16
            r21 = r19
            r9 = r2
            r48 = r20
            r20 = r10
            r10 = r48
        L_0x031f:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0330
            java.lang.String r0 = "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:213)"
            r2 = -958708118(0xffffffffc6db466a, float:-28067.207)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r5, r0)
        L_0x0330:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.String r1 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r2 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x034f
            androidx.compose.ui.focus.FocusRequester r2 = new androidx.compose.ui.focus.FocusRequester
            r2.<init>()
            r11.updateRememberedValue(r2)
        L_0x034f:
            r11.endReplaceableGroup()
            androidx.compose.ui.focus.FocusRequester r2 = (androidx.compose.ui.focus.FocusRequester) r2
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextInputService()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            java.lang.Object r3 = r11.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.text.input.TextInputService r3 = (androidx.compose.ui.text.input.TextInputService) r3
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r19 = r0
            androidx.compose.ui.unit.Density r19 = (androidx.compose.ui.unit.Density) r19
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.text.font.FontFamily$Resolver r0 = (androidx.compose.ui.text.font.FontFamily.Resolver) r0
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            r12 = r16
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            java.lang.Object r12 = r11.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.foundation.text.selection.TextSelectionColors r12 = (androidx.compose.foundation.text.selection.TextSelectionColors) r12
            long r16 = r12.m1323getBackgroundColor0d7_KjU()
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            java.lang.Object r12 = r11.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.focus.FocusManager r12 = (androidx.compose.ui.focus.FocusManager) r12
            androidx.compose.runtime.ProvidableCompositionLocal r29 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalWindowInfo()
            r31 = r14
            r14 = r29
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            java.lang.Object r14 = r11.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.platform.WindowInfo r14 = (androidx.compose.ui.platform.WindowInfo) r14
            androidx.compose.runtime.ProvidableCompositionLocal r29 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalSoftwareKeyboardController()
            r64 = r5
            r5 = r29
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            java.lang.Object r5 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.platform.SoftwareKeyboardController r5 = (androidx.compose.ui.platform.SoftwareKeyboardController) r5
            r4 = 1
            if (r9 != r4) goto L_0x03f7
            if (r24 != 0) goto L_0x03f7
            boolean r22 = r8.getSingleLine()
            if (r22 == 0) goto L_0x03f7
            androidx.compose.foundation.gestures.Orientation r22 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x03f9
        L_0x03f7:
            androidx.compose.foundation.gestures.Orientation r22 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x03f9:
            r32 = r9
            r33 = r14
            r9 = r22
            java.lang.Object[] r14 = new java.lang.Object[r4]
            r4 = 0
            r14[r4] = r9
            androidx.compose.foundation.text.TextFieldScrollerPosition$Companion r4 = androidx.compose.foundation.text.TextFieldScrollerPosition.Companion
            androidx.compose.runtime.saveable.Saver r4 = r4.getSaver()
            r34 = r10
            r10 = 294183095(0x1188e0b7, float:2.1595508E-28)
            r11.startReplaceableGroup(r10)
            boolean r10 = r11.changed((java.lang.Object) r9)
            r35 = r8
            java.lang.Object r8 = r11.rememberedValue()
            if (r10 != 0) goto L_0x0426
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r8 != r10) goto L_0x0430
        L_0x0426:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            r8.<init>(r9)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r11.updateRememberedValue(r8)
        L_0x0430:
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r11.endReplaceableGroup()
            r9 = 72
            r10 = 4
            r36 = 0
            r51 = r14
            r52 = r4
            r53 = r36
            r54 = r8
            r55 = r11
            r56 = r9
            r57 = r10
            java.lang.Object r4 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r51, r52, (java.lang.String) r53, r54, (androidx.compose.runtime.Composer) r55, (int) r56, (int) r57)
            r8 = r4
            androidx.compose.foundation.text.TextFieldScrollerPosition r8 = (androidx.compose.foundation.text.TextFieldScrollerPosition) r8
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            boolean r4 = r11.changed((java.lang.Object) r15)
            boolean r9 = r11.changed((java.lang.Object) r13)
            r4 = r4 | r9
            java.lang.Object r9 = r11.rememberedValue()
            if (r4 != 0) goto L_0x0471
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r9 != r4) goto L_0x048f
        L_0x0471:
            androidx.compose.ui.text.AnnotatedString r4 = r49.getAnnotatedString()
            androidx.compose.ui.text.input.TransformedText r4 = androidx.compose.foundation.text.ValidatingOffsetMappingKt.filterWithValidation(r13, r4)
            androidx.compose.ui.text.TextRange r9 = r49.m6298getCompositionMzsxiRA()
            if (r9 == 0) goto L_0x048b
            long r9 = r9.m6046unboximpl()
            androidx.compose.foundation.text.TextFieldDelegate$Companion r14 = androidx.compose.foundation.text.TextFieldDelegate.Companion
            androidx.compose.ui.text.input.TransformedText r9 = r14.m1125applyCompositionDecoration72CqOWE(r9, r4)
            if (r9 != 0) goto L_0x048c
        L_0x048b:
            r9 = r4
        L_0x048c:
            r11.updateRememberedValue(r9)
        L_0x048f:
            r11.endReplaceableGroup()
            r4 = r9
            androidx.compose.ui.text.input.TransformedText r4 = (androidx.compose.ui.text.input.TransformedText) r4
            androidx.compose.ui.text.AnnotatedString r9 = r4.getText()
            androidx.compose.ui.text.input.OffsetMapping r14 = r4.getOffsetMapping()
            r36 = r8
            r10 = 0
            androidx.compose.runtime.RecomposeScope r8 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r11, r10)
            r10 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r10)
            boolean r10 = r11.changed((java.lang.Object) r5)
            r37 = r4
            java.lang.Object r4 = r11.rememberedValue()
            if (r10 != 0) goto L_0x04c3
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r4 != r10) goto L_0x04f4
        L_0x04c3:
            androidx.compose.foundation.text.TextFieldState r4 = new androidx.compose.foundation.text.TextFieldState
            androidx.compose.foundation.text.TextDelegate r10 = new androidx.compose.foundation.text.TextDelegate
            r38 = 300(0x12c, float:4.2E-43)
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r51 = r10
            r52 = r9
            r53 = r20
            r54 = r40
            r55 = r41
            r56 = r24
            r57 = r42
            r58 = r19
            r59 = r0
            r60 = r43
            r61 = r38
            r62 = r39
            r51.<init>(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62)
            r4.<init>(r10, r8, r5)
            r11.updateRememberedValue(r4)
        L_0x04f4:
            r11.endReplaceableGroup()
            androidx.compose.foundation.text.TextFieldState r4 = (androidx.compose.foundation.text.TextFieldState) r4
            androidx.compose.ui.text.AnnotatedString r5 = r49.getAnnotatedString()
            r51 = r4
            r52 = r5
            r53 = r9
            r54 = r20
            r55 = r24
            r56 = r19
            r57 = r0
            r58 = r50
            r59 = r26
            r60 = r12
            r61 = r16
            r51.m1148updatefnh65Uc(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61)
            androidx.compose.ui.text.input.EditProcessor r0 = r4.getProcessor()
            androidx.compose.ui.text.input.TextInputSession r5 = r4.getInputSession()
            r0.reset(r15, r5)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r0 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x0541
            androidx.compose.foundation.text.UndoManager r0 = new androidx.compose.foundation.text.UndoManager
            r5 = 0
            r8 = 0
            r9 = 1
            r0.<init>(r8, r9, r5)
            r11.updateRememberedValue(r0)
        L_0x0541:
            r11.endReplaceableGroup()
            androidx.compose.foundation.text.UndoManager r0 = (androidx.compose.foundation.text.UndoManager) r0
            r5 = 2
            r8 = 0
            r9 = 0
            r51 = r0
            r52 = r49
            r53 = r9
            r55 = r5
            r56 = r8
            androidx.compose.foundation.text.UndoManager.snapshotIfNeeded$default(r51, r52, r53, r55, r56)
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r5 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x0574
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r5 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager
            r5.<init>(r0)
            r11.updateRememberedValue(r5)
        L_0x0574:
            r11.endReplaceableGroup()
            r10 = r5
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r10 = (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r10
            r10.setOffsetMapping$foundation_release(r14)
            r10.setVisualTransformation$foundation_release(r13)
            kotlin.jvm.functions.Function1 r5 = r4.getOnValueChange()
            r10.setOnValueChange$foundation_release(r5)
            r10.setState$foundation_release(r4)
            r10.setValue$foundation_release(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r8, r6)
            java.lang.Object r5 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.platform.ClipboardManager r5 = (androidx.compose.ui.platform.ClipboardManager) r5
            r10.setClipboardManager$foundation_release(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r8, r6)
            java.lang.Object r5 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.platform.TextToolbar r5 = (androidx.compose.ui.platform.TextToolbar) r5
            r10.setTextToolbar(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r8, r6)
            java.lang.Object r5 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.hapticfeedback.HapticFeedback r5 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r5
            r10.setHapticFeedBack(r5)
            r10.setFocusRequester(r2)
            r5 = r27 ^ 1
            r10.setEditable(r5)
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r5 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x0608
            kotlin.coroutines.EmptyCoroutineContext r5 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlinx.coroutines.CoroutineScope r5 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r5, r11)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r6 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r6.<init>(r5)
            r11.updateRememberedValue(r6)
            r5 = r6
        L_0x0608:
            r11.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r5
            kotlinx.coroutines.CoroutineScope r5 = r5.getCoroutineScope()
            r11.endReplaceableGroup()
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r1 != r6) goto L_0x0630
            androidx.compose.foundation.relocation.BringIntoViewRequester r1 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r11.updateRememberedValue(r1)
        L_0x0630:
            r11.endReplaceableGroup()
            r16 = r1
            androidx.compose.foundation.relocation.BringIntoViewRequester r16 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r16
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
            r51 = r6
            r52 = r4
            r53 = r3
            r54 = r7
            r55 = r27
            r56 = r49
            r57 = r35
            r58 = r14
            r59 = r10
            r60 = r5
            r61 = r16
            r51.<init>(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r9 = r34
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.textFieldFocusModifier(r1, r7, r2, r9, r6)
            r5 = -55007276(0xfffffffffcb8a7d4, float:-7.6702926E36)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "344@17012L42,345@17063L1006"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            if (r3 == 0) goto L_0x0699
            if (r7 == 0) goto L_0x0671
            if (r27 != 0) goto L_0x0671
            r5 = 1
            goto L_0x0672
        L_0x0671:
            r5 = 0
        L_0x0672:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r6 = 0
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r5, r11, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2
            r17 = 0
            r51 = r8
            r52 = r4
            r53 = r5
            r54 = r3
            r55 = r10
            r56 = r35
            r57 = r17
            r51.<init>(r52, r53, r54, r55, r56, r57)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r5 = 70
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r6, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r8, (androidx.compose.runtime.Composer) r11, (int) r5)
        L_0x0699:
            r11.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
            r6.<init>(r4)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.text.selection.SelectionGesturesKt.updateSelectionTouchMode(r5, r6)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2
            r51 = r6
            r52 = r4
            r53 = r2
            r54 = r27
            r55 = r10
            r56 = r14
            r51.<init>(r52, r53, r54, r55, r56)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier(r5, r9, r7, r6)
            androidx.compose.foundation.text.selection.MouseSelectionObserver r6 = r10.getMouseSelectionObserver$foundation_release()
            androidx.compose.foundation.text.TextDragObserver r8 = r10.getTouchSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.text.selection.SelectionGesturesKt.selectionGestureInput(r5, r6, r8)
            androidx.compose.ui.input.pointer.PointerIcon r6 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r34 = r9
            r62 = r12
            r8 = 0
            r9 = 2
            r12 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r5, r6, r12, r9, r8)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
            r8.<init>(r4, r15, r14)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.ui.Modifier r17 = androidx.compose.ui.draw.DrawModifierKt.drawBehind(r6, r8)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
            r51 = r8
            r53 = r7
            r54 = r33
            r56 = r49
            r57 = r14
            r51.<init>(r52, r53, r54, r55, r56, r57)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.ui.Modifier r18 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r6, r8)
            boolean r6 = r13 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1 r9 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
            r51 = r9
            r52 = r37
            r53 = r49
            r54 = r7
            r55 = r6
            r56 = r35
            r57 = r27
            r58 = r4
            r59 = r14
            r60 = r10
            r61 = r2
            r51.<init>(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r2 = 1
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r8, r2, r9)
            if (r7 == 0) goto L_0x0739
            if (r27 != 0) goto L_0x0739
            boolean r2 = isWindowFocusedBehindFlag(r33)
            if (r2 == 0) goto L_0x0739
            r2 = 1
            goto L_0x073a
        L_0x0739:
            r2 = r12
        L_0x073a:
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r51 = r8
            r52 = r4
            r53 = r49
            r54 = r14
            r55 = r23
            r56 = r2
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.text.TextFieldCursorKt.cursor(r51, r52, r53, r54, r55, r56)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3 r2 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
            r2.<init>(r10)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r8 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r2, (androidx.compose.runtime.Composer) r11, (int) r8)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4 r2 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
            r8 = r35
            r2.<init>(r3, r4, r15, r8)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            int r3 = r64 >> 3
            r3 = r3 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r8, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r2, (androidx.compose.runtime.Composer) r11, (int) r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            kotlin.jvm.functions.Function1 r3 = r4.getOnValueChange()
            r28 = r27 ^ 1
            r12 = r32
            r15 = 1
            if (r12 != r15) goto L_0x077c
            r22 = r15
            goto L_0x077e
        L_0x077c:
            r22 = 0
        L_0x077e:
            int r32 = r8.m6250getImeActioneUduSuo()
            r51 = r2
            r52 = r4
            r53 = r10
            r54 = r49
            r55 = r3
            r56 = r28
            r57 = r22
            r58 = r14
            r59 = r0
            r60 = r32
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldKeyInputKt.m1134textFieldKeyInput2WJ9YEU(r51, r52, r53, r54, r55, r56, r57, r58, r59, r60)
            r3 = r31
            androidx.compose.ui.Modifier r1 = r3.then(r1)
            r2 = r62
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.text.TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(r1, r4, r2)
            androidx.compose.ui.Modifier r1 = previewKeyEventToDeselectOnBack(r1, r4, r10)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            r1 = r34
            r2 = r36
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable(r0, r2, r1, r7)
            androidx.compose.ui.Modifier r0 = r0.then(r5)
            androidx.compose.ui.Modifier r0 = r0.then(r6)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            r5.<init>(r4)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r5)
            if (r7 == 0) goto L_0x07e0
            boolean r0 = r4.getHasFocus()
            if (r0 == 0) goto L_0x07e0
            boolean r0 = r4.isInTouchMode()
            if (r0 == 0) goto L_0x07e0
            boolean r0 = isWindowFocusedBehindFlag(r33)
            if (r0 == 0) goto L_0x07e0
            r29 = r15
            goto L_0x07e2
        L_0x07e0:
            r29 = 0
        L_0x07e2:
            if (r29 == 0) goto L_0x07ed
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.textFieldMagnifier(r0, r10)
            goto L_0x07f1
        L_0x07ed:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x07f1:
            r22 = r0
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
            r0 = r5
            r28 = r1
            r1 = r30
            r31 = r2
            r2 = r4
            r32 = r3
            r3 = r20
            r4 = r25
            r44 = r5
            r5 = r12
            r45 = r6
            r6 = r31
            r31 = r7
            r7 = r49
            r33 = r8
            r8 = r13
            r48 = r28
            r28 = r12
            r12 = r48
            r34 = r12
            r12 = r10
            r10 = r17
            r46 = r11
            r11 = r18
            r51 = r12
            r12 = r22
            r22 = r13
            r13 = r16
            r18 = r14
            r14 = r51
            r15 = r29
            r16 = r27
            r17 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = -374338080(0xffffffffe9b00de0, float:-2.6604558E25)
            r2 = r44
            r1 = r46
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r3, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r2 = 448(0x1c0, float:6.28E-43)
            r5 = r51
            r3 = r45
            CoreTextFieldRootBox(r3, r5, r0, r1, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0855
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0855:
            r4 = r20
            r6 = r21
            r5 = r22
            r8 = r23
            r9 = r24
            r11 = r25
            r13 = r26
            r15 = r27
            r10 = r28
            r16 = r30
            r14 = r31
            r3 = r32
            r12 = r33
            r7 = r34
        L_0x0871:
            androidx.compose.runtime.ScopeUpdateScope r2 = r1.endRestartGroup()
            if (r2 == 0) goto L_0x0893
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6 r20 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
            r0 = r20
            r1 = r49
            r47 = r2
            r2 = r50
            r17 = r66
            r18 = r67
            r19 = r68
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r47
            r1.updateScope(r0)
        L_0x0893:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextFieldRootBox)P(2,1)747@33825L95:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, i, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:746)");
        }
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        Composer r4 = Updater.m3282constructorimpl(startRestartGroup);
        Updater.m3289setimpl(r4, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1087268488, "C748@33881L33:CoreTextField.kt#423gt5");
        startRestartGroup.startReplaceableGroup(-1985516685);
        ComposerKt.sourceInformation(startRestartGroup, "CC(ContextMenuArea)P(1)29@1062L9:ContextMenu.android.kt#423gt5");
        function2.invoke(startRestartGroup, Integer.valueOf(((((i >> 3) & 112) | 8) >> 3) & 14));
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$CoreTextFieldRootBox$2(modifier, textFieldSelectionManager, function2, i));
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(textFieldState, textFieldSelectionManager));
    }

    /* access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else if (z && (keyboardController = textFieldState.getKeyboardController()) != null) {
            keyboardController.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        textFieldState.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(textFieldState, textFieldValue, offsetMapping);
    }

    /* access modifiers changed from: private */
    public static final void endInputSession(TextFieldState textFieldState) {
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), textFieldState.getOnValueChange());
        }
        textFieldState.setInputSession((TextInputSession) null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m6039getMaximpl(textFieldValue.m6299getSelectiond9O1mEE()));
        if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed);
        } else if (originalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, (float) IntSize.m6789getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), (String) null, 0, 24, (Object) null)));
        }
        Object bringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z, Composer composer, int i) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles)1101@48248L202:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, i, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1082)");
        }
        if (z) {
            TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
            TextLayoutResult textLayoutResult = null;
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
                TextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
                if (!(state$foundation_release2 != null ? state$foundation_release2.isLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                if (!TextRange.m6036getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m6299getSelectiond9O1mEE())) {
                    int originalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m6042getStartimpl(textFieldSelectionManager.getValue$foundation_release().m6299getSelectiond9O1mEE()));
                    int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m6037getEndimpl(textFieldSelectionManager.getValue$foundation_release().m6299getSelectiond9O1mEE()));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                    startRestartGroup.startReplaceableGroup(-498386756);
                    ComposerKt.sourceInformation(startRestartGroup, "1094@47925L203");
                    TextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release3 != null && state$foundation_release3.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, 518);
                    }
                    startRestartGroup.endReplaceableGroup();
                    TextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release4 != null && state$foundation_release4.getShowSelectionHandleEnd()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, 518);
                    }
                }
                TextFieldState state$foundation_release5 = textFieldSelectionManager.getState$foundation_release();
                if (state$foundation_release5 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state$foundation_release5.setShowFloatingToolbar(false);
                    }
                    if (state$foundation_release5.getHasFocus()) {
                        if (state$foundation_release5.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$SelectionToolbarAndHandles$2(textFieldSelectionManager, z, i));
        }
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionManager textFieldSelectionManager, Composer composer, int i) {
        AnnotatedString transformedText$foundation_release;
        Composer startRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)1127@49342L50,1128@49455L7,1129@49472L1101:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, i, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1125)");
        }
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release != null && state$foundation_release.getShowCursorHandle() && (transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release()) != null && transformedText$foundation_release.length() > 0) {
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) textFieldSelectionManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long r3 = textFieldSelectionManager.m1303getCursorPositiontuRUvjQ$foundation_release((Density) consume);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new CoreTextFieldKt$TextFieldCursorHandle$1(textDragObserver, textFieldSelectionManager, (Continuation<? super CoreTextFieldKt$TextFieldCursorHandle$1>) null));
            startRestartGroup.startReplaceableGroup(294220498);
            boolean changed2 = startRestartGroup.changed(r3);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(r3);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m1042CursorHandleULxng0E(r3, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue2, 1, (Object) null), (Function2<? super Composer, ? super Integer, Unit>) null, startRestartGroup, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$TextFieldCursorHandle$3(textFieldSelectionManager, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void notifyFocusedRect(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot makeCurrent;
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
            if (layoutResult == null) {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
                return;
            }
            TextInputSession inputSession = textFieldState.getInputSession();
            if (inputSession == null) {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
                return;
            }
            LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
            if (layoutCoordinates == null) {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
                return;
            }
            TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(textFieldValue, textFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, textFieldState.getHasFocus(), offsetMapping);
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
