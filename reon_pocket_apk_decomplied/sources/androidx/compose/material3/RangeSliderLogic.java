package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/RangeSliderLogic;", "", "state", "Landroidx/compose/material3/RangeSliderState;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getEndInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getStartInteractionSource", "getState", "()Landroidx/compose/material3/RangeSliderState;", "activeInteraction", "draggingStart", "", "captureThumb", "", "posX", "", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "compareOffsets", "", "eventX", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class RangeSliderLogic {
    private final MutableInteractionSource endInteractionSource;
    private final MutableInteractionSource startInteractionSource;
    private final RangeSliderState state;

    public RangeSliderLogic(RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2) {
        this.state = rangeSliderState;
        this.startInteractionSource = mutableInteractionSource;
        this.endInteractionSource = mutableInteractionSource2;
    }

    public final RangeSliderState getState() {
        return this.state;
    }

    public final MutableInteractionSource getStartInteractionSource() {
        return this.startInteractionSource;
    }

    public final MutableInteractionSource getEndInteractionSource() {
        return this.endInteractionSource;
    }

    public final MutableInteractionSource activeInteraction(boolean z) {
        return z ? this.startInteractionSource : this.endInteractionSource;
    }

    public final int compareOffsets(float f) {
        return Float.compare(Math.abs(this.state.getRawOffsetStart$material3_release() - f), Math.abs(this.state.getRawOffsetEnd$material3_release() - f));
    }

    public final void captureThumb(boolean z, float f, Interaction interaction, CoroutineScope coroutineScope) {
        RangeSliderState rangeSliderState = this.state;
        rangeSliderState.onDrag$material3_release(z, f - (z ? rangeSliderState.getRawOffsetStart$material3_release() : rangeSliderState.getRawOffsetEnd$material3_release()));
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RangeSliderLogic$captureThumb$1(this, z, interaction, (Continuation<? super RangeSliderLogic$captureThumb$1>) null), 3, (Object) null);
    }
}
