package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b3\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0002\u0010@\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010)J\u0003\u0010@\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010:J\u0003\u0010@\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010?R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "()V", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TrailingIcon", "", "expanded", "", "(ZLandroidx/compose/runtime/Composer;I)V", "outlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "errorTextColor", "errorContainerColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "outlinedTextFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "outlinedTextFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-St-qZLY", "textFieldColors-tN0la-I", "textFieldColors-FD9MK7s", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();
    private static final PaddingValues ItemContentPadding = PaddingKt.m664PaddingValuesYgX7TsA(ExposedDropdownMenu_androidKt.ExposedDropdownMenuItemHorizontalPadding, Dp.m6614constructorimpl((float) 0));

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(boolean z, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-473088613);
        ComposerKt.sourceInformation(startRestartGroup, "C(TrailingIcon)323@14130L129:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473088613, i2, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:322)");
            }
            IconKt.m1903Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), (String) null, RotateKt.rotate(Modifier.Companion, z ? 180.0f : 0.0f), 0, startRestartGroup, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuDefaults$TrailingIcon$1(this, z, i));
        }
    }

    /* renamed from: textFieldColors-FD9MK7s  reason: not valid java name */
    public final TextFieldColors m1850textFieldColorsFD9MK7s(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        long j39;
        int i7;
        long j40;
        int i8;
        long j41;
        int i9;
        long j42;
        int i10;
        long j43;
        int i11;
        long j44;
        int i12;
        Composer composer2 = composer;
        int i13 = i;
        int i14 = i2;
        int i15 = i5;
        int i16 = i6;
        composer2.startReplaceableGroup(768358577);
        ComposerKt.sourceInformation(composer2, "C(textFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,29,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)380@18242L5,381@18330L5,382@18425L5,384@18596L5,385@18691L5,386@18788L5,387@18884L5,388@18977L5,389@19058L5,390@19154L5,391@19233L7,393@19353L5,395@19468L5,397@19590L5,400@19802L5,402@19918L5,404@20031L5,406@20151L5,409@20357L5,411@20475L5,413@20590L5,415@20712L5,418@20921L5,419@21013L5,420@21102L5,421@21198L5,422@21288L5,424@21398L5,426@21510L5,428@21629L5,430@21816L5,431@21909L5,432@22004L5,434@22119L5,435@22284L5,436@22377L5,437@22472L5,439@22587L5,440@22752L5,442@22810L2230:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i15 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer2, 6) : j;
        long value2 = (i15 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer2, 6) : j2;
        long r11 = (i15 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long value3 = (i15 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer2, 6) : j4;
        long value4 = (i15 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer2, 6) : j5;
        long value5 = (i15 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer2, 6) : j6;
        long value6 = (i15 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer2, 6) : j7;
        long value7 = (i15 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer2, 6) : j8;
        long value8 = (i15 & 256) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer2, 6) : j9;
        long value9 = (i15 & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer2, 6) : j10;
        if ((i15 & 1024) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i15 & 2048) != 0) {
            i7 = 6;
            j39 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer2, 6);
        } else {
            i7 = 6;
            j39 = j11;
        }
        long value10 = (i15 & 4096) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer2, i7) : j12;
        long r35 = (i15 & 8192) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer2, i7), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        if ((i15 & 16384) != 0) {
            i8 = 6;
            j40 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer2, 6);
        } else {
            i8 = 6;
            j40 = j14;
        }
        long value11 = (32768 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer2, i8) : j15;
        long value12 = (65536 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer2, i8) : j16;
        long r43 = (131072 & i15) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer2, i8), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        if ((262144 & i15) != 0) {
            i9 = 6;
            j41 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer2, 6);
        } else {
            i9 = 6;
            j41 = j18;
        }
        long value13 = (524288 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer2, i9) : j19;
        long value14 = (1048576 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer2, i9) : j20;
        long r51 = (2097152 & i15) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer2, i9), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21;
        if ((4194304 & i15) != 0) {
            i10 = 6;
            j42 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer2, 6);
        } else {
            i10 = 6;
            j42 = j22;
        }
        long value15 = (8388608 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer2, i10) : j23;
        long value16 = (16777216 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer2, i10) : j24;
        long value17 = (33554432 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer2, i10) : j25;
        long value18 = (67108864 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer2, i10) : j26;
        long value19 = (134217728 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i10) : j27;
        long value20 = (268435456 & i15) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i10) : j28;
        long r76 = (536870912 & i15) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, i10), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j29;
        if ((i15 & 1073741824) != 0) {
            i11 = 6;
            j43 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6);
        } else {
            i11 = 6;
            j43 = j30;
        }
        long value21 = (i16 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i11) : j31;
        long value22 = (i16 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i11) : j32;
        long r84 = (i16 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, i11), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j33;
        if ((i16 & 8) != 0) {
            i12 = 6;
            j44 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6);
        } else {
            i12 = 6;
            j44 = j34;
        }
        long value23 = (i16 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i12) : j35;
        long value24 = (i16 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i12) : j36;
        long r100 = (i16 & 64) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, i12), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j37;
        long value25 = (i16 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j38;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(768358577, i13, i14, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:442)");
        }
        int i17 = i4 << 12;
        int i18 = i4 >> 18;
        TextFieldColors r0 = TextFieldDefaults.INSTANCE.m2425colors0hiis_0(value, value2, r11, value3, value4, value5, value6, value7, value8, value9, textSelectionColors2, j39, value10, r35, j40, value11, value12, r43, j41, value13, value14, r51, j42, value15, value16, value17, value18, value19, value20, r76, j43, 0, 0, 0, 0, value21, value22, r84, j44, value23, value24, r100, value25, composer, i13 & 2147483646, i14 & 2147483646, i3 & 2147483646, (i4 & 14) | (458752 & i17) | (3670016 & i17) | (29360128 & i17) | (234881024 & i17) | (i17 & 1879048192), (i18 & 14) | 3072 | (i18 & 112) | (i18 & 896), 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: outlinedTextFieldColors-FD9MK7s  reason: not valid java name */
    public final TextFieldColors m1847outlinedTextFieldColorsFD9MK7s(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        long j39;
        int i7;
        long j40;
        int i8;
        long j41;
        int i9;
        long j42;
        int i10;
        long j43;
        int i11;
        long j44;
        int i12;
        long j45;
        int i13;
        Composer composer2 = composer;
        int i14 = i;
        int i15 = i2;
        int i16 = i5;
        int i17 = i6;
        composer2.startReplaceableGroup(-1567195085);
        ComposerKt.sourceInformation(composer2, "C(outlinedTextFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,29,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)533@29005L5,534@29095L5,535@29192L5,537@29367L5,542@29683L5,544@29793L5,545@29872L7,546@29971L5,547@30065L5,549@30178L5,551@30363L5,553@30481L5,555@30596L5,557@30718L5,560@30928L5,562@31048L5,564@31165L5,566@31289L5,569@31502L5,570@31596L5,571@31687L5,572@31785L5,574@31961L5,576@32073L5,578@32187L5,580@32308L5,583@32511L5,584@32606L5,585@32703L5,587@32820L5,588@32989L5,589@33084L5,590@33181L5,592@33298L5,593@33467L5,595@33533L2206:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i16 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer2, 6) : j;
        long value2 = (i16 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer2, 6) : j2;
        long r11 = (i16 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long value3 = (i16 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer2, 6) : j4;
        long r16 = (i16 & 16) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j5;
        long r18 = (i16 & 32) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j6;
        long r20 = (i16 & 64) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j7;
        long r22 = (i16 & 128) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j8;
        long value4 = (i16 & 256) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer2, 6) : j9;
        long value5 = (i16 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer2, 6) : j10;
        if ((i16 & 1024) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i16 & 2048) != 0) {
            i7 = 6;
            j39 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer2, 6);
        } else {
            i7 = 6;
            j39 = j11;
        }
        long value6 = (i16 & 4096) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer2, i7) : j12;
        long r35 = (i16 & 8192) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer2, i7), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        if ((i16 & 16384) != 0) {
            i8 = 6;
            j40 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer2, 6);
        } else {
            i8 = 6;
            j40 = j14;
        }
        long value7 = (32768 & i16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer2, i8) : j15;
        long value8 = (65536 & i16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer2, i8) : j16;
        long r43 = (131072 & i16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer2, i8), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        if ((262144 & i16) != 0) {
            i9 = 6;
            j41 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer2, 6);
        } else {
            i9 = 6;
            j41 = j18;
        }
        long value9 = (524288 & i16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer2, i9) : j19;
        long value10 = (1048576 & i16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer2, i9) : j20;
        long r51 = (2097152 & i16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer2, i9), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21;
        if ((4194304 & i16) != 0) {
            i10 = 6;
            j42 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer2, 6);
        } else {
            i10 = 6;
            j42 = j22;
        }
        long value11 = (8388608 & i16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer2, i10) : j23;
        long value12 = (16777216 & i16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer2, i10) : j24;
        long r59 = (33554432 & i16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer2, i10), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j25;
        if ((67108864 & i16) != 0) {
            i11 = 6;
            j43 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer2, 6);
        } else {
            i11 = 6;
            j43 = j26;
        }
        long value13 = (134217728 & i16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i11) : j27;
        long value14 = (268435456 & i16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i11) : j28;
        long r76 = (536870912 & i16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, i11), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j29;
        if ((i16 & 1073741824) != 0) {
            i12 = 6;
            j44 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6);
        } else {
            i12 = 6;
            j44 = j30;
        }
        long value15 = (i17 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i12) : j31;
        long value16 = (i17 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i12) : j32;
        long r84 = (i17 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, i12), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j33;
        if ((i17 & 8) != 0) {
            i13 = 6;
            j45 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6);
        } else {
            i13 = 6;
            j45 = j34;
        }
        long value17 = (i17 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i13) : j35;
        long value18 = (i17 & 32) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, i13) : j36;
        long r100 = (i17 & 64) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, i13), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j37;
        long value19 = (i17 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j38;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1567195085, i14, i15, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:595)");
        }
        int i18 = i4 << 12;
        int i19 = i4 >> 18;
        TextFieldColors r0 = OutlinedTextFieldDefaults.INSTANCE.m2040colors0hiis_0(value, value2, r11, value3, r16, r18, r20, r22, value4, value5, textSelectionColors2, j39, value6, r35, j40, value7, value8, r43, j41, value9, value10, r51, j42, value11, value12, r59, j43, value13, value14, r76, j44, 0, 0, 0, 0, value15, value16, r84, j45, value17, value18, r100, value19, composer, i14 & 2147483646, i15 & 2147483646, i3 & 2147483646, (i4 & 14) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (234881024 & i18) | (i18 & 1879048192), (i19 & 14) | 3072 | (i19 & 112) | (i19 & 896), 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-tN0la-I  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1852textFieldColorstN0laI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i7 = i;
        int i8 = i2;
        int i9 = i5;
        composer2.startReplaceableGroup(611690079);
        ComposerKt.sourceInformation(composer2, "C(textFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)649@36278L5,650@36366L5,651@36461L5,653@36632L5,654@36720L5,655@36813L5,656@36894L5,657@36990L5,658@37069L7,660@37189L5,662@37304L5,664@37426L5,667@37638L5,669@37754L5,671@37867L5,673@37987L5,676@38193L5,678@38311L5,680@38426L5,682@38548L5,685@38757L5,686@38849L5,687@38938L5,688@39034L5,689@39124L5,691@39234L5,693@39346L5,695@39465L5,697@39652L5,698@39745L5,699@39840L5,701@39955L5,702@40120L5,703@40213L5,704@40308L5,706@40423L5,707@40588L5,709@40628L2215:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i9 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer2, 6) : j;
        long value2 = (i9 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer2, 6) : j2;
        long r10 = (i9 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long value3 = (i9 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer2, 6) : j4;
        long value4 = (i9 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer2, 6) : j5;
        long value5 = (i9 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer2, 6) : j6;
        long value6 = (i9 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer2, 6) : j7;
        long value7 = (i9 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer2, 6) : j8;
        if ((i9 & 256) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value8 = (i9 & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer2, 6) : j9;
        long value9 = (i9 & 1024) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer2, 6) : j10;
        long r30 = (i9 & 2048) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long value10 = (i9 & 4096) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer2, 6) : j12;
        long value11 = (i9 & 8192) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer2, 6) : j13;
        long value12 = (i9 & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer2, 6) : j14;
        long r38 = (32768 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j15;
        long value13 = (65536 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer2, 6) : j16;
        long value14 = (131072 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer2, 6) : j17;
        long value15 = (262144 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer2, 6) : j18;
        long r46 = (524288 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j19;
        long value16 = (1048576 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer2, 6) : j20;
        long value17 = (2097152 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer2, 6) : j21;
        long value18 = (4194304 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer2, 6) : j22;
        long value19 = (8388608 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer2, 6) : j23;
        long value20 = (16777216 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer2, 6) : j24;
        long value21 = (33554432 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j25;
        long value22 = (67108864 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j26;
        long r62 = (134217728 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j27;
        long value23 = (268435456 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j28;
        long value24 = (536870912 & i9) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j29;
        long value25 = (i9 & 1073741824) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j30;
        long r70 = (i6 & 1) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j31;
        long value26 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j32;
        long value27 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j33;
        long value28 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j34;
        long r85 = (i6 & 16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j35;
        long value29 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j36;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611690079, i7, i8, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:709)");
        }
        int i10 = i7 << 6;
        int i11 = i8 << 6;
        int i12 = i3 << 6;
        int i13 = ((i8 >> 24) & 126) | (i12 & 896) | (i12 & 7168) | (i12 & 57344) | (i12 & 458752) | (i12 & 3670016) | (i12 & 29360128) | (i12 & 234881024) | (i12 & 1879048192);
        int i14 = i4 << 6;
        TextFieldColors r0 = m1850textFieldColorsFD9MK7s(value, value2, r10, value3, value4, value4, value4, value5, value6, value7, textSelectionColors2, value8, value9, r30, value10, value11, value12, r38, value13, value14, value15, r46, value16, value17, value18, value19, value20, value21, value22, r62, value23, value24, value25, r70, value26, value27, value28, r85, value29, composer, (65534 & i7) | ((i7 << 3) & 458752) | (i10 & 3670016) | (i10 & 29360128) | (i10 & 234881024) | (i10 & 1879048192), ((i7 >> 24) & 126) | (i11 & 896) | (i11 & 7168) | (i11 & 57344) | (i11 & 458752) | (i11 & 3670016) | (i11 & 29360128) | (i11 & 234881024) | (i11 & 1879048192), i13, ((i3 >> 24) & 126) | (i14 & 896) | (i14 & 7168) | (i14 & 57344) | (i14 & 458752) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-tN0la-I  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1849outlinedTextFieldColorstN0laI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i7 = i;
        int i8 = i2;
        int i9 = i5;
        composer2.startReplaceableGroup(-388128543);
        ComposerKt.sourceInformation(composer2, "C(outlinedTextFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)754@43068L5,755@43158L5,756@43255L5,758@43430L5,761@43620L5,763@43730L5,764@43809L7,765@43908L5,766@44002L5,768@44115L5,770@44300L5,772@44418L5,774@44533L5,776@44655L5,779@44865L5,781@44985L5,783@45102L5,785@45226L5,788@45439L5,789@45533L5,790@45624L5,791@45722L5,793@45898L5,795@46010L5,797@46124L5,799@46245L5,802@46448L5,803@46543L5,804@46640L5,806@46757L5,807@46926L5,808@47021L5,809@47118L5,811@47235L5,812@47404L5,814@47444L2199:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i9 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer2, 6) : j;
        long value2 = (i9 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer2, 6) : j2;
        long r10 = (i9 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long value3 = (i9 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer2, 6) : j4;
        long r16 = (i9 & 16) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j5;
        long r18 = (i9 & 32) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j6;
        long value4 = (i9 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer2, 6) : j7;
        long value5 = (i9 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer2, 6) : j8;
        if ((i9 & 256) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value6 = (i9 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer2, 6) : j9;
        long value7 = (i9 & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer2, 6) : j10;
        long r30 = (i9 & 2048) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long value8 = (i9 & 4096) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer2, 6) : j12;
        long value9 = (i9 & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer2, 6) : j13;
        long value10 = (i9 & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer2, 6) : j14;
        long r38 = (32768 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j15;
        long value11 = (65536 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer2, 6) : j16;
        long value12 = (131072 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer2, 6) : j17;
        long value13 = (262144 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer2, 6) : j18;
        long r46 = (524288 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j19;
        long value14 = (1048576 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer2, 6) : j20;
        long value15 = (2097152 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer2, 6) : j21;
        long value16 = (4194304 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer2, 6) : j22;
        long r54 = (8388608 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        long value17 = (16777216 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer2, 6) : j24;
        long value18 = (33554432 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j25;
        long value19 = (67108864 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j26;
        long r62 = (134217728 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j27;
        long value20 = (268435456 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j28;
        long value21 = (536870912 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j29;
        long value22 = (i9 & 1073741824) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j30;
        long r70 = (i6 & 1) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j31;
        long value23 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j32;
        long value24 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j33;
        long value25 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j34;
        long r85 = (i6 & 16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j35;
        long value26 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j36;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-388128543, i7, i8, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:814)");
        }
        int i10 = i7 << 6;
        int i11 = i8 << 6;
        int i12 = i3 << 6;
        int i13 = ((i8 >> 24) & 126) | (i12 & 896) | (i12 & 7168) | (i12 & 57344) | (i12 & 458752) | (i12 & 3670016) | (i12 & 29360128) | (i12 & 234881024) | (i12 & 1879048192);
        int i14 = i4 << 6;
        TextFieldColors r0 = m1847outlinedTextFieldColorsFD9MK7s(value, value2, r10, value3, r16, r16, r16, r18, value4, value5, textSelectionColors2, value6, value7, r30, value8, value9, value10, r38, value11, value12, value13, r46, value14, value15, value16, r54, value17, value18, value19, r62, value20, value21, value22, r70, value23, value24, value25, r85, value26, composer, (65534 & i7) | ((i7 << 3) & 458752) | (i10 & 3670016) | (i10 & 29360128) | (i10 & 234881024) | (i10 & 1879048192), ((i7 >> 24) & 126) | (i11 & 896) | (i11 & 7168) | (i11 & 57344) | (i11 & 458752) | (i11 & 3670016) | (i11 & 29360128) | (i11 & 234881024) | (i11 & 1879048192), i13, ((i3 >> 24) & 126) | (i14 & 896) | (i14 & 7168) | (i14 & 57344) | (i14 & 458752) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-St-qZLY  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1851textFieldColorsStqZLY(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, Composer composer, int i, int i2, int i3, int i4) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i5 = i;
        int i6 = i2;
        int i7 = i4;
        composer2.startReplaceableGroup(-1343678550);
        ComposerKt.sourceInformation(composer2, "C(textFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)859@49846L5,860@49941L5,862@50111L5,863@50192L5,864@50288L5,865@50367L7,867@50487L5,869@50602L5,871@50724L5,874@50936L5,876@51052L5,878@51165L5,880@51285L5,883@51491L5,885@51609L5,887@51724L5,889@51846L5,892@52055L5,893@52147L5,894@52236L5,895@52332L5,896@52422L5,897@52513L5,899@52627L5,933@54432L5,934@54522L5,935@54619L5,937@54794L5,938@54882L5,939@54972L5,940@55069L5,942@55244L5,901@52744L2512:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i7 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer2, 6) : j;
        long r9 = (i7 & 2) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long value2 = (i7 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer2, 6) : j3;
        long value3 = (i7 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer2, 6) : j4;
        long value4 = (i7 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer2, 6) : j5;
        if ((i7 & 32) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value5 = (i7 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer2, 6) : j6;
        long value6 = (i7 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer2, 6) : j7;
        long r27 = (i7 & 256) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long value7 = (i7 & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer2, 6) : j9;
        long value8 = (i7 & 1024) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer2, 6) : j10;
        long value9 = (i7 & 2048) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer2, 6) : j11;
        long r35 = (i7 & 4096) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j12;
        long value10 = (i7 & 8192) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer2, 6) : j13;
        long value11 = (i7 & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer2, 6) : j14;
        long value12 = (32768 & i7) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer2, 6) : j15;
        long r43 = (65536 & i7) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long value13 = (131072 & i7) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer2, 6) : j17;
        long value14 = (262144 & i7) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer2, 6) : j18;
        long value15 = (524288 & i7) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer2, 6) : j19;
        long value16 = (1048576 & i7) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer2, 6) : j20;
        long value17 = (2097152 & i7) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer2, 6) : j21;
        long value18 = (4194304 & i7) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j22;
        long r58 = (i7 & 8388608) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1343678550, i5, i6, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:901)");
        }
        int i8 = i5 << 3;
        int i9 = (i5 & 14) | (i8 & 112) | (i8 & 896);
        int i10 = i5 << 9;
        int i11 = i9 | (i10 & 7168) | ((i5 << 6) & 57344) | (i10 & 458752) | ((i5 << 12) & 3670016);
        int i12 = i5 << 15;
        int i13 = i11 | (i12 & 29360128) | (i12 & 234881024) | (i12 & 1879048192);
        int i14 = i6 << 15;
        int i15 = i3 << 15;
        int i16 = i3 << 18;
        TextFieldColors r0 = m1850textFieldColorsFD9MK7s(value, value, r9, value, value2, value2, value2, value2, value3, value4, textSelectionColors2, value5, value6, r27, value7, value8, value9, r35, value10, value11, value12, r43, value13, value14, value15, value16, value17, value18, value18, r58, value18, ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), composer, i13, ((i5 >> 15) & 65534) | (i14 & 458752) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192), ((i6 >> 15) & 65534) | (i15 & 458752) | (i15 & 3670016) | (i15 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), ((i3 >> 6) & 14) | (i15 & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-St-qZLY  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1848outlinedTextFieldColorsStqZLY(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, Composer composer, int i, int i2, int i3, int i4) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i5 = i;
        int i6 = i2;
        int i7 = i4;
        composer2.startReplaceableGroup(-836383316);
        ComposerKt.sourceInformation(composer2, "C(outlinedTextFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)948@55469L5,949@55566L5,952@55784L5,954@55894L5,955@55973L7,956@56072L5,957@56166L5,959@56279L5,961@56464L5,963@56582L5,965@56697L5,967@56819L5,970@57029L5,972@57149L5,974@57266L5,976@57390L5,979@57603L5,980@57697L5,981@57788L5,982@57886L5,984@58062L5,985@58155L5,987@58271L5,1021@60062L5,1022@60152L5,1023@60249L5,1025@60424L5,1026@60512L5,1027@60602L5,1028@60699L5,1030@60874L5,989@58390L2496:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i7 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer2, 6) : j;
        long r9 = (i7 & 2) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r16 = (i7 & 4) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j3;
        long value2 = (i7 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer2, 6) : j4;
        long value3 = (i7 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer2, 6) : j5;
        if ((i7 & 32) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i7 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer2, 6) : j6;
        long value5 = (i7 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer2, 6) : j7;
        long r27 = (i7 & 256) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long value6 = (i7 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer2, 6) : j9;
        long value7 = (i7 & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer2, 6) : j10;
        long value8 = (i7 & 2048) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer2, 6) : j11;
        long r35 = (i7 & 4096) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j12;
        long value9 = (i7 & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer2, 6) : j13;
        long value10 = (i7 & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer2, 6) : j14;
        long value11 = (32768 & i7) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer2, 6) : j15;
        long r43 = (65536 & i7) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long value12 = (131072 & i7) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer2, 6) : j17;
        long value13 = (262144 & i7) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer2, 6) : j18;
        long value14 = (524288 & i7) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer2, 6) : j19;
        long r51 = (1048576 & i7) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j20;
        long value15 = (2097152 & i7) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer2, 6) : j21;
        long value16 = (4194304 & i7) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j22;
        long r58 = (i7 & 8388608) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-836383316, i5, i6, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:989)");
        }
        int i8 = i5 << 3;
        int i9 = (i5 & 14) | (i8 & 112) | (i8 & 896);
        int i10 = i5 << 9;
        int i11 = i9 | (i10 & 7168) | ((i5 << 6) & 57344) | (i10 & 458752) | ((i5 << 12) & 3670016);
        int i12 = i5 << 15;
        int i13 = i11 | (i12 & 29360128) | (i12 & 234881024) | (i12 & 1879048192);
        int i14 = i6 << 15;
        int i15 = i3 << 15;
        int i16 = i3 << 18;
        TextFieldColors r0 = m1847outlinedTextFieldColorsFD9MK7s(value, value, r9, value, r16, r16, r16, r16, value2, value3, textSelectionColors2, value4, value5, r27, value6, value7, value8, r35, value9, value10, value11, r43, value12, value13, value14, r51, value15, value16, value16, r58, value16, ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6), composer, i13, ((i5 >> 15) & 65534) | (i14 & 458752) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192), ((i6 >> 15) & 65534) | (i15 & 458752) | (i15 & 3670016) | (i15 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), ((i3 >> 6) & 14) | (i15 & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }
}
