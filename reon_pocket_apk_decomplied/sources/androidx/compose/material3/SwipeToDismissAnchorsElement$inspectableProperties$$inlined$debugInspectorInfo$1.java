package androidx.compose.material3;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class SwipeToDismissAnchorsElement$inspectableProperties$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ SwipeToDismissAnchorsElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeToDismissAnchorsElement$inspectableProperties$$inlined$debugInspectorInfo$1(SwipeToDismissAnchorsElement swipeToDismissAnchorsElement) {
        super(1);
        this.this$0 = swipeToDismissAnchorsElement;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        inspectorInfo.getProperties().set("state", this.this$0.state);
        inspectorInfo.getProperties().set("enableDismissFromStartToEnd", Boolean.valueOf(this.this$0.enableDismissFromStartToEnd));
        inspectorInfo.getProperties().set("enableDismissFromEndToStart", Boolean.valueOf(this.this$0.enableDismissFromEndToStart));
    }
}
