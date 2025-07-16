package androidx.compose.foundation;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.Magnifier_androidKt$magnifier-jPUL71Q$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class Magnifier_androidKt$magnifierjPUL71Q$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ boolean $clippingEnabled$inlined;
    final /* synthetic */ float $cornerRadius$inlined;
    final /* synthetic */ float $elevation$inlined;
    final /* synthetic */ Function1 $magnifierCenter$inlined;
    final /* synthetic */ long $size$inlined;
    final /* synthetic */ Function1 $sourceCenter$inlined;
    final /* synthetic */ float $zoom$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Magnifier_androidKt$magnifierjPUL71Q$$inlined$debugInspectorInfo$1(Function1 function1, Function1 function12, float f, long j, float f2, float f3, boolean z) {
        super(1);
        this.$sourceCenter$inlined = function1;
        this.$magnifierCenter$inlined = function12;
        this.$zoom$inlined = f;
        this.$size$inlined = j;
        this.$cornerRadius$inlined = f2;
        this.$elevation$inlined = f3;
        this.$clippingEnabled$inlined = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("magnifier (not supported)");
        inspectorInfo.getProperties().set("sourceCenter", this.$sourceCenter$inlined);
        inspectorInfo.getProperties().set("magnifierCenter", this.$magnifierCenter$inlined);
        inspectorInfo.getProperties().set("zoom", Float.valueOf(this.$zoom$inlined));
        inspectorInfo.getProperties().set("size", DpSize.m6700boximpl(this.$size$inlined));
        inspectorInfo.getProperties().set("cornerRadius", Dp.m6612boximpl(this.$cornerRadius$inlined));
        inspectorInfo.getProperties().set("elevation", Dp.m6612boximpl(this.$elevation$inlined));
        inspectorInfo.getProperties().set("clippingEnabled", Boolean.valueOf(this.$clippingEnabled$inlined));
    }
}
