package androidx.compose.foundation.text;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCursor.kt */
final class TextFieldCursorKt$cursor$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCursorKt$cursor$1(Brush brush, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(3);
        this.$cursorBrush = brush;
        this.$state = textFieldState;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Modifier modifier2;
        composer.startReplaceableGroup(1634330012);
        ComposerKt.sourceInformation(composer, "C45@1739L27,48@1941L491:TextFieldCursor.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1634330012, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:45)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Animatable animatable = (Animatable) rememberedValue;
        Brush brush = this.$cursorBrush;
        boolean z = !(brush instanceof SolidColor) || ((SolidColor) brush).m4212getValue0d7_KjU() != Color.Companion.m3852getUnspecified0d7_KjU();
        if (!this.$state.getHasFocus() || !TextRange.m6036getCollapsedimpl(this.$value.m6299getSelectiond9O1mEE()) || !z) {
            modifier2 = Modifier.Companion;
        } else {
            EffectsKt.LaunchedEffect(this.$value.getAnnotatedString(), TextRange.m6030boximpl(this.$value.m6299getSelectiond9O1mEE()), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 512);
            final OffsetMapping offsetMapping = this.$offsetMapping;
            final TextFieldValue textFieldValue = this.$value;
            final TextFieldState textFieldState = this.$state;
            final Brush brush2 = this.$cursorBrush;
            modifier2 = DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ContentDrawScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ContentDrawScope contentDrawScope) {
                    Rect rect;
                    TextLayoutResult value;
                    ContentDrawScope contentDrawScope2 = contentDrawScope;
                    contentDrawScope.drawContent();
                    float coerceIn = RangesKt.coerceIn(animatable.getValue().floatValue(), 0.0f, 1.0f);
                    if (coerceIn != 0.0f) {
                        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m6042getStartimpl(textFieldValue.m6299getSelectiond9O1mEE()));
                        TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                        if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(originalToTransformed)) == null) {
                            rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                        }
                        float r11 = contentDrawScope2.m6550toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                        float f = r11 / ((float) 2);
                        float coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(rect.getLeft() + f, Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()) - f), f);
                        DrawScope.CC.m4461drawLine1RTmtNc$default(contentDrawScope2, brush2, OffsetKt.Offset(coerceAtLeast, rect.getTop()), OffsetKt.Offset(coerceAtLeast, rect.getBottom()), r11, 0, (PathEffect) null, coerceIn, (ColorFilter) null, 0, 432, (Object) null);
                    }
                }
            });
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifier2;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1", f = "TextFieldCursor.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1  reason: invalid class name */
    /* compiled from: TextFieldCursor.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(animatable, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Animatable<Float, AnimationVector1D> animatable = animatable;
                this.label = 1;
                if (BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 
                    }
