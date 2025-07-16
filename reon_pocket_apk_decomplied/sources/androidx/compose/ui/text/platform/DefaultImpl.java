package androidx.compose.ui.text.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/platform/DefaultImpl;", "Landroidx/compose/ui/text/platform/EmojiCompatStatusDelegate;", "()V", "fontLoaded", "Landroidx/compose/runtime/State;", "", "getFontLoaded", "()Landroidx/compose/runtime/State;", "loadState", "getFontLoadState", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EmojiCompatStatus.android.kt */
final class DefaultImpl implements EmojiCompatStatusDelegate {
    /* access modifiers changed from: private */
    public State<Boolean> loadState;

    public DefaultImpl() {
        this.loadState = EmojiCompat.isConfigured() ? getFontLoadState() : null;
    }

    public State<Boolean> getFontLoaded() {
        State<Boolean> state = this.loadState;
        if (state != null) {
            Intrinsics.checkNotNull(state);
            return state;
        } else if (!EmojiCompat.isConfigured()) {
            return EmojiCompatStatus_androidKt.Falsey;
        } else {
            State<Boolean> fontLoadState = getFontLoadState();
            this.loadState = fontLoadState;
            Intrinsics.checkNotNull(fontLoadState);
            return fontLoadState;
        }
    }

    private final State<Boolean> getFontLoadState() {
        EmojiCompat emojiCompat = EmojiCompat.get();
        if (emojiCompat.getLoadState() == 1) {
            return new ImmutableBool(true);
        }
        MutableState mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        emojiCompat.registerInitCallback(new DefaultImpl$getFontLoadState$initCallback$1(mutableStateOf$default, this));
        return mutableStateOf$default;
    }
}
