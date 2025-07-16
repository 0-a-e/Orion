package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0012R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnEvent", "()Lkotlin/jvm/functions/Function1;", "setOnEvent", "(Lkotlin/jvm/functions/Function1;)V", "getOnPreEvent", "setOnPreEvent", "onKeyEvent", "event", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyInputModifier.kt */
final class KeyInputNode extends Modifier.Node implements KeyInputModifierNode {
    private Function1<? super KeyEvent, Boolean> onEvent;
    private Function1<? super KeyEvent, Boolean> onPreEvent;

    public final Function1<KeyEvent, Boolean> getOnEvent() {
        return this.onEvent;
    }

    public final void setOnEvent(Function1<? super KeyEvent, Boolean> function1) {
        this.onEvent = function1;
    }

    public final Function1<KeyEvent, Boolean> getOnPreEvent() {
        return this.onPreEvent;
    }

    public final void setOnPreEvent(Function1<? super KeyEvent, Boolean> function1) {
        this.onPreEvent = function1;
    }

    public KeyInputNode(Function1<? super KeyEvent, Boolean> function1, Function1<? super KeyEvent, Boolean> function12) {
        this.onEvent = function1;
        this.onPreEvent = function12;
    }

    /* renamed from: onKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m4966onKeyEventZmokQxo(KeyEvent keyEvent) {
        Function1<? super KeyEvent, Boolean> function1 = this.onEvent;
        if (function1 != null) {
            return function1.invoke(KeyEvent.m4940boximpl(keyEvent)).booleanValue();
        }
        return false;
    }

    /* renamed from: onPreKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m4967onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        Function1<? super KeyEvent, Boolean> function1 = this.onPreEvent;
        if (function1 != null) {
            return function1.invoke(KeyEvent.m4940boximpl(keyEvent)).booleanValue();
        }
        return false;
    }
}
