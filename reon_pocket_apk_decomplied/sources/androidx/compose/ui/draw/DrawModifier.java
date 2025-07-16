package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/Modifier$Element;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
public interface DrawModifier extends Modifier.Element {

    /* renamed from: androidx.compose.ui.draw.DrawModifier$-CC  reason: invalid class name */
    /* compiled from: DrawModifier.kt */
    public final /* synthetic */ class CC {
    }

    void draw(ContentDrawScope contentDrawScope);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DrawModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(DrawModifier drawModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$all(drawModifier, function1);
        }

        @Deprecated
        public static boolean any(DrawModifier drawModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$any(drawModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(DrawModifier drawModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldIn(drawModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(DrawModifier drawModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldOut(drawModifier, r, function2);
        }

        @Deprecated
        public static Modifier then(DrawModifier drawModifier, Modifier modifier) {
            return Modifier.CC.$default$then(drawModifier, modifier);
        }
    }
}
