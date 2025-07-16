package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Group$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ List<PathNode> $clipPathData;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ String $name;
    final /* synthetic */ float $pivotX;
    final /* synthetic */ float $pivotY;
    final /* synthetic */ float $rotation;
    final /* synthetic */ float $scaleX;
    final /* synthetic */ float $scaleY;
    final /* synthetic */ float $translationX;
    final /* synthetic */ float $translationY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorComposeKt$Group$4(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$name = str;
        this.$rotation = f;
        this.$pivotX = f2;
        this.$pivotY = f3;
        this.$scaleX = f4;
        this.$scaleY = f5;
        this.$translationX = f6;
        this.$translationY = f7;
        this.$clipPathData = list;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        VectorComposeKt.Group(this.$name, this.$rotation, this.$pivotX, this.$pivotY, this.$scaleX, this.$scaleY, this.$translationX, this.$translationY, this.$clipPathData, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
