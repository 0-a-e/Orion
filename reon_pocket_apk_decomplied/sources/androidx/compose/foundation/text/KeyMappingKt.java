package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyMapping.kt */
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping = new KeyMappingKt$defaultKeyMapping$2$1(commonKeyMapping(KeyMappingKt$defaultKeyMapping$1.INSTANCE));

    public static final KeyMapping commonKeyMapping(Function1<? super KeyEvent, Boolean> function1) {
        return new KeyMappingKt$commonKeyMapping$1(function1);
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }
}
