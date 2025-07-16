package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J$\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016R\u001c\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"androidx/compose/foundation/layout/Arrangement$Center$1", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "F", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Arrangement.kt */
public final class Arrangement$Center$1 implements Arrangement.HorizontalOrVertical {
    private final float spacing = Dp.m6614constructorimpl((float) 0);

    Arrangement$Center$1() {
    }

    /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
    public float m550getSpacingD9Ej5fM() {
        return this.spacing;
    }

    public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
        if (layoutDirection == LayoutDirection.Ltr) {
            Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
        } else {
            Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, true);
        }
    }

    public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
        Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
    }

    public String toString() {
        return "Arrangement#Center";
    }
}
