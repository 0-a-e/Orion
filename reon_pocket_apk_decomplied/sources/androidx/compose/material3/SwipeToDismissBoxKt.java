package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ak\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001ao\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0019\u001aR\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00112\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00160\b2#\b\u0002\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u001e0\bH\u0007¢\u0006\u0002\u0010\"\u001a$\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006$"}, d2 = {"DismissThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismiss", "", "state", "Landroidx/compose/material3/SwipeToDismissBoxState;", "background", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Ljava/util/Set;Landroidx/compose/runtime/Composer;II)V", "SwipeToDismissBox", "backgroundContent", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "content", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSwipeToDismissBoxState", "initialValue", "confirmValueChange", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "swipeToDismissBoxAnchors", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
public final class SwipeToDismissBoxKt {
    /* access modifiers changed from: private */
    public static final float DismissThreshold = Dp.m6614constructorimpl((float) 125);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.SwipeToDismissBoxState, androidx.compose.material3.SwipeToDismissBoxValue>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: kotlin.jvm.functions.Function1<java.lang.Float, java.lang.Float>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.SwipeToDismissBoxState rememberSwipeToDismissBoxState(androidx.compose.material3.SwipeToDismissBoxValue r10, kotlin.jvm.functions.Function1<? super androidx.compose.material3.SwipeToDismissBoxValue, java.lang.Boolean> r11, kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            r0 = -246335487(0xfffffffff1513801, float:-1.03600115E30)
            r13.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberSwipeToDismissBoxState)P(1)218@8375L19,220@8455L7,227@8669L102,221@8474L297:SwipeToDismissBox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x0011
            androidx.compose.material3.SwipeToDismissBoxValue r10 = androidx.compose.material3.SwipeToDismissBoxValue.Settled
        L_0x0011:
            r1 = r15 & 2
            if (r1 == 0) goto L_0x0019
            androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$1 r11 = androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$1.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
        L_0x0019:
            r1 = 4
            r15 = r15 & r1
            r2 = 6
            if (r15 == 0) goto L_0x0024
            androidx.compose.material3.SwipeToDismissBoxDefaults r12 = androidx.compose.material3.SwipeToDismissBoxDefaults.INSTANCE
            kotlin.jvm.functions.Function1 r12 = r12.getPositionalThreshold(r13, r2)
        L_0x0024:
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0030
            r15 = -1
            java.lang.String r3 = "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:219)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r15, r3)
        L_0x0030:
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r3)
            java.lang.Object r15 = r13.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            r0 = 0
            java.lang.Object[] r3 = new java.lang.Object[r0]
            androidx.compose.material3.SwipeToDismissBoxState$Companion r4 = androidx.compose.material3.SwipeToDismissBoxState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r4.Saver(r11, r12, r15)
            r5 = -1012845646(0xffffffffc3a133b2, float:-322.40387)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):SwipeToDismissBox.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            r5 = r14 & 14
            r2 = r2 ^ r5
            r5 = 1
            if (r2 <= r1) goto L_0x0067
            boolean r2 = r13.changed((java.lang.Object) r10)
            if (r2 != 0) goto L_0x006b
        L_0x0067:
            r2 = r14 & 6
            if (r2 != r1) goto L_0x006d
        L_0x006b:
            r1 = r5
            goto L_0x006e
        L_0x006d:
            r1 = r0
        L_0x006e:
            boolean r2 = r13.changed((java.lang.Object) r15)
            r1 = r1 | r2
            r2 = r14 & 112(0x70, float:1.57E-43)
            r2 = r2 ^ 48
            r6 = 32
            if (r2 <= r6) goto L_0x0081
            boolean r2 = r13.changed((java.lang.Object) r11)
            if (r2 != 0) goto L_0x0085
        L_0x0081:
            r2 = r14 & 48
            if (r2 != r6) goto L_0x0087
        L_0x0085:
            r2 = r5
            goto L_0x0088
        L_0x0087:
            r2 = r0
        L_0x0088:
            r1 = r1 | r2
            r2 = r14 & 896(0x380, float:1.256E-42)
            r2 = r2 ^ 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r2 <= r6) goto L_0x0097
            boolean r2 = r13.changed((java.lang.Object) r12)
            if (r2 != 0) goto L_0x009b
        L_0x0097:
            r14 = r14 & 384(0x180, float:5.38E-43)
            if (r14 != r6) goto L_0x009c
        L_0x009b:
            r0 = r5
        L_0x009c:
            r14 = r1 | r0
            java.lang.Object r0 = r13.rememberedValue()
            if (r14 != 0) goto L_0x00ac
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r0 != r14) goto L_0x00b7
        L_0x00ac:
            androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1 r14 = new androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1
            r14.<init>(r10, r15, r11, r12)
            r0 = r14
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r13.updateRememberedValue(r0)
        L_0x00b7:
            r6 = r0
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r13.endReplaceableGroup()
            r8 = 0
            r9 = 4
            r5 = 0
            r7 = r13
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.material3.SwipeToDismissBoxState r10 = (androidx.compose.material3.SwipeToDismissBoxState) r10
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x00d0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00d0:
            r13.endReplaceableGroup()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeToDismissBoxKt.rememberSwipeToDismissBoxState(androidx.compose.material3.SwipeToDismissBoxValue, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.SwipeToDismissBoxState");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use SwipeToDismissBox instead", replaceWith = @kotlin.ReplaceWith(expression = "SwipeToDismissBox(state, background, modifier, enableDismissFromStartToEnd, enableDismissFromEndToStart, dismissContent)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwipeToDismiss(androidx.compose.material3.SwipeToDismissBoxState r17, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, java.util.Set<? extends androidx.compose.material3.SwipeToDismissBoxValue> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r6 = r23
            r0 = -539317584(0xffffffffdfdaaab0, float:-3.15132E19)
            r1 = r22
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(SwipeToDismiss)P(4!1,2,3)261@10010L295:SwipeToDismissBox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r24 & 1
            r3 = 2
            if (r2 == 0) goto L_0x001b
            r2 = r6 | 6
            r4 = r2
            r2 = r17
            goto L_0x002f
        L_0x001b:
            r2 = r6 & 6
            if (r2 != 0) goto L_0x002c
            r2 = r17
            boolean r4 = r1.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = r3
        L_0x002a:
            r4 = r4 | r6
            goto L_0x002f
        L_0x002c:
            r2 = r17
            r4 = r6
        L_0x002f:
            r5 = r24 & 2
            if (r5 == 0) goto L_0x0036
            r4 = r4 | 48
            goto L_0x0049
        L_0x0036:
            r5 = r6 & 48
            if (r5 != 0) goto L_0x0049
            r5 = r18
            boolean r7 = r1.changedInstance(r5)
            if (r7 == 0) goto L_0x0045
            r7 = 32
            goto L_0x0047
        L_0x0045:
            r7 = 16
        L_0x0047:
            r4 = r4 | r7
            goto L_0x004b
        L_0x0049:
            r5 = r18
        L_0x004b:
            r7 = r24 & 4
            if (r7 == 0) goto L_0x0054
            r4 = r4 | 384(0x180, float:5.38E-43)
            r15 = r19
            goto L_0x0066
        L_0x0054:
            r7 = r6 & 384(0x180, float:5.38E-43)
            r15 = r19
            if (r7 != 0) goto L_0x0066
            boolean r7 = r1.changedInstance(r15)
            if (r7 == 0) goto L_0x0063
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r4 = r4 | r7
        L_0x0066:
            r7 = r24 & 8
            if (r7 == 0) goto L_0x006d
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r8 = r6 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0080
            r8 = r20
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007c
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r4 = r4 | r9
            goto L_0x0082
        L_0x0080:
            r8 = r20
        L_0x0082:
            r9 = r24 & 16
            if (r9 == 0) goto L_0x0089
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0089:
            r10 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009c
            r10 = r21
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x0098
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r4 = r4 | r11
            goto L_0x009e
        L_0x009c:
            r10 = r21
        L_0x009e:
            r11 = r4 & 9363(0x2493, float:1.312E-41)
            r12 = 9362(0x2492, float:1.3119E-41)
            if (r11 != r12) goto L_0x00b0
            boolean r11 = r1.getSkipping()
            if (r11 != 0) goto L_0x00ab
            goto L_0x00b0
        L_0x00ab:
            r1.skipToGroupEnd()
            r4 = r8
            goto L_0x010f
        L_0x00b0:
            if (r7 == 0) goto L_0x00b9
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r16 = r7
            goto L_0x00bb
        L_0x00b9:
            r16 = r8
        L_0x00bb:
            if (r9 == 0) goto L_0x00ce
            androidx.compose.material3.SwipeToDismissBoxValue[] r3 = new androidx.compose.material3.SwipeToDismissBoxValue[r3]
            r7 = 0
            androidx.compose.material3.SwipeToDismissBoxValue r8 = androidx.compose.material3.SwipeToDismissBoxValue.EndToStart
            r3[r7] = r8
            androidx.compose.material3.SwipeToDismissBoxValue r7 = androidx.compose.material3.SwipeToDismissBoxValue.StartToEnd
            r8 = 1
            r3[r8] = r7
            java.util.Set r3 = kotlin.collections.SetsKt.setOf(r3)
            goto L_0x00cf
        L_0x00ce:
            r3 = r10
        L_0x00cf:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00db
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.SwipeToDismiss (SwipeToDismissBox.kt:261)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r7, r8)
        L_0x00db:
            androidx.compose.material3.SwipeToDismissBoxValue r0 = androidx.compose.material3.SwipeToDismissBoxValue.StartToEnd
            boolean r10 = r3.contains(r0)
            androidx.compose.material3.SwipeToDismissBoxValue r0 = androidx.compose.material3.SwipeToDismissBoxValue.EndToStart
            boolean r11 = r3.contains(r0)
            r0 = r4 & 126(0x7e, float:1.77E-43)
            int r7 = r4 >> 3
            r7 = r7 & 896(0x380, float:1.256E-42)
            r0 = r0 | r7
            int r4 = r4 << 9
            r7 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r7
            r14 = r0 | r4
            r0 = 0
            r7 = r17
            r8 = r18
            r9 = r16
            r12 = r19
            r13 = r1
            r15 = r0
            SwipeToDismissBox(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x010c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010c:
            r10 = r3
            r4 = r16
        L_0x010f:
            androidx.compose.runtime.ScopeUpdateScope r8 = r1.endRestartGroup()
            if (r8 == 0) goto L_0x012b
            androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismiss$1 r9 = new androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismiss$1
            r0 = r9
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r10
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x012b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeToDismissBoxKt.SwipeToDismiss(androidx.compose.material3.SwipeToDismissBoxState, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, java.util.Set, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwipeToDismissBox(androidx.compose.material3.SwipeToDismissBoxState r20, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.ui.Modifier r22, boolean r23, boolean r24, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r1 = r20
            r2 = r21
            r6 = r25
            r7 = r27
            r0 = -955454127(0xffffffffc70ced51, float:-36077.316)
            r3 = r26
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(SwipeToDismissBox)P(5!1,4,3,2)293@11383L7,295@11419L703:SwipeToDismissBox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r28 & 1
            if (r4 == 0) goto L_0x001d
            r4 = r7 | 6
            goto L_0x002d
        L_0x001d:
            r4 = r7 & 6
            if (r4 != 0) goto L_0x002c
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = 2
        L_0x002a:
            r4 = r4 | r7
            goto L_0x002d
        L_0x002c:
            r4 = r7
        L_0x002d:
            r5 = r28 & 2
            if (r5 == 0) goto L_0x0034
            r4 = r4 | 48
            goto L_0x0044
        L_0x0034:
            r5 = r7 & 48
            if (r5 != 0) goto L_0x0044
            boolean r5 = r3.changedInstance(r2)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r4 = r4 | r5
        L_0x0044:
            r5 = r28 & 4
            if (r5 == 0) goto L_0x004b
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r8 = r7 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x005e
            r8 = r22
            boolean r9 = r3.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005a
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r4 = r4 | r9
            goto L_0x0060
        L_0x005e:
            r8 = r22
        L_0x0060:
            r9 = r28 & 8
            if (r9 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r10 = r7 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007a
            r10 = r23
            boolean r11 = r3.changed((boolean) r10)
            if (r11 == 0) goto L_0x0076
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r11
            goto L_0x007c
        L_0x007a:
            r10 = r23
        L_0x007c:
            r11 = r28 & 16
            if (r11 == 0) goto L_0x0083
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0083:
            r12 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0096
            r12 = r24
            boolean r13 = r3.changed((boolean) r12)
            if (r13 == 0) goto L_0x0092
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r4 = r4 | r13
            goto L_0x0098
        L_0x0096:
            r12 = r24
        L_0x0098:
            r13 = r28 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a0
            r4 = r4 | r14
            goto L_0x00b0
        L_0x00a0:
            r13 = r7 & r14
            if (r13 != 0) goto L_0x00b0
            boolean r13 = r3.changedInstance(r6)
            if (r13 == 0) goto L_0x00ad
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r4 = r4 | r13
        L_0x00b0:
            r13 = 74899(0x12493, float:1.04956E-40)
            r13 = r13 & r4
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00c7
            boolean r13 = r3.getSkipping()
            if (r13 != 0) goto L_0x00c0
            goto L_0x00c7
        L_0x00c0:
            r3.skipToGroupEnd()
            r4 = r10
            r5 = r12
            goto L_0x03a1
        L_0x00c7:
            if (r5 == 0) goto L_0x00ce
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r8 = r5
        L_0x00ce:
            r5 = 1
            if (r9 == 0) goto L_0x00d2
            r10 = r5
        L_0x00d2:
            if (r11 == 0) goto L_0x00d6
            r9 = r5
            goto L_0x00d7
        L_0x00d6:
            r9 = r12
        L_0x00d7:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x00e3
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:292)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r11, r12)
        L_0x00e3:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r11, r12)
            java.lang.Object r0 = r3.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r11 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r15 = 0
            if (r0 != r11) goto L_0x0100
            r16 = r5
            goto L_0x0102
        L_0x0100:
            r16 = r15
        L_0x0102:
            androidx.compose.material3.AnchoredDraggableState r13 = r20.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r14 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.material3.SwipeToDismissBoxValue r0 = r20.getCurrentValue()
            androidx.compose.material3.SwipeToDismissBoxValue r11 = androidx.compose.material3.SwipeToDismissBoxValue.Settled
            if (r0 != r11) goto L_0x0112
            r0 = r5
            goto L_0x0113
        L_0x0112:
            r0 = r15
        L_0x0113:
            r18 = 16
            r19 = 0
            r17 = 0
            r12 = r8
            r11 = r15
            r15 = r0
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.AnchoredDraggableKt.anchoredDraggable$default(r12, r13, r14, r15, r16, r17, r18, r19)
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r3.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r12)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getTopStart()
            r13 = 48
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r5, r3, r13)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r12)
            java.lang.String r13 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r13)
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r11)
            androidx.compose.runtime.CompositionLocalMap r15 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r11 = r3.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x015f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x015f:
            r3.startReusableNode()
            boolean r11 = r3.getInserting()
            if (r11 == 0) goto L_0x016c
            r3.createNode(r12)
            goto L_0x016f
        L_0x016c:
            r3.useNode()
        L_0x016f:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m3282constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r11, r5, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r11, r15, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            boolean r12 = r11.getInserting()
            if (r12 != 0) goto L_0x019f
            java.lang.Object r12 = r11.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r14)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r15)
            if (r12 != 0) goto L_0x01ad
        L_0x019f:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r14)
            r11.updateRememberedValue(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r14)
            r11.apply(r12, r5)
        L_0x01ad:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r5)
            r11 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r0.invoke(r5, r3, r12)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r0)
            r5 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r11 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r5, r11)
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r5 = (androidx.compose.foundation.layout.BoxScope) r5
            r11 = 1536819819(0x5b9a026b, float:8.669961E16)
            java.lang.String r12 = "C305@11773L105,309@11887L229:SwipeToDismissBox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r11, r12)
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            androidx.compose.ui.Modifier r5 = r5.matchParentSize(r11)
            int r11 = r4 << 6
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r12 = 693286680(0x2952b718, float:4.6788176E-14)
            r3.startReplaceableGroup(r12)
            java.lang.String r14 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r14)
            androidx.compose.foundation.layout.Arrangement r15 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r15 = r15.getStart()
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r12 = r17.getTop()
            r0 = 0
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r15, r12, r3, r0)
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r13)
            int r15 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r0)
            androidx.compose.runtime.CompositionLocalMap r0 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r5)
            r26 = r8
            androidx.compose.runtime.Applier r8 = r3.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0227
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0227:
            r3.startReusableNode()
            boolean r8 = r3.getInserting()
            if (r8 == 0) goto L_0x0234
            r3.createNode(r7)
            goto L_0x0237
        L_0x0234:
            r3.useNode()
        L_0x0237:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3282constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r12, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r0, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r8 = r7.getInserting()
            if (r8 != 0) goto L_0x0267
            java.lang.Object r8 = r7.rememberedValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r15)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r12)
            if (r8 != 0) goto L_0x0275
        L_0x0267:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r15)
            r7.updateRememberedValue(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r15)
            r7.apply(r8, r0)
        L_0x0275:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r0)
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r5.invoke(r0, r3, r8)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r0)
            r0 = -326681643(0xffffffffec873bd5, float:-1.3079003E27)
            java.lang.String r5 = "C92@4661L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r5)
            androidx.compose.foundation.layout.RowScopeInstance r7 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r8 = r11 >> 6
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | 6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2.invoke(r7, r3, r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            androidx.compose.ui.Modifier r7 = swipeToDismissBoxAnchors(r7, r1, r10, r9)
            int r4 = r4 >> 6
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r8 = 693286680(0x2952b718, float:4.6788176E-14)
            r3.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r14)
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r8.getStart()
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r11 = r11.getTop()
            r12 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r8, r11, r3, r12)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r13)
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r12)
            androidx.compose.runtime.CompositionLocalMap r12 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r7)
            androidx.compose.runtime.Applier r14 = r3.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x02fd
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02fd:
            r3.startReusableNode()
            boolean r14 = r3.getInserting()
            if (r14 == 0) goto L_0x030a
            r3.createNode(r13)
            goto L_0x030d
        L_0x030a:
            r3.useNode()
        L_0x030d:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m3282constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r13, r8, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r13, r12, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetCompositeKeyHash()
            boolean r12 = r13.getInserting()
            if (r12 != 0) goto L_0x033d
            java.lang.Object r12 = r13.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 != 0) goto L_0x034b
        L_0x033d:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r13.updateRememberedValue(r12)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r13.apply(r11, r8)
        L_0x034b:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r8)
            r11 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7.invoke(r8, r3, r11)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r5)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r4 = r4 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | 6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.invoke(r0, r3, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x039d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x039d:
            r8 = r26
            r5 = r9
            r4 = r10
        L_0x03a1:
            androidx.compose.runtime.ScopeUpdateScope r9 = r3.endRestartGroup()
            if (r9 == 0) goto L_0x03bd
            androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$2 r10 = new androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$2
            r0 = r10
            r1 = r20
            r2 = r21
            r3 = r8
            r6 = r25
            r7 = r27
            r8 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x03bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeToDismissBoxKt.SwipeToDismissBox(androidx.compose.material3.SwipeToDismissBoxState, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Modifier swipeToDismissBoxAnchors(Modifier modifier, SwipeToDismissBoxState swipeToDismissBoxState, boolean z, boolean z2) {
        return modifier.then(new SwipeToDismissAnchorsElement(swipeToDismissBoxState, z, z2));
    }
}
