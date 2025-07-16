package jp.co.sony.reonpocket.connection.aws;

import android.content.Context;
import android.os.Build;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.UuidHelperUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: DynamoDBManager.kt */
final class DynamoDBManager$registerDeviceInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $aCallback;
    final /* synthetic */ Context $aContext;
    final /* synthetic */ DeviceInfoEntity $aDeviceInfoEntity;
    final /* synthetic */ boolean $aIsCreate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DynamoDBManager$registerDeviceInfo$1(Context context, DeviceInfoEntity deviceInfoEntity, boolean z, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$aContext = context;
        this.$aDeviceInfoEntity = deviceInfoEntity;
        this.$aIsCreate = z;
        this.$aCallback = function1;
    }

    public final void invoke() {
        DateFormat dateFormat;
        CognitoCachingCredentialsProvider mCredentialsProvider;
        if (DynamoDBManager.mDynamoDBMapper == null) {
            DynamoDBManager.INSTANCE.createDBMapper(this.$aContext);
            Unit unit = Unit.INSTANCE;
        }
        DynamoDBMapper access$getMDynamoDBMapper$p = DynamoDBManager.mDynamoDBMapper;
        if (access$getMDynamoDBMapper$p != null) {
            DeviceInfoEntity deviceInfoEntity = this.$aDeviceInfoEntity;
            Context context = this.$aContext;
            boolean z = this.$aIsCreate;
            Function1<Boolean, Unit> function1 = this.$aCallback;
            try {
                CognitoCachingCredentialsProvider mCredentialsProvider2 = CognitoManager.INSTANCE.getMCredentialsProvider();
                if ((mCredentialsProvider2 == null || mCredentialsProvider2.getCachedIdentityId() == null) && (mCredentialsProvider = CognitoManager.INSTANCE.getMCredentialsProvider()) != null) {
                    mCredentialsProvider.getIdentityId();
                }
                CognitoCachingCredentialsProvider mCredentialsProvider3 = CognitoManager.INSTANCE.getMCredentialsProvider();
                String str = null;
                String cachedIdentityId = mCredentialsProvider3 != null ? mCredentialsProvider3.getCachedIdentityId() : null;
                if (cachedIdentityId != null) {
                    Intrinsics.checkNotNull(cachedIdentityId);
                    deviceInfoEntity.setOwnerId(UuidHelperUtil.INSTANCE.getUUIDFromByteArray(UuidHelperUtil.INSTANCE.getOwnIdByteArray(context)));
                    TimeZone timeZone = TimeZone.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
                    } else {
                        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ");
                    }
                    dateFormat.setTimeZone(timeZone);
                    String format = dateFormat.format(new Date());
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    if (z) {
                        str = format;
                    }
                    deviceInfoEntity.setCreated(str);
                    deviceInfoEntity.setUpdated(format);
                    if (z) {
                        access$getMDynamoDBMapper$p.save(deviceInfoEntity);
                    } else {
                        access$getMDynamoDBMapper$p.save(deviceInfoEntity, new DynamoDBMapperConfig(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES));
                    }
                    if (function1 != null) {
                        function1.invoke(true);
                    }
                    DebugLogUtil.INSTANCE.d("AwsManager_DynamoDBManager", "DeviceInfoEntity Success");
                } else if (function1 != null) {
                    function1.invoke(false);
                }
            } catch (DynamoDBMappingException e) {
                DebugLogUtil.INSTANCE.e("AwsManager_DynamoDBManager", "Internal error occurred dbMapping with DynamoDB");
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                String message = e.getMessage();
                debugLogUtil.d("AwsManager_DynamoDBManager", "Error Message:  " + message);
                if (function1 != null) {
                    function1.invoke(false);
                }
            } catch (AmazonServiceException e2) {
                DebugLogUtil.INSTANCE.e("AwsManager_DynamoDBManager", "Could not complete operation");
                DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
                String errorMessage = e2.getErrorMessage();
                debugLogUtil2.d("AwsManager_DynamoDBManager", "Error Message:  " + errorMessage);
                DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
                int statusCode = e2.getStatusCode();
                debugLogUtil3.d("AwsManager_DynamoDBManager", "HTTP Status:    " + statusCode);
                DebugLogUtil debugLogUtil4 = DebugLogUtil.INSTANCE;
                String errorCode = e2.getErrorCode();
                debugLogUtil4.d("AwsManager_DynamoDBManager", "AWS Error Code: " + errorCode);
                DebugLogUtil debugLogUtil5 = DebugLogUtil.INSTANCE;
                AmazonServiceException.ErrorType errorType = e2.getErrorType();
                debugLogUtil5.d("AwsManager_DynamoDBManager", "Error Type:     " + errorType);
                DebugLogUtil debugLogUtil6 = DebugLogUtil.INSTANCE;
                String requestId = e2.getRequestId();
                debugLogUtil6.d("AwsManager_DynamoDBManager", "Request ID:     " + requestId);
                if (function1 != null) {
                    function1.invoke(false);
                }
            } catch (AmazonClientException e3) {
                DebugLogUtil.INSTANCE.e("AwsManager_DynamoDBManager", "Internal error occurred communicating with DynamoDB");
                DebugLogUtil debugLogUtil7 = DebugLogUtil.INSTANCE;
                String message2 = e3.getMessage();
                debugLogUtil7.d("AwsManager_DynamoDBManager", "Error Message:  " + message2);
                if (function1 != null) {
                    function1.invoke(false);
                }
            } catch (Exception e4) {
                DebugLogUtil.INSTANCE.e("AwsManager_DynamoDBManager", "Other error occurred");
                DebugLogUtil debugLogUtil8 = DebugLogUtil.INSTANCE;
                String message3 = e4.getMessage();
                debugLogUtil8.d("AwsManager_DynamoDBManager", "Error Message:  " + message3);
                if (function1 != null) {
                    function1.invoke(false);
                }
            }
        }
    }
}
