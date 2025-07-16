package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrder;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000fB\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020\u001eH\u0002J\b\u0010A\u001a\u00020\u001eH\u0016J\b\u0010B\u001a\u00020<H\u0016J\b\u0010C\u001a\u00020<H\u0016J\b\u0010D\u001a\u00020<H\u0016J\r\u0010E\u001a\u00020<H\u0000¢\u0006\u0002\bFJ\u0010\u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020\"H\u0016J\b\u0010L\u001a\u00020<H\u0016J\u0010\u0010M\u001a\u00020<2\u0006\u0010K\u001a\u00020\"H\u0016J*\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001a\u0010W\u001a\u00020<2\u0006\u00103\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001a\u00020\u001eH\u0016J\b\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020<H\u0002J\b\u0010^\u001a\u00020<H\u0002J\u0006\u0010_\u001a\u00020<J\u0014\u0010`\u001a\u00020<2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030aH\u0002J\f\u0010b\u001a\u00020<*\u00020cH\u0016J\f\u0010d\u001a\u00020<*\u00020eH\u0016J\u001c\u0010f\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020gH\u0016J\u001c\u0010l\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010m\u001a\u00020gH\u0016J&\u0010n\u001a\u00020o*\u00020p2\u0006\u0010i\u001a\u00020q2\u0006\u0010r\u001a\u00020sH\u0016ø\u0001\u0000¢\u0006\u0004\bt\u0010uJ\u001c\u0010v\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020gH\u0016J\u001c\u0010w\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010m\u001a\u00020gH\u0016J\u0018\u0010x\u001a\u0004\u0018\u00010y*\u00020\u00162\b\u0010z\u001a\u0004\u0018\u00010yH\u0016R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0012R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R2\u0010+\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0,j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-`.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u0002048VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b5\u00106R$\u00107\u001a\u0002H8\"\u0004\b\u0000\u00108*\b\u0012\u0004\u0012\u0002H80-8VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006{"}, d2 = {"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "(Landroidx/compose/ui/Modifier$Element;)V", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "value", "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "invalidateCache", "", "isValidOwnerScope", "()Z", "lastOnPlacedCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "initializeModifier", "duringAttach", "interceptOutOfBoundsChildEvents", "onAttach", "onCancelPointerInput", "onDetach", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui_release", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onGloballyPositioned", "coordinates", "onMeasureResultChanged", "onPlaced", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "sharePointerInputWithSiblings", "toString", "", "unInitializeModifier", "updateDrawCache", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "modifyParentData", "", "parentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackwardsCompatNode.kt */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalModifierNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, OwnerScope, BuildDrawCacheParams {
    public static final int $stable = 8;
    private BackwardsCompatLocalMap _providedValues;
    private Modifier.Element element;
    private boolean invalidateCache = true;
    /* access modifiers changed from: private */
    public LayoutCoordinates lastOnPlacedCoordinates;
    private HashSet<ModifierLocal<?>> readValues = new HashSet<>();

    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    public /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        ModifierLocalModifierNode.CC.$default$provide(this, modifierLocal, obj);
    }

    public BackwardsCompatNode(Modifier.Element element2) {
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element2));
        this.element = element2;
    }

    public final Modifier.Element getElement() {
        return this.element;
    }

    public final void setElement(Modifier.Element element2) {
        if (isAttached()) {
            unInitializeModifier();
        }
        this.element = element2;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element2));
        if (isAttached()) {
            initializeModifier(false);
        }
    }

    public void onAttach() {
        initializeModifier(true);
    }

    public void onDetach() {
        unInitializeModifier();
    }

    private final void unInitializeModifier() {
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            Modifier.Node node = this;
            if ((NodeKind.m5647constructorimpl(32) & node.getKindSet$ui_release()) != 0) {
                if (element2 instanceof ModifierLocalProvider) {
                    DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, ((ModifierLocalProvider) element2).getKey());
                }
                if (element2 instanceof ModifierLocalConsumer) {
                    ((ModifierLocalConsumer) element2).onModifierLocalsUpdated(BackwardsCompatNodeKt.DetachedModifierLocalReadScope);
                }
            }
            if ((node.getKindSet$ui_release() & NodeKind.m5647constructorimpl(8)) != 0) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
            }
            if (element2 instanceof FocusRequesterModifier) {
                ((FocusRequesterModifier) element2).getFocusRequester().getFocusRequesterNodes$ui_release().remove(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("unInitializeModifier called on unattached node".toString());
    }

    private final void initializeModifier(boolean z) {
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            Modifier.Node node = this;
            if ((NodeKind.m5647constructorimpl(32) & node.getKindSet$ui_release()) != 0) {
                if (element2 instanceof ModifierLocalConsumer) {
                    sideEffect(new BackwardsCompatNode$initializeModifier$2(this));
                }
                if (element2 instanceof ModifierLocalProvider) {
                    updateModifierLocalProvider((ModifierLocalProvider) element2);
                }
            }
            if ((NodeKind.m5647constructorimpl(4) & node.getKindSet$ui_release()) != 0) {
                if (element2 instanceof DrawCacheModifier) {
                    this.invalidateCache = true;
                }
                if (!z) {
                    LayoutModifierNodeKt.invalidateLayer(this);
                }
            }
            if ((NodeKind.m5647constructorimpl(2) & node.getKindSet$ui_release()) != 0) {
                if (BackwardsCompatNodeKt.isChainUpdate(this)) {
                    NodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release);
                    ((LayoutModifierNodeCoordinator) coordinator$ui_release).setLayoutModifierNode$ui_release(this);
                    coordinator$ui_release.onLayoutModifierNodeChanged();
                }
                if (!z) {
                    LayoutModifierNodeKt.invalidateLayer(this);
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
            }
            if (element2 instanceof RemeasurementModifier) {
                ((RemeasurementModifier) element2).onRemeasurementAvailable(DelegatableNodeKt.requireLayoutNode(this));
            }
            if ((NodeKind.m5647constructorimpl(128) & node.getKindSet$ui_release()) != 0) {
                if ((element2 instanceof OnRemeasuredModifier) && BackwardsCompatNodeKt.isChainUpdate(this)) {
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
                if (element2 instanceof OnPlacedModifier) {
                    this.lastOnPlacedCoordinates = null;
                    if (BackwardsCompatNodeKt.isChainUpdate(this)) {
                        DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new BackwardsCompatNode$initializeModifier$3(this));
                    }
                }
            }
            if ((NodeKind.m5647constructorimpl(256) & node.getKindSet$ui_release()) != 0 && (element2 instanceof OnGloballyPositionedModifier) && BackwardsCompatNodeKt.isChainUpdate(this)) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if (element2 instanceof FocusRequesterModifier) {
                ((FocusRequesterModifier) element2).getFocusRequester().getFocusRequesterNodes$ui_release().add(this);
            }
            if ((NodeKind.m5647constructorimpl(16) & node.getKindSet$ui_release()) != 0 && (element2 instanceof PointerInputModifier)) {
                ((PointerInputModifier) element2).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator$ui_release());
            }
            if ((NodeKind.m5647constructorimpl(8) & node.getKindSet$ui_release()) != 0) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
                return;
            }
            return;
        }
        throw new IllegalStateException("initializeModifier called on unattached node".toString());
    }

    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m5450getSizeNHjbRc() {
        return IntSizeKt.m6800toSizeozmzZPI(DelegatableNodeKt.m5468requireCoordinator64DMado(this, NodeKind.m5647constructorimpl(128)).m5621getSizeYbymL2g());
    }

    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final void updateDrawCache() {
        Modifier.Element element2 = this.element;
        if (element2 instanceof DrawCacheModifier) {
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.onDrawCacheReadsChanged, new BackwardsCompatNode$updateDrawCache$1(element2, this));
        }
        this.invalidateCache = false;
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    public final void setReadValues(HashSet<ModifierLocal<?>> hashSet) {
        this.readValues = hashSet;
    }

    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalModifierNodeKt.modifierLocalMapOf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
        r2 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getCurrent(androidx.compose.ui.modifier.ModifierLocal<T> r12) {
        /*
            r11 = this;
            java.util.HashSet<androidx.compose.ui.modifier.ModifierLocal<?>> r0 = r11.readValues
            r0.add(r12)
            r0 = r11
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r1 = 32
            int r1 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x00c8
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x0024:
            if (r0 == 0) goto L_0x00bf
            androidx.compose.ui.node.NodeChain r3 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r1
            r4 = 0
            if (r3 == 0) goto L_0x00aa
        L_0x0036:
            if (r2 == 0) goto L_0x00aa
            int r3 = r2.getKindSet$ui_release()
            r3 = r3 & r1
            if (r3 == 0) goto L_0x00a5
            r3 = r2
            r5 = r4
        L_0x0041:
            if (r3 == 0) goto L_0x00a5
            boolean r6 = r3 instanceof androidx.compose.ui.modifier.ModifierLocalModifierNode
            if (r6 == 0) goto L_0x005c
            androidx.compose.ui.modifier.ModifierLocalModifierNode r3 = (androidx.compose.ui.modifier.ModifierLocalModifierNode) r3
            androidx.compose.ui.modifier.ModifierLocalMap r6 = r3.getProvidedValues()
            boolean r6 = r6.contains$ui_release(r12)
            if (r6 == 0) goto L_0x00a0
            androidx.compose.ui.modifier.ModifierLocalMap r0 = r3.getProvidedValues()
            java.lang.Object r12 = r0.get$ui_release(r12)
            return r12
        L_0x005c:
            int r6 = r3.getKindSet$ui_release()
            r6 = r6 & r1
            if (r6 == 0) goto L_0x00a0
            boolean r6 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L_0x00a0
            r6 = r3
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate$ui_release()
            r7 = 0
            r8 = r7
        L_0x0070:
            r9 = 1
            if (r6 == 0) goto L_0x009d
            int r10 = r6.getKindSet$ui_release()
            r10 = r10 & r1
            if (r10 == 0) goto L_0x0098
            int r8 = r8 + 1
            if (r8 != r9) goto L_0x0080
            r3 = r6
            goto L_0x0098
        L_0x0080:
            if (r5 != 0) goto L_0x008b
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r9 = 16
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r9]
            r5.<init>(r9, r7)
        L_0x008b:
            if (r3 == 0) goto L_0x0093
            if (r5 == 0) goto L_0x0092
            r5.add(r3)
        L_0x0092:
            r3 = r4
        L_0x0093:
            if (r5 == 0) goto L_0x0098
            r5.add(r6)
        L_0x0098:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L_0x0070
        L_0x009d:
            if (r8 != r9) goto L_0x00a0
            goto L_0x0041
        L_0x00a0:
            androidx.compose.ui.Modifier$Node r3 = androidx.compose.ui.node.DelegatableNodeKt.pop(r5)
            goto L_0x0041
        L_0x00a5:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x0036
        L_0x00aa:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00bc
            androidx.compose.ui.node.NodeChain r2 = r0.getNodes$ui_release()
            if (r2 == 0) goto L_0x00bc
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x0024
        L_0x00bc:
            r2 = r4
            goto L_0x0024
        L_0x00bf:
            kotlin.jvm.functions.Function0 r12 = r12.getDefaultFactory$ui_release()
            java.lang.Object r12 = r12.invoke()
            return r12
        L_0x00c8:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.BackwardsCompatNode.getCurrent(androidx.compose.ui.modifier.ModifierLocal):java.lang.Object");
    }

    public final void updateModifierLocalConsumer() {
        if (isAttached()) {
            this.readValues.clear();
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.updateModifierLocalConsumer, new BackwardsCompatNode$updateModifierLocalConsumer$1(this));
        }
    }

    private final void updateModifierLocalProvider(ModifierLocalProvider<?> modifierLocalProvider) {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        if (backwardsCompatLocalMap == null || !backwardsCompatLocalMap.contains$ui_release(modifierLocalProvider.getKey())) {
            this._providedValues = new BackwardsCompatLocalMap(modifierLocalProvider);
            if (BackwardsCompatNodeKt.isChainUpdate(this)) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().insertedProvider(this, modifierLocalProvider.getKey());
                return;
            }
            return;
        }
        backwardsCompatLocalMap.setElement(modifierLocalProvider);
        DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, modifierLocalProvider.getKey());
    }

    public boolean isValidOwnerScope() {
        return isAttached();
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m5451measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).m5329measure3p2s80s(measureScope, measurable, j);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier drawModifier = (DrawModifier) element2;
        if (this.invalidateCache && (element2 instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        drawModifier.draw(contentDrawScope);
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        SemanticsConfiguration semanticsConfiguration = ((SemanticsModifier) element2).getSemanticsConfiguration();
        Intrinsics.checkNotNull(semanticsPropertyReceiver, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        ((SemanticsConfiguration) semanticsPropertyReceiver).collapsePeer$ui_release(semanticsConfiguration);
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m5452onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().m5137onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    public void onCancelPointerInput() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().onCancel();
    }

    public boolean sharePointerInputWithSiblings() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getShareWithSiblings();
    }

    public boolean interceptOutOfBoundsChildEvents() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    public Object modifyParentData(Density density, Object obj) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) element2).modifyParentData(density, obj);
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element2).onGloballyPositioned(layoutCoordinates);
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m5453onRemeasuredozmzZPI(long j) {
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element2).m5399onRemeasuredozmzZPI(j);
        }
    }

    public void onPlaced(LayoutCoordinates layoutCoordinates) {
        this.lastOnPlacedCoordinates = layoutCoordinates;
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element2).onPlaced(layoutCoordinates);
        }
    }

    public void onFocusEvent(FocusState focusState) {
        Modifier.Element element2 = this.element;
        if (element2 instanceof FocusEventModifier) {
            ((FocusEventModifier) element2).onFocusEvent(focusState);
            return;
        }
        throw new IllegalStateException("onFocusEvent called on wrong node".toString());
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        Modifier.Element element2 = this.element;
        if (element2 instanceof FocusOrderModifier) {
            ((FocusOrderModifier) element2).populateFocusOrder(new FocusOrder(focusProperties));
            return;
        }
        throw new IllegalStateException("applyFocusProperties called on wrong node".toString());
    }

    public String toString() {
        return this.element.toString();
    }
}
