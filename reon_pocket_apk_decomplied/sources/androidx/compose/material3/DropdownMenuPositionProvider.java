package androidx.compose.material3;

import androidx.compose.material3.MenuPosition;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00128\b\u0002\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\u0010\u0010J2\u0010%\u001a\u00020&2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0016J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J9\u00102\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0003Jk\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u000728\b\u0002\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0007HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000RA\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/compose/material3/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "verticalMargin", "", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "bottomToAnchorTop", "Landroidx/compose/material3/MenuPosition$Vertical;", "bottomToWindowBottom", "centerToAnchorTop", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "endToAnchorEnd", "Landroidx/compose/material3/MenuPosition$Horizontal;", "leftToWindowLeft", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "rightToWindowRight", "startToAnchorStart", "topToAnchorBottom", "topToWindowTop", "getVerticalMargin", "()I", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "component4", "copy", "copy-uVxBXkw", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;)Landroidx/compose/material3/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MenuPosition.kt */
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final MenuPosition.Vertical centerToAnchorTop;
    private final long contentOffset;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int verticalMargin;

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density2, int i, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density2, i, function2);
    }

    /* renamed from: copy-uVxBXkw$default  reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m1827copyuVxBXkw$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density2, int i, Function2<IntRect, IntRect, Unit> function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            density2 = dropdownMenuPositionProvider.density;
        }
        Density density3 = density2;
        if ((i2 & 4) != 0) {
            i = dropdownMenuPositionProvider.verticalMargin;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m1830copyuVxBXkw(j2, density3, i3, function2);
    }

    /* renamed from: component1-RKDOV3M  reason: not valid java name */
    public final long m1829component1RKDOV3M() {
        return this.contentOffset;
    }

    public final Density component2() {
        return this.density;
    }

    public final int component3() {
        return this.verticalMargin;
    }

    public final Function2<IntRect, IntRect, Unit> component4() {
        return this.onPositionCalculated;
    }

    /* renamed from: copy-uVxBXkw  reason: not valid java name */
    public final DropdownMenuPositionProvider m1830copyuVxBXkw(long j, Density density2, int i, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        return new DropdownMenuPositionProvider(j, density2, i, function2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        return DpOffset.m6674equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual((Object) this.density, (Object) dropdownMenuPositionProvider.density) && this.verticalMargin == dropdownMenuPositionProvider.verticalMargin && Intrinsics.areEqual((Object) this.onPositionCalculated, (Object) dropdownMenuPositionProvider.onPositionCalculated);
    }

    public int hashCode() {
        return (((((DpOffset.m6679hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.verticalMargin) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + DpOffset.m6682toStringimpl(this.contentOffset) + ", density=" + this.density + ", verticalMargin=" + this.verticalMargin + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    private DropdownMenuPositionProvider(long j, Density density2, int i, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = j;
        this.density = density2;
        this.verticalMargin = i;
        this.onPositionCalculated = function2;
        int r6 = density2.m6545roundToPx0680j_4(DpOffset.m6675getXD9Ej5fM(j));
        this.startToAnchorStart = MenuPosition.INSTANCE.startToAnchorStart(r6);
        this.endToAnchorEnd = MenuPosition.INSTANCE.endToAnchorEnd(r6);
        this.leftToWindowLeft = MenuPosition.INSTANCE.leftToWindowLeft(0);
        this.rightToWindowRight = MenuPosition.INSTANCE.rightToWindowRight(0);
        int r2 = density2.m6545roundToPx0680j_4(DpOffset.m6677getYD9Ej5fM(j));
        this.topToAnchorBottom = MenuPosition.INSTANCE.topToAnchorBottom(r2);
        this.bottomToAnchorTop = MenuPosition.INSTANCE.bottomToAnchorTop(r2);
        this.centerToAnchorTop = MenuPosition.INSTANCE.centerToAnchorTop(r2);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(i);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(i);
    }

    /* renamed from: getContentOffset-RKDOV3M  reason: not valid java name */
    public final long m1831getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density2, int i, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density2, (i2 & 4) != 0 ? density2.m6545roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i, (i2 & 8) != 0 ? AnonymousClass2.INSTANCE : function2, (DefaultConstructorMarker) null);
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m1828calculatePositionllwVHH4(androidx.compose.ui.unit.IntRect r17, long r18, androidx.compose.ui.unit.LayoutDirection r20, long r21) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            r8 = 3
            androidx.compose.material3.MenuPosition$Horizontal[] r1 = new androidx.compose.material3.MenuPosition.Horizontal[r8]
            androidx.compose.material3.MenuPosition$Horizontal r2 = r0.startToAnchorStart
            r9 = 0
            r1[r9] = r2
            androidx.compose.material3.MenuPosition$Horizontal r2 = r0.endToAnchorEnd
            r10 = 1
            r1[r10] = r2
            long r2 = r17.m6771getCenternOccac()
            int r2 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r2)
            int r3 = androidx.compose.ui.unit.IntSize.m6790getWidthimpl(r18)
            r11 = 2
            int r3 = r3 / r11
            if (r2 >= r3) goto L_0x0024
            androidx.compose.material3.MenuPosition$Horizontal r2 = r0.leftToWindowLeft
            goto L_0x0026
        L_0x0024:
            androidx.compose.material3.MenuPosition$Horizontal r2 = r0.rightToWindowRight
        L_0x0026:
            r1[r11] = r2
            java.util.List r12 = kotlin.collections.CollectionsKt.listOf(r1)
            java.util.ArrayList r13 = new java.util.ArrayList
            int r1 = r12.size()
            r13.<init>(r1)
            int r14 = r12.size()
            r15 = r9
        L_0x003a:
            if (r15 >= r14) goto L_0x005f
            java.lang.Object r1 = r12.get(r15)
            r6 = r13
            java.util.Collection r6 = (java.util.Collection) r6
            androidx.compose.material3.MenuPosition$Horizontal r1 = (androidx.compose.material3.MenuPosition.Horizontal) r1
            int r5 = androidx.compose.ui.unit.IntSize.m6790getWidthimpl(r21)
            r2 = r17
            r3 = r18
            r8 = r6
            r6 = r20
            int r1 = r1.m1977position95KtPRI(r2, r3, r5, r6)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8.add(r1)
            int r15 = r15 + 1
            r8 = 3
            goto L_0x003a
        L_0x005f:
            java.util.List r13 = (java.util.List) r13
            int r1 = r13.size()
            r2 = r9
        L_0x0066:
            r3 = 0
            if (r2 >= r1) goto L_0x0085
            java.lang.Object r4 = r13.get(r2)
            r5 = r4
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 < 0) goto L_0x0082
            int r6 = androidx.compose.ui.unit.IntSize.m6790getWidthimpl(r21)
            int r5 = r5 + r6
            int r6 = androidx.compose.ui.unit.IntSize.m6790getWidthimpl(r18)
            if (r5 > r6) goto L_0x0082
            goto L_0x0086
        L_0x0082:
            int r2 = r2 + 1
            goto L_0x0066
        L_0x0085:
            r4 = r3
        L_0x0086:
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L_0x008f
            int r1 = r4.intValue()
            goto L_0x0099
        L_0x008f:
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r13)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
        L_0x0099:
            r2 = 4
            androidx.compose.material3.MenuPosition$Vertical[] r2 = new androidx.compose.material3.MenuPosition.Vertical[r2]
            androidx.compose.material3.MenuPosition$Vertical r4 = r0.topToAnchorBottom
            r2[r9] = r4
            androidx.compose.material3.MenuPosition$Vertical r4 = r0.bottomToAnchorTop
            r2[r10] = r4
            androidx.compose.material3.MenuPosition$Vertical r4 = r0.centerToAnchorTop
            r2[r11] = r4
            long r4 = r17.m6771getCenternOccac()
            int r4 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r4)
            int r5 = androidx.compose.ui.unit.IntSize.m6789getHeightimpl(r18)
            int r5 = r5 / r11
            if (r4 >= r5) goto L_0x00ba
            androidx.compose.material3.MenuPosition$Vertical r4 = r0.topToWindowTop
            goto L_0x00bc
        L_0x00ba:
            androidx.compose.material3.MenuPosition$Vertical r4 = r0.bottomToWindowBottom
        L_0x00bc:
            r5 = 3
            r2[r5] = r4
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r2.size()
            r4.<init>(r5)
            int r5 = r2.size()
            r6 = r9
        L_0x00d1:
            if (r6 >= r5) goto L_0x00f0
            java.lang.Object r8 = r2.get(r6)
            r10 = r4
            java.util.Collection r10 = (java.util.Collection) r10
            androidx.compose.material3.MenuPosition$Vertical r8 = (androidx.compose.material3.MenuPosition.Vertical) r8
            int r11 = androidx.compose.ui.unit.IntSize.m6789getHeightimpl(r21)
            r12 = r18
            int r8 = r8.m1978positionJVtK1S4(r7, r12, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10.add(r8)
            int r6 = r6 + 1
            goto L_0x00d1
        L_0x00f0:
            r12 = r18
            java.util.List r4 = (java.util.List) r4
            int r2 = r4.size()
        L_0x00f8:
            if (r9 >= r2) goto L_0x011c
            java.lang.Object r5 = r4.get(r9)
            r6 = r5
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            int r8 = r0.verticalMargin
            if (r6 < r8) goto L_0x0119
            int r8 = androidx.compose.ui.unit.IntSize.m6789getHeightimpl(r21)
            int r6 = r6 + r8
            int r8 = androidx.compose.ui.unit.IntSize.m6789getHeightimpl(r18)
            int r10 = r0.verticalMargin
            int r8 = r8 - r10
            if (r6 > r8) goto L_0x0119
            r3 = r5
            goto L_0x011c
        L_0x0119:
            int r9 = r9 + 1
            goto L_0x00f8
        L_0x011c:
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x0125
            int r2 = r3.intValue()
            goto L_0x012f
        L_0x0125:
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r4)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
        L_0x012f:
            long r1 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r1, r2)
            kotlin.jvm.functions.Function2<androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect, kotlin.Unit> r3 = r0.onPositionCalculated
            r4 = r21
            androidx.compose.ui.unit.IntRect r4 = androidx.compose.ui.unit.IntRectKt.m6780IntRectVbeCjmY(r1, r4)
            r3.invoke(r7, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DropdownMenuPositionProvider.m1828calculatePositionllwVHH4(androidx.compose.ui.unit.IntRect, long, androidx.compose.ui.unit.LayoutDirection, long):long");
    }
}
