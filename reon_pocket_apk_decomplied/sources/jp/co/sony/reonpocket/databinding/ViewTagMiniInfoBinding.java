package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewTagMiniInfoBinding implements ViewBinding {
    public final LinearLayout dividingLine;
    public final ImageView dividingLineImage;
    public final ImageView errorLayoutTagImage;
    public final TextView messageHumi;
    public final TextView messageTemp;
    private final FrameLayout rootView;
    public final TextView statusText;
    public final LinearLayout tagErrorLayout;
    public final ImageView tagHumiAnime;
    public final ImageView tagHumiImage;
    public final ImageView tagImage;
    public final LinearLayout tagMiniTempLayout;
    public final ImageView tagTempAnime;
    public final ImageView tagTempImage;

    private ViewTagMiniInfoBinding(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout3, ImageView imageView6, ImageView imageView7) {
        this.rootView = frameLayout;
        this.dividingLine = linearLayout;
        this.dividingLineImage = imageView;
        this.errorLayoutTagImage = imageView2;
        this.messageHumi = textView;
        this.messageTemp = textView2;
        this.statusText = textView3;
        this.tagErrorLayout = linearLayout2;
        this.tagHumiAnime = imageView3;
        this.tagHumiImage = imageView4;
        this.tagImage = imageView5;
        this.tagMiniTempLayout = linearLayout3;
        this.tagTempAnime = imageView6;
        this.tagTempImage = imageView7;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewTagMiniInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewTagMiniInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_tag_mini_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewTagMiniInfoBinding bind(View view) {
        View view2 = view;
        int i = R.id.dividing_line;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
        if (linearLayout != null) {
            i = R.id.dividing_line_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
            if (imageView != null) {
                i = R.id.error_layout_tag_image;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView2 != null) {
                    i = R.id.message_humi;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView != null) {
                        i = R.id.message_temp;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView2 != null) {
                            i = R.id.status_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView3 != null) {
                                i = R.id.tag_error_layout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                if (linearLayout2 != null) {
                                    i = R.id.tag_humi_anime;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView3 != null) {
                                        i = R.id.tag_humi_image;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                        if (imageView4 != null) {
                                            i = R.id.tag_image;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                            if (imageView5 != null) {
                                                i = R.id.tag_mini_temp_layout;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.tag_temp_anime;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                    if (imageView6 != null) {
                                                        i = R.id.tag_temp_image;
                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                        if (imageView7 != null) {
                                                            return new ViewTagMiniInfoBinding((FrameLayout) view2, linearLayout, imageView, imageView2, textView, textView2, textView3, linearLayout2, imageView3, imageView4, imageView5, linearLayout3, imageView6, imageView7);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
