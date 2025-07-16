package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0001\u001a\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0001\"\u0014\u0010\u0000\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\r"}, d2 = {"PrevFocusedChild", "", "getPrevFocusedChild$annotations", "()V", "focusRestorer", "Landroidx/compose/ui/Modifier;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "restoreFocusedChild", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "saveFocusedChild", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRestorer.kt */
public final class FocusRestorerKt {
    private static final String PrevFocusedChild = "previouslyFocusedChildHash";

    private static /* synthetic */ void getPrevFocusedChild$annotations() {
    }

    public static final boolean saveFocusedChild(FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.getFocusState().getHasFocus()) {
            return false;
        }
        DelegatableNode delegatableNode = focusTargetNode;
        int r2 = NodeKind.m5647constructorimpl(1024);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & r2) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
                } else {
                    while (true) {
                        if (node == null) {
                            continue;
                            break;
                        } else if ((node.getKindSet$ui_release() & r2) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                    if (focusTargetNode2.getFocusState().getHasFocus()) {
                                        focusTargetNode.setPreviouslyFocusedChildHash(DelegatableNodeKt.requireLayoutNode(focusTargetNode2).getCompositeKeyHash());
                                        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) CompositionLocalConsumerModifierNodeKt.currentValueOf(focusTargetNode, SaveableStateRegistryKt.getLocalSaveableStateRegistry());
                                        if (saveableStateRegistry != null) {
                                            saveableStateRegistry.registerProvider(PrevFocusedChild, new FocusRestorerKt$saveFocusedChild$1$1(focusTargetNode));
                                        }
                                        return true;
                                    }
                                } else if ((node.getKindSet$ui_release() & r2) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r2) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node);
                                                    }
                                                    node = null;
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
                                node = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    public static final boolean restoreFocusedChild(FocusTargetNode focusTargetNode) {
        SaveableStateRegistry saveableStateRegistry;
        Object consumeRestored;
        if (!(focusTargetNode.getPreviouslyFocusedChildHash() != 0 || (saveableStateRegistry = (SaveableStateRegistry) CompositionLocalConsumerModifierNodeKt.currentValueOf(focusTargetNode, SaveableStateRegistryKt.getLocalSaveableStateRegistry())) == null || (consumeRestored = saveableStateRegistry.consumeRestored(PrevFocusedChild)) == null)) {
            focusTargetNode.setPreviouslyFocusedChildHash(((Integer) consumeRestored).intValue());
        }
        if (focusTargetNode.getPreviouslyFocusedChildHash() == 0) {
            return false;
        }
        DelegatableNode delegatableNode = focusTargetNode;
        int r2 = NodeKind.m5647constructorimpl(1024);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & r2) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
                } else {
                    while (true) {
                        if (node == null) {
                            continue;
                            break;
                        } else if ((node.getKindSet$ui_release() & r2) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                    if (DelegatableNodeKt.requireLayoutNode(focusTargetNode2).getCompositeKeyHash() == focusTargetNode.getPreviouslyFocusedChildHash()) {
                                        if (restoreFocusedChild(focusTargetNode2) || FocusTransactionsKt.requestFocus(focusTargetNode2)) {
                                            return true;
                                        }
                                        return false;
                                    }
                                } else if ((node.getKindSet$ui_release() & r2) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r2) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node);
                                                    }
                                                    node = null;
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
                                node = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    public static /* synthetic */ Modifier focusRestorer$default(Modifier modifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return focusRestorer(modifier, function0);
    }

    public static final Modifier focusRestorer(Modifier modifier, Function0<FocusRequester> function0) {
        return modifier.then(new FocusRestorerElement(function0));
    }
}
