package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BN\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0002H\u0016J\f\u0010)\u001a\u00020\r*\u00020\fH\u0016R\"\u0010\u0007\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\"\u0010\u0005\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingNode;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "setBottom-0680j_4", "(F)V", "F", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getStart-D9Ej5fM", "setStart-0680j_4", "getTop-D9Ej5fM", "setTop-0680j_4", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingElement extends ModifierNodeElement<PaddingNode> {
    private float bottom;
    private float end;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingElement(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m657getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: setStart-0680j_4  reason: not valid java name */
    public final void m661setStart0680j_4(float f) {
        this.start = f;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m658getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: setTop-0680j_4  reason: not valid java name */
    public final void m662setTop0680j_4(float f) {
        this.top = f;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m656getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: setEnd-0680j_4  reason: not valid java name */
    public final void m660setEnd0680j_4(float f) {
        this.end = f;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m655getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: setBottom-0680j_4  reason: not valid java name */
    public final void m659setBottom0680j_4(float f) {
        this.bottom = f;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public final void setRtlAware(boolean z) {
        this.rtlAware = z;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    private PaddingElement(float f, float f2, float f3, float f4, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        this.rtlAware = z;
        this.inspectorInfo = function1;
        if (f >= 0.0f || Dp.m6619equalsimpl0(f, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
            float f5 = this.top;
            if (f5 >= 0.0f || Dp.m6619equalsimpl0(f5, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                float f6 = this.end;
                if (f6 >= 0.0f || Dp.m6619equalsimpl0(f6, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                    float f7 = this.bottom;
                    if (f7 >= 0.0f || Dp.m6619equalsimpl0(f7, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Padding must be non-negative".toString());
    }

    public PaddingNode create() {
        return new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware, (DefaultConstructorMarker) null);
    }

    public void update(PaddingNode paddingNode) {
        paddingNode.m682setStart0680j_4(this.start);
        paddingNode.m683setTop0680j_4(this.top);
        paddingNode.m681setEnd0680j_4(this.end);
        paddingNode.m680setBottom0680j_4(this.bottom);
        paddingNode.setRtlAware(this.rtlAware);
    }

    public int hashCode() {
        return (((((((Dp.m6620hashCodeimpl(this.start) * 31) + Dp.m6620hashCodeimpl(this.top)) * 31) + Dp.m6620hashCodeimpl(this.end)) * 31) + Dp.m6620hashCodeimpl(this.bottom)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.rtlAware);
    }

    public boolean equals(Object obj) {
        PaddingElement paddingElement = obj instanceof PaddingElement ? (PaddingElement) obj : null;
        if (paddingElement != null && Dp.m6619equalsimpl0(this.start, paddingElement.start) && Dp.m6619equalsimpl0(this.top, paddingElement.top) && Dp.m6619equalsimpl0(this.end, paddingElement.end) && Dp.m6619equalsimpl0(this.bottom, paddingElement.bottom) && this.rtlAware == paddingElement.rtlAware) {
            return true;
        }
        return false;
    }

    public void inspectableProperties(InspectorInfo inspectorInfo2) {
        this.inspectorInfo.invoke(inspectorInfo2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaddingElement(float r11, float r12, float r13, float r14, boolean r15, kotlin.jvm.functions.Function1 r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r10 = this;
            r0 = r17 & 1
            r1 = 0
            if (r0 == 0) goto L_0x000c
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r0)
            r3 = r0
            goto L_0x000d
        L_0x000c:
            r3 = r11
        L_0x000d:
            r0 = r17 & 2
            if (r0 == 0) goto L_0x0018
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r0)
            r4 = r0
            goto L_0x0019
        L_0x0018:
            r4 = r12
        L_0x0019:
            r0 = r17 & 4
            if (r0 == 0) goto L_0x0024
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r0)
            r5 = r0
            goto L_0x0025
        L_0x0024:
            r5 = r13
        L_0x0025:
            r0 = r17 & 8
            if (r0 == 0) goto L_0x0030
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r0)
            r6 = r0
            goto L_0x0031
        L_0x0030:
            r6 = r14
        L_0x0031:
            r9 = 0
            r2 = r10
            r7 = r15
            r8 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingElement.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
