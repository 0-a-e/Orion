package androidx.compose.foundation.pager;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aØ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f21\u0010 \u001a-\u0012\u0004\u0012\u00020\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b$¢\u0006\u0002\b%H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a.\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020/H\u0002\u001aØ\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f21\u0010 \u001a-\u0012\u0004\u0012\u00020\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b$¢\u0006\u0002\b%H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u0017\u00106\u001a\u00020\u00062\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\b\u001a\f\u0010:\u001a\u00020/*\u00020\bH\u0002\u001a\f\u0010;\u001a\u00020\u0001*\u00020\bH\u0002\u001a!\u0010<\u001a\u00020\n*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010>\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DEBUG", "", "LowVelocityAnimationDefaultDuration", "", "PagerDebugEnable", "HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapPositionalThreshold", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isScrollingForward", "pagerSemantics", "isVertical", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerKt {
    private static final boolean DEBUG = false;
    private static final int LowVelocityAnimationDefaultDuration = 500;
    public static final boolean PagerDebugEnable = false;

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0133  */
    /* renamed from: HorizontalPager-xYaah8o  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m973HorizontalPagerxYaah8o(androidx.compose.foundation.pager.PagerState r35, androidx.compose.ui.Modifier r36, androidx.compose.foundation.layout.PaddingValues r37, androidx.compose.foundation.pager.PageSize r38, int r39, float r40, androidx.compose.ui.Alignment.Vertical r41, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r42, boolean r43, boolean r44, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r45, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r46, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, int r49, int r50, int r51) {
        /*
            r15 = r35
            r14 = r49
            r13 = r50
            r11 = r51
            r10 = 1491175841(0x58e189a1, float:1.98384982E15)
            r0 = r48
            androidx.compose.runtime.Composer r12 = r0.startRestartGroup(r10)
            java.lang.String r0 = "C(HorizontalPager)P(10,4,1,7!1,8:c#ui.unit.Dp,12!1,11,9!1,6)116@6471L28,120@6673L103,125@6846L620:Pager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x001d
            r0 = r14 | 6
            goto L_0x002d
        L_0x001d:
            r0 = r14 & 14
            if (r0 != 0) goto L_0x002c
            boolean r0 = r12.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0029
            r0 = 4
            goto L_0x002a
        L_0x0029:
            r0 = 2
        L_0x002a:
            r0 = r0 | r14
            goto L_0x002d
        L_0x002c:
            r0 = r14
        L_0x002d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0034
            r0 = r0 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r14 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r36
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r0 = r0 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r36
        L_0x0049:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r8 = r14 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0063
            r8 = r37
            boolean r9 = r12.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r9
            goto L_0x0065
        L_0x0063:
            r8 = r37
        L_0x0065:
            r9 = r11 & 8
            if (r9 == 0) goto L_0x006c
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006c:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0080
            r2 = r38
            boolean r17 = r12.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x007b
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r0 = r0 | r17
            goto L_0x0082
        L_0x0080:
            r2 = r38
        L_0x0082:
            r17 = r11 & 16
            r18 = 57344(0xe000, float:8.0356E-41)
            if (r17 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r6 = r39
            goto L_0x00a1
        L_0x008e:
            r19 = r14 & r18
            r6 = r39
            if (r19 != 0) goto L_0x00a1
            boolean r20 = r12.changed((int) r6)
            if (r20 == 0) goto L_0x009d
            r20 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r20
        L_0x00a1:
            r20 = r11 & 32
            r21 = 458752(0x70000, float:6.42848E-40)
            if (r20 == 0) goto L_0x00ae
            r22 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r22
            r7 = r40
            goto L_0x00c1
        L_0x00ae:
            r22 = r14 & r21
            r7 = r40
            if (r22 != 0) goto L_0x00c1
            boolean r23 = r12.changed((float) r7)
            if (r23 == 0) goto L_0x00bd
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r0 = r0 | r23
        L_0x00c1:
            r23 = r11 & 64
            r24 = 3670016(0x380000, float:5.142788E-39)
            if (r23 == 0) goto L_0x00ce
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r10 = r41
            goto L_0x00e1
        L_0x00ce:
            r25 = r14 & r24
            r10 = r41
            if (r25 != 0) goto L_0x00e1
            boolean r26 = r12.changed((java.lang.Object) r10)
            if (r26 == 0) goto L_0x00dd
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r0 = r0 | r26
        L_0x00e1:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r14 & r26
            if (r26 != 0) goto L_0x00fd
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00f6
            r1 = r42
            boolean r27 = r12.changed((java.lang.Object) r1)
            if (r27 == 0) goto L_0x00f8
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f6:
            r1 = r42
        L_0x00f8:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r0 = r0 | r27
            goto L_0x00ff
        L_0x00fd:
            r1 = r42
        L_0x00ff:
            r6 = r11 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x0108
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r27
            goto L_0x0120
        L_0x0108:
            r27 = 234881024(0xe000000, float:1.5777218E-30)
            r27 = r14 & r27
            if (r27 != 0) goto L_0x0120
            r27 = r6
            r6 = r43
            boolean r28 = r12.changed((boolean) r6)
            if (r28 == 0) goto L_0x011b
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011d
        L_0x011b:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011d:
            r0 = r0 | r28
            goto L_0x0124
        L_0x0120:
            r27 = r6
            r6 = r43
        L_0x0124:
            r6 = r11 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x0133
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r29 = r0
            r28 = r6
            r6 = r44
            goto L_0x0151
        L_0x0133:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r14 & r28
            if (r28 != 0) goto L_0x014b
            r28 = r6
            r6 = r44
            boolean r29 = r12.changed((boolean) r6)
            if (r29 == 0) goto L_0x0146
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0148
        L_0x0146:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0148:
            r0 = r0 | r29
            goto L_0x014f
        L_0x014b:
            r28 = r6
            r6 = r44
        L_0x014f:
            r29 = r0
        L_0x0151:
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x015a
            r16 = r13 | 6
            r6 = r45
            goto L_0x0170
        L_0x015a:
            r30 = r13 & 14
            r6 = r45
            if (r30 != 0) goto L_0x016e
            boolean r30 = r12.changedInstance(r6)
            if (r30 == 0) goto L_0x0169
            r16 = 4
            goto L_0x016b
        L_0x0169:
            r16 = 2
        L_0x016b:
            r16 = r13 | r16
            goto L_0x0170
        L_0x016e:
            r16 = r13
        L_0x0170:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0176
            r16 = r16 | 16
        L_0x0176:
            r30 = r0
            r0 = r16
            r1 = r11 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0181
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0197
        L_0x0181:
            r1 = r13 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0195
            r1 = r47
            boolean r16 = r12.changedInstance(r1)
            if (r16 == 0) goto L_0x0190
            r19 = 256(0x100, float:3.59E-43)
            goto L_0x0192
        L_0x0190:
            r19 = 128(0x80, float:1.794E-43)
        L_0x0192:
            r0 = r0 | r19
            goto L_0x0197
        L_0x0195:
            r1 = r47
        L_0x0197:
            r1 = 2048(0x800, float:2.87E-42)
            if (r6 != r1) goto L_0x01cb
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r29 & r1
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x01cb
            r1 = r0 & 731(0x2db, float:1.024E-42)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 != r2) goto L_0x01cb
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x01b2
            goto L_0x01cb
        L_0x01b2:
            r12.skipToGroupEnd()
            r5 = r39
            r9 = r43
            r11 = r45
            r2 = r4
            r6 = r7
            r3 = r8
            r7 = r10
            r25 = r12
            r4 = r38
            r8 = r42
            r10 = r44
            r12 = r46
            goto L_0x0379
        L_0x01cb:
            r12.startDefaults()
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0203
            boolean r1 = r12.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01d9
            goto L_0x0203
        L_0x01d9:
            r12.skipToGroupEnd()
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01e5
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r29 = r29 & r1
        L_0x01e5:
            if (r6 == 0) goto L_0x01e9
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
        L_0x01e9:
            r22 = r38
            r23 = r39
            r28 = r42
            r31 = r44
            r30 = r45
            r32 = r46
            r19 = r4
            r26 = r7
            r20 = r8
            r27 = r10
            r1 = r29
            r29 = r43
            goto L_0x02e0
        L_0x0203:
            if (r3 == 0) goto L_0x020c
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x020e
        L_0x020c:
            r16 = r4
        L_0x020e:
            r4 = 0
            if (r5 == 0) goto L_0x021d
            float r1 = (float) r4
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            androidx.compose.foundation.layout.PaddingValues r1 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r1)
            r19 = r1
            goto L_0x021f
        L_0x021d:
            r19 = r8
        L_0x021f:
            if (r9 == 0) goto L_0x0228
            androidx.compose.foundation.pager.PageSize$Fill r1 = androidx.compose.foundation.pager.PageSize.Fill.INSTANCE
            androidx.compose.foundation.pager.PageSize r1 = (androidx.compose.foundation.pager.PageSize) r1
            r22 = r1
            goto L_0x022a
        L_0x0228:
            r22 = r38
        L_0x022a:
            if (r17 == 0) goto L_0x022f
            r17 = r4
            goto L_0x0231
        L_0x022f:
            r17 = r39
        L_0x0231:
            if (r20 == 0) goto L_0x023b
            float r1 = (float) r4
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            r20 = r1
            goto L_0x023d
        L_0x023b:
            r20 = r7
        L_0x023d:
            if (r23 == 0) goto L_0x0246
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r1 = r1.getCenterVertically()
            r10 = r1
        L_0x0246:
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0272
            androidx.compose.foundation.pager.PagerDefaults r1 = androidx.compose.foundation.pager.PagerDefaults.INSTANCE
            r2 = r29 & 14
            r3 = 2097152(0x200000, float:2.938736E-39)
            r8 = r2 | r3
            r9 = 62
            r2 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r23 = 0
            r26 = r0
            r0 = r1
            r1 = r35
            r31 = r4
            r4 = r5
            r5 = r7
            r32 = r6
            r6 = r23
            r7 = r12
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r0 = r0.flingBehavior(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r29 = r29 & r1
            goto L_0x027a
        L_0x0272:
            r26 = r0
            r31 = r4
            r32 = r6
            r0 = r42
        L_0x027a:
            if (r27 == 0) goto L_0x027e
            r1 = 1
            goto L_0x0280
        L_0x027e:
            r1 = r43
        L_0x0280:
            if (r28 == 0) goto L_0x0283
            goto L_0x0285
        L_0x0283:
            r31 = r44
        L_0x0285:
            if (r30 == 0) goto L_0x0289
            r2 = 0
            goto L_0x028b
        L_0x0289:
            r2 = r45
        L_0x028b:
            if (r32 == 0) goto L_0x02c8
            r3 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            boolean r3 = r12.changed((java.lang.Object) r15)
            java.lang.Object r4 = r12.rememberedValue()
            if (r3 != 0) goto L_0x02aa
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02b5
        L_0x02aa:
            androidx.compose.foundation.pager.PagerDefaults r3 = androidx.compose.foundation.pager.PagerDefaults.INSTANCE
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = r3.pageNestedScrollConnection(r15, r4)
            r12.updateRememberedValue(r4)
        L_0x02b5:
            r12.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r4
            r3 = r26 & -113(0xffffffffffffff8f, float:NaN)
            r28 = r0
            r30 = r2
            r0 = r3
            r32 = r4
            r27 = r10
            r23 = r17
            goto L_0x02d4
        L_0x02c8:
            r32 = r46
            r28 = r0
            r30 = r2
            r27 = r10
            r23 = r17
            r0 = r26
        L_0x02d4:
            r26 = r20
            r20 = r19
            r19 = r16
            r34 = r29
            r29 = r1
            r1 = r34
        L_0x02e0:
            r12.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02f1
            java.lang.String r2 = "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:124)"
            r3 = 1491175841(0x58e189a1, float:1.98384982E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x02f1:
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getCenterHorizontally()
            r25 = r12
            r12 = r2
            int r2 = r1 >> 3
            r2 = r2 & 14
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            int r3 = r1 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r1 >> 18
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r1 >> 6
            r5 = r3 & r21
            r2 = r2 | r5
            r3 = r3 & r24
            r2 = r2 | r3
            int r3 = r1 << 9
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r3
            r2 = r2 | r5
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r5
            r2 = r2 | r3
            int r3 = r1 << 18
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r5
            r16 = r2 | r3
            int r2 = r0 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 392(0x188, float:5.5E-43)
            int r1 = r1 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r0 = r0 << 6
            r0 = r0 & r18
            r17 = r1 | r0
            r18 = 0
            r0 = r19
            r1 = r35
            r2 = r20
            r3 = r31
            r5 = r28
            r6 = r29
            r7 = r23
            r8 = r26
            r9 = r22
            r10 = r32
            r11 = r30
            r13 = r27
            r14 = r47
            r15 = r25
            androidx.compose.foundation.pager.LazyLayoutPagerKt.m968Pagerfs30GE4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0363
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0363:
            r2 = r19
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r30
            r10 = r31
            r12 = r32
        L_0x0379:
            androidx.compose.runtime.ScopeUpdateScope r15 = r25.endRestartGroup()
            if (r15 == 0) goto L_0x039b
            androidx.compose.foundation.pager.PagerKt$HorizontalPager$2 r17 = new androidx.compose.foundation.pager.PagerKt$HorizontalPager$2
            r0 = r17
            r1 = r35
            r13 = r47
            r14 = r49
            r33 = r15
            r15 = r50
            r16 = r51
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x039b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m973HorizontalPagerxYaah8o(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0133  */
    /* renamed from: VerticalPager-xYaah8o  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m974VerticalPagerxYaah8o(androidx.compose.foundation.pager.PagerState r35, androidx.compose.ui.Modifier r36, androidx.compose.foundation.layout.PaddingValues r37, androidx.compose.foundation.pager.PageSize r38, int r39, float r40, androidx.compose.ui.Alignment.Horizontal r41, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r42, boolean r43, boolean r44, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r45, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r46, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, int r49, int r50, int r51) {
        /*
            r15 = r35
            r14 = r49
            r12 = r50
            r11 = r51
            r10 = -1457068767(0xffffffffa926e521, float:-3.7058142E-14)
            r0 = r48
            androidx.compose.runtime.Composer r13 = r0.startRestartGroup(r10)
            java.lang.String r0 = "C(VerticalPager)P(11,5,1,8!1,9:c#ui.unit.Dp,3!1,12,10!1,7)196@10975L28,200@11177L101,205@11348L618:Pager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x001d
            r0 = r14 | 6
            goto L_0x002d
        L_0x001d:
            r0 = r14 & 14
            if (r0 != 0) goto L_0x002c
            boolean r0 = r13.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0029
            r0 = 4
            goto L_0x002a
        L_0x0029:
            r0 = 2
        L_0x002a:
            r0 = r0 | r14
            goto L_0x002d
        L_0x002c:
            r0 = r14
        L_0x002d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0034
            r0 = r0 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r14 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r36
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r0 = r0 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r36
        L_0x0049:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r8 = r14 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0063
            r8 = r37
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r9
            goto L_0x0065
        L_0x0063:
            r8 = r37
        L_0x0065:
            r9 = r11 & 8
            if (r9 == 0) goto L_0x006c
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006c:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0080
            r2 = r38
            boolean r17 = r13.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x007b
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r0 = r0 | r17
            goto L_0x0082
        L_0x0080:
            r2 = r38
        L_0x0082:
            r17 = r11 & 16
            r18 = 57344(0xe000, float:8.0356E-41)
            if (r17 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r6 = r39
            goto L_0x00a1
        L_0x008e:
            r19 = r14 & r18
            r6 = r39
            if (r19 != 0) goto L_0x00a1
            boolean r20 = r13.changed((int) r6)
            if (r20 == 0) goto L_0x009d
            r20 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r20
        L_0x00a1:
            r20 = r11 & 32
            r21 = 458752(0x70000, float:6.42848E-40)
            if (r20 == 0) goto L_0x00ae
            r22 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r22
            r7 = r40
            goto L_0x00c1
        L_0x00ae:
            r22 = r14 & r21
            r7 = r40
            if (r22 != 0) goto L_0x00c1
            boolean r23 = r13.changed((float) r7)
            if (r23 == 0) goto L_0x00bd
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r0 = r0 | r23
        L_0x00c1:
            r23 = r11 & 64
            r24 = 3670016(0x380000, float:5.142788E-39)
            if (r23 == 0) goto L_0x00ce
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r10 = r41
            goto L_0x00e1
        L_0x00ce:
            r25 = r14 & r24
            r10 = r41
            if (r25 != 0) goto L_0x00e1
            boolean r26 = r13.changed((java.lang.Object) r10)
            if (r26 == 0) goto L_0x00dd
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r0 = r0 | r26
        L_0x00e1:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r14 & r26
            if (r26 != 0) goto L_0x00fd
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00f6
            r1 = r42
            boolean r27 = r13.changed((java.lang.Object) r1)
            if (r27 == 0) goto L_0x00f8
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f6:
            r1 = r42
        L_0x00f8:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r0 = r0 | r27
            goto L_0x00ff
        L_0x00fd:
            r1 = r42
        L_0x00ff:
            r6 = r11 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x0108
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r27
            goto L_0x0120
        L_0x0108:
            r27 = 234881024(0xe000000, float:1.5777218E-30)
            r27 = r14 & r27
            if (r27 != 0) goto L_0x0120
            r27 = r6
            r6 = r43
            boolean r28 = r13.changed((boolean) r6)
            if (r28 == 0) goto L_0x011b
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011d
        L_0x011b:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011d:
            r0 = r0 | r28
            goto L_0x0124
        L_0x0120:
            r27 = r6
            r6 = r43
        L_0x0124:
            r6 = r11 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x0133
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r29 = r0
            r28 = r6
            r6 = r44
            goto L_0x0151
        L_0x0133:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r14 & r28
            if (r28 != 0) goto L_0x014b
            r28 = r6
            r6 = r44
            boolean r29 = r13.changed((boolean) r6)
            if (r29 == 0) goto L_0x0146
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0148
        L_0x0146:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0148:
            r0 = r0 | r29
            goto L_0x014f
        L_0x014b:
            r28 = r6
            r6 = r44
        L_0x014f:
            r29 = r0
        L_0x0151:
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x015a
            r16 = r12 | 6
            r6 = r45
            goto L_0x0170
        L_0x015a:
            r30 = r12 & 14
            r6 = r45
            if (r30 != 0) goto L_0x016e
            boolean r30 = r13.changedInstance(r6)
            if (r30 == 0) goto L_0x0169
            r16 = 4
            goto L_0x016b
        L_0x0169:
            r16 = 2
        L_0x016b:
            r16 = r12 | r16
            goto L_0x0170
        L_0x016e:
            r16 = r12
        L_0x0170:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0176
            r16 = r16 | 16
        L_0x0176:
            r30 = r0
            r0 = r16
            r1 = r11 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0181
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0197
        L_0x0181:
            r1 = r12 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0195
            r1 = r47
            boolean r16 = r13.changedInstance(r1)
            if (r16 == 0) goto L_0x0190
            r19 = 256(0x100, float:3.59E-43)
            goto L_0x0192
        L_0x0190:
            r19 = 128(0x80, float:1.794E-43)
        L_0x0192:
            r0 = r0 | r19
            goto L_0x0197
        L_0x0195:
            r1 = r47
        L_0x0197:
            r1 = 2048(0x800, float:2.87E-42)
            if (r6 != r1) goto L_0x01cb
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r29 & r1
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x01cb
            r1 = r0 & 731(0x2db, float:1.024E-42)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 != r2) goto L_0x01cb
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x01b2
            goto L_0x01cb
        L_0x01b2:
            r13.skipToGroupEnd()
            r5 = r39
            r9 = r43
            r11 = r45
            r12 = r46
            r2 = r4
            r6 = r7
            r3 = r8
            r7 = r10
            r25 = r13
            r4 = r38
            r8 = r42
            r10 = r44
            goto L_0x0379
        L_0x01cb:
            r13.startDefaults()
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0203
            boolean r1 = r13.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01d9
            goto L_0x0203
        L_0x01d9:
            r13.skipToGroupEnd()
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01e5
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r29 = r29 & r1
        L_0x01e5:
            if (r6 == 0) goto L_0x01e9
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
        L_0x01e9:
            r22 = r38
            r23 = r39
            r28 = r42
            r31 = r44
            r30 = r45
            r32 = r46
            r19 = r4
            r26 = r7
            r20 = r8
            r27 = r10
            r1 = r29
            r29 = r43
            goto L_0x02e0
        L_0x0203:
            if (r3 == 0) goto L_0x020c
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x020e
        L_0x020c:
            r16 = r4
        L_0x020e:
            r4 = 0
            if (r5 == 0) goto L_0x021d
            float r1 = (float) r4
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            androidx.compose.foundation.layout.PaddingValues r1 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r1)
            r19 = r1
            goto L_0x021f
        L_0x021d:
            r19 = r8
        L_0x021f:
            if (r9 == 0) goto L_0x0228
            androidx.compose.foundation.pager.PageSize$Fill r1 = androidx.compose.foundation.pager.PageSize.Fill.INSTANCE
            androidx.compose.foundation.pager.PageSize r1 = (androidx.compose.foundation.pager.PageSize) r1
            r22 = r1
            goto L_0x022a
        L_0x0228:
            r22 = r38
        L_0x022a:
            if (r17 == 0) goto L_0x022f
            r17 = r4
            goto L_0x0231
        L_0x022f:
            r17 = r39
        L_0x0231:
            if (r20 == 0) goto L_0x023b
            float r1 = (float) r4
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            r20 = r1
            goto L_0x023d
        L_0x023b:
            r20 = r7
        L_0x023d:
            if (r23 == 0) goto L_0x0246
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r1 = r1.getCenterHorizontally()
            r10 = r1
        L_0x0246:
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0272
            androidx.compose.foundation.pager.PagerDefaults r1 = androidx.compose.foundation.pager.PagerDefaults.INSTANCE
            r2 = r29 & 14
            r3 = 2097152(0x200000, float:2.938736E-39)
            r8 = r2 | r3
            r9 = 62
            r2 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r23 = 0
            r26 = r0
            r0 = r1
            r1 = r35
            r31 = r4
            r4 = r5
            r5 = r7
            r32 = r6
            r6 = r23
            r7 = r13
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r0 = r0.flingBehavior(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r29 = r29 & r1
            goto L_0x027a
        L_0x0272:
            r26 = r0
            r31 = r4
            r32 = r6
            r0 = r42
        L_0x027a:
            if (r27 == 0) goto L_0x027e
            r1 = 1
            goto L_0x0280
        L_0x027e:
            r1 = r43
        L_0x0280:
            if (r28 == 0) goto L_0x0283
            goto L_0x0285
        L_0x0283:
            r31 = r44
        L_0x0285:
            if (r30 == 0) goto L_0x0289
            r2 = 0
            goto L_0x028b
        L_0x0289:
            r2 = r45
        L_0x028b:
            if (r32 == 0) goto L_0x02c8
            r3 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            boolean r3 = r13.changed((java.lang.Object) r15)
            java.lang.Object r4 = r13.rememberedValue()
            if (r3 != 0) goto L_0x02aa
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02b5
        L_0x02aa:
            androidx.compose.foundation.pager.PagerDefaults r3 = androidx.compose.foundation.pager.PagerDefaults.INSTANCE
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Vertical
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = r3.pageNestedScrollConnection(r15, r4)
            r13.updateRememberedValue(r4)
        L_0x02b5:
            r13.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r4
            r3 = r26 & -113(0xffffffffffffff8f, float:NaN)
            r28 = r0
            r30 = r2
            r0 = r3
            r32 = r4
            r27 = r10
            r23 = r17
            goto L_0x02d4
        L_0x02c8:
            r32 = r46
            r28 = r0
            r30 = r2
            r27 = r10
            r23 = r17
            r0 = r26
        L_0x02d4:
            r26 = r20
            r20 = r19
            r19 = r16
            r34 = r29
            r29 = r1
            r1 = r34
        L_0x02e0:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02f1
            java.lang.String r2 = "androidx.compose.foundation.pager.VerticalPager (Pager.kt:204)"
            r3 = -1457068767(0xffffffffa926e521, float:-3.7058142E-14)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x02f1:
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Vertical
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getCenterVertically()
            r25 = r13
            r13 = r2
            int r2 = r1 >> 3
            r2 = r2 & 14
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            int r3 = r1 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r1 >> 18
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r1 >> 6
            r5 = r3 & r21
            r2 = r2 | r5
            r3 = r3 & r24
            r2 = r2 | r3
            int r3 = r1 << 9
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r3
            r2 = r2 | r5
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r5
            r2 = r2 | r3
            int r3 = r1 << 18
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r5
            r16 = r2 | r3
            int r2 = r0 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 3080(0xc08, float:4.316E-42)
            int r1 = r1 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r0 = r0 << 6
            r0 = r0 & r18
            r17 = r1 | r0
            r18 = 0
            r0 = r19
            r1 = r35
            r2 = r20
            r3 = r31
            r5 = r28
            r6 = r29
            r7 = r23
            r8 = r26
            r9 = r22
            r10 = r32
            r11 = r30
            r12 = r27
            r14 = r47
            r15 = r25
            androidx.compose.foundation.pager.LazyLayoutPagerKt.m968Pagerfs30GE4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0363
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0363:
            r2 = r19
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r30
            r10 = r31
            r12 = r32
        L_0x0379:
            androidx.compose.runtime.ScopeUpdateScope r15 = r25.endRestartGroup()
            if (r15 == 0) goto L_0x039b
            androidx.compose.foundation.pager.PagerKt$VerticalPager$2 r17 = new androidx.compose.foundation.pager.PagerKt$VerticalPager$2
            r0 = r17
            r1 = r35
            r13 = r47
            r14 = r49
            r33 = r15
            r15 = r50
            r16 = r51
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x039b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m974VerticalPagerxYaah8o(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(PagerState pagerState, PagerSnapDistance pagerSnapDistance, DecayAnimationSpec<Float> decayAnimationSpec, float f) {
        return new PagerKt$SnapLayoutInfoProvider$1(pagerState, f, decayAnimationSpec, pagerSnapDistance);
    }

    public static final Modifier pagerSemantics(Modifier modifier, PagerState pagerState, boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(1509835088);
        ComposerKt.sourceInformation(composer, "C(pagerSemantics)P(1)915@43355L24:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, i, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:914)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Modifier then = modifier.then(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new PagerKt$pagerSemantics$1(z, pagerState, coroutineScope), 1, (Object) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }

    /* access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, (Continuation<? super PagerKt$pagerSemantics$performForwardPaging$1>) null), 3, (Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, (Continuation<? super PagerKt$pagerSemantics$performBackwardPaging$1>) null), 3, (Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState pagerState) {
        return dragGestureDelta(pagerState) < 0.0f;
    }

    /* access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState pagerState) {
        if (pagerState.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
            return Offset.m3562getXimpl(pagerState.m984getUpDownDifferenceF1C5BW0$foundation_release());
        }
        return Offset.m3563getYimpl(pagerState.m984getUpDownDifferenceF1C5BW0$foundation_release());
    }
}
