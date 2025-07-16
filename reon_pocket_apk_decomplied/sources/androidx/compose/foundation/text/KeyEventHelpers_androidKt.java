package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"showCharacterPalette", "", "cancelsTextSelection", "", "Landroidx/compose/ui/input/key/KeyEvent;", "cancelsTextSelection-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyEventHelpers.android.kt */
public final class KeyEventHelpers_androidKt {
    public static final void showCharacterPalette() {
    }

    /* renamed from: cancelsTextSelection-ZmokQxo  reason: not valid java name */
    public static final boolean m1070cancelsTextSelectionZmokQxo(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 4 && KeyEventType.m4950equalsimpl0(KeyEvent_androidKt.m4958getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4955getKeyUpCS__XNY());
    }
}
