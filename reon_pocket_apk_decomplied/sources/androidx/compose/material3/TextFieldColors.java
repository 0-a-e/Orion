package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BÝ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0002\u0010/J-\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0004\bh\u0010iJÀ\u0003\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010e\u001a\u00020dH\u0001¢\u0006\u0004\bm\u0010nJ\u0013\u0010o\u001a\u00020d2\b\u0010p\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010q\u001a\u00020rH\u0016J-\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0004\bt\u0010iJ-\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0004\bv\u0010iJ-\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0004\bx\u0010iJ-\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0004\bz\u0010iJ-\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0004\b|\u0010iJ-\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0004\b~\u0010iJ.\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0005\b\u0001\u0010iJ/\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0005\b\u0001\u0010iJ/\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0005\b\u0001\u0010iJ%\u0010\u0001\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0001H\u0000¢\u0006\u0003\b\u0001R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b4\u00101R\u0019\u0010\u001d\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b5\u00101R\u0019\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b6\u00101R\u0019\u0010!\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b7\u00101R\u0019\u0010)\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b8\u00101R\u0019\u0010-\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b9\u00101R\u0019\u0010%\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b:\u00101R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b;\u00101R\u0019\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b<\u00101R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b=\u00101R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b>\u00101R\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b?\u00101R\u0019\u0010\u001e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b@\u00101R\u0019\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bA\u00101R\u0019\u0010\"\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bB\u00101R\u0019\u0010*\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bC\u00101R\u0019\u0010.\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bD\u00101R\u0019\u0010&\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bE\u00101R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bF\u00101R\u0019\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bG\u00101R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bH\u00101R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bI\u00101R\u0019\u0010\u001b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bJ\u00101R\u0019\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bK\u00101R\u0019\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bL\u00101R\u0019\u0010'\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bM\u00101R\u0019\u0010+\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bN\u00101R\u0019\u0010#\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bO\u00101R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bP\u00101R\u0019\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bQ\u00101R\u0014\u0010R\u001a\u00020\u000e8AX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bW\u00101R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bX\u00101R\u0019\u0010\u001c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bY\u00101R\u0019\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bZ\u00101R\u0019\u0010 \u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b[\u00101R\u0019\u0010(\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b\\\u00101R\u0019\u0010,\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b]\u00101R\u0019\u0010$\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b^\u00101R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b_\u00101R\u0019\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b`\u00101\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020dX\u0002"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCursorColor-0d7_KjU", "()J", "J", "getDisabledContainerColor-0d7_KjU", "getDisabledIndicatorColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getDisabledPlaceholderColor-0d7_KjU", "getDisabledPrefixColor-0d7_KjU", "getDisabledSuffixColor-0d7_KjU", "getDisabledSupportingTextColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getErrorContainerColor-0d7_KjU", "getErrorCursorColor-0d7_KjU", "getErrorIndicatorColor-0d7_KjU", "getErrorLabelColor-0d7_KjU", "getErrorLeadingIconColor-0d7_KjU", "getErrorPlaceholderColor-0d7_KjU", "getErrorPrefixColor-0d7_KjU", "getErrorSuffixColor-0d7_KjU", "getErrorSupportingTextColor-0d7_KjU", "getErrorTextColor-0d7_KjU", "getErrorTrailingIconColor-0d7_KjU", "getFocusedContainerColor-0d7_KjU", "getFocusedIndicatorColor-0d7_KjU", "getFocusedLabelColor-0d7_KjU", "getFocusedLeadingIconColor-0d7_KjU", "getFocusedPlaceholderColor-0d7_KjU", "getFocusedPrefixColor-0d7_KjU", "getFocusedSuffixColor-0d7_KjU", "getFocusedSupportingTextColor-0d7_KjU", "getFocusedTextColor-0d7_KjU", "getFocusedTrailingIconColor-0d7_KjU", "selectionColors", "getSelectionColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getUnfocusedContainerColor-0d7_KjU", "getUnfocusedIndicatorColor-0d7_KjU", "getUnfocusedLabelColor-0d7_KjU", "getUnfocusedLeadingIconColor-0d7_KjU", "getUnfocusedPlaceholderColor-0d7_KjU", "getUnfocusedPrefixColor-0d7_KjU", "getUnfocusedSuffixColor-0d7_KjU", "getUnfocusedSupportingTextColor-0d7_KjU", "getUnfocusedTextColor-0d7_KjU", "getUnfocusedTrailingIconColor-0d7_KjU", "containerColor", "Landroidx/compose/runtime/State;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "containerColor$material3_release", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "copy", "copy-ejIjP34", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/TextFieldColors;", "cursorColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "indicatorColor", "indicatorColor$material3_release", "labelColor", "labelColor$material3_release", "leadingIconColor", "leadingIconColor$material3_release", "placeholderColor", "placeholderColor$material3_release", "prefixColor", "prefixColor$material3_release", "suffixColor", "suffixColor$material3_release", "supportingTextColor", "supportingTextColor$material3_release", "textColor", "textColor$material3_release", "trailingIconColor", "trailingIconColor$material3_release", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3_release", "material3_release", "focused"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldColors {
    public static final int $stable = 0;
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors2, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, textSelectionColors2, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42);
    }

    private TextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors2, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42) {
        this.focusedTextColor = j;
        this.unfocusedTextColor = j2;
        this.disabledTextColor = j3;
        this.errorTextColor = j4;
        this.focusedContainerColor = j5;
        this.unfocusedContainerColor = j6;
        this.disabledContainerColor = j7;
        this.errorContainerColor = j8;
        this.cursorColor = j9;
        this.errorCursorColor = j10;
        this.textSelectionColors = textSelectionColors2;
        this.focusedIndicatorColor = j11;
        this.unfocusedIndicatorColor = j12;
        this.disabledIndicatorColor = j13;
        this.errorIndicatorColor = j14;
        this.focusedLeadingIconColor = j15;
        this.unfocusedLeadingIconColor = j16;
        this.disabledLeadingIconColor = j17;
        this.errorLeadingIconColor = j18;
        this.focusedTrailingIconColor = j19;
        this.unfocusedTrailingIconColor = j20;
        this.disabledTrailingIconColor = j21;
        this.errorTrailingIconColor = j22;
        this.focusedLabelColor = j23;
        this.unfocusedLabelColor = j24;
        this.disabledLabelColor = j25;
        this.errorLabelColor = j26;
        this.focusedPlaceholderColor = j27;
        this.unfocusedPlaceholderColor = j28;
        this.disabledPlaceholderColor = j29;
        this.errorPlaceholderColor = j30;
        this.focusedSupportingTextColor = j31;
        this.unfocusedSupportingTextColor = j32;
        this.disabledSupportingTextColor = j33;
        this.errorSupportingTextColor = j34;
        this.focusedPrefixColor = j35;
        this.unfocusedPrefixColor = j36;
        this.disabledPrefixColor = j37;
        this.errorPrefixColor = j38;
        this.focusedSuffixColor = j39;
        this.unfocusedSuffixColor = j40;
        this.disabledSuffixColor = j41;
        this.errorSuffixColor = j42;
    }

    /* renamed from: getFocusedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2403getFocusedTextColor0d7_KjU() {
        return this.focusedTextColor;
    }

    /* renamed from: getUnfocusedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2413getUnfocusedTextColor0d7_KjU() {
        return this.unfocusedTextColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU  reason: not valid java name */
    public final long m2382getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* renamed from: getErrorTextColor-0d7_KjU  reason: not valid java name */
    public final long m2393getErrorTextColor0d7_KjU() {
        return this.errorTextColor;
    }

    /* renamed from: getFocusedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2395getFocusedContainerColor0d7_KjU() {
        return this.focusedContainerColor;
    }

    /* renamed from: getUnfocusedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2405getUnfocusedContainerColor0d7_KjU() {
        return this.unfocusedContainerColor;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2374getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* renamed from: getErrorContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2384getErrorContainerColor0d7_KjU() {
        return this.errorContainerColor;
    }

    /* renamed from: getCursorColor-0d7_KjU  reason: not valid java name */
    public final long m2373getCursorColor0d7_KjU() {
        return this.cursorColor;
    }

    /* renamed from: getErrorCursorColor-0d7_KjU  reason: not valid java name */
    public final long m2385getErrorCursorColor0d7_KjU() {
        return this.errorCursorColor;
    }

    public final TextSelectionColors getTextSelectionColors() {
        return this.textSelectionColors;
    }

    /* renamed from: getFocusedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2396getFocusedIndicatorColor0d7_KjU() {
        return this.focusedIndicatorColor;
    }

    /* renamed from: getUnfocusedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2406getUnfocusedIndicatorColor0d7_KjU() {
        return this.unfocusedIndicatorColor;
    }

    /* renamed from: getDisabledIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2375getDisabledIndicatorColor0d7_KjU() {
        return this.disabledIndicatorColor;
    }

    /* renamed from: getErrorIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2386getErrorIndicatorColor0d7_KjU() {
        return this.errorIndicatorColor;
    }

    /* renamed from: getFocusedLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2398getFocusedLeadingIconColor0d7_KjU() {
        return this.focusedLeadingIconColor;
    }

    /* renamed from: getUnfocusedLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2408getUnfocusedLeadingIconColor0d7_KjU() {
        return this.unfocusedLeadingIconColor;
    }

    /* renamed from: getDisabledLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2377getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    /* renamed from: getErrorLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2388getErrorLeadingIconColor0d7_KjU() {
        return this.errorLeadingIconColor;
    }

    /* renamed from: getFocusedTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2404getFocusedTrailingIconColor0d7_KjU() {
        return this.focusedTrailingIconColor;
    }

    /* renamed from: getUnfocusedTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2414getUnfocusedTrailingIconColor0d7_KjU() {
        return this.unfocusedTrailingIconColor;
    }

    /* renamed from: getDisabledTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2383getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    /* renamed from: getErrorTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2394getErrorTrailingIconColor0d7_KjU() {
        return this.errorTrailingIconColor;
    }

    /* renamed from: getFocusedLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2397getFocusedLabelColor0d7_KjU() {
        return this.focusedLabelColor;
    }

    /* renamed from: getUnfocusedLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2407getUnfocusedLabelColor0d7_KjU() {
        return this.unfocusedLabelColor;
    }

    /* renamed from: getDisabledLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2376getDisabledLabelColor0d7_KjU() {
        return this.disabledLabelColor;
    }

    /* renamed from: getErrorLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2387getErrorLabelColor0d7_KjU() {
        return this.errorLabelColor;
    }

    /* renamed from: getFocusedPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2399getFocusedPlaceholderColor0d7_KjU() {
        return this.focusedPlaceholderColor;
    }

    /* renamed from: getUnfocusedPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2409getUnfocusedPlaceholderColor0d7_KjU() {
        return this.unfocusedPlaceholderColor;
    }

    /* renamed from: getDisabledPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2378getDisabledPlaceholderColor0d7_KjU() {
        return this.disabledPlaceholderColor;
    }

    /* renamed from: getErrorPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2389getErrorPlaceholderColor0d7_KjU() {
        return this.errorPlaceholderColor;
    }

    /* renamed from: getFocusedSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2402getFocusedSupportingTextColor0d7_KjU() {
        return this.focusedSupportingTextColor;
    }

    /* renamed from: getUnfocusedSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2412getUnfocusedSupportingTextColor0d7_KjU() {
        return this.unfocusedSupportingTextColor;
    }

    /* renamed from: getDisabledSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2381getDisabledSupportingTextColor0d7_KjU() {
        return this.disabledSupportingTextColor;
    }

    /* renamed from: getErrorSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2392getErrorSupportingTextColor0d7_KjU() {
        return this.errorSupportingTextColor;
    }

    /* renamed from: getFocusedPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2400getFocusedPrefixColor0d7_KjU() {
        return this.focusedPrefixColor;
    }

    /* renamed from: getUnfocusedPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2410getUnfocusedPrefixColor0d7_KjU() {
        return this.unfocusedPrefixColor;
    }

    /* renamed from: getDisabledPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2379getDisabledPrefixColor0d7_KjU() {
        return this.disabledPrefixColor;
    }

    /* renamed from: getErrorPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2390getErrorPrefixColor0d7_KjU() {
        return this.errorPrefixColor;
    }

    /* renamed from: getFocusedSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2401getFocusedSuffixColor0d7_KjU() {
        return this.focusedSuffixColor;
    }

    /* renamed from: getUnfocusedSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2411getUnfocusedSuffixColor0d7_KjU() {
        return this.unfocusedSuffixColor;
    }

    /* renamed from: getDisabledSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2380getDisabledSuffixColor0d7_KjU() {
        return this.disabledSuffixColor;
    }

    /* renamed from: getErrorSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2391getErrorSuffixColor0d7_KjU() {
        return this.errorSuffixColor;
    }

    /* renamed from: copy-ejIjP34$default  reason: not valid java name */
    public static /* synthetic */ TextFieldColors m2371copyejIjP34$default(TextFieldColors textFieldColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors2, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, int i, int i2, Object obj) {
        long j43;
        TextFieldColors textFieldColors2 = textFieldColors;
        int i3 = i;
        int i4 = i2;
        long j44 = (i3 & 1) != 0 ? textFieldColors2.focusedTextColor : j;
        long j45 = (i3 & 2) != 0 ? textFieldColors2.unfocusedTextColor : j2;
        long j46 = (i3 & 4) != 0 ? textFieldColors2.disabledTextColor : j3;
        long j47 = (i3 & 8) != 0 ? textFieldColors2.errorTextColor : j4;
        long j48 = (i3 & 16) != 0 ? textFieldColors2.focusedContainerColor : j5;
        long j49 = (i3 & 32) != 0 ? textFieldColors2.unfocusedContainerColor : j6;
        long j50 = (i3 & 64) != 0 ? textFieldColors2.disabledContainerColor : j7;
        long j51 = (i3 & 128) != 0 ? textFieldColors2.errorContainerColor : j8;
        long j52 = (i3 & 256) != 0 ? textFieldColors2.cursorColor : j9;
        long j53 = (i3 & 512) != 0 ? textFieldColors2.errorCursorColor : j10;
        TextSelectionColors textSelectionColors3 = (i3 & 1024) != 0 ? textFieldColors2.textSelectionColors : textSelectionColors2;
        long j54 = j53;
        long j55 = (i3 & 2048) != 0 ? textFieldColors2.focusedIndicatorColor : j11;
        long j56 = (i3 & 4096) != 0 ? textFieldColors2.unfocusedIndicatorColor : j12;
        long j57 = (i3 & 8192) != 0 ? textFieldColors2.disabledIndicatorColor : j13;
        long j58 = (i3 & 16384) != 0 ? textFieldColors2.errorIndicatorColor : j14;
        long j59 = (32768 & i3) != 0 ? textFieldColors2.focusedLeadingIconColor : j15;
        long j60 = (65536 & i3) != 0 ? textFieldColors2.unfocusedLeadingIconColor : j16;
        long j61 = (131072 & i3) != 0 ? textFieldColors2.disabledLeadingIconColor : j17;
        long j62 = (262144 & i3) != 0 ? textFieldColors2.errorLeadingIconColor : j18;
        long j63 = (524288 & i3) != 0 ? textFieldColors2.focusedTrailingIconColor : j19;
        long j64 = (1048576 & i3) != 0 ? textFieldColors2.unfocusedTrailingIconColor : j20;
        long j65 = (2097152 & i3) != 0 ? textFieldColors2.disabledTrailingIconColor : j21;
        long j66 = (4194304 & i3) != 0 ? textFieldColors2.errorTrailingIconColor : j22;
        long j67 = (8388608 & i3) != 0 ? textFieldColors2.focusedLabelColor : j23;
        long j68 = (16777216 & i3) != 0 ? textFieldColors2.unfocusedLabelColor : j24;
        long j69 = (33554432 & i3) != 0 ? textFieldColors2.disabledLabelColor : j25;
        long j70 = (67108864 & i3) != 0 ? textFieldColors2.errorLabelColor : j26;
        long j71 = (134217728 & i3) != 0 ? textFieldColors2.focusedPlaceholderColor : j27;
        long j72 = (268435456 & i3) != 0 ? textFieldColors2.unfocusedPlaceholderColor : j28;
        long j73 = (536870912 & i3) != 0 ? textFieldColors2.disabledPlaceholderColor : j29;
        long j74 = (1073741824 & i3) != 0 ? textFieldColors2.errorPlaceholderColor : j30;
        long j75 = (i3 & Integer.MIN_VALUE) != 0 ? textFieldColors2.focusedSupportingTextColor : j31;
        long j76 = (i4 & 1) != 0 ? textFieldColors2.unfocusedSupportingTextColor : j32;
        long j77 = (i4 & 2) != 0 ? textFieldColors2.disabledSupportingTextColor : j33;
        long j78 = (i4 & 4) != 0 ? textFieldColors2.errorSupportingTextColor : j34;
        long j79 = (i4 & 8) != 0 ? textFieldColors2.focusedPrefixColor : j35;
        long j80 = (i4 & 16) != 0 ? textFieldColors2.unfocusedPrefixColor : j36;
        long j81 = (i4 & 32) != 0 ? textFieldColors2.disabledPrefixColor : j37;
        long j82 = (i4 & 64) != 0 ? textFieldColors2.errorPrefixColor : j38;
        long j83 = (i4 & 128) != 0 ? textFieldColors2.focusedSuffixColor : j39;
        long j84 = (i4 & 256) != 0 ? textFieldColors2.unfocusedSuffixColor : j40;
        long j85 = (i4 & 512) != 0 ? textFieldColors2.disabledSuffixColor : j41;
        if ((i4 & 1024) != 0) {
            j43 = textFieldColors2.errorSuffixColor;
        } else {
            j43 = j42;
        }
        return textFieldColors.m2372copyejIjP34(j44, j45, j46, j47, j48, j49, j50, j51, j52, j54, textSelectionColors3, j55, j56, j57, j58, j59, j60, j61, j62, j63, j64, j65, j66, j67, j68, j69, j70, j71, j72, j73, j74, j75, j76, j77, j78, j79, j80, j81, j82, j83, j84, j85, j43);
    }

    public final TextSelectionColors takeOrElse$material3_release(TextSelectionColors textSelectionColors2, Function0<TextSelectionColors> function0) {
        return textSelectionColors2 == null ? function0.invoke() : textSelectionColors2;
    }

    public final State<Color> leadingIconColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(925127045);
        ComposerKt.sourceInformation(composer, "C(leadingIconColor)P(!1,2)2028@113395L25,2030@113437L267:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(925127045, i, -1, "androidx.compose.material3.TextFieldColors.leadingIconColor (TextFieldDefaults.kt:2027)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledLeadingIconColor;
        } else if (z2) {
            j = this.errorLeadingIconColor;
        } else if (leadingIconColor$lambda$42(collectIsFocusedAsState)) {
            j = this.focusedLeadingIconColor;
        } else {
            j = this.unfocusedLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> trailingIconColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-109504137);
        ComposerKt.sourceInformation(composer, "C(trailingIconColor)P(!1,2)2054@114290L25,2056@114332L271:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-109504137, i, -1, "androidx.compose.material3.TextFieldColors.trailingIconColor (TextFieldDefaults.kt:2053)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledTrailingIconColor;
        } else if (z2) {
            j = this.errorTrailingIconColor;
        } else if (trailingIconColor$lambda$43(collectIsFocusedAsState)) {
            j = this.focusedTrailingIconColor;
        } else {
            j = this.unfocusedTrailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> indicatorColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        State<Color> state;
        composer.startReplaceableGroup(-1877482635);
        ComposerKt.sourceInformation(composer, "C(indicatorColor)P(!1,2)2080@115189L25:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877482635, i, -1, "androidx.compose.material3.TextFieldColors.indicatorColor (TextFieldDefaults.kt:2079)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledIndicatorColor;
        } else if (z2) {
            j = this.errorIndicatorColor;
        } else if (indicatorColor$lambda$44(collectIsFocusedAsState)) {
            j = this.focusedIndicatorColor;
        } else {
            j = this.unfocusedIndicatorColor;
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(715804770);
            ComposerKt.sourceInformation(composer, "2089@115480L75");
            state = SingleValueAnimationKt.m105animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer, 48, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(715804875);
            ComposerKt.sourceInformation(composer, "2091@115585L33");
            state = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j2), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }

    public final State<Color> containerColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-1921164569);
        ComposerKt.sourceInformation(composer, "C(containerColor)P(!1,2)2109@116195L25,2117@116459L75:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1921164569, i, -1, "androidx.compose.material3.TextFieldColors.containerColor (TextFieldDefaults.kt:2108)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledContainerColor;
        } else if (z2) {
            j = this.errorContainerColor;
        } else if (containerColor$lambda$45(collectIsFocusedAsState)) {
            j = this.focusedContainerColor;
        } else {
            j = this.unfocusedContainerColor;
        }
        State<Color> r10 = SingleValueAnimationKt.m105animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r10;
    }

    public final State<Color> placeholderColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(653850713);
        ComposerKt.sourceInformation(composer, "C(placeholderColor)P(!1,2)2134@117117L25,2142@117389L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(653850713, i, -1, "androidx.compose.material3.TextFieldColors.placeholderColor (TextFieldDefaults.kt:2133)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledPlaceholderColor;
        } else if (z2) {
            j = this.errorPlaceholderColor;
        } else if (placeholderColor$lambda$46(collectIsFocusedAsState)) {
            j = this.focusedPlaceholderColor;
        } else {
            j = this.unfocusedPlaceholderColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> labelColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(1167161306);
        ComposerKt.sourceInformation(composer, "C(labelColor)P(!1,2)2159@117993L25,2167@118241L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1167161306, i, -1, "androidx.compose.material3.TextFieldColors.labelColor (TextFieldDefaults.kt:2158)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledLabelColor;
        } else if (z2) {
            j = this.errorLabelColor;
        } else if (labelColor$lambda$47(collectIsFocusedAsState)) {
            j = this.focusedLabelColor;
        } else {
            j = this.unfocusedLabelColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> textColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(68412911);
        ComposerKt.sourceInformation(composer, "C(textColor)P(!1,2)2184@118850L25,2192@119094L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(68412911, i, -1, "androidx.compose.material3.TextFieldColors.textColor (TextFieldDefaults.kt:2183)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledTextColor;
        } else if (z2) {
            j = this.errorTextColor;
        } else if (textColor$lambda$48(collectIsFocusedAsState)) {
            j = this.focusedTextColor;
        } else {
            j = this.unfocusedTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> supportingTextColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(1464709698);
        ComposerKt.sourceInformation(composer, "C(supportingTextColor)P(!1,2)2201@119349L25,2203@119391L279:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1464709698, i, -1, "androidx.compose.material3.TextFieldColors.supportingTextColor (TextFieldDefaults.kt:2200)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledSupportingTextColor;
        } else if (z2) {
            j = this.errorSupportingTextColor;
        } else if (supportingTextColor$lambda$49(collectIsFocusedAsState)) {
            j = this.focusedSupportingTextColor;
        } else {
            j = this.unfocusedSupportingTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> prefixColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(129569364);
        ComposerKt.sourceInformation(composer, "C(prefixColor)P(!1,2)2227@120243L25,2235@120495L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(129569364, i, -1, "androidx.compose.material3.TextFieldColors.prefixColor (TextFieldDefaults.kt:2226)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledPrefixColor;
        } else if (z2) {
            j = this.errorPrefixColor;
        } else if (prefixColor$lambda$50(collectIsFocusedAsState)) {
            j = this.focusedPrefixColor;
        } else {
            j = this.unfocusedPrefixColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> suffixColor$material3_release(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(1575329427);
        ComposerKt.sourceInformation(composer, "C(suffixColor)P(!1,2)2252@121101L25,2260@121353L33:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1575329427, i, -1, "androidx.compose.material3.TextFieldColors.suffixColor (TextFieldDefaults.kt:2251)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        if (!z) {
            j = this.disabledSuffixColor;
        } else if (z2) {
            j = this.errorSuffixColor;
        } else if (suffixColor$lambda$51(collectIsFocusedAsState)) {
            j = this.focusedSuffixColor;
        } else {
            j = this.unfocusedSuffixColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> cursorColor$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-1885422187);
        ComposerKt.sourceInformation(composer, "C(cursorColor)2270@121652L68:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1885422187, i, -1, "androidx.compose.material3.TextFieldColors.cursorColor (TextFieldDefaults.kt:2269)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(z ? this.errorCursorColor : this.cursorColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final TextSelectionColors getSelectionColors(Composer composer, int i) {
        composer.startReplaceableGroup(997785083);
        ComposerKt.sourceInformation(composer, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(997785083, i, -1, "androidx.compose.material3.TextFieldColors.<get-selectionColors> (TextFieldDefaults.kt:2277)");
        }
        TextSelectionColors textSelectionColors2 = this.textSelectionColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TextFieldColors)) {
            return false;
        }
        TextFieldColors textFieldColors = (TextFieldColors) obj;
        return Color.m3817equalsimpl0(this.focusedTextColor, textFieldColors.focusedTextColor) && Color.m3817equalsimpl0(this.unfocusedTextColor, textFieldColors.unfocusedTextColor) && Color.m3817equalsimpl0(this.disabledTextColor, textFieldColors.disabledTextColor) && Color.m3817equalsimpl0(this.errorTextColor, textFieldColors.errorTextColor) && Color.m3817equalsimpl0(this.focusedContainerColor, textFieldColors.focusedContainerColor) && Color.m3817equalsimpl0(this.unfocusedContainerColor, textFieldColors.unfocusedContainerColor) && Color.m3817equalsimpl0(this.disabledContainerColor, textFieldColors.disabledContainerColor) && Color.m3817equalsimpl0(this.errorContainerColor, textFieldColors.errorContainerColor) && Color.m3817equalsimpl0(this.cursorColor, textFieldColors.cursorColor) && Color.m3817equalsimpl0(this.errorCursorColor, textFieldColors.errorCursorColor) && Intrinsics.areEqual((Object) this.textSelectionColors, (Object) textFieldColors.textSelectionColors) && Color.m3817equalsimpl0(this.focusedIndicatorColor, textFieldColors.focusedIndicatorColor) && Color.m3817equalsimpl0(this.unfocusedIndicatorColor, textFieldColors.unfocusedIndicatorColor) && Color.m3817equalsimpl0(this.disabledIndicatorColor, textFieldColors.disabledIndicatorColor) && Color.m3817equalsimpl0(this.errorIndicatorColor, textFieldColors.errorIndicatorColor) && Color.m3817equalsimpl0(this.focusedLeadingIconColor, textFieldColors.focusedLeadingIconColor) && Color.m3817equalsimpl0(this.unfocusedLeadingIconColor, textFieldColors.unfocusedLeadingIconColor) && Color.m3817equalsimpl0(this.disabledLeadingIconColor, textFieldColors.disabledLeadingIconColor) && Color.m3817equalsimpl0(this.errorLeadingIconColor, textFieldColors.errorLeadingIconColor) && Color.m3817equalsimpl0(this.focusedTrailingIconColor, textFieldColors.focusedTrailingIconColor) && Color.m3817equalsimpl0(this.unfocusedTrailingIconColor, textFieldColors.unfocusedTrailingIconColor) && Color.m3817equalsimpl0(this.disabledTrailingIconColor, textFieldColors.disabledTrailingIconColor) && Color.m3817equalsimpl0(this.errorTrailingIconColor, textFieldColors.errorTrailingIconColor) && Color.m3817equalsimpl0(this.focusedLabelColor, textFieldColors.focusedLabelColor) && Color.m3817equalsimpl0(this.unfocusedLabelColor, textFieldColors.unfocusedLabelColor) && Color.m3817equalsimpl0(this.disabledLabelColor, textFieldColors.disabledLabelColor) && Color.m3817equalsimpl0(this.errorLabelColor, textFieldColors.errorLabelColor) && Color.m3817equalsimpl0(this.focusedPlaceholderColor, textFieldColors.focusedPlaceholderColor) && Color.m3817equalsimpl0(this.unfocusedPlaceholderColor, textFieldColors.unfocusedPlaceholderColor) && Color.m3817equalsimpl0(this.disabledPlaceholderColor, textFieldColors.disabledPlaceholderColor) && Color.m3817equalsimpl0(this.errorPlaceholderColor, textFieldColors.errorPlaceholderColor) && Color.m3817equalsimpl0(this.focusedSupportingTextColor, textFieldColors.focusedSupportingTextColor) && Color.m3817equalsimpl0(this.unfocusedSupportingTextColor, textFieldColors.unfocusedSupportingTextColor) && Color.m3817equalsimpl0(this.disabledSupportingTextColor, textFieldColors.disabledSupportingTextColor) && Color.m3817equalsimpl0(this.errorSupportingTextColor, textFieldColors.errorSupportingTextColor) && Color.m3817equalsimpl0(this.focusedPrefixColor, textFieldColors.focusedPrefixColor) && Color.m3817equalsimpl0(this.unfocusedPrefixColor, textFieldColors.unfocusedPrefixColor) && Color.m3817equalsimpl0(this.disabledPrefixColor, textFieldColors.disabledPrefixColor) && Color.m3817equalsimpl0(this.errorPrefixColor, textFieldColors.errorPrefixColor) && Color.m3817equalsimpl0(this.focusedSuffixColor, textFieldColors.focusedSuffixColor) && Color.m3817equalsimpl0(this.unfocusedSuffixColor, textFieldColors.unfocusedSuffixColor) && Color.m3817equalsimpl0(this.disabledSuffixColor, textFieldColors.disabledSuffixColor) && Color.m3817equalsimpl0(this.errorSuffixColor, textFieldColors.errorSuffixColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Color.m3823hashCodeimpl(this.focusedTextColor) * 31) + Color.m3823hashCodeimpl(this.unfocusedTextColor)) * 31) + Color.m3823hashCodeimpl(this.disabledTextColor)) * 31) + Color.m3823hashCodeimpl(this.errorTextColor)) * 31) + Color.m3823hashCodeimpl(this.focusedContainerColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedContainerColor)) * 31) + Color.m3823hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m3823hashCodeimpl(this.errorContainerColor)) * 31) + Color.m3823hashCodeimpl(this.cursorColor)) * 31) + Color.m3823hashCodeimpl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.m3823hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m3823hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m3823hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m3823hashCodeimpl(this.focusedLeadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedLeadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.focusedTrailingIconColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedTrailingIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m3823hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m3823hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m3823hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m3823hashCodeimpl(this.errorLabelColor)) * 31) + Color.m3823hashCodeimpl(this.focusedPlaceholderColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedPlaceholderColor)) * 31) + Color.m3823hashCodeimpl(this.disabledPlaceholderColor)) * 31) + Color.m3823hashCodeimpl(this.errorPlaceholderColor)) * 31) + Color.m3823hashCodeimpl(this.focusedSupportingTextColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedSupportingTextColor)) * 31) + Color.m3823hashCodeimpl(this.disabledSupportingTextColor)) * 31) + Color.m3823hashCodeimpl(this.errorSupportingTextColor)) * 31) + Color.m3823hashCodeimpl(this.focusedPrefixColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedPrefixColor)) * 31) + Color.m3823hashCodeimpl(this.disabledPrefixColor)) * 31) + Color.m3823hashCodeimpl(this.errorPrefixColor)) * 31) + Color.m3823hashCodeimpl(this.focusedSuffixColor)) * 31) + Color.m3823hashCodeimpl(this.unfocusedSuffixColor)) * 31) + Color.m3823hashCodeimpl(this.disabledSuffixColor)) * 31) + Color.m3823hashCodeimpl(this.errorSuffixColor);
    }

    /* renamed from: copy-ejIjP34  reason: not valid java name */
    public final TextFieldColors m2372copyejIjP34(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors2, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42) {
        return new TextFieldColors(j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : this.focusedTextColor, j2 != Color.Companion.m3852getUnspecified0d7_KjU() ? j2 : this.unfocusedTextColor, j3 != Color.Companion.m3852getUnspecified0d7_KjU() ? j3 : this.disabledTextColor, j4 != Color.Companion.m3852getUnspecified0d7_KjU() ? j4 : this.errorTextColor, j5 != Color.Companion.m3852getUnspecified0d7_KjU() ? j5 : this.focusedContainerColor, j6 != Color.Companion.m3852getUnspecified0d7_KjU() ? j6 : this.unfocusedContainerColor, j7 != Color.Companion.m3852getUnspecified0d7_KjU() ? j7 : this.disabledContainerColor, j8 != Color.Companion.m3852getUnspecified0d7_KjU() ? j8 : this.errorContainerColor, j9 != Color.Companion.m3852getUnspecified0d7_KjU() ? j9 : this.cursorColor, j10 != Color.Companion.m3852getUnspecified0d7_KjU() ? j10 : this.errorCursorColor, takeOrElse$material3_release(textSelectionColors2, new TextFieldColors$copy$11(this)), j11 != Color.Companion.m3852getUnspecified0d7_KjU() ? j11 : this.focusedIndicatorColor, j12 != Color.Companion.m3852getUnspecified0d7_KjU() ? j12 : this.unfocusedIndicatorColor, j13 != Color.Companion.m3852getUnspecified0d7_KjU() ? j13 : this.disabledIndicatorColor, j14 != Color.Companion.m3852getUnspecified0d7_KjU() ? j14 : this.errorIndicatorColor, j15 != Color.Companion.m3852getUnspecified0d7_KjU() ? j15 : this.focusedLeadingIconColor, j16 != Color.Companion.m3852getUnspecified0d7_KjU() ? j16 : this.unfocusedLeadingIconColor, j17 != Color.Companion.m3852getUnspecified0d7_KjU() ? j17 : this.disabledLeadingIconColor, j18 != Color.Companion.m3852getUnspecified0d7_KjU() ? j18 : this.errorLeadingIconColor, j19 != Color.Companion.m3852getUnspecified0d7_KjU() ? j19 : this.focusedTrailingIconColor, j20 != Color.Companion.m3852getUnspecified0d7_KjU() ? j20 : this.unfocusedTrailingIconColor, j21 != Color.Companion.m3852getUnspecified0d7_KjU() ? j21 : this.disabledTrailingIconColor, j22 != Color.Companion.m3852getUnspecified0d7_KjU() ? j22 : this.errorTrailingIconColor, j23 != Color.Companion.m3852getUnspecified0d7_KjU() ? j23 : this.focusedLabelColor, j24 != Color.Companion.m3852getUnspecified0d7_KjU() ? j24 : this.unfocusedLabelColor, j25 != Color.Companion.m3852getUnspecified0d7_KjU() ? j25 : this.disabledLabelColor, j26 != Color.Companion.m3852getUnspecified0d7_KjU() ? j26 : this.errorLabelColor, j27 != Color.Companion.m3852getUnspecified0d7_KjU() ? j27 : this.focusedPlaceholderColor, j28 != Color.Companion.m3852getUnspecified0d7_KjU() ? j28 : this.unfocusedPlaceholderColor, j29 != Color.Companion.m3852getUnspecified0d7_KjU() ? j29 : this.disabledPlaceholderColor, j30 != Color.Companion.m3852getUnspecified0d7_KjU() ? j30 : this.errorPlaceholderColor, j31 != Color.Companion.m3852getUnspecified0d7_KjU() ? j31 : this.focusedSupportingTextColor, j32 != Color.Companion.m3852getUnspecified0d7_KjU() ? j32 : this.unfocusedSupportingTextColor, j33 != Color.Companion.m3852getUnspecified0d7_KjU() ? j33 : this.disabledSupportingTextColor, j34 != Color.Companion.m3852getUnspecified0d7_KjU() ? j34 : this.errorSupportingTextColor, j35 != Color.Companion.m3852getUnspecified0d7_KjU() ? j35 : this.focusedPrefixColor, j36 != Color.Companion.m3852getUnspecified0d7_KjU() ? j36 : this.unfocusedPrefixColor, j37 != Color.Companion.m3852getUnspecified0d7_KjU() ? j37 : this.disabledPrefixColor, j38 != Color.Companion.m3852getUnspecified0d7_KjU() ? j38 : this.errorPrefixColor, j39 != Color.Companion.m3852getUnspecified0d7_KjU() ? j39 : this.focusedSuffixColor, j40 != Color.Companion.m3852getUnspecified0d7_KjU() ? j40 : this.unfocusedSuffixColor, j41 != Color.Companion.m3852getUnspecified0d7_KjU() ? j41 : this.disabledSuffixColor, j42 != Color.Companion.m3852getUnspecified0d7_KjU() ? j42 : this.errorSuffixColor, (DefaultConstructorMarker) null);
    }

    private static final boolean leadingIconColor$lambda$42(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean trailingIconColor$lambda$43(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean indicatorColor$lambda$44(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean containerColor$lambda$45(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean placeholderColor$lambda$46(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean labelColor$lambda$47(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean textColor$lambda$48(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean supportingTextColor$lambda$49(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean prefixColor$lambda$50(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean suffixColor$lambda$51(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
