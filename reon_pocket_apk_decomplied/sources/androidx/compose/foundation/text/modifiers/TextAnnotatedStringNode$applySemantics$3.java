package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Z)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextAnnotatedStringNode.kt */
final class TextAnnotatedStringNode$applySemantics$3 extends Lambda implements Function1<Boolean, Boolean> {
    final /* synthetic */ TextAnnotatedStringNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextAnnotatedStringNode$applySemantics$3(TextAnnotatedStringNode textAnnotatedStringNode) {
        super(1);
        this.this$0 = textAnnotatedStringNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }

    public final Boolean invoke(boolean z) {
        if (this.this$0.getTextSubstitution() == null) {
            return false;
        }
        TextAnnotatedStringNode.TextSubstitutionValue access$getTextSubstitution = this.this$0.getTextSubstitution();
        if (access$getTextSubstitution != null) {
            access$getTextSubstitution.setShowingSubstitution(z);
        }
        SemanticsModifierNodeKt.invalidateSemantics(this.this$0);
        LayoutModifierNodeKt.invalidateMeasurement(this.this$0);
        DrawModifierNodeKt.invalidateDraw(this.this$0);
        return true;
    }
}
