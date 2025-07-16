package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jl\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/ListItemDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ListItemColors;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
public final class ListItemDefaults {
    public static final int $stable = 0;
    private static final float Elevation = ListTokens.INSTANCE.m2948getListItemContainerElevationD9Ej5fM();
    public static final ListItemDefaults INSTANCE = new ListItemDefaults();

    private ListItemDefaults() {
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m1943getElevationD9Ej5fM() {
        return Elevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -496871597, "C395@15265L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-496871597, i, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:395)");
        }
        Shape value = ShapesKt.getValue(ListTokens.INSTANCE.getListItemContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1253579929, "C400@15438L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1253579929, i, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItem.kt:400)");
        }
        long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1076068327, "C405@15607L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1076068327, i, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItem.kt:405)");
        }
        long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* renamed from: colors-J08w3-E  reason: not valid java name */
    public final ListItemColors m1942colorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(-352515689);
        ComposerKt.sourceInformation(composer2, "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)426@16675L5,427@16747L5,428@16824L5,429@16895L5,430@16974L5,431@17053L5,432@17141L5,434@17305L5,436@17473L5:ListItem.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemContainerColor(), composer2, 6) : j;
        long value2 = (i3 & 2) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLabelTextColor(), composer2, 6) : j2;
        long value3 = (i3 & 4) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLeadingIconColor(), composer2, 6) : j3;
        long value4 = (i3 & 8) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemOverlineColor(), composer2, 6) : j4;
        long value5 = (i3 & 16) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemSupportingTextColor(), composer2, 6) : j5;
        long value6 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemTrailingIconColor(), composer2, 6) : j6;
        long r20 = (i3 & 64) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemDisabledLabelTextColor(), composer2, 6), ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long r22 = (i3 & 128) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemDisabledLeadingIconColor(), composer2, 6), ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long r24 = (i3 & 256) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemDisabledTrailingIconColor(), composer2, 6), ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-352515689, i, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:439)");
        }
        ListItemColors listItemColors = new ListItemColors(value, value2, value3, value4, value5, value6, r20, r22, r24, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return listItemColors;
    }
}
