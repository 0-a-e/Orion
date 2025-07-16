package androidx.compose.ui.window;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
final class AndroidDialog_androidKt$DialogLayout$1 implements MeasurePolicy {
    public static final AndroidDialog_androidKt$DialogLayout$1 INSTANCE = new AndroidDialog_androidKt$DialogLayout$1();

    AndroidDialog_androidKt$DialogLayout$1() {
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.compose.ui.layout.Placeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.layout.MeasureResult m6875measure3p2s80s(androidx.compose.ui.layout.MeasureScope r12, java.util.List<? extends androidx.compose.ui.layout.Measurable> r13, long r14) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r13.size()
            r0.<init>(r1)
            int r1 = r13.size()
            r2 = 0
            r3 = r2
        L_0x000f:
            if (r3 >= r1) goto L_0x0024
            java.lang.Object r4 = r13.get(r3)
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.ui.layout.Measurable) r4
            androidx.compose.ui.layout.Placeable r4 = r4.m5368measureBRTryo0(r14)
            r5.add(r4)
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0024:
            java.util.List r0 = (java.util.List) r0
            boolean r13 = r0.isEmpty()
            r1 = 0
            r3 = 1
            if (r13 == 0) goto L_0x0030
            r13 = r1
            goto L_0x0056
        L_0x0030:
            java.lang.Object r13 = r0.get(r2)
            r4 = r13
            androidx.compose.ui.layout.Placeable r4 = (androidx.compose.ui.layout.Placeable) r4
            int r4 = r4.getWidth()
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r0)
            if (r3 > r5) goto L_0x0056
            r6 = r3
        L_0x0042:
            java.lang.Object r7 = r0.get(r6)
            r8 = r7
            androidx.compose.ui.layout.Placeable r8 = (androidx.compose.ui.layout.Placeable) r8
            int r8 = r8.getWidth()
            if (r4 >= r8) goto L_0x0051
            r13 = r7
            r4 = r8
        L_0x0051:
            if (r6 == r5) goto L_0x0056
            int r6 = r6 + 1
            goto L_0x0042
        L_0x0056:
            androidx.compose.ui.layout.Placeable r13 = (androidx.compose.ui.layout.Placeable) r13
            if (r13 == 0) goto L_0x005f
            int r13 = r13.getWidth()
            goto L_0x0063
        L_0x005f:
            int r13 = androidx.compose.ui.unit.Constraints.m6528getMinWidthimpl(r14)
        L_0x0063:
            r5 = r13
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L_0x006b
            goto L_0x0091
        L_0x006b:
            java.lang.Object r13 = r0.get(r2)
            r1 = r13
            androidx.compose.ui.layout.Placeable r1 = (androidx.compose.ui.layout.Placeable) r1
            int r1 = r1.getHeight()
            int r2 = kotlin.collections.CollectionsKt.getLastIndex(r0)
            if (r3 > r2) goto L_0x0090
        L_0x007c:
            java.lang.Object r4 = r0.get(r3)
            r6 = r4
            androidx.compose.ui.layout.Placeable r6 = (androidx.compose.ui.layout.Placeable) r6
            int r6 = r6.getHeight()
            if (r1 >= r6) goto L_0x008b
            r13 = r4
            r1 = r6
        L_0x008b:
            if (r3 == r2) goto L_0x0090
            int r3 = r3 + 1
            goto L_0x007c
        L_0x0090:
            r1 = r13
        L_0x0091:
            androidx.compose.ui.layout.Placeable r1 = (androidx.compose.ui.layout.Placeable) r1
            if (r1 == 0) goto L_0x009a
            int r13 = r1.getHeight()
            goto L_0x009e
        L_0x009a:
            int r13 = androidx.compose.ui.unit.Constraints.m6527getMinHeightimpl(r14)
        L_0x009e:
            r6 = r13
            androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$1 r13 = new androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$1
            r13.<init>(r0)
            r8 = r13
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r9 = 4
            r10 = 0
            r7 = 0
            r4 = r12
            androidx.compose.ui.layout.MeasureResult r12 = androidx.compose.ui.layout.MeasureScope.CC.layout$default(r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1.m6875measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }
}
