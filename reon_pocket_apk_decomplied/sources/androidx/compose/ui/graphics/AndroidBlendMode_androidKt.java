package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0006H\u0001¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidBlendMode.android.kt */
public final class AndroidBlendMode_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidBlendMode.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|61) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0150 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.graphics.BlendMode[] r0 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1()     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SRC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$5()     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$4()     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$6()     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$7()     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$8()     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$9()     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$11()     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$12()     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DST_ATOP     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.XOR     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.PLUS     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.MODULATE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SCREEN     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.OVERLAY     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DARKEN     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.LIGHTEN     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$10()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.COLOR_BURN     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.HARD_LIGHT     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SOFT_LIGHT     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DIFFERENCE     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.EXCLUSION     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.MULTIPLY     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.HUE     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m()     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$2()     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                android.graphics.BlendMode r1 = androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$3()     // Catch:{ NoSuchFieldError -> 0x015c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidBlendMode_androidKt.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: isSupported-s9anfk8  reason: not valid java name */
    public static final boolean m3653isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3746getSrcOver0nO6VwU()) || m3655toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toPorterDuffMode-s9anfk8  reason: not valid java name */
    public static final PorterDuff.Mode m3655toPorterDuffModes9anfk8(int i) {
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3719getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3742getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3725getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3746getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3729getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3744getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3727getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3745getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3728getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3743getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3726getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3747getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3738getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3740getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3737getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3723getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3733getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3735getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8  reason: not valid java name */
    public static final BlendMode m3654toAndroidBlendModes9anfk8(int i) {
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3719getClear0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3742getSrc0nO6VwU())) {
            return BlendMode.SRC;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3725getDst0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$5();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3746getSrcOver0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$4();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3729getDstOver0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$6();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3744getSrcIn0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$7();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3727getDstIn0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$8();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3745getSrcOut0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$9();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3728getDstOut0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$11();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3743getSrcAtop0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$12();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3726getDstAtop0nO6VwU())) {
            return BlendMode.DST_ATOP;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3747getXor0nO6VwU())) {
            return BlendMode.XOR;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3738getPlus0nO6VwU())) {
            return BlendMode.PLUS;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3735getModulate0nO6VwU())) {
            return BlendMode.MODULATE;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3740getScreen0nO6VwU())) {
            return BlendMode.SCREEN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3737getOverlay0nO6VwU())) {
            return BlendMode.OVERLAY;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3723getDarken0nO6VwU())) {
            return BlendMode.DARKEN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3733getLighten0nO6VwU())) {
            return BlendMode.LIGHTEN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3722getColorDodge0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$10();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3721getColorBurn0nO6VwU())) {
            return BlendMode.COLOR_BURN;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3731getHardlight0nO6VwU())) {
            return BlendMode.HARD_LIGHT;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3741getSoftlight0nO6VwU())) {
            return BlendMode.SOFT_LIGHT;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3724getDifference0nO6VwU())) {
            return BlendMode.DIFFERENCE;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3730getExclusion0nO6VwU())) {
            return BlendMode.EXCLUSION;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3736getMultiply0nO6VwU())) {
            return BlendMode.MULTIPLY;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3732getHue0nO6VwU())) {
            return BlendMode.HUE;
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3739getSaturation0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3720getColor0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$2();
        }
        if (BlendMode.m3715equalsimpl0(i, BlendMode.Companion.m3734getLuminosity0nO6VwU())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$3();
        }
        return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$4();
    }

    public static final int toComposeBlendMode(BlendMode blendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[blendMode.ordinal()]) {
            case 1:
                return BlendMode.Companion.m3719getClear0nO6VwU();
            case 2:
                return BlendMode.Companion.m3742getSrc0nO6VwU();
            case 3:
                return BlendMode.Companion.m3725getDst0nO6VwU();
            case 4:
                return BlendMode.Companion.m3746getSrcOver0nO6VwU();
            case 5:
                return BlendMode.Companion.m3729getDstOver0nO6VwU();
            case 6:
                return BlendMode.Companion.m3744getSrcIn0nO6VwU();
            case 7:
                return BlendMode.Companion.m3727getDstIn0nO6VwU();
            case 8:
                return BlendMode.Companion.m3745getSrcOut0nO6VwU();
            case 9:
                return BlendMode.Companion.m3728getDstOut0nO6VwU();
            case 10:
                return BlendMode.Companion.m3743getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.Companion.m3726getDstAtop0nO6VwU();
            case 12:
                return BlendMode.Companion.m3747getXor0nO6VwU();
            case 13:
                return BlendMode.Companion.m3738getPlus0nO6VwU();
            case 14:
                return BlendMode.Companion.m3735getModulate0nO6VwU();
            case 15:
                return BlendMode.Companion.m3740getScreen0nO6VwU();
            case 16:
                return BlendMode.Companion.m3737getOverlay0nO6VwU();
            case 17:
                return BlendMode.Companion.m3723getDarken0nO6VwU();
            case 18:
                return BlendMode.Companion.m3733getLighten0nO6VwU();
            case 19:
                return BlendMode.Companion.m3722getColorDodge0nO6VwU();
            case 20:
                return BlendMode.Companion.m3721getColorBurn0nO6VwU();
            case 21:
                return BlendMode.Companion.m3731getHardlight0nO6VwU();
            case 22:
                return BlendMode.Companion.m3741getSoftlight0nO6VwU();
            case 23:
                return BlendMode.Companion.m3724getDifference0nO6VwU();
            case 24:
                return BlendMode.Companion.m3730getExclusion0nO6VwU();
            case 25:
                return BlendMode.Companion.m3736getMultiply0nO6VwU();
            case 26:
                return BlendMode.Companion.m3732getHue0nO6VwU();
            case 27:
                return BlendMode.Companion.m3739getSaturation0nO6VwU();
            case 28:
                return BlendMode.Companion.m3720getColor0nO6VwU();
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /*29*/:
                return BlendMode.Companion.m3734getLuminosity0nO6VwU();
            default:
                return BlendMode.Companion.m3746getSrcOver0nO6VwU();
        }
    }
}
