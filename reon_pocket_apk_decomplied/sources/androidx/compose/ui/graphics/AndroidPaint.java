package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\f\u0010K\u001a\u00060\u0004j\u0002`LH\u0016R\u0016\u0010\u0006\u001a\u00020\u0007X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\u001b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020!8V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u0010\u0010%\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(X\u000e¢\u0006\u0002\n\u0000R$\u0010*\u001a\u00020)2\u0006\u0010\t\u001a\u00020)8V@VX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\t\u001a\u0004\u0018\u00010.@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R4\u00104\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(2\u000e\u0010\t\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(8V@VX\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010:\u001a\u0002092\u0006\u0010\t\u001a\u0002098V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b;\u0010\u0012\"\u0004\b<\u0010\u0014R*\u0010>\u001a\u00020=2\u0006\u0010\t\u001a\u00020=8V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010\u0014R$\u0010A\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u000e¢\u0006\f\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR$\u0010D\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u000e¢\u0006\f\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR*\u0010H\u001a\u00020G2\u0006\u0010\t\u001a\u00020G8V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPaint;", "Landroidx/compose/ui/graphics/Paint;", "()V", "internalPaint", "Landroid/graphics/Paint;", "(Landroid/graphics/Paint;)V", "_blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "getFilterQuality-f-v9h1I", "setFilterQuality-vDHp3xo", "internalColorFilter", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "", "isAntiAlias", "()Z", "setAntiAlias", "(Z)V", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "setPathEffect", "(Landroidx/compose/ui/graphics/PathEffect;)V", "shader", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeCap", "getStrokeCap-KaPHkGw", "setStrokeCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeJoin", "getStrokeJoin-LxFBmk8", "setStrokeJoin-Ww9F2mQ", "strokeMiterLimit", "getStrokeMiterLimit", "setStrokeMiterLimit", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "Landroidx/compose/ui/graphics/PaintingStyle;", "style", "getStyle-TiuSbCo", "setStyle-k9PVt8s", "asFrameworkPaint", "Landroidx/compose/ui/graphics/NativePaint;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPaint.android.kt */
public final class AndroidPaint implements Paint {
    private int _blendMode;
    private ColorFilter internalColorFilter;
    private Paint internalPaint;
    private Shader internalShader;
    private PathEffect pathEffect;

    public AndroidPaint(Paint paint) {
        this.internalPaint = paint;
        this._blendMode = BlendMode.Companion.m3746getSrcOver0nO6VwU();
    }

    public AndroidPaint() {
        this(AndroidPaint_androidKt.makeNativePaint());
    }

    public Paint asFrameworkPaint() {
        return this.internalPaint;
    }

    public float getAlpha() {
        return AndroidPaint_androidKt.getNativeAlpha(this.internalPaint);
    }

    public void setAlpha(float f) {
        AndroidPaint_androidKt.setNativeAlpha(this.internalPaint, f);
    }

    public boolean isAntiAlias() {
        return AndroidPaint_androidKt.getNativeAntiAlias(this.internalPaint);
    }

    public void setAntiAlias(boolean z) {
        AndroidPaint_androidKt.setNativeAntiAlias(this.internalPaint, z);
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public long m3677getColor0d7_KjU() {
        return AndroidPaint_androidKt.getNativeColor(this.internalPaint);
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public void m3683setColor8_81llA(long j) {
        AndroidPaint_androidKt.m3689setNativeColor4WTKRHQ(this.internalPaint, j);
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public int m3676getBlendMode0nO6VwU() {
        return this._blendMode;
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public void m3682setBlendModes9anfk8(int i) {
        if (!BlendMode.m3715equalsimpl0(this._blendMode, i)) {
            this._blendMode = i;
            AndroidPaint_androidKt.m3688setNativeBlendModeGB0RdKg(this.internalPaint, i);
        }
    }

    /* renamed from: getStyle-TiuSbCo  reason: not valid java name */
    public int m3681getStyleTiuSbCo() {
        return AndroidPaint_androidKt.getNativeStyle(this.internalPaint);
    }

    /* renamed from: setStyle-k9PVt8s  reason: not valid java name */
    public void m3687setStylek9PVt8s(int i) {
        AndroidPaint_androidKt.m3693setNativeStyle5YerkU(this.internalPaint, i);
    }

    public float getStrokeWidth() {
        return AndroidPaint_androidKt.getNativeStrokeWidth(this.internalPaint);
    }

    public void setStrokeWidth(float f) {
        AndroidPaint_androidKt.setNativeStrokeWidth(this.internalPaint, f);
    }

    /* renamed from: getStrokeCap-KaPHkGw  reason: not valid java name */
    public int m3679getStrokeCapKaPHkGw() {
        return AndroidPaint_androidKt.getNativeStrokeCap(this.internalPaint);
    }

    /* renamed from: setStrokeCap-BeK7IIE  reason: not valid java name */
    public void m3685setStrokeCapBeK7IIE(int i) {
        AndroidPaint_androidKt.m3691setNativeStrokeCapCSYIeUk(this.internalPaint, i);
    }

    /* renamed from: getStrokeJoin-LxFBmk8  reason: not valid java name */
    public int m3680getStrokeJoinLxFBmk8() {
        return AndroidPaint_androidKt.getNativeStrokeJoin(this.internalPaint);
    }

    /* renamed from: setStrokeJoin-Ww9F2mQ  reason: not valid java name */
    public void m3686setStrokeJoinWw9F2mQ(int i) {
        AndroidPaint_androidKt.m3692setNativeStrokeJoinkLtJ_vA(this.internalPaint, i);
    }

    public float getStrokeMiterLimit() {
        return AndroidPaint_androidKt.getNativeStrokeMiterLimit(this.internalPaint);
    }

    public void setStrokeMiterLimit(float f) {
        AndroidPaint_androidKt.setNativeStrokeMiterLimit(this.internalPaint, f);
    }

    /* renamed from: getFilterQuality-f-v9h1I  reason: not valid java name */
    public int m3678getFilterQualityfv9h1I() {
        return AndroidPaint_androidKt.getNativeFilterQuality(this.internalPaint);
    }

    /* renamed from: setFilterQuality-vDHp3xo  reason: not valid java name */
    public void m3684setFilterQualityvDHp3xo(int i) {
        AndroidPaint_androidKt.m3690setNativeFilterQuality50PEsBU(this.internalPaint, i);
    }

    public Shader getShader() {
        return this.internalShader;
    }

    public void setShader(Shader shader) {
        this.internalShader = shader;
        AndroidPaint_androidKt.setNativeShader(this.internalPaint, shader);
    }

    public ColorFilter getColorFilter() {
        return this.internalColorFilter;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.internalColorFilter = colorFilter;
        AndroidPaint_androidKt.setNativeColorFilter(this.internalPaint, colorFilter);
    }

    public PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public void setPathEffect(PathEffect pathEffect2) {
        AndroidPaint_androidKt.setNativePathEffect(this.internalPaint, pathEffect2);
        this.pathEffect = pathEffect2;
    }
}
