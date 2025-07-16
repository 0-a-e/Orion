package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.BasicText_androidKt;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eR\u0016\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/runtime/RememberObserver;", "selectableId", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "backgroundSelectionColor", "Landroidx/compose/ui/graphics/Color;", "params", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "(JLandroidx/compose/foundation/text/selection/SelectionRegistrar;JLandroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "draw", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "updateGlobalPosition", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateTextLayout", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionController.kt */
public final class SelectionController implements RememberObserver {
    public static final int $stable = 8;
    private final long backgroundSelectionColor;
    private final Modifier modifier;
    /* access modifiers changed from: private */
    public StaticTextSelectionParams params;
    private Selectable selectable;
    private final long selectableId;
    private final SelectionRegistrar selectionRegistrar;

    public /* synthetic */ SelectionController(long j, SelectionRegistrar selectionRegistrar2, long j2, StaticTextSelectionParams staticTextSelectionParams, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, selectionRegistrar2, j2, staticTextSelectionParams);
    }

    private SelectionController(long j, SelectionRegistrar selectionRegistrar2, long j2, StaticTextSelectionParams staticTextSelectionParams) {
        this.selectableId = j;
        this.selectionRegistrar = selectionRegistrar2;
        this.backgroundSelectionColor = j2;
        this.params = staticTextSelectionParams;
        this.modifier = BasicText_androidKt.textPointerHoverIcon(SelectionControllerKt.makeSelectionModifier(selectionRegistrar2, j, new SelectionController$modifier$1(this)), selectionRegistrar2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectionController(long j, SelectionRegistrar selectionRegistrar2, long j2, StaticTextSelectionParams staticTextSelectionParams, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, selectionRegistrar2, j2, (i & 8) != 0 ? StaticTextSelectionParams.Companion.getEmpty() : staticTextSelectionParams, (DefaultConstructorMarker) null);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public void onRemembered() {
        this.selectable = this.selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.selectableId, new SelectionController$onRemembered$1(this), new SelectionController$onRemembered$2(this)));
    }

    public void onForgotten() {
        Selectable selectable2 = this.selectable;
        if (selectable2 != null) {
            this.selectionRegistrar.unsubscribe(selectable2);
            this.selectable = null;
        }
    }

    public void onAbandoned() {
        Selectable selectable2 = this.selectable;
        if (selectable2 != null) {
            this.selectionRegistrar.unsubscribe(selectable2);
            this.selectable = null;
        }
    }

    public final void updateTextLayout(TextLayoutResult textLayoutResult) {
        this.params = StaticTextSelectionParams.copy$default(this.params, (LayoutCoordinates) null, textLayoutResult, 1, (Object) null);
    }

    public final void updateGlobalPosition(LayoutCoordinates layoutCoordinates) {
        this.params = StaticTextSelectionParams.copy$default(this.params, layoutCoordinates, (TextLayoutResult) null, 2, (Object) null);
        this.selectionRegistrar.notifyPositionChange(this.selectableId);
    }

    public final void draw(DrawScope drawScope) {
        int i;
        int i2;
        Selection selection = this.selectionRegistrar.getSubselections().get(Long.valueOf(this.selectableId));
        if (selection != null) {
            if (!selection.getHandlesCrossed()) {
                i = selection.getStart().getOffset();
            } else {
                i = selection.getEnd().getOffset();
            }
            if (!selection.getHandlesCrossed()) {
                i2 = selection.getEnd().getOffset();
            } else {
                i2 = selection.getStart().getOffset();
            }
            if (i != i2) {
                Selectable selectable2 = this.selectable;
                int lastVisibleOffset = selectable2 != null ? selectable2.getLastVisibleOffset() : 0;
                Path pathForRange = this.params.getPathForRange(RangesKt.coerceAtMost(i, lastVisibleOffset), RangesKt.coerceAtMost(i2, lastVisibleOffset));
                if (pathForRange != null) {
                    if (this.params.getShouldClip()) {
                        float r8 = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc());
                        float r9 = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc());
                        int r10 = ClipOp.Companion.m3805getIntersectrtfAjoo();
                        DrawContext drawContext = drawScope.getDrawContext();
                        long r1 = drawContext.m4412getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        drawContext.getTransform().m4523clipRectN_I0leg(0.0f, 0.0f, r8, r9, r10);
                        DrawScope.CC.m4466drawPathLG529CI$default(drawScope, pathForRange, this.backgroundSelectionColor, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                        drawContext.getCanvas().restore();
                        drawContext.m4413setSizeuvyYCjk(r1);
                        return;
                    }
                    DrawScope.CC.m4466drawPathLG529CI$default(drawScope, pathForRange, this.backgroundSelectionColor, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                }
            }
        }
    }
}
