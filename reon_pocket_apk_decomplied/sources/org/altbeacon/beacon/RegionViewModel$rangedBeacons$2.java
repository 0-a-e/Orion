package org.altbeacon.beacon;

import androidx.lifecycle.MutableLiveData;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "Lorg/altbeacon/beacon/Beacon;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RegionViewModel.kt */
final class RegionViewModel$rangedBeacons$2 extends Lambda implements Function0<MutableLiveData<Collection<? extends Beacon>>> {
    public static final RegionViewModel$rangedBeacons$2 INSTANCE = new RegionViewModel$rangedBeacons$2();

    RegionViewModel$rangedBeacons$2() {
        super(0);
    }

    public final MutableLiveData<Collection<Beacon>> invoke() {
        return new MutableLiveData<>();
    }
}
