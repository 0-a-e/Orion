package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001aX\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u001a\u001a\u0010\u001a\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u001a\r\u0010\u001e\u001a\u00020\t*\u00020\tH\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "arcToBezier", "", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "toPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "target", "toRadians", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathParser.kt */
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    private static final double toRadians(double d) {
        return (d / ((double) 180)) * 3.141592653589793d;
    }

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    public static final Path toPath(List<? extends PathNode> list, Path path) {
        float f;
        int i;
        PathNode pathNode;
        int i2;
        PathNode pathNode2;
        float f2;
        float f3;
        float f4;
        float f5;
        float dy;
        float x1;
        float y1;
        float x2;
        float y2;
        float f6;
        float f7;
        float f8;
        float f9;
        PathNode pathNode3;
        float dy2;
        List<? extends PathNode> list2 = list;
        Path path2 = path;
        int r1 = path.m4109getFillTypeRgk1Os();
        path.rewind();
        path2.m4111setFillTypeoQ8Xj4U(r1);
        PathNode pathNode4 = (PathNode) (list.isEmpty() ? PathNode.Close.INSTANCE : list2.get(0));
        int size = list.size();
        float f10 = 0.0f;
        int i3 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        while (i3 < size) {
            PathNode pathNode5 = (PathNode) list2.get(i3);
            if (pathNode5 instanceof PathNode.Close) {
                path.close();
                path2.moveTo(f15, f16);
                pathNode = pathNode5;
                f11 = f15;
                f13 = f11;
                f12 = f16;
                f14 = f12;
            } else if (pathNode5 instanceof PathNode.RelativeMoveTo) {
                PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode5;
                f13 += relativeMoveTo.getDx();
                f14 += relativeMoveTo.getDy();
                path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                pathNode = pathNode5;
                f15 = f13;
                f16 = f14;
            } else {
                if (pathNode5 instanceof PathNode.MoveTo) {
                    PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode5;
                    float x = moveTo.getX();
                    float y = moveTo.getY();
                    path2.moveTo(moveTo.getX(), moveTo.getY());
                    f13 = x;
                    f15 = f13;
                    f14 = y;
                    f16 = f14;
                } else {
                    if (pathNode5 instanceof PathNode.RelativeLineTo) {
                        PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode5;
                        path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                        f13 += relativeLineTo.getDx();
                        dy2 = relativeLineTo.getDy();
                    } else if (pathNode5 instanceof PathNode.LineTo) {
                        PathNode.LineTo lineTo = (PathNode.LineTo) pathNode5;
                        path2.lineTo(lineTo.getX(), lineTo.getY());
                        float x3 = lineTo.getX();
                        f14 = lineTo.getY();
                        f13 = x3;
                    } else if (pathNode5 instanceof PathNode.RelativeHorizontalTo) {
                        PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode5;
                        path2.relativeLineTo(relativeHorizontalTo.getDx(), f10);
                        f13 += relativeHorizontalTo.getDx();
                    } else if (pathNode5 instanceof PathNode.HorizontalTo) {
                        PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode5;
                        path2.lineTo(horizontalTo.getX(), f14);
                        f13 = horizontalTo.getX();
                    } else if (pathNode5 instanceof PathNode.RelativeVerticalTo) {
                        PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode5;
                        path2.relativeLineTo(f10, relativeVerticalTo.getDy());
                        dy2 = relativeVerticalTo.getDy();
                    } else if (pathNode5 instanceof PathNode.VerticalTo) {
                        PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode5;
                        path2.lineTo(f13, verticalTo.getY());
                        f14 = verticalTo.getY();
                    } else {
                        if (pathNode5 instanceof PathNode.RelativeCurveTo) {
                            PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode5;
                            pathNode2 = pathNode5;
                            path.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                            f4 = relativeCurveTo.getDx2() + f13;
                            f5 = relativeCurveTo.getDy2() + f14;
                            f13 += relativeCurveTo.getDx3();
                            dy = relativeCurveTo.getDy3();
                        } else {
                            pathNode2 = pathNode5;
                            if (pathNode2 instanceof PathNode.CurveTo) {
                                PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode2;
                                path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                x1 = curveTo.getX2();
                                y1 = curveTo.getY2();
                                x2 = curveTo.getX3();
                                y2 = curveTo.getY3();
                            } else if (pathNode2 instanceof PathNode.RelativeReflectiveCurveTo) {
                                if (pathNode4.isCurve()) {
                                    f8 = f14 - f12;
                                    f9 = f13 - f11;
                                } else {
                                    f9 = f10;
                                    f8 = f9;
                                }
                                PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode2;
                                path.relativeCubicTo(f9, f8, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                f4 = relativeReflectiveCurveTo.getDx1() + f13;
                                f5 = relativeReflectiveCurveTo.getDy1() + f14;
                                f13 += relativeReflectiveCurveTo.getDx2();
                                dy = relativeReflectiveCurveTo.getDy2();
                            } else if (pathNode2 instanceof PathNode.ReflectiveCurveTo) {
                                if (pathNode4.isCurve()) {
                                    float f17 = (float) 2;
                                    f6 = (f17 * f14) - f12;
                                    f7 = (f13 * f17) - f11;
                                } else {
                                    f7 = f13;
                                    f6 = f14;
                                }
                                PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode2;
                                path.cubicTo(f7, f6, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                x1 = reflectiveCurveTo.getX1();
                                y1 = reflectiveCurveTo.getY1();
                                x2 = reflectiveCurveTo.getX2();
                                y2 = reflectiveCurveTo.getY2();
                            } else if (pathNode2 instanceof PathNode.RelativeQuadTo) {
                                PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode2;
                                path2.relativeQuadraticBezierTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                f4 = relativeQuadTo.getDx1() + f13;
                                f5 = relativeQuadTo.getDy1() + f14;
                                f13 += relativeQuadTo.getDx2();
                                dy = relativeQuadTo.getDy2();
                            } else if (pathNode2 instanceof PathNode.QuadTo) {
                                PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode2;
                                path2.quadraticBezierTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                x1 = quadTo.getX1();
                                y1 = quadTo.getY1();
                                x2 = quadTo.getX2();
                                y2 = quadTo.getY2();
                            } else if (pathNode2 instanceof PathNode.RelativeReflectiveQuadTo) {
                                if (pathNode4.isQuad()) {
                                    f3 = f13 - f11;
                                    f2 = f14 - f12;
                                } else {
                                    f3 = f10;
                                    f2 = f3;
                                }
                                PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode2;
                                path2.relativeQuadraticBezierTo(f3, f2, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                f4 = f3 + f13;
                                f5 = f2 + f14;
                                f13 += relativeReflectiveQuadTo.getDx();
                                dy = relativeReflectiveQuadTo.getDy();
                            } else {
                                if (pathNode2 instanceof PathNode.ReflectiveQuadTo) {
                                    if (pathNode4.isQuad()) {
                                        float f18 = (float) 2;
                                        f13 = (f13 * f18) - f11;
                                        f14 = (f18 * f14) - f12;
                                    }
                                    PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode2;
                                    path2.quadraticBezierTo(f13, f14, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                    float x4 = reflectiveQuadTo.getX();
                                    pathNode = pathNode2;
                                    f12 = f14;
                                    f = f10;
                                    i = i3;
                                    i2 = size;
                                    f14 = reflectiveQuadTo.getY();
                                    f11 = f13;
                                    f13 = x4;
                                } else if (pathNode2 instanceof PathNode.RelativeArcTo) {
                                    PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode2;
                                    float arcStartDx = relativeArcTo.getArcStartDx() + f13;
                                    pathNode = pathNode2;
                                    float arcStartDy = relativeArcTo.getArcStartDy() + f14;
                                    i = i3;
                                    f = 0;
                                    float f19 = arcStartDy;
                                    i2 = size;
                                    drawArc(path, (double) f13, (double) f14, (double) arcStartDx, (double) arcStartDy, (double) relativeArcTo.getHorizontalEllipseRadius(), (double) relativeArcTo.getVerticalEllipseRadius(), (double) relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
                                    f11 = arcStartDx;
                                    f13 = f11;
                                    f15 = f15;
                                    f16 = f16;
                                    f12 = f19;
                                    f14 = f12;
                                } else {
                                    PathNode pathNode6 = pathNode2;
                                    float f20 = f15;
                                    float f21 = f16;
                                    f = f10;
                                    i = i3;
                                    i2 = size;
                                    if (pathNode6 instanceof PathNode.ArcTo) {
                                        PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode6;
                                        pathNode = pathNode6;
                                        drawArc(path, (double) f13, (double) f14, (double) arcTo.getArcStartX(), (double) arcTo.getArcStartY(), (double) arcTo.getHorizontalEllipseRadius(), (double) arcTo.getVerticalEllipseRadius(), (double) arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                        f13 = arcTo.getArcStartX();
                                        f12 = arcTo.getArcStartY();
                                        f14 = f12;
                                        f15 = f20;
                                        f16 = f21;
                                        f11 = f13;
                                    } else {
                                        pathNode = pathNode6;
                                        f15 = f20;
                                        f16 = f21;
                                    }
                                }
                                i3 = i + 1;
                                path2 = path;
                                size = i2;
                                pathNode4 = pathNode;
                                f10 = f;
                                list2 = list;
                            }
                            pathNode3 = pathNode2;
                            f13 = x2;
                            f14 = y2;
                            f = f10;
                            i = i3;
                            i2 = size;
                            f12 = y1;
                            f11 = x1;
                            i3 = i + 1;
                            path2 = path;
                            size = i2;
                            pathNode4 = pathNode;
                            f10 = f;
                            list2 = list;
                        }
                        f14 += dy;
                        pathNode3 = pathNode2;
                        f12 = f5;
                        f = f10;
                        i = i3;
                        i2 = size;
                        f11 = x1;
                        i3 = i + 1;
                        path2 = path;
                        size = i2;
                        pathNode4 = pathNode;
                        f10 = f;
                        list2 = list;
                    }
                    f14 += dy2;
                }
                pathNode = pathNode5;
            }
            f = f10;
            i = i3;
            i2 = size;
            i3 = i + 1;
            path2 = path;
            size = i2;
            pathNode4 = pathNode;
            f10 = f;
            list2 = list;
        }
        return path;
    }

    private static final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = d;
        double d11 = d3;
        boolean z3 = z2;
        double d12 = (d7 / ((double) 180)) * 3.141592653589793d;
        double cos = Math.cos(d12);
        double sin = Math.sin(d12);
        double d13 = ((d10 * cos) + (d2 * sin)) / d5;
        double d14 = (((-d10) * sin) + (d2 * cos)) / d6;
        double d15 = ((d11 * cos) + (d4 * sin)) / d5;
        double d16 = (((-d11) * sin) + (d4 * cos)) / d6;
        double d17 = d13 - d15;
        double d18 = d14 - d16;
        double d19 = (double) 2;
        double d20 = (d13 + d15) / d19;
        double d21 = (d14 + d16) / d19;
        double d22 = (d17 * d17) + (d18 * d18);
        if (d22 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double d23 = (1.0d / d22) - 0.25d;
            if (d23 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double sqrt = (double) ((float) (Math.sqrt(d22) / 1.99999d));
                drawArc(path, d, d2, d3, d4, d5 * sqrt, d6 * sqrt, d7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d23);
            double d24 = d17 * sqrt2;
            double d25 = sqrt2 * d18;
            boolean z4 = z2;
            if (z == z4) {
                d9 = d20 - d25;
                d8 = d21 + d24;
            } else {
                d9 = d20 + d25;
                d8 = d21 - d24;
            }
            double atan2 = Math.atan2(d14 - d8, d13 - d9);
            double atan22 = Math.atan2(d16 - d8, d15 - d9) - atan2;
            int i = (atan22 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (atan22 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
            if (z4 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d26 = d9 * d5;
            double d27 = d8 * d6;
            arcToBezier(path, (d26 * cos) - (d27 * sin), (d26 * sin) + (d27 * cos), d5, d6, d, d2, d12, atan2, atan22);
        }
    }

    private static final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        double d11 = (double) 4;
        int ceil = (int) Math.ceil(Math.abs((d9 * d11) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d12 = -d10;
        double d13 = d12 * cos;
        double d14 = d4 * sin;
        double d15 = (d13 * sin2) - (d14 * cos2);
        double d16 = d12 * sin;
        double d17 = d4 * cos;
        double d18 = (sin2 * d16) + (cos2 * d17);
        double d19 = d9 / ((double) ceil);
        double d20 = d5;
        double d21 = d18;
        double d22 = d15;
        int i = 0;
        double d23 = d6;
        double d24 = d8;
        while (i < ceil) {
            double d25 = d24 + d19;
            double sin3 = Math.sin(d25);
            double cos3 = Math.cos(d25);
            int i2 = ceil;
            double d26 = (d + ((d10 * cos) * cos3)) - (d14 * sin3);
            double d27 = d2 + (d10 * sin * cos3) + (d17 * sin3);
            double d28 = (d13 * sin3) - (d14 * cos3);
            double d29 = (sin3 * d16) + (cos3 * d17);
            double d30 = d25 - d24;
            double tan = Math.tan(d30 / ((double) 2));
            double d31 = d11;
            double sin4 = (Math.sin(d30) * (Math.sqrt(d11 + ((3.0d * tan) * tan)) - ((double) 1))) / ((double) 3);
            path.cubicTo((float) (d20 + (d22 * sin4)), (float) (d23 + (d21 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
            i++;
            d19 = d19;
            sin = sin;
            d20 = d26;
            d16 = d16;
            d24 = d25;
            d21 = d29;
            d11 = d31;
            d22 = d28;
            cos = cos;
            ceil = i2;
            d23 = d27;
            d10 = d3;
        }
    }
}
