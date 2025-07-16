package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\t\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u000e\u001a\u00020\u0003*\u00020\u0003H'R\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0002\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/LookaheadScope;", "", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates$annotations", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)V", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "coordinates", "localLookaheadPositionOf-dBAh8RU", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)J", "toLookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadScope.kt */
public interface LookaheadScope {
    LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope);

    /* renamed from: localLookaheadPositionOf-dBAh8RU  reason: not valid java name */
    long m5365localLookaheadPositionOfdBAh8RU(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2);

    LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates);

    /* renamed from: androidx.compose.ui.layout.LookaheadScope$-CC  reason: invalid class name */
    /* compiled from: LookaheadScope.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void getLookaheadScopeCoordinates$annotations(Placeable.PlacementScope placementScope) {
        }

        /* renamed from: $default$localLookaheadPositionOf-dBAh8RU  reason: not valid java name */
        public static long m5366$default$localLookaheadPositionOfdBAh8RU(LookaheadScope _this, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
            return _this.toLookaheadCoordinates(layoutCoordinates).m5319localPositionOfR5De75A(_this.toLookaheadCoordinates(layoutCoordinates2), Offset.Companion.m3578getZeroF1C5BW0());
        }
    }
}
