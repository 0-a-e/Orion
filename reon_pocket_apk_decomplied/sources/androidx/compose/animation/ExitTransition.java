package androidx.compose.animation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0011\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/ExitTransition;", "", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "equals", "", "other", "hashCode", "", "plus", "exit", "toString", "", "Companion", "Landroidx/compose/animation/ExitTransitionImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
public abstract class ExitTransition {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ExitTransition KeepUntilTransitionsFinished = new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, true, (Map) null, 47, (DefaultConstructorMarker) null));
    /* access modifiers changed from: private */
    public static final ExitTransition None = new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, false, (Map) null, 63, (DefaultConstructorMarker) null));

    public /* synthetic */ ExitTransition(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract TransitionData getData$animation_release();

    private ExitTransition() {
    }

    public final ExitTransition plus(ExitTransition exitTransition) {
        Fade fade = getData$animation_release().getFade();
        if (fade == null) {
            fade = exitTransition.getData$animation_release().getFade();
        }
        Fade fade2 = fade;
        Slide slide = getData$animation_release().getSlide();
        if (slide == null) {
            slide = exitTransition.getData$animation_release().getSlide();
        }
        Slide slide2 = slide;
        ChangeSize changeSize = getData$animation_release().getChangeSize();
        if (changeSize == null) {
            changeSize = exitTransition.getData$animation_release().getChangeSize();
        }
        ChangeSize changeSize2 = changeSize;
        Scale scale = getData$animation_release().getScale();
        if (scale == null) {
            scale = exitTransition.getData$animation_release().getScale();
        }
        return new ExitTransitionImpl(new TransitionData(fade2, slide2, changeSize2, scale, getData$animation_release().getHold() || exitTransition.getData$animation_release().getHold(), MapsKt.plus(getData$animation_release().getEffectsMap(), exitTransition.getData$animation_release().getEffectsMap())));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ExitTransition) && Intrinsics.areEqual((Object) ((ExitTransition) obj).getData$animation_release(), (Object) getData$animation_release());
    }

    public String toString() {
        if (Intrinsics.areEqual((Object) this, (Object) None)) {
            return "ExitTransition.None";
        }
        if (Intrinsics.areEqual((Object) this, (Object) KeepUntilTransitionsFinished)) {
            return "ExitTransition.KeepUntilTransitionsFinished";
        }
        TransitionData data$animation_release = getData$animation_release();
        StringBuilder sb = new StringBuilder("ExitTransition: \nFade - ");
        Fade fade = data$animation_release.getFade();
        String str = null;
        sb.append(fade != null ? fade.toString() : null);
        sb.append(",\nSlide - ");
        Slide slide = data$animation_release.getSlide();
        sb.append(slide != null ? slide.toString() : null);
        sb.append(",\nShrink - ");
        ChangeSize changeSize = data$animation_release.getChangeSize();
        sb.append(changeSize != null ? changeSize.toString() : null);
        sb.append(",\nScale - ");
        Scale scale = data$animation_release.getScale();
        if (scale != null) {
            str = scale.toString();
        }
        sb.append(str);
        sb.append(",\nKeepUntilTransitionsFinished - ");
        sb.append(data$animation_release.getHold());
        return sb.toString();
    }

    public int hashCode() {
        return getData$animation_release().hashCode();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/animation/ExitTransition$Companion;", "", "()V", "KeepUntilTransitionsFinished", "Landroidx/compose/animation/ExitTransition;", "getKeepUntilTransitionsFinished$animation_release", "()Landroidx/compose/animation/ExitTransition;", "None", "getNone", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: EnterExitTransition.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExitTransition getNone() {
            return ExitTransition.None;
        }

        public final ExitTransition getKeepUntilTransitionsFinished$animation_release() {
            return ExitTransition.KeepUntilTransitionsFinished;
        }
    }
}
