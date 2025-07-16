package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "screen", "", "", "invoke", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$ClockFace$2 extends Lambda implements Function3<List<? extends Integer>, Composer, Integer, Unit> {
    final /* synthetic */ boolean $autoSwitchToMinute;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockFace$2(TimePickerState timePickerState, boolean z, TimePickerColors timePickerColors) {
        super(3);
        this.$state = timePickerState;
        this.$autoSwitchToMinute = z;
        this.$colors = timePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((List<Integer>) (List) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final List<Integer> list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1348@53705L2099:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1628166511, i, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1348)");
        }
        Modifier access$drawSelector = TimePickerKt.drawSelector(SizeKt.m742size3ABfNKs(Modifier.Companion.then(new ClockDialModifier(this.$state, this.$autoSwitchToMinute)), TimePickerTokens.INSTANCE.m3179getClockDialContainerSizeD9Ej5fM()), this.$state, this.$colors);
        float access$getOuterCircleSizeRadius$p = TimePickerKt.OuterCircleSizeRadius;
        final TimePickerColors timePickerColors = this.$colors;
        final TimePickerState timePickerState = this.$state;
        final boolean z = this.$autoSwitchToMinute;
        TimePickerKt.m2482CircularLayoutuFdPcIQ(access$drawSelector, access$getOuterCircleSizeRadius$p, ComposableLambdaKt.composableLambda(composer, -1385633737, true, new Function2<Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C1355@53981L1813:TimePicker.kt#uh7d8r");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1385633737, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1355)");
                    }
                    ProvidedValue<Color> provides = ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(timePickerColors.m2460clockDialContentColorvNxB06k$material3_release(false)));
                    final List<Integer> list = list;
                    final TimePickerState timePickerState = timePickerState;
                    final boolean z = z;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -2018362505, true, new Function2<Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            int i2;
                            ComposerKt.sourceInformation(composer, "C1375@54838L924:TimePicker.kt#uh7d8r");
                            if ((i & 3) != 2 || !composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2018362505, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1358)");
                                }
                                composer.startReplaceableGroup(-504293055);
                                ComposerKt.sourceInformation(composer, "*1365@54465L88,1364@54400L323");
                                int size = list.size();
                                TimePickerState timePickerState = timePickerState;
                                List<Integer> list = list;
                                boolean z = z;
                                for (int i3 = 0; i3 < size; i3++) {
                                    if (!timePickerState.is24hour() || Selection.m2164equalsimpl0(timePickerState.m2507getSelectionJiIwxys$material3_release(), Selection.Companion.m2169getMinuteJiIwxys())) {
                                        i2 = list.get(i3).intValue();
                                    } else {
                                        i2 = list.get(i3).intValue() % 12;
                                    }
                                    int i4 = i2;
                                    Modifier modifier = Modifier.Companion;
                                    composer.startReplaceableGroup(-1916851139);
                                    ComposerKt.sourceInformation(composer, "CC(remember):TimePicker.kt#9igjgp");
                                    boolean changed = composer.changed(i3);
                                    Object rememberedValue = composer.rememberedValue();
                                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new TimePickerKt$ClockFace$2$1$1$1$1$1(i3);
                                        composer.updateRememberedValue(rememberedValue);
                                    }
                                    composer.endReplaceableGroup();
                                    TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null), timePickerState, i4, z, composer, 0);
                                }
                                composer.endReplaceableGroup();
                                if (Selection.m2164equalsimpl0(timePickerState.m2507getSelectionJiIwxys$material3_release(), Selection.Companion.m2168getHourJiIwxys()) && timePickerState.is24hour()) {
                                    Modifier r4 = BackgroundKt.m213backgroundbw27NRU(SizeKt.m742size3ABfNKs(LayoutIdKt.layoutId(Modifier.Companion, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m3179getClockDialContainerSizeD9Ej5fM()), Color.Companion.m3851getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                                    float access$getInnerCircleRadius$p = TimePickerKt.InnerCircleRadius;
                                    final TimePickerState timePickerState2 = timePickerState;
                                    final boolean z2 = z;
                                    TimePickerKt.m2482CircularLayoutuFdPcIQ(r4, access$getInnerCircleRadius$p, ComposableLambdaKt.composableLambda(composer, -448649404, true, new Function2<Composer, Integer, Unit>() {
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer, int i) {
                                            ComposerKt.sourceInformation(composer, "C*1385@55403L109,1384@55330L384:TimePicker.kt#uh7d8r");
                                            if ((i & 3) != 2 || !composer.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-448649404, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1382)");
                                                }
                                                int size = TimePickerKt.ExtraHours.size();
                                                TimePickerState timePickerState = timePickerState2;
                                                boolean z = z2;
                                                for (int i2 = 0; i2 < size; i2++) {
                                                    int intValue = ((Number) TimePickerKt.ExtraHours.get(i2)).intValue();
                                                    Modifier modifier = Modifier.Companion;
                                                    composer.startReplaceableGroup(-1469917176);
                                                    ComposerKt.sourceInformation(composer, "CC(remember):TimePicker.kt#9igjgp");
                                                    boolean changed = composer.changed(i2);
                                                    Object rememberedValue = composer.rememberedValue();
                                                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                                        rememberedValue = new TimePickerKt$ClockFace$2$1$1$2$1$1$1(i2);
                                                        composer.updateRememberedValue(rememberedValue);
                                                    }
                                                    composer.endReplaceableGroup();
                                                    TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null), timePickerState, intValue, z, composer, 0);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer.skipToGroupEnd();
                                        }
                                    }), composer, 432, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer.skipToGroupEnd();
                        }
                    }), composer, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), composer, 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
