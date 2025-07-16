package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.PathFillType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/vector/PathComponent;", "it", "Landroidx/compose/ui/graphics/PathFillType;", "invoke-pweu1eQ", "(Landroidx/compose/ui/graphics/vector/PathComponent;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Path$2$3 extends Lambda implements Function2<PathComponent, PathFillType, Unit> {
    public static final VectorComposeKt$Path$2$3 INSTANCE = new VectorComposeKt$Path$2$3();

    VectorComposeKt$Path$2$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m4593invokepweu1eQ((PathComponent) obj, ((PathFillType) obj2).m4127unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-pweu1eQ  reason: not valid java name */
    public final void m4593invokepweu1eQ(PathComponent pathComponent, int i) {
        pathComponent.m4585setPathFillTypeoQ8Xj4U(i);
    }
}
