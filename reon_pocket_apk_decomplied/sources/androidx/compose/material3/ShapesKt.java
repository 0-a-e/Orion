package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a\u0014\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0000\u001a\f\u0010\u000e\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a\f\u0010\u000f\u001a\u00020\u000b*\u00020\u000bH\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078AX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"LocalShapes", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/Shapes;", "getLocalShapes", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "value", "Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/ShapeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "bottom", "Landroidx/compose/foundation/shape/CornerBasedShape;", "end", "fromToken", "start", "top", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Shapes.kt */
public final class ShapesKt {
    private static final ProvidableCompositionLocal<Shapes> LocalShapes = CompositionLocalKt.staticCompositionLocalOf(ShapesKt$LocalShapes$1.INSTANCE);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Shapes.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.compose.material3.tokens.ShapeKeyTokens[] r0 = androidx.compose.material3.tokens.ShapeKeyTokens.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerExtraLarge     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerExtraLargeTop     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerExtraSmall     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerExtraSmallTop     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerFull     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerLarge     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerLargeEnd     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerLargeTop     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerMedium     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerNone     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                androidx.compose.material3.tokens.ShapeKeyTokens r1 = androidx.compose.material3.tokens.ShapeKeyTokens.CornerSmall     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ShapesKt.WhenMappings.<clinit>():void");
        }
    }

    public static final Shape fromToken(Shapes shapes, ShapeKeyTokens shapeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[shapeKeyTokens.ordinal()]) {
            case 1:
                return shapes.getExtraLarge();
            case 2:
                return top(shapes.getExtraLarge());
            case 3:
                return shapes.getExtraSmall();
            case 4:
                return top(shapes.getExtraSmall());
            case 5:
                return RoundedCornerShapeKt.getCircleShape();
            case 6:
                return shapes.getLarge();
            case 7:
                return end(shapes.getLarge());
            case 8:
                return top(shapes.getLarge());
            case 9:
                return shapes.getMedium();
            case 10:
                return RectangleShapeKt.getRectangleShape();
            case 11:
                return shapes.getSmall();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Shape getValue(ShapeKeyTokens shapeKeyTokens, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1629172543, "C192@7777L6:Shapes.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1629172543, i, -1, "androidx.compose.material3.<get-value> (Shapes.kt:192)");
        }
        Shape fromToken = fromToken(MaterialTheme.INSTANCE.getShapes(composer, 6), shapeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fromToken;
    }

    public static final ProvidableCompositionLocal<Shapes> getLocalShapes() {
        return LocalShapes;
    }

    public static final CornerBasedShape top(CornerBasedShape cornerBasedShape) {
        float f = (float) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return CornerBasedShape.copy$default(cornerBasedShape, (CornerSize) null, (CornerSize) null, CornerSizeKt.m1024CornerSize0680j_4(Dp.m6614constructorimpl(f)), CornerSizeKt.m1024CornerSize0680j_4(Dp.m6614constructorimpl(f)), 3, (Object) null);
    }

    public static final CornerBasedShape bottom(CornerBasedShape cornerBasedShape) {
        float f = (float) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return CornerBasedShape.copy$default(cornerBasedShape, CornerSizeKt.m1024CornerSize0680j_4(Dp.m6614constructorimpl(f)), CornerSizeKt.m1024CornerSize0680j_4(Dp.m6614constructorimpl(f)), (CornerSize) null, (CornerSize) null, 12, (Object) null);
    }

    public static final CornerBasedShape start(CornerBasedShape cornerBasedShape) {
        float f = (float) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return CornerBasedShape.copy$default(cornerBasedShape, (CornerSize) null, CornerSizeKt.m1024CornerSize0680j_4(Dp.m6614constructorimpl(f)), CornerSizeKt.m1024CornerSize0680j_4(Dp.m6614constructorimpl(f)), (CornerSize) null, 9, (Object) null);
    }

    public static final CornerBasedShape end(CornerBasedShape cornerBasedShape) {
        float f = (float) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return CornerBasedShape.copy$default(cornerBasedShape, CornerSizeKt.m1024CornerSize0680j_4(Dp.m6614constructorimpl(f)), (CornerSize) null, (CornerSize) null, CornerSizeKt.m1024CornerSize0680j_4(Dp.m6614constructorimpl(f)), 6, (Object) null);
    }
}
