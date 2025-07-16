package androidx.compose.foundation.text2.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J:\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J2\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170$¢\u0006\u0002\b&H\bJ\u0013\u0010'\u001a\u0004\u0018\u00010(*\u00020\u0010H\u0002¢\u0006\u0002\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TextFieldKeyEventHandler;", "", "()V", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "preparedSelectionState", "Landroidx/compose/foundation/text2/input/internal/TextFieldPreparedSelectionState;", "onKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-6ptp14s", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "preparedSelectionContext", "state", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text2/input/internal/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "getVisibleTextLayoutHeight", "", "(Landroidx/compose/foundation/text2/input/internal/TextLayoutState;)Ljava/lang/Float;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldKeyEventHandler.kt */
public abstract class TextFieldKeyEventHandler {
    public static final int $stable = 8;
    private final DeadKeyCombiner deadKeyCombiner = new DeadKeyCombiner();
    private final KeyMapping keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();
    private final TextFieldPreparedSelectionState preparedSelectionState = new TextFieldPreparedSelectionState();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldKeyEventHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(98:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|(2:95|96)|97|99) */
        /* JADX WARNING: Can't wrap try/catch for region: R(99:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|99) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x010e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0118 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0136 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0140 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x014a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0154 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x015e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0172 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x017c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0186 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0190 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x019a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x01a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x01ae */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x01b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x01c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x01cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x01d6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.compose.foundation.text.KeyCommand[] r0 = androidx.compose.foundation.text.KeyCommand.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.COPY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.PASTE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.CUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LEFT_CHAR     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.RIGHT_CHAR     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LEFT_WORD     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.RIGHT_WORD     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.PREV_PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.NEXT_PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.UP     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DOWN     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.PAGE_UP     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.PAGE_DOWN     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LINE_START     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LINE_END     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LINE_LEFT     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LINE_RIGHT     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.HOME     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.END     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_PREV_CHAR     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_NEXT_CHAR     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_PREV_WORD     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_NEXT_WORD     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_FROM_LINE_START     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_TO_LINE_END     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.NEW_LINE     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.TAB     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_ALL     // Catch:{ NoSuchFieldError -> 0x0118 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0118 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0118 }
            L_0x0118:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LEFT_CHAR     // Catch:{ NoSuchFieldError -> 0x0122 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0122 }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0122 }
            L_0x0122:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_RIGHT_CHAR     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LEFT_WORD     // Catch:{ NoSuchFieldError -> 0x0136 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0136 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0136 }
            L_0x0136:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_RIGHT_WORD     // Catch:{ NoSuchFieldError -> 0x0140 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0140 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0140 }
            L_0x0140:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_PREV_PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x014a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x014a }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x014a }
            L_0x014a:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_NEXT_PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0154 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0154 }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0154 }
            L_0x0154:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LINE_START     // Catch:{ NoSuchFieldError -> 0x015e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015e }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015e }
            L_0x015e:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LINE_END     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LINE_LEFT     // Catch:{ NoSuchFieldError -> 0x0172 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0172 }
                r2 = 37
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0172 }
            L_0x0172:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LINE_RIGHT     // Catch:{ NoSuchFieldError -> 0x017c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x017c }
                r2 = 38
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x017c }
            L_0x017c:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_UP     // Catch:{ NoSuchFieldError -> 0x0186 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0186 }
                r2 = 39
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0186 }
            L_0x0186:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_DOWN     // Catch:{ NoSuchFieldError -> 0x0190 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0190 }
                r2 = 40
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0190 }
            L_0x0190:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_PAGE_UP     // Catch:{ NoSuchFieldError -> 0x019a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x019a }
                r2 = 41
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x019a }
            L_0x019a:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_PAGE_DOWN     // Catch:{ NoSuchFieldError -> 0x01a4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a4 }
                r2 = 42
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01a4 }
            L_0x01a4:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_HOME     // Catch:{ NoSuchFieldError -> 0x01ae }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ae }
                r2 = 43
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01ae }
            L_0x01ae:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_END     // Catch:{ NoSuchFieldError -> 0x01b8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b8 }
                r2 = 44
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01b8 }
            L_0x01b8:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DESELECT     // Catch:{ NoSuchFieldError -> 0x01c2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01c2 }
                r2 = 45
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01c2 }
            L_0x01c2:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.UNDO     // Catch:{ NoSuchFieldError -> 0x01cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01cc }
                r2 = 46
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01cc }
            L_0x01cc:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.REDO     // Catch:{ NoSuchFieldError -> 0x01d6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d6 }
                r2 = 47
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01d6 }
            L_0x01d6:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.CHARACTER_PALETTE     // Catch:{ NoSuchFieldError -> 0x01e0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e0 }
                r2 = 48
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01e0 }
            L_0x01e0:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: onPreKeyEvent-MyFupTE  reason: not valid java name */
    public boolean m1401onPreKeyEventMyFupTE(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        if (TextRange.m6036getCollapsedimpl(transformedTextFieldState.getText().m1346getSelectionInCharsd9O1mEE()) || !KeyEventHelpers_androidKt.m1070cancelsTextSelectionZmokQxo(keyEvent)) {
            return false;
        }
        textFieldSelectionState.deselect();
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: onKeyEvent-6ptp14s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1400onKeyEvent6ptp14s(android.view.KeyEvent r17, androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r18, androidx.compose.foundation.text2.input.internal.TextLayoutState r19, androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r20, boolean r21, boolean r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            int r3 = androidx.compose.ui.input.key.KeyEvent_androidKt.m4958getTypeZmokQxo(r17)
            androidx.compose.ui.input.key.KeyEventType$Companion r4 = androidx.compose.ui.input.key.KeyEventType.Companion
            int r4 = r4.m4954getKeyDownCS__XNY()
            boolean r3 = androidx.compose.ui.input.key.KeyEventType.m4950equalsimpl0(r3, r4)
            r4 = 0
            if (r3 != 0) goto L_0x0018
            return r4
        L_0x0018:
            boolean r3 = androidx.compose.foundation.text.TextFieldKeyInput_androidKt.m1137isTypedEventZmokQxo(r17)
            r5 = 1
            if (r3 == 0) goto L_0x009b
            androidx.compose.foundation.text.DeadKeyCombiner r3 = r0.deadKeyCombiner
            java.lang.Integer r3 = r3.m1067consumeZmokQxo(r1)
            if (r3 == 0) goto L_0x009b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r6 = 2
            r1.<init>(r6)
            int r3 = r3.intValue()
            java.lang.StringBuilder r1 = androidx.compose.foundation.text.StringHelpers_jvmKt.appendCodePointX(r1, r3)
            java.lang.String r1 = r1.toString()
            if (r21 == 0) goto L_0x009a
            androidx.compose.foundation.text2.input.TextFieldState r3 = r18.textFieldState
            androidx.compose.foundation.text2.input.InputTransformation r2 = r18.inputTransformation
            androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior r4 = androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior.MergeIfPossible
            androidx.compose.foundation.text2.input.TextFieldCharSequence r6 = r3.getText()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r7 = r3.getMainBuffer$foundation_release()
            androidx.compose.foundation.text2.input.internal.ChangeTracker r7 = r7.getChangeTracker()
            r7.clearChanges()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r7 = r3.getMainBuffer$foundation_release()
            r7.commitComposition()
            androidx.compose.foundation.text2.input.internal.EditCommandKt.commitText(r7, r1, r5)
            androidx.compose.foundation.text2.input.internal.EditingBuffer r1 = r3.getMainBuffer$foundation_release()
            androidx.compose.foundation.text2.input.internal.ChangeTracker r1 = r1.getChangeTracker()
            int r1 = r1.getChangeCount()
            if (r1 != 0) goto L_0x0091
            long r7 = r6.m1346getSelectionInCharsd9O1mEE()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r1 = r3.getMainBuffer$foundation_release()
            long r9 = r1.m1370getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6035equalsimpl0(r7, r9)
            if (r1 == 0) goto L_0x0091
            androidx.compose.ui.text.TextRange r1 = r6.m1345getCompositionInCharsMzsxiRA()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r7 = r3.getMainBuffer$foundation_release()
            androidx.compose.ui.text.TextRange r7 = r7.m1369getCompositionMzsxiRA()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r7)
            if (r1 == 0) goto L_0x0091
            goto L_0x0094
        L_0x0091:
            r3.commitEditAsUser(r6, r2, r5, r4)
        L_0x0094:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelectionState r1 = r0.preparedSelectionState
            r1.resetCachedX()
            r4 = r5
        L_0x009a:
            return r4
        L_0x009b:
            androidx.compose.foundation.text.KeyMapping r3 = r0.keyMapping
            androidx.compose.foundation.text.KeyCommand r1 = r3.m1071mapZmokQxo(r1)
            if (r1 == 0) goto L_0x0461
            boolean r3 = r1.getEditsText()
            if (r3 == 0) goto L_0x00ad
            if (r21 != 0) goto L_0x00ad
            goto L_0x0461
        L_0x00ad:
            androidx.compose.ui.text.TextLayoutResult r3 = r19.getLayoutResult()
            if (r3 != 0) goto L_0x00b5
            goto L_0x0460
        L_0x00b5:
            r6 = r19
            java.lang.Float r6 = r0.getVisibleTextLayoutHeight(r6)
            if (r6 == 0) goto L_0x0460
            float r6 = r6.floatValue()
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r7 = new androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelectionState r8 = r0.preparedSelectionState
            r7.<init>(r2, r3, r6, r8)
            int[] r3 = androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
            r3 = -1
            r6 = 0
            java.lang.String r8 = ""
            switch(r1) {
                case 1: goto L_0x0440;
                case 2: goto L_0x043c;
                case 3: goto L_0x0438;
                case 4: goto L_0x0430;
                case 5: goto L_0x0428;
                case 6: goto L_0x0424;
                case 7: goto L_0x0420;
                case 8: goto L_0x041c;
                case 9: goto L_0x0418;
                case 10: goto L_0x0414;
                case 11: goto L_0x0410;
                case 12: goto L_0x040c;
                case 13: goto L_0x0408;
                case 14: goto L_0x0404;
                case 15: goto L_0x0400;
                case 16: goto L_0x03fc;
                case 17: goto L_0x03f8;
                case 18: goto L_0x03f4;
                case 19: goto L_0x03f0;
                case 20: goto L_0x0394;
                case 21: goto L_0x0337;
                case 22: goto L_0x02fb;
                case 23: goto L_0x02bf;
                case 24: goto L_0x0283;
                case 25: goto L_0x0247;
                case 26: goto L_0x01e2;
                case 27: goto L_0x0182;
                case 28: goto L_0x017d;
                case 29: goto L_0x0174;
                case 30: goto L_0x016b;
                case 31: goto L_0x0162;
                case 32: goto L_0x0159;
                case 33: goto L_0x0150;
                case 34: goto L_0x0147;
                case 35: goto L_0x013e;
                case 36: goto L_0x0135;
                case 37: goto L_0x012c;
                case 38: goto L_0x0123;
                case 39: goto L_0x011a;
                case 40: goto L_0x0111;
                case 41: goto L_0x0108;
                case 42: goto L_0x00ff;
                case 43: goto L_0x00f6;
                case 44: goto L_0x00ed;
                case 45: goto L_0x00e8;
                case 46: goto L_0x00e3;
                case 47: goto L_0x00de;
                case 48: goto L_0x00d9;
                default: goto L_0x00d7;
            }
        L_0x00d7:
            goto L_0x0445
        L_0x00d9:
            androidx.compose.foundation.text.KeyEventHelpers_androidKt.showCharacterPalette()
            goto L_0x0445
        L_0x00de:
            r18.redo()
            goto L_0x0445
        L_0x00e3:
            r18.undo()
            goto L_0x0445
        L_0x00e8:
            r7.deselect()
            goto L_0x0445
        L_0x00ed:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorToEnd()
            r1.selectMovement()
            goto L_0x0445
        L_0x00f6:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorToHome()
            r1.selectMovement()
            goto L_0x0445
        L_0x00ff:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorDownByPage()
            r1.selectMovement()
            goto L_0x0445
        L_0x0108:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorUpByPage()
            r1.selectMovement()
            goto L_0x0445
        L_0x0111:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorDownByLine()
            r1.selectMovement()
            goto L_0x0445
        L_0x011a:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorUpByLine()
            r1.selectMovement()
            goto L_0x0445
        L_0x0123:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorToLineRightSide()
            r1.selectMovement()
            goto L_0x0445
        L_0x012c:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorToLineLeftSide()
            r1.selectMovement()
            goto L_0x0445
        L_0x0135:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorToLineEnd()
            r1.selectMovement()
            goto L_0x0445
        L_0x013e:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorToLineStart()
            r1.selectMovement()
            goto L_0x0445
        L_0x0147:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorNextByParagraph()
            r1.selectMovement()
            goto L_0x0445
        L_0x0150:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorPrevByParagraph()
            r1.selectMovement()
            goto L_0x0445
        L_0x0159:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorRightByWord()
            r1.selectMovement()
            goto L_0x0445
        L_0x0162:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorLeftByWord()
            r1.selectMovement()
            goto L_0x0445
        L_0x016b:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorRight()
            r1.selectMovement()
            goto L_0x0445
        L_0x0174:
            androidx.compose.foundation.text2.input.internal.TextFieldPreparedSelection r1 = r7.moveCursorLeft()
            r1.selectMovement()
            goto L_0x0445
        L_0x017d:
            r7.selectAll()
            goto L_0x0445
        L_0x0182:
            if (r22 != 0) goto L_0x0446
            androidx.compose.foundation.text2.input.TextFieldState r1 = r18.textFieldState
            androidx.compose.foundation.text2.input.InputTransformation r3 = r18.inputTransformation
            androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior r4 = androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior.MergeIfPossible
            androidx.compose.foundation.text2.input.TextFieldCharSequence r6 = r1.getText()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r8 = r1.getMainBuffer$foundation_release()
            androidx.compose.foundation.text2.input.internal.ChangeTracker r8 = r8.getChangeTracker()
            r8.clearChanges()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r8 = r1.getMainBuffer$foundation_release()
            r8.commitComposition()
            java.lang.String r9 = "\t"
            androidx.compose.foundation.text2.input.internal.EditCommandKt.commitText(r8, r9, r5)
            androidx.compose.foundation.text2.input.internal.EditingBuffer r8 = r1.getMainBuffer$foundation_release()
            androidx.compose.foundation.text2.input.internal.ChangeTracker r8 = r8.getChangeTracker()
            int r8 = r8.getChangeCount()
            if (r8 != 0) goto L_0x01dd
            long r8 = r6.m1346getSelectionInCharsd9O1mEE()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r10 = r1.getMainBuffer$foundation_release()
            long r10 = r10.m1370getSelectiond9O1mEE()
            boolean r8 = androidx.compose.ui.text.TextRange.m6035equalsimpl0(r8, r10)
            if (r8 == 0) goto L_0x01dd
            androidx.compose.ui.text.TextRange r8 = r6.m1345getCompositionInCharsMzsxiRA()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r9 = r1.getMainBuffer$foundation_release()
            androidx.compose.ui.text.TextRange r9 = r9.m1369getCompositionMzsxiRA()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x01dd
            goto L_0x0445
        L_0x01dd:
            r1.commitEditAsUser(r6, r3, r5, r4)
            goto L_0x0445
        L_0x01e2:
            if (r22 != 0) goto L_0x0242
            androidx.compose.foundation.text2.input.TextFieldState r1 = r18.textFieldState
            androidx.compose.foundation.text2.input.InputTransformation r3 = r18.inputTransformation
            androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior r4 = androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior.MergeIfPossible
            androidx.compose.foundation.text2.input.TextFieldCharSequence r6 = r1.getText()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r8 = r1.getMainBuffer$foundation_release()
            androidx.compose.foundation.text2.input.internal.ChangeTracker r8 = r8.getChangeTracker()
            r8.clearChanges()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r8 = r1.getMainBuffer$foundation_release()
            r8.commitComposition()
            java.lang.String r9 = "\n"
            androidx.compose.foundation.text2.input.internal.EditCommandKt.commitText(r8, r9, r5)
            androidx.compose.foundation.text2.input.internal.EditingBuffer r8 = r1.getMainBuffer$foundation_release()
            androidx.compose.foundation.text2.input.internal.ChangeTracker r8 = r8.getChangeTracker()
            int r8 = r8.getChangeCount()
            if (r8 != 0) goto L_0x023d
            long r8 = r6.m1346getSelectionInCharsd9O1mEE()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r10 = r1.getMainBuffer$foundation_release()
            long r10 = r10.m1370getSelectiond9O1mEE()
            boolean r8 = androidx.compose.ui.text.TextRange.m6035equalsimpl0(r8, r10)
            if (r8 == 0) goto L_0x023d
            androidx.compose.ui.text.TextRange r8 = r6.m1345getCompositionInCharsMzsxiRA()
            androidx.compose.foundation.text2.input.internal.EditingBuffer r9 = r1.getMainBuffer$foundation_release()
            androidx.compose.ui.text.TextRange r9 = r9.m1369getCompositionMzsxiRA()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x023d
            goto L_0x0445
        L_0x023d:
            r1.commitEditAsUser(r6, r3, r5, r4)
            goto L_0x0445
        L_0x0242:
            r23.invoke()
            goto L_0x0445
        L_0x0247:
            long r3 = r7.m1408getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6036getCollapsedimpl(r3)
            if (r1 != 0) goto L_0x0264
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            long r11 = r7.m1408getSelectiond9O1mEE()
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x0264:
            long r3 = r7.m1408getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m6042getStartimpl(r3)
            int r3 = r7.getLineEndByOffset()
            long r11 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r3)
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x0283:
            long r3 = r7.m1408getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6036getCollapsedimpl(r3)
            if (r1 != 0) goto L_0x02a0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            long r11 = r7.m1408getSelectiond9O1mEE()
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x02a0:
            int r1 = r7.getLineStartByOffset()
            long r3 = r7.m1408getSelectiond9O1mEE()
            int r3 = androidx.compose.ui.text.TextRange.m6037getEndimpl(r3)
            long r11 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r3)
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x02bf:
            long r3 = r7.m1408getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6036getCollapsedimpl(r3)
            if (r1 != 0) goto L_0x02dc
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            long r11 = r7.m1408getSelectiond9O1mEE()
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x02dc:
            long r3 = r7.m1408getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m6042getStartimpl(r3)
            int r3 = r7.getNextWordOffset()
            long r11 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r3)
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x02fb:
            long r3 = r7.m1408getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6036getCollapsedimpl(r3)
            if (r1 != 0) goto L_0x0318
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            long r11 = r7.m1408getSelectiond9O1mEE()
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x0318:
            int r1 = r7.getPreviousWordOffset()
            long r3 = r7.m1408getSelectiond9O1mEE()
            int r3 = androidx.compose.ui.text.TextRange.m6037getEndimpl(r3)
            long r11 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r3)
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x0337:
            long r9 = r7.m1408getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6036getCollapsedimpl(r9)
            if (r1 != 0) goto L_0x0354
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            long r11 = r7.m1408getSelectiond9O1mEE()
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x0354:
            int r1 = r7.getNextCharacterIndex()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4 = r1
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r4 == r3) goto L_0x0366
            goto L_0x0367
        L_0x0366:
            r1 = r6
        L_0x0367:
            if (r1 == 0) goto L_0x037f
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            long r3 = r7.m1408getSelectiond9O1mEE()
            int r3 = androidx.compose.ui.text.TextRange.m6042getStartimpl(r3)
            long r3 = androidx.compose.ui.text.TextRangeKt.TextRange(r3, r1)
            androidx.compose.ui.text.TextRange r6 = androidx.compose.ui.text.TextRange.m6030boximpl(r3)
        L_0x037f:
            if (r6 == 0) goto L_0x0445
            long r11 = r6.m6046unboximpl()
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x0394:
            long r9 = r7.m1408getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6036getCollapsedimpl(r9)
            if (r1 != 0) goto L_0x03b1
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            long r11 = r7.m1408getSelectiond9O1mEE()
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x03b1:
            int r1 = r7.getPrecedingCharacterIndex()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4 = r1
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r4 == r3) goto L_0x03c3
            goto L_0x03c4
        L_0x03c3:
            r1 = r6
        L_0x03c4:
            if (r1 == 0) goto L_0x03dc
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            long r3 = r7.m1408getSelectiond9O1mEE()
            int r3 = androidx.compose.ui.text.TextRange.m6037getEndimpl(r3)
            long r3 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r3)
            androidx.compose.ui.text.TextRange r6 = androidx.compose.ui.text.TextRange.m6030boximpl(r3)
        L_0x03dc:
            if (r6 == 0) goto L_0x0445
            long r11 = r6.m6046unboximpl()
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r9 = r7.state
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 4
            r15 = 0
            r13 = 0
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState.m1424replaceTextSbBc2M$default(r9, r10, r11, r13, r14, r15)
            goto L_0x0445
        L_0x03f0:
            r7.moveCursorToEnd()
            goto L_0x0445
        L_0x03f4:
            r7.moveCursorToHome()
            goto L_0x0445
        L_0x03f8:
            r7.moveCursorToLineRightSide()
            goto L_0x0445
        L_0x03fc:
            r7.moveCursorToLineLeftSide()
            goto L_0x0445
        L_0x0400:
            r7.moveCursorToLineEnd()
            goto L_0x0445
        L_0x0404:
            r7.moveCursorToLineStart()
            goto L_0x0445
        L_0x0408:
            r7.moveCursorDownByPage()
            goto L_0x0445
        L_0x040c:
            r7.moveCursorUpByPage()
            goto L_0x0445
        L_0x0410:
            r7.moveCursorDownByLine()
            goto L_0x0445
        L_0x0414:
            r7.moveCursorUpByLine()
            goto L_0x0445
        L_0x0418:
            r7.moveCursorNextByParagraph()
            goto L_0x0445
        L_0x041c:
            r7.moveCursorPrevByParagraph()
            goto L_0x0445
        L_0x0420:
            r7.moveCursorRightByWord()
            goto L_0x0445
        L_0x0424:
            r7.moveCursorLeftByWord()
            goto L_0x0445
        L_0x0428:
            androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$2 r1 = androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$2.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r7.collapseRightOr(r1)
            goto L_0x0445
        L_0x0430:
            androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$1 r1 = androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r7.collapseLeftOr(r1)
            goto L_0x0445
        L_0x0438:
            r20.cut()
            goto L_0x0445
        L_0x043c:
            r20.paste()
            goto L_0x0445
        L_0x0440:
            r1 = r20
            r1.copy(r4)
        L_0x0445:
            r4 = r5
        L_0x0446:
            long r5 = r7.m1408getSelectiond9O1mEE()
            androidx.compose.foundation.text2.input.TextFieldCharSequence r1 = r7.getInitialValue()
            long r8 = r1.m1346getSelectionInCharsd9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6035equalsimpl0(r5, r8)
            if (r1 != 0) goto L_0x045f
            long r5 = r7.m1408getSelectiond9O1mEE()
            r2.m1429selectCharsIn5zctL8(r5)
        L_0x045f:
            r5 = r4
        L_0x0460:
            return r5
        L_0x0461:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler.m1400onKeyEvent6ptp14s(android.view.KeyEvent, androidx.compose.foundation.text2.input.internal.TransformedTextFieldState, androidx.compose.foundation.text2.input.internal.TextLayoutState, androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState, boolean, boolean, kotlin.jvm.functions.Function0):boolean");
    }

    private final void preparedSelectionContext(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Function1<? super TextFieldPreparedSelection, Unit> function1) {
        Float visibleTextLayoutHeight;
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        if (layoutResult != null && (visibleTextLayoutHeight = getVisibleTextLayoutHeight(textLayoutState)) != null) {
            TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(transformedTextFieldState, layoutResult, visibleTextLayoutHeight.floatValue(), this.preparedSelectionState);
            function1.invoke(textFieldPreparedSelection);
            if (!TextRange.m6035equalsimpl0(textFieldPreparedSelection.m1408getSelectiond9O1mEE(), textFieldPreparedSelection.getInitialValue().m1346getSelectionInCharsd9O1mEE())) {
                transformedTextFieldState.m1429selectCharsIn5zctL8(textFieldPreparedSelection.m1408getSelectiond9O1mEE());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Float getVisibleTextLayoutHeight(androidx.compose.foundation.text2.input.internal.TextLayoutState r5) {
        /*
            r4 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.getTextLayoutNodeCoordinates()
            r1 = 0
            if (r0 == 0) goto L_0x0037
            boolean r2 = r0.isAttached()
            if (r2 == 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 == 0) goto L_0x0037
            androidx.compose.ui.layout.LayoutCoordinates r5 = r5.getDecoratorNodeCoordinates()
            if (r5 == 0) goto L_0x0028
            boolean r2 = r5.isAttached()
            if (r2 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r5 = r1
        L_0x001f:
            if (r5 == 0) goto L_0x0028
            r2 = 0
            r3 = 2
            androidx.compose.ui.geometry.Rect r5 = androidx.compose.ui.layout.LayoutCoordinates.CC.localBoundingBoxOf$default(r5, r0, r2, r3, r1)
            goto L_0x0029
        L_0x0028:
            r5 = r1
        L_0x0029:
            if (r5 == 0) goto L_0x0037
            long r0 = r5.m3595getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m3628getHeightimpl(r0)
            java.lang.Float r1 = java.lang.Float.valueOf(r5)
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler.getVisibleTextLayoutHeight(androidx.compose.foundation.text2.input.internal.TextLayoutState):java.lang.Float");
    }
}
