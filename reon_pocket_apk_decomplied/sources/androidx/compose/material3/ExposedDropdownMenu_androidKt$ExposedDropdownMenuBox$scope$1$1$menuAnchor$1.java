package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ MutableState<LayoutCoordinates> $anchorCoordinates$delegate;
    final /* synthetic */ MutableIntState $anchorWidth$delegate;
    final /* synthetic */ MutableIntState $menuMaxHeight$delegate;
    final /* synthetic */ int $verticalMargin;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1(View view, int i, MutableState<LayoutCoordinates> mutableState, MutableIntState mutableIntState, MutableIntState mutableIntState2) {
        super(1);
        this.$view = view;
        this.$verticalMargin = i;
        this.$anchorCoordinates$delegate = mutableState;
        this.$anchorWidth$delegate = mutableIntState;
        this.$menuMaxHeight$delegate = mutableIntState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$3(this.$anchorCoordinates$delegate, layoutCoordinates);
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$6(this.$anchorWidth$delegate, IntSize.m6790getWidthimpl(layoutCoordinates.m5318getSizeYbymL2g()));
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$9(this.$menuMaxHeight$delegate, ExposedDropdownMenu_androidKt.calculateMaxHeight(ExposedDropdownMenu_androidKt.getWindowBounds(this.$view.getRootView()), ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(this.$anchorCoordinates$delegate)), this.$verticalMargin));
    }
}
