package androidx.compose.material3.internal;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.android.kt */
final class ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1$2$1 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ PopupLayout $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1$2$1(PopupLayout popupLayout) {
        super(1);
        this.$this_apply = popupLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m2626invokeozmzZPI(((IntSize) obj).m6794unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m2626invokeozmzZPI(long j) {
        this.$this_apply.m2629setPopupContentSizefhxjrPA(IntSize.m6782boximpl(j));
        this.$this_apply.updatePosition();
    }
}
