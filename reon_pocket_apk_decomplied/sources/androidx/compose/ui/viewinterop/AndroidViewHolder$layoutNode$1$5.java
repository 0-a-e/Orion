package androidx.compose.ui.viewinterop;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\"\u0010\u0007\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\f\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u0016\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"androidx/compose/ui/viewinterop/AndroidViewHolder$layoutNode$1$5", "Landroidx/compose/ui/layout/MeasurePolicy;", "intrinsicHeight", "", "width", "intrinsicWidth", "height", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
public final class AndroidViewHolder$layoutNode$1$5 implements MeasurePolicy {
    final /* synthetic */ LayoutNode $layoutNode;
    final /* synthetic */ AndroidViewHolder $this_run;

    AndroidViewHolder$layoutNode$1$5(AndroidViewHolder androidViewHolder, LayoutNode layoutNode) {
        this.$this_run = androidViewHolder;
        this.$layoutNode = layoutNode;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m6867measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        if (this.$this_run.getChildCount() == 0) {
            return MeasureScope.CC.layout$default(measureScope, Constraints.m6528getMinWidthimpl(j), Constraints.m6527getMinHeightimpl(j), (Map) null, AndroidViewHolder$layoutNode$1$5$measure$1.INSTANCE, 4, (Object) null);
        }
        if (Constraints.m6528getMinWidthimpl(j) != 0) {
            this.$this_run.getChildAt(0).setMinimumWidth(Constraints.m6528getMinWidthimpl(j));
        }
        if (Constraints.m6527getMinHeightimpl(j) != 0) {
            this.$this_run.getChildAt(0).setMinimumHeight(Constraints.m6527getMinHeightimpl(j));
        }
        AndroidViewHolder androidViewHolder = this.$this_run;
        int r0 = Constraints.m6528getMinWidthimpl(j);
        int r1 = Constraints.m6526getMaxWidthimpl(j);
        ViewGroup.LayoutParams layoutParams = this.$this_run.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        int access$obtainMeasureSpec = androidViewHolder.obtainMeasureSpec(r0, r1, layoutParams.width);
        AndroidViewHolder androidViewHolder2 = this.$this_run;
        int r2 = Constraints.m6527getMinHeightimpl(j);
        int r10 = Constraints.m6525getMaxHeightimpl(j);
        ViewGroup.LayoutParams layoutParams2 = this.$this_run.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2);
        androidViewHolder.measure(access$obtainMeasureSpec, androidViewHolder2.obtainMeasureSpec(r2, r10, layoutParams2.height));
        return MeasureScope.CC.layout$default(measureScope, this.$this_run.getMeasuredWidth(), this.$this_run.getMeasuredHeight(), (Map) null, new AndroidViewHolder$layoutNode$1$5$measure$2(this.$this_run, this.$layoutNode), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(i);
    }

    private final int intrinsicWidth(int i) {
        AndroidViewHolder androidViewHolder = this.$this_run;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        AndroidViewHolder androidViewHolder2 = this.$this_run;
        ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        androidViewHolder.measure(makeMeasureSpec, androidViewHolder2.obtainMeasureSpec(0, i, layoutParams.height));
        return this.$this_run.getMeasuredWidth();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(i);
    }

    private final int intrinsicHeight(int i) {
        AndroidViewHolder androidViewHolder = this.$this_run;
        ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        androidViewHolder.measure(androidViewHolder.obtainMeasureSpec(0, i, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.$this_run.getMeasuredHeight();
    }
}
