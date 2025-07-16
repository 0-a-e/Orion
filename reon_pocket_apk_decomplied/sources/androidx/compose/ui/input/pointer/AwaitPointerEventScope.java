package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014JE\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\b\u001dH@¢\u0006\u0002\u0010\u001eJG\u0010\u001f\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\b\u001dH@¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00078VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006 À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendingPointerInputFilter.kt */
public interface AwaitPointerEventScope extends Density {
    Object awaitPointerEvent(PointerEventPass pointerEventPass, Continuation<? super PointerEvent> continuation);

    PointerEvent getCurrentEvent();

    /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
    long m5009getExtendedTouchPaddingNHjbRc();

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long m5010getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    <T> Object withTimeout(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    <T> Object withTimeoutOrNull(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SuspendingPointerInputFilter.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m5026roundToPxR2X_6o(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return Density.CC.m6554$default$roundToPxR2X_6o(awaitPointerEventScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m5027roundToPx0680j_4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return Density.CC.m6555$default$roundToPx0680j_4(awaitPointerEventScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m5028toDpGaN1DYA(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return FontScaling.CC.m6725$default$toDpGaN1DYA(awaitPointerEventScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5029toDpu2uoSUM(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return Density.CC.m6556$default$toDpu2uoSUM((Density) awaitPointerEventScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5030toDpu2uoSUM(AwaitPointerEventScope awaitPointerEventScope, int i) {
            return Density.CC.m6557$default$toDpu2uoSUM((Density) awaitPointerEventScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m5031toDpSizekrfVVM(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return Density.CC.m6558$default$toDpSizekrfVVM(awaitPointerEventScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m5032toPxR2X_6o(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return Density.CC.m6559$default$toPxR2X_6o(awaitPointerEventScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m5033toPx0680j_4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return Density.CC.m6560$default$toPx0680j_4(awaitPointerEventScope, f);
        }

        @Deprecated
        public static Rect toRect(AwaitPointerEventScope awaitPointerEventScope, DpRect dpRect) {
            return Density.CC.$default$toRect(awaitPointerEventScope, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m5034toSizeXkaWNTQ(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return Density.CC.m6561$default$toSizeXkaWNTQ(awaitPointerEventScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m5035toSp0xMU5do(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return FontScaling.CC.m6726$default$toSp0xMU5do(awaitPointerEventScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5036toSpkPz2Gy4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return Density.CC.m6562$default$toSpkPz2Gy4((Density) awaitPointerEventScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5037toSpkPz2Gy4(AwaitPointerEventScope awaitPointerEventScope, int i) {
            return Density.CC.m6563$default$toSpkPz2Gy4((Density) awaitPointerEventScope, i);
        }

        @Deprecated
        /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
        public static long m5025getExtendedTouchPaddingNHjbRc(AwaitPointerEventScope awaitPointerEventScope) {
            return CC.m5011$default$getExtendedTouchPaddingNHjbRc(awaitPointerEventScope);
        }

        @Deprecated
        public static <T> Object withTimeoutOrNull(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            return CC.$default$withTimeoutOrNull(awaitPointerEventScope, j, function2, continuation);
        }

        @Deprecated
        public static <T> Object withTimeout(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            return CC.$default$withTimeout(awaitPointerEventScope, j, function2, continuation);
        }
    }

    /* renamed from: androidx.compose.ui.input.pointer.AwaitPointerEventScope$-CC  reason: invalid class name */
    /* compiled from: SuspendingPointerInputFilter.kt */
    public final /* synthetic */ class CC {
        public static Object $default$withTimeout(AwaitPointerEventScope _this, long j, Function2 function2, Continuation continuation) {
            return function2.invoke(_this, continuation);
        }

        public static Object $default$withTimeoutOrNull(AwaitPointerEventScope _this, long j, Function2 function2, Continuation continuation) {
            return function2.invoke(_this, continuation);
        }

        /* renamed from: $default$getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
        public static long m5011$default$getExtendedTouchPaddingNHjbRc(AwaitPointerEventScope _this) {
            return Size.Companion.m3640getZeroNHjbRc();
        }

        public static /* synthetic */ Object awaitPointerEvent$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    pointerEventPass = PointerEventPass.Main;
                }
                return awaitPointerEventScope.awaitPointerEvent(pointerEventPass, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        }
    }
}
