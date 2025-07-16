package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aD\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0011\u001a\u00020\u00062\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u0014\u001aD\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010\u001a\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010&\u001a\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\u00162\u0006\u0010'\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"CheckedZIndexFactor", "", "IconSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "MultiChoiceSegmentedButtonRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "space", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SegmentedButtonContent", "icon", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SingleChoiceSegmentedButtonRow", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButton", "checked", "", "onCheckedChange", "shape", "Landroidx/compose/ui/graphics/Shape;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentedButton.kt */
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    /* access modifiers changed from: private */
    public static final float IconSpacing = Dp.m6614constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:105:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SegmentedButton(androidx.compose.material3.MultiChoiceSegmentedButtonRowScope r29, boolean r30, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r31, androidx.compose.ui.graphics.Shape r32, androidx.compose.ui.Modifier r33, boolean r34, androidx.compose.material3.SegmentedButtonColors r35, androidx.compose.foundation.BorderStroke r36, androidx.compose.foundation.interaction.MutableInteractionSource r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42, int r43) {
        /*
            r1 = r29
            r0 = r30
            r14 = r39
            r13 = r41
            r6 = r43
            r2 = -1596038053(0xffffffffa0de645b, float:-3.7674673E-19)
            r3 = r40
            androidx.compose.runtime.Composer r5 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(SegmentedButton)P(1,8,9,7,3,2!1,5)134@6782L8,138@6959L39,144@7288L25,146@7319L585:SegmentedButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r6
            if (r3 == 0) goto L_0x0020
            r3 = r13 | 6
            goto L_0x0030
        L_0x0020:
            r3 = r13 & 6
            if (r3 != 0) goto L_0x002f
            boolean r3 = r5.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r13
            goto L_0x0030
        L_0x002f:
            r3 = r13
        L_0x0030:
            r8 = r6 & 1
            if (r8 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x0047
        L_0x0037:
            r8 = r13 & 48
            if (r8 != 0) goto L_0x0047
            boolean r8 = r5.changed((boolean) r0)
            if (r8 == 0) goto L_0x0044
            r8 = 32
            goto L_0x0046
        L_0x0044:
            r8 = 16
        L_0x0046:
            r3 = r3 | r8
        L_0x0047:
            r8 = r6 & 2
            if (r8 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            r12 = r31
            goto L_0x0062
        L_0x0050:
            r8 = r13 & 384(0x180, float:5.38E-43)
            r12 = r31
            if (r8 != 0) goto L_0x0062
            boolean r8 = r5.changedInstance(r12)
            if (r8 == 0) goto L_0x005f
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r8
        L_0x0062:
            r8 = r6 & 4
            if (r8 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r11 = r32
            goto L_0x007d
        L_0x006b:
            r8 = r13 & 3072(0xc00, float:4.305E-42)
            r11 = r32
            if (r8 != 0) goto L_0x007d
            boolean r8 = r5.changed((java.lang.Object) r11)
            if (r8 == 0) goto L_0x007a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r8
        L_0x007d:
            r8 = r6 & 8
            if (r8 == 0) goto L_0x0084
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r9 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0097
            r9 = r33
            boolean r10 = r5.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0093
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r10
            goto L_0x0099
        L_0x0097:
            r9 = r33
        L_0x0099:
            r10 = r6 & 16
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a1
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00a1:
            r15 = r15 & r13
            if (r15 != 0) goto L_0x00b4
            r15 = r34
            boolean r16 = r5.changed((boolean) r15)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r16
            goto L_0x00b6
        L_0x00b4:
            r15 = r34
        L_0x00b6:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00d0
            r16 = r6 & 32
            r4 = r35
            if (r16 != 0) goto L_0x00cb
            boolean r16 = r5.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r4 = r35
        L_0x00d2:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00ec
            r16 = r6 & 64
            r2 = r36
            if (r16 != 0) goto L_0x00e7
            boolean r17 = r5.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00e7
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00e7:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e9:
            r3 = r3 | r17
            goto L_0x00ee
        L_0x00ec:
            r2 = r36
        L_0x00ee:
            r7 = r6 & 128(0x80, float:1.794E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r7 == 0) goto L_0x00f9
            r3 = r3 | r18
            r2 = r37
            goto L_0x010c
        L_0x00f9:
            r18 = r13 & r18
            r2 = r37
            if (r18 != 0) goto L_0x010c
            boolean r18 = r5.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x0108
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010a
        L_0x0108:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010a:
            r3 = r3 | r18
        L_0x010c:
            r2 = r6 & 256(0x100, float:3.59E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0117
            r3 = r3 | r18
            r4 = r38
            goto L_0x012a
        L_0x0117:
            r18 = r13 & r18
            r4 = r38
            if (r18 != 0) goto L_0x012a
            boolean r18 = r5.changedInstance(r4)
            if (r18 == 0) goto L_0x0126
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0128
        L_0x0126:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0128:
            r3 = r3 | r18
        L_0x012a:
            r4 = r6 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0131
            r4 = r42 | 6
            goto L_0x0143
        L_0x0131:
            r4 = r42 & 6
            if (r4 != 0) goto L_0x0141
            boolean r4 = r5.changedInstance(r14)
            if (r4 == 0) goto L_0x013d
            r4 = 4
            goto L_0x013e
        L_0x013d:
            r4 = 2
        L_0x013e:
            r4 = r42 | r4
            goto L_0x0143
        L_0x0141:
            r4 = r42
        L_0x0143:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r9 = r3 & r18
            r11 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r11) goto L_0x016b
            r9 = r4 & 3
            r11 = 2
            if (r9 != r11) goto L_0x016b
            boolean r9 = r5.getSkipping()
            if (r9 != 0) goto L_0x0159
            goto L_0x016b
        L_0x0159:
            r5.skipToGroupEnd()
            r7 = r35
            r8 = r36
            r9 = r37
            r10 = r38
            r21 = r5
            r6 = r15
            r5 = r33
            goto L_0x02cd
        L_0x016b:
            r5.startDefaults()
            r9 = r13 & 1
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r11 = 6
            if (r9 == 0) goto L_0x019f
            boolean r9 = r5.getDefaultsInvalid()
            if (r9 == 0) goto L_0x017d
            goto L_0x019f
        L_0x017d:
            r5.skipToGroupEnd()
            r2 = r6 & 32
            if (r2 == 0) goto L_0x0186
            r3 = r3 & r17
        L_0x0186:
            r2 = r6 & 64
            if (r2 == 0) goto L_0x018e
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r2
        L_0x018e:
            r25 = r33
            r2 = r35
            r26 = r36
            r27 = r37
            r11 = r38
            r28 = r15
            r15 = r3
            r3 = r28
            goto L_0x0221
        L_0x019f:
            if (r8 == 0) goto L_0x01a6
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            goto L_0x01a8
        L_0x01a6:
            r8 = r33
        L_0x01a8:
            if (r10 == 0) goto L_0x01ab
            r15 = 1
        L_0x01ab:
            r9 = r6 & 32
            if (r9 == 0) goto L_0x01b8
            androidx.compose.material3.SegmentedButtonDefaults r9 = androidx.compose.material3.SegmentedButtonDefaults.INSTANCE
            androidx.compose.material3.SegmentedButtonColors r9 = r9.colors(r5, r11)
            r3 = r3 & r17
            goto L_0x01ba
        L_0x01b8:
            r9 = r35
        L_0x01ba:
            r10 = r6 & 64
            if (r10 == 0) goto L_0x01d4
            androidx.compose.material3.SegmentedButtonDefaults r19 = androidx.compose.material3.SegmentedButtonDefaults.INSTANCE
            long r20 = r9.m2122borderColorWaAFU9c$material3_release(r15, r0)
            r23 = 2
            r24 = 0
            r22 = 0
            androidx.compose.foundation.BorderStroke r10 = androidx.compose.material3.SegmentedButtonDefaults.m2139borderStrokel07J4OM$default(r19, r20, r22, r23, r24)
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r17
            goto L_0x01d6
        L_0x01d4:
            r10 = r36
        L_0x01d6:
            if (r7 == 0) goto L_0x01fc
            r7 = -773603666(0xffffffffd1e3beae, float:-1.22269581E11)
            r5.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):SegmentedButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r7)
            java.lang.Object r7 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r17.getEmpty()
            if (r7 != r11) goto L_0x01f6
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r5.updateRememberedValue(r7)
        L_0x01f6:
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = (androidx.compose.foundation.interaction.MutableInteractionSource) r7
            r5.endReplaceableGroup()
            goto L_0x01fe
        L_0x01fc:
            r7 = r37
        L_0x01fe:
            if (r2 == 0) goto L_0x0213
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$2 r2 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$2
            r2.<init>(r0)
            r11 = 970447394(0x39d7da22, float:4.1170517E-4)
            r33 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r11, r3, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r11 = r2
            goto L_0x0217
        L_0x0213:
            r33 = r3
            r11 = r38
        L_0x0217:
            r27 = r7
            r25 = r8
            r2 = r9
            r26 = r10
            r3 = r15
            r15 = r33
        L_0x0221:
            r5.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0232
            java.lang.String r7 = "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:141)"
            r8 = -1596038053(0xffffffffa0de645b, float:-3.7674673E-19)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r15, r4, r7)
        L_0x0232:
            long r7 = r2.m2123containerColorWaAFU9c$material3_release(r3, r0)
            long r9 = r2.m2124contentColorWaAFU9c$material3_release(r3, r0)
            r4 = r27
            androidx.compose.foundation.interaction.InteractionSource r4 = (androidx.compose.foundation.interaction.InteractionSource) r4
            int r16 = r15 >> 24
            r33 = r2
            r2 = r16 & 14
            androidx.compose.runtime.State r4 = interactionCountAsState(r4, r5, r2)
            r19 = r1
            androidx.compose.foundation.layout.RowScope r19 = (androidx.compose.foundation.layout.RowScope) r19
            r23 = 2
            r24 = 0
            r21 = 1065353216(0x3f800000, float:1.0)
            r22 = 0
            r20 = r25
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r19, r20, r21, r22, r23, r24)
            androidx.compose.ui.Modifier r1 = interactionZIndex(r1, r0, r4)
            androidx.compose.material3.ButtonDefaults r4 = androidx.compose.material3.ButtonDefaults.INSTANCE
            float r4 = r4.m1561getMinWidthD9Ej5fM()
            androidx.compose.material3.ButtonDefaults r16 = androidx.compose.material3.ButtonDefaults.INSTANCE
            float r0 = r16.m1560getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m726defaultMinSizeVpY3zN4(r1, r4, r0)
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3 r0 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3
            r0.<init>(r11, r14)
            r1 = 1635710341(0x617ef585, float:2.9394778E20)
            r16 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r1, r3, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3 = r15
            r15 = r0
            int r0 = r3 >> 3
            r0 = r0 & 126(0x7e, float:1.77E-43)
            int r1 = r3 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            int r17 = r3 << 3
            r1 = r17 & r1
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = 6
            int r3 = r3 << 6
            r1 = r1 & r3
            r17 = r0 | r1
            r18 = r2 | 48
            r19 = 384(0x180, float:5.38E-43)
            r0 = 0
            r1 = r11
            r11 = r0
            r12 = r0
            r0 = r33
            r2 = r30
            r20 = r16
            r3 = r31
            r21 = r5
            r5 = r20
            r6 = r32
            r13 = r26
            r14 = r27
            r16 = r21
            androidx.compose.material3.SurfaceKt.m2305Surfaced85dljk((boolean) r2, (kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>) r3, (androidx.compose.ui.Modifier) r4, (boolean) r5, (androidx.compose.ui.graphics.Shape) r6, (long) r7, (long) r9, (float) r11, (float) r12, (androidx.compose.foundation.BorderStroke) r13, (androidx.compose.foundation.interaction.MutableInteractionSource) r14, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02c3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02c3:
            r7 = r0
            r10 = r1
            r6 = r20
            r5 = r25
            r8 = r26
            r9 = r27
        L_0x02cd:
            androidx.compose.runtime.ScopeUpdateScope r15 = r21.endRestartGroup()
            if (r15 == 0) goto L_0x02f1
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$4 r16 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$4
            r0 = r16
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
            r11 = r39
            r12 = r41
            r13 = r42
            r14 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonKt.SegmentedButton(androidx.compose.material3.MultiChoiceSegmentedButtonRowScope, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SegmentedButtonColors, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SegmentedButton(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope r29, boolean r30, kotlin.jvm.functions.Function0<kotlin.Unit> r31, androidx.compose.ui.graphics.Shape r32, androidx.compose.ui.Modifier r33, boolean r34, androidx.compose.material3.SegmentedButtonColors r35, androidx.compose.foundation.BorderStroke r36, androidx.compose.foundation.interaction.MutableInteractionSource r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42, int r43) {
        /*
            r1 = r29
            r0 = r30
            r14 = r39
            r13 = r41
            r6 = r43
            r2 = -1016574361(0xffffffffc3684e67, float:-232.30626)
            r3 = r40
            androidx.compose.runtime.Composer r5 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(SegmentedButton)P(8,7,9,6,2,1!1,4)209@10206L8,213@10384L39,219@10716L25,221@10747L623:SegmentedButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r6
            if (r3 == 0) goto L_0x0020
            r3 = r13 | 6
            goto L_0x0030
        L_0x0020:
            r3 = r13 & 6
            if (r3 != 0) goto L_0x002f
            boolean r3 = r5.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r13
            goto L_0x0030
        L_0x002f:
            r3 = r13
        L_0x0030:
            r8 = r6 & 1
            if (r8 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x0047
        L_0x0037:
            r8 = r13 & 48
            if (r8 != 0) goto L_0x0047
            boolean r8 = r5.changed((boolean) r0)
            if (r8 == 0) goto L_0x0044
            r8 = 32
            goto L_0x0046
        L_0x0044:
            r8 = 16
        L_0x0046:
            r3 = r3 | r8
        L_0x0047:
            r8 = r6 & 2
            if (r8 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            r12 = r31
            goto L_0x0062
        L_0x0050:
            r8 = r13 & 384(0x180, float:5.38E-43)
            r12 = r31
            if (r8 != 0) goto L_0x0062
            boolean r8 = r5.changedInstance(r12)
            if (r8 == 0) goto L_0x005f
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r8
        L_0x0062:
            r8 = r6 & 4
            if (r8 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r11 = r32
            goto L_0x007d
        L_0x006b:
            r8 = r13 & 3072(0xc00, float:4.305E-42)
            r11 = r32
            if (r8 != 0) goto L_0x007d
            boolean r8 = r5.changed((java.lang.Object) r11)
            if (r8 == 0) goto L_0x007a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r8
        L_0x007d:
            r8 = r6 & 8
            if (r8 == 0) goto L_0x0084
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r9 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0097
            r9 = r33
            boolean r10 = r5.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0093
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r10
            goto L_0x0099
        L_0x0097:
            r9 = r33
        L_0x0099:
            r10 = r6 & 16
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a1
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00a1:
            r15 = r15 & r13
            if (r15 != 0) goto L_0x00b4
            r15 = r34
            boolean r16 = r5.changed((boolean) r15)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r16
            goto L_0x00b6
        L_0x00b4:
            r15 = r34
        L_0x00b6:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00d0
            r16 = r6 & 32
            r4 = r35
            if (r16 != 0) goto L_0x00cb
            boolean r16 = r5.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r4 = r35
        L_0x00d2:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00ec
            r16 = r6 & 64
            r2 = r36
            if (r16 != 0) goto L_0x00e7
            boolean r17 = r5.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00e7
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00e7:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e9:
            r3 = r3 | r17
            goto L_0x00ee
        L_0x00ec:
            r2 = r36
        L_0x00ee:
            r7 = r6 & 128(0x80, float:1.794E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r7 == 0) goto L_0x00f9
            r3 = r3 | r18
            r2 = r37
            goto L_0x010c
        L_0x00f9:
            r18 = r13 & r18
            r2 = r37
            if (r18 != 0) goto L_0x010c
            boolean r18 = r5.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x0108
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010a
        L_0x0108:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010a:
            r3 = r3 | r18
        L_0x010c:
            r2 = r6 & 256(0x100, float:3.59E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0117
            r3 = r3 | r18
            r4 = r38
            goto L_0x012a
        L_0x0117:
            r18 = r13 & r18
            r4 = r38
            if (r18 != 0) goto L_0x012a
            boolean r18 = r5.changedInstance(r4)
            if (r18 == 0) goto L_0x0126
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0128
        L_0x0126:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0128:
            r3 = r3 | r18
        L_0x012a:
            r4 = r6 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0131
            r4 = r42 | 6
            goto L_0x0143
        L_0x0131:
            r4 = r42 & 6
            if (r4 != 0) goto L_0x0141
            boolean r4 = r5.changedInstance(r14)
            if (r4 == 0) goto L_0x013d
            r4 = 4
            goto L_0x013e
        L_0x013d:
            r4 = 2
        L_0x013e:
            r4 = r42 | r4
            goto L_0x0143
        L_0x0141:
            r4 = r42
        L_0x0143:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r9 = r3 & r18
            r11 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r11) goto L_0x016b
            r9 = r4 & 3
            r11 = 2
            if (r9 != r11) goto L_0x016b
            boolean r9 = r5.getSkipping()
            if (r9 != 0) goto L_0x0159
            goto L_0x016b
        L_0x0159:
            r5.skipToGroupEnd()
            r7 = r35
            r8 = r36
            r9 = r37
            r10 = r38
            r21 = r5
            r6 = r15
            r5 = r33
            goto L_0x02d4
        L_0x016b:
            r5.startDefaults()
            r9 = r13 & 1
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r11 = 6
            if (r9 == 0) goto L_0x019f
            boolean r9 = r5.getDefaultsInvalid()
            if (r9 == 0) goto L_0x017d
            goto L_0x019f
        L_0x017d:
            r5.skipToGroupEnd()
            r2 = r6 & 32
            if (r2 == 0) goto L_0x0186
            r3 = r3 & r17
        L_0x0186:
            r2 = r6 & 64
            if (r2 == 0) goto L_0x018e
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r2
        L_0x018e:
            r25 = r33
            r2 = r35
            r26 = r36
            r27 = r37
            r11 = r38
            r28 = r15
            r15 = r3
            r3 = r28
            goto L_0x0221
        L_0x019f:
            if (r8 == 0) goto L_0x01a6
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            goto L_0x01a8
        L_0x01a6:
            r8 = r33
        L_0x01a8:
            if (r10 == 0) goto L_0x01ab
            r15 = 1
        L_0x01ab:
            r9 = r6 & 32
            if (r9 == 0) goto L_0x01b8
            androidx.compose.material3.SegmentedButtonDefaults r9 = androidx.compose.material3.SegmentedButtonDefaults.INSTANCE
            androidx.compose.material3.SegmentedButtonColors r9 = r9.colors(r5, r11)
            r3 = r3 & r17
            goto L_0x01ba
        L_0x01b8:
            r9 = r35
        L_0x01ba:
            r10 = r6 & 64
            if (r10 == 0) goto L_0x01d4
            androidx.compose.material3.SegmentedButtonDefaults r19 = androidx.compose.material3.SegmentedButtonDefaults.INSTANCE
            long r20 = r9.m2122borderColorWaAFU9c$material3_release(r15, r0)
            r23 = 2
            r24 = 0
            r22 = 0
            androidx.compose.foundation.BorderStroke r10 = androidx.compose.material3.SegmentedButtonDefaults.m2139borderStrokel07J4OM$default(r19, r20, r22, r23, r24)
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r17
            goto L_0x01d6
        L_0x01d4:
            r10 = r36
        L_0x01d6:
            if (r7 == 0) goto L_0x01fc
            r7 = -773600241(0xffffffffd1e3cc0f, float:-1.22297639E11)
            r5.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):SegmentedButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r7)
            java.lang.Object r7 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r17.getEmpty()
            if (r7 != r11) goto L_0x01f6
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r5.updateRememberedValue(r7)
        L_0x01f6:
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = (androidx.compose.foundation.interaction.MutableInteractionSource) r7
            r5.endReplaceableGroup()
            goto L_0x01fe
        L_0x01fc:
            r7 = r37
        L_0x01fe:
            if (r2 == 0) goto L_0x0213
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$6 r2 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$6
            r2.<init>(r0)
            r11 = 1235063168(0x499d9180, float:1290800.0)
            r33 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r11, r3, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r11 = r2
            goto L_0x0217
        L_0x0213:
            r33 = r3
            r11 = r38
        L_0x0217:
            r27 = r7
            r25 = r8
            r2 = r9
            r26 = r10
            r3 = r15
            r15 = r33
        L_0x0221:
            r5.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0232
            java.lang.String r7 = "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:216)"
            r8 = -1016574361(0xffffffffc3684e67, float:-232.30626)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r15, r4, r7)
        L_0x0232:
            long r7 = r2.m2123containerColorWaAFU9c$material3_release(r3, r0)
            long r9 = r2.m2124contentColorWaAFU9c$material3_release(r3, r0)
            r4 = r27
            androidx.compose.foundation.interaction.InteractionSource r4 = (androidx.compose.foundation.interaction.InteractionSource) r4
            int r16 = r15 >> 24
            r33 = r2
            r2 = r16 & 14
            androidx.compose.runtime.State r4 = interactionCountAsState(r4, r5, r2)
            r19 = r1
            androidx.compose.foundation.layout.RowScope r19 = (androidx.compose.foundation.layout.RowScope) r19
            r23 = 2
            r24 = 0
            r21 = 1065353216(0x3f800000, float:1.0)
            r22 = 0
            r20 = r25
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r19, r20, r21, r22, r23, r24)
            androidx.compose.ui.Modifier r1 = interactionZIndex(r1, r0, r4)
            androidx.compose.material3.ButtonDefaults r4 = androidx.compose.material3.ButtonDefaults.INSTANCE
            float r4 = r4.m1561getMinWidthD9Ej5fM()
            androidx.compose.material3.ButtonDefaults r16 = androidx.compose.material3.ButtonDefaults.INSTANCE
            float r0 = r16.m1560getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m726defaultMinSizeVpY3zN4(r1, r4, r0)
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7 r1 = androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4 = 0
            r16 = r3
            r3 = 0
            r6 = 1
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r3, r1, r6, r4)
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$8 r0 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$8
            r0.<init>(r11, r14)
            r1 = 383378045(0x16d9e27d, float:3.5201175E-25)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r1, r6, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3 = r15
            r15 = r0
            int r0 = r3 >> 3
            r0 = r0 & 126(0x7e, float:1.77E-43)
            int r1 = r3 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            int r6 = r3 << 3
            r1 = r1 & r6
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = 6
            int r3 = r3 << r6
            r1 = r1 & r3
            r17 = r0 | r1
            r18 = r2 | 48
            r19 = 384(0x180, float:5.38E-43)
            r0 = 0
            r1 = r11
            r11 = r0
            r12 = r0
            r0 = r33
            r2 = r30
            r20 = r16
            r3 = r31
            r21 = r5
            r5 = r20
            r6 = r32
            r13 = r26
            r14 = r27
            r16 = r21
            androidx.compose.material3.SurfaceKt.m2304Surfaced85dljk((boolean) r2, (kotlin.jvm.functions.Function0<kotlin.Unit>) r3, (androidx.compose.ui.Modifier) r4, (boolean) r5, (androidx.compose.ui.graphics.Shape) r6, (long) r7, (long) r9, (float) r11, (float) r12, (androidx.compose.foundation.BorderStroke) r13, (androidx.compose.foundation.interaction.MutableInteractionSource) r14, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02ca
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ca:
            r7 = r0
            r10 = r1
            r6 = r20
            r5 = r25
            r8 = r26
            r9 = r27
        L_0x02d4:
            androidx.compose.runtime.ScopeUpdateScope r15 = r21.endRestartGroup()
            if (r15 == 0) goto L_0x02f8
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$9 r16 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$9
            r0 = r16
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
            r11 = r39
            r12 = r41
            r13 = r42
            r14 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonKt.SegmentedButton(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SegmentedButtonColors, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ  reason: not valid java name */
    public static final void m2145SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, Function3<? super SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1520863498);
        ComposerKt.sourceInformation(startRestartGroup, "C(SingleChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)266@12418L423:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m2142getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520863498, i3, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:265)");
            }
            Modifier width = IntrinsicKt.width(SizeKt.m727defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(modifier), 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3007getContainerHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m537spacedBy0680j_4(Dp.m6614constructorimpl(-f)), centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(width);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r6, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -181589436, "C274@12753L58,275@12826L9:SegmentedButton.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(-181589424);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SegmentedButton.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SingleChoiceSegmentedButtonScopeWrapper(rowScope);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            function3.invoke((SingleChoiceSegmentedButtonScopeWrapper) rememberedValue, startRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
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
        float f2 = f;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SegmentedButtonKt$SingleChoiceSegmentedButtonRow$2(modifier2, f2, function3, i, i2));
        }
    }

    /* renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ  reason: not valid java name */
    public static final void m2144MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, Function3<? super MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(155922315);
        ComposerKt.sourceInformation(startRestartGroup, "C(MultiChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)304@13910L391:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m2142getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(155922315, i3, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:303)");
            }
            Modifier width = IntrinsicKt.width(SizeKt.m727defaultMinSizeVpY3zN4$default(modifier, 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3007getContainerHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m537spacedBy0680j_4(Dp.m6614constructorimpl(-f)), centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(width);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r6, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 573415822, "C311@14214L57,312@14286L9:SegmentedButton.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(573415834);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SegmentedButton.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MultiChoiceSegmentedButtonScopeWrapper(rowScope);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            function3.invoke((MultiChoiceSegmentedButtonScopeWrapper) rememberedValue, startRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
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
        float f2 = f;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SegmentedButtonKt$MultiChoiceSegmentedButtonRow$2(modifier2, f2, function3, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void SegmentedButtonContent(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1464121570);
        ComposerKt.sourceInformation(startRestartGroup, "C(SegmentedButtonContent)P(1)322@14458L637:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464121570, i2, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:321)");
            }
            Alignment center = Alignment.Companion.getCenter();
            Modifier padding = PaddingKt.padding(Modifier.Companion, ButtonDefaults.INSTANCE.getTextButtonContentPadding());
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
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
            Composer r6 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r6, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 372432274, "C327@14644L10,328@14718L371:SegmentedButton.kt#uh7d8r");
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1420592651, true, new SegmentedButtonKt$SegmentedButtonContent$1$1(function2, function22)), startRestartGroup, 48);
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
            endRestartGroup.updateScope(new SegmentedButtonKt$SegmentedButtonContent$2(function2, function22, i));
        }
    }

    private static final State<Integer> interactionCountAsState(InteractionSource interactionSource, Composer composer, int i) {
        composer.startReplaceableGroup(281890131);
        ComposerKt.sourceInformation(composer, "C(interactionCountAsState)399@17334L33,400@17393L500,400@17372L521:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, i, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:398)");
        }
        composer.startReplaceableGroup(-1372284393);
        ComposerKt.sourceInformation(composer, "CC(remember):SegmentedButton.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        boolean z = false;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableIntState mutableIntState = (MutableIntState) rememberedValue;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-1372284334);
        ComposerKt.sourceInformation(composer, "CC(remember):SegmentedButton.kt#9igjgp");
        int i2 = i & 14;
        if (((i2 ^ 6) > 4 && composer.changed((Object) interactionSource)) || (i & 6) == 4) {
            z = true;
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new SegmentedButtonKt$interactionCountAsState$1$1(interactionSource, mutableIntState, (Continuation<? super SegmentedButtonKt$interactionCountAsState$1$1>) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect((Object) interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableIntState;
    }

    private static final Modifier interactionZIndex(Modifier modifier, boolean z, State<Integer> state) {
        return LayoutModifierKt.layout(modifier, new SegmentedButtonKt$interactionZIndex$1(state, z));
    }
}
