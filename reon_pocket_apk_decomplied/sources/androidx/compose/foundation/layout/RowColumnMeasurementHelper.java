package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\u0002\u0010\u0014J2\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020+H\u0002J(\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002032\u0006\u00102\u001a\u0002032\u0006\u00106\u001a\u000207H\u0002J0\u00108\u001a\u0002092\u0006\u00106\u001a\u0002072\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b>\u0010?J&\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020+2\u0006\u0010/\u001a\u000200J\n\u0010\n\u001a\u00020+*\u00020\u0013J\n\u0010F\u001a\u00020+*\u00020\u0013R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001b\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012X\u0004¢\u0006\u0004\n\u0002\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArrangementSpacing-D9Ej5fM", "()F", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisSize", "()Landroidx/compose/foundation/layout/SizeMode;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getMeasurables", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/layout/LayoutOrientation;", "getPlaceables", "()[Landroidx/compose/ui/layout/Placeable;", "[Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "[Landroidx/compose/foundation/layout/RowColumnParentData;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getCrossAxisPosition", "", "placeable", "parentData", "crossAxisLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measureWithoutPlacing", "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "startIndex", "endIndex", "measureWithoutPlacing-_EkL_-Y", "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "placeHelper", "", "placeableScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measureResult", "crossAxisOffset", "mainAxisSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnMeasurementHelper.kt */
public final class RowColumnMeasurementHelper {
    public static final int $stable = 8;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final Arrangement.Horizontal horizontalArrangement;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, horizontal, vertical, f, sizeMode, crossAxisAlignment2, list, placeableArr);
    }

    private RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, List<? extends Measurable> list, Placeable[] placeableArr) {
        this.orientation = layoutOrientation;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.arrangementSpacing = f;
        this.crossAxisSize = sizeMode;
        this.crossAxisAlignment = crossAxisAlignment2;
        this.measurables = list;
        this.placeables = placeableArr;
        int size = list.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    /* renamed from: getArrangementSpacing-D9Ej5fM  reason: not valid java name */
    public final float m713getArrangementSpacingD9Ej5fM() {
        return this.arrangementSpacing;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final int mainAxisSize(Placeable placeable) {
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    public final int crossAxisSize(Placeable placeable) {
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: measureWithoutPlacing-_EkL_-Y  reason: not valid java name */
    public final RowColumnMeasureHelperResult m714measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long j, int i, int i2) {
        int i3;
        int i4;
        int i5;
        long j2;
        RowColumnMeasurementHelper rowColumnMeasurementHelper;
        RowColumnMeasurementHelper rowColumnMeasurementHelper2;
        int i6;
        int i7;
        int i8;
        int i9;
        String str;
        String str2;
        float f;
        String str3;
        String str4;
        String str5;
        long j3;
        String str6;
        String str7;
        String str8;
        String str9;
        int i10;
        String str10;
        String str11;
        String str12;
        String str13;
        long j4;
        long j5;
        String str14;
        String str15;
        String str16;
        String str17;
        long j6;
        float f2;
        int i11;
        int i12;
        int i13;
        float f3;
        int i14;
        int i15;
        long j7;
        int i16;
        int i17;
        long j8;
        int i18;
        RowColumnMeasurementHelper rowColumnMeasurementHelper3 = this;
        int i19 = i2;
        long r2 = OrientationIndependentConstraints.m639constructorimpl(j, rowColumnMeasurementHelper3.orientation);
        long r4 = (long) measureScope.m6545roundToPx0680j_4(rowColumnMeasurementHelper3.arrangementSpacing);
        int i20 = i19 - i;
        int i21 = i;
        float f4 = 0.0f;
        long j9 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        boolean z = false;
        while (true) {
            boolean z2 = true;
            if (i21 >= i19) {
                break;
            }
            Measurable measurable = rowColumnMeasurementHelper3.measurables.get(i21);
            RowColumnParentData rowColumnParentData2 = rowColumnMeasurementHelper3.rowColumnParentData[i21];
            float weight = RowColumnImplKt.getWeight(rowColumnParentData2);
            if (weight > 0.0f) {
                f3 = f4 + weight;
                i13 = i22 + 1;
                i14 = i21;
            } else {
                int r13 = Constraints.m6526getMaxWidthimpl(r2);
                Placeable placeable = rowColumnMeasurementHelper3.placeables[i21];
                if (placeable == null) {
                    float f5 = f4;
                    if (r13 == Integer.MAX_VALUE) {
                        i17 = i22;
                        i16 = r13;
                        i18 = Integer.MAX_VALUE;
                        j8 = 0;
                    } else {
                        i17 = i22;
                        i16 = r13;
                        j8 = 0;
                        i18 = (int) RangesKt.coerceAtLeast(((long) r13) - j9, 0);
                    }
                    j7 = j9;
                    f3 = f5;
                    i13 = i17;
                    i14 = i21;
                    long j10 = j8;
                    i15 = i16;
                    placeable = measurable.m5368measureBRTryo0(OrientationIndependentConstraints.m652toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m641copyyUG9Ft0$default(r2, 0, i18, 0, 0, 8, (Object) null), rowColumnMeasurementHelper3.orientation));
                } else {
                    j7 = j9;
                    f3 = f4;
                    i13 = i22;
                    i14 = i21;
                    i15 = r13;
                }
                long j11 = j7;
                int min = Math.min((int) r4, (int) RangesKt.coerceAtLeast((((long) i15) - j11) - ((long) rowColumnMeasurementHelper3.mainAxisSize(placeable)), 0));
                j9 = ((long) (rowColumnMeasurementHelper3.mainAxisSize(placeable) + min)) + j11;
                int max = Math.max(i24, rowColumnMeasurementHelper3.crossAxisSize(placeable));
                if (!z && !RowColumnImplKt.isRelative(rowColumnParentData2)) {
                    z2 = false;
                }
                rowColumnMeasurementHelper3.placeables[i14] = placeable;
                i23 = min;
                i24 = max;
                z = z2;
            }
            i21 = i14 + 1;
            MeasureScope measureScope2 = measureScope;
            f4 = f3;
            i22 = i13;
        }
        long j12 = j9;
        float f6 = f4;
        int i25 = i22;
        if (i25 == 0) {
            j2 = j12 - ((long) i23);
            rowColumnMeasurementHelper = rowColumnMeasurementHelper3;
            i3 = i20;
            i4 = i24;
            i5 = 0;
        } else {
            float f7 = f6;
            int i26 = (f7 > 0.0f ? 1 : (f7 == 0.0f ? 0 : -1));
            if (i26 <= 0 || Constraints.m6526getMaxWidthimpl(r2) == Integer.MAX_VALUE) {
                i9 = Constraints.m6528getMinWidthimpl(r2);
            } else {
                i9 = Constraints.m6526getMaxWidthimpl(r2);
            }
            long j13 = ((long) (i25 - 1)) * r4;
            long j14 = r4;
            long j15 = j13;
            long coerceAtLeast = RangesKt.coerceAtLeast((((long) i9) - j12) - j13, 0);
            float f8 = i26 > 0 ? ((float) coerceAtLeast) / f7 : 0.0f;
            int i27 = i;
            long j16 = coerceAtLeast;
            while (true) {
                i3 = i20;
                str = "weightedSize ";
                str2 = "weightUnitSpace ";
                f = f7;
                str3 = "fixedSpace ";
                str4 = "totalWeight ";
                str5 = "weightChildrenCount ";
                j3 = coerceAtLeast;
                str6 = "arrangementSpacingPx ";
                str7 = "targetSpace ";
                str8 = "remainingToTarget ";
                if (i27 >= i19) {
                    break;
                }
                float weight2 = RowColumnImplKt.getWeight(rowColumnMeasurementHelper3.rowColumnParentData[i27]);
                float f9 = f8 * weight2;
                try {
                    j16 -= (long) MathKt.roundToInt(f9);
                    i27++;
                    rowColumnMeasurementHelper3 = this;
                    i20 = i3;
                    i19 = i2;
                    f7 = f;
                    coerceAtLeast = j3;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax " + Constraints.m6526getMaxWidthimpl(r2) + "mainAxisMin " + Constraints.m6528getMinWidthimpl(r2) + str7 + i9 + str6 + j14 + str5 + i25 + str3 + j12 + "arrangementSpacingTotal " + j15 + str8 + j3 + str4 + f + str2 + f8 + "itemWeight " + weight2 + str + f9).initCause(e);
                }
            }
            long j17 = j15;
            String str18 = str4;
            long j18 = j3;
            long j19 = j12;
            long j20 = j14;
            String str19 = "arrangementSpacingTotal ";
            long j21 = j20;
            String str20 = str8;
            i4 = i24;
            int i28 = 0;
            int i29 = i;
            String str21 = str18;
            int i30 = i2;
            while (i29 < i30) {
                String str22 = str3;
                if (this.placeables[i29] == null) {
                    Measurable measurable2 = this.measurables.get(i29);
                    i10 = i25;
                    RowColumnParentData rowColumnParentData3 = this.rowColumnParentData[i29];
                    String str23 = str5;
                    float weight3 = RowColumnImplKt.getWeight(rowColumnParentData3);
                    if (weight3 > 0.0f) {
                        long j22 = j21;
                        int sign = MathKt.getSign(j16);
                        String str24 = str6;
                        String str25 = str7;
                        j16 -= (long) sign;
                        float f10 = f8 * weight3;
                        String str26 = str24;
                        int max2 = Math.max(0, MathKt.roundToInt(f10) + sign);
                        try {
                            if (!RowColumnImplKt.getFill(rowColumnParentData3) || max2 == Integer.MAX_VALUE) {
                                i11 = sign;
                                i12 = 0;
                            } else {
                                i12 = max2;
                                i11 = sign;
                            }
                            try {
                                f2 = f10;
                                try {
                                    Placeable r42 = measurable2.m5368measureBRTryo0(OrientationIndependentConstraints.m652toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m637constructorimpl(i12, max2, 0, Constraints.m6525getMaxHeightimpl(r2)), this.orientation));
                                    i28 += mainAxisSize(r42);
                                    i4 = Math.max(i4, crossAxisSize(r42));
                                    boolean z3 = z || RowColumnImplKt.isRelative(rowColumnParentData3);
                                    this.placeables[i29] = r42;
                                    z = z3;
                                    str15 = str;
                                    j6 = j19;
                                    j21 = j22;
                                    str17 = str25;
                                    str16 = str26;
                                    str13 = str21;
                                    str11 = str19;
                                    str10 = str22;
                                    str9 = str23;
                                    str14 = str2;
                                    j4 = j18;
                                    str12 = str20;
                                    j5 = j17;
                                } catch (IllegalArgumentException e2) {
                                    e = e2;
                                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + Constraints.m6526getMaxWidthimpl(r2) + "mainAxisMin " + Constraints.m6528getMinWidthimpl(r2) + str25 + i9 + str26 + j22 + str23 + i10 + str22 + j19 + str19 + j17 + str20 + j18 + str21 + f + str2 + f8 + "weight " + weight3 + str + f2 + "remainderUnit " + i11 + "childMainAxisSize " + max2).initCause(e);
                                }
                            } catch (IllegalArgumentException e3) {
                                e = e3;
                                f2 = f10;
                                throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + Constraints.m6526getMaxWidthimpl(r2) + "mainAxisMin " + Constraints.m6528getMinWidthimpl(r2) + str25 + i9 + str26 + j22 + str23 + i10 + str22 + j19 + str19 + j17 + str20 + j18 + str21 + f + str2 + f8 + "weight " + weight3 + str + f2 + "remainderUnit " + i11 + "childMainAxisSize " + max2).initCause(e);
                            }
                        } catch (IllegalArgumentException e4) {
                            e = e4;
                            f2 = f10;
                            i11 = sign;
                            throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + Constraints.m6526getMaxWidthimpl(r2) + "mainAxisMin " + Constraints.m6528getMinWidthimpl(r2) + str25 + i9 + str26 + j22 + str23 + i10 + str22 + j19 + str19 + j17 + str20 + j18 + str21 + f + str2 + f8 + "weight " + weight3 + str + f2 + "remainderUnit " + i11 + "childMainAxisSize " + max2).initCause(e);
                        }
                    } else {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                } else {
                    str16 = str6;
                    i10 = i25;
                    str9 = str5;
                    str15 = str;
                    str17 = str7;
                    str13 = str21;
                    str14 = str2;
                    j6 = j19;
                    str11 = str19;
                    str12 = str20;
                    str10 = str22;
                    j5 = j17;
                    j4 = j18;
                }
                i29++;
                i30 = i2;
                j17 = j5;
                j18 = j4;
                str20 = str12;
                str19 = str11;
                str2 = str14;
                str21 = str13;
                str = str15;
                str5 = str9;
                long j23 = j6;
                str7 = str17;
                str6 = str16;
                str3 = str10;
                i25 = i10;
                j19 = j23;
            }
            rowColumnMeasurementHelper = this;
            long j24 = j19;
            i5 = (int) RangesKt.coerceIn(((long) i28) + j17, 0, ((long) Constraints.m6526getMaxWidthimpl(r2)) - j24);
            j2 = j24;
        }
        if (z) {
            rowColumnMeasurementHelper2 = rowColumnMeasurementHelper;
            i7 = 0;
            i6 = 0;
            int i31 = i2;
            for (int i32 = i; i32 < i31; i32++) {
                Placeable placeable2 = rowColumnMeasurementHelper2.placeables[i32];
                Intrinsics.checkNotNull(placeable2);
                CrossAxisAlignment crossAxisAlignment2 = RowColumnImplKt.getCrossAxisAlignment(rowColumnMeasurementHelper2.rowColumnParentData[i32]);
                Integer calculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment2 != null ? crossAxisAlignment2.calculateAlignmentLinePosition$foundation_layout_release(placeable2) : null;
                if (calculateAlignmentLinePosition$foundation_layout_release != null) {
                    Number number = calculateAlignmentLinePosition$foundation_layout_release;
                    int intValue = number.intValue();
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = 0;
                    }
                    i7 = Math.max(i7, intValue);
                    int crossAxisSize2 = rowColumnMeasurementHelper2.crossAxisSize(placeable2);
                    int intValue2 = number.intValue();
                    if (intValue2 == Integer.MIN_VALUE) {
                        intValue2 = rowColumnMeasurementHelper2.crossAxisSize(placeable2);
                    }
                    i6 = Math.max(i6, crossAxisSize2 - intValue2);
                }
            }
        } else {
            rowColumnMeasurementHelper2 = rowColumnMeasurementHelper;
            int i33 = i2;
            i7 = 0;
            i6 = 0;
        }
        int max3 = Math.max((int) RangesKt.coerceAtLeast(j2 + ((long) i5), 0), Constraints.m6528getMinWidthimpl(r2));
        if (Constraints.m6525getMaxHeightimpl(r2) == Integer.MAX_VALUE || rowColumnMeasurementHelper2.crossAxisSize != SizeMode.Expand) {
            i8 = Math.max(i4, Math.max(Constraints.m6527getMinHeightimpl(r2), i6 + i7));
        } else {
            i8 = Constraints.m6525getMaxHeightimpl(r2);
        }
        int i34 = i8;
        int i35 = i3;
        int[] iArr = new int[i35];
        for (int i36 = 0; i36 < i35; i36++) {
            iArr[i36] = 0;
        }
        int[] iArr2 = new int[i35];
        for (int i37 = 0; i37 < i35; i37++) {
            Placeable placeable3 = rowColumnMeasurementHelper2.placeables[i37 + i];
            Intrinsics.checkNotNull(placeable3);
            iArr2[i37] = rowColumnMeasurementHelper2.mainAxisSize(placeable3);
        }
        return new RowColumnMeasureHelperResult(i34, max3, i, i2, i7, rowColumnMeasurementHelper2.mainAxisPositions(max3, iArr2, iArr, measureScope));
    }

    private final int[] mainAxisPositions(int i, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        if (this.orientation == LayoutOrientation.Vertical) {
            Arrangement.Vertical vertical = this.verticalArrangement;
            if (vertical != null) {
                vertical.arrange(measureScope, i, iArr, iArr2);
            } else {
                throw new IllegalArgumentException("null verticalArrangement in Column".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.horizontalArrangement;
            if (horizontal != null) {
                horizontal.arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
            } else {
                throw new IllegalArgumentException("null horizontalArrangement in Row".toString());
            }
        }
        return iArr2;
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData rowColumnParentData2, int i, LayoutDirection layoutDirection, int i2) {
        CrossAxisAlignment crossAxisAlignment2;
        if (rowColumnParentData2 == null || (crossAxisAlignment2 = rowColumnParentData2.getCrossAxisAlignment()) == null) {
            crossAxisAlignment2 = this.crossAxisAlignment;
        }
        int crossAxisSize2 = i - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection = LayoutDirection.Ltr;
        }
        return crossAxisAlignment2.align$foundation_layout_release(crossAxisSize2, layoutDirection, placeable, i2);
    }

    public final void placeHelper(Placeable.PlacementScope placementScope, RowColumnMeasureHelperResult rowColumnMeasureHelperResult, int i, LayoutDirection layoutDirection) {
        int endIndex = rowColumnMeasureHelperResult.getEndIndex();
        for (int startIndex = rowColumnMeasureHelperResult.getStartIndex(); startIndex < endIndex; startIndex++) {
            Placeable placeable = this.placeables[startIndex];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = rowColumnMeasureHelperResult.getMainAxisPositions();
            Object parentData = this.measurables.get(startIndex).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, rowColumnMeasureHelperResult.getCrossAxisSize(), layoutDirection, rowColumnMeasureHelperResult.getBeforeCrossAxisAlignmentLine()) + i;
            if (this.orientation == LayoutOrientation.Horizontal) {
                Placeable.PlacementScope.place$default(placementScope, placeable, mainAxisPositions[startIndex - rowColumnMeasureHelperResult.getStartIndex()], crossAxisPosition, 0.0f, 4, (Object) null);
            } else {
                Placeable.PlacementScope.place$default(placementScope, placeable, crossAxisPosition, mainAxisPositions[startIndex - rowColumnMeasureHelperResult.getStartIndex()], 0.0f, 4, (Object) null);
            }
        }
    }
}
