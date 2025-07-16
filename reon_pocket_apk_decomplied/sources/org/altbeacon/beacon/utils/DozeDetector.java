package org.altbeacon.beacon.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import java.lang.reflect.InvocationTargetException;
import org.altbeacon.beacon.logging.LogManager;

public class DozeDetector {
    private static final String TAG = "DozeDetector";

    public boolean isInDozeMode(Context context) {
        return isInFullDozeMode(context) || isInLightDozeMode(context);
    }

    public boolean isInLightDozeMode(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        try {
            boolean booleanValue = ((Boolean) powerManager.getClass().getDeclaredMethod("isLightDeviceIdleMode", (Class[]) null).invoke(powerManager, (Object[]) null)).booleanValue();
            String str = TAG;
            LogManager.d(str, "Light Doze mode? pm.isLightDeviceIdleMode: " + booleanValue, new Object[0]);
            return booleanValue;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            String str2 = TAG;
            LogManager.d(str2, "Reflection failed for isLightDeviceIdleMode: " + e.toString(), e);
            return false;
        }
    }

    public boolean isInFullDozeMode(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            LogManager.d(TAG, "Can't get PowerManager to check doze mode.", new Object[0]);
            return false;
        }
        String str = TAG;
        LogManager.d(str, "Full Doze mode? pm.isDeviceIdleMode()=" + powerManager.isDeviceIdleMode(), new Object[0]);
        if (powerManager.isDeviceIdleMode()) {
            return true;
        }
        LogManager.d(str, "Doze mode? pm.isPowerSaveMode()=" + powerManager.isPowerSaveMode(), new Object[0]);
        return powerManager.isPowerSaveMode();
    }

    public void registerDozeCallbacks(Context context, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        context.registerReceiver(broadcastReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(getLightIdleModeChangeAction());
        context.registerReceiver(broadcastReceiver, intentFilter2);
    }

    public String getLightIdleModeChangeAction() {
        try {
            Object obj = PowerManager.class.getField("ACTION_LIGHT_DEVICE_IDLE_MODE_CHANGED").get((Object) null);
            if (obj == null || !(obj instanceof String)) {
                return "android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGE";
            }
            return (String) obj;
        } catch (Exception e) {
            String str = TAG;
            LogManager.d(str, "Cannot get LIGHT_DEVICE_IDLE_MODE_CHANGE action: " + e.toString(), e);
            return "android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGE";
        }
    }
}
