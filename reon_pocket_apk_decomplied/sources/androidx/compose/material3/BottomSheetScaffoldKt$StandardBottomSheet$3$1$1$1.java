package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $dismissActionLabel;
    final /* synthetic */ String $expandActionLabel;
    final /* synthetic */ String $partialExpandActionLabel;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ SheetState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1(SheetState sheetState, boolean z, String str, String str2, String str3, CoroutineScope coroutineScope) {
        super(1);
        this.$state = sheetState;
        this.$sheetSwipeEnabled = z;
        this.$expandActionLabel = str;
        this.$partialExpandActionLabel = str2;
        this.$dismissActionLabel = str3;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SheetState sheetState = this.$state;
        boolean z = this.$sheetSwipeEnabled;
        String str = this.$expandActionLabel;
        String str2 = this.$partialExpandActionLabel;
        String str3 = this.$dismissActionLabel;
        CoroutineScope coroutineScope = this.$scope;
        if (sheetState.getAnchoredDraggableState$material3_release().getAnchors().getSize() > 1 && z) {
            if (sheetState.getCurrentValue() == SheetValue.PartiallyExpanded) {
                if (sheetState.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                    SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1(coroutineScope, sheetState));
                }
            } else if (sheetState.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str2, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2(coroutineScope, sheetState));
            }
            if (!sheetState.getSkipHiddenState$material3_release()) {
                SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str3, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3(coroutineScope, sheetState));
            }
        }
    }
}
