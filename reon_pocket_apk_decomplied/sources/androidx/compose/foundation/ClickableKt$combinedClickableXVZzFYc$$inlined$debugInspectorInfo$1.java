package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ Indication $indication$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ Function0 $onClick$inlined;
    final /* synthetic */ String $onClickLabel$inlined;
    final /* synthetic */ Function0 $onDoubleClick$inlined;
    final /* synthetic */ Function0 $onLongClick$inlined;
    final /* synthetic */ String $onLongClickLabel$inlined;
    final /* synthetic */ Role $role$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(Indication indication, MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, Function0 function0, Function0 function02, Function0 function03, String str2) {
        super(1);
        this.$indication$inlined = indication;
        this.$interactionSource$inlined = mutableInteractionSource;
        this.$enabled$inlined = z;
        this.$onClickLabel$inlined = str;
        this.$role$inlined = role;
        this.$onClick$inlined = function0;
        this.$onDoubleClick$inlined = function02;
        this.$onLongClick$inlined = function03;
        this.$onLongClickLabel$inlined = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("combinedClickable");
        inspectorInfo.getProperties().set("indication", this.$indication$inlined);
        inspectorInfo.getProperties().set("interactionSource", this.$interactionSource$inlined);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
        inspectorInfo.getProperties().set("onClickLabel", this.$onClickLabel$inlined);
        inspectorInfo.getProperties().set("role", this.$role$inlined);
        inspectorInfo.getProperties().set("onClick", this.$onClick$inlined);
        inspectorInfo.getProperties().set("onDoubleClick", this.$onDoubleClick$inlined);
        inspectorInfo.getProperties().set("onLongClick", this.$onLongClick$inlined);
        inspectorInfo.getProperties().set("onLongClickLabel", this.$onLongClickLabel$inlined);
    }
}
