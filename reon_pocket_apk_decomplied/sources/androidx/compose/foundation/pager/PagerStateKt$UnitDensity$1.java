package androidx.compose.foundation.pager;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/ui/unit/Density;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public final class PagerStateKt$UnitDensity$1 implements Density {
    private final float density = 1.0f;
    private final float fontScale = 1.0f;

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ int m987roundToPxR2X_6o(long j) {
        return Density.CC.m6554$default$roundToPxR2X_6o(this, j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public /* synthetic */ int m988roundToPx0680j_4(float f) {
        return Density.CC.m6555$default$roundToPx0680j_4(this, f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public /* synthetic */ float m989toDpGaN1DYA(long j) {
        return FontScaling.CC.m6725$default$toDpGaN1DYA(this, j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m990toDpu2uoSUM(float f) {
        return Density.CC.m6556$default$toDpu2uoSUM((Density) this, f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m991toDpu2uoSUM(int i) {
        return Density.CC.m6557$default$toDpu2uoSUM((Density) this, i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public /* synthetic */ long m992toDpSizekrfVVM(long j) {
        return Density.CC.m6558$default$toDpSizekrfVVM(this, j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ float m993toPxR2X_6o(long j) {
        return Density.CC.m6559$default$toPxR2X_6o(this, j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public /* synthetic */ float m994toPx0680j_4(float f) {
        return Density.CC.m6560$default$toPx0680j_4(this, f);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return Density.CC.$default$toRect(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public /* synthetic */ long m995toSizeXkaWNTQ(long j) {
        return Density.CC.m6561$default$toSizeXkaWNTQ(this, j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public /* synthetic */ long m996toSp0xMU5do(float f) {
        return FontScaling.CC.m6726$default$toSp0xMU5do(this, f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m997toSpkPz2Gy4(float f) {
        return Density.CC.m6562$default$toSpkPz2Gy4((Density) this, f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m998toSpkPz2Gy4(int i) {
        return Density.CC.m6563$default$toSpkPz2Gy4((Density) this, i);
    }

    PagerStateKt$UnitDensity$1() {
    }

    public float getDensity() {
        return this.density;
    }

    public float getFontScale() {
        return this.fontScale;
    }
}
