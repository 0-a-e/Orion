package jp.co.sony.reonpocket.view;

import jp.co.sony.reonpocket.view.CustomSlideView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"jp/co/sony/reonpocket/view/CustomSlideView$setCurrentLevel$2", "Ljp/co/sony/reonpocket/view/CustomSlideView$OnLayoutListener;", "onLayoutOver", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomSlideView.kt */
public final class CustomSlideView$setCurrentLevel$2 implements CustomSlideView.OnLayoutListener {
    final /* synthetic */ CustomSlideView this$0;

    CustomSlideView$setCurrentLevel$2(CustomSlideView customSlideView) {
        this.this$0 = customSlideView;
    }

    public void onLayoutOver() {
        CustomSlideView customSlideView = this.this$0;
        customSlideView.setTop(((float) customSlideView.getHeight()) - (((float) this.this$0.mCurrentLevel) * (((float) this.this$0.getHeight()) / ((float) this.this$0.mMaxLevel))));
        this.this$0.mLayoutListener = null;
    }
}
