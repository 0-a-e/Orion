package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/interaction/PressInteraction;", "Landroidx/compose/foundation/interaction/Interaction;", "Cancel", "Press", "Release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PressInteraction.kt */
public interface PressInteraction extends Interaction {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/foundation/interaction/PressInteraction;", "pressPosition", "Landroidx/compose/ui/geometry/Offset;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPressPosition-F1C5BW0", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PressInteraction.kt */
    public static final class Press implements PressInteraction {
        public static final int $stable = 0;
        private final long pressPosition;

        public /* synthetic */ Press(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        private Press(long j) {
            this.pressPosition = j;
        }

        /* renamed from: getPressPosition-F1C5BW0  reason: not valid java name */
        public final long m502getPressPositionF1C5BW0() {
            return this.pressPosition;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/interaction/PressInteraction$Release;", "Landroidx/compose/foundation/interaction/PressInteraction;", "press", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PressInteraction.kt */
    public static final class Release implements PressInteraction {
        public static final int $stable = 0;
        private final Press press;

        public Release(Press press2) {
            this.press = press2;
        }

        public final Press getPress() {
            return this.press;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/interaction/PressInteraction$Cancel;", "Landroidx/compose/foundation/interaction/PressInteraction;", "press", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PressInteraction.kt */
    public static final class Cancel implements PressInteraction {
        public static final int $stable = 0;
        private final Press press;

        public Cancel(Press press2) {
            this.press = press2;
        }

        public final Press getPress() {
            return this.press;
        }
    }
}
