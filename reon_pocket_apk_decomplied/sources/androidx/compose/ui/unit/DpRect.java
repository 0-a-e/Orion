package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0018\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0010J\u0016\u0010\u001a\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0010J\u0016\u0010\u001c\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0010J\u0016\u0010\u001e\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0010J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R$\u0010\u000b\u001a\u00020\b8\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0007\u001a\u00020\b8\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R$\u0010\n\u001a\u00020\b8\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R$\u0010\t\u001a\u00020\b8\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/unit/DpRect;", "", "origin", "Landroidx/compose/ui/unit/DpOffset;", "size", "Landroidx/compose/ui/unit/DpSize;", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "getBottom-D9Ej5fM", "()F", "F", "getLeft-D9Ej5fM$annotations", "getLeft-D9Ej5fM", "getRight-D9Ej5fM$annotations", "getRight-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "copy", "copy-a9UjIt4", "(FFFF)Landroidx/compose/ui/unit/DpRect;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dp.kt */
public final class DpRect {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public /* synthetic */ DpRect(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    public /* synthetic */ DpRect(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* renamed from: copy-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ DpRect m6686copya9UjIt4$default(DpRect dpRect, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpRect.left;
        }
        if ((i & 2) != 0) {
            f2 = dpRect.top;
        }
        if ((i & 4) != 0) {
            f3 = dpRect.right;
        }
        if ((i & 8) != 0) {
            f4 = dpRect.bottom;
        }
        return dpRect.m6695copya9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: getBottom-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m6687getBottomD9Ej5fM$annotations() {
    }

    /* renamed from: getLeft-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m6688getLeftD9Ej5fM$annotations() {
    }

    /* renamed from: getRight-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m6689getRightD9Ej5fM$annotations() {
    }

    /* renamed from: getTop-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m6690getTopD9Ej5fM$annotations() {
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m6691component1D9Ej5fM() {
        return this.left;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m6692component2D9Ej5fM() {
        return this.top;
    }

    /* renamed from: component3-D9Ej5fM  reason: not valid java name */
    public final float m6693component3D9Ej5fM() {
        return this.right;
    }

    /* renamed from: component4-D9Ej5fM  reason: not valid java name */
    public final float m6694component4D9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: copy-a9UjIt4  reason: not valid java name */
    public final DpRect m6695copya9UjIt4(float f, float f2, float f3, float f4) {
        return new DpRect(f, f2, f3, f4, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DpRect)) {
            return false;
        }
        DpRect dpRect = (DpRect) obj;
        return Dp.m6619equalsimpl0(this.left, dpRect.left) && Dp.m6619equalsimpl0(this.top, dpRect.top) && Dp.m6619equalsimpl0(this.right, dpRect.right) && Dp.m6619equalsimpl0(this.bottom, dpRect.bottom);
    }

    public int hashCode() {
        return (((((Dp.m6620hashCodeimpl(this.left) * 31) + Dp.m6620hashCodeimpl(this.top)) * 31) + Dp.m6620hashCodeimpl(this.right)) * 31) + Dp.m6620hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "DpRect(left=" + Dp.m6625toStringimpl(this.left) + ", top=" + Dp.m6625toStringimpl(this.top) + ", right=" + Dp.m6625toStringimpl(this.right) + ", bottom=" + Dp.m6625toStringimpl(this.bottom) + ')';
    }

    private DpRect(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    /* renamed from: getLeft-D9Ej5fM  reason: not valid java name */
    public final float m6697getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m6699getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getRight-D9Ej5fM  reason: not valid java name */
    public final float m6698getRightD9Ej5fM() {
        return this.right;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m6696getBottomD9Ej5fM() {
        return this.bottom;
    }

    private DpRect(long j, long j2) {
        this(DpOffset.m6675getXD9Ej5fM(j), DpOffset.m6677getYD9Ej5fM(j), Dp.m6614constructorimpl(DpOffset.m6675getXD9Ej5fM(j) + DpSize.m6712getWidthD9Ej5fM(j2)), Dp.m6614constructorimpl(DpOffset.m6677getYD9Ej5fM(j) + DpSize.m6710getHeightD9Ej5fM(j2)), (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/DpRect$Companion;", "", "()V", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Dp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
