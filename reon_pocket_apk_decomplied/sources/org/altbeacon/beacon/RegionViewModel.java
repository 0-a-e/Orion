package org.altbeacon.beacon;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Lorg/altbeacon/beacon/RegionViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "rangedBeacons", "Landroidx/lifecycle/MutableLiveData;", "", "Lorg/altbeacon/beacon/Beacon;", "getRangedBeacons", "()Landroidx/lifecycle/MutableLiveData;", "rangedBeacons$delegate", "Lkotlin/Lazy;", "regionState", "", "getRegionState", "regionState$delegate", "android-beacon-library_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: RegionViewModel.kt */
public final class RegionViewModel extends ViewModel {
    private final Lazy rangedBeacons$delegate = LazyKt.lazy(RegionViewModel$rangedBeacons$2.INSTANCE);
    private final Lazy regionState$delegate = LazyKt.lazy(RegionViewModel$regionState$2.INSTANCE);

    public final MutableLiveData<Collection<Beacon>> getRangedBeacons() {
        return (MutableLiveData) this.rangedBeacons$delegate.getValue();
    }

    public final MutableLiveData<Integer> getRegionState() {
        return (MutableLiveData) this.regionState$delegate.getValue();
    }
}
