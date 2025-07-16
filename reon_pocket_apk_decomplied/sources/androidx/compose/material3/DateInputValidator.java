package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J.\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060 j\u0002`!ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "currentStartDateMillis", "", "currentEndDateMillis", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCurrentEndDateMillis$material3_release", "()Ljava/lang/Long;", "setCurrentEndDateMillis$material3_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCurrentStartDateMillis$material3_release", "setCurrentStartDateMillis$material3_release", "validate", "dateToValidate", "Landroidx/compose/material3/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
public final class DateInputValidator {
    public static final int $stable = 0;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public DateInputValidator(IntRange intRange, SelectableDates selectableDates2, DateInputFormat dateInputFormat2, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l2) {
        this.yearRange = intRange;
        this.selectableDates = selectableDates2;
        this.dateInputFormat = dateInputFormat2;
        this.dateFormatter = datePickerFormatter;
        this.errorDatePattern = str;
        this.errorDateOutOfYearRange = str2;
        this.errorInvalidNotAllowed = str3;
        this.errorInvalidRangeInput = str4;
        this.currentStartDateMillis = l;
        this.currentEndDateMillis = l2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DateInputValidator(kotlin.ranges.IntRange r15, androidx.compose.material3.SelectableDates r16, androidx.compose.material3.DateInputFormat r17, androidx.compose.material3.DatePickerFormatter r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.Long r23, java.lang.Long r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r12 = r2
            goto L_0x000b
        L_0x0009:
            r12 = r23
        L_0x000b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0011
            r13 = r2
            goto L_0x0013
        L_0x0011:
            r13 = r24
        L_0x0013:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.<init>(kotlin.ranges.IntRange, androidx.compose.material3.SelectableDates, androidx.compose.material3.DateInputFormat, androidx.compose.material3.DatePickerFormatter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getCurrentStartDateMillis$material3_release() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentStartDateMillis$material3_release(Long l) {
        this.currentStartDateMillis = l;
    }

    public final Long getCurrentEndDateMillis$material3_release() {
        return this.currentEndDateMillis;
    }

    public final void setCurrentEndDateMillis$material3_release(Long l) {
        this.currentEndDateMillis = l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009b, code lost:
        if (r0 < (r12 != null ? r12.longValue() : Long.MAX_VALUE)) goto L_0x009d;
     */
    /* renamed from: validate-XivgLIo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m1735validateXivgLIo(androidx.compose.material3.CalendarDate r10, int r11, java.util.Locale r12) {
        /*
            r9 = this;
            java.lang.String r0 = "format(this, *args)"
            r1 = 0
            r2 = 1
            if (r10 != 0) goto L_0x002a
            java.lang.String r10 = r9.errorDatePattern
            androidx.compose.material3.DateInputFormat r11 = r9.dateInputFormat
            java.lang.String r11 = r11.getPatternWithDelimiters()
            java.util.Locale r12 = java.util.Locale.ROOT
            java.lang.String r11 = r11.toUpperCase(r12)
            java.lang.String r12 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r12[r1] = r11
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r12, r2)
            java.lang.String r10 = java.lang.String.format(r10, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            return r10
        L_0x002a:
            kotlin.ranges.IntRange r3 = r9.yearRange
            int r4 = r10.getYear()
            boolean r3 = r3.contains((int) r4)
            if (r3 != 0) goto L_0x0064
            java.lang.String r10 = r9.errorDateOutOfYearRange
            kotlin.ranges.IntRange r11 = r9.yearRange
            int r3 = r11.getFirst()
            r7 = 7
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r11 = androidx.compose.material3.ActualJvm_jvmKt.toLocalString$default(r3, r4, r5, r6, r7, r8)
            kotlin.ranges.IntRange r12 = r9.yearRange
            int r3 = r12.getLast()
            java.lang.String r12 = androidx.compose.material3.ActualJvm_jvmKt.toLocalString$default(r3, r4, r5, r6, r7, r8)
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r1] = r11
            r4[r2] = r12
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r4, r3)
            java.lang.String r10 = java.lang.String.format(r10, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            return r10
        L_0x0064:
            androidx.compose.material3.SelectableDates r3 = r9.selectableDates
            int r4 = r10.getYear()
            boolean r4 = r3.isSelectableYear(r4)
            if (r4 == 0) goto L_0x00c2
            long r4 = r10.getUtcTimeMillis()
            boolean r3 = r3.isSelectableDate(r4)
            if (r3 != 0) goto L_0x007b
            goto L_0x00c2
        L_0x007b:
            androidx.compose.material3.InputIdentifier$Companion r12 = androidx.compose.material3.InputIdentifier.Companion
            int r12 = r12.m1926getStartDateInputJ2x2o4M()
            boolean r12 = androidx.compose.material3.InputIdentifier.m1920equalsimpl0(r11, r12)
            if (r12 == 0) goto L_0x009d
            long r0 = r10.getUtcTimeMillis()
            java.lang.Long r12 = r9.currentEndDateMillis
            if (r12 == 0) goto L_0x0094
            long r2 = r12.longValue()
            goto L_0x0099
        L_0x0094:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0099:
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x00bc
        L_0x009d:
            androidx.compose.material3.InputIdentifier$Companion r12 = androidx.compose.material3.InputIdentifier.Companion
            int r12 = r12.m1924getEndDateInputJ2x2o4M()
            boolean r11 = androidx.compose.material3.InputIdentifier.m1920equalsimpl0(r11, r12)
            if (r11 == 0) goto L_0x00bf
            long r10 = r10.getUtcTimeMillis()
            java.lang.Long r12 = r9.currentStartDateMillis
            if (r12 == 0) goto L_0x00b6
            long r0 = r12.longValue()
            goto L_0x00b8
        L_0x00b6:
            r0 = -9223372036854775808
        L_0x00b8:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 >= 0) goto L_0x00bf
        L_0x00bc:
            java.lang.String r10 = r9.errorInvalidRangeInput
            return r10
        L_0x00bf:
            java.lang.String r10 = ""
            return r10
        L_0x00c2:
            java.lang.String r11 = r9.errorInvalidNotAllowed
            androidx.compose.material3.DatePickerFormatter r3 = r9.dateFormatter
            long r4 = r10.getUtcTimeMillis()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r7 = 4
            r8 = 0
            r6 = 0
            r5 = r12
            java.lang.String r10 = androidx.compose.material3.DatePickerFormatter.CC.formatDate$default(r3, r4, r5, r6, r7, r8)
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r12[r1] = r10
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r12, r2)
            java.lang.String r10 = java.lang.String.format(r11, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m1735validateXivgLIo(androidx.compose.material3.CalendarDate, int, java.util.Locale):java.lang.String");
    }
}
