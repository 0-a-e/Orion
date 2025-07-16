package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a \u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¨\u0006\r"}, d2 = {"PlatformTypefaces", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "getWeightSuffixForFallbackFamilyName", "", "name", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformTypefaces.android.kt */
public final class PlatformTypefaces_androidKt {
    public static final PlatformTypefaces PlatformTypefaces() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PlatformTypefacesApi28();
        }
        return new PlatformTypefacesApi();
    }

    public static final Typeface setFontVariationSettings(Typeface typeface, FontVariation.Settings settings, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? TypefaceCompatApi26.INSTANCE.setFontVariationSettings(typeface, settings, context) : typeface;
    }

    public static final String getWeightSuffixForFallbackFamilyName(String str, FontWeight fontWeight) {
        int weight = fontWeight.getWeight() / 100;
        if (weight >= 0 && weight < 2) {
            return str + "-thin";
        } else if (2 <= weight && weight < 4) {
            return str + "-light";
        } else if (weight == 4) {
            return str;
        } else {
            if (weight == 5) {
                return str + "-medium";
            } else if ((6 <= weight && weight < 8) || 8 > weight || weight >= 11) {
                return str;
            } else {
                return str + "-black";
            }
        }
    }
}
