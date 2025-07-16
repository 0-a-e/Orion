package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\u001d\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003H\u0000¢\u0006\u0002\b*R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8@@@X\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/AndroidWindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "type", "", "name", "", "(ILjava/lang/String;)V", "<set-?>", "Landroidx/core/graphics/Insets;", "insets", "getInsets$foundation_layout_release", "()Landroidx/core/graphics/Insets;", "setInsets$foundation_layout_release", "(Landroidx/core/graphics/Insets;)V", "insets$delegate", "Landroidx/compose/runtime/MutableState;", "", "isVisible", "()Z", "setVisible", "(Z)V", "isVisible$delegate", "getType$foundation_layout_release", "()I", "equals", "other", "", "getBottom", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "update", "", "windowInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "typeMask", "update$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsets.android.kt */
public final class AndroidWindowInsets implements WindowInsets {
    public static final int $stable = 0;
    private final MutableState insets$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Insets.NONE, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState isVisible$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final String name;
    private final int type;

    public AndroidWindowInsets(int i, String str) {
        this.type = i;
        this.name = str;
    }

    public final int getType$foundation_layout_release() {
        return this.type;
    }

    public final Insets getInsets$foundation_layout_release() {
        return (Insets) this.insets$delegate.getValue();
    }

    public final void setInsets$foundation_layout_release(Insets insets) {
        this.insets$delegate.setValue(insets);
    }

    private final void setVisible(boolean z) {
        this.isVisible$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isVisible() {
        return ((Boolean) this.isVisible$delegate.getValue()).booleanValue();
    }

    public int getLeft(Density density, LayoutDirection layoutDirection) {
        return getInsets$foundation_layout_release().left;
    }

    public int getTop(Density density) {
        return getInsets$foundation_layout_release().top;
    }

    public int getRight(Density density, LayoutDirection layoutDirection) {
        return getInsets$foundation_layout_release().right;
    }

    public int getBottom(Density density) {
        return getInsets$foundation_layout_release().bottom;
    }

    public final void update$foundation_layout_release(WindowInsetsCompat windowInsetsCompat, int i) {
        if (i == 0 || (i & this.type) != 0) {
            setInsets$foundation_layout_release(windowInsetsCompat.getInsets(this.type));
            setVisible(windowInsetsCompat.isVisible(this.type));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidWindowInsets)) {
            return false;
        }
        if (this.type == ((AndroidWindowInsets) obj).type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.type;
    }

    public String toString() {
        return this.name + '(' + getInsets$foundation_layout_release().left + ", " + getInsets$foundation_layout_release().top + ", " + getInsets$foundation_layout_release().right + ", " + getInsets$foundation_layout_release().bottom + ')';
    }
}
