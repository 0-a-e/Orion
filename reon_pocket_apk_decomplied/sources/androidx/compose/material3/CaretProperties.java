package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0007J\u0016\u0010\f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/CaretProperties;", "", "caretHeight", "Landroidx/compose/ui/unit/Dp;", "caretWidth", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCaretHeight-D9Ej5fM", "()F", "F", "getCaretWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-YgX7TsA", "(FF)Landroidx/compose/material3/CaretProperties;", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
public final class CaretProperties {
    public static final int $stable = 0;
    private final float caretHeight;
    private final float caretWidth;

    public /* synthetic */ CaretProperties(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    /* renamed from: copy-YgX7TsA$default  reason: not valid java name */
    public static /* synthetic */ CaretProperties m1580copyYgX7TsA$default(CaretProperties caretProperties, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = caretProperties.caretHeight;
        }
        if ((i & 2) != 0) {
            f2 = caretProperties.caretWidth;
        }
        return caretProperties.m1583copyYgX7TsA(f, f2);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m1581component1D9Ej5fM() {
        return this.caretHeight;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m1582component2D9Ej5fM() {
        return this.caretWidth;
    }

    /* renamed from: copy-YgX7TsA  reason: not valid java name */
    public final CaretProperties m1583copyYgX7TsA(float f, float f2) {
        return new CaretProperties(f, f2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CaretProperties)) {
            return false;
        }
        CaretProperties caretProperties = (CaretProperties) obj;
        return Dp.m6619equalsimpl0(this.caretHeight, caretProperties.caretHeight) && Dp.m6619equalsimpl0(this.caretWidth, caretProperties.caretWidth);
    }

    public int hashCode() {
        return (Dp.m6620hashCodeimpl(this.caretHeight) * 31) + Dp.m6620hashCodeimpl(this.caretWidth);
    }

    public String toString() {
        return "CaretProperties(caretHeight=" + Dp.m6625toStringimpl(this.caretHeight) + ", caretWidth=" + Dp.m6625toStringimpl(this.caretWidth) + ')';
    }

    private CaretProperties(float f, float f2) {
        this.caretHeight = f;
        this.caretWidth = f2;
    }

    /* renamed from: getCaretHeight-D9Ej5fM  reason: not valid java name */
    public final float m1584getCaretHeightD9Ej5fM() {
        return this.caretHeight;
    }

    /* renamed from: getCaretWidth-D9Ej5fM  reason: not valid java name */
    public final float m1585getCaretWidthD9Ej5fM() {
        return this.caretWidth;
    }
}
