package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aT\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0012\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"drawMultiParagraph", "", "Landroidx/compose/ui/text/MultiParagraph;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawMultiParagraph-7AXcY_I", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "drawParagraphs", "drawParagraphs-7AXcY_I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMultiParagraphDraw.android.kt */
public final class AndroidMultiParagraphDraw_androidKt {
    /* renamed from: drawMultiParagraph-7AXcY_I  reason: not valid java name */
    public static final void m6309drawMultiParagraph7AXcY_I(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        Brush brush2 = brush;
        canvas.save();
        if (multiParagraph.getParagraphInfoList$ui_text_release().size() <= 1) {
            m6311drawParagraphs7AXcY_I(multiParagraph, canvas, brush, f, shadow, textDecoration, drawStyle, i);
        } else if (brush2 instanceof SolidColor) {
            m6311drawParagraphs7AXcY_I(multiParagraph, canvas, brush, f, shadow, textDecoration, drawStyle, i);
        } else if (brush2 instanceof ShaderBrush) {
            List<ParagraphInfo> paragraphInfoList$ui_text_release = multiParagraph.getParagraphInfoList$ui_text_release();
            int size = paragraphInfoList$ui_text_release.size();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i2 = 0; i2 < size; i2++) {
                ParagraphInfo paragraphInfo = paragraphInfoList$ui_text_release.get(i2);
                f3 += paragraphInfo.getParagraph().getHeight();
                f2 = Math.max(f2, paragraphInfo.getParagraph().getWidth());
            }
            Shader r0 = ((ShaderBrush) brush2).m4186createShaderuvyYCjk(SizeKt.Size(f2, f3));
            Matrix matrix = new Matrix();
            r0.getLocalMatrix(matrix);
            List<ParagraphInfo> paragraphInfoList$ui_text_release2 = multiParagraph.getParagraphInfoList$ui_text_release();
            int size2 = paragraphInfoList$ui_text_release2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ParagraphInfo paragraphInfo2 = paragraphInfoList$ui_text_release2.get(i3);
                Canvas canvas2 = canvas;
                paragraphInfo2.getParagraph().m5924painthn5TExg(canvas2, BrushKt.ShaderBrush(r0), f, shadow, textDecoration, drawStyle, i);
                canvas2.translate(0.0f, paragraphInfo2.getParagraph().getHeight());
                matrix.setTranslate(0.0f, -paragraphInfo2.getParagraph().getHeight());
                r0.setLocalMatrix(matrix);
            }
        }
        Canvas canvas3 = canvas;
        canvas.restore();
    }

    /* renamed from: drawMultiParagraph-7AXcY_I$default  reason: not valid java name */
    public static /* synthetic */ void m6310drawMultiParagraph7AXcY_I$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        m6309drawMultiParagraph7AXcY_I(multiParagraph, canvas, brush, (i2 & 4) != 0 ? Float.NaN : f, (i2 & 8) != 0 ? null : shadow, (i2 & 16) != 0 ? null : textDecoration, (i2 & 32) != 0 ? null : drawStyle, (i2 & 64) != 0 ? BlendMode.Companion.m3746getSrcOver0nO6VwU() : i);
    }

    /* renamed from: drawParagraphs-7AXcY_I  reason: not valid java name */
    private static final void m6311drawParagraphs7AXcY_I(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        List<ParagraphInfo> paragraphInfoList$ui_text_release = multiParagraph.getParagraphInfoList$ui_text_release();
        int size = paragraphInfoList$ui_text_release.size();
        for (int i2 = 0; i2 < size; i2++) {
            ParagraphInfo paragraphInfo = paragraphInfoList$ui_text_release.get(i2);
            paragraphInfo.getParagraph().m5924painthn5TExg(canvas, brush, f, shadow, textDecoration, drawStyle, i);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
    }
}
