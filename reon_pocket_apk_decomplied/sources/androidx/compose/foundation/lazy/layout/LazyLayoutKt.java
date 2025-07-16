package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"MaxItemsToRetainForReuse", "", "LazyLayout", "", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(message = "Use an overload accepting a lambda prodicing an item provider instead", replaceWith = @kotlin.ReplaceWith(expression = "LazyLayout({ itemProvider }, modifier, prefetchState, measurePolicy)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyLayout(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r8, androidx.compose.ui.Modifier r9, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r10, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 852831187(0x32d52bd3, float:2.4816392E-8)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyLayout)P(!1,2,3)53@2125L68:LazyLayout.kt#wow0x6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0022
            boolean r1 = r12.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r13
            goto L_0x0023
        L_0x0022:
            r1 = r13
        L_0x0023:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 48
            goto L_0x003a
        L_0x002a:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x003a
            boolean r3 = r12.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r1 = r1 | r3
        L_0x003a:
            r3 = r14 & 4
            if (r3 == 0) goto L_0x0041
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0051
        L_0x0041:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0051
            boolean r4 = r12.changed((java.lang.Object) r10)
            if (r4 == 0) goto L_0x004e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0050
        L_0x004e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0050:
            r1 = r1 | r4
        L_0x0051:
            r4 = r14 & 8
            if (r4 == 0) goto L_0x0058
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0068
        L_0x0058:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0068
            boolean r4 = r12.changedInstance(r11)
            if (r4 == 0) goto L_0x0065
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0067
        L_0x0065:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0067:
            r1 = r1 | r4
        L_0x0068:
            r4 = r1 & 5851(0x16db, float:8.199E-42)
            r5 = 1170(0x492, float:1.64E-42)
            if (r4 != r5) goto L_0x007b
            boolean r4 = r12.getSkipping()
            if (r4 != 0) goto L_0x0075
            goto L_0x007b
        L_0x0075:
            r12.skipToGroupEnd()
        L_0x0078:
            r3 = r9
            r4 = r10
            goto L_0x00ce
        L_0x007b:
            if (r2 == 0) goto L_0x0081
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
        L_0x0081:
            if (r3 == 0) goto L_0x0084
            r10 = 0
        L_0x0084:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0090
            r2 = -1
            java.lang.String r3 = "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x0090:
            r0 = -1428817084(0xffffffffaad5fb44, float:-3.801075E-13)
            r12.startReplaceableGroup(r0)
            boolean r0 = r12.changed((java.lang.Object) r8)
            java.lang.Object r2 = r12.rememberedValue()
            if (r0 != 0) goto L_0x00a8
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x00b3
        L_0x00a8:
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$1 r0 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$1
            r0.<init>(r8)
            r2 = r0
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r12.updateRememberedValue(r2)
        L_0x00b3:
            r0 = r2
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r12.endReplaceableGroup()
            r6 = r1 & 8176(0x1ff0, float:1.1457E-41)
            r7 = 0
            r1 = r0
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0078
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0078
        L_0x00ce:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 == 0) goto L_0x00e3
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2 r10 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2
            r1 = r10
            r2 = r8
            r5 = r11
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void LazyLayout(Function0<? extends LazyLayoutItemProvider> function0, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2002163445);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyLayout)P(!1,2,3)78@3217L34,80@3257L1039:LazyLayout.kt#wow0x6");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) lazyLayoutPrefetchState) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                lazyLayoutPrefetchState = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2002163445, i3, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:77)");
            }
            LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(startRestartGroup, -1488997347, true, new LazyLayoutKt$LazyLayout$3(lazyLayoutPrefetchState, modifier, function2, SnapshotStateKt.rememberUpdatedState(function0, startRestartGroup, i3 & 14))), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyLayoutKt$LazyLayout$4(function0, modifier2, lazyLayoutPrefetchState2, function2, i, i2));
        }
    }
}
