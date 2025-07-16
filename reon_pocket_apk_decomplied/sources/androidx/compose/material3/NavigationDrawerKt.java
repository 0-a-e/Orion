package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001al\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aQ\u0010\u001b\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\"\u001aj\u0010#\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001al\u0010&\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001a\u001a`\u0010(\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0001\u0010,\u001a\u00020\t2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\u0006\u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d¢\u0006\u0002\b\u00172\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001al\u00108\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010\u001a\u001a=\u0010:\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010;\u001a>\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020!2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010@\u001a\u00020\u000fH\u0003ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a \u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0002\u001a+\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020I2\u0014\b\u0002\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020!0\u0015H\u0007¢\u0006\u0002\u0010K\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002XD¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "drawerState", "Landroidx/compose/material3/DrawerState;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "DrawerSheet-vywBR7E", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
public final class NavigationDrawerKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(256, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float DrawerPositionalThreshold = 0.5f;
    /* access modifiers changed from: private */
    public static final float DrawerVelocityThreshold = Dp.m6614constructorimpl((float) 400);
    /* access modifiers changed from: private */
    public static final float MinimumDrawerWidth = Dp.m6614constructorimpl((float) 240);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.DrawerState, androidx.compose.material3.DrawerValue>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.DrawerState rememberDrawerState(androidx.compose.material3.DrawerValue r7, kotlin.jvm.functions.Function1<? super androidx.compose.material3.DrawerValue, java.lang.Boolean> r8, androidx.compose.runtime.Composer r9, int r10, int r11) {
        /*
            r0 = 2098699222(0x7d179bd6, float:1.2595161E37)
            r9.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberDrawerState)P(1)280@10617L61,280@10553L125:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r11 = r11 & 2
            if (r11 == 0) goto L_0x0013
            androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$1 r8 = androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$1.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
        L_0x0013:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x001f
            r11 = -1
            java.lang.String r1 = "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:279)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r11, r1)
        L_0x001f:
            r11 = 0
            java.lang.Object[] r0 = new java.lang.Object[r11]
            androidx.compose.material3.DrawerState$Companion r1 = androidx.compose.material3.DrawerState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r1.Saver(r8)
            r2 = -21510967(0xfffffffffeb7c4c9, float:-1.2213525E38)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r10 & 14
            r2 = r2 ^ 6
            r3 = 1
            r4 = 4
            if (r2 <= r4) goto L_0x0041
            boolean r2 = r9.changed((java.lang.Object) r7)
            if (r2 != 0) goto L_0x0045
        L_0x0041:
            r2 = r10 & 6
            if (r2 != r4) goto L_0x0047
        L_0x0045:
            r2 = r3
            goto L_0x0048
        L_0x0047:
            r2 = r11
        L_0x0048:
            r4 = r10 & 112(0x70, float:1.57E-43)
            r4 = r4 ^ 48
            r5 = 32
            if (r4 <= r5) goto L_0x0056
            boolean r4 = r9.changed((java.lang.Object) r8)
            if (r4 != 0) goto L_0x005a
        L_0x0056:
            r10 = r10 & 48
            if (r10 != r5) goto L_0x005b
        L_0x005a:
            r11 = r3
        L_0x005b:
            r10 = r2 | r11
            java.lang.Object r11 = r9.rememberedValue()
            if (r10 != 0) goto L_0x006b
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0076
        L_0x006b:
            androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1 r10 = new androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1
            r10.<init>(r7, r8)
            r11 = r10
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r9.updateRememberedValue(r11)
        L_0x0076:
            r3 = r11
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r9.endReplaceableGroup()
            r5 = 0
            r6 = 4
            r2 = 0
            r4 = r9
            java.lang.Object r7 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.DrawerState r7 = (androidx.compose.material3.DrawerState) r7
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x008f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x008f:
            r9.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.rememberDrawerState(androidx.compose.material3.DrawerValue, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.DrawerState");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03d7  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04b7  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0528  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x05cc  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x05d9  */
    /* JADX WARNING: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0155  */
    /* renamed from: ModalNavigationDrawer-FHprtrg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2012ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.material3.DrawerState r30, boolean r31, long r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r1 = r28
            r7 = r34
            r8 = r36
            r0 = -1169303680(0xffffffffba4dd780, float:-7.8522414E-4)
            r2 = r35
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)309@11871L39,311@11988L10,314@12056L24,315@12106L33,316@12171L7,320@12300L250,320@12289L261,330@12589L7,331@12624L1701:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r37 & 1
            r4 = 2
            if (r3 == 0) goto L_0x001c
            r3 = r8 | 6
            goto L_0x002c
        L_0x001c:
            r3 = r8 & 6
            if (r3 != 0) goto L_0x002b
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = r4
        L_0x0029:
            r3 = r3 | r8
            goto L_0x002c
        L_0x002b:
            r3 = r8
        L_0x002c:
            r5 = r37 & 2
            if (r5 == 0) goto L_0x0033
            r3 = r3 | 48
            goto L_0x0046
        L_0x0033:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0046
            r6 = r29
            boolean r9 = r2.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x0042
            r9 = 32
            goto L_0x0044
        L_0x0042:
            r9 = 16
        L_0x0044:
            r3 = r3 | r9
            goto L_0x0048
        L_0x0046:
            r6 = r29
        L_0x0048:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0061
            r9 = r37 & 4
            if (r9 != 0) goto L_0x005b
            r9 = r30
            boolean r10 = r2.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x005d
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005b:
            r9 = r30
        L_0x005d:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r10
            goto L_0x0063
        L_0x0061:
            r9 = r30
        L_0x0063:
            r10 = r37 & 8
            if (r10 == 0) goto L_0x006a
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r12 = r8 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007d
            r12 = r31
            boolean r13 = r2.changed((boolean) r12)
            if (r13 == 0) goto L_0x0079
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r13
            goto L_0x007f
        L_0x007d:
            r12 = r31
        L_0x007f:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r37 & 16
            if (r13 != 0) goto L_0x0092
            r13 = r32
            boolean r16 = r2.changed((long) r13)
            if (r16 == 0) goto L_0x0094
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r13 = r32
        L_0x0094:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r16
            goto L_0x009b
        L_0x0099:
            r13 = r32
        L_0x009b:
            r16 = r37 & 32
            if (r16 == 0) goto L_0x00a4
            r16 = 196608(0x30000, float:2.75506E-40)
        L_0x00a1:
            r3 = r3 | r16
            goto L_0x00b6
        L_0x00a4:
            r16 = 196608(0x30000, float:2.75506E-40)
            r16 = r8 & r16
            if (r16 != 0) goto L_0x00b6
            boolean r16 = r2.changedInstance(r7)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a1
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a1
        L_0x00b6:
            r16 = 74899(0x12493, float:1.04956E-40)
            r11 = r3 & r16
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r15) goto L_0x00d0
            boolean r11 = r2.getSkipping()
            if (r11 != 0) goto L_0x00c7
            goto L_0x00d0
        L_0x00c7:
            r2.skipToGroupEnd()
            r3 = r9
            r4 = r12
            r25 = r13
            goto L_0x05d3
        L_0x00d0:
            r2.startDefaults()
            r11 = r8 & 1
            r15 = 0
            if (r11 == 0) goto L_0x00f6
            boolean r11 = r2.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00df
            goto L_0x00f6
        L_0x00df:
            r2.skipToGroupEnd()
            r4 = r37 & 4
            if (r4 == 0) goto L_0x00e8
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00e8:
            r4 = r37 & 16
            if (r4 == 0) goto L_0x00f0
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = r3 & r4
        L_0x00f0:
            r5 = r3
            r3 = r9
            r4 = r12
            r25 = r13
            goto L_0x0121
        L_0x00f6:
            if (r5 == 0) goto L_0x00fd
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = r5
        L_0x00fd:
            r5 = r37 & 4
            r11 = 6
            if (r5 == 0) goto L_0x010b
            androidx.compose.material3.DrawerValue r5 = androidx.compose.material3.DrawerValue.Closed
            androidx.compose.material3.DrawerState r4 = rememberDrawerState(r5, r15, r2, r11, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r9 = r4
        L_0x010b:
            if (r10 == 0) goto L_0x010e
            r12 = 1
        L_0x010e:
            r4 = r37 & 16
            if (r4 == 0) goto L_0x00f0
            androidx.compose.material3.DrawerDefaults r4 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r4 = r4.getScrimColor(r2, r11)
            r10 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = r3 & r10
            r25 = r4
            r4 = r12
            r5 = r3
            r3 = r9
        L_0x0121:
            r2.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0133
            r9 = -1
            java.lang.String r10 = "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:313)"
            r11 = -1169303680(0xffffffffba4dd780, float:-7.8522414E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r5, r9, r10)
        L_0x0133:
            r9 = 773894976(0x2e20b340, float:3.6538994E-11)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            java.lang.Object r9 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r9 != r10) goto L_0x0166
            kotlin.coroutines.EmptyCoroutineContext r9 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
            kotlinx.coroutines.CoroutineScope r9 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r9, r2)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r10 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r10.<init>(r9)
            r2.updateRememberedValue(r10)
            r9 = r10
        L_0x0166:
            r2.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r9 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r9
            kotlinx.coroutines.CoroutineScope r14 = r9.getCoroutineScope()
            r2.endReplaceableGroup()
            androidx.compose.material3.Strings$Companion r9 = androidx.compose.material3.Strings.Companion
            int r9 = androidx.compose.ui.R.string.navigation_menu
            int r9 = androidx.compose.material3.Strings.m2224constructorimpl(r9)
            r12 = 0
            java.lang.String r13 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r9, r2, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r10, r11)
            java.lang.Object r9 = r2.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.material3.tokens.NavigationDrawerTokens r10 = androidx.compose.material3.tokens.NavigationDrawerTokens.INSTANCE
            float r10 = r10.m2972getContainerWidthD9Ej5fM()
            float r10 = r9.m6550toPx0680j_4(r10)
            float r10 = -r10
            r11 = -1870335235(0xffffffff9084f2fd, float:-5.24392E-29)
            r2.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            r0 = r5 & 896(0x380, float:1.256E-42)
            r0 = r0 ^ 384(0x180, float:5.38E-43)
            r15 = 256(0x100, float:3.59E-43)
            if (r0 <= r15) goto L_0x01ba
            boolean r16 = r2.changed((java.lang.Object) r3)
            if (r16 != 0) goto L_0x01be
        L_0x01ba:
            r12 = r5 & 384(0x180, float:5.38E-43)
            if (r12 != r15) goto L_0x01c0
        L_0x01be:
            r12 = 1
            goto L_0x01c1
        L_0x01c0:
            r12 = 0
        L_0x01c1:
            boolean r15 = r2.changed((java.lang.Object) r9)
            r12 = r12 | r15
            boolean r15 = r2.changed((float) r10)
            r12 = r12 | r15
            java.lang.Object r15 = r2.rememberedValue()
            r8 = 0
            if (r12 != 0) goto L_0x01da
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r15 != r12) goto L_0x01e5
        L_0x01da:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1 r12 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
            r12.<init>(r3, r9, r10, r8)
            r15 = r12
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r2.updateRememberedValue(r15)
        L_0x01e5:
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r2.endReplaceableGroup()
            r9 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r15, r2, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r12, r15)
            java.lang.Object r9 = r2.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r12 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r9 != r12) goto L_0x020a
            r21 = 1
            goto L_0x020c
        L_0x020a:
            r21 = 0
        L_0x020c:
            r9 = 0
            r12 = 1
            r15 = 0
            androidx.compose.ui.Modifier r17 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r6, r9, r12, r15)
            androidx.compose.material3.AnchoredDraggableState r18 = r3.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r19 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r23 = 16
            r24 = 0
            r22 = 0
            r20 = r4
            androidx.compose.ui.Modifier r9 = androidx.compose.material3.AnchoredDraggableKt.anchoredDraggable$default(r17, r18, r19, r20, r21, r22, r23, r24)
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r12)
            java.lang.String r8 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r8)
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r15 = r17.getTopStart()
            r12 = 0
            androidx.compose.ui.layout.MeasurePolicy r15 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r15, r12, r2, r12)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            r17 = r6
            r6 = 0
            int r18 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            r33 = r13
            kotlin.jvm.functions.Function0 r13 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r9 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r9)
            androidx.compose.runtime.Applier r1 = r2.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0268
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0268:
            r2.startReusableNode()
            boolean r1 = r2.getInserting()
            if (r1 == 0) goto L_0x0275
            r2.createNode(r13)
            goto L_0x0278
        L_0x0275:
            r2.useNode()
        L_0x0278:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r1, r15, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r1, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r13 = r1.getInserting()
            if (r13 != 0) goto L_0x02a8
            java.lang.Object r13 = r1.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r18)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r15)
            if (r13 != 0) goto L_0x02b6
        L_0x02a8:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r18)
            r1.updateRememberedValue(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r18)
            r1.apply(r13, r6)
        L_0x02b6:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r6 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r9.invoke(r1, r2, r13)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            r6 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r15 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r6, r15)
            androidx.compose.foundation.layout.BoxScopeInstance r9 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r9 = (androidx.compose.foundation.layout.BoxScope) r9
            r9 = 2009208343(0x77c21617, float:7.873075E33)
            java.lang.String r13 = "C341@12933L37,346@13047L264,354@13336L98,344@12979L497,361@13535L198,368@13761L507,359@13485L834:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r13)
            r13 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r8)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            androidx.compose.ui.Alignment$Companion r18 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r13 = r18.getTopStart()
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r13, r6, r2, r6)
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            int r20 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r1 = r21.getConstructor()
            kotlin.jvm.functions.Function3 r9 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r9)
            r21 = r12
            androidx.compose.runtime.Applier r12 = r2.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0320
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0320:
            r2.startReusableNode()
            boolean r12 = r2.getInserting()
            if (r12 == 0) goto L_0x032d
            r2.createNode(r1)
            goto L_0x0330
        L_0x032d:
            r2.useNode()
        L_0x0330:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r1, r13, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r1, r6, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r12 = r1.getInserting()
            if (r12 != 0) goto L_0x0360
            java.lang.Object r12 = r1.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r20)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 != 0) goto L_0x036e
        L_0x0360:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r20)
            r1.updateRememberedValue(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r20)
            r1.apply(r12, r6)
        L_0x036e:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r6 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r9.invoke(r1, r2, r12)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            r1 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r15)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = -860467894(0xffffffffccb64d4a, float:-9.5578704E7)
            java.lang.String r9 = "C342@12951L9:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r9)
            int r1 = r5 >> 15
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r7.invoke(r2, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            boolean r9 = r3.isOpen()
            r1 = 2009208457(0x77c21689, float:7.873146E33)
            r2.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            r1 = r5 & 7168(0x1c00, float:1.0045E-41)
            r12 = 2048(0x800, float:2.87E-42)
            if (r1 != r12) goto L_0x03c8
            r1 = 1
            goto L_0x03c9
        L_0x03c8:
            r1 = r6
        L_0x03c9:
            r12 = 256(0x100, float:3.59E-43)
            if (r0 <= r12) goto L_0x03d3
            boolean r13 = r2.changed((java.lang.Object) r3)
            if (r13 != 0) goto L_0x03d7
        L_0x03d3:
            r13 = r5 & 384(0x180, float:5.38E-43)
            if (r13 != r12) goto L_0x03d9
        L_0x03d7:
            r12 = 1
            goto L_0x03da
        L_0x03d9:
            r12 = r6
        L_0x03da:
            r1 = r1 | r12
            boolean r12 = r2.changedInstance(r14)
            r1 = r1 | r12
            java.lang.Object r12 = r2.rememberedValue()
            if (r1 != 0) goto L_0x03ee
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r12 != r1) goto L_0x03f9
        L_0x03ee:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1 r1 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
            r1.<init>(r4, r3, r14)
            r12 = r1
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r2.updateRememberedValue(r12)
        L_0x03f9:
            r1 = r12
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r2.endReplaceableGroup()
            r12 = 2009208746(0x77c217aa, float:7.8733246E33)
            r2.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            boolean r12 = r2.changed((float) r10)
            r13 = 256(0x100, float:3.59E-43)
            if (r0 <= r13) goto L_0x0416
            boolean r16 = r2.changed((java.lang.Object) r3)
            if (r16 != 0) goto L_0x041a
        L_0x0416:
            r6 = r5 & 384(0x180, float:5.38E-43)
            if (r6 != r13) goto L_0x041c
        L_0x041a:
            r6 = 1
            goto L_0x041d
        L_0x041c:
            r6 = 0
        L_0x041d:
            r6 = r6 | r12
            java.lang.Object r12 = r2.rememberedValue()
            if (r6 != 0) goto L_0x042c
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r12 != r6) goto L_0x0438
        L_0x042c:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1 r6 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
            r12 = 0
            r6.<init>(r10, r12, r3)
            r12 = r6
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r2.updateRememberedValue(r12)
        L_0x0438:
            r6 = r12
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r2.endReplaceableGroup()
            int r10 = r5 >> 3
            r12 = r10 & 7168(0x1c00, float:1.0045E-41)
            r10 = r1
            r1 = r11
            r11 = r6
            r6 = r33
            r30 = r4
            r16 = r12
            r20 = r13
            r4 = r21
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12 = r25
            r7 = r14
            r14 = r2
            r27 = r15
            r4 = r20
            r15 = r16
            m2014ScrimBx497Mc(r9, r10, r11, r12, r14, r15)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r10 = 2009208945(0x77c21871, float:7.873448E33)
            r2.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            if (r0 <= r4) goto L_0x0474
            boolean r10 = r2.changed((java.lang.Object) r3)
            if (r10 != 0) goto L_0x0478
        L_0x0474:
            r10 = r5 & 384(0x180, float:5.38E-43)
            if (r10 != r4) goto L_0x047a
        L_0x0478:
            r12 = 1
            goto L_0x047b
        L_0x047a:
            r12 = 0
        L_0x047b:
            java.lang.Object r10 = r2.rememberedValue()
            if (r12 != 0) goto L_0x0489
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r10 != r11) goto L_0x0493
        L_0x0489:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1 r10 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
            r10.<init>(r3)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r2.updateRememberedValue(r10)
        L_0x0493:
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.OffsetKt.offset(r9, r10)
            r10 = 2009209171(0x77c21953, float:7.873588E33)
            r2.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            boolean r1 = r2.changed((java.lang.Object) r6)
            if (r0 <= r4) goto L_0x04b1
            boolean r0 = r2.changed((java.lang.Object) r3)
            if (r0 != 0) goto L_0x04b5
        L_0x04b1:
            r0 = r5 & 384(0x180, float:5.38E-43)
            if (r0 != r4) goto L_0x04b7
        L_0x04b5:
            r12 = 1
            goto L_0x04b8
        L_0x04b7:
            r12 = 0
        L_0x04b8:
            r0 = r1 | r12
            boolean r1 = r2.changedInstance(r7)
            r0 = r0 | r1
            java.lang.Object r1 = r2.rememberedValue()
            if (r0 != 0) goto L_0x04cd
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x04d8
        L_0x04cd:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1 r0 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
            r0.<init>(r6, r3, r7)
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2.updateRememberedValue(r1)
        L_0x04d8:
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2.endReplaceableGroup()
            r0 = 0
            r4 = 0
            r6 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r9, r4, r1, r6, r0)
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r8)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r4, r2, r4)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r6)
            r6 = r21
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r6)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r4)
            androidx.compose.runtime.CompositionLocalMap r4 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r8 = r2.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x051f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x051f:
            r2.startReusableNode()
            boolean r8 = r2.getInserting()
            if (r8 == 0) goto L_0x052c
            r2.createNode(r7)
            goto L_0x052f
        L_0x052c:
            r2.useNode()
        L_0x052f:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r1, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r4 = r7.getInserting()
            if (r4 != 0) goto L_0x055f
            java.lang.Object r4 = r7.rememberedValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r8)
            if (r4 != 0) goto L_0x056d
        L_0x055f:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r7.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r7.apply(r4, r1)
        L_0x056d:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.invoke(r1, r2, r4)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            r0 = r27
            r1 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -860466551(0xffffffffccb65289, float:-9.5589448E7)
            java.lang.String r1 = "C382@14294L15:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            r0 = r5 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r28
            r1.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05cf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05cf:
            r4 = r30
            r6 = r17
        L_0x05d3:
            androidx.compose.runtime.ScopeUpdateScope r10 = r2.endRestartGroup()
            if (r10 == 0) goto L_0x05ef
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3 r11 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3
            r0 = r11
            r1 = r28
            r2 = r6
            r5 = r25
            r7 = r34
            r8 = r36
            r9 = r37
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x05ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2012ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:176:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DismissibleNavigationDrawer(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.ui.Modifier r25, androidx.compose.material3.DrawerState r26, boolean r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r1 = r24
            r5 = r28
            r6 = r30
            r0 = 398812198(0x17c56426, float:1.2756108E-24)
            r2 = r29
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(DismissibleNavigationDrawer)P(1,4,2,3)412@15589L39,416@15738L7,422@15939L250,422@15928L261,432@16207L24,433@16257L33,435@16329L7,436@16364L1446:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r31 & 1
            r4 = 2
            if (r3 == 0) goto L_0x001c
            r3 = r6 | 6
            goto L_0x002c
        L_0x001c:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x002b
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = r4
        L_0x0029:
            r3 = r3 | r6
            goto L_0x002c
        L_0x002b:
            r3 = r6
        L_0x002c:
            r7 = r31 & 2
            if (r7 == 0) goto L_0x0033
            r3 = r3 | 48
            goto L_0x0046
        L_0x0033:
            r8 = r6 & 48
            if (r8 != 0) goto L_0x0046
            r8 = r25
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0042
            r9 = 32
            goto L_0x0044
        L_0x0042:
            r9 = 16
        L_0x0044:
            r3 = r3 | r9
            goto L_0x0048
        L_0x0046:
            r8 = r25
        L_0x0048:
            r9 = r6 & 384(0x180, float:5.38E-43)
            r10 = 256(0x100, float:3.59E-43)
            if (r9 != 0) goto L_0x0062
            r9 = r31 & 4
            if (r9 != 0) goto L_0x005c
            r9 = r26
            boolean r11 = r2.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x005e
            r11 = r10
            goto L_0x0060
        L_0x005c:
            r9 = r26
        L_0x005e:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r11
            goto L_0x0064
        L_0x0062:
            r9 = r26
        L_0x0064:
            r11 = r31 & 8
            if (r11 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r12 = r6 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r27
            boolean r13 = r2.changed((boolean) r12)
            if (r13 == 0) goto L_0x007a
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r13
            goto L_0x0080
        L_0x007e:
            r12 = r27
        L_0x0080:
            r13 = r31 & 16
            if (r13 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0087:
            r13 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0097
            boolean r13 = r2.changedInstance(r5)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r13
        L_0x0097:
            r13 = r3 & 9363(0x2493, float:1.312E-41)
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00ab
            boolean r13 = r2.getSkipping()
            if (r13 != 0) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            r2.skipToGroupEnd()
            r3 = r9
            r4 = r12
            goto L_0x0576
        L_0x00ab:
            r2.startDefaults()
            r13 = r6 & 1
            r14 = 0
            if (r13 == 0) goto L_0x00c4
            boolean r13 = r2.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00ba
            goto L_0x00c4
        L_0x00ba:
            r2.skipToGroupEnd()
            r4 = r31 & 4
            if (r4 == 0) goto L_0x00dc
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00dc
        L_0x00c4:
            if (r7 == 0) goto L_0x00cb
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r8 = r7
        L_0x00cb:
            r7 = r31 & 4
            if (r7 == 0) goto L_0x00d9
            androidx.compose.material3.DrawerValue r7 = androidx.compose.material3.DrawerValue.Closed
            r9 = 6
            androidx.compose.material3.DrawerState r4 = rememberDrawerState(r7, r14, r2, r9, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r9 = r4
        L_0x00d9:
            if (r11 == 0) goto L_0x00dc
            r12 = 1
        L_0x00dc:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00eb
            r4 = -1
            java.lang.String r7 = "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:415)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r4, r7)
        L_0x00eb:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.material3.tokens.NavigationDrawerTokens r4 = androidx.compose.material3.tokens.NavigationDrawerTokens.INSTANCE
            float r4 = r4.m2972getContainerWidthD9Ej5fM()
            float r4 = r0.m6550toPx0680j_4(r4)
            float r4 = -r4
            r7 = 171918245(0xa3f43a5, float:9.209038E-33)
            r2.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            r11 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 ^ 384(0x180, float:5.38E-43)
            r13 = 0
            if (r11 <= r10) goto L_0x0125
            boolean r16 = r2.changed((java.lang.Object) r9)
            if (r16 != 0) goto L_0x0129
        L_0x0125:
            r14 = r3 & 384(0x180, float:5.38E-43)
            if (r14 != r10) goto L_0x012b
        L_0x0129:
            r14 = 1
            goto L_0x012c
        L_0x012b:
            r14 = r13
        L_0x012c:
            boolean r16 = r2.changed((java.lang.Object) r0)
            r14 = r14 | r16
            boolean r16 = r2.changed((float) r4)
            r14 = r14 | r16
            java.lang.Object r15 = r2.rememberedValue()
            if (r14 != 0) goto L_0x0146
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r15 != r14) goto L_0x0152
        L_0x0146:
            androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1 r14 = new androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
            r15 = 0
            r14.<init>(r9, r0, r4, r15)
            r15 = r14
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r2.updateRememberedValue(r15)
        L_0x0152:
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r2.endReplaceableGroup()
            androidx.compose.runtime.EffectsKt.SideEffect(r15, r2, r13)
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            java.lang.Object r0 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r0 != r4) goto L_0x018d
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r2)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r4.<init>(r0)
            r2.updateRememberedValue(r4)
            r0 = r4
        L_0x018d:
            r2.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r0 = r0.getCoroutineScope()
            r2.endReplaceableGroup()
            androidx.compose.material3.Strings$Companion r4 = androidx.compose.material3.Strings.Companion
            int r4 = androidx.compose.ui.R.string.navigation_menu
            int r4 = androidx.compose.material3.Strings.m2224constructorimpl(r4)
            java.lang.String r4 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r4, r2, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r10)
            java.lang.Object r10 = r2.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r14 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r10 != r14) goto L_0x01c1
            r20 = 1
            goto L_0x01c3
        L_0x01c1:
            r20 = r13
        L_0x01c3:
            androidx.compose.material3.AnchoredDraggableState r17 = r9.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r18 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r22 = 16
            r23 = 0
            r21 = 0
            r16 = r8
            r19 = r12
            androidx.compose.ui.Modifier r10 = androidx.compose.material3.AnchoredDraggableKt.anchoredDraggable$default(r16, r17, r18, r19, r20, r21, r22, r23)
            r14 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r14)
            java.lang.String r15 = "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r14 = r16.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r14, r13, r2, r13)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            r6 = 0
            int r16 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r18 = r8
            kotlin.jvm.functions.Function0 r8 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r10)
            r17 = r12
            androidx.compose.runtime.Applier r12 = r2.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0219
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0219:
            r2.startReusableNode()
            boolean r12 = r2.getInserting()
            if (r12 == 0) goto L_0x0226
            r2.createNode(r8)
            goto L_0x0229
        L_0x0226:
            r2.useNode()
        L_0x0229:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r8, r14, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r8, r6, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r12 = r8.getInserting()
            if (r12 != 0) goto L_0x0259
            java.lang.Object r12 = r8.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 != 0) goto L_0x0267
        L_0x0259:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r16)
            r8.updateRememberedValue(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r16)
            r8.apply(r12, r6)
        L_0x0267:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r6)
            r8 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)
            r10.invoke(r6, r2, r12)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r6)
            r8 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            java.lang.String r10 = "C73@3426L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r10)
            androidx.compose.foundation.layout.BoxScopeInstance r12 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r12 = (androidx.compose.foundation.layout.BoxScope) r12
            r12 = 973030793(0x39ff4589, float:4.8689198E-4)
            java.lang.String r14 = "C464@17278L526,445@16646L1158:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r12, r14)
            r12 = 973031425(0x39ff4801, float:4.8691037E-4)
            r2.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            r12 = 256(0x100, float:3.59E-43)
            if (r11 <= r12) goto L_0x02a4
            boolean r14 = r2.changed((java.lang.Object) r9)
            if (r14 != 0) goto L_0x02a8
        L_0x02a4:
            r14 = r3 & 384(0x180, float:5.38E-43)
            if (r14 != r12) goto L_0x02aa
        L_0x02a8:
            r12 = 1
            goto L_0x02ab
        L_0x02aa:
            r12 = 0
        L_0x02ab:
            java.lang.Object r14 = r2.rememberedValue()
            if (r12 != 0) goto L_0x02b9
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r14 != r12) goto L_0x02c4
        L_0x02b9:
            androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1 r12 = new androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
            r12.<init>(r9)
            r14 = r12
            androidx.compose.ui.layout.MeasurePolicy r14 = (androidx.compose.ui.layout.MeasurePolicy) r14
            r2.updateRememberedValue(r14)
        L_0x02c4:
            androidx.compose.ui.layout.MeasurePolicy r14 = (androidx.compose.ui.layout.MeasurePolicy) r14
            r2.endReplaceableGroup()
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            r8 = 0
            int r19 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r8)
            androidx.compose.runtime.CompositionLocalMap r8 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r20.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r12)
            androidx.compose.runtime.Applier r5 = r2.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x02f4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02f4:
            r2.startReusableNode()
            boolean r5 = r2.getInserting()
            if (r5 == 0) goto L_0x0301
            r2.createNode(r6)
            goto L_0x0304
        L_0x0301:
            r2.useNode()
        L_0x0304:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r14, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r8, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r8 = r5.getInserting()
            if (r8 != 0) goto L_0x0334
            java.lang.Object r8 = r5.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r19)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r14)
            if (r8 != 0) goto L_0x0342
        L_0x0334:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)
            r5.updateRememberedValue(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)
            r5.apply(r8, r6)
        L_0x0342:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r5)
            r6 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            r12.invoke(r5, r2, r8)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r5)
            r5 = 94149449(0x59c9b49, float:1.4727212E-35)
            java.lang.String r6 = "C446@16700L459,446@16677L531,461@17221L45:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r6)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = 94149472(0x59c9b60, float:1.4727245E-35)
            r2.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            boolean r6 = r2.changed((java.lang.Object) r4)
            r7 = 256(0x100, float:3.59E-43)
            if (r11 <= r7) goto L_0x037b
            boolean r8 = r2.changed((java.lang.Object) r9)
            if (r8 != 0) goto L_0x037f
        L_0x037b:
            r8 = r3 & 384(0x180, float:5.38E-43)
            if (r8 != r7) goto L_0x0381
        L_0x037f:
            r7 = 1
            goto L_0x0382
        L_0x0381:
            r7 = 0
        L_0x0382:
            r6 = r6 | r7
            boolean r7 = r2.changedInstance(r0)
            r6 = r6 | r7
            java.lang.Object r7 = r2.rememberedValue()
            if (r6 != 0) goto L_0x0396
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x03a1
        L_0x0396:
            androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1 r6 = new androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
            r6.<init>(r4, r9, r0)
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r2.updateRememberedValue(r7)
        L_0x03a1:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r2.endReplaceableGroup()
            r0 = 0
            r4 = 0
            r6 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r5, r4, r7, r6, r0)
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r4, r2, r4)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r4)
            androidx.compose.runtime.CompositionLocalMap r4 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r8 = r2.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x03e6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03e6:
            r2.startReusableNode()
            boolean r8 = r2.getInserting()
            if (r8 == 0) goto L_0x03f3
            r2.createNode(r7)
            goto L_0x03f6
        L_0x03f3:
            r2.useNode()
        L_0x03f6:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r5, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r4, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r5 = r7.getInserting()
            if (r5 != 0) goto L_0x0426
            java.lang.Object r5 = r7.rememberedValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r5 != 0) goto L_0x0434
        L_0x0426:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r7.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r7.apply(r5, r4)
        L_0x0434:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r4)
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.invoke(r4, r2, r6)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r10)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -817264288(0xffffffffcf498960, float:-3.38122342E9)
            java.lang.String r4 = "C459@17179L15:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r4)
            r0 = r3 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r5 = 0
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r5, r2, r5)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r13)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r5)
            androidx.compose.runtime.CompositionLocalMap r5 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r8 = r2.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x04b5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x04b5:
            r2.startReusableNode()
            boolean r8 = r2.getInserting()
            if (r8 == 0) goto L_0x04c2
            r2.createNode(r7)
            goto L_0x04c5
        L_0x04c2:
            r2.useNode()
        L_0x04c5:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3282constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r4, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r7, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r5 = r7.getInserting()
            if (r5 != 0) goto L_0x04f5
            java.lang.Object r5 = r7.rememberedValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r5 != 0) goto L_0x0503
        L_0x04f5:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r7.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r7.apply(r5, r4)
        L_0x0503:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r4)
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.invoke(r4, r2, r5)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            r0 = -1253629263(0xffffffffb54722b1, float:-7.418376E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r10)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -817264224(0xffffffffcf4989a0, float:-3.38123981E9)
            java.lang.String r4 = "C462@17243L9:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r4)
            int r0 = r3 >> 12
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5 = r28
            r5.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0571
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0571:
            r3 = r9
            r4 = r17
            r8 = r18
        L_0x0576:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x0590
            androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3 r10 = new androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3
            r0 = r10
            r1 = r24
            r2 = r8
            r5 = r28
            r6 = r30
            r7 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0590:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void PermanentNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-276843608);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermanentNavigationDrawer)P(1,2)501@18841L105:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276843608, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:500)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r8 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r8, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r8.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1153993360, "C502@18879L15,503@18903L37:NavigationDrawer.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r7 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r7, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r7, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r7.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1146975803, "C504@18921L9:NavigationDrawer.kt#uh7d8r");
            function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
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
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationDrawerKt$PermanentNavigationDrawer$2(function2, modifier2, function22, i, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ea  */
    /* renamed from: ModalDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2011ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier r23, androidx.compose.ui.graphics.Shape r24, long r25, long r27, float r29, androidx.compose.foundation.layout.WindowInsets r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r10 = r33
            r0 = 1001163336(0x3bac8a48, float:0.005265508)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)528@20049L5,529@20105L14,530@20153L37,532@20308L12,535@20378L183:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r34 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r10 | 6
            r4 = r3
            r3 = r23
            goto L_0x002e
        L_0x001a:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r23
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r10
            goto L_0x002e
        L_0x002b:
            r3 = r23
            r4 = r10
        L_0x002e:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0047
            r5 = r34 & 2
            if (r5 != 0) goto L_0x0041
            r5 = r24
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0043
            r6 = 32
            goto L_0x0045
        L_0x0041:
            r5 = r24
        L_0x0043:
            r6 = 16
        L_0x0045:
            r4 = r4 | r6
            goto L_0x0049
        L_0x0047:
            r5 = r24
        L_0x0049:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0062
            r6 = r34 & 4
            if (r6 != 0) goto L_0x005c
            r6 = r25
            boolean r8 = r1.changed((long) r6)
            if (r8 == 0) goto L_0x005e
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r6 = r25
        L_0x005e:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r4 = r4 | r8
            goto L_0x0064
        L_0x0062:
            r6 = r25
        L_0x0064:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007d
            r8 = r34 & 8
            if (r8 != 0) goto L_0x0077
            r8 = r27
            boolean r11 = r1.changed((long) r8)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r8 = r27
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r4 = r4 | r11
            goto L_0x007f
        L_0x007d:
            r8 = r27
        L_0x007f:
            r11 = r34 & 16
            if (r11 == 0) goto L_0x0086
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0099
            r12 = r29
            boolean r13 = r1.changed((float) r12)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r4 = r4 | r13
            goto L_0x009b
        L_0x0099:
            r12 = r29
        L_0x009b:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00b5
            r13 = r34 & 32
            if (r13 != 0) goto L_0x00af
            r13 = r30
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r13 = r30
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r4 = r4 | r14
            goto L_0x00b7
        L_0x00b5:
            r13 = r30
        L_0x00b7:
            r14 = r34 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bf
            r4 = r4 | r15
            goto L_0x00d2
        L_0x00bf:
            r14 = r10 & r15
            if (r14 != 0) goto L_0x00d2
            r14 = r31
            boolean r15 = r1.changedInstance(r14)
            if (r15 == 0) goto L_0x00ce
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r4 = r4 | r15
            goto L_0x00d4
        L_0x00d2:
            r14 = r31
        L_0x00d4:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r4
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ea
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e4
            goto L_0x00ea
        L_0x00e4:
            r1.skipToGroupEnd()
            r2 = r5
            goto L_0x01ad
        L_0x00ea:
            r1.startDefaults()
            r0 = r10 & 1
            r15 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x0119
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00fb
            goto L_0x0119
        L_0x00fb:
            r1.skipToGroupEnd()
            r0 = r34 & 2
            if (r0 == 0) goto L_0x0104
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0104:
            r0 = r34 & 4
            if (r0 == 0) goto L_0x010a
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010a:
            r0 = r34 & 8
            if (r0 == 0) goto L_0x0110
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0110:
            r0 = r34 & 32
            if (r0 == 0) goto L_0x0115
            r4 = r4 & r15
        L_0x0115:
            r0 = r3
        L_0x0116:
            r2 = r12
            r3 = r13
            goto L_0x0160
        L_0x0119:
            if (r2 == 0) goto L_0x0120
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0121
        L_0x0120:
            r0 = r3
        L_0x0121:
            r2 = r34 & 2
            r3 = 6
            if (r2 == 0) goto L_0x012f
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r1, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            r5 = r2
        L_0x012f:
            r2 = r34 & 4
            if (r2 == 0) goto L_0x013b
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r6 = r2.getContainerColor(r1, r3)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x013b:
            r2 = r34 & 8
            if (r2 == 0) goto L_0x014a
            int r2 = r4 >> 6
            r2 = r2 & 14
            long r8 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r6, r1, r2)
            r2 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r4 = r2
        L_0x014a:
            if (r11 == 0) goto L_0x0153
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1825getModalDrawerElevationD9Ej5fM()
            r12 = r2
        L_0x0153:
            r2 = r34 & 32
            if (r2 == 0) goto L_0x0116
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r1, r3)
            r4 = r4 & r15
            r3 = r2
            r2 = r12
        L_0x0160:
            r1.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0172
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:534)"
            r13 = 1001163336(0x3bac8a48, float:0.005265508)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r4, r11, r12)
        L_0x0172:
            int r11 = r4 >> 15
            r11 = r11 & 14
            int r12 = r4 << 3
            r13 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r13
            r13 = r12 & 896(0x380, float:1.256E-42)
            r11 = r11 | r13
            r13 = r12 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r12
            r11 = r11 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r13
            r11 = r11 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r12
            r21 = r11 | r4
            r22 = 0
            r11 = r3
            r12 = r0
            r13 = r5
            r14 = r6
            r16 = r8
            r18 = r2
            r19 = r31
            r20 = r1
            m2010DrawerSheetvywBR7E(r11, r12, r13, r14, r16, r18, r19, r20, r21, r22)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x01a9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a9:
            r12 = r2
            r13 = r3
            r2 = r5
            r3 = r0
        L_0x01ad:
            androidx.compose.runtime.ScopeUpdateScope r14 = r1.endRestartGroup()
            if (r14 == 0) goto L_0x01c9
            androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1 r15 = new androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1
            r0 = r15
            r1 = r3
            r3 = r6
            r5 = r8
            r7 = r12
            r8 = r13
            r9 = r31
            r10 = r33
            r11 = r34
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x01c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2011ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f0  */
    /* renamed from: DismissibleDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2009DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r10 = r35
            r0 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)566@21732L14,567@21780L37,569@21941L12,572@22011L183:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r36 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r10 | 6
            r4 = r3
            r3 = r25
            goto L_0x002e
        L_0x001a:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r25
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r10
            goto L_0x002e
        L_0x002b:
            r3 = r25
            r4 = r10
        L_0x002e:
            r5 = r36 & 2
            if (r5 == 0) goto L_0x0035
            r4 = r4 | 48
            goto L_0x0048
        L_0x0035:
            r6 = r10 & 48
            if (r6 != 0) goto L_0x0048
            r6 = r26
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0044
            r7 = 32
            goto L_0x0046
        L_0x0044:
            r7 = 16
        L_0x0046:
            r4 = r4 | r7
            goto L_0x004a
        L_0x0048:
            r6 = r26
        L_0x004a:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0063
            r7 = r36 & 4
            if (r7 != 0) goto L_0x005d
            r7 = r27
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005d:
            r7 = r27
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r4 = r4 | r9
            goto L_0x0065
        L_0x0063:
            r7 = r27
        L_0x0065:
            r9 = r10 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007c
            r9 = r36 & 8
            r11 = r29
            if (r9 != 0) goto L_0x0078
            boolean r9 = r1.changed((long) r11)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r9
            goto L_0x007e
        L_0x007c:
            r11 = r29
        L_0x007e:
            r9 = r36 & 16
            if (r9 == 0) goto L_0x0085
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0098
            r13 = r31
            boolean r14 = r1.changed((float) r13)
            if (r14 == 0) goto L_0x0094
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r4 = r4 | r14
            goto L_0x009a
        L_0x0098:
            r13 = r31
        L_0x009a:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b4
            r14 = r36 & 32
            if (r14 != 0) goto L_0x00ae
            r14 = r32
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r14 = r32
        L_0x00b0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r4 = r4 | r15
            goto L_0x00b6
        L_0x00b4:
            r14 = r32
        L_0x00b6:
            r15 = r36 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bf
            r4 = r4 | r16
            goto L_0x00d3
        L_0x00bf:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d3
            r15 = r33
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r4 = r4 | r16
            goto L_0x00d5
        L_0x00d3:
            r15 = r33
        L_0x00d5:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r4 & r16
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x00f0
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e6
            goto L_0x00f0
        L_0x00e6:
            r1.skipToGroupEnd()
            r2 = r25
            r3 = r7
            r7 = r13
            r8 = r14
            goto L_0x01b1
        L_0x00f0:
            r1.startDefaults()
            r0 = r10 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x011c
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0101
            goto L_0x011c
        L_0x0101:
            r1.skipToGroupEnd()
            r0 = r36 & 4
            if (r0 == 0) goto L_0x010a
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010a:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x0110
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0110:
            r0 = r36 & 32
            if (r0 == 0) goto L_0x0115
            r4 = r4 & r3
        L_0x0115:
            r0 = r25
        L_0x0117:
            r9 = r4
            r2 = r11
            r4 = r13
            r5 = r14
            goto L_0x0160
        L_0x011c:
            if (r2 == 0) goto L_0x0123
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0125
        L_0x0123:
            r0 = r25
        L_0x0125:
            if (r5 == 0) goto L_0x012c
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = r2
        L_0x012c:
            r2 = r36 & 4
            r5 = 6
            if (r2 == 0) goto L_0x0139
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r7 = r2.getContainerColor(r1, r5)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0139:
            r2 = r36 & 8
            if (r2 == 0) goto L_0x0148
            int r2 = r4 >> 6
            r2 = r2 & 14
            long r11 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r7, r1, r2)
            r2 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r4 = r2
        L_0x0148:
            if (r9 == 0) goto L_0x0151
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1823getDismissibleDrawerElevationD9Ej5fM()
            r13 = r2
        L_0x0151:
            r2 = r36 & 32
            if (r2 == 0) goto L_0x0117
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r1, r5)
            r4 = r4 & r3
            r5 = r2
            r9 = r4
            r2 = r11
            r4 = r13
        L_0x0160:
            r1.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0172
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:571)"
            r13 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r9, r11, r12)
        L_0x0172:
            int r11 = r9 >> 15
            r11 = r11 & 14
            int r12 = r9 << 3
            r13 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r13
            r13 = r12 & 896(0x380, float:1.256E-42)
            r11 = r11 | r13
            r13 = r12 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r12
            r11 = r11 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r13
            r11 = r11 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r12
            r21 = r11 | r9
            r22 = 0
            r11 = r5
            r12 = r0
            r13 = r6
            r14 = r7
            r16 = r2
            r18 = r4
            r19 = r33
            r20 = r1
            m2010DrawerSheetvywBR7E(r11, r12, r13, r14, r16, r18, r19, r20, r21, r22)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01a9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a9:
            r11 = r2
            r2 = r0
            r23 = r7
            r7 = r4
            r8 = r5
            r3 = r23
        L_0x01b1:
            androidx.compose.runtime.ScopeUpdateScope r13 = r1.endRestartGroup()
            if (r13 == 0) goto L_0x01cb
            androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1 r14 = new androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1
            r0 = r14
            r1 = r2
            r2 = r6
            r5 = r11
            r9 = r33
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x01cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2009DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f0  */
    /* renamed from: PermanentDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2013PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r10 = r35
            r0 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)603@23356L14,604@23404L37,606@23563L12,609@23654L33,612@23754L50,610@23692L244:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r36 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r10 | 6
            r4 = r3
            r3 = r25
            goto L_0x002e
        L_0x001a:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r25
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r10
            goto L_0x002e
        L_0x002b:
            r3 = r25
            r4 = r10
        L_0x002e:
            r5 = r36 & 2
            if (r5 == 0) goto L_0x0035
            r4 = r4 | 48
            goto L_0x0048
        L_0x0035:
            r6 = r10 & 48
            if (r6 != 0) goto L_0x0048
            r6 = r26
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0044
            r7 = 32
            goto L_0x0046
        L_0x0044:
            r7 = 16
        L_0x0046:
            r4 = r4 | r7
            goto L_0x004a
        L_0x0048:
            r6 = r26
        L_0x004a:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0063
            r7 = r36 & 4
            if (r7 != 0) goto L_0x005d
            r7 = r27
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005d:
            r7 = r27
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r4 = r4 | r9
            goto L_0x0065
        L_0x0063:
            r7 = r27
        L_0x0065:
            r9 = r10 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007c
            r9 = r36 & 8
            r11 = r29
            if (r9 != 0) goto L_0x0078
            boolean r9 = r1.changed((long) r11)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r9
            goto L_0x007e
        L_0x007c:
            r11 = r29
        L_0x007e:
            r9 = r36 & 16
            if (r9 == 0) goto L_0x0085
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0098
            r13 = r31
            boolean r14 = r1.changed((float) r13)
            if (r14 == 0) goto L_0x0094
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r4 = r4 | r14
            goto L_0x009a
        L_0x0098:
            r13 = r31
        L_0x009a:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b4
            r14 = r36 & 32
            if (r14 != 0) goto L_0x00ae
            r14 = r32
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r14 = r32
        L_0x00b0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r4 = r4 | r15
            goto L_0x00b6
        L_0x00b4:
            r14 = r32
        L_0x00b6:
            r15 = r36 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bf
            r4 = r4 | r16
            goto L_0x00d3
        L_0x00bf:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d3
            r15 = r33
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r4 = r4 | r16
            goto L_0x00d5
        L_0x00d3:
            r15 = r33
        L_0x00d5:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r4 & r16
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x00f0
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e6
            goto L_0x00f0
        L_0x00e6:
            r1.skipToGroupEnd()
            r2 = r25
            r3 = r7
            r7 = r13
            r8 = r14
            goto L_0x01ed
        L_0x00f0:
            r1.startDefaults()
            r0 = r10 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x011c
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0101
            goto L_0x011c
        L_0x0101:
            r1.skipToGroupEnd()
            r0 = r36 & 4
            if (r0 == 0) goto L_0x010a
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010a:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x0110
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0110:
            r0 = r36 & 32
            if (r0 == 0) goto L_0x0115
            r4 = r4 & r3
        L_0x0115:
            r0 = r25
        L_0x0117:
            r9 = r4
            r2 = r11
            r4 = r13
            r5 = r14
            goto L_0x0160
        L_0x011c:
            if (r2 == 0) goto L_0x0123
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0125
        L_0x0123:
            r0 = r25
        L_0x0125:
            if (r5 == 0) goto L_0x012c
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = r2
        L_0x012c:
            r2 = r36 & 4
            r5 = 6
            if (r2 == 0) goto L_0x0139
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r7 = r2.getContainerColor(r1, r5)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0139:
            r2 = r36 & 8
            if (r2 == 0) goto L_0x0148
            int r2 = r4 >> 6
            r2 = r2 & 14
            long r11 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r7, r1, r2)
            r2 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r4 = r2
        L_0x0148:
            if (r9 == 0) goto L_0x0151
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1826getPermanentDrawerElevationD9Ej5fM()
            r13 = r2
        L_0x0151:
            r2 = r36 & 32
            if (r2 == 0) goto L_0x0117
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r1, r5)
            r4 = r4 & r3
            r5 = r2
            r9 = r4
            r2 = r11
            r4 = r13
        L_0x0160:
            r1.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0172
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:608)"
            r13 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r9, r11, r12)
        L_0x0172:
            androidx.compose.material3.Strings$Companion r11 = androidx.compose.material3.Strings.Companion
            int r11 = androidx.compose.ui.R.string.navigation_menu
            int r11 = androidx.compose.material3.Strings.m2224constructorimpl(r11)
            r12 = 0
            java.lang.String r11 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r11, r1, r12)
            r13 = 705343847(0x2a0ab167, float:1.2318411E-13)
            r1.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            boolean r13 = r1.changed((java.lang.Object) r11)
            java.lang.Object r14 = r1.rememberedValue()
            if (r13 != 0) goto L_0x019c
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x01a7
        L_0x019c:
            androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1 r13 = new androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
            r13.<init>(r11)
            r14 = r13
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r1.updateRememberedValue(r14)
        L_0x01a7:
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r1.endReplaceableGroup()
            r11 = 0
            r13 = 1
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r12, r14, r13, r11)
            int r11 = r9 >> 15
            r11 = r11 & 14
            int r13 = r9 << 3
            r14 = r13 & 896(0x380, float:1.256E-42)
            r11 = r11 | r14
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r13
            r11 = r11 | r14
            r14 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r14
            r11 = r11 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r13
            r21 = r11 | r9
            r22 = 0
            r11 = r5
            r13 = r6
            r14 = r7
            r16 = r2
            r18 = r4
            r19 = r33
            r20 = r1
            m2010DrawerSheetvywBR7E(r11, r12, r13, r14, r16, r18, r19, r20, r21, r22)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01e5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e5:
            r11 = r2
            r2 = r0
            r23 = r7
            r7 = r4
            r8 = r5
            r3 = r23
        L_0x01ed:
            androidx.compose.runtime.ScopeUpdateScope r13 = r1.endRestartGroup()
            if (r13 == 0) goto L_0x0207
            androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2 r14 = new androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2
            r0 = r14
            r1 = r2
            r2 = r6
            r5 = r11
            r9 = r33
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0207:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2013PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e9  */
    /* renamed from: DrawerSheet-vywBR7E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2010DrawerSheetvywBR7E(androidx.compose.foundation.layout.WindowInsets r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.graphics.Shape r28, long r29, long r31, float r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r1 = r26
            r9 = r34
            r10 = r36
            r0 = 175072821(0xa6f6635, float:1.15266544E-32)
            r2 = r35
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(DrawerSheet)P(6,5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp)628@24134L14,629@24182L37,633@24349L667:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r37 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r10
            goto L_0x002b
        L_0x002a:
            r3 = r10
        L_0x002b:
            r4 = r37 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r27
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r27
        L_0x0047:
            r6 = r37 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0061
            r7 = r28
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r28
        L_0x0063:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007a
            r8 = r37 & 8
            r11 = r29
            if (r8 != 0) goto L_0x0076
            boolean r8 = r2.changed((long) r11)
            if (r8 == 0) goto L_0x0076
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r8
            goto L_0x007c
        L_0x007a:
            r11 = r29
        L_0x007c:
            r8 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x0093
            r8 = r37 & 16
            r13 = r31
            if (r8 != 0) goto L_0x008f
            boolean r8 = r2.changed((long) r13)
            if (r8 == 0) goto L_0x008f
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0091
        L_0x008f:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0091:
            r3 = r3 | r8
            goto L_0x0095
        L_0x0093:
            r13 = r31
        L_0x0095:
            r8 = r37 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x009d
            r3 = r3 | r15
            goto L_0x00b0
        L_0x009d:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b0
            r15 = r33
            boolean r16 = r2.changed((float) r15)
            if (r16 == 0) goto L_0x00ab
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00ab:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00ad:
            r3 = r3 | r16
            goto L_0x00b2
        L_0x00b0:
            r15 = r33
        L_0x00b2:
            r16 = r37 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00bb
            r3 = r3 | r17
            goto L_0x00cc
        L_0x00bb:
            r16 = r10 & r17
            if (r16 != 0) goto L_0x00cc
            boolean r16 = r2.changedInstance(r9)
            if (r16 == 0) goto L_0x00c8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ca
        L_0x00c8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ca:
            r3 = r3 | r16
        L_0x00cc:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r5) goto L_0x00e9
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00dd
            goto L_0x00e9
        L_0x00dd:
            r2.skipToGroupEnd()
            r3 = r27
            r4 = r7
            r6 = r11
            r24 = r13
            r8 = r15
            goto L_0x01c4
        L_0x00e9:
            r2.startDefaults()
            r0 = r10 & 1
            r5 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0110
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00fa
            goto L_0x0110
        L_0x00fa:
            r2.skipToGroupEnd()
            r0 = r37 & 8
            if (r0 == 0) goto L_0x0103
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0103:
            r0 = r37 & 16
            if (r0 == 0) goto L_0x0108
            r3 = r3 & r5
        L_0x0108:
            r0 = r27
            r4 = r7
            r6 = r11
            r24 = r13
        L_0x010e:
            r5 = r15
            goto L_0x014d
        L_0x0110:
            if (r4 == 0) goto L_0x0117
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0119
        L_0x0117:
            r0 = r27
        L_0x0119:
            if (r6 == 0) goto L_0x0120
            androidx.compose.ui.graphics.Shape r4 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x0121
        L_0x0120:
            r4 = r7
        L_0x0121:
            r6 = r37 & 8
            if (r6 == 0) goto L_0x012f
            androidx.compose.material3.DrawerDefaults r6 = androidx.compose.material3.DrawerDefaults.INSTANCE
            r7 = 6
            long r6 = r6.getContainerColor(r2, r7)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0130
        L_0x012f:
            r6 = r11
        L_0x0130:
            r11 = r37 & 16
            if (r11 == 0) goto L_0x013e
            int r11 = r3 >> 9
            r11 = r11 & 14
            long r11 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r6, r2, r11)
            r3 = r3 & r5
            goto L_0x013f
        L_0x013e:
            r11 = r13
        L_0x013f:
            if (r8 == 0) goto L_0x014a
            androidx.compose.material3.DrawerDefaults r5 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r5 = r5.m1826getPermanentDrawerElevationD9Ej5fM()
            r24 = r11
            goto L_0x014d
        L_0x014a:
            r24 = r11
            goto L_0x010e
        L_0x014d:
            r2.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x015f
            r8 = -1
            java.lang.String r11 = "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:632)"
            r12 = 175072821(0xa6f6635, float:1.15266544E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r3, r8, r11)
        L_0x015f:
            float r8 = MinimumDrawerWidth
            androidx.compose.material3.DrawerDefaults r11 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r11 = r11.m1824getMaximumDrawerWidthD9Ej5fM()
            r12 = 10
            r13 = 0
            r14 = 0
            r15 = 0
            r27 = r0
            r28 = r8
            r29 = r14
            r30 = r11
            r31 = r15
            r32 = r12
            r33 = r13
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m746sizeInqDBjuR0$default(r27, r28, r29, r30, r31, r32, r33)
            r11 = 0
            r12 = 0
            r13 = 1
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r8, r11, r13, r12)
            androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1 r8 = new androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
            r8.<init>(r1, r9)
            r12 = 959363152(0x392eb850, float:1.6662595E-4)
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r12, r13, r8)
            r20 = r8
            kotlin.jvm.functions.Function2 r20 = (kotlin.jvm.functions.Function2) r20
            int r3 = r3 >> 3
            r8 = r3 & 112(0x70, float:1.57E-43)
            r12 = 12582912(0xc00000, float:1.7632415E-38)
            r8 = r8 | r12
            r12 = r3 & 896(0x380, float:1.256E-42)
            r8 = r8 | r12
            r12 = r3 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r12
            r22 = r8 | r3
            r23 = 96
            r18 = 0
            r19 = 0
            r12 = r4
            r13 = r6
            r15 = r24
            r17 = r5
            r21 = r2
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01c2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c2:
            r3 = r0
            r8 = r5
        L_0x01c4:
            androidx.compose.runtime.ScopeUpdateScope r12 = r2.endRestartGroup()
            if (r12 == 0) goto L_0x01e2
            androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2 r13 = new androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
            r0 = r13
            r1 = r26
            r2 = r3
            r3 = r4
            r4 = r6
            r6 = r24
            r9 = r34
            r10 = r36
            r11 = r37
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x01e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2010DrawerSheetvywBR7E(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationDrawerItem(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, boolean r36, kotlin.jvm.functions.Function0<kotlin.Unit> r37, androidx.compose.ui.Modifier r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.NavigationDrawerItemColors r42, androidx.compose.foundation.interaction.MutableInteractionSource r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r14 = r36
            r12 = r45
            r4 = r46
            r0 = -1304626543(0xffffffffb23cfa91, float:-1.10000125E-8)
            r1 = r44
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)729@28081L5,730@28158L8,731@28218L39,741@28543L24,733@28266L1246:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r4 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r12 | 6
            r11 = r35
            goto L_0x002f
        L_0x001d:
            r2 = r12 & 6
            r11 = r35
            if (r2 != 0) goto L_0x002e
            boolean r2 = r1.changedInstance(r11)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r12
            goto L_0x002f
        L_0x002e:
            r2 = r12
        L_0x002f:
            r3 = r4 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0046
        L_0x0036:
            r3 = r12 & 48
            if (r3 != 0) goto L_0x0046
            boolean r3 = r1.changed((boolean) r14)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r2 = r2 | r3
        L_0x0046:
            r3 = r4 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            r10 = r37
            goto L_0x0061
        L_0x004f:
            r3 = r12 & 384(0x180, float:5.38E-43)
            r10 = r37
            if (r3 != 0) goto L_0x0061
            boolean r3 = r1.changedInstance(r10)
            if (r3 == 0) goto L_0x005e
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r3
        L_0x0061:
            r3 = r4 & 8
            if (r3 == 0) goto L_0x0068
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r5 = r12 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007b
            r5 = r38
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0077
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r6
            goto L_0x007d
        L_0x007b:
            r5 = r38
        L_0x007d:
            r6 = r4 & 16
            if (r6 == 0) goto L_0x0084
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r7 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0097
            r7 = r39
            boolean r8 = r1.changedInstance(r7)
            if (r8 == 0) goto L_0x0093
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r2 = r2 | r8
            goto L_0x0099
        L_0x0097:
            r7 = r39
        L_0x0099:
            r8 = r4 & 32
            r9 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a1
            r2 = r2 | r9
            goto L_0x00b3
        L_0x00a1:
            r9 = r9 & r12
            if (r9 != 0) goto L_0x00b3
            r9 = r40
            boolean r13 = r1.changedInstance(r9)
            if (r13 == 0) goto L_0x00af
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r2 = r2 | r13
            goto L_0x00b5
        L_0x00b3:
            r9 = r40
        L_0x00b5:
            r13 = 1572864(0x180000, float:2.204052E-39)
            r13 = r13 & r12
            if (r13 != 0) goto L_0x00cf
            r13 = r4 & 64
            if (r13 != 0) goto L_0x00c9
            r13 = r41
            boolean r15 = r1.changed((java.lang.Object) r13)
            if (r15 == 0) goto L_0x00cb
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00c9:
            r13 = r41
        L_0x00cb:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r2 = r2 | r15
            goto L_0x00d1
        L_0x00cf:
            r13 = r41
        L_0x00d1:
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00ec
            r15 = r4 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00e5
            r15 = r42
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00e7
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00e5:
            r15 = r42
        L_0x00e7:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e9:
            r2 = r2 | r16
            goto L_0x00ee
        L_0x00ec:
            r15 = r42
        L_0x00ee:
            r0 = r4 & 256(0x100, float:3.59E-43)
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00f9
            r2 = r2 | r16
            r5 = r43
            goto L_0x010c
        L_0x00f9:
            r16 = r12 & r16
            r5 = r43
            if (r16 != 0) goto L_0x010c
            boolean r16 = r1.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x0108
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010a
        L_0x0108:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010a:
            r2 = r2 | r16
        L_0x010c:
            r16 = 38347923(0x2492493, float:1.4777644E-37)
            r5 = r2 & r16
            r7 = 38347922(0x2492492, float:1.4777643E-37)
            if (r5 != r7) goto L_0x012d
            boolean r5 = r1.getSkipping()
            if (r5 != 0) goto L_0x011d
            goto L_0x012d
        L_0x011d:
            r1.skipToGroupEnd()
            r4 = r38
            r5 = r39
            r24 = r1
            r6 = r9
            r7 = r13
            r8 = r15
            r9 = r43
            goto L_0x0280
        L_0x012d:
            r1.startDefaults()
            r5 = r12 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r7 = 0
            if (r5 == 0) goto L_0x015e
            boolean r5 = r1.getDefaultsInvalid()
            if (r5 == 0) goto L_0x013f
            goto L_0x015e
        L_0x013f:
            r1.skipToGroupEnd()
            r0 = r4 & 64
            if (r0 == 0) goto L_0x0148
            r2 = r2 & r16
        L_0x0148:
            r0 = r4 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0150
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r0
        L_0x0150:
            r0 = r38
            r18 = r39
            r21 = r43
            r3 = r2
            r19 = r9
            r20 = r13
            r9 = r15
            goto L_0x01dc
        L_0x015e:
            if (r3 == 0) goto L_0x0165
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0167
        L_0x0165:
            r3 = r38
        L_0x0167:
            if (r6 == 0) goto L_0x016b
            r5 = r7
            goto L_0x016d
        L_0x016b:
            r5 = r39
        L_0x016d:
            if (r8 == 0) goto L_0x0170
            r9 = r7
        L_0x0170:
            r6 = r4 & 64
            if (r6 == 0) goto L_0x0182
            androidx.compose.material3.tokens.NavigationDrawerTokens r6 = androidx.compose.material3.tokens.NavigationDrawerTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r6 = r6.getActiveIndicatorShape()
            r8 = 6
            androidx.compose.ui.graphics.Shape r6 = androidx.compose.material3.ShapesKt.getValue(r6, r1, r8)
            r2 = r2 & r16
            goto L_0x0183
        L_0x0182:
            r6 = r13
        L_0x0183:
            r8 = r4 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x01a8
            androidx.compose.material3.NavigationDrawerItemDefaults r15 = androidx.compose.material3.NavigationDrawerItemDefaults.INSTANCE
            r33 = 100663296(0x6000000, float:2.4074124E-35)
            r34 = 255(0xff, float:3.57E-43)
            r16 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r28 = 0
            r30 = 0
            r32 = r1
            androidx.compose.material3.NavigationDrawerItemColors r8 = r15.m2008colorsoq7We08(r16, r18, r20, r22, r24, r26, r28, r30, r32, r33, r34)
            r13 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r13
            goto L_0x01a9
        L_0x01a8:
            r8 = r15
        L_0x01a9:
            if (r0 == 0) goto L_0x01d1
            r0 = 111536735(0x6a5ea5f, float:6.241048E-35)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            java.lang.Object r0 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r0 != r13) goto L_0x01c9
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r0)
        L_0x01c9:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r1.endReplaceableGroup()
            r21 = r0
            goto L_0x01d3
        L_0x01d1:
            r21 = r43
        L_0x01d3:
            r0 = r3
            r18 = r5
            r20 = r6
            r19 = r9
            r3 = r2
            r9 = r8
        L_0x01dc:
            r1.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01ee
            r2 = -1
            java.lang.String r5 = "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:732)"
            r6 = -1304626543(0xffffffffb23cfa91, float:-1.10000125E-8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r3, r2, r5)
        L_0x01ee:
            androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2 r2 = androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r5 = 0
            r8 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r5, r2, r8, r7)
            androidx.compose.material3.tokens.NavigationDrawerTokens r5 = androidx.compose.material3.tokens.NavigationDrawerTokens.INSTANCE
            float r5 = r5.m2970getActiveIndicatorHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r2, r5)
            r5 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r5, r8, r7)
            int r7 = r3 >> 3
            r5 = r7 & 14
            int r6 = r3 >> 18
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.runtime.State r5 = r9.containerColor(r14, r1, r5)
            java.lang.Object r5 = r5.getValue()
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r5 = r5.m3826unboximpl()
            androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3 r13 = new androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
            r38 = r13
            r39 = r18
            r40 = r9
            r41 = r36
            r42 = r19
            r43 = r35
            r38.<init>(r39, r40, r41, r42, r43)
            r15 = 191488423(0xb69e1a7, float:4.504393E-32)
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r15, r8, r13)
            r13 = r8
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r7 = r7 & 126(0x7e, float:1.77E-43)
            int r8 = r3 >> 6
            r15 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r15
            r15 = r7 | r8
            int r3 = r3 >> 24
            r3 = r3 & 14
            r16 = r3 | 48
            r17 = 968(0x3c8, float:1.356E-42)
            r3 = 0
            r7 = 0
            r22 = 0
            r23 = r9
            r9 = r22
            r10 = r22
            r22 = 0
            r11 = r22
            r22 = r0
            r0 = r36
            r24 = r1
            r1 = r37
            r4 = r20
            r12 = r21
            r14 = r24
            androidx.compose.material3.SurfaceKt.m2304Surfaced85dljk((boolean) r0, (kotlin.jvm.functions.Function0<kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (androidx.compose.ui.graphics.Shape) r4, (long) r5, (long) r7, (float) r9, (float) r10, (androidx.compose.foundation.BorderStroke) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16, (int) r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0274
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0274:
            r5 = r18
            r6 = r19
            r7 = r20
            r9 = r21
            r4 = r22
            r8 = r23
        L_0x0280:
            androidx.compose.runtime.ScopeUpdateScope r12 = r24.endRestartGroup()
            if (r12 == 0) goto L_0x029b
            androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$4 r13 = new androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$4
            r0 = r13
            r1 = r35
            r2 = r36
            r3 = r37
            r10 = r45
            r11 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x029b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.NavigationDrawerItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc  reason: not valid java name */
    public static final void m2014ScrimBx497Mc(boolean z, Function0<Unit> function0, Function0<Float> function02, long j, Composer composer, int i) {
        int i2;
        Modifier modifier;
        int i3;
        boolean z2 = z;
        Function0<Unit> function03 = function0;
        Function0<Float> function04 = function02;
        long j2 = j;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)919@35520L30,935@35964L51,931@35873L142:NavigationDrawer.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changed(z2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function03) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function04) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:918)");
            }
            Strings.Companion companion = Strings.Companion;
            String r0 = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.close_drawer), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1858700652);
            ComposerKt.sourceInformation(startRestartGroup, "922@35639L35,923@35723L108");
            if (z2) {
                Modifier modifier2 = Modifier.Companion;
                startRestartGroup.startReplaceableGroup(-1858700588);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i5 = i2 & 112;
                boolean z3 = i5 == 32;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function03, (Continuation<? super NavigationDrawerKt$Scrim$dismissDrawer$1$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) function03, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                startRestartGroup.startReplaceableGroup(-1858700504);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean changed = (i5 == 32) | startRestartGroup.changed((Object) r0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new NavigationDrawerKt$Scrim$dismissDrawer$2$1(r0, function03);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                i3 = 1;
                modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
            } else {
                i3 = 1;
                modifier = Modifier.Companion;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i3, (Object) null).then(modifier);
            startRestartGroup.startReplaceableGroup(-1858700263);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i6 = ((i2 & 7168) == 2048 ? i3 : 0) | ((i2 & 896) == 256 ? i3 : 0);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (i6 != 0 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new NavigationDrawerKt$Scrim$1$1(j2, function04);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationDrawerKt$Scrim$2(z, function0, function02, j, i));
        }
    }
}
