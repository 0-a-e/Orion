package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ&\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/material3/TabIndicatorOffsetNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "tabPositionsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/material3/TabPosition;", "selectedTabIndex", "", "followContentSize", "", "(Landroidx/compose/runtime/State;IZ)V", "getFollowContentSize", "()Z", "setFollowContentSize", "(Z)V", "initialOffset", "Landroidx/compose/ui/unit/Dp;", "initialWidth", "offsetAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getSelectedTabIndex", "()I", "setSelectedTabIndex", "(I)V", "getTabPositionsState", "()Landroidx/compose/runtime/State;", "setTabPositionsState", "(Landroidx/compose/runtime/State;)V", "widthAnimatable", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabIndicatorOffsetNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private boolean followContentSize;
    private Dp initialOffset;
    private Dp initialWidth;
    private Animatable<Dp, AnimationVector1D> offsetAnimatable;
    private int selectedTabIndex;
    private State<? extends List<TabPosition>> tabPositionsState;
    private Animatable<Dp, AnimationVector1D> widthAnimatable;

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final State<List<TabPosition>> getTabPositionsState() {
        return this.tabPositionsState;
    }

    public final void setTabPositionsState(State<? extends List<TabPosition>> state) {
        this.tabPositionsState = state;
    }

    public final int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public final void setSelectedTabIndex(int i) {
        this.selectedTabIndex = i;
    }

    public final boolean getFollowContentSize() {
        return this.followContentSize;
    }

    public final void setFollowContentSize(boolean z) {
        this.followContentSize = z;
    }

    public TabIndicatorOffsetNode(State<? extends List<TabPosition>> state, int i, boolean z) {
        this.tabPositionsState = state;
        this.selectedTabIndex = i;
        this.followContentSize = z;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2340measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Measurable measurable2;
        long j2;
        MeasureScope measureScope2 = measureScope;
        if (((List) this.tabPositionsState.getValue()).isEmpty()) {
            return MeasureScope.CC.layout$default(measureScope, 0, 0, (Map) null, TabIndicatorOffsetNode$measure$1.INSTANCE, 4, (Object) null);
        }
        float r1 = ((TabPosition) ((List) this.tabPositionsState.getValue()).get(this.selectedTabIndex)).m2347getContentWidthD9Ej5fM();
        if (this.followContentSize) {
            if (this.initialWidth != null) {
                Animatable<Dp, AnimationVector1D> animatable = this.widthAnimatable;
                if (animatable == null) {
                    Dp dp = this.initialWidth;
                    Intrinsics.checkNotNull(dp);
                    animatable = new Animatable<>(dp, VectorConvertersKt.getVectorConverter(Dp.Companion), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
                    this.widthAnimatable = animatable;
                }
                if (!Dp.m6619equalsimpl0(r1, animatable.getTargetValue().m6628unboximpl())) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TabIndicatorOffsetNode$measure$2(animatable, r1, (Continuation<? super TabIndicatorOffsetNode$measure$2>) null), 3, (Object) null);
                }
            } else {
                this.initialWidth = Dp.m6612boximpl(r1);
            }
        }
        float r2 = ((TabPosition) ((List) this.tabPositionsState.getValue()).get(this.selectedTabIndex)).m2348getLeftD9Ej5fM();
        if (this.initialOffset != null) {
            Animatable<Dp, AnimationVector1D> animatable2 = this.offsetAnimatable;
            if (animatable2 == null) {
                Dp dp2 = this.initialOffset;
                Intrinsics.checkNotNull(dp2);
                animatable2 = new Animatable<>(dp2, VectorConvertersKt.getVectorConverter(Dp.Companion), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
                this.offsetAnimatable = animatable2;
            }
            if (!Dp.m6619equalsimpl0(r2, animatable2.getTargetValue().m6628unboximpl())) {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TabIndicatorOffsetNode$measure$3(animatable2, r2, (Continuation<? super TabIndicatorOffsetNode$measure$3>) null), 3, (Object) null);
            }
        } else {
            this.initialOffset = Dp.m6612boximpl(r2);
        }
        Animatable<Dp, AnimationVector1D> animatable3 = this.offsetAnimatable;
        if (animatable3 != null) {
            r2 = animatable3.getValue().m6628unboximpl();
        }
        float f = r2;
        if (this.followContentSize) {
            Animatable<Dp, AnimationVector1D> animatable4 = this.widthAnimatable;
            if (animatable4 != null) {
                r1 = animatable4.getValue().m6628unboximpl();
            }
            j2 = Constraints.m6517copyZbe2FdA$default(j, measureScope2.m6545roundToPx0680j_4(r1), measureScope2.m6545roundToPx0680j_4(r1), 0, 0, 12, (Object) null);
            measurable2 = measurable;
        } else {
            measurable2 = measurable;
            j2 = j;
        }
        Placeable r22 = measurable2.m5368measureBRTryo0(j2);
        int width = r22.getWidth();
        return MeasureScope.CC.layout$default(measureScope, width, Constraints.m6525getMaxHeightimpl(j), (Map) null, new TabIndicatorOffsetNode$measure$4(r22, measureScope, f, j), 4, (Object) null);
    }
}
