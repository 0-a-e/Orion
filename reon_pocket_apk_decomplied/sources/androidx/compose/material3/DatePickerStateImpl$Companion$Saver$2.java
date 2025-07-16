package androidx.compose.material3;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/material3/DatePickerStateImpl;", "value", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerStateImpl$Companion$Saver$2 extends Lambda implements Function1<List, DatePickerStateImpl> {
    final /* synthetic */ Locale $locale;
    final /* synthetic */ SelectableDates $selectableDates;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerStateImpl$Companion$Saver$2(SelectableDates selectableDates, Locale locale) {
        super(1);
        this.$selectableDates = selectableDates;
        this.$locale = locale;
    }

    public final DatePickerStateImpl invoke(List<? extends Object> list) {
        Object obj = list.get(2);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        Object obj2 = list.get(3);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        IntRange intRange = new IntRange(intValue, ((Integer) obj2).intValue());
        Object obj3 = list.get(4);
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
        return new DatePickerStateImpl((Long) list.get(0), (Long) list.get(1), intRange, DisplayMode.m1807constructorimpl(((Integer) obj3).intValue()), this.$selectableDates, this.$locale, (DefaultConstructorMarker) null);
    }
}
