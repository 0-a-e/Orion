package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001 B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J*\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0006\u0010\u0012\u001a\u00020\rJ\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0017J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/ChangeTracker;", "Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "initialChanges", "(Landroidx/compose/foundation/text2/input/internal/ChangeTracker;)V", "_changes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text2/input/internal/ChangeTracker$Change;", "_changesTemp", "changeCount", "", "getChangeCount", "()I", "appendNewChange", "", "mergedOverlappingChange", "preMin", "preMax", "postDelta", "clearChanges", "getOriginalRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getOriginalRange--jx7JFs", "(I)J", "getRange", "getRange--jx7JFs", "toString", "", "trackChange", "preStart", "preEnd", "postLength", "Change", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ChangeTracker.kt */
public final class ChangeTracker implements TextFieldBuffer.ChangeList {
    public static final int $stable = 8;
    private MutableVector<Change> _changes;
    private MutableVector<Change> _changesTemp;

    public ChangeTracker() {
        this((ChangeTracker) null, 1, (DefaultConstructorMarker) null);
    }

    public ChangeTracker(ChangeTracker changeTracker) {
        MutableVector<Change> mutableVector;
        int size;
        int i = 0;
        this._changes = new MutableVector<>(new Change[16], 0);
        this._changesTemp = new MutableVector<>(new Change[16], 0);
        if (changeTracker != null && (mutableVector = changeTracker._changes) != null && (size = mutableVector.getSize()) > 0) {
            Object[] content = mutableVector.getContent();
            do {
                Change change = (Change) content[i];
                this._changes.add(new Change(change.getPreStart(), change.getPreEnd(), change.getOriginalStart(), change.getOriginalEnd()));
                i++;
            } while (i < size);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChangeTracker(ChangeTracker changeTracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : changeTracker);
    }

    public int getChangeCount() {
        return this._changes.getSize();
    }

    public final void trackChange(int i, int i2, int i3) {
        int preEnd;
        if (i != i2 || i3 != 0) {
            int min = Math.min(i, i2);
            int max = Math.max(i, i2);
            int i4 = i3 - (max - min);
            Change change = null;
            boolean z = false;
            for (int i5 = 0; i5 < this._changes.getSize(); i5++) {
                Change change2 = (Change) this._changes.getContent()[i5];
                int preStart = change2.getPreStart();
                if ((min > preStart || preStart > max) && (min > (preEnd = change2.getPreEnd()) || preEnd > max)) {
                    if (change2.getPreStart() > max && !z) {
                        appendNewChange(change, min, max, i4);
                        z = true;
                    }
                    if (z) {
                        change2.setPreStart(change2.getPreStart() + i4);
                        change2.setPreEnd(change2.getPreEnd() + i4);
                    }
                    this._changesTemp.add(change2);
                } else if (change == null) {
                    change = change2;
                } else {
                    change.setPreEnd(change2.getPreEnd());
                    change.setOriginalEnd(change2.getOriginalEnd());
                }
            }
            if (!z) {
                appendNewChange(change, min, max, i4);
            }
            MutableVector<Change> mutableVector = this._changes;
            this._changes = this._changesTemp;
            this._changesTemp = mutableVector;
            mutableVector.clear();
        }
    }

    public final void clearChanges() {
        this._changes.clear();
    }

    /* renamed from: getRange--jx7JFs  reason: not valid java name */
    public long m1368getRangejx7JFs(int i) {
        Change change = (Change) this._changes.getContent()[i];
        return TextRangeKt.TextRange(change.getPreStart(), change.getPreEnd());
    }

    /* renamed from: getOriginalRange--jx7JFs  reason: not valid java name */
    public long m1367getOriginalRangejx7JFs(int i) {
        Change change = (Change) this._changes.getContent()[i];
        return TextRangeKt.TextRange(change.getOriginalStart(), change.getOriginalEnd());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChangeList(changes=[");
        MutableVector<Change> mutableVector = this._changes;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                Change change = (Change) content[i];
                sb.append("(" + change.getOriginalStart() + ',' + change.getOriginalEnd() + ")->(" + change.getPreStart() + ',' + change.getPreEnd() + ')');
                if (i < getChangeCount() - 1) {
                    sb.append(", ");
                }
                i++;
            } while (i < size);
        }
        sb.append("])");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final void appendNewChange(Change change, int i, int i2, int i3) {
        int i4;
        if (this._changesTemp.isEmpty()) {
            i4 = 0;
        } else {
            Change last = this._changesTemp.last();
            i4 = last.getPreEnd() - last.getOriginalEnd();
        }
        if (change == null) {
            int i5 = i - i4;
            change = new Change(i, i2 + i3, i5, (i2 - i) + i5);
        } else {
            if (change.getPreStart() > i) {
                change.setPreStart(i);
                change.setOriginalStart(i);
            }
            if (i2 > change.getPreEnd()) {
                change.setPreEnd(i2);
                change.setOriginalEnd(i2 - (change.getPreEnd() - change.getOriginalEnd()));
            }
            change.setPreEnd(change.getPreEnd() + i3);
        }
        this._changesTemp.add(change);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/ChangeTracker$Change;", "", "preStart", "", "preEnd", "originalStart", "originalEnd", "(IIII)V", "getOriginalEnd", "()I", "setOriginalEnd", "(I)V", "getOriginalStart", "setOriginalStart", "getPreEnd", "setPreEnd", "getPreStart", "setPreStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ChangeTracker.kt */
    private static final class Change {
        private int originalEnd;
        private int originalStart;
        private int preEnd;
        private int preStart;

        public static /* synthetic */ Change copy$default(Change change, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = change.preStart;
            }
            if ((i5 & 2) != 0) {
                i2 = change.preEnd;
            }
            if ((i5 & 4) != 0) {
                i3 = change.originalStart;
            }
            if ((i5 & 8) != 0) {
                i4 = change.originalEnd;
            }
            return change.copy(i, i2, i3, i4);
        }

        public final int component1() {
            return this.preStart;
        }

        public final int component2() {
            return this.preEnd;
        }

        public final int component3() {
            return this.originalStart;
        }

        public final int component4() {
            return this.originalEnd;
        }

        public final Change copy(int i, int i2, int i3, int i4) {
            return new Change(i, i2, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Change)) {
                return false;
            }
            Change change = (Change) obj;
            return this.preStart == change.preStart && this.preEnd == change.preEnd && this.originalStart == change.originalStart && this.originalEnd == change.originalEnd;
        }

        public int hashCode() {
            return (((((this.preStart * 31) + this.preEnd) * 31) + this.originalStart) * 31) + this.originalEnd;
        }

        public String toString() {
            return "Change(preStart=" + this.preStart + ", preEnd=" + this.preEnd + ", originalStart=" + this.originalStart + ", originalEnd=" + this.originalEnd + ')';
        }

        public Change(int i, int i2, int i3, int i4) {
            this.preStart = i;
            this.preEnd = i2;
            this.originalStart = i3;
            this.originalEnd = i4;
        }

        public final int getPreStart() {
            return this.preStart;
        }

        public final void setPreStart(int i) {
            this.preStart = i;
        }

        public final int getPreEnd() {
            return this.preEnd;
        }

        public final void setPreEnd(int i) {
            this.preEnd = i;
        }

        public final int getOriginalStart() {
            return this.originalStart;
        }

        public final void setOriginalStart(int i) {
            this.originalStart = i;
        }

        public final int getOriginalEnd() {
            return this.originalEnd;
        }

        public final void setOriginalEnd(int i) {
            this.originalEnd = i;
        }
    }
}
