package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0011\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a*\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0000\u001a\f\u0010\"\u001a\u00020#*\u00020$H\u0000\u001a2\u0010%\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a<\u0010(\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0001H\u0000\u001a2\u0010*\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a2\u0010+\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a\f\u0010,\u001a\u00020$*\u00020$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"FILL_TYPE_WINDING", "", "LINECAP_BUTT", "LINECAP_ROUND", "LINECAP_SQUARE", "LINEJOIN_BEVEL", "LINEJOIN_MITER", "LINEJOIN_ROUND", "SHAPE_CLIP_PATH", "", "SHAPE_GROUP", "SHAPE_PATH", "getStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "id", "defValue", "getStrokeLineCap-CSYIeUk", "(II)I", "getStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getStrokeLineJoin-kLtJ_vA", "obtainBrushFromComplexColor", "Landroidx/compose/ui/graphics/Brush;", "complexColor", "Landroidx/core/content/res/ComplexColorCompat;", "createVectorImageBuilder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "attrs", "Landroid/util/AttributeSet;", "isAtEnd", "", "Lorg/xmlpull/v1/XmlPullParser;", "parseClipPath", "", "builder", "parseCurrentVectorNode", "nestedGroups", "parseGroup", "parsePath", "seekToStartTag", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: XmlVectorParser.android.kt */
public final class XmlVectorParser_androidKt {
    private static final int FILL_TYPE_WINDING = 0;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";

    /* renamed from: getStrokeLineCap-CSYIeUk$default  reason: not valid java name */
    static /* synthetic */ int m4614getStrokeLineCapCSYIeUk$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StrokeCap.Companion.m4230getButtKaPHkGw();
        }
        return m4613getStrokeLineCapCSYIeUk(i, i2);
    }

    /* renamed from: getStrokeLineCap-CSYIeUk  reason: not valid java name */
    private static final int m4613getStrokeLineCapCSYIeUk(int i, int i2) {
        if (i == 0) {
            return StrokeCap.Companion.m4230getButtKaPHkGw();
        }
        if (i == 1) {
            return StrokeCap.Companion.m4231getRoundKaPHkGw();
        }
        if (i != 2) {
            return i2;
        }
        return StrokeCap.Companion.m4232getSquareKaPHkGw();
    }

    /* renamed from: getStrokeLineJoin-kLtJ_vA$default  reason: not valid java name */
    static /* synthetic */ int m4616getStrokeLineJoinkLtJ_vA$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StrokeJoin.Companion.m4241getMiterLxFBmk8();
        }
        return m4615getStrokeLineJoinkLtJ_vA(i, i2);
    }

    /* renamed from: getStrokeLineJoin-kLtJ_vA  reason: not valid java name */
    private static final int m4615getStrokeLineJoinkLtJ_vA(int i, int i2) {
        if (i == 0) {
            return StrokeJoin.Companion.m4241getMiterLxFBmk8();
        }
        if (i == 1) {
            return StrokeJoin.Companion.m4242getRoundLxFBmk8();
        }
        if (i != 2) {
            return i2;
        }
        return StrokeJoin.Companion.m4240getBevelLxFBmk8();
    }

    public static final boolean isAtEnd(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() == 1) {
            return true;
        }
        if (xmlPullParser.getDepth() >= 1 || xmlPullParser.getEventType() != 3) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ int parseCurrentVectorNode$default(AndroidVectorParser androidVectorParser, Resources resources, AttributeSet attributeSet, Resources.Theme theme, ImageVector.Builder builder, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            theme = null;
        }
        return parseCurrentVectorNode(androidVectorParser, resources, attributeSet, theme, builder, i);
    }

    public static final int parseCurrentVectorNode(AndroidVectorParser androidVectorParser, Resources resources, AttributeSet attributeSet, Resources.Theme theme, ImageVector.Builder builder, int i) {
        int eventType = androidVectorParser.getXmlParser().getEventType();
        if (eventType == 2) {
            String name = androidVectorParser.getXmlParser().getName();
            if (name == null) {
                return i;
            }
            int hashCode = name.hashCode();
            if (hashCode != -1649314686) {
                if (hashCode != 3433509) {
                    if (hashCode != 98629247 || !name.equals("group")) {
                        return i;
                    }
                    parseGroup(androidVectorParser, resources, theme, attributeSet, builder);
                    return i;
                } else if (!name.equals(SHAPE_PATH)) {
                    return i;
                } else {
                    parsePath(androidVectorParser, resources, theme, attributeSet, builder);
                    return i;
                }
            } else if (!name.equals(SHAPE_CLIP_PATH)) {
                return i;
            } else {
                parseClipPath(androidVectorParser, resources, theme, attributeSet, builder);
                return i + 1;
            }
        } else if (eventType != 3 || !Intrinsics.areEqual((Object) "group", (Object) androidVectorParser.getXmlParser().getName())) {
            return i;
        } else {
            int i2 = i + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                builder.clearGroup();
            }
            return 0;
        }
    }

    public static final XmlPullParser seekToStartTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
        int next = xmlPullParser.next();
        while (next != 2 && next != 1) {
            next = xmlPullParser.next();
        }
        if (next == 2) {
            return xmlPullParser;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static final ImageVector.Builder createVectorImageBuilder(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        long j;
        int i;
        AndroidVectorParser androidVectorParser2 = androidVectorParser;
        Resources.Theme theme2 = theme;
        TypedArray obtainAttributes = androidVectorParser2.obtainAttributes(resources, theme2, attributeSet, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY());
        boolean namedBoolean = androidVectorParser2.getNamedBoolean(obtainAttributes, "autoMirrored", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_AUTO_MIRRORED(), false);
        float namedFloat = androidVectorParser2.getNamedFloat(obtainAttributes, "viewportWidth", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_WIDTH(), 0.0f);
        float namedFloat2 = androidVectorParser2.getNamedFloat(obtainAttributes, "viewportHeight", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_HEIGHT(), 0.0f);
        if (namedFloat <= 0.0f) {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        } else if (namedFloat2 > 0.0f) {
            float dimension = androidVectorParser2.getDimension(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_WIDTH(), 0.0f);
            float dimension2 = androidVectorParser2.getDimension(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_HEIGHT(), 0.0f);
            if (obtainAttributes.hasValue(AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) {
                TypedValue typedValue = new TypedValue();
                obtainAttributes.getValue(AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT(), typedValue);
                if (typedValue.type == 2) {
                    j = Color.Companion.m3852getUnspecified0d7_KjU();
                } else {
                    ColorStateList namedColorStateList = androidVectorParser2.getNamedColorStateList(obtainAttributes, theme2, "tint", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT());
                    if (namedColorStateList != null) {
                        j = ColorKt.Color(namedColorStateList.getDefaultColor());
                    } else {
                        j = Color.Companion.m3852getUnspecified0d7_KjU();
                    }
                }
            } else {
                j = Color.Companion.m3852getUnspecified0d7_KjU();
            }
            long j2 = j;
            int i2 = androidVectorParser2.getInt(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT_MODE(), -1);
            if (i2 == -1) {
                i = BlendMode.Companion.m3744getSrcIn0nO6VwU();
            } else if (i2 == 3) {
                i = BlendMode.Companion.m3746getSrcOver0nO6VwU();
            } else if (i2 == 5) {
                i = BlendMode.Companion.m3744getSrcIn0nO6VwU();
            } else if (i2 != 9) {
                switch (i2) {
                    case 14:
                        i = BlendMode.Companion.m3735getModulate0nO6VwU();
                        break;
                    case 15:
                        i = BlendMode.Companion.m3740getScreen0nO6VwU();
                        break;
                    case 16:
                        i = BlendMode.Companion.m3738getPlus0nO6VwU();
                        break;
                    default:
                        i = BlendMode.Companion.m3744getSrcIn0nO6VwU();
                        break;
                }
            } else {
                i = BlendMode.Companion.m3743getSrcAtop0nO6VwU();
            }
            int i3 = i;
            float r9 = Dp.m6614constructorimpl(dimension / resources.getDisplayMetrics().density);
            float r10 = Dp.m6614constructorimpl(dimension2 / resources.getDisplayMetrics().density);
            obtainAttributes.recycle();
            return new ImageVector.Builder((String) null, r9, r10, namedFloat, namedFloat2, j2, i3, namedBoolean, 1, (DefaultConstructorMarker) null);
        } else {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
    }

    public static final void parsePath(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) throws IllegalArgumentException {
        AndroidVectorParser androidVectorParser2 = androidVectorParser;
        TypedArray obtainAttributes = androidVectorParser2.obtainAttributes(resources, theme, attributeSet, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH());
        if (TypedArrayUtils.hasAttribute(androidVectorParser.getXmlParser(), "pathData")) {
            String string = androidVectorParser2.getString(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_NAME());
            if (string == null) {
                string = "";
            }
            String str = string;
            List<PathNode> addPathNodes = VectorKt.addPathNodes(androidVectorParser2.getString(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_PATH_DATA()));
            ComplexColorCompat namedComplexColor = androidVectorParser.getNamedComplexColor(obtainAttributes, theme, "fillColor", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_COLOR(), 0);
            float namedFloat = androidVectorParser2.getNamedFloat(obtainAttributes, "fillAlpha", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_ALPHA(), 1.0f);
            int r18 = m4613getStrokeLineCapCSYIeUk(androidVectorParser2.getNamedInt(obtainAttributes, "strokeLineCap", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_CAP(), -1), StrokeCap.Companion.m4230getButtKaPHkGw());
            int r19 = m4615getStrokeLineJoinkLtJ_vA(androidVectorParser2.getNamedInt(obtainAttributes, "strokeLineJoin", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_JOIN(), -1), StrokeJoin.Companion.m4240getBevelLxFBmk8());
            float namedFloat2 = androidVectorParser2.getNamedFloat(obtainAttributes, "strokeMiterLimit", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_MITER_LIMIT(), 1.0f);
            ComplexColorCompat namedComplexColor2 = androidVectorParser.getNamedComplexColor(obtainAttributes, theme, "strokeColor", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_COLOR(), 0);
            float namedFloat3 = androidVectorParser2.getNamedFloat(obtainAttributes, "strokeAlpha", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_ALPHA(), 1.0f);
            float namedFloat4 = androidVectorParser2.getNamedFloat(obtainAttributes, "strokeWidth", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_WIDTH(), 1.0f);
            float namedFloat5 = androidVectorParser2.getNamedFloat(obtainAttributes, "trimPathEnd", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_END(), 1.0f);
            float namedFloat6 = androidVectorParser2.getNamedFloat(obtainAttributes, "trimPathOffset", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_OFFSET(), 0.0f);
            float namedFloat7 = androidVectorParser2.getNamedFloat(obtainAttributes, "trimPathStart", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_START(), 0.0f);
            int namedInt = androidVectorParser2.getNamedInt(obtainAttributes, "fillType", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_FILLTYPE(), FILL_TYPE_WINDING);
            obtainAttributes.recycle();
            Brush obtainBrushFromComplexColor = obtainBrushFromComplexColor(namedComplexColor);
            Brush obtainBrushFromComplexColor2 = obtainBrushFromComplexColor(namedComplexColor2);
            PathFillType.Companion companion = PathFillType.Companion;
            builder.m4579addPathoIyEayM(addPathNodes, namedInt == 0 ? companion.m4129getNonZeroRgk1Os() : companion.m4128getEvenOddRgk1Os(), str, obtainBrushFromComplexColor, namedFloat, obtainBrushFromComplexColor2, namedFloat3, namedFloat4, r18, r19, namedFloat2, namedFloat7, namedFloat5, namedFloat6);
            return;
        }
        throw new IllegalArgumentException("No path data available");
    }

    private static final Brush obtainBrushFromComplexColor(ComplexColorCompat complexColorCompat) {
        if (!complexColorCompat.willDraw()) {
            return null;
        }
        Shader shader = complexColorCompat.getShader();
        if (shader != null) {
            return BrushKt.ShaderBrush(shader);
        }
        return new SolidColor(ColorKt.Color(complexColorCompat.getColor()), (DefaultConstructorMarker) null);
    }

    public static final void parseClipPath(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) {
        AndroidVectorParser androidVectorParser2 = androidVectorParser;
        TypedArray obtainAttributes = androidVectorParser.obtainAttributes(resources, theme, attributeSet, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH());
        String string = androidVectorParser.getString(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_NAME());
        if (string == null) {
            string = "";
        }
        List<PathNode> addPathNodes = VectorKt.addPathNodes(androidVectorParser.getString(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_PATH_DATA()));
        obtainAttributes.recycle();
        ImageVector.Builder.addGroup$default(builder, string, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, addPathNodes, 254, (Object) null);
    }

    public static final void parseGroup(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) {
        TypedArray obtainAttributes = androidVectorParser.obtainAttributes(resources, theme, attributeSet, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP());
        float namedFloat = androidVectorParser.getNamedFloat(obtainAttributes, "rotation", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_ROTATION(), 0.0f);
        float f = androidVectorParser.getFloat(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_X(), 0.0f);
        float f2 = androidVectorParser.getFloat(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_Y(), 0.0f);
        float namedFloat2 = androidVectorParser.getNamedFloat(obtainAttributes, "scaleX", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_X(), 1.0f);
        float namedFloat3 = androidVectorParser.getNamedFloat(obtainAttributes, "scaleY", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_Y(), 1.0f);
        float namedFloat4 = androidVectorParser.getNamedFloat(obtainAttributes, "translateX", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_X(), 0.0f);
        float namedFloat5 = androidVectorParser.getNamedFloat(obtainAttributes, "translateY", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_Y(), 0.0f);
        String string = androidVectorParser.getString(obtainAttributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_NAME());
        if (string == null) {
            string = "";
        }
        obtainAttributes.recycle();
        builder.addGroup(string, namedFloat, f, f2, namedFloat2, namedFloat3, namedFloat4, namedFloat5, VectorKt.getEmptyPath());
    }
}
