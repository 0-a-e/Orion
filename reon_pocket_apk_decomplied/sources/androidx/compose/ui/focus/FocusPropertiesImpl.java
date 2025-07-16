package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR,\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000e¨\u00060"}, d2 = {"Landroidx/compose/ui/focus/FocusPropertiesImpl;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "down", "Landroidx/compose/ui/focus/FocusRequester;", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "enter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "getEnter$annotations", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "exit", "getExit$annotations", "getExit", "setExit", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
public final class FocusPropertiesImpl implements FocusProperties {
    public static final int $stable = 8;
    private boolean canFocus = true;
    private FocusRequester down = FocusRequester.Companion.getDefault();
    private FocusRequester end = FocusRequester.Companion.getDefault();
    private Function1<? super FocusDirection, FocusRequester> enter = FocusPropertiesImpl$enter$1.INSTANCE;
    private Function1<? super FocusDirection, FocusRequester> exit = FocusPropertiesImpl$exit$1.INSTANCE;
    private FocusRequester left = FocusRequester.Companion.getDefault();
    private FocusRequester next = FocusRequester.Companion.getDefault();
    private FocusRequester previous = FocusRequester.Companion.getDefault();
    private FocusRequester right = FocusRequester.Companion.getDefault();
    private FocusRequester start = FocusRequester.Companion.getDefault();
    private FocusRequester up = FocusRequester.Companion.getDefault();

    public static /* synthetic */ void getEnter$annotations() {
    }

    public static /* synthetic */ void getExit$annotations() {
    }

    public boolean getCanFocus() {
        return this.canFocus;
    }

    public void setCanFocus(boolean z) {
        this.canFocus = z;
    }

    public FocusRequester getNext() {
        return this.next;
    }

    public void setNext(FocusRequester focusRequester) {
        this.next = focusRequester;
    }

    public FocusRequester getPrevious() {
        return this.previous;
    }

    public void setPrevious(FocusRequester focusRequester) {
        this.previous = focusRequester;
    }

    public FocusRequester getUp() {
        return this.up;
    }

    public void setUp(FocusRequester focusRequester) {
        this.up = focusRequester;
    }

    public FocusRequester getDown() {
        return this.down;
    }

    public void setDown(FocusRequester focusRequester) {
        this.down = focusRequester;
    }

    public FocusRequester getLeft() {
        return this.left;
    }

    public void setLeft(FocusRequester focusRequester) {
        this.left = focusRequester;
    }

    public FocusRequester getRight() {
        return this.right;
    }

    public void setRight(FocusRequester focusRequester) {
        this.right = focusRequester;
    }

    public FocusRequester getStart() {
        return this.start;
    }

    public void setStart(FocusRequester focusRequester) {
        this.start = focusRequester;
    }

    public FocusRequester getEnd() {
        return this.end;
    }

    public void setEnd(FocusRequester focusRequester) {
        this.end = focusRequester;
    }

    public Function1<FocusDirection, FocusRequester> getEnter() {
        return this.enter;
    }

    public void setEnter(Function1<? super FocusDirection, FocusRequester> function1) {
        this.enter = function1;
    }

    public Function1<FocusDirection, FocusRequester> getExit() {
        return this.exit;
    }

    public void setExit(Function1<? super FocusDirection, FocusRequester> function1) {
        this.exit = function1;
    }
}
