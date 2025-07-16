package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/node/CanFocusChecker;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", "value", "", "canFocus", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "canFocusValue", "Ljava/lang/Boolean;", "isCanFocusSet", "reset", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeKind.kt */
final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();
    private static Boolean canFocusValue;

    public /* synthetic */ FocusRequester getDown() {
        return FocusProperties.CC.$default$getDown(this);
    }

    public /* synthetic */ FocusRequester getEnd() {
        return FocusProperties.CC.$default$getEnd(this);
    }

    public /* synthetic */ Function1 getEnter() {
        return FocusProperties.CC.$default$getEnter(this);
    }

    public /* synthetic */ Function1 getExit() {
        return FocusProperties.CC.$default$getExit(this);
    }

    public /* synthetic */ FocusRequester getLeft() {
        return FocusProperties.CC.$default$getLeft(this);
    }

    public /* synthetic */ FocusRequester getNext() {
        return FocusProperties.CC.$default$getNext(this);
    }

    public /* synthetic */ FocusRequester getPrevious() {
        return FocusProperties.CC.$default$getPrevious(this);
    }

    public /* synthetic */ FocusRequester getRight() {
        return FocusProperties.CC.$default$getRight(this);
    }

    public /* synthetic */ FocusRequester getStart() {
        return FocusProperties.CC.$default$getStart(this);
    }

    public /* synthetic */ FocusRequester getUp() {
        return FocusProperties.CC.$default$getUp(this);
    }

    public /* synthetic */ void setDown(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setDown(this, focusRequester);
    }

    public /* synthetic */ void setEnd(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setEnd(this, focusRequester);
    }

    public /* synthetic */ void setEnter(Function1 function1) {
        FocusProperties.CC.$default$setEnter(this, function1);
    }

    public /* synthetic */ void setExit(Function1 function1) {
        FocusProperties.CC.$default$setExit(this, function1);
    }

    public /* synthetic */ void setLeft(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setLeft(this, focusRequester);
    }

    public /* synthetic */ void setNext(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setNext(this, focusRequester);
    }

    public /* synthetic */ void setPrevious(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setPrevious(this, focusRequester);
    }

    public /* synthetic */ void setRight(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setRight(this, focusRequester);
    }

    public /* synthetic */ void setStart(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setStart(this, focusRequester);
    }

    public /* synthetic */ void setUp(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setUp(this, focusRequester);
    }

    private CanFocusChecker() {
    }

    public boolean getCanFocus() {
        Boolean bool = canFocusValue;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new IllegalStateException("canFocus is read before it is written".toString());
    }

    public void setCanFocus(boolean z) {
        canFocusValue = Boolean.valueOf(z);
    }

    public final boolean isCanFocusSet() {
        return canFocusValue != null;
    }

    public final void reset() {
        canFocusValue = null;
    }
}
