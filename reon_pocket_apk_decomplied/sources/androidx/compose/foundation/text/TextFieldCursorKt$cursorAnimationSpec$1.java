package androidx.compose.foundation.text;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCursor.kt */
final class TextFieldCursorKt$cursorAnimationSpec$1 extends Lambda implements Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit> {
    public static final TextFieldCursorKt$cursorAnimationSpec$1 INSTANCE = new TextFieldCursorKt$cursorAnimationSpec$1();

    TextFieldCursorKt$cursorAnimationSpec$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) (KeyframesSpec.KeyframesSpecConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(1000);
        Float valueOf = Float.valueOf(1.0f);
        keyframesSpecConfig.at((Object) valueOf, 0);
        keyframesSpecConfig.at((Object) valueOf, 499);
        Float valueOf2 = Float.valueOf(0.0f);
        keyframesSpecConfig.at((Object) valueOf2, 500);
        keyframesSpecConfig.at((Object) valueOf2, 999);
    }
}
