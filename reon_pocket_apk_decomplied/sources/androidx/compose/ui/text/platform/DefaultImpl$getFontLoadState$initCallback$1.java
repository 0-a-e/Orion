package androidx.compose.ui.text.platform;

import androidx.compose.runtime.MutableState;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/ui/text/platform/DefaultImpl$getFontLoadState$initCallback$1", "Landroidx/emoji2/text/EmojiCompat$InitCallback;", "onFailed", "", "throwable", "", "onInitialized", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EmojiCompatStatus.android.kt */
public final class DefaultImpl$getFontLoadState$initCallback$1 extends EmojiCompat.InitCallback {
    final /* synthetic */ MutableState<Boolean> $mutableLoaded;
    final /* synthetic */ DefaultImpl this$0;

    DefaultImpl$getFontLoadState$initCallback$1(MutableState<Boolean> mutableState, DefaultImpl defaultImpl) {
        this.$mutableLoaded = mutableState;
        this.this$0 = defaultImpl;
    }

    public void onInitialized() {
        this.$mutableLoaded.setValue(true);
        this.this$0.loadState = new ImmutableBool(true);
    }

    public void onFailed(Throwable th) {
        this.this$0.loadState = EmojiCompatStatus_androidKt.Falsey;
    }
}
