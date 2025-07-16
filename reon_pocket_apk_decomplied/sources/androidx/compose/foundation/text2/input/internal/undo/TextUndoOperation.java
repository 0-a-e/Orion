package androidx.compose.foundation.text2.input.internal.undo;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;", "", "index", "", "preText", "", "postText", "preSelection", "Landroidx/compose/ui/text/TextRange;", "postSelection", "timeInMillis", "", "canMerge", "", "(ILjava/lang/String;Ljava/lang/String;JJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanMerge", "()Z", "deletionType", "Landroidx/compose/foundation/text2/input/internal/undo/TextDeleteType;", "getDeletionType", "()Landroidx/compose/foundation/text2/input/internal/undo/TextDeleteType;", "getIndex", "()I", "getPostSelection-d9O1mEE", "()J", "J", "getPostText", "()Ljava/lang/String;", "getPreSelection-d9O1mEE", "getPreText", "textEditType", "Landroidx/compose/foundation/text2/input/internal/undo/TextEditType;", "getTextEditType", "()Landroidx/compose/foundation/text2/input/internal/undo/TextEditType;", "getTimeInMillis", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextUndoOperation.kt */
public final class TextUndoOperation {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<TextUndoOperation, Object> Saver = new TextUndoOperation$Companion$Saver$1();
    private final boolean canMerge;
    private final int index;
    private final long postSelection;
    private final String postText;
    private final long preSelection;
    private final String preText;
    private final TextEditType textEditType;
    private final long timeInMillis;

    public /* synthetic */ TextUndoOperation(int i, String str, String str2, long j, long j2, long j3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, j, j2, j3, z);
    }

    private TextUndoOperation(int i, String str, String str2, long j, long j2, long j3, boolean z) {
        TextEditType textEditType2;
        this.index = i;
        this.preText = str;
        this.postText = str2;
        this.preSelection = j;
        this.postSelection = j2;
        this.timeInMillis = j3;
        this.canMerge = z;
        if (str.length() == 0 && str2.length() == 0) {
            throw new IllegalArgumentException("Either pre or post text must not be empty");
        }
        if (str.length() == 0 && str2.length() > 0) {
            textEditType2 = TextEditType.Insert;
        } else if (str.length() <= 0 || str2.length() != 0) {
            textEditType2 = TextEditType.Replace;
        } else {
            textEditType2 = TextEditType.Delete;
        }
        this.textEditType = textEditType2;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getPreText() {
        return this.preText;
    }

    public final String getPostText() {
        return this.postText;
    }

    /* renamed from: getPreSelection-d9O1mEE  reason: not valid java name */
    public final long m1476getPreSelectiond9O1mEE() {
        return this.preSelection;
    }

    /* renamed from: getPostSelection-d9O1mEE  reason: not valid java name */
    public final long m1475getPostSelectiond9O1mEE() {
        return this.postSelection;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextUndoOperation(int r15, java.lang.String r16, java.lang.String r17, long r18, long r20, long r22, boolean r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25 & 32
            if (r0 == 0) goto L_0x000a
            long r0 = androidx.compose.foundation.text.UndoManager_jvmKt.timeNowMillis()
            r10 = r0
            goto L_0x000c
        L_0x000a:
            r10 = r22
        L_0x000c:
            r0 = r25 & 64
            if (r0 == 0) goto L_0x0013
            r0 = 1
            r12 = r0
            goto L_0x0015
        L_0x0013:
            r12 = r24
        L_0x0015:
            r13 = 0
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r8 = r20
            r2.<init>(r3, r4, r5, r6, r8, r10, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.undo.TextUndoOperation.<init>(int, java.lang.String, java.lang.String, long, long, long, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getTimeInMillis() {
        return this.timeInMillis;
    }

    public final boolean getCanMerge() {
        return this.canMerge;
    }

    public final TextEditType getTextEditType() {
        return this.textEditType;
    }

    public final TextDeleteType getDeletionType() {
        if (this.textEditType != TextEditType.Delete) {
            return TextDeleteType.NotByUser;
        }
        if (!TextRange.m6036getCollapsedimpl(this.postSelection)) {
            return TextDeleteType.NotByUser;
        }
        if (TextRange.m6036getCollapsedimpl(this.preSelection)) {
            if (TextRange.m6042getStartimpl(this.preSelection) > TextRange.m6042getStartimpl(this.postSelection)) {
                return TextDeleteType.Start;
            }
            return TextDeleteType.End;
        } else if (TextRange.m6042getStartimpl(this.preSelection) == TextRange.m6042getStartimpl(this.postSelection) && TextRange.m6042getStartimpl(this.preSelection) == this.index) {
            return TextDeleteType.Inner;
        } else {
            return TextDeleteType.NotByUser;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextUndoOperation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TextUndoOperation, Object> getSaver() {
            return TextUndoOperation.Saver;
        }
    }
}
