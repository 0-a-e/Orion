package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001\u001a\u0001\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u001b\b\u0002\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a¬\u0001\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u001b\b\u0002\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\" \u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "isPlatformMagnifierSupported", "", "sdkVersion", "", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clip", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FJFFZ)Landroidx/compose/ui/Modifier;", "useTextDefault", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.android.kt */
public final class Magnifier_androidKt {
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", (Function2) null, 2, (DefaultConstructorMarker) null);

    public static final boolean isPlatformMagnifierSupported(int i) {
        return i >= 28;
    }

    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    /* renamed from: magnifier-UpNRX3w$default  reason: not valid java name */
    public static /* synthetic */ Modifier m287magnifierUpNRX3w$default(Modifier modifier, Function1 function1, Function1 function12, Function1 function13, float f, long j, float f2, float f3, boolean z, int i, Object obj) {
        int i2 = i;
        Function1 function14 = null;
        Function1 function15 = (i2 & 2) != 0 ? null : function12;
        if ((i2 & 4) == 0) {
            function14 = function13;
        }
        return m286magnifierUpNRX3w(modifier, function1, function15, function14, (i2 & 8) != 0 ? Float.NaN : f, (i2 & 16) != 0 ? DpSize.Companion.m6721getUnspecifiedMYxV2XQ() : j, (i2 & 32) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f2, (i2 & 64) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f3, (i2 & 128) != 0 ? true : z);
    }

    /* renamed from: magnifier-UpNRX3w  reason: not valid java name */
    public static final Modifier m286magnifierUpNRX3w(Modifier modifier, Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f, long j, float f2, float f3, boolean z) {
        return m289magnifierjPUL71Q$default(modifier, function1, function12, function13, f, false, j, f2, f3, z, (PlatformMagnifierFactory) null, 512, (Object) null);
    }

    /* renamed from: magnifier-jPUL71Q$default  reason: not valid java name */
    public static /* synthetic */ Modifier m289magnifierjPUL71Q$default(Modifier modifier, Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, Object obj) {
        int i2 = i;
        PlatformMagnifierFactory platformMagnifierFactory2 = null;
        Function1 function14 = (i2 & 2) != 0 ? null : function12;
        Function1 function15 = (i2 & 4) != 0 ? null : function13;
        float f4 = (i2 & 8) != 0 ? Float.NaN : f;
        boolean z3 = (i2 & 16) != 0 ? false : z;
        long r6 = (i2 & 32) != 0 ? DpSize.Companion.m6721getUnspecifiedMYxV2XQ() : j;
        float r8 = (i2 & 64) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f2;
        float r9 = (i2 & 128) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f3;
        boolean z4 = (i2 & 256) != 0 ? true : z2;
        if ((i2 & 512) == 0) {
            platformMagnifierFactory2 = platformMagnifierFactory;
        }
        return m288magnifierjPUL71Q(modifier, function1, function14, function15, f4, z3, r6, r8, r9, z4, platformMagnifierFactory2);
    }

    /* renamed from: magnifier-jPUL71Q  reason: not valid java name */
    public static final Modifier m288magnifierjPUL71Q(Modifier modifier, Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory) {
        Modifier modifier2 = modifier;
        if (isPlatformMagnifierSupported$default(0, 1, (Object) null)) {
            return modifier.then(new MagnifierElement(function1, function12, function13, f, z, j, f2, f3, z2, platformMagnifierFactory == null ? PlatformMagnifierFactory.Companion.getForCurrentPlatform() : platformMagnifierFactory, (DefaultConstructorMarker) null));
        }
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Magnifier_androidKt$magnifierjPUL71Q$$inlined$debugInspectorInfo$1(function1, function12, f, j, f2, f3, z2) : InspectableValueKt.getNoInspectorInfo(), Modifier.Companion);
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }
}
