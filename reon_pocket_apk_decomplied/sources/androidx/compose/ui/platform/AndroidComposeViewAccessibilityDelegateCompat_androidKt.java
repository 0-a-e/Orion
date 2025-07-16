package androidx.compose.ui.platform;

import android.graphics.Region;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u001c\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002\u001a\f\u0010 \u001a\u00020\u0003*\u00020\rH\u0002\u001a\f\u0010!\u001a\u00020\u0003*\u00020\rH\u0002\u001a\u001c\u0010\"\u001a\u0004\u0018\u00010#*\b\u0012\u0004\u0012\u00020#0$2\u0006\u0010%\u001a\u00020&H\u0002\u001a\"\u0010'\u001a\u0004\u0018\u00010(*\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00030*H\u0002\u001a\u0018\u0010+\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020-0,*\u00020.H\u0002\u001a\u000e\u0010/\u001a\u0004\u0018\u00010\f*\u00020\rH\u0002\u001a\f\u00100\u001a\u00020\u0003*\u00020\rH\u0002\u001a\u0014\u00101\u001a\u00020\u0003*\u00020(2\u0006\u00102\u001a\u00020(H\u0002\u001a\f\u00103\u001a\u00020\u0003*\u00020\rH\u0002\u001a\u0014\u00104\u001a\u00020\u0003*\u00020\r2\u0006\u00105\u001a\u000206H\u0002\u001a\u0016\u00107\u001a\u0004\u0018\u000108*\u0002092\u0006\u0010%\u001a\u00020&H\u0000\u001a\u0018\u0010:\u001a\u0004\u0018\u00010\f*\u00020;H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038G@GX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0003*\u00020\r8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0019\u0010\u0012\u001a\u00020\u0003*\u00020\r8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0019\u0010\u0013\u001a\u00020\u0003*\u00020\r8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\"\u0019\u0010\u0014\u001a\u00020\u0003*\u00020\r8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\r8BX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u0011\"\u0019\u0010\u0018\u001a\u00020\u0019*\u00020\r8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"DefaultFakeNodeBounds", "Landroidx/compose/ui/geometry/Rect;", "<set-?>", "", "DisableContentCapture", "getDisableContentCapture$annotations", "()V", "getDisableContentCapture", "()Z", "setDisableContentCapture", "(Z)V", "infoContentDescriptionOrNull", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "getInfoContentDescriptionOrNull", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/String;", "isPassword", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isRtl", "isTextField", "isTraversalGroup", "isVisible", "isVisible$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "traversalIndex", "", "getTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsNode;)F", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", "other", "", "enabled", "excludeLineAndPageGranularities", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "getAllUncoveredSemanticsNodesToMap", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getTextForTranslation", "hasPaneTitle", "isAncestorOf", "node", "isImportantForAccessibility", "propertiesDeleted", "oldConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "toLegacyClassName", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    private static final Rect DefaultFakeNodeBounds = new Rect(0.0f, 0.0f, 10.0f, 10.0f);
    private static boolean DisableContentCapture;

    public static /* synthetic */ void getDisableContentCapture$annotations() {
    }

    private static /* synthetic */ void isVisible$annotations(SemanticsNode semanticsNode) {
    }

    /* access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (function1.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean enabled(SemanticsNode semanticsNode) {
        return SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getDisabled()) == null;
    }

    /* access modifiers changed from: private */
    public static final boolean isImportantForAccessibility(SemanticsNode semanticsNode) {
        return semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode.getUnmergedConfig$ui_release().containsImportantForAccessibility$ui_release();
    }

    /* access modifiers changed from: private */
    public static final boolean isVisible(SemanticsNode semanticsNode) {
        return !semanticsNode.isTransparent$ui_release() && !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser());
    }

    /* access modifiers changed from: private */
    public static final boolean propertiesDeleted(SemanticsNode semanticsNode, SemanticsConfiguration semanticsConfiguration) {
        Iterator<Map.Entry<SemanticsPropertyKey<?>, Object>> it = semanticsConfiguration.iterator();
        while (it.hasNext()) {
            if (!semanticsNode.getConfig().contains((SemanticsPropertyKey) it.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean hasPaneTitle(SemanticsNode semanticsNode) {
        return semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle());
    }

    private static final boolean isPassword(SemanticsNode semanticsNode) {
        return semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getPassword());
    }

    private static final boolean isTextField(SemanticsNode semanticsNode) {
        return semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText());
    }

    private static final boolean isRtl(SemanticsNode semanticsNode) {
        return semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
    }

    private static final boolean isTraversalGroup(SemanticsNode semanticsNode) {
        return ((Boolean) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), AndroidComposeViewAccessibilityDelegateCompat_androidKt$isTraversalGroup$1.INSTANCE)).booleanValue();
    }

    private static final float getTraversalIndex(SemanticsNode semanticsNode) {
        return ((Number) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), AndroidComposeViewAccessibilityDelegateCompat_androidKt$traversalIndex$1.INSTANCE)).floatValue();
    }

    /* access modifiers changed from: private */
    public static final String getInfoContentDescriptionOrNull(SemanticsNode semanticsNode) {
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
        if (list != null) {
            return (String) CollectionsKt.firstOrNull(list);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final String getTextForTranslation(SemanticsNode semanticsNode) {
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (list != null) {
            return ListUtilsKt.fastJoinToString$default(list, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean accessibilityEquals(AccessibilityAction<?> accessibilityAction, Object obj) {
        if (accessibilityAction == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
        if (!Intrinsics.areEqual((Object) accessibilityAction.getLabel(), (Object) accessibilityAction2.getLabel())) {
            return false;
        }
        if (accessibilityAction.getAction() != null || accessibilityAction2.getAction() == null) {
            return accessibilityAction.getAction() == null || accessibilityAction2.getAction() != null;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final Map<Integer, SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToMap(SemanticsOwner semanticsOwner) {
        SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
        Map<Integer, SemanticsNodeWithAdjustedBounds> linkedHashMap = new LinkedHashMap<>();
        if (unmergedRootSemanticsNode.getLayoutNode$ui_release().isPlaced() && unmergedRootSemanticsNode.getLayoutNode$ui_release().isAttached()) {
            Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
            getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(new Region(MathKt.roundToInt(boundsInRoot.getLeft()), MathKt.roundToInt(boundsInRoot.getTop()), MathKt.roundToInt(boundsInRoot.getRight()), MathKt.roundToInt(boundsInRoot.getBottom())), unmergedRootSemanticsNode, linkedHashMap, unmergedRootSemanticsNode, new Region());
        }
        return linkedHashMap;
    }

    private static final void getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(Region region, SemanticsNode semanticsNode, Map<Integer, SemanticsNodeWithAdjustedBounds> map, SemanticsNode semanticsNode2, Region region2) {
        int i;
        Rect rect;
        LayoutInfo layoutInfo;
        boolean z = !semanticsNode2.getLayoutNode$ui_release().isPlaced() || !semanticsNode2.getLayoutNode$ui_release().isAttached();
        if (region.isEmpty() && semanticsNode2.getId() != semanticsNode.getId()) {
            return;
        }
        if (!z || semanticsNode2.isFake$ui_release()) {
            Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
            int roundToInt = MathKt.roundToInt(touchBoundsInRoot.getLeft());
            int roundToInt2 = MathKt.roundToInt(touchBoundsInRoot.getTop());
            int roundToInt3 = MathKt.roundToInt(touchBoundsInRoot.getRight());
            int roundToInt4 = MathKt.roundToInt(touchBoundsInRoot.getBottom());
            region2.set(roundToInt, roundToInt2, roundToInt3, roundToInt4);
            if (semanticsNode2.getId() == semanticsNode.getId()) {
                i = -1;
            } else {
                i = semanticsNode2.getId();
            }
            if (region2.op(region, Region.Op.INTERSECT)) {
                map.put(Integer.valueOf(i), new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
                List<SemanticsNode> replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
                for (int size = replacedChildren$ui_release.size() - 1; -1 < size; size--) {
                    getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(region, semanticsNode, map, replacedChildren$ui_release.get(size), region2);
                }
                if (isImportantForAccessibility(semanticsNode2)) {
                    region.op(roundToInt, roundToInt2, roundToInt3, roundToInt4, Region.Op.DIFFERENCE);
                }
            } else if (semanticsNode2.isFake$ui_release()) {
                SemanticsNode parent = semanticsNode2.getParent();
                if (parent == null || (layoutInfo = parent.getLayoutInfo()) == null || !layoutInfo.isPlaced()) {
                    rect = DefaultFakeNodeBounds;
                } else {
                    rect = parent.getBoundsInRoot();
                }
                map.put(Integer.valueOf(i), new SemanticsNodeWithAdjustedBounds(semanticsNode2, new android.graphics.Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()))));
            } else if (i == -1) {
                map.put(Integer.valueOf(i), new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final ScrollObservationScope findById(List<ScrollObservationScope> list, int i) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2).getSemanticsNodeId() == i) {
                return list.get(i2);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLegacyClassName-V4PA4sw  reason: not valid java name */
    public static final String m5753toLegacyClassNameV4PA4sw(int i) {
        if (Role.m5860equalsimpl0(i, Role.Companion.m5864getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m5860equalsimpl0(i, Role.Companion.m5865getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m5860equalsimpl0(i, Role.Companion.m5868getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m5860equalsimpl0(i, Role.Companion.m5867getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m5860equalsimpl0(i, Role.Companion.m5866getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.ui.viewinterop.AndroidViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.view.View semanticsIdToView(androidx.compose.ui.platform.AndroidViewsHandler r3, int r4) {
        /*
            java.util.HashMap r3 = r3.getLayoutNodeToHolder()
            java.util.Set r3 = r3.entrySet()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x000e:
            boolean r0 = r3.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x0029
            java.lang.Object r0 = r3.next()
            r2 = r0
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getKey()
            androidx.compose.ui.node.LayoutNode r2 = (androidx.compose.ui.node.LayoutNode) r2
            int r2 = r2.getSemanticsId()
            if (r2 != r4) goto L_0x000e
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            if (r0 == 0) goto L_0x0035
            java.lang.Object r3 = r0.getValue()
            r1 = r3
            androidx.compose.ui.viewinterop.AndroidViewHolder r1 = (androidx.compose.ui.viewinterop.AndroidViewHolder) r1
        L_0x0035:
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(androidx.compose.ui.platform.AndroidViewsHandler, int):android.view.View");
    }

    /* access modifiers changed from: private */
    public static final boolean isAncestorOf(LayoutNode layoutNode, LayoutNode layoutNode2) {
        LayoutNode parent$ui_release = layoutNode2.getParent$ui_release();
        if (parent$ui_release == null) {
            return false;
        }
        if (Intrinsics.areEqual((Object) parent$ui_release, (Object) layoutNode) || isAncestorOf(layoutNode, parent$ui_release)) {
            return true;
        }
        return false;
    }

    public static final boolean getDisableContentCapture() {
        return DisableContentCapture;
    }

    public static final void setDisableContentCapture(boolean z) {
        DisableContentCapture = z;
    }

    /* access modifiers changed from: private */
    public static final boolean excludeLineAndPageGranularities(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText()) && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
            return true;
        }
        LayoutNode findClosestParentNode = findClosestParentNode(semanticsNode.getLayoutNode$ui_release(), AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.INSTANCE);
        if (findClosestParentNode != null) {
            SemanticsConfiguration collapsedSemantics$ui_release = findClosestParentNode.getCollapsedSemantics$ui_release();
            if (!(collapsedSemantics$ui_release != null ? Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SemanticsProperties.INSTANCE.getFocused()), (Object) true) : false)) {
                return true;
            }
        }
        return false;
    }
}
