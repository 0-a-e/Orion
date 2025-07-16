package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/material3/ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "exposedDropdownSize", "Landroidx/compose/ui/Modifier;", "matchTextFieldWidth", "", "menuAnchor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public final class ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 extends ExposedDropdownMenuBoxScope {
    final /* synthetic */ MutableState<LayoutCoordinates> $anchorCoordinates$delegate;
    final /* synthetic */ MutableIntState $anchorWidth$delegate;
    final /* synthetic */ String $collapsedDescription;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ String $expandedDescription;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ MutableIntState $menuMaxHeight$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    final /* synthetic */ int $verticalMargin;
    final /* synthetic */ View $view;

    ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1(boolean z, String str, String str2, FocusRequester focusRequester, View view, int i, MutableState<LayoutCoordinates> mutableState, MutableIntState mutableIntState, MutableIntState mutableIntState2, Function1<? super Boolean, Unit> function1) {
        this.$expanded = z;
        this.$expandedDescription = str;
        this.$collapsedDescription = str2;
        this.$focusRequester = focusRequester;
        this.$view = view;
        this.$verticalMargin = i;
        this.$anchorCoordinates$delegate = mutableState;
        this.$anchorWidth$delegate = mutableIntState;
        this.$menuMaxHeight$delegate = mutableIntState2;
        this.$onExpandedChange = function1;
    }

    public Modifier menuAnchor(Modifier modifier) {
        return FocusRequesterModifierKt.focusRequester(ExposedDropdownMenu_androidKt.expandable(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, new ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1(this.$view, this.$verticalMargin, this.$anchorCoordinates$delegate, this.$anchorWidth$delegate, this.$menuMaxHeight$delegate)), this.$expanded, new ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(this.$onExpandedChange, this.$expanded), this.$expandedDescription, this.$collapsedDescription), this.$focusRequester);
    }

    public Modifier exposedDropdownSize(Modifier modifier, boolean z) {
        return LayoutModifierKt.layout(modifier, new ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1(z, this.$anchorWidth$delegate, this.$menuMaxHeight$delegate));
    }
}
