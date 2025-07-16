package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Group$2$8 extends Lambda implements Function2<GroupComponent, Float, Unit> {
    public static final VectorComposeKt$Group$2$8 INSTANCE = new VectorComposeKt$Group$2$8();

    VectorComposeKt$Group$2$8() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GroupComponent) obj, ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(GroupComponent groupComponent, float f) {
        groupComponent.setTranslationY(f);
    }
}
