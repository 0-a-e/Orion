package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.compress.archivers.zip.UnixStat;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0001\u0010 \u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u001e2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010&\u001a\u00020\u001e2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001e2\b\b\u0002\u0010*\u001a\u00020\u001e2\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010,\u001a\u00020\u001e2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u00020\u001e2\b\b\u0002\u00100\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0001\u0010 \u001a\u00020!2\b\b\u0002\u00103\u001a\u00020\u001e2\b\b\u0002\u00104\u001a\u00020\u001e2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010&\u001a\u00020\u001e2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001e2\b\b\u0002\u0010*\u001a\u00020\u001e2\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010,\u001a\u00020\u001e2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u00020\u001e2\b\b\u0002\u00100\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b7\u00108R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "()F", "F", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "ShadowElevation", "getShadowElevation-D9Ej5fM", "TonalElevation", "getTonalElevation-D9Ej5fM", "dockedShape", "Landroidx/compose/ui/graphics/Shape;", "getDockedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "inputFieldShape", "getInputFieldShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "textColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "placeholderColor", "disabledPlaceholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
public final class SearchBarDefaults {
    public static final int $stable = 0;
    private static final float Elevation;
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float InputFieldHeight = SearchBarTokens.INSTANCE.m3118getContainerHeightD9Ej5fM();
    private static final float ShadowElevation = ElevationTokens.INSTANCE.m2817getLevel0D9Ej5fM();
    private static final float TonalElevation;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(expression = "TonalElevation", imports = {}))
    /* renamed from: getElevation-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m2108getElevationD9Ej5fM$annotations() {
    }

    private SearchBarDefaults() {
    }

    static {
        float r0 = SearchBarTokens.INSTANCE.m3117getContainerElevationD9Ej5fM();
        TonalElevation = r0;
        Elevation = r0;
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m2113getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* renamed from: getShadowElevation-D9Ej5fM  reason: not valid java name */
    public final float m2112getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m2110getElevationD9Ej5fM() {
        return Elevation;
    }

    /* renamed from: getInputFieldHeight-D9Ej5fM  reason: not valid java name */
    public final float m2111getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer composer, int i) {
        composer.startReplaceableGroup(-971556142);
        ComposerKt.sourceInformation(composer, "C523@24182L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-971556142, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.android.kt:523)");
        }
        Shape value = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getFullScreenShape(Composer composer, int i) {
        composer.startReplaceableGroup(1665502056);
        ComposerKt.sourceInformation(composer, "C527@24354L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1665502056, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.android.kt:527)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getDockedShape(Composer composer, int i) {
        composer.startReplaceableGroup(1006952150);
        ComposerKt.sourceInformation(composer, "C530@24496L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006952150, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.android.kt:530)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        composer.startReplaceableGroup(2112270157);
        ComposerKt.sourceInformation(composer, "C533@24623L10:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2112270157, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.android.kt:533)");
        }
        WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return statusBars;
    }

    /* renamed from: colors-Klgx-Pg  reason: not valid java name */
    public final SearchBarColors m2109colorsKlgxPg(long j, long j2, TextFieldColors textFieldColors, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(-1216168196);
        ComposerKt.sourceInformation(composer2, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)545@25112L5,546@25179L5,547@25230L18:SearchBar.android.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer2, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer2, 6) : j2;
        TextFieldColors r10 = (i2 & 4) != 0 ? m2115inputFieldColorsITpI4ow(0, 0, 0, 0, (TextSelectionColors) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, composer, 0, (i3 << 3) & 57344, 16383) : textFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216168196, i, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:548)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(value, value2, r10, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return searchBarColors;
    }

    /* renamed from: inputFieldColors-ITpI4ow  reason: not valid java name */
    public final TextFieldColors m2115inputFieldColorsITpI4ow(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        composer2.startReplaceableGroup(-602148837);
        ComposerKt.sourceInformation(composer2, "C(inputFieldColors)P(7:c#ui.graphics.Color,12:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,9,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color)580@27197L5,581@27271L5,582@27354L5,584@27493L5,585@27572L7,586@27655L5,587@27738L5,589@27847L5,590@27993L5,591@28078L5,593@28189L5,594@28337L5,595@28423L5,596@28513L5,599@28641L847:SearchBar.android.kt#uh7d8r");
        long value = (i6 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer2, 6) : j;
        long value2 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer2, 6) : j2;
        long r32 = (i6 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long value3 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer2, 6) : j4;
        if ((i6 & 16) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j5;
        long value5 = (i6 & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j6;
        long r42 = (i6 & 128) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long value6 = (i6 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j8;
        long value7 = (i6 & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j9;
        long r58 = (i6 & 1024) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        long value8 = (i6 & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer2, 6) : j11;
        long value9 = (i6 & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer2, 6) : j12;
        long r98 = (i6 & 8192) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-602148837, i4, i5, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:599)");
        }
        int i7 = i5 << 18;
        TextFieldColors r0 = TextFieldDefaults.INSTANCE.m2425colors0hiis_0(value, value2, r32, 0, 0, 0, 0, 0, value3, 0, textSelectionColors2, 0, 0, 0, 0, value4, value5, r42, 0, value6, value7, r58, 0, 0, 0, 0, 0, value8, value9, r98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, composer, (i4 & 1022) | ((i4 << 15) & 234881024), ((i4 >> 12) & 14) | (458752 & i4) | (3670016 & i4) | (i4 & 29360128) | ((i4 << 3) & 1879048192), ((i4 >> 27) & 14) | ((i5 << 3) & 112) | (i7 & 29360128) | (i7 & 234881024) | (i7 & 1879048192), 0, 3072, 1204058872, UnixStat.PERM_MASK);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: inputFieldColors--u-KgnY  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2114inputFieldColorsuKgnY(long j, long j2, long j3, TextSelectionColors textSelectionColors, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        composer2.startReplaceableGroup(355927049);
        ComposerKt.sourceInformation(composer2, "C(inputFieldColors)P(9:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,8,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,4:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color)619@29678L5,620@29761L5,622@29900L5,623@29979L7,624@30062L5,625@30145L5,627@30254L5,628@30400L5,629@30485L5,631@30596L5,632@30737L5,633@30827L5,635@30912L765:SearchBar.android.kt#uh7d8r");
        long value = (i6 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer2, 6) : j;
        long r8 = (i6 & 2) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long value2 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer2, 6) : j3;
        if ((i6 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value3 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j4;
        long value4 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j5;
        long r19 = (i6 & 64) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long value5 = (i6 & 128) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j7;
        long value6 = (i6 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j8;
        long r25 = (i6 & 512) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j9;
        long value7 = (i6 & 1024) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer2, 6) : j10;
        long r32 = (i6 & 2048) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(355927049, i4, i5, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:635)");
        }
        int i7 = i4 << 3;
        int i8 = i5 << 6;
        TextFieldColors r0 = m2115inputFieldColorsITpI4ow(value, value, r8, value2, textSelectionColors2, value3, value4, r19, value5, value6, r25, value7, value7, r32, composer, (i4 & 14) | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (i7 & 57344) | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (i7 & 1879048192), ((i4 >> 27) & 14) | ((i5 << 3) & 112) | (i8 & 896) | (i8 & 7168) | (i8 & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }
}
