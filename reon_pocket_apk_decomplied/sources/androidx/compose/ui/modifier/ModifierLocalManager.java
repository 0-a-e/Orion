package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u0015\u001a\u00020\u0012J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00172\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroidx/compose/ui/node/Owner;)V", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "insertedLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "invalidated", "", "getOwner", "()Landroidx/compose/ui/node/Owner;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "removedLocal", "insertedProvider", "", "node", "key", "invalidate", "invalidateConsumersOfNodeForKey", "Landroidx/compose/ui/Modifier$Node;", "set", "", "removedProvider", "triggerUpdates", "updatedProvider", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalManager.kt */
public final class ModifierLocalManager {
    public static final int $stable = 8;
    private final MutableVector<BackwardsCompatNode> inserted = new MutableVector<>(new BackwardsCompatNode[16], 0);
    private final MutableVector<ModifierLocal<?>> insertedLocal = new MutableVector<>(new ModifierLocal[16], 0);
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector<LayoutNode> removed = new MutableVector<>(new LayoutNode[16], 0);
    private final MutableVector<ModifierLocal<?>> removedLocal = new MutableVector<>(new ModifierLocal[16], 0);

    public ModifierLocalManager(Owner owner2) {
        this.owner = owner2;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void invalidate() {
        if (!this.invalidated) {
            this.invalidated = true;
            this.owner.registerOnEndApplyChangesListener(new ModifierLocalManager$invalidate$1(this));
        }
    }

    public final void triggerUpdates() {
        int i = 0;
        this.invalidated = false;
        HashSet<BackwardsCompatNode> hashSet = new HashSet<>();
        MutableVector<LayoutNode> mutableVector = this.removed;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i2];
                ModifierLocal modifierLocal = (ModifierLocal) this.removedLocal.getContent()[i2];
                if (layoutNode.getNodes$ui_release().getHead$ui_release().isAttached()) {
                    invalidateConsumersOfNodeForKey(layoutNode.getNodes$ui_release().getHead$ui_release(), modifierLocal, hashSet);
                }
                i2++;
            } while (i2 < size);
        }
        this.removed.clear();
        this.removedLocal.clear();
        MutableVector<BackwardsCompatNode> mutableVector2 = this.inserted;
        int size2 = mutableVector2.getSize();
        if (size2 > 0) {
            Object[] content2 = mutableVector2.getContent();
            do {
                BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) content2[i];
                ModifierLocal modifierLocal2 = (ModifierLocal) this.insertedLocal.getContent()[i];
                if (backwardsCompatNode.isAttached()) {
                    invalidateConsumersOfNodeForKey(backwardsCompatNode, modifierLocal2, hashSet);
                }
                i++;
            } while (i < size2);
        }
        this.inserted.clear();
        this.insertedLocal.clear();
        for (BackwardsCompatNode updateModifierLocalConsumer : hashSet) {
            updateModifierLocalConsumer.updateModifierLocalConsumer();
        }
    }

    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal<?> modifierLocal, Set<BackwardsCompatNode> set) {
        DelegatableNode delegatableNode = node;
        int r0 = NodeKind.m5647constructorimpl(32);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node2 = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node2.getAggregateChildKindSet$ui_release() & r0) != 0) {
                    Modifier.Node node3 = node2;
                    while (true) {
                        if (node3 == null) {
                            break;
                        }
                        if ((node3.getKindSet$ui_release() & r0) != 0) {
                            Modifier.Node node4 = node3;
                            MutableVector mutableVector2 = null;
                            while (node4 != null) {
                                if (node4 instanceof ModifierLocalModifierNode) {
                                    ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) node4;
                                    if (modifierLocalModifierNode instanceof BackwardsCompatNode) {
                                        BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) modifierLocalModifierNode;
                                        if ((backwardsCompatNode.getElement() instanceof ModifierLocalConsumer) && backwardsCompatNode.getReadValues().contains(modifierLocal)) {
                                            set.add(modifierLocalModifierNode);
                                        }
                                    }
                                    if (!(!modifierLocalModifierNode.getProvidedValues().contains$ui_release(modifierLocal))) {
                                        break;
                                    }
                                } else if ((node4.getKindSet$ui_release() & r0) != 0 && (node4 instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node4 = delegate$ui_release;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node4 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node4);
                                                    }
                                                    node4 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node4 = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        }
                        node3 = node3.getChild$ui_release();
                    }
                }
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node2);
            }
            return;
        }
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }

    public final void updatedProvider(BackwardsCompatNode backwardsCompatNode, ModifierLocal<?> modifierLocal) {
        this.inserted.add(backwardsCompatNode);
        this.insertedLocal.add(modifierLocal);
        invalidate();
    }

    public final void insertedProvider(BackwardsCompatNode backwardsCompatNode, ModifierLocal<?> modifierLocal) {
        this.inserted.add(backwardsCompatNode);
        this.insertedLocal.add(modifierLocal);
        invalidate();
    }

    public final void removedProvider(BackwardsCompatNode backwardsCompatNode, ModifierLocal<?> modifierLocal) {
        this.removed.add(DelegatableNodeKt.requireLayoutNode(backwardsCompatNode));
        this.removedLocal.add(modifierLocal);
        invalidate();
    }
}
