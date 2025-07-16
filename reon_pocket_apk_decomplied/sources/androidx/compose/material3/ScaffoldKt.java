package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001f\u001a\u00020 2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a±\u0001\u0010$\u001a\u00020\u00142\b\b\u0002\u0010%\u001a\u00020&2\u0013\b\u0002\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0001\u0010/\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001f\u001a\u00020 2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b0\u0010#\u001a\u0001\u00101\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001f\u001a\u00020 2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u0010#\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"1\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0002¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "<set-?>", "", "ScaffoldSubcomposeInMeasureFix", "getScaffoldSubcomposeInMeasureFix$annotations", "()V", "getScaffoldSubcomposeInMeasureFix", "()Z", "setScaffoldSubcomposeInMeasureFix", "(Z)V", "ScaffoldSubcomposeInMeasureFix$delegate", "Landroidx/compose/runtime/MutableState;", "LegacyScaffoldLayout", "", "fabPosition", "Landroidx/compose/material3/FabPosition;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "snackbar", "fab", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "bottomBar", "LegacyScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scaffold", "modifier", "Landroidx/compose/ui/Modifier;", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "ScaffoldLayout-FMILGgc", "ScaffoldLayoutWithMeasureFix", "ScaffoldLayoutWithMeasureFix-FMILGgc", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
public final class ScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m6614constructorimpl((float) 16);
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(ScaffoldKt$LocalFabPlacement$1.INSTANCE);
    private static final MutableState ScaffoldSubcomposeInMeasureFix$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);

    public static /* synthetic */ void getScaffoldSubcomposeInMeasureFix$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: androidx.compose.material3.MutableWindowInsets} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0120  */
    /* renamed from: Scaffold-TvnljyQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2098ScaffoldTvnljyQ(androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, int r33, long r34, long r36, androidx.compose.foundation.layout.WindowInsets r38, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r13 = r41
            r14 = r42
            r0 = -1219521777(0xffffffffb74f930f, float:-1.2372401E-5)
            r1 = r40
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Scaffold)P(7,9!1,8,5,6:c#material3.FabPosition,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4)92@4736L11,93@4786L31,94@4876L19,97@4971L86,101@5129L212,100@5062L664:Scaffold.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r14 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r13 | 6
            r4 = r3
            r3 = r28
            goto L_0x0030
        L_0x001c:
            r3 = r13 & 6
            if (r3 != 0) goto L_0x002d
            r3 = r28
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r13
            goto L_0x0030
        L_0x002d:
            r3 = r28
            r4 = r13
        L_0x0030:
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            goto L_0x004a
        L_0x0037:
            r6 = r13 & 48
            if (r6 != 0) goto L_0x004a
            r6 = r29
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x0046
            r7 = 32
            goto L_0x0048
        L_0x0046:
            r7 = 16
        L_0x0048:
            r4 = r4 | r7
            goto L_0x004c
        L_0x004a:
            r6 = r29
        L_0x004c:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0053
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r8 = r13 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0066
            r8 = r30
            boolean r9 = r1.changedInstance(r8)
            if (r9 == 0) goto L_0x0062
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r4 = r4 | r9
            goto L_0x0068
        L_0x0066:
            r8 = r30
        L_0x0068:
            r9 = r14 & 8
            if (r9 == 0) goto L_0x006f
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r10 = r13 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0082
            r10 = r31
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x007e
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r4 = r4 | r11
            goto L_0x0084
        L_0x0082:
            r10 = r31
        L_0x0084:
            r11 = r14 & 16
            if (r11 == 0) goto L_0x008b
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008b:
            r12 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009e
            r12 = r32
            boolean r15 = r1.changedInstance(r12)
            if (r15 == 0) goto L_0x009a
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r4 = r4 | r15
            goto L_0x00a0
        L_0x009e:
            r12 = r32
        L_0x00a0:
            r15 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00ab
            r4 = r4 | r16
            r0 = r33
            goto L_0x00be
        L_0x00ab:
            r16 = r13 & r16
            r0 = r33
            if (r16 != 0) goto L_0x00be
            boolean r17 = r1.changed((int) r0)
            if (r17 == 0) goto L_0x00ba
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r4 = r4 | r17
        L_0x00be:
            r17 = 1572864(0x180000, float:2.204052E-39)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00da
            r17 = r14 & 64
            r40 = r11
            r10 = r34
            if (r17 != 0) goto L_0x00d5
            boolean r17 = r1.changed((long) r10)
            if (r17 == 0) goto L_0x00d5
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r4 = r4 | r17
            goto L_0x00de
        L_0x00da:
            r40 = r11
            r10 = r34
        L_0x00de:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r18 = r13 & r17
            if (r18 != 0) goto L_0x00f7
            r0 = r14 & 128(0x80, float:1.794E-43)
            r10 = r36
            if (r0 != 0) goto L_0x00f3
            boolean r0 = r1.changed((long) r10)
            if (r0 == 0) goto L_0x00f3
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f3:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r4 = r4 | r0
            goto L_0x00f9
        L_0x00f7:
            r10 = r36
        L_0x00f9:
            r0 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r13 & r0
            if (r18 != 0) goto L_0x0115
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010e
            r0 = r38
            boolean r20 = r1.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x0110
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0112
        L_0x010e:
            r0 = r38
        L_0x0110:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0112:
            r4 = r4 | r20
            goto L_0x0117
        L_0x0115:
            r0 = r38
        L_0x0117:
            r0 = r14 & 512(0x200, float:7.175E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0120
            r4 = r4 | r20
            goto L_0x0134
        L_0x0120:
            r0 = r13 & r20
            if (r0 != 0) goto L_0x0134
            r0 = r39
            boolean r20 = r1.changedInstance(r0)
            if (r20 == 0) goto L_0x012f
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0131
        L_0x012f:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0131:
            r4 = r4 | r20
            goto L_0x0136
        L_0x0134:
            r0 = r39
        L_0x0136:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r4 & r20
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x0159
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0147
            goto L_0x0159
        L_0x0147:
            r1.skipToGroupEnd()
            r2 = r28
            r4 = r31
            r13 = r38
            r3 = r8
            r5 = r12
            r8 = r33
            r11 = r10
            r9 = r34
            goto L_0x02ef
        L_0x0159:
            r1.startDefaults()
            r0 = r13 & 1
            r3 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r20 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r21 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0194
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0170
            goto L_0x0194
        L_0x0170:
            r1.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x0179
            r4 = r4 & r21
        L_0x0179:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x017f
            r4 = r4 & r20
        L_0x017f:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0184
            r4 = r4 & r3
        L_0x0184:
            r0 = r28
            r9 = r4
            r2 = r6
            r5 = r8
            r7 = r12
            r6 = r31
            r8 = r33
            r3 = r34
        L_0x0190:
            r12 = r38
            goto L_0x0205
        L_0x0194:
            if (r2 == 0) goto L_0x019b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x019d
        L_0x019b:
            r0 = r28
        L_0x019d:
            if (r5 == 0) goto L_0x01a6
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r2 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r2 = r2.m1716getLambda1$material3_release()
            goto L_0x01a7
        L_0x01a6:
            r2 = r6
        L_0x01a7:
            if (r7 == 0) goto L_0x01b0
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r5 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r5 = r5.m1717getLambda2$material3_release()
            goto L_0x01b1
        L_0x01b0:
            r5 = r8
        L_0x01b1:
            if (r9 == 0) goto L_0x01ba
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r6 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r6 = r6.m1718getLambda3$material3_release()
            goto L_0x01bc
        L_0x01ba:
            r6 = r31
        L_0x01bc:
            if (r40 == 0) goto L_0x01c5
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r7 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r7 = r7.m1719getLambda4$material3_release()
            goto L_0x01c6
        L_0x01c5:
            r7 = r12
        L_0x01c6:
            if (r15 == 0) goto L_0x01cf
            androidx.compose.material3.FabPosition$Companion r8 = androidx.compose.material3.FabPosition.Companion
            int r8 = r8.m1862getEndERTFSPs()
            goto L_0x01d1
        L_0x01cf:
            r8 = r33
        L_0x01d1:
            r9 = r14 & 64
            r12 = 6
            if (r9 == 0) goto L_0x01e6
            androidx.compose.material3.MaterialTheme r9 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r9 = r9.getColorScheme(r1, r12)
            long r22 = r9.m1643getBackground0d7_KjU()
            r4 = r4 & r21
            r9 = r4
            r3 = r22
            goto L_0x01e9
        L_0x01e6:
            r9 = r4
            r3 = r34
        L_0x01e9:
            r15 = r14 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x01f7
            int r10 = r9 >> 18
            r10 = r10 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r3, r1, r10)
            r9 = r9 & r20
        L_0x01f7:
            r15 = r14 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L_0x0190
            androidx.compose.material3.ScaffoldDefaults r15 = androidx.compose.material3.ScaffoldDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r12 = r15.getContentWindowInsets(r1, r12)
            r15 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r9 = r9 & r15
        L_0x0205:
            r1.endDefaults()
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0217
            r15 = -1
            java.lang.String r13 = "androidx.compose.material3.Scaffold (Scaffold.kt:96)"
            r14 = -1219521777(0xffffffffb74f930f, float:-1.2372401E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r9, r15, r13)
        L_0x0217:
            r13 = -889185358(0xffffffffcb001bb2, float:-8395698.0)
            r1.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember):Scaffold.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            r13 = r13 & r9
            r14 = 100663296(0x6000000, float:2.4074124E-35)
            r13 = r13 ^ r14
            r15 = 67108864(0x4000000, float:1.5046328E-36)
            if (r13 <= r15) goto L_0x0236
            boolean r16 = r1.changed((java.lang.Object) r12)
            if (r16 != 0) goto L_0x0233
            goto L_0x0236
        L_0x0233:
            r37 = r10
            goto L_0x023c
        L_0x0236:
            r37 = r10
            r10 = r9 & r14
            if (r10 != r15) goto L_0x023e
        L_0x023c:
            r10 = 1
            goto L_0x023f
        L_0x023e:
            r10 = 0
        L_0x023f:
            java.lang.Object r11 = r1.rememberedValue()
            if (r10 != 0) goto L_0x024d
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0255
        L_0x024d:
            androidx.compose.material3.MutableWindowInsets r11 = new androidx.compose.material3.MutableWindowInsets
            r11.<init>(r12)
            r1.updateRememberedValue(r11)
        L_0x0255:
            r10 = r11
            androidx.compose.material3.MutableWindowInsets r10 = (androidx.compose.material3.MutableWindowInsets) r10
            r1.endReplaceableGroup()
            r11 = -889185200(0xffffffffcb001c50, float:-8395856.0)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember):Scaffold.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            boolean r11 = r1.changed((java.lang.Object) r10)
            r14 = 67108864(0x4000000, float:1.5046328E-36)
            if (r13 <= r14) goto L_0x0274
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 != 0) goto L_0x0279
        L_0x0274:
            r13 = 100663296(0x6000000, float:2.4074124E-35)
            r13 = r13 & r9
            if (r13 != r14) goto L_0x027b
        L_0x0279:
            r13 = 1
            goto L_0x027c
        L_0x027b:
            r13 = 0
        L_0x027c:
            r11 = r11 | r13
            java.lang.Object r13 = r1.rememberedValue()
            if (r11 != 0) goto L_0x028b
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r13 != r11) goto L_0x0296
        L_0x028b:
            androidx.compose.material3.ScaffoldKt$Scaffold$1$1 r11 = new androidx.compose.material3.ScaffoldKt$Scaffold$1$1
            r11.<init>(r10, r12)
            r13 = r11
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r1.updateRememberedValue(r13)
        L_0x0296:
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(r0, r13)
            androidx.compose.material3.ScaffoldKt$Scaffold$2 r11 = new androidx.compose.material3.ScaffoldKt$Scaffold$2
            r28 = r11
            r29 = r8
            r30 = r2
            r31 = r39
            r32 = r6
            r33 = r7
            r34 = r10
            r35 = r5
            r28.<init>(r29, r30, r31, r32, r33, r34, r35)
            r10 = -1979205334(0xffffffff8a07b92a, float:-6.534839E-33)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r10, r13, r11)
            r24 = r10
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            int r9 = r9 >> 12
            r10 = r9 & 896(0x380, float:1.256E-42)
            r10 = r10 | r17
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r26 = r10 | r9
            r27 = 114(0x72, float:1.6E-43)
            r16 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r17 = r3
            r19 = r37
            r25 = r1
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r27)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x02e6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e6:
            r9 = r3
            r3 = r5
            r4 = r6
            r5 = r7
            r13 = r12
            r11 = r37
            r6 = r2
            r2 = r0
        L_0x02ef:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 == 0) goto L_0x030f
            androidx.compose.material3.ScaffoldKt$Scaffold$3 r16 = new androidx.compose.material3.ScaffoldKt$Scaffold$3
            r0 = r16
            r1 = r2
            r2 = r6
            r6 = r8
            r7 = r9
            r9 = r11
            r11 = r13
            r12 = r39
            r13 = r41
            r14 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x030f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ScaffoldKt.m2098ScaffoldTvnljyQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, long, long, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-FMILGgc  reason: not valid java name */
    public static final void m2099ScaffoldLayoutFMILGgc(int i, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i2) {
        int i3;
        int i4 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-975511942);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2):Scaffold.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            int i5 = i;
            i3 = i4;
        }
        if ((i4 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        }
        if ((i4 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        } else {
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32 = function3;
        }
        if ((i4 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        }
        if ((i4 & CpioConstants.C_ISBLK) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        }
        WindowInsets windowInsets2 = windowInsets;
        if ((196608 & i4) == 0) {
            i3 |= startRestartGroup.changed((Object) windowInsets2) ? 131072 : 65536;
        }
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        if ((1572864 & i4) == 0) {
            i3 |= startRestartGroup.changedInstance(function28) ? 1048576 : 524288;
        }
        if ((599187 & i3) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, i3, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:141)");
            }
            if (getScaffoldSubcomposeInMeasureFix()) {
                startRestartGroup.startReplaceableGroup(-915303637);
                ComposerKt.sourceInformation(startRestartGroup, "143@6712L283");
                m2100ScaffoldLayoutWithMeasureFixFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, startRestartGroup, i3 & 4194302);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-915303332);
                ComposerKt.sourceInformation(startRestartGroup, "153@7017L275");
                m2097LegacyScaffoldLayoutFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, startRestartGroup, i3 & 4194302);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$1(i, function2, function3, function22, function23, windowInsets, function24, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ScaffoldLayoutWithMeasureFix-FMILGgc  reason: not valid java name */
    public static final void m2100ScaffoldLayoutWithMeasureFixFMILGgc(int i, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i2) {
        int i3;
        int i4;
        Function2 function25;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-2037614249);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayoutWithMeasureFix)P(4:c#material3.FabPosition,6,1,5,3,2)178@7738L6567,178@7721L6584:Scaffold.kt#uh7d8r");
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i5;
        } else {
            int i6 = i;
            i3 = i5;
        }
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        }
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        } else {
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32 = function3;
        }
        Function2<? super Composer, ? super Integer, Unit> function27 = function22;
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function27) ? 2048 : 1024;
        }
        Function2<? super Composer, ? super Integer, Unit> function28 = function23;
        if ((i5 & CpioConstants.C_ISBLK) == 0) {
            i3 |= startRestartGroup.changedInstance(function28) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i3 |= startRestartGroup.changed((Object) windowInsets) ? 131072 : 65536;
        } else {
            WindowInsets windowInsets2 = windowInsets;
        }
        Function2<? super Composer, ? super Integer, Unit> function29 = function24;
        if ((i5 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function29) ? 1048576 : 524288;
        }
        if ((i3 & 599187) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2037614249, i3, -1, "androidx.compose.material3.ScaffoldLayoutWithMeasureFix (Scaffold.kt:177)");
            }
            startRestartGroup.startReplaceableGroup(-273325894);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
            boolean z = ((i3 & 112) == 32) | ((i3 & 7168) == 2048) | ((458752 & i3) == 131072) | ((57344 & i3) == 16384) | ((i3 & 14) == 4) | ((3670016 & i3) == 1048576) | ((i3 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                i4 = 0;
                function25 = new ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1(function2, function22, function23, i, windowInsets, function24, function3);
                startRestartGroup.updateRememberedValue(function25);
            } else {
                function25 = rememberedValue;
                i4 = 0;
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, function25, startRestartGroup, i4, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayoutWithMeasureFix$2(i, function2, function3, function22, function23, windowInsets, function24, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: LegacyScaffoldLayout-FMILGgc  reason: not valid java name */
    public static final void m2097LegacyScaffoldLayoutFMILGgc(int i, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i2) {
        int i3;
        int i4;
        Function2 function25;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1307205667);
        ComposerKt.sourceInformation(startRestartGroup, "C(LegacyScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)348@14737L6941,348@14720L6958:Scaffold.kt#uh7d8r");
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i5;
        } else {
            int i6 = i;
            i3 = i5;
        }
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        }
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        } else {
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32 = function3;
        }
        Function2<? super Composer, ? super Integer, Unit> function27 = function22;
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function27) ? 2048 : 1024;
        }
        Function2<? super Composer, ? super Integer, Unit> function28 = function23;
        if ((i5 & CpioConstants.C_ISBLK) == 0) {
            i3 |= startRestartGroup.changedInstance(function28) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i3 |= startRestartGroup.changed((Object) windowInsets) ? 131072 : 65536;
        } else {
            WindowInsets windowInsets2 = windowInsets;
        }
        Function2<? super Composer, ? super Integer, Unit> function29 = function24;
        if ((i5 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function29) ? 1048576 : 524288;
        }
        if ((i3 & 599187) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1307205667, i3, -1, "androidx.compose.material3.LegacyScaffoldLayout (Scaffold.kt:347)");
            }
            startRestartGroup.startReplaceableGroup(1646578117);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
            boolean z = ((i3 & 112) == 32) | ((i3 & 7168) == 2048) | ((458752 & i3) == 131072) | ((57344 & i3) == 16384) | ((i3 & 14) == 4) | ((3670016 & i3) == 1048576) | ((i3 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                i4 = 0;
                function25 = new ScaffoldKt$LegacyScaffoldLayout$1$1(function2, function22, function23, i, windowInsets, function24, function3);
                startRestartGroup.updateRememberedValue(function25);
            } else {
                function25 = rememberedValue;
                i4 = 0;
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, function25, startRestartGroup, i4, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ScaffoldKt$LegacyScaffoldLayout$2(i, function2, function3, function22, function23, windowInsets, function24, i2));
        }
    }

    public static final boolean getScaffoldSubcomposeInMeasureFix() {
        return ((Boolean) ScaffoldSubcomposeInMeasureFix$delegate.getValue()).booleanValue();
    }

    public static final void setScaffoldSubcomposeInMeasureFix(boolean z) {
        ScaffoldSubcomposeInMeasureFix$delegate.setValue(Boolean.valueOf(z));
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
