package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0015\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0016\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a*\u0010\u001a\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0011\u001a\u001e\u0010\u001e\u001a\u00020\f*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0019\u001a*\u0010 \u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0019\u001a&\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a>\u0010*\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001e\u0010/\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019\u001a*\u00101\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0019\u001a&\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u0010)\u001a>\u00106\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b7\u0010.\u001a\u001e\u0010%\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019\u001a*\u00109\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0011\u001a \u0010;\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010@\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020A2\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010B\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020?H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillElement;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "defaultMinSize", "Landroidx/compose/ui/Modifier;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fraction", "", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", "min", "max", "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", "size", "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "Landroidx/compose/ui/unit/DpSize;", "requiredSize-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "requiredSizeIn", "maxWidth", "maxHeight", "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "size-6HolHcs", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "wrapContentSize", "Landroidx/compose/ui/Alignment;", "wrapContentWidth", "Landroidx/compose/ui/Alignment$Horizontal;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
public final class SizeKt {
    private static final FillElement FillWholeMaxHeight = FillElement.Companion.height(1.0f);
    private static final FillElement FillWholeMaxSize = FillElement.Companion.size(1.0f);
    private static final FillElement FillWholeMaxWidth = FillElement.Companion.width(1.0f);
    private static final WrapContentElement WrapContentHeightCenter = WrapContentElement.Companion.height(Alignment.Companion.getCenterVertically(), false);
    private static final WrapContentElement WrapContentHeightTop = WrapContentElement.Companion.height(Alignment.Companion.getTop(), false);
    private static final WrapContentElement WrapContentSizeCenter = WrapContentElement.Companion.size(Alignment.Companion.getCenter(), false);
    private static final WrapContentElement WrapContentSizeTopStart = WrapContentElement.Companion.size(Alignment.Companion.getTopStart(), false);
    private static final WrapContentElement WrapContentWidthCenter = WrapContentElement.Companion.width(Alignment.Companion.getCenterHorizontally(), false);
    private static final WrapContentElement WrapContentWidthStart = WrapContentElement.Companion.width(Alignment.Companion.getStart(), false);

    /* renamed from: width-3ABfNKs  reason: not valid java name */
    public static final Modifier m747width3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$width3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: height-3ABfNKs  reason: not valid java name */
    public static final Modifier m728height3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$height3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: size-6HolHcs  reason: not valid java name */
    public static final Modifier m743size6HolHcs(Modifier modifier, long j) {
        return m744sizeVpY3zN4(modifier, DpSize.m6712getWidthD9Ej5fM(j), DpSize.m6710getHeightD9Ej5fM(j));
    }

    /* renamed from: widthIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m749widthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        return m748widthInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: widthIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m748widthInVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(f, 0.0f, f2, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$widthInVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: heightIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m730heightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        return m729heightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: heightIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m729heightInVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$heightInVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: sizeIn-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m746sizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        return m745sizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: sizeIn-qDBjuR0  reason: not valid java name */
    public static final Modifier m745sizeInqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        return modifier.then(new SizeElement(f, f2, f3, f4, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$sizeInqDBjuR0$$inlined$debugInspectorInfo$1(f, f2, f3, f4) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredWidth-3ABfNKs  reason: not valid java name */
    public static final Modifier m739requiredWidth3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidth3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredHeight-3ABfNKs  reason: not valid java name */
    public static final Modifier m731requiredHeight3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeight3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-6HolHcs  reason: not valid java name */
    public static final Modifier m735requiredSize6HolHcs(Modifier modifier, long j) {
        return m736requiredSizeVpY3zN4(modifier, DpSize.m6712getWidthD9Ej5fM(j), DpSize.m6710getHeightD9Ej5fM(j));
    }

    /* renamed from: requiredWidthIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m741requiredWidthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        return m740requiredWidthInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredWidthIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m740requiredWidthInVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(f, 0.0f, f2, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidthInVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredHeightIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m733requiredHeightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        return m732requiredHeightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredHeightIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m732requiredHeightInVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeightInVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m738requiredSizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        return m737requiredSizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: requiredSizeIn-qDBjuR0  reason: not valid java name */
    public static final Modifier m737requiredSizeInqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        return modifier.then(new SizeElement(f, f2, f3, f4, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1(f, f2, f3, f4) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxWidth(modifier, f);
    }

    public static final Modifier fillMaxWidth(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxWidth : FillElement.Companion.width(f));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxHeight(modifier, f);
    }

    public static final Modifier fillMaxHeight(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxHeight : FillElement.Companion.height(f));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxSize(modifier, f);
    }

    public static final Modifier fillMaxSize(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxSize : FillElement.Companion.size(f));
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = Alignment.Companion.getCenterHorizontally();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentWidth(modifier, horizontal, z);
    }

    public static final Modifier wrapContentWidth(Modifier modifier, Alignment.Horizontal horizontal, boolean z) {
        WrapContentElement wrapContentElement;
        if (Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getCenterHorizontally()) && !z) {
            wrapContentElement = WrapContentWidthCenter;
        } else if (!Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getStart()) || z) {
            wrapContentElement = WrapContentElement.Companion.width(horizontal, z);
        } else {
            wrapContentElement = WrapContentWidthStart;
        }
        return modifier.then(wrapContentElement);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = Alignment.Companion.getCenterVertically();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentHeight(modifier, vertical, z);
    }

    public static final Modifier wrapContentHeight(Modifier modifier, Alignment.Vertical vertical, boolean z) {
        WrapContentElement wrapContentElement;
        if (Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getCenterVertically()) && !z) {
            wrapContentElement = WrapContentHeightCenter;
        } else if (!Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getTop()) || z) {
            wrapContentElement = WrapContentElement.Companion.height(vertical, z);
        } else {
            wrapContentElement = WrapContentHeightTop;
        }
        return modifier.then(wrapContentElement);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentSize(modifier, alignment, z);
    }

    public static final Modifier wrapContentSize(Modifier modifier, Alignment alignment, boolean z) {
        WrapContentElement wrapContentElement;
        if (Intrinsics.areEqual((Object) alignment, (Object) Alignment.Companion.getCenter()) && !z) {
            wrapContentElement = WrapContentSizeCenter;
        } else if (!Intrinsics.areEqual((Object) alignment, (Object) Alignment.Companion.getTopStart()) || z) {
            wrapContentElement = WrapContentElement.Companion.size(alignment, z);
        } else {
            wrapContentElement = WrapContentSizeTopStart;
        }
        return modifier.then(wrapContentElement);
    }

    /* renamed from: defaultMinSize-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m727defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6634getUnspecifiedD9Ej5fM();
        }
        return m726defaultMinSizeVpY3zN4(modifier, f, f2);
    }

    /* renamed from: defaultMinSize-VpY3zN4  reason: not valid java name */
    public static final Modifier m726defaultMinSizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new UnspecifiedConstraintsElement(f, f2, (DefaultConstructorMarker) null));
    }

    /* renamed from: size-3ABfNKs  reason: not valid java name */
    public static final Modifier m742size3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, f, f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$size3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: size-VpY3zN4  reason: not valid java name */
    public static final Modifier m744sizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$sizeVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-3ABfNKs  reason: not valid java name */
    public static final Modifier m734requiredSize3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, f, f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSize3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-VpY3zN4  reason: not valid java name */
    public static final Modifier m736requiredSizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }
}
