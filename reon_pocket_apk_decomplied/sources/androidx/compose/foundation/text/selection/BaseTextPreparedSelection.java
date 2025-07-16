package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b)\b \u0018\u0000 a*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001aB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J$\u0010(\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J$\u0010.\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J\u000b\u0010/\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u00101\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\r\u00103\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0006\u00104\u001a\u00020&J\r\u00105\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0006\u00106\u001a\u00020&J\r\u00107\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\b\u00108\u001a\u000209H\u0002J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010;\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010<\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010=\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010>\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010?\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\r\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010A\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010B\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010C\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010E\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010G\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010J\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010K\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010L\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u00100J\u0010\u0010N\u001a\u00020+2\u0006\u0010'\u001a\u00020&H\u0004J\u0018\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020&2\u0006\u0010Q\u001a\u00020&H\u0004J\b\u0010R\u001a\u00020&H\u0002J\b\u0010S\u001a\u00020&H\u0002J\b\u0010T\u001a\u00020&H\u0002J;\u0010U\u001a\u00028\u0000\"\u0004\b\u0001\u0010V*\u0002HV2\b\b\u0002\u0010W\u001a\u0002092\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\b¢\u0006\u0002\u0010YJ\u0016\u0010Z\u001a\u00020&*\u00020\b2\b\b\u0002\u0010[\u001a\u00020&H\u0002J\u0016\u0010\\\u001a\u00020&*\u00020\b2\b\b\u0002\u0010[\u001a\u00020&H\u0002J\u0017\u0010]\u001a\u00020&*\u00020\b2\b\b\u0002\u0010[\u001a\u00020&H\u0010J\u0017\u0010^\u001a\u00020&*\u00020\b2\b\b\u0002\u0010[\u001a\u00020&H\u0010J\u0014\u0010_\u001a\u00020&*\u00020\b2\u0006\u0010`\u001a\u00020&H\u0002R\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\u00020\u0006X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8@X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006b"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getOriginalSelection-d9O1mEE", "()J", "J", "getOriginalText", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "text", "", "getText$foundation_release", "()Ljava/lang/String;", "charOffset", "", "offset", "collapseLeftOr", "or", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "deselect", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffset", "()Ljava/lang/Integer;", "getLineStartByOffset", "getNextCharacterIndex", "getNextWordOffset", "getPrecedingCharacterIndex", "getPreviousWordOffset", "isLtr", "", "moveCursorDownByLine", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "selectAll", "selectMovement", "setCursor", "setSelection", "start", "end", "transformedEndOffset", "transformedMaxOffset", "transformedMinOffset", "apply", "U", "resetCachedX", "block", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffset", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NoCharacterFound = -1;
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString2, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping2, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, j, textLayoutResult, offsetMapping2, textPreparedSelectionState);
    }

    private BaseTextPreparedSelection(AnnotatedString annotatedString2, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping2, TextPreparedSelectionState textPreparedSelectionState) {
        this.originalText = annotatedString2;
        this.originalSelection = j;
        this.layoutResult = textLayoutResult;
        this.offsetMapping = offsetMapping2;
        this.state = textPreparedSelectionState;
        this.selection = j;
        this.annotatedString = annotatedString2;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    /* renamed from: getOriginalSelection-d9O1mEE  reason: not valid java name */
    public final long m1207getOriginalSelectiond9O1mEE() {
        return this.originalSelection;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1208getSelectiond9O1mEE() {
        return this.selection;
    }

    /* renamed from: setSelection-5zc-tL8  reason: not valid java name */
    public final void m1209setSelection5zctL8(long j) {
        this.selection = j;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final void setAnnotatedString(AnnotatedString annotatedString2) {
        this.annotatedString = annotatedString2;
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection baseTextPreparedSelection, Object obj, boolean z, Function1 function1, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            if (z) {
                baseTextPreparedSelection.getState().resetCachedX();
            }
            if (baseTextPreparedSelection.getText$foundation_release().length() > 0) {
                function1.invoke(obj);
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
            return (BaseTextPreparedSelection) obj;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
    }

    /* access modifiers changed from: protected */
    public final <U> T apply(U u, boolean z, Function1<? super U, Unit> function1) {
        if (z) {
            getState().resetCachedX();
        }
        if (getText$foundation_release().length() > 0) {
            function1.invoke(u);
        }
        Intrinsics.checkNotNull(u, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection) u;
    }

    /* access modifiers changed from: protected */
    public final void setCursor(int i) {
        setSelection(i, i);
    }

    /* access modifiers changed from: protected */
    public final void setSelection(int i, int i2) {
        this.selection = TextRangeKt.TextRange(i, i2);
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.m6037getEndimpl(this.selection));
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.m6037getEndimpl(this.selection));
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getPrevWordOffset$default(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    private final boolean isLtr() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        return (textLayoutResult != null ? textLayoutResult.getParagraphDirection(transformedEndOffset()) : null) != ResolvedTextDirection.Rtl;
    }

    static /* synthetic */ int getNextWordOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i < this.originalText.length()) {
            long r0 = textLayoutResult.m6016getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6037getEndimpl(r0) > i) {
                return this.offsetMapping.transformedToOriginal(TextRange.m6037getEndimpl(r0));
            }
            i++;
        }
        return this.originalText.length();
    }

    static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
    }

    private final int getPrevWordOffset(TextLayoutResult textLayoutResult, int i) {
        while (i > 0) {
            long r0 = textLayoutResult.m6016getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6042getStartimpl(r0) < i) {
                return this.offsetMapping.transformedToOriginal(TextRange.m6042getStartimpl(r0));
            }
            i--;
        }
        return 0;
    }

    static /* synthetic */ int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedMinOffset();
            }
            return baseTextPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i)));
    }

    static /* synthetic */ int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedMaxOffset();
            }
            return baseTextPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i), true));
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int transformedEndOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf(textLayoutResult.getCursorRect(transformedEndOffset).getLeft()));
        }
        int lineForOffset = textLayoutResult.getLineForOffset(transformedEndOffset) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return getText$foundation_release().length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - ((float) 1);
        Float cachedX = this.state.getCachedX();
        Intrinsics.checkNotNull(cachedX);
        Number number = cachedX;
        float floatValue = number.floatValue();
        if ((isLtr() && floatValue >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && floatValue <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return this.offsetMapping.transformedToOriginal(textLayoutResult.m6014getOffsetForPositionk4lQ0M(OffsetKt.Offset(number.floatValue(), lineBottom)));
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6037getEndimpl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6040getMinimpl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6039getMaximpl(this.selection));
    }

    private final int charOffset(int i) {
        return RangesKt.coerceAtMost(i, getText$foundation_release().length() - 1);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection$Companion;", "", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextPreparedSelection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final T selectAll() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            setSelection(0, getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T deselect() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            setCursor(TextRange.m6037getEndimpl(this.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorLeft() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (isLtr()) {
                moveCursorPrev();
            } else {
                moveCursorNext();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorRight() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (isLtr()) {
                moveCursorNext();
            } else {
                moveCursorPrev();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T collapseLeftOr(Function1<? super T, Unit> function1) {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (TextRange.m6036getCollapsedimpl(this.selection)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseLeftOr$lambda$4");
                function1.invoke(this);
            } else if (isLtr()) {
                setCursor(TextRange.m6040getMinimpl(this.selection));
            } else {
                setCursor(TextRange.m6039getMaximpl(this.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T collapseRightOr(Function1<? super T, Unit> function1) {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (TextRange.m6036getCollapsedimpl(this.selection)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseRightOr$lambda$5");
                function1.invoke(this);
            } else if (isLtr()) {
                setCursor(TextRange.m6039getMaximpl(this.selection));
            } else {
                setCursor(TextRange.m6040getMinimpl(this.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    private final T moveCursorPrev() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            int precedingCharacterIndex = getPrecedingCharacterIndex();
            if (precedingCharacterIndex != -1) {
                setCursor(precedingCharacterIndex);
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    private final T moveCursorNext() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            int nextCharacterIndex = getNextCharacterIndex();
            if (nextCharacterIndex != -1) {
                setCursor(nextCharacterIndex);
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorToHome() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            setCursor(0);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorToEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            setCursor(getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorLeftByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (isLtr()) {
                moveCursorPrevByWord();
            } else {
                moveCursorNextByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorRightByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (isLtr()) {
                moveCursorNextByWord();
            } else {
                moveCursorPrevByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    private final T moveCursorNextByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            Integer nextWordOffset = getNextWordOffset();
            if (nextWordOffset != null) {
                setCursor(nextWordOffset.intValue());
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    private final T moveCursorPrevByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            Integer previousWordOffset = getPreviousWordOffset();
            if (previousWordOffset != null) {
                setCursor(previousWordOffset.intValue());
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorPrevByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            int findParagraphStart = StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m6040getMinimpl(this.selection));
            if (findParagraphStart == TextRange.m6040getMinimpl(this.selection) && findParagraphStart != 0) {
                findParagraphStart = StringHelpersKt.findParagraphStart(getText$foundation_release(), findParagraphStart - 1);
            }
            setCursor(findParagraphStart);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorNextByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            int findParagraphEnd = StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m6039getMaximpl(this.selection));
            if (findParagraphEnd == TextRange.m6039getMaximpl(this.selection) && findParagraphEnd != getText$foundation_release().length()) {
                findParagraphEnd = StringHelpersKt.findParagraphEnd(getText$foundation_release(), findParagraphEnd + 1);
            }
            setCursor(findParagraphEnd);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorUpByLine() {
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            TextLayoutResult textLayoutResult = this.layoutResult;
            if (textLayoutResult != null) {
                setCursor(jumpByLinesOffset(textLayoutResult, -1));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorDownByLine() {
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            TextLayoutResult textLayoutResult = this.layoutResult;
            if (textLayoutResult != null) {
                setCursor(jumpByLinesOffset(textLayoutResult, 1));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorToLineStart() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            Integer lineStartByOffset = getLineStartByOffset();
            if (lineStartByOffset != null) {
                setCursor(lineStartByOffset.intValue());
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorToLineEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            Integer lineEndByOffset = getLineEndByOffset();
            if (lineEndByOffset != null) {
                setCursor(lineEndByOffset.intValue());
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorToLineLeftSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (isLtr()) {
                moveCursorToLineStart();
            } else {
                moveCursorToLineEnd();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T moveCursorToLineRightSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (isLtr()) {
                moveCursorToLineEnd();
            } else {
                moveCursorToLineStart();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }

    public final T selectMovement() {
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            this.selection = TextRangeKt.TextRange(TextRange.m6042getStartimpl(this.originalSelection), TextRange.m6037getEndimpl(this.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        BaseTextPreparedSelection baseTextPreparedSelection2 = this;
        return this;
    }
}
