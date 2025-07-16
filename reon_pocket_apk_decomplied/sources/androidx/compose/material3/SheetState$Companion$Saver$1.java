package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/material3/SheetValue;", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/material3/SheetState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
final class SheetState$Companion$Saver$1 extends Lambda implements Function2<SaverScope, SheetState, SheetValue> {
    public static final SheetState$Companion$Saver$1 INSTANCE = new SheetState$Companion$Saver$1();

    SheetState$Companion$Saver$1() {
        super(2);
    }

    public final SheetValue invoke(SaverScope saverScope, SheetState sheetState) {
        return sheetState.getCurrentValue();
    }
}
