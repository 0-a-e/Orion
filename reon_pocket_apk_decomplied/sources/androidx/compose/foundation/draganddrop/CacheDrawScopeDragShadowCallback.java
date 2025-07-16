package androidx.compose.foundation.draganddrop;

import android.graphics.Picture;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "", "()V", "cachedPicture", "Landroid/graphics/Picture;", "cachePicture", "Landroidx/compose/ui/draw/DrawResult;", "scope", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawDragShadow", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDragAndDropSource.android.kt */
final class CacheDrawScopeDragShadowCallback {
    private Picture cachedPicture;

    public final void drawDragShadow(DrawScope drawScope) {
        Picture picture = this.cachedPicture;
        if (picture != null) {
            AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()).drawPicture(picture);
            return;
        }
        throw new IllegalArgumentException("No cached drag shadow. Check if Modifier.cacheDragShadow(painter) was called.");
    }

    public final DrawResult cachePicture(CacheDrawScope cacheDrawScope) {
        Picture picture = new Picture();
        this.cachedPicture = picture;
        return cacheDrawScope.onDrawWithContent(new CacheDrawScopeDragShadowCallback$cachePicture$1$1(picture, (int) Size.m3631getWidthimpl(cacheDrawScope.m3452getSizeNHjbRc()), (int) Size.m3628getHeightimpl(cacheDrawScope.m3452getSizeNHjbRc())));
    }
}
