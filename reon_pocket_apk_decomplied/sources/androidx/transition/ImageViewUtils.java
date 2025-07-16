package androidx.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ImageViewUtils {
    private static final String TAG = "ImageViewUtils";
    private static Method sAnimateTransformMethod;
    private static boolean sAnimateTransformMethodFetched;

    static void reserveEndAnimateTransform(ImageView imageView, Animator animator) {
    }

    static void startAnimateTransform(ImageView imageView) {
    }

    static void animateTransform(ImageView imageView, Matrix matrix) {
        fetchAnimateTransformMethod();
        Method method = sAnimateTransformMethod;
        if (method != null) {
            try {
                method.invoke(imageView, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private static void fetchAnimateTransformMethod() {
        if (!sAnimateTransformMethodFetched) {
            try {
                Method declaredMethod = ImageView.class.getDeclaredMethod("animateTransform", new Class[]{Matrix.class});
                sAnimateTransformMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve animateTransform method", e);
            }
            sAnimateTransformMethodFetched = true;
        }
    }

    private ImageViewUtils() {
    }
}
