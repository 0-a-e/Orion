package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a(\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*¢\u0006\u0002\b-H\b\u001a\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020%0$2\b\u0010/\u001a\u0004\u0018\u00010\u0006\u001a\u001e\u00100\u001a\u000201*\u00020\u001a2\u0006\u00102\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a\u000e\u00105\u001a\u000201*\u0004\u0018\u000106H\u0000\"\u0013\u0010\u0000\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0013\u0010\u0011\u001a\u00020\u0012¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u0003\"\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0016\u001a\u00020\u0017¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0018\u0010\u0003\"\u0013\u0010\u0019\u001a\u00020\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c\"\u000e\u0010\u001e\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"DefaultFillType", "Landroidx/compose/ui/graphics/PathFillType;", "getDefaultFillType", "()I", "I", "DefaultGroupName", "", "DefaultPathName", "DefaultPivotX", "", "DefaultPivotY", "DefaultRotation", "DefaultScaleX", "DefaultScaleY", "DefaultStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultStrokeLineCap", "DefaultStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultStrokeLineJoin", "DefaultStrokeLineMiter", "DefaultStrokeLineWidth", "DefaultTintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultTintBlendMode", "DefaultTintColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultTintColor", "()J", "J", "DefaultTranslationX", "DefaultTranslationY", "DefaultTrimPathEnd", "DefaultTrimPathOffset", "DefaultTrimPathStart", "EmptyPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "getEmptyPath", "()Ljava/util/List;", "PathData", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "Lkotlin/ExtensionFunctionType;", "addPathNodes", "pathStr", "rgbEqual", "", "other", "rgbEqual--OWjLjI", "(JJ)Z", "tintableWithAlphaMask", "Landroidx/compose/ui/graphics/ColorFilter;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Vector.kt */
public final class VectorKt {
    private static final int DefaultFillType = PathFillType.Companion.m4129getNonZeroRgk1Os();
    public static final String DefaultGroupName = "";
    public static final String DefaultPathName = "";
    public static final float DefaultPivotX = 0.0f;
    public static final float DefaultPivotY = 0.0f;
    public static final float DefaultRotation = 0.0f;
    public static final float DefaultScaleX = 1.0f;
    public static final float DefaultScaleY = 1.0f;
    private static final int DefaultStrokeLineCap = StrokeCap.Companion.m4230getButtKaPHkGw();
    private static final int DefaultStrokeLineJoin = StrokeJoin.Companion.m4241getMiterLxFBmk8();
    public static final float DefaultStrokeLineMiter = 4.0f;
    public static final float DefaultStrokeLineWidth = 0.0f;
    private static final int DefaultTintBlendMode = BlendMode.Companion.m3744getSrcIn0nO6VwU();
    private static final long DefaultTintColor = Color.Companion.m3851getTransparent0d7_KjU();
    public static final float DefaultTranslationX = 0.0f;
    public static final float DefaultTranslationY = 0.0f;
    public static final float DefaultTrimPathEnd = 1.0f;
    public static final float DefaultTrimPathOffset = 0.0f;
    public static final float DefaultTrimPathStart = 0.0f;
    private static final List<PathNode> EmptyPath = CollectionsKt.emptyList();

    public static final List<PathNode> getEmptyPath() {
        return EmptyPath;
    }

    public static final int getDefaultStrokeLineCap() {
        return DefaultStrokeLineCap;
    }

    public static final int getDefaultStrokeLineJoin() {
        return DefaultStrokeLineJoin;
    }

    public static final int getDefaultTintBlendMode() {
        return DefaultTintBlendMode;
    }

    public static final long getDefaultTintColor() {
        return DefaultTintColor;
    }

    public static final int getDefaultFillType() {
        return DefaultFillType;
    }

    public static final List<PathNode> PathData(Function1<? super PathBuilder, Unit> function1) {
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return pathBuilder.getNodes();
    }

    public static final List<PathNode> addPathNodes(String str) {
        if (str == null) {
            return EmptyPath;
        }
        return new PathParser().parsePathString(str).toNodes();
    }

    /* renamed from: rgbEqual--OWjLjI  reason: not valid java name */
    public static final boolean m4595rgbEqualOWjLjI(long j, long j2) {
        return Color.m3822getRedimpl(j) == Color.m3822getRedimpl(j2) && Color.m3821getGreenimpl(j) == Color.m3821getGreenimpl(j2) && Color.m3819getBlueimpl(j) == Color.m3819getBlueimpl(j2);
    }

    public static final boolean tintableWithAlphaMask(ColorFilter colorFilter) {
        if (colorFilter instanceof BlendModeColorFilter) {
            BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) colorFilter;
            if (BlendMode.m3715equalsimpl0(blendModeColorFilter.m3748getBlendMode0nO6VwU(), BlendMode.Companion.m3744getSrcIn0nO6VwU()) || BlendMode.m3715equalsimpl0(blendModeColorFilter.m3748getBlendMode0nO6VwU(), BlendMode.Companion.m3746getSrcOver0nO6VwU())) {
                return true;
            }
        } else if (colorFilter == null) {
            return true;
        }
        return false;
    }
}
