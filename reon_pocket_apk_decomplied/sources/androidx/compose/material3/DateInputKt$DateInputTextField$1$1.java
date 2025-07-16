package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "input", "Landroidx/compose/ui/text/input/TextFieldValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputTextField$1$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DateInputFormat $dateInputFormat;
    final /* synthetic */ DateInputValidator $dateInputValidator;
    final /* synthetic */ MutableState<String> $errorText;
    final /* synthetic */ int $inputIdentifier;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
    final /* synthetic */ MutableState<TextFieldValue> $text$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputTextField$1$1(DateInputFormat dateInputFormat, MutableState<String> mutableState, Function1<? super Long, Unit> function1, CalendarModel calendarModel, DateInputValidator dateInputValidator, int i, Locale locale, MutableState<TextFieldValue> mutableState2) {
        super(1);
        this.$dateInputFormat = dateInputFormat;
        this.$errorText = mutableState;
        this.$onDateSelectionChange = function1;
        this.$calendarModel = calendarModel;
        this.$dateInputValidator = dateInputValidator;
        this.$inputIdentifier = i;
        this.$locale = locale;
        this.$text$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        if (textFieldValue.getText().length() <= this.$dateInputFormat.getPatternWithoutDelimiters().length()) {
            CharSequence text = textFieldValue.getText();
            int i = 0;
            while (i < text.length()) {
                if (Character.isDigit(text.charAt(i))) {
                    i++;
                } else {
                    return;
                }
            }
            DateInputKt.DateInputTextField_tQNruF0$lambda$5(this.$text$delegate, textFieldValue);
            String obj = StringsKt.trim((CharSequence) textFieldValue.getText()).toString();
            Long l = null;
            if (obj.length() != 0 && obj.length() >= this.$dateInputFormat.getPatternWithoutDelimiters().length()) {
                CalendarDate parse = this.$calendarModel.parse(obj, this.$dateInputFormat.getPatternWithoutDelimiters());
                this.$errorText.setValue(this.$dateInputValidator.m1735validateXivgLIo(parse, this.$inputIdentifier, this.$locale));
                Function1<Long, Unit> function1 = this.$onDateSelectionChange;
                if (this.$errorText.getValue().length() == 0 && parse != null) {
                    l = Long.valueOf(parse.getUtcTimeMillis());
                }
                function1.invoke(l);
                return;
            }
            this.$errorText.setValue("");
            this.$onDateSelectionChange.invoke(null);
        }
    }
}
