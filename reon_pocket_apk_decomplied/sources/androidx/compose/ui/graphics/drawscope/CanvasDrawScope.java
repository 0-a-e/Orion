package androidx.compose.ui.graphics.drawscope;

import android.graphics.Shader;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&JH\u0010\u0019\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*Jl\u0010+\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105Jj\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107JL\u00108\u001a\u0002092\u0006\u0010\u0003\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090@¢\u0006\u0002\bAH\bø\u0001\u0000¢\u0006\u0004\bB\u0010CJf\u0010D\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJf\u0010D\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bM\u0010NJN\u0010O\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bR\u0010SJN\u0010O\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJF\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010I\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ^\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0017ø\u0001\u0000¢\u0006\u0004\ba\u0010bJf\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\bc\u0010dJ`\u0010e\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ`\u0010e\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bj\u0010kJN\u0010l\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bm\u0010nJN\u0010l\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bo\u0010pJF\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bt\u0010uJF\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010'\u001a\u00020(2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bv\u0010wJf\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\b}\u0010~Jg\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0010\u0001JP\u0010\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010nJP\u0010\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010pJ[\u0010\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0001\u001a\u00030\u00012\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J[\u0010\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u001dH\u0002J!\u0010\u0001\u001a\u00020(*\u00020(2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "()V", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "strokePaint", "configurePaint", "brush", "Landroidx/compose/ui/graphics/Brush;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "strokeWidth", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "draw", "", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CanvasDrawScope.kt */
public final class CanvasDrawScope implements DrawScope {
    private final DrawContext drawContext = new CanvasDrawScope$drawContext$1(this);
    private final DrawParams drawParams = new DrawParams((Density) null, (LayoutDirection) null, (Canvas) null, 0, 15, (DefaultConstructorMarker) null);
    private Paint fillPaint;
    private Paint strokePaint;

    public static /* synthetic */ void getDrawParams$annotations() {
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public /* synthetic */ long m4354getCenterF1C5BW0() {
        return DrawScope.CC.m4436$default$getCenterF1C5BW0(this);
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public /* synthetic */ long m4355getSizeNHjbRc() {
        return DrawScope.CC.m4437$default$getSizeNHjbRc(this);
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ int m4356roundToPxR2X_6o(long j) {
        return Density.CC.m6554$default$roundToPxR2X_6o(this, j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public /* synthetic */ int m4357roundToPx0680j_4(float f) {
        return Density.CC.m6555$default$roundToPx0680j_4(this, f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public /* synthetic */ float m4358toDpGaN1DYA(long j) {
        return FontScaling.CC.m6725$default$toDpGaN1DYA(this, j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m4359toDpu2uoSUM(float f) {
        return Density.CC.m6556$default$toDpu2uoSUM((Density) this, f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m4360toDpu2uoSUM(int i) {
        return Density.CC.m6557$default$toDpu2uoSUM((Density) this, i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public /* synthetic */ long m4361toDpSizekrfVVM(long j) {
        return Density.CC.m6558$default$toDpSizekrfVVM(this, j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ float m4362toPxR2X_6o(long j) {
        return Density.CC.m6559$default$toPxR2X_6o(this, j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public /* synthetic */ float m4363toPx0680j_4(float f) {
        return Density.CC.m6560$default$toPx0680j_4(this, f);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return Density.CC.$default$toRect(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public /* synthetic */ long m4364toSizeXkaWNTQ(long j) {
        return Density.CC.m6561$default$toSizeXkaWNTQ(this, j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public /* synthetic */ long m4365toSp0xMU5do(float f) {
        return FontScaling.CC.m6726$default$toSp0xMU5do(this, f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m4366toSpkPz2Gy4(float f) {
        return Density.CC.m6562$default$toSpkPz2Gy4((Density) this, f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m4367toSpkPz2Gy4(int i) {
        return Density.CC.m6563$default$toSpkPz2Gy4((Density) this, i);
    }

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    public void m4342drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.drawParams.getCanvas().m3782drawLineWko1d7g(j, j2, m4332configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i, StrokeJoin.Companion.m4241getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, 512, (Object) null));
    }

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    public void m4343drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.drawParams.getCanvas().m3782drawLineWko1d7g(j2, j3, m4330configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i, StrokeJoin.Companion.m4241getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, 512, (Object) null));
    }

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    public void m4350drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawRect(Offset.m3562getXimpl(j), Offset.m3563getYimpl(j), Offset.m3562getXimpl(j) + Size.m3631getWidthimpl(j2), Offset.m3563getYimpl(j) + Size.m3628getHeightimpl(j2), m4328configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    public void m4351drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawRect(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2), Offset.m3562getXimpl(j2) + Size.m3631getWidthimpl(j3), Offset.m3563getYimpl(j2) + Size.m3628getHeightimpl(j3), m4326configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    public void m4341drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        ImageBitmap imageBitmap2 = imageBitmap;
        long j2 = j;
        this.drawParams.getCanvas().m3780drawImaged4ec7I(imageBitmap, j, m4328configurePaintswdJneE$default(this, (Brush) null, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    public /* synthetic */ void m4339drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().m3781drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m4328configurePaintswdJneE$default(this, (Brush) null, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    public void m4340drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        this.drawParams.getCanvas().m3781drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m4327configurePaintswdJneE((Brush) null, drawStyle, f, colorFilter, i, i2));
    }

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    public void m4352drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m3562getXimpl(j), Offset.m3563getYimpl(j), Offset.m3562getXimpl(j) + Size.m3631getWidthimpl(j2), Offset.m3563getYimpl(j) + Size.m3628getHeightimpl(j2), CornerRadius.m3537getXimpl(j3), CornerRadius.m3538getYimpl(j3), m4328configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    public void m4353drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2), Offset.m3562getXimpl(j2) + Size.m3631getWidthimpl(j3), Offset.m3563getYimpl(j2) + Size.m3628getHeightimpl(j3), CornerRadius.m3537getXimpl(j4), CornerRadius.m3538getYimpl(j4), m4326configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    public void m4337drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        float f3 = f;
        long j2 = j;
        this.drawParams.getCanvas().m3779drawCircle9KIMszo(j, f, m4328configurePaintswdJneE$default(this, brush, drawStyle, f2, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    public void m4338drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        float f3 = f;
        this.drawParams.getCanvas().m3779drawCircle9KIMszo(j2, f, m4326configurePaint2qPWKa0$default(this, j, drawStyle, f2, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    public void m4344drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawOval(Offset.m3562getXimpl(j), Offset.m3563getYimpl(j), Offset.m3562getXimpl(j) + Size.m3631getWidthimpl(j2), Offset.m3563getYimpl(j) + Size.m3628getHeightimpl(j2), m4328configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    public void m4345drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawOval(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2), Offset.m3562getXimpl(j2) + Size.m3631getWidthimpl(j3), Offset.m3563getYimpl(j2) + Size.m3628getHeightimpl(j3), m4326configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    public void m4335drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawArc(Offset.m3562getXimpl(j), Offset.m3563getYimpl(j), Offset.m3562getXimpl(j) + Size.m3631getWidthimpl(j2), Offset.m3563getYimpl(j) + Size.m3628getHeightimpl(j2), f, f2, z, m4328configurePaintswdJneE$default(this, brush, drawStyle, f3, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    public void m4336drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawArc(Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2), Offset.m3562getXimpl(j2) + Size.m3631getWidthimpl(j3), Offset.m3563getYimpl(j2) + Size.m3628getHeightimpl(j3), f, f2, z, m4326configurePaint2qPWKa0$default(this, j, drawStyle, f3, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    public void m4347drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Path path2 = path;
        this.drawParams.getCanvas().drawPath(path, m4326configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    public void m4346drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Path path2 = path;
        this.drawParams.getCanvas().drawPath(path, m4328configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, (Object) null));
    }

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    public void m4348drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        int i4 = i;
        this.drawParams.getCanvas().m3783drawPointsO7TthRY(i4, list, m4330configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i2, StrokeJoin.Companion.m4241getMiterLxFBmk8(), pathEffect, f2, colorFilter, i3, 0, 512, (Object) null));
    }

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    public void m4349drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        int i4 = i;
        this.drawParams.getCanvas().m3783drawPointsO7TthRY(i4, list, m4332configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i2, StrokeJoin.Companion.m4241getMiterLxFBmk8(), pathEffect, f2, colorFilter, i3, 0, 512, (Object) null));
    }

    /* renamed from: draw-yzxVdVo  reason: not valid java name */
    public final void m4334drawyzxVdVo(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, Function1<? super DrawScope, Unit> function1) {
        DrawParams drawParams2 = getDrawParams();
        Density component1 = drawParams2.component1();
        LayoutDirection component2 = drawParams2.component2();
        Canvas component3 = drawParams2.component3();
        long r4 = drawParams2.m4369component4NHjbRc();
        DrawParams drawParams3 = getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection);
        drawParams3.setCanvas(canvas);
        drawParams3.m4372setSizeuvyYCjk(j);
        canvas.save();
        function1.invoke(this);
        canvas.restore();
        DrawParams drawParams4 = getDrawParams();
        drawParams4.setDensity(component1);
        drawParams4.setLayoutDirection(component2);
        drawParams4.setCanvas(component3);
        drawParams4.m4372setSizeuvyYCjk(r4);
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m4098setStylek9PVt8s(PaintingStyle.Companion.m4106getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m4098setStylek9PVt8s(PaintingStyle.Companion.m4107getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual((Object) drawStyle, (Object) Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (drawStyle instanceof Stroke) {
            Paint obtainStrokePaint = obtainStrokePaint();
            Stroke stroke = (Stroke) drawStyle;
            if (obtainStrokePaint.getStrokeWidth() != stroke.getWidth()) {
                obtainStrokePaint.setStrokeWidth(stroke.getWidth());
            }
            if (!StrokeCap.m4226equalsimpl0(obtainStrokePaint.m4090getStrokeCapKaPHkGw(), stroke.m4555getCapKaPHkGw())) {
                obtainStrokePaint.m4096setStrokeCapBeK7IIE(stroke.m4555getCapKaPHkGw());
            }
            if (obtainStrokePaint.getStrokeMiterLimit() != stroke.getMiter()) {
                obtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
            }
            if (!StrokeJoin.m4236equalsimpl0(obtainStrokePaint.m4091getStrokeJoinLxFBmk8(), stroke.m4556getJoinLxFBmk8())) {
                obtainStrokePaint.m4097setStrokeJoinWw9F2mQ(stroke.m4556getJoinLxFBmk8());
            }
            if (!Intrinsics.areEqual((Object) obtainStrokePaint.getPathEffect(), (Object) stroke.getPathEffect())) {
                obtainStrokePaint.setPathEffect(stroke.getPathEffect());
            }
            return obtainStrokePaint;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: configurePaint-swdJneE$default  reason: not valid java name */
    static /* synthetic */ Paint m4328configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            i2 = DrawScope.Companion.m4474getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m4327configurePaintswdJneE(brush, drawStyle, f, colorFilter, i, i2);
    }

    /* renamed from: configurePaint-swdJneE  reason: not valid java name */
    private final Paint m4327configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2) {
        Paint selectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.m3752applyToPq9zytI(m4355getSizeNHjbRc(), selectPaint, f);
        } else {
            if (selectPaint.getShader() != null) {
                selectPaint.setShader((Shader) null);
            }
            if (!Color.m3817equalsimpl0(selectPaint.m4088getColor0d7_KjU(), Color.Companion.m3842getBlack0d7_KjU())) {
                selectPaint.m4094setColor8_81llA(Color.Companion.m3842getBlack0d7_KjU());
            }
            if (selectPaint.getAlpha() != f) {
                selectPaint.setAlpha(f);
            }
        }
        if (!Intrinsics.areEqual((Object) selectPaint.getColorFilter(), (Object) colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m3715equalsimpl0(selectPaint.m4087getBlendMode0nO6VwU(), i)) {
            selectPaint.m4093setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m3912equalsimpl0(selectPaint.m4089getFilterQualityfv9h1I(), i2)) {
            selectPaint.m4095setFilterQualityvDHp3xo(i2);
        }
        return selectPaint;
    }

    /* renamed from: configurePaint-2qPWKa0$default  reason: not valid java name */
    static /* synthetic */ Paint m4326configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        return canvasDrawScope.m4325configurePaint2qPWKa0(j, drawStyle, f, colorFilter, i, (i3 & 32) != 0 ? DrawScope.Companion.m4474getDefaultFilterQualityfv9h1I() : i2);
    }

    /* renamed from: configurePaint-2qPWKa0  reason: not valid java name */
    private final Paint m4325configurePaint2qPWKa0(long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2) {
        Paint selectPaint = selectPaint(drawStyle);
        long r3 = m4333modulate5vOe2sY(j, f);
        if (!Color.m3817equalsimpl0(selectPaint.m4088getColor0d7_KjU(), r3)) {
            selectPaint.m4094setColor8_81llA(r3);
        }
        if (selectPaint.getShader() != null) {
            selectPaint.setShader((Shader) null);
        }
        if (!Intrinsics.areEqual((Object) selectPaint.getColorFilter(), (Object) colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m3715equalsimpl0(selectPaint.m4087getBlendMode0nO6VwU(), i)) {
            selectPaint.m4093setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m3912equalsimpl0(selectPaint.m4089getFilterQualityfv9h1I(), i2)) {
            selectPaint.m4095setFilterQualityvDHp3xo(i2);
        }
        return selectPaint;
    }

    /* renamed from: configureStrokePaint-Q_0CZUI$default  reason: not valid java name */
    static /* synthetic */ Paint m4330configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m4329configureStrokePaintQ_0CZUI(j, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m4474getDefaultFilterQualityfv9h1I() : i4);
    }

    /* renamed from: configureStrokePaint-Q_0CZUI  reason: not valid java name */
    private final Paint m4329configureStrokePaintQ_0CZUI(long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint obtainStrokePaint = obtainStrokePaint();
        long r4 = m4333modulate5vOe2sY(j, f3);
        if (!Color.m3817equalsimpl0(obtainStrokePaint.m4088getColor0d7_KjU(), r4)) {
            obtainStrokePaint.m4094setColor8_81llA(r4);
        }
        if (obtainStrokePaint.getShader() != null) {
            obtainStrokePaint.setShader((Shader) null);
        }
        if (!Intrinsics.areEqual((Object) obtainStrokePaint.getColorFilter(), (Object) colorFilter)) {
            obtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m3715equalsimpl0(obtainStrokePaint.m4087getBlendMode0nO6VwU(), i3)) {
            obtainStrokePaint.m4093setBlendModes9anfk8(i3);
        }
        if (obtainStrokePaint.getStrokeWidth() != f) {
            obtainStrokePaint.setStrokeWidth(f);
        }
        if (obtainStrokePaint.getStrokeMiterLimit() != f2) {
            obtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m4226equalsimpl0(obtainStrokePaint.m4090getStrokeCapKaPHkGw(), i)) {
            obtainStrokePaint.m4096setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m4236equalsimpl0(obtainStrokePaint.m4091getStrokeJoinLxFBmk8(), i2)) {
            obtainStrokePaint.m4097setStrokeJoinWw9F2mQ(i2);
        }
        if (!Intrinsics.areEqual((Object) obtainStrokePaint.getPathEffect(), (Object) pathEffect)) {
            obtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m3912equalsimpl0(obtainStrokePaint.m4089getFilterQualityfv9h1I(), i4)) {
            obtainStrokePaint.m4095setFilterQualityvDHp3xo(i4);
        }
        return obtainStrokePaint;
    }

    /* renamed from: configureStrokePaint-ho4zsrM$default  reason: not valid java name */
    static /* synthetic */ Paint m4332configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m4331configureStrokePaintho4zsrM(brush, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m4474getDefaultFilterQualityfv9h1I() : i4);
    }

    /* renamed from: configureStrokePaint-ho4zsrM  reason: not valid java name */
    private final Paint m4331configureStrokePaintho4zsrM(Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint obtainStrokePaint = obtainStrokePaint();
        if (brush != null) {
            brush.m3752applyToPq9zytI(m4355getSizeNHjbRc(), obtainStrokePaint, f3);
        } else if (obtainStrokePaint.getAlpha() != f3) {
            obtainStrokePaint.setAlpha(f3);
        }
        if (!Intrinsics.areEqual((Object) obtainStrokePaint.getColorFilter(), (Object) colorFilter)) {
            obtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m3715equalsimpl0(obtainStrokePaint.m4087getBlendMode0nO6VwU(), i3)) {
            obtainStrokePaint.m4093setBlendModes9anfk8(i3);
        }
        if (obtainStrokePaint.getStrokeWidth() != f) {
            obtainStrokePaint.setStrokeWidth(f);
        }
        if (obtainStrokePaint.getStrokeMiterLimit() != f2) {
            obtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m4226equalsimpl0(obtainStrokePaint.m4090getStrokeCapKaPHkGw(), i)) {
            obtainStrokePaint.m4096setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m4236equalsimpl0(obtainStrokePaint.m4091getStrokeJoinLxFBmk8(), i2)) {
            obtainStrokePaint.m4097setStrokeJoinWw9F2mQ(i2);
        }
        if (!Intrinsics.areEqual((Object) obtainStrokePaint.getPathEffect(), (Object) pathEffect)) {
            obtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m3912equalsimpl0(obtainStrokePaint.m4089getFilterQualityfv9h1I(), i4)) {
            obtainStrokePaint.m4095setFilterQualityvDHp3xo(i4);
        }
        return obtainStrokePaint;
    }

    /* renamed from: modulate-5vOe2sY  reason: not valid java name */
    private final long m4333modulate5vOe2sY(long j, float f) {
        if (f == 1.0f) {
            return j;
        }
        return Color.m3815copywmQWz5c$default(j, Color.m3818getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0016\u0010\u001f\u001a\u00020\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CanvasDrawScope.kt */
    public static final class DrawParams {
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(density2, layoutDirection2, canvas2, j);
        }

        /* renamed from: copy-Ug5Nnss$default  reason: not valid java name */
        public static /* synthetic */ DrawParams m4368copyUg5Nnss$default(DrawParams drawParams, Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                density2 = drawParams.density;
            }
            if ((i & 2) != 0) {
                layoutDirection2 = drawParams.layoutDirection;
            }
            LayoutDirection layoutDirection3 = layoutDirection2;
            if ((i & 4) != 0) {
                canvas2 = drawParams.canvas;
            }
            Canvas canvas3 = canvas2;
            if ((i & 8) != 0) {
                j = drawParams.size;
            }
            return drawParams.m4370copyUg5Nnss(density2, layoutDirection3, canvas3, j);
        }

        public final Density component1() {
            return this.density;
        }

        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        public final Canvas component3() {
            return this.canvas;
        }

        /* renamed from: component4-NH-jbRc  reason: not valid java name */
        public final long m4369component4NHjbRc() {
            return this.size;
        }

        /* renamed from: copy-Ug5Nnss  reason: not valid java name */
        public final DrawParams m4370copyUg5Nnss(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j) {
            return new DrawParams(density2, layoutDirection2, canvas2, j, (DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual((Object) this.density, (Object) drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual((Object) this.canvas, (Object) drawParams.canvas) && Size.m3627equalsimpl0(this.size, drawParams.size);
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m3632hashCodeimpl(this.size);
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + Size.m3635toStringimpl(this.size) + ')';
        }

        private DrawParams(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j) {
            this.density = density2;
            this.layoutDirection = layoutDirection2;
            this.canvas = canvas2;
            this.size = j;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DrawParams(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? DrawContextKt.getDefaultDensity() : density2, (i & 2) != 0 ? LayoutDirection.Ltr : layoutDirection2, (i & 4) != 0 ? new EmptyCanvas() : canvas2, (i & 8) != 0 ? Size.Companion.m3640getZeroNHjbRc() : j, (DefaultConstructorMarker) null);
        }

        public final Density getDensity() {
            return this.density;
        }

        public final void setDensity(Density density2) {
            this.density = density2;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final void setLayoutDirection(LayoutDirection layoutDirection2) {
            this.layoutDirection = layoutDirection2;
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas2) {
            this.canvas = canvas2;
        }

        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public final long m4371getSizeNHjbRc() {
            return this.size;
        }

        /* renamed from: setSize-uvyYCjk  reason: not valid java name */
        public final void m4372setSizeuvyYCjk(long j) {
            this.size = j;
        }
    }
}
