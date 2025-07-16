package androidx.compose.ui.text.input;

import android.view.KeyEvent;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J8\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H&ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/input/InputEventCallback2;", "", "onConnectionClosed", "", "inputConnection", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "onEditCommands", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeAction", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction-KlQnJC8", "(I)V", "onKeyEvent", "event", "Landroid/view/KeyEvent;", "onRequestCursorAnchorInfo", "immediate", "", "monitor", "includeInsertionMarker", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InputEventCallback2.android.kt */
public interface InputEventCallback2 {
    void onConnectionClosed(RecordingInputConnection recordingInputConnection);

    void onEditCommands(List<? extends EditCommand> list);

    /* renamed from: onImeAction-KlQnJC8  reason: not valid java name */
    void m6253onImeActionKlQnJC8(int i);

    void onKeyEvent(KeyEvent keyEvent);

    void onRequestCursorAnchorInfo(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);
}
