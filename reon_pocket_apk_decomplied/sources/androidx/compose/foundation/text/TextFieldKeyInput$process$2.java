package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldKeyInput.kt */
final class TextFieldKeyInput$process$2 extends Lambda implements Function1<TextFieldPreparedSelection, Unit> {
    final /* synthetic */ KeyCommand $command;
    final /* synthetic */ Ref.BooleanRef $consumed;
    final /* synthetic */ TextFieldKeyInput this$0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldKeyInput.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldKeyInput$process$2.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKeyInput$process$2(KeyCommand keyCommand, TextFieldKeyInput textFieldKeyInput, Ref.BooleanRef booleanRef) {
        super(1);
        this.$command = keyCommand;
        this.this$0 = textFieldKeyInput;
        this.$consumed = booleanRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldPreparedSelection) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
        TextFieldValue undo;
        TextFieldValue redo;
        switch (WhenMappings.$EnumSwitchMapping$0[this.$command.ordinal()]) {
            case 1:
                this.this$0.getSelectionManager().copy$foundation_release(false);
                return;
            case 2:
                this.this$0.getSelectionManager().paste$foundation_release();
                return;
            case 3:
                this.this$0.getSelectionManager().cut$foundation_release();
                return;
            case 4:
                textFieldPreparedSelection.collapseLeftOr(AnonymousClass1.INSTANCE);
                return;
            case 5:
                textFieldPreparedSelection.collapseRightOr(AnonymousClass2.INSTANCE);
                return;
            case 6:
                textFieldPreparedSelection.moveCursorLeftByWord();
                return;
            case 7:
                textFieldPreparedSelection.moveCursorRightByWord();
                return;
            case 8:
                textFieldPreparedSelection.moveCursorPrevByParagraph();
                return;
            case 9:
                textFieldPreparedSelection.moveCursorNextByParagraph();
                return;
            case 10:
                textFieldPreparedSelection.moveCursorUpByLine();
                return;
            case 11:
                textFieldPreparedSelection.moveCursorDownByLine();
                return;
            case 12:
                textFieldPreparedSelection.moveCursorUpByPage();
                return;
            case 13:
                textFieldPreparedSelection.moveCursorDownByPage();
                return;
            case 14:
                textFieldPreparedSelection.moveCursorToLineStart();
                return;
            case 15:
                textFieldPreparedSelection.moveCursorToLineEnd();
                return;
            case 16:
                textFieldPreparedSelection.moveCursorToLineLeftSide();
                return;
            case 17:
                textFieldPreparedSelection.moveCursorToLineRightSide();
                return;
            case 18:
                textFieldPreparedSelection.moveCursorToHome();
                return;
            case 19:
                textFieldPreparedSelection.moveCursorToEnd();
                return;
            case 20:
                List<EditCommand> deleteIfSelectedOr = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass3.INSTANCE);
                if (deleteIfSelectedOr != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr);
                    return;
                }
                return;
            case 21:
                List<EditCommand> deleteIfSelectedOr2 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass4.INSTANCE);
                if (deleteIfSelectedOr2 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr2);
                    return;
                }
                return;
            case 22:
                List<EditCommand> deleteIfSelectedOr3 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass5.INSTANCE);
                if (deleteIfSelectedOr3 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr3);
                    return;
                }
                return;
            case 23:
                List<EditCommand> deleteIfSelectedOr4 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass6.INSTANCE);
                if (deleteIfSelectedOr4 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr4);
                    return;
                }
                return;
            case 24:
                List<EditCommand> deleteIfSelectedOr5 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass7.INSTANCE);
                if (deleteIfSelectedOr5 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr5);
                    return;
                }
                return;
            case 25:
                List<EditCommand> deleteIfSelectedOr6 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass8.INSTANCE);
                if (deleteIfSelectedOr6 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr6);
                    return;
                }
                return;
            case 26:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply((EditCommand) new CommitTextCommand("\n", 1));
                    return;
                } else {
                    this.this$0.getState().getOnImeActionPerformed().invoke(ImeAction.m6222boximpl(this.this$0.imeAction));
                    return;
                }
            case 27:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply((EditCommand) new CommitTextCommand("\t", 1));
                    return;
                } else {
                    this.$consumed.element = false;
                    return;
                }
            case 28:
                textFieldPreparedSelection.selectAll();
                return;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /*29*/:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorLeft()).selectMovement();
                return;
            case 30:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorRight()).selectMovement();
                return;
            case 31:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorLeftByWord()).selectMovement();
                return;
            case 32:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorRightByWord()).selectMovement();
                return;
            case 33:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorPrevByParagraph()).selectMovement();
                return;
            case 34:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorNextByParagraph()).selectMovement();
                return;
            case 35:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToLineStart()).selectMovement();
                return;
            case 36:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToLineEnd()).selectMovement();
                return;
            case 37:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToLineLeftSide()).selectMovement();
                return;
            case 38:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToLineRightSide()).selectMovement();
                return;
            case 39:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorUpByLine()).selectMovement();
                return;
            case 40:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorDownByLine()).selectMovement();
                return;
            case 41:
                textFieldPreparedSelection.moveCursorUpByPage().selectMovement();
                return;
            case 42:
                textFieldPreparedSelection.moveCursorDownByPage().selectMovement();
                return;
            case 43:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToHome()).selectMovement();
                return;
            case 44:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToEnd()).selectMovement();
                return;
            case 45:
                textFieldPreparedSelection.deselect();
                return;
            case 46:
                UndoManager undoManager = this.this$0.getUndoManager();
                if (undoManager != null) {
                    undoManager.makeSnapshot(textFieldPreparedSelection.getValue());
                }
                UndoManager undoManager2 = this.this$0.getUndoManager();
                if (undoManager2 != null && (undo = undoManager2.undo()) != null) {
                    this.this$0.onValueChange.invoke(undo);
                    return;
                }
                return;
            case 47:
                UndoManager undoManager3 = this.this$0.getUndoManager();
                if (undoManager3 != null && (redo = undoManager3.redo()) != null) {
                    this.this$0.onValueChange.invoke(redo);
                    return;
                }
                return;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /*48*/:
                KeyEventHelpers_androidKt.showCharacterPalette();
                return;
            default:
                return;
        }
    }
}
