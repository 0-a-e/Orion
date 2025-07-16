package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/selection/Selection;", "", "start", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "end", "handlesCrossed", "", "(Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Z)V", "getEnd", "()Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getHandlesCrossed", "()Z", "getStart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "merge", "toString", "", "toTextRange", "Landroidx/compose/ui/text/TextRange;", "toTextRange-d9O1mEE", "()J", "AnchorInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Selection.kt */
public final class Selection {
    public static final int $stable = 0;
    private final AnchorInfo end;
    private final boolean handlesCrossed;
    private final AnchorInfo start;

    public static /* synthetic */ Selection copy$default(Selection selection, AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            anchorInfo = selection.start;
        }
        if ((i & 2) != 0) {
            anchorInfo2 = selection.end;
        }
        if ((i & 4) != 0) {
            z = selection.handlesCrossed;
        }
        return selection.copy(anchorInfo, anchorInfo2, z);
    }

    public final AnchorInfo component1() {
        return this.start;
    }

    public final AnchorInfo component2() {
        return this.end;
    }

    public final boolean component3() {
        return this.handlesCrossed;
    }

    public final Selection copy(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z) {
        return new Selection(anchorInfo, anchorInfo2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selection)) {
            return false;
        }
        Selection selection = (Selection) obj;
        return Intrinsics.areEqual((Object) this.start, (Object) selection.start) && Intrinsics.areEqual((Object) this.end, (Object) selection.end) && this.handlesCrossed == selection.handlesCrossed;
    }

    public int hashCode() {
        return (((this.start.hashCode() * 31) + this.end.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.handlesCrossed);
    }

    public String toString() {
        return "Selection(start=" + this.start + ", end=" + this.end + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    public Selection(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z) {
        this.start = anchorInfo;
        this.end = anchorInfo2;
        this.handlesCrossed = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Selection(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(anchorInfo, anchorInfo2, (i & 4) != 0 ? false : z);
    }

    public final AnchorInfo getStart() {
        return this.start;
    }

    public final AnchorInfo getEnd() {
        return this.end;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "", "selectableId", "", "(Landroidx/compose/ui/text/style/ResolvedTextDirection;IJ)V", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getOffset", "()I", "getSelectableId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Selection.kt */
    public static final class AnchorInfo {
        public static final int $stable = 0;
        private final ResolvedTextDirection direction;
        private final int offset;
        private final long selectableId;

        public static /* synthetic */ AnchorInfo copy$default(AnchorInfo anchorInfo, ResolvedTextDirection resolvedTextDirection, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                resolvedTextDirection = anchorInfo.direction;
            }
            if ((i2 & 2) != 0) {
                i = anchorInfo.offset;
            }
            if ((i2 & 4) != 0) {
                j = anchorInfo.selectableId;
            }
            return anchorInfo.copy(resolvedTextDirection, i, j);
        }

        public final ResolvedTextDirection component1() {
            return this.direction;
        }

        public final int component2() {
            return this.offset;
        }

        public final long component3() {
            return this.selectableId;
        }

        public final AnchorInfo copy(ResolvedTextDirection resolvedTextDirection, int i, long j) {
            return new AnchorInfo(resolvedTextDirection, i, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnchorInfo)) {
                return false;
            }
            AnchorInfo anchorInfo = (AnchorInfo) obj;
            return this.direction == anchorInfo.direction && this.offset == anchorInfo.offset && this.selectableId == anchorInfo.selectableId;
        }

        public int hashCode() {
            return (((this.direction.hashCode() * 31) + this.offset) * 31) + UByte$$ExternalSyntheticBackport0.m(this.selectableId);
        }

        public String toString() {
            return "AnchorInfo(direction=" + this.direction + ", offset=" + this.offset + ", selectableId=" + this.selectableId + ')';
        }

        public AnchorInfo(ResolvedTextDirection resolvedTextDirection, int i, long j) {
            this.direction = resolvedTextDirection;
            this.offset = i;
            this.selectableId = j;
        }

        public final ResolvedTextDirection getDirection() {
            return this.direction;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final long getSelectableId() {
            return this.selectableId;
        }
    }

    public final Selection merge(Selection selection) {
        if (selection == null) {
            return this;
        }
        boolean z = this.handlesCrossed;
        if (z || selection.handlesCrossed) {
            return new Selection(selection.handlesCrossed ? selection.start : selection.end, z ? this.end : this.start, true);
        }
        return copy$default(this, (AnchorInfo) null, selection.end, false, 5, (Object) null);
    }

    /* renamed from: toTextRange-d9O1mEE  reason: not valid java name */
    public final long m1225toTextRanged9O1mEE() {
        return TextRangeKt.TextRange(this.start.getOffset(), this.end.getOffset());
    }
}
