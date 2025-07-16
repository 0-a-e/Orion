package androidx.compose.foundation.text.selection;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ long $handleColor;
    final /* synthetic */ Function0<Boolean> $iconVisible;
    final /* synthetic */ boolean $isLeft;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1(long j, Function0<Boolean> function0, boolean z) {
        super(1);
        this.$handleColor = j;
        this.$iconVisible = function0;
        this.$isLeft = z;
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, Size.m3631getWidthimpl(cacheDrawScope.m3452getSizeNHjbRc()) / 2.0f);
        final ColorFilter r1 = ColorFilter.Companion.m3857tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, (Object) null);
        final Function0<Boolean> function0 = this.$iconVisible;
        final boolean z = this.$isLeft;
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                if (function0.invoke().booleanValue()) {
                    if (z) {
                        DrawScope drawScope = contentDrawScope;
                        ImageBitmap imageBitmap = createHandleImage;
                        ColorFilter colorFilter = r1;
                        long r3 = drawScope.m4433getCenterF1C5BW0();
                        DrawContext drawContext = drawScope.getDrawContext();
                        long r11 = drawContext.m4412getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        drawContext.getTransform().m4527scale0AR0LA0(-1.0f, 1.0f, r3);
                        DrawScope.CC.m4460drawImagegbVJVH8$default(drawScope, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                        drawContext.getCanvas().restore();
                        drawContext.m4413setSizeuvyYCjk(r11);
                        return;
                    }
                    DrawScope.CC.m4460drawImagegbVJVH8$default(contentDrawScope, createHandleImage, 0, 0.0f, (DrawStyle) null, r1, 0, 46, (Object) null);
                }
            }
        });
    }
}
