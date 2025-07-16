package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/input/PasswordVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "mask", "", "(C)V", "getMask", "()C", "equals", "", "other", "", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "hashCode", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VisualTransformation.kt */
public final class PasswordVisualTransformation implements VisualTransformation {
    public static final int $stable = 0;
    private final char mask;

    public PasswordVisualTransformation() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public PasswordVisualTransformation(char c) {
        this.mask = c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PasswordVisualTransformation(char c, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Typography.bullet : c);
    }

    public final char getMask() {
        return this.mask;
    }

    public TransformedText filter(AnnotatedString annotatedString) {
        return new TransformedText(new AnnotatedString(StringsKt.repeat(String.valueOf(this.mask), annotatedString.getText().length()), (List) null, (List) null, 6, (DefaultConstructorMarker) null), OffsetMapping.Companion.getIdentity());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PasswordVisualTransformation) && this.mask == ((PasswordVisualTransformation) obj).mask;
    }

    public int hashCode() {
        return this.mask;
    }
}
