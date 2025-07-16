package jp.co.sony.reonpocket.view;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/view/CustomFontTextViewKt$handleUrlClick$1$1$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomFontTextView.kt */
public final class CustomFontTextViewKt$handleUrlClick$1$1$1 extends ClickableSpan {
    final /* synthetic */ Function1<String, Unit> $aOnClickedEvent;
    final /* synthetic */ URLSpan $it;

    CustomFontTextViewKt$handleUrlClick$1$1$1(Function1<? super String, Unit> function1, URLSpan uRLSpan) {
        this.$aOnClickedEvent = function1;
        this.$it = uRLSpan;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        Function1<String, Unit> function1 = this.$aOnClickedEvent;
        if (function1 != null) {
            String url = this.$it.getURL();
            Intrinsics.checkNotNullExpressionValue(url, "getURL(...)");
            function1.invoke(url);
        }
    }
}
