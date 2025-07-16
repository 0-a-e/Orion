package androidx.compose.material3;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/DraggableAnchorsConfig;", "Landroidx/compose/material3/SheetValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$modalBottomSheetAnchors$1$newAnchors$1 extends Lambda implements Function1<DraggableAnchorsConfig<SheetValue>, Unit> {
    final /* synthetic */ float $fullHeight;
    final /* synthetic */ long $sheetSize;
    final /* synthetic */ SheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$modalBottomSheetAnchors$1$newAnchors$1(float f, long j, SheetState sheetState) {
        super(1);
        this.$fullHeight = f;
        this.$sheetSize = j;
        this.$sheetState = sheetState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DraggableAnchorsConfig<SheetValue>) (DraggableAnchorsConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
        draggableAnchorsConfig.at(SheetValue.Hidden, this.$fullHeight);
        if (((float) IntSize.m6789getHeightimpl(this.$sheetSize)) > this.$fullHeight / ((float) 2) && !this.$sheetState.getSkipPartiallyExpanded$material3_release()) {
            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, this.$fullHeight / 2.0f);
        }
        if (IntSize.m6789getHeightimpl(this.$sheetSize) != 0) {
            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(0.0f, this.$fullHeight - ((float) IntSize.m6789getHeightimpl(this.$sheetSize))));
        }
    }
}
