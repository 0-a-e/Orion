package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Brush.kt */
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, j2, (i2 & 16) != 0 ? TileMode.Companion.m4251getClamp3opZhB0() : i, (DefaultConstructorMarker) null);
    }

    private LinearGradient(List<Color> list, List<Float> list2, long j, long j2, int i) {
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
        this.tileMode = i;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m4055getIntrinsicSizeNHjbRc() {
        float f;
        float r0 = Offset.m3562getXimpl(this.start);
        float f2 = Float.NaN;
        if (!Float.isInfinite(r0) && !Float.isNaN(r0)) {
            float r02 = Offset.m3562getXimpl(this.end);
            if (!Float.isInfinite(r02) && !Float.isNaN(r02)) {
                f = Math.abs(Offset.m3562getXimpl(this.start) - Offset.m3562getXimpl(this.end));
                float r1 = Offset.m3563getYimpl(this.start);
                if (!Float.isInfinite(r1) && !Float.isNaN(r1)) {
                    float r12 = Offset.m3563getYimpl(this.end);
                    if (!Float.isInfinite(r12) && !Float.isNaN(r12)) {
                        f2 = Math.abs(Offset.m3563getYimpl(this.start) - Offset.m3563getYimpl(this.end));
                    }
                }
                return SizeKt.Size(f, f2);
            }
        }
        f = Float.NaN;
        float r13 = Offset.m3563getYimpl(this.start);
        float r122 = Offset.m3563getYimpl(this.end);
        f2 = Math.abs(Offset.m3563getYimpl(this.start) - Offset.m3563getYimpl(this.end));
        return SizeKt.Size(f, f2);
    }

    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public Shader m4054createShaderuvyYCjk(long j) {
        return ShaderKt.m4189LinearGradientShaderVjE6UOU(OffsetKt.Offset(Offset.m3562getXimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m3631getWidthimpl(j) : Offset.m3562getXimpl(this.start), Offset.m3563getYimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m3628getHeightimpl(j) : Offset.m3563getYimpl(this.start)), OffsetKt.Offset(Offset.m3562getXimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m3631getWidthimpl(j) : Offset.m3562getXimpl(this.end), Offset.m3563getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m3628getHeightimpl(j) : Offset.m3563getYimpl(this.end)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return Intrinsics.areEqual((Object) this.colors, (Object) linearGradient.colors) && Intrinsics.areEqual((Object) this.stops, (Object) linearGradient.stops) && Offset.m3559equalsimpl0(this.start, linearGradient.start) && Offset.m3559equalsimpl0(this.end, linearGradient.end) && TileMode.m4247equalsimpl0(this.tileMode, linearGradient.tileMode);
    }

    public int hashCode() {
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m3564hashCodeimpl(this.start)) * 31) + Offset.m3564hashCodeimpl(this.end)) * 31) + TileMode.m4248hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m3579isFinitek4lQ0M(this.start)) {
            str = "start=" + Offset.m3570toStringimpl(this.start) + ", ";
        } else {
            str = str2;
        }
        if (OffsetKt.m3579isFinitek4lQ0M(this.end)) {
            str2 = "end=" + Offset.m3570toStringimpl(this.end) + ", ";
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + TileMode.m4249toStringimpl(this.tileMode) + ')';
    }
}
