package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        try {
            Class<Rect> cls = Rect.class;
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{cls, cls});
            sComputeFitSystemWindowsMethod = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                sComputeFitSystemWindowsMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    private ViewUtils() {
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        Method method = sComputeFitSystemWindowsMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e) {
                Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static void makeOptionalFitsSystemWindows(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", (Class[]) null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, (Object[]) null);
        } catch (NoSuchMethodException unused) {
            Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e) {
            Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (IllegalAccessException e2) {
            Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
    }
}
