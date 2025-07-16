package jp.co.sony.reonpocket.modules.tagInfo.view;

import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragment$addHyperLink$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "textView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoFragment.kt */
public final class TagInfoFragment$addHyperLink$1 extends ClickableSpan {
    final /* synthetic */ TagInfoFragment this$0;

    TagInfoFragment$addHyperLink$1(TagInfoFragment tagInfoFragment) {
        this.this$0 = tagInfoFragment;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "textView");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://reonpocket.sony.co.jp/support/index.html#tag_battery_exchange"));
        FragmentActivity activity = this.this$0.getActivity();
        Intrinsics.checkNotNull(activity);
        activity.startActivity(intent);
    }
}
