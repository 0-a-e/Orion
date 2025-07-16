package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDragAndDropSource.android.kt */
/* synthetic */ class DragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1 extends FunctionReferenceImpl implements Function1<CacheDrawScope, DrawResult> {
    DragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1(Object obj) {
        super(1, obj, CacheDrawScopeDragShadowCallback.class, "cachePicture", "cachePicture(Landroidx/compose/ui/draw/CacheDrawScope;)Landroidx/compose/ui/draw/DrawResult;", 0);
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        return ((CacheDrawScopeDragShadowCallback) this.receiver).cachePicture(cacheDrawScope);
    }
}
