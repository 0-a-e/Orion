package jp.co.sony.reonpocket.modules.main.view;

import android.view.View;
import android.widget.ImageView;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainCoolFragment$showWaveGuide$2$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainCoolFragment.kt */
public final class MainCoolFragment$showWaveGuide$2$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ MainCoolFragment this$0;

    MainCoolFragment$showWaveGuide$2$1(MainCoolFragment mainCoolFragment) {
        this.this$0 = mainCoolFragment;
    }

    public void onViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "aView");
        CustomFontTextView customFontTextView = (CustomFontTextView) view.findViewById(R.id.subtitle);
        if (customFontTextView != null) {
            customFontTextView.setText(this.this$0.getString(R.string.mainview_wave_guide_description));
        }
        this.this$0.mImageView = (ImageView) view.findViewById(R.id.image_view);
        ImageView access$getMImageView$p = this.this$0.mImageView;
        if (access$getMImageView$p != null) {
            access$getMImageView$p.setImageResource(R.drawable.img_guide_wave);
            access$getMImageView$p.setVisibility(0);
        }
        CustomFontTextView customFontTextView2 = (CustomFontTextView) view.findViewById(R.id.description);
        if (customFontTextView2 != null) {
            customFontTextView2.setVisibility(8);
        }
        CustomFontTextView customFontTextView3 = (CustomFontTextView) view.findViewById(R.id.url);
        if (customFontTextView3 != null) {
            customFontTextView3.setVisibility(8);
        }
    }
}
