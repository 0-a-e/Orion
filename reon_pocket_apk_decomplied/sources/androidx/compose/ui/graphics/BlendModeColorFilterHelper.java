package androidx.compose.ui.graphics;

import android.graphics.BlendModeColorFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/BlendModeColorFilterHelper;", "", "()V", "BlendModeColorFilter", "Landroid/graphics/BlendModeColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "BlendModeColorFilter-xETnrds", "(JI)Landroid/graphics/BlendModeColorFilter;", "createBlendModeColorFilter", "Landroidx/compose/ui/graphics/BlendModeColorFilter;", "androidBlendModeColorFilter", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidColorFilter.android.kt */
final class BlendModeColorFilterHelper {
    public static final BlendModeColorFilterHelper INSTANCE = new BlendModeColorFilterHelper();

    private BlendModeColorFilterHelper() {
    }

    /* renamed from: BlendModeColorFilter-xETnrds  reason: not valid java name */
    public final BlendModeColorFilter m3750BlendModeColorFilterxETnrds(long j, int i) {
        Api26Bitmap$$ExternalSyntheticApiModelOutline0.m();
        return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(ColorKt.m3870toArgb8_81llA(j), AndroidBlendMode_androidKt.m3654toAndroidBlendModes9anfk8(i));
    }

    public final BlendModeColorFilter createBlendModeColorFilter(BlendModeColorFilter blendModeColorFilter) {
        return new BlendModeColorFilter(ColorKt.Color(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(blendModeColorFilter)), AndroidBlendMode_androidKt.toComposeBlendMode(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(blendModeColorFilter)), blendModeColorFilter, (DefaultConstructorMarker) null);
    }
}
