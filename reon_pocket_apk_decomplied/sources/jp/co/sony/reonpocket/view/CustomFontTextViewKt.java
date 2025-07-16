package jp.co.sony.reonpocket.view;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"handleUrlClick", "", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "aOnClickedEvent", "Lkotlin/Function1;", "", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomFontTextView.kt */
public final class CustomFontTextViewKt {
    public static /* synthetic */ void handleUrlClick$default(CustomFontTextView customFontTextView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        handleUrlClick(customFontTextView, function1);
    }

    public static final void handleUrlClick(CustomFontTextView customFontTextView, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(customFontTextView, "<this>");
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(customFontTextView.getText());
        Object[] spans = valueOf.getSpans(0, valueOf.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        for (Object obj : spans) {
            URLSpan uRLSpan = (URLSpan) obj;
            valueOf.setSpan(new CustomFontTextViewKt$handleUrlClick$1$1$1(function1, uRLSpan), valueOf.getSpanStart(uRLSpan), valueOf.getSpanEnd(uRLSpan), 17);
            valueOf.removeSpan(uRLSpan);
        }
        customFontTextView.setText(valueOf);
        customFontTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
