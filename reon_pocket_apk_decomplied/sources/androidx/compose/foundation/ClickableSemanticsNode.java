package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\u000eJR\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nø\u0001\u0000¢\u0006\u0002\b\u0013J\f\u0010\u0014\u001a\u00020\u000b*\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/ClickableSemanticsNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "onLongClick", "(ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "()Z", "update", "update-UMe6uN4", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableSemanticsNode extends Modifier.Node implements SemanticsModifierNode {
    private boolean enabled;
    /* access modifiers changed from: private */
    public Function0<Unit> onClick;
    private String onClickLabel;
    /* access modifiers changed from: private */
    public Function0<Unit> onLongClick;
    private String onLongClickLabel;
    private Role role;

    public /* synthetic */ ClickableSemanticsNode(boolean z, String str, Role role2, Function0 function0, String str2, Function0 function02, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, role2, function0, str2, function02);
    }

    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    private ClickableSemanticsNode(boolean z, String str, Role role2, Function0<Unit> function0, String str2, Function0<Unit> function02) {
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role2;
        this.onClick = function0;
        this.onLongClickLabel = str2;
        this.onLongClick = function02;
    }

    /* renamed from: update-UMe6uN4  reason: not valid java name */
    public final void m260updateUMe6uN4(boolean z, String str, Role role2, Function0<Unit> function0, String str2, Function0<Unit> function02) {
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role2;
        this.onClick = function0;
        this.onLongClickLabel = str2;
        this.onLongClick = function02;
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role2 = this.role;
        if (role2 != null) {
            Intrinsics.checkNotNull(role2);
            SemanticsPropertiesKt.m5880setRolekuIjeqM(semanticsPropertyReceiver, role2.m5863unboximpl());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.onClickLabel, new ClickableSemanticsNode$applySemantics$1(this));
        if (this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.onLongClickLabel, new ClickableSemanticsNode$applySemantics$2(this));
        }
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
    }
}
