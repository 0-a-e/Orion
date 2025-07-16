package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a¤\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0001\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0001\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a \u0001\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a¤\u0001\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001e\u001a\u0001\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010#\u001a\u0001\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010#\u001an\u00100\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a~\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00102\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "Landroidx/compose/material3/TabIndicatorScope;", "Lkotlin/ExtensionFunctionType;", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImp", "ScrollableTabRowImp-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabRowKt {
    /* access modifiers changed from: private */
    public static final float ScrollableTabRowMinimumTabWidth = Dp.m6614constructorimpl((float) 90);
    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ea  */
    /* renamed from: PrimaryTabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2356PrimaryTabRowpAZo6Ak(int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r21
            r10 = r31
            r0 = -1884787284(0xffffffff8fa86dac, float:-1.6608323E-29)
            r2 = r30
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)150@7456L21,151@7520L19,166@7964L76:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((int) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r22
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r22
        L_0x0045:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r32 & 4
            if (r6 != 0) goto L_0x0058
            r6 = r23
            boolean r8 = r2.changed((long) r6)
            if (r8 == 0) goto L_0x005a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r6 = r23
        L_0x005a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r8
            goto L_0x0060
        L_0x005e:
            r6 = r23
        L_0x0060:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r32 & 8
            if (r8 != 0) goto L_0x0073
            r8 = r25
            boolean r11 = r2.changed((long) r8)
            if (r11 == 0) goto L_0x0075
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r8 = r25
        L_0x0075:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r11
            goto L_0x007b
        L_0x0079:
            r8 = r25
        L_0x007b:
            r11 = r32 & 16
            if (r11 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r27
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x0091
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r13
            goto L_0x0097
        L_0x0095:
            r12 = r27
        L_0x0097:
            r13 = r32 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x009f
            r3 = r3 | r14
            goto L_0x00b1
        L_0x009f:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b1
            r14 = r28
            boolean r15 = r2.changedInstance(r14)
            if (r15 == 0) goto L_0x00ad
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r15
            goto L_0x00b3
        L_0x00b1:
            r14 = r28
        L_0x00b3:
            r15 = r32 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bc
            r3 = r3 | r16
            goto L_0x00d0
        L_0x00bc:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d0
            r15 = r29
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r15 = r29
        L_0x00d2:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r5) goto L_0x00ea
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00e3
            goto L_0x00ea
        L_0x00e3:
            r2.skipToGroupEnd()
            r3 = r22
            goto L_0x0180
        L_0x00ea:
            r2.startDefaults()
            r0 = r10 & 1
            if (r0 == 0) goto L_0x010d
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00f8
            goto L_0x010d
        L_0x00f8:
            r2.skipToGroupEnd()
            r0 = r32 & 4
            if (r0 == 0) goto L_0x0101
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0101:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x0107
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0107:
            r0 = r22
            r4 = r8
            r8 = r12
        L_0x010b:
            r9 = r14
            goto L_0x014c
        L_0x010d:
            if (r4 == 0) goto L_0x0114
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0116
        L_0x0114:
            r0 = r22
        L_0x0116:
            r4 = r32 & 4
            r5 = 6
            if (r4 == 0) goto L_0x0123
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r4.getPrimaryContainerColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0123:
            r4 = r32 & 8
            if (r4 == 0) goto L_0x0130
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r4 = r4.getPrimaryContentColor(r2, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0131
        L_0x0130:
            r4 = r8
        L_0x0131:
            if (r11 == 0) goto L_0x0143
            androidx.compose.material3.TabRowKt$PrimaryTabRow$1 r8 = new androidx.compose.material3.TabRowKt$PrimaryTabRow$1
            r8.<init>(r1)
            r9 = -2021049253(0xffffffff87893c5b, float:-2.0648943E-34)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r9, r11, r8)
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            goto L_0x0144
        L_0x0143:
            r8 = r12
        L_0x0144:
            if (r13 == 0) goto L_0x010b
            androidx.compose.material3.ComposableSingletons$TabRowKt r9 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r9 = r9.m1724getLambda1$material3_release()
        L_0x014c:
            r2.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x015e
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.PrimaryTabRow (TabRow.kt:165)"
            r13 = -1884787284(0xffffffff8fa86dac, float:-1.6608323E-29)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r3, r11, r12)
        L_0x015e:
            int r3 = r3 >> 3
            r11 = 524286(0x7fffe, float:7.34681E-40)
            r20 = r3 & r11
            r11 = r0
            r12 = r6
            r14 = r4
            r16 = r8
            r17 = r9
            r18 = r29
            r19 = r2
            m2362TabRowImplDTcfvLk(r11, r12, r14, r16, r17, r18, r19, r20)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x017c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017c:
            r3 = r0
            r12 = r8
            r14 = r9
            r8 = r4
        L_0x0180:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x019e
            androidx.compose.material3.TabRowKt$PrimaryTabRow$2 r15 = new androidx.compose.material3.TabRowKt$PrimaryTabRow$2
            r0 = r15
            r1 = r21
            r2 = r3
            r3 = r6
            r5 = r8
            r7 = r12
            r8 = r14
            r9 = r29
            r10 = r31
            r11 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r13.updateScope(r15)
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2356PrimaryTabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ea  */
    /* renamed from: SecondaryTabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2360SecondaryTabRowpAZo6Ak(int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r21
            r10 = r31
            r0 = -1909540706(0xffffffff8e2eb89e, float:-2.1536046E-30)
            r2 = r30
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)207@10434L23,208@10500L21,219@10867L76:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((int) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r22
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r22
        L_0x0045:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r32 & 4
            if (r6 != 0) goto L_0x0058
            r6 = r23
            boolean r8 = r2.changed((long) r6)
            if (r8 == 0) goto L_0x005a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r6 = r23
        L_0x005a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r8
            goto L_0x0060
        L_0x005e:
            r6 = r23
        L_0x0060:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r32 & 8
            if (r8 != 0) goto L_0x0073
            r8 = r25
            boolean r11 = r2.changed((long) r8)
            if (r11 == 0) goto L_0x0075
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r8 = r25
        L_0x0075:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r11
            goto L_0x007b
        L_0x0079:
            r8 = r25
        L_0x007b:
            r11 = r32 & 16
            if (r11 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r27
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x0091
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r13
            goto L_0x0097
        L_0x0095:
            r12 = r27
        L_0x0097:
            r13 = r32 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x009f
            r3 = r3 | r14
            goto L_0x00b1
        L_0x009f:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b1
            r14 = r28
            boolean r15 = r2.changedInstance(r14)
            if (r15 == 0) goto L_0x00ad
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r15
            goto L_0x00b3
        L_0x00b1:
            r14 = r28
        L_0x00b3:
            r15 = r32 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bc
            r3 = r3 | r16
            goto L_0x00d0
        L_0x00bc:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d0
            r15 = r29
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r15 = r29
        L_0x00d2:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r5) goto L_0x00ea
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00e3
            goto L_0x00ea
        L_0x00e3:
            r2.skipToGroupEnd()
            r3 = r22
            goto L_0x0180
        L_0x00ea:
            r2.startDefaults()
            r0 = r10 & 1
            if (r0 == 0) goto L_0x010d
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00f8
            goto L_0x010d
        L_0x00f8:
            r2.skipToGroupEnd()
            r0 = r32 & 4
            if (r0 == 0) goto L_0x0101
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0101:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x0107
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0107:
            r0 = r22
            r4 = r8
            r8 = r12
        L_0x010b:
            r9 = r14
            goto L_0x014c
        L_0x010d:
            if (r4 == 0) goto L_0x0114
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0116
        L_0x0114:
            r0 = r22
        L_0x0116:
            r4 = r32 & 4
            r5 = 6
            if (r4 == 0) goto L_0x0123
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r4.getSecondaryContainerColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0123:
            r4 = r32 & 8
            if (r4 == 0) goto L_0x0130
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r4 = r4.getSecondaryContentColor(r2, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0131
        L_0x0130:
            r4 = r8
        L_0x0131:
            if (r11 == 0) goto L_0x0143
            androidx.compose.material3.TabRowKt$SecondaryTabRow$1 r8 = new androidx.compose.material3.TabRowKt$SecondaryTabRow$1
            r8.<init>(r1)
            r9 = 286693261(0x1116978d, float:1.1879614E-28)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r9, r11, r8)
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            goto L_0x0144
        L_0x0143:
            r8 = r12
        L_0x0144:
            if (r13 == 0) goto L_0x010b
            androidx.compose.material3.ComposableSingletons$TabRowKt r9 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r9 = r9.m1725getLambda2$material3_release()
        L_0x014c:
            r2.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x015e
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.SecondaryTabRow (TabRow.kt:218)"
            r13 = -1909540706(0xffffffff8e2eb89e, float:-2.1536046E-30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r3, r11, r12)
        L_0x015e:
            int r3 = r3 >> 3
            r11 = 524286(0x7fffe, float:7.34681E-40)
            r20 = r3 & r11
            r11 = r0
            r12 = r6
            r14 = r4
            r16 = r8
            r17 = r9
            r18 = r29
            r19 = r2
            m2362TabRowImplDTcfvLk(r11, r12, r14, r16, r17, r18, r19, r20)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x017c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017c:
            r3 = r0
            r12 = r8
            r14 = r9
            r8 = r4
        L_0x0180:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x019e
            androidx.compose.material3.TabRowKt$SecondaryTabRow$2 r15 = new androidx.compose.material3.TabRowKt$SecondaryTabRow$2
            r0 = r15
            r1 = r21
            r2 = r3
            r3 = r6
            r5 = r8
            r7 = r12
            r8 = r14
            r9 = r29
            r10 = r31
            r11 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r13.updateScope(r15)
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2360SecondaryTabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ea  */
    /* renamed from: TabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2361TabRowpAZo6Ak(int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r21
            r10 = r31
            r0 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            r2 = r30
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)299@15165L21,300@15229L19,313@15685L90:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((int) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r22
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r22
        L_0x0045:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r32 & 4
            if (r6 != 0) goto L_0x0058
            r6 = r23
            boolean r8 = r2.changed((long) r6)
            if (r8 == 0) goto L_0x005a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r6 = r23
        L_0x005a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r8
            goto L_0x0060
        L_0x005e:
            r6 = r23
        L_0x0060:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r32 & 8
            if (r8 != 0) goto L_0x0073
            r8 = r25
            boolean r11 = r2.changed((long) r8)
            if (r11 == 0) goto L_0x0075
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r8 = r25
        L_0x0075:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r11
            goto L_0x007b
        L_0x0079:
            r8 = r25
        L_0x007b:
            r11 = r32 & 16
            if (r11 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r27
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x0091
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r13
            goto L_0x0097
        L_0x0095:
            r12 = r27
        L_0x0097:
            r13 = r32 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x009f
            r3 = r3 | r14
            goto L_0x00b1
        L_0x009f:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b1
            r14 = r28
            boolean r15 = r2.changedInstance(r14)
            if (r15 == 0) goto L_0x00ad
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r15
            goto L_0x00b3
        L_0x00b1:
            r14 = r28
        L_0x00b3:
            r15 = r32 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bc
            r3 = r3 | r16
            goto L_0x00d0
        L_0x00bc:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d0
            r15 = r29
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r15 = r29
        L_0x00d2:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r5) goto L_0x00ea
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00e3
            goto L_0x00ea
        L_0x00e3:
            r2.skipToGroupEnd()
            r3 = r22
            goto L_0x0180
        L_0x00ea:
            r2.startDefaults()
            r0 = r10 & 1
            if (r0 == 0) goto L_0x010d
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00f8
            goto L_0x010d
        L_0x00f8:
            r2.skipToGroupEnd()
            r0 = r32 & 4
            if (r0 == 0) goto L_0x0101
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0101:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x0107
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0107:
            r0 = r22
            r4 = r8
            r8 = r12
        L_0x010b:
            r9 = r14
            goto L_0x014c
        L_0x010d:
            if (r4 == 0) goto L_0x0114
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0116
        L_0x0114:
            r0 = r22
        L_0x0116:
            r4 = r32 & 4
            r5 = 6
            if (r4 == 0) goto L_0x0123
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r4.getPrimaryContainerColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0123:
            r4 = r32 & 8
            if (r4 == 0) goto L_0x0130
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r4 = r4.getPrimaryContentColor(r2, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0131
        L_0x0130:
            r4 = r8
        L_0x0131:
            if (r11 == 0) goto L_0x0143
            androidx.compose.material3.TabRowKt$TabRow$1 r8 = new androidx.compose.material3.TabRowKt$TabRow$1
            r8.<init>(r1)
            r9 = -2052073983(0xffffffff85afd601, float:-1.6535534E-35)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r9, r11, r8)
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            goto L_0x0144
        L_0x0143:
            r8 = r12
        L_0x0144:
            if (r13 == 0) goto L_0x010b
            androidx.compose.material3.ComposableSingletons$TabRowKt r9 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r9 = r9.m1726getLambda3$material3_release()
        L_0x014c:
            r2.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x015e
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.TabRow (TabRow.kt:312)"
            r13 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r3, r11, r12)
        L_0x015e:
            int r3 = r3 >> 3
            r11 = 524286(0x7fffe, float:7.34681E-40)
            r20 = r3 & r11
            r11 = r0
            r12 = r6
            r14 = r4
            r16 = r8
            r17 = r9
            r18 = r29
            r19 = r2
            m2363TabRowWithSubcomposeImplDTcfvLk(r11, r12, r14, r16, r17, r18, r19, r20)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x017c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017c:
            r3 = r0
            r12 = r8
            r14 = r9
            r8 = r4
        L_0x0180:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x019e
            androidx.compose.material3.TabRowKt$TabRow$2 r15 = new androidx.compose.material3.TabRowKt$TabRow$2
            r0 = r15
            r1 = r21
            r2 = r3
            r3 = r6
            r5 = r8
            r7 = r12
            r8 = r14
            r9 = r29
            r10 = r31
            r11 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r13.updateScope(r15)
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2361TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TabRowImpl-DTcfvLk  reason: not valid java name */
    public static final void m2362TabRowImplDTcfvLk(Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)366@17359L4073:TabRow.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        } else {
            long j3 = j;
        }
        long j4 = j2;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, i2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:365)");
            }
            int i4 = i2 << 3;
            SurfaceKt.m2303SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier), (Shape) null, j, j2, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(startRestartGroup, -65106680, true, new TabRowKt$TabRowImpl$1(function24, function23, function32)), startRestartGroup, (i4 & 896) | 12582912 | (i4 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowKt$TabRowImpl$2(modifier, j, j2, function3, function2, function22, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk  reason: not valid java name */
    public static final void m2363TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)583@24853L2206:TabRow.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        } else {
            long j3 = j;
        }
        long j4 = j2;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
        }
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, i2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:582)");
            }
            int i4 = i2 << 3;
            SurfaceKt.m2303SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier), (Shape) null, j, j2, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1617702432, true, new TabRowKt$TabRowWithSubcomposeImpl$1(function24, function23, function32)), startRestartGroup, (i4 & 896) | 12582912 | (i4 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowKt$TabRowWithSubcomposeImpl$2(modifier, j, j2, function3, function2, function22, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f9  */
    /* renamed from: PrimaryScrollableTabRow-qhFBPw4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2355PrimaryScrollableTabRowqhFBPw4(int r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.ScrollState r30, long r31, long r33, float r35, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r14 = r28
            r15 = r40
            r13 = r41
            r0 = -1763241113(0xffffffff96e71367, float:-3.7332307E-25)
            r1 = r39
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)677@29409L21,678@29475L21,679@29539L19,695@30196L327:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r15 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r15 & 6
            if (r1 != 0) goto L_0x002a
            boolean r1 = r12.changed((int) r14)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r15
            goto L_0x002b
        L_0x002a:
            r1 = r15
        L_0x002b:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r15 & 48
            if (r3 != 0) goto L_0x0045
            r3 = r29
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r29
        L_0x0047:
            r4 = r15 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0060
            r4 = r13 & 4
            if (r4 != 0) goto L_0x005a
            r4 = r30
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r4 = r30
        L_0x005c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r5
            goto L_0x0062
        L_0x0060:
            r4 = r30
        L_0x0062:
            r5 = r15 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007b
            r5 = r13 & 8
            if (r5 != 0) goto L_0x0075
            r5 = r31
            boolean r7 = r12.changed((long) r5)
            if (r7 == 0) goto L_0x0077
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r5 = r31
        L_0x0077:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r7
            goto L_0x007d
        L_0x007b:
            r5 = r31
        L_0x007d:
            r7 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0096
            r7 = r13 & 16
            if (r7 != 0) goto L_0x0090
            r7 = r33
            boolean r9 = r12.changed((long) r7)
            if (r9 == 0) goto L_0x0092
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0090:
            r7 = r33
        L_0x0092:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r1 = r1 | r9
            goto L_0x0098
        L_0x0096:
            r7 = r33
        L_0x0098:
            r9 = r13 & 32
            r10 = 196608(0x30000, float:2.75506E-40)
            if (r9 == 0) goto L_0x00a0
            r1 = r1 | r10
            goto L_0x00b2
        L_0x00a0:
            r10 = r10 & r15
            if (r10 != 0) goto L_0x00b2
            r10 = r35
            boolean r11 = r12.changed((float) r10)
            if (r11 == 0) goto L_0x00ae
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r1 = r1 | r11
            goto L_0x00b4
        L_0x00b2:
            r10 = r35
        L_0x00b4:
            r11 = r13 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r11 == 0) goto L_0x00bf
            r1 = r1 | r16
            r0 = r36
            goto L_0x00d2
        L_0x00bf:
            r16 = r15 & r16
            r0 = r36
            if (r16 != 0) goto L_0x00d2
            boolean r17 = r12.changedInstance(r0)
            if (r17 == 0) goto L_0x00ce
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r17
        L_0x00d2:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00dd
            r1 = r1 | r17
            r3 = r37
            goto L_0x00f0
        L_0x00dd:
            r17 = r15 & r17
            r3 = r37
            if (r17 != 0) goto L_0x00f0
            boolean r17 = r12.changedInstance(r3)
            if (r17 == 0) goto L_0x00ec
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r1 = r1 | r17
        L_0x00f0:
            r3 = r13 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x00f9
            r1 = r1 | r17
            goto L_0x010d
        L_0x00f9:
            r3 = r15 & r17
            if (r3 != 0) goto L_0x010d
            r3 = r38
            boolean r17 = r12.changedInstance(r3)
            if (r17 == 0) goto L_0x0108
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010a
        L_0x0108:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010a:
            r1 = r1 | r17
            goto L_0x010f
        L_0x010d:
            r3 = r38
        L_0x010f:
            r17 = 38347923(0x2492493, float:1.4777644E-37)
            r3 = r1 & r17
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r4) goto L_0x0132
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x0120
            goto L_0x0132
        L_0x0120:
            r12.skipToGroupEnd()
            r2 = r29
            r3 = r30
            r9 = r36
            r4 = r5
            r6 = r7
            r8 = r10
            r27 = r12
            r10 = r37
            goto L_0x0241
        L_0x0132:
            r12.startDefaults()
            r3 = r15 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x0167
            boolean r3 = r12.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0143
            goto L_0x0167
        L_0x0143:
            r12.skipToGroupEnd()
            r0 = r13 & 4
            if (r0 == 0) goto L_0x014c
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014c:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0152
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0152:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0157
            r1 = r1 & r4
        L_0x0157:
            r17 = r29
            r18 = r30
            r24 = r36
            r25 = r37
            r19 = r5
            r21 = r7
            r23 = r10
            goto L_0x01d1
        L_0x0167:
            if (r2 == 0) goto L_0x016e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0170
        L_0x016e:
            r2 = r29
        L_0x0170:
            r3 = r13 & 4
            r4 = 1
            if (r3 == 0) goto L_0x017d
            r3 = 0
            androidx.compose.foundation.ScrollState r3 = androidx.compose.foundation.ScrollKt.rememberScrollState(r3, r12, r3, r4)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x017f
        L_0x017d:
            r3 = r30
        L_0x017f:
            r17 = r13 & 8
            r4 = 6
            if (r17 == 0) goto L_0x018c
            androidx.compose.material3.TabRowDefaults r5 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r5 = r5.getPrimaryContainerColor(r12, r4)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x018c:
            r17 = r13 & 16
            if (r17 == 0) goto L_0x019a
            androidx.compose.material3.TabRowDefaults r7 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r7 = r7.getPrimaryContentColor(r12, r4)
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r4
        L_0x019a:
            if (r9 == 0) goto L_0x01a3
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            float r4 = r4.m2354getScrollableTabRowEdgeStartPaddingD9Ej5fM()
            goto L_0x01a4
        L_0x01a3:
            r4 = r10
        L_0x01a4:
            if (r11 == 0) goto L_0x01b6
            androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1 r9 = new androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
            r9.<init>(r14)
            r10 = 438091970(0x1a1cc0c2, float:3.2415752E-23)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r10, r11, r9)
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            goto L_0x01b8
        L_0x01b6:
            r9 = r36
        L_0x01b8:
            if (r0 == 0) goto L_0x01c3
            androidx.compose.material3.ComposableSingletons$TabRowKt r0 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1727getLambda4$material3_release()
            r25 = r0
            goto L_0x01c5
        L_0x01c3:
            r25 = r37
        L_0x01c5:
            r17 = r2
            r18 = r3
            r23 = r4
            r19 = r5
            r21 = r7
            r24 = r9
        L_0x01d1:
            r12.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01e3
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:694)"
            r3 = -1763241113(0xffffffff96e71367, float:-3.7332307E-25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x01e3:
            r0 = r1 & 14
            int r2 = r1 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r1 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r1 >> 3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r0 = r0 | r2
            int r1 = r1 << 18
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r2
            r16 = r0 | r1
            r26 = 0
            r0 = r28
            r1 = r24
            r2 = r17
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r25
            r9 = r38
            r10 = r18
            r11 = r12
            r27 = r12
            r12 = r16
            r13 = r26
            m2358ScrollableTabRowImpqhFBPw4(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0233
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0233:
            r2 = r17
            r3 = r18
            r4 = r19
            r6 = r21
            r8 = r23
            r9 = r24
            r10 = r25
        L_0x0241:
            androidx.compose.runtime.ScopeUpdateScope r13 = r27.endRestartGroup()
            if (r13 == 0) goto L_0x025e
            androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2 r16 = new androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2
            r0 = r16
            r1 = r28
            r11 = r38
            r12 = r40
            r14 = r13
            r13 = r41
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x025e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2355PrimaryScrollableTabRowqhFBPw4(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f9  */
    /* renamed from: SecondaryScrollableTabRow-qhFBPw4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2359SecondaryScrollableTabRowqhFBPw4(int r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.ScrollState r30, long r31, long r33, float r35, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r14 = r28
            r15 = r40
            r13 = r41
            r0 = 1821940917(0x6c989cb5, float:1.475974E27)
            r1 = r39
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)749@33144L21,750@33210L23,751@33276L21,763@33731L326:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r15 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r15 & 6
            if (r1 != 0) goto L_0x002a
            boolean r1 = r12.changed((int) r14)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r15
            goto L_0x002b
        L_0x002a:
            r1 = r15
        L_0x002b:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r15 & 48
            if (r3 != 0) goto L_0x0045
            r3 = r29
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r29
        L_0x0047:
            r4 = r15 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0060
            r4 = r13 & 4
            if (r4 != 0) goto L_0x005a
            r4 = r30
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r4 = r30
        L_0x005c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r5
            goto L_0x0062
        L_0x0060:
            r4 = r30
        L_0x0062:
            r5 = r15 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007b
            r5 = r13 & 8
            if (r5 != 0) goto L_0x0075
            r5 = r31
            boolean r7 = r12.changed((long) r5)
            if (r7 == 0) goto L_0x0077
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r5 = r31
        L_0x0077:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r7
            goto L_0x007d
        L_0x007b:
            r5 = r31
        L_0x007d:
            r7 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0096
            r7 = r13 & 16
            if (r7 != 0) goto L_0x0090
            r7 = r33
            boolean r9 = r12.changed((long) r7)
            if (r9 == 0) goto L_0x0092
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0090:
            r7 = r33
        L_0x0092:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r1 = r1 | r9
            goto L_0x0098
        L_0x0096:
            r7 = r33
        L_0x0098:
            r9 = r13 & 32
            r10 = 196608(0x30000, float:2.75506E-40)
            if (r9 == 0) goto L_0x00a0
            r1 = r1 | r10
            goto L_0x00b2
        L_0x00a0:
            r10 = r10 & r15
            if (r10 != 0) goto L_0x00b2
            r10 = r35
            boolean r11 = r12.changed((float) r10)
            if (r11 == 0) goto L_0x00ae
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r1 = r1 | r11
            goto L_0x00b4
        L_0x00b2:
            r10 = r35
        L_0x00b4:
            r11 = r13 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r11 == 0) goto L_0x00bf
            r1 = r1 | r16
            r0 = r36
            goto L_0x00d2
        L_0x00bf:
            r16 = r15 & r16
            r0 = r36
            if (r16 != 0) goto L_0x00d2
            boolean r17 = r12.changedInstance(r0)
            if (r17 == 0) goto L_0x00ce
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r17
        L_0x00d2:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00dd
            r1 = r1 | r17
            r3 = r37
            goto L_0x00f0
        L_0x00dd:
            r17 = r15 & r17
            r3 = r37
            if (r17 != 0) goto L_0x00f0
            boolean r17 = r12.changedInstance(r3)
            if (r17 == 0) goto L_0x00ec
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r1 = r1 | r17
        L_0x00f0:
            r3 = r13 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x00f9
            r1 = r1 | r17
            goto L_0x010d
        L_0x00f9:
            r3 = r15 & r17
            if (r3 != 0) goto L_0x010d
            r3 = r38
            boolean r17 = r12.changedInstance(r3)
            if (r17 == 0) goto L_0x0108
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010a
        L_0x0108:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010a:
            r1 = r1 | r17
            goto L_0x010f
        L_0x010d:
            r3 = r38
        L_0x010f:
            r17 = 38347923(0x2492493, float:1.4777644E-37)
            r3 = r1 & r17
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r4) goto L_0x0132
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x0120
            goto L_0x0132
        L_0x0120:
            r12.skipToGroupEnd()
            r2 = r29
            r3 = r30
            r9 = r36
            r4 = r5
            r6 = r7
            r8 = r10
            r27 = r12
            r10 = r37
            goto L_0x0241
        L_0x0132:
            r12.startDefaults()
            r3 = r15 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x0167
            boolean r3 = r12.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0143
            goto L_0x0167
        L_0x0143:
            r12.skipToGroupEnd()
            r0 = r13 & 4
            if (r0 == 0) goto L_0x014c
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014c:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0152
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0152:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0157
            r1 = r1 & r4
        L_0x0157:
            r17 = r29
            r18 = r30
            r24 = r36
            r25 = r37
            r19 = r5
            r21 = r7
            r23 = r10
            goto L_0x01d1
        L_0x0167:
            if (r2 == 0) goto L_0x016e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0170
        L_0x016e:
            r2 = r29
        L_0x0170:
            r3 = r13 & 4
            r4 = 1
            if (r3 == 0) goto L_0x017d
            r3 = 0
            androidx.compose.foundation.ScrollState r3 = androidx.compose.foundation.ScrollKt.rememberScrollState(r3, r12, r3, r4)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x017f
        L_0x017d:
            r3 = r30
        L_0x017f:
            r17 = r13 & 8
            r4 = 6
            if (r17 == 0) goto L_0x018c
            androidx.compose.material3.TabRowDefaults r5 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r5 = r5.getSecondaryContainerColor(r12, r4)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x018c:
            r17 = r13 & 16
            if (r17 == 0) goto L_0x019a
            androidx.compose.material3.TabRowDefaults r7 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r7 = r7.getSecondaryContentColor(r12, r4)
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r4
        L_0x019a:
            if (r9 == 0) goto L_0x01a3
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            float r4 = r4.m2354getScrollableTabRowEdgeStartPaddingD9Ej5fM()
            goto L_0x01a4
        L_0x01a3:
            r4 = r10
        L_0x01a4:
            if (r11 == 0) goto L_0x01b6
            androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1 r9 = new androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
            r9.<init>(r14)
            r10 = -115843248(0xfffffffff9185f50, float:-4.9447643E34)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r10, r11, r9)
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            goto L_0x01b8
        L_0x01b6:
            r9 = r36
        L_0x01b8:
            if (r0 == 0) goto L_0x01c3
            androidx.compose.material3.ComposableSingletons$TabRowKt r0 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1728getLambda5$material3_release()
            r25 = r0
            goto L_0x01c5
        L_0x01c3:
            r25 = r37
        L_0x01c5:
            r17 = r2
            r18 = r3
            r23 = r4
            r19 = r5
            r21 = r7
            r24 = r9
        L_0x01d1:
            r12.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01e3
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:762)"
            r3 = 1821940917(0x6c989cb5, float:1.475974E27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x01e3:
            r0 = r1 & 14
            int r2 = r1 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r1 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r1 >> 3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r0 = r0 | r2
            int r1 = r1 << 18
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r2
            r16 = r0 | r1
            r26 = 0
            r0 = r28
            r1 = r24
            r2 = r17
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r25
            r9 = r38
            r10 = r18
            r11 = r12
            r27 = r12
            r12 = r16
            r13 = r26
            m2358ScrollableTabRowImpqhFBPw4(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0233
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0233:
            r2 = r17
            r3 = r18
            r4 = r19
            r6 = r21
            r8 = r23
            r9 = r24
            r10 = r25
        L_0x0241:
            androidx.compose.runtime.ScopeUpdateScope r13 = r27.endRestartGroup()
            if (r13 == 0) goto L_0x025e
            androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2 r16 = new androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2
            r0 = r16
            r1 = r28
            r11 = r38
            r12 = r40
            r14 = r13
            r13 = r41
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x025e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2359SecondaryScrollableTabRowqhFBPw4(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0113  */
    /* renamed from: ScrollableTabRow-sKfQg0A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2357ScrollableTabRowsKfQg0A(int r27, androidx.compose.ui.Modifier r28, long r29, long r31, float r33, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r14 = r27
            r15 = r38
            r13 = r39
            r0 = -497821003(0xffffffffe253dab5, float:-9.770056E20)
            r1 = r37
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)816@36583L21,817@36647L19,838@37409L21,829@37100L336:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r15 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r15 & 6
            if (r1 != 0) goto L_0x002a
            boolean r1 = r12.changed((int) r14)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r15
            goto L_0x002b
        L_0x002a:
            r1 = r15
        L_0x002b:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r15 & 48
            if (r3 != 0) goto L_0x0045
            r3 = r28
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r28
        L_0x0047:
            r4 = r15 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0060
            r4 = r13 & 4
            if (r4 != 0) goto L_0x005a
            r4 = r29
            boolean r6 = r12.changed((long) r4)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r4 = r29
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r6
            goto L_0x0062
        L_0x0060:
            r4 = r29
        L_0x0062:
            r6 = r15 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007b
            r6 = r13 & 8
            if (r6 != 0) goto L_0x0075
            r6 = r31
            boolean r8 = r12.changed((long) r6)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r6 = r31
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r8
            goto L_0x007d
        L_0x007b:
            r6 = r31
        L_0x007d:
            r8 = r13 & 16
            if (r8 == 0) goto L_0x0084
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r9 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0097
            r9 = r33
            boolean r10 = r12.changed((float) r9)
            if (r10 == 0) goto L_0x0093
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r1 = r1 | r10
            goto L_0x0099
        L_0x0097:
            r9 = r33
        L_0x0099:
            r10 = r13 & 32
            r11 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a1
            r1 = r1 | r11
            goto L_0x00b4
        L_0x00a1:
            r11 = r11 & r15
            if (r11 != 0) goto L_0x00b4
            r11 = r34
            boolean r16 = r12.changedInstance(r11)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r1 = r1 | r16
            goto L_0x00b6
        L_0x00b4:
            r11 = r34
        L_0x00b6:
            r16 = r13 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c1
            r1 = r1 | r17
            r0 = r35
            goto L_0x00d4
        L_0x00c1:
            r17 = r15 & r17
            r0 = r35
            if (r17 != 0) goto L_0x00d4
            boolean r18 = r12.changedInstance(r0)
            if (r18 == 0) goto L_0x00d0
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r1 = r1 | r18
        L_0x00d4:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00dd
            r1 = r1 | r18
            goto L_0x00f1
        L_0x00dd:
            r0 = r15 & r18
            if (r0 != 0) goto L_0x00f1
            r0 = r36
            boolean r18 = r12.changedInstance(r0)
            if (r18 == 0) goto L_0x00ec
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r1 = r1 | r18
            goto L_0x00f3
        L_0x00f1:
            r0 = r36
        L_0x00f3:
            r18 = 4793491(0x492493, float:6.717112E-39)
            r0 = r1 & r18
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0113
            boolean r0 = r12.getSkipping()
            if (r0 != 0) goto L_0x0104
            goto L_0x0113
        L_0x0104:
            r12.skipToGroupEnd()
            r2 = r28
            r3 = r4
            r5 = r6
            r7 = r9
            r8 = r11
            r26 = r12
            r9 = r35
            goto L_0x01f7
        L_0x0113:
            r12.startDefaults()
            r0 = r15 & 1
            if (r0 == 0) goto L_0x013d
            boolean r0 = r12.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0121
            goto L_0x013d
        L_0x0121:
            r12.skipToGroupEnd()
            r0 = r13 & 4
            if (r0 == 0) goto L_0x012a
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012a:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0130
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0130:
            r16 = r28
            r24 = r35
        L_0x0134:
            r18 = r4
            r20 = r6
            r22 = r9
            r23 = r11
            goto L_0x018d
        L_0x013d:
            if (r2 == 0) goto L_0x0144
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0146
        L_0x0144:
            r0 = r28
        L_0x0146:
            r2 = r13 & 4
            r3 = 6
            if (r2 == 0) goto L_0x0153
            androidx.compose.material3.TabRowDefaults r2 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r4 = r2.getPrimaryContainerColor(r12, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0153:
            r2 = r13 & 8
            if (r2 == 0) goto L_0x0160
            androidx.compose.material3.TabRowDefaults r2 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r2 = r2.getPrimaryContentColor(r12, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r2
        L_0x0160:
            if (r8 == 0) goto L_0x0169
            androidx.compose.material3.TabRowDefaults r2 = androidx.compose.material3.TabRowDefaults.INSTANCE
            float r2 = r2.m2354getScrollableTabRowEdgeStartPaddingD9Ej5fM()
            r9 = r2
        L_0x0169:
            if (r10 == 0) goto L_0x017b
            androidx.compose.material3.TabRowKt$ScrollableTabRow$1 r2 = new androidx.compose.material3.TabRowKt$ScrollableTabRow$1
            r2.<init>(r14)
            r3 = -913748678(0xffffffffc9894d3a, float:-1124775.2)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r3, r8, r2)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r11 = r2
        L_0x017b:
            if (r16 == 0) goto L_0x0188
            androidx.compose.material3.ComposableSingletons$TabRowKt r2 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r2 = r2.m1729getLambda6$material3_release()
            r16 = r0
            r24 = r2
            goto L_0x0134
        L_0x0188:
            r24 = r35
            r16 = r0
            goto L_0x0134
        L_0x018d:
            r12.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019f
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.ScrollableTabRow (TabRow.kt:828)"
            r3 = -497821003(0xffffffffe253dab5, float:-9.770056E20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x019f:
            r0 = 0
            r2 = 1
            androidx.compose.foundation.ScrollState r10 = androidx.compose.foundation.ScrollKt.rememberScrollState(r0, r12, r0, r2)
            r0 = r1 & 14
            int r2 = r1 >> 12
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r1 << 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r3
            r0 = r0 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r2
            r17 = r0 | r1
            r25 = 0
            r0 = r27
            r1 = r23
            r2 = r16
            r3 = r18
            r5 = r20
            r7 = r22
            r8 = r24
            r9 = r36
            r11 = r12
            r26 = r12
            r12 = r17
            r13 = r25
            m2358ScrollableTabRowImpqhFBPw4(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01eb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01eb:
            r2 = r16
            r3 = r18
            r5 = r20
            r7 = r22
            r8 = r23
            r9 = r24
        L_0x01f7:
            androidx.compose.runtime.ScopeUpdateScope r13 = r26.endRestartGroup()
            if (r13 == 0) goto L_0x0213
            androidx.compose.material3.TabRowKt$ScrollableTabRow$2 r16 = new androidx.compose.material3.TabRowKt$ScrollableTabRow$2
            r0 = r16
            r1 = r27
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0213:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2357ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0100  */
    /* renamed from: ScrollableTabRowImp-qhFBPw4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2358ScrollableTabRowImpqhFBPw4(int r27, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, long r30, long r32, float r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.foundation.ScrollState r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r12 = r39
            r13 = r40
            r0 = -1696166011(0xffffffff9ae68f85, float:-9.535764E-23)
            r1 = r38
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ScrollableTabRowImp)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)847@37660L21,848@37724L19,856@37975L3984:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r12 | 6
            r3 = r2
            r2 = r27
            goto L_0x0030
        L_0x001c:
            r2 = r12 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r27
            boolean r3 = r1.changed((int) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r12
            goto L_0x0030
        L_0x002d:
            r2 = r27
            r3 = r12
        L_0x0030:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r12 & 48
            if (r4 != 0) goto L_0x004a
            r4 = r28
            boolean r5 = r1.changedInstance(r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r3 = r3 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r28
        L_0x004c:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r12 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0066
            r6 = r29
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r7
            goto L_0x0068
        L_0x0066:
            r6 = r29
        L_0x0068:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0081
            r7 = r13 & 8
            if (r7 != 0) goto L_0x007b
            r7 = r30
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x007d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007b:
            r7 = r30
        L_0x007d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r3 = r3 | r9
            goto L_0x0083
        L_0x0081:
            r7 = r30
        L_0x0083:
            r9 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009c
            r9 = r13 & 16
            if (r9 != 0) goto L_0x0096
            r9 = r32
            boolean r11 = r1.changed((long) r9)
            if (r11 == 0) goto L_0x0098
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r9 = r32
        L_0x0098:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r3 = r3 | r11
            goto L_0x009e
        L_0x009c:
            r9 = r32
        L_0x009e:
            r11 = r13 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00a6
            r3 = r3 | r14
            goto L_0x00b8
        L_0x00a6:
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00b8
            r14 = r34
            boolean r15 = r1.changed((float) r14)
            if (r15 == 0) goto L_0x00b4
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r3 = r3 | r15
            goto L_0x00ba
        L_0x00b8:
            r14 = r34
        L_0x00ba:
            r15 = r13 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c5
            r3 = r3 | r16
            r0 = r35
            goto L_0x00d8
        L_0x00c5:
            r16 = r12 & r16
            r0 = r35
            if (r16 != 0) goto L_0x00d8
            boolean r17 = r1.changedInstance(r0)
            if (r17 == 0) goto L_0x00d4
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r3 = r3 | r17
        L_0x00d8:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e1
            r3 = r3 | r17
            goto L_0x00f5
        L_0x00e1:
            r0 = r12 & r17
            if (r0 != 0) goto L_0x00f5
            r0 = r36
            boolean r18 = r1.changedInstance(r0)
            if (r18 == 0) goto L_0x00f0
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r3 = r3 | r18
            goto L_0x00f7
        L_0x00f5:
            r0 = r36
        L_0x00f7:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0100
            r3 = r3 | r18
            goto L_0x0114
        L_0x0100:
            r0 = r12 & r18
            if (r0 != 0) goto L_0x0114
            r0 = r37
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010f
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0111
        L_0x010f:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0111:
            r3 = r3 | r18
            goto L_0x0116
        L_0x0114:
            r0 = r37
        L_0x0116:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r3 & r18
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x012f
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0127
            goto L_0x012f
        L_0x0127:
            r1.skipToGroupEnd()
            r11 = r35
        L_0x012c:
            r3 = r6
            goto L_0x01e6
        L_0x012f:
            r1.startDefaults()
            r0 = r12 & 1
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0152
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0140
            goto L_0x0152
        L_0x0140:
            r1.skipToGroupEnd()
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0149
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0149:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x014e
            r3 = r3 & r2
        L_0x014e:
            r2 = r35
        L_0x0150:
            r0 = r14
            goto L_0x0186
        L_0x0152:
            if (r5 == 0) goto L_0x0159
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0159:
            r0 = r13 & 8
            r5 = 6
            if (r0 == 0) goto L_0x0166
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r7 = r0.getPrimaryContainerColor(r1, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0166:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0173
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r9 = r0.getPrimaryContentColor(r1, r5)
            r0 = r3 & r2
            r3 = r0
        L_0x0173:
            if (r11 == 0) goto L_0x017c
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            float r0 = r0.m2354getScrollableTabRowEdgeStartPaddingD9Ej5fM()
            r14 = r0
        L_0x017c:
            if (r15 == 0) goto L_0x014e
            androidx.compose.material3.ComposableSingletons$TabRowKt r0 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1730getLambda7$material3_release()
            r2 = r0
            goto L_0x0150
        L_0x0186:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0198
            r5 = -1
            java.lang.String r11 = "androidx.compose.material3.ScrollableTabRowImp (TabRow.kt:855)"
            r14 = -1696166011(0xffffffff9ae68f85, float:-9.535764E-23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r3, r5, r11)
        L_0x0198:
            androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1 r5 = new androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
            r29 = r5
            r30 = r37
            r31 = r0
            r32 = r36
            r33 = r2
            r34 = r28
            r35 = r27
            r29.<init>(r30, r31, r32, r33, r34, r35)
            r11 = -1178901494(0xffffffffb9bb640a, float:-3.5741954E-4)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r11, r14, r5)
            r23 = r5
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            int r5 = r3 >> 6
            r5 = r5 & 14
            r5 = r5 | r17
            int r3 = r3 >> 3
            r11 = r3 & 896(0x380, float:1.256E-42)
            r5 = r5 | r11
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r25 = r5 | r3
            r26 = 114(0x72, float:1.6E-43)
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r14 = r6
            r16 = r7
            r18 = r9
            r24 = r1
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01e2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e2:
            r14 = r0
            r11 = r2
            goto L_0x012c
        L_0x01e6:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 == 0) goto L_0x020a
            androidx.compose.material3.TabRowKt$ScrollableTabRowImp$2 r16 = new androidx.compose.material3.TabRowKt$ScrollableTabRowImp$2
            r0 = r16
            r1 = r27
            r2 = r28
            r4 = r7
            r6 = r9
            r8 = r14
            r9 = r11
            r10 = r36
            r11 = r37
            r12 = r39
            r13 = r40
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x020a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2358ScrollableTabRowImpqhFBPw4(int, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int):void");
    }
}
