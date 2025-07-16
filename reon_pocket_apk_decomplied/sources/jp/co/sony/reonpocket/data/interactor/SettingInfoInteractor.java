package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reonpocket.data.interactor.SettingInfoInteractorInput;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractor;", "Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractorInput;", "()V", "mTestUrl", "", "compareFirmRevisionWithServer", "", "aListener", "Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractorInput$OnCompleteListener;", "AppVersionComparisonResult", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingInfoInteractor.kt */
public final class SettingInfoInteractor implements SettingInfoInteractorInput {
    public static final int $stable = 0;
    private final String mTestUrl = "https://rnp-dev-appinfo.s3-ap-northeast-1.amazonaws.com/app-params/latest-app-version-debug-future-version";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractor$AppVersionComparisonResult;", "", "(Ljava/lang/String;I)V", "LATEST_APP", "OLDER_APP", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingInfoInteractor.kt */
    public enum AppVersionComparisonResult {
        LATEST_APP,
        OLDER_APP;

        public static EnumEntries<AppVersionComparisonResult> getEntries() {
            return $ENTRIES;
        }

        static {
            AppVersionComparisonResult[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public void compareFirmRevisionWithServer(SettingInfoInteractorInput.OnCompleteListener onCompleteListener) {
        Intrinsics.checkNotNullParameter(onCompleteListener, "aListener");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SettingInfoInteractor$compareFirmRevisionWithServer$1(onCompleteListener, (Continuation<? super SettingInfoInteractor$compareFirmRevisionWithServer$1>) null), 3, (Object) null);
    }
}
