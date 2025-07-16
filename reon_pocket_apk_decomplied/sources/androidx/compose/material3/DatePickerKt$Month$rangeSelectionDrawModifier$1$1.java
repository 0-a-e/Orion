package androidx.compose.material3;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$Month$rangeSelectionDrawModifier$1$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ SelectedRangeInfo $rangeSelectionInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$Month$rangeSelectionDrawModifier$1$1(SelectedRangeInfo selectedRangeInfo, DatePickerColors datePickerColors) {
        super(1);
        this.$rangeSelectionInfo = selectedRangeInfo;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        DateRangePickerKt.m1790drawRangeBackgroundmxwnekA(contentDrawScope, this.$rangeSelectionInfo, this.$colors.m1741getDayInSelectionRangeContainerColor0d7_KjU());
        contentDrawScope.drawContent();
    }
}
