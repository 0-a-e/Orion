package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, d2 = {"androidx/compose/foundation/text/KeyMappingKt$defaultKeyMapping$2$1", "Landroidx/compose/foundation/text/KeyMapping;", "map", "Landroidx/compose/foundation/text/KeyCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "map-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/foundation/text/KeyCommand;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyMapping.kt */
public final class KeyMappingKt$defaultKeyMapping$2$1 implements KeyMapping {
    final /* synthetic */ KeyMapping $common;

    KeyMappingKt$defaultKeyMapping$2$1(KeyMapping keyMapping) {
        this.$common = keyMapping;
    }

    /* renamed from: map-ZmokQxo  reason: not valid java name */
    public KeyCommand m1073mapZmokQxo(KeyEvent keyEvent) {
        KeyCommand keyCommand = null;
        if (KeyEvent_androidKt.m4963isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m4961isCtrlPressedZmokQxo(keyEvent)) {
            long r2 = KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent);
            if (Key.m4649equalsimpl0(r2, MappedKeys.INSTANCE.m1097getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_LEFT_WORD;
            } else if (Key.m4649equalsimpl0(r2, MappedKeys.INSTANCE.m1098getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_RIGHT_WORD;
            } else if (Key.m4649equalsimpl0(r2, MappedKeys.INSTANCE.m1099getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
            } else if (Key.m4649equalsimpl0(r2, MappedKeys.INSTANCE.m1096getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
            }
        } else if (KeyEvent_androidKt.m4961isCtrlPressedZmokQxo(keyEvent)) {
            long r22 = KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent);
            if (Key.m4649equalsimpl0(r22, MappedKeys.INSTANCE.m1097getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.LEFT_WORD;
            } else if (Key.m4649equalsimpl0(r22, MappedKeys.INSTANCE.m1098getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.RIGHT_WORD;
            } else if (Key.m4649equalsimpl0(r22, MappedKeys.INSTANCE.m1099getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.PREV_PARAGRAPH;
            } else if (Key.m4649equalsimpl0(r22, MappedKeys.INSTANCE.m1096getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.NEXT_PARAGRAPH;
            } else if (Key.m4649equalsimpl0(r22, MappedKeys.INSTANCE.m1101getHEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_PREV_CHAR;
            } else if (Key.m4649equalsimpl0(r22, MappedKeys.INSTANCE.m1095getDeleteEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_NEXT_WORD;
            } else if (Key.m4649equalsimpl0(r22, MappedKeys.INSTANCE.m1091getBackspaceEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_PREV_WORD;
            } else if (Key.m4649equalsimpl0(r22, MappedKeys.INSTANCE.m1090getBackslashEK5gGoQ())) {
                keyCommand = KeyCommand.DESELECT;
            }
        } else if (KeyEvent_androidKt.m4963isShiftPressedZmokQxo(keyEvent)) {
            long r23 = KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent);
            if (Key.m4649equalsimpl0(r23, MappedKeys.INSTANCE.m1104getMoveHomeEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_LINE_LEFT;
            } else if (Key.m4649equalsimpl0(r23, MappedKeys.INSTANCE.m1103getMoveEndEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_LINE_RIGHT;
            }
        } else if (KeyEvent_androidKt.m4960isAltPressedZmokQxo(keyEvent)) {
            long r24 = KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent);
            if (Key.m4649equalsimpl0(r24, MappedKeys.INSTANCE.m1091getBackspaceEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_FROM_LINE_START;
            } else if (Key.m4649equalsimpl0(r24, MappedKeys.INSTANCE.m1095getDeleteEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_TO_LINE_END;
            }
        }
        return keyCommand == null ? this.$common.m1071mapZmokQxo(keyEvent) : keyCommand;
    }
}
