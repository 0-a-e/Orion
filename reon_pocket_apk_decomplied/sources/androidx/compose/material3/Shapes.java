package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/Shapes;", "", "extraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", "small", "medium", "large", "extraLarge", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getExtraLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getExtraSmall", "getLarge", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Shapes.kt */
public final class Shapes {
    public static final int $stable = 0;
    private final CornerBasedShape extraLarge;
    private final CornerBasedShape extraSmall;
    private final CornerBasedShape large;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;

    public Shapes() {
        this((CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, 31, (DefaultConstructorMarker) null);
    }

    public Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5) {
        this.extraSmall = cornerBasedShape;
        this.small = cornerBasedShape2;
        this.medium = cornerBasedShape3;
        this.large = cornerBasedShape4;
        this.extraLarge = cornerBasedShape5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Shapes(androidx.compose.foundation.shape.CornerBasedShape r4, androidx.compose.foundation.shape.CornerBasedShape r5, androidx.compose.foundation.shape.CornerBasedShape r6, androidx.compose.foundation.shape.CornerBasedShape r7, androidx.compose.foundation.shape.CornerBasedShape r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            androidx.compose.material3.ShapeDefaults r4 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r4 = r4.getExtraSmall()
        L_0x000a:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0014
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getSmall()
        L_0x0014:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x001f
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r6 = r5.getMedium()
        L_0x001f:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x002a
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r7 = r5.getLarge()
        L_0x002a:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0035
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r8 = r5.getExtraLarge()
        L_0x0035:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Shapes.<init>(androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final CornerBasedShape getExtraSmall() {
        return this.extraSmall;
    }

    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    public final CornerBasedShape getLarge() {
        return this.large;
    }

    public final CornerBasedShape getExtraLarge() {
        return this.extraLarge;
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, int i, Object obj) {
        if ((i & 1) != 0) {
            cornerBasedShape = shapes.extraSmall;
        }
        if ((i & 2) != 0) {
            cornerBasedShape2 = shapes.small;
        }
        CornerBasedShape cornerBasedShape6 = cornerBasedShape2;
        if ((i & 4) != 0) {
            cornerBasedShape3 = shapes.medium;
        }
        CornerBasedShape cornerBasedShape7 = cornerBasedShape3;
        if ((i & 8) != 0) {
            cornerBasedShape4 = shapes.large;
        }
        CornerBasedShape cornerBasedShape8 = cornerBasedShape4;
        if ((i & 16) != 0) {
            cornerBasedShape5 = shapes.extraLarge;
        }
        return shapes.copy(cornerBasedShape, cornerBasedShape6, cornerBasedShape7, cornerBasedShape8, cornerBasedShape5);
    }

    public final Shapes copy(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5) {
        return new Shapes(cornerBasedShape, cornerBasedShape2, cornerBasedShape3, cornerBasedShape4, cornerBasedShape5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) obj;
        return Intrinsics.areEqual((Object) this.extraSmall, (Object) shapes.extraSmall) && Intrinsics.areEqual((Object) this.small, (Object) shapes.small) && Intrinsics.areEqual((Object) this.medium, (Object) shapes.medium) && Intrinsics.areEqual((Object) this.large, (Object) shapes.large) && Intrinsics.areEqual((Object) this.extraLarge, (Object) shapes.extraLarge);
    }

    public int hashCode() {
        return (((((((this.extraSmall.hashCode() * 31) + this.small.hashCode()) * 31) + this.medium.hashCode()) * 31) + this.large.hashCode()) * 31) + this.extraLarge.hashCode();
    }

    public String toString() {
        return "Shapes(extraSmall=" + this.extraSmall + ", small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ", extraLarge=" + this.extraLarge + ')';
    }
}
