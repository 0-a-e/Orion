package androidx.compose.material3;

import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$ScrollableTabRowImp$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$ScrollableTabRowImp$1(ScrollState scrollState, float f, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$scrollState = scrollState;
        this.$edgePadding = f;
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
        this.$selectedTabIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: androidx.compose.material3.ScrollableTabData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 3
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r21.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r21.skipToGroupEnd()
            goto L_0x0130
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)"
            r6 = -1178901494(0xffffffffb9bb640a, float:-3.5741954E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
        L_0x002b:
            r2 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            java.lang.Object r2 = r21.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x005e
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r2)
            r1.updateRememberedValue(r3)
            r2 = r3
        L_0x005e:
            r21.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r2 = r2.getCoroutineScope()
            r21.endReplaceableGroup()
            r3 = 121290627(0x73abf83, float:1.4049365E-34)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):TabRow.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            androidx.compose.foundation.ScrollState r5 = r0.$scrollState
            boolean r5 = r1.changed((java.lang.Object) r5)
            boolean r6 = r1.changed((java.lang.Object) r2)
            r5 = r5 | r6
            androidx.compose.foundation.ScrollState r6 = r0.$scrollState
            java.lang.Object r7 = r21.rememberedValue()
            if (r5 != 0) goto L_0x0090
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x0098
        L_0x0090:
            androidx.compose.material3.ScrollableTabData r7 = new androidx.compose.material3.ScrollableTabData
            r7.<init>(r6, r2)
            r1.updateRememberedValue(r7)
        L_0x0098:
            r12 = r7
            androidx.compose.material3.ScrollableTabData r12 = (androidx.compose.material3.ScrollableTabData) r12
            r21.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = 0
            r6 = 1
            r7 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r5, r6, r7)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenterStart()
            r6 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r2, r5, r6, r4, r7)
            androidx.compose.foundation.ScrollState r14 = r0.$scrollState
            r18 = 14
            r19 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ScrollKt.horizontalScroll$default(r13, r14, r15, r16, r17, r18, r19)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r2)
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.ClipKt.clipToBounds(r2)
            r4 = 121291080(0x73ac148, float:1.4049885E-34)
            r1.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            float r3 = r0.$edgePadding
            boolean r3 = r1.changed((float) r3)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$tabs
            boolean r4 = r1.changed((java.lang.Object) r4)
            r3 = r3 | r4
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$divider
            boolean r4 = r1.changed((java.lang.Object) r4)
            r3 = r3 | r4
            kotlin.jvm.functions.Function3<java.util.List<androidx.compose.material3.TabPosition>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$indicator
            boolean r4 = r1.changed((java.lang.Object) r4)
            r3 = r3 | r4
            boolean r4 = r1.changedInstance(r12)
            r3 = r3 | r4
            int r4 = r0.$selectedTabIndex
            boolean r4 = r1.changed((int) r4)
            r3 = r3 | r4
            float r9 = r0.$edgePadding
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.$tabs
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$divider
            int r13 = r0.$selectedTabIndex
            kotlin.jvm.functions.Function3<java.util.List<androidx.compose.material3.TabPosition>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r0.$indicator
            java.lang.Object r4 = r21.rememberedValue()
            if (r3 != 0) goto L_0x0113
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x011f
        L_0x0113:
            androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1 r3 = new androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
            r8 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r4 = r3
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r1.updateRememberedValue(r4)
        L_0x011f:
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r21.endReplaceableGroup()
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r2, r4, r1, r6, r6)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0130
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
