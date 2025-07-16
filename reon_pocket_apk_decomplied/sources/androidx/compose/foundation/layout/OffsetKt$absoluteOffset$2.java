package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Offset.kt */
final class OffsetKt$absoluteOffset$2 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function1<Density, IntOffset> $offset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OffsetKt$absoluteOffset$2(Function1<? super Density, IntOffset> function1) {
        super(1);
        this.$offset = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("absoluteOffset");
        inspectorInfo.getProperties().set("offset", this.$offset);
    }
}
