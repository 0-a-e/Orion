package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0001\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u001b\b\u0002\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0013\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0002H\u0016J\f\u0010\"\u001a\u00020\u000b*\u00020#H\u0016R\u000e\u0010\u0014\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u0012X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0013\u001a\u00020\u0012X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R!\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u00020\nX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/MagnifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MagnifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "J", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.android.kt */
public final class MagnifierElement extends ModifierNodeElement<MagnifierNode> {
    public static final int $stable = 0;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final Function1<Density, Offset> magnifierCenter;
    private final Function1<DpSize, Unit> onSizeChanged;
    private final PlatformMagnifierFactory platformMagnifierFactory;
    private final long size;
    private final Function1<Density, Offset> sourceCenter;
    private final boolean useTextDefault;
    private final float zoom;

    public /* synthetic */ MagnifierElement(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f, z, j, f2, f3, z2, platformMagnifierFactory2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MagnifierElement(kotlin.jvm.functions.Function1 r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function1 r19, float r20, boolean r21, long r22, float r24, float r25, boolean r26, androidx.compose.foundation.PlatformMagnifierFactory r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r16 = this;
            r0 = r28
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r18
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r19
        L_0x0013:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001b
            r1 = 2143289344(0x7fc00000, float:NaN)
            r7 = r1
            goto L_0x001d
        L_0x001b:
            r7 = r20
        L_0x001d:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0024
            r1 = 0
            r8 = r1
            goto L_0x0026
        L_0x0024:
            r8 = r21
        L_0x0026:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0032
            androidx.compose.ui.unit.DpSize$Companion r1 = androidx.compose.ui.unit.DpSize.Companion
            long r1 = r1.m6721getUnspecifiedMYxV2XQ()
            r9 = r1
            goto L_0x0034
        L_0x0032:
            r9 = r22
        L_0x0034:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0040
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            float r1 = r1.m6634getUnspecifiedD9Ej5fM()
            r11 = r1
            goto L_0x0042
        L_0x0040:
            r11 = r24
        L_0x0042:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            float r1 = r1.m6634getUnspecifiedD9Ej5fM()
            r12 = r1
            goto L_0x0050
        L_0x004e:
            r12 = r25
        L_0x0050:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0057
            r0 = 1
            r13 = r0
            goto L_0x0059
        L_0x0057:
            r13 = r26
        L_0x0059:
            r15 = 0
            r3 = r16
            r4 = r17
            r14 = r27
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierElement.<init>(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, boolean, long, float, float, boolean, androidx.compose.foundation.PlatformMagnifierFactory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private MagnifierElement(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory2) {
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.onSizeChanged = function13;
        this.zoom = f;
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f2;
        this.elevation = f3;
        this.clippingEnabled = z2;
        this.platformMagnifierFactory = platformMagnifierFactory2;
    }

    public MagnifierNode create() {
        return new MagnifierNode(this.sourceCenter, this.magnifierCenter, this.onSizeChanged, this.zoom, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, this.platformMagnifierFactory, (DefaultConstructorMarker) null);
    }

    public void update(MagnifierNode magnifierNode) {
        magnifierNode.m284update5F03MCQ(this.sourceCenter, this.magnifierCenter, this.zoom, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, this.onSizeChanged, this.platformMagnifierFactory);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MagnifierElement)) {
            return false;
        }
        MagnifierElement magnifierElement = (MagnifierElement) obj;
        return Intrinsics.areEqual((Object) this.sourceCenter, (Object) magnifierElement.sourceCenter) && Intrinsics.areEqual((Object) this.magnifierCenter, (Object) magnifierElement.magnifierCenter) && this.zoom == magnifierElement.zoom && this.useTextDefault == magnifierElement.useTextDefault && DpSize.m6709equalsimpl0(this.size, magnifierElement.size) && Dp.m6619equalsimpl0(this.cornerRadius, magnifierElement.cornerRadius) && Dp.m6619equalsimpl0(this.elevation, magnifierElement.elevation) && this.clippingEnabled == magnifierElement.clippingEnabled && Intrinsics.areEqual((Object) this.onSizeChanged, (Object) magnifierElement.onSizeChanged) && Intrinsics.areEqual((Object) this.platformMagnifierFactory, (Object) magnifierElement.platformMagnifierFactory);
    }

    public int hashCode() {
        int hashCode = this.sourceCenter.hashCode() * 31;
        Function1<Density, Offset> function1 = this.magnifierCenter;
        int i = 0;
        int hashCode2 = (((((((((((((hashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + Float.floatToIntBits(this.zoom)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.useTextDefault)) * 31) + DpSize.m6714hashCodeimpl(this.size)) * 31) + Dp.m6620hashCodeimpl(this.cornerRadius)) * 31) + Dp.m6620hashCodeimpl(this.elevation)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.clippingEnabled)) * 31;
        Function1<DpSize, Unit> function12 = this.onSizeChanged;
        if (function12 != null) {
            i = function12.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.platformMagnifierFactory.hashCode();
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("magnifier");
        inspectorInfo.getProperties().set("sourceCenter", this.sourceCenter);
        inspectorInfo.getProperties().set("magnifierCenter", this.magnifierCenter);
        inspectorInfo.getProperties().set("zoom", Float.valueOf(this.zoom));
        inspectorInfo.getProperties().set("size", DpSize.m6700boximpl(this.size));
        inspectorInfo.getProperties().set("cornerRadius", Dp.m6612boximpl(this.cornerRadius));
        inspectorInfo.getProperties().set("elevation", Dp.m6612boximpl(this.elevation));
        inspectorInfo.getProperties().set("clippingEnabled", Boolean.valueOf(this.clippingEnabled));
    }
}
