package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$DockedSearchBar$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $active;
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onActiveChange;
    final /* synthetic */ Function1<String, Unit> $onQueryChange;
    final /* synthetic */ Function1<String, Unit> $onSearch;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ String $query;
    final /* synthetic */ float $shadowElevation;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $tonalElevation;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$DockedSearchBar$5(String str, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z, Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, MutableInteractionSource mutableInteractionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2, int i3) {
        super(2);
        this.$query = str;
        this.$onQueryChange = function1;
        this.$onSearch = function12;
        this.$active = z;
        this.$onActiveChange = function13;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$placeholder = function2;
        this.$leadingIcon = function22;
        this.$trailingIcon = function23;
        this.$shape = shape;
        this.$colors = searchBarColors;
        this.$tonalElevation = f;
        this.$shadowElevation = f2;
        this.$interactionSource = mutableInteractionSource;
        this.$content = function3;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        String str = this.$query;
        String str2 = str;
        SearchBar_androidKt.m2116DockedSearchBareWTbjVg(str2, this.$onQueryChange, this.$onSearch, this.$active, this.$onActiveChange, this.$modifier, this.$enabled, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$shape, this.$colors, this.$tonalElevation, this.$shadowElevation, this.$interactionSource, this.$content, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
