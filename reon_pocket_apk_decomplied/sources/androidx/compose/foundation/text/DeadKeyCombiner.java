package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/DeadKeyCombiner;", "", "()V", "deadKeyCode", "", "Ljava/lang/Integer;", "consume", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "consume-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DeadKeyCombiner.android.kt */
public final class DeadKeyCombiner {
    public static final int $stable = 8;
    private Integer deadKeyCode;

    /* renamed from: consume-ZmokQxo  reason: not valid java name */
    public final Integer m1067consumeZmokQxo(KeyEvent keyEvent) {
        int r4 = KeyEvent_androidKt.m4959getUtf16CodePointZmokQxo(keyEvent);
        Integer num = null;
        if ((Integer.MIN_VALUE & r4) != 0) {
            this.deadKeyCode = Integer.valueOf(r4 & Integer.MAX_VALUE);
            return null;
        }
        Integer num2 = this.deadKeyCode;
        if (num2 == null) {
            return Integer.valueOf(r4);
        }
        this.deadKeyCode = null;
        Integer valueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(num2.intValue(), r4));
        if (valueOf.intValue() != 0) {
            num = valueOf;
        }
        return num == null ? Integer.valueOf(r4) : num;
    }
}
