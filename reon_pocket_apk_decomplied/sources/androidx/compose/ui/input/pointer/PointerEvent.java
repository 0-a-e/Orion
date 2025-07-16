package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u001f\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010\"\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R,\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@@X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Ljava/util/List;)V", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "()I", "I", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent$ui_release", "()Landroid/view/MotionEvent;", "<set-?>", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerEvent.android.kt */
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(List<PointerInputChange> list, InternalPointerEvent internalPointerEvent2) {
        this.changes = list;
        this.internalPointerEvent = internalPointerEvent2;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        int i = 0;
        this.buttons = PointerButtons.m5045constructorimpl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m5180constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : i);
        this.type = m5051calculatePointerEventType7fucELk();
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    public final InternalPointerEvent getInternalPointerEvent$ui_release() {
        return this.internalPointerEvent;
    }

    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent2 = this.internalPointerEvent;
        if (internalPointerEvent2 != null) {
            return internalPointerEvent2.getMotionEvent();
        }
        return null;
    }

    public PointerEvent(List<PointerInputChange> list) {
        this(list, (InternalPointerEvent) null);
    }

    /* renamed from: getButtons-ry648PA  reason: not valid java name */
    public final int m5052getButtonsry648PA() {
        return this.buttons;
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A  reason: not valid java name */
    public final int m5053getKeyboardModifiersk7X9c1A() {
        return this.keyboardModifiers;
    }

    /* renamed from: getType-7fucELk  reason: not valid java name */
    public final int m5054getType7fucELk() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release  reason: not valid java name */
    public final void m5055setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    /* renamed from: calculatePointerEventType-7fucELk  reason: not valid java name */
    private final int m5051calculatePointerEventType7fucELk() {
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release != null) {
            int actionMasked = motionEvent$ui_release.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                return PointerEventType.Companion.m5070getScroll7fucELk();
                            case 9:
                                return PointerEventType.Companion.m5065getEnter7fucELk();
                            case 10:
                                return PointerEventType.Companion.m5066getExit7fucELk();
                            default:
                                return PointerEventType.Companion.m5071getUnknown7fucELk();
                        }
                    }
                    return PointerEventType.Companion.m5067getMove7fucELk();
                }
                return PointerEventType.Companion.m5069getRelease7fucELk();
            }
            return PointerEventType.Companion.m5068getPress7fucELk();
        }
        List<PointerInputChange> list = this.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = list.get(i);
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.m5069getRelease7fucELk();
            }
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.m5068getPress7fucELk();
            }
        }
        return PointerEventType.Companion.m5067getMove7fucELk();
    }

    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    public final PointerEvent copy(List<PointerInputChange> list, MotionEvent motionEvent) {
        boolean z;
        List<PointerInputChange> list2 = list;
        MotionEvent motionEvent2 = motionEvent;
        if (motionEvent2 == null) {
            return new PointerEvent(list2, (InternalPointerEvent) null);
        }
        if (Intrinsics.areEqual((Object) motionEvent2, (Object) getMotionEvent$ui_release())) {
            return new PointerEvent(list2, this.internalPointerEvent);
        }
        LongSparseArray longSparseArray = new LongSparseArray(list.size());
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            PointerInputChange pointerInputChange = list2.get(i);
            longSparseArray.put(pointerInputChange.m5111getIdJ3iCeTQ(), pointerInputChange);
            Collection collection = arrayList;
            long r11 = pointerInputChange.m5111getIdJ3iCeTQ();
            long uptimeMillis = pointerInputChange.getUptimeMillis();
            long r16 = pointerInputChange.m5113getPositionF1C5BW0();
            long r18 = pointerInputChange.m5113getPositionF1C5BW0();
            boolean pressed = pointerInputChange.getPressed();
            float pressure = pointerInputChange.getPressure();
            int r22 = pointerInputChange.m5116getTypeT8wyACA();
            InternalPointerEvent internalPointerEvent2 = this.internalPointerEvent;
            int i2 = i;
            if (internalPointerEvent2 != null) {
                z = true;
                if (internalPointerEvent2.m5041issuesEnterExitEvent0FcD4WY(pointerInputChange.m5111getIdJ3iCeTQ())) {
                    PointerInputEventData pointerInputEventData = r10;
                    PointerInputEventData pointerInputEventData2 = new PointerInputEventData(r11, uptimeMillis, r16, r18, pressed, pressure, r22, z, (List) null, 0, 0, 1792, (DefaultConstructorMarker) null);
                    collection.add(pointerInputEventData);
                    i = i2 + 1;
                }
            }
            z = false;
            PointerInputEventData pointerInputEventData3 = pointerInputEventData2;
            PointerInputEventData pointerInputEventData22 = new PointerInputEventData(r11, uptimeMillis, r16, r18, pressed, pressure, r22, z, (List) null, 0, 0, 1792, (DefaultConstructorMarker) null);
            collection.add(pointerInputEventData3);
            i = i2 + 1;
        }
        return new PointerEvent(list2, new InternalPointerEvent(longSparseArray, new PointerInputEvent(motionEvent.getEventTime(), arrayList, motionEvent2)));
    }
}
