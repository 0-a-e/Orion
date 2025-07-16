package androidx.compose.foundation.text;

import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "getEmptyTextReplacement", "()Ljava/lang/String;", "computeSizeForDefaultText", "Landroidx/compose/ui/unit/IntSize;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "text", "maxLines", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/lang/String;I)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDelegate.kt */
public final class TextFieldDelegateKt {
    public static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement = StringsKt.repeat("H", 10);

    public static final String getEmptyTextReplacement() {
        return EmptyTextReplacement;
    }

    public static /* synthetic */ long computeSizeForDefaultText$default(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = EmptyTextReplacement;
        }
        if ((i2 & 16) != 0) {
            i = 1;
        }
        return computeSizeForDefaultText(textStyle, density, resolver, str, i);
    }

    public static final long computeSizeForDefaultText(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i) {
        String str2 = str;
        TextStyle textStyle2 = textStyle;
        Paragraph r0 = ParagraphKt.m5934ParagraphUdtVg6A$default(str2, textStyle2, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null), density, resolver, CollectionsKt.emptyList(), (List) null, i, false, 64, (Object) null);
        return IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(r0.getMinIntrinsicWidth()), TextDelegateKt.ceilToIntPx(r0.getHeight()));
    }
}
