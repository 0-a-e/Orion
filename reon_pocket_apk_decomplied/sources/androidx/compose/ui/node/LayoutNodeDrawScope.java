package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020#H\u0000ø\u0001\u0000¢\u0006\u0004\b$\u0010%Jq\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106Jq\u0010&\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:JY\u0010;\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>JY\u0010;\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\u001eH\u0016J2\u0010B\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\bC\u0010DJO\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010IJm\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020K2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJw\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020K2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u0010R\u001a\u00020SH\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJk\u0010V\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_Jk\u0010V\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJY\u0010b\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010dJY\u0010b\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\be\u0010fJM\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020i2\u0006\u0010'\u001a\u00020(2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\bj\u0010kJM\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020i2\u0006\u00107\u001a\u0002082\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJq\u0010n\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070p2\u0006\u0010q\u001a\u00020r2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010tJq\u0010n\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070p2\u0006\u0010q\u001a\u00020r2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010vJY\u0010w\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010dJY\u0010w\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010fJc\u0010z\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010{\u001a\u00020|2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~Jd\u0010z\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010{\u001a\u00020|2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0001ø\u0001\u0000¢\u0006\u0005\b\u0010\u0001J\u0013\u0010\u0001\u001a\u00020\u001e*\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00030\u0001*\u00020\u000bH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00030\u0001*\u00020\u001bH\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u000b*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u000b*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001J\u001b\u0010\u0001\u001a\u00020\u001b*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00030\u0001*\u00020\u000bH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010 \u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078VX\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001b8VX\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "draw-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawDirect", "drawDirect-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "performDraw", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeDrawScope.kt */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    public static final int $stable = 0;
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    public LayoutNodeDrawScope() {
        this((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    }

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    public void m5516drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4335drawArcillE91I(brush, f, f2, z, j, j2, f3, drawStyle, colorFilter, i);
    }

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    public void m5517drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4336drawArcyD3GUKo(j, f, f2, z, j2, j3, f3, drawStyle, colorFilter, i);
    }

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    public void m5518drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4337drawCircleV9BoPsw(brush, f, j, f2, drawStyle, colorFilter, i);
    }

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    public void m5519drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4338drawCircleVaOC9Bg(j, f, j2, f2, drawStyle, colorFilter, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    public /* synthetic */ void m5521drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4339drawImage9jGpkUE(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    public void m5522drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        this.canvasDrawScope.m4340drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
    }

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    public void m5523drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4341drawImagegbVJVH8(imageBitmap, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    public void m5524drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.canvasDrawScope.m4342drawLine1RTmtNc(brush, j, j2, f, i, pathEffect, f2, colorFilter, i2);
    }

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    public void m5525drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.canvasDrawScope.m4343drawLineNGM6Ib0(j, j2, j3, f, i, pathEffect, f2, colorFilter, i2);
    }

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    public void m5526drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4344drawOvalAsUm42w(brush, j, j2, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    public void m5527drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4345drawOvalnJ9OG0(j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    public void m5528drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4346drawPathGBMwjPU(path, brush, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    public void m5529drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4347drawPathLG529CI(path, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    public void m5530drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        this.canvasDrawScope.m4348drawPointsF8ZwMP8(list, i, j, f, i2, pathEffect, f2, colorFilter, i3);
    }

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    public void m5531drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        this.canvasDrawScope.m4349drawPointsGsft0Ws(list, i, brush, f, i2, pathEffect, f2, colorFilter, i3);
    }

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    public void m5532drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4350drawRectAsUm42w(brush, j, j2, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    public void m5533drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4351drawRectnJ9OG0(j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    public void m5534drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4352drawRoundRectZuiqVtQ(brush, j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    public void m5535drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4353drawRoundRectuAw5IA(j, j2, j3, j4, drawStyle, f, colorFilter, i);
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public long m5536getCenterF1C5BW0() {
        return this.canvasDrawScope.m4354getCenterF1C5BW0();
    }

    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m5537getSizeNHjbRc() {
        return this.canvasDrawScope.m4355getSizeNHjbRc();
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m5538roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.m4356roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m5539roundToPx0680j_4(float f) {
        return this.canvasDrawScope.m4357roundToPx0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m5540toDpGaN1DYA(long j) {
        return this.canvasDrawScope.m4358toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m5541toDpu2uoSUM(float f) {
        return this.canvasDrawScope.m4359toDpu2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m5542toDpu2uoSUM(int i) {
        return this.canvasDrawScope.m4360toDpu2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m5543toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.m4361toDpSizekrfVVM(j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m5544toPxR2X_6o(long j) {
        return this.canvasDrawScope.m4362toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m5545toPx0680j_4(float f) {
        return this.canvasDrawScope.m4363toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        return this.canvasDrawScope.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m5546toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.m4364toSizeXkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m5547toSp0xMU5do(float f) {
        return this.canvasDrawScope.m4365toSp0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m5548toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.m4366toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m5549toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.m4367toSpkPz2Gy4(i);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2) {
        this.canvasDrawScope = canvasDrawScope2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope2);
    }

    public void drawContent() {
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        DelegatableNode delegatableNode = drawModifierNode;
        Modifier.Node access$nextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(delegatableNode);
        if (access$nextDrawNode != null) {
            int r1 = NodeKind.m5647constructorimpl(4);
            MutableVector mutableVector = null;
            while (access$nextDrawNode != null) {
                if (access$nextDrawNode instanceof DrawModifierNode) {
                    performDraw((DrawModifierNode) access$nextDrawNode, canvas);
                } else if ((access$nextDrawNode.getKindSet$ui_release() & r1) != 0 && (access$nextDrawNode instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) access$nextDrawNode).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                            i++;
                            if (i == 1) {
                                access$nextDrawNode = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (access$nextDrawNode != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(access$nextDrawNode);
                                    }
                                    access$nextDrawNode = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                access$nextDrawNode = DelegatableNodeKt.pop(mutableVector);
            }
            return;
        }
        NodeCoordinator r2 = DelegatableNodeKt.m5468requireCoordinator64DMado(delegatableNode, NodeKind.m5647constructorimpl(4));
        if (r2.getTail() == drawModifierNode.getNode()) {
            r2 = r2.getWrapped$ui_release();
            Intrinsics.checkNotNull(r2);
        }
        r2.performDraw(canvas);
    }

    public final void performDraw(DrawModifierNode drawModifierNode, Canvas canvas) {
        NodeCoordinator r6 = DelegatableNodeKt.m5468requireCoordinator64DMado(drawModifierNode, NodeKind.m5647constructorimpl(4));
        r6.getLayoutNode().getMDrawScope$ui_release().m5520drawDirectx_KDEd0$ui_release(canvas, IntSizeKt.m6800toSizeozmzZPI(r6.m5621getSizeYbymL2g()), r6, drawModifierNode);
    }

    /* renamed from: drawDirect-x_KDEd0$ui_release  reason: not valid java name */
    public final void m5520drawDirectx_KDEd0$ui_release(Canvas canvas, long j, NodeCoordinator nodeCoordinator, DrawModifierNode drawModifierNode) {
        DrawModifierNode drawModifierNode2 = this.drawNode;
        this.drawNode = drawModifierNode;
        CanvasDrawScope canvasDrawScope2 = this.canvasDrawScope;
        LayoutDirection layoutDirection = nodeCoordinator.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r7 = drawParams.m4369component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(nodeCoordinator);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m4372setSizeuvyYCjk(j);
        canvas.save();
        DrawScope drawScope = canvasDrawScope2;
        drawModifierNode.draw(this);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m4372setSizeuvyYCjk(r7);
        this.drawNode = drawModifierNode2;
    }

    /* renamed from: draw-x_KDEd0$ui_release  reason: not valid java name */
    public final void m5515drawx_KDEd0$ui_release(Canvas canvas, long j, NodeCoordinator nodeCoordinator, Modifier.Node node) {
        int r0 = NodeKind.m5647constructorimpl(4);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof DrawModifierNode) {
                m5520drawDirectx_KDEd0$ui_release(canvas, j, nodeCoordinator, (DrawModifierNode) node);
            } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                int i = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                    if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                        i++;
                        if (i == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
    }
}
