package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0002\u0010\u0015J\u0016\u0010(\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001bJ\u0016\u0010*\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001bJ\u0016\u0010,\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010\u001bJ\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u0016\u0010/\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\u001bJ\u0016\u00101\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u001bJ\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\u0016\u00105\u001a\u00020\u000eHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010%J\t\u00107\u001a\u00020\nHÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u0013\u0010<\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0019\u0010\u0014\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0019\u0010\b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\u0013\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0019\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventData;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "position", "down", "", "pressure", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "issuesEnterExit", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "originalEventPosition", "(JJJJZFIZLjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDown", "()Z", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "getIssuesEnterExit", "getOriginalEventPosition-F1C5BW0", "getPosition-F1C5BW0", "getPositionOnScreen-F1C5BW0", "getPressure", "()F", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptime", "component1", "component1-J3iCeTQ", "component10", "component10-F1C5BW0", "component11", "component11-F1C5BW0", "component2", "component3", "component3-F1C5BW0", "component4", "component4-F1C5BW0", "component5", "component6", "component7", "component7-T8wyACA", "component8", "component9", "copy", "copy-rc8HELY", "(JJJJZFIZLjava/util/List;JJ)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "equals", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InternalPointerInput.kt */
public final class PointerInputEventData {
    public static final int $stable = 8;
    private final boolean down;
    private final List<HistoricalChange> historical;
    private final long id;
    private final boolean issuesEnterExit;
    private final long originalEventPosition;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    public /* synthetic */ PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, f, i, z2, list, j5, j6);
    }

    /* renamed from: copy-rc8HELY$default  reason: not valid java name */
    public static /* synthetic */ PointerInputEventData m5120copyrc8HELY$default(PointerInputEventData pointerInputEventData, long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, long j6, int i2, Object obj) {
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        int i3 = i2;
        return pointerInputEventData.m5127copyrc8HELY((i3 & 1) != 0 ? pointerInputEventData2.id : j, (i3 & 2) != 0 ? pointerInputEventData2.uptime : j2, (i3 & 4) != 0 ? pointerInputEventData2.positionOnScreen : j3, (i3 & 8) != 0 ? pointerInputEventData2.position : j4, (i3 & 16) != 0 ? pointerInputEventData2.down : z, (i3 & 32) != 0 ? pointerInputEventData2.pressure : f, (i3 & 64) != 0 ? pointerInputEventData2.type : i, (i3 & 128) != 0 ? pointerInputEventData2.issuesEnterExit : z2, (i3 & 256) != 0 ? pointerInputEventData2.historical : list, (i3 & 512) != 0 ? pointerInputEventData2.scrollDelta : j5, (i3 & 1024) != 0 ? pointerInputEventData2.originalEventPosition : j6);
    }

    /* renamed from: component1-J3iCeTQ  reason: not valid java name */
    public final long m5121component1J3iCeTQ() {
        return this.id;
    }

    /* renamed from: component10-F1C5BW0  reason: not valid java name */
    public final long m5122component10F1C5BW0() {
        return this.scrollDelta;
    }

    /* renamed from: component11-F1C5BW0  reason: not valid java name */
    public final long m5123component11F1C5BW0() {
        return this.originalEventPosition;
    }

    public final long component2() {
        return this.uptime;
    }

    /* renamed from: component3-F1C5BW0  reason: not valid java name */
    public final long m5124component3F1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: component4-F1C5BW0  reason: not valid java name */
    public final long m5125component4F1C5BW0() {
        return this.position;
    }

    public final boolean component5() {
        return this.down;
    }

    public final float component6() {
        return this.pressure;
    }

    /* renamed from: component7-T8wyACA  reason: not valid java name */
    public final int m5126component7T8wyACA() {
        return this.type;
    }

    public final boolean component8() {
        return this.issuesEnterExit;
    }

    public final List<HistoricalChange> component9() {
        return this.historical;
    }

    /* renamed from: copy-rc8HELY  reason: not valid java name */
    public final PointerInputEventData m5127copyrc8HELY(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List<HistoricalChange> list, long j5, long j6) {
        return new PointerInputEventData(j, j2, j3, j4, z, f, i, z2, list, j5, j6, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        return PointerId.m5095equalsimpl0(this.id, pointerInputEventData.id) && this.uptime == pointerInputEventData.uptime && Offset.m3559equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m3559equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && Float.compare(this.pressure, pointerInputEventData.pressure) == 0 && PointerType.m5189equalsimpl0(this.type, pointerInputEventData.type) && this.issuesEnterExit == pointerInputEventData.issuesEnterExit && Intrinsics.areEqual((Object) this.historical, (Object) pointerInputEventData.historical) && Offset.m3559equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta) && Offset.m3559equalsimpl0(this.originalEventPosition, pointerInputEventData.originalEventPosition);
    }

    public int hashCode() {
        return (((((((((((((((((((PointerId.m5096hashCodeimpl(this.id) * 31) + UByte$$ExternalSyntheticBackport0.m(this.uptime)) * 31) + Offset.m3564hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m3564hashCodeimpl(this.position)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.down)) * 31) + Float.floatToIntBits(this.pressure)) * 31) + PointerType.m5190hashCodeimpl(this.type)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.issuesEnterExit)) * 31) + this.historical.hashCode()) * 31) + Offset.m3564hashCodeimpl(this.scrollDelta)) * 31) + Offset.m3564hashCodeimpl(this.originalEventPosition);
    }

    public String toString() {
        return "PointerInputEventData(id=" + PointerId.m5097toStringimpl(this.id) + ", uptime=" + this.uptime + ", positionOnScreen=" + Offset.m3570toStringimpl(this.positionOnScreen) + ", position=" + Offset.m3570toStringimpl(this.position) + ", down=" + this.down + ", pressure=" + this.pressure + ", type=" + PointerType.m5191toStringimpl(this.type) + ", issuesEnterExit=" + this.issuesEnterExit + ", historical=" + this.historical + ", scrollDelta=" + Offset.m3570toStringimpl(this.scrollDelta) + ", originalEventPosition=" + Offset.m3570toStringimpl(this.originalEventPosition) + ')';
    }

    private PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List<HistoricalChange> list, long j5, long j6) {
        this.id = j;
        this.uptime = j2;
        this.positionOnScreen = j3;
        this.position = j4;
        this.down = z;
        this.pressure = f;
        this.type = i;
        this.issuesEnterExit = z2;
        this.historical = list;
        this.scrollDelta = j5;
        this.originalEventPosition = j6;
    }

    /* renamed from: getId-J3iCeTQ  reason: not valid java name */
    public final long m5128getIdJ3iCeTQ() {
        return this.id;
    }

    public final long getUptime() {
        return this.uptime;
    }

    /* renamed from: getPositionOnScreen-F1C5BW0  reason: not valid java name */
    public final long m5131getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m5130getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getDown() {
        return this.down;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: getType-T8wyACA  reason: not valid java name */
    public final int m5133getTypeT8wyACA() {
        return this.type;
    }

    public final boolean getIssuesEnterExit() {
        return this.issuesEnterExit;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputEventData(long r22, long r24, long r26, long r28, boolean r30, float r31, int r32, boolean r33, java.util.List r34, long r35, long r37, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r14 = r1
            goto L_0x000b
        L_0x0009:
            r14 = r33
        L_0x000b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0018
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            r15 = r1
            goto L_0x001a
        L_0x0018:
            r15 = r34
        L_0x001a:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0027
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r1 = r1.m3578getZeroF1C5BW0()
            r16 = r1
            goto L_0x0029
        L_0x0027:
            r16 = r35
        L_0x0029:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0036
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r18 = r0
            goto L_0x0038
        L_0x0036:
            r18 = r37
        L_0x0038:
            r20 = 0
            r2 = r21
            r3 = r22
            r5 = r24
            r7 = r26
            r9 = r28
            r11 = r30
            r12 = r31
            r13 = r32
            r2.<init>(r3, r5, r7, r9, r11, r12, r13, r14, r15, r16, r18, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputEventData.<init>(long, long, long, long, boolean, float, int, boolean, java.util.List, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<HistoricalChange> getHistorical() {
        return this.historical;
    }

    /* renamed from: getScrollDelta-F1C5BW0  reason: not valid java name */
    public final long m5132getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* renamed from: getOriginalEventPosition-F1C5BW0  reason: not valid java name */
    public final long m5129getOriginalEventPositionF1C5BW0() {
        return this.originalEventPosition;
    }
}
