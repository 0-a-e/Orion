package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 C2\u00020\u0001:\u0001CB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010=\u001a\u00020\u001cJ\u0018\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b@\u0010%J\u0006\u0010A\u001a\u00020\u001cJ\u0006\u0010B\u001a\u00020\u001cR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020!X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R1\u0010'\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!8F@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b*\u0010\u0015\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020-0,X\u0004¢\u0006\u0002\n\u0000R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u000bR\"\u00101\u001a\u00020!X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R+\u00104\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@BX\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<0,X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006D"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "appearanceSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getAppearanceSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAppearanceSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "", "isAppearanceAnimationInProgress", "()Z", "setAppearanceAnimationInProgress", "(Z)V", "isAppearanceAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "isPlacementAnimationInProgress$delegate", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "lookaheadOffset", "Landroidx/compose/ui/unit/IntOffset;", "getLookaheadOffset-nOcc-ac", "()J", "setLookaheadOffset--gyyYBs", "(J)V", "J", "placementDelta", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta$delegate", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "placementSpec", "getPlacementSpec", "setPlacementSpec", "rawOffset", "getRawOffset-nOcc-ac", "setRawOffset--gyyYBs", "visibility", "getVisibility", "()F", "setVisibility", "(F)V", "visibility$delegate", "Landroidx/compose/runtime/MutableFloatState;", "visibilityAnimation", "Landroidx/compose/animation/core/AnimationVector1D;", "animateAppearance", "animatePlacementDelta", "delta", "animatePlacementDelta--gyyYBs", "cancelPlacementAnimation", "stopAnimations", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutAnimation.kt */
public final class LazyLayoutAnimation {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private FiniteAnimationSpec<Float> appearanceSpec;
    private final CoroutineScope coroutineScope;
    private final MutableState isAppearanceAnimationInProgress$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState isPlacementAnimationInProgress$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Function1<GraphicsLayerScope, Unit> layerBlock;
    private long lookaheadOffset;
    private final MutableState placementDelta$delegate;
    /* access modifiers changed from: private */
    public final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    private long rawOffset;
    private final MutableFloatState visibility$delegate;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> visibilityAnimation;

    public LazyLayoutAnimation(CoroutineScope coroutineScope2) {
        this.coroutineScope = coroutineScope2;
        long j = NotInitialized;
        this.rawOffset = j;
        this.placementDeltaAnimation = new Animatable(IntOffset.m6739boximpl(IntOffset.Companion.m6758getZeronOccac()), VectorConvertersKt.getVectorConverter(IntOffset.Companion), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
        this.visibilityAnimation = new Animatable(Float.valueOf(1.0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
        this.placementDelta$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m6739boximpl(IntOffset.Companion.m6758getZeronOccac()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.visibility$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
        this.layerBlock = new LazyLayoutAnimation$layerBlock$1(this);
        this.lookaheadOffset = j;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final FiniteAnimationSpec<Float> getAppearanceSpec() {
        return this.appearanceSpec;
    }

    public final void setAppearanceSpec(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.appearanceSpec = finiteAnimationSpec;
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        this.placementSpec = finiteAnimationSpec;
    }

    /* access modifiers changed from: private */
    public final void setPlacementAnimationInProgress(boolean z) {
        this.isPlacementAnimationInProgress$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isPlacementAnimationInProgress() {
        return ((Boolean) this.isPlacementAnimationInProgress$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void setAppearanceAnimationInProgress(boolean z) {
        this.isAppearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isAppearanceAnimationInProgress() {
        return ((Boolean) this.isAppearanceAnimationInProgress$delegate.getValue()).booleanValue();
    }

    /* renamed from: getRawOffset-nOcc-ac  reason: not valid java name */
    public final long m858getRawOffsetnOccac() {
        return this.rawOffset;
    }

    /* renamed from: setRawOffset--gyyYBs  reason: not valid java name */
    public final void m860setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: setPlacementDelta--gyyYBs  reason: not valid java name */
    public final void m854setPlacementDeltagyyYBs(long j) {
        this.placementDelta$delegate.setValue(IntOffset.m6739boximpl(j));
    }

    /* renamed from: getPlacementDelta-nOcc-ac  reason: not valid java name */
    public final long m857getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta$delegate.getValue()).m6757unboximpl();
    }

    /* access modifiers changed from: private */
    public final void setVisibility(float f) {
        this.visibility$delegate.setFloatValue(f);
    }

    public final float getVisibility() {
        return this.visibility$delegate.getFloatValue();
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final void cancelPlacementAnimation() {
        if (isPlacementAnimationInProgress()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LazyLayoutAnimation$cancelPlacementAnimation$1(this, (Continuation<? super LazyLayoutAnimation$cancelPlacementAnimation$1>) null), 3, (Object) null);
        }
    }

    /* renamed from: getLookaheadOffset-nOcc-ac  reason: not valid java name */
    public final long m856getLookaheadOffsetnOccac() {
        return this.lookaheadOffset;
    }

    /* renamed from: setLookaheadOffset--gyyYBs  reason: not valid java name */
    public final void m859setLookaheadOffsetgyyYBs(long j) {
        this.lookaheadOffset = j;
    }

    /* renamed from: animatePlacementDelta--gyyYBs  reason: not valid java name */
    public final void m855animatePlacementDeltagyyYBs(long j) {
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec = this.placementSpec;
        if (finiteAnimationSpec != null) {
            long r0 = m857getPlacementDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r0) - IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(r0) - IntOffset.m6749getYimpl(j));
            m854setPlacementDeltagyyYBs(IntOffset);
            setPlacementAnimationInProgress(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LazyLayoutAnimation$animatePlacementDelta$1(this, finiteAnimationSpec, IntOffset, (Continuation<? super LazyLayoutAnimation$animatePlacementDelta$1>) null), 3, (Object) null);
        }
    }

    public final void animateAppearance() {
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.appearanceSpec;
        if (!isAppearanceAnimationInProgress() && finiteAnimationSpec != null) {
            setAppearanceAnimationInProgress(true);
            setVisibility(0.0f);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LazyLayoutAnimation$animateAppearance$1(this, finiteAnimationSpec, (Continuation<? super LazyLayoutAnimation$animateAppearance$1>) null), 3, (Object) null);
        }
    }

    public final void stopAnimations() {
        if (isPlacementAnimationInProgress()) {
            setPlacementAnimationInProgress(false);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LazyLayoutAnimation$stopAnimations$1(this, (Continuation<? super LazyLayoutAnimation$stopAnimations$1>) null), 3, (Object) null);
        }
        if (isAppearanceAnimationInProgress()) {
            setAppearanceAnimationInProgress(false);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LazyLayoutAnimation$stopAnimations$2(this, (Continuation<? super LazyLayoutAnimation$stopAnimations$2>) null), 3, (Object) null);
        }
        m854setPlacementDeltagyyYBs(IntOffset.Companion.m6758getZeronOccac());
        this.rawOffset = NotInitialized;
        setVisibility(1.0f);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation$Companion;", "", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutAnimation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNotInitialized-nOcc-ac  reason: not valid java name */
        public final long m861getNotInitializednOccac() {
            return LazyLayoutAnimation.NotInitialized;
        }
    }
}
