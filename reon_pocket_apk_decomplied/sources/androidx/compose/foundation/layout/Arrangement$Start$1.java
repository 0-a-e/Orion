package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J,\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"androidx/compose/foundation/layout/Arrangement$Start$1", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Arrangement.kt */
public final class Arrangement$Start$1 implements Arrangement.Horizontal {
    /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
    public /* synthetic */ float m568getSpacingD9Ej5fM() {
        return Arrangement.Horizontal.CC.m553$default$getSpacingD9Ej5fM(this);
    }

    Arrangement$Start$1() {
    }

    public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
        if (layoutDirection == LayoutDirection.Ltr) {
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
        } else {
            Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, true);
        }
    }

    public String toString() {
        return "Arrangement#Start";
    }
}
