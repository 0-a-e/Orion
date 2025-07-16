package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "delta", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
final class TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1 extends Lambda implements Function1<Float, Float> {
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1(TextFieldScrollerPosition textFieldScrollerPosition) {
        super(1);
        this.$scrollerPosition = textFieldScrollerPosition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    public final Float invoke(float f) {
        float offset = this.$scrollerPosition.getOffset() + f;
        if (offset > this.$scrollerPosition.getMaximum()) {
            f = this.$scrollerPosition.getMaximum() - this.$scrollerPosition.getOffset();
        } else if (offset < 0.0f) {
            f = -this.$scrollerPosition.getOffset();
        }
        TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
        textFieldScrollerPosition.setOffset(textFieldScrollerPosition.getOffset() + f);
        return Float.valueOf(f);
    }
}
