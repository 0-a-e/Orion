package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/text/TextLayoutResult;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClickableText.kt */
final class ClickableTextKt$ClickableText$2$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableTextKt$ClickableText$2$1(MutableState<TextLayoutResult> mutableState, Function1<? super TextLayoutResult, Unit> function1) {
        super(1);
        this.$layoutResult = mutableState;
        this.$onTextLayout = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextLayoutResult textLayoutResult) {
        this.$layoutResult.setValue(textLayoutResult);
        this.$onTextLayout.invoke(textLayoutResult);
    }
}
