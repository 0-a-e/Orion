package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/SpanStyle;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$SpanStyleSaver$2 extends Lambda implements Function1<Object, SpanStyle> {
    public static final SaversKt$SpanStyleSaver$2 INSTANCE = new SaversKt$SpanStyleSaver$2();

    SaversKt$SpanStyleSaver$2() {
        super(1);
    }

    public final SpanStyle invoke(Object obj) {
        Color color;
        TextUnit textUnit;
        FontWeight fontWeight;
        FontStyle fontStyle;
        FontSynthesis fontSynthesis;
        String str;
        TextUnit textUnit2;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        Color color2;
        TextDecoration textDecoration;
        Shadow shadow;
        Object obj2 = obj;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj2;
        Object obj3 = list.get(0);
        Saver<Color, Object> saver = SaversKt.getSaver(Color.Companion);
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) {
            color = saver.restore(obj3);
        } else {
            color = null;
        }
        Intrinsics.checkNotNull(color);
        long r3 = color.m3826unboximpl();
        Object obj4 = list.get(1);
        Saver<TextUnit, Object> saver2 = SaversKt.getSaver(TextUnit.Companion);
        if ((!Intrinsics.areEqual(obj4, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj4 != null) {
            textUnit = saver2.restore(obj4);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r6 = textUnit.m6820unboximpl();
        Object obj5 = list.get(2);
        Saver<FontWeight, Object> saver3 = SaversKt.getSaver(FontWeight.Companion);
        if ((!Intrinsics.areEqual(obj5, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj5 != null) {
            fontWeight = saver3.restore(obj5);
        } else {
            fontWeight = null;
        }
        Object obj6 = list.get(3);
        if (obj6 != null) {
            fontStyle = (FontStyle) obj6;
        } else {
            fontStyle = null;
        }
        Object obj7 = list.get(4);
        if (obj7 != null) {
            fontSynthesis = (FontSynthesis) obj7;
        } else {
            fontSynthesis = null;
        }
        Object obj8 = list.get(6);
        if (obj8 != null) {
            str = (String) obj8;
        } else {
            str = null;
        }
        Object obj9 = list.get(7);
        Saver<TextUnit, Object> saver4 = SaversKt.getSaver(TextUnit.Companion);
        if ((!Intrinsics.areEqual(obj9, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj9 != null) {
            textUnit2 = saver4.restore(obj9);
        } else {
            textUnit2 = null;
        }
        Intrinsics.checkNotNull(textUnit2);
        long r13 = textUnit2.m6820unboximpl();
        Object obj10 = list.get(8);
        Saver<BaselineShift, Object> saver5 = SaversKt.getSaver(BaselineShift.Companion);
        if ((!Intrinsics.areEqual(obj10, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj10 != null) {
            baselineShift = saver5.restore(obj10);
        } else {
            baselineShift = null;
        }
        Object obj11 = list.get(9);
        Saver<TextGeometricTransform, Object> saver6 = SaversKt.getSaver(TextGeometricTransform.Companion);
        if ((!Intrinsics.areEqual(obj11, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj11 != null) {
            textGeometricTransform = saver6.restore(obj11);
        } else {
            textGeometricTransform = null;
        }
        Object obj12 = list.get(10);
        Saver<LocaleList, Object> saver7 = SaversKt.getSaver(LocaleList.Companion);
        if ((!Intrinsics.areEqual(obj12, (Object) false) || (saver7 instanceof NonNullValueClassSaver)) && obj12 != null) {
            localeList = saver7.restore(obj12);
        } else {
            localeList = null;
        }
        Object obj13 = list.get(11);
        Saver<Color, Object> saver8 = SaversKt.getSaver(Color.Companion);
        if ((!Intrinsics.areEqual(obj13, (Object) false) || (saver8 instanceof NonNullValueClassSaver)) && obj13 != null) {
            color2 = saver8.restore(obj13);
        } else {
            color2 = null;
        }
        Intrinsics.checkNotNull(color2);
        long r18 = color2.m3826unboximpl();
        Object obj14 = list.get(12);
        Saver<TextDecoration, Object> saver9 = SaversKt.getSaver(TextDecoration.Companion);
        if ((!Intrinsics.areEqual(obj14, (Object) false) || (saver9 instanceof NonNullValueClassSaver)) && obj14 != null) {
            textDecoration = saver9.restore(obj14);
        } else {
            textDecoration = null;
        }
        Object obj15 = list.get(13);
        Saver<Shadow, Object> saver10 = SaversKt.getSaver(Shadow.Companion);
        if ((!Intrinsics.areEqual(obj15, (Object) false) || (saver10 instanceof NonNullValueClassSaver)) && obj15 != null) {
            shadow = saver10.restore(obj15);
        } else {
            shadow = null;
        }
        return new SpanStyle(r3, r6, fontWeight, fontStyle, fontSynthesis, (FontFamily) null, str, r13, baselineShift, textGeometricTransform, localeList, r18, textDecoration, shadow, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
    }
}
