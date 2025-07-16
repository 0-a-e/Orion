package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import androidx.core.view.PointerIconCompat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0002J(\u0010#\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\f\u0010$\u001a\u00020\u001e*\u00020%H\u0016J\f\u0010&\u001a\u00020\u001e*\u00020'H\u0016R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R1\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158B@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/text2/input/internal/selection/TextFieldMagnifierNodeImpl28;", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldMagnifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "isFocused", "", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Z)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "animationJob", "Lkotlinx/coroutines/Job;", "magnifierNode", "Landroidx/compose/foundation/MagnifierNode;", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "magnifierSize", "getMagnifierSize-YbymL2g", "()J", "setMagnifierSize-ozmzZPI", "(J)V", "magnifierSize$delegate", "Landroidx/compose/runtime/MutableState;", "onAttach", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "restartAnimationJob", "update", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextFieldMagnifier.android.kt */
public final class TextFieldMagnifierNodeImpl28 extends TextFieldMagnifierNode implements CompositionLocalConsumerModifierNode {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public final Animatable<Offset, AnimationVector2D> animatable = new Animatable(Offset.m3551boximpl(TextFieldMagnifierKt.m1440calculateSelectionMagnifierCenterAndroidhUlJWOE(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, m1443getMagnifierSizeYbymL2g())), SelectionMagnifierKt.getUnspecifiedSafeOffsetVectorConverter(), Offset.m3551boximpl(SelectionMagnifierKt.getOffsetDisplacementThreshold()), (String) null, 8, (DefaultConstructorMarker) null);
    private Job animationJob;
    private boolean isFocused;
    private final MagnifierNode magnifierNode = ((MagnifierNode) delegate(new MagnifierNode(new TextFieldMagnifierNodeImpl28$magnifierNode$1(this), (Function1) null, new TextFieldMagnifierNodeImpl28$magnifierNode$2(this), 0.0f, true, 0, 0.0f, 0.0f, false, (PlatformMagnifierFactory) null, PointerIconCompat.TYPE_HAND, (DefaultConstructorMarker) null)));
    private final MutableState magnifierSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m6782boximpl(IntSize.Companion.m6795getZeroYbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public TextFieldSelectionState textFieldSelectionState;
    /* access modifiers changed from: private */
    public TransformedTextFieldState textFieldState;
    /* access modifiers changed from: private */
    public TextLayoutState textLayoutState;

    public TextFieldMagnifierNodeImpl28(TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, TextLayoutState textLayoutState2, boolean z) {
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.textLayoutState = textLayoutState2;
        this.isFocused = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: getMagnifierSize-YbymL2g  reason: not valid java name */
    public final long m1443getMagnifierSizeYbymL2g() {
        return ((IntSize) this.magnifierSize$delegate.getValue()).m6794unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: setMagnifierSize-ozmzZPI  reason: not valid java name */
    public final void m1444setMagnifierSizeozmzZPI(long j) {
        this.magnifierSize$delegate.setValue(IntSize.m6782boximpl(j));
    }

    public void onAttach() {
        restartAnimationJob();
    }

    public void update(TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, TextLayoutState textLayoutState2, boolean z) {
        TransformedTextFieldState transformedTextFieldState2 = this.textFieldState;
        TextFieldSelectionState textFieldSelectionState3 = this.textFieldSelectionState;
        TextLayoutState textLayoutState3 = this.textLayoutState;
        boolean z2 = this.isFocused;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.textLayoutState = textLayoutState2;
        this.isFocused = z;
        if (!Intrinsics.areEqual((Object) transformedTextFieldState, (Object) transformedTextFieldState2) || !Intrinsics.areEqual((Object) textFieldSelectionState2, (Object) textFieldSelectionState3) || !Intrinsics.areEqual((Object) textLayoutState2, (Object) textLayoutState3) || z != z2) {
            restartAnimationJob();
        }
    }

    private final void restartAnimationJob() {
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
        if (this.isFocused && Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, (Object) null)) {
            this.animationJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldMagnifierNodeImpl28$restartAnimationJob$1(this, (Continuation<? super TextFieldMagnifierNodeImpl28$restartAnimationJob$1>) null), 3, (Object) null);
        }
    }

    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        this.magnifierNode.draw(contentDrawScope);
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        this.magnifierNode.onGloballyPositioned(layoutCoordinates);
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.magnifierNode.applySemantics(semanticsPropertyReceiver);
    }
}
