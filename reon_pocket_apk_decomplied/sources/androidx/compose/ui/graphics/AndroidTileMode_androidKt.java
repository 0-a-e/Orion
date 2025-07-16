package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTileMode.android.kt */
public final class AndroidTileMode_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidTileMode.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                android.graphics.Shader$TileMode[] r0 = android.graphics.Shader.TileMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.graphics.Shader$TileMode r1 = android.graphics.Shader.TileMode.CLAMP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                android.graphics.Shader$TileMode r1 = android.graphics.Shader.TileMode.MIRROR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                android.graphics.Shader$TileMode r1 = android.graphics.Shader.TileMode.REPEAT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidTileMode_androidKt.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: isSupported-0vamqd0  reason: not valid java name */
    public static final boolean m3708isSupported0vamqd0(int i) {
        return Build.VERSION.SDK_INT >= 31 || !TileMode.m4247equalsimpl0(i, TileMode.Companion.m4252getDecal3opZhB0());
    }

    /* renamed from: toAndroidTileMode-0vamqd0  reason: not valid java name */
    public static final Shader.TileMode m3709toAndroidTileMode0vamqd0(int i) {
        if (TileMode.m4247equalsimpl0(i, TileMode.Companion.m4251getClamp3opZhB0())) {
            return Shader.TileMode.CLAMP;
        }
        if (TileMode.m4247equalsimpl0(i, TileMode.Companion.m4254getRepeated3opZhB0())) {
            return Shader.TileMode.REPEAT;
        }
        if (TileMode.m4247equalsimpl0(i, TileMode.Companion.m4253getMirror3opZhB0())) {
            return Shader.TileMode.MIRROR;
        }
        if (!TileMode.m4247equalsimpl0(i, TileMode.Companion.m4252getDecal3opZhB0())) {
            return Shader.TileMode.CLAMP;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
        }
        return Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(Shader.TileMode tileMode) {
        int i = WhenMappings.$EnumSwitchMapping$0[tileMode.ordinal()];
        if (i == 1) {
            return TileMode.Companion.m4251getClamp3opZhB0();
        }
        if (i == 2) {
            return TileMode.Companion.m4253getMirror3opZhB0();
        }
        if (i == 3) {
            return TileMode.Companion.m4254getRepeated3opZhB0();
        }
        if (Build.VERSION.SDK_INT < 31 || tileMode != Api26Bitmap$$ExternalSyntheticApiModelOutline0.m()) {
            return TileMode.Companion.m4251getClamp3opZhB0();
        }
        return TileModeVerificationHelper.INSTANCE.m4255getComposeTileModeDecal3opZhB0();
    }
}
