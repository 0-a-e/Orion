package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eRB\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00128W@WX\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRB\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00128W@WX\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR$\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR$\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR$\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR$\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR$\u0010+\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR$\u0010.\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusProperties;", "", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "<anonymous parameter 0>", "Landroidx/compose/ui/focus/FocusRequester;", "down", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "enter", "getEnter$annotations", "()V", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "exit", "getExit$annotations", "getExit", "setExit", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
public interface FocusProperties {
    boolean getCanFocus();

    FocusRequester getDown();

    FocusRequester getEnd();

    Function1<FocusDirection, FocusRequester> getEnter();

    Function1<FocusDirection, FocusRequester> getExit();

    FocusRequester getLeft();

    FocusRequester getNext();

    FocusRequester getPrevious();

    FocusRequester getRight();

    FocusRequester getStart();

    FocusRequester getUp();

    void setCanFocus(boolean z);

    void setDown(FocusRequester focusRequester);

    void setEnd(FocusRequester focusRequester);

    void setEnter(Function1<? super FocusDirection, FocusRequester> function1);

    void setExit(Function1<? super FocusDirection, FocusRequester> function1);

    void setLeft(FocusRequester focusRequester);

    void setNext(FocusRequester focusRequester);

    void setPrevious(FocusRequester focusRequester);

    void setRight(FocusRequester focusRequester);

    void setStart(FocusRequester focusRequester);

    void setUp(FocusRequester focusRequester);

    /* renamed from: androidx.compose.ui.focus.FocusProperties$-CC  reason: invalid class name */
    /* compiled from: FocusProperties.kt */
    public final /* synthetic */ class CC {
        public static void $default$setDown(FocusProperties _this, FocusRequester focusRequester) {
        }

        public static void $default$setEnd(FocusProperties _this, FocusRequester focusRequester) {
        }

        public static void $default$setEnter(FocusProperties _this, Function1 function1) {
        }

        public static void $default$setExit(FocusProperties _this, Function1 function1) {
        }

        public static void $default$setLeft(FocusProperties _this, FocusRequester focusRequester) {
        }

        public static void $default$setNext(FocusProperties _this, FocusRequester focusRequester) {
        }

        public static void $default$setPrevious(FocusProperties _this, FocusRequester focusRequester) {
        }

        public static void $default$setRight(FocusProperties _this, FocusRequester focusRequester) {
        }

        public static void $default$setStart(FocusProperties _this, FocusRequester focusRequester) {
        }

        public static void $default$setUp(FocusProperties _this, FocusRequester focusRequester) {
        }

        public static /* synthetic */ void getEnter$annotations() {
        }

        public static /* synthetic */ void getExit$annotations() {
        }

        public static FocusRequester $default$getNext(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester $default$getPrevious(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester $default$getUp(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester $default$getDown(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester $default$getLeft(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester $default$getRight(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester $default$getStart(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester $default$getEnd(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static Function1 $default$getEnter(FocusProperties _this) {
            return FocusProperties$enter$1.INSTANCE;
        }

        public static Function1 $default$getExit(FocusProperties _this) {
            return FocusProperties$exit$1.INSTANCE;
        }
    }
}
