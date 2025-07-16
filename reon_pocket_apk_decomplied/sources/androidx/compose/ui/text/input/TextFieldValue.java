package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007B#\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J.\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/String;", "copy", "copy-3r_uNRQ", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldValue.kt */
public final class TextFieldValue {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<TextFieldValue, Object> Saver = SaverKt.Saver(TextFieldValue$Companion$Saver$1.INSTANCE, TextFieldValue$Companion$Saver$2.INSTANCE);
    private final AnnotatedString annotatedString;
    private final TextRange composition;
    private final long selection;

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString2, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, j, textRange);
    }

    public /* synthetic */ TextFieldValue(String str, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, textRange);
    }

    private TextFieldValue(AnnotatedString annotatedString2, long j, TextRange textRange) {
        this.annotatedString = annotatedString2;
        this.selection = TextRangeKt.m6048coerceIn8ffj60Q(j, 0, getText().length());
        this.composition = textRange != null ? TextRange.m6030boximpl(TextRangeKt.m6048coerceIn8ffj60Q(textRange.m6046unboximpl(), 0, getText().length())) : null;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString2, long j, TextRange textRange, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, (i & 2) != 0 ? TextRange.Companion.m6047getZerod9O1mEE() : j, (i & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldValue(String str, long j, TextRange textRange, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? TextRange.Companion.m6047getZerod9O1mEE() : j, (i & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    private TextFieldValue(String str, long j, TextRange textRange) {
        this(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), j, textRange, (DefaultConstructorMarker) null);
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m6299getSelectiond9O1mEE() {
        return this.selection;
    }

    /* renamed from: getComposition-MzsxiRA  reason: not valid java name */
    public final TextRange m6298getCompositionMzsxiRA() {
        return this.composition;
    }

    /* renamed from: copy-3r_uNRQ$default  reason: not valid java name */
    public static /* synthetic */ TextFieldValue m6294copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString2, long j, TextRange textRange, int i, Object obj) {
        if ((i & 1) != 0) {
            annotatedString2 = textFieldValue.annotatedString;
        }
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        if ((i & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m6296copy3r_uNRQ(annotatedString2, j, textRange);
    }

    /* renamed from: copy-3r_uNRQ  reason: not valid java name */
    public final TextFieldValue m6296copy3r_uNRQ(AnnotatedString annotatedString2, long j, TextRange textRange) {
        return new TextFieldValue(annotatedString2, j, textRange, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-3r_uNRQ$default  reason: not valid java name */
    public static /* synthetic */ TextFieldValue m6295copy3r_uNRQ$default(TextFieldValue textFieldValue, String str, long j, TextRange textRange, int i, Object obj) {
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        if ((i & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m6297copy3r_uNRQ(str, j, textRange);
    }

    /* renamed from: copy-3r_uNRQ  reason: not valid java name */
    public final TextFieldValue m6297copy3r_uNRQ(String str, long j, TextRange textRange) {
        return new TextFieldValue(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), j, textRange, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        if (!TextRange.m6035equalsimpl0(this.selection, textFieldValue.selection) || !Intrinsics.areEqual((Object) this.composition, (Object) textFieldValue.composition) || !Intrinsics.areEqual((Object) this.annotatedString, (Object) textFieldValue.annotatedString)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = ((this.annotatedString.hashCode() * 31) + TextRange.m6043hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        return hashCode + (textRange != null ? TextRange.m6043hashCodeimpl(textRange.m6046unboximpl()) : 0);
    }

    public String toString() {
        return "TextFieldValue(text='" + this.annotatedString + "', selection=" + TextRange.m6045toStringimpl(this.selection) + ", composition=" + this.composition + ')';
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldValue.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TextFieldValue, Object> getSaver() {
            return TextFieldValue.Saver;
        }
    }
}
