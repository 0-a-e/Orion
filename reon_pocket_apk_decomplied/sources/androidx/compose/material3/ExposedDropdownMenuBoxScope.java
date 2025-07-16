package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JU\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0006H&J\f\u0010\u0015\u001a\u00020\n*\u00020\nH&¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "()V", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "menuAnchor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    public abstract Modifier menuAnchor(Modifier modifier);

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: androidx.compose.material3.DropdownMenuPositionProvider} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: androidx.compose.material3.DropdownMenuPositionProvider} */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01b6, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x01b8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x016e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ExposedDropdownMenu(boolean r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, androidx.compose.foundation.ScrollState r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r28 = this;
            r7 = r35
            r0 = 1729549851(0x6716d61b, float:7.123045E23)
            r1 = r34
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ExposedDropdownMenu)P(1,3,2,4)266@12013L21,278@12512L42,282@12711L51,283@12802L7,284@12850L309,293@13173L489:ExposedDropdownMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r36 & 1
            r2 = 2
            if (r1 == 0) goto L_0x001a
            r1 = r7 | 6
            r9 = r29
            goto L_0x002c
        L_0x001a:
            r1 = r7 & 6
            r9 = r29
            if (r1 != 0) goto L_0x002b
            boolean r1 = r8.changed((boolean) r9)
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0028:
            r1 = r2
        L_0x0029:
            r1 = r1 | r7
            goto L_0x002c
        L_0x002b:
            r1 = r7
        L_0x002c:
            r3 = r36 & 2
            if (r3 == 0) goto L_0x0035
            r1 = r1 | 48
            r10 = r30
            goto L_0x0047
        L_0x0035:
            r3 = r7 & 48
            r10 = r30
            if (r3 != 0) goto L_0x0047
            boolean r3 = r8.changedInstance(r10)
            if (r3 == 0) goto L_0x0044
            r3 = 32
            goto L_0x0046
        L_0x0044:
            r3 = 16
        L_0x0046:
            r1 = r1 | r3
        L_0x0047:
            r3 = r36 & 4
            if (r3 == 0) goto L_0x004e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r4 = r7 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0061
            r4 = r31
            boolean r5 = r8.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005d
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r5
            goto L_0x0063
        L_0x0061:
            r4 = r31
        L_0x0063:
            r5 = r7 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007c
            r5 = r36 & 8
            if (r5 != 0) goto L_0x0076
            r5 = r32
            boolean r6 = r8.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0078
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r5 = r32
        L_0x0078:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r1 = r1 | r6
            goto L_0x007e
        L_0x007c:
            r5 = r32
        L_0x007e:
            r6 = r36 & 16
            if (r6 == 0) goto L_0x0085
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r6 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x0098
            r6 = r33
            boolean r11 = r8.changedInstance(r6)
            if (r11 == 0) goto L_0x0094
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r1 = r1 | r11
            goto L_0x009a
        L_0x0098:
            r6 = r33
        L_0x009a:
            r11 = r36 & 32
            r12 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00a4
            r1 = r1 | r12
            r15 = r28
            goto L_0x00b6
        L_0x00a4:
            r11 = r7 & r12
            r15 = r28
            if (r11 != 0) goto L_0x00b6
            boolean r11 = r8.changed((java.lang.Object) r15)
            if (r11 == 0) goto L_0x00b3
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r1 = r1 | r11
        L_0x00b6:
            r11 = 74899(0x12493, float:1.04956E-40)
            r11 = r11 & r1
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r12) goto L_0x00cb
            boolean r11 = r8.getSkipping()
            if (r11 != 0) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            r8.skipToGroupEnd()
            goto L_0x0215
        L_0x00cb:
            r8.startDefaults()
            r11 = r7 & 1
            r12 = 0
            r14 = 1
            if (r11 == 0) goto L_0x00e7
            boolean r11 = r8.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00db
            goto L_0x00e7
        L_0x00db:
            r8.skipToGroupEnd()
            r3 = r36 & 8
            if (r3 == 0) goto L_0x00e4
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00e4:
            r18 = r4
            goto L_0x0100
        L_0x00e7:
            if (r3 == 0) goto L_0x00ee
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00ef
        L_0x00ee:
            r3 = r4
        L_0x00ef:
            r4 = r36 & 8
            if (r4 == 0) goto L_0x00fe
            androidx.compose.foundation.ScrollState r4 = androidx.compose.foundation.ScrollKt.rememberScrollState(r12, r8, r12, r14)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r18 = r3
            r19 = r4
            goto L_0x0102
        L_0x00fe:
            r18 = r3
        L_0x0100:
            r19 = r5
        L_0x0102:
            r8.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0111
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:268)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r4)
        L_0x0111:
            r0 = 1950029224(0x743b15a8, float:5.9289475E31)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            java.lang.Object r3 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0134
            androidx.compose.animation.core.MutableTransitionState r3 = new androidx.compose.animation.core.MutableTransitionState
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r12)
            r3.<init>(r4)
            r8.updateRememberedValue(r3)
        L_0x0134:
            r12 = r3
            androidx.compose.animation.core.MutableTransitionState r12 = (androidx.compose.animation.core.MutableTransitionState) r12
            r8.endReplaceableGroup()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r29)
            r12.setTargetState(r3)
            java.lang.Object r3 = r12.getCurrentState()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x0159
            java.lang.Object r3 = r12.getTargetState()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0208
        L_0x0159:
            r3 = 1950029423(0x743b166f, float:5.9290437E31)
            r8.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            java.lang.Object r3 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0180
            androidx.compose.ui.graphics.TransformOrigin$Companion r3 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r3 = r3.m4269getCenterSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r3 = androidx.compose.ui.graphics.TransformOrigin.m4256boximpl(r3)
            r4 = 0
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r4, r2, r4)
            r8.updateRememberedValue(r3)
        L_0x0180:
            r13 = r3
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            r8.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r4)
            java.lang.Object r2 = r8.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r3 = 1950029562(0x743b16fa, float:5.929111E31)
            r8.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            boolean r0 = r8.changed((java.lang.Object) r2)
            java.lang.Object r3 = r8.rememberedValue()
            if (r0 != 0) goto L_0x01b8
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x01d9
        L_0x01b8:
            androidx.compose.material3.DropdownMenuPositionProvider r3 = new androidx.compose.material3.DropdownMenuPositionProvider
            androidx.compose.ui.unit.DpOffset$Companion r0 = androidx.compose.ui.unit.DpOffset.Companion
            long r21 = r0.m6685getZeroRKDOV3M()
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1 r0 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
            r0.<init>(r13)
            r25 = r0
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r26 = 4
            r27 = 0
            r24 = 0
            r20 = r3
            r23 = r2
            r20.<init>(r21, r23, r24, r25, r26, r27)
            r8.updateRememberedValue(r3)
        L_0x01d9:
            androidx.compose.material3.DropdownMenuPositionProvider r3 = (androidx.compose.material3.DropdownMenuPositionProvider) r3
            r8.endReplaceableGroup()
            r2 = r3
            androidx.compose.ui.window.PopupPositionProvider r2 = (androidx.compose.ui.window.PopupPositionProvider) r2
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 r0 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
            r11 = r0
            r3 = r14
            r14 = r19
            r15 = r28
            r16 = r18
            r17 = r33
            r11.<init>(r12, r13, r14, r15, r16, r17)
            r4 = 723773237(0x2b23e735, float:5.8230097E-13)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r4, r3, r0)
            r3 = r0
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            int r0 = r1 >> 3
            r0 = r0 & 14
            r5 = r0 | 384(0x180, float:5.38E-43)
            r0 = 0
            r1 = r30
            r4 = r8
            r6 = r0
            androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(r1, r2, r3, r4, r5, r6)
        L_0x0208:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0211
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0211:
            r4 = r18
            r5 = r19
        L_0x0215:
            androidx.compose.runtime.ScopeUpdateScope r11 = r8.endRestartGroup()
            if (r11 == 0) goto L_0x0232
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2 r12 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2
            r0 = r12
            r1 = r28
            r2 = r29
            r3 = r30
            r6 = r33
            r7 = r35
            r8 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0232:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
