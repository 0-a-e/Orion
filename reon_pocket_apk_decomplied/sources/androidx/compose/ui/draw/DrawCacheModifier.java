package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawCacheModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "onBuildCache", "", "params", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
public interface DrawCacheModifier extends DrawModifier {

    /* renamed from: androidx.compose.ui.draw.DrawCacheModifier$-CC  reason: invalid class name */
    /* compiled from: DrawModifier.kt */
    public final /* synthetic */ class CC {
    }

    void onBuildCache(BuildDrawCacheParams buildDrawCacheParams);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DrawModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(DrawCacheModifier drawCacheModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$all(drawCacheModifier, function1);
        }

        @Deprecated
        public static boolean any(DrawCacheModifier drawCacheModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$any(drawCacheModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(DrawCacheModifier drawCacheModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldIn(drawCacheModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(DrawCacheModifier drawCacheModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldOut(drawCacheModifier, r, function2);
        }

        @Deprecated
        public static Modifier then(DrawCacheModifier drawCacheModifier, Modifier modifier) {
            return Modifier.CC.$default$then(drawCacheModifier, modifier);
        }
    }
}
