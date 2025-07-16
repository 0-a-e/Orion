package androidx.compose.ui.autofill;

import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/autofill/AndroidAutofill;", "Landroidx/compose/ui/autofill/Autofill;", "view", "Landroid/view/View;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "(Landroid/view/View;Landroidx/compose/ui/autofill/AutofillTree;)V", "autofillManager", "Landroid/view/autofill/AutofillManager;", "getAutofillManager", "()Landroid/view/autofill/AutofillManager;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "getView", "()Landroid/view/View;", "cancelAutofillForNode", "", "autofillNode", "Landroidx/compose/ui/autofill/AutofillNode;", "requestAutofillForNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAutofill.android.kt */
public final class AndroidAutofill implements Autofill {
    public static final int $stable = 8;
    private final AutofillManager autofillManager;
    private final AutofillTree autofillTree;
    private final View view;

    public AndroidAutofill(View view2, AutofillTree autofillTree2) {
        this.view = view2;
        this.autofillTree = autofillTree2;
        AutofillManager m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(view2.getContext().getSystemService(ComponentDialog$$ExternalSyntheticApiModelOutline0.m$1()));
        if (m != null) {
            this.autofillManager = m;
            view2.setImportantForAutofill(1);
            return;
        }
        throw new IllegalStateException("Autofill service could not be located.".toString());
    }

    public final AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final View getView() {
        return this.view;
    }

    public final AutofillManager getAutofillManager() {
        return this.autofillManager;
    }

    public void requestAutofillForNode(AutofillNode autofillNode) {
        Rect boundingBox = autofillNode.getBoundingBox();
        if (boundingBox != null) {
            this.autofillManager.notifyViewEntered(this.view, autofillNode.getId(), new android.graphics.Rect(MathKt.roundToInt(boundingBox.getLeft()), MathKt.roundToInt(boundingBox.getTop()), MathKt.roundToInt(boundingBox.getRight()), MathKt.roundToInt(boundingBox.getBottom())));
            return;
        }
        throw new IllegalStateException("requestAutofill called before onChildPositioned()".toString());
    }

    public void cancelAutofillForNode(AutofillNode autofillNode) {
        this.autofillManager.notifyViewExited(this.view, autofillNode.getId());
    }
}
