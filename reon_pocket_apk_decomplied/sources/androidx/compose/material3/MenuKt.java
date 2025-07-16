package androidx.compose.material3;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001aY\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010\u001e\u001a\u0001\u0010\u001f\u001a\u00020\u000e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000e0!¢\u0006\u0002\b\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0!2\u0006\u0010\u0017\u001a\u00020\u00182\u0013\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010!¢\u0006\u0002\b\u001c2\u0013\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010!¢\u0006\u0002\b\u001c2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\u0010,\u001a\u001d\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0002\u00101\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0016\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\"\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u00062²\u0006\n\u00103\u001a\u000204X\u0002²\u0006\n\u00105\u001a\u000204X\u0002"}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material3_release", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m6614constructorimpl((float) 280);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m6614constructorimpl((float) 112);
    /* access modifiers changed from: private */
    public static final float DropdownMenuItemHorizontalPadding = Dp.m6614constructorimpl((float) 12);
    private static final float DropdownMenuVerticalPadding = Dp.m6614constructorimpl((float) 8);
    public static final int InTransitionDuration = 120;
    private static final float MenuVerticalMargin = Dp.m6614constructorimpl((float) 48);
    public static final int OutTransitionDuration = 75;

    /* JADX WARNING: Removed duplicated region for block: B:117:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuContent(androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r23, androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.TransformOrigin> r24, androidx.compose.foundation.ScrollState r25, androidx.compose.ui.Modifier r26, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r1 = r23
            r2 = r24
            r3 = r25
            r5 = r27
            r6 = r29
            r0 = -1289304092(0xffffffffb326c7e4, float:-3.8831686E-8)
            r4 = r28
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r0)
            java.lang.String r7 = "C(DropdownMenuContent)P(1,4,3,2)235@9967L47,237@10044L569,257@10643L380,272@11080L153,278@11277L5,279@11314L11,271@11029L701:Menu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            r7 = r30 & 1
            if (r7 == 0) goto L_0x001f
            r7 = r6 | 6
            goto L_0x0038
        L_0x001f:
            r7 = r6 & 6
            if (r7 != 0) goto L_0x0037
            r7 = r6 & 8
            if (r7 != 0) goto L_0x002c
            boolean r7 = r4.changed((java.lang.Object) r1)
            goto L_0x0030
        L_0x002c:
            boolean r7 = r4.changedInstance(r1)
        L_0x0030:
            if (r7 == 0) goto L_0x0034
            r7 = 4
            goto L_0x0035
        L_0x0034:
            r7 = 2
        L_0x0035:
            r7 = r7 | r6
            goto L_0x0038
        L_0x0037:
            r7 = r6
        L_0x0038:
            r8 = r30 & 2
            if (r8 == 0) goto L_0x003f
            r7 = r7 | 48
            goto L_0x004f
        L_0x003f:
            r8 = r6 & 48
            if (r8 != 0) goto L_0x004f
            boolean r8 = r4.changed((java.lang.Object) r2)
            if (r8 == 0) goto L_0x004c
            r8 = 32
            goto L_0x004e
        L_0x004c:
            r8 = 16
        L_0x004e:
            r7 = r7 | r8
        L_0x004f:
            r8 = r30 & 4
            if (r8 == 0) goto L_0x0056
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0056:
            r8 = r6 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0066
            boolean r8 = r4.changed((java.lang.Object) r3)
            if (r8 == 0) goto L_0x0063
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r7 = r7 | r8
        L_0x0066:
            r8 = r30 & 8
            if (r8 == 0) goto L_0x006d
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r9 = r6 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0080
            r9 = r26
            boolean r10 = r4.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x007c
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r7 = r7 | r10
            goto L_0x0082
        L_0x0080:
            r9 = r26
        L_0x0082:
            r10 = r30 & 16
            if (r10 == 0) goto L_0x0089
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0089:
            r10 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0099
            boolean r10 = r4.changedInstance(r5)
            if (r10 == 0) goto L_0x0096
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r7 = r7 | r10
        L_0x0099:
            r14 = r7
            r7 = r14 & 9363(0x2493, float:1.312E-41)
            r10 = 9362(0x2492, float:1.3119E-41)
            if (r7 != r10) goto L_0x00ac
            boolean r7 = r4.getSkipping()
            if (r7 != 0) goto L_0x00a7
            goto L_0x00ac
        L_0x00a7:
            r4.skipToGroupEnd()
            goto L_0x02c6
        L_0x00ac:
            if (r8 == 0) goto L_0x00b4
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r13 = r7
            goto L_0x00b5
        L_0x00b4:
            r13 = r9
        L_0x00b5:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r12 = -1
            if (r7 == 0) goto L_0x00c1
            java.lang.String r7 = "androidx.compose.material3.DropdownMenuContent (Menu.kt:232)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r12, r7)
        L_0x00c1:
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            r0 = r0 | 48
            r7 = r14 & 14
            r0 = r0 | r7
            java.lang.String r7 = "DropDownMenu"
            r11 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r7, (androidx.compose.runtime.Composer) r4, (int) r0, (int) r11)
            androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2 r7 = androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2.INSTANCE
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            r10 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r4.startReplaceableGroup(r10)
            java.lang.String r9 = "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            kotlin.jvm.internal.FloatCompanionObject r8 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r16 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r8)
            r8 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r4.startReplaceableGroup(r8)
            java.lang.String r15 = "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r15)
            java.lang.Object r17 = r0.getCurrentState()
            java.lang.Boolean r17 = (java.lang.Boolean) r17
            boolean r17 = r17.booleanValue()
            r8 = 2092995144(0x7cc09248, float:7.9991035E36)
            r4.startReplaceableGroup(r8)
            r18 = r14
            java.lang.String r14 = "C:Menu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r14)
            boolean r19 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r19 == 0) goto L_0x0111
            java.lang.String r10 = "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:254)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r11, r12, r10)
        L_0x0111:
            r20 = 1065353216(0x3f800000, float:1.0)
            if (r17 == 0) goto L_0x0118
            r10 = r20
            goto L_0x011b
        L_0x0118:
            r10 = 1061997773(0x3f4ccccd, float:0.8)
        L_0x011b:
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x0124
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0124:
            r4.endReplaceableGroup()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.Object r17 = r0.getTargetState()
            java.lang.Boolean r17 = (java.lang.Boolean) r17
            boolean r17 = r17.booleanValue()
            r4.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r14)
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r21 == 0) goto L_0x0146
            java.lang.String r1 = "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:254)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r11, r12, r1)
        L_0x0146:
            if (r17 == 0) goto L_0x014b
            r1 = r20
            goto L_0x014e
        L_0x014b:
            r1 = 1061997773(0x3f4ccccd, float:0.8)
        L_0x014e:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0157
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0157:
            r4.endReplaceableGroup()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.animation.core.Transition$Segment r8 = r0.getSegment()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            java.lang.Object r7 = r7.invoke(r8, r4, r12)
            r12 = r7
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            java.lang.String r21 = "FloatAnimation"
            r22 = 0
            r7 = r0
            r8 = r10
            r10 = r9
            r9 = r1
            r1 = r10
            r10 = r12
            r12 = r11
            r11 = r16
            r12 = r21
            r6 = r13
            r13 = r4
            r3 = r14
            r16 = r18
            r14 = r22
            androidx.compose.runtime.State r14 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r7, r8, r9, r10, r11, r12, r13, r14)
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2 r7 = androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2.INSTANCE
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            r8 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r4.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r1)
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r11 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r1 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r4.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r15)
            java.lang.Object r1 = r0.getCurrentState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r8 = 1546829492(0x5c32beb4, float:2.01248905E17)
            r4.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r3)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01ca
            java.lang.String r9 = "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:268)"
            r10 = -1
            r15 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r15, r10, r9)
            goto L_0x01cc
        L_0x01ca:
            r10 = -1
            r15 = 0
        L_0x01cc:
            if (r1 == 0) goto L_0x01d1
            r1 = r20
            goto L_0x01d2
        L_0x01d1:
            r1 = 0
        L_0x01d2:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01db
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01db:
            r4.endReplaceableGroup()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Object r9 = r0.getTargetState()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r4.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01fd
            java.lang.String r3 = "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:268)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r15, r10, r3)
        L_0x01fd:
            if (r9 == 0) goto L_0x0200
            goto L_0x0202
        L_0x0200:
            r20 = 0
        L_0x0202:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x020b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x020b:
            r4.endReplaceableGroup()
            java.lang.Float r9 = java.lang.Float.valueOf(r20)
            androidx.compose.animation.core.Transition$Segment r3 = r0.getSegment()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r15)
            java.lang.Object r3 = r7.invoke(r3, r4, r8)
            r10 = r3
            androidx.compose.animation.core.FiniteAnimationSpec r10 = (androidx.compose.animation.core.FiniteAnimationSpec) r10
            java.lang.String r12 = "FloatAnimation"
            r7 = r0
            r8 = r1
            r13 = r4
            r0 = r14
            r14 = r22
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r7, r8, r9, r10, r11, r12, r13, r14)
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r7 = 1402453378(0x5397bd82, float:1.30343895E12)
            r4.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Menu.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            boolean r7 = r4.changed((java.lang.Object) r0)
            boolean r8 = r4.changed((java.lang.Object) r1)
            r7 = r7 | r8
            r8 = r16 & 112(0x70, float:1.57E-43)
            r11 = 1
            r9 = 32
            if (r8 != r9) goto L_0x0253
            r15 = r11
        L_0x0253:
            r7 = r7 | r15
            java.lang.Object r8 = r4.rememberedValue()
            if (r7 != 0) goto L_0x0262
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x026d
        L_0x0262:
            androidx.compose.material3.MenuKt$DropdownMenuContent$1$1 r7 = new androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
            r7.<init>(r2, r0, r1)
            r8 = r7
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r4.updateRememberedValue(r8)
        L_0x026d:
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r4.endReplaceableGroup()
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r3, r8)
            androidx.compose.material3.tokens.MenuTokens r0 = androidx.compose.material3.tokens.MenuTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r0 = r0.getContainerShape()
            r1 = 6
            androidx.compose.ui.graphics.Shape r8 = androidx.compose.material3.ShapesKt.getValue(r0, r4, r1)
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r0 = r0.getColorScheme(r4, r1)
            androidx.compose.material3.tokens.MenuTokens r1 = androidx.compose.material3.tokens.MenuTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getContainerColor()
            long r9 = androidx.compose.material3.ColorSchemeKt.fromToken(r0, r1)
            androidx.compose.material3.tokens.MenuTokens r0 = androidx.compose.material3.tokens.MenuTokens.INSTANCE
            float r13 = r0.m2961getContainerElevationD9Ej5fM()
            androidx.compose.material3.tokens.MenuTokens r0 = androidx.compose.material3.tokens.MenuTokens.INSTANCE
            float r14 = r0.m2961getContainerElevationD9Ej5fM()
            androidx.compose.material3.MenuKt$DropdownMenuContent$2 r0 = new androidx.compose.material3.MenuKt$DropdownMenuContent$2
            r3 = r25
            r0.<init>(r6, r3, r5)
            r1 = -1266256833(0xffffffffb486743f, float:-2.5044025E-7)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r4, r1, r11, r0)
            r16 = r0
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            r18 = 12804096(0xc36000, float:1.794236E-38)
            r19 = 72
            r11 = 0
            r15 = 0
            r17 = r4
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02c5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02c5:
            r9 = r6
        L_0x02c6:
            androidx.compose.runtime.ScopeUpdateScope r8 = r4.endRestartGroup()
            if (r8 == 0) goto L_0x02e4
            androidx.compose.material3.MenuKt$DropdownMenuContent$3 r10 = new androidx.compose.material3.MenuKt$DropdownMenuContent$3
            r0 = r10
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r9
            r5 = r27
            r6 = r29
            r7 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r8.updateScope(r10)
        L_0x02e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MenuKt.DropdownMenuContent(androidx.compose.animation.core.MutableTransitionState, androidx.compose.runtime.MutableState, androidx.compose.foundation.ScrollState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void DropdownMenuItemContent(Function2<? super Composer, ? super Integer, Unit> function2, Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, int i) {
        int i2;
        PaddingValues paddingValues2 = paddingValues;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1564716777);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenuItemContent)P(7,6,5,4,8,2)312@12376L20,306@12132L2357:Menu.kt#uh7d8r");
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function24) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        Function0<Unit> function02 = function0;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        Modifier modifier2 = modifier;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier2) ? 256 : 128;
        }
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 16384 : 8192;
        }
        boolean z2 = z;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 131072 : 65536;
        }
        MenuItemColors menuItemColors2 = menuItemColors;
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) menuItemColors2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) paddingValues2) ? 8388608 : 4194304;
        }
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        if ((100663296 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564716777, i2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:304)");
            }
            Modifier padding = PaddingKt.padding(SizeKt.m746sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m246clickableO2vRcR0$default(modifier, mutableInteractionSource, RippleKt.m1491rememberRipple9IZ8Weo(true, 0.0f, 0, startRestartGroup, 6, 6), z, (String) null, (Role) null, function0, 24, (Object) null), 0.0f, 1, (Object) null), DropdownMenuItemDefaultMinWidth, MenuTokens.INSTANCE.m2962getListItemContainerHeightD9Ej5fM(), DropdownMenuItemDefaultMaxWidth, 0.0f, 8, (Object) null), paddingValues2);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r4 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r4, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1557325246, "C324@12879L10,324@12848L1635:Menu.kt#uh7d8r");
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), MenuTokens.INSTANCE.getListItemLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1065051884, true, new MenuKt$DropdownMenuItemContent$1$1(function22, menuItemColors, z, function23, RowScopeInstance.INSTANCE, function2)), startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MenuKt$DropdownMenuItemContent$2(function2, function0, modifier, function22, function23, z, menuItemColors, paddingValues, mutableInteractionSource, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long calculateTransformOrigin(androidx.compose.ui.unit.IntRect r5, androidx.compose.ui.unit.IntRect r6) {
        /*
            int r0 = r6.getLeft()
            int r1 = r5.getRight()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r0 < r1) goto L_0x000f
        L_0x000d:
            r0 = r3
            goto L_0x0049
        L_0x000f:
            int r0 = r6.getRight()
            int r1 = r5.getLeft()
            if (r0 > r1) goto L_0x001b
            r0 = r2
            goto L_0x0049
        L_0x001b:
            int r0 = r6.getWidth()
            if (r0 != 0) goto L_0x0022
            goto L_0x000d
        L_0x0022:
            int r0 = r5.getLeft()
            int r1 = r6.getLeft()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r5.getRight()
            int r4 = r6.getRight()
            int r1 = java.lang.Math.min(r1, r4)
            int r0 = r0 + r1
            int r0 = r0 / 2
            int r1 = r6.getLeft()
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.getWidth()
            float r1 = (float) r1
            float r0 = r0 / r1
        L_0x0049:
            int r1 = r6.getTop()
            int r4 = r5.getBottom()
            if (r1 < r4) goto L_0x0055
        L_0x0053:
            r2 = r3
            goto L_0x008f
        L_0x0055:
            int r1 = r6.getBottom()
            int r4 = r5.getTop()
            if (r1 > r4) goto L_0x0060
            goto L_0x008f
        L_0x0060:
            int r1 = r6.getHeight()
            if (r1 != 0) goto L_0x0067
            goto L_0x0053
        L_0x0067:
            int r1 = r5.getTop()
            int r2 = r6.getTop()
            int r1 = java.lang.Math.max(r1, r2)
            int r5 = r5.getBottom()
            int r2 = r6.getBottom()
            int r5 = java.lang.Math.min(r5, r2)
            int r1 = r1 + r5
            int r1 = r1 / 2
            int r5 = r6.getTop()
            int r1 = r1 - r5
            float r5 = (float) r1
            int r6 = r6.getHeight()
            float r6 = (float) r6
            float r2 = r5 / r6
        L_0x008f:
            long r5 = androidx.compose.ui.graphics.TransformOriginKt.TransformOrigin(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MenuKt.calculateTransformOrigin(androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect):long");
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    /* access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
