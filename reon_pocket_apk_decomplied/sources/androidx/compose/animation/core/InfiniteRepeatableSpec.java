package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\b\u0017\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J,\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\b\b\u0001\u0010\u001a*\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "T", "Landroidx/compose/animation/core/AnimationSpec;", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimation", "()Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "getInitialStartOffset-Rmkjzm4", "()J", "J", "getRepeatMode", "()Landroidx/compose/animation/core/RepeatMode;", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSpec.kt */
public final class InfiniteRepeatableSpec<T> implements AnimationSpec<T> {
    public static final int $stable = 8;
    private final DurationBasedAnimationSpec<T> animation;
    private final long initialStartOffset;
    private final RepeatMode repeatMode;

    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(durationBasedAnimationSpec, repeatMode2, j);
    }

    private InfiniteRepeatableSpec(DurationBasedAnimationSpec<T> durationBasedAnimationSpec, RepeatMode repeatMode2, long j) {
        this.animation = durationBasedAnimationSpec;
        this.repeatMode = repeatMode2;
        this.initialStartOffset = j;
    }

    public final DurationBasedAnimationSpec<T> getAnimation() {
        return this.animation;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(durationBasedAnimationSpec, (i & 2) != 0 ? RepeatMode.Restart : repeatMode2, (i & 4) != 0 ? StartOffset.m151constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null) : j, (DefaultConstructorMarker) null);
    }

    public final RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    /* renamed from: getInitialStartOffset-Rmkjzm4  reason: not valid java name */
    public final long m134getInitialStartOffsetRmkjzm4() {
        return this.initialStartOffset;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(durationBasedAnimationSpec, (i & 2) != 0 ? RepeatMode.Restart : repeatMode2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This constructor has been deprecated")
    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode2) {
        this(durationBasedAnimationSpec, repeatMode2, StartOffset.m151constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
    }

    public <V extends AnimationVector> VectorizedAnimationSpec<V> vectorize(TwoWayConverter<T, V> twoWayConverter) {
        return new VectorizedInfiniteRepeatableSpec<>((VectorizedDurationBasedAnimationSpec) this.animation.vectorize(twoWayConverter), this.repeatMode, this.initialStartOffset, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InfiniteRepeatableSpec)) {
            return false;
        }
        InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) obj;
        if (!Intrinsics.areEqual((Object) infiniteRepeatableSpec.animation, (Object) this.animation) || infiniteRepeatableSpec.repeatMode != this.repeatMode || !StartOffset.m153equalsimpl0(infiniteRepeatableSpec.initialStartOffset, this.initialStartOffset)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.animation.hashCode() * 31) + this.repeatMode.hashCode()) * 31) + StartOffset.m156hashCodeimpl(this.initialStartOffset);
    }
}
