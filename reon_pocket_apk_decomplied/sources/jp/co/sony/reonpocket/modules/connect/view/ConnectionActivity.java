package jp.co.sony.reonpocket.modules.connect.view;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.connection.log.logcat.LogCatLoggingService;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.IntentExtraConstant;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractor;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.connect.presenter.ConnectionPresenter;
import jp.co.sony.reonpocket.modules.connect.view.ConnectStartFragment;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionViewInput;
import jp.co.sony.reonpocket.modules.helpGuide.view.HelpGuideFragment;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.modules.main.view.MainActivityKt;
import jp.co.sony.reonpocket.modules.settings.view.ChangeUserInfoFragment;
import jp.co.sony.reonpocket.modules.settings.view.LegalFragment;
import jp.co.sony.reonpocket.modules.settings.view.OssContentFragment;
import jp.co.sony.reonpocket.modules.settings.view.SettingActivityKt;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.BuildVersionCode;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DialogBuilderUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.util.PermissionUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.util.RequestBLEPermissions;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.TagMiniInfoView;
import jp.co.sony.reonpocket.view.TagMiniInfoViewOutput;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import jp.co.sony.reonpocket.view.fragment.AlertDialogFragment;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\"*\u0002\u0012\u001e\b\u0007\u0018\u0000 Ü\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0006Ü\u0001Ý\u0001Þ\u0001B\u0005¢\u0006\u0002\u0010\bJ(\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010E\u001a\u00020>H\u0003J\u0010\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020\u000eH\u0002J\u0010\u0010H\u001a\u00020>2\u0006\u0010I\u001a\u00020\u000eH\u0002J\b\u0010J\u001a\u00020>H\u0002J\b\u0010K\u001a\u00020>H\u0016J0\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020D2\u0006\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020>H\u0002J\b\u0010U\u001a\u00020>H\u0016J\b\u0010V\u001a\u00020>H\u0002J\b\u0010W\u001a\u00020>H\u0002J\b\u0010X\u001a\u00020>H\u0016J\b\u0010Y\u001a\u00020>H\u0002J\b\u0010Z\u001a\u00020>H\u0016J\b\u0010[\u001a\u00020>H\u0002J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020>H\u0002J\u0012\u0010_\u001a\u00020>2\b\u0010`\u001a\u0004\u0018\u00010DH\u0002J \u0010a\u001a\u00020>2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020eH\u0017J\b\u0010g\u001a\u00020>H\u0016J\u0012\u0010h\u001a\u00020>2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u0012\u0010k\u001a\u00020>2\b\u0010l\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010m\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020oH\u0016J\u0018\u0010p\u001a\u00020>2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0016J \u0010q\u001a\u00020>2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020eH\u0016J\u0018\u0010r\u001a\u00020>2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0016J\u0010\u0010s\u001a\u00020>2\u0006\u0010t\u001a\u00020DH\u0016J\b\u0010u\u001a\u00020>H\u0016J\b\u0010v\u001a\u00020>H\u0016J\u0010\u0010w\u001a\u00020>2\u0006\u0010x\u001a\u00020yH\u0016J\b\u0010z\u001a\u00020>H\u0016J\u001a\u0010{\u001a\u00020>2\u0006\u0010|\u001a\u00020e2\b\u0010}\u001a\u0004\u0018\u00010&H\u0016J\b\u0010~\u001a\u00020>H\u0016J\u0011\u0010\u001a\u00020\u000e2\u0007\u0010x\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020>H\u0014J4\u0010\u0001\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020e2\u0010\u0010\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020D0\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020>H\u0016J\t\u0010\u0001\u001a\u00020>H\u0014J2\u0010\u0001\u001a\u00020>2\u0006\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020D2\u0006\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020DH\u0016J\t\u0010\u0001\u001a\u00020>H\u0014J1\u0010\u0001\u001a\u00020>2\u0006\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020D2\u0006\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020DH\u0016J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0016J\u0013\u0010\u0001\u001a\u00020>2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0016J\t\u0010\u0001\u001a\u00020>H\u0016J\t\u0010\u0001\u001a\u00020>H\u0016J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0016J\u0012\u0010\u0001\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020eH\u0016J\t\u0010\u0001\u001a\u00020>H\u0016J\t\u0010\u0001\u001a\u00020>H\u0002JF\u0010 \u0001\u001a\u00020>2\t\u0010¡\u0001\u001a\u0004\u0018\u00010D2\u0007\u0010¢\u0001\u001a\u00020D2\u0007\u0010£\u0001\u001a\u00020D2\u0007\u0010¤\u0001\u001a\u00020D2\t\u0010¥\u0001\u001a\u0004\u0018\u00010D2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\t\u0010¨\u0001\u001a\u00020>H\u0016J\t\u0010©\u0001\u001a\u00020>H\u0002J\u0013\u0010ª\u0001\u001a\u00020>2\b\b\u0002\u0010`\u001a\u00020DH\u0002J\u0014\u0010«\u0001\u001a\u00020>2\t\b\u0002\u0010¬\u0001\u001a\u00020\u000eH\u0002J\u0014\u0010­\u0001\u001a\u00020>2\t\b\u0002\u0010¬\u0001\u001a\u00020\u000eH\u0002J\u001d\u0010®\u0001\u001a\u00020>2\u0007\u0010¯\u0001\u001a\u00020\u000b2\t\b\u0002\u0010°\u0001\u001a\u00020\u000eH\u0002J\t\u0010±\u0001\u001a\u00020>H\u0002J\t\u0010²\u0001\u001a\u00020>H\u0002J\t\u0010³\u0001\u001a\u00020>H\u0002J\t\u0010´\u0001\u001a\u00020>H\u0016J\t\u0010µ\u0001\u001a\u00020>H\u0002J\t\u0010¶\u0001\u001a\u00020>H\u0016J\t\u0010·\u0001\u001a\u00020>H\u0016J\t\u0010¸\u0001\u001a\u00020>H\u0016J+\u0010¹\u0001\u001a\u00020>2\u0007\u0010º\u0001\u001a\u0002042\u0007\u0010»\u0001\u001a\u00020D2\u000e\u0010¼\u0001\u001a\t\u0012\u0004\u0012\u00020>0½\u0001H\u0016J\t\u0010¾\u0001\u001a\u00020>H\u0002J\t\u0010¿\u0001\u001a\u00020>H\u0016J\t\u0010À\u0001\u001a\u00020>H\u0016J$\u0010À\u0001\u001a\u00020>2\u0007\u0010Á\u0001\u001a\u00020D2\u0007\u0010º\u0001\u001a\u0002042\u0007\u0010»\u0001\u001a\u00020DH\u0016J\u001b\u0010Â\u0001\u001a\u00020>2\u0007\u0010º\u0001\u001a\u0002042\u0007\u0010»\u0001\u001a\u00020DH\u0002J\t\u0010Ã\u0001\u001a\u00020>H\u0016J\t\u0010Ä\u0001\u001a\u00020>H\u0016J\t\u0010Å\u0001\u001a\u00020>H\u0016J\t\u0010Æ\u0001\u001a\u00020>H\u0002J\u0007\u0010Ç\u0001\u001a\u00020>J\t\u0010È\u0001\u001a\u00020>H\u0002J\u0007\u0010É\u0001\u001a\u00020>J\u0013\u0010Ê\u0001\u001a\u00020>2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010&J\u0015\u0010Ë\u0001\u001a\u00020>2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010&H\u0002J\u0007\u0010Ì\u0001\u001a\u00020>J\t\u0010Í\u0001\u001a\u00020>H\u0002J\t\u0010Î\u0001\u001a\u00020>H\u0016J\t\u0010Ï\u0001\u001a\u00020>H\u0016J\t\u0010Ð\u0001\u001a\u00020>H\u0002J\u0012\u0010Ñ\u0001\u001a\u00020>2\u0007\u0010Ò\u0001\u001a\u00020eH\u0016J\u0012\u0010Ó\u0001\u001a\u00020>2\u0007\u0010Ô\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010Õ\u0001\u001a\u00020>2\u0007\u0010Ö\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010×\u0001\u001a\u00020>2\u0007\u0010Ò\u0001\u001a\u00020eH\u0016J\u001d\u0010Ø\u0001\u001a\u00020>2\u0007\u0010Ù\u0001\u001a\u00020\u000e2\t\u0010Ú\u0001\u001a\u0004\u0018\u000108H\u0016J\u001d\u0010Û\u0001\u001a\u00020>2\u0007\u0010Ù\u0001\u001a\u00020\u000e2\t\u0010Ú\u0001\u001a\u0004\u0018\u000104H\u0016R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006ß\u0001"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectionViewInput;", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectStartFragment$OnConnectStartListener;", "Ljp/co/sony/reonpocket/modules/settings/view/LegalFragment$OnLegalItemSelectListener;", "Ljp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment$OnChangeUserInfoListener;", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "Ljp/co/sony/reonpocket/view/TagMiniInfoViewOutput;", "()V", "blePermissions", "Ljava/util/ArrayList;", "Ljp/co/sony/reonpocket/util/RequestBLEPermissions;", "Lkotlin/collections/ArrayList;", "isConnecting", "", "mBleAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothStateBroadcastReceiver", "jp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$mBluetoothStateBroadcastReceiver$1", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$mBluetoothStateBroadcastReceiver$1;", "mDfuCompleteDialog", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mErrorDialog", "mHavePendingTransit", "mIsTagInfoReceiving", "mIsTagNoAmbientTemp", "mIsTagRegistered", "mLocationProviderChangedReceiver", "jp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$mLocationProviderChangedReceiver$1", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$mLocationProviderChangedReceiver$1;", "mNextBtnIsVisible", "mOptionsMenu", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$OptionsMenu;", "mOutput", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$ConnectionViewOutput;", "mPendingBundle", "Landroid/os/Bundle;", "mPercentTextView", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "mPrepareDfuDialog", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressBarDialog", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "mProgressDialog", "Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment;", "mRequestLocationDialog", "mRequestNearbyDeviceDialog", "mSettingMenuDialog", "mTagDataInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "mTagDfuCompleteDialog", "mTagDfuProgressBarDialog", "mTagInfo", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "mTagMiniInfoView", "Ljp/co/sony/reonpocket/view/TagMiniInfoView;", "mTagRegisterSuccessDialog", "mTagUnRegisterDialog", "analyticsSend", "", "aEventName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventName;", "aParamName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventParameter;", "aParam", "", "bluetoothDialogButton", "changeDescriptionState", "aIsConnecting", "changeNextBtnState", "aIsVisible", "checkBTPermission", "doDfu", "doUserInfoInit", "aGender", "aAge", "aHeight", "aWeight", "aState", "getReonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "hiddenDfuCompleteDialog", "hiddenProgress", "hiddenProgressBarDialog", "hiddenProgressDialog", "hiddenSettingMenuDialog", "hiddenTagDfuDialog", "hiddenTagDfuProgress", "hiddenTagUnRegisterDialog", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "nextShowRequestDialog", "noticeAnalyticsSend", "aMessage", "onAlertDialogSucceeded", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "", "aResultCode", "onCancelUserInfo", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDataDialogCancelled", "onDataDialogSucceeded", "onDismiss", "onFail", "aErrorMessage", "onFinishSend", "onInitUserInfo", "onLegalItemSelect", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "onNextHelpGuide", "onNextPage", "aPageId", "aBundle", "onNextStep", "onOptionsItemSelected", "Landroid/view/MenuItem;", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onReset", "onResume", "onSend", "aAddress", "onStart", "onUserInfoInit", "registerBroadcastReceivers", "requestForAppUpdate", "requestPermissionDialog", "permissionCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "scanBoundedDevice", "setActionBarTitle", "setBackPressedEvent", "showDfuComplete", "showDfuDisconnect", "showDfuFail", "showDfuFailed", "showDfuStarting", "showErrorMessage", "aStringResId", "showNoMessageProgress", "showNoMessageProgressDialog", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showProgress", "showProgressBarDialog", "showProgressDialog", "showRequestBluetoothDialog", "aIsRequestPermission", "showRequestLocationDialog", "showRequestPermissionDialog", "permission", "isSetting", "showSettingLocationDialog", "showSettingMenuDialog", "showSettingPermissionDialog", "showTagDfuComplete", "showTagDfuDialog", "showTagDfuDisconnect", "showTagDfuFail", "showTagDfuStarting", "showTagFoundDialog", "aTagInfo", "aTagModelName", "positiveCompletion", "Lkotlin/Function0;", "showTagNotFoundDialog", "showTagNotFoundPopup", "showTagRegisterDialog", "bdAddress", "showTagRegisteredDialog", "showTagRegistrationFailedDialog", "showTagUnRegisterDialog", "showTagUpdateMessage", "startTagScan", "transitToChangeUserInfo", "transitToHelpGuide", "transitToLegalFragment", "transitToMain", "transitToMainBackground", "transitToOssContentFragment", "transitToStartFragment", "tryConnectDfu", "unRegisterTagStatus", "unregisterBroadcastReceivers", "updateDfuProgress", "aProgress", "updateNoAmbientTemperature", "isNotGet", "updateNoReceiving", "isNoReceiving", "updateTagDfuProgress", "updateTagMiniInfoView", "isActive", "entity", "updateTagMiniInfoViewNoReceiving", "Companion", "ConnectionViewOutput", "OptionsMenu", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionActivity.kt */
public final class ConnectionActivity extends BaseActivity implements ConnectionViewInput, ConnectStartFragment.OnConnectStartListener, LegalFragment.OnLegalItemSelectListener, ChangeUserInfoFragment.OnChangeUserInfoListener, DataDialogFragment.Callback, TagMiniInfoViewOutput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DELAY_TIME_AFTER_DFU_COMPLETE = 3000;
    private static final String PROGRESS_DIALOG_TAG = "progress_dialog_tag";
    private ArrayList<RequestBLEPermissions> blePermissions = new ArrayList<>();
    private boolean isConnecting;
    private BluetoothAdapter mBleAdapter;
    private final ConnectionActivity$mBluetoothStateBroadcastReceiver$1 mBluetoothStateBroadcastReceiver = new ConnectionActivity$mBluetoothStateBroadcastReceiver$1(this);
    private AlertDialogFragment mDfuCompleteDialog;
    private DialogHelperUtil mDialogHelper;
    private AlertDialogFragment mErrorDialog;
    private boolean mHavePendingTransit;
    private boolean mIsTagInfoReceiving;
    private boolean mIsTagNoAmbientTemp;
    private boolean mIsTagRegistered;
    private final ConnectionActivity$mLocationProviderChangedReceiver$1 mLocationProviderChangedReceiver = new ConnectionActivity$mLocationProviderChangedReceiver$1(this);
    private boolean mNextBtnIsVisible;
    private OptionsMenu mOptionsMenu = OptionsMenu.NONE;
    /* access modifiers changed from: private */
    public ConnectionViewOutput mOutput;
    private Bundle mPendingBundle;
    /* access modifiers changed from: private */
    public CustomFontTextView mPercentTextView;
    private AlertDialogFragment mPrepareDfuDialog;
    /* access modifiers changed from: private */
    public ProgressBar mProgressBar;
    private DataDialogFragment mProgressBarDialog;
    private ProgressDialogFragment mProgressDialog;
    private AlertDialogFragment mRequestLocationDialog;
    private AlertDialogFragment mRequestNearbyDeviceDialog;
    private DataDialogFragment mSettingMenuDialog;
    private TagDataEntity mTagDataInfo;
    private AlertDialogFragment mTagDfuCompleteDialog;
    private DataDialogFragment mTagDfuProgressBarDialog;
    private NotifyTagSensorDataEntity mTagInfo;
    private TagMiniInfoView mTagMiniInfoView;
    private DataDialogFragment mTagRegisterSuccessDialog;
    private AlertDialogFragment mTagUnRegisterDialog;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\b\u0010%\u001a\u00020\u0003H&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J\b\u0010*\u001a\u00020\u0003H&J,\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u000bH&J\b\u00100\u001a\u00020\u0003H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\bH&J\b\u00103\u001a\u00020\u0003H&¨\u00064"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$ConnectionViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "connect", "", "connectDFU", "disconnect", "doForceUpdate", "getIsConnectWhenOnCreate", "", "getOnWriteSetTagControlResult", "getTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "handleSettingMenuTapItem", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "initUserInfo", "isTagRegistered", "onTagWriteFailed", "registerTag", "bdAddress", "", "entity", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "reset", "setDfuState", "aIsDfu", "Ljp/co/sony/reonpocket/modules/connect/presenter/ConnectionPresenter$DfuState;", "setSuspendReason", "aReason", "Ljp/co/sony/reonpocket/modules/connect/presenter/ConnectionPresenter$SuspendReason;", "setTagScanListener", "info", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$TagInfo;", "showNotification", "startTagDfu", "tagAlwaysScan", "tagScan", "tagScanNoReceiving", "transitToEula", "transitToOss", "transitToPrivacy", "transitToTagInfo", "isTagInfoReceiving", "isTagNoAmbientTemp", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "tagDataEntity", "unRegisterTag", "updateDialogStatus", "isShow", "writeRequestDfu", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConnectionActivity.kt */
    public interface ConnectionViewOutput extends BaseViewOutput {
        void connect();

        void connectDFU();

        void disconnect();

        void doForceUpdate();

        boolean getIsConnectWhenOnCreate();

        boolean getOnWriteSetTagControlResult();

        TagDataEntity getTagInfo();

        void handleSettingMenuTapItem(SettingItemAdapter.SettingListItem settingListItem);

        void initUserInfo();

        boolean isTagRegistered();

        void onTagWriteFailed();

        void registerTag(String str, TagDataEntity tagDataEntity);

        void registerUserInfo(UserInfoEntity userInfoEntity);

        void reset();

        void setDfuState(ConnectionPresenter.DfuState dfuState);

        void setSuspendReason(ConnectionPresenter.SuspendReason suspendReason);

        void setTagScanListener(TagScanInteractor.TagInfo tagInfo);

        void showNotification();

        void startTagDfu();

        void tagAlwaysScan();

        void tagScan();

        void tagScanNoReceiving();

        void transitToEula();

        void transitToOss();

        void transitToPrivacy();

        void transitToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity, TagDataEntity tagDataEntity);

        void unRegisterTag();

        void updateDialogStatus(boolean z);

        void writeRequestDfu();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConnectionActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|21|22|23|24|25|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
        static {
            /*
                jp.co.sony.reonpocket.constant.ReonProductType[] r0 = jp.co.sony.reonpocket.constant.ReonProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.constant.ReonProductType r2 = jp.co.sony.reonpocket.constant.ReonProductType.ORIGINAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.constant.ReonProductType r3 = jp.co.sony.reonpocket.constant.ReonProductType.PRO     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$OptionsMenu[] r0 = jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.OptionsMenu.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$OptionsMenu r3 = jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.OptionsMenu.TAG_POPUP     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$OptionsMenu r3 = jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.OptionsMenu.OK     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                $EnumSwitchMapping$1 = r0
                jp.co.sony.reonpocket.util.RequestBLEPermissions[] r0 = jp.co.sony.reonpocket.util.RequestBLEPermissions.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.util.RequestBLEPermissions r3 = jp.co.sony.reonpocket.util.RequestBLEPermissions.REQUEST_ACCESS_COARSE_LOCATION     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                jp.co.sony.reonpocket.util.RequestBLEPermissions r3 = jp.co.sony.reonpocket.util.RequestBLEPermissions.REQUEST_BLUETOOTH     // Catch:{ NoSuchFieldError -> 0x004b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                $EnumSwitchMapping$2 = r0
                jp.co.sony.reonpocket.constant.BleConnStatusCode[] r0 = jp.co.sony.reonpocket.constant.BleConnStatusCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.BleConnStatusCode r3 = jp.co.sony.reonpocket.constant.BleConnStatusCode.PERMISSION_MISS_LOCATION     // Catch:{ NoSuchFieldError -> 0x005c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r3 = jp.co.sony.reonpocket.constant.BleConnStatusCode.PERMISSION_MISS_BLUETOOTH     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                $EnumSwitchMapping$3 = r0
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem[] r0 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r3 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LICENSE     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.PRIVACY_POLICY     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.OPEN_SOURCE     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                $EnumSwitchMapping$4 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.WhenMappings.<clinit>():void");
        }
    }

    public void onDataDialogCancelled(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onDataDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onDismiss(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$Companion;", "", "()V", "DELAY_TIME_AFTER_DFU_COMPLETE", "", "PROGRESS_DIALOG_TAG", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConnectionActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$OptionsMenu;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "NONE", "TAG_POPUP", "OK", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConnectionActivity.kt */
    public enum OptionsMenu {
        NONE(R.menu.menu_tag_popup),
        TAG_POPUP(R.menu.menu_tag_popup),
        OK(R.menu.menu_ok);
        
        private final int id;

        public static EnumEntries<OptionsMenu> getEntries() {
            return $ENTRIES;
        }

        private OptionsMenu(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }

        static {
            OptionsMenu[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_connection);
        setActionBarTitle();
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((FragmentActivity) this);
        Object systemService = getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.mBleAdapter = ((BluetoothManager) systemService).getAdapter();
        if (bundle == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            beginTransaction.replace(R.id.fragment_container, ConnectStartFragment.Companion.newInstance());
            beginTransaction.commit();
            this.mOptionsMenu = OptionsMenu.TAG_POPUP;
            setActionBarTitle();
        }
        this.mTagMiniInfoView = (TagMiniInfoView) findViewById(R.id.tag_mini_info);
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        boolean isTagRegistered = connectionViewOutput != null ? connectionViewOutput.isTagRegistered() : false;
        this.mIsTagRegistered = isTagRegistered;
        TagMiniInfoView tagMiniInfoView = this.mTagMiniInfoView;
        if (tagMiniInfoView != null) {
            tagMiniInfoView.setVisibility(isTagRegistered ? 0 : 8);
        }
        TagMiniInfoView tagMiniInfoView2 = this.mTagMiniInfoView;
        if (tagMiniInfoView2 != null) {
            tagMiniInfoView2.setOnClickListener(this);
        }
        TagMiniInfoView tagMiniInfoView3 = this.mTagMiniInfoView;
        if (tagMiniInfoView3 != null) {
            tagMiniInfoView3.setOutput(this);
        }
        ConnectionViewOutput connectionViewOutput2 = this.mOutput;
        if (connectionViewOutput2 != null ? connectionViewOutput2.getIsConnectWhenOnCreate() : false) {
            checkBTPermission();
            new Bundle().putBoolean(IntentExtraConstant.FromSplash.IS_CONNECT_WHEN_ON_CREATE.getKey(), false);
        }
    }

    private final void setActionBarTitle() {
        int i = WhenMappings.$EnumSwitchMapping$0[getReonProductType().ordinal()];
        if (i == 1) {
            setToolbarTitle(R.string.connect_start_title_original);
        } else if (i == 2) {
            setToolbarTitle(R.string.connect_start_title_pro);
        }
    }

    private final ReonProductType getReonProductType() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        DeviceInfoInteractor deviceInfoInteractor = new DeviceInfoInteractor();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        String peripheralName = deviceInfoInteractor.getPeripheralName(applicationContext);
        if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_P1.getModel())) {
            return ReonProductType.PRO;
        }
        boolean z6 = true;
        if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1.getModel())) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1A.getModel());
        }
        if (z) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1L.getModel());
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_2.getModel());
        }
        if (z3) {
            z4 = true;
        } else {
            z4 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_3.getModel());
        }
        if (z4) {
            z5 = true;
        } else {
            z5 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_4.getModel());
        }
        if (!z5) {
            z6 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_5.getModel());
        }
        if (z6) {
            return ReonProductType.ORIGINAL;
        }
        DebugLogUtil.INSTANCE.e("unknown type");
        return ReonProductType.ORIGINAL;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        Bundle extras;
        String string;
        DialogHelperUtil dialogHelperUtil;
        super.onStart();
        Intent intent = getIntent();
        Unit unit = null;
        if (!(intent == null || (extras = intent.getExtras()) == null || (string = extras.getString(MainActivityKt.MAIN_ACTIVITY_ERROR_REASON)) == null)) {
            if (string.hashCode() == 48938092 && string.equals(MainPresenterKt.BUNDLE_SHUTDOWN_BY_LOW_BATTERY)) {
                DialogHelperUtil dialogHelperUtil2 = this.mDialogHelper;
                if (dialogHelperUtil2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                    dialogHelperUtil = null;
                } else {
                    dialogHelperUtil = dialogHelperUtil2;
                }
                dialogHelperUtil.showConfirmationDialog(R.string.dev_shutdown_error_title, R.string.dev_shutdown_error_description, 0, DialogHelperUtil.RequestCode.NO_REQUEST.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
                changeDescriptionState(false);
                changeNextBtnState(true);
            }
            if (string.hashCode() == 2016329595 && string.equals(SettingActivityKt.BUNDLE_BY_INITIALIZE)) {
                changeDescriptionState(false);
                changeNextBtnState(true);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ConnectionActivity connectionActivity = this;
            changeNextBtnState(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (isToolbar()) {
            getMenuInflater().inflate(this.mOptionsMenu.getId(), menu);
            setMenuIconVisibility(this.mOptionsMenu != OptionsMenu.NONE);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int i = WhenMappings.$EnumSwitchMapping$1[this.mOptionsMenu.ordinal()];
        if (i == 1) {
            showSettingMenuDialog();
        } else if (i == 2) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (findFragmentById instanceof ChangeUserInfoFragment) {
                ((ChangeUserInfoFragment) findFragmentById).sendUserInfo();
            }
        }
        if (menuItem.getItemId() == 16908332) {
            getSupportFragmentManager().popBackStack((String) null, 1);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private final void setBackPressedEvent() {
        getOnBackPressedDispatcher().addCallback(new ConnectionActivity$setBackPressedEvent$callback$1(this));
    }

    public void onClick(View view) {
        ConnectionViewOutput connectionViewOutput;
        super.onClick(view);
        if (view != null) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (findFragmentById instanceof LegalFragment) {
                transitToStartFragment();
            } else if (findFragmentById instanceof ChangeUserInfoFragment) {
                transitToStartFragment();
            } else if (findFragmentById instanceof OssContentFragment) {
                getSupportFragmentManager().popBackStack();
                setMenuIconVisibility(false);
            } else if (findFragmentById instanceof HelpGuideFragment) {
                getSupportFragmentManager().popBackStack();
                setNavigationIconStatus(false);
                ActionBar mActionBar = getMActionBar();
                if (mActionBar != null) {
                    mActionBar.setDisplayShowTitleEnabled(true);
                }
                setActionBarTitle();
            } else if (view.getId() == R.id.tag_mini_info && (connectionViewOutput = this.mOutput) != null) {
                connectionViewOutput.transitToTagInfo(this.mIsTagInfoReceiving, this.mIsTagNoAmbientTemp, this.mTagInfo, this.mTagDataInfo);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.mHavePendingTransit) {
            transitToMainBackground(this.mPendingBundle);
        }
        registerBroadcastReceivers();
        if (this.mIsTagRegistered) {
            ConnectionViewOutput connectionViewOutput = this.mOutput;
            if (connectionViewOutput != null) {
                connectionViewOutput.tagScanNoReceiving();
                return;
            }
            return;
        }
        ConnectionViewOutput connectionViewOutput2 = this.mOutput;
        if (connectionViewOutput2 != null) {
            connectionViewOutput2.tagAlwaysScan();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        unregisterBroadcastReceivers();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: jp.co.sony.reonpocket.util.RequestBLEPermissions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: jp.co.sony.reonpocket.util.RequestBLEPermissions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: jp.co.sony.reonpocket.util.RequestBLEPermissions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: jp.co.sony.reonpocket.util.RequestBLEPermissions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: jp.co.sony.reonpocket.util.RequestBLEPermissions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: jp.co.sony.reonpocket.util.RequestBLEPermissions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: jp.co.sony.reonpocket.util.RequestBLEPermissions} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int r5, java.lang.String[] r6, int[] r7) {
        /*
            r4 = this;
            java.lang.String r0 = "permissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "grantResults"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            super.onRequestPermissionsResult(r5, r6, r7)
            java.util.ArrayList<jp.co.sony.reonpocket.util.RequestBLEPermissions> r0 = r4.blePermissions
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x004f
            kotlin.enums.EnumEntries r7 = jp.co.sony.reonpocket.util.RequestBLEPermissions.getEntries()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0025:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0039
            java.lang.Object r0 = r7.next()
            r1 = r0
            jp.co.sony.reonpocket.util.RequestBLEPermissions r1 = (jp.co.sony.reonpocket.util.RequestBLEPermissions) r1
            int r1 = r1.getCode()
            if (r1 != r5) goto L_0x0025
            r2 = r0
        L_0x0039:
            jp.co.sony.reonpocket.util.RequestBLEPermissions r2 = (jp.co.sony.reonpocket.util.RequestBLEPermissions) r2
            if (r2 == 0) goto L_0x004b
            r5 = r6[r3]
            boolean r5 = r4.shouldShowRequestPermissionRationale(r5)
            if (r5 == 0) goto L_0x004b
            r5 = r4
            android.content.Context r5 = (android.content.Context) r5
            r2.markPermissionRequested(r5)
        L_0x004b:
            r4.nextShowRequestDialog()
            return
        L_0x004f:
            int r6 = r7.length
            if (r6 != 0) goto L_0x0054
            r6 = r1
            goto L_0x0055
        L_0x0054:
            r6 = r3
        L_0x0055:
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x0077
            r6 = r7[r3]
            if (r6 != 0) goto L_0x0077
            jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$onRequestPermissionsResult$3 r5 = jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$onRequestPermissionsResult$3.INSTANCE
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r4.checkBTConnect(r5)
            boolean r5 = r4.mNextBtnIsVisible
            if (r5 == 0) goto L_0x0068
            return
        L_0x0068:
            r4.changeNextBtnState(r1)
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLoggingService$Companion r5 = jp.co.sony.reonpocket.connection.log.logcat.LogCatLoggingService.Companion
            r6 = r4
            android.content.Context r6 = (android.content.Context) r6
            r5.startService(r6)
            r4.scanBoundedDevice()
            goto L_0x00a4
        L_0x0077:
            kotlin.enums.EnumEntries r6 = jp.co.sony.reonpocket.util.RequestBLEPermissions.getEntries()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x0081:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0095
            java.lang.Object r7 = r6.next()
            r0 = r7
            jp.co.sony.reonpocket.util.RequestBLEPermissions r0 = (jp.co.sony.reonpocket.util.RequestBLEPermissions) r0
            int r0 = r0.getCode()
            if (r0 != r5) goto L_0x0081
            r2 = r7
        L_0x0095:
            jp.co.sony.reonpocket.util.RequestBLEPermissions r2 = (jp.co.sony.reonpocket.util.RequestBLEPermissions) r2
            if (r2 != 0) goto L_0x009a
            return
        L_0x009a:
            jp.co.sony.reonpocket.util.DebugLogUtil r5 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r6 = "Location permission is refused, app is finish!"
            r5.e(r6)
            r4.showRequestPermissionDialog(r2, r3)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    public void onAlertDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        ConnectionViewOutput connectionViewOutput;
        DialogHelperUtil dialogHelperUtil;
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
        super.onAlertDialogSucceeded(baseDialogFragment, i, i2);
        if (i == DialogHelperUtil.RequestCode.BLUETOOTH_NOT_SETTING.ordinal()) {
            if (i2 == -2) {
                changeNextBtnState(true);
            } else if (i2 == -1) {
                bluetoothDialogButton();
            }
        } else if (i == DialogHelperUtil.RequestCode.LOCATION_NOT_SETTING.ordinal()) {
            if (i2 == -2) {
                startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } else if (i2 == -1) {
                onReset();
            }
        } else if (i == DialogHelperUtil.RequestCode.CONNECT_FAILED.ordinal()) {
            if (i2 == -2) {
                this.isConnecting = false;
                changeDescriptionState(false);
                changeNextBtnState(true);
                return;
            }
            onReset();
        } else if (i == DialogHelperUtil.RequestCode.CONFIRM_DFU.ordinal()) {
            DialogHelperUtil dialogHelperUtil2 = this.mDialogHelper;
            if (dialogHelperUtil2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil = null;
            } else {
                dialogHelperUtil = dialogHelperUtil2;
            }
            this.mPrepareDfuDialog = dialogHelperUtil.showConfirmationDialog(R.string.setting_dfu_start_subtitle_2, R.string.setting_dfu_start_description_2, 0, DialogHelperUtil.RequestCode.REQUEST_DFU.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
        } else if (i == DialogHelperUtil.RequestCode.REQUEST_DFU.ordinal()) {
            this.isConnecting = false;
            changeDescriptionState(true);
            changeNextBtnState(false);
            AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.FIRMWARE_UPDATE_START, AnalyticsUtil.EventParameter.FW_VERSION, UpdateVersionConstant.REON_FIRMWARE_VERSION);
            ConnectionViewOutput connectionViewOutput2 = this.mOutput;
            if (connectionViewOutput2 != null) {
                connectionViewOutput2.writeRequestDfu();
            }
        } else if (i == DialogHelperUtil.RequestCode.DFU_COMPLETE.ordinal()) {
            ConnectionViewInput.DefaultImpls.onNextPage$default(this, ConnectionPresenter.NextPage.CONNECTION_GOING_AFTER_DFU.ordinal(), (Bundle) null, 2, (Object) null);
        } else if (i == DialogHelperUtil.RequestCode.FORCE_UPDATE.ordinal()) {
            ConnectionViewOutput connectionViewOutput3 = this.mOutput;
            if (connectionViewOutput3 != null) {
                connectionViewOutput3.setSuspendReason(ConnectionPresenter.SuspendReason.NONE);
            }
            ConnectionViewOutput connectionViewOutput4 = this.mOutput;
            if (connectionViewOutput4 != null) {
                connectionViewOutput4.doForceUpdate();
            }
        } else if (i == DialogHelperUtil.RequestCode.REQUEST_LOCATION.ordinal()) {
            ActivityCompat.requestPermissions(this, BuildVersionCode.Companion.getNowBuildVersionCodeType().getRequestLocationPermissionList(), RequestBLEPermissions.REQUEST_ACCESS_COARSE_LOCATION.getCode());
        } else if (i == DialogHelperUtil.RequestCode.SETTING_LOCATION.ordinal()) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivity(intent);
        } else if (i == DialogHelperUtil.RequestCode.REQUEST_NEARBY_DEVICES.ordinal()) {
            ActivityCompat.requestPermissions(this, BuildVersionCode.Companion.getNowBuildVersionCodeType().getRequestBluetoothPermissionList(), RequestBLEPermissions.REQUEST_BLUETOOTH.getCode());
        } else if (i == DialogHelperUtil.RequestCode.TAG_UNREGISTER.ordinal()) {
            if (i2 == -1) {
                ConnectionViewOutput connectionViewOutput5 = this.mOutput;
                if (connectionViewOutput5 != null) {
                    connectionViewOutput5.unRegisterTag();
                }
                hiddenTagUnRegisterDialog();
                hiddenSettingMenuDialog();
                updateTagMiniInfoView(false, (NotifyTagSensorDataEntity) null);
                return;
            }
            hiddenTagUnRegisterDialog();
        } else if (i == DialogHelperUtil.RequestCode.TAG_DFU_COMPLETE.ordinal()) {
            ConnectionViewOutput connectionViewOutput6 = this.mOutput;
            if (connectionViewOutput6 != null) {
                connectionViewOutput6.tagScanNoReceiving();
            }
        } else if (i == DialogHelperUtil.RequestCode.TAG_DFU_FAILED.ordinal() && (connectionViewOutput = this.mOutput) != null) {
            connectionViewOutput.tagAlwaysScan();
        }
    }

    private final void bluetoothDialogButton() {
        if (Build.VERSION.SDK_INT < 32) {
            BluetoothAdapter bluetoothAdapter = this.mBleAdapter;
            if (!(bluetoothAdapter != null ? bluetoothAdapter.enable() : false)) {
                new Handler(Looper.getMainLooper()).postDelayed(new ConnectionActivity$$ExternalSyntheticLambda2(this), DELAY_TIME_AFTER_DFU_COMPLETE);
            }
            this.isConnecting = false;
            changeDescriptionState(false);
            changeNextBtnState(true);
            return;
        }
        startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
        this.isConnecting = false;
        changeDescriptionState(false);
        changeNextBtnState(true);
    }

    /* access modifiers changed from: private */
    public static final void bluetoothDialogButton$lambda$6(ConnectionActivity connectionActivity) {
        Intrinsics.checkNotNullParameter(connectionActivity, "this$0");
        connectionActivity.checkBTConnect(ConnectionActivity$bluetoothDialogButton$1$1.INSTANCE);
        LogCatLoggingService.Companion.startService(connectionActivity);
        connectionActivity.scanBoundedDevice();
    }

    static /* synthetic */ void showRequestLocationDialog$default(ConnectionActivity connectionActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        connectionActivity.showRequestLocationDialog(z);
    }

    private final void showRequestLocationDialog(boolean z) {
        int i;
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DialogHelperUtil dialogHelperUtil2 = dialogHelperUtil;
        int i2 = R.string.setting_location_access_permission_reason;
        if (z) {
            i = DialogHelperUtil.RequestCode.REQUEST_LOCATION.ordinal();
        } else {
            i = DialogHelperUtil.RequestCode.SETTING_LOCATION.ordinal();
        }
        this.mRequestLocationDialog = dialogHelperUtil2.showConfirmationDialog(0, i2, 0, i, Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    private final void showSettingLocationDialog() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        this.mRequestLocationDialog = dialogHelperUtil.showConfirmationDialog(0, R.string.setting_request_location_access_permission, 0, DialogHelperUtil.RequestCode.SETTING_LOCATION.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    static /* synthetic */ void showRequestBluetoothDialog$default(ConnectionActivity connectionActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        connectionActivity.showRequestBluetoothDialog(z);
    }

    private final void showRequestBluetoothDialog(boolean z) {
        int i;
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DialogHelperUtil dialogHelperUtil2 = dialogHelperUtil;
        int i2 = R.string.setting_request_nearby_devices_access_permission;
        if (z) {
            i = DialogHelperUtil.RequestCode.REQUEST_NEARBY_DEVICES.ordinal();
        } else {
            i = DialogHelperUtil.RequestCode.SETTING_LOCATION.ordinal();
        }
        this.mRequestLocationDialog = dialogHelperUtil2.showConfirmationDialog(0, i2, 0, i, Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    private final void showSettingPermissionDialog() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        this.mRequestLocationDialog = dialogHelperUtil.showConfirmationDialog(0, R.string.setting_request_location_access_permission, 0, DialogHelperUtil.RequestCode.SETTING_LOCATION.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    /* access modifiers changed from: private */
    public final void checkBTPermission() {
        this.blePermissions = RequestBLEPermissions.Companion.isNotGrantedArray(this);
        changeNextBtnState(true);
        if (this.blePermissions.isEmpty()) {
            checkBTConnect(new ConnectionActivity$checkBTPermission$1(this));
        } else {
            nextShowRequestDialog();
        }
    }

    private final void nextShowRequestDialog() {
        if (!this.blePermissions.isEmpty()) {
            RequestBLEPermissions requestBLEPermissions = (RequestBLEPermissions) CollectionsKt.first(this.blePermissions);
            if (!this.blePermissions.isEmpty()) {
                this.blePermissions.remove(requestBLEPermissions);
            }
            showRequestPermissionDialog$default(this, requestBLEPermissions, false, 2, (Object) null);
        }
    }

    static /* synthetic */ void showRequestPermissionDialog$default(ConnectionActivity connectionActivity, RequestBLEPermissions requestBLEPermissions, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        connectionActivity.showRequestPermissionDialog(requestBLEPermissions, z);
    }

    private final void showRequestPermissionDialog(RequestBLEPermissions requestBLEPermissions, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$2[requestBLEPermissions.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (requestBLEPermissions.isPermissionDeniedForever(this)) {
                    showRequestBluetoothDialog(false);
                } else {
                    showRequestBluetoothDialog(z);
                }
            }
        } else if (requestBLEPermissions.isPermissionDeniedForever(this)) {
            showSettingLocationDialog();
        } else {
            showRequestLocationDialog(z);
        }
    }

    private final void showSettingMenuDialog() {
        this.mSettingMenuDialog = DialogBuilderUtil.INSTANCE.showSettingMenuDialog(this, new ConnectionActivity$showSettingMenuDialog$1(this));
    }

    private final void showTagNotFoundDialog() {
        DialogBuilderUtil.INSTANCE.showTagNotFoundDialog(this, new ConnectionActivity$showTagNotFoundDialog$1(this));
    }

    /* access modifiers changed from: private */
    public final void showTagRegisteredDialog(TagDataEntity tagDataEntity, String str) {
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        if (connectionViewOutput != null) {
            connectionViewOutput.updateDialogStatus(true);
        }
        this.mTagRegisterSuccessDialog = DialogBuilderUtil.INSTANCE.showTagRegisteredDialog(this, tagDataEntity, str, new ConnectionActivity$showTagRegisteredDialog$1(this));
        if (tagDataEntity.getFwVersionCode() < Integer.parseInt(UpdateVersionConstant.TAG_FIRMWARE_VERSION_CODE)) {
            tagDataEntity.getFwVersionCode();
        }
    }

    /* access modifiers changed from: private */
    public final void startTagScan() {
        ConnectionViewOutput connectionViewOutput;
        ConnectionViewOutput connectionViewOutput2 = this.mOutput;
        boolean isTagRegistered = connectionViewOutput2 != null ? connectionViewOutput2.isTagRegistered() : false;
        this.mIsTagRegistered = isTagRegistered;
        updateTagMiniInfoView(isTagRegistered, this.mTagInfo);
        if (this.mIsTagRegistered && (connectionViewOutput = this.mOutput) != null) {
            connectionViewOutput.tagScanNoReceiving();
        }
    }

    public void showTagRegistrationFailedDialog() {
        DialogBuilderUtil.INSTANCE.showTagRegistrationFailedDialog(this, new ConnectionActivity$showTagRegistrationFailedDialog$1(this));
    }

    /* access modifiers changed from: private */
    public final void scanBoundedDevice() {
        if (!this.isConnecting) {
            ConnectionViewInput.DefaultImpls.onNextPage$default(this, ConnectionPresenter.NextPage.CONNECTION_GOING.ordinal(), (Bundle) null, 2, (Object) null);
        }
    }

    private final void registerBroadcastReceivers() {
        if (Build.VERSION.SDK_INT >= 33) {
            Intent unused = registerReceiver(this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), 4);
        } else {
            registerReceiver(this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        registerReceiver(this.mLocationProviderChangedReceiver, new IntentFilter("android.location.MODE_CHANGED"));
    }

    private final void unregisterBroadcastReceivers() {
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        unregisterReceiver(this.mLocationProviderChangedReceiver);
    }

    static /* synthetic */ void showProgressDialog$default(ConnectionActivity connectionActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectionActivity.getString(R.string.connect_on_going_title);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        connectionActivity.showProgressDialog(str);
    }

    /* access modifiers changed from: private */
    public final void showProgressDialog(String str) {
        hideErrorDialog();
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DialogInterface showProgressDialog = dialogHelperUtil.showProgressDialog(str, "progress_dialog_tag", false);
        Intrinsics.checkNotNull(showProgressDialog, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment");
        this.mProgressDialog = (ProgressDialogFragment) showProgressDialog;
    }

    private final void showProgressBarDialog() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DataDialogFragment showDataDialog = dialogHelperUtil.showDataDialog(R.string.setting_dfu_on_going_subtitle, BaseDialogFragment.Builder.DialogType.PROGRESS, DialogHelperUtil.RequestCode.DIALOG_DURATION.ordinal(), 0, 0, R.string.setting_dfu_on_going_description);
        this.mProgressBarDialog = showDataDialog;
        Intrinsics.checkNotNull(showDataDialog);
        showDataDialog.setLifecycleListener(new ConnectionActivity$showProgressBarDialog$1(this));
    }

    private final void showNoMessageProgressDialog() {
        showProgressDialog("");
    }

    /* access modifiers changed from: private */
    public final void hiddenProgressDialog() {
        Dialog dialog;
        ProgressDialogFragment progressDialogFragment = this.mProgressDialog;
        if (progressDialogFragment != null && (dialog = progressDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    private final void hiddenProgressBarDialog() {
        Dialog dialog;
        DataDialogFragment dataDialogFragment = this.mProgressBarDialog;
        if (dataDialogFragment != null && (dialog = dataDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    private final void hiddenDfuCompleteDialog() {
        Dialog dialog;
        AlertDialogFragment alertDialogFragment = this.mDfuCompleteDialog;
        if (alertDialogFragment != null && (dialog = alertDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    private final void hiddenTagUnRegisterDialog() {
        Dialog dialog;
        AlertDialogFragment alertDialogFragment = this.mTagUnRegisterDialog;
        if (alertDialogFragment != null && (dialog = alertDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    private final void changeNextBtnState(boolean z) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof ConnectStartFragment) {
            ConnectStartFragment connectStartFragment = (ConnectStartFragment) findFragmentById;
            if (connectStartFragment.currentNextBtnState() != z) {
                connectStartFragment.changeNextBtnState(z);
            } else {
                return;
            }
        }
        this.mNextBtnIsVisible = z;
    }

    private final void changeDescriptionState(boolean z) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof ConnectStartFragment) {
            ((ConnectStartFragment) findFragmentById).changeDescriptionState(z);
        }
        this.mNextBtnIsVisible = z;
    }

    private final void transitToStartFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            setToolbarTitle(R.string.pairing_start_title);
            this.mOptionsMenu = OptionsMenu.TAG_POPUP;
            setMenuIconVisibility(true);
            getSupportFragmentManager().popBackStack((String) null, 1);
            setNavigationIconStatus(false);
            setActionBarTitle();
            invalidateOptionsMenu();
        }
    }

    private final void showTagDfuDialog() {
        this.mTagDfuProgressBarDialog = DialogBuilderUtil.INSTANCE.showTagFwUpdateProgressDialog(this, new ConnectionActivity$showTagDfuDialog$1(this));
    }

    private final void hiddenTagDfuDialog() {
        Dialog dialog;
        DataDialogFragment dataDialogFragment = this.mTagDfuProgressBarDialog;
        if (dataDialogFragment != null && (dialog = dataDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    private final void showDfuFailed() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(R.string.tag_error_update_title, R.string.tag_error_update_description, 0, DialogHelperUtil.RequestCode.TAG_DFU_FAILED.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    public final void transitToLegalFragment() {
        setToolbarTitle(R.string.setting_top_legal);
        setNavigationIcon(R.drawable.ic_back, this);
        TransitionSet transitionSet = new TransitionSet();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        transitionSet.addTransition(slide);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.addToBackStack((String) null);
        LegalFragment newInstance = LegalFragment.Companion.newInstance();
        newInstance.setEnterTransition(transitionSet);
        beginTransaction.replace(R.id.fragment_container, newInstance);
        beginTransaction.commit();
        invalidateOptionsMenu();
        this.mOptionsMenu = OptionsMenu.NONE;
    }

    public final void transitToChangeUserInfo() {
        setToolbarTitle(R.string.user_info_title);
        setNavigationIcon(R.drawable.ic_back, this);
        TransitionSet transitionSet = new TransitionSet();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        transitionSet.addTransition(slide);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.addToBackStack((String) null);
        ChangeUserInfoFragment newInstance = ChangeUserInfoFragment.Companion.newInstance();
        newInstance.setEnterTransition(transitionSet);
        beginTransaction.replace(R.id.fragment_container, newInstance);
        beginTransaction.commit();
        invalidateOptionsMenu();
        this.mOptionsMenu = OptionsMenu.OK;
    }

    public final void transitToOssContentFragment() {
        setToolbarTitle(R.string.setting_top_license);
        TransitionSet transitionSet = new TransitionSet();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        transitionSet.addTransition(slide);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.addToBackStack((String) null);
        OssContentFragment newInstance = OssContentFragment.Companion.newInstance();
        newInstance.setEnterTransition(transitionSet);
        beginTransaction.replace(R.id.fragment_container, newInstance);
        beginTransaction.commit();
        invalidateOptionsMenu();
        this.mOptionsMenu = OptionsMenu.NONE;
    }

    private final void doUserInfoInit(String str, String str2, String str3, String str4, String str5) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof ChangeUserInfoFragment) {
            ((ChangeUserInfoFragment) findFragmentById).doInitDataSetting(str, str2, str3, str4, str5);
        }
    }

    static /* synthetic */ void analyticsSend$default(ConnectionActivity connectionActivity, AnalyticsUtil.EventName eventName, AnalyticsUtil.EventParameter eventParameter, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            eventParameter = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        connectionActivity.analyticsSend(eventName, eventParameter, str);
    }

    private final void analyticsSend(AnalyticsUtil.EventName eventName, AnalyticsUtil.EventParameter eventParameter, String str) {
        AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), eventName, eventParameter, str);
    }

    /* access modifiers changed from: private */
    public final void noticeAnalyticsSend(String str) {
        analyticsSend(AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, str);
    }

    public BaseViewOutput initPresenter() {
        ConnectionViewOutput connectionPresenter = new ConnectionPresenter(this, this, getMFirebaseAnalytics());
        this.mOutput = connectionPresenter;
        Intrinsics.checkNotNull(connectionPresenter, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.connect.presenter.ConnectionPresenter");
        return (ConnectionPresenter) connectionPresenter;
    }

    public void onNextStep() {
        Context context = this;
        if (!RequestBLEPermissions.Companion.isAllRequestPermission(context)) {
            checkBTPermission();
            return;
        }
        PermissionUtil permissionUtil = PermissionUtil.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (!permissionUtil.isBleEnabled(applicationContext)) {
            checkBTConnect(ConnectionActivity$onNextStep$1.INSTANCE);
            return;
        }
        PermissionUtil permissionUtil2 = PermissionUtil.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        if (!permissionUtil2.isLocationEnabled(applicationContext2)) {
            showLocationPermissionCheckDialog();
            return;
        }
        LogCatLoggingService.Companion.startService(context);
        scanBoundedDevice();
    }

    public void onReset() {
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        if (connectionViewOutput != null) {
            connectionViewOutput.reset();
        }
    }

    public void onNextHelpGuide() {
        transitToHelpGuide();
    }

    public void onFail(String str) {
        ConnectionViewOutput connectionViewOutput;
        Intrinsics.checkNotNullParameter(str, "aErrorMessage");
        hiddenDfuCompleteDialog();
        hiddenProgressDialog();
        hiddenProgressBarDialog();
        showErrorDialog(str);
        this.isConnecting = false;
        changeDescriptionState(false);
        changeNextBtnState(true);
        if (this.mIsTagRegistered && (connectionViewOutput = this.mOutput) != null) {
            connectionViewOutput.tagScanNoReceiving();
        }
    }

    public void onNextPage(int i, Bundle bundle) {
        DialogHelperUtil dialogHelperUtil;
        DialogHelperUtil dialogHelperUtil2;
        if (i == ConnectionPresenter.NextPage.CONNECTION_GOING.ordinal() || i == ConnectionPresenter.NextPage.CONNECTION_GOING_AFTER_DFU.ordinal()) {
            this.isConnecting = true;
            changeDescriptionState(true);
            showProgressDialog$default(this, (String) null, 1, (Object) null);
            AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.BLE_RECONNECT_START, (Bundle) null, 8, (Object) null);
            if (i == ConnectionPresenter.NextPage.CONNECTION_GOING.ordinal()) {
                ConnectionViewOutput connectionViewOutput = this.mOutput;
                if (connectionViewOutput != null) {
                    connectionViewOutput.connect();
                    return;
                }
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new ConnectionActivity$$ExternalSyntheticLambda1(this), DELAY_TIME_AFTER_DFU_COMPLETE);
        } else if (i == ConnectionPresenter.NextPage.DFU_START.ordinal()) {
            hiddenProgressDialog();
            DialogHelperUtil dialogHelperUtil3 = this.mDialogHelper;
            if (dialogHelperUtil3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil2 = null;
            } else {
                dialogHelperUtil2 = dialogHelperUtil3;
            }
            this.mPrepareDfuDialog = dialogHelperUtil2.showConfirmationDialog(R.string.setting_dfu_start_subtitle, R.string.setting_dfu_start_description, 0, DialogHelperUtil.RequestCode.CONFIRM_DFU.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
        } else if (i == ConnectionPresenter.NextPage.DFU_GOING.ordinal()) {
            hiddenProgressDialog();
            hideErrorDialog();
            showProgressBarDialog();
        } else if (i != ConnectionPresenter.NextPage.MAIN.ordinal() && i == ConnectionPresenter.NextPage.DFU_COMPLETE.ordinal()) {
            hiddenProgressBarDialog();
            DialogHelperUtil dialogHelperUtil4 = this.mDialogHelper;
            if (dialogHelperUtil4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil = null;
            } else {
                dialogHelperUtil = dialogHelperUtil4;
            }
            this.mDfuCompleteDialog = dialogHelperUtil.showConfirmationDialog(R.string.setting_complete_message, 0, 0, DialogHelperUtil.RequestCode.DFU_COMPLETE.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
        }
    }

    /* access modifiers changed from: private */
    public static final void onNextPage$lambda$7(ConnectionActivity connectionActivity) {
        Intrinsics.checkNotNullParameter(connectionActivity, "this$0");
        ConnectionViewOutput connectionViewOutput = connectionActivity.mOutput;
        if (connectionViewOutput != null) {
            connectionViewOutput.connect();
        }
    }

    public void doDfu() {
        this.isConnecting = true;
        changeDescriptionState(true);
        showProgressDialog$default(this, (String) null, 1, (Object) null);
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        if (connectionViewOutput != null) {
            connectionViewOutput.connectDFU();
        }
    }

    public void tryConnectDfu() {
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        if (connectionViewOutput != null) {
            connectionViewOutput.connectDFU();
        }
    }

    public void requestForAppUpdate() {
        hiddenProgressDialog();
        this.isConnecting = false;
        changeDescriptionState(false);
        changeNextBtnState(true);
        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SHOW_APP_UPDATE, (Bundle) null, 8, (Object) null);
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(R.string.setting_app_update_requirement_title, R.string.setting_app_update_requirement_description, 0, DialogHelperUtil.RequestCode.FORCE_UPDATE.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    public static /* synthetic */ void transitToMain$default(ConnectionActivity connectionActivity, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            bundle = null;
        }
        connectionActivity.transitToMain(bundle);
    }

    public final void transitToMain(Bundle bundle) {
        hiddenProgressDialog();
        this.mHavePendingTransit = true;
        this.mPendingBundle = bundle;
        if (isAppOnForeground()) {
            Context context = this;
            Intent intent = new Intent(context, MainActivity.class);
            if (bundle != null) {
                bundle.putString(MainActivityKt.TRANSIT_PARENT, getClass().getSimpleName());
                intent.putExtras(bundle);
            }
            AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, context, getMFirebaseAnalytics(), AnalyticsUtil.EventName.BLE_CONNECT_COMPLETE, (Bundle) null, 8, (Object) null);
            startActivity(intent);
            finish();
        }
    }

    static /* synthetic */ void transitToMainBackground$default(ConnectionActivity connectionActivity, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            bundle = null;
        }
        connectionActivity.transitToMainBackground(bundle);
    }

    private final void transitToMainBackground(Bundle bundle) {
        Context context = this;
        Intent intent = new Intent(context, MainActivity.class);
        if (bundle != null) {
            bundle.putString(MainActivityKt.TRANSIT_PARENT, getClass().getSimpleName());
            intent.putExtras(bundle);
        }
        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, context, getMFirebaseAnalytics(), AnalyticsUtil.EventName.BLE_CONNECT_COMPLETE, (Bundle) null, 8, (Object) null);
        startActivity(intent);
        finish();
    }

    private final void transitToHelpGuide() {
        HelpGuideFragment newInstance = HelpGuideFragment.Companion.newInstance(getReonProductType());
        ActionBar mActionBar = getMActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayShowTitleEnabled(false);
        }
        setBackPressedEvent();
        setNavigationIcon(R.drawable.ic_close, this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, newInstance).addToBackStack((String) null).commit();
    }

    public void showDfuComplete() {
        hiddenProgressBarDialog();
    }

    public void showDfuDisconnect() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
    }

    public void showDfuFail() {
        hiddenProgressBarDialog();
        changeDescriptionState(false);
        changeNextBtnState(true);
    }

    public void showDfuStarting() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
    }

    public void updateDfuProgress(int i) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        ProgressBar progressBar2 = this.mProgressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(i);
        }
        CustomFontTextView customFontTextView = this.mPercentTextView;
        if (customFontTextView != null) {
            customFontTextView.setText(getString(R.string.setting_dfu_on_going_percent, new Object[]{Integer.valueOf(i)}));
        }
    }

    public void requestPermissionDialog(BleConnStatusCode bleConnStatusCode) {
        Intrinsics.checkNotNullParameter(bleConnStatusCode, "permissionCode");
        new Handler(Looper.getMainLooper()).postDelayed(new ConnectionActivity$$ExternalSyntheticLambda3(this, bleConnStatusCode), 300);
    }

    /* access modifiers changed from: private */
    public static final void requestPermissionDialog$lambda$12(ConnectionActivity connectionActivity, BleConnStatusCode bleConnStatusCode) {
        Unit unit;
        Dialog dialog;
        Intrinsics.checkNotNullParameter(connectionActivity, "this$0");
        Intrinsics.checkNotNullParameter(bleConnStatusCode, "$permissionCode");
        connectionActivity.hiddenProgressDialog();
        connectionActivity.isConnecting = false;
        connectionActivity.changeDescriptionState(false);
        connectionActivity.changeNextBtnState(true);
        AlertDialogFragment alertDialogFragment = connectionActivity.mRequestNearbyDeviceDialog;
        if (alertDialogFragment == null || (dialog = alertDialogFragment.getDialog()) == null) {
            unit = null;
        } else {
            dialog.show();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            int i = WhenMappings.$EnumSwitchMapping$3[bleConnStatusCode.ordinal()];
            if (i == 1) {
                showRequestLocationDialog$default(connectionActivity, false, 1, (Object) null);
            } else if (i != 2) {
                connectionActivity.showSettingPermissionDialog();
            } else {
                showRequestBluetoothDialog$default(connectionActivity, false, 1, (Object) null);
            }
        }
    }

    public void hiddenSettingMenuDialog() {
        Dialog dialog;
        DataDialogFragment dataDialogFragment = this.mSettingMenuDialog;
        if (dataDialogFragment != null && (dialog = dataDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void onUserInfoInit(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "aGender");
        Intrinsics.checkNotNullParameter(str2, "aAge");
        Intrinsics.checkNotNullParameter(str3, "aHeight");
        Intrinsics.checkNotNullParameter(str4, "aWeight");
        Intrinsics.checkNotNullParameter(str5, "aState");
        doUserInfoInit(str, str2, str3, str4, str5);
    }

    public void onFinishSend() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ChangeUserInfoFragment) {
            transitToStartFragment();
            invalidateOptionsMenu();
        }
        hiddenProgressDialog();
    }

    public void showProgress() {
        showProgressDialog$default(this, (String) null, 1, (Object) null);
    }

    public void showNoMessageProgress() {
        showNoMessageProgressDialog();
    }

    public void showErrorMessage(int i) {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(i, 0, 0, DialogHelperUtil.RequestCode.NO_REQUEST.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    public void showTagRegisterDialog() {
        DialogBuilderUtil.INSTANCE.showTagRegisterDialog(this, new ConnectionActivity$showTagRegisterDialog$1(this));
    }

    public void hiddenProgress() {
        hiddenProgressDialog();
    }

    public void hiddenTagDfuProgress() {
        hiddenTagDfuDialog();
    }

    public void showTagNotFoundPopup() {
        showTagNotFoundDialog();
    }

    public void showTagFoundDialog(TagDataEntity tagDataEntity, String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(tagDataEntity, "aTagInfo");
        Intrinsics.checkNotNullParameter(str, "aTagModelName");
        Intrinsics.checkNotNullParameter(function0, "positiveCompletion");
        DialogBuilderUtil.INSTANCE.showTagFoundDialog(this, tagDataEntity, str, new ConnectionActivity$showTagFoundDialog$1(function0, this, tagDataEntity, str));
    }

    public void showTagUnRegisterDialog() {
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        DialogBuilderUtil.INSTANCE.showTagUnRegisterDialog(this, connectionViewOutput != null ? connectionViewOutput.getTagInfo() : null, new ConnectionActivity$showTagUnRegisterDialog$1(this));
    }

    public void unRegisterTagStatus() {
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        if (connectionViewOutput != null) {
            connectionViewOutput.unRegisterTag();
        }
        updateTagMiniInfoView(false, (NotifyTagSensorDataEntity) null);
    }

    public void showTagRegisterDialog(String str, TagDataEntity tagDataEntity, String str2) {
        Intrinsics.checkNotNullParameter(str, "bdAddress");
        Intrinsics.checkNotNullParameter(tagDataEntity, "aTagInfo");
        Intrinsics.checkNotNullParameter(str2, "aTagModelName");
        DialogBuilderUtil.INSTANCE.showTagFoundDialog(this, tagDataEntity, str2, new ConnectionActivity$showTagRegisterDialog$2(this, str, tagDataEntity, str2));
    }

    public void showNotification(String str, String str2, String str3, String str4, String str5, Bitmap bitmap) {
        String str6;
        DialogHelperUtil dialogHelperUtil;
        DialogHelperUtil dialogHelperUtil2;
        String str7 = str;
        Intrinsics.checkNotNullParameter(str2, "aTitle");
        Intrinsics.checkNotNullParameter(str3, "aSubtitle");
        Intrinsics.checkNotNullParameter(str4, "aDescription");
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity == null || (str6 = Integer.valueOf(mNotificationEntity.getVersion()).toString()) == null) {
            str6 = AnalyticsUtil.ParameterConstants.NO_ID.getValue();
        }
        noticeAnalyticsSend(str6);
        if (str7 == null || !Intrinsics.areEqual((Object) str7, (Object) MainActivityKt.BUTTON_PREFERENCE_TOP_LEFT)) {
            DialogHelperUtil dialogHelperUtil3 = this.mDialogHelper;
            if (dialogHelperUtil3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil = null;
            } else {
                dialogHelperUtil = dialogHelperUtil3;
            }
            dialogHelperUtil.showDataDialog(str2, BaseDialogFragment.Builder.DialogType.INFORMATION, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), R.string.common_ok, 0).setLifecycleListener(new ConnectionActivity$showNotification$2(str3, str4, str5, this, bitmap));
            return;
        }
        DialogHelperUtil dialogHelperUtil4 = this.mDialogHelper;
        if (dialogHelperUtil4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil2 = null;
        } else {
            dialogHelperUtil2 = dialogHelperUtil4;
        }
        DialogHelperUtil.showDataDialog$default(dialogHelperUtil2, 0, BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_2, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), 0, 0, 0, 32, (Object) null).setLifecycleListener(new ConnectionActivity$showNotification$1$1(str2, str3, str4, str5, this, bitmap));
    }

    public void updateTagMiniInfoView(boolean z, NotifyTagSensorDataEntity notifyTagSensorDataEntity) {
        this.mIsTagRegistered = z;
        TagMiniInfoView tagMiniInfoView = this.mTagMiniInfoView;
        if (tagMiniInfoView != null) {
            tagMiniInfoView.setVisibility(z ? 0 : 8);
        }
        this.mTagInfo = notifyTagSensorDataEntity;
        TagMiniInfoView tagMiniInfoView2 = this.mTagMiniInfoView;
        if (tagMiniInfoView2 != null) {
            tagMiniInfoView2.updateTagInfo(notifyTagSensorDataEntity);
        }
    }

    public void updateTagMiniInfoViewNoReceiving(boolean z, TagDataEntity tagDataEntity) {
        TagMiniInfoView tagMiniInfoView = this.mTagMiniInfoView;
        if (tagMiniInfoView != null) {
            tagMiniInfoView.setVisibility(z ? 0 : 8);
        }
        this.mTagDataInfo = tagDataEntity;
        TagMiniInfoView tagMiniInfoView2 = this.mTagMiniInfoView;
        if (tagMiniInfoView2 != null) {
            tagMiniInfoView2.updateTagInfoNoReceiving(tagDataEntity);
        }
    }

    public void onLegalItemSelect(SettingItemAdapter.SettingListItem settingListItem) {
        ConnectionViewOutput connectionViewOutput;
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        int i = WhenMappings.$EnumSwitchMapping$4[settingListItem.getType().ordinal()];
        if (i == 1) {
            ConnectionViewOutput connectionViewOutput2 = this.mOutput;
            if (connectionViewOutput2 != null) {
                connectionViewOutput2.transitToEula();
            }
        } else if (i == 2) {
            ConnectionViewOutput connectionViewOutput3 = this.mOutput;
            if (connectionViewOutput3 != null) {
                connectionViewOutput3.transitToPrivacy();
            }
        } else if (i == 3 && (connectionViewOutput = this.mOutput) != null) {
            connectionViewOutput.transitToOss();
        }
    }

    public void onInitUserInfo() {
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        if (connectionViewOutput != null) {
            connectionViewOutput.initUserInfo();
        }
    }

    public void onCancelUserInfo() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ChangeUserInfoFragment) {
            transitToStartFragment();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSend(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r9 = this;
            java.lang.String r0 = "aGender"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "aAge"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "aHeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "aWeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "aAddress"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            android.content.res.Configuration r0 = r0.getConfiguration()
            androidx.core.os.LocaleListCompat r0 = androidx.core.os.ConfigurationCompat.getLocales(r0)
            r1 = 0
            java.util.Locale r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r1 = r0.getLanguage()
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            java.util.Locale r2 = java.util.Locale.JAPANESE
            java.lang.String r2 = r2.toString()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0042
            java.lang.String r0 = "Japan"
        L_0x0040:
            r6 = r0
            goto L_0x0061
        L_0x0042:
            java.util.Locale r2 = java.util.Locale.CHINESE
            java.lang.String r2 = r2.toString()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            java.lang.String r2 = "Other"
            if (r1 == 0) goto L_0x0060
            java.lang.String r0 = r0.getCountry()
            java.lang.String r1 = "hk"
            r3 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r3)
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "HongKong"
            goto L_0x0040
        L_0x0060:
            r6 = r2
        L_0x0061:
            jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$ConnectionViewOutput r0 = r9.mOutput
            if (r0 == 0) goto L_0x0073
            jp.co.sony.reonpocket.connection.aws.UserInfoEntity r8 = new jp.co.sony.reonpocket.connection.aws.UserInfoEntity
            r1 = r8
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.registerUserInfo(r8)
        L_0x0073:
            java.lang.String r10 = ""
            r9.showProgressDialog(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.onSend(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void showTagUpdateMessage() {
        DialogBuilderUtil.INSTANCE.showTagFwUpdateDialog(this, new ConnectionActivity$showTagUpdateMessage$1(this));
    }

    public void showTagDfuStarting() {
        hiddenProgressDialog();
        showTagDfuDialog();
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
    }

    public void updateTagDfuProgress(int i) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        ProgressBar progressBar2 = this.mProgressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(i);
        }
        CustomFontTextView customFontTextView = this.mPercentTextView;
        if (customFontTextView != null) {
            customFontTextView.setText(getString(R.string.setting_dfu_on_going_percent, new Object[]{Integer.valueOf(i)}));
        }
    }

    public void showTagDfuFail() {
        ConnectionViewOutput connectionViewOutput = this.mOutput;
        if (connectionViewOutput != null) {
            connectionViewOutput.unRegisterTag();
        }
        updateTagMiniInfoView(false, (NotifyTagSensorDataEntity) null);
        hiddenProgressDialog();
        hiddenTagDfuDialog();
        showDfuFailed();
    }

    public void showTagDfuComplete() {
        hiddenTagDfuDialog();
        this.mTagDfuCompleteDialog = DialogBuilderUtil.INSTANCE.showTagFwUpdateCompleteDialog(this);
    }

    public void showTagDfuDisconnect() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
    }

    public void updateNoReceiving(boolean z) {
        this.mIsTagInfoReceiving = !z;
    }

    public void updateNoAmbientTemperature(boolean z) {
        this.mIsTagNoAmbientTemp = z;
    }
}
