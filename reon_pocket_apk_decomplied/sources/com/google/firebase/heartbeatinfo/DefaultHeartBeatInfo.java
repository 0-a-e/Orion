package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultHeartBeatInfo implements HeartBeatInfo {
    private static final ThreadFactory THREAD_FACTORY = new DefaultHeartBeatInfo$$ExternalSyntheticLambda2();
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private Provider<HeartBeatInfoStorage> storageProvider;

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        return new Thread(runnable, "heartbeat-information-executor");
    }

    private DefaultHeartBeatInfo(Context context, Set<HeartBeatConsumer> set) {
        this(new Lazy(new DefaultHeartBeatInfo$$ExternalSyntheticLambda0(context)), set, new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY));
    }

    DefaultHeartBeatInfo(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
    }

    public HeartBeatInfo.HeartBeat getHeartBeatCode(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean shouldSendSdkHeartBeat = this.storageProvider.get().shouldSendSdkHeartBeat(str, currentTimeMillis);
        boolean shouldSendGlobalHeartBeat = this.storageProvider.get().shouldSendGlobalHeartBeat(currentTimeMillis);
        if (shouldSendSdkHeartBeat && shouldSendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (shouldSendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        if (shouldSendSdkHeartBeat) {
            return HeartBeatInfo.HeartBeat.SDK;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    public Task<List<HeartBeatResult>> getAndClearStoredHeartBeatInfo() {
        return Tasks.call(this.backgroundExecutor, new DefaultHeartBeatInfo$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getAndClearStoredHeartBeatInfo$2$com-google-firebase-heartbeatinfo-DefaultHeartBeatInfo  reason: not valid java name */
    public /* synthetic */ List m6964lambda$getAndClearStoredHeartBeatInfo$2$comgooglefirebaseheartbeatinfoDefaultHeartBeatInfo() throws Exception {
        HeartBeatInfo.HeartBeat heartBeat;
        ArrayList arrayList = new ArrayList();
        HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
        List<SdkHeartBeatResult> storedHeartBeats = heartBeatInfoStorage.getStoredHeartBeats(true);
        long lastGlobalHeartBeat = heartBeatInfoStorage.getLastGlobalHeartBeat();
        for (SdkHeartBeatResult next : storedHeartBeats) {
            boolean isSameDateUtc = HeartBeatInfoStorage.isSameDateUtc(lastGlobalHeartBeat, next.getMillis());
            if (isSameDateUtc) {
                heartBeat = HeartBeatInfo.HeartBeat.COMBINED;
            } else {
                heartBeat = HeartBeatInfo.HeartBeat.SDK;
            }
            if (isSameDateUtc) {
                lastGlobalHeartBeat = next.getMillis();
            }
            arrayList.add(HeartBeatResult.create(next.getSdkName(), next.getMillis(), heartBeat));
        }
        if (lastGlobalHeartBeat > 0) {
            heartBeatInfoStorage.updateGlobalHeartBeat(lastGlobalHeartBeat);
        }
        return arrayList;
    }

    public Task<Void> storeHeartBeatInfo(String str) {
        if (this.consumers.size() <= 0) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.backgroundExecutor, new DefaultHeartBeatInfo$$ExternalSyntheticLambda4(this, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$storeHeartBeatInfo$3$com-google-firebase-heartbeatinfo-DefaultHeartBeatInfo  reason: not valid java name */
    public /* synthetic */ Void m6965lambda$storeHeartBeatInfo$3$comgooglefirebaseheartbeatinfoDefaultHeartBeatInfo(String str) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.storageProvider.get().shouldSendSdkHeartBeat(str, currentTimeMillis)) {
            return null;
        }
        this.storageProvider.get().storeHeartBeatInformation(str, currentTimeMillis);
        return null;
    }

    public static Component<HeartBeatInfo> component() {
        return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).add(Dependency.setOf(HeartBeatConsumer.class)).factory(new DefaultHeartBeatInfo$$ExternalSyntheticLambda3()).build();
    }

    static /* synthetic */ HeartBeatInfo lambda$component$4(ComponentContainer componentContainer) {
        return new DefaultHeartBeatInfo((Context) componentContainer.get(Context.class), componentContainer.setOf(HeartBeatConsumer.class));
    }
}
