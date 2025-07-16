package jp.co.sony.reonpocket.constant;

import java.util.Iterator;
import jp.co.sony.reonpocket.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/constant/NotificationId;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "TimeActionNotificationReceiver", "FirebaseCloudMessageService", "LaunchApplicationNotificationService", "NotifyAlertGroup", "NotifyAlertVbusVoltage", "NotifyAlertUsbWater", "NotifyAlertAroundUsbWater", "NotifyAlertAroundUsbHeat", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MyNotificationConstant.kt */
public enum NotificationId {
    TimeActionNotificationReceiver(R.string.app_name),
    FirebaseCloudMessageService(1),
    LaunchApplicationNotificationService(2),
    NotifyAlertGroup(100),
    NotifyAlertVbusVoltage(236),
    NotifyAlertUsbWater(237),
    NotifyAlertAroundUsbWater(238),
    NotifyAlertAroundUsbHeat(239);
    
    public static final Companion Companion = null;
    private final int id;

    public static EnumEntries<NotificationId> getEntries() {
        return $ENTRIES;
    }

    private NotificationId(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }

    static {
        NotificationId[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/constant/NotificationId$Companion;", "", "()V", "from", "Ljp/co/sony/reonpocket/constant/NotificationId;", "id", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MyNotificationConstant.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationId from(int i) {
            Object obj;
            Iterator it = NotificationId.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((NotificationId) obj).getId() == i) {
                    break;
                }
            }
            return (NotificationId) obj;
        }
    }
}
