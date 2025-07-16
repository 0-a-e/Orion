package jp.co.sony.reonpocket.modules.pairing.view;

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
import androidx.transition.Slide;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import java.util.Iterator;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.connection.log.logcat.LogCatLoggingService;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractor;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.helpGuide.view.HelpGuideFragment;
import jp.co.sony.reonpocket.modules.main.view.MainActivityKt;
import jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter;
import jp.co.sony.reonpocket.modules.pairing.view.PairingCompleteFragment;
import jp.co.sony.reonpocket.modules.pairing.view.PairingStartFragment;
import jp.co.sony.reonpocket.modules.pairing.view.SelectProductFragment;
import jp.co.sony.reonpocket.modules.settings.view.ChangeUserInfoFragment;
import jp.co.sony.reonpocket.modules.settings.view.LegalFragment;
import jp.co.sony.reonpocket.modules.settings.view.OssContentFragment;
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

@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b$*\u0002\u0012\u001f\b\u0007\u0018\u0000 â\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0006â\u0001ã\u0001ä\u0001B\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J(\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010$H\u0002J\b\u0010I\u001a\u00020@H\u0002J\u0010\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020\u001aH\u0002J\u0010\u0010L\u001a\u00020@2\u0006\u0010K\u001a\u00020\u001aH\u0002J\u0010\u0010M\u001a\u00020@2\u0006\u0010K\u001a\u00020\u001aH\u0016J\b\u0010N\u001a\u00020@H\u0002J\b\u0010O\u001a\u00020@H\u0016J0\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$H\u0002J\b\u0010V\u001a\u00020@H\u0002J\b\u0010W\u001a\u00020@H\u0016J\b\u0010X\u001a\u00020@H\u0002J\b\u0010Y\u001a\u00020@H\u0002J\b\u0010Z\u001a\u00020@H\u0016J\b\u0010[\u001a\u00020@H\u0002J\b\u0010\\\u001a\u00020@H\u0016J\b\u0010]\u001a\u00020@H\u0002J\b\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020@H\u0002J\u0012\u0010a\u001a\u00020@2\b\u0010b\u001a\u0004\u0018\u00010$H\u0002J \u0010c\u001a\u00020@2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0016J\b\u0010i\u001a\u00020@H\u0016J\u0012\u0010j\u001a\u00020@2\b\u0010k\u001a\u0004\u0018\u00010lH\u0016J\b\u0010m\u001a\u00020@H\u0016J\u0012\u0010n\u001a\u00020@2\b\u0010o\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010p\u001a\u00020\u001a2\u0006\u0010q\u001a\u00020rH\u0016J\u0018\u0010s\u001a\u00020@2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J \u0010t\u001a\u00020@2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0016J\u0018\u0010u\u001a\u00020@2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\u0010\u0010v\u001a\u00020@2\u0006\u0010w\u001a\u00020$H\u0016J\b\u0010x\u001a\u00020@H\u0016J\b\u0010y\u001a\u00020@H\u0016J\u0010\u0010z\u001a\u00020@2\u0006\u0010{\u001a\u00020|H\u0016J\u0010\u0010}\u001a\u00020@2\u0006\u0010~\u001a\u00020H\u0016J\u0011\u0010\u0001\u001a\u00020@2\u0006\u0010~\u001a\u00020H\u0016J(\u0010\u0001\u001a\u00020@2\u0007\u0010\u0001\u001a\u00020g2\t\u0010\u0001\u001a\u0004\u0018\u00010$2\t\u0010\u0001\u001a\u0004\u0018\u00010\"H\u0016J\t\u0010\u0001\u001a\u00020@H\u0016J\u0012\u0010\u0001\u001a\u00020\u001a2\u0007\u0010{\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020@H\u0014J4\u0010\u0001\u001a\u00020@2\u0007\u0010\u0001\u001a\u00020g2\u0010\u0010\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020$0\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020@H\u0014J2\u0010\u0001\u001a\u00020@2\u0006\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$H\u0016J1\u0010\u0001\u001a\u00020@2\u0006\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$H\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010\u0001\u001a\u00020@H\u0002J\u0011\u0010\u0001\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J\t\u0010\u0001\u001a\u00020@H\u0016J\t\u0010\u0001\u001a\u00020@H\u0016J\u0013\u0010\u0001\u001a\u00020@2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020@H\u0002J\t\u0010\u0001\u001a\u00020@H\u0016J\t\u0010\u0001\u001a\u00020@H\u0016J\t\u0010\u0001\u001a\u00020@H\u0016J\t\u0010\u0001\u001a\u00020@H\u0002J\t\u0010 \u0001\u001a\u00020@H\u0016J\u0012\u0010¡\u0001\u001a\u00020@2\u0007\u0010¢\u0001\u001a\u00020gH\u0016J\t\u0010£\u0001\u001a\u00020@H\u0016J\t\u0010¤\u0001\u001a\u00020@H\u0002JF\u0010¥\u0001\u001a\u00020@2\t\u0010¦\u0001\u001a\u0004\u0018\u00010$2\u0007\u0010§\u0001\u001a\u00020$2\u0007\u0010¨\u0001\u001a\u00020$2\u0007\u0010©\u0001\u001a\u00020$2\t\u0010ª\u0001\u001a\u0004\u0018\u00010$2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\t\u0010­\u0001\u001a\u00020@H\u0016J\t\u0010®\u0001\u001a\u00020@H\u0002J\u0013\u0010¯\u0001\u001a\u00020@2\b\b\u0002\u0010b\u001a\u00020$H\u0002J\u0014\u0010°\u0001\u001a\u00020@2\t\b\u0002\u0010±\u0001\u001a\u00020\u001aH\u0002J\u0014\u0010²\u0001\u001a\u00020@2\t\b\u0002\u0010±\u0001\u001a\u00020\u001aH\u0002J\u0012\u0010³\u0001\u001a\u00020@2\u0007\u0010´\u0001\u001a\u00020\rH\u0002J\t\u0010µ\u0001\u001a\u00020@H\u0002J\t\u0010¶\u0001\u001a\u00020@H\u0002J\t\u0010·\u0001\u001a\u00020@H\u0002J\t\u0010¸\u0001\u001a\u00020@H\u0016J\t\u0010¹\u0001\u001a\u00020@H\u0002J\t\u0010º\u0001\u001a\u00020@H\u0016J\t\u0010»\u0001\u001a\u00020@H\u0016J\t\u0010¼\u0001\u001a\u00020@H\u0016J+\u0010½\u0001\u001a\u00020@2\u0007\u0010¾\u0001\u001a\u0002062\u0007\u0010¿\u0001\u001a\u00020$2\u000e\u0010À\u0001\u001a\t\u0012\u0004\u0012\u00020@0Á\u0001H\u0016J\t\u0010Â\u0001\u001a\u00020@H\u0002J\t\u0010Ã\u0001\u001a\u00020@H\u0016J\t\u0010Ä\u0001\u001a\u00020@H\u0016J$\u0010Ä\u0001\u001a\u00020@2\u0007\u0010Å\u0001\u001a\u00020$2\u0007\u0010¾\u0001\u001a\u0002062\u0007\u0010¿\u0001\u001a\u00020$H\u0016J\u001b\u0010Æ\u0001\u001a\u00020@2\u0007\u0010¾\u0001\u001a\u0002062\u0007\u0010¿\u0001\u001a\u00020$H\u0002J\t\u0010Ç\u0001\u001a\u00020@H\u0016J\t\u0010È\u0001\u001a\u00020@H\u0016J\t\u0010É\u0001\u001a\u00020@H\u0016J\t\u0010Ê\u0001\u001a\u00020@H\u0002J\u0007\u0010Ë\u0001\u001a\u00020@J\u0012\u0010Ì\u0001\u001a\u00020@2\t\u0010\u0001\u001a\u0004\u0018\u00010$J\u0014\u0010Í\u0001\u001a\u00020@2\t\u0010\u0001\u001a\u0004\u0018\u00010$H\u0002J\u0011\u0010Î\u0001\u001a\u00020@2\u0006\u0010~\u001a\u00020H\u0002J\u0007\u0010Ï\u0001\u001a\u00020@J\u0007\u0010Ð\u0001\u001a\u00020@J\u0011\u0010Ñ\u0001\u001a\u00020@2\u0006\u0010~\u001a\u00020H\u0002J\t\u0010Ò\u0001\u001a\u00020@H\u0002J\t\u0010Ó\u0001\u001a\u00020@H\u0016J\t\u0010Ô\u0001\u001a\u00020@H\u0016J\t\u0010Õ\u0001\u001a\u00020@H\u0002J\u0012\u0010Ö\u0001\u001a\u00020@2\u0007\u0010×\u0001\u001a\u00020gH\u0016J\u0012\u0010Ø\u0001\u001a\u00020@2\u0007\u0010Ù\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010Ú\u0001\u001a\u00020@2\u0007\u0010Û\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010Ü\u0001\u001a\u00020@2\u0007\u0010×\u0001\u001a\u00020gH\u0016J\u001d\u0010Ý\u0001\u001a\u00020@2\u0007\u0010Þ\u0001\u001a\u00020\u001a2\t\u0010ß\u0001\u001a\u0004\u0018\u00010:H\u0016J\u001d\u0010à\u0001\u001a\u00020@2\u0007\u0010Þ\u0001\u001a\u00020\u001a2\t\u0010ß\u0001\u001a\u0004\u0018\u000106H\u0016J\r\u0010á\u0001\u001a\u00020$*\u00020BH\u0002R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006å\u0001"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingViewInput;", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingStartFragment$OnPairingStartListener;", "Ljp/co/sony/reonpocket/modules/pairing/view/SelectProductFragment$OnSelectProductListener;", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingCompleteFragment$OnPairingCompleteListener;", "Ljp/co/sony/reonpocket/modules/settings/view/LegalFragment$OnLegalItemSelectListener;", "Ljp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment$OnChangeUserInfoListener;", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "Ljp/co/sony/reonpocket/view/TagMiniInfoViewOutput;", "()V", "blePermissions", "Ljava/util/ArrayList;", "Ljp/co/sony/reonpocket/util/RequestBLEPermissions;", "Lkotlin/collections/ArrayList;", "mBleAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mBluetoothStateBroadcastReceiver", "jp/co/sony/reonpocket/modules/pairing/view/PairingActivity$mBluetoothStateBroadcastReceiver$1", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity$mBluetoothStateBroadcastReceiver$1;", "mDfuCompleteDialog", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mErrorDialog", "mHavePendingTransit", "", "mIsTagInfoReceiving", "mIsTagNoAmbientTemp", "mIsTagRegistered", "mLocationProviderChangedReceiver", "jp/co/sony/reonpocket/modules/pairing/view/PairingActivity$mLocationProviderChangedReceiver$1", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity$mLocationProviderChangedReceiver$1;", "mMainBundle", "Landroid/os/Bundle;", "mModelName", "", "mOptionsMenu", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity$OptionsMenu;", "mOutput", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity$PairingViewOutput;", "mPercentTextView", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "mPrepareDfuDialog", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressBarDialog", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "mProgressDialog", "Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment;", "mRequestLocationDialog", "mRequestNearbyDeviceDialog", "mSettingMenuDialog", "mTagDataInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "mTagDfuCompleteDialog", "mTagDfuProgressBarDialog", "mTagInfo", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "mTagMiniInfoView", "Ljp/co/sony/reonpocket/view/TagMiniInfoView;", "mTagRegisterSuccessDialog", "mTagUnRegisterDialog", "addFragment", "", "fragment", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "analyticsSend", "aEventName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventName;", "aParamName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventParameter;", "aParam", "bluetoothDialogButton", "changeHelpGuideBtnState", "aIsActive", "changeNextBtnState", "changeOkBtnState", "checkBTPermission", "doDfu", "doUserInfoInit", "aGender", "aAge", "aHeight", "aWeight", "aState", "hiddenDfuCompleteDialog", "hiddenProgress", "hiddenProgressBarDialog", "hiddenProgressDialog", "hiddenSettingMenuDialog", "hiddenTagDfuDialog", "hiddenTagDfuProgress", "hiddenTagUnRegisterDialog", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "nextShowRequestDialog", "noticeAnalyticsSend", "aMessage", "onAlertDialogSucceeded", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "", "aResultCode", "onCancelUserInfo", "onClick", "v", "Landroid/view/View;", "onComplete", "onCreate", "savedInstanceState", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDataDialogCancelled", "onDataDialogSucceeded", "onDismiss", "onFail", "aErrorMessage", "onFinishSend", "onInitUserInfo", "onLegalItemSelect", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "onNextHelpGuide", "reonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "onNextPage", "aPageId", "aModelName", "aBundle", "onNextStep", "onOptionsItemSelected", "Landroid/view/MenuItem;", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSend", "aAddress", "onUserInfoInit", "pushBlePermission", "registerBroadcastReceivers", "replaceFragment", "requestForAppUpdate", "requestPermission", "requestPermissionDialog", "permissionCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "setBackPressedEvent", "showDfuComplete", "showDfuDisconnect", "showDfuFail", "showDfuFailed", "showDfuStarting", "showErrorMessage", "aStringResId", "showNoMessageProgress", "showNoMessageProgressDialog", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showProgress", "showProgressBarDialog", "showProgressDialog", "showRequestBluetoothDialog", "aIsRequestPermission", "showRequestLocationDialog", "showRequestPermissionDialog", "permission", "showSettingLocationDialog", "showSettingMenuDialog", "showSettingPermissionDialog", "showTagDfuComplete", "showTagDfuDialog", "showTagDfuDisconnect", "showTagDfuFail", "showTagDfuStarting", "showTagFoundDialog", "aTagInfo", "aTagModelName", "positiveCompletion", "Lkotlin/Function0;", "showTagNotFoundDialog", "showTagNotFoundPopup", "showTagRegisterDialog", "bdAddress", "showTagRegisteredDialog", "showTagRegistrationFailedDialog", "showTagUnRegisterDialog", "showTagUpdateMessage", "startTagScan", "transitToChangeUserInfo", "transitToCompleteFragment", "transitToCompleteFragmentBackground", "transitToHelpGuide", "transitToLegalFragment", "transitToOssContentFragment", "transitToPairingStartFragment", "transitToSelectProduct", "tryConnectDfu", "unRegisterTagStatus", "unregisterBroadcastReceivers", "updateDfuProgress", "aProgress", "updateNoAmbientTemperature", "isNotGet", "updateNoReceiving", "isNoReceiving", "updateTagDfuProgress", "updateTagMiniInfoView", "isActive", "entity", "updateTagMiniInfoViewNoReceiving", "getBackStackTag", "Companion", "OptionsMenu", "PairingViewOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingActivity.kt */
public final class PairingActivity extends BaseActivity implements PairingViewInput, PairingStartFragment.OnPairingStartListener, SelectProductFragment.OnSelectProductListener, PairingCompleteFragment.OnPairingCompleteListener, LegalFragment.OnLegalItemSelectListener, ChangeUserInfoFragment.OnChangeUserInfoListener, DataDialogFragment.Callback, TagMiniInfoViewOutput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DELAY_TIME_AFTER_DFU_COMPLETE = 3000;
    private static final String PROGRESS_DIALOG_TAG = "progress_dialog_tag";
    private ArrayList<RequestBLEPermissions> blePermissions = new ArrayList<>();
    private BluetoothAdapter mBleAdapter;
    private final PairingActivity$mBluetoothStateBroadcastReceiver$1 mBluetoothStateBroadcastReceiver = new PairingActivity$mBluetoothStateBroadcastReceiver$1(this);
    private AlertDialogFragment mDfuCompleteDialog;
    private DialogHelperUtil mDialogHelper;
    private AlertDialogFragment mErrorDialog;
    private boolean mHavePendingTransit;
    private boolean mIsTagInfoReceiving;
    private boolean mIsTagNoAmbientTemp;
    private boolean mIsTagRegistered;
    private final PairingActivity$mLocationProviderChangedReceiver$1 mLocationProviderChangedReceiver = new PairingActivity$mLocationProviderChangedReceiver$1(this);
    private Bundle mMainBundle;
    private String mModelName = "";
    /* access modifiers changed from: private */
    public OptionsMenu mOptionsMenu = OptionsMenu.NONE;
    /* access modifiers changed from: private */
    public PairingViewOutput mOutput;
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

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\b\u0010%\u001a\u00020\u0003H&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J,\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\nH&J\b\u0010/\u001a\u00020\u0003H&J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\bH&J\b\u00102\u001a\u00020\u0003H&¨\u00063"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity$PairingViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "connect", "", "connectDFU", "disconnect", "doForceUpdate", "getOnWriteSetTagControlResult", "", "getTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "handleSettingMenuTapItem", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "initUserInfo", "isTagRegistered", "onTagWriteFailed", "registerTag", "bdAddress", "", "entity", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "setDfuState", "aIsDfu", "Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$DfuState;", "setSuspendReason", "aReason", "Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$SuspendReason;", "setTagScanListener", "info", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$TagInfo;", "showNotification", "startTagDfu", "tagAlwaysScan", "tagScan", "tagScanNoReceiving", "transitToEula", "transitToMain", "transitToOss", "transitToPrivacy", "transitToTagInfo", "isTagInfoReceiving", "isTagNoAmbientTemp", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "tagDataEntity", "unRegisterTag", "updateDialogStatus", "isShow", "writeRequestDfu", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingActivity.kt */
    public interface PairingViewOutput extends BaseViewOutput {
        void connect();

        void connectDFU();

        void disconnect();

        void doForceUpdate();

        boolean getOnWriteSetTagControlResult();

        TagDataEntity getTagInfo();

        void handleSettingMenuTapItem(SettingItemAdapter.SettingListItem settingListItem);

        void initUserInfo();

        boolean isTagRegistered();

        void onTagWriteFailed();

        void registerTag(String str, TagDataEntity tagDataEntity);

        void registerUserInfo(UserInfoEntity userInfoEntity);

        void setDfuState(PairingPresenter.DfuState dfuState);

        void setSuspendReason(PairingPresenter.SuspendReason suspendReason);

        void setTagScanListener(TagScanInteractor.TagInfo tagInfo);

        void showNotification();

        void startTagDfu();

        void tagAlwaysScan();

        void tagScan();

        void tagScanNoReceiving();

        void transitToEula();

        void transitToMain();

        void transitToOss();

        void transitToPrivacy();

        void transitToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity, TagDataEntity tagDataEntity);

        void unRegisterTag();

        void updateDialogStatus(boolean z);

        void writeRequestDfu();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|19|20|(2:21|22)|23|25|26|27|28|29|31|32|33|34|35|36|37|39) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|31|32|33|34|35|36|37|39) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0086 */
        static {
            /*
                jp.co.sony.reonpocket.modules.pairing.view.PairingActivity$OptionsMenu[] r0 = jp.co.sony.reonpocket.modules.pairing.view.PairingActivity.OptionsMenu.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.modules.pairing.view.PairingActivity$OptionsMenu r2 = jp.co.sony.reonpocket.modules.pairing.view.PairingActivity.OptionsMenu.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.modules.pairing.view.PairingActivity$OptionsMenu r3 = jp.co.sony.reonpocket.modules.pairing.view.PairingActivity.OptionsMenu.TAG_POPUP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                jp.co.sony.reonpocket.modules.pairing.view.PairingActivity$OptionsMenu r4 = jp.co.sony.reonpocket.modules.pairing.view.PairingActivity.OptionsMenu.OK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.util.RequestBLEPermissions[] r0 = jp.co.sony.reonpocket.util.RequestBLEPermissions.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.util.RequestBLEPermissions r4 = jp.co.sony.reonpocket.util.RequestBLEPermissions.REQUEST_ACCESS_COARSE_LOCATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                jp.co.sony.reonpocket.util.RequestBLEPermissions r4 = jp.co.sony.reonpocket.util.RequestBLEPermissions.REQUEST_BLUETOOTH     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                jp.co.sony.reonpocket.constant.ReonProductType[] r0 = jp.co.sony.reonpocket.constant.ReonProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.ReonProductType r4 = jp.co.sony.reonpocket.constant.ReonProductType.ORIGINAL     // Catch:{ NoSuchFieldError -> 0x004c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                jp.co.sony.reonpocket.constant.ReonProductType r4 = jp.co.sony.reonpocket.constant.ReonProductType.PRO     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                $EnumSwitchMapping$2 = r0
                jp.co.sony.reonpocket.constant.BleConnStatusCode[] r0 = jp.co.sony.reonpocket.constant.BleConnStatusCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.BleConnStatusCode r4 = jp.co.sony.reonpocket.constant.BleConnStatusCode.PERMISSION_MISS_LOCATION     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r4 = jp.co.sony.reonpocket.constant.BleConnStatusCode.PERMISSION_MISS_BLUETOOTH     // Catch:{ NoSuchFieldError -> 0x006d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                $EnumSwitchMapping$3 = r0
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem[] r0 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r4 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LICENSE     // Catch:{ NoSuchFieldError -> 0x007e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.PRIVACY_POLICY     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.OPEN_SOURCE     // Catch:{ NoSuchFieldError -> 0x008e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                $EnumSwitchMapping$4 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.pairing.view.PairingActivity.WhenMappings.<clinit>():void");
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity$Companion;", "", "()V", "DELAY_TIME_AFTER_DFU_COMPLETE", "", "PROGRESS_DIALOG_TAG", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity$OptionsMenu;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "NONE", "TAG_POPUP", "OK", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingActivity.kt */
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
        setContentView(R.layout.activity_pairing);
        setToolbarTitle(R.string.pairing_start_title);
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((FragmentActivity) this);
        Object systemService = getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.mBleAdapter = ((BluetoothManager) systemService).getAdapter();
        if (bundle == null) {
            addFragment(SelectProductFragment.Companion.newInstance());
        }
        this.mOptionsMenu = OptionsMenu.TAG_POPUP;
        this.mTagMiniInfoView = (TagMiniInfoView) findViewById(R.id.tag_mini_info);
        PairingViewOutput pairingViewOutput = this.mOutput;
        int i = 0;
        boolean isTagRegistered = pairingViewOutput != null ? pairingViewOutput.isTagRegistered() : false;
        this.mIsTagRegistered = isTagRegistered;
        TagMiniInfoView tagMiniInfoView = this.mTagMiniInfoView;
        if (tagMiniInfoView != null) {
            if (!isTagRegistered) {
                i = 8;
            }
            tagMiniInfoView.setVisibility(i);
        }
        TagMiniInfoView tagMiniInfoView2 = this.mTagMiniInfoView;
        if (tagMiniInfoView2 != null) {
            tagMiniInfoView2.setOnClickListener(this);
        }
        TagMiniInfoView tagMiniInfoView3 = this.mTagMiniInfoView;
        if (tagMiniInfoView3 != null) {
            tagMiniInfoView3.setOutput(this);
        }
    }

    private final void addFragment(BaseFragment baseFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, baseFragment).commit();
    }

    private final void replaceFragment(BaseFragment baseFragment) {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.select_product_fragment_slide_in, R.anim.select_product_fragment_fade_out, R.anim.select_product_fragment_fade_in, R.anim.select_product_fragment_slide_out).replace(R.id.fragment_container, baseFragment).addToBackStack(getBackStackTag(baseFragment)).commit();
    }

    private final String getBackStackTag(BaseFragment baseFragment) {
        String simpleName = baseFragment.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(this.mOptionsMenu.getId(), menu);
        MenuItem findItem = menu.findItem(R.id.action_ok);
        int i = WhenMappings.$EnumSwitchMapping$0[this.mOptionsMenu.ordinal()];
        if (i == 1) {
            findItem.setVisible(false);
        } else if (i == 2 || i == 3) {
            findItem.setVisible(true);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_ok || itemId == R.id.action_setting) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (findFragmentById instanceof ChangeUserInfoFragment) {
                ((ChangeUserInfoFragment) findFragmentById).sendUserInfo();
                this.mOptionsMenu = OptionsMenu.TAG_POPUP;
                invalidateOptionsMenu();
                return true;
            }
            showSettingMenuDialog();
            return true;
        } else if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof HelpGuideFragment) {
                ActionBar mActionBar = getMActionBar();
                if (mActionBar != null) {
                    mActionBar.setDisplayShowTitleEnabled(true);
                }
                this.mOptionsMenu = OptionsMenu.TAG_POPUP;
                invalidateOptionsMenu();
            }
            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount() - 1;
            if (backStackEntryCount < 0) {
                return true;
            }
            getSupportFragmentManager().popBackStack(getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount).getName(), 1);
            Fragment findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (findFragmentById2 instanceof LegalFragment ? true : findFragmentById2 instanceof ChangeUserInfoFragment ? true : findFragmentById2 instanceof PairingStartFragment ? true : findFragmentById2 instanceof SelectProductFragment) {
                this.mOptionsMenu = OptionsMenu.TAG_POPUP;
            } else if (findFragmentById2 instanceof OssContentFragment) {
                this.mOptionsMenu = OptionsMenu.NONE;
            }
            invalidateOptionsMenu();
            return true;
        }
    }

    private final void setBackPressedEvent() {
        getOnBackPressedDispatcher().addCallback(new PairingActivity$setBackPressedEvent$callback$1(this));
    }

    public void onClick(View view) {
        PairingViewOutput pairingViewOutput;
        super.onClick(view);
        if (view != null) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (findFragmentById instanceof LegalFragment ? true : findFragmentById instanceof ChangeUserInfoFragment ? true : findFragmentById instanceof OssContentFragment) {
                getSupportFragmentManager().popBackStack(getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName(), 1);
            } else if (view.getId() == R.id.tag_mini_info && (pairingViewOutput = this.mOutput) != null) {
                pairingViewOutput.transitToTagInfo(this.mIsTagInfoReceiving, this.mIsTagNoAmbientTemp, this.mTagInfo, this.mTagDataInfo);
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

    public void requestPermission() {
        checkBTPermission();
    }

    public void onNextPage(ReonProductType reonProductType) {
        Intrinsics.checkNotNullParameter(reonProductType, "reonProductType");
        transitToPairingStartFragment(reonProductType);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        PairingViewOutput pairingViewOutput;
        super.onResume();
        if (this.mHavePendingTransit) {
            transitToCompleteFragmentBackground(this.mModelName);
            hiddenProgressDialog();
            this.mHavePendingTransit = false;
            changeOkBtnState(true);
        }
        registerBroadcastReceivers();
        if (this.mIsTagRegistered && (pairingViewOutput = this.mOutput) != null) {
            pairingViewOutput.tagScanNoReceiving();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        unregisterBroadcastReceivers();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Object obj;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        Iterator it = RequestBLEPermissions.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((RequestBLEPermissions) obj).getCode() == i) {
                break;
            }
        }
        RequestBLEPermissions requestBLEPermissions = (RequestBLEPermissions) obj;
        if (requestBLEPermissions != null && shouldShowRequestPermissionRationale(strArr[0])) {
            requestBLEPermissions.markPermissionRequested(this);
        }
        if (!this.blePermissions.isEmpty()) {
            nextShowRequestDialog();
            return;
        }
        if ((!(iArr.length == 0)) && iArr[0] == 0) {
            checkBTConnect(PairingActivity$onRequestPermissionsResult$3.INSTANCE);
        }
    }

    public void onAlertDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        PairingViewOutput pairingViewOutput;
        DialogHelperUtil dialogHelperUtil;
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
        super.onAlertDialogSucceeded(baseDialogFragment, i, i2);
        if (i == DialogHelperUtil.RequestCode.BLUETOOTH_NOT_SETTING.ordinal()) {
            if (i2 == -2) {
                changeNextBtnState(true);
                changeHelpGuideBtnState(true);
            } else if (i2 == -1) {
                bluetoothDialogButton();
            }
        } else if (i == DialogHelperUtil.RequestCode.LOCATION_NOT_SETTING.ordinal()) {
            if (i2 == -1) {
                startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        } else if (i == DialogHelperUtil.RequestCode.CONNECT_FAILED.ordinal()) {
        } else {
            if (i == DialogHelperUtil.RequestCode.CONFIRM_DFU.ordinal()) {
                DialogHelperUtil dialogHelperUtil2 = this.mDialogHelper;
                if (dialogHelperUtil2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                    dialogHelperUtil = null;
                } else {
                    dialogHelperUtil = dialogHelperUtil2;
                }
                this.mPrepareDfuDialog = dialogHelperUtil.showConfirmationDialog(R.string.setting_dfu_start_subtitle_2, R.string.setting_dfu_start_description_2, 0, DialogHelperUtil.RequestCode.REQUEST_DFU.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
            } else if (i == DialogHelperUtil.RequestCode.REQUEST_DFU.ordinal()) {
                changeNextBtnState(false);
                changeHelpGuideBtnState(false);
                AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.FIRMWARE_UPDATE_START, AnalyticsUtil.EventParameter.FW_VERSION, UpdateVersionConstant.REON_FIRMWARE_VERSION);
                PairingViewOutput pairingViewOutput2 = this.mOutput;
                if (pairingViewOutput2 != null) {
                    pairingViewOutput2.writeRequestDfu();
                }
            } else if (i == DialogHelperUtil.RequestCode.DFU_COMPLETE.ordinal()) {
                changeNextBtnState(true);
                changeHelpGuideBtnState(true);
                showProgressDialog$default(this, (String) null, 1, (Object) null);
                new Handler(Looper.getMainLooper()).postDelayed(new PairingActivity$$ExternalSyntheticLambda2(this), DELAY_TIME_AFTER_DFU_COMPLETE);
            } else if (i == DialogHelperUtil.RequestCode.FORCE_UPDATE.ordinal()) {
                PairingViewOutput pairingViewOutput3 = this.mOutput;
                if (pairingViewOutput3 != null) {
                    pairingViewOutput3.setSuspendReason(PairingPresenter.SuspendReason.NONE);
                }
                PairingViewOutput pairingViewOutput4 = this.mOutput;
                if (pairingViewOutput4 != null) {
                    pairingViewOutput4.doForceUpdate();
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
                    PairingViewOutput pairingViewOutput5 = this.mOutput;
                    if (pairingViewOutput5 != null) {
                        pairingViewOutput5.unRegisterTag();
                    }
                    hiddenTagUnRegisterDialog();
                    hiddenSettingMenuDialog();
                    updateTagMiniInfoView(false, (NotifyTagSensorDataEntity) null);
                    return;
                }
                hiddenTagUnRegisterDialog();
            } else if (i == DialogHelperUtil.RequestCode.TAG_DFU_COMPLETE.ordinal()) {
                PairingViewOutput pairingViewOutput6 = this.mOutput;
                if (pairingViewOutput6 != null) {
                    pairingViewOutput6.tagScanNoReceiving();
                }
            } else if (i == DialogHelperUtil.RequestCode.TAG_DFU_FAILED.ordinal() && (pairingViewOutput = this.mOutput) != null) {
                pairingViewOutput.tagAlwaysScan();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onAlertDialogSucceeded$lambda$2(PairingActivity pairingActivity) {
        Intrinsics.checkNotNullParameter(pairingActivity, "this$0");
        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, pairingActivity, pairingActivity.getMFirebaseAnalytics(), AnalyticsUtil.EventName.BLE_RECONNECT_START, (Bundle) null, 8, (Object) null);
        PairingViewOutput pairingViewOutput = pairingActivity.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.connect();
        }
    }

    private final void showSettingLocationDialog() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        this.mRequestLocationDialog = dialogHelperUtil.showConfirmationDialog(0, R.string.setting_request_location_access_permission, 0, DialogHelperUtil.RequestCode.SETTING_LOCATION.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    private final void bluetoothDialogButton() {
        if (Build.VERSION.SDK_INT < 32) {
            BluetoothAdapter bluetoothAdapter = this.mBleAdapter;
            if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
                DebugLogUtil.INSTANCE.e("Open bluetooth is failed, app is finish!");
                finish();
                return;
            }
            checkBTConnect(PairingActivity$bluetoothDialogButton$1.INSTANCE);
            return;
        }
        startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
    }

    static /* synthetic */ void showRequestLocationDialog$default(PairingActivity pairingActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        pairingActivity.showRequestLocationDialog(z);
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

    static /* synthetic */ void showRequestBluetoothDialog$default(PairingActivity pairingActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        pairingActivity.showRequestBluetoothDialog(z);
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

    private final void showProgressBarDialog() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DataDialogFragment showDataDialog = dialogHelperUtil.showDataDialog(R.string.setting_dfu_on_going_subtitle, BaseDialogFragment.Builder.DialogType.PROGRESS, DialogHelperUtil.RequestCode.DIALOG_DURATION.ordinal(), 0, 0, R.string.setting_dfu_on_going_description);
        this.mProgressBarDialog = showDataDialog;
        Intrinsics.checkNotNull(showDataDialog);
        showDataDialog.setLifecycleListener(new PairingActivity$showProgressBarDialog$1(this));
    }

    private final void showSettingMenuDialog() {
        this.mSettingMenuDialog = DialogBuilderUtil.INSTANCE.showSettingMenuDialog(this, new PairingActivity$showSettingMenuDialog$1(this));
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

    /* access modifiers changed from: private */
    public final void checkBTPermission() {
        this.blePermissions = RequestBLEPermissions.Companion.isNotGrantedArray(this);
        changeNextBtnState(true);
        changeHelpGuideBtnState(true);
        if (this.blePermissions.isEmpty()) {
            checkBTConnect(PairingActivity$checkBTPermission$1.INSTANCE);
        } else {
            nextShowRequestDialog();
        }
    }

    private final void nextShowRequestDialog() {
        RequestBLEPermissions pushBlePermission = pushBlePermission();
        if (pushBlePermission != null) {
            showRequestPermissionDialog(pushBlePermission);
        }
    }

    private final RequestBLEPermissions pushBlePermission() {
        if (this.blePermissions.isEmpty()) {
            return null;
        }
        RequestBLEPermissions requestBLEPermissions = (RequestBLEPermissions) CollectionsKt.first(this.blePermissions);
        if (!this.blePermissions.isEmpty()) {
            this.blePermissions.remove(requestBLEPermissions);
        }
        return requestBLEPermissions;
    }

    private final void showRequestPermissionDialog(RequestBLEPermissions requestBLEPermissions) {
        int i = WhenMappings.$EnumSwitchMapping$1[requestBLEPermissions.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (requestBLEPermissions.isPermissionDeniedForever(this)) {
                    showRequestBluetoothDialog(false);
                } else {
                    showRequestBluetoothDialog$default(this, false, 1, (Object) null);
                }
            }
        } else if (requestBLEPermissions.isPermissionDeniedForever(this)) {
            showSettingLocationDialog();
        } else {
            showRequestLocationDialog$default(this, false, 1, (Object) null);
        }
    }

    private final void showTagNotFoundDialog() {
        DialogBuilderUtil.INSTANCE.showTagNotFoundDialog(this, new PairingActivity$showTagNotFoundDialog$1(this));
    }

    /* access modifiers changed from: private */
    public final void showTagRegisteredDialog(TagDataEntity tagDataEntity, String str) {
        PairingViewOutput pairingViewOutput = this.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.updateDialogStatus(true);
        }
        this.mTagRegisterSuccessDialog = DialogBuilderUtil.INSTANCE.showTagRegisteredDialog(this, tagDataEntity, str, new PairingActivity$showTagRegisteredDialog$1(this));
        if (tagDataEntity.getFwVersionCode() < Integer.parseInt(UpdateVersionConstant.TAG_FIRMWARE_VERSION_CODE)) {
            tagDataEntity.getFwVersionCode();
        }
    }

    /* access modifiers changed from: private */
    public final void startTagScan() {
        PairingViewOutput pairingViewOutput;
        PairingViewOutput pairingViewOutput2 = this.mOutput;
        boolean isTagRegistered = pairingViewOutput2 != null ? pairingViewOutput2.isTagRegistered() : false;
        this.mIsTagRegistered = isTagRegistered;
        updateTagMiniInfoView(isTagRegistered, this.mTagInfo);
        if (this.mIsTagRegistered && (pairingViewOutput = this.mOutput) != null) {
            pairingViewOutput.tagScanNoReceiving();
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

    /* access modifiers changed from: private */
    public final void changeNextBtnState(boolean z) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof PairingStartFragment) {
            ((PairingStartFragment) findFragmentById).changeNextBtnState(z);
        }
    }

    /* access modifiers changed from: private */
    public final void changeHelpGuideBtnState(boolean z) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof PairingStartFragment) {
            ((PairingStartFragment) findFragmentById).changeHelpGuideBtnState(z);
        }
    }

    public void changeOkBtnState(boolean z) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof PairingCompleteFragment) {
            ((PairingCompleteFragment) findFragmentById).changeOkBtnState(z);
        }
    }

    static /* synthetic */ void showProgressDialog$default(PairingActivity pairingActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pairingActivity.getString(R.string.pairing_on_going_title);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        pairingActivity.showProgressDialog(str);
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

    private final void hiddenTagUnRegisterDialog() {
        Dialog dialog;
        AlertDialogFragment alertDialogFragment = this.mTagUnRegisterDialog;
        if (alertDialogFragment != null && (dialog = alertDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    private final void transitToSelectProduct() {
        this.mOptionsMenu = OptionsMenu.TAG_POPUP;
        setMenuIconVisibility(true);
        invalidateOptionsMenu();
    }

    private final void transitToPairingStartFragment(ReonProductType reonProductType) {
        replaceFragment(PairingStartFragment.Companion.newInstance(reonProductType));
    }

    public final void transitToCompleteFragment(String str) {
        int i = WhenMappings.$EnumSwitchMapping$2[ReonProductType.Companion.getReonProductType(str).ordinal()];
        if (i == 1) {
            setToolbarTitle(R.string.pairing_start_title_original);
        } else if (i == 2) {
            setToolbarTitle(R.string.pairing_start_title_pro);
        }
        if (!isAppOnForeground()) {
            this.mHavePendingTransit = true;
            this.mModelName = str;
            return;
        }
        addFragment(PairingCompleteFragment.Companion.newInstance(str));
        this.mOptionsMenu = OptionsMenu.NONE;
        invalidateOptionsMenu();
    }

    private final void transitToCompleteFragmentBackground(String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        ReonProductType.Companion.getReonProductType(str);
        beginTransaction.replace(R.id.fragment_container, PairingCompleteFragment.Companion.newInstance(str));
        beginTransaction.commitNow();
    }

    private final void transitToHelpGuide(ReonProductType reonProductType) {
        HelpGuideFragment newInstance = HelpGuideFragment.Companion.newInstance(reonProductType);
        ActionBar mActionBar = getMActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayShowTitleEnabled(false);
        }
        setBackPressedEvent();
        replaceFragment(newInstance);
    }

    public final void transitToLegalFragment() {
        LegalFragment newInstance = LegalFragment.Companion.newInstance();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(slide);
        newInstance.setEnterTransition(transitionSet);
        replaceFragment(newInstance);
        invalidateOptionsMenu();
        this.mOptionsMenu = OptionsMenu.NONE;
    }

    public final void transitToChangeUserInfo() {
        ChangeUserInfoFragment newInstance = ChangeUserInfoFragment.Companion.newInstance();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(slide);
        newInstance.setEnterTransition(transitionSet);
        replaceFragment(newInstance);
        invalidateOptionsMenu();
        this.mOptionsMenu = OptionsMenu.OK;
    }

    public final void transitToOssContentFragment() {
        setToolbarTitle(R.string.setting_top_license);
        TransitionSet transitionSet = new TransitionSet();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        transitionSet.addTransition(slide);
        replaceFragment(OssContentFragment.Companion.newInstance());
        invalidateOptionsMenu();
        this.mOptionsMenu = OptionsMenu.NONE;
    }

    private final void doUserInfoInit(String str, String str2, String str3, String str4, String str5) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof ChangeUserInfoFragment) {
            ((ChangeUserInfoFragment) findFragmentById).doInitDataSetting(str, str2, str3, str4, str5);
        }
    }

    static /* synthetic */ void analyticsSend$default(PairingActivity pairingActivity, AnalyticsUtil.EventName eventName, AnalyticsUtil.EventParameter eventParameter, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            eventParameter = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        pairingActivity.analyticsSend(eventName, eventParameter, str);
    }

    private final void analyticsSend(AnalyticsUtil.EventName eventName, AnalyticsUtil.EventParameter eventParameter, String str) {
        AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), eventName, eventParameter, str);
    }

    /* access modifiers changed from: private */
    public final void noticeAnalyticsSend(String str) {
        analyticsSend(AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, str);
    }

    private final void showTagDfuDialog() {
        this.mTagDfuProgressBarDialog = DialogBuilderUtil.INSTANCE.showTagFwUpdateProgressDialog(this, new PairingActivity$showTagDfuDialog$1(this));
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

    public BaseViewOutput initPresenter() {
        PairingViewOutput pairingPresenter = new PairingPresenter(this, this, getMFirebaseAnalytics());
        this.mOutput = pairingPresenter;
        Intrinsics.checkNotNull(pairingPresenter, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter");
        return (PairingPresenter) pairingPresenter;
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
            checkBTConnect(PairingActivity$onNextStep$1.INSTANCE);
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
        showProgressDialog$default(this, (String) null, 1, (Object) null);
        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, context, getMFirebaseAnalytics(), AnalyticsUtil.EventName.BLE_PAIRING_START, (Bundle) null, 8, (Object) null);
        PairingViewOutput pairingViewOutput = this.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.connect();
        }
    }

    public void onNextHelpGuide(ReonProductType reonProductType) {
        Intrinsics.checkNotNullParameter(reonProductType, "reonProductType");
        transitToHelpGuide(reonProductType);
    }

    public void onComplete() {
        PairingViewOutput pairingViewOutput = this.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.transitToMain();
        }
    }

    public void onFail(String str) {
        PairingViewOutput pairingViewOutput;
        Intrinsics.checkNotNullParameter(str, "aErrorMessage");
        hiddenDfuCompleteDialog();
        hiddenProgressDialog();
        hiddenProgressBarDialog();
        showErrorDialog(str);
        changeNextBtnState(true);
        changeHelpGuideBtnState(true);
        if (this.mIsTagRegistered && (pairingViewOutput = this.mOutput) != null) {
            pairingViewOutput.tagScanNoReceiving();
        }
    }

    public void onNextPage(int i, String str, Bundle bundle) {
        DialogHelperUtil dialogHelperUtil;
        DialogHelperUtil dialogHelperUtil2;
        hiddenProgressDialog();
        if (i == PairingPresenter.NextPage.PAIRING_COMPLETE.ordinal()) {
            transitToCompleteFragment(str);
        } else if (i == PairingPresenter.NextPage.DFU_START.ordinal()) {
            hiddenProgressDialog();
            DialogHelperUtil dialogHelperUtil3 = this.mDialogHelper;
            if (dialogHelperUtil3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil2 = null;
            } else {
                dialogHelperUtil2 = dialogHelperUtil3;
            }
            this.mPrepareDfuDialog = dialogHelperUtil2.showConfirmationDialog(R.string.setting_dfu_start_subtitle, R.string.setting_dfu_start_description, 0, DialogHelperUtil.RequestCode.CONFIRM_DFU.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
        } else if (i == PairingPresenter.NextPage.DFU_GOING.ordinal()) {
            hiddenProgressDialog();
            hideErrorDialog();
            showProgressBarDialog();
        } else if (i == PairingPresenter.NextPage.MAIN.ordinal()) {
            changeOkBtnState(true);
            this.mMainBundle = bundle;
        } else if (i == PairingPresenter.NextPage.DFU_COMPLETE.ordinal()) {
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

    public void doDfu() {
        showProgressDialog$default(this, (String) null, 1, (Object) null);
        PairingViewOutput pairingViewOutput = this.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.connectDFU();
        }
    }

    public void tryConnectDfu() {
        PairingViewOutput pairingViewOutput = this.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.connectDFU();
        }
    }

    public void requestForAppUpdate() {
        hiddenProgressDialog();
        changeNextBtnState(true);
        changeHelpGuideBtnState(true);
        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SHOW_APP_UPDATE, (Bundle) null, 8, (Object) null);
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(R.string.setting_app_update_requirement_title, R.string.setting_app_update_requirement_description, 0, DialogHelperUtil.RequestCode.FORCE_UPDATE.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
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
        changeNextBtnState(true);
        changeHelpGuideBtnState(true);
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
        new Handler(Looper.getMainLooper()).postDelayed(new PairingActivity$$ExternalSyntheticLambda1(this, bleConnStatusCode), 300);
    }

    /* access modifiers changed from: private */
    public static final void requestPermissionDialog$lambda$5(PairingActivity pairingActivity, BleConnStatusCode bleConnStatusCode) {
        Unit unit;
        Dialog dialog;
        Intrinsics.checkNotNullParameter(pairingActivity, "this$0");
        Intrinsics.checkNotNullParameter(bleConnStatusCode, "$permissionCode");
        pairingActivity.hiddenProgressDialog();
        AlertDialogFragment alertDialogFragment = pairingActivity.mRequestNearbyDeviceDialog;
        if (alertDialogFragment == null || (dialog = alertDialogFragment.getDialog()) == null) {
            unit = null;
        } else {
            dialog.show();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            int i = WhenMappings.$EnumSwitchMapping$3[bleConnStatusCode.ordinal()];
            if (i == 1) {
                showRequestLocationDialog$default(pairingActivity, false, 1, (Object) null);
            } else if (i != 2) {
                pairingActivity.showSettingPermissionDialog();
            } else {
                showRequestBluetoothDialog$default(pairingActivity, false, 1, (Object) null);
            }
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
            getSupportFragmentManager().popBackStack(getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName(), 1);
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
        DialogBuilderUtil.INSTANCE.showTagRegisterDialog(this, new PairingActivity$showTagRegisterDialog$1(this));
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
        DialogBuilderUtil.INSTANCE.showTagFoundDialog(this, tagDataEntity, str, new PairingActivity$showTagFoundDialog$1(function0, this, tagDataEntity, str));
    }

    public void showTagUnRegisterDialog() {
        PairingViewOutput pairingViewOutput = this.mOutput;
        DialogBuilderUtil.INSTANCE.showTagUnRegisterDialog(this, pairingViewOutput != null ? pairingViewOutput.getTagInfo() : null, new PairingActivity$showTagUnRegisterDialog$1(this));
    }

    public void unRegisterTagStatus() {
        PairingViewOutput pairingViewOutput = this.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.unRegisterTag();
        }
        updateTagMiniInfoView(false, (NotifyTagSensorDataEntity) null);
    }

    public void showTagRegisterDialog(String str, TagDataEntity tagDataEntity, String str2) {
        Intrinsics.checkNotNullParameter(str, "bdAddress");
        Intrinsics.checkNotNullParameter(tagDataEntity, "aTagInfo");
        Intrinsics.checkNotNullParameter(str2, "aTagModelName");
        DialogBuilderUtil.INSTANCE.showTagFoundDialog(this, tagDataEntity, str2, new PairingActivity$showTagRegisterDialog$2(this, str, tagDataEntity, str2));
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
            dialogHelperUtil.showDataDialog(str2, BaseDialogFragment.Builder.DialogType.INFORMATION, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), R.string.common_ok, 0).setLifecycleListener(new PairingActivity$showNotification$2(str3, str4, str5, this, bitmap));
            return;
        }
        DialogHelperUtil dialogHelperUtil4 = this.mDialogHelper;
        if (dialogHelperUtil4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil2 = null;
        } else {
            dialogHelperUtil2 = dialogHelperUtil4;
        }
        DialogHelperUtil.showDataDialog$default(dialogHelperUtil2, 0, BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_2, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), 0, 0, 0, 32, (Object) null).setLifecycleListener(new PairingActivity$showNotification$1$1(str2, str3, str4, str5, this, bitmap));
    }

    public void onLegalItemSelect(SettingItemAdapter.SettingListItem settingListItem) {
        PairingViewOutput pairingViewOutput;
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        int i = WhenMappings.$EnumSwitchMapping$4[settingListItem.getType().ordinal()];
        if (i == 1) {
            PairingViewOutput pairingViewOutput2 = this.mOutput;
            if (pairingViewOutput2 != null) {
                pairingViewOutput2.transitToEula();
            }
        } else if (i == 2) {
            PairingViewOutput pairingViewOutput3 = this.mOutput;
            if (pairingViewOutput3 != null) {
                pairingViewOutput3.transitToPrivacy();
            }
        } else if (i == 3 && (pairingViewOutput = this.mOutput) != null) {
            pairingViewOutput.transitToOss();
        }
    }

    public void onInitUserInfo() {
        PairingViewOutput pairingViewOutput = this.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.initUserInfo();
        }
    }

    public void onCancelUserInfo() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ChangeUserInfoFragment) {
            getSupportFragmentManager().popBackStack(getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName(), 1);
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
            jp.co.sony.reonpocket.modules.pairing.view.PairingActivity$PairingViewOutput r0 = r9.mOutput
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
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.pairing.view.PairingActivity.onSend(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
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

    public void showTagUpdateMessage() {
        DialogBuilderUtil.INSTANCE.showTagFwUpdateDialog(this, new PairingActivity$showTagUpdateMessage$1(this));
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
        PairingViewOutput pairingViewOutput = this.mOutput;
        if (pairingViewOutput != null) {
            pairingViewOutput.unRegisterTag();
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

    public void showTagRegistrationFailedDialog() {
        DialogBuilderUtil.INSTANCE.showTagRegistrationFailedDialog(this, new PairingActivity$showTagRegistrationFailedDialog$1(this));
    }

    public void updateNoReceiving(boolean z) {
        this.mIsTagInfoReceiving = !z;
    }

    public void updateNoAmbientTemperature(boolean z) {
        this.mIsTagNoAmbientTemp = z;
    }
}
