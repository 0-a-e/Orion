package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J=\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0019\u0010#\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e\u0018\u00010$¢\u0006\u0002\b&H$ø\u0001\u0000¢\u0006\u0004\b'\u0010(R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR,\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@DX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR,\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0017@DX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "()V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "()J", "J", "", "height", "getHeight", "()I", "measuredHeight", "getMeasuredHeight", "value", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "setMeasuredSize-ozmzZPI", "(J)V", "measuredWidth", "getMeasuredWidth", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "width", "getWidth", "onMeasuredSizeChanged", "", "placeAt", "position", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "PlacementScope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Placeable.kt */
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public long apparentToRealOffset = IntOffset.Companion.m6758getZeronOccac();
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private int width;

    public /* synthetic */ Object getParentData() {
        return Measured.CC.$default$getParentData(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public abstract void m5406placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1);

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredWidth() {
        return IntSize.m6790getWidthimpl(this.measuredSize);
    }

    public int getMeasuredHeight() {
        return IntSize.m6789getHeightimpl(this.measuredSize);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getMeasuredSize-YbymL2g  reason: not valid java name */
    public final long m5404getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMeasuredSize-ozmzZPI  reason: not valid java name */
    public final void m5407setMeasuredSizeozmzZPI(long j) {
        if (!IntSize.m6788equalsimpl0(this.measuredSize, j)) {
            this.measuredSize = j;
            onMeasuredSizeChanged();
        }
    }

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn(IntSize.m6790getWidthimpl(this.measuredSize), Constraints.m6528getMinWidthimpl(this.measurementConstraints), Constraints.m6526getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt.coerceIn(IntSize.m6789getHeightimpl(this.measuredSize), Constraints.m6527getMinHeightimpl(this.measurementConstraints), Constraints.m6525getMaxHeightimpl(this.measurementConstraints));
        this.apparentToRealOffset = IntOffsetKt.IntOffset((this.width - IntSize.m6790getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m6789getHeightimpl(this.measuredSize)) / 2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getMeasurementConstraints-msEJaDk  reason: not valid java name */
    public final long m5405getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMeasurementConstraints-BRTryo0  reason: not valid java name */
    public final void m5408setMeasurementConstraintsBRTryo0(long j) {
        if (!Constraints.m6519equalsimpl0(this.measurementConstraints, j)) {
            this.measurementConstraints = j;
            onMeasuredSizeChanged();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: getApparentToRealOffset-nOcc-ac  reason: not valid java name */
    public final long m5403getApparentToRealOffsetnOccac() {
        return this.apparentToRealOffset;
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015JD\u0010\u001a\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u001b\b\b\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001c¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JD\u0010!\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u001b\b\b\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001c¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\b\"\u0010 J&\u0010#\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0017J$\u0010#\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015JA\u0010%\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eø\u0001\u0000¢\u0006\u0004\b&\u0010 J?\u0010%\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eJA\u0010'\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eø\u0001\u0000¢\u0006\u0004\b(\u0010 J?\u0010'\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "()V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "place", "", "Landroidx/compose/ui/layout/Placeable;", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "place-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "placeApparentToRealOffset", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeApparentToRealOffset-aW-9-wM$ui_release", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui_release", "placeRelative", "placeRelative-70tqf50", "placeRelativeWithLayer", "placeRelativeWithLayer-aW-9-wM", "placeWithLayer", "placeWithLayer-aW-9-wM", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Placeable.kt */
    public static abstract class PlacementScope {
        public static final int $stable = 0;

        public LayoutCoordinates getCoordinates() {
            return null;
        }

        /* access modifiers changed from: protected */
        public abstract LayoutDirection getParentLayoutDirection();

        /* access modifiers changed from: protected */
        public abstract int getParentWidth();

        /* renamed from: placeRelative-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m5410placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                placementScope.m5416placeRelative70tqf50(placeable, j, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.placeRelative(placeable, i, i2, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
        }

        public final void placeRelative(Placeable placeable, int i, int i2, float f) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.apparentToRealOffset;
                placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(IntOffset) + IntOffset.m6749getYimpl(r0)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m6748getXimpl(IntOffset), IntOffset.m6749getYimpl(IntOffset));
            long r02 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset2) + IntOffset.m6748getXimpl(r02), IntOffset.m6749getYimpl(IntOffset2) + IntOffset.m6749getYimpl(r02)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.place(placeable, i, i2, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
        }

        public final void place(Placeable placeable, int i, int i2, float f) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            long r0 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(IntOffset) + IntOffset.m6749getYimpl(r0)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m5409place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                placementScope.m5413place70tqf50(placeable, j, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m5411placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                float f2 = f;
                if ((i & 4) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.m5417placeRelativeWithLayeraW9wM(placeable, j, f2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                float f2 = f;
                if ((i3 & 8) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.placeRelativeWithLayer(placeable, i, i2, f2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.apparentToRealOffset;
                placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(IntOffset) + IntOffset.m6749getYimpl(r0)), f, function1);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m6748getXimpl(IntOffset), IntOffset.m6749getYimpl(IntOffset));
            long r02 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset2) + IntOffset.m6748getXimpl(r02), IntOffset.m6749getYimpl(IntOffset2) + IntOffset.m6749getYimpl(r02)), f, function1);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                float f2 = f;
                if ((i3 & 8) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.placeWithLayer(placeable, i, i2, f2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            long r0 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(IntOffset) + IntOffset.m6749getYimpl(r0)), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m5412placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                float f2 = f;
                if ((i & 4) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.m5418placeWithLayeraW9wM(placeable, j, f2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release  reason: not valid java name */
        public final void m5415placeAutoMirroredaW9wM$ui_release(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.apparentToRealOffset;
                placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(r0)), f, function1);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(j));
            long r02 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset) + IntOffset.m6748getXimpl(r02), IntOffset.m6749getYimpl(IntOffset) + IntOffset.m6749getYimpl(r02)), f, function1);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release  reason: not valid java name */
        public final void m5414placeApparentToRealOffsetaW9wM$ui_release(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            long r0 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(r0)), f, function1);
        }

        /* renamed from: placeRelative-70tqf50  reason: not valid java name */
        public final void m5416placeRelative70tqf50(Placeable placeable, long j, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.apparentToRealOffset;
                placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(r0)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(j));
            long r02 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset) + IntOffset.m6748getXimpl(r02), IntOffset.m6749getYimpl(IntOffset) + IntOffset.m6749getYimpl(r02)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50  reason: not valid java name */
        public final void m5413place70tqf50(Placeable placeable, long j, float f) {
            long r0 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(r0)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m5417placeRelativeWithLayeraW9wM(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.apparentToRealOffset;
                placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(r0)), f, function1);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(j));
            long r02 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(IntOffset) + IntOffset.m6748getXimpl(r02), IntOffset.m6749getYimpl(IntOffset) + IntOffset.m6749getYimpl(r02)), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m5418placeWithLayeraW9wM(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            long r0 = placeable.apparentToRealOffset;
            placeable.m5406placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(j) + IntOffset.m6748getXimpl(r0), IntOffset.m6749getYimpl(j) + IntOffset.m6749getYimpl(r0)), f, function1);
        }
    }
}
