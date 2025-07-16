package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"testTag", "Landroidx/compose/ui/Modifier;", "tag", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TestTag.kt */
public final class TestTagKt {
    public static final Modifier testTag(Modifier modifier, String str) {
        return SemanticsModifierKt.semantics$default(modifier, false, new TestTagKt$testTag$1(str), 1, (Object) null);
    }
}
