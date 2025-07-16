package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u0001\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e¢\u0006\u0002\b\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
public final class LazyListKt {
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyList(androidx.compose.ui.Modifier r36, androidx.compose.foundation.lazy.LazyListState r37, androidx.compose.foundation.layout.PaddingValues r38, boolean r39, boolean r40, androidx.compose.foundation.gestures.FlingBehavior r41, boolean r42, int r43, androidx.compose.ui.Alignment.Horizontal r44, androidx.compose.foundation.layout.Arrangement.Vertical r45, androidx.compose.ui.Alignment.Vertical r46, androidx.compose.foundation.layout.Arrangement.Horizontal r47, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, int r50, int r51, int r52) {
        /*
            r1 = r36
            r15 = r37
            r0 = r39
            r14 = r40
            r13 = r48
            r12 = r50
            r11 = r51
            r10 = r52
            r2 = 620764179(0x25001c13, float:1.1111742E-16)
            r3 = r49
            androidx.compose.runtime.Composer r9 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)80@3813L50,82@3889L48,83@3954L24,86@4037L292,99@4377L18,105@4632L277,114@5029L153,120@5345L7,113@4973L481,128@5678L7,101@4487L1676:LazyList.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r3)
            r3 = r10 & 1
            if (r3 == 0) goto L_0x0025
            r3 = r12 | 6
            goto L_0x0035
        L_0x0025:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0034
            boolean r3 = r9.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0031
            r3 = 4
            goto L_0x0032
        L_0x0031:
            r3 = 2
        L_0x0032:
            r3 = r3 | r12
            goto L_0x0035
        L_0x0034:
            r3 = r12
        L_0x0035:
            r6 = r10 & 2
            if (r6 == 0) goto L_0x003c
            r3 = r3 | 48
            goto L_0x004c
        L_0x003c:
            r6 = r12 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            boolean r6 = r9.changed((java.lang.Object) r15)
            if (r6 == 0) goto L_0x0049
            r6 = 32
            goto L_0x004b
        L_0x0049:
            r6 = 16
        L_0x004b:
            r3 = r3 | r6
        L_0x004c:
            r6 = r10 & 4
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0057
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0057:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006b
            r6 = r38
            boolean r18 = r9.changed((java.lang.Object) r6)
            if (r18 == 0) goto L_0x0066
            r18 = r16
            goto L_0x0068
        L_0x0066:
            r18 = r17
        L_0x0068:
            r3 = r3 | r18
            goto L_0x006d
        L_0x006b:
            r6 = r38
        L_0x006d:
            r18 = r10 & 8
            if (r18 == 0) goto L_0x0074
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0074:
            r4 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0084
            boolean r4 = r9.changed((boolean) r0)
            if (r4 == 0) goto L_0x0081
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r3 = r3 | r4
        L_0x0084:
            r4 = r10 & 16
            r18 = 57344(0xe000, float:8.0356E-41)
            if (r4 == 0) goto L_0x008e
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008e:
            r4 = r12 & r18
            if (r4 != 0) goto L_0x009e
            boolean r4 = r9.changed((boolean) r14)
            if (r4 == 0) goto L_0x009b
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r3 = r3 | r4
        L_0x009e:
            r4 = r10 & 32
            r19 = 458752(0x70000, float:6.42848E-40)
            if (r4 == 0) goto L_0x00a8
            r4 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r4
            goto L_0x00bc
        L_0x00a8:
            r4 = r12 & r19
            if (r4 != 0) goto L_0x00bc
            r4 = r41
            boolean r20 = r9.changed((java.lang.Object) r4)
            if (r20 == 0) goto L_0x00b7
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r3 = r3 | r20
            goto L_0x00be
        L_0x00bc:
            r4 = r41
        L_0x00be:
            r20 = r10 & 64
            r21 = 3670016(0x380000, float:5.142788E-39)
            if (r20 == 0) goto L_0x00cb
            r20 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r20
            r2 = r42
            goto L_0x00de
        L_0x00cb:
            r20 = r12 & r21
            r2 = r42
            if (r20 != 0) goto L_0x00de
            boolean r22 = r9.changed((boolean) r2)
            if (r22 == 0) goto L_0x00da
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r3 = r3 | r22
        L_0x00de:
            r5 = r10 & 128(0x80, float:1.794E-43)
            r23 = 29360128(0x1c00000, float:7.052966E-38)
            if (r5 == 0) goto L_0x00eb
            r24 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r24
            r7 = r43
            goto L_0x00fe
        L_0x00eb:
            r24 = r12 & r23
            r7 = r43
            if (r24 != 0) goto L_0x00fe
            boolean r25 = r9.changed((int) r7)
            if (r25 == 0) goto L_0x00fa
            r25 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00fa:
            r25 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r3 = r3 | r25
        L_0x00fe:
            r8 = r10 & 256(0x100, float:3.59E-43)
            r26 = 234881024(0xe000000, float:1.5777218E-30)
            if (r8 == 0) goto L_0x010b
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r27
            r2 = r44
            goto L_0x011e
        L_0x010b:
            r27 = r12 & r26
            r2 = r44
            if (r27 != 0) goto L_0x011e
            boolean r27 = r9.changed((java.lang.Object) r2)
            if (r27 == 0) goto L_0x011a
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011c
        L_0x011a:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011c:
            r3 = r3 | r27
        L_0x011e:
            r2 = r10 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0129
            r27 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r27
            r4 = r45
            goto L_0x013e
        L_0x0129:
            r27 = 1879048192(0x70000000, float:1.58456325E29)
            r27 = r12 & r27
            r4 = r45
            if (r27 != 0) goto L_0x013e
            boolean r27 = r9.changed((java.lang.Object) r4)
            if (r27 == 0) goto L_0x013a
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013c
        L_0x013a:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013c:
            r3 = r3 | r27
        L_0x013e:
            r4 = r10 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0147
            r22 = r11 | 6
            r6 = r46
            goto L_0x015d
        L_0x0147:
            r27 = r11 & 14
            r6 = r46
            if (r27 != 0) goto L_0x015b
            boolean r27 = r9.changed((java.lang.Object) r6)
            if (r27 == 0) goto L_0x0156
            r22 = 4
            goto L_0x0158
        L_0x0156:
            r22 = 2
        L_0x0158:
            r22 = r11 | r22
            goto L_0x015d
        L_0x015b:
            r22 = r11
        L_0x015d:
            r6 = r10 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0164
            r22 = r22 | 48
            goto L_0x0177
        L_0x0164:
            r27 = r11 & 112(0x70, float:1.57E-43)
            r7 = r47
            if (r27 != 0) goto L_0x0177
            boolean r27 = r9.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x0173
            r24 = 32
            goto L_0x0175
        L_0x0173:
            r24 = 16
        L_0x0175:
            r22 = r22 | r24
        L_0x0177:
            r7 = r22
            r12 = r10 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x0180
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x018f
        L_0x0180:
            r12 = r11 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x018f
            boolean r12 = r9.changedInstance(r13)
            if (r12 == 0) goto L_0x018b
            goto L_0x018d
        L_0x018b:
            r16 = r17
        L_0x018d:
            r7 = r7 | r16
        L_0x018f:
            r12 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r12 & r3
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r10) goto L_0x01b5
            r10 = r7 & 731(0x2db, float:1.024E-42)
            r12 = 146(0x92, float:2.05E-43)
            if (r10 != r12) goto L_0x01b5
            boolean r10 = r9.getSkipping()
            if (r10 != 0) goto L_0x01a5
            goto L_0x01b5
        L_0x01a5:
            r9.skipToGroupEnd()
            r8 = r43
            r10 = r45
            r11 = r46
            r32 = r47
            r12 = r9
            r9 = r44
            goto L_0x0356
        L_0x01b5:
            if (r5 == 0) goto L_0x01ba
            r5 = 0
            r12 = r5
            goto L_0x01bc
        L_0x01ba:
            r12 = r43
        L_0x01bc:
            r5 = 0
            if (r8 == 0) goto L_0x01c2
            r16 = r5
            goto L_0x01c4
        L_0x01c2:
            r16 = r44
        L_0x01c4:
            if (r2 == 0) goto L_0x01c9
            r17 = r5
            goto L_0x01cb
        L_0x01c9:
            r17 = r45
        L_0x01cb:
            if (r4 == 0) goto L_0x01d0
            r31 = r5
            goto L_0x01d2
        L_0x01d0:
            r31 = r46
        L_0x01d2:
            if (r6 == 0) goto L_0x01d7
            r32 = r5
            goto L_0x01d9
        L_0x01d7:
            r32 = r47
        L_0x01d9:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01e7
            java.lang.String r2 = "androidx.compose.foundation.lazy.LazyList (LazyList.kt:79)"
            r4 = 620764179(0x25001c13, float:1.1111742E-16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r7, r2)
        L_0x01e7:
            int r2 = r3 >> 3
            r20 = r2 & 14
            int r2 = r7 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r20 | r2
            kotlin.jvm.functions.Function0 r33 = androidx.compose.foundation.lazy.LazyListItemProviderKt.rememberLazyListItemProviderLambda(r15, r13, r9, r2)
            int r2 = r3 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r20 | r2
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r22 = androidx.compose.foundation.lazy.LazyListSemanticsKt.rememberLazyListSemanticState(r15, r14, r9, r2)
            r2 = 773894976(0x2e20b340, float:3.6538994E-11)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            java.lang.Object r2 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x0232
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r9)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r4.<init>(r2)
            r9.updateRememberedValue(r4)
            r2 = r4
        L_0x0232:
            r9.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r2 = r2.getCoroutineScope()
            r9.endReplaceableGroup()
            r15.setCoroutineScope$foundation_release(r2)
            r10 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = 65520(0xfff0, float:9.1813E-41)
            r2 = r2 & r3
            int r24 = r3 >> 6
            r4 = r24 & r19
            r2 = r2 | r4
            r4 = r24 & r21
            r2 = r2 | r4
            int r4 = r7 << 21
            r5 = r4 & r23
            r2 = r2 | r5
            r4 = r4 & r26
            r2 = r2 | r4
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r3
            r23 = r2 | r4
            r25 = 0
            r2 = r33
            r26 = r3
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r7 = r12
            r8 = r16
            r43 = r9
            r9 = r31
            r27 = r10
            r10 = r32
            r11 = r17
            r34 = r12
            r12 = r43
            r13 = r23
            r14 = r25
            kotlin.jvm.functions.Function2 r11 = rememberLazyListMeasurePolicy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            androidx.compose.foundation.gestures.ScrollableDefaults r2 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r10 = 6
            androidx.compose.foundation.OverscrollEffect r13 = r2.overscrollEffect(r12, r10)
            if (r40 == 0) goto L_0x028f
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0291
        L_0x028f:
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0291:
            r14 = r2
            androidx.compose.ui.layout.RemeasurementModifier r2 = r37.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = r1.then(r2)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r3 = r37.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r2 = r2.then(r3)
            r3 = r24 & r18
            int r4 = r26 << 6
            r4 = r4 & r19
            r9 = r3 | r4
            r3 = r33
            r4 = r22
            r5 = r14
            r6 = r42
            r7 = r39
            r8 = r12
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r2, r14)
            int r3 = r26 >> 18
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r20 | r3
            r9 = r34
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r3 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(r15, r9, r12, r3)
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r4 = r37.getBeyondBoundsInfo$foundation_release()
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r6, r7)
            java.lang.Object r5 = r12.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r6 = r5
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            int r5 = androidx.compose.runtime.collection.MutableVector.$stable
            int r5 = r5 << r10
            r5 = r5 | r27
            r7 = r26 & r21
            r10 = r5 | r7
            r5 = r39
            r7 = r14
            r8 = r42
            r18 = r9
            r9 = r12
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.Modifier r20 = androidx.compose.foundation.OverscrollKt.overscroll(r2, r13)
            androidx.compose.foundation.gestures.ScrollableDefaults r2 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r5)
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            boolean r25 = r2.reverseDirection(r3, r14, r0)
            androidx.compose.foundation.interaction.MutableInteractionSource r27 = r37.getInternalInteractionSource$foundation_release()
            r21 = r15
            androidx.compose.foundation.gestures.ScrollableState r21 = (androidx.compose.foundation.gestures.ScrollableState) r21
            r29 = 128(0x80, float:1.794E-43)
            r30 = 0
            r28 = 0
            r22 = r14
            r23 = r13
            r24 = r42
            r26 = r41
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r5 = r37.getPrefetchState$foundation_release()
            r8 = 0
            r9 = 0
            r3 = r33
            r6 = r11
            r7 = r12
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r3, (androidx.compose.ui.Modifier) r4, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x034e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x034e:
            r9 = r16
            r10 = r17
            r8 = r18
            r11 = r31
        L_0x0356:
            androidx.compose.runtime.ScopeUpdateScope r14 = r12.endRestartGroup()
            if (r14 == 0) goto L_0x0387
            androidx.compose.foundation.lazy.LazyListKt$LazyList$1 r17 = new androidx.compose.foundation.lazy.LazyListKt$LazyList$1
            r0 = r17
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            r6 = r41
            r7 = r42
            r12 = r32
            r13 = r48
            r15 = r14
            r14 = r50
            r35 = r15
            r15 = r51
            r16 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x0387:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(Function0<? extends LazyListItemProvider> function0, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(183156450);
        ComposerKt.sourceInformation(composer2, "C(rememberLazyListMeasurePolicy)P(5,7,1,6,4!2,8)167@7348L7990:LazyList.kt#428nma");
        Alignment.Horizontal horizontal3 = (i4 & 64) != 0 ? null : horizontal;
        Alignment.Vertical vertical3 = (i4 & 128) != 0 ? null : vertical;
        Arrangement.Horizontal horizontal4 = (i4 & 256) != 0 ? null : horizontal2;
        Arrangement.Vertical vertical4 = (i4 & 512) != 0 ? null : vertical2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(183156450, i2, -1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:167)");
        }
        Object[] objArr = {lazyListState, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4};
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i5 = 0; i5 < 8; i5++) {
            z3 |= composer2.changed(objArr[i5]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValues, z, function0, vertical4, horizontal4, i, horizontal3, vertical3);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }
}
