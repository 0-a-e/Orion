package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "distance", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class DrawerState$anchoredDraggableState$1 extends Lambda implements Function1<Float, Float> {
    public static final DrawerState$anchoredDraggableState$1 INSTANCE = new DrawerState$anchoredDraggableState$1();

    DrawerState$anchoredDraggableState$1() {
        super(1);
    }

    public final Float invoke(float f) {
        return Float.valueOf(f * NavigationDrawerKt.DrawerPositionalThreshold);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
