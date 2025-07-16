package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032A\u0010\u0004\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006E\u0010\u0010\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u0002"}, d2 = {"PredictiveBackHandler", "", "enabled", "", "onBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PredictiveBackHandler.kt */
public final class PredictiveBackHandlerKt {
    public static final void PredictiveBackHandler(boolean z, Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-642000585);
        ComposerKt.sourceInformation(startRestartGroup, "C(PredictiveBackHandler)77@3028L28,78@3079L24,80@3128L2068,128@5226L48,128@5202L72,*132@5348L7,136@5536L7,138@5598L137,138@5549L186:PredictiveBackHandler.kt#q1dkbc");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) function2) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                z = true;
            }
            State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i3 >> 3) & 14);
            startRestartGroup.startReplaceableGroup(-723524056);
            ComposerKt.sourceInformation(startRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1071578902);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PredictiveBackHandler.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1(z, coroutineScope, rememberUpdatedState);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 = (PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            Boolean valueOf = Boolean.valueOf(z);
            startRestartGroup.startReplaceableGroup(-1071576804);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PredictiveBackHandler.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1) | startRestartGroup.changed(z);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new PredictiveBackHandlerKt$PredictiveBackHandler$1$1(predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1, z, (Continuation<? super PredictiveBackHandlerKt$PredictiveBackHandler$1$1>) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue3, startRestartGroup, i3 & 14);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, 6);
            if (current != null) {
                OnBackPressedDispatcher onBackPressedDispatcher = current.getOnBackPressedDispatcher();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
                startRestartGroup.startReplaceableGroup(-1071576432);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):PredictiveBackHandler.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed((Object) onBackPressedDispatcher) | startRestartGroup.changed((Object) lifecycleOwner) | startRestartGroup.changed((Object) predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new PredictiveBackHandlerKt$PredictiveBackHandler$2$1(onBackPressedDispatcher, lifecycleOwner, predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(lifecycleOwner, onBackPressedDispatcher, (Function1) rememberedValue4, startRestartGroup, 0);
            } else {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PredictiveBackHandlerKt$PredictiveBackHandler$3(z, function2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final Function2<Flow<BackEventCompat>, Continuation<Unit>, Object> PredictiveBackHandler$lambda$0(State<? extends Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object>> state) {
        return (Function2) state.getValue();
    }
}
