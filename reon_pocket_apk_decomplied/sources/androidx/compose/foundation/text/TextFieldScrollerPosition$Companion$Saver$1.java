package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
final class TextFieldScrollerPosition$Companion$Saver$1 extends Lambda implements Function2<SaverScope, TextFieldScrollerPosition, List<? extends Object>> {
    public static final TextFieldScrollerPosition$Companion$Saver$1 INSTANCE = new TextFieldScrollerPosition$Companion$Saver$1();

    TextFieldScrollerPosition$Companion$Saver$1() {
        super(2);
    }

    public final List<Object> invoke(SaverScope saverScope, TextFieldScrollerPosition textFieldScrollerPosition) {
        return CollectionsKt.listOf(Float.valueOf(textFieldScrollerPosition.getOffset()), Boolean.valueOf(textFieldScrollerPosition.getOrientation() == Orientation.Vertical));
    }
}
