package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class FragmentTagInfoBinding implements ViewBinding {
    public final TextView TagInfoUnitText;
    public final ImageView ambientTempImageError;
    public final TextView ambientTempMessageError;
    public final ImageView imageError;
    public final TextView messageError;
    public final TextView messageHumi;
    public final TextView messageSerialNo;
    public final TextView messageTemp;
    public final TextView messageTempUnit;
    private final LinearLayout rootView;
    public final ImageView rowBatteryImage;
    public final ImageView tagHumiAnime;
    public final ImageView tagHumiImage;
    public final LinearLayout tagHumiLayout;
    public final ImageView tagImage;
    public final ConstraintLayout tagImageLayout;
    public final LinearLayout tagInfoLayout;
    public final ImageView tagTempAnime;
    public final ImageView tagTempImage;

    private FragmentTagInfoBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout2, ImageView imageView6, ConstraintLayout constraintLayout, LinearLayout linearLayout3, ImageView imageView7, ImageView imageView8) {
        this.rootView = linearLayout;
        this.TagInfoUnitText = textView;
        this.ambientTempImageError = imageView;
        this.ambientTempMessageError = textView2;
        this.imageError = imageView2;
        this.messageError = textView3;
        this.messageHumi = textView4;
        this.messageSerialNo = textView5;
        this.messageTemp = textView6;
        this.messageTempUnit = textView7;
        this.rowBatteryImage = imageView3;
        this.tagHumiAnime = imageView4;
        this.tagHumiImage = imageView5;
        this.tagHumiLayout = linearLayout2;
        this.tagImage = imageView6;
        this.tagImageLayout = constraintLayout;
        this.tagInfoLayout = linearLayout3;
        this.tagTempAnime = imageView7;
        this.tagTempImage = imageView8;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTagInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentTagInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tag_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTagInfoBinding bind(View view) {
        View view2 = view;
        int i = R.id.TagInfoUnitText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
        if (textView != null) {
            i = R.id.ambient_temp_image_error;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
            if (imageView != null) {
                i = R.id.ambient_temp_message_error;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView2 != null) {
                    i = R.id.image_error;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView2 != null) {
                        i = R.id.message_error;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView3 != null) {
                            i = R.id.message_humi;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView4 != null) {
                                i = R.id.message_serialNo;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView5 != null) {
                                    i = R.id.message_temp;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView6 != null) {
                                        i = R.id.message_temp_unit;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView7 != null) {
                                            i = R.id.row_battery_image;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                            if (imageView3 != null) {
                                                i = R.id.tag_humi_anime;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                if (imageView4 != null) {
                                                    i = R.id.tag_humi_image;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                    if (imageView5 != null) {
                                                        i = R.id.tag_humi_layout;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                        if (linearLayout != null) {
                                                            i = R.id.tag_image;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                            if (imageView6 != null) {
                                                                i = R.id.tag_image_layout;
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (constraintLayout != null) {
                                                                    i = R.id.tag_info_layout;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.tag_temp_anime;
                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                        if (imageView7 != null) {
                                                                            i = R.id.tag_temp_image;
                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                            if (imageView8 != null) {
                                                                                return new FragmentTagInfoBinding((LinearLayout) view2, textView, imageView, textView2, imageView2, textView3, textView4, textView5, textView6, textView7, imageView3, imageView4, imageView5, linearLayout, imageView6, constraintLayout, linearLayout2, imageView7, imageView8);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
