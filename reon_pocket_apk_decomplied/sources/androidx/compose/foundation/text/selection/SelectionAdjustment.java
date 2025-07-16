package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "", "adjust", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionAdjustment.kt */
public interface SelectionAdjustment {
    public static final Companion Companion = Companion.$$INSTANCE;

    Selection adjust(SelectionLayout selectionLayout);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment$Companion;", "", "()V", "Character", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getCharacter", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "CharacterWithWordAccelerate", "getCharacterWithWordAccelerate", "None", "getNone", "Paragraph", "getParagraph", "Word", "getWord", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionAdjustment.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SelectionAdjustment Character = new SelectionAdjustment$Companion$$ExternalSyntheticLambda1();
        private static final SelectionAdjustment CharacterWithWordAccelerate = new SelectionAdjustment$Companion$$ExternalSyntheticLambda4();
        private static final SelectionAdjustment None = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0();
        private static final SelectionAdjustment Paragraph = new SelectionAdjustment$Companion$$ExternalSyntheticLambda3();
        private static final SelectionAdjustment Word = new SelectionAdjustment$Companion$$ExternalSyntheticLambda2();

        private Companion() {
        }

        public final SelectionAdjustment getNone() {
            return None;
        }

        /* access modifiers changed from: private */
        public static final Selection None$lambda$0(SelectionLayout selectionLayout) {
            return new Selection(selectionLayout.getStartInfo().anchorForOffset(selectionLayout.getStartInfo().getRawStartHandleOffset()), selectionLayout.getEndInfo().anchorForOffset(selectionLayout.getEndInfo().getRawEndHandleOffset()), selectionLayout.getCrossStatus() == CrossStatus.CROSSED);
        }

        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        /* access modifiers changed from: private */
        public static final Selection Character$lambda$1(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(None.adjust(selectionLayout), selectionLayout);
        }

        public final SelectionAdjustment getWord() {
            return Word;
        }

        /* access modifiers changed from: private */
        public static final Selection Word$lambda$2(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.adjustToBoundaries(selectionLayout, SelectionAdjustment$Companion$Word$1$1.INSTANCE);
        }

        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        /* access modifiers changed from: private */
        public static final Selection Paragraph$lambda$3(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.adjustToBoundaries(selectionLayout, SelectionAdjustment$Companion$Paragraph$1$1.INSTANCE);
        }

        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return CharacterWithWordAccelerate;
        }

        /* access modifiers changed from: private */
        public static final Selection CharacterWithWordAccelerate$lambda$4(SelectionLayout selectionLayout) {
            Selection.AnchorInfo anchorInfo;
            Selection.AnchorInfo anchorInfo2;
            Selection.AnchorInfo anchorInfo3;
            Selection.AnchorInfo anchorInfo4;
            Selection previousSelection = selectionLayout.getPreviousSelection();
            if (previousSelection == null) {
                return Word.adjust(selectionLayout);
            }
            if (selectionLayout.isStartHandle()) {
                anchorInfo4 = previousSelection.getStart();
                anchorInfo3 = SelectionAdjustmentKt.updateSelectionBoundary(selectionLayout, selectionLayout.getStartInfo(), anchorInfo4);
                anchorInfo = previousSelection.getEnd();
                anchorInfo2 = anchorInfo3;
            } else {
                anchorInfo4 = previousSelection.getEnd();
                anchorInfo3 = SelectionAdjustmentKt.updateSelectionBoundary(selectionLayout, selectionLayout.getEndInfo(), anchorInfo4);
                anchorInfo2 = previousSelection.getStart();
                anchorInfo = anchorInfo3;
            }
            if (Intrinsics.areEqual((Object) anchorInfo3, (Object) anchorInfo4)) {
                return previousSelection;
            }
            return SelectionAdjustmentKt.ensureAtLeastOneChar(new Selection(anchorInfo2, anchorInfo, selectionLayout.getCrossStatus() == CrossStatus.CROSSED || (selectionLayout.getCrossStatus() == CrossStatus.COLLAPSED && anchorInfo2.getOffset() > anchorInfo.getOffset())), selectionLayout);
        }
    }
}
