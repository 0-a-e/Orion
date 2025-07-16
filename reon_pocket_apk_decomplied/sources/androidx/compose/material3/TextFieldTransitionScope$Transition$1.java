package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope$Transition$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> $content;
    final /* synthetic */ Function3<InputPhase, Composer, Integer, Color> $contentColor;
    final /* synthetic */ long $focusedTextStyleColor;
    final /* synthetic */ InputPhase $inputState;
    final /* synthetic */ boolean $showLabel;
    final /* synthetic */ TextFieldTransitionScope $tmp0_rcvr;
    final /* synthetic */ long $unfocusedTextStyleColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldTransitionScope$Transition$1(TextFieldTransitionScope textFieldTransitionScope, InputPhase inputPhase, long j, long j2, Function3<? super InputPhase, ? super Composer, ? super Integer, Color> function3, boolean z, Function7<? super Float, ? super Color, ? super Color, ? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function7, int i) {
        super(2);
        this.$tmp0_rcvr = textFieldTransitionScope;
        this.$inputState = inputPhase;
        this.$focusedTextStyleColor = j;
        this.$unfocusedTextStyleColor = j2;
        this.$contentColor = function3;
        this.$showLabel = z;
        this.$content = function7;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.m2454TransitionDTcfvLk(this.$inputState, this.$focusedTextStyleColor, this.$unfocusedTextStyleColor, this.$contentColor, this.$showLabel, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
