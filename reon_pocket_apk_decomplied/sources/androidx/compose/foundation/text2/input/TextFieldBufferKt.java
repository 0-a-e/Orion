package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.TextFieldBuffer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a{\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0006H\b\u001a\u001c\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0007\u001aE\u0010\u0012\u001a\u00020\u0001*\u00020\u001326\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00010\u0015H\b\u001aE\u0010\u0019\u001a\u00020\u0001*\u00020\u001326\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00010\u0015H\b\u001a\u001c\u0010\u001a\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0007\u001a\f\u0010\u001e\u001a\u00020\u0001*\u00020\u000fH\u0007\u001a\f\u0010\u001f\u001a\u00020\u0001*\u00020\u000fH\u0007¨\u0006 "}, d2 = {"findCommonPrefixAndSuffix", "", "a", "", "b", "onFound", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "aPrefixStart", "aSuffixStart", "bPrefixStart", "bSuffixStart", "delete", "Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "start", "end", "forEachChange", "Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/text/TextRange;", "range", "originalRange", "forEachChangeReversed", "insert", "index", "text", "", "placeCursorAtEnd", "selectAll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldBuffer.kt */
public final class TextFieldBufferKt {
    public static final void insert(TextFieldBuffer textFieldBuffer, int i, String str) {
        textFieldBuffer.replace(i, i, str);
    }

    public static final void delete(TextFieldBuffer textFieldBuffer, int i, int i2) {
        textFieldBuffer.replace(i, i2, "");
    }

    public static final void placeCursorAtEnd(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.placeCursorBeforeCharAt(textFieldBuffer.getLength());
    }

    public static final void selectAll(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.m1340selectCharsIn5zctL8(TextRangeKt.TextRange(0, textFieldBuffer.getLength()));
    }

    public static final void forEachChange(TextFieldBuffer.ChangeList changeList, Function2<? super TextRange, ? super TextRange, Unit> function2) {
        for (int i = 0; i < changeList.getChangeCount(); i++) {
            function2.invoke(TextRange.m6030boximpl(changeList.m1344getRangejx7JFs(i)), TextRange.m6030boximpl(changeList.m1343getOriginalRangejx7JFs(i)));
        }
    }

    public static final void forEachChangeReversed(TextFieldBuffer.ChangeList changeList, Function2<? super TextRange, ? super TextRange, Unit> function2) {
        for (int changeCount = changeList.getChangeCount() - 1; changeCount >= 0; changeCount--) {
            function2.invoke(TextRange.m6030boximpl(changeList.m1344getRangejx7JFs(changeCount)), TextRange.m6030boximpl(changeList.m1343getOriginalRangejx7JFs(changeCount)));
        }
    }

    public static final void findCommonPrefixAndSuffix(CharSequence charSequence, CharSequence charSequence2, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        int i;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = 0;
        if (charSequence.length() <= 0 || charSequence2.length() <= 0) {
            i = 0;
        } else {
            int i3 = 0;
            i = 0;
            boolean z = false;
            while (true) {
                if (i2 == 0) {
                    if (charSequence.charAt(i3) == charSequence2.charAt(i)) {
                        i3++;
                        i++;
                    } else {
                        i2 = 1;
                    }
                }
                if (!z) {
                    if (charSequence.charAt(length - 1) == charSequence2.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z = true;
                    }
                }
                if (i3 >= length || i >= length2 || (i2 != 0 && z)) {
                    i2 = i3;
                }
            }
            i2 = i3;
        }
        if (i2 < length || i < length2) {
            function4.invoke(Integer.valueOf(i2), Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(length2));
        }
    }
}
