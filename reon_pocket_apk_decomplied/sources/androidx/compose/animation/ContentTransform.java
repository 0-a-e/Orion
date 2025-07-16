package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/ContentTransform;", "", "targetContentEnter", "Landroidx/compose/animation/EnterTransition;", "initialContentExit", "Landroidx/compose/animation/ExitTransition;", "targetContentZIndex", "", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;FLandroidx/compose/animation/SizeTransform;)V", "getInitialContentExit", "()Landroidx/compose/animation/ExitTransition;", "<set-?>", "getSizeTransform", "()Landroidx/compose/animation/SizeTransform;", "setSizeTransform$animation_release", "(Landroidx/compose/animation/SizeTransform;)V", "getTargetContentEnter", "()Landroidx/compose/animation/EnterTransition;", "getTargetContentZIndex", "()F", "setTargetContentZIndex", "(F)V", "targetContentZIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
public final class ContentTransform {
    public static final int $stable = 8;
    private final ExitTransition initialContentExit;
    private SizeTransform sizeTransform;
    private final EnterTransition targetContentEnter;
    private final MutableFloatState targetContentZIndex$delegate;

    public ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f, SizeTransform sizeTransform2) {
        this.targetContentEnter = enterTransition;
        this.initialContentExit = exitTransition;
        this.targetContentZIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.sizeTransform = sizeTransform2;
    }

    public final EnterTransition getTargetContentEnter() {
        return this.targetContentEnter;
    }

    public final ExitTransition getInitialContentExit() {
        return this.initialContentExit;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f, SizeTransform sizeTransform2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enterTransition, exitTransition, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? AnimatedContentKt.SizeTransform$default(false, (Function2) null, 3, (Object) null) : sizeTransform2);
    }

    public final float getTargetContentZIndex() {
        return this.targetContentZIndex$delegate.getFloatValue();
    }

    public final void setTargetContentZIndex(float f) {
        this.targetContentZIndex$delegate.setFloatValue(f);
    }

    public final SizeTransform getSizeTransform() {
        return this.sizeTransform;
    }

    public final void setSizeTransform$animation_release(SizeTransform sizeTransform2) {
        this.sizeTransform = sizeTransform2;
    }
}
