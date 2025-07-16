package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u000b\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\tX\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/NestedVectorStack;", "T", "", "()V", "currentIndexes", "", "size", "", "vectors", "", "Landroidx/compose/runtime/collection/MutableVector;", "[Landroidx/compose/runtime/collection/MutableVector;", "isNotEmpty", "", "pop", "()Ljava/lang/Object;", "push", "", "vector", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedVectorStack.kt */
public final class NestedVectorStack<T> {
    public static final int $stable = 8;
    private int[] currentIndexes = new int[16];
    private int size;
    private MutableVector<T>[] vectors = new MutableVector[16];

    public final boolean isNotEmpty() {
        int i = this.size;
        return i > 0 && this.currentIndexes[i - 1] >= 0;
    }

    public final T pop() {
        int i = this.size;
        if (i > 0) {
            int i2 = i - 1;
            int i3 = this.currentIndexes[i2];
            MutableVector<T> mutableVector = this.vectors[i2];
            Intrinsics.checkNotNull(mutableVector);
            if (i3 > 0) {
                int[] iArr = this.currentIndexes;
                iArr[i2] = iArr[i2] - 1;
            } else if (i3 == 0) {
                this.vectors[i2] = null;
                this.size--;
            }
            return mutableVector.getContent()[i3];
        }
        throw new IllegalStateException("Cannot call pop() on an empty stack. Guard with a call to isNotEmpty()".toString());
    }

    public final void push(MutableVector<T> mutableVector) {
        if (!mutableVector.isEmpty()) {
            int i = this.size;
            int[] iArr = this.currentIndexes;
            if (i >= iArr.length) {
                int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.currentIndexes = copyOf;
                MutableVector<T>[] mutableVectorArr = this.vectors;
                Object[] copyOf2 = Arrays.copyOf(mutableVectorArr, mutableVectorArr.length * 2);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
                this.vectors = (MutableVector[]) copyOf2;
            }
            this.currentIndexes[i] = mutableVector.getSize() - 1;
            this.vectors[i] = mutableVector;
            this.size++;
        }
    }
}
