package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u001f\u0010\u0004\u001a\u001b\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0016¨\u0006\n"}, d2 = {"androidx/compose/material3/LabelKt$Label$scope$1$1", "Landroidx/compose/material3/CaretScope;", "drawCaret", "Landroidx/compose/ui/Modifier;", "draw", "Lkotlin/Function2;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Label.kt */
public final class LabelKt$Label$scope$1$1 implements CaretScope {
    final /* synthetic */ MutableState<LayoutCoordinates> $anchorBounds$delegate;

    LabelKt$Label$scope$1$1(MutableState<LayoutCoordinates> mutableState) {
        this.$anchorBounds$delegate = mutableState;
    }

    public Modifier drawCaret(Modifier modifier, Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function2) {
        return DrawModifierKt.drawWithCache(modifier, new LabelKt$Label$scope$1$1$drawCaret$1(function2, this.$anchorBounds$delegate));
    }
}
