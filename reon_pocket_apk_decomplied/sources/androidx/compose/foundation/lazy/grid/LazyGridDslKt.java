package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001a%\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010%\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0(2%\b\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\b\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\b\u00162%\b\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u00106\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u001c2%\b\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\b\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\b\u00162%\b\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u00107\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0(2:\b\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\b\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\b\u00162:\b\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010;\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u001c2:\b\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\b\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\b\u00162:\b\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010<¨\u0006="}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
public final class LazyGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.grid.LazyGridState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Vertical r33, androidx.compose.foundation.layout.Arrangement.Horizontal r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r11 = r39
            r12 = r40
            r0 = 1485410512(0x588990d0, float:1.21004046E15)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)64@2980L23,70@3340L15,75@3468L71,74@3442L481:LazyGridDsl.kt#7791vq"
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
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r29
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
            r5 = r29
        L_0x0047:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0060
            r6 = r12 & 4
            if (r6 != 0) goto L_0x005a
            r6 = r30
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r6 = r30
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r7
            goto L_0x0062
        L_0x0060:
            r6 = r30
        L_0x0062:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x0069
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007c
            r8 = r31
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r9
            goto L_0x007e
        L_0x007c:
            r8 = r31
        L_0x007e:
            r9 = r12 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0088
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r11 & r10
            if (r13 != 0) goto L_0x009b
            r13 = r32
            boolean r14 = r2.changed((boolean) r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r32
        L_0x009d:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00b7
            r14 = r12 & 32
            if (r14 != 0) goto L_0x00b1
            r14 = r33
            boolean r15 = r2.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b3
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r14 = r33
        L_0x00b3:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r15
            goto L_0x00b9
        L_0x00b7:
            r14 = r33
        L_0x00b9:
            r15 = r12 & 64
            r16 = 3670016(0x380000, float:5.142788E-39)
            if (r15 == 0) goto L_0x00c6
            r17 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r17
            r10 = r34
            goto L_0x00d9
        L_0x00c6:
            r17 = r11 & r16
            r10 = r34
            if (r17 != 0) goto L_0x00d9
            boolean r17 = r2.changed((java.lang.Object) r10)
            if (r17 == 0) goto L_0x00d5
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r3 = r3 | r17
        L_0x00d9:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r11 & r17
            if (r18 != 0) goto L_0x00f5
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ee
            r0 = r35
            boolean r19 = r2.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x00f0
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00ee:
            r0 = r35
        L_0x00f0:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r3 = r3 | r19
            goto L_0x00f7
        L_0x00f5:
            r0 = r35
        L_0x00f7:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x0104
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r20
            r5 = r36
            goto L_0x0117
        L_0x0104:
            r20 = r11 & r19
            r5 = r36
            if (r20 != 0) goto L_0x0117
            boolean r20 = r2.changed((boolean) r5)
            if (r20 == 0) goto L_0x0113
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0115
        L_0x0113:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0115:
            r3 = r3 | r20
        L_0x0117:
            r5 = r12 & 512(0x200, float:7.175E-43)
            r20 = 1879048192(0x70000000, float:1.58456325E29)
            if (r5 == 0) goto L_0x0121
            r5 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r5
            goto L_0x0135
        L_0x0121:
            r5 = r11 & r20
            if (r5 != 0) goto L_0x0135
            r5 = r37
            boolean r21 = r2.changedInstance(r5)
            if (r21 == 0) goto L_0x0130
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0132
        L_0x0130:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0132:
            r3 = r3 | r21
            goto L_0x0137
        L_0x0135:
            r5 = r37
        L_0x0137:
            r21 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r3 & r21
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r6) goto L_0x0159
            boolean r5 = r2.getSkipping()
            if (r5 != 0) goto L_0x0148
            goto L_0x0159
        L_0x0148:
            r2.skipToGroupEnd()
            r4 = r29
            r3 = r30
            r7 = r8
            r9 = r10
            r5 = r13
            r6 = r14
            r8 = r35
            r10 = r36
            goto L_0x025e
        L_0x0159:
            r2.startDefaults()
            r5 = r11 & 1
            r6 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r5 == 0) goto L_0x018e
            boolean r5 = r2.getDefaultsInvalid()
            if (r5 == 0) goto L_0x016a
            goto L_0x018e
        L_0x016a:
            r2.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0173
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0173:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0178
            r3 = r3 & r6
        L_0x0178:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0180
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0180:
            r4 = r29
            r5 = r30
            r0 = r36
            r7 = r8
            r9 = r10
            r6 = r13
            r8 = r14
            r10 = r35
            goto L_0x01f0
        L_0x018e:
            if (r4 == 0) goto L_0x0195
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0197
        L_0x0195:
            r4 = r29
        L_0x0197:
            r5 = r12 & 4
            r6 = 0
            if (r5 == 0) goto L_0x01a4
            r5 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r5 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r6, r6, r2, r6, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01a6
        L_0x01a4:
            r5 = r30
        L_0x01a6:
            if (r7 == 0) goto L_0x01b2
            float r7 = (float) r6
            float r7 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r7)
            androidx.compose.foundation.layout.PaddingValues r7 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r7)
            goto L_0x01b3
        L_0x01b2:
            r7 = r8
        L_0x01b3:
            if (r9 == 0) goto L_0x01b6
            goto L_0x01b7
        L_0x01b6:
            r6 = r13
        L_0x01b7:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x01cd
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r6 != 0) goto L_0x01c4
            androidx.compose.foundation.layout.Arrangement$Vertical r8 = r8.getTop()
            goto L_0x01c8
        L_0x01c4:
            androidx.compose.foundation.layout.Arrangement$Vertical r8 = r8.getBottom()
        L_0x01c8:
            r9 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r9
            goto L_0x01ce
        L_0x01cd:
            r8 = r14
        L_0x01ce:
            if (r15 == 0) goto L_0x01d7
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r9 = r9.getStart()
            goto L_0x01d8
        L_0x01d7:
            r9 = r10
        L_0x01d8:
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x01e8
            androidx.compose.foundation.gestures.ScrollableDefaults r10 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r13 = 6
            androidx.compose.foundation.gestures.FlingBehavior r10 = r10.flingBehavior(r2, r13)
            r13 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r13
            goto L_0x01ea
        L_0x01e8:
            r10 = r35
        L_0x01ea:
            if (r0 == 0) goto L_0x01ee
            r0 = 1
            goto L_0x01f0
        L_0x01ee:
            r0 = r36
        L_0x01f0:
            r2.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0202
            r13 = -1
            java.lang.String r14 = "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)"
            r15 = 1485410512(0x588990d0, float:1.21004046E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r3, r13, r14)
        L_0x0202:
            r13 = r3 & 14
            int r14 = r3 >> 15
            r14 = r14 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            int r14 = r3 >> 3
            r15 = r14 & 896(0x380, float:1.256E-42)
            r13 = r13 | r15
            androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r15 = rememberColumnWidthSums(r1, r9, r7, r2, r13)
            r13 = r14 & 14
            r18 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 | r18
            r18 = r14 & 112(0x70, float:1.57E-43)
            r13 = r13 | r18
            r1 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r3
            r1 = r1 | r13
            r13 = r14 & r16
            r1 = r1 | r13
            r13 = r14 & r17
            r1 = r1 | r13
            int r13 = r3 << 9
            r14 = r13 & r19
            r1 = r1 | r14
            r13 = r13 & r20
            r25 = r1 | r13
            int r1 = r3 >> 27
            r26 = r1 & 14
            r27 = 0
            r18 = 1
            r13 = r4
            r14 = r5
            r16 = r7
            r17 = r6
            r19 = r10
            r20 = r0
            r21 = r8
            r22 = r9
            r23 = r37
            r24 = r2
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0259
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0259:
            r3 = r5
            r5 = r6
            r6 = r8
            r8 = r10
            r10 = r0
        L_0x025e:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x027b
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1 r14 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
            r0 = r14
            r1 = r28
            r2 = r4
            r4 = r7
            r7 = r9
            r9 = r10
            r10 = r37
            r11 = r39
            r12 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x027b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.grid.LazyGridState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Horizontal r33, androidx.compose.foundation.layout.Arrangement.Vertical r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r11 = r39
            r12 = r40
            r0 = 2123608858(0x7e93b31a, float:9.816323E37)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)117@5477L23,123@5834L15,128@5962L64,127@5936L475:LazyGridDsl.kt#7791vq"
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
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r29
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
            r5 = r29
        L_0x0047:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0060
            r6 = r12 & 4
            if (r6 != 0) goto L_0x005a
            r6 = r30
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r6 = r30
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r7
            goto L_0x0062
        L_0x0060:
            r6 = r30
        L_0x0062:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x0069
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007c
            r8 = r31
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r9
            goto L_0x007e
        L_0x007c:
            r8 = r31
        L_0x007e:
            r9 = r12 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0088
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r11 & r10
            if (r13 != 0) goto L_0x009b
            r13 = r32
            boolean r14 = r2.changed((boolean) r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r32
        L_0x009d:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00b7
            r14 = r12 & 32
            if (r14 != 0) goto L_0x00b1
            r14 = r33
            boolean r15 = r2.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b3
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r14 = r33
        L_0x00b3:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r15
            goto L_0x00b9
        L_0x00b7:
            r14 = r33
        L_0x00b9:
            r15 = r12 & 64
            r16 = 3670016(0x380000, float:5.142788E-39)
            if (r15 == 0) goto L_0x00c6
            r17 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r17
            r10 = r34
            goto L_0x00d9
        L_0x00c6:
            r17 = r11 & r16
            r10 = r34
            if (r17 != 0) goto L_0x00d9
            boolean r17 = r2.changed((java.lang.Object) r10)
            if (r17 == 0) goto L_0x00d5
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r3 = r3 | r17
        L_0x00d9:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r11 & r17
            if (r18 != 0) goto L_0x00f5
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ee
            r0 = r35
            boolean r19 = r2.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x00f0
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00ee:
            r0 = r35
        L_0x00f0:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r3 = r3 | r19
            goto L_0x00f7
        L_0x00f5:
            r0 = r35
        L_0x00f7:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x0104
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r20
            r5 = r36
            goto L_0x0117
        L_0x0104:
            r20 = r11 & r19
            r5 = r36
            if (r20 != 0) goto L_0x0117
            boolean r20 = r2.changed((boolean) r5)
            if (r20 == 0) goto L_0x0113
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0115
        L_0x0113:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0115:
            r3 = r3 | r20
        L_0x0117:
            r5 = r12 & 512(0x200, float:7.175E-43)
            r20 = 1879048192(0x70000000, float:1.58456325E29)
            if (r5 == 0) goto L_0x0121
            r5 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r5
            goto L_0x0135
        L_0x0121:
            r5 = r11 & r20
            if (r5 != 0) goto L_0x0135
            r5 = r37
            boolean r21 = r2.changedInstance(r5)
            if (r21 == 0) goto L_0x0130
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0132
        L_0x0130:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0132:
            r3 = r3 | r21
            goto L_0x0137
        L_0x0135:
            r5 = r37
        L_0x0137:
            r21 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r3 & r21
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r6) goto L_0x0159
            boolean r5 = r2.getSkipping()
            if (r5 != 0) goto L_0x0148
            goto L_0x0159
        L_0x0148:
            r2.skipToGroupEnd()
            r4 = r29
            r3 = r30
            r7 = r8
            r9 = r10
            r5 = r13
            r6 = r14
            r8 = r35
            r10 = r36
            goto L_0x0260
        L_0x0159:
            r2.startDefaults()
            r5 = r11 & 1
            r6 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r5 == 0) goto L_0x018e
            boolean r5 = r2.getDefaultsInvalid()
            if (r5 == 0) goto L_0x016a
            goto L_0x018e
        L_0x016a:
            r2.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0173
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0173:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0178
            r3 = r3 & r6
        L_0x0178:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0180
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0180:
            r4 = r29
            r5 = r30
            r0 = r36
            r7 = r8
            r9 = r10
            r6 = r13
            r8 = r14
            r10 = r35
            goto L_0x01f0
        L_0x018e:
            if (r4 == 0) goto L_0x0195
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0197
        L_0x0195:
            r4 = r29
        L_0x0197:
            r5 = r12 & 4
            r6 = 0
            if (r5 == 0) goto L_0x01a4
            r5 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r5 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r6, r6, r2, r6, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01a6
        L_0x01a4:
            r5 = r30
        L_0x01a6:
            if (r7 == 0) goto L_0x01b2
            float r7 = (float) r6
            float r7 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r7)
            androidx.compose.foundation.layout.PaddingValues r7 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r7)
            goto L_0x01b3
        L_0x01b2:
            r7 = r8
        L_0x01b3:
            if (r9 == 0) goto L_0x01b6
            goto L_0x01b7
        L_0x01b6:
            r6 = r13
        L_0x01b7:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x01cd
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r6 != 0) goto L_0x01c4
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r8.getStart()
            goto L_0x01c8
        L_0x01c4:
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r8.getEnd()
        L_0x01c8:
            r9 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r9
            goto L_0x01ce
        L_0x01cd:
            r8 = r14
        L_0x01ce:
            if (r15 == 0) goto L_0x01d7
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = r9.getTop()
            goto L_0x01d8
        L_0x01d7:
            r9 = r10
        L_0x01d8:
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x01e8
            androidx.compose.foundation.gestures.ScrollableDefaults r10 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r13 = 6
            androidx.compose.foundation.gestures.FlingBehavior r10 = r10.flingBehavior(r2, r13)
            r13 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r13
            goto L_0x01ea
        L_0x01e8:
            r10 = r35
        L_0x01ea:
            if (r0 == 0) goto L_0x01ee
            r0 = 1
            goto L_0x01f0
        L_0x01ee:
            r0 = r36
        L_0x01f0:
            r2.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0202
            r13 = -1
            java.lang.String r14 = "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:126)"
            r15 = 2123608858(0x7e93b31a, float:9.816323E37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r3, r13, r14)
        L_0x0202:
            r13 = r3 & 14
            int r14 = r3 >> 15
            r14 = r14 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            int r14 = r3 >> 3
            r15 = r14 & 896(0x380, float:1.256E-42)
            r13 = r13 | r15
            androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r15 = rememberRowHeightSums(r1, r9, r7, r2, r13)
            r13 = r14 & 14
            r18 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 | r18
            r18 = r14 & 112(0x70, float:1.57E-43)
            r13 = r13 | r18
            r1 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r3
            r1 = r1 | r13
            r13 = r14 & r16
            r1 = r1 | r13
            r13 = r14 & r17
            r1 = r1 | r13
            int r13 = r3 << 6
            r13 = r13 & r19
            r1 = r1 | r13
            int r13 = r3 << 12
            r13 = r13 & r20
            r25 = r1 | r13
            int r1 = r3 >> 27
            r26 = r1 & 14
            r27 = 0
            r18 = 0
            r13 = r4
            r14 = r5
            r16 = r7
            r17 = r6
            r19 = r10
            r20 = r0
            r21 = r9
            r22 = r8
            r23 = r37
            r24 = r2
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x025b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x025b:
            r3 = r5
            r5 = r6
            r6 = r8
            r8 = r10
            r10 = r0
        L_0x0260:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x027d
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1 r14 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1
            r0 = r14
            r1 = r28
            r2 = r4
            r4 = r7
            r7 = r9
            r9 = r10
            r10 = r37
            r11 = r39
            r12 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x027d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(GridCells gridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(1632454918);
        ComposerKt.sourceInformation(composer, "C(rememberColumnWidthSums)P(!1,2)148@6622L975:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1632454918, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) gridCells) | composer.changed((Object) horizontal) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GridSlotCache(new LazyGridDslKt$rememberColumnWidthSums$1$1(paddingValues, gridCells, horizontal));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyGridSlotsProvider;
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(GridCells gridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-741512409);
        ComposerKt.sourceInformation(composer, "C(rememberRowHeightSums)P(1,2)181@7795L909:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-741512409, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:181)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) gridCells) | composer.changed((Object) vertical) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GridSlotCache(new LazyGridDslKt$rememberRowHeightSums$1$1(paddingValues, gridCells, vertical));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyGridSlotsProvider;
    }

    /* access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        Function2 function22 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = LazyGridDslKt$items$1.INSTANCE;
        }
        int size = list.size();
        Function1 lazyGridDslKt$items$2 = function1 != null ? new LazyGridDslKt$items$2(function1, list) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$3(function2, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$items$2, function22, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        int size = list.size();
        Function2 function22 = null;
        Function1 lazyGridDslKt$items$2 = function1 != null ? new LazyGridDslKt$items$2(function1, list) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$3(function2, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$items$2, function22, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        Function2 function23 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = LazyGridDslKt$itemsIndexed$1.INSTANCE;
        }
        int size = list.size();
        Function1 lazyGridDslKt$itemsIndexed$2 = function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$3(function3, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$itemsIndexed$2, function23, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        int size = list.size();
        Function2 function23 = null;
        Function1 lazyGridDslKt$itemsIndexed$2 = function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$3(function3, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$itemsIndexed$2, function23, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        Function2 function22 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = LazyGridDslKt$items$6.INSTANCE;
        }
        int length = objArr.length;
        Function1 lazyGridDslKt$items$7 = function1 != null ? new LazyGridDslKt$items$7(function1, objArr) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$8(function2, objArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$items$7, function22, new LazyGridDslKt$items$9(function12, objArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        int length = tArr.length;
        Function2 function22 = null;
        Function1 lazyGridDslKt$items$7 = function1 != null ? new LazyGridDslKt$items$7(function1, tArr) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$8(function2, tArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$items$7, function22, new LazyGridDslKt$items$9(function12, tArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        Function2 function23 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = LazyGridDslKt$itemsIndexed$6.INSTANCE;
        }
        int length = objArr.length;
        Function1 lazyGridDslKt$itemsIndexed$7 = function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, objArr) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$8(function3, objArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$itemsIndexed$7, function23, new LazyGridDslKt$itemsIndexed$9(function22, objArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        int length = tArr.length;
        Function2 function23 = null;
        Function1 lazyGridDslKt$itemsIndexed$7 = function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, tArr) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$8(function3, tArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$itemsIndexed$7, function23, new LazyGridDslKt$itemsIndexed$9(function22, tArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, tArr)));
    }
}
