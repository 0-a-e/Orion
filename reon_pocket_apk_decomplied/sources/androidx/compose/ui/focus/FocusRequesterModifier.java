package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifier;", "Landroidx/compose/ui/Modifier$Element;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(message = "Use FocusRequesterModifierNode instead")
/* compiled from: FocusRequesterModifier.kt */
public interface FocusRequesterModifier extends Modifier.Element {

    /* renamed from: androidx.compose.ui.focus.FocusRequesterModifier$-CC  reason: invalid class name */
    /* compiled from: FocusRequesterModifier.kt */
    public final /* synthetic */ class CC {
    }

    FocusRequester getFocusRequester();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusRequesterModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(FocusRequesterModifier focusRequesterModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$all(focusRequesterModifier, function1);
        }

        @Deprecated
        public static boolean any(FocusRequesterModifier focusRequesterModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$any(focusRequesterModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(FocusRequesterModifier focusRequesterModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldIn(focusRequesterModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(FocusRequesterModifier focusRequesterModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldOut(focusRequesterModifier, r, function2);
        }

        @Deprecated
        public static Modifier then(FocusRequesterModifier focusRequesterModifier, Modifier modifier) {
            return Modifier.CC.$default$then(focusRequesterModifier, modifier);
        }
    }
}
