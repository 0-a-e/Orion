package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
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
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J,\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    /* access modifiers changed from: private */
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> function1, boolean z, float f, PaddingValues paddingValues2) {
        this.onLabelMeasured = function1;
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2051measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Measurable measurable;
        Object obj5;
        Object obj6;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
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
        Placeable r4 = measurable2 != null ? measurable2.m5368measureBRTryo0(r2) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(r4);
        int max = Math.max(0, TextFieldImplKt.heightOrZero(r4));
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
        Placeable r5 = measurable4 != null ? measurable4.m5368measureBRTryo0(ConstraintsKt.m6543offsetNN6EwU$default(r2, -widthOrZero2, 0, 2, (Object) null)) : null;
        int widthOrZero3 = widthOrZero2 + TextFieldImplKt.widthOrZero(r5);
        int max3 = Math.max(max2, TextFieldImplKt.heightOrZero(r5));
        int size4 = list.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list2.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), (Object) TextFieldImplKt.SuffixId)) {
                break;
            }
            i4++;
        }
        Measurable measurable5 = (Measurable) obj4;
        Placeable r7 = measurable5 != null ? measurable5.m5368measureBRTryo0(ConstraintsKt.m6543offsetNN6EwU$default(r2, -widthOrZero3, 0, 2, (Object) null)) : null;
        int widthOrZero4 = widthOrZero3 + TextFieldImplKt.widthOrZero(r7);
        int max4 = Math.max(max3, TextFieldImplKt.heightOrZero(r7));
        int r10 = measureScope2.m6545roundToPx0680j_4(this.paddingValues.m685calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope2.m6545roundToPx0680j_4(this.paddingValues.m686calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int i5 = -widthOrZero4;
        int i6 = -r1;
        long r12 = ConstraintsKt.m6542offsetNN6EwU(r2, MathHelpersKt.lerp(i5 - r10, -r10, this.animationProgress), i6);
        int size5 = list.size();
        long j2 = r2;
        int i7 = 0;
        while (true) {
            if (i7 >= size5) {
                measurable = null;
                break;
            }
            Object obj7 = list2.get(i7);
            Object obj8 = obj7;
            int i8 = size5;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj7), (Object) TextFieldImplKt.LabelId)) {
                measurable = obj8;
                break;
            }
            i7++;
            size5 = i8;
        }
        Measurable measurable6 = measurable;
        Placeable r102 = measurable6 != null ? measurable6.m5368measureBRTryo0(r12) : null;
        if (r102 != null) {
            this.onLabelMeasured.invoke(Size.m3619boximpl(SizeKt.Size((float) r102.getWidth(), (float) r102.getHeight())));
        }
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
        int max5 = Math.max(TextFieldImplKt.heightOrZero(r102) / 2, measureScope2.m6545roundToPx0680j_4(this.paddingValues.m687calculateTopPaddingD9Ej5fM()));
        int i11 = (i6 - max5) - minIntrinsicHeight;
        Measurable measurable8 = measurable7;
        long r11 = Constraints.m6517copyZbe2FdA$default(ConstraintsKt.m6542offsetNN6EwU(j, i5, i11), 0, 0, 0, 0, 11, (Object) null);
        int size7 = list.size();
        int i12 = 0;
        while (i12 < size7) {
            int i13 = size7;
            Measurable measurable9 = (Measurable) list2.get(i12);
            int i14 = i12;
            String str = "Collection contains no element matching the predicate.";
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable9), (Object) TextFieldImplKt.TextFieldId)) {
                Placeable r13 = measurable9.m5368measureBRTryo0(r11);
                long r112 = Constraints.m6517copyZbe2FdA$default(r11, 0, 0, 0, 0, 14, (Object) null);
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
                Placeable r113 = measurable10 != null ? measurable10.m5368measureBRTryo0(r112) : null;
                int max6 = Math.max(max4, Math.max(TextFieldImplKt.heightOrZero(r13), TextFieldImplKt.heightOrZero(r113)) + max5 + r1);
                int r15 = OutlinedTextFieldKt.m2049calculateWidthDHJA7U0(TextFieldImplKt.widthOrZero(r4), TextFieldImplKt.widthOrZero(r9), TextFieldImplKt.widthOrZero(r5), TextFieldImplKt.widthOrZero(r7), r13.getWidth(), TextFieldImplKt.widthOrZero(r102), TextFieldImplKt.widthOrZero(r113), this.animationProgress, j, measureScope.getDensity(), this.paddingValues);
                Placeable r22 = measurable8 != null ? measurable8.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(ConstraintsKt.m6543offsetNN6EwU$default(j2, 0, -max6, 1, (Object) null), 0, r15, 0, 0, 9, (Object) null)) : null;
                int heightOrZero = TextFieldImplKt.heightOrZero(r22);
                int r16 = OutlinedTextFieldKt.m2048calculateHeightmKXJcVc(TextFieldImplKt.heightOrZero(r4), TextFieldImplKt.heightOrZero(r9), TextFieldImplKt.heightOrZero(r5), TextFieldImplKt.heightOrZero(r7), r13.getHeight(), TextFieldImplKt.heightOrZero(r102), TextFieldImplKt.heightOrZero(r113), TextFieldImplKt.heightOrZero(r22), this.animationProgress, j, measureScope.getDensity(), this.paddingValues);
                int i17 = r16 - heightOrZero;
                int size9 = list.size();
                for (int i18 = 0; i18 < size9; i18++) {
                    Measurable measurable11 = (Measurable) list.get(i18);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable11), (Object) TextFieldImplKt.ContainerId)) {
                        return MeasureScope.CC.layout$default(measureScope, r15, r16, (Map) null, new OutlinedTextFieldMeasurePolicy$measure$2(r16, r15, r4, r9, r5, r7, r13, r102, r113, measurable11.m5368measureBRTryo0(ConstraintsKt.Constraints(r15 != Integer.MAX_VALUE ? r15 : 0, r15, i17 != Integer.MAX_VALUE ? i17 : 0, i17)), r22, this, measureScope), 4, (Object) null);
                    }
                }
                throw new NoSuchElementException(str);
            }
            List<? extends Measurable> list3 = list2;
            i12 = i14 + 1;
            size7 = i13;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), (Object) TextFieldImplKt.LeadingId)) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), (Object) TextFieldImplKt.PrefixId)) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), (Object) TextFieldImplKt.SuffixId)) {
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
                return OutlinedTextFieldKt.m2049calculateWidthDHJA7U0(intValue4, intValue3, intValue5, intValue6, intValue, intValue2, i2, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
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
        IntrinsicMeasurable intrinsicMeasurable;
        List<? extends IntrinsicMeasurable> list2 = list;
        int i7 = i;
        Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22 = function2;
        int size = list.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i8);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), (Object) TextFieldImplKt.LeadingId)) {
                break;
            }
            i8++;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj;
        if (intrinsicMeasurable2 != null) {
            i3 = OutlinedTextFieldKt.substractConstraintSafely(i7, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            i2 = function22.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue();
        } else {
            i3 = i7;
            i2 = 0;
        }
        int size2 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i9);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), (Object) TextFieldImplKt.TrailingId)) {
                break;
            }
            i9++;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj2;
        if (intrinsicMeasurable3 != null) {
            i3 = OutlinedTextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable3.maxIntrinsicWidth(Integer.MAX_VALUE));
            i4 = function22.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue();
        } else {
            i4 = 0;
        }
        int size3 = list.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list2.get(i10);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), (Object) TextFieldImplKt.LabelId)) {
                break;
            }
            i10++;
        }
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj3;
        int intValue = intrinsicMeasurable4 != null ? function22.invoke(intrinsicMeasurable4, Integer.valueOf(MathHelpersKt.lerp(i3, i7, this.animationProgress))).intValue() : 0;
        int size4 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list2.get(i11);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), (Object) TextFieldImplKt.PrefixId)) {
                break;
            }
            i11++;
        }
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) obj4;
        if (intrinsicMeasurable5 != null) {
            i5 = function22.invoke(intrinsicMeasurable5, Integer.valueOf(i3)).intValue();
            i3 = OutlinedTextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable5.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i5 = 0;
        }
        int size5 = list.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size5) {
                obj5 = null;
                break;
            }
            obj5 = list2.get(i12);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), (Object) TextFieldImplKt.SuffixId)) {
                break;
            }
            i12++;
        }
        IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj5;
        if (intrinsicMeasurable6 != null) {
            int intValue2 = function22.invoke(intrinsicMeasurable6, Integer.valueOf(i3)).intValue();
            i3 = OutlinedTextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable6.maxIntrinsicWidth(Integer.MAX_VALUE));
            i6 = intValue2;
        } else {
            i6 = 0;
        }
        int size6 = list.size();
        for (int i13 = 0; i13 < size6; i13++) {
            Object obj7 = list2.get(i13);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj7), (Object) TextFieldImplKt.TextFieldId)) {
                int intValue3 = function22.invoke(obj7, Integer.valueOf(i3)).intValue();
                int size7 = list.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size7) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list2.get(i14);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj6), (Object) TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i14++;
                }
                IntrinsicMeasurable intrinsicMeasurable7 = (IntrinsicMeasurable) obj6;
                int intValue4 = intrinsicMeasurable7 != null ? function22.invoke(intrinsicMeasurable7, Integer.valueOf(i3)).intValue() : 0;
                int size8 = list.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size8) {
                        intrinsicMeasurable = null;
                        break;
                    }
                    Object obj8 = list2.get(i15);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj8), (Object) TextFieldImplKt.SupportingId)) {
                        intrinsicMeasurable = obj8;
                        break;
                    }
                    i15++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable;
                return OutlinedTextFieldKt.m2048calculateHeightmKXJcVc(i2, i4, i5, i6, intValue3, intValue, intValue4, intrinsicMeasurable8 != null ? function22.invoke(intrinsicMeasurable8, Integer.valueOf(i)).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
