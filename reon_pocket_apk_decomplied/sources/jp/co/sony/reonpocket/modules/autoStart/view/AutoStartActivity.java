package jp.co.sony.reonpocket.modules.autoStart.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.entity.AutoStartEntity;
import jp.co.sony.reonpocket.modules.autoStart.presenter.AutoStartPresenter;
import jp.co.sony.reonpocket.modules.autoStart.view.AutoStartFragment;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\"B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartViewInput;", "Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartFragment$OnSettingListener;", "()V", "mOutput", "Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartActivity$AutoStartViewOutput;", "doActionDone", "", "doUpdate", "aAutoStartEntity", "Ljp/co/sony/reonpocket/data/entity/AutoStartEntity;", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDone", "onFail", "aErrorMessage", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestDataInit", "onSuccess", "updateAutoStart", "AutoStartViewOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AutoStartActivity.kt */
public final class AutoStartActivity extends BaseActivity implements AutoStartViewInput, AutoStartFragment.OnSettingListener {
    public static final int $stable = 8;
    private AutoStartViewOutput mOutput;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartActivity$AutoStartViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "finish", "", "readAutoStart", "writeAutoStart", "aEntity", "Ljp/co/sony/reonpocket/data/entity/AutoStartEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AutoStartActivity.kt */
    public interface AutoStartViewOutput extends BaseViewOutput {
        void finish();

        void readAutoStart();

        void writeAutoStart(AutoStartEntity autoStartEntity);
    }

    public BaseViewOutput initPresenter() {
        AutoStartViewOutput autoStartPresenter = new AutoStartPresenter(this, this);
        this.mOutput = autoStartPresenter;
        Intrinsics.checkNotNull(autoStartPresenter, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.autoStart.presenter.AutoStartPresenter");
        return (AutoStartPresenter) autoStartPresenter;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_auto_start);
        setToolbarTitle(R.string.setting_top_auto_start);
        setNavigationIcon(R.drawable.ic_close, this);
        if (bundle == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            beginTransaction.replace(R.id.fragment_container, AutoStartFragment.Companion.newInstance());
            beginTransaction.commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (isToolbar()) {
            getMenuInflater().inflate(R.menu.menu_done, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != R.id.action_done) {
            return super.onOptionsItemSelected(menuItem);
        }
        doActionDone();
        return true;
    }

    private final void doActionDone() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof AutoStartFragment) {
            ((AutoStartFragment) findFragmentById).doSetting();
        }
    }

    public void onClick(View view) {
        AutoStartViewOutput autoStartViewOutput;
        super.onClick(view);
        if (view != null && (autoStartViewOutput = this.mOutput) != null) {
            autoStartViewOutput.finish();
        }
    }

    public void onFail(String str) {
        Intrinsics.checkNotNullParameter(str, "aErrorMessage");
        showErrorDialog(str);
    }

    public void onSuccess() {
        AutoStartViewOutput autoStartViewOutput = this.mOutput;
        if (autoStartViewOutput != null) {
            autoStartViewOutput.finish();
        }
    }

    public void updateAutoStart(AutoStartEntity autoStartEntity) {
        Intrinsics.checkNotNullParameter(autoStartEntity, "aAutoStartEntity");
        doUpdate(autoStartEntity);
    }

    private final void doUpdate(AutoStartEntity autoStartEntity) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof AutoStartFragment) {
            ((AutoStartFragment) findFragmentById).doUpdate(autoStartEntity);
        }
    }

    public void onRequestDataInit() {
        AutoStartViewOutput autoStartViewOutput = this.mOutput;
        if (autoStartViewOutput != null) {
            autoStartViewOutput.readAutoStart();
        }
    }

    public void onDone(AutoStartEntity autoStartEntity) {
        if (autoStartEntity == null) {
            onFail("data error");
            return;
        }
        AutoStartViewOutput autoStartViewOutput = this.mOutput;
        if (autoStartViewOutput != null) {
            autoStartViewOutput.writeAutoStart(autoStartEntity);
        }
    }
}
