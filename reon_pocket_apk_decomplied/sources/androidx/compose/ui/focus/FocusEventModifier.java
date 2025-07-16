package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/focus/FocusEventModifier;", "Landroidx/compose/ui/Modifier$Element;", "onFocusEvent", "", "focusState", "Landroidx/compose/ui/focus/FocusState;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(message = "Use FocusEventModifierNode instead")
/* compiled from: FocusEventModifier.kt */
public interface FocusEventModifier extends Modifier.Element {

    /* renamed from: androidx.compose.ui.focus.FocusEventModifier$-CC  reason: invalid class name */
    /* compiled from: FocusEventModifier.kt */
    public final /* synthetic */ class CC {
    }

    void onFocusEvent(FocusState focusState);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusEventModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(FocusEventModifier focusEventModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$all(focusEventModifier, function1);
        }

        @Deprecated
        public static boolean any(FocusEventModifier focusEventModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$any(focusEventModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(FocusEventModifier focusEventModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldIn(focusEventModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(FocusEventModifier focusEventModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldOut(focusEventModifier, r, function2);
        }

        @Deprecated
        public static Modifier then(FocusEventModifier focusEventModifier, Modifier modifier) {
            return Modifier.CC.$default$then(focusEventModifier, modifier);
        }
    }
}
