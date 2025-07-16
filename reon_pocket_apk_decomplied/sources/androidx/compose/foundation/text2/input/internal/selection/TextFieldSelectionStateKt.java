package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002\u001a\u0016\u0010\b\u001a\u00020\t*\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"DEBUG", "", "DEBUG_TAG", "", "logDebug", "", "text", "Lkotlin/Function0;", "reverse", "Landroidx/compose/ui/text/TextRange;", "reverse-5zc-tL8", "(J)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
public final class TextFieldSelectionStateKt {
    private static final boolean DEBUG = false;
    private static final String DEBUG_TAG = "TextFieldSelectionState";

    /* access modifiers changed from: private */
    public static final void logDebug(Function0<String> function0) {
    }

    /* access modifiers changed from: private */
    /* renamed from: reverse-5zc-tL8  reason: not valid java name */
    public static final long m1474reverse5zctL8(long j) {
        return TextRangeKt.TextRange(TextRange.m6037getEndimpl(j), TextRange.m6042getStartimpl(j));
    }
}
