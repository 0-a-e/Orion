package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aH\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0004X\u0002"}, d2 = {"animateBorderStrokeAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release", "focused"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaultsKt {
    /* access modifiers changed from: private */
    /* renamed from: animateBorderStrokeAsState-NuRrP5Q  reason: not valid java name */
    public static final State<BorderStroke> m2444animateBorderStrokeAsStateNuRrP5Q(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, Composer composer, int i) {
        State<Dp> state;
        composer.startReplaceableGroup(-1633063017);
        ComposerKt.sourceInformation(composer, "C(animateBorderStrokeAsState)P(1,4,3!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)2387@128548L25,2388@128606L51,2395@128963L107:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1633063017, i, -1, "androidx.compose.material3.animateBorderStrokeAsState (TextFieldDefaults.kt:2386)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        State<Color> indicatorColor$material3_release = textFieldColors.indicatorColor$material3_release(z, z2, interactionSource, composer, i & 8190);
        float f3 = animateBorderStrokeAsState_NuRrP5Q$lambda$0(collectIsFocusedAsState) ? f : f2;
        if (z) {
            composer.startReplaceableGroup(-1927721478);
            ComposerKt.sourceInformation(composer, "2391@128801L76");
            state = AnimateAsStateKt.m119animateDpAsStateAjpBEmI(f3, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Dp, Unit>) null, composer, 48, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1927721380);
            ComposerKt.sourceInformation(composer, "2393@128899L46");
            state = SnapshotStateKt.rememberUpdatedState(Dp.m6612boximpl(f2), composer, (i >> 15) & 14);
            composer.endReplaceableGroup();
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new BorderStroke(state.getValue().m6628unboximpl(), new SolidColor(indicatorColor$material3_release.getValue().m3826unboximpl(), (DefaultConstructorMarker) null), (DefaultConstructorMarker) null), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean animateBorderStrokeAsState_NuRrP5Q$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
