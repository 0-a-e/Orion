package jp.co.sony.reonpocket.connection.aws;

import android.content.Context;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002JE\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013JE\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ljp/co/sony/reonpocket/connection/aws/DynamoDBManager;", "", "()V", "TAG", "", "mDynamoDBMapper", "Lcom/amazonaws/mobileconnectors/dynamodbv2/dynamodbmapper/DynamoDBMapper;", "mRegions", "Lcom/amazonaws/regions/Regions;", "createDBMapper", "", "aContext", "Landroid/content/Context;", "registerDeviceInfo", "aDeviceInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/DeviceInfoEntity;", "aIsCreate", "", "aCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "aResult", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DynamoDBManager.kt */
public final class DynamoDBManager {
    public static final int $stable = 8;
    public static final DynamoDBManager INSTANCE = new DynamoDBManager();
    private static final String TAG = "AwsManager_DynamoDBManager";
    /* access modifiers changed from: private */
    public static DynamoDBMapper mDynamoDBMapper;
    private static final Regions mRegions = Regions.AP_NORTHEAST_1;

    private DynamoDBManager() {
    }

    public static /* synthetic */ void registerUserInfo$default(DynamoDBManager dynamoDBManager, Context context, UserInfoEntity userInfoEntity, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        dynamoDBManager.registerUserInfo(context, userInfoEntity, z, function1);
    }

    public final void registerUserInfo(Context context, UserInfoEntity userInfoEntity, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(userInfoEntity, "aUserInfoEntity");
        ThreadsKt.thread$default(true, false, (ClassLoader) null, (String) null, 0, new DynamoDBManager$registerUserInfo$1(context, userInfoEntity, z, function1), 30, (Object) null);
    }

    public static /* synthetic */ void registerDeviceInfo$default(DynamoDBManager dynamoDBManager, Context context, DeviceInfoEntity deviceInfoEntity, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        dynamoDBManager.registerDeviceInfo(context, deviceInfoEntity, z, function1);
    }

    public final void registerDeviceInfo(Context context, DeviceInfoEntity deviceInfoEntity, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(deviceInfoEntity, "aDeviceInfoEntity");
        ThreadsKt.thread$default(true, false, (ClassLoader) null, (String) null, 0, new DynamoDBManager$registerDeviceInfo$1(context, deviceInfoEntity, z, function1), 30, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void createDBMapper(Context context) {
        if (CognitoManager.INSTANCE.getMCredentialsProvider() == null) {
            DynamoDBManager dynamoDBManager = this;
            CognitoManager.INSTANCE.createCredentialsProvider(context);
            Unit unit = Unit.INSTANCE;
        }
        CognitoCachingCredentialsProvider mCredentialsProvider = CognitoManager.INSTANCE.getMCredentialsProvider();
        if (mCredentialsProvider != null) {
            AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBClient((AWSCredentialsProvider) mCredentialsProvider);
            amazonDynamoDBClient.setRegion(Region.getRegion(mRegions));
            mDynamoDBMapper = DynamoDBMapper.builder().dynamoDBClient(amazonDynamoDBClient).awsConfiguration(AWSMobileClient.getInstance().getConfiguration()).build();
        }
    }
}
