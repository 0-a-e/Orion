package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/input/pointer/PositionCalculator;", "", "localToScreen", "Landroidx/compose/ui/geometry/Offset;", "localPosition", "localToScreen-MK-Hz9U", "(J)J", "", "localTransform", "Landroidx/compose/ui/graphics/Matrix;", "localToScreen-58bKbWc", "([F)V", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInputEventProcessor.kt */
public interface PositionCalculator {
    /* renamed from: localToScreen-58bKbWc  reason: not valid java name */
    void m5198localToScreen58bKbWc(float[] fArr);

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    long m5199localToScreenMKHz9U(long j);

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    long m5200screenToLocalMKHz9U(long j);
}
