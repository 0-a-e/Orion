package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$SingleRowTopAppBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $actionsRow;
    final /* synthetic */ boolean $centeredTitle;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$SingleRowTopAppBar$2(WindowInsets windowInsets, TopAppBarColors topAppBarColors, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TopAppBarScrollBehavior topAppBarScrollBehavior) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$colors = topAppBarColors;
        this.$title = function2;
        this.$titleTextStyle = textStyle;
        this.$centeredTitle = z;
        this.$navigationIcon = function22;
        this.$actionsRow = function23;
        this.$scrollBehavior = topAppBarScrollBehavior;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0050, code lost:
        r2 = r2.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r22, int r23) {
        /*
            r21 = this;
            r0 = r21
            r13 = r22
            r1 = r23
            java.lang.String r2 = "C*1691@75731L7,1695@75881L890:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001c
            boolean r2 = r22.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r22.skipToGroupEnd()
            goto L_0x00bf
        L_0x001c:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002b
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1691)"
            r4 = 376925230(0x16776c2e, float:1.9986637E-25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x002b:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r2, r3)
            java.lang.Object r1 = r13.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r22)
            androidx.compose.material3.TopAppBarScrollBehavior r2 = r0.$scrollBehavior
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.material3.tokens.TopAppBarSmallTokens r3 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r3 = r3.m3207getContainerHeightD9Ej5fM()
            float r1 = r1.m6550toPx0680j_4(r3)
            if (r2 == 0) goto L_0x005b
            androidx.compose.material3.TopAppBarState r2 = r2.getState()
            if (r2 == 0) goto L_0x005b
            float r2 = r2.getHeightOffset()
            goto L_0x005c
        L_0x005b:
            r2 = 0
        L_0x005c:
            float r2 = r2 + r1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.layout.WindowInsets r3 = r0.$windowInsets
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.windowInsetsPadding(r1, r3)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.ClipKt.clipToBounds(r1)
            androidx.compose.material3.TopAppBarColors r3 = r0.$colors
            long r3 = r3.m2613getNavigationIconContentColor0d7_KjU()
            androidx.compose.material3.TopAppBarColors r5 = r0.$colors
            long r5 = r5.m2615getTitleContentColor0d7_KjU()
            androidx.compose.material3.TopAppBarColors r7 = r0.$colors
            long r7 = r7.m2611getActionIconContentColor0d7_KjU()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r9 = r0.$title
            androidx.compose.ui.text.TextStyle r10 = r0.$titleTextStyle
            androidx.compose.foundation.layout.Arrangement r11 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r11 = r11.getCenter()
            r12 = r11
            androidx.compose.foundation.layout.Arrangement$Vertical r12 = (androidx.compose.foundation.layout.Arrangement.Vertical) r12
            boolean r11 = r0.$centeredTitle
            if (r11 == 0) goto L_0x0097
            androidx.compose.foundation.layout.Arrangement r11 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r11 = r11.getCenter()
            androidx.compose.foundation.layout.Arrangement$Horizontal r11 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r11
            goto L_0x009d
        L_0x0097:
            androidx.compose.foundation.layout.Arrangement r11 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r11 = r11.getStart()
        L_0x009d:
            r18 = r11
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$navigationIcon
            r16 = r11
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$actionsRow
            r17 = r11
            r19 = 113246208(0x6c00000, float:7.2222373E-35)
            r20 = 3126(0xc36, float:4.38E-42)
            r11 = 1065353216(0x3f800000, float:1.0)
            r14 = 0
            r15 = 0
            r13 = r18
            r18 = r22
            androidx.compose.material3.AppBarKt.m1515TopAppBarLayoutkXwM9vE(r1, r2, r3, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00bf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
