package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"computeFillHeight", "", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeFillHeight-iLBOSCw", "(JJ)F", "computeFillMaxDimension", "computeFillMaxDimension-iLBOSCw", "computeFillMinDimension", "computeFillMinDimension-iLBOSCw", "computeFillWidth", "computeFillWidth-iLBOSCw", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentScale.kt */
public final class ContentScaleKt {
    /* access modifiers changed from: private */
    /* renamed from: computeFillMaxDimension-iLBOSCw  reason: not valid java name */
    public static final float m5276computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return Math.max(m5278computeFillWidthiLBOSCw(j, j2), m5275computeFillHeightiLBOSCw(j, j2));
    }

    /* access modifiers changed from: private */
    /* renamed from: computeFillMinDimension-iLBOSCw  reason: not valid java name */
    public static final float m5277computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(m5278computeFillWidthiLBOSCw(j, j2), m5275computeFillHeightiLBOSCw(j, j2));
    }

    /* access modifiers changed from: private */
    /* renamed from: computeFillWidth-iLBOSCw  reason: not valid java name */
    public static final float m5278computeFillWidthiLBOSCw(long j, long j2) {
        return Size.m3631getWidthimpl(j2) / Size.m3631getWidthimpl(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: computeFillHeight-iLBOSCw  reason: not valid java name */
    public static final float m5275computeFillHeightiLBOSCw(long j, long j2) {
        return Size.m3628getHeightimpl(j2) / Size.m3628getHeightimpl(j);
    }
}
