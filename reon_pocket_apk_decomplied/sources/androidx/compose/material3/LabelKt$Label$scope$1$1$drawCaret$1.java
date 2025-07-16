package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Label.kt */
final class LabelKt$Label$scope$1$1$drawCaret$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ MutableState<LayoutCoordinates> $anchorBounds$delegate;
    final /* synthetic */ Function2<CacheDrawScope, LayoutCoordinates, DrawResult> $draw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LabelKt$Label$scope$1$1$drawCaret$1(Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function2, MutableState<LayoutCoordinates> mutableState) {
        super(1);
        this.$draw = function2;
        this.$anchorBounds$delegate = mutableState;
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        return this.$draw.invoke(cacheDrawScope, LabelKt.Label$lambda$3(this.$anchorBounds$delegate));
    }
}
