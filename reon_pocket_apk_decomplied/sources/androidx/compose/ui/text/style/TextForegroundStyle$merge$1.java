package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextForegroundStyle.kt */
final class TextForegroundStyle$merge$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ TextForegroundStyle this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextForegroundStyle$merge$1(TextForegroundStyle textForegroundStyle) {
        super(0);
        this.this$0 = textForegroundStyle;
    }

    public final Float invoke() {
        return Float.valueOf(this.this$0.getAlpha());
    }
}
