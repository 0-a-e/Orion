package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 _*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001_B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\u0010\u0007B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u0004H\u0002J#\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u0015\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u00102\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b3JE\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010:J=\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010?J3\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010AJ5\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ6\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ+\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010JJ'\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ,\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J'\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ(\u0010O\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J\u001e\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J(\u0010Q\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J;\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010?J5\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ2\u0010T\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ&\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J2\u0010W\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ,\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00109\u001a\u00020\tH\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002J)\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J$\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006`"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "E", "", "bitmap", "", "buffer", "", "(I[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "add", "elementHash", "element", "shift", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "addElementAt", "positionMask", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "calculateSize", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionContainsElement", "", "(Ljava/lang/Object;)Z", "collisionRemove", "collisionRemoveElementAtIndex", "i", "contains", "(ILjava/lang/Object;I)Z", "containsAll", "otherNode", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "elementsIdentityEquals", "hasNoCellAt", "indexOfCellAt", "indexOfCellAt$runtime_release", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "owner", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddAll", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableAddElementAt", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAddAll", "mutableCollisionRemove", "mutableCollisionRemoveAll", "mutableCollisionRemoveElementAtIndex", "mutableCollisionRetainAll", "mutableMoveElementToNode", "mutableRemove", "mutableRemoveAll", "mutableRemoveCellAtIndex", "cellIndex", "mutableRetainAll", "mutableUpdateNodeAtIndex", "nodeIndex", "newNode", "nodeAtIndex", "remove", "removeCellAtIndex", "updateNodeAtIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TrieNode.kt */
public final class TrieNode<E> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TrieNode EMPTY = new TrieNode(0, new Object[0]);
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    public TrieNode(int i, Object[] objArr, MutabilityOwnership mutabilityOwnership) {
        this.bitmap = i;
        this.buffer = objArr;
        this.ownedBy = mutabilityOwnership;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(int i) {
        this.bitmap = i;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final void setBuffer(Object[] objArr) {
        this.buffer = objArr;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final void setOwnedBy(MutabilityOwnership mutabilityOwnership) {
        this.ownedBy = mutabilityOwnership;
    }

    public TrieNode(int i, Object[] objArr) {
        this(i, objArr, (MutabilityOwnership) null);
    }

    private final boolean hasNoCellAt(int i) {
        return (i & this.bitmap) == 0;
    }

    public final int indexOfCellAt$runtime_release(int i) {
        return Integer.bitCount((i - 1) & this.bitmap);
    }

    private final E elementAtIndex(int i) {
        return this.buffer[i];
    }

    private final TrieNode<E> nodeAtIndex(int i) {
        Object obj = this.buffer[i];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode<E> addElementAt(int i, E e) {
        return new TrieNode<>(i | this.bitmap, TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release(i), e));
    }

    private final TrieNode<E> mutableAddElementAt(int i, E e, MutabilityOwnership mutabilityOwnership) {
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i);
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, e);
            this.bitmap = i | this.bitmap;
            return this;
        }
        return new TrieNode<>(i | this.bitmap, TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, e), mutabilityOwnership);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> updateNodeAtIndex(int r4, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r5) {
        /*
            r3 = this;
            java.lang.Object[] r0 = r5.buffer
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x0018
            r1 = 0
            r0 = r0[r1]
            boolean r1 = r0 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r1 != 0) goto L_0x0018
            java.lang.Object[] r1 = r3.buffer
            int r1 = r1.length
            if (r1 != r2) goto L_0x0017
            int r4 = r3.bitmap
            r5.bitmap = r4
            return r5
        L_0x0017:
            r5 = r0
        L_0x0018:
            java.lang.Object[] r0 = r3.buffer
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.lang.String r1 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0[r4] = r5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r5 = r3.bitmap
            r4.<init>(r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.updateNodeAtIndex(int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableUpdateNodeAtIndex(int r4, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r5, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r6) {
        /*
            r3 = this;
            java.lang.Object[] r0 = r5.buffer
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x0018
            r1 = 0
            r0 = r0[r1]
            boolean r1 = r0 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r1 != 0) goto L_0x0018
            java.lang.Object[] r1 = r3.buffer
            int r1 = r1.length
            if (r1 != r2) goto L_0x0017
            int r4 = r3.bitmap
            r5.bitmap = r4
            return r5
        L_0x0017:
            r5 = r0
        L_0x0018:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r3.ownedBy
            if (r0 != r6) goto L_0x0021
            java.lang.Object[] r6 = r3.buffer
            r6[r4] = r5
            return r3
        L_0x0021:
            java.lang.Object[] r0 = r3.buffer
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.lang.String r1 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0[r4] = r5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r5 = r3.bitmap
            r4.<init>(r5, r0, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableUpdateNodeAtIndex(int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    private final TrieNode<E> makeNodeAtIndex(int i, int i2, E e, int i3, MutabilityOwnership mutabilityOwnership) {
        Object elementAtIndex = elementAtIndex(i);
        return makeNode(elementAtIndex != null ? elementAtIndex.hashCode() : 0, elementAtIndex, i2, e, i3 + 5, mutabilityOwnership);
    }

    private final TrieNode<E> moveElementToNode(int i, int i2, E e, int i3) {
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = makeNodeAtIndex(i, i2, e, i3, (MutabilityOwnership) null);
        return new TrieNode<>(this.bitmap, copyOf);
    }

    private final TrieNode<E> mutableMoveElementToNode(int i, int i2, E e, int i3, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer[i] = makeNodeAtIndex(i, i2, e, i3, mutabilityOwnership);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = makeNodeAtIndex(i, i2, e, i3, mutabilityOwnership);
        return new TrieNode<>(this.bitmap, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> makeNode(int i, E e, int i2, E e2, int i3, MutabilityOwnership mutabilityOwnership) {
        int i4 = i3;
        MutabilityOwnership mutabilityOwnership2 = mutabilityOwnership;
        if (i4 > 30) {
            return new TrieNode<>(0, new Object[]{e, e2}, mutabilityOwnership2);
        }
        int i5 = i;
        int indexSegment = TrieNodeKt.indexSegment(i, i4);
        int i6 = i2;
        int indexSegment2 = TrieNodeKt.indexSegment(i2, i4);
        if (indexSegment != indexSegment2) {
            return new TrieNode<>((1 << indexSegment) | (1 << indexSegment2), indexSegment < indexSegment2 ? new Object[]{e, e2} : new Object[]{e2, e}, mutabilityOwnership2);
        }
        return new TrieNode<>(1 << indexSegment, new Object[]{makeNode(i, e, i2, e2, i4 + 5, mutabilityOwnership)}, mutabilityOwnership2);
    }

    private final TrieNode<E> removeCellAtIndex(int i, int i2) {
        return new TrieNode<>(i2 ^ this.bitmap, TrieNodeKt.removeCellAtIndex(this.buffer, i));
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int i, int i2, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i);
            this.bitmap ^= i2;
            return this;
        }
        return new TrieNode<>(i2 ^ this.bitmap, TrieNodeKt.removeCellAtIndex(this.buffer, i), mutabilityOwnership);
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int i) {
        return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i));
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int i, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        return this;
    }

    private final boolean collisionContainsElement(E e) {
        return ArraysKt.contains((T[]) this.buffer, e);
    }

    private final TrieNode<E> collisionAdd(E e) {
        if (collisionContainsElement(e)) {
            return this;
        }
        return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, e));
    }

    private final TrieNode<E> mutableCollisionAdd(E e, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        if (collisionContainsElement(e)) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
        if (this.ownedBy != persistentHashSetBuilder.getOwnership$runtime_release()) {
            return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, e), persistentHashSetBuilder.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, 0, e);
        return this;
    }

    private final TrieNode<E> collisionRemove(E e) {
        int indexOf = ArraysKt.indexOf((T[]) this.buffer, e);
        return indexOf != -1 ? collisionRemoveElementAtIndex(indexOf) : this;
    }

    private final TrieNode<E> mutableCollisionRemove(E e, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        int indexOf = ArraysKt.indexOf((T[]) this.buffer, e);
        if (indexOf == -1) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
        return mutableCollisionRemoveElementAtIndex(indexOf, persistentHashSetBuilder.getOwnership$runtime_release());
    }

    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Object[] objArr2 = trieNode.buffer;
        int length = this.buffer.length;
        int i = 0;
        int i2 = 0;
        while (i < objArr2.length) {
            boolean z = true;
            CommonFunctionsKt.m3399assert(i2 <= i);
            if (!collisionContainsElement(objArr2[i])) {
                copyOf[length + i2] = objArr2[i];
                i2++;
                if (length + i2 > copyOf.length) {
                    z = false;
                }
                CommonFunctionsKt.m3399assert(z);
            }
            i++;
        }
        int length2 = i2 + this.buffer.length;
        deltaCounter.plusAssign(copyOf.length - length2);
        if (length2 == this.buffer.length) {
            return this;
        }
        if (length2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (length2 != copyOf.length) {
            copyOf = Arrays.copyOf(copyOf, length2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        }
        if (!Intrinsics.areEqual((Object) this.ownedBy, (Object) mutabilityOwnership)) {
            return new TrieNode<>(0, copyOf, mutabilityOwnership);
        }
        this.buffer = copyOf;
        return this;
    }

    private final Object mutableCollisionRetainAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr;
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        if (Intrinsics.areEqual((Object) mutabilityOwnership, (Object) this.ownedBy)) {
            objArr = this.buffer;
        } else {
            objArr = new Object[Math.min(this.buffer.length, trieNode.buffer.length)];
        }
        Object[] objArr2 = this.buffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m3399assert(i2 <= i);
            if (trieNode.collisionContainsElement(objArr2[i])) {
                objArr[i2] = objArr2[i];
                i2++;
                if (i2 > objArr.length) {
                    z = false;
                }
                CommonFunctionsKt.m3399assert(z);
            }
            i++;
        }
        deltaCounter.plusAssign(i2);
        if (i2 == 0) {
            return EMPTY;
        }
        if (i2 == 1) {
            return objArr[0];
        }
        if (i2 == this.buffer.length) {
            return this;
        }
        if (i2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (i2 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, mutabilityOwnership);
    }

    private final Object mutableCollisionRemoveAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return EMPTY;
        }
        Object[] objArr = Intrinsics.areEqual((Object) mutabilityOwnership, (Object) this.ownedBy) ? this.buffer : new Object[this.buffer.length];
        Object[] objArr2 = this.buffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m3399assert(i2 <= i);
            if (!trieNode.collisionContainsElement(objArr2[i])) {
                objArr[i2] = objArr2[i];
                i2++;
                if (i2 > objArr.length) {
                    z = false;
                }
                CommonFunctionsKt.m3399assert(z);
            }
            i++;
        }
        deltaCounter.plusAssign(this.buffer.length - i2);
        if (i2 == 0) {
            return EMPTY;
        }
        if (i2 == 1) {
            return objArr[0];
        }
        if (i2 == this.buffer.length) {
            return this;
        }
        if (i2 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, mutabilityOwnership);
    }

    private final int calculateSize() {
        if (this.bitmap == 0) {
            return this.buffer.length;
        }
        int i = 0;
        for (Object obj : this.buffer) {
            i += obj instanceof TrieNode ? ((TrieNode) obj).calculateSize() : 1;
        }
        return i;
    }

    private final boolean elementsIdentityEquals(TrieNode<E> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.bitmap != trieNode.bitmap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != trieNode.buffer[i]) {
                return false;
            }
        }
        return true;
    }

    public final boolean contains(int i, E e, int i2) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return false;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (!(obj instanceof TrieNode)) {
            return Intrinsics.areEqual((Object) e, obj);
        }
        TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        if (i2 == 30) {
            return nodeAtIndex.collisionContainsElement(e);
        }
        return nodeAtIndex.contains(i, e, i2 + 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r20, int r21, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r22, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> r23) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            if (r7 != r8) goto L_0x0019
            int r0 = r22.getCount()
            int r1 = r19.calculateSize()
            int r0 = r0 + r1
            r10.setCount(r0)
            return r7
        L_0x0019:
            r0 = 30
            if (r9 <= r0) goto L_0x0026
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r23.getOwnership$runtime_release()
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r7.mutableCollisionAddAll(r8, r10, r0)
            return r0
        L_0x0026:
            int r0 = r7.bitmap
            int r1 = r8.bitmap
            r1 = r1 | r0
            if (r1 != r0) goto L_0x003b
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r7.ownedBy
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r2 = r23.getOwnership$runtime_release()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x003b
            r12 = r7
            goto L_0x004b
        L_0x003b:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r2 = java.lang.Integer.bitCount(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r3 = r23.getOwnership$runtime_release()
            r0.<init>(r1, r2, r3)
            r12 = r0
        L_0x004b:
            r13 = 0
            r14 = r1
            r15 = r13
        L_0x004e:
            if (r14 == 0) goto L_0x0135
            int r6 = java.lang.Integer.lowestOneBit(r14)
            int r0 = r7.indexOfCellAt$runtime_release(r6)
            int r1 = r8.indexOfCellAt$runtime_release(r6)
            java.lang.Object[] r5 = r12.buffer
            boolean r2 = r7.hasNoCellAt(r6)
            if (r2 == 0) goto L_0x006e
            java.lang.Object[] r0 = r8.buffer
            r0 = r0[r1]
        L_0x0068:
            r18 = r5
            r16 = r6
            goto L_0x012d
        L_0x006e:
            boolean r2 = r8.hasNoCellAt(r6)
            if (r2 == 0) goto L_0x0079
            java.lang.Object[] r1 = r7.buffer
            r0 = r1[r0]
            goto L_0x0068
        L_0x0079:
            java.lang.Object[] r2 = r7.buffer
            r2 = r2[r0]
            java.lang.Object[] r0 = r8.buffer
            r4 = r0[r1]
            boolean r0 = r2 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            boolean r1 = r4 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>"
            if (r0 == 0) goto L_0x009c
            if (r1 == 0) goto L_0x009c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r4
            int r0 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r2.mutableAddAll(r4, r0, r10, r11)
            goto L_0x0068
        L_0x009c:
            if (r0 == 0) goto L_0x00c8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r2
            int r0 = r23.size()
            if (r4 == 0) goto L_0x00ae
            int r1 = r4.hashCode()
            goto L_0x00af
        L_0x00ae:
            r1 = r13
        L_0x00af:
            int r3 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = r2.mutableAdd(r1, r4, r3, r11)
            int r2 = r23.size()
            if (r2 != r0) goto L_0x00c4
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
        L_0x00c4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00c6:
            r0 = r1
            goto L_0x0068
        L_0x00c8:
            if (r1 == 0) goto L_0x00f3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r4
            int r0 = r23.size()
            if (r2 == 0) goto L_0x00da
            int r1 = r2.hashCode()
            goto L_0x00db
        L_0x00da:
            r1 = r13
        L_0x00db:
            int r3 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = r4.mutableAdd(r1, r2, r3, r11)
            int r2 = r23.size()
            if (r2 != r0) goto L_0x00f0
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
        L_0x00f0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x00c6
        L_0x00f3:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x0107
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = r2
            goto L_0x0068
        L_0x0107:
            if (r2 == 0) goto L_0x010f
            int r0 = r2.hashCode()
            r1 = r0
            goto L_0x0110
        L_0x010f:
            r1 = r13
        L_0x0110:
            if (r4 == 0) goto L_0x0118
            int r0 = r4.hashCode()
            r3 = r0
            goto L_0x0119
        L_0x0118:
            r3 = r13
        L_0x0119:
            int r16 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r17 = r23.getOwnership$runtime_release()
            r0 = r19
            r18 = r5
            r5 = r16
            r16 = r6
            r6 = r17
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r0.makeNode(r1, r2, r3, r4, r5, r6)
        L_0x012d:
            r18[r15] = r0
            int r15 = r15 + 1
            r14 = r14 ^ r16
            goto L_0x004e
        L_0x0135:
            boolean r0 = r7.elementsIdentityEquals(r12)
            if (r0 == 0) goto L_0x013d
            r12 = r7
            goto L_0x0144
        L_0x013d:
            boolean r0 = r8.elementsIdentityEquals(r12)
            if (r0 == 0) goto L_0x0144
            r12 = r8
        L_0x0144:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    public final Object mutableRetainAll(TrieNode<E> trieNode, int i, DeltaCounter deltaCounter, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode trieNode2;
        TrieNode trieNode3;
        TrieNode<E> trieNode4 = trieNode;
        int i2 = i;
        DeltaCounter deltaCounter2 = deltaCounter;
        if (this == trieNode4) {
            deltaCounter2.plusAssign(calculateSize());
            return this;
        } else if (i2 > 30) {
            return mutableCollisionRetainAll(trieNode4, deltaCounter2, persistentHashSetBuilder.getOwnership$runtime_release());
        } else {
            int i3 = this.bitmap & trieNode4.bitmap;
            if (i3 == 0) {
                return EMPTY;
            }
            if (!Intrinsics.areEqual((Object) this.ownedBy, (Object) persistentHashSetBuilder.getOwnership$runtime_release()) || i3 != this.bitmap) {
                trieNode2 = new TrieNode(i3, new Object[Integer.bitCount(i3)], persistentHashSetBuilder.getOwnership$runtime_release());
            } else {
                trieNode2 = this;
            }
            int i4 = i3;
            int i5 = 0;
            int i6 = 0;
            while (i4 != 0) {
                int lowestOneBit = Integer.lowestOneBit(i4);
                int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
                int indexOfCellAt$runtime_release2 = trieNode4.indexOfCellAt$runtime_release(lowestOneBit);
                TrieNode trieNode5 = this;
                Object obj = this.buffer[indexOfCellAt$runtime_release];
                Object obj2 = trieNode4.buffer[indexOfCellAt$runtime_release2];
                boolean z = obj instanceof TrieNode;
                boolean z2 = obj2 instanceof TrieNode;
                if (z && z2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                    obj = ((TrieNode) obj).mutableRetainAll((TrieNode) obj2, i2 + 5, deltaCounter2, persistentHashSetBuilder);
                } else if (z) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                    if (((TrieNode) obj).contains(obj2 != null ? obj2.hashCode() : 0, obj2, i2 + 5)) {
                        deltaCounter2.plusAssign(1);
                        obj = obj2;
                    } else {
                        obj = EMPTY;
                    }
                } else if (z2) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                    if (((TrieNode) obj2).contains(obj != null ? obj.hashCode() : 0, obj, i2 + 5)) {
                        deltaCounter2.plusAssign(1);
                    } else {
                        obj = EMPTY;
                    }
                } else if (Intrinsics.areEqual(obj, obj2)) {
                    deltaCounter2.plusAssign(1);
                } else {
                    obj = EMPTY;
                }
                if (obj != EMPTY) {
                    i5 |= lowestOneBit;
                }
                trieNode2.buffer[i6] = obj;
                i6++;
                i4 ^= lowestOneBit;
            }
            int bitCount = Integer.bitCount(i5);
            if (i5 == 0) {
                return EMPTY;
            }
            if (i5 != i3) {
                if (bitCount != 1 || i2 == 0) {
                    Object[] objArr = new Object[bitCount];
                    Object[] objArr2 = trieNode2.buffer;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < objArr2.length) {
                        CommonFunctionsKt.m3399assert(i8 <= i7);
                        if (objArr2[i7] != Companion.getEMPTY$runtime_release()) {
                            objArr[i8] = objArr2[i7];
                            i8++;
                            CommonFunctionsKt.m3399assert(i8 <= bitCount);
                        }
                        i7++;
                    }
                    trieNode3 = new TrieNode(i5, objArr, persistentHashSetBuilder.getOwnership$runtime_release());
                } else {
                    Object obj3 = trieNode2.buffer[trieNode2.indexOfCellAt$runtime_release(i5)];
                    if (!(obj3 instanceof TrieNode)) {
                        return obj3;
                    }
                    trieNode3 = new TrieNode(i5, new Object[]{obj3}, persistentHashSetBuilder.getOwnership$runtime_release());
                }
                return trieNode3;
            } else if (trieNode2.elementsIdentityEquals(this)) {
                return this;
            } else {
                if (trieNode2.elementsIdentityEquals(trieNode4)) {
                    return trieNode4;
                }
                return trieNode2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        if ((r13 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) == false) goto L_0x00e3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object mutableRemoveAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r17, int r18, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r19, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            if (r0 != r1) goto L_0x0016
            int r1 = r16.calculateSize()
            r3.plusAssign(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = EMPTY
            return r1
        L_0x0016:
            r5 = 30
            if (r2 <= r5) goto L_0x0023
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r2 = r20.getOwnership$runtime_release()
            java.lang.Object r1 = r0.mutableCollisionRemoveAll(r1, r3, r2)
            return r1
        L_0x0023:
            int r5 = r0.bitmap
            int r6 = r1.bitmap
            r5 = r5 & r6
            if (r5 != 0) goto L_0x002b
            return r0
        L_0x002b:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r6 = r0.ownedBy
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r7 = r20.getOwnership$runtime_release()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0039
            r6 = r0
            goto L_0x0050
        L_0x0039:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r6 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r7 = r0.bitmap
            java.lang.Object[] r8 = r0.buffer
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.lang.String r9 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r9 = r20.getOwnership$runtime_release()
            r6.<init>(r7, r8, r9)
        L_0x0050:
            int r7 = r0.bitmap
        L_0x0052:
            if (r5 == 0) goto L_0x00ef
            int r10 = java.lang.Integer.lowestOneBit(r5)
            int r11 = r0.indexOfCellAt$runtime_release(r10)
            int r12 = r1.indexOfCellAt$runtime_release(r10)
            r13 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r13 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r13
            java.lang.Object[] r13 = r0.buffer
            r13 = r13[r11]
            java.lang.Object[] r14 = r1.buffer
            r12 = r14[r12]
            boolean r14 = r13 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            boolean r15 = r12 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.String r8 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>"
            if (r14 == 0) goto L_0x0086
            if (r15 == 0) goto L_0x0086
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r13 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r13
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r12 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r12
            int r8 = r2 + 5
            java.lang.Object r13 = r13.mutableRemoveAll(r12, r8, r3, r4)
            goto L_0x00e3
        L_0x0086:
            if (r14 == 0) goto L_0x00b9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r8)
            r8 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r8 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r8
            int r14 = r20.size()
            if (r12 == 0) goto L_0x0099
            int r15 = r12.hashCode()
            goto L_0x009a
        L_0x0099:
            r15 = 0
        L_0x009a:
            int r9 = r2 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r8 = r8.mutableRemove(r15, r12, r9, r4)
            int r9 = r20.size()
            if (r14 == r9) goto L_0x00e3
            r9 = 1
            r3.plusAssign(r9)
            java.lang.Object[] r12 = r8.buffer
            int r13 = r12.length
            if (r13 != r9) goto L_0x00b7
            r9 = 0
            r13 = r12[r9]
            boolean r9 = r13 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r9 != 0) goto L_0x00b7
            goto L_0x00e3
        L_0x00b7:
            r13 = r8
            goto L_0x00e3
        L_0x00b9:
            if (r15 == 0) goto L_0x00d7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r12 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r12
            if (r13 == 0) goto L_0x00c7
            int r8 = r13.hashCode()
            goto L_0x00c8
        L_0x00c7:
            r8 = 0
        L_0x00c8:
            int r9 = r2 + 5
            boolean r8 = r12.contains(r8, r13, r9)
            if (r8 == 0) goto L_0x00e3
            r8 = 1
            r3.plusAssign(r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r13 = EMPTY
            goto L_0x00e3
        L_0x00d7:
            r8 = 1
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r12)
            if (r9 == 0) goto L_0x00e3
            r3.plusAssign(r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r13 = EMPTY
        L_0x00e3:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r8 = EMPTY
            if (r13 != r8) goto L_0x00e8
            r7 = r7 ^ r10
        L_0x00e8:
            java.lang.Object[] r8 = r6.buffer
            r8[r11] = r13
            r5 = r5 ^ r10
            goto L_0x0052
        L_0x00ef:
            int r1 = java.lang.Integer.bitCount(r7)
            if (r7 != 0) goto L_0x00f9
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r6 = EMPTY
            goto L_0x015c
        L_0x00f9:
            int r3 = r0.bitmap
            if (r7 != r3) goto L_0x0105
            boolean r1 = r6.elementsIdentityEquals(r0)
            if (r1 == 0) goto L_0x015c
            r6 = r0
            goto L_0x015c
        L_0x0105:
            r9 = 1
            if (r1 != r9) goto L_0x0126
            if (r2 == 0) goto L_0x0126
            java.lang.Object[] r1 = r6.buffer
            int r2 = r6.indexOfCellAt$runtime_release(r7)
            r6 = r1[r2]
            boolean r1 = r6 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r1 == 0) goto L_0x015c
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.Object[] r2 = new java.lang.Object[r9]
            r3 = 0
            r2[r3] = r6
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r3 = r20.getOwnership$runtime_release()
            r1.<init>(r7, r2, r3)
            r6 = r1
            goto L_0x015c
        L_0x0126:
            r3 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Object[] r5 = r6.buffer
            r6 = r3
            r8 = r6
        L_0x012d:
            int r10 = r5.length
            if (r6 >= r10) goto L_0x0153
            if (r8 > r6) goto L_0x0134
            r10 = r9
            goto L_0x0135
        L_0x0134:
            r10 = r3
        L_0x0135:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt.m3399assert(r10)
            r10 = r5[r6]
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode$Companion r11 = Companion
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r11 = r11.getEMPTY$runtime_release()
            if (r10 == r11) goto L_0x0150
            r10 = r5[r6]
            r2[r8] = r10
            int r8 = r8 + 1
            if (r8 > r1) goto L_0x014c
            r10 = r9
            goto L_0x014d
        L_0x014c:
            r10 = r3
        L_0x014d:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt.m3399assert(r10)
        L_0x0150:
            int r6 = r6 + 1
            goto L_0x012d
        L_0x0153:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r6 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r1 = r20.getOwnership$runtime_release()
            r6.<init>(r7, r2, r1)
        L_0x015c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):java.lang.Object");
    }

    public final boolean containsAll(TrieNode<E> trieNode, int i) {
        if (this == trieNode) {
            return true;
        }
        if (i > 30) {
            for (Object contains : trieNode.buffer) {
                if (!ArraysKt.contains((T[]) this.buffer, contains)) {
                    return false;
                }
            }
            return true;
        }
        int i2 = this.bitmap;
        int i3 = trieNode.bitmap;
        int i4 = i2 & i3;
        if (i4 != i3) {
            return false;
        }
        while (i4 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i4);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = trieNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj = this.buffer[indexOfCellAt$runtime_release];
            Object obj2 = trieNode.buffer[indexOfCellAt$runtime_release2];
            boolean z = obj instanceof TrieNode;
            boolean z2 = obj2 instanceof TrieNode;
            if (z && z2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                if (!((TrieNode) obj).containsAll((TrieNode) obj2, i + 5)) {
                    return false;
                }
            } else if (z) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                if (!((TrieNode) obj).contains(obj2 != null ? obj2.hashCode() : 0, obj2, i + 5)) {
                    return false;
                }
            } else if (z2 || !Intrinsics.areEqual(obj, obj2)) {
                return false;
            }
            i4 ^= lowestOneBit;
        }
        return true;
    }

    public final TrieNode<E> add(int i, E e, int i2) {
        TrieNode trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return addElementAt(indexSegment, e);
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i2 == 30) {
                trieNode = nodeAtIndex.collisionAdd(e);
            } else {
                trieNode = nodeAtIndex.add(i, e, i2 + 5);
            }
            if (nodeAtIndex == trieNode) {
                return this;
            }
            return updateNodeAtIndex(indexOfCellAt$runtime_release, trieNode);
        } else if (Intrinsics.areEqual((Object) e, obj)) {
            return this;
        } else {
            return moveElementToNode(indexOfCellAt$runtime_release, i, e, i2);
        }
    }

    public final TrieNode<E> mutableAdd(int i, E e, int i2, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode<?> trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
            return mutableAddElementAt(indexSegment, e, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<?> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i2 == 30) {
                trieNode = nodeAtIndex.mutableCollisionAdd(e, persistentHashSetBuilder);
            } else {
                trieNode = nodeAtIndex.mutableAdd(i, e, i2 + 5, persistentHashSetBuilder);
            }
            if (nodeAtIndex == trieNode) {
                return this;
            }
            return mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, trieNode, persistentHashSetBuilder.getOwnership$runtime_release());
        } else if (Intrinsics.areEqual((Object) e, obj)) {
            return this;
        } else {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
            return mutableMoveElementToNode(indexOfCellAt$runtime_release, i, e, i2, persistentHashSetBuilder.getOwnership$runtime_release());
        }
    }

    public final TrieNode<E> remove(int i, E e, int i2) {
        TrieNode trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (!(obj instanceof TrieNode)) {
            return Intrinsics.areEqual((Object) e, obj) ? removeCellAtIndex(indexOfCellAt$runtime_release, indexSegment) : this;
        }
        TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        if (i2 == 30) {
            trieNode = nodeAtIndex.collisionRemove(e);
        } else {
            trieNode = nodeAtIndex.remove(i, e, i2 + 5);
        }
        if (nodeAtIndex == trieNode) {
            return this;
        }
        return updateNodeAtIndex(indexOfCellAt$runtime_release, trieNode);
    }

    public final TrieNode<E> mutableRemove(int i, E e, int i2, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode<?> trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<?> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i2 == 30) {
                trieNode = nodeAtIndex.mutableCollisionRemove(e, persistentHashSetBuilder);
            } else {
                trieNode = nodeAtIndex.mutableRemove(i, e, i2 + 5, persistentHashSetBuilder);
            }
            if (this.ownedBy == persistentHashSetBuilder.getOwnership$runtime_release() || nodeAtIndex != trieNode) {
                return mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, trieNode, persistentHashSetBuilder.getOwnership$runtime_release());
            }
            return this;
        } else if (!Intrinsics.areEqual((Object) e, obj)) {
            return this;
        } else {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
            return mutableRemoveCellAtIndex(indexOfCellAt$runtime_release, indexSegment, persistentHashSetBuilder.getOwnership$runtime_release());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TrieNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }
    }
}
