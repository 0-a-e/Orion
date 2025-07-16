package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001e\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016R\"\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusOrderToProperties;", "Landroidx/compose/ui/focus/FocusPropertiesScope;", "focusOrderReceiver", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusOrder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getFocusOrderReceiver", "()Lkotlin/jvm/functions/Function1;", "apply", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOrderModifier.kt */
public final class FocusOrderToProperties implements FocusPropertiesScope {
    public static final int $stable = 0;
    private final Function1<FocusOrder, Unit> focusOrderReceiver;

    public FocusOrderToProperties(Function1<? super FocusOrder, Unit> function1) {
        this.focusOrderReceiver = function1;
    }

    public final Function1<FocusOrder, Unit> getFocusOrderReceiver() {
        return this.focusOrderReceiver;
    }

    public void apply(FocusProperties focusProperties) {
        this.focusOrderReceiver.invoke(new FocusOrder(focusProperties));
    }
}
