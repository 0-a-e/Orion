package jp.co.sony.reonpocket.modules.tagInfo.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TagInfoFragment$$ExternalSyntheticLambda0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ LinearLayout f$1;
    public final /* synthetic */ View f$2;

    public /* synthetic */ TagInfoFragment$$ExternalSyntheticLambda0(Ref.BooleanRef booleanRef, LinearLayout linearLayout, View view) {
        this.f$0 = booleanRef;
        this.f$1 = linearLayout;
        this.f$2 = view;
    }

    public final void onGlobalLayout() {
        TagInfoFragment.initView$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}
