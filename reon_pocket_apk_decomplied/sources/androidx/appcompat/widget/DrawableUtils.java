package androidx.appcompat.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.WrappedDrawable;

public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class<?> sInsetsClazz;

    static void fixDrawable(Drawable drawable) {
    }

    static {
        try {
            sInsetsClazz = Class.forName("android.graphics.Insets");
        } catch (ClassNotFoundException unused) {
        }
    }

    private DrawableUtils() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Rect getOpticalBounds(android.graphics.drawable.Drawable r11) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x0028
            android.graphics.Insets r11 = r11.getOpticalInsets()
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            int r1 = r11.left
            r0.left = r1
            int r1 = r11.right
            r0.right = r1
            int r1 = r11.top
            r0.top = r1
            int r11 = r11.bottom
            r0.bottom = r11
            return r0
        L_0x0028:
            java.lang.Class<?> r0 = sInsetsClazz
            if (r0 == 0) goto L_0x00bb
            android.graphics.drawable.Drawable r11 = androidx.core.graphics.drawable.DrawableCompat.unwrap(r11)     // Catch:{ Exception -> 0x00b4 }
            java.lang.Class r0 = r11.getClass()     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r1 = "getOpticalInsets"
            r2 = 0
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ Exception -> 0x00b4 }
            java.lang.Object r11 = r0.invoke(r11, r2)     // Catch:{ Exception -> 0x00b4 }
            if (r11 == 0) goto L_0x00bb
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ Exception -> 0x00b4 }
            r0.<init>()     // Catch:{ Exception -> 0x00b4 }
            java.lang.Class<?> r1 = sInsetsClazz     // Catch:{ Exception -> 0x00b4 }
            java.lang.reflect.Field[] r1 = r1.getFields()     // Catch:{ Exception -> 0x00b4 }
            int r2 = r1.length     // Catch:{ Exception -> 0x00b4 }
            r3 = 0
            r4 = r3
        L_0x004f:
            if (r4 >= r2) goto L_0x00b3
            r5 = r1[r4]     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r6 = r5.getName()     // Catch:{ Exception -> 0x00b4 }
            int r7 = r6.hashCode()     // Catch:{ Exception -> 0x00b4 }
            r8 = 3
            r9 = 2
            r10 = 1
            switch(r7) {
                case -1383228885: goto L_0x0081;
                case 115029: goto L_0x0076;
                case 3317767: goto L_0x006c;
                case 108511772: goto L_0x0062;
                default: goto L_0x0061;
            }     // Catch:{ Exception -> 0x00b4 }
        L_0x0061:
            goto L_0x008b
        L_0x0062:
            java.lang.String r7 = "right"
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x00b4 }
            if (r6 == 0) goto L_0x008b
            r6 = r9
            goto L_0x008c
        L_0x006c:
            java.lang.String r7 = "left"
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x00b4 }
            if (r6 == 0) goto L_0x008b
            r6 = r3
            goto L_0x008c
        L_0x0076:
            java.lang.String r7 = "top"
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x00b4 }
            if (r6 == 0) goto L_0x008b
            r6 = r10
            goto L_0x008c
        L_0x0081:
            java.lang.String r7 = "bottom"
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x00b4 }
            if (r6 == 0) goto L_0x008b
            r6 = r8
            goto L_0x008c
        L_0x008b:
            r6 = -1
        L_0x008c:
            if (r6 == 0) goto L_0x00aa
            if (r6 == r10) goto L_0x00a3
            if (r6 == r9) goto L_0x009c
            if (r6 == r8) goto L_0x0095
            goto L_0x00b0
        L_0x0095:
            int r5 = r5.getInt(r11)     // Catch:{ Exception -> 0x00b4 }
            r0.bottom = r5     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00b0
        L_0x009c:
            int r5 = r5.getInt(r11)     // Catch:{ Exception -> 0x00b4 }
            r0.right = r5     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00b0
        L_0x00a3:
            int r5 = r5.getInt(r11)     // Catch:{ Exception -> 0x00b4 }
            r0.top = r5     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00b0
        L_0x00aa:
            int r5 = r5.getInt(r11)     // Catch:{ Exception -> 0x00b4 }
            r0.left = r5     // Catch:{ Exception -> 0x00b4 }
        L_0x00b0:
            int r4 = r4 + 1
            goto L_0x004f
        L_0x00b3:
            return r0
        L_0x00b4:
            java.lang.String r11 = "DrawableUtils"
            java.lang.String r0 = "Couldn't obtain the optical insets. Ignoring."
            android.util.Log.e(r11, r0)
        L_0x00bb:
            android.graphics.Rect r11 = INSETS_NONE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.getOpticalBounds(android.graphics.drawable.Drawable):android.graphics.Rect");
    }

    public static boolean canSafelyMutateDrawable(Drawable drawable) {
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable canSafelyMutateDrawable : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!canSafelyMutateDrawable(canSafelyMutateDrawable)) {
                    return false;
                }
            }
            return true;
        } else if (drawable instanceof WrappedDrawable) {
            return canSafelyMutateDrawable(((WrappedDrawable) drawable).getWrappedDrawable());
        } else {
            if (drawable instanceof DrawableWrapper) {
                return canSafelyMutateDrawable(((DrawableWrapper) drawable).getWrappedDrawable());
            }
            if (drawable instanceof ScaleDrawable) {
                return canSafelyMutateDrawable(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
    }

    private static void fixVectorDrawableTinting(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(CHECKED_STATE_SET);
        } else {
            drawable.setState(EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
