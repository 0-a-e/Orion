package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryDefault;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StaticLayoutFactory.kt */
final class StaticLayoutFactoryDefault implements StaticLayoutFactoryImpl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean isInitialized;
    /* access modifiers changed from: private */
    public static Constructor<StaticLayout> staticLayoutConstructor;

    public boolean isFallbackLineSpacingEnabled(StaticLayout staticLayout, boolean z) {
        return false;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryDefault$Companion;", "", "()V", "isInitialized", "", "staticLayoutConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/text/StaticLayout;", "getStaticLayoutConstructor", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: StaticLayoutFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Constructor<StaticLayout> getStaticLayoutConstructor() {
            if (StaticLayoutFactoryDefault.isInitialized) {
                return StaticLayoutFactoryDefault.staticLayoutConstructor;
            }
            StaticLayoutFactoryDefault.isInitialized = true;
            Class<StaticLayout> cls = StaticLayout.class;
            try {
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                StaticLayoutFactoryDefault.staticLayoutConstructor = cls.getConstructor(new Class[]{CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, TextDirectionHeuristic.class, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2});
            } catch (NoSuchMethodException unused) {
                StaticLayoutFactoryDefault.staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to collect necessary constructor.");
            }
            return StaticLayoutFactoryDefault.staticLayoutConstructor;
        }
    }

    public StaticLayout create(StaticLayoutParams staticLayoutParams) {
        StaticLayout staticLayout;
        Constructor access$getStaticLayoutConstructor = Companion.getStaticLayoutConstructor();
        if (access$getStaticLayoutConstructor != null) {
            try {
                staticLayout = (StaticLayout) access$getStaticLayoutConstructor.newInstance(new Object[]{staticLayoutParams.getText(), Integer.valueOf(staticLayoutParams.getStart()), Integer.valueOf(staticLayoutParams.getEnd()), staticLayoutParams.getPaint(), Integer.valueOf(staticLayoutParams.getWidth()), staticLayoutParams.getAlignment(), staticLayoutParams.getTextDir(), Float.valueOf(staticLayoutParams.getLineSpacingMultiplier()), Float.valueOf(staticLayoutParams.getLineSpacingExtra()), Boolean.valueOf(staticLayoutParams.getIncludePadding()), staticLayoutParams.getEllipsize(), Integer.valueOf(staticLayoutParams.getEllipsizedWidth()), Integer.valueOf(staticLayoutParams.getMaxLines())});
            } catch (IllegalAccessException unused) {
                staticLayout = null;
                staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            } catch (InstantiationException unused2) {
                staticLayout = null;
                staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            } catch (InvocationTargetException unused3) {
                staticLayout = null;
                staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            }
        } else {
            staticLayout = null;
        }
        StaticLayout staticLayout2 = staticLayout;
        return staticLayout2 != null ? staticLayout2 : new StaticLayout(staticLayoutParams.getText(), staticLayoutParams.getStart(), staticLayoutParams.getEnd(), staticLayoutParams.getPaint(), staticLayoutParams.getWidth(), staticLayoutParams.getAlignment(), staticLayoutParams.getLineSpacingMultiplier(), staticLayoutParams.getLineSpacingExtra(), staticLayoutParams.getIncludePadding(), staticLayoutParams.getEllipsize(), staticLayoutParams.getEllipsizedWidth());
    }
}
