package androidx.compose.ui.text;

import java.text.BreakIterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"findFollowingBreak", "", "", "index", "findPrecedingBreak", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: JvmCharHelpers.android.kt */
public final class JvmCharHelpers_androidKt {
    public static final int findPrecedingBreak(String str, int i) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i);
    }

    public static final int findFollowingBreak(String str, int i) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.following(i);
    }
}
