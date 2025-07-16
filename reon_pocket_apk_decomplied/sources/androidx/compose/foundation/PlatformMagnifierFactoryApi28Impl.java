package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "view", "Landroid/view/View;", "useTextDefault", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "create-nHHXs2Y", "(Landroid/view/View;ZJFFZLandroidx/compose/ui/unit/Density;F)Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "PlatformMagnifierImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformMagnifier.android.kt */
public final class PlatformMagnifierFactoryApi28Impl implements PlatformMagnifierFactory {
    public static final int $stable = 0;
    public static final PlatformMagnifierFactoryApi28Impl INSTANCE = new PlatformMagnifierFactoryApi28Impl();
    private static final boolean canUpdateZoom = false;

    private PlatformMagnifierFactoryApi28Impl() {
    }

    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    /* renamed from: create-nHHXs2Y  reason: not valid java name */
    public PlatformMagnifierImpl m318createnHHXs2Y(View view, boolean z, long j, float f, float f2, boolean z2, Density density, float f3) {
        return new PlatformMagnifierImpl(new Magnifier(view));
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\b8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifier;", "magnifier", "Landroid/widget/Magnifier;", "(Landroid/widget/Magnifier;)V", "getMagnifier", "()Landroid/widget/Magnifier;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "dismiss", "", "update", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "updateContent", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PlatformMagnifier.android.kt */
    public static class PlatformMagnifierImpl implements PlatformMagnifier {
        public static final int $stable = 8;
        private final Magnifier magnifier;

        public PlatformMagnifierImpl(Magnifier magnifier2) {
            this.magnifier = magnifier2;
        }

        public final Magnifier getMagnifier() {
            return this.magnifier;
        }

        /* renamed from: getSize-YbymL2g  reason: not valid java name */
        public long m319getSizeYbymL2g() {
            return IntSizeKt.IntSize(this.magnifier.getWidth(), this.magnifier.getHeight());
        }

        public void updateContent() {
            this.magnifier.update();
        }

        /* renamed from: update-Wko1d7g  reason: not valid java name */
        public void m320updateWko1d7g(long j, long j2, float f) {
            this.magnifier.show(Offset.m3562getXimpl(j), Offset.m3563getYimpl(j));
        }

        public void dismiss() {
            this.magnifier.dismiss();
        }
    }
}
