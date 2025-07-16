package org.altbeacon.beacon.powersave;

import android.content.Context;

@Deprecated
public class BackgroundPowerSaver extends BackgroundPowerSaverInternal {
    public BackgroundPowerSaver(Context context) {
        super(context);
    }

    @Deprecated
    public BackgroundPowerSaver(Context context, boolean z) {
        this(context);
    }
}
