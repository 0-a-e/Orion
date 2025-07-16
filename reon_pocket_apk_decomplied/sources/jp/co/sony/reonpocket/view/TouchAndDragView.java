package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0002'(B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u001e\u0010\u001f\u001a\u00020\u000e2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000fJ\u001e\u0010 \u001a\u00020\u000e2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\rj\u0002`\u0012J\u001e\u0010\"\u001a\u00020\u000e2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u0014J\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011H\u0002R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000fX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\u0004\u0018\u0001`\u0012X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Ljp/co/sony/reonpocket/view/TouchAndDragView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "absoluteX", "absoluteY", "addTouchAction", "Lkotlin/Function1;", "", "Ljp/co/sony/reonpocket/view/AddTouchAction;", "detailMovementSetting", "Ljp/co/sony/reonpocket/view/TouchAndDragView$Coordinate;", "Ljp/co/sony/reonpocket/view/DetailMovementSettingHandler;", "moveCompletion", "Ljp/co/sony/reonpocket/view/MoveLocalPositionCompletion;", "movementDirectionPossible", "Ljp/co/sony/reonpocket/view/TouchAndDragView$MovementDirection;", "init", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "performClick", "setAddTouchAction", "setLocalMoving", "setting", "setMovedCompletion", "setMovementDirectionPossible", "direction", "updateLocalPosition", "newCoordinate", "Coordinate", "MovementDirection", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TouchAndDragView.kt */
public class TouchAndDragView extends ConstraintLayout implements View.OnTouchListener {
    public static final int $stable = 8;
    private int absoluteX;
    private int absoluteY;
    private Function1<? super Integer, Unit> addTouchAction;
    private Function1<? super Coordinate, Coordinate> detailMovementSetting;
    private Function1<? super Coordinate, Unit> moveCompletion;
    private MovementDirection movementDirectionPossible;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TouchAndDragView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                jp.co.sony.reonpocket.view.TouchAndDragView$MovementDirection[] r0 = jp.co.sony.reonpocket.view.TouchAndDragView.MovementDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.view.TouchAndDragView$MovementDirection r1 = jp.co.sony.reonpocket.view.TouchAndDragView.MovementDirection.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.view.TouchAndDragView$MovementDirection r1 = jp.co.sony.reonpocket.view.TouchAndDragView.MovementDirection.UP_AND_DOWN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.view.TouchAndDragView.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TouchAndDragView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TouchAndDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TouchAndDragView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchAndDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.movementDirectionPossible = MovementDirection.NONE;
        init();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/view/TouchAndDragView$Coordinate;", "", "x", "", "y", "(II)V", "getX", "()I", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TouchAndDragView.kt */
    public static final class Coordinate {
        public static final int $stable = 0;
        private final int x;
        private final int y;

        public static /* synthetic */ Coordinate copy$default(Coordinate coordinate, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = coordinate.x;
            }
            if ((i3 & 2) != 0) {
                i2 = coordinate.y;
            }
            return coordinate.copy(i, i2);
        }

        public final int component1() {
            return this.x;
        }

        public final int component2() {
            return this.y;
        }

        public final Coordinate copy(int i, int i2) {
            return new Coordinate(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Coordinate)) {
                return false;
            }
            Coordinate coordinate = (Coordinate) obj;
            return this.x == coordinate.x && this.y == coordinate.y;
        }

        public int hashCode() {
            return (this.x * 31) + this.y;
        }

        public String toString() {
            int i = this.x;
            int i2 = this.y;
            return "Coordinate(x=" + i + ", y=" + i2 + ")";
        }

        public Coordinate(int i, int i2) {
            this.x = i;
            this.y = i2;
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/view/TouchAndDragView$MovementDirection;", "", "(Ljava/lang/String;I)V", "NONE", "UP_AND_DOWN", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TouchAndDragView.kt */
    public enum MovementDirection {
        NONE,
        UP_AND_DOWN;

        public static EnumEntries<MovementDirection> getEntries() {
            return $ENTRIES;
        }

        static {
            MovementDirection[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    private final void init() {
        setOnTouchListener(this);
    }

    public boolean performClick() {
        super.performClick();
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Function1<? super Integer, Unit> function1;
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            if (view != null) {
                view.performClick();
            }
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            Coordinate updateLocalPosition = updateLocalPosition(new Coordinate(rawX, rawY));
            this.absoluteX = rawX;
            this.absoluteY = rawY;
            layout(updateLocalPosition.getX(), updateLocalPosition.getY(), updateLocalPosition.getX() + getWidth(), updateLocalPosition.getY() + getHeight());
            Function1<? super Coordinate, Unit> function12 = this.moveCompletion;
            if (function12 != null) {
                function12.invoke(updateLocalPosition);
            }
            Function1<? super Integer, Unit> function13 = this.addTouchAction;
            if (function13 != null) {
                function13.invoke(2);
            }
        } else if (valueOf != null && valueOf.intValue() == 0) {
            this.absoluteX = (int) motionEvent.getRawX();
            this.absoluteY = (int) motionEvent.getRawY();
            Function1<? super Integer, Unit> function14 = this.addTouchAction;
            if (function14 != null) {
                function14.invoke(0);
            }
        } else if (!(valueOf == null || valueOf.intValue() != 1 || (function1 = this.addTouchAction) == null)) {
            function1.invoke(1);
        }
        return true;
    }

    public final void setMovementDirectionPossible(MovementDirection movementDirection) {
        Intrinsics.checkNotNullParameter(movementDirection, "direction");
        this.movementDirectionPossible = movementDirection;
    }

    public final void setLocalMoving(Function1<? super Coordinate, Coordinate> function1) {
        Intrinsics.checkNotNullParameter(function1, "setting");
        this.detailMovementSetting = function1;
    }

    public final void setMovedCompletion(Function1<? super Coordinate, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "setting");
        this.moveCompletion = function1;
    }

    public final void setAddTouchAction(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NotificationCompat.CATEGORY_EVENT);
        this.addTouchAction = function1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0024, code lost:
        if (r6 != 2) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r6 = r6.invoke(new jp.co.sony.reonpocket.view.TouchAndDragView.Coordinate(r0, r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final jp.co.sony.reonpocket.view.TouchAndDragView.Coordinate updateLocalPosition(jp.co.sony.reonpocket.view.TouchAndDragView.Coordinate r6) {
        /*
            r5 = this;
            int r0 = r5.getLeft()
            int r1 = r5.getTop()
            int r2 = r5.absoluteX
            int r3 = r6.getX()
            int r2 = r2 - r3
            int r3 = r5.absoluteY
            int r6 = r6.getY()
            int r3 = r3 - r6
            jp.co.sony.reonpocket.view.TouchAndDragView$MovementDirection r6 = r5.movementDirectionPossible
            int[] r4 = jp.co.sony.reonpocket.view.TouchAndDragView.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r4[r6]
            r4 = 1
            if (r6 == r4) goto L_0x0027
            r2 = 2
            if (r6 == r2) goto L_0x0028
            goto L_0x0029
        L_0x0027:
            int r0 = r0 - r2
        L_0x0028:
            int r1 = r1 - r3
        L_0x0029:
            kotlin.jvm.functions.Function1<? super jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate, jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate> r6 = r5.detailMovementSetting
            if (r6 == 0) goto L_0x003a
            jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate r2 = new jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate
            r2.<init>(r0, r1)
            java.lang.Object r6 = r6.invoke(r2)
            jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate r6 = (jp.co.sony.reonpocket.view.TouchAndDragView.Coordinate) r6
            if (r6 != 0) goto L_0x003f
        L_0x003a:
            jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate r6 = new jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate
            r6.<init>(r0, r1)
        L_0x003f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.view.TouchAndDragView.updateLocalPosition(jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate):jp.co.sony.reonpocket.view.TouchAndDragView$Coordinate");
    }
}
