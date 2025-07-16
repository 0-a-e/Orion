package jp.co.sony.reonpocket.constant;

import jp.co.sony.reonpocket.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel;", "", "id", "", "name", "", "description", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getDescription", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getName", "()I", "NotificationGroup", "NotifyAlert", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MyNotificationConstant.kt */
public abstract class MyNotificationChannel {
    public static final int $stable = 0;
    private final Integer description;
    private final String id;
    private final int name;

    public /* synthetic */ MyNotificationChannel(String str, int i, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, num);
    }

    private MyNotificationChannel(String str, int i, Integer num) {
        this.id = str;
        this.name = i;
        this.description = num;
    }

    public final String getId() {
        return this.id;
    }

    public final int getName() {
        return this.name;
    }

    public final Integer getDescription() {
        return this.description;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0007B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0001\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotificationGroup;", "", "id", "", "(I)V", "getId", "()I", "Notification", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MyNotificationConstant.kt */
    public static abstract class NotificationGroup {
        public static final int $stable = 0;
        private final int id;

        public /* synthetic */ NotificationGroup(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        private NotificationGroup(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotificationGroup$Notification;", "", "id", "", "title", "description", "(IILjava/lang/Integer;)V", "getDescription", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()I", "getTitle", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup$AroundUsbHeat;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup$AroundUsbWater;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup$UsbWater;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup$VbusVoltage;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: MyNotificationConstant.kt */
        public static abstract class Notification {
            public static final int $stable = 0;
            private final Integer description;
            private final int id;
            private final int title;

            public /* synthetic */ Notification(int i, int i2, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2, num);
            }

            private Notification(int i, int i2, Integer num) {
                this.id = i;
                this.title = i2;
                this.description = num;
            }

            public final int getId() {
                return this.id;
            }

            public final int getTitle() {
                return this.title;
            }

            public final Integer getDescription() {
                return this.description;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NotificationGroup", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MyNotificationConstant.kt */
    public static final class NotifyAlert extends MyNotificationChannel {
        public static final int $stable = 0;
        public static final NotifyAlert INSTANCE = new NotifyAlert();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NotifyAlert)) {
                return false;
            }
            NotifyAlert notifyAlert = (NotifyAlert) obj;
            return true;
        }

        public int hashCode() {
            return -398181952;
        }

        public String toString() {
            return "NotifyAlert";
        }

        private NotifyAlert() {
            super("notify.alert", R.string.dev_alerts_android_notification_channel_name, (Integer) null, (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\n\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotificationGroup;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "AroundUsbHeat", "AroundUsbWater", "UsbWater", "VbusVoltage", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: MyNotificationConstant.kt */
        public static final class NotificationGroup extends NotificationGroup {
            public static final int $stable = 0;
            public static final NotificationGroup INSTANCE = new NotificationGroup();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NotificationGroup)) {
                    return false;
                }
                NotificationGroup notificationGroup = (NotificationGroup) obj;
                return true;
            }

            public int hashCode() {
                return -322468986;
            }

            public String toString() {
                return "NotificationGroup";
            }

            private NotificationGroup() {
                super(NotificationId.NotifyAlertGroup.getId(), (DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup$VbusVoltage;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotificationGroup$Notification;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* compiled from: MyNotificationConstant.kt */
            public static final class VbusVoltage extends NotificationGroup.Notification {
                public static final int $stable = 0;
                public static final VbusVoltage INSTANCE = new VbusVoltage();

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof VbusVoltage)) {
                        return false;
                    }
                    VbusVoltage vbusVoltage = (VbusVoltage) obj;
                    return true;
                }

                public int hashCode() {
                    return -1067101396;
                }

                public String toString() {
                    return "VbusVoltage";
                }

                private VbusVoltage() {
                    super(NotificationId.NotifyAlertVbusVoltage.getId(), R.string.dev_vbus_voltage_alert_notification_title, Integer.valueOf(R.string.dev_vbus_voltage_alert_notification_description), (DefaultConstructorMarker) null);
                }
            }

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup$UsbWater;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotificationGroup$Notification;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* compiled from: MyNotificationConstant.kt */
            public static final class UsbWater extends NotificationGroup.Notification {
                public static final int $stable = 0;
                public static final UsbWater INSTANCE = new UsbWater();

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof UsbWater)) {
                        return false;
                    }
                    UsbWater usbWater = (UsbWater) obj;
                    return true;
                }

                public int hashCode() {
                    return -2011411589;
                }

                public String toString() {
                    return "UsbWater";
                }

                private UsbWater() {
                    super(NotificationId.NotifyAlertUsbWater.getId(), R.string.dev_usb_water_alert_notification_title, Integer.valueOf(R.string.dev_usb_water_alert_notification_description), (DefaultConstructorMarker) null);
                }
            }

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup$AroundUsbWater;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotificationGroup$Notification;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* compiled from: MyNotificationConstant.kt */
            public static final class AroundUsbWater extends NotificationGroup.Notification {
                public static final int $stable = 0;
                public static final AroundUsbWater INSTANCE = new AroundUsbWater();

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof AroundUsbWater)) {
                        return false;
                    }
                    AroundUsbWater aroundUsbWater = (AroundUsbWater) obj;
                    return true;
                }

                public int hashCode() {
                    return -1433660824;
                }

                public String toString() {
                    return "AroundUsbWater";
                }

                private AroundUsbWater() {
                    super(NotificationId.NotifyAlertAroundUsbWater.getId(), R.string.dev_around_usb_water_alert_notification_title, Integer.valueOf(R.string.dev_around_usb_water_alert_notification_description), (DefaultConstructorMarker) null);
                }
            }

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotifyAlert$NotificationGroup$AroundUsbHeat;", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotificationGroup$Notification;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* compiled from: MyNotificationConstant.kt */
            public static final class AroundUsbHeat extends NotificationGroup.Notification {
                public static final int $stable = 0;
                public static final AroundUsbHeat INSTANCE = new AroundUsbHeat();

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof AroundUsbHeat)) {
                        return false;
                    }
                    AroundUsbHeat aroundUsbHeat = (AroundUsbHeat) obj;
                    return true;
                }

                public int hashCode() {
                    return 1061687935;
                }

                public String toString() {
                    return "AroundUsbHeat";
                }

                private AroundUsbHeat() {
                    super(NotificationId.NotifyAlertAroundUsbHeat.getId(), R.string.dev_around_usb_heat_alert_notification_title, Integer.valueOf(R.string.dev_around_usb_heat_alert_notification_description), (DefaultConstructorMarker) null);
                }
            }
        }
    }
}
