package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextStringSimpleNode.kt */
final class TextStringSimpleNode$applySemantics$4 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TextStringSimpleNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextStringSimpleNode$applySemantics$4(TextStringSimpleNode textStringSimpleNode) {
        super(0);
        this.this$0 = textStringSimpleNode;
    }

    public final Boolean invoke() {
        this.this$0.clearSubstitution();
        SemanticsModifierNodeKt.invalidateSemantics(this.this$0);
        LayoutModifierNodeKt.invalidateMeasurement(this.this$0);
        DrawModifierNodeKt.invalidateDraw(this.this$0);
        return true;
    }
}
