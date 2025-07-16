package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$onObservedReadsChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$onObservedReadsChanged$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(0);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    public final void invoke() {
        TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
        textFieldDecoratorModifierNode.windowInfo = (WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldDecoratorModifierNode, CompositionLocalsKt.getLocalWindowInfo());
        this.this$0.startOrDisposeInputSessionOnWindowFocusChange();
    }
}
