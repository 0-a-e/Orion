package jp.co.sony.reonpocket.util;

import android.graphics.PointF;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/util/ChartUtil;", "", "()V", "calcArcEndPointXY", "Landroid/graphics/PointF;", "cirX", "", "cirY", "radius", "cirAngle", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartUtil.kt */
public final class ChartUtil {
    public static final int $stable = 0;
    public static final ChartUtil INSTANCE = new ChartUtil();

    private ChartUtil() {
    }

    public final PointF calcArcEndPointXY(float f, float f2, float f3, float f4) {
        double sin;
        double sin2;
        float f5 = (float) ((((double) f4) * 3.141592653589793d) / 180.0d);
        int i = (f4 > 90.0f ? 1 : (f4 == 90.0f ? 0 : -1));
        if (i < 0) {
            double d = (double) f5;
            f += ((float) Math.cos(d)) * f3;
            sin2 = Math.sin(d);
        } else {
            if (i == 0) {
                f2 += f3;
            } else if (f4 > 90.0f && f4 < 180.0f) {
                double d2 = (double) ((float) ((((double) (((float) 180) - f4)) * 3.141592653589793d) / 180.0d));
                f -= ((float) Math.cos(d2)) * f3;
                sin2 = Math.sin(d2);
            } else if (f4 == 180.0f) {
                f -= f3;
            } else {
                if (f4 > 180.0f && f4 < 270.0f) {
                    double d3 = (double) ((float) ((((double) (f4 - ((float) 180))) * 3.141592653589793d) / 180.0d));
                    r8 = f - (((float) Math.cos(d3)) * f3);
                    sin = Math.sin(d3);
                } else if (f4 == 270.0f) {
                    f2 -= f3;
                } else {
                    double d4 = (double) ((float) ((((double) (((float) 360) - f4)) * 3.141592653589793d) / 180.0d));
                    r8 = f + (((float) Math.cos(d4)) * f3);
                    sin = Math.sin(d4);
                }
                f2 -= ((float) sin) * f3;
            }
            return new PointF(f, f2);
        }
        f2 += ((float) sin2) * f3;
        return new PointF(f, f2);
    }
}
