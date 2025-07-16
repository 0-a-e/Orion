package jp.co.sony.reonpocket.connection.aws;

import android.content.Context;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ljp/co/sony/reonpocket/connection/aws/CognitoManager;", "", "()V", "IDENTITY_POOL_ID", "", "mCredentialsProvider", "Lcom/amazonaws/auth/CognitoCachingCredentialsProvider;", "getMCredentialsProvider", "()Lcom/amazonaws/auth/CognitoCachingCredentialsProvider;", "setMCredentialsProvider", "(Lcom/amazonaws/auth/CognitoCachingCredentialsProvider;)V", "mRegions", "Lcom/amazonaws/regions/Regions;", "createCredentialsProvider", "", "aContext", "Landroid/content/Context;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CognitoManager.kt */
public final class CognitoManager {
    public static final int $stable = 8;
    private static final String IDENTITY_POOL_ID = "ap-northeast-1:114a5e31-f7c3-423f-b4f0-8e44152f1a32";
    public static final CognitoManager INSTANCE = new CognitoManager();
    private static CognitoCachingCredentialsProvider mCredentialsProvider;
    private static final Regions mRegions = Regions.AP_NORTHEAST_1;

    private CognitoManager() {
    }

    public final CognitoCachingCredentialsProvider getMCredentialsProvider() {
        return mCredentialsProvider;
    }

    public final void setMCredentialsProvider(CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider) {
        mCredentialsProvider = cognitoCachingCredentialsProvider;
    }

    public final void createCredentialsProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        if (mCredentialsProvider == null) {
            mCredentialsProvider = new CognitoCachingCredentialsProvider(context.getApplicationContext(), "ap-northeast-1:114a5e31-f7c3-423f-b4f0-8e44152f1a32", mRegions);
            Unit unit = Unit.INSTANCE;
        }
    }
}
