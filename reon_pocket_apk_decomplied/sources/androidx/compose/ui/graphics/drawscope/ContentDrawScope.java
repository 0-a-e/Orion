package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentDrawScope.kt */
public interface ContentDrawScope extends DrawScope {

    /* renamed from: androidx.compose.ui.graphics.drawscope.ContentDrawScope$-CC  reason: invalid class name */
    /* compiled from: ContentDrawScope.kt */
    public final /* synthetic */ class CC {
    }

    void drawContent();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ContentDrawScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
        public static void m4397drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            DrawScope.CC.m4435$default$drawImageAZ2fEMs(contentDrawScope, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
        public static long m4398getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            return DrawScope.CC.m4436$default$getCenterF1C5BW0(contentDrawScope);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public static long m4399getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            return DrawScope.CC.m4437$default$getSizeNHjbRc(contentDrawScope);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m4400roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m6554$default$roundToPxR2X_6o(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m4401roundToPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m6555$default$roundToPx0680j_4(contentDrawScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m4402toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            return FontScaling.CC.m6725$default$toDpGaN1DYA(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m4403toDpu2uoSUM(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m6556$default$toDpu2uoSUM((Density) contentDrawScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m4404toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            return Density.CC.m6557$default$toDpu2uoSUM((Density) contentDrawScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m4405toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m6558$default$toDpSizekrfVVM(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m4406toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m6559$default$toPxR2X_6o(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m4407toPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m6560$default$toPx0680j_4(contentDrawScope, f);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect dpRect) {
            return Density.CC.$default$toRect(contentDrawScope, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m4408toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m6561$default$toSizeXkaWNTQ(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m4409toSp0xMU5do(ContentDrawScope contentDrawScope, float f) {
            return FontScaling.CC.m6726$default$toSp0xMU5do(contentDrawScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m4410toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m6562$default$toSpkPz2Gy4((Density) contentDrawScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m4411toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            return Density.CC.m6563$default$toSpkPz2Gy4((Density) contentDrawScope, i);
        }
    }
}
