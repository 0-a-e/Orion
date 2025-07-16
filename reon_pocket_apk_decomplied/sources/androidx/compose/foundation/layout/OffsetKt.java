package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a*\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"absoluteOffset", "Landroidx/compose/ui/Modifier;", "offset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "absoluteOffset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "offset-VpY3zN4", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Offset.kt */
public final class OffsetKt {
    /* renamed from: offset-VpY3zN4  reason: not valid java name */
    public static final Modifier m628offsetVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new OffsetElement(f, f2, true, new OffsetKt$offset$1(f, f2), (DefaultConstructorMarker) null));
    }

    /* renamed from: absoluteOffset-VpY3zN4  reason: not valid java name */
    public static final Modifier m626absoluteOffsetVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new OffsetElement(f, f2, false, new OffsetKt$absoluteOffset$1(f, f2), (DefaultConstructorMarker) null));
    }

    public static final Modifier offset(Modifier modifier, Function1<? super Density, IntOffset> function1) {
        return modifier.then(new OffsetPxElement(function1, true, new OffsetKt$offset$2(function1)));
    }

    public static final Modifier absoluteOffset(Modifier modifier, Function1<? super Density, IntOffset> function1) {
        return modifier.then(new OffsetPxElement(function1, false, new OffsetKt$absoluteOffset$2(function1)));
    }

    /* renamed from: offset-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m629offsetVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m6614constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m6614constructorimpl((float) 0);
        }
        return m628offsetVpY3zN4(modifier, f, f2);
    }

    /* renamed from: absoluteOffset-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m627absoluteOffsetVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m6614constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m6614constructorimpl((float) 0);
        }
        return m626absoluteOffsetVpY3zN4(modifier, f, f2);
    }
}
