package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\u001a2\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002\u001a\u001e\u0010\u0018\u001a\u00020\u0019*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a.\u0010\u001d\u001a\u00020\u0019*\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"&\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"platformTextInputServiceInterceptor", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "getPlatformTextInputServiceInterceptor", "()Lkotlin/jvm/functions/Function1;", "setPlatformTextInputServiceInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "localeLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroid/content/res/Configuration;", "getLocaleLayoutDirection", "(Landroid/content/res/Configuration;)Landroidx/compose/ui/unit/LayoutDirection;", "dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "layoutDirectionFromInt", "layoutDirection", "preTransform", "", "other", "preTransform-JiSxe2E", "([F[F)V", "preTranslate", "x", "y", "tmpMatrix", "preTranslate-cG2Xzmc", "([FFF[F)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView_androidKt {
    private static Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> platformTextInputServiceInterceptor = AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1.INSTANCE;

    public static final Function1<PlatformTextInputService, PlatformTextInputService> getPlatformTextInputServiceInterceptor() {
        return platformTextInputServiceInterceptor;
    }

    public static final void setPlatformTextInputServiceInterceptor(Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> function1) {
        platformTextInputServiceInterceptor = function1;
    }

    public static final LayoutDirection getLocaleLayoutDirection(Configuration configuration) {
        return layoutDirectionFromInt(configuration.getLayoutDirection());
    }

    /* access modifiers changed from: private */
    public static final LayoutDirection layoutDirectionFromInt(int i) {
        if (i == 0) {
            return LayoutDirection.Ltr;
        }
        if (i != 1) {
            return LayoutDirection.Ltr;
        }
        return LayoutDirection.Rtl;
    }

    /* access modifiers changed from: private */
    /* renamed from: preTransform-JiSxe2E  reason: not valid java name */
    public static final void m5757preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        float r3 = m5756dotp89u6pk(fArr4, 0, fArr3, 0);
        float r5 = m5756dotp89u6pk(fArr4, 0, fArr3, 1);
        float r7 = m5756dotp89u6pk(fArr4, 0, fArr3, 2);
        float r9 = m5756dotp89u6pk(fArr4, 0, fArr3, 3);
        float r10 = m5756dotp89u6pk(fArr4, 1, fArr3, 0);
        float r11 = m5756dotp89u6pk(fArr4, 1, fArr3, 1);
        float r12 = m5756dotp89u6pk(fArr4, 1, fArr3, 2);
        float r13 = m5756dotp89u6pk(fArr4, 1, fArr3, 3);
        float r14 = m5756dotp89u6pk(fArr4, 2, fArr3, 0);
        float r15 = m5756dotp89u6pk(fArr4, 2, fArr3, 1);
        float r16 = m5756dotp89u6pk(fArr4, 2, fArr3, 2);
        float r17 = m5756dotp89u6pk(fArr4, 2, fArr3, 3);
        float r18 = m5756dotp89u6pk(fArr4, 3, fArr3, 0);
        float r19 = m5756dotp89u6pk(fArr4, 3, fArr3, 1);
        float r20 = m5756dotp89u6pk(fArr4, 3, fArr3, 2);
        float r1 = m5756dotp89u6pk(fArr4, 3, fArr3, 3);
        fArr3[0] = r3;
        fArr3[1] = r5;
        fArr3[2] = r7;
        fArr3[3] = r9;
        fArr3[4] = r10;
        fArr3[5] = r11;
        fArr3[6] = r12;
        fArr3[7] = r13;
        fArr3[8] = r14;
        fArr3[9] = r15;
        fArr3[10] = r16;
        fArr3[11] = r17;
        fArr3[12] = r18;
        fArr3[13] = r19;
        fArr3[14] = r20;
        fArr3[15] = r1;
    }

    /* access modifiers changed from: private */
    /* renamed from: preTranslate-cG2Xzmc  reason: not valid java name */
    public static final void m5758preTranslatecG2Xzmc(float[] fArr, float f, float f2, float[] fArr2) {
        Matrix.m4067resetimpl(fArr2);
        Matrix.m4078translateimpl$default(fArr2, f, f2, 0.0f, 4, (Object) null);
        m5757preTransformJiSxe2E(fArr, fArr2);
    }

    /* renamed from: dot-p89u6pk  reason: not valid java name */
    private static final float m5756dotp89u6pk(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = i * 4;
        return (fArr[i3] * fArr2[i2]) + (fArr[i3 + 1] * fArr2[4 + i2]) + (fArr[i3 + 2] * fArr2[8 + i2]) + (fArr[i3 + 3] * fArr2[12 + i2]);
    }
}
