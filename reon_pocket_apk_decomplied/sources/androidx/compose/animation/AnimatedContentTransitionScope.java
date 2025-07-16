package androidx.compose.animation;

import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001#JO\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJO\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112#\b\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H&ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020 *\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H¦\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0001\u0001$ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "KeepUntilTransitionsFinished", "Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/animation/ExitTransition$Companion;", "getKeepUntilTransitionsFinished", "(Landroidx/compose/animation/ExitTransition$Companion;)Landroidx/compose/animation/ExitTransition;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "SlideDirection", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
public interface AnimatedContentTransitionScope<S> extends Transition.Segment<S> {
    Alignment getContentAlignment();

    ExitTransition getKeepUntilTransitionsFinished(ExitTransition.Companion companion);

    /* renamed from: slideIntoContainer-mOhB8PU  reason: not valid java name */
    EnterTransition m37slideIntoContainermOhB8PU(int i, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1);

    /* renamed from: slideOutOfContainer-mOhB8PU  reason: not valid java name */
    ExitTransition m38slideOutOfContainermOhB8PU(int i, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1);

    ContentTransform using(ContentTransform contentTransform, SizeTransform sizeTransform);

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimatedContent.kt */
    public static final class SlideDirection {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int Down = m42constructorimpl(3);
        /* access modifiers changed from: private */
        public static final int End = m42constructorimpl(5);
        /* access modifiers changed from: private */
        public static final int Left = m42constructorimpl(0);
        /* access modifiers changed from: private */
        public static final int Right = m42constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int Start = m42constructorimpl(4);
        /* access modifiers changed from: private */
        public static final int Up = m42constructorimpl(2);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ SlideDirection m41boximpl(int i) {
            return new SlideDirection(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m42constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m43equalsimpl(int i, Object obj) {
            return (obj instanceof SlideDirection) && i == ((SlideDirection) obj).m47unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m44equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m45hashCodeimpl(int i) {
            return i;
        }

        public boolean equals(Object obj) {
            return m43equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m45hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m47unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection$Companion;", "", "()V", "Down", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "getDown-DKzdypw", "()I", "I", "End", "getEnd-DKzdypw", "Left", "getLeft-DKzdypw", "Right", "getRight-DKzdypw", "Start", "getStart-DKzdypw", "Up", "getUp-DKzdypw", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnimatedContent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getLeft-DKzdypw  reason: not valid java name */
            public final int m50getLeftDKzdypw() {
                return SlideDirection.Left;
            }

            /* renamed from: getRight-DKzdypw  reason: not valid java name */
            public final int m51getRightDKzdypw() {
                return SlideDirection.Right;
            }

            /* renamed from: getUp-DKzdypw  reason: not valid java name */
            public final int m53getUpDKzdypw() {
                return SlideDirection.Up;
            }

            /* renamed from: getDown-DKzdypw  reason: not valid java name */
            public final int m48getDownDKzdypw() {
                return SlideDirection.Down;
            }

            /* renamed from: getStart-DKzdypw  reason: not valid java name */
            public final int m52getStartDKzdypw() {
                return SlideDirection.Start;
            }

            /* renamed from: getEnd-DKzdypw  reason: not valid java name */
            public final int m49getEndDKzdypw() {
                return SlideDirection.End;
            }
        }

        private /* synthetic */ SlideDirection(int i) {
            this.value = i;
        }

        public String toString() {
            return m46toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m46toStringimpl(int i) {
            if (m44equalsimpl0(i, Left)) {
                return "Left";
            }
            if (m44equalsimpl0(i, Right)) {
                return "Right";
            }
            if (m44equalsimpl0(i, Up)) {
                return "Up";
            }
            if (m44equalsimpl0(i, Down)) {
                return "Down";
            }
            if (m44equalsimpl0(i, Start)) {
                return "Start";
            }
            if (m44equalsimpl0(i, End)) {
                return "End";
            }
            return "Invalid";
        }
    }

    /* renamed from: androidx.compose.animation.AnimatedContentTransitionScope$-CC  reason: invalid class name */
    /* compiled from: AnimatedContent.kt */
    public final /* synthetic */ class CC {
        /* renamed from: slideIntoContainer-mOhB8PU$default  reason: not valid java name */
        public static /* synthetic */ EnterTransition m39slideIntoContainermOhB8PU$default(AnimatedContentTransitionScope animatedContentTransitionScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
                }
                if ((i2 & 4) != 0) {
                    function1 = AnimatedContentTransitionScope$slideIntoContainer$1.INSTANCE;
                }
                return animatedContentTransitionScope.m37slideIntoContainermOhB8PU(i, finiteAnimationSpec, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideIntoContainer-mOhB8PU");
        }

        /* renamed from: slideOutOfContainer-mOhB8PU$default  reason: not valid java name */
        public static /* synthetic */ ExitTransition m40slideOutOfContainermOhB8PU$default(AnimatedContentTransitionScope animatedContentTransitionScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
                }
                if ((i2 & 4) != 0) {
                    function1 = AnimatedContentTransitionScope$slideOutOfContainer$1.INSTANCE;
                }
                return animatedContentTransitionScope.m38slideOutOfContainermOhB8PU(i, finiteAnimationSpec, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideOutOfContainer-mOhB8PU");
        }

        public static ExitTransition $default$getKeepUntilTransitionsFinished(AnimatedContentTransitionScope _this, ExitTransition.Companion companion) {
            return companion.getKeepUntilTransitionsFinished$animation_release();
        }
    }
}
