package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
final class SelectionContainerKt$SelectionContainer$3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $children;
    final /* synthetic */ SelectionManager $manager;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$3$1(Modifier modifier, SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$modifier = modifier;
        this.$manager = selectionManager;
        this.$children = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C101@3688L1810:SelectionContainer.kt#eksfi3");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(935424596, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:101)");
            }
            Modifier then = this.$modifier.then(this.$manager.getModifier());
            final Function2<Composer, Integer, Unit> function2 = this.$children;
            final SelectionManager selectionManager = this.$manager;
            SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.composableLambda(composer, 1375295262, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Selection selection;
                    ResolvedTextDirection resolvedTextDirection;
                    Function0 function0;
                    ComposerKt.sourceInformation(composer, "C102@3763L10,*109@4103L129,113@4299L361,127@4923L495:SelectionContainer.kt#eksfi3");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1375295262, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:102)");
                        }
                        function2.invoke(composer, 0);
                        if (selectionManager.isInTouchMode() && selectionManager.getHasFocus() && !selectionManager.isTriviallyCollapsedSelection$foundation_release() && (selection = selectionManager.getSelection()) != null) {
                            SelectionManager selectionManager = selectionManager;
                            List listOf = CollectionsKt.listOf(true, false);
                            int size = listOf.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                Boolean bool = (Boolean) listOf.get(i2);
                                boolean booleanValue = bool.booleanValue();
                                composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                                boolean changed = composer.changed((Object) bool);
                                Object rememberedValue = composer.rememberedValue();
                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = selectionManager.handleDragObserver(booleanValue);
                                    composer.updateRememberedValue(rememberedValue);
                                }
                                composer.endReplaceableGroup();
                                TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                                composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                                boolean changed2 = composer.changed((Object) bool);
                                Object rememberedValue2 = composer.rememberedValue();
                                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                    if (booleanValue) {
                                        function0 = new SelectionContainerKt$SelectionContainer$3$1$1$1$1$positionProvider$1$1(selectionManager);
                                    } else {
                                        function0 = new SelectionContainerKt$SelectionContainer$3$1$1$1$1$positionProvider$1$2(selectionManager);
                                    }
                                    rememberedValue2 = function0;
                                    composer.updateRememberedValue(rememberedValue2);
                                }
                                composer.endReplaceableGroup();
                                Function0 function02 = (Function0) rememberedValue2;
                                if (booleanValue) {
                                    resolvedTextDirection = selection.getStart().getDirection();
                                } else {
                                    resolvedTextDirection = selection.getEnd().getDirection();
                                }
                                AndroidSelectionHandles_androidKt.SelectionHandle(new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(function02), booleanValue, resolvedTextDirection, selection.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1(textDragObserver, (Continuation<? super SelectionContainerKt$SelectionContainer$3$1$1$1$1$1>) null)), composer, 0);
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
