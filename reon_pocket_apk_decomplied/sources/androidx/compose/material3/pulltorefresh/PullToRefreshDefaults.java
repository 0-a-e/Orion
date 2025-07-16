package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "()V", "PositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "getPositionalThreshold-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "Indicator", "", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Indicator-FNF3uiM", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
public final class PullToRefreshDefaults {
    public static final int $stable = 0;
    public static final PullToRefreshDefaults INSTANCE = new PullToRefreshDefaults();
    private static final float PositionalThreshold = Dp.m6614constructorimpl((float) 80);
    private static final Shape shape = RoundedCornerShapeKt.getCircleShape();

    private PullToRefreshDefaults() {
    }

    public final Shape getShape() {
        return shape;
    }

    public final long getContainerColor(Composer composer, int i) {
        composer.startReplaceableGroup(1066257972);
        ComposerKt.sourceInformation(composer, "C150@6323L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066257972, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:150)");
        }
        long r0 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1670getSurfaceContainerHigh0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    public final long getContentColor(Composer composer, int i) {
        composer.startReplaceableGroup(813427380);
        ComposerKt.sourceInformation(composer, "C153@6487L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(813427380, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-contentColor> (PullToRefresh.kt:153)");
        }
        long r0 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1657getOnSurfaceVariant0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: getPositionalThreshold-D9Ej5fM  reason: not valid java name */
    public final float m2632getPositionalThresholdD9Ej5fM() {
        return PositionalThreshold;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* renamed from: Indicator-FNF3uiM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2631IndicatorFNF3uiM(androidx.compose.material3.pulltorefresh.PullToRefreshState r18, androidx.compose.ui.Modifier r19, long r20, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r17 = this;
            r2 = r18
            r6 = r23
            r0 = 1160852333(0x4531336d, float:2835.214)
            r1 = r22
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(Indicator)P(2,1,0:c#ui.graphics.Color)165@6853L7,167@6878L781:PullToRefresh.kt#djiw08"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r24 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r6 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r6
            goto L_0x0029
        L_0x0028:
            r3 = r6
        L_0x0029:
            r4 = r24 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r6 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r19
            boolean r7 = r1.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r5 = r19
        L_0x0045:
            r7 = r6 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005e
            r7 = r24 & 4
            if (r7 != 0) goto L_0x0058
            r7 = r20
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x005a
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r7 = r20
        L_0x005a:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r9
            goto L_0x0060
        L_0x005e:
            r7 = r20
        L_0x0060:
            r9 = r3 & 147(0x93, float:2.06E-43)
            r10 = 146(0x92, float:2.05E-43)
            if (r9 != r10) goto L_0x0074
            boolean r9 = r1.getSkipping()
            if (r9 != 0) goto L_0x006d
            goto L_0x0074
        L_0x006d:
            r1.skipToGroupEnd()
            r3 = r5
            r4 = r7
            goto L_0x0101
        L_0x0074:
            r1.startDefaults()
            r9 = r6 & 1
            if (r9 == 0) goto L_0x008d
            boolean r9 = r1.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0082
            goto L_0x008d
        L_0x0082:
            r1.skipToGroupEnd()
            r4 = r24 & 4
            if (r4 == 0) goto L_0x008b
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x008b:
            r4 = r5
            goto L_0x00b6
        L_0x008d:
            if (r4 == 0) goto L_0x0094
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0095
        L_0x0094:
            r4 = r5
        L_0x0095:
            r5 = r24 & 4
            if (r5 == 0) goto L_0x00b6
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r8)
            java.lang.Object r5 = r1.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r7 = r5.m3826unboximpl()
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00b6:
            r14 = r7
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00c6
            r5 = -1
            java.lang.String r7 = "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:166)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r5, r7)
        L_0x00c6:
            boolean r0 = r18.isRefreshing()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r0)
            r0 = 100
            r3 = 0
            r5 = 0
            r8 = 6
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r3, r5, r8, r5)
            r9 = r0
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1
            r0.<init>(r4, r14, r2)
            r3 = -1378661396(0xffffffffadd34bec, float:-2.4021639E-11)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r3, r5, r0)
            r11 = r0
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r13 = 24960(0x6180, float:3.4976E-41)
            r0 = 10
            r8 = 0
            r10 = 0
            r12 = r1
            r15 = r14
            r14 = r0
            androidx.compose.animation.CrossfadeKt.Crossfade(r7, (androidx.compose.ui.Modifier) r8, (androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float>) r9, (java.lang.String) r10, r11, (androidx.compose.runtime.Composer) r12, (int) r13, (int) r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ff:
            r3 = r4
            r4 = r15
        L_0x0101:
            androidx.compose.runtime.ScopeUpdateScope r8 = r1.endRestartGroup()
            if (r8 == 0) goto L_0x011a
            androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$2 r9 = new androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$2
            r0 = r9
            r1 = r17
            r2 = r18
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.m2631IndicatorFNF3uiM(androidx.compose.material3.pulltorefresh.PullToRefreshState, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
