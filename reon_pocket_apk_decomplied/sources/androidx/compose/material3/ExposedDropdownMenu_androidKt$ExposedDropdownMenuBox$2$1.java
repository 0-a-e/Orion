package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<LayoutCoordinates> $anchorCoordinates$delegate;
    final /* synthetic */ MutableIntState $menuMaxHeight$delegate;
    final /* synthetic */ int $verticalMargin;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1(View view, int i, MutableState<LayoutCoordinates> mutableState, MutableIntState mutableIntState) {
        super(0);
        this.$view = view;
        this.$verticalMargin = i;
        this.$anchorCoordinates$delegate = mutableState;
        this.$menuMaxHeight$delegate = mutableIntState;
    }

    public final void invoke() {
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$9(this.$menuMaxHeight$delegate, ExposedDropdownMenu_androidKt.calculateMaxHeight(ExposedDropdownMenu_androidKt.getWindowBounds(this.$view.getRootView()), ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(this.$anchorCoordinates$delegate)), this.$verticalMargin));
    }
}
