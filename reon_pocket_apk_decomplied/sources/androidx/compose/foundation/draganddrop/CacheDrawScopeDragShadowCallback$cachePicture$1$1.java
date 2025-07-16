package androidx.compose.foundation.draganddrop;

import android.graphics.Picture;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDragAndDropSource.android.kt */
final class CacheDrawScopeDragShadowCallback$cachePicture$1$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ int $height;
    final /* synthetic */ Picture $picture;
    final /* synthetic */ int $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CacheDrawScopeDragShadowCallback$cachePicture$1$1(Picture picture, int i, int i2) {
        super(1);
        this.$picture = picture;
        this.$width = i;
        this.$height = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        Canvas Canvas = AndroidCanvas_androidKt.Canvas(this.$picture.beginRecording(this.$width, this.$height));
        DrawScope drawScope = contentDrawScope;
        LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
        long r3 = contentDrawScope.m4434getSizeNHjbRc();
        Density density = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        long r8 = drawScope.getDrawContext().m4412getSizeNHjbRc();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(contentDrawScope);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(Canvas);
        drawContext.m4413setSizeuvyYCjk(r3);
        Canvas.save();
        contentDrawScope.drawContent();
        Canvas.restore();
        DrawContext drawContext2 = drawScope.getDrawContext();
        drawContext2.setDensity(density);
        drawContext2.setLayoutDirection(layoutDirection2);
        drawContext2.setCanvas(canvas);
        drawContext2.m4413setSizeuvyYCjk(r8);
        this.$picture.endRecording();
        AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()).drawPicture(this.$picture);
    }
}
