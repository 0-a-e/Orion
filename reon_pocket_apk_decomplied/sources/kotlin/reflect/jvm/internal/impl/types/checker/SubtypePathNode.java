package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: utils.kt */
final class SubtypePathNode {
    private final SubtypePathNode previous;
    private final KotlinType type;

    public SubtypePathNode(KotlinType kotlinType, SubtypePathNode subtypePathNode) {
        Intrinsics.checkNotNullParameter(kotlinType, TransferTable.COLUMN_TYPE);
        this.type = kotlinType;
        this.previous = subtypePathNode;
    }

    public final SubtypePathNode getPrevious() {
        return this.previous;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
