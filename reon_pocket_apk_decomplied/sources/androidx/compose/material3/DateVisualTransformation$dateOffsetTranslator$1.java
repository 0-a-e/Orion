package androidx.compose.material3;

import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1", "Landroidx/compose/ui/text/input/OffsetMapping;", "originalToTransformed", "", "offset", "transformedToOriginal", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
public final class DateVisualTransformation$dateOffsetTranslator$1 implements OffsetMapping {
    final /* synthetic */ DateVisualTransformation this$0;

    DateVisualTransformation$dateOffsetTranslator$1(DateVisualTransformation dateVisualTransformation) {
        this.this$0 = dateVisualTransformation;
    }

    public int originalToTransformed(int i) {
        if (i < this.this$0.firstDelimiterOffset) {
            return i;
        }
        if (i < this.this$0.secondDelimiterOffset) {
            return i + 1;
        }
        if (i > this.this$0.dateFormatLength) {
            i = this.this$0.dateFormatLength;
        }
        return i + 2;
    }

    public int transformedToOriginal(int i) {
        if (i <= this.this$0.firstDelimiterOffset - 1) {
            return i;
        }
        if (i <= this.this$0.secondDelimiterOffset - 1) {
            return i - 1;
        }
        if (i <= this.this$0.dateFormatLength + 1) {
            return i - 2;
        }
        return this.this$0.dateFormatLength;
    }
}
