package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "invoke", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutKt$LazyLayout$3 extends Lambda implements Function3<SaveableStateHolder, Composer, Integer, Unit> {
    final /* synthetic */ State<Function0<LazyLayoutItemProvider>> $currentItemProvider;
    final /* synthetic */ Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> $measurePolicy;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$3(LazyLayoutPrefetchState lazyLayoutPrefetchState, Modifier modifier, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2, State<? extends Function0<? extends LazyLayoutItemProvider>> state) {
        super(3);
        this.$prefetchState = lazyLayoutPrefetchState;
        this.$modifier = modifier;
        this.$measurePolicy = function2;
        this.$currentItemProvider = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SaveableStateHolder) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.saveable.SaveableStateHolder r10, androidx.compose.runtime.Composer r11, int r12) {
        /*
            r9 = this;
            java.lang.String r0 = "C81@3347L114,84@3498L101,98@3888L392,95@3801L489:LazyLayout.kt#wow0x6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0014
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:81)"
            r2 = -1488997347(0xffffffffa73fb41d, float:-2.6604214E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r12, r0, r1)
        L_0x0014:
            androidx.compose.runtime.State<kotlin.jvm.functions.Function0<androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>> r12 = r9.$currentItemProvider
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.String r1 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r2 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x003c
            androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory r2 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1 r3 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1
            r3.<init>(r12)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r2.<init>(r10, r3)
            r11.updateRememberedValue(r2)
        L_0x003c:
            r11.endReplaceableGroup()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory r2 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory) r2
            r11.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r10 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x0062
            androidx.compose.ui.layout.SubcomposeLayoutState r10 = new androidx.compose.ui.layout.SubcomposeLayoutState
            androidx.compose.foundation.lazy.layout.LazyLayoutItemReusePolicy r12 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemReusePolicy
            r12.<init>(r2)
            androidx.compose.ui.layout.SubcomposeSlotReusePolicy r12 = (androidx.compose.ui.layout.SubcomposeSlotReusePolicy) r12
            r10.<init>((androidx.compose.ui.layout.SubcomposeSlotReusePolicy) r12)
            r11.updateRememberedValue(r10)
        L_0x0062:
            r11.endReplaceableGroup()
            r3 = r10
            androidx.compose.ui.layout.SubcomposeLayoutState r3 = (androidx.compose.ui.layout.SubcomposeLayoutState) r3
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r10 = r9.$prefetchState
            r12 = -1523807258(0xffffffffa52c8be6, float:-1.4966021E-16)
            r11.startReplaceableGroup(r12)
            java.lang.String r12 = "*88@3641L140"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            if (r10 != 0) goto L_0x0078
            goto L_0x0085
        L_0x0078:
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r10 = r9.$prefetchState
            int r12 = androidx.compose.ui.layout.SubcomposeLayoutState.$stable
            int r12 = r12 << 6
            r12 = r12 | 64
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(r10, r2, r3, r11, r12)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L_0x0085:
            r11.endReplaceableGroup()
            androidx.compose.ui.Modifier r4 = r9.$modifier
            kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> r10 = r9.$measurePolicy
            r12 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            boolean r12 = r11.changed((java.lang.Object) r2)
            boolean r0 = r11.changed((java.lang.Object) r10)
            r12 = r12 | r0
            java.lang.Object r0 = r11.rememberedValue()
            if (r12 != 0) goto L_0x00ae
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r0 != r12) goto L_0x00b9
        L_0x00ae:
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1 r12 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1
            r12.<init>(r2, r10)
            r0 = r12
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateRememberedValue(r0)
        L_0x00b9:
            r11.endReplaceableGroup()
            r5 = r0
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            int r7 = androidx.compose.ui.layout.SubcomposeLayoutState.$stable
            r8 = 0
            r6 = r11
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r3, r4, r5, r6, r7, r8)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00cf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3.invoke(androidx.compose.runtime.saveable.SaveableStateHolder, androidx.compose.runtime.Composer, int):void");
    }
}
