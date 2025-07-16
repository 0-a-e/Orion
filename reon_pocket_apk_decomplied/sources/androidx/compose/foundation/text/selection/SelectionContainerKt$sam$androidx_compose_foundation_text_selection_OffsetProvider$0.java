package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
final class SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 implements OffsetProvider, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(Function0 function0) {
        this.function = function0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof OffsetProvider) || !(obj instanceof FunctionAdapter)) {
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

    /* renamed from: provide-F1C5BW0  reason: not valid java name */
    public final /* synthetic */ long m1231provideF1C5BW0() {
        return ((Offset) this.function.invoke()).m3572unboximpl();
    }
}
