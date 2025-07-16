package androidx.compose.foundation.text;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "getDefaultCursorThickness", "()F", "F", "cursorAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "cursor", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCursor.kt */
public final class TextFieldCursorKt {
    private static final float DefaultCursorThickness = Dp.m6614constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> cursorAnimationSpec = AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(TextFieldCursorKt$cursorAnimationSpec$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null);

    public static final Modifier cursor(Modifier modifier, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Brush brush, boolean z) {
        return z ? ComposedModifierKt.composed$default(modifier, (Function1) null, new TextFieldCursorKt$cursor$1(brush, textFieldState, textFieldValue, offsetMapping), 1, (Object) null) : modifier;
    }

    public static final float getDefaultCursorThickness() {
        return DefaultCursorThickness;
    }
}
