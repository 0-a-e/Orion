package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JH\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\u0001J(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u0019*\u000200H\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0017\u0010/\u001a\u00020\u0019*\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0016\u00106\u001a\u000200*\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0019\u00106\u001a\u000200*\u00020\tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0019\u00106\u001a\u000200*\u00020\u0019H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010;J\u0016\u0010<\u001a\u00020=*\u00020>H\u0016ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\t*\u000200H\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010:J\u0017\u0010A\u001a\u00020\t*\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u00108J\r\u0010D\u001a\u00020E*\u00020FH\u0001J\u0016\u0010G\u001a\u00020>*\u00020=H\u0016ø\u0001\u0000¢\u0006\u0004\bH\u0010@J\u0016\u0010I\u001a\u000203*\u000200H\u0016ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u0019\u0010I\u001a\u000203*\u00020\tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010KJ\u0019\u0010I\u001a\u000203*\u00020\u0019H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MR\u0014\u0010\b\u001a\u00020\t8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u0014X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0018j\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a`\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006N"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeMeasureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "placeablesCache", "Ljava/util/HashMap;", "", "", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/collections/HashMap;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "measure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutMeasureScope.kt */
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    public static final int $stable = 0;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final LazyLayoutItemProvider itemProvider;
    private final HashMap<Integer, List<Placeable>> placeablesCache = new HashMap<>();
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    public boolean isLookingAhead() {
        return this.subcomposeMeasureScope.isLookingAhead();
    }

    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
        return this.subcomposeMeasureScope.layout(i, i2, map, function1);
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m889roundToPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.m6544roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m890roundToPx0680j_4(float f) {
        return this.subcomposeMeasureScope.m6545roundToPx0680j_4(f);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m895toPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.m6549toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m896toPx0680j_4(float f) {
        return this.subcomposeMeasureScope.m6550toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        return this.subcomposeMeasureScope.toRect(dpRect);
    }

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope2) {
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope2;
        this.itemProvider = lazyLayoutItemContentFactory.getItemProvider().invoke();
    }

    /* renamed from: measure-0kLqBqw  reason: not valid java name */
    public List<Placeable> m888measure0kLqBqw(int i, long j) {
        List<Placeable> list = this.placeablesCache.get(Integer.valueOf(i));
        if (list != null) {
            return list;
        }
        Object key = this.itemProvider.getKey(i);
        List<Measurable> subcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i, key, this.itemProvider.getContentType(i)));
        int size = subcompose.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(subcompose.get(i2).m5368measureBRTryo0(j));
        }
        List<Placeable> list2 = arrayList;
        this.placeablesCache.put(Integer.valueOf(i), list2);
        return list2;
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m891toDpGaN1DYA(long j) {
        return this.subcomposeMeasureScope.m6723toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m893toDpu2uoSUM(int i) {
        return this.subcomposeMeasureScope.m6547toDpu2uoSUM(i);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m892toDpu2uoSUM(float f) {
        return this.subcomposeMeasureScope.m6546toDpu2uoSUM(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m899toSpkPz2Gy4(float f) {
        return this.subcomposeMeasureScope.m6552toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m900toSpkPz2Gy4(int i) {
        return this.subcomposeMeasureScope.m6553toSpkPz2Gy4(i);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m898toSp0xMU5do(float f) {
        return this.subcomposeMeasureScope.m6724toSp0xMU5do(f);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m897toSizeXkaWNTQ(long j) {
        return this.subcomposeMeasureScope.m6551toSizeXkaWNTQ(j);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m894toDpSizekrfVVM(long j) {
        return this.subcomposeMeasureScope.m6548toDpSizekrfVVM(j);
    }
}
