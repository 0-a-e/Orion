package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0013\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "", "visible", "", "position", "Landroidx/compose/ui/geometry/Offset;", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "(ZJLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getHandlesCrossed", "()Z", "getPosition-F1C5BW0", "()J", "J", "getVisible", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "copy", "copy-ubNVwUQ", "(ZJLandroidx/compose/ui/text/style/ResolvedTextDirection;Z)Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "equals", "other", "hashCode", "", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldHandleState.kt */
public final class TextFieldHandleState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TextFieldHandleState Hidden = new TextFieldHandleState(false, Offset.Companion.m3577getUnspecifiedF1C5BW0(), ResolvedTextDirection.Ltr, false, (DefaultConstructorMarker) null);
    private final ResolvedTextDirection direction;
    private final boolean handlesCrossed;
    private final long position;
    private final boolean visible;

    public /* synthetic */ TextFieldHandleState(boolean z, long j, ResolvedTextDirection resolvedTextDirection, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, resolvedTextDirection, z2);
    }

    /* renamed from: copy-ubNVwUQ$default  reason: not valid java name */
    public static /* synthetic */ TextFieldHandleState m1436copyubNVwUQ$default(TextFieldHandleState textFieldHandleState, boolean z, long j, ResolvedTextDirection resolvedTextDirection, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = textFieldHandleState.visible;
        }
        if ((i & 2) != 0) {
            j = textFieldHandleState.position;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            resolvedTextDirection = textFieldHandleState.direction;
        }
        ResolvedTextDirection resolvedTextDirection2 = resolvedTextDirection;
        if ((i & 8) != 0) {
            z2 = textFieldHandleState.handlesCrossed;
        }
        return textFieldHandleState.m1438copyubNVwUQ(z, j2, resolvedTextDirection2, z2);
    }

    public final boolean component1() {
        return this.visible;
    }

    /* renamed from: component2-F1C5BW0  reason: not valid java name */
    public final long m1437component2F1C5BW0() {
        return this.position;
    }

    public final ResolvedTextDirection component3() {
        return this.direction;
    }

    public final boolean component4() {
        return this.handlesCrossed;
    }

    /* renamed from: copy-ubNVwUQ  reason: not valid java name */
    public final TextFieldHandleState m1438copyubNVwUQ(boolean z, long j, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        return new TextFieldHandleState(z, j, resolvedTextDirection, z2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldHandleState)) {
            return false;
        }
        TextFieldHandleState textFieldHandleState = (TextFieldHandleState) obj;
        return this.visible == textFieldHandleState.visible && Offset.m3559equalsimpl0(this.position, textFieldHandleState.position) && this.direction == textFieldHandleState.direction && this.handlesCrossed == textFieldHandleState.handlesCrossed;
    }

    public int hashCode() {
        return (((((UByte$$ExternalSyntheticBackport0.m(this.visible) * 31) + Offset.m3564hashCodeimpl(this.position)) * 31) + this.direction.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.handlesCrossed);
    }

    public String toString() {
        return "TextFieldHandleState(visible=" + this.visible + ", position=" + Offset.m3570toStringimpl(this.position) + ", direction=" + this.direction + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    private TextFieldHandleState(boolean z, long j, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        this.visible = z;
        this.position = j;
        this.direction = resolvedTextDirection;
        this.handlesCrossed = z2;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m1439getPositionF1C5BW0() {
        return this.position;
    }

    public final ResolvedTextDirection getDirection() {
        return this.direction;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState$Companion;", "", "()V", "Hidden", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "getHidden", "()Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldHandleState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextFieldHandleState getHidden() {
            return TextFieldHandleState.Hidden;
        }
    }
}
