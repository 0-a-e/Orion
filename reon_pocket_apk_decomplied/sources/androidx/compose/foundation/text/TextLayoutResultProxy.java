package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\"\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010$J\u0016\u0010'\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "decorationBoxCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getDecorationBoxCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setDecorationBoxCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "innerTextFieldCoordinates", "getInnerTextFieldCoordinates", "setInnerTextFieldCoordinates", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getLineEnd", "", "lineIndex", "visibleEnd", "", "getLineForVerticalPosition", "vertical", "", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "translateDecorationToInnerCoordinates", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release", "(J)J", "translateInnerToDecorationCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutResultProxy.kt */
public final class TextLayoutResultProxy {
    public static final int $stable = 8;
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult) {
        this.value = textLayoutResult;
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k$default  reason: not valid java name */
    public static /* synthetic */ int m1152getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutResultProxy.m1153getOffsetForPosition3MmeM6k(j, z);
    }

    /* renamed from: getOffsetForPosition-3MmeM6k  reason: not valid java name */
    public final int m1153getOffsetForPosition3MmeM6k(long j, boolean z) {
        if (z) {
            j = m1151coercedInVisibleBoundsOfInputTextMKHz9U(j);
        }
        return this.value.m6014getOffsetForPositionk4lQ0M(m1155translateDecorationToInnerCoordinatesMKHz9U$foundation_release(j));
    }

    public final int getLineForVerticalPosition(float f) {
        return this.value.getLineForVerticalPosition(Offset.m3563getYimpl(m1155translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m1151coercedInVisibleBoundsOfInputTextMKHz9U(OffsetKt.Offset(0.0f, f)))));
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResultProxy textLayoutResultProxy, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayoutResultProxy.getLineEnd(i, z);
    }

    public final int getLineEnd(int i, boolean z) {
        return this.value.getLineEnd(i, z);
    }

    /* renamed from: isPositionOnText-k-4lQ0M  reason: not valid java name */
    public final boolean m1154isPositionOnTextk4lQ0M(long j) {
        long r4 = m1155translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m1151coercedInVisibleBoundsOfInputTextMKHz9U(j));
        int lineForVerticalPosition = this.value.getLineForVerticalPosition(Offset.m3563getYimpl(r4));
        return Offset.m3562getXimpl(r4) >= this.value.getLineLeft(lineForVerticalPosition) && Offset.m3562getXimpl(r4) <= this.value.getLineRight(lineForVerticalPosition);
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    /* renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release  reason: not valid java name */
    public final long m1155translateDecorationToInnerCoordinatesMKHz9U$foundation_release(long j) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 == null) {
            return j;
        }
        LayoutCoordinates layoutCoordinates3 = null;
        if (!layoutCoordinates2.isAttached()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.decorationBoxCoordinates) == null) {
            return j;
        }
        if (layoutCoordinates.isAttached()) {
            layoutCoordinates3 = layoutCoordinates;
        }
        return layoutCoordinates3 == null ? j : layoutCoordinates2.m5319localPositionOfR5De75A(layoutCoordinates3, j);
    }

    /* renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release  reason: not valid java name */
    public final long m1156translateInnerToDecorationCoordinatesMKHz9U$foundation_release(long j) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 == null) {
            return j;
        }
        LayoutCoordinates layoutCoordinates3 = null;
        if (!layoutCoordinates2.isAttached()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.decorationBoxCoordinates) == null) {
            return j;
        }
        if (layoutCoordinates.isAttached()) {
            layoutCoordinates3 = layoutCoordinates;
        }
        return layoutCoordinates3 == null ? j : layoutCoordinates3.m5319localPositionOfR5De75A(layoutCoordinates2, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r2 == null) goto L_0x001e;
     */
    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m1151coercedInVisibleBoundsOfInputTextMKHz9U(long r6) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.innerTextFieldCoordinates
            if (r0 == 0) goto L_0x001e
            boolean r1 = r0.isAttached()
            if (r1 == 0) goto L_0x0016
            androidx.compose.ui.layout.LayoutCoordinates r1 = r5.decorationBoxCoordinates
            r2 = 0
            if (r1 == 0) goto L_0x001c
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinates.CC.localBoundingBoxOf$default(r1, r0, r3, r4, r2)
            goto L_0x001c
        L_0x0016:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L_0x001c:
            if (r2 != 0) goto L_0x0024
        L_0x001e:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L_0x0024:
            long r6 = androidx.compose.foundation.text.TextLayoutResultProxyKt.m1158coerceIn3MmeM6k(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLayoutResultProxy.m1151coercedInVisibleBoundsOfInputTextMKHz9U(long):long");
    }
}
