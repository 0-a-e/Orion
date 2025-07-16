package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J;\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "", "capability1", "Ljp/co/sony/reonpocket/data/entity/Capability1;", "capability2", "Ljp/co/sony/reonpocket/data/entity/Capability2;", "capability3", "Ljp/co/sony/reonpocket/data/entity/Capability3;", "capability4", "Ljp/co/sony/reonpocket/data/entity/Capability4;", "capability5", "Ljp/co/sony/reonpocket/data/entity/Capability5;", "(Ljp/co/sony/reonpocket/data/entity/Capability1;Ljp/co/sony/reonpocket/data/entity/Capability2;Ljp/co/sony/reonpocket/data/entity/Capability3;Ljp/co/sony/reonpocket/data/entity/Capability4;Ljp/co/sony/reonpocket/data/entity/Capability5;)V", "getCapability1", "()Ljp/co/sony/reonpocket/data/entity/Capability1;", "setCapability1", "(Ljp/co/sony/reonpocket/data/entity/Capability1;)V", "getCapability2", "()Ljp/co/sony/reonpocket/data/entity/Capability2;", "setCapability2", "(Ljp/co/sony/reonpocket/data/entity/Capability2;)V", "getCapability3", "()Ljp/co/sony/reonpocket/data/entity/Capability3;", "setCapability3", "(Ljp/co/sony/reonpocket/data/entity/Capability3;)V", "getCapability4", "()Ljp/co/sony/reonpocket/data/entity/Capability4;", "setCapability4", "(Ljp/co/sony/reonpocket/data/entity/Capability4;)V", "getCapability5", "()Ljp/co/sony/reonpocket/data/entity/Capability5;", "setCapability5", "(Ljp/co/sony/reonpocket/data/entity/Capability5;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CapabilityEntity.kt */
public final class CapabilityEntity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Capability1 capability1;
    private Capability2 capability2;
    private Capability3 capability3;
    private Capability4 capability4;
    private Capability5 capability5;

    public static /* synthetic */ CapabilityEntity copy$default(CapabilityEntity capabilityEntity, Capability1 capability12, Capability2 capability22, Capability3 capability32, Capability4 capability42, Capability5 capability52, int i, Object obj) {
        if ((i & 1) != 0) {
            capability12 = capabilityEntity.capability1;
        }
        if ((i & 2) != 0) {
            capability22 = capabilityEntity.capability2;
        }
        Capability2 capability23 = capability22;
        if ((i & 4) != 0) {
            capability32 = capabilityEntity.capability3;
        }
        Capability3 capability33 = capability32;
        if ((i & 8) != 0) {
            capability42 = capabilityEntity.capability4;
        }
        Capability4 capability43 = capability42;
        if ((i & 16) != 0) {
            capability52 = capabilityEntity.capability5;
        }
        return capabilityEntity.copy(capability12, capability23, capability33, capability43, capability52);
    }

    public final Capability1 component1() {
        return this.capability1;
    }

    public final Capability2 component2() {
        return this.capability2;
    }

    public final Capability3 component3() {
        return this.capability3;
    }

    public final Capability4 component4() {
        return this.capability4;
    }

    public final Capability5 component5() {
        return this.capability5;
    }

    public final CapabilityEntity copy(Capability1 capability12, Capability2 capability22, Capability3 capability32, Capability4 capability42, Capability5 capability52) {
        Intrinsics.checkNotNullParameter(capability12, "capability1");
        Intrinsics.checkNotNullParameter(capability22, "capability2");
        Intrinsics.checkNotNullParameter(capability32, "capability3");
        Intrinsics.checkNotNullParameter(capability42, "capability4");
        Intrinsics.checkNotNullParameter(capability52, "capability5");
        return new CapabilityEntity(capability12, capability22, capability32, capability42, capability52);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CapabilityEntity)) {
            return false;
        }
        CapabilityEntity capabilityEntity = (CapabilityEntity) obj;
        return Intrinsics.areEqual((Object) this.capability1, (Object) capabilityEntity.capability1) && Intrinsics.areEqual((Object) this.capability2, (Object) capabilityEntity.capability2) && Intrinsics.areEqual((Object) this.capability3, (Object) capabilityEntity.capability3) && Intrinsics.areEqual((Object) this.capability4, (Object) capabilityEntity.capability4) && Intrinsics.areEqual((Object) this.capability5, (Object) capabilityEntity.capability5);
    }

    public int hashCode() {
        return (((((((this.capability1.hashCode() * 31) + this.capability2.hashCode()) * 31) + this.capability3.hashCode()) * 31) + this.capability4.hashCode()) * 31) + this.capability5.hashCode();
    }

    public String toString() {
        Capability1 capability12 = this.capability1;
        Capability2 capability22 = this.capability2;
        Capability3 capability32 = this.capability3;
        Capability4 capability42 = this.capability4;
        Capability5 capability52 = this.capability5;
        return "CapabilityEntity(capability1=" + capability12 + ", capability2=" + capability22 + ", capability3=" + capability32 + ", capability4=" + capability42 + ", capability5=" + capability52 + ")";
    }

    public CapabilityEntity(Capability1 capability12, Capability2 capability22, Capability3 capability32, Capability4 capability42, Capability5 capability52) {
        Intrinsics.checkNotNullParameter(capability12, "capability1");
        Intrinsics.checkNotNullParameter(capability22, "capability2");
        Intrinsics.checkNotNullParameter(capability32, "capability3");
        Intrinsics.checkNotNullParameter(capability42, "capability4");
        Intrinsics.checkNotNullParameter(capability52, "capability5");
        this.capability1 = capability12;
        this.capability2 = capability22;
        this.capability3 = capability32;
        this.capability4 = capability42;
        this.capability5 = capability52;
    }

    public final Capability1 getCapability1() {
        return this.capability1;
    }

    public final void setCapability1(Capability1 capability12) {
        Intrinsics.checkNotNullParameter(capability12, "<set-?>");
        this.capability1 = capability12;
    }

    public final Capability2 getCapability2() {
        return this.capability2;
    }

    public final void setCapability2(Capability2 capability22) {
        Intrinsics.checkNotNullParameter(capability22, "<set-?>");
        this.capability2 = capability22;
    }

    public final Capability3 getCapability3() {
        return this.capability3;
    }

    public final void setCapability3(Capability3 capability32) {
        Intrinsics.checkNotNullParameter(capability32, "<set-?>");
        this.capability3 = capability32;
    }

    public final Capability4 getCapability4() {
        return this.capability4;
    }

    public final void setCapability4(Capability4 capability42) {
        Intrinsics.checkNotNullParameter(capability42, "<set-?>");
        this.capability4 = capability42;
    }

    public final Capability5 getCapability5() {
        return this.capability5;
    }

    public final void setCapability5(Capability5 capability52) {
        Intrinsics.checkNotNullParameter(capability52, "<set-?>");
        this.capability5 = capability52;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/CapabilityEntity$Companion;", "", "()V", "toObject", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CapabilityEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CapabilityEntity toObject(BleDataEntity bleDataEntity) {
            Integer intValue$default;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            if (bleDataEntity.getData() == null || (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null)) == null) {
                return null;
            }
            int intValue = intValue$default.intValue();
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
            if (intValue$default2 == null) {
                return null;
            }
            int intValue2 = intValue$default2.intValue();
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 2, (ByteOrder) null, 4, (Object) null);
            if (intValue$default3 == null) {
                return null;
            }
            int intValue3 = intValue$default3.intValue();
            Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
            if (intValue$default4 == null) {
                return null;
            }
            int intValue4 = intValue$default4.intValue();
            Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 4, (ByteOrder) null, 4, (Object) null);
            if (intValue$default5 == null) {
                return null;
            }
            return new CapabilityEntity(new Capability1(intValue), new Capability2(intValue2), new Capability3(intValue3), new Capability4(intValue4), new Capability5(intValue$default5.intValue()));
        }
    }
}
