package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001aC\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122'\u0010\u0017\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0018H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\" \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c²\u0006\n\u0010\u001b\u001a\u00020\u0002X\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0002X\u0002"}, d2 = {"MagnifierSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierSpringSpec", "()Landroidx/compose/animation/core/SpringSpec;", "OffsetDisplacementThreshold", "getOffsetDisplacementThreshold", "()J", "J", "UnspecifiedAnimationVector2D", "Landroidx/compose/animation/core/AnimationVector2D;", "UnspecifiedSafeOffsetVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "getUnspecifiedSafeOffsetVectorConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "rememberAnimatedMagnifierPosition", "Landroidx/compose/runtime/State;", "targetCalculation", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animatedSelectionMagnifier", "Landroidx/compose/ui/Modifier;", "magnifierCenter", "platformMagnifier", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animatedCenter", "foundation_release", "targetValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionMagnifier.kt */
public final class SelectionMagnifierKt {
    private static final SpringSpec<Offset> MagnifierSpringSpec;
    private static final long OffsetDisplacementThreshold;
    /* access modifiers changed from: private */
    public static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);
    private static final TwoWayConverter<Offset, AnimationVector2D> UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1.INSTANCE, SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2.INSTANCE);

    static {
        long Offset = OffsetKt.Offset(0.01f, 0.01f);
        OffsetDisplacementThreshold = Offset;
        MagnifierSpringSpec = new SpringSpec(0.0f, 0.0f, Offset.m3551boximpl(Offset), 3, (DefaultConstructorMarker) null);
    }

    public static final TwoWayConverter<Offset, AnimationVector2D> getUnspecifiedSafeOffsetVectorConverter() {
        return UnspecifiedSafeOffsetVectorConverter;
    }

    public static final long getOffsetDisplacementThreshold() {
        return OffsetDisplacementThreshold;
    }

    public static final SpringSpec<Offset> getMagnifierSpringSpec() {
        return MagnifierSpringSpec;
    }

    public static final Modifier animatedSelectionMagnifier(Modifier modifier, Function0<Offset> function0, Function1<? super Function0<Offset>, ? extends Modifier> function1) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new SelectionMagnifierKt$animatedSelectionMagnifier$1(function0, function1), 1, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<androidx.compose.ui.geometry.Offset> rememberAnimatedMagnifierPosition(kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Offset> r9, androidx.compose.runtime.Composer r10, int r11) {
        /*
            r0 = -1589795249(0xffffffffa13da64f, float:-6.42558E-19)
            r10.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberAnimatedMagnifierPosition)77@2973L46,78@3041L208,82@3254L1186:SelectionMagnifier.kt#eksfi3"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:76)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r1, r2)
        L_0x0017:
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r11)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r1 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0035
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r9)
            r10.updateRememberedValue(r1)
        L_0x0035:
            r10.endReplaceableGroup()
            androidx.compose.runtime.State r1 = (androidx.compose.runtime.State) r1
            r10.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r9 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r9 != r11) goto L_0x006d
            androidx.compose.animation.core.Animatable r9 = new androidx.compose.animation.core.Animatable
            long r2 = rememberAnimatedMagnifierPosition$lambda$1(r1)
            androidx.compose.ui.geometry.Offset r3 = androidx.compose.ui.geometry.Offset.m3551boximpl(r2)
            androidx.compose.animation.core.TwoWayConverter r4 = getUnspecifiedSafeOffsetVectorConverter()
            long r5 = getOffsetDisplacementThreshold()
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m3551boximpl(r5)
            r7 = 8
            r8 = 0
            r6 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r10.updateRememberedValue(r9)
        L_0x006d:
            r10.endReplaceableGroup()
            androidx.compose.animation.core.Animatable r9 = (androidx.compose.animation.core.Animatable) r9
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1 r0 = new androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1
            r2 = 0
            r0.<init>(r1, r9, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 70
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r10, (int) r1)
            androidx.compose.runtime.State r9 = r9.asState()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x008e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x008e:
            r10.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionMagnifierKt.rememberAnimatedMagnifierPosition(kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    /* access modifiers changed from: private */
    public static final long rememberAnimatedMagnifierPosition$lambda$1(State<Offset> state) {
        return state.getValue().m3572unboximpl();
    }
}
