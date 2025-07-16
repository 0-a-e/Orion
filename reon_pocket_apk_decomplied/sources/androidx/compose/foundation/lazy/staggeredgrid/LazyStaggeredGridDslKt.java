package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010$\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0'2%\b\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\b\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\b\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u00104\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&052%\b\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\b\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\b\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u00106\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0'2:\b\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\b\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\b\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\b\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010;\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&052:\b\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\b\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\b\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\b\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010<\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "verticalItemSpacing", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
public final class LazyStaggeredGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010e  */
    /* renamed from: LazyVerticalStaggeredGrid-zadm560  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m924LazyVerticalStaggeredGridzadm560(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, float r33, androidx.compose.foundation.layout.Arrangement.Horizontal r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r11 = r39
            r12 = r40
            r0 = 1695323794(0x650c9692, float:4.1494302E22)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyVerticalStaggeredGrid)P(!1,5,7,2,6,9:c#ui.unit.Dp,4,3,8)64@3068L32,69@3365L15,83@3878L67,73@3476L502:LazyStaggeredGridDsl.kt#fzvcnm"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r12 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r11 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r11
            goto L_0x002b
        L_0x002a:
            r3 = r11
        L_0x002b:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r6 = r11 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0045
            r6 = r29
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r3 = r3 | r7
            goto L_0x0047
        L_0x0045:
            r6 = r29
        L_0x0047:
            r7 = r12 & 4
            if (r7 == 0) goto L_0x004d
            r3 = r3 | 128(0x80, float:1.794E-43)
        L_0x004d:
            r8 = r12 & 8
            if (r8 == 0) goto L_0x0054
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0067
        L_0x0054:
            r9 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0067
            r9 = r31
            boolean r10 = r2.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0063
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0065
        L_0x0063:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0065:
            r3 = r3 | r10
            goto L_0x0069
        L_0x0067:
            r9 = r31
        L_0x0069:
            r10 = r12 & 16
            r13 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0073
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0086
        L_0x0073:
            r14 = r11 & r13
            if (r14 != 0) goto L_0x0086
            r14 = r32
            boolean r15 = r2.changed((boolean) r14)
            if (r15 == 0) goto L_0x0082
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0082:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r3 = r3 | r15
            goto L_0x0088
        L_0x0086:
            r14 = r32
        L_0x0088:
            r15 = r12 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x0095
            r17 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r17
            r13 = r33
            goto L_0x00a8
        L_0x0095:
            r17 = r11 & r16
            r13 = r33
            if (r17 != 0) goto L_0x00a8
            boolean r17 = r2.changed((float) r13)
            if (r17 == 0) goto L_0x00a4
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a6
        L_0x00a4:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00a6:
            r3 = r3 | r17
        L_0x00a8:
            r17 = r12 & 64
            r18 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00b5
            r19 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r19
            r0 = r34
            goto L_0x00c8
        L_0x00b5:
            r19 = r11 & r18
            r0 = r34
            if (r19 != 0) goto L_0x00c8
            boolean r20 = r2.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x00c4
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c6
        L_0x00c4:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00c6:
            r3 = r3 | r20
        L_0x00c8:
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r21 = r11 & r20
            if (r21 != 0) goto L_0x00e4
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 != 0) goto L_0x00dd
            r4 = r35
            boolean r22 = r2.changed((java.lang.Object) r4)
            if (r22 == 0) goto L_0x00df
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e1
        L_0x00dd:
            r4 = r35
        L_0x00df:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e1:
            r3 = r3 | r22
            goto L_0x00e6
        L_0x00e4:
            r4 = r35
        L_0x00e6:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r22 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x00f3
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r23
            r4 = r36
            goto L_0x0106
        L_0x00f3:
            r23 = r11 & r22
            r4 = r36
            if (r23 != 0) goto L_0x0106
            boolean r23 = r2.changed((boolean) r4)
            if (r23 == 0) goto L_0x0102
            r23 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0104
        L_0x0102:
            r23 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0104:
            r3 = r3 | r23
        L_0x0106:
            r4 = r12 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x010e
            r4 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r4
            goto L_0x0125
        L_0x010e:
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r11
            if (r4 != 0) goto L_0x0123
            r4 = r37
            boolean r23 = r2.changedInstance(r4)
            if (r23 == 0) goto L_0x011e
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0120
        L_0x011e:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0120:
            r3 = r3 | r23
            goto L_0x0125
        L_0x0123:
            r4 = r37
        L_0x0125:
            r4 = 4
            if (r7 != r4) goto L_0x014a
            r4 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r4 = r4 & r3
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r6) goto L_0x014a
            boolean r4 = r2.getSkipping()
            if (r4 != 0) goto L_0x0138
            goto L_0x014a
        L_0x0138:
            r2.skipToGroupEnd()
            r4 = r29
            r3 = r30
            r7 = r34
            r10 = r35
            r8 = r9
            r6 = r13
            r5 = r14
            r9 = r36
            goto L_0x0243
        L_0x014a:
            r2.startDefaults()
            r4 = r11 & 1
            r6 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r4 == 0) goto L_0x0177
            boolean r4 = r2.getDefaultsInvalid()
            if (r4 == 0) goto L_0x015b
            goto L_0x0177
        L_0x015b:
            r2.skipToGroupEnd()
            if (r7 == 0) goto L_0x0162
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0162:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0167
            r3 = r3 & r6
        L_0x0167:
            r4 = r29
            r7 = r30
            r5 = r34
            r10 = r35
            r6 = r3
            r8 = r9
            r9 = r13
        L_0x0172:
            r0 = r14
            r3 = r36
            goto L_0x01d0
        L_0x0177:
            if (r5 == 0) goto L_0x017e
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0180
        L_0x017e:
            r4 = r29
        L_0x0180:
            r5 = 0
            if (r7 == 0) goto L_0x018b
            r7 = 3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r7 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(r5, r5, r2, r5, r7)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x018d
        L_0x018b:
            r7 = r30
        L_0x018d:
            if (r8 == 0) goto L_0x0199
            float r8 = (float) r5
            float r8 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r8)
            androidx.compose.foundation.layout.PaddingValues r8 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r8)
            goto L_0x019a
        L_0x0199:
            r8 = r9
        L_0x019a:
            if (r10 == 0) goto L_0x019d
            r14 = r5
        L_0x019d:
            if (r15 == 0) goto L_0x01a5
            float r9 = (float) r5
            float r9 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r9)
            goto L_0x01a6
        L_0x01a5:
            r9 = r13
        L_0x01a6:
            if (r17 == 0) goto L_0x01b6
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r5)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r5 = r10.m537spacedBy0680j_4(r5)
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r5
            goto L_0x01b8
        L_0x01b6:
            r5 = r34
        L_0x01b8:
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x01c5
            androidx.compose.foundation.gestures.ScrollableDefaults r10 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r13 = 6
            androidx.compose.foundation.gestures.FlingBehavior r10 = r10.flingBehavior(r2, r13)
            r3 = r3 & r6
            goto L_0x01c7
        L_0x01c5:
            r10 = r35
        L_0x01c7:
            if (r0 == 0) goto L_0x01ce
            r0 = 1
            r6 = r3
            r3 = r0
            r0 = r14
            goto L_0x01d0
        L_0x01ce:
            r6 = r3
            goto L_0x0172
        L_0x01d0:
            r2.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01e2
            r13 = -1
            java.lang.String r14 = "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:72)"
            r15 = 1695323794(0x650c9692, float:4.1494302E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r6, r13, r14)
        L_0x01e2:
            androidx.compose.foundation.gestures.Orientation r14 = androidx.compose.foundation.gestures.Orientation.Vertical
            float r23 = r5.m552getSpacingD9Ej5fM()
            r13 = r6 & 14
            int r15 = r6 >> 15
            r15 = r15 & 112(0x70, float:1.57E-43)
            r13 = r13 | r15
            int r15 = r6 >> 3
            r11 = r15 & 896(0x380, float:1.256E-42)
            r11 = r11 | r13
            androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r11 = rememberColumnSlots(r1, r5, r8, r2, r11)
            int r13 = r6 << 6
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | 56
            int r17 = r6 << 3
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r17 & r19
            r13 = r13 | r19
            r16 = r17 & r16
            r13 = r13 | r16
            r16 = r15 & r18
            r13 = r13 | r16
            r15 = r15 & r20
            r13 = r13 | r15
            int r15 = r6 << 9
            r15 = r15 & r22
            r25 = r13 | r15
            int r6 = r6 >> 27
            r26 = r6 & 14
            r27 = 0
            r13 = r7
            r15 = r11
            r16 = r4
            r17 = r8
            r18 = r0
            r19 = r10
            r20 = r3
            r21 = r9
            r22 = r23
            r23 = r37
            r24 = r2
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m929LazyStaggeredGridLJWHXA8(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x023e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x023e:
            r6 = r9
            r9 = r3
            r3 = r7
            r7 = r5
            r5 = r0
        L_0x0243:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x025f
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1 r14 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1
            r0 = r14
            r1 = r28
            r2 = r4
            r4 = r8
            r8 = r10
            r10 = r37
            r11 = r39
            r12 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x025f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.m924LazyVerticalStaggeredGridzadm560(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, boolean, float, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberColumnSlots(StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-1267076841);
        ComposerKt.sourceInformation(composer, "C(rememberColumnSlots)P(!1,2)94@4216L1114:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1267076841, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:94)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) staggeredGridCells) | composer.changed((Object) horizontal) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyStaggeredGridSlotCache(new LazyStaggeredGridDslKt$rememberColumnSlots$1$1(paddingValues, staggeredGridCells, horizontal));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyGridStaggeredGridSlotsProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010e  */
    /* renamed from: LazyHorizontalStaggeredGrid-cJHQLPU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m923LazyHorizontalStaggeredGridcJHQLPU(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Vertical r33, float r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r11 = r39
            r12 = r40
            r0 = -8666074(0xffffffffff7bc426, float:-3.3465469E38)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyHorizontalStaggeredGrid)P(6,4,7,1,5,9,3:c#ui.unit.Dp,2,8)154@6993L32,159@7288L15,173@7803L59,163@7399L496:LazyStaggeredGridDsl.kt#fzvcnm"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r12 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r11 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r11
            goto L_0x002b
        L_0x002a:
            r3 = r11
        L_0x002b:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r6 = r11 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0045
            r6 = r29
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r3 = r3 | r7
            goto L_0x0047
        L_0x0045:
            r6 = r29
        L_0x0047:
            r7 = r12 & 4
            if (r7 == 0) goto L_0x004d
            r3 = r3 | 128(0x80, float:1.794E-43)
        L_0x004d:
            r8 = r12 & 8
            if (r8 == 0) goto L_0x0054
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0067
        L_0x0054:
            r9 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0067
            r9 = r31
            boolean r10 = r2.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0063
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0065
        L_0x0063:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0065:
            r3 = r3 | r10
            goto L_0x0069
        L_0x0067:
            r9 = r31
        L_0x0069:
            r10 = r12 & 16
            r13 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0073
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0086
        L_0x0073:
            r14 = r11 & r13
            if (r14 != 0) goto L_0x0086
            r14 = r32
            boolean r15 = r2.changed((boolean) r14)
            if (r15 == 0) goto L_0x0082
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0082:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r3 = r3 | r15
            goto L_0x0088
        L_0x0086:
            r14 = r32
        L_0x0088:
            r15 = r12 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x0095
            r17 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r17
            r13 = r33
            goto L_0x00a8
        L_0x0095:
            r17 = r11 & r16
            r13 = r33
            if (r17 != 0) goto L_0x00a8
            boolean r17 = r2.changed((java.lang.Object) r13)
            if (r17 == 0) goto L_0x00a4
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a6
        L_0x00a4:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00a6:
            r3 = r3 | r17
        L_0x00a8:
            r17 = r12 & 64
            r18 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00b5
            r19 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r19
            r0 = r34
            goto L_0x00c8
        L_0x00b5:
            r19 = r11 & r18
            r0 = r34
            if (r19 != 0) goto L_0x00c8
            boolean r20 = r2.changed((float) r0)
            if (r20 == 0) goto L_0x00c4
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c6
        L_0x00c4:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00c6:
            r3 = r3 | r20
        L_0x00c8:
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r21 = r11 & r20
            if (r21 != 0) goto L_0x00e4
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 != 0) goto L_0x00dd
            r4 = r35
            boolean r22 = r2.changed((java.lang.Object) r4)
            if (r22 == 0) goto L_0x00df
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e1
        L_0x00dd:
            r4 = r35
        L_0x00df:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e1:
            r3 = r3 | r22
            goto L_0x00e6
        L_0x00e4:
            r4 = r35
        L_0x00e6:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r22 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x00f3
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r23
            r4 = r36
            goto L_0x0106
        L_0x00f3:
            r23 = r11 & r22
            r4 = r36
            if (r23 != 0) goto L_0x0106
            boolean r23 = r2.changed((boolean) r4)
            if (r23 == 0) goto L_0x0102
            r23 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0104
        L_0x0102:
            r23 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0104:
            r3 = r3 | r23
        L_0x0106:
            r4 = r12 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x010e
            r4 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r4
            goto L_0x0125
        L_0x010e:
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r11
            if (r4 != 0) goto L_0x0123
            r4 = r37
            boolean r23 = r2.changedInstance(r4)
            if (r23 == 0) goto L_0x011e
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0120
        L_0x011e:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0120:
            r3 = r3 | r23
            goto L_0x0125
        L_0x0123:
            r4 = r37
        L_0x0125:
            r4 = 4
            if (r7 != r4) goto L_0x014a
            r4 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r4 = r4 & r3
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r6) goto L_0x014a
            boolean r4 = r2.getSkipping()
            if (r4 != 0) goto L_0x0138
            goto L_0x014a
        L_0x0138:
            r2.skipToGroupEnd()
            r4 = r29
            r3 = r30
            r7 = r34
            r10 = r35
            r8 = r9
            r6 = r13
            r5 = r14
            r9 = r36
            goto L_0x0241
        L_0x014a:
            r2.startDefaults()
            r4 = r11 & 1
            r6 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r4 == 0) goto L_0x0177
            boolean r4 = r2.getDefaultsInvalid()
            if (r4 == 0) goto L_0x015b
            goto L_0x0177
        L_0x015b:
            r2.skipToGroupEnd()
            if (r7 == 0) goto L_0x0162
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0162:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0167
            r3 = r3 & r6
        L_0x0167:
            r4 = r29
            r7 = r30
            r5 = r34
            r10 = r35
            r6 = r3
            r8 = r9
            r9 = r13
        L_0x0172:
            r0 = r14
            r3 = r36
            goto L_0x01d0
        L_0x0177:
            if (r5 == 0) goto L_0x017e
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0180
        L_0x017e:
            r4 = r29
        L_0x0180:
            r5 = 0
            if (r7 == 0) goto L_0x018b
            r7 = 3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r7 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(r5, r5, r2, r5, r7)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x018d
        L_0x018b:
            r7 = r30
        L_0x018d:
            if (r8 == 0) goto L_0x0199
            float r8 = (float) r5
            float r8 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r8)
            androidx.compose.foundation.layout.PaddingValues r8 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r8)
            goto L_0x019a
        L_0x0199:
            r8 = r9
        L_0x019a:
            if (r10 == 0) goto L_0x019d
            r14 = r5
        L_0x019d:
            if (r15 == 0) goto L_0x01ad
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r10 = (float) r5
            float r10 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r10)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r9 = r9.m537spacedBy0680j_4(r10)
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = (androidx.compose.foundation.layout.Arrangement.Vertical) r9
            goto L_0x01ae
        L_0x01ad:
            r9 = r13
        L_0x01ae:
            if (r17 == 0) goto L_0x01b6
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r5)
            goto L_0x01b8
        L_0x01b6:
            r5 = r34
        L_0x01b8:
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x01c5
            androidx.compose.foundation.gestures.ScrollableDefaults r10 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r13 = 6
            androidx.compose.foundation.gestures.FlingBehavior r10 = r10.flingBehavior(r2, r13)
            r3 = r3 & r6
            goto L_0x01c7
        L_0x01c5:
            r10 = r35
        L_0x01c7:
            if (r0 == 0) goto L_0x01ce
            r0 = 1
            r6 = r3
            r3 = r0
            r0 = r14
            goto L_0x01d0
        L_0x01ce:
            r6 = r3
            goto L_0x0172
        L_0x01d0:
            r2.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01e2
            r13 = -1
            java.lang.String r14 = "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:162)"
            r15 = -8666074(0xffffffffff7bc426, float:-3.3465469E38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r6, r13, r14)
        L_0x01e2:
            androidx.compose.foundation.gestures.Orientation r14 = androidx.compose.foundation.gestures.Orientation.Horizontal
            float r23 = r9.m570getSpacingD9Ej5fM()
            r13 = r6 & 14
            int r15 = r6 >> 12
            r15 = r15 & 112(0x70, float:1.57E-43)
            r13 = r13 | r15
            int r15 = r6 >> 3
            r11 = r15 & 896(0x380, float:1.256E-42)
            r11 = r11 | r13
            androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r11 = rememberRowSlots(r1, r9, r8, r2, r11)
            int r13 = r6 << 6
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 56
            int r17 = r6 << 3
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r17 & r19
            r1 = r1 | r19
            r16 = r17 & r16
            r1 = r1 | r16
            r16 = r15 & r18
            r1 = r1 | r16
            r15 = r15 & r20
            r1 = r1 | r15
            r13 = r13 & r22
            r25 = r1 | r13
            int r1 = r6 >> 27
            r26 = r1 & 14
            r27 = 0
            r13 = r7
            r15 = r11
            r16 = r4
            r17 = r8
            r18 = r0
            r19 = r10
            r20 = r3
            r21 = r5
            r22 = r23
            r23 = r37
            r24 = r2
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m929LazyStaggeredGridLJWHXA8(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x023c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x023c:
            r6 = r9
            r9 = r3
            r3 = r7
            r7 = r5
            r5 = r0
        L_0x0241:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x025d
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1 r14 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1
            r0 = r14
            r1 = r28
            r2 = r4
            r4 = r8
            r8 = r10
            r10 = r37
            r11 = r39
            r12 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x025d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.m923LazyHorizontalStaggeredGridcJHQLPU(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, float, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberRowSlots(StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-1532383053);
        ComposerKt.sourceInformation(composer, "C(rememberRowSlots)P(1,2)184@8120L940:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1532383053, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:184)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) staggeredGridCells) | composer.changed((Object) vertical) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyStaggeredGridSlotCache(new LazyStaggeredGridDslKt$rememberRowSlots$1$1(paddingValues, staggeredGridCells, vertical));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyGridStaggeredGridSlotsProvider;
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        Function1 function14 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyStaggeredGridDslKt$items$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        int size = list.size();
        Function1 lazyStaggeredGridDslKt$items$2$1 = function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null;
        Function1 lazyStaggeredGridDslKt$items$3 = new LazyStaggeredGridDslKt$items$3(function12, list);
        if (function13 != null) {
            function14 = new LazyStaggeredGridDslKt$items$4$1(function13, list);
        }
        lazyStaggeredGridScope.items(size, lazyStaggeredGridDslKt$items$2$1, lazyStaggeredGridDslKt$items$3, function14, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        int size = list.size();
        Function1 function14 = null;
        Function1 lazyStaggeredGridDslKt$items$2$1 = function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null;
        Function1 lazyStaggeredGridDslKt$items$3 = new LazyStaggeredGridDslKt$items$3(function12, list);
        if (function13 != null) {
            function14 = new LazyStaggeredGridDslKt$items$4$1(function13, list);
        }
        lazyStaggeredGridScope.items(size, lazyStaggeredGridDslKt$items$2$1, lazyStaggeredGridDslKt$items$3, function14, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = LazyStaggeredGridDslKt$itemsIndexed$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        int size = list.size();
        Function1 lazyStaggeredGridDslKt$itemsIndexed$2$1 = function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$3 = new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list);
        if (function23 != null) {
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list);
        }
        lazyStaggeredGridScope.items(size, lazyStaggeredGridDslKt$itemsIndexed$2$1, lazyStaggeredGridDslKt$itemsIndexed$3, function1, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        int size = list.size();
        Function1 function1 = null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$2$1 = function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$3 = new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list);
        if (function23 != null) {
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list);
        }
        lazyStaggeredGridScope.items(size, lazyStaggeredGridDslKt$itemsIndexed$2$1, lazyStaggeredGridDslKt$itemsIndexed$3, function1, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        Function1 function14 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyStaggeredGridDslKt$items$6.INSTANCE;
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        int length = objArr.length;
        Function1 lazyStaggeredGridDslKt$items$7$1 = function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, objArr) : null;
        Function1 lazyStaggeredGridDslKt$items$8 = new LazyStaggeredGridDslKt$items$8(function12, objArr);
        if (function13 != null) {
            function14 = new LazyStaggeredGridDslKt$items$9$1(function13, objArr);
        }
        lazyStaggeredGridScope.items(length, lazyStaggeredGridDslKt$items$7$1, lazyStaggeredGridDslKt$items$8, function14, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        int length = tArr.length;
        Function1 function14 = null;
        Function1 lazyStaggeredGridDslKt$items$7$1 = function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, tArr) : null;
        Function1 lazyStaggeredGridDslKt$items$8 = new LazyStaggeredGridDslKt$items$8(function12, tArr);
        if (function13 != null) {
            function14 = new LazyStaggeredGridDslKt$items$9$1(function13, tArr);
        }
        lazyStaggeredGridScope.items(length, lazyStaggeredGridDslKt$items$7$1, lazyStaggeredGridDslKt$items$8, function14, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = LazyStaggeredGridDslKt$itemsIndexed$6.INSTANCE;
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        int length = objArr.length;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$7$1 = function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, objArr) : null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$8 = new LazyStaggeredGridDslKt$itemsIndexed$8(function22, objArr);
        if (function23 != null) {
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, objArr);
        }
        lazyStaggeredGridScope.items(length, lazyStaggeredGridDslKt$itemsIndexed$7$1, lazyStaggeredGridDslKt$itemsIndexed$8, function1, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        int length = tArr.length;
        Function1 function1 = null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$7$1 = function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, tArr) : null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$8 = new LazyStaggeredGridDslKt$itemsIndexed$8(function22, tArr);
        if (function23 != null) {
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, tArr);
        }
        lazyStaggeredGridScope.items(length, lazyStaggeredGridDslKt$itemsIndexed$7$1, lazyStaggeredGridDslKt$itemsIndexed$8, function1, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(function5, tArr)));
    }
}
