package androidx.compose.ui.focus;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
final class FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0 implements FocusPropertiesScope, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void apply(FocusProperties focusProperties) {
        this.function.invoke(focusProperties);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FocusPropertiesScope) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
