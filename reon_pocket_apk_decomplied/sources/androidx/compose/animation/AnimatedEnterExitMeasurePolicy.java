package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J,\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedEnterExitMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scope", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "(Landroidx/compose/animation/AnimatedVisibilityScopeImpl;)V", "getScope", "()Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl) {
        this.scope = animatedVisibilityScopeImpl;
    }

    public final AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: androidx.compose.ui.layout.Placeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m66measure3p2s80s(androidx.compose.ui.layout.MeasureScope r11, java.util.List<? extends androidx.compose.ui.layout.Measurable> r12, long r13) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.size()
            r0.<init>(r1)
            int r1 = r12.size()
            r2 = 0
            r3 = r2
        L_0x000f:
            if (r3 >= r1) goto L_0x0024
            java.lang.Object r4 = r12.get(r3)
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.ui.layout.Measurable) r4
            androidx.compose.ui.layout.Placeable r4 = r4.m5368measureBRTryo0(r13)
            r5.add(r4)
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0024:
            java.util.List r0 = (java.util.List) r0
            boolean r12 = r0.isEmpty()
            r13 = 0
            r14 = 1
            if (r12 == 0) goto L_0x0030
            r12 = r13
            goto L_0x0056
        L_0x0030:
            java.lang.Object r12 = r0.get(r2)
            r1 = r12
            androidx.compose.ui.layout.Placeable r1 = (androidx.compose.ui.layout.Placeable) r1
            int r1 = r1.getWidth()
            int r3 = kotlin.collections.CollectionsKt.getLastIndex(r0)
            if (r14 > r3) goto L_0x0056
            r4 = r14
        L_0x0042:
            java.lang.Object r5 = r0.get(r4)
            r6 = r5
            androidx.compose.ui.layout.Placeable r6 = (androidx.compose.ui.layout.Placeable) r6
            int r6 = r6.getWidth()
            if (r1 >= r6) goto L_0x0051
            r12 = r5
            r1 = r6
        L_0x0051:
            if (r4 == r3) goto L_0x0056
            int r4 = r4 + 1
            goto L_0x0042
        L_0x0056:
            androidx.compose.ui.layout.Placeable r12 = (androidx.compose.ui.layout.Placeable) r12
            if (r12 == 0) goto L_0x0060
            int r12 = r12.getWidth()
            r4 = r12
            goto L_0x0061
        L_0x0060:
            r4 = r2
        L_0x0061:
            boolean r12 = r0.isEmpty()
            if (r12 == 0) goto L_0x0068
            goto L_0x008e
        L_0x0068:
            java.lang.Object r12 = r0.get(r2)
            r13 = r12
            androidx.compose.ui.layout.Placeable r13 = (androidx.compose.ui.layout.Placeable) r13
            int r13 = r13.getHeight()
            int r1 = kotlin.collections.CollectionsKt.getLastIndex(r0)
            if (r14 > r1) goto L_0x008d
        L_0x0079:
            java.lang.Object r3 = r0.get(r14)
            r5 = r3
            androidx.compose.ui.layout.Placeable r5 = (androidx.compose.ui.layout.Placeable) r5
            int r5 = r5.getHeight()
            if (r13 >= r5) goto L_0x0088
            r12 = r3
            r13 = r5
        L_0x0088:
            if (r14 == r1) goto L_0x008d
            int r14 = r14 + 1
            goto L_0x0079
        L_0x008d:
            r13 = r12
        L_0x008e:
            androidx.compose.ui.layout.Placeable r13 = (androidx.compose.ui.layout.Placeable) r13
            if (r13 == 0) goto L_0x0096
            int r2 = r13.getHeight()
        L_0x0096:
            r5 = r2
            androidx.compose.animation.AnimatedVisibilityScopeImpl r12 = r10.scope
            androidx.compose.runtime.MutableState r12 = r12.getTargetSize$animation_release()
            long r13 = androidx.compose.ui.unit.IntSizeKt.IntSize(r4, r5)
            androidx.compose.ui.unit.IntSize r13 = androidx.compose.ui.unit.IntSize.m6782boximpl(r13)
            r12.setValue(r13)
            androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1 r12 = new androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1
            r12.<init>(r0)
            r7 = r12
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = 4
            r9 = 0
            r6 = 0
            r3 = r11
            androidx.compose.ui.layout.MeasureResult r11 = androidx.compose.ui.layout.MeasureScope.CC.layout$default(r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedEnterExitMeasurePolicy.m66measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Comparable comparable;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).minIntrinsicWidth(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).minIntrinsicWidth(i));
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Comparable comparable;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).minIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).minIntrinsicHeight(i));
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Comparable comparable;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).maxIntrinsicWidth(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).maxIntrinsicWidth(i));
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Comparable comparable;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).maxIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).maxIntrinsicHeight(i));
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
