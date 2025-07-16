package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/ViewLayer$Companion$OutlineProvider$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewLayer.android.kt */
public final class ViewLayer$Companion$OutlineProvider$1 extends ViewOutlineProvider {
    ViewLayer$Companion$OutlineProvider$1() {
    }

    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
        Outline outline2 = ((ViewLayer) view).outlineResolver.getOutline();
        Intrinsics.checkNotNull(outline2);
        outline.set(outline2);
    }
}
