package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002\u001a2\u0010\u001e\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002\u001a\u000e\u0010\"\u001a\u00020\u001b*\u0004\u0018\u00010#H\u0002\u001a\f\u0010$\u001a\u00020\u001b*\u00020\u0012H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006%²\u0006\f\u0010&\u001a\u0004\u0018\u00010#X\u0002²\u0006\n\u0010'\u001a\u00020\u0019X\u0002²\u0006\n\u0010(\u001a\u00020\u0019X\u0002"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "Lkotlin/Function0;", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/geometry/Rect;", "anchorBounds", "verticalMargin", "expandable", "expandedDescription", "", "collapsedDescription", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getWindowBounds", "material3_release", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public final class ExposedDropdownMenu_androidKt {
    /* access modifiers changed from: private */
    public static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m6614constructorimpl((float) 16);

    /* JADX WARNING: Removed duplicated region for block: B:114:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuBox(boolean r25, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function3<? super androidx.compose.material3.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r11 = r25
            r12 = r28
            r13 = r30
            r0 = 2067579792(0x7b3cc390, float:9.801183E35)
            r1 = r29
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ExposedDropdownMenuBox)P(1,3,2)116@5545L7,117@5578L7,118@5617L7,122@5730L53,123@5807L33,124@5866L33,126@5926L29,127@5986L31,128@6049L32,130@6099L1761,166@7866L45,180@8254L59,180@8243L70:ExposedDropdownMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r31 & 1
            r2 = 2
            if (r1 == 0) goto L_0x001c
            r1 = r13 | 6
            goto L_0x002c
        L_0x001c:
            r1 = r13 & 6
            if (r1 != 0) goto L_0x002b
            boolean r1 = r14.changed((boolean) r11)
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0028:
            r1 = r2
        L_0x0029:
            r1 = r1 | r13
            goto L_0x002c
        L_0x002b:
            r1 = r13
        L_0x002c:
            r3 = r31 & 2
            if (r3 == 0) goto L_0x0035
            r1 = r1 | 48
            r10 = r26
            goto L_0x0047
        L_0x0035:
            r3 = r13 & 48
            r10 = r26
            if (r3 != 0) goto L_0x0047
            boolean r3 = r14.changedInstance(r10)
            if (r3 == 0) goto L_0x0044
            r3 = 32
            goto L_0x0046
        L_0x0044:
            r3 = 16
        L_0x0046:
            r1 = r1 | r3
        L_0x0047:
            r3 = r31 & 4
            if (r3 == 0) goto L_0x004e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r5 = r13 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0061
            r5 = r27
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r6
            goto L_0x0063
        L_0x0061:
            r5 = r27
        L_0x0063:
            r6 = r31 & 8
            if (r6 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x006a:
            r6 = r13 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007a
            boolean r6 = r14.changedInstance(r12)
            if (r6 == 0) goto L_0x0077
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r6
        L_0x007a:
            r9 = r1
            r1 = r9 & 1171(0x493, float:1.641E-42)
            r6 = 1170(0x492, float:1.64E-42)
            if (r1 != r6) goto L_0x008e
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0088
            goto L_0x008e
        L_0x0088:
            r14.skipToGroupEnd()
            r3 = r5
            goto L_0x0376
        L_0x008e:
            if (r3 == 0) goto L_0x0097
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x0099
        L_0x0097:
            r16 = r5
        L_0x0099:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a5
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:115)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r1, r3)
        L_0x00a5:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalConfiguration()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r3)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            android.content.res.Configuration r0 = (android.content.res.Configuration) r0
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r3)
            java.lang.Object r5 = r14.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r8 = r5
            android.view.View r8 = (android.view.View) r8
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r3)
            java.lang.Object r1 = r14.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r7 = r1
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            float r1 = androidx.compose.material3.MenuKt.getMenuVerticalMargin()
            int r6 = r7.m6545roundToPx0680j_4(r1)
            r1 = 983580452(0x3aa03f24, float:0.0012225849)
            r14.startReplaceableGroup(r1)
            java.lang.String r5 = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r1 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r1 != r3) goto L_0x0109
            r1 = 0
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r1, r2, r1)
            r14.updateRememberedValue(r1)
        L_0x0109:
            r3 = r1
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r14.endReplaceableGroup()
            r1 = 983580529(0x3aa03f71, float:0.0012225938)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r1 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            r4 = 0
            if (r1 != r2) goto L_0x012c
            androidx.compose.runtime.MutableIntState r1 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r4)
            r14.updateRememberedValue(r1)
        L_0x012c:
            r17 = r1
            androidx.compose.runtime.MutableIntState r17 = (androidx.compose.runtime.MutableIntState) r17
            r14.endReplaceableGroup()
            r1 = 983580588(0x3aa03fac, float:0.0012226007)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r1 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x014f
            androidx.compose.runtime.MutableIntState r1 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r4)
            r14.updateRememberedValue(r1)
        L_0x014f:
            r2 = r1
            androidx.compose.runtime.MutableIntState r2 = (androidx.compose.runtime.MutableIntState) r2
            r14.endReplaceableGroup()
            r1 = 983580648(0x3aa03fe8, float:0.0012226077)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r1 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r18.getEmpty()
            if (r1 != r15) goto L_0x0172
            androidx.compose.ui.focus.FocusRequester r1 = new androidx.compose.ui.focus.FocusRequester
            r1.<init>()
            r14.updateRememberedValue(r1)
        L_0x0172:
            r15 = r1
            androidx.compose.ui.focus.FocusRequester r15 = (androidx.compose.ui.focus.FocusRequester) r15
            r14.endReplaceableGroup()
            androidx.compose.material3.Strings$Companion r1 = androidx.compose.material3.Strings.Companion
            int r1 = androidx.compose.material3.R.string.m3c_dropdown_menu_expanded
            int r1 = androidx.compose.material3.Strings.m2224constructorimpl(r1)
            java.lang.String r18 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r1, r14, r4)
            androidx.compose.material3.Strings$Companion r1 = androidx.compose.material3.Strings.Companion
            int r1 = androidx.compose.material3.R.string.m3c_dropdown_menu_collapsed
            int r1 = androidx.compose.material3.Strings.m2224constructorimpl(r1)
            java.lang.String r19 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r1, r14, r4)
            r1 = 983580821(0x3aa04095, float:0.0012226278)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            r1 = r9 & 14
            r20 = 1
            r4 = 4
            if (r1 != r4) goto L_0x01a3
            r4 = r20
            goto L_0x01a4
        L_0x01a3:
            r4 = 0
        L_0x01a4:
            r21 = r1
            r1 = r9 & 112(0x70, float:1.57E-43)
            r22 = r2
            r2 = 32
            if (r1 != r2) goto L_0x01b1
            r1 = r20
            goto L_0x01b2
        L_0x01b1:
            r1 = 0
        L_0x01b2:
            r1 = r1 | r4
            boolean r0 = r14.changed((java.lang.Object) r0)
            r0 = r0 | r1
            boolean r1 = r14.changed((java.lang.Object) r8)
            r0 = r0 | r1
            boolean r1 = r14.changed((java.lang.Object) r7)
            r0 = r0 | r1
            java.lang.Object r1 = r14.rememberedValue()
            if (r0 != 0) goto L_0x01e1
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x01d1
            goto L_0x01e1
        L_0x01d1:
            r18 = r3
            r23 = r7
            r24 = r8
            r17 = r9
            r19 = r15
            r29 = r22
            r15 = r5
            r22 = r6
            goto L_0x0210
        L_0x01e1:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 r4 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
            r0 = r4
            r2 = r21
            r1 = r25
            r13 = r2
            r29 = r22
            r2 = r18
            r18 = r3
            r3 = r19
            r21 = r13
            r13 = r4
            r4 = r15
            r19 = r15
            r15 = r5
            r5 = r8
            r22 = r6
            r23 = r7
            r7 = r18
            r24 = r8
            r8 = r17
            r17 = r9
            r9 = r29
            r10 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.updateRememberedValue(r13)
            r1 = r13
        L_0x0210:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 r1 = (androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) r1
            r14.endReplaceableGroup()
            int r0 = r17 >> 6
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r3 = 0
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r3, r14, r3)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r14.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r16)
            androidx.compose.runtime.Applier r7 = r14.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0255
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0255:
            r14.startReusableNode()
            boolean r7 = r14.getInserting()
            if (r7 == 0) goto L_0x0262
            r14.createNode(r5)
            goto L_0x0265
        L_0x0262:
            r14.useNode()
        L_0x0265:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3282constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r3 = r5.getInserting()
            if (r3 != 0) goto L_0x0295
            java.lang.Object r3 = r5.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r3 != 0) goto L_0x02a3
        L_0x0295:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r5.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r5.apply(r3, r2)
        L_0x02a3:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r2)
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r6.invoke(r2, r14, r4)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r2)
            r2 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r3 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r2, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r2 = 1004943029(0x3be636b5, float:0.0070255646)
            java.lang.String r3 = "C167@7896L9:ExposedDropdownMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r2, r3)
            r0 = r0 & 112(0x70, float:1.57E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r12.invoke(r1, r14, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r14.endReplaceableGroup()
            r14.endNode()
            r14.endReplaceableGroup()
            r14.endReplaceableGroup()
            r0 = 983582639(0x3aa047af, float:0.0012228395)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "171@7977L254,171@7941L290"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            if (r11 == 0) goto L_0x0333
            r0 = 983582699(0x3aa047eb, float:0.0012228464)
            r14.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            r5 = r24
            boolean r0 = r14.changedInstance(r5)
            r1 = r22
            boolean r2 = r14.changed((int) r1)
            r0 = r0 | r2
            java.lang.Object r2 = r14.rememberedValue()
            if (r0 != 0) goto L_0x0319
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0328
        L_0x0319:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1 r0 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1
            r3 = r29
            r2 = r18
            r0.<init>(r5, r1, r2, r3)
            r2 = r0
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.updateRememberedValue(r2)
        L_0x0328:
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.endReplaceableGroup()
            r1 = r23
            r0 = 0
            SoftKeyboardListener(r5, r1, r2, r14, r0)
        L_0x0333:
            r14.endReplaceableGroup()
            r0 = 983582976(0x3aa04900, float:0.0012228787)
            r14.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            r0 = r21
            r1 = 4
            if (r0 != r1) goto L_0x0347
            r4 = r20
            goto L_0x0348
        L_0x0347:
            r4 = 0
        L_0x0348:
            java.lang.Object r0 = r14.rememberedValue()
            if (r4 != 0) goto L_0x0356
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0362
        L_0x0356:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1 r0 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1
            r1 = r19
            r0.<init>(r11, r1)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r14.updateRememberedValue(r0)
        L_0x0362:
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r14.endReplaceableGroup()
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r14, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0374
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0374:
            r3 = r16
        L_0x0376:
            androidx.compose.runtime.ScopeUpdateScope r7 = r14.endRestartGroup()
            if (r7 == 0) goto L_0x0391
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4 r8 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4
            r0 = r8
            r1 = r25
            r2 = r26
            r4 = r28
            r5 = r30
            r6 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x0391:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return (LayoutCoordinates) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* access modifiers changed from: private */
    public static final void SoftKeyboardListener(View view, Density density, Function0<Unit> function0, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1319522472);
        ComposerKt.sourceInformation(startRestartGroup, "C(SoftKeyboardListener)P(2)193@8669L1413,193@8637L1445:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(view) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) density) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319522472, i2, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:190)");
            }
            startRestartGroup.startReplaceableGroup(-491766155);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(view) | ((i2 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1(view, function0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(view, density, (Function1) rememberedValue, startRestartGroup, i2 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenu_androidKt$SoftKeyboardListener$2(view, density, function0, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Modifier expandable(Modifier modifier, boolean z, Function0<Unit> function0, String str, String str2) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new ExposedDropdownMenu_androidKt$expandable$1(function0, (Continuation<? super ExposedDropdownMenu_androidKt$expandable$1>) null)), false, new ExposedDropdownMenu_androidKt$expandable$2(z, str, str2, function0), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final int calculateMaxHeight(Rect rect, Rect rect2, int i) {
        int i2;
        if (rect2 == null) {
            return 0;
        }
        float f = (float) i;
        float top = rect.getTop() + f;
        float bottom = rect.getBottom() - f;
        if (rect2.getTop() > rect.getBottom() || rect2.getBottom() < rect.getTop()) {
            i2 = MathKt.roundToInt(bottom - top);
        } else {
            i2 = MathKt.roundToInt(Math.max(rect2.getTop() - top, bottom - rect2.getBottom()));
        }
        return Math.max(i2, 0);
    }

    /* access modifiers changed from: private */
    public static final Rect getWindowBounds(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.toComposeRect(rect);
    }

    /* access modifiers changed from: private */
    public static final Rect getAnchorBounds(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates == null ? Rect.Companion.getZero() : RectKt.m3602Recttz77jQw(LayoutCoordinatesKt.positionInWindow(layoutCoordinates), IntSizeKt.m6800toSizeozmzZPI(layoutCoordinates.m5318getSizeYbymL2g()));
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$3(MutableState<LayoutCoordinates> mutableState, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$6(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$9(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }
}
