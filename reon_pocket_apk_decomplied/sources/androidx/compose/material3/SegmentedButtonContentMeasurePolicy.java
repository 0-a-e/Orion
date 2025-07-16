package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/SegmentedButtonContentMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "setAnimatable", "(Landroidx/compose/animation/core/Animatable;)V", "initialOffset", "Ljava/lang/Integer;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentedButton.kt */
public final class SegmentedButtonContentMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable = 0;
    private Animatable<Integer, AnimationVector1D> animatable;
    private Integer initialOffset;
    private final CoroutineScope scope;

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MultiContentMeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MultiContentMeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public SegmentedButtonContentMeasurePolicy(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final Animatable<Integer, AnimationVector1D> getAnimatable() {
        return this.animatable;
    }

    public final void setAnimatable(Animatable<Integer, AnimationVector1D> animatable2) {
        this.animatable = animatable2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2138measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        MeasureScope measureScope2 = measureScope;
        List<? extends List<? extends Measurable>> list2 = list;
        long j2 = j;
        List list3 = (List) list2.get(0);
        int i = 1;
        List list4 = (List) list2.get(1);
        ArrayList arrayList = new ArrayList(list3.size());
        int size = list3.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Measurable) list3.get(i2)).m5368measureBRTryo0(j2));
        }
        List list5 = arrayList;
        if (list5.isEmpty()) {
            obj = null;
        } else {
            obj = list5.get(0);
            int width = ((Placeable) obj).getWidth();
            int lastIndex = CollectionsKt.getLastIndex(list5);
            if (1 <= lastIndex) {
                int i3 = 1;
                while (true) {
                    Object obj4 = list5.get(i3);
                    int width2 = ((Placeable) obj4).getWidth();
                    if (width < width2) {
                        obj = obj4;
                        width = width2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        int width3 = placeable != null ? placeable.getWidth() : 0;
        ArrayList arrayList2 = new ArrayList(list4.size());
        int size2 = list4.size();
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList2.add(((Measurable) list4.get(i4)).m5368measureBRTryo0(j2));
        }
        List list6 = arrayList2;
        if (list6.isEmpty()) {
            obj2 = null;
        } else {
            obj2 = list6.get(0);
            int width4 = ((Placeable) obj2).getWidth();
            int lastIndex2 = CollectionsKt.getLastIndex(list6);
            if (1 <= lastIndex2) {
                int i5 = 1;
                while (true) {
                    Object obj5 = list6.get(i5);
                    int width5 = ((Placeable) obj5).getWidth();
                    if (width4 < width5) {
                        obj2 = obj5;
                        width4 = width5;
                    }
                    if (i5 == lastIndex2) {
                        break;
                    }
                    i5++;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj2;
        Integer valueOf = placeable2 != null ? Integer.valueOf(placeable2.getWidth()) : null;
        if (list6.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = list6.get(0);
            int height = ((Placeable) obj3).getHeight();
            int lastIndex3 = CollectionsKt.getLastIndex(list6);
            if (1 <= lastIndex3) {
                while (true) {
                    Object obj6 = list6.get(i);
                    int height2 = ((Placeable) obj6).getHeight();
                    if (height < height2) {
                        obj3 = obj6;
                        height = height2;
                    }
                    if (i == lastIndex3) {
                        break;
                    }
                    i++;
                }
            }
        }
        Placeable placeable3 = (Placeable) obj3;
        int height3 = placeable3 != null ? placeable3.getHeight() : 0;
        int max = Math.max(measureScope2.m6545roundToPx0680j_4(SegmentedButtonDefaults.INSTANCE.m2143getIconSizeD9Ej5fM()), width3) + measureScope2.m6545roundToPx0680j_4(SegmentedButtonKt.IconSpacing) + (valueOf != null ? valueOf.intValue() : 0);
        int i6 = width3 == 0 ? (-(measureScope2.m6545roundToPx0680j_4(SegmentedButtonDefaults.INSTANCE.m2143getIconSizeD9Ej5fM()) + measureScope2.m6545roundToPx0680j_4(SegmentedButtonKt.IconSpacing))) / 2 : 0;
        if (this.initialOffset == null) {
            this.initialOffset = Integer.valueOf(i6);
        } else {
            Animatable<Integer, AnimationVector1D> animatable2 = this.animatable;
            if (animatable2 == null) {
                Integer num = this.initialOffset;
                Intrinsics.checkNotNull(num);
                animatable2 = new Animatable<>(num, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
                this.animatable = animatable2;
            }
            if (animatable2.getTargetValue().intValue() != i6) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SegmentedButtonContentMeasurePolicy$measure$1(animatable2, i6, (Continuation<? super SegmentedButtonContentMeasurePolicy$measure$1>) null), 3, (Object) null);
            }
        }
        return MeasureScope.CC.layout$default(measureScope, max, height3, (Map) null, new SegmentedButtonContentMeasurePolicy$measure$2(list5, measureScope, this, i6, list6, height3), 4, (Object) null);
    }
}
