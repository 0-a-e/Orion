package androidx.activity.compose;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\u0010\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0002"}, d2 = {"BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackHandler.kt */
public final class BackHandlerKt {
    public static final void BackHandler(boolean z, Function0<Unit> function0, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-361453782);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackHandler)83@3458L28,85@3588L171,93@3860L48,93@3849L59,*96@3981L7,99@4160L7,100@4221L253,100@4172L302:BackHandler.kt#q1dkbc");
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
            i3 |= startRestartGroup.changed((Object) function0) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                z = true;
            }
            State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, startRestartGroup, (i3 >> 3) & 14);
            startRestartGroup.startReplaceableGroup(-971159753);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BackHandler.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BackHandlerKt$BackHandler$backCallback$1$1(z, rememberUpdatedState);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1 = (BackHandlerKt$BackHandler$backCallback$1$1) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-971159481);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BackHandler.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) backHandlerKt$BackHandler$backCallback$1$1) | startRestartGroup.changed(z);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new BackHandlerKt$BackHandler$1$1(backHandlerKt$BackHandler$backCallback$1$1, z);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, 6);
            if (current != null) {
                OnBackPressedDispatcher onBackPressedDispatcher = current.getOnBackPressedDispatcher();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
                startRestartGroup.startReplaceableGroup(-971159120);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BackHandler.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed((Object) onBackPressedDispatcher) | startRestartGroup.changed((Object) lifecycleOwner) | startRestartGroup.changed((Object) backHandlerKt$BackHandler$backCallback$1$1);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new BackHandlerKt$BackHandler$2$1(onBackPressedDispatcher, lifecycleOwner, backHandlerKt$BackHandler$backCallback$1$1);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(lifecycleOwner, onBackPressedDispatcher, (Function1) rememberedValue3, startRestartGroup, 0);
            } else {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackHandlerKt$BackHandler$3(z, function0, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final Function0<Unit> BackHandler$lambda$0(State<? extends Function0<Unit>> state) {
        return (Function0) state.getValue();
    }
}
