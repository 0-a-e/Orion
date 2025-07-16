package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    /* access modifiers changed from: private */
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, float f, PaddingValues paddingValues2) {
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2453measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Measurable measurable;
        Object obj5;
        Object obj6;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        int r13 = measureScope2.m6545roundToPx0680j_4(this.paddingValues.m687calculateTopPaddingD9Ej5fM());
        int r1 = measureScope2.m6545roundToPx0680j_4(this.paddingValues.m684calculateBottomPaddingD9Ej5fM());
        long r2 = Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) TextFieldImplKt.LeadingId)) {
                break;
            }
            i++;
        }
        Measurable measurable2 = (Measurable) obj;
        Placeable r6 = measurable2 != null ? measurable2.m5368measureBRTryo0(r2) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(r6);
        int max = Math.max(0, TextFieldImplKt.heightOrZero(r6));
        int size2 = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), (Object) TextFieldImplKt.TrailingId)) {
                break;
            }
            i2++;
        }
        Measurable measurable3 = (Measurable) obj2;
        Placeable r9 = measurable3 != null ? measurable3.m5368measureBRTryo0(ConstraintsKt.m6543offsetNN6EwU$default(r2, -widthOrZero, 0, 2, (Object) null)) : null;
        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(r9);
        int max2 = Math.max(max, TextFieldImplKt.heightOrZero(r9));
        int size3 = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list2.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), (Object) TextFieldImplKt.PrefixId)) {
                break;
            }
            i3++;
        }
        Measurable measurable4 = (Measurable) obj3;
        Placeable r8 = measurable4 != null ? measurable4.m5368measureBRTryo0(ConstraintsKt.m6543offsetNN6EwU$default(r2, -widthOrZero2, 0, 2, (Object) null)) : null;
        int widthOrZero3 = widthOrZero2 + TextFieldImplKt.widthOrZero(r8);
        int max3 = Math.max(max2, TextFieldImplKt.heightOrZero(r8));
        int size4 = list.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list2.get(i4);
            int i5 = size4;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), (Object) TextFieldImplKt.SuffixId)) {
                break;
            }
            i4++;
            size4 = i5;
        }
        Measurable measurable5 = (Measurable) obj4;
        Placeable r10 = measurable5 != null ? measurable5.m5368measureBRTryo0(ConstraintsKt.m6543offsetNN6EwU$default(r2, -widthOrZero3, 0, 2, (Object) null)) : null;
        int widthOrZero4 = widthOrZero3 + TextFieldImplKt.widthOrZero(r10);
        int max4 = Math.max(max3, TextFieldImplKt.heightOrZero(r10));
        int i6 = -widthOrZero4;
        long r11 = ConstraintsKt.m6542offsetNN6EwU(r2, i6, -r1);
        int size5 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size5) {
                measurable = null;
                break;
            }
            Object obj7 = list2.get(i7);
            int i8 = size5;
            Object obj8 = obj7;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj7), (Object) TextFieldImplKt.LabelId)) {
                measurable = obj8;
                break;
            }
            i7++;
            size5 = i8;
        }
        Measurable measurable6 = measurable;
        Placeable r7 = measurable6 != null ? measurable6.m5368measureBRTryo0(r11) : null;
        int size6 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size6) {
                obj5 = null;
                break;
            }
            obj5 = list2.get(i9);
            int i10 = size6;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj5), (Object) TextFieldImplKt.SupportingId)) {
                break;
            }
            i9++;
            size6 = i10;
        }
        Measurable measurable7 = (Measurable) obj5;
        int minIntrinsicHeight = measurable7 != null ? measurable7.minIntrinsicHeight(Constraints.m6528getMinWidthimpl(j)) : 0;
        int heightOrZero = TextFieldImplKt.heightOrZero(r7) + r13;
        Measurable measurable8 = measurable7;
        int i11 = r13;
        long r132 = ConstraintsKt.m6542offsetNN6EwU(Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null), i6, ((-heightOrZero) - r1) - minIntrinsicHeight);
        int size7 = list.size();
        int i12 = 0;
        while (i12 < size7) {
            int i13 = size7;
            Measurable measurable9 = (Measurable) list2.get(i12);
            int i14 = i12;
            String str = "Collection contains no element matching the predicate.";
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable9), (Object) TextFieldImplKt.TextFieldId)) {
                Placeable r4 = measurable9.m5368measureBRTryo0(r132);
                long r133 = Constraints.m6517copyZbe2FdA$default(r132, 0, 0, 0, 0, 14, (Object) null);
                int size8 = list.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size8) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list2.get(i15);
                    int i16 = size8;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj6), (Object) TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i15++;
                    list2 = list;
                    size8 = i16;
                }
                Measurable measurable10 = (Measurable) obj6;
                Placeable r112 = measurable10 != null ? measurable10.m5368measureBRTryo0(r133) : null;
                int max5 = Math.max(max4, Math.max(TextFieldImplKt.heightOrZero(r4), TextFieldImplKt.heightOrZero(r112)) + heightOrZero + r1);
                int r15 = TextFieldKt.m2452calculateWidthyeHjK3Y(TextFieldImplKt.widthOrZero(r6), TextFieldImplKt.widthOrZero(r9), TextFieldImplKt.widthOrZero(r8), TextFieldImplKt.widthOrZero(r10), r4.getWidth(), TextFieldImplKt.widthOrZero(r7), TextFieldImplKt.widthOrZero(r112), j);
                Placeable r22 = measurable8 != null ? measurable8.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(ConstraintsKt.m6543offsetNN6EwU$default(r2, 0, -max5, 1, (Object) null), 0, r15, 0, 0, 9, (Object) null)) : null;
                int heightOrZero2 = TextFieldImplKt.heightOrZero(r22);
                int r16 = TextFieldKt.m2451calculateHeightmKXJcVc(r4.getHeight(), TextFieldImplKt.heightOrZero(r7), TextFieldImplKt.heightOrZero(r6), TextFieldImplKt.heightOrZero(r9), TextFieldImplKt.heightOrZero(r8), TextFieldImplKt.heightOrZero(r10), TextFieldImplKt.heightOrZero(r112), TextFieldImplKt.heightOrZero(r22), this.animationProgress, j, measureScope.getDensity(), this.paddingValues);
                int i17 = r16 - heightOrZero2;
                int size9 = list.size();
                int i18 = 0;
                while (i18 < size9) {
                    Measurable measurable11 = (Measurable) list.get(i18);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable11), (Object) TextFieldImplKt.ContainerId)) {
                        return MeasureScope.CC.layout$default(measureScope, r15, r16, (Map) null, new TextFieldMeasurePolicy$measure$1(r7, r15, r16, r4, r112, r6, r9, r8, r10, measurable11.m5368measureBRTryo0(ConstraintsKt.Constraints(r15 != Integer.MAX_VALUE ? r15 : 0, r15, i17 != Integer.MAX_VALUE ? i17 : 0, i17)), r22, this, i11, measureScope), 4, (Object) null);
                    }
                    i18++;
                }
                throw new NoSuchElementException(str);
            }
            Measurable measurable12 = measurable8;
            i12 = i14 + 1;
            size7 = i13;
            list2 = list;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, TextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, TextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(list, i, TextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(list, i, TextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        List<? extends IntrinsicMeasurable> list2 = list;
        Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22 = function2;
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj6 = list2.get(i3);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj6), (Object) TextFieldImplKt.TextFieldId)) {
                int intValue = function22.invoke(obj6, Integer.valueOf(i)).intValue();
                int size2 = list.size();
                int i4 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i4 >= size2) {
                        obj = null;
                        break;
                    }
                    obj = list2.get(i4);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), (Object) TextFieldImplKt.LabelId)) {
                        break;
                    }
                    i4++;
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj;
                int intValue2 = intrinsicMeasurable2 != null ? function22.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue() : 0;
                int size3 = list.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size3) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list2.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), (Object) TextFieldImplKt.TrailingId)) {
                        break;
                    }
                    i5++;
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj2;
                int intValue3 = intrinsicMeasurable3 != null ? function22.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue() : 0;
                int size4 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size4) {
                        obj3 = null;
                        break;
                    }
                    obj3 = list2.get(i6);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), (Object) TextFieldImplKt.PrefixId)) {
                        break;
                    }
                    i6++;
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj3;
                int intValue4 = intrinsicMeasurable4 != null ? function22.invoke(intrinsicMeasurable4, Integer.valueOf(i)).intValue() : 0;
                int size5 = list.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size5) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list2.get(i7);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), (Object) TextFieldImplKt.SuffixId)) {
                        break;
                    }
                    i7++;
                }
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) obj4;
                int intValue5 = intrinsicMeasurable5 != null ? function22.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue() : 0;
                int size6 = list.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size6) {
                        obj5 = null;
                        break;
                    }
                    obj5 = list2.get(i8);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), (Object) TextFieldImplKt.LeadingId)) {
                        break;
                    }
                    i8++;
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj5;
                int intValue6 = intrinsicMeasurable6 != null ? function22.invoke(intrinsicMeasurable6, Integer.valueOf(i)).intValue() : 0;
                int size7 = list.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size7) {
                        break;
                    }
                    Object obj7 = list2.get(i9);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj7), (Object) TextFieldImplKt.PlaceholderId)) {
                        intrinsicMeasurable = obj7;
                        break;
                    }
                    i9++;
                }
                IntrinsicMeasurable intrinsicMeasurable7 = intrinsicMeasurable;
                if (intrinsicMeasurable7 != null) {
                    i2 = function22.invoke(intrinsicMeasurable7, Integer.valueOf(i)).intValue();
                }
                return TextFieldKt.m2452calculateWidthyeHjK3Y(intValue6, intValue3, intValue4, intValue5, intValue, intValue2, i2, TextFieldImplKt.getZeroConstraints());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        int i2;
        int i3;
        Object obj2;
        int i4;
        Object obj3;
        Object obj4;
        int i5;
        Object obj5;
        int i6;
        Object obj6;
        Object obj7;
        List<? extends IntrinsicMeasurable> list2 = list;
        Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22 = function2;
        int size = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i7);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), (Object) TextFieldImplKt.LeadingId)) {
                break;
            }
            i7++;
        }
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj;
        if (intrinsicMeasurable != null) {
            i3 = TextFieldKt.substractConstraintSafely(i, intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE));
            i2 = function22.invoke(intrinsicMeasurable, Integer.valueOf(i)).intValue();
        } else {
            i3 = i;
            i2 = 0;
        }
        int size2 = list.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i8);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), (Object) TextFieldImplKt.TrailingId)) {
                break;
            }
            i8++;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj2;
        if (intrinsicMeasurable2 != null) {
            i3 = TextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            i4 = function22.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue();
        } else {
            i4 = 0;
        }
        int size3 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list2.get(i9);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), (Object) TextFieldImplKt.LabelId)) {
                break;
            }
            i9++;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj3;
        int intValue = intrinsicMeasurable3 != null ? function22.invoke(intrinsicMeasurable3, Integer.valueOf(i3)).intValue() : 0;
        int size4 = list.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list2.get(i10);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), (Object) TextFieldImplKt.PrefixId)) {
                break;
            }
            i10++;
        }
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj4;
        if (intrinsicMeasurable4 != null) {
            int intValue2 = function22.invoke(intrinsicMeasurable4, Integer.valueOf(i3)).intValue();
            i3 = TextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable4.maxIntrinsicWidth(Integer.MAX_VALUE));
            i5 = intValue2;
        } else {
            i5 = 0;
        }
        int size5 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size5) {
                obj5 = null;
                break;
            }
            obj5 = list2.get(i11);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), (Object) TextFieldImplKt.SuffixId)) {
                break;
            }
            i11++;
        }
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) obj5;
        if (intrinsicMeasurable5 != null) {
            i6 = function22.invoke(intrinsicMeasurable5, Integer.valueOf(i3)).intValue();
            i3 = TextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable5.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i6 = 0;
        }
        int size6 = list.size();
        for (int i12 = 0; i12 < size6; i12++) {
            Object obj8 = list2.get(i12);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj8), (Object) TextFieldImplKt.TextFieldId)) {
                int intValue3 = function22.invoke(obj8, Integer.valueOf(i3)).intValue();
                int size7 = list.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size7) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list2.get(i13);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj6), (Object) TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i13++;
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj6;
                int intValue4 = intrinsicMeasurable6 != null ? function22.invoke(intrinsicMeasurable6, Integer.valueOf(i3)).intValue() : 0;
                int size8 = list.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list2.get(i14);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj7), (Object) TextFieldImplKt.SupportingId)) {
                        break;
                    }
                    i14++;
                }
                IntrinsicMeasurable intrinsicMeasurable7 = (IntrinsicMeasurable) obj7;
                return TextFieldKt.m2451calculateHeightmKXJcVc(intValue3, intValue, i2, i4, i5, i6, intValue4, intrinsicMeasurable7 != null ? function22.invoke(intrinsicMeasurable7, Integer.valueOf(i)).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
