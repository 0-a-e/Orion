package androidx.compose.material3;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\b\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/DateVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "(Landroidx/compose/material3/DateInputFormat;)V", "dateFormatLength", "", "dateOffsetTranslator", "androidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1", "Landroidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1;", "firstDelimiterOffset", "secondDelimiterOffset", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateVisualTransformation implements VisualTransformation {
    /* access modifiers changed from: private */
    public final int dateFormatLength;
    private final DateInputFormat dateInputFormat;
    private final DateVisualTransformation$dateOffsetTranslator$1 dateOffsetTranslator = new DateVisualTransformation$dateOffsetTranslator$1(this);
    /* access modifiers changed from: private */
    public final int firstDelimiterOffset;
    /* access modifiers changed from: private */
    public final int secondDelimiterOffset;

    public DateVisualTransformation(DateInputFormat dateInputFormat2) {
        this.dateInputFormat = dateInputFormat2;
        this.firstDelimiterOffset = StringsKt.indexOf$default((CharSequence) dateInputFormat2.getPatternWithDelimiters(), dateInputFormat2.getDelimiter(), 0, false, 6, (Object) null);
        this.secondDelimiterOffset = StringsKt.lastIndexOf$default((CharSequence) dateInputFormat2.getPatternWithDelimiters(), dateInputFormat2.getDelimiter(), 0, false, 6, (Object) null);
        this.dateFormatLength = dateInputFormat2.getPatternWithoutDelimiters().length();
    }

    public TransformedText filter(AnnotatedString annotatedString) {
        String str;
        int i = 0;
        if (annotatedString.getText().length() > this.dateFormatLength) {
            str = StringsKt.substring(annotatedString.getText(), RangesKt.until(0, this.dateFormatLength));
        } else {
            str = annotatedString.getText();
        }
        CharSequence charSequence = str;
        String str2 = "";
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            String str3 = str2 + charSequence.charAt(i);
            if (i3 == this.firstDelimiterOffset || i2 + 2 == this.secondDelimiterOffset) {
                str2 = str3 + this.dateInputFormat.getDelimiter();
            } else {
                str2 = str3;
            }
            i++;
            i2 = i3;
        }
        return new TransformedText(new AnnotatedString(str2, (List) null, (List) null, 6, (DefaultConstructorMarker) null), this.dateOffsetTranslator);
    }
}
