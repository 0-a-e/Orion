package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/CanvasUtils;", "", "()V", "inorderBarrierMethod", "Ljava/lang/reflect/Method;", "orderMethodsFetched", "", "reorderBarrierMethod", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CanvasUtils.android.kt */
public final class CanvasUtils {
    public static final CanvasUtils INSTANCE = new CanvasUtils();
    private static Method inorderBarrierMethod;
    private static boolean orderMethodsFetched;
    private static Method reorderBarrierMethod;

    private CanvasUtils() {
    }

    public final void enableZ(Canvas canvas, boolean z) {
        Method method;
        if (Build.VERSION.SDK_INT >= 29) {
            CanvasZHelper.INSTANCE.enableZ(canvas, z);
            return;
        }
        if (!orderMethodsFetched) {
            try {
                if (Build.VERSION.SDK_INT == 28) {
                    Class<Class> cls = Class.class;
                    Method declaredMethod = cls.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()});
                    reorderBarrierMethod = (Method) declaredMethod.invoke(Canvas.class, new Object[]{"insertReorderBarrier", new Class[0]});
                    inorderBarrierMethod = (Method) declaredMethod.invoke(Canvas.class, new Object[]{"insertInorderBarrier", new Class[0]});
                } else {
                    reorderBarrierMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", (Class[]) null);
                    inorderBarrierMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", (Class[]) null);
                }
                Method method2 = reorderBarrierMethod;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                Method method3 = inorderBarrierMethod;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            orderMethodsFetched = true;
        }
        if (z) {
            try {
                Method method4 = reorderBarrierMethod;
                if (method4 != null) {
                    Intrinsics.checkNotNull(method4);
                    method4.invoke(canvas, (Object[]) null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (!z && (method = inorderBarrierMethod) != null) {
            Intrinsics.checkNotNull(method);
            method.invoke(canvas, (Object[]) null);
        }
    }
}
