package org.altbeacon.beacon.powersave;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;

public class BackgroundPowerSaverInternal implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "BackgroundPowerSaver";
    private int activeActivityCount = 0;
    /* access modifiers changed from: private */
    public final Context applicationContext;
    private final BeaconManager beaconManager;
    /* access modifiers changed from: private */
    public BroadcastReceiver screenOffReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            BackgroundPowerSaverInternal.this.inferBackground("the screen going off");
            BackgroundPowerSaverInternal.this.applicationContext.getApplicationContext().unregisterReceiver(BackgroundPowerSaverInternal.this.screenOffReceiver);
        }
    };

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public BackgroundPowerSaverInternal(Context context) {
        Context applicationContext2 = context.getApplicationContext();
        this.applicationContext = applicationContext2;
        this.beaconManager = BeaconManager.getInstanceForApplication(applicationContext2);
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(this);
    }

    public void onActivityResumed(Activity activity) {
        int i = this.activeActivityCount + 1;
        this.activeActivityCount = i;
        if (i < 1) {
            LogManager.d(TAG, "reset active activity count on resume.  It was %s", Integer.valueOf(i));
            this.activeActivityCount = 1;
        }
        this.beaconManager.setBackgroundMode(false);
        LogManager.d(TAG, "activity resumed: %s active activities: %s", activity, Integer.valueOf(this.activeActivityCount));
    }

    public void onActivityPaused(Activity activity) {
        int i = this.activeActivityCount - 1;
        this.activeActivityCount = i;
        LogManager.d(TAG, "activity paused: %s active activities: %s", activity, Integer.valueOf(i));
        if (this.activeActivityCount < 1) {
            LogManager.d(TAG, "setting background mode", new Object[0]);
            this.beaconManager.setBackgroundMode(true);
        }
    }

    public void enableDefaultBackgroundStateInference() {
        if (this.beaconManager.isBackgroundModeUninitialized()) {
            if (methodCalledByApplicationOnCreate()) {
                inferBackground("application.onCreate in the call stack");
            } else if (!((PowerManager) this.applicationContext.getSystemService("power")).isInteractive()) {
                inferBackground("the screen being off");
            } else {
                this.applicationContext.getApplicationContext().registerReceiver(this.screenOffReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"));
            }
        }
        if (this.beaconManager.isBackgroundModeUninitialized()) {
            LogManager.i(TAG, "Background mode not set.  We assume we are in the foreground.", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void inferBackground(String str) {
        if (this.beaconManager.isBackgroundModeUninitialized()) {
            LogManager.i(TAG, "We have inferred by " + str + " that we are in the background.", new Object[0]);
            this.beaconManager.setBackgroundModeInternal(true);
        }
    }

    private boolean methodCalledByApplicationOnCreate() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String canonicalName = Application.class.getCanonicalName();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if ("onCreate".equals(stackTraceElement.getMethodName())) {
                if (canonicalName.equals(stackTraceElement.getClassName())) {
                    return true;
                }
                if (stackTraceElement.getClassName() != null) {
                    try {
                        Class cls = Class.forName(stackTraceElement.getClassName());
                        while (true) {
                            cls = cls.getSuperclass();
                            if (cls == null) {
                                continue;
                                break;
                            } else if (canonicalName.equals(cls.getCanonicalName())) {
                                return true;
                            }
                        }
                    } catch (ClassNotFoundException unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }
}
