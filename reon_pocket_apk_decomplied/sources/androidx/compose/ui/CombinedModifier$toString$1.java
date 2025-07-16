package androidx.compose.ui;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "acc", "element", "Landroidx/compose/ui/Modifier$Element;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Modifier.kt */
final class CombinedModifier$toString$1 extends Lambda implements Function2<String, Modifier.Element, String> {
    public static final CombinedModifier$toString$1 INSTANCE = new CombinedModifier$toString$1();

    CombinedModifier$toString$1() {
        super(2);
    }

    public final String invoke(String str, Modifier.Element element) {
        if (str.length() == 0) {
            return element.toString();
        }
        return str + ", " + element;
    }
}
