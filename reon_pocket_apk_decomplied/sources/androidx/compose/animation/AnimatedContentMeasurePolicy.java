package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J,\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentTransitionScopeImpl<?> rootScope;

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl<?> animatedContentTransitionScopeImpl) {
        this.rootScope = animatedContentTransitionScopeImpl;
    }

    public final AnimatedContentTransitionScopeImpl<?> getRootScope() {
        return this.rootScope;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [androidx.compose.ui.layout.Placeable] */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m36measure3p2s80s(androidx.compose.ui.layout.MeasureScope r19, java.util.List<? extends androidx.compose.ui.layout.Measurable> r20, long r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            int r4 = r20.size()
            androidx.compose.ui.layout.Placeable[] r5 = new androidx.compose.ui.layout.Placeable[r4]
            int r6 = r20.size()
            r7 = 0
            r8 = r7
        L_0x0012:
            r9 = 0
            r10 = 1
            if (r8 >= r6) goto L_0x0038
            java.lang.Object r11 = r1.get(r8)
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            java.lang.Object r12 = r11.getParentData()
            boolean r13 = r12 instanceof androidx.compose.animation.AnimatedContentTransitionScopeImpl.ChildData
            if (r13 == 0) goto L_0x0027
            r9 = r12
            androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData r9 = (androidx.compose.animation.AnimatedContentTransitionScopeImpl.ChildData) r9
        L_0x0027:
            if (r9 == 0) goto L_0x0035
            boolean r9 = r9.isTarget()
            if (r9 != r10) goto L_0x0035
            androidx.compose.ui.layout.Placeable r9 = r11.m5368measureBRTryo0(r2)
            r5[r8] = r9
        L_0x0035:
            int r8 = r8 + 1
            goto L_0x0012
        L_0x0038:
            int r6 = r20.size()
            r8 = r7
        L_0x003d:
            if (r8 >= r6) goto L_0x0052
            java.lang.Object r11 = r1.get(r8)
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            r12 = r5[r8]
            if (r12 != 0) goto L_0x004f
            androidx.compose.ui.layout.Placeable r11 = r11.m5368measureBRTryo0(r2)
            r5[r8] = r11
        L_0x004f:
            int r8 = r8 + 1
            goto L_0x003d
        L_0x0052:
            if (r4 != 0) goto L_0x0056
            r1 = r9
            goto L_0x0089
        L_0x0056:
            r1 = r5[r7]
            int r2 = kotlin.collections.ArraysKt.getLastIndex((T[]) r5)
            if (r2 != 0) goto L_0x005f
            goto L_0x0089
        L_0x005f:
            if (r1 == 0) goto L_0x0066
            int r3 = r1.getWidth()
            goto L_0x0067
        L_0x0066:
            r3 = r7
        L_0x0067:
            kotlin.ranges.IntRange r6 = new kotlin.ranges.IntRange
            r6.<init>(r10, r2)
            kotlin.collections.IntIterator r2 = r6.iterator()
        L_0x0070:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0089
            int r6 = r2.nextInt()
            r6 = r5[r6]
            if (r6 == 0) goto L_0x0083
            int r8 = r6.getWidth()
            goto L_0x0084
        L_0x0083:
            r8 = r7
        L_0x0084:
            if (r3 >= r8) goto L_0x0070
            r1 = r6
            r3 = r8
            goto L_0x0070
        L_0x0089:
            if (r1 == 0) goto L_0x0091
            int r1 = r1.getWidth()
            r12 = r1
            goto L_0x0092
        L_0x0091:
            r12 = r7
        L_0x0092:
            if (r4 != 0) goto L_0x0095
            goto L_0x00c8
        L_0x0095:
            r9 = r5[r7]
            int r1 = kotlin.collections.ArraysKt.getLastIndex((T[]) r5)
            if (r1 != 0) goto L_0x009e
            goto L_0x00c8
        L_0x009e:
            if (r9 == 0) goto L_0x00a5
            int r2 = r9.getHeight()
            goto L_0x00a6
        L_0x00a5:
            r2 = r7
        L_0x00a6:
            kotlin.ranges.IntRange r3 = new kotlin.ranges.IntRange
            r3.<init>(r10, r1)
            kotlin.collections.IntIterator r1 = r3.iterator()
        L_0x00af:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00c8
            int r3 = r1.nextInt()
            r3 = r5[r3]
            if (r3 == 0) goto L_0x00c2
            int r4 = r3.getHeight()
            goto L_0x00c3
        L_0x00c2:
            r4 = r7
        L_0x00c3:
            if (r2 >= r4) goto L_0x00af
            r9 = r3
            r2 = r4
            goto L_0x00af
        L_0x00c8:
            if (r9 == 0) goto L_0x00ce
            int r7 = r9.getHeight()
        L_0x00ce:
            r13 = r7
            androidx.compose.animation.AnimatedContentTransitionScopeImpl<?> r1 = r0.rootScope
            long r2 = androidx.compose.ui.unit.IntSizeKt.IntSize(r12, r13)
            r1.m61setMeasuredSizeozmzZPI$animation_release(r2)
            androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3 r1 = new androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
            r1.<init>(r5, r0, r12, r13)
            r15 = r1
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r16 = 4
            r17 = 0
            r14 = 0
            r11 = r19
            androidx.compose.ui.layout.MeasureResult r1 = androidx.compose.ui.layout.MeasureScope.CC.layout$default(r11, r12, r13, r14, r15, r16, r17)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentMeasurePolicy.m36measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
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
