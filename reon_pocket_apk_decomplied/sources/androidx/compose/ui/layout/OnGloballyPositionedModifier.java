package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "Landroidx/compose/ui/Modifier$Element;", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OnGloballyPositionedModifier.kt */
public interface OnGloballyPositionedModifier extends Modifier.Element {

    /* renamed from: androidx.compose.ui.layout.OnGloballyPositionedModifier$-CC  reason: invalid class name */
    /* compiled from: OnGloballyPositionedModifier.kt */
    public final /* synthetic */ class CC {
    }

    void onGloballyPositioned(LayoutCoordinates layoutCoordinates);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OnGloballyPositionedModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(OnGloballyPositionedModifier onGloballyPositionedModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$all(onGloballyPositionedModifier, function1);
        }

        @Deprecated
        public static boolean any(OnGloballyPositionedModifier onGloballyPositionedModifier, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$any(onGloballyPositionedModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(OnGloballyPositionedModifier onGloballyPositionedModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldIn(onGloballyPositionedModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(OnGloballyPositionedModifier onGloballyPositionedModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return Modifier.Element.CC.$default$foldOut(onGloballyPositionedModifier, r, function2);
        }

        @Deprecated
        public static Modifier then(OnGloballyPositionedModifier onGloballyPositionedModifier, Modifier modifier) {
            return Modifier.CC.$default$then(onGloballyPositionedModifier, modifier);
        }
    }
}
