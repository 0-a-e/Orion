package androidx.compose.material3;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:BA\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bB9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\"\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020!H@¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020)H@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020)H@¢\u0006\u0002\u0010.J\u000e\u00100\u001a\u00020)H@¢\u0006\u0002\u0010.J\b\u00101\u001a\u00020\u0005H\u0002J\u0006\u00102\u001a\u00020!J\u0018\u00103\u001a\u00020)2\u0006\u0010*\u001a\u00020!H@¢\u0006\u0004\b4\u00105J\u000e\u00106\u001a\u00020)H@¢\u0006\u0002\u0010.J\u0018\u00107\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0007H@¢\u0006\u0004\b8\u00109R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010!8@X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010&\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b'\u0010\u0015¨\u0006;"}, d2 = {"Landroidx/compose/material3/SheetState;", "", "skipPartiallyExpanded", "", "density", "Landroidx/compose/ui/unit/Density;", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "(ZLandroidx/compose/ui/unit/Density;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "(ZLandroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "anchoredDraggableState", "Landroidx/compose/material3/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/AnchoredDraggableState;", "setAnchoredDraggableState$material3_release", "(Landroidx/compose/material3/AnchoredDraggableState;)V", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3_release", "(Landroidx/compose/ui/unit/Density;)V", "hasExpandedState", "getHasExpandedState", "()Z", "hasPartiallyExpandedState", "getHasPartiallyExpandedState", "isVisible", "offset", "", "getOffset$material3_release", "()Ljava/lang/Float;", "getSkipHiddenState$material3_release", "getSkipPartiallyExpanded$material3_release", "targetValue", "getTargetValue", "animateTo", "", "velocity", "animateTo$material3_release", "(Landroidx/compose/material3/SheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hide", "partialExpand", "requireDensity", "requireOffset", "settle", "settle$material3_release", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "snapTo", "snapTo$material3_release", "(Landroidx/compose/material3/SheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
public final class SheetState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private AnchoredDraggableState<SheetValue> anchoredDraggableState;
    private Density density;
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;

    @Deprecated(message = "This constructor is deprecated. Please use the constructor that provides a [Density]", replaceWith = @ReplaceWith(expression = "SheetState(skipPartiallyExpanded, LocalDensity.current, initialValue, confirmValueChange, skipHiddenState)", imports = {}))
    public SheetState(boolean z, SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z2) {
        this.skipPartiallyExpanded = z;
        this.skipHiddenState = z2;
        if (z && sheetValue == SheetValue.PartiallyExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
        } else if (!z2 || sheetValue != SheetValue.Hidden) {
            SheetValue sheetValue2 = sheetValue;
            this.anchoredDraggableState = new AnchoredDraggableState(sheetValue2, new SheetState$anchoredDraggableState$1(this), new SheetState$anchoredDraggableState$2(this), AnchoredDraggableDefaults.INSTANCE.getAnimationSpec(), function1);
        } else {
            throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
        }
    }

    public final boolean getSkipPartiallyExpanded$material3_release() {
        return this.skipPartiallyExpanded;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SheetState(boolean z, SheetValue sheetValue, Function1 function1, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? SheetValue.Hidden : sheetValue, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function1, (i & 8) != 0 ? false : z2);
    }

    public final boolean getSkipHiddenState$material3_release() {
        return this.skipHiddenState;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SheetState(boolean z, Density density2, SheetValue sheetValue, Function1 function1, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, density2, (i & 4) != 0 ? SheetValue.Hidden : sheetValue, (i & 8) != 0 ? AnonymousClass2.INSTANCE : function1, (i & 16) != 0 ? false : z2);
    }

    public SheetState(boolean z, Density density2, SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z2) {
        this(z, sheetValue, function1, z2);
        this.density = density2;
    }

    public final SheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final SheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isVisible() {
        return this.anchoredDraggableState.getCurrentValue() != SheetValue.Hidden;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final boolean getHasExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.PartiallyExpanded);
    }

    public final Object expand(Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SheetValue.Expanded, 0.0f, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object partialExpand(Continuation<? super Unit> continuation) {
        if (!this.skipPartiallyExpanded) {
            Object animateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.PartiallyExpanded, 0.0f, continuation, 2, (Object) null);
            return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
        }
        throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
    }

    public final Object show(Continuation<? super Unit> continuation) {
        SheetValue sheetValue;
        if (getHasPartiallyExpandedState()) {
            sheetValue = SheetValue.PartiallyExpanded;
        } else {
            sheetValue = SheetValue.Expanded;
        }
        Object animateTo$material3_release$default = animateTo$material3_release$default(this, sheetValue, 0.0f, continuation, 2, (Object) null);
        return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> continuation) {
        if (!this.skipHiddenState) {
            Object animateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.Hidden, 0.0f, continuation, 2, (Object) null);
            return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
        }
        throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
    }

    public static /* synthetic */ Object animateTo$material3_release$default(SheetState sheetState, SheetValue sheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = sheetState.anchoredDraggableState.getLastVelocity();
        }
        return sheetState.animateTo$material3_release(sheetValue, f, continuation);
    }

    public final Object animateTo$material3_release(SheetValue sheetValue, float f, Continuation<? super Unit> continuation) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, sheetValue, f, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material3_release(SheetValue sheetValue, Continuation<? super Unit> continuation) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, sheetValue, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final Object settle$material3_release(float f, Continuation<? super Unit> continuation) {
        Object obj = this.anchoredDraggableState.settle(f, continuation);
        return obj == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }

    public final AnchoredDraggableState<SheetValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final void setAnchoredDraggableState$material3_release(AnchoredDraggableState<SheetValue> anchoredDraggableState2) {
        this.anchoredDraggableState = anchoredDraggableState2;
    }

    public final Float getOffset$material3_release() {
        return Float.valueOf(this.anchoredDraggableState.getOffset());
    }

    public final Density getDensity$material3_release() {
        return this.density;
    }

    public final void setDensity$material3_release(Density density2) {
        this.density = density2;
    }

    /* access modifiers changed from: private */
    public final Density requireDensity() {
        Density density2 = this.density;
        if (density2 != null) {
            return density2;
        }
        throw new IllegalArgumentException("SheetState did not have a density attached. Are you using SheetState with BottomSheetScaffold or ModalBottomSheet component?".toString());
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\nH\u0007J6\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Landroidx/compose/material3/SheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Landroidx/compose/material3/SheetValue;", "skipPartiallyExpanded", "", "confirmValueChange", "Lkotlin/Function1;", "density", "Landroidx/compose/ui/unit/Density;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SheetDefaults.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SheetState, SheetValue> Saver(boolean z, Function1<? super SheetValue, Boolean> function1, Density density) {
            return SaverKt.Saver(SheetState$Companion$Saver$1.INSTANCE, new SheetState$Companion$Saver$2(z, density, function1));
        }

        @Deprecated(message = "This function is deprecated. Please use the overload where Density is provided.", replaceWith = @ReplaceWith(expression = "Saver(skipPartiallyExpanded, confirmValueChange, LocalDensity.current)", imports = {}))
        public final Saver<SheetState, SheetValue> Saver(boolean z, Function1<? super SheetValue, Boolean> function1) {
            return SaverKt.Saver(SheetState$Companion$Saver$3.INSTANCE, new SheetState$Companion$Saver$4(z, function1));
        }
    }
}
