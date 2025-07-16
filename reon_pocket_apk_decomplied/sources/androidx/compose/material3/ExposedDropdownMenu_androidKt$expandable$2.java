package androidx.compose.material3;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$expandable$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $collapsedDescription;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ String $expandedDescription;
    final /* synthetic */ Function0<Unit> $onExpandedChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$expandable$2(boolean z, String str, String str2, Function0<Unit> function0) {
        super(1);
        this.$expanded = z;
        this.$expandedDescription = str;
        this.$collapsedDescription = str2;
        this.$onExpandedChange = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, this.$expanded ? this.$expandedDescription : this.$collapsedDescription);
        SemanticsPropertiesKt.m5880setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5866getDropdownListo7Vup1c());
        final Function0<Unit> function0 = this.$onExpandedChange;
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                function0.invoke();
                return true;
            }
        }, 1, (Object) null);
    }
}
