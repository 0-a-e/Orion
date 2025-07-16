package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/ParagraphStyle;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$ParagraphStyleSaver$2 extends Lambda implements Function1<Object, ParagraphStyle> {
    public static final SaversKt$ParagraphStyleSaver$2 INSTANCE = new SaversKt$ParagraphStyleSaver$2();

    SaversKt$ParagraphStyleSaver$2() {
        super(1);
    }

    public final ParagraphStyle invoke(Object obj) {
        TextAlign textAlign;
        TextDirection textDirection;
        TextUnit textUnit;
        TextIndent textIndent;
        Object obj2 = obj;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj2;
        Object obj3 = list.get(0);
        if (obj3 != null) {
            textAlign = (TextAlign) obj3;
        } else {
            textAlign = null;
        }
        Intrinsics.checkNotNull(textAlign);
        int r4 = textAlign.m6459unboximpl();
        Object obj4 = list.get(1);
        if (obj4 != null) {
            textDirection = (TextDirection) obj4;
        } else {
            textDirection = null;
        }
        Intrinsics.checkNotNull(textDirection);
        int r5 = textDirection.m6473unboximpl();
        Object obj5 = list.get(2);
        Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.Companion);
        if ((!Intrinsics.areEqual(obj5, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj5 != null) {
            textUnit = saver.restore(obj5);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r6 = textUnit.m6820unboximpl();
        Object obj6 = list.get(3);
        Saver<TextIndent, Object> saver2 = SaversKt.getSaver(TextIndent.Companion);
        if ((!Intrinsics.areEqual(obj6, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj6 != null) {
            textIndent = saver2.restore(obj6);
        } else {
            textIndent = null;
        }
        return new ParagraphStyle(r4, r5, r6, textIndent, (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 496, (DefaultConstructorMarker) null);
    }
}
