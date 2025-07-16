package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/focus/FocusRestorerNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "(Lkotlin/jvm/functions/Function0;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "getOnEnter$annotations", "()V", "onExit", "getOnRestoreFailed", "()Lkotlin/jvm/functions/Function0;", "setOnRestoreFailed", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRestorer.kt */
public final class FocusRestorerNode extends Modifier.Node implements FocusPropertiesModifierNode, FocusRequesterModifierNode {
    public static final int $stable = 8;
    private final Function1<FocusDirection, FocusRequester> onEnter = new FocusRestorerNode$onEnter$1(this);
    private final Function1<FocusDirection, FocusRequester> onExit = new FocusRestorerNode$onExit$1(this);
    private Function0<FocusRequester> onRestoreFailed;

    private static /* synthetic */ void getOnEnter$annotations() {
    }

    public final Function0<FocusRequester> getOnRestoreFailed() {
        return this.onRestoreFailed;
    }

    public final void setOnRestoreFailed(Function0<FocusRequester> function0) {
        this.onRestoreFailed = function0;
    }

    public FocusRestorerNode(Function0<FocusRequester> function0) {
        this.onRestoreFailed = function0;
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setEnter(this.onEnter);
        focusProperties.setExit(this.onExit);
    }
}
